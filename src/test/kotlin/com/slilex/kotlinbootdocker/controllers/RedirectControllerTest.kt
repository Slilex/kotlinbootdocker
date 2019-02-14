package com.slilex.kotlinbootdocker.controllers


import com.slilex.kotlinbootdocker.KotlinbootdockerApplication
import com.slilex.kotlinbootdocker.service.KeyMapperService
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*
import org.springframework.test.web.servlet.setup.MockMvcBuilders.*
import org.springframework.web.context.WebApplicationContext

@RunWith(SpringJUnit4ClassRunner::class)
@ContextConfiguration (classes = arrayOf(KotlinbootdockerApplication::class) )
@WebAppConfiguration
class RedirectControllerTest {

    @Autowired lateinit var webApplicationContext: WebApplicationContext
    lateinit var mockMvc: MockMvc

    @Mock
    lateinit var service: KeyMapperService

    @Autowired
    @InjectMocks
    lateinit var controller: RedirectController

    @Before
    fun init(){
        MockitoAnnotations.initMocks(this)
        mockMvc = webAppContextSetup(webApplicationContext)
                .build()

        Mockito.`when`(service.getLink(PATH)).thenReturn(KeyMapperService.Get.Link(HEADER_VALUE))
        Mockito.`when`(service.getLink(BAD_PATH)).thenReturn(KeyMapperService.Get.NotFound(BAD_PATH))
    }

    private val PATH = "abcdef"
    private val REDIRECT_STATUS: Int = 302
    private val HEADER_NAME = "location"
    private val HEADER_VALUE = "http://www.eveonline.com"

    @Test fun controllerMustRedirectUsWhenRequesIsSuccedful(){
        mockMvc.perform(get("/$PATH"))
                .andExpect(status().`is`(REDIRECT_STATUS))
                .andExpect(header().string( HEADER_NAME, HEADER_VALUE))
    }

    private val BAD_PATH = "/ololo"
    private val NOT_FOUND: Int = 404

    @Test fun controllerMustReturn404ifBadKey(){
        mockMvc.perform(get("/$BAD_PATH"))
                .andExpect(status().`is`(NOT_FOUND))
    }

}
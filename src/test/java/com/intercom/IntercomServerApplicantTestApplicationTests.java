package com.intercom;

import static org.assertj.core.api.Assertions.assertThat;

import com.intercom.controller.UserController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = IntercomServerApplicantTestApplication.class)
public class IntercomServerApplicantTestApplicationTests {

  @Autowired
  private UserController userController;

  @Test
  public void contextLoads() {
  }

  @Test
  public void storeControllerInitializedCorrectly() {
    assertThat(userController).isNotNull();
  }

}

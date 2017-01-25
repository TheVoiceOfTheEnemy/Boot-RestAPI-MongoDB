package com.ramso.restapi;

import org.junit.Test;

public class UserTest {
	
	private static final String NAME = "nametest";
	private static final int CREDITS = 0;
	private static final boolean IS_ADMIN = false;
	
	private static final int MAX_LENGTH_NAME = 30;
	
    @Test(expected = NullPointerException.class)
    public void build_NameIsNull_ShouldThrowException() {
        User.getBuilder()
                .name(null)
              //  .credits(CREDITS)
               // .isAdmin(IS_ADMIN)
                .build();
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void build_NameIsEmpty_ShouldThrowException() {
        User.getBuilder()
                .name("")
               // .credits(CREDITS)
               // .isAdmin(IS_ADMIN)
                .build();
    }

    @Test(expected = IllegalArgumentException.class)
    public void build_NameIsTooLong_ShouldThrowException() {
        String tooLongName = StringTestUtil.createStringWithLength(MAX_LENGTH_NAME + 1);
        User.getBuilder()
		        .name("")
		       // .credits(CREDITS)
		      //  .isAdmin(IS_ADMIN)
                .build();
    }

}

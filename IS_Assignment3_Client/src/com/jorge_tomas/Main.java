package com.jorge_tomas;

import artifact.ManagementWeb;
import artifact.ManagementWebService;

public class Main {

    public static void main(String[] args) {
	    // write your code here
        ManagementWebService managementWebService = new ManagementWebService();
        ManagementWeb managementWeb = managementWebService.getManagementWebPort();

        System.out.println(managementWeb.addFollower("tomas", "jaguar", 0, 2500));
    }
}

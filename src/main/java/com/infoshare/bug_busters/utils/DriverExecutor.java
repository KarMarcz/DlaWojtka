package com.infoshare.bug_busters.utils;

import java.io.IOException;

class DriverExecutor {

    static void setFullPermissionsForDriver(String driverPath) {
        try {
            Runtime.getRuntime().exec("chmod 777 " + driverPath);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}

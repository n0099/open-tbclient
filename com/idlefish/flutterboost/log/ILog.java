package com.idlefish.flutterboost.log;

import android.support.media.ExifInterface;
/* loaded from: classes12.dex */
public interface ILog {
    void e(String str, String str2);

    void e(String str, String str2, Throwable th);

    /* loaded from: classes12.dex */
    public enum LogLevelEnum {
        VERBOSE(0, ExifInterface.GPS_MEASUREMENT_INTERRUPTED),
        DEBUG(1, "D"),
        INFO(2, "I"),
        WARNING(3, ExifInterface.LONGITUDE_WEST),
        ERROR(4, ExifInterface.LONGITUDE_EAST);
        
        private String logLevelName;
        private int loglevel;

        LogLevelEnum(int i, String str) {
            this.loglevel = i;
            this.logLevelName = str;
        }

        public String getLogLevelName() {
            return this.logLevelName;
        }

        public int getLoglevel() {
            return this.loglevel;
        }
    }
}

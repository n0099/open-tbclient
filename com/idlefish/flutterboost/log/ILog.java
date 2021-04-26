package com.idlefish.flutterboost.log;
/* loaded from: classes6.dex */
public interface ILog {

    /* loaded from: classes6.dex */
    public enum LogLevelEnum {
        VERBOSE(0, "V"),
        DEBUG(1, "D"),
        INFO(2, "I"),
        WARNING(3, "W"),
        ERROR(4, "E");
        
        public String logLevelName;
        public int loglevel;

        LogLevelEnum(int i2, String str) {
            this.loglevel = i2;
            this.logLevelName = str;
        }

        public String getLogLevelName() {
            return this.logLevelName;
        }

        public int getLoglevel() {
            return this.loglevel;
        }
    }

    void e(String str, String str2);

    void e(String str, String str2, Throwable th);
}

package com.idlefish.flutterboost.log;
/* loaded from: classes15.dex */
public interface ILog {
    void e(String str, String str2);

    void e(String str, String str2, Throwable th);

    /* loaded from: classes15.dex */
    public enum LogLevelEnum {
        VERBOSE(0, "V"),
        DEBUG(1, "D"),
        INFO(2, "I"),
        WARNING(3, "W"),
        ERROR(4, "E");
        
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

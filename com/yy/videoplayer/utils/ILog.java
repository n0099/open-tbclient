package com.yy.videoplayer.utils;
/* loaded from: classes6.dex */
public interface ILog {
    void debug(String str, String str2);

    void error(String str, String str2);

    void error(String str, String str2, Throwable th);

    void info(String str, String str2);

    void verbose(String str, String str2);

    void warn(String str, String str2);
}

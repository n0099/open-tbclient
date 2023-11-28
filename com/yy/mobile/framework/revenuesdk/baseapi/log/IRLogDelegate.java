package com.yy.mobile.framework.revenuesdk.baseapi.log;

import androidx.annotation.Keep;
@Keep
/* loaded from: classes2.dex */
public interface IRLogDelegate {
    void debug(Object obj, String str);

    void debug(Object obj, String str, Throwable th);

    void debug(Object obj, String str, Object... objArr);

    void error(Object obj, String str, Throwable th);

    void error(Object obj, String str, Object... objArr);

    void info(Object obj, String str);

    void info(Object obj, String str, Object... objArr);

    void verbose(Object obj, String str);

    void verbose(Object obj, String str, Object... objArr);

    void warn(Object obj, String str);

    void warn(Object obj, String str, Object... objArr);
}

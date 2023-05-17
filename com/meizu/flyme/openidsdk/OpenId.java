package com.meizu.flyme.openidsdk;

import androidx.annotation.Keep;
@Keep
/* loaded from: classes9.dex */
public class OpenId {
    @Keep
    public int code;
    @Keep
    public long expiredTime;
    @Keep
    public String type;
    @Keep
    public String value;

    public OpenId(String str) {
        this.type = str;
    }

    @Keep
    public native boolean isValid();

    @Keep
    public native void setDataExpired();

    @Keep
    public native void updateCode(int i);

    @Keep
    public native void updateExpiredTime(long j);

    @Keep
    public native void updateValue(String str);
}

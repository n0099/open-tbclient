package com.meizu.flyme.openidsdk;

import androidx.annotation.Keep;
@Keep
/* loaded from: classes9.dex */
public class SupportInfo {
    @Keep
    public Boolean support;
    @Keep
    public String version;

    @Keep
    public native boolean isCached();

    @Keep
    public native boolean isSameVersion(String str);

    @Keep
    public native boolean isSupport();

    @Keep
    public native void setSupport(boolean z);

    @Keep
    public native void setVersionName(String str);
}

package com.win.opensdk;

import com.baidu.searchbox.config.DefaultSharedPrefsWrapper;
/* loaded from: classes14.dex */
public enum L0 {
    STATE_DEFAULT(DefaultSharedPrefsWrapper.SP_FILE_DEFAULT),
    STATE_EXPANDED("expanded"),
    STATE_LOADING("loading"),
    STATE_HIDDEN("hidden"),
    STATE_RESIZED("resized");
    

    /* renamed from: a  reason: collision with root package name */
    public String f8097a;

    L0(String str) {
        this.f8097a = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.f8097a;
    }
}

package com.win.opensdk;
/* loaded from: classes7.dex */
public enum L0 {
    STATE_DEFAULT("default"),
    STATE_EXPANDED("expanded"),
    STATE_LOADING("loading"),
    STATE_HIDDEN("hidden"),
    STATE_RESIZED("resized");
    

    /* renamed from: a  reason: collision with root package name */
    public String f40105a;

    L0(String str) {
        this.f40105a = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.f40105a;
    }
}

package com.win.opensdk;
/* loaded from: classes4.dex */
public enum ag {
    STATE_DEFAULT("default"),
    STATE_EXPANDED("expanded"),
    STATE_LOADING("loading"),
    STATE_HIDDEN("hidden"),
    STATE_RESIZED("resized");
    

    /* renamed from: java  reason: collision with other field name */
    private String f16java;

    ag(String str) {
        this.f16java = str;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.f16java;
    }
}

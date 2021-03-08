package com.sdk.base.framework.c;
/* JADX WARN: $VALUES field not found */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes4.dex */
public abstract class g {

    /* renamed from: a  reason: collision with root package name */
    public static final g f7632a = new g("PRODUCE_STATISTICAL", 0) { // from class: com.sdk.base.framework.c.h
        @Override // com.sdk.base.framework.c.g
        public final String a() {
            return com.sdk.base.framework.f.f.a.a("cucc/host_cucc.properties", "PRODUCE_STATISTICAL");
        }
    };
    public static final g b = new g("PRODUCE_DZH", 1) { // from class: com.sdk.base.framework.c.i
        @Override // com.sdk.base.framework.c.g
        public final String a() {
            return com.sdk.base.framework.f.f.a.a("cucc/host_cucc.properties", "PRODUCE_DZH");
        }
    };

    static {
        g[] gVarArr = {f7632a, b};
    }

    private g(String str, int i) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ g(String str, int i, byte b2) {
        this(str, i);
    }

    public abstract String a();
}

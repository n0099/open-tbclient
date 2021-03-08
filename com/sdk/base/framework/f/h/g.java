package com.sdk.base.framework.f.h;
/* JADX WARN: $VALUES field not found */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes4.dex */
public abstract class g {

    /* renamed from: a  reason: collision with root package name */
    public static final g f7647a = new g("CMCC", 0) { // from class: com.sdk.base.framework.f.h.h
        @Override // com.sdk.base.framework.f.h.g
        public final String a() {
            return "CMCC";
        }

        @Override // com.sdk.base.framework.f.h.g
        public final int b() {
            return 1;
        }
    };
    public static final g b = new g("CUCC", 1) { // from class: com.sdk.base.framework.f.h.i
        @Override // com.sdk.base.framework.f.h.g
        public final String a() {
            return "CUCC";
        }

        @Override // com.sdk.base.framework.f.h.g
        public final int b() {
            return 2;
        }
    };
    public static final g c = new g("CTC", 2) { // from class: com.sdk.base.framework.f.h.j
        @Override // com.sdk.base.framework.f.h.g
        public final String a() {
            return "CTC";
        }

        @Override // com.sdk.base.framework.f.h.g
        public final int b() {
            return 3;
        }
    };

    static {
        g[] gVarArr = {f7647a, b, c};
    }

    private g(String str, int i) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ g(String str, int i, byte b2) {
        this(str, i);
    }

    public abstract String a();

    public abstract int b();
}

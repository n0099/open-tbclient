package com.sdk.base.framework.f.h;
/* JADX WARN: $VALUES field not found */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes16.dex */
public abstract class c {

    /* renamed from: a  reason: collision with root package name */
    public static final c f4499a = new c("WIFI", 0) { // from class: com.sdk.base.framework.f.h.d
        @Override // com.sdk.base.framework.f.h.c
        public final int a() {
            return 0;
        }
    };
    public static final c b = new c("NET", 1) { // from class: com.sdk.base.framework.f.h.e
        @Override // com.sdk.base.framework.f.h.c
        public final int a() {
            return 1;
        }
    };
    public static final c c = new c("UNKNOW", 2) { // from class: com.sdk.base.framework.f.h.f
        @Override // com.sdk.base.framework.f.h.c
        public final int a() {
            return -1;
        }
    };

    static {
        c[] cVarArr = {f4499a, b, c};
    }

    private c(String str, int i) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ c(String str, int i, byte b2) {
        this(str, i);
    }

    public abstract int a();
}

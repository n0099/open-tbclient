package com.sdk.base.framework.f.g;

import com.baidu.tieba.imageProblem.httpNet.CDNIPDirectConnect;
/* JADX WARN: $VALUES field not found */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes6.dex */
public abstract class c {

    /* renamed from: a  reason: collision with root package name */
    public static final c f36520a = new c(CDNIPDirectConnect.CDNNetworkChangeReceiver.WIFI_STRING, 0) { // from class: com.sdk.base.framework.f.g.d
        @Override // com.sdk.base.framework.f.g.c
        public final int a() {
            return 0;
        }
    };

    /* renamed from: b  reason: collision with root package name */
    public static final c f36521b = new c("NET", 1) { // from class: com.sdk.base.framework.f.g.e
        @Override // com.sdk.base.framework.f.g.c
        public final int a() {
            return 1;
        }
    };

    /* renamed from: c  reason: collision with root package name */
    public static final c f36522c = new c("UNKNOW", 2) { // from class: com.sdk.base.framework.f.g.f
        @Override // com.sdk.base.framework.f.g.c
        public final int a() {
            return -1;
        }
    };

    public c(String str, int i2) {
    }

    public /* synthetic */ c(String str, int i2, byte b2) {
        this(str, i2);
    }

    public abstract int a();
}

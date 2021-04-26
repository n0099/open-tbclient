package com.sdk.base.framework.f.g;

import com.baidu.sapi2.outsdk.OneKeyLoginSdkCall;
/* JADX WARN: $VALUES field not found */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes6.dex */
public abstract class g {

    /* renamed from: c  reason: collision with root package name */
    public static g f36525c = new g(OneKeyLoginSdkCall.OPERATOR_CHINA_MOBILE, 0) { // from class: com.sdk.base.framework.f.g.h
        @Override // com.sdk.base.framework.f.g.g
        public final String a() {
            return OneKeyLoginSdkCall.OPERATOR_CHINA_MOBILE;
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public static final g f36523a = new g(OneKeyLoginSdkCall.OPERATOR_CHINA_UNICOM, 1) { // from class: com.sdk.base.framework.f.g.i
        @Override // com.sdk.base.framework.f.g.g
        public final String a() {
            return OneKeyLoginSdkCall.OPERATOR_CHINA_UNICOM;
        }
    };

    /* renamed from: b  reason: collision with root package name */
    public static final g f36524b = new g("CTC", 2) { // from class: com.sdk.base.framework.f.g.j
        @Override // com.sdk.base.framework.f.g.g
        public final String a() {
            return "CTC";
        }
    };

    public g(String str, int i2) {
    }

    public /* synthetic */ g(String str, int i2, byte b2) {
        this(str, i2);
    }

    public abstract String a();
}

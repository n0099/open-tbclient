package com.bytedance.sdk.openadsdk.f.a;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.common.others.lang.StringUtil;
/* loaded from: classes5.dex */
public class p {

    /* renamed from: a  reason: collision with root package name */
    public final int f29913a;

    /* renamed from: b  reason: collision with root package name */
    public final String f29914b;

    /* renamed from: c  reason: collision with root package name */
    public final String f29915c;

    /* renamed from: d  reason: collision with root package name */
    public final String f29916d;

    /* renamed from: e  reason: collision with root package name */
    public final String f29917e;

    /* renamed from: f  reason: collision with root package name */
    public final String f29918f;

    /* renamed from: g  reason: collision with root package name */
    public final String f29919g;

    /* renamed from: h  reason: collision with root package name */
    public final String f29920h;

    /* loaded from: classes5.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public String f29921a;

        /* renamed from: b  reason: collision with root package name */
        public String f29922b;

        /* renamed from: c  reason: collision with root package name */
        public String f29923c;

        /* renamed from: d  reason: collision with root package name */
        public String f29924d;

        /* renamed from: e  reason: collision with root package name */
        public String f29925e;

        /* renamed from: f  reason: collision with root package name */
        public String f29926f;

        /* renamed from: g  reason: collision with root package name */
        public String f29927g;

        public a() {
        }

        public a a(String str) {
            this.f29921a = str;
            return this;
        }

        public a b(String str) {
            this.f29922b = str;
            return this;
        }

        public a c(String str) {
            this.f29923c = str;
            return this;
        }

        public a d(String str) {
            this.f29924d = str;
            return this;
        }

        public a e(String str) {
            this.f29925e = str;
            return this;
        }

        public a f(String str) {
            this.f29926f = str;
            return this;
        }

        public a g(String str) {
            this.f29927g = str;
            return this;
        }

        public p a() {
            return new p(this);
        }
    }

    public static a a() {
        return new a();
    }

    @NonNull
    public String toString() {
        return "methodName: " + this.f29916d + ", params: " + this.f29917e + ", callbackId: " + this.f29918f + ", type: " + this.f29915c + ", version: " + this.f29914b + StringUtil.ARRAY_ELEMENT_SEPARATOR;
    }

    public p(String str, int i2) {
        this.f29914b = null;
        this.f29915c = null;
        this.f29916d = null;
        this.f29917e = null;
        this.f29918f = str;
        this.f29919g = null;
        this.f29913a = i2;
        this.f29920h = null;
    }

    public static p a(String str, int i2) {
        return new p(str, i2);
    }

    public static boolean a(p pVar) {
        return pVar == null || pVar.f29913a != 1 || TextUtils.isEmpty(pVar.f29916d) || TextUtils.isEmpty(pVar.f29917e);
    }

    public p(a aVar) {
        this.f29914b = aVar.f29921a;
        this.f29915c = aVar.f29922b;
        this.f29916d = aVar.f29923c;
        this.f29917e = aVar.f29924d;
        this.f29918f = aVar.f29925e;
        this.f29919g = aVar.f29926f;
        this.f29913a = 1;
        this.f29920h = aVar.f29927g;
    }
}

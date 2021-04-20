package com.bytedance.sdk.openadsdk.f.a;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.common.others.lang.StringUtil;
/* loaded from: classes5.dex */
public class p {

    /* renamed from: a  reason: collision with root package name */
    public final int f29013a;

    /* renamed from: b  reason: collision with root package name */
    public final String f29014b;

    /* renamed from: c  reason: collision with root package name */
    public final String f29015c;

    /* renamed from: d  reason: collision with root package name */
    public final String f29016d;

    /* renamed from: e  reason: collision with root package name */
    public final String f29017e;

    /* renamed from: f  reason: collision with root package name */
    public final String f29018f;

    /* renamed from: g  reason: collision with root package name */
    public final String f29019g;

    /* renamed from: h  reason: collision with root package name */
    public final String f29020h;

    /* loaded from: classes5.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public String f29021a;

        /* renamed from: b  reason: collision with root package name */
        public String f29022b;

        /* renamed from: c  reason: collision with root package name */
        public String f29023c;

        /* renamed from: d  reason: collision with root package name */
        public String f29024d;

        /* renamed from: e  reason: collision with root package name */
        public String f29025e;

        /* renamed from: f  reason: collision with root package name */
        public String f29026f;

        /* renamed from: g  reason: collision with root package name */
        public String f29027g;

        public a() {
        }

        public a a(String str) {
            this.f29021a = str;
            return this;
        }

        public a b(String str) {
            this.f29022b = str;
            return this;
        }

        public a c(String str) {
            this.f29023c = str;
            return this;
        }

        public a d(String str) {
            this.f29024d = str;
            return this;
        }

        public a e(String str) {
            this.f29025e = str;
            return this;
        }

        public a f(String str) {
            this.f29026f = str;
            return this;
        }

        public a g(String str) {
            this.f29027g = str;
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
        return "methodName: " + this.f29016d + ", params: " + this.f29017e + ", callbackId: " + this.f29018f + ", type: " + this.f29015c + ", version: " + this.f29014b + StringUtil.ARRAY_ELEMENT_SEPARATOR;
    }

    public p(String str, int i) {
        this.f29014b = null;
        this.f29015c = null;
        this.f29016d = null;
        this.f29017e = null;
        this.f29018f = str;
        this.f29019g = null;
        this.f29013a = i;
        this.f29020h = null;
    }

    public static p a(String str, int i) {
        return new p(str, i);
    }

    public static boolean a(p pVar) {
        return pVar == null || pVar.f29013a != 1 || TextUtils.isEmpty(pVar.f29016d) || TextUtils.isEmpty(pVar.f29017e);
    }

    public p(a aVar) {
        this.f29014b = aVar.f29021a;
        this.f29015c = aVar.f29022b;
        this.f29016d = aVar.f29023c;
        this.f29017e = aVar.f29024d;
        this.f29018f = aVar.f29025e;
        this.f29019g = aVar.f29026f;
        this.f29013a = 1;
        this.f29020h = aVar.f29027g;
    }
}

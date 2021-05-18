package com.bytedance.sdk.openadsdk.f.a;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.common.others.lang.StringUtil;
/* loaded from: classes6.dex */
public class p {

    /* renamed from: a  reason: collision with root package name */
    public final int f29158a;

    /* renamed from: b  reason: collision with root package name */
    public final String f29159b;

    /* renamed from: c  reason: collision with root package name */
    public final String f29160c;

    /* renamed from: d  reason: collision with root package name */
    public final String f29161d;

    /* renamed from: e  reason: collision with root package name */
    public final String f29162e;

    /* renamed from: f  reason: collision with root package name */
    public final String f29163f;

    /* renamed from: g  reason: collision with root package name */
    public final String f29164g;

    /* renamed from: h  reason: collision with root package name */
    public final String f29165h;

    /* loaded from: classes6.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public String f29166a;

        /* renamed from: b  reason: collision with root package name */
        public String f29167b;

        /* renamed from: c  reason: collision with root package name */
        public String f29168c;

        /* renamed from: d  reason: collision with root package name */
        public String f29169d;

        /* renamed from: e  reason: collision with root package name */
        public String f29170e;

        /* renamed from: f  reason: collision with root package name */
        public String f29171f;

        /* renamed from: g  reason: collision with root package name */
        public String f29172g;

        public a() {
        }

        public a a(String str) {
            this.f29166a = str;
            return this;
        }

        public a b(String str) {
            this.f29167b = str;
            return this;
        }

        public a c(String str) {
            this.f29168c = str;
            return this;
        }

        public a d(String str) {
            this.f29169d = str;
            return this;
        }

        public a e(String str) {
            this.f29170e = str;
            return this;
        }

        public a f(String str) {
            this.f29171f = str;
            return this;
        }

        public a g(String str) {
            this.f29172g = str;
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
        return "methodName: " + this.f29161d + ", params: " + this.f29162e + ", callbackId: " + this.f29163f + ", type: " + this.f29160c + ", version: " + this.f29159b + StringUtil.ARRAY_ELEMENT_SEPARATOR;
    }

    public p(String str, int i2) {
        this.f29159b = null;
        this.f29160c = null;
        this.f29161d = null;
        this.f29162e = null;
        this.f29163f = str;
        this.f29164g = null;
        this.f29158a = i2;
        this.f29165h = null;
    }

    public static p a(String str, int i2) {
        return new p(str, i2);
    }

    public static boolean a(p pVar) {
        return pVar == null || pVar.f29158a != 1 || TextUtils.isEmpty(pVar.f29161d) || TextUtils.isEmpty(pVar.f29162e);
    }

    public p(a aVar) {
        this.f29159b = aVar.f29166a;
        this.f29160c = aVar.f29167b;
        this.f29161d = aVar.f29168c;
        this.f29162e = aVar.f29169d;
        this.f29163f = aVar.f29170e;
        this.f29164g = aVar.f29171f;
        this.f29158a = 1;
        this.f29165h = aVar.f29172g;
    }
}

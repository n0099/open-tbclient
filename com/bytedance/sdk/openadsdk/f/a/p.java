package com.bytedance.sdk.openadsdk.f.a;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.common.others.lang.StringUtil;
/* loaded from: classes6.dex */
public class p {

    /* renamed from: a  reason: collision with root package name */
    public final int f29328a;

    /* renamed from: b  reason: collision with root package name */
    public final String f29329b;

    /* renamed from: c  reason: collision with root package name */
    public final String f29330c;

    /* renamed from: d  reason: collision with root package name */
    public final String f29331d;

    /* renamed from: e  reason: collision with root package name */
    public final String f29332e;

    /* renamed from: f  reason: collision with root package name */
    public final String f29333f;

    /* renamed from: g  reason: collision with root package name */
    public final String f29334g;

    /* renamed from: h  reason: collision with root package name */
    public final String f29335h;

    /* loaded from: classes6.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public String f29336a;

        /* renamed from: b  reason: collision with root package name */
        public String f29337b;

        /* renamed from: c  reason: collision with root package name */
        public String f29338c;

        /* renamed from: d  reason: collision with root package name */
        public String f29339d;

        /* renamed from: e  reason: collision with root package name */
        public String f29340e;

        /* renamed from: f  reason: collision with root package name */
        public String f29341f;

        /* renamed from: g  reason: collision with root package name */
        public String f29342g;

        public a() {
        }

        public a a(String str) {
            this.f29336a = str;
            return this;
        }

        public a b(String str) {
            this.f29337b = str;
            return this;
        }

        public a c(String str) {
            this.f29338c = str;
            return this;
        }

        public a d(String str) {
            this.f29339d = str;
            return this;
        }

        public a e(String str) {
            this.f29340e = str;
            return this;
        }

        public a f(String str) {
            this.f29341f = str;
            return this;
        }

        public a g(String str) {
            this.f29342g = str;
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
        return "methodName: " + this.f29331d + ", params: " + this.f29332e + ", callbackId: " + this.f29333f + ", type: " + this.f29330c + ", version: " + this.f29329b + StringUtil.ARRAY_ELEMENT_SEPARATOR;
    }

    public p(String str, int i) {
        this.f29329b = null;
        this.f29330c = null;
        this.f29331d = null;
        this.f29332e = null;
        this.f29333f = str;
        this.f29334g = null;
        this.f29328a = i;
        this.f29335h = null;
    }

    public static p a(String str, int i) {
        return new p(str, i);
    }

    public static boolean a(p pVar) {
        return pVar == null || pVar.f29328a != 1 || TextUtils.isEmpty(pVar.f29331d) || TextUtils.isEmpty(pVar.f29332e);
    }

    public p(a aVar) {
        this.f29329b = aVar.f29336a;
        this.f29330c = aVar.f29337b;
        this.f29331d = aVar.f29338c;
        this.f29332e = aVar.f29339d;
        this.f29333f = aVar.f29340e;
        this.f29334g = aVar.f29341f;
        this.f29328a = 1;
        this.f29335h = aVar.f29342g;
    }
}

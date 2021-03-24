package com.bytedance.sdk.openadsdk.f.a;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.common.others.lang.StringUtil;
/* loaded from: classes6.dex */
public class p {

    /* renamed from: a  reason: collision with root package name */
    public final int f29327a;

    /* renamed from: b  reason: collision with root package name */
    public final String f29328b;

    /* renamed from: c  reason: collision with root package name */
    public final String f29329c;

    /* renamed from: d  reason: collision with root package name */
    public final String f29330d;

    /* renamed from: e  reason: collision with root package name */
    public final String f29331e;

    /* renamed from: f  reason: collision with root package name */
    public final String f29332f;

    /* renamed from: g  reason: collision with root package name */
    public final String f29333g;

    /* renamed from: h  reason: collision with root package name */
    public final String f29334h;

    /* loaded from: classes6.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public String f29335a;

        /* renamed from: b  reason: collision with root package name */
        public String f29336b;

        /* renamed from: c  reason: collision with root package name */
        public String f29337c;

        /* renamed from: d  reason: collision with root package name */
        public String f29338d;

        /* renamed from: e  reason: collision with root package name */
        public String f29339e;

        /* renamed from: f  reason: collision with root package name */
        public String f29340f;

        /* renamed from: g  reason: collision with root package name */
        public String f29341g;

        public a() {
        }

        public a a(String str) {
            this.f29335a = str;
            return this;
        }

        public a b(String str) {
            this.f29336b = str;
            return this;
        }

        public a c(String str) {
            this.f29337c = str;
            return this;
        }

        public a d(String str) {
            this.f29338d = str;
            return this;
        }

        public a e(String str) {
            this.f29339e = str;
            return this;
        }

        public a f(String str) {
            this.f29340f = str;
            return this;
        }

        public a g(String str) {
            this.f29341g = str;
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
        return "methodName: " + this.f29330d + ", params: " + this.f29331e + ", callbackId: " + this.f29332f + ", type: " + this.f29329c + ", version: " + this.f29328b + StringUtil.ARRAY_ELEMENT_SEPARATOR;
    }

    public p(String str, int i) {
        this.f29328b = null;
        this.f29329c = null;
        this.f29330d = null;
        this.f29331e = null;
        this.f29332f = str;
        this.f29333g = null;
        this.f29327a = i;
        this.f29334h = null;
    }

    public static p a(String str, int i) {
        return new p(str, i);
    }

    public static boolean a(p pVar) {
        return pVar == null || pVar.f29327a != 1 || TextUtils.isEmpty(pVar.f29330d) || TextUtils.isEmpty(pVar.f29331e);
    }

    public p(a aVar) {
        this.f29328b = aVar.f29335a;
        this.f29329c = aVar.f29336b;
        this.f29330d = aVar.f29337c;
        this.f29331e = aVar.f29338d;
        this.f29332f = aVar.f29339e;
        this.f29333g = aVar.f29340f;
        this.f29327a = 1;
        this.f29334h = aVar.f29341g;
    }
}

package com.bytedance.sdk.openadsdk.f.a;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.common.others.lang.StringUtil;
/* loaded from: classes6.dex */
public class p {

    /* renamed from: a  reason: collision with root package name */
    public final int f29190a;

    /* renamed from: b  reason: collision with root package name */
    public final String f29191b;

    /* renamed from: c  reason: collision with root package name */
    public final String f29192c;

    /* renamed from: d  reason: collision with root package name */
    public final String f29193d;

    /* renamed from: e  reason: collision with root package name */
    public final String f29194e;

    /* renamed from: f  reason: collision with root package name */
    public final String f29195f;

    /* renamed from: g  reason: collision with root package name */
    public final String f29196g;

    /* renamed from: h  reason: collision with root package name */
    public final String f29197h;

    /* loaded from: classes6.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public String f29198a;

        /* renamed from: b  reason: collision with root package name */
        public String f29199b;

        /* renamed from: c  reason: collision with root package name */
        public String f29200c;

        /* renamed from: d  reason: collision with root package name */
        public String f29201d;

        /* renamed from: e  reason: collision with root package name */
        public String f29202e;

        /* renamed from: f  reason: collision with root package name */
        public String f29203f;

        /* renamed from: g  reason: collision with root package name */
        public String f29204g;

        public a() {
        }

        public a a(String str) {
            this.f29198a = str;
            return this;
        }

        public a b(String str) {
            this.f29199b = str;
            return this;
        }

        public a c(String str) {
            this.f29200c = str;
            return this;
        }

        public a d(String str) {
            this.f29201d = str;
            return this;
        }

        public a e(String str) {
            this.f29202e = str;
            return this;
        }

        public a f(String str) {
            this.f29203f = str;
            return this;
        }

        public a g(String str) {
            this.f29204g = str;
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
        return "methodName: " + this.f29193d + ", params: " + this.f29194e + ", callbackId: " + this.f29195f + ", type: " + this.f29192c + ", version: " + this.f29191b + StringUtil.ARRAY_ELEMENT_SEPARATOR;
    }

    public p(String str, int i2) {
        this.f29191b = null;
        this.f29192c = null;
        this.f29193d = null;
        this.f29194e = null;
        this.f29195f = str;
        this.f29196g = null;
        this.f29190a = i2;
        this.f29197h = null;
    }

    public static p a(String str, int i2) {
        return new p(str, i2);
    }

    public static boolean a(p pVar) {
        return pVar == null || pVar.f29190a != 1 || TextUtils.isEmpty(pVar.f29193d) || TextUtils.isEmpty(pVar.f29194e);
    }

    public p(a aVar) {
        this.f29191b = aVar.f29198a;
        this.f29192c = aVar.f29199b;
        this.f29193d = aVar.f29200c;
        this.f29194e = aVar.f29201d;
        this.f29195f = aVar.f29202e;
        this.f29196g = aVar.f29203f;
        this.f29190a = 1;
        this.f29197h = aVar.f29204g;
    }
}

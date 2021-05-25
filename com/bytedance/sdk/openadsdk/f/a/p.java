package com.bytedance.sdk.openadsdk.f.a;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.common.others.lang.StringUtil;
/* loaded from: classes6.dex */
public class p {

    /* renamed from: a  reason: collision with root package name */
    public final int f29087a;

    /* renamed from: b  reason: collision with root package name */
    public final String f29088b;

    /* renamed from: c  reason: collision with root package name */
    public final String f29089c;

    /* renamed from: d  reason: collision with root package name */
    public final String f29090d;

    /* renamed from: e  reason: collision with root package name */
    public final String f29091e;

    /* renamed from: f  reason: collision with root package name */
    public final String f29092f;

    /* renamed from: g  reason: collision with root package name */
    public final String f29093g;

    /* renamed from: h  reason: collision with root package name */
    public final String f29094h;

    /* loaded from: classes6.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public String f29095a;

        /* renamed from: b  reason: collision with root package name */
        public String f29096b;

        /* renamed from: c  reason: collision with root package name */
        public String f29097c;

        /* renamed from: d  reason: collision with root package name */
        public String f29098d;

        /* renamed from: e  reason: collision with root package name */
        public String f29099e;

        /* renamed from: f  reason: collision with root package name */
        public String f29100f;

        /* renamed from: g  reason: collision with root package name */
        public String f29101g;

        public a() {
        }

        public a a(String str) {
            this.f29095a = str;
            return this;
        }

        public a b(String str) {
            this.f29096b = str;
            return this;
        }

        public a c(String str) {
            this.f29097c = str;
            return this;
        }

        public a d(String str) {
            this.f29098d = str;
            return this;
        }

        public a e(String str) {
            this.f29099e = str;
            return this;
        }

        public a f(String str) {
            this.f29100f = str;
            return this;
        }

        public a g(String str) {
            this.f29101g = str;
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
        return "methodName: " + this.f29090d + ", params: " + this.f29091e + ", callbackId: " + this.f29092f + ", type: " + this.f29089c + ", version: " + this.f29088b + StringUtil.ARRAY_ELEMENT_SEPARATOR;
    }

    public p(String str, int i2) {
        this.f29088b = null;
        this.f29089c = null;
        this.f29090d = null;
        this.f29091e = null;
        this.f29092f = str;
        this.f29093g = null;
        this.f29087a = i2;
        this.f29094h = null;
    }

    public static p a(String str, int i2) {
        return new p(str, i2);
    }

    public static boolean a(p pVar) {
        return pVar == null || pVar.f29087a != 1 || TextUtils.isEmpty(pVar.f29090d) || TextUtils.isEmpty(pVar.f29091e);
    }

    public p(a aVar) {
        this.f29088b = aVar.f29095a;
        this.f29089c = aVar.f29096b;
        this.f29090d = aVar.f29097c;
        this.f29091e = aVar.f29098d;
        this.f29092f = aVar.f29099e;
        this.f29093g = aVar.f29100f;
        this.f29087a = 1;
        this.f29094h = aVar.f29101g;
    }
}

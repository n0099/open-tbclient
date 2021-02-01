package com.bytedance.sdk.openadsdk.f.a;

import android.text.TextUtils;
import androidx.annotation.NonNull;
/* loaded from: classes6.dex */
public class p {

    /* renamed from: a  reason: collision with root package name */
    public final int f7132a;

    /* renamed from: b  reason: collision with root package name */
    public final String f7133b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;

    public static a a() {
        return new a();
    }

    public static p a(String str, int i) {
        return new p(str, i);
    }

    private p(String str, int i) {
        this.f7133b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = str;
        this.g = null;
        this.f7132a = i;
        this.h = null;
    }

    private p(a aVar) {
        this.f7133b = aVar.f7134a;
        this.c = aVar.f7135b;
        this.d = aVar.c;
        this.e = aVar.d;
        this.f = aVar.e;
        this.g = aVar.f;
        this.f7132a = 1;
        this.h = aVar.g;
    }

    public static boolean a(p pVar) {
        return pVar == null || pVar.f7132a != 1 || TextUtils.isEmpty(pVar.d) || TextUtils.isEmpty(pVar.e);
    }

    @NonNull
    public String toString() {
        return "methodName: " + this.d + ", params: " + this.e + ", callbackId: " + this.f + ", type: " + this.c + ", version: " + this.f7133b + ", ";
    }

    /* loaded from: classes6.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private String f7134a;

        /* renamed from: b  reason: collision with root package name */
        private String f7135b;
        private String c;
        private String d;
        private String e;
        private String f;
        private String g;

        private a() {
        }

        public a a(String str) {
            this.f7134a = str;
            return this;
        }

        public a b(String str) {
            this.f7135b = str;
            return this;
        }

        public a c(String str) {
            this.c = str;
            return this;
        }

        public a d(String str) {
            this.d = str;
            return this;
        }

        public a e(String str) {
            this.e = str;
            return this;
        }

        public a f(String str) {
            this.f = str;
            return this;
        }

        public a g(String str) {
            this.g = str;
            return this;
        }

        public p a() {
            return new p(this);
        }
    }
}

package com.kwai.sodler.lib.ext;

import androidx.annotation.NonNull;
import com.baidu.webkit.sdk.SevenZipUtils;
/* loaded from: classes6.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public final int f37160a;

    /* renamed from: b  reason: collision with root package name */
    public final String f37161b;

    /* renamed from: c  reason: collision with root package name */
    public final String f37162c;

    /* renamed from: d  reason: collision with root package name */
    public final String f37163d;

    /* renamed from: e  reason: collision with root package name */
    public final String f37164e;

    /* renamed from: f  reason: collision with root package name */
    public final String f37165f;

    /* renamed from: g  reason: collision with root package name */
    public final String f37166g;

    /* renamed from: h  reason: collision with root package name */
    public final String f37167h;
    public final boolean i;
    public final boolean j;
    public String k;
    public byte[] l;
    public boolean m;

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: b  reason: collision with root package name */
        public String f37169b;
        public String k;
        public byte[] l;
        public boolean m;

        /* renamed from: a  reason: collision with root package name */
        public int f37168a = 3;

        /* renamed from: c  reason: collision with root package name */
        public String f37170c = "sodler";

        /* renamed from: d  reason: collision with root package name */
        public String f37171d = "code-cache";

        /* renamed from: e  reason: collision with root package name */
        public String f37172e = "lib";

        /* renamed from: f  reason: collision with root package name */
        public String f37173f = SevenZipUtils.FILE_NAME_TEMP;

        /* renamed from: g  reason: collision with root package name */
        public String f37174g = "base-1.apk";

        /* renamed from: h  reason: collision with root package name */
        public String f37175h = ".tmp";
        public boolean i = false;
        public boolean j = false;

        public a a(int i) {
            if (i > 0) {
                this.f37168a = i;
            }
            return this;
        }

        public a a(@NonNull String str) {
            this.f37170c = str;
            return this;
        }

        public a a(boolean z) {
            this.m = z;
            return this;
        }

        public c a() {
            return new c(this.j, this.i, this.f37169b, this.f37170c, this.f37171d, this.f37172e, this.f37173f, this.f37175h, this.f37174g, this.f37168a, this.k, this.l, this.m);
        }
    }

    public c(boolean z, boolean z2, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, String str8, byte[] bArr, boolean z3) {
        this.f37160a = i;
        this.f37161b = str2;
        this.f37162c = str3;
        this.f37163d = str4;
        this.f37164e = str5;
        this.f37165f = str6;
        this.f37166g = str7;
        this.f37167h = str;
        this.i = z;
        this.j = z2;
        this.k = str8;
        this.l = bArr;
        this.m = z3;
    }

    public int a() {
        return this.f37160a;
    }

    public String b() {
        return this.f37161b;
    }

    public String c() {
        return this.f37163d;
    }

    public String d() {
        return this.f37164e;
    }

    public String e() {
        return this.f37165f;
    }

    public String f() {
        return this.f37166g;
    }

    public boolean g() {
        return this.j;
    }
}

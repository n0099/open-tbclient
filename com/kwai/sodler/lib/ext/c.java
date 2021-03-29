package com.kwai.sodler.lib.ext;

import androidx.annotation.NonNull;
import com.baidu.webkit.sdk.SevenZipUtils;
/* loaded from: classes6.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public final int f37161a;

    /* renamed from: b  reason: collision with root package name */
    public final String f37162b;

    /* renamed from: c  reason: collision with root package name */
    public final String f37163c;

    /* renamed from: d  reason: collision with root package name */
    public final String f37164d;

    /* renamed from: e  reason: collision with root package name */
    public final String f37165e;

    /* renamed from: f  reason: collision with root package name */
    public final String f37166f;

    /* renamed from: g  reason: collision with root package name */
    public final String f37167g;

    /* renamed from: h  reason: collision with root package name */
    public final String f37168h;
    public final boolean i;
    public final boolean j;
    public String k;
    public byte[] l;
    public boolean m;

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: b  reason: collision with root package name */
        public String f37170b;
        public String k;
        public byte[] l;
        public boolean m;

        /* renamed from: a  reason: collision with root package name */
        public int f37169a = 3;

        /* renamed from: c  reason: collision with root package name */
        public String f37171c = "sodler";

        /* renamed from: d  reason: collision with root package name */
        public String f37172d = "code-cache";

        /* renamed from: e  reason: collision with root package name */
        public String f37173e = "lib";

        /* renamed from: f  reason: collision with root package name */
        public String f37174f = SevenZipUtils.FILE_NAME_TEMP;

        /* renamed from: g  reason: collision with root package name */
        public String f37175g = "base-1.apk";

        /* renamed from: h  reason: collision with root package name */
        public String f37176h = ".tmp";
        public boolean i = false;
        public boolean j = false;

        public a a(int i) {
            if (i > 0) {
                this.f37169a = i;
            }
            return this;
        }

        public a a(@NonNull String str) {
            this.f37171c = str;
            return this;
        }

        public a a(boolean z) {
            this.m = z;
            return this;
        }

        public c a() {
            return new c(this.j, this.i, this.f37170b, this.f37171c, this.f37172d, this.f37173e, this.f37174f, this.f37176h, this.f37175g, this.f37169a, this.k, this.l, this.m);
        }
    }

    public c(boolean z, boolean z2, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, String str8, byte[] bArr, boolean z3) {
        this.f37161a = i;
        this.f37162b = str2;
        this.f37163c = str3;
        this.f37164d = str4;
        this.f37165e = str5;
        this.f37166f = str6;
        this.f37167g = str7;
        this.f37168h = str;
        this.i = z;
        this.j = z2;
        this.k = str8;
        this.l = bArr;
        this.m = z3;
    }

    public int a() {
        return this.f37161a;
    }

    public String b() {
        return this.f37162b;
    }

    public String c() {
        return this.f37164d;
    }

    public String d() {
        return this.f37165e;
    }

    public String e() {
        return this.f37166f;
    }

    public String f() {
        return this.f37167g;
    }

    public boolean g() {
        return this.j;
    }
}

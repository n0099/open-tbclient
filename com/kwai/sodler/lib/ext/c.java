package com.kwai.sodler.lib.ext;

import androidx.annotation.NonNull;
import com.baidu.webkit.sdk.SevenZipUtils;
/* loaded from: classes6.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public final int f37545a;

    /* renamed from: b  reason: collision with root package name */
    public final String f37546b;

    /* renamed from: c  reason: collision with root package name */
    public final String f37547c;

    /* renamed from: d  reason: collision with root package name */
    public final String f37548d;

    /* renamed from: e  reason: collision with root package name */
    public final String f37549e;

    /* renamed from: f  reason: collision with root package name */
    public final String f37550f;

    /* renamed from: g  reason: collision with root package name */
    public final String f37551g;

    /* renamed from: h  reason: collision with root package name */
    public final String f37552h;
    public final boolean i;
    public final boolean j;
    public String k;
    public byte[] l;
    public boolean m;

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: b  reason: collision with root package name */
        public String f37554b;
        public String k;
        public byte[] l;
        public boolean m;

        /* renamed from: a  reason: collision with root package name */
        public int f37553a = 3;

        /* renamed from: c  reason: collision with root package name */
        public String f37555c = "sodler";

        /* renamed from: d  reason: collision with root package name */
        public String f37556d = "code-cache";

        /* renamed from: e  reason: collision with root package name */
        public String f37557e = "lib";

        /* renamed from: f  reason: collision with root package name */
        public String f37558f = SevenZipUtils.FILE_NAME_TEMP;

        /* renamed from: g  reason: collision with root package name */
        public String f37559g = "base-1.apk";

        /* renamed from: h  reason: collision with root package name */
        public String f37560h = ".tmp";
        public boolean i = false;
        public boolean j = false;

        public a a(int i) {
            if (i > 0) {
                this.f37553a = i;
            }
            return this;
        }

        public a a(@NonNull String str) {
            this.f37555c = str;
            return this;
        }

        public a a(boolean z) {
            this.m = z;
            return this;
        }

        public c a() {
            return new c(this.j, this.i, this.f37554b, this.f37555c, this.f37556d, this.f37557e, this.f37558f, this.f37560h, this.f37559g, this.f37553a, this.k, this.l, this.m);
        }
    }

    public c(boolean z, boolean z2, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, String str8, byte[] bArr, boolean z3) {
        this.f37545a = i;
        this.f37546b = str2;
        this.f37547c = str3;
        this.f37548d = str4;
        this.f37549e = str5;
        this.f37550f = str6;
        this.f37551g = str7;
        this.f37552h = str;
        this.i = z;
        this.j = z2;
        this.k = str8;
        this.l = bArr;
        this.m = z3;
    }

    public int a() {
        return this.f37545a;
    }

    public String b() {
        return this.f37546b;
    }

    public String c() {
        return this.f37548d;
    }

    public String d() {
        return this.f37549e;
    }

    public String e() {
        return this.f37550f;
    }

    public String f() {
        return this.f37551g;
    }

    public boolean g() {
        return this.j;
    }
}

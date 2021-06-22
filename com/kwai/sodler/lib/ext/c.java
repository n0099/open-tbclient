package com.kwai.sodler.lib.ext;

import androidx.annotation.NonNull;
import com.baidu.webkit.sdk.SevenZipUtils;
/* loaded from: classes7.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public final int f38025a;

    /* renamed from: b  reason: collision with root package name */
    public final String f38026b;

    /* renamed from: c  reason: collision with root package name */
    public final String f38027c;

    /* renamed from: d  reason: collision with root package name */
    public final String f38028d;

    /* renamed from: e  reason: collision with root package name */
    public final String f38029e;

    /* renamed from: f  reason: collision with root package name */
    public final String f38030f;

    /* renamed from: g  reason: collision with root package name */
    public final String f38031g;

    /* renamed from: h  reason: collision with root package name */
    public final String f38032h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f38033i;
    public final boolean j;
    public String k;
    public byte[] l;
    public boolean m;

    /* loaded from: classes7.dex */
    public static class a {

        /* renamed from: b  reason: collision with root package name */
        public String f38035b;
        public String k;
        public byte[] l;
        public boolean m;

        /* renamed from: a  reason: collision with root package name */
        public int f38034a = 3;

        /* renamed from: c  reason: collision with root package name */
        public String f38036c = "sodler";

        /* renamed from: d  reason: collision with root package name */
        public String f38037d = "code-cache";

        /* renamed from: e  reason: collision with root package name */
        public String f38038e = "lib";

        /* renamed from: f  reason: collision with root package name */
        public String f38039f = SevenZipUtils.FILE_NAME_TEMP;

        /* renamed from: g  reason: collision with root package name */
        public String f38040g = "base-1.apk";

        /* renamed from: h  reason: collision with root package name */
        public String f38041h = ".tmp";

        /* renamed from: i  reason: collision with root package name */
        public boolean f38042i = false;
        public boolean j = false;

        public a a(int i2) {
            if (i2 > 0) {
                this.f38034a = i2;
            }
            return this;
        }

        public a a(@NonNull String str) {
            this.f38036c = str;
            return this;
        }

        public a a(boolean z) {
            this.m = z;
            return this;
        }

        public c a() {
            return new c(this.j, this.f38042i, this.f38035b, this.f38036c, this.f38037d, this.f38038e, this.f38039f, this.f38041h, this.f38040g, this.f38034a, this.k, this.l, this.m);
        }
    }

    public c(boolean z, boolean z2, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i2, String str8, byte[] bArr, boolean z3) {
        this.f38025a = i2;
        this.f38026b = str2;
        this.f38027c = str3;
        this.f38028d = str4;
        this.f38029e = str5;
        this.f38030f = str6;
        this.f38031g = str7;
        this.f38032h = str;
        this.f38033i = z;
        this.j = z2;
        this.k = str8;
        this.l = bArr;
        this.m = z3;
    }

    public int a() {
        return this.f38025a;
    }

    public String b() {
        return this.f38026b;
    }

    public String c() {
        return this.f38028d;
    }

    public String d() {
        return this.f38029e;
    }

    public String e() {
        return this.f38030f;
    }

    public String f() {
        return this.f38031g;
    }

    public boolean g() {
        return this.j;
    }
}

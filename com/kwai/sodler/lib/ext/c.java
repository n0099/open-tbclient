package com.kwai.sodler.lib.ext;

import androidx.annotation.NonNull;
import com.baidu.webkit.sdk.SevenZipUtils;
/* loaded from: classes6.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public final int f34443a;

    /* renamed from: b  reason: collision with root package name */
    public final String f34444b;

    /* renamed from: c  reason: collision with root package name */
    public final String f34445c;

    /* renamed from: d  reason: collision with root package name */
    public final String f34446d;

    /* renamed from: e  reason: collision with root package name */
    public final String f34447e;

    /* renamed from: f  reason: collision with root package name */
    public final String f34448f;

    /* renamed from: g  reason: collision with root package name */
    public final String f34449g;

    /* renamed from: h  reason: collision with root package name */
    public final String f34450h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f34451i;
    public final boolean j;
    public String k;
    public byte[] l;
    public boolean m;

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: b  reason: collision with root package name */
        public String f34453b;
        public String k;
        public byte[] l;
        public boolean m;

        /* renamed from: a  reason: collision with root package name */
        public int f34452a = 3;

        /* renamed from: c  reason: collision with root package name */
        public String f34454c = "sodler";

        /* renamed from: d  reason: collision with root package name */
        public String f34455d = "code-cache";

        /* renamed from: e  reason: collision with root package name */
        public String f34456e = "lib";

        /* renamed from: f  reason: collision with root package name */
        public String f34457f = SevenZipUtils.FILE_NAME_TEMP;

        /* renamed from: g  reason: collision with root package name */
        public String f34458g = "base-1.apk";

        /* renamed from: h  reason: collision with root package name */
        public String f34459h = ".tmp";

        /* renamed from: i  reason: collision with root package name */
        public boolean f34460i = false;
        public boolean j = false;

        public a a(int i2) {
            if (i2 > 0) {
                this.f34452a = i2;
            }
            return this;
        }

        public a a(@NonNull String str) {
            this.f34454c = str;
            return this;
        }

        public a a(boolean z) {
            this.m = z;
            return this;
        }

        public c a() {
            return new c(this.j, this.f34460i, this.f34453b, this.f34454c, this.f34455d, this.f34456e, this.f34457f, this.f34459h, this.f34458g, this.f34452a, this.k, this.l, this.m);
        }
    }

    public c(boolean z, boolean z2, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i2, String str8, byte[] bArr, boolean z3) {
        this.f34443a = i2;
        this.f34444b = str2;
        this.f34445c = str3;
        this.f34446d = str4;
        this.f34447e = str5;
        this.f34448f = str6;
        this.f34449g = str7;
        this.f34450h = str;
        this.f34451i = z;
        this.j = z2;
        this.k = str8;
        this.l = bArr;
        this.m = z3;
    }

    public int a() {
        return this.f34443a;
    }

    public String b() {
        return this.f34444b;
    }

    public String c() {
        return this.f34446d;
    }

    public String d() {
        return this.f34447e;
    }

    public String e() {
        return this.f34448f;
    }

    public String f() {
        return this.f34449g;
    }

    public boolean g() {
        return this.j;
    }
}

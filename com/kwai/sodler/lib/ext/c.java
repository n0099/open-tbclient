package com.kwai.sodler.lib.ext;

import androidx.annotation.NonNull;
import com.baidu.webkit.sdk.SevenZipUtils;
/* loaded from: classes6.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public final int f35269a;

    /* renamed from: b  reason: collision with root package name */
    public final String f35270b;

    /* renamed from: c  reason: collision with root package name */
    public final String f35271c;

    /* renamed from: d  reason: collision with root package name */
    public final String f35272d;

    /* renamed from: e  reason: collision with root package name */
    public final String f35273e;

    /* renamed from: f  reason: collision with root package name */
    public final String f35274f;

    /* renamed from: g  reason: collision with root package name */
    public final String f35275g;

    /* renamed from: h  reason: collision with root package name */
    public final String f35276h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f35277i;
    public final boolean j;
    public String k;
    public byte[] l;
    public boolean m;

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: b  reason: collision with root package name */
        public String f35279b;
        public String k;
        public byte[] l;
        public boolean m;

        /* renamed from: a  reason: collision with root package name */
        public int f35278a = 3;

        /* renamed from: c  reason: collision with root package name */
        public String f35280c = "sodler";

        /* renamed from: d  reason: collision with root package name */
        public String f35281d = "code-cache";

        /* renamed from: e  reason: collision with root package name */
        public String f35282e = "lib";

        /* renamed from: f  reason: collision with root package name */
        public String f35283f = SevenZipUtils.FILE_NAME_TEMP;

        /* renamed from: g  reason: collision with root package name */
        public String f35284g = "base-1.apk";

        /* renamed from: h  reason: collision with root package name */
        public String f35285h = ".tmp";

        /* renamed from: i  reason: collision with root package name */
        public boolean f35286i = false;
        public boolean j = false;

        public a a(int i2) {
            if (i2 > 0) {
                this.f35278a = i2;
            }
            return this;
        }

        public a a(@NonNull String str) {
            this.f35280c = str;
            return this;
        }

        public a a(boolean z) {
            this.m = z;
            return this;
        }

        public c a() {
            return new c(this.j, this.f35286i, this.f35279b, this.f35280c, this.f35281d, this.f35282e, this.f35283f, this.f35285h, this.f35284g, this.f35278a, this.k, this.l, this.m);
        }
    }

    public c(boolean z, boolean z2, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i2, String str8, byte[] bArr, boolean z3) {
        this.f35269a = i2;
        this.f35270b = str2;
        this.f35271c = str3;
        this.f35272d = str4;
        this.f35273e = str5;
        this.f35274f = str6;
        this.f35275g = str7;
        this.f35276h = str;
        this.f35277i = z;
        this.j = z2;
        this.k = str8;
        this.l = bArr;
        this.m = z3;
    }

    public int a() {
        return this.f35269a;
    }

    public String b() {
        return this.f35270b;
    }

    public String c() {
        return this.f35272d;
    }

    public String d() {
        return this.f35273e;
    }

    public String e() {
        return this.f35274f;
    }

    public String f() {
        return this.f35275g;
    }

    public boolean g() {
        return this.j;
    }
}

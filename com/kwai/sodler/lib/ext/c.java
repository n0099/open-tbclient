package com.kwai.sodler.lib.ext;

import androidx.annotation.NonNull;
import com.baidu.webkit.sdk.SevenZipUtils;
/* loaded from: classes6.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public final int f37450a;

    /* renamed from: b  reason: collision with root package name */
    public final String f37451b;

    /* renamed from: c  reason: collision with root package name */
    public final String f37452c;

    /* renamed from: d  reason: collision with root package name */
    public final String f37453d;

    /* renamed from: e  reason: collision with root package name */
    public final String f37454e;

    /* renamed from: f  reason: collision with root package name */
    public final String f37455f;

    /* renamed from: g  reason: collision with root package name */
    public final String f37456g;

    /* renamed from: h  reason: collision with root package name */
    public final String f37457h;
    public final boolean i;
    public final boolean j;
    public String k;
    public byte[] l;
    public boolean m;

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: b  reason: collision with root package name */
        public String f37459b;
        public String k;
        public byte[] l;
        public boolean m;

        /* renamed from: a  reason: collision with root package name */
        public int f37458a = 3;

        /* renamed from: c  reason: collision with root package name */
        public String f37460c = "sodler";

        /* renamed from: d  reason: collision with root package name */
        public String f37461d = "code-cache";

        /* renamed from: e  reason: collision with root package name */
        public String f37462e = "lib";

        /* renamed from: f  reason: collision with root package name */
        public String f37463f = SevenZipUtils.FILE_NAME_TEMP;

        /* renamed from: g  reason: collision with root package name */
        public String f37464g = "base-1.apk";

        /* renamed from: h  reason: collision with root package name */
        public String f37465h = ".tmp";
        public boolean i = false;
        public boolean j = false;

        public a a(int i) {
            if (i > 0) {
                this.f37458a = i;
            }
            return this;
        }

        public a a(@NonNull String str) {
            this.f37460c = str;
            return this;
        }

        public a a(boolean z) {
            this.m = z;
            return this;
        }

        public c a() {
            return new c(this.j, this.i, this.f37459b, this.f37460c, this.f37461d, this.f37462e, this.f37463f, this.f37465h, this.f37464g, this.f37458a, this.k, this.l, this.m);
        }
    }

    public c(boolean z, boolean z2, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, String str8, byte[] bArr, boolean z3) {
        this.f37450a = i;
        this.f37451b = str2;
        this.f37452c = str3;
        this.f37453d = str4;
        this.f37454e = str5;
        this.f37455f = str6;
        this.f37456g = str7;
        this.f37457h = str;
        this.i = z;
        this.j = z2;
        this.k = str8;
        this.l = bArr;
        this.m = z3;
    }

    public int a() {
        return this.f37450a;
    }

    public String b() {
        return this.f37451b;
    }

    public String c() {
        return this.f37453d;
    }

    public String d() {
        return this.f37454e;
    }

    public String e() {
        return this.f37455f;
    }

    public String f() {
        return this.f37456g;
    }

    public boolean g() {
        return this.j;
    }
}

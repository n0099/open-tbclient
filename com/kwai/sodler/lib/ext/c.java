package com.kwai.sodler.lib.ext;

import androidx.annotation.NonNull;
import com.baidu.webkit.sdk.SevenZipUtils;
/* loaded from: classes6.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public final int f34514a;

    /* renamed from: b  reason: collision with root package name */
    public final String f34515b;

    /* renamed from: c  reason: collision with root package name */
    public final String f34516c;

    /* renamed from: d  reason: collision with root package name */
    public final String f34517d;

    /* renamed from: e  reason: collision with root package name */
    public final String f34518e;

    /* renamed from: f  reason: collision with root package name */
    public final String f34519f;

    /* renamed from: g  reason: collision with root package name */
    public final String f34520g;

    /* renamed from: h  reason: collision with root package name */
    public final String f34521h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f34522i;
    public final boolean j;
    public String k;
    public byte[] l;
    public boolean m;

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: b  reason: collision with root package name */
        public String f34524b;
        public String k;
        public byte[] l;
        public boolean m;

        /* renamed from: a  reason: collision with root package name */
        public int f34523a = 3;

        /* renamed from: c  reason: collision with root package name */
        public String f34525c = "sodler";

        /* renamed from: d  reason: collision with root package name */
        public String f34526d = "code-cache";

        /* renamed from: e  reason: collision with root package name */
        public String f34527e = "lib";

        /* renamed from: f  reason: collision with root package name */
        public String f34528f = SevenZipUtils.FILE_NAME_TEMP;

        /* renamed from: g  reason: collision with root package name */
        public String f34529g = "base-1.apk";

        /* renamed from: h  reason: collision with root package name */
        public String f34530h = ".tmp";

        /* renamed from: i  reason: collision with root package name */
        public boolean f34531i = false;
        public boolean j = false;

        public a a(int i2) {
            if (i2 > 0) {
                this.f34523a = i2;
            }
            return this;
        }

        public a a(@NonNull String str) {
            this.f34525c = str;
            return this;
        }

        public a a(boolean z) {
            this.m = z;
            return this;
        }

        public c a() {
            return new c(this.j, this.f34531i, this.f34524b, this.f34525c, this.f34526d, this.f34527e, this.f34528f, this.f34530h, this.f34529g, this.f34523a, this.k, this.l, this.m);
        }
    }

    public c(boolean z, boolean z2, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i2, String str8, byte[] bArr, boolean z3) {
        this.f34514a = i2;
        this.f34515b = str2;
        this.f34516c = str3;
        this.f34517d = str4;
        this.f34518e = str5;
        this.f34519f = str6;
        this.f34520g = str7;
        this.f34521h = str;
        this.f34522i = z;
        this.j = z2;
        this.k = str8;
        this.l = bArr;
        this.m = z3;
    }

    public int a() {
        return this.f34514a;
    }

    public String b() {
        return this.f34515b;
    }

    public String c() {
        return this.f34517d;
    }

    public String d() {
        return this.f34518e;
    }

    public String e() {
        return this.f34519f;
    }

    public String f() {
        return this.f34520g;
    }

    public boolean g() {
        return this.j;
    }
}

package com.kwai.sodler.lib.ext;

import androidx.annotation.NonNull;
/* loaded from: classes5.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private final int f11311a;

    /* renamed from: b  reason: collision with root package name */
    private final String f11312b;
    private final String c;
    private final String d;
    private final String e;
    private final String f;
    private final String g;
    private final String h;
    private final boolean i;
    private final boolean j;
    private String k;
    private byte[] l;
    private boolean m;

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: b  reason: collision with root package name */
        private String f11314b;
        private String k;
        private byte[] l;
        private boolean m;

        /* renamed from: a  reason: collision with root package name */
        private int f11313a = 3;
        private String c = "sodler";
        private String d = "code-cache";
        private String e = "lib";
        private String f = "temp";
        private String g = "base-1.apk";
        private String h = ".tmp";
        private boolean i = false;
        private boolean j = false;

        public a a(int i) {
            if (i > 0) {
                this.f11313a = i;
            }
            return this;
        }

        public a a(@NonNull String str) {
            this.c = str;
            return this;
        }

        public a a(boolean z) {
            this.m = z;
            return this;
        }

        public c a() {
            return new c(this.j, this.i, this.f11314b, this.c, this.d, this.e, this.f, this.h, this.g, this.f11313a, this.k, this.l, this.m);
        }
    }

    private c(boolean z, boolean z2, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, String str8, byte[] bArr, boolean z3) {
        this.f11311a = i;
        this.f11312b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
        this.f = str6;
        this.g = str7;
        this.h = str;
        this.i = z;
        this.j = z2;
        this.k = str8;
        this.l = bArr;
        this.m = z3;
    }

    public int a() {
        return this.f11311a;
    }

    public String b() {
        return this.f11312b;
    }

    public String c() {
        return this.d;
    }

    public String d() {
        return this.e;
    }

    public String e() {
        return this.f;
    }

    public String f() {
        return this.g;
    }

    public boolean g() {
        return this.j;
    }
}

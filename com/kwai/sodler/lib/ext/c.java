package com.kwai.sodler.lib.ext;

import androidx.annotation.NonNull;
import com.baidu.webkit.sdk.SevenZipUtils;
/* loaded from: classes7.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public final int f37927a;

    /* renamed from: b  reason: collision with root package name */
    public final String f37928b;

    /* renamed from: c  reason: collision with root package name */
    public final String f37929c;

    /* renamed from: d  reason: collision with root package name */
    public final String f37930d;

    /* renamed from: e  reason: collision with root package name */
    public final String f37931e;

    /* renamed from: f  reason: collision with root package name */
    public final String f37932f;

    /* renamed from: g  reason: collision with root package name */
    public final String f37933g;

    /* renamed from: h  reason: collision with root package name */
    public final String f37934h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f37935i;
    public final boolean j;
    public String k;
    public byte[] l;
    public boolean m;

    /* loaded from: classes7.dex */
    public static class a {

        /* renamed from: b  reason: collision with root package name */
        public String f37937b;
        public String k;
        public byte[] l;
        public boolean m;

        /* renamed from: a  reason: collision with root package name */
        public int f37936a = 3;

        /* renamed from: c  reason: collision with root package name */
        public String f37938c = "sodler";

        /* renamed from: d  reason: collision with root package name */
        public String f37939d = "code-cache";

        /* renamed from: e  reason: collision with root package name */
        public String f37940e = "lib";

        /* renamed from: f  reason: collision with root package name */
        public String f37941f = SevenZipUtils.FILE_NAME_TEMP;

        /* renamed from: g  reason: collision with root package name */
        public String f37942g = "base-1.apk";

        /* renamed from: h  reason: collision with root package name */
        public String f37943h = ".tmp";

        /* renamed from: i  reason: collision with root package name */
        public boolean f37944i = false;
        public boolean j = false;

        public a a(int i2) {
            if (i2 > 0) {
                this.f37936a = i2;
            }
            return this;
        }

        public a a(@NonNull String str) {
            this.f37938c = str;
            return this;
        }

        public a a(boolean z) {
            this.m = z;
            return this;
        }

        public c a() {
            return new c(this.j, this.f37944i, this.f37937b, this.f37938c, this.f37939d, this.f37940e, this.f37941f, this.f37943h, this.f37942g, this.f37936a, this.k, this.l, this.m);
        }
    }

    public c(boolean z, boolean z2, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i2, String str8, byte[] bArr, boolean z3) {
        this.f37927a = i2;
        this.f37928b = str2;
        this.f37929c = str3;
        this.f37930d = str4;
        this.f37931e = str5;
        this.f37932f = str6;
        this.f37933g = str7;
        this.f37934h = str;
        this.f37935i = z;
        this.j = z2;
        this.k = str8;
        this.l = bArr;
        this.m = z3;
    }

    public int a() {
        return this.f37927a;
    }

    public String b() {
        return this.f37928b;
    }

    public String c() {
        return this.f37930d;
    }

    public String d() {
        return this.f37931e;
    }

    public String e() {
        return this.f37932f;
    }

    public String f() {
        return this.f37933g;
    }

    public boolean g() {
        return this.j;
    }
}

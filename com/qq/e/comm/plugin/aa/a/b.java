package com.qq.e.comm.plugin.aa.a;

import java.io.File;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private final String f11953a;

    /* renamed from: b  reason: collision with root package name */
    private final File f11954b;
    private final String c;
    private final boolean d;

    /* loaded from: classes4.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private String f11955a;

        /* renamed from: b  reason: collision with root package name */
        private File f11956b;
        private String c;
        private boolean d = true;

        public a a(File file) {
            this.f11956b = file;
            return this;
        }

        public a a(String str) {
            this.c = str;
            return this;
        }

        public a a(boolean z) {
            this.d = z;
            return this;
        }

        public b a() {
            return new b(this.f11956b, this.c, this.f11955a, this.d);
        }

        public a b(String str) {
            this.f11955a = str;
            return this;
        }
    }

    private b(File file, String str, String str2, boolean z) {
        this.f11954b = file;
        this.c = str;
        this.f11953a = str2;
        this.d = z;
    }

    public File a() {
        return this.f11954b;
    }

    public String b() {
        return this.c;
    }

    public String c() {
        return this.f11953a;
    }

    public boolean d() {
        return this.d;
    }
}

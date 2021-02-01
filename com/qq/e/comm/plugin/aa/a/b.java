package com.qq.e.comm.plugin.aa.a;

import java.io.File;
/* loaded from: classes15.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private final String f11655a;

    /* renamed from: b  reason: collision with root package name */
    private final File f11656b;
    private final String c;
    private final boolean d;

    /* loaded from: classes15.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private String f11657a;

        /* renamed from: b  reason: collision with root package name */
        private File f11658b;
        private String c;
        private boolean d = true;

        public a a(File file) {
            this.f11658b = file;
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
            return new b(this.f11658b, this.c, this.f11657a, this.d);
        }

        public a b(String str) {
            this.f11657a = str;
            return this;
        }
    }

    private b(File file, String str, String str2, boolean z) {
        this.f11656b = file;
        this.c = str;
        this.f11655a = str2;
        this.d = z;
    }

    public File a() {
        return this.f11656b;
    }

    public String b() {
        return this.c;
    }

    public String c() {
        return this.f11655a;
    }

    public boolean d() {
        return this.d;
    }
}

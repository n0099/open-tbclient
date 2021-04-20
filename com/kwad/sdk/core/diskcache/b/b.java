package com.kwad.sdk.core.diskcache.b;

import android.content.Context;
import java.io.File;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public Context f33797a;

    /* renamed from: b  reason: collision with root package name */
    public int f33798b;

    /* renamed from: c  reason: collision with root package name */
    public long f33799c;

    /* renamed from: d  reason: collision with root package name */
    public File f33800d;

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public Context f33801a;

        /* renamed from: b  reason: collision with root package name */
        public int f33802b = 1;

        /* renamed from: c  reason: collision with root package name */
        public long f33803c = 100;

        /* renamed from: d  reason: collision with root package name */
        public File f33804d;

        public a(Context context) {
            this.f33801a = context.getApplicationContext();
        }

        public a a(int i) {
            if (i > 0) {
                this.f33802b = i;
                return this;
            }
            throw new IllegalArgumentException("appVersion <= 0");
        }

        public a a(long j) {
            if (j > 0) {
                this.f33803c = j;
                return this;
            }
            throw new IllegalArgumentException("maxSize <= 0");
        }

        public a a(File file) {
            d.a(file, "directory is not allow null");
            this.f33804d = file;
            return this;
        }

        public b a() {
            b bVar = new b();
            bVar.f33797a = this.f33801a;
            bVar.f33798b = this.f33802b;
            bVar.f33799c = this.f33803c;
            bVar.f33800d = this.f33804d;
            return bVar;
        }
    }

    public b() {
    }
}

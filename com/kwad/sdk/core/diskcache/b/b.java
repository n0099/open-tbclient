package com.kwad.sdk.core.diskcache.b;

import android.content.Context;
import java.io.File;
/* loaded from: classes7.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public Context f34228a;

    /* renamed from: b  reason: collision with root package name */
    public int f34229b;

    /* renamed from: c  reason: collision with root package name */
    public long f34230c;

    /* renamed from: d  reason: collision with root package name */
    public File f34231d;

    /* loaded from: classes7.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public Context f34232a;

        /* renamed from: b  reason: collision with root package name */
        public int f34233b = 1;

        /* renamed from: c  reason: collision with root package name */
        public long f34234c = 100;

        /* renamed from: d  reason: collision with root package name */
        public File f34235d;

        public a(Context context) {
            this.f34232a = context.getApplicationContext();
        }

        public a a(int i2) {
            if (i2 > 0) {
                this.f34233b = i2;
                return this;
            }
            throw new IllegalArgumentException("appVersion <= 0");
        }

        public a a(long j) {
            if (j > 0) {
                this.f34234c = j;
                return this;
            }
            throw new IllegalArgumentException("maxSize <= 0");
        }

        public a a(File file) {
            d.a(file, "directory is not allow null");
            this.f34235d = file;
            return this;
        }

        public b a() {
            b bVar = new b();
            bVar.f34228a = this.f34232a;
            bVar.f34229b = this.f34233b;
            bVar.f34230c = this.f34234c;
            bVar.f34231d = this.f34235d;
            return bVar;
        }
    }

    public b() {
    }
}

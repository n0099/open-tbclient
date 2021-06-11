package com.kwad.sdk.core.diskcache.b;

import android.content.Context;
import java.io.File;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public Context f34130a;

    /* renamed from: b  reason: collision with root package name */
    public int f34131b;

    /* renamed from: c  reason: collision with root package name */
    public long f34132c;

    /* renamed from: d  reason: collision with root package name */
    public File f34133d;

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public Context f34134a;

        /* renamed from: b  reason: collision with root package name */
        public int f34135b = 1;

        /* renamed from: c  reason: collision with root package name */
        public long f34136c = 100;

        /* renamed from: d  reason: collision with root package name */
        public File f34137d;

        public a(Context context) {
            this.f34134a = context.getApplicationContext();
        }

        public a a(int i2) {
            if (i2 > 0) {
                this.f34135b = i2;
                return this;
            }
            throw new IllegalArgumentException("appVersion <= 0");
        }

        public a a(long j) {
            if (j > 0) {
                this.f34136c = j;
                return this;
            }
            throw new IllegalArgumentException("maxSize <= 0");
        }

        public a a(File file) {
            d.a(file, "directory is not allow null");
            this.f34137d = file;
            return this;
        }

        public b a() {
            b bVar = new b();
            bVar.f34130a = this.f34134a;
            bVar.f34131b = this.f34135b;
            bVar.f34132c = this.f34136c;
            bVar.f34133d = this.f34137d;
            return bVar;
        }
    }

    public b() {
    }
}

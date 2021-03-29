package com.kwad.sdk.core.diskcache.b;

import android.content.Context;
import java.io.File;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public Context f33508a;

    /* renamed from: b  reason: collision with root package name */
    public int f33509b;

    /* renamed from: c  reason: collision with root package name */
    public long f33510c;

    /* renamed from: d  reason: collision with root package name */
    public File f33511d;

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public Context f33512a;

        /* renamed from: b  reason: collision with root package name */
        public int f33513b = 1;

        /* renamed from: c  reason: collision with root package name */
        public long f33514c = 100;

        /* renamed from: d  reason: collision with root package name */
        public File f33515d;

        public a(Context context) {
            this.f33512a = context.getApplicationContext();
        }

        public a a(int i) {
            if (i > 0) {
                this.f33513b = i;
                return this;
            }
            throw new IllegalArgumentException("appVersion <= 0");
        }

        public a a(long j) {
            if (j > 0) {
                this.f33514c = j;
                return this;
            }
            throw new IllegalArgumentException("maxSize <= 0");
        }

        public a a(File file) {
            d.a(file, "directory is not allow null");
            this.f33515d = file;
            return this;
        }

        public b a() {
            b bVar = new b();
            bVar.f33508a = this.f33512a;
            bVar.f33509b = this.f33513b;
            bVar.f33510c = this.f33514c;
            bVar.f33511d = this.f33515d;
            return bVar;
        }
    }

    public b() {
    }
}

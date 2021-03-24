package com.kwad.sdk.core.diskcache.b;

import android.content.Context;
import java.io.File;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public Context f33507a;

    /* renamed from: b  reason: collision with root package name */
    public int f33508b;

    /* renamed from: c  reason: collision with root package name */
    public long f33509c;

    /* renamed from: d  reason: collision with root package name */
    public File f33510d;

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public Context f33511a;

        /* renamed from: b  reason: collision with root package name */
        public int f33512b = 1;

        /* renamed from: c  reason: collision with root package name */
        public long f33513c = 100;

        /* renamed from: d  reason: collision with root package name */
        public File f33514d;

        public a(Context context) {
            this.f33511a = context.getApplicationContext();
        }

        public a a(int i) {
            if (i > 0) {
                this.f33512b = i;
                return this;
            }
            throw new IllegalArgumentException("appVersion <= 0");
        }

        public a a(long j) {
            if (j > 0) {
                this.f33513c = j;
                return this;
            }
            throw new IllegalArgumentException("maxSize <= 0");
        }

        public a a(File file) {
            d.a(file, "directory is not allow null");
            this.f33514d = file;
            return this;
        }

        public b a() {
            b bVar = new b();
            bVar.f33507a = this.f33511a;
            bVar.f33508b = this.f33512b;
            bVar.f33509c = this.f33513c;
            bVar.f33510d = this.f33514d;
            return bVar;
        }
    }

    public b() {
    }
}

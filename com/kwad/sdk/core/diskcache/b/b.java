package com.kwad.sdk.core.diskcache.b;

import android.content.Context;
import java.io.File;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public Context f33892a;

    /* renamed from: b  reason: collision with root package name */
    public int f33893b;

    /* renamed from: c  reason: collision with root package name */
    public long f33894c;

    /* renamed from: d  reason: collision with root package name */
    public File f33895d;

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public Context f33896a;

        /* renamed from: b  reason: collision with root package name */
        public int f33897b = 1;

        /* renamed from: c  reason: collision with root package name */
        public long f33898c = 100;

        /* renamed from: d  reason: collision with root package name */
        public File f33899d;

        public a(Context context) {
            this.f33896a = context.getApplicationContext();
        }

        public a a(int i) {
            if (i > 0) {
                this.f33897b = i;
                return this;
            }
            throw new IllegalArgumentException("appVersion <= 0");
        }

        public a a(long j) {
            if (j > 0) {
                this.f33898c = j;
                return this;
            }
            throw new IllegalArgumentException("maxSize <= 0");
        }

        public a a(File file) {
            d.a(file, "directory is not allow null");
            this.f33899d = file;
            return this;
        }

        public b a() {
            b bVar = new b();
            bVar.f33892a = this.f33896a;
            bVar.f33893b = this.f33897b;
            bVar.f33894c = this.f33898c;
            bVar.f33895d = this.f33899d;
            return bVar;
        }
    }

    public b() {
    }
}

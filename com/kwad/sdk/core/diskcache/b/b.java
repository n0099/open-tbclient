package com.kwad.sdk.core.diskcache.b;

import android.content.Context;
import java.io.File;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public Context f32092a;

    /* renamed from: b  reason: collision with root package name */
    public int f32093b;

    /* renamed from: c  reason: collision with root package name */
    public long f32094c;

    /* renamed from: d  reason: collision with root package name */
    public File f32095d;

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public Context f32096a;

        /* renamed from: b  reason: collision with root package name */
        public int f32097b = 1;

        /* renamed from: c  reason: collision with root package name */
        public long f32098c = 100;

        /* renamed from: d  reason: collision with root package name */
        public File f32099d;

        public a(Context context) {
            this.f32096a = context.getApplicationContext();
        }

        public a a(int i2) {
            if (i2 > 0) {
                this.f32097b = i2;
                return this;
            }
            throw new IllegalArgumentException("appVersion <= 0");
        }

        public a a(long j) {
            if (j > 0) {
                this.f32098c = j;
                return this;
            }
            throw new IllegalArgumentException("maxSize <= 0");
        }

        public a a(File file) {
            d.a(file, "directory is not allow null");
            this.f32099d = file;
            return this;
        }

        public b a() {
            b bVar = new b();
            bVar.f32092a = this.f32096a;
            bVar.f32093b = this.f32097b;
            bVar.f32094c = this.f32098c;
            bVar.f32095d = this.f32099d;
            return bVar;
        }
    }

    public b() {
    }
}

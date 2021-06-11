package com.kwad.sdk.glide.load.engine.a;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.util.Log;
import com.bumptech.glide.load.engine.cache.MemorySizeCalculator;
/* loaded from: classes7.dex */
public final class i {

    /* renamed from: a  reason: collision with root package name */
    public final int f36117a;

    /* renamed from: b  reason: collision with root package name */
    public final int f36118b;

    /* renamed from: c  reason: collision with root package name */
    public final Context f36119c;

    /* renamed from: d  reason: collision with root package name */
    public final int f36120d;

    /* loaded from: classes7.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public static final int f36121a;

        /* renamed from: b  reason: collision with root package name */
        public final Context f36122b;

        /* renamed from: c  reason: collision with root package name */
        public ActivityManager f36123c;

        /* renamed from: d  reason: collision with root package name */
        public c f36124d;

        /* renamed from: f  reason: collision with root package name */
        public float f36126f;

        /* renamed from: e  reason: collision with root package name */
        public float f36125e = 2.0f;

        /* renamed from: g  reason: collision with root package name */
        public float f36127g = 0.4f;

        /* renamed from: h  reason: collision with root package name */
        public float f36128h = 0.33f;

        /* renamed from: i  reason: collision with root package name */
        public int f36129i = 4194304;

        static {
            f36121a = Build.VERSION.SDK_INT < 26 ? 4 : 1;
        }

        public a(Context context) {
            this.f36126f = f36121a;
            this.f36122b = context;
            this.f36123c = (ActivityManager) context.getSystemService("activity");
            this.f36124d = new b(context.getResources().getDisplayMetrics());
            if (Build.VERSION.SDK_INT < 26 || !i.a(this.f36123c)) {
                return;
            }
            this.f36126f = 0.0f;
        }

        public i a() {
            return new i(this);
        }
    }

    /* loaded from: classes7.dex */
    public static final class b implements c {

        /* renamed from: a  reason: collision with root package name */
        public final DisplayMetrics f36130a;

        public b(DisplayMetrics displayMetrics) {
            this.f36130a = displayMetrics;
        }

        @Override // com.kwad.sdk.glide.load.engine.a.i.c
        public int a() {
            return this.f36130a.widthPixels;
        }

        @Override // com.kwad.sdk.glide.load.engine.a.i.c
        public int b() {
            return this.f36130a.heightPixels;
        }
    }

    /* loaded from: classes7.dex */
    public interface c {
        int a();

        int b();
    }

    public i(a aVar) {
        this.f36119c = aVar.f36122b;
        this.f36120d = a(aVar.f36123c) ? aVar.f36129i / 2 : aVar.f36129i;
        int a2 = a(aVar.f36123c, aVar.f36127g, aVar.f36128h);
        float a3 = aVar.f36124d.a() * aVar.f36124d.b() * 4;
        int round = Math.round(aVar.f36126f * a3);
        int round2 = Math.round(a3 * aVar.f36125e);
        int i2 = a2 - this.f36120d;
        int i3 = round2 + round;
        if (i3 <= i2) {
            this.f36118b = round2;
            this.f36117a = round;
        } else {
            float f2 = i2;
            float f3 = aVar.f36126f;
            float f4 = aVar.f36125e;
            float f5 = f2 / (f3 + f4);
            this.f36118b = Math.round(f4 * f5);
            this.f36117a = Math.round(f5 * aVar.f36126f);
        }
        if (Log.isLoggable(MemorySizeCalculator.TAG, 3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Calculation complete, Calculated memory cache size: ");
            sb.append(a(this.f36118b));
            sb.append(", pool size: ");
            sb.append(a(this.f36117a));
            sb.append(", byte array size: ");
            sb.append(a(this.f36120d));
            sb.append(", memory class limited? ");
            sb.append(i3 > a2);
            sb.append(", max size: ");
            sb.append(a(a2));
            sb.append(", memoryClass: ");
            sb.append(aVar.f36123c.getMemoryClass());
            sb.append(", isLowMemoryDevice: ");
            sb.append(a(aVar.f36123c));
            Log.d(MemorySizeCalculator.TAG, sb.toString());
        }
    }

    public static int a(ActivityManager activityManager, float f2, float f3) {
        boolean a2 = a(activityManager);
        float memoryClass = activityManager.getMemoryClass() * 1024 * 1024;
        if (a2) {
            f2 = f3;
        }
        return Math.round(memoryClass * f2);
    }

    private String a(int i2) {
        return Formatter.formatFileSize(this.f36119c, i2);
    }

    @TargetApi(19)
    public static boolean a(ActivityManager activityManager) {
        if (Build.VERSION.SDK_INT >= 19) {
            return activityManager.isLowRamDevice();
        }
        return true;
    }

    public int a() {
        return this.f36118b;
    }

    public int b() {
        return this.f36117a;
    }

    public int c() {
        return this.f36120d;
    }
}

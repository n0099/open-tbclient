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
    public final int f36215a;

    /* renamed from: b  reason: collision with root package name */
    public final int f36216b;

    /* renamed from: c  reason: collision with root package name */
    public final Context f36217c;

    /* renamed from: d  reason: collision with root package name */
    public final int f36218d;

    /* loaded from: classes7.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public static final int f36219a;

        /* renamed from: b  reason: collision with root package name */
        public final Context f36220b;

        /* renamed from: c  reason: collision with root package name */
        public ActivityManager f36221c;

        /* renamed from: d  reason: collision with root package name */
        public c f36222d;

        /* renamed from: f  reason: collision with root package name */
        public float f36224f;

        /* renamed from: e  reason: collision with root package name */
        public float f36223e = 2.0f;

        /* renamed from: g  reason: collision with root package name */
        public float f36225g = 0.4f;

        /* renamed from: h  reason: collision with root package name */
        public float f36226h = 0.33f;

        /* renamed from: i  reason: collision with root package name */
        public int f36227i = 4194304;

        static {
            f36219a = Build.VERSION.SDK_INT < 26 ? 4 : 1;
        }

        public a(Context context) {
            this.f36224f = f36219a;
            this.f36220b = context;
            this.f36221c = (ActivityManager) context.getSystemService("activity");
            this.f36222d = new b(context.getResources().getDisplayMetrics());
            if (Build.VERSION.SDK_INT < 26 || !i.a(this.f36221c)) {
                return;
            }
            this.f36224f = 0.0f;
        }

        public i a() {
            return new i(this);
        }
    }

    /* loaded from: classes7.dex */
    public static final class b implements c {

        /* renamed from: a  reason: collision with root package name */
        public final DisplayMetrics f36228a;

        public b(DisplayMetrics displayMetrics) {
            this.f36228a = displayMetrics;
        }

        @Override // com.kwad.sdk.glide.load.engine.a.i.c
        public int a() {
            return this.f36228a.widthPixels;
        }

        @Override // com.kwad.sdk.glide.load.engine.a.i.c
        public int b() {
            return this.f36228a.heightPixels;
        }
    }

    /* loaded from: classes7.dex */
    public interface c {
        int a();

        int b();
    }

    public i(a aVar) {
        this.f36217c = aVar.f36220b;
        this.f36218d = a(aVar.f36221c) ? aVar.f36227i / 2 : aVar.f36227i;
        int a2 = a(aVar.f36221c, aVar.f36225g, aVar.f36226h);
        float a3 = aVar.f36222d.a() * aVar.f36222d.b() * 4;
        int round = Math.round(aVar.f36224f * a3);
        int round2 = Math.round(a3 * aVar.f36223e);
        int i2 = a2 - this.f36218d;
        int i3 = round2 + round;
        if (i3 <= i2) {
            this.f36216b = round2;
            this.f36215a = round;
        } else {
            float f2 = i2;
            float f3 = aVar.f36224f;
            float f4 = aVar.f36223e;
            float f5 = f2 / (f3 + f4);
            this.f36216b = Math.round(f4 * f5);
            this.f36215a = Math.round(f5 * aVar.f36224f);
        }
        if (Log.isLoggable(MemorySizeCalculator.TAG, 3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Calculation complete, Calculated memory cache size: ");
            sb.append(a(this.f36216b));
            sb.append(", pool size: ");
            sb.append(a(this.f36215a));
            sb.append(", byte array size: ");
            sb.append(a(this.f36218d));
            sb.append(", memory class limited? ");
            sb.append(i3 > a2);
            sb.append(", max size: ");
            sb.append(a(a2));
            sb.append(", memoryClass: ");
            sb.append(aVar.f36221c.getMemoryClass());
            sb.append(", isLowMemoryDevice: ");
            sb.append(a(aVar.f36221c));
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
        return Formatter.formatFileSize(this.f36217c, i2);
    }

    @TargetApi(19)
    public static boolean a(ActivityManager activityManager) {
        if (Build.VERSION.SDK_INT >= 19) {
            return activityManager.isLowRamDevice();
        }
        return true;
    }

    public int a() {
        return this.f36216b;
    }

    public int b() {
        return this.f36215a;
    }

    public int c() {
        return this.f36218d;
    }
}

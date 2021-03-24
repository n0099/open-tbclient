package com.kwad.sdk.glide.load.engine.a;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.util.Log;
import com.bumptech.glide.load.engine.cache.MemorySizeCalculator;
/* loaded from: classes6.dex */
public final class i {

    /* renamed from: a  reason: collision with root package name */
    public final int f35432a;

    /* renamed from: b  reason: collision with root package name */
    public final int f35433b;

    /* renamed from: c  reason: collision with root package name */
    public final Context f35434c;

    /* renamed from: d  reason: collision with root package name */
    public final int f35435d;

    /* loaded from: classes6.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public static final int f35436a;

        /* renamed from: b  reason: collision with root package name */
        public final Context f35437b;

        /* renamed from: c  reason: collision with root package name */
        public ActivityManager f35438c;

        /* renamed from: d  reason: collision with root package name */
        public c f35439d;

        /* renamed from: f  reason: collision with root package name */
        public float f35441f;

        /* renamed from: e  reason: collision with root package name */
        public float f35440e = 2.0f;

        /* renamed from: g  reason: collision with root package name */
        public float f35442g = 0.4f;

        /* renamed from: h  reason: collision with root package name */
        public float f35443h = 0.33f;
        public int i = 4194304;

        static {
            f35436a = Build.VERSION.SDK_INT < 26 ? 4 : 1;
        }

        public a(Context context) {
            this.f35441f = f35436a;
            this.f35437b = context;
            this.f35438c = (ActivityManager) context.getSystemService("activity");
            this.f35439d = new b(context.getResources().getDisplayMetrics());
            if (Build.VERSION.SDK_INT < 26 || !i.a(this.f35438c)) {
                return;
            }
            this.f35441f = 0.0f;
        }

        public i a() {
            return new i(this);
        }
    }

    /* loaded from: classes6.dex */
    public static final class b implements c {

        /* renamed from: a  reason: collision with root package name */
        public final DisplayMetrics f35444a;

        public b(DisplayMetrics displayMetrics) {
            this.f35444a = displayMetrics;
        }

        @Override // com.kwad.sdk.glide.load.engine.a.i.c
        public int a() {
            return this.f35444a.widthPixels;
        }

        @Override // com.kwad.sdk.glide.load.engine.a.i.c
        public int b() {
            return this.f35444a.heightPixels;
        }
    }

    /* loaded from: classes6.dex */
    public interface c {
        int a();

        int b();
    }

    public i(a aVar) {
        this.f35434c = aVar.f35437b;
        this.f35435d = a(aVar.f35438c) ? aVar.i / 2 : aVar.i;
        int a2 = a(aVar.f35438c, aVar.f35442g, aVar.f35443h);
        float a3 = aVar.f35439d.a() * aVar.f35439d.b() * 4;
        int round = Math.round(aVar.f35441f * a3);
        int round2 = Math.round(a3 * aVar.f35440e);
        int i = a2 - this.f35435d;
        int i2 = round2 + round;
        if (i2 <= i) {
            this.f35433b = round2;
            this.f35432a = round;
        } else {
            float f2 = i;
            float f3 = aVar.f35441f;
            float f4 = aVar.f35440e;
            float f5 = f2 / (f3 + f4);
            this.f35433b = Math.round(f4 * f5);
            this.f35432a = Math.round(f5 * aVar.f35441f);
        }
        if (Log.isLoggable(MemorySizeCalculator.TAG, 3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Calculation complete, Calculated memory cache size: ");
            sb.append(a(this.f35433b));
            sb.append(", pool size: ");
            sb.append(a(this.f35432a));
            sb.append(", byte array size: ");
            sb.append(a(this.f35435d));
            sb.append(", memory class limited? ");
            sb.append(i2 > a2);
            sb.append(", max size: ");
            sb.append(a(a2));
            sb.append(", memoryClass: ");
            sb.append(aVar.f35438c.getMemoryClass());
            sb.append(", isLowMemoryDevice: ");
            sb.append(a(aVar.f35438c));
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

    private String a(int i) {
        return Formatter.formatFileSize(this.f35434c, i);
    }

    @TargetApi(19)
    public static boolean a(ActivityManager activityManager) {
        if (Build.VERSION.SDK_INT >= 19) {
            return activityManager.isLowRamDevice();
        }
        return true;
    }

    public int a() {
        return this.f35433b;
    }

    public int b() {
        return this.f35432a;
    }

    public int c() {
        return this.f35435d;
    }
}

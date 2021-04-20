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
    public final int f35722a;

    /* renamed from: b  reason: collision with root package name */
    public final int f35723b;

    /* renamed from: c  reason: collision with root package name */
    public final Context f35724c;

    /* renamed from: d  reason: collision with root package name */
    public final int f35725d;

    /* loaded from: classes6.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public static final int f35726a;

        /* renamed from: b  reason: collision with root package name */
        public final Context f35727b;

        /* renamed from: c  reason: collision with root package name */
        public ActivityManager f35728c;

        /* renamed from: d  reason: collision with root package name */
        public c f35729d;

        /* renamed from: f  reason: collision with root package name */
        public float f35731f;

        /* renamed from: e  reason: collision with root package name */
        public float f35730e = 2.0f;

        /* renamed from: g  reason: collision with root package name */
        public float f35732g = 0.4f;

        /* renamed from: h  reason: collision with root package name */
        public float f35733h = 0.33f;
        public int i = 4194304;

        static {
            f35726a = Build.VERSION.SDK_INT < 26 ? 4 : 1;
        }

        public a(Context context) {
            this.f35731f = f35726a;
            this.f35727b = context;
            this.f35728c = (ActivityManager) context.getSystemService("activity");
            this.f35729d = new b(context.getResources().getDisplayMetrics());
            if (Build.VERSION.SDK_INT < 26 || !i.a(this.f35728c)) {
                return;
            }
            this.f35731f = 0.0f;
        }

        public i a() {
            return new i(this);
        }
    }

    /* loaded from: classes6.dex */
    public static final class b implements c {

        /* renamed from: a  reason: collision with root package name */
        public final DisplayMetrics f35734a;

        public b(DisplayMetrics displayMetrics) {
            this.f35734a = displayMetrics;
        }

        @Override // com.kwad.sdk.glide.load.engine.a.i.c
        public int a() {
            return this.f35734a.widthPixels;
        }

        @Override // com.kwad.sdk.glide.load.engine.a.i.c
        public int b() {
            return this.f35734a.heightPixels;
        }
    }

    /* loaded from: classes6.dex */
    public interface c {
        int a();

        int b();
    }

    public i(a aVar) {
        this.f35724c = aVar.f35727b;
        this.f35725d = a(aVar.f35728c) ? aVar.i / 2 : aVar.i;
        int a2 = a(aVar.f35728c, aVar.f35732g, aVar.f35733h);
        float a3 = aVar.f35729d.a() * aVar.f35729d.b() * 4;
        int round = Math.round(aVar.f35731f * a3);
        int round2 = Math.round(a3 * aVar.f35730e);
        int i = a2 - this.f35725d;
        int i2 = round2 + round;
        if (i2 <= i) {
            this.f35723b = round2;
            this.f35722a = round;
        } else {
            float f2 = i;
            float f3 = aVar.f35731f;
            float f4 = aVar.f35730e;
            float f5 = f2 / (f3 + f4);
            this.f35723b = Math.round(f4 * f5);
            this.f35722a = Math.round(f5 * aVar.f35731f);
        }
        if (Log.isLoggable(MemorySizeCalculator.TAG, 3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Calculation complete, Calculated memory cache size: ");
            sb.append(a(this.f35723b));
            sb.append(", pool size: ");
            sb.append(a(this.f35722a));
            sb.append(", byte array size: ");
            sb.append(a(this.f35725d));
            sb.append(", memory class limited? ");
            sb.append(i2 > a2);
            sb.append(", max size: ");
            sb.append(a(a2));
            sb.append(", memoryClass: ");
            sb.append(aVar.f35728c.getMemoryClass());
            sb.append(", isLowMemoryDevice: ");
            sb.append(a(aVar.f35728c));
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
        return Formatter.formatFileSize(this.f35724c, i);
    }

    @TargetApi(19)
    public static boolean a(ActivityManager activityManager) {
        if (Build.VERSION.SDK_INT >= 19) {
            return activityManager.isLowRamDevice();
        }
        return true;
    }

    public int a() {
        return this.f35723b;
    }

    public int b() {
        return this.f35722a;
    }

    public int c() {
        return this.f35725d;
    }
}

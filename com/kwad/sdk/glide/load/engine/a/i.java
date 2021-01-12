package com.kwad.sdk.glide.load.engine.a;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.util.Log;
import com.meizu.cloud.pushsdk.constants.PushConstants;
/* loaded from: classes4.dex */
public final class i {

    /* renamed from: a  reason: collision with root package name */
    private final int f10167a;

    /* renamed from: b  reason: collision with root package name */
    private final int f10168b;
    private final Context c;
    private final int d;

    /* loaded from: classes4.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        static final int f10169a;

        /* renamed from: b  reason: collision with root package name */
        final Context f10170b;
        ActivityManager c;
        c d;
        float f;
        float e = 2.0f;
        float g = 0.4f;
        float h = 0.33f;
        int i = 4194304;

        static {
            f10169a = Build.VERSION.SDK_INT < 26 ? 4 : 1;
        }

        public a(Context context) {
            this.f = f10169a;
            this.f10170b = context;
            this.c = (ActivityManager) context.getSystemService(PushConstants.INTENT_ACTIVITY_NAME);
            this.d = new b(context.getResources().getDisplayMetrics());
            if (Build.VERSION.SDK_INT < 26 || !i.a(this.c)) {
                return;
            }
            this.f = 0.0f;
        }

        public i a() {
            return new i(this);
        }
    }

    /* loaded from: classes4.dex */
    private static final class b implements c {

        /* renamed from: a  reason: collision with root package name */
        private final DisplayMetrics f10171a;

        b(DisplayMetrics displayMetrics) {
            this.f10171a = displayMetrics;
        }

        @Override // com.kwad.sdk.glide.load.engine.a.i.c
        public int a() {
            return this.f10171a.widthPixels;
        }

        @Override // com.kwad.sdk.glide.load.engine.a.i.c
        public int b() {
            return this.f10171a.heightPixels;
        }
    }

    /* loaded from: classes4.dex */
    interface c {
        int a();

        int b();
    }

    i(a aVar) {
        this.c = aVar.f10170b;
        this.d = a(aVar.c) ? aVar.i / 2 : aVar.i;
        int a2 = a(aVar.c, aVar.g, aVar.h);
        int a3 = aVar.d.a() * aVar.d.b() * 4;
        int round = Math.round(a3 * aVar.f);
        int round2 = Math.round(a3 * aVar.e);
        int i = a2 - this.d;
        if (round2 + round <= i) {
            this.f10168b = round2;
            this.f10167a = round;
        } else {
            float f = i / (aVar.f + aVar.e);
            this.f10168b = Math.round(aVar.e * f);
            this.f10167a = Math.round(f * aVar.f);
        }
        if (Log.isLoggable("MemorySizeCalculator", 3)) {
            Log.d("MemorySizeCalculator", "Calculation complete, Calculated memory cache size: " + a(this.f10168b) + ", pool size: " + a(this.f10167a) + ", byte array size: " + a(this.d) + ", memory class limited? " + (round2 + round > a2) + ", max size: " + a(a2) + ", memoryClass: " + aVar.c.getMemoryClass() + ", isLowMemoryDevice: " + a(aVar.c));
        }
    }

    private static int a(ActivityManager activityManager, float f, float f2) {
        boolean a2 = a(activityManager);
        float memoryClass = activityManager.getMemoryClass() * 1024 * 1024;
        if (!a2) {
            f2 = f;
        }
        return Math.round(memoryClass * f2);
    }

    private String a(int i) {
        return Formatter.formatFileSize(this.c, i);
    }

    @TargetApi(19)
    static boolean a(ActivityManager activityManager) {
        if (Build.VERSION.SDK_INT >= 19) {
            return activityManager.isLowRamDevice();
        }
        return true;
    }

    public int a() {
        return this.f10168b;
    }

    public int b() {
        return this.f10167a;
    }

    public int c() {
        return this.d;
    }
}

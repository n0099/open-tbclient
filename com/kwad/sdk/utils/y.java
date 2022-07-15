package com.kwad.sdk.utils;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
/* loaded from: classes5.dex */
public final class y {

    /* loaded from: classes5.dex */
    public static class a {
        public int a;
        public int b;
        public int c;
        public int d;
        public int e;
        public int f;

        public a() {
            this.a = -1;
            this.b = -1;
            this.c = -1;
            this.d = -1;
            this.e = -1;
            this.f = -1;
        }

        public a(int i, int i2) {
            this.a = -1;
            this.b = -1;
            this.c = -1;
            this.d = -1;
            this.e = -1;
            this.f = -1;
            this.a = i;
            this.b = i2;
        }

        public final int a() {
            return this.a;
        }

        public final void a(float f, float f2) {
            this.c = (int) f;
            this.d = (int) f2;
        }

        public final void a(int i, int i2) {
            this.a = i;
            this.b = i2;
        }

        public final int b() {
            return this.b;
        }

        public final void b(float f, float f2) {
            this.e = (int) f;
            this.f = (int) f2;
        }

        public final int c() {
            return this.c;
        }

        public final int d() {
            return this.d;
        }

        public final int e() {
            return this.e;
        }

        public final int f() {
            return this.f;
        }

        public final String toString() {
            return "TouchCoords{mWidth=" + this.a + ", mHeight=" + this.b + ", mDownX=" + this.c + ", mDownY=" + this.d + ", mUpX=" + this.e + ", mUpY=" + this.f + '}';
        }
    }

    public static String a(int i) {
        return i >= 0 ? String.valueOf(i) : "-999";
    }

    public static String a(@Nullable Context context, String str) {
        return str.replace("__TS__", String.valueOf(ax.a(context)));
    }

    @WorkerThread
    public static String a(String str, a aVar) {
        return (TextUtils.isEmpty(str) || aVar == null) ? str : str.replace("__WIDTH__", a(aVar.a())).replace("__HEIGHT__", a(aVar.b())).replace("__DOWN_X__", a(aVar.c())).replace("__DOWN_Y__", a(aVar.d())).replace("__UP_X__", a(aVar.e())).replace("__UP_Y__", a(aVar.f()));
    }

    public static String b(Context context, String str) {
        return TextUtils.isEmpty(str) ? str : str.replace("__SCREEN_WIDTH__", String.valueOf(j.b(context))).replace("__SCREEN_HEIGHT__", String.valueOf(j.c(context))).replace("__DEVICE_WIDTH__", String.valueOf(j.e(context))).replace("__DEVICE_HEIGHT__", String.valueOf(j.f(context)));
    }
}

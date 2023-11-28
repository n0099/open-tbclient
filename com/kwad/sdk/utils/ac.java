package com.kwad.sdk.utils;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
/* loaded from: classes10.dex */
public final class ac {

    /* loaded from: classes10.dex */
    public static class a {
        public int aNG;
        public int aNH;
        public int aNI;
        public int aNJ;
        public int mHeight;
        public int mWidth;

        public a() {
            this.mWidth = -1;
            this.mHeight = -1;
            this.aNG = -1;
            this.aNH = -1;
            this.aNI = -1;
            this.aNJ = -1;
        }

        public final int Kt() {
            return this.aNG;
        }

        public final int Ku() {
            return this.aNH;
        }

        public final int Kv() {
            return this.aNI;
        }

        public final int Kw() {
            return this.aNJ;
        }

        public final int getHeight() {
            return this.mHeight;
        }

        public final int getWidth() {
            return this.mWidth;
        }

        public a(int i, int i2) {
            this.mWidth = -1;
            this.mHeight = -1;
            this.aNG = -1;
            this.aNH = -1;
            this.aNI = -1;
            this.aNJ = -1;
            this.mWidth = i;
            this.mHeight = i2;
        }

        public final void B(int i, int i2) {
            this.mWidth = i;
            this.mHeight = i2;
        }

        public final void f(float f, float f2) {
            this.aNG = (int) f;
            this.aNH = (int) f2;
        }

        public final void g(float f, float f2) {
            this.aNI = (int) f;
            this.aNJ = (int) f2;
        }

        public final String toString() {
            return "TouchCoords{mWidth=" + this.mWidth + ", mHeight=" + this.mHeight + ", mDownX=" + this.aNG + ", mDownY=" + this.aNH + ", mUpX=" + this.aNI + ", mUpY=" + this.aNJ + '}';
        }
    }

    @WorkerThread
    public static String a(String str, a aVar) {
        if (!TextUtils.isEmpty(str) && aVar != null) {
            return str.replace("__WIDTH__", dC(aVar.getWidth())).replace("__HEIGHT__", dC(aVar.getHeight())).replace("__DOWN_X__", dC(aVar.Kt())).replace("__DOWN_Y__", dC(aVar.Ku())).replace("__UP_X__", dC(aVar.Kv())).replace("__UP_Y__", dC(aVar.Kw()));
        }
        return str;
    }

    public static String am(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        return str.replace("__SCREEN_WIDTH__", String.valueOf(k.getScreenWidth(context))).replace("__SCREEN_HEIGHT__", String.valueOf(k.getScreenHeight(context))).replace("__DEVICE_WIDTH__", String.valueOf(k.bT(context))).replace("__DEVICE_HEIGHT__", String.valueOf(k.bU(context)));
    }

    public static String c(@Nullable Context context, String str, boolean z) {
        return str.replace("__TS__", String.valueOf(bk.v(context, z)));
    }

    public static String dC(int i) {
        if (i >= 0) {
            return String.valueOf(i);
        }
        return "-999";
    }
}

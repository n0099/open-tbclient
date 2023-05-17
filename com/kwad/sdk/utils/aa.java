package com.kwad.sdk.utils;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
/* loaded from: classes9.dex */
public final class aa {

    /* loaded from: classes9.dex */
    public static class a {
        public int anF;
        public int anG;
        public int anH;
        public int anI;
        public int mHeight;
        public int mWidth;

        public a() {
            this.mWidth = -1;
            this.mHeight = -1;
            this.anF = -1;
            this.anG = -1;
            this.anH = -1;
            this.anI = -1;
        }

        public a(int i, int i2) {
            this.mWidth = -1;
            this.mHeight = -1;
            this.anF = -1;
            this.anG = -1;
            this.anH = -1;
            this.anI = -1;
            this.mWidth = i;
            this.mHeight = i2;
        }

        public final void e(float f, float f2) {
            this.anF = (int) f;
            this.anG = (int) f2;
        }

        public final void f(float f, float f2) {
            this.anH = (int) f;
            this.anI = (int) f2;
        }

        public final int getHeight() {
            return this.mHeight;
        }

        public final int getWidth() {
            return this.mWidth;
        }

        public final void q(int i, int i2) {
            this.mWidth = i;
            this.mHeight = i2;
        }

        public final String toString() {
            return "TouchCoords{mWidth=" + this.mWidth + ", mHeight=" + this.mHeight + ", mDownX=" + this.anF + ", mDownY=" + this.anG + ", mUpX=" + this.anH + ", mUpY=" + this.anI + '}';
        }

        public final int zH() {
            return this.anF;
        }

        public final int zI() {
            return this.anG;
        }

        public final int zJ() {
            return this.anH;
        }

        public final int zK() {
            return this.anI;
        }
    }

    public static String R(@Nullable Context context, String str) {
        return str.replace("__TS__", String.valueOf(bb.dz(context)));
    }

    public static String S(Context context, String str) {
        return TextUtils.isEmpty(str) ? str : str.replace("__SCREEN_WIDTH__", String.valueOf(j.getScreenWidth(context))).replace("__SCREEN_HEIGHT__", String.valueOf(j.getScreenHeight(context))).replace("__DEVICE_WIDTH__", String.valueOf(j.cd(context))).replace("__DEVICE_HEIGHT__", String.valueOf(j.ce(context)));
    }

    @WorkerThread
    public static String a(String str, a aVar) {
        return (TextUtils.isEmpty(str) || aVar == null) ? str : str.replace("__WIDTH__", bC(aVar.getWidth())).replace("__HEIGHT__", bC(aVar.getHeight())).replace("__DOWN_X__", bC(aVar.zH())).replace("__DOWN_Y__", bC(aVar.zI())).replace("__UP_X__", bC(aVar.zJ())).replace("__UP_Y__", bC(aVar.zK()));
    }

    public static String bC(int i) {
        return i >= 0 ? String.valueOf(i) : "-999";
    }
}

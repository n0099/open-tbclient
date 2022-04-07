package com.kwad.sdk.utils;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.kwad.sdk.KsAdSDKImpl;
/* loaded from: classes5.dex */
public final class z {

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

        public int a() {
            return this.a;
        }

        public void a(float f, float f2) {
            this.c = (int) f;
            this.d = (int) f2;
        }

        public void a(int i, int i2) {
            this.a = i;
            this.b = i2;
        }

        public int b() {
            return this.b;
        }

        public void b(float f, float f2) {
            this.e = (int) f;
            this.f = (int) f2;
        }

        public int c() {
            return this.c;
        }

        public int d() {
            return this.d;
        }

        public int e() {
            return this.e;
        }

        public int f() {
            return this.f;
        }

        @NonNull
        public String toString() {
            return PreferencesUtil.LEFT_MOUNT + this.a + "," + this.b + "," + this.c + "," + this.d + "," + this.e + "," + this.f + PreferencesUtil.RIGHT_MOUNT;
        }
    }

    public static String a(int i) {
        return i > -1 ? String.valueOf(i) : "-999";
    }

    public static String a(String str) {
        return str.replace("__TS__", String.valueOf(System.currentTimeMillis()));
    }

    @WorkerThread
    public static String a(String str, a aVar) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String b = b(b(str, aVar));
        String v = av.v(KsAdSDKImpl.get().getContext());
        if (!TextUtils.isEmpty(v)) {
            b = b.replace("__MAC__", v).replace("__MAC2__", aa.a(v)).replace("__MAC3__", aa.a(v.replace(":", "")));
        }
        String d = av.d(KsAdSDKImpl.get().getContext());
        if (!TextUtils.isEmpty(d)) {
            b = b.replace("__IMEI__", d).replace("__IMEI2__", aa.a(d)).replace("__IMEI3__", aa.b(d));
        }
        String a2 = com.kwad.sdk.core.f.a.a();
        if (!TextUtils.isEmpty(a2)) {
            b = b.replace("__OAID__", a2).replace("__OAID2__", aa.a(a2));
        }
        String t = av.t(KsAdSDKImpl.get().getContext());
        if (!TextUtils.isEmpty(t)) {
            b = b.replace("__ANDROIDID2__", aa.a(t)).replace("__ANDROIDID3__", aa.b(t)).replace("__ANDROIDID__", t);
        }
        return a(b);
    }

    public static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        Context context = KsAdSDKImpl.get().getContext();
        return str.replace("__SCREEN_WIDTH__", String.valueOf(av.n(context))).replace("__SCREEN_HEIGHT__", String.valueOf(av.o(context))).replace("__DEVICE_WIDTH__", String.valueOf(av.p(context))).replace("__DEVICE_HEIGHT__", String.valueOf(av.q(context)));
    }

    @WorkerThread
    public static String b(String str, a aVar) {
        return (TextUtils.isEmpty(str) || aVar == null) ? str : str.replace("__WIDTH__", a(aVar.a())).replace("__HEIGHT__", a(aVar.b())).replace("__DOWN_X__", a(aVar.c())).replace("__DOWN_Y__", a(aVar.d())).replace("__UP_X__", a(aVar.e())).replace("__UP_Y__", a(aVar.f()));
    }
}

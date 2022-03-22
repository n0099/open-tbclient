package com.kwad.sdk.utils;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.kwad.sdk.KsAdSDKImpl;
/* loaded from: classes7.dex */
public final class z {

    /* loaded from: classes7.dex */
    public static class a {
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public int f41412b;

        /* renamed from: c  reason: collision with root package name */
        public int f41413c;

        /* renamed from: d  reason: collision with root package name */
        public int f41414d;

        /* renamed from: e  reason: collision with root package name */
        public int f41415e;

        /* renamed from: f  reason: collision with root package name */
        public int f41416f;

        public a() {
            this.a = -1;
            this.f41412b = -1;
            this.f41413c = -1;
            this.f41414d = -1;
            this.f41415e = -1;
            this.f41416f = -1;
        }

        public a(int i, int i2) {
            this.a = -1;
            this.f41412b = -1;
            this.f41413c = -1;
            this.f41414d = -1;
            this.f41415e = -1;
            this.f41416f = -1;
            this.a = i;
            this.f41412b = i2;
        }

        public int a() {
            return this.a;
        }

        public void a(float f2, float f3) {
            this.f41413c = (int) f2;
            this.f41414d = (int) f3;
        }

        public void a(int i, int i2) {
            this.a = i;
            this.f41412b = i2;
        }

        public int b() {
            return this.f41412b;
        }

        public void b(float f2, float f3) {
            this.f41415e = (int) f2;
            this.f41416f = (int) f3;
        }

        public int c() {
            return this.f41413c;
        }

        public int d() {
            return this.f41414d;
        }

        public int e() {
            return this.f41415e;
        }

        public int f() {
            return this.f41416f;
        }

        @NonNull
        public String toString() {
            return PreferencesUtil.LEFT_MOUNT + this.a + "," + this.f41412b + "," + this.f41413c + "," + this.f41414d + "," + this.f41415e + "," + this.f41416f + PreferencesUtil.RIGHT_MOUNT;
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
        String b2 = b(b(str, aVar));
        String v = av.v(KsAdSDKImpl.get().getContext());
        if (!TextUtils.isEmpty(v)) {
            b2 = b2.replace("__MAC__", v).replace("__MAC2__", aa.a(v)).replace("__MAC3__", aa.a(v.replace(":", "")));
        }
        String d2 = av.d(KsAdSDKImpl.get().getContext());
        if (!TextUtils.isEmpty(d2)) {
            b2 = b2.replace("__IMEI__", d2).replace("__IMEI2__", aa.a(d2)).replace("__IMEI3__", aa.b(d2));
        }
        String a2 = com.kwad.sdk.core.f.a.a();
        if (!TextUtils.isEmpty(a2)) {
            b2 = b2.replace("__OAID__", a2).replace("__OAID2__", aa.a(a2));
        }
        String t = av.t(KsAdSDKImpl.get().getContext());
        if (!TextUtils.isEmpty(t)) {
            b2 = b2.replace("__ANDROIDID2__", aa.a(t)).replace("__ANDROIDID3__", aa.b(t)).replace("__ANDROIDID__", t);
        }
        return a(b2);
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

package com.kwad.sdk.utils;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.kwad.sdk.KsAdSDKImpl;
/* loaded from: classes3.dex */
public final class z {

    /* loaded from: classes3.dex */
    public static class a {
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public int f57963b;

        /* renamed from: c  reason: collision with root package name */
        public int f57964c;

        /* renamed from: d  reason: collision with root package name */
        public int f57965d;

        /* renamed from: e  reason: collision with root package name */
        public int f57966e;

        /* renamed from: f  reason: collision with root package name */
        public int f57967f;

        public a() {
            this.a = -1;
            this.f57963b = -1;
            this.f57964c = -1;
            this.f57965d = -1;
            this.f57966e = -1;
            this.f57967f = -1;
        }

        public a(int i2, int i3) {
            this.a = -1;
            this.f57963b = -1;
            this.f57964c = -1;
            this.f57965d = -1;
            this.f57966e = -1;
            this.f57967f = -1;
            this.a = i2;
            this.f57963b = i3;
        }

        public int a() {
            return this.a;
        }

        public void a(float f2, float f3) {
            this.f57964c = (int) f2;
            this.f57965d = (int) f3;
        }

        public void a(int i2, int i3) {
            this.a = i2;
            this.f57963b = i3;
        }

        public int b() {
            return this.f57963b;
        }

        public void b(float f2, float f3) {
            this.f57966e = (int) f2;
            this.f57967f = (int) f3;
        }

        public int c() {
            return this.f57964c;
        }

        public int d() {
            return this.f57965d;
        }

        public int e() {
            return this.f57966e;
        }

        public int f() {
            return this.f57967f;
        }

        @NonNull
        public String toString() {
            return PreferencesUtil.LEFT_MOUNT + this.a + "," + this.f57963b + "," + this.f57964c + "," + this.f57965d + "," + this.f57966e + "," + this.f57967f + PreferencesUtil.RIGHT_MOUNT;
        }
    }

    public static String a(int i2) {
        return i2 > -1 ? String.valueOf(i2) : "-999";
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

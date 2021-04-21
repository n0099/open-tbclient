package com.kwad.sdk.utils;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.KsAdSDKImpl;
/* loaded from: classes6.dex */
public final class s {

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f37171a;

        /* renamed from: b  reason: collision with root package name */
        public int f37172b;

        /* renamed from: c  reason: collision with root package name */
        public int f37173c;

        /* renamed from: d  reason: collision with root package name */
        public int f37174d;

        /* renamed from: e  reason: collision with root package name */
        public int f37175e;

        /* renamed from: f  reason: collision with root package name */
        public int f37176f;

        public a() {
            this.f37171a = -1;
            this.f37172b = -1;
            this.f37173c = -1;
            this.f37174d = -1;
            this.f37175e = -1;
            this.f37176f = -1;
        }

        public a(int i, int i2) {
            this.f37171a = -1;
            this.f37172b = -1;
            this.f37173c = -1;
            this.f37174d = -1;
            this.f37175e = -1;
            this.f37176f = -1;
            this.f37171a = i;
            this.f37172b = i2;
        }

        public int a() {
            return this.f37171a;
        }

        public void a(float f2, float f3) {
            this.f37173c = (int) f2;
            this.f37174d = (int) f3;
        }

        public void a(int i, int i2) {
            this.f37171a = i;
            this.f37172b = i2;
        }

        public int b() {
            return this.f37172b;
        }

        public void b(float f2, float f3) {
            this.f37175e = (int) f2;
            this.f37176f = (int) f3;
        }

        public int c() {
            return this.f37173c;
        }

        public int d() {
            return this.f37174d;
        }

        public int e() {
            return this.f37175e;
        }

        public int f() {
            return this.f37176f;
        }

        @NonNull
        public String toString() {
            return "[" + this.f37171a + "," + this.f37172b + "," + this.f37173c + "," + this.f37174d + "," + this.f37175e + "," + this.f37176f + "]";
        }
    }

    public static String a(int i) {
        return i > -1 ? String.valueOf(i) : "-999";
    }

    @WorkerThread
    public static String a(String str, a aVar) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String b2 = b(str, aVar);
        String k = ah.k(KsAdSDKImpl.get().getContext());
        if (!TextUtils.isEmpty(k)) {
            b2 = b2.replace("__MAC__", k).replace("__MAC2__", t.a(k)).replace("__MAC3__", t.a(k.replace(":", "")));
        }
        String d2 = ah.d(KsAdSDKImpl.get().getContext());
        if (!TextUtils.isEmpty(d2)) {
            b2 = b2.replace("__IMEI__", d2).replace("__IMEI2__", t.a(d2)).replace("__IMEI3__", t.b(d2));
        }
        String a2 = com.kwad.sdk.core.f.a.a();
        if (!TextUtils.isEmpty(a2)) {
            b2 = b2.replace("__OAID__", a2).replace("__OAID2__", t.a(a2));
        }
        String i = ah.i(KsAdSDKImpl.get().getContext());
        if (!TextUtils.isEmpty(i)) {
            b2 = b2.replace("__ANDROIDID2__", t.a(i)).replace("__ANDROIDID3__", t.b(i)).replace("__ANDROIDID__", i);
        }
        return b2.replace("__TS__", String.valueOf(System.currentTimeMillis()));
    }

    @WorkerThread
    public static String b(String str, a aVar) {
        return (TextUtils.isEmpty(str) || aVar == null) ? str : str.replace("__WIDTH__", a(aVar.a())).replace("__HEIGHT__", a(aVar.b())).replace("__DOWN_X__", a(aVar.c())).replace("__DOWN_Y__", a(aVar.d())).replace("__UP_X__", a(aVar.e())).replace("__UP_Y__", a(aVar.f()));
    }
}

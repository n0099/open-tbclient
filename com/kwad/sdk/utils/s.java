package com.kwad.sdk.utils;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.KsAdSDKImpl;
/* loaded from: classes7.dex */
public final class s {

    /* loaded from: classes7.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f37544a;

        /* renamed from: b  reason: collision with root package name */
        public int f37545b;

        /* renamed from: c  reason: collision with root package name */
        public int f37546c;

        /* renamed from: d  reason: collision with root package name */
        public int f37547d;

        /* renamed from: e  reason: collision with root package name */
        public int f37548e;

        /* renamed from: f  reason: collision with root package name */
        public int f37549f;

        public a() {
            this.f37544a = -1;
            this.f37545b = -1;
            this.f37546c = -1;
            this.f37547d = -1;
            this.f37548e = -1;
            this.f37549f = -1;
        }

        public a(int i2, int i3) {
            this.f37544a = -1;
            this.f37545b = -1;
            this.f37546c = -1;
            this.f37547d = -1;
            this.f37548e = -1;
            this.f37549f = -1;
            this.f37544a = i2;
            this.f37545b = i3;
        }

        public int a() {
            return this.f37544a;
        }

        public void a(float f2, float f3) {
            this.f37546c = (int) f2;
            this.f37547d = (int) f3;
        }

        public void a(int i2, int i3) {
            this.f37544a = i2;
            this.f37545b = i3;
        }

        public int b() {
            return this.f37545b;
        }

        public void b(float f2, float f3) {
            this.f37548e = (int) f2;
            this.f37549f = (int) f3;
        }

        public int c() {
            return this.f37546c;
        }

        public int d() {
            return this.f37547d;
        }

        public int e() {
            return this.f37548e;
        }

        public int f() {
            return this.f37549f;
        }

        @NonNull
        public String toString() {
            return "[" + this.f37544a + "," + this.f37545b + "," + this.f37546c + "," + this.f37547d + "," + this.f37548e + "," + this.f37549f + "]";
        }
    }

    public static String a(int i2) {
        return i2 > -1 ? String.valueOf(i2) : "-999";
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
        String i2 = ah.i(KsAdSDKImpl.get().getContext());
        if (!TextUtils.isEmpty(i2)) {
            b2 = b2.replace("__ANDROIDID2__", t.a(i2)).replace("__ANDROIDID3__", t.b(i2)).replace("__ANDROIDID__", i2);
        }
        return b2.replace("__TS__", String.valueOf(System.currentTimeMillis()));
    }

    @WorkerThread
    public static String b(String str, a aVar) {
        return (TextUtils.isEmpty(str) || aVar == null) ? str : str.replace("__WIDTH__", a(aVar.a())).replace("__HEIGHT__", a(aVar.b())).replace("__DOWN_X__", a(aVar.c())).replace("__DOWN_Y__", a(aVar.d())).replace("__UP_X__", a(aVar.e())).replace("__UP_Y__", a(aVar.f()));
    }
}

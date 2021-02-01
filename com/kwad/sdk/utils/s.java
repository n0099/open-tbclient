package com.kwad.sdk.utils;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.KsAdSDKImpl;
/* loaded from: classes3.dex */
public final class s {

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private int f10832a;

        /* renamed from: b  reason: collision with root package name */
        private int f10833b;
        private int c;
        private int d;
        private int e;
        private int f;

        public a() {
            this.f10832a = -1;
            this.f10833b = -1;
            this.c = -1;
            this.d = -1;
            this.e = -1;
            this.f = -1;
        }

        public a(int i, int i2) {
            this.f10832a = -1;
            this.f10833b = -1;
            this.c = -1;
            this.d = -1;
            this.e = -1;
            this.f = -1;
            this.f10832a = i;
            this.f10833b = i2;
        }

        public int a() {
            return this.f10832a;
        }

        public void a(float f, float f2) {
            this.c = (int) f;
            this.d = (int) f2;
        }

        public void a(int i, int i2) {
            this.f10832a = i;
            this.f10833b = i2;
        }

        public int b() {
            return this.f10833b;
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
            return "[" + this.f10832a + "," + this.f10833b + "," + this.c + "," + this.d + "," + this.e + "," + this.f + "]";
        }
    }

    private static String a(int i) {
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
        String d = ah.d(KsAdSDKImpl.get().getContext());
        if (!TextUtils.isEmpty(d)) {
            b2 = b2.replace("__IMEI__", d).replace("__IMEI2__", t.a(d)).replace("__IMEI3__", t.b(d));
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

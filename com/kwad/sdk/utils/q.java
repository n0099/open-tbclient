package com.kwad.sdk.utils;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.KsAdSDKImpl;
/* loaded from: classes6.dex */
public final class q {

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f34904a;

        /* renamed from: b  reason: collision with root package name */
        public int f34905b;

        /* renamed from: c  reason: collision with root package name */
        public int f34906c;

        /* renamed from: d  reason: collision with root package name */
        public int f34907d;

        /* renamed from: e  reason: collision with root package name */
        public int f34908e;

        /* renamed from: f  reason: collision with root package name */
        public int f34909f;

        public a() {
            this.f34904a = -1;
            this.f34905b = -1;
            this.f34906c = -1;
            this.f34907d = -1;
            this.f34908e = -1;
            this.f34909f = -1;
        }

        public a(int i2, int i3) {
            this.f34904a = -1;
            this.f34905b = -1;
            this.f34906c = -1;
            this.f34907d = -1;
            this.f34908e = -1;
            this.f34909f = -1;
            this.f34904a = i2;
            this.f34905b = i3;
        }

        public int a() {
            return this.f34904a;
        }

        public void a(float f2, float f3) {
            this.f34906c = (int) f2;
            this.f34907d = (int) f3;
        }

        public void a(int i2, int i3) {
            this.f34904a = i2;
            this.f34905b = i3;
        }

        public int b() {
            return this.f34905b;
        }

        public void b(float f2, float f3) {
            this.f34908e = (int) f2;
            this.f34909f = (int) f3;
        }

        public int c() {
            return this.f34906c;
        }

        public int d() {
            return this.f34907d;
        }

        public int e() {
            return this.f34908e;
        }

        public int f() {
            return this.f34909f;
        }

        @NonNull
        public String toString() {
            return "[" + this.f34904a + "," + this.f34905b + "," + this.f34906c + "," + this.f34907d + "," + this.f34908e + "," + this.f34909f + "]";
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
        String m = ai.m(KsAdSDKImpl.get().getContext());
        if (!TextUtils.isEmpty(m)) {
            b2 = b2.replace("__MAC__", m).replace("__MAC2__", r.a(m)).replace("__MAC3__", r.a(m.replace(":", "")));
        }
        String d2 = ai.d(KsAdSDKImpl.get().getContext());
        if (!TextUtils.isEmpty(d2)) {
            b2 = b2.replace("__IMEI__", d2).replace("__IMEI2__", r.a(d2)).replace("__IMEI3__", r.b(d2));
        }
        String a2 = com.kwad.sdk.core.f.a.a();
        if (!TextUtils.isEmpty(a2)) {
            b2 = b2.replace("__OAID__", a2).replace("__OAID2__", r.a(a2));
        }
        String k = ai.k(KsAdSDKImpl.get().getContext());
        if (!TextUtils.isEmpty(k)) {
            b2 = b2.replace("__ANDROIDID2__", r.a(k)).replace("__ANDROIDID3__", r.b(k)).replace("__ANDROIDID__", k);
        }
        return b2.replace("__TS__", String.valueOf(System.currentTimeMillis()));
    }

    @WorkerThread
    public static String b(String str, a aVar) {
        return (TextUtils.isEmpty(str) || aVar == null) ? str : str.replace("__WIDTH__", a(aVar.a())).replace("__HEIGHT__", a(aVar.b())).replace("__DOWN_X__", a(aVar.c())).replace("__DOWN_Y__", a(aVar.d())).replace("__UP_X__", a(aVar.e())).replace("__UP_Y__", a(aVar.f()));
    }
}

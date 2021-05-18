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
        public int f34149a;

        /* renamed from: b  reason: collision with root package name */
        public int f34150b;

        /* renamed from: c  reason: collision with root package name */
        public int f34151c;

        /* renamed from: d  reason: collision with root package name */
        public int f34152d;

        /* renamed from: e  reason: collision with root package name */
        public int f34153e;

        /* renamed from: f  reason: collision with root package name */
        public int f34154f;

        public a() {
            this.f34149a = -1;
            this.f34150b = -1;
            this.f34151c = -1;
            this.f34152d = -1;
            this.f34153e = -1;
            this.f34154f = -1;
        }

        public a(int i2, int i3) {
            this.f34149a = -1;
            this.f34150b = -1;
            this.f34151c = -1;
            this.f34152d = -1;
            this.f34153e = -1;
            this.f34154f = -1;
            this.f34149a = i2;
            this.f34150b = i3;
        }

        public int a() {
            return this.f34149a;
        }

        public void a(float f2, float f3) {
            this.f34151c = (int) f2;
            this.f34152d = (int) f3;
        }

        public void a(int i2, int i3) {
            this.f34149a = i2;
            this.f34150b = i3;
        }

        public int b() {
            return this.f34150b;
        }

        public void b(float f2, float f3) {
            this.f34153e = (int) f2;
            this.f34154f = (int) f3;
        }

        public int c() {
            return this.f34151c;
        }

        public int d() {
            return this.f34152d;
        }

        public int e() {
            return this.f34153e;
        }

        public int f() {
            return this.f34154f;
        }

        @NonNull
        public String toString() {
            return "[" + this.f34149a + "," + this.f34150b + "," + this.f34151c + "," + this.f34152d + "," + this.f34153e + "," + this.f34154f + "]";
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

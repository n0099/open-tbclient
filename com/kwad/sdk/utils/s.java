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
        public int f37076a;

        /* renamed from: b  reason: collision with root package name */
        public int f37077b;

        /* renamed from: c  reason: collision with root package name */
        public int f37078c;

        /* renamed from: d  reason: collision with root package name */
        public int f37079d;

        /* renamed from: e  reason: collision with root package name */
        public int f37080e;

        /* renamed from: f  reason: collision with root package name */
        public int f37081f;

        public a() {
            this.f37076a = -1;
            this.f37077b = -1;
            this.f37078c = -1;
            this.f37079d = -1;
            this.f37080e = -1;
            this.f37081f = -1;
        }

        public a(int i, int i2) {
            this.f37076a = -1;
            this.f37077b = -1;
            this.f37078c = -1;
            this.f37079d = -1;
            this.f37080e = -1;
            this.f37081f = -1;
            this.f37076a = i;
            this.f37077b = i2;
        }

        public int a() {
            return this.f37076a;
        }

        public void a(float f2, float f3) {
            this.f37078c = (int) f2;
            this.f37079d = (int) f3;
        }

        public void a(int i, int i2) {
            this.f37076a = i;
            this.f37077b = i2;
        }

        public int b() {
            return this.f37077b;
        }

        public void b(float f2, float f3) {
            this.f37080e = (int) f2;
            this.f37081f = (int) f3;
        }

        public int c() {
            return this.f37078c;
        }

        public int d() {
            return this.f37079d;
        }

        public int e() {
            return this.f37080e;
        }

        public int f() {
            return this.f37081f;
        }

        @NonNull
        public String toString() {
            return "[" + this.f37076a + "," + this.f37077b + "," + this.f37078c + "," + this.f37079d + "," + this.f37080e + "," + this.f37081f + "]";
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

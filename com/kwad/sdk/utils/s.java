package com.kwad.sdk.utils;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.kwad.sdk.KsAdSDKImpl;
/* loaded from: classes7.dex */
public final class s {

    /* loaded from: classes7.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f37642a;

        /* renamed from: b  reason: collision with root package name */
        public int f37643b;

        /* renamed from: c  reason: collision with root package name */
        public int f37644c;

        /* renamed from: d  reason: collision with root package name */
        public int f37645d;

        /* renamed from: e  reason: collision with root package name */
        public int f37646e;

        /* renamed from: f  reason: collision with root package name */
        public int f37647f;

        public a() {
            this.f37642a = -1;
            this.f37643b = -1;
            this.f37644c = -1;
            this.f37645d = -1;
            this.f37646e = -1;
            this.f37647f = -1;
        }

        public a(int i2, int i3) {
            this.f37642a = -1;
            this.f37643b = -1;
            this.f37644c = -1;
            this.f37645d = -1;
            this.f37646e = -1;
            this.f37647f = -1;
            this.f37642a = i2;
            this.f37643b = i3;
        }

        public int a() {
            return this.f37642a;
        }

        public void a(float f2, float f3) {
            this.f37644c = (int) f2;
            this.f37645d = (int) f3;
        }

        public void a(int i2, int i3) {
            this.f37642a = i2;
            this.f37643b = i3;
        }

        public int b() {
            return this.f37643b;
        }

        public void b(float f2, float f3) {
            this.f37646e = (int) f2;
            this.f37647f = (int) f3;
        }

        public int c() {
            return this.f37644c;
        }

        public int d() {
            return this.f37645d;
        }

        public int e() {
            return this.f37646e;
        }

        public int f() {
            return this.f37647f;
        }

        @NonNull
        public String toString() {
            return PreferencesUtil.LEFT_MOUNT + this.f37642a + "," + this.f37643b + "," + this.f37644c + "," + this.f37645d + "," + this.f37646e + "," + this.f37647f + PreferencesUtil.RIGHT_MOUNT;
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

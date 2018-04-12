package com.meizu.cloud.pushsdk.networking.common;

import com.meizu.cloud.pushsdk.networking.b.k;
import com.meizu.cloud.pushsdk.networking.error.ANError;
/* loaded from: classes3.dex */
public class c<T> {
    private final T a;
    private final ANError b;
    private k c;

    public static <T> c<T> a(T t) {
        return new c<>(t);
    }

    public static <T> c<T> a(ANError aNError) {
        return new c<>(aNError);
    }

    public c(T t) {
        this.a = t;
        this.b = null;
    }

    public c(ANError aNError) {
        this.a = null;
        this.b = aNError;
    }

    public T a() {
        return this.a;
    }

    public boolean b() {
        return this.b == null;
    }

    public ANError c() {
        return this.b;
    }

    public void a(k kVar) {
        this.c = kVar;
    }

    public k d() {
        return this.c;
    }
}

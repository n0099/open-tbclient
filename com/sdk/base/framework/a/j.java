package com.sdk.base.framework.a;

import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpTrace;
/* JADX WARN: $VALUES field not found */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes6.dex */
public final class j {

    /* renamed from: a  reason: collision with root package name */
    public static final j f38480a = new j("GET", 0, "GET");

    /* renamed from: b  reason: collision with root package name */
    public static final j f38481b = new j("POST", 1, "POST");

    /* renamed from: c  reason: collision with root package name */
    public static j f38482c = new j(HttpPut.METHOD_NAME, 2, HttpPut.METHOD_NAME);

    /* renamed from: d  reason: collision with root package name */
    public static j f38483d = new j("HEAD", 3, "HEAD");

    /* renamed from: e  reason: collision with root package name */
    public static j f38484e = new j("MOVE", 4, "MOVE");

    /* renamed from: f  reason: collision with root package name */
    public static j f38485f = new j("COPY", 5, "COPY");

    /* renamed from: g  reason: collision with root package name */
    public static j f38486g = new j(HttpDelete.METHOD_NAME, 6, HttpDelete.METHOD_NAME);

    /* renamed from: h  reason: collision with root package name */
    public static j f38487h = new j(HttpOptions.METHOD_NAME, 7, HttpOptions.METHOD_NAME);
    public static j i = new j(HttpTrace.METHOD_NAME, 8, HttpTrace.METHOD_NAME);
    public static j j = new j("CONNECT", 9, "CONNECT");
    public final String k;

    public j(String str, int i2, String str2) {
        this.k = str2;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.k;
    }
}

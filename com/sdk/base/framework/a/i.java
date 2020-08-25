package com.sdk.base.framework.a;

import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpTrace;
/* JADX WARN: $VALUES field not found */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes5.dex */
public final class i {
    public static final i a = new i("GET", 0, "GET");
    public static final i b = new i("POST", 1, "POST");
    private static i c = new i(HttpPut.METHOD_NAME, 2, HttpPut.METHOD_NAME);
    private static i d = new i(HttpHead.METHOD_NAME, 3, HttpHead.METHOD_NAME);
    private static i e = new i("MOVE", 4, "MOVE");
    private static i f = new i("COPY", 5, "COPY");
    private static i g = new i(HttpDelete.METHOD_NAME, 6, HttpDelete.METHOD_NAME);
    private static i h = new i(HttpOptions.METHOD_NAME, 7, HttpOptions.METHOD_NAME);
    private static i i = new i(HttpTrace.METHOD_NAME, 8, HttpTrace.METHOD_NAME);
    private static i j = new i("CONNECT", 9, "CONNECT");
    private final String k;

    static {
        i[] iVarArr = {a, b, c, d, e, f, g, h, i, j};
    }

    private i(String str, int i2, String str2) {
        this.k = str2;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.k;
    }
}

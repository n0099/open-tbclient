package com.meizu.cloud.pushsdk.networking.b;

import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpPut;
/* loaded from: classes3.dex */
public class d {
    public static boolean a(String str) {
        return str.equals("POST") || str.equals(HttpPut.METHOD_NAME) || str.equals("PATCH") || str.equals("PROPPATCH") || str.equals("REPORT");
    }

    public static boolean b(String str) {
        return a(str) || str.equals(HttpOptions.METHOD_NAME) || str.equals(HttpDelete.METHOD_NAME) || str.equals("PROPFIND") || str.equals("MKCOL") || str.equals("LOCK");
    }
}

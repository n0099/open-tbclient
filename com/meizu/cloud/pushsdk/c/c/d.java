package com.meizu.cloud.pushsdk.c.c;

import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpPut;
/* loaded from: classes10.dex */
public class d {
    public static boolean a(String str) {
        return "POST".equals(str) || HttpPut.METHOD_NAME.equals(str) || "PATCH".equals(str) || "PROPPATCH".equals(str) || "REPORT".equals(str);
    }

    public static boolean b(String str) {
        return a(str) || HttpOptions.METHOD_NAME.equals(str) || HttpDelete.METHOD_NAME.equals(str) || "PROPFIND".equals(str) || "MKCOL".equals(str) || "LOCK".equals(str);
    }
}

package okhttp3.internal.http;

import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpPut;
/* loaded from: classes9.dex */
public final class HttpMethod {
    public static boolean invalidatesCache(String str) {
        if (!str.equals("POST") && !str.equals("PATCH") && !str.equals(HttpPut.METHOD_NAME) && !str.equals(HttpDelete.METHOD_NAME) && !str.equals("MOVE")) {
            return false;
        }
        return true;
    }

    public static boolean permitsRequestBody(String str) {
        if (!str.equals("GET") && !str.equals("HEAD")) {
            return true;
        }
        return false;
    }

    public static boolean redirectsToGet(String str) {
        return !str.equals("PROPFIND");
    }

    public static boolean redirectsWithBody(String str) {
        return str.equals("PROPFIND");
    }

    public static boolean requiresRequestBody(String str) {
        if (!str.equals("POST") && !str.equals(HttpPut.METHOD_NAME) && !str.equals("PATCH") && !str.equals("PROPPATCH") && !str.equals("REPORT")) {
            return false;
        }
        return true;
    }
}

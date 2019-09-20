package com.tencent.mm.opensdk.diffdev.a;

import com.tencent.mm.opensdk.utils.Log;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.util.EntityUtils;
/* loaded from: classes2.dex */
public final class e {
    public static byte[] a(String str) {
        byte[] bArr = null;
        if (str == null || str.length() == 0) {
            Log.e("MicroMsg.SDK.NetUtil", "httpGet, url is null");
        } else {
            DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
            HttpGet httpGet = new HttpGet(str);
            try {
                HttpConnectionParams.setSoTimeout(defaultHttpClient.getParams(), 60000);
                HttpResponse execute = defaultHttpClient.execute(httpGet);
                if (execute.getStatusLine().getStatusCode() != 200) {
                    Log.e("MicroMsg.SDK.NetUtil", "httpGet fail, status code = " + execute.getStatusLine().getStatusCode());
                } else {
                    bArr = EntityUtils.toByteArray(execute.getEntity());
                }
            } catch (Exception e) {
                Log.e("MicroMsg.SDK.NetUtil", "httpGet, Exception ex = " + e.getMessage());
            } catch (IncompatibleClassChangeError e2) {
                Log.e("MicroMsg.SDK.NetUtil", "httpGet, IncompatibleClassChangeError ex = " + e2.getMessage());
            } catch (Throwable th) {
                Log.e("MicroMsg.SDK.NetUtil", "httpGet, Throwable ex = " + th.getMessage());
            }
        }
        return bArr;
    }
}

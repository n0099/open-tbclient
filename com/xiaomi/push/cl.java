package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.miui.pushads.sdk.k;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.LinkedList;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
/* loaded from: classes3.dex */
class cl {
    public static int a(String str, String str2, ch chVar) {
        HttpPost httpPost;
        LinkedList linkedList = new LinkedList();
        linkedList.add(new BasicNameValuePair("logValue", chVar.f182a));
        linkedList.add(new BasicNameValuePair("appId", str));
        linkedList.add(new BasicNameValuePair("showType", chVar.a + ""));
        linkedList.add(new BasicNameValuePair("s", cm.a(linkedList, str2)));
        try {
            httpPost = new HttpPost("http://new.api.ad.xiaomi.com/logNotificationAdActions");
            httpPost.setEntity(new UrlEncodedFormEntity(linkedList, HTTP.UTF_8));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e2) {
            e2.printStackTrace();
        } catch (IOException e3) {
            e3.printStackTrace();
        }
        return 200 == new DefaultHttpClient().execute(httpPost).getStatusLine().getStatusCode() ? 0 : 1;
    }

    public static boolean a(Context context) {
        return k.a.NONE != com.xiaomi.miui.pushads.sdk.f.a(context);
    }
}

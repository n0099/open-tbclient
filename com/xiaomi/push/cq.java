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
/* loaded from: classes9.dex */
class cq {
    public static int a(String str, String str2, cm cmVar) {
        HttpPost httpPost;
        LinkedList linkedList = new LinkedList();
        linkedList.add(new BasicNameValuePair("logValue", cmVar.f173a));
        linkedList.add(new BasicNameValuePair("appId", str));
        linkedList.add(new BasicNameValuePair("showType", cmVar.a + ""));
        linkedList.add(new BasicNameValuePair("s", cr.a(linkedList, str2)));
        try {
            httpPost = new HttpPost("http://new.api.ad.xiaomi.com/logNotificationAdActions");
            httpPost.setEntity(new UrlEncodedFormEntity(linkedList, "UTF-8"));
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
        return k.a.a != com.xiaomi.miui.pushads.sdk.f.a(context);
    }
}

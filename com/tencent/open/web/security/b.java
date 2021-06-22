package com.tencent.open.web.security;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.WebView;
import com.tencent.open.a;
import com.tencent.open.a.f;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes7.dex */
public class b extends com.tencent.open.a {
    @Override // com.tencent.open.a
    public void a(String str, String str2, List<String> list, a.C0519a c0519a) {
        f.a("openSDK_LOG.SecureJsBridge", "-->getResult, objectName: " + str + " | methodName: " + str2);
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                list.set(i2, URLDecoder.decode(list.get(i2), "UTF-8"));
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
        }
        a.b bVar = this.f40118a.get(str);
        if (bVar != null) {
            f.b("openSDK_LOG.SecureJsBridge", "-->handler != null");
            bVar.call(str2, list, c0519a);
            return;
        }
        f.b("openSDK_LOG.SecureJsBridge", "-->handler == null");
        if (c0519a != null) {
            c0519a.a();
        }
    }

    @Override // com.tencent.open.a
    public boolean a(WebView webView, String str) {
        f.a("openSDK_LOG.SecureJsBridge", "-->canHandleUrl---url = " + str);
        if (str != null && Uri.parse(str).getScheme().equals("jsbridge")) {
            ArrayList arrayList = new ArrayList(Arrays.asList((str + "/#").split("/")));
            if (arrayList.size() < 7) {
                return false;
            }
            String str2 = (String) arrayList.get(2);
            String str3 = (String) arrayList.get(3);
            String str4 = (String) arrayList.get(4);
            String str5 = (String) arrayList.get(5);
            f.a("openSDK_LOG.SecureJsBridge", "-->canHandleUrl, objectName: " + str2 + " | methodName: " + str3 + " | snStr: " + str4);
            if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4)) {
                try {
                    a(str2, str3, arrayList.subList(6, arrayList.size() - 1), new c(webView, Long.parseLong(str4), str, str5));
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }
        return false;
    }
}

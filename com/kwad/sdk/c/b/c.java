package com.kwad.sdk.c.b;

import com.alibaba.fastjson.support.spring.FastJsonJsonView;
import com.baidu.sapi2.SapiWebView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class c {
    public static List<String> a;

    static {
        ArrayList arrayList = new ArrayList(2);
        a = arrayList;
        arrayList.add("application/x-javascript");
        a.add("image/jpeg");
        a.add("image/tiff");
        a.add("text/css");
        a.add(SapiWebView.DATA_MIME_TYPE);
        a.add("image/gif");
        a.add("image/png");
        a.add(FastJsonJsonView.DEFAULT_JSONP_CONTENT_TYPE);
    }

    public static boolean a(String str) {
        return a.contains(str);
    }
}

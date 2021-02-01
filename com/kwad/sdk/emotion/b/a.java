package com.kwad.sdk.emotion.b;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.kwad.sdk.emotion.model.CDNUrl;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public final class a {
    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (URLUtil.isNetworkUrl(str)) {
            return true;
        }
        File file = new File(str);
        if (file.exists() && file.isFile()) {
            return true;
        }
        return TextUtils.equals("content", Uri.parse(str).getScheme()) && TextUtils.equals("media", Uri.parse(str).getHost());
    }

    public static String[] a(List<CDNUrl> list, String str) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (CDNUrl cDNUrl : list) {
                if (a(cDNUrl.getUrl()) && !arrayList.contains(cDNUrl.getUrl())) {
                    arrayList.add(cDNUrl.getUrl());
                }
            }
        }
        if (a(str) && !arrayList.contains(str)) {
            arrayList.add(str);
        }
        return (String[]) arrayList.toArray(new String[0]);
    }
}

package com.xiaomi.network;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.tbadk.core.atomData.CreateGroupStepActivityConfig;
import com.xiaomi.channel.commonutils.network.d;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public abstract class HttpUtils {

    /* loaded from: classes2.dex */
    public static class DefaultHttpGetProcessor extends HttpProcessor {
        public DefaultHttpGetProcessor() {
            super(1);
        }

        @Override // com.xiaomi.network.HttpProcessor
        public String b(Context context, String str, List<com.xiaomi.channel.commonutils.network.c> list) {
            if (list == null) {
                return d.a(context, new URL(str));
            }
            Uri.Builder buildUpon = Uri.parse(str).buildUpon();
            for (com.xiaomi.channel.commonutils.network.c cVar : list) {
                buildUpon.appendQueryParameter(cVar.a(), cVar.b());
            }
            return d.a(context, new URL(buildUpon.toString()));
        }
    }

    static int a(int i, int i2) {
        return (((i2 + 243) / 1448) * 132) + 1080 + i + i2;
    }

    static int a(int i, int i2, int i3) {
        return (((i2 + 200) / 1448) * 132) + CreateGroupStepActivityConfig.SOURCE_FROM_NEAR + i2 + i + i3;
    }

    private static int a(HttpProcessor httpProcessor, String str, List<com.xiaomi.channel.commonutils.network.c> list, String str2) {
        if (httpProcessor.a() == 1) {
            return a(str.length(), a(str2));
        }
        if (httpProcessor.a() == 2) {
            return a(str.length(), a(list), a(str2));
        }
        return -1;
    }

    static int a(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            return str.getBytes("UTF-8").length;
        } catch (UnsupportedEncodingException e) {
            return 0;
        }
    }

    static int a(List<com.xiaomi.channel.commonutils.network.c> list) {
        int i = 0;
        Iterator<com.xiaomi.channel.commonutils.network.c> it = list.iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return i2 * 2;
            }
            com.xiaomi.channel.commonutils.network.c next = it.next();
            if (!TextUtils.isEmpty(next.a())) {
                i2 += next.a().length();
            }
            i = !TextUtils.isEmpty(next.b()) ? next.b().length() + i2 : i2;
        }
    }

    public static String a(Context context, String str, List<com.xiaomi.channel.commonutils.network.c> list) {
        return a(context, str, list, new DefaultHttpGetProcessor(), true);
    }

    public static String a(Context context, String str, List<com.xiaomi.channel.commonutils.network.c> list, HttpProcessor httpProcessor, boolean z) {
        if (d.d(context)) {
            try {
                ArrayList<String> arrayList = new ArrayList<>();
                Fallback fallback = null;
                if (z && (fallback = HostManager.getInstance().getFallbacksByURL(str)) != null) {
                    arrayList = fallback.a(str);
                }
                if (!arrayList.contains(str)) {
                    arrayList.add(str);
                }
                String str2 = null;
                Iterator<String> it = arrayList.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    ArrayList arrayList2 = list != null ? new ArrayList(list) : null;
                    long currentTimeMillis = System.currentTimeMillis();
                    try {
                    } catch (IOException e) {
                        if (fallback != null) {
                            fallback.a(next, System.currentTimeMillis() - currentTimeMillis, a(httpProcessor, next, arrayList2, str2), e);
                        }
                        e.printStackTrace();
                    }
                    if (!httpProcessor.a(context, next, arrayList2)) {
                        return str2;
                    }
                    str2 = httpProcessor.b(context, next, arrayList2);
                    if (!TextUtils.isEmpty(str2)) {
                        if (fallback != null) {
                            fallback.a(next, System.currentTimeMillis() - currentTimeMillis, a(httpProcessor, next, arrayList2, str2));
                            return str2;
                        }
                        return str2;
                    }
                    if (fallback != null) {
                        fallback.a(next, System.currentTimeMillis() - currentTimeMillis, a(httpProcessor, next, arrayList2, str2), null);
                    }
                    str2 = str2;
                }
                return str2;
            } catch (MalformedURLException e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }
}

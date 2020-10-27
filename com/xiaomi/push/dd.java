package com.xiaomi.push;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.android.imsdk.upload.action.pb.IMPushPb;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes12.dex */
public abstract class dd {

    /* loaded from: classes12.dex */
    public static class a extends dc {
        public a() {
            super(1);
        }

        @Override // com.xiaomi.push.dc
        public String a(Context context, String str, List<ay> list) {
            if (list == null) {
                return az.a(context, new URL(str));
            }
            Uri.Builder buildUpon = Uri.parse(str).buildUpon();
            for (ay ayVar : list) {
                buildUpon.appendQueryParameter(ayVar.a(), ayVar.b());
            }
            return az.a(context, new URL(buildUpon.toString()));
        }
    }

    static int a(int i, int i2) {
        return (((i2 + 243) / 1448) * IMPushPb.PushImClient.ACTIONS_FIELD_NUMBER) + 1080 + i + i2;
    }

    static int a(int i, int i2, int i3) {
        return (((i2 + 200) / 1448) * IMPushPb.PushImClient.ACTIONS_FIELD_NUMBER) + 1011 + i2 + i + i3;
    }

    private static int a(dc dcVar, String str, List<ay> list, String str2) {
        if (dcVar.a() == 1) {
            return a(str.length(), a(str2));
        }
        if (dcVar.a() == 2) {
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

    static int a(List<ay> list) {
        int i = 0;
        Iterator<ay> it = list.iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return i2 * 2;
            }
            ay next = it.next();
            if (!TextUtils.isEmpty(next.a())) {
                i2 += next.a().length();
            }
            i = !TextUtils.isEmpty(next.b()) ? next.b().length() + i2 : i2;
        }
    }

    public static String a(Context context, String str, List<ay> list) {
        return a(context, str, list, new a(), true);
    }

    public static String a(Context context, String str, List<ay> list, dc dcVar, boolean z) {
        if (az.b(context)) {
            try {
                ArrayList<String> arrayList = new ArrayList<>();
                cv cvVar = null;
                if (z && (cvVar = cz.a().m216a(str)) != null) {
                    arrayList = cvVar.a(str);
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
                        if (cvVar != null) {
                            cvVar.a(next, System.currentTimeMillis() - currentTimeMillis, a(dcVar, next, arrayList2, str2), e);
                        }
                        e.printStackTrace();
                    }
                    if (!dcVar.m225a(context, next, (List<ay>) arrayList2)) {
                        return str2;
                    }
                    str2 = dcVar.a(context, next, (List<ay>) arrayList2);
                    if (!TextUtils.isEmpty(str2)) {
                        if (cvVar != null) {
                            cvVar.a(next, System.currentTimeMillis() - currentTimeMillis, a(dcVar, next, arrayList2, str2));
                            return str2;
                        }
                        return str2;
                    }
                    if (cvVar != null) {
                        cvVar.a(next, System.currentTimeMillis() - currentTimeMillis, a(dcVar, next, arrayList2, str2), null);
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

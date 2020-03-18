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
/* loaded from: classes8.dex */
public abstract class cy {

    /* loaded from: classes8.dex */
    public static class a extends cx {
        public a() {
            super(1);
        }

        @Override // com.xiaomi.push.cx
        public String a(Context context, String str, List<ar> list) {
            if (list == null) {
                return as.a(context, new URL(str));
            }
            Uri.Builder buildUpon = Uri.parse(str).buildUpon();
            for (ar arVar : list) {
                buildUpon.appendQueryParameter(arVar.a(), arVar.b());
            }
            return as.a(context, new URL(buildUpon.toString()));
        }
    }

    static int a(int i, int i2) {
        return (((i2 + 243) / 1448) * IMPushPb.PushImClient.ACTIONS_FIELD_NUMBER) + 1080 + i + i2;
    }

    static int a(int i, int i2, int i3) {
        return (((i2 + 200) / 1448) * IMPushPb.PushImClient.ACTIONS_FIELD_NUMBER) + 1011 + i2 + i + i3;
    }

    private static int a(cx cxVar, String str, List<ar> list, String str2) {
        if (cxVar.a() == 1) {
            return a(str.length(), a(str2));
        }
        if (cxVar.a() == 2) {
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

    static int a(List<ar> list) {
        int i = 0;
        Iterator<ar> it = list.iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return i2 * 2;
            }
            ar next = it.next();
            if (!TextUtils.isEmpty(next.a())) {
                i2 += next.a().length();
            }
            i = !TextUtils.isEmpty(next.b()) ? next.b().length() + i2 : i2;
        }
    }

    public static String a(Context context, String str, List<ar> list) {
        return a(context, str, list, new a(), true);
    }

    public static String a(Context context, String str, List<ar> list, cx cxVar, boolean z) {
        if (as.b(context)) {
            try {
                ArrayList<String> arrayList = new ArrayList<>();
                cq cqVar = null;
                if (z && (cqVar = cu.a().m205a(str)) != null) {
                    arrayList = cqVar.a(str);
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
                        if (cqVar != null) {
                            cqVar.a(next, System.currentTimeMillis() - currentTimeMillis, a(cxVar, next, arrayList2, str2), e);
                        }
                        e.printStackTrace();
                    }
                    if (!cxVar.m214a(context, next, (List<ar>) arrayList2)) {
                        return str2;
                    }
                    str2 = cxVar.a(context, next, (List<ar>) arrayList2);
                    if (!TextUtils.isEmpty(str2)) {
                        if (cqVar != null) {
                            cqVar.a(next, System.currentTimeMillis() - currentTimeMillis, a(cxVar, next, arrayList2, str2));
                            return str2;
                        }
                        return str2;
                    }
                    if (cqVar != null) {
                        cqVar.a(next, System.currentTimeMillis() - currentTimeMillis, a(cxVar, next, arrayList2, str2), null);
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

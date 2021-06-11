package com.xiaomi.push;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.sapi2.activity.IdCardOcrCameraActivity;
import com.baidu.wallet.lightapp.business.LightappBusinessClient;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes7.dex */
public abstract class cw {

    /* loaded from: classes7.dex */
    public static class a extends cv {
        public a() {
            super(1);
        }

        @Override // com.xiaomi.push.cv
        public String a(Context context, String str, List<bf> list) {
            URL url;
            if (list == null) {
                url = new URL(str);
            } else {
                Uri.Builder buildUpon = Uri.parse(str).buildUpon();
                for (bf bfVar : list) {
                    buildUpon.appendQueryParameter(bfVar.a(), bfVar.b());
                }
                url = new URL(buildUpon.toString());
            }
            return bg.a(context, url);
        }
    }

    public static int a(int i2, int i3) {
        return (((i3 + LightappBusinessClient.REQUEST_PERMISSION_SELECT_PHONE_FROM_ADDRESSBOOK) / 1448) * 132) + IdCardOcrCameraActivity.G + i2 + i3;
    }

    public static int a(int i2, int i3, int i4) {
        return (((i3 + 200) / 1448) * 132) + 1011 + i3 + i2 + i4;
    }

    public static int a(cv cvVar, String str, List<bf> list, String str2) {
        if (cvVar.a() == 1) {
            return a(str.length(), a(str2));
        }
        if (cvVar.a() == 2) {
            return a(str.length(), a(list), a(str2));
        }
        return -1;
    }

    public static int a(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            return str.getBytes("UTF-8").length;
        } catch (UnsupportedEncodingException unused) {
            return 0;
        }
    }

    public static int a(List<bf> list) {
        int i2 = 0;
        for (bf bfVar : list) {
            if (!TextUtils.isEmpty(bfVar.a())) {
                i2 += bfVar.a().length();
            }
            if (!TextUtils.isEmpty(bfVar.b())) {
                i2 += bfVar.b().length();
            }
        }
        return i2 * 2;
    }

    public static String a(Context context, String str, List<bf> list) {
        return a(context, str, list, new a(), true);
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x00aa A[Catch: MalformedURLException -> 0x00c3, TRY_ENTER, TryCatch #4 {MalformedURLException -> 0x00c3, blocks: (B:4:0x000f, B:6:0x0016, B:8:0x0020, B:11:0x0027, B:13:0x002d, B:14:0x0030, B:15:0x0035, B:17:0x003b, B:19:0x0044, B:21:0x004c, B:49:0x00aa, B:50:0x00bc), top: B:64:0x000f }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(Context context, String str, List<bf> list, cv cvVar, boolean z) {
        co coVar;
        IOException iOException;
        String str2;
        String str3;
        if (bg.b(context)) {
            try {
                ArrayList<String> arrayList = new ArrayList<>();
                if (z) {
                    co m215a = cs.a().m215a(str);
                    if (m215a != null) {
                        arrayList = m215a.a(str);
                    }
                    coVar = m215a;
                } else {
                    coVar = null;
                }
                if (!arrayList.contains(str)) {
                    arrayList.add(str);
                }
                Iterator<String> it = arrayList.iterator();
                String str4 = null;
                while (it.hasNext()) {
                    String next = it.next();
                    ArrayList arrayList2 = list != null ? new ArrayList(list) : null;
                    long currentTimeMillis = System.currentTimeMillis();
                    try {
                    } catch (IOException e2) {
                        iOException = e2;
                        str2 = str4;
                    }
                    if (!cvVar.m224a(context, next, (List<bf>) arrayList2)) {
                        return str4;
                    }
                    String a2 = cvVar.a(context, next, (List<bf>) arrayList2);
                    try {
                    } catch (IOException e3) {
                        e = e3;
                        str3 = a2;
                    }
                    if (!TextUtils.isEmpty(a2)) {
                        if (coVar != null) {
                            try {
                                coVar.a(next, System.currentTimeMillis() - currentTimeMillis, a(cvVar, next, arrayList2, a2));
                            } catch (IOException e4) {
                                iOException = e4;
                                str2 = a2;
                                if (coVar != null) {
                                    coVar.a(next, System.currentTimeMillis() - currentTimeMillis, a(cvVar, next, arrayList2, str2), iOException);
                                }
                                iOException.printStackTrace();
                                str4 = str2;
                            }
                        }
                        return a2;
                    }
                    if (coVar != null) {
                        str3 = a2;
                        try {
                            coVar.a(next, System.currentTimeMillis() - currentTimeMillis, a(cvVar, next, arrayList2, a2), null);
                        } catch (IOException e5) {
                            e = e5;
                            String str5 = str3;
                            iOException = e;
                            str2 = str5;
                            if (coVar != null) {
                            }
                            iOException.printStackTrace();
                            str4 = str2;
                        }
                    } else {
                        str3 = a2;
                    }
                    str4 = str3;
                }
                return str4;
            } catch (MalformedURLException e6) {
                e6.printStackTrace();
            }
        }
        return null;
    }
}

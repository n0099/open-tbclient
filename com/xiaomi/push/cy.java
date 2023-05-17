package com.xiaomi.push;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes10.dex */
public abstract class cy {

    /* loaded from: classes10.dex */
    public static class a extends cx {
        public a() {
            super(1);
        }

        @Override // com.xiaomi.push.cx
        public String a(Context context, String str, List<bh> list) {
            URL url;
            if (list == null) {
                url = new URL(str);
            } else {
                Uri.Builder buildUpon = Uri.parse(str).buildUpon();
                for (bh bhVar : list) {
                    buildUpon.appendQueryParameter(bhVar.a(), bhVar.b());
                }
                url = new URL(buildUpon.toString());
            }
            return bi.a(context, url);
        }
    }

    public static int a(int i, int i2) {
        return (((i2 + 243) / 1448) * 132) + 1080 + i + i2;
    }

    public static int a(int i, int i2, int i3) {
        return (((i2 + 200) / 1448) * 132) + 1011 + i2 + i + i3;
    }

    public static int a(cx cxVar, String str, List<bh> list, String str2) {
        if (cxVar.a() == 1) {
            return a(str.length(), a(str2));
        }
        if (cxVar.a() == 2) {
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

    public static int a(List<bh> list) {
        int i = 0;
        for (bh bhVar : list) {
            if (!TextUtils.isEmpty(bhVar.a())) {
                i += bhVar.a().length();
            }
            if (!TextUtils.isEmpty(bhVar.b())) {
                i += bhVar.b().length();
            }
        }
        return i * 2;
    }

    public static String a(Context context, String str, List<bh> list) {
        return a(context, str, list, new a(), true);
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x00aa A[Catch: MalformedURLException -> 0x00c3, TRY_ENTER, TryCatch #4 {MalformedURLException -> 0x00c3, blocks: (B:4:0x000f, B:6:0x0016, B:8:0x0020, B:11:0x0027, B:13:0x002d, B:14:0x0030, B:15:0x0035, B:17:0x003b, B:19:0x0044, B:21:0x004c, B:49:0x00aa, B:50:0x00bc), top: B:64:0x000f }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(Context context, String str, List<bh> list, cx cxVar, boolean z) {
        cq cqVar;
        IOException iOException;
        String str2;
        String str3;
        if (bi.b(context)) {
            try {
                ArrayList<String> arrayList = new ArrayList<>();
                if (z) {
                    cq m285a = cu.a().m285a(str);
                    if (m285a != null) {
                        arrayList = m285a.a(str);
                    }
                    cqVar = m285a;
                } else {
                    cqVar = null;
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
                    } catch (IOException e) {
                        iOException = e;
                        str2 = str4;
                    }
                    if (!cxVar.m294a(context, next, (List<bh>) arrayList2)) {
                        return str4;
                    }
                    String a2 = cxVar.a(context, next, (List<bh>) arrayList2);
                    try {
                    } catch (IOException e2) {
                        e = e2;
                        str3 = a2;
                    }
                    if (!TextUtils.isEmpty(a2)) {
                        if (cqVar != null) {
                            try {
                                cqVar.a(next, System.currentTimeMillis() - currentTimeMillis, a(cxVar, next, arrayList2, a2));
                            } catch (IOException e3) {
                                iOException = e3;
                                str2 = a2;
                                if (cqVar != null) {
                                    cqVar.a(next, System.currentTimeMillis() - currentTimeMillis, a(cxVar, next, arrayList2, str2), iOException);
                                }
                                iOException.printStackTrace();
                                str4 = str2;
                            }
                        }
                        return a2;
                    }
                    if (cqVar != null) {
                        str3 = a2;
                        try {
                            cqVar.a(next, System.currentTimeMillis() - currentTimeMillis, a(cxVar, next, arrayList2, a2), null);
                        } catch (IOException e4) {
                            e = e4;
                            String str5 = str3;
                            iOException = e;
                            str2 = str5;
                            if (cqVar != null) {
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
            } catch (MalformedURLException e5) {
                e5.printStackTrace();
            }
        }
        return null;
    }
}

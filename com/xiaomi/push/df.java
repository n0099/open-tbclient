package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
/* loaded from: classes9.dex */
public class df {
    public static int a(Context context, int i) {
        int a = gx.a(context);
        if (-1 == a) {
            return -1;
        }
        return ((a == 0 ? 13 : 11) * i) / 10;
    }

    public static int a(hm hmVar) {
        return fa.a(hmVar.a());
    }

    public static int a(ix ixVar, hm hmVar) {
        switch (dg.a[hmVar.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                return fa.a(hmVar.a());
            case 11:
                int a = fa.a(hmVar.a());
                if (ixVar != null) {
                    try {
                        if (ixVar instanceof id) {
                            String str = ((id) ixVar).f565d;
                            return (TextUtils.isEmpty(str) || fa.a(fa.m265a(str)) == -1) ? a : fa.a(fa.m265a(str));
                        } else if (ixVar instanceof il) {
                            String str2 = ((il) ixVar).f624d;
                            if (TextUtils.isEmpty(str2)) {
                                return a;
                            }
                            if (fa.a(fa.m265a(str2)) != -1) {
                                a = fa.a(fa.m265a(str2));
                            }
                            if (hw.UploadTinyData.equals(fa.m265a(str2))) {
                                return -1;
                            }
                            return a;
                        } else {
                            return a;
                        }
                    } catch (Exception e) {
                        com.xiaomi.channel.commonutils.logger.b.d("PERF_ERROR : parse Notification type error");
                        return a;
                    }
                }
                return a;
            case 12:
                int a2 = fa.a(hmVar.a());
                if (ixVar != null) {
                    try {
                        if (ixVar instanceof ih) {
                            String a3 = ((ih) ixVar).a();
                            if (!TextUtils.isEmpty(a3) && fg.a(a3) != -1) {
                                a2 = fg.a(a3);
                            }
                        } else if (ixVar instanceof ig) {
                            String a4 = ((ig) ixVar).a();
                            if (!TextUtils.isEmpty(a4) && fg.a(a4) != -1) {
                                a2 = fg.a(a4);
                            }
                        }
                        return a2;
                    } catch (Exception e2) {
                        com.xiaomi.channel.commonutils.logger.b.d("PERF_ERROR : parse Command type error");
                        return a2;
                    }
                }
                return a2;
            default:
                return -1;
        }
    }

    public static void a(String str, Context context, int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            return;
        }
        int a = a(context, i2);
        if (i != fa.a(hw.UploadTinyData)) {
            fb.a(context.getApplicationContext()).a(str, i, 1L, a);
        }
    }

    public static void a(String str, Context context, ii iiVar, int i) {
        hm a;
        if (context == null || iiVar == null || (a = iiVar.a()) == null) {
            return;
        }
        int a2 = a(a);
        int i2 = 0;
        if (i <= 0) {
            byte[] a3 = iw.a(iiVar);
            if (a3 != null) {
                i2 = a3.length;
            }
        } else {
            i2 = i;
        }
        a(str, context, a2, i2);
    }

    public static void a(String str, Context context, ix ixVar, hm hmVar, int i) {
        a(str, context, a(ixVar, hmVar), i);
    }

    public static void a(String str, Context context, byte[] bArr) {
        if (context == null || bArr == null || bArr.length <= 0) {
            return;
        }
        ii iiVar = new ii();
        try {
            iw.a(iiVar, bArr);
            a(str, context, iiVar, bArr.length);
        } catch (jc e) {
            com.xiaomi.channel.commonutils.logger.b.m49a("fail to convert bytes to container");
        }
    }
}

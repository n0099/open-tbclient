package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
/* loaded from: classes6.dex */
public class df {
    public static int a(Context context, int i) {
        int a2 = gx.a(context);
        if (-1 == a2) {
            return -1;
        }
        return ((a2 == 0 ? 13 : 11) * i) / 10;
    }

    public static int a(hm hmVar) {
        return fa.a(hmVar.a());
    }

    public static int a(ix ixVar, hm hmVar) {
        switch (dg.f14233a[hmVar.ordinal()]) {
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
                int a2 = fa.a(hmVar.a());
                if (ixVar != null) {
                    try {
                        if (ixVar instanceof id) {
                            String str = ((id) ixVar).f642d;
                            return (TextUtils.isEmpty(str) || fa.a(fa.m289a(str)) == -1) ? a2 : fa.a(fa.m289a(str));
                        } else if (ixVar instanceof il) {
                            String str2 = ((il) ixVar).f701d;
                            if (TextUtils.isEmpty(str2)) {
                                return a2;
                            }
                            if (fa.a(fa.m289a(str2)) != -1) {
                                a2 = fa.a(fa.m289a(str2));
                            }
                            if (hw.UploadTinyData.equals(fa.m289a(str2))) {
                                return -1;
                            }
                            return a2;
                        } else {
                            return a2;
                        }
                    } catch (Exception e) {
                        com.xiaomi.channel.commonutils.logger.b.d("PERF_ERROR : parse Notification type error");
                        return a2;
                    }
                }
                return a2;
            case 12:
                int a3 = fa.a(hmVar.a());
                if (ixVar != null) {
                    try {
                        if (ixVar instanceof ih) {
                            String a4 = ((ih) ixVar).a();
                            if (!TextUtils.isEmpty(a4) && fg.a(a4) != -1) {
                                a3 = fg.a(a4);
                            }
                        } else if (ixVar instanceof ig) {
                            String a5 = ((ig) ixVar).a();
                            if (!TextUtils.isEmpty(a5) && fg.a(a5) != -1) {
                                a3 = fg.a(a5);
                            }
                        }
                        return a3;
                    } catch (Exception e2) {
                        com.xiaomi.channel.commonutils.logger.b.d("PERF_ERROR : parse Command type error");
                        return a3;
                    }
                }
                return a3;
            default:
                return -1;
        }
    }

    public static void a(String str, Context context, int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            return;
        }
        int a2 = a(context, i2);
        if (i != fa.a(hw.UploadTinyData)) {
            fb.a(context.getApplicationContext()).a(str, i, 1L, a2);
        }
    }

    public static void a(String str, Context context, ii iiVar, int i) {
        hm a2;
        if (context == null || iiVar == null || (a2 = iiVar.a()) == null) {
            return;
        }
        int a3 = a(a2);
        int i2 = 0;
        if (i <= 0) {
            byte[] a4 = iw.a(iiVar);
            if (a4 != null) {
                i2 = a4.length;
            }
        } else {
            i2 = i;
        }
        a(str, context, a3, i2);
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
            com.xiaomi.channel.commonutils.logger.b.m73a("fail to convert bytes to container");
        }
    }
}

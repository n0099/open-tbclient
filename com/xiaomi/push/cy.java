package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
/* loaded from: classes7.dex */
public class cy {
    public static int a(Context context, int i2) {
        int a2 = gq.a(context);
        if (-1 == a2) {
            return -1;
        }
        return (i2 * (a2 == 0 ? 13 : 11)) / 10;
    }

    public static int a(hf hfVar) {
        return ek.a(hfVar.a());
    }

    public static int a(iq iqVar, hf hfVar) {
        int a2;
        switch (cz.f38245a[hfVar.ordinal()]) {
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
                return ek.a(hfVar.a());
            case 11:
                a2 = ek.a(hfVar.a());
                if (iqVar != null) {
                    try {
                        if (iqVar instanceof hw) {
                            String str = ((hw) iqVar).f591d;
                            if (!TextUtils.isEmpty(str) && ek.a(ek.m273a(str)) != -1) {
                                a2 = ek.a(ek.m273a(str));
                                break;
                            }
                        } else if (iqVar instanceof ie) {
                            String str2 = ((ie) iqVar).f652d;
                            if (!TextUtils.isEmpty(str2)) {
                                if (ek.a(ek.m273a(str2)) != -1) {
                                    a2 = ek.a(ek.m273a(str2));
                                }
                                if (hp.UploadTinyData.equals(ek.m273a(str2))) {
                                    return -1;
                                }
                            }
                        }
                    } catch (Exception unused) {
                        com.xiaomi.channel.commonutils.logger.b.d("PERF_ERROR : parse Notification type error");
                        return a2;
                    }
                }
                break;
            case 12:
                a2 = ek.a(hfVar.a());
                if (iqVar != null) {
                    try {
                        if (iqVar instanceof ia) {
                            String b2 = ((ia) iqVar).b();
                            if (!TextUtils.isEmpty(b2) && ev.a(b2) != -1) {
                                a2 = ev.a(b2);
                                break;
                            }
                        } else if (iqVar instanceof hz) {
                            String a3 = ((hz) iqVar).a();
                            if (!TextUtils.isEmpty(a3) && ev.a(a3) != -1) {
                                return ev.a(a3);
                            }
                        }
                    } catch (Exception unused2) {
                        com.xiaomi.channel.commonutils.logger.b.d("PERF_ERROR : parse Command type error");
                        break;
                    }
                }
                break;
            default:
                return -1;
        }
        return a2;
    }

    public static void a(String str, Context context, int i2, int i3) {
        if (i2 <= 0 || i3 <= 0) {
            return;
        }
        int a2 = a(context, i3);
        if (i2 != ek.a(hp.UploadTinyData)) {
            el.a(context.getApplicationContext()).a(str, i2, 1L, a2);
        }
    }

    public static void a(String str, Context context, ib ibVar, int i2) {
        hf a2;
        if (context == null || ibVar == null || (a2 = ibVar.a()) == null) {
            return;
        }
        int a3 = a(a2);
        if (i2 <= 0) {
            byte[] a4 = ip.a(ibVar);
            i2 = a4 != null ? a4.length : 0;
        }
        a(str, context, a3, i2);
    }

    public static void a(String str, Context context, iq iqVar, hf hfVar, int i2) {
        a(str, context, a(iqVar, hfVar), i2);
    }

    public static void a(String str, Context context, byte[] bArr) {
        if (context == null || bArr == null || bArr.length <= 0) {
            return;
        }
        ib ibVar = new ib();
        try {
            ip.a(ibVar, bArr);
            a(str, context, ibVar, bArr.length);
        } catch (iv unused) {
            com.xiaomi.channel.commonutils.logger.b.m58a("fail to convert bytes to container");
        }
    }
}

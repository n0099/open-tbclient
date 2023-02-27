package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
/* loaded from: classes8.dex */
public class da {
    public static int a(Context context, int i) {
        int a = ha.a(context);
        if (-1 == a) {
            return -1;
        }
        return (i * (a == 0 ? 13 : 11)) / 10;
    }

    public static int a(hh hhVar) {
        return em.a(hhVar.a());
    }

    public static int a(is isVar, hh hhVar) {
        int a;
        switch (db.a[hhVar.ordinal()]) {
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
                return em.a(hhVar.a());
            case 11:
                a = em.a(hhVar.a());
                if (isVar != null) {
                    try {
                        if (isVar instanceof hy) {
                            String str = ((hy) isVar).f593d;
                            if (!TextUtils.isEmpty(str) && em.a(em.m368a(str)) != -1) {
                                a = em.a(em.m368a(str));
                                break;
                            }
                        } else if (isVar instanceof ig) {
                            String str2 = ((ig) isVar).f655d;
                            if (!TextUtils.isEmpty(str2)) {
                                if (em.a(em.m368a(str2)) != -1) {
                                    a = em.a(em.m368a(str2));
                                }
                                if (hr.UploadTinyData.equals(em.m368a(str2))) {
                                    return -1;
                                }
                            }
                        }
                    } catch (Exception unused) {
                        com.xiaomi.channel.commonutils.logger.b.d("PERF_ERROR : parse Notification type error");
                        return a;
                    }
                }
                break;
            case 12:
                a = em.a(hhVar.a());
                if (isVar != null) {
                    try {
                        if (isVar instanceof ic) {
                            String b = ((ic) isVar).b();
                            if (!TextUtils.isEmpty(b) && ex.a(b) != -1) {
                                a = ex.a(b);
                                break;
                            }
                        } else if (isVar instanceof ib) {
                            String a2 = ((ib) isVar).a();
                            if (!TextUtils.isEmpty(a2) && ex.a(a2) != -1) {
                                return ex.a(a2);
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
        return a;
    }

    public static void a(String str, Context context, int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            return;
        }
        int a = a(context, i2);
        if (i != em.a(hr.UploadTinyData)) {
            en.a(context.getApplicationContext()).a(str, i, 1L, a);
        }
    }

    public static void a(String str, Context context, id idVar, int i) {
        hh a;
        if (context == null || idVar == null || (a = idVar.a()) == null) {
            return;
        }
        int a2 = a(a);
        if (i <= 0) {
            byte[] a3 = ir.a(idVar);
            i = a3 != null ? a3.length : 0;
        }
        a(str, context, a2, i);
    }

    public static void a(String str, Context context, is isVar, hh hhVar, int i) {
        a(str, context, a(isVar, hhVar), i);
    }

    public static void a(String str, Context context, byte[] bArr) {
        if (context == null || bArr == null || bArr.length <= 0) {
            return;
        }
        id idVar = new id();
        try {
            ir.a(idVar, bArr);
            a(str, context, idVar, bArr.length);
        } catch (ix unused) {
            com.xiaomi.channel.commonutils.logger.b.m97a("fail to convert bytes to container");
        }
    }
}

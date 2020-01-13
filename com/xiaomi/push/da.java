package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
/* loaded from: classes6.dex */
public class da {
    public static int a(Context context, int i) {
        int a = gr.a(context);
        if (-1 == a) {
            return -1;
        }
        return ((a == 0 ? 13 : 11) * i) / 10;
    }

    public static int a(hg hgVar) {
        return eu.a(hgVar.a());
    }

    public static int a(ir irVar, hg hgVar) {
        switch (db.a[hgVar.ordinal()]) {
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
                return eu.a(hgVar.a());
            case 11:
                int a = eu.a(hgVar.a());
                if (irVar != null) {
                    try {
                        if (irVar instanceof hx) {
                            String str = ((hx) irVar).f577d;
                            return (TextUtils.isEmpty(str) || eu.a(eu.m254a(str)) == -1) ? a : eu.a(eu.m254a(str));
                        } else if (irVar instanceof Cif) {
                            String str2 = ((Cif) irVar).f637d;
                            if (TextUtils.isEmpty(str2)) {
                                return a;
                            }
                            if (eu.a(eu.m254a(str2)) != -1) {
                                a = eu.a(eu.m254a(str2));
                            }
                            if (hq.UploadTinyData.equals(eu.m254a(str2))) {
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
                int a2 = eu.a(hgVar.a());
                if (irVar != null) {
                    try {
                        if (irVar instanceof ib) {
                            String a3 = ((ib) irVar).a();
                            if (!TextUtils.isEmpty(a3) && fa.a(a3) != -1) {
                                a2 = fa.a(a3);
                            }
                        } else if (irVar instanceof ia) {
                            String a4 = ((ia) irVar).a();
                            if (!TextUtils.isEmpty(a4) && fa.a(a4) != -1) {
                                a2 = fa.a(a4);
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
        if (i != eu.a(hq.UploadTinyData)) {
            ev.a(context.getApplicationContext()).a(str, i, 1L, a);
        }
    }

    public static void a(String str, Context context, ic icVar, int i) {
        hg a;
        if (context == null || icVar == null || (a = icVar.a()) == null) {
            return;
        }
        int a2 = a(a);
        int i2 = 0;
        if (i <= 0) {
            byte[] a3 = iq.a(icVar);
            if (a3 != null) {
                i2 = a3.length;
            }
        } else {
            i2 = i;
        }
        a(str, context, a2, i2);
    }

    public static void a(String str, Context context, ir irVar, hg hgVar, int i) {
        a(str, context, a(irVar, hgVar), i);
    }

    public static void a(String str, Context context, byte[] bArr) {
        if (context == null || bArr == null || bArr.length <= 0) {
            return;
        }
        ic icVar = new ic();
        try {
            iq.a(icVar, bArr);
            a(str, context, icVar, bArr.length);
        } catch (iw e) {
            com.xiaomi.channel.commonutils.logger.b.m42a("fail to convert bytes to container");
        }
    }
}

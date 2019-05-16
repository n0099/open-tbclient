package com.xiaomi.push.clientreport;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.push.service.clientReport.c;
import com.xiaomi.push.service.clientReport.d;
import com.xiaomi.smack.util.g;
import com.xiaomi.xmpush.thrift.aa;
import com.xiaomi.xmpush.thrift.ad;
import com.xiaomi.xmpush.thrift.ae;
import com.xiaomi.xmpush.thrift.af;
import com.xiaomi.xmpush.thrift.ai;
import com.xiaomi.xmpush.thrift.at;
import com.xiaomi.xmpush.thrift.r;
import org.apache.thrift.f;
/* loaded from: classes3.dex */
public class a {
    public static int a(Context context, int i) {
        int b = g.b(context);
        if (-1 == b) {
            return -1;
        }
        return ((b == 0 ? 13 : 11) * i) / 10;
    }

    public static int a(com.xiaomi.xmpush.thrift.a aVar) {
        return c.b(aVar.a());
    }

    public static int a(org.apache.thrift.a aVar, com.xiaomi.xmpush.thrift.a aVar2) {
        switch (b.a[aVar2.ordinal()]) {
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
                return c.b(aVar2.a());
            case 11:
                int b = c.b(aVar2.a());
                if (aVar != null) {
                    try {
                        if (aVar instanceof aa) {
                            String str = ((aa) aVar).e;
                            return (TextUtils.isEmpty(str) || c.a(c.b(str)) == -1) ? b : c.a(c.b(str));
                        } else if (aVar instanceof ai) {
                            String str2 = ((ai) aVar).e;
                            if (TextUtils.isEmpty(str2)) {
                                return b;
                            }
                            if (c.a(c.b(str2)) != -1) {
                                b = c.a(c.b(str2));
                            }
                            if (r.UploadTinyData.equals(c.b(str2))) {
                                return -1;
                            }
                            return b;
                        } else {
                            return b;
                        }
                    } catch (Exception e) {
                        com.xiaomi.channel.commonutils.logger.b.d("PERF_ERROR : parse Notification type error");
                        return b;
                    }
                }
                return b;
            case 12:
                int b2 = c.b(aVar2.a());
                if (aVar != null) {
                    try {
                        if (aVar instanceof ae) {
                            String d = ((ae) aVar).d();
                            if (!TextUtils.isEmpty(d) && com.xiaomi.push.service.xmpush.a.a(d) != -1) {
                                b2 = com.xiaomi.push.service.xmpush.a.a(d);
                            }
                        } else if (aVar instanceof ad) {
                            String d2 = ((ad) aVar).d();
                            if (!TextUtils.isEmpty(d2) && com.xiaomi.push.service.xmpush.a.a(d2) != -1) {
                                b2 = com.xiaomi.push.service.xmpush.a.a(d2);
                            }
                        }
                        return b2;
                    } catch (Exception e2) {
                        com.xiaomi.channel.commonutils.logger.b.d("PERF_ERROR : parse Command type error");
                        return b2;
                    }
                }
                return b2;
            default:
                return -1;
        }
    }

    public static void a(Context context, int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            return;
        }
        int a = a(context, i2);
        if (i != c.a(r.UploadTinyData)) {
            com.xiaomi.channel.commonutils.logger.b.a("Perf_code  packetType  " + i + "  length " + a);
            d.a(context.getApplicationContext()).a(i, 1L, a);
        }
    }

    public static void a(Context context, af afVar, int i) {
        com.xiaomi.xmpush.thrift.a a;
        if (context == null || afVar == null || (a = afVar.a()) == null) {
            return;
        }
        int a2 = a(a);
        int i2 = 0;
        if (i <= 0) {
            byte[] a3 = at.a(afVar);
            if (a3 != null) {
                i2 = a3.length;
            }
        } else {
            i2 = i;
        }
        a(context, a2, i2);
    }

    public static void a(Context context, org.apache.thrift.a aVar, com.xiaomi.xmpush.thrift.a aVar2, int i) {
        a(context, a(aVar, aVar2), i);
    }

    public static void a(Context context, byte[] bArr) {
        if (context == null || bArr == null || bArr.length <= 0) {
            return;
        }
        af afVar = new af();
        try {
            at.a(afVar, bArr);
            a(context, afVar, bArr.length);
        } catch (f e) {
            com.xiaomi.channel.commonutils.logger.b.a("fail to convert bytes to container");
        }
    }
}

package com.xiaomi.push.service;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.hk;
import com.xiaomi.push.hl;
import com.xiaomi.push.hr;
import com.xiaomi.push.ig;
import com.xiaomi.push.ir;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes10.dex */
public class bz {
    public static String a;

    /* renamed from: a  reason: collision with other field name */
    public static SimpleDateFormat f959a;

    /* renamed from: a  reason: collision with other field name */
    public static AtomicLong f960a = new AtomicLong(0);

    static {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        f959a = simpleDateFormat;
        a = simpleDateFormat.format(Long.valueOf(System.currentTimeMillis()));
    }

    public static ig a(String str, String str2, hk hkVar) {
        return new ig("-1", false).d(str).b(str2).a(com.xiaomi.push.y.a(ir.a(hkVar))).c(hr.UploadTinyData.f504a);
    }

    public static synchronized String a() {
        String str;
        synchronized (bz.class) {
            String format = f959a.format(Long.valueOf(System.currentTimeMillis()));
            if (!TextUtils.equals(a, format)) {
                f960a.set(0L);
                a = format;
            }
            str = format + "-" + f960a.incrementAndGet();
        }
        return str;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0066  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static ArrayList<ig> a(List<hl> list, String str, String str2, int i) {
        int i2;
        String str3;
        if (list == null) {
            str3 = "requests can not be null in TinyDataHelper.transToThriftObj().";
        } else if (list.size() != 0) {
            ArrayList<ig> arrayList = new ArrayList<>();
            hk hkVar = new hk();
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                hl hlVar = list.get(i4);
                if (hlVar != null) {
                    if (hlVar.m563a() == null || !hlVar.m563a().containsKey("item_size")) {
                        i2 = 0;
                    } else {
                        String str4 = hlVar.m563a().get("item_size");
                        if (!TextUtils.isEmpty(str4)) {
                            try {
                                i2 = Integer.parseInt(str4);
                            } catch (Exception unused) {
                            }
                            if (hlVar.m563a().size() != 1) {
                                hlVar.a((Map<String, String>) null);
                            } else {
                                hlVar.m563a().remove("item_size");
                            }
                        }
                        i2 = 0;
                        if (hlVar.m563a().size() != 1) {
                        }
                    }
                    if (i2 <= 0) {
                        i2 = ir.a(hlVar).length;
                    }
                    if (i2 > i) {
                        com.xiaomi.channel.commonutils.logger.b.d("TinyData is too big, ignore upload request item:" + hlVar.d());
                    } else {
                        if (i3 + i2 > i) {
                            arrayList.add(a(str, str2, hkVar));
                            hkVar = new hk();
                            i3 = 0;
                        }
                        hkVar.a(hlVar);
                        i3 += i2;
                    }
                }
            }
            if (hkVar.a() != 0) {
                arrayList.add(a(str, str2, hkVar));
            }
            return arrayList;
        } else {
            str3 = "requests.length is 0 in TinyDataHelper.transToThriftObj().";
        }
        com.xiaomi.channel.commonutils.logger.b.d(str3);
        return null;
    }

    public static void a(Context context, String str, String str2, long j, String str3) {
        hl hlVar = new hl();
        hlVar.d(str);
        hlVar.c(str2);
        hlVar.a(j);
        hlVar.b(str3);
        hlVar.a("push_sdk_channel");
        hlVar.g(context.getPackageName());
        hlVar.e(context.getPackageName());
        hlVar.a(true);
        hlVar.b(System.currentTimeMillis());
        hlVar.f(a());
        ca.a(context, hlVar);
    }

    public static boolean a(hl hlVar, boolean z) {
        String str;
        if (hlVar == null) {
            str = "item is null, verfiy ClientUploadDataItem failed.";
        } else if (!z && TextUtils.isEmpty(hlVar.f476a)) {
            str = "item.channel is null or empty, verfiy ClientUploadDataItem failed.";
        } else if (TextUtils.isEmpty(hlVar.f483d)) {
            str = "item.category is null or empty, verfiy ClientUploadDataItem failed.";
        } else if (TextUtils.isEmpty(hlVar.f482c)) {
            str = "item.name is null or empty, verfiy ClientUploadDataItem failed.";
        } else if (!com.xiaomi.push.bo.m308a(hlVar.f483d)) {
            str = "item.category can only contain ascii char, verfiy ClientUploadDataItem failed.";
        } else if (com.xiaomi.push.bo.m308a(hlVar.f482c)) {
            String str2 = hlVar.f481b;
            if (str2 == null || str2.length() <= 10240) {
                return false;
            }
            str = "item.data is too large(" + hlVar.f481b.length() + "), max size for data is 10240 , verfiy ClientUploadDataItem failed.";
        } else {
            str = "item.name can only contain ascii char, verfiy ClientUploadDataItem failed.";
        }
        com.xiaomi.channel.commonutils.logger.b.m190a(str);
        return true;
    }

    public static boolean a(String str) {
        return !com.xiaomi.push.s.m736b() || Constants.HYBRID_PACKAGE_NAME.equals(str);
    }
}

package com.xiaomi.push.service;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.Cif;
import com.xiaomi.push.hj;
import com.xiaomi.push.hk;
import com.xiaomi.push.hq;
import com.xiaomi.push.iq;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes8.dex */
public class be {

    /* renamed from: a  reason: collision with other field name */
    private static AtomicLong f896a = new AtomicLong(0);

    /* renamed from: a  reason: collision with other field name */
    private static SimpleDateFormat f895a = new SimpleDateFormat("yyyy/MM/dd");
    private static String a = f895a.format(Long.valueOf(System.currentTimeMillis()));

    public static synchronized String a() {
        String str;
        synchronized (be.class) {
            String format = f895a.format(Long.valueOf(System.currentTimeMillis()));
            if (!TextUtils.equals(a, format)) {
                f896a.set(0L);
                a = format;
            }
            str = format + Constants.ACCEPT_TIME_SEPARATOR_SERVER + f896a.incrementAndGet();
        }
        return str;
    }

    public static ArrayList<Cif> a(List<hk> list, String str, String str2, int i) {
        if (list == null) {
            com.xiaomi.channel.commonutils.logger.b.d("requests can not be null in TinyDataHelper.transToThriftObj().");
            return null;
        } else if (list.size() == 0) {
            com.xiaomi.channel.commonutils.logger.b.d("requests.length is 0 in TinyDataHelper.transToThriftObj().");
            return null;
        } else {
            ArrayList<Cif> arrayList = new ArrayList<>();
            int i2 = 0;
            hj hjVar = new hj();
            for (int i3 = 0; i3 < list.size(); i3++) {
                hk hkVar = list.get(i3);
                if (hkVar != null) {
                    int length = iq.a(hkVar).length;
                    if (length > i) {
                        com.xiaomi.channel.commonutils.logger.b.d("TinyData is too big, ignore upload request item:" + hkVar.d());
                    } else {
                        if (i2 + length > i) {
                            Cif cif = new Cif("-1", false);
                            cif.d(str);
                            cif.b(str2);
                            cif.c(hq.UploadTinyData.f489a);
                            cif.a(com.xiaomi.push.y.a(iq.a(hjVar)));
                            arrayList.add(cif);
                            hjVar = new hj();
                            i2 = 0;
                        }
                        hjVar.a(hkVar);
                        i2 += length;
                    }
                }
            }
            if (hjVar.a() != 0) {
                Cif cif2 = new Cif("-1", false);
                cif2.d(str);
                cif2.b(str2);
                cif2.c(hq.UploadTinyData.f489a);
                cif2.a(com.xiaomi.push.y.a(iq.a(hjVar)));
                arrayList.add(cif2);
            }
            return arrayList;
        }
    }

    public static void a(Context context, String str, String str2, long j, String str3) {
        hk hkVar = new hk();
        hkVar.d(str);
        hkVar.c(str2);
        hkVar.a(j);
        hkVar.b(str3);
        hkVar.a("push_sdk_channel");
        hkVar.g(context.getPackageName());
        hkVar.e(context.getPackageName());
        hkVar.a(true);
        hkVar.b(System.currentTimeMillis());
        hkVar.f(a());
        bf.a(context, hkVar);
    }

    public static boolean a(hk hkVar, boolean z) {
        if (hkVar == null) {
            com.xiaomi.channel.commonutils.logger.b.m47a("item is null, verfiy ClientUploadDataItem failed.");
            return true;
        } else if (!z && TextUtils.isEmpty(hkVar.f461a)) {
            com.xiaomi.channel.commonutils.logger.b.m47a("item.channel is null or empty, verfiy ClientUploadDataItem failed.");
            return true;
        } else if (TextUtils.isEmpty(hkVar.f468d)) {
            com.xiaomi.channel.commonutils.logger.b.m47a("item.category is null or empty, verfiy ClientUploadDataItem failed.");
            return true;
        } else if (TextUtils.isEmpty(hkVar.f467c)) {
            com.xiaomi.channel.commonutils.logger.b.m47a("item.name is null or empty, verfiy ClientUploadDataItem failed.");
            return true;
        } else if (!com.xiaomi.push.ay.m140a(hkVar.f468d)) {
            com.xiaomi.channel.commonutils.logger.b.m47a("item.category can only contain ascii char, verfiy ClientUploadDataItem failed.");
            return true;
        } else if (!com.xiaomi.push.ay.m140a(hkVar.f467c)) {
            com.xiaomi.channel.commonutils.logger.b.m47a("item.name can only contain ascii char, verfiy ClientUploadDataItem failed.");
            return true;
        } else if (hkVar.f466b == null || hkVar.f466b.length() <= 10240) {
            return false;
        } else {
            com.xiaomi.channel.commonutils.logger.b.m47a("item.data is too large(" + hkVar.f466b.length() + "), max size for data is 10240 , verfiy ClientUploadDataItem failed.");
            return true;
        }
    }

    public static boolean a(String str) {
        return !com.xiaomi.push.t.m566b() || Constants.HYBRID_PACKAGE_NAME.equals(str);
    }
}

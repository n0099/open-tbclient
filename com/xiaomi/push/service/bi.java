package com.xiaomi.push.service;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.hp;
import com.xiaomi.push.hq;
import com.xiaomi.push.hw;
import com.xiaomi.push.il;
import com.xiaomi.push.iw;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes12.dex */
public class bi {

    /* renamed from: a  reason: collision with other field name */
    private static AtomicLong f896a = new AtomicLong(0);

    /* renamed from: a  reason: collision with other field name */
    private static SimpleDateFormat f895a = new SimpleDateFormat("yyyy/MM/dd");

    /* renamed from: a  reason: collision with root package name */
    private static String f5082a = f895a.format(Long.valueOf(System.currentTimeMillis()));

    public static synchronized String a() {
        String str;
        synchronized (bi.class) {
            String format = f895a.format(Long.valueOf(System.currentTimeMillis()));
            if (!TextUtils.equals(f5082a, format)) {
                f896a.set(0L);
                f5082a = format;
            }
            str = format + Constants.ACCEPT_TIME_SEPARATOR_SERVER + f896a.incrementAndGet();
        }
        return str;
    }

    public static ArrayList<il> a(List<hq> list, String str, String str2, int i) {
        if (list == null) {
            com.xiaomi.channel.commonutils.logger.b.d("requests can not be null in TinyDataHelper.transToThriftObj().");
            return null;
        } else if (list.size() == 0) {
            com.xiaomi.channel.commonutils.logger.b.d("requests.length is 0 in TinyDataHelper.transToThriftObj().");
            return null;
        } else {
            ArrayList<il> arrayList = new ArrayList<>();
            int i2 = 0;
            hp hpVar = new hp();
            for (int i3 = 0; i3 < list.size(); i3++) {
                hq hqVar = list.get(i3);
                if (hqVar != null) {
                    int length = iw.a(hqVar).length;
                    if (length > i) {
                        com.xiaomi.channel.commonutils.logger.b.d("TinyData is too big, ignore upload request item:" + hqVar.d());
                    } else {
                        if (i2 + length > i) {
                            il ilVar = new il("-1", false);
                            ilVar.d(str);
                            ilVar.b(str2);
                            ilVar.c(hw.UploadTinyData.f477a);
                            ilVar.a(com.xiaomi.push.y.a(iw.a(hpVar)));
                            arrayList.add(ilVar);
                            hpVar = new hp();
                            i2 = 0;
                        }
                        hpVar.a(hqVar);
                        i2 += length;
                    }
                }
            }
            if (hpVar.a() != 0) {
                il ilVar2 = new il("-1", false);
                ilVar2.d(str);
                ilVar2.b(str2);
                ilVar2.c(hw.UploadTinyData.f477a);
                ilVar2.a(com.xiaomi.push.y.a(iw.a(hpVar)));
                arrayList.add(ilVar2);
            }
            return arrayList;
        }
    }

    public static void a(Context context, String str, String str2, long j, String str3) {
        hq hqVar = new hq();
        hqVar.d(str);
        hqVar.c(str2);
        hqVar.a(j);
        hqVar.b(str3);
        hqVar.a("push_sdk_channel");
        hqVar.g(context.getPackageName());
        hqVar.e(context.getPackageName());
        hqVar.a(true);
        hqVar.b(System.currentTimeMillis());
        hqVar.f(a());
        bj.a(context, hqVar);
    }

    public static boolean a(hq hqVar, boolean z) {
        if (hqVar == null) {
            com.xiaomi.channel.commonutils.logger.b.m55a("item is null, verfiy ClientUploadDataItem failed.");
            return true;
        } else if (!z && TextUtils.isEmpty(hqVar.f449a)) {
            com.xiaomi.channel.commonutils.logger.b.m55a("item.channel is null or empty, verfiy ClientUploadDataItem failed.");
            return true;
        } else if (TextUtils.isEmpty(hqVar.f456d)) {
            com.xiaomi.channel.commonutils.logger.b.m55a("item.category is null or empty, verfiy ClientUploadDataItem failed.");
            return true;
        } else if (TextUtils.isEmpty(hqVar.f455c)) {
            com.xiaomi.channel.commonutils.logger.b.m55a("item.name is null or empty, verfiy ClientUploadDataItem failed.");
            return true;
        } else if (!com.xiaomi.push.bf.m164a(hqVar.f456d)) {
            com.xiaomi.channel.commonutils.logger.b.m55a("item.category can only contain ascii char, verfiy ClientUploadDataItem failed.");
            return true;
        } else if (!com.xiaomi.push.bf.m164a(hqVar.f455c)) {
            com.xiaomi.channel.commonutils.logger.b.m55a("item.name can only contain ascii char, verfiy ClientUploadDataItem failed.");
            return true;
        } else if (hqVar.f454b == null || hqVar.f454b.length() <= 10240) {
            return false;
        } else {
            com.xiaomi.channel.commonutils.logger.b.m55a("item.data is too large(" + hqVar.f454b.length() + "), max size for data is 10240 , verfiy ClientUploadDataItem failed.");
            return true;
        }
    }

    public static boolean a(String str) {
        return !com.xiaomi.push.t.m589b() || Constants.HYBRID_PACKAGE_NAME.equals(str);
    }
}

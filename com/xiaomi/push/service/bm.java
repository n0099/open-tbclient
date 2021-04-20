package com.xiaomi.push.service;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.hi;
import com.xiaomi.push.hj;
import com.xiaomi.push.hp;
import com.xiaomi.push.ie;
import com.xiaomi.push.ip;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes7.dex */
public class bm {

    /* renamed from: a  reason: collision with root package name */
    public static String f41297a;

    /* renamed from: a  reason: collision with other field name */
    public static SimpleDateFormat f937a;

    /* renamed from: a  reason: collision with other field name */
    public static AtomicLong f938a = new AtomicLong(0);

    static {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        f937a = simpleDateFormat;
        f41297a = simpleDateFormat.format(Long.valueOf(System.currentTimeMillis()));
    }

    public static ie a(String str, String str2, hi hiVar) {
        return new ie("-1", false).d(str).b(str2).a(com.xiaomi.push.y.a(ip.a(hiVar))).c(hp.UploadTinyData.f506a);
    }

    public static synchronized String a() {
        String str;
        synchronized (bm.class) {
            String format = f937a.format(Long.valueOf(System.currentTimeMillis()));
            if (!TextUtils.equals(f41297a, format)) {
                f938a.set(0L);
                f41297a = format;
            }
            str = format + "-" + f938a.incrementAndGet();
        }
        return str;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0066  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static ArrayList<ie> a(List<hj> list, String str, String str2, int i) {
        int i2;
        String str3;
        if (list == null) {
            str3 = "requests can not be null in TinyDataHelper.transToThriftObj().";
        } else if (list.size() != 0) {
            ArrayList<ie> arrayList = new ArrayList<>();
            hi hiVar = new hi();
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                hj hjVar = list.get(i4);
                if (hjVar != null) {
                    if (hjVar.m361a() == null || !hjVar.m361a().containsKey("item_size")) {
                        i2 = 0;
                    } else {
                        String str4 = hjVar.m361a().get("item_size");
                        if (!TextUtils.isEmpty(str4)) {
                            try {
                                i2 = Integer.parseInt(str4);
                            } catch (Exception unused) {
                            }
                            if (hjVar.m361a().size() != 1) {
                                hjVar.a((Map<String, String>) null);
                            } else {
                                hjVar.m361a().remove("item_size");
                            }
                        }
                        i2 = 0;
                        if (hjVar.m361a().size() != 1) {
                        }
                    }
                    if (i2 <= 0) {
                        i2 = ip.a(hjVar).length;
                    }
                    if (i2 > i) {
                        com.xiaomi.channel.commonutils.logger.b.d("TinyData is too big, ignore upload request item:" + hjVar.d());
                    } else {
                        if (i3 + i2 > i) {
                            arrayList.add(a(str, str2, hiVar));
                            hiVar = new hi();
                            i3 = 0;
                        }
                        hiVar.a(hjVar);
                        i3 += i2;
                    }
                }
            }
            if (hiVar.a() != 0) {
                arrayList.add(a(str, str2, hiVar));
            }
            return arrayList;
        } else {
            str3 = "requests.length is 0 in TinyDataHelper.transToThriftObj().";
        }
        com.xiaomi.channel.commonutils.logger.b.d(str3);
        return null;
    }

    public static void a(Context context, String str, String str2, long j, String str3) {
        hj hjVar = new hj();
        hjVar.d(str);
        hjVar.c(str2);
        hjVar.a(j);
        hjVar.b(str3);
        hjVar.a("push_sdk_channel");
        hjVar.g(context.getPackageName());
        hjVar.e(context.getPackageName());
        hjVar.a(true);
        hjVar.b(System.currentTimeMillis());
        hjVar.f(a());
        bn.a(context, hjVar);
    }

    public static boolean a(hj hjVar, boolean z) {
        String str;
        if (hjVar == null) {
            str = "item is null, verfiy ClientUploadDataItem failed.";
        } else if (!z && TextUtils.isEmpty(hjVar.f478a)) {
            str = "item.channel is null or empty, verfiy ClientUploadDataItem failed.";
        } else if (TextUtils.isEmpty(hjVar.f485d)) {
            str = "item.category is null or empty, verfiy ClientUploadDataItem failed.";
        } else if (TextUtils.isEmpty(hjVar.f484c)) {
            str = "item.name is null or empty, verfiy ClientUploadDataItem failed.";
        } else if (!com.xiaomi.push.bm.m166a(hjVar.f485d)) {
            str = "item.category can only contain ascii char, verfiy ClientUploadDataItem failed.";
        } else if (com.xiaomi.push.bm.m166a(hjVar.f484c)) {
            String str2 = hjVar.f483b;
            if (str2 == null || str2.length() <= 10240) {
                return false;
            }
            str = "item.data is too large(" + hjVar.f483b.length() + "), max size for data is 10240 , verfiy ClientUploadDataItem failed.";
        } else {
            str = "item.name can only contain ascii char, verfiy ClientUploadDataItem failed.";
        }
        com.xiaomi.channel.commonutils.logger.b.m55a(str);
        return true;
    }

    public static boolean a(String str) {
        return !com.xiaomi.push.t.m626b() || Constants.HYBRID_PACKAGE_NAME.equals(str);
    }
}

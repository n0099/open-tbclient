package com.xiaomi.push.service;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.pass.biometrics.face.liveness.stat.LivenessStat;
import com.xiaomi.mipush.sdk.Constants;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes3.dex */
public class bj {
    private static AtomicLong a = new AtomicLong(0);
    private static SimpleDateFormat b = new SimpleDateFormat("yyyy/MM/dd");
    private static String c = b.format(Long.valueOf(System.currentTimeMillis()));

    public static synchronized String a() {
        String str;
        synchronized (bj.class) {
            String format = b.format(Long.valueOf(System.currentTimeMillis()));
            if (!TextUtils.equals(c, format)) {
                a.set(0L);
                c = format;
            }
            str = format + Constants.ACCEPT_TIME_SEPARATOR_SERVER + a.incrementAndGet();
        }
        return str;
    }

    public static ArrayList<com.xiaomi.xmpush.thrift.ai> a(List<com.xiaomi.xmpush.thrift.f> list, String str, String str2, int i) {
        if (list == null) {
            com.xiaomi.channel.commonutils.logger.b.d("requests can not be null in TinyDataHelper.transToThriftObj().");
            return null;
        } else if (list.size() == 0) {
            com.xiaomi.channel.commonutils.logger.b.d("requests.length is 0 in TinyDataHelper.transToThriftObj().");
            return null;
        } else {
            ArrayList<com.xiaomi.xmpush.thrift.ai> arrayList = new ArrayList<>();
            int i2 = 0;
            com.xiaomi.xmpush.thrift.e eVar = new com.xiaomi.xmpush.thrift.e();
            for (int i3 = 0; i3 < list.size(); i3++) {
                com.xiaomi.xmpush.thrift.f fVar = list.get(i3);
                if (fVar != null) {
                    int length = com.xiaomi.xmpush.thrift.at.a(fVar).length;
                    if (length > i) {
                        com.xiaomi.channel.commonutils.logger.b.d("TinyData is too big, ignore upload request item:" + fVar.m());
                    } else {
                        if (i2 + length > i) {
                            com.xiaomi.xmpush.thrift.ai aiVar = new com.xiaomi.xmpush.thrift.ai(LivenessStat.TYPE_STRING_DEFAULT, false);
                            aiVar.d(str);
                            aiVar.b(str2);
                            aiVar.c(com.xiaomi.xmpush.thrift.r.UploadTinyData.aa);
                            aiVar.a(com.xiaomi.channel.commonutils.file.b.a(com.xiaomi.xmpush.thrift.at.a(eVar)));
                            arrayList.add(aiVar);
                            eVar = new com.xiaomi.xmpush.thrift.e();
                            i2 = 0;
                        }
                        eVar.a(fVar);
                        i2 += length;
                    }
                }
            }
            if (eVar.a() != 0) {
                com.xiaomi.xmpush.thrift.ai aiVar2 = new com.xiaomi.xmpush.thrift.ai(LivenessStat.TYPE_STRING_DEFAULT, false);
                aiVar2.d(str);
                aiVar2.b(str2);
                aiVar2.c(com.xiaomi.xmpush.thrift.r.UploadTinyData.aa);
                aiVar2.a(com.xiaomi.channel.commonutils.file.b.a(com.xiaomi.xmpush.thrift.at.a(eVar)));
                arrayList.add(aiVar2);
            }
            return arrayList;
        }
    }

    public static void a(Context context, String str, String str2, long j, String str3) {
        com.xiaomi.xmpush.thrift.f fVar = new com.xiaomi.xmpush.thrift.f();
        fVar.d(str);
        fVar.c(str2);
        fVar.a(j);
        fVar.b(str3);
        fVar.a("push_sdk_channel");
        fVar.g(context.getPackageName());
        fVar.e(context.getPackageName());
        fVar.c(true);
        fVar.b(System.currentTimeMillis());
        fVar.f(a());
        bk.a(context, fVar);
    }

    public static boolean a(com.xiaomi.xmpush.thrift.f fVar, boolean z) {
        if (fVar == null) {
            com.xiaomi.channel.commonutils.logger.b.a("item is null, verfiy ClientUploadDataItem failed.");
            return true;
        } else if (!z && TextUtils.isEmpty(fVar.a)) {
            com.xiaomi.channel.commonutils.logger.b.a("item.channel is null or empty, verfiy ClientUploadDataItem failed.");
            return true;
        } else if (TextUtils.isEmpty(fVar.g)) {
            com.xiaomi.channel.commonutils.logger.b.a("item.category is null or empty, verfiy ClientUploadDataItem failed.");
            return true;
        } else if (TextUtils.isEmpty(fVar.c)) {
            com.xiaomi.channel.commonutils.logger.b.a("item.name is null or empty, verfiy ClientUploadDataItem failed.");
            return true;
        } else if (!com.xiaomi.channel.commonutils.string.d.d(fVar.g)) {
            com.xiaomi.channel.commonutils.logger.b.a("item.category can only contain ascii char, verfiy ClientUploadDataItem failed.");
            return true;
        } else if (!com.xiaomi.channel.commonutils.string.d.d(fVar.c)) {
            com.xiaomi.channel.commonutils.logger.b.a("item.name can only contain ascii char, verfiy ClientUploadDataItem failed.");
            return true;
        } else if (fVar.b == null || fVar.b.length() <= 10240) {
            return false;
        } else {
            com.xiaomi.channel.commonutils.logger.b.a("item.data is too large(" + fVar.b.length() + "), max size for data is 10240 , verfiy ClientUploadDataItem failed.");
            return true;
        }
    }
}

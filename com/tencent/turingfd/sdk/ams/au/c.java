package com.tencent.turingfd.sdk.ams.au;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.text.TextUtils;
import com.baidu.appsearchlib.Info;
import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.tencent.turingfd.sdk.ams.au.ap;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final String f13817a = ab.a("turingfd_conf_").append(af.f13767a).append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS).append("auMini").toString();

    /* renamed from: b  reason: collision with root package name */
    public Handler f13818b;

    /* loaded from: classes4.dex */
    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f13819a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Map f13820b;

        public a(Context context, Map map) {
            this.f13819a = context;
            this.f13820b = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.a(this.f13819a, this.f13820b);
        }
    }

    public c(Handler handler) {
        this.f13818b = handler;
    }

    public static long a(Context context) {
        try {
            return Long.valueOf(a(context, TbEnum.SystemMessage.EVENT_ID_OFFLINE_DEBUG)).longValue();
        } catch (Throwable th) {
            return 0L;
        }
    }

    public static String a(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(f13817a, 0);
        if (sharedPreferences == null) {
            return "";
        }
        String string = sharedPreferences.getString(str, "");
        if (TextUtils.isEmpty(string)) {
            return string;
        }
        try {
            int length = string.length() / 2;
            byte[] bArr = new byte[length];
            char[] charArray = string.toUpperCase().toCharArray();
            for (int i = 0; i < length; i++) {
                int i2 = i * 2;
                bArr[i] = (byte) (((byte) "0123456789ABCDEF".indexOf(charArray[i2 + 1])) | (((byte) "0123456789ABCDEF".indexOf(charArray[i2])) << 4));
            }
            return new String(aj.b(bArr, aj.b()), "UTF-8");
        } catch (Throwable th) {
            return "";
        }
    }

    public ae<Long> a(Context context, int i) {
        System.currentTimeMillis();
        ae<Long> aeVar = new ae<>(i);
        for (String str : a(context, TbEnum.SystemMessage.EVENT_ID_PASSED_FRIEND).split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS)) {
            try {
                aeVar.a(Long.valueOf(Long.valueOf(str).longValue()));
            } catch (NumberFormatException e) {
            }
        }
        return aeVar;
    }

    public void a(Context context, long j) {
        a(context, TbEnum.SystemMessage.EVENT_ID_DISMISS_GROUP, "" + j, true);
        a(context, "108", "" + (System.currentTimeMillis() / 1000), true);
    }

    public void a(Context context, long j, int i) {
        a(context, "203", "" + j + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + i);
    }

    public void a(Context context, ae<Long> aeVar) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < aeVar.a(); i++) {
            sb.append(aeVar.f13766b.get(i));
            if (i != aeVar.a() - 1) {
                sb.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
            }
        }
        a(context, TbEnum.SystemMessage.EVENT_ID_PASSED_FRIEND, sb.toString(), true);
    }

    public void a(Context context, ap apVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("101", apVar.f13784b);
        hashMap.put(TbEnum.SystemMessage.EVENT_ID_NOTICE_MODIFY, "" + apVar.c);
        if (!TextUtils.isEmpty(apVar.e)) {
            hashMap.put(TbEnum.SystemMessage.EVENT_ID_GROUP_UPGRADE, apVar.e);
        }
        if (!TextUtils.isEmpty(apVar.f)) {
            hashMap.put(TbEnum.SystemMessage.EVENT_ID_GROUP_JOIN, apVar.f);
        }
        if (!TextUtils.isEmpty(apVar.g)) {
            hashMap.put(TbEnum.SystemMessage.EVENT_ID_GROUP_QUIT, apVar.g);
        }
        if (!TextUtils.isEmpty(apVar.h)) {
            hashMap.put(TbEnum.SystemMessage.EVENT_ID_COMMON, apVar.h);
        }
        a(context, (Map<String, String>) hashMap, true);
    }

    public final void a(Context context, String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put(str, str2);
        a(context, (Map<String, String>) hashMap, false);
    }

    public final void a(Context context, String str, String str2, boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put(str, str2);
        a(context, hashMap, z);
    }

    public final void a(Context context, Map<String, String> map) {
        SharedPreferences.Editor edit;
        SharedPreferences sharedPreferences = context.getSharedPreferences(f13817a, 0);
        if (sharedPreferences == null || (edit = sharedPreferences.edit()) == null) {
            return;
        }
        for (String str : map.keySet()) {
            try {
                edit.putString(str, aj.d(aj.a(map.get(str).getBytes(), aj.b())));
            } catch (Throwable th) {
            }
        }
        try {
            edit.commit();
        } catch (Throwable th2) {
        }
    }

    public final void a(Context context, Map<String, String> map, boolean z) {
        if (z) {
            a(context, map);
        } else {
            this.f13818b.post(new a(context, map));
        }
    }

    public void a(Context context, boolean z) {
        a(context, "403", "" + z, true);
    }

    public ap b(Context context) {
        String a2 = a(context, "101");
        if (TextUtils.isEmpty(a2)) {
            return ap.a(1);
        }
        long j = 0;
        try {
            j = Long.valueOf(a(context, TbEnum.SystemMessage.EVENT_ID_NOTICE_MODIFY)).longValue();
        } catch (Throwable th) {
        }
        String a3 = a(context, TbEnum.SystemMessage.EVENT_ID_GROUP_UPGRADE);
        String a4 = a(context, TbEnum.SystemMessage.EVENT_ID_GROUP_JOIN);
        String a5 = a(context, TbEnum.SystemMessage.EVENT_ID_GROUP_QUIT);
        String a6 = a(context, TbEnum.SystemMessage.EVENT_ID_COMMON);
        ap.b b2 = ap.b(0);
        b2.f13786b = j;
        b2.f13785a = a2;
        b2.e = a3;
        b2.f = a4;
        b2.g = a5;
        b2.h = a6;
        return b2.a();
    }

    public void b(Context context, long j) {
        a(context, "204", "" + j);
    }

    public void b(Context context, String str) {
        a(context, "404", str, true);
    }

    public long c(Context context) {
        try {
            return Long.valueOf(a(context, TbEnum.SystemMessage.EVENT_ID_DISMISS_GROUP)).longValue();
        } catch (Throwable th) {
            return 0L;
        }
    }

    public final long c(Context context, String str) {
        try {
            return Long.valueOf(a(context, str)).longValue();
        } catch (Throwable th) {
            return 0L;
        }
    }

    public void c(Context context, long j) {
        if (j >= Long.MAX_VALUE) {
            j = Long.MAX_VALUE;
        }
        a(context, TbEnum.SystemMessage.EVENT_ID_APPLY_FRIEND, "" + j, true);
    }

    public String d(Context context) {
        return a(context, "404");
    }

    public void d(Context context, long j) {
        a(context, TbEnum.SystemMessage.EVENT_ID_INVITE_GROUP, "" + j, true);
    }

    public long e(Context context) {
        try {
            return Long.valueOf(a(context, TbEnum.SystemMessage.EVENT_ID_APPLY_FRIEND)).longValue();
        } catch (Throwable th) {
            return 0L;
        }
    }

    public void e(Context context, long j) {
        a(context, TbEnum.SystemMessage.EVENT_ID_OFFLINE_DEBUG, "" + j, true);
    }

    public long f(Context context) {
        return c(context, TbEnum.SystemMessage.EVENT_ID_INVITE_GROUP);
    }

    public String g(Context context) {
        return a(context, "203");
    }

    public String h(Context context) {
        return a(context, "202");
    }

    public String i(Context context) {
        return a(context, Info.kBaiduPIDValue);
    }

    public String j(Context context) {
        return a(context, TbEnum.SystemMessage.EVENT_ID_DELETE_FRIEND);
    }

    public boolean k(Context context) {
        String a2 = a(context, "403");
        try {
            if (TextUtils.isEmpty(a2)) {
                return true;
            }
            return Boolean.valueOf(a2).booleanValue();
        } catch (Throwable th) {
            return true;
        }
    }

    public void l(Context context) {
        a(context, TbEnum.SystemMessage.EVENT_ID_UPLOAD_STAT, ab.a("").append(System.currentTimeMillis()).toString(), true);
    }

    public String m(Context context) {
        return a(context, "205");
    }
}

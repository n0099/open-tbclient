package com.cmic.sso.sdk.a;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.cmic.sso.sdk.d.c;
import com.cmic.sso.sdk.d.g;
import com.cmic.sso.sdk.d.n;
import java.lang.reflect.Method;
import java.util.List;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static b f30314a;

    /* renamed from: b  reason: collision with root package name */
    public static long f30315b;

    /* renamed from: c  reason: collision with root package name */
    public C0345b f30316c = null;

    /* loaded from: classes5.dex */
    public static class a extends Exception {
        public a(String str) {
            super(str);
        }
    }

    /* renamed from: com.cmic.sso.sdk.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0345b {

        /* renamed from: a  reason: collision with root package name */
        public String f30317a = "";

        /* renamed from: b  reason: collision with root package name */
        public String f30318b = "";

        /* renamed from: c  reason: collision with root package name */
        public String f30319c = "";

        /* renamed from: d  reason: collision with root package name */
        public String f30320d = "";

        /* renamed from: e  reason: collision with root package name */
        public int f30321e = -1;

        /* renamed from: f  reason: collision with root package name */
        public int f30322f = -1;

        /* renamed from: g  reason: collision with root package name */
        public String f30323g = "";

        /* renamed from: h  reason: collision with root package name */
        public String f30324h = "";
        public int i = -1;
        public int j = -1;

        public int e() {
            return this.f30321e;
        }

        public int f() {
            return this.f30322f;
        }

        public int g() {
            if (TextUtils.isEmpty(this.f30320d) || TextUtils.isEmpty(this.f30319c)) {
                if (TextUtils.isEmpty(this.f30323g) || TextUtils.isEmpty(this.f30324h)) {
                    return (TextUtils.isEmpty(this.f30319c) && TextUtils.isEmpty(this.f30320d) && TextUtils.isEmpty(this.f30323g) && TextUtils.isEmpty(this.f30324h)) ? 0 : 1;
                }
                return 2;
            }
            return 2;
        }

        public String e(int i) {
            if (this.f30321e == i) {
                return this.f30319c;
            }
            return this.f30322f == i ? this.f30320d : "";
        }

        public String f(int i) {
            if (this.f30321e == i) {
                return this.f30323g;
            }
            return this.f30322f == i ? this.f30324h : "";
        }

        public String a() {
            return this.f30319c;
        }

        public String b() {
            return this.f30320d;
        }

        public void c(String str) {
            if (str != null) {
                this.f30323g = str;
            }
        }

        public void d(String str) {
            this.f30324h = str;
        }

        public void a(String str) {
            if (str != null) {
                this.f30319c = str;
            }
        }

        public void b(String str) {
            if (str != null) {
                this.f30320d = str;
            }
        }

        public String c() {
            return this.f30324h;
        }

        public int d() {
            return this.i;
        }

        public String a(int i) {
            if (this.f30321e == i) {
                return this.f30317a;
            }
            return this.f30322f == i ? this.f30318b : "";
        }

        public void b(int i) {
            this.i = i;
        }

        public void c(int i) {
            this.f30321e = i;
        }

        public void d(int i) {
            this.f30322f = i;
        }
    }

    public static b a() {
        if (f30314a == null) {
            f30314a = new b();
        }
        return f30314a;
    }

    @SuppressLint({"NewApi"})
    private void c(Context context) {
        List<SubscriptionInfo> e2;
        TelephonyManager telephonyManager = (TelephonyManager) context.getApplicationContext().getSystemService("phone");
        if (telephonyManager == null || (e2 = e(context)) == null || e2.size() <= 0) {
            return;
        }
        a(e2, telephonyManager);
        b(e2, telephonyManager);
    }

    @SuppressLint({"MissingPermission"})
    private void d(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getApplicationContext().getSystemService("phone");
        this.f30316c.c(0);
        this.f30316c.d(1);
        this.f30316c.b(-1);
        try {
            try {
                try {
                    this.f30316c.a(a(telephonyManager, "getSubscriberId", 0));
                    this.f30316c.b(a(telephonyManager, "getSubscriberId", 1));
                } catch (a unused) {
                    this.f30316c.a(telephonyManager.getSubscriberId());
                }
            } catch (a unused2) {
                this.f30316c.a(a(telephonyManager, "getSubscriberIdGemini", 0));
                this.f30316c.b(a(telephonyManager, "getSubscriberIdGemini", 1));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        try {
            try {
                this.f30316c.c(a(telephonyManager, "getSimOperator", 0));
                this.f30316c.d(a(telephonyManager, "getSimOperator", 1));
            } catch (a unused3) {
                this.f30316c.c(a(telephonyManager, "getSimOperatorGemini", 0));
                this.f30316c.d(a(telephonyManager, "getSimOperatorGemini", 1));
            }
        } catch (a unused4) {
            this.f30316c.c(telephonyManager.getSimOperator());
        }
        if (TextUtils.isEmpty(this.f30316c.a()) && !TextUtils.isEmpty(this.f30316c.b())) {
            C0345b c0345b = this.f30316c;
            c0345b.a(c0345b.b());
            this.f30316c.b("");
            C0345b c0345b2 = this.f30316c;
            c0345b2.c(c0345b2.f());
            this.f30316c.d(-1);
            C0345b c0345b3 = this.f30316c;
            c0345b3.c(c0345b3.c());
            this.f30316c.d("");
            C0345b c0345b4 = this.f30316c;
            c0345b4.b(c0345b4.e());
        } else if (!TextUtils.isEmpty(this.f30316c.a()) && TextUtils.isEmpty(this.f30316c.b())) {
            this.f30316c.d(-1);
            C0345b c0345b5 = this.f30316c;
            c0345b5.b(c0345b5.e());
        } else if (TextUtils.isEmpty(this.f30316c.a()) && TextUtils.isEmpty(this.f30316c.b())) {
            this.f30316c.c(-1);
            this.f30316c.d(-1);
            this.f30316c.b(-1);
        }
    }

    @SuppressLint({"NewApi", "MissingPermission"})
    private List<SubscriptionInfo> e(Context context) {
        SubscriptionManager from = SubscriptionManager.from(context.getApplicationContext());
        if (from != null) {
            return from.getActiveSubscriptionInfoList();
        }
        return null;
    }

    @SuppressLint({"MissingPermission"})
    private int f(Context context) {
        TelephonyManager telephonyManager;
        if (!g.a(context, "android.permission.READ_PHONE_STATE") || (telephonyManager = (TelephonyManager) context.getApplicationContext().getSystemService("phone")) == null) {
            return -1;
        }
        if (n.d()) {
            try {
                Method method = telephonyManager.getClass().getMethod("getDataNetworkType", Integer.TYPE);
                StringBuilder sb = new StringBuilder();
                sb.append("data dataNetworkType defaultDataSubId = ");
                sb.append(this.f30316c.j);
                c.b("UMCTelephonyManagement", sb.toString());
                int intValue = ((Integer) method.invoke(telephonyManager, Integer.valueOf(this.f30316c.j))).intValue();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("data dataNetworkType ---------");
                sb2.append(intValue);
                c.b("UMCTelephonyManagement", sb2.toString());
                if (intValue != 0 || Build.VERSION.SDK_INT < 24) {
                    return intValue;
                }
                StringBuilder sb3 = new StringBuilder();
                sb3.append("data dataNetworkType ---->=N ");
                sb3.append(intValue);
                c.b("UMCTelephonyManagement", sb3.toString());
                return telephonyManager.getDataNetworkType();
            } catch (Exception e2) {
                c.a("UMCTelephonyManagement", "data dataNetworkType ----反射出错-----");
                e2.printStackTrace();
                return -1;
            }
        }
        return telephonyManager.getDataNetworkType();
    }

    public C0345b b() {
        C0345b c0345b = this.f30316c;
        return c0345b == null ? new C0345b() : c0345b;
    }

    private void b(Context context, boolean z) {
        if (Build.VERSION.SDK_INT < 22) {
            this.f30316c.i = -1;
            return;
        }
        SubscriptionManager from = SubscriptionManager.from(context.getApplicationContext());
        if (from != null) {
            if (z) {
                try {
                    SubscriptionInfo a2 = a(from, "getDefaultDataSubscriptionInfo", (Object[]) null);
                    if (a2 != null) {
                        this.f30316c.i = a2.getSimSlotIndex();
                        this.f30316c.j = a2.getSubscriptionId();
                        StringBuilder sb = new StringBuilder();
                        sb.append("getDefaultDataSubscriptionInfo适配成功: dataSlotId即sim_id = ");
                        sb.append(this.f30316c.i);
                        c.b("UMCTelephonyManagement", sb.toString());
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("getDefaultDataSubscriptionInfo适配成功: dataSubId = ");
                        sb2.append(this.f30316c.j);
                        c.b("UMCTelephonyManagement", sb2.toString());
                        return;
                    }
                } catch (Exception unused) {
                    c.a("UMCTelephonyManagement", "readDefaultDataSubId-->getDefaultDataSubscriptionInfo 反射出错");
                }
            }
            try {
                if (this.f30316c.i == -1 && Build.VERSION.SDK_INT >= 24) {
                    this.f30316c.j = SubscriptionManager.getDefaultDataSubscriptionId();
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("android 7.0及以上手机getDefaultDataSubscriptionId适配成功: dataSubId = ");
                    sb3.append(this.f30316c.j);
                    c.b("UMCTelephonyManagement", sb3.toString());
                    return;
                }
            } catch (Exception unused2) {
                c.a("UMCTelephonyManagement", "android 7.0及以上手机getDefaultDataSubscriptionId适配失败");
            }
            try {
                Method method = from.getClass().getMethod("getDefaultDataSubId", new Class[0]);
                if (method != null) {
                    this.f30316c.j = ((Integer) method.invoke(from, new Object[0])).intValue();
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("android 7.0以下手机getDefaultDataSubId适配成功: dataSubId = ");
                    sb4.append(this.f30316c.j);
                    c.b("UMCTelephonyManagement", sb4.toString());
                    return;
                }
            } catch (Exception unused3) {
                c.a("UMCTelephonyManagement", "readDefaultDataSubId-->getDefaultDataSubId 反射出错");
            }
            try {
                Method method2 = from.getClass().getMethod("getDefaultDataSubscriptionId", new Class[0]);
                if (method2 != null) {
                    this.f30316c.j = ((Integer) method2.invoke(from, new Object[0])).intValue();
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("反射getDefaultDataSubscriptionId适配成功: dataSubId = ");
                    sb5.append(this.f30316c.j);
                    c.b("UMCTelephonyManagement", sb5.toString());
                }
            } catch (Exception unused4) {
                c.a("UMCTelephonyManagement", "getDefaultDataSubscriptionId-->getDefaultDataSubscriptionId 反射出错");
            }
        }
    }

    public void a(Context context, boolean z) {
        if (System.currentTimeMillis() - f30315b < 5000) {
            return;
        }
        this.f30316c = new C0345b();
        if (n.a(context)) {
            b(context, z);
            if (n.e() && n.d()) {
                c.b("UMCTelephonyManagement", "华为手机兼容性处理");
                if (this.f30316c.j == 0 || this.f30316c.j == 1) {
                    C0345b c0345b = this.f30316c;
                    c0345b.i = c0345b.j;
                }
            }
            if (z) {
                try {
                    if (Build.VERSION.SDK_INT >= 22) {
                        c(context);
                    } else {
                        d(context);
                    }
                } catch (Exception unused) {
                    c.a("UMCTelephonyManagement", "read sim info error");
                }
            }
            if (Build.VERSION.SDK_INT >= 21) {
                b(context);
            }
            f30315b = System.currentTimeMillis();
        }
    }

    private String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        c.b("UMCTelephonyManagement", "operatorChina = " + str);
        return str.contains("中国移动") ? "46000" : str.contains("中国联通") ? "46001" : str.contains("中国电信") ? "46003" : "";
    }

    @SuppressLint({"NewApi", "MissingPermission"})
    private void a(List<SubscriptionInfo> list, TelephonyManager telephonyManager) {
        SubscriptionInfo a2;
        int size = list != null ? list.size() : 0;
        if (size == 1) {
            a2 = list.get(0);
        } else if (size <= 1) {
            return;
        } else {
            a2 = a(list, 0);
        }
        this.f30316c.f30317a = a2.getIccId();
        this.f30316c.c(a2.getSimSlotIndex());
        C0345b c0345b = this.f30316c;
        c0345b.f30323g = b(c0345b.f30317a);
        c.b("UMCTelephonyManagement", "readSim1Info1 iccid1 = " + this.f30316c.f30317a);
        if (this.f30316c.i == -1 && this.f30316c.j == a2.getSubscriptionId()) {
            this.f30316c.i = a2.getSimSlotIndex();
            c.b("UMCTelephonyManagement", "readSim1Info1 dataSlotId = " + this.f30316c.i);
        }
        if (n.d()) {
            int simSlotIndex = com.cmic.sso.sdk.a.a.a() == 0 ? a2.getSimSlotIndex() : a2.getSubscriptionId();
            try {
                try {
                    try {
                        this.f30316c.a(a(telephonyManager, "getSubscriberId", a2.getSubscriptionId()));
                    } catch (a unused) {
                        this.f30316c.a(telephonyManager.getSubscriberId());
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } catch (a unused2) {
                this.f30316c.a(a(telephonyManager, "getSubscriberIdGemini", simSlotIndex));
            }
            try {
                try {
                    this.f30316c.c(a(telephonyManager, "getSimOperator", a2.getSubscriptionId()));
                } catch (a unused3) {
                    this.f30316c.c(a(telephonyManager, "getSimOperatorGemini", simSlotIndex));
                }
            } catch (a unused4) {
                this.f30316c.c(telephonyManager.getSimOperator());
            }
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x025d, code lost:
        if (r12 != null) goto L108;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x0267, code lost:
        if (r12 == null) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x0269, code lost:
        r12.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x026c, code lost:
        com.cmic.sso.sdk.d.c.b("UMCTelephonyManagement", "readSimInfoDbEnd");
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x0271, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b(Context context) {
        c.b("UMCTelephonyManagement", "readSimInfoDbStart");
        Uri parse = Uri.parse("content://telephony/siminfo");
        ContentResolver contentResolver = context.getContentResolver();
        Cursor cursor = null;
        try {
            try {
                cursor = contentResolver.query(parse, new String[]{"_id", "icc_id", "sim_id", "mcc", "mnc", "carrier_name"}, "sim_id>=?", new String[]{"0"}, null);
                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        String string = cursor.getString(cursor.getColumnIndex("icc_id"));
                        int i = cursor.getInt(cursor.getColumnIndex("sim_id"));
                        int i2 = cursor.getInt(cursor.getColumnIndex("_id"));
                        String string2 = cursor.getString(cursor.getColumnIndex("mcc"));
                        String string3 = cursor.getString(cursor.getColumnIndex("mnc"));
                        String string4 = cursor.getString(cursor.getColumnIndex("carrier_name"));
                        if (this.f30316c.i == -1 && this.f30316c.j != -1 && this.f30316c.j == i2) {
                            this.f30316c.i = i;
                            StringBuilder sb = new StringBuilder();
                            sb.append("通过读取sim db获取数据流量卡的卡槽值：");
                            sb.append(i);
                            c.b("UMCTelephonyManagement", sb.toString());
                        }
                        if (this.f30316c.i == i && !n.e()) {
                            this.f30316c.j = i2;
                        }
                        if (i == 0) {
                            this.f30316c.f30317a = string;
                            if (this.f30316c.f30321e == -1) {
                                this.f30316c.f30321e = i;
                            }
                            if (TextUtils.isEmpty(this.f30316c.f30323g) && !TextUtils.isEmpty(string4)) {
                                String a2 = a(string4);
                                if (!TextUtils.isEmpty(a2)) {
                                    this.f30316c.f30323g = a2;
                                }
                            }
                            if (TextUtils.isEmpty(this.f30316c.f30323g)) {
                                String b2 = b(string);
                                if (!TextUtils.isEmpty(b2)) {
                                    this.f30316c.f30323g = b2;
                                }
                            }
                            if (TextUtils.isEmpty(this.f30316c.f30323g) && !TextUtils.isEmpty(string2) && !TextUtils.isEmpty(string3)) {
                                if (string3.length() == 1) {
                                    string3 = "0" + string3;
                                }
                                this.f30316c.f30323g = string2 + string3;
                            }
                        } else if (i == 1) {
                            this.f30316c.f30318b = string;
                            if (this.f30316c.f30322f == -1) {
                                this.f30316c.f30322f = i;
                            }
                            if (TextUtils.isEmpty(this.f30316c.f30324h) && !TextUtils.isEmpty(string4)) {
                                String a3 = a(string4);
                                if (!TextUtils.isEmpty(a3)) {
                                    this.f30316c.f30324h = a3;
                                }
                            }
                            if (TextUtils.isEmpty(this.f30316c.f30324h)) {
                                String b3 = b(string);
                                if (!TextUtils.isEmpty(b3)) {
                                    this.f30316c.f30324h = b3;
                                }
                            }
                            if (TextUtils.isEmpty(this.f30316c.f30324h) && !TextUtils.isEmpty(string2) && !TextUtils.isEmpty(string3)) {
                                if (string3.length() == 1) {
                                    string3 = "0" + string3;
                                }
                                this.f30316c.f30324h = string2 + string3;
                            }
                        }
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("icc_id-->");
                        sb2.append(string);
                        c.b("UMCTelephonyManagement", sb2.toString());
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("sim_id-->");
                        sb3.append(i);
                        c.b("UMCTelephonyManagement", sb3.toString());
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append("subId或者说是_id->");
                        sb4.append(i2);
                        c.b("UMCTelephonyManagement", sb4.toString());
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("mcc_string--->");
                        sb5.append(string3);
                        c.b("UMCTelephonyManagement", sb5.toString());
                        StringBuilder sb6 = new StringBuilder();
                        sb6.append("mnc_string--->");
                        sb6.append(string2);
                        c.b("UMCTelephonyManagement", sb6.toString());
                        StringBuilder sb7 = new StringBuilder();
                        sb7.append("carrier_name----->");
                        sb7.append(string4);
                        c.b("UMCTelephonyManagement", sb7.toString());
                        c.b("UMCTelephonyManagement", "---------------------------------");
                    }
                }
            } catch (Exception unused) {
                c.a("UMCTelephonyManagement", "readSimInfoDb error");
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    @SuppressLint({"NewApi"})
    private SubscriptionInfo a(List<SubscriptionInfo> list, int i) {
        SubscriptionInfo subscriptionInfo = list.get(0);
        for (SubscriptionInfo subscriptionInfo2 : list) {
            if (subscriptionInfo2.getSimSlotIndex() == i) {
                subscriptionInfo = subscriptionInfo2;
            }
        }
        return subscriptionInfo;
    }

    private String a(TelephonyManager telephonyManager, String str, int i) {
        Object a2 = a(telephonyManager, str, new Object[]{Integer.valueOf(i)}, new Class[]{Integer.TYPE});
        if (a2 != null) {
            return a2.toString();
        }
        return null;
    }

    @SuppressLint({"NewApi"})
    private SubscriptionInfo a(Object obj, String str, Object[] objArr) {
        return (SubscriptionInfo) a(obj, str, objArr, null);
    }

    private Object a(Object obj, String str, Object[] objArr, Class[] clsArr) {
        try {
            Class<?> cls = Class.forName(obj.getClass().getName());
            if (objArr != null && clsArr != null) {
                return cls.getMethod(str, clsArr).invoke(obj, objArr);
            }
            return cls.getMethod(str, new Class[0]).invoke(obj, new Object[0]);
        } catch (Exception unused) {
            c.a("UMCTelephonyManagement", str + " 反射出错");
            throw new a(str);
        }
    }

    public String a(Context context) {
        switch (f(context)) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
            case 16:
                return "1";
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
            case 17:
                return "2";
            case 13:
            case 18:
            case 19:
                return "3";
            case 20:
                return "4";
            default:
                return "0";
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x008b, code lost:
        if (r7.equals("898609") != false) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String b(String str) {
        char c2 = 6;
        if (!TextUtils.isEmpty(str) || str.length() >= 6) {
            String substring = str.substring(0, 6);
            c.b("UMCTelephonyManagement", "operatorFlag = " + substring);
            int hashCode = substring.hashCode();
            if (hashCode == 1657594885) {
                if (substring.equals("898606")) {
                    c2 = 5;
                }
                c2 = 65535;
            } else if (hashCode == 1657594886) {
                if (substring.equals("898607")) {
                    c2 = 3;
                }
                c2 = 65535;
            } else if (hashCode != 1657594888) {
                if (hashCode != 1657594911) {
                    switch (hashCode) {
                        case 1657594879:
                            if (substring.equals("898600")) {
                                c2 = 0;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 1657594880:
                            if (substring.equals("898601")) {
                                c2 = 4;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 1657594881:
                            if (substring.equals("898602")) {
                                c2 = 1;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 1657594882:
                            if (substring.equals("898603")) {
                                c2 = 7;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 1657594883:
                            if (substring.equals("898604")) {
                                c2 = 2;
                                break;
                            }
                            c2 = 65535;
                            break;
                        default:
                            c2 = 65535;
                            break;
                    }
                } else {
                    if (substring.equals("898611")) {
                        c2 = '\b';
                    }
                    c2 = 65535;
                }
            }
            switch (c2) {
                case 0:
                case 1:
                case 2:
                case 3:
                    return "46000";
                case 4:
                case 5:
                case 6:
                    return "46001";
                case 7:
                case '\b':
                    return "46003";
                default:
                    return "";
            }
        }
        return "";
    }

    @SuppressLint({"NewApi"})
    private void b(List<SubscriptionInfo> list, TelephonyManager telephonyManager) {
        if ((list != null ? list.size() : 0) > 1) {
            SubscriptionInfo a2 = a(list, 1);
            this.f30316c.d(a2.getSimSlotIndex());
            this.f30316c.f30318b = a2.getIccId();
            C0345b c0345b = this.f30316c;
            c0345b.f30324h = b(c0345b.f30318b);
            c.b("UMCTelephonyManagement", "readSim1Info2 iccid2 = " + this.f30316c.f30318b);
            if (this.f30316c.i == -1 && this.f30316c.j == a2.getSubscriptionId()) {
                this.f30316c.i = a2.getSimSlotIndex();
                c.b("UMCTelephonyManagement", "readSim1Info2 dataSlotId = " + this.f30316c.i);
            }
            if (n.d()) {
                int subscriptionId = com.cmic.sso.sdk.a.a.a() != 0 ? a2.getSubscriptionId() : 1;
                try {
                    try {
                        this.f30316c.b(a(telephonyManager, "getSubscriberId", a2.getSubscriptionId()));
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                } catch (a unused) {
                    this.f30316c.b(a(telephonyManager, "getSubscriberIdGemini", subscriptionId));
                }
                try {
                    try {
                        this.f30316c.d(a(telephonyManager, "getSimOperator", a2.getSubscriptionId()));
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                } catch (a unused2) {
                    this.f30316c.d(a(telephonyManager, "getSimOperatorGemini", subscriptionId));
                }
            }
        }
    }
}

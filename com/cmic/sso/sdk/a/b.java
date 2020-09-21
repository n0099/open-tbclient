package com.cmic.sso.sdk.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.baidu.android.imsdk.IMConstants;
import com.cmic.sso.sdk.e.c;
import com.cmic.sso.sdk.e.g;
import com.cmic.sso.sdk.e.n;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes7.dex */
public class b {
    private static long b = 0;
    private static b nsq;
    private C0853b nsr = null;

    /* loaded from: classes7.dex */
    public static class a extends Exception {
        public a(String str) {
            super(str);
        }
    }

    /* renamed from: com.cmic.sso.sdk.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0853b {
        private String a = "";
        private String b = "";
        private String c = "";
        private String d = "";
        private String e = "";
        private String f = "";
        private boolean g = false;
        private boolean h = false;
        private int i = -1;
        private int j = -1;
        private int k = -1;
        private int l = -1;
        private String m = "";
        private String n = "";
        private int o = -1;
        private int p = -1;
        private int q = -1;

        protected void a(String str) {
            if (str != null) {
                this.c = str;
            }
        }

        public String a() {
            return this.d;
        }

        protected void b(String str) {
            if (str != null) {
                this.d = str;
            }
        }

        public String b() {
            return this.e;
        }

        protected void c(String str) {
            if (str != null) {
                this.e = str;
            }
        }

        public String a(int i) {
            if (this.i == i) {
                return this.a;
            }
            if (this.j == i) {
                return this.b;
            }
            return "";
        }

        public String c() {
            return this.f;
        }

        protected void d(String str) {
            if (str != null) {
                this.f = str;
            }
        }

        protected void e(String str) {
            if (str != null) {
                this.m = str;
            }
        }

        public String d() {
            return this.n;
        }

        protected void f(String str) {
            this.n = str;
        }

        protected void a(boolean z) {
            this.g = z;
        }

        public boolean e() {
            return this.h;
        }

        protected void b(boolean z) {
            this.h = z;
        }

        public int f() {
            return this.o;
        }

        protected void b(int i) {
            this.o = i;
        }

        public int g() {
            return this.i;
        }

        protected void c(int i) {
            this.i = i;
        }

        public int h() {
            return this.j;
        }

        protected void d(int i) {
            this.j = i;
        }

        protected void e(int i) {
            this.k = i;
        }

        protected void f(int i) {
            this.l = i;
        }

        public int i() {
            if ((!TextUtils.isEmpty(this.f) && !TextUtils.isEmpty(this.e)) || (!TextUtils.isEmpty(this.m) && !TextUtils.isEmpty(this.n))) {
                return 2;
            }
            if (!TextUtils.isEmpty(this.e) || !TextUtils.isEmpty(this.f) || !TextUtils.isEmpty(this.m) || !TextUtils.isEmpty(this.n)) {
                return 1;
            }
            return 0;
        }

        public String Lo(int i) {
            if (this.i == i) {
                return this.e;
            }
            if (this.j == i) {
                return this.f;
            }
            return "";
        }

        public String Lp(int i) {
            if (this.i == i) {
                return this.c;
            }
            if (this.j == i) {
                return this.d;
            }
            return "";
        }

        public String Lq(int i) {
            if (this.i == i) {
                return this.m;
            }
            if (this.j == i) {
                return this.n;
            }
            return "";
        }
    }

    private b() {
    }

    public static b dRm() {
        if (nsq == null) {
            nsq = new b();
        }
        return nsq;
    }

    public C0853b dRn() {
        return this.nsr == null ? new C0853b() : this.nsr;
    }

    public void a(Context context, boolean z) {
        if (System.currentTimeMillis() - b >= 5000) {
            this.nsr = new C0853b();
            if (n.a(context)) {
                b(context, z);
                if (n.e() && n.d()) {
                    c.b("UMCTelephonyManagement", "华为手机兼容性处理");
                    if (this.nsr.p == 0 || this.nsr.p == 1) {
                        this.nsr.o = this.nsr.p;
                    }
                }
                if (z) {
                    try {
                        if (Build.VERSION.SDK_INT >= 22) {
                            c(context);
                        } else {
                            d(context);
                        }
                    } catch (Exception e) {
                        c.a("UMCTelephonyManagement", "read sim info error");
                    }
                }
                if (Build.VERSION.SDK_INT >= 21) {
                    b(context);
                }
                b = System.currentTimeMillis();
            }
        }
    }

    private void b(Context context, boolean z) {
        if (Build.VERSION.SDK_INT < 22) {
            this.nsr.o = -1;
            return;
        }
        SubscriptionManager from = SubscriptionManager.from(context.getApplicationContext());
        if (from != null) {
            if (z) {
                try {
                    SubscriptionInfo c = c(from, "getDefaultDataSubscriptionInfo", null);
                    if (c != null) {
                        this.nsr.o = c.getSimSlotIndex();
                        this.nsr.p = c.getSubscriptionId();
                        c.b("UMCTelephonyManagement", "getDefaultDataSubscriptionInfo适配成功: dataSlotId即sim_id = " + this.nsr.o);
                        c.b("UMCTelephonyManagement", "getDefaultDataSubscriptionInfo适配成功: dataSubId = " + this.nsr.p);
                        return;
                    }
                } catch (Exception e) {
                    c.a("UMCTelephonyManagement", "readDefaultDataSubId-->getDefaultDataSubscriptionInfo 反射出错");
                }
            }
            try {
                if (this.nsr.o == -1 && Build.VERSION.SDK_INT >= 24) {
                    this.nsr.p = SubscriptionManager.getDefaultDataSubscriptionId();
                    c.b("UMCTelephonyManagement", "android 7.0及以上手机getDefaultDataSubscriptionId适配成功: dataSubId = " + this.nsr.p);
                    return;
                }
            } catch (Exception e2) {
                c.a("UMCTelephonyManagement", "android 7.0及以上手机getDefaultDataSubscriptionId适配失败");
            }
            try {
                Method method = from.getClass().getMethod("getDefaultDataSubId", new Class[0]);
                if (method != null) {
                    this.nsr.p = ((Integer) method.invoke(from, new Object[0])).intValue();
                    c.b("UMCTelephonyManagement", "android 7.0以下手机getDefaultDataSubId适配成功: dataSubId = " + this.nsr.p);
                    return;
                }
            } catch (Exception e3) {
                c.a("UMCTelephonyManagement", "readDefaultDataSubId-->getDefaultDataSubId 反射出错");
            }
            try {
                Method method2 = from.getClass().getMethod("getDefaultDataSubscriptionId", new Class[0]);
                if (method2 != null) {
                    this.nsr.p = ((Integer) method2.invoke(from, new Object[0])).intValue();
                    c.b("UMCTelephonyManagement", "反射getDefaultDataSubscriptionId适配成功: dataSubId = " + this.nsr.p);
                }
            } catch (Exception e4) {
                c.a("UMCTelephonyManagement", "getDefaultDataSubscriptionId-->getDefaultDataSubscriptionId 反射出错");
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [647=4] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x02e4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b(Context context) {
        Cursor cursor;
        Cursor cursor2 = null;
        c.b("UMCTelephonyManagement", "readSimInfoDbStart");
        try {
            cursor = context.getContentResolver().query(Uri.parse("content://telephony/siminfo"), new String[]{IMConstants.MSG_ROW_ID, "icc_id", "sim_id", "mcc", "mnc", "carrier_name"}, "sim_id>=?", new String[]{"0"}, null);
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    try {
                        try {
                            String string = cursor.getString(cursor.getColumnIndex("icc_id"));
                            int i = cursor.getInt(cursor.getColumnIndex("sim_id"));
                            int i2 = cursor.getInt(cursor.getColumnIndex(IMConstants.MSG_ROW_ID));
                            String string2 = cursor.getString(cursor.getColumnIndex("mcc"));
                            String string3 = cursor.getString(cursor.getColumnIndex("mnc"));
                            String string4 = cursor.getString(cursor.getColumnIndex("carrier_name"));
                            if (this.nsr.o == -1 && this.nsr.p != -1 && this.nsr.p == i2) {
                                this.nsr.o = i;
                                c.b("UMCTelephonyManagement", "通过读取sim db获取数据流量卡的卡槽值：" + i);
                            }
                            if (this.nsr.o == i && !n.e()) {
                                this.nsr.p = i2;
                            }
                            if (i == 0) {
                                this.nsr.a = string;
                                this.nsr.k = i2;
                                if (this.nsr.i == -1) {
                                    this.nsr.i = i;
                                }
                                if (TextUtils.isEmpty(this.nsr.m) && !TextUtils.isEmpty(string4)) {
                                    String a2 = a(string4);
                                    if (!TextUtils.isEmpty(a2)) {
                                        this.nsr.m = a2;
                                    }
                                }
                                if (TextUtils.isEmpty(this.nsr.m)) {
                                    String b2 = b(string);
                                    if (!TextUtils.isEmpty(b2)) {
                                        this.nsr.m = b2;
                                    }
                                }
                                if (TextUtils.isEmpty(this.nsr.m) && !TextUtils.isEmpty(string2) && !TextUtils.isEmpty(string3)) {
                                    if (string3.length() == 1) {
                                        string3 = "0" + string3;
                                    }
                                    this.nsr.m = string2 + string3;
                                }
                            } else if (i == 1) {
                                this.nsr.b = string;
                                this.nsr.l = i2;
                                if (this.nsr.j == -1) {
                                    this.nsr.j = i;
                                }
                                if (TextUtils.isEmpty(this.nsr.n) && !TextUtils.isEmpty(string4)) {
                                    String a3 = a(string4);
                                    if (!TextUtils.isEmpty(a3)) {
                                        this.nsr.n = a3;
                                    }
                                }
                                if (TextUtils.isEmpty(this.nsr.n)) {
                                    String b3 = b(string);
                                    if (!TextUtils.isEmpty(b3)) {
                                        this.nsr.n = b3;
                                    }
                                }
                                if (TextUtils.isEmpty(this.nsr.n) && !TextUtils.isEmpty(string2) && !TextUtils.isEmpty(string3)) {
                                    if (string3.length() == 1) {
                                        string3 = "0" + string3;
                                    }
                                    this.nsr.n = string2 + string3;
                                }
                            }
                            c.b("UMCTelephonyManagement", "icc_id-->" + string);
                            c.b("UMCTelephonyManagement", "sim_id-->" + i);
                            c.b("UMCTelephonyManagement", "subId或者说是_id->" + i2);
                            c.b("UMCTelephonyManagement", "mcc_string--->" + string3);
                            c.b("UMCTelephonyManagement", "mnc_string--->" + string2);
                            c.b("UMCTelephonyManagement", "carrier_name----->" + string4);
                            c.b("UMCTelephonyManagement", "---------------------------------");
                        } catch (Exception e) {
                            c.a("UMCTelephonyManagement", "readSimInfoDb error");
                            if (cursor != null) {
                                cursor.close();
                            }
                            c.b("UMCTelephonyManagement", "readSimInfoDbEnd");
                        }
                    } catch (Throwable th) {
                        cursor2 = cursor;
                        th = th;
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        throw th;
                    }
                }
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (Exception e2) {
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            if (cursor2 != null) {
            }
            throw th;
        }
        c.b("UMCTelephonyManagement", "readSimInfoDbEnd");
    }

    private String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        c.b("UMCTelephonyManagement", "operatorChina = " + str);
        if (str.contains("中国移动")) {
            return "46000";
        }
        if (str.contains("中国联通")) {
            return "46001";
        }
        if (str.contains("中国电信")) {
            return "46003";
        }
        return "";
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0047, code lost:
        if (r3.equals("898600") != false) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String b(String str) {
        char c = 0;
        if (TextUtils.isEmpty(str) && str.length() < 6) {
            return "";
        }
        String substring = str.substring(0, 6);
        c.b("UMCTelephonyManagement", "operatorFlag = " + substring);
        switch (substring.hashCode()) {
            case 1657594879:
                break;
            case 1657594880:
                if (substring.equals("898601")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 1657594881:
                if (substring.equals("898602")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 1657594882:
                if (substring.equals("898603")) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case 1657594883:
                if (substring.equals("898604")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 1657594885:
                if (substring.equals("898606")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case 1657594886:
                if (substring.equals("898607")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 1657594888:
                if (substring.equals("898609")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case 1657594911:
                if (substring.equals("898611")) {
                    c = '\b';
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
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

    @SuppressLint({"NewApi"})
    private void c(Context context) {
        List<SubscriptionInfo> gq;
        TelephonyManager telephonyManager = (TelephonyManager) context.getApplicationContext().getSystemService("phone");
        if (telephonyManager != null && (gq = gq(context)) != null && gq.size() > 0) {
            a(gq, telephonyManager);
            b(gq, telephonyManager);
        }
    }

    @SuppressLint({"MissingPermission"})
    private void d(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getApplicationContext().getSystemService("phone");
        this.nsr.c(0);
        this.nsr.d(1);
        this.nsr.b(-1);
        try {
            this.nsr.c(a(telephonyManager, "getSubscriberId", 0));
            this.nsr.d(a(telephonyManager, "getSubscriberId", 1));
        } catch (a e) {
            try {
                this.nsr.c(a(telephonyManager, "getSubscriberIdGemini", 0));
                this.nsr.d(a(telephonyManager, "getSubscriberIdGemini", 1));
            } catch (a e2) {
                try {
                    this.nsr.c(telephonyManager.getSubscriberId());
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
        }
        try {
            this.nsr.a(b(telephonyManager, "getSimState", 0));
            this.nsr.b(b(telephonyManager, "getSimState", 1));
        } catch (a e4) {
            try {
                this.nsr.a(b(telephonyManager, "getSimStateGemini", 0));
                this.nsr.b(b(telephonyManager, "getSimStateGemini", 1));
            } catch (a e5) {
                this.nsr.a(telephonyManager.getSimState() == 5);
            }
        }
        try {
            this.nsr.e(a(telephonyManager, "getSimOperator", 0));
            this.nsr.f(a(telephonyManager, "getSimOperator", 1));
        } catch (a e6) {
            try {
                this.nsr.e(a(telephonyManager, "getSimOperatorGemini", 0));
                this.nsr.f(a(telephonyManager, "getSimOperatorGemini", 1));
            } catch (a e7) {
                this.nsr.e(telephonyManager.getSimOperator());
            }
        }
        if (TextUtils.isEmpty(this.nsr.b()) && !TextUtils.isEmpty(this.nsr.c())) {
            this.nsr.a(this.nsr.a());
            this.nsr.b("");
            this.nsr.c(this.nsr.c());
            this.nsr.d("");
            this.nsr.c(this.nsr.h());
            this.nsr.d(-1);
            this.nsr.a(this.nsr.e());
            this.nsr.b(false);
            this.nsr.e(this.nsr.d());
            this.nsr.f("");
            this.nsr.b(this.nsr.g());
        } else if (!TextUtils.isEmpty(this.nsr.b()) && TextUtils.isEmpty(this.nsr.c())) {
            this.nsr.b("");
            this.nsr.b(false);
            this.nsr.d(-1);
            this.nsr.b(this.nsr.g());
        } else if (TextUtils.isEmpty(this.nsr.b()) && TextUtils.isEmpty(this.nsr.c())) {
            this.nsr.a("");
            this.nsr.b("");
            this.nsr.c(-1);
            this.nsr.d(-1);
            this.nsr.a(false);
            this.nsr.b(false);
            this.nsr.b(-1);
        }
    }

    @SuppressLint({"NewApi", "MissingPermission"})
    private void a(List<SubscriptionInfo> list, TelephonyManager telephonyManager) {
        SubscriptionInfo x;
        int size = list != null ? list.size() : 0;
        if (size == 1) {
            x = list.get(0);
        } else if (size > 1) {
            x = x(list, 0);
        } else {
            return;
        }
        this.nsr.a = x.getIccId();
        this.nsr.c(x.getSimSlotIndex());
        this.nsr.e(x.getSubscriptionId());
        this.nsr.m = b(this.nsr.a);
        c.b("UMCTelephonyManagement", "readSim1Info1 iccid1 = " + this.nsr.a);
        if (this.nsr.o == -1 && this.nsr.p == x.getSubscriptionId()) {
            this.nsr.o = x.getSimSlotIndex();
            c.b("UMCTelephonyManagement", "readSim1Info1 dataSlotId = " + this.nsr.o);
        }
        if (n.d()) {
            try {
                this.nsr.a(a(telephonyManager, "getDeviceId", x.getSimSlotIndex()));
            } catch (a e) {
                try {
                    this.nsr.a(a(telephonyManager, "getDeviceIdGemini", x.getSimSlotIndex()));
                } catch (a e2) {
                    try {
                        this.nsr.a(telephonyManager.getDeviceId());
                    } catch (Exception e3) {
                        c.a("UMCTelephonyManagement", "readSim1Info imei1 failed");
                    }
                }
            }
            int simSlotIndex = com.cmic.sso.sdk.a.a.a() == 0 ? x.getSimSlotIndex() : x.getSubscriptionId();
            try {
                this.nsr.c(a(telephonyManager, "getSubscriberId", x.getSubscriptionId()));
            } catch (a e4) {
                try {
                    this.nsr.c(a(telephonyManager, "getSubscriberIdGemini", simSlotIndex));
                } catch (a e5) {
                    try {
                        this.nsr.c(telephonyManager.getSubscriberId());
                    } catch (Exception e6) {
                        e6.printStackTrace();
                    }
                }
            }
            try {
                this.nsr.e(a(telephonyManager, "getSimOperator", x.getSubscriptionId()));
            } catch (a e7) {
                try {
                    this.nsr.e(a(telephonyManager, "getSimOperatorGemini", simSlotIndex));
                } catch (a e8) {
                    this.nsr.e(telephonyManager.getSimOperator());
                }
            }
        }
    }

    @SuppressLint({"NewApi"})
    private void b(List<SubscriptionInfo> list, TelephonyManager telephonyManager) {
        if ((list != null ? list.size() : 0) > 1) {
            SubscriptionInfo x = x(list, 1);
            this.nsr.d(x.getSimSlotIndex());
            this.nsr.f(x.getSubscriptionId());
            this.nsr.b = x.getIccId();
            this.nsr.n = b(this.nsr.b);
            c.b("UMCTelephonyManagement", "readSim1Info2 iccid2 = " + this.nsr.b);
            if (this.nsr.o == -1 && this.nsr.p == x.getSubscriptionId()) {
                this.nsr.o = x.getSimSlotIndex();
                c.b("UMCTelephonyManagement", "readSim1Info2 dataSlotId = " + this.nsr.o);
            }
            if (n.d()) {
                try {
                    this.nsr.b(a(telephonyManager, "getDeviceId", 1));
                } catch (a e) {
                    try {
                        this.nsr.b(a(telephonyManager, "getDeviceIdGemini", 1));
                    } catch (Exception e2) {
                        c.a("UMCTelephonyManagement", "readSim1Info imei2 failed");
                    }
                }
                int subscriptionId = com.cmic.sso.sdk.a.a.a() != 0 ? x.getSubscriptionId() : 1;
                try {
                    this.nsr.d(a(telephonyManager, "getSubscriberId", x.getSubscriptionId()));
                } catch (a e3) {
                    try {
                        this.nsr.d(a(telephonyManager, "getSubscriberIdGemini", subscriptionId));
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                }
                try {
                    this.nsr.f(a(telephonyManager, "getSimOperator", x.getSubscriptionId()));
                } catch (a e5) {
                    try {
                        this.nsr.f(a(telephonyManager, "getSimOperatorGemini", subscriptionId));
                    } catch (Exception e6) {
                        e6.printStackTrace();
                    }
                }
            }
        }
    }

    @SuppressLint({"NewApi"})
    private SubscriptionInfo x(List<SubscriptionInfo> list, int i) {
        SubscriptionInfo subscriptionInfo = list.get(0);
        Iterator<SubscriptionInfo> it = list.iterator();
        while (true) {
            SubscriptionInfo subscriptionInfo2 = subscriptionInfo;
            if (it.hasNext()) {
                subscriptionInfo = it.next();
                if (subscriptionInfo.getSimSlotIndex() != i) {
                    subscriptionInfo = subscriptionInfo2;
                }
            } else {
                return subscriptionInfo2;
            }
        }
    }

    @SuppressLint({"NewApi", "MissingPermission"})
    private List<SubscriptionInfo> gq(Context context) {
        SubscriptionManager from = SubscriptionManager.from(context.getApplicationContext());
        if (from == null) {
            return null;
        }
        return from.getActiveSubscriptionInfoList();
    }

    private String a(TelephonyManager telephonyManager, String str, int i) throws a {
        Object a2 = a(telephonyManager, str, new Object[]{Integer.valueOf(i)}, new Class[]{Integer.TYPE});
        if (a2 == null) {
            return null;
        }
        return a2.toString();
    }

    private boolean b(TelephonyManager telephonyManager, String str, int i) throws a {
        Object a2 = a(telephonyManager, str, new Object[]{Integer.valueOf(i)}, new Class[]{Integer.TYPE});
        return a2 != null && Integer.parseInt(a2.toString()) == 5;
    }

    @SuppressLint({"NewApi"})
    private SubscriptionInfo c(Object obj, String str, Object[] objArr) throws a {
        return (SubscriptionInfo) a(obj, str, objArr, null);
    }

    private Object a(Object obj, String str, Object[] objArr, Class[] clsArr) throws a {
        try {
            Class<?> cls = Class.forName(obj.getClass().getName());
            if (objArr != null && clsArr != null) {
                return cls.getMethod(str, clsArr).invoke(obj, objArr);
            }
            return cls.getMethod(str, new Class[0]).invoke(obj, new Object[0]);
        } catch (Exception e) {
            c.a("UMCTelephonyManagement", str + " 反射出错");
            throw new a(str);
        }
    }

    @SuppressLint({"MissingPermission"})
    private int f(Context context) {
        if (g.a(context, "android.permission.READ_PHONE_STATE")) {
            TelephonyManager telephonyManager = (TelephonyManager) context.getApplicationContext().getSystemService("phone");
            if (telephonyManager == null) {
                return -1;
            }
            if (n.d()) {
                try {
                    Method method = telephonyManager.getClass().getMethod("getDataNetworkType", Integer.TYPE);
                    c.b("UMCTelephonyManagement", "data dataNetworkType defaultDataSubId = " + this.nsr.p);
                    int intValue = ((Integer) method.invoke(telephonyManager, Integer.valueOf(this.nsr.p))).intValue();
                    c.b("UMCTelephonyManagement", "data dataNetworkType ---------" + intValue);
                    if (intValue != 0 || Build.VERSION.SDK_INT < 24) {
                        return intValue;
                    }
                    c.b("UMCTelephonyManagement", "data dataNetworkType ---->=N " + intValue);
                    return telephonyManager.getDataNetworkType();
                } catch (Exception e) {
                    c.a("UMCTelephonyManagement", "data dataNetworkType ----反射出错-----");
                    e.printStackTrace();
                }
            } else {
                return telephonyManager.getDataNetworkType();
            }
        }
        return -1;
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
}

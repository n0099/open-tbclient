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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.cmic.sso.sdk.d.c;
import com.cmic.sso.sdk.d.g;
import com.cmic.sso.sdk.d.n;
import java.lang.reflect.Method;
import java.util.List;
/* loaded from: classes11.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static b f61826a;

    /* renamed from: b  reason: collision with root package name */
    public static long f61827b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public C1852b f61828c;

    /* loaded from: classes11.dex */
    public static class a extends Exception {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str) {
            super(str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((String) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    /* renamed from: com.cmic.sso.sdk.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C1852b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f61829a;

        /* renamed from: b  reason: collision with root package name */
        public String f61830b;

        /* renamed from: c  reason: collision with root package name */
        public String f61831c;

        /* renamed from: d  reason: collision with root package name */
        public String f61832d;

        /* renamed from: e  reason: collision with root package name */
        public int f61833e;

        /* renamed from: f  reason: collision with root package name */
        public int f61834f;

        /* renamed from: g  reason: collision with root package name */
        public String f61835g;

        /* renamed from: h  reason: collision with root package name */
        public String f61836h;

        /* renamed from: i  reason: collision with root package name */
        public int f61837i;
        public int j;

        public C1852b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f61829a = "";
            this.f61830b = "";
            this.f61831c = "";
            this.f61832d = "";
            this.f61833e = -1;
            this.f61834f = -1;
            this.f61835g = "";
            this.f61836h = "";
            this.f61837i = -1;
            this.j = -1;
        }

        public int e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.j : invokeV.intValue;
        }

        public int f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f61833e : invokeV.intValue;
        }

        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f61834f : invokeV.intValue;
        }

        public int h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
                if (TextUtils.isEmpty(this.f61832d) || TextUtils.isEmpty(this.f61831c)) {
                    if (TextUtils.isEmpty(this.f61835g) || TextUtils.isEmpty(this.f61836h)) {
                        return (TextUtils.isEmpty(this.f61831c) && TextUtils.isEmpty(this.f61832d) && TextUtils.isEmpty(this.f61835g) && TextUtils.isEmpty(this.f61836h)) ? 0 : 1;
                    }
                    return 2;
                }
                return 2;
            }
            return invokeV.intValue;
        }

        public String e(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i2)) == null) {
                if (this.f61833e == i2) {
                    return this.f61831c;
                }
                return this.f61834f == i2 ? this.f61832d : "";
            }
            return (String) invokeI.objValue;
        }

        public String f(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i2)) == null) {
                if (this.f61833e == i2) {
                    return this.f61835g;
                }
                return this.f61834f == i2 ? this.f61836h : "";
            }
            return (String) invokeI.objValue;
        }

        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f61831c : (String) invokeV.objValue;
        }

        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f61832d : (String) invokeV.objValue;
        }

        public void c(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) || str == null) {
                return;
            }
            this.f61835g = str;
        }

        public void d(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
                this.f61836h = str;
            }
        }

        public void a(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || str == null) {
                return;
            }
            this.f61831c = str;
        }

        public void b(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048581, this, str) == null) || str == null) {
                return;
            }
            this.f61832d = str;
        }

        public String c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f61836h : (String) invokeV.objValue;
        }

        public int d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f61837i : invokeV.intValue;
        }

        public String a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
                if (this.f61833e == i2) {
                    return this.f61829a;
                }
                return this.f61834f == i2 ? this.f61830b : "";
            }
            return (String) invokeI.objValue;
        }

        public void b(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
                this.f61837i = i2;
            }
        }

        public void c(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
                this.f61833e = i2;
            }
        }

        public void d(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
                this.f61834f = i2;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1436909427, "Lcom/cmic/sso/sdk/a/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1436909427, "Lcom/cmic/sso/sdk/a/b;");
        }
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f61828c = null;
    }

    public static b a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (f61826a == null) {
                f61826a = new b();
            }
            return f61826a;
        }
        return (b) invokeV.objValue;
    }

    @SuppressLint({"NewApi"})
    private void c(Context context) {
        TelephonyManager telephonyManager;
        List<SubscriptionInfo> e2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65549, this, context) == null) || (telephonyManager = (TelephonyManager) context.getApplicationContext().getSystemService("phone")) == null || (e2 = e(context)) == null || e2.size() <= 0) {
            return;
        }
        a(e2, telephonyManager);
        b(e2, telephonyManager);
    }

    @SuppressLint({"MissingPermission"})
    private void d(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, this, context) == null) {
            TelephonyManager telephonyManager = (TelephonyManager) context.getApplicationContext().getSystemService("phone");
            this.f61828c.c(0);
            this.f61828c.d(1);
            this.f61828c.b(-1);
            try {
                try {
                    try {
                        this.f61828c.a(a(telephonyManager, "getSubscriberId", 0));
                        this.f61828c.b(a(telephonyManager, "getSubscriberId", 1));
                    } catch (a unused) {
                        this.f61828c.a(a(telephonyManager, "getSubscriberIdGemini", 0));
                        this.f61828c.b(a(telephonyManager, "getSubscriberIdGemini", 1));
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } catch (a unused2) {
                this.f61828c.a(telephonyManager.getSubscriberId());
            }
            try {
                try {
                    this.f61828c.c(a(telephonyManager, "getSimOperator", 0));
                    this.f61828c.d(a(telephonyManager, "getSimOperator", 1));
                } catch (a unused3) {
                    this.f61828c.c(telephonyManager.getSimOperator());
                }
            } catch (a unused4) {
                this.f61828c.c(a(telephonyManager, "getSimOperatorGemini", 0));
                this.f61828c.d(a(telephonyManager, "getSimOperatorGemini", 1));
            }
            if (TextUtils.isEmpty(this.f61828c.a()) && !TextUtils.isEmpty(this.f61828c.b())) {
                C1852b c1852b = this.f61828c;
                c1852b.a(c1852b.b());
                this.f61828c.b("");
                C1852b c1852b2 = this.f61828c;
                c1852b2.c(c1852b2.g());
                this.f61828c.d(-1);
                C1852b c1852b3 = this.f61828c;
                c1852b3.c(c1852b3.c());
                this.f61828c.d("");
                C1852b c1852b4 = this.f61828c;
                c1852b4.b(c1852b4.f());
            } else if (!TextUtils.isEmpty(this.f61828c.a()) && TextUtils.isEmpty(this.f61828c.b())) {
                this.f61828c.d(-1);
                C1852b c1852b5 = this.f61828c;
                c1852b5.b(c1852b5.f());
            } else if (TextUtils.isEmpty(this.f61828c.a()) && TextUtils.isEmpty(this.f61828c.b())) {
                this.f61828c.c(-1);
                this.f61828c.d(-1);
                this.f61828c.b(-1);
            }
        }
    }

    @SuppressLint({"NewApi", "MissingPermission"})
    private List<SubscriptionInfo> e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, this, context)) == null) {
            SubscriptionManager from = SubscriptionManager.from(context.getApplicationContext());
            if (from != null) {
                return from.getActiveSubscriptionInfoList();
            }
            return null;
        }
        return (List) invokeL.objValue;
    }

    @SuppressLint({"MissingPermission"})
    private int f(Context context) {
        InterceptResult invokeL;
        TelephonyManager telephonyManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, this, context)) == null) {
            if (!g.a(context, "android.permission.READ_PHONE_STATE") || (telephonyManager = (TelephonyManager) context.getApplicationContext().getSystemService("phone")) == null) {
                return -1;
            }
            if (n.d()) {
                try {
                    Method method = telephonyManager.getClass().getMethod("getDataNetworkType", Integer.TYPE);
                    StringBuilder sb = new StringBuilder();
                    sb.append("data dataNetworkType defaultDataSubId = ");
                    sb.append(this.f61828c.j);
                    c.b("UMCTelephonyManagement", sb.toString());
                    int intValue = ((Integer) method.invoke(telephonyManager, Integer.valueOf(this.f61828c.j))).intValue();
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
        return invokeL.intValue;
    }

    public C1852b b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            C1852b c1852b = this.f61828c;
            return c1852b == null ? new C1852b() : c1852b;
        }
        return (C1852b) invokeV.objValue;
    }

    private void b(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65547, this, context, z) == null) {
            if (Build.VERSION.SDK_INT < 22) {
                this.f61828c.f61837i = -1;
                return;
            }
            SubscriptionManager from = SubscriptionManager.from(context.getApplicationContext());
            if (from != null) {
                if (z) {
                    try {
                        SubscriptionInfo a2 = a(from, "getDefaultDataSubscriptionInfo", (Object[]) null);
                        if (a2 != null) {
                            this.f61828c.f61837i = a2.getSimSlotIndex();
                            this.f61828c.j = a2.getSubscriptionId();
                            StringBuilder sb = new StringBuilder();
                            sb.append("getDefaultDataSubscriptionInfo适配成功: dataSlotId即sim_id = ");
                            sb.append(this.f61828c.f61837i);
                            c.b("UMCTelephonyManagement", sb.toString());
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("getDefaultDataSubscriptionInfo适配成功: dataSubId = ");
                            sb2.append(this.f61828c.j);
                            c.b("UMCTelephonyManagement", sb2.toString());
                            return;
                        }
                    } catch (Exception unused) {
                        c.a("UMCTelephonyManagement", "readDefaultDataSubId-->getDefaultDataSubscriptionInfo 反射出错");
                    }
                }
                try {
                    if (this.f61828c.f61837i == -1 && Build.VERSION.SDK_INT >= 24) {
                        this.f61828c.j = SubscriptionManager.getDefaultDataSubscriptionId();
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("android 7.0及以上手机getDefaultDataSubscriptionId适配成功: dataSubId = ");
                        sb3.append(this.f61828c.j);
                        c.b("UMCTelephonyManagement", sb3.toString());
                        return;
                    }
                } catch (Exception unused2) {
                    c.a("UMCTelephonyManagement", "android 7.0及以上手机getDefaultDataSubscriptionId适配失败");
                }
                try {
                    Method method = from.getClass().getMethod("getDefaultDataSubId", new Class[0]);
                    if (method != null) {
                        this.f61828c.j = ((Integer) method.invoke(from, new Object[0])).intValue();
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append("android 7.0以下手机getDefaultDataSubId适配成功: dataSubId = ");
                        sb4.append(this.f61828c.j);
                        c.b("UMCTelephonyManagement", sb4.toString());
                        return;
                    }
                } catch (Exception unused3) {
                    c.a("UMCTelephonyManagement", "readDefaultDataSubId-->getDefaultDataSubId 反射出错");
                }
                try {
                    Method method2 = from.getClass().getMethod("getDefaultDataSubscriptionId", new Class[0]);
                    if (method2 != null) {
                        this.f61828c.j = ((Integer) method2.invoke(from, new Object[0])).intValue();
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("反射getDefaultDataSubscriptionId适配成功: dataSubId = ");
                        sb5.append(this.f61828c.j);
                        c.b("UMCTelephonyManagement", sb5.toString());
                    }
                } catch (Exception unused4) {
                    c.a("UMCTelephonyManagement", "getDefaultDataSubscriptionId-->getDefaultDataSubscriptionId 反射出错");
                }
            }
        }
    }

    public void a(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, z) == null) || System.currentTimeMillis() - f61827b < 5000) {
            return;
        }
        this.f61828c = new C1852b();
        if (n.a(context)) {
            b(context, z);
            if (n.e() && n.d()) {
                c.b("UMCTelephonyManagement", "华为手机兼容性处理");
                if (this.f61828c.j == 0 || this.f61828c.j == 1) {
                    if (this.f61828c.f61837i == -1) {
                        C1852b c1852b = this.f61828c;
                        c1852b.f61837i = c1852b.j;
                    }
                    this.f61828c.j = -1;
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
            f61827b = System.currentTimeMillis();
        }
    }

    private String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            c.b("UMCTelephonyManagement", "operatorChina = " + str);
            return str.contains("中国移动") ? "46000" : str.contains("中国联通") ? "46001" : str.contains("中国电信") ? "46003" : "";
        }
        return (String) invokeL.objValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x0261, code lost:
        if (r12 != null) goto L110;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x026b, code lost:
        if (r12 == null) goto L107;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x026d, code lost:
        r12.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x0270, code lost:
        com.cmic.sso.sdk.d.c.b("UMCTelephonyManagement", "readSimInfoDbEnd");
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x0275, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(65546, this, context) != null) {
            return;
        }
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
                        int i2 = cursor.getInt(cursor.getColumnIndex("sim_id"));
                        int i3 = cursor.getInt(cursor.getColumnIndex("_id"));
                        String string2 = cursor.getString(cursor.getColumnIndex("mcc"));
                        String string3 = cursor.getString(cursor.getColumnIndex("mnc"));
                        String string4 = cursor.getString(cursor.getColumnIndex("carrier_name"));
                        if (this.f61828c.f61837i == -1 && this.f61828c.j != -1 && this.f61828c.j == i3) {
                            this.f61828c.f61837i = i2;
                            StringBuilder sb = new StringBuilder();
                            sb.append("通过读取sim db获取数据流量卡的卡槽值：");
                            sb.append(i2);
                            c.b("UMCTelephonyManagement", sb.toString());
                        }
                        if (this.f61828c.f61837i == i2 && !n.e()) {
                            this.f61828c.j = i3;
                        }
                        if (i2 == 0) {
                            this.f61828c.f61829a = string;
                            if (this.f61828c.f61833e == -1) {
                                this.f61828c.f61833e = i2;
                            }
                            if (TextUtils.isEmpty(this.f61828c.f61835g) && !TextUtils.isEmpty(string4)) {
                                String a2 = a(string4);
                                if (!TextUtils.isEmpty(a2)) {
                                    this.f61828c.f61835g = a2;
                                }
                            }
                            if (TextUtils.isEmpty(this.f61828c.f61835g)) {
                                String b2 = b(string);
                                if (!TextUtils.isEmpty(b2)) {
                                    this.f61828c.f61835g = b2;
                                }
                            }
                            if (TextUtils.isEmpty(this.f61828c.f61835g) && !TextUtils.isEmpty(string2) && !TextUtils.isEmpty(string3)) {
                                if (string3.length() == 1) {
                                    string3 = "0" + string3;
                                }
                                this.f61828c.f61835g = string2 + string3;
                            }
                        } else if (i2 == 1) {
                            this.f61828c.f61830b = string;
                            if (this.f61828c.f61834f == -1) {
                                this.f61828c.f61834f = i2;
                            }
                            if (TextUtils.isEmpty(this.f61828c.f61836h) && !TextUtils.isEmpty(string4)) {
                                String a3 = a(string4);
                                if (!TextUtils.isEmpty(a3)) {
                                    this.f61828c.f61836h = a3;
                                }
                            }
                            if (TextUtils.isEmpty(this.f61828c.f61836h)) {
                                String b3 = b(string);
                                if (!TextUtils.isEmpty(b3)) {
                                    this.f61828c.f61836h = b3;
                                }
                            }
                            if (TextUtils.isEmpty(this.f61828c.f61836h) && !TextUtils.isEmpty(string2) && !TextUtils.isEmpty(string3)) {
                                if (string3.length() == 1) {
                                    string3 = "0" + string3;
                                }
                                this.f61828c.f61836h = string2 + string3;
                            }
                        }
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("icc_id-->");
                        sb2.append(string);
                        c.b("UMCTelephonyManagement", sb2.toString());
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("sim_id-->");
                        sb3.append(i2);
                        c.b("UMCTelephonyManagement", sb3.toString());
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append("subId或者说是_id->");
                        sb4.append(i3);
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

    @SuppressLint({"NewApi", "MissingPermission"})
    private void a(List<SubscriptionInfo> list, TelephonyManager telephonyManager) {
        SubscriptionInfo a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, this, list, telephonyManager) == null) {
            int size = list != null ? list.size() : 0;
            if (size == 1) {
                a2 = list.get(0);
            } else if (size <= 1) {
                return;
            } else {
                a2 = a(list, 0);
            }
            this.f61828c.f61829a = a2.getIccId();
            this.f61828c.c(a2.getSimSlotIndex());
            C1852b c1852b = this.f61828c;
            c1852b.f61835g = b(c1852b.f61829a);
            c.b("UMCTelephonyManagement", "readSim1Info1 iccid1 = " + this.f61828c.f61829a);
            if (this.f61828c.f61837i == -1 && this.f61828c.j == a2.getSubscriptionId()) {
                this.f61828c.f61837i = a2.getSimSlotIndex();
                c.b("UMCTelephonyManagement", "readSim1Info1 dataSlotId = " + this.f61828c.f61837i);
            }
            if (n.d()) {
                int simSlotIndex = com.cmic.sso.sdk.a.a.a() == 0 ? a2.getSimSlotIndex() : a2.getSubscriptionId();
                try {
                    try {
                        try {
                            this.f61828c.a(a(telephonyManager, "getSubscriberId", a2.getSubscriptionId()));
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    } catch (a unused) {
                        this.f61828c.a(a(telephonyManager, "getSubscriberIdGemini", simSlotIndex));
                    }
                } catch (a unused2) {
                    this.f61828c.a(telephonyManager.getSubscriberId());
                }
                try {
                    try {
                        this.f61828c.c(a(telephonyManager, "getSimOperator", a2.getSubscriptionId()));
                    } catch (a unused3) {
                        this.f61828c.c(telephonyManager.getSimOperator());
                    }
                } catch (a unused4) {
                    this.f61828c.c(a(telephonyManager, "getSimOperatorGemini", simSlotIndex));
                }
            }
        }
    }

    @SuppressLint({"NewApi"})
    private SubscriptionInfo a(List<SubscriptionInfo> list, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, this, list, i2)) == null) {
            SubscriptionInfo subscriptionInfo = list.get(0);
            for (SubscriptionInfo subscriptionInfo2 : list) {
                if (subscriptionInfo2.getSimSlotIndex() == i2) {
                    subscriptionInfo = subscriptionInfo2;
                }
            }
            return subscriptionInfo;
        }
        return (SubscriptionInfo) invokeLI.objValue;
    }

    private String a(TelephonyManager telephonyManager, String str, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(AdIconUtil.BAIDU_LOGO_ID, this, telephonyManager, str, i2)) == null) {
            Object a2 = a(telephonyManager, str, new Object[]{Integer.valueOf(i2)}, new Class[]{Integer.TYPE});
            if (a2 != null) {
                return a2.toString();
            }
            return null;
        }
        return (String) invokeLLI.objValue;
    }

    @SuppressLint({"NewApi"})
    private SubscriptionInfo a(Object obj, String str, Object[] objArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, this, obj, str, objArr)) == null) ? (SubscriptionInfo) a(obj, str, objArr, null) : (SubscriptionInfo) invokeLLL.objValue;
    }

    private Object a(Object obj, String str, Object[] objArr, Class[] clsArr) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(AdIconUtil.AD_TEXT_ID, this, obj, str, objArr, clsArr)) == null) {
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
        return invokeLLLL.objValue;
    }

    public String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
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
        return (String) invokeL.objValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0098, code lost:
        if (r7.equals("898606") != false) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, this, str)) == null) {
            char c2 = 6;
            if (!TextUtils.isEmpty(str) || str.length() >= 6) {
                String substring = str.substring(0, 6);
                c.b("UMCTelephonyManagement", "operatorFlag = " + substring);
                int hashCode = substring.hashCode();
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
                                c2 = 5;
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
                                c2 = '\b';
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
                            switch (hashCode) {
                                case 1657594885:
                                    break;
                                case 1657594886:
                                    if (substring.equals("898607")) {
                                        c2 = 3;
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                case 1657594887:
                                    if (substring.equals("898608")) {
                                        c2 = 4;
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                case 1657594888:
                                    if (substring.equals("898609")) {
                                        c2 = 7;
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                default:
                                    c2 = 65535;
                                    break;
                            }
                    }
                } else {
                    if (substring.equals("898611")) {
                        c2 = '\t';
                    }
                    c2 = 65535;
                }
                switch (c2) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                        return "46000";
                    case 5:
                    case 6:
                    case 7:
                        return "46001";
                    case '\b':
                    case '\t':
                        return "46003";
                    default:
                        return "";
                }
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    @SuppressLint({"NewApi"})
    private void b(List<SubscriptionInfo> list, TelephonyManager telephonyManager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, this, list, telephonyManager) == null) {
            if ((list != null ? list.size() : 0) > 1) {
                SubscriptionInfo a2 = a(list, 1);
                this.f61828c.d(a2.getSimSlotIndex());
                this.f61828c.f61830b = a2.getIccId();
                C1852b c1852b = this.f61828c;
                c1852b.f61836h = b(c1852b.f61830b);
                c.b("UMCTelephonyManagement", "readSim1Info2 iccid2 = " + this.f61828c.f61830b);
                if (this.f61828c.f61837i == -1 && this.f61828c.j == a2.getSubscriptionId()) {
                    this.f61828c.f61837i = a2.getSimSlotIndex();
                    c.b("UMCTelephonyManagement", "readSim1Info2 dataSlotId = " + this.f61828c.f61837i);
                }
                if (n.d()) {
                    int subscriptionId = com.cmic.sso.sdk.a.a.a() != 0 ? a2.getSubscriptionId() : 1;
                    try {
                        try {
                            this.f61828c.b(a(telephonyManager, "getSubscriberId", a2.getSubscriptionId()));
                        } catch (a unused) {
                            this.f61828c.b(a(telephonyManager, "getSubscriberIdGemini", subscriptionId));
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    try {
                        try {
                            this.f61828c.d(a(telephonyManager, "getSimOperator", a2.getSubscriptionId()));
                        } catch (a unused2) {
                            this.f61828c.d(a(telephonyManager, "getSimOperatorGemini", subscriptionId));
                        }
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                }
            }
        }
    }
}

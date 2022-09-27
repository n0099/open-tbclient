package com.cmic.sso.sdk.b;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.cmic.sso.sdk.e.c;
import com.cmic.sso.sdk.e.g;
import com.cmic.sso.sdk.e.m;
import com.kuaishou.weapon.p0.h;
import java.lang.reflect.Method;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static a a;
    public static long b;
    public transient /* synthetic */ FieldHolder $fh;
    public C0508a c;

    /* renamed from: com.cmic.sso.sdk.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0508a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public int b;

        public C0508a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = -1;
            this.b = -1;
        }

        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.b : invokeV.intValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1436879667, "Lcom/cmic/sso/sdk/b/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1436879667, "Lcom/cmic/sso/sdk/b/a;");
        }
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = null;
    }

    public static a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (a == null) {
                a = new a();
            }
            return a;
        }
        return (a) invokeV.objValue;
    }

    @SuppressLint({"MissingPermission"})
    private int c(Context context) {
        InterceptResult invokeL;
        TelephonyManager telephonyManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, this, context)) == null) {
            if (!g.a(context, h.c) || (telephonyManager = (TelephonyManager) context.getApplicationContext().getSystemService("phone")) == null) {
                return -1;
            }
            if (m.d()) {
                try {
                    Method method = telephonyManager.getClass().getMethod("getDataNetworkType", Integer.TYPE);
                    StringBuilder sb = new StringBuilder();
                    sb.append("data dataNetworkType defaultDataSubId = ");
                    sb.append(this.c.b);
                    c.b("UMCTelephonyManagement", sb.toString());
                    int intValue = ((Integer) method.invoke(telephonyManager, Integer.valueOf(this.c.b))).intValue();
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
                } catch (Exception e) {
                    c.a("UMCTelephonyManagement", "data dataNetworkType ----反射出错-----");
                    e.printStackTrace();
                    return -1;
                }
            }
            return telephonyManager.getDataNetworkType();
        }
        return invokeL.intValue;
    }

    public C0508a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            C0508a c0508a = this.c;
            return c0508a == null ? new C0508a() : c0508a;
        }
        return (C0508a) invokeV.objValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0084, code lost:
        if (r11 != null) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x008e, code lost:
        if (r11 == null) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0090, code lost:
        r11.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0093, code lost:
        com.cmic.sso.sdk.e.c.b("UMCTelephonyManagement", "readSimInfoDbEnd");
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0098, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, context) != null) {
            return;
        }
        c.b("UMCTelephonyManagement", "readSimInfoDbStart");
        Uri parse = Uri.parse("content://telephony/siminfo");
        ContentResolver contentResolver = context.getContentResolver();
        Cursor cursor = null;
        try {
            try {
                cursor = contentResolver.query(parse, new String[]{"_id", "sim_id"}, "sim_id>=?", new String[]{"0"}, null);
                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        int i = cursor.getInt(cursor.getColumnIndex("sim_id"));
                        int i2 = cursor.getInt(cursor.getColumnIndex("_id"));
                        if (this.c.a == -1 && this.c.b != -1 && this.c.b == i2) {
                            this.c.a = i;
                            StringBuilder sb = new StringBuilder();
                            sb.append("通过读取sim db获取数据流量卡的卡槽值：");
                            sb.append(i);
                            c.b("UMCTelephonyManagement", sb.toString());
                        }
                        if (this.c.a == i) {
                            this.c.b = i2;
                        }
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

    public void a(Context context, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{context, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            long currentTimeMillis = System.currentTimeMillis() - b;
            if (currentTimeMillis >= 5000 || currentTimeMillis <= 0) {
                this.c = new C0508a();
                if (z2) {
                    a(context, z);
                    if (m.e() && m.d()) {
                        c.b("UMCTelephonyManagement", "华为手机兼容性处理");
                        if (this.c.b == 0 || this.c.b == 1) {
                            if (this.c.a == -1) {
                                C0508a c0508a = this.c;
                                c0508a.a = c0508a.b;
                            }
                            this.c.b = -1;
                        }
                        if ((this.c.a != -1 || this.c.b != -1) && Build.VERSION.SDK_INT >= 21) {
                            b(context);
                        }
                    }
                    b = System.currentTimeMillis();
                }
            }
        }
    }

    private void a(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65539, this, context, z) == null) {
            if (Build.VERSION.SDK_INT < 22) {
                this.c.a = -1;
                return;
            }
            SubscriptionManager from = SubscriptionManager.from(context.getApplicationContext());
            if (from != null) {
                try {
                    if (this.c.a == -1 && Build.VERSION.SDK_INT >= 24) {
                        this.c.b = SubscriptionManager.getDefaultDataSubscriptionId();
                        StringBuilder sb = new StringBuilder();
                        sb.append("android 7.0及以上手机getDefaultDataSubscriptionId适配成功: dataSubId = ");
                        sb.append(this.c.b);
                        c.b("UMCTelephonyManagement", sb.toString());
                        return;
                    }
                } catch (Exception unused) {
                    c.a("UMCTelephonyManagement", "android 7.0及以上手机getDefaultDataSubscriptionId适配失败");
                }
                try {
                    Object invoke = from.getClass().getMethod("getDefaultDataSubId", new Class[0]).invoke(from, new Object[0]);
                    if ((invoke instanceof Integer) || (invoke instanceof Long)) {
                        this.c.b = ((Integer) invoke).intValue();
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("android 7.0以下手机getDefaultDataSubId适配成功: dataSubId = ");
                        sb2.append(this.c.b);
                        c.b("UMCTelephonyManagement", sb2.toString());
                        return;
                    }
                } catch (Exception unused2) {
                    c.a("UMCTelephonyManagement", "readDefaultDataSubId-->getDefaultDataSubId 反射出错");
                }
                try {
                    Object invoke2 = from.getClass().getMethod("getDefaultDataSubscriptionId", new Class[0]).invoke(from, new Object[0]);
                    if ((invoke2 instanceof Integer) || (invoke2 instanceof Long)) {
                        this.c.b = ((Integer) invoke2).intValue();
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("反射getDefaultDataSubscriptionId适配成功: dataSubId = ");
                        sb3.append(this.c.b);
                        c.b("UMCTelephonyManagement", sb3.toString());
                    }
                } catch (Exception unused3) {
                    c.a("UMCTelephonyManagement", "getDefaultDataSubscriptionId-->getDefaultDataSubscriptionId 反射出错");
                }
            }
        }
    }

    public String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            switch (c(context)) {
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
}

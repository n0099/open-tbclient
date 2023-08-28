package com.cmic.sso.sdk.b;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.telephony.SubscriptionManager;
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
import com.cmic.sso.sdk.e.m;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static a a;
    public static long b;
    public transient /* synthetic */ FieldHolder $fh;
    public C0581a c;

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

    /* renamed from: com.cmic.sso.sdk.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C0581a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public int b;

        public C0581a() {
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
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.b;
            }
            return invokeV.intValue;
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

    public C0581a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            C0581a c0581a = this.c;
            if (c0581a == null) {
                return new C0581a();
            }
            return c0581a;
        }
        return (C0581a) invokeV.objValue;
    }

    private void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, context) == null) {
            if (Build.VERSION.SDK_INT >= 22) {
                SubscriptionManager from = SubscriptionManager.from(context.getApplicationContext());
                if (from != null) {
                    try {
                        if (this.c.a == -1 && Build.VERSION.SDK_INT >= 24) {
                            this.c.b = SubscriptionManager.getDefaultDataSubscriptionId();
                            c.b("UMCTelephonyManagement", "android 7.0及以上手机getDefaultDataSubscriptionId适配成功: dataSubId = " + this.c.b);
                            return;
                        }
                    } catch (Exception unused) {
                        c.a("UMCTelephonyManagement", "android 7.0及以上手机getDefaultDataSubscriptionId适配失败");
                    }
                    try {
                        Object invoke = from.getClass().getMethod("getDefaultDataSubId", new Class[0]).invoke(from, new Object[0]);
                        if ((invoke instanceof Integer) || (invoke instanceof Long)) {
                            this.c.b = ((Integer) invoke).intValue();
                            c.b("UMCTelephonyManagement", "android 7.0以下手机getDefaultDataSubId适配成功: dataSubId = " + this.c.b);
                            return;
                        }
                    } catch (Exception unused2) {
                        c.a("UMCTelephonyManagement", "readDefaultDataSubId-->getDefaultDataSubId 反射出错");
                    }
                    try {
                        Object invoke2 = from.getClass().getMethod("getDefaultDataSubscriptionId", new Class[0]).invoke(from, new Object[0]);
                        if ((invoke2 instanceof Integer) || (invoke2 instanceof Long)) {
                            this.c.b = ((Integer) invoke2).intValue();
                            c.b("UMCTelephonyManagement", "反射getDefaultDataSubscriptionId适配成功: dataSubId = " + this.c.b);
                            return;
                        }
                        return;
                    } catch (Exception unused3) {
                        c.a("UMCTelephonyManagement", "getDefaultDataSubscriptionId-->getDefaultDataSubscriptionId 反射出错");
                        return;
                    }
                }
                return;
            }
            this.c.a = -1;
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0084, code lost:
        if (r11 != null) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x008c, code lost:
        if (r11 == null) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x008e, code lost:
        r11.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0091, code lost:
        com.cmic.sso.sdk.e.c.b("UMCTelephonyManagement", "readSimInfoDbEnd");
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0096, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, context) == null) {
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
                                c.b("UMCTelephonyManagement", "通过读取sim db获取数据流量卡的卡槽值：" + i);
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
    }

    public void a(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048576, this, context, z) == null) {
            long currentTimeMillis = System.currentTimeMillis() - b;
            if (currentTimeMillis < 5000 && currentTimeMillis > 0) {
                return;
            }
            this.c = new C0581a();
            if (!z) {
                return;
            }
            a(context);
            if (m.e() && m.d()) {
                c.b("UMCTelephonyManagement", "华为手机兼容性处理");
                if (this.c.b == 0 || this.c.b == 1) {
                    if (this.c.a == -1) {
                        C0581a c0581a = this.c;
                        c0581a.a = c0581a.b;
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

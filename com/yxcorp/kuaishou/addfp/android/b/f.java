package com.yxcorp.kuaishou.addfp.android.b;

import android.content.Context;
import android.os.IBinder;
import android.os.Parcel;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Field;
/* loaded from: classes4.dex */
public final class f {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static Context f61757b;
    public transient /* synthetic */ FieldHolder $fh;
    public h a;

    /* renamed from: c  reason: collision with root package name */
    public final Class f61758c;

    /* renamed from: d  reason: collision with root package name */
    public i f61759d;

    /* renamed from: e  reason: collision with root package name */
    public String[] f61760e;

    /* renamed from: f  reason: collision with root package name */
    public String[] f61761f;

    public f() {
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
        this.f61760e = null;
        this.f61761f = null;
        this.f61758c = b();
        this.a = new h(this);
        this.f61759d = new i(this);
    }

    public /* synthetic */ f(byte b2) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Parcel a(String str, String str2, Parcel parcel, Parcel parcel2) {
        InterceptResult invokeLLLL;
        Object obj;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TRACKBALL, this, str, str2, parcel, parcel2)) == null) {
            String a = a(str);
            if (a != null && str2 != null) {
                try {
                    obj = this.f61758c.getDeclaredMethod("getService", String.class).invoke(null, str);
                    try {
                        Field declaredField = Class.forName(a + "$Stub").getDeclaredField(str2);
                        declaredField.setAccessible(true);
                        i2 = declaredField.getInt(null);
                    } catch (Throwable th) {
                        th = th;
                        th.printStackTrace();
                        i2 = -1;
                        if (obj != null) {
                            try {
                                ((IBinder) obj).transact(i2, parcel, parcel2, 0);
                            } catch (Throwable th2) {
                                th2.printStackTrace();
                            }
                            return parcel2;
                        }
                        return null;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    obj = null;
                }
                if (obj != null && i2 >= 0) {
                    ((IBinder) obj).transact(i2, parcel, parcel2, 0);
                    return parcel2;
                }
            }
            return null;
        }
        return (Parcel) invokeLLLL.objValue;
    }

    public static f a(Context context) {
        InterceptResult invokeL;
        f fVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            f61757b = context;
            fVar = g.a;
            return fVar;
        }
        return (f) invokeL.objValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE, INVOKE, MOVE_EXCEPTION, INVOKE, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
    /* JADX INFO: Access modifiers changed from: private */
    public String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, this, str)) == null) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            String str2 = null;
            try {
                ((IBinder) this.f61758c.getDeclaredMethod("getService", String.class).invoke(null, str)).transact(1598968902, obtain, obtain2, 0);
                str2 = obtain2.readString();
            } finally {
                try {
                    return str2;
                } finally {
                }
            }
            return str2;
        }
        return (String) invokeL.objValue;
    }

    public static Class b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            try {
                return Class.forName("android.os.ServiceManager");
            } catch (ClassNotFoundException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (Class) invokeV.objValue;
    }
}

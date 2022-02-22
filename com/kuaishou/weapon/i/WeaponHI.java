package com.kuaishou.weapon.i;

import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.weapon.IWeaponInitParams;
import com.kuaishou.weapon.RequestCallback;
import com.kuaishou.weapon.jni.W;
import com.kuaishou.weapon.un.d;
import com.kuaishou.weapon.un.l1;
import com.kuaishou.weapon.un.n;
import com.kuaishou.weapon.un.r0;
import com.kuaishou.weapon.un.t1;
import com.kuaishou.weapon.un.x1;
import com.kuaishou.weapon.un.z1;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class WeaponHI {
    public static /* synthetic */ Interceptable $ic;
    public static RequestCallback mCallback;
    public static Context mContext;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;

        public a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            n a;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || WeaponHI.mContext == null) {
                return;
            }
            d dVar = new d(WeaponHI.mContext);
            boolean z = this.a;
            if (!z) {
                dVar.a(d.a1, Boolean.valueOf(z));
            } else if (dVar.b(d.a1)) {
            } else {
                dVar.a(d.a1, Boolean.valueOf(this.a));
                String a2 = x1.a(Process.myPid());
                if (TextUtils.isEmpty(a2)) {
                    return;
                }
                if (TextUtils.isEmpty(a2) || !a2.contains(":")) {
                    if ((TextUtils.isEmpty(a2) || a2.equals(WeaponHI.mContext.getPackageName())) && (a = n.a(WeaponHI.mContext)) != null) {
                        a.a();
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f55238b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f55239c;

        public b(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.f55238b = str2;
            this.f55239c = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            String[] a;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && !TextUtils.isEmpty(this.a) && !TextUtils.isEmpty(this.f55238b) && !TextUtils.isEmpty(this.f55239c) && (a = l1.a(WeaponHI.mContext)) != null && a.length == 2 && a[0] != null && a[1] != null && a[0].equals(this.a) && a[1].equals(this.f55238b)) {
                try {
                    if (new d(WeaponHI.mContext).a(d.g0, 0) == 0) {
                        return;
                    }
                    r0.a(this.f55239c);
                    n a2 = n.a(WeaponHI.mContext);
                    if (a2 == null) {
                        return;
                    }
                    a2.a(this.f55239c);
                } catch (Exception unused) {
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ IWeaponInitParams a;

        public c(IWeaponInitParams iWeaponInitParams) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iWeaponInitParams};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = iWeaponInitParams;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (this.a == null) {
                        return;
                    }
                    String a = x1.a(Process.myPid());
                    if (TextUtils.isEmpty(a) || !a.contains(":")) {
                        if ((TextUtils.isEmpty(a) || a.equals(WeaponHI.mContext.getPackageName())) && WeaponHI.mContext.getFilesDir().getParentFile().exists()) {
                            d dVar = new d(WeaponHI.mContext);
                            dVar.a(d.Z0, Boolean.valueOf(this.a.getPrivacySwitch()));
                            W.getInstance(WeaponHI.mContext);
                            dVar.a(0);
                            n a2 = n.a(WeaponHI.mContext);
                            if (a2 == null) {
                                return;
                            }
                            if (!TextUtils.isEmpty(this.a.getAppKey()) && !TextUtils.isEmpty(this.a.getSecKey())) {
                                a2.b(this.a.getAppKey(), this.a.getSecKey());
                                n.c(1);
                                a2.a(this.a);
                                a2.d();
                            }
                            String[] a3 = l1.a(WeaponHI.mContext);
                            if (a3 != null && a3.length == 2 && a3[0] != null && a3[1] != null) {
                                a2.b(a3[0], a3[1]);
                            }
                            n.c(1);
                            a2.a(this.a);
                            a2.d();
                        }
                    }
                } catch (Throwable th) {
                    l1.a(th);
                    HashMap hashMap = new HashMap();
                    hashMap.put("e", th.getMessage());
                    hashMap.put("l", "HI");
                    l1.a(WeaponHI.mContext, "1002001", hashMap);
                }
            }
        }
    }

    public WeaponHI() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static String getT() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            Context context = mContext;
            return context == null ? "" : z1.a(context).a();
        }
        return (String) invokeV.objValue;
    }

    public static void i(String str, String str2) {
        n a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, str, str2) == null) {
            try {
                if (p(str, str2) && (a2 = n.a(mContext)) != null) {
                    a2.e();
                }
            } catch (Throwable th) {
                l1.a(th);
                HashMap hashMap = new HashMap();
                hashMap.put("e", th.getMessage());
                hashMap.put("l", "i");
                l1.a(mContext, "1002001", hashMap);
            }
        }
    }

    public static void init(Context context, IWeaponInitParams iWeaponInitParams, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, iWeaponInitParams, str) == null) {
            try {
                mContext = context.getApplicationContext();
                t1.a().a(new c(iWeaponInitParams));
            } catch (Throwable th) {
                l1.a(th);
                HashMap hashMap = new HashMap();
                hashMap.put("e", th.getMessage());
                hashMap.put("l", "HI");
                l1.a(mContext, "1002001", hashMap);
            }
        }
    }

    public static void n(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65541, null, str, str2, str3) == null) {
            try {
                t1.a().a(new b(str, str2, str3));
            } catch (Exception unused) {
            }
        }
    }

    public static boolean p(String str, String str2) {
        InterceptResult invokeLL;
        String[] a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, str, str2)) == null) {
            if (mContext == null) {
                return false;
            }
            String a3 = x1.a(Process.myPid());
            if (TextUtils.isEmpty(a3)) {
                return false;
            }
            if (TextUtils.isEmpty(a3) || !a3.contains(":")) {
                if ((TextUtils.isEmpty(a3) || a3.equals(mContext.getPackageName())) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && (a2 = l1.a(mContext)) != null && a2.length == 2 && a2[0] != null && a2[1] != null && a2[0].equals(str)) {
                    if (a2[1].equals(str2)) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static void setPS(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65543, null, z) == null) {
            try {
                t1.a().a(new a(z));
            } catch (Exception unused) {
            }
        }
    }
}

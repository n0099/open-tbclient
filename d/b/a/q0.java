package d.b.a;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.IBinder;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.embedapplog.cb;
import d.b.a.c1;
import d.b.a.v0;
/* loaded from: classes10.dex */
public final class q0 implements v0 {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final j0<Boolean> f71742a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes10.dex */
    public static class a extends j0<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.a.j0
        /* renamed from: c */
        public Boolean a(Object... objArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, objArr)) == null) ? Boolean.valueOf(p0.b((Context) objArr[0], "com.huawei.hwid")) : (Boolean) invokeL.objValue;
        }
    }

    /* loaded from: classes10.dex */
    public static class b implements c1.b<cb, Pair<String, Boolean>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.a.c1.b
        /* renamed from: b */
        public Pair<String, Boolean> a(cb cbVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cbVar)) == null) {
                if (cbVar == null) {
                    return null;
                }
                return new Pair<>(cbVar.a(), Boolean.valueOf(cbVar.b()));
            }
            return (Pair) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.a.c1.b
        /* renamed from: c */
        public cb a(IBinder iBinder) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, iBinder)) == null) ? cb.a.a(iBinder) : (cb) invokeL.objValue;
        }
    }

    /* loaded from: classes10.dex */
    public static class c extends v0.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public long f71743c;

        public c() {
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
            this.f71743c = 0L;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(413439530, "Ld/b/a/q0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(413439530, "Ld/b/a/q0;");
                return;
            }
        }
        f71742a = new a();
    }

    public q0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static boolean c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (context == null) {
                return false;
            }
            return f71742a.b(context).booleanValue();
        }
        return invokeL.booleanValue;
    }

    public static int e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.huawei.hwid", 0);
                if (packageInfo != null) {
                    return packageInfo.versionCode;
                }
                return 0;
            } catch (Throwable th) {
                th.printStackTrace();
                return 0;
            }
        }
        return invokeL.intValue;
    }

    @Nullable
    public static Pair<String, Boolean> f(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65540, null, context)) == null) ? (Pair) new c1(context, new Intent("com.uodis.opendevice.OPENIDS_SERVICE").setPackage("com.huawei.hwid"), new b()).a() : (Pair) invokeL.objValue;
    }

    @Override // d.b.a.v0
    public boolean a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) ? c(context) : invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.a.v0
    @Nullable
    @WorkerThread
    /* renamed from: d */
    public c b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) {
            c cVar = new c();
            if (Build.VERSION.SDK_INT >= 24) {
                try {
                    String string = Settings.Global.getString(context.getContentResolver(), "pps_oaid");
                    String string2 = Settings.Global.getString(context.getContentResolver(), "pps_track_limit");
                    if (!TextUtils.isEmpty(string)) {
                        cVar.f71764a = string;
                        cVar.f71765b = Boolean.parseBoolean(string2);
                        cVar.f71743c = 202003021704L;
                        return cVar;
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            Pair<String, Boolean> f2 = f(context);
            if (f2 != null) {
                cVar.f71764a = (String) f2.first;
                cVar.f71765b = ((Boolean) f2.second).booleanValue();
                cVar.f71743c = e(context);
            }
            return cVar;
        }
        return (c) invokeL.objValue;
    }
}

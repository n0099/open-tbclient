package com.tencent.open.log;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.text.SimpleDateFormat;
/* loaded from: classes2.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static final boolean a(int i2, int i3) {
            InterceptResult invokeII;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeII = interceptable.invokeII(65536, null, i2, i3)) == null) ? i3 == (i2 & i3) : invokeII.booleanValue;
        }
    }

    /* loaded from: classes2.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
                String externalStorageState = Environment.getExternalStorageState();
                return "mounted".equals(externalStorageState) || "mounted_ro".equals(externalStorageState);
            }
            return invokeV.booleanValue;
        }

        public static c b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
                if (a()) {
                    return c.b(Environment.getExternalStorageDirectory());
                }
                return null;
            }
            return (c) invokeV.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public File f71027a;

        /* renamed from: b  reason: collision with root package name */
        public long f71028b;

        /* renamed from: c  reason: collision with root package name */
        public long f71029c;

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
                }
            }
        }

        public File a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f71027a : (File) invokeV.objValue;
        }

        public long b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f71028b : invokeV.longValue;
        }

        public long c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f71029c : invokeV.longValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? String.format("[%s : %d / %d]", a().getAbsolutePath(), Long.valueOf(c()), Long.valueOf(b())) : (String) invokeV.objValue;
        }

        public void a(File file) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, file) == null) {
                this.f71027a = file;
            }
        }

        public void b(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048580, this, j) == null) {
                this.f71029c = j;
            }
        }

        public static c b(File file) {
            InterceptResult invokeL;
            StatFs statFs;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, file)) == null) {
                c cVar = new c();
                cVar.a(file);
                long blockSize = new StatFs(file.getAbsolutePath()).getBlockSize();
                cVar.a(statFs.getBlockCount() * blockSize);
                cVar.b(statFs.getAvailableBlocks() * blockSize);
                return cVar;
            }
            return (c) invokeL.objValue;
        }

        public void a(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
                this.f71028b = j;
            }
        }
    }

    /* renamed from: com.tencent.open.log.d$d  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C2065d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @SuppressLint({"SimpleDateFormat"})
        public static SimpleDateFormat a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) ? new SimpleDateFormat(str) : (SimpleDateFormat) invokeL.objValue;
        }
    }

    public static boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) ? str.contains("access_token") || str.contains("pay_token") || str.contains("pfkey") || str.contains("expires_in") || str.contains("openid") || str.contains("proxy_code") || str.contains("proxy_expires_in") : invokeL.booleanValue;
    }

    public static Bundle b(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bundle)) == null) {
            if (a(bundle)) {
                Bundle bundle2 = new Bundle(bundle);
                bundle2.remove("access_token");
                bundle2.remove("pay_token");
                bundle2.remove("pfkey");
                bundle2.remove("expires_in");
                bundle2.remove("openid");
                bundle2.remove("proxy_code");
                bundle2.remove("proxy_expires_in");
                return bundle2;
            }
            return bundle;
        }
        return (Bundle) invokeL.objValue;
    }

    public static boolean a(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65536, null, bundle)) == null) ? bundle.containsKey("access_token") || bundle.containsKey("pay_token") || bundle.containsKey("pfkey") || bundle.containsKey("expires_in") || bundle.containsKey("openid") || bundle.containsKey("proxy_code") || bundle.containsKey("proxy_expires_in") : invokeL.booleanValue;
    }
}

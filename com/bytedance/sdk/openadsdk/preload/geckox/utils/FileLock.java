package com.bytedance.sdk.openadsdk.preload.geckox.utils;

import android.os.Process;
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
import java.io.File;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes9.dex */
public class FileLock {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final Map<String, Integer> f68433a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final int f68434b;

    /* renamed from: c  reason: collision with root package name */
    public final String f68435c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1928321007, "Lcom/bytedance/sdk/openadsdk/preload/geckox/utils/FileLock;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1928321007, "Lcom/bytedance/sdk/openadsdk/preload/geckox/utils/FileLock;");
                return;
            }
        }
        f68433a = new HashMap();
        g.a("file_lock_pg");
    }

    public FileLock(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f68435c = str;
        this.f68434b = i2;
    }

    public static FileLock a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            try {
                int d2 = d(str);
                nLockFile(d2);
                return new FileLock(str, d2);
            } catch (Exception e2) {
                throw new RuntimeException("lock failed, file:" + str + ", pid:" + Process.myPid() + " caused by:" + e2.getMessage());
            }
        }
        return (FileLock) invokeL.objValue;
    }

    public static FileLock b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            try {
                int d2 = d(str);
                if (nTryLock(d2)) {
                    return new FileLock(str, d2);
                }
                return null;
            } catch (Exception e2) {
                throw new RuntimeException("try lock failed, file:" + str + " caused by:" + e2.getMessage());
            }
        }
        return (FileLock) invokeL.objValue;
    }

    public static FileLock c(String str) throws Exception {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) {
            try {
                int d2 = d(str);
                if (!nTryLock(d2)) {
                    new FileLock(str, d2).b();
                    return null;
                }
                return new FileLock(str, d2);
            } catch (Exception e2) {
                throw new RuntimeException("try lock failed, file:" + str + " caused by:" + e2.getMessage());
            }
        }
        return (FileLock) invokeL.objValue;
    }

    public static int d(String str) throws Exception {
        InterceptResult invokeL;
        Integer num;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, str)) == null) {
            synchronized (f68433a) {
                num = f68433a.get(str);
                if (num == null) {
                    new File(str).getParentFile().mkdirs();
                    num = Integer.valueOf(nGetFD(str));
                    f68433a.put(str, num);
                }
            }
            return num.intValue();
        }
        return invokeL.intValue;
    }

    public static native int nGetFD(String str) throws Exception;

    public static native void nLockFile(int i2) throws Exception;

    public static native void nLockFileSegment(int i2, int i3) throws Exception;

    public static native void nRelease(int i2) throws Exception;

    public static native boolean nTryLock(int i2) throws Exception;

    public static native void nUnlockFile(int i2) throws Exception;

    public static FileLock a(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, str, i2)) == null) {
            try {
                int d2 = d(str);
                nLockFileSegment(d2, i2);
                return new FileLock(str, d2);
            } catch (Exception e2) {
                throw new RuntimeException("lock segment failed, file:" + str + " caused by:" + e2.getMessage());
            }
        }
        return (FileLock) invokeLI.objValue;
    }

    public void b() {
        Integer remove;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (f68433a) {
                remove = f68433a.remove(this.f68435c);
            }
            try {
                nRelease(remove.intValue());
            } catch (Exception e2) {
                throw new RuntimeException("release lock failed, file:" + this.f68435c + " caused by:" + e2.getMessage());
            }
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                nUnlockFile(this.f68434b);
            } catch (Exception unused) {
                throw new RuntimeException("release lock failed，path:" + this.f68435c);
            }
        }
    }
}

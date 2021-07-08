package d.a.c.j;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.titan.TitanDownloadService;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.io.Closeables;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
/* loaded from: classes7.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f41793d;

    /* renamed from: e  reason: collision with root package name */
    public static volatile h f41794e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f41795a;

    /* renamed from: b  reason: collision with root package name */
    public long f41796b;

    /* renamed from: c  reason: collision with root package name */
    public int f41797c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1754036535, "Ld/a/c/j/h;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1754036535, "Ld/a/c/j/h;");
                return;
            }
        }
        f41793d = a.f41781a;
    }

    public h() {
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
        this.f41795a = -1L;
        this.f41796b = 0L;
        this.f41797c = 0;
    }

    public static synchronized h d() {
        InterceptResult invokeV;
        h hVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            synchronized (h.class) {
                if (f41794e == null) {
                    f41794e = new h();
                }
                hVar = f41794e;
            }
            return hVar;
        }
        return (h) invokeV.objValue;
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                Context appContext = AppRuntime.getAppContext();
                PackageInfo packageInfo = appContext.getPackageManager().getPackageInfo(appContext.getPackageName(), 0);
                if (packageInfo != null) {
                    if (f41793d) {
                        Log.d(TitanDownloadService.TAG, "cur host version code = " + packageInfo.versionCode);
                    }
                    return packageInfo.versionCode;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public long b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (a() > c()) {
                return -1L;
            }
            return this.f41795a;
        }
        return invokeV.longValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f41797c : invokeV.intValue;
    }

    public long e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f41796b : invokeV.longValue;
    }

    public final File f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            File file = new File(AppRuntime.getAppContext().getCacheDir(), "titan_sandbox_cache");
            file.mkdirs();
            return new File(file, "update_v3.profile");
        }
        return (File) invokeV.objValue;
    }

    public void g() {
        DataInputStream dataInputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            File f2 = f();
            if (f2.exists()) {
                DataInputStream dataInputStream2 = null;
                try {
                    try {
                        dataInputStream = new DataInputStream(new FileInputStream(f2));
                    } catch (IOException e2) {
                        e = e2;
                    }
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    this.f41795a = dataInputStream.readLong();
                    this.f41796b = dataInputStream.readLong();
                    this.f41797c = dataInputStream.readInt();
                    Closeables.closeSafely(dataInputStream);
                } catch (IOException e3) {
                    e = e3;
                    dataInputStream2 = dataInputStream;
                    e.printStackTrace();
                    Closeables.closeSafely(dataInputStream2);
                } catch (Throwable th2) {
                    th = th2;
                    dataInputStream2 = dataInputStream;
                    Closeables.closeSafely(dataInputStream2);
                    throw th;
                }
            }
        }
    }

    public void h(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.f41797c = i2;
        }
    }

    public void i(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048583, this, j) == null) {
            this.f41796b = j;
        }
    }

    public void j(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j) == null) {
            this.f41795a = j;
        }
    }

    public void k() {
        File file;
        DataOutputStream dataOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (f41793d) {
                Log.d(TitanDownloadService.TAG, "updateToFile value = " + toString());
            }
            File f2 = f();
            DataOutputStream dataOutputStream2 = null;
            try {
                try {
                    file = File.createTempFile("titan", "profile", f2.getParentFile());
                    try {
                        dataOutputStream = new DataOutputStream(new FileOutputStream(file));
                    } catch (IOException e2) {
                        e = e2;
                    }
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    dataOutputStream.writeLong(this.f41795a);
                    dataOutputStream.writeLong(this.f41796b);
                    dataOutputStream.writeInt(this.f41797c);
                    dataOutputStream.close();
                    f2.delete();
                    file.renameTo(f2);
                    Closeables.closeSafely(dataOutputStream);
                    if (file == null || !file.exists()) {
                        return;
                    }
                } catch (IOException e3) {
                    e = e3;
                    dataOutputStream2 = dataOutputStream;
                    e.printStackTrace();
                    Closeables.closeSafely(dataOutputStream2);
                    if (file == null || !file.exists()) {
                        return;
                    }
                    file.delete();
                } catch (Throwable th2) {
                    th = th2;
                    dataOutputStream2 = dataOutputStream;
                    Closeables.closeSafely(dataOutputStream2);
                    if (file != null && file.exists()) {
                        file.delete();
                    }
                    throw th;
                }
            } catch (IOException e4) {
                e = e4;
                file = null;
            } catch (Throwable th3) {
                th = th3;
                file = null;
            }
            file.delete();
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return "[updateVersion = " + this.f41795a + ", lastUpdateTime = " + this.f41796b + ", hostVersionCode = " + this.f41797c + PreferencesUtil.RIGHT_MOUNT;
        }
        return (String) invokeV.objValue;
    }
}

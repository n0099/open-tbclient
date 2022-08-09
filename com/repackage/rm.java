package com.repackage;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.titan.TitanDownloadService;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.io.Closeables;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.launch.stats.AppBeforeCreateSpeedStats;
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
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class rm {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean d;
    public static volatile rm e;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;
    public long b;
    public int c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1964028630, "Lcom/repackage/rm;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1964028630, "Lcom/repackage/rm;");
                return;
            }
        }
        d = jm.a;
    }

    public rm() {
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
        this.a = -1L;
        this.b = 0L;
        this.c = 0;
    }

    public static synchronized rm d() {
        InterceptResult invokeV;
        rm rmVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            synchronized (rm.class) {
                if (e == null) {
                    e = new rm();
                }
                rmVar = e;
            }
            return rmVar;
        }
        return (rm) invokeV.objValue;
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                Context appContext = AppRuntime.getAppContext();
                PackageInfo packageInfo = appContext.getPackageManager().getPackageInfo(appContext.getPackageName(), 0);
                if (packageInfo != null) {
                    if (d) {
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
            return this.a;
        }
        return invokeV.longValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.c : invokeV.intValue;
    }

    public long e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.b : invokeV.longValue;
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
            File f = f();
            if (f.exists()) {
                DataInputStream dataInputStream2 = null;
                try {
                    try {
                        dataInputStream = new DataInputStream(new FileInputStream(f));
                    } catch (IOException e2) {
                        e = e2;
                    }
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    this.a = dataInputStream.readLong();
                    this.b = dataInputStream.readLong();
                    this.c = dataInputStream.readInt();
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

    public void h(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.c = i;
        }
    }

    public void i(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048583, this, j) == null) {
            this.b = j;
        }
    }

    public void j(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j) == null) {
            this.a = j;
        }
    }

    public JSONObject k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("updateVersion", this.a);
                jSONObject.put("lastUpdateTime", this.b);
                jSONObject.put("hostVersionCode", this.c);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public void l() {
        File file;
        DataOutputStream dataOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (d) {
                Log.d(TitanDownloadService.TAG, "updateToFile value = " + toString());
            }
            File f = f();
            DataOutputStream dataOutputStream2 = null;
            try {
                try {
                    file = File.createTempFile(AppBeforeCreateSpeedStats.TITAN_DETAILS, "profile", f.getParentFile());
                    try {
                        dataOutputStream = new DataOutputStream(new FileOutputStream(file));
                    } catch (IOException e2) {
                        e = e2;
                    }
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    dataOutputStream.writeLong(this.a);
                    dataOutputStream.writeLong(this.b);
                    dataOutputStream.writeInt(this.c);
                    dataOutputStream.close();
                    f.delete();
                    file.renameTo(f);
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return "[updateVersion = " + this.a + ", lastUpdateTime = " + this.b + ", hostVersionCode = " + this.c + PreferencesUtil.RIGHT_MOUNT;
        }
        return (String) invokeV.objValue;
    }
}

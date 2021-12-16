package com.kuaishou.weapon.un;

import android.content.Context;
import android.os.Build;
import android.os.Debug;
import android.os.Process;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.track.ui.TrackUI;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedReader;
import java.io.FileReader;
/* loaded from: classes3.dex */
public class a0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public a0() {
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

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            try {
                return Boolean.valueOf(Debug.isDebuggerConnected()).booleanValue();
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            try {
                return (context.getPackageManager().getApplicationInfo(context.getPackageName(), 8192).flags & 2) == 1;
            } catch (Throwable th) {
                x0.a(th);
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            try {
                return x0.a(" cat /proc/" + Process.myPid() + "/cmdline ");
            } catch (Exception unused) {
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    public static boolean b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            try {
                if (Build.VERSION.SDK_INT >= 24) {
                    if ((context.getPackageManager().getApplicationInfo(context.getPackageName(), 8192).flags & 2) == 1) {
                        return true;
                    }
                } else if ((context.getPackageManager().getApplicationInfo(context.getPackageName(), 8192).flags & 2) == 1) {
                    return true;
                }
                return false;
            } catch (Throwable th) {
                x0.a(th);
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static String c() {
        InterceptResult invokeV;
        String readLine;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(65541, null)) != null) {
            return (String) invokeV.objValue;
        }
        BufferedReader bufferedReader = null;
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new FileReader("/proc/" + Process.myPid() + "/status"));
            while (true) {
                try {
                    readLine = bufferedReader2.readLine();
                    if (!readLine.contains("TracerPid")) {
                        if (readLine == null) {
                            readLine = "";
                            break;
                        }
                    } else {
                        break;
                    }
                } catch (Exception unused) {
                    bufferedReader = bufferedReader2;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Exception unused2) {
                        }
                    }
                    return "";
                } catch (Throwable th) {
                    th = th;
                    bufferedReader = bufferedReader2;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Exception unused3) {
                        }
                    }
                    throw th;
                }
            }
            String replace = readLine.replace(TrackUI.SEPERATOR, " ");
            try {
                bufferedReader2.close();
            } catch (Exception unused4) {
            }
            return replace;
        } catch (Exception unused5) {
        } catch (Throwable th2) {
            th = th2;
        }
    }
}

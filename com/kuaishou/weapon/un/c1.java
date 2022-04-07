package com.kuaishou.weapon.un;

import android.content.Context;
import android.provider.Settings;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.engine.GlideException;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
/* loaded from: classes5.dex */
public class c1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public c1() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static int a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            try {
                return Settings.System.getString(context.getContentResolver(), "airplane_mode_on").equals("0") ? 0 : 1;
            } catch (Throwable th) {
                x0.a(th);
                return -2;
            }
        }
        return invokeL.intValue;
    }

    public static long a() {
        InterceptResult invokeV;
        DataInputStream dataInputStream;
        Throwable th;
        BufferedReader bufferedReader;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            long j = -1;
            try {
                dataInputStream = new DataInputStream(Runtime.getRuntime().exec("cat /proc/uptime").getInputStream());
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(dataInputStream));
                    double d = 0.0d;
                    while (true) {
                        try {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                break;
                            }
                            String[] split = a(readLine).split(";");
                            if (split != null && split.length != 0) {
                                d = Double.valueOf(split[0]).doubleValue();
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            try {
                                x0.a(th);
                            } finally {
                                if (dataInputStream != null) {
                                    try {
                                        dataInputStream.close();
                                    } catch (IOException e) {
                                        x0.a(e);
                                    }
                                }
                                if (bufferedReader != null) {
                                    try {
                                        bufferedReader.close();
                                    } catch (IOException e2) {
                                        x0.a(e2);
                                    }
                                }
                            }
                        }
                    }
                    j = System.currentTimeMillis() - ((long) (d * 1000.0d));
                    try {
                        dataInputStream.close();
                    } catch (IOException e3) {
                        x0.a(e3);
                    }
                } catch (Throwable th3) {
                    bufferedReader = null;
                    th = th3;
                }
            } catch (Throwable th4) {
                dataInputStream = null;
                th = th4;
                bufferedReader = null;
            }
            return j;
        }
        return invokeV.longValue;
    }

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            try {
                return str.replace("      ", ";").replace("     ", ";").replace("    ", ";").replace("   ", ";").replace(GlideException.IndentedAppendable.INDENT, ";").replace(" ", ";");
            } catch (Throwable th) {
                x0.a(th);
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public static long b() {
        InterceptResult invokeV;
        DataInputStream dataInputStream;
        Throwable th;
        BufferedReader bufferedReader;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            long j = -1;
            try {
                dataInputStream = new DataInputStream(Runtime.getRuntime().exec("cat /proc/uptime").getInputStream());
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(dataInputStream));
                    double d = 0.0d;
                    while (true) {
                        try {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                break;
                            }
                            String[] split = a(readLine).split(";");
                            if (split != null && split.length != 0) {
                                d = Double.valueOf(split[0]).doubleValue();
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            try {
                                x0.a(th);
                            } finally {
                                if (dataInputStream != null) {
                                    try {
                                        dataInputStream.close();
                                    } catch (IOException e) {
                                        x0.a(e);
                                    }
                                }
                                if (bufferedReader != null) {
                                    try {
                                        bufferedReader.close();
                                    } catch (IOException e2) {
                                        x0.a(e2);
                                    }
                                }
                            }
                        }
                    }
                    j = (long) (d * 1000.0d);
                    try {
                        dataInputStream.close();
                    } catch (IOException e3) {
                        x0.a(e3);
                    }
                } catch (Throwable th3) {
                    bufferedReader = null;
                    th = th3;
                }
            } catch (Throwable th4) {
                dataInputStream = null;
                th = th4;
                bufferedReader = null;
            }
            return j;
        }
        return invokeV.longValue;
    }
}

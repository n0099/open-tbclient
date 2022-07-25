package com.kuaishou.weapon.p0;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Build;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.engine.GlideException;
import com.yy.hiidostatis.defs.obj.ParamableElem;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ListIterator;
/* loaded from: classes5.dex */
public class o1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public o1() {
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
        SensorManager sensorManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            try {
                if (Build.VERSION.SDK_INT >= 23 && (sensorManager = (SensorManager) context.getSystemService("sensor")) != null) {
                    List<Sensor> sensorList = sensorManager.getSensorList(-1);
                    if (sensorList.size() > 0) {
                        ListIterator<Sensor> listIterator = sensorList.listIterator();
                        while (listIterator.hasNext()) {
                            if (listIterator.next().getType() == 9) {
                                return 0;
                            }
                        }
                        return 1;
                    }
                    return 0;
                }
                return 0;
            } catch (Exception unused) {
                return 0;
            }
        }
        return invokeL.intValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0064, code lost:
        if (r3 != null) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static long a() {
        InterceptResult invokeV;
        BufferedReader bufferedReader;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            DataInputStream dataInputStream = null;
            long j = -1;
            try {
                DataInputStream dataInputStream2 = new DataInputStream(Runtime.getRuntime().exec("cat /proc/uptime").getInputStream());
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(dataInputStream2));
                    double d = 0.0d;
                    while (true) {
                        try {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                break;
                            }
                            String[] split = a(readLine).split(ParamableElem.DIVIDE_PARAM);
                            if (split != null && split.length != 0) {
                                d = Double.valueOf(split[0]).doubleValue();
                            }
                        } catch (Throwable unused) {
                            dataInputStream = dataInputStream2;
                            if (dataInputStream != null) {
                                try {
                                    dataInputStream.close();
                                } catch (IOException unused2) {
                                }
                            }
                        }
                    }
                    long currentTimeMillis = System.currentTimeMillis() - ((long) (d * 1000.0d));
                    try {
                        dataInputStream2.close();
                    } catch (IOException unused3) {
                    }
                    j = currentTimeMillis;
                } catch (Throwable unused4) {
                    bufferedReader = null;
                }
            } catch (Throwable unused5) {
                bufferedReader = null;
            }
            try {
                bufferedReader.close();
            } catch (IOException unused6) {
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
                return str.replace("      ", ParamableElem.DIVIDE_PARAM).replace("     ", ParamableElem.DIVIDE_PARAM).replace("    ", ParamableElem.DIVIDE_PARAM).replace("   ", ParamableElem.DIVIDE_PARAM).replace(GlideException.IndentedAppendable.INDENT, ParamableElem.DIVIDE_PARAM).replace(" ", ParamableElem.DIVIDE_PARAM);
            } catch (Throwable unused) {
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0062, code lost:
        if (r3 != null) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static long b() {
        InterceptResult invokeV;
        BufferedReader bufferedReader;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            DataInputStream dataInputStream = null;
            long j = -1;
            try {
                DataInputStream dataInputStream2 = new DataInputStream(Runtime.getRuntime().exec("cat /proc/uptime").getInputStream());
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(dataInputStream2));
                    double d = 0.0d;
                    while (true) {
                        try {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                break;
                            }
                            String[] split = a(readLine).split(ParamableElem.DIVIDE_PARAM);
                            if (split != null && split.length != 0) {
                                d = Double.valueOf(split[0]).doubleValue();
                            }
                        } catch (Throwable unused) {
                            dataInputStream = dataInputStream2;
                            if (dataInputStream != null) {
                                try {
                                    dataInputStream.close();
                                } catch (IOException unused2) {
                                }
                            }
                        }
                    }
                    System.currentTimeMillis();
                    long j2 = (long) (d * 1000.0d);
                    try {
                        dataInputStream2.close();
                    } catch (IOException unused3) {
                    }
                    j = j2;
                } catch (Throwable unused4) {
                    bufferedReader = null;
                }
            } catch (Throwable unused5) {
                bufferedReader = null;
            }
            try {
                bufferedReader.close();
            } catch (IOException unused6) {
            }
            return j;
        }
        return invokeV.longValue;
    }
}

package com.repackage;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
/* loaded from: classes5.dex */
public class a90 {
    public static /* synthetic */ Interceptable $ic;
    public static Context a;
    public static a90 b;
    public static File c;
    public transient /* synthetic */ FieldHolder $fh;

    public a90() {
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

    public static File a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (Environment.getExternalStorageState().equals("mounted")) {
                File file = new File(a.getExternalFilesDir("Log").getPath() + "/");
                Log.i("LogToFileUtils", "file path ..." + file.getPath());
                if (!file.exists()) {
                    file.mkdirs();
                }
                File file2 = new File(file.getPath() + "/logs.txt");
                if (file2.exists()) {
                    file2.delete();
                }
                try {
                    file2.createNewFile();
                } catch (Exception e) {
                    Log.e("LogToFileUtils", "Create log file failure !!! " + e.toString());
                }
                return file2;
            }
            Log.e("LogToFileUtils", "sd not mounted");
            return null;
        }
        return (File) invokeV.objValue;
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            try {
                Class<?> cls = Class.forName("com.baidu.android.imsdk.internal.IMConfigInternal");
                String valueOf = String.valueOf(cls.getMethod("getSDKVersionValue", Context.class).invoke(cls.getMethod("getInstance", new Class[0]).invoke(new Object(), new Object[0]), a));
                return String.format("%s.%s.%s", valueOf.substring(0, 1), valueOf.substring(1, 2), valueOf.substring(2, 3));
            } catch (Exception e) {
                Log.i("LogToFileUtils", e.getMessage());
                e.printStackTrace();
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    public static a90 c(Context context) {
        InterceptResult invokeL;
        File file;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            Log.i("LogToFileUtils", "init ...");
            if (a != null && b != null && (file = c) != null && file.exists()) {
                Log.i("LogToFileUtils", "LogToFileUtils has been init ...");
            } else {
                a = context;
                b = new a90();
                c = a();
                e("imsdkversion:" + b());
                e("lcpsdkversion:" + d());
                Log.i("LogToFileUtils", "LogFilePath is: " + c.getPath());
            }
            return b;
        }
        return (a90) invokeL.objValue;
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? "2280016" : (String) invokeV.objValue;
    }

    public static void e(Object obj) {
        File file;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, obj) == null) {
            if (a != null && b != null && (file = c) != null && file.exists()) {
                String str = System.currentTimeMillis() + ":" + obj.toString();
                Log.i("LogToFileUtils", str);
                try {
                    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(c, true));
                    bufferedWriter.write(str);
                    bufferedWriter.write("\r\n");
                    bufferedWriter.flush();
                    return;
                } catch (Exception e) {
                    Log.e("LogToFileUtils", "Write failure !!! " + e.toString());
                    return;
                }
            }
            Log.e("LogToFileUtils", "Initialization failure !!!");
        }
    }
}

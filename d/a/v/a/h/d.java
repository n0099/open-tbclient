package d.a.v.a.h;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.android.internal.http.multipart.Part;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
/* loaded from: classes8.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static Context f68436a;

    /* renamed from: b  reason: collision with root package name */
    public static d f68437b;

    /* renamed from: c  reason: collision with root package name */
    public static File f68438c;
    public transient /* synthetic */ FieldHolder $fh;

    public d() {
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

    public static File a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (Environment.getExternalStorageState().equals("mounted")) {
                File file = new File(f68436a.getExternalFilesDir("Log").getPath() + "/");
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
                } catch (Exception e2) {
                    Log.e("LogToFileUtils", "Create log file failure !!! " + e2.toString());
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
                String valueOf = String.valueOf(cls.getMethod("getSDKVersionValue", Context.class).invoke(cls.getMethod("getInstance", new Class[0]).invoke(new Object(), new Object[0]), f68436a));
                return String.format("%s.%s.%s", valueOf.substring(0, 1), valueOf.substring(1, 2), valueOf.substring(2, 3));
            } catch (Exception e2) {
                Log.i("LogToFileUtils", e2.getMessage());
                e2.printStackTrace();
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    public static d c(Context context) {
        InterceptResult invokeL;
        File file;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            Log.i("LogToFileUtils", "init ...");
            if (f68436a != null && f68437b != null && (file = f68438c) != null && file.exists()) {
                Log.i("LogToFileUtils", "LogToFileUtils has been init ...");
            } else {
                f68436a = context;
                f68437b = new d();
                f68438c = a();
                e("imsdkversion:" + b());
                e("lcpsdkversion:" + d());
                Log.i("LogToFileUtils", "LogFilePath is: " + f68438c.getPath());
            }
            return f68437b;
        }
        return (d) invokeL.objValue;
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? "2280016" : (String) invokeV.objValue;
    }

    public static void e(Object obj) {
        File file;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, obj) == null) {
            if (f68436a != null && f68437b != null && (file = f68438c) != null && file.exists()) {
                String str = System.currentTimeMillis() + ":" + obj.toString();
                Log.i("LogToFileUtils", str);
                try {
                    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(f68438c, true));
                    bufferedWriter.write(str);
                    bufferedWriter.write(Part.CRLF);
                    bufferedWriter.flush();
                    return;
                } catch (Exception e2) {
                    Log.e("LogToFileUtils", "Write failure !!! " + e2.toString());
                    return;
                }
            }
            Log.e("LogToFileUtils", "Initialization failure !!!");
        }
    }
}

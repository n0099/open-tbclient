package d.a.t.a.h;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import com.android.internal.http.multipart.Part;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
/* loaded from: classes2.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static Context f64638a;

    /* renamed from: b  reason: collision with root package name */
    public static d f64639b;

    /* renamed from: c  reason: collision with root package name */
    public static File f64640c;

    public static File a() {
        if (Environment.getExternalStorageState().equals("mounted")) {
            File file = new File(f64638a.getExternalFilesDir("Log").getPath() + "/");
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

    public static String b() {
        try {
            Class<?> cls = Class.forName("com.baidu.android.imsdk.internal.IMConfigInternal");
            String valueOf = String.valueOf(cls.getMethod("getSDKVersionValue", Context.class).invoke(cls.getMethod("getInstance", new Class[0]).invoke(new Object(), new Object[0]), f64638a));
            return String.format("%s.%s.%s", valueOf.substring(0, 1), valueOf.substring(1, 2), valueOf.substring(2, 3));
        } catch (Exception e2) {
            Log.i("LogToFileUtils", e2.getMessage());
            e2.printStackTrace();
            return "";
        }
    }

    public static d c(Context context) {
        File file;
        Log.i("LogToFileUtils", "init ...");
        if (f64638a != null && f64639b != null && (file = f64640c) != null && file.exists()) {
            Log.i("LogToFileUtils", "LogToFileUtils has been init ...");
        } else {
            f64638a = context;
            f64639b = new d();
            f64640c = a();
            e("imsdkversion:" + b());
            e("lcpsdkversion:" + d());
            Log.i("LogToFileUtils", "LogFilePath is: " + f64640c.getPath());
        }
        return f64639b;
    }

    public static String d() {
        return "2280016";
    }

    public static void e(Object obj) {
        File file;
        if (f64638a != null && f64639b != null && (file = f64640c) != null && file.exists()) {
            String str = System.currentTimeMillis() + ":" + obj.toString();
            Log.i("LogToFileUtils", str);
            try {
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(f64640c, true));
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

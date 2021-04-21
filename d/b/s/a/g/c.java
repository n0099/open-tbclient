package d.b.s.a.g;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import com.android.internal.http.multipart.Part;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static Context f65624a;

    /* renamed from: b  reason: collision with root package name */
    public static c f65625b;

    /* renamed from: c  reason: collision with root package name */
    public static File f65626c;

    public static File a() {
        if (Environment.getExternalStorageState().equals("mounted")) {
            File file = new File(f65624a.getExternalFilesDir("Log").getPath() + "/");
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
            String valueOf = String.valueOf(cls.getMethod("getSDKVersionValue", Context.class).invoke(cls.getMethod("getInstance", new Class[0]).invoke(new Object(), new Object[0]), f65624a));
            return String.format("%s.%s.%s", valueOf.substring(0, 1), valueOf.substring(1, 2), valueOf.substring(2, 3));
        } catch (Exception e2) {
            Log.i("LogToFileUtils", e2.getMessage());
            e2.printStackTrace();
            return "";
        }
    }

    public static c c(Context context) {
        File file;
        Log.i("LogToFileUtils", "init ...");
        if (f65624a != null && f65625b != null && (file = f65626c) != null && file.exists()) {
            Log.i("LogToFileUtils", "LogToFileUtils has been init ...");
        } else {
            f65624a = context;
            f65625b = new c();
            f65626c = a();
            e("imsdkversion:" + b());
            e("lcpsdkversion:" + d());
            Log.i("LogToFileUtils", "LogFilePath is: " + f65626c.getPath());
        }
        return f65625b;
    }

    public static String d() {
        return "2240016";
    }

    public static void e(Object obj) {
        File file;
        if (f65624a != null && f65625b != null && (file = f65626c) != null && file.exists()) {
            String str = System.currentTimeMillis() + ":" + obj.toString();
            Log.i("LogToFileUtils", str);
            try {
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(f65626c, true));
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

package d.a.n0.u1;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.FileHelper;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.json.JSONArray;
/* loaded from: classes3.dex */
public class d {
    public static void a(String str) {
        if (StringUtils.isNull(str)) {
            return;
        }
        File file = new File(str);
        if (file.exists()) {
            return;
        }
        file.mkdirs();
    }

    public static void b(String str) {
        if (StringUtils.isNull(str)) {
            return;
        }
        FileHelper.deleteFileOrDir(new File(f.f61326e + f.f61322a + str));
    }

    public static void c(String str, JSONArray jSONArray) {
        if (StringUtils.isNull(str) || jSONArray == null) {
            return;
        }
        try {
            JSONArray jSONArray2 = new JSONArray(str);
            for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                jSONArray.put(jSONArray2.optJSONObject(i2));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static JSONArray d(String str) {
        JSONArray jSONArray = new JSONArray();
        if (StringUtils.isNull(str)) {
            return jSONArray;
        }
        File file = new File(str);
        if (file.exists()) {
            String e2 = e(file);
            String[] split = e2.split("\n");
            if (split.length > 0) {
                for (String str2 : split) {
                    c(str2, jSONArray);
                }
            } else {
                c(e2, jSONArray);
            }
            FileHelper.deleteFile(file);
            return jSONArray;
        }
        return jSONArray;
    }

    public static String e(File file) {
        FileInputStream fileInputStream;
        StringBuilder sb = new StringBuilder();
        FileInputStream fileInputStream2 = null;
        try {
            try {
                fileInputStream = new FileInputStream(file);
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                sb.append(new String(bArr, 0, read));
            }
            d.a.c.e.m.a.c(fileInputStream);
        } catch (Exception e3) {
            e = e3;
            fileInputStream2 = fileInputStream;
            e.printStackTrace();
            d.a.c.e.m.a.c(fileInputStream2);
            return sb.toString();
        } catch (Throwable th2) {
            th = th2;
            fileInputStream2 = fileInputStream;
            d.a.c.e.m.a.c(fileInputStream2);
            throw th;
        }
        return sb.toString();
    }

    public static boolean f(File file, String str) {
        return g(file, str, true);
    }

    public static boolean g(File file, String str, boolean z) {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                if (!file.exists()) {
                    file.createNewFile();
                }
                fileOutputStream = new FileOutputStream(file, z);
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e2) {
            e = e2;
        }
        try {
            fileOutputStream.write(str.getBytes());
            fileOutputStream.flush();
            d.a.c.e.m.a.d(fileOutputStream);
            return true;
        } catch (Exception e3) {
            e = e3;
            fileOutputStream2 = fileOutputStream;
            e.printStackTrace();
            d.a.c.e.m.a.d(fileOutputStream2);
            return false;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            d.a.c.e.m.a.d(fileOutputStream2);
            throw th;
        }
    }
}

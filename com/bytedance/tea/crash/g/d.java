package com.bytedance.tea.crash.g;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d {
    public static void b(@NonNull File file, @NonNull String str, boolean z) throws IOException {
        FileOutputStream fileOutputStream;
        if (!TextUtils.isEmpty(str)) {
            file.getParentFile().mkdirs();
            try {
                fileOutputStream = new FileOutputStream(file, z);
            } catch (Throwable th) {
                th = th;
                fileOutputStream = null;
            }
            try {
                fileOutputStream.write(str.getBytes());
                fileOutputStream.flush();
                f.a(fileOutputStream);
            } catch (Throwable th2) {
                th = th2;
                f.a(fileOutputStream);
                throw th;
            }
        }
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File file = new File(str);
        return file.exists() && file.delete();
    }

    public static boolean a(File file) {
        return file.exists() && file.delete();
    }

    public static boolean c(@NonNull File file, boolean z) {
        boolean c;
        if (!z || file.isFile()) {
            return a(file);
        }
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            int i = 0;
            boolean z2 = true;
            while (listFiles != null && i < listFiles.length) {
                if (listFiles[i].isFile()) {
                    c = a(listFiles[i]);
                } else {
                    c = c(listFiles[i], true);
                }
                i++;
                z2 = c & z2;
            }
            return a(file) & z2;
        }
        return true;
    }

    public static String a(String str, String str2) throws IOException {
        BufferedReader bufferedReader;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(str);
        StringBuilder sb = new StringBuilder();
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        sb.append(readLine);
                        if (str2 != null) {
                            sb.append(str2);
                        }
                    } else {
                        f.a(bufferedReader);
                        return sb.toString();
                    }
                } catch (Throwable th) {
                    th = th;
                    f.a(bufferedReader);
                    throw th;
                }
            }
        } catch (Throwable th2) {
            th = th2;
            bufferedReader = null;
        }
    }

    public static String b(String str) throws IOException {
        return a(str, null);
    }

    public static com.bytedance.tea.crash.c.c XR(String str) {
        try {
            JSONObject jSONObject = new JSONObject(b(str));
            com.bytedance.tea.crash.c.c cVar = new com.bytedance.tea.crash.c.c();
            cVar.a(jSONObject.optString("url"));
            cVar.a(jSONObject.optJSONObject("body"));
            cVar.b(jSONObject.optString("dump_file"));
            cVar.a(jSONObject.optBoolean("encrypt", false));
            return cVar;
        } catch (Throwable th) {
            return null;
        }
    }

    public static String a(File file, String str, String str2, JSONObject jSONObject, boolean z) {
        return a(file, str, str2, jSONObject, null, z);
    }

    public static String a(File file, String str, String str2, JSONObject jSONObject, String str3, boolean z) {
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, str);
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("url", str2);
            jSONObject2.put("body", jSONObject);
            if (str3 == null) {
                str3 = "";
            }
            jSONObject2.put("dump_file", str3);
            jSONObject2.put("encrypt", z);
            b(file2, jSONObject2.toString(), false);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return file2.getAbsolutePath();
    }

    public static void a(Context context, String str, String str2) {
        try {
            StringBuilder append = new StringBuilder().append(System.currentTimeMillis()).append(" ");
            if (str == null) {
                str = "null";
            }
            StringBuilder append2 = append.append(str).append(" ");
            if (str2 == null) {
                str2 = "null";
            }
            b(h.b(context), append2.append(str2).append("\n").toString(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Nullable
    public static String[] XS(String str) {
        BufferedReader bufferedReader;
        String[] strArr = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(str)), 1000);
            try {
                try {
                    String readLine = bufferedReader.readLine();
                    int indexOf = readLine.indexOf(")");
                    if (indexOf > 0) {
                        readLine = readLine.substring(indexOf + 2);
                    }
                    strArr = readLine.split(" ");
                    f.a(bufferedReader);
                } catch (Exception e) {
                    e = e;
                    e.printStackTrace();
                    f.a(bufferedReader);
                    return strArr;
                }
            } catch (Throwable th) {
                th = th;
                f.a(bufferedReader);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            bufferedReader = null;
        } catch (Throwable th2) {
            th = th2;
            bufferedReader = null;
            f.a(bufferedReader);
            throw th;
        }
        return strArr;
    }
}

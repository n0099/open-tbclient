package com.kwad.sdk.core.webview.b.c;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
/* loaded from: classes10.dex */
public final class a {
    public static String F(Context context, String str) {
        String br = br(context);
        if (TextUtils.isEmpty(br)) {
            return null;
        }
        return br + File.separator + str;
    }

    public static String G(Context context, String str) {
        String br = br(context);
        if (TextUtils.isEmpty(br)) {
            return null;
        }
        return br + File.separator + str + ".zip";
    }

    public static String H(Context context, String str) {
        String br = br(context);
        if (TextUtils.isEmpty(br)) {
            return null;
        }
        return br + File.separator + str;
    }

    public static String I(Context context, String str) {
        String br = br(context);
        if (TextUtils.isEmpty(br)) {
            return null;
        }
        return br + File.separator + str + File.separator + "_manifest_.json";
    }

    public static File bq(Context context) {
        File filesDir = context.getFilesDir();
        if (filesDir == null) {
            return new File("/data/data/" + context.getPackageName() + "/file/");
        }
        return filesDir;
    }

    public static String br(Context context) {
        String str = bq(context) + File.separator + "offlinepackage";
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return str;
    }

    public static File bs(Context context) {
        String br = br(context);
        if (TextUtils.isEmpty(br)) {
            return null;
        }
        ex(br);
        File file = new File(br, "packageIndex.json");
        if (!file.exists()) {
            file.createNewFile();
        }
        return file;
    }

    public static String ev(String str) {
        try {
            return Uri.parse(str).getQueryParameter("sceneId");
        } catch (Throwable unused) {
            com.kwad.sdk.core.e.c.e("HybridFileUtils", "getSceneId This isn't a hierarchical URI url is " + str);
            return "";
        }
    }

    public static boolean ex(String str) {
        File file = new File(str);
        if (!file.exists()) {
            return file.mkdirs();
        }
        return true;
    }

    public static String ew(String str) {
        try {
            List<String> pathSegments = Uri.parse(str).getPathSegments();
            String str2 = null;
            if (pathSegments != null && pathSegments.size() > 0) {
                str2 = pathSegments.get(pathSegments.size() - 1);
            }
            if (TextUtils.isEmpty(str2) || !str2.contains(".zip")) {
                return "";
            }
            return str2.substring(0, str2.indexOf(".zip"));
        } catch (Throwable unused) {
            com.kwad.sdk.core.e.c.e("HybridFileUtils", "getZipName This isn't a hierarchical URI url is " + str);
            return "";
        }
    }

    public static void f(Context context, String str, String str2) {
        ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(str));
        while (true) {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            if (nextEntry == null) {
                break;
            }
            String name = nextEntry.getName();
            String br = br(context);
            if (!new File(br, name).getAbsolutePath().startsWith(br)) {
                break;
            } else if (nextEntry.isDirectory()) {
                if (!name.contains("../")) {
                    String substring = name.substring(0, name.length() - 1);
                    new File(str2 + File.separator + substring).mkdirs();
                }
            } else {
                File file = new File(str2 + File.separator + name);
                if (!file.exists()) {
                    file.getParentFile().mkdirs();
                    file.createNewFile();
                }
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = zipInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, read);
                    fileOutputStream.flush();
                }
                com.kwad.sdk.crash.utils.b.closeQuietly(fileOutputStream);
            }
        }
        com.kwad.sdk.crash.utils.b.closeQuietly(zipInputStream);
    }
}

package com.yy.mediaframework.utils;

import android.os.Environment;
import android.os.StatFs;
import com.baidu.down.manage.DownloadConstants;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class BasicFileUtils {
    public static final String JPG_EXT = ".jpg";
    private static final int MAX_BUFF_SIZE = 1048576;
    private static final int MIN_BUFF_SIZE = 4096;
    public static final String SPEEX_EXT = ".aud";
    public static final String ZIP_EXT = ".zip";
    private static String TAG = "BasicFileUtils";
    private static Map<String, String> FILE_MIMES = new HashMap();

    static {
        FILE_MIMES.put(".zip", "application/zip");
        FILE_MIMES.put(".bmp", "image/bmp");
        FILE_MIMES.put(".gif", DownloadConstants.MIMETYPE_GIF);
        FILE_MIMES.put(".jpe", "image/jpeg");
        FILE_MIMES.put(".jpeg", "image/jpeg");
        FILE_MIMES.put(".jpg", "image/jpeg");
        FILE_MIMES.put(".png", "image/png");
        FILE_MIMES.put(".speex", "audio/speex");
        FILE_MIMES.put(".spx", "audio/speex");
        FILE_MIMES.put(".aud", "audio/speex");
    }

    public static boolean isSDCardMounted() {
        return availableMemInSDcard();
    }

    public static boolean availableMemInSDcard() {
        if (externalStorageExist()) {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            return (((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize())) / 1024 >= 10;
        }
        return false;
    }

    public static boolean externalStorageExist() {
        String externalStorageState = Environment.getExternalStorageState();
        if (externalStorageState == null) {
            return false;
        }
        return externalStorageState.equalsIgnoreCase("mounted");
    }

    public static String getFileExt(String str) {
        int lastIndexOf = str.lastIndexOf(".");
        return lastIndexOf == -1 ? "" : str.toLowerCase().substring(lastIndexOf);
    }

    public static String getFileName(String str) {
        int lastIndexOf;
        if (str == null || (lastIndexOf = str.lastIndexOf("/") + 1) <= 0) {
            return null;
        }
        return str.substring(lastIndexOf);
    }

    public static String getFileMime(String str) {
        String str2 = FILE_MIMES.get(getFileExt(str));
        return str2 != null ? str2 : "*/*";
    }

    public static void ensureDirExists(String str) {
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    public static void createDir(String str, boolean z) {
        ensureDirExists(str);
        if (z) {
            try {
                new File(str + "/.nomedia").createNewFile();
            } catch (IOException e) {
                YMFLog.error((Object) null, "[Util    ]", "Create new file exception:" + e.toString());
            }
        }
    }

    public static File createFileOnSD(String str, String str2) {
        if (isSDCardMounted()) {
            createDir(str, true);
            String str3 = str + File.separator + str2;
            File file = new File(str3);
            try {
                if (!file.exists()) {
                    if (!file.createNewFile()) {
                        return null;
                    }
                }
                return file;
            } catch (IOException e) {
                YMFLog.error((Object) null, "[Util    ]", "create file exception: " + str3);
                return null;
            }
        }
        return null;
    }

    public static boolean isFileExisted(String str) {
        if (StringUtils.isNullOrEmpty(str)) {
            return false;
        }
        try {
            File file = new File(str);
            if (file.exists()) {
                return file.length() > 0;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public static String getDirOfFilePath(String str) {
        int lastIndexOf;
        if (StringUtils.isNullOrEmpty(str) || (lastIndexOf = str.lastIndexOf(File.separatorChar)) == -1) {
            return null;
        }
        return str.substring(0, lastIndexOf);
    }

    public static void renameFile(String str, String str2) {
        try {
            new File(str).renameTo(new File(str2));
        } catch (Exception e) {
            YMFLog.error(null, "[Util    ]", "renameFile fail, oldFile:%s, exception:%s", str, e.toString());
        }
    }

    public static void removeFile(String str) {
        if (!StringUtils.isNullOrEmpty(str)) {
            new File(str).delete();
        }
    }

    public static void removeDir(String str) {
        File[] listFiles;
        File file = new File(str);
        if (file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                file2.delete();
            }
        }
        file.delete();
    }

    public static void rm(String str) {
        rm(new File(str));
    }

    public static void rm(File file) {
        if (file.exists()) {
            if (file.isDirectory()) {
                for (File file2 : (File[]) FP.ref(file.listFiles())) {
                    rm(file2);
                }
                return;
            }
            file.delete();
        }
    }

    public static void copyFile(File file, File file2) throws IOException {
        int i = 1048576;
        if (file2.exists()) {
            file2.delete();
        }
        file2.createNewFile();
        FileInputStream fileInputStream = new FileInputStream(file);
        int available = fileInputStream.available();
        if (available == 0) {
            i = 4096;
        } else if (available < 1048576) {
            i = available;
        }
        FileOutputStream fileOutputStream = new FileOutputStream(file2);
        byte[] bArr = new byte[i];
        while (true) {
            int read = fileInputStream.read(bArr);
            if (read == -1) {
                fileInputStream.close();
                fileOutputStream.flush();
                fileOutputStream.close();
                return;
            }
            fileOutputStream.write(bArr, 0, read);
        }
    }

    public static boolean copyFile(String str, String str2) {
        try {
            copyFile(new File(str), new File(str2));
            return true;
        } catch (Exception e) {
            YMFLog.error(null, "[Util    ]", "copy file exception:%s", e.toString());
            return false;
        }
    }
}

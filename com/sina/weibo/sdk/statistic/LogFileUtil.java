package com.sina.weibo.sdk.statistic;

import android.os.Environment;
import android.text.TextUtils;
import com.sina.weibo.sdk.utils.LogUtil;
import com.sina.weibo.sdk.utils.MD5;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class LogFileUtil {
    public static final String ANALYTICS_FILE_NAME = "app_logs";
    private static final String ANALYTICS_FILE_SUFFIX = ".txt";
    private static final String SDCARD_WEIBO_ANALYTICS_DIR = "/sina/weibo/.applogs/";

    LogFileUtil() {
    }

    public static String getAppLogs(String str) {
        return TextUtils.isEmpty(str) ? "" : readStringFromFile(str);
    }

    public static String getAppLogPath(String str) {
        String str2 = "";
        if (LogReport.getPackageName() != null) {
            str2 = MD5.hexdigest(LogReport.getPackageName()) + "/";
        }
        return getSDPath() + SDCARD_WEIBO_ANALYTICS_DIR + str2 + str + ".txt";
    }

    private static String getSDPath() {
        File externalStorageDirectory = Environment.getExternalStorageState().equals("mounted") ? Environment.getExternalStorageDirectory() : null;
        if (externalStorageDirectory != null) {
            return externalStorageDirectory.toString();
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [84=5, 86=4] */
    /* JADX WARN: Type inference failed for: r1v2, types: [int] */
    private static String readStringFromFile(String str) {
        BufferedReader bufferedReader;
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        File file = new File(str);
        if (!file.isFile() || !file.exists()) {
            return "";
        }
        BufferedReader bufferedReader2 = null;
        ?? length = (int) file.length();
        StringBuilder sb = new StringBuilder((int) length);
        try {
            try {
                try {
                    bufferedReader = new BufferedReader(new FileReader(file));
                    while (true) {
                        try {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                break;
                            }
                            sb.append(readLine);
                        } catch (IOException e) {
                            e = e;
                            e.printStackTrace();
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (IOException e2) {
                                }
                            }
                            return sb.toString();
                        } catch (OutOfMemoryError e3) {
                            e = e3;
                            bufferedReader2 = bufferedReader;
                            e.printStackTrace();
                            if (bufferedReader2 != null) {
                                try {
                                    bufferedReader2.close();
                                } catch (IOException e4) {
                                }
                            }
                            return sb.toString();
                        }
                    }
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e5) {
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                        } catch (IOException e6) {
                        }
                    }
                    throw th;
                }
            } catch (IOException e7) {
                e = e7;
                bufferedReader = null;
            } catch (OutOfMemoryError e8) {
                e = e8;
            }
            return sb.toString();
        } catch (Throwable th2) {
            th = th2;
            bufferedReader2 = length;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [137=4] */
    public static synchronized void writeToFile(String str, String str2, boolean z) {
        Throwable th;
        FileWriter fileWriter;
        synchronized (LogFileUtil.class) {
            if (!TextUtils.isEmpty(str)) {
                LogUtil.i(WBAgent.TAG, "filePath:" + str);
                if (str2 != null && str2.length() != 0) {
                    StringBuilder sb = new StringBuilder(str2);
                    if (sb.charAt(0) == '[') {
                        sb.replace(0, 1, "");
                    }
                    if (sb.charAt(sb.length() - 1) != ',') {
                        sb.replace(sb.length() - 1, sb.length(), ",");
                    }
                    File file = new File(str);
                    FileWriter fileWriter2 = null;
                    try {
                        File parentFile = file.getParentFile();
                        if (!parentFile.exists()) {
                            parentFile.mkdirs();
                        }
                        if (!file.exists()) {
                            file.createNewFile();
                        } else if (file.lastModified() > 0 && System.currentTimeMillis() - file.lastModified() > 86400000) {
                            z = false;
                        }
                        FileWriter fileWriter3 = new FileWriter(file, z);
                        try {
                            fileWriter3.write(sb.toString());
                            fileWriter3.flush();
                            if (fileWriter3 != null) {
                                try {
                                    fileWriter3.close();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        } catch (IOException e2) {
                            fileWriter2 = fileWriter3;
                            if (fileWriter2 != null) {
                                try {
                                    fileWriter2.close();
                                } catch (IOException e3) {
                                    e3.printStackTrace();
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            fileWriter = fileWriter3;
                            if (fileWriter != null) {
                                try {
                                    fileWriter.close();
                                } catch (IOException e4) {
                                    e4.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    } catch (IOException e5) {
                    } catch (Throwable th3) {
                        th = th3;
                        fileWriter = null;
                    }
                }
            }
        }
    }

    public static boolean delete(String str) {
        File file = new File(str);
        if (file.exists() && file.isFile()) {
            file.delete();
            return true;
        }
        return false;
    }
}

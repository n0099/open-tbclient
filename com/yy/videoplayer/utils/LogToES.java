package com.yy.videoplayer.utils;

import android.os.Environment;
import android.util.Log;
import com.baidu.down.request.db.DownloadDataConstants;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.yy.videoplayer.Constant;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.Locale;
/* loaded from: classes4.dex */
public class LogToES {
    private static final String BAK_EXT = ".bak";
    private static final int BAK_FILE_NUM_LIMIT = 2;
    private static final long DAY_DELAY = 864000000;
    private static final String LOG_NAME_PREFIX = "yysdk_adapter";
    private static final String LOG_PATH = "/logs";
    public static final int MAX_FILE_SIZE = 2;
    private static String TAG = "LogToES";
    private static final ThreadLocal<DateFormat> logFormater = new ThreadLocal<DateFormat>() { // from class: com.yy.videoplayer.utils.LogToES.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public DateFormat initialValue() {
            return new SimpleDateFormat("yyyy:MM:dd kk:mm:ss.SSS", Locale.getDefault());
        }
    };
    private static String s_LogPath = null;
    private static String s_AbsoluteLogPath = null;
    private static final SimpleDateFormat FILE_NAME_FORMAT = new SimpleDateFormat("MM-dd_HH-mm-ss", Locale.getDefault());
    private static final String[] LOGCAT_CMD = {"logcat", "-d", "-v", "time"};
    private static String mLogFileName = "";
    private static String mLogFilePath = "";

    public static String getLogPath() {
        return s_LogPath == null ? Constant.DEFAULT_LOG_PATH : s_LogPath;
    }

    public static String getAbsolutionLogPath() {
        return s_AbsoluteLogPath;
    }

    public static void setLogPath(String str) {
        s_LogPath = File.separator + str;
        s_AbsoluteLogPath = Environment.getExternalStorageDirectory().getAbsolutePath() + s_LogPath;
    }

    public static synchronized void writeLogToFile(String str, String str2, String str3) throws IOException {
        synchronized (LogToES.class) {
            writeLog(str, str2, str3);
        }
    }

    public static synchronized void writeLogToCacheFile(String str, String str2, String str3) throws IOException {
        synchronized (LogToES.class) {
            writeLog(str, str2, str3);
        }
    }

    public static void writeLog(String str, String str2, String str3) throws IOException {
        Date date = new Date();
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(str + File.separator + str2);
        if (!file2.exists()) {
            try {
                Log.i(TAG, "try to create new log file:" + file2.toString() + " path:" + str + " fileName:" + str2);
                file2.createNewFile();
            } catch (IOException e) {
                Log.e(TAG, "create new log file fail:" + e.getMessage());
                return;
            }
        } else if ((file2.length() >>> 20) > 2) {
            deleteOldLogs();
            String format = new SimpleDateFormat("-MM-dd-kk-mm-ss", Locale.getDefault()).format(date);
            StringBuilder sb = new StringBuilder(str);
            sb.append(File.separator).append(str2).append(format).append(BAK_EXT);
            file2.renameTo(new File(sb.toString()));
            Log.d("LogToES", "LogToES log keep volume.");
            limitVolume();
        }
        String str4 = logFormater.get().format(date) + ' ' + str3 + '\n';
        FileWriter fileWriter = new FileWriter(file2, true);
        fileWriter.write(str4);
        fileWriter.flush();
        fileWriter.close();
    }

    private static void deleteOldLogs() {
        File externalStorageDirectory;
        if (Environment.getExternalStorageDirectory().exists()) {
            File file = new File(externalStorageDirectory.getAbsolutePath() + getLogPath());
            if (file.exists()) {
                long currentTimeMillis = System.currentTimeMillis();
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    for (File file2 : listFiles) {
                        if (file2.getName().endsWith(BAK_EXT) && currentTimeMillis - file2.lastModified() > DAY_DELAY) {
                            file2.delete();
                        }
                    }
                }
            }
        }
    }

    private static void limitVolume() {
        File externalStorageDirectory;
        File[] listFiles;
        int i;
        if (Environment.getExternalStorageDirectory().exists()) {
            File file = new File(externalStorageDirectory.getAbsolutePath() + getLogPath());
            if (file.exists() && (listFiles = file.listFiles()) != null && listFiles.length > Math.max(0, 2)) {
                int i2 = 0;
                for (File file2 : listFiles) {
                    if (file2.getName().endsWith(BAK_EXT)) {
                        i2++;
                    }
                }
                if (i2 > 0) {
                    Log.d("LogToES", "LogToES there ARE " + i2 + " deletables.");
                    File[] fileArr = new File[i2];
                    int length = listFiles.length;
                    int i3 = 0;
                    int i4 = 0;
                    while (i3 < length) {
                        File file3 = listFiles[i3];
                        if (i4 >= i2) {
                            break;
                        }
                        if (file3.getName().endsWith(BAK_EXT)) {
                            i = i4 + 1;
                            fileArr[i4] = file3;
                        } else {
                            i = i4;
                        }
                        i3++;
                        i4 = i;
                    }
                    deleteIfOutOfBound(fileArr);
                }
            }
        }
    }

    private static void deleteIfOutOfBound(File[] fileArr) {
        if (fileArr.length > 2) {
            Arrays.sort(fileArr, new Comparator<File>() { // from class: com.yy.videoplayer.utils.LogToES.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                public int compare(File file, File file2) {
                    return file2.getName().compareTo(file.getName());
                }
            });
            int length = fileArr.length;
            for (int i = 0; i < 2; i++) {
                Log.d("LogToES", "LogToES keep file " + fileArr[i]);
            }
            for (int i2 = 2; i2 < length; i2++) {
                File file = fileArr[i2];
                if (!file.delete()) {
                    Log.e("LogToES", "LogToES failed to delete file " + file);
                } else {
                    Log.d("LogToES", "LogToES delete file " + file);
                }
            }
        }
    }

    public static void writeAllLogsToFile() {
        new Thread(new Runnable() { // from class: com.yy.videoplayer.utils.LogToES.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Date date = new Date();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(LogToES.LOGCAT_CMD).getInputStream()), 1024);
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        sb.append(readLine);
                        sb.append(System.getProperty("line.separator"));
                    }
                    bufferedReader.close();
                    String str = Environment.getExternalStorageDirectory().getAbsolutePath() + LogToES.getLogPath();
                    File file = new File(str);
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    File file2 = new File(str + File.separator + LogToES.FILE_NAME_FORMAT.format(date) + BdStatsConstant.StatsFile.LOG_FILE_SUFFIX);
                    if (!file2.exists()) {
                        file2.createNewFile();
                    }
                    FileOutputStream fileOutputStream = new FileOutputStream(file2);
                    fileOutputStream.write(sb.toString().getBytes());
                    fileOutputStream.flush();
                    fileOutputStream.close();
                } catch (IOException e) {
                    Log.e("yy", "Failed to writeAllLogsToFile " + e);
                }
            }
        }, "YY_yyvideolib_LogToES_Thread").start();
    }

    private static String findLastModifYMFLogFile() {
        File externalStorageDirectory;
        if (!Environment.getExternalStorageDirectory().exists()) {
            return createLogFileName();
        }
        File file = new File(externalStorageDirectory.getAbsolutePath() + getLogFilePath());
        if (!file.exists()) {
            return createLogFileName();
        }
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return createLogFileName();
        }
        File file2 = null;
        for (File file3 : listFiles) {
            if (file3.getName().startsWith(LOG_NAME_PREFIX) && (file2 == null || file2.lastModified() < file3.lastModified())) {
                file2 = file3;
            }
        }
        if (file2 != null) {
            return file2.getName();
        }
        return createLogFileName();
    }

    private static String createLogFileName() {
        return LOG_NAME_PREFIX + new SimpleDateFormat("-MM-dd-kk-mm").format(new Date()) + DownloadDataConstants.DEFAULT_DL_TEXT_EXTENSION;
    }

    public static void setLogFilePath(String str) {
        mLogFilePath = str;
    }

    public static String getLogFilePath() {
        if (mLogFilePath == null || mLogFilePath.trim().length() == 0) {
            mLogFilePath = "/yysdk/logs";
        }
        return mLogFilePath;
    }

    public static String getLogFileName() {
        if (mLogFileName == null || mLogFileName.trim().length() == 0) {
            mLogFileName = findLastModifYMFLogFile();
        }
        return mLogFileName;
    }
}

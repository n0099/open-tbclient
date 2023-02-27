package com.yy.hiidostatis.message.log;

import android.app.Application;
import android.content.Context;
import com.yy.hiidostatis.api.StatisContent;
import com.yy.hiidostatis.inner.util.ProcessUtil;
import com.yy.hiidostatis.inner.util.ThreadPool;
import com.yy.hiidostatis.inner.util.Util;
import com.yy.hiidostatis.inner.util.hdid.DeviceProxy;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Locale;
/* loaded from: classes8.dex */
public class TraceLog {
    public static final int INIT_FAILED = -1;
    public static final int INIT_SUCCESS = 1;
    public static final int LENGTH_APPKEY = 8;
    public static final long LOG_FILE_CAPACITY = 104857600;
    public static final String LOG_FILE_PREFIX = "hdtrace";
    public static final String LOG_FILE_SUB_PATH = "hdstatis";
    public static final int UNINIT = 0;
    public Context appContext;
    public String innerPath;
    public FileOutputStream stream;
    public volatile boolean writing;
    public static TraceLog logger = new TraceLog();
    public static boolean enable = true;
    public final StringBuilder cache = new StringBuilder();
    public volatile int initResult = 0;
    public Runnable writeRunnable = new Runnable() { // from class: com.yy.hiidostatis.message.log.TraceLog.1
        @Override // java.lang.Runnable
        public void run() {
            String sb;
            TraceLog.this.writing = false;
            if (TraceLog.this.initResult != 1) {
                TraceLog.this.cache.setLength(0);
                return;
            }
            if (TraceLog.this.stream == null) {
                try {
                    TraceLog.this.stream = new FileOutputStream(TraceLog.this.getFileName());
                } catch (Throwable th) {
                    th.printStackTrace();
                    return;
                }
            }
            try {
                synchronized (TraceLog.this.cache) {
                    sb = TraceLog.this.cache.toString();
                    TraceLog.this.cache.setLength(0);
                }
                if (!sb.isEmpty()) {
                    TraceLog.this.stream.write(sb.getBytes("UTF-8"));
                }
                TraceLog.this.stream.flush();
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    };

    private void startLogClean() {
        ThreadPool.getPool().execute(new Runnable() { // from class: com.yy.hiidostatis.message.log.TraceLog.2
            @Override // java.lang.Runnable
            public void run() {
                File[] listFiles;
                ArrayList arrayList = new ArrayList();
                if (TraceLog.this.innerPath != null && (listFiles = new File(TraceLog.this.innerPath).listFiles(new FilenameFilter() { // from class: com.yy.hiidostatis.message.log.TraceLog.2.1
                    @Override // java.io.FilenameFilter
                    public boolean accept(File file, String str) {
                        return str.startsWith(TraceLog.LOG_FILE_PREFIX);
                    }
                })) != null && listFiles.length > 0) {
                    arrayList.addAll(Arrays.asList(listFiles));
                }
                Collections.sort(arrayList, new Comparator<File>() { // from class: com.yy.hiidostatis.message.log.TraceLog.2.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // java.util.Comparator
                    public int compare(File file, File file2) {
                        return file.getName().compareTo(file2.getName());
                    }
                });
                if (arrayList.size() > 2) {
                    long j = 0;
                    for (int size = arrayList.size() - 2; size > 0; size--) {
                        File file = (File) arrayList.get(size);
                        j += file.length();
                        if (j > 104857600 && file.delete()) {
                            j -= file.length();
                        }
                    }
                }
            }
        });
    }

    private String ts() {
        return Util.formatDate("yyyyMMddHHmmssSSS", System.currentTimeMillis());
    }

    private void write() {
        if (this.initResult == 1 && !this.writing) {
            this.writing = true;
            ThreadPool.getPool().execute(this.writeRunnable);
        }
    }

    public static void addMessageLog(String str, StatisContent statisContent) {
        if (enable) {
            logger.addMessage(str, statisContent);
        }
    }

    private void dropMessage(String str, String str2) {
        if (this.initResult == -1) {
            return;
        }
        addLog(String.format(Locale.CHINA, "D,%s,%s_%s\n", ts(), str, str2));
    }

    public static void dropMessageLog(String str, String str2) {
        if (enable) {
            logger.dropMessage(str, str2);
        }
    }

    private void addLog(String str) {
        synchronized (this.cache) {
            this.cache.append(str);
        }
        write();
    }

    private void failedMessage(String str) {
        if (this.initResult == -1) {
            return;
        }
        addLog(String.format(Locale.CHINA, "E,%s,%s\n", ts(), str));
    }

    public static void failedMessageLog(String str) {
        if (enable) {
            logger.failedMessage(str);
        }
    }

    public static void initLog(Context context) {
        logger.init(context);
    }

    private void saveMessage(String str) {
        if (this.initResult == -1) {
            return;
        }
        addLog(String.format(Locale.CHINA, "S,%s,%s\n", ts(), str));
    }

    public static void saveMessageLog(String str) {
        if (enable) {
            logger.saveMessage(str);
        }
    }

    public static void setEnable(boolean z) {
        enable = z;
    }

    private void successMessage(String str) {
        if (this.initResult == -1) {
            return;
        }
        addLog(String.format(Locale.CHINA, "F,%s,%s\n", ts(), str));
    }

    public static void successMessageLog(String str) {
        if (enable) {
            logger.successMessage(str);
        }
    }

    private void addMessage(String str, StatisContent statisContent) {
        if (this.initResult == -1) {
            return;
        }
        try {
            Locale locale = Locale.CHINA;
            Object[] objArr = new Object[6];
            int i = 0;
            objArr[0] = ts();
            objArr[1] = str.substring(0, 8);
            objArr[2] = statisContent.getAct();
            objArr[3] = statisContent.getGuid();
            objArr[4] = Long.valueOf(statisContent.getAutoId());
            if (!statisContent.isNotSave()) {
                i = 1;
            }
            objArr[5] = Integer.valueOf(i);
            addLog(String.format(locale, "A,%s,%s,%s,%s,%d,%d\n", objArr));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getFileName() {
        String str = this.innerPath;
        try {
            new File(str).mkdirs();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        Locale locale = Locale.CHINA;
        Context context = this.appContext;
        return String.format(locale, "%s%s%s_%s_%s.txt", str, File.separator, LOG_FILE_PREFIX, ts(), ProcessUtil.getFileNameBindProcess(context, DeviceProxy.getHdid(context)));
    }

    public synchronized void init(Context context) {
        Context applicationContext;
        if (this.initResult == 0) {
            if (context instanceof Application) {
                applicationContext = context;
            } else {
                applicationContext = context.getApplicationContext();
            }
            this.appContext = applicationContext;
            this.innerPath = String.format(Locale.CHINA, "%s%s%s", context.getCacheDir().getAbsolutePath(), File.separator, LOG_FILE_SUB_PATH);
            this.initResult = 1;
            startLogClean();
        }
    }
}

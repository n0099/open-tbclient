package com.yy.hiidostatis.inner.util.log;

import android.app.Application;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.baidu.mobstat.Config;
import com.yy.hiidostatis.api.HiidoSDK;
import com.yy.hiidostatis.inner.BaseStatisContent;
import com.yy.hiidostatis.inner.util.ArdUtil;
import com.yy.hiidostatis.inner.util.DefaultPreference;
import com.yy.hiidostatis.inner.util.ThreadPool;
import com.yy.hiidostatis.inner.util.Util;
import com.yy.hiidostatis.inner.util.ZipUtil;
import com.yy.hiidostatis.inner.util.http.HttpUtil;
import com.yy.hiidostatis.testui.FloatingService;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class ActLog {
    public static final int LENGTH_APPKEY = 8;
    public static final String SEND_FAIL_LOG_SUFFIX = "-flog";
    public static final String SEND_SUC_LOG_SUFFIX = "-slog";
    public static final String TYPE_ADD = "Add";
    public static final String TYPE_DISCARD = "Dis";
    public static final String TYPE_FAIL = "Fail";
    public static final String TYPE_RETRY = "Retry";
    public static final String TYPE_SAVE = "Save";
    public static final String TYPE_SUC = "Suc";
    public static volatile String innerPath = null;
    public static volatile boolean innerPathValid = false;
    public static volatile ActLogListener mActLogListener = null;
    public static Context mContext = null;
    public static String mLogNamePre = "hdstatis";
    public static volatile AtomicLong countLength = new AtomicLong(0);
    public static volatile boolean initActLog = false;
    public static volatile boolean logEnable = true;
    public static ConcurrentHashMap<String, LogWriter> logWriters = new ConcurrentHashMap<>(3);
    public static AtomicBoolean isDelete = new AtomicBoolean(false);
    public static volatile boolean isWriteSucLog = false;
    public static volatile boolean isWriteFailLog = false;
    public static volatile String mUploadUrl = "https://config.bigda.com/api/upload";

    /* loaded from: classes10.dex */
    public interface ActLogListener {
        void sendFail(String str, String str2, String str3, String str4, Integer num, String str5, String str6, String str7);
    }

    /* loaded from: classes10.dex */
    public interface ILogConfigListener {
        JSONObject getLogConfig();
    }

    @Deprecated
    public static void setLogNamePre(String str) {
    }

    /* loaded from: classes10.dex */
    public static class LogWriter {
        public static final int BUFFER_MAX_LEN = 50;
        public volatile AtomicInteger bufferCount;
        public String dateString;
        public String fileNameTemplate;
        public ConcurrentLinkedQueue<String> logBuffer;
        public FileWriter logWriter;
        public String pid;
        public volatile AtomicBoolean writing;

        public LogWriter(String str) {
            this.pid = String.valueOf(Process.myPid());
            this.logBuffer = new ConcurrentLinkedQueue<>();
            this.writing = new AtomicBoolean(false);
            this.bufferCount = new AtomicInteger(0);
            this.fileNameTemplate = str;
        }

        private FileWriter getFileWriter() {
            String formatDate = Util.formatDate("yyyyMMdd", System.currentTimeMillis());
            if (this.logWriter != null && formatDate.equals(this.dateString)) {
                return this.logWriter;
            }
            synchronized (this) {
                if (this.logWriter != null && formatDate.equals(this.dateString)) {
                    return this.logWriter;
                }
                if (this.logWriter != null) {
                    try {
                        this.logWriter.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                this.dateString = formatDate;
                File file = new File(this.fileNameTemplate.replaceAll("#yyyyMMdd#", formatDate).replaceAll("#pid#", ""));
                if (file.exists() && !file.canWrite()) {
                    file = new File(this.fileNameTemplate.replaceAll("#yyyyMMdd#", this.dateString).replaceAll("#pid#", this.pid));
                }
                if (!file.getParentFile().exists()) {
                    file.getParentFile().mkdirs();
                }
                try {
                    FileWriter fileWriter = new FileWriter(file, true);
                    this.logWriter = fileWriter;
                    return fileWriter;
                } catch (IOException e2) {
                    e2.printStackTrace();
                    return null;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void writeLine(String str) {
            if (this.bufferCount.get() > 50) {
                return;
            }
            this.bufferCount.incrementAndGet();
            this.logBuffer.add(str);
            if (!this.writing.compareAndSet(false, true)) {
                return;
            }
            String poll = this.logBuffer.poll();
            FileWriter fileWriter = getFileWriter();
            while (poll != null && fileWriter != null) {
                this.bufferCount.decrementAndGet();
                try {
                    fileWriter.write(poll);
                    fileWriter.write("\n");
                    fileWriter.flush();
                    poll = this.logBuffer.poll();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            this.writing.set(false);
        }

        public synchronized void close() {
            if (this.logWriter != null) {
                try {
                    this.logWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                this.logWriter = null;
            }
        }
    }

    public static /* synthetic */ boolean access$1100() {
        return upload();
    }

    public static boolean isLogEnable() {
        return logEnable;
    }

    public static boolean upload() {
        if (innerPathValid) {
            return upload(innerPath);
        }
        return true;
    }

    public static void addLogLength(long j) {
        long addAndGet = countLength.addAndGet(j);
        if (addAndGet > 52428800) {
            countLength.getAndAdd(delLog(addAndGet - Config.FULL_TRACE_LOG_LIMIT) * (-1));
        }
    }

    public static long delLog(long j) {
        try {
            if (!innerPathValid) {
                return 0L;
            }
            return delLog(j, innerPath);
        } catch (Throwable th) {
            L.warn("ActLog", "delLogFile exception = %s", th);
            return 0L;
        }
    }

    public static String getAppkey(String str) {
        if (str.length() > 8) {
            return str.substring(0, 8);
        }
        return str;
    }

    public static Context getCtx(Context context) {
        if (context == null) {
            return mContext;
        }
        return context;
    }

    public static void setActLogListener(ActLogListener actLogListener) {
        mActLogListener = actLogListener;
    }

    public static void setLogEnable(boolean z) {
        logEnable = z;
    }

    public static void setUploadUrl(String str) {
        mUploadUrl = str;
    }

    public static void write(String str, String str2, Object... objArr) {
        try {
            String formatStr = Util.formatStr(str2, objArr);
            addLogLength(formatStr.length());
            getLogWriter(str).writeLine(formatStr);
        } catch (Throwable th) {
            L.debug("ActLog", "write Exception = %s", th);
        }
    }

    public static void delLogFile(final String str, final int i) {
        if (!isDelete.compareAndSet(false, true)) {
            return;
        }
        ThreadPool.getPool().execute(new Runnable() { // from class: com.yy.hiidostatis.inner.util.log.ActLog.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    File file = new File(str);
                    File[] listFiles = file.listFiles();
                    if (listFiles != null) {
                        int length = listFiles.length;
                        int i2 = 0;
                        for (File file2 : listFiles) {
                            String name = file2.getName();
                            if (ActLog.matchFileName(name, i)) {
                                boolean delete = file2.delete();
                                if (delete) {
                                    i2++;
                                }
                                L.debug("ActLog", "delLogFile [%s] = %b ", name, Boolean.valueOf(delete));
                            }
                        }
                        if (i2 == length) {
                            file.delete();
                        }
                    }
                } catch (Throwable th) {
                    L.warn("ActLog", "delLogFile exception = %s", th);
                }
            }
        });
    }

    public static boolean uploadFile(String str, String str2) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("file", str);
            return HttpUtil.postFileByUrlConn(mUploadUrl, null, hashMap).isSucceed;
        } catch (Throwable th) {
            L.error("ActLog", "uploadFile error.%s", th);
            return false;
        }
    }

    public static void uploadLog(Context context, final ILogConfigListener iLogConfigListener) {
        if (!initActLog(context)) {
            return;
        }
        ThreadPool.getPool().execute(new Runnable() { // from class: com.yy.hiidostatis.inner.util.log.ActLog.8
            @Override // java.lang.Runnable
            public void run() {
                boolean z;
                boolean z2;
                try {
                    String str = ActLog.mLogNamePre + "_uploadDate";
                    String formatDate = Util.formatDate("yyyyMMdd", System.currentTimeMillis());
                    boolean equals = formatDate.equals(DefaultPreference.getPreference().getPrefString(ActLog.mContext, str, null));
                    L.debug("ActLog", "uploadDate = %s,isReport = %b", formatDate, Boolean.valueOf(equals));
                    if (equals) {
                        return;
                    }
                    JSONObject logConfig = ILogConfigListener.this.getLogConfig();
                    if (logConfig != null && logConfig.has("sdkConfig")) {
                        JSONObject jSONObject = logConfig.getJSONObject("sdkConfig");
                        if (jSONObject.has("uploadUrl")) {
                            String unused = ActLog.mUploadUrl = jSONObject.getString("uploadUrl");
                        }
                        if (!jSONObject.has("suc")) {
                            z = ActLog.isWriteSucLog;
                        } else {
                            z = "1".equals(jSONObject.get("suc"));
                        }
                        boolean unused2 = ActLog.isWriteSucLog = z;
                        L.debug("ActLog", "isWriteSucLog = %b ", Boolean.valueOf(ActLog.isWriteSucLog));
                        if (!jSONObject.has("fai")) {
                            z2 = ActLog.isWriteFailLog;
                        } else {
                            z2 = "1".equals(jSONObject.get("fai"));
                        }
                        boolean unused3 = ActLog.isWriteFailLog = z2;
                        L.debug("ActLog", "isWriteFailLog = %b ", Boolean.valueOf(ActLog.isWriteFailLog));
                        if (ArdUtil.isWifiActive(ActLog.mContext) && ActLog.access$1100()) {
                            DefaultPreference.getPreference().setPrefString(ActLog.mContext, str, formatDate);
                            return;
                        }
                        return;
                    }
                    L.debug("ActLog", "sdkConfig is null", new Object[0]);
                } catch (Throwable th) {
                    L.error("ActLog", "uploadLog exception = %s", th);
                }
            }
        });
    }

    public static long delLog(long j, String str) {
        File[] listFiles = new File(str).listFiles();
        ArrayList arrayList = new ArrayList(listFiles.length);
        for (File file : listFiles) {
            arrayList.add(file);
        }
        Collections.sort(arrayList, new Comparator<File>() { // from class: com.yy.hiidostatis.inner.util.log.ActLog.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            public int compare(File file2, File file3) {
                if (file2.lastModified() <= file3.lastModified()) {
                    return -1;
                }
                return 1;
            }
        });
        Iterator it = arrayList.iterator();
        long j2 = 0;
        while (it.hasNext()) {
            File file2 = (File) it.next();
            long length = file2.length();
            if (file2.delete()) {
                j2 += length;
            }
            if (j2 >= j) {
                break;
            }
        }
        return j2;
    }

    public static boolean matchFileName(String str, int i) {
        try {
            if (Util.daysBetween(Util.parseDate("yyyyMMdd", str.substring(str.lastIndexOf("_") + 1, str.lastIndexOf(".")).substring(0, 8)).getTime(), System.currentTimeMillis()) > i) {
                return true;
            }
            return false;
        } catch (Throwable th) {
            L.warn("ActLog", "matchFileName excetion = %s", th);
            return false;
        }
    }

    public static LogWriter getLogWriter(String str) {
        if (str == null) {
            str = "";
        }
        LogWriter logWriter = logWriters.get(str);
        if (logWriter != null) {
            return logWriter;
        }
        synchronized ("ActLog") {
            LogWriter logWriter2 = logWriters.get(str);
            if (logWriter2 != null) {
                return logWriter2;
            }
            LogWriter logWriter3 = new LogWriter(String.format("%s%s%s_#yyyyMMdd##pid#.log%s", innerPath, File.separator, mLogNamePre, str));
            logWriters.put(str, logWriter3);
            return logWriter3;
        }
    }

    public static int[] getTotal(Context context, String str) {
        BufferedReader bufferedReader;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        char c;
        char c2;
        if (!initActLog(context)) {
            return new int[]{0, 0, 0, 0, 0};
        }
        try {
            ArrayList<File> arrayList = new ArrayList();
            if (innerPathValid) {
                Collections.addAll(arrayList, new File(innerPath).listFiles(new FileFilter() { // from class: com.yy.hiidostatis.inner.util.log.ActLog.4
                    public String pre = String.format("%s_%s", ActLog.mLogNamePre, Util.formatDate("yyyyMMdd", System.currentTimeMillis()));

                    @Override // java.io.FileFilter
                    public boolean accept(File file) {
                        if (file.isFile() && file.getName().endsWith(".log") && file.getName().startsWith(this.pre)) {
                            return true;
                        }
                        return false;
                    }
                }));
            }
            BufferedReader bufferedReader2 = null;
            i = 0;
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
            for (File file : arrayList) {
                try {
                    try {
                        bufferedReader = new BufferedReader(new FileReader(file));
                        String[] strArr = null;
                        while (true) {
                            try {
                                String readLine = bufferedReader.readLine();
                                if (readLine != null) {
                                    if (str != null) {
                                        strArr = readLine.split(",");
                                        if (strArr.length >= 4) {
                                            if (strArr.length > 8) {
                                                c2 = 3;
                                            } else {
                                                c2 = 2;
                                            }
                                            if (!str.startsWith(strArr[c2])) {
                                            }
                                        }
                                    }
                                    if (strArr.length > 8) {
                                        c = 4;
                                    } else {
                                        c = 3;
                                    }
                                    String str2 = strArr[c];
                                    if (TYPE_ADD.equals(str2)) {
                                        i++;
                                    } else if (TYPE_FAIL.equals(str2)) {
                                        i2++;
                                    } else if (TYPE_SUC.equals(str2)) {
                                        i3++;
                                    } else if (TYPE_DISCARD.equals(str2)) {
                                        i4++;
                                    } else if (TYPE_RETRY.equals(str2)) {
                                        i5++;
                                    }
                                } else {
                                    try {
                                        break;
                                    } catch (Throwable th) {
                                        th = th;
                                        try {
                                            L.error("ActLog", "getTotal Exception = %s", th);
                                            if (bufferedReader != null) {
                                                try {
                                                    bufferedReader.close();
                                                } catch (Throwable th2) {
                                                    L.error("ActLog", th2.getMessage(), new Object[0]);
                                                }
                                            }
                                            return new int[]{i, i2, i3, i4, i5};
                                        } catch (Throwable th3) {
                                            if (bufferedReader != null) {
                                                try {
                                                    bufferedReader.close();
                                                } catch (Throwable th4) {
                                                    L.error("ActLog", th4.getMessage(), new Object[0]);
                                                }
                                            }
                                            throw th3;
                                        }
                                    }
                                }
                            } catch (Throwable th5) {
                                th = th5;
                                bufferedReader2 = bufferedReader;
                                L.debug("ActLog", th.getMessage(), new Object[0]);
                                if (bufferedReader2 != null) {
                                    bufferedReader2.close();
                                    bufferedReader2 = null;
                                }
                            }
                        }
                        bufferedReader.close();
                    } catch (Throwable th6) {
                        th = th6;
                    }
                    bufferedReader2 = null;
                } catch (Throwable th7) {
                    th = th7;
                    bufferedReader = bufferedReader2;
                }
            }
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (Throwable th8) {
                    L.error("ActLog", th8.getMessage(), new Object[0]);
                }
            }
        } catch (Throwable th9) {
            th = th9;
            bufferedReader = null;
            i = 0;
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
        }
        return new int[]{i, i2, i3, i4, i5};
    }

    public static boolean initActLog(Context context) {
        Context applicationContext;
        if (initActLog) {
            return initActLog;
        }
        synchronized ("ActLog") {
            if (initActLog) {
                return initActLog;
            } else if (context == null) {
                return false;
            } else {
                if (context instanceof Application) {
                    applicationContext = context;
                } else {
                    applicationContext = context.getApplicationContext();
                }
                mContext = (Application) applicationContext;
                innerPath = String.format("%s/%s", context.getCacheDir().getAbsolutePath(), mLogNamePre);
                long j = 0;
                File file = new File(innerPath);
                if (file.exists()) {
                    innerPathValid = true;
                    for (File file2 : file.listFiles()) {
                        j += file2.length();
                    }
                }
                countLength.set(j);
                initActLog = true;
                return initActLog;
            }
        }
    }

    public static boolean upload(String str) {
        String str2;
        try {
            L.brief("upload begin,waiting...", new Object[0]);
            File file = new File(str);
            if (file.exists() && file.listFiles() != null && file.listFiles().length != 0) {
                String str3 = mLogNamePre + "_" + ArdUtil.getPackageName(mContext) + "_" + HiidoSDK.instance().getHdid(mContext) + "_" + Util.formatDate("yyyyMMddHHmmssSSS", System.currentTimeMillis()) + ".zip";
                String str4 = file.getParent() + File.separator + str3;
                ZipUtil.zipFolder(str, str4);
                L.debug("ActLog", "create zip=%s", str4);
                boolean uploadFile = uploadFile(str4, str3);
                L.debug("ActLog", "upload zip=%s isUpload=%b", str4, Boolean.valueOf(uploadFile));
                File file2 = new File(str4);
                L.debug("ActLog", "zip=%s length =%s ", str4, Long.valueOf(file2.length()));
                L.debug("ActLog", "delete zip=%s, delete =%b", str4, Boolean.valueOf(file2.delete()));
                if (uploadFile) {
                    str2 = "upload file success!";
                } else {
                    str2 = "upload file fail!";
                }
                L.brief(str2, new Object[0]);
                if (uploadFile) {
                    isDelete.set(false);
                    delLogFile(str, 1);
                }
                return uploadFile;
            }
            L.brief("no upload file, end", new Object[0]);
            return true;
        } catch (Throwable th) {
            L.error("ActLog", "upload error = %s", th);
            return false;
        }
    }

    public static void writeActLog(Context context, final String str, final String str2, final String str3, final String str4, final String str5) {
        if (!logEnable || !initActLog(context)) {
            return;
        }
        ThreadPool.getPool().execute(new Runnable() { // from class: com.yy.hiidostatis.inner.util.log.ActLog.3
            @Override // java.lang.Runnable
            public void run() {
                String str6;
                String str7;
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    String formatDate = Util.formatDate("yyyyMMddHHmmss", currentTimeMillis);
                    Map<String, String> parseParams = Util.parseParams(str2);
                    String formatDate2 = Util.formatDate("HH:mm:ss", System.currentTimeMillis());
                    String str8 = parseParams.get(BaseStatisContent.GUID);
                    String str9 = parseParams.get("act");
                    parseParams.clear();
                    String appkey = ActLog.getAppkey(parseParams.get("appkey"));
                    FloatingService.INSTANCT.addLog(formatDate2, appkey, str, str8, str9);
                    Object[] objArr = new Object[9];
                    objArr[0] = Long.valueOf(currentTimeMillis);
                    objArr[1] = formatDate;
                    objArr[2] = str8;
                    objArr[3] = appkey;
                    objArr[4] = str;
                    objArr[5] = str9;
                    String str10 = "-";
                    if (str3 == null) {
                        str6 = "-";
                    } else {
                        str6 = str3;
                    }
                    objArr[6] = str6;
                    if (str4 == null) {
                        str7 = "-";
                    } else {
                        str7 = str4;
                    }
                    objArr[7] = str7;
                    if (str5 != null) {
                        str10 = str5;
                    }
                    objArr[8] = str10;
                    ActLog.write(null, "%d,%s,%s,%s,%s,%s,%s,%s,%s", objArr);
                } catch (Throwable th) {
                    L.debug("ActLog", "writeActLog Exception = %s", th);
                }
            }
        });
    }

    public static void writeActLog(Context context, final String str, final String str2, final String str3, final String str4, final String str5, final String str6, final String str7) {
        if (!logEnable || !initActLog(context)) {
            return;
        }
        ThreadPool.getPool().execute(new Runnable() { // from class: com.yy.hiidostatis.inner.util.log.ActLog.2
            @Override // java.lang.Runnable
            public void run() {
                String str8;
                String str9;
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    String formatDate = Util.formatDate("yyyyMMddHHmmss", currentTimeMillis);
                    FloatingService.INSTANCT.addLog(Util.formatDate("HH:mm:ss", System.currentTimeMillis()), str3, str, str4, str2);
                    Object[] objArr = new Object[9];
                    objArr[0] = Long.valueOf(currentTimeMillis);
                    objArr[1] = formatDate;
                    objArr[2] = str4;
                    objArr[3] = str3;
                    objArr[4] = str;
                    objArr[5] = str2;
                    String str10 = "-";
                    if (str5 == null) {
                        str8 = "-";
                    } else {
                        str8 = str5;
                    }
                    objArr[6] = str8;
                    if (str6 == null) {
                        str9 = "-";
                    } else {
                        str9 = str6;
                    }
                    objArr[7] = str9;
                    if (str7 != null) {
                        str10 = str7;
                    }
                    objArr[8] = str10;
                    ActLog.write(null, "%d,%s,%s,%s,%s,%s,%s,%s,%s", objArr);
                } catch (Throwable th) {
                    L.debug("ActLog", "writeActLog Exception = %s", th);
                }
            }
        });
    }

    public static void writeSendFailLog(Context context, final String str, final String str2, final String str3, final String str4, final String str5, final Integer num) {
        if (!logEnable) {
            return;
        }
        if ((!L.isLogOn() && !isWriteFailLog) || !initActLog(context)) {
            return;
        }
        ThreadPool.getPool().execute(new Runnable() { // from class: com.yy.hiidostatis.inner.util.log.ActLog.7
            @Override // java.lang.Runnable
            public void run() {
                String str6;
                String str7;
                try {
                    String str8 = str2;
                    if (str8 != null) {
                        str8 = (str8 + "\n" + InetAddress.getByName(str2).getHostAddress()) + "\n" + TextUtils.join(" ", InetAddress.getAllByName(str2));
                    }
                    String formatDate = Util.formatDate("yyyyMMddHHmmss", System.currentTimeMillis());
                    Map<String, String> parseParams = Util.parseParams(str3);
                    String str9 = parseParams.get(BaseStatisContent.GUID);
                    String str10 = parseParams.get("act");
                    String str11 = parseParams.get("appkey");
                    parseParams.clear();
                    String appkey = ActLog.getAppkey(str11);
                    Object[] objArr = new Object[9];
                    objArr[0] = formatDate;
                    objArr[1] = str9;
                    objArr[2] = appkey;
                    objArr[3] = str10;
                    Object obj = "-";
                    if (str == null) {
                        str6 = "-";
                    } else {
                        str6 = str;
                    }
                    objArr[4] = str6;
                    if (str2 == null) {
                        str7 = "-";
                    } else {
                        str7 = str2;
                    }
                    objArr[5] = str7;
                    if (num != null) {
                        obj = num;
                    }
                    objArr[6] = obj;
                    objArr[7] = str5;
                    objArr[8] = str4 + str8;
                    ActLog.write(ActLog.SEND_FAIL_LOG_SUFFIX, "%s,%s,%s,%s,%s,%s,%s,%s,%s", objArr);
                    if (ActLog.mActLogListener != null) {
                        ActLog.mActLogListener.sendFail(str11, str9, str, str10, num, str2, str5, str4);
                    }
                } catch (Throwable th) {
                    L.error("ActLog", "writeSendFailLog Exception = %s", th);
                }
            }
        });
    }

    public static void writeSendSucLog(Context context, final String str, final String str2, final String str3) {
        if (!logEnable) {
            return;
        }
        if ((!L.isLogOn() && !isWriteSucLog) || !initActLog(context)) {
            return;
        }
        ThreadPool.getPool().execute(new Runnable() { // from class: com.yy.hiidostatis.inner.util.log.ActLog.6
            @Override // java.lang.Runnable
            public void run() {
                String str4;
                try {
                    String formatDate = Util.formatDate("yyyyMMddHHmmss", System.currentTimeMillis());
                    Map<String, String> parseParams = Util.parseParams(str3);
                    parseParams.clear();
                    String appkey = ActLog.getAppkey(parseParams.get("appkey"));
                    Object[] objArr = new Object[6];
                    objArr[0] = formatDate;
                    objArr[1] = parseParams.get(BaseStatisContent.GUID);
                    objArr[2] = appkey;
                    objArr[3] = parseParams.get("act");
                    String str5 = "-";
                    if (str == null) {
                        str4 = "-";
                    } else {
                        str4 = str;
                    }
                    objArr[4] = str4;
                    if (str2 != null) {
                        str5 = str2;
                    }
                    objArr[5] = str5;
                    ActLog.write(ActLog.SEND_SUC_LOG_SUFFIX, "%s,%s,%s,%s,%s,%s", objArr);
                } catch (Throwable th) {
                    L.error("ActLog", "writeSendSucLog Exception = %s", th);
                }
            }
        });
    }
}

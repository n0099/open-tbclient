package com.yy.hiidostatis.inner.util.log;

import android.app.Application;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobstat.Config;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes8.dex */
public class ActLog {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int LENGTH_APPKEY = 8;
    public static final String SEND_FAIL_LOG_SUFFIX = "-flog";
    public static final String SEND_SUC_LOG_SUFFIX = "-slog";
    public static final String TYPE_ADD = "Add";
    public static final String TYPE_DISCARD = "Dis";
    public static final String TYPE_FAIL = "Fail";
    public static final String TYPE_RETRY = "Retry";
    public static final String TYPE_SAVE = "Save";
    public static final String TYPE_SUC = "Suc";
    public static volatile AtomicLong countLength = null;
    public static volatile boolean initActLog = false;
    public static volatile String innerPath = null;
    public static volatile boolean innerPathValid = false;
    public static AtomicBoolean isDelete = null;
    public static volatile boolean isWriteFailLog = false;
    public static volatile boolean isWriteSucLog = false;
    public static volatile boolean logEnable = false;
    public static ConcurrentHashMap<String, LogWriter> logWriters = null;
    public static volatile ActLogListener mActLogListener = null;
    public static Context mContext = null;
    public static String mLogNamePre = "hdstatis";
    public static volatile String mUploadUrl;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public interface ActLogListener {
        void sendFail(String str, String str2, String str3, String str4, Integer num, String str5, String str6, String str7);
    }

    /* loaded from: classes8.dex */
    public interface ILogConfigListener {
        JSONObject getLogConfig();
    }

    /* loaded from: classes8.dex */
    public static class LogWriter {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int BUFFER_MAX_LEN = 50;
        public transient /* synthetic */ FieldHolder $fh;
        public volatile AtomicInteger bufferCount;
        public String dateString;
        public String fileNameTemplate;
        public ConcurrentLinkedQueue<String> logBuffer;
        public FileWriter logWriter;
        public String pid;
        public volatile AtomicBoolean writing;

        private FileWriter getFileWriter() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
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
            return (FileWriter) invokeV.objValue;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void writeLine(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, str) == null) || this.bufferCount.get() > 50) {
                return;
            }
            this.bufferCount.incrementAndGet();
            this.logBuffer.add(str);
            if (this.writing.compareAndSet(false, true)) {
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
        }

        public synchronized void close() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this) {
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
        }

        public LogWriter(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.pid = String.valueOf(Process.myPid());
            this.logBuffer = new ConcurrentLinkedQueue<>();
            this.writing = new AtomicBoolean(false);
            this.bufferCount = new AtomicInteger(0);
            this.fileNameTemplate = str;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1585592515, "Lcom/yy/hiidostatis/inner/util/log/ActLog;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1585592515, "Lcom/yy/hiidostatis/inner/util/log/ActLog;");
                return;
            }
        }
        countLength = new AtomicLong(0L);
        initActLog = false;
        logEnable = true;
        logWriters = new ConcurrentHashMap<>(3);
        isDelete = new AtomicBoolean(false);
        isWriteSucLog = false;
        isWriteFailLog = false;
        mUploadUrl = "https://config.bigda.com/api/upload";
    }

    public ActLog() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void addLogLength(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65550, null, j) == null) {
            long addAndGet = countLength.addAndGet(j);
            if (addAndGet > 52428800) {
                countLength.getAndAdd(delLog(addAndGet - Config.FULL_TRACE_LOG_LIMIT) * (-1));
            }
        }
    }

    public static long delLog(long j, String str) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(65552, null, j, str)) == null) {
            File[] listFiles = new File(str).listFiles();
            ArrayList arrayList = new ArrayList(listFiles.length);
            for (File file : listFiles) {
                arrayList.add(file);
            }
            Collections.sort(arrayList, new Comparator<File>() { // from class: com.yy.hiidostatis.inner.util.log.ActLog.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                public int compare(File file2, File file3) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, file2, file3)) == null) ? file2.lastModified() <= file3.lastModified() ? -1 : 1 : invokeLL.intValue;
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
        return invokeJL.longValue;
    }

    public static void delLogFile(String str, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(65553, null, str, i) == null) && isDelete.compareAndSet(false, true)) {
            ThreadPool.getPool().execute(new Runnable(str, i) { // from class: com.yy.hiidostatis.inner.util.log.ActLog.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ int val$dayAgo;
                public final /* synthetic */ String val$path;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {str, Integer.valueOf(i)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$path = str;
                    this.val$dayAgo = i;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            File file = new File(this.val$path);
                            File[] listFiles = file.listFiles();
                            if (listFiles != null) {
                                int length = listFiles.length;
                                int i2 = 0;
                                for (File file2 : listFiles) {
                                    String name = file2.getName();
                                    if (ActLog.matchFileName(name, this.val$dayAgo)) {
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
                }
            });
        }
    }

    public static String getAppkey(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65554, null, str)) == null) ? str.length() > 8 ? str.substring(0, 8) : str : (String) invokeL.objValue;
    }

    public static Context getCtx(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65555, null, context)) == null) ? context == null ? mContext : context : (Context) invokeL.objValue;
    }

    public static LogWriter getLogWriter(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65556, null, str)) == null) {
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
        return (LogWriter) invokeL.objValue;
    }

    public static int[] getTotal(Context context, String str) {
        InterceptResult invokeLL;
        BufferedReader bufferedReader;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65557, null, context, str)) == null) {
            if (initActLog(context)) {
                try {
                    ArrayList<File> arrayList = new ArrayList();
                    if (innerPathValid) {
                        Collections.addAll(arrayList, new File(innerPath).listFiles(new FileFilter() { // from class: com.yy.hiidostatis.inner.util.log.ActLog.4
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public String pre;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i6 = newInitContext.flag;
                                    if ((i6 & 1) != 0) {
                                        int i7 = i6 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.pre = String.format("%s_%s", ActLog.mLogNamePre, Util.formatDate("yyyyMMdd", System.currentTimeMillis()));
                            }

                            @Override // java.io.FileFilter
                            public boolean accept(File file) {
                                InterceptResult invokeL;
                                Interceptable interceptable2 = $ic;
                                return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, file)) == null) ? file.isFile() && file.getName().endsWith(".log") && file.getName().startsWith(this.pre) : invokeL.booleanValue;
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
                                                    if (!str.startsWith(strArr[strArr.length > 8 ? (char) 3 : (char) 2])) {
                                                    }
                                                }
                                            }
                                            String str2 = strArr[strArr.length > 8 ? (char) 4 : (char) 3];
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
            return new int[]{0, 0, 0, 0, 0};
        }
        return (int[]) invokeLL.objValue;
    }

    public static boolean initActLog(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65558, null, context)) == null) {
            if (initActLog) {
                return initActLog;
            }
            synchronized ("ActLog") {
                if (initActLog) {
                    return initActLog;
                }
                if (context == null) {
                    return false;
                }
                mContext = (Application) (context instanceof Application ? context : context.getApplicationContext());
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
        return invokeL.booleanValue;
    }

    public static boolean isLogEnable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65559, null)) == null) ? logEnable : invokeV.booleanValue;
    }

    public static boolean matchFileName(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65560, null, str, i)) == null) {
            try {
                return Util.daysBetween(Util.parseDate("yyyyMMdd", str.substring(str.lastIndexOf("_") + 1, str.lastIndexOf(".")).substring(0, 8)).getTime(), System.currentTimeMillis()) > i;
            } catch (Throwable th) {
                L.warn("ActLog", "matchFileName excetion = %s", th);
                return false;
            }
        }
        return invokeLI.booleanValue;
    }

    public static void setActLogListener(ActLogListener actLogListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65561, null, actLogListener) == null) {
            mActLogListener = actLogListener;
        }
    }

    public static void setLogEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65562, null, z) == null) {
            logEnable = z;
        }
    }

    @Deprecated
    public static void setLogNamePre(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65563, null, str) == null) {
        }
    }

    public static void setUploadUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65564, null, str) == null) {
            mUploadUrl = str;
        }
    }

    public static boolean upload() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65565, null)) == null) {
            if (innerPathValid) {
                return upload(innerPath);
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public static boolean uploadFile(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65567, null, str, str2)) == null) {
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("file", str);
                return HttpUtil.postFileByUrlConn(mUploadUrl, null, hashMap).isSucceed;
            } catch (Throwable th) {
                L.error("ActLog", "uploadFile error.%s", th);
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public static void uploadLog(Context context, ILogConfigListener iLogConfigListener) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65568, null, context, iLogConfigListener) == null) && initActLog(context)) {
            ThreadPool.getPool().execute(new Runnable(iLogConfigListener) { // from class: com.yy.hiidostatis.inner.util.log.ActLog.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ILogConfigListener val$logConfigListener;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {iLogConfigListener};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$logConfigListener = iLogConfigListener;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            String str = ActLog.mLogNamePre + "_uploadDate";
                            String formatDate = Util.formatDate("yyyyMMdd", System.currentTimeMillis());
                            boolean equals = formatDate.equals(DefaultPreference.getPreference().getPrefString(ActLog.mContext, str, null));
                            L.debug("ActLog", "uploadDate = %s,isReport = %b", formatDate, Boolean.valueOf(equals));
                            if (equals) {
                                return;
                            }
                            JSONObject logConfig = this.val$logConfigListener.getLogConfig();
                            if (logConfig != null && logConfig.has("sdkConfig")) {
                                JSONObject jSONObject = logConfig.getJSONObject("sdkConfig");
                                if (jSONObject.has("uploadUrl")) {
                                    String unused = ActLog.mUploadUrl = jSONObject.getString("uploadUrl");
                                }
                                boolean unused2 = ActLog.isWriteSucLog = jSONObject.has("suc") ? "1".equals(jSONObject.get("suc")) : ActLog.isWriteSucLog;
                                L.debug("ActLog", "isWriteSucLog = %b ", Boolean.valueOf(ActLog.isWriteSucLog));
                                boolean unused3 = ActLog.isWriteFailLog = jSONObject.has("fai") ? "1".equals(jSONObject.get("fai")) : ActLog.isWriteFailLog;
                                L.debug("ActLog", "isWriteFailLog = %b ", Boolean.valueOf(ActLog.isWriteFailLog));
                                if (ArdUtil.isWifiActive(ActLog.mContext) && ActLog.upload()) {
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
                }
            });
        }
    }

    public static void write(String str, String str2, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65569, null, str, str2, objArr) == null) {
            try {
                String formatStr = Util.formatStr(str2, objArr);
                addLogLength(formatStr.length());
                getLogWriter(str).writeLine(formatStr);
            } catch (Throwable th) {
                L.debug("ActLog", "write Exception = %s", th);
            }
        }
    }

    public static void writeActLog(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65571, null, new Object[]{context, str, str2, str3, str4, str5, str6, str7}) == null) && logEnable && initActLog(context)) {
            ThreadPool.getPool().execute(new Runnable(str3, str, str4, str2, str5, str6, str7) { // from class: com.yy.hiidostatis.inner.util.log.ActLog.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ String val$act;
                public final /* synthetic */ String val$appkey;
                public final /* synthetic */ String val$extra;
                public final /* synthetic */ String val$guid;
                public final /* synthetic */ String val$host;
                public final /* synthetic */ String val$smkdata;
                public final /* synthetic */ String val$type;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {str3, str, str4, str2, str5, str6, str7};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$appkey = str3;
                    this.val$type = str;
                    this.val$guid = str4;
                    this.val$act = str2;
                    this.val$smkdata = str5;
                    this.val$host = str6;
                    this.val$extra = str7;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            long currentTimeMillis = System.currentTimeMillis();
                            String formatDate = Util.formatDate("yyyyMMddHHmmss", currentTimeMillis);
                            FloatingService.INSTANCT.addLog(Util.formatDate("HH:mm:ss", System.currentTimeMillis()), this.val$appkey, this.val$type, this.val$guid, this.val$act);
                            Object[] objArr = new Object[9];
                            objArr[0] = Long.valueOf(currentTimeMillis);
                            objArr[1] = formatDate;
                            objArr[2] = this.val$guid;
                            objArr[3] = this.val$appkey;
                            objArr[4] = this.val$type;
                            objArr[5] = this.val$act;
                            String str8 = "-";
                            objArr[6] = this.val$smkdata == null ? "-" : this.val$smkdata;
                            objArr[7] = this.val$host == null ? "-" : this.val$host;
                            if (this.val$extra != null) {
                                str8 = this.val$extra;
                            }
                            objArr[8] = str8;
                            ActLog.write(null, "%d,%s,%s,%s,%s,%s,%s,%s,%s", objArr);
                        } catch (Throwable th) {
                            L.debug("ActLog", "writeActLog Exception = %s", th);
                        }
                    }
                }
            });
        }
    }

    public static void writeSendFailLog(Context context, String str, String str2, String str3, String str4, String str5, Integer num) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65572, null, new Object[]{context, str, str2, str3, str4, str5, num}) == null) && logEnable) {
            if ((L.isLogOn() || isWriteFailLog) && initActLog(context)) {
                ThreadPool.getPool().execute(new Runnable(str2, str3, str, num, str5, str4) { // from class: com.yy.hiidostatis.inner.util.log.ActLog.7
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ String val$content;
                    public final /* synthetic */ String val$error;
                    public final /* synthetic */ String val$errorCode;
                    public final /* synthetic */ String val$host;
                    public final /* synthetic */ Integer val$retry;
                    public final /* synthetic */ String val$smkdata;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {str2, str3, str, num, str5, str4};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.val$host = str2;
                        this.val$content = str3;
                        this.val$smkdata = str;
                        this.val$retry = num;
                        this.val$errorCode = str5;
                        this.val$error = str4;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            try {
                                String str6 = this.val$host;
                                if (str6 != null) {
                                    str6 = (str6 + "\n" + InetAddress.getByName(this.val$host).getHostAddress()) + "\n" + TextUtils.join(" ", InetAddress.getAllByName(this.val$host));
                                }
                                String formatDate = Util.formatDate("yyyyMMddHHmmss", System.currentTimeMillis());
                                Map<String, String> parseParams = Util.parseParams(this.val$content);
                                String str7 = parseParams.get(BaseStatisContent.GUID);
                                String str8 = parseParams.get("act");
                                String str9 = parseParams.get("appkey");
                                parseParams.clear();
                                String appkey = ActLog.getAppkey(str9);
                                Object[] objArr = new Object[9];
                                objArr[0] = formatDate;
                                objArr[1] = str7;
                                objArr[2] = appkey;
                                objArr[3] = str8;
                                Object obj = "-";
                                objArr[4] = this.val$smkdata == null ? "-" : this.val$smkdata;
                                objArr[5] = this.val$host == null ? "-" : this.val$host;
                                if (this.val$retry != null) {
                                    obj = this.val$retry;
                                }
                                objArr[6] = obj;
                                objArr[7] = this.val$errorCode;
                                objArr[8] = this.val$error + str6;
                                ActLog.write(ActLog.SEND_FAIL_LOG_SUFFIX, "%s,%s,%s,%s,%s,%s,%s,%s,%s", objArr);
                                if (ActLog.mActLogListener != null) {
                                    ActLog.mActLogListener.sendFail(str9, str7, this.val$smkdata, str8, this.val$retry, this.val$host, this.val$errorCode, this.val$error);
                                }
                            } catch (Throwable th) {
                                L.error("ActLog", "writeSendFailLog Exception = %s", th);
                            }
                        }
                    }
                });
            }
        }
    }

    public static void writeSendSucLog(Context context, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(65573, null, context, str, str2, str3) == null) && logEnable) {
            if ((L.isLogOn() || isWriteSucLog) && initActLog(context)) {
                ThreadPool.getPool().execute(new Runnable(str3, str, str2) { // from class: com.yy.hiidostatis.inner.util.log.ActLog.6
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ String val$content;
                    public final /* synthetic */ String val$host;
                    public final /* synthetic */ String val$smkdata;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {str3, str, str2};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.val$content = str3;
                        this.val$smkdata = str;
                        this.val$host = str2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            try {
                                String formatDate = Util.formatDate("yyyyMMddHHmmss", System.currentTimeMillis());
                                Map<String, String> parseParams = Util.parseParams(this.val$content);
                                parseParams.clear();
                                String appkey = ActLog.getAppkey(parseParams.get("appkey"));
                                Object[] objArr = new Object[6];
                                objArr[0] = formatDate;
                                objArr[1] = parseParams.get(BaseStatisContent.GUID);
                                objArr[2] = appkey;
                                objArr[3] = parseParams.get("act");
                                String str4 = "-";
                                objArr[4] = this.val$smkdata == null ? "-" : this.val$smkdata;
                                if (this.val$host != null) {
                                    str4 = this.val$host;
                                }
                                objArr[5] = str4;
                                ActLog.write(ActLog.SEND_SUC_LOG_SUFFIX, "%s,%s,%s,%s,%s,%s", objArr);
                            } catch (Throwable th) {
                                L.error("ActLog", "writeSendSucLog Exception = %s", th);
                            }
                        }
                    }
                });
            }
        }
    }

    public static boolean upload(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65566, null, str)) == null) {
            try {
                L.brief("upload begin,waiting...", new Object[0]);
                File file = new File(str);
                if (file.exists() && file.listFiles() != null && file.listFiles().length != 0) {
                    String str2 = mLogNamePre + "_" + ArdUtil.getPackageName(mContext) + "_" + HiidoSDK.instance().getHdid(mContext) + "_" + Util.formatDate("yyyyMMddHHmmssSSS", System.currentTimeMillis()) + ".zip";
                    String str3 = file.getParent() + File.separator + str2;
                    ZipUtil.zipFolder(str, str3);
                    L.debug("ActLog", "create zip=%s", str3);
                    boolean uploadFile = uploadFile(str3, str2);
                    L.debug("ActLog", "upload zip=%s isUpload=%b", str3, Boolean.valueOf(uploadFile));
                    File file2 = new File(str3);
                    L.debug("ActLog", "zip=%s length =%s ", str3, Long.valueOf(file2.length()));
                    L.debug("ActLog", "delete zip=%s, delete =%b", str3, Boolean.valueOf(file2.delete()));
                    L.brief(uploadFile ? "upload file success!" : "upload file fail!", new Object[0]);
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
        return invokeL.booleanValue;
    }

    public static void writeActLog(Context context, String str, String str2, String str3, String str4, String str5) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65570, null, new Object[]{context, str, str2, str3, str4, str5}) == null) && logEnable && initActLog(context)) {
            ThreadPool.getPool().execute(new Runnable(str2, str, str3, str4, str5) { // from class: com.yy.hiidostatis.inner.util.log.ActLog.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ String val$content;
                public final /* synthetic */ String val$extra;
                public final /* synthetic */ String val$host;
                public final /* synthetic */ String val$smkdata;
                public final /* synthetic */ String val$type;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {str2, str, str3, str4, str5};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$content = str2;
                    this.val$type = str;
                    this.val$smkdata = str3;
                    this.val$host = str4;
                    this.val$extra = str5;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            long currentTimeMillis = System.currentTimeMillis();
                            String formatDate = Util.formatDate("yyyyMMddHHmmss", currentTimeMillis);
                            Map<String, String> parseParams = Util.parseParams(this.val$content);
                            String formatDate2 = Util.formatDate("HH:mm:ss", System.currentTimeMillis());
                            String str6 = parseParams.get(BaseStatisContent.GUID);
                            String str7 = parseParams.get("act");
                            parseParams.clear();
                            String appkey = ActLog.getAppkey(parseParams.get("appkey"));
                            FloatingService.INSTANCT.addLog(formatDate2, appkey, this.val$type, str6, str7);
                            Object[] objArr = new Object[9];
                            objArr[0] = Long.valueOf(currentTimeMillis);
                            objArr[1] = formatDate;
                            objArr[2] = str6;
                            objArr[3] = appkey;
                            objArr[4] = this.val$type;
                            objArr[5] = str7;
                            String str8 = "-";
                            objArr[6] = this.val$smkdata == null ? "-" : this.val$smkdata;
                            objArr[7] = this.val$host == null ? "-" : this.val$host;
                            if (this.val$extra != null) {
                                str8 = this.val$extra;
                            }
                            objArr[8] = str8;
                            ActLog.write(null, "%d,%s,%s,%s,%s,%s,%s,%s,%s", objArr);
                        } catch (Throwable th) {
                            L.debug("ActLog", "writeActLog Exception = %s", th);
                        }
                    }
                }
            });
        }
    }

    public static long delLog(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65551, null, j)) == null) {
            try {
                if (innerPathValid) {
                    return delLog(j, innerPath);
                }
                return 0L;
            } catch (Throwable th) {
                L.warn("ActLog", "delLogFile exception = %s", th);
                return 0L;
            }
        }
        return invokeJ.longValue;
    }
}

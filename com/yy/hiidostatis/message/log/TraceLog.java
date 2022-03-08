package com.yy.hiidostatis.message.log;

import android.app.Application;
import android.content.Context;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
    public static /* synthetic */ Interceptable $ic = null;
    public static final int INIT_FAILED = -1;
    public static final int INIT_SUCCESS = 1;
    public static final int LENGTH_APPKEY = 8;
    public static final long LOG_FILE_CAPACITY = 104857600;
    public static final String LOG_FILE_PREFIX = "hdtrace";
    public static final String LOG_FILE_SUB_PATH = "hdstatis";
    public static final int UNINIT = 0;
    public static boolean enable;
    public static TraceLog logger;
    public transient /* synthetic */ FieldHolder $fh;
    public Context appContext;
    public final StringBuilder cache;
    public volatile int initResult;
    public String innerPath;
    public FileOutputStream stream;
    public Runnable writeRunnable;
    public volatile boolean writing;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1372712662, "Lcom/yy/hiidostatis/message/log/TraceLog;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1372712662, "Lcom/yy/hiidostatis/message/log/TraceLog;");
                return;
            }
        }
        logger = new TraceLog();
        enable = true;
    }

    public TraceLog() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.cache = new StringBuilder();
        this.initResult = 0;
        this.writeRunnable = new Runnable(this) { // from class: com.yy.hiidostatis.message.log.TraceLog.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ TraceLog this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                String sb;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.this$0.writing = false;
                    if (this.this$0.initResult != 1) {
                        this.this$0.cache.setLength(0);
                        return;
                    }
                    if (this.this$0.stream == null) {
                        try {
                            this.this$0.stream = new FileOutputStream(this.this$0.getFileName());
                        } catch (Throwable th) {
                            th.printStackTrace();
                            return;
                        }
                    }
                    try {
                        synchronized (this.this$0.cache) {
                            sb = this.this$0.cache.toString();
                            this.this$0.cache.setLength(0);
                        }
                        if (!sb.isEmpty()) {
                            this.this$0.stream.write(sb.getBytes("UTF-8"));
                        }
                        this.this$0.stream.flush();
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                    }
                }
            }
        };
    }

    private void addLog(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, this, str) == null) {
            synchronized (this.cache) {
                this.cache.append(str);
            }
            write();
        }
    }

    private void addMessage(String str, StatisContent statisContent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65546, this, str, statisContent) == null) || this.initResult == -1) {
            return;
        }
        try {
            Locale locale = Locale.CHINA;
            Object[] objArr = new Object[6];
            int i2 = 0;
            objArr[0] = ts();
            objArr[1] = str.substring(0, 8);
            objArr[2] = statisContent.getAct();
            objArr[3] = statisContent.getGuid();
            objArr[4] = Long.valueOf(statisContent.getAutoId());
            if (!statisContent.isNotSave()) {
                i2 = 1;
            }
            objArr[5] = Integer.valueOf(i2);
            addLog(String.format(locale, "A,%s,%s,%s,%s,%d,%d\n", objArr));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void addMessageLog(String str, StatisContent statisContent) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65547, null, str, statisContent) == null) && enable) {
            logger.addMessage(str, statisContent);
        }
    }

    private void dropMessage(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65548, this, str, str2) == null) || this.initResult == -1) {
            return;
        }
        addLog(String.format(Locale.CHINA, "D,%s,%s_%s\n", ts(), str, str2));
    }

    public static void dropMessageLog(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65549, null, str, str2) == null) && enable) {
            logger.dropMessage(str, str2);
        }
    }

    private void failedMessage(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65550, this, str) == null) || this.initResult == -1) {
            return;
        }
        addLog(String.format(Locale.CHINA, "E,%s,%s\n", ts(), str));
    }

    public static void failedMessageLog(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65551, null, str) == null) && enable) {
            logger.failedMessage(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getFileName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65552, this)) == null) {
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
        return (String) invokeV.objValue;
    }

    public static void initLog(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, null, context) == null) {
            logger.init(context);
        }
    }

    private void saveMessage(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65554, this, str) == null) || this.initResult == -1) {
            return;
        }
        addLog(String.format(Locale.CHINA, "S,%s,%s\n", ts(), str));
    }

    public static void saveMessageLog(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65555, null, str) == null) && enable) {
            logger.saveMessage(str);
        }
    }

    public static void setEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65556, null, z) == null) {
            enable = z;
        }
    }

    private void startLogClean() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65557, this) == null) {
            ThreadPool.getPool().execute(new Runnable(this) { // from class: com.yy.hiidostatis.message.log.TraceLog.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ TraceLog this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    File[] listFiles;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        ArrayList arrayList = new ArrayList();
                        if (this.this$0.innerPath != null && (listFiles = new File(this.this$0.innerPath).listFiles(new FilenameFilter(this) { // from class: com.yy.hiidostatis.message.log.TraceLog.2.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ AnonymousClass2 this$1;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.this$1 = this;
                            }

                            @Override // java.io.FilenameFilter
                            public boolean accept(File file, String str) {
                                InterceptResult invokeLL;
                                Interceptable interceptable3 = $ic;
                                return (interceptable3 == null || (invokeLL = interceptable3.invokeLL(1048576, this, file, str)) == null) ? str.startsWith(TraceLog.LOG_FILE_PREFIX) : invokeLL.booleanValue;
                            }
                        })) != null && listFiles.length > 0) {
                            arrayList.addAll(Arrays.asList(listFiles));
                        }
                        Collections.sort(arrayList, new Comparator<File>(this) { // from class: com.yy.hiidostatis.message.log.TraceLog.2.2
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ AnonymousClass2 this$1;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.this$1 = this;
                            }

                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // java.util.Comparator
                            public int compare(File file, File file2) {
                                InterceptResult invokeLL;
                                Interceptable interceptable3 = $ic;
                                return (interceptable3 == null || (invokeLL = interceptable3.invokeLL(1048576, this, file, file2)) == null) ? file.getName().compareTo(file2.getName()) : invokeLL.intValue;
                            }
                        });
                        if (arrayList.size() > 2) {
                            long j2 = 0;
                            for (int size = arrayList.size() - 2; size > 0; size--) {
                                File file = (File) arrayList.get(size);
                                j2 += file.length();
                                if (j2 > 104857600 && file.delete()) {
                                    j2 -= file.length();
                                }
                            }
                        }
                    }
                }
            });
        }
    }

    private void successMessage(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65558, this, str) == null) || this.initResult == -1) {
            return;
        }
        addLog(String.format(Locale.CHINA, "F,%s,%s\n", ts(), str));
    }

    public static void successMessageLog(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65559, null, str) == null) && enable) {
            logger.successMessage(str);
        }
    }

    private String ts() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65560, this)) == null) ? Util.formatDate("yyyyMMddHHmmssSSS", System.currentTimeMillis()) : (String) invokeV.objValue;
    }

    private void write() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65561, this) == null) && this.initResult == 1 && !this.writing) {
            this.writing = true;
            ThreadPool.getPool().execute(this.writeRunnable);
        }
    }

    public synchronized void init(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            synchronized (this) {
                if (this.initResult == 0) {
                    this.appContext = context instanceof Application ? context : context.getApplicationContext();
                    this.innerPath = String.format(Locale.CHINA, "%s%s%s", context.getCacheDir().getAbsolutePath(), File.separator, LOG_FILE_SUB_PATH);
                    this.initResult = 1;
                    startLogClean();
                }
            }
        }
    }
}

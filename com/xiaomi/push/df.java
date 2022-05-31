package com.xiaomi.push;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.channel.commonutils.logger.LoggerInterface;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes8.dex */
public class df implements LoggerInterface {
    public static /* synthetic */ Interceptable $ic;
    public static String a;

    /* renamed from: a  reason: collision with other field name */
    public static final SimpleDateFormat f212a;

    /* renamed from: a  reason: collision with other field name */
    public static List<Pair<String, Throwable>> f213a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public Context f214a;

    /* renamed from: a  reason: collision with other field name */
    public Handler f215a;
    public String b;
    public String c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-56376834, "Lcom/xiaomi/push/df;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-56376834, "Lcom/xiaomi/push/df;");
                return;
            }
        }
        f212a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss aaa");
        a = "/MiPushLog";
        f213a = Collections.synchronizedList(new ArrayList());
    }

    public df(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = "";
        this.f214a = context;
        if (context.getApplicationContext() != null) {
            this.f214a = context.getApplicationContext();
        }
        this.b = this.f214a.getPackageName();
        HandlerThread handlerThread = new HandlerThread("Log2FileHandlerThread");
        handlerThread.start();
        this.f215a = new Handler(handlerThread.getLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:87:0x017e -> B:128:0x0183). Please submit an issue!!! */
    /* renamed from: a  reason: collision with other method in class */
    public void m282a() {
        FileLock fileLock;
        RandomAccessFile randomAccessFile;
        File file;
        File externalFilesDir;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            BufferedWriter bufferedWriter = null;
            try {
                try {
                    try {
                        if (TextUtils.isEmpty(this.c) && (externalFilesDir = this.f214a.getExternalFilesDir(null)) != null) {
                            this.c = externalFilesDir.getAbsolutePath() + "";
                        }
                        file = new File(this.c + a);
                    } catch (Throwable th) {
                        th = th;
                    }
                } catch (Exception e) {
                    e = e;
                    fileLock = null;
                    randomAccessFile = null;
                } catch (Throwable th2) {
                    th = th2;
                    fileLock = null;
                    randomAccessFile = null;
                }
            } catch (IOException e2) {
                Log.e(this.b, "", e2);
            }
            if ((!file.exists() || !file.isDirectory()) && !file.mkdirs()) {
                Log.w(this.b, "Create mipushlog directory fail.");
                return;
            }
            File file2 = new File(file, "log.lock");
            if (!file2.exists() || file2.isDirectory()) {
                file2.createNewFile();
            }
            randomAccessFile = new RandomAccessFile(file2, "rw");
            try {
                fileLock = randomAccessFile.getChannel().lock();
                try {
                    BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(file, "log1.txt"), true)));
                    while (!f213a.isEmpty()) {
                        try {
                            Pair<String, Throwable> remove = f213a.remove(0);
                            String str = (String) remove.first;
                            if (remove.second != null) {
                                str = (str + "\n") + Log.getStackTraceString((Throwable) remove.second);
                            }
                            bufferedWriter2.write(str + "\n");
                        } catch (Exception e3) {
                            e = e3;
                            bufferedWriter = bufferedWriter2;
                            Log.e(this.b, "", e);
                            if (bufferedWriter != null) {
                                try {
                                    bufferedWriter.close();
                                } catch (IOException e4) {
                                    Log.e(this.b, "", e4);
                                }
                            }
                            if (fileLock != null && fileLock.isValid()) {
                                try {
                                    fileLock.release();
                                } catch (IOException e5) {
                                    Log.e(this.b, "", e5);
                                }
                            }
                            if (randomAccessFile != null) {
                                randomAccessFile.close();
                            }
                            return;
                        } catch (Throwable th3) {
                            th = th3;
                            bufferedWriter = bufferedWriter2;
                            if (bufferedWriter != null) {
                                try {
                                    bufferedWriter.close();
                                } catch (IOException e6) {
                                    Log.e(this.b, "", e6);
                                }
                            }
                            if (fileLock != null && fileLock.isValid()) {
                                try {
                                    fileLock.release();
                                } catch (IOException e7) {
                                    Log.e(this.b, "", e7);
                                }
                            }
                            if (randomAccessFile != null) {
                                try {
                                    randomAccessFile.close();
                                } catch (IOException e8) {
                                    Log.e(this.b, "", e8);
                                }
                            }
                            throw th;
                        }
                    }
                    bufferedWriter2.flush();
                    bufferedWriter2.close();
                    File file3 = new File(file, "log1.txt");
                    if (file3.length() >= 1048576) {
                        File file4 = new File(file, "log0.txt");
                        if (file4.exists() && file4.isFile()) {
                            file4.delete();
                        }
                        file3.renameTo(file4);
                    }
                    if (0 != 0) {
                        try {
                            bufferedWriter.close();
                        } catch (IOException e9) {
                            Log.e(this.b, "", e9);
                        }
                    }
                    if (fileLock != null && fileLock.isValid()) {
                        try {
                            fileLock.release();
                        } catch (IOException e10) {
                            Log.e(this.b, "", e10);
                        }
                    }
                    randomAccessFile.close();
                } catch (Exception e11) {
                    e = e11;
                }
            } catch (Exception e12) {
                e = e12;
                fileLock = null;
            } catch (Throwable th4) {
                th = th4;
                fileLock = null;
            }
        }
    }

    @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
    public final void log(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            log(str, null);
        }
    }

    @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
    public final void log(String str, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, th) == null) {
            this.f215a.post(new dg(this, str, th));
        }
    }

    @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
    public final void setTag(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.b = str;
        }
    }
}

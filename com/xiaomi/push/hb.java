package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class hb {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Context a;

        /* renamed from: a  reason: collision with other field name */
        public he f473a;

        public a(Context context, he heVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, heVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f473a = heVar;
            this.a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                hb.c(this.a, this.f473a);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-56373114, "Lcom/xiaomi/push/hb;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-56373114, "Lcom/xiaomi/push/hb;");
        }
    }

    public static void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, context) == null) {
            File file = new File(context.getFilesDir() + "/tdReadTemp");
            if (file.exists()) {
                return;
            }
            file.mkdirs();
        }
    }

    public static void a(Context context, he heVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, context, heVar) == null) {
            ai.a(context).a(new a(context, heVar));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x00a1, code lost:
        r15 = "TinyData read from cache file failed cause lengthBuffer < 1 || too big. length:" + r7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(Context context, he heVar, File file, byte[] bArr) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLLLL(65539, null, context, heVar, file, bArr) != null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        byte[] bArr2 = new byte[4];
        BufferedInputStream bufferedInputStream = null;
        try {
            try {
                BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file));
                loop0: while (true) {
                    int i2 = 0;
                    int i3 = 0;
                    while (true) {
                        try {
                            int read = bufferedInputStream2.read(bArr2);
                            if (read == -1) {
                                break loop0;
                            } else if (read == 4) {
                                int a2 = ac.a(bArr2);
                                if (a2 < 1 || a2 > 10240) {
                                    break loop0;
                                }
                                byte[] bArr3 = new byte[a2];
                                int read2 = bufferedInputStream2.read(bArr3);
                                if (read2 != a2) {
                                    str = "TinyData read from cache file failed cause buffer size not equal length. size:" + read2 + "__length:" + a2;
                                    break loop0;
                                }
                                byte[] a3 = h.a(bArr, bArr3);
                                if (a3 != null && a3.length != 0) {
                                    hj hjVar = new hj();
                                    ip.a(hjVar, a3);
                                    hjVar.a("item_size", String.valueOf(a3.length));
                                    arrayList.add(hjVar);
                                    i2++;
                                    i3 += a3.length;
                                    if (i2 >= 8 || i3 >= 10240) {
                                    }
                                }
                                com.xiaomi.channel.commonutils.logger.b.d("TinyData read from cache file failed cause decrypt fail");
                            } else {
                                str = "TinyData read from cache file failed cause lengthBuffer error. size:" + read;
                                break loop0;
                            }
                        } catch (Exception e2) {
                            e = e2;
                            bufferedInputStream = bufferedInputStream2;
                            com.xiaomi.channel.commonutils.logger.b.a(e);
                            y.a(bufferedInputStream);
                            return;
                        } catch (Throwable th) {
                            th = th;
                            bufferedInputStream = bufferedInputStream2;
                            y.a(bufferedInputStream);
                            throw th;
                        }
                    }
                    hc.a(context, heVar, arrayList);
                    arrayList.clear();
                }
                com.xiaomi.channel.commonutils.logger.b.d(str);
                hc.a(context, heVar, arrayList);
                if (file != null && file.exists() && !file.delete()) {
                    com.xiaomi.channel.commonutils.logger.b.m122a("TinyData delete reading temp file failed");
                }
                y.a(bufferedInputStream2);
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e3) {
            e = e3;
        }
    }

    public static void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context) == null) {
            SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 4).edit();
            edit.putLong("last_tiny_data_upload_timestamp", System.currentTimeMillis() / 1000);
            edit.commit();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00bf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void c(Context context, he heVar) {
        RandomAccessFile randomAccessFile;
        File file;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, context, heVar) == null) {
            if (a) {
                com.xiaomi.channel.commonutils.logger.b.m122a("TinyData extractTinyData is running");
                return;
            }
            a = true;
            File file2 = new File(context.getFilesDir(), "tiny_data.data");
            if (!file2.exists()) {
                com.xiaomi.channel.commonutils.logger.b.m122a("TinyData no ready file to get data.");
                return;
            }
            a(context);
            byte[] a2 = com.xiaomi.push.service.bn.a(context);
            FileLock fileLock = null;
            try {
                File file3 = new File(context.getFilesDir(), "tiny_data.lock");
                y.m695a(file3);
                randomAccessFile = new RandomAccessFile(file3, "rw");
                try {
                    try {
                        fileLock = randomAccessFile.getChannel().lock();
                        file2.renameTo(new File(context.getFilesDir() + "/tdReadTemp/tiny_data.data"));
                        if (fileLock != null && fileLock.isValid()) {
                            try {
                                fileLock.release();
                            } catch (IOException e2) {
                                e = e2;
                                com.xiaomi.channel.commonutils.logger.b.a(e);
                                y.a(randomAccessFile);
                                file = new File(context.getFilesDir() + "/tdReadTemp/tiny_data.data");
                                if (file.exists()) {
                                }
                            }
                        }
                    } catch (Exception e3) {
                        e = e3;
                        com.xiaomi.channel.commonutils.logger.b.a(e);
                        if (fileLock != null && fileLock.isValid()) {
                            try {
                                fileLock.release();
                            } catch (IOException e4) {
                                e = e4;
                                com.xiaomi.channel.commonutils.logger.b.a(e);
                                y.a(randomAccessFile);
                                file = new File(context.getFilesDir() + "/tdReadTemp/tiny_data.data");
                                if (file.exists()) {
                                }
                            }
                        }
                        y.a(randomAccessFile);
                        file = new File(context.getFilesDir() + "/tdReadTemp/tiny_data.data");
                        if (file.exists()) {
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    if (fileLock != null && fileLock.isValid()) {
                        try {
                            fileLock.release();
                        } catch (IOException e5) {
                            com.xiaomi.channel.commonutils.logger.b.a(e5);
                        }
                    }
                    y.a(randomAccessFile);
                    throw th;
                }
            } catch (Exception e6) {
                e = e6;
                randomAccessFile = null;
            } catch (Throwable th2) {
                th = th2;
                randomAccessFile = null;
                if (fileLock != null) {
                    fileLock.release();
                }
                y.a(randomAccessFile);
                throw th;
            }
            y.a(randomAccessFile);
            file = new File(context.getFilesDir() + "/tdReadTemp/tiny_data.data");
            if (file.exists()) {
                com.xiaomi.channel.commonutils.logger.b.m122a("TinyData no ready file to get data.");
                return;
            }
            a(context, heVar, file, a2);
            ha.a(false);
            b(context);
            a = false;
        }
    }
}

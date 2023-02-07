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
/* loaded from: classes8.dex */
public class he {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Context a;

        /* renamed from: a  reason: collision with other field name */
        public hh f488a;

        public a(Context context, hh hhVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, hhVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f488a = hhVar;
            this.a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                he.c(this.a, this.f488a);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-56373021, "Lcom/xiaomi/push/he;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-56373021, "Lcom/xiaomi/push/he;");
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

    public static void a(Context context, hh hhVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, context, hhVar) == null) {
            al.a(context).a(new a(context, hhVar));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x00a1, code lost:
        r15 = "TinyData read from cache file failed cause lengthBuffer < 1 || too big. length:" + r7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(Context context, hh hhVar, File file, byte[] bArr) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLLLL(65539, null, context, hhVar, file, bArr) != null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        byte[] bArr2 = new byte[4];
        BufferedInputStream bufferedInputStream = null;
        try {
            try {
                BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file));
                loop0: while (true) {
                    int i = 0;
                    int i2 = 0;
                    while (true) {
                        try {
                            int read = bufferedInputStream2.read(bArr2);
                            if (read == -1) {
                                break loop0;
                            } else if (read == 4) {
                                int a2 = af.a(bArr2);
                                if (a2 < 1 || a2 > 10240) {
                                    break loop0;
                                }
                                byte[] bArr3 = new byte[a2];
                                int read2 = bufferedInputStream2.read(bArr3);
                                if (read2 != a2) {
                                    str = "TinyData read from cache file failed cause buffer size not equal length. size:" + read2 + "__length:" + a2;
                                    break loop0;
                                }
                                byte[] a3 = i.a(bArr, bArr3);
                                if (a3 != null && a3.length != 0) {
                                    hn hnVar = new hn();
                                    it.a(hnVar, a3);
                                    hnVar.a("item_size", String.valueOf(a3.length));
                                    arrayList.add(hnVar);
                                    i++;
                                    i2 += a3.length;
                                    if (i >= 8 || i2 >= 10240) {
                                    }
                                }
                                com.xiaomi.channel.commonutils.logger.b.d("TinyData read from cache file failed cause decrypt fail");
                            } else {
                                str = "TinyData read from cache file failed cause lengthBuffer error. size:" + read;
                                break loop0;
                            }
                        } catch (Exception e) {
                            e = e;
                            bufferedInputStream = bufferedInputStream2;
                            com.xiaomi.channel.commonutils.logger.b.a(e);
                            ab.a(bufferedInputStream);
                            return;
                        } catch (Throwable th) {
                            th = th;
                            bufferedInputStream = bufferedInputStream2;
                            ab.a(bufferedInputStream);
                            throw th;
                        }
                    }
                    hf.a(context, hhVar, arrayList);
                    arrayList.clear();
                }
                com.xiaomi.channel.commonutils.logger.b.d(str);
                hf.a(context, hhVar, arrayList);
                if (file != null && file.exists() && !file.delete()) {
                    com.xiaomi.channel.commonutils.logger.b.m105a("TinyData delete reading temp file failed");
                }
                ab.a(bufferedInputStream2);
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e2) {
            e = e2;
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
    public static void c(Context context, hh hhVar) {
        RandomAccessFile randomAccessFile;
        File file;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, context, hhVar) == null) {
            if (a) {
                com.xiaomi.channel.commonutils.logger.b.m105a("TinyData extractTinyData is running");
                return;
            }
            a = true;
            File file2 = new File(context.getFilesDir(), "tiny_data.data");
            if (!file2.exists()) {
                com.xiaomi.channel.commonutils.logger.b.m105a("TinyData no ready file to get data.");
                return;
            }
            a(context);
            byte[] a2 = com.xiaomi.push.service.ca.a(context);
            FileLock fileLock = null;
            try {
                File file3 = new File(context.getFilesDir(), "tiny_data.lock");
                ab.m177a(file3);
                randomAccessFile = new RandomAccessFile(file3, "rw");
                try {
                    try {
                        fileLock = randomAccessFile.getChannel().lock();
                        file2.renameTo(new File(context.getFilesDir() + "/tdReadTemp/tiny_data.data"));
                        if (fileLock != null && fileLock.isValid()) {
                            try {
                                fileLock.release();
                            } catch (IOException e) {
                                e = e;
                                com.xiaomi.channel.commonutils.logger.b.a(e);
                                ab.a(randomAccessFile);
                                file = new File(context.getFilesDir() + "/tdReadTemp/tiny_data.data");
                                if (file.exists()) {
                                }
                            }
                        }
                    } catch (Exception e2) {
                        e = e2;
                        com.xiaomi.channel.commonutils.logger.b.a(e);
                        if (fileLock != null && fileLock.isValid()) {
                            try {
                                fileLock.release();
                            } catch (IOException e3) {
                                e = e3;
                                com.xiaomi.channel.commonutils.logger.b.a(e);
                                ab.a(randomAccessFile);
                                file = new File(context.getFilesDir() + "/tdReadTemp/tiny_data.data");
                                if (file.exists()) {
                                }
                            }
                        }
                        ab.a(randomAccessFile);
                        file = new File(context.getFilesDir() + "/tdReadTemp/tiny_data.data");
                        if (file.exists()) {
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    if (fileLock != null && fileLock.isValid()) {
                        try {
                            fileLock.release();
                        } catch (IOException e4) {
                            com.xiaomi.channel.commonutils.logger.b.a(e4);
                        }
                    }
                    ab.a(randomAccessFile);
                    throw th;
                }
            } catch (Exception e5) {
                e = e5;
                randomAccessFile = null;
            } catch (Throwable th2) {
                th = th2;
                randomAccessFile = null;
                if (fileLock != null) {
                    fileLock.release();
                }
                ab.a(randomAccessFile);
                throw th;
            }
            ab.a(randomAccessFile);
            file = new File(context.getFilesDir() + "/tdReadTemp/tiny_data.data");
            if (file.exists()) {
                com.xiaomi.channel.commonutils.logger.b.m105a("TinyData no ready file to get data.");
                return;
            }
            a(context, hhVar, file, a2);
            hd.a(false);
            b(context);
            a = false;
        }
    }
}

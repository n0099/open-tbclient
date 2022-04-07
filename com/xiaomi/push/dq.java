package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.push.ai;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
/* loaded from: classes8.dex */
public abstract class dq extends ai.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: a  reason: collision with other field name */
    public Context f222a;

    public dq(Context context, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = i;
        this.f222a = context;
    }

    public static void a(Context context, hn hnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, context, hnVar) == null) {
            di m284a = dj.a().m284a();
            String a = m284a == null ? "" : m284a.a();
            if (TextUtils.isEmpty(a) || TextUtils.isEmpty(hnVar.a())) {
                return;
            }
            a(context, hnVar, a);
        }
    }

    public static void a(Context context, hn hnVar, String str) {
        byte[] b;
        BufferedOutputStream bufferedOutputStream;
        RandomAccessFile randomAccessFile;
        FileLock lock;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65538, null, context, hnVar, str) == null) || (b = dl.b(str, ip.a(hnVar))) == null || b.length == 0) {
            return;
        }
        synchronized (dm.a) {
            FileLock fileLock = null;
            try {
                try {
                    File file = new File(context.getExternalFilesDir(null), "push_cdata.lock");
                    y.m681a(file);
                    randomAccessFile = new RandomAccessFile(file, "rw");
                    try {
                        lock = randomAccessFile.getChannel().lock();
                        try {
                            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File(context.getExternalFilesDir(null), "push_cdata.data"), true));
                        } catch (IOException e) {
                            e = e;
                            bufferedOutputStream = null;
                        } catch (Throwable th) {
                            th = th;
                            bufferedOutputStream = null;
                        }
                    } catch (IOException e2) {
                        e = e2;
                        bufferedOutputStream = null;
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedOutputStream = null;
                    }
                    try {
                        bufferedOutputStream.write(ac.a(b.length));
                        bufferedOutputStream.write(b);
                        bufferedOutputStream.flush();
                        if (lock != null && lock.isValid()) {
                            try {
                                lock.release();
                            } catch (IOException unused) {
                            }
                        }
                        y.a(bufferedOutputStream);
                    } catch (IOException e3) {
                        e = e3;
                        fileLock = lock;
                        try {
                            e.printStackTrace();
                            if (fileLock != null && fileLock.isValid()) {
                                try {
                                    fileLock.release();
                                } catch (IOException unused2) {
                                }
                            }
                            y.a(bufferedOutputStream);
                            y.a(randomAccessFile);
                        } catch (Throwable th3) {
                            th = th3;
                            if (fileLock != null && fileLock.isValid()) {
                                try {
                                    fileLock.release();
                                } catch (IOException unused3) {
                                }
                            }
                            y.a(bufferedOutputStream);
                            y.a(randomAccessFile);
                            throw th;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        fileLock = lock;
                        if (fileLock != null) {
                            fileLock.release();
                        }
                        y.a(bufferedOutputStream);
                        y.a(randomAccessFile);
                        throw th;
                    }
                } catch (Throwable th5) {
                    throw th5;
                }
            } catch (IOException e4) {
                e = e4;
                bufferedOutputStream = null;
                randomAccessFile = null;
            } catch (Throwable th6) {
                th = th6;
                bufferedOutputStream = null;
                randomAccessFile = null;
            }
            y.a(randomAccessFile);
        }
    }

    private String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            return "dc_job_result_time_" + mo222a();
        }
        return (String) invokeV.objValue;
    }

    private String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            return "dc_job_result_" + mo222a();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.xiaomi.push.ai.a
    /* renamed from: a */
    public abstract hh mo222a();

    @Override // com.xiaomi.push.ai.a
    /* renamed from: a */
    public boolean mo222a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? dl.a(this.f222a, String.valueOf(mo222a()), this.a) : invokeV.booleanValue;
    }

    public abstract String b();

    /* renamed from: b  reason: collision with other method in class */
    public boolean m286b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m287c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            String b = b();
            if (TextUtils.isEmpty(b)) {
                return;
            }
            if (mo222a()) {
                com.xiaomi.channel.commonutils.logger.b.m108a("DC run job mutual: " + mo222a());
                return;
            }
            di m284a = dj.a().m284a();
            String a = m284a == null ? "" : m284a.a();
            if (!TextUtils.isEmpty(a) && m286b()) {
                if (m287c()) {
                    SharedPreferences sharedPreferences = this.f222a.getSharedPreferences("mipush_extra", 0);
                    if (bm.a(b).equals(sharedPreferences.getString(d(), null))) {
                        long j = sharedPreferences.getLong(c(), 0L);
                        int a2 = com.xiaomi.push.service.aq.a(this.f222a).a(hk.ba.a(), 604800);
                        if ((System.currentTimeMillis() - j) / 1000 < this.a) {
                            return;
                        }
                        if ((System.currentTimeMillis() - j) / 1000 < a2) {
                            b = "same_" + j;
                        }
                    }
                }
                hn hnVar = new hn();
                hnVar.a(b);
                hnVar.a(System.currentTimeMillis());
                hnVar.a(mo222a());
                a(this.f222a, hnVar, a);
            }
        }
    }
}

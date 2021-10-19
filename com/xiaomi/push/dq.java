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
/* loaded from: classes10.dex */
public abstract class dq extends ai.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f77844a;

    /* renamed from: a  reason: collision with other field name */
    public Context f245a;

    public dq(Context context, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f77844a = i2;
        this.f245a = context;
    }

    public static void a(Context context, hn hnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, context, hnVar) == null) {
            di m249a = dj.a().m249a();
            String a2 = m249a == null ? "" : m249a.a();
            if (TextUtils.isEmpty(a2) || TextUtils.isEmpty(hnVar.a())) {
                return;
            }
            a(context, hnVar, a2);
        }
    }

    public static void a(Context context, hn hnVar, String str) {
        byte[] b2;
        BufferedOutputStream bufferedOutputStream;
        RandomAccessFile randomAccessFile;
        FileLock lock;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65538, null, context, hnVar, str) == null) || (b2 = dl.b(str, ip.a(hnVar))) == null || b2.length == 0) {
            return;
        }
        synchronized (dm.f77839a) {
            FileLock fileLock = null;
            try {
                try {
                    File file = new File(context.getExternalFilesDir(null), "push_cdata.lock");
                    y.m646a(file);
                    randomAccessFile = new RandomAccessFile(file, "rw");
                    try {
                        lock = randomAccessFile.getChannel().lock();
                        try {
                            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File(context.getExternalFilesDir(null), "push_cdata.data"), true));
                        } catch (IOException e2) {
                            e = e2;
                            bufferedOutputStream = null;
                        } catch (Throwable th) {
                            th = th;
                            bufferedOutputStream = null;
                        }
                    } catch (IOException e3) {
                        e = e3;
                        bufferedOutputStream = null;
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedOutputStream = null;
                    }
                    try {
                        bufferedOutputStream.write(ac.a(b2.length));
                        bufferedOutputStream.write(b2);
                        bufferedOutputStream.flush();
                        if (lock != null && lock.isValid()) {
                            try {
                                lock.release();
                            } catch (IOException unused) {
                            }
                        }
                        y.a(bufferedOutputStream);
                    } catch (IOException e4) {
                        e = e4;
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
            } catch (IOException e5) {
                e = e5;
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
            return "dc_job_result_time_" + mo187a();
        }
        return (String) invokeV.objValue;
    }

    private String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            return "dc_job_result_" + mo187a();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.xiaomi.push.ai.a
    /* renamed from: a */
    public abstract hh mo187a();

    @Override // com.xiaomi.push.ai.a
    /* renamed from: a */
    public boolean mo187a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? dl.a(this.f245a, String.valueOf(mo187a()), this.f77844a) : invokeV.booleanValue;
    }

    public abstract String b();

    /* renamed from: b  reason: collision with other method in class */
    public boolean m251b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m252c() {
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
            String b2 = b();
            if (TextUtils.isEmpty(b2)) {
                return;
            }
            if (mo187a()) {
                com.xiaomi.channel.commonutils.logger.b.m73a("DC run job mutual: " + mo187a());
                return;
            }
            di m249a = dj.a().m249a();
            String a2 = m249a == null ? "" : m249a.a();
            if (!TextUtils.isEmpty(a2) && m251b()) {
                if (m252c()) {
                    SharedPreferences sharedPreferences = this.f245a.getSharedPreferences("mipush_extra", 0);
                    if (bm.a(b2).equals(sharedPreferences.getString(d(), null))) {
                        long j2 = sharedPreferences.getLong(c(), 0L);
                        int a3 = com.xiaomi.push.service.aq.a(this.f245a).a(hk.ba.a(), 604800);
                        if ((System.currentTimeMillis() - j2) / 1000 < this.f77844a) {
                            return;
                        }
                        if ((System.currentTimeMillis() - j2) / 1000 < a3) {
                            b2 = "same_" + j2;
                        }
                    }
                }
                hn hnVar = new hn();
                hnVar.a(b2);
                hnVar.a(System.currentTimeMillis());
                hnVar.a(mo187a());
                a(this.f245a, hnVar, a2);
            }
        }
    }
}

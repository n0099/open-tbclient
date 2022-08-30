package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.rw;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.push.al;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
/* loaded from: classes8.dex */
public abstract class dt extends al.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: a  reason: collision with other field name */
    public Context f233a;

    public dt(Context context, int i) {
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
        this.f233a = context;
    }

    public static void a(Context context, hr hrVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, context, hrVar) == null) {
            dm m269a = dn.a().m269a();
            String a = m269a == null ? "" : m269a.a();
            if (TextUtils.isEmpty(a) || TextUtils.isEmpty(hrVar.a())) {
                return;
            }
            a(context, hrVar, a);
        }
    }

    public static void a(Context context, hr hrVar, String str) {
        byte[] b;
        BufferedOutputStream bufferedOutputStream;
        RandomAccessFile randomAccessFile;
        File file;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65538, null, context, hrVar, str) == null) || (b = dp.b(str, it.a(hrVar))) == null || b.length == 0) {
            return;
        }
        synchronized (dq.a) {
            FileLock fileLock = null;
            try {
                try {
                    File file2 = new File(context.getExternalFilesDir(null), "push_cdata.lock");
                    ab.m161a(file2);
                    randomAccessFile = new RandomAccessFile(file2, rw.c);
                    try {
                        FileLock lock = randomAccessFile.getChannel().lock();
                        try {
                            file = new File(context.getExternalFilesDir(null), "push_cdata.data");
                            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file, true));
                        } catch (IOException e) {
                            e = e;
                            bufferedOutputStream = null;
                        } catch (Throwable th) {
                            th = th;
                            bufferedOutputStream = null;
                        }
                        try {
                            bufferedOutputStream.write(af.a(b.length));
                            bufferedOutputStream.write(b);
                            bufferedOutputStream.flush();
                            file.setLastModified(0L);
                            if (lock != null && lock.isValid()) {
                                try {
                                    lock.release();
                                } catch (IOException unused) {
                                }
                            }
                            ab.a(bufferedOutputStream);
                        } catch (IOException e2) {
                            e = e2;
                            fileLock = lock;
                            try {
                                e.printStackTrace();
                                if (fileLock != null && fileLock.isValid()) {
                                    try {
                                        fileLock.release();
                                    } catch (IOException unused2) {
                                    }
                                }
                                ab.a(bufferedOutputStream);
                                ab.a(randomAccessFile);
                            } catch (Throwable th2) {
                                th = th2;
                                if (fileLock != null && fileLock.isValid()) {
                                    try {
                                        fileLock.release();
                                    } catch (IOException unused3) {
                                    }
                                }
                                ab.a(bufferedOutputStream);
                                ab.a(randomAccessFile);
                                throw th;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            fileLock = lock;
                            if (fileLock != null) {
                                fileLock.release();
                            }
                            ab.a(bufferedOutputStream);
                            ab.a(randomAccessFile);
                            throw th;
                        }
                    } catch (IOException e3) {
                        e = e3;
                        bufferedOutputStream = null;
                    } catch (Throwable th4) {
                        th = th4;
                        bufferedOutputStream = null;
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
            ab.a(randomAccessFile);
        }
    }

    private String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            return "dc_job_result_time_" + mo207a();
        }
        return (String) invokeV.objValue;
    }

    private String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            return "dc_job_result_" + mo207a();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.xiaomi.push.al.a
    /* renamed from: a */
    public abstract hl mo207a();

    @Override // com.xiaomi.push.al.a
    /* renamed from: a */
    public boolean mo207a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? dp.a(this.f233a, String.valueOf(mo207a()), this.a) : invokeV.booleanValue;
    }

    public abstract String b();

    /* renamed from: b  reason: collision with other method in class */
    public boolean m271b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m272c() {
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
            if (mo207a()) {
                com.xiaomi.channel.commonutils.logger.b.m89a("DC run job mutual: " + mo207a());
                return;
            }
            dm m269a = dn.a().m269a();
            String a = m269a == null ? "" : m269a.a();
            if (!TextUtils.isEmpty(a) && m271b()) {
                if (m272c()) {
                    SharedPreferences sharedPreferences = this.f233a.getSharedPreferences("mipush_extra", 0);
                    if (bp.a(b).equals(sharedPreferences.getString(d(), null))) {
                        long j = sharedPreferences.getLong(c(), 0L);
                        int a2 = com.xiaomi.push.service.ba.a(this.f233a).a(ho.ba.a(), 604800);
                        if ((System.currentTimeMillis() - j) / 1000 < this.a) {
                            return;
                        }
                        if ((System.currentTimeMillis() - j) / 1000 < a2) {
                            b = "same_" + j;
                        }
                    }
                }
                hr hrVar = new hr();
                hrVar.a(b);
                hrVar.a(System.currentTimeMillis());
                hrVar.a(mo207a());
                a(this.f233a, hrVar, a);
            }
        }
    }
}

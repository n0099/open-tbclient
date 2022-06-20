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
import com.xiaomi.push.al;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class dv extends al.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: a  reason: collision with other field name */
    public SharedPreferences f226a;

    /* renamed from: a  reason: collision with other field name */
    public com.xiaomi.push.service.ba f227a;

    public dv(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = context;
        this.f226a = context.getSharedPreferences("mipush_extra", 0);
        this.f227a = com.xiaomi.push.service.ba.a(context);
    }

    private List<hr> a(File file) {
        InterceptResult invokeL;
        RandomAccessFile randomAccessFile;
        FileInputStream fileInputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, file)) == null) {
            dm m264a = dn.a().m264a();
            String a = m264a == null ? "" : m264a.a();
            FileLock fileLock = null;
            if (TextUtils.isEmpty(a)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            byte[] bArr = new byte[4];
            synchronized (dq.a) {
                try {
                    File file2 = new File(this.a.getExternalFilesDir(null), "push_cdata.lock");
                    ab.m156a(file2);
                    randomAccessFile = new RandomAccessFile(file2, "rw");
                    try {
                        FileLock lock = randomAccessFile.getChannel().lock();
                        try {
                            fileInputStream = new FileInputStream(file);
                            while (fileInputStream.read(bArr) == 4) {
                                try {
                                    int a2 = af.a(bArr);
                                    byte[] bArr2 = new byte[a2];
                                    if (fileInputStream.read(bArr2) != a2) {
                                        break;
                                    }
                                    byte[] a3 = dp.a(a, bArr2);
                                    if (a3 != null && a3.length != 0) {
                                        hr hrVar = new hr();
                                        it.a(hrVar, a3);
                                        arrayList.add(hrVar);
                                        a(hrVar);
                                    }
                                } catch (Exception unused) {
                                    fileLock = lock;
                                    if (fileLock != null && fileLock.isValid()) {
                                        try {
                                            fileLock.release();
                                        } catch (IOException unused2) {
                                        }
                                    }
                                    ab.a(fileInputStream);
                                    ab.a(randomAccessFile);
                                    return arrayList;
                                } catch (Throwable th) {
                                    th = th;
                                    fileLock = lock;
                                    if (fileLock != null && fileLock.isValid()) {
                                        try {
                                            fileLock.release();
                                        } catch (IOException unused3) {
                                        }
                                    }
                                    ab.a(fileInputStream);
                                    ab.a(randomAccessFile);
                                    throw th;
                                }
                            }
                            if (lock != null && lock.isValid()) {
                                try {
                                    lock.release();
                                } catch (IOException unused4) {
                                }
                            }
                            ab.a(fileInputStream);
                        } catch (Exception unused5) {
                            fileInputStream = null;
                        } catch (Throwable th2) {
                            th = th2;
                            fileInputStream = null;
                        }
                    } catch (Exception unused6) {
                        fileInputStream = null;
                    } catch (Throwable th3) {
                        th = th3;
                        fileInputStream = null;
                    }
                } catch (Exception unused7) {
                    randomAccessFile = null;
                    fileInputStream = null;
                } catch (Throwable th4) {
                    th = th4;
                    randomAccessFile = null;
                    fileInputStream = null;
                }
                ab.a(randomAccessFile);
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            SharedPreferences.Editor edit = this.f226a.edit();
            edit.putLong("last_upload_data_timestamp", System.currentTimeMillis() / 1000);
            edit.commit();
        }
    }

    private void a(hr hrVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65539, this, hrVar) == null) && hrVar.f489a == hl.b && !hrVar.f490a.startsWith("same_")) {
            SharedPreferences.Editor edit = this.f226a.edit();
            edit.putLong("dc_job_result_time_4", hrVar.f488a);
            edit.putString("dc_job_result_4", bp.a(hrVar.f490a));
            edit.commit();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    private boolean m268a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            if (bj.e(this.a)) {
                return false;
            }
            if ((bj.g(this.a) || bj.f(this.a)) && !c()) {
                return true;
            }
            return (bj.h(this.a) && !b()) || bj.i(this.a);
        }
        return invokeV.booleanValue;
    }

    private boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) {
            if (this.f227a.a(ho.L.a(), true)) {
                return Math.abs((System.currentTimeMillis() / 1000) - this.f226a.getLong("last_upload_data_timestamp", -1L)) > ((long) Math.max(86400, this.f227a.a(ho.M.a(), 432000)));
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    private boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) {
            if (this.f227a.a(ho.J.a(), true)) {
                return Math.abs((System.currentTimeMillis() / 1000) - this.f226a.getLong("last_upload_data_timestamp", -1L)) > ((long) Math.max(86400, this.f227a.a(ho.K.a(), 259200)));
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.xiaomi.push.al.a
    /* renamed from: a */
    public String mo202a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "1" : (String) invokeV.objValue;
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            File file = new File(this.a.getExternalFilesDir(null), "push_cdata.data");
            if (!bj.d(this.a)) {
                if (file.length() > 1863680) {
                    file.delete();
                }
            } else if (!m268a() && file.exists()) {
                List<hr> a = a(file);
                if (!ag.a(a)) {
                    int size = a.size();
                    if (size > 4000) {
                        a = a.subList(size - 4000, size);
                    }
                    ic icVar = new ic();
                    icVar.a(a);
                    byte[] a2 = ab.a(it.a(icVar));
                    ii iiVar = new ii("-1", false);
                    iiVar.c(ht.q.f498a);
                    iiVar.a(a2);
                    dm m264a = dn.a().m264a();
                    if (m264a != null) {
                        m264a.a(iiVar, hj.i, null);
                    }
                    a();
                }
                file.delete();
            }
        }
    }
}

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
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class ds extends ai.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: a  reason: collision with other field name */
    public SharedPreferences f247a;

    /* renamed from: a  reason: collision with other field name */
    public com.xiaomi.push.service.aq f248a;

    public ds(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = context;
        this.f247a = context.getSharedPreferences("mipush_extra", 0);
        this.f248a = com.xiaomi.push.service.aq.a(context);
    }

    private List<hn> a(File file) {
        InterceptResult invokeL;
        RandomAccessFile randomAccessFile;
        FileInputStream fileInputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, file)) == null) {
            di m309a = dj.a().m309a();
            String a = m309a == null ? "" : m309a.a();
            FileLock fileLock = null;
            if (TextUtils.isEmpty(a)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            byte[] bArr = new byte[4];
            synchronized (dm.a) {
                try {
                    File file2 = new File(this.a.getExternalFilesDir(null), "push_cdata.lock");
                    y.m706a(file2);
                    randomAccessFile = new RandomAccessFile(file2, "rw");
                    try {
                        FileLock lock = randomAccessFile.getChannel().lock();
                        try {
                            fileInputStream = new FileInputStream(file);
                            while (fileInputStream.read(bArr) == 4) {
                                try {
                                    int a2 = ac.a(bArr);
                                    byte[] bArr2 = new byte[a2];
                                    if (fileInputStream.read(bArr2) != a2) {
                                        break;
                                    }
                                    byte[] a3 = dl.a(a, bArr2);
                                    if (a3 != null && a3.length != 0) {
                                        hn hnVar = new hn();
                                        ip.a(hnVar, a3);
                                        arrayList.add(hnVar);
                                        a(hnVar);
                                    }
                                } catch (Exception unused) {
                                    fileLock = lock;
                                    if (fileLock != null && fileLock.isValid()) {
                                        try {
                                            fileLock.release();
                                        } catch (IOException unused2) {
                                        }
                                    }
                                    y.a(fileInputStream);
                                    y.a(randomAccessFile);
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
                                    y.a(fileInputStream);
                                    y.a(randomAccessFile);
                                    throw th;
                                }
                            }
                            if (lock != null && lock.isValid()) {
                                try {
                                    lock.release();
                                } catch (IOException unused4) {
                                }
                            }
                            y.a(fileInputStream);
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
                y.a(randomAccessFile);
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            SharedPreferences.Editor edit = this.f247a.edit();
            edit.putLong("last_upload_data_timestamp", System.currentTimeMillis() / 1000);
            edit.commit();
        }
    }

    private void a(hn hnVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65539, this, hnVar) == null) && hnVar.f505a == hh.f59731b && !hnVar.f506a.startsWith("same_")) {
            SharedPreferences.Editor edit = this.f247a.edit();
            edit.putLong("dc_job_result_time_4", hnVar.f504a);
            edit.putString("dc_job_result_4", bm.a(hnVar.f506a));
            edit.commit();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    private boolean m313a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            if (bg.e(this.a)) {
                return false;
            }
            if ((bg.g(this.a) || bg.f(this.a)) && !c()) {
                return true;
            }
            return (bg.h(this.a) && !b()) || bg.i(this.a);
        }
        return invokeV.booleanValue;
    }

    private boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) {
            if (this.f248a.a(hk.L.a(), true)) {
                return Math.abs((System.currentTimeMillis() / 1000) - this.f247a.getLong("last_upload_data_timestamp", -1L)) > ((long) Math.max(86400, this.f248a.a(hk.M.a(), 432000)));
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    private boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) {
            if (this.f248a.a(hk.J.a(), true)) {
                return Math.abs((System.currentTimeMillis() / 1000) - this.f247a.getLong("last_upload_data_timestamp", -1L)) > ((long) Math.max(86400, this.f248a.a(hk.K.a(), 259200)));
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.xiaomi.push.ai.a
    /* renamed from: a */
    public String mo247a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "1" : (String) invokeV.objValue;
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            File file = new File(this.a.getExternalFilesDir(null), "push_cdata.data");
            if (!bg.d(this.a)) {
                if (file.length() > 1863680) {
                    file.delete();
                }
            } else if (!m313a() && file.exists()) {
                List<hn> a = a(file);
                if (!ad.a(a)) {
                    int size = a.size();
                    if (size > 4000) {
                        a = a.subList(size - 4000, size);
                    }
                    hy hyVar = new hy();
                    hyVar.a(a);
                    byte[] a2 = y.a(ip.a(hyVar));
                    ie ieVar = new ie("-1", false);
                    ieVar.c(hp.q.f514a);
                    ieVar.a(a2);
                    di m309a = dj.a().m309a();
                    if (m309a != null) {
                        m309a.a(ieVar, hf.f59728i, null);
                    }
                    a();
                }
                file.delete();
            }
        }
    }
}

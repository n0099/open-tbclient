package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
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
/* loaded from: classes6.dex */
public class ds extends ai.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f40258a;

    /* renamed from: a  reason: collision with other field name */
    public SharedPreferences f242a;

    /* renamed from: a  reason: collision with other field name */
    public com.xiaomi.push.service.aq f243a;

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
        this.f40258a = context;
        this.f242a = context.getSharedPreferences("mipush_extra", 0);
        this.f243a = com.xiaomi.push.service.aq.a(context);
    }

    private List<hn> a(File file) {
        InterceptResult invokeL;
        RandomAccessFile randomAccessFile;
        FileInputStream fileInputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, file)) == null) {
            di m246a = dj.a().m246a();
            String a2 = m246a == null ? "" : m246a.a();
            FileLock fileLock = null;
            if (TextUtils.isEmpty(a2)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            byte[] bArr = new byte[4];
            synchronized (dm.f40252a) {
                try {
                    File file2 = new File(this.f40258a.getExternalFilesDir(null), "push_cdata.lock");
                    y.m643a(file2);
                    randomAccessFile = new RandomAccessFile(file2, "rw");
                    try {
                        FileLock lock = randomAccessFile.getChannel().lock();
                        try {
                            fileInputStream = new FileInputStream(file);
                            while (fileInputStream.read(bArr) == 4) {
                                try {
                                    int a3 = ac.a(bArr);
                                    byte[] bArr2 = new byte[a3];
                                    if (fileInputStream.read(bArr2) != a3) {
                                        break;
                                    }
                                    byte[] a4 = dl.a(a2, bArr2);
                                    if (a4 != null && a4.length != 0) {
                                        hn hnVar = new hn();
                                        ip.a(hnVar, a4);
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
            SharedPreferences.Editor edit = this.f242a.edit();
            edit.putLong("last_upload_data_timestamp", System.currentTimeMillis() / 1000);
            edit.commit();
        }
    }

    private void a(hn hnVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65539, this, hnVar) == null) && hnVar.f500a == hh.f40534b && !hnVar.f501a.startsWith("same_")) {
            SharedPreferences.Editor edit = this.f242a.edit();
            edit.putLong("dc_job_result_time_4", hnVar.f499a);
            edit.putString("dc_job_result_4", bm.a(hnVar.f501a));
            edit.commit();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    private boolean m250a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            if (bg.e(this.f40258a)) {
                return false;
            }
            if ((bg.g(this.f40258a) || bg.f(this.f40258a)) && !c()) {
                return true;
            }
            return (bg.h(this.f40258a) && !b()) || bg.i(this.f40258a);
        }
        return invokeV.booleanValue;
    }

    private boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this)) == null) {
            if (this.f243a.a(hk.L.a(), true)) {
                return Math.abs((System.currentTimeMillis() / 1000) - this.f242a.getLong("last_upload_data_timestamp", -1L)) > ((long) Math.max(86400, this.f243a.a(hk.M.a(), 432000)));
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    private boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this)) == null) {
            if (this.f243a.a(hk.J.a(), true)) {
                return Math.abs((System.currentTimeMillis() / 1000) - this.f242a.getLong("last_upload_data_timestamp", -1L)) > ((long) Math.max(86400, this.f243a.a(hk.K.a(), 259200)));
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.xiaomi.push.ai.a
    /* renamed from: a */
    public String mo184a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "1" : (String) invokeV.objValue;
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            File file = new File(this.f40258a.getExternalFilesDir(null), "push_cdata.data");
            if (!bg.d(this.f40258a)) {
                if (file.length() > 1863680) {
                    file.delete();
                }
            } else if (!m250a() && file.exists()) {
                List<hn> a2 = a(file);
                if (!ad.a(a2)) {
                    int size = a2.size();
                    if (size > 4000) {
                        a2 = a2.subList(size - 4000, size);
                    }
                    hy hyVar = new hy();
                    hyVar.a(a2);
                    byte[] a3 = y.a(ip.a(hyVar));
                    ie ieVar = new ie("-1", false);
                    ieVar.c(hp.q.f509a);
                    ieVar.a(a3);
                    di m246a = dj.a().m246a();
                    if (m246a != null) {
                        m246a.a(ieVar, hf.f40530i, null);
                    }
                    a();
                }
                file.delete();
            }
        }
    }
}

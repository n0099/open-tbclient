package com.ss.android.socialbase.downloader.h;

import android.annotation.SuppressLint;
import android.os.Process;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.socialbase.downloader.downloader.j;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.network.i;
import java.io.IOException;
import java.util.List;
/* loaded from: classes3.dex */
public class b implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public static final String a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public com.ss.android.socialbase.downloader.model.b f62427b;

    /* renamed from: c  reason: collision with root package name */
    public com.ss.android.socialbase.downloader.model.b f62428c;

    /* renamed from: d  reason: collision with root package name */
    public com.ss.android.socialbase.downloader.downloader.e f62429d;

    /* renamed from: e  reason: collision with root package name */
    public final DownloadTask f62430e;

    /* renamed from: f  reason: collision with root package name */
    public DownloadInfo f62431f;

    /* renamed from: g  reason: collision with root package name */
    public final f f62432g;

    /* renamed from: h  reason: collision with root package name */
    public i f62433h;

    /* renamed from: i  reason: collision with root package name */
    public j f62434i;

    /* renamed from: j  reason: collision with root package name */
    public volatile boolean f62435j;

    /* renamed from: k  reason: collision with root package name */
    public volatile boolean f62436k;
    public boolean l;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(479400510, "Lcom/ss/android/socialbase/downloader/h/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(479400510, "Lcom/ss/android/socialbase/downloader/h/b;");
                return;
            }
        }
        a = b.class.getSimpleName();
    }

    public b(com.ss.android.socialbase.downloader.model.b bVar, DownloadTask downloadTask, f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, downloadTask, fVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.l = false;
        this.f62428c = bVar;
        this.f62430e = downloadTask;
        if (downloadTask != null) {
            this.f62431f = downloadTask.getDownloadInfo();
        }
        this.f62432g = fVar;
        this.f62434i = com.ss.android.socialbase.downloader.downloader.c.x();
        this.f62428c.a(this);
    }

    private String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) ? this.f62431f.getConnectionUrl() : (String) invokeV.objValue;
    }

    private void d() {
        i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65542, this) == null) || (iVar = this.f62433h) == null) {
            return;
        }
        iVar.d();
        this.f62433h = null;
    }

    private boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) ? this.f62435j || this.f62436k : invokeV.booleanValue;
    }

    public void a(long j2, long j3) {
        com.ss.android.socialbase.downloader.downloader.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) || (eVar = this.f62429d) == null) {
            return;
        }
        eVar.a(j2, j3);
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f62436k = true;
            com.ss.android.socialbase.downloader.downloader.e eVar = this.f62429d;
            if (eVar != null) {
                eVar.c();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x001b, code lost:
        r4.f62427b.a(false);
     */
    @Override // java.lang.Runnable
    @SuppressLint({"DefaultLocale"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            Process.setThreadPriority(10);
            this.f62427b = this.f62428c;
            while (true) {
                try {
                    this.f62427b.a(this);
                    if (!a(this.f62427b)) {
                        break;
                    }
                    this.f62427b.a(false);
                    if (!e()) {
                        this.f62427b = this.f62432g.a(this.f62427b.s());
                        if (e() || this.f62427b == null) {
                            break;
                        }
                        Thread.sleep(50L);
                    } else {
                        break;
                    }
                } finally {
                    com.ss.android.socialbase.downloader.model.b bVar = this.f62427b;
                    if (bVar != null) {
                        bVar.a(false);
                    }
                    d();
                    this.f62432g.a(this);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:141:0x01e8 A[Catch: all -> 0x02ab, TRY_ENTER, TryCatch #1 {all -> 0x02ab, blocks: (B:137:0x01de, B:141:0x01e8, B:143:0x01ee, B:146:0x01f7, B:148:0x01ff, B:150:0x0205, B:154:0x0210, B:156:0x0214, B:158:0x021c, B:160:0x022d, B:169:0x0253, B:171:0x0259, B:173:0x0266, B:177:0x026e, B:172:0x0260, B:163:0x023a, B:164:0x0246, B:179:0x0279, B:181:0x0281, B:183:0x0289, B:185:0x0291, B:187:0x0299, B:190:0x02a2, B:124:0x01c0, B:128:0x01ca, B:131:0x01d1), top: B:202:0x01de, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0259 A[Catch: all -> 0x02ab, TryCatch #1 {all -> 0x02ab, blocks: (B:137:0x01de, B:141:0x01e8, B:143:0x01ee, B:146:0x01f7, B:148:0x01ff, B:150:0x0205, B:154:0x0210, B:156:0x0214, B:158:0x021c, B:160:0x022d, B:169:0x0253, B:171:0x0259, B:173:0x0266, B:177:0x026e, B:172:0x0260, B:163:0x023a, B:164:0x0246, B:179:0x0279, B:181:0x0281, B:183:0x0289, B:185:0x0291, B:187:0x0299, B:190:0x02a2, B:124:0x01c0, B:128:0x01ca, B:131:0x01d1), top: B:202:0x01de, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0260 A[Catch: all -> 0x02ab, TryCatch #1 {all -> 0x02ab, blocks: (B:137:0x01de, B:141:0x01e8, B:143:0x01ee, B:146:0x01f7, B:148:0x01ff, B:150:0x0205, B:154:0x0210, B:156:0x0214, B:158:0x021c, B:160:0x022d, B:169:0x0253, B:171:0x0259, B:173:0x0266, B:177:0x026e, B:172:0x0260, B:163:0x023a, B:164:0x0246, B:179:0x0279, B:181:0x0281, B:183:0x0289, B:185:0x0291, B:187:0x0299, B:190:0x02a2, B:124:0x01c0, B:128:0x01ca, B:131:0x01d1), top: B:202:0x01de, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:177:0x026e A[Catch: all -> 0x02ab, TRY_ENTER, TRY_LEAVE, TryCatch #1 {all -> 0x02ab, blocks: (B:137:0x01de, B:141:0x01e8, B:143:0x01ee, B:146:0x01f7, B:148:0x01ff, B:150:0x0205, B:154:0x0210, B:156:0x0214, B:158:0x021c, B:160:0x022d, B:169:0x0253, B:171:0x0259, B:173:0x0266, B:177:0x026e, B:172:0x0260, B:163:0x023a, B:164:0x0246, B:179:0x0279, B:181:0x0281, B:183:0x0289, B:185:0x0291, B:187:0x0299, B:190:0x02a2, B:124:0x01c0, B:128:0x01ca, B:131:0x01d1), top: B:202:0x01de, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:224:0x0103 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:232:0x026a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:234:0x01e4 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0107 A[Catch: all -> 0x01be, BaseException -> 0x01da, TRY_ENTER, TryCatch #11 {BaseException -> 0x01da, blocks: (B:24:0x0053, B:28:0x005d, B:32:0x0068, B:64:0x00fd, B:68:0x0107, B:70:0x010b, B:81:0x013b, B:53:0x00e1), top: B:215:0x0053 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean a(com.ss.android.socialbase.downloader.model.b bVar) {
        InterceptResult invokeL;
        boolean z;
        long j2;
        long j3;
        com.ss.android.socialbase.downloader.exception.h a2;
        int b2;
        com.ss.android.socialbase.downloader.model.b e2;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, bVar)) != null) {
            return invokeL.booleanValue;
        }
        while (true) {
            com.ss.android.socialbase.downloader.model.b bVar2 = (bVar.d() && bVar.f() && (e2 = bVar.e()) != null && e2.s() == bVar.s()) ? e2 : null;
            if (bVar2 != null && bVar2.i()) {
                return true;
            }
            long n = bVar.n();
            long p = bVar.p();
            long n2 = bVar.n();
            if (bVar2 != null) {
                n2 = bVar2.n();
                n = bVar2.n();
                p = bVar2.p();
            }
            long j4 = n;
            long j5 = p;
            long j6 = 0;
            boolean z2 = false;
            try {
                try {
                    if (e()) {
                        return false;
                    }
                    String c2 = c();
                    boolean z3 = this.f62433h != null;
                    this.l = z3;
                    bVar.b(z3);
                    try {
                        try {
                            if (!this.l) {
                                List<com.ss.android.socialbase.downloader.model.c> a3 = com.ss.android.socialbase.downloader.i.f.a(this.f62431f.getExtraHeaders(), this.f62431f.geteTag(), j4, j5);
                                a3.add(new com.ss.android.socialbase.downloader.model.c("Chunk-Index", String.valueOf(bVar.s())));
                                com.ss.android.socialbase.downloader.i.f.a(a3, this.f62431f);
                                com.ss.android.socialbase.downloader.i.f.b(a3, this.f62431f);
                                this.f62433h = com.ss.android.socialbase.downloader.downloader.c.a(this.f62431f.isNeedDefaultHttpServiceBackUp(), this.f62431f.getMaxBytes(), c2, a3);
                            }
                        } catch (BaseException e3) {
                            e = e3;
                            z2 = false;
                            try {
                                if (e()) {
                                    return true;
                                }
                                if (com.ss.android.socialbase.downloader.i.f.b(e)) {
                                    this.f62432g.a(e, z);
                                    return z;
                                } else if (this.f62432g.a(e)) {
                                    if (com.ss.android.socialbase.downloader.i.f.a(e)) {
                                        this.f62432g.a(e, true);
                                        return z;
                                    }
                                    if (z2) {
                                        if (this.f62429d != null) {
                                            if (com.ss.android.socialbase.downloader.i.a.a(32)) {
                                                j3 = this.f62429d.a() - this.f62429d.e();
                                                int i2 = (j3 > 0L ? 1 : (j3 == 0L ? 0 : -1));
                                                if (i2 > 0) {
                                                    a(bVar, this.f62429d.e());
                                                } else if (i2 < 0) {
                                                }
                                                if (!com.ss.android.socialbase.downloader.i.a.a(16)) {
                                                    a2 = this.f62432g.a(bVar, e, j3);
                                                } else {
                                                    a2 = this.f62432g.a(e, j3);
                                                }
                                                if (a2 != com.ss.android.socialbase.downloader.exception.h.a) {
                                                    return z;
                                                }
                                                bVar.b(z);
                                                d();
                                            } else {
                                                j6 = this.f62429d.a() - j2;
                                                a(bVar, j2);
                                            }
                                        } else {
                                            this.f62432g.b(e);
                                            return z;
                                        }
                                    }
                                    j3 = j6;
                                    if (!com.ss.android.socialbase.downloader.i.a.a(16)) {
                                    }
                                    if (a2 != com.ss.android.socialbase.downloader.exception.h.a) {
                                    }
                                } else if (this.f62431f.isNeedChunkDowngradeRetry() && !this.f62431f.isChunkDowngradeRetryUsed() && this.f62431f.getChunkCount() > 1 && com.ss.android.socialbase.downloader.i.f.a(e, this.f62431f)) {
                                    this.f62432g.c(e);
                                    return z;
                                } else {
                                    this.f62432g.b(e);
                                    return z;
                                }
                            } finally {
                                d();
                            }
                        }
                        try {
                            if (this.f62433h != null && this.f62432g != null) {
                                try {
                                    int b3 = this.f62433h.b();
                                    if (b3 < 200 || b3 >= 300) {
                                        this.f62432g.a(this.f62433h);
                                    }
                                } catch (Throwable th) {
                                    th = th;
                                    th.printStackTrace();
                                    if (e()) {
                                    }
                                }
                            }
                        } catch (BaseException e4) {
                            e = e4;
                            j2 = n2;
                            z = false;
                            if (e()) {
                            }
                        }
                    } catch (BaseException e5) {
                        try {
                            throw e5;
                        } catch (Throwable th2) {
                            th = th2;
                            Throwable th3 = th;
                            if (this.f62433h != null) {
                                try {
                                    b2 = this.f62433h.b();
                                    if (b2 >= 200) {
                                    }
                                    this.f62432g.a(this.f62433h);
                                } catch (Throwable th4) {
                                    th4.printStackTrace();
                                }
                            }
                            throw th3;
                        }
                    } catch (Throwable th5) {
                        try {
                            com.ss.android.socialbase.downloader.i.f.a(th5, "ChunkRunnableConnection");
                            if (this.f62433h != null && this.f62432g != null) {
                                try {
                                    int b4 = this.f62433h.b();
                                    if (b4 < 200 || b4 >= 300) {
                                        this.f62432g.a(this.f62433h);
                                    }
                                } catch (Throwable th6) {
                                    th = th6;
                                    th.printStackTrace();
                                    if (e()) {
                                    }
                                }
                            }
                        } catch (Throwable th7) {
                            th = th7;
                            Throwable th32 = th;
                            if (this.f62433h != null && this.f62432g != null) {
                                b2 = this.f62433h.b();
                                if (b2 >= 200 || b2 >= 300) {
                                    this.f62432g.a(this.f62433h);
                                }
                            }
                            throw th32;
                        }
                    }
                    if (e()) {
                        return false;
                    }
                    if (this.f62433h != null) {
                        if (!this.l) {
                            try {
                                int b5 = this.f62433h.b();
                                if (!com.ss.android.socialbase.downloader.i.f.d(b5)) {
                                    throw new BaseException(1002, String.format("Http response error , code is : %s ", String.valueOf(b5)));
                                    break;
                                }
                            } catch (BaseException e6) {
                                throw e6;
                                break;
                            } catch (Throwable th8) {
                                com.ss.android.socialbase.downloader.i.f.a(th8, "ChunkRunnableGetResponseCode");
                            }
                        }
                        z = false;
                        j2 = n2;
                        try {
                            this.f62429d = new com.ss.android.socialbase.downloader.downloader.e(this.f62431f, c2, this.f62433h, bVar, this.f62432g);
                            if (bVar2 != null) {
                                long c3 = bVar2.c(false);
                                if (j5 != 0 && j5 >= j4) {
                                    c3 = (j5 - j4) + 1;
                                }
                                this.f62429d.a(bVar2.n(), bVar2.p(), c3);
                            }
                            try {
                                this.f62429d.d();
                                return true;
                            } catch (BaseException e7) {
                                e = e7;
                                z2 = true;
                                if (e()) {
                                }
                            }
                        } catch (Throwable th9) {
                            th = th9;
                            if (e()) {
                                return true;
                            }
                            try {
                                com.ss.android.socialbase.downloader.i.f.a(th, "downloadChunkInner");
                            } catch (BaseException e8) {
                                this.f62432g.b(e8);
                            }
                            return z;
                        }
                    } else {
                        throw new BaseException(1022, new IOException("download can't continue, chunk connection is null"));
                    }
                } catch (BaseException e9) {
                    e = e9;
                    j2 = n2;
                    z = false;
                }
            } catch (Throwable th10) {
                th = th10;
                z = false;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b(com.ss.android.socialbase.downloader.model.b bVar, DownloadTask downloadTask, i iVar, f fVar) {
        this(bVar, downloadTask, fVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, downloadTask, iVar, fVar};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((com.ss.android.socialbase.downloader.model.b) objArr2[0], (DownloadTask) objArr2[1], (f) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f62433h = iVar;
    }

    private void a(com.ss.android.socialbase.downloader.model.b bVar, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65539, this, bVar, j2) == null) {
            com.ss.android.socialbase.downloader.model.b e2 = bVar.d() ? bVar.e() : bVar;
            if (e2 != null) {
                if (e2.h()) {
                    this.f62434i.a(e2.k(), e2.b(), j2);
                }
                e2.b(j2);
                this.f62434i.a(e2.k(), e2.s(), e2.b(), j2);
            } else if (bVar.d()) {
                this.f62434i.a(bVar.k(), bVar.s(), j2);
            }
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f62435j = true;
            com.ss.android.socialbase.downloader.downloader.e eVar = this.f62429d;
            if (eVar != null) {
                eVar.b();
            }
        }
    }
}

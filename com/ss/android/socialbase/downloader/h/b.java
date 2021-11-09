package com.ss.android.socialbase.downloader.h;

import android.annotation.SuppressLint;
import android.os.Process;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
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
/* loaded from: classes2.dex */
public class b implements Runnable {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final String f69394a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public com.ss.android.socialbase.downloader.model.b f69395b;

    /* renamed from: c  reason: collision with root package name */
    public com.ss.android.socialbase.downloader.model.b f69396c;

    /* renamed from: d  reason: collision with root package name */
    public com.ss.android.socialbase.downloader.downloader.e f69397d;

    /* renamed from: e  reason: collision with root package name */
    public final DownloadTask f69398e;

    /* renamed from: f  reason: collision with root package name */
    public DownloadInfo f69399f;

    /* renamed from: g  reason: collision with root package name */
    public final f f69400g;

    /* renamed from: h  reason: collision with root package name */
    public i f69401h;

    /* renamed from: i  reason: collision with root package name */
    public j f69402i;
    public volatile boolean j;
    public volatile boolean k;
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
        f69394a = b.class.getSimpleName();
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
        this.f69396c = bVar;
        this.f69398e = downloadTask;
        if (downloadTask != null) {
            this.f69399f = downloadTask.getDownloadInfo();
        }
        this.f69400g = fVar;
        this.f69402i = com.ss.android.socialbase.downloader.downloader.c.x();
        this.f69396c.a(this);
    }

    private String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this)) == null) ? this.f69399f.getConnectionUrl() : (String) invokeV.objValue;
    }

    private void d() {
        i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) || (iVar = this.f69401h) == null) {
            return;
        }
        iVar.d();
        this.f69401h = null;
    }

    private boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) ? this.j || this.k : invokeV.booleanValue;
    }

    public void a(long j, long j2) {
        com.ss.android.socialbase.downloader.downloader.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) || (eVar = this.f69397d) == null) {
            return;
        }
        eVar.a(j, j2);
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.k = true;
            com.ss.android.socialbase.downloader.downloader.e eVar = this.f69397d;
            if (eVar != null) {
                eVar.c();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x001b, code lost:
        r4.f69395b.a(false);
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
            this.f69395b = this.f69396c;
            while (true) {
                try {
                    this.f69395b.a(this);
                    if (!a(this.f69395b)) {
                        break;
                    }
                    this.f69395b.a(false);
                    if (!e()) {
                        this.f69395b = this.f69400g.a(this.f69395b.s());
                        if (e() || this.f69395b == null) {
                            break;
                        }
                        Thread.sleep(50L);
                    } else {
                        break;
                    }
                } finally {
                    com.ss.android.socialbase.downloader.model.b bVar = this.f69395b;
                    if (bVar != null) {
                        bVar.a(false);
                    }
                    d();
                    this.f69400g.a(this);
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
        long j;
        long j2;
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
            long j3 = n;
            long j4 = p;
            long j5 = 0;
            boolean z2 = false;
            try {
                try {
                    if (e()) {
                        return false;
                    }
                    String c2 = c();
                    boolean z3 = this.f69401h != null;
                    this.l = z3;
                    bVar.b(z3);
                    try {
                        try {
                            if (!this.l) {
                                List<com.ss.android.socialbase.downloader.model.c> a3 = com.ss.android.socialbase.downloader.i.f.a(this.f69399f.getExtraHeaders(), this.f69399f.geteTag(), j3, j4);
                                a3.add(new com.ss.android.socialbase.downloader.model.c("Chunk-Index", String.valueOf(bVar.s())));
                                com.ss.android.socialbase.downloader.i.f.a(a3, this.f69399f);
                                com.ss.android.socialbase.downloader.i.f.b(a3, this.f69399f);
                                this.f69401h = com.ss.android.socialbase.downloader.downloader.c.a(this.f69399f.isNeedDefaultHttpServiceBackUp(), this.f69399f.getMaxBytes(), c2, a3);
                            }
                        } catch (BaseException e3) {
                            e = e3;
                            z2 = false;
                            try {
                                if (e()) {
                                    return true;
                                }
                                if (com.ss.android.socialbase.downloader.i.f.b(e)) {
                                    this.f69400g.a(e, z);
                                    return z;
                                } else if (this.f69400g.a(e)) {
                                    if (com.ss.android.socialbase.downloader.i.f.a(e)) {
                                        this.f69400g.a(e, true);
                                        return z;
                                    }
                                    if (z2) {
                                        if (this.f69397d != null) {
                                            if (com.ss.android.socialbase.downloader.i.a.a(32)) {
                                                j2 = this.f69397d.a() - this.f69397d.e();
                                                int i2 = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
                                                if (i2 > 0) {
                                                    a(bVar, this.f69397d.e());
                                                } else if (i2 < 0) {
                                                }
                                                if (!com.ss.android.socialbase.downloader.i.a.a(16)) {
                                                    a2 = this.f69400g.a(bVar, e, j2);
                                                } else {
                                                    a2 = this.f69400g.a(e, j2);
                                                }
                                                if (a2 != com.ss.android.socialbase.downloader.exception.h.f69310a) {
                                                    return z;
                                                }
                                                bVar.b(z);
                                                d();
                                            } else {
                                                j5 = this.f69397d.a() - j;
                                                a(bVar, j);
                                            }
                                        } else {
                                            this.f69400g.b(e);
                                            return z;
                                        }
                                    }
                                    j2 = j5;
                                    if (!com.ss.android.socialbase.downloader.i.a.a(16)) {
                                    }
                                    if (a2 != com.ss.android.socialbase.downloader.exception.h.f69310a) {
                                    }
                                } else if (this.f69399f.isNeedChunkDowngradeRetry() && !this.f69399f.isChunkDowngradeRetryUsed() && this.f69399f.getChunkCount() > 1 && com.ss.android.socialbase.downloader.i.f.a(e, this.f69399f)) {
                                    this.f69400g.c(e);
                                    return z;
                                } else {
                                    this.f69400g.b(e);
                                    return z;
                                }
                            } finally {
                                d();
                            }
                        }
                        try {
                            if (this.f69401h != null && this.f69400g != null) {
                                try {
                                    int b3 = this.f69401h.b();
                                    if (b3 < 200 || b3 >= 300) {
                                        this.f69400g.a(this.f69401h);
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
                            j = n2;
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
                            if (this.f69401h != null) {
                                try {
                                    b2 = this.f69401h.b();
                                    if (b2 >= 200) {
                                    }
                                    this.f69400g.a(this.f69401h);
                                } catch (Throwable th4) {
                                    th4.printStackTrace();
                                }
                            }
                            throw th3;
                        }
                    } catch (Throwable th5) {
                        try {
                            com.ss.android.socialbase.downloader.i.f.a(th5, "ChunkRunnableConnection");
                            if (this.f69401h != null && this.f69400g != null) {
                                try {
                                    int b4 = this.f69401h.b();
                                    if (b4 < 200 || b4 >= 300) {
                                        this.f69400g.a(this.f69401h);
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
                            if (this.f69401h != null && this.f69400g != null) {
                                b2 = this.f69401h.b();
                                if (b2 >= 200 || b2 >= 300) {
                                    this.f69400g.a(this.f69401h);
                                }
                            }
                            throw th32;
                        }
                    }
                    if (e()) {
                        return false;
                    }
                    if (this.f69401h != null) {
                        if (!this.l) {
                            try {
                                int b5 = this.f69401h.b();
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
                        j = n2;
                        try {
                            this.f69397d = new com.ss.android.socialbase.downloader.downloader.e(this.f69399f, c2, this.f69401h, bVar, this.f69400g);
                            if (bVar2 != null) {
                                long c3 = bVar2.c(false);
                                if (j4 != 0 && j4 >= j3) {
                                    c3 = (j4 - j3) + 1;
                                }
                                this.f69397d.a(bVar2.n(), bVar2.p(), c3);
                            }
                            try {
                                this.f69397d.d();
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
                                this.f69400g.b(e8);
                            }
                            return z;
                        }
                    } else {
                        throw new BaseException(1022, new IOException("download can't continue, chunk connection is null"));
                    }
                } catch (BaseException e9) {
                    e = e9;
                    j = n2;
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
        this.f69401h = iVar;
    }

    private void a(com.ss.android.socialbase.downloader.model.b bVar, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65539, this, bVar, j) == null) {
            com.ss.android.socialbase.downloader.model.b e2 = bVar.d() ? bVar.e() : bVar;
            if (e2 != null) {
                if (e2.h()) {
                    this.f69402i.a(e2.k(), e2.b(), j);
                }
                e2.b(j);
                this.f69402i.a(e2.k(), e2.s(), e2.b(), j);
            } else if (bVar.d()) {
                this.f69402i.a(bVar.k(), bVar.s(), j);
            }
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.j = true;
            com.ss.android.socialbase.downloader.downloader.e eVar = this.f69397d;
            if (eVar != null) {
                eVar.b();
            }
        }
    }
}

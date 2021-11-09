package com.ss.android.socialbase.downloader.f;

import android.os.SystemClock;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final List<l> f69327a;

    /* renamed from: b  reason: collision with root package name */
    public final List<l> f69328b;

    /* renamed from: c  reason: collision with root package name */
    public final DownloadInfo f69329c;

    /* renamed from: d  reason: collision with root package name */
    public final com.ss.android.socialbase.downloader.downloader.j f69330d;

    /* renamed from: e  reason: collision with root package name */
    public final com.ss.android.socialbase.downloader.g.a f69331e;

    /* renamed from: f  reason: collision with root package name */
    public final com.ss.android.socialbase.downloader.h.f f69332f;

    /* renamed from: g  reason: collision with root package name */
    public final c f69333g;

    /* renamed from: h  reason: collision with root package name */
    public BaseException f69334h;

    /* renamed from: i  reason: collision with root package name */
    public volatile boolean f69335i;
    public volatile boolean j;
    public volatile boolean k;
    public final com.ss.android.socialbase.downloader.a.a l;
    public final boolean m;
    public final long n;
    public final long o;
    public final boolean p;
    public long q;
    public volatile long r;
    public volatile long s;

    public g(DownloadInfo downloadInfo, com.ss.android.socialbase.downloader.h.f fVar, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {downloadInfo, fVar, cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f69327a = new LinkedList();
        this.f69328b = new ArrayList();
        this.f69335i = false;
        this.j = false;
        this.k = false;
        this.r = 0L;
        this.s = 0L;
        this.f69329c = downloadInfo;
        this.f69330d = com.ss.android.socialbase.downloader.downloader.c.x();
        this.f69332f = fVar;
        this.f69333g = cVar;
        this.l = com.ss.android.socialbase.downloader.a.a.a();
        com.ss.android.socialbase.downloader.g.a a2 = com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId());
        this.f69331e = a2;
        boolean z = a2.a("sync_strategy", 0) == 1;
        this.m = z;
        if (z) {
            this.n = Math.max(this.f69331e.a("sync_interval_ms_fg", 5000), 500L);
            this.o = Math.max(this.f69331e.a("sync_interval_ms_bg", 1000), 500L);
        } else {
            this.n = 0L;
            this.o = 0L;
        }
        this.p = this.f69331e.b("monitor_rw") == 1;
    }

    private boolean a(long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) ? j > 65536 && j2 > 500 : invokeCommon.booleanValue;
    }

    private void b(List<l> list) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, list) == null) {
            for (l lVar : list) {
                lVar.c();
            }
        }
    }

    private void c() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            boolean z = this.p;
            long nanoTime = z ? System.nanoTime() : 0L;
            DownloadInfo downloadInfo = this.f69329c;
            com.ss.android.socialbase.downloader.downloader.j jVar = this.f69330d;
            List<l> list = this.f69327a;
            List<l> list2 = this.f69328b;
            Map<Long, i> l = jVar.l(downloadInfo.getId());
            if (l == null) {
                l = new HashMap<>(4);
            }
            synchronized (this) {
                a(list);
                b(list);
                a(list, l);
                if (list2.size() > 0) {
                    c(list2);
                    list.removeAll(list2);
                    list2.clear();
                }
            }
            if (1 != 0) {
                downloadInfo.updateRealDownloadTime(true);
                jVar.a(downloadInfo.getId(), l);
                jVar.a(downloadInfo);
                this.r = downloadInfo.getCurBytes();
            }
            if (z) {
                this.q += System.nanoTime() - nanoTime;
            }
        }
    }

    public void a(l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, lVar) == null) {
            synchronized (this) {
                this.f69327a.add(lVar);
            }
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.j = true;
            this.f69335i = true;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:210:0x02a6, code lost:
        r3.b(r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00bc, code lost:
        if (r13 <= 0) goto L269;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00bf, code lost:
        r3.b(r13);
     */
    /* JADX WARN: Removed duplicated region for block: B:162:0x01f7 A[Catch: all -> 0x03db, TryCatch #28 {all -> 0x03db, blocks: (B:160:0x01f3, B:162:0x01f7, B:165:0x01fd, B:167:0x0203, B:168:0x0206, B:169:0x021c, B:206:0x02a0, B:207:0x02a2, B:246:0x0329, B:248:0x0333, B:250:0x0337, B:287:0x03b9, B:289:0x03bf, B:290:0x03c2, B:291:0x03da), top: B:366:0x002b, inners: #24 }] */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0203 A[Catch: all -> 0x03db, TryCatch #28 {all -> 0x03db, blocks: (B:160:0x01f3, B:162:0x01f7, B:165:0x01fd, B:167:0x0203, B:168:0x0206, B:169:0x021c, B:206:0x02a0, B:207:0x02a2, B:246:0x0329, B:248:0x0333, B:250:0x0337, B:287:0x03b9, B:289:0x03bf, B:290:0x03c2, B:291:0x03da), top: B:366:0x002b, inners: #24 }] */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0223  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x0333 A[Catch: all -> 0x03db, TryCatch #28 {all -> 0x03db, blocks: (B:160:0x01f3, B:162:0x01f7, B:165:0x01fd, B:167:0x0203, B:168:0x0206, B:169:0x021c, B:206:0x02a0, B:207:0x02a2, B:246:0x0329, B:248:0x0333, B:250:0x0337, B:287:0x03b9, B:289:0x03bf, B:290:0x03c2, B:291:0x03da), top: B:366:0x002b, inners: #24 }] */
    /* JADX WARN: Removed duplicated region for block: B:289:0x03bf A[Catch: all -> 0x03db, TryCatch #28 {all -> 0x03db, blocks: (B:160:0x01f3, B:162:0x01f7, B:165:0x01fd, B:167:0x0203, B:168:0x0206, B:169:0x021c, B:206:0x02a0, B:207:0x02a2, B:246:0x0329, B:248:0x0333, B:250:0x0337, B:287:0x03b9, B:289:0x03bf, B:290:0x03c2, B:291:0x03da), top: B:366:0x002b, inners: #24 }] */
    /* JADX WARN: Removed duplicated region for block: B:302:0x03ef  */
    /* JADX WARN: Removed duplicated region for block: B:344:0x022d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:346:0x02af A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:348:0x0366 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:350:0x00e7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:371:0x0419 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:375:0x03f9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:381:0x024c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:383:0x02ce A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(d dVar) throws BaseException {
        DownloadInfo downloadInfo;
        long curBytes;
        long nanoTime;
        boolean z;
        boolean z2;
        long j;
        long j2;
        long j3;
        long j4;
        Throwable th;
        int i2;
        Throwable th2;
        Throwable th3;
        Throwable th4;
        Throwable th5;
        Throwable th6;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar) == null) || this.j || this.k) {
            return;
        }
        com.ss.android.socialbase.downloader.network.b.e();
        this.f69334h = null;
        downloadInfo = this.f69329c;
        com.ss.android.socialbase.downloader.h.f fVar = this.f69332f;
        c cVar = this.f69333g;
        curBytes = downloadInfo.getCurBytes();
        nanoTime = System.nanoTime();
        z = this.p;
        long j5 = 0;
        z2 = true;
        int i3 = 0;
        boolean z3 = false;
        try {
            try {
                downloadInfo.updateRealStartDownloadTime();
                long j6 = 0;
                long j7 = 0;
                long j8 = 0;
                int i4 = 0;
                while (true) {
                    if (z) {
                        try {
                            j6 = System.nanoTime();
                        } catch (p e2) {
                            e = e2;
                            i3 = i4;
                            j4 = j7;
                            try {
                                this.f69334h = e;
                                throw e;
                            } catch (Throwable th7) {
                                th = th7;
                                j2 = j5;
                                j = j4;
                                if (i3 > 0) {
                                }
                                if (!this.k) {
                                }
                                th5 = null;
                                synchronized (this) {
                                }
                            }
                        } catch (BaseException e3) {
                            e = e3;
                            j2 = j5;
                            i2 = i4;
                            j3 = j7;
                            if (!this.f69331e.a("ignore_base_ex_on_stop_status") && (this.j || this.k)) {
                                if (i2 > 0) {
                                    try {
                                        fVar.b(i2);
                                    } catch (Throwable unused) {
                                    }
                                }
                                if (!this.k) {
                                    try {
                                        c();
                                    } catch (Throwable th8) {
                                        th4 = th8;
                                        com.ss.android.socialbase.downloader.c.a.d("MultiSegmentWriter", "loopAndWrite: finally sync, e = " + th4);
                                        synchronized (this) {
                                            c(this.f69327a);
                                            this.f69327a.clear();
                                        }
                                        com.ss.android.socialbase.downloader.d.a.a(this.f69331e, downloadInfo, downloadInfo.getUrl(), null, this.j, this.k, this.f69334h, downloadInfo.getCurBytes() - curBytes, System.nanoTime() - nanoTime, z, j2, j3, this.q, null);
                                        if (th4 != null) {
                                            if (!this.j && !this.k && this.f69334h == null) {
                                                z2 = false;
                                            }
                                            if (z2) {
                                                return;
                                            }
                                            try {
                                                com.ss.android.socialbase.downloader.i.f.a(th4, "loopAndWrite_finally");
                                                return;
                                            } catch (BaseException e4) {
                                                this.f69334h = e4;
                                                throw e4;
                                            }
                                        }
                                        return;
                                    }
                                }
                                th4 = null;
                                synchronized (this) {
                                }
                            } else {
                                if (com.ss.android.socialbase.downloader.c.a.a()) {
                                    e.printStackTrace();
                                }
                                com.ss.android.socialbase.downloader.c.a.d("MultiSegmentWriter", "loopAndWrite:  BaseException e = " + e);
                                this.f69334h = e;
                                throw e;
                            }
                        } catch (Throwable th9) {
                            th = th9;
                            j2 = j5;
                            i3 = i4;
                            j = j7;
                            if (!this.j && !this.k) {
                                if (com.ss.android.socialbase.downloader.c.a.a()) {
                                    th.printStackTrace();
                                }
                                com.ss.android.socialbase.downloader.c.a.d("MultiSegmentWriter", "loopAndWrite:  e = " + th);
                                try {
                                    com.ss.android.socialbase.downloader.i.f.a(th, "loopAndWrite");
                                    if (i3 > 0) {
                                        try {
                                            fVar.b(i3);
                                        } catch (Throwable unused2) {
                                        }
                                    }
                                    if (!this.k) {
                                        try {
                                            c();
                                        } catch (Throwable th10) {
                                            th3 = th10;
                                            com.ss.android.socialbase.downloader.c.a.d("MultiSegmentWriter", "loopAndWrite: finally sync, e = " + th3);
                                            synchronized (this) {
                                                c(this.f69327a);
                                                this.f69327a.clear();
                                            }
                                            com.ss.android.socialbase.downloader.d.a.a(this.f69331e, downloadInfo, downloadInfo.getUrl(), null, this.j, this.k, this.f69334h, downloadInfo.getCurBytes() - curBytes, System.nanoTime() - nanoTime, z, j2, j, this.q, null);
                                            if (th3 != null) {
                                                if (!this.j && !this.k && this.f69334h == null) {
                                                    z2 = false;
                                                }
                                                if (z2) {
                                                    return;
                                                }
                                                try {
                                                    com.ss.android.socialbase.downloader.i.f.a(th3, "loopAndWrite_finally");
                                                    return;
                                                } catch (BaseException e5) {
                                                    this.f69334h = e5;
                                                    throw e5;
                                                }
                                            }
                                            return;
                                        }
                                    }
                                    th3 = null;
                                    synchronized (this) {
                                    }
                                } catch (BaseException e6) {
                                    this.f69334h = e6;
                                    throw e6;
                                }
                            }
                            if (!this.k) {
                                try {
                                    c();
                                } catch (Throwable th11) {
                                    th2 = th11;
                                    com.ss.android.socialbase.downloader.c.a.d("MultiSegmentWriter", "loopAndWrite: finally sync, e = " + th2);
                                    synchronized (this) {
                                        c(this.f69327a);
                                        this.f69327a.clear();
                                    }
                                    com.ss.android.socialbase.downloader.d.a.a(this.f69331e, downloadInfo, downloadInfo.getUrl(), null, this.j, this.k, this.f69334h, downloadInfo.getCurBytes() - curBytes, System.nanoTime() - nanoTime, z, j2, j, this.q, null);
                                    if (th2 != null) {
                                        if (!this.j && !this.k && this.f69334h == null) {
                                            z2 = false;
                                        }
                                        if (z2) {
                                            return;
                                        }
                                        try {
                                            com.ss.android.socialbase.downloader.i.f.a(th2, "loopAndWrite_finally");
                                            return;
                                        } catch (BaseException e7) {
                                            this.f69334h = e7;
                                            throw e7;
                                        }
                                    }
                                    return;
                                }
                            }
                            th2 = null;
                            synchronized (this) {
                            }
                        }
                    }
                    try {
                        a a2 = dVar.a();
                        if (z) {
                            j5 += System.nanoTime() - j6;
                        }
                        j2 = j5;
                        try {
                            int i5 = a2.f69316c;
                            if (i5 == -1) {
                                try {
                                    a(a2.f69315b);
                                    cVar.a(a2);
                                    j5 = j2;
                                } catch (p e8) {
                                    e = e8;
                                    i3 = i4;
                                    j4 = j7;
                                    j5 = j2;
                                    this.f69334h = e;
                                    throw e;
                                } catch (BaseException e9) {
                                    e = e9;
                                    i2 = i4;
                                    j3 = j7;
                                    if (!this.f69331e.a("ignore_base_ex_on_stop_status")) {
                                    }
                                    if (com.ss.android.socialbase.downloader.c.a.a()) {
                                    }
                                    com.ss.android.socialbase.downloader.c.a.d("MultiSegmentWriter", "loopAndWrite:  BaseException e = " + e);
                                    this.f69334h = e;
                                    throw e;
                                } catch (Throwable th12) {
                                    th = th12;
                                    i3 = i4;
                                    j = j7;
                                    if (!this.j) {
                                    }
                                    if (!this.k) {
                                    }
                                    th2 = null;
                                    synchronized (this) {
                                    }
                                }
                            } else {
                                if (z) {
                                    j6 = System.nanoTime();
                                }
                                a2.f69315b.b(a2);
                                if (z) {
                                    j7 += System.nanoTime() - j6;
                                }
                                j4 = j7;
                                try {
                                    cVar.a(a2);
                                    if (this.f69335i) {
                                        if (this.j) {
                                            break;
                                        }
                                        try {
                                            if (this.k) {
                                                break;
                                            }
                                            this.f69335i = z3;
                                        } catch (p e10) {
                                            e = e10;
                                            i3 = i4;
                                            j5 = j2;
                                            this.f69334h = e;
                                            throw e;
                                        } catch (BaseException e11) {
                                            e = e11;
                                            i2 = i4;
                                            j3 = j4;
                                            if (!this.f69331e.a("ignore_base_ex_on_stop_status")) {
                                            }
                                            if (com.ss.android.socialbase.downloader.c.a.a()) {
                                            }
                                            com.ss.android.socialbase.downloader.c.a.d("MultiSegmentWriter", "loopAndWrite:  BaseException e = " + e);
                                            this.f69334h = e;
                                            throw e;
                                        } catch (Throwable th13) {
                                            th = th13;
                                            i3 = i4;
                                            j = j4;
                                            if (!this.j) {
                                            }
                                            if (!this.k) {
                                            }
                                            th2 = null;
                                            synchronized (this) {
                                            }
                                        }
                                    }
                                    i4 += i5;
                                    if (i4 >= 65536) {
                                        try {
                                            long uptimeMillis = SystemClock.uptimeMillis();
                                            if (uptimeMillis - j8 > 100) {
                                                long j9 = j6;
                                                try {
                                                    a(uptimeMillis, fVar.b(i4));
                                                    if (!com.ss.android.socialbase.downloader.network.b.f69674a) {
                                                        if (!downloadInfo.isOnlyWifi()) {
                                                            if (downloadInfo.isDownloadFromReserveWifi() && downloadInfo.isPauseReserveOnWifi()) {
                                                                throw new com.ss.android.socialbase.downloader.exception.e();
                                                            }
                                                        } else {
                                                            throw new com.ss.android.socialbase.downloader.exception.c();
                                                        }
                                                    }
                                                    j8 = uptimeMillis;
                                                    j5 = j2;
                                                    j7 = j4;
                                                    j6 = j9;
                                                    i4 = 0;
                                                    z3 = false;
                                                } catch (p e12) {
                                                    e = e12;
                                                    j5 = j2;
                                                    i3 = 0;
                                                    this.f69334h = e;
                                                    throw e;
                                                } catch (BaseException e13) {
                                                    e = e13;
                                                    j3 = j4;
                                                    i2 = 0;
                                                    if (!this.f69331e.a("ignore_base_ex_on_stop_status")) {
                                                    }
                                                    if (com.ss.android.socialbase.downloader.c.a.a()) {
                                                    }
                                                    com.ss.android.socialbase.downloader.c.a.d("MultiSegmentWriter", "loopAndWrite:  BaseException e = " + e);
                                                    this.f69334h = e;
                                                    throw e;
                                                } catch (Throwable th14) {
                                                    th = th14;
                                                    j = j4;
                                                    i3 = 0;
                                                    if (!this.j) {
                                                    }
                                                    if (!this.k) {
                                                    }
                                                    th2 = null;
                                                    synchronized (this) {
                                                    }
                                                }
                                            }
                                        } catch (p e14) {
                                            e = e14;
                                            i3 = i4;
                                            j5 = j2;
                                            this.f69334h = e;
                                            throw e;
                                        } catch (BaseException e15) {
                                            e = e15;
                                            i2 = i4;
                                            j3 = j4;
                                            if (!this.f69331e.a("ignore_base_ex_on_stop_status")) {
                                            }
                                            if (com.ss.android.socialbase.downloader.c.a.a()) {
                                            }
                                            com.ss.android.socialbase.downloader.c.a.d("MultiSegmentWriter", "loopAndWrite:  BaseException e = " + e);
                                            this.f69334h = e;
                                            throw e;
                                        } catch (Throwable th15) {
                                            th = th15;
                                            i3 = i4;
                                            j = j4;
                                            if (!this.j) {
                                            }
                                            if (!this.k) {
                                            }
                                            th2 = null;
                                            synchronized (this) {
                                            }
                                        }
                                    }
                                    j5 = j2;
                                    j7 = j4;
                                    j6 = j6;
                                    z3 = false;
                                } catch (p e16) {
                                    e = e16;
                                } catch (BaseException e17) {
                                    e = e17;
                                } catch (Throwable th16) {
                                    th = th16;
                                }
                            }
                        } catch (p e18) {
                            e = e18;
                            i3 = i4;
                            j4 = j7;
                        } catch (BaseException e19) {
                            e = e19;
                            i2 = i4;
                            j3 = j7;
                            if (!this.f69331e.a("ignore_base_ex_on_stop_status")) {
                            }
                            if (com.ss.android.socialbase.downloader.c.a.a()) {
                            }
                            com.ss.android.socialbase.downloader.c.a.d("MultiSegmentWriter", "loopAndWrite:  BaseException e = " + e);
                            this.f69334h = e;
                            throw e;
                        } catch (Throwable th17) {
                            th = th17;
                            i3 = i4;
                            j = j7;
                            if (!this.j) {
                                if (com.ss.android.socialbase.downloader.c.a.a()) {
                                }
                                com.ss.android.socialbase.downloader.c.a.d("MultiSegmentWriter", "loopAndWrite:  e = " + th);
                                com.ss.android.socialbase.downloader.i.f.a(th, "loopAndWrite");
                                if (i3 > 0) {
                                }
                                if (!this.k) {
                                }
                                th3 = null;
                                synchronized (this) {
                                }
                            }
                            if (!this.k) {
                            }
                            th2 = null;
                            synchronized (this) {
                            }
                        }
                    } catch (p e20) {
                        e = e20;
                        i3 = i4;
                        j4 = j7;
                    } catch (BaseException e21) {
                        e = e21;
                        j2 = j5;
                    } catch (Throwable th18) {
                        th = th18;
                        j2 = j5;
                    }
                }
            } catch (Throwable th19) {
                th = th19;
                if (i3 > 0) {
                    try {
                        fVar.b(i3);
                    } catch (Throwable unused3) {
                    }
                }
                if (!this.k) {
                    try {
                        c();
                    } catch (Throwable th20) {
                        com.ss.android.socialbase.downloader.c.a.d("MultiSegmentWriter", "loopAndWrite: finally sync, e = " + th20);
                        th5 = th20;
                        synchronized (this) {
                        }
                    }
                }
                th5 = null;
                synchronized (this) {
                    c(this.f69327a);
                    this.f69327a.clear();
                }
                com.ss.android.socialbase.downloader.d.a.a(this.f69331e, downloadInfo, downloadInfo.getUrl(), null, this.j, this.k, this.f69334h, downloadInfo.getCurBytes() - curBytes, System.nanoTime() - nanoTime, z, j2, j, this.q, null);
                if (th5 != null) {
                    if (!this.j && !this.k && this.f69334h == null) {
                        z2 = false;
                    }
                    if (!z2) {
                        try {
                            com.ss.android.socialbase.downloader.i.f.a(th5, "loopAndWrite_finally");
                        } catch (BaseException e22) {
                            this.f69334h = e22;
                            throw e22;
                        }
                    }
                }
                throw th;
            }
        } catch (p e23) {
            e = e23;
            j4 = 0;
        } catch (BaseException e24) {
            e = e24;
            j3 = 0;
            j2 = 0;
        } catch (Throwable th21) {
            th = th21;
            j = 0;
            j2 = 0;
        }
        if (!this.k) {
            try {
                c();
            } catch (Throwable th22) {
                th6 = th22;
                com.ss.android.socialbase.downloader.c.a.d("MultiSegmentWriter", "loopAndWrite: finally sync, e = " + th6);
                synchronized (this) {
                    c(this.f69327a);
                    this.f69327a.clear();
                }
                com.ss.android.socialbase.downloader.d.a.a(this.f69331e, downloadInfo, downloadInfo.getUrl(), null, this.j, this.k, this.f69334h, downloadInfo.getCurBytes() - curBytes, System.nanoTime() - nanoTime, z, j2, j4, this.q, null);
                if (th6 != null) {
                    if (!this.j && !this.k && this.f69334h == null) {
                        z2 = false;
                    }
                    if (z2) {
                        return;
                    }
                    try {
                        com.ss.android.socialbase.downloader.i.f.a(th6, "loopAndWrite_finally");
                        return;
                    } catch (BaseException e25) {
                        this.f69334h = e25;
                        throw e25;
                    }
                }
                return;
            }
        }
        th6 = null;
        synchronized (this) {
        }
    }

    private void c(List<l> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, list) == null) {
            for (l lVar : list) {
                lVar.d();
            }
        }
    }

    private void a(long j, boolean z) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z)}) == null) {
            long j2 = j - this.s;
            if (this.m) {
                if (j2 > (this.l.b() ? this.n : this.o)) {
                    c();
                    this.s = j;
                    return;
                }
                return;
            }
            long curBytes = this.f69329c.getCurBytes() - this.r;
            if (z || a(curBytes, j2)) {
                c();
                this.s = j;
            }
        }
    }

    private void a(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, eVar) == null) {
            synchronized (this) {
                this.f69328b.add((l) eVar);
            }
        }
    }

    private void a(List<l> list) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, list) == null) {
            for (l lVar : list) {
                lVar.b();
            }
        }
    }

    private void a(List<l> list, Map<Long, i> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, list, map) == null) {
            for (l lVar : list) {
                i e2 = lVar.e();
                i iVar = map.get(Long.valueOf(e2.c()));
                if (iVar == null) {
                    map.put(Long.valueOf(e2.c()), new i(e2));
                } else {
                    iVar.a(e2.d());
                    iVar.c(e2.f());
                }
            }
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.k = true;
            this.f69335i = true;
        }
    }
}

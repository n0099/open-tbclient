package com.ss.android.socialbase.downloader.b;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.socialbase.downloader.b.c;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import d.l.a.e.b.g.l;
import d.l.a.e.b.g.t;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import org.json.JSONArray;
/* loaded from: classes6.dex */
public class e extends c.a implements t {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static volatile SQLiteDatabase f38577b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public com.ss.android.socialbase.downloader.b.b f38578a;

    /* renamed from: c  reason: collision with root package name */
    public d.l.a.e.b.b.c f38579c;

    /* renamed from: d  reason: collision with root package name */
    public d.l.a.e.b.b.c f38580d;

    /* renamed from: e  reason: collision with root package name */
    public d.l.a.e.b.b.c f38581e;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f38582f;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ DownloadInfo f38583e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f38584f;

        public a(e eVar, DownloadInfo downloadInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, downloadInfo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38584f = eVar;
            this.f38583e = downloadInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f38584f.d(this.f38583e);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f38585e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f38586f;

        public b(e eVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38586f = eVar;
            this.f38585e = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f38586f.e(this.f38585e);
                this.f38586f.d(this.f38585e);
                this.f38586f.m(this.f38585e);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SparseArray f38587e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SparseArray f38588f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.l.a.e.b.b.b f38589g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ e f38590h;

        public c(e eVar, SparseArray sparseArray, SparseArray sparseArray2, d.l.a.e.b.b.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, sparseArray, sparseArray2, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38590h = eVar;
            this.f38587e = sparseArray;
            this.f38588f = sparseArray2;
            this.f38589g = bVar;
        }

        /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET]}, finally: {[IGET, IGET, IGET, IGET, INVOKE, INVOKE, IGET, INVOKE, IGET, IGET, IGET, INVOKE, IF] complete} */
        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        /* JADX DEBUG: Finally have unexpected throw blocks count: 3, expect 1 */
        /* JADX WARN: Code restructure failed: missing block: B:122:0x0273, code lost:
            if (r0 == null) goto L90;
         */
        /* JADX WARN: Code restructure failed: missing block: B:127:0x027d, code lost:
            if (r0 == null) goto L90;
         */
        /* JADX WARN: Code restructure failed: missing block: B:129:0x0281, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:163:0x0336, code lost:
            if (r0 == null) goto L183;
         */
        /* JADX WARN: Code restructure failed: missing block: B:168:0x033f, code lost:
            if (r0 == null) goto L183;
         */
        /* JADX WARN: Code restructure failed: missing block: B:169:0x0341, code lost:
            r0.a();
            r18.f38590h.f38582f = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:170:0x0349, code lost:
            r18.f38590h.a(r18.f38587e, r18.f38588f);
         */
        /* JADX WARN: Code restructure failed: missing block: B:171:0x0352, code lost:
            throw r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:80:0x019f, code lost:
            if (r0 != null) goto L92;
         */
        /* JADX WARN: Removed duplicated region for block: B:197:0x00de A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:199:0x00ce A[SYNTHETIC] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            d.l.a.e.b.b.b bVar;
            d.l.a.e.b.b.b bVar2;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.f38590h.h();
            if (e.f38577b == null) {
                return;
            }
            l b2 = d.l.a.e.b.g.e.b();
            SparseArray sparseArray = new SparseArray();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            Cursor cursor = null;
            int i2 = 0;
            try {
                cursor = e.f38577b.rawQuery("SELECT * FROM downloader", null);
                while (cursor.moveToNext()) {
                    DownloadInfo downloadInfo = new DownloadInfo(cursor);
                    downloadInfo.setStatusAtDbInit(downloadInfo.getRealStatus());
                    if (downloadInfo.isCanResumeFromBreakPointStatus()) {
                        downloadInfo.setStatus(-5);
                        if (d.l.a.e.b.j.a.r().q("status_not_update_to_db", true)) {
                            sparseArray.put(downloadInfo.getId(), downloadInfo);
                        }
                    }
                    if (!TextUtils.isEmpty(downloadInfo.getSavePath()) && !TextUtils.isEmpty(downloadInfo.getName())) {
                        if (downloadInfo.getStatus() != 1 || downloadInfo.getCurBytes() > 0) {
                            if (downloadInfo.getStatus() != -3 && downloadInfo.getStatus() != 11 && !downloadInfo.isFileDataValid()) {
                                downloadInfo.reset();
                            }
                            z = false;
                        } else {
                            z = true;
                        }
                        if (downloadInfo.getStatus() == 11) {
                            downloadInfo.setStatus(-5);
                        }
                        if (d.l.a.e.b.l.f.I(downloadInfo.getStatus(), downloadInfo.getSavePath(), downloadInfo.getName())) {
                            if (!d.l.a.e.b.l.a.a(33554432)) {
                                downloadInfo.erase();
                            }
                        }
                        if (!z) {
                            arrayList.add(Integer.valueOf(downloadInfo.getId()));
                            arrayList2.add(downloadInfo);
                        } else {
                            int id = downloadInfo.getId();
                            int a2 = b2 != null ? b2.a(downloadInfo.getUrl(), downloadInfo.getSavePath()) : 0;
                            if (a2 != id) {
                                downloadInfo.setId(a2);
                                sparseArray.put(id, downloadInfo);
                            }
                            this.f38587e.put(downloadInfo.getId(), downloadInfo);
                        }
                    }
                    z = true;
                    if (!z) {
                    }
                }
                d.l.a.e.b.l.f.D(cursor);
                this.f38590h.a(arrayList2);
                this.f38590h.a(arrayList2, arrayList, sparseArray, this.f38587e, this.f38588f);
                try {
                    ArrayList<Integer> arrayList3 = new ArrayList();
                    if (this.f38587e != null) {
                        while (i2 < this.f38587e.size()) {
                            int keyAt = this.f38587e.keyAt(i2);
                            if (keyAt != 0) {
                                DownloadInfo downloadInfo2 = (DownloadInfo) this.f38587e.get(keyAt);
                                if (d.l.a.e.b.l.a.a(8192)) {
                                    if (downloadInfo2 != null && !downloadInfo2.isChunkBreakpointAvailable() && downloadInfo2.getStatus() != -3) {
                                        arrayList3.add(Integer.valueOf(downloadInfo2.getId()));
                                        this.f38588f.remove(downloadInfo2.getId());
                                    }
                                } else if (downloadInfo2 != null && !downloadInfo2.isChunkBreakpointAvailable()) {
                                    arrayList3.add(Integer.valueOf(downloadInfo2.getId()));
                                    this.f38588f.remove(downloadInfo2.getId());
                                }
                            }
                            for (Integer num : arrayList3) {
                                this.f38587e.remove(num.intValue());
                            }
                            i2++;
                        }
                    }
                    bVar2 = this.f38589g;
                } catch (Throwable th) {
                    try {
                        th.printStackTrace();
                    } finally {
                    }
                }
            } catch (Throwable th2) {
                try {
                    th2.printStackTrace();
                    d.l.a.e.b.l.f.D(cursor);
                    this.f38590h.a(arrayList2);
                    this.f38590h.a(arrayList2, arrayList, sparseArray, this.f38587e, this.f38588f);
                    try {
                        ArrayList<Integer> arrayList4 = new ArrayList();
                        if (this.f38587e != null) {
                            while (i2 < this.f38587e.size()) {
                                int keyAt2 = this.f38587e.keyAt(i2);
                                if (keyAt2 != 0) {
                                    DownloadInfo downloadInfo3 = (DownloadInfo) this.f38587e.get(keyAt2);
                                    if (d.l.a.e.b.l.a.a(8192)) {
                                        if (downloadInfo3 != null && !downloadInfo3.isChunkBreakpointAvailable() && downloadInfo3.getStatus() != -3) {
                                            arrayList4.add(Integer.valueOf(downloadInfo3.getId()));
                                            this.f38588f.remove(downloadInfo3.getId());
                                        }
                                    } else if (downloadInfo3 != null && !downloadInfo3.isChunkBreakpointAvailable()) {
                                        arrayList4.add(Integer.valueOf(downloadInfo3.getId()));
                                        this.f38588f.remove(downloadInfo3.getId());
                                    }
                                }
                                for (Integer num2 : arrayList4) {
                                    this.f38587e.remove(num2.intValue());
                                }
                                i2++;
                            }
                        }
                        bVar2 = this.f38589g;
                    } catch (Throwable th3) {
                        try {
                            th3.printStackTrace();
                            bVar2 = this.f38589g;
                        } finally {
                            d.l.a.e.b.b.b bVar3 = this.f38589g;
                            if (bVar3 != null) {
                                bVar3.a();
                                this.f38590h.f38582f = true;
                            }
                            this.f38590h.a(this.f38587e, this.f38588f);
                        }
                    }
                } catch (Throwable th4) {
                    d.l.a.e.b.l.f.D(cursor);
                    this.f38590h.a(arrayList2);
                    this.f38590h.a(arrayList2, arrayList, sparseArray, this.f38587e, this.f38588f);
                    try {
                        ArrayList<Integer> arrayList5 = new ArrayList();
                        if (this.f38587e != null) {
                            while (i2 < this.f38587e.size()) {
                                int keyAt3 = this.f38587e.keyAt(i2);
                                if (keyAt3 != 0) {
                                    DownloadInfo downloadInfo4 = (DownloadInfo) this.f38587e.get(keyAt3);
                                    if (d.l.a.e.b.l.a.a(8192)) {
                                        if (downloadInfo4 != null && !downloadInfo4.isChunkBreakpointAvailable() && downloadInfo4.getStatus() != -3) {
                                            arrayList5.add(Integer.valueOf(downloadInfo4.getId()));
                                            this.f38588f.remove(downloadInfo4.getId());
                                        }
                                    } else if (downloadInfo4 != null && !downloadInfo4.isChunkBreakpointAvailable()) {
                                        arrayList5.add(Integer.valueOf(downloadInfo4.getId()));
                                        this.f38588f.remove(downloadInfo4.getId());
                                    }
                                }
                                for (Integer num3 : arrayList5) {
                                    this.f38587e.remove(num3.intValue());
                                }
                                i2++;
                            }
                        }
                        bVar = this.f38589g;
                    } catch (Throwable th5) {
                        try {
                            th5.printStackTrace();
                            bVar = this.f38589g;
                        } finally {
                            d.l.a.e.b.b.b bVar4 = this.f38589g;
                            if (bVar4 != null) {
                                bVar4.a();
                                this.f38590h.f38582f = true;
                            }
                            this.f38590h.a(this.f38587e, this.f38588f);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f38591e;

        public d(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38591e = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f38591e.k();
            }
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.b.e$e  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class RunnableC0492e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f38592e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ContentValues f38593f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ e f38594g;

        public RunnableC0492e(e eVar, int i2, ContentValues contentValues) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, Integer.valueOf(i2), contentValues};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38594g = eVar;
            this.f38592e = i2;
            this.f38593f = contentValues;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f38594g.b(this.f38592e, this.f38593f);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f38595e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f38596f;

        public f(e eVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38596f = eVar;
            this.f38595e = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.f38596f.a(this.f38595e, this.f38596f.f38580d.b());
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ com.ss.android.socialbase.downloader.model.b f38597e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f38598f;

        public g(e eVar, com.ss.android.socialbase.downloader.model.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38598f = eVar;
            this.f38597e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.f38598f.a(this.f38597e, this.f38598f.f38580d.a());
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f38599e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f38600f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ long f38601g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ e f38602h;

        public h(e eVar, int i2, int i3, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38602h = eVar;
            this.f38599e = i2;
            this.f38600f = i3;
            this.f38601g = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.f38602h.a(this.f38599e, this.f38600f, this.f38601g, this.f38602h.f38580d.c());
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f38603e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f38604f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f38605g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ long f38606h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ e f38607i;

        public i(e eVar, int i2, int i3, int i4, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38607i = eVar;
            this.f38603e = i2;
            this.f38604f = i3;
            this.f38605g = i4;
            this.f38606h = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.f38607i.a(this.f38603e, this.f38604f, this.f38605g, this.f38606h, this.f38607i.f38580d.c());
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f38608e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f38609f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f38610g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f38611h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ e f38612i;

        public j(e eVar, int i2, int i3, int i4, int i5) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i6 = newInitContext.flag;
                if ((i6 & 1) != 0) {
                    int i7 = i6 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38612i = eVar;
            this.f38608e = i2;
            this.f38609f = i3;
            this.f38610g = i4;
            this.f38611h = i5;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.f38612i.a(this.f38608e, this.f38609f, this.f38610g, this.f38611h, this.f38612i.f38580d.c());
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ DownloadInfo f38613e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f38614f;

        public k(e eVar, DownloadInfo downloadInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, downloadInfo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38614f = eVar;
            this.f38613e = downloadInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.f38614f.a(this.f38613e, this.f38614f.f38579c.a());
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(479221857, "Lcom/ss/android/socialbase/downloader/b/e;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(479221857, "Lcom/ss/android/socialbase/downloader/b/e;");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public e() {
        this(false);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this(((Boolean) newInitContext.callArgs[0]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65568, this) == null) && f38577b == null) {
            synchronized (e.class) {
                if (f38577b == null) {
                    f38577b = d.l.a.e.b.b.a.a().getWritableDatabase();
                    this.f38579c = new d.l.a.e.b.b.c(f38577b, "downloader", d.l.a.e.b.d.b.f72184a, d.l.a.e.b.d.b.f72185b);
                    this.f38580d = new d.l.a.e.b.b.c(f38577b, "downloadChunk", d.l.a.e.b.d.b.f72186c, d.l.a.e.b.d.b.f72187d);
                    this.f38581e = new d.l.a.e.b.b.c(f38577b, "segments", d.l.a.e.b.d.b.f72188e, d.l.a.e.b.d.b.f72189f);
                }
            }
        }
    }

    private void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65569, this) == null) {
            f38577b.beginTransaction();
        }
    }

    private void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65570, this) == null) {
            try {
                if (f38577b == null || !f38577b.inTransaction()) {
                    return;
                }
                f38577b.endTransaction();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65571, this) == null) {
            synchronized (this) {
                i();
                f38577b.delete("downloader", null, null);
                f38577b.delete("downloadChunk", null, null);
                f38577b.setTransactionSuccessful();
                j();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public void a(int i2, List<com.ss.android.socialbase.downloader.model.b> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, list) == null) {
        }
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public List<DownloadInfo> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return null;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public List<DownloadInfo> b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, str)) == null) {
            return null;
        }
        return (List) invokeL.objValue;
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public void b(DownloadInfo downloadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, downloadInfo) == null) {
        }
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public List<DownloadInfo> c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, str)) == null) {
            return null;
        }
        return (List) invokeL.objValue;
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public List<DownloadInfo> d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, str)) == null) {
            return null;
        }
        return (List) invokeL.objValue;
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public boolean e(int i2) {
        InterceptResult invokeI;
        d.l.a.e.b.b.c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048609, this, i2)) == null) {
            h();
            if (f38577b != null && (cVar = this.f38579c) != null) {
                try {
                    a(i2, cVar.b());
                    return true;
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public boolean f(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048610, this, i2)) == null) {
            d.l.a.e.b.g.e.g0(new b(this, i2));
            return true;
        }
        return invokeI.booleanValue;
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public DownloadInfo g(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048611, this, i2)) == null) {
            return null;
        }
        return (DownloadInfo) invokeI.objValue;
    }

    @Override // d.l.a.e.b.g.k
    public Map<Long, d.l.a.e.b.i.i> l(int i2) {
        InterceptResult invokeI;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048616, this, i2)) == null) {
            h();
            if (f38577b != null) {
                try {
                    cursor = f38577b.rawQuery(String.format("SELECT * FROM %s WHERE %s = ?", "segments", "_id"), new String[]{Integer.toString(i2)});
                    try {
                        if (cursor.moveToNext()) {
                            int columnIndex = cursor.getColumnIndex("info");
                            String string = columnIndex >= 0 ? cursor.getString(columnIndex) : null;
                            HashMap hashMap = new HashMap();
                            JSONArray jSONArray = new JSONArray(string);
                            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                                d.l.a.e.b.i.i iVar = new d.l.a.e.b.i.i(jSONArray.getJSONObject(i3));
                                hashMap.put(Long.valueOf(iVar.h()), iVar);
                            }
                            d.l.a.e.b.l.f.D(cursor);
                            return hashMap;
                        }
                        d.l.a.e.b.l.f.D(cursor);
                    } catch (Throwable th) {
                        th = th;
                        try {
                            th.printStackTrace();
                            d.l.a.e.b.l.f.D(cursor);
                            return null;
                        } catch (Throwable th2) {
                            d.l.a.e.b.l.f.D(cursor);
                            throw th2;
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    cursor = null;
                }
            }
            return null;
        }
        return (Map) invokeI.objValue;
    }

    @Override // d.l.a.e.b.g.k
    public void m(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048617, this, i2) == null) {
            h();
            if (f38577b == null) {
                return;
            }
            try {
                a(i2, this.f38581e.b());
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f38578a = null;
        if (z) {
            this.f38582f = false;
            a();
        }
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public DownloadInfo b(int i2) {
        InterceptResult invokeI;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i2)) == null) {
            h();
            if (f38577b != null) {
                try {
                    cursor = f38577b.rawQuery(String.format("SELECT * FROM %s WHERE %s = ?", "downloader", "_id"), new String[]{Integer.toString(i2)});
                    try {
                        if (cursor.moveToNext()) {
                            DownloadInfo downloadInfo = new DownloadInfo(cursor);
                            d.l.a.e.b.l.f.D(cursor);
                            return downloadInfo;
                        }
                        d.l.a.e.b.l.f.D(cursor);
                    } catch (Throwable th) {
                        th = th;
                        try {
                            th.printStackTrace();
                            d.l.a.e.b.l.f.D(cursor);
                            return null;
                        } catch (Throwable th2) {
                            d.l.a.e.b.l.f.D(cursor);
                            throw th2;
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    cursor = null;
                }
            }
            return null;
        }
        return (DownloadInfo) invokeI.objValue;
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public List<com.ss.android.socialbase.downloader.model.b> c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048600, this, i2)) == null) {
            ArrayList arrayList = new ArrayList();
            h();
            if (f38577b != null) {
                Cursor cursor = null;
                try {
                    cursor = f38577b.rawQuery(String.format("SELECT * FROM %s WHERE %s = ?", "downloadChunk", "_id"), new String[]{Integer.toString(i2)});
                    while (cursor.moveToNext()) {
                        arrayList.add(new com.ss.android.socialbase.downloader.model.b(cursor));
                    }
                    d.l.a.e.b.l.f.D(cursor);
                } catch (Throwable th) {
                    try {
                        th.printStackTrace();
                        d.l.a.e.b.l.f.D(cursor);
                    } catch (Throwable th2) {
                        d.l.a.e.b.l.f.D(cursor);
                        throw th2;
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeI.objValue;
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048605, this, i2) == null) {
            h();
            if (f38577b == null || this.f38580d == null) {
                return;
            }
            d.l.a.e.b.g.e.g0(new f(this, i2));
        }
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public DownloadInfo i(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048613, this, i2)) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("status", (Integer) 1);
            a(i2, contentValues);
            return null;
        }
        return (DownloadInfo) invokeI.objValue;
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public DownloadInfo j(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048614, this, i2)) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("status", (Integer) (-7));
            a(i2, contentValues);
            return null;
        }
        return (DownloadInfo) invokeI.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void d(DownloadInfo downloadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65566, this, downloadInfo) == null) {
            synchronized (this) {
                if (downloadInfo == null) {
                    return;
                }
                try {
                    if (!a(downloadInfo.getId())) {
                        c(downloadInfo);
                    } else if (this.f38579c == null) {
                    } else {
                        b(downloadInfo, this.f38579c.c());
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public DownloadInfo e(int i2, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048607, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)})) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("status", (Integer) (-4));
            contentValues.put("curBytes", Long.valueOf(j2));
            a(i2, contentValues);
            return null;
        }
        return (DownloadInfo) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.l.a.e.b.g.k
    /* renamed from: k */
    public ArrayList<d.l.a.e.b.i.i> n(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048615, this, i2)) == null) {
            Map<Long, d.l.a.e.b.i.i> l = l(i2);
            if (l == null || l.isEmpty()) {
                return null;
            }
            return new ArrayList<>(l.values());
        }
        return (ArrayList) invokeI.objValue;
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public DownloadInfo h(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048612, this, i2)) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("status", (Integer) 5);
            contentValues.put("isFirstDownload", (Integer) 0);
            a(i2, contentValues);
            return null;
        }
        return (DownloadInfo) invokeI.objValue;
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public void b(com.ss.android.socialbase.downloader.model.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, bVar) == null) {
            a(bVar);
        }
    }

    private void b(DownloadInfo downloadInfo, SQLiteStatement sQLiteStatement) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65562, this, downloadInfo, sQLiteStatement) == null) || downloadInfo == null || sQLiteStatement == null) {
            return;
        }
        try {
            synchronized (sQLiteStatement) {
                downloadInfo.bindValue(sQLiteStatement);
                sQLiteStatement.bindLong(downloadInfo.getBindValueCount() + 1, downloadInfo.getId());
                sQLiteStatement.execute();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            a(new SparseArray<>(), new SparseArray<>(), (d.l.a.e.b.b.b) null);
        }
    }

    private void c(DownloadInfo downloadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65564, this, downloadInfo) == null) {
            h();
            if (f38577b == null || this.f38579c == null) {
                return;
            }
            d.l.a.e.b.g.e.g0(new k(this, downloadInfo));
        }
    }

    @Override // d.l.a.e.b.g.t
    public void a(SparseArray<DownloadInfo> sparseArray, SparseArray<List<com.ss.android.socialbase.downloader.model.b>> sparseArray2, d.l.a.e.b.b.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048586, this, sparseArray, sparseArray2, bVar) == null) {
            try {
                c cVar = new c(this, sparseArray, sparseArray2, bVar);
                ExecutorService G0 = d.l.a.e.b.g.e.G0();
                if (G0 != null) {
                    G0.execute(cVar);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public DownloadInfo d(int i2, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048603, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)})) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("status", (Integer) (-2));
            contentValues.put("curBytes", Long.valueOf(j2));
            a(i2, contentValues);
            return null;
        }
        return (DownloadInfo) invokeCommon.objValue;
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            h();
            if (f38577b == null) {
                return;
            }
            d.l.a.e.b.g.e.g0(new d(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<DownloadInfo> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65557, this, list) == null) || list == null) {
            return;
        }
        try {
            for (DownloadInfo downloadInfo : list) {
                if (downloadInfo != null && downloadInfo.isSavePathRedirected()) {
                    d.l.a.e.b.l.f.b0(downloadInfo);
                }
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.f38582f : invokeV.booleanValue;
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public DownloadInfo b(int i2, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048593, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)})) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("status", (Integer) (-1));
            contentValues.put("curBytes", Long.valueOf(j2));
            if (j2 > 0) {
                contentValues.put("isFirstDownload", (Integer) 0);
            }
            a(i2, contentValues);
            return null;
        }
        return (DownloadInfo) invokeCommon.objValue;
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public DownloadInfo c(int i2, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048599, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)})) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("status", (Integer) (-3));
            contentValues.put("curBytes", Long.valueOf(j2));
            contentValues.put("isFirstDownload", (Integer) 0);
            contentValues.put("isFirstSuccess", (Integer) 0);
            a(i2, contentValues);
            return null;
        }
        return (DownloadInfo) invokeCommon.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<DownloadInfo> list, List<Integer> list2, SparseArray<DownloadInfo> sparseArray, SparseArray<DownloadInfo> sparseArray2, SparseArray<List<com.ss.android.socialbase.downloader.model.b>> sparseArray3) {
        int size;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLLL(65558, this, list, list2, sparseArray, sparseArray2, sparseArray3) == null) || (size = sparseArray.size()) < 0 || f38577b == null) {
            return;
        }
        synchronized (f38577b) {
            try {
                i();
                if (!list.isEmpty()) {
                    if (d.l.a.e.b.j.a.r().l("clear_invalid_task_error")) {
                        String[] strArr = new String[list.size()];
                        for (int i2 = 0; i2 < list.size(); i2++) {
                            strArr[i2] = String.valueOf(list.get(i2));
                        }
                        String str = "CAST(_id AS TEXT) IN (" + new String(new char[list.size() - 1]).replace("\u0000", "?,") + "?)";
                        f38577b.delete("downloader", str, strArr);
                        f38577b.delete("downloadChunk", str, strArr);
                    } else {
                        String join = TextUtils.join(StringUtil.ARRAY_ELEMENT_SEPARATOR, list2);
                        f38577b.delete("downloader", "_id IN (?)", new String[]{join});
                        f38577b.delete("downloadChunk", "_id IN (?)", new String[]{join});
                    }
                }
                for (int i3 = 0; i3 < size; i3++) {
                    int keyAt = sparseArray.keyAt(i3);
                    DownloadInfo downloadInfo = sparseArray.get(keyAt);
                    f38577b.delete("downloader", "_id = ?", new String[]{String.valueOf(keyAt)});
                    f38577b.insert("downloader", null, downloadInfo.toContentValues());
                    if (downloadInfo.getChunkCount() > 1) {
                        List<com.ss.android.socialbase.downloader.model.b> c2 = c(keyAt);
                        if (c2.size() > 0) {
                            f38577b.delete("downloadChunk", "_id = ?", new String[]{String.valueOf(keyAt)});
                            for (com.ss.android.socialbase.downloader.model.b bVar : c2) {
                                bVar.b(downloadInfo.getId());
                                f38577b.insert("downloadChunk", null, bVar.a());
                            }
                        }
                    }
                }
                if (sparseArray2 != null && sparseArray3 != null) {
                    int size2 = sparseArray2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        int id = sparseArray2.valueAt(i4).getId();
                        List<com.ss.android.socialbase.downloader.model.b> r = d.l.a.e.b.l.f.r(c(id));
                        if (r != null && r.size() > 0) {
                            sparseArray3.put(id, r);
                        }
                    }
                }
                f38577b.setTransactionSuccessful();
                j();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public void b(int i2, List<com.ss.android.socialbase.downloader.model.b> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048596, this, i2, list) == null) {
            try {
                d(i2);
                if (list != null) {
                    for (com.ss.android.socialbase.downloader.model.b bVar : list) {
                        if (bVar != null) {
                            a(bVar);
                            if (bVar.f()) {
                                for (com.ss.android.socialbase.downloader.model.b bVar2 : bVar.g()) {
                                    a(bVar2);
                                }
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i2, ContentValues contentValues) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65561, this, i2, contentValues) == null) {
            int i3 = 10;
            while (f38577b.isDbLockedByCurrentThread() && i3 - 1 >= 0) {
                try {
                    Thread.sleep(5L);
                } catch (Throwable th) {
                    th.printStackTrace();
                    return;
                }
            }
            f38577b.update("downloader", contentValues, "_id = ? ", new String[]{String.valueOf(i2)});
        }
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public boolean a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i2)) == null) {
            try {
                return b(i2) != null;
            } catch (Throwable th) {
                th.printStackTrace();
                return false;
            }
        }
        return invokeI.booleanValue;
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public List<DownloadInfo> a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            h();
            ArrayList arrayList = new ArrayList();
            if (f38577b != null) {
                Cursor cursor = null;
                try {
                    cursor = f38577b.rawQuery(String.format("SELECT * FROM %s WHERE %s = ?", "downloader", "url"), new String[]{str});
                    if (cursor.moveToNext()) {
                        arrayList.add(new DownloadInfo(cursor));
                    }
                    d.l.a.e.b.l.f.D(cursor);
                } catch (Throwable th) {
                    try {
                        th.printStackTrace();
                        d.l.a.e.b.l.f.D(cursor);
                    } catch (Throwable th2) {
                        d.l.a.e.b.l.f.D(cursor);
                        throw th2;
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, SQLiteStatement sQLiteStatement) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(65543, this, i2, sQLiteStatement) == null) || sQLiteStatement == null) {
            return;
        }
        try {
            synchronized (sQLiteStatement) {
                sQLiteStatement.bindLong(1, i2);
                sQLiteStatement.execute();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public void a(com.ss.android.socialbase.downloader.model.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bVar) == null) {
            h();
            if (f38577b == null || this.f38580d == null) {
                return;
            }
            d.l.a.e.b.g.e.g0(new g(this, bVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DownloadInfo downloadInfo, SQLiteStatement sQLiteStatement) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65555, this, downloadInfo, sQLiteStatement) == null) || downloadInfo == null || sQLiteStatement == null) {
            return;
        }
        try {
            synchronized (sQLiteStatement) {
                downloadInfo.bindValue(sQLiteStatement);
                sQLiteStatement.executeInsert();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.ss.android.socialbase.downloader.model.b bVar, SQLiteStatement sQLiteStatement) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65556, this, bVar, sQLiteStatement) == null) || bVar == null || sQLiteStatement == null) {
            return;
        }
        try {
            synchronized (sQLiteStatement) {
                bVar.a(sQLiteStatement);
                sQLiteStatement.executeInsert();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public void a(int i2, int i3, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2)}) == null) {
            h();
            if (i2 == 0 || i3 < 0 || j2 < 0 || f38577b == null || this.f38580d == null) {
                return;
            }
            d.l.a.e.b.g.e.g0(new h(this, i2, i3, j2));
        }
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public void a(int i2, int i3, int i4, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Long.valueOf(j2)}) == null) {
            h();
            if (i2 == 0 || i3 < 0 || i4 < 0 || j2 < 0 || f38577b == null || this.f38580d == null) {
                return;
            }
            d.l.a.e.b.g.e.g0(new i(this, i2, i3, i4, j2));
        }
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public void a(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048581, this, i2, i3, i4, i5) == null) {
            h();
            if (i2 == 0 || i4 < 0 || i5 == i3 || i5 < 0 || f38577b == null || this.f38580d == null) {
                return;
            }
            d.l.a.e.b.g.e.g0(new j(this, i2, i3, i4, i5));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, int i3, int i4, int i5, SQLiteStatement sQLiteStatement) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), sQLiteStatement}) == null) {
            try {
                synchronized (sQLiteStatement) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("chunkIndex", Integer.valueOf(i5));
                    f38577b.update("downloadChunk", contentValues, "_id = ? AND chunkIndex = ? AND hostChunkIndex = ?", new String[]{Integer.toString(i2), Integer.toString(i3), Integer.toString(i4)});
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, int i3, long j2, SQLiteStatement sQLiteStatement) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2), sQLiteStatement}) == null) {
            try {
                synchronized (sQLiteStatement) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("curOffset", Long.valueOf(j2));
                    f38577b.update("downloadChunk", contentValues, "_id = ? AND chunkIndex = ?", new String[]{Integer.toString(i2), Integer.toString(i3)});
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, int i3, int i4, long j2, SQLiteStatement sQLiteStatement) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Long.valueOf(j2), sQLiteStatement}) == null) {
            try {
                synchronized (sQLiteStatement) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("curOffset", Long.valueOf(j2));
                    f38577b.update("downloadChunk", contentValues, "_id = ? AND chunkIndex = ? AND hostChunkIndex = ?", new String[]{Integer.toString(i2), Integer.toString(i3), Integer.toString(i4)});
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public DownloadInfo a(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048576, this, i2, i3)) == null) {
            h();
            if (f38577b == null) {
                return null;
            }
            int i4 = 10;
            while (f38577b.isDbLockedByCurrentThread() && i4 - 1 >= 0) {
                try {
                    Thread.sleep(5L);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("chunkCount", Integer.valueOf(i3));
            f38577b.update("downloader", contentValues, "_id = ? ", new String[]{Integer.toString(i2)});
            return null;
        }
        return (DownloadInfo) invokeII.objValue;
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public boolean a(DownloadInfo downloadInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, downloadInfo)) == null) {
            h();
            if (downloadInfo == null || f38577b == null) {
                return false;
            }
            d.l.a.e.b.g.e.g0(new a(this, downloadInfo));
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public DownloadInfo a(int i2, long j2, String str, String str2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2), str, str2})) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("status", (Integer) 3);
            contentValues.put("totalBytes", Long.valueOf(j2));
            contentValues.put("eTag", str);
            if (!TextUtils.isEmpty(str2)) {
                contentValues.put("name", str2);
            }
            a(i2, contentValues);
            return null;
        }
        return (DownloadInfo) invokeCommon.objValue;
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public DownloadInfo a(int i2, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)})) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("status", (Integer) 4);
            contentValues.put("curBytes", Long.valueOf(j2));
            a(i2, contentValues);
            return null;
        }
        return (DownloadInfo) invokeCommon.objValue;
    }

    @Override // d.l.a.e.b.g.k
    public boolean a(int i2, Map<Long, d.l.a.e.b.i.i> map) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048590, this, i2, map)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            h();
            if (f38577b == null) {
                return false;
            }
            JSONArray jSONArray = new JSONArray();
            try {
                for (Long l : map.keySet()) {
                    jSONArray.put(map.get(Long.valueOf(l.longValue())).r());
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            Log.d("SqlDownloadCache", "json=" + jSONArray);
            SQLiteStatement d2 = this.f38581e.d();
            synchronized (d2) {
                d2.clearBindings();
                d2.bindLong(1, i2);
                d2.bindString(2, jSONArray.toString());
                d2.execute();
            }
            d.l.a.e.b.c.a.g("SqlDownloadCache", "updateSegments cost=" + d.l.a.e.b.l.f.l0(currentTimeMillis));
            return false;
        }
        return invokeIL.booleanValue;
    }

    private void a(int i2, ContentValues contentValues) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(AdIconUtil.BAIDU_LOGO_ID, this, i2, contentValues) == null) {
            h();
            if (f38577b == null) {
                return;
            }
            d.l.a.e.b.g.e.g0(new RunnableC0492e(this, i2, contentValues));
        }
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public void a(com.ss.android.socialbase.downloader.b.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bVar) == null) {
            this.f38578a = bVar;
        }
    }

    public void a(SparseArray<DownloadInfo> sparseArray, SparseArray<List<com.ss.android.socialbase.downloader.model.b>> sparseArray2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, sparseArray, sparseArray2) == null) {
            try {
                HashMap q = d.l.a.e.b.l.f.q(sparseArray);
                HashMap q2 = d.l.a.e.b.l.f.q(sparseArray2);
                if (this.f38578a != null) {
                    this.f38578a.a(q, q2);
                }
            } catch (Throwable unused) {
            }
        }
    }
}

package com.ss.android.socialbase.downloader.b;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidubce.auth.NTLMEngineImpl;
import com.ss.android.socialbase.downloader.b.c;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import d.o.a.e.b.g.s;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import org.json.JSONArray;
/* loaded from: classes6.dex */
public class e extends c.a implements s {

    /* renamed from: b  reason: collision with root package name */
    public static volatile SQLiteDatabase f36691b;

    /* renamed from: a  reason: collision with root package name */
    public com.ss.android.socialbase.downloader.b.b f36692a;

    /* renamed from: c  reason: collision with root package name */
    public d.o.a.e.b.b.c f36693c;

    /* renamed from: d  reason: collision with root package name */
    public d.o.a.e.b.b.c f36694d;

    /* renamed from: e  reason: collision with root package name */
    public d.o.a.e.b.b.c f36695e;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f36696f;

    /* loaded from: classes6.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ DownloadInfo f36697e;

        public a(DownloadInfo downloadInfo) {
            this.f36697e = downloadInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.d(this.f36697e);
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f36699e;

        public b(int i2) {
            this.f36699e = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.e(this.f36699e);
            e.this.d(this.f36699e);
            e.this.m(this.f36699e);
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SparseArray f36701e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SparseArray f36702f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.o.a.e.b.b.b f36703g;

        public c(SparseArray sparseArray, SparseArray sparseArray2, d.o.a.e.b.b.b bVar) {
            this.f36701e = sparseArray;
            this.f36702f = sparseArray2;
            this.f36703g = bVar;
        }

        /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET]}, finally: {[IGET, IGET, INVOKE, INVOKE, IGET, INVOKE, IGET, INVOKE, IF] complete} */
        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        /* JADX DEBUG: Finally have unexpected throw blocks count: 3, expect 1 */
        /* JADX WARN: Code restructure failed: missing block: B:107:0x01c9, code lost:
            if (r0 != null) goto L71;
         */
        /* JADX WARN: Code restructure failed: missing block: B:108:0x01cb, code lost:
            r0.a();
            r20.f36704h.f36696f = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:109:0x01d3, code lost:
            r20.f36704h.a(r8, r9);
         */
        /* JADX WARN: Code restructure failed: missing block: B:145:0x0273, code lost:
            if (r0 == null) goto L72;
         */
        /* JADX WARN: Code restructure failed: missing block: B:154:0x028d, code lost:
            if (r0 == null) goto L72;
         */
        /* JADX WARN: Code restructure failed: missing block: B:156:0x0291, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:193:0x032c, code lost:
            if (r0 == null) goto L187;
         */
        /* JADX WARN: Code restructure failed: missing block: B:202:0x0345, code lost:
            if (r0 == null) goto L187;
         */
        /* JADX WARN: Code restructure failed: missing block: B:203:0x0347, code lost:
            r0.a();
            r20.f36704h.f36696f = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:204:0x034f, code lost:
            r20.f36704h.a(r8, r9);
         */
        /* JADX WARN: Code restructure failed: missing block: B:205:0x0354, code lost:
            throw r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:98:0x01b0, code lost:
            if (r0 == null) goto L72;
         */
        /* JADX WARN: Removed duplicated region for block: B:49:0x00de A[Catch: all -> 0x01da, TryCatch #9 {all -> 0x01da, blocks: (B:12:0x003b, B:13:0x0045, B:15:0x004b, B:17:0x005e, B:19:0x006d, B:20:0x0074, B:22:0x007e, B:25:0x0089, B:27:0x0091, B:38:0x00b3, B:40:0x00b9, B:41:0x00bc, B:43:0x00ce, B:46:0x00d7, B:49:0x00de, B:50:0x00ed, B:52:0x00f3, B:55:0x0103, B:57:0x010b, B:30:0x009d, B:32:0x00a3, B:34:0x00a9, B:36:0x00af, B:58:0x010c, B:59:0x0113), top: B:216:0x003b }] */
        /* JADX WARN: Removed duplicated region for block: B:50:0x00ed A[Catch: all -> 0x01da, TryCatch #9 {all -> 0x01da, blocks: (B:12:0x003b, B:13:0x0045, B:15:0x004b, B:17:0x005e, B:19:0x006d, B:20:0x0074, B:22:0x007e, B:25:0x0089, B:27:0x0091, B:38:0x00b3, B:40:0x00b9, B:41:0x00bc, B:43:0x00ce, B:46:0x00d7, B:49:0x00de, B:50:0x00ed, B:52:0x00f3, B:55:0x0103, B:57:0x010b, B:30:0x009d, B:32:0x00a3, B:34:0x00a9, B:36:0x00af, B:58:0x010c, B:59:0x0113), top: B:216:0x003b }] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            d.o.a.e.b.b.b bVar;
            d.o.a.e.b.b.b bVar2;
            boolean z;
            e.this.g();
            if (e.f36691b == null) {
                return;
            }
            SparseArray<DownloadInfo> sparseArray = this.f36701e;
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
            }
            SparseArray<DownloadInfo> sparseArray2 = sparseArray;
            SparseArray<List<com.ss.android.socialbase.downloader.model.b>> sparseArray3 = this.f36702f;
            if (sparseArray3 == null) {
                sparseArray3 = new SparseArray<>();
            }
            SparseArray<List<com.ss.android.socialbase.downloader.model.b>> sparseArray4 = sparseArray3;
            d.o.a.e.b.g.k b2 = d.o.a.e.b.g.d.b();
            SparseArray sparseArray5 = new SparseArray();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            Cursor cursor = null;
            int i2 = -3;
            int i3 = 0;
            try {
                cursor = e.f36691b.rawQuery("SELECT * FROM downloader", null);
                while (cursor.moveToNext()) {
                    DownloadInfo downloadInfo = new DownloadInfo(cursor);
                    downloadInfo.b3(downloadInfo.z0());
                    if (downloadInfo.g1()) {
                        downloadInfo.a3(-5);
                        if (d.o.a.e.b.j.a.r().q("status_not_update_to_db", true)) {
                            sparseArray5.put(downloadInfo.c0(), downloadInfo);
                        }
                    }
                    if (!TextUtils.isEmpty(downloadInfo.F0()) && !TextUtils.isEmpty(downloadInfo.q0())) {
                        if (downloadInfo.H0() != 1 || downloadInfo.E() > 0) {
                            if (downloadInfo.H0() != i2 && downloadInfo.H0() != 11 && !downloadInfo.r1()) {
                                downloadInfo.Z1();
                            }
                            z = false;
                        } else {
                            z = true;
                        }
                        if (downloadInfo.H0() == 11) {
                            downloadInfo.a3(-5);
                        }
                        if (d.o.a.e.b.l.e.G(downloadInfo.H0(), downloadInfo.F0(), downloadInfo.q0())) {
                            if (!d.o.a.e.b.l.a.a(NTLMEngineImpl.FLAG_REQUEST_VERSION)) {
                                downloadInfo.q();
                            }
                        }
                        if (!z) {
                            arrayList.add(Integer.valueOf(downloadInfo.c0()));
                            arrayList2.add(downloadInfo);
                        } else {
                            int c0 = downloadInfo.c0();
                            int a2 = b2 != null ? b2.a(downloadInfo.T0(), downloadInfo.F0()) : 0;
                            if (a2 != c0) {
                                downloadInfo.D2(a2);
                                sparseArray5.put(c0, downloadInfo);
                            }
                            if (sparseArray2 != null) {
                                synchronized (sparseArray2) {
                                    sparseArray2.put(downloadInfo.c0(), downloadInfo);
                                }
                            }
                        }
                        i2 = -3;
                    }
                    z = true;
                    if (!z) {
                    }
                    i2 = -3;
                }
                d.o.a.e.b.l.e.C(cursor);
                e.this.a(arrayList2);
                e.this.a(arrayList2, arrayList, sparseArray5, sparseArray2, sparseArray4);
                if (sparseArray2 != null) {
                    try {
                        synchronized (sparseArray2) {
                            ArrayList<Integer> arrayList3 = new ArrayList();
                            while (i3 < sparseArray2.size()) {
                                int keyAt = sparseArray2.keyAt(i3);
                                if (keyAt != 0) {
                                    DownloadInfo downloadInfo2 = sparseArray2.get(keyAt);
                                    if (d.o.a.e.b.l.a.a(8192)) {
                                        if (downloadInfo2 != null && !downloadInfo2.h1() && downloadInfo2.H0() != -3) {
                                            arrayList3.add(Integer.valueOf(downloadInfo2.c0()));
                                            sparseArray4.remove(downloadInfo2.c0());
                                        }
                                    } else if (downloadInfo2 != null && !downloadInfo2.h1()) {
                                        arrayList3.add(Integer.valueOf(downloadInfo2.c0()));
                                        sparseArray4.remove(downloadInfo2.c0());
                                    }
                                }
                                i3++;
                            }
                            for (Integer num : arrayList3) {
                                sparseArray2.remove(num.intValue());
                            }
                        }
                    } catch (Throwable th) {
                        try {
                            th.printStackTrace();
                            bVar2 = this.f36703g;
                        } finally {
                        }
                    }
                }
                bVar2 = this.f36703g;
            } catch (Throwable th2) {
                try {
                    th2.printStackTrace();
                    d.o.a.e.b.l.e.C(cursor);
                    e.this.a(arrayList2);
                    e.this.a(arrayList2, arrayList, sparseArray5, sparseArray2, sparseArray4);
                    if (sparseArray2 != null) {
                        try {
                            synchronized (sparseArray2) {
                                ArrayList<Integer> arrayList4 = new ArrayList();
                                while (i3 < sparseArray2.size()) {
                                    int keyAt2 = sparseArray2.keyAt(i3);
                                    if (keyAt2 != 0) {
                                        DownloadInfo downloadInfo3 = sparseArray2.get(keyAt2);
                                        if (d.o.a.e.b.l.a.a(8192)) {
                                            if (downloadInfo3 != null && !downloadInfo3.h1() && downloadInfo3.H0() != -3) {
                                                arrayList4.add(Integer.valueOf(downloadInfo3.c0()));
                                                sparseArray4.remove(downloadInfo3.c0());
                                            }
                                        } else if (downloadInfo3 != null && !downloadInfo3.h1()) {
                                            arrayList4.add(Integer.valueOf(downloadInfo3.c0()));
                                            sparseArray4.remove(downloadInfo3.c0());
                                        }
                                    }
                                    i3++;
                                }
                                for (Integer num2 : arrayList4) {
                                    sparseArray2.remove(num2.intValue());
                                }
                            }
                        } catch (Throwable th3) {
                            try {
                                th3.printStackTrace();
                                bVar2 = this.f36703g;
                            } finally {
                            }
                        }
                    }
                    bVar2 = this.f36703g;
                } catch (Throwable th4) {
                    d.o.a.e.b.l.e.C(cursor);
                    e.this.a(arrayList2);
                    e.this.a(arrayList2, arrayList, sparseArray5, sparseArray2, sparseArray4);
                    if (sparseArray2 != null) {
                        try {
                            synchronized (sparseArray2) {
                                ArrayList<Integer> arrayList5 = new ArrayList();
                                while (i3 < sparseArray2.size()) {
                                    int keyAt3 = sparseArray2.keyAt(i3);
                                    if (keyAt3 != 0) {
                                        DownloadInfo downloadInfo4 = sparseArray2.get(keyAt3);
                                        if (d.o.a.e.b.l.a.a(8192)) {
                                            if (downloadInfo4 != null && !downloadInfo4.h1()) {
                                                if (downloadInfo4.H0() != -3) {
                                                    arrayList5.add(Integer.valueOf(downloadInfo4.c0()));
                                                    sparseArray4.remove(downloadInfo4.c0());
                                                }
                                            }
                                        } else if (downloadInfo4 != null && !downloadInfo4.h1()) {
                                            arrayList5.add(Integer.valueOf(downloadInfo4.c0()));
                                            sparseArray4.remove(downloadInfo4.c0());
                                        }
                                        i3++;
                                    }
                                    i3++;
                                }
                                for (Integer num3 : arrayList5) {
                                    sparseArray2.remove(num3.intValue());
                                }
                            }
                        } catch (Throwable th5) {
                            try {
                                th5.printStackTrace();
                                bVar = this.f36703g;
                            } finally {
                                d.o.a.e.b.b.b bVar3 = this.f36703g;
                                if (bVar3 != null) {
                                    bVar3.a();
                                    e.this.f36696f = true;
                                }
                                e.this.a(sparseArray2, sparseArray4);
                            }
                        }
                    }
                    bVar = this.f36703g;
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.j();
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.b.e$e  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class RunnableC0443e implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f36706e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ContentValues f36707f;

        public RunnableC0443e(int i2, ContentValues contentValues) {
            this.f36706e = i2;
            this.f36707f = contentValues;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.b(this.f36706e, this.f36707f);
        }
    }

    /* loaded from: classes6.dex */
    public class f implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f36709e;

        public f(int i2) {
            this.f36709e = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                e.this.a(this.f36709e, e.this.f36694d.b());
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ com.ss.android.socialbase.downloader.model.b f36711e;

        public g(com.ss.android.socialbase.downloader.model.b bVar) {
            this.f36711e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                e.this.a(this.f36711e, e.this.f36694d.a());
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f36713e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f36714f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ long f36715g;

        public h(int i2, int i3, long j) {
            this.f36713e = i2;
            this.f36714f = i3;
            this.f36715g = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                e.this.a(this.f36713e, this.f36714f, this.f36715g, e.this.f36694d.c());
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f36717e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f36718f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f36719g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ long f36720h;

        public i(int i2, int i3, int i4, long j) {
            this.f36717e = i2;
            this.f36718f = i3;
            this.f36719g = i4;
            this.f36720h = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                e.this.a(this.f36717e, this.f36718f, this.f36719g, this.f36720h, e.this.f36694d.c());
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f36722e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f36723f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f36724g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f36725h;

        public j(int i2, int i3, int i4, int i5) {
            this.f36722e = i2;
            this.f36723f = i3;
            this.f36724g = i4;
            this.f36725h = i5;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                e.this.a(this.f36722e, this.f36723f, this.f36724g, this.f36725h, e.this.f36694d.c());
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class k implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ DownloadInfo f36727e;

        public k(DownloadInfo downloadInfo) {
            this.f36727e = downloadInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                e.this.a(this.f36727e, e.this.f36693c.a());
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public e() {
        this(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        if (f36691b == null) {
            synchronized (e.class) {
                if (f36691b == null) {
                    f36691b = d.o.a.e.b.b.a.a().getWritableDatabase();
                    this.f36693c = new d.o.a.e.b.b.c(f36691b, "downloader", d.o.a.e.b.d.b.f66443a, d.o.a.e.b.d.b.f66444b);
                    this.f36694d = new d.o.a.e.b.b.c(f36691b, "downloadChunk", d.o.a.e.b.d.b.f66445c, d.o.a.e.b.d.b.f66446d);
                    this.f36695e = new d.o.a.e.b.b.c(f36691b, "segments", d.o.a.e.b.d.b.f66447e, d.o.a.e.b.d.b.f66448f);
                }
            }
        }
    }

    private void h() {
        f36691b.beginTransaction();
    }

    private void i() {
        try {
            if (f36691b == null || !f36691b.inTransaction()) {
                return;
            }
            f36691b.endTransaction();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void j() {
        h();
        f36691b.delete("downloader", null, null);
        f36691b.delete("downloadChunk", null, null);
        f36691b.setTransactionSuccessful();
        i();
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public void a(int i2, List<com.ss.android.socialbase.downloader.model.b> list) {
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public List<DownloadInfo> b(String str) {
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public void b(DownloadInfo downloadInfo) {
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public List<DownloadInfo> c(String str) {
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public List<DownloadInfo> d(String str) {
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public boolean d() {
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public boolean e(int i2) {
        d.o.a.e.b.b.c cVar;
        g();
        if (f36691b != null && (cVar = this.f36693c) != null) {
            try {
                a(i2, cVar.b());
                return true;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public DownloadInfo g(int i2) {
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.o.a.e.b.g.j
    /* renamed from: k */
    public ArrayList<d.o.a.e.b.i.i> n(int i2) {
        Map<Long, d.o.a.e.b.i.i> l = l(i2);
        if (l == null || l.isEmpty()) {
            return null;
        }
        return new ArrayList<>(l.values());
    }

    @Override // d.o.a.e.b.g.j
    public Map<Long, d.o.a.e.b.i.i> l(int i2) {
        Cursor cursor;
        g();
        if (f36691b != null) {
            try {
                cursor = f36691b.rawQuery(String.format("SELECT * FROM %s WHERE %s = ?", "segments", "_id"), new String[]{Integer.toString(i2)});
                try {
                    if (cursor.moveToNext()) {
                        int columnIndex = cursor.getColumnIndex("info");
                        String string = columnIndex >= 0 ? cursor.getString(columnIndex) : null;
                        HashMap hashMap = new HashMap();
                        JSONArray jSONArray = new JSONArray(string);
                        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                            d.o.a.e.b.i.i iVar = new d.o.a.e.b.i.i(jSONArray.getJSONObject(i3));
                            hashMap.put(Long.valueOf(iVar.g()), iVar);
                        }
                        d.o.a.e.b.l.e.C(cursor);
                        return hashMap;
                    }
                    d.o.a.e.b.l.e.C(cursor);
                } catch (Throwable th) {
                    th = th;
                    try {
                        th.printStackTrace();
                        d.o.a.e.b.l.e.C(cursor);
                        return null;
                    } catch (Throwable th2) {
                        d.o.a.e.b.l.e.C(cursor);
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

    @Override // d.o.a.e.b.g.j
    public void m(int i2) {
        g();
        if (f36691b == null) {
            return;
        }
        try {
            a(i2, this.f36695e.b());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public e(boolean z) {
        this.f36692a = null;
        if (z) {
            this.f36696f = false;
            a();
        }
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public DownloadInfo b(int i2) {
        Cursor cursor;
        g();
        if (f36691b != null) {
            try {
                cursor = f36691b.rawQuery(String.format("SELECT * FROM %s WHERE %s = ?", "downloader", "_id"), new String[]{Integer.toString(i2)});
                try {
                    if (cursor.moveToNext()) {
                        DownloadInfo downloadInfo = new DownloadInfo(cursor);
                        d.o.a.e.b.l.e.C(cursor);
                        return downloadInfo;
                    }
                    d.o.a.e.b.l.e.C(cursor);
                } catch (Throwable th) {
                    th = th;
                    try {
                        th.printStackTrace();
                        d.o.a.e.b.l.e.C(cursor);
                        return null;
                    } catch (Throwable th2) {
                        d.o.a.e.b.l.e.C(cursor);
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

    @Override // com.ss.android.socialbase.downloader.b.c
    public List<com.ss.android.socialbase.downloader.model.b> c(int i2) {
        ArrayList arrayList = new ArrayList();
        g();
        if (f36691b != null) {
            Cursor cursor = null;
            try {
                cursor = f36691b.rawQuery(String.format("SELECT * FROM %s WHERE %s = ?", "downloadChunk", "_id"), new String[]{Integer.toString(i2)});
                while (cursor.moveToNext()) {
                    arrayList.add(new com.ss.android.socialbase.downloader.model.b(cursor));
                }
                d.o.a.e.b.l.e.C(cursor);
            } catch (Throwable th) {
                try {
                    th.printStackTrace();
                    d.o.a.e.b.l.e.C(cursor);
                } catch (Throwable th2) {
                    d.o.a.e.b.l.e.C(cursor);
                    throw th2;
                }
            }
        }
        return arrayList;
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public void d(int i2) {
        g();
        if (f36691b == null || this.f36694d == null) {
            return;
        }
        d.o.a.e.b.g.d.c0(new f(i2));
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public boolean f(int i2) {
        d.o.a.e.b.g.d.c0(new b(i2));
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public DownloadInfo h(int i2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) 5);
        contentValues.put("isFirstDownload", (Integer) 0);
        a(i2, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public DownloadInfo i(int i2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) 1);
        a(i2, contentValues);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void d(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return;
        }
        try {
            if (!a(downloadInfo.c0())) {
                c(downloadInfo);
            } else if (this.f36693c == null) {
            } else {
                b(downloadInfo, this.f36693c.c());
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public DownloadInfo e(int i2, long j2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) (-4));
        contentValues.put("curBytes", Long.valueOf(j2));
        a(i2, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public DownloadInfo j(int i2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) (-7));
        a(i2, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public void b(com.ss.android.socialbase.downloader.model.b bVar) {
        a(bVar);
    }

    private void b(DownloadInfo downloadInfo, SQLiteStatement sQLiteStatement) {
        if (downloadInfo == null || sQLiteStatement == null) {
            return;
        }
        try {
            synchronized (sQLiteStatement) {
                downloadInfo.a(sQLiteStatement);
                sQLiteStatement.bindLong(downloadInfo.y() + 1, downloadInfo.c0());
                sQLiteStatement.execute();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public void a() {
        a((SparseArray<DownloadInfo>) null, (SparseArray<List<com.ss.android.socialbase.downloader.model.b>>) null, (d.o.a.e.b.b.b) null);
    }

    private void c(DownloadInfo downloadInfo) {
        g();
        if (f36691b == null || this.f36693c == null) {
            return;
        }
        d.o.a.e.b.g.d.c0(new k(downloadInfo));
    }

    @Override // d.o.a.e.b.g.s
    public void a(SparseArray<DownloadInfo> sparseArray, SparseArray<List<com.ss.android.socialbase.downloader.model.b>> sparseArray2, d.o.a.e.b.b.b bVar) {
        try {
            c cVar = new c(sparseArray, sparseArray2, bVar);
            ExecutorService C0 = d.o.a.e.b.g.d.C0();
            if (C0 != null) {
                C0.execute(cVar);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public DownloadInfo d(int i2, long j2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) (-2));
        contentValues.put("curBytes", Long.valueOf(j2));
        a(i2, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public DownloadInfo c(int i2, long j2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) (-3));
        contentValues.put("curBytes", Long.valueOf(j2));
        contentValues.put("isFirstDownload", (Integer) 0);
        contentValues.put("isFirstSuccess", (Integer) 0);
        a(i2, contentValues);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<DownloadInfo> list) {
        if (list == null) {
            return;
        }
        try {
            for (DownloadInfo downloadInfo : list) {
                if (downloadInfo != null && downloadInfo.O1()) {
                    d.o.a.e.b.l.e.Z(downloadInfo);
                }
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public void b() {
        g();
        if (f36691b == null) {
            return;
        }
        d.o.a.e.b.g.d.c0(new d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<DownloadInfo> list, List<Integer> list2, SparseArray<DownloadInfo> sparseArray, SparseArray<DownloadInfo> sparseArray2, SparseArray<List<com.ss.android.socialbase.downloader.model.b>> sparseArray3) {
        int size = sparseArray.size();
        if (size < 0 || f36691b == null) {
            return;
        }
        synchronized (f36691b) {
            try {
                h();
                if (!list.isEmpty()) {
                    if (d.o.a.e.b.j.a.r().l("clear_invalid_task_error")) {
                        String[] strArr = new String[list.size()];
                        for (int i2 = 0; i2 < list.size(); i2++) {
                            strArr[i2] = String.valueOf(list.get(i2));
                        }
                        String str = "CAST(_id AS TEXT) IN (" + new String(new char[list.size() - 1]).replace("\u0000", "?,") + "?)";
                        f36691b.delete("downloader", str, strArr);
                        f36691b.delete("downloadChunk", str, strArr);
                    } else {
                        String join = TextUtils.join(StringUtil.ARRAY_ELEMENT_SEPARATOR, list2);
                        f36691b.delete("downloader", "_id IN (?)", new String[]{join});
                        f36691b.delete("downloadChunk", "_id IN (?)", new String[]{join});
                    }
                }
                for (int i3 = 0; i3 < size; i3++) {
                    int keyAt = sparseArray.keyAt(i3);
                    DownloadInfo downloadInfo = sparseArray.get(keyAt);
                    f36691b.delete("downloader", "_id = ?", new String[]{String.valueOf(keyAt)});
                    f36691b.insert("downloader", null, downloadInfo.m3());
                    if (downloadInfo.B() > 1) {
                        List<com.ss.android.socialbase.downloader.model.b> c2 = c(keyAt);
                        if (c2.size() > 0) {
                            f36691b.delete("downloadChunk", "_id = ?", new String[]{String.valueOf(keyAt)});
                            for (com.ss.android.socialbase.downloader.model.b bVar : c2) {
                                bVar.k(downloadInfo.c0());
                                f36691b.insert("downloadChunk", null, bVar.a());
                            }
                        }
                    }
                }
                if (sparseArray2 != null && sparseArray3 != null) {
                    synchronized (sparseArray2) {
                        int size2 = sparseArray2.size();
                        for (int i4 = 0; i4 < size2; i4++) {
                            int c0 = sparseArray2.valueAt(i4).c0();
                            List<com.ss.android.socialbase.downloader.model.b> p = d.o.a.e.b.l.e.p(c(c0));
                            if (p != null && p.size() > 0) {
                                sparseArray3.put(c0, p);
                            }
                        }
                    }
                }
                f36691b.setTransactionSuccessful();
                i();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public DownloadInfo b(int i2, long j2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) (-1));
        contentValues.put("curBytes", Long.valueOf(j2));
        if (j2 > 0) {
            contentValues.put("isFirstDownload", (Integer) 0);
        }
        a(i2, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public boolean c() {
        return this.f36696f;
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public void b(int i2, List<com.ss.android.socialbase.downloader.model.b> list) {
        try {
            d(i2);
            if (list != null) {
                for (com.ss.android.socialbase.downloader.model.b bVar : list) {
                    if (bVar != null) {
                        a(bVar);
                        if (bVar.s()) {
                            for (com.ss.android.socialbase.downloader.model.b bVar2 : bVar.t()) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i2, ContentValues contentValues) {
        int i3 = 10;
        while (f36691b.isDbLockedByCurrentThread() && i3 - 1 >= 0) {
            try {
                Thread.sleep(5L);
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        }
        f36691b.update("downloader", contentValues, "_id = ? ", new String[]{String.valueOf(i2)});
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public boolean a(int i2) {
        try {
            return b(i2) != null;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public List<DownloadInfo> a(String str) {
        g();
        ArrayList arrayList = new ArrayList();
        if (f36691b != null) {
            Cursor cursor = null;
            try {
                cursor = f36691b.rawQuery(String.format("SELECT * FROM %s WHERE %s = ?", "downloader", "url"), new String[]{str});
                if (cursor.moveToNext()) {
                    arrayList.add(new DownloadInfo(cursor));
                }
                d.o.a.e.b.l.e.C(cursor);
            } catch (Throwable th) {
                try {
                    th.printStackTrace();
                    d.o.a.e.b.l.e.C(cursor);
                } catch (Throwable th2) {
                    d.o.a.e.b.l.e.C(cursor);
                    throw th2;
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, SQLiteStatement sQLiteStatement) {
        if (sQLiteStatement == null) {
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
        g();
        if (f36691b == null || this.f36694d == null) {
            return;
        }
        d.o.a.e.b.g.d.c0(new g(bVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DownloadInfo downloadInfo, SQLiteStatement sQLiteStatement) {
        if (downloadInfo == null || sQLiteStatement == null) {
            return;
        }
        try {
            synchronized (sQLiteStatement) {
                downloadInfo.a(sQLiteStatement);
                sQLiteStatement.executeInsert();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.ss.android.socialbase.downloader.model.b bVar, SQLiteStatement sQLiteStatement) {
        if (bVar == null || sQLiteStatement == null) {
            return;
        }
        try {
            synchronized (sQLiteStatement) {
                bVar.e(sQLiteStatement);
                sQLiteStatement.executeInsert();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public void a(int i2, int i3, long j2) {
        g();
        if (i2 == 0 || i3 < 0 || j2 < 0 || f36691b == null || this.f36694d == null) {
            return;
        }
        d.o.a.e.b.g.d.c0(new h(i2, i3, j2));
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public void a(int i2, int i3, int i4, long j2) {
        g();
        if (i2 == 0 || i3 < 0 || i4 < 0 || j2 < 0 || f36691b == null || this.f36694d == null) {
            return;
        }
        d.o.a.e.b.g.d.c0(new i(i2, i3, i4, j2));
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public void a(int i2, int i3, int i4, int i5) {
        g();
        if (i2 == 0 || i4 < 0 || i5 == i3 || i5 < 0 || f36691b == null || this.f36694d == null) {
            return;
        }
        d.o.a.e.b.g.d.c0(new j(i2, i3, i4, i5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, int i3, int i4, int i5, SQLiteStatement sQLiteStatement) {
        try {
            synchronized (sQLiteStatement) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("chunkIndex", Integer.valueOf(i5));
                f36691b.update("downloadChunk", contentValues, "_id = ? AND chunkIndex = ? AND hostChunkIndex = ?", new String[]{Integer.toString(i2), Integer.toString(i3), Integer.toString(i4)});
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, int i3, long j2, SQLiteStatement sQLiteStatement) {
        try {
            synchronized (sQLiteStatement) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("curOffset", Long.valueOf(j2));
                f36691b.update("downloadChunk", contentValues, "_id = ? AND chunkIndex = ?", new String[]{Integer.toString(i2), Integer.toString(i3)});
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, int i3, int i4, long j2, SQLiteStatement sQLiteStatement) {
        try {
            synchronized (sQLiteStatement) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("curOffset", Long.valueOf(j2));
                f36691b.update("downloadChunk", contentValues, "_id = ? AND chunkIndex = ? AND hostChunkIndex = ?", new String[]{Integer.toString(i2), Integer.toString(i3), Integer.toString(i4)});
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public DownloadInfo a(int i2, int i3) {
        g();
        if (f36691b == null) {
            return null;
        }
        int i4 = 10;
        while (f36691b.isDbLockedByCurrentThread() && i4 - 1 >= 0) {
            try {
                Thread.sleep(5L);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("chunkCount", Integer.valueOf(i3));
        f36691b.update("downloader", contentValues, "_id = ? ", new String[]{Integer.toString(i2)});
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public boolean a(DownloadInfo downloadInfo) {
        g();
        if (downloadInfo == null || f36691b == null) {
            return false;
        }
        d.o.a.e.b.g.d.c0(new a(downloadInfo));
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public DownloadInfo a(int i2, long j2, String str, String str2) {
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

    @Override // com.ss.android.socialbase.downloader.b.c
    public DownloadInfo a(int i2, long j2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) 4);
        contentValues.put("curBytes", Long.valueOf(j2));
        a(i2, contentValues);
        return null;
    }

    @Override // d.o.a.e.b.g.j
    public boolean a(int i2, Map<Long, d.o.a.e.b.i.i> map) {
        long currentTimeMillis = System.currentTimeMillis();
        g();
        if (f36691b == null) {
            return false;
        }
        JSONArray jSONArray = new JSONArray();
        try {
            for (Long l : map.keySet()) {
                jSONArray.put(map.get(Long.valueOf(l.longValue())).q());
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        Log.d("SqlDownloadCache", "json=" + jSONArray);
        SQLiteStatement d2 = this.f36695e.d();
        synchronized (d2) {
            d2.clearBindings();
            d2.bindLong(1, i2);
            d2.bindString(2, jSONArray.toString());
            d2.execute();
        }
        d.o.a.e.b.c.a.g("SqlDownloadCache", "updateSegments cost=" + d.o.a.e.b.l.e.j0(currentTimeMillis));
        return false;
    }

    private void a(int i2, ContentValues contentValues) {
        g();
        if (f36691b == null) {
            return;
        }
        d.o.a.e.b.g.d.c0(new RunnableC0443e(i2, contentValues));
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public void a(com.ss.android.socialbase.downloader.b.b bVar) {
        this.f36692a = bVar;
    }

    public void a(SparseArray<DownloadInfo> sparseArray, SparseArray<List<com.ss.android.socialbase.downloader.model.b>> sparseArray2) {
        try {
            HashMap o = d.o.a.e.b.l.e.o(sparseArray);
            HashMap o2 = d.o.a.e.b.l.e.o(sparseArray2);
            if (this.f36692a != null) {
                this.f36692a.a(o, o2);
            }
        } catch (Throwable unused) {
        }
    }
}

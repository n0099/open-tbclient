package com.ss.android.socialbase.downloader.b;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.baidu.android.common.others.lang.StringUtil;
import com.ss.android.socialbase.downloader.b.c;
import com.ss.android.socialbase.downloader.downloader.k;
import com.ss.android.socialbase.downloader.downloader.t;
import com.ss.android.socialbase.downloader.f.i;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import org.json.JSONArray;
/* loaded from: classes10.dex */
public class e extends c.a implements t {
    public static volatile SQLiteDatabase b;
    public b a;
    public g c;
    public g d;
    public g e;
    public volatile boolean f;

    @Override // com.ss.android.socialbase.downloader.b.c
    public void a(int i, List<com.ss.android.socialbase.downloader.model.b> list) {
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public List<DownloadInfo> b() {
        return null;
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
    public boolean e() {
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public DownloadInfo g(int i) {
        return null;
    }

    public e() {
        this(false);
    }

    private void i() {
        b.beginTransaction();
    }

    private void j() {
        try {
            if (b != null && b.inTransaction()) {
                b.endTransaction();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void k() {
        i();
        b.delete("downloader", null, null);
        b.delete("downloadChunk", null, null);
        b.setTransactionSuccessful();
        j();
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public void a() {
        a(new SparseArray<>(), new SparseArray<>(), (d) null);
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public void c() {
        h();
        if (b == null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.c.b(new Runnable() { // from class: com.ss.android.socialbase.downloader.b.e.2
            @Override // java.lang.Runnable
            public void run() {
                e.this.k();
            }
        });
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public boolean d() {
        return this.f;
    }

    public e(boolean z) {
        this.a = null;
        if (!z) {
            return;
        }
        this.f = false;
        a();
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public boolean e(int i) {
        g gVar;
        h();
        if (b != null && (gVar = this.c) != null) {
            try {
                a(i, gVar.b());
                return true;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public boolean f(final int i) {
        com.ss.android.socialbase.downloader.downloader.c.b(new Runnable() { // from class: com.ss.android.socialbase.downloader.b.e.11
            @Override // java.lang.Runnable
            public void run() {
                e.this.e(i);
                e.this.d(i);
                e.this.m(i);
            }
        });
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public DownloadInfo h(int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) 5);
        contentValues.put("isFirstDownload", (Integer) 0);
        update(i, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public DownloadInfo i(int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) 1);
        update(i, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public DownloadInfo j(int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) (-7));
        update(i, contentValues);
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.ss.android.socialbase.downloader.downloader.j
    /* renamed from: k */
    public ArrayList<i> n(int i) {
        Map<Long, i> l = l(i);
        if (l != null && !l.isEmpty()) {
            return new ArrayList<>(l.values());
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void m(int i) {
        h();
        if (b == null) {
            return;
        }
        try {
            a(i, this.e.b());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2, int i3, int i4, SQLiteStatement sQLiteStatement) {
        try {
            synchronized (sQLiteStatement) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("chunkIndex", Integer.valueOf(i4));
                b.update("downloadChunk", contentValues, "_id = ? AND chunkIndex = ? AND hostChunkIndex = ?", new String[]{Integer.toString(i), Integer.toString(i2), Integer.toString(i3)});
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2, int i3, long j, SQLiteStatement sQLiteStatement) {
        try {
            synchronized (sQLiteStatement) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("curOffset", Long.valueOf(j));
                b.update("downloadChunk", contentValues, "_id = ? AND chunkIndex = ? AND hostChunkIndex = ?", new String[]{Integer.toString(i), Integer.toString(i2), Integer.toString(i3)});
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2, long j, SQLiteStatement sQLiteStatement) {
        try {
            synchronized (sQLiteStatement) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("curOffset", Long.valueOf(j));
                b.update("downloadChunk", contentValues, "_id = ? AND chunkIndex = ?", new String[]{Integer.toString(i), Integer.toString(i2)});
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ContentValues contentValues) {
        int i2 = 10;
        while (b.isDbLockedByCurrentThread() && i2 - 1 >= 0) {
            try {
                Thread.sleep(5L);
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        }
        b.update("downloader", contentValues, "_id = ? ", new String[]{String.valueOf(i)});
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public void b(int i, List<com.ss.android.socialbase.downloader.model.b> list) {
        try {
            d(i);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, SQLiteStatement sQLiteStatement) {
        if (sQLiteStatement == null) {
            return;
        }
        try {
            synchronized (sQLiteStatement) {
                sQLiteStatement.bindLong(1, i);
                sQLiteStatement.execute();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void b(DownloadInfo downloadInfo, SQLiteStatement sQLiteStatement) {
        if (downloadInfo != null && sQLiteStatement != null) {
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
    }

    private void update(final int i, final ContentValues contentValues) {
        h();
        if (b == null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.c.b(new Runnable() { // from class: com.ss.android.socialbase.downloader.b.e.3
            @Override // java.lang.Runnable
            public void run() {
                e.this.a(i, contentValues);
            }
        });
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public DownloadInfo c(int i, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) (-3));
        contentValues.put("curBytes", Long.valueOf(j));
        contentValues.put("isFirstDownload", (Integer) 0);
        contentValues.put("isFirstSuccess", (Integer) 0);
        update(i, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public DownloadInfo d(int i, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) (-2));
        contentValues.put("curBytes", Long.valueOf(j));
        update(i, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public DownloadInfo e(int i, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) (-4));
        contentValues.put("curBytes", Long.valueOf(j));
        update(i, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public DownloadInfo b(int i, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) (-1));
        contentValues.put("curBytes", Long.valueOf(j));
        if (j > 0) {
            contentValues.put("isFirstDownload", (Integer) 0);
        }
        update(i, contentValues);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DownloadInfo downloadInfo, SQLiteStatement sQLiteStatement) {
        if (downloadInfo != null && sQLiteStatement != null) {
            try {
                synchronized (sQLiteStatement) {
                    downloadInfo.bindValue(sQLiteStatement);
                    sQLiteStatement.executeInsert();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.ss.android.socialbase.downloader.model.b bVar, SQLiteStatement sQLiteStatement) {
        if (bVar != null && sQLiteStatement != null) {
            try {
                synchronized (sQLiteStatement) {
                    bVar.a(sQLiteStatement);
                    sQLiteStatement.executeInsert();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<DownloadInfo> list) {
        if (list == null) {
            return;
        }
        try {
            for (DownloadInfo downloadInfo : list) {
                if (downloadInfo != null && downloadInfo.isSavePathRedirected()) {
                    com.ss.android.socialbase.downloader.i.f.b(downloadInfo);
                }
            }
        } catch (Throwable unused) {
        }
    }

    private void c(final DownloadInfo downloadInfo) {
        h();
        if (b != null && this.c != null) {
            com.ss.android.socialbase.downloader.downloader.c.b(new Runnable() { // from class: com.ss.android.socialbase.downloader.b.e.9
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        e.this.a(downloadInfo, e.this.c.a());
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void d(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return;
        }
        try {
            if (!a(downloadInfo.getId())) {
                c(downloadInfo);
            } else if (this.c == null) {
            } else {
                b(downloadInfo, this.c.c());
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public void b(com.ss.android.socialbase.downloader.model.b bVar) {
        a(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<DownloadInfo> list, List<Integer> list2, SparseArray<DownloadInfo> sparseArray, SparseArray<DownloadInfo> sparseArray2, SparseArray<List<com.ss.android.socialbase.downloader.model.b>> sparseArray3) {
        int size = sparseArray.size();
        if (size >= 0 && b != null) {
            synchronized (b) {
                try {
                    i();
                    if (!list.isEmpty()) {
                        if (com.ss.android.socialbase.downloader.g.a.c().a("clear_invalid_task_error")) {
                            String[] strArr = new String[list.size()];
                            for (int i = 0; i < list.size(); i++) {
                                strArr[i] = String.valueOf(list.get(i));
                            }
                            String str = "CAST(_id AS TEXT) IN (" + new String(new char[list.size() - 1]).replace("\u0000", "?,") + "?)";
                            b.delete("downloader", str, strArr);
                            b.delete("downloadChunk", str, strArr);
                        } else {
                            String join = TextUtils.join(StringUtil.ARRAY_ELEMENT_SEPARATOR, list2);
                            b.delete("downloader", "_id IN (?)", new String[]{join});
                            b.delete("downloadChunk", "_id IN (?)", new String[]{join});
                        }
                    }
                    for (int i2 = 0; i2 < size; i2++) {
                        int keyAt = sparseArray.keyAt(i2);
                        DownloadInfo downloadInfo = sparseArray.get(keyAt);
                        b.delete("downloader", "_id = ?", new String[]{String.valueOf(keyAt)});
                        b.insert("downloader", null, downloadInfo.toContentValues());
                        if (downloadInfo.getChunkCount() > 1) {
                            List<com.ss.android.socialbase.downloader.model.b> c = c(keyAt);
                            if (c.size() > 0) {
                                b.delete("downloadChunk", "_id = ?", new String[]{String.valueOf(keyAt)});
                                for (com.ss.android.socialbase.downloader.model.b bVar : c) {
                                    bVar.b(downloadInfo.getId());
                                    b.insert("downloadChunk", null, bVar.a());
                                }
                            }
                        }
                    }
                    if (sparseArray2 != null && sparseArray3 != null) {
                        int size2 = sparseArray2.size();
                        for (int i3 = 0; i3 < size2; i3++) {
                            int id = sparseArray2.valueAt(i3).getId();
                            List<com.ss.android.socialbase.downloader.model.b> a = com.ss.android.socialbase.downloader.i.f.a(c(id));
                            if (a != null && a.size() > 0) {
                                sparseArray3.put(id, a);
                            }
                        }
                    }
                    b.setTransactionSuccessful();
                    j();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if (b == null) {
            synchronized (e.class) {
                if (b == null) {
                    b = a.a().getWritableDatabase();
                    this.c = new g(b, "downloader", com.ss.android.socialbase.downloader.constants.c.a, com.ss.android.socialbase.downloader.constants.c.b);
                    this.d = new g(b, "downloadChunk", com.ss.android.socialbase.downloader.constants.c.c, com.ss.android.socialbase.downloader.constants.c.d);
                    this.e = new g(b, "segments", com.ss.android.socialbase.downloader.constants.c.e, com.ss.android.socialbase.downloader.constants.c.f);
                }
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public DownloadInfo a(int i, int i2) {
        h();
        if (b == null) {
            return null;
        }
        int i3 = 10;
        while (b.isDbLockedByCurrentThread() && i3 - 1 >= 0) {
            try {
                Thread.sleep(5L);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("chunkCount", Integer.valueOf(i2));
        b.update("downloader", contentValues, "_id = ? ", new String[]{Integer.toString(i)});
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public DownloadInfo a(int i, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) 4);
        contentValues.put("curBytes", Long.valueOf(j));
        update(i, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public DownloadInfo a(int i, long j, String str, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) 3);
        contentValues.put("totalBytes", Long.valueOf(j));
        contentValues.put("eTag", str);
        if (!TextUtils.isEmpty(str2)) {
            contentValues.put("name", str2);
        }
        update(i, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public List<DownloadInfo> a(String str) {
        h();
        ArrayList arrayList = new ArrayList();
        if (b != null) {
            Cursor cursor = null;
            try {
                cursor = b.rawQuery(String.format("SELECT * FROM %s WHERE %s = ?", "downloader", "url"), new String[]{str});
                if (cursor.moveToNext()) {
                    arrayList.add(new DownloadInfo(cursor));
                }
                com.ss.android.socialbase.downloader.i.f.a(cursor);
            } catch (Throwable th) {
                try {
                    th.printStackTrace();
                    com.ss.android.socialbase.downloader.i.f.a(cursor);
                } catch (Throwable th2) {
                    com.ss.android.socialbase.downloader.i.f.a(cursor);
                    throw th2;
                }
            }
        }
        return arrayList;
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public DownloadInfo b(int i) {
        Cursor cursor;
        h();
        if (b != null) {
            try {
                cursor = b.rawQuery(String.format("SELECT * FROM %s WHERE %s = ?", "downloader", "_id"), new String[]{Integer.toString(i)});
                try {
                    if (cursor.moveToNext()) {
                        DownloadInfo downloadInfo = new DownloadInfo(cursor);
                        com.ss.android.socialbase.downloader.i.f.a(cursor);
                        return downloadInfo;
                    }
                    com.ss.android.socialbase.downloader.i.f.a(cursor);
                } catch (Throwable th) {
                    th = th;
                    try {
                        th.printStackTrace();
                        com.ss.android.socialbase.downloader.i.f.a(cursor);
                        return null;
                    } catch (Throwable th2) {
                        com.ss.android.socialbase.downloader.i.f.a(cursor);
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
    public List<com.ss.android.socialbase.downloader.model.b> c(int i) {
        ArrayList arrayList = new ArrayList();
        h();
        if (b != null) {
            Cursor cursor = null;
            try {
                cursor = b.rawQuery(String.format("SELECT * FROM %s WHERE %s = ?", "downloadChunk", "_id"), new String[]{Integer.toString(i)});
                while (cursor.moveToNext()) {
                    arrayList.add(new com.ss.android.socialbase.downloader.model.b(cursor));
                }
                com.ss.android.socialbase.downloader.i.f.a(cursor);
            } catch (Throwable th) {
                try {
                    th.printStackTrace();
                    com.ss.android.socialbase.downloader.i.f.a(cursor);
                } catch (Throwable th2) {
                    com.ss.android.socialbase.downloader.i.f.a(cursor);
                    throw th2;
                }
            }
        }
        return arrayList;
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public void a(final int i, final int i2, final int i3, final int i4) {
        h();
        if (i != 0 && i3 >= 0 && i4 != i2 && i4 >= 0 && b != null && this.d != null) {
            com.ss.android.socialbase.downloader.downloader.c.b(new Runnable() { // from class: com.ss.android.socialbase.downloader.b.e.8
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        e.this.a(i, i2, i3, i4, e.this.d.c());
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
        }
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public void a(final int i, final int i2, final int i3, final long j) {
        h();
        if (i != 0 && i2 >= 0 && i3 >= 0 && j >= 0 && b != null && this.d != null) {
            com.ss.android.socialbase.downloader.downloader.c.b(new Runnable() { // from class: com.ss.android.socialbase.downloader.b.e.7
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        e.this.a(i, i2, i3, j, e.this.d.c());
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
        }
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public void a(final int i, final int i2, final long j) {
        h();
        if (i != 0 && i2 >= 0 && j >= 0 && b != null && this.d != null) {
            com.ss.android.socialbase.downloader.downloader.c.b(new Runnable() { // from class: com.ss.android.socialbase.downloader.b.e.6
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        e.this.a(i, i2, j, e.this.d.c());
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
        }
    }

    public void a(SparseArray<DownloadInfo> sparseArray, SparseArray<List<com.ss.android.socialbase.downloader.model.b>> sparseArray2) {
        try {
            HashMap a = com.ss.android.socialbase.downloader.i.f.a(sparseArray);
            HashMap a2 = com.ss.android.socialbase.downloader.i.f.a(sparseArray2);
            if (this.a != null) {
                this.a.a(a, a2);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.t
    public void a(final SparseArray<DownloadInfo> sparseArray, final SparseArray<List<com.ss.android.socialbase.downloader.model.b>> sparseArray2, final d dVar) {
        try {
            Runnable runnable = new Runnable() { // from class: com.ss.android.socialbase.downloader.b.e.1
                /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET]}, finally: {[IGET, IGET, IGET, IGET, INVOKE, INVOKE, IGET, INVOKE, IGET, IGET, IGET, INVOKE, IF] complete} */
                /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
                /* JADX DEBUG: Finally have unexpected throw blocks count: 3, expect 1 */
                /* JADX WARN: Code restructure failed: missing block: B:120:0x026f, code lost:
                    if (r0 == null) goto L88;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:125:0x0279, code lost:
                    if (r0 == null) goto L88;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:127:0x027d, code lost:
                    return;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:161:0x0332, code lost:
                    if (r0 == null) goto L181;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:166:0x033b, code lost:
                    if (r0 == null) goto L181;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:167:0x033d, code lost:
                    r0.a();
                    r18.d.f = true;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:168:0x0345, code lost:
                    r18.d.a(r2, r3);
                 */
                /* JADX WARN: Code restructure failed: missing block: B:169:0x034e, code lost:
                    throw r0;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:78:0x019b, code lost:
                    if (r0 != null) goto L90;
                 */
                /* JADX WARN: Removed duplicated region for block: B:192:0x00da A[SYNTHETIC] */
                /* JADX WARN: Removed duplicated region for block: B:194:0x00ca A[SYNTHETIC] */
                @Override // java.lang.Runnable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void run() {
                    d dVar2;
                    d dVar3;
                    boolean z;
                    int i;
                    e.this.h();
                    if (e.b == null) {
                        return;
                    }
                    k B = com.ss.android.socialbase.downloader.downloader.c.B();
                    SparseArray sparseArray3 = new SparseArray();
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    Cursor cursor = null;
                    int i2 = 0;
                    try {
                        cursor = e.b.rawQuery("SELECT * FROM downloader", null);
                        while (cursor.moveToNext()) {
                            DownloadInfo downloadInfo = new DownloadInfo(cursor);
                            downloadInfo.setStatusAtDbInit(downloadInfo.getRealStatus());
                            if (downloadInfo.isCanResumeFromBreakPointStatus()) {
                                downloadInfo.setStatus(-5);
                                if (com.ss.android.socialbase.downloader.g.a.c().b("status_not_update_to_db", true)) {
                                    sparseArray3.put(downloadInfo.getId(), downloadInfo);
                                }
                            }
                            if (!TextUtils.isEmpty(downloadInfo.getSavePath()) && !TextUtils.isEmpty(downloadInfo.getName())) {
                                if (downloadInfo.getStatus() == 1 && downloadInfo.getCurBytes() <= 0) {
                                    z = true;
                                } else {
                                    if (downloadInfo.getStatus() != -3 && downloadInfo.getStatus() != 11 && !downloadInfo.isFileDataValid()) {
                                        downloadInfo.reset();
                                    }
                                    z = false;
                                }
                                if (downloadInfo.getStatus() == 11) {
                                    downloadInfo.setStatus(-5);
                                }
                                if (com.ss.android.socialbase.downloader.i.f.a(downloadInfo.getStatus(), downloadInfo.getSavePath(), downloadInfo.getName())) {
                                    if (!com.ss.android.socialbase.downloader.i.a.a(33554432)) {
                                        downloadInfo.erase();
                                    }
                                }
                                if (!z) {
                                    arrayList.add(Integer.valueOf(downloadInfo.getId()));
                                    arrayList2.add(downloadInfo);
                                } else {
                                    int id = downloadInfo.getId();
                                    if (B != null) {
                                        i = B.a(downloadInfo.getUrl(), downloadInfo.getSavePath());
                                    } else {
                                        i = 0;
                                    }
                                    if (i != id) {
                                        downloadInfo.setId(i);
                                        sparseArray3.put(id, downloadInfo);
                                    }
                                    sparseArray.put(downloadInfo.getId(), downloadInfo);
                                }
                            }
                            z = true;
                            if (!z) {
                            }
                        }
                        com.ss.android.socialbase.downloader.i.f.a(cursor);
                        e.this.a(arrayList2);
                        e.this.a(arrayList2, arrayList, sparseArray3, sparseArray, sparseArray2);
                        try {
                            ArrayList<Integer> arrayList3 = new ArrayList();
                            if (sparseArray != null) {
                                while (i2 < sparseArray.size()) {
                                    int keyAt = sparseArray.keyAt(i2);
                                    if (keyAt != 0) {
                                        DownloadInfo downloadInfo2 = (DownloadInfo) sparseArray.get(keyAt);
                                        if (com.ss.android.socialbase.downloader.i.a.a(8192)) {
                                            if (downloadInfo2 != null && !downloadInfo2.isChunkBreakpointAvailable() && downloadInfo2.getStatus() != -3) {
                                                arrayList3.add(Integer.valueOf(downloadInfo2.getId()));
                                                sparseArray2.remove(downloadInfo2.getId());
                                            }
                                        } else if (downloadInfo2 != null && !downloadInfo2.isChunkBreakpointAvailable()) {
                                            arrayList3.add(Integer.valueOf(downloadInfo2.getId()));
                                            sparseArray2.remove(downloadInfo2.getId());
                                        }
                                    }
                                    for (Integer num : arrayList3) {
                                        sparseArray.remove(num.intValue());
                                    }
                                    i2++;
                                }
                            }
                            dVar3 = dVar;
                        } catch (Throwable th) {
                            try {
                                th.printStackTrace();
                            } finally {
                            }
                        }
                    } catch (Throwable th2) {
                        try {
                            th2.printStackTrace();
                            com.ss.android.socialbase.downloader.i.f.a(cursor);
                            e.this.a(arrayList2);
                            e.this.a(arrayList2, arrayList, sparseArray3, sparseArray, sparseArray2);
                            try {
                                ArrayList<Integer> arrayList4 = new ArrayList();
                                if (sparseArray != null) {
                                    while (i2 < sparseArray.size()) {
                                        int keyAt2 = sparseArray.keyAt(i2);
                                        if (keyAt2 != 0) {
                                            DownloadInfo downloadInfo3 = (DownloadInfo) sparseArray.get(keyAt2);
                                            if (com.ss.android.socialbase.downloader.i.a.a(8192)) {
                                                if (downloadInfo3 != null && !downloadInfo3.isChunkBreakpointAvailable() && downloadInfo3.getStatus() != -3) {
                                                    arrayList4.add(Integer.valueOf(downloadInfo3.getId()));
                                                    sparseArray2.remove(downloadInfo3.getId());
                                                }
                                            } else if (downloadInfo3 != null && !downloadInfo3.isChunkBreakpointAvailable()) {
                                                arrayList4.add(Integer.valueOf(downloadInfo3.getId()));
                                                sparseArray2.remove(downloadInfo3.getId());
                                            }
                                        }
                                        for (Integer num2 : arrayList4) {
                                            sparseArray.remove(num2.intValue());
                                        }
                                        i2++;
                                    }
                                }
                                dVar3 = dVar;
                            } catch (Throwable th3) {
                                try {
                                    th3.printStackTrace();
                                    dVar3 = dVar;
                                } finally {
                                    d dVar4 = dVar;
                                    if (dVar4 != null) {
                                        dVar4.a();
                                        e.this.f = true;
                                    }
                                    e.this.a(sparseArray, sparseArray2);
                                }
                            }
                        } catch (Throwable th4) {
                            com.ss.android.socialbase.downloader.i.f.a(cursor);
                            e.this.a(arrayList2);
                            e.this.a(arrayList2, arrayList, sparseArray3, sparseArray, sparseArray2);
                            try {
                                ArrayList<Integer> arrayList5 = new ArrayList();
                                if (sparseArray != null) {
                                    while (i2 < sparseArray.size()) {
                                        int keyAt3 = sparseArray.keyAt(i2);
                                        if (keyAt3 != 0) {
                                            DownloadInfo downloadInfo4 = (DownloadInfo) sparseArray.get(keyAt3);
                                            if (com.ss.android.socialbase.downloader.i.a.a(8192)) {
                                                if (downloadInfo4 != null && !downloadInfo4.isChunkBreakpointAvailable() && downloadInfo4.getStatus() != -3) {
                                                    arrayList5.add(Integer.valueOf(downloadInfo4.getId()));
                                                    sparseArray2.remove(downloadInfo4.getId());
                                                }
                                            } else if (downloadInfo4 != null && !downloadInfo4.isChunkBreakpointAvailable()) {
                                                arrayList5.add(Integer.valueOf(downloadInfo4.getId()));
                                                sparseArray2.remove(downloadInfo4.getId());
                                            }
                                        }
                                        for (Integer num3 : arrayList5) {
                                            sparseArray.remove(num3.intValue());
                                        }
                                        i2++;
                                    }
                                }
                                dVar2 = dVar;
                            } catch (Throwable th5) {
                                try {
                                    th5.printStackTrace();
                                    dVar2 = dVar;
                                } finally {
                                    d dVar5 = dVar;
                                    if (dVar5 != null) {
                                        dVar5.a();
                                        e.this.f = true;
                                    }
                                    e.this.a(sparseArray, sparseArray2);
                                }
                            }
                        }
                    }
                }
            };
            ExecutorService r = com.ss.android.socialbase.downloader.downloader.c.r();
            if (r != null) {
                r.execute(runnable);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public void a(b bVar) {
        this.a = bVar;
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public void d(final int i) {
        h();
        if (b != null && this.d != null) {
            com.ss.android.socialbase.downloader.downloader.c.b(new Runnable() { // from class: com.ss.android.socialbase.downloader.b.e.4
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        e.this.a(i, e.this.d.b());
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
        }
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public void a(final com.ss.android.socialbase.downloader.model.b bVar) {
        h();
        if (b != null && this.d != null) {
            com.ss.android.socialbase.downloader.downloader.c.b(new Runnable() { // from class: com.ss.android.socialbase.downloader.b.e.5
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        e.this.a(bVar, e.this.d.a());
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
        }
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public boolean a(int i) {
        try {
            if (b(i) == null) {
                return false;
            }
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public boolean a(int i, Map<Long, i> map) {
        long currentTimeMillis = System.currentTimeMillis();
        h();
        if (b == null) {
            return false;
        }
        JSONArray jSONArray = new JSONArray();
        try {
            for (Long l : map.keySet()) {
                jSONArray.put(map.get(Long.valueOf(l.longValue())).k());
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        Log.d("SqlDownloadCache", "json=" + jSONArray);
        SQLiteStatement d = this.e.d();
        synchronized (d) {
            d.clearBindings();
            d.bindLong(1, i);
            d.bindString(2, jSONArray.toString());
            d.execute();
        }
        com.ss.android.socialbase.downloader.c.a.b("SqlDownloadCache", "updateSegments cost=" + com.ss.android.socialbase.downloader.i.f.c(currentTimeMillis));
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public boolean a(final DownloadInfo downloadInfo) {
        h();
        if (downloadInfo != null && b != null) {
            com.ss.android.socialbase.downloader.downloader.c.b(new Runnable() { // from class: com.ss.android.socialbase.downloader.b.e.10
                @Override // java.lang.Runnable
                public void run() {
                    e.this.d(downloadInfo);
                }
            });
            return true;
        }
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public Map<Long, i> l(int i) {
        Cursor cursor;
        String str;
        h();
        if (b != null) {
            try {
                cursor = b.rawQuery(String.format("SELECT * FROM %s WHERE %s = ?", "segments", "_id"), new String[]{Integer.toString(i)});
                try {
                    if (cursor.moveToNext()) {
                        int columnIndex = cursor.getColumnIndex("info");
                        if (columnIndex >= 0) {
                            str = cursor.getString(columnIndex);
                        } else {
                            str = null;
                        }
                        HashMap hashMap = new HashMap();
                        JSONArray jSONArray = new JSONArray(str);
                        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                            i iVar = new i(jSONArray.getJSONObject(i2));
                            hashMap.put(Long.valueOf(iVar.c()), iVar);
                        }
                        com.ss.android.socialbase.downloader.i.f.a(cursor);
                        return hashMap;
                    }
                    com.ss.android.socialbase.downloader.i.f.a(cursor);
                } catch (Throwable th) {
                    th = th;
                    try {
                        th.printStackTrace();
                        com.ss.android.socialbase.downloader.i.f.a(cursor);
                        return null;
                    } catch (Throwable th2) {
                        com.ss.android.socialbase.downloader.i.f.a(cursor);
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
}

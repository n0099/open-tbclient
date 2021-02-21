package com.ss.android.socialbase.downloader.c;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.android.imsdk.IMConstants;
import com.ss.android.socialbase.downloader.c.c;
import com.ss.android.socialbase.downloader.downloader.l;
import com.ss.android.socialbase.downloader.downloader.t;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutorService;
/* loaded from: classes6.dex */
public class e extends c.a implements t {

    /* renamed from: b  reason: collision with root package name */
    private static volatile SQLiteDatabase f13087b = null;

    /* renamed from: a  reason: collision with root package name */
    b f13088a;
    private g c;
    private g d;
    private volatile boolean e;

    public e() {
        this(false);
    }

    public e(boolean z) {
        this.f13088a = null;
        if (z) {
            this.e = false;
            a();
        }
    }

    @Override // com.ss.android.socialbase.downloader.c.c
    public com.ss.android.socialbase.downloader.g.c g(int i) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (f13087b == null) {
            synchronized (e.class) {
                if (f13087b == null) {
                    f13087b = a.eGa().getWritableDatabase();
                    this.c = new g(f13087b, "downloader", com.ss.android.socialbase.downloader.b.c.f13070a, com.ss.android.socialbase.downloader.b.c.f13071b);
                    this.d = new g(f13087b, "downloadChunk", com.ss.android.socialbase.downloader.b.c.c, com.ss.android.socialbase.downloader.b.c.d);
                }
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.c.c
    public void a() {
        a((SparseArray<com.ss.android.socialbase.downloader.g.c>) null, (SparseArray<List<com.ss.android.socialbase.downloader.g.b>>) null, (d) null);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.t
    public void a(final SparseArray<com.ss.android.socialbase.downloader.g.c> sparseArray, final SparseArray<List<com.ss.android.socialbase.downloader.g.b>> sparseArray2, final d dVar) {
        try {
            Runnable runnable = new Runnable() { // from class: com.ss.android.socialbase.downloader.c.e.1
                /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET]}, finally: {[IGET, IGET, INVOKE, IGET, INVOKE, IGET, CONST, INVOKE, IGET, INVOKE, IF] complete} */
                /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [186=6, 207=6, 213=9, 214=9, 215=9, 217=9] */
                /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
                /* JADX DEBUG: Finally have unexpected throw blocks count: 3, expect 1 */
                @Override // java.lang.Runnable
                public void run() {
                    e.this.f();
                    if (e.f13087b == null) {
                        return;
                    }
                    SparseArray<com.ss.android.socialbase.downloader.g.c> sparseArray3 = sparseArray;
                    if (sparseArray3 == null) {
                        sparseArray3 = new SparseArray<>();
                    }
                    SparseArray<List<com.ss.android.socialbase.downloader.g.b>> sparseArray4 = sparseArray2;
                    if (sparseArray4 == null) {
                        sparseArray4 = new SparseArray<>();
                    }
                    l eGw = com.ss.android.socialbase.downloader.downloader.b.eGw();
                    SparseArray sparseArray5 = new SparseArray();
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    Cursor cursor = null;
                    try {
                        cursor = e.f13087b.rawQuery("SELECT * FROM downloader", null);
                        while (cursor.moveToNext()) {
                            boolean z = false;
                            com.ss.android.socialbase.downloader.g.c cVar = new com.ss.android.socialbase.downloader.g.c(cursor);
                            if (cVar.eHT()) {
                                cVar.c(-5);
                            }
                            if (TextUtils.isEmpty(cVar.k()) || TextUtils.isEmpty(cVar.h())) {
                                z = true;
                            } else {
                                if (cVar.q() == 1 && cVar.eHi() <= 0) {
                                    z = true;
                                } else if (cVar.q() != -3 && cVar.q() != 11 && !cVar.bd()) {
                                    cVar.eHM();
                                }
                                if (cVar.q() == 11) {
                                    cVar.c(-5);
                                }
                                if (com.ss.android.socialbase.downloader.m.d.s(cVar.q(), cVar.k(), cVar.h())) {
                                    if (com.ss.android.socialbase.downloader.m.a.a(33554432)) {
                                        z = true;
                                    } else {
                                        cVar.eHN();
                                    }
                                }
                            }
                            if (z) {
                                arrayList.add(Integer.valueOf(cVar.g()));
                                arrayList2.add(cVar);
                            } else {
                                int g = cVar.g();
                                int a2 = eGw != null ? eGw.a(cVar.j(), cVar.k()) : 0;
                                if (a2 != g) {
                                    cVar.i(a2);
                                    sparseArray5.put(g, cVar);
                                }
                                if (sparseArray3 != null) {
                                    synchronized (sparseArray3) {
                                        sparseArray3.put(cVar.g(), cVar);
                                    }
                                }
                            }
                        }
                        com.ss.android.socialbase.downloader.m.d.a(cursor);
                        e.this.a(arrayList2);
                        e.this.a(arrayList2, arrayList, sparseArray5, sparseArray3, sparseArray4);
                        if (sparseArray3 != null) {
                            try {
                                synchronized (sparseArray3) {
                                    ArrayList<Integer> arrayList3 = new ArrayList();
                                    for (int i = 0; i < sparseArray3.size(); i++) {
                                        int keyAt = sparseArray3.keyAt(i);
                                        if (keyAt != 0) {
                                            com.ss.android.socialbase.downloader.g.c cVar2 = sparseArray3.get(keyAt);
                                            if (com.ss.android.socialbase.downloader.m.a.a(8192)) {
                                                if (cVar2 != null && !cVar2.eHO() && cVar2.q() != -3) {
                                                    arrayList3.add(Integer.valueOf(cVar2.g()));
                                                    sparseArray4.remove(cVar2.g());
                                                }
                                            } else if (cVar2 != null && !cVar2.eHO()) {
                                                arrayList3.add(Integer.valueOf(cVar2.g()));
                                                sparseArray4.remove(cVar2.g());
                                            }
                                        }
                                    }
                                    for (Integer num : arrayList3) {
                                        sparseArray3.remove(num.intValue());
                                    }
                                }
                            } catch (Throwable th) {
                                try {
                                    th.printStackTrace();
                                    if (dVar != null) {
                                        dVar.a();
                                        e.this.e = true;
                                    }
                                    e.this.a(sparseArray3, sparseArray4);
                                    return;
                                } finally {
                                }
                            }
                        }
                        if (dVar != null) {
                            dVar.a();
                            e.this.e = true;
                        }
                        e.this.a(sparseArray3, sparseArray4);
                    } catch (Throwable th2) {
                        try {
                            th2.printStackTrace();
                            com.ss.android.socialbase.downloader.m.d.a(cursor);
                            e.this.a(arrayList2);
                            e.this.a(arrayList2, arrayList, sparseArray5, sparseArray3, sparseArray4);
                            if (sparseArray3 != null) {
                                try {
                                    synchronized (sparseArray3) {
                                        ArrayList<Integer> arrayList4 = new ArrayList();
                                        int i2 = 0;
                                        while (true) {
                                            int i3 = i2;
                                            if (i3 >= sparseArray3.size()) {
                                                break;
                                            }
                                            int keyAt2 = sparseArray3.keyAt(i3);
                                            if (keyAt2 != 0) {
                                                com.ss.android.socialbase.downloader.g.c cVar3 = sparseArray3.get(keyAt2);
                                                if (com.ss.android.socialbase.downloader.m.a.a(8192)) {
                                                    if (cVar3 != null && !cVar3.eHO() && cVar3.q() != -3) {
                                                        arrayList4.add(Integer.valueOf(cVar3.g()));
                                                        sparseArray4.remove(cVar3.g());
                                                    }
                                                } else if (cVar3 != null && !cVar3.eHO()) {
                                                    arrayList4.add(Integer.valueOf(cVar3.g()));
                                                    sparseArray4.remove(cVar3.g());
                                                }
                                            }
                                            i2 = i3 + 1;
                                        }
                                        for (Integer num2 : arrayList4) {
                                            sparseArray3.remove(num2.intValue());
                                        }
                                    }
                                } catch (Throwable th3) {
                                    try {
                                        th3.printStackTrace();
                                        if (dVar != null) {
                                            dVar.a();
                                            e.this.e = true;
                                        }
                                        e.this.a(sparseArray3, sparseArray4);
                                        return;
                                    } finally {
                                    }
                                }
                            }
                            if (dVar != null) {
                                dVar.a();
                                e.this.e = true;
                            }
                            e.this.a(sparseArray3, sparseArray4);
                        } catch (Throwable th4) {
                            com.ss.android.socialbase.downloader.m.d.a(cursor);
                            e.this.a(arrayList2);
                            e.this.a(arrayList2, arrayList, sparseArray5, sparseArray3, sparseArray4);
                            if (sparseArray3 != null) {
                                try {
                                    synchronized (sparseArray3) {
                                        ArrayList<Integer> arrayList5 = new ArrayList();
                                        int i4 = 0;
                                        while (true) {
                                            int i5 = i4;
                                            if (i5 >= sparseArray3.size()) {
                                                break;
                                            }
                                            int keyAt3 = sparseArray3.keyAt(i5);
                                            if (keyAt3 != 0) {
                                                com.ss.android.socialbase.downloader.g.c cVar4 = sparseArray3.get(keyAt3);
                                                if (com.ss.android.socialbase.downloader.m.a.a(8192)) {
                                                    if (cVar4 != null && !cVar4.eHO() && cVar4.q() != -3) {
                                                        arrayList5.add(Integer.valueOf(cVar4.g()));
                                                        sparseArray4.remove(cVar4.g());
                                                    }
                                                } else if (cVar4 != null && !cVar4.eHO()) {
                                                    arrayList5.add(Integer.valueOf(cVar4.g()));
                                                    sparseArray4.remove(cVar4.g());
                                                }
                                            }
                                            i4 = i5 + 1;
                                        }
                                        for (Integer num3 : arrayList5) {
                                            sparseArray3.remove(num3.intValue());
                                        }
                                    }
                                } catch (Throwable th5) {
                                    try {
                                        th5.printStackTrace();
                                        if (dVar != null) {
                                            dVar.a();
                                            e.this.e = true;
                                        }
                                        e.this.a(sparseArray3, sparseArray4);
                                        throw th4;
                                    } finally {
                                        if (dVar != null) {
                                            dVar.a();
                                            e.this.e = true;
                                        }
                                        e.this.a(sparseArray3, sparseArray4);
                                    }
                                }
                            }
                            if (dVar != null) {
                                dVar.a();
                                e.this.e = true;
                            }
                            e.this.a(sparseArray3, sparseArray4);
                            throw th4;
                        }
                    }
                }
            };
            ExecutorService eGp = com.ss.android.socialbase.downloader.downloader.b.eGp();
            if (eGp != null) {
                eGp.execute(runnable);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<com.ss.android.socialbase.downloader.g.c> list) {
        if (list != null) {
            try {
                for (com.ss.android.socialbase.downloader.g.c cVar : list) {
                    if (cVar != null && cVar.eIc()) {
                        com.ss.android.socialbase.downloader.m.d.b(cVar);
                    }
                }
            } catch (Throwable th) {
            }
        }
    }

    private void g() {
        f13087b.beginTransaction();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<com.ss.android.socialbase.downloader.g.c> list, List<Integer> list2, SparseArray<com.ss.android.socialbase.downloader.g.c> sparseArray, SparseArray<com.ss.android.socialbase.downloader.g.c> sparseArray2, SparseArray<List<com.ss.android.socialbase.downloader.g.b>> sparseArray3) {
        int size = sparseArray.size();
        if (size >= 0 && f13087b != null) {
            synchronized (f13087b) {
                try {
                    g();
                    if (!list.isEmpty()) {
                        if (com.ss.android.socialbase.downloader.k.a.eIF().a("clear_invalid_task_error")) {
                            String[] strArr = new String[list.size()];
                            for (int i = 0; i < list.size(); i++) {
                                strArr[i] = String.valueOf(list.get(i));
                            }
                            String str = "CAST(_id AS TEXT) IN (" + new String(new char[list.size() - 1]).replace("\u0000", "?,") + "?)";
                            f13087b.delete("downloader", str, strArr);
                            f13087b.delete("downloadChunk", str, strArr);
                        } else {
                            String join = TextUtils.join(", ", list2);
                            f13087b.delete("downloader", "_id IN (?)", new String[]{join});
                            f13087b.delete("downloadChunk", "_id IN (?)", new String[]{join});
                        }
                    }
                    for (int i2 = 0; i2 < size; i2++) {
                        int keyAt = sparseArray.keyAt(i2);
                        com.ss.android.socialbase.downloader.g.c cVar = sparseArray.get(keyAt);
                        f13087b.delete("downloader", "_id = ?", new String[]{String.valueOf(keyAt)});
                        f13087b.insert("downloader", null, cVar.eGX());
                        if (cVar.eHU() > 1) {
                            List<com.ss.android.socialbase.downloader.g.b> c = c(keyAt);
                            if (c.size() > 0) {
                                f13087b.delete("downloadChunk", "_id = ?", new String[]{String.valueOf(keyAt)});
                                for (com.ss.android.socialbase.downloader.g.b bVar : c) {
                                    bVar.b(cVar.g());
                                    f13087b.insert("downloadChunk", null, bVar.eGT());
                                }
                            }
                        }
                    }
                    if (sparseArray2 != null && sparseArray3 != null) {
                        synchronized (sparseArray2) {
                            int size2 = sparseArray2.size();
                            for (int i3 = 0; i3 < size2; i3++) {
                                int g = sparseArray2.valueAt(i3).g();
                                List<com.ss.android.socialbase.downloader.g.b> a2 = com.ss.android.socialbase.downloader.m.d.a(c(g));
                                if (a2 != null && a2.size() > 0) {
                                    sparseArray3.put(g, a2);
                                }
                            }
                        }
                    }
                    f13087b.setTransactionSuccessful();
                    h();
                }
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.c.c
    public boolean a(int i) {
        try {
            return b(i) != null;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.c.c
    public com.ss.android.socialbase.downloader.g.c b(int i) {
        Cursor cursor;
        f();
        if (f13087b != null) {
            try {
                cursor = f13087b.rawQuery(String.format("SELECT * FROM %s WHERE %s = ?", "downloader", IMConstants.MSG_ROW_ID), new String[]{Integer.toString(i)});
            } catch (Throwable th) {
                th = th;
                cursor = null;
            }
            try {
                if (cursor.moveToNext()) {
                    com.ss.android.socialbase.downloader.g.c cVar = new com.ss.android.socialbase.downloader.g.c(cursor);
                    com.ss.android.socialbase.downloader.m.d.a(cursor);
                    return cVar;
                }
                com.ss.android.socialbase.downloader.m.d.a(cursor);
            } catch (Throwable th2) {
                th = th2;
                try {
                    th.printStackTrace();
                    com.ss.android.socialbase.downloader.m.d.a(cursor);
                    return null;
                } catch (Throwable th3) {
                    com.ss.android.socialbase.downloader.m.d.a(cursor);
                    throw th3;
                }
            }
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.c.c
    public List<com.ss.android.socialbase.downloader.g.c> a(String str) {
        f();
        ArrayList arrayList = new ArrayList();
        if (f13087b != null) {
            Cursor cursor = null;
            try {
                cursor = f13087b.rawQuery(String.format("SELECT * FROM %s WHERE %s = ?", "downloader", "url"), new String[]{str});
                if (cursor.moveToNext()) {
                    arrayList.add(new com.ss.android.socialbase.downloader.g.c(cursor));
                }
                com.ss.android.socialbase.downloader.m.d.a(cursor);
            } catch (Throwable th) {
                try {
                    th.printStackTrace();
                    com.ss.android.socialbase.downloader.m.d.a(cursor);
                } catch (Throwable th2) {
                    com.ss.android.socialbase.downloader.m.d.a(cursor);
                    throw th2;
                }
            }
        }
        return arrayList;
    }

    @Override // com.ss.android.socialbase.downloader.c.c
    public List<com.ss.android.socialbase.downloader.g.c> b(String str) {
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.c.c
    public List<com.ss.android.socialbase.downloader.g.c> c(String str) {
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.c.c
    public List<com.ss.android.socialbase.downloader.g.c> d(String str) {
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.c.c
    public List<com.ss.android.socialbase.downloader.g.b> c(int i) {
        ArrayList arrayList = new ArrayList();
        f();
        if (f13087b != null) {
            Cursor cursor = null;
            try {
                cursor = f13087b.rawQuery(String.format("SELECT * FROM %s WHERE %s = ?", "downloadChunk", IMConstants.MSG_ROW_ID), new String[]{Integer.toString(i)});
                while (cursor.moveToNext()) {
                    arrayList.add(new com.ss.android.socialbase.downloader.g.b(cursor));
                }
                com.ss.android.socialbase.downloader.m.d.a(cursor);
            } catch (Throwable th) {
                try {
                    th.printStackTrace();
                    com.ss.android.socialbase.downloader.m.d.a(cursor);
                } catch (Throwable th2) {
                    com.ss.android.socialbase.downloader.m.d.a(cursor);
                    throw th2;
                }
            }
        }
        return arrayList;
    }

    @Override // com.ss.android.socialbase.downloader.c.c
    public void d(final int i) {
        f();
        if (f13087b != null && this.d != null) {
            com.ss.android.socialbase.downloader.downloader.b.b(new Runnable() { // from class: com.ss.android.socialbase.downloader.c.e.6
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        e.this.a(i, e.this.d.eGc());
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, SQLiteStatement sQLiteStatement) {
        if (sQLiteStatement != null) {
            try {
                synchronized (sQLiteStatement) {
                    sQLiteStatement.bindLong(1, i);
                    sQLiteStatement.execute();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.c.c
    public void a(final com.ss.android.socialbase.downloader.g.b bVar) {
        f();
        if (f13087b != null && this.d != null) {
            com.ss.android.socialbase.downloader.downloader.b.b(new Runnable() { // from class: com.ss.android.socialbase.downloader.c.e.7
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        e.this.a(bVar, e.this.d.eGb());
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
        }
    }

    @Override // com.ss.android.socialbase.downloader.c.c
    public void b(com.ss.android.socialbase.downloader.g.b bVar) {
        a(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.ss.android.socialbase.downloader.g.c cVar, SQLiteStatement sQLiteStatement) {
        if (cVar != null && sQLiteStatement != null) {
            try {
                synchronized (sQLiteStatement) {
                    cVar.b(sQLiteStatement);
                    sQLiteStatement.executeInsert();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.ss.android.socialbase.downloader.g.b bVar, SQLiteStatement sQLiteStatement) {
        if (bVar != null && sQLiteStatement != null) {
            try {
                synchronized (sQLiteStatement) {
                    bVar.b(sQLiteStatement);
                    sQLiteStatement.executeInsert();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.c.c
    public void a(final int i, final int i2, final long j) {
        f();
        if (i != 0 && i2 >= 0 && j >= 0 && f13087b != null && this.d != null) {
            com.ss.android.socialbase.downloader.downloader.b.b(new Runnable() { // from class: com.ss.android.socialbase.downloader.c.e.8
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        e.this.a(i, i2, j, e.this.d.eGd());
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
        }
    }

    @Override // com.ss.android.socialbase.downloader.c.c
    public void a(final int i, final int i2, final int i3, final long j) {
        f();
        if (i != 0 && i2 >= 0 && i3 >= 0 && j >= 0 && f13087b != null && this.d != null) {
            com.ss.android.socialbase.downloader.downloader.b.b(new Runnable() { // from class: com.ss.android.socialbase.downloader.c.e.9
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        e.this.a(i, i2, i3, j, e.this.d.eGd());
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
        }
    }

    @Override // com.ss.android.socialbase.downloader.c.c
    public void a(final int i, final int i2, final int i3, final int i4) {
        f();
        if (i != 0 && i3 >= 0 && i4 != i2 && i4 >= 0 && f13087b != null && this.d != null) {
            com.ss.android.socialbase.downloader.downloader.b.b(new Runnable() { // from class: com.ss.android.socialbase.downloader.c.e.10
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        e.this.a(i, i2, i3, i4, e.this.d.eGd());
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2, int i3, int i4, SQLiteStatement sQLiteStatement) {
        try {
            synchronized (sQLiteStatement) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("chunkIndex", Integer.valueOf(i4));
                f13087b.update("downloadChunk", contentValues, "_id = ? AND chunkIndex = ? AND hostChunkIndex = ?", new String[]{Integer.toString(i), Integer.toString(i2), Integer.toString(i3)});
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
                f13087b.update("downloadChunk", contentValues, "_id = ? AND chunkIndex = ?", new String[]{Integer.toString(i), Integer.toString(i2)});
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
                f13087b.update("downloadChunk", contentValues, "_id = ? AND chunkIndex = ? AND hostChunkIndex = ?", new String[]{Integer.toString(i), Integer.toString(i2), Integer.toString(i3)});
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void b(com.ss.android.socialbase.downloader.g.c cVar, SQLiteStatement sQLiteStatement) {
        if (cVar != null && sQLiteStatement != null) {
            try {
                synchronized (sQLiteStatement) {
                    cVar.b(sQLiteStatement);
                    sQLiteStatement.bindLong(cVar.f() + 1, cVar.g());
                    sQLiteStatement.execute();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.c.c
    public com.ss.android.socialbase.downloader.g.c a(int i, int i2) {
        f();
        if (f13087b != null) {
            int i3 = 10;
            while (f13087b.isDbLockedByCurrentThread() && i3 - 1 >= 0) {
                try {
                    Thread.sleep(5L);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("chunkCount", Integer.valueOf(i2));
            f13087b.update("downloader", contentValues, "_id = ? ", new String[]{Integer.toString(i)});
        }
        return null;
    }

    private void c(final com.ss.android.socialbase.downloader.g.c cVar) {
        f();
        if (f13087b != null && this.c != null) {
            com.ss.android.socialbase.downloader.downloader.b.b(new Runnable() { // from class: com.ss.android.socialbase.downloader.c.e.11
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        e.this.a(cVar, e.this.c.eGb());
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
        }
    }

    @Override // com.ss.android.socialbase.downloader.c.c
    public boolean a(final com.ss.android.socialbase.downloader.g.c cVar) {
        f();
        if (cVar == null || f13087b == null) {
            return false;
        }
        com.ss.android.socialbase.downloader.downloader.b.b(new Runnable() { // from class: com.ss.android.socialbase.downloader.c.e.2
            @Override // java.lang.Runnable
            public void run() {
                e.this.d(cVar);
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void d(com.ss.android.socialbase.downloader.g.c cVar) {
        if (cVar != null) {
            try {
                if (!a(cVar.g())) {
                    c(cVar);
                } else if (this.c != null) {
                    b(cVar, this.c.eGd());
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private void h() {
        try {
            if (f13087b != null && f13087b.inTransaction()) {
                f13087b.endTransaction();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.c.c
    public boolean e(int i) {
        f();
        if (f13087b == null || this.c == null) {
            return false;
        }
        try {
            a(i, this.c.eGc());
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.c.c
    public boolean f(final int i) {
        com.ss.android.socialbase.downloader.downloader.b.b(new Runnable() { // from class: com.ss.android.socialbase.downloader.c.e.3
            @Override // java.lang.Runnable
            public void run() {
                e.this.e(i);
                e.this.d(i);
            }
        });
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.c.c
    public void b() {
        f();
        if (f13087b != null) {
            com.ss.android.socialbase.downloader.downloader.b.b(new Runnable() { // from class: com.ss.android.socialbase.downloader.c.e.4
                @Override // java.lang.Runnable
                public void run() {
                    e.this.i();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void i() {
        g();
        f13087b.delete("downloader", null, null);
        f13087b.delete("downloadChunk", null, null);
        f13087b.setTransactionSuccessful();
        h();
    }

    @Override // com.ss.android.socialbase.downloader.c.c
    public com.ss.android.socialbase.downloader.g.c a(int i, long j, String str, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) 3);
        contentValues.put("totalBytes", Long.valueOf(j));
        contentValues.put("eTag", str);
        if (!TextUtils.isEmpty(str2)) {
            contentValues.put("name", str2);
        }
        a(i, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.c.c
    public com.ss.android.socialbase.downloader.g.c a(int i, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) 4);
        contentValues.put("curBytes", Long.valueOf(j));
        a(i, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.c.c
    public com.ss.android.socialbase.downloader.g.c b(int i, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) (-1));
        contentValues.put("curBytes", Long.valueOf(j));
        if (j > 0) {
            contentValues.put("isFirstDownload", (Integer) 0);
        }
        a(i, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.c.c
    public com.ss.android.socialbase.downloader.g.c h(int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) 5);
        contentValues.put("isFirstDownload", (Integer) 0);
        a(i, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.c.c
    public com.ss.android.socialbase.downloader.g.c c(int i, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) (-3));
        contentValues.put("curBytes", Long.valueOf(j));
        contentValues.put("isFirstDownload", (Integer) 0);
        contentValues.put("isFirstSuccess", (Integer) 0);
        a(i, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.c.c
    public com.ss.android.socialbase.downloader.g.c d(int i, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) (-2));
        contentValues.put("curBytes", Long.valueOf(j));
        a(i, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.c.c
    public com.ss.android.socialbase.downloader.g.c e(int i, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) (-4));
        contentValues.put("curBytes", Long.valueOf(j));
        a(i, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.c.c
    public com.ss.android.socialbase.downloader.g.c i(int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) 1);
        a(i, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.c.c
    public com.ss.android.socialbase.downloader.g.c j(int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) (-7));
        a(i, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.c.c
    public boolean c() {
        return this.e;
    }

    @Override // com.ss.android.socialbase.downloader.c.c
    public boolean d() {
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.c.c
    public void b(com.ss.android.socialbase.downloader.g.c cVar) {
    }

    @Override // com.ss.android.socialbase.downloader.c.c
    public void a(int i, List<com.ss.android.socialbase.downloader.g.b> list) {
    }

    @Override // com.ss.android.socialbase.downloader.c.c
    public void b(int i, List<com.ss.android.socialbase.downloader.g.b> list) {
        try {
            d(i);
            if (list != null) {
                for (com.ss.android.socialbase.downloader.g.b bVar : list) {
                    if (bVar != null) {
                        a(bVar);
                        if (bVar.f()) {
                            for (com.ss.android.socialbase.downloader.g.b bVar2 : bVar.g()) {
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

    private void a(final int i, final ContentValues contentValues) {
        f();
        if (f13087b != null) {
            com.ss.android.socialbase.downloader.downloader.b.b(new Runnable() { // from class: com.ss.android.socialbase.downloader.c.e.5
                @Override // java.lang.Runnable
                public void run() {
                    e.this.b(i, contentValues);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, ContentValues contentValues) {
        int i2 = 10;
        while (f13087b.isDbLockedByCurrentThread() && i2 - 1 >= 0) {
            try {
                Thread.sleep(5L);
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        }
        f13087b.update("downloader", contentValues, "_id = ? ", new String[]{String.valueOf(i)});
    }

    @Override // com.ss.android.socialbase.downloader.c.c
    public void a(b bVar) {
        this.f13088a = bVar;
    }

    public void a(SparseArray<com.ss.android.socialbase.downloader.g.c> sparseArray, SparseArray<List<com.ss.android.socialbase.downloader.g.b>> sparseArray2) {
        try {
            HashMap l = com.ss.android.socialbase.downloader.m.d.l(sparseArray);
            HashMap l2 = com.ss.android.socialbase.downloader.m.d.l(sparseArray2);
            if (this.f13088a != null) {
                this.f13088a.a(l, l2);
            }
        } catch (Throwable th) {
        }
    }
}

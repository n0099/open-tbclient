package com.kwai.filedownloader.b;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.searchbox.bddownload.core.breakpoint.sqllite.BreakpointSQLiteKey;
import com.kwai.filedownloader.b.a;
import com.kwai.filedownloader.f.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes6.dex */
public class d implements com.kwai.filedownloader.b.a {

    /* renamed from: a  reason: collision with root package name */
    public SQLiteDatabase f36871a;

    /* loaded from: classes6.dex */
    public class a implements a.InterfaceC0440a {

        /* renamed from: b  reason: collision with root package name */
        public final SparseArray<com.kwai.filedownloader.d.c> f36873b;

        /* renamed from: c  reason: collision with root package name */
        public b f36874c;

        /* renamed from: d  reason: collision with root package name */
        public final SparseArray<com.kwai.filedownloader.d.c> f36875d;

        /* renamed from: e  reason: collision with root package name */
        public final SparseArray<List<com.kwai.filedownloader.d.a>> f36876e;

        public a(d dVar) {
            this(null, null);
        }

        public a(SparseArray<com.kwai.filedownloader.d.c> sparseArray, SparseArray<List<com.kwai.filedownloader.d.a>> sparseArray2) {
            this.f36873b = new SparseArray<>();
            this.f36875d = sparseArray;
            this.f36876e = sparseArray2;
        }

        @Override // com.kwai.filedownloader.b.a.InterfaceC0440a
        public void a() {
            b bVar = this.f36874c;
            if (bVar != null) {
                bVar.b();
            }
            if (d.this.f36871a == null) {
                return;
            }
            int size = this.f36873b.size();
            try {
                try {
                    if (size < 0) {
                        return;
                    }
                    try {
                        d.this.f36871a.beginTransaction();
                        for (int i = 0; i < size; i++) {
                            int keyAt = this.f36873b.keyAt(i);
                            com.kwai.filedownloader.d.c cVar = this.f36873b.get(keyAt);
                            d.this.f36871a.delete("ksad_file_download", "_id = ?", new String[]{String.valueOf(keyAt)});
                            d.this.f36871a.insert("ksad_file_download", null, cVar.p());
                            if (cVar.n() > 1) {
                                List<com.kwai.filedownloader.d.a> c2 = d.this.c(keyAt);
                                if (c2.size() > 0) {
                                    d.this.f36871a.delete("ksad_file_download_connection", "id = ?", new String[]{String.valueOf(keyAt)});
                                    for (com.kwai.filedownloader.d.a aVar : c2) {
                                        aVar.a(cVar.a());
                                        d.this.f36871a.insert("ksad_file_download_connection", null, aVar.f());
                                    }
                                }
                            }
                        }
                        if (this.f36875d != null && this.f36876e != null) {
                            synchronized (this.f36875d) {
                                int size2 = this.f36875d.size();
                                for (int i2 = 0; i2 < size2; i2++) {
                                    int a2 = this.f36875d.valueAt(i2).a();
                                    List<com.kwai.filedownloader.d.a> c3 = d.this.c(a2);
                                    if (c3 != null && c3.size() > 0) {
                                        synchronized (this.f36876e) {
                                            this.f36876e.put(a2, c3);
                                        }
                                    }
                                }
                            }
                        }
                        d.this.f36871a.setTransactionSuccessful();
                        if (d.this.f36871a != null) {
                            d.this.f36871a.endTransaction();
                        }
                    } catch (SQLiteException e2) {
                        d.b(e2);
                        if (d.this.f36871a != null) {
                            d.this.f36871a.endTransaction();
                        }
                    } catch (Exception e3) {
                        d.b(e3);
                        if (d.this.f36871a != null) {
                            d.this.f36871a.endTransaction();
                        }
                    }
                } catch (Exception e4) {
                    d.b(e4);
                }
            } catch (Throwable th) {
                if (d.this.f36871a != null) {
                    try {
                        d.this.f36871a.endTransaction();
                    } catch (Exception e5) {
                        d.b(e5);
                    }
                }
                throw th;
            }
        }

        @Override // com.kwai.filedownloader.b.a.InterfaceC0440a
        public void a(int i, com.kwai.filedownloader.d.c cVar) {
            this.f36873b.put(i, cVar);
        }

        @Override // com.kwai.filedownloader.b.a.InterfaceC0440a
        public void a(com.kwai.filedownloader.d.c cVar) {
        }

        @Override // com.kwai.filedownloader.b.a.InterfaceC0440a
        public void b(com.kwai.filedownloader.d.c cVar) {
            SparseArray<com.kwai.filedownloader.d.c> sparseArray = this.f36875d;
            if (sparseArray != null) {
                synchronized (sparseArray) {
                    this.f36875d.put(cVar.a(), cVar);
                }
            }
        }

        @Override // java.lang.Iterable
        public Iterator<com.kwai.filedownloader.d.c> iterator() {
            b bVar = new b();
            this.f36874c = bVar;
            return bVar;
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Iterator<com.kwai.filedownloader.d.c> {

        /* renamed from: b  reason: collision with root package name */
        public Cursor f36878b;

        /* renamed from: c  reason: collision with root package name */
        public final List<Integer> f36879c = new ArrayList();

        /* renamed from: d  reason: collision with root package name */
        public int f36880d;

        public b() {
            if (d.this.f36871a != null) {
                try {
                    this.f36878b = d.this.f36871a.rawQuery("SELECT * FROM ksad_file_download", null);
                } catch (SQLiteException e2) {
                    d.b(e2);
                } catch (Exception e3) {
                    d.b(e3);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Iterator
        /* renamed from: a */
        public com.kwai.filedownloader.d.c next() {
            com.kwai.filedownloader.d.c b2 = d.b(this.f36878b);
            this.f36880d = b2.a();
            return b2;
        }

        public void b() {
            Cursor cursor;
            if (d.this.f36871a == null || (cursor = this.f36878b) == null) {
                return;
            }
            cursor.close();
            if (this.f36879c.isEmpty()) {
                return;
            }
            String join = TextUtils.join(StringUtil.ARRAY_ELEMENT_SEPARATOR, this.f36879c);
            if (com.kwai.filedownloader.f.d.f37011a) {
                com.kwai.filedownloader.f.d.c(this, "delete %s", join);
            }
            try {
                d.this.f36871a.execSQL(f.a("DELETE FROM %s WHERE %s IN (%s);", "ksad_file_download", "_id", join));
                d.this.f36871a.execSQL(f.a("DELETE FROM %s WHERE %s IN (%s);", "ksad_file_download_connection", "id", join));
            } catch (SQLiteException e2) {
                d.b(e2);
            } catch (Exception e3) {
                d.b(e3);
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            Cursor cursor = this.f36878b;
            if (cursor != null) {
                return cursor.moveToNext();
            }
            return false;
        }

        @Override // java.util.Iterator
        public void remove() {
            this.f36879c.add(Integer.valueOf(this.f36880d));
        }
    }

    public d() {
        try {
            this.f36871a = new e(com.kwai.filedownloader.f.c.a()).getWritableDatabase();
        } catch (SQLiteException e2) {
            b(e2);
        }
    }

    private void a(int i, ContentValues contentValues) {
        SQLiteDatabase sQLiteDatabase = this.f36871a;
        if (sQLiteDatabase != null) {
            try {
                sQLiteDatabase.update("ksad_file_download", contentValues, "_id = ? ", new String[]{String.valueOf(i)});
            } catch (SQLiteException e2) {
                b(e2);
            } catch (Exception e3) {
                b(e3);
            }
        }
    }

    public static com.kwai.filedownloader.d.c b(Cursor cursor) {
        com.kwai.filedownloader.d.c cVar = new com.kwai.filedownloader.d.c();
        if (cursor == null) {
            return cVar;
        }
        cVar.a(cursor.getInt(cursor.getColumnIndex("_id")));
        cVar.a(cursor.getString(cursor.getColumnIndex("url")));
        cVar.a(cursor.getString(cursor.getColumnIndex("path")), cursor.getShort(cursor.getColumnIndex("pathAsDirectory")) == 1);
        cVar.a((byte) cursor.getShort(cursor.getColumnIndex("status")));
        cVar.a(cursor.getLong(cursor.getColumnIndex("sofar")));
        cVar.c(cursor.getLong(cursor.getColumnIndex("total")));
        cVar.c(cursor.getString(cursor.getColumnIndex("errMsg")));
        cVar.b(cursor.getString(cursor.getColumnIndex("etag")));
        cVar.d(cursor.getString(cursor.getColumnIndex(BreakpointSQLiteKey.FILENAME)));
        cVar.b(cursor.getInt(cursor.getColumnIndex("connectionCount")));
        return cVar;
    }

    public static void b(@Nullable SQLiteException sQLiteException) {
        b((Throwable) sQLiteException);
        boolean z = sQLiteException instanceof SQLiteFullException;
    }

    public static void b(Throwable th) {
        if (th != null) {
            th.printStackTrace();
            com.kwad.sdk.core.a.a.a(th);
        }
    }

    public a.InterfaceC0440a a(SparseArray<com.kwai.filedownloader.d.c> sparseArray, SparseArray<List<com.kwai.filedownloader.d.a>> sparseArray2) {
        return new a(sparseArray, sparseArray2);
    }

    @Override // com.kwai.filedownloader.b.a
    public void a() {
        SQLiteDatabase sQLiteDatabase = this.f36871a;
        if (sQLiteDatabase != null) {
            try {
                sQLiteDatabase.delete("ksad_file_download", null, null);
            } catch (SQLiteException e2) {
                b(e2);
            }
            try {
                this.f36871a.delete("ksad_file_download_connection", null, null);
            } catch (SQLiteException e3) {
                b(e3);
            }
        }
    }

    @Override // com.kwai.filedownloader.b.a
    public void a(int i) {
    }

    @Override // com.kwai.filedownloader.b.a
    public void a(int i, int i2) {
        if (this.f36871a == null) {
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("connectionCount", Integer.valueOf(i2));
        try {
            this.f36871a.update("ksad_file_download", contentValues, "_id = ? ", new String[]{Integer.toString(i)});
        } catch (SQLiteException e2) {
            b(e2);
        } catch (Exception e3) {
            b(e3);
        }
    }

    @Override // com.kwai.filedownloader.b.a
    public void a(int i, int i2, long j) {
        if (this.f36871a == null) {
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("currentOffset", Long.valueOf(j));
        try {
            this.f36871a.update("ksad_file_download_connection", contentValues, "id = ? AND connectionIndex = ?", new String[]{Integer.toString(i), Integer.toString(i2)});
        } catch (SQLiteException e2) {
            b(e2);
        } catch (Exception e3) {
            b(e3);
        }
    }

    @Override // com.kwai.filedownloader.b.a
    public void a(int i, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Byte) (byte) 3);
        contentValues.put("sofar", Long.valueOf(j));
        a(i, contentValues);
    }

    @Override // com.kwai.filedownloader.b.a
    public void a(int i, long j, String str, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Byte) (byte) 2);
        contentValues.put("total", Long.valueOf(j));
        contentValues.put("etag", str);
        contentValues.put(BreakpointSQLiteKey.FILENAME, str2);
        a(i, contentValues);
    }

    @Override // com.kwai.filedownloader.b.a
    public void a(int i, String str, long j, long j2, int i2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("sofar", Long.valueOf(j));
        contentValues.put("total", Long.valueOf(j2));
        contentValues.put("etag", str);
        contentValues.put("connectionCount", Integer.valueOf(i2));
        a(i, contentValues);
    }

    @Override // com.kwai.filedownloader.b.a
    public void a(int i, Throwable th) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("errMsg", th.toString());
        contentValues.put("status", (Byte) (byte) 5);
        a(i, contentValues);
    }

    @Override // com.kwai.filedownloader.b.a
    public void a(int i, Throwable th, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("errMsg", th.toString());
        contentValues.put("status", (Byte) (byte) -1);
        contentValues.put("sofar", Long.valueOf(j));
        a(i, contentValues);
    }

    @Override // com.kwai.filedownloader.b.a
    public void a(com.kwai.filedownloader.d.a aVar) {
        SQLiteDatabase sQLiteDatabase;
        if (aVar == null || (sQLiteDatabase = this.f36871a) == null) {
            return;
        }
        try {
            sQLiteDatabase.insert("ksad_file_download_connection", null, aVar.f());
        } catch (SQLiteException e2) {
            b(e2);
        } catch (Exception e3) {
            b(e3);
        }
    }

    @Override // com.kwai.filedownloader.b.a
    public void a(com.kwai.filedownloader.d.c cVar) {
        if (this.f36871a == null) {
            return;
        }
        if (cVar == null) {
            com.kwai.filedownloader.f.d.d(this, "update but model == null!", new Object[0]);
        } else if (b(cVar.a()) == null) {
            b(cVar);
        } else {
            try {
                this.f36871a.update("ksad_file_download", cVar.p(), "_id = ? ", new String[]{String.valueOf(cVar.a())});
            } catch (SQLiteException e2) {
                b(e2);
            } catch (Exception e3) {
                b(e3);
            }
        }
    }

    @Override // com.kwai.filedownloader.b.a
    public a.InterfaceC0440a b() {
        return new a(this);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: int */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0035, code lost:
        if (r8 != null) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x004b, code lost:
        if (r8 == null) goto L17;
     */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.kwai.filedownloader.b.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public com.kwai.filedownloader.d.c b(int i) {
        Cursor cursor;
        SQLiteDatabase sQLiteDatabase = this.f36871a;
        Cursor cursor2 = null;
        try {
            if (sQLiteDatabase == null) {
                return null;
            }
            try {
                cursor = sQLiteDatabase.rawQuery(f.a("SELECT * FROM %s WHERE %s = ?", "ksad_file_download", "_id"), new String[]{Integer.toString(i)});
                try {
                    if (cursor.moveToNext()) {
                        com.kwai.filedownloader.d.c b2 = b(cursor);
                        if (cursor != null) {
                            cursor.close();
                        }
                        return b2;
                    }
                } catch (SQLiteException e2) {
                    e = e2;
                    b(e);
                } catch (Exception e3) {
                    e = e3;
                    b(e);
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                }
            } catch (SQLiteException e4) {
                e = e4;
                cursor = null;
            } catch (Exception e5) {
                e = e5;
                cursor = null;
            } catch (Throwable th) {
                th = th;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            cursor2 = i;
        }
    }

    @Override // com.kwai.filedownloader.b.a
    public void b(int i, long j) {
        e(i);
    }

    public void b(com.kwai.filedownloader.d.c cVar) {
        SQLiteDatabase sQLiteDatabase = this.f36871a;
        if (sQLiteDatabase != null) {
            try {
                sQLiteDatabase.insert("ksad_file_download", null, cVar.p());
            } catch (SQLiteException e2) {
                b(e2);
            } catch (Exception e3) {
                b(e3);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0070, code lost:
        if (r2 != null) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0080, code lost:
        if (r2 == null) goto L13;
     */
    @Override // com.kwai.filedownloader.b.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<com.kwai.filedownloader.d.a> c(int i) {
        ArrayList arrayList = new ArrayList();
        SQLiteDatabase sQLiteDatabase = this.f36871a;
        if (sQLiteDatabase == null) {
            return arrayList;
        }
        Cursor cursor = null;
        try {
            try {
                try {
                    cursor = sQLiteDatabase.rawQuery(f.a("SELECT * FROM %s WHERE %s = ?", "ksad_file_download_connection", "id"), new String[]{Integer.toString(i)});
                    while (cursor.moveToNext()) {
                        com.kwai.filedownloader.d.a aVar = new com.kwai.filedownloader.d.a();
                        aVar.a(i);
                        aVar.b(cursor.getInt(cursor.getColumnIndex("connectionIndex")));
                        aVar.a(cursor.getLong(cursor.getColumnIndex("startOffset")));
                        aVar.b(cursor.getLong(cursor.getColumnIndex("currentOffset")));
                        aVar.c(cursor.getLong(cursor.getColumnIndex("endOffset")));
                        arrayList.add(aVar);
                    }
                } catch (Exception e2) {
                    b(e2);
                    if (cursor != null) {
                        cursor.close();
                    }
                    return arrayList;
                }
            } catch (SQLiteException e3) {
                b(e3);
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    @Override // com.kwai.filedownloader.b.a
    public void c(int i, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Byte) (byte) -2);
        contentValues.put("sofar", Long.valueOf(j));
        a(i, contentValues);
    }

    @Override // com.kwai.filedownloader.b.a
    public void d(int i) {
        SQLiteDatabase sQLiteDatabase = this.f36871a;
        if (sQLiteDatabase == null) {
            return;
        }
        try {
            sQLiteDatabase.execSQL("DELETE FROM ksad_file_download_connection WHERE id = " + i);
        } catch (SQLiteException e2) {
            b(e2);
        } catch (Exception e3) {
            b(e3);
        }
    }

    @Override // com.kwai.filedownloader.b.a
    public boolean e(int i) {
        SQLiteDatabase sQLiteDatabase = this.f36871a;
        if (sQLiteDatabase == null) {
            return false;
        }
        try {
            return sQLiteDatabase.delete("ksad_file_download", "_id = ?", new String[]{String.valueOf(i)}) != 0;
        } catch (SQLiteException e2) {
            b(e2);
            return false;
        } catch (Exception e3) {
            b(e3);
            return false;
        }
    }

    @Override // com.kwai.filedownloader.b.a
    public void f(int i) {
    }
}

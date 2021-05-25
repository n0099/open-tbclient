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
import com.kwai.filedownloader.b.a;
import com.kwai.filedownloader.f.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes6.dex */
public class d implements com.kwai.filedownloader.b.a {

    /* renamed from: b  reason: collision with root package name */
    public static boolean f34145b = false;

    /* renamed from: a  reason: collision with root package name */
    public SQLiteDatabase f34146a;

    /* loaded from: classes6.dex */
    public class a implements a.InterfaceC0391a {

        /* renamed from: b  reason: collision with root package name */
        public final SparseArray<com.kwai.filedownloader.d.c> f34148b;

        /* renamed from: c  reason: collision with root package name */
        public b f34149c;

        /* renamed from: d  reason: collision with root package name */
        public final SparseArray<com.kwai.filedownloader.d.c> f34150d;

        /* renamed from: e  reason: collision with root package name */
        public final SparseArray<List<com.kwai.filedownloader.d.a>> f34151e;

        public a(d dVar) {
            this(null, null);
        }

        public a(SparseArray<com.kwai.filedownloader.d.c> sparseArray, SparseArray<List<com.kwai.filedownloader.d.a>> sparseArray2) {
            this.f34148b = new SparseArray<>();
            this.f34150d = sparseArray;
            this.f34151e = sparseArray2;
        }

        @Override // com.kwai.filedownloader.b.a.InterfaceC0391a
        public void a() {
            b bVar = this.f34149c;
            if (bVar != null) {
                bVar.b();
            }
            if (d.this.f34146a == null) {
                return;
            }
            int size = this.f34148b.size();
            try {
                try {
                    if (size < 0) {
                        return;
                    }
                    try {
                        d.this.f34146a.beginTransaction();
                        for (int i2 = 0; i2 < size; i2++) {
                            int keyAt = this.f34148b.keyAt(i2);
                            com.kwai.filedownloader.d.c cVar = this.f34148b.get(keyAt);
                            d.this.f34146a.delete("ksad_file_download", "_id = ?", new String[]{String.valueOf(keyAt)});
                            d.this.f34146a.insert("ksad_file_download", null, cVar.p());
                            if (cVar.n() > 1) {
                                List<com.kwai.filedownloader.d.a> c2 = d.this.c(keyAt);
                                if (c2.size() > 0) {
                                    d.this.f34146a.delete("ksad_file_download_connection", "id = ?", new String[]{String.valueOf(keyAt)});
                                    for (com.kwai.filedownloader.d.a aVar : c2) {
                                        aVar.a(cVar.a());
                                        d.this.f34146a.insert("ksad_file_download_connection", null, aVar.f());
                                    }
                                }
                            }
                        }
                        if (this.f34150d != null && this.f34151e != null) {
                            synchronized (this.f34150d) {
                                int size2 = this.f34150d.size();
                                for (int i3 = 0; i3 < size2; i3++) {
                                    int a2 = this.f34150d.valueAt(i3).a();
                                    List<com.kwai.filedownloader.d.a> c3 = d.this.c(a2);
                                    if (c3 != null && c3.size() > 0) {
                                        synchronized (this.f34151e) {
                                            this.f34151e.put(a2, c3);
                                        }
                                    }
                                }
                            }
                        }
                        d.this.f34146a.setTransactionSuccessful();
                    } catch (SQLiteException e2) {
                        d.this.a(e2);
                        if (d.this.f34146a == null) {
                            return;
                        }
                        d.this.f34146a.endTransaction();
                    } catch (Exception e3) {
                        d.b(e3);
                        if (d.this.f34146a == null) {
                            return;
                        }
                        d.this.f34146a.endTransaction();
                    }
                    if (d.this.f34146a != null) {
                        d.this.f34146a.endTransaction();
                    }
                } catch (Throwable th) {
                    if (d.this.f34146a != null) {
                        try {
                            d.this.f34146a.endTransaction();
                        } catch (Exception e4) {
                            d.b(e4);
                        }
                    }
                    throw th;
                }
            } catch (Exception e5) {
                d.b(e5);
            }
        }

        @Override // com.kwai.filedownloader.b.a.InterfaceC0391a
        public void a(int i2, com.kwai.filedownloader.d.c cVar) {
            this.f34148b.put(i2, cVar);
        }

        @Override // com.kwai.filedownloader.b.a.InterfaceC0391a
        public void a(com.kwai.filedownloader.d.c cVar) {
        }

        @Override // com.kwai.filedownloader.b.a.InterfaceC0391a
        public void b(com.kwai.filedownloader.d.c cVar) {
            SparseArray<com.kwai.filedownloader.d.c> sparseArray = this.f34150d;
            if (sparseArray != null) {
                synchronized (sparseArray) {
                    this.f34150d.put(cVar.a(), cVar);
                }
            }
        }

        @Override // java.lang.Iterable
        public Iterator<com.kwai.filedownloader.d.c> iterator() {
            b bVar = new b();
            this.f34149c = bVar;
            return bVar;
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Iterator<com.kwai.filedownloader.d.c> {

        /* renamed from: b  reason: collision with root package name */
        public Cursor f34153b;

        /* renamed from: c  reason: collision with root package name */
        public final List<Integer> f34154c = new ArrayList();

        /* renamed from: d  reason: collision with root package name */
        public int f34155d;

        public b() {
            if (d.this.f34146a != null) {
                try {
                    this.f34153b = d.this.f34146a.rawQuery("SELECT * FROM ksad_file_download", null);
                } catch (SQLiteException e2) {
                    d.this.a(e2);
                } catch (Exception e3) {
                    d.b(e3);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Iterator
        /* renamed from: a */
        public com.kwai.filedownloader.d.c next() {
            com.kwai.filedownloader.d.c b2 = d.b(this.f34153b);
            this.f34155d = b2.a();
            return b2;
        }

        public void b() {
            Cursor cursor;
            if (d.this.f34146a == null || (cursor = this.f34153b) == null) {
                return;
            }
            cursor.close();
            if (this.f34154c.isEmpty()) {
                return;
            }
            String join = TextUtils.join(StringUtil.ARRAY_ELEMENT_SEPARATOR, this.f34154c);
            if (com.kwai.filedownloader.f.d.f34292a) {
                com.kwai.filedownloader.f.d.c(this, "delete %s", join);
            }
            try {
                d.this.f34146a.execSQL(f.a("DELETE FROM %s WHERE %s IN (%s);", "ksad_file_download", "_id", join));
                d.this.f34146a.execSQL(f.a("DELETE FROM %s WHERE %s IN (%s);", "ksad_file_download_connection", "id", join));
            } catch (SQLiteException e2) {
                d.this.a(e2);
            } catch (Exception e3) {
                d.b(e3);
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            Cursor cursor = this.f34153b;
            if (cursor != null) {
                return cursor.moveToNext();
            }
            return false;
        }

        @Override // java.util.Iterator
        public void remove() {
            this.f34154c.add(Integer.valueOf(this.f34155d));
        }
    }

    public d() {
        try {
            this.f34146a = new e(com.kwai.filedownloader.f.c.a()).getWritableDatabase();
        } catch (SQLiteException e2) {
            a(e2);
        }
    }

    private void a(int i2, ContentValues contentValues) {
        SQLiteDatabase sQLiteDatabase = this.f34146a;
        if (sQLiteDatabase != null) {
            try {
                sQLiteDatabase.update("ksad_file_download", contentValues, "_id = ? ", new String[]{String.valueOf(i2)});
            } catch (SQLiteException e2) {
                a(i2, e2);
            } catch (Exception e3) {
                b(e3);
            }
        }
    }

    private void a(int i2, @Nullable SQLiteException sQLiteException) {
        if (!(sQLiteException instanceof SQLiteFullException)) {
            b(sQLiteException);
            return;
        }
        if (i2 != -1) {
            e(i2);
            d(i2);
        }
        a(sQLiteException, !f34145b);
        f34145b = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SQLiteException sQLiteException) {
        a(-1, sQLiteException);
    }

    public static void a(Throwable th, boolean z) {
        if (th != null) {
            th.printStackTrace();
            if (z) {
                com.kwad.sdk.core.a.a.a(th);
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
        cVar.d(cursor.getString(cursor.getColumnIndex("filename")));
        cVar.b(cursor.getInt(cursor.getColumnIndex("connectionCount")));
        return cVar;
    }

    public static void b(Throwable th) {
        a(th, true);
    }

    public a.InterfaceC0391a a(SparseArray<com.kwai.filedownloader.d.c> sparseArray, SparseArray<List<com.kwai.filedownloader.d.a>> sparseArray2) {
        return new a(sparseArray, sparseArray2);
    }

    @Override // com.kwai.filedownloader.b.a
    public void a() {
        SQLiteDatabase sQLiteDatabase = this.f34146a;
        if (sQLiteDatabase != null) {
            try {
                sQLiteDatabase.delete("ksad_file_download", null, null);
            } catch (SQLiteException e2) {
                a(e2);
            }
            try {
                this.f34146a.delete("ksad_file_download_connection", null, null);
            } catch (SQLiteException e3) {
                a(e3);
            }
        }
    }

    @Override // com.kwai.filedownloader.b.a
    public void a(int i2) {
    }

    @Override // com.kwai.filedownloader.b.a
    public void a(int i2, int i3) {
        if (this.f34146a == null) {
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("connectionCount", Integer.valueOf(i3));
        try {
            this.f34146a.update("ksad_file_download", contentValues, "_id = ? ", new String[]{Integer.toString(i2)});
        } catch (SQLiteException e2) {
            a(i2, e2);
        } catch (Exception e3) {
            b(e3);
        }
    }

    @Override // com.kwai.filedownloader.b.a
    public void a(int i2, int i3, long j) {
        if (this.f34146a == null) {
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("currentOffset", Long.valueOf(j));
        try {
            this.f34146a.update("ksad_file_download_connection", contentValues, "id = ? AND connectionIndex = ?", new String[]{Integer.toString(i2), Integer.toString(i3)});
        } catch (SQLiteException e2) {
            a(i2, e2);
        } catch (Exception e3) {
            b(e3);
        }
    }

    @Override // com.kwai.filedownloader.b.a
    public void a(int i2, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Byte) (byte) 3);
        contentValues.put("sofar", Long.valueOf(j));
        a(i2, contentValues);
    }

    @Override // com.kwai.filedownloader.b.a
    public void a(int i2, long j, String str, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Byte) (byte) 2);
        contentValues.put("total", Long.valueOf(j));
        contentValues.put("etag", str);
        contentValues.put("filename", str2);
        a(i2, contentValues);
    }

    @Override // com.kwai.filedownloader.b.a
    public void a(int i2, String str, long j, long j2, int i3) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("sofar", Long.valueOf(j));
        contentValues.put("total", Long.valueOf(j2));
        contentValues.put("etag", str);
        contentValues.put("connectionCount", Integer.valueOf(i3));
        a(i2, contentValues);
    }

    @Override // com.kwai.filedownloader.b.a
    public void a(int i2, Throwable th) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("errMsg", th.toString());
        contentValues.put("status", (Byte) (byte) 5);
        a(i2, contentValues);
    }

    @Override // com.kwai.filedownloader.b.a
    public void a(int i2, Throwable th, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("errMsg", th.toString());
        contentValues.put("status", (Byte) (byte) -1);
        contentValues.put("sofar", Long.valueOf(j));
        a(i2, contentValues);
    }

    @Override // com.kwai.filedownloader.b.a
    public void a(com.kwai.filedownloader.d.a aVar) {
        SQLiteDatabase sQLiteDatabase;
        if (aVar == null || (sQLiteDatabase = this.f34146a) == null) {
            return;
        }
        try {
            sQLiteDatabase.insert("ksad_file_download_connection", null, aVar.f());
        } catch (SQLiteException e2) {
            a(aVar.a(), e2);
        } catch (Exception e3) {
            b(e3);
        }
    }

    @Override // com.kwai.filedownloader.b.a
    public void a(com.kwai.filedownloader.d.c cVar) {
        if (this.f34146a == null) {
            return;
        }
        if (cVar == null) {
            com.kwai.filedownloader.f.d.d(this, "update but model == null!", new Object[0]);
        } else if (b(cVar.a()) == null) {
            b(cVar);
        } else {
            try {
                this.f34146a.update("ksad_file_download", cVar.p(), "_id = ? ", new String[]{String.valueOf(cVar.a())});
            } catch (SQLiteException e2) {
                cVar.c(e2.toString());
                cVar.a((byte) -1);
                a(cVar.a(), e2);
            } catch (Exception e3) {
                b(e3);
            }
        }
    }

    @Override // com.kwai.filedownloader.b.a
    public a.InterfaceC0391a b() {
        return new a(this);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:18:0x003c */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0035, code lost:
        if (r0 != null) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x004b, code lost:
        if (r0 == null) goto L17;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [android.database.Cursor] */
    @Override // com.kwai.filedownloader.b.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public com.kwai.filedownloader.d.c b(int i2) {
        Cursor cursor;
        SQLiteDatabase sQLiteDatabase = this.f34146a;
        ?? r1 = 0;
        try {
            if (sQLiteDatabase == null) {
                return null;
            }
            try {
                cursor = sQLiteDatabase.rawQuery(f.a("SELECT * FROM %s WHERE %s = ?", "ksad_file_download", "_id"), new String[]{Integer.toString(i2)});
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
                    a(i2, e);
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
                if (r1 != 0) {
                    r1.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            r1 = sQLiteDatabase;
        }
    }

    @Override // com.kwai.filedownloader.b.a
    public void b(int i2, long j) {
        e(i2);
    }

    public void b(com.kwai.filedownloader.d.c cVar) {
        SQLiteDatabase sQLiteDatabase = this.f34146a;
        if (sQLiteDatabase != null) {
            try {
                sQLiteDatabase.insert("ksad_file_download", null, cVar.p());
            } catch (SQLiteException e2) {
                cVar.c(e2.toString());
                cVar.a((byte) -1);
                a(cVar.a(), e2);
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
    public List<com.kwai.filedownloader.d.a> c(int i2) {
        ArrayList arrayList = new ArrayList();
        SQLiteDatabase sQLiteDatabase = this.f34146a;
        if (sQLiteDatabase == null) {
            return arrayList;
        }
        Cursor cursor = null;
        try {
            try {
                try {
                    cursor = sQLiteDatabase.rawQuery(f.a("SELECT * FROM %s WHERE %s = ?", "ksad_file_download_connection", "id"), new String[]{Integer.toString(i2)});
                    while (cursor.moveToNext()) {
                        com.kwai.filedownloader.d.a aVar = new com.kwai.filedownloader.d.a();
                        aVar.a(i2);
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
                a(i2, e3);
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    @Override // com.kwai.filedownloader.b.a
    public void c(int i2, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Byte) (byte) -2);
        contentValues.put("sofar", Long.valueOf(j));
        a(i2, contentValues);
    }

    @Override // com.kwai.filedownloader.b.a
    public void d(int i2) {
        SQLiteDatabase sQLiteDatabase = this.f34146a;
        if (sQLiteDatabase == null) {
            return;
        }
        try {
            sQLiteDatabase.execSQL("DELETE FROM ksad_file_download_connection WHERE id = " + i2);
        } catch (SQLiteException | Exception e2) {
            b(e2);
        }
    }

    @Override // com.kwai.filedownloader.b.a
    public boolean e(int i2) {
        SQLiteDatabase sQLiteDatabase = this.f34146a;
        if (sQLiteDatabase == null) {
            return false;
        }
        try {
            return sQLiteDatabase.delete("ksad_file_download", "_id = ?", new String[]{String.valueOf(i2)}) != 0;
        } catch (SQLiteException | Exception e2) {
            b(e2);
            return false;
        }
    }

    @Override // com.kwai.filedownloader.b.a
    public void f(int i2) {
    }
}

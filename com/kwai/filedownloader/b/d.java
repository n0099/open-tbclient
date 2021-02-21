package com.kwai.filedownloader.b;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.IMConstants;
import com.kwai.filedownloader.b.a;
import com.kwai.filedownloader.f.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class d implements com.kwai.filedownloader.b.a {

    /* renamed from: a  reason: collision with root package name */
    private SQLiteDatabase f10875a;

    /* loaded from: classes3.dex */
    public class a implements a.InterfaceC1156a {

        /* renamed from: b  reason: collision with root package name */
        private final SparseArray<com.kwai.filedownloader.d.c> f10877b;
        private b c;
        private final SparseArray<com.kwai.filedownloader.d.c> d;
        private final SparseArray<List<com.kwai.filedownloader.d.a>> e;

        a(d dVar) {
            this(null, null);
        }

        a(SparseArray<com.kwai.filedownloader.d.c> sparseArray, SparseArray<List<com.kwai.filedownloader.d.a>> sparseArray2) {
            this.f10877b = new SparseArray<>();
            this.d = sparseArray;
            this.e = sparseArray2;
        }

        @Override // com.kwai.filedownloader.b.a.InterfaceC1156a
        public void a() {
            if (this.c != null) {
                this.c.b();
            }
            if (d.this.f10875a == null) {
                return;
            }
            int size = this.f10877b.size();
            try {
                if (size >= 0) {
                    try {
                        d.this.f10875a.beginTransaction();
                        for (int i = 0; i < size; i++) {
                            int keyAt = this.f10877b.keyAt(i);
                            com.kwai.filedownloader.d.c cVar = this.f10877b.get(keyAt);
                            d.this.f10875a.delete("ksad_file_download", "_id = ?", new String[]{String.valueOf(keyAt)});
                            d.this.f10875a.insert("ksad_file_download", null, cVar.p());
                            if (cVar.n() > 1) {
                                List<com.kwai.filedownloader.d.a> c = d.this.c(keyAt);
                                if (c.size() > 0) {
                                    d.this.f10875a.delete("ksad_file_download_connection", "id = ?", new String[]{String.valueOf(keyAt)});
                                    for (com.kwai.filedownloader.d.a aVar : c) {
                                        aVar.a(cVar.a());
                                        d.this.f10875a.insert("ksad_file_download_connection", null, aVar.f());
                                    }
                                }
                            }
                        }
                        if (this.d != null && this.e != null) {
                            synchronized (this.d) {
                                int size2 = this.d.size();
                                for (int i2 = 0; i2 < size2; i2++) {
                                    int a2 = this.d.valueAt(i2).a();
                                    List<com.kwai.filedownloader.d.a> c2 = d.this.c(a2);
                                    if (c2 != null && c2.size() > 0) {
                                        synchronized (this.e) {
                                            this.e.put(a2, c2);
                                        }
                                    }
                                }
                            }
                        }
                        d.this.f10875a.setTransactionSuccessful();
                        if (d.this.f10875a != null) {
                            try {
                                d.this.f10875a.endTransaction();
                            } catch (Exception e) {
                                d.b(e);
                            }
                        }
                    } catch (SQLiteException e2) {
                        d.b(e2);
                        if (d.this.f10875a != null) {
                            try {
                                d.this.f10875a.endTransaction();
                            } catch (Exception e3) {
                                d.b(e3);
                            }
                        }
                    } catch (Exception e4) {
                        d.b(e4);
                        if (d.this.f10875a != null) {
                            try {
                                d.this.f10875a.endTransaction();
                            } catch (Exception e5) {
                                d.b(e5);
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                if (d.this.f10875a != null) {
                    try {
                        d.this.f10875a.endTransaction();
                    } catch (Exception e6) {
                        d.b(e6);
                    }
                }
                throw th;
            }
        }

        @Override // com.kwai.filedownloader.b.a.InterfaceC1156a
        public void a(int i, com.kwai.filedownloader.d.c cVar) {
            this.f10877b.put(i, cVar);
        }

        @Override // com.kwai.filedownloader.b.a.InterfaceC1156a
        public void a(com.kwai.filedownloader.d.c cVar) {
        }

        @Override // com.kwai.filedownloader.b.a.InterfaceC1156a
        public void b(com.kwai.filedownloader.d.c cVar) {
            if (this.d != null) {
                synchronized (this.d) {
                    this.d.put(cVar.a(), cVar);
                }
            }
        }

        @Override // java.lang.Iterable
        public Iterator<com.kwai.filedownloader.d.c> iterator() {
            b bVar = new b();
            this.c = bVar;
            return bVar;
        }
    }

    /* loaded from: classes3.dex */
    class b implements Iterator<com.kwai.filedownloader.d.c> {

        /* renamed from: b  reason: collision with root package name */
        private Cursor f10879b;
        private final List<Integer> c = new ArrayList();
        private int d;

        b() {
            if (d.this.f10875a != null) {
                try {
                    this.f10879b = d.this.f10875a.rawQuery("SELECT * FROM ksad_file_download", null);
                } catch (SQLiteException e) {
                    d.b(e);
                } catch (Exception e2) {
                    d.b(e2);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Iterator
        /* renamed from: a */
        public com.kwai.filedownloader.d.c next() {
            com.kwai.filedownloader.d.c b2 = d.b(this.f10879b);
            this.d = b2.a();
            return b2;
        }

        void b() {
            if (d.this.f10875a == null || this.f10879b == null) {
                return;
            }
            this.f10879b.close();
            if (this.c.isEmpty()) {
                return;
            }
            String join = TextUtils.join(", ", this.c);
            if (com.kwai.filedownloader.f.d.f10930a) {
                com.kwai.filedownloader.f.d.c(this, "delete %s", join);
            }
            try {
                d.this.f10875a.execSQL(f.a("DELETE FROM %s WHERE %s IN (%s);", "ksad_file_download", IMConstants.MSG_ROW_ID, join));
                d.this.f10875a.execSQL(f.a("DELETE FROM %s WHERE %s IN (%s);", "ksad_file_download_connection", "id", join));
            } catch (SQLiteException e) {
                d.b(e);
            } catch (Exception e2) {
                d.b(e2);
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f10879b != null) {
                return this.f10879b.moveToNext();
            }
            return false;
        }

        @Override // java.util.Iterator
        public void remove() {
            this.c.add(Integer.valueOf(this.d));
        }
    }

    public d() {
        try {
            this.f10875a = new e(com.kwai.filedownloader.f.c.a()).getWritableDatabase();
        } catch (SQLiteException e) {
            b(e);
        }
    }

    private void a(int i, ContentValues contentValues) {
        if (this.f10875a != null) {
            try {
                this.f10875a.update("ksad_file_download", contentValues, "_id = ? ", new String[]{String.valueOf(i)});
            } catch (SQLiteException e) {
                b(e);
            } catch (Exception e2) {
                b(e2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static com.kwai.filedownloader.d.c b(Cursor cursor) {
        com.kwai.filedownloader.d.c cVar = new com.kwai.filedownloader.d.c();
        if (cursor == null) {
            return cVar;
        }
        cVar.a(cursor.getInt(cursor.getColumnIndex(IMConstants.MSG_ROW_ID)));
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

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(@Nullable SQLiteException sQLiteException) {
        b((Throwable) sQLiteException);
        if (sQLiteException instanceof SQLiteFullException) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Throwable th) {
        if (th != null) {
            th.printStackTrace();
            com.kwad.sdk.core.a.a.a(th);
        }
    }

    public a.InterfaceC1156a a(SparseArray<com.kwai.filedownloader.d.c> sparseArray, SparseArray<List<com.kwai.filedownloader.d.a>> sparseArray2) {
        return new a(sparseArray, sparseArray2);
    }

    @Override // com.kwai.filedownloader.b.a
    public void a() {
        if (this.f10875a != null) {
            try {
                this.f10875a.delete("ksad_file_download", null, null);
            } catch (SQLiteException e) {
                b(e);
            }
            try {
                this.f10875a.delete("ksad_file_download_connection", null, null);
            } catch (SQLiteException e2) {
                b(e2);
            }
        }
    }

    @Override // com.kwai.filedownloader.b.a
    public void a(int i) {
    }

    @Override // com.kwai.filedownloader.b.a
    public void a(int i, int i2) {
        if (this.f10875a == null) {
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("connectionCount", Integer.valueOf(i2));
        try {
            this.f10875a.update("ksad_file_download", contentValues, "_id = ? ", new String[]{Integer.toString(i)});
        } catch (SQLiteException e) {
            b(e);
        } catch (Exception e2) {
            b(e2);
        }
    }

    @Override // com.kwai.filedownloader.b.a
    public void a(int i, int i2, long j) {
        if (this.f10875a == null) {
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("currentOffset", Long.valueOf(j));
        try {
            this.f10875a.update("ksad_file_download_connection", contentValues, "id = ? AND connectionIndex = ?", new String[]{Integer.toString(i), Integer.toString(i2)});
        } catch (SQLiteException e) {
            b(e);
        } catch (Exception e2) {
            b(e2);
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
        contentValues.put("filename", str2);
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
        if (aVar == null || this.f10875a == null) {
            return;
        }
        try {
            this.f10875a.insert("ksad_file_download_connection", null, aVar.f());
        } catch (SQLiteException e) {
            b(e);
        } catch (Exception e2) {
            b(e2);
        }
    }

    @Override // com.kwai.filedownloader.b.a
    public void a(com.kwai.filedownloader.d.c cVar) {
        if (this.f10875a == null) {
            return;
        }
        if (cVar == null) {
            com.kwai.filedownloader.f.d.d(this, "update but model == null!", new Object[0]);
        } else if (b(cVar.a()) == null) {
            b(cVar);
        } else {
            try {
                this.f10875a.update("ksad_file_download", cVar.p(), "_id = ? ", new String[]{String.valueOf(cVar.a())});
            } catch (SQLiteException e) {
                b(e);
            } catch (Exception e2) {
                b(e2);
            }
        }
    }

    @Override // com.kwai.filedownloader.b.a
    public a.InterfaceC1156a b() {
        return new a(this);
    }

    @Override // com.kwai.filedownloader.b.a
    public com.kwai.filedownloader.d.c b(int i) {
        Throwable th;
        Cursor cursor;
        com.kwai.filedownloader.d.c cVar = null;
        try {
            if (this.f10875a != null) {
                try {
                    cursor = this.f10875a.rawQuery(f.a("SELECT * FROM %s WHERE %s = ?", "ksad_file_download", IMConstants.MSG_ROW_ID), new String[]{Integer.toString(i)});
                    try {
                        if (cursor.moveToNext()) {
                            cVar = b(cursor);
                            if (cursor != null) {
                                cursor.close();
                            }
                        } else if (cursor != null) {
                            cursor.close();
                        }
                    } catch (SQLiteException e) {
                        e = e;
                        b(e);
                        if (cursor != null) {
                            cursor.close();
                        }
                        return cVar;
                    } catch (Exception e2) {
                        e = e2;
                        b(e);
                        if (cursor != null) {
                            cursor.close();
                        }
                        return cVar;
                    }
                } catch (SQLiteException e3) {
                    e = e3;
                    cursor = null;
                } catch (Exception e4) {
                    e = e4;
                    cursor = null;
                } catch (Throwable th2) {
                    th = th2;
                    cursor = null;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
            return cVar;
        } catch (Throwable th3) {
            th = th3;
        }
    }

    @Override // com.kwai.filedownloader.b.a
    public void b(int i, long j) {
        e(i);
    }

    public void b(com.kwai.filedownloader.d.c cVar) {
        if (this.f10875a != null) {
            try {
                this.f10875a.insert("ksad_file_download", null, cVar.p());
            } catch (SQLiteException e) {
                b(e);
            } catch (Exception e2) {
                b(e2);
            }
        }
    }

    @Override // com.kwai.filedownloader.b.a
    public List<com.kwai.filedownloader.d.a> c(int i) {
        ArrayList arrayList = new ArrayList();
        if (this.f10875a != null) {
            Cursor cursor = null;
            try {
                try {
                    cursor = this.f10875a.rawQuery(f.a("SELECT * FROM %s WHERE %s = ?", "ksad_file_download_connection", "id"), new String[]{Integer.toString(i)});
                    while (cursor.moveToNext()) {
                        com.kwai.filedownloader.d.a aVar = new com.kwai.filedownloader.d.a();
                        aVar.a(i);
                        aVar.b(cursor.getInt(cursor.getColumnIndex("connectionIndex")));
                        aVar.a(cursor.getLong(cursor.getColumnIndex("startOffset")));
                        aVar.b(cursor.getLong(cursor.getColumnIndex("currentOffset")));
                        aVar.c(cursor.getLong(cursor.getColumnIndex("endOffset")));
                        arrayList.add(aVar);
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                } catch (SQLiteException e) {
                    b(e);
                    if (cursor != null) {
                        cursor.close();
                    }
                } catch (Exception e2) {
                    b(e2);
                    if (cursor != null) {
                        cursor.close();
                    }
                }
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        }
        return arrayList;
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
        if (this.f10875a == null) {
            return;
        }
        try {
            this.f10875a.execSQL("DELETE FROM ksad_file_download_connection WHERE id = " + i);
        } catch (SQLiteException e) {
            b(e);
        } catch (Exception e2) {
            b(e2);
        }
    }

    @Override // com.kwai.filedownloader.b.a
    public boolean e(int i) {
        if (this.f10875a == null) {
            return false;
        }
        try {
            return this.f10875a.delete("ksad_file_download", "_id = ?", new String[]{String.valueOf(i)}) != 0;
        } catch (SQLiteException e) {
            b(e);
            return false;
        } catch (Exception e2) {
            b(e2);
            return false;
        }
    }

    @Override // com.kwai.filedownloader.b.a
    public void f(int i) {
    }
}

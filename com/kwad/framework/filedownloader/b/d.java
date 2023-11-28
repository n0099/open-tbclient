package com.kwad.framework.filedownloader.b;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.searchbox.bddownload.core.breakpoint.sqlite.BreakpointSQLiteKey;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.kwad.framework.filedownloader.b.a;
import com.kwad.framework.filedownloader.f.f;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes10.dex */
public final class d implements com.kwad.framework.filedownloader.b.a {
    public static boolean afi;
    public final e afj = new e(com.kwad.framework.filedownloader.f.c.wB());
    public SQLiteDatabase afk;

    @Override // com.kwad.framework.filedownloader.b.a
    public final void be(int i) {
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void bj(int i) {
    }

    /* loaded from: classes10.dex */
    public class a implements a.InterfaceC0678a {
        public final SparseArray<com.kwad.framework.filedownloader.d.c> aeY;
        public final SparseArray<List<com.kwad.framework.filedownloader.d.a>> aeZ;
        public final SparseArray<com.kwad.framework.filedownloader.d.c> afl = new SparseArray<>();
        public b afm;

        public a(SparseArray<com.kwad.framework.filedownloader.d.c> sparseArray, SparseArray<List<com.kwad.framework.filedownloader.d.a>> sparseArray2) {
            this.aeY = sparseArray;
            this.aeZ = sparseArray2;
        }

        @Override // com.kwad.framework.filedownloader.b.a.InterfaceC0678a
        public final void a(int i, com.kwad.framework.filedownloader.d.c cVar) {
            this.afl.put(i, cVar);
        }

        @Override // com.kwad.framework.filedownloader.b.a.InterfaceC0678a
        public final void c(com.kwad.framework.filedownloader.d.c cVar) {
            SparseArray<com.kwad.framework.filedownloader.d.c> sparseArray = this.aeY;
            if (sparseArray != null) {
                synchronized (sparseArray) {
                    this.aeY.put(cVar.getId(), cVar);
                }
            }
        }

        @Override // java.lang.Iterable
        public final Iterator<com.kwad.framework.filedownloader.d.c> iterator() {
            b bVar = new b();
            this.afm = bVar;
            return bVar;
        }

        @Override // com.kwad.framework.filedownloader.b.a.InterfaceC0678a
        public final void uW() {
            b bVar = this.afm;
            if (bVar != null) {
                bVar.uW();
            }
            try {
                SQLiteDatabase uX = d.this.uX();
                if (uX == null) {
                    return;
                }
                int size = this.afl.size();
                try {
                    if (size < 0) {
                        return;
                    }
                    try {
                        uX.beginTransaction();
                        for (int i = 0; i < size; i++) {
                            int keyAt = this.afl.keyAt(i);
                            com.kwad.framework.filedownloader.d.c cVar = this.afl.get(keyAt);
                            uX.delete("ksad_file_download", "_id = ?", new String[]{String.valueOf(keyAt)});
                            uX.insert("ksad_file_download", null, cVar.vZ());
                            if (cVar.we() > 1) {
                                List<com.kwad.framework.filedownloader.d.a> bg = d.this.bg(keyAt);
                                if (bg.size() > 0) {
                                    uX.delete("ksad_file_download_connection", "id = ?", new String[]{String.valueOf(keyAt)});
                                    for (com.kwad.framework.filedownloader.d.a aVar : bg) {
                                        aVar.setId(cVar.getId());
                                        uX.insert("ksad_file_download_connection", null, aVar.vZ());
                                    }
                                }
                            }
                        }
                        if (this.aeY != null && this.aeZ != null) {
                            synchronized (this.aeY) {
                                int size2 = this.aeY.size();
                                for (int i2 = 0; i2 < size2; i2++) {
                                    int id = this.aeY.valueAt(i2).getId();
                                    List<com.kwad.framework.filedownloader.d.a> bg2 = d.this.bg(id);
                                    if (bg2 != null && bg2.size() > 0) {
                                        synchronized (this.aeZ) {
                                            this.aeZ.put(id, bg2);
                                        }
                                    }
                                }
                            }
                        }
                        uX.setTransactionSuccessful();
                        if (uX != null) {
                            try {
                                uX.endTransaction();
                            } catch (Exception e) {
                                d.printStackTrace(e);
                            }
                        }
                    } catch (SQLiteException e2) {
                        d.this.a(e2);
                        if (uX != null) {
                            try {
                                uX.endTransaction();
                            } catch (Exception e3) {
                                d.printStackTrace(e3);
                            }
                        }
                    } catch (Exception e4) {
                        d.printStackTrace(e4);
                        if (uX != null) {
                            try {
                                uX.endTransaction();
                            } catch (Exception e5) {
                                d.printStackTrace(e5);
                            }
                        }
                    }
                } catch (Throwable th) {
                    if (uX != null) {
                        try {
                            uX.endTransaction();
                        } catch (Exception e6) {
                            d.printStackTrace(e6);
                        }
                    }
                    throw th;
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* loaded from: classes10.dex */
    public class b implements Iterator<com.kwad.framework.filedownloader.d.c> {
        public Cursor afo;
        public final List<Integer> afp = new ArrayList();
        public int afq;

        public b() {
            try {
                this.afo = d.this.uX().rawQuery("SELECT * FROM ksad_file_download", null);
            } catch (SQLiteException e) {
                d.this.a(e);
            } catch (Exception e2) {
                d.printStackTrace(e2);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: private */
        @Override // java.util.Iterator
        /* renamed from: uY */
        public com.kwad.framework.filedownloader.d.c next() {
            com.kwad.framework.filedownloader.d.c d = d.d(this.afo);
            this.afq = d.getId();
            return d;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            try {
                if (this.afo == null) {
                    return false;
                }
                return this.afo.moveToNext();
            } catch (Throwable th) {
                d.printStackTrace(th);
                return false;
            }
        }

        @Override // java.util.Iterator
        public final void remove() {
            this.afp.add(Integer.valueOf(this.afq));
        }

        public final void uW() {
            Cursor cursor = this.afo;
            if (cursor == null) {
                return;
            }
            cursor.close();
            if (!this.afp.isEmpty()) {
                String join = TextUtils.join(StringUtil.ARRAY_ELEMENT_SEPARATOR, this.afp);
                if (com.kwad.framework.filedownloader.f.d.ahW) {
                    com.kwad.framework.filedownloader.f.d.c(this, "delete %s", join);
                }
                try {
                    SQLiteDatabase uX = d.this.uX();
                    uX.execSQL(f.b("DELETE FROM %s WHERE %s IN (%s);", "ksad_file_download", "_id", join));
                    uX.execSQL(f.b("DELETE FROM %s WHERE %s IN (%s);", "ksad_file_download_connection", "id", join));
                } catch (SQLiteException e) {
                    d.this.a(e);
                } catch (Exception e2) {
                    d.printStackTrace(e2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SQLiteDatabase uX() {
        if (this.afk == null) {
            this.afk = this.afj.getWritableDatabase();
        }
        return this.afk;
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void clear() {
        try {
            uX().delete("ksad_file_download", null, null);
        } catch (SQLiteException e) {
            a(e);
        }
        try {
            uX().delete("ksad_file_download_connection", null, null);
        } catch (SQLiteException e2) {
            a(e2);
        }
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final a.InterfaceC0678a uV() {
        return new a(null, null);
    }

    private void d(com.kwad.framework.filedownloader.d.c cVar) {
        try {
            uX().insert("ksad_file_download", null, cVar.vZ());
        } catch (SQLiteException e) {
            cVar.bh(e.toString());
            cVar.d((byte) -1);
            a(cVar.getId(), e);
        } catch (Exception e2) {
            printStackTrace(e2);
        }
    }

    public static void i(Throwable th) {
        if (th != null) {
            th.printStackTrace();
        }
    }

    public static void printStackTrace(Throwable th) {
        i(th);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void bh(int i) {
        try {
            SQLiteDatabase uX = uX();
            uX.execSQL("DELETE FROM ksad_file_download_connection WHERE id = " + i);
        } catch (SQLiteException e) {
            printStackTrace(e);
        } catch (Exception e2) {
            printStackTrace(e2);
        }
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final boolean bi(int i) {
        try {
            if (uX().delete("ksad_file_download", "_id = ?", new String[]{String.valueOf(i)}) == 0) {
                return false;
            }
            return true;
        } catch (SQLiteException e) {
            printStackTrace(e);
            return false;
        } catch (Exception e2) {
            printStackTrace(e2);
            return false;
        }
    }

    private void a(int i, ContentValues contentValues) {
        try {
            uX().update("ksad_file_download", contentValues, "_id = ? ", new String[]{String.valueOf(i)});
        } catch (SQLiteException e) {
            a(i, e);
        } catch (Exception e2) {
            printStackTrace(e2);
        }
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void c(int i, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Byte) (byte) 3);
        contentValues.put("sofar", Long.valueOf(j));
        a(i, contentValues);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void d(int i, long j) {
        bi(i);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void e(int i, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Byte) (byte) -2);
        contentValues.put("sofar", Long.valueOf(j));
        a(i, contentValues);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void u(int i, int i2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("connectionCount", Integer.valueOf(i2));
        try {
            uX().update("ksad_file_download", contentValues, "_id = ? ", new String[]{Integer.toString(i)});
        } catch (SQLiteException e) {
            a(i, e);
        } catch (Exception e2) {
            printStackTrace(e2);
        }
    }

    private void a(int i, @Nullable SQLiteException sQLiteException) {
        if (sQLiteException instanceof SQLiteFullException) {
            if (i != -1) {
                bi(i);
                bh(i);
            }
            i(sQLiteException);
            afi = true;
            return;
        }
        printStackTrace(sQLiteException);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SQLiteException sQLiteException) {
        a(-1, sQLiteException);
    }

    @SuppressLint({"Range"})
    public static com.kwad.framework.filedownloader.d.c d(Cursor cursor) {
        com.kwad.framework.filedownloader.d.c cVar = new com.kwad.framework.filedownloader.d.c();
        if (cursor == null) {
            return cVar;
        }
        cVar.setId(cursor.getInt(cursor.getColumnIndex("_id")));
        cVar.setUrl(cursor.getString(cursor.getColumnIndex("url")));
        String string = cursor.getString(cursor.getColumnIndex("path"));
        boolean z = true;
        if (cursor.getShort(cursor.getColumnIndex("pathAsDirectory")) != 1) {
            z = false;
        }
        cVar.d(string, z);
        cVar.d((byte) cursor.getShort(cursor.getColumnIndex("status")));
        cVar.O(cursor.getLong(cursor.getColumnIndex("sofar")));
        cVar.Q(cursor.getLong(cursor.getColumnIndex("total")));
        cVar.bh(cursor.getString(cursor.getColumnIndex(StatConstants.KEY_EXT_ERR_MSG)));
        cVar.bg(cursor.getString(cursor.getColumnIndex("etag")));
        cVar.bi(cursor.getString(cursor.getColumnIndex(BreakpointSQLiteKey.FILENAME)));
        cVar.by(cursor.getInt(cursor.getColumnIndex("connectionCount")));
        return cVar;
    }

    public final a.InterfaceC0678a a(SparseArray<com.kwad.framework.filedownloader.d.c> sparseArray, SparseArray<List<com.kwad.framework.filedownloader.d.a>> sparseArray2) {
        return new a(sparseArray, sparseArray2);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(int i, int i2, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("currentOffset", Long.valueOf(j));
        try {
            uX().update("ksad_file_download_connection", contentValues, "id = ? AND connectionIndex = ?", new String[]{Integer.toString(i), Integer.toString(i2)});
        } catch (SQLiteException e) {
            a(i, e);
        } catch (Exception e2) {
            printStackTrace(e2);
        }
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(int i, long j, String str, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Byte) (byte) 2);
        contentValues.put("total", Long.valueOf(j));
        contentValues.put("etag", str);
        contentValues.put(BreakpointSQLiteKey.FILENAME, str2);
        a(i, contentValues);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(int i, String str, long j, long j2, int i2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("sofar", Long.valueOf(j));
        contentValues.put("total", Long.valueOf(j2));
        contentValues.put("etag", str);
        contentValues.put("connectionCount", Integer.valueOf(i2));
        a(i, contentValues);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(int i, Throwable th) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(StatConstants.KEY_EXT_ERR_MSG, th.toString());
        contentValues.put("status", (Byte) (byte) 5);
        a(i, contentValues);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(int i, Throwable th, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(StatConstants.KEY_EXT_ERR_MSG, th.toString());
        contentValues.put("status", (Byte) (byte) -1);
        contentValues.put("sofar", Long.valueOf(j));
        a(i, contentValues);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(com.kwad.framework.filedownloader.d.a aVar) {
        if (aVar != null) {
            try {
                uX().insert("ksad_file_download_connection", null, aVar.vZ());
            } catch (SQLiteException e) {
                a(aVar.getId(), e);
            } catch (Exception e2) {
                printStackTrace(e2);
            }
        }
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void b(com.kwad.framework.filedownloader.d.c cVar) {
        if (cVar == null) {
            com.kwad.framework.filedownloader.f.d.d(this, "update but model == null!", new Object[0]);
        } else if (bf(cVar.getId()) != null) {
            try {
                uX().update("ksad_file_download", cVar.vZ(), "_id = ? ", new String[]{String.valueOf(cVar.getId())});
            } catch (SQLiteException e) {
                cVar.bh(e.toString());
                cVar.d((byte) -1);
                a(cVar.getId(), e);
            } catch (Exception e2) {
                printStackTrace(e2);
            }
        } else {
            d(cVar);
        }
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0048: MOVE  (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:24:0x0048 */
    @Override // com.kwad.framework.filedownloader.b.a
    public final com.kwad.framework.filedownloader.d.c bf(int i) {
        Cursor cursor;
        Closeable closeable;
        Closeable closeable2 = null;
        try {
            try {
                cursor = uX().rawQuery(f.b("SELECT * FROM %s WHERE %s = ?", "ksad_file_download", "_id"), new String[]{Integer.toString(i)});
                try {
                    if (cursor.moveToNext()) {
                        com.kwad.framework.filedownloader.d.c d = d(cursor);
                        com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
                        return d;
                    }
                } catch (SQLiteException e) {
                    e = e;
                    a(i, e);
                    com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
                    return null;
                } catch (Exception e2) {
                    e = e2;
                    printStackTrace(e);
                    com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                closeable2 = closeable;
                com.kwad.sdk.crash.utils.b.closeQuietly(closeable2);
                throw th;
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursor = null;
        } catch (Exception e4) {
            e = e4;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            com.kwad.sdk.crash.utils.b.closeQuietly(closeable2);
            throw th;
        }
        com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
        return null;
    }

    @Override // com.kwad.framework.filedownloader.b.a
    @SuppressLint({"Range"})
    public final List<com.kwad.framework.filedownloader.d.a> bg(int i) {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            try {
                cursor = uX().rawQuery(f.b("SELECT * FROM %s WHERE %s = ?", "ksad_file_download_connection", "id"), new String[]{Integer.toString(i)});
                while (cursor.moveToNext()) {
                    com.kwad.framework.filedownloader.d.a aVar = new com.kwad.framework.filedownloader.d.a();
                    aVar.setId(i);
                    aVar.setIndex(cursor.getInt(cursor.getColumnIndex("connectionIndex")));
                    aVar.setStartOffset(cursor.getLong(cursor.getColumnIndex("startOffset")));
                    aVar.M(cursor.getLong(cursor.getColumnIndex("currentOffset")));
                    aVar.N(cursor.getLong(cursor.getColumnIndex("endOffset")));
                    arrayList.add(aVar);
                }
            } catch (SQLiteException e) {
                a(i, e);
            } catch (Exception e2) {
                printStackTrace(e2);
            }
            return arrayList;
        } finally {
            com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
        }
    }
}

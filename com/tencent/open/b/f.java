package com.tencent.open.b;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes7.dex */
public class f extends SQLiteOpenHelper {

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f40174a = {"key"};

    /* renamed from: b  reason: collision with root package name */
    public static f f40175b;

    public f(Context context) {
        super(context, "sdk_report.db", (SQLiteDatabase.CursorFactory) null, 2);
    }

    public static synchronized f a() {
        f fVar;
        synchronized (f.class) {
            if (f40175b == null) {
                f40175b = new f(com.tencent.open.utils.e.a());
            }
            fVar = f40175b;
        }
        return fVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001e, code lost:
        if (r0 != null) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0020, code lost:
        r0.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x002e, code lost:
        if (r0 == null) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0032, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        SQLiteDatabase writableDatabase = getWritableDatabase();
        if (writableDatabase == null) {
            return;
        }
        try {
            writableDatabase.delete("via_cgi_report", "type = ?", new String[]{str});
        } catch (Exception e2) {
            com.tencent.open.a.f.b("openSDK_LOG.ReportDatabaseHelper", "clearReportItem has exception.", e2);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS via_cgi_report( _id INTEGER PRIMARY KEY,key TEXT,type TEXT,blob BLOB);");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS via_cgi_report");
        onCreate(sQLiteDatabase);
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x008a, code lost:
        if (r1 == null) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x008c, code lost:
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x009f, code lost:
        if (r1 != null) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00a3, code lost:
        return r0;
     */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0075 A[Catch: all -> 0x007f, Exception -> 0x0082, TRY_ENTER, TryCatch #13 {Exception -> 0x0082, all -> 0x007f, blocks: (B:14:0x0030, B:16:0x0036, B:17:0x0039, B:20:0x0053, B:21:0x0056, B:37:0x0075, B:38:0x0078, B:28:0x0062, B:29:0x0065, B:30:0x0068, B:33:0x006c, B:34:0x006f), top: B:94:0x0030 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0087 A[Catch: all -> 0x00af, TRY_ENTER, TryCatch #7 {, blocks: (B:3:0x0001, B:7:0x0012, B:46:0x0087, B:48:0x008c, B:61:0x00a6, B:63:0x00ab, B:64:0x00ae, B:55:0x009c), top: B:84:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized List<Serializable> a(String str) {
        ObjectInputStream objectInputStream;
        Serializable serializable;
        List<Serializable> synchronizedList = Collections.synchronizedList(new ArrayList());
        if (TextUtils.isEmpty(str)) {
            return synchronizedList;
        }
        SQLiteDatabase readableDatabase = getReadableDatabase();
        if (readableDatabase == null) {
            return synchronizedList;
        }
        Cursor cursor = null;
        ObjectInputStream objectInputStream2 = null;
        cursor = null;
        try {
            try {
                Cursor query = readableDatabase.query("via_cgi_report", null, "type = ?", new String[]{str}, null, null, null);
                if (query != null) {
                    try {
                        if (query.getCount() > 0) {
                            query.moveToFirst();
                            do {
                                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(query.getBlob(query.getColumnIndex("blob")));
                                try {
                                    objectInputStream = new ObjectInputStream(byteArrayInputStream);
                                    try {
                                        serializable = (Serializable) objectInputStream.readObject();
                                        try {
                                            objectInputStream.close();
                                        } catch (IOException unused) {
                                        }
                                        try {
                                            byteArrayInputStream.close();
                                        } catch (IOException unused2) {
                                        }
                                    } catch (Exception unused3) {
                                        if (objectInputStream != null) {
                                            try {
                                                objectInputStream.close();
                                            } catch (IOException unused4) {
                                            }
                                        }
                                        try {
                                            byteArrayInputStream.close();
                                        } catch (IOException unused5) {
                                        }
                                        serializable = null;
                                        if (serializable != null) {
                                        }
                                        if (!query.moveToNext()) {
                                            if (query != null) {
                                            }
                                        }
                                    } catch (Throwable th) {
                                        th = th;
                                        objectInputStream2 = objectInputStream;
                                        if (objectInputStream2 != null) {
                                            try {
                                                objectInputStream2.close();
                                            } catch (IOException unused6) {
                                            }
                                        }
                                        try {
                                            byteArrayInputStream.close();
                                        } catch (IOException unused7) {
                                        }
                                        throw th;
                                    }
                                } catch (Exception unused8) {
                                    objectInputStream = null;
                                } catch (Throwable th2) {
                                    th = th2;
                                }
                                if (serializable != null) {
                                    synchronizedList.add(serializable);
                                }
                            } while (!query.moveToNext());
                        }
                    } catch (Exception e2) {
                        e = e2;
                        cursor = query;
                        com.tencent.open.a.f.b("openSDK_LOG.ReportDatabaseHelper", "getReportItemFromDB has exception.", e);
                        if (cursor != null) {
                            cursor.close();
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        cursor = query;
                        if (cursor != null) {
                            cursor.close();
                        }
                        if (readableDatabase != null) {
                            readableDatabase.close();
                        }
                        throw th;
                    }
                }
                if (query != null) {
                    query.close();
                }
            } catch (Exception e3) {
                e = e3;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x0080, code lost:
        if (r1 != null) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0082, code lost:
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0092, code lost:
        if (r1 == null) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0096, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void a(String str, List<Serializable> list) {
        ObjectOutputStream objectOutputStream;
        int size = list.size();
        if (size == 0) {
            return;
        }
        if (size > 20) {
            size = 20;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        b(str);
        SQLiteDatabase writableDatabase = getWritableDatabase();
        if (writableDatabase == null) {
            return;
        }
        writableDatabase.beginTransaction();
        try {
            ContentValues contentValues = new ContentValues();
            for (int i2 = 0; i2 < size; i2++) {
                Serializable serializable = list.get(i2);
                if (serializable != null) {
                    contentValues.put("type", str);
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
                    ObjectOutputStream objectOutputStream2 = null;
                    try {
                        objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                        try {
                            objectOutputStream.writeObject(serializable);
                            try {
                                objectOutputStream.close();
                            } catch (IOException unused) {
                            }
                        } catch (IOException unused2) {
                            if (objectOutputStream != null) {
                                objectOutputStream.close();
                            }
                            byteArrayOutputStream.close();
                        } catch (Throwable th) {
                            th = th;
                            objectOutputStream2 = objectOutputStream;
                            if (objectOutputStream2 != null) {
                                try {
                                    objectOutputStream2.close();
                                } catch (IOException unused3) {
                                }
                            }
                            try {
                                byteArrayOutputStream.close();
                            } catch (IOException unused4) {
                            }
                            throw th;
                        }
                    } catch (IOException unused5) {
                        objectOutputStream = null;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException unused6) {
                        contentValues.put("blob", byteArrayOutputStream.toByteArray());
                        writableDatabase.insert("via_cgi_report", null, contentValues);
                    }
                }
                contentValues.clear();
            }
            writableDatabase.setTransactionSuccessful();
            writableDatabase.endTransaction();
        } catch (Exception unused7) {
            com.tencent.open.a.f.e("openSDK_LOG.ReportDatabaseHelper", "saveReportItemToDB has exception.");
            writableDatabase.endTransaction();
        }
    }
}

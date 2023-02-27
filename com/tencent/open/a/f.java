package com.tencent.open.a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.tencent.open.log.SLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes8.dex */
public class f extends SQLiteOpenHelper {
    public static final String[] a = {"key"};
    public static f b;

    public static synchronized f a() {
        f fVar;
        synchronized (f.class) {
            if (b == null) {
                b = new f(com.tencent.open.utils.f.a());
            }
            fVar = b;
        }
        return fVar;
    }

    public f(Context context) {
        super(context, "sdk_report.db", (SQLiteDatabase.CursorFactory) null, 2);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS via_cgi_report( _id INTEGER PRIMARY KEY,key TEXT,type TEXT,blob BLOB);");
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x008c, code lost:
        if (r1 == null) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x008e, code lost:
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00a1, code lost:
        if (r1 != null) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00a5, code lost:
        return r0;
     */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0077 A[Catch: all -> 0x0081, Exception -> 0x0084, TRY_ENTER, TryCatch #14 {Exception -> 0x0084, all -> 0x0081, blocks: (B:14:0x0032, B:16:0x0038, B:17:0x003b, B:20:0x0055, B:21:0x0058, B:37:0x0077, B:38:0x007a, B:28:0x0064, B:29:0x0067, B:30:0x006a, B:33:0x006e, B:34:0x0071), top: B:92:0x0032 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0089 A[Catch: all -> 0x00b1, TRY_ENTER, TryCatch #9 {, blocks: (B:3:0x0001, B:7:0x0012, B:46:0x0089, B:48:0x008e, B:61:0x00a8, B:63:0x00ad, B:64:0x00b0, B:55:0x009e), top: B:84:0x0001 }] */
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
                                } catch (Exception unused) {
                                    objectInputStream = null;
                                } catch (Throwable th) {
                                    th = th;
                                }
                                try {
                                    serializable = (Serializable) objectInputStream.readObject();
                                    try {
                                        objectInputStream.close();
                                    } catch (IOException unused2) {
                                    }
                                    try {
                                        byteArrayInputStream.close();
                                    } catch (IOException unused3) {
                                    }
                                } catch (Exception unused4) {
                                    if (objectInputStream != null) {
                                        try {
                                            objectInputStream.close();
                                        } catch (IOException unused5) {
                                        }
                                    }
                                    try {
                                        byteArrayInputStream.close();
                                    } catch (IOException unused6) {
                                    }
                                    serializable = null;
                                    if (serializable != null) {
                                    }
                                    if (!query.moveToNext()) {
                                        if (query != null) {
                                        }
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    objectInputStream2 = objectInputStream;
                                    if (objectInputStream2 != null) {
                                        try {
                                            objectInputStream2.close();
                                        } catch (IOException unused7) {
                                        }
                                    }
                                    try {
                                        byteArrayInputStream.close();
                                    } catch (IOException unused8) {
                                    }
                                    throw th;
                                }
                                if (serializable != null) {
                                    synchronizedList.add(serializable);
                                }
                            } while (!query.moveToNext());
                        }
                    } catch (Exception e) {
                        e = e;
                        cursor = query;
                        SLog.e("openSDK_LOG.ReportDatabaseHelper", "getReportItemFromDB has exception.", e);
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
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x0082, code lost:
        if (r1 != null) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0084, code lost:
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0095, code lost:
        if (r1 == null) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0099, code lost:
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
            for (int i = 0; i < size; i++) {
                Serializable serializable = list.get(i);
                if (serializable != null) {
                    contentValues.put("type", str);
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
                    ObjectOutputStream objectOutputStream2 = null;
                    try {
                        try {
                            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                        } catch (IOException unused) {
                        }
                        try {
                            objectOutputStream.writeObject(serializable);
                            objectOutputStream.close();
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
            SLog.e("openSDK_LOG.ReportDatabaseHelper", "saveReportItemToDB has exception.");
            writableDatabase.endTransaction();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0020, code lost:
        if (r0 != null) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0022, code lost:
        r0.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0030, code lost:
        if (r0 == null) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0034, code lost:
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
        } catch (Exception e) {
            SLog.e("openSDK_LOG.ReportDatabaseHelper", "clearReportItem has exception.", e);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS via_cgi_report");
        onCreate(sQLiteDatabase);
    }
}

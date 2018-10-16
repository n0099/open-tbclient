package com.tencent.open.b;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.baidu.fsg.base.armor.RimArmor;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes6.dex */
public class f extends SQLiteOpenHelper {
    protected static final String[] a = {RimArmor.KEY};
    protected static f b;

    public static synchronized f a() {
        f fVar;
        synchronized (f.class) {
            if (b == null) {
                b = new f(com.tencent.open.utils.e.a());
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

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS via_cgi_report");
        onCreate(sQLiteDatabase);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [131=4] */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0071 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:112:0x00c6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0061 A[Catch: Exception -> 0x0095, all -> 0x00de, TRY_ENTER, TryCatch #17 {Exception -> 0x0095, all -> 0x00de, blocks: (B:15:0x0033, B:17:0x0039, B:18:0x003c, B:22:0x0059, B:23:0x005c, B:25:0x0061, B:26:0x0064, B:46:0x008e, B:47:0x0091, B:48:0x0094, B:38:0x007f, B:39:0x0082), top: B:123:0x0033 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x006c A[Catch: all -> 0x00b0, TRY_ENTER, TRY_LEAVE, TryCatch #11 {, blocks: (B:4:0x0002, B:9:0x0014, B:29:0x006c, B:31:0x0071, B:33:0x0076, B:63:0x00b4, B:53:0x00a2, B:55:0x00a7, B:57:0x00ac, B:65:0x00b9, B:69:0x00c1, B:71:0x00c6, B:73:0x00cb, B:74:0x00ce, B:76:0x00d0), top: B:114:0x0002, inners: #2, #5, #8 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0076 A[Catch: all -> 0x00b0, TRY_ENTER, TRY_LEAVE, TryCatch #11 {, blocks: (B:4:0x0002, B:9:0x0014, B:29:0x006c, B:31:0x0071, B:33:0x0076, B:63:0x00b4, B:53:0x00a2, B:55:0x00a7, B:57:0x00ac, B:65:0x00b9, B:69:0x00c1, B:71:0x00c6, B:73:0x00cb, B:74:0x00ce, B:76:0x00d0), top: B:114:0x0002, inners: #2, #5, #8 }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c1 A[Catch: all -> 0x00b0, TRY_LEAVE, TryCatch #11 {, blocks: (B:4:0x0002, B:9:0x0014, B:29:0x006c, B:31:0x0071, B:33:0x0076, B:63:0x00b4, B:53:0x00a2, B:55:0x00a7, B:57:0x00ac, B:65:0x00b9, B:69:0x00c1, B:71:0x00c6, B:73:0x00cb, B:74:0x00ce, B:76:0x00d0), top: B:114:0x0002, inners: #2, #5, #8 }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00cb A[Catch: all -> 0x00b0, TRY_ENTER, TryCatch #11 {, blocks: (B:4:0x0002, B:9:0x0014, B:29:0x006c, B:31:0x0071, B:33:0x0076, B:63:0x00b4, B:53:0x00a2, B:55:0x00a7, B:57:0x00ac, B:65:0x00b9, B:69:0x00c1, B:71:0x00c6, B:73:0x00cb, B:74:0x00ce, B:76:0x00d0), top: B:114:0x0002, inners: #2, #5, #8 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized List<Serializable> a(String str) {
        Cursor cursor;
        Cursor cursor2;
        List<Serializable> list;
        ObjectInputStream objectInputStream;
        ObjectInputStream objectInputStream2;
        Serializable serializable;
        List<Serializable> synchronizedList = Collections.synchronizedList(new ArrayList());
        if (TextUtils.isEmpty(str)) {
            list = synchronizedList;
        } else {
            SQLiteDatabase readableDatabase = getReadableDatabase();
            if (readableDatabase == null) {
                list = synchronizedList;
            } else {
                ObjectInputStream objectInputStream3 = null;
                try {
                    cursor = readableDatabase.query("via_cgi_report", null, "type = ?", new String[]{str}, null, null, null);
                    if (cursor != null) {
                        try {
                            if (cursor.getCount() > 0) {
                                cursor.moveToFirst();
                                do {
                                    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(cursor.getBlob(cursor.getColumnIndex("blob")));
                                    try {
                                        objectInputStream = new ObjectInputStream(byteArrayInputStream);
                                        try {
                                            serializable = (Serializable) objectInputStream.readObject();
                                            if (objectInputStream != null) {
                                                try {
                                                    objectInputStream.close();
                                                } catch (IOException e) {
                                                }
                                            }
                                            try {
                                                byteArrayInputStream.close();
                                            } catch (IOException e2) {
                                            }
                                        } catch (Exception e3) {
                                            objectInputStream2 = objectInputStream;
                                            if (objectInputStream2 != null) {
                                                try {
                                                    objectInputStream2.close();
                                                } catch (IOException e4) {
                                                }
                                            }
                                            try {
                                                byteArrayInputStream.close();
                                                serializable = null;
                                            } catch (IOException e5) {
                                                serializable = null;
                                            }
                                            if (serializable != null) {
                                            }
                                            if (!cursor.moveToNext()) {
                                                if (cursor != null) {
                                                }
                                                if (0 != 0) {
                                                }
                                                if (readableDatabase != null) {
                                                }
                                                list = synchronizedList;
                                                return list;
                                            }
                                        } catch (Throwable th) {
                                            th = th;
                                            if (objectInputStream != null) {
                                                try {
                                                    objectInputStream.close();
                                                } catch (IOException e6) {
                                                }
                                            }
                                            try {
                                                byteArrayInputStream.close();
                                            } catch (IOException e7) {
                                            }
                                            throw th;
                                        }
                                    } catch (Exception e8) {
                                        objectInputStream2 = null;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        objectInputStream = null;
                                    }
                                    if (serializable != null) {
                                        synchronizedList.add(serializable);
                                    }
                                } while (!cursor.moveToNext());
                            }
                        } catch (Exception e9) {
                            e = e9;
                            cursor2 = cursor;
                            try {
                                com.tencent.open.a.f.b("openSDK_LOG.ReportDatabaseHelper", "getReportItemFromDB has exception.", e);
                                if (cursor2 != null) {
                                    cursor2.close();
                                }
                                if (0 != 0) {
                                    try {
                                        objectInputStream3.close();
                                    } catch (IOException e10) {
                                        e10.printStackTrace();
                                    }
                                }
                                if (readableDatabase != null) {
                                    readableDatabase.close();
                                }
                                list = synchronizedList;
                                return list;
                            } catch (Throwable th3) {
                                th = th3;
                                cursor = cursor2;
                                if (cursor != null) {
                                    cursor.close();
                                }
                                if (0 != 0) {
                                    try {
                                        objectInputStream3.close();
                                    } catch (IOException e11) {
                                        e11.printStackTrace();
                                    }
                                }
                                if (readableDatabase != null) {
                                    readableDatabase.close();
                                }
                                throw th;
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            if (cursor != null) {
                            }
                            if (0 != 0) {
                            }
                            if (readableDatabase != null) {
                            }
                            throw th;
                        }
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                    if (0 != 0) {
                        try {
                            objectInputStream3.close();
                        } catch (IOException e12) {
                            e12.printStackTrace();
                        }
                    }
                    if (readableDatabase != null) {
                        readableDatabase.close();
                    }
                } catch (Exception e13) {
                    e = e13;
                    cursor2 = null;
                } catch (Throwable th5) {
                    th = th5;
                    cursor = null;
                }
                list = synchronizedList;
            }
        }
        return list;
    }

    public synchronized void a(String str, List<Serializable> list) {
        ObjectOutputStream objectOutputStream;
        ObjectOutputStream objectOutputStream2;
        ObjectOutputStream objectOutputStream3 = null;
        synchronized (this) {
            int size = list.size();
            if (size != 0) {
                int i = size <= 20 ? size : 20;
                if (!TextUtils.isEmpty(str)) {
                    b(str);
                    SQLiteDatabase writableDatabase = getWritableDatabase();
                    if (writableDatabase != null) {
                        writableDatabase.beginTransaction();
                        try {
                            ContentValues contentValues = new ContentValues();
                            for (int i2 = 0; i2 < i; i2++) {
                                Serializable serializable = list.get(i2);
                                if (serializable != null) {
                                    contentValues.put("type", str);
                                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
                                    try {
                                        objectOutputStream2 = new ObjectOutputStream(byteArrayOutputStream);
                                    } catch (IOException e) {
                                        objectOutputStream = null;
                                    } catch (Throwable th) {
                                        th = th;
                                    }
                                    try {
                                        objectOutputStream2.writeObject(serializable);
                                        if (objectOutputStream2 != null) {
                                            try {
                                                objectOutputStream2.close();
                                            } catch (IOException e2) {
                                            }
                                        }
                                        try {
                                            byteArrayOutputStream.close();
                                        } catch (IOException e3) {
                                        }
                                    } catch (IOException e4) {
                                        objectOutputStream = objectOutputStream2;
                                        if (objectOutputStream != null) {
                                            try {
                                                objectOutputStream.close();
                                            } catch (IOException e5) {
                                            }
                                        }
                                        try {
                                            byteArrayOutputStream.close();
                                        } catch (IOException e6) {
                                        }
                                        contentValues.put("blob", byteArrayOutputStream.toByteArray());
                                        writableDatabase.insert("via_cgi_report", null, contentValues);
                                        contentValues.clear();
                                    } catch (Throwable th2) {
                                        th = th2;
                                        objectOutputStream3 = objectOutputStream2;
                                        if (objectOutputStream3 != null) {
                                            try {
                                                objectOutputStream3.close();
                                            } catch (IOException e7) {
                                            }
                                        }
                                        try {
                                            byteArrayOutputStream.close();
                                        } catch (IOException e8) {
                                        }
                                        throw th;
                                    }
                                    contentValues.put("blob", byteArrayOutputStream.toByteArray());
                                    writableDatabase.insert("via_cgi_report", null, contentValues);
                                }
                                contentValues.clear();
                            }
                            writableDatabase.setTransactionSuccessful();
                            writableDatabase.endTransaction();
                            if (writableDatabase != null) {
                                writableDatabase.close();
                            }
                        } catch (Exception e9) {
                            com.tencent.open.a.f.e("openSDK_LOG.ReportDatabaseHelper", "saveReportItemToDB has exception.");
                            writableDatabase.endTransaction();
                            if (writableDatabase != null) {
                                writableDatabase.close();
                            }
                        }
                    }
                }
            }
        }
    }

    public synchronized void b(String str) {
        SQLiteDatabase writableDatabase;
        if (!TextUtils.isEmpty(str) && (writableDatabase = getWritableDatabase()) != null) {
            try {
                writableDatabase.delete("via_cgi_report", "type = ?", new String[]{str});
                if (writableDatabase != null) {
                    writableDatabase.close();
                }
            } catch (Exception e) {
                com.tencent.open.a.f.b("openSDK_LOG.ReportDatabaseHelper", "clearReportItem has exception.", e);
                if (writableDatabase != null) {
                    writableDatabase.close();
                }
            }
        }
    }
}

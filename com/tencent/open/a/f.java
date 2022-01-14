package com.tencent.open.a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes4.dex */
public class f extends SQLiteOpenHelper {
    public static /* synthetic */ Interceptable $ic;
    public static final String[] a;

    /* renamed from: b  reason: collision with root package name */
    public static f f60503b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2039280004, "Lcom/tencent/open/a/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2039280004, "Lcom/tencent/open/a/f;");
                return;
            }
        }
        a = new String[]{"key"};
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(Context context) {
        super(context, "sdk_report.db", (SQLiteDatabase.CursorFactory) null, 2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (String) objArr2[1], (SQLiteDatabase.CursorFactory) objArr2[2], ((Integer) objArr2[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static synchronized f a() {
        InterceptResult invokeV;
        f fVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            synchronized (f.class) {
                if (f60503b == null) {
                    f60503b = new f(com.tencent.open.utils.f.a());
                }
                fVar = f60503b;
            }
            return fVar;
        }
        return (f) invokeV.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0022, code lost:
        if (r0 != null) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0024, code lost:
        r0.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0032, code lost:
        if (r0 == null) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0036, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) != null) {
            return;
        }
        synchronized (this) {
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
                SLog.e("openSDK_LOG.ReportDatabaseHelper", "clearReportItem has exception.", e2);
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, sQLiteDatabase) == null) {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS via_cgi_report( _id INTEGER PRIMARY KEY,key TEXT,type TEXT,blob BLOB);");
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048580, this, sQLiteDatabase, i2, i3) == null) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS via_cgi_report");
            onCreate(sQLiteDatabase);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x008e, code lost:
        if (r1 == null) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0090, code lost:
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00a3, code lost:
        if (r1 != null) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00a7, code lost:
        return r0;
     */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0079 A[Catch: all -> 0x0083, Exception -> 0x0086, TRY_ENTER, TryCatch #13 {Exception -> 0x0086, all -> 0x0083, blocks: (B:16:0x0034, B:18:0x003a, B:19:0x003d, B:22:0x0057, B:23:0x005a, B:39:0x0079, B:40:0x007c, B:30:0x0066, B:31:0x0069, B:32:0x006c, B:35:0x0070, B:36:0x0073), top: B:100:0x0034 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008b A[Catch: all -> 0x00b3, TRY_ENTER, TryCatch #11 {, blocks: (B:5:0x0005, B:9:0x0016, B:48:0x008b, B:50:0x0090, B:63:0x00aa, B:65:0x00af, B:66:0x00b2, B:57:0x00a0), top: B:92:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized List<Serializable> a(String str) {
        InterceptResult invokeL;
        ObjectInputStream objectInputStream;
        Serializable serializable;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, str)) != null) {
            return (List) invokeL.objValue;
        }
        synchronized (this) {
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
                } catch (Exception e3) {
                    e = e3;
                }
            } catch (Throwable th4) {
                th = th4;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:48:0x0084, code lost:
        if (r1 != null) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0086, code lost:
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0096, code lost:
        if (r1 == null) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x009a, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void a(String str, List<Serializable> list) {
        ObjectOutputStream objectOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, list) != null) {
            return;
        }
        synchronized (this) {
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
    }
}

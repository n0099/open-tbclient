package com.kwad.components.core.c;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.kwad.sdk.KsAdSDKImpl;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes10.dex */
public class a {
    public static volatile a IN;
    public final SQLiteDatabase IM;

    /* renamed from: com.kwad.components.core.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0633a extends SQLiteOpenHelper {
        public static int IO = 1;
        public String IP;
        public String IQ;

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }

        public C0633a(@Nullable Context context) {
            super(context, "ksadcache.db", (SQLiteDatabase.CursorFactory) null, IO);
            this.IP = "CREATE TABLE IF NOT EXISTS ksad_ad_cache (creativeId VARCHAR PRIMARY KEY NOT NULL, posId TEXT, adJson TEXT, ecpm INTEGER, playAgainJson TEXT, adSenseJson TEXT, createTime INTEGER, expireTime INTEGER)";
            this.IQ = "CREATE TABLE IF NOT EXISTS ksad_ad_cache_strategy(posId VARCHAR PRIMARY KEY NOT NULL, cacheSize INTEGER, cacheSecond INTEGER, strategyCode INTEGER, enable INTEGER)";
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onCreate(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL(this.IP);
            sQLiteDatabase.execSQL(this.IQ);
        }
    }

    public a(Context context) {
        this.IM = new C0633a(context).getWritableDatabase();
    }

    public final void a(e eVar) {
        b(Collections.singletonList(eVar), "ksad_ad_cache_strategy");
    }

    @WorkerThread
    public final void i(List<h> list) {
        b(list, "ksad_ad_cache");
    }

    @WorkerThread
    public final void r(long j) {
        try {
            int delete = this.IM.delete("ksad_ad_cache", "creativeId=?", new String[]{String.valueOf(j)});
            com.kwad.sdk.core.e.c.d("AdCacheDBManager", "deleteCachedAdByCreativeId result: " + delete);
        } catch (Exception e) {
            com.kwad.sdk.core.e.c.printStackTrace(e);
        }
    }

    private <T extends i> void b(List<T> list, String str) {
        try {
            try {
                this.IM.beginTransaction();
                for (T t : list) {
                    try {
                        long insertWithOnConflict = this.IM.insertWithOnConflict(str, null, t.mA(), 5);
                        com.kwad.sdk.core.e.c.d("AdCacheDBManager", "insertData: " + str + ", rowId: " + insertWithOnConflict);
                    } catch (Exception e) {
                        com.kwad.sdk.core.e.c.printStackTrace(e);
                    }
                }
                this.IM.setTransactionSuccessful();
                SQLiteDatabase sQLiteDatabase = this.IM;
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.endTransaction();
                    } catch (Exception e2) {
                        com.kwad.sdk.core.e.c.printStackTrace(e2);
                    }
                }
            } catch (Exception e3) {
                com.kwad.sdk.core.e.c.printStackTrace(e3);
                SQLiteDatabase sQLiteDatabase2 = this.IM;
                if (sQLiteDatabase2 != null) {
                    try {
                        sQLiteDatabase2.endTransaction();
                    } catch (Exception e4) {
                        com.kwad.sdk.core.e.c.printStackTrace(e4);
                    }
                }
            }
        } catch (Throwable th) {
            SQLiteDatabase sQLiteDatabase3 = this.IM;
            if (sQLiteDatabase3 != null) {
                try {
                    sQLiteDatabase3.endTransaction();
                } catch (Exception e5) {
                    com.kwad.sdk.core.e.c.printStackTrace(e5);
                }
            }
            throw th;
        }
    }

    @Nullable
    public static a mn() {
        KsAdSDKImpl ksAdSDKImpl;
        if (IN == null) {
            synchronized (a.class) {
                if (IN == null && (ksAdSDKImpl = KsAdSDKImpl.get()) != null) {
                    try {
                        IN = new a(ksAdSDKImpl.getContext());
                    } catch (SQLiteException e) {
                        com.kwad.sdk.core.e.c.printStackTraceOnly(e);
                        IN = null;
                    }
                }
            }
        }
        return IN;
    }

    @WorkerThread
    public final void mo() {
        try {
            this.IM.delete("ksad_ad_cache", "expireTime<?", new String[]{String.valueOf(System.currentTimeMillis() / 1000)});
        } catch (Exception e) {
            com.kwad.sdk.core.e.c.printStackTrace(e);
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:20:0x0035 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v4, types: [java.io.Closeable] */
    @WorkerThread
    public final e X(String str) {
        Throwable th;
        Cursor cursor;
        try {
            try {
                cursor = this.IM.rawQuery("select  * from ksad_ad_cache_strategy where posId=?", new String[]{str});
                try {
                    List<e> a = e.a(cursor);
                    if (a != null && a.size() > 0) {
                        e eVar = a.get(0);
                        com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
                        return eVar;
                    }
                } catch (Exception e) {
                    e = e;
                    com.kwad.sdk.core.e.c.printStackTraceOnly(e);
                    com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
                    return null;
                }
            } catch (Throwable th2) {
                th = th2;
                com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) str);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            cursor = null;
        } catch (Throwable th3) {
            th = th3;
            str = 0;
            com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) str);
            throw th;
        }
        com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
        return null;
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0096: MOVE  (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:34:0x0096 */
    @Nullable
    @WorkerThread
    public final List<h> a(String str, long j, int i) {
        Cursor cursor;
        Closeable closeable;
        Closeable closeable2 = null;
        try {
            try {
                cursor = this.IM.rawQuery("select  * from ksad_ad_cache where posId=? order by createTime desc", new String[]{str});
                try {
                    List<h> a = h.a(cursor);
                    if (a == null) {
                        com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
                        return null;
                    }
                    StringBuilder sb = new StringBuilder("(posId = " + str + ") AND (");
                    ArrayList arrayList = new ArrayList();
                    int i2 = 0;
                    for (h hVar : a) {
                        i2++;
                        if (i2 <= i) {
                            if (hVar.mH() >= j) {
                                arrayList.add(hVar);
                            }
                        } else {
                            sb.append(" creativeId = ");
                            sb.append(hVar.mJ());
                            if (i2 == a.size()) {
                                sb.append(SmallTailInfo.EMOTION_SUFFIX);
                            } else {
                                sb.append(" OR");
                            }
                        }
                    }
                    if (i2 > i) {
                        this.IM.delete("ksad_ad_cache", sb.toString(), new String[0]);
                    }
                    com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
                    return arrayList;
                } catch (Exception e) {
                    e = e;
                    com.kwad.sdk.core.e.c.printStackTraceOnly(e);
                    com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                closeable2 = closeable;
                com.kwad.sdk.crash.utils.b.closeQuietly(closeable2);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            com.kwad.sdk.crash.utils.b.closeQuietly(closeable2);
            throw th;
        }
    }
}

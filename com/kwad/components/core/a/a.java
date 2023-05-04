package com.kwad.components.core.a;

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
/* loaded from: classes8.dex */
public class a {
    public static volatile a CS;
    public final SQLiteDatabase CR;

    /* renamed from: com.kwad.components.core.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0588a extends SQLiteOpenHelper {
        public static int CU = 1;
        public String CV;
        public String CW;

        public C0588a(@Nullable Context context) {
            super(context, "ksadcache.db", (SQLiteDatabase.CursorFactory) null, CU);
            this.CV = "CREATE TABLE IF NOT EXISTS ksad_ad_cache (creativeId VARCHAR PRIMARY KEY NOT NULL, posId TEXT, adJson TEXT, ecpm INTEGER, playAgainJson TEXT, adSenseJson TEXT, createTime INTEGER, expireTime INTEGER)";
            this.CW = "CREATE TABLE IF NOT EXISTS ksad_ad_cache_strategy(posId VARCHAR PRIMARY KEY NOT NULL, cacheSize INTEGER, cacheSecond INTEGER, strategyCode INTEGER, enable INTEGER)";
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onCreate(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL(this.CV);
            sQLiteDatabase.execSQL(this.CW);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }
    }

    public a(Context context) {
        this.CR = new C0588a(context).getWritableDatabase();
    }

    private <T extends h> void b(List<T> list, String str) {
        try {
            try {
                this.CR.beginTransaction();
                for (T t : list) {
                    try {
                        long insertWithOnConflict = this.CR.insertWithOnConflict(str, null, t.ma(), 5);
                        com.kwad.sdk.core.e.b.d("AdCacheDBManager", "insertData: " + str + ", rowId: " + insertWithOnConflict);
                    } catch (Exception e) {
                        com.kwad.sdk.core.e.b.printStackTrace(e);
                    }
                }
                this.CR.setTransactionSuccessful();
                SQLiteDatabase sQLiteDatabase = this.CR;
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.endTransaction();
                    } catch (Exception e2) {
                        com.kwad.sdk.core.e.b.printStackTrace(e2);
                    }
                }
            } catch (Exception e3) {
                com.kwad.sdk.core.e.b.printStackTrace(e3);
                SQLiteDatabase sQLiteDatabase2 = this.CR;
                if (sQLiteDatabase2 != null) {
                    try {
                        sQLiteDatabase2.endTransaction();
                    } catch (Exception e4) {
                        com.kwad.sdk.core.e.b.printStackTrace(e4);
                    }
                }
            }
        } catch (Throwable th) {
            SQLiteDatabase sQLiteDatabase3 = this.CR;
            if (sQLiteDatabase3 != null) {
                try {
                    sQLiteDatabase3.endTransaction();
                } catch (Exception e5) {
                    com.kwad.sdk.core.e.b.printStackTrace(e5);
                }
            }
            throw th;
        }
    }

    @Nullable
    public static a lP() {
        KsAdSDKImpl ksAdSDKImpl;
        if (CS == null) {
            synchronized (a.class) {
                if (CS == null && (ksAdSDKImpl = KsAdSDKImpl.get()) != null) {
                    try {
                        CS = new a(ksAdSDKImpl.getContext());
                    } catch (SQLiteException e) {
                        com.kwad.sdk.core.e.b.printStackTraceOnly(e);
                        CS = null;
                    }
                }
            }
        }
        return CS;
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0093: MOVE  (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:35:0x0093 */
    @Nullable
    @WorkerThread
    public final List<g> a(String str, long j, int i) {
        Cursor cursor;
        Closeable closeable;
        Closeable closeable2 = null;
        try {
            try {
                cursor = this.CR.rawQuery("select  * from ksad_ad_cache where posId=? order by createTime desc", new String[]{str});
                try {
                    List<g> a = g.a(cursor);
                    if (a == null) {
                        com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
                        return null;
                    }
                    StringBuilder sb = new StringBuilder("(posId = " + str + ") AND (");
                    ArrayList arrayList = new ArrayList();
                    int i2 = 0;
                    for (g gVar : a) {
                        i2++;
                        if (i2 > i) {
                            sb.append(" creativeId = ");
                            sb.append(gVar.mi());
                            sb.append(i2 == a.size() ? SmallTailInfo.EMOTION_SUFFIX : " OR");
                        } else if (gVar.mg() >= j) {
                            arrayList.add(gVar);
                        }
                    }
                    if (i2 > i) {
                        this.CR.delete("ksad_ad_cache", sb.toString(), new String[0]);
                    }
                    com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
                    return arrayList;
                } catch (Exception e) {
                    e = e;
                    com.kwad.sdk.core.e.b.printStackTraceOnly(e);
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

    public final void a(e eVar) {
        b(Collections.singletonList(eVar), "ksad_ad_cache_strategy");
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:20:0x0035 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v4, types: [java.io.Closeable] */
    @WorkerThread
    public final e af(String str) {
        Throwable th;
        Cursor cursor;
        try {
            try {
                cursor = this.CR.rawQuery("select  * from ksad_ad_cache_strategy where posId=?", new String[]{str});
                try {
                    List<e> a = e.a(cursor);
                    if (a != null && a.size() > 0) {
                        e eVar = a.get(0);
                        com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
                        return eVar;
                    }
                } catch (Exception e) {
                    e = e;
                    com.kwad.sdk.core.e.b.printStackTraceOnly(e);
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

    @WorkerThread
    public final void h(List<g> list) {
        b(list, "ksad_ad_cache");
    }

    @WorkerThread
    public final void j(long j) {
        try {
            int delete = this.CR.delete("ksad_ad_cache", "creativeId=?", new String[]{String.valueOf(j)});
            com.kwad.sdk.core.e.b.d("AdCacheDBManager", "deleteCachedAdByCreativeId result: " + delete);
        } catch (Exception e) {
            com.kwad.sdk.core.e.b.printStackTrace(e);
        }
    }

    @WorkerThread
    public final void lQ() {
        try {
            this.CR.delete("ksad_ad_cache", "expireTime<?", new String[]{String.valueOf(System.currentTimeMillis() / 1000)});
        } catch (Exception e) {
            com.kwad.sdk.core.e.b.printStackTrace(e);
        }
    }
}

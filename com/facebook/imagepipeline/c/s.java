package com.facebook.imagepipeline.c;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.text.TextUtils;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.a;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes2.dex */
public class s implements r {
    private static final String TAG = s.class.getSimpleName();
    private static final String[] aAq = {"cache_choice", "cache_key", "width", "height"};
    @GuardedBy("MediaVariationsIndexDatabase.class")
    private final b jFD;
    private final Executor jFa;
    private final Executor jFb;

    public s(Context context, Executor executor, Executor executor2) {
        this.jFD = new b(context);
        this.jFa = executor;
        this.jFb = executor2;
    }

    @Override // com.facebook.imagepipeline.c.r
    public bolts.g<com.facebook.imagepipeline.request.a> a(final String str, final a.C0437a c0437a) {
        try {
            return bolts.g.a(new Callable<com.facebook.imagepipeline.request.a>() { // from class: com.facebook.imagepipeline.c.s.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.concurrent.Callable
                /* renamed from: cwE */
                public com.facebook.imagepipeline.request.a call() throws Exception {
                    return s.this.b(str, c0437a);
                }
            }, this.jFa);
        } catch (Exception e) {
            com.facebook.common.c.a.a(TAG, e, "Failed to schedule query task for %s", str);
            return bolts.g.f(e);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [130=4] */
    protected com.facebook.imagepipeline.request.a b(String str, a.C0437a c0437a) {
        com.facebook.imagepipeline.request.a cAE;
        Cursor cursor = null;
        synchronized (s.class) {
            try {
            } catch (Throwable th) {
                th = th;
            }
            try {
                Cursor query = this.jFD.getWritableDatabase().query("media_variations_index", aAq, "media_id = ?", new String[]{str}, null, null, null);
                try {
                    if (query.getCount() == 0) {
                        cAE = c0437a.cAE();
                        if (query != null) {
                            query.close();
                        }
                    } else {
                        int columnIndexOrThrow = query.getColumnIndexOrThrow("cache_key");
                        int columnIndexOrThrow2 = query.getColumnIndexOrThrow("width");
                        int columnIndexOrThrow3 = query.getColumnIndexOrThrow("height");
                        int columnIndexOrThrow4 = query.getColumnIndexOrThrow("cache_choice");
                        while (query.moveToNext()) {
                            String string = query.getString(columnIndexOrThrow4);
                            c0437a.a(Uri.parse(query.getString(columnIndexOrThrow)), query.getInt(columnIndexOrThrow2), query.getInt(columnIndexOrThrow3), TextUtils.isEmpty(string) ? null : ImageRequest.CacheChoice.valueOf(string));
                        }
                        cAE = c0437a.cAE();
                        if (query != null) {
                            query.close();
                        }
                    }
                } catch (SQLException e) {
                    e = e;
                    com.facebook.common.c.a.b(TAG, e, "Error reading for %s", str);
                    throw e;
                }
            } catch (SQLException e2) {
                e = e2;
            } catch (Throwable th2) {
                th = th2;
                if (0 != 0) {
                    cursor.close();
                }
                throw th;
            }
        }
        return cAE;
    }

    @Override // com.facebook.imagepipeline.c.r
    public void a(final String str, final ImageRequest.CacheChoice cacheChoice, final com.facebook.cache.common.b bVar, final com.facebook.imagepipeline.f.d dVar) {
        this.jFb.execute(new Runnable() { // from class: com.facebook.imagepipeline.c.s.2
            @Override // java.lang.Runnable
            public void run() {
                s.this.b(str, cacheChoice, bVar, dVar);
            }
        });
    }

    protected void b(String str, ImageRequest.CacheChoice cacheChoice, com.facebook.cache.common.b bVar, com.facebook.imagepipeline.f.d dVar) {
        synchronized (s.class) {
            SQLiteDatabase writableDatabase = this.jFD.getWritableDatabase();
            try {
                writableDatabase.beginTransaction();
                ContentValues contentValues = new ContentValues();
                contentValues.put("media_id", str);
                contentValues.put("width", Integer.valueOf(dVar.getWidth()));
                contentValues.put("height", Integer.valueOf(dVar.getHeight()));
                contentValues.put("cache_choice", cacheChoice.name());
                contentValues.put("cache_key", bVar.getUriString());
                contentValues.put("resource_id", com.facebook.cache.common.c.b(bVar));
                writableDatabase.replaceOrThrow("media_variations_index", null, contentValues);
                writableDatabase.setTransactionSuccessful();
                writableDatabase.endTransaction();
            } catch (Exception e) {
                com.facebook.common.c.a.b(TAG, e, "Error writing for %s", str);
                writableDatabase.endTransaction();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class b {
        @Nullable
        private a jFI;
        private final Context mContext;

        private b(Context context) {
            this.mContext = context;
        }

        public synchronized SQLiteDatabase getWritableDatabase() {
            if (this.jFI == null) {
                this.jFI = new a(this.mContext);
            }
            return this.jFI.getWritableDatabase();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a extends SQLiteOpenHelper {
        public a(Context context) {
            super(context, "FrescoMediaVariationsIndex.db", (SQLiteDatabase.CursorFactory) null, 2);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.beginTransaction();
            try {
                sQLiteDatabase.execSQL("CREATE TABLE media_variations_index (_id INTEGER PRIMARY KEY,media_id TEXT,width INTEGER,height INTEGER,cache_choice TEXT,cache_key TEXT,resource_id TEXT UNIQUE )");
                sQLiteDatabase.execSQL("CREATE INDEX index_media_id ON media_variations_index (media_id)");
                sQLiteDatabase.setTransactionSuccessful();
            } finally {
                sQLiteDatabase.endTransaction();
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            sQLiteDatabase.beginTransaction();
            try {
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS media_variations_index");
                sQLiteDatabase.setTransactionSuccessful();
                sQLiteDatabase.endTransaction();
                onCreate(sQLiteDatabase);
            } catch (Throwable th) {
                sQLiteDatabase.endTransaction();
                throw th;
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            onUpgrade(sQLiteDatabase, i, i2);
        }
    }
}

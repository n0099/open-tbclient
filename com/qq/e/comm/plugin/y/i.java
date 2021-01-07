package com.qq.e.comm.plugin.y;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.qq.e.comm.plugin.util.ai;
import com.qq.e.comm.plugin.y.t;
import com.qq.e.comm.util.GDTLogger;
import java.util.HashMap;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class i extends SQLiteOpenHelper {

    /* renamed from: a  reason: collision with root package name */
    private static volatile i f13003a;

    /* renamed from: b  reason: collision with root package name */
    private Map<String, t> f13004b;

    private i(Context context) {
        super(new com.qq.e.comm.plugin.g.a(context), "gdt_stat.db", (SQLiteDatabase.CursorFactory) null, 2);
        this.f13004b = new HashMap(5);
        this.f13004b.put("event", new t("event", new t.a<k>() { // from class: com.qq.e.comm.plugin.y.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.qq.e.comm.plugin.y.t.a
            /* renamed from: a */
            public k b(int i, String str) {
                return l.a(i, str);
            }
        }));
        this.f13004b.put("performance", new t("performance", new t.a<o>() { // from class: com.qq.e.comm.plugin.y.i.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.qq.e.comm.plugin.y.t.a
            /* renamed from: a */
            public o b(int i, String str) {
                return p.a(i, str);
            }
        }));
    }

    public static i a(Context context) {
        if (f13003a == null) {
            synchronized (i.class) {
                try {
                    if (f13003a == null) {
                        f13003a = new i(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f13003a;
    }

    private void a(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase == null) {
            GDTLogger.w("No stat db!");
            return;
        }
        try {
            sQLiteDatabase.beginTransaction();
            for (t tVar : this.f13004b.values()) {
                tVar.b(sQLiteDatabase);
            }
            sQLiteDatabase.setTransactionSuccessful();
            ai.a("Drop stat db success", new Object[0]);
        } catch (Throwable th) {
            try {
                GDTLogger.e("Drop stat table failed!", th);
            } finally {
                sQLiteDatabase.endTransaction();
            }
        }
    }

    private void b(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase == null) {
            GDTLogger.w("No stat db!");
            return;
        }
        try {
            sQLiteDatabase.beginTransaction();
            for (t tVar : this.f13004b.values()) {
                tVar.a(sQLiteDatabase);
            }
            sQLiteDatabase.setTransactionSuccessful();
            ai.a("Create stat db success", new Object[0]);
        } catch (Throwable th) {
            try {
                GDTLogger.e("Create stat table failed!", th);
            } finally {
                sQLiteDatabase.endTransaction();
            }
        }
    }

    public void a() {
        for (t tVar : this.f13004b.values()) {
            tVar.a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public t b() {
        return this.f13004b.get("event");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public t c() {
        return this.f13004b.get("performance");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        b(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        a(sQLiteDatabase);
        b(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        a(sQLiteDatabase);
        b(sQLiteDatabase);
    }
}

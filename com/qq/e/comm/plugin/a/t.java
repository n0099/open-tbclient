package com.qq.e.comm.plugin.a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.baidu.live.tbadk.statics.AlaStaticKeys;
import com.baidu.mobstat.Config;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.plugin.y.u;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class t extends SQLiteOpenHelper {

    /* renamed from: a  reason: collision with root package name */
    private static volatile t f11648a;
    private static SQLiteDatabase c;

    /* renamed from: b  reason: collision with root package name */
    private AtomicInteger f11649b;

    private t(Context context) {
        super(new com.qq.e.comm.plugin.g.a(context), "GDTSDK.db", (SQLiteDatabase.CursorFactory) null, 9);
        this.f11649b = new AtomicInteger();
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    private com.qq.e.comm.plugin.a.c a(int r5, java.lang.String r6) {
        /*
            r4 = this;
            r0 = 0
            android.database.sqlite.SQLiteDatabase r2 = r4.getReadableDatabase()     // Catch: java.lang.Throwable -> L3b
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L56
            r1.<init>()     // Catch: java.lang.Throwable -> L56
            java.lang.String r3 = "select * from tasks where id = '"
            java.lang.StringBuilder r1 = r1.append(r3)     // Catch: java.lang.Throwable -> L56
            java.lang.StringBuilder r1 = r1.append(r5)     // Catch: java.lang.Throwable -> L56
            java.lang.String r3 = "' and status in "
            java.lang.StringBuilder r1 = r1.append(r3)     // Catch: java.lang.Throwable -> L56
            java.lang.StringBuilder r1 = r1.append(r6)     // Catch: java.lang.Throwable -> L56
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L56
            r3 = 0
            android.database.Cursor r1 = r2.rawQuery(r1, r3)     // Catch: java.lang.Throwable -> L56
            boolean r3 = r4.b(r1)     // Catch: java.lang.Throwable -> L59
            if (r3 == 0) goto L37
            com.qq.e.comm.plugin.a.c r0 = r4.a(r1)     // Catch: java.lang.Throwable -> L59
            r4.a(r2, r1)
        L36:
            return r0
        L37:
            r4.a(r2, r1)
            goto L36
        L3b:
            r1 = move-exception
            r2 = r0
            r1 = r0
        L3e:
            java.lang.String r3 = "Get getTaskByTargetUrlAStatus Error"
            com.qq.e.comm.util.GDTLogger.w(r3)     // Catch: java.lang.Throwable -> L52
            r4.a(r2, r1)
            goto L36
        L48:
            r3 = move-exception
            r1 = r0
            r2 = r0
        L4b:
            r4.a(r2, r1)
            throw r3
        L4f:
            r3 = move-exception
            r1 = r0
            goto L4b
        L52:
            r3 = move-exception
            r0 = r1
            r1 = r0
            goto L4b
        L56:
            r1 = move-exception
            r1 = r0
            goto L3e
        L59:
            r3 = move-exception
            goto L3e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.plugin.a.t.a(int, java.lang.String):com.qq.e.comm.plugin.a.c");
    }

    private c a(Cursor cursor) {
        if (cursor.moveToNext()) {
            String string = cursor.getString(cursor.getColumnIndex("targetid"));
            String string2 = cursor.getString(cursor.getColumnIndex("clickid"));
            String string3 = cursor.getString(cursor.getColumnIndex(AlaStaticKeys.ALA_STATIC_VALUE_ICON));
            String string4 = cursor.getString(cursor.getColumnIndex("url"));
            String string5 = cursor.getString(cursor.getColumnIndex("name"));
            String string6 = cursor.getString(cursor.getColumnIndex(Config.INPUT_DEF_PKG));
            long j = cursor.getLong(cursor.getColumnIndex("createtime"));
            int i = cursor.getInt(cursor.getColumnIndex("isreturned"));
            c cVar = new c(cursor.getString(cursor.getColumnIndex("adid")), string, string2, string3, string4, string5, string6, new Bundle(), GDTADManager.getInstance().getDeviceStatus().getNetworkType().getConnValue(), j, cursor.getInt(cursor.getColumnIndex("status")), cursor.getString(cursor.getColumnIndex("title")), cursor.getString(cursor.getColumnIndex("description")));
            cVar.b(cursor.getInt(cursor.getColumnIndex("id")));
            cVar.e(cursor.getString(cursor.getColumnIndex("failreason")));
            cVar.b(cursor.getInt(cursor.getColumnIndex("delayDownload")) != 0);
            cVar.a("totalSize", cursor.getInt(cursor.getColumnIndex("totalSize")));
            cVar.a("progress", cursor.getInt(cursor.getColumnIndex("progress")));
            cVar.a(i != 0);
            String string7 = cursor.getString(cursor.getColumnIndex("launchparam"));
            try {
                JSONObject jSONObject = StringUtil.isEmpty(string7) ? null : new JSONObject(string7);
                if (jSONObject != null) {
                    cVar.a(jSONObject);
                    cVar.a("autoInstall", jSONObject.optBoolean("autoInstall", true));
                    return cVar;
                }
                return cVar;
            } catch (JSONException e) {
                GDTLogger.w("Parse Task LaunchParam Error");
                return cVar;
            }
        }
        return null;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    private com.qq.e.comm.plugin.a.c a(java.lang.String r7, java.lang.String r8) {
        /*
            r6 = this;
            r0 = 0
            android.database.sqlite.SQLiteDatabase r2 = r6.getReadableDatabase()     // Catch: java.lang.Throwable -> L42
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L75
            r1.<init>()     // Catch: java.lang.Throwable -> L75
            java.lang.String r3 = "select * from tasks where "
            java.lang.StringBuilder r1 = r1.append(r3)     // Catch: java.lang.Throwable -> L75
            java.lang.StringBuilder r1 = r1.append(r7)     // Catch: java.lang.Throwable -> L75
            java.lang.String r3 = " = '"
            java.lang.StringBuilder r1 = r1.append(r3)     // Catch: java.lang.Throwable -> L75
            java.lang.StringBuilder r1 = r1.append(r8)     // Catch: java.lang.Throwable -> L75
            java.lang.String r3 = "'"
            java.lang.StringBuilder r1 = r1.append(r3)     // Catch: java.lang.Throwable -> L75
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L75
            r3 = 0
            android.database.Cursor r4 = r2.rawQuery(r1, r3)     // Catch: java.lang.Throwable -> L75
            boolean r1 = r6.b(r4)     // Catch: java.lang.Throwable -> L78
            if (r1 == 0) goto L3e
            com.qq.e.comm.plugin.a.c r0 = r6.a(r4)     // Catch: java.lang.Throwable -> L78
            r6.a(r2, r4)
        L3d:
            return r0
        L3e:
            r6.a(r2, r4)
            goto L3d
        L42:
            r1 = move-exception
            r2 = r0
            r4 = r0
        L45:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L71
            r3.<init>()     // Catch: java.lang.Throwable -> L71
            java.lang.String r5 = "Get TaskByColumn "
            java.lang.StringBuilder r3 = r3.append(r5)     // Catch: java.lang.Throwable -> L71
            java.lang.StringBuilder r3 = r3.append(r7)     // Catch: java.lang.Throwable -> L71
            java.lang.String r5 = " Error"
            java.lang.StringBuilder r3 = r3.append(r5)     // Catch: java.lang.Throwable -> L71
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L71
            com.qq.e.comm.util.GDTLogger.w(r3, r1)     // Catch: java.lang.Throwable -> L71
            r6.a(r2, r4)
            goto L3d
        L67:
            r3 = move-exception
            r1 = r0
            r2 = r0
        L6a:
            r6.a(r2, r1)
            throw r3
        L6e:
            r3 = move-exception
            r1 = r0
            goto L6a
        L71:
            r3 = move-exception
            r0 = r4
            r1 = r0
            goto L6a
        L75:
            r1 = move-exception
            r4 = r0
            goto L45
        L78:
            r1 = move-exception
            goto L45
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.plugin.a.t.a(java.lang.String, java.lang.String):com.qq.e.comm.plugin.a.c");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static t a(Context context) {
        if (f11648a == null) {
            synchronized ("GDTSDK.db") {
                try {
                    if (f11648a == null) {
                        f11648a = new t(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f11648a;
    }

    private void a(SQLiteDatabase sQLiteDatabase, Cursor cursor) {
        synchronized (this) {
            if (cursor != null) {
                cursor.close();
            }
            if (sQLiteDatabase != null && this.f11649b.decrementAndGet() == 0) {
                sQLiteDatabase.close();
            }
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    private java.util.List<com.qq.e.comm.plugin.a.c> b(java.lang.String r6) {
        /*
            r5 = this;
            r1 = 0
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            android.database.sqlite.SQLiteDatabase r2 = r5.getReadableDatabase()     // Catch: java.lang.Throwable -> L54
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L58
            r0.<init>()     // Catch: java.lang.Throwable -> L58
            java.lang.String r4 = "select * from tasks where status in "
            java.lang.StringBuilder r0 = r0.append(r4)     // Catch: java.lang.Throwable -> L58
            java.lang.StringBuilder r0 = r0.append(r6)     // Catch: java.lang.Throwable -> L58
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L58
            r4 = 0
            android.database.Cursor r0 = r2.rawQuery(r0, r4)     // Catch: java.lang.Throwable -> L58
        L23:
            boolean r1 = r5.b(r0)     // Catch: java.lang.Throwable -> L37
            if (r1 == 0) goto L42
            com.qq.e.comm.plugin.a.c r1 = r5.a(r0)     // Catch: java.lang.Throwable -> L37
            boolean r4 = com.qq.e.comm.plugin.a.e.a.a(r1)     // Catch: java.lang.Throwable -> L37
            if (r4 == 0) goto L23
            r3.add(r1)     // Catch: java.lang.Throwable -> L37
            goto L23
        L37:
            r1 = move-exception
        L38:
            java.lang.String r1 = "Get getTasksByStatus Error"
            com.qq.e.comm.util.GDTLogger.w(r1)     // Catch: java.lang.Throwable -> L50
            r5.a(r2, r0)
        L41:
            return r3
        L42:
            r5.a(r2, r0)
            goto L41
        L46:
            r3 = move-exception
            r0 = r1
            r2 = r1
        L49:
            r5.a(r2, r0)
            throw r3
        L4d:
            r3 = move-exception
            r0 = r1
            goto L49
        L50:
            r3 = move-exception
            r1 = r2
            r2 = r1
            goto L49
        L54:
            r0 = move-exception
            r2 = r1
            r0 = r1
            goto L38
        L58:
            r0 = move-exception
            r0 = r1
            goto L38
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.plugin.a.t.b(java.lang.String):java.util.List");
    }

    private boolean b(Cursor cursor) {
        return cursor.getCount() > 0 && !cursor.isLast();
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    private java.util.List<com.qq.e.comm.plugin.a.c> c(java.lang.String r6) {
        /*
            r5 = this;
            r1 = 0
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            android.database.sqlite.SQLiteDatabase r2 = r5.getReadableDatabase()     // Catch: java.lang.Throwable -> L4e
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L52
            r0.<init>()     // Catch: java.lang.Throwable -> L52
            java.lang.String r4 = "select * from tasks where status in "
            java.lang.StringBuilder r0 = r0.append(r4)     // Catch: java.lang.Throwable -> L52
            java.lang.StringBuilder r0 = r0.append(r6)     // Catch: java.lang.Throwable -> L52
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L52
            r4 = 0
            android.database.Cursor r0 = r2.rawQuery(r0, r4)     // Catch: java.lang.Throwable -> L52
        L23:
            boolean r1 = r5.b(r0)     // Catch: java.lang.Throwable -> L31
            if (r1 == 0) goto L3c
            com.qq.e.comm.plugin.a.c r1 = r5.a(r0)     // Catch: java.lang.Throwable -> L31
            r3.add(r1)     // Catch: java.lang.Throwable -> L31
            goto L23
        L31:
            r1 = move-exception
        L32:
            java.lang.String r1 = "Get getTasksByStatus Error"
            com.qq.e.comm.util.GDTLogger.w(r1)     // Catch: java.lang.Throwable -> L4a
            r5.a(r2, r0)
        L3b:
            return r3
        L3c:
            r5.a(r2, r0)
            goto L3b
        L40:
            r3 = move-exception
            r0 = r1
            r2 = r1
        L43:
            r5.a(r2, r0)
            throw r3
        L47:
            r3 = move-exception
            r0 = r1
            goto L43
        L4a:
            r3 = move-exception
            r1 = r2
            r2 = r1
            goto L43
        L4e:
            r0 = move-exception
            r2 = r1
            r0 = r1
            goto L32
        L52:
            r0 = move-exception
            r0 = r1
            goto L32
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.plugin.a.t.c(java.lang.String):java.util.List");
    }

    private ContentValues e(c cVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("targetid", cVar.j());
        contentValues.put("clickid", cVar.k());
        contentValues.put("url", cVar.g());
        contentValues.put("name", cVar.f());
        contentValues.put(Config.INPUT_DEF_PKG, cVar.h());
        contentValues.put("tracer", "");
        contentValues.put(AlaStaticKeys.ALA_STATIC_VALUE_ICON, cVar.i());
        contentValues.put("createtime", Long.valueOf(cVar.d()));
        contentValues.put("isreturned", Boolean.valueOf(cVar.c()));
        contentValues.put("title", cVar.a());
        contentValues.put("description", cVar.b());
        contentValues.put("network", Integer.valueOf(cVar.e()));
        contentValues.put("status", Integer.valueOf(cVar.o()));
        contentValues.put("failreason", cVar.a("failReason"));
        String a2 = cVar.a(ConstantsAPI.Token.WX_LAUNCH_PARAM_KEY);
        if (a2 == null) {
            a2 = "";
        }
        contentValues.put("launchparam", a2);
        contentValues.put("adid", cVar.l());
        contentValues.put("delayDownload", Integer.valueOf(cVar.r() ? 1 : 0));
        contentValues.put("manualPaused", Integer.valueOf(cVar.b("manualPause")));
        contentValues.put("totalSize", Long.valueOf(cVar.c("totalSize")));
        contentValues.put("progress", Integer.valueOf(cVar.b("progress")));
        return contentValues;
    }

    public int a(c cVar) {
        SQLiteDatabase sQLiteDatabase;
        com.qq.e.comm.plugin.y.c b2 = new com.qq.e.comm.plugin.y.c().b(cVar.l());
        u.a(60602, 0, b2);
        long j = -1;
        try {
            sQLiteDatabase = getWritableDatabase();
        } catch (Throwable th) {
            th = th;
            sQLiteDatabase = null;
        }
        try {
            j = sQLiteDatabase.insert("tasks", null, e(cVar));
            if (j > 0) {
                cVar.b((int) j);
            }
            GDTLogger.d("TEST_DB:new taskID=" + j);
            a(sQLiteDatabase, (Cursor) null);
        } catch (Throwable th2) {
            th = th2;
            try {
                GDTLogger.w("Add New Task Error");
                com.qq.e.comm.plugin.y.d dVar = new com.qq.e.comm.plugin.y.d();
                dVar.a("ot", th.toString());
                u.a(60612, 0, b2, dVar);
                a(sQLiteDatabase, (Cursor) null);
                return (int) j;
            } catch (Throwable th3) {
                a(sQLiteDatabase, (Cursor) null);
                throw th3;
            }
        }
        return (int) j;
    }

    public c a(int i) {
        return a("id", i + "");
    }

    public c a(String str) {
        return a(Config.INPUT_DEF_PKG, str);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    public java.util.List<com.qq.e.comm.plugin.a.c> a() {
        /*
            r10 = this;
            r8 = 0
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            android.database.sqlite.SQLiteDatabase r0 = r10.getReadableDatabase()     // Catch: java.lang.Throwable -> L4c
            java.lang.String r1 = "tasks"
            r2 = 0
            java.lang.String r3 = "delayDownload=?"
            r4 = 1
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch: java.lang.Throwable -> L50
            r5 = 0
            java.lang.String r6 = "1"
            r4[r5] = r6     // Catch: java.lang.Throwable -> L50
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r8 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L50
        L21:
            boolean r1 = r10.b(r8)     // Catch: java.lang.Throwable -> L2f
            if (r1 == 0) goto L3b
            com.qq.e.comm.plugin.a.c r1 = r10.a(r8)     // Catch: java.lang.Throwable -> L2f
            r9.add(r1)     // Catch: java.lang.Throwable -> L2f
            goto L21
        L2f:
            r1 = move-exception
            r1 = r8
        L31:
            java.lang.String r2 = "Get DelayDownload Tasks Error"
            com.qq.e.comm.util.GDTLogger.w(r2)     // Catch: java.lang.Throwable -> L53
            r10.a(r0, r1)
        L3a:
            return r9
        L3b:
            r10.a(r0, r8)
            goto L3a
        L3f:
            r2 = move-exception
            r0 = r8
            r1 = r8
        L42:
            r10.a(r0, r1)
            throw r2
        L46:
            r2 = move-exception
            r1 = r8
            goto L42
        L49:
            r2 = move-exception
        L4a:
            r1 = r8
            goto L42
        L4c:
            r0 = move-exception
            r1 = r8
            r0 = r8
            goto L31
        L50:
            r1 = move-exception
            r1 = r8
            goto L31
        L53:
            r2 = move-exception
            r8 = r1
            goto L4a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.plugin.a.t.a():java.util.List");
    }

    public int b(@NonNull c cVar) {
        SQLiteDatabase sQLiteDatabase;
        int i = 0;
        com.qq.e.comm.plugin.y.c b2 = new com.qq.e.comm.plugin.y.c().b(cVar.l());
        u.a(60622, 0, b2);
        int m = cVar.m();
        if (m > 0) {
            try {
                sQLiteDatabase = getWritableDatabase();
                try {
                    i = sQLiteDatabase.update("tasks", e(cVar), " id=" + m, null);
                    a(sQLiteDatabase, (Cursor) null);
                } catch (Throwable th) {
                    th = th;
                    try {
                        GDTLogger.w("Update Task Error");
                        com.qq.e.comm.plugin.y.d dVar = new com.qq.e.comm.plugin.y.d();
                        dVar.a("ot", th.toString());
                        u.a(60632, 0, b2, dVar);
                        a(sQLiteDatabase, (Cursor) null);
                        return i;
                    } catch (Throwable th2) {
                        a(sQLiteDatabase, (Cursor) null);
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                sQLiteDatabase = null;
            }
        }
        return i;
    }

    public c b(int i) {
        return a(i, new String("(4)"));
    }

    public List<c> b() {
        return c(new String("(4,32,16)"));
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    public int c(com.qq.e.comm.plugin.a.c r14) {
        /*
            r13 = this;
            r8 = -1
            r10 = 1
            r11 = 0
            r9 = 0
            com.qq.e.comm.plugin.y.c r0 = new com.qq.e.comm.plugin.y.c
            r0.<init>()
            java.lang.String r1 = r14.l()
            com.qq.e.comm.plugin.y.c r12 = r0.b(r1)
            r0 = 60642(0xece2, float:8.4978E-41)
            com.qq.e.comm.plugin.y.u.a(r0, r11, r12)
            android.database.sqlite.SQLiteDatabase r0 = r13.getReadableDatabase()     // Catch: java.lang.Throwable -> L5a
            java.lang.String r1 = "tasks"
            r2 = 0
            java.lang.String r3 = "delayDownload=?"
            r4 = 1
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch: java.lang.Throwable -> L90
            r5 = 0
            java.lang.String r6 = "1"
            r4[r5] = r6     // Catch: java.lang.Throwable -> L90
            r5 = 0
            r6 = 0
            java.lang.String r7 = "createtime"
            android.database.Cursor r2 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L90
            boolean r1 = r13.b(r2)     // Catch: java.lang.Throwable -> L94
            if (r1 == 0) goto L97
            int r1 = r2.getCount()     // Catch: java.lang.Throwable -> L94
            r3 = 3
            if (r1 != r3) goto L97
            com.qq.e.comm.plugin.a.c r1 = r13.a(r2)     // Catch: java.lang.Throwable -> L94
            int r1 = r13.d(r1)     // Catch: java.lang.Throwable -> L94
            if (r1 != r10) goto L56
            r1 = r10
        L4c:
            if (r1 == 0) goto L58
            int r1 = r13.a(r14)     // Catch: java.lang.Throwable -> L94
        L52:
            r13.a(r0, r2)
        L55:
            return r1
        L56:
            r1 = r11
            goto L4c
        L58:
            r1 = r8
            goto L52
        L5a:
            r1 = move-exception
            r2 = r9
            r3 = r9
        L5d:
            java.lang.String r0 = "Add DelayDownload Tasks Error"
            com.qq.e.comm.util.GDTLogger.w(r0)     // Catch: java.lang.Throwable -> L8d
            com.qq.e.comm.plugin.y.d r0 = new com.qq.e.comm.plugin.y.d     // Catch: java.lang.Throwable -> L8d
            r0.<init>()     // Catch: java.lang.Throwable -> L8d
            java.lang.String r4 = "ot"
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L8d
            r0.a(r4, r1)     // Catch: java.lang.Throwable -> L8d
            r1 = 60652(0xecec, float:8.4992E-41)
            r4 = 0
            com.qq.e.comm.plugin.y.u.a(r1, r4, r12, r0)     // Catch: java.lang.Throwable -> L8d
            r13.a(r3, r2)
            r1 = r8
            goto L55
        L7e:
            r0 = move-exception
            r1 = r0
            r2 = r9
            r3 = r9
        L82:
            r13.a(r3, r2)
            throw r1
        L86:
            r1 = move-exception
            r2 = r9
            r3 = r0
            goto L82
        L8a:
            r1 = move-exception
            r3 = r0
            goto L82
        L8d:
            r0 = move-exception
            r1 = r0
            goto L82
        L90:
            r1 = move-exception
            r2 = r9
            r3 = r0
            goto L5d
        L94:
            r1 = move-exception
            r3 = r0
            goto L5d
        L97:
            r1 = r10
            goto L4c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.plugin.a.t.c(com.qq.e.comm.plugin.a.c):int");
    }

    public c c(int i) {
        return a(i, new String("(32,16)"));
    }

    public List<c> c() {
        return c(new String("(4)"));
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    public int d(com.qq.e.comm.plugin.a.c r9) {
        /*
            r8 = this;
            r0 = 0
            r2 = 0
            android.database.sqlite.SQLiteDatabase r1 = r8.getWritableDatabase()     // Catch: java.lang.Throwable -> L22
            java.lang.String r3 = "tasks"
            java.lang.String r4 = "id=?"
            r5 = 1
            java.lang.String[] r5 = new java.lang.String[r5]     // Catch: java.lang.Throwable -> L32
            r6 = 0
            int r7 = r9.m()     // Catch: java.lang.Throwable -> L32
            java.lang.String r7 = java.lang.String.valueOf(r7)     // Catch: java.lang.Throwable -> L32
            r5[r6] = r7     // Catch: java.lang.Throwable -> L32
            int r0 = r1.delete(r3, r4, r5)     // Catch: java.lang.Throwable -> L32
            r8.a(r1, r2)
        L21:
            return r0
        L22:
            r1 = move-exception
            r1 = r2
        L24:
            r8.a(r1, r2)
            goto L21
        L28:
            r1 = move-exception
            r0 = r2
            r3 = r1
        L2b:
            r8.a(r0, r2)
            throw r3
        L2f:
            r3 = move-exception
            r0 = r1
            goto L2b
        L32:
            r3 = move-exception
            goto L24
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.plugin.a.t.d(com.qq.e.comm.plugin.a.c):int");
    }

    public List<c> d() {
        return b("(8)");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public SQLiteDatabase getReadableDatabase() {
        SQLiteDatabase sQLiteDatabase;
        synchronized (this) {
            if (this.f11649b.incrementAndGet() == 1) {
                c = super.getReadableDatabase();
            }
            sQLiteDatabase = c;
        }
        return sQLiteDatabase;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public SQLiteDatabase getWritableDatabase() {
        SQLiteDatabase sQLiteDatabase;
        synchronized (this) {
            if (this.f11649b.incrementAndGet() == 1) {
                c = super.getWritableDatabase();
            }
            sQLiteDatabase = c;
        }
        return sQLiteDatabase;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("create table tasks   (   id integer primary key autoincrement,   adid text not null,   targetid text not null,   clickid text not null,   url text not null unique,   name text not null,   pkg text not null,   tracer text,   icon text not null,   createtime integer not null,   isreturned integer,   title text,   description text,   network integer not null,   status integer not null,   failreason text,   launchparam text,   delayDownload integer not null,   manualPaused integer not null,   progress integer not null,   totalSize integer not null)");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i2 == 9) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS tasks");
            onCreate(sQLiteDatabase);
        }
    }
}

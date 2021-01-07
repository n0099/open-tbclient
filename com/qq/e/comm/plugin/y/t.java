package com.qq.e.comm.plugin.y;

import android.database.sqlite.SQLiteDatabase;
import com.qq.e.comm.plugin.util.ai;
import com.qq.e.comm.plugin.y.n;
import com.qq.e.comm.util.GDTLogger;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class t<DataType extends n> {

    /* renamed from: a  reason: collision with root package name */
    private final String f13031a;

    /* renamed from: b  reason: collision with root package name */
    private final String f13032b;
    private final String c;
    private int d = 0;
    private i e;
    private a<DataType> f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public interface a<DataType> {
        DataType b(int i, String str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(String str, a<DataType> aVar) {
        this.f13031a = str;
        this.f13032b = "create table " + str + "(id integer primary key autoincrement,content text not null,ts long not null)";
        this.c = "id not in (select id from " + str + " order by ts desc limit 1000)";
        this.f = aVar;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    java.util.List<DataType> a() {
        /*
            r11 = this;
            r10 = 0
            r8 = 0
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            com.qq.e.comm.plugin.y.i r0 = r11.e     // Catch: java.lang.Throwable -> Ldc
            android.database.sqlite.SQLiteDatabase r0 = r0.getReadableDatabase()     // Catch: java.lang.Throwable -> Ldc
            java.lang.String r1 = r11.f13031a     // Catch: java.lang.Throwable -> Le1
            r2 = 2
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch: java.lang.Throwable -> Le1
            r3 = 0
            java.lang.String r4 = "id"
            r2[r3] = r4     // Catch: java.lang.Throwable -> Le1
            r3 = 1
            java.lang.String r4 = "content"
            r2[r3] = r4     // Catch: java.lang.Throwable -> Le1
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            java.lang.String r7 = "ts"
            android.database.Cursor r8 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> Le1
            if (r8 == 0) goto L31
            int r1 = r8.getCount()     // Catch: java.lang.Throwable -> Lac
            if (r1 > 0) goto L82
        L31:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lac
            r1.<init>()     // Catch: java.lang.Throwable -> Lac
            java.lang.String r2 = "Read stat 0 from table: "
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.lang.Throwable -> Lac
            java.lang.String r2 = r11.f13031a     // Catch: java.lang.Throwable -> Lac
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.lang.Throwable -> Lac
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> Lac
            r2 = 0
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> Lac
            com.qq.e.comm.plugin.util.ai.a(r1, r2)     // Catch: java.lang.Throwable -> Lac
        L4d:
            if (r8 == 0) goto L52
            r8.close()
        L52:
            if (r0 == 0) goto L57
            r0.close()     // Catch: java.lang.Throwable -> Le5
        L57:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Read stat data: "
            java.lang.StringBuilder r0 = r0.append(r1)
            int r1 = r9.size()
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r1 = " from table: "
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r1 = r11.f13031a
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.Object[] r1 = new java.lang.Object[r10]
            com.qq.e.comm.plugin.util.ai.a(r0, r1)
            return r9
        L82:
            boolean r1 = r8.moveToNext()     // Catch: java.lang.Throwable -> Lac
            if (r1 == 0) goto L4d
            java.lang.String r1 = "id"
            int r1 = r8.getColumnIndex(r1)     // Catch: java.lang.Throwable -> Lac
            int r1 = r8.getInt(r1)     // Catch: java.lang.Throwable -> Lac
            java.lang.String r2 = "content"
            int r2 = r8.getColumnIndex(r2)     // Catch: java.lang.Throwable -> Lac
            java.lang.String r2 = r8.getString(r2)     // Catch: java.lang.Throwable -> Lac
            com.qq.e.comm.plugin.y.t$a<DataType extends com.qq.e.comm.plugin.y.n> r3 = r11.f     // Catch: java.lang.Throwable -> Lac
            java.lang.Object r1 = r3.b(r1, r2)     // Catch: java.lang.Throwable -> Lac
            com.qq.e.comm.plugin.y.n r1 = (com.qq.e.comm.plugin.y.n) r1     // Catch: java.lang.Throwable -> Lac
            if (r1 == 0) goto L82
            r9.add(r1)     // Catch: java.lang.Throwable -> Lac
            goto L82
        Lac:
            r1 = move-exception
            r2 = r0
            r3 = r8
        Laf:
            java.lang.String r0 = "Read stat db failed"
            com.qq.e.comm.util.GDTLogger.e(r0, r1)     // Catch: java.lang.Throwable -> Ld9
            if (r3 == 0) goto Lba
            r3.close()
        Lba:
            if (r2 == 0) goto L57
            r2.close()     // Catch: java.lang.Throwable -> Lc0
            goto L57
        Lc0:
            r0 = move-exception
            goto L57
        Lc2:
            r0 = move-exception
            r1 = r0
            r2 = r8
            r3 = r8
        Lc6:
            if (r3 == 0) goto Lcb
            r3.close()
        Lcb:
            if (r2 == 0) goto Ld0
            r2.close()     // Catch: java.lang.Throwable -> Le8
        Ld0:
            throw r1
        Ld1:
            r1 = move-exception
            r2 = r0
            r3 = r8
            goto Lc6
        Ld5:
            r1 = move-exception
            r2 = r0
            r3 = r8
            goto Lc6
        Ld9:
            r0 = move-exception
            r1 = r0
            goto Lc6
        Ldc:
            r0 = move-exception
            r1 = r0
            r2 = r8
            r3 = r8
            goto Laf
        Le1:
            r1 = move-exception
            r2 = r0
            r3 = r8
            goto Laf
        Le5:
            r0 = move-exception
            goto L57
        Le8:
            r0 = move-exception
            goto Ld0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.plugin.y.t.a():java.util.List");
    }

    public void a(SQLiteDatabase sQLiteDatabase) throws Throwable {
        sQLiteDatabase.execSQL(this.f13032b);
        this.d = 0;
    }

    public void a(i iVar) {
        this.e = iVar;
        this.d = a().size();
        ai.a("Stat db init: total " + this.f13031a + " count=" + this.d, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(List<DataType> list) {
        SQLiteDatabase sQLiteDatabase = null;
        if (list == null || list.size() <= 0) {
            return;
        }
        try {
            sQLiteDatabase = this.e.getWritableDatabase();
            sQLiteDatabase.beginTransaction();
            StringBuilder append = new StringBuilder("insert into ").append(this.f13031a).append(" (").append("content").append(", ").append("ts").append(") ");
            DataType datatype = list.get(0);
            append.append("select '").append(datatype.b()).append("', ").append(datatype.c());
            int size = list.size();
            for (int i = 1; i < size; i++) {
                DataType datatype2 = list.get(i);
                append.append(" union all select '").append(datatype2.b()).append("', ").append(datatype2.c());
            }
            sQLiteDatabase.execSQL(append.toString());
            int delete = sQLiteDatabase.delete(this.f13031a, this.c, null);
            int size2 = list.size();
            ai.a("Insert stat:" + list.size() + ", delete stat: " + delete + " from table: " + this.f13031a, new Object[0]);
            sQLiteDatabase.setTransactionSuccessful();
            this.d = (size2 - delete) + this.d;
            if (sQLiteDatabase != null) {
                try {
                    sQLiteDatabase.endTransaction();
                    sQLiteDatabase.close();
                } catch (Throwable th) {
                }
            }
        } catch (Throwable th2) {
            try {
                GDTLogger.e("Insert stat db failed", th2);
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.endTransaction();
                        sQLiteDatabase.close();
                    } catch (Throwable th3) {
                    }
                }
            } catch (Throwable th4) {
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.endTransaction();
                        sQLiteDatabase.close();
                    } catch (Throwable th5) {
                    }
                }
                throw th4;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Set<Integer> set) {
        SQLiteDatabase sQLiteDatabase = null;
        if (set == null || set.size() == 0) {
            return;
        }
        Iterator<Integer> it = set.iterator();
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        if (it.hasNext()) {
            sb.append(it.next());
        }
        while (it.hasNext()) {
            sb.append(",").append(it.next());
        }
        sb.append(")");
        try {
            sQLiteDatabase = this.e.getWritableDatabase();
            int delete = sQLiteDatabase.delete(this.f13031a, "id in " + sb.toString(), null);
            ai.a("Delete stat count: " + delete + " from table: " + this.f13031a, new Object[0]);
            this.d -= delete;
            if (this.d < 0) {
                this.d = 0;
            }
            if (sQLiteDatabase != null) {
                try {
                    sQLiteDatabase.close();
                } catch (Throwable th) {
                }
            }
        } catch (Throwable th2) {
            try {
                GDTLogger.e("Delete stat db failed", th2);
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.close();
                    } catch (Throwable th3) {
                    }
                }
            } catch (Throwable th4) {
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.close();
                    } catch (Throwable th5) {
                    }
                }
                throw th4;
            }
        }
    }

    public long b() {
        return this.d;
    }

    public void b(SQLiteDatabase sQLiteDatabase) throws Throwable {
        sQLiteDatabase.execSQL("drop table if exists " + this.f13031a);
        this.d = 0;
    }
}

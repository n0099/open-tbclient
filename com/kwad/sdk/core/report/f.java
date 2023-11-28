package com.kwad.sdk.core.report;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes10.dex */
public abstract class f implements o<g> {
    public e avw;

    public abstract String Du();

    public abstract String Dv();

    public abstract g g(@NonNull Cursor cursor);

    public abstract String getTag();

    public f(e eVar) {
        a(eVar);
    }

    private void a(e eVar) {
        this.avw = eVar;
    }

    private synchronized void c(g gVar) {
        String tag = getTag();
        com.kwad.sdk.core.e.c.d(tag, "deleteAction action = " + gVar);
        try {
            this.avw.getReadableDatabase().delete(Du(), "actionId=?", new String[]{gVar.actionId});
        } catch (Exception e) {
            com.kwad.sdk.core.e.c.printStackTrace(e);
        }
    }

    @Override // com.kwad.sdk.core.report.o
    public final synchronized List<g> Dw() {
        Cursor cursor = null;
        try {
            String Dv = Dv();
            if (!TextUtils.isEmpty(Dv)) {
                cursor = this.avw.getReadableDatabase().rawQuery(Dv, null);
            }
            if (cursor != null) {
                ArrayList arrayList = new ArrayList();
                while (cursor.moveToNext()) {
                    try {
                        arrayList.add(g(cursor));
                    } catch (Exception e) {
                        com.kwad.sdk.core.e.c.printStackTrace(e);
                    }
                }
                String tag = getTag();
                com.kwad.sdk.core.e.c.d(tag, "read size= " + arrayList.size());
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    String tag2 = getTag();
                    com.kwad.sdk.core.e.c.d(tag2, "read action=" + ((g) it.next()));
                }
                com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
                return arrayList;
            }
        } catch (Exception e2) {
            com.kwad.sdk.core.e.c.printStackTrace(e2);
        }
        com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
        return new ArrayList();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.report.o
    /* renamed from: b */
    public final synchronized void j(g gVar) {
        String tag = getTag();
        com.kwad.sdk.core.e.c.d(tag, "write = " + gVar);
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("actionId", gVar.actionId);
            contentValues.put("aLog", gVar.toJson().toString());
            try {
                this.avw.getReadableDatabase().insert(Du(), null, contentValues);
            } catch (Exception e) {
                com.kwad.sdk.core.e.c.printStackTrace(e);
            }
        } catch (Exception e2) {
            com.kwad.sdk.core.e.c.printStackTrace(e2);
        }
    }

    @Override // com.kwad.sdk.core.report.o
    public final synchronized long size() {
        long j;
        Cursor cursor = null;
        try {
            SQLiteDatabase readableDatabase = this.avw.getReadableDatabase();
            cursor = readableDatabase.rawQuery("select count(*) from " + Du(), null);
            cursor.moveToFirst();
            j = cursor.getLong(0);
            com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
        } catch (Exception e) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(e);
            com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
            j = 0;
        }
        return j;
    }

    @Override // com.kwad.sdk.core.report.o
    public final synchronized void v(List<g> list) {
        String tag = getTag();
        com.kwad.sdk.core.e.c.d(tag, "delete size= " + list.size());
        SQLiteDatabase sQLiteDatabase = null;
        try {
            sQLiteDatabase = this.avw.getReadableDatabase();
            sQLiteDatabase.beginTransaction();
            for (g gVar : list) {
                c(gVar);
            }
            sQLiteDatabase.setTransactionSuccessful();
            if (sQLiteDatabase != null) {
                try {
                    sQLiteDatabase.endTransaction();
                } catch (Exception e) {
                    com.kwad.sdk.core.e.c.printStackTrace(e);
                }
            }
        } catch (Exception e2) {
            com.kwad.sdk.core.e.c.printStackTrace(e2);
            if (sQLiteDatabase != null) {
                try {
                    sQLiteDatabase.endTransaction();
                } catch (Exception e3) {
                    com.kwad.sdk.core.e.c.printStackTrace(e3);
                }
            }
        }
    }
}

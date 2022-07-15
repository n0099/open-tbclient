package com.kwad.sdk.core.report;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class p implements j<m> {
    public static volatile p a;
    public final SQLiteDatabase b;
    public final List<n> c = new ArrayList();

    public p(Context context) {
        this.b = new o(context, o.a).getWritableDatabase();
        this.c.add(new h());
    }

    private synchronized m a(@NonNull Cursor cursor) {
        try {
            JSONObject jSONObject = new JSONObject(cursor.getString(cursor.getColumnIndex("aLog")));
            int size = this.c.size() - 1;
            if (size >= 0) {
                return this.c.get(size).a(jSONObject);
            }
            return new m(jSONObject);
        } catch (JSONException e) {
            com.kwad.sdk.core.d.b.a(e);
            return new m("");
        }
    }

    public static p a(Context context) {
        if (a == null) {
            synchronized (p.class) {
                if (a == null) {
                    a = new p(context);
                }
            }
        }
        return a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.report.j
    public synchronized void a(m mVar) {
        ContentValues contentValues;
        com.kwad.sdk.core.d.b.a("ReportActionDBManager", "write = " + mVar);
        try {
            contentValues = new ContentValues();
            contentValues.put("actionId", mVar.a);
            contentValues.put("aLog", mVar.toJson().toString());
        } catch (Exception e) {
            com.kwad.sdk.core.d.b.a(e);
        }
        try {
            this.b.insert("ksad_actions", null, contentValues);
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.a(e2);
        }
    }

    private synchronized void b(m mVar) {
        com.kwad.sdk.core.d.b.a("ReportActionDBManager", "deleteAction action = " + mVar);
        try {
            this.b.delete("ksad_actions", "actionId=?", new String[]{mVar.a});
        } catch (Exception e) {
            com.kwad.sdk.core.d.b.a(e);
        }
    }

    @Override // com.kwad.sdk.core.report.j
    public final synchronized long a() {
        long j;
        Cursor cursor = null;
        try {
            cursor = this.b.rawQuery("select count(*) from ksad_actions", null);
            cursor.moveToFirst();
            j = cursor.getLong(0);
            com.kwad.sdk.crash.utils.b.a(cursor);
        } catch (Exception e) {
            com.kwad.sdk.core.d.b.b(e);
            com.kwad.sdk.crash.utils.b.a(cursor);
            j = 0;
        }
        return j;
    }

    @Override // com.kwad.sdk.core.report.j
    public final synchronized void a(List<m> list) {
        com.kwad.sdk.core.d.b.a("ReportActionDBManager", "delete size= " + list.size());
        try {
            this.b.beginTransaction();
            for (m mVar : list) {
                b(mVar);
            }
            this.b.setTransactionSuccessful();
            this.b.endTransaction();
        } catch (Exception e) {
            com.kwad.sdk.core.d.b.a(e);
        }
    }

    @Override // com.kwad.sdk.core.report.j
    public final synchronized List<m> b() {
        Cursor cursor = null;
        try {
            cursor = this.b.rawQuery("select  * from ksad_actions", null);
            if (cursor != null) {
                ArrayList arrayList = new ArrayList();
                while (cursor.moveToNext()) {
                    try {
                        arrayList.add(a(cursor));
                    } catch (Exception e) {
                        com.kwad.sdk.core.d.b.a(e);
                    }
                }
                com.kwad.sdk.core.d.b.a("ReportActionDBManager", "read size= " + arrayList.size());
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    com.kwad.sdk.core.d.b.a("ReportActionDBManager", "read action=" + ((m) it.next()));
                }
                com.kwad.sdk.crash.utils.b.a(cursor);
                return arrayList;
            }
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.a(e2);
        }
        com.kwad.sdk.crash.utils.b.a(cursor);
        return new ArrayList();
    }
}

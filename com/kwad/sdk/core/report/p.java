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
/* loaded from: classes9.dex */
public class p implements j<m> {
    public static volatile p abr;
    public final SQLiteDatabase CR;
    public final List<n> abs = new ArrayList();

    public p(Context context) {
        this.CR = new o(context, o.CU).getWritableDatabase();
        this.abs.add(new h());
    }

    public static p bx(Context context) {
        if (abr == null) {
            synchronized (p.class) {
                if (abr == null) {
                    abr = new p(context);
                }
            }
        }
        return abr;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.report.j
    /* renamed from: c */
    public synchronized void d(m mVar) {
        ContentValues contentValues;
        com.kwad.sdk.core.e.b.d("ReportActionDBManager", "write = " + mVar);
        try {
            contentValues = new ContentValues();
            contentValues.put("actionId", mVar.ZR);
            contentValues.put("aLog", mVar.toJson().toString());
        } catch (Exception e) {
            com.kwad.sdk.core.e.b.printStackTrace(e);
        }
        try {
            this.CR.insert("ksad_actions", null, contentValues);
        } catch (Exception e2) {
            com.kwad.sdk.core.e.b.printStackTrace(e2);
        }
    }

    /* renamed from: d  reason: avoid collision after fix types in other method */
    private synchronized void d2(m mVar) {
        com.kwad.sdk.core.e.b.d("ReportActionDBManager", "deleteAction action = " + mVar);
        try {
            this.CR.delete("ksad_actions", "actionId=?", new String[]{mVar.ZR});
        } catch (Exception e) {
            com.kwad.sdk.core.e.b.printStackTrace(e);
        }
    }

    private synchronized m e(@NonNull Cursor cursor) {
        try {
            JSONObject jSONObject = new JSONObject(cursor.getString(cursor.getColumnIndex("aLog")));
            int size = this.abs.size() - 1;
            if (size >= 0) {
                return this.abs.get(size).f(jSONObject);
            }
            return new m(jSONObject);
        } catch (JSONException e) {
            com.kwad.sdk.core.e.b.printStackTrace(e);
            return new m("");
        }
    }

    @Override // com.kwad.sdk.core.report.j
    public final synchronized void q(List<m> list) {
        com.kwad.sdk.core.e.b.d("ReportActionDBManager", "delete size= " + list.size());
        try {
            this.CR.beginTransaction();
            for (m mVar : list) {
                d2(mVar);
            }
            this.CR.setTransactionSuccessful();
            if (this.CR != null) {
                try {
                    this.CR.endTransaction();
                } catch (Exception e) {
                    com.kwad.sdk.core.e.b.printStackTrace(e);
                }
            }
        } catch (Exception e2) {
            com.kwad.sdk.core.e.b.printStackTrace(e2);
            if (this.CR != null) {
                try {
                    this.CR.endTransaction();
                } catch (Exception e3) {
                    com.kwad.sdk.core.e.b.printStackTrace(e3);
                }
            }
        }
    }

    @Override // com.kwad.sdk.core.report.j
    public final synchronized long size() {
        long j;
        Cursor cursor = null;
        try {
            cursor = this.CR.rawQuery("select count(*) from ksad_actions", null);
            cursor.moveToFirst();
            j = cursor.getLong(0);
            com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
        } catch (Exception e) {
            com.kwad.sdk.core.e.b.printStackTraceOnly(e);
            com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
            j = 0;
        }
        return j;
    }

    @Override // com.kwad.sdk.core.report.j
    public final synchronized List<m> uy() {
        Cursor cursor = null;
        try {
            cursor = this.CR.rawQuery("select  * from ksad_actions", null);
            if (cursor != null) {
                ArrayList arrayList = new ArrayList();
                while (cursor.moveToNext()) {
                    try {
                        arrayList.add(e(cursor));
                    } catch (Exception e) {
                        com.kwad.sdk.core.e.b.printStackTrace(e);
                    }
                }
                com.kwad.sdk.core.e.b.d("ReportActionDBManager", "read size= " + arrayList.size());
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    com.kwad.sdk.core.e.b.d("ReportActionDBManager", "read action=" + ((m) it.next()));
                }
                com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
                return arrayList;
            }
        } catch (Exception e2) {
            com.kwad.sdk.core.e.b.printStackTrace(e2);
        }
        com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
        return new ArrayList();
    }
}

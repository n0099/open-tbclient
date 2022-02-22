package com.kwad.sdk.core.report;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import androidx.annotation.NonNull;
import com.kwad.sdk.utils.ae;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class l implements h<ReportAction> {
    public static volatile l a;

    /* renamed from: b  reason: collision with root package name */
    public SQLiteDatabase f56266b;

    public l(Context context) {
        this.f56266b = new k(context, k.a).getWritableDatabase();
    }

    private synchronized ReportAction a(@NonNull Cursor cursor) {
        return ReportAction.a(cursor.getString(cursor.getColumnIndex("aLog")));
    }

    public static l a(Context context) {
        if (a == null) {
            synchronized (l.class) {
                if (a == null) {
                    a = new l(context);
                }
            }
        }
        return a;
    }

    private synchronized void b(ReportAction reportAction) {
        com.kwad.sdk.core.d.a.a("ReportActionDBManager", "deleteAction action = " + reportAction);
        try {
            this.f56266b.delete("ksad_actions", "actionId=?", new String[]{reportAction.a});
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.a(e2);
        }
    }

    @Override // com.kwad.sdk.core.report.h
    public synchronized long a() {
        long j2;
        Cursor cursor = null;
        try {
            cursor = this.f56266b.rawQuery("select count(*) from ksad_actions", null);
            cursor.moveToFirst();
            j2 = cursor.getLong(0);
            ae.a(cursor);
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.b(e2);
            ae.a(cursor);
            j2 = 0;
        }
        return j2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.report.h
    public synchronized void a(ReportAction reportAction) {
        com.kwad.sdk.core.d.a.a("ReportActionDBManager", "write = " + reportAction);
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("actionId", reportAction.a);
            contentValues.put("aLog", reportAction.toJson().toString());
            try {
                this.f56266b.insert("ksad_actions", null, contentValues);
            } catch (Exception e2) {
                com.kwad.sdk.core.d.a.a(e2);
            }
        } catch (Exception e3) {
            com.kwad.sdk.core.d.a.a(e3);
        }
    }

    @Override // com.kwad.sdk.core.report.h
    public synchronized void a(List<ReportAction> list) {
        com.kwad.sdk.core.d.a.a("ReportActionDBManager", "delete size= " + list.size());
        try {
            this.f56266b.beginTransaction();
            for (ReportAction reportAction : list) {
                b(reportAction);
            }
            this.f56266b.setTransactionSuccessful();
            this.f56266b.endTransaction();
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.a(e2);
        }
    }

    @Override // com.kwad.sdk.core.report.h
    public synchronized List<ReportAction> b() {
        Cursor cursor = null;
        try {
            cursor = this.f56266b.rawQuery("select  * from ksad_actions", null);
            if (cursor != null) {
                ArrayList arrayList = new ArrayList();
                while (cursor.moveToNext()) {
                    try {
                        arrayList.add(a(cursor));
                    } catch (Exception e2) {
                        com.kwad.sdk.core.d.a.a(e2);
                    }
                }
                com.kwad.sdk.core.d.a.a("ReportActionDBManager", "read size= " + arrayList.size());
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    com.kwad.sdk.core.d.a.a("ReportActionDBManager", "read action=" + ((ReportAction) it.next()));
                }
                ae.a(cursor);
                return arrayList;
            }
        } catch (Exception e3) {
            com.kwad.sdk.core.d.a.a(e3);
        }
        ae.a(cursor);
        return new ArrayList();
    }
}

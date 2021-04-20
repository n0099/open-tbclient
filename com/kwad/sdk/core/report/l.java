package com.kwad.sdk.core.report;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import androidx.annotation.NonNull;
import com.kwad.sdk.utils.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes6.dex */
public class l implements i<ReportAction> {

    /* renamed from: a  reason: collision with root package name */
    public static volatile l f34337a;

    /* renamed from: b  reason: collision with root package name */
    public SQLiteDatabase f34338b;

    public l(Context context) {
        this.f34338b = new k(context, k.f34335a).getWritableDatabase();
    }

    private synchronized ReportAction a(@NonNull Cursor cursor) {
        return new ReportAction(cursor.getString(cursor.getColumnIndex("aLog")));
    }

    public static l a(Context context) {
        if (f34337a == null) {
            synchronized (l.class) {
                if (f34337a == null) {
                    f34337a = new l(context);
                }
            }
        }
        return f34337a;
    }

    private synchronized void b(ReportAction reportAction) {
        com.kwad.sdk.core.d.a.a("ReportActionDBManager", "deleteAction action = " + reportAction);
        try {
            this.f34338b.delete("ksad_actions", "actionId=?", new String[]{reportAction.f34328a});
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.a(e2);
        }
    }

    @Override // com.kwad.sdk.core.report.i
    public synchronized long a() {
        long j;
        Cursor cursor = null;
        try {
            cursor = this.f34338b.rawQuery("select count(*) from ksad_actions", null);
            cursor.moveToFirst();
            j = cursor.getLong(0);
            w.a(cursor);
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.a(e2);
            w.a(cursor);
            j = 0;
        }
        return j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.report.i
    public synchronized void a(ReportAction reportAction) {
        com.kwad.sdk.core.d.a.a("ReportActionDBManager", "write = " + reportAction);
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("actionId", reportAction.f34328a);
            contentValues.put("aLog", reportAction.toJson().toString());
            try {
                this.f34338b.insert("ksad_actions", null, contentValues);
            } catch (Exception e2) {
                com.kwad.sdk.core.d.a.a(e2);
            }
        } catch (Exception e3) {
            com.kwad.sdk.core.d.a.a(e3);
        }
    }

    @Override // com.kwad.sdk.core.report.i
    public synchronized void a(List<ReportAction> list) {
        com.kwad.sdk.core.d.a.a("ReportActionDBManager", "delete size= " + list.size());
        try {
            this.f34338b.beginTransaction();
            for (ReportAction reportAction : list) {
                b(reportAction);
            }
            this.f34338b.setTransactionSuccessful();
            this.f34338b.endTransaction();
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.a(e2);
        }
    }

    @Override // com.kwad.sdk.core.report.i
    public synchronized List<ReportAction> b() {
        Cursor cursor = null;
        try {
            cursor = this.f34338b.rawQuery("select  * from ksad_actions", null);
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
                w.a(cursor);
                return arrayList;
            }
        } catch (Exception e3) {
            com.kwad.sdk.core.d.a.a(e3);
        }
        w.a(cursor);
        return new ArrayList();
    }
}

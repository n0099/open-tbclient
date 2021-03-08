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
/* loaded from: classes3.dex */
public class l implements i<ReportAction> {

    /* renamed from: a  reason: collision with root package name */
    private static volatile l f6252a;
    private SQLiteDatabase b;

    private l(Context context) {
        this.b = new k(context, k.f6251a).getWritableDatabase();
    }

    private synchronized ReportAction a(@NonNull Cursor cursor) {
        return new ReportAction(cursor.getString(cursor.getColumnIndex("aLog")));
    }

    public static l a(Context context) {
        if (f6252a == null) {
            synchronized (l.class) {
                if (f6252a == null) {
                    f6252a = new l(context);
                }
            }
        }
        return f6252a;
    }

    private synchronized void b(ReportAction reportAction) {
        com.kwad.sdk.core.d.a.a("ReportActionDBManager", "deleteAction action = " + reportAction);
        try {
            this.b.delete("ksad_actions", "actionId=?", new String[]{reportAction.f6245a});
        } catch (Exception e) {
            com.kwad.sdk.core.d.a.a(e);
        }
    }

    @Override // com.kwad.sdk.core.report.i
    public synchronized long a() {
        long j;
        Cursor cursor = null;
        synchronized (this) {
            j = 0;
            try {
                cursor = this.b.rawQuery("select count(*) from ksad_actions", null);
                cursor.moveToFirst();
                j = cursor.getLong(0);
                w.a(cursor);
            } catch (Exception e) {
                com.kwad.sdk.core.d.a.a(e);
                w.a(cursor);
            }
        }
        return j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.report.i
    public synchronized void a(ReportAction reportAction) {
        com.kwad.sdk.core.d.a.a("ReportActionDBManager", "write = " + reportAction);
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("actionId", reportAction.f6245a);
            contentValues.put("aLog", reportAction.toJson().toString());
            try {
                this.b.insert("ksad_actions", null, contentValues);
            } catch (Exception e) {
                com.kwad.sdk.core.d.a.a(e);
            }
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.a(e2);
        }
    }

    @Override // com.kwad.sdk.core.report.i
    public synchronized void a(List<ReportAction> list) {
        com.kwad.sdk.core.d.a.a("ReportActionDBManager", "delete size= " + list.size());
        try {
            this.b.beginTransaction();
            for (ReportAction reportAction : list) {
                b(reportAction);
            }
            this.b.setTransactionSuccessful();
            this.b.endTransaction();
        } catch (Exception e) {
            com.kwad.sdk.core.d.a.a(e);
        }
    }

    @Override // com.kwad.sdk.core.report.i
    public synchronized List<ReportAction> b() {
        Cursor cursor;
        ArrayList arrayList;
        Cursor cursor2 = null;
        synchronized (this) {
            try {
                cursor = this.b.rawQuery("select  * from ksad_actions", null);
            } catch (Exception e) {
                e = e;
            } catch (Throwable th) {
                th = th;
                cursor = null;
            }
            if (cursor != null) {
                try {
                    try {
                        ArrayList arrayList2 = new ArrayList();
                        while (cursor.moveToNext()) {
                            try {
                                arrayList2.add(a(cursor));
                            } catch (Exception e2) {
                                com.kwad.sdk.core.d.a.a(e2);
                            }
                        }
                        com.kwad.sdk.core.d.a.a("ReportActionDBManager", "read size= " + arrayList2.size());
                        Iterator<ReportAction> it = arrayList2.iterator();
                        while (it.hasNext()) {
                            com.kwad.sdk.core.d.a.a("ReportActionDBManager", "read action=" + it.next());
                        }
                        w.a(cursor);
                        arrayList = arrayList2;
                    } catch (Exception e3) {
                        e = e3;
                        cursor2 = cursor;
                        try {
                            com.kwad.sdk.core.d.a.a(e);
                            w.a(cursor2);
                            arrayList = new ArrayList();
                            return arrayList;
                        } catch (Throwable th2) {
                            th = th2;
                            cursor = cursor2;
                            w.a(cursor);
                            throw th;
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    w.a(cursor);
                    throw th;
                }
            } else {
                w.a(cursor);
                arrayList = new ArrayList();
            }
        }
        return arrayList;
    }
}

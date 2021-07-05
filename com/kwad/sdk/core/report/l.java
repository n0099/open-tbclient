package com.kwad.sdk.core.report;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.utils.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes7.dex */
public class l implements i<ReportAction> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile l f36544a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public SQLiteDatabase f36545b;

    public l(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f36545b = new k(context, k.f36542a).getWritableDatabase();
    }

    private synchronized ReportAction a(@NonNull Cursor cursor) {
        InterceptResult invokeL;
        ReportAction reportAction;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, cursor)) == null) {
            synchronized (this) {
                reportAction = new ReportAction(cursor.getString(cursor.getColumnIndex("aLog")));
            }
            return reportAction;
        }
        return (ReportAction) invokeL.objValue;
    }

    public static l a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (f36544a == null) {
                synchronized (l.class) {
                    if (f36544a == null) {
                        f36544a = new l(context);
                    }
                }
            }
            return f36544a;
        }
        return (l) invokeL.objValue;
    }

    private synchronized void b(ReportAction reportAction) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, reportAction) == null) {
            synchronized (this) {
                com.kwad.sdk.core.d.a.a("ReportActionDBManager", "deleteAction action = " + reportAction);
                try {
                    this.f36545b.delete("ksad_actions", "actionId=?", new String[]{reportAction.f36535a});
                } catch (Exception e2) {
                    com.kwad.sdk.core.d.a.a(e2);
                }
            }
        }
    }

    @Override // com.kwad.sdk.core.report.i
    public synchronized long a() {
        InterceptResult invokeV;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this) {
                Cursor cursor = null;
                try {
                    cursor = this.f36545b.rawQuery("select count(*) from ksad_actions", null);
                    cursor.moveToFirst();
                    j = cursor.getLong(0);
                    w.a(cursor);
                } catch (Exception e2) {
                    com.kwad.sdk.core.d.a.a(e2);
                    w.a(cursor);
                    j = 0;
                }
            }
            return j;
        }
        return invokeV.longValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.report.i
    public synchronized void a(ReportAction reportAction) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, reportAction) == null) {
            synchronized (this) {
                com.kwad.sdk.core.d.a.a("ReportActionDBManager", "write = " + reportAction);
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("actionId", reportAction.f36535a);
                    contentValues.put("aLog", reportAction.toJson().toString());
                    try {
                        this.f36545b.insert("ksad_actions", null, contentValues);
                    } catch (Exception e2) {
                        com.kwad.sdk.core.d.a.a(e2);
                    }
                } catch (Exception e3) {
                    com.kwad.sdk.core.d.a.a(e3);
                }
            }
        }
    }

    @Override // com.kwad.sdk.core.report.i
    public synchronized void a(List<ReportAction> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            synchronized (this) {
                com.kwad.sdk.core.d.a.a("ReportActionDBManager", "delete size= " + list.size());
                try {
                    this.f36545b.beginTransaction();
                    for (ReportAction reportAction : list) {
                        b(reportAction);
                    }
                    this.f36545b.setTransactionSuccessful();
                    this.f36545b.endTransaction();
                } catch (Exception e2) {
                    com.kwad.sdk.core.d.a.a(e2);
                }
            }
        }
    }

    @Override // com.kwad.sdk.core.report.i
    public synchronized List<ReportAction> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (this) {
                Cursor cursor = null;
                try {
                    cursor = this.f36545b.rawQuery("select  * from ksad_actions", null);
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
        return (List) invokeV.objValue;
    }
}

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
import com.kwad.sdk.utils.aa;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes10.dex */
public class k implements h<ReportAction> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile k f72525a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public SQLiteDatabase f72526b;

    public k(Context context) {
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
        this.f72526b = new j(context, j.f72523a).getWritableDatabase();
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

    public static k a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (f72525a == null) {
                synchronized (k.class) {
                    if (f72525a == null) {
                        f72525a = new k(context);
                    }
                }
            }
            return f72525a;
        }
        return (k) invokeL.objValue;
    }

    private synchronized void b(ReportAction reportAction) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, reportAction) == null) {
            synchronized (this) {
                com.kwad.sdk.core.d.a.a("ReportActionDBManager", "deleteAction action = " + reportAction);
                try {
                    this.f72526b.delete("ksad_actions", "actionId=?", new String[]{reportAction.f72515a});
                } catch (Exception e2) {
                    com.kwad.sdk.core.d.a.a(e2);
                }
            }
        }
    }

    @Override // com.kwad.sdk.core.report.h
    public synchronized long a() {
        InterceptResult invokeV;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this) {
                Cursor cursor = null;
                try {
                    cursor = this.f72526b.rawQuery("select count(*) from ksad_actions", null);
                    cursor.moveToFirst();
                    j2 = cursor.getLong(0);
                    aa.a(cursor);
                } catch (Exception e2) {
                    com.kwad.sdk.core.d.a.a(e2);
                    aa.a(cursor);
                    j2 = 0;
                }
            }
            return j2;
        }
        return invokeV.longValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.report.h
    public synchronized void a(ReportAction reportAction) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, reportAction) == null) {
            synchronized (this) {
                com.kwad.sdk.core.d.a.a("ReportActionDBManager", "write = " + reportAction);
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("actionId", reportAction.f72515a);
                    contentValues.put("aLog", reportAction.toJson().toString());
                    try {
                        this.f72526b.insert("ksad_actions", null, contentValues);
                    } catch (Exception e2) {
                        com.kwad.sdk.core.d.a.a(e2);
                    }
                } catch (Exception e3) {
                    com.kwad.sdk.core.d.a.a(e3);
                }
            }
        }
    }

    @Override // com.kwad.sdk.core.report.h
    public synchronized void a(List<ReportAction> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            synchronized (this) {
                com.kwad.sdk.core.d.a.a("ReportActionDBManager", "delete size= " + list.size());
                try {
                    this.f72526b.beginTransaction();
                    for (ReportAction reportAction : list) {
                        b(reportAction);
                    }
                    this.f72526b.setTransactionSuccessful();
                    this.f72526b.endTransaction();
                } catch (Exception e2) {
                    com.kwad.sdk.core.d.a.a(e2);
                }
            }
        }
    }

    @Override // com.kwad.sdk.core.report.h
    public synchronized List<ReportAction> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (this) {
                Cursor cursor = null;
                try {
                    cursor = this.f72526b.rawQuery("select  * from ksad_actions", null);
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
                        aa.a(cursor);
                        return arrayList;
                    }
                } catch (Exception e3) {
                    com.kwad.sdk.core.d.a.a(e3);
                }
                aa.a(cursor);
                return new ArrayList();
            }
        }
        return (List) invokeV.objValue;
    }
}

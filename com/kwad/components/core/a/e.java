package com.kwad.components.core.a;

import android.content.ContentValues;
import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.download.center.clearcache.DiskManagerSharedPrefsUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class e implements g {
    public static /* synthetic */ Interceptable $ic;
    public static e a;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public String b;
    public int c;
    public int d;
    public long e;
    public boolean f;

    public e() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = 0;
        this.d = 1;
        this.e = DiskManagerSharedPrefsUtils.DISK_CHECK_DURATION_DEFAULT;
        this.f = false;
    }

    public e(long j) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = 0;
        this.d = 1;
        this.e = DiskManagerSharedPrefsUtils.DISK_CHECK_DURATION_DEFAULT;
        this.f = false;
        this.b = String.valueOf(j);
    }

    @NonNull
    public static e a(long j) {
        InterceptResult invokeJ;
        e a2;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65538, null, j)) == null) ? (a.a() == null || (a2 = a.a().a(String.valueOf(j))) == null) ? g() : a2 : (e) invokeJ.objValue;
    }

    public static e a(AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, adTemplate)) == null) {
            if (adTemplate == null) {
                return null;
            }
            long j = adTemplate.posId;
            AdInfo i = com.kwad.sdk.core.response.a.d.i(adTemplate);
            e eVar = new e(j);
            AdInfo.AdBaseInfo adBaseInfo = i.adBaseInfo;
            eVar.c = adBaseInfo.adCacheStrategy;
            eVar.e = adBaseInfo.adCacheSecond;
            eVar.d = adBaseInfo.adCacheSize;
            eVar.f = adBaseInfo.adCacheSwitch == 1;
            return eVar;
        }
        return (e) invokeL.objValue;
    }

    public static synchronized List<e> a(Cursor cursor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, cursor)) == null) {
            synchronized (e.class) {
                if (cursor == null) {
                    return null;
                }
                ArrayList arrayList = new ArrayList();
                while (cursor.moveToNext()) {
                    try {
                        arrayList.add(b(cursor));
                    } catch (Exception e) {
                        com.kwad.sdk.core.d.b.a(e);
                    }
                }
                return arrayList;
            }
        }
        return (List) invokeL.objValue;
    }

    public static synchronized e b(Cursor cursor) {
        InterceptResult invokeL;
        e eVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, cursor)) == null) {
            synchronized (e.class) {
                String string = cursor.getString(cursor.getColumnIndex("posId"));
                int i = cursor.getInt(cursor.getColumnIndex("strategyCode"));
                int i2 = cursor.getInt(cursor.getColumnIndex("cacheSize"));
                long j = cursor.getLong(cursor.getColumnIndex("cacheSecond"));
                boolean z = true;
                if (cursor.getInt(cursor.getColumnIndex("enable")) != 1) {
                    z = false;
                }
                eVar = new e();
                eVar.b = string;
                eVar.c = i;
                eVar.d = i2;
                eVar.e = j;
                eVar.f = z;
            }
            return eVar;
        }
        return (e) invokeL.objValue;
    }

    @NonNull
    public static e g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            if (a == null) {
                synchronized (e.class) {
                    if (a == null) {
                        a = new e();
                    }
                }
            }
            return a;
        }
        return (e) invokeV.objValue;
    }

    public final int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.c : invokeV.intValue;
    }

    public final int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.d : invokeV.intValue;
    }

    public final long c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.e : invokeV.longValue;
    }

    public final boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f : invokeV.booleanValue;
    }

    public final boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? equals(g()) : invokeV.booleanValue;
    }

    @Override // com.kwad.components.core.a.g
    public final ContentValues f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("posId", this.b);
            contentValues.put("strategyCode", Integer.valueOf(this.c));
            contentValues.put("cacheSize", Integer.valueOf(this.d));
            contentValues.put("cacheSecond", Long.valueOf(this.e));
            contentValues.put("enable", Integer.valueOf(this.f ? 1 : 0));
            return contentValues;
        }
        return (ContentValues) invokeV.objValue;
    }
}

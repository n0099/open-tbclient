package com.kwad.components.core.a;

import android.content.ContentValues;
import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
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
/* loaded from: classes8.dex */
public class e implements h {
    public static /* synthetic */ Interceptable $ic;
    public static volatile e Dq;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public String Dr;
    public int Ds;
    public int Dt;
    public long Du;
    public boolean Dv;

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
        this.Ds = 0;
        this.Dt = 1;
        this.Du = DiskManagerSharedPrefsUtils.DISK_CHECK_DURATION_DEFAULT;
        this.Dv = false;
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
        this.Ds = 0;
        this.Dt = 1;
        this.Du = DiskManagerSharedPrefsUtils.DISK_CHECK_DURATION_DEFAULT;
        this.Dv = false;
        this.Dr = String.valueOf(j);
    }

    public static e H(AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, adTemplate)) == null) {
            if (adTemplate == null) {
                return null;
            }
            long j = adTemplate.posId;
            AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(adTemplate);
            e eVar = new e(j);
            AdInfo.AdBaseInfo adBaseInfo = bQ.adBaseInfo;
            eVar.Ds = adBaseInfo.adCacheStrategy;
            eVar.Du = adBaseInfo.adCacheSecond;
            eVar.Dt = adBaseInfo.adCacheSize;
            eVar.Dv = adBaseInfo.adCacheSwitch == 1;
            return eVar;
        }
        return (e) invokeL.objValue;
    }

    public static synchronized List<e> a(Cursor cursor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, cursor)) == null) {
            synchronized (e.class) {
                if (cursor == null) {
                    return null;
                }
                ArrayList arrayList = new ArrayList();
                while (cursor.moveToNext()) {
                    try {
                        arrayList.add(b(cursor));
                    } catch (Exception e) {
                        com.kwad.sdk.core.e.b.printStackTrace(e);
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
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, cursor)) == null) {
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
                eVar.Dr = string;
                eVar.Ds = i;
                eVar.Dt = i2;
                eVar.Du = j;
                eVar.Dv = z;
            }
            return eVar;
        }
        return (e) invokeL.objValue;
    }

    @NonNull
    @WorkerThread
    public static e k(long j) {
        InterceptResult invokeJ;
        e af;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65541, null, j)) == null) ? (a.lP() == null || (af = a.lP().af(String.valueOf(j))) == null) ? lW() : af : (e) invokeJ.objValue;
    }

    @NonNull
    public static e lW() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            if (Dq == null) {
                synchronized (e.class) {
                    if (Dq == null) {
                        Dq = new e();
                    }
                }
            }
            return Dq;
        }
        return (e) invokeV.objValue;
    }

    public final boolean isDefault() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? equals(lW()) : invokeV.booleanValue;
    }

    public final boolean isEnable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.Dv : invokeV.booleanValue;
    }

    public final int lX() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.Ds : invokeV.intValue;
    }

    public final int lY() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.Dt : invokeV.intValue;
    }

    public final long lZ() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.Du : invokeV.longValue;
    }

    @Override // com.kwad.components.core.a.h
    public final ContentValues ma() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("posId", this.Dr);
            contentValues.put("strategyCode", Integer.valueOf(this.Ds));
            contentValues.put("cacheSize", Integer.valueOf(this.Dt));
            contentValues.put("cacheSecond", Long.valueOf(this.Du));
            contentValues.put("enable", Integer.valueOf(this.Dv ? 1 : 0));
            return contentValues;
        }
        return (ContentValues) invokeV.objValue;
    }
}

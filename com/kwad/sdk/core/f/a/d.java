package com.kwad.sdk.core.f.a;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.utils.aa;
/* loaded from: classes10.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f71728a;

    public d(Context context) {
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
        this.f71728a = context;
    }

    private String a(Cursor cursor) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, cursor)) == null) {
            str = "";
            if (cursor != null && !cursor.isClosed()) {
                cursor.moveToFirst();
                int columnIndex = cursor.getColumnIndex("value");
                str = columnIndex > 0 ? cursor.getString(columnIndex) : "";
                int columnIndex2 = cursor.getColumnIndex("code");
                if (columnIndex2 > 0) {
                    cursor.getInt(columnIndex2);
                }
                int columnIndex3 = cursor.getColumnIndex("expired");
                if (columnIndex3 > 0) {
                    cursor.getLong(columnIndex3);
                }
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            String str = "";
            try {
                Cursor query = this.f71728a.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new String[]{"oaid"}, null);
                str = a(query);
                com.kwad.sdk.core.d.a.c("MeizuDeviceIDHelper", "getOAID oaid:" + str);
                aa.a(query);
            } catch (Exception e2) {
                com.kwad.sdk.core.d.a.c("MeizuDeviceIDHelper", "getOAID service not found;");
                com.kwad.sdk.core.d.a.a(e2);
            }
            return str;
        }
        return (String) invokeV.objValue;
    }
}

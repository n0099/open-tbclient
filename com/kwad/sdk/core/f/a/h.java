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
/* loaded from: classes6.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f34617a;

    public h(Context context) {
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
        this.f34617a = context;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            String str = "";
            Cursor cursor = null;
            try {
                try {
                    cursor = this.f34617a.getContentResolver().query(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), null, null, null, null);
                    if (cursor != null && cursor.moveToNext()) {
                        str = cursor.getString(cursor.getColumnIndex("value"));
                        com.kwad.sdk.core.d.a.c("VivoDeviceIDHelper", "getOAID oaid:" + str);
                    }
                } catch (Exception e2) {
                    com.kwad.sdk.core.d.a.c("VivoDeviceIDHelper", "getOAID fail");
                    com.kwad.sdk.core.d.a.b(e2);
                }
                return str;
            } finally {
                aa.a(cursor);
            }
        }
        return (String) invokeV.objValue;
    }
}

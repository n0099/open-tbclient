package com.yxcorp.kuaishou.addfp.android.b;

import android.content.Context;
import android.os.Build;
import android.os.Parcel;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public final class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public /* synthetic */ f b;

    public h(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = fVar;
        this.a = "iphonesubinfo";
    }

    private String a(String str, String str2) {
        InterceptResult invokeLL;
        String a;
        Parcel a2;
        Context context;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, this, str, str2)) == null) {
            String str3 = "";
            if (Build.VERSION.SDK_INT >= 29) {
                return "";
            }
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            a = this.b.a(str2);
            if (TextUtils.isEmpty(a)) {
                return "";
            }
            obtain.writeInterfaceToken(a);
            if (Build.VERSION.SDK_INT >= 23) {
                context = f.b;
                obtain.writeString(context.getPackageName());
            }
            a2 = this.b.a(str2, str, obtain, obtain2);
            if (a2 != null) {
                try {
                    obtain2.readException();
                    str3 = obtain2.readString();
                } catch (SecurityException unused) {
                    return "";
                }
            }
            obtain2.recycle();
            obtain.recycle();
            return str3;
        }
        return (String) invokeLL.objValue;
    }

    public final String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? a("TRANSACTION_getDeviceId", "iphonesubinfo") : (String) invokeV.objValue;
    }

    public final String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? a("TRANSACTION_getIccSerialNumber", "iphonesubinfo") : (String) invokeV.objValue;
    }
}

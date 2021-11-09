package com.xiaomi.push;

import android.content.Context;
import com.baidu.android.imsdk.db.DBTableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.push.ai;
/* loaded from: classes2.dex */
public class bx extends ai.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ bu f70733a;

    public bx(bu buVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {buVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f70733a = buVar;
    }

    @Override // com.xiaomi.push.ai.a
    /* renamed from: a */
    public String mo187a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "10053" : (String) invokeV.objValue;
    }

    @Override // java.lang.Runnable
    public void run() {
        ck ckVar;
        ck ckVar2;
        Context context;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ckVar = this.f70733a.f168a;
            if (ckVar != null) {
                ckVar2 = this.f70733a.f168a;
                context = this.f70733a.f165a;
                ckVar2.b(context);
                this.f70733a.b(DBTableDefine.GroupInfoColumns.COLUMN_DELETE_TIEM);
            }
        }
    }
}

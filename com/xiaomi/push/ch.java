package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.push.ai;
import com.xiaomi.push.cg;
import java.util.ArrayList;
/* loaded from: classes10.dex */
public class ch extends ai.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ cg f77790a;

    public ch(cg cgVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cgVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f77790a = cgVar;
    }

    @Override // com.xiaomi.push.ai.a
    /* renamed from: a */
    public String mo187a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "100957" : (String) invokeV.objValue;
    }

    @Override // java.lang.Runnable
    public void run() {
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        ArrayList arrayList4;
        ArrayList arrayList5;
        ArrayList<cg.a> arrayList6;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            arrayList = this.f77790a.f179a;
            synchronized (arrayList) {
                arrayList2 = this.f77790a.f179a;
                if (arrayList2.size() > 0) {
                    arrayList3 = this.f77790a.f179a;
                    if (arrayList3.size() > 1) {
                        cg cgVar = this.f77790a;
                        arrayList6 = this.f77790a.f179a;
                        cgVar.a(arrayList6);
                    } else {
                        cg cgVar2 = this.f77790a;
                        arrayList4 = this.f77790a.f179a;
                        cgVar2.b((cg.a) arrayList4.get(0));
                    }
                    arrayList5 = this.f77790a.f179a;
                    arrayList5.clear();
                    System.gc();
                }
            }
        }
    }
}

package com.kwad.sdk.pngencrypt.chunk;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
/* loaded from: classes10.dex */
public class ah {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final e f73132a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f73133b;

    public ah(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f73132a = eVar;
        this.f73133b = !(eVar instanceof f);
    }

    public List<? extends ae> a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.f73132a.a("tEXt", str));
            arrayList.addAll(this.f73132a.a("zTXt", str));
            arrayList.addAll(this.f73132a.a("iTXt", str));
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            List<? extends ae> a2 = a(str);
            if (a2.isEmpty()) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            for (ae aeVar : a2) {
                sb.append(aeVar.d());
                sb.append(StringUtils.LF);
            }
            return sb.toString().trim();
        }
        return (String) invokeL.objValue;
    }
}

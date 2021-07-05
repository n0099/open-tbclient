package com.kwad.sdk.lib.b;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public abstract class a<PAGE, MODEL> implements c<PAGE, MODEL> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final List<MODEL> f38512a;

    /* renamed from: b  reason: collision with root package name */
    public final e f38513b;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f38512a = new ArrayList();
        this.f38513b = new e();
    }

    @Override // com.kwad.sdk.lib.b.d
    public void a(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
            this.f38513b.a(fVar);
        }
    }

    @Override // com.kwad.sdk.lib.b.c
    public boolean a(MODEL model) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, model)) == null) {
            boolean remove = this.f38512a.remove(model);
            if (remove) {
                this.f38513b.a(false);
            }
            return remove;
        }
        return invokeL.booleanValue;
    }

    @Override // com.kwad.sdk.lib.b.d
    public void b(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, fVar) == null) {
            this.f38513b.b(fVar);
        }
    }

    @Override // com.kwad.sdk.lib.b.c
    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f38512a.isEmpty() : invokeV.booleanValue;
    }

    @Override // com.kwad.sdk.lib.b.c
    public List<MODEL> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f38512a : (List) invokeV.objValue;
    }

    @Override // com.kwad.sdk.lib.b.c
    public List<MODEL> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            ArrayList arrayList = new ArrayList(this.f38512a.size());
            arrayList.addAll(this.f38512a);
            return arrayList;
        }
        return (List) invokeV.objValue;
    }
}

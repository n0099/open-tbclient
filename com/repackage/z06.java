package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.collections.CollectionsKt__MutableCollectionsJVMKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public abstract class z06 extends x06 implements p0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final r0 e;
    public final Comparator<o0> f;
    public final List<o0> g;
    public boolean h;

    public /* synthetic */ z06(u06 u06Var, r0 r0Var, Comparator comparator, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(u06Var, r0Var, (i & 4) != 0 ? new y06() : comparator);
    }

    public void a(o0 entity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, entity) == null) {
            Intrinsics.checkNotNullParameter(entity, "entity");
            this.g.remove(entity);
            this.h = true;
        }
    }

    @Override // com.repackage.p0
    public void b(o0 entity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, entity) == null) {
            Intrinsics.checkNotNullParameter(entity, "entity");
            this.g.add(entity);
            this.h = true;
        }
    }

    @Override // com.repackage.q0
    public void c(n0 engine) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, engine) == null) {
            Intrinsics.checkNotNullParameter(engine, "engine");
            this.g.clear();
            y0<o0> newEntities = engine.j(this.e);
            if (newEntities.size() > 0) {
                List<o0> list = this.g;
                Intrinsics.checkNotNullExpressionValue(newEntities, "newEntities");
                CollectionsKt__MutableCollectionsKt.addAll(list, newEntities);
            }
            CollectionsKt__MutableCollectionsJVMKt.sortWith(this.g, this.f);
            this.h = false;
            engine.f(this.e, this);
        }
    }

    @Override // com.repackage.x06, com.repackage.q0
    public void g(n0 engine) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, engine) == null) {
            Intrinsics.checkNotNullParameter(engine, "engine");
            super.g(engine);
            engine.o(this);
            this.g.clear();
            this.h = false;
        }
    }

    @Override // com.repackage.x06
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    public final List<o0> k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            m();
            return this.g;
        }
        return (List) invokeV.objValue;
    }

    public abstract void l(o0 o0Var, float f);

    public final void m() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && this.h) {
            CollectionsKt__MutableCollectionsJVMKt.sortWith(this.g, this.f);
            this.h = false;
        }
    }

    @Override // com.repackage.q0
    public void update(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(InputDeviceCompat.SOURCE_TOUCHPAD, this, f) == null) {
            m();
            for (o0 o0Var : this.g) {
                l(o0Var, f);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z06(u06 context, r0 family, Comparator<o0> comparator) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, family, comparator};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((u06) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(family, "family");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        this.e = family;
        this.f = comparator;
        this.g = new ArrayList();
    }
}

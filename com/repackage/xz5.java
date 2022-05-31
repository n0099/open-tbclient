package com.repackage;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.danmu.cache.CacheManager;
import com.baidu.tieba.danmu.data.ItemState;
import com.baidu.tieba.danmu.data.state.DrawState;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class xz5 extends bz5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int i;
    public int j;
    public a k;
    public final CacheManager l;
    public f06 m;

    /* loaded from: classes7.dex */
    public final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public a(xz5 this$0) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {this$0};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this.a = -1;
            CollectionsKt__CollectionsKt.emptyList();
        }

        public final int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : invokeV.intValue;
        }

        public final void b(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                this.a = i;
            }
        }

        public final void c(List<? extends Object> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
                Intrinsics.checkNotNullParameter(list, "<set-?>");
            }
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public xz5(wy5 context) {
        super(context, r3, null, 4, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((wy5) objArr2[0], (o0) objArr2[1], (Comparator) objArr2[2], ((Integer) objArr2[3]).intValue(), (DefaultConstructorMarker) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Class<? extends yy5>[] b = w06.a.b();
        o0 b2 = o0.d((Class[]) Arrays.copyOf(b, b.length)).b();
        Intrinsics.checkNotNullExpressionValue(b2, "all(*Families.layoutComponentTypes).get()");
        this.i = -1;
        this.j = -1;
        this.k = new a(this);
        this.l = context.b();
        this.m = new g06();
    }

    @Override // com.repackage.bz5, com.repackage.m0
    public void a(l0 entity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, entity) == null) {
            Intrinsics.checkNotNullParameter(entity, "entity");
            super.a(entity);
            f06 f06Var = this.m;
            dz5 b = b06.b(entity);
            ry5 a2 = b == null ? null : b.a();
            if (a2 == null) {
                return;
            }
            f06Var.b(a2);
        }
    }

    @Override // com.repackage.bz5
    public void l(l0 entity, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, entity, f) == null) {
            Intrinsics.checkNotNullParameter(entity, "entity");
        }
    }

    public final r06 n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? a06.c(this) : (r06) invokeV.objValue;
    }

    public final f06 o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.m : (f06) invokeV.objValue;
    }

    public final void p(f06 f06Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, f06Var) == null) {
            Intrinsics.checkNotNullParameter(f06Var, "<set-?>");
            this.m = f06Var;
        }
    }

    @Override // com.repackage.bz5, com.repackage.n0
    public void update(float f) {
        ez5 ez5Var;
        DrawState drawState;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048581, this, f) == null) {
            c06.b("LayoutSystem_update");
            ly5 c = i().c();
            boolean z = false;
            boolean z2 = (this.i == c.r() && this.j == c.o()) ? false : true;
            if (a06.e(this) && !z2) {
                c06.a();
                return;
            }
            if (this.i != c.r()) {
                BdLog.v("DanmakuEngine [Layout] RetainerGeneration change, clear retainer.");
                this.m.c(0, (int) (n().getHeight() * c.u()));
                this.m.clear();
                this.i = c.r();
            }
            if (this.k.a() != c.l()) {
                this.k.b(c.l());
                this.k.c(CollectionsKt___CollectionsKt.toList(c.n()));
            }
            long b = a06.b(this);
            List<l0> k = k();
            ArrayList arrayList = new ArrayList();
            for (Object obj : k) {
                cz5 d = b06.d((l0) obj);
                if ((d == null || d.d()) ? false : true) {
                    arrayList.add(obj);
                }
            }
            Iterator it = arrayList.iterator();
            boolean z3 = false;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                dz5 b2 = b06.b((l0) it.next());
                ry5 a2 = b2 != null ? b2.a() : null;
                if (a2 != null && a2.i() != ItemState.Measuring) {
                    boolean z4 = !a2.f().r(c.p());
                    if (a2.i().compareTo(ItemState.Measuring) < 0 || z4) {
                        if (z4 && a2.i().compareTo(ItemState.Measuring) >= 0) {
                            BdLog.v(Intrinsics.stringPlus("DanmakuEngine [Layout] re-measure ", a2.e()));
                        }
                        a2.o(ItemState.Measuring);
                        this.l.o(a2, n(), c);
                        z3 = true;
                    }
                }
            }
            ArrayList<l0> arrayList2 = new ArrayList();
            for (Object obj2 : arrayList) {
                dz5 b3 = b06.b((l0) obj2);
                ry5 a3 = b3 == null ? null : b3.a();
                if (a3 != null && a3.i().compareTo(ItemState.Measured) >= 0) {
                    arrayList2.add(obj2);
                }
            }
            boolean z5 = z3;
            for (l0 l0Var : arrayList2) {
                dz5 b4 = b06.b(l0Var);
                ry5 a4 = b4 == null ? null : b4.a();
                if (a4 != null) {
                    DrawState f2 = a4.f();
                    ez5 e = b06.e(l0Var);
                    if (e != null || (e = (ez5) a06.a(this, ez5.class, l0Var, a4)) != null) {
                        ez5 ez5Var2 = e;
                        if (f2.e() != c.o()) {
                            f2.H(z);
                            ez5Var = ez5Var2;
                            drawState = f2;
                            ez5Var.e(o().d(a4, b, n(), c));
                        } else {
                            ez5Var = ez5Var2;
                            drawState = f2;
                        }
                        if (ez5Var.d()) {
                            synchronized (a4.i()) {
                                if (a4.i().compareTo(ItemState.Rendering) < 0) {
                                    a4.o(ItemState.Rendering);
                                    this.l.m(a4, n(), c);
                                    z5 = true;
                                }
                                Unit unit = Unit.INSTANCE;
                            }
                            o().a(a4, b, n(), c);
                            drawState.y(c.o());
                        }
                        ez5Var.c().set(drawState.g(), drawState.h());
                        z = false;
                    }
                }
            }
            if (a06.e(this)) {
                if (z5) {
                    this.l.n();
                } else {
                    c.H();
                    this.j = c.o();
                }
            }
            c06.a();
        }
    }
}

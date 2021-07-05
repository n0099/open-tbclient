package com.kwad.sdk.lib.widget.recycler;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.lib.b.f;
import com.kwad.sdk.lib.widget.recycler.a.b;
import com.kwad.sdk.lib.widget.recycler.b.a;
import com.kwad.sdk.lib.widget.recycler.b.a.C0475a;
import com.kwad.sdk.mvp.Presenter;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes7.dex */
public abstract class c<Model, CallerContext extends a.C0475a<Model>> extends a<Model, com.kwad.sdk.lib.widget.recycler.b.a<Model, CallerContext>> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final ExecutorService f38575c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public KsFragment f38576d;

    /* renamed from: e  reason: collision with root package name */
    public RecyclerView f38577e;

    /* renamed from: f  reason: collision with root package name */
    public final Set<Presenter> f38578f;

    /* renamed from: g  reason: collision with root package name */
    public com.kwad.sdk.lib.b.c<?, Model> f38579g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.lib.widget.recycler.a.d<Model> f38580h;

    /* renamed from: i  reason: collision with root package name */
    public final com.kwad.sdk.lib.widget.recycler.a.e<Model> f38581i;
    public f j;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(354376994, "Lcom/kwad/sdk/lib/widget/recycler/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(354376994, "Lcom/kwad/sdk/lib/widget/recycler/c;");
                return;
            }
        }
        f38575c = new ThreadPoolExecutor(1, 1, 1L, TimeUnit.MINUTES, new LinkedBlockingQueue());
    }

    public c(KsFragment ksFragment, RecyclerView recyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ksFragment, recyclerView};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.j = new f(this) { // from class: com.kwad.sdk.lib.widget.recycler.c.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c f38582a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f38582a = this;
            }

            @Override // com.kwad.sdk.lib.b.f
            public void a(boolean z) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeZ(1048576, this, z) == null) {
                    if (this.f38582a.f38580h != null) {
                        this.f38582a.a(z);
                    } else {
                        this.f38582a.notifyDataSetChanged();
                    }
                }
            }

            @Override // com.kwad.sdk.lib.b.f
            public void a(boolean z, int i4, String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i4), str}) == null) {
                }
            }

            @Override // com.kwad.sdk.lib.b.f
            public void a(boolean z, boolean z2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                }
            }

            @Override // com.kwad.sdk.lib.b.f
            public void b(boolean z, boolean z2) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || this.f38582a.f38579g.e()) {
                    return;
                }
                if (this.f38582a.f38580h != null) {
                    c cVar = this.f38582a;
                    cVar.a(cVar.a(z, z2));
                    return;
                }
                c cVar2 = this.f38582a;
                cVar2.a(cVar2.f38579g.g());
                this.f38582a.notifyDataSetChanged();
            }
        };
        this.f38578f = new LinkedHashSet();
        this.f38576d = ksFragment;
        this.f38577e = recyclerView;
        this.f38581i = null;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(KsFragment ksFragment, RecyclerView recyclerView, @NonNull com.kwad.sdk.lib.widget.recycler.a.e<Model> eVar) {
        super(false);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ksFragment, recyclerView, eVar};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super(((Boolean) newInitContext.callArgs[0]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.j = new f(this) { // from class: com.kwad.sdk.lib.widget.recycler.c.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c f38582a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f38582a = this;
            }

            @Override // com.kwad.sdk.lib.b.f
            public void a(boolean z) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeZ(1048576, this, z) == null) {
                    if (this.f38582a.f38580h != null) {
                        this.f38582a.a(z);
                    } else {
                        this.f38582a.notifyDataSetChanged();
                    }
                }
            }

            @Override // com.kwad.sdk.lib.b.f
            public void a(boolean z, int i4, String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i4), str}) == null) {
                }
            }

            @Override // com.kwad.sdk.lib.b.f
            public void a(boolean z, boolean z2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                }
            }

            @Override // com.kwad.sdk.lib.b.f
            public void b(boolean z, boolean z2) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || this.f38582a.f38579g.e()) {
                    return;
                }
                if (this.f38582a.f38580h != null) {
                    c cVar = this.f38582a;
                    cVar.a(cVar.a(z, z2));
                    return;
                }
                c cVar2 = this.f38582a;
                cVar2.a(cVar2.f38579g.g());
                this.f38582a.notifyDataSetChanged();
            }
        };
        this.f38578f = new LinkedHashSet();
        this.f38576d = ksFragment;
        this.f38577e = recyclerView;
        this.f38581i = eVar;
        this.f38536a = new com.kwad.sdk.lib.widget.b(a());
    }

    private List<Model> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65540, this)) == null) {
            com.kwad.sdk.lib.widget.recycler.a.d<Model> dVar = new com.kwad.sdk.lib.widget.recycler.a.d<>(new com.kwad.sdk.lib.widget.recycler.a.a(this), new b.a(this.f38581i).a(f38575c).a(), this);
            this.f38580h = dVar;
            return new com.kwad.sdk.lib.widget.recycler.a.c(dVar);
        }
        return (List) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(AdIconUtil.BAIDU_LOGO_ID, this, z) == null) {
            if (z) {
                this.f38580h.b(this.f38579g.g());
            } else {
                this.f38580h.a(this.f38579g.g());
            }
        }
    }

    public abstract View a(ViewGroup viewGroup, int i2);

    public abstract Presenter a(int i2);

    public void a(com.kwad.sdk.lib.b.c<?, Model> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
            com.kwad.sdk.lib.b.c<?, Model> cVar2 = this.f38579g;
            if (cVar2 != null) {
                cVar2.b(this.j);
            }
            this.f38579g = cVar;
            cVar.a(this.j);
        }
    }

    /* JADX DEBUG: Type inference failed for r1v2. Raw type applied. Possible types: com.kwad.sdk.lib.b.c<?, Model>, com.kwad.sdk.lib.b.c<?, MODEL> */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.lang.Object, MODEL] */
    public void a(CallerContext callercontext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, callercontext, i2) == null) {
            ?? r0 = this.f38536a.get(i2);
            callercontext.f38568d = this.f38576d;
            callercontext.f38569e = this.f38577e;
            callercontext.f38570f = (com.kwad.sdk.lib.b.c<?, Model>) this.f38579g;
            callercontext.f38572h = i2;
            callercontext.f38573i = r0;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onViewRecycled(com.kwad.sdk.lib.widget.recycler.b.a<Model, CallerContext> aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            super.onViewRecycled(aVar);
            if (aVar != null) {
                View view = aVar.itemView;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(com.kwad.sdk.lib.widget.recycler.b.a<Model, CallerContext> aVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, aVar, i2) == null) {
            com.kwad.sdk.core.d.a.a("RecyclerAdapter", "onBindViewHolder position" + i2);
            a((c<Model, CallerContext>) aVar.f38567b, i2);
            aVar.f38566a.a(aVar.f38567b);
        }
    }

    public boolean a(boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) ? z : invokeCommon.booleanValue;
    }

    public abstract CallerContext b();

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: b */
    public com.kwad.sdk.lib.widget.recycler.b.a<Model, CallerContext> onCreateViewHolder(ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, viewGroup, i2)) == null) {
            com.kwad.sdk.lib.widget.recycler.b.a<Model, CallerContext> aVar = new com.kwad.sdk.lib.widget.recycler.b.a<>(a(viewGroup, i2), a(i2), b());
            this.f38578f.add(aVar.f38566a);
            return aVar;
        }
        return (com.kwad.sdk.lib.widget.recycler.b.a) invokeLI.objValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            com.kwad.sdk.lib.widget.recycler.a.d<Model> dVar = this.f38580h;
            return dVar != null && dVar.f38552a;
        }
        return invokeV.booleanValue;
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            for (Presenter presenter : this.f38578f) {
                if (presenter != null) {
                    presenter.j();
                }
            }
            this.f38578f.clear();
            com.kwad.sdk.lib.b.c<?, Model> cVar = this.f38579g;
            if (cVar != null) {
                cVar.b(this.j);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, recyclerView) == null) {
            super.onDetachedFromRecyclerView(recyclerView);
            k();
        }
    }
}

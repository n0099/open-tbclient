package com.kwad.sdk.lib.a.b;

import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.lib.a.a.b;
import com.kwad.sdk.lib.b.f;
import com.kwad.sdk.lib.b.g;
/* loaded from: classes7.dex */
public class b<PAGE, MODEL, CallerContext extends com.kwad.sdk.lib.a.a.b<PAGE, MODEL>> extends com.kwad.sdk.lib.a.a.a<MODEL, CallerContext> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public RecyclerView f38477a;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.lib.widget.recycler.c<MODEL, ?> f38478c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.lib.widget.recycler.d f38479d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.lib.b.c<PAGE, MODEL> f38480e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.lib.a.b<PAGE> f38481f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f38482g;

    /* renamed from: h  reason: collision with root package name */
    public f f38483h;

    public b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f38483h = new g(this) { // from class: com.kwad.sdk.lib.a.b.b.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f38484a;

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
                this.f38484a = this;
            }

            @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
            public void a(boolean z2, int i4, String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z2), Integer.valueOf(i4), str}) == null) {
                }
            }

            @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
            public void a(boolean z2, boolean z3) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
                }
            }

            @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
            public void b(boolean z2, boolean z3) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) && this.f38484a.f38482g && this.f38484a.f38477a.getLayoutManager() == null) {
                    this.f38484a.e();
                }
            }
        };
        this.f38482g = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65540, this) == null) {
            this.f38477a.setItemAnimator(null);
            RecyclerView.ItemDecoration b2 = this.f38481f.b(this.f38480e.p());
            if (b2 != null) {
                this.f38477a.addItemDecoration(b2);
            }
            this.f38477a.setLayoutManager(this.f38481f.a(this.f38480e.p()));
            this.f38479d.a(this.f38477a);
        }
    }

    @Override // com.kwad.sdk.lib.a.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            CallerContext callercontext = ((com.kwad.sdk.lib.a.a.a) this).f38465b;
            this.f38477a = callercontext.f38468f;
            com.kwad.sdk.lib.b.c<PAGE, MODEL> cVar = callercontext.f38469g;
            this.f38480e = cVar;
            com.kwad.sdk.lib.widget.recycler.c<MODEL, ?> cVar2 = callercontext.f38470h;
            this.f38478c = cVar2;
            this.f38479d = callercontext.f38471i;
            cVar2.a(cVar.g());
            this.f38478c.a((com.kwad.sdk.lib.b.c<?, MODEL>) ((com.kwad.sdk.lib.a.a.a) this).f38465b.f38469g);
            this.f38477a.setAdapter(this.f38479d);
            this.f38481f = ((com.kwad.sdk.lib.a.a.a) this).f38465b.k;
            if (this.f38482g) {
                this.f38480e.a(this.f38483h);
            } else {
                e();
            }
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.b_();
            if (this.f38482g) {
                this.f38480e.a(this.f38483h);
            }
        }
    }
}

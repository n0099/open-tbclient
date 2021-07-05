package com.kwad.sdk.lib.a.b;

import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.lib.a.a.b;
/* loaded from: classes7.dex */
public class a<MODEL, CallerContext extends com.kwad.sdk.lib.a.a.b<?, MODEL>> extends com.kwad.sdk.lib.a.a.a<MODEL, CallerContext> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public RecyclerView f38472a;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.lib.b.c<?, MODEL> f38473c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.lib.widget.recycler.c<MODEL, ?> f38474d;

    /* renamed from: e  reason: collision with root package name */
    public RecyclerView.OnScrollListener f38475e;

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
        this.f38475e = new RecyclerView.OnScrollListener(this) { // from class: com.kwad.sdk.lib.a.b.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f38476a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f38476a = this;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLI(1048576, this, recyclerView, i4) == null) {
                    super.onScrollStateChanged(recyclerView, i4);
                    if (i4 == 1) {
                        this.f38476a.e();
                    }
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i4, int i5) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i4, i5) == null) {
                    super.onScrolled(recyclerView, i4, i5);
                    if (i4 > 0 || i5 > 0) {
                        this.f38476a.e();
                    }
                }
            }
        };
    }

    @Override // com.kwad.sdk.lib.a.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            CallerContext callercontext = ((com.kwad.sdk.lib.a.a.a) this).f38465b;
            RecyclerView recyclerView = callercontext.f38468f;
            this.f38472a = recyclerView;
            this.f38473c = (com.kwad.sdk.lib.b.c<?, MODEL>) callercontext.f38469g;
            this.f38474d = callercontext.f38470h;
            recyclerView.addOnScrollListener(this.f38475e);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.b_();
            this.f38472a.removeOnScrollListener(this.f38475e);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            RecyclerView.LayoutManager layoutManager = this.f38472a.getLayoutManager();
            if (layoutManager.getChildCount() <= 0 || !f()) {
                return;
            }
            if (((RecyclerView.LayoutParams) layoutManager.getChildAt(layoutManager.getChildCount() - 1).getLayoutParams()).getViewAdapterPosition() < this.f38474d.getItemCount() - ((com.kwad.sdk.lib.a.a.a) this).f38465b.l || this.f38474d.j()) {
                return;
            }
            this.f38473c.m();
        }
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            com.kwad.sdk.lib.b.c<?, MODEL> cVar = this.f38473c;
            return (cVar == null || cVar.f() == null || this.f38473c.f().isEmpty()) ? false : true;
        }
        return invokeV.booleanValue;
    }
}

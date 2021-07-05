package com.kwad.sdk.feed.a.c;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.lib.widget.recycler.d;
import com.kwad.sdk.lib.widget.recycler.e;
/* loaded from: classes7.dex */
public class a extends com.kwad.sdk.feed.a.b.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public RecyclerView f37384c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.lib.widget.recycler.c<AdTemplate, ?> f37385d;

    /* renamed from: e  reason: collision with root package name */
    public RecyclerView.OnScrollListener f37386e;

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
        this.f37386e = new RecyclerView.OnScrollListener(this) { // from class: com.kwad.sdk.feed.a.c.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f37387a;

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
                this.f37387a = this;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i4, int i5) {
                RecyclerView.Adapter adapter;
                int i6;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLII(1048576, this, recyclerView, i4, i5) == null) {
                    super.onScrolled(recyclerView, i4, i5);
                    if (this.f37387a.f37384c == null || this.f37387a.f37385d == null || (adapter = this.f37387a.f37384c.getAdapter()) == null || adapter.getItemCount() == 0) {
                        return;
                    }
                    int a2 = e.a(this.f37387a.f37384c);
                    int b2 = e.b(this.f37387a.f37384c);
                    if (-1 == a2 || -1 == b2) {
                        return;
                    }
                    com.kwad.sdk.core.d.a.a("FeedHomeItemVisiblePresenter", "firstVisible=" + a2 + "--lastVisible=" + b2);
                    RecyclerView.LayoutManager layoutManager = this.f37387a.f37384c.getLayoutManager();
                    while (a2 <= b2) {
                        if (adapter instanceof d) {
                            d dVar = (d) adapter;
                            if (this.f37387a.a(a2, dVar)) {
                                a2++;
                            } else {
                                i6 = a2 - dVar.a();
                            }
                        } else {
                            i6 = a2;
                        }
                        AdTemplate adTemplate = (AdTemplate) this.f37387a.f37385d.c(i6);
                        if (adTemplate != null) {
                            View findViewByPosition = layoutManager.findViewByPosition(a2);
                            Rect rect = new Rect();
                            if (findViewByPosition.getGlobalVisibleRect(rect)) {
                                this.f37387a.a(adTemplate, rect.height() / (findViewByPosition.getHeight() * 1.0f));
                            }
                        }
                        a2++;
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AdTemplate adTemplate, float f2) {
        e.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLF(65538, this, adTemplate, f2) == null) || (aVar = ((com.kwad.sdk.feed.a.b.a) this).f37377a.f37380c.get(adTemplate.mUniqueId)) == null) {
            return;
        }
        aVar.a(adTemplate, f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(int i2, d dVar) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(65540, this, i2, dVar)) == null) ? i2 < dVar.a() || i2 >= dVar.a() + dVar.getItemCount() : invokeIL.booleanValue;
    }

    /* JADX DEBUG: Type inference failed for r1v0. Raw type applied. Possible types: com.kwad.sdk.lib.widget.recycler.c<MODEL, ?>, com.kwad.sdk.lib.widget.recycler.c<com.kwad.sdk.core.response.model.AdTemplate, ?> */
    @Override // com.kwad.sdk.feed.a.b.a, com.kwad.sdk.lib.a.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            com.kwad.sdk.feed.a.b.b bVar = ((com.kwad.sdk.feed.a.b.a) this).f37377a;
            this.f37385d = bVar.f38470h;
            RecyclerView recyclerView = bVar.f38468f;
            this.f37384c = recyclerView;
            recyclerView.addOnScrollListener(this.f37386e);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.b_();
            this.f37384c.clearOnScrollListeners();
        }
    }
}

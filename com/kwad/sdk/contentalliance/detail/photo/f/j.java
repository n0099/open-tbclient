package com.kwad.sdk.contentalliance.detail.photo.f;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.detail.photo.related.RelatedVideoPanel;
import com.kwad.sdk.contentalliance.home.viewpager.SlidePlayViewPager;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.p;
/* loaded from: classes7.dex */
public class j extends a<View> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public ViewStub f34814d;

    /* renamed from: e  reason: collision with root package name */
    public RelatedVideoPanel f34815e;

    /* renamed from: f  reason: collision with root package name */
    public final int f34816f;

    /* renamed from: g  reason: collision with root package name */
    public SlidePlayViewPager f34817g;

    /* renamed from: h  reason: collision with root package name */
    public AdTemplate f34818h;

    public j(boolean z) {
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
        this.f34816f = z ? R.layout.ksad_content_photo_related_top_button : R.layout.ksad_content_photo_related_bottom_button;
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65540, this) == null) || this.f34814d == null) {
            return;
        }
        RelatedVideoPanel relatedVideoPanel = this.f34815e;
        if (relatedVideoPanel == null || relatedVideoPanel.getVisibility() != 0) {
            if (this.f34814d.getParent() != null) {
                this.f34815e = (RelatedVideoPanel) this.f34814d.inflate();
            }
            RelatedVideoPanel relatedVideoPanel2 = (RelatedVideoPanel) b(R.id.ksad_related_panel);
            this.f34815e = relatedVideoPanel2;
            relatedVideoPanel2.setRelatedPanelListener(new RelatedVideoPanel.a(this) { // from class: com.kwad.sdk.contentalliance.detail.photo.f.j.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ j f34819a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f34819a = this;
                }

                @Override // com.kwad.sdk.contentalliance.detail.photo.related.RelatedVideoPanel.a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f34819a.f34817g.setEnabled(false);
                        ((com.kwad.sdk.contentalliance.detail.b) this.f34819a).f34553a.n = true;
                    }
                }

                @Override // com.kwad.sdk.contentalliance.detail.photo.related.RelatedVideoPanel.a
                public void b() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        this.f34819a.f34817g.setEnabled(true);
                        ((com.kwad.sdk.contentalliance.detail.b) this.f34819a).f34553a.n = false;
                    }
                }
            });
            ((com.kwad.sdk.contentalliance.detail.b) this).f34553a.f34576c.add(this.f34815e);
            RelatedVideoPanel relatedVideoPanel3 = this.f34815e;
            com.kwad.sdk.contentalliance.detail.c cVar = ((com.kwad.sdk.contentalliance.detail.b) this).f34553a;
            relatedVideoPanel3.a(cVar.k, cVar.j);
            this.f34817g.setEnabled(false);
        }
    }

    @Override // com.kwad.sdk.contentalliance.detail.photo.f.a, com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            com.kwad.sdk.contentalliance.detail.c cVar = ((com.kwad.sdk.contentalliance.detail.b) this).f34553a;
            this.f34817g = cVar.l;
            this.f34818h = cVar.j;
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.b_();
            RelatedVideoPanel relatedVideoPanel = this.f34815e;
            if (relatedVideoPanel != null) {
                ((com.kwad.sdk.contentalliance.detail.b) this).f34553a.f34576c.remove(relatedVideoPanel);
                this.f34815e.setVisibility(8);
                this.f34815e.b();
            }
            this.f34817g.setEnabled(true);
        }
    }

    @Override // com.kwad.sdk.contentalliance.detail.photo.f.a, com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.c();
            this.f34814d = (ViewStub) b(R.id.ksad_related_panel_view_stub);
            ((a) this).f34792b.setOnClickListener(this);
        }
    }

    @Override // com.kwad.sdk.contentalliance.detail.photo.f.d
    public View g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? ao.a((ViewGroup) ((a) this).f34793c, this.f34816f, false) : (View) invokeV.objValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view) == null) {
            if (com.kwad.sdk.core.response.b.c.c(((com.kwad.sdk.contentalliance.detail.b) this).f34553a.j)) {
                p.a(view.getContext(), view.getContext().getString(R.string.ksad_ad_function_disable));
            } else {
                e();
            }
            com.kwad.sdk.core.report.e.p(this.f34818h);
        }
    }
}

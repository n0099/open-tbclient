package com.kwad.sdk.feed.a.a.b.a;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.download.b.a;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.glide.load.h;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.widget.RCPVADFrameLayout;
/* loaded from: classes7.dex */
public class d extends com.kwad.sdk.feed.a.a.a.a implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public RCPVADFrameLayout f37346b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f37347c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f37348d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f37349e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f37350f;

    /* renamed from: g  reason: collision with root package name */
    public AdTemplate f37351g;

    /* renamed from: h  reason: collision with root package name */
    public AdInfo f37352h;

    /* renamed from: i  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f37353i;
    public KsAppDownloadListener j;

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65538, this, i2) == null) {
            com.kwad.sdk.core.report.b.a(this.f37351g, i2, this.f37346b.getTouchCoords());
        }
    }

    private KsAppDownloadListener e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this)) == null) {
            if (this.j == null) {
                this.j = new com.kwad.sdk.core.download.b.c(this) { // from class: com.kwad.sdk.feed.a.a.b.a.d.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ d f37354a;

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
                        this.f37354a = this;
                    }

                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public void onDownloadFailed() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.f37354a.f37350f.setText(com.kwad.sdk.core.response.b.a.w(this.f37354a.f37352h));
                        }
                    }

                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public void onDownloadFinished() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                            this.f37354a.f37350f.setText(com.kwad.sdk.core.response.b.a.a(this.f37354a.f37351g));
                        }
                    }

                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public void onIdle() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                            this.f37354a.f37350f.setText(com.kwad.sdk.core.response.b.a.w(this.f37354a.f37352h));
                        }
                    }

                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public void onInstalled() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                            this.f37354a.f37350f.setText(com.kwad.sdk.core.response.b.a.b());
                        }
                    }

                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public void onProgressUpdate(int i2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeI(1048580, this, i2) == null) {
                            TextView textView = this.f37354a.f37350f;
                            textView.setText("下载中..." + i2 + "%");
                        }
                    }
                };
            }
            return this.j;
        }
        return (KsAppDownloadListener) invokeV.objValue;
    }

    @Override // com.kwad.sdk.lib.widget.recycler.b.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        TextView textView;
        int i2;
        com.kwad.sdk.core.download.b.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            AdTemplate adTemplate = (AdTemplate) ((com.kwad.sdk.feed.a.a.a.b) ((com.kwad.sdk.lib.widget.recycler.b.b) this).f38574a).f38573i;
            this.f37351g = adTemplate;
            this.f37352h = com.kwad.sdk.core.response.b.c.j(adTemplate);
            CallerContext callercontext = ((com.kwad.sdk.lib.widget.recycler.b.b) this).f38574a;
            this.f37353i = ((com.kwad.sdk.feed.a.a.a.b) callercontext).f37315b;
            com.kwad.sdk.glide.c.a(((com.kwad.sdk.feed.a.a.a.b) callercontext).f38568d).a(com.kwad.sdk.core.response.b.c.q(this.f37351g)).a(o().getResources().getDrawable(R.drawable.ksad_photo_default_author_icon)).c(o().getResources().getDrawable(R.drawable.ksad_photo_default_author_icon)).a((h<Bitmap>) new com.kwad.sdk.support.a()).a(this.f37347c);
            String v = com.kwad.sdk.core.response.b.c.v(this.f37351g);
            if (ag.a(v) && com.kwad.sdk.core.response.b.c.c(this.f37351g)) {
                v = o().getString(R.string.ksad_ad_default_username_normal);
            }
            this.f37348d.setText(v);
            String x = com.kwad.sdk.core.response.b.c.x((AdTemplate) ((com.kwad.sdk.feed.a.a.a.b) ((com.kwad.sdk.lib.widget.recycler.b.b) this).f38574a).f38573i);
            if (ag.a(x)) {
                textView = this.f37349e;
                i2 = 8;
            } else {
                this.f37349e.setText(x);
                textView = this.f37349e;
                i2 = 0;
            }
            textView.setVisibility(i2);
            this.f37350f.setText(com.kwad.sdk.core.response.b.a.w(this.f37352h));
            if (com.kwad.sdk.core.response.b.a.y(this.f37352h) && (bVar = this.f37353i) != null) {
                bVar.a(e());
            }
            this.f37347c.setOnClickListener(this);
            this.f37348d.setOnClickListener(this);
            this.f37350f.setOnClickListener(this);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.b_();
            com.kwad.sdk.core.download.b.b bVar = this.f37353i;
            if (bVar != null) {
                bVar.b(this.j);
            }
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.c();
            this.f37346b = (RCPVADFrameLayout) b(R.id.ksad_feed_item_root);
            this.f37347c = (ImageView) b(R.id.ksad_feed_item_author_icon);
            this.f37348d = (TextView) b(R.id.ksad_feed_item_author_name);
            this.f37349e = (TextView) b(R.id.ksad_feed_item_photo_desc);
            this.f37350f = (TextView) b(R.id.ksad_ad_convert_btn);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            com.kwad.sdk.core.download.b.a.a(view.getContext(), this.f37351g, new a.InterfaceC0426a(this, view == this.f37347c ? 55 : view == this.f37348d ? 82 : view == this.f37350f ? 83 : 0) { // from class: com.kwad.sdk.feed.a.a.b.a.d.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ int f37355a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ d f37356b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Integer.valueOf(r7)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f37356b = this;
                    this.f37355a = r7;
                }

                @Override // com.kwad.sdk.core.download.b.a.InterfaceC0426a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f37356b.a(this.f37355a);
                    }
                }
            }, this.f37353i);
        }
    }
}

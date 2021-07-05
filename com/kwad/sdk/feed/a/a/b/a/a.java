package com.kwad.sdk.feed.a.a.b.a;

import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
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
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.widget.RCPVADFrameLayout;
/* loaded from: classes7.dex */
public class a extends com.kwad.sdk.feed.a.a.a.a implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public RCPVADFrameLayout f37325b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f37326c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f37327d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f37328e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f37329f;

    /* renamed from: g  reason: collision with root package name */
    public AdTemplate f37330g;

    /* renamed from: h  reason: collision with root package name */
    public AdInfo f37331h;

    /* renamed from: i  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f37332i;
    public KsAppDownloadListener j;

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
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65538, this, i2) == null) {
            com.kwad.sdk.core.report.b.a(this.f37330g, i2, this.f37325b.getTouchCoords());
        }
    }

    private KsAppDownloadListener e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) {
            if (this.j == null) {
                this.j = new com.kwad.sdk.core.download.b.c(this) { // from class: com.kwad.sdk.feed.a.a.b.a.a.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ a f37333a;

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
                        this.f37333a = this;
                    }

                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public void onDownloadFailed() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.f37333a.f37329f.setTextColor(this.f37333a.o().getResources().getColor(R.color.ksad_feed_covert_idle));
                            this.f37333a.f37329f.setText(com.kwad.sdk.core.response.b.a.w(this.f37333a.f37331h));
                            this.f37333a.f37329f.setBackgroundResource(R.drawable.ksad_feed_item_covert_btn_idle_bg);
                            ViewGroup.LayoutParams layoutParams = this.f37333a.f37329f.getLayoutParams();
                            layoutParams.width = -2;
                            this.f37333a.f37329f.setLayoutParams(layoutParams);
                        }
                    }

                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public void onDownloadFinished() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                            this.f37333a.f37329f.setTextColor(this.f37333a.o().getResources().getColor(R.color.ksad_feed_covert_finish));
                            this.f37333a.f37329f.setText(com.kwad.sdk.core.response.b.a.a(this.f37333a.f37330g));
                            this.f37333a.f37329f.setBackgroundResource(R.drawable.ksad_feed_item_covert_btn_finish_bg);
                            ViewGroup.LayoutParams layoutParams = this.f37333a.f37329f.getLayoutParams();
                            layoutParams.width = -2;
                            this.f37333a.f37329f.setLayoutParams(layoutParams);
                        }
                    }

                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public void onIdle() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                            this.f37333a.f37329f.setTextColor(this.f37333a.o().getResources().getColor(R.color.ksad_feed_covert_idle));
                            this.f37333a.f37329f.setText(com.kwad.sdk.core.response.b.a.w(this.f37333a.f37331h));
                            this.f37333a.f37329f.setBackgroundResource(R.drawable.ksad_feed_item_covert_btn_idle_bg);
                            ViewGroup.LayoutParams layoutParams = this.f37333a.f37329f.getLayoutParams();
                            layoutParams.width = -2;
                            this.f37333a.f37329f.setLayoutParams(layoutParams);
                        }
                    }

                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public void onInstalled() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                            this.f37333a.f37329f.setTextColor(this.f37333a.o().getResources().getColor(R.color.ksad_feed_covert_finish));
                            this.f37333a.f37329f.setText(com.kwad.sdk.core.response.b.a.b());
                            this.f37333a.f37329f.setBackgroundResource(R.drawable.ksad_feed_item_covert_btn_finish_bg);
                            ViewGroup.LayoutParams layoutParams = this.f37333a.f37329f.getLayoutParams();
                            layoutParams.width = -2;
                            this.f37333a.f37329f.setLayoutParams(layoutParams);
                        }
                    }

                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public void onProgressUpdate(int i2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeI(1048580, this, i2) == null) {
                            this.f37333a.f37329f.setTextColor(this.f37333a.o().getResources().getColor(R.color.ksad_feed_covert_idle));
                            TextView textView = this.f37333a.f37329f;
                            textView.setText("下载中..." + i2 + "%");
                            this.f37333a.f37329f.setBackgroundResource(R.drawable.ksad_feed_item_covert_btn_idle_bg);
                            ViewGroup.LayoutParams layoutParams = this.f37333a.f37329f.getLayoutParams();
                            layoutParams.width = ao.a(this.f37333a.o(), 76.0f);
                            this.f37333a.f37329f.setLayoutParams(layoutParams);
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
            this.f37330g = adTemplate;
            this.f37331h = com.kwad.sdk.core.response.b.c.j(adTemplate);
            this.f37332i = ((com.kwad.sdk.feed.a.a.a.b) ((com.kwad.sdk.lib.widget.recycler.b.b) this).f38574a).f37315b;
            String x = com.kwad.sdk.core.response.b.c.x(this.f37330g);
            if (ag.a(x)) {
                textView = this.f37326c;
                i2 = 8;
            } else {
                this.f37326c.setText(x);
                textView = this.f37326c;
                i2 = 0;
            }
            textView.setVisibility(i2);
            com.kwad.sdk.glide.c.a(((com.kwad.sdk.feed.a.a.a.b) ((com.kwad.sdk.lib.widget.recycler.b.b) this).f38574a).f38568d).a(com.kwad.sdk.core.response.b.c.q(this.f37330g)).a(o().getResources().getDrawable(R.drawable.ksad_photo_default_author_icon)).c(o().getResources().getDrawable(R.drawable.ksad_photo_default_author_icon)).a((h<Bitmap>) new com.kwad.sdk.support.a()).a(this.f37327d);
            String v = com.kwad.sdk.core.response.b.c.v(this.f37330g);
            if (ag.a(v) && com.kwad.sdk.core.response.b.c.c(this.f37330g)) {
                v = o().getString(R.string.ksad_ad_default_username_normal);
            }
            this.f37328e.setText(v);
            this.f37329f.setTextColor(o().getResources().getColor(R.color.ksad_feed_covert_idle));
            this.f37329f.setText(com.kwad.sdk.core.response.b.a.w(this.f37331h));
            this.f37329f.setBackgroundResource(R.drawable.ksad_feed_item_covert_btn_idle_bg);
            ViewGroup.LayoutParams layoutParams = this.f37329f.getLayoutParams();
            layoutParams.width = -2;
            this.f37329f.setLayoutParams(layoutParams);
            if (com.kwad.sdk.core.response.b.a.y(this.f37331h) && (bVar = this.f37332i) != null) {
                bVar.a(e());
            }
            this.f37327d.setOnClickListener(this);
            this.f37328e.setOnClickListener(this);
            this.f37329f.setOnClickListener(this);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.b_();
            com.kwad.sdk.core.download.b.b bVar = this.f37332i;
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
            this.f37325b = (RCPVADFrameLayout) b(R.id.ksad_feed_item_root);
            this.f37326c = (TextView) b(R.id.ksad_feed_item_photo_desc);
            this.f37329f = (TextView) b(R.id.ksad_ad_convert_btn);
            this.f37327d = (ImageView) b(R.id.ksad_feed_item_author_icon);
            this.f37328e = (TextView) b(R.id.ksad_feed_item_author_name);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            com.kwad.sdk.core.download.b.a.a(view.getContext(), this.f37330g, new a.InterfaceC0426a(this, view == this.f37327d ? 55 : view == this.f37328e ? 82 : view == this.f37329f ? 83 : 0) { // from class: com.kwad.sdk.feed.a.a.b.a.a.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ int f37334a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ a f37335b;

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
                    this.f37335b = this;
                    this.f37334a = r7;
                }

                @Override // com.kwad.sdk.core.download.b.a.InterfaceC0426a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f37335b.a(this.f37334a);
                    }
                }
            }, this.f37332i);
        }
    }
}

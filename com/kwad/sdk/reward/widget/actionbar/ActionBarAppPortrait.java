package com.kwad.sdk.reward.widget.actionbar;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
import com.kwad.sdk.core.download.b.b;
import com.kwad.sdk.core.download.b.c;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.page.widget.TextProgressBar;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.reward.widget.AppScoreView;
import com.kwad.sdk.utils.ao;
/* loaded from: classes7.dex */
public class ActionBarAppPortrait extends LinearLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ImageView f39081a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f39082b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f39083c;

    /* renamed from: d  reason: collision with root package name */
    public AppScoreView f39084d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f39085e;

    /* renamed from: f  reason: collision with root package name */
    public TextProgressBar f39086f;

    /* renamed from: g  reason: collision with root package name */
    public View f39087g;

    /* renamed from: h  reason: collision with root package name */
    public AdTemplate f39088h;

    /* renamed from: i  reason: collision with root package name */
    public AdInfo f39089i;
    public a j;
    public b k;
    public KsAppDownloadListener l;

    /* loaded from: classes7.dex */
    public interface a {
        void a();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ActionBarAppPortrait(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ActionBarAppPortrait(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ActionBarAppPortrait(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        a();
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65540, this) == null) {
            LinearLayout.inflate(getContext(), R.layout.ksad_video_actionbar_app_portrait, this);
            this.f39081a = (ImageView) findViewById(R.id.ksad_app_icon);
            this.f39082b = (TextView) findViewById(R.id.ksad_app_title);
            this.f39083c = (TextView) findViewById(R.id.ksad_app_desc);
            this.f39084d = (AppScoreView) findViewById(R.id.ksad_app_score);
            this.f39085e = (TextView) findViewById(R.id.ksad_app_download_count);
            TextProgressBar textProgressBar = (TextProgressBar) findViewById(R.id.ksad_app_download_btn);
            this.f39086f = textProgressBar;
            textProgressBar.setTextDimen(ao.a(getContext(), 16.0f));
            this.f39086f.setTextColor(-1);
            this.f39087g = findViewById(R.id.ksad_download_bar_cover);
        }
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
            String t = com.kwad.sdk.core.response.b.a.t(this.f39089i);
            boolean z = !TextUtils.isEmpty(t);
            float u = com.kwad.sdk.core.response.b.a.u(this.f39089i);
            boolean z2 = u >= 3.0f;
            if (z && z2) {
                ((LinearLayout.LayoutParams) this.f39082b.getLayoutParams()).bottomMargin = ao.a(getContext(), 1.0f);
                ((LinearLayout.LayoutParams) this.f39084d.getLayoutParams()).bottomMargin = ao.a(getContext(), 1.0f);
                this.f39085e.setText(t);
                this.f39085e.setVisibility(0);
                this.f39084d.setVisibility(0);
                this.f39084d.setScore(u);
            } else if (z) {
                this.f39085e.setText(t);
                this.f39085e.setVisibility(0);
                this.f39084d.setVisibility(8);
            } else if (!z2) {
                this.f39083c.setText(com.kwad.sdk.core.response.b.a.n(this.f39089i));
                this.f39085e.setVisibility(8);
                this.f39084d.setVisibility(8);
                this.f39083c.setVisibility(0);
                return;
            } else {
                this.f39085e.setVisibility(8);
                this.f39084d.setScore(u);
                this.f39084d.setVisibility(0);
            }
            this.f39083c.setVisibility(8);
        }
    }

    private KsAppDownloadListener getAppDownloadListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) {
            if (this.l == null) {
                this.l = new c(this) { // from class: com.kwad.sdk.reward.widget.actionbar.ActionBarAppPortrait.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ ActionBarAppPortrait f39090a;

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
                        this.f39090a = this;
                    }

                    @Override // com.kwad.sdk.core.download.b.c
                    public void a(int i2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeI(1048576, this, i2) == null) {
                            this.f39090a.f39086f.a(com.kwad.sdk.core.response.b.a.c(i2), i2);
                            this.f39090a.f39087g.setVisibility(8);
                        }
                    }

                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public void onDownloadFailed() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                            this.f39090a.f39086f.a(com.kwad.sdk.core.response.b.a.w(this.f39090a.f39089i), 0);
                            this.f39090a.f39087g.setVisibility(0);
                        }
                    }

                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public void onDownloadFinished() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                            this.f39090a.f39086f.a(com.kwad.sdk.core.response.b.a.a(this.f39090a.f39088h), 0);
                            this.f39090a.f39087g.setVisibility(0);
                        }
                    }

                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public void onIdle() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                            this.f39090a.f39086f.a(com.kwad.sdk.core.response.b.a.w(this.f39090a.f39089i), 0);
                            this.f39090a.f39087g.setVisibility(0);
                        }
                    }

                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public void onInstalled() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048580, this) == null) {
                            this.f39090a.f39086f.a(com.kwad.sdk.core.response.b.a.b(), 0);
                            this.f39090a.f39087g.setVisibility(0);
                        }
                    }

                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public void onProgressUpdate(int i2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeI(1048581, this, i2) == null) {
                            this.f39090a.f39086f.a(com.kwad.sdk.core.response.b.a.a(i2), i2);
                            this.f39090a.f39087g.setVisibility(8);
                        }
                    }
                };
            }
            return this.l;
        }
        return (KsAppDownloadListener) invokeV.objValue;
    }

    public void a(@NonNull AdTemplate adTemplate, @Nullable b bVar, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, adTemplate, bVar, aVar) == null) {
            this.f39088h = adTemplate;
            AdInfo j = com.kwad.sdk.core.response.b.c.j(adTemplate);
            this.f39089i = j;
            this.j = aVar;
            this.k = bVar;
            KSImageLoader.loadAppIcon(this.f39081a, com.kwad.sdk.core.response.b.a.o(j), adTemplate, 12);
            this.f39082b.setText(com.kwad.sdk.core.response.b.a.q(this.f39089i));
            b();
            this.f39086f.a(com.kwad.sdk.core.response.b.a.w(this.f39089i), 0);
            b bVar2 = this.k;
            if (bVar2 != null) {
                bVar2.a(getAppDownloadListener());
            }
            setOnClickListener(this);
            this.f39086f.setOnClickListener(this);
        }
    }

    public b getApkDownloadHelper() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.k : (b) invokeV.objValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) {
            b.a(this.k, view == this.f39086f);
            com.kwad.sdk.core.download.b.a.a(view.getContext(), this.f39088h, new a.InterfaceC0426a(this) { // from class: com.kwad.sdk.reward.widget.actionbar.ActionBarAppPortrait.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ ActionBarAppPortrait f39091a;

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
                    this.f39091a = this;
                }

                @Override // com.kwad.sdk.core.download.b.a.InterfaceC0426a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f39091a.j == null) {
                        return;
                    }
                    this.f39091a.j.a();
                }
            }, this.k);
        }
    }
}

package com.kwad.sdk.reward.widget.tailframe;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
import com.kwad.sdk.core.download.b.a;
import com.kwad.sdk.core.download.b.c;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.page.widget.TextProgressBar;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.reward.widget.tailframe.appbar.TailFrameBarAppLandscape;
import com.kwad.sdk.reward.widget.tailframe.h5bar.TailFrameBarH5Landscape;
import com.kwad.sdk.widget.KsLogoView;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class TailFrameLandscapeHorizontal extends LinearLayout implements View.OnClickListener, a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ImageView f39119a;

    /* renamed from: b  reason: collision with root package name */
    public TailFrameBarAppLandscape f39120b;

    /* renamed from: c  reason: collision with root package name */
    public TailFrameBarH5Landscape f39121c;

    /* renamed from: d  reason: collision with root package name */
    public b f39122d;

    /* renamed from: e  reason: collision with root package name */
    public AdTemplate f39123e;

    /* renamed from: f  reason: collision with root package name */
    public AdInfo f39124f;

    /* renamed from: g  reason: collision with root package name */
    public JSONObject f39125g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f39126h;

    /* renamed from: i  reason: collision with root package name */
    public TextProgressBar f39127i;
    public KsLogoView j;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TailFrameLandscapeHorizontal(Context context) {
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
    public TailFrameLandscapeHorizontal(Context context, @Nullable AttributeSet attributeSet) {
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
    public TailFrameLandscapeHorizontal(Context context, @Nullable AttributeSet attributeSet, int i2) {
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
        c();
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
            LinearLayout.inflate(getContext(), R.layout.ksad_video_tf_view_landscape_horizontal, this);
            this.f39119a = (ImageView) findViewById(R.id.ksad_video_thumb_img);
            this.j = (KsLogoView) findViewById(R.id.ksad_video_tf_logo);
        }
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            if (!com.kwad.sdk.core.response.b.a.y(this.f39124f)) {
                TailFrameBarH5Landscape tailFrameBarH5Landscape = (TailFrameBarH5Landscape) findViewById(R.id.ksad_video_h5_tail_frame);
                this.f39121c = tailFrameBarH5Landscape;
                tailFrameBarH5Landscape.setModel(this.f39123e);
                this.f39121c.setVisibility(0);
                return;
            }
            TailFrameBarAppLandscape tailFrameBarAppLandscape = (TailFrameBarAppLandscape) findViewById(R.id.ksad_video_app_tail_frame);
            this.f39120b = tailFrameBarAppLandscape;
            tailFrameBarAppLandscape.setModel(this.f39123e);
            this.f39120b.setVisibility(0);
            this.f39127i = this.f39120b.getTextProgressBar();
            e();
            this.f39127i.setOnClickListener(this);
        }
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            this.f39126h = new com.kwad.sdk.core.download.b.b(this.f39123e, this.f39125g, new c(this) { // from class: com.kwad.sdk.reward.widget.tailframe.TailFrameLandscapeHorizontal.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ TailFrameLandscapeHorizontal f39128a;

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
                    this.f39128a = this;
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onDownloadFailed() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f39128a.f39120b.a(com.kwad.sdk.core.response.b.c.j(this.f39128a.f39123e));
                        this.f39128a.f39127i.a(com.kwad.sdk.core.response.b.a.w(this.f39128a.f39124f), 0);
                    }
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onDownloadFinished() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        this.f39128a.f39120b.a(com.kwad.sdk.core.response.b.c.j(this.f39128a.f39123e));
                        this.f39128a.f39127i.a(com.kwad.sdk.core.response.b.a.a(this.f39128a.f39123e), 0);
                    }
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onIdle() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                        this.f39128a.f39120b.a(com.kwad.sdk.core.response.b.c.j(this.f39128a.f39123e));
                        this.f39128a.f39127i.a(com.kwad.sdk.core.response.b.a.w(this.f39128a.f39124f), 0);
                    }
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onInstalled() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                        this.f39128a.f39120b.a(com.kwad.sdk.core.response.b.c.j(this.f39128a.f39123e));
                        this.f39128a.f39127i.a(com.kwad.sdk.core.response.b.a.b(), 0);
                    }
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onProgressUpdate(int i2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeI(1048580, this, i2) == null) {
                        this.f39128a.f39120b.a(com.kwad.sdk.core.response.b.c.j(this.f39128a.f39123e));
                        this.f39128a.f39127i.a(com.kwad.sdk.core.response.b.a.a(i2), i2);
                    }
                }
            });
        }
    }

    private void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            setOnClickListener(null);
            this.f39126h = null;
        }
    }

    @Override // com.kwad.sdk.reward.widget.tailframe.a
    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this : (View) invokeV.objValue;
    }

    @Override // com.kwad.sdk.reward.widget.tailframe.a
    public void a(@NonNull AdTemplate adTemplate, JSONObject jSONObject, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adTemplate, jSONObject, bVar) == null) {
            this.f39123e = adTemplate;
            this.f39124f = com.kwad.sdk.core.response.b.c.j(adTemplate);
            this.f39125g = jSONObject;
            this.f39122d = bVar;
            this.j.a(this.f39123e);
            KSImageLoader.loadImage(this.f39119a, com.kwad.sdk.core.response.b.a.f(this.f39124f), this.f39123e);
            d();
            setOnClickListener(this);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            TailFrameBarAppLandscape tailFrameBarAppLandscape = this.f39120b;
            if (tailFrameBarAppLandscape != null) {
                tailFrameBarAppLandscape.a();
                this.f39120b.setVisibility(8);
            }
            TailFrameBarH5Landscape tailFrameBarH5Landscape = this.f39121c;
            if (tailFrameBarH5Landscape != null) {
                tailFrameBarH5Landscape.a();
                this.f39121c.setVisibility(8);
            }
            f();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            com.kwad.sdk.core.download.b.b.a(this.f39126h, view == this.f39127i);
            com.kwad.sdk.core.download.b.a.a(view.getContext(), this.f39123e, new a.InterfaceC0426a(this) { // from class: com.kwad.sdk.reward.widget.tailframe.TailFrameLandscapeHorizontal.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ TailFrameLandscapeHorizontal f39129a;

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
                    this.f39129a = this;
                }

                @Override // com.kwad.sdk.core.download.b.a.InterfaceC0426a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f39129a.f39122d == null) {
                        return;
                    }
                    this.f39129a.f39122d.a();
                }
            }, this.f39126h);
        }
    }
}

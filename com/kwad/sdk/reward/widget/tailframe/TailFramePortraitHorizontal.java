package com.kwad.sdk.reward.widget.tailframe;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
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
import com.kwad.sdk.reward.widget.tailframe.appbar.TailFrameBarAppPortraitHorizontal;
import com.kwad.sdk.reward.widget.tailframe.h5bar.TailFrameBarH5PortraitHorizontal;
import com.kwad.sdk.utils.av;
import com.kwad.sdk.widget.KsLogoView;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class TailFramePortraitHorizontal extends LinearLayout implements View.OnClickListener, a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ImageView f74033a;

    /* renamed from: b  reason: collision with root package name */
    public TailFrameBarAppPortraitHorizontal f74034b;

    /* renamed from: c  reason: collision with root package name */
    public TailFrameBarH5PortraitHorizontal f74035c;

    /* renamed from: d  reason: collision with root package name */
    public b f74036d;

    /* renamed from: e  reason: collision with root package name */
    public AdTemplate f74037e;

    /* renamed from: f  reason: collision with root package name */
    public AdInfo f74038f;

    /* renamed from: g  reason: collision with root package name */
    public JSONObject f74039g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f74040h;

    /* renamed from: i  reason: collision with root package name */
    public TextProgressBar f74041i;

    /* renamed from: j  reason: collision with root package name */
    public KsLogoView f74042j;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TailFramePortraitHorizontal(Context context) {
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
    public TailFramePortraitHorizontal(Context context, @Nullable AttributeSet attributeSet) {
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
    public TailFramePortraitHorizontal(Context context, @Nullable AttributeSet attributeSet, int i2) {
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
            LinearLayout.inflate(getContext(), R.layout.ksad_video_tf_view_portrait_horizontal, this);
            this.f74033a = (ImageView) findViewById(R.id.ksad_video_thumb_img);
            this.f74042j = (KsLogoView) findViewById(R.id.ksad_video_tf_logo);
        }
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            AdInfo.AdMaterialInfo.MaterialFeature C = com.kwad.sdk.core.response.b.a.C(this.f74038f);
            int i2 = C.width;
            int i3 = C.height;
            int c2 = av.c(getContext());
            ViewGroup.LayoutParams layoutParams = this.f74033a.getLayoutParams();
            layoutParams.width = c2;
            layoutParams.height = (int) (c2 * (i3 / i2));
            KSImageLoader.loadImage(this.f74033a, C.coverUrl, this.f74037e);
        }
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            if (!com.kwad.sdk.core.response.b.a.v(this.f74038f)) {
                TailFrameBarH5PortraitHorizontal tailFrameBarH5PortraitHorizontal = (TailFrameBarH5PortraitHorizontal) findViewById(R.id.ksad_video_h5_tail_frame);
                this.f74035c = tailFrameBarH5PortraitHorizontal;
                tailFrameBarH5PortraitHorizontal.setModel(this.f74037e);
                this.f74035c.setVisibility(0);
                return;
            }
            TailFrameBarAppPortraitHorizontal tailFrameBarAppPortraitHorizontal = (TailFrameBarAppPortraitHorizontal) findViewById(R.id.ksad_video_app_tail_frame);
            this.f74034b = tailFrameBarAppPortraitHorizontal;
            tailFrameBarAppPortraitHorizontal.a(this.f74037e);
            this.f74034b.setVisibility(0);
            this.f74041i = this.f74034b.getTextProgressBar();
            f();
            this.f74041i.setOnClickListener(this);
        }
    }

    private void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            this.f74040h = new com.kwad.sdk.core.download.b.b(this.f74037e, this.f74039g, new c(this) { // from class: com.kwad.sdk.reward.widget.tailframe.TailFramePortraitHorizontal.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ TailFramePortraitHorizontal f74043b;

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
                    this.f74043b = this;
                }

                @Override // com.kwad.sdk.core.download.b.c
                public void a(int i2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeI(1048576, this, i2) == null) {
                        this.f74043b.f74034b.a(this.f74043b.f74038f);
                        this.f74043b.f74041i.a(com.kwad.sdk.core.response.b.a.b(i2), i2);
                    }
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onDownloadFailed() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        this.f74043b.f74034b.a(this.f74043b.f74038f);
                        this.f74043b.f74041i.a(com.kwad.sdk.core.response.b.a.u(this.f74043b.f74038f), 0);
                    }
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onDownloadFinished() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                        this.f74043b.f74034b.a(this.f74043b.f74038f);
                        this.f74043b.f74041i.a(com.kwad.sdk.core.response.b.a.a(this.f74043b.f74037e), 0);
                    }
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onIdle() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                        this.f74043b.f74034b.a(this.f74043b.f74038f);
                        this.f74043b.f74041i.a(com.kwad.sdk.core.response.b.a.u(this.f74043b.f74038f), 0);
                    }
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onInstalled() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048580, this) == null) {
                        this.f74043b.f74034b.a(this.f74043b.f74038f);
                        this.f74043b.f74041i.a(com.kwad.sdk.core.response.b.a.j(this.f74043b.f74038f), 0);
                    }
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onProgressUpdate(int i2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeI(1048581, this, i2) == null) {
                        this.f74043b.f74034b.a(this.f74043b.f74038f);
                        this.f74043b.f74041i.a(com.kwad.sdk.core.response.b.a.a(i2), i2);
                    }
                }
            });
        }
    }

    private void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            setOnClickListener(null);
            this.f74040h = null;
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
            this.f74037e = adTemplate;
            this.f74038f = com.kwad.sdk.core.response.b.c.i(adTemplate);
            this.f74039g = jSONObject;
            this.f74036d = bVar;
            this.f74042j.a(this.f74037e);
            d();
            e();
            setOnClickListener(this);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            TailFrameBarAppPortraitHorizontal tailFrameBarAppPortraitHorizontal = this.f74034b;
            if (tailFrameBarAppPortraitHorizontal != null) {
                tailFrameBarAppPortraitHorizontal.a();
                this.f74034b.setVisibility(8);
            }
            TailFrameBarH5PortraitHorizontal tailFrameBarH5PortraitHorizontal = this.f74035c;
            if (tailFrameBarH5PortraitHorizontal != null) {
                tailFrameBarH5PortraitHorizontal.a();
                this.f74035c.setVisibility(8);
            }
            g();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            com.kwad.sdk.core.download.b.a.a(view.getContext(), this.f74037e, new a.InterfaceC1992a(this) { // from class: com.kwad.sdk.reward.widget.tailframe.TailFramePortraitHorizontal.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ TailFramePortraitHorizontal f74044a;

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
                    this.f74044a = this;
                }

                @Override // com.kwad.sdk.core.download.b.a.InterfaceC1992a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f74044a.f74036d == null) {
                        return;
                    }
                    this.f74044a.f74036d.a();
                }
            }, this.f74040h, view == this.f74041i);
        }
    }
}

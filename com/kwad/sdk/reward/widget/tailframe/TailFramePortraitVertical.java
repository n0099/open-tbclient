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
import com.kwad.sdk.reward.widget.tailframe.appbar.TailFrameBarAppPortraitVertical;
import com.kwad.sdk.reward.widget.tailframe.h5bar.TailFrameBarH5PortraitVertical;
import com.kwad.sdk.widget.KsLogoView;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class TailFramePortraitVertical extends LinearLayout implements View.OnClickListener, a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ImageView f66436a;

    /* renamed from: b  reason: collision with root package name */
    public TailFrameBarAppPortraitVertical f66437b;

    /* renamed from: c  reason: collision with root package name */
    public TailFrameBarH5PortraitVertical f66438c;

    /* renamed from: d  reason: collision with root package name */
    public b f66439d;

    /* renamed from: e  reason: collision with root package name */
    public AdTemplate f66440e;

    /* renamed from: f  reason: collision with root package name */
    public AdInfo f66441f;

    /* renamed from: g  reason: collision with root package name */
    public JSONObject f66442g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f66443h;

    /* renamed from: i  reason: collision with root package name */
    public TextProgressBar f66444i;
    public KsLogoView j;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TailFramePortraitVertical(Context context) {
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
    public TailFramePortraitVertical(Context context, @Nullable AttributeSet attributeSet) {
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
    public TailFramePortraitVertical(Context context, @Nullable AttributeSet attributeSet, int i2) {
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
            LinearLayout.inflate(getContext(), R.layout.ksad_video_tf_view_portrait_vertical, this);
            this.f66436a = (ImageView) findViewById(R.id.ksad_video_thumb_img);
            this.j = (KsLogoView) findViewById(R.id.ksad_video_tf_logo);
        }
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            if (!com.kwad.sdk.core.response.b.a.v(this.f66441f)) {
                TailFrameBarH5PortraitVertical tailFrameBarH5PortraitVertical = (TailFrameBarH5PortraitVertical) findViewById(R.id.ksad_video_h5_tail_frame);
                this.f66438c = tailFrameBarH5PortraitVertical;
                tailFrameBarH5PortraitVertical.a(this.f66440e);
                this.f66438c.setVisibility(0);
                return;
            }
            TailFrameBarAppPortraitVertical tailFrameBarAppPortraitVertical = (TailFrameBarAppPortraitVertical) findViewById(R.id.ksad_video_app_tail_frame);
            this.f66437b = tailFrameBarAppPortraitVertical;
            tailFrameBarAppPortraitVertical.a(this.f66440e);
            this.f66437b.setVisibility(0);
            this.f66444i = this.f66437b.getTextProgressBar();
            e();
            this.f66444i.setOnClickListener(this);
        }
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            this.f66443h = new com.kwad.sdk.core.download.b.b(this.f66440e, this.f66442g, new c(this) { // from class: com.kwad.sdk.reward.widget.tailframe.TailFramePortraitVertical.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ TailFramePortraitVertical f66445b;

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
                    this.f66445b = this;
                }

                @Override // com.kwad.sdk.core.download.b.c
                public void a(int i2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeI(1048576, this, i2) == null) {
                        this.f66445b.f66437b.a(this.f66445b.f66441f);
                        this.f66445b.f66444i.a(com.kwad.sdk.core.response.b.a.b(i2), i2);
                    }
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onDownloadFailed() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        this.f66445b.f66437b.a(this.f66445b.f66441f);
                        this.f66445b.f66444i.a(com.kwad.sdk.core.response.b.a.u(this.f66445b.f66441f), 0);
                    }
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onDownloadFinished() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                        this.f66445b.f66437b.a(this.f66445b.f66441f);
                        this.f66445b.f66444i.a(com.kwad.sdk.core.response.b.a.a(this.f66445b.f66440e), 0);
                    }
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onIdle() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                        this.f66445b.f66437b.a(this.f66445b.f66441f);
                        this.f66445b.f66444i.a(com.kwad.sdk.core.response.b.a.u(this.f66445b.f66441f), 0);
                    }
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onInstalled() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048580, this) == null) {
                        this.f66445b.f66437b.a(this.f66445b.f66441f);
                        this.f66445b.f66444i.a(com.kwad.sdk.core.response.b.a.j(this.f66445b.f66441f), 0);
                    }
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onProgressUpdate(int i2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeI(1048581, this, i2) == null) {
                        this.f66445b.f66437b.a(this.f66445b.f66441f);
                        this.f66445b.f66444i.a(com.kwad.sdk.core.response.b.a.a(i2), i2);
                    }
                }
            });
        }
    }

    private void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            setOnClickListener(null);
            this.f66443h = null;
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
            this.f66440e = adTemplate;
            AdInfo i2 = com.kwad.sdk.core.response.b.c.i(adTemplate);
            this.f66441f = i2;
            this.f66442g = jSONObject;
            this.f66439d = bVar;
            KSImageLoader.loadImage(this.f66436a, com.kwad.sdk.core.response.b.a.f(i2), this.f66440e);
            this.j.a(adTemplate);
            d();
            setOnClickListener(this);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            TailFrameBarAppPortraitVertical tailFrameBarAppPortraitVertical = this.f66437b;
            if (tailFrameBarAppPortraitVertical != null) {
                tailFrameBarAppPortraitVertical.a();
                this.f66437b.setVisibility(8);
            }
            TailFrameBarH5PortraitVertical tailFrameBarH5PortraitVertical = this.f66438c;
            if (tailFrameBarH5PortraitVertical != null) {
                tailFrameBarH5PortraitVertical.a();
                this.f66438c.setVisibility(8);
            }
            f();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            com.kwad.sdk.core.download.b.a.a(view.getContext(), this.f66440e, new a.InterfaceC1901a(this) { // from class: com.kwad.sdk.reward.widget.tailframe.TailFramePortraitVertical.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ TailFramePortraitVertical f66446a;

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
                    this.f66446a = this;
                }

                @Override // com.kwad.sdk.core.download.b.a.InterfaceC1901a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f66446a.f66439d == null) {
                        return;
                    }
                    this.f66446a.f66439d.a();
                }
            }, this.f66443h, view == this.f66444i);
        }
    }
}

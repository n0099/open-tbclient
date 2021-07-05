package com.kwad.sdk.reward.b.b.b;

import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.detail.video.f;
import com.kwad.sdk.core.download.b.a;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener;
import com.kwad.sdk.core.imageloader.utils.IoUtils;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.glide.framesequence.FrameSequence;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.widget.AnimatedImageView;
import java.io.InputStream;
/* loaded from: classes7.dex */
public class e extends com.kwad.sdk.reward.d implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f38943b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f38944c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f38945d;

    /* renamed from: e  reason: collision with root package name */
    public ViewGroup f38946e;

    /* renamed from: f  reason: collision with root package name */
    public AnimatedImageView f38947f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f38948g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f38949h;

    /* renamed from: i  reason: collision with root package name */
    public AdTemplate f38950i;
    public com.kwad.sdk.core.download.b.b j;
    public String k;
    public com.kwad.sdk.contentalliance.detail.video.e l;

    public e() {
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
        this.l = new f(this) { // from class: com.kwad.sdk.reward.b.b.b.e.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ e f38951a;

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
                this.f38951a = this;
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
            public void a(long j, long j2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
                    AdInfo j3 = com.kwad.sdk.core.response.b.c.j(this.f38951a.f38950i);
                    long m = com.kwad.sdk.core.response.b.a.m(j3);
                    if (!com.kwad.sdk.core.response.b.a.l(j3) && m > 0) {
                        j = Math.min(j, m);
                    }
                    this.f38951a.a(j, j2);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
            int i2 = (int) ((((float) (j - j2)) / 1000.0f) + 0.5f);
            if (i2 < 0) {
                this.f38948g.setVisibility(8);
                this.f38949h.setText(o().getString(R.string.ksad_reward_success_tip));
                g();
            } else if (i2 == 0) {
            } else {
                TextView textView = this.f38948g;
                textView.setText(i2 + "s");
                this.f38948g.setVisibility(0);
                this.f38949h.setText(this.k);
            }
        }
    }

    private void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65540, this, str) == null) {
            if (ag.a(str) || !FrameSequence.isEnable()) {
                this.f38947f.setImageResource(R.drawable.ksad_reward_icon_detail);
            } else {
                KSImageLoader.loadImage(str, this.f38950i, KSImageLoader.IMGOPTION_ENTRY, new SimpleImageLoadingListener(this, str) { // from class: com.kwad.sdk.reward.b.b.b.e.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ String f38952a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ e f38953b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, str};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f38953b = this;
                        this.f38952a = str;
                    }

                    @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                    public boolean onDecode(String str2, InputStream inputStream, DecodedResult decodedResult) {
                        InterceptResult invokeLLL;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeLLL = interceptable2.invokeLLL(1048576, this, str2, inputStream, decodedResult)) == null) {
                            try {
                                FrameSequence decodeStream = FrameSequence.decodeStream(inputStream);
                                IoUtils.closeSilently(inputStream);
                                decodedResult.mFrameSequence = decodeStream;
                                return decodeStream != null;
                            } catch (Throwable th) {
                                com.kwad.sdk.core.d.a.a(th);
                                return false;
                            }
                        }
                        return invokeLLL.booleanValue;
                    }

                    @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                    public void onLoadingComplete(String str2, View view, DecodedResult decodedResult) {
                        Interceptable interceptable2 = $ic;
                        if ((interceptable2 == null || interceptable2.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str2, view, decodedResult) == null) && this.f38952a.equals(str2)) {
                            if (decodedResult.mFrameSequence != null) {
                                this.f38953b.f38947f.setWebpStream(decodedResult.mFrameSequence);
                                this.f38953b.f38947f.a();
                                return;
                            }
                            Bitmap bitmap = decodedResult.mBitmap;
                            if (bitmap == null || bitmap.isRecycled()) {
                                return;
                            }
                            this.f38953b.f38947f.setImageBitmap(decodedResult.mBitmap);
                        }
                    }
                });
            }
        }
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f38943b.getLayoutParams();
            marginLayoutParams.leftMargin = 0;
            this.f38943b.setLayoutParams(marginLayoutParams);
            this.f38944c.setVisibility(8);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f38946e.getLayoutParams();
            ImageView imageView = this.f38945d;
            if (imageView == null || imageView.getVisibility() != 0) {
                layoutParams.rightMargin = 0;
            } else {
                layoutParams.rightMargin = ao.a(o(), 40.0f);
            }
            this.f38946e.setLayoutParams(layoutParams);
            AdInfo j = com.kwad.sdk.core.response.b.c.j(this.f38950i);
            long b2 = com.kwad.sdk.core.response.b.a.b(j) * 1000;
            long m = com.kwad.sdk.core.response.b.a.m(j);
            if (!com.kwad.sdk.core.response.b.a.l(j) && m > 0 && b2 != 0) {
                b2 = Math.min(m, b2);
            }
            String b3 = com.kwad.sdk.core.response.b.b.b(this.f38950i);
            this.k = b3;
            if (ag.a(b3)) {
                this.k = o().getString(R.string.ksad_reward_default_tip);
            }
            a(com.kwad.sdk.core.response.b.b.c(this.f38950i));
            a(b2, 0L);
            this.f38946e.setOnClickListener(this);
            this.f38946e.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            com.kwad.sdk.core.report.b.a(this.f38950i, 41, ((com.kwad.sdk.reward.d) this).f39062a.f38818h.getTouchCoords(), ((com.kwad.sdk.reward.d) this).f39062a.f38814d);
            ((com.kwad.sdk.reward.d) this).f39062a.f38812b.a();
        }
    }

    private void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            ((com.kwad.sdk.reward.d) this).f39062a.f38812b.e();
        }
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            com.kwad.sdk.reward.a aVar = ((com.kwad.sdk.reward.d) this).f39062a;
            this.f38950i = aVar.f38816f;
            this.j = aVar.j;
            e();
            ((com.kwad.sdk.reward.d) this).f39062a.f38819i.a(this.l);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.b_();
            ((com.kwad.sdk.reward.d) this).f39062a.f38819i.b(this.l);
            this.f38947f.b();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.c();
            this.f38944c = (TextView) b(R.id.ksad_video_count_down);
            this.f38943b = (ImageView) b(R.id.ksad_video_sound_switch);
            this.f38945d = (ImageView) b(R.id.ksad_detail_close_btn);
            ViewGroup viewGroup = (ViewGroup) b(R.id.ksad_reward_container_new);
            this.f38946e = viewGroup;
            this.f38947f = (AnimatedImageView) viewGroup.findViewById(R.id.ksad_detail_reward_icon_new);
            this.f38948g = (TextView) this.f38946e.findViewById(R.id.ksad_video_count_down_new);
            this.f38949h = (TextView) this.f38946e.findViewById(R.id.ksad_detail_reward_tip_new);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, view) == null) && view == this.f38946e) {
            com.kwad.sdk.core.download.b.a.a(view.getContext(), this.f38950i, new a.InterfaceC0426a(this) { // from class: com.kwad.sdk.reward.b.b.b.e.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ e f38954a;

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
                    this.f38954a = this;
                }

                @Override // com.kwad.sdk.core.download.b.a.InterfaceC0426a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f38954a.f();
                    }
                }
            }, this.j);
        }
    }
}

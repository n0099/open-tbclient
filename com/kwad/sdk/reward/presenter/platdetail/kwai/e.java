package com.kwad.sdk.reward.presenter.platdetail.kwai;

import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.core.download.a.a;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener;
import com.kwad.sdk.core.imageloader.utils.IoUtils;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.glide.framesequence.FrameSequence;
import com.kwad.sdk.reward.g;
import com.kwad.sdk.utils.at;
import com.kwad.sdk.widget.WebpAnimationImageView;
import java.io.InputStream;
/* loaded from: classes3.dex */
public class e extends g implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f59861b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f59862c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f59863d;

    /* renamed from: e  reason: collision with root package name */
    public ViewGroup f59864e;

    /* renamed from: f  reason: collision with root package name */
    public WebpAnimationImageView f59865f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f59866g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f59867h;

    /* renamed from: i  reason: collision with root package name */
    public AdTemplate f59868i;

    /* renamed from: j  reason: collision with root package name */
    public com.kwad.sdk.core.download.a.b f59869j;

    /* renamed from: k  reason: collision with root package name */
    public String f59870k;
    public com.kwad.sdk.contentalliance.detail.video.d l;

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
        this.l = new com.kwad.sdk.contentalliance.detail.video.e(this) { // from class: com.kwad.sdk.reward.presenter.platdetail.kwai.e.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ e a;

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
                this.a = this;
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
            public void a(long j2, long j3) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) {
                    long p = com.kwad.sdk.core.response.a.a.p(com.kwad.sdk.core.response.a.d.j(this.a.f59868i));
                    if (p > 0) {
                        j2 = Math.min(j2, p);
                    }
                    this.a.a(j2, j3);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            int i2 = (int) ((((float) (j2 - j3)) / 1000.0f) + 0.5f);
            if (i2 < 0) {
                this.f59866g.setVisibility(8);
                this.f59867h.setText(q().getString(R.string.ksad_reward_success_tip));
                r();
            } else if (i2 == 0) {
            } else {
                TextView textView = this.f59866g;
                textView.setText(i2 + "s");
                this.f59866g.setVisibility(0);
                this.f59867h.setText(this.f59870k);
            }
        }
    }

    private void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, str) == null) {
            if (at.a(str) || !FrameSequence.isEnable()) {
                this.f59865f.setImageResource(R.drawable.ksad_reward_icon_detail);
            } else {
                KSImageLoader.loadImage(str, this.f59868i, KSImageLoader.IMGOPTION_ENTRY_FS(), new SimpleImageLoadingListener(this, str) { // from class: com.kwad.sdk.reward.presenter.platdetail.kwai.e.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ String a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ e f59871b;

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
                        this.f59871b = this;
                        this.a = str;
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
                        if ((interceptable2 == null || interceptable2.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str2, view, decodedResult) == null) && this.a.equals(str2)) {
                            if (decodedResult.mFrameSequence != null) {
                                this.f59871b.f59865f.setWebpStream(decodedResult.mFrameSequence);
                                this.f59871b.f59865f.a();
                                return;
                            }
                            Bitmap bitmap = decodedResult.mBitmap;
                            if (bitmap == null || bitmap.isRecycled()) {
                                return;
                            }
                            this.f59871b.f59865f.setImageBitmap(decodedResult.mBitmap);
                        }
                    }
                });
            }
        }
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f59861b.getLayoutParams();
            marginLayoutParams.leftMargin = 0;
            this.f59861b.setLayoutParams(marginLayoutParams);
            this.f59862c.setVisibility(8);
            AdInfo j2 = com.kwad.sdk.core.response.a.d.j(this.f59868i);
            long b2 = com.kwad.sdk.core.response.a.a.b(j2) * 1000;
            long p = com.kwad.sdk.core.response.a.a.p(j2);
            if (p > 0 && b2 != 0) {
                b2 = Math.min(p, b2);
            }
            String a = com.kwad.sdk.core.response.a.c.a(this.f59868i);
            this.f59870k = a;
            if (at.a(a)) {
                this.f59870k = q().getString(R.string.ksad_reward_default_tip);
            }
            a(com.kwad.sdk.core.response.a.c.b(this.f59868i));
            a(b2, 0L);
            this.f59864e.setOnClickListener(this);
            this.f59864e.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            com.kwad.sdk.core.report.a.a(this.f59868i, 41, ((g) this).a.f59458j.getTouchCoords(), ((g) this).a.f59453e);
            ((g) this).a.f59450b.a();
        }
    }

    private void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            ((g) this).a.f59450b.e();
        }
    }

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            com.kwad.sdk.reward.a aVar = ((g) this).a;
            this.f59868i = aVar.f59455g;
            this.f59869j = aVar.l;
            e();
            ((g) this).a.f59459k.a(this.l);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.c();
            ((g) this).a.f59459k.b(this.l);
            this.f59865f.b();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.c_();
            this.f59862c = (TextView) a(R.id.ksad_video_count_down);
            this.f59861b = (ImageView) a(R.id.ksad_video_sound_switch);
            this.f59863d = (ImageView) a(R.id.ksad_detail_close_btn);
            ViewGroup viewGroup = (ViewGroup) a(R.id.ksad_reward_container_new);
            this.f59864e = viewGroup;
            this.f59865f = (WebpAnimationImageView) viewGroup.findViewById(R.id.ksad_detail_reward_icon_new);
            this.f59866g = (TextView) this.f59864e.findViewById(R.id.ksad_video_count_down_new);
            this.f59867h = (TextView) this.f59864e.findViewById(R.id.ksad_detail_reward_tip_new);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, view) == null) && view == this.f59864e) {
            com.kwad.sdk.core.download.a.a.a(new a.C2076a(view.getContext()).a(this.f59868i).a(this.f59869j).a(2).a(new a.b(this) { // from class: com.kwad.sdk.reward.presenter.platdetail.kwai.e.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ e a;

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
                    this.a = this;
                }

                @Override // com.kwad.sdk.core.download.a.a.b
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.a.i();
                    }
                }
            }));
        }
    }
}

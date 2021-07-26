package com.kwad.sdk.reward.b.b.b;

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
import com.kwad.sdk.core.download.b.a;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener;
import com.kwad.sdk.core.imageloader.utils.IoUtils;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.glide.framesequence.FrameSequence;
import com.kwad.sdk.utils.an;
import com.kwad.sdk.widget.WebpAnimationImageView;
import java.io.InputStream;
/* loaded from: classes6.dex */
public class e extends com.kwad.sdk.reward.d implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f36210b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f36211c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f36212d;

    /* renamed from: e  reason: collision with root package name */
    public ViewGroup f36213e;

    /* renamed from: f  reason: collision with root package name */
    public WebpAnimationImageView f36214f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f36215g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f36216h;

    /* renamed from: i  reason: collision with root package name */
    public AdTemplate f36217i;
    public com.kwad.sdk.core.download.b.b j;
    public String k;
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
        this.l = new com.kwad.sdk.contentalliance.detail.video.e(this) { // from class: com.kwad.sdk.reward.b.b.b.e.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ e f36218a;

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
                this.f36218a = this;
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
            public void a(long j, long j2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
                    AdInfo i4 = com.kwad.sdk.core.response.b.c.i(this.f36218a.f36217i);
                    long l = com.kwad.sdk.core.response.b.a.l(i4);
                    if (!com.kwad.sdk.core.response.b.a.k(i4) && l > 0) {
                        j = Math.min(j, l);
                    }
                    this.f36218a.a(j, j2);
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
                this.f36215g.setVisibility(8);
                this.f36216h.setText(m().getString(R.string.ksad_reward_success_tip));
                n();
            } else if (i2 == 0) {
            } else {
                TextView textView = this.f36215g;
                textView.setText(i2 + "s");
                this.f36215g.setVisibility(0);
                this.f36216h.setText(this.k);
            }
        }
    }

    private void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, str) == null) {
            if (an.a(str) || !FrameSequence.isEnable()) {
                this.f36214f.setImageResource(R.drawable.ksad_reward_icon_detail);
            } else {
                KSImageLoader.loadImage(str, this.f36217i, KSImageLoader.IMGOPTION_ENTRY_FS(), new SimpleImageLoadingListener(this, str) { // from class: com.kwad.sdk.reward.b.b.b.e.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ String f36219a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ e f36220b;

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
                        this.f36220b = this;
                        this.f36219a = str;
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
                        if ((interceptable2 == null || interceptable2.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str2, view, decodedResult) == null) && this.f36219a.equals(str2)) {
                            if (decodedResult.mFrameSequence != null) {
                                this.f36220b.f36214f.setWebpStream(decodedResult.mFrameSequence);
                                this.f36220b.f36214f.a();
                                return;
                            }
                            Bitmap bitmap = decodedResult.mBitmap;
                            if (bitmap == null || bitmap.isRecycled()) {
                                return;
                            }
                            this.f36220b.f36214f.setImageBitmap(decodedResult.mBitmap);
                        }
                    }
                });
            }
        }
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f36210b.getLayoutParams();
            marginLayoutParams.leftMargin = 0;
            this.f36210b.setLayoutParams(marginLayoutParams);
            this.f36211c.setVisibility(8);
            AdInfo i2 = com.kwad.sdk.core.response.b.c.i(this.f36217i);
            long b2 = com.kwad.sdk.core.response.b.a.b(i2) * 1000;
            long l = com.kwad.sdk.core.response.b.a.l(i2);
            if (!com.kwad.sdk.core.response.b.a.k(i2) && l > 0 && b2 != 0) {
                b2 = Math.min(l, b2);
            }
            String a2 = com.kwad.sdk.core.response.b.b.a(this.f36217i);
            this.k = a2;
            if (an.a(a2)) {
                this.k = m().getString(R.string.ksad_reward_default_tip);
            }
            a(com.kwad.sdk.core.response.b.b.b(this.f36217i));
            a(b2, 0L);
            this.f36213e.setOnClickListener(this);
            this.f36213e.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            com.kwad.sdk.core.report.a.a(this.f36217i, 41, ((com.kwad.sdk.reward.d) this).f36403a.f36079h.getTouchCoords(), ((com.kwad.sdk.reward.d) this).f36403a.f36075d);
            ((com.kwad.sdk.reward.d) this).f36403a.f36073b.a();
        }
    }

    private void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            ((com.kwad.sdk.reward.d) this).f36403a.f36073b.e();
        }
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            com.kwad.sdk.reward.a aVar = ((com.kwad.sdk.reward.d) this).f36403a;
            this.f36217i = aVar.f36077f;
            this.j = aVar.j;
            e();
            ((com.kwad.sdk.reward.d) this).f36403a.f36080i.a(this.l);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.b();
            this.f36211c = (TextView) a(R.id.ksad_video_count_down);
            this.f36210b = (ImageView) a(R.id.ksad_video_sound_switch);
            this.f36212d = (ImageView) a(R.id.ksad_detail_close_btn);
            ViewGroup viewGroup = (ViewGroup) a(R.id.ksad_reward_container_new);
            this.f36213e = viewGroup;
            this.f36214f = (WebpAnimationImageView) viewGroup.findViewById(R.id.ksad_detail_reward_icon_new);
            this.f36215g = (TextView) this.f36213e.findViewById(R.id.ksad_video_count_down_new);
            this.f36216h = (TextView) this.f36213e.findViewById(R.id.ksad_detail_reward_tip_new);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.c();
            ((com.kwad.sdk.reward.d) this).f36403a.f36080i.b(this.l);
            this.f36214f.b();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, view) == null) && view == this.f36213e) {
            com.kwad.sdk.core.download.b.a.a(view.getContext(), this.f36217i, new a.InterfaceC0415a(this) { // from class: com.kwad.sdk.reward.b.b.b.e.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ e f36221a;

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
                    this.f36221a = this;
                }

                @Override // com.kwad.sdk.core.download.b.a.InterfaceC0415a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f36221a.f();
                    }
                }
            }, this.j, false);
        }
    }
}

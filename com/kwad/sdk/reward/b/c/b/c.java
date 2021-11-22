package com.kwad.sdk.reward.b.c.b;

import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
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
import com.kwad.sdk.glide.framesequence.FrameSequence;
import com.kwad.sdk.reward.a.f;
import com.kwad.sdk.reward.d;
import com.kwad.sdk.utils.an;
import com.kwad.sdk.widget.WebpAnimationImageView;
import java.io.InputStream;
/* loaded from: classes2.dex */
public class c extends d implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f67161b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f67162c;

    /* renamed from: d  reason: collision with root package name */
    public WebpAnimationImageView f67163d;

    /* renamed from: e  reason: collision with root package name */
    public WebpAnimationImageView f67164e;

    /* renamed from: f  reason: collision with root package name */
    public f f67165f;

    public c() {
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
        this.f67165f = new f(this) { // from class: com.kwad.sdk.reward.b.c.b.c.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c f67166a;

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
                this.f67166a = this;
            }

            @Override // com.kwad.sdk.reward.a.f
            public void a() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || ((d) this.f67166a).f67255a.t) {
                    return;
                }
                this.f67166a.e();
            }
        };
    }

    private void a(WebpAnimationImageView webpAnimationImageView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, this, webpAnimationImageView, str) == null) {
            if (an.a(str) || !FrameSequence.isEnable()) {
                webpAnimationImageView.setImageResource(R.drawable.ksad_reward_icon_end);
            } else if (str.equals(webpAnimationImageView.getTag())) {
            } else {
                KSImageLoader.loadImage(str, ((d) this).f67255a.f66928f, KSImageLoader.IMGOPTION_ENTRY, new SimpleImageLoadingListener(this, str, webpAnimationImageView) { // from class: com.kwad.sdk.reward.b.c.b.c.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ String f67167a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ WebpAnimationImageView f67168b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ c f67169c;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, str, webpAnimationImageView};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f67169c = this;
                        this.f67167a = str;
                        this.f67168b = webpAnimationImageView;
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
                        if ((interceptable2 == null || interceptable2.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str2, view, decodedResult) == null) && this.f67167a.equals(str2)) {
                            FrameSequence frameSequence = decodedResult.mFrameSequence;
                            if (frameSequence != null) {
                                this.f67168b.setWebpStream(frameSequence);
                                this.f67168b.setTag(str2);
                                this.f67168b.a();
                                return;
                            }
                            Bitmap bitmap = decodedResult.mBitmap;
                            if (bitmap == null || bitmap.isRecycled()) {
                                return;
                            }
                            this.f67168b.setImageBitmap(decodedResult.mBitmap);
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
            if (((d) this).f67255a.r) {
                ImageView imageView = this.f67162c;
                if (imageView != null) {
                    imageView.setVisibility(8);
                }
                String c2 = com.kwad.sdk.core.response.b.b.c(((d) this).f67255a.f66928f);
                if (((d) this).f67255a.f66927e != 1) {
                    WebpAnimationImageView webpAnimationImageView = this.f67164e;
                    if (webpAnimationImageView != null) {
                        a(webpAnimationImageView, c2);
                        this.f67164e.setVisibility(0);
                        this.f67164e.setOnClickListener(this);
                    }
                    ViewGroup viewGroup2 = this.f67161b;
                    if (viewGroup2 != null) {
                        viewGroup2.setVisibility(8);
                        return;
                    }
                    return;
                }
                WebpAnimationImageView webpAnimationImageView2 = this.f67163d;
                if (webpAnimationImageView2 != null) {
                    a(webpAnimationImageView2, c2);
                    this.f67163d.setVisibility(0);
                    this.f67163d.setOnClickListener(this);
                }
                viewGroup = this.f67161b;
                if (viewGroup == null) {
                    return;
                }
            } else {
                WebpAnimationImageView webpAnimationImageView3 = this.f67163d;
                if (webpAnimationImageView3 != null) {
                    webpAnimationImageView3.setVisibility(8);
                }
                WebpAnimationImageView webpAnimationImageView4 = this.f67164e;
                if (webpAnimationImageView4 != null) {
                    webpAnimationImageView4.setVisibility(8);
                }
                ImageView imageView2 = this.f67162c;
                if (imageView2 != null) {
                    imageView2.setVisibility(0);
                    this.f67162c.setOnClickListener(this);
                }
                viewGroup = this.f67161b;
                if (viewGroup == null) {
                    return;
                }
            }
            viewGroup.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
            com.kwad.sdk.reward.a aVar = ((d) this).f67255a;
            com.kwad.sdk.core.report.a.a(aVar.f66928f, 41, aVar.f66930h.getTouchCoords(), ((d) this).f67255a.f66926d);
            ((d) this).f67255a.f66924b.a();
        }
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            ((d) this).f67255a.a(this.f67165f);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.b();
            this.f67161b = (ViewGroup) a(R.id.ksad_end_reward_icon_layout);
            this.f67162c = (ImageView) a(R.id.ksad_end_reward_icon);
            this.f67163d = (WebpAnimationImageView) a(R.id.ksad_end_reward_icon_new_left);
            this.f67164e = (WebpAnimationImageView) a(R.id.ksad_end_reward_icon_new_right);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.c();
            ((d) this).f67255a.b(this.f67165f);
            this.f67163d.b();
            this.f67164e.b();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            if (view == this.f67162c || view == this.f67163d || view == this.f67164e) {
                com.kwad.sdk.core.download.b.a.a(view.getContext(), ((d) this).f67255a.f66928f, new a.InterfaceC1941a(this) { // from class: com.kwad.sdk.reward.b.c.b.c.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ c f67170a;

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
                        this.f67170a = this;
                    }

                    @Override // com.kwad.sdk.core.download.b.a.InterfaceC1941a
                    public void a() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.f67170a.f();
                        }
                    }
                }, ((d) this).f67255a.j, false);
            }
        }
    }
}

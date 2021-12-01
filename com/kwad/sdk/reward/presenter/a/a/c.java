package com.kwad.sdk.reward.presenter.a.a;

import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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
import com.kwad.sdk.glide.framesequence.FrameSequence;
import com.kwad.sdk.reward.a.f;
import com.kwad.sdk.reward.a.h;
import com.kwad.sdk.reward.d;
import com.kwad.sdk.reward.g;
import com.kwad.sdk.utils.at;
import com.kwad.sdk.widget.WebpAnimationImageView;
import java.io.InputStream;
/* loaded from: classes2.dex */
public class c extends g implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f59042b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f59043c;

    /* renamed from: d  reason: collision with root package name */
    public WebpAnimationImageView f59044d;

    /* renamed from: e  reason: collision with root package name */
    public WebpAnimationImageView f59045e;

    /* renamed from: f  reason: collision with root package name */
    public final f f59046f;

    /* renamed from: g  reason: collision with root package name */
    public final h f59047g;

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
        this.f59046f = new f(this) { // from class: com.kwad.sdk.reward.presenter.a.a.c.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

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

            @Override // com.kwad.sdk.reward.a.f
            public void a() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || ((g) this.a).a.x || this.a.f() || this.a.g() || !((g) this.a).a.v) {
                    return;
                }
                this.a.e();
            }
        };
        this.f59047g = new h(this) { // from class: com.kwad.sdk.reward.presenter.a.a.c.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

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

            @Override // com.kwad.sdk.reward.a.h
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.a.e();
                }
            }
        };
    }

    private void a(WebpAnimationImageView webpAnimationImageView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, this, webpAnimationImageView, str) == null) {
            if (at.a(str) || !FrameSequence.isEnable()) {
                webpAnimationImageView.setImageResource(R.drawable.ksad_reward_icon_end);
            } else if (str.equals(webpAnimationImageView.getTag())) {
            } else {
                KSImageLoader.loadImage(str, ((g) this).a.f58874g, KSImageLoader.IMGOPTION_ENTRY, new SimpleImageLoadingListener(this, str, webpAnimationImageView) { // from class: com.kwad.sdk.reward.presenter.a.a.c.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ String a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ WebpAnimationImageView f59048b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ c f59049c;

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
                        this.f59049c = this;
                        this.a = str;
                        this.f59048b = webpAnimationImageView;
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
                            FrameSequence frameSequence = decodedResult.mFrameSequence;
                            if (frameSequence != null) {
                                this.f59048b.setWebpStream(frameSequence);
                                this.f59048b.setTag(str2);
                                this.f59048b.a();
                                return;
                            }
                            Bitmap bitmap = decodedResult.mBitmap;
                            if (bitmap == null || bitmap.isRecycled()) {
                                return;
                            }
                            this.f59048b.setImageBitmap(decodedResult.mBitmap);
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
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            if (((g) this).a.s) {
                ImageView imageView = this.f59043c;
                if (imageView != null) {
                    imageView.setVisibility(8);
                }
                String c2 = com.kwad.sdk.core.response.a.c.c(((g) this).a.f58874g);
                if (((g) this).a.f58873f != 1) {
                    WebpAnimationImageView webpAnimationImageView = this.f59045e;
                    if (webpAnimationImageView != null) {
                        a(webpAnimationImageView, c2);
                        this.f59045e.setVisibility(0);
                        this.f59045e.setOnClickListener(this);
                    }
                    ViewGroup viewGroup2 = this.f59042b;
                    if (viewGroup2 != null) {
                        viewGroup2.setVisibility(8);
                        return;
                    }
                    return;
                }
                WebpAnimationImageView webpAnimationImageView2 = this.f59044d;
                if (webpAnimationImageView2 != null) {
                    a(webpAnimationImageView2, c2);
                    this.f59044d.setVisibility(0);
                    this.f59044d.setOnClickListener(this);
                }
                viewGroup = this.f59042b;
                if (viewGroup == null) {
                    return;
                }
            } else {
                WebpAnimationImageView webpAnimationImageView3 = this.f59044d;
                if (webpAnimationImageView3 != null) {
                    webpAnimationImageView3.setVisibility(8);
                }
                WebpAnimationImageView webpAnimationImageView4 = this.f59045e;
                if (webpAnimationImageView4 != null) {
                    webpAnimationImageView4.setVisibility(8);
                }
                ImageView imageView2 = this.f59043c;
                if (imageView2 != null) {
                    imageView2.setVisibility(0);
                    this.f59043c.setOnClickListener(this);
                }
                viewGroup = this.f59042b;
                if (viewGroup == null) {
                    return;
                }
            }
            viewGroup.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            com.kwad.sdk.reward.a aVar = ((g) this).a;
            com.kwad.sdk.core.report.a.a(aVar.f58874g, 41, aVar.f58877j.getTouchCoords(), ((g) this).a.f58872e);
            ((g) this).a.f58869b.a();
        }
    }

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            d.a().a(this.f59047g);
            ((g) this).a.a(this.f59046f);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.c();
            d.a().b(this.f59047g);
            ((g) this).a.b(this.f59046f);
            this.f59044d.b();
            this.f59045e.b();
            this.f59042b.setVisibility(8);
            this.f59043c.setVisibility(8);
            this.f59044d.setVisibility(8);
            this.f59045e.setVisibility(8);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.c_();
            this.f59042b = (ViewGroup) a(R.id.ksad_end_reward_icon_layout);
            this.f59043c = (ImageView) a(R.id.ksad_end_reward_icon);
            this.f59044d = (WebpAnimationImageView) a(R.id.ksad_end_reward_icon_new_left);
            this.f59045e = (WebpAnimationImageView) a(R.id.ksad_end_reward_icon_new_right);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            if (view == this.f59043c || view == this.f59044d || view == this.f59045e) {
                com.kwad.sdk.core.download.a.a.a(new a.C2015a(view.getContext()).a(((g) this).a.f58874g).a(((g) this).a.l).a(false).a(2).a(new a.b(this) { // from class: com.kwad.sdk.reward.presenter.a.a.c.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ c a;

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
}

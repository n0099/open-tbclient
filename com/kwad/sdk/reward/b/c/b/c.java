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
import com.kwad.sdk.reward.a.e;
import com.kwad.sdk.reward.d;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.widget.AnimatedImageView;
import java.io.InputStream;
/* loaded from: classes7.dex */
public class c extends d implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f39026b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f39027c;

    /* renamed from: d  reason: collision with root package name */
    public AnimatedImageView f39028d;

    /* renamed from: e  reason: collision with root package name */
    public AnimatedImageView f39029e;

    /* renamed from: f  reason: collision with root package name */
    public e f39030f;

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
        this.f39030f = new e(this) { // from class: com.kwad.sdk.reward.b.c.b.c.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c f39031a;

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
                this.f39031a = this;
            }

            @Override // com.kwad.sdk.reward.a.e
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f39031a.e();
                }
            }
        };
    }

    private void a(AnimatedImageView animatedImageView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, this, animatedImageView, str) == null) {
            if (ag.a(str) || !FrameSequence.isEnable()) {
                animatedImageView.setImageResource(R.drawable.ksad_reward_icon_end);
            } else {
                KSImageLoader.loadImage(str, ((d) this).f39062a.f38816f, KSImageLoader.IMGOPTION_ENTRY, new SimpleImageLoadingListener(this, str, animatedImageView) { // from class: com.kwad.sdk.reward.b.c.b.c.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ String f39032a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ AnimatedImageView f39033b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ c f39034c;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, str, animatedImageView};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f39034c = this;
                        this.f39032a = str;
                        this.f39033b = animatedImageView;
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
                        if ((interceptable2 == null || interceptable2.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str2, view, decodedResult) == null) && this.f39032a.equals(str2)) {
                            FrameSequence frameSequence = decodedResult.mFrameSequence;
                            if (frameSequence != null) {
                                this.f39033b.setWebpStream(frameSequence);
                                this.f39033b.a();
                                return;
                            }
                            Bitmap bitmap = decodedResult.mBitmap;
                            if (bitmap == null || bitmap.isRecycled()) {
                                return;
                            }
                            this.f39033b.setImageBitmap(decodedResult.mBitmap);
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65540, this) == null) {
            if (((d) this).f39062a.q) {
                this.f39027c.setVisibility(8);
                String d2 = com.kwad.sdk.core.response.b.b.d(((d) this).f39062a.f38816f);
                if (((d) this).f39062a.f38815e != 1) {
                    a(this.f39029e, d2);
                    this.f39029e.setVisibility(0);
                    this.f39029e.setOnClickListener(this);
                    this.f39026b.setVisibility(8);
                    return;
                }
                a(this.f39028d, d2);
                this.f39028d.setVisibility(0);
                imageView = this.f39028d;
            } else {
                this.f39028d.setVisibility(8);
                this.f39029e.setVisibility(8);
                this.f39027c.setVisibility(0);
                imageView = this.f39027c;
            }
            imageView.setOnClickListener(this);
            this.f39026b.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
            com.kwad.sdk.reward.a aVar = ((d) this).f39062a;
            com.kwad.sdk.core.report.b.a(aVar.f38816f, 41, aVar.f38818h.getTouchCoords(), ((d) this).f39062a.f38814d);
            ((d) this).f39062a.f38812b.a();
        }
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            ((d) this).f39062a.n.add(this.f39030f);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.b_();
            ((d) this).f39062a.n.remove(this.f39030f);
            this.f39028d.b();
            this.f39029e.b();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.c();
            this.f39026b = (ViewGroup) b(R.id.ksad_end_reward_icon_layout);
            this.f39027c = (ImageView) b(R.id.ksad_end_reward_icon);
            this.f39028d = (AnimatedImageView) b(R.id.ksad_end_reward_icon_new_left);
            this.f39029e = (AnimatedImageView) b(R.id.ksad_end_reward_icon_new_right);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            if (view == this.f39027c || view == this.f39028d || view == this.f39029e) {
                com.kwad.sdk.core.download.b.a.a(view.getContext(), ((d) this).f39062a.f38816f, new a.InterfaceC0426a(this) { // from class: com.kwad.sdk.reward.b.c.b.c.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ c f39035a;

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
                        this.f39035a = this;
                    }

                    @Override // com.kwad.sdk.core.download.b.a.InterfaceC0426a
                    public void a() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.f39035a.f();
                        }
                    }
                }, ((d) this).f39062a.j);
            }
        }
    }
}

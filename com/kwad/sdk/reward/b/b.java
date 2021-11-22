package com.kwad.sdk.reward.b;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.detail.video.DetailVideoView;
import com.kwad.sdk.core.imageloader.ImageLoaderProxy;
import com.kwad.sdk.core.imageloader.core.DisplayImageOptions;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener;
import com.kwad.sdk.core.imageloader.utils.BlurUtils;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.jshandler.a;
import com.kwad.sdk.reward.widget.tailframe.TailFrameLandscapeHorizontal;
import com.kwad.sdk.reward.widget.tailframe.TailFrameLandscapeVertical;
import com.kwad.sdk.reward.widget.tailframe.TailFramePortraitHorizontal;
import com.kwad.sdk.reward.widget.tailframe.TailFramePortraitVertical;
import com.kwad.sdk.utils.av;
import com.kwad.sdk.widget.KsLogoView;
import java.io.File;
import java.io.InputStream;
/* loaded from: classes2.dex */
public class b extends com.kwad.sdk.reward.d {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: b  reason: collision with root package name */
    public static String f66949b = "RewardMiddleEndCardPresenter";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public View f66950c;

    /* renamed from: d  reason: collision with root package name */
    public KsLogoView f66951d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f66952e;

    /* renamed from: f  reason: collision with root package name */
    public DetailVideoView f66953f;

    /* renamed from: g  reason: collision with root package name */
    public View f66954g;

    /* renamed from: h  reason: collision with root package name */
    public FrameLayout f66955h;

    /* renamed from: i  reason: collision with root package name */
    public FrameLayout f66956i;
    public com.kwad.sdk.d.b j;
    public Animator k;
    public Animator l;
    public com.kwad.sdk.contentalliance.detail.video.d m;
    public a.b n;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(758072843, "Lcom/kwad/sdk/reward/b/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(758072843, "Lcom/kwad/sdk/reward/b/b;");
        }
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.m = new com.kwad.sdk.contentalliance.detail.video.e(this) { // from class: com.kwad.sdk.reward.b.b.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f66957a;

            /* renamed from: b  reason: collision with root package name */
            public boolean f66958b;

            /* renamed from: c  reason: collision with root package name */
            public int f66959c;

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
                this.f66957a = this;
                this.f66958b = false;
                this.f66959c = -1;
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
            public void a(long j, long j2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
                    if (this.f66959c <= 0) {
                        this.f66959c = com.kwad.sdk.core.response.b.a.N(com.kwad.sdk.core.response.b.c.i(((com.kwad.sdk.reward.d) this.f66957a).f67255a.f66928f));
                    }
                    int i4 = this.f66959c;
                    if (i4 > 0) {
                        int i5 = i4 * 1000;
                        if (this.f66958b || j2 <= i5) {
                            return;
                        }
                        this.f66957a.f();
                        this.f66958b = true;
                    }
                }
            }
        };
        this.n = new a.b(this) { // from class: com.kwad.sdk.reward.b.b.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f66965a;

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
                this.f66965a = this;
            }

            @Override // com.kwad.sdk.core.webview.jshandler.a.b
            public void a(a.C1956a c1956a) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, c1956a) == null) {
                    ((com.kwad.sdk.reward.d) this.f66965a).f67255a.f66924b.a();
                }
            }
        };
    }

    private Animator a(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65538, this, i2, i3)) == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f66950c, "translationY", 0.0f, -i2);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f66951d, "alpha", 0.0f, 255.0f);
            this.f66953f.getWidth();
            ViewGroup.LayoutParams layoutParams = this.f66953f.getLayoutParams();
            ViewGroup.LayoutParams layoutParams2 = this.f66952e.getLayoutParams();
            ValueAnimator ofInt = ValueAnimator.ofInt(this.f66953f.getHeight(), i3);
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this, layoutParams, layoutParams2) { // from class: com.kwad.sdk.reward.b.b.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ ViewGroup.LayoutParams f66961a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ ViewGroup.LayoutParams f66962b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ b f66963c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, layoutParams, layoutParams2};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i4 = newInitContext.flag;
                        if ((i4 & 1) != 0) {
                            int i5 = i4 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f66963c = this;
                    this.f66961a = layoutParams;
                    this.f66962b = layoutParams2;
                }

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator) == null) {
                        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        int i4 = (int) (intValue / 1.7777778f);
                        ViewGroup.LayoutParams layoutParams3 = this.f66961a;
                        if (layoutParams3 != null) {
                            layoutParams3.height = intValue;
                            layoutParams3.width = i4;
                            this.f66963c.f66953f.setLayoutParams(this.f66961a);
                        }
                        ViewGroup.LayoutParams layoutParams4 = this.f66962b;
                        if (layoutParams4 != null) {
                            layoutParams4.height = intValue;
                            this.f66963c.f66952e.setLayoutParams(this.f66962b);
                        }
                    }
                }
            });
            Interpolator create = PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(500L);
            animatorSet.setInterpolator(create);
            animatorSet.playTogether(ofFloat, ofFloat2, ofInt);
            return animatorSet;
        }
        return (Animator) invokeII.objValue;
    }

    private void a(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.f66952e.setVisibility(0);
        ImageLoaderProxy.INSTANCE.load(KsAdSDKImpl.get().getContext(), str, this.f66952e, new DisplayImageOptions.Builder().setBlurRadius(50).build(), new SimpleImageLoadingListener(this) { // from class: com.kwad.sdk.reward.b.b.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f66960a;

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
                this.f66960a = this;
            }

            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public boolean onDecode(String str2, InputStream inputStream, DecodedResult decodedResult) {
                InterceptResult invokeLLL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeLLL = interceptable2.invokeLLL(1048576, this, str2, inputStream, decodedResult)) == null) {
                    decodedResult.mBitmap = BlurUtils.stackBlur(BitmapFactory.decodeStream(inputStream), 50, false);
                    return true;
                }
                return invokeLLL.booleanValue;
            }

            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public void onLoadingComplete(String str2, View view, DecodedResult decodedResult) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str2, view, decodedResult) == null) {
                }
            }
        });
    }

    private void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(AdIconUtil.AD_TEXT_ID, this, z) == null) {
            FrameLayout frameLayout = this.f66956i;
            if (frameLayout != null) {
                frameLayout.setVisibility(z ? 8 : 0);
            }
            FrameLayout frameLayout2 = this.f66955h;
            if (frameLayout2 != null) {
                frameLayout2.setVisibility(z ? 0 : 8);
            }
        }
    }

    private boolean a(AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, adInfo)) == null) {
            AdInfo.AdMaterialInfo.MaterialFeature C = com.kwad.sdk.core.response.b.a.C(adInfo);
            return C.height > C.width;
        }
        return invokeL.booleanValue;
    }

    private int b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65543, this, i2)) == null) ? (int) ((av.c(k()) - i2) + m().getResources().getDimensionPixelOffset(R.dimen.ksad_reward_middle_end_card_logo_view_height) + m().getResources().getDimensionPixelOffset(R.dimen.ksad_reward_middle_end_card_logo_view_margin_bottom)) : invokeI.intValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            boolean d2 = this.j.d();
            a(d2);
            if (!d2) {
                View p = p();
                this.f66956i.removeAllViews();
                this.f66956i.addView(p);
            }
            int o = o();
            int b2 = b(o);
            Animator a2 = a(b2, o);
            this.k = a2;
            a2.start();
            Animator n = n();
            this.l = n;
            n.start();
            ViewGroup.LayoutParams layoutParams = this.f66950c.getLayoutParams();
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                layoutParams2.height = b2;
                layoutParams2.bottomMargin = -b2;
            } else {
                FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, b2);
                layoutParams3.height = b2;
                layoutParams3.bottomMargin = -b2;
                this.f66950c.setLayoutParams(layoutParams3);
            }
            ((com.kwad.sdk.reward.d) this).f67255a.u = true;
        }
    }

    private Animator n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, this)) == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f66954g, "alpha", 255.0f, 0.0f);
            ofFloat.setInterpolator(PathInterpolatorCompat.create(0.25f, 0.1f, 0.25f, 1.0f));
            ofFloat.setDuration(200L);
            return ofFloat;
        }
        return (Animator) invokeV.objValue;
    }

    private int o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65551, this)) == null) ? (int) ((av.b(k()) * 9.0f) / 16.0f) : invokeV.intValue;
    }

    private View p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65552, this)) == null) {
            AdInfo i2 = com.kwad.sdk.core.response.b.c.i(((com.kwad.sdk.reward.d) this).f67255a.f66928f);
            Context context = this.f66950c.getContext();
            int i3 = ((com.kwad.sdk.reward.d) this).f67255a.f66927e;
            boolean a2 = a(i2);
            com.kwad.sdk.reward.widget.tailframe.a tailFramePortraitVertical = i3 == 0 ? a2 ? new TailFramePortraitVertical(context) : new TailFramePortraitHorizontal(context) : a2 ? new TailFrameLandscapeVertical(context) : new TailFrameLandscapeHorizontal(context);
            com.kwad.sdk.reward.a aVar = ((com.kwad.sdk.reward.d) this).f67255a;
            tailFramePortraitVertical.a(aVar.f66928f, aVar.f66926d, new com.kwad.sdk.reward.widget.tailframe.b(this) { // from class: com.kwad.sdk.reward.b.b.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ b f66964a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i4 = newInitContext.flag;
                        if ((i4 & 1) != 0) {
                            int i5 = i4 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f66964a = this;
                }

                @Override // com.kwad.sdk.reward.widget.tailframe.b
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f66964a.q();
                    }
                }
            });
            return tailFramePortraitVertical.a();
        }
        return (View) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, this) == null) {
            com.kwad.sdk.reward.a aVar = ((com.kwad.sdk.reward.d) this).f67255a;
            com.kwad.sdk.core.report.a.a(aVar.f66928f, 2, aVar.f66930h.getTouchCoords(), ((com.kwad.sdk.reward.d) this).f67255a.f66926d);
            ((com.kwad.sdk.reward.d) this).f67255a.f66924b.a();
        }
    }

    public String a(AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, adTemplate)) == null) ? com.kwad.sdk.core.response.b.a.y(com.kwad.sdk.core.response.b.c.i(adTemplate)) : (String) invokeL.objValue;
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        com.kwad.sdk.d.b bVar;
        String e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.a();
            ((com.kwad.sdk.reward.d) this).f67255a.f66931i.a(this.m);
            com.kwad.sdk.reward.a aVar = ((com.kwad.sdk.reward.d) this).f67255a;
            com.kwad.sdk.d.b bVar2 = aVar.n;
            this.j = bVar2;
            if (bVar2 != null) {
                AdTemplate adTemplate = aVar.f66928f;
                boolean r = com.kwad.sdk.core.response.b.c.r(adTemplate);
                this.j.a(r);
                if (r) {
                    bVar = this.j;
                    e2 = a(adTemplate);
                } else {
                    bVar = this.j;
                    e2 = e();
                }
                bVar.a(e2);
                this.j.a(this.n);
                com.kwad.sdk.d.b bVar3 = this.j;
                FrameLayout frameLayout = this.f66955h;
                com.kwad.sdk.reward.a aVar2 = ((com.kwad.sdk.reward.d) this).f67255a;
                bVar3.a(frameLayout, aVar2.f66930h, adTemplate, aVar2.j, aVar2.f66927e);
                this.j.a(((com.kwad.sdk.reward.d) this).f67255a.f66929g);
                this.j.c();
                if (adTemplate.adInfoList.size() > 0) {
                    a(com.kwad.sdk.core.response.b.a.f(adTemplate.adInfoList.get(0)));
                }
            }
            this.f66951d.a(((com.kwad.sdk.reward.d) this).f67255a.f66928f);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.b();
            this.f66950c = a(R.id.ksad_middle_end_card);
            this.f66953f = (DetailVideoView) a(R.id.ksad_video_player);
            this.f66951d = (KsLogoView) a(R.id.ksad_splash_logo_container);
            this.f66952e = (ImageView) a(R.id.ksad_blur_video_cover);
            this.f66954g = a(R.id.ksad_play_web_card_webView);
            this.f66955h = (FrameLayout) a(R.id.ksad_middle_end_card_webview_container);
            this.f66956i = (FrameLayout) a(R.id.ksad_middle_end_card_native);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.c();
            ((com.kwad.sdk.reward.d) this).f67255a.f66931i.b(this.m);
            com.kwad.sdk.d.b bVar = this.j;
            if (bVar != null) {
                bVar.g();
            }
            Animator animator = this.l;
            if (animator != null) {
                animator.cancel();
            }
            Animator animator2 = this.k;
            if (animator2 != null) {
                animator2.cancel();
            }
            this.l = null;
            this.k = null;
        }
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (m() != null) {
                File h2 = com.kwad.sdk.core.config.c.h(m());
                if (h2.exists()) {
                    return Uri.fromFile(h2).toString();
                }
                if (com.kwad.sdk.core.config.c.u() != null) {
                    return com.kwad.sdk.core.config.c.u().h5Url;
                }
                return null;
            }
            return null;
        }
        return (String) invokeV.objValue;
    }
}

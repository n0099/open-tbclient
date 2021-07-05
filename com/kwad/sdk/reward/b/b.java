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
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.detail.video.DetailVideoView;
import com.kwad.sdk.contentalliance.detail.video.f;
import com.kwad.sdk.core.imageloader.core.ImageLoader;
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
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.widget.KsLogoView;
import java.io.File;
import java.io.InputStream;
/* loaded from: classes7.dex */
public class b extends com.kwad.sdk.reward.d {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: b  reason: collision with root package name */
    public static String f38832b = "RewardMiddleEndCardPresenter";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public View f38833c;

    /* renamed from: d  reason: collision with root package name */
    public KsLogoView f38834d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f38835e;

    /* renamed from: f  reason: collision with root package name */
    public DetailVideoView f38836f;

    /* renamed from: g  reason: collision with root package name */
    public View f38837g;

    /* renamed from: h  reason: collision with root package name */
    public FrameLayout f38838h;

    /* renamed from: i  reason: collision with root package name */
    public FrameLayout f38839i;
    public com.kwad.sdk.c.b j;
    public Animator k;
    public Animator l;
    public com.kwad.sdk.contentalliance.detail.video.e m;
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
        this.m = new f(this) { // from class: com.kwad.sdk.reward.b.b.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f38840a;

            /* renamed from: b  reason: collision with root package name */
            public boolean f38841b;

            /* renamed from: c  reason: collision with root package name */
            public int f38842c;

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
                this.f38840a = this;
                this.f38841b = false;
                this.f38842c = -1;
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
            public void a(long j, long j2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
                    if (this.f38842c <= 0) {
                        this.f38842c = com.kwad.sdk.core.config.c.W();
                    }
                    int i4 = this.f38842c;
                    if (i4 > 0) {
                        int i5 = i4 * 1000;
                        if (this.f38841b || j2 <= i5) {
                            return;
                        }
                        this.f38840a.f();
                        this.f38841b = true;
                    }
                }
            }
        };
        this.n = new a.b(this) { // from class: com.kwad.sdk.reward.b.b.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f38848a;

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
                this.f38848a = this;
            }

            @Override // com.kwad.sdk.core.webview.jshandler.a.b
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    ((com.kwad.sdk.reward.d) this.f38848a).f39062a.f38812b.a();
                }
            }
        };
    }

    private int a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65538, this, i2)) == null) ? (int) ((ao.d(m()) - i2) + o().getResources().getDimensionPixelOffset(R.dimen.ksad_reward_middle_end_card_logo_view_height) + o().getResources().getDimensionPixelOffset(R.dimen.ksad_reward_middle_end_card_logo_view_margin_bottom)) : invokeI.intValue;
    }

    private Animator a(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65539, this, i2, i3)) == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f38833c, "translationY", 0.0f, -i2);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f38834d, "alpha", 0.0f, 255.0f);
            this.f38836f.getWidth();
            ViewGroup.LayoutParams layoutParams = this.f38836f.getLayoutParams();
            ViewGroup.LayoutParams layoutParams2 = this.f38835e.getLayoutParams();
            ValueAnimator ofInt = ValueAnimator.ofInt(this.f38836f.getHeight(), i3);
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this, layoutParams, layoutParams2) { // from class: com.kwad.sdk.reward.b.b.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ ViewGroup.LayoutParams f38844a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ ViewGroup.LayoutParams f38845b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ b f38846c;

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
                    this.f38846c = this;
                    this.f38844a = layoutParams;
                    this.f38845b = layoutParams2;
                }

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator) == null) {
                        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        int i4 = (int) (intValue / 1.7777778f);
                        ViewGroup.LayoutParams layoutParams3 = this.f38844a;
                        if (layoutParams3 != null) {
                            layoutParams3.height = intValue;
                            layoutParams3.width = i4;
                            this.f38846c.f38836f.setLayoutParams(this.f38844a);
                        }
                        ViewGroup.LayoutParams layoutParams4 = this.f38845b;
                        if (layoutParams4 != null) {
                            layoutParams4.height = intValue;
                            this.f38846c.f38835e.setLayoutParams(this.f38845b);
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
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.f38835e.setVisibility(0);
        ImageLoader.getInstance().displayImage(str, this.f38835e, new SimpleImageLoadingListener(this) { // from class: com.kwad.sdk.reward.b.b.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f38843a;

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
                this.f38843a = this;
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
        if (interceptable == null || interceptable.invokeZ(AdIconUtil.BAIDU_LOGO_ID, this, z) == null) {
            FrameLayout frameLayout = this.f38839i;
            if (frameLayout != null) {
                frameLayout.setVisibility(z ? 8 : 0);
            }
            FrameLayout frameLayout2 = this.f38838h;
            if (frameLayout2 != null) {
                frameLayout2.setVisibility(z ? 0 : 8);
            }
        }
    }

    private boolean a(AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, this, adInfo)) == null) {
            AdInfo.AdMaterialInfo.MaterialFeature E = com.kwad.sdk.core.response.b.a.E(adInfo);
            return E.height > E.width;
        }
        return invokeL.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            boolean d2 = this.j.d();
            a(d2);
            if (!d2) {
                View p = p();
                this.f38839i.removeAllViews();
                this.f38839i.addView(p);
            }
            int h2 = h();
            int a2 = a(h2);
            Animator a3 = a(a2, h2);
            this.k = a3;
            a3.start();
            Animator g2 = g();
            this.l = g2;
            g2.start();
            ViewGroup.LayoutParams layoutParams = this.f38833c.getLayoutParams();
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                layoutParams2.height = a2;
                layoutParams2.bottomMargin = -a2;
                return;
            }
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, a2);
            layoutParams3.height = a2;
            layoutParams3.bottomMargin = -a2;
            this.f38833c.setLayoutParams(layoutParams3);
        }
    }

    private Animator g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, this)) == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f38837g, "alpha", 255.0f, 0.0f);
            ofFloat.setInterpolator(PathInterpolatorCompat.create(0.25f, 0.1f, 0.25f, 1.0f));
            ofFloat.setDuration(200L);
            return ofFloat;
        }
        return (Animator) invokeV.objValue;
    }

    private int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65550, this)) == null) ? (int) ((ao.c(m()) * 9.0f) / 16.0f) : invokeV.intValue;
    }

    private View p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, this)) == null) {
            AdInfo j = com.kwad.sdk.core.response.b.c.j(((com.kwad.sdk.reward.d) this).f39062a.f38816f);
            Context context = this.f38833c.getContext();
            int i2 = ((com.kwad.sdk.reward.d) this).f39062a.f38815e;
            boolean a2 = a(j);
            com.kwad.sdk.reward.widget.tailframe.a tailFramePortraitVertical = i2 == 0 ? a2 ? new TailFramePortraitVertical(context) : new TailFramePortraitHorizontal(context) : a2 ? new TailFrameLandscapeVertical(context) : new TailFrameLandscapeHorizontal(context);
            com.kwad.sdk.reward.a aVar = ((com.kwad.sdk.reward.d) this).f39062a;
            tailFramePortraitVertical.a(aVar.f38816f, aVar.f38814d, new com.kwad.sdk.reward.widget.tailframe.b(this) { // from class: com.kwad.sdk.reward.b.b.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ b f38847a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f38847a = this;
                }

                @Override // com.kwad.sdk.reward.widget.tailframe.b
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f38847a.q();
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
        if (interceptable == null || interceptable.invokeV(65552, this) == null) {
            com.kwad.sdk.reward.a aVar = ((com.kwad.sdk.reward.d) this).f39062a;
            com.kwad.sdk.core.report.b.a(aVar.f38816f, 2, aVar.f38818h.getTouchCoords(), ((com.kwad.sdk.reward.d) this).f39062a.f38814d);
            ((com.kwad.sdk.reward.d) this).f39062a.f38812b.a();
        }
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            ((com.kwad.sdk.reward.d) this).f39062a.f38819i.a(this.m);
            com.kwad.sdk.c.b bVar = ((com.kwad.sdk.reward.d) this).f39062a.m;
            this.j = bVar;
            if (bVar != null) {
                bVar.a(e());
                AdTemplate adTemplate = ((com.kwad.sdk.reward.d) this).f39062a.f38816f;
                this.j.a(this.n);
                com.kwad.sdk.c.b bVar2 = this.j;
                FrameLayout frameLayout = this.f38838h;
                com.kwad.sdk.reward.a aVar = ((com.kwad.sdk.reward.d) this).f39062a;
                bVar2.a(frameLayout, aVar.f38818h, adTemplate, aVar.j, aVar.f38815e);
                this.j.a(((com.kwad.sdk.reward.d) this).f39062a.f38817g);
                this.j.g();
                if (adTemplate.adInfoList.size() > 0) {
                    a(com.kwad.sdk.core.response.b.a.f(adTemplate.adInfoList.get(0)));
                }
            }
            this.f38834d.a(((com.kwad.sdk.reward.d) this).f39062a.f38816f);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.b_();
            ((com.kwad.sdk.reward.d) this).f39062a.f38819i.b(this.m);
            com.kwad.sdk.c.b bVar = this.j;
            if (bVar != null) {
                bVar.i();
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

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.c();
            this.f38833c = b(R.id.ksad_middle_end_card);
            this.f38836f = (DetailVideoView) b(R.id.ksad_video_player);
            this.f38834d = (KsLogoView) b(R.id.ksad_splash_logo_container);
            this.f38835e = (ImageView) b(R.id.ksad_blur_video_cover);
            this.f38837g = b(R.id.ksad_play_web_card_webView);
            this.f38838h = (FrameLayout) b(R.id.ksad_middle_end_card_webview_container);
            this.f38839i = (FrameLayout) b(R.id.ksad_middle_end_card_native);
        }
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (o() != null) {
                File f2 = com.kwad.sdk.core.config.c.f(o());
                if (f2.exists()) {
                    return Uri.fromFile(f2).toString();
                }
                if (com.kwad.sdk.core.config.c.M() != null) {
                    return com.kwad.sdk.core.config.c.M().h5Url;
                }
                return null;
            }
            return null;
        }
        return (String) invokeV.objValue;
    }
}

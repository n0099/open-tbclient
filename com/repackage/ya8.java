package com.repackage;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.widget.AdImageView;
import com.baidu.nadcore.widget.NadDragView;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.elementsMaven.Direction;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.widget.ApkDownloadView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.sk5;
import java.util.HashMap;
import tbclient.VideoInfo;
/* loaded from: classes7.dex */
public class ya8 extends xa8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RelativeLayout f;
    public AdImageView g;
    public TBSpecificationBtn h;
    public TextView i;
    public TextView j;
    public TextView k;
    public boolean l;
    public NadDragView m;
    public DragImageView.h n;
    public RelativeLayout o;
    public RelativeLayout p;
    public ImageView q;
    public FrameLayout r;
    public View s;
    public TBLottieAnimationView t;
    public Runnable u;
    public ApkDownloadView v;
    public VideoInfo w;
    public final View.OnClickListener x;

    /* loaded from: classes7.dex */
    public class a implements View.OnAttachStateChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ya8 a;

        public a(ya8 ya8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ya8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ya8Var;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.t.resumeAnimation();
                this.a.t.playAnimation();
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
                this.a.t.cancelAnimation();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ya8 a;

        public b(ya8 ya8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ya8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ya8Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            ya8 ya8Var;
            FrameLayout frameLayout;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (frameLayout = (ya8Var = this.a).r) == null || ya8Var.t == null || frameLayout.getVisibility() != 0) {
                return;
            }
            this.a.t.cancelAnimation();
            this.a.r.setVisibility(8);
        }
    }

    /* loaded from: classes7.dex */
    public class c implements NadDragView.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ya8 a;

        public c(ya8 ya8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ya8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ya8Var;
        }

        @Override // com.baidu.nadcore.widget.NadDragView.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.n != null) {
                    this.a.n.a();
                }
                this.a.i.setVisibility(8);
                this.a.j.setVisibility(8);
                this.a.k.setVisibility(8);
                this.a.o.setVisibility(8);
                this.a.q.setVisibility(8);
                this.a.h.setVisibility(8);
                this.a.v.setVisibility(8);
            }
        }

        @Override // com.baidu.nadcore.widget.NadDragView.a
        public void b() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.a.n == null) {
                return;
            }
            this.a.n.b();
        }

        @Override // com.baidu.nadcore.widget.NadDragView.a
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                if (this.a.n != null) {
                    this.a.n.c();
                }
                this.a.i.setVisibility(0);
                this.a.j.setVisibility(0);
                this.a.k.setVisibility(0);
                this.a.o.setVisibility(0);
                ya8 ya8Var = this.a;
                AdvertAppInfo advertAppInfo = ya8Var.b;
                if (advertAppInfo != null) {
                    ya8Var.q.setVisibility(advertAppInfo.o() ? 0 : 8);
                    if (this.a.b.k()) {
                        this.a.h.setVisibility(0);
                    } else {
                        this.a.v.setVisibility(0);
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ya8 a;

        public d(ya8 ya8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ya8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ya8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            int u;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                ya8 ya8Var = this.a;
                if (ya8Var.b == null || ya8Var.a == null || ya8Var.l) {
                    return;
                }
                HashMap<String, Object> hashMap = new HashMap<>();
                if (view2.getId() == R.id.obfuscated_res_0x7f090e35) {
                    u = this.a.t(view2);
                    str = NativeConstants.ID_BUTTON;
                } else if (view2.getId() == R.id.obfuscated_res_0x7f0903bd) {
                    u = this.a.s();
                    str = "title";
                } else {
                    u = this.a.u();
                    str = this.a.b.i() ? "image" : "video";
                }
                hashMap.put("da_area", str);
                this.a.e.a(u, hashMap);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements sk5.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ya8 a;

        public e(ya8 ya8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ya8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ya8Var;
        }

        @Override // com.repackage.sk5.a
        public boolean a(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                hk5.a(this.a.a.getButtonCmdScheme());
                bd7.c(this.a.b);
                ya8 ya8Var = this.a;
                if (ya8Var.c != null && t98.g(ya8Var.a.getScheme()) && t98.i(this.a.b.p)) {
                    ya8 ya8Var2 = this.a;
                    Context context = ya8Var2.c;
                    String scheme = ya8Var2.a.getScheme();
                    String downloadId = this.a.b.getDownloadId();
                    ya8 ya8Var3 = this.a;
                    t98.a(context, scheme, downloadId, ya8Var3.b.g, ya8Var3.a.cmdScheme);
                    return true;
                } else if (this.a.c == null || di5.a().f() || sh8.a((Activity) this.a.c)) {
                    return false;
                } else {
                    pi.N((Activity) this.a.c, R.string.obfuscated_res_0x7f0f15d5);
                    return false;
                }
            }
            return invokeL.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ya8(TbPageContext tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = false;
        this.u = null;
        this.x = new d(this);
    }

    public void A() {
        FrameLayout frameLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (frameLayout = this.r) == null || this.t == null) {
            return;
        }
        frameLayout.setVisibility(0);
        this.t.playAnimation();
        q();
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.u == null) {
            return;
        }
        qg.a().removeCallbacks(this.u);
    }

    public void C(DragImageView.h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, hVar) == null) {
            this.n = hVar;
        }
    }

    public void D(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onClickListener) == null) {
            TBSpecificationBtn tBSpecificationBtn = this.h;
            if (tBSpecificationBtn != null) {
                tBSpecificationBtn.setOnClickListener(onClickListener);
            }
            AdImageView adImageView = this.g;
            if (adImageView != null) {
                adImageView.setOnClickListener(onClickListener);
            }
            RelativeLayout relativeLayout = this.p;
            if (relativeLayout != null) {
                relativeLayout.setOnClickListener(onClickListener);
            }
            ImageView imageView = this.q;
            if (imageView != null) {
                imageView.setOnClickListener(onClickListener);
            }
        }
    }

    @Override // com.repackage.xa8
    public void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.d == null) {
            return;
        }
        this.f = (RelativeLayout) LayoutInflater.from(this.c).inflate(R.layout.obfuscated_res_0x7f0d0069, (ViewGroup) null);
        AdImageView adImageView = new AdImageView(this.c);
        this.g = adImageView;
        adImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        this.g.setLayoutParams(layoutParams);
        this.g.setAdjustViewBounds(true);
        NadDragView nadDragView = (NadDragView) this.f.findViewById(R.id.obfuscated_res_0x7f090807);
        this.m = nadDragView;
        nadDragView.setDragView(this.g);
        this.h = (TBSpecificationBtn) this.f.findViewById(R.id.obfuscated_res_0x7f090e35);
        uu4 uu4Var = new uu4();
        uu4Var.p(R.color.CAM_X0302, R.color.CAM_X0101);
        this.h.setConfig(uu4Var);
        this.h.setTextHorizontalCenter(true);
        this.i = (TextView) this.f.findViewById(R.id.obfuscated_res_0x7f0900f0);
        this.j = (TextView) this.f.findViewById(R.id.obfuscated_res_0x7f090091);
        this.k = (TextView) this.f.findViewById(R.id.obfuscated_res_0x7f0900e8);
        this.o = (RelativeLayout) this.f.findViewById(R.id.obfuscated_res_0x7f0900ae);
        this.p = (RelativeLayout) this.f.findViewById(R.id.obfuscated_res_0x7f0903bd);
        ImageView imageView = (ImageView) this.f.findViewById(R.id.obfuscated_res_0x7f092378);
        this.q = imageView;
        imageView.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_video_play44, SkinManager.getColor(R.color.CAM_X0101), null));
        this.r = (FrameLayout) this.f.findViewById(R.id.obfuscated_res_0x7f0900cd);
        View findViewById = this.f.findViewById(R.id.obfuscated_res_0x7f0900e0);
        this.s = findViewById;
        ur4.d(findViewById).p(new int[]{R.color.black_alpha40, R.color.black_alpha0}, Direction.RIGHT);
        TBLottieAnimationView tBLottieAnimationView = (TBLottieAnimationView) this.f.findViewById(R.id.obfuscated_res_0x7f0900ce);
        this.t = tBLottieAnimationView;
        SkinManager.setLottieAnimation(tBLottieAnimationView, R.raw.obfuscated_res_0x7f110000);
        this.t.setRepeatCount(3);
        this.t.addOnAttachStateChangeListener(new a(this));
        ApkDownloadView apkDownloadView = (ApkDownloadView) this.f.findViewById(R.id.obfuscated_res_0x7f090e3a);
        this.v = apkDownloadView;
        apkDownloadView.setTextSize(R.dimen.tbds39);
        this.v.setTextColorInitSkin(R.color.CAM_X0101);
        this.v.setBackgroundSkin(R.drawable.obfuscated_res_0x7f080edf);
        this.v.c();
        D(this.x);
    }

    @Override // com.repackage.xa8
    public void c(AdCard adCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, adCard) == null) {
            super.c(adCard);
            if (adCard == null) {
                return;
            }
            p();
            this.w = this.a.videoInfo;
            z();
            x(this.b, this.a);
            if (!TextUtils.isEmpty(this.b.l)) {
                this.j.setText(this.b.l);
                this.k.setText(this.c.getString(R.string.obfuscated_res_0x7f0f00dd));
            }
            if (!TextUtils.isEmpty(adCard.threadTitle)) {
                this.i.setText(adCard.threadTitle);
            }
            this.q.setVisibility(this.b.o() ? 0 : 8);
            D(this.x);
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.m.setDragToExitListener(new c(this));
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.u = new b(this);
            qg.a().postDelayed(this.u, 10000L);
        }
    }

    public View r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f : (View) invokeV.objValue;
    }

    public final int s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? y() : invokeV.intValue;
    }

    public final int t(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, view2)) == null) ? y() : invokeL.intValue;
    }

    public final int u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (this.b.i()) {
                return y();
            }
            return v();
        }
        return invokeV.intValue;
    }

    public final int v() {
        InterceptResult invokeV;
        AdCard adCard;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (this.b == null || (adCard = this.a) == null || this.w == null) {
                return 0;
            }
            return t98.c(this.c, adCard.getScheme(), this.b, this.a.playCmdScheme);
        }
        return invokeV.intValue;
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            TBLottieAnimationView tBLottieAnimationView = this.t;
            if (tBLottieAnimationView != null) {
                tBLottieAnimationView.cancelAnimation();
            }
            FrameLayout frameLayout = this.r;
            if (frameLayout != null) {
                frameLayout.setVisibility(8);
            }
        }
    }

    public void x(AdvertAppInfo advertAppInfo, AdCard adCard) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048590, this, advertAppInfo, adCard) == null) || advertAppInfo == null || adCard == null) {
            return;
        }
        this.b = advertAppInfo;
        this.a = adCard;
        if (advertAppInfo.k()) {
            this.h.setText(adCard.getButtonText());
            this.v.setVisibility(8);
            this.h.setVisibility(0);
            return;
        }
        this.v.setClickable(true);
        this.v.setInitText(adCard.getButtonText());
        this.v.setOnClickInterceptListener(new e(this));
        this.v.setVisibility(0);
        this.h.setVisibility(8);
        new rk5(this.v, wa8.d(adCard));
    }

    public final int y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? t98.a(this.c, this.a.getScheme(), this.a.getDownloadId(), this.b.g, this.a.cmdScheme) : invokeV.intValue;
    }

    public final void z() {
        String picUrl;
        VideoInfo videoInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            if (this.b.o() && (videoInfo = this.w) != null) {
                picUrl = videoInfo.thumbnail_url;
            } else {
                picUrl = this.a.getPicUrl();
            }
            this.g.g(picUrl);
        }
    }
}

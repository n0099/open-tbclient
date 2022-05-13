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
import com.repackage.yj5;
import java.util.HashMap;
import tbclient.VideoInfo;
/* loaded from: classes6.dex */
public class pb8 extends ob8 {
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

    /* loaded from: classes6.dex */
    public class a implements View.OnAttachStateChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pb8 a;

        public a(pb8 pb8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pb8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pb8Var;
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

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pb8 a;

        public b(pb8 pb8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pb8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pb8Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            pb8 pb8Var;
            FrameLayout frameLayout;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (frameLayout = (pb8Var = this.a).r) == null || pb8Var.t == null || frameLayout.getVisibility() != 0) {
                return;
            }
            this.a.t.cancelAnimation();
            this.a.r.setVisibility(8);
        }
    }

    /* loaded from: classes6.dex */
    public class c implements NadDragView.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pb8 a;

        public c(pb8 pb8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pb8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pb8Var;
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
                pb8 pb8Var = this.a;
                AdvertAppInfo advertAppInfo = pb8Var.b;
                if (advertAppInfo != null) {
                    pb8Var.q.setVisibility(advertAppInfo.r() ? 0 : 8);
                    if (this.a.b.m()) {
                        this.a.h.setVisibility(0);
                    } else {
                        this.a.v.setVisibility(0);
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pb8 a;

        public d(pb8 pb8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pb8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pb8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            int u;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                pb8 pb8Var = this.a;
                if (pb8Var.b == null || pb8Var.a == null || pb8Var.l) {
                    return;
                }
                HashMap<String, Object> hashMap = new HashMap<>();
                if (view2.getId() == R.id.obfuscated_res_0x7f090e71) {
                    u = this.a.t(view2);
                    str = NativeConstants.ID_BUTTON;
                } else if (view2.getId() == R.id.obfuscated_res_0x7f0903bf) {
                    u = this.a.s();
                    str = "title";
                } else {
                    u = this.a.u();
                    str = this.a.b.k() ? "image" : "video";
                }
                hashMap.put("da_area", str);
                this.a.e.a(u, hashMap);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements yj5.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pb8 a;

        public e(pb8 pb8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pb8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pb8Var;
        }

        @Override // com.repackage.yj5.a
        public boolean a(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                nj5.a(this.a.a.getButtonCmdScheme());
                kd7.c(this.a.b);
                pb8 pb8Var = this.a;
                if (pb8Var.c != null && ka8.g(pb8Var.a.getScheme()) && ka8.i(this.a.b.p)) {
                    pb8 pb8Var2 = this.a;
                    Context context = pb8Var2.c;
                    String scheme = pb8Var2.a.getScheme();
                    String downloadId = this.a.b.getDownloadId();
                    pb8 pb8Var3 = this.a;
                    ka8.a(context, scheme, downloadId, pb8Var3.b.g, pb8Var3.a.cmdScheme);
                    return true;
                } else if (this.a.c == null || kh5.a().f() || dj8.a((Activity) this.a.c)) {
                    return false;
                } else {
                    mi.M((Activity) this.a.c, R.string.obfuscated_res_0x7f0f15b1);
                    return false;
                }
            }
            return invokeL.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public pb8(TbPageContext tbPageContext) {
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
        ng.a().removeCallbacks(this.u);
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

    @Override // com.repackage.ob8
    public void c() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.d == null) {
            return;
        }
        this.f = (RelativeLayout) LayoutInflater.from(this.c).inflate(R.layout.obfuscated_res_0x7f0d006e, (ViewGroup) null);
        AdImageView adImageView = new AdImageView(this.c);
        this.g = adImageView;
        adImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        this.g.setLayoutParams(layoutParams);
        this.g.setAdjustViewBounds(true);
        NadDragView nadDragView = (NadDragView) this.f.findViewById(R.id.obfuscated_res_0x7f090831);
        this.m = nadDragView;
        nadDragView.setDragView(this.g);
        this.h = (TBSpecificationBtn) this.f.findViewById(R.id.obfuscated_res_0x7f090e71);
        yu4 yu4Var = new yu4();
        yu4Var.p(R.color.CAM_X0302, R.color.CAM_X0101);
        this.h.setConfig(yu4Var);
        this.h.setTextHorizontalCenter(true);
        this.i = (TextView) this.f.findViewById(R.id.obfuscated_res_0x7f0900f0);
        this.j = (TextView) this.f.findViewById(R.id.obfuscated_res_0x7f090092);
        this.k = (TextView) this.f.findViewById(R.id.obfuscated_res_0x7f0900e8);
        this.o = (RelativeLayout) this.f.findViewById(R.id.obfuscated_res_0x7f0900ae);
        this.p = (RelativeLayout) this.f.findViewById(R.id.obfuscated_res_0x7f0903bf);
        ImageView imageView = (ImageView) this.f.findViewById(R.id.obfuscated_res_0x7f09233e);
        this.q = imageView;
        imageView.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_video_play44, SkinManager.getColor(R.color.CAM_X0101), null));
        this.r = (FrameLayout) this.f.findViewById(R.id.obfuscated_res_0x7f0900cd);
        View findViewById = this.f.findViewById(R.id.obfuscated_res_0x7f0900e0);
        this.s = findViewById;
        gs4.d(findViewById).p(new int[]{R.color.black_alpha40, R.color.black_alpha0}, Direction.RIGHT);
        TBLottieAnimationView tBLottieAnimationView = (TBLottieAnimationView) this.f.findViewById(R.id.obfuscated_res_0x7f0900ce);
        this.t = tBLottieAnimationView;
        SkinManager.setLottieAnimation(tBLottieAnimationView, R.raw.obfuscated_res_0x7f110000);
        this.t.setRepeatCount(3);
        this.t.addOnAttachStateChangeListener(new a(this));
        ApkDownloadView apkDownloadView = (ApkDownloadView) this.f.findViewById(R.id.obfuscated_res_0x7f090e76);
        this.v = apkDownloadView;
        apkDownloadView.setTextSize(R.dimen.tbds39);
        this.v.setTextColorInitSkin(R.color.CAM_X0101);
        this.v.setBackgroundSkin(R.drawable.obfuscated_res_0x7f080f5d);
        this.v.c();
        D(this.x);
    }

    @Override // com.repackage.ob8
    public void d(AdCard adCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, adCard) == null) {
            super.d(adCard);
            if (adCard == null) {
                return;
            }
            p();
            this.w = this.a.videoInfo;
            z();
            x(this.b, this.a);
            if (!TextUtils.isEmpty(this.b.l)) {
                this.j.setText(this.b.l);
                this.k.setText(this.c.getString(R.string.obfuscated_res_0x7f0f00dc));
            }
            if (!TextUtils.isEmpty(adCard.threadTitle)) {
                this.i.setText(adCard.threadTitle);
            }
            this.q.setVisibility(this.b.r() ? 0 : 8);
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
            ng.a().postDelayed(this.u, 10000L);
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
            if (this.b.k()) {
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
            return ka8.c(this.c, adCard.getScheme(), this.b, this.a.playCmdScheme);
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
        if (advertAppInfo.m()) {
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
        new xj5(this.v, nb8.d(adCard));
    }

    public final int y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? ka8.a(this.c, this.a.getScheme(), this.a.getDownloadId(), this.b.g, this.a.cmdScheme) : invokeV.intValue;
    }

    public final void z() {
        String picUrl;
        VideoInfo videoInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            if (this.b.r() && (videoInfo = this.w) != null) {
                picUrl = videoInfo.thumbnail_url;
            } else {
                picUrl = this.a.getPicUrl();
            }
            this.g.n(picUrl);
        }
    }
}

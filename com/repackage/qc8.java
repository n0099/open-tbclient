package com.repackage;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.elementsMaven.Direction;
import com.baidu.tbadk.core.util.JsonTransHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.coreExtra.view.UrlDragImageView;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.ad.download.AdDownloadData;
import com.baidu.tieba.ad.download.DownloadCacheKey;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.widget.ApkDownloadView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.oj5;
import java.util.HashMap;
import org.json.JSONObject;
import tbclient.VideoInfo;
/* loaded from: classes7.dex */
public class qc8 extends pc8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final View.OnClickListener A;
    public RelativeLayout g;
    public TbImageView h;
    public TBSpecificationBtn i;
    public TextView j;
    public TextView k;
    public TextView l;
    public boolean m;
    public UrlDragImageView n;
    public DragImageView.h o;
    public RelativeLayout p;
    public RelativeLayout q;
    public ImageView r;
    public FrameLayout s;
    public View t;
    public TBLottieAnimationView u;
    public Runnable v;
    public ApkDownloadView w;
    public VideoInfo x;
    public DownloadCacheKey y;
    public tj5 z;

    /* loaded from: classes7.dex */
    public class a implements View.OnAttachStateChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qc8 a;

        public a(qc8 qc8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qc8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qc8Var;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.u.resumeAnimation();
                this.a.u.playAnimation();
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
                this.a.u.cancelAnimation();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qc8 a;

        public b(qc8 qc8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qc8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qc8Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            qc8 qc8Var;
            FrameLayout frameLayout;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (frameLayout = (qc8Var = this.a).s) == null || qc8Var.u == null || frameLayout.getVisibility() != 0) {
                return;
            }
            this.a.u.cancelAnimation();
            this.a.s.setVisibility(8);
        }
    }

    /* loaded from: classes7.dex */
    public class c implements TbImageView.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qc8 a;

        public c(qc8 qc8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qc8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qc8Var;
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) && z) {
                this.a.L();
            }
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void onCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements DragImageView.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qc8 a;

        public d(qc8 qc8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qc8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qc8Var;
        }

        @Override // com.baidu.tbadk.widget.DragImageView.h
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.o != null) {
                    this.a.o.a();
                }
                this.a.j.setVisibility(8);
                this.a.k.setVisibility(8);
                this.a.l.setVisibility(8);
                this.a.p.setVisibility(8);
                this.a.r.setVisibility(8);
                this.a.i.setVisibility(8);
                this.a.w.setVisibility(8);
            }
        }

        @Override // com.baidu.tbadk.widget.DragImageView.h
        public void b() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.a.o == null) {
                return;
            }
            this.a.o.b();
        }

        @Override // com.baidu.tbadk.widget.DragImageView.h
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                if (this.a.o != null) {
                    this.a.o.c();
                }
                this.a.j.setVisibility(0);
                this.a.k.setVisibility(0);
                this.a.l.setVisibility(0);
                this.a.p.setVisibility(0);
                qc8 qc8Var = this.a;
                AdvertAppInfo advertAppInfo = qc8Var.b;
                if (advertAppInfo != null) {
                    qc8Var.r.setVisibility(advertAppInfo.r() ? 0 : 8);
                    if (this.a.b.m()) {
                        this.a.i.setVisibility(0);
                    } else {
                        this.a.w.setVisibility(0);
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public float a;
        public float b;
        public float c;
        public final /* synthetic */ View.OnClickListener d;
        public final /* synthetic */ qc8 e;

        public e(qc8 qc8Var, View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qc8Var, onClickListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = qc8Var;
            this.d = onClickListener;
            this.a = 0.0f;
            this.b = 0.0f;
            this.c = 0.0f;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                int action = motionEvent.getAction();
                if (action != 0) {
                    if (action == 1) {
                        this.e.m = 10.0f < this.c;
                        qc8 qc8Var = this.e;
                        if (!qc8Var.m) {
                            this.d.onClick(qc8Var.h);
                        }
                    } else if (action == 2) {
                        float x = motionEvent.getX() - this.a;
                        float y = motionEvent.getY() - this.b;
                        this.c = (float) (this.c + Math.sqrt((x * x) + (y * y)));
                        this.a = motionEvent.getX();
                        this.b = motionEvent.getY();
                    }
                } else {
                    this.e.m = false;
                    this.a = motionEvent.getX();
                    this.b = motionEvent.getY();
                    this.c = 0.0f;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qc8 a;

        public f(qc8 qc8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qc8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qc8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            int w;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                qc8 qc8Var = this.a;
                if (qc8Var.b == null || qc8Var.a == null) {
                    return;
                }
                if (qc8Var.m && view2.getId() == R.id.obfuscated_res_0x7f090373) {
                    return;
                }
                HashMap<String, Object> hashMap = new HashMap<>();
                if (view2.getId() == R.id.obfuscated_res_0x7f090e6a) {
                    w = this.a.v(view2);
                    str = NativeConstants.ID_BUTTON;
                } else if (view2.getId() == R.id.obfuscated_res_0x7f0903c5) {
                    w = this.a.u();
                    str = "title";
                } else {
                    w = this.a.w();
                    str = this.a.b.k() ? "image" : "video";
                }
                hashMap.put("da_area", str);
                this.a.f.a(w, hashMap);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements oj5.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qc8 a;

        public g(qc8 qc8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qc8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qc8Var;
        }

        @Override // com.repackage.oj5.a
        public boolean b(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                vi5.a(this.a.a.getButtonCmdScheme());
                ed7.h(ed7.e(this.a.b));
                qc8 qc8Var = this.a;
                if (qc8Var.d != null && na8.p(qc8Var.a.getScheme()) && na8.r(this.a.b.s)) {
                    qc8 qc8Var2 = this.a;
                    Context context = qc8Var2.d;
                    String scheme = qc8Var2.a.getScheme();
                    String downloadId = this.a.b.getDownloadId();
                    qc8 qc8Var3 = this.a;
                    na8.d(context, scheme, downloadId, qc8Var3.b.h, qc8Var3.a.cmdScheme);
                    return true;
                } else if (this.a.d == null || rg5.h().u() || gk8.a((Activity) this.a.d)) {
                    return false;
                } else {
                    oi.M((Activity) this.a.d, R.string.obfuscated_res_0x7f0f1585);
                    return false;
                }
            }
            return invokeL.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public qc8(TbPageContext tbPageContext) {
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
        this.m = false;
        this.v = null;
        this.z = null;
        this.A = new f(this);
    }

    public final void A(AdCard adCard, AdvertAppInfo advertAppInfo) {
        DownloadCacheKey i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, adCard, advertAppInfo) == null) || advertAppInfo == null || !advertAppInfo.i() || adCard == null) {
            return;
        }
        String scheme = adCard.getScheme();
        String downloadId = adCard.getDownloadId();
        if (!TextUtils.isEmpty(downloadId)) {
            i = lj5.d().h(downloadId);
        } else {
            i = lj5.d().i(scheme);
        }
        if (i == null) {
            i = DownloadCacheKey.create(downloadId, advertAppInfo.r, advertAppInfo.s);
            lj5.d().j(i, null);
        }
        r(i);
    }

    public final int B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? na8.d(this.d, this.a.getScheme(), this.a.getDownloadId(), this.b.h, this.a.cmdScheme) : invokeV.intValue;
    }

    public final void C() {
        String picUrl;
        VideoInfo videoInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.b.r() && (videoInfo = this.x) != null) {
                picUrl = videoInfo.thumbnail_url;
            } else {
                picUrl = this.a.getPicUrl();
            }
            this.h.setEvent(new c(this));
            this.h.H(picUrl, this.c ? 30 : 31, 720, 720, false);
            UrlDragImageView urlDragImageView = this.n;
            if (urlDragImageView != null) {
                urlDragImageView.setIsCdn(this.c);
                this.n.setUrl(picUrl, true);
            }
        }
    }

    public void D() {
        FrameLayout frameLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (frameLayout = this.s) == null || this.u == null) {
            return;
        }
        frameLayout.setVisibility(0);
        this.u.playAnimation();
        s();
    }

    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            K();
            if (this.v != null) {
                pg.a().removeCallbacks(this.v);
            }
        }
    }

    public final void F() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.y == null || this.z == null) {
            return;
        }
        lj5.d().j(this.y, this.z);
    }

    public final void G(DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, downloadData) == null) || downloadData == null) {
            return;
        }
        downloadData.setStatus(this.w.getDownloadStatus());
    }

    public void H(DragImageView.h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, hVar) == null) {
            this.o = hVar;
        }
    }

    public void I(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, onClickListener) == null) {
            TBSpecificationBtn tBSpecificationBtn = this.i;
            if (tBSpecificationBtn != null) {
                tBSpecificationBtn.setOnClickListener(onClickListener);
            }
            TbImageView tbImageView = this.h;
            if (tbImageView != null) {
                tbImageView.setOnClickListener(onClickListener);
            }
            RelativeLayout relativeLayout = this.q;
            if (relativeLayout != null) {
                relativeLayout.setOnClickListener(onClickListener);
            }
            ImageView imageView = this.r;
            if (imageView != null) {
                imageView.setOnClickListener(onClickListener);
            }
            UrlDragImageView urlDragImageView = this.n;
            if (urlDragImageView != null) {
                urlDragImageView.setOuterOnTouchListener(new e(this, onClickListener));
            }
        }
    }

    public DownloadData J(AdvertAppInfo advertAppInfo, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048585, this, advertAppInfo, i)) == null) {
            if (advertAppInfo == null) {
                return new DownloadData();
            }
            DownloadData downloadData = new DownloadData(advertAppInfo.getDownloadId());
            downloadData.setUrl(advertAppInfo.r);
            downloadData.setName(advertAppInfo.n);
            downloadData.setPosition(i);
            downloadData.setNotifyId(mg.e(advertAppInfo.a, 0));
            return downloadData;
        }
        return (DownloadData) invokeLI.objValue;
    }

    public final void K() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || this.y == null || this.z == null) {
            return;
        }
        lj5.d().r(this.y, this.z);
    }

    public void L() {
        WindowManager windowManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (windowManager = (WindowManager) this.d.getSystemService("window")) == null) {
            return;
        }
        int width = windowManager.getDefaultDisplay().getWidth();
        ViewGroup.LayoutParams layoutParams = this.h.getLayoutParams();
        double loadedHeight = this.h.getLoadedHeight() / this.h.getLoadedWidth();
        if (loadedHeight > 1.0d) {
            layoutParams.height = width;
            layoutParams.width = (int) (width / loadedHeight);
        } else {
            layoutParams.height = (int) (width * loadedHeight);
            layoutParams.width = width;
        }
        this.h.setLayoutParams(layoutParams);
    }

    @Override // com.repackage.pc8
    public void c() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || this.e == null) {
            return;
        }
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.d).inflate(R.layout.obfuscated_res_0x7f0d0072, (ViewGroup) null);
        this.g = relativeLayout;
        this.h = (TbImageView) relativeLayout.findViewById(R.id.obfuscated_res_0x7f090373);
        this.i = (TBSpecificationBtn) this.g.findViewById(R.id.obfuscated_res_0x7f090e6a);
        lu4 lu4Var = new lu4();
        lu4Var.p(R.color.CAM_X0302, R.color.CAM_X0101);
        this.i.setConfig(lu4Var);
        this.i.setTextHorizontalCenter(true);
        this.j = (TextView) this.g.findViewById(R.id.obfuscated_res_0x7f0900f8);
        this.k = (TextView) this.g.findViewById(R.id.obfuscated_res_0x7f090094);
        this.l = (TextView) this.g.findViewById(R.id.obfuscated_res_0x7f0900f0);
        this.p = (RelativeLayout) this.g.findViewById(R.id.obfuscated_res_0x7f0900b3);
        this.q = (RelativeLayout) this.g.findViewById(R.id.obfuscated_res_0x7f0903c5);
        ImageView imageView = (ImageView) this.g.findViewById(R.id.obfuscated_res_0x7f0922e9);
        this.r = imageView;
        imageView.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_video_play44, SkinManager.getColor(R.color.CAM_X0101), null));
        this.s = (FrameLayout) this.g.findViewById(R.id.obfuscated_res_0x7f0900d2);
        View findViewById = this.g.findViewById(R.id.obfuscated_res_0x7f0900e8);
        this.t = findViewById;
        vr4.d(findViewById).p(new int[]{R.color.black_alpha40, R.color.black_alpha0}, Direction.RIGHT);
        TBLottieAnimationView tBLottieAnimationView = (TBLottieAnimationView) this.g.findViewById(R.id.obfuscated_res_0x7f0900d3);
        this.u = tBLottieAnimationView;
        SkinManager.setLottieAnimation(tBLottieAnimationView, R.raw.obfuscated_res_0x7f110000);
        this.u.setRepeatCount(3);
        this.u.addOnAttachStateChangeListener(new a(this));
        ApkDownloadView apkDownloadView = (ApkDownloadView) this.g.findViewById(R.id.obfuscated_res_0x7f090e6f);
        this.w = apkDownloadView;
        TbPageContext tbPageContext = this.e;
        if (tbPageContext != null) {
            apkDownloadView.k(tbPageContext.getUniqueId());
        }
        this.w.setTextSize(R.dimen.tbds39);
        this.w.setTextColorInitSkin(R.color.CAM_X0101);
        this.w.setBackgroundSkin(R.drawable.obfuscated_res_0x7f080f47);
        this.w.j();
        I(this.A);
    }

    @Override // com.repackage.pc8
    public void d(AdCard adCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, adCard) == null) {
            super.d(adCard);
            if (adCard == null) {
                return;
            }
            q();
            this.x = this.a.videoInfo;
            C();
            z(this.b, this.a);
            if (!TextUtils.isEmpty(this.b.n)) {
                this.k.setText(this.b.n);
                this.l.setText(this.d.getString(R.string.obfuscated_res_0x7f0f00da));
            }
            if (!TextUtils.isEmpty(adCard.threadTitle)) {
                this.j.setText(adCard.threadTitle);
            }
            this.r.setVisibility(this.b.r() ? 0 : 8);
            I(this.A);
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.h.setVisibility(4);
            UrlDragImageView urlDragImageView = this.n;
            if (urlDragImageView != null) {
                this.g.removeView(urlDragImageView);
            }
            UrlDragImageView urlDragImageView2 = new UrlDragImageView(this.d);
            this.n = urlDragImageView2;
            urlDragImageView2.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            this.n.setIsCanDrag(true);
            this.n.setCanScale(false);
            this.n.setDragToExitListener(new d(this));
            this.g.addView(this.n, 0);
        }
    }

    public void r(DownloadCacheKey downloadCacheKey) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, downloadCacheKey) == null) || downloadCacheKey == null) {
            return;
        }
        this.y = downloadCacheKey;
        K();
        this.z = null;
        AdDownloadData b2 = lj5.d().b(downloadCacheKey);
        AdCard adCard = this.a;
        if (adCard != null && adCard.getAdvertAppInfo() != null) {
            String str = this.a.getAdvertAppInfo().k;
            b2.setExtInfo(this.a.getAdvertAppInfo().h);
            b2.setDownloadKey(this.a.getDownloadKey());
            JSONObject appJson = JsonTransHelper.toAppJson(this.a.getAdvertAppInfo().m);
            if (appJson != null) {
                b2.setAppJson(appJson.toString());
            }
            b2.setPage(str);
            b2.setDeeplinkUrl(this.a.scheme);
            b2.setCmdScheme(this.a.cmdScheme);
        }
        lj5 d2 = lj5.d();
        ApkDownloadView apkDownloadView = this.w;
        pj5 c2 = d2.c(apkDownloadView, apkDownloadView, b2);
        this.z = new rj5(c2);
        if (b2 != null && b2.extra() != null && b2.extra().getPercent() > 0) {
            c2.e(b2);
        }
        this.w.d(b2.getCurrentState());
        F();
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.v = new b(this);
            pg.a().postDelayed(this.v, 10000L);
        }
    }

    public View t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.g : (View) invokeV.objValue;
    }

    public final int u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? B() : invokeV.intValue;
    }

    public final int v(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, view2)) == null) ? B() : invokeL.intValue;
    }

    public final int w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            if (this.b.k()) {
                return B();
            }
            return x();
        }
        return invokeV.intValue;
    }

    public final int x() {
        InterceptResult invokeV;
        AdCard adCard;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            if (this.b == null || (adCard = this.a) == null || this.x == null) {
                return 0;
            }
            return na8.g(this.d, adCard.getScheme(), this.b, this.a.playCmdScheme);
        }
        return invokeV.intValue;
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            TBLottieAnimationView tBLottieAnimationView = this.u;
            if (tBLottieAnimationView != null) {
                tBLottieAnimationView.cancelAnimation();
            }
            FrameLayout frameLayout = this.s;
            if (frameLayout != null) {
                frameLayout.setVisibility(8);
            }
        }
    }

    public void z(AdvertAppInfo advertAppInfo, AdCard adCard) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048599, this, advertAppInfo, adCard) == null) || advertAppInfo == null || adCard == null) {
            return;
        }
        this.b = advertAppInfo;
        this.a = adCard;
        if (advertAppInfo.m()) {
            this.i.setText(adCard.getButtonText());
            this.w.setVisibility(8);
            this.i.setVisibility(0);
            return;
        }
        this.w.setClickable(true);
        this.w.setInitText(adCard.getButtonText());
        this.w.setOnClickInterceptListener(new g(this));
        DownloadData J = J(this.b, mg.e(this.b.g, -1));
        G(J);
        this.w.setData(J);
        this.w.setVisibility(0);
        this.i.setVisibility(8);
        A(adCard, advertAppInfo);
    }
}

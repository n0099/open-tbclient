package com.repackage;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.push.PushExtData;
import com.baidu.tieba.push.PushGeneralData;
import com.baidu.tieba.push.PushRemindInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class ha8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final View a;
    public final RelativeLayout b;
    public final EMTextView c;
    public final EMTextView d;
    public final EMTextView e;
    public final TbImageView f;
    public final TBSpecificationBtn g;
    public final TBLottieAnimationView h;
    public final RelativeLayout i;
    public final EMTextView j;
    public String k;
    public TbPageContext l;
    public PushExtData m;
    public PushRemindInfo n;
    public e o;
    public int p;
    public boolean q;
    public float r;
    public float s;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ha8 a;

        public a(ha8 ha8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ha8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ha8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.k();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ha8 a;

        public b(ha8 ha8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ha8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ha8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.k();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ha8 a;

        public c(ha8 ha8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ha8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ha8Var;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    this.a.r = motionEvent.getY();
                    this.a.q = false;
                } else if (action != 1) {
                    if (action == 2) {
                        if (this.a.r == 0.0f) {
                            this.a.r = motionEvent.getY();
                        }
                        this.a.s = motionEvent.getY() - this.a.r;
                        if (this.a.s < 0.0f) {
                            this.a.q = true;
                        } else {
                            this.a.q = false;
                        }
                    }
                } else if (this.a.q && this.a.o != null) {
                    this.a.o.a(this.a.b);
                    return true;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ha8 a;

        public d(ha8 ha8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ha8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ha8Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.h.playAnimation();
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface e {
        void a(View view2);
    }

    public ha8(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.q = false;
        this.s = 0.0f;
        this.l = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getContext()).inflate(R.layout.obfuscated_res_0x7f0d0740, (ViewGroup) null);
        this.a = inflate;
        this.b = (RelativeLayout) inflate.findViewById(R.id.obfuscated_res_0x7f09224c);
        this.c = (EMTextView) this.a.findViewById(R.id.obfuscated_res_0x7f090789);
        this.d = (EMTextView) this.a.findViewById(R.id.obfuscated_res_0x7f0921ea);
        this.e = (EMTextView) this.a.findViewById(R.id.obfuscated_res_0x7f09203a);
        this.h = (TBLottieAnimationView) this.a.findViewById(R.id.obfuscated_res_0x7f0902ff);
        this.f = (TbImageView) this.a.findViewById(R.id.obfuscated_res_0x7f0902fe);
        this.g = (TBSpecificationBtn) this.a.findViewById(R.id.obfuscated_res_0x7f091be6);
        this.j = (EMTextView) this.a.findViewById(R.id.obfuscated_res_0x7f091017);
        this.i = (RelativeLayout) this.a.findViewById(R.id.obfuscated_res_0x7f091c08);
        this.f.setPlaceHolder(1);
        this.f.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f.setConrers(15);
        this.f.setRadiusById(R.string.J_X01);
        this.f.setDrawCorner(true);
        ov4 ov4Var = new ov4();
        ov4Var.l(UtilHelper.getDimenPixelSize(R.dimen.M_W_X006));
        this.g.setTextSize(R.dimen.T_X08);
        this.g.setConfig(ov4Var);
        this.g.setOnClickListener(new a(this));
        this.b.setOnClickListener(new b(this));
        this.b.setOnTouchListener(new c(this));
        n();
    }

    public final void k() {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            UrlManager.getInstance().dealOneLink(this.l, new String[]{this.k});
            int i = this.p;
            if (i == 3) {
                str = TbadkCoreStatisticKey.KEY_GAME_PLAY_PUSH_ATTENTION_ACCEPT_CLICK;
            } else if (i == 6) {
                str = TbadkCoreStatisticKey.KEY_GAME_PLAY_PUSH_ACCEPT_CLICK;
            } else if (i != 7) {
                return;
            } else {
                str = TbadkCoreStatisticKey.KEY_GAME_PLAY_PUSH_REJECT_CLICK;
            }
            StatisticItem statisticItem = new StatisticItem(str);
            PushExtData pushExtData = this.m;
            StatisticItem addParam = statisticItem.addParam("uid", pushExtData == null ? "" : pushExtData.getUserId());
            PushExtData pushExtData2 = this.m;
            StatisticItem addParam2 = addParam.addParam("obj_id", pushExtData2 == null ? "" : pushExtData2.getGameId());
            PushExtData pushExtData3 = this.m;
            TiebaStatic.log(addParam2.addParam("obj_name", pushExtData3 != null ? pushExtData3.getGameName() : ""));
            e eVar = this.o;
            if (eVar != null) {
                eVar.a(this.g);
            }
        }
    }

    public void l() {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (tBLottieAnimationView = this.h) == null) {
            return;
        }
        tBLottieAnimationView.cancelAnimation();
    }

    public View m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a : (View) invokeV.objValue;
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            ms4 d2 = ms4.d(this.d);
            d2.v(R.color.CAM_X0105);
            d2.A(R.string.F_X02);
            d2.z(R.dimen.T_X06);
            ms4 d3 = ms4.d(this.c);
            d3.v(R.color.CAM_X0109);
            d3.z(R.dimen.T_X09);
            ms4 d4 = ms4.d(this.j);
            d4.v(R.color.CAM_X0109);
            d4.z(R.dimen.T_X08);
            ms4 d5 = ms4.d(this.b);
            d5.n(R.string.J_X05);
            d5.m(0);
            d5.f(R.color.CAM_X0207);
            ms4 d6 = ms4.d(this.e);
            d6.z(R.dimen.T_X10);
            d6.v(R.color.CAM_X0101);
            d6.n(R.string.J_X04);
            d6.f(R.color.CAM_X0311);
            SkinManager.setLottieAnimation(this.h, R.raw.card_live_header_bg);
            this.g.k();
        }
    }

    public void o(PushGeneralData pushGeneralData) {
        int measureText;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, pushGeneralData) == null) {
            this.n = pushGeneralData.getForegroundShowData().getRemindInfo();
            PushExtData extData = pushGeneralData.getForegroundShowData().getExtData();
            this.m = extData;
            this.p = extData == null ? -1 : extData.getType();
            this.d.setText(this.n.getTitle());
            this.c.setText(this.n.getDesc());
            this.f.K(this.n.getImage(), 10, false);
            this.g.setText(this.n.getBtnText());
            this.k = this.n.getScheme();
            if (TextUtils.isEmpty(this.n.getTagText())) {
                this.e.setVisibility(8);
                measureText = 0;
            } else {
                this.e.setVisibility(0);
                this.e.setText(this.n.getTagText());
                measureText = (int) this.e.getPaint().measureText(this.n.getTagText());
            }
            int k = qi.k(this.l.getContext());
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X007);
            int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.M_W_X006);
            int dimenPixelSize3 = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
            int dimenPixelSize4 = UtilHelper.getDimenPixelSize(R.dimen.M_W_X002);
            this.d.setMaxWidth((((((((k - (dimenPixelSize * 2)) - UtilHelper.getDimenPixelSize(R.dimen.tbds94)) - (dimenPixelSize2 * 3)) - measureText) - (dimenPixelSize3 * 2)) - ((int) this.j.getPaint().measureText(this.n.getBtnText()))) - (dimenPixelSize2 * 2)) - (dimenPixelSize4 * 3));
            int i = this.p;
            if (i == 3) {
                str = TbadkCoreStatisticKey.KEY_GAME_PLAY_PUSH_ATTENTION_SHOW;
            } else if (i == 6) {
                str = TbadkCoreStatisticKey.KEY_GAME_PLAY_PUSH_ACCEPT_SHOW;
            } else if (i != 7) {
                return;
            } else {
                str = TbadkCoreStatisticKey.KEY_GAME_PLAY_PUSH_REJECT_SHOW;
            }
            StatisticItem statisticItem = new StatisticItem(str);
            PushExtData pushExtData = this.m;
            StatisticItem addParam = statisticItem.addParam("uid", pushExtData == null ? "" : pushExtData.getUserId());
            PushExtData pushExtData2 = this.m;
            StatisticItem addParam2 = addParam.addParam("obj_id", pushExtData2 == null ? "" : pushExtData2.getGameId());
            PushExtData pushExtData3 = this.m;
            TiebaStatic.log(addParam2.addParam("obj_name", pushExtData3 != null ? pushExtData3.getGameName() : ""));
            if (this.n.getIsBreathe()) {
                this.h.setVisibility(0);
                if (this.h.isAnimating()) {
                    return;
                }
                this.h.setSpeed(0.8f);
                this.h.setRepeatCount(-1);
                this.h.post(new d(this));
            }
        }
    }

    public void p(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, eVar) == null) {
            this.o = eVar;
        }
    }
}

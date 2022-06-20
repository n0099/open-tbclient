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
public class g78 {
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
    public boolean p;
    public float q;
    public float r;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g78 a;

        public a(g78 g78Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g78Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g78Var;
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
        public final /* synthetic */ g78 a;

        public b(g78 g78Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g78Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g78Var;
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
        public final /* synthetic */ g78 a;

        public c(g78 g78Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g78Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g78Var;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    this.a.q = motionEvent.getY();
                    this.a.p = false;
                } else if (action != 1) {
                    if (action == 2) {
                        if (this.a.q == 0.0f) {
                            this.a.q = motionEvent.getY();
                        }
                        this.a.r = motionEvent.getY() - this.a.q;
                        if (this.a.r < 0.0f) {
                            this.a.p = true;
                        } else {
                            this.a.p = false;
                        }
                    }
                } else if (this.a.p && this.a.o != null) {
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
        public final /* synthetic */ g78 a;

        public d(g78 g78Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g78Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g78Var;
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

    public g78(TbPageContext tbPageContext) {
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
        this.p = false;
        this.r = 0.0f;
        this.l = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getContext()).inflate(R.layout.obfuscated_res_0x7f0d06f3, (ViewGroup) null);
        this.a = inflate;
        this.b = (RelativeLayout) inflate.findViewById(R.id.obfuscated_res_0x7f0920a7);
        this.c = (EMTextView) this.a.findViewById(R.id.obfuscated_res_0x7f090757);
        this.d = (EMTextView) this.a.findViewById(R.id.obfuscated_res_0x7f092047);
        this.e = (EMTextView) this.a.findViewById(R.id.obfuscated_res_0x7f091e96);
        this.h = (TBLottieAnimationView) this.a.findViewById(R.id.obfuscated_res_0x7f0902e7);
        this.f = (TbImageView) this.a.findViewById(R.id.obfuscated_res_0x7f0902e6);
        this.g = (TBSpecificationBtn) this.a.findViewById(R.id.obfuscated_res_0x7f091a8d);
        this.j = (EMTextView) this.a.findViewById(R.id.obfuscated_res_0x7f090fb9);
        this.i = (RelativeLayout) this.a.findViewById(R.id.obfuscated_res_0x7f091aae);
        this.f.setPlaceHolder(1);
        this.f.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f.setConrers(15);
        this.f.setRadiusById(R.string.J_X01);
        this.f.setDrawCorner(true);
        wt4 wt4Var = new wt4();
        wt4Var.l(UtilHelper.getDimenPixelSize(R.dimen.M_W_X006));
        this.g.setTextSize(R.dimen.T_X08);
        this.g.setConfig(wt4Var);
        this.g.setOnClickListener(new a(this));
        this.b.setOnClickListener(new b(this));
        this.b.setOnTouchListener(new c(this));
        n();
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            UrlManager.getInstance().dealOneLink(this.l, new String[]{this.k});
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_GAME_PLAY_PUSH_ATTENTION_ACCEPT_CLICK);
            PushExtData pushExtData = this.m;
            StatisticItem addParam = statisticItem.addParam("obj_id", pushExtData == null ? "" : pushExtData.getGameId());
            PushExtData pushExtData2 = this.m;
            TiebaStatic.log(addParam.addParam("obj_name", pushExtData2 != null ? pushExtData2.getGameName() : ""));
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
            fr4 d2 = fr4.d(this.d);
            d2.v(R.color.CAM_X0105);
            d2.A(R.string.F_X02);
            d2.z(R.dimen.T_X06);
            fr4 d3 = fr4.d(this.c);
            d3.v(R.color.CAM_X0109);
            d3.z(R.dimen.T_X09);
            fr4 d4 = fr4.d(this.j);
            d4.v(R.color.CAM_X0109);
            d4.z(R.dimen.T_X08);
            fr4 d5 = fr4.d(this.b);
            d5.n(R.string.J_X05);
            d5.m(0);
            d5.f(R.color.CAM_X0207);
            fr4 d6 = fr4.d(this.e);
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, pushGeneralData) == null) {
            this.n = pushGeneralData.getForegroundShowData().getRemindInfo();
            this.m = pushGeneralData.getForegroundShowData().getExtData();
            this.d.setText(this.n.getTitle());
            this.c.setText(this.n.getDesc());
            this.f.J(this.n.getImage(), 10, false);
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
            int k = pi.k(this.l.getContext());
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X007);
            int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.M_W_X006);
            int dimenPixelSize3 = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
            int dimenPixelSize4 = UtilHelper.getDimenPixelSize(R.dimen.M_W_X002);
            int dimenPixelSize5 = ((((k - (dimenPixelSize * 2)) - UtilHelper.getDimenPixelSize(R.dimen.tbds94)) - (dimenPixelSize2 * 3)) - measureText) - (dimenPixelSize3 * 2);
            this.d.setMaxWidth(((dimenPixelSize5 - ((int) this.j.getPaint().measureText(this.n.getBtnText()))) - (dimenPixelSize2 * 2)) - (dimenPixelSize4 * 3));
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_GAME_PLAY_PUSH_ATTENTION_SHOW).addParam("obj_id", this.m.getGameId()).addParam("obj_name", this.m.getGameName()));
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

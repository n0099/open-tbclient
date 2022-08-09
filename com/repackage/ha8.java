package com.repackage;

import android.app.Activity;
import android.content.Context;
import android.media.Ringtone;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BdToken.BdUniDispatchSchemeController;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.push.PushExtData;
import com.baidu.tieba.push.PushRemindInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class ha8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Activity a;
    public final Context b;
    public View c;
    public TextView d;
    public TBSpecificationBtn e;
    public TBLottieAnimationView f;
    public Animation g;
    public CountDownTimer h;
    public final PushExtData i;
    public final PushRemindInfo j;
    public final int k;
    public Ringtone l;

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
                this.a.l();
                this.a.o(true);
                if (this.a.k == 1 || this.a.k == 2 || this.a.k == 5) {
                    ja8.e(this.a.b, this.a.j.getScheme(), true);
                } else if (this.a.k == 4) {
                    TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GAME_PLAY_ATTENTION_ACCEPT, TbConfig.SERVER_GAME_PLAY_ADRESS + this.a.i.getUri());
                    tbHttpMessageTask.setIsNeedAddCommenParam(true);
                    tbHttpMessageTask.setIsUseCurrentBDUSS(true);
                    MessageManager.getInstance().registerTask(tbHttpMessageTask);
                    HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GAME_PLAY_ATTENTION_ACCEPT);
                    httpMessage.addParam(BdUniDispatchSchemeController.PARAM_ORDER_ID, this.a.i.getOrderId());
                    MessageManager.getInstance().sendMessage(httpMessage);
                    ja8.c(this.a.b, this.a.j.getScheme());
                }
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
                this.a.o(false);
                this.a.l();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c extends CountDownTimer {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ha8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(ha8 ha8Var, long j, long j2) {
            super(j, j2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ha8Var, Long.valueOf(j), Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Long) objArr2[0]).longValue(), ((Long) objArr2[1]).longValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ha8Var;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.l();
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
                String valueOf = String.valueOf((int) (j / 1000));
                TextView textView = this.a.d;
                textView.setText(valueOf + this.a.b.getString(R.string.obfuscated_res_0x7f0f0e09));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements View.OnClickListener {
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GAME_PLAY_ATTENTION_ACCEPT, TbConfig.SERVER_GAME_PLAY_ADRESS + this.a.i.getUriReject());
                tbHttpMessageTask.setIsNeedAddCommenParam(true);
                tbHttpMessageTask.setIsUseCurrentBDUSS(true);
                MessageManager.getInstance().registerTask(tbHttpMessageTask);
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GAME_PLAY_ATTENTION_ACCEPT);
                httpMessage.addParam(BdUniDispatchSchemeController.PARAM_ORDER_ID, this.a.i.getOrderId());
                MessageManager.getInstance().sendMessage(httpMessage);
                this.a.o(false);
                this.a.l();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e extends CountDownTimer {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ha8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(ha8 ha8Var, long j, long j2) {
            super(j, j2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ha8Var, Long.valueOf(j), Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Long) objArr2[0]).longValue(), ((Long) objArr2[1]).longValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ha8Var;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.l();
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
                String valueOf = String.valueOf(j / 60000);
                String valueOf2 = String.valueOf((j % 60000) / 1000);
                this.a.e.setText(this.a.j.getBtnText() + " " + valueOf + ":" + valueOf2);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public f(ha8 ha8Var) {
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
                }
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ha8 a;

        public g(ha8 ha8Var) {
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

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.a.r();
                if (this.a.h != null) {
                    this.a.h.start();
                }
                this.a.p();
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ha8 a;

        public h(ha8 ha8Var) {
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
                this.a.l();
            }
        }
    }

    public ha8(Activity activity, PushExtData pushExtData, PushRemindInfo pushRemindInfo) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, pushExtData, pushRemindInfo};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = activity;
        this.b = activity.getBaseContext();
        this.i = pushExtData;
        this.j = pushRemindInfo;
        this.k = pushExtData.getType();
        m();
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            s();
            Animation animation = this.g;
            if (animation != null) {
                animation.cancel();
            }
            CountDownTimer countDownTimer = this.h;
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
            Activity activity = this.a;
            if (activity != null) {
                ((FrameLayout) activity.findViewById(16908290)).removeView(this.c);
            }
            Ringtone ringtone = this.l;
            if (ringtone != null) {
                ringtone.stop();
            }
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            View inflate = LayoutInflater.from(this.b).inflate(R.layout.obfuscated_res_0x7f0d036d, (ViewGroup) null);
            this.c = inflate;
            this.d = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091880);
            HeadImageView headImageView = (HeadImageView) this.c.findViewById(R.id.obfuscated_res_0x7f091884);
            headImageView.setIsRound(true);
            headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            headImageView.K(this.j.getImage(), 12, false);
            TextView textView = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f091885);
            textView.setText(this.j.getTitle());
            TextView textView2 = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f091883);
            textView2.setText(this.j.getDesc());
            ms4.d(textView).v(R.color.CAM_X0101);
            ms4.d(textView2).v(R.color.CAM_X0103);
            ms4 d2 = ms4.d(this.d);
            d2.v(R.color.CAM_X0103);
            d2.z(R.dimen.T_X08);
            TBLottieAnimationView tBLottieAnimationView = (TBLottieAnimationView) this.c.findViewById(R.id.obfuscated_res_0x7f09187e);
            this.f = tBLottieAnimationView;
            tBLottieAnimationView.setAnimation(R.raw.obfuscated_res_0x7f110046);
            this.f.setRepeatMode(1);
            this.f.setRepeatCount(-1);
            TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) this.c.findViewById(R.id.obfuscated_res_0x7f091881);
            this.e = tBSpecificationBtn;
            tBSpecificationBtn.setTextSize(R.dimen.T_X07);
            pv4 pv4Var = new pv4();
            pv4Var.p(R.color.CAM_X0101, R.color.CAM_X0302);
            pv4Var.l(UtilHelper.getDimenPixelSize(R.dimen.M_W_X019));
            this.e.setConfig(pv4Var);
            this.e.k();
            this.e.setText(this.j.getBtnText());
            this.e.setOnClickListener(new a(this));
            n();
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            int i = this.k;
            if (i != 1 && i != 2 && i != 5) {
                if (i == 4) {
                    this.d.setText(this.b.getString(R.string.obfuscated_res_0x7f0f0e08));
                    this.d.setOnClickListener(new d(this));
                    this.h = new e(this, this.j.getShowtime(), 1000L);
                    return;
                }
                return;
            }
            TextView textView = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f09187f);
            textView.setText(this.j.getTagText());
            textView.setVisibility(0);
            View findViewById = this.c.findViewById(R.id.obfuscated_res_0x7f091882);
            findViewById.setVisibility(0);
            findViewById.setOnClickListener(new b(this));
            this.h = new c(this, this.j.getShowtime(), 1000L);
        }
    }

    public final void o(boolean z) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            int i = this.k;
            if (i == 1) {
                str = z ? TbadkCoreStatisticKey.KEY_GAME_PLAY_PUSH_SYSTEM_GROUP_ACCEPT_CLICK : TbadkCoreStatisticKey.KEY_GAME_PLAY_PUSH_SYSTEM_GROUP_REJECT_CLICK;
            } else if (i == 2) {
                str = z ? TbadkCoreStatisticKey.KEY_GAME_PLAY_PUSH_PLAYER_ACCEPT_CLICK : TbadkCoreStatisticKey.KEY_GAME_PLAY_PUSH_PLAYER_REJECT_CLICK;
            } else if (i == 4) {
                str = z ? TbadkCoreStatisticKey.KEY_GAME_PLAY_PUSH_ORDER_ACCEPT_CLICK : TbadkCoreStatisticKey.KEY_GAME_PLAY_PUSH_ORDER_REJECT_CLICK;
            } else if (i != 5) {
                return;
            } else {
                str = z ? TbadkCoreStatisticKey.KEY_GAME_PLAY_PUSH_GUIDE_ORDER_ACCEPT_CLICK : TbadkCoreStatisticKey.KEY_GAME_PLAY_PUSH_GUIDE_ORDER_CLOSE_CLICK;
            }
            StatisticItem statisticItem = new StatisticItem(str);
            PushExtData pushExtData = this.i;
            StatisticItem addParam = statisticItem.addParam("uid", pushExtData == null ? "" : pushExtData.getUserId());
            PushExtData pushExtData2 = this.i;
            StatisticItem addParam2 = addParam.addParam("obj_id", pushExtData2 == null ? "" : pushExtData2.getGameId());
            PushExtData pushExtData3 = this.i;
            StatisticItem addParam3 = addParam2.addParam("obj_name", pushExtData3 == null ? "" : pushExtData3.getGameName());
            PushExtData pushExtData4 = this.i;
            TiebaStatic.log(addParam3.addParam("obj_source", pushExtData4 != null ? pushExtData4.getSource() : ""));
        }
    }

    public final void p() {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            int i = this.k;
            if (i == 1) {
                str = TbadkCoreStatisticKey.KEY_GAME_PLAY_PUSH_SYSTEM_GROUP_SHOW;
            } else if (i == 2) {
                str = TbadkCoreStatisticKey.KEY_GAME_PLAY_PUSH_PLAYER_SHOW;
            } else if (i == 4) {
                str = TbadkCoreStatisticKey.KEY_GAME_PLAY_PUSH_ORDER_SHOW;
            } else if (i != 5) {
                return;
            } else {
                str = TbadkCoreStatisticKey.KEY_GAME_PLAY_PUSH_GUIDE_ORDER_SHOW;
            }
            StatisticItem statisticItem = new StatisticItem(str);
            PushExtData pushExtData = this.i;
            StatisticItem addParam = statisticItem.addParam("uid", pushExtData == null ? "" : pushExtData.getUserId());
            PushExtData pushExtData2 = this.i;
            StatisticItem addParam2 = addParam.addParam("obj_id", pushExtData2 == null ? "" : pushExtData2.getGameId());
            PushExtData pushExtData3 = this.i;
            StatisticItem addParam3 = addParam2.addParam("obj_name", pushExtData3 == null ? "" : pushExtData3.getGameName());
            PushExtData pushExtData4 = this.i;
            TiebaStatic.log(addParam3.addParam("obj_source", pushExtData4 != null ? pushExtData4.getSource() : ""));
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 48;
            layoutParams.topMargin = e45.a(this.b);
            int f2 = qi.f(this.b, R.dimen.M_W_X007);
            layoutParams.leftMargin = f2;
            layoutParams.rightMargin = f2;
            this.c.setLayoutParams(layoutParams);
            this.c.setOnClickListener(new f(this));
            ((FrameLayout) this.a.findViewById(16908290)).addView(this.c);
            Animation loadAnimation = AnimationUtils.loadAnimation(this.b, R.anim.obfuscated_res_0x7f010102);
            this.g = loadAnimation;
            loadAnimation.setDuration(400L);
            this.g.setAnimationListener(new g(this));
            this.c.startAnimation(this.g);
            this.c.findViewById(R.id.obfuscated_res_0x7f091882).setOnClickListener(new h(this));
            this.l = ja8.f();
        }
    }

    public final void r() {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (tBLottieAnimationView = this.f) == null) {
            return;
        }
        tBLottieAnimationView.playAnimation();
    }

    public final void s() {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (tBLottieAnimationView = this.f) == null) {
            return;
        }
        tBLottieAnimationView.cancelAnimation();
        this.f.setFrame(0);
    }
}

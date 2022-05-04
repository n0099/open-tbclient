package com.repackage;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.CountDownTimer;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPrivilegeActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.MemberPayStatistic;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.ThirdStatisticHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewCommonUtil;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.widget.LinearGradientView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.recommend.FrsLikeRecommendLayout;
import com.baidu.tieba.frs.servicearea.ServiceAreaView;
import com.baidu.tieba.frs.shrinkhead.LogicField;
import com.baidu.tieba.frs.vc.FrsTopView;
import com.baidu.tieba.frs.view.FrsHeaderVideoImageShadeView;
import com.baidu.tieba.frs.view.HotRankEntryView;
import com.baidu.tieba.frs.voiceroom.view.FrsVoiceRoomListLayout;
import com.baidu.tieba.play.OnStatusChangedListener;
import com.baidu.tieba.play.TbVideoView;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.view.AdapterLinearLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.cr4;
import com.repackage.z68;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import tbclient.SignActivityInfo;
import tbclient.ThemeColorInfo;
import tbclient.ThemeElement;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes5.dex */
public class bh6 extends nr6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout A0;
    public View B0;
    public View C0;
    public View D0;
    public View E0;
    public TextView F0;
    public final View G0;
    public final HeadImageView H0;
    public final TextView I0;
    public final View J0;
    public final ImageView K0;
    public final TextView L0;
    public HotRankEntryView M0;
    public List<uo> N0;
    public nz5 O0;
    public int P0;
    public long Q0;
    public ScheduledExecutorService R0;
    public boolean S0;
    public boolean T0;
    public boolean U0;
    public CountDownTimer V0;
    public boolean W0;
    @NonNull
    public final ho6 X0;
    @NonNull
    public final mo6 Y0;
    @Nullable
    public BdTypeRecyclerView Z0;
    public TbVideoView a1;
    public TbImageView b1;
    public View c1;
    public View d1;
    public TBLottieAnimationView e1;
    public TextView f1;
    public TBLottieAnimationView g1;
    public View h1;
    public View i1;
    public View j1;
    public View k1;
    public FrsHeaderVideoImageShadeView l1;
    public boolean m1;
    public boolean n1;
    public CustomMessageListener o1;
    public CustomMessageListener p1;
    public RelativeLayout q0;
    public CustomMessageListener q1;
    public TextView r0;
    public CustomMessageListener r1;
    public TextView s0;
    public String t0;
    public ArrayList<TbImageView> u0;
    public ye6 v0;
    public boolean w0;
    public View x0;
    public View y0;
    public boolean z0;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ro4 a;
        public final /* synthetic */ FrsViewData b;
        public final /* synthetic */ bh6 c;

        public a(bh6 bh6Var, ro4 ro4Var, FrsViewData frsViewData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bh6Var, ro4Var, frsViewData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = bh6Var;
            this.a = ro4Var;
            this.b = frsViewData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.c.a == null || ve5.a(this.c.a.getPageActivity(), this.a.h()) || TextUtils.isEmpty(this.a.g())) {
                return;
            }
            FrsViewData frsViewData = this.b;
            if (frsViewData != null && frsViewData.getForum() != null && !TextUtils.isEmpty(this.b.getForum().getId()) && this.b.getActivityHeadData() != null && !TextUtils.isEmpty(this.b.getActivityHeadData().c())) {
                String id = this.b.getForum().getId();
                String c = this.b.getActivityHeadData().c();
                StatisticItem statisticItem = new StatisticItem("c13330");
                statisticItem.param("fid", id);
                statisticItem.param("obj_id", c);
                TiebaStatic.log(statisticItem);
                if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                    statisticItem.param("ab_tag", TbadkCoreApplication.getInst().getAdAdSense().n);
                }
                jq6.d(this.b, 1, this.c.b.getUniqueId());
            }
            lq6.b(this.c.a, this.a.k(), this.a.g(), this.a.i());
            ThirdStatisticHelper.sendReq((String) ListUtils.getItem(this.a.n(), 1));
        }
    }

    /* loaded from: classes5.dex */
    public class b implements cr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(bh6 bh6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bh6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.cr4.e
        public void onClick(cr4 cr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cr4Var) == null) {
                cr4Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements cr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bh6 a;

        public c(bh6 bh6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bh6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bh6Var;
        }

        @Override // com.repackage.cr4.e
        public void onClick(cr4 cr4Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, cr4Var) == null) || this.a.a == null || this.a.a.getPageActivity() == null) {
                return;
            }
            MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(this.a.a.getPageActivity(), this.a.f0, "exp_acce", 2);
            memberPayActivityConfig.setSceneId("4004001000");
            memberPayActivityConfig.setReferPageClickZone(MemberPayStatistic.REFER_PAGE_FRS, MemberPayStatistic.CLICK_ZONE_POP_UPS_OPENDE_BUTTON);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
            cr4Var.dismiss();
        }
    }

    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bh6 a;

        public d(bh6 bh6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bh6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bh6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.a == null || this.a.a.getPageActivity() == null) {
                return;
            }
            rg.d(this.a.M, this.a.a.getPageActivity());
            this.a.b.c = false;
            ul4.q(this.a.a.getPageActivity(), this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f05ca), TbConfig.SERVER_ADDRESS_WEB_VIEW + "mo/q/tbeanrights?type=7&_client_version=" + TbConfig.getVersion() + "&nohead=1", true, true, true);
        }
    }

    /* loaded from: classes5.dex */
    public class e implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bh6 a;

        public e(bh6 bh6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bh6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bh6Var;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                if (motionEvent.getAction() == 4) {
                    rg.c(this.a.M);
                    this.a.b.c = false;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class f extends CountDownTimer {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ bh6 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(bh6 bh6Var, long j, long j2, String str) {
            super(j, j2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bh6Var, Long.valueOf(j), Long.valueOf(j2), str};
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
            this.b = bh6Var;
            this.a = str;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.F = false;
                if (this.b.E != null) {
                    this.b.E.setVisibility(8);
                }
                if (this.b.Q == null || this.b.j()) {
                    return;
                }
                this.b.Q.q(this.b.F);
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) || this.b.E == null) {
                return;
            }
            this.b.E.setVisibility(0);
            EMTextView eMTextView = this.b.E;
            eMTextView.setText(this.a + (j / 1000) + "s");
        }
    }

    /* loaded from: classes5.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ bh6 b;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ g a;

            public a(g gVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {gVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = gVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.b.E == null) {
                    return;
                }
                if (this.a.b.E.getVisibility() == 8) {
                    this.a.b.E.setVisibility(0);
                    this.a.b.E.setText(this.a.a);
                    if (this.a.b.G != null) {
                        bh6 bh6Var = this.a.b;
                        bh6Var.L1(bh6Var.G.activity_msg, this.a.b.G.countdown_time.intValue());
                    }
                } else if (this.a.b.E.getVisibility() == 0) {
                    this.a.b.v1();
                }
            }
        }

        public g(bh6 bh6Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bh6Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = bh6Var;
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                pg.a().post(new a(this));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bh6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(bh6 bh6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bh6Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bh6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof tn4)) {
                tn4 tn4Var = (tn4) customResponsedMessage.getData();
                this.a.M1(tn4Var);
                this.a.C1(tn4Var);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bh6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(bh6 bh6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bh6Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bh6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && sq6.m(this.a.X)) {
                this.a.K1();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bh6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(bh6 bh6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bh6Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bh6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                if (intValue == 1) {
                    if (sq6.m(this.a.X) && this.a.a1.getVisibility() == 0) {
                        this.a.K1();
                    }
                    this.a.n1 = false;
                } else if (intValue == 2 && sq6.m(this.a.X)) {
                    if (!this.a.n1) {
                        bh6 bh6Var = this.a;
                        bh6Var.K(bh6Var.X.getForum(), this.a.X);
                    }
                    this.a.n1 = false;
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class k extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bh6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(bh6 bh6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bh6Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bh6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                this.a.m1 = true;
                if (intValue != 1) {
                    if (intValue == 2 && sq6.m(this.a.X)) {
                        bh6 bh6Var = this.a;
                        bh6Var.K(bh6Var.X.getForum(), this.a.X);
                    }
                } else if (FrsFragment.f2 || !sq6.m(this.a.X)) {
                } else {
                    bh6 bh6Var2 = this.a;
                    bh6Var2.K(bh6Var2.X.getForum(), this.a.X);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class l implements ye6 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bh6 a;

        public l(bh6 bh6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bh6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bh6Var;
        }

        @Override // com.repackage.ye6
        public void a(ThreadData threadData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, threadData) == null) {
                rq6.d(this.a.b, this.a.X, threadData);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class m implements OnStatusChangedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ro4 a;
        public final /* synthetic */ FrsViewData b;
        public final /* synthetic */ bh6 c;

        public m(bh6 bh6Var, ro4 ro4Var, FrsViewData frsViewData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bh6Var, ro4Var, frsViewData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = bh6Var;
            this.a = ro4Var;
            this.b = frsViewData;
        }

        @Override // com.baidu.tieba.play.OnStatusChangedListener
        public void onStatusChange(OnStatusChangedListener.VideoStatus videoStatus) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, videoStatus) == null) {
                if (videoStatus == OnStatusChangedListener.VideoStatus.VIDEO_PLAYING) {
                    this.c.b1.setVisibility(8);
                    this.c.d1.setVisibility(8);
                    this.c.D1();
                    this.c.X1(this.a, 0);
                    jq6.l("c14592", this.b);
                } else if (videoStatus == OnStatusChangedListener.VideoStatus.VIDEO_COMPLETE) {
                    this.c.K1();
                    jq6.l("c14593", this.b);
                } else if (videoStatus == OnStatusChangedListener.VideoStatus.INTERNAL_VIDEO_BUFFERING_ERROR) {
                    this.c.K1();
                } else if (videoStatus == OnStatusChangedListener.VideoStatus.INTERNAL_VIDEO_BUFFERING_BUFFER) {
                    this.c.c2();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class n implements z68.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ro4 a;
        public final /* synthetic */ bh6 b;

        public n(bh6 bh6Var, ro4 ro4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bh6Var, ro4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = bh6Var;
            this.a = ro4Var;
        }

        @Override // com.repackage.z68.c
        public void a(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) {
                this.b.X1(this.a, i2);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class o implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ro4 a;
        public final /* synthetic */ FrsViewData b;
        public final /* synthetic */ bh6 c;

        public o(bh6 bh6Var, ro4 ro4Var, FrsViewData frsViewData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bh6Var, ro4Var, frsViewData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = bh6Var;
            this.a = ro4Var;
            this.b = frsViewData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.c.d1.getVisibility() == 0) {
                    this.c.a1.start();
                    return;
                }
                lq6.b(this.c.a, this.a.k(), this.a.g(), this.a.i());
                if (this.c.b != null) {
                    jq6.d(this.b, 2, this.c.b.getUniqueId());
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class p implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ro4 a;
        public final /* synthetic */ FrsViewData b;
        public final /* synthetic */ bh6 c;

        public p(bh6 bh6Var, ro4 ro4Var, FrsViewData frsViewData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bh6Var, ro4Var, frsViewData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = bh6Var;
            this.a = ro4Var;
            this.b = frsViewData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                lq6.b(this.c.a, this.a.k(), this.a.g(), this.a.i());
                if (this.c.b != null) {
                    jq6.d(this.b, 2, this.c.b.getUniqueId());
                }
            }
        }
    }

    public bh6(FrsFragment frsFragment, String str, String str2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment, str, str2, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.z0 = false;
        this.P0 = -1;
        this.Q0 = 1000L;
        this.W0 = false;
        this.X0 = go6.a();
        this.o1 = new h(this, 2921679);
        this.p1 = new i(this, 2921681);
        this.q1 = new j(this, 2921680);
        this.r1 = new k(this, 2921682);
        this.u0 = new ArrayList<>();
        this.f0 = i2;
        this.c = new Handler();
        this.b = frsFragment;
        this.a = frsFragment.getPageContext();
        oi.f(frsFragment.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f0701d5);
        oi.f(frsFragment.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f07026a);
        oi.f(frsFragment.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f070250);
        this.T = str;
        this.U = str2;
        View y1 = y1();
        this.d = y1;
        this.X0.f(frsFragment, y1);
        this.Y0 = this.X0.h();
        this.q0 = (RelativeLayout) this.d.findViewById(R.id.obfuscated_res_0x7f0906d2);
        this.u = (RelativeLayout) this.d.findViewById(R.id.obfuscated_res_0x7f090d31);
        this.v = (LinearGradientView) this.d.findViewById(R.id.obfuscated_res_0x7f090d34);
        TbImageView tbImageView = (TbImageView) this.d.findViewById(R.id.obfuscated_res_0x7f090d32);
        this.w = tbImageView;
        tbImageView.setPageId(this.b.getUniqueId());
        this.w.setDefaultBgResource(R.color.transparent);
        this.w.setDefaultResource(R.drawable.obfuscated_res_0x7f080f0b);
        this.x0 = this.d.findViewById(R.id.obfuscated_res_0x7f090d4d);
        this.a1 = (TbVideoView) this.d.findViewById(R.id.obfuscated_res_0x7f09231b);
        TbImageView tbImageView2 = (TbImageView) this.d.findViewById(R.id.obfuscated_res_0x7f092315);
        this.b1 = tbImageView2;
        tbImageView2.setPageId(this.b.getUniqueId());
        this.b1.setDefaultBgResource(R.drawable.obfuscated_res_0x7f080f0b);
        this.b1.setDefaultResource(R.drawable.obfuscated_res_0x7f080f0b);
        this.b1.setPlaceHolder(2);
        this.c1 = this.d.findViewById(R.id.obfuscated_res_0x7f09231a);
        this.d1 = this.d.findViewById(R.id.obfuscated_res_0x7f092319);
        this.e1 = (TBLottieAnimationView) this.d.findViewById(R.id.obfuscated_res_0x7f092318);
        this.y0 = this.d.findViewById(R.id.obfuscated_res_0x7f090bda);
        this.S = (FrsLikeRecommendLayout) this.d.findViewById(R.id.obfuscated_res_0x7f090b66);
        go6.e(this.x0, this.y0);
        this.h1 = go6.b(this.d);
        this.i1 = this.d.findViewById(R.id.obfuscated_res_0x7f090d33);
        this.j1 = this.d.findViewById(R.id.obfuscated_res_0x7f0912f9);
        this.f1 = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f092212);
        this.g1 = (TBLottieAnimationView) this.d.findViewById(R.id.obfuscated_res_0x7f091343);
        this.k1 = this.d.findViewById(R.id.obfuscated_res_0x7f092316);
        this.l1 = (FrsHeaderVideoImageShadeView) this.d.findViewById(R.id.obfuscated_res_0x7f092314);
        this.A0 = (LinearLayout) this.d.findViewById(R.id.obfuscated_res_0x7f0911b7);
        int n2 = this.X0.n(LogicField.ROUND_CORNER_STYLE);
        View findViewById = this.d.findViewById(R.id.obfuscated_res_0x7f090d48);
        this.B0 = findViewById;
        findViewById.setVisibility(n2);
        this.C0 = this.d.findViewById(R.id.obfuscated_res_0x7f091c8d);
        this.D0 = this.d.findViewById(R.id.obfuscated_res_0x7f090304);
        this.x = (ServiceAreaView) this.d.findViewById(R.id.obfuscated_res_0x7f091c8e);
        this.y = (FrameLayout) this.d.findViewById(R.id.obfuscated_res_0x7f090abf);
        this.D = (FrsVoiceRoomListLayout) this.d.findViewById(R.id.obfuscated_res_0x7f0923e2);
        this.A = (FrsTopView) this.d.findViewById(R.id.obfuscated_res_0x7f090c01);
        this.E0 = this.d.findViewById(R.id.obfuscated_res_0x7f090bf8);
        this.B = this.d.findViewById(R.id.obfuscated_res_0x7f090bf9);
        this.C = this.d.findViewById(R.id.obfuscated_res_0x7f091c91);
        this.Z0 = yo6.g(this.A, this.b.E2());
        this.h = (List) this.X0.a(LogicField.LIKE_BTN);
        this.i = (List) this.X0.a(LogicField.SIGN_BTN);
        this.L = (ImageView) x1().a(LogicField.SPEED_ICON);
        this.r0 = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f0913d1);
        this.s0 = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f0918a5);
        this.j = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f09122f);
        this.s = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f091227);
        this.k = (ImageView) this.d.findViewById(R.id.obfuscated_res_0x7f091349);
        this.l = (ImageView) this.d.findViewById(R.id.obfuscated_res_0x7f091348);
        this.e = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f0913d6);
        this.f = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f0918ab);
        this.n = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f090a6a);
        this.o = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f0903f1);
        BarImageView barImageView = (BarImageView) this.d.findViewById(R.id.obfuscated_res_0x7f090b44);
        this.N = barImageView;
        barImageView.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.N.setPageId(this.b.getUniqueId());
        this.N.setContentDescription(frsFragment.getResources().getString(R.string.obfuscated_res_0x7f0f02d2));
        this.N.setStrokeWith(oi.f(TbadkCoreApplication.getInst(), R.dimen.tbds4));
        this.N.setShowOval(true);
        this.N.setPlaceHolder(1);
        this.r = this.d.findViewById(R.id.obfuscated_res_0x7f091228);
        this.q = (RelativeLayout) this.d.findViewById(R.id.obfuscated_res_0x7f090d1e);
        this.p = (RelativeLayout) this.d.findViewById(R.id.obfuscated_res_0x7f0915b6);
        this.t = (RelativeLayout) this.d.findViewById(R.id.obfuscated_res_0x7f090d27);
        this.G0 = this.d.findViewById(R.id.obfuscated_res_0x7f090b90);
        this.I0 = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f090b91);
        HeadImageView headImageView = (HeadImageView) this.d.findViewById(R.id.obfuscated_res_0x7f090b92);
        this.H0 = headImageView;
        headImageView.setIsRound(true);
        this.H0.setDrawBorder(true);
        this.H0.setDefaultResource(R.drawable.icon_default_avatar100);
        this.H0.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.J0 = this.d.findViewById(R.id.obfuscated_res_0x7f090b8f);
        this.K0 = (ImageView) this.d.findViewById(R.id.obfuscated_res_0x7f090b8e);
        this.L0 = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f090b8d);
        WebPManager.setPureDrawable(this.K0, R.drawable.obfuscated_res_0x7f0807de, R.color.CAM_X0101, null);
        this.I = LayoutInflater.from(frsFragment.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0354, (ViewGroup) null);
        this.m = LayoutInflater.from(this.b.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0322, (ViewGroup) null);
        this.M0 = (HotRankEntryView) this.d.findViewById(R.id.obfuscated_res_0x7f090b42);
        this.m.setVisibility(8);
        new eq6(this.a);
        this.E = (EMTextView) this.d.findViewById(R.id.obfuscated_res_0x7f090701);
        MessageManager.getInstance().registerListener(this.o1);
        MessageManager.getInstance().registerListener(this.p1);
        MessageManager.getInstance().registerListener(this.q1);
        MessageManager.getInstance().registerListener(this.r1);
    }

    @Override // com.repackage.nr6
    public void A(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            super.A(z);
            ig6 ig6Var = this.z;
            if (ig6Var != null) {
                ig6Var.k(z);
            }
        }
    }

    public final LinearGradientView A1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            FrsFragment frsFragment = this.b;
            if (frsFragment != null && frsFragment.I2() != null) {
                View C = this.b.I2().C();
                if (C instanceof LinearGradientView) {
                    return (LinearGradientView) C;
                }
            }
            return null;
        }
        return (LinearGradientView) invokeV.objValue;
    }

    @Override // com.repackage.nr6
    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            ig6 ig6Var = this.z;
            if (ig6Var != null) {
                ig6Var.l();
            }
            if (FrsFragment.f2 && sq6.m(this.X)) {
                FrsFragment.f2 = false;
                K(this.X.getForum(), this.X);
            }
        }
    }

    public final int B1(boolean z, boolean z2) {
        InterceptResult invokeCommon;
        List<uo> list;
        List<ik8> list2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            int i2 = 0;
            if (z2) {
                hk8 hk8Var = this.X.serviceAreaData;
                if (hk8Var != null && (list2 = hk8Var.b) != null && list2.size() == 1) {
                    i2 = 0 + oi.f(this.a.getPageActivity(), R.dimen.tbds83);
                } else {
                    i2 = 0 + oi.f(this.a.getPageActivity(), R.dimen.tbds84);
                }
            }
            if (z && (list = this.N0) != null) {
                i2 += Math.min(list.size(), 2) * oi.f(this.a.getPageActivity(), R.dimen.tbds83);
            }
            if (this.y.getVisibility() == 0) {
                i2 += oi.f(this.a.getPageActivity(), R.dimen.tbds231);
            }
            return (z2 || z || this.y.getVisibility() == 0) ? i2 + oi.f(this.a.getPageActivity(), R.dimen.tbds45) : i2;
        }
        return invokeCommon.intValue;
    }

    public final void C1(tn4 tn4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, tn4Var) == null) || tn4Var == null || tn4Var.b() == 0.0f) {
            return;
        }
        float d2 = tn4Var.d() / ((tn4Var.b() * 40.0f) / 70.0f);
        float d3 = tn4Var.d() / tn4Var.b();
        this.f1.setAlpha(d2);
        this.g1.setAlpha(d2);
        this.h1.setAlpha(1.0f - d2);
        float f2 = 1.0f - d3;
        this.i1.setAlpha(f2);
        this.c1.setAlpha(f2);
    }

    public final void D1() {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (tBLottieAnimationView = this.e1) == null) {
            return;
        }
        tBLottieAnimationView.setVisibility(8);
        if (this.e1.isAnimating()) {
            this.e1.cancelAnimation();
        }
    }

    @Override // com.repackage.nr6
    public void E(boolean z, float f2) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Boolean.valueOf(z), Float.valueOf(f2)}) == null) {
            this.j0 = z;
            Bitmap cashBitmap = BitmapHelper.getCashBitmap(R.drawable.bg_frs_signin_bar_down);
            if (cashBitmap == null || this.j == null || this.k == null || this.s == null || cashBitmap.getWidth() <= 0) {
                return;
            }
            if (this.j0) {
                this.j.setText(R.string.obfuscated_res_0x7f0f09d6);
                if (f2 >= 1.0f) {
                    i2 = this.Z;
                } else {
                    i2 = this.Z + 1;
                }
                FrsViewData g0 = this.b.g0();
                if (g0 != null && g0.getForum() != null) {
                    g0.getForum().setUser_level(i2);
                }
                this.s.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0a6d, Integer.valueOf(i2)));
            } else {
                this.X0.g(this.Z, this.V);
                this.j.setText(this.V);
                this.s.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0a6d, Integer.valueOf(this.Z)));
            }
            this.k.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, z1(this.Z)));
            if (!this.j0) {
                b0(this.k, this.l0, f2);
            } else if (f2 >= 1.0f) {
                b0(this.k, this.l0, f2);
            } else {
                Z(this.k, this.l0, f2);
            }
            this.l0 = f2;
        }
    }

    public final boolean E1(ro4 ro4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, ro4Var)) == null) ? (ro4Var == null || StringUtils.isNull(ro4Var.e()) || StringUtils.isNull(ro4Var.j())) ? false : true : invokeL.booleanValue;
    }

    @Override // com.repackage.nr6
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.A.i(this.P0);
        }
    }

    public final boolean F1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            FrsTopView frsTopView = this.A;
            return frsTopView != null && frsTopView.getVisibility() == 0;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.nr6
    public void G() {
        FrsViewData frsViewData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || this.b == null || (frsViewData = this.X) == null) {
            return;
        }
        List<uo> showTopThreadList = frsViewData.getShowTopThreadList();
        this.z0 = showTopThreadList.size() > 2;
        Z1(showTopThreadList, this.X.getBusinessPromot());
    }

    public final boolean G1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            ServiceAreaView serviceAreaView = this.x;
            return serviceAreaView != null && serviceAreaView.getVisibility() == 0;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.nr6
    public void H() {
        br6 br6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (br6Var = this.Q) == null) {
            return;
        }
        br6Var.o(this.c0);
    }

    public final int H1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            int k2 = oi.k(this.a.getPageActivity());
            int i2 = (k2 * 9) / 16;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.a1.getLayoutParams();
            layoutParams.width = k2;
            layoutParams.height = i2;
            this.a1.setLayoutParams(layoutParams);
            return i2;
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.nr6
    public void I() {
        br6 br6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (br6Var = this.Q) == null) {
            return;
        }
        br6Var.q(this.F);
    }

    public final void I1(int i2) {
        FrsViewData frsViewData;
        ForumData forum;
        ThemeColorInfo themeColorInfo;
        ThemeElement themeElement;
        ThemeElement themeElement2;
        ThemeElement themeElement3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048591, this, i2) == null) || (frsViewData = this.X) == null || (forum = frsViewData.getForum()) == null || (themeColorInfo = forum.getThemeColorInfo()) == null || (themeElement = themeColorInfo.day) == null || (themeElement2 = themeColorInfo.night) == null || (themeElement3 = themeColorInfo.dark) == null) {
            return;
        }
        if (i2 == 4) {
            themeElement = themeElement3;
        } else if (i2 == 1) {
            themeElement = themeElement2;
        }
        this.Y0.e(themeElement);
        this.X0.e(themeElement);
        if (!this.w0) {
            LinearGradientView A1 = A1();
            LinearGradientView linearGradientView = this.v;
            if (linearGradientView != null && A1 != null) {
                ThemeElement themeElement4 = themeColorInfo.day;
                String str = themeElement4.light_color;
                String str2 = themeElement4.dark_color;
                ThemeElement themeElement5 = themeColorInfo.night;
                String str3 = themeElement5.light_color;
                String str4 = themeElement5.dark_color;
                ThemeElement themeElement6 = themeColorInfo.dark;
                linearGradientView.setGradientColor(str, str2, str3, str4, themeElement6.light_color, themeElement6.dark_color);
            }
            if (this.w != null) {
                if (UbsABTestHelper.isFrsModifyABTestA()) {
                    this.w.setDefaultResource(R.color.transparent);
                } else {
                    this.w.K(themeElement.pattern_image, 10, false);
                }
            }
        }
        ServiceAreaView serviceAreaView = this.x;
        if (serviceAreaView != null) {
            serviceAreaView.setThemeFontColor(kd7.b(themeElement.common_color));
        }
        if (this.A != null) {
            int b2 = kd7.b(themeElement.common_color);
            if (UbsABTestHelper.isFrsModifyABTestA() && UtilHelper.isNightOrDarkMode()) {
                b2 = SkinManager.getColor(R.color.CAM_X0105);
            }
            this.A.setUrlAndColor(forum.getTopIcon(), b2);
        }
    }

    @Override // com.repackage.nr6
    public void J(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, onClickListener) == null) {
            this.N.setOnClickListener(onClickListener);
            this.n.setOnClickListener(onClickListener);
            this.r.setOnClickListener(onClickListener);
            HotRankEntryView hotRankEntryView = this.M0;
            if (hotRankEntryView != null) {
                hotRankEntryView.setOnClickListener(onClickListener);
            }
            View view2 = this.G0;
            if (view2 != null) {
                view2.setOnClickListener(onClickListener);
            }
            View view3 = this.J0;
            if (view3 != null) {
                view3.setOnClickListener(onClickListener);
            }
            this.X0.d(onClickListener);
        }
    }

    public void J1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            boolean a2 = a2();
            this.w0 = a2;
            this.X0.b(a2);
            if (this.w0) {
                this.v.setVisibility(8);
                if (sq6.m(this.X)) {
                    this.x0.setVisibility(4);
                } else {
                    this.x0.setVisibility(0);
                }
                this.y0.setVisibility(0);
            } else {
                this.x0.setVisibility(8);
                this.y0.setVisibility(8);
                this.v.setVisibility(0);
                this.w.setOnClickListener(null);
            }
            TextView textView = this.e;
            if (textView != null) {
                textView.setText(StringHelper.numberUniformFormatExtraWithRoundInt(this.a0));
            }
            TextView textView2 = this.f;
            if (textView2 != null) {
                textView2.setText(StringHelper.numberUniformFormatExtraWithRoundInt(this.b0));
            }
            this.X0.j(this.a0, this.b0);
            this.X0.g(this.Z, this.V);
            ArrayList<bo4> arrayList = this.P;
            if (arrayList != null && arrayList.size() > 0) {
                this.T = UtilHelper.getFixedText(this.T, 7);
            } else if (this.k0) {
                this.T = UtilHelper.getFixedText(this.T, 6);
            }
            String b0 = qd6.b0(this.T);
            TextView textView3 = this.g;
            if (textView3 != null) {
                textView3.setText(b0);
            }
            TextView textView4 = this.n;
            if (textView4 != null) {
                textView4.setText(b0);
            }
            this.X0.k(this.t0, b0);
            N1();
            G();
            I1(TbadkCoreApplication.getInst().getSkinType());
            t1();
        }
    }

    @Override // com.repackage.nr6
    public void K(ForumData forumData, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048594, this, forumData, frsViewData) == null) || forumData == null) {
            return;
        }
        boolean z = true;
        this.n1 = true;
        if (sq6.m(this.X)) {
            K1();
        }
        this.T = forumData.getName();
        this.U = forumData.getId();
        this.a0 = forumData.getMember_num();
        this.b0 = forumData.getPost_num();
        forumData.getTag_color();
        this.t0 = forumData.getImage_url();
        this.V = forumData.getLevelName();
        this.Z = forumData.getUser_level();
        if (forumData.getSignData() != null) {
            int i2 = forumData.getSignData().count_sign_num;
            this.c0 = forumData.getSignData().miss_sign_num;
        }
        this.d0 = forumData.getCurScore();
        this.e0 = forumData.getLevelupScore();
        this.P = forumData.getBadgeData();
        this.W = forumData.getAccelerateContent();
        this.k0 = forumData.isBrandForum;
        this.X = frsViewData;
        if (!StringUtils.isNull(this.U) && !StringUtils.isNull(this.T)) {
            this.d.setVisibility(0);
        } else {
            this.d.setVisibility(8);
        }
        FrsViewData frsViewData2 = this.X;
        if (frsViewData2 != null && frsViewData2.getHotUserRankData() != null && this.X.getHotUserRankData().hot_user != null && this.X.getHotUserRankData().hot_user.size() >= 3) {
            this.x.setHasHotRankList(true);
        } else {
            this.x.setHasHotRankList(false);
        }
        int n2 = this.X0.n(LogicField.SERVICE_AREA);
        FrsViewData frsViewData3 = this.X;
        if ((frsViewData3 == null || frsViewData3.serviceAreaData == null) && !this.x.a()) {
            z = false;
        }
        if (n2 == 0 && z) {
            this.x.setVisibility(0);
            this.C0.setVisibility(0);
            ServiceAreaView serviceAreaView = this.x;
            FrsViewData frsViewData4 = this.X;
            serviceAreaView.setData(frsViewData4.serviceAreaData, frsViewData4);
        } else {
            this.x.setVisibility(8);
            this.C0.setVisibility(8);
        }
        this.Y = new ThreadData();
        T1();
        J1();
        if (this.X.getActivityHeadData() != null && this.X.getActivityHeadData().a() != null) {
            ArrayList<ro4> b2 = this.X.getActivityHeadData().b();
            this.F0 = go6.d(this.d, E1(ListUtils.isEmpty(b2) ? null : b2.get(0)));
            if (this.w0 && this.X.getActivityHeadData().a().h) {
                this.F0.setVisibility(0);
            } else {
                this.F0.setVisibility(8);
            }
        }
        Y1(forumData);
        if (frsViewData != null) {
            this.G = frsViewData.mSignActivityInfo;
            v1();
        }
    }

    public final void K1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.b1.setVisibility(0);
            X1(null, -1);
            D1();
            TbVideoView tbVideoView = this.a1;
            if (tbVideoView != null) {
                tbVideoView.stop();
            }
            this.a1.setVisibility(8);
        }
    }

    public final void L1(String str, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048596, this, str, j2) == null) {
            this.F = false;
            ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1);
            this.R0 = newScheduledThreadPool;
            newScheduledThreadPool.schedule(new g(this, str), j2, TimeUnit.SECONDS);
        }
    }

    public final void M1(tn4 tn4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048597, this, tn4Var) == null) || tn4Var == null) {
            return;
        }
        if (!tn4Var.e()) {
            if (this.f1.getVisibility() != 8) {
                this.f1.setVisibility(8);
            }
            if (this.g1.getVisibility() != 8) {
                this.g1.setVisibility(8);
                if (this.g1.isAnimating()) {
                    this.g1.cancelAnimation();
                }
            }
        } else if (tn4Var.d() < tn4Var.b()) {
            this.f1.setText(R.string.obfuscated_res_0x7f0f1204);
            U1();
        } else if (tn4Var.d() < tn4Var.c()) {
            this.f1.setText(R.string.obfuscated_res_0x7f0f1203);
            U1();
        } else {
            this.f1.setText(R.string.obfuscated_res_0x7f0f1205);
            this.g1.setVisibility(4);
            if (this.g1.isAnimating()) {
                this.g1.cancelAnimation();
            }
        }
    }

    public void N1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            this.N.K(this.t0, 10, false);
        }
    }

    public void O1(cr4 cr4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, cr4Var) == null) {
            cr4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f036e, new b(this));
        }
    }

    public void P1(cr4 cr4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, cr4Var) == null) {
            cr4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0ccb, new c(this));
        }
    }

    public final int Q1(boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048601, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            int f2 = oi.f(this.a.getPageActivity(), R.dimen.tbds782);
            int B1 = B1(z, z2);
            S1(f2);
            int i2 = f2 + B1;
            this.w.setVisibility(0);
            this.a1.setVisibility(8);
            ((RelativeLayout.LayoutParams) this.w.getLayoutParams()).bottomMargin = B1;
            ((RelativeLayout.LayoutParams) this.x0.getLayoutParams()).bottomMargin = B1;
            if (B1 != 0) {
                ((RelativeLayout.LayoutParams) this.t.getLayoutParams()).topMargin = oi.f(this.a.getPageActivity(), R.dimen.tbds782) - oi.f(this.a.getPageActivity(), R.dimen.tbds282);
            } else {
                ((RelativeLayout.LayoutParams) this.t.getLayoutParams()).topMargin = oi.f(this.a.getPageActivity(), R.dimen.tbds493);
            }
            return i2;
        }
        return invokeCommon.intValue;
    }

    public void R1() {
        ar6 ar6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048602, this) == null) || (ar6Var = this.R) == null) {
            return;
        }
        ar6Var.n();
    }

    public final void S1(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i2) == null) {
            int f2 = oi.f(this.a.getPageActivity(), R.dimen.tbds130);
            if (this.B0.getVisibility() != 0) {
                f2 -= oi.f(this.a.getPageActivity(), R.dimen.tbds32);
            }
            ((RelativeLayout.LayoutParams) this.j1.getLayoutParams()).topMargin = i2 - f2;
        }
    }

    public void T1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            MediaData mediaData = new MediaData();
            mediaData.setType(3);
            mediaData.setPic(this.t0);
            this.Y.getMedias().add(mediaData);
        }
    }

    public final void U1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            TextView textView = this.f1;
            if (textView != null && textView.getVisibility() == 8) {
                this.f1.setVisibility(0);
            }
            TBLottieAnimationView tBLottieAnimationView = this.g1;
            if (tBLottieAnimationView != null) {
                if (tBLottieAnimationView.getVisibility() == 8 || this.g1.getVisibility() == 4) {
                    this.g1.setVisibility(0);
                    if (this.g1.isAnimating()) {
                        this.g1.cancelAnimation();
                    }
                    this.g1.setAnimation("frs_video_head_drag_hint_lottie.json");
                    this.g1.setRepeatCount(-1);
                    this.g1.playAnimation();
                }
            }
        }
    }

    @Override // com.repackage.nr6
    @SuppressLint({"ResourceAsColor"})
    public void V(View view2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048606, this, view2, z) == null) {
            if (this.f0 == 0 && TbadkCoreApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) != null) {
                if (TbadkCoreApplication.getInst().getIntentClass(MemberPayActivityConfig.class) == null || z) {
                    return;
                }
                View inflate = LayoutInflater.from(this.a.getContext()).inflate(R.layout.obfuscated_res_0x7f0d061b, (ViewGroup) null);
                TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090736);
                TextView textView2 = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091236);
                TextView textView3 = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091d48);
                SkinManager.setViewTextColor((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090949), R.color.CAM_X0105, 1);
                SkinManager.setViewTextColor(textView, R.color.CAM_X0105, 1);
                SkinManager.setViewTextColor(textView2, R.color.CAM_X0105, 1);
                SkinManager.setViewTextColor(textView3, R.color.CAM_X0105, 1);
                cr4 cr4Var = new cr4(this.a.getPageActivity());
                cr4Var.setContentView(inflate);
                L(textView, textView2);
                if (!TextUtils.isEmpty(this.W) && !TextUtils.isEmpty(this.W.trim())) {
                    textView3.setVisibility(0);
                    textView3.setText(this.W);
                } else {
                    textView3.setVisibility(8);
                }
                cr4Var.setButtonTextColor(R.color.CAM_X0305);
                O1(cr4Var);
                P1(cr4Var);
                cr4Var.create(this.a);
                cr4Var.show();
                return;
            }
            this.c.removeCallbacks(this.n0);
            if (this.H == null) {
                PopupWindow popupWindow = new PopupWindow(this.a.getPageActivity());
                this.H = popupWindow;
                popupWindow.setContentView(this.I);
                this.H.setBackgroundDrawable(new BitmapDrawable());
                this.H.setOutsideTouchable(true);
                this.H.setFocusable(true);
                this.H.setWidth(this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070280));
                this.H.setHeight(this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07019a));
            }
            this.J = (TextView) this.I.findViewById(R.id.obfuscated_res_0x7f090735);
            this.K = (TextView) this.I.findViewById(R.id.obfuscated_res_0x7f091235);
            SkinManager.setBackgroundResource(this.I.findViewById(R.id.obfuscated_res_0x7f090946), R.drawable.icon_frs_experience_number);
            SkinManager.setViewTextColor((TextView) this.I.findViewById(R.id.obfuscated_res_0x7f090945), R.color.CAM_X0111, 1);
            SkinManager.setViewTextColor(this.J, R.color.common_color_10047, 1);
            SkinManager.setViewTextColor(this.K, R.color.CAM_X0111, 1);
            L(this.J, this.K);
            if (this.H.isShowing()) {
                rg.d(this.H, this.a.getPageActivity());
                return;
            }
            int[] iArr = new int[2];
            view2.getLocationOnScreen(iArr);
            if (iArr[1] - this.H.getHeight() <= 50) {
                rg.d(this.H, this.a.getPageActivity());
                return;
            }
            PopupWindow popupWindow2 = this.H;
            rg.m(popupWindow2, this.d, 0, iArr[0], iArr[1] - popupWindow2.getHeight());
            this.H.update();
            this.c.postDelayed(this.n0, 2000L);
        }
    }

    public final void V1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            int k2 = oi.k(this.a.getPageActivity());
            int i2 = (k2 * 9) / 16;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.b1.getLayoutParams();
            layoutParams.width = k2;
            layoutParams.height = i2;
            this.b1.setLayoutParams(layoutParams);
            this.b1.setScaleType(ImageView.ScaleType.CENTER_CROP);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.c1.getLayoutParams();
            layoutParams2.width = k2;
            layoutParams2.height = i2;
            this.c1.setLayoutParams(layoutParams2);
        }
    }

    @Override // com.repackage.nr6
    public void W() {
        FrsViewData frsViewData;
        String string;
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048608, this) == null) || this.P0 == -1 || (frsViewData = this.X) == null || frsViewData.forumRule == null || frsViewData.getUserData() == null || this.A == null) {
            return;
        }
        if (this.X.getUserData().getIs_manager() == 1) {
            if (this.X.forumRule.has_forum_rule.intValue() == 1 || this.X.forumRule.audit_status.intValue() != 0) {
                return;
            }
            string = this.a.getString(R.string.obfuscated_res_0x7f0f0745);
            str = "key_forum_rule_first_show_frs_manager";
        } else {
            string = this.a.getString(R.string.obfuscated_res_0x7f0f0746);
            str = "key_forum_rule_first_show_frs";
        }
        View view2 = null;
        if (this.A.getmTopViews() != null && this.A.getmTopViews().size() > 0 && (this.A.getmTopViews().get(0) instanceof AdapterLinearLayout)) {
            AdapterLinearLayout adapterLinearLayout = (AdapterLinearLayout) this.A.getmTopViews().get(0);
            if (this.P0 < adapterLinearLayout.getChildCount()) {
                view2 = adapterLinearLayout.getChildAt(this.P0);
            }
        }
        if (this.O0 != null || view2 == null) {
            return;
        }
        nz5 nz5Var = new nz5(this.a, view2);
        this.O0 = nz5Var;
        nz5Var.g0(R.drawable.obfuscated_res_0x7f0802f2);
        this.O0.O(16);
        this.O0.U(true);
        this.O0.j0(UtilHelper.getDimenPixelSize(R.dimen.tbds128));
        this.O0.k0(UtilHelper.getDimenPixelSize(R.dimen.tbds_10));
        this.O0.h0(true);
        this.O0.N(4000);
        if (this.O0.J() || this.b.D2()) {
            return;
        }
        this.O0.m0(string, str);
    }

    public final int W1(boolean z, boolean z2) {
        InterceptResult invokeCommon;
        int f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048609, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            int H1 = H1();
            V1();
            int B1 = B1(z, z2);
            if (go6.c()) {
                this.k1.setVisibility(8);
                this.l1.setVisibility(8);
                f2 = 0;
            } else {
                this.k1.setVisibility(0);
                this.l1.setVisibility(0);
                f2 = oi.f(this.a.getPageActivity(), R.dimen.tbds96);
            }
            int i2 = B1 + H1 + f2;
            this.w.setVisibility(8);
            this.a1.setVisibility(0);
            ((RelativeLayout.LayoutParams) this.t.getLayoutParams()).topMargin = (H1 - oi.f(this.a.getPageActivity(), R.dimen.tbds282)) + f2;
            S1(H1 + f2);
            return i2;
        }
        return invokeCommon.intValue;
    }

    public final void X1(ro4 ro4Var, int i2) {
        String b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048610, this, ro4Var, i2) == null) {
            if (i2 == -1) {
                b2 = jq6.c(this.X);
            } else {
                b2 = jq6.b(ro4Var, i2);
            }
            if (StringUtils.isNull(b2)) {
                return;
            }
            int b3 = kd7.b(b2);
            this.l1.setGradientColors(0, b3);
            this.k1.setBackgroundColor(b3);
        }
    }

    @Override // com.repackage.nr6
    public void Y() {
        View contentView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            PopupWindow popupWindow = this.M;
            if (popupWindow == null) {
                this.M = new PopupWindow(this.a.getPageActivity());
                contentView = LayoutInflater.from(this.a.getContext()).inflate(R.layout.obfuscated_res_0x7f0d078c, (ViewGroup) null);
                this.M.setContentView(contentView);
                contentView.setOnClickListener(new d(this));
                this.M.setWidth(this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07029c));
                this.M.setHeight(this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070309));
                this.M.setBackgroundDrawable(new BitmapDrawable());
                this.M.setOutsideTouchable(true);
                this.M.setTouchInterceptor(new e(this));
            } else {
                contentView = popupWindow.getContentView();
            }
            SkinManager.setViewTextColor((TextView) contentView.findViewById(R.id.obfuscated_res_0x7f0913c2), R.color.CAM_X0101, 1);
            SkinManager.setViewTextColor((TextView) contentView.findViewById(R.id.obfuscated_res_0x7f091d40), R.color.CAM_X0305, 1);
            SkinManager.setViewTextColor((TextView) contentView.findViewById(R.id.obfuscated_res_0x7f091efb), R.color.CAM_X0101, 1);
            int[] iArr = new int[2];
            this.L.getLocationOnScreen(iArr);
            PopupWindow popupWindow2 = this.M;
            rg.m(popupWindow2, this.d, 0, (iArr[0] - (popupWindow2.getWidth() / 2)) + (this.L.getWidth() / 2), iArr[1] + this.L.getWidth());
            this.M.update();
        }
    }

    public final void Y1(ForumData forumData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, forumData) == null) {
            if (forumData.getManagers() != null && forumData.getManagers().size() > 0) {
                String str = forumData.getManagers().get(0).show_name;
                if (TextUtils.isEmpty(str)) {
                    str = forumData.getManagers().get(0).name;
                }
                if (!TextUtils.isEmpty(str)) {
                    this.I0.setText(str);
                    this.H0.K(forumData.getManagers().get(0).portrait, 12, false);
                    this.G0.setVisibility(0);
                } else {
                    this.G0.setVisibility(8);
                }
                if (this.J0.getVisibility() == 0) {
                    this.J0.setVisibility(8);
                    return;
                }
                return;
            }
            if (this.G0.getVisibility() == 0) {
                this.G0.setVisibility(8);
            }
            if (this.J0.getVisibility() == 8) {
                this.J0.setVisibility(0);
            }
        }
    }

    public final void Z1(List<uo> list, mj8 mj8Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048613, this, list, mj8Var) == null) || this.A == null) {
            return;
        }
        this.N0 = list;
        FrsViewData frsViewData = this.X;
        if (frsViewData != null && frsViewData.getVoiceRoomData() != null && this.X.getVoiceRoomData().a().size() > 0) {
            this.D.setVisibility(0);
            this.D.setPageContext(this.a);
            if (!ListUtils.isEmpty(this.X.getVoiceRoomData().a())) {
                if (this.X.getVoiceRoomData().a().size() > 5) {
                    this.D.setShowMore(true);
                } else {
                    this.D.setShowMore(false);
                }
            }
            this.D.a(this.X.getVoiceRoomData());
        } else {
            FrsVoiceRoomListLayout frsVoiceRoomListLayout = this.D;
            if (frsVoiceRoomListLayout != null && frsVoiceRoomListLayout.getVisibility() == 0) {
                this.D.setVisibility(8);
            }
        }
        if (mj8Var != null) {
            this.z = new ig6(this.a.getPageActivity());
            this.y.setVisibility(0);
            this.y.addView(this.z.f());
            FrsViewData frsViewData2 = this.X;
            ForumData forum = frsViewData2 != null ? frsViewData2.getForum() : null;
            ig6 ig6Var = this.z;
            FrsViewData frsViewData3 = this.X;
            ig6Var.e(forum, mj8Var, frsViewData3 == null || frsViewData3.isFromCache);
            w1(mj8Var);
        } else {
            this.y.setVisibility(8);
        }
        FrsVoiceRoomListLayout frsVoiceRoomListLayout2 = this.D;
        if (frsVoiceRoomListLayout2 != null && frsVoiceRoomListLayout2.getVisibility() == 0) {
            this.E0.setVisibility(8);
        } else {
            this.E0.setVisibility(this.X0.n(LogicField.TOP_DIVIDER));
        }
        FrsFragment frsFragment = this.b;
        if (frsFragment != null && frsFragment.a3()) {
            this.A.setVisibility(0);
            this.A.setFragmentUniqueId(this.b.getUniqueId());
            FrsViewData frsViewData4 = this.X;
            ForumData forum2 = frsViewData4 != null ? frsViewData4.getForum() : null;
            FrsViewData frsViewData5 = this.X;
            this.A.setForum(this.U, this.T, forum2, frsViewData5 != null ? frsViewData5.getUserData() : null, this.b.x2());
            if (list.size() > 0 && (list.get(0) instanceof vj8)) {
                this.P0 = 0;
            } else if (list.size() > 1 && (list.get(1) instanceof vj8)) {
                this.P0 = 1;
            } else {
                this.P0 = -1;
            }
            this.A.setDatas(list, mj8Var);
            if (this.v0 == null) {
                this.v0 = new l(this);
            }
            this.A.setStatListener(this.v0);
            return;
        }
        this.A.setVisibility(8);
        BdTypeRecyclerView bdTypeRecyclerView = this.Z0;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.removeHeaderView(this.A);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:60:? A[RETURN, SYNTHETIC] */
    @Override // com.repackage.nr6
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a() {
        int i2;
        int i3;
        int i4;
        int i5;
        FrsLikeRecommendLayout frsLikeRecommendLayout;
        ViewGroup.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(1048614, this) != null) {
            return;
        }
        int i6 = 0;
        ViewCommonUtil.setViewMargin(this.A0, -1, 0, -1, -1);
        boolean z = true;
        boolean z2 = this.y.getVisibility() == 0;
        boolean z3 = this.D.getVisibility() == 0;
        View m2 = this.X0.m();
        z = (m2 == null || m2.getVisibility() != 0) ? false : false;
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds24);
        int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.tbds15);
        if (z) {
            ViewCommonUtil.setViewMargin(m2, -1, -1, -1, z2 ? dimenPixelSize2 : dimenPixelSize);
        } else if (z2) {
            i2 = dimenPixelSize2;
            ViewCommonUtil.setViewPadding(this.A0, -1, i2, -1, -1);
            int o0 = this.b.w0().o0();
            if (this.w0) {
                i5 = o0 + oo6.o;
                if (z2 || z3 || z) {
                    ViewCommonUtil.setViewMargin(this.A0, -1, UtilHelper.getDimenPixelSize(R.dimen.tbds55), -1, -1);
                }
            } else {
                if (sq6.m(this.X)) {
                    i3 = H1();
                    V1();
                    this.w.setVisibility(8);
                    this.a1.setVisibility(0);
                    S1(i3);
                } else {
                    i3 = oo6.p + o0;
                    this.w.setVisibility(0);
                    this.a1.setVisibility(8);
                    S1(i3);
                }
                if (z2) {
                    i6 = UtilHelper.getDimenPixelSize(R.dimen.tbds231) + 0;
                    i4 = 0 + dimenPixelSize2;
                } else {
                    i4 = 0;
                }
                if (z3) {
                    i6 += UtilHelper.getDimenPixelSize(R.dimen.tbds282);
                    if (i4 == 0) {
                        i4 += dimenPixelSize;
                    }
                }
                int i7 = i6 + (i4 * 2);
                ViewCommonUtil.setViewMargin(this.w, -1, -1, -1, i7);
                ViewCommonUtil.setViewMargin(this.x0, -1, -1, -1, i7);
                ViewCommonUtil.setViewMargin(this.t, -1, i3, -1, -1);
                i5 = i3 + i7;
            }
            frsLikeRecommendLayout = this.S;
            if (frsLikeRecommendLayout != null && frsLikeRecommendLayout.getVisibility() == 0) {
                i5 += this.S.getCurrentHeight();
            }
            layoutParams = this.u.getLayoutParams();
            if (layoutParams.height == i5) {
                layoutParams.height = i5;
                this.u.setLayoutParams(layoutParams);
                FrsFragment frsFragment = this.b;
                if (frsFragment != null) {
                    frsFragment.l3();
                    return;
                }
                return;
            }
            return;
        }
        i2 = dimenPixelSize;
        ViewCommonUtil.setViewPadding(this.A0, -1, i2, -1, -1);
        int o02 = this.b.w0().o0();
        if (this.w0) {
        }
        frsLikeRecommendLayout = this.S;
        if (frsLikeRecommendLayout != null) {
            i5 += this.S.getCurrentHeight();
        }
        layoutParams = this.u.getLayoutParams();
        if (layoutParams.height == i5) {
        }
    }

    @Override // com.repackage.nr6
    public void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
        }
    }

    public final boolean a2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            FrsViewData frsViewData = this.X;
            if (frsViewData == null) {
                return false;
            }
            ro4 ro4Var = null;
            if (frsViewData.getStar() != null && !StringUtils.isNull(frsViewData.getStar().a())) {
                ro4Var = new ro4();
                ro4Var.s("");
                ro4Var.r(frsViewData.getStar().a());
            } else if (frsViewData.getActivityHeadData() != null && ListUtils.getCount(frsViewData.getActivityHeadData().b()) >= 1) {
                ro4Var = frsViewData.getActivityHeadData().b().get(0);
            }
            if (ro4Var != null) {
                if (E1(ro4Var)) {
                    d2(frsViewData, ro4Var);
                } else {
                    b2(frsViewData, ro4Var);
                }
                ThirdStatisticHelper.sendReq((String) ListUtils.getItem(ro4Var.n(), 0));
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void b2(FrsViewData frsViewData, ro4 ro4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048617, this, frsViewData, ro4Var) == null) || this.w == null || ro4Var == null) {
            return;
        }
        if (frsViewData != null && frsViewData.getForum() != null && !TextUtils.isEmpty(frsViewData.getForum().getId()) && frsViewData.getActivityHeadData() != null && !TextUtils.isEmpty(frsViewData.getActivityHeadData().c())) {
            StatisticItem statisticItem = new StatisticItem("c13326");
            statisticItem.param("fid", frsViewData.getForum().getId());
            statisticItem.param("obj_id", frsViewData.getActivityHeadData().c());
            TiebaStatic.log(statisticItem);
            if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                statisticItem.param("ab_tag", TbadkCoreApplication.getInst().getAdAdSense().n);
            }
            jq6.e(frsViewData, 1, this.b.getUniqueId());
        }
        this.w.K(ro4Var.f(), 10, false);
        this.w.setOnClickListener(new a(this, ro4Var, frsViewData));
    }

    @Override // com.repackage.nr6
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            this.X0.l(LogicField.BRAND_LABEL, 0);
            this.o.setVisibility(0);
        }
    }

    @Override // com.repackage.nr6
    public void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            if (this.f0 != 0) {
                SkinManager.setImageResource(this.L, R.drawable.icon_sml_speed_orange);
            } else {
                SkinManager.setImageResource(this.L, R.drawable.icon_sml_speed_gray);
            }
        }
    }

    public final void c2() {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048620, this) == null) || (tBLottieAnimationView = this.e1) == null) {
            return;
        }
        if (tBLottieAnimationView.getVisibility() == 8 || this.e1.getVisibility() == 4) {
            this.e1.setVisibility(0);
            if (this.e1.isAnimating()) {
                this.e1.cancelAnimation();
            }
            this.e1.setAnimation(R.raw.obfuscated_res_0x7f110018);
            this.e1.setRepeatCount(-1);
            this.e1.playAnimation();
        }
    }

    @Override // com.repackage.nr6
    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048621, this, i2) == null) {
            this.X0.onChangeSkinType(i2);
            this.a.getLayoutMode().k(i2 == 1);
            this.a.getLayoutMode().j(this.d);
            this.a.getLayoutMode().j(this.I);
            this.a.getLayoutMode().j(this.m);
            SkinManager.setBackgroundResource(this.k, R.drawable.obfuscated_res_0x7f08058b);
            vr4 d2 = vr4.d(this.B0);
            d2.m(1);
            d2.n(R.string.J_X14);
            d2.f(R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.C0, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.D0, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.B, R.color.CAM_X0624);
            SkinManager.setBackgroundColor(this.E0, R.color.CAM_X0201);
            SkinManager.setBackgroundColor(this.l, R.color.CAM_X0101);
            SkinManager.setBackgroundColor(this.t, R.color.black_alpha0);
            SkinManager.setBackgroundColor(this.q0, R.color.CAM_X0204);
            SkinManager.setViewTextColor(this.n, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.s, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.j, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.r0, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.e, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.s0, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.f, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.I0, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.L0, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.f, (int) R.color.CAM_X0101);
            vr4 d3 = vr4.d(this.f1);
            d3.v(R.color.CAM_X0101);
            d3.z(R.dimen.T_X09);
            vr4 d4 = vr4.d(this.E);
            d4.A(R.string.F_X01);
            d4.v(R.color.CAM_X0101);
            BarImageView barImageView = this.N;
            if (barImageView != null) {
                barImageView.setBorderWidth(oi.f(this.a.getPageActivity(), R.dimen.tbds1));
                this.N.setBorderColor(SkinManager.getColor(R.color.CAM_X0603));
                this.N.setStrokeColorResId(R.color.CAM_X0201);
                this.N.setPlaceHolder(1);
                this.N.invalidate();
            }
            HeadImageView headImageView = this.H0;
            if (headImageView != null) {
                headImageView.invalidate();
            }
            UserIconBox userIconBox = this.O;
            if (userIconBox != null) {
                userIconBox.i(i2);
            }
            LinearGradientView linearGradientView = this.v;
            if (linearGradientView != null) {
                linearGradientView.a(i2);
            }
            FrsLikeRecommendLayout frsLikeRecommendLayout = this.S;
            if (frsLikeRecommendLayout != null) {
                frsLikeRecommendLayout.onChangeSkinType(this.a, i2);
            }
            Iterator<TbImageView> it = this.u0.iterator();
            while (it.hasNext()) {
                it.next().invalidate();
            }
            c0();
            O(this.i0 ? 1 : 0);
            R1();
            I1(i2);
            s1(F1(), G1());
            ServiceAreaView serviceAreaView = this.x;
            if (serviceAreaView != null) {
                serviceAreaView.b(i2);
            }
            FrsTopView frsTopView = this.A;
            if (frsTopView != null) {
                frsTopView.h(i2);
            }
            ig6 ig6Var = this.z;
            if (ig6Var != null) {
                ig6Var.h(i2);
            }
            HotRankEntryView hotRankEntryView = this.M0;
            if (hotRankEntryView != null) {
                hotRankEntryView.b(i2);
            }
            FrsVoiceRoomListLayout frsVoiceRoomListLayout = this.D;
            if (frsVoiceRoomListLayout != null) {
                frsVoiceRoomListLayout.onChangeSkinType(this.a, i2);
            }
        }
    }

    public final void d2(FrsViewData frsViewData, ro4 ro4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048622, this, frsViewData, ro4Var) == null) {
            this.b1.setVisibility(0);
            X1(null, -1);
            this.b1.K(ro4Var.e(), 10, false);
            if (this.a1.getVisibility() != 0) {
                this.a1.setVisibility(0);
            }
            this.a1.setVideoPath(ro4Var.j());
            this.a1.setVolume(0.0f, 0.0f);
            this.a1.setVideoScalingMode(0);
            this.a1.K(true);
            this.a1.setLooping(false);
            this.a1.setVideoStatusChangeListener(new m(this, ro4Var, frsViewData));
            this.a1.getMediaProgressObserver().j(new n(this, ro4Var));
            if (jq6.f()) {
                this.d1.setVisibility(8);
                FrsFragment frsFragment = this.b;
                if (frsFragment != null && !this.X.isFromCache && (this.m1 || (!frsFragment.X2() && !this.b.W2()))) {
                    this.a1.start();
                }
            } else {
                this.d1.setVisibility(0);
            }
            this.b1.setOnClickListener(new o(this, ro4Var, frsViewData));
            this.a1.setOnClickListener(new p(this, ro4Var, frsViewData));
            FrsFragment frsFragment2 = this.b;
            if (frsFragment2 != null) {
                jq6.e(frsViewData, 2, frsFragment2.getUniqueId());
            }
        }
    }

    public final void e2(String str, long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048623, this, new Object[]{str, Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            this.F = true;
            this.V0 = new f(this, j2, j3, str).start();
            if (this.Q == null || j()) {
                return;
            }
            this.Q.q(this.F);
        }
    }

    @Override // com.repackage.nr6
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            SignActivityInfo signActivityInfo = this.G;
            if (signActivityInfo != null) {
                return String.valueOf(signActivityInfo.activity_id);
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.repackage.nr6
    public SignActivityInfo l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) ? this.G : (SignActivityInfo) invokeV.objValue;
    }

    @Override // com.repackage.nr6
    public void o() {
        nz5 nz5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048626, this) == null) || (nz5Var = this.O0) == null) {
            return;
        }
        nz5Var.I();
        this.P0 = -1;
    }

    @Override // com.repackage.nr6
    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) ? this.w0 : invokeV.booleanValue;
    }

    public final void s1(boolean z, boolean z2) {
        int f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048628, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (go6.c()) {
                a();
                return;
            }
            RelativeLayout relativeLayout = this.u;
            if (relativeLayout == null || relativeLayout.getLayoutParams() == null) {
                return;
            }
            if (this.M0.getVisibility() == 0) {
                f2 = oi.f(this.a.getPageActivity(), R.dimen.tbds704);
                ((RelativeLayout.LayoutParams) this.t.getLayoutParams()).topMargin = oi.f(this.a.getPageActivity(), R.dimen.tbds384);
                ((RelativeLayout.LayoutParams) this.M0.getLayoutParams()).topMargin = (oi.f(this.a.getPageActivity(), R.dimen.tbds226) + oi.r(this.a.getPageActivity())) - oi.f(this.a.getPageActivity(), R.dimen.tbds72);
            } else {
                f2 = oi.f(this.a.getPageActivity(), R.dimen.tbds600);
            }
            if (!z && !z2 && !this.w0) {
                f2 -= oi.f(this.a.getPageActivity(), R.dimen.tbds80);
            } else if (this.w0) {
                if (sq6.m(this.X)) {
                    f2 = W1(z, z2);
                } else {
                    f2 = Q1(z, z2);
                }
            }
            ViewGroup.LayoutParams layoutParams = this.u.getLayoutParams();
            if (layoutParams.height != f2) {
                layoutParams.height = f2;
                this.u.setLayoutParams(layoutParams);
            }
        }
    }

    @Override // com.repackage.nr6
    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) ? this.F : invokeV.booleanValue;
    }

    public final void t1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048630, this) == null) {
            boolean F1 = F1();
            boolean G1 = G1();
            if (!TextUtils.isEmpty(this.T)) {
                wp6 c2 = vp6.d().c(this.T);
                if (c2 == null) {
                    c2 = new wp6(this.z0, F1);
                } else {
                    c2.d(this.z0);
                    c2.e(F1);
                }
                vp6.d().e(this.T, c2);
            }
            u1(F1, G1);
            s1(F1, G1);
        }
    }

    public final void u1(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048631, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || this.b.I2() == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.A0.getLayoutParams();
        if (!z && !z2) {
            this.A0.setVisibility(0);
            this.C0.setVisibility(8);
            this.D0.setVisibility(this.X0.n(LogicField.BANNER_AND_BOTTOM_VIEW));
            layoutParams.topMargin = oi.f(this.a.getPageActivity(), R.dimen.tbds50);
        } else {
            this.A0.setVisibility(0);
            this.C0.setVisibility(this.X0.n(LogicField.SERVICE_AREA));
            layoutParams.topMargin = oi.f(this.a.getPageActivity(), R.dimen.tbds55);
        }
        this.b.I2().u(z, z2);
    }

    public final void v1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048632, this) == null) || this.G == null) {
            return;
        }
        CountDownTimer countDownTimer = this.V0;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.V0.onFinish();
        }
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        this.S0 = ((long) (this.G.activity_time.intValue() + this.G.activity_duration.intValue())) - currentTimeMillis < 0;
        this.T0 = ((long) this.G.activity_time.intValue()) - currentTimeMillis <= 0;
        this.U0 = ((long) (this.G.activity_time.intValue() - this.G.countdown_time.intValue())) - currentTimeMillis <= 0;
        boolean z = this.S0;
        if (z) {
            this.E.setVisibility(8);
            return;
        }
        if (this.T0 && !z) {
            e2(this.G.activity_msg, 1000 * ((this.G.activity_time.intValue() + this.G.activity_duration.intValue()) - currentTimeMillis), this.Q0);
        }
        if (!this.T0 && this.U0) {
            this.E.setVisibility(0);
            this.E.setText(this.G.countdown_msg);
            SignActivityInfo signActivityInfo = this.G;
            L1(signActivityInfo.activity_msg, signActivityInfo.activity_time.intValue() - currentTimeMillis);
        }
        if (this.U0) {
            return;
        }
        SignActivityInfo signActivityInfo2 = this.G;
        L1(signActivityInfo2.countdown_msg, (signActivityInfo2.activity_time.intValue() - this.G.countdown_time.intValue()) - currentTimeMillis);
    }

    public final void w1(mj8 mj8Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048633, this, mj8Var) == null) || mj8Var == null || this.X == null || this.W0) {
            return;
        }
        this.W0 = true;
        StatisticItem statisticItem = new StatisticItem("common_exp");
        statisticItem.param("page_type", "a006");
        statisticItem.param(TiebaStatic.Params.OBJ_ISAD, "1");
        int i2 = 6;
        if (mj8Var.getType() != 1) {
            if (mj8Var.getType() == 2) {
                i2 = 7;
            } else if (mj8Var.getType() == 3) {
                i2 = 8;
            } else if (mj8Var.getType() == 4) {
                i2 = 21;
            }
        }
        statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, 1);
        statisticItem.param(TiebaStatic.Params.OBJ_AD_LOCATE, i2);
        statisticItem.param("obj_id", mj8Var.c());
        ForumData forum = this.X.getForum();
        if (forum != null) {
            statisticItem.param("fid", forum.getId());
            statisticItem.param("fname", forum.getName());
            statisticItem.param(TiebaStatic.Params.FIRST_DIR, forum.getFirst_class());
            statisticItem.param(TiebaStatic.Params.SECOND_DIR, forum.getSecond_class());
        }
        if (mj8Var.getType() == 1) {
            statisticItem.param("tid", mj8Var.l());
            statisticItem.param("thread_type", mj8Var.m());
        }
        if (StringUtils.isNull(mj8Var.p())) {
            statisticItem.param("obj_type", 1);
        } else {
            statisticItem.param("obj_type", 2);
        }
        TiebaStatic.log(statisticItem);
    }

    @Override // com.repackage.nr6
    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048634, this) == null) {
            super.x();
            Handler handler = this.c;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            PopupWindow popupWindow = this.M;
            if (popupWindow != null && popupWindow.isShowing()) {
                this.M.dismiss();
            }
            o();
            ig6 ig6Var = this.z;
            if (ig6Var != null) {
                ig6Var.i();
            }
            CountDownTimer countDownTimer = this.V0;
            if (countDownTimer != null) {
                countDownTimer.cancel();
                this.V0 = null;
            }
            MessageManager.getInstance().unRegisterListener(this.o1);
            MessageManager.getInstance().unRegisterListener(this.p1);
            MessageManager.getInstance().unRegisterListener(this.q1);
            MessageManager.getInstance().unRegisterListener(this.r1);
        }
    }

    @NonNull
    public ho6 x1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) ? this.X0 : (ho6) invokeV.objValue;
    }

    @Override // com.repackage.nr6
    public void y(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048636, this, z) == null) {
            this.X0.c(z);
        }
    }

    public View y1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) ? LayoutInflater.from(this.b.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0348, (ViewGroup) null) : (View) invokeV.objValue;
    }

    @Override // com.repackage.nr6
    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048638, this) == null) {
            super.z();
            if (sq6.m(this.X)) {
                K1();
            }
            ig6 ig6Var = this.z;
            if (ig6Var != null) {
                ig6Var.j();
            }
        }
    }

    public final int[] z1(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048639, this, i2)) == null) ? i2 <= 3 ? new int[]{-8331843, -10499102} : i2 <= 9 ? new int[]{-10499102, -154262} : i2 <= 15 ? new int[]{-154262, -148180} : new int[]{-148180, -100818} : (int[]) invokeI.objValue;
    }
}

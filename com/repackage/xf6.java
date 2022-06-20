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
import com.repackage.k58;
import com.repackage.nq4;
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
/* loaded from: classes7.dex */
public class xf6 extends wp6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View A0;
    public boolean B0;
    public LinearLayout C0;
    public View D0;
    public View E0;
    public View F0;
    public View G0;
    public TextView H0;
    public final View I0;
    public final HeadImageView J0;
    public final TextView K0;
    public final View L0;
    public final ImageView M0;
    public final TextView N0;
    public HotRankEntryView O0;
    public List<nn> P0;
    public zy5 Q0;
    public int R0;
    public long S0;
    public ScheduledExecutorService T0;
    public boolean U0;
    public boolean V0;
    public boolean W0;
    public CountDownTimer X0;
    public boolean Y0;
    @NonNull
    public final rm6 Z0;
    @NonNull
    public final wm6 a1;
    @Nullable
    public BdTypeRecyclerView b1;
    public TbVideoView c1;
    public TbImageView d1;
    public View e1;
    public View f1;
    public TBLottieAnimationView g1;
    public TextView h1;
    public TBLottieAnimationView i1;
    public View j1;
    public View k1;
    public View l1;
    public View m1;
    public FrsHeaderVideoImageShadeView n1;
    public boolean o1;
    public boolean p1;
    public CustomMessageListener q1;
    public CustomMessageListener r1;
    public RelativeLayout s0;
    public CustomMessageListener s1;
    public TextView t0;
    public CustomMessageListener t1;
    public TextView u0;
    public String v0;
    public ArrayList<TbImageView> w0;
    public td6 x0;
    public boolean y0;
    public View z0;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ao4 a;
        public final /* synthetic */ FrsViewData b;
        public final /* synthetic */ xf6 c;

        public a(xf6 xf6Var, ao4 ao4Var, FrsViewData frsViewData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xf6Var, ao4Var, frsViewData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = xf6Var;
            this.a = ao4Var;
            this.b = frsViewData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.c.a == null || ff5.a(this.c.a.getPageActivity(), this.a.h()) || TextUtils.isEmpty(this.a.g())) {
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
                    statisticItem.param("ab_tag", TbadkCoreApplication.getInst().getAdAdSense().k);
                }
                to6.d(this.b, 1, this.c.b.getUniqueId());
            }
            vo6.b(this.c.a, this.a.k(), this.a.g(), this.a.i());
            ThirdStatisticHelper.sendReq((String) ListUtils.getItem(this.a.n(), 1));
        }
    }

    /* loaded from: classes7.dex */
    public class b implements nq4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(xf6 xf6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xf6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.nq4.e
        public void onClick(nq4 nq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nq4Var) == null) {
                nq4Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements nq4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xf6 a;

        public c(xf6 xf6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xf6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xf6Var;
        }

        @Override // com.repackage.nq4.e
        public void onClick(nq4 nq4Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, nq4Var) == null) || this.a.a == null || this.a.a.getPageActivity() == null) {
                return;
            }
            MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(this.a.a.getPageActivity(), this.a.f0, "exp_acce", 2);
            memberPayActivityConfig.setSceneId("4004001000");
            memberPayActivityConfig.setReferPageClickZone(MemberPayStatistic.REFER_PAGE_FRS, MemberPayStatistic.CLICK_ZONE_POP_UPS_OPENDE_BUTTON);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
            nq4Var.dismiss();
        }
    }

    /* loaded from: classes7.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xf6 a;

        public d(xf6 xf6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xf6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xf6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.a == null || this.a.a.getPageActivity() == null) {
                return;
            }
            sg.d(this.a.M, this.a.a.getPageActivity());
            this.a.b.c = false;
            cl4.s(this.a.a.getPageActivity(), this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f05cb), TbConfig.SERVER_ADDRESS_WEB_VIEW + "mo/q/tbeanrights?type=7&_client_version=" + TbConfig.getVersion() + "&nohead=1", true, true, true);
        }
    }

    /* loaded from: classes7.dex */
    public class e implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xf6 a;

        public e(xf6 xf6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xf6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xf6Var;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                if (motionEvent.getAction() == 4) {
                    sg.c(this.a.M);
                    this.a.b.c = false;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class f extends CountDownTimer {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ xf6 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(xf6 xf6Var, long j, long j2, String str) {
            super(j, j2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xf6Var, Long.valueOf(j), Long.valueOf(j2), str};
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
            this.b = xf6Var;
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

    /* loaded from: classes7.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ xf6 b;

        /* loaded from: classes7.dex */
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
                        xf6 xf6Var = this.a.b;
                        xf6Var.N1(xf6Var.G.activity_msg, this.a.b.G.countdown_time.intValue());
                    }
                } else if (this.a.b.E.getVisibility() == 0) {
                    this.a.b.x1();
                }
            }
        }

        public g(xf6 xf6Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xf6Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = xf6Var;
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                qg.a().post(new a(this));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xf6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(xf6 xf6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xf6Var, Integer.valueOf(i)};
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
            this.a = xf6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof cn4)) {
                cn4 cn4Var = (cn4) customResponsedMessage.getData();
                this.a.O1(cn4Var);
                this.a.E1(cn4Var);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xf6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(xf6 xf6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xf6Var, Integer.valueOf(i)};
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
            this.a = xf6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && cp6.m(this.a.X)) {
                this.a.M1();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xf6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(xf6 xf6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xf6Var, Integer.valueOf(i)};
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
            this.a = xf6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                if (intValue == 1) {
                    if (cp6.m(this.a.X) && this.a.c1.getVisibility() == 0) {
                        this.a.M1();
                    }
                    this.a.p1 = false;
                } else if (intValue == 2 && cp6.m(this.a.X)) {
                    if (!this.a.p1) {
                        xf6 xf6Var = this.a;
                        xf6Var.K(xf6Var.X.getForum(), this.a.X);
                    }
                    this.a.p1 = false;
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class k extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xf6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(xf6 xf6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xf6Var, Integer.valueOf(i)};
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
            this.a = xf6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                this.a.o1 = true;
                if (intValue == 1) {
                    if (FrsFragment.k2 || !cp6.m(this.a.X)) {
                        return;
                    }
                    xf6 xf6Var = this.a;
                    xf6Var.K(xf6Var.X.getForum(), this.a.X);
                } else if (intValue == 2) {
                    if (cp6.m(this.a.X)) {
                        xf6 xf6Var2 = this.a;
                        xf6Var2.K(xf6Var2.X.getForum(), this.a.X);
                    }
                } else if (intValue == 3) {
                    xf6 xf6Var3 = this.a;
                    xf6Var3.K(xf6Var3.X.getForum(), this.a.X);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class l implements td6 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xf6 a;

        public l(xf6 xf6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xf6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xf6Var;
        }

        @Override // com.repackage.td6
        public void a(ThreadData threadData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, threadData) == null) {
                bp6.d(this.a.b, this.a.X, threadData);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class m implements OnStatusChangedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ao4 a;
        public final /* synthetic */ FrsViewData b;
        public final /* synthetic */ xf6 c;

        public m(xf6 xf6Var, ao4 ao4Var, FrsViewData frsViewData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xf6Var, ao4Var, frsViewData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = xf6Var;
            this.a = ao4Var;
            this.b = frsViewData;
        }

        @Override // com.baidu.tieba.play.OnStatusChangedListener
        public void onStatusChange(OnStatusChangedListener.VideoStatus videoStatus) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, videoStatus) == null) {
                if (videoStatus == OnStatusChangedListener.VideoStatus.VIDEO_PLAYING) {
                    this.c.d1.setVisibility(8);
                    this.c.f1.setVisibility(8);
                    this.c.F1();
                    this.c.a2(this.a, 0);
                    to6.l("c14592", this.b);
                } else if (videoStatus == OnStatusChangedListener.VideoStatus.VIDEO_COMPLETE) {
                    this.c.M1();
                    to6.l("c14593", this.b);
                } else if (videoStatus == OnStatusChangedListener.VideoStatus.INTERNAL_VIDEO_BUFFERING_ERROR) {
                    this.c.M1();
                } else if (videoStatus == OnStatusChangedListener.VideoStatus.INTERNAL_VIDEO_BUFFERING_BUFFER) {
                    this.c.f2();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class n implements k58.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ao4 a;
        public final /* synthetic */ xf6 b;

        public n(xf6 xf6Var, ao4 ao4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xf6Var, ao4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = xf6Var;
            this.a = ao4Var;
        }

        @Override // com.repackage.k58.c
        public void a(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) {
                this.b.a2(this.a, i2);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class o implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ao4 a;
        public final /* synthetic */ FrsViewData b;
        public final /* synthetic */ xf6 c;

        public o(xf6 xf6Var, ao4 ao4Var, FrsViewData frsViewData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xf6Var, ao4Var, frsViewData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = xf6Var;
            this.a = ao4Var;
            this.b = frsViewData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.c.f1.getVisibility() == 0) {
                    this.c.c1.start();
                    return;
                }
                vo6.b(this.c.a, this.a.k(), this.a.g(), this.a.i());
                if (this.c.b != null) {
                    to6.d(this.b, 2, this.c.b.getUniqueId());
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class p implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ao4 a;
        public final /* synthetic */ FrsViewData b;
        public final /* synthetic */ xf6 c;

        public p(xf6 xf6Var, ao4 ao4Var, FrsViewData frsViewData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xf6Var, ao4Var, frsViewData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = xf6Var;
            this.a = ao4Var;
            this.b = frsViewData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                vo6.b(this.c.a, this.a.k(), this.a.g(), this.a.i());
                if (this.c.b != null) {
                    to6.d(this.b, 2, this.c.b.getUniqueId());
                }
            }
        }
    }

    public xf6(FrsFragment frsFragment, String str, String str2, int i2) {
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
        this.B0 = false;
        this.R0 = -1;
        this.S0 = 1000L;
        this.Y0 = false;
        this.Z0 = qm6.a();
        this.q1 = new h(this, 2921679);
        this.r1 = new i(this, 2921681);
        this.s1 = new j(this, 2921680);
        this.t1 = new k(this, 2921682);
        this.w0 = new ArrayList<>();
        this.f0 = i2;
        this.c = new Handler();
        this.b = frsFragment;
        this.a = frsFragment.getPageContext();
        pi.f(frsFragment.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f0701d5);
        pi.f(frsFragment.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f07026a);
        pi.f(frsFragment.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f070250);
        this.T = str;
        this.U = str2;
        View A1 = A1();
        this.d = A1;
        this.Z0.f(frsFragment, A1);
        this.a1 = this.Z0.h();
        this.s0 = (RelativeLayout) this.d.findViewById(R.id.obfuscated_res_0x7f09069b);
        this.u = (RelativeLayout) this.d.findViewById(R.id.obfuscated_res_0x7f090cd2);
        this.v = (LinearGradientView) this.d.findViewById(R.id.obfuscated_res_0x7f090cd5);
        TbImageView tbImageView = (TbImageView) this.d.findViewById(R.id.obfuscated_res_0x7f090cd3);
        this.w = tbImageView;
        tbImageView.setPageId(this.b.getUniqueId());
        this.w.setDefaultBgResource(R.color.transparent);
        this.w.setDefaultResource(R.drawable.obfuscated_res_0x7f080f26);
        this.z0 = this.d.findViewById(R.id.obfuscated_res_0x7f090cf0);
        this.c1 = (TbVideoView) this.d.findViewById(R.id.obfuscated_res_0x7f092302);
        TbImageView tbImageView2 = (TbImageView) this.d.findViewById(R.id.obfuscated_res_0x7f0922fc);
        this.d1 = tbImageView2;
        tbImageView2.setPageId(this.b.getUniqueId());
        this.d1.setDefaultBgResource(R.drawable.obfuscated_res_0x7f080f26);
        this.d1.setDefaultResource(R.drawable.obfuscated_res_0x7f080f26);
        this.d1.setPlaceHolder(2);
        this.e1 = this.d.findViewById(R.id.obfuscated_res_0x7f092301);
        this.f1 = this.d.findViewById(R.id.obfuscated_res_0x7f092300);
        this.g1 = (TBLottieAnimationView) this.d.findViewById(R.id.obfuscated_res_0x7f0922ff);
        this.A0 = this.d.findViewById(R.id.obfuscated_res_0x7f090b9b);
        this.S = (FrsLikeRecommendLayout) this.d.findViewById(R.id.obfuscated_res_0x7f090b2c);
        qm6.e(this.z0, this.A0);
        this.j1 = qm6.b(this.d);
        this.k1 = this.d.findViewById(R.id.obfuscated_res_0x7f090cd4);
        this.l1 = this.d.findViewById(R.id.obfuscated_res_0x7f0912c1);
        this.h1 = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f09220b);
        this.i1 = (TBLottieAnimationView) this.d.findViewById(R.id.obfuscated_res_0x7f09130b);
        this.m1 = this.d.findViewById(R.id.obfuscated_res_0x7f0922fd);
        this.n1 = (FrsHeaderVideoImageShadeView) this.d.findViewById(R.id.obfuscated_res_0x7f0922fb);
        this.C0 = (LinearLayout) this.d.findViewById(R.id.obfuscated_res_0x7f09117d);
        int n2 = this.Z0.n(LogicField.ROUND_CORNER_STYLE);
        View findViewById = this.d.findViewById(R.id.obfuscated_res_0x7f090ceb);
        this.D0 = findViewById;
        findViewById.setVisibility(n2);
        this.E0 = this.d.findViewById(R.id.obfuscated_res_0x7f091c7b);
        this.F0 = this.d.findViewById(R.id.obfuscated_res_0x7f0902fd);
        this.x = (ServiceAreaView) this.d.findViewById(R.id.obfuscated_res_0x7f091c7c);
        this.y = (FrameLayout) this.d.findViewById(R.id.obfuscated_res_0x7f090a89);
        this.D = (FrsVoiceRoomListLayout) this.d.findViewById(R.id.obfuscated_res_0x7f0923c4);
        this.A = (FrsTopView) this.d.findViewById(R.id.obfuscated_res_0x7f090bc2);
        this.G0 = this.d.findViewById(R.id.obfuscated_res_0x7f090bb9);
        this.B = this.d.findViewById(R.id.obfuscated_res_0x7f090bba);
        this.C = this.d.findViewById(R.id.obfuscated_res_0x7f091c7f);
        this.b1 = in6.g(this.A, this.b.w3());
        this.h = (List) this.Z0.a(LogicField.LIKE_BTN);
        this.i = (List) this.Z0.a(LogicField.SIGN_BTN);
        this.L = (ImageView) z1().a(LogicField.SPEED_ICON);
        this.t0 = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f09139e);
        this.u0 = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f0918a9);
        this.j = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f0911f3);
        this.s = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f0911eb);
        this.k = (ImageView) this.d.findViewById(R.id.obfuscated_res_0x7f091311);
        this.l = (ImageView) this.d.findViewById(R.id.obfuscated_res_0x7f091310);
        this.e = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f0913a3);
        this.f = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f0918af);
        this.n = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f090a37);
        this.o = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f0903e1);
        BarImageView barImageView = (BarImageView) this.d.findViewById(R.id.obfuscated_res_0x7f090b0a);
        this.N = barImageView;
        barImageView.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.N.setPageId(this.b.getUniqueId());
        this.N.setContentDescription(frsFragment.getResources().getString(R.string.obfuscated_res_0x7f0f02d9));
        this.N.setStrokeWith(pi.f(TbadkCoreApplication.getInst(), R.dimen.tbds4));
        this.N.setShowOval(true);
        this.N.setPlaceHolder(1);
        this.r = this.d.findViewById(R.id.obfuscated_res_0x7f0911ec);
        this.q = (RelativeLayout) this.d.findViewById(R.id.obfuscated_res_0x7f090cbf);
        this.p = (RelativeLayout) this.d.findViewById(R.id.obfuscated_res_0x7f09157c);
        this.t = (RelativeLayout) this.d.findViewById(R.id.obfuscated_res_0x7f090cc8);
        this.I0 = this.d.findViewById(R.id.obfuscated_res_0x7f090b56);
        this.K0 = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f090b57);
        HeadImageView headImageView = (HeadImageView) this.d.findViewById(R.id.obfuscated_res_0x7f090b58);
        this.J0 = headImageView;
        headImageView.setIsRound(true);
        this.J0.setDrawBorder(true);
        this.J0.setDefaultResource(R.drawable.icon_default_avatar100);
        this.J0.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.L0 = this.d.findViewById(R.id.obfuscated_res_0x7f090b55);
        this.M0 = (ImageView) this.d.findViewById(R.id.obfuscated_res_0x7f090b54);
        this.N0 = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f090b53);
        WebPManager.setPureDrawable(this.M0, R.drawable.obfuscated_res_0x7f0807c5, R.color.CAM_X0101, null);
        this.I = LayoutInflater.from(frsFragment.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0342, (ViewGroup) null);
        this.m = LayoutInflater.from(this.b.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0310, (ViewGroup) null);
        this.O0 = (HotRankEntryView) this.d.findViewById(R.id.obfuscated_res_0x7f090b08);
        this.m.setVisibility(8);
        new oo6(this.a);
        this.E = (EMTextView) this.d.findViewById(R.id.obfuscated_res_0x7f0906cd);
        this.m0 = (ViewGroup) this.d.findViewById(R.id.obfuscated_res_0x7f090cde);
        MessageManager.getInstance().registerListener(this.q1);
        MessageManager.getInstance().registerListener(this.r1);
        MessageManager.getInstance().registerListener(this.s1);
        MessageManager.getInstance().registerListener(this.t1);
    }

    @Override // com.repackage.wp6
    public void A(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            super.A(z);
            ef6 ef6Var = this.z;
            if (ef6Var != null) {
                ef6Var.k(z);
            }
        }
    }

    public View A1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? LayoutInflater.from(this.b.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0336, (ViewGroup) null) : (View) invokeV.objValue;
    }

    @Override // com.repackage.wp6
    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            ef6 ef6Var = this.z;
            if (ef6Var != null) {
                ef6Var.l();
            }
            if (FrsFragment.k2 && cp6.m(this.X)) {
                FrsFragment.k2 = false;
                K(this.X.getForum(), this.X);
            }
        }
    }

    public final int[] B1(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) ? i2 <= 3 ? new int[]{-8331843, -10499102} : i2 <= 9 ? new int[]{-10499102, -154262} : i2 <= 15 ? new int[]{-154262, -148180} : new int[]{-148180, -100818} : (int[]) invokeI.objValue;
    }

    public final LinearGradientView C1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            FrsFragment frsFragment = this.b;
            if (frsFragment != null && frsFragment.A3() != null) {
                View E = this.b.A3().E();
                if (E instanceof LinearGradientView) {
                    return (LinearGradientView) E;
                }
            }
            return null;
        }
        return (LinearGradientView) invokeV.objValue;
    }

    public final int D1(boolean z, boolean z2) {
        InterceptResult invokeCommon;
        List<nn> list;
        List<zg8> list2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            int i2 = 0;
            if (z2) {
                yg8 yg8Var = this.X.serviceAreaData;
                if (yg8Var != null && (list2 = yg8Var.b) != null && list2.size() == 1) {
                    i2 = 0 + pi.f(this.a.getPageActivity(), R.dimen.tbds83);
                } else {
                    i2 = 0 + pi.f(this.a.getPageActivity(), R.dimen.tbds84);
                }
            }
            if (z && (list = this.P0) != null) {
                i2 += Math.min(list.size(), 2) * pi.f(this.a.getPageActivity(), R.dimen.tbds83);
            }
            if (this.y.getVisibility() == 0) {
                i2 += pi.f(this.a.getPageActivity(), R.dimen.tbds231);
            }
            return (z2 || z || this.y.getVisibility() == 0) ? i2 + pi.f(this.a.getPageActivity(), R.dimen.tbds45) : i2;
        }
        return invokeCommon.intValue;
    }

    @Override // com.repackage.wp6
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
                this.j.setText(R.string.obfuscated_res_0x7f0f09e8);
                if (f2 >= 1.0f) {
                    i2 = this.Z;
                } else {
                    i2 = this.Z + 1;
                }
                FrsViewData P0 = this.b.P0();
                if (P0 != null && P0.getForum() != null) {
                    P0.getForum().setUser_level(i2);
                }
                this.s.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0a7e, Integer.valueOf(i2)));
            } else {
                this.Z0.g(this.Z, this.V);
                this.j.setText(this.V);
                this.s.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0a7e, Integer.valueOf(this.Z)));
            }
            this.k.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, B1(this.Z)));
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

    public final void E1(cn4 cn4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, cn4Var) == null) || cn4Var == null || cn4Var.b() == 0.0f) {
            return;
        }
        float d2 = cn4Var.d() / ((cn4Var.b() * 40.0f) / 70.0f);
        float d3 = cn4Var.d() / cn4Var.b();
        this.h1.setAlpha(d2);
        this.i1.setAlpha(d2);
        this.j1.setAlpha(1.0f - d2);
        float f2 = 1.0f - d3;
        this.k1.setAlpha(f2);
        this.e1.setAlpha(f2);
    }

    @Override // com.repackage.wp6
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.A.i(this.R0);
        }
    }

    public final void F1() {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (tBLottieAnimationView = this.g1) == null) {
            return;
        }
        tBLottieAnimationView.setVisibility(8);
        if (this.g1.isAnimating()) {
            this.g1.cancelAnimation();
        }
    }

    @Override // com.repackage.wp6
    public void G() {
        FrsViewData frsViewData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || this.b == null || (frsViewData = this.X) == null) {
            return;
        }
        List<nn> showTopThreadList = frsViewData.getShowTopThreadList();
        this.B0 = showTopThreadList.size() > 2;
        c2(showTopThreadList, this.X.getBusinessPromot());
    }

    public final boolean G1(ao4 ao4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, ao4Var)) == null) ? (ao4Var == null || StringUtils.isNull(ao4Var.e()) || StringUtils.isNull(ao4Var.j())) ? false : true : invokeL.booleanValue;
    }

    @Override // com.repackage.wp6
    public void H() {
        lp6 lp6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (lp6Var = this.Q) == null) {
            return;
        }
        lp6Var.o(this.c0);
    }

    public final boolean H1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            FrsTopView frsTopView = this.A;
            return frsTopView != null && frsTopView.getVisibility() == 0;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.wp6
    public void I() {
        lp6 lp6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (lp6Var = this.Q) == null) {
            return;
        }
        lp6Var.q(this.F);
    }

    public final boolean I1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            ServiceAreaView serviceAreaView = this.x;
            return serviceAreaView != null && serviceAreaView.getVisibility() == 0;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.wp6
    public void J(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, onClickListener) == null) {
            this.N.setOnClickListener(onClickListener);
            this.n.setOnClickListener(onClickListener);
            this.r.setOnClickListener(onClickListener);
            HotRankEntryView hotRankEntryView = this.O0;
            if (hotRankEntryView != null) {
                hotRankEntryView.setOnClickListener(onClickListener);
            }
            View view2 = this.I0;
            if (view2 != null) {
                view2.setOnClickListener(onClickListener);
            }
            View view3 = this.L0;
            if (view3 != null) {
                view3.setOnClickListener(onClickListener);
            }
            this.Z0.d(onClickListener);
        }
    }

    public final int J1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            int k2 = pi.k(this.a.getPageActivity());
            int i2 = (k2 * 9) / 16;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.c1.getLayoutParams();
            layoutParams.width = k2;
            layoutParams.height = i2;
            this.c1.setLayoutParams(layoutParams);
            return i2;
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.wp6
    public void K(ForumData forumData, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048594, this, forumData, frsViewData) == null) || forumData == null) {
            return;
        }
        boolean z = true;
        this.p1 = true;
        if (cp6.m(this.X)) {
            M1();
        }
        this.T = forumData.getName();
        this.U = forumData.getId();
        this.a0 = forumData.getMember_num();
        this.b0 = forumData.getPost_num();
        forumData.getTag_color();
        this.v0 = forumData.getImage_url();
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
        int n2 = this.Z0.n(LogicField.SERVICE_AREA);
        FrsViewData frsViewData3 = this.X;
        if ((frsViewData3 == null || frsViewData3.serviceAreaData == null) && !this.x.a()) {
            z = false;
        }
        if (n2 == 0 && z) {
            this.x.setVisibility(0);
            this.E0.setVisibility(0);
            ServiceAreaView serviceAreaView = this.x;
            FrsViewData frsViewData4 = this.X;
            serviceAreaView.setData(frsViewData4.serviceAreaData, frsViewData4);
        } else {
            this.x.setVisibility(8);
            this.E0.setVisibility(8);
        }
        this.Y = new ThreadData();
        W1();
        L1();
        if (this.X.getActivityHeadData() != null && this.X.getActivityHeadData().a() != null) {
            ArrayList<ao4> b2 = this.X.getActivityHeadData().b();
            this.H0 = qm6.d(this.d, G1(ListUtils.isEmpty(b2) ? null : b2.get(0)));
            if (this.y0 && this.X.getActivityHeadData().a().h) {
                this.H0.setVisibility(0);
            } else {
                this.H0.setVisibility(8);
            }
        }
        b2(forumData);
        if (frsViewData != null) {
            this.G = frsViewData.mSignActivityInfo;
            x1();
        }
    }

    public final void K1(int i2) {
        FrsViewData frsViewData;
        ForumData forum;
        ThemeColorInfo themeColorInfo;
        ThemeElement themeElement;
        ThemeElement themeElement2;
        ThemeElement themeElement3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048595, this, i2) == null) || (frsViewData = this.X) == null || (forum = frsViewData.getForum()) == null || (themeColorInfo = forum.getThemeColorInfo()) == null || (themeElement = themeColorInfo.day) == null || (themeElement2 = themeColorInfo.night) == null || (themeElement3 = themeColorInfo.dark) == null) {
            return;
        }
        if (i2 == 4) {
            themeElement = themeElement3;
        } else if (i2 == 1) {
            themeElement = themeElement2;
        }
        this.a1.e(themeElement);
        this.Z0.e(themeElement);
        if (!this.y0) {
            LinearGradientView C1 = C1();
            LinearGradientView linearGradientView = this.v;
            if (linearGradientView != null && C1 != null) {
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
                    this.w.J(themeElement.pattern_image, 10, false);
                }
            }
        }
        ServiceAreaView serviceAreaView = this.x;
        if (serviceAreaView != null) {
            serviceAreaView.setThemeFontColor(pc7.b(themeElement.common_color));
        }
        if (this.A != null) {
            int b2 = pc7.b(themeElement.common_color);
            if (UbsABTestHelper.isFrsModifyABTestA() && UtilHelper.isNightOrDarkMode()) {
                b2 = SkinManager.getColor(R.color.CAM_X0105);
            }
            this.A.setUrlAndColor(forum.getTopIcon(), b2);
        }
    }

    public void L1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            boolean d2 = d2();
            this.y0 = d2;
            this.Z0.b(d2);
            if (this.y0) {
                this.v.setVisibility(8);
                if (cp6.m(this.X)) {
                    this.z0.setVisibility(4);
                } else {
                    this.z0.setVisibility(0);
                }
                this.A0.setVisibility(0);
            } else {
                this.z0.setVisibility(8);
                this.A0.setVisibility(8);
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
            this.Z0.j(this.a0, this.b0);
            this.Z0.g(this.Z, this.V);
            ArrayList<kn4> arrayList = this.P;
            if (arrayList != null && arrayList.size() > 0) {
                this.T = UtilHelper.getFixedText(this.T, 7);
            } else if (this.k0) {
                this.T = UtilHelper.getFixedText(this.T, 6);
            }
            String b0 = lc6.b0(this.T);
            TextView textView3 = this.g;
            if (textView3 != null) {
                textView3.setText(b0);
            }
            TextView textView4 = this.n;
            if (textView4 != null) {
                textView4.setText(b0);
            }
            this.Z0.k(this.v0, b0);
            P1();
            G();
            K1(TbadkCoreApplication.getInst().getSkinType());
            S1();
            v1();
        }
    }

    public final void M1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.d1.setVisibility(0);
            a2(null, -1);
            F1();
            TbVideoView tbVideoView = this.c1;
            if (tbVideoView != null) {
                tbVideoView.stop();
            }
            this.c1.setVisibility(8);
        }
    }

    public final void N1(String str, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048598, this, str, j2) == null) {
            this.F = false;
            ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1);
            this.T0 = newScheduledThreadPool;
            newScheduledThreadPool.schedule(new g(this, str), j2, TimeUnit.SECONDS);
        }
    }

    public final void O1(cn4 cn4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048599, this, cn4Var) == null) || cn4Var == null) {
            return;
        }
        if (!cn4Var.e()) {
            if (this.h1.getVisibility() != 8) {
                this.h1.setVisibility(8);
            }
            if (this.i1.getVisibility() != 8) {
                this.i1.setVisibility(8);
                if (this.i1.isAnimating()) {
                    this.i1.cancelAnimation();
                }
            }
        } else if (cn4Var.d() < cn4Var.b()) {
            this.h1.setText(R.string.obfuscated_res_0x7f0f1244);
            X1();
        } else if (cn4Var.d() < cn4Var.c()) {
            this.h1.setText(R.string.obfuscated_res_0x7f0f1243);
            X1();
        } else {
            this.h1.setText(R.string.obfuscated_res_0x7f0f1245);
            this.i1.setVisibility(4);
            if (this.i1.isAnimating()) {
                this.i1.cancelAnimation();
            }
        }
    }

    public void P1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            this.N.J(this.v0, 10, false);
        }
    }

    public void Q1(nq4 nq4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, nq4Var) == null) {
            nq4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0366, new b(this));
        }
    }

    public void R1(nq4 nq4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, nq4Var) == null) {
            nq4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0cef, new c(this));
        }
    }

    public final void S1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            FrsViewData frsViewData = this.X;
            if (frsViewData != null && !ListUtils.isEmpty(frsViewData.liveFuseForumDataList)) {
                this.n0 = new zj6(this.a);
                if (this.X.getForum() != null) {
                    this.n0.j(this.X.getForum().getId());
                }
                this.n0.e(this.X.liveFuseForumDataList);
                View g2 = this.n0.g();
                if (g2 != null) {
                    this.m0.setVisibility(0);
                    this.m0.removeAllViews();
                    this.m0.addView(g2);
                    this.n0.d();
                    this.G0.setVisibility(8);
                    return;
                }
                this.m0.setVisibility(8);
                return;
            }
            this.m0.setVisibility(8);
        }
    }

    public final int T1(boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048604, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            int f2 = pi.f(this.a.getPageActivity(), R.dimen.tbds782);
            int D1 = D1(z, z2);
            V1(f2);
            int i2 = f2 + D1;
            this.w.setVisibility(0);
            this.c1.setVisibility(8);
            ((RelativeLayout.LayoutParams) this.w.getLayoutParams()).bottomMargin = D1;
            ((RelativeLayout.LayoutParams) this.z0.getLayoutParams()).bottomMargin = D1;
            if (D1 != 0) {
                ((RelativeLayout.LayoutParams) this.t.getLayoutParams()).topMargin = pi.f(this.a.getPageActivity(), R.dimen.tbds782) - pi.f(this.a.getPageActivity(), R.dimen.tbds282);
            } else {
                ((RelativeLayout.LayoutParams) this.t.getLayoutParams()).topMargin = pi.f(this.a.getPageActivity(), R.dimen.tbds493);
            }
            return i2;
        }
        return invokeCommon.intValue;
    }

    public void U1() {
        kp6 kp6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048605, this) == null) || (kp6Var = this.R) == null) {
            return;
        }
        kp6Var.n();
    }

    @Override // com.repackage.wp6
    @SuppressLint({"ResourceAsColor"})
    public void V(View view2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048606, this, view2, z) == null) {
            if (this.f0 == 0 && TbadkCoreApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) != null) {
                if (TbadkCoreApplication.getInst().getIntentClass(MemberPayActivityConfig.class) == null || z) {
                    return;
                }
                View inflate = LayoutInflater.from(this.a.getContext()).inflate(R.layout.obfuscated_res_0x7f0d0602, (ViewGroup) null);
                TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090701);
                TextView textView2 = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0911fa);
                TextView textView3 = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091d43);
                SkinManager.setViewTextColor((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090913), R.color.CAM_X0105, 1);
                SkinManager.setViewTextColor(textView, R.color.CAM_X0105, 1);
                SkinManager.setViewTextColor(textView2, R.color.CAM_X0105, 1);
                SkinManager.setViewTextColor(textView3, R.color.CAM_X0105, 1);
                nq4 nq4Var = new nq4(this.a.getPageActivity());
                nq4Var.setContentView(inflate);
                L(textView, textView2);
                if (!TextUtils.isEmpty(this.W) && !TextUtils.isEmpty(this.W.trim())) {
                    textView3.setVisibility(0);
                    textView3.setText(this.W);
                } else {
                    textView3.setVisibility(8);
                }
                nq4Var.setButtonTextColor(R.color.CAM_X0305);
                Q1(nq4Var);
                R1(nq4Var);
                nq4Var.create(this.a);
                nq4Var.show();
                return;
            }
            this.c.removeCallbacks(this.p0);
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
            this.J = (TextView) this.I.findViewById(R.id.obfuscated_res_0x7f090700);
            this.K = (TextView) this.I.findViewById(R.id.obfuscated_res_0x7f0911f9);
            SkinManager.setBackgroundResource(this.I.findViewById(R.id.obfuscated_res_0x7f090910), R.drawable.icon_frs_experience_number);
            SkinManager.setViewTextColor((TextView) this.I.findViewById(R.id.obfuscated_res_0x7f09090f), R.color.CAM_X0111, 1);
            SkinManager.setViewTextColor(this.J, R.color.common_color_10047, 1);
            SkinManager.setViewTextColor(this.K, R.color.CAM_X0111, 1);
            L(this.J, this.K);
            if (this.H.isShowing()) {
                sg.d(this.H, this.a.getPageActivity());
                return;
            }
            int[] iArr = new int[2];
            view2.getLocationOnScreen(iArr);
            if (iArr[1] - this.H.getHeight() <= 50) {
                sg.d(this.H, this.a.getPageActivity());
                return;
            }
            PopupWindow popupWindow2 = this.H;
            sg.m(popupWindow2, this.d, 0, iArr[0], iArr[1] - popupWindow2.getHeight());
            this.H.update();
            this.c.postDelayed(this.p0, 2000L);
        }
    }

    public final void V1(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048607, this, i2) == null) {
            int f2 = pi.f(this.a.getPageActivity(), R.dimen.tbds130);
            if (this.D0.getVisibility() != 0) {
                f2 -= pi.f(this.a.getPageActivity(), R.dimen.tbds32);
            }
            ((RelativeLayout.LayoutParams) this.l1.getLayoutParams()).topMargin = i2 - f2;
        }
    }

    @Override // com.repackage.wp6
    public void W() {
        FrsViewData frsViewData;
        String string;
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048608, this) == null) || this.R0 == -1 || (frsViewData = this.X) == null || frsViewData.forumRule == null || frsViewData.getUserData() == null || this.A == null) {
            return;
        }
        if (this.X.getUserData().getIs_manager() == 1) {
            if (this.X.forumRule.has_forum_rule.intValue() == 1 || this.X.forumRule.audit_status.intValue() != 0) {
                return;
            }
            string = this.a.getString(R.string.obfuscated_res_0x7f0f0749);
            str = "key_forum_rule_first_show_frs_manager";
        } else {
            string = this.a.getString(R.string.obfuscated_res_0x7f0f074a);
            str = "key_forum_rule_first_show_frs";
        }
        View view2 = null;
        if (this.A.getmTopViews() != null && this.A.getmTopViews().size() > 0 && (this.A.getmTopViews().get(0) instanceof AdapterLinearLayout)) {
            AdapterLinearLayout adapterLinearLayout = (AdapterLinearLayout) this.A.getmTopViews().get(0);
            if (this.R0 < adapterLinearLayout.getChildCount()) {
                view2 = adapterLinearLayout.getChildAt(this.R0);
            }
        }
        if (this.Q0 != null || view2 == null) {
            return;
        }
        zy5 zy5Var = new zy5(this.a, view2);
        this.Q0 = zy5Var;
        zy5Var.g0(R.drawable.obfuscated_res_0x7f0802ef);
        this.Q0.O(16);
        this.Q0.U(true);
        this.Q0.j0(UtilHelper.getDimenPixelSize(R.dimen.tbds128));
        this.Q0.k0(UtilHelper.getDimenPixelSize(R.dimen.tbds_10));
        this.Q0.h0(true);
        this.Q0.N(4000);
        if (this.Q0.J() || this.b.u3()) {
            return;
        }
        this.Q0.m0(string, str);
    }

    public void W1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            MediaData mediaData = new MediaData();
            mediaData.setType(3);
            mediaData.setPic(this.v0);
            this.Y.getMedias().add(mediaData);
        }
    }

    public final void X1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            TextView textView = this.h1;
            if (textView != null && textView.getVisibility() == 8) {
                this.h1.setVisibility(0);
            }
            TBLottieAnimationView tBLottieAnimationView = this.i1;
            if (tBLottieAnimationView != null) {
                if (tBLottieAnimationView.getVisibility() == 8 || this.i1.getVisibility() == 4) {
                    this.i1.setVisibility(0);
                    if (this.i1.isAnimating()) {
                        this.i1.cancelAnimation();
                    }
                    this.i1.setAnimation("frs_video_head_drag_hint_lottie.json");
                    this.i1.setRepeatCount(-1);
                    this.i1.playAnimation();
                }
            }
        }
    }

    @Override // com.repackage.wp6
    public void Y() {
        View contentView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            PopupWindow popupWindow = this.M;
            if (popupWindow == null) {
                this.M = new PopupWindow(this.a.getPageActivity());
                contentView = LayoutInflater.from(this.a.getContext()).inflate(R.layout.obfuscated_res_0x7f0d0776, (ViewGroup) null);
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
            SkinManager.setViewTextColor((TextView) contentView.findViewById(R.id.obfuscated_res_0x7f09138f), R.color.CAM_X0101, 1);
            SkinManager.setViewTextColor((TextView) contentView.findViewById(R.id.obfuscated_res_0x7f091d3b), R.color.CAM_X0305, 1);
            SkinManager.setViewTextColor((TextView) contentView.findViewById(R.id.obfuscated_res_0x7f091ef8), R.color.CAM_X0101, 1);
            int[] iArr = new int[2];
            this.L.getLocationOnScreen(iArr);
            PopupWindow popupWindow2 = this.M;
            sg.m(popupWindow2, this.d, 0, (iArr[0] - (popupWindow2.getWidth() / 2)) + (this.L.getWidth() / 2), iArr[1] + this.L.getWidth());
            this.M.update();
        }
    }

    public final void Y1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            int k2 = pi.k(this.a.getPageActivity());
            int i2 = (k2 * 9) / 16;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.d1.getLayoutParams();
            layoutParams.width = k2;
            layoutParams.height = i2;
            this.d1.setLayoutParams(layoutParams);
            this.d1.setScaleType(ImageView.ScaleType.CENTER_CROP);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.e1.getLayoutParams();
            layoutParams2.width = k2;
            layoutParams2.height = i2;
            this.e1.setLayoutParams(layoutParams2);
        }
    }

    public final int Z1(boolean z, boolean z2) {
        InterceptResult invokeCommon;
        int f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048613, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            int J1 = J1();
            Y1();
            int D1 = D1(z, z2);
            if (qm6.c()) {
                this.m1.setVisibility(8);
                this.n1.setVisibility(8);
                f2 = 0;
            } else {
                this.m1.setVisibility(0);
                this.n1.setVisibility(0);
                f2 = pi.f(this.a.getPageActivity(), R.dimen.tbds96);
            }
            int i2 = D1 + J1 + f2;
            this.w.setVisibility(8);
            this.c1.setVisibility(0);
            ((RelativeLayout.LayoutParams) this.t.getLayoutParams()).topMargin = (J1 - pi.f(this.a.getPageActivity(), R.dimen.tbds282)) + f2;
            V1(J1 + f2);
            return i2;
        }
        return invokeCommon.intValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:60:? A[RETURN, SYNTHETIC] */
    @Override // com.repackage.wp6
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
        ViewCommonUtil.setViewMargin(this.C0, -1, 0, -1, -1);
        boolean z = true;
        boolean z2 = this.y.getVisibility() == 0;
        boolean z3 = this.D.getVisibility() == 0;
        View m2 = this.Z0.m();
        z = (m2 == null || m2.getVisibility() != 0) ? false : false;
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds24);
        int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.tbds15);
        if (z) {
            ViewCommonUtil.setViewMargin(m2, -1, -1, -1, z2 ? dimenPixelSize2 : dimenPixelSize);
        } else if (z2) {
            i2 = dimenPixelSize2;
            ViewCommonUtil.setViewPadding(this.C0, -1, i2, -1, -1);
            int o0 = this.b.k1().o0();
            if (this.y0) {
                i5 = o0 + ym6.o;
                if (z2 || z3 || z) {
                    ViewCommonUtil.setViewMargin(this.C0, -1, UtilHelper.getDimenPixelSize(R.dimen.tbds55), -1, -1);
                }
            } else {
                if (cp6.m(this.X)) {
                    i3 = J1();
                    Y1();
                    this.w.setVisibility(8);
                    this.c1.setVisibility(0);
                    V1(i3);
                } else {
                    i3 = ym6.p + o0;
                    this.w.setVisibility(0);
                    this.c1.setVisibility(8);
                    V1(i3);
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
                ViewCommonUtil.setViewMargin(this.z0, -1, -1, -1, i7);
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
                    frsFragment.f4();
                    return;
                }
                return;
            }
            return;
        }
        i2 = dimenPixelSize;
        ViewCommonUtil.setViewPadding(this.C0, -1, i2, -1, -1);
        int o02 = this.b.k1().o0();
        if (this.y0) {
        }
        frsLikeRecommendLayout = this.S;
        if (frsLikeRecommendLayout != null) {
            i5 += this.S.getCurrentHeight();
        }
        layoutParams = this.u.getLayoutParams();
        if (layoutParams.height == i5) {
        }
    }

    @Override // com.repackage.wp6
    public void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
        }
    }

    public final void a2(ao4 ao4Var, int i2) {
        String b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048616, this, ao4Var, i2) == null) {
            if (i2 == -1) {
                b2 = to6.c(this.X);
            } else {
                b2 = to6.b(ao4Var, i2);
            }
            if (StringUtils.isNull(b2)) {
                return;
            }
            int b3 = pc7.b(b2);
            this.n1.setGradientColors(0, b3);
            this.m1.setBackgroundColor(b3);
        }
    }

    public final void b2(ForumData forumData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, forumData) == null) {
            if (forumData.getManagers() != null && forumData.getManagers().size() > 0) {
                String str = forumData.getManagers().get(0).show_name;
                if (TextUtils.isEmpty(str)) {
                    str = forumData.getManagers().get(0).name;
                }
                if (!TextUtils.isEmpty(str)) {
                    this.K0.setText(str);
                    this.J0.J(forumData.getManagers().get(0).portrait, 12, false);
                    this.I0.setVisibility(0);
                } else {
                    this.I0.setVisibility(8);
                }
                if (this.L0.getVisibility() == 0) {
                    this.L0.setVisibility(8);
                    return;
                }
                return;
            }
            if (this.I0.getVisibility() == 0) {
                this.I0.setVisibility(8);
            }
            if (this.L0.getVisibility() == 8) {
                this.L0.setVisibility(0);
            }
        }
    }

    @Override // com.repackage.wp6
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            this.Z0.l(LogicField.BRAND_LABEL, 0);
            this.o.setVisibility(0);
        }
    }

    @Override // com.repackage.wp6
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

    public final void c2(List<nn> list, dg8 dg8Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048620, this, list, dg8Var) == null) || this.A == null) {
            return;
        }
        this.P0 = list;
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
        if (dg8Var != null) {
            this.z = new ef6(this.a.getPageActivity());
            this.y.setVisibility(0);
            this.y.addView(this.z.f());
            FrsViewData frsViewData2 = this.X;
            ForumData forum = frsViewData2 != null ? frsViewData2.getForum() : null;
            ef6 ef6Var = this.z;
            FrsViewData frsViewData3 = this.X;
            ef6Var.e(forum, dg8Var, frsViewData3 == null || frsViewData3.isFromCache);
            y1(dg8Var);
        } else {
            this.y.setVisibility(8);
        }
        FrsVoiceRoomListLayout frsVoiceRoomListLayout2 = this.D;
        if (frsVoiceRoomListLayout2 != null && frsVoiceRoomListLayout2.getVisibility() == 0) {
            this.G0.setVisibility(8);
        } else {
            this.G0.setVisibility(this.Z0.n(LogicField.TOP_DIVIDER));
        }
        FrsFragment frsFragment = this.b;
        if (frsFragment != null && frsFragment.T3()) {
            this.A.setVisibility(0);
            this.A.setFragmentUniqueId(this.b.getUniqueId());
            FrsViewData frsViewData4 = this.X;
            ForumData forum2 = frsViewData4 != null ? frsViewData4.getForum() : null;
            FrsViewData frsViewData5 = this.X;
            this.A.setForum(this.U, this.T, forum2, frsViewData5 != null ? frsViewData5.getUserData() : null, this.b.m3());
            if (list.size() > 0 && (list.get(0) instanceof mg8)) {
                this.R0 = 0;
            } else if (list.size() > 1 && (list.get(1) instanceof mg8)) {
                this.R0 = 1;
            } else {
                this.R0 = -1;
            }
            this.A.setDatas(list, dg8Var);
            if (this.x0 == null) {
                this.x0 = new l(this);
            }
            this.A.setStatListener(this.x0);
            return;
        }
        this.A.setVisibility(8);
        BdTypeRecyclerView bdTypeRecyclerView = this.b1;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.removeHeaderView(this.A);
        }
    }

    @Override // com.repackage.wp6
    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048621, this, i2) == null) {
            this.Z0.onChangeSkinType(i2);
            this.a.getLayoutMode().k(i2 == 1);
            this.a.getLayoutMode().j(this.d);
            this.a.getLayoutMode().j(this.I);
            this.a.getLayoutMode().j(this.m);
            SkinManager.setBackgroundResource(this.k, R.drawable.obfuscated_res_0x7f080578);
            fr4 d2 = fr4.d(this.D0);
            d2.m(1);
            d2.n(R.string.J_X14);
            d2.f(R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.E0, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.F0, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.B, R.color.CAM_X0624);
            SkinManager.setBackgroundColor(this.G0, R.color.CAM_X0201);
            SkinManager.setBackgroundColor(this.l, R.color.CAM_X0101);
            SkinManager.setBackgroundColor(this.t, R.color.black_alpha0);
            SkinManager.setBackgroundColor(this.s0, R.color.CAM_X0204);
            SkinManager.setViewTextColor(this.n, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.s, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.j, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.t0, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.e, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.u0, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.f, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.K0, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.N0, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.f, (int) R.color.CAM_X0101);
            fr4 d3 = fr4.d(this.h1);
            d3.v(R.color.CAM_X0101);
            d3.z(R.dimen.T_X09);
            fr4 d4 = fr4.d(this.E);
            d4.A(R.string.F_X01);
            d4.v(R.color.CAM_X0101);
            BarImageView barImageView = this.N;
            if (barImageView != null) {
                barImageView.setBorderWidth(pi.f(this.a.getPageActivity(), R.dimen.tbds1));
                this.N.setBorderColor(SkinManager.getColor(R.color.CAM_X0603));
                this.N.setStrokeColorResId(R.color.CAM_X0201);
                this.N.setPlaceHolder(1);
                this.N.invalidate();
            }
            HeadImageView headImageView = this.J0;
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
            Iterator<TbImageView> it = this.w0.iterator();
            while (it.hasNext()) {
                it.next().invalidate();
            }
            c0();
            O(this.i0 ? 1 : 0);
            U1();
            K1(i2);
            u1(H1(), I1());
            ServiceAreaView serviceAreaView = this.x;
            if (serviceAreaView != null) {
                serviceAreaView.b(i2);
            }
            FrsTopView frsTopView = this.A;
            if (frsTopView != null) {
                frsTopView.h(i2);
            }
            ef6 ef6Var = this.z;
            if (ef6Var != null) {
                ef6Var.h(i2);
            }
            HotRankEntryView hotRankEntryView = this.O0;
            if (hotRankEntryView != null) {
                hotRankEntryView.b(i2);
            }
            FrsVoiceRoomListLayout frsVoiceRoomListLayout = this.D;
            if (frsVoiceRoomListLayout != null) {
                frsVoiceRoomListLayout.onChangeSkinType(this.a, i2);
            }
            zj6 zj6Var = this.n0;
            if (zj6Var != null) {
                zj6Var.i();
            }
        }
    }

    public final boolean d2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            FrsViewData frsViewData = this.X;
            if (frsViewData == null) {
                return false;
            }
            ao4 ao4Var = null;
            if (frsViewData.getStar() != null && !StringUtils.isNull(frsViewData.getStar().a())) {
                ao4Var = new ao4();
                ao4Var.s("");
                ao4Var.r(frsViewData.getStar().a());
            } else if (frsViewData.getActivityHeadData() != null && ListUtils.getCount(frsViewData.getActivityHeadData().b()) >= 1) {
                ao4Var = frsViewData.getActivityHeadData().b().get(0);
            }
            if (ao4Var != null) {
                if (G1(ao4Var)) {
                    g2(frsViewData, ao4Var);
                } else {
                    e2(frsViewData, ao4Var);
                }
                ThirdStatisticHelper.sendReq((String) ListUtils.getItem(ao4Var.n(), 0));
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void e2(FrsViewData frsViewData, ao4 ao4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048623, this, frsViewData, ao4Var) == null) || this.w == null || ao4Var == null) {
            return;
        }
        if (frsViewData != null && frsViewData.getForum() != null && !TextUtils.isEmpty(frsViewData.getForum().getId()) && frsViewData.getActivityHeadData() != null && !TextUtils.isEmpty(frsViewData.getActivityHeadData().c())) {
            StatisticItem statisticItem = new StatisticItem("c13326");
            statisticItem.param("fid", frsViewData.getForum().getId());
            statisticItem.param("obj_id", frsViewData.getActivityHeadData().c());
            TiebaStatic.log(statisticItem);
            if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                statisticItem.param("ab_tag", TbadkCoreApplication.getInst().getAdAdSense().k);
            }
            to6.e(frsViewData, 1, this.b.getUniqueId());
        }
        this.w.J(ao4Var.f(), 10, false);
        this.w.setOnClickListener(new a(this, ao4Var, frsViewData));
    }

    @Override // com.repackage.wp6
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

    public final void f2() {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048625, this) == null) || (tBLottieAnimationView = this.g1) == null) {
            return;
        }
        if (tBLottieAnimationView.getVisibility() == 8 || this.g1.getVisibility() == 4) {
            this.g1.setVisibility(0);
            if (this.g1.isAnimating()) {
                this.g1.cancelAnimation();
            }
            this.g1.setAnimation(R.raw.obfuscated_res_0x7f110019);
            this.g1.setRepeatCount(-1);
            this.g1.playAnimation();
        }
    }

    public final void g2(FrsViewData frsViewData, ao4 ao4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048626, this, frsViewData, ao4Var) == null) {
            this.d1.setVisibility(0);
            a2(null, -1);
            this.d1.J(ao4Var.e(), 10, false);
            if (this.c1.getVisibility() != 0) {
                this.c1.setVisibility(0);
            }
            this.c1.setVideoPath(ao4Var.j());
            this.c1.setVolume(0.0f, 0.0f);
            this.c1.setVideoScalingMode(0);
            this.c1.K(true);
            this.c1.setLooping(false);
            this.c1.setVideoStatusChangeListener(new m(this, ao4Var, frsViewData));
            this.c1.getMediaProgressObserver().j(new n(this, ao4Var));
            if (to6.f()) {
                this.f1.setVisibility(8);
                FrsFragment frsFragment = this.b;
                if (frsFragment != null && !this.X.isFromCache && (this.o1 || (!frsFragment.Q3() && !this.b.P3() && !this.b.v3()))) {
                    this.c1.start();
                }
            } else {
                this.f1.setVisibility(0);
            }
            this.d1.setOnClickListener(new o(this, ao4Var, frsViewData));
            this.c1.setOnClickListener(new p(this, ao4Var, frsViewData));
            FrsFragment frsFragment2 = this.b;
            if (frsFragment2 != null) {
                to6.e(frsViewData, 2, frsFragment2.getUniqueId());
            }
        }
    }

    public final void h2(String str, long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048627, this, new Object[]{str, Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            this.F = true;
            this.X0 = new f(this, j2, j3, str).start();
            if (this.Q == null || j()) {
                return;
            }
            this.Q.q(this.F);
        }
    }

    @Override // com.repackage.wp6
    public SignActivityInfo l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) ? this.G : (SignActivityInfo) invokeV.objValue;
    }

    @Override // com.repackage.wp6
    public void o() {
        zy5 zy5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048629, this) == null) || (zy5Var = this.Q0) == null) {
            return;
        }
        zy5Var.I();
        this.R0 = -1;
    }

    @Override // com.repackage.wp6
    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) ? this.y0 : invokeV.booleanValue;
    }

    @Override // com.repackage.wp6
    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) ? this.F : invokeV.booleanValue;
    }

    public final void u1(boolean z, boolean z2) {
        int f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048632, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (qm6.c()) {
                a();
                return;
            }
            RelativeLayout relativeLayout = this.u;
            if (relativeLayout == null || relativeLayout.getLayoutParams() == null) {
                return;
            }
            if (this.O0.getVisibility() == 0) {
                f2 = pi.f(this.a.getPageActivity(), R.dimen.tbds704);
                ((RelativeLayout.LayoutParams) this.t.getLayoutParams()).topMargin = pi.f(this.a.getPageActivity(), R.dimen.tbds384);
                ((RelativeLayout.LayoutParams) this.O0.getLayoutParams()).topMargin = (pi.f(this.a.getPageActivity(), R.dimen.tbds226) + pi.s(this.a.getPageActivity())) - pi.f(this.a.getPageActivity(), R.dimen.tbds72);
            } else {
                f2 = pi.f(this.a.getPageActivity(), R.dimen.tbds600);
            }
            if (!z && !z2 && !this.y0) {
                f2 -= pi.f(this.a.getPageActivity(), R.dimen.tbds80);
            } else if (this.y0) {
                if (cp6.m(this.X)) {
                    f2 = Z1(z, z2);
                } else {
                    f2 = T1(z, z2);
                }
            }
            ViewGroup.LayoutParams layoutParams = this.u.getLayoutParams();
            if (layoutParams.height != f2) {
                layoutParams.height = f2;
                this.u.setLayoutParams(layoutParams);
            }
        }
    }

    public final void v1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048633, this) == null) {
            boolean H1 = H1();
            boolean I1 = I1();
            if (!TextUtils.isEmpty(this.T)) {
                go6 c2 = fo6.d().c(this.T);
                if (c2 == null) {
                    c2 = new go6(this.B0, H1);
                } else {
                    c2.d(this.B0);
                    c2.e(H1);
                }
                fo6.d().e(this.T, c2);
            }
            w1(H1, I1);
            u1(H1, I1);
        }
    }

    public final void w1(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048634, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || this.b.A3() == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.C0.getLayoutParams();
        if (!z && !z2) {
            this.C0.setVisibility(0);
            this.E0.setVisibility(8);
            this.F0.setVisibility(this.Z0.n(LogicField.BANNER_AND_BOTTOM_VIEW));
            layoutParams.topMargin = pi.f(this.a.getPageActivity(), R.dimen.tbds50);
        } else {
            this.C0.setVisibility(0);
            this.E0.setVisibility(this.Z0.n(LogicField.SERVICE_AREA));
            layoutParams.topMargin = pi.f(this.a.getPageActivity(), R.dimen.tbds55);
        }
        this.b.A3().u(z, z2);
    }

    @Override // com.repackage.wp6
    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048635, this) == null) {
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
            ef6 ef6Var = this.z;
            if (ef6Var != null) {
                ef6Var.i();
            }
            CountDownTimer countDownTimer = this.X0;
            if (countDownTimer != null) {
                countDownTimer.cancel();
                this.X0 = null;
            }
            MessageManager.getInstance().unRegisterListener(this.q1);
            MessageManager.getInstance().unRegisterListener(this.r1);
            MessageManager.getInstance().unRegisterListener(this.s1);
            MessageManager.getInstance().unRegisterListener(this.t1);
        }
    }

    public final void x1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048636, this) == null) || this.G == null) {
            return;
        }
        CountDownTimer countDownTimer = this.X0;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.X0.onFinish();
        }
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        this.U0 = ((long) (this.G.activity_time.intValue() + this.G.activity_duration.intValue())) - currentTimeMillis < 0;
        this.V0 = ((long) this.G.activity_time.intValue()) - currentTimeMillis <= 0;
        this.W0 = ((long) (this.G.activity_time.intValue() - this.G.countdown_time.intValue())) - currentTimeMillis <= 0;
        boolean z = this.U0;
        if (z) {
            this.E.setVisibility(8);
            return;
        }
        if (this.V0 && !z) {
            h2(this.G.activity_msg, 1000 * ((this.G.activity_time.intValue() + this.G.activity_duration.intValue()) - currentTimeMillis), this.S0);
        }
        if (!this.V0 && this.W0) {
            this.E.setVisibility(0);
            this.E.setText(this.G.countdown_msg);
            SignActivityInfo signActivityInfo = this.G;
            N1(signActivityInfo.activity_msg, signActivityInfo.activity_time.intValue() - currentTimeMillis);
        }
        if (this.W0) {
            return;
        }
        SignActivityInfo signActivityInfo2 = this.G;
        N1(signActivityInfo2.countdown_msg, (signActivityInfo2.activity_time.intValue() - this.G.countdown_time.intValue()) - currentTimeMillis);
    }

    @Override // com.repackage.wp6
    public void y(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048637, this, z) == null) {
            this.Z0.c(z);
        }
    }

    public final void y1(dg8 dg8Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048638, this, dg8Var) == null) || dg8Var == null || this.X == null || this.Y0) {
            return;
        }
        this.Y0 = true;
        StatisticItem statisticItem = new StatisticItem("common_exp");
        statisticItem.param("page_type", "a006");
        statisticItem.param(TiebaStatic.Params.OBJ_ISAD, "1");
        int i2 = 6;
        if (dg8Var.getType() != 1) {
            if (dg8Var.getType() == 2) {
                i2 = 7;
            } else if (dg8Var.getType() == 3) {
                i2 = 8;
            } else if (dg8Var.getType() == 4) {
                i2 = 21;
            }
        }
        statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, 1);
        statisticItem.param(TiebaStatic.Params.OBJ_AD_LOCATE, i2);
        statisticItem.param("obj_id", dg8Var.c());
        ForumData forum = this.X.getForum();
        if (forum != null) {
            statisticItem.param("fid", forum.getId());
            statisticItem.param("fname", forum.getName());
            statisticItem.param(TiebaStatic.Params.FIRST_DIR, forum.getFirst_class());
            statisticItem.param(TiebaStatic.Params.SECOND_DIR, forum.getSecond_class());
        }
        if (dg8Var.getType() == 1) {
            statisticItem.param("tid", dg8Var.l());
            statisticItem.param("thread_type", dg8Var.m());
        }
        if (StringUtils.isNull(dg8Var.p())) {
            statisticItem.param("obj_type", 1);
        } else {
            statisticItem.param("obj_type", 2);
        }
        TiebaStatic.log(statisticItem);
    }

    @Override // com.repackage.wp6
    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048639, this) == null) {
            super.z();
            if (cp6.m(this.X)) {
                M1();
            }
            ef6 ef6Var = this.z;
            if (ef6Var != null) {
                ef6Var.j();
            }
        }
    }

    @NonNull
    public rm6 z1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) ? this.Z0 : (rm6) invokeV.objValue;
    }
}

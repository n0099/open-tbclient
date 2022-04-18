package com.repackage;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.Parcelable;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AlertDialog;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.DeleteThreadInfo;
import com.baidu.tbadk.core.data.LoginDialogData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.dialog.TBAlertConfig;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.DialogLoginHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.view.AgreeView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.sendtool.SendView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.util.MaskView;
import com.baidu.tbadk.widget.RightFloatLayerLottieView;
import com.baidu.tbadk.widget.RightFloatLayerView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ObservedChangeRelativeLayout;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.ejection.EjectionAnimationView;
import com.baidu.tieba.pb.pb.main.AbsPbActivity;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbLandscapeListView;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.PbReplyTitleViewHolder;
import com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar;
import com.baidu.tieba.pb.pb.main.view.CustomBlueCheckRadioButton;
import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
import com.baidu.tieba.pb.pb.main.view.PbThreadPostView;
import com.baidu.tieba.pb.pb.main.view.PbTopTipView;
import com.baidu.tieba.pb.view.FallingView;
import com.baidu.tieba.pb.view.PbInterviewStatusView;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.view.NavigationBarCoverTip;
import com.baidu.tieba.view.WaterRippleView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.bi5;
import com.repackage.bt7;
import com.repackage.cr4;
import com.repackage.cu4;
import com.repackage.er4;
import com.repackage.fv7;
import com.repackage.nk8;
import com.repackage.nr4;
import com.repackage.sw7;
import com.repackage.yh5;
import java.math.RoundingMode;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes6.dex */
public class gw7 {
    public static /* synthetic */ Interceptable $ic;
    public static final int c2;
    public static int d2;
    public static int e2;
    public static int f2;
    public static int g2;
    public static int h2;
    public static int i2;
    public static final int j2;
    public static nk8.f k2;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView A;
    public n08 A0;
    public long A1;
    public ObservedChangeRelativeLayout B;
    public TextView B0;
    public boolean B1;
    public qu7 C;
    public TextView C0;
    public int C1;
    public cr4 D;
    public TextView D0;
    public int D1;
    public er4 E;
    public boolean E0;
    public boolean E1;
    public View F;
    public int F0;
    public m08 F1;
    public EditText G;
    public xt4 G0;
    public MaskView G1;
    public o08 H;
    public boolean H0;
    public final FallingView H1;
    public PbListView I;
    public bs7 I0;
    public RightFloatLayerView I1;
    public k08 J;
    public PostData J0;
    public final FrameLayout J1;
    public View K;
    public int K0;
    public boolean K1;
    public View L;
    public int L0;
    public String L1;
    public View M;
    public boolean M0;
    public CustomMessageListener M1;
    public View.OnClickListener N;
    public ViewStub N0;
    public CustomMessageListener N1;
    public TbRichTextView.y O;
    public PbInterviewStatusView O0;
    public Handler O1;
    public NoNetworkView.b P;
    public FrameLayout P0;
    public Runnable P1;
    public lr4 Q;
    public TextView Q0;
    public CustomMessageListener Q1;
    public View.OnClickListener R;
    public View R0;
    public PbFragment.d3 R1;
    public cr4 S;
    public View S0;
    public boolean S1;
    public Dialog T;
    public View T0;
    public View.OnClickListener T1;
    public Dialog U;
    public PbReplyTitleViewHolder U0;
    public boolean U1;
    public View V;
    public View V0;
    public String V1;
    public LinearLayout W;
    public int W0;
    public cu4.g W1;
    public CompoundButton.OnCheckedChangeListener X;
    public boolean X0;
    public View.OnClickListener X1;
    public TextView Y;
    public s0 Y0;
    public final List<TbImageView> Y1;
    public TextView Z;
    public PbEmotionBar Z0;
    public int Z1;
    public final ViewTreeObserver.OnGlobalLayoutListener a;
    public String a0;
    public int a1;
    public boolean a2;
    public int b;
    public lr4 b0;
    public int b1;
    public boolean b2;
    public PbFragment c;
    public lr4 c0;
    public Runnable c1;
    public RelativeLayout d;
    public gr4 d0;
    public PbFakeFloorModel d1;
    public View e;
    public boolean e0;
    public cv7 e1;
    public int f;
    public boolean f0;
    public bw7 f1;
    public final Handler g;
    public String g0;
    public boolean g1;
    public final dy7 h;
    public String h0;
    public int h1;
    public cy7 i;
    public dt7 i0;
    public boolean i1;
    public ViewStub j;
    public ScrollView j0;
    public boolean j1;
    public ViewStub k;
    public EditorTools k0;
    public boolean k1;
    public PbLandscapeListView l;
    public boolean l0;
    public int l1;
    public NoNetworkView m;
    public View m0;
    public PbTopTipView m1;
    public List<CustomBlueCheckRadioButton> n;
    public View n0;
    public PopupWindow n1;
    public PbThreadPostView o;
    public EjectionAnimationView o0;
    public TextView o1;
    public gv7 p;
    public Button p0;
    public List<String> p1;
    public fv7 q;
    public View q0;
    public ex7 q1;
    public yw7 r;
    public View r0;
    public bu7 r1;
    public tw7 s;
    public LinearLayout s0;
    public PbLandscapeListView.c s1;
    public vw7 t;
    public HeadImageView t0;
    public boolean t1;
    public xw7 u;
    public TextView u0;
    public tv7 u1;
    public uw7 v;
    public WaterRippleView v0;
    public NavigationBarCoverTip v1;
    public ww7 w;
    public ImageView w0;
    public yh5 w1;
    public sw7 x;
    public AgreeView x0;
    public bi5 x1;
    public LinearLayout y;
    public ImageView y0;
    public String y1;
    public TextView z;
    public ImageView z0;
    public PermissionJudgePolicy z1;

    /* loaded from: classes6.dex */
    public class a implements PbLandscapeListView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ PbReplyTitleViewHolder b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ int d;
        public final /* synthetic */ int e;
        public final /* synthetic */ int f;
        public final /* synthetic */ gw7 g;

        /* renamed from: com.repackage.gw7$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class RunnableC0427a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public RunnableC0427a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.g.V0 == null || this.a.g.V0.getLayoutParams() == null) {
                    return;
                }
                ViewGroup.LayoutParams layoutParams = this.a.g.V0.getLayoutParams();
                layoutParams.height = this.a.g.b1;
                this.a.g.V0.setLayoutParams(layoutParams);
            }
        }

        public a(gw7 gw7Var, int i, PbReplyTitleViewHolder pbReplyTitleViewHolder, boolean z, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gw7Var, Integer.valueOf(i), pbReplyTitleViewHolder, Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = gw7Var;
            this.a = i;
            this.b = pbReplyTitleViewHolder;
            this.c = z;
            this.d = i2;
            this.e = i3;
            this.f = i4;
        }

        @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.b
        public void onLayout() {
            ViewGroup.LayoutParams layoutParams;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int i2 = this.a;
                if (i2 >= 0 && i2 <= this.g.d.getMeasuredHeight()) {
                    int Z0 = this.g.Z0(this.b);
                    int i3 = this.a;
                    int i4 = Z0 - i3;
                    if (this.c && i4 != 0 && i3 <= (i = this.d)) {
                        i4 = Z0 - i;
                    }
                    if (this.g.V0 == null || (layoutParams = this.g.V0.getLayoutParams()) == null) {
                        return;
                    }
                    if (i4 == 0 || i4 > this.g.d.getMeasuredHeight() || Z0 >= this.g.d.getMeasuredHeight()) {
                        layoutParams.height = this.g.b1;
                    } else {
                        if (layoutParams != null) {
                            int i5 = layoutParams.height;
                            if (i5 + i4 > 0 && i5 + i4 <= this.g.d.getMeasuredHeight()) {
                                layoutParams.height += i4;
                                this.g.l.setSelectionFromTop(this.e, this.f);
                            }
                        }
                        layoutParams.height = this.g.b1;
                    }
                    this.g.V0.setLayoutParams(layoutParams);
                    pg.a().post(new RunnableC0427a(this));
                }
                this.g.l.setOnLayoutListener(null);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gw7 a;

        public a0(gw7 gw7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gw7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gw7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (!(view2 instanceof HeadImageView) || this.a.I0 == null || this.a.I0.O() == null || this.a.I0.O().getAuthor() == null || this.a.I0.O().getAuthor().getAlaInfo() == null || this.a.I0.O().getAuthor().getAlaInfo().live_status != 1) {
                    if (this.a.i1) {
                        TiebaStatic.log(new StatisticItem("c11923").param("obj_id", 2));
                    }
                    if (!this.a.i1 && this.a.I0 != null && this.a.I0.O() != null && this.a.I0.O().getAuthor() != null && this.a.I0.O().getAuthor().isBigV()) {
                        TiebaStatic.log(new StatisticItem("c12151").param("obj_locate", 1));
                    }
                    if (this.a.c.x() != null) {
                        this.a.c.x().mEvent.b.onClick(view2);
                        return;
                    }
                    return;
                }
                StatisticItem statisticItem = new StatisticItem("c11851");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                TiebaStatic.log(statisticItem);
                StatisticItem statisticItem2 = new StatisticItem("c13715");
                statisticItem2.param("fid", this.a.I0.m());
                statisticItem2.param("fname", this.a.I0.n());
                statisticItem2.param("obj_param1", this.a.I0.O().getAuthor().getAlaInfo().user_info != null ? this.a.I0.O().getAuthor().getAlaInfo().user_info.user_id : 0L);
                statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem2.param("tid", this.a.I0.Q());
                statisticItem2.param(TiebaStatic.Params.OBJ_PARAM2, 1);
                statisticItem2.param(TiebaStatic.Params.OBJ_PARAM4, YYLiveUtil.calculateLiveType(this.a.I0.O().getAuthor().getAlaInfo()));
                if (this.a.I0.O().getAuthor().getAlaInfo().mYyExtData != null) {
                    statisticItem2.param(TiebaStatic.Params.OBJ_PARAM3, TiebaStatic.YYValues.YY_LIVE);
                    TiebaStaticHelper.addYYParam(statisticItem2, this.a.I0.O().getAuthor().getAlaInfo().mYyExtData);
                }
                TiebaStatic.log(statisticItem2);
                if (this.a.I0.O().getAuthor().getAlaInfo().isLegalYYLiveData()) {
                    YYLiveUtil.jumpYYLiveRoom(this.a.c.getPageContext(), this.a.I0.O().getAuthor().getAlaInfo(), YYLiveUtil.SOURCE_PB_LIVE_HEAD);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements AgreeView.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gw7 a;

        /* loaded from: classes6.dex */
        public class a implements f05 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = bVar;
            }

            @Override // com.repackage.f05
            public void a(List<Bitmap> list) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
                    this.a.a.o0.setVisibility(0);
                    this.a.a.o0.setBitmaps(list);
                    Rect rect = new Rect();
                    this.a.a.x0.getImgAgree().getGlobalVisibleRect(rect);
                    this.a.a.o0.setAnchorPosition((rect.right + rect.left) / 2, (rect.bottom + rect.top) / 2);
                    this.a.a.o0.k();
                }
            }
        }

        public b(gw7 gw7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gw7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gw7Var;
        }

        @Override // com.baidu.tbadk.core.view.AgreeView.h
        public void onLongPress() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.p3();
                h05.g().c(new a(this));
            }
        }

        @Override // com.baidu.tbadk.core.view.AgreeView.h
        public void onRelease() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.z2();
                this.a.o0.l();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b0 implements sw7.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gw7 a;

        public b0(gw7 gw7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gw7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gw7Var;
        }

        @Override // com.repackage.sw7.a
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    this.a.x.a(this.a.l);
                } else {
                    this.a.x.d(this.a.l);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gw7 a;

        public c(gw7 gw7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gw7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gw7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.x0 == null || this.a.x0.getData() == null) {
                return;
            }
            gw7 gw7Var = this.a;
            gw7Var.t2(gw7Var.x0.getData(), this.a.x0.getData().agreeNum);
            if (!UbsABTestHelper.isLikeModifyTestA() || this.a.x0.D()) {
                return;
            }
            gw7 gw7Var2 = this.a;
            gw7Var2.o2(gw7Var2.x0);
        }
    }

    /* loaded from: classes6.dex */
    public class c0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gw7 a;

        public c0(gw7 gw7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gw7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gw7Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            gw7 gw7Var;
            dy7 dy7Var;
            LinearLayout linearLayout;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.C == null || (dy7Var = (gw7Var = this.a).h) == null || dy7Var.i == null || gw7Var.I0 == null || this.a.I0.O() == null || this.a.I0.O().isVideoThreadType() || this.a.K1() || this.a.I0.l() == null || ni.isEmpty(this.a.I0.l().getName())) {
                return;
            }
            if ((this.a.C.J() == null || !this.a.C.J().isShown()) && (linearLayout = this.a.h.i) != null) {
                linearLayout.setVisibility(0);
                if (this.a.c == null || this.a.c.w() == null) {
                    return;
                }
                StatisticItem statisticItem = new StatisticItem("c13400");
                statisticItem.param("tid", this.a.c.w().l1());
                statisticItem.param("fid", this.a.c.w().getForumId());
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gw7 a;

        public d(gw7 gw7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gw7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gw7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            SparseArray<Object> sparseArray;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || (sparseArray = (SparseArray) view2.getTag()) == null) {
                return;
            }
            boolean booleanValue = sparseArray.get(R.id.obfuscated_res_0x7f091e98) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091e98)).booleanValue() : false;
            boolean booleanValue2 = sparseArray.get(R.id.obfuscated_res_0x7f091eab) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091eab)).booleanValue() : false;
            boolean booleanValue3 = sparseArray.get(R.id.obfuscated_res_0x7f091e96) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091e96)).booleanValue() : false;
            if (booleanValue) {
                if (booleanValue2) {
                    sparseArray.put(R.id.obfuscated_res_0x7f091e69, 1);
                    this.a.c.c4(sparseArray);
                    return;
                }
                this.a.n2(view2);
            } else if (booleanValue2) {
                sparseArray.put(R.id.obfuscated_res_0x7f091e69, 0);
                sparseArray.put(R.id.obfuscated_res_0x7f091e52, 1);
                this.a.c.c4(sparseArray);
            } else if (booleanValue3) {
                this.a.i2(((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091e5a)).intValue(), (String) sparseArray.get(R.id.obfuscated_res_0x7f091e58), ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091e75)).intValue(), ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091e59)).booleanValue());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ gw7 b;

        public d0(gw7 gw7Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gw7Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = gw7Var;
            this.a = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (oi.C()) {
                    UrlManager.getInstance().dealOneLink(this.b.c.getPageContext(), new String[]{this.a});
                    this.b.c.finish();
                    return;
                }
                this.b.c.showToast(R.string.obfuscated_res_0x7f0f0c17);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gw7 a;

        public e(gw7 gw7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gw7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gw7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.D2();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kw4 a;
        public final /* synthetic */ gw7 b;

        public e0(gw7 gw7Var, kw4 kw4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gw7Var, kw4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = gw7Var;
            this.a = kw4Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a == null || this.b.I0 == null || this.b.I1 == null) {
                return;
            }
            this.b.I1.g(this.a);
            this.b.I1.setAutoCompleteShown(false);
        }
    }

    /* loaded from: classes6.dex */
    public class f implements PbFakeFloorModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gw7 a;

        public f(gw7 gw7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gw7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gw7Var;
        }

        @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.b
        public void a(PostData postData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, postData) == null) {
                this.a.d1.P(postData);
                this.a.C.Z();
                this.a.e1.c();
                this.a.k0.q();
                this.a.w3(false);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Parcelable a;
        public final /* synthetic */ ArrayList b;
        public final /* synthetic */ bs7 c;
        public final /* synthetic */ gw7 d;

        public f0(gw7 gw7Var, Parcelable parcelable, ArrayList arrayList, bs7 bs7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gw7Var, parcelable, arrayList, bs7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = gw7Var;
            this.a = parcelable;
            this.b = arrayList;
            this.c = bs7Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.d.l.onRestoreInstanceState(this.a);
                if (ListUtils.getCount(this.b) <= 1 || this.c.y().b() <= 0) {
                    return;
                }
                this.d.I.f();
                this.d.I.C(this.d.c.getString(R.string.obfuscated_res_0x7f0f0daa));
                this.d.I.x();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements FallingView.m {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gw7 a;

        public g(gw7 gw7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gw7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gw7Var;
        }

        @Override // com.baidu.tieba.pb.view.FallingView.m
        public void onAnimationEnd() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.Q3();
            }
        }

        @Override // com.baidu.tieba.pb.view.FallingView.m
        public void onAnimationStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.H1.setTag(Boolean.FALSE);
                if (this.a.I1 == null) {
                    return;
                }
                this.a.I1.setAutoCompleteShown(false);
                if (this.a.I1.getVisibility() == 0) {
                    this.a.I1.setTag(this.a.H1);
                    this.a.I1.c();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g0 implements PbLandscapeListView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gw7 a;

        public g0(gw7 gw7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gw7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gw7Var;
        }

        @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.c
        public void a(int i, int i2, float f, float f2, float f3, float f4) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)}) == null) && this.a.c != null && this.a.c.isAdded()) {
                if (i < 0 && f > this.a.l1) {
                    this.a.i0();
                    this.a.b2();
                }
                this.a.p0();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gw7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(gw7 gw7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gw7Var, Integer.valueOf(i)};
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
            this.a = gw7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2005016 || this.a.C == null) {
                return;
            }
            this.a.C.Z();
        }
    }

    /* loaded from: classes6.dex */
    public class h0 implements cr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gw7 a;

        public h0(gw7 gw7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gw7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gw7Var;
        }

        @Override // com.repackage.cr4.e
        public void onClick(cr4 cr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cr4Var) == null) {
                this.a.i0();
                cr4Var.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gw7 a;

        public i(gw7 gw7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gw7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gw7Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.y == null) {
                    this.a.u1();
                }
                this.a.k.setVisibility(0);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i0 implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gw7 a;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ i0 a;

            public a(i0 i0Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {i0Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = i0Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.a.c.HidenSoftKeyPad((InputMethodManager) this.a.a.c.getBaseFragmentActivity().getSystemService("input_method"), this.a.a.d);
                }
            }
        }

        public i0(gw7 gw7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gw7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gw7Var;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                if (this.a.c1 == null) {
                    this.a.c1 = new a(this);
                }
                pg.a().postDelayed(this.a.c1, 150L);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gw7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(gw7 gw7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gw7Var, Integer.valueOf(i)};
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
            this.a = gw7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            this.a.E0 = false;
        }
    }

    /* loaded from: classes6.dex */
    public class j0 implements cr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public j0(gw7 gw7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gw7Var};
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

    /* loaded from: classes6.dex */
    public class k implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gw7 a;

        public k(gw7 gw7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gw7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gw7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.D2();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class k0 implements cr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public k0(gw7 gw7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gw7Var};
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

    /* loaded from: classes6.dex */
    public class l implements j05 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gw7 a;

        public l(gw7 gw7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gw7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gw7Var;
        }

        @Override // com.repackage.j05
        public void onAction(i05 i05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, i05Var) == null) {
                Object obj = i05Var.c;
                if (obj instanceof zw4) {
                    if (((zw4) obj).getType() == EmotionGroupType.BIG_EMOTION || ((zw4) i05Var.c).getType() == EmotionGroupType.USER_COLLECT) {
                        if (this.a.z1 == null) {
                            this.a.z1 = new PermissionJudgePolicy();
                        }
                        this.a.z1.clearRequestPermissionList();
                        this.a.z1.appendRequestPermission(this.a.c.getBaseFragmentActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (this.a.z1.startRequestPermission(this.a.c.getBaseFragmentActivity())) {
                            return;
                        }
                        this.a.c.L4().h((zw4) i05Var.c);
                        this.a.c.L4().z(false, null);
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class l0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;
        public final /* synthetic */ View d;
        public final /* synthetic */ gw7 e;

        public l0(gw7 gw7Var, int i, int i2, int i3, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gw7Var, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = gw7Var;
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.d = view2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int i = this.a;
                if (i == this.b || i - this.c >= 0) {
                    this.e.n1.showAsDropDown(this.e.r0, this.d.getLeft(), -this.e.r0.getHeight());
                } else {
                    this.e.n1.showAsDropDown(this.d);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class m implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gw7 a;

        public m(gw7 gw7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gw7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gw7Var;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || this.a.c.G0 == null || this.a.c.G0.e() == null) {
                return;
            }
            if (!this.a.c.G0.e().e()) {
                this.a.c.G0.a(false);
            }
            this.a.c.G0.e().l(false);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            int i4;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) == null) || this.a.k0 == null || this.a.k0.getVisibility() != 0 || charSequence == null || charSequence.length() < (i4 = i3 + i)) {
                return;
            }
            String substring = charSequence.toString().substring(i, i4);
            if (TextUtils.isEmpty(substring)) {
                return;
            }
            if (this.a.q1 == null) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(11);
                layoutParams.addRule(2, this.a.k0.getId());
                gw7 gw7Var = this.a;
                gw7Var.q1 = new ex7(gw7Var.c.getPageContext(), this.a.d, layoutParams);
                if (!ListUtils.isEmpty(this.a.p1)) {
                    this.a.q1.q(this.a.p1);
                }
                this.a.q1.r(this.a.k0);
            }
            this.a.q1.p(substring);
        }
    }

    /* loaded from: classes6.dex */
    public class m0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kw4 a;
        public final /* synthetic */ gw7 b;

        public m0(gw7 gw7Var, kw4 kw4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gw7Var, kw4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = gw7Var;
            this.a = kw4Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921664));
                this.b.I1.setHomePbFloatLastCloseTime();
                this.b.p1();
                this.b.I1.u(this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class n implements nr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ gw7 b;

        public n(gw7 gw7Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gw7Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = gw7Var;
            this.a = z;
        }

        @Override // com.repackage.nr4.e
        public void onItemClick(nr4 nr4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, nr4Var, i, view2) == null) {
                this.b.Q.dismiss();
                SparseArray<Object> sparseArray = (SparseArray) view2.getTag();
                if (sparseArray == null) {
                    return;
                }
                switch (i) {
                    case 10:
                        this.b.i2(((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091e5a)).intValue(), (String) sparseArray.get(R.id.obfuscated_res_0x7f091e58), ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091e75)).intValue(), ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091e59)).booleanValue());
                        return;
                    case 11:
                        if (this.b.R1 != null) {
                            this.b.R1.a(new Object[]{sparseArray.get(R.id.obfuscated_res_0x7f091e75), sparseArray.get(R.id.obfuscated_res_0x7f091e63), sparseArray.get(R.id.obfuscated_res_0x7f091e66), sparseArray.get(R.id.obfuscated_res_0x7f091e64), sparseArray.get(R.id.obfuscated_res_0x7f091e65)});
                            return;
                        }
                        return;
                    case 12:
                        this.b.c.X4(this.a, (String) sparseArray.get(R.id.obfuscated_res_0x7f091ea7), sparseArray);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class n0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gw7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n0(gw7 gw7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gw7Var, Integer.valueOf(i)};
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
            this.a = gw7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2921306) {
                this.a.L1 = null;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class o implements cr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public o(gw7 gw7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gw7Var};
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

    /* loaded from: classes6.dex */
    public class o0 implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;
        public final /* synthetic */ gw7 b;

        public o0(gw7 gw7Var, PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gw7Var, pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = gw7Var;
            this.a = pbFragment;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.b.E1 || this.a == null || this.b.c.w() == null || !this.b.c.w().C1()) {
                return;
            }
            this.b.E1 = true;
            this.a.Z3(false);
        }
    }

    /* loaded from: classes6.dex */
    public class p implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlertDialog a;
        public final /* synthetic */ SparseArray b;
        public final /* synthetic */ gw7 c;

        public p(gw7 gw7Var, AlertDialog alertDialog, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gw7Var, alertDialog, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = gw7Var;
            this.a = alertDialog;
            this.b = sparseArray;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                AlertDialog alertDialog = this.a;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                }
                if (!mi.A()) {
                    oi.M(this.c.c.x(), R.string.obfuscated_res_0x7f0f0c17);
                } else {
                    this.c.c.k4(this.b, null);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class p0 implements bt7.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gw7 a;

        public p0(gw7 gw7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gw7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gw7Var;
        }

        @Override // com.repackage.bt7.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.c.a5();
            }
        }

        @Override // com.repackage.bt7.b
        public void b() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.a.l == null) {
                return;
            }
            if (this.a.r != null) {
                this.a.r.t();
            }
            this.a.l.setSelection(0);
        }
    }

    /* loaded from: classes6.dex */
    public class q implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlertDialog a;

        public q(gw7 gw7Var, AlertDialog alertDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gw7Var, alertDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            AlertDialog alertDialog;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || (alertDialog = this.a) == null) {
                return;
            }
            alertDialog.dismiss();
        }
    }

    /* loaded from: classes6.dex */
    public class q0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gw7 a;

        public q0(gw7 gw7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gw7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gw7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.c.getActivity(), LoginDialogData.PB_BOTTOM_REPLY_RESULT_PAGE))) {
                this.a.c.I5();
                if (this.a.c == null || this.a.c.w() == null || this.a.c.w().T0() == null || this.a.c.w().T0().O() == null || this.a.c.w().T0().O().getAuthor() == null) {
                    return;
                }
                TiebaStatic.log(new StatisticItem("c13701").param("tid", this.a.c.w().m1()).param("fid", this.a.c.w().T0().m()).param("uid", TbadkCoreApplication.getCurrentAccountId()));
                TiebaStatic.log(new StatisticItem("c13402").param("tid", this.a.c.w().b).param("fid", this.a.c.w().T0().m()).param("obj_locate", 1).param("uid", this.a.c.w().T0().O().getAuthor().getUserId()));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class r implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlertDialog a;
        public final /* synthetic */ SparseArray b;
        public final /* synthetic */ gw7 c;

        public r(gw7 gw7Var, AlertDialog alertDialog, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gw7Var, alertDialog, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = gw7Var;
            this.a = alertDialog;
            this.b = sparseArray;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                AlertDialog alertDialog = this.a;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                }
                if (!mi.A()) {
                    oi.M(this.c.c.x(), R.string.obfuscated_res_0x7f0f0c17);
                } else {
                    this.c.c.k4(this.b, null);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class r0 implements at7 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gw7 a;

        public r0(gw7 gw7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gw7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gw7Var;
        }

        @Override // com.repackage.at7
        public /* synthetic */ void onStart() {
            zs7.a(this);
        }

        @Override // com.repackage.at7
        public void onStop() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.o0.setVisibility(8);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class s implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlertDialog a;

        public s(gw7 gw7Var, AlertDialog alertDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gw7Var, alertDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            AlertDialog alertDialog;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || (alertDialog = this.a) == null) {
                return;
            }
            alertDialog.dismiss();
        }
    }

    /* loaded from: classes6.dex */
    public static class s0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public int b;
        public PbReplyTitleViewHolder c;

        public s0() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class t implements nk8.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public t() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.nk8.f
        public void onRefresh() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public class u implements yh5.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cr4 a;
        public final /* synthetic */ gw7 b;

        public u(gw7 gw7Var, cr4 cr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gw7Var, cr4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = gw7Var;
            this.a = cr4Var;
        }

        @Override // com.repackage.yh5.g
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                this.b.c.l4(this.a, jSONArray);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class v implements bi5.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SparseArray a;
        public final /* synthetic */ gw7 b;

        public v(gw7 gw7Var, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gw7Var, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = gw7Var;
            this.a = sparseArray;
        }

        @Override // com.repackage.bi5.h
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                this.b.c.k4(this.a, jSONArray);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class w implements CompoundButton.OnCheckedChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gw7 a;

        public w(gw7 gw7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gw7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gw7Var;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, compoundButton, z) == null) && z) {
                this.a.a0 = (String) compoundButton.getTag();
                if (this.a.n != null) {
                    for (CustomBlueCheckRadioButton customBlueCheckRadioButton : this.a.n) {
                        String str = (String) customBlueCheckRadioButton.getTag();
                        if (str != null && this.a.a0 != null && !str.equals(this.a.a0)) {
                            customBlueCheckRadioButton.setChecked(false);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class x implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gw7 a;

        public x(gw7 gw7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gw7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gw7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (this.a.U instanceof Dialog)) {
                rg.b(this.a.U, this.a.c.getPageContext());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class y implements nr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ er4.c a;
        public final /* synthetic */ gw7 b;

        public y(gw7 gw7Var, er4.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gw7Var, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = gw7Var;
            this.a = cVar;
        }

        @Override // com.repackage.nr4.e
        public void onItemClick(nr4 nr4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, nr4Var, i, view2) == null) {
                this.b.c0.dismiss();
                this.a.a(null, i, view2);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class z implements nr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ er4.c a;
        public final /* synthetic */ gw7 b;

        public z(gw7 gw7Var, er4.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gw7Var, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = gw7Var;
            this.a = cVar;
        }

        @Override // com.repackage.nr4.e
        public void onItemClick(nr4 nr4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, nr4Var, i, view2) == null) {
                this.b.c0.dismiss();
                this.a.a(null, i, view2);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755663542, "Lcom/repackage/gw7;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755663542, "Lcom/repackage/gw7;");
                return;
            }
        }
        c2 = UtilHelper.getLightStatusBarHeight();
        d2 = 3;
        e2 = 0;
        f2 = 3;
        g2 = 4;
        h2 = 5;
        i2 = 6;
        j2 = oi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds80);
        k2 = new t();
    }

    public gw7(PbFragment pbFragment, View.OnClickListener onClickListener, dt7 dt7Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pbFragment, onClickListener, dt7Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = 0;
        this.g = new Handler();
        this.l = null;
        this.C = null;
        this.D = null;
        this.E = null;
        this.F = null;
        this.G = null;
        this.H = null;
        this.I = null;
        this.J = null;
        this.K = null;
        this.L = null;
        this.N = null;
        this.O = null;
        this.P = null;
        this.Q = null;
        this.R = null;
        this.S = null;
        this.T = null;
        this.U = null;
        this.V = null;
        this.W = null;
        this.X = null;
        this.Y = null;
        this.Z = null;
        this.a0 = null;
        this.b0 = null;
        this.c0 = null;
        this.d0 = null;
        this.e0 = false;
        this.f0 = false;
        this.g0 = null;
        this.h0 = null;
        this.j0 = null;
        this.l0 = false;
        this.p0 = null;
        this.r0 = null;
        this.u0 = null;
        this.E0 = true;
        this.G0 = null;
        this.H0 = false;
        this.L0 = 3;
        this.M0 = false;
        this.N0 = null;
        this.W0 = 0;
        this.X0 = true;
        this.Y0 = new s0();
        this.a1 = 0;
        this.g1 = false;
        this.h1 = 0;
        this.i1 = false;
        this.j1 = false;
        this.k1 = false;
        this.l1 = 0;
        this.t1 = false;
        this.A1 = 0L;
        this.D1 = 0;
        this.M1 = new n0(this, 2921306);
        this.N1 = new h(this, 2005016);
        this.O1 = new Handler();
        this.Q1 = new j(this, 2004009);
        this.S1 = true;
        this.T1 = new a0(this);
        this.U1 = false;
        this.V1 = null;
        this.Y1 = new ArrayList();
        this.a2 = false;
        this.A1 = System.currentTimeMillis();
        this.c = pbFragment;
        this.N = onClickListener;
        this.i0 = dt7Var;
        this.l1 = oi.k(pbFragment.getContext()) / 8;
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.c.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d05fb, (ViewGroup) null);
        this.d = relativeLayout;
        relativeLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.m0 = this.d.findViewById(R.id.obfuscated_res_0x7f0903e4);
        this.v1 = (NavigationBarCoverTip) this.d.findViewById(R.id.obfuscated_res_0x7f0916fe);
        this.e = this.d.findViewById(R.id.obfuscated_res_0x7f091d93);
        this.J1 = (FrameLayout) this.d.findViewById(R.id.obfuscated_res_0x7f091aa3);
        this.B = (ObservedChangeRelativeLayout) this.d.findViewById(R.id.obfuscated_res_0x7f092047);
        this.m = (NoNetworkView) this.d.findViewById(R.id.obfuscated_res_0x7f0923ae);
        this.l = (PbLandscapeListView) this.d.findViewById(R.id.obfuscated_res_0x7f09154d);
        this.P0 = (FrameLayout) this.d.findViewById(R.id.obfuscated_res_0x7f091ad2);
        this.Q0 = new TextView(this.c.getActivity());
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + oi.f(this.c.getActivity(), R.dimen.obfuscated_res_0x7f070309));
        this.l.x(this.Q0, 0);
        this.l.setTextViewAdded(true);
        this.b1 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds134);
        this.V0 = new View(this.c.getPageContext().getPageActivity());
        if (qg5.d()) {
            this.V0.setLayoutParams(new AbsListView.LayoutParams(-1, 0));
        } else {
            this.V0.setLayoutParams(new AbsListView.LayoutParams(-1, this.b1));
        }
        this.V0.setVisibility(4);
        this.l.addFooterView(this.V0);
        this.l.setOnTouchListener(this.c.D2);
        this.a = new o0(this, pbFragment);
        this.l.getViewTreeObserver().addOnGlobalLayoutListener(this.a);
        this.h = new dy7(pbFragment, this.d);
        if (this.c.D4()) {
            ViewStub viewStub = (ViewStub) this.d.findViewById(R.id.obfuscated_res_0x7f09138a);
            this.j = viewStub;
            viewStub.setVisibility(0);
            cy7 cy7Var = new cy7(pbFragment);
            this.i = cy7Var;
            cy7Var.c();
            this.h.a.setVisibility(8);
            layoutParams.height = oi.f(this.c.getActivity(), R.dimen.obfuscated_res_0x7f07023f);
        }
        this.Q0.setLayoutParams(layoutParams);
        this.h.p().setOnTouchListener(new bt7(new p0(this)));
        this.q0 = this.d.findViewById(R.id.obfuscated_res_0x7f092394);
        this.r0 = this.d.findViewById(R.id.obfuscated_res_0x7f0916a1);
        oi.f(TbadkCoreApplication.getInst(), R.dimen.tbds120);
        this.F0 = oi.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f070287);
        HeadImageView headImageView = (HeadImageView) this.d.findViewById(R.id.obfuscated_res_0x7f0916a5);
        this.t0 = headImageView;
        headImageView.setVisibility(0);
        this.t0.setIsRound(true);
        this.t0.setBorderWidth(oi.f(this.c.getContext(), R.dimen.L_X01));
        this.t0.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
        this.t0.setPlaceHolder(0);
        S1();
        this.u0 = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f0916a4);
        LinearLayout linearLayout = (LinearLayout) this.d.findViewById(R.id.obfuscated_res_0x7f09169c);
        this.s0 = linearLayout;
        linearLayout.setOnClickListener(new q0(this));
        EjectionAnimationView ejectionAnimationView = (EjectionAnimationView) this.d.findViewById(R.id.obfuscated_res_0x7f090871);
        this.o0 = ejectionAnimationView;
        ejectionAnimationView.setEjectionAnimationViewCallback(new r0(this));
        this.w0 = (ImageView) this.d.findViewById(R.id.obfuscated_res_0x7f0916a2);
        this.G1 = (MaskView) this.d.findViewById(R.id.obfuscated_res_0x7f0913ab);
        this.w0.setOnClickListener(this.N);
        AgreeView agreeView = (AgreeView) this.d.findViewById(R.id.obfuscated_res_0x7f09169e);
        this.x0 = agreeView;
        agreeView.setAgreeAlone(true);
        this.x0.r();
        this.x0.setAgreeLongClickListener(new b(this));
        this.x0.setAfterClickListener(new c(this));
        if (UbsABTestHelper.isLikeModifyTestA()) {
            this.x0.setUseDynamicLikeRes("/pb");
        }
        if (this.x0.getAgreeNumView() != null) {
            this.x0.getAgreeNumView().setVisibility(8);
        }
        if (this.x0.getMsgData() != null) {
            this.x0.getMsgData().a = BdUniqueId.gen();
        }
        boolean booleanExtra = this.c.getBaseFragmentActivity().getIntent().getBooleanExtra("key_is_from_dynamic", false);
        ImageView imageView = (ImageView) this.d.findViewById(R.id.obfuscated_res_0x7f0916a0);
        this.y0 = imageView;
        imageView.setOnClickListener(this.N);
        if (booleanExtra) {
            this.y0.setVisibility(8);
        } else {
            this.y0.setVisibility(0);
        }
        ImageView imageView2 = (ImageView) this.d.findViewById(R.id.obfuscated_res_0x7f0916a6);
        this.z0 = imageView2;
        imageView2.setOnClickListener(this.N);
        this.A0 = new n08(this.z0);
        if (!UbsABTestHelper.isResizeInduceSharingABTest() && !UbsABTestHelper.isResizeInduceSharingABTestA()) {
            this.A0.e();
        }
        TextView textView = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f0916a3);
        this.C0 = textView;
        textView.setVisibility(0);
        this.B0 = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f09169f);
        this.N0 = (ViewStub) this.d.findViewById(R.id.obfuscated_res_0x7f090f41);
        if (UbsABTestHelper.isLikeModifyTestA()) {
            this.x0.setVisibility(0);
            this.B0.setVisibility(0);
        }
        this.s = new tw7(this.c, dt7Var);
        this.u = new xw7(this.c, dt7Var, this.N);
        qu7 qu7Var = new qu7(this.c, this.l);
        this.C = qu7Var;
        qu7Var.w0(this.N);
        this.C.y0(this.i0);
        this.C.t0(this.O);
        this.C.v0(this.c.b2);
        this.C.q0(this.X1);
        d dVar = new d(this);
        this.R = dVar;
        this.C.s0(dVar);
        y1();
        s1();
        ww7 ww7Var = new ww7(this.c);
        this.w = ww7Var;
        ww7Var.f = 2;
        r1();
        this.x.a(this.l);
        this.t.a(this.l);
        this.u.j(this.l);
        this.s.a(this.l);
        PbListView pbListView = new PbListView(this.c.getPageContext().getPageActivity());
        this.I = pbListView;
        this.K = pbListView.b().findViewById(R.id.obfuscated_res_0x7f0916ee);
        this.L = this.I.b().findViewById(R.id.obfuscated_res_0x7f09168d);
        if (!this.I.i().booleanValue()) {
            this.L.setVisibility(8);
        }
        View view2 = this.K;
        if (view2 != null) {
            view2.setOnClickListener(this.N);
            SkinManager.setBackgroundResource(this.K, R.drawable.pb_foot_more_trans_selector);
        }
        View view3 = this.L;
        if (view3 != null) {
            view3.setOnClickListener(this.N);
        }
        this.I.z();
        this.I.o(R.drawable.pb_foot_more_trans_selector);
        this.I.p(R.drawable.pb_foot_more_trans_selector);
        this.M = this.d.findViewById(R.id.obfuscated_res_0x7f0923ca);
        this.c.registerListener(this.Q1);
        this.d1 = new PbFakeFloorModel(this.c.getPageContext());
        PbModel w2 = this.c.w();
        this.d1.R(w2.H(), w2.D(), w2.E(), w2.C(), w2.I());
        cv7 cv7Var = new cv7(this.c.getPageContext(), this.d1, this.d);
        this.e1 = cv7Var;
        cv7Var.k(new e(this));
        this.e1.n(this.c.f2);
        this.d1.T(new f(this));
        if (this.c.w() != null && !StringUtils.isNull(this.c.w().W0())) {
            PbFragment pbFragment2 = this.c;
            pbFragment2.showToast(pbFragment2.w().W0());
        }
        this.R0 = this.d.findViewById(R.id.obfuscated_res_0x7f0916a8);
        this.S0 = this.d.findViewById(R.id.obfuscated_res_0x7f0903df);
        View findViewById = this.d.findViewById(R.id.obfuscated_res_0x7f091d9f);
        this.T0 = findViewById;
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
        if (this.c.w() != null && this.c.w().F0()) {
            this.R0.setVisibility(0);
            if (layoutParams2 != null) {
                layoutParams2.height = 0;
                this.T0.setLayoutParams(layoutParams2);
            }
        } else if (layoutParams2 != null) {
            layoutParams2.height = c2;
            this.T0.setLayoutParams(layoutParams2);
        }
        PbReplyTitleViewHolder pbReplyTitleViewHolder = new PbReplyTitleViewHolder(this.c.getPageContext(), this.d.findViewById(R.id.obfuscated_res_0x7f09171c));
        this.U0 = pbReplyTitleViewHolder;
        pbReplyTitleViewHolder.s(pbFragment.k0);
        this.U0.g.setVisibility(8);
        this.U0.r(this.N);
        this.U0.p(this.c.b2);
        this.c.registerListener(this.N1);
        this.c.registerListener(this.M1);
        PbFragment pbFragment3 = this.c;
        this.F1 = new m08(pbFragment3, pbFragment3.getUniqueId());
        this.H1 = (FallingView) this.d.findViewById(R.id.obfuscated_res_0x7f090975);
        J2();
        this.H1.setAnimationListener(new g(this));
        d0();
        C2(false);
        this.n0 = this.d.findViewById(R.id.obfuscated_res_0x7f091693);
        c0(qg5.d());
        if (UbsABTestHelper.isPbForumGuideTestA() && w2.G1() && gr7.b().e()) {
            if (this.p == null) {
                this.p = new gv7(this.c.getActivity(), (ViewGroup) g1().findViewById(R.id.obfuscated_res_0x7f0916c7));
            }
            fv7 fv7Var = new fv7(this.l);
            this.q = fv7Var;
            fv7Var.d(new fv7.a() { // from class: com.repackage.hu7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.repackage.fv7.a
                public final void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        gw7.this.P1();
                    }
                }
            });
        }
    }

    public FallingView A0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.H1 : (FallingView) invokeV.objValue;
    }

    public boolean A1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.U1 : invokeV.booleanValue;
    }

    public void A2() {
        PbLandscapeListView pbLandscapeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (pbLandscapeListView = this.l) == null) {
            return;
        }
        this.x.d(pbLandscapeListView);
        this.t.d(this.l);
        this.u.w(this.l);
        this.v.d(this.l);
        this.s.f(this.l);
    }

    public void A3(boolean z2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048579, this, z2) == null) || this.r0 == null || (textView = this.u0) == null) {
            return;
        }
        textView.setText(R.string.obfuscated_res_0x7f0f0507);
        if (z2) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(400L);
            this.r0.startAnimation(alphaAnimation);
        }
        this.q0.setVisibility(0);
        this.r0.setVisibility(0);
        this.E0 = true;
        if (this.Z0 == null || this.r1.l()) {
            return;
        }
        this.Z0.setVisibility(0);
        C2(true);
    }

    public int B0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? D0(this.l.getFirstVisiblePosition()) : invokeV.intValue;
    }

    public boolean B1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.E0 : invokeV.booleanValue;
    }

    public final void B2() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (pbFragment = this.c) == null || pbFragment.L4() == null || this.k0 == null) {
            return;
        }
        i25.a().c(0);
        m25 L4 = this.c.L4();
        L4.T();
        L4.R();
        if (L4.y() != null) {
            L4.y().setMaxImagesAllowed(L4.v ? 1 : 9);
        }
        L4.l0(SendView.g);
        L4.j(SendView.g);
        p05 m2 = this.k0.m(23);
        p05 m3 = this.k0.m(2);
        p05 m4 = this.k0.m(5);
        if (m3 != null) {
            m3.b();
        }
        if (m4 != null) {
            m4.b();
        }
        if (m2 != null) {
            m2.hide();
        }
        this.k0.invalidate();
    }

    public void B3(View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, view2) == null) || vt4.k().h("show_long_press_collection_tips", false)) {
            return;
        }
        Rect rect = new Rect();
        this.r0.getGlobalVisibleRect(rect);
        int i3 = rect.bottom;
        int i4 = rect.top;
        view2.getGlobalVisibleRect(rect);
        int i5 = rect.bottom;
        FrameLayout frameLayout = new FrameLayout(this.c.getContext());
        frameLayout.setBackgroundResource(R.drawable.pic_sign_tip);
        TextView textView = new TextView(this.c.getContext());
        this.o1 = textView;
        textView.setText(R.string.obfuscated_res_0x7f0f042d);
        this.o1.setGravity(17);
        this.o1.setPadding(oi.f(this.c.getContext(), R.dimen.obfuscated_res_0x7f0701e8), 0, oi.f(this.c.getContext(), R.dimen.obfuscated_res_0x7f0701e8), 0);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        layoutParams.height = oi.f(this.c.getContext(), R.dimen.obfuscated_res_0x7f070253);
        if (this.o1.getParent() == null) {
            frameLayout.addView(this.o1, layoutParams);
        }
        PopupWindow popupWindow = new PopupWindow(this.c.getContext());
        this.n1 = popupWindow;
        popupWindow.setContentView(frameLayout);
        this.n1.setHeight(-2);
        this.n1.setWidth(-2);
        this.n1.setFocusable(true);
        this.n1.setOutsideTouchable(false);
        this.n1.setBackgroundDrawable(new ColorDrawable(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent)));
        this.l.postDelayed(new l0(this, i5, i3, i4, view2), 100L);
        vt4.k().u("show_long_press_collection_tips", true);
    }

    public PostData C0(bs7 bs7Var, boolean z2) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, bs7Var, z2)) == null) {
            PostData postData = null;
            if (bs7Var == null) {
                return null;
            }
            if (bs7Var.W() != null) {
                return bs7Var.W();
            }
            if (!ListUtils.isEmpty(bs7Var.F())) {
                Iterator<PostData> it = bs7Var.F().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    PostData next = it.next();
                    if (next != null && next.A() == 1) {
                        postData = next;
                        break;
                    }
                }
            }
            if (postData == null) {
                postData = bs7Var.j();
            }
            if (!F1(postData)) {
                postData = X0(bs7Var);
            }
            if (postData != null && postData.s() != null && postData.s().getUserTbVipInfoData() != null && postData.s().getUserTbVipInfoData().getvipIntro() != null) {
                postData.s().getGodUserData().setIntro(postData.s().getUserTbVipInfoData().getvipIntro());
            }
            return postData;
        }
        return (PostData) invokeLZ.objValue;
    }

    public final boolean C1(bs7 bs7Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, bs7Var)) == null) {
            if (bs7Var == null || bs7Var.O() == null) {
                return false;
            }
            SpannableStringBuilder span_str = bs7Var.O().getSpan_str();
            if (span_str != null) {
                return TbadkApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0d98).equals(span_str.toString());
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void C2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z2) == null) {
        }
    }

    public void C3() {
        dy7 dy7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (dy7Var = this.h) == null || this.k1) {
            return;
        }
        dy7Var.C();
        this.k1 = true;
    }

    public final int D0(int i3) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i3)) == null) {
            lo adapter2 = this.l.getAdapter2();
            if (adapter2 == null) {
                return i3;
            }
            if (i3 < adapter2.getCount() && i3 >= 0 && (adapter2.getItem(i3) instanceof yr7)) {
                i3++;
            }
            int o2 = (adapter2.o() + adapter2.m()) - 1;
            if (i3 > o2) {
                i3 = o2;
            }
            int n2 = (this.l.getAdapter2() == null || !(this.l.getAdapter2() instanceof lo)) ? 0 : this.l.getAdapter2().n();
            if (i3 > n2) {
                return i3 - n2;
            }
            return 0;
        }
        return invokeI.intValue;
    }

    public boolean D1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView == null) {
                return false;
            }
            return pbLandscapeListView.J();
        }
        return invokeV.booleanValue;
    }

    public void D2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            B2();
            k1();
            this.e1.c();
            w3(false);
        }
    }

    public void D3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.l.setVisibility(0);
        }
    }

    public Button E0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.p0 : (Button) invokeV.objValue;
    }

    public boolean E1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            EditorTools editorTools = this.k0;
            return editorTools != null && editorTools.getVisibility() == 0;
        }
        return invokeV.booleanValue;
    }

    public final void E2() {
        yw7 yw7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || (yw7Var = this.r) == null) {
            return;
        }
        yw7Var.q(this.l, this.Q0, this.K0);
    }

    public void E3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            if (this.G0 == null) {
                this.G0 = new xt4(this.c.getPageContext());
            }
            this.G0.h(true);
        }
    }

    public int F0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.l.getHeaderViewsCount() : invokeV.intValue;
    }

    public final boolean F1(PostData postData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, postData)) == null) {
            if (postData == null || postData.s() == null) {
                return false;
            }
            MetaData s2 = postData.s();
            return (TextUtils.isEmpty(s2.getUserId()) && TextUtils.isEmpty(s2.getAvater())) ? false : true;
        }
        return invokeL.booleanValue;
    }

    public void F2() {
        Handler handler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048598, this) == null) || (handler = this.O1) == null) {
            return;
        }
        Runnable runnable = this.P1;
        if (runnable != null) {
            handler.removeCallbacks(runnable);
        }
        i iVar = new i(this);
        this.P1 = iVar;
        this.O1.postDelayed(iVar, 2000L);
    }

    public final void F3(SparseArray<Object> sparseArray, int i3, ai5 ai5Var, UserData userData, boolean z2) {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{sparseArray, Integer.valueOf(i3), ai5Var, userData, Boolean.valueOf(z2)}) == null) || (pbFragment = this.c) == null) {
            return;
        }
        if (this.x1 == null && this.s != null) {
            this.x1 = new bi5(pbFragment.getPageContext(), this.s.c(), ai5Var, userData);
        }
        this.x1.C(z2);
        AntiData t4 = this.c.t4();
        SparseArray<String> sparseArray2 = new SparseArray<>();
        if (t4 != null && t4.getDelThreadInfoList() != null) {
            List<DeleteThreadInfo> delThreadInfoList = t4.getDelThreadInfoList();
            for (int i4 = 0; i4 < delThreadInfoList.size(); i4++) {
                if (!TextUtils.isEmpty(delThreadInfoList.get(i4).text_info)) {
                    sparseArray2.put(delThreadInfoList.get(i4).text_id, delThreadInfoList.get(i4).text_info);
                }
            }
        }
        lp4 lp4Var = new lp4();
        lp4Var.j(sparseArray2);
        this.x1.E(new String[]{this.c.getString(R.string.obfuscated_res_0x7f0f04a9), this.c.getString(R.string.obfuscated_res_0x7f0f04aa), this.c.getString(R.string.obfuscated_res_0x7f0f04ab), this.c.getString(R.string.obfuscated_res_0x7f0f04ac), this.c.getString(R.string.obfuscated_res_0x7f0f04ad)});
        this.x1.D(lp4Var);
        this.x1.G((i3 == 1 || i3 == 2) ? "4" : "3");
        this.x1.F(new v(this, sparseArray));
    }

    public TextView G0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.u.n() : (TextView) invokeV.objValue;
    }

    public boolean G1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void G2(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, editorTools) == null) {
            this.k0 = editorTools;
            editorTools.setOnCancelClickListener(new k(this));
            this.k0.setId(R.id.obfuscated_res_0x7f09169d);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            if (this.k0.getParent() == null) {
                this.d.addView(this.k0, layoutParams);
            }
            this.k0.w(TbadkCoreApplication.getInst().getSkinType());
            this.k0.setActionListener(24, new l(this));
            k1();
            this.c.L4().i(new m(this));
        }
    }

    public void G3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            this.C.g0(this.I0, false);
            this.C.Z();
        }
    }

    public int H0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            n08 n08Var = this.A0;
            if (n08Var != null) {
                return n08Var.f();
            }
            return 3;
        }
        return invokeV.intValue;
    }

    public final boolean H1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.V1) : invokeV.booleanValue;
    }

    public void H2(String str) {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048606, this, str) == null) || (pbListView = this.I) == null) {
            return;
        }
        pbListView.C(str);
    }

    public void H3(bs7 bs7Var, int i3, int i4, boolean z2, int i5, boolean z3) {
        PbLandscapeListView pbLandscapeListView;
        int i6;
        PbReplyTitleViewHolder pbReplyTitleViewHolder;
        bs7 bs7Var2;
        Parcelable e3;
        Parcelable e4;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048607, this, new Object[]{bs7Var, Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z2), Integer.valueOf(i5), Boolean.valueOf(z3)}) == null) || bs7Var == null || this.l == null) {
            return;
        }
        this.I0 = bs7Var;
        this.K0 = i3;
        if (bs7Var.O() != null) {
            this.a1 = bs7Var.O().getCopyThreadRemindType();
            if (bs7Var.O().getAnchorLevel() != 0) {
                this.U1 = true;
            }
            this.f0 = I1(bs7Var.O());
        }
        if (bs7Var.U() != null) {
            this.V1 = bs7Var.U().getUserId();
        }
        t1(bs7Var);
        a0();
        this.M0 = false;
        this.H0 = z2;
        h3();
        ks7 ks7Var = bs7Var.h;
        if (ks7Var != null && ks7Var.b()) {
            if (this.o == null) {
                PbThreadPostView pbThreadPostView = new PbThreadPostView(this.c.getContext());
                this.o = pbThreadPostView;
                this.l.x(pbThreadPostView, 1);
                this.o.setData(bs7Var);
                this.o.setChildOnClickLinstener(this.N);
            }
        } else {
            PbThreadPostView pbThreadPostView2 = this.o;
            if (pbThreadPostView2 != null && (pbLandscapeListView = this.l) != null) {
                pbLandscapeListView.removeHeaderView(pbThreadPostView2);
            }
        }
        I3(bs7Var, z2, i3, TbadkCoreApplication.getInst().getSkinType());
        x3(bs7Var);
        this.u.G(bs7Var, this.J0);
        if (this.u1 == null) {
            this.u1 = new tv7(this.c.getPageContext(), this.v1);
        }
        this.u1.a(bs7Var.w());
        if (this.c.D4()) {
            if (this.H == null) {
                o08 o08Var = new o08(this.c.getPageContext());
                this.H = o08Var;
                o08Var.n();
                this.H.f(this.W1);
            }
            this.l.setPullRefresh(this.H);
            E2();
            o08 o08Var2 = this.H;
            if (o08Var2 != null) {
                o08Var2.H(TbadkCoreApplication.getInst().getSkinType());
            }
        } else if (bs7Var.y().c() == 0 && z2) {
            this.l.setPullRefresh(null);
        } else {
            if (this.H == null) {
                o08 o08Var3 = new o08(this.c.getPageContext());
                this.H = o08Var3;
                o08Var3.n();
                this.H.f(this.W1);
            }
            this.l.setPullRefresh(this.H);
            E2();
            o08 o08Var4 = this.H;
            if (o08Var4 != null) {
                o08Var4.H(TbadkCoreApplication.getInst().getSkinType());
            }
            m1();
        }
        l0();
        this.C.o0(this.H0);
        this.C.l0(false);
        this.C.m0(i3 == 5);
        this.C.n0(i3 == 6);
        this.C.j0(z3 && this.S1 && i3 != 2);
        this.C.g0(bs7Var, false);
        this.C.Z();
        this.u.E(C0(bs7Var, z2), bs7Var.g0());
        if (bs7Var.O() != null && bs7Var.O().getPraise() != null && this.b != -1) {
            bs7Var.O().getPraise().setIsLike(this.b);
        }
        this.l.removeFooterView(this.V0);
        this.l.addFooterView(this.V0);
        if (TbadkCoreApplication.isLogin()) {
            this.l.setNextPage(this.I);
            this.f = 2;
            m1();
        } else {
            this.M0 = true;
            if (bs7Var.y().b() == 1) {
                if (this.J == null) {
                    PbFragment pbFragment = this.c;
                    this.J = new k08(pbFragment, pbFragment);
                }
                this.l.setNextPage(this.J);
            } else {
                this.l.setNextPage(this.I);
            }
            this.f = 3;
        }
        ArrayList<PostData> F = bs7Var.F();
        if (bs7Var.y().b() != 0 && F != null && F.size() >= bs7Var.y().e()) {
            if (z3) {
                if (this.S1) {
                    o0();
                    if (bs7Var.y().b() != 0) {
                        this.I.C(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0da9));
                    }
                } else {
                    this.I.z();
                    this.I.N();
                }
            } else {
                this.I.z();
                this.I.N();
            }
            this.I.k();
        } else {
            if (ListUtils.getCount(F) != 0 && (ListUtils.getCount(F) != 1 || F.get(0) == null || F.get(0).A() != 1)) {
                if (bs7Var.y().b() == 0) {
                    this.I.C(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f09e6));
                } else {
                    this.I.C(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0a2b));
                }
                this.I.k();
            } else {
                s0 s0Var = this.Y0;
                if (s0Var == null || (pbReplyTitleViewHolder = s0Var.c) == null || pbReplyTitleViewHolder.b() == null) {
                    i6 = 0;
                } else {
                    i6 = this.Y0.c.b().getTop() < 0 ? this.Y0.c.b().getHeight() : this.Y0.c.b().getBottom();
                }
                if (this.c.k5()) {
                    this.I.u(false);
                    if (ListUtils.isEmpty(bs7Var.R())) {
                        this.I.F(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0db1), i6);
                    }
                } else if (ListUtils.isEmpty(bs7Var.R())) {
                    this.I.F(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0db2), i6);
                }
                if (this.c.M4() != null && !this.c.M4().p()) {
                    this.c.M4().x();
                }
            }
            if (bs7Var.y().b() == 0 || F == null) {
                y2();
            }
        }
        if (i3 == 2) {
            this.l.setSelection(i4 > 1 ? (i4 + ((this.l.getData() == null && bs7Var.F() == null) ? 0 : (this.l.getData().size() - bs7Var.F().size()) + this.l.getHeaderViewsCount())) - 2 : 0);
        } else if (i3 != 3) {
            if (i3 == 4) {
                this.S1 = false;
            } else if (i3 == 5) {
                this.l.setSelection(0);
            } else if (i3 != 6) {
                if (i3 == 8) {
                    if (i4 == 0) {
                        yw7 yw7Var = this.r;
                        if (yw7Var != null && yw7Var.c() != null) {
                            if (this.c.getBaseFragmentActivity().isUseStyleImmersiveSticky()) {
                                this.l.setSelectionFromTop((this.C.B() + this.l.getHeaderViewsCount()) - 1, this.r.d() - oi.r(this.c.getPageContext().getPageActivity()));
                            } else {
                                this.l.setSelectionFromTop((this.C.B() + this.l.getHeaderViewsCount()) - 1, this.r.d());
                            }
                        } else {
                            this.l.setSelection(this.C.B() + this.l.getHeaderViewsCount());
                        }
                    } else if (ListUtils.isEmpty(bs7Var.R())) {
                        this.l.setSelection(i4 > 0 ? i4 + ((this.l.getData() == null && bs7Var.F() == null) ? 0 : (this.l.getData().size() - bs7Var.F().size()) + this.l.getHeaderViewsCount()) : 0);
                    } else {
                        this.l.setSelection(bs7Var.F().size() + this.l.getHeaderViewsCount());
                    }
                    this.I.f();
                    this.I.C(this.c.getString(R.string.obfuscated_res_0x7f0f0daa));
                    this.I.x();
                }
            } else if (i5 == 1 && (e4 = yv7.b().e()) != null && !(e4 instanceof RecyclerView.SavedState)) {
                this.l.onRestoreInstanceState(e4);
            } else {
                this.l.setSelection(0);
            }
        } else if (i5 == 1 && (e3 = yv7.b().e()) != null && !(e3 instanceof RecyclerView.SavedState)) {
            this.l.post(new f0(this, e3, F, bs7Var));
        }
        if (this.a1 == d2 && H1()) {
            f0();
        }
        if (this.g1) {
            s2();
            this.g1 = false;
            if (i5 == 0) {
                W2(true);
            }
        }
        if (bs7Var.d == 1 || bs7Var.e == 1) {
            if (this.m1 == null) {
                this.m1 = new PbTopTipView(this.c.getContext());
            }
            if (bs7Var.e == 1 && "game_guide".equals(this.c.R4())) {
                this.m1.setText(this.c.getString(R.string.obfuscated_res_0x7f0f0dbd));
                this.m1.l(this.d, this.L0);
            } else if (bs7Var.d == 1 && "game_news".equals(this.c.R4())) {
                this.m1.setText(this.c.getString(R.string.obfuscated_res_0x7f0f0dbc));
                this.m1.l(this.d, this.L0);
            }
        }
        this.l.removeFooterView(this.F1.a());
        if (!ListUtils.isEmpty(bs7Var.I()) && bs7Var.y().b() == 0) {
            this.l.removeFooterView(this.V0);
            this.F1.d(Math.max(this.r0.getMeasuredHeight(), this.F0 / 2));
            this.l.addFooterView(this.F1.a());
            this.F1.f(bs7Var);
        }
        u2(bs7Var);
        if (bs7Var.e0() && this.c.w().G1() && this.c.O4() != null) {
            this.c.O4().d();
        }
        if (bs7Var.g() != 3) {
            x1(bs7Var);
        }
        this.u0.setText(TbSingleton.getInstance().getAdVertiComment(bs7Var.k0(), bs7Var.l0(), Y0()));
        if (this.p == null || (bs7Var2 = this.I0) == null || bs7Var2.l() == null) {
            return;
        }
        this.p.m(this.I0.l().getImage_url());
        this.p.n(this.I0.l().getName());
        PbFragment pbFragment2 = this.c;
        if (pbFragment2 == null || pbFragment2.w() == null) {
            return;
        }
        this.p.o(this.c.w().b);
    }

    public PbInterviewStatusView I0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.O0 : (PbInterviewStatusView) invokeV.objValue;
    }

    public final boolean I1(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, threadData)) == null) {
            if (threadData == null || threadData.getAuthor() == null) {
                return false;
            }
            PostData C0 = C0(this.I0, false);
            return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), (C0 == null || C0.s() == null) ? "" : C0.s().getUserId());
        }
        return invokeL.booleanValue;
    }

    public void I2(String str) {
        PbReplyTitleViewHolder pbReplyTitleViewHolder;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048610, this, str) == null) || this.I == null) {
            return;
        }
        int i3 = 0;
        s0 s0Var = this.Y0;
        if (s0Var != null && (pbReplyTitleViewHolder = s0Var.c) != null && pbReplyTitleViewHolder.b() != null) {
            i3 = this.Y0.c.b().getTop() < 0 ? this.Y0.c.b().getHeight() : this.Y0.c.b().getBottom();
        }
        this.I.F(str, i3);
    }

    @SuppressLint({"ResourceAsColor"})
    public final void I3(bs7 bs7Var, boolean z2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048611, this, new Object[]{bs7Var, Boolean.valueOf(z2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) || bs7Var == null || bs7Var.O() == null) {
            return;
        }
        if (this.c.isSimpleForum()) {
            if (bs7Var.h() != null) {
                this.g0 = bs7Var.h().a();
                this.h0 = bs7Var.h().b();
            }
            if (this.g0 == null && this.c.w() != null && this.c.w().s0() != null) {
                this.g0 = this.c.w().s0();
            }
        }
        PostData C0 = C0(bs7Var, z2);
        f3(C0, bs7Var);
        this.u.B(8);
        if (bs7Var.r0()) {
            this.i1 = true;
            this.h.A(true);
            this.h.a.hideBottomLine();
            if (this.r == null) {
                this.r = new yw7(this.c);
            }
            this.r.v(bs7Var, C0, this.l, this.u, this.P0, this.h, this.g0, this.A1);
            this.r.s(this.T1);
            E2();
        } else {
            this.i1 = false;
            this.h.A(false);
            yw7 yw7Var = this.r;
            if (yw7Var != null) {
                yw7Var.p(this.l);
            }
        }
        if (this.c.M4() != null) {
            this.c.M4().w(this.i1);
        }
        if (C0 == null) {
            return;
        }
        this.J0 = C0;
        this.u.B(0);
        SparseArray<Object> q2 = this.u.q();
        q2.put(R.id.obfuscated_res_0x7f091e56, C0);
        q2.put(R.id.obfuscated_res_0x7f091e6f, Boolean.FALSE);
        this.v.e(bs7Var, this.l);
        this.x.e(bs7Var, this.C1, new b0(this));
        this.t.f(bs7Var);
        this.s.h(bs7Var, this.H0);
        this.s.g(bs7Var);
        this.u.C(this.L0, this.I0, C0, this.T1);
        if (this.U0 != null) {
            if (bs7Var.g0()) {
                this.U0.b().setVisibility(8);
            } else {
                this.U0.b().setVisibility(0);
                os7 os7Var = new os7(os7.h);
                if (bs7Var.O() != null) {
                    bs7Var.O().getReply_num();
                }
                os7Var.c = bs7Var.g;
                bs7Var.c();
                os7Var.d = this.c.k5();
                os7Var.g = bs7Var.f;
                this.U0.i(os7Var);
            }
        }
        U3(bs7Var);
        pg.a().post(new c0(this));
        this.w.e(this.l);
        if (C0.Q) {
            this.w.f(C0.I());
            this.w.b(this.l, this.l.getHeaderViewsCount() <= 1 ? 0 : 1);
        }
        qu7 qu7Var = this.C;
        if (qu7Var != null && qu7Var.z() != null) {
            this.C.z().m0(C0.Q);
        }
        qu7 qu7Var2 = this.C;
        if (qu7Var2 != null) {
            qu7Var2.r0(C0.Q);
        }
        this.G1.setVisibility(C0.Q ? 0 : 8);
    }

    public boolean J0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.t1 : invokeV.booleanValue;
    }

    public boolean J1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            View view2 = this.V0;
            if (view2 == null || view2.getParent() == null || this.I.m()) {
                return false;
            }
            int bottom = this.V0.getBottom();
            Rect rect = new Rect();
            this.V0.getWindowVisibleDisplayFrame(rect);
            return bottom > 0 && bottom <= rect.bottom;
        }
        return invokeV.booleanValue;
    }

    public final void J2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            this.H1.setFallingFeedbackListener(new FallingView.k() { // from class: com.repackage.gu7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.pb.view.FallingView.k
                public final void onClick() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        gw7.this.R1();
                    }
                }
            });
        }
    }

    public void J3(er4.c cVar, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048615, this, cVar, z2) == null) {
            lr4 lr4Var = this.c0;
            if (lr4Var != null) {
                lr4Var.dismiss();
                this.c0 = null;
            }
            nr4 nr4Var = new nr4(this.c.getContext());
            ArrayList arrayList = new ArrayList();
            bs7 bs7Var = this.I0;
            if (bs7Var != null && bs7Var.O() != null && !this.I0.O().isBjh()) {
                arrayList.add(new jr4(0, this.c.getPageContext().getString(R.string.obfuscated_res_0x7f0f106e), nr4Var));
            }
            if (!z2) {
                arrayList.add(new jr4(1, this.c.getPageContext().getString(R.string.obfuscated_res_0x7f0f106f), nr4Var));
            }
            nr4Var.j(arrayList);
            nr4Var.n(new z(this, cVar));
            lr4 lr4Var2 = new lr4(this.c.getPageContext(), nr4Var);
            this.c0 = lr4Var2;
            lr4Var2.m();
        }
    }

    public int K0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            int lastVisiblePosition = this.l.getLastVisiblePosition();
            if (this.r != null) {
                if (lastVisiblePosition == this.l.getCount() - 1) {
                    lastVisiblePosition--;
                }
                if (lastVisiblePosition < 0) {
                    lastVisiblePosition = 0;
                }
            }
            return D0(lastVisiblePosition);
        }
        return invokeV.intValue;
    }

    public boolean K1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            bs7 bs7Var = this.I0;
            return bs7Var == null || bs7Var.l() == null || "0".equals(this.I0.l().getId()) || "me0407".equals(this.I0.l().getName());
        }
        return invokeV.booleanValue;
    }

    public void K2(PbFragment.d3 d3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, d3Var) == null) {
            this.R1 = d3Var;
        }
    }

    public void K3(er4.c cVar, boolean z2, boolean z3, boolean z4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048619, this, new Object[]{cVar, Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4)}) == null) {
            lr4 lr4Var = this.b0;
            if (lr4Var != null) {
                lr4Var.dismiss();
                this.b0 = null;
            }
            nr4 nr4Var = new nr4(this.c.getContext());
            ArrayList arrayList = new ArrayList();
            if (!z4) {
                arrayList.add(new jr4(0, this.c.getPageContext().getString(R.string.obfuscated_res_0x7f0f043c), nr4Var));
            }
            if (z3) {
                arrayList.add(new jr4(1, this.c.getPageContext().getString(R.string.obfuscated_res_0x7f0f0fa8), nr4Var));
            } else if (!z2) {
                arrayList.add(new jr4(1, this.c.getPageContext().getString(R.string.obfuscated_res_0x7f0f0a81), nr4Var));
            } else {
                arrayList.add(new jr4(1, this.c.getPageContext().getString(R.string.obfuscated_res_0x7f0f0f84), nr4Var));
            }
            nr4Var.j(arrayList);
            nr4Var.n(new y(this, cVar));
            lr4 lr4Var2 = new lr4(this.c.getPageContext(), nr4Var);
            this.c0 = lr4Var2;
            lr4Var2.m();
        }
    }

    public BdTypeListView L0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) ? this.l : (BdTypeListView) invokeV.objValue;
    }

    public boolean L1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            yw7 yw7Var = this.r;
            return yw7Var != null && yw7Var.f();
        }
        return invokeV.booleanValue;
    }

    public void L2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048622, this, z2) == null) {
            this.l0 = z2;
        }
    }

    public void L3(AdapterView.OnItemClickListener onItemClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, onItemClickListener) == null) {
            gr4 gr4Var = this.d0;
            if (gr4Var != null) {
                gr4Var.d();
                this.d0 = null;
            }
            if (this.I0 == null) {
                return;
            }
            ArrayList<pr4> arrayList = new ArrayList<>();
            arrayList.add(new pr4(this.c.getContext().getString(R.string.obfuscated_res_0x7f0f0267), "", this.I0.L() == 1, Integer.toString(1)));
            arrayList.add(new pr4(this.c.getContext().getString(R.string.obfuscated_res_0x7f0f0b25), "", this.I0.L() == 2, Integer.toString(5)));
            arrayList.add(new pr4(this.c.getContext().getString(R.string.obfuscated_res_0x7f0f0b21), "", this.I0.L() == 3, Integer.toString(6)));
            arrayList.add(new pr4(this.c.getContext().getString(R.string.obfuscated_res_0x7f0f0b3c), "", this.I0.L() == 4, Integer.toString(7)));
            gr4 gr4Var2 = new gr4(this.c.getPageContext());
            gr4Var2.l(R.string.obfuscated_res_0x7f0f0db9);
            this.d0 = gr4Var2;
            gr4Var2.k(arrayList, onItemClickListener);
            gr4Var2.c();
            this.d0.n();
        }
    }

    public SparseArray<Object> M0(bs7 bs7Var, boolean z2, int i3) {
        InterceptResult invokeCommon;
        PostData C0;
        uo4 uo4Var;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048624, this, new Object[]{bs7Var, Boolean.valueOf(z2), Integer.valueOf(i3)})) == null) {
            StringBuilder sb = null;
            if (bs7Var == null || (C0 = C0(bs7Var, z2)) == null) {
                return null;
            }
            String userId = C0.s().getUserId();
            boolean z3 = userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount());
            SparseArray<Object> sparseArray = new SparseArray<>();
            if (i3 == 0) {
                sparseArray.put(R.id.obfuscated_res_0x7f091e58, C0.I());
                sparseArray.put(R.id.obfuscated_res_0x7f091e5a, 0);
                sparseArray.put(R.id.obfuscated_res_0x7f091e59, Boolean.valueOf(z3));
                sparseArray.put(R.id.obfuscated_res_0x7f091e75, Integer.valueOf(bs7Var.V()));
                sparseArray.put(R.id.obfuscated_res_0x7f091e98, Boolean.FALSE);
            } else if (i3 == 1) {
                if (C0.s() != null) {
                    sparseArray.put(R.id.obfuscated_res_0x7f091e63, C0.s().getUserName());
                    sparseArray.put(R.id.obfuscated_res_0x7f091e64, C0.s().getName_show());
                    sparseArray.put(R.id.obfuscated_res_0x7f091e65, C0.s().getPortrait());
                    sparseArray.put(R.id.obfuscated_res_0x7f091e66, C0.I());
                }
                sparseArray.put(R.id.obfuscated_res_0x7f091e58, C0.I());
                sparseArray.put(R.id.obfuscated_res_0x7f091e5a, 0);
                sparseArray.put(R.id.obfuscated_res_0x7f091e59, Boolean.valueOf(z3));
                sparseArray.put(R.id.obfuscated_res_0x7f091e75, Integer.valueOf(bs7Var.V()));
                sparseArray.put(R.id.obfuscated_res_0x7f091e98, Boolean.TRUE);
            }
            if (!z3) {
                List<nq4> p2 = bs7Var.p();
                if (ListUtils.getCount(p2) > 0) {
                    sb = new StringBuilder();
                    for (nq4 nq4Var : p2) {
                        if (nq4Var != null && !StringUtils.isNull(nq4Var.a()) && (uo4Var = nq4Var.g) != null && uo4Var.a && !uo4Var.c && ((i4 = uo4Var.b) == 1 || i4 == 2)) {
                            sb.append(ni.cutString(nq4Var.a(), 12));
                            sb.append(this.c.getString(R.string.obfuscated_res_0x7f0f0643));
                            sb.append("、");
                        }
                    }
                }
                if (sb != null && !StringUtils.isNull(sb.toString())) {
                    sparseArray.put(R.id.obfuscated_res_0x7f091e57, String.format(this.c.getString(R.string.obfuscated_res_0x7f0f048d), sb.toString().substring(0, sb.length() - 1)));
                }
            }
            return sparseArray;
        }
        return (SparseArray) invokeCommon.objValue;
    }

    public boolean M1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) ? this.K1 : invokeV.booleanValue;
    }

    public void M2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048626, this, z2) == null) {
            this.C.h0(z2);
        }
    }

    public void M3() {
        PostData postData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048627, this) == null) || !TbadkCoreApplication.isLogin() || this.I0 == null || !this.j1 || this.i1 || this.f0 || (postData = this.J0) == null || postData.s() == null || this.J0.s().getIsLike() || this.J0.s().hadConcerned() || this.f1 != null) {
            return;
        }
        this.f1 = new bw7(this.c);
    }

    public bu7 N0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) ? this.r1 : (bu7) invokeV.objValue;
    }

    public boolean N1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) {
            n08 n08Var = this.A0;
            if (n08Var == null) {
                return false;
            }
            return n08Var.h();
        }
        return invokeV.booleanValue;
    }

    public void N2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048630, this, z2) == null) {
            this.B1 = z2;
        }
    }

    public final void N3(cr4 cr4Var, int i3) {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048631, this, cr4Var, i3) == null) || (pbFragment = this.c) == null || cr4Var == null) {
            return;
        }
        if (this.w1 == null && this.s != null) {
            this.w1 = new yh5(pbFragment.getPageContext(), this.s.c());
        }
        AntiData t4 = this.c.t4();
        SparseArray<String> sparseArray = new SparseArray<>();
        if (t4 != null && t4.getDelThreadInfoList() != null) {
            List<DeleteThreadInfo> delThreadInfoList = t4.getDelThreadInfoList();
            for (int i4 = 0; i4 < delThreadInfoList.size(); i4++) {
                if (!TextUtils.isEmpty(delThreadInfoList.get(i4).text_info)) {
                    sparseArray.put(delThreadInfoList.get(i4).text_id, delThreadInfoList.get(i4).text_info);
                }
            }
        }
        lp4 lp4Var = new lp4();
        lp4Var.j(sparseArray);
        this.w1.y(new String[]{this.c.getString(R.string.obfuscated_res_0x7f0f04a9), this.c.getString(R.string.obfuscated_res_0x7f0f04aa), this.c.getString(R.string.obfuscated_res_0x7f0f04ab), this.c.getString(R.string.obfuscated_res_0x7f0f04ac), this.c.getString(R.string.obfuscated_res_0x7f0f04ad)});
        this.w1.x(lp4Var);
        this.w1.A((i3 == 1 || i3 == 2) ? "4" : "3");
        this.w1.z(new u(this, cr4Var));
    }

    public View O0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) ? this.L : (View) invokeV.objValue;
    }

    public boolean O1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) {
            EditorTools editorTools = this.k0;
            return editorTools != null && editorTools.u();
        }
        return invokeV.booleanValue;
    }

    public void O2(boolean z2) {
        qu7 qu7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048634, this, z2) == null) || (qu7Var = this.C) == null) {
            return;
        }
        qu7Var.i0(z2);
    }

    public void O3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048635, this) == null) {
            this.M.setVisibility(0);
        }
    }

    public final int P0(boolean z2) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048636, this, z2)) == null) {
            PbInterviewStatusView pbInterviewStatusView = this.O0;
            if (pbInterviewStatusView != null && pbInterviewStatusView.getVisibility() == 0 && z2) {
                return 0 + oi.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f07026a);
            }
            return 0;
        }
        return invokeZ.intValue;
    }

    public /* synthetic */ void P1() {
        this.l.post(new Runnable() { // from class: com.repackage.iu7
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // java.lang.Runnable
            public final void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    gw7.this.Q1();
                }
            }
        });
    }

    public void P2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048638, this, z2) == null) {
            this.t1 = z2;
        }
    }

    public void P3() {
        qu7 qu7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048639, this) == null) || (qu7Var = this.C) == null) {
            return;
        }
        qu7Var.z0();
    }

    public View Q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) ? this.K : (View) invokeV.objValue;
    }

    public /* synthetic */ void Q1() {
        gv7 gv7Var = this.p;
        if (gv7Var != null) {
            gv7Var.p();
        }
    }

    public void Q2(boolean z2) {
        yw7 yw7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048642, this, z2) == null) || (yw7Var = this.r) == null) {
            return;
        }
        yw7Var.r(z2);
    }

    public final void Q3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048643, this) == null) {
            FallingView fallingView = this.H1;
            if (fallingView != null) {
                fallingView.setTag(Boolean.TRUE);
            }
            RightFloatLayerView rightFloatLayerView = this.I1;
            if (rightFloatLayerView != null && rightFloatLayerView.getTag() == this.H1) {
                this.I1.setTag(null);
                this.I1.setAutoCompleteShown(true);
                this.I1.d();
            }
        }
    }

    public PbListView R0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) ? this.I : (PbListView) invokeV.objValue;
    }

    public /* synthetic */ void R1() {
        String Y0;
        PbFragment pbFragment = this.c;
        if (pbFragment != null && pbFragment.w() != null && this.c.w().z1()) {
            Y0 = this.c.getString(R.string.obfuscated_res_0x7f0f0dc0);
        } else {
            Y0 = Y0();
        }
        if (!StringUtils.isNull(Y0) && this.I0 != null) {
            Y0 = TbSingleton.getInstance().getAdVertiComment(this.I0.k0(), this.I0.l0(), Y0);
        }
        PbFragment pbFragment2 = this.c;
        if (pbFragment2 != null && pbFragment2.L4() != null) {
            this.c.L4().k0(Y0);
        }
        TextView textView = this.u0;
        if (textView != null) {
            textView.setText(Y0);
        }
        w3(false);
        Q3();
    }

    public void R2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048646, this, z2) == null) {
            this.C.k0(z2);
        }
    }

    public void R3() {
        n08 n08Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048647, this) == null) || (n08Var = this.A0) == null) {
            return;
        }
        n08Var.m(2);
    }

    public int S0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048648, this)) == null) {
            try {
                return Integer.parseInt(this.G.getText().toString(), 10);
            } catch (Exception unused) {
                return -1;
            }
        }
        return invokeV.intValue;
    }

    public final void S1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048649, this) == null) {
            if (this.t0 != null && TbadkCoreApplication.getCurrentAccountInfo() != null) {
                this.t0.setImageResource(0);
                this.t0.K(TbadkCoreApplication.getCurrentAccountInfo().getAvatar(), 12, false);
                return;
            }
            this.t0.setImageResource(R.drawable.obfuscated_res_0x7f08120b);
        }
    }

    public void S2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048650, this, z2) == null) {
            this.C.p0(z2);
        }
    }

    public void S3(pp4 pp4Var, cr4.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048651, this, pp4Var, eVar) == null) || pp4Var == null) {
            return;
        }
        int a2 = pp4Var.a();
        int h3 = pp4Var.h();
        cr4 cr4Var = this.D;
        if (cr4Var != null) {
            cr4Var.show();
        } else {
            this.D = new cr4(this.c.getPageContext().getPageActivity());
            View inflate = LayoutInflater.from(this.c.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0235, (ViewGroup) null);
            this.F = inflate;
            this.D.setContentView(inflate);
            this.D.setPositiveButton(R.string.obfuscated_res_0x7f0f04dd, eVar);
            this.D.setNegativeButton(R.string.obfuscated_res_0x7f0f04d8, new h0(this));
            this.D.setOnCalcelListener(new i0(this));
            this.D.create(this.c.getPageContext()).show();
        }
        EditText editText = (EditText) this.F.findViewById(R.id.obfuscated_res_0x7f090efb);
        this.G = editText;
        editText.setText("");
        TextView textView = (TextView) this.F.findViewById(R.id.obfuscated_res_0x7f09073c);
        if (a2 <= 0) {
            a2 = 1;
        }
        if (h3 <= 0) {
            h3 = 1;
        }
        textView.setText(MessageFormat.format(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0467), Integer.valueOf(a2), Integer.valueOf(h3)));
        this.c.getBaseFragmentActivity().ShowSoftKeyPadDelay(this.G, 150);
    }

    public View T0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048652, this)) == null) ? this.R0 : (View) invokeV.objValue;
    }

    public void T1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048653, this) == null) {
            u2(this.I0);
        }
    }

    public void T2(cu4.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048654, this, gVar) == null) {
            this.W1 = gVar;
            o08 o08Var = this.H;
            if (o08Var != null) {
                o08Var.f(gVar);
            }
        }
    }

    public void T3(boolean z2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048655, this, z2) == null) || this.l == null || (textView = this.Q0) == null || this.e == null) {
            return;
        }
        if (z2) {
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.e.setVisibility(0);
            } else {
                this.e.setVisibility(8);
                this.l.removeHeaderView(this.Q0);
                this.l.setTextViewAdded(false);
            }
            AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) this.Q0.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = c2;
                this.Q0.setLayoutParams(layoutParams);
            }
            E2();
            return;
        }
        AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) textView.getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT) + P0(true);
            this.Q0.setLayoutParams(layoutParams2);
        }
        E2();
        x2();
    }

    public PbFakeFloorModel U0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048656, this)) == null) ? this.d1 : (PbFakeFloorModel) invokeV.objValue;
    }

    public void U1() {
        fv7 fv7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048657, this) == null) || (fv7Var = this.q) == null) {
            return;
        }
        fv7Var.b();
    }

    public void U2(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048658, this, onClickListener) == null) {
            this.X1 = onClickListener;
            qu7 qu7Var = this.C;
            if (qu7Var != null) {
                qu7Var.q0(onClickListener);
            }
        }
    }

    public final void U3(bs7 bs7Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048659, this, bs7Var) == null) || bs7Var == null || bs7Var.O() == null || bs7Var.O().isVideoThreadType()) {
            return;
        }
        boolean z2 = bs7Var.O().getIs_good() == 1;
        boolean z3 = bs7Var.O().getIs_top() == 1;
        xw7 xw7Var = this.u;
        if (xw7Var != null) {
            xw7Var.l(bs7Var, z2, z3);
        }
        qu7 qu7Var = this.C;
        if (qu7Var == null || qu7Var.t() == null) {
            return;
        }
        this.C.t().e(bs7Var, z2, z3);
    }

    public cv7 V0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048660, this)) == null) ? this.e1 : (cv7) invokeV.objValue;
    }

    public void V1(sk8 sk8Var) {
        bs7 bs7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048661, this, sk8Var) == null) || sk8Var == null || sk8Var.a == null || sk8Var.b == null || (bs7Var = this.I0) == null || bs7Var.O() == null || this.I0.O().getAgreeData() == null) {
            return;
        }
        AgreeData agreeData = this.I0.O().getAgreeData();
        String str = sk8Var.b.nid;
        if (!TextUtils.isEmpty(str) && !"0".equals(str)) {
            BaijiahaoData baijiahaoData = agreeData.baijiahaoData;
            if (baijiahaoData == null || !TextUtils.equals(str, baijiahaoData.oriUgcNid)) {
                return;
            }
        } else {
            String str2 = sk8Var.b.threadId;
            String str3 = agreeData.threadId;
            if ("0".equals(str2) || TextUtils.isEmpty(str2) || !TextUtils.equals(str2, str3)) {
                return;
            }
        }
        AgreeData agreeData2 = sk8Var.b;
        if (agreeData2.agreeType == 2 && agreeData2.hasAgree) {
            q3(this.x0);
        }
        AgreeData agreeData3 = sk8Var.b;
        t2(agreeData3, agreeData3.agreeNum);
    }

    public void V2(String str) {
        cy7 cy7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048662, this, str) == null) || (cy7Var = this.i) == null) {
            return;
        }
        cy7Var.b(str);
    }

    @SuppressLint({"CutPasteId"})
    public void V3(bs7 bs7Var, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048663, this, bs7Var, z2) == null) || bs7Var == null) {
            return;
        }
        e4(bs7Var, z2);
        l0();
    }

    public final boolean W(AbsListView absListView, int i3) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048664, this, absListView, i3)) == null) {
            if (absListView == null) {
                return false;
            }
            boolean z2 = i3 > 0;
            if (z2 || absListView.getChildCount() <= 0) {
                return z2;
            }
            return absListView.getChildAt(0).getTop() < absListView.getListPaddingTop();
        }
        return invokeLI.booleanValue;
    }

    public yw7 W0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048665, this)) == null) ? this.r : (yw7) invokeV.objValue;
    }

    public void W1(int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048666, this, i3) == null) || this.L0 == i3) {
            return;
        }
        this.L0 = i3;
        V3(this.I0, this.H0);
        w2(this.I0, this.H0, this.K0, i3);
        this.c.getBaseFragmentActivity().getLayoutMode().k(i3 == 1);
        this.c.getBaseFragmentActivity().getLayoutMode().j(this.d);
        SkinManager.setBackgroundColor(this.d, R.color.CAM_X0201);
        SkinManager.setBackgroundColor(this.m0, R.color.CAM_X0203);
        yw7 yw7Var = this.r;
        if (yw7Var != null) {
            yw7Var.h(i3);
        }
        uw7 uw7Var = this.v;
        if (uw7Var != null) {
            uw7Var.c(i3);
        }
        tw7 tw7Var = this.s;
        if (tw7Var != null) {
            tw7Var.e(i3);
        }
        vw7 vw7Var = this.t;
        if (vw7Var != null) {
            vw7Var.c(i3);
        }
        xw7 xw7Var = this.u;
        if (xw7Var != null) {
            xw7Var.t(i3);
        }
        ww7 ww7Var = this.w;
        if (ww7Var != null) {
            ww7Var.d();
        }
        sw7 sw7Var = this.x;
        if (sw7Var != null) {
            sw7Var.c();
        }
        MaskView maskView = this.G1;
        if (maskView != null) {
            maskView.f();
        }
        PbListView pbListView = this.I;
        if (pbListView != null) {
            pbListView.d(i3);
        }
        if (this.K != null) {
            this.c.getBaseFragmentActivity().getLayoutMode().j(this.K);
            SkinManager.setBackgroundResource(this.K, R.drawable.pb_foot_more_trans_selector);
        }
        if (this.L != null) {
            this.c.getBaseFragmentActivity().getLayoutMode().j(this.L);
            SkinManager.setBackgroundResource(this.L, R.drawable.pb_foot_more_trans_selector);
        }
        cr4 cr4Var = this.D;
        if (cr4Var != null) {
            cr4Var.autoChangeSkinType(this.c.getPageContext());
        }
        a4(this.e0);
        this.C.Z();
        o08 o08Var = this.H;
        if (o08Var != null) {
            o08Var.H(i3);
        }
        EditorTools editorTools = this.k0;
        if (editorTools != null) {
            editorTools.w(i3);
        }
        k08 k08Var = this.J;
        if (k08Var != null) {
            k08Var.f(i3);
        }
        if (!ListUtils.isEmpty(this.n)) {
            for (CustomBlueCheckRadioButton customBlueCheckRadioButton : this.n) {
                customBlueCheckRadioButton.c();
            }
        }
        f4();
        UtilHelper.setStatusBarBackground(this.e, i3);
        UtilHelper.setStatusBarBackground(this.T0, i3);
        if (this.y != null) {
            f95.a(this.c.getPageContext(), this.y);
        }
        cv7 cv7Var = this.e1;
        if (cv7Var != null) {
            cv7Var.h(i3);
        }
        dy7 dy7Var = this.h;
        if (dy7Var != null) {
            yw7 yw7Var2 = this.r;
            if (yw7Var2 != null) {
                yw7Var2.i(i3);
            } else {
                dy7Var.u(i3);
            }
        }
        HeadImageView headImageView = this.t0;
        if (headImageView != null) {
            headImageView.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
        }
        LinearLayout linearLayout = this.s0;
        if (linearLayout != null) {
            linearLayout.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(oi.f(this.c.getContext(), R.dimen.tbds47), SkinManager.getColor(R.color.CAM_X0209)));
        }
        bs7 bs7Var = this.I0;
        if (bs7Var != null && bs7Var.r()) {
            WebPManager.setPureDrawable(this.y0, R.drawable.obfuscated_res_0x7f08092c, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
        } else {
            WebPManager.setPureDrawable(this.y0, R.drawable.obfuscated_res_0x7f08092b, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        }
        WebPManager.setPureDrawable(this.w0, R.drawable.obfuscated_res_0x7f08092e, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        d4(this.I0);
        SkinManager.setBackgroundColor(this.r0, R.color.CAM_X0207);
        SkinManager.setBackgroundColor(this.q0, R.color.CAM_X0203);
        SkinManager.setViewTextColor(this.o1, (int) R.color.cp_cont_n);
        SkinManager.setViewTextColor(this.u0, (int) R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.D0, (int) R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.C0, (int) R.color.CAM_X0107);
        SkinManager.setBackgroundShapeDrawable(this.C0, oi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18), R.color.CAM_X0207, R.color.CAM_X0207);
        SkinManager.setViewTextColor(this.B0, (int) R.color.CAM_X0107);
        SkinManager.setBackgroundShapeDrawable(this.B0, oi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18), R.color.CAM_X0207, R.color.CAM_X0207);
        AgreeView agreeView = this.x0;
        if (agreeView != null) {
            agreeView.r();
            this.x0.J(i3);
            AgreeData data = this.x0.getData();
            if (data != null) {
                t2(data, data.agreeNum);
            }
        }
        bu7 bu7Var = this.r1;
        if (bu7Var != null) {
            bu7Var.m(i3);
        }
        PbEmotionBar pbEmotionBar = this.Z0;
        if (pbEmotionBar != null) {
            pbEmotionBar.w();
        }
        PbThreadPostView pbThreadPostView = this.o;
        if (pbThreadPostView != null) {
            pbThreadPostView.c(i3);
        }
        n08 n08Var = this.A0;
        if (n08Var != null) {
            n08Var.i();
        }
        m08 m08Var = this.F1;
        if (m08Var != null) {
            m08Var.c();
        }
        RightFloatLayerView rightFloatLayerView = this.I1;
        if (rightFloatLayerView != null) {
            rightFloatLayerView.o();
        }
        SkinManager.setBackgroundColor(this.S0, R.color.CAM_X0207);
        SkinManager.setViewTextColor(this.S0.findViewById(R.id.obfuscated_res_0x7f092202), (int) R.color.CAM_X0105);
    }

    public void W2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048667, this, z2) == null) {
            this.g1 = z2;
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView != null) {
                this.h1 = pbLandscapeListView.getHeaderViewsCount();
            }
        }
    }

    public void W3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048668, this, str) == null) {
            this.c.showToast(str);
        }
    }

    public void X() {
        n08 n08Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048669, this) == null) || (n08Var = this.A0) == null) {
            return;
        }
        n08Var.l(false);
    }

    public final PostData X0(bs7 bs7Var) {
        InterceptResult invokeL;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048670, this, bs7Var)) == null) {
            if (bs7Var == null || bs7Var.O() == null || bs7Var.O().getAuthor() == null) {
                return null;
            }
            PostData postData = new PostData();
            MetaData author = bs7Var.O().getAuthor();
            String userId = author.getUserId();
            HashMap<String, MetaData> userMap = bs7Var.O().getUserMap();
            if (userMap != null && (metaData = userMap.get(userId)) != null && metaData.getUserId() != null) {
                author = metaData;
            }
            postData.p0(1);
            postData.u0(bs7Var.O().getFirstPostId());
            postData.G0(bs7Var.O().getTitle());
            postData.F0(bs7Var.O().getCreateTime());
            postData.n0(author);
            return postData;
        }
        return (PostData) invokeL.objValue;
    }

    public void X1(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048671, this, configuration) == null) || configuration == null) {
            return;
        }
        i0();
        if (configuration.orientation == 2) {
            i1();
            k1();
        } else {
            D2();
        }
        cv7 cv7Var = this.e1;
        if (cv7Var != null) {
            cv7Var.c();
        }
        this.c.a5();
        this.B.setVisibility(8);
        this.h.B(false);
        this.c.W5(false);
        if (this.r != null) {
            if (configuration.orientation == 1) {
                f1().setVisibility(0);
            }
            if (configuration.orientation == 2) {
                this.b2 = true;
                this.l.setIsLandscape(true);
                this.l.smoothScrollToPosition(0);
            } else {
                this.b2 = false;
                this.l.setIsLandscape(false);
                int i3 = this.Z1;
                if (i3 > 0) {
                    this.l.smoothScrollBy(i3, 0);
                }
            }
            this.r.j(configuration);
            this.P0.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        }
    }

    public void X2(PbFragment.e3 e3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048672, this, e3Var) == null) {
        }
    }

    public void X3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048673, this) == null) {
            this.c.showProgressBar();
        }
    }

    public boolean Y(boolean z2) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048674, this, z2)) == null) {
            EditorTools editorTools = this.k0;
            if (editorTools == null || !editorTools.u()) {
                return false;
            }
            this.k0.q();
            return true;
        }
        return invokeZ.booleanValue;
    }

    public String Y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048675, this)) == null) {
            if (!ni.isEmpty(this.y1)) {
                return this.y1;
            }
            if (this.c != null) {
                this.y1 = TbadkCoreApplication.getInst().getResources().getString(ew7.b());
            }
            return this.y1;
        }
        return (String) invokeV.objValue;
    }

    public void Y1() {
        NoNetworkView.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048676, this) == null) {
            gv7 gv7Var = this.p;
            if (gv7Var != null) {
                gv7Var.l();
            }
            RelativeLayout relativeLayout = this.d;
            if (relativeLayout != null && relativeLayout.getHandler() != null) {
                this.d.getHandler().removeCallbacksAndMessages(null);
            }
            n08 n08Var = this.A0;
            if (n08Var != null) {
                n08Var.j();
            }
            bw7 bw7Var = this.f1;
            if (bw7Var != null) {
                bw7Var.a();
            }
            tv7 tv7Var = this.u1;
            if (tv7Var != null) {
                tv7Var.c();
            }
            PbTopTipView pbTopTipView = this.m1;
            if (pbTopTipView != null) {
                pbTopTipView.g();
            }
            this.c.hideProgressBar();
            NoNetworkView noNetworkView = this.m;
            if (noNetworkView != null && (bVar = this.P) != null) {
                noNetworkView.d(bVar);
            }
            i0();
            o0();
            if (this.c1 != null) {
                pg.a().removeCallbacks(this.c1);
            }
            PbInterviewStatusView pbInterviewStatusView = this.O0;
            if (pbInterviewStatusView != null) {
                pbInterviewStatusView.m();
            }
            this.O1 = null;
            this.g.removeCallbacksAndMessages(null);
            this.C.a0(3);
            View view2 = this.e;
            if (view2 != null) {
                view2.setBackgroundDrawable(null);
            }
            yw7 yw7Var = this.r;
            if (yw7Var != null) {
                yw7Var.a();
            }
            qu7 qu7Var = this.C;
            if (qu7Var != null) {
                qu7Var.b0();
            }
            this.l.setOnLayoutListener(null);
            ex7 ex7Var = this.q1;
            if (ex7Var != null) {
                ex7Var.l();
            }
            PbEmotionBar pbEmotionBar = this.Z0;
            if (pbEmotionBar != null) {
                pbEmotionBar.x();
            }
            xw7 xw7Var = this.u;
            if (xw7Var != null) {
                xw7Var.u();
            }
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView != null) {
                pbLandscapeListView.getViewTreeObserver().removeGlobalOnLayoutListener(this.a);
            }
        }
    }

    public void Y2(TbRichTextView.y yVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048677, this, yVar) == null) {
            this.O = yVar;
            this.C.t0(yVar);
            this.r1.q(this.O);
        }
    }

    public void Y3() {
        FallingView fallingView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048678, this) == null) || (fallingView = this.H1) == null) {
            return;
        }
        fallingView.C();
    }

    public boolean Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048679, this)) == null) {
            PbListView pbListView = this.I;
            if (pbListView == null || TextUtils.isEmpty(pbListView.h())) {
                return false;
            }
            return this.I.h().equals(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f09e6));
        }
        return invokeV.booleanValue;
    }

    public final int Z0(PbReplyTitleViewHolder pbReplyTitleViewHolder) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048680, this, pbReplyTitleViewHolder)) == null) {
            if (pbReplyTitleViewHolder == null || pbReplyTitleViewHolder.b() == null) {
                return 0;
            }
            if (pbReplyTitleViewHolder.b().getTop() != 0 || pbReplyTitleViewHolder.b().isShown()) {
                return pbReplyTitleViewHolder.b().getBottom();
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public void Z1(TbRichText tbRichText) {
        bs7 bs7Var;
        PostData postData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048681, this, tbRichText) == null) || (bs7Var = this.I0) == null || bs7Var.F() == null || this.I0.F().isEmpty() || tbRichText == null || StringUtils.isNull(tbRichText.getAuthorId())) {
            return;
        }
        for (int i3 = 0; i3 < this.I0.F().size() && (postData = this.I0.F().get(i3)) != null && postData.s() != null && !StringUtils.isNull(postData.s().getUserId()); i3++) {
            if (this.I0.F().get(i3).s().getUserId().equals(tbRichText.getAuthorId())) {
                bu7 bu7Var = this.r1;
                if (bu7Var != null && bu7Var.l()) {
                    w3(false);
                }
                PbEmotionBar pbEmotionBar = this.Z0;
                if (pbEmotionBar != null) {
                    pbEmotionBar.q(true);
                }
                postData.s().getName_show();
                return;
            }
        }
    }

    public void Z2(NoNetworkView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048682, this, bVar) == null) {
            this.P = bVar;
            NoNetworkView noNetworkView = this.m;
            if (noNetworkView != null) {
                noNetworkView.a(bVar);
            }
        }
    }

    public void Z3() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048683, this) == null) || this.Y1 == null) {
            return;
        }
        while (this.Y1.size() > 0) {
            TbImageView remove = this.Y1.remove(0);
            if (remove != null) {
                remove.O();
            }
        }
    }

    public NoNetworkView a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048684, this)) == null) ? this.m : (NoNetworkView) invokeV.objValue;
    }

    public final void a0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048685, this) == null) || this.I0 == null || !UbsABTestHelper.isResizeInduceSharingABTest() || zx7.k(this.I0.Q())) {
            return;
        }
        this.A0.e();
        zx7.b(this.I0.Q());
    }

    public int a1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048686, this)) == null) ? R.id.obfuscated_res_0x7f091a7a : invokeV.intValue;
    }

    public boolean a2(int i3) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048687, this, i3)) == null) {
            yw7 yw7Var = this.r;
            if (yw7Var != null) {
                return yw7Var.k(i3);
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public void a3(BdListView.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048688, this, pVar) == null) {
            this.l.setOnSrollToBottomListener(pVar);
        }
    }

    public void a4(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048689, this, z2) == null) {
            this.e0 = z2;
        }
    }

    public void b0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048690, this) == null) {
            if (!this.c.checkUpIsLogin()) {
                TiebaStatic.log(new StatisticItem("c10517").param("obj_locate", 2).param("fid", this.h0));
            } else if (this.c.d4()) {
                m25 L4 = this.c.L4();
                if (L4 != null && (L4.B() || L4.D())) {
                    this.c.L4().z(false, null);
                    return;
                }
                if (this.k0 != null) {
                    v1();
                }
                EditorTools editorTools = this.k0;
                if (editorTools != null) {
                    this.E0 = false;
                    if (editorTools.n(2) != null) {
                        nk8.c(this.c.getPageContext(), (View) this.k0.n(2).k, false, k2);
                    }
                }
                i1();
            }
        }
    }

    public final int b1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048691, this)) == null) {
            View childAt = this.l.getChildAt(0);
            if (childAt == null) {
                return 0;
            }
            return (-childAt.getTop()) + (this.l.getFirstVisiblePosition() * childAt.getHeight());
        }
        return invokeV.intValue;
    }

    public void b2() {
        PostData postData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048692, this) == null) || this.c == null) {
            return;
        }
        if ((this.B1 || this.C1 == 17) && UbsABTestHelper.leftSlideToFrs()) {
            bs7 bs7Var = this.I0;
            if (bs7Var == null || bs7Var.l() == null || ni.isEmpty(this.I0.l().getName())) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.c.getContext()).createNormalCfg(this.I0.l().getName(), null)));
            TiebaStatic.log(new StatisticItem("c13853").param("post_id", this.I0.Q()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("fid", this.I0.l().getId()));
        } else if (!this.j1 || this.i1 || (postData = this.J0) == null || postData.s() == null) {
        } else {
            TiebaStatic.log(new StatisticItem("c12601").param("obj_locate", this.c.isSimpleForum() ? 2 : 1).param("obj_type", this.i1 ? 2 : 1));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.c.getPageContext().getPageActivity(), this.J0.s().getUserId(), this.J0.s().getUserName(), this.c.w().s0(), AddFriendActivityConfig.TYPE_PB_HEAD)));
        }
    }

    public void b3(AbsListView.OnScrollListener onScrollListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048693, this, onScrollListener) == null) {
            this.l.setOnScrollListener(onScrollListener);
        }
    }

    public void b4(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048694, this, z2) == null) {
            this.h.H(z2);
            if (z2 && this.M0) {
                this.I.C(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f03df));
                this.l.setNextPage(this.I);
                this.f = 2;
            }
            S1();
        }
    }

    public void c0(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048695, this, z2) == null) {
            if (z2) {
                SkinManager.setBackgroundColor(this.l, R.color.CAM_X0202);
            } else {
                this.l.setBackgroundResource(0);
            }
            View view2 = this.n0;
            if (view2 != null) {
                view2.setVisibility(z2 ? 8 : 0);
            }
            PbListView pbListView = this.I;
            if (pbListView != null) {
                pbListView.K(z2 ? 8 : 0);
            }
            View view3 = this.K;
            if (view3 != null) {
                view3.setVisibility(z2 ? 8 : 0);
            }
        }
    }

    public int c1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048696, this)) == null) ? this.L0 : invokeV.intValue;
    }

    public void c2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048697, this, z2) == null) {
            if (z2) {
                C3();
            } else {
                l1();
            }
            this.Y0.c = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.Y0));
            q2(this.Y0.c, false);
        }
    }

    public void c3(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048698, this, onClickListener) == null) {
            this.C.x0(onClickListener);
        }
    }

    public void c4(zr7 zr7Var) {
        String string;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048699, this, zr7Var) == null) || zr7Var == null) {
            return;
        }
        this.h.I();
        if (!StringUtils.isNull(zr7Var.b)) {
            this.h.F(zr7Var.b);
        }
        String string2 = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f139a);
        int e3 = mg.e(zr7Var.a, 0);
        if (e3 == 100) {
            string = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f10dd);
        } else if (e3 != 300) {
            string = e3 != 400 ? "" : TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f1317);
        } else {
            string = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f02e6);
        }
        this.c.showNetRefreshView(this.d, String.format(string2, string), null, TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0293), true, new d0(this, zr7Var.c));
    }

    public final void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048700, this) == null) {
            bu7 bu7Var = new bu7(this.c, this, (ViewStub) this.d.findViewById(R.id.obfuscated_res_0x7f09143f));
            this.r1 = bu7Var;
            bu7Var.o(this.N);
            this.r1.p(this.R);
            this.r1.q(this.O);
            this.r1.o(this.N);
            this.r1.s(this.i0);
        }
    }

    public View d1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048701, this)) == null) ? this.e : (View) invokeV.objValue;
    }

    public void d2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048702, this) == null) {
            Z3();
            this.C.a0(1);
            yw7 yw7Var = this.r;
            if (yw7Var != null) {
                yw7Var.l();
            }
            gv7 gv7Var = this.p;
            if (gv7Var != null) {
                gv7Var.k();
            }
            RightFloatLayerView rightFloatLayerView = this.I1;
            if (rightFloatLayerView != null && (rightFloatLayerView instanceof RightFloatLayerLottieView)) {
                ((RightFloatLayerLottieView) rightFloatLayerView).H(600);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
        }
    }

    public void d3(int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048703, this, i3) == null) {
            this.C1 = i3;
        }
    }

    public void d4(bs7 bs7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048704, this, bs7Var) == null) {
            if (bs7Var != null && AntiHelper.o(bs7Var.O())) {
                n08 n08Var = this.A0;
                if (n08Var != null) {
                    n08Var.k(false);
                    this.A0.j();
                }
                ViewGroup.LayoutParams layoutParams = this.z0.getLayoutParams();
                layoutParams.height = -2;
                layoutParams.width = -2;
                this.z0.setLayoutParams(layoutParams);
                WebPManager.setPureDrawable(this.z0, R.drawable.obfuscated_res_0x7f080930, R.color.CAM_X0110, WebPManager.ResourceStateType.NORMAL_PRESS);
                return;
            }
            n08 n08Var2 = this.A0;
            if (n08Var2 == null || !n08Var2.g()) {
                ViewGroup.LayoutParams layoutParams2 = this.z0.getLayoutParams();
                layoutParams2.height = -2;
                layoutParams2.width = -2;
                this.z0.setLayoutParams(layoutParams2);
                WebPManager.setPureDrawable(this.z0, R.drawable.obfuscated_res_0x7f080930, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            }
        }
    }

    public final CustomBlueCheckRadioButton e0(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048705, this, str, str2)) == null) {
            Activity pageActivity = this.c.getPageContext().getPageActivity();
            CustomBlueCheckRadioButton customBlueCheckRadioButton = new CustomBlueCheckRadioButton(pageActivity);
            RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, oi.f(pageActivity, R.dimen.obfuscated_res_0x7f07019a));
            customBlueCheckRadioButton.setOnCheckedChangeListener(this.X);
            customBlueCheckRadioButton.setTag(str);
            customBlueCheckRadioButton.setText(str2);
            customBlueCheckRadioButton.setLayoutParams(layoutParams);
            return customBlueCheckRadioButton;
        }
        return (CustomBlueCheckRadioButton) invokeLL.objValue;
    }

    public PbThreadPostView e1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048706, this)) == null) ? this.o : (PbThreadPostView) invokeV.objValue;
    }

    public void e2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048707, this) == null) {
            this.C.a0(2);
            yw7 yw7Var = this.r;
            if (yw7Var != null) {
                yw7Var.m();
                if (TbSingleton.getInstance().isNotchScreen(this.c.getFragmentActivity()) || TbSingleton.getInstance().isCutoutScreen(this.c.getFragmentActivity())) {
                    return;
                }
                g1().setSystemUiVisibility(4);
            }
        }
    }

    public void e3(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048708, this, onLongClickListener) == null) {
            this.u.x(onLongClickListener);
            this.C.u0(onLongClickListener);
            bu7 bu7Var = this.r1;
            if (bu7Var != null) {
                bu7Var.r(onLongClickListener);
            }
        }
    }

    public boolean e4(bs7 bs7Var, boolean z2) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048709, this, bs7Var, z2)) == null) {
            if (bs7Var == null) {
                return false;
            }
            if (this.t != null) {
                if (bs7Var.O() != null && bs7Var.O().getIsNoTitle() == 0 && !bs7Var.O().isVideoThreadType() && !this.K1) {
                    if (bs7Var.O() != null) {
                        ThreadData O = bs7Var.O();
                        O.parserSpecTitleForFrsAndPb(true, z3(bs7Var));
                        O.setResource(3);
                        O.setPbTitle("2");
                    }
                    if (bs7Var.O().isBJHArticleThreadType()) {
                        this.u.w(this.l);
                        this.t.d(this.l);
                        this.t.a(this.l);
                        this.u.j(this.l);
                        this.u.A(this.I0);
                        if (C1(bs7Var)) {
                            this.t.d(this.l);
                        } else {
                            this.t.e(bs7Var);
                        }
                    } else {
                        this.u.A(this.I0);
                        if (C1(bs7Var)) {
                            this.t.d(this.l);
                        } else {
                            this.t.g(bs7Var);
                        }
                    }
                } else if (bs7Var.O().getIsNoTitle() == 1) {
                    if (bs7Var.O() != null) {
                        this.t.d(this.l);
                        this.u.A(this.I0);
                    }
                } else {
                    this.t.d(this.l);
                    this.u.A(this.I0);
                }
            }
            U3(bs7Var);
            this.H0 = z2;
            return false;
        }
        return invokeLZ.booleanValue;
    }

    public void f0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048710, this) == null) || this.a2) {
            return;
        }
        TiebaStatic.log("c10490");
        this.a2 = true;
        cr4 cr4Var = new cr4(this.c.getPageContext().getPageActivity());
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(e2, Integer.valueOf(g2));
        cr4Var.setTitle(R.string.obfuscated_res_0x7f0f07cf);
        View inflate = LayoutInflater.from(this.c.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0859, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090c36)).setText(R.string.obfuscated_res_0x7f0f0778);
        ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f092045)).setText(R.string.obfuscated_res_0x7f0f07cf);
        cr4Var.setContentView(inflate);
        cr4Var.setYesButtonTag(sparseArray);
        cr4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f07ce, this.c);
        cr4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0a5c, new j0(this));
        cr4Var.create(this.c.getPageContext()).show();
    }

    public RelativeLayout f1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048711, this)) == null) ? this.B : (RelativeLayout) invokeV.objValue;
    }

    public void f2(AbsListView absListView, int i3, int i4, int i5) {
        PbReplyTitleViewHolder pbReplyTitleViewHolder;
        xw7 xw7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048712, this, absListView, i3, i4, i5) == null) {
            fv7 fv7Var = this.q;
            if (fv7Var != null) {
                fv7Var.c(i3, i4);
            }
            yw7 yw7Var = this.r;
            if (yw7Var != null) {
                yw7Var.n(absListView, i3, i4, i5);
            }
            dy7 dy7Var = this.h;
            if (dy7Var != null && (xw7Var = this.u) != null) {
                dy7Var.w(xw7Var.o());
            }
            s0 s0Var = this.Y0;
            s0Var.a = i3;
            s0Var.b = this.l.getHeaderViewsCount();
            this.Y0.c = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.Y0));
            v3(W(absListView, i3));
            int i6 = 0;
            q2(this.Y0.c, false);
            h0();
            if (!this.I.n() || this.I.C) {
                return;
            }
            s0 s0Var2 = this.Y0;
            if (s0Var2 != null && (pbReplyTitleViewHolder = s0Var2.c) != null && pbReplyTitleViewHolder.b() != null) {
                i6 = this.Y0.c.b().getTop() < 0 ? this.Y0.c.b().getHeight() : this.Y0.c.b().getBottom();
            }
            this.I.e(i6);
            this.I.C = true;
        }
    }

    public final void f3(PostData postData, bs7 bs7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048713, this, postData, bs7Var) == null) {
            this.u.y(postData, bs7Var);
        }
    }

    public final void f4() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048714, this) == null) && this.c.D4()) {
            if (this.c.I4() == -1) {
                SkinManager.setViewTextColor(this.z, R.color.CAM_X0110, 1);
            }
            if (this.c.H4() == -1) {
                SkinManager.setViewTextColor(this.A, R.color.CAM_X0110, 1);
            }
        }
    }

    public void g0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048715, this, str) == null) {
            if (str.contains("_")) {
                str = str.replace("_", "\n");
            }
            cr4 cr4Var = new cr4(this.c.getPageContext().getPageActivity());
            View inflate = LayoutInflater.from(this.c.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0859, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f092045);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(0, 0, 0, 0);
            textView.setLayoutParams(layoutParams);
            textView.setGravity(3);
            textView.setText(str);
            ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090c36)).setVisibility(8);
            cr4Var.setContentView(inflate);
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(e2, Integer.valueOf(h2));
            cr4Var.setYesButtonTag(sparseArray);
            cr4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f1503, this.c);
            cr4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f036e, new k0(this));
            cr4Var.create(this.c.getPageContext()).show();
        }
    }

    public View g1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048716, this)) == null) ? this.d : (View) invokeV.objValue;
    }

    public void g2(AbsListView absListView, int i3) {
        RightFloatLayerView rightFloatLayerView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048717, this, absListView, i3) == null) {
            yw7 yw7Var = this.r;
            if (yw7Var != null) {
                yw7Var.o(absListView, i3);
            }
            if (!this.b2 && i3 == 0) {
                this.Z1 = b1();
                this.Y0.c = null;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.Y0));
                q2(this.Y0.c, true);
                h0();
                this.C.f0(true);
            }
            this.C.e0();
            if (i3 == 0) {
                RightFloatLayerView rightFloatLayerView2 = this.I1;
                if (rightFloatLayerView2 != null) {
                    rightFloatLayerView2.q();
                }
            } else if (i3 == 1) {
                RightFloatLayerView rightFloatLayerView3 = this.I1;
                if (rightFloatLayerView3 != null) {
                    rightFloatLayerView3.p();
                }
            } else if (i3 != 2 || (rightFloatLayerView = this.I1) == null) {
            } else {
                rightFloatLayerView.r();
            }
        }
    }

    public void g3(boolean z2, PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048718, this, z2, postWriteCallBackData) == null) {
            this.c.hideProgressBar();
            if (z2) {
                i0();
            } else if (postWriteCallBackData != null && (postWriteCallBackData.isSensitiveError() || postWriteCallBackData.isErrorLinkCountExceedLimit() || postWriteCallBackData.isErrorShowApplyMemberDialog())) {
                j0();
            } else {
                i0();
            }
        }
    }

    public void g4(bs7 bs7Var) {
        tw7 tw7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048719, this, bs7Var) == null) || (tw7Var = this.s) == null) {
            return;
        }
        tw7Var.h(bs7Var, this.H0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x004d, code lost:
        if (r5.D1 == 1) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void h0() {
        m08 m08Var;
        boolean z2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048720, this) == null) || (m08Var = this.F1) == null) {
            return;
        }
        if (((m08Var.a() == null || this.F1.a().getParent() == null) ? -1 : this.l.getPositionForView(this.F1.a())) != -1) {
            if (this.F1.a().getTop() + j2 <= this.R0.getBottom()) {
                this.D1 = 1;
                z2 = true;
            } else {
                this.D1 = 0;
                z2 = false;
            }
        }
        this.U0.u(this.D1 == 1);
        this.F1.e(z2);
    }

    public void h1() {
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048721, this) == null) {
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView != null) {
                pbLandscapeListView.setVisibility(8);
            }
            if (this.l != null) {
                this.P0.setVisibility(8);
            }
            dy7 dy7Var = this.h;
            if (dy7Var == null || (view2 = dy7Var.d) == null) {
                return;
            }
            view2.setVisibility(8);
        }
    }

    public void h2(ArrayList<cp4> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048722, this, arrayList) == null) {
            if (this.V == null) {
                this.V = LayoutInflater.from(this.c.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d01f2, (ViewGroup) null);
            }
            this.c.getBaseFragmentActivity().getLayoutMode().j(this.V);
            if (this.U == null) {
                Dialog dialog = new Dialog(this.c.getPageContext().getPageActivity(), R.style.obfuscated_res_0x7f10039f);
                this.U = dialog;
                dialog.setCanceledOnTouchOutside(true);
                this.U.setCancelable(true);
                this.j0 = (ScrollView) this.V.findViewById(R.id.obfuscated_res_0x7f090ce0);
                this.U.setContentView(this.V);
                WindowManager.LayoutParams attributes = this.U.getWindow().getAttributes();
                attributes.width = oi.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0702de);
                this.U.getWindow().setAttributes(attributes);
                this.X = new w(this);
                this.W = (LinearLayout) this.V.findViewById(R.id.obfuscated_res_0x7f090cdf);
                TextView textView = (TextView) this.V.findViewById(R.id.obfuscated_res_0x7f0907a1);
                this.Z = textView;
                textView.setOnClickListener(new x(this));
                TextView textView2 = (TextView) this.V.findViewById(R.id.obfuscated_res_0x7f0907a2);
                this.Y = textView2;
                textView2.setOnClickListener(this.N);
            }
            this.W.removeAllViews();
            this.n = new ArrayList();
            CustomBlueCheckRadioButton e02 = e0("0", this.c.getPageContext().getString(R.string.obfuscated_res_0x7f0f139f));
            this.n.add(e02);
            e02.setChecked(true);
            this.W.addView(e02);
            if (arrayList != null) {
                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                    cp4 cp4Var = arrayList.get(i3);
                    if (cp4Var != null && !TextUtils.isEmpty(cp4Var.b()) && cp4Var.a() > 0) {
                        CustomBlueCheckRadioButton e03 = e0(String.valueOf(cp4Var.a()), cp4Var.b());
                        this.n.add(e03);
                        View view2 = new View(this.c.getPageContext().getPageActivity());
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, oi.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f070198));
                        SkinManager.setBackgroundColor(view2, R.color.CAM_X0204);
                        view2.setLayoutParams(layoutParams);
                        this.W.addView(view2);
                        this.W.addView(e03);
                    }
                }
                ViewGroup.LayoutParams layoutParams2 = this.j0.getLayoutParams();
                int size = arrayList.size();
                if (size == 0 || size == 1) {
                    layoutParams2.height = oi.d(this.c.getPageContext().getPageActivity(), 120.0f);
                } else if (size != 2) {
                    layoutParams2.height = oi.d(this.c.getPageContext().getPageActivity(), 220.0f);
                } else {
                    layoutParams2.height = oi.d(this.c.getPageContext().getPageActivity(), 186.0f);
                }
                this.j0.setLayoutParams(layoutParams2);
                this.j0.removeAllViews();
                LinearLayout linearLayout = this.W;
                if (linearLayout != null && linearLayout.getParent() == null) {
                    this.j0.addView(this.W);
                }
            }
            rg.j(this.U, this.c.getPageContext());
        }
    }

    public void h3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048723, this) == null) {
            this.c.hideProgressBar();
            bs7 bs7Var = this.I0;
            if (bs7Var != null && this.I != null && bs7Var.y() != null && this.I0.y().b() == 0) {
                this.I.u(this.I0.t());
                if (this.I0.t()) {
                    StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_PB_FOLD_ICON_SHOW);
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem.param("fid", this.I0.m());
                    statisticItem.param("fname", this.I0.n());
                    statisticItem.param("tid", this.I0.Q());
                    TiebaStatic.log(statisticItem);
                }
            }
            o0();
            this.l.A(0L);
            l0();
        }
    }

    public void i0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048724, this) == null) {
            this.h.k();
            xw7 xw7Var = this.u;
            if (xw7Var != null) {
                xw7Var.m();
            }
            PbFragment pbFragment = this.c;
            if (pbFragment != null) {
                oi.w(pbFragment.getContext(), this.G);
            }
            k1();
            lr4 lr4Var = this.b0;
            if (lr4Var != null) {
                lr4Var.dismiss();
            }
            m0();
            cr4 cr4Var = this.D;
            if (cr4Var != null) {
                cr4Var.dismiss();
            }
            er4 er4Var = this.E;
            if (er4Var != null) {
                er4Var.e();
            }
        }
    }

    public void i1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048725, this) == null) || this.r0 == null) {
            return;
        }
        this.q0.setVisibility(8);
        this.r0.setVisibility(8);
        this.E0 = false;
        PbEmotionBar pbEmotionBar = this.Z0;
        if (pbEmotionBar != null) {
            pbEmotionBar.setVisibility(8);
            C2(false);
        }
    }

    public void i2(int i3, String str, int i4, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048726, this, new Object[]{Integer.valueOf(i3), str, Integer.valueOf(i4), Boolean.valueOf(z2)}) == null) {
            j2(i3, str, i4, z2, null);
        }
    }

    public void i3() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048727, this) == null) || (pbFragment = this.c) == null || pbFragment.getBaseFragmentActivity() == null) {
            return;
        }
        oi.w(this.c.getPageContext().getPageActivity(), this.c.getBaseFragmentActivity().getCurrentFocus());
    }

    public void j0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048728, this) == null) {
            this.h.k();
            xw7 xw7Var = this.u;
            if (xw7Var != null) {
                xw7Var.m();
            }
            lr4 lr4Var = this.b0;
            if (lr4Var != null) {
                lr4Var.dismiss();
            }
            m0();
            cr4 cr4Var = this.D;
            if (cr4Var != null) {
                cr4Var.dismiss();
            }
            er4 er4Var = this.E;
            if (er4Var != null) {
                er4Var.e();
            }
        }
    }

    public void j1(boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048729, this, z2) == null) || this.r0 == null || this.u0 == null) {
            return;
        }
        TbSingleton tbSingleton = TbSingleton.getInstance();
        bs7 bs7Var = this.I0;
        boolean z3 = bs7Var != null && bs7Var.k0();
        bs7 bs7Var2 = this.I0;
        this.u0.setText(tbSingleton.getAdVertiComment(z3, bs7Var2 != null && bs7Var2.l0(), Y0()));
        if (z2) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(400L);
            this.r0.startAnimation(alphaAnimation);
        }
        this.q0.setVisibility(0);
        this.r0.setVisibility(0);
        this.E0 = true;
        if (this.Z0 == null || this.r1.l()) {
            return;
        }
        this.Z0.setVisibility(0);
        C2(true);
    }

    public void j2(int i3, String str, int i4, boolean z2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048730, this, new Object[]{Integer.valueOf(i3), str, Integer.valueOf(i4), Boolean.valueOf(z2), str2}) == null) {
            k2(i3, str, i4, z2, str2, false);
        }
    }

    public void j3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048731, this) == null) {
            this.I.z();
            this.I.Q();
        }
    }

    public void k0() {
        n08 n08Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048732, this) == null) || (n08Var = this.A0) == null) {
            return;
        }
        n08Var.k(false);
    }

    public void k1() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048733, this) == null) || (editorTools = this.k0) == null) {
            return;
        }
        editorTools.o();
        ex7 ex7Var = this.q1;
        if (ex7Var != null) {
            ex7Var.m();
        }
    }

    public void k2(int i3, String str, int i4, boolean z2, String str2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048734, this, new Object[]{Integer.valueOf(i3), str, Integer.valueOf(i4), Boolean.valueOf(z2), str2, Boolean.valueOf(z3)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(R.id.obfuscated_res_0x7f091e58, str);
            sparseArray.put(R.id.obfuscated_res_0x7f091e5a, Integer.valueOf(i3));
            sparseArray.put(R.id.obfuscated_res_0x7f091e75, Integer.valueOf(i4));
            sparseArray.put(R.id.obfuscated_res_0x7f091e59, Boolean.valueOf(z2));
            sparseArray.put(e2, Integer.valueOf(f2));
            int i5 = (i4 != 1002 || z2) ? R.string.obfuscated_res_0x7f0f048a : R.string.obfuscated_res_0x7f0f0fa5;
            int i6 = R.string.obfuscated_res_0x7f0f0429;
            if (i3 == 0) {
                if (i4 != 1002 || z2) {
                    i6 = R.string.obfuscated_res_0x7f0f048e;
                    i5 = R.string.obfuscated_res_0x7f0f048f;
                } else {
                    i5 = R.string.obfuscated_res_0x7f0f0fa9;
                }
            }
            this.S = new cr4(this.c.getActivity());
            if (StringUtils.isNull(str2)) {
                this.S.setMessageId(i5);
            } else {
                this.S.setOnlyMessageShowCenter(false);
                this.S.setMessage(str2);
            }
            this.S.setYesButtonTag(sparseArray);
            this.S.setPositiveButton(R.string.obfuscated_res_0x7f0f04dd, this.c);
            this.S.setNegativeButton(R.string.obfuscated_res_0x7f0f04d8, new o(this));
            this.S.setCancelable(true);
            this.S.create(this.c.getPageContext());
            if (z3) {
                y3(sparseArray, i6, i5);
            } else if (z2) {
                y3(sparseArray, i6, i5);
            } else if (o3()) {
                ai5 ai5Var = new ai5(this.c.w().T0().l().getDeletedReasonInfo().is_grays_cale_forum.intValue(), this.c.w().T0().l().getDeletedReasonInfo().is_boomgrow.intValue(), this.c.w().T0().o().has_forum_rule.intValue());
                ai5Var.i(this.c.w().T0().l().getId(), this.c.w().T0().l().getName());
                ai5Var.h(this.c.w().T0().l().getImage_url());
                ai5Var.j(this.c.w().T0().l().getUser_level());
                F3(sparseArray, i3, ai5Var, this.c.w().T0().U(), false);
            } else {
                N3(this.S, i3);
            }
        }
    }

    public void k3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048735, this, z2) == null) {
            this.u.z(z2);
        }
    }

    public final boolean l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048736, this)) == null) ? this.s.b(this.H0) : invokeV.booleanValue;
    }

    public void l1() {
        dy7 dy7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048737, this) == null) || (dy7Var = this.h) == null) {
            return;
        }
        dy7Var.q();
    }

    public void l2(int i3, String str, int i4, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048738, this, new Object[]{Integer.valueOf(i3), str, Integer.valueOf(i4), Boolean.valueOf(z2)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(R.id.obfuscated_res_0x7f091e58, str);
            sparseArray.put(R.id.obfuscated_res_0x7f091e5a, Integer.valueOf(i3));
            sparseArray.put(R.id.obfuscated_res_0x7f091e75, Integer.valueOf(i4));
            sparseArray.put(R.id.obfuscated_res_0x7f091e59, Boolean.valueOf(z2));
            sparseArray.put(e2, Integer.valueOf(f2));
            if (z2) {
                t3(sparseArray);
            } else {
                u3(i3, sparseArray);
            }
        }
    }

    public void l3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048739, this, str) == null) {
            this.u0.performClick();
            if (StringUtils.isNull(str) || this.c.L4() == null || this.c.L4().v() == null || this.c.L4().v().h() == null) {
                return;
            }
            EditText h3 = this.c.L4().v().h();
            h3.setText(str);
            h3.setSelection(str.length());
        }
    }

    public void m0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048740, this) == null) {
            cr4 cr4Var = this.S;
            if (cr4Var != null) {
                cr4Var.dismiss();
            }
            Dialog dialog = this.T;
            if (dialog != null) {
                rg.b(dialog, this.c.getPageContext());
            }
            Dialog dialog2 = this.U;
            if (dialog2 != null) {
                rg.b(dialog2, this.c.getPageContext());
            }
            lr4 lr4Var = this.Q;
            if (lr4Var != null) {
                lr4Var.dismiss();
            }
        }
    }

    public void m1() {
        xt4 xt4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048741, this) == null) || (xt4Var = this.G0) == null) {
            return;
        }
        xt4Var.h(false);
    }

    public void m2(SparseArray<Object> sparseArray, boolean z2) {
        jr4 jr4Var;
        jr4 jr4Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048742, this, sparseArray, z2) == null) {
            nr4 nr4Var = new nr4(this.c.getContext());
            nr4Var.q(this.c.getString(R.string.obfuscated_res_0x7f0f02d4));
            nr4Var.n(new n(this, z2));
            ArrayList arrayList = new ArrayList();
            int intValue = sparseArray.get(R.id.obfuscated_res_0x7f091e52) instanceof Integer ? ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091e52)).intValue() : -1;
            if (!"".equals(sparseArray.get(R.id.obfuscated_res_0x7f091e58)) && intValue != 2) {
                if ((sparseArray.get(R.id.obfuscated_res_0x7f091e5a) instanceof Integer ? ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091e5a)).intValue() : -1) == 0) {
                    jr4Var2 = new jr4(10, this.c.getString(R.string.obfuscated_res_0x7f0f04a0), nr4Var);
                } else {
                    jr4Var2 = new jr4(10, this.c.getString(R.string.obfuscated_res_0x7f0f0495), nr4Var);
                }
                SparseArray sparseArray2 = new SparseArray();
                sparseArray2.put(R.id.obfuscated_res_0x7f091e58, sparseArray.get(R.id.obfuscated_res_0x7f091e58));
                sparseArray2.put(R.id.obfuscated_res_0x7f091e5a, sparseArray.get(R.id.obfuscated_res_0x7f091e5a));
                sparseArray2.put(R.id.obfuscated_res_0x7f091e59, sparseArray.get(R.id.obfuscated_res_0x7f091e59));
                sparseArray2.put(R.id.obfuscated_res_0x7f091e75, sparseArray.get(R.id.obfuscated_res_0x7f091e75));
                jr4Var2.d.setTag(sparseArray2);
                arrayList.add(jr4Var2);
            }
            if ((!"".equals(sparseArray.get(R.id.obfuscated_res_0x7f091e63)) || !"".equals(sparseArray.get(R.id.obfuscated_res_0x7f091e64))) && !M1()) {
                SparseArray sparseArray3 = new SparseArray();
                sparseArray3.put(R.id.obfuscated_res_0x7f091e63, sparseArray.get(R.id.obfuscated_res_0x7f091e63));
                sparseArray3.put(R.id.obfuscated_res_0x7f091e64, sparseArray.get(R.id.obfuscated_res_0x7f091e64));
                sparseArray3.put(R.id.obfuscated_res_0x7f091e65, sparseArray.get(R.id.obfuscated_res_0x7f091e65));
                sparseArray3.put(R.id.obfuscated_res_0x7f091e75, sparseArray.get(R.id.obfuscated_res_0x7f091e75));
                sparseArray3.put(R.id.obfuscated_res_0x7f091e66, sparseArray.get(R.id.obfuscated_res_0x7f091e66));
                jr4 jr4Var3 = new jr4(11, this.c.getString(R.string.obfuscated_res_0x7f0f063d), nr4Var);
                jr4Var3.d.setTag(sparseArray3);
                arrayList.add(jr4Var3);
            }
            if ((sparseArray.get(R.id.obfuscated_res_0x7f091eab) instanceof Boolean) && ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091eab)).booleanValue()) {
                SparseArray sparseArray4 = new SparseArray();
                sparseArray4.put(R.id.obfuscated_res_0x7f091e6d, sparseArray.get(R.id.obfuscated_res_0x7f091e6d));
                sparseArray4.put(R.id.obfuscated_res_0x7f091ea7, sparseArray.get(R.id.obfuscated_res_0x7f091ea7));
                sparseArray4.put(R.id.obfuscated_res_0x7f091ea8, sparseArray.get(R.id.obfuscated_res_0x7f091ea8));
                sparseArray4.put(R.id.obfuscated_res_0x7f091ea6, sparseArray.get(R.id.obfuscated_res_0x7f091ea6));
                sparseArray4.put(R.id.obfuscated_res_0x7f091ea9, sparseArray.get(R.id.obfuscated_res_0x7f091ea9));
                sparseArray4.put(R.id.obfuscated_res_0x7f091eaa, sparseArray.get(R.id.obfuscated_res_0x7f091eaa));
                sparseArray4.put(R.id.obfuscated_res_0x7f091ea5, sparseArray.get(R.id.obfuscated_res_0x7f091ea5));
                if (z2) {
                    jr4Var = new jr4(12, this.c.getString(R.string.obfuscated_res_0x7f0f1467), nr4Var);
                } else {
                    jr4Var = new jr4(12, this.c.getString(R.string.obfuscated_res_0x7f0f0b14), nr4Var);
                }
                jr4Var.d.setTag(sparseArray4);
                arrayList.add(jr4Var);
            }
            yx7.e(arrayList);
            if (UbsABTestHelper.isPBPlanA()) {
                nr4Var.k(arrayList, false);
            } else {
                nr4Var.k(arrayList, true);
            }
            lr4 lr4Var = new lr4(this.c.getPageContext(), nr4Var);
            this.Q = lr4Var;
            lr4Var.m();
        }
    }

    public void m3(int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048743, this, i3) == null) {
            this.l.setSelection(i3);
        }
    }

    public void n0() {
        yw7 yw7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048744, this) == null) || (yw7Var = this.r) == null) {
            return;
        }
        yw7Var.b();
    }

    public void n1() {
        Runnable runnable;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048745, this) == null) {
            if (this.y == null) {
                u1();
            }
            this.k.setVisibility(8);
            Handler handler = this.O1;
            if (handler == null || (runnable = this.P1) == null) {
                return;
            }
            handler.removeCallbacks(runnable);
        }
    }

    public void n2(View view2) {
        SparseArray<Object> sparseArray;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048746, this, view2) == null) || (sparseArray = (SparseArray) view2.getTag()) == null) {
            return;
        }
        m2(sparseArray, false);
    }

    public void n3(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048747, this, list) == null) {
            this.p1 = list;
            ex7 ex7Var = this.q1;
            if (ex7Var != null) {
                ex7Var.q(list);
            }
        }
    }

    public void o0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048748, this) == null) {
            PbListView pbListView = this.I;
            if (pbListView != null) {
                pbListView.x();
                this.I.f();
            }
            m1();
        }
    }

    public void o1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048749, this) == null) {
            this.M.setVisibility(8);
        }
    }

    public void o2(@NonNull View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048750, this, view2) == null) || this.x0.getData() == null || !this.x0.getData().hasAgree || this.c.getActivity() == null) {
            return;
        }
        fr7 fr7Var = new fr7(this.c.getContext());
        int f3 = oi.f(TbadkCoreApplication.getInst(), R.dimen.tbds774);
        int f4 = oi.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f070724);
        int[] iArr = new int[2];
        view2.getLocationInWindow(iArr);
        int i3 = iArr[0];
        int i4 = iArr[1];
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(f4, f3);
        layoutParams.leftMargin = ((view2.getWidth() / 2) + i3) - ((int) ((f4 * 1) / 1.45d));
        layoutParams.topMargin = oi.f(TbadkCoreApplication.getInst(), R.dimen.M_H_X006);
        fr7Var.j(f3);
        fr7Var.i(layoutParams);
        fr7Var.h(false);
        fr7Var.l(true, this.c.getActivity().findViewById(16908290), 0, i4, this.I0.Q(), this.I0.m());
    }

    public final boolean o3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048751, this)) == null) {
            PbFragment pbFragment = this.c;
            return (pbFragment == null || pbFragment.w().T0().l().getDeletedReasonInfo() == null || 1 != this.c.w().T0().l().getDeletedReasonInfo().is_grays_cale_forum.intValue()) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public void p0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048752, this) == null) {
            this.l.A(0L);
            l0();
        }
    }

    public void p1() {
        RightFloatLayerView rightFloatLayerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048753, this) == null) || (rightFloatLayerView = this.I1) == null) {
            return;
        }
        rightFloatLayerView.c();
    }

    public void p2(hz4 hz4Var, int i3) {
        FallingView fallingView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048754, this, hz4Var, i3) == null) || (fallingView = this.H1) == null) {
            return;
        }
        fallingView.A(hz4Var, this.c.getPageContext(), i3, false);
    }

    public final void p3() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048755, this) == null) || (pbFragment = this.c) == null || pbFragment.getActivity() == null) {
            return;
        }
        if (this.x0.getWidth() != 0 && this.x0.getHeight() != 0) {
            WaterRippleView waterRippleView = this.v0;
            if (waterRippleView == null) {
                this.v0 = new WaterRippleView(this.c.getActivity());
            } else {
                ViewParent parent = waterRippleView.getParent();
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(this.v0);
                }
            }
            Rect rect = new Rect();
            this.d.getGlobalVisibleRect(rect);
            Rect rect2 = new Rect();
            this.x0.getImgAgree().getGlobalVisibleRect(rect2);
            int f3 = oi.f(this.c.getActivity(), R.dimen.tbds166);
            int i3 = ((rect2.right + rect2.left) / 2) - f3;
            int i4 = (rect.bottom - ((rect2.bottom + rect2.top) / 2)) - f3;
            int i5 = f3 * 2;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i5, i5);
            layoutParams.addRule(12, -1);
            layoutParams.setMargins(i3, 0, 0, i4);
            this.d.addView(this.v0, layoutParams);
            TextView textView = this.B0;
            if (textView != null) {
                textView.setVisibility(4);
                return;
            }
            return;
        }
        BdLog.e("AgreeView not measured");
    }

    public void q0(int i3, boolean z2, String str, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048756, this, new Object[]{Integer.valueOf(i3), Boolean.valueOf(z2), str, Boolean.valueOf(z3)}) == null) {
            this.c.hideProgressBar();
            if (z2 && z3) {
                PbFragment pbFragment = this.c;
                pbFragment.showToast(pbFragment.getPageContext().getString(R.string.obfuscated_res_0x7f0f11f8));
            } else if (z3) {
                if (ni.isEmpty(str)) {
                    str = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0c17);
                }
                this.c.showToast(str);
            }
        }
    }

    public void q1() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048757, this) == null) || (editorTools = this.k0) == null) {
            return;
        }
        editorTools.q();
    }

    public final void q2(PbReplyTitleViewHolder pbReplyTitleViewHolder, boolean z2) {
        int measuredHeight;
        int i3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048758, this, pbReplyTitleViewHolder, z2) == null) || this.i1 || this.R0 == null || this.h.p() == null) {
            return;
        }
        View r2 = u0().r();
        if (r2 != null) {
            int[] iArr = new int[2];
            r2.getLocationInWindow(iArr);
            int i4 = iArr[1];
            if (i4 != 0) {
                if (this.R0.getVisibility() == 0 && i4 - this.h.p().getBottom() <= this.R0.getHeight()) {
                    this.S0.setVisibility(0);
                    if (i4 > this.h.p().getBottom()) {
                        i3 = -(((this.R0.getHeight() + this.S0.getHeight()) + this.h.p().getBottom()) - r2.getBottom());
                    } else {
                        i3 = -this.R0.getHeight();
                    }
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.R0.getLayoutParams();
                    if (layoutParams.topMargin != i3) {
                        layoutParams.topMargin = i3;
                        this.R0.setLayoutParams(layoutParams);
                    }
                } else {
                    this.S0.setVisibility(4);
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.R0.getLayoutParams();
                    if (layoutParams2.topMargin != 0) {
                        layoutParams2.topMargin = 0;
                        this.R0.setLayoutParams(layoutParams2);
                    }
                }
            }
        }
        int H = this.C.H();
        if (H > 0 && (pbReplyTitleViewHolder == null || pbReplyTitleViewHolder.b().getParent() == null)) {
            if (H > this.l.getFirstVisiblePosition() - this.l.getHeaderViewsCount()) {
                this.R0.setVisibility(4);
                return;
            }
            this.R0.setVisibility(0);
            v3(false);
            this.h.a.hideBottomLine();
            if (this.R0.getParent() == null || ((ViewGroup) this.R0.getParent()).getHeight() > this.R0.getTop()) {
                return;
            }
            this.R0.getParent().requestLayout();
        } else if (pbReplyTitleViewHolder != null && pbReplyTitleViewHolder.b() != null && pbReplyTitleViewHolder.g != null) {
            int top = pbReplyTitleViewHolder.b().getTop();
            if (pbReplyTitleViewHolder.b().getParent() != null) {
                if (this.X0) {
                    this.W0 = top;
                    this.X0 = false;
                }
                int i5 = this.W0;
                if (top < i5) {
                    i5 = top;
                }
                this.W0 = i5;
            }
            if (top != 0 || pbReplyTitleViewHolder.b().isShown()) {
                if (this.B.getY() < 0.0f) {
                    measuredHeight = c2 - pbReplyTitleViewHolder.g.getMeasuredHeight();
                } else {
                    measuredHeight = this.h.p().getMeasuredHeight() - pbReplyTitleViewHolder.g.getMeasuredHeight();
                    this.h.a.hideBottomLine();
                }
                if (pbReplyTitleViewHolder.b().getParent() == null && top <= this.W0) {
                    this.R0.setVisibility(0);
                    v3(false);
                } else if (top < measuredHeight) {
                    this.R0.setVisibility(0);
                    v3(false);
                } else {
                    this.R0.setVisibility(4);
                    this.h.a.hideBottomLine();
                }
                if (z2) {
                    this.X0 = true;
                }
            }
        } else if (this.l.getFirstVisiblePosition() == 0) {
            this.R0.setVisibility(4);
            this.h.a.hideBottomLine();
        }
    }

    public void q3(View view2) {
        AbsPbActivity x2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048759, this, view2) == null) || (x2 = this.c.x()) == null || x2.isFinishing()) {
            return;
        }
        nz5 nz5Var = new nz5(this.c.getPageContext(), view2);
        nz5Var.g0(R.drawable.obfuscated_res_0x7f0802ed);
        nz5Var.O(48);
        nz5Var.U(true);
        nz5Var.L(2);
        nz5Var.h0(true);
        nz5Var.k0(oi.f(x2, R.dimen.tbds21));
        nz5Var.j0(oi.f(x2, R.dimen.tbds128));
        nz5Var.d0(x2.getResources().getDimensionPixelSize(R.dimen.tbds20));
        nz5Var.a0(x2.getResources().getDimensionPixelSize(R.dimen.tbds38));
        nz5Var.N(3000);
        nz5Var.n0(x2.getString(R.string.obfuscated_res_0x7f0f0dab), "pb_bottom_agree_tip_guide_key", true);
    }

    public void r0() {
        PbLandscapeListView pbLandscapeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048760, this) == null) || (pbLandscapeListView = this.l) == null) {
            return;
        }
        pbLandscapeListView.setForbidDragListener(true);
    }

    public final void r1() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048761, this) == null) && this.x == null && (pbFragment = this.c) != null) {
            this.x = new sw7(pbFragment.getContext());
        }
    }

    public final void r2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048762, this) == null) {
            this.u.v(this.I0, this.J0, this.j1, this.i1);
        }
    }

    public void r3() {
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048763, this) == null) {
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView != null) {
                pbLandscapeListView.setVisibility(0);
            }
            FrameLayout frameLayout = this.P0;
            if (frameLayout != null) {
                frameLayout.setVisibility(0);
            }
            dy7 dy7Var = this.h;
            if (dy7Var == null || (view2 = dy7Var.d) == null) {
                return;
            }
            view2.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
        }
    }

    public final String s0(long j3) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048764, this, j3)) == null) {
            if (j3 == 0) {
                return "";
            }
            NumberFormat numberFormat = NumberFormat.getInstance();
            numberFormat.setRoundingMode(RoundingMode.HALF_UP);
            if (j3 > 9990000) {
                return "· · ·";
            }
            if (j3 >= 1000000) {
                numberFormat.setMaximumFractionDigits(0);
                return numberFormat.format(((float) j3) / 10000.0f) + "W";
            } else if (j3 >= 10000) {
                numberFormat.setMaximumFractionDigits(1);
                return numberFormat.format(((float) j3) / 10000.0f) + "W";
            } else {
                return "" + j3;
            }
        }
        return (String) invokeJ.objValue;
    }

    public final void s1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048765, this) == null) && this.t == null) {
            this.t = new vw7(this.c, this.i0);
        }
    }

    public void s2() {
        PbLandscapeListView pbLandscapeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048766, this) == null) || (pbLandscapeListView = this.l) == null) {
            return;
        }
        int headerViewsCount = pbLandscapeListView.getHeaderViewsCount() - this.h1;
        int firstVisiblePosition = (this.l.getFirstVisiblePosition() == 0 || this.l.getFirstVisiblePosition() + headerViewsCount < 0) ? 0 : this.l.getFirstVisiblePosition() + headerViewsCount;
        View childAt = this.l.getChildAt(0);
        int top = childAt != null ? childAt.getTop() : -1;
        this.Y0.c = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.Y0));
        PbReplyTitleViewHolder pbReplyTitleViewHolder = this.Y0.c;
        int Z0 = Z0(pbReplyTitleViewHolder);
        int measuredHeight = this.B.getMeasuredHeight() + ((int) this.B.getY());
        boolean z2 = this.R0.getVisibility() == 0;
        boolean z3 = this.B.getY() < 0.0f;
        if ((z2 && pbReplyTitleViewHolder != null) || firstVisiblePosition >= this.C.H() + this.l.getHeaderViewsCount()) {
            int measuredHeight2 = pbReplyTitleViewHolder != null ? pbReplyTitleViewHolder.g.getMeasuredHeight() : 0;
            if (z3) {
                this.l.setSelectionFromTop(this.C.H() + this.l.getHeaderViewsCount(), c2 - measuredHeight2);
            } else {
                this.l.setSelectionFromTop(this.C.H() + this.l.getHeaderViewsCount(), this.h.p().getMeasuredHeight() - measuredHeight2);
            }
        } else {
            this.l.setSelectionFromTop(firstVisiblePosition, top);
        }
        if (this.i1 && this.r != null) {
            this.l.setSelectionFromTop(this.C.H() + this.l.getHeaderViewsCount(), this.r.d());
        } else if (this.K0 != 6) {
        } else {
            this.l.setOnLayoutListener(new a(this, Z0, pbReplyTitleViewHolder, z2, measuredHeight, firstVisiblePosition, top));
        }
    }

    public void s3() {
        yw7 yw7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048767, this) == null) || (yw7Var = this.r) == null) {
            return;
        }
        yw7Var.u(this.l);
    }

    public final String t0(int i3) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048768, this, i3)) == null) {
            if (i3 == 0) {
                return this.c.getString(R.string.obfuscated_res_0x7f0f0d97);
            }
            NumberFormat numberFormat = NumberFormat.getInstance();
            numberFormat.setRoundingMode(RoundingMode.HALF_UP);
            if (i3 > 9990000) {
                return "· · ·";
            }
            if (i3 >= 1000000) {
                numberFormat.setMaximumFractionDigits(0);
                return numberFormat.format(i3 / 10000.0f) + "W";
            } else if (i3 >= 10000) {
                numberFormat.setMaximumFractionDigits(1);
                return numberFormat.format(i3 / 10000.0f) + "W";
            } else {
                return "" + i3;
            }
        }
        return (String) invokeI.objValue;
    }

    public final void t1(bs7 bs7Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048769, this, bs7Var) == null) && bs7Var != null && bs7Var.O() != null && bs7Var.O().isInterviewLive() && this.O0 == null) {
            PbInterviewStatusView pbInterviewStatusView = (PbInterviewStatusView) this.N0.inflate();
            this.O0 = pbInterviewStatusView;
            pbInterviewStatusView.setOnClickListener(this.N);
            this.O0.setCallback(this.c.B4());
            this.O0.setData(this.c, bs7Var);
        }
    }

    public final void t2(AgreeData agreeData, long j3) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLJ(1048770, this, agreeData, j3) == null) || agreeData == null || !UbsABTestHelper.isLikeModifyTestA() || (textView = this.B0) == null) {
            return;
        }
        if (j3 > 0) {
            if (agreeData.agreeType == 2 && agreeData.hasAgree) {
                textView.setTextColor(SkinManager.getColor(R.color.CAM_X0301));
            } else {
                this.B0.setTextColor(SkinManager.getColor(R.color.CAM_X0107));
            }
            this.B0.setText(s0(j3));
            this.B0.setVisibility(0);
            return;
        }
        textView.setVisibility(8);
    }

    public final void t3(SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048771, this, sparseArray) == null) || this.c == null) {
            return;
        }
        if (sparseArray != null) {
            sparseArray.put(R.id.obfuscated_res_0x7f091e6c, Boolean.TRUE);
        }
        TBAlertConfig.a aVar = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f1159, TBAlertConfig.OperateBtnStyle.MAIN);
        TBAlertConfig.a aVar2 = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f036e, TBAlertConfig.OperateBtnStyle.SECONDARY);
        qr4 qr4Var = new qr4(this.c.x());
        qr4Var.v(R.string.obfuscated_res_0x7f0f0b10);
        qr4Var.l(R.string.obfuscated_res_0x7f0f0b11);
        qr4Var.n(true);
        qr4Var.r(aVar2, aVar);
        qr4Var.i(false);
        AlertDialog y2 = qr4Var.y();
        aVar.a(new r(this, y2, sparseArray));
        aVar2.a(new s(this, y2));
    }

    public qu7 u0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048772, this)) == null) ? this.C : (qu7) invokeV.objValue;
    }

    public final void u1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048773, this) == null) && this.c.D4()) {
            ViewStub viewStub = (ViewStub) this.d.findViewById(R.id.obfuscated_res_0x7f091385);
            this.k = viewStub;
            viewStub.setVisibility(0);
            if (this.y == null) {
                this.y = (LinearLayout) this.d.findViewById(R.id.obfuscated_res_0x7f091384);
                f95.a(this.c.getPageContext(), this.y);
            }
            if (this.z == null) {
                this.z = (TextView) this.y.findViewById(R.id.obfuscated_res_0x7f091389);
            }
            if (this.A == null) {
                this.A = (TextView) this.y.findViewById(R.id.obfuscated_res_0x7f091388);
            }
            this.z.setOnClickListener(this.N);
            this.A.setOnClickListener(this.N);
        }
    }

    public final void u2(bs7 bs7Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048774, this, bs7Var) == null) || bs7Var == null || bs7Var.O() == null) {
            return;
        }
        d4(bs7Var);
        if (bs7Var.r()) {
            WebPManager.setPureDrawable(this.y0, R.drawable.obfuscated_res_0x7f08092c, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
        } else {
            WebPManager.setPureDrawable(this.y0, R.drawable.obfuscated_res_0x7f08092b, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        }
        String t0 = t0(bs7Var.O().getReply_num());
        TextView textView = this.C0;
        if (textView != null) {
            textView.setText(t0);
        }
        TextView textView2 = this.D0;
        if (textView2 != null) {
            textView2.setText(t0);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921416, bs7Var.O()));
        t2(bs7Var.O().getAgreeData(), bs7Var.O().getAgreeNum());
        if (this.x0 == null || bs7Var.O() == null) {
            return;
        }
        this.x0.setThreadData(bs7Var.O());
        int i3 = 1;
        if (bs7Var.O().getAgreeData() != null) {
            bs7Var.O().getAgreeData().isInThread = true;
        }
        this.x0.setData(bs7Var.O().getAgreeData());
        vn4 vn4Var = new vn4();
        vn4Var.b = 26;
        if (bs7Var.O().isVideoThreadType() && bs7Var.O().getThreadVideoInfo() != null) {
            i3 = 2;
        }
        vn4Var.c = i3;
        PbFragment pbFragment = this.c;
        if (pbFragment != null && pbFragment.w() != null) {
            vn4Var.j = this.c.w().getFromForumId();
            vn4Var.f = this.c.w().S0();
        }
        this.x0.setStatisticData(vn4Var);
    }

    public final void u3(int i3, SparseArray<Object> sparseArray) {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048775, this, i3, sparseArray) == null) || (pbFragment = this.c) == null || pbFragment.w() == null || this.c.w().T0() == null || this.c.w().T0().o() == null || this.c.w().T0().l() == null || this.c.w().T0().l().getDeletedReasonInfo() == null) {
            return;
        }
        if (sparseArray != null) {
            sparseArray.put(R.id.obfuscated_res_0x7f091e6c, Boolean.TRUE);
        }
        ai5 ai5Var = new ai5(this.c.w().T0().l().getDeletedReasonInfo().is_grays_cale_forum.intValue(), this.c.w().T0().l().getDeletedReasonInfo().is_boomgrow.intValue(), this.c.w().T0().o().has_forum_rule.intValue());
        ai5Var.i(this.c.w().T0().l().getId(), this.c.w().T0().l().getName());
        ai5Var.h(this.c.w().T0().l().getImage_url());
        ai5Var.j(this.c.w().T0().l().getUser_level());
        F3(sparseArray, i3, ai5Var, this.c.w().T0().U(), true);
    }

    public LinearLayout v0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048776, this)) == null) ? this.s0 : (LinearLayout) invokeV.objValue;
    }

    public void v1() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048777, this) == null) || this.c == null || (editorTools = this.k0) == null) {
            return;
        }
        editorTools.j();
        if (this.c.L4() != null) {
            this.c.L4().P();
        }
        i1();
    }

    public void v2(int i3, bs7 bs7Var, boolean z2, int i4) {
        PostData C0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048778, this, new Object[]{Integer.valueOf(i3), bs7Var, Boolean.valueOf(z2), Integer.valueOf(i4)}) == null) || i3 <= 0 || (C0 = C0(bs7Var, z2)) == null || C0.s() == null) {
            return;
        }
        MetaData s2 = C0.s();
        s2.setGiftNum(s2.getGiftNum() + i3);
    }

    public void v3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048779, this, z2) == null) {
            this.m0.setVisibility(z2 ? 0 : 8);
        }
    }

    public View w0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048780, this)) == null) {
            View view2 = this.V;
            if (view2 != null) {
                return view2.findViewById(R.id.obfuscated_res_0x7f0907a2);
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    public final void w1(bs7 bs7Var, kw4 kw4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048781, this, bs7Var, kw4Var) == null) || this.J1 == null || bs7Var == null || kw4Var == null || this.c.getContext() == null) {
            return;
        }
        if (!RightFloatLayerView.k()) {
            p1();
            return;
        }
        if (this.I1 == null) {
            this.I1 = RightFloatLayerLottieView.F(kw4Var, this.c.getContext());
            this.J1.removeAllViews();
            this.J1.addView(this.I1);
        }
        if ((this.H1.getTag() instanceof Boolean) && !((Boolean) this.H1.getTag()).booleanValue()) {
            this.I1.setAutoCompleteShown(false);
            this.I1.setTag(this.H1);
            this.I1.c();
        }
        if (kw4Var.a()) {
            return;
        }
        this.I1.setData(kw4Var);
        this.I1.setLogoListener(new e0(this, kw4Var));
        this.I1.setFeedBackListener(new m0(this, kw4Var));
    }

    public void w2(bs7 bs7Var, boolean z2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048782, this, new Object[]{bs7Var, Boolean.valueOf(z2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            I3(bs7Var, z2, i3, i4);
            this.u.t(i4);
        }
    }

    public void w3(boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048783, this, z2) == null) || this.r0 == null) {
            return;
        }
        L2(this.c.L4().C());
        if (this.l0) {
            A3(z2);
        } else {
            j1(z2);
        }
    }

    public String x0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048784, this)) == null) ? this.a0 : (String) invokeV.objValue;
    }

    public void x1(bs7 bs7Var) {
        kw4 pbAdFloatViewItemData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048785, this, bs7Var) == null) || bs7Var == null) {
            return;
        }
        if (bs7Var.k0()) {
            pbAdFloatViewItemData = bs7Var.Z();
        } else {
            pbAdFloatViewItemData = TbSingleton.getInstance().getPbAdFloatViewItemData();
        }
        if (pbAdFloatViewItemData != null && !pbAdFloatViewItemData.a()) {
            w1(bs7Var, pbAdFloatViewItemData);
        } else {
            p1();
        }
    }

    public final void x2() {
        PbInterviewStatusView pbInterviewStatusView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048786, this) == null) && (pbInterviewStatusView = this.O0) != null && pbInterviewStatusView.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.O0.getLayoutParams();
            layoutParams.setMargins(0, 0, 0, 0);
            this.O0.setLayoutParams(layoutParams);
        }
    }

    public void x3(bs7 bs7Var) {
        PostData postData;
        dy7 dy7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048787, this, bs7Var) == null) || bs7Var == null || (postData = this.J0) == null || postData.s() == null || (dy7Var = this.h) == null) {
            return;
        }
        boolean z2 = !this.i1;
        this.j1 = z2;
        dy7Var.G(z2);
        if (this.c.M4() != null) {
            this.c.M4().s(this.j1);
        }
        r2();
        PbFragment pbFragment = this.c;
        if (pbFragment != null && !pbFragment.isSimpleForum() && !ListUtils.isEmpty(bs7Var.p())) {
            nq4 nq4Var = bs7Var.p().get(0);
            if (nq4Var != null) {
                this.h.K(bs7Var, nq4Var.a(), nq4Var.b(), nq4Var.d(), nq4Var.getIsLike());
            }
        } else if (bs7Var.l() != null) {
            this.h.K(bs7Var, bs7Var.l().getName(), bs7Var.l().getId(), bs7Var.l().getImage_url(), bs7Var.l().isLike() == 1);
        }
        if (this.j1) {
            this.u.F(bs7Var, this.J0, this.f0);
            View view2 = this.T0;
            if (view2 != null) {
                view2.setVisibility(8);
            }
            if (this.s1 == null) {
                this.s1 = new g0(this);
            }
            this.l.setListViewDragListener(this.s1);
            return;
        }
        View view3 = this.T0;
        if (view3 != null) {
            view3.setVisibility(0);
        }
        this.u.F(bs7Var, this.J0, this.f0);
        this.s1 = null;
        this.l.setListViewDragListener(null);
    }

    public int y0() {
        InterceptResult invokeV;
        View childAt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048788, this)) == null) {
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView == null) {
                return 0;
            }
            int firstVisiblePosition = pbLandscapeListView.getFirstVisiblePosition();
            int lastVisiblePosition = this.l.getLastVisiblePosition();
            if (lastVisiblePosition > firstVisiblePosition) {
                int i3 = (lastVisiblePosition - firstVisiblePosition) + 1;
                int[] iArr = new int[i3];
                Rect rect = new Rect();
                int childCount = this.l.getChildCount();
                int i4 = 0;
                for (int i5 = firstVisiblePosition; i5 <= lastVisiblePosition; i5++) {
                    int i6 = i5 - firstVisiblePosition;
                    if (i6 < childCount && (childAt = this.l.getChildAt(i6)) != null) {
                        childAt.getGlobalVisibleRect(rect);
                        iArr[i6] = rect.height();
                    }
                    i4 += iArr[i6];
                }
                int i7 = i4 / 2;
                int i8 = 0;
                int i9 = 0;
                while (true) {
                    if (i8 >= i3) {
                        break;
                    }
                    i9 += iArr[i8];
                    if (i9 > i7) {
                        firstVisiblePosition += i8;
                        break;
                    }
                    i8++;
                }
            }
            if (firstVisiblePosition < 0) {
                return 0;
            }
            return firstVisiblePosition;
        }
        return invokeV.intValue;
    }

    public final void y1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048789, this) == null) && this.v == null) {
            this.v = new uw7(this.c, this.N);
        }
    }

    public void y2() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048790, this) == null) || this.f == 2) {
            return;
        }
        this.l.setNextPage(this.I);
        this.f = 2;
    }

    public final void y3(SparseArray<Object> sparseArray, @StringRes int i3, @StringRes int i4) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(1048791, this, sparseArray, i3, i4) == null) || this.c == null) {
            return;
        }
        TBAlertConfig.a aVar = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f0495, TBAlertConfig.OperateBtnStyle.MAIN);
        TBAlertConfig.a aVar2 = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f036e, TBAlertConfig.OperateBtnStyle.SECONDARY);
        qr4 qr4Var = new qr4(this.c.x());
        qr4Var.v(i3);
        qr4Var.l(i4);
        qr4Var.n(true);
        qr4Var.r(aVar2, aVar);
        qr4Var.i(false);
        AlertDialog y2 = qr4Var.y();
        aVar.a(new p(this, y2, sparseArray));
        aVar2.a(new q(this, y2));
    }

    public PostData z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048792, this)) == null) {
            if (this.l == null) {
                return null;
            }
            int y0 = y0() - this.l.getHeaderViewsCount();
            int i3 = 0;
            if (y0 < 0) {
                y0 = 0;
            }
            if (this.C.y(y0) != null && this.C.y(y0) != PostData.w0) {
                i3 = y0 + 1;
            }
            if (this.C.x(i3) instanceof PostData) {
                return (PostData) this.C.x(i3);
            }
            return null;
        }
        return (PostData) invokeV.objValue;
    }

    public void z1(bs7 bs7Var) {
        PbReplyTitleViewHolder pbReplyTitleViewHolder;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048793, this, bs7Var) == null) {
            int i3 = 0;
            this.C.g0(bs7Var, false);
            this.C.Z();
            l0();
            bu7 bu7Var = this.r1;
            if (bu7Var != null) {
                bu7Var.n();
            }
            ArrayList<PostData> F = bs7Var.F();
            if (bs7Var.y().b() == 0 || F == null || F.size() < bs7Var.y().e()) {
                if (ListUtils.getCount(F) != 0 && (ListUtils.getCount(F) != 1 || F.get(0) == null || F.get(0).A() != 1)) {
                    if (bs7Var.y().b() == 0) {
                        this.I.C(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f09e6));
                    } else {
                        this.I.C(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0a2b));
                    }
                    this.I.k();
                } else {
                    s0 s0Var = this.Y0;
                    if (s0Var != null && (pbReplyTitleViewHolder = s0Var.c) != null && pbReplyTitleViewHolder.b() != null) {
                        i3 = this.Y0.c.b().getTop() < 0 ? this.Y0.c.b().getHeight() : this.Y0.c.b().getBottom();
                    }
                    if (this.c.k5()) {
                        this.I.F(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0db1), i3);
                    } else {
                        this.I.F(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0db2), i3);
                    }
                }
            }
            u2(bs7Var);
        }
    }

    public final void z2() {
        PbFragment pbFragment;
        WaterRippleView waterRippleView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048794, this) == null) || (pbFragment = this.c) == null || pbFragment.getActivity() == null || (waterRippleView = this.v0) == null) {
            return;
        }
        ViewParent parent = waterRippleView.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.v0);
        }
        TextView textView = this.B0;
        if (textView != null) {
            textView.setVisibility(0);
        }
    }

    public final boolean z3(bs7 bs7Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048795, this, bs7Var)) == null) {
            if (bs7Var == null || bs7Var.O() == null) {
                return false;
            }
            return bs7Var.O().getIsLive() == 1 || bs7Var.O().getThreadType() == 33 || !(bs7Var.O().getTopicData() == null || bs7Var.O().getTopicData().a() == 0) || bs7Var.O().getIs_top() == 1 || bs7Var.O().getIs_good() == 1 || bs7Var.O().isActInfo() || bs7Var.O().isInterviewLive() || bs7Var.O().isVoteThreadType() || bs7Var.O().getYulePostActivityData() != null || !ni.isEmpty(bs7Var.O().getCategory()) || bs7Var.O().isGodThread() || bs7Var.O().isRealGod();
        }
        return invokeL.booleanValue;
    }
}

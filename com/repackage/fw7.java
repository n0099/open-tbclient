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
import com.repackage.bt7;
import com.repackage.ev7;
import com.repackage.kj8;
import com.repackage.nr4;
import com.repackage.pr4;
import com.repackage.pu4;
import com.repackage.ri5;
import com.repackage.rw7;
import com.repackage.ui5;
import com.repackage.yr4;
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
public class fw7 {
    public static /* synthetic */ Interceptable $ic;
    public static final int d2;
    public static int e2;
    public static int f2;
    public static int g2;
    public static int h2;
    public static int i2;
    public static int j2;
    public static final int k2;
    public static kj8.f l2;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView A;
    public View A0;
    public PermissionJudgePolicy A1;
    public ObservedChangeRelativeLayout B;
    public k08 B0;
    public long B1;
    public pu7 C;
    public TextView C0;
    public boolean C1;
    public nr4 D;
    public TextView D0;
    public int D1;
    public pr4 E;
    public TextView E0;
    public int E1;
    public View F;
    public boolean F0;
    public boolean F1;
    public EditText G;
    public int G0;
    public j08 G1;
    public l08 H;
    public ku4 H0;
    public MaskView H1;
    public PbListView I;
    public boolean I0;
    public final FallingView I1;
    public h08 J;
    public bs7 J0;
    public RightFloatLayerView J1;
    public View K;
    public PostData K0;
    public final FrameLayout K1;
    public View L;
    public int L0;
    public boolean L1;
    public View M;
    public int M0;
    public String M1;
    public View.OnClickListener N;
    public boolean N0;
    public CustomMessageListener N1;
    public TbRichTextView.y O;
    public ViewStub O0;
    public CustomMessageListener O1;
    public NoNetworkView.b P;
    public PbInterviewStatusView P0;
    public Handler P1;
    public wr4 Q;
    public FrameLayout Q0;
    public Runnable Q1;
    public View.OnClickListener R;
    public TextView R0;
    public CustomMessageListener R1;
    public nr4 S;
    public View S0;
    public PbFragment.d3 S1;
    public Dialog T;
    public View T0;
    public boolean T1;
    public Dialog U;
    public View U0;
    public View.OnClickListener U1;
    public View V;
    public PbReplyTitleViewHolder V0;
    public boolean V1;
    public LinearLayout W;
    public View W0;
    public String W1;
    public CompoundButton.OnCheckedChangeListener X;
    public int X0;
    public pu4.g X1;
    public TextView Y;
    public boolean Y0;
    public View.OnClickListener Y1;
    public TextView Z;
    public t0 Z0;
    public final List<TbImageView> Z1;
    public final ViewTreeObserver.OnGlobalLayoutListener a;
    public String a0;
    public PbEmotionBar a1;
    public int a2;
    public int b;
    public wr4 b0;
    public int b1;
    public boolean b2;
    public PbFragment c;
    public wr4 c0;
    public int c1;
    public boolean c2;
    public RelativeLayout d;
    public rr4 d0;
    public Runnable d1;
    public View e;
    public boolean e0;
    public PbFakeFloorModel e1;
    public int f;
    public boolean f0;
    public bv7 f1;
    public final Handler g;
    public String g0;
    public aw7 g1;
    public final ay7 h;
    public String h0;
    public boolean h1;
    public zx7 i;
    public dt7 i0;
    public int i1;
    public ViewStub j;
    public ScrollView j0;
    public boolean j1;
    public ViewStub k;
    public EditorTools k0;
    public boolean k1;
    public PbLandscapeListView l;
    public boolean l0;
    public boolean l1;
    public NoNetworkView m;
    public View m0;
    public int m1;
    public List<CustomBlueCheckRadioButton> n;
    public View n0;
    public PbTopTipView n1;
    public PbThreadPostView o;
    public EjectionAnimationView o0;
    public PopupWindow o1;
    public fv7 p;
    public Button p0;
    public TextView p1;
    public ev7 q;
    public View q0;
    public List<String> q1;
    public xw7 r;
    public View r0;
    public cx7 r1;
    public sw7 s;
    public LinearLayout s0;
    public bu7 s1;
    public uw7 t;
    public HeadImageView t0;
    public PbLandscapeListView.c t1;
    public ww7 u;
    public TextView u0;
    public boolean u1;
    public tw7 v;
    public WaterRippleView v0;
    public sv7 v1;
    public vw7 w;
    public ImageView w0;
    public NavigationBarCoverTip w1;
    public rw7 x;
    public AgreeView x0;
    public ri5 x1;
    public LinearLayout y;
    public ImageView y0;
    public ui5 y1;
    public TextView z;
    public ImageView z0;
    public String z1;

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
        public final /* synthetic */ fw7 g;

        /* renamed from: com.repackage.fw7$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class RunnableC0417a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public RunnableC0417a(a aVar) {
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
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.g.W0 == null || this.a.g.W0.getLayoutParams() == null) {
                    return;
                }
                ViewGroup.LayoutParams layoutParams = this.a.g.W0.getLayoutParams();
                layoutParams.height = this.a.g.c1;
                this.a.g.W0.setLayoutParams(layoutParams);
            }
        }

        public a(fw7 fw7Var, int i, PbReplyTitleViewHolder pbReplyTitleViewHolder, boolean z, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fw7Var, Integer.valueOf(i), pbReplyTitleViewHolder, Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = fw7Var;
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
                    int b1 = this.g.b1(this.b);
                    int i3 = this.a;
                    int i4 = b1 - i3;
                    if (this.c && i4 != 0 && i3 <= (i = this.d)) {
                        i4 = b1 - i;
                    }
                    if (this.g.W0 == null || (layoutParams = this.g.W0.getLayoutParams()) == null) {
                        return;
                    }
                    if (i4 == 0 || i4 > this.g.d.getMeasuredHeight() || b1 >= this.g.d.getMeasuredHeight()) {
                        layoutParams.height = this.g.c1;
                    } else {
                        if (layoutParams != null) {
                            int i5 = layoutParams.height;
                            if (i5 + i4 > 0 && i5 + i4 <= this.g.d.getMeasuredHeight()) {
                                layoutParams.height += i4;
                                this.g.l.setSelectionFromTop(this.e, this.f);
                            }
                        }
                        layoutParams.height = this.g.c1;
                    }
                    this.g.W0.setLayoutParams(layoutParams);
                    ng.a().post(new RunnableC0417a(this));
                }
                this.g.l.setOnLayoutListener(null);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a0 implements yr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pr4.c a;
        public final /* synthetic */ fw7 b;

        public a0(fw7 fw7Var, pr4.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fw7Var, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = fw7Var;
            this.a = cVar;
        }

        @Override // com.repackage.yr4.e
        public void onItemClick(yr4 yr4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, yr4Var, i, view2) == null) {
                this.b.c0.dismiss();
                this.a.a(null, i, view2);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements AgreeView.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fw7 a;

        /* loaded from: classes6.dex */
        public class a implements t05 {
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

            @Override // com.repackage.t05
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

        public b(fw7 fw7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fw7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fw7Var;
        }

        @Override // com.baidu.tbadk.core.view.AgreeView.h
        public void onLongPress() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && UbsABTestHelper.isShowLikeAnimation()) {
                this.a.r3();
                v05.g().c(new a(this));
            }
        }

        @Override // com.baidu.tbadk.core.view.AgreeView.h
        public void onRelease() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.C2();
                this.a.o0.l();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fw7 a;

        public b0(fw7 fw7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fw7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fw7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (!(view2 instanceof HeadImageView) || this.a.J0 == null || this.a.J0.O() == null || this.a.J0.O().getAuthor() == null || this.a.J0.O().getAuthor().getAlaInfo() == null || this.a.J0.O().getAuthor().getAlaInfo().live_status != 1) {
                    if (this.a.j1) {
                        TiebaStatic.log(new StatisticItem("c11923").param("obj_id", 2));
                    }
                    if (!this.a.j1 && this.a.J0 != null && this.a.J0.O() != null && this.a.J0.O().getAuthor() != null && this.a.J0.O().getAuthor().isBigV()) {
                        TiebaStatic.log(new StatisticItem("c12151").param("obj_locate", 1));
                    }
                    if (this.a.c.w() != null) {
                        this.a.c.w().mEvent.b.onClick(view2);
                        return;
                    }
                    return;
                }
                StatisticItem statisticItem = new StatisticItem("c11851");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                TiebaStatic.log(statisticItem);
                StatisticItem statisticItem2 = new StatisticItem("c13715");
                statisticItem2.param("fid", this.a.J0.m());
                statisticItem2.param("fname", this.a.J0.n());
                statisticItem2.param("obj_param1", this.a.J0.O().getAuthor().getAlaInfo().user_info != null ? this.a.J0.O().getAuthor().getAlaInfo().user_info.user_id : 0L);
                statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem2.param("tid", this.a.J0.Q());
                statisticItem2.param(TiebaStatic.Params.OBJ_PARAM2, 1);
                statisticItem2.param(TiebaStatic.Params.OBJ_PARAM4, YYLiveUtil.calculateLiveType(this.a.J0.O().getAuthor().getAlaInfo()));
                if (this.a.J0.O().getAuthor().getAlaInfo().mYyExtData != null) {
                    statisticItem2.param(TiebaStatic.Params.OBJ_PARAM3, TiebaStatic.YYValues.YY_LIVE);
                    TiebaStaticHelper.addYYParam(statisticItem2, this.a.J0.O().getAuthor().getAlaInfo().mYyExtData);
                }
                TiebaStatic.log(statisticItem2);
                if (this.a.J0.O().getAuthor().getAlaInfo().isLegalYYLiveData()) {
                    YYLiveUtil.jumpYYLiveRoom(this.a.c.getPageContext(), this.a.J0.O().getAuthor().getAlaInfo(), YYLiveUtil.SOURCE_PB_LIVE_HEAD);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fw7 a;

        public c(fw7 fw7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fw7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fw7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.x0 == null || this.a.x0.getData() == null) {
                return;
            }
            fw7 fw7Var = this.a;
            fw7Var.w2(fw7Var.x0.getData(), this.a.x0.getData().agreeNum);
            if (!UbsABTestHelper.isShowLikeAnimation() || this.a.x0.D()) {
                return;
            }
            fw7 fw7Var2 = this.a;
            fw7Var2.r2(fw7Var2.x0);
        }
    }

    /* loaded from: classes6.dex */
    public class c0 implements rw7.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fw7 a;

        public c0(fw7 fw7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fw7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fw7Var;
        }

        @Override // com.repackage.rw7.a
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
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fw7 a;

        public d(fw7 fw7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fw7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fw7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.A0.getVisibility() == 0) {
                    iu4.k().u("pb_share_red_dot_shown", true);
                    this.a.A0.setVisibility(8);
                }
                this.a.N.onClick(view2);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fw7 a;

        public d0(fw7 fw7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fw7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fw7Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            fw7 fw7Var;
            ay7 ay7Var;
            LinearLayout linearLayout;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.C == null || (ay7Var = (fw7Var = this.a).h) == null || ay7Var.i == null || fw7Var.J0 == null || this.a.J0.O() == null || this.a.J0.O().isVideoThreadType() || this.a.M1() || this.a.J0.l() == null || li.isEmpty(this.a.J0.l().getName())) {
                return;
            }
            if ((this.a.C.J() == null || !this.a.C.J().isShown()) && (linearLayout = this.a.h.i) != null) {
                linearLayout.setVisibility(0);
                if (this.a.c == null || this.a.c.v() == null) {
                    return;
                }
                StatisticItem statisticItem = new StatisticItem("c13400");
                statisticItem.param("tid", this.a.c.v().h2());
                statisticItem.param("fid", this.a.c.v().getForumId());
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fw7 a;

        public e(fw7 fw7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fw7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fw7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            SparseArray<Object> sparseArray;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || (sparseArray = (SparseArray) view2.getTag()) == null) {
                return;
            }
            boolean booleanValue = sparseArray.get(R.id.obfuscated_res_0x7f091ef0) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091ef0)).booleanValue() : false;
            boolean booleanValue2 = sparseArray.get(R.id.obfuscated_res_0x7f091f03) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091f03)).booleanValue() : false;
            boolean booleanValue3 = sparseArray.get(R.id.obfuscated_res_0x7f091eee) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091eee)).booleanValue() : false;
            if (booleanValue) {
                if (booleanValue2) {
                    sparseArray.put(R.id.obfuscated_res_0x7f091ec1, 1);
                    this.a.c.d4(sparseArray);
                    return;
                }
                this.a.q2(view2);
            } else if (booleanValue2) {
                sparseArray.put(R.id.obfuscated_res_0x7f091ec1, 0);
                sparseArray.put(R.id.obfuscated_res_0x7f091eaa, 1);
                this.a.c.d4(sparseArray);
            } else if (booleanValue3) {
                this.a.l2(((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091eb2)).intValue(), (String) sparseArray.get(R.id.obfuscated_res_0x7f091eb0), ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091ecd)).intValue(), ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091eb1)).booleanValue());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ fw7 b;

        public e0(fw7 fw7Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fw7Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = fw7Var;
            this.a = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (mi.C()) {
                    UrlManager.getInstance().dealOneLink(this.b.c.getPageContext(), new String[]{this.a});
                    this.b.c.finish();
                    return;
                }
                this.b.c.showToast(R.string.obfuscated_res_0x7f0f0c2d);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fw7 a;

        public f(fw7 fw7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fw7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fw7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.G2();
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
        public final /* synthetic */ fw7 d;

        public f0(fw7 fw7Var, Parcelable parcelable, ArrayList arrayList, bs7 bs7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fw7Var, parcelable, arrayList, bs7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = fw7Var;
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
                this.d.I.C(this.d.c.getString(R.string.obfuscated_res_0x7f0f0dc4));
                this.d.I.x();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements PbFakeFloorModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fw7 a;

        public g(fw7 fw7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fw7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fw7Var;
        }

        @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.b
        public void a(PostData postData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, postData) == null) {
                this.a.e1.P(postData);
                this.a.C.Z();
                this.a.f1.c();
                this.a.k0.q();
                this.a.y3(false);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xw4 a;
        public final /* synthetic */ fw7 b;

        public g0(fw7 fw7Var, xw4 xw4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fw7Var, xw4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = fw7Var;
            this.a = xw4Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a == null || this.b.J0 == null || this.b.J1 == null) {
                return;
            }
            this.b.J1.g(this.a);
            this.b.J1.setAutoCompleteShown(false);
        }
    }

    /* loaded from: classes6.dex */
    public class h implements FallingView.n {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fw7 a;

        public h(fw7 fw7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fw7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fw7Var;
        }

        @Override // com.baidu.tieba.pb.view.FallingView.n
        public void onAnimationEnd() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.S3();
            }
        }

        @Override // com.baidu.tieba.pb.view.FallingView.n
        public void onAnimationStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.I1.setTag(Boolean.FALSE);
                if (this.a.J1 == null) {
                    return;
                }
                this.a.J1.setAutoCompleteShown(false);
                if (this.a.J1.getVisibility() == 0) {
                    this.a.J1.setTag(this.a.I1);
                    this.a.J1.c();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h0 implements PbLandscapeListView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fw7 a;

        public h0(fw7 fw7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fw7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fw7Var;
        }

        @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.c
        public void a(int i, int i2, float f, float f2, float f3, float f4) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)}) == null) && this.a.c != null && this.a.c.isAdded()) {
                if (i < 0 && f > this.a.m1) {
                    this.a.k0();
                    this.a.d2();
                }
                this.a.r0();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fw7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(fw7 fw7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fw7Var, Integer.valueOf(i)};
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
            this.a = fw7Var;
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
    public class i0 implements nr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fw7 a;

        public i0(fw7 fw7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fw7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fw7Var;
        }

        @Override // com.repackage.nr4.e
        public void onClick(nr4 nr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nr4Var) == null) {
                this.a.k0();
                nr4Var.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fw7 a;

        public j(fw7 fw7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fw7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fw7Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.y == null) {
                    this.a.w1();
                }
                this.a.k.setVisibility(0);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j0 implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fw7 a;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ j0 a;

            public a(j0 j0Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {j0Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = j0Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.a.c.HidenSoftKeyPad((InputMethodManager) this.a.a.c.getBaseFragmentActivity().getSystemService("input_method"), this.a.a.d);
                }
            }
        }

        public j0(fw7 fw7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fw7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fw7Var;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                if (this.a.d1 == null) {
                    this.a.d1 = new a(this);
                }
                ng.a().postDelayed(this.a.d1, 150L);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class k extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fw7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(fw7 fw7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fw7Var, Integer.valueOf(i)};
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
            this.a = fw7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            this.a.F0 = false;
        }
    }

    /* loaded from: classes6.dex */
    public class k0 implements nr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public k0(fw7 fw7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fw7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.nr4.e
        public void onClick(nr4 nr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nr4Var) == null) {
                nr4Var.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class l implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fw7 a;

        public l(fw7 fw7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fw7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fw7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.G2();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class l0 implements nr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public l0(fw7 fw7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fw7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.nr4.e
        public void onClick(nr4 nr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nr4Var) == null) {
                nr4Var.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class m implements x05 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fw7 a;

        public m(fw7 fw7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fw7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fw7Var;
        }

        @Override // com.repackage.x05
        public void onAction(w05 w05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, w05Var) == null) {
                Object obj = w05Var.c;
                if (obj instanceof mx4) {
                    if (((mx4) obj).getType() == EmotionGroupType.BIG_EMOTION || ((mx4) w05Var.c).getType() == EmotionGroupType.USER_COLLECT) {
                        if (this.a.A1 == null) {
                            this.a.A1 = new PermissionJudgePolicy();
                        }
                        this.a.A1.clearRequestPermissionList();
                        this.a.A1.appendRequestPermission(this.a.c.getBaseFragmentActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (this.a.A1.startRequestPermission(this.a.c.getBaseFragmentActivity())) {
                            return;
                        }
                        this.a.c.M4().h((mx4) w05Var.c);
                        this.a.c.M4().z(false, null);
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class m0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;
        public final /* synthetic */ View d;
        public final /* synthetic */ fw7 e;

        public m0(fw7 fw7Var, int i, int i2, int i3, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fw7Var, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = fw7Var;
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
                    this.e.o1.showAsDropDown(this.e.r0, this.d.getLeft(), -this.e.r0.getHeight());
                } else {
                    this.e.o1.showAsDropDown(this.d);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class n implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fw7 a;

        public n(fw7 fw7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fw7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fw7Var;
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
            if (this.a.r1 == null) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(11);
                layoutParams.addRule(2, this.a.k0.getId());
                fw7 fw7Var = this.a;
                fw7Var.r1 = new cx7(fw7Var.c.getPageContext(), this.a.d, layoutParams);
                if (!ListUtils.isEmpty(this.a.q1)) {
                    this.a.r1.q(this.a.q1);
                }
                this.a.r1.r(this.a.k0);
            }
            this.a.r1.p(substring);
        }
    }

    /* loaded from: classes6.dex */
    public class n0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xw4 a;
        public final /* synthetic */ fw7 b;

        public n0(fw7 fw7Var, xw4 xw4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fw7Var, xw4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = fw7Var;
            this.a = xw4Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921664));
                this.b.J1.setHomePbFloatLastCloseTime();
                this.b.r1();
                this.b.J1.u(this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class o implements yr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ fw7 b;

        public o(fw7 fw7Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fw7Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = fw7Var;
            this.a = z;
        }

        @Override // com.repackage.yr4.e
        public void onItemClick(yr4 yr4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, yr4Var, i, view2) == null) {
                this.b.Q.dismiss();
                SparseArray<Object> sparseArray = (SparseArray) view2.getTag();
                if (sparseArray == null) {
                    return;
                }
                switch (i) {
                    case 10:
                        this.b.l2(((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091eb2)).intValue(), (String) sparseArray.get(R.id.obfuscated_res_0x7f091eb0), ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091ecd)).intValue(), ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091eb1)).booleanValue());
                        return;
                    case 11:
                        if (this.b.S1 != null) {
                            this.b.S1.a(new Object[]{sparseArray.get(R.id.obfuscated_res_0x7f091ecd), sparseArray.get(R.id.obfuscated_res_0x7f091ebb), sparseArray.get(R.id.obfuscated_res_0x7f091ebe), sparseArray.get(R.id.obfuscated_res_0x7f091ebc), sparseArray.get(R.id.obfuscated_res_0x7f091ebd)});
                            return;
                        }
                        return;
                    case 12:
                        this.b.c.Y4(this.a, (String) sparseArray.get(R.id.obfuscated_res_0x7f091eff), sparseArray);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class o0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fw7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o0(fw7 fw7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fw7Var, Integer.valueOf(i)};
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
            this.a = fw7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2921306) {
                this.a.M1 = null;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class p implements nr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public p(fw7 fw7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fw7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.nr4.e
        public void onClick(nr4 nr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nr4Var) == null) {
                nr4Var.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class p0 implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;
        public final /* synthetic */ fw7 b;

        public p0(fw7 fw7Var, PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fw7Var, pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = fw7Var;
            this.a = pbFragment;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.b.F1 || this.a == null || this.b.c.v() == null || !this.b.c.v().y2()) {
                return;
            }
            this.b.F1 = true;
            this.a.a4(false);
        }
    }

    /* loaded from: classes6.dex */
    public class q implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlertDialog a;
        public final /* synthetic */ SparseArray b;
        public final /* synthetic */ fw7 c;

        public q(fw7 fw7Var, AlertDialog alertDialog, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fw7Var, alertDialog, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = fw7Var;
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
                if (!ki.A()) {
                    mi.M(this.c.c.w(), R.string.obfuscated_res_0x7f0f0c2d);
                } else {
                    this.c.c.l4(this.b, null);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class q0 implements bt7.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fw7 a;

        public q0(fw7 fw7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fw7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fw7Var;
        }

        @Override // com.repackage.bt7.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.c.b5();
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
    public class r implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlertDialog a;

        public r(fw7 fw7Var, AlertDialog alertDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fw7Var, alertDialog};
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
    public class r0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fw7 a;

        public r0(fw7 fw7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fw7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fw7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.c.getActivity(), LoginDialogData.PB_BOTTOM_REPLY_RESULT_PAGE))) {
                this.a.c.J5();
                if (this.a.c == null || this.a.c.v() == null || this.a.c.v().P1() == null || this.a.c.v().P1().O() == null || this.a.c.v().P1().O().getAuthor() == null) {
                    return;
                }
                TiebaStatic.log(new StatisticItem("c13701").param("tid", this.a.c.v().i2()).param("fid", this.a.c.v().P1().m()).param("uid", TbadkCoreApplication.getCurrentAccountId()));
                TiebaStatic.log(new StatisticItem("c13402").param("tid", this.a.c.v().b).param("fid", this.a.c.v().P1().m()).param("obj_locate", 1).param("uid", this.a.c.v().P1().O().getAuthor().getUserId()));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class s implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlertDialog a;
        public final /* synthetic */ SparseArray b;
        public final /* synthetic */ fw7 c;

        public s(fw7 fw7Var, AlertDialog alertDialog, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fw7Var, alertDialog, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = fw7Var;
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
                if (!ki.A()) {
                    mi.M(this.c.c.w(), R.string.obfuscated_res_0x7f0f0c2d);
                } else {
                    this.c.c.l4(this.b, null);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class s0 implements at7 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fw7 a;

        public s0(fw7 fw7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fw7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fw7Var;
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
    public class t implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlertDialog a;

        public t(fw7 fw7Var, AlertDialog alertDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fw7Var, alertDialog};
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
    public static class t0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public int b;
        public PbReplyTitleViewHolder c;

        public t0() {
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
    public class u implements ri5.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nr4 a;
        public final /* synthetic */ fw7 b;

        public u(fw7 fw7Var, nr4 nr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fw7Var, nr4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = fw7Var;
            this.a = nr4Var;
        }

        @Override // com.repackage.ri5.g
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                this.b.c.m4(this.a, jSONArray);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class v implements kj8.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public v() {
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

        @Override // com.repackage.kj8.f
        public void onRefresh() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public class w implements ui5.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SparseArray a;
        public final /* synthetic */ fw7 b;

        public w(fw7 fw7Var, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fw7Var, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = fw7Var;
            this.a = sparseArray;
        }

        @Override // com.repackage.ui5.h
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                this.b.c.l4(this.a, jSONArray);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class x implements CompoundButton.OnCheckedChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fw7 a;

        public x(fw7 fw7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fw7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fw7Var;
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
    public class y implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fw7 a;

        public y(fw7 fw7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fw7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fw7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (this.a.U instanceof Dialog)) {
                pg.b(this.a.U, this.a.c.getPageContext());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class z implements yr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pr4.c a;
        public final /* synthetic */ fw7 b;

        public z(fw7 fw7Var, pr4.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fw7Var, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = fw7Var;
            this.a = cVar;
        }

        @Override // com.repackage.yr4.e
        public void onItemClick(yr4 yr4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, yr4Var, i, view2) == null) {
                this.b.c0.dismiss();
                this.a.a(null, i, view2);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755693333, "Lcom/repackage/fw7;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755693333, "Lcom/repackage/fw7;");
                return;
            }
        }
        d2 = UtilHelper.getLightStatusBarHeight();
        e2 = 3;
        f2 = 0;
        g2 = 3;
        h2 = 4;
        i2 = 5;
        j2 = 6;
        k2 = mi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds80);
        l2 = new v();
    }

    public fw7(PbFragment pbFragment, View.OnClickListener onClickListener, dt7 dt7Var) {
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
        this.F0 = true;
        this.H0 = null;
        this.I0 = false;
        this.M0 = 3;
        this.N0 = false;
        this.O0 = null;
        this.X0 = 0;
        this.Y0 = true;
        this.Z0 = new t0();
        this.b1 = 0;
        this.h1 = false;
        this.i1 = 0;
        this.j1 = false;
        this.k1 = false;
        this.l1 = false;
        this.m1 = 0;
        this.u1 = false;
        this.B1 = 0L;
        this.E1 = 0;
        this.N1 = new o0(this, 2921306);
        this.O1 = new i(this, 2005016);
        this.P1 = new Handler();
        this.R1 = new k(this, 2004009);
        this.T1 = true;
        this.U1 = new b0(this);
        this.V1 = false;
        this.W1 = null;
        this.Z1 = new ArrayList();
        this.b2 = false;
        this.B1 = System.currentTimeMillis();
        this.c = pbFragment;
        this.N = onClickListener;
        this.i0 = dt7Var;
        this.m1 = mi.k(pbFragment.getContext()) / 8;
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.c.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d05ef, (ViewGroup) null);
        this.d = relativeLayout;
        relativeLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.m0 = this.d.findViewById(R.id.obfuscated_res_0x7f0903df);
        this.w1 = (NavigationBarCoverTip) this.d.findViewById(R.id.obfuscated_res_0x7f091726);
        this.e = this.d.findViewById(R.id.obfuscated_res_0x7f091dec);
        this.K1 = (FrameLayout) this.d.findViewById(R.id.obfuscated_res_0x7f091af1);
        this.B = (ObservedChangeRelativeLayout) this.d.findViewById(R.id.obfuscated_res_0x7f0920a4);
        this.m = (NoNetworkView) this.d.findViewById(R.id.obfuscated_res_0x7f0923ff);
        this.l = (PbLandscapeListView) this.d.findViewById(R.id.obfuscated_res_0x7f09156a);
        this.Q0 = (FrameLayout) this.d.findViewById(R.id.obfuscated_res_0x7f091b20);
        this.R0 = new TextView(this.c.getActivity());
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + mi.f(this.c.getActivity(), R.dimen.obfuscated_res_0x7f070309));
        this.l.x(this.R0, 0);
        this.l.setTextViewAdded(true);
        this.c1 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds134);
        this.W0 = new View(this.c.getPageContext().getPageActivity());
        if (jh5.d()) {
            this.W0.setLayoutParams(new AbsListView.LayoutParams(-1, 0));
        } else {
            this.W0.setLayoutParams(new AbsListView.LayoutParams(-1, this.c1));
        }
        this.W0.setVisibility(4);
        this.l.addFooterView(this.W0);
        this.l.setOnTouchListener(this.c.D2);
        this.a = new p0(this, pbFragment);
        this.l.getViewTreeObserver().addOnGlobalLayoutListener(this.a);
        this.h = new ay7(pbFragment, this.d);
        if (this.c.E4()) {
            ViewStub viewStub = (ViewStub) this.d.findViewById(R.id.obfuscated_res_0x7f09139d);
            this.j = viewStub;
            viewStub.setVisibility(0);
            zx7 zx7Var = new zx7(pbFragment);
            this.i = zx7Var;
            zx7Var.c();
            this.h.a.setVisibility(8);
            layoutParams.height = mi.f(this.c.getActivity(), R.dimen.obfuscated_res_0x7f07023f);
        }
        this.R0.setLayoutParams(layoutParams);
        this.h.p().setOnTouchListener(new bt7(new q0(this)));
        this.q0 = this.d.findViewById(R.id.obfuscated_res_0x7f0923e5);
        this.r0 = this.d.findViewById(R.id.obfuscated_res_0x7f0916c8);
        mi.f(TbadkCoreApplication.getInst(), R.dimen.tbds120);
        this.G0 = mi.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f070287);
        HeadImageView headImageView = (HeadImageView) this.d.findViewById(R.id.obfuscated_res_0x7f0916cc);
        this.t0 = headImageView;
        headImageView.setVisibility(0);
        this.t0.setIsRound(true);
        this.t0.setBorderWidth(mi.f(this.c.getContext(), R.dimen.L_X01));
        this.t0.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
        this.t0.setPlaceHolder(0);
        U1();
        this.u0 = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f0916cb);
        LinearLayout linearLayout = (LinearLayout) this.d.findViewById(R.id.obfuscated_res_0x7f0916c3);
        this.s0 = linearLayout;
        linearLayout.setOnClickListener(new r0(this));
        EjectionAnimationView ejectionAnimationView = (EjectionAnimationView) this.d.findViewById(R.id.obfuscated_res_0x7f090869);
        this.o0 = ejectionAnimationView;
        ejectionAnimationView.setEjectionAnimationViewCallback(new s0(this));
        this.w0 = (ImageView) this.d.findViewById(R.id.obfuscated_res_0x7f0916c9);
        this.H1 = (MaskView) this.d.findViewById(R.id.obfuscated_res_0x7f0913bf);
        this.w0.setOnClickListener(this.N);
        AgreeView agreeView = (AgreeView) this.d.findViewById(R.id.obfuscated_res_0x7f0916c5);
        this.x0 = agreeView;
        agreeView.setAgreeAlone(true);
        this.x0.r();
        this.x0.setAgreeLongClickListener(new b(this));
        this.x0.setAfterClickListener(new c(this));
        if (UbsABTestHelper.isShowLikeAnimation()) {
            this.x0.setUseDynamicLikeRes("/pb");
        }
        if (this.x0.getAgreeNumView() != null) {
            this.x0.getAgreeNumView().setVisibility(8);
        }
        if (this.x0.getMsgData() != null) {
            this.x0.getMsgData().a = BdUniqueId.gen();
        }
        boolean booleanExtra = this.c.getBaseFragmentActivity().getIntent().getBooleanExtra("key_is_from_dynamic", false);
        ImageView imageView = (ImageView) this.d.findViewById(R.id.obfuscated_res_0x7f0916c7);
        this.y0 = imageView;
        imageView.setOnClickListener(this.N);
        if (booleanExtra) {
            this.y0.setVisibility(8);
        } else {
            this.y0.setVisibility(0);
        }
        View findViewById = this.d.findViewById(R.id.obfuscated_res_0x7f0916ce);
        this.A0 = findViewById;
        findViewById.setVisibility((iu4.k().h("pb_share_red_dot_shown", false) || !TbadkCoreApplication.isLogin()) ? 8 : 0);
        ImageView imageView2 = (ImageView) this.d.findViewById(R.id.obfuscated_res_0x7f0916cd);
        this.z0 = imageView2;
        imageView2.setOnClickListener(new d(this));
        this.B0 = new k08(this.z0);
        if (!UbsABTestHelper.isResizeInduceSharingABTest() && !UbsABTestHelper.isResizeInduceSharingABTestA()) {
            this.B0.e();
        }
        TextView textView = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f0916ca);
        this.D0 = textView;
        textView.setVisibility(0);
        this.C0 = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f0916c6);
        this.O0 = (ViewStub) this.d.findViewById(R.id.obfuscated_res_0x7f090f4e);
        if (UbsABTestHelper.isLikeModifyTestA()) {
            this.x0.setVisibility(0);
            this.C0.setVisibility(0);
        }
        this.s = new sw7(this.c, dt7Var);
        this.u = new ww7(this.c, dt7Var, this.N);
        pu7 pu7Var = new pu7(this.c, this.l);
        this.C = pu7Var;
        pu7Var.v0(this.N);
        this.C.x0(this.i0);
        this.C.s0(this.O);
        this.C.u0(this.c.b2);
        this.C.p0(this.Y1);
        e eVar = new e(this);
        this.R = eVar;
        this.C.r0(eVar);
        A1();
        u1();
        vw7 vw7Var = new vw7(this.c);
        this.w = vw7Var;
        vw7Var.f = 2;
        t1();
        this.x.a(this.l);
        this.t.a(this.l);
        this.u.j(this.l);
        this.s.a(this.l);
        PbListView pbListView = new PbListView(this.c.getPageContext().getPageActivity());
        this.I = pbListView;
        this.K = pbListView.b().findViewById(R.id.obfuscated_res_0x7f091716);
        this.L = this.I.b().findViewById(R.id.obfuscated_res_0x7f0916b4);
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
        this.M = this.d.findViewById(R.id.obfuscated_res_0x7f09241b);
        this.c.registerListener(this.R1);
        this.e1 = new PbFakeFloorModel(this.c.getPageContext());
        PbModel v2 = this.c.v();
        this.e1.R(v2.H(), v2.D(), v2.E(), v2.C(), v2.I());
        bv7 bv7Var = new bv7(this.c.getPageContext(), this.e1, this.d);
        this.f1 = bv7Var;
        bv7Var.k(new f(this));
        this.f1.n(this.c.f2);
        this.e1.T(new g(this));
        if (this.c.v() != null && !StringUtils.isNull(this.c.v().S1())) {
            PbFragment pbFragment2 = this.c;
            pbFragment2.showToast(pbFragment2.v().S1());
        }
        this.S0 = this.d.findViewById(R.id.obfuscated_res_0x7f0916d0);
        this.T0 = this.d.findViewById(R.id.obfuscated_res_0x7f0903da);
        View findViewById2 = this.d.findViewById(R.id.obfuscated_res_0x7f091df7);
        this.U0 = findViewById2;
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) findViewById2.getLayoutParams();
        if (this.c.v() != null && this.c.v().B1()) {
            this.S0.setVisibility(0);
            if (layoutParams2 != null) {
                layoutParams2.height = 0;
                this.U0.setLayoutParams(layoutParams2);
            }
        } else if (layoutParams2 != null) {
            layoutParams2.height = d2;
            this.U0.setLayoutParams(layoutParams2);
        }
        PbReplyTitleViewHolder pbReplyTitleViewHolder = new PbReplyTitleViewHolder(this.c.getPageContext(), this.d.findViewById(R.id.obfuscated_res_0x7f091744));
        this.V0 = pbReplyTitleViewHolder;
        pbReplyTitleViewHolder.s(pbFragment.k0);
        this.V0.g.setVisibility(8);
        this.V0.r(this.N);
        this.V0.q(this.c.b2);
        this.c.registerListener(this.O1);
        this.c.registerListener(this.N1);
        PbFragment pbFragment3 = this.c;
        this.G1 = new j08(pbFragment3, pbFragment3.getUniqueId());
        this.I1 = (FallingView) this.d.findViewById(R.id.obfuscated_res_0x7f09096e);
        M2();
        this.I1.setAnimationListener(new h(this));
        f0();
        F2(false);
        this.n0 = this.d.findViewById(R.id.obfuscated_res_0x7f0916ba);
        e0(jh5.d());
        if (UbsABTestHelper.isPbForumGuideTestA() && v2.C2() && gr7.b().e()) {
            if (this.p == null) {
                this.p = new fv7(this.c.getActivity(), (ViewGroup) i1().findViewById(R.id.obfuscated_res_0x7f0916ef));
            }
            ev7 ev7Var = new ev7(this.l);
            this.q = ev7Var;
            ev7Var.d(new ev7.a() { // from class: com.repackage.hu7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.repackage.ev7.a
                public final void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        fw7.this.R1();
                    }
                }
            });
        }
    }

    public int A0() {
        InterceptResult invokeV;
        View childAt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
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

    public final void A1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.v == null) {
            this.v = new tw7(this.c, this.N);
        }
    }

    public final void A2() {
        PbInterviewStatusView pbInterviewStatusView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (pbInterviewStatusView = this.P0) != null && pbInterviewStatusView.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.P0.getLayoutParams();
            layoutParams.setMargins(0, 0, 0, 0);
            this.P0.setLayoutParams(layoutParams);
        }
    }

    public final void A3(SparseArray<Object> sparseArray, @StringRes int i3, @StringRes int i4) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(1048579, this, sparseArray, i3, i4) == null) || this.c == null) {
            return;
        }
        TBAlertConfig.a aVar = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f049d, TBAlertConfig.OperateBtnStyle.MAIN);
        TBAlertConfig.a aVar2 = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f0374, TBAlertConfig.OperateBtnStyle.SECONDARY);
        bs4 bs4Var = new bs4(this.c.w());
        bs4Var.v(i3);
        bs4Var.l(i4);
        bs4Var.n(true);
        bs4Var.r(aVar2, aVar);
        bs4Var.i(false);
        AlertDialog y2 = bs4Var.y();
        aVar.a(new q(this, y2, sparseArray));
        aVar2.a(new r(this, y2));
    }

    public PostData B0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.l == null) {
                return null;
            }
            int A0 = A0() - this.l.getHeaderViewsCount();
            int i3 = 0;
            if (A0 < 0) {
                A0 = 0;
            }
            if (this.C.y(A0) != null && this.C.y(A0) != PostData.w0) {
                i3 = A0 + 1;
            }
            if (this.C.x(i3) instanceof PostData) {
                return (PostData) this.C.x(i3);
            }
            return null;
        }
        return (PostData) invokeV.objValue;
    }

    public void B1(bs7 bs7Var) {
        PbReplyTitleViewHolder pbReplyTitleViewHolder;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bs7Var) == null) {
            int i3 = 0;
            this.C.g0(bs7Var, false);
            this.C.Z();
            n0();
            bu7 bu7Var = this.s1;
            if (bu7Var != null) {
                bu7Var.n();
            }
            ArrayList<PostData> F = bs7Var.F();
            if (bs7Var.y().b() == 0 || F == null || F.size() < bs7Var.y().e()) {
                if (ListUtils.getCount(F) != 0 && (ListUtils.getCount(F) != 1 || F.get(0) == null || F.get(0).A() != 1)) {
                    if (bs7Var.y().b() == 0) {
                        this.I.C(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f09ec));
                    } else {
                        this.I.C(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0a31));
                    }
                    this.I.k();
                } else {
                    t0 t0Var = this.Z0;
                    if (t0Var != null && (pbReplyTitleViewHolder = t0Var.c) != null && pbReplyTitleViewHolder.b() != null) {
                        i3 = this.Z0.c.b().getTop() < 0 ? this.Z0.c.b().getHeight() : this.Z0.c.b().getBottom();
                    }
                    if (this.c.l5()) {
                        this.I.F(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0dcb), i3);
                    } else {
                        this.I.F(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0dcc), i3);
                    }
                }
            }
            x2(bs7Var);
        }
    }

    public void B2() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.f == 2) {
            return;
        }
        this.l.setNextPage(this.I);
        this.f = 2;
    }

    public final boolean B3(bs7 bs7Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, bs7Var)) == null) {
            if (bs7Var == null || bs7Var.O() == null) {
                return false;
            }
            return bs7Var.O().getIsLive() == 1 || bs7Var.O().getThreadType() == 33 || !(bs7Var.O().getTopicData() == null || bs7Var.O().getTopicData().a() == 0) || bs7Var.O().getIs_top() == 1 || bs7Var.O().getIs_good() == 1 || bs7Var.O().isActInfo() || bs7Var.O().isInterviewLive() || bs7Var.O().isVoteThreadType() || bs7Var.O().getYulePostActivityData() != null || !li.isEmpty(bs7Var.O().getCategory()) || bs7Var.O().isGodThread() || bs7Var.O().isRealGod();
        }
        return invokeL.booleanValue;
    }

    public FallingView C0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.I1 : (FallingView) invokeV.objValue;
    }

    public boolean C1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.V1 : invokeV.booleanValue;
    }

    public final void C2() {
        PbFragment pbFragment;
        WaterRippleView waterRippleView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (pbFragment = this.c) == null || pbFragment.getActivity() == null || (waterRippleView = this.v0) == null) {
            return;
        }
        ViewParent parent = waterRippleView.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.v0);
        }
        TextView textView = this.C0;
        if (textView != null) {
            textView.setVisibility(0);
        }
    }

    public void C3(boolean z2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048587, this, z2) == null) || this.r0 == null || (textView = this.u0) == null) {
            return;
        }
        textView.setText(R.string.obfuscated_res_0x7f0f050d);
        if (z2) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(400L);
            this.r0.startAnimation(alphaAnimation);
        }
        this.q0.setVisibility(0);
        this.r0.setVisibility(0);
        this.F0 = true;
        if (this.a1 == null || this.s1.l()) {
            return;
        }
        this.a1.setVisibility(0);
        F2(true);
    }

    public int D0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? F0(this.l.getFirstVisiblePosition()) : invokeV.intValue;
    }

    public boolean D1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.F0 : invokeV.booleanValue;
    }

    public void D2() {
        PbLandscapeListView pbLandscapeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (pbLandscapeListView = this.l) == null) {
            return;
        }
        this.x.d(pbLandscapeListView);
        this.t.d(this.l);
        this.u.x(this.l);
        this.v.d(this.l);
        this.s.f(this.l);
    }

    public void D3(View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, view2) == null) || iu4.k().h("show_long_press_collection_tips", false)) {
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
        this.p1 = textView;
        textView.setText(R.string.obfuscated_res_0x7f0f0434);
        this.p1.setGravity(17);
        this.p1.setPadding(mi.f(this.c.getContext(), R.dimen.obfuscated_res_0x7f0701e8), 0, mi.f(this.c.getContext(), R.dimen.obfuscated_res_0x7f0701e8), 0);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        layoutParams.height = mi.f(this.c.getContext(), R.dimen.obfuscated_res_0x7f070253);
        if (this.p1.getParent() == null) {
            frameLayout.addView(this.p1, layoutParams);
        }
        PopupWindow popupWindow = new PopupWindow(this.c.getContext());
        this.o1 = popupWindow;
        popupWindow.setContentView(frameLayout);
        this.o1.setHeight(-2);
        this.o1.setWidth(-2);
        this.o1.setFocusable(true);
        this.o1.setOutsideTouchable(false);
        this.o1.setBackgroundDrawable(new ColorDrawable(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent)));
        this.l.postDelayed(new m0(this, i5, i3, i4, view2), 100L);
        iu4.k().u("show_long_press_collection_tips", true);
    }

    public PostData E0(bs7 bs7Var, boolean z2) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048592, this, bs7Var, z2)) == null) {
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
            if (!H1(postData)) {
                postData = Z0(bs7Var);
            }
            if (postData != null && postData.s() != null && postData.s().getUserTbVipInfoData() != null && postData.s().getUserTbVipInfoData().getvipIntro() != null) {
                postData.s().getGodUserData().setIntro(postData.s().getUserTbVipInfoData().getvipIntro());
            }
            return postData;
        }
        return (PostData) invokeLZ.objValue;
    }

    public final boolean E1(bs7 bs7Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, bs7Var)) == null) {
            if (bs7Var == null || bs7Var.O() == null) {
                return false;
            }
            SpannableStringBuilder span_str = bs7Var.O().getSpan_str();
            if (span_str != null) {
                return TbadkApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0db2).equals(span_str.toString());
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void E2() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || (pbFragment = this.c) == null || pbFragment.M4() == null || this.k0 == null) {
            return;
        }
        x25.a().c(0);
        b35 M4 = this.c.M4();
        M4.T();
        M4.R();
        if (M4.y() != null) {
            M4.y().setMaxImagesAllowed(M4.v ? 1 : 9);
        }
        M4.l0(SendView.g);
        M4.j(SendView.g);
        d15 m2 = this.k0.m(23);
        d15 m3 = this.k0.m(2);
        d15 m4 = this.k0.m(5);
        if (m3 != null) {
            m3.e();
        }
        if (m4 != null) {
            m4.e();
        }
        if (m2 != null) {
            m2.hide();
        }
        this.k0.invalidate();
    }

    public void E3() {
        ay7 ay7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || (ay7Var = this.h) == null || this.l1) {
            return;
        }
        ay7Var.C();
        this.l1 = true;
    }

    public final int F0(int i3) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048596, this, i3)) == null) {
            io adapter2 = this.l.getAdapter2();
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
            int n2 = (this.l.getAdapter2() == null || !(this.l.getAdapter2() instanceof io)) ? 0 : this.l.getAdapter2().n();
            if (i3 > n2) {
                return i3 - n2;
            }
            return 0;
        }
        return invokeI.intValue;
    }

    public boolean F1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView == null) {
                return false;
            }
            return pbLandscapeListView.J();
        }
        return invokeV.booleanValue;
    }

    public final void F2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z2) == null) {
        }
    }

    public void F3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            this.l.setVisibility(0);
        }
    }

    public Button G0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.p0 : (Button) invokeV.objValue;
    }

    public boolean G1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            EditorTools editorTools = this.k0;
            return editorTools != null && editorTools.getVisibility() == 0;
        }
        return invokeV.booleanValue;
    }

    public void G2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            E2();
            m1();
            this.f1.c();
            y3(false);
        }
    }

    public void G3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            if (this.H0 == null) {
                this.H0 = new ku4(this.c.getPageContext());
            }
            this.H0.h(true);
        }
    }

    public int H0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.l.getHeaderViewsCount() : invokeV.intValue;
    }

    public final boolean H1(PostData postData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, postData)) == null) {
            if (postData == null || postData.s() == null) {
                return false;
            }
            MetaData s2 = postData.s();
            return (TextUtils.isEmpty(s2.getUserId()) && TextUtils.isEmpty(s2.getAvater())) ? false : true;
        }
        return invokeL.booleanValue;
    }

    public final void H2() {
        xw7 xw7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048606, this) == null) || (xw7Var = this.r) == null) {
            return;
        }
        xw7Var.q(this.l, this.R0, this.L0);
    }

    public final void H3(SparseArray<Object> sparseArray, int i3, ti5 ti5Var, UserData userData, boolean z2) {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048607, this, new Object[]{sparseArray, Integer.valueOf(i3), ti5Var, userData, Boolean.valueOf(z2)}) == null) || (pbFragment = this.c) == null) {
            return;
        }
        if (this.y1 == null && this.s != null) {
            this.y1 = new ui5(pbFragment.getPageContext(), this.s.c(), ti5Var, userData);
        }
        this.y1.C(z2);
        AntiData u4 = this.c.u4();
        SparseArray<String> sparseArray2 = new SparseArray<>();
        if (u4 != null && u4.getDelThreadInfoList() != null) {
            List<DeleteThreadInfo> delThreadInfoList = u4.getDelThreadInfoList();
            for (int i4 = 0; i4 < delThreadInfoList.size(); i4++) {
                if (!TextUtils.isEmpty(delThreadInfoList.get(i4).text_info)) {
                    sparseArray2.put(delThreadInfoList.get(i4).text_id, delThreadInfoList.get(i4).text_info);
                }
            }
        }
        wp4 wp4Var = new wp4();
        wp4Var.j(sparseArray2);
        this.y1.E(new String[]{this.c.getString(R.string.obfuscated_res_0x7f0f04b1), this.c.getString(R.string.obfuscated_res_0x7f0f04b2), this.c.getString(R.string.obfuscated_res_0x7f0f04b3), this.c.getString(R.string.obfuscated_res_0x7f0f04b4), this.c.getString(R.string.obfuscated_res_0x7f0f04b5)});
        this.y1.D(wp4Var);
        this.y1.G((i3 == 1 || i3 == 2) ? "4" : "3");
        this.y1.F(new w(this, sparseArray));
    }

    public TextView I0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.u.n() : (TextView) invokeV.objValue;
    }

    public boolean I1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void I2() {
        Handler handler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048610, this) == null) || (handler = this.P1) == null) {
            return;
        }
        Runnable runnable = this.Q1;
        if (runnable != null) {
            handler.removeCallbacks(runnable);
        }
        j jVar = new j(this);
        this.Q1 = jVar;
        this.P1.postDelayed(jVar, 2000L);
    }

    public void I3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            this.C.g0(this.J0, false);
            this.C.Z();
        }
    }

    public int J0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            k08 k08Var = this.B0;
            if (k08Var != null) {
                return k08Var.f();
            }
            return 3;
        }
        return invokeV.intValue;
    }

    public final boolean J1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.W1) : invokeV.booleanValue;
    }

    public void J2(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, editorTools) == null) {
            this.k0 = editorTools;
            editorTools.setOnCancelClickListener(new l(this));
            this.k0.setId(R.id.obfuscated_res_0x7f0916c4);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            if (this.k0.getParent() == null) {
                this.d.addView(this.k0, layoutParams);
            }
            this.k0.w(TbadkCoreApplication.getInst().getSkinType());
            this.k0.setActionListener(24, new m(this));
            m1();
            this.c.M4().i(new n(this));
        }
    }

    public void J3(bs7 bs7Var, int i3, int i4, boolean z2, int i5, boolean z3) {
        PbLandscapeListView pbLandscapeListView;
        int i6;
        PbReplyTitleViewHolder pbReplyTitleViewHolder;
        bs7 bs7Var2;
        Parcelable e3;
        Parcelable e4;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048615, this, new Object[]{bs7Var, Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z2), Integer.valueOf(i5), Boolean.valueOf(z3)}) == null) || bs7Var == null || this.l == null) {
            return;
        }
        this.J0 = bs7Var;
        this.L0 = i3;
        if (bs7Var.O() != null) {
            this.b1 = bs7Var.O().getCopyThreadRemindType();
            if (bs7Var.O().getAnchorLevel() != 0) {
                this.V1 = true;
            }
            this.f0 = K1(bs7Var.O());
        }
        if (bs7Var.U() != null) {
            this.W1 = bs7Var.U().getUserId();
        }
        v1(bs7Var);
        c0();
        this.N0 = false;
        this.I0 = z2;
        j3();
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
        K3(bs7Var, z2, i3, TbadkCoreApplication.getInst().getSkinType());
        z3(bs7Var);
        this.u.H(bs7Var, this.K0);
        if (this.v1 == null) {
            this.v1 = new sv7(this.c.getPageContext(), this.w1);
        }
        this.v1.a(bs7Var.w());
        if (this.c.E4()) {
            if (this.H == null) {
                l08 l08Var = new l08(this.c.getPageContext());
                this.H = l08Var;
                l08Var.n();
                this.H.e(this.X1);
            }
            this.l.setPullRefresh(this.H);
            H2();
            l08 l08Var2 = this.H;
            if (l08Var2 != null) {
                l08Var2.H(TbadkCoreApplication.getInst().getSkinType());
            }
        } else if (bs7Var.y().c() == 0 && z2) {
            this.l.setPullRefresh(null);
        } else {
            if (this.H == null) {
                l08 l08Var3 = new l08(this.c.getPageContext());
                this.H = l08Var3;
                l08Var3.n();
                this.H.e(this.X1);
            }
            this.l.setPullRefresh(this.H);
            H2();
            l08 l08Var4 = this.H;
            if (l08Var4 != null) {
                l08Var4.H(TbadkCoreApplication.getInst().getSkinType());
            }
            o1();
        }
        n0();
        this.C.n0(this.I0);
        this.C.k0(false);
        this.C.l0(i3 == 5);
        this.C.m0(i3 == 6);
        this.C.i0(z3 && this.T1 && i3 != 2);
        this.C.g0(bs7Var, false);
        this.C.Z();
        this.u.F(E0(bs7Var, z2), bs7Var.g0());
        if (bs7Var.O() != null && bs7Var.O().getPraise() != null && this.b != -1) {
            bs7Var.O().getPraise().setIsLike(this.b);
        }
        this.l.removeFooterView(this.W0);
        this.l.addFooterView(this.W0);
        if (TbadkCoreApplication.isLogin()) {
            this.l.setNextPage(this.I);
            this.f = 2;
            o1();
        } else {
            this.N0 = true;
            if (bs7Var.y().b() == 1) {
                if (this.J == null) {
                    PbFragment pbFragment = this.c;
                    this.J = new h08(pbFragment, pbFragment);
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
                if (this.T1) {
                    q0();
                    if (bs7Var.y().b() != 0) {
                        this.I.C(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0dc3));
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
                    this.I.C(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f09ec));
                } else {
                    this.I.C(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0a31));
                }
                this.I.k();
            } else {
                t0 t0Var = this.Z0;
                if (t0Var == null || (pbReplyTitleViewHolder = t0Var.c) == null || pbReplyTitleViewHolder.b() == null) {
                    i6 = 0;
                } else {
                    i6 = this.Z0.c.b().getTop() < 0 ? this.Z0.c.b().getHeight() : this.Z0.c.b().getBottom();
                }
                if (this.c.l5()) {
                    this.I.u(false);
                    if (ListUtils.isEmpty(bs7Var.R())) {
                        this.I.F(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0dcb), i6);
                    }
                } else if (ListUtils.isEmpty(bs7Var.R())) {
                    this.I.F(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0dcc), i6);
                }
                if (this.c.N4() != null && !this.c.N4().p()) {
                    this.c.N4().x();
                }
            }
            if (bs7Var.y().b() == 0 || F == null) {
                B2();
            }
        }
        if (i3 == 2) {
            this.l.setSelection(i4 > 1 ? (i4 + ((this.l.getData() == null && bs7Var.F() == null) ? 0 : (this.l.getData().size() - bs7Var.F().size()) + this.l.getHeaderViewsCount())) - 2 : 0);
        } else if (i3 != 3) {
            if (i3 == 4) {
                this.T1 = false;
            } else if (i3 == 5) {
                this.l.setSelection(0);
            } else if (i3 != 6) {
                if (i3 == 8) {
                    if (i4 == 0) {
                        xw7 xw7Var = this.r;
                        if (xw7Var != null && xw7Var.c() != null) {
                            if (this.c.getBaseFragmentActivity().isUseStyleImmersiveSticky()) {
                                this.l.setSelectionFromTop((this.C.B() + this.l.getHeaderViewsCount()) - 1, this.r.d() - mi.r(this.c.getPageContext().getPageActivity()));
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
                    this.I.C(this.c.getString(R.string.obfuscated_res_0x7f0f0dc4));
                    this.I.x();
                }
            } else if (i5 == 1 && (e4 = xv7.b().e()) != null && !(e4 instanceof RecyclerView.SavedState)) {
                this.l.onRestoreInstanceState(e4);
            } else {
                this.l.setSelection(0);
            }
        } else if (i5 == 1 && (e3 = xv7.b().e()) != null && !(e3 instanceof RecyclerView.SavedState)) {
            this.l.post(new f0(this, e3, F, bs7Var));
        }
        if (this.b1 == e2 && J1()) {
            h0();
        }
        if (this.h1) {
            v2();
            this.h1 = false;
            if (i5 == 0) {
                Y2(true);
            }
        }
        if (bs7Var.d == 1 || bs7Var.e == 1) {
            if (this.n1 == null) {
                this.n1 = new PbTopTipView(this.c.getContext());
            }
            if (bs7Var.e == 1 && "game_guide".equals(this.c.S4())) {
                this.n1.setText(this.c.getString(R.string.obfuscated_res_0x7f0f0dd7));
                this.n1.l(this.d, this.M0);
            } else if (bs7Var.d == 1 && "game_news".equals(this.c.S4())) {
                this.n1.setText(this.c.getString(R.string.obfuscated_res_0x7f0f0dd6));
                this.n1.l(this.d, this.M0);
            }
        }
        this.l.removeFooterView(this.G1.a());
        if (!ListUtils.isEmpty(bs7Var.I()) && bs7Var.y().b() == 0) {
            this.l.removeFooterView(this.W0);
            this.G1.d(Math.max(this.r0.getMeasuredHeight(), this.G0 / 2));
            this.l.addFooterView(this.G1.a());
            this.G1.f(bs7Var);
        }
        x2(bs7Var);
        if (bs7Var.e0() && this.c.v().C2() && this.c.P4() != null) {
            this.c.P4().d();
        }
        if (bs7Var.g() != 3) {
            z1(bs7Var);
        }
        this.u0.setText(TbSingleton.getInstance().getAdVertiComment(bs7Var.k0(), bs7Var.l0(), a1()));
        if (this.p == null || (bs7Var2 = this.J0) == null || bs7Var2.l() == null) {
            return;
        }
        this.p.m(this.J0.l().getImage_url());
        this.p.n(this.J0.l().getName());
        PbFragment pbFragment2 = this.c;
        if (pbFragment2 == null || pbFragment2.v() == null) {
            return;
        }
        this.p.o(this.c.v().b);
    }

    public PbInterviewStatusView K0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.P0 : (PbInterviewStatusView) invokeV.objValue;
    }

    public final boolean K1(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048617, this, threadData)) == null) {
            if (threadData == null || threadData.getAuthor() == null) {
                return false;
            }
            PostData E0 = E0(this.J0, false);
            return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), (E0 == null || E0.s() == null) ? "" : E0.s().getUserId());
        }
        return invokeL.booleanValue;
    }

    public void K2(String str) {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048618, this, str) == null) || (pbListView = this.I) == null) {
            return;
        }
        pbListView.C(str);
    }

    @SuppressLint({"ResourceAsColor"})
    public final void K3(bs7 bs7Var, boolean z2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048619, this, new Object[]{bs7Var, Boolean.valueOf(z2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) || bs7Var == null || bs7Var.O() == null) {
            return;
        }
        if (this.c.isSimpleForum()) {
            if (bs7Var.h() != null) {
                this.g0 = bs7Var.h().a();
                this.h0 = bs7Var.h().b();
            }
            if (this.g0 == null && this.c.v() != null && this.c.v().o1() != null) {
                this.g0 = this.c.v().o1();
            }
        }
        PostData E0 = E0(bs7Var, z2);
        h3(E0, bs7Var);
        this.u.C(8);
        if (bs7Var.r0()) {
            this.j1 = true;
            this.h.A(true);
            this.h.a.hideBottomLine();
            if (this.r == null) {
                this.r = new xw7(this.c);
            }
            this.r.v(bs7Var, E0, this.l, this.u, this.Q0, this.h, this.g0, this.B1);
            this.r.s(this.U1);
            H2();
        } else {
            this.j1 = false;
            this.h.A(false);
            xw7 xw7Var = this.r;
            if (xw7Var != null) {
                xw7Var.p(this.l);
            }
        }
        if (this.c.N4() != null) {
            this.c.N4().w(this.j1);
        }
        if (E0 == null) {
            return;
        }
        this.K0 = E0;
        this.u.C(0);
        SparseArray<Object> r2 = this.u.r();
        r2.put(R.id.obfuscated_res_0x7f091eae, E0);
        r2.put(R.id.obfuscated_res_0x7f091ec7, Boolean.FALSE);
        this.v.e(bs7Var, this.l);
        this.x.e(bs7Var, this.D1, new c0(this));
        this.t.f(bs7Var);
        this.s.h(bs7Var, this.I0);
        this.s.g(bs7Var);
        this.u.D(this.M0, this.J0, E0, this.U1);
        if (this.V0 != null) {
            if (bs7Var.g0()) {
                this.V0.b().setVisibility(8);
            } else {
                this.V0.b().setVisibility(0);
                os7 os7Var = new os7(os7.h);
                if (bs7Var.O() != null) {
                    bs7Var.O().getReply_num();
                }
                os7Var.c = bs7Var.g;
                bs7Var.c();
                os7Var.d = this.c.l5();
                os7Var.g = bs7Var.f;
                this.V0.i(os7Var);
            }
        }
        W3(bs7Var);
        ng.a().post(new d0(this));
        this.w.e(this.l);
        if (E0.Q) {
            this.w.f(E0.I());
            this.w.b(this.l, this.l.getHeaderViewsCount() <= 1 ? 0 : 1);
        }
        pu7 pu7Var = this.C;
        if (pu7Var != null && pu7Var.z() != null) {
            this.C.z().m0(E0.Q);
        }
        pu7 pu7Var2 = this.C;
        if (pu7Var2 != null) {
            pu7Var2.q0(E0.Q);
        }
        this.H1.setVisibility(E0.Q ? 0 : 8);
    }

    public boolean L0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) ? this.u1 : invokeV.booleanValue;
    }

    public boolean L1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            View view2 = this.W0;
            if (view2 == null || view2.getParent() == null || this.I.m()) {
                return false;
            }
            int bottom = this.W0.getBottom();
            Rect rect = new Rect();
            this.W0.getWindowVisibleDisplayFrame(rect);
            return bottom > 0 && bottom <= rect.bottom;
        }
        return invokeV.booleanValue;
    }

    public void L2(String str) {
        PbReplyTitleViewHolder pbReplyTitleViewHolder;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048622, this, str) == null) || this.I == null) {
            return;
        }
        int i3 = 0;
        t0 t0Var = this.Z0;
        if (t0Var != null && (pbReplyTitleViewHolder = t0Var.c) != null && pbReplyTitleViewHolder.b() != null) {
            i3 = this.Z0.c.b().getTop() < 0 ? this.Z0.c.b().getHeight() : this.Z0.c.b().getBottom();
        }
        this.I.F(str, i3);
    }

    public void L3(pr4.c cVar, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048623, this, cVar, z2) == null) {
            wr4 wr4Var = this.c0;
            if (wr4Var != null) {
                wr4Var.dismiss();
                this.c0 = null;
            }
            yr4 yr4Var = new yr4(this.c.getContext());
            ArrayList arrayList = new ArrayList();
            bs7 bs7Var = this.J0;
            if (bs7Var != null && bs7Var.O() != null && !this.J0.O().isBjh()) {
                arrayList.add(new ur4(0, this.c.getPageContext().getString(R.string.obfuscated_res_0x7f0f1086), yr4Var));
            }
            if (!z2) {
                arrayList.add(new ur4(1, this.c.getPageContext().getString(R.string.obfuscated_res_0x7f0f1087), yr4Var));
            }
            yr4Var.j(arrayList);
            yr4Var.n(new a0(this, cVar));
            wr4 wr4Var2 = new wr4(this.c.getPageContext(), yr4Var);
            this.c0 = wr4Var2;
            wr4Var2.m();
        }
    }

    public int M0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            int lastVisiblePosition = this.l.getLastVisiblePosition();
            if (this.r != null) {
                if (lastVisiblePosition == this.l.getCount() - 1) {
                    lastVisiblePosition--;
                }
                if (lastVisiblePosition < 0) {
                    lastVisiblePosition = 0;
                }
            }
            return F0(lastVisiblePosition);
        }
        return invokeV.intValue;
    }

    public boolean M1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            bs7 bs7Var = this.J0;
            return bs7Var == null || bs7Var.l() == null || "0".equals(this.J0.l().getId()) || "me0407".equals(this.J0.l().getName());
        }
        return invokeV.booleanValue;
    }

    public final void M2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
            this.I1.setFallingFeedbackListener(new FallingView.l() { // from class: com.repackage.fu7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.pb.view.FallingView.l
                public final void onClick() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        fw7.this.T1();
                    }
                }
            });
        }
    }

    public void M3(pr4.c cVar, boolean z2, boolean z3, boolean z4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048627, this, new Object[]{cVar, Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4)}) == null) {
            wr4 wr4Var = this.b0;
            if (wr4Var != null) {
                wr4Var.dismiss();
                this.b0 = null;
            }
            yr4 yr4Var = new yr4(this.c.getContext());
            ArrayList arrayList = new ArrayList();
            if (!z4) {
                arrayList.add(new ur4(0, this.c.getPageContext().getString(R.string.obfuscated_res_0x7f0f0444), yr4Var));
            }
            if (z3) {
                arrayList.add(new ur4(1, this.c.getPageContext().getString(R.string.obfuscated_res_0x7f0f0fc0), yr4Var));
            } else if (!z2) {
                arrayList.add(new ur4(1, this.c.getPageContext().getString(R.string.obfuscated_res_0x7f0f0a87), yr4Var));
            } else {
                arrayList.add(new ur4(1, this.c.getPageContext().getString(R.string.obfuscated_res_0x7f0f0f9c), yr4Var));
            }
            yr4Var.j(arrayList);
            yr4Var.n(new z(this, cVar));
            wr4 wr4Var2 = new wr4(this.c.getPageContext(), yr4Var);
            this.c0 = wr4Var2;
            wr4Var2.m();
        }
    }

    public BdTypeListView N0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) ? this.l : (BdTypeListView) invokeV.objValue;
    }

    public boolean N1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) {
            xw7 xw7Var = this.r;
            return xw7Var != null && xw7Var.f();
        }
        return invokeV.booleanValue;
    }

    public void N2(PbFragment.d3 d3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048630, this, d3Var) == null) {
            this.S1 = d3Var;
        }
    }

    public void N3(AdapterView.OnItemClickListener onItemClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048631, this, onItemClickListener) == null) {
            rr4 rr4Var = this.d0;
            if (rr4Var != null) {
                rr4Var.d();
                this.d0 = null;
            }
            if (this.J0 == null) {
                return;
            }
            ArrayList<as4> arrayList = new ArrayList<>();
            arrayList.add(new as4(this.c.getContext().getString(R.string.obfuscated_res_0x7f0f0269), "", this.J0.L() == 1, Integer.toString(1)));
            arrayList.add(new as4(this.c.getContext().getString(R.string.obfuscated_res_0x7f0f0b36), "", this.J0.L() == 2, Integer.toString(5)));
            arrayList.add(new as4(this.c.getContext().getString(R.string.obfuscated_res_0x7f0f0b32), "", this.J0.L() == 3, Integer.toString(6)));
            arrayList.add(new as4(this.c.getContext().getString(R.string.obfuscated_res_0x7f0f0b50), "", this.J0.L() == 4, Integer.toString(7)));
            rr4 rr4Var2 = new rr4(this.c.getPageContext());
            rr4Var2.l(R.string.obfuscated_res_0x7f0f0dd3);
            this.d0 = rr4Var2;
            rr4Var2.k(arrayList, onItemClickListener);
            rr4Var2.c();
            this.d0.n();
        }
    }

    public SparseArray<Object> O0(bs7 bs7Var, boolean z2, int i3) {
        InterceptResult invokeCommon;
        PostData E0;
        ep4 ep4Var;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048632, this, new Object[]{bs7Var, Boolean.valueOf(z2), Integer.valueOf(i3)})) == null) {
            StringBuilder sb = null;
            if (bs7Var == null || (E0 = E0(bs7Var, z2)) == null) {
                return null;
            }
            String userId = E0.s().getUserId();
            boolean z3 = userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount());
            SparseArray<Object> sparseArray = new SparseArray<>();
            if (i3 == 0) {
                sparseArray.put(R.id.obfuscated_res_0x7f091eb0, E0.I());
                sparseArray.put(R.id.obfuscated_res_0x7f091eb2, 0);
                sparseArray.put(R.id.obfuscated_res_0x7f091eb1, Boolean.valueOf(z3));
                sparseArray.put(R.id.obfuscated_res_0x7f091ecd, Integer.valueOf(bs7Var.V()));
                sparseArray.put(R.id.obfuscated_res_0x7f091ef0, Boolean.FALSE);
            } else if (i3 == 1) {
                if (E0.s() != null) {
                    sparseArray.put(R.id.obfuscated_res_0x7f091ebb, E0.s().getUserName());
                    sparseArray.put(R.id.obfuscated_res_0x7f091ebc, E0.s().getName_show());
                    sparseArray.put(R.id.obfuscated_res_0x7f091ebd, E0.s().getPortrait());
                    sparseArray.put(R.id.obfuscated_res_0x7f091ebe, E0.I());
                }
                sparseArray.put(R.id.obfuscated_res_0x7f091eb0, E0.I());
                sparseArray.put(R.id.obfuscated_res_0x7f091eb2, 0);
                sparseArray.put(R.id.obfuscated_res_0x7f091eb1, Boolean.valueOf(z3));
                sparseArray.put(R.id.obfuscated_res_0x7f091ecd, Integer.valueOf(bs7Var.V()));
                sparseArray.put(R.id.obfuscated_res_0x7f091ef0, Boolean.TRUE);
            }
            if (!z3) {
                List<yq4> p2 = bs7Var.p();
                if (ListUtils.getCount(p2) > 0) {
                    sb = new StringBuilder();
                    for (yq4 yq4Var : p2) {
                        if (yq4Var != null && !StringUtils.isNull(yq4Var.a()) && (ep4Var = yq4Var.g) != null && ep4Var.a && !ep4Var.c && ((i4 = ep4Var.b) == 1 || i4 == 2)) {
                            sb.append(li.cutString(yq4Var.a(), 12));
                            sb.append(this.c.getString(R.string.obfuscated_res_0x7f0f064b));
                            sb.append("、");
                        }
                    }
                }
                if (sb != null && !StringUtils.isNull(sb.toString())) {
                    sparseArray.put(R.id.obfuscated_res_0x7f091eaf, String.format(this.c.getString(R.string.obfuscated_res_0x7f0f0495), sb.toString().substring(0, sb.length() - 1)));
                }
            }
            return sparseArray;
        }
        return (SparseArray) invokeCommon.objValue;
    }

    public boolean O1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) ? this.L1 : invokeV.booleanValue;
    }

    public void O2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048634, this, z2) == null) {
            this.l0 = z2;
        }
    }

    public void O3() {
        PostData postData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048635, this) == null) || !TbadkCoreApplication.isLogin() || this.J0 == null || !this.k1 || this.j1 || this.f0 || (postData = this.K0) == null || postData.s() == null || this.K0.s().getIsLike() || this.K0.s().hadConcerned() || this.g1 != null) {
            return;
        }
        this.g1 = new aw7(this.c);
    }

    public bu7 P0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) ? this.s1 : (bu7) invokeV.objValue;
    }

    public boolean P1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) {
            k08 k08Var = this.B0;
            if (k08Var == null) {
                return false;
            }
            return k08Var.h();
        }
        return invokeV.booleanValue;
    }

    public void P2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048638, this, z2) == null) {
            this.C.h0(z2);
        }
    }

    public final void P3(nr4 nr4Var, int i3) {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048639, this, nr4Var, i3) == null) || (pbFragment = this.c) == null || nr4Var == null) {
            return;
        }
        if (this.x1 == null && this.s != null) {
            this.x1 = new ri5(pbFragment.getPageContext(), this.s.c());
        }
        AntiData u4 = this.c.u4();
        SparseArray<String> sparseArray = new SparseArray<>();
        if (u4 != null && u4.getDelThreadInfoList() != null) {
            List<DeleteThreadInfo> delThreadInfoList = u4.getDelThreadInfoList();
            for (int i4 = 0; i4 < delThreadInfoList.size(); i4++) {
                if (!TextUtils.isEmpty(delThreadInfoList.get(i4).text_info)) {
                    sparseArray.put(delThreadInfoList.get(i4).text_id, delThreadInfoList.get(i4).text_info);
                }
            }
        }
        wp4 wp4Var = new wp4();
        wp4Var.j(sparseArray);
        this.x1.y(new String[]{this.c.getString(R.string.obfuscated_res_0x7f0f04b1), this.c.getString(R.string.obfuscated_res_0x7f0f04b2), this.c.getString(R.string.obfuscated_res_0x7f0f04b3), this.c.getString(R.string.obfuscated_res_0x7f0f04b4), this.c.getString(R.string.obfuscated_res_0x7f0f04b5)});
        this.x1.x(wp4Var);
        this.x1.A((i3 == 1 || i3 == 2) ? "4" : "3");
        this.x1.z(new u(this, nr4Var));
    }

    public View Q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) ? this.L : (View) invokeV.objValue;
    }

    public boolean Q1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) {
            EditorTools editorTools = this.k0;
            return editorTools != null && editorTools.u();
        }
        return invokeV.booleanValue;
    }

    public void Q2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048642, this, z2) == null) {
            this.C1 = z2;
        }
    }

    public void Q3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048643, this) == null) {
            this.M.setVisibility(0);
        }
    }

    public final int R0(boolean z2) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048644, this, z2)) == null) {
            PbInterviewStatusView pbInterviewStatusView = this.P0;
            if (pbInterviewStatusView != null && pbInterviewStatusView.getVisibility() == 0 && z2) {
                return 0 + mi.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f07026a);
            }
            return 0;
        }
        return invokeZ.intValue;
    }

    public /* synthetic */ void R1() {
        this.l.post(new Runnable() { // from class: com.repackage.gu7
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // java.lang.Runnable
            public final void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    fw7.this.S1();
                }
            }
        });
    }

    public void R2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048646, this, z2) == null) {
            this.u1 = z2;
        }
    }

    public void R3() {
        pu7 pu7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048647, this) == null) || (pu7Var = this.C) == null) {
            return;
        }
        pu7Var.y0();
    }

    public View S0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048648, this)) == null) ? this.K : (View) invokeV.objValue;
    }

    public /* synthetic */ void S1() {
        fv7 fv7Var = this.p;
        if (fv7Var != null) {
            fv7Var.p();
        }
    }

    public void S2(boolean z2) {
        xw7 xw7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048650, this, z2) == null) || (xw7Var = this.r) == null) {
            return;
        }
        xw7Var.r(z2);
    }

    public final void S3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048651, this) == null) {
            FallingView fallingView = this.I1;
            if (fallingView != null) {
                fallingView.setTag(Boolean.TRUE);
            }
            RightFloatLayerView rightFloatLayerView = this.J1;
            if (rightFloatLayerView != null && rightFloatLayerView.getTag() == this.I1) {
                this.J1.setTag(null);
                this.J1.setAutoCompleteShown(true);
                this.J1.d();
            }
        }
    }

    public PbListView T0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048652, this)) == null) ? this.I : (PbListView) invokeV.objValue;
    }

    public /* synthetic */ void T1() {
        String a1;
        PbFragment pbFragment = this.c;
        if (pbFragment != null && pbFragment.v() != null && this.c.v().v2()) {
            a1 = this.c.getString(R.string.obfuscated_res_0x7f0f0dda);
        } else {
            a1 = a1();
        }
        if (!StringUtils.isNull(a1) && this.J0 != null) {
            a1 = TbSingleton.getInstance().getAdVertiComment(this.J0.k0(), this.J0.l0(), a1);
        }
        PbFragment pbFragment2 = this.c;
        if (pbFragment2 != null && pbFragment2.M4() != null) {
            this.c.M4().k0(a1);
        }
        TextView textView = this.u0;
        if (textView != null) {
            textView.setText(a1);
        }
        y3(false);
        S3();
    }

    public void T2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048654, this, z2) == null) {
            this.C.j0(z2);
        }
    }

    public void T3() {
        k08 k08Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048655, this) == null) || (k08Var = this.B0) == null) {
            return;
        }
        k08Var.m(2);
    }

    public int U0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048656, this)) == null) {
            try {
                return Integer.parseInt(this.G.getText().toString(), 10);
            } catch (Exception unused) {
                return -1;
            }
        }
        return invokeV.intValue;
    }

    public final void U1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048657, this) == null) {
            if (this.t0 != null && TbadkCoreApplication.getCurrentAccountInfo() != null) {
                this.t0.setImageResource(0);
                this.t0.K(TbadkCoreApplication.getCurrentAccountInfo().getAvatar(), 12, false);
                return;
            }
            this.t0.setImageResource(R.drawable.obfuscated_res_0x7f081221);
        }
    }

    public void U2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048658, this, z2) == null) {
            this.C.o0(z2);
        }
    }

    public void U3(aq4 aq4Var, nr4.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048659, this, aq4Var, eVar) == null) || aq4Var == null) {
            return;
        }
        int a2 = aq4Var.a();
        int h3 = aq4Var.h();
        nr4 nr4Var = this.D;
        if (nr4Var != null) {
            nr4Var.show();
        } else {
            this.D = new nr4(this.c.getPageContext().getPageActivity());
            View inflate = LayoutInflater.from(this.c.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d022e, (ViewGroup) null);
            this.F = inflate;
            this.D.setContentView(inflate);
            this.D.setPositiveButton(R.string.obfuscated_res_0x7f0f04e3, eVar);
            this.D.setNegativeButton(R.string.obfuscated_res_0x7f0f04de, new i0(this));
            this.D.setOnCalcelListener(new j0(this));
            this.D.create(this.c.getPageContext()).show();
        }
        EditText editText = (EditText) this.F.findViewById(R.id.obfuscated_res_0x7f090f08);
        this.G = editText;
        editText.setText("");
        TextView textView = (TextView) this.F.findViewById(R.id.obfuscated_res_0x7f090739);
        if (a2 <= 0) {
            a2 = 1;
        }
        if (h3 <= 0) {
            h3 = 1;
        }
        textView.setText(MessageFormat.format(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f046f), Integer.valueOf(a2), Integer.valueOf(h3)));
        this.c.getBaseFragmentActivity().ShowSoftKeyPadDelay(this.G, 150);
    }

    public View V0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048660, this)) == null) ? this.S0 : (View) invokeV.objValue;
    }

    public void V1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048661, this) == null) {
            x2(this.J0);
        }
    }

    public void V2(pu4.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048662, this, gVar) == null) {
            this.X1 = gVar;
            l08 l08Var = this.H;
            if (l08Var != null) {
                l08Var.e(gVar);
            }
        }
    }

    public void V3(boolean z2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048663, this, z2) == null) || this.l == null || (textView = this.R0) == null || this.e == null) {
            return;
        }
        if (z2) {
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.e.setVisibility(0);
            } else {
                this.e.setVisibility(8);
                this.l.removeHeaderView(this.R0);
                this.l.setTextViewAdded(false);
            }
            AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) this.R0.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = d2;
                this.R0.setLayoutParams(layoutParams);
            }
            H2();
            return;
        }
        AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) textView.getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT) + R0(true);
            this.R0.setLayoutParams(layoutParams2);
        }
        H2();
        A2();
    }

    public PbFakeFloorModel W0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048664, this)) == null) ? this.e1 : (PbFakeFloorModel) invokeV.objValue;
    }

    public void W1() {
        ev7 ev7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048665, this) == null) || (ev7Var = this.q) == null) {
            return;
        }
        ev7Var.b();
    }

    public void W2(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048666, this, onClickListener) == null) {
            this.Y1 = onClickListener;
            pu7 pu7Var = this.C;
            if (pu7Var != null) {
                pu7Var.p0(onClickListener);
            }
        }
    }

    public final void W3(bs7 bs7Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048667, this, bs7Var) == null) || bs7Var == null || bs7Var.O() == null || bs7Var.O().isVideoThreadType()) {
            return;
        }
        boolean z2 = bs7Var.O().getIs_good() == 1;
        boolean z3 = bs7Var.O().getIs_top() == 1;
        ww7 ww7Var = this.u;
        if (ww7Var != null) {
            ww7Var.l(bs7Var, z2, z3);
        }
        pu7 pu7Var = this.C;
        if (pu7Var == null || pu7Var.t() == null) {
            return;
        }
        this.C.t().e(bs7Var, z2, z3);
    }

    public bv7 X0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048668, this)) == null) ? this.f1 : (bv7) invokeV.objValue;
    }

    public void X1(pj8 pj8Var) {
        bs7 bs7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048669, this, pj8Var) == null) || pj8Var == null || pj8Var.a == null || pj8Var.b == null || (bs7Var = this.J0) == null || bs7Var.O() == null || this.J0.O().getAgreeData() == null) {
            return;
        }
        AgreeData agreeData = this.J0.O().getAgreeData();
        String str = pj8Var.b.nid;
        if (!TextUtils.isEmpty(str) && !"0".equals(str)) {
            BaijiahaoData baijiahaoData = agreeData.baijiahaoData;
            if (baijiahaoData == null || !TextUtils.equals(str, baijiahaoData.oriUgcNid)) {
                return;
            }
        } else {
            String str2 = pj8Var.b.threadId;
            String str3 = agreeData.threadId;
            if ("0".equals(str2) || TextUtils.isEmpty(str2) || !TextUtils.equals(str2, str3)) {
                return;
            }
        }
        AgreeData agreeData2 = pj8Var.b;
        if (agreeData2.agreeType == 2 && agreeData2.hasAgree) {
            s3(this.x0);
        }
        AgreeData agreeData3 = pj8Var.b;
        w2(agreeData3, agreeData3.agreeNum);
    }

    public void X2(String str) {
        zx7 zx7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048670, this, str) == null) || (zx7Var = this.i) == null) {
            return;
        }
        zx7Var.b(str);
    }

    @SuppressLint({"CutPasteId"})
    public void X3(bs7 bs7Var, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048671, this, bs7Var, z2) == null) || bs7Var == null) {
            return;
        }
        g4(bs7Var, z2);
        n0();
    }

    public final boolean Y(AbsListView absListView, int i3) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048672, this, absListView, i3)) == null) {
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

    public xw7 Y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048673, this)) == null) ? this.r : (xw7) invokeV.objValue;
    }

    public void Y1(int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048674, this, i3) == null) || this.M0 == i3) {
            return;
        }
        this.M0 = i3;
        X3(this.J0, this.I0);
        z2(this.J0, this.I0, this.L0, i3);
        this.c.getBaseFragmentActivity().getLayoutMode().k(i3 == 1);
        this.c.getBaseFragmentActivity().getLayoutMode().j(this.d);
        SkinManager.setBackgroundColor(this.d, R.color.CAM_X0201);
        SkinManager.setBackgroundColor(this.m0, R.color.CAM_X0203);
        xw7 xw7Var = this.r;
        if (xw7Var != null) {
            xw7Var.h(i3);
        }
        tw7 tw7Var = this.v;
        if (tw7Var != null) {
            tw7Var.c(i3);
        }
        sw7 sw7Var = this.s;
        if (sw7Var != null) {
            sw7Var.e(i3);
        }
        uw7 uw7Var = this.t;
        if (uw7Var != null) {
            uw7Var.c(i3);
        }
        ww7 ww7Var = this.u;
        if (ww7Var != null) {
            ww7Var.u(i3);
        }
        vw7 vw7Var = this.w;
        if (vw7Var != null) {
            vw7Var.d();
        }
        rw7 rw7Var = this.x;
        if (rw7Var != null) {
            rw7Var.c();
        }
        MaskView maskView = this.H1;
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
        nr4 nr4Var = this.D;
        if (nr4Var != null) {
            nr4Var.autoChangeSkinType(this.c.getPageContext());
        }
        c4(this.e0);
        this.C.Z();
        l08 l08Var = this.H;
        if (l08Var != null) {
            l08Var.H(i3);
        }
        EditorTools editorTools = this.k0;
        if (editorTools != null) {
            editorTools.w(i3);
        }
        h08 h08Var = this.J;
        if (h08Var != null) {
            h08Var.f(i3);
        }
        if (!ListUtils.isEmpty(this.n)) {
            for (CustomBlueCheckRadioButton customBlueCheckRadioButton : this.n) {
                customBlueCheckRadioButton.c();
            }
        }
        h4();
        UtilHelper.setStatusBarBackground(this.e, i3);
        UtilHelper.setStatusBarBackground(this.U0, i3);
        if (this.y != null) {
            w95.a(this.c.getPageContext(), this.y);
        }
        bv7 bv7Var = this.f1;
        if (bv7Var != null) {
            bv7Var.h(i3);
        }
        ay7 ay7Var = this.h;
        if (ay7Var != null) {
            xw7 xw7Var2 = this.r;
            if (xw7Var2 != null) {
                xw7Var2.i(i3);
            } else {
                ay7Var.u(i3);
            }
        }
        HeadImageView headImageView = this.t0;
        if (headImageView != null) {
            headImageView.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
        }
        LinearLayout linearLayout = this.s0;
        if (linearLayout != null) {
            linearLayout.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(mi.f(this.c.getContext(), R.dimen.tbds47), SkinManager.getColor(R.color.CAM_X0209)));
        }
        bs7 bs7Var = this.J0;
        if (bs7Var != null && bs7Var.r()) {
            WebPManager.setPureDrawable(this.y0, R.drawable.obfuscated_res_0x7f080940, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
        } else {
            WebPManager.setPureDrawable(this.y0, R.drawable.obfuscated_res_0x7f08093f, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        }
        WebPManager.setPureDrawable(this.w0, R.drawable.obfuscated_res_0x7f080942, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        f4(this.J0);
        if (this.A0.getVisibility() == 0) {
            this.A0.setBackgroundDrawable(SkinManager.createShapeDrawable(mi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds15), R.color.CAM_X0301, 0, 0, i3));
        }
        SkinManager.setBackgroundColor(this.r0, R.color.CAM_X0207);
        SkinManager.setBackgroundColor(this.q0, R.color.CAM_X0203);
        SkinManager.setViewTextColor(this.p1, (int) R.color.cp_cont_n);
        SkinManager.setViewTextColor(this.u0, (int) R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.E0, (int) R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.D0, (int) R.color.CAM_X0107);
        SkinManager.setBackgroundShapeDrawable(this.D0, mi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18), R.color.CAM_X0207, R.color.CAM_X0207);
        SkinManager.setViewTextColor(this.C0, (int) R.color.CAM_X0107);
        SkinManager.setBackgroundShapeDrawable(this.C0, mi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18), R.color.CAM_X0207, R.color.CAM_X0207);
        AgreeView agreeView = this.x0;
        if (agreeView != null) {
            agreeView.r();
            this.x0.J(i3);
            AgreeData data = this.x0.getData();
            if (data != null) {
                w2(data, data.agreeNum);
            }
        }
        bu7 bu7Var = this.s1;
        if (bu7Var != null) {
            bu7Var.m(i3);
        }
        PbEmotionBar pbEmotionBar = this.a1;
        if (pbEmotionBar != null) {
            pbEmotionBar.w();
        }
        PbThreadPostView pbThreadPostView = this.o;
        if (pbThreadPostView != null) {
            pbThreadPostView.c(i3);
        }
        k08 k08Var = this.B0;
        if (k08Var != null) {
            k08Var.i();
        }
        j08 j08Var = this.G1;
        if (j08Var != null) {
            j08Var.c();
        }
        RightFloatLayerView rightFloatLayerView = this.J1;
        if (rightFloatLayerView != null) {
            rightFloatLayerView.o();
        }
        SkinManager.setBackgroundColor(this.T0, R.color.CAM_X0207);
        SkinManager.setViewTextColor(this.T0.findViewById(R.id.obfuscated_res_0x7f09225a), (int) R.color.CAM_X0105);
    }

    public void Y2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048675, this, z2) == null) {
            this.h1 = z2;
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView != null) {
                this.i1 = pbLandscapeListView.getHeaderViewsCount();
            }
        }
    }

    public void Y3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048676, this, str) == null) {
            this.c.showToast(str);
        }
    }

    public void Z() {
        k08 k08Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048677, this) == null) || (k08Var = this.B0) == null) {
            return;
        }
        k08Var.l(false);
    }

    public final PostData Z0(bs7 bs7Var) {
        InterceptResult invokeL;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048678, this, bs7Var)) == null) {
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

    public void Z1(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048679, this, configuration) == null) || configuration == null) {
            return;
        }
        k0();
        if (configuration.orientation == 2) {
            k1();
            m1();
        } else {
            G2();
        }
        bv7 bv7Var = this.f1;
        if (bv7Var != null) {
            bv7Var.c();
        }
        this.c.b5();
        this.B.setVisibility(8);
        this.h.B(false);
        this.c.X5(false);
        if (this.r != null) {
            if (configuration.orientation == 1) {
                h1().setVisibility(0);
            }
            if (configuration.orientation == 2) {
                this.c2 = true;
                this.l.setIsLandscape(true);
                this.l.smoothScrollToPosition(0);
            } else {
                this.c2 = false;
                this.l.setIsLandscape(false);
                int i3 = this.a2;
                if (i3 > 0) {
                    this.l.smoothScrollBy(i3, 0);
                }
            }
            this.r.j(configuration);
            this.Q0.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        }
    }

    public void Z2(PbFragment.e3 e3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048680, this, e3Var) == null) {
        }
    }

    public void Z3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048681, this) == null) {
            this.c.showProgressBar();
        }
    }

    public NoNetworkView a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048682, this)) == null) ? this.m : (NoNetworkView) invokeV.objValue;
    }

    public boolean a0(boolean z2) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048683, this, z2)) == null) {
            EditorTools editorTools = this.k0;
            if (editorTools == null || !editorTools.u()) {
                return false;
            }
            this.k0.q();
            return true;
        }
        return invokeZ.booleanValue;
    }

    public String a1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048684, this)) == null) {
            if (!li.isEmpty(this.z1)) {
                return this.z1;
            }
            if (this.c != null) {
                this.z1 = TbadkCoreApplication.getInst().getResources().getString(dw7.b());
            }
            return this.z1;
        }
        return (String) invokeV.objValue;
    }

    public void a2() {
        NoNetworkView.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048685, this) == null) {
            fv7 fv7Var = this.p;
            if (fv7Var != null) {
                fv7Var.l();
            }
            RelativeLayout relativeLayout = this.d;
            if (relativeLayout != null && relativeLayout.getHandler() != null) {
                this.d.getHandler().removeCallbacksAndMessages(null);
            }
            k08 k08Var = this.B0;
            if (k08Var != null) {
                k08Var.j();
            }
            aw7 aw7Var = this.g1;
            if (aw7Var != null) {
                aw7Var.a();
            }
            sv7 sv7Var = this.v1;
            if (sv7Var != null) {
                sv7Var.c();
            }
            PbTopTipView pbTopTipView = this.n1;
            if (pbTopTipView != null) {
                pbTopTipView.g();
            }
            this.c.hideProgressBar();
            NoNetworkView noNetworkView = this.m;
            if (noNetworkView != null && (bVar = this.P) != null) {
                noNetworkView.d(bVar);
            }
            k0();
            q0();
            if (this.d1 != null) {
                ng.a().removeCallbacks(this.d1);
            }
            PbInterviewStatusView pbInterviewStatusView = this.P0;
            if (pbInterviewStatusView != null) {
                pbInterviewStatusView.m();
            }
            this.P1 = null;
            this.g.removeCallbacksAndMessages(null);
            this.C.a0(3);
            View view2 = this.e;
            if (view2 != null) {
                view2.setBackgroundDrawable(null);
            }
            xw7 xw7Var = this.r;
            if (xw7Var != null) {
                xw7Var.a();
            }
            pu7 pu7Var = this.C;
            if (pu7Var != null) {
                pu7Var.b0();
            }
            this.l.setOnLayoutListener(null);
            cx7 cx7Var = this.r1;
            if (cx7Var != null) {
                cx7Var.l();
            }
            PbEmotionBar pbEmotionBar = this.a1;
            if (pbEmotionBar != null) {
                pbEmotionBar.x();
            }
            ww7 ww7Var = this.u;
            if (ww7Var != null) {
                ww7Var.v();
            }
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView != null) {
                pbLandscapeListView.getViewTreeObserver().removeGlobalOnLayoutListener(this.a);
            }
        }
    }

    public void a3(TbRichTextView.y yVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048686, this, yVar) == null) {
            this.O = yVar;
            this.C.s0(yVar);
            this.s1.q(this.O);
        }
    }

    public void a4() {
        FallingView fallingView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048687, this) == null) || (fallingView = this.I1) == null) {
            return;
        }
        fallingView.F();
    }

    public boolean b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048688, this)) == null) {
            PbListView pbListView = this.I;
            if (pbListView == null || TextUtils.isEmpty(pbListView.h())) {
                return false;
            }
            return this.I.h().equals(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f09ec));
        }
        return invokeV.booleanValue;
    }

    public final int b1(PbReplyTitleViewHolder pbReplyTitleViewHolder) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048689, this, pbReplyTitleViewHolder)) == null) {
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

    public void b2(TbRichText tbRichText) {
        bs7 bs7Var;
        PostData postData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048690, this, tbRichText) == null) || (bs7Var = this.J0) == null || bs7Var.F() == null || this.J0.F().isEmpty() || tbRichText == null || StringUtils.isNull(tbRichText.getAuthorId())) {
            return;
        }
        for (int i3 = 0; i3 < this.J0.F().size() && (postData = this.J0.F().get(i3)) != null && postData.s() != null && !StringUtils.isNull(postData.s().getUserId()); i3++) {
            if (this.J0.F().get(i3).s().getUserId().equals(tbRichText.getAuthorId())) {
                bu7 bu7Var = this.s1;
                if (bu7Var != null && bu7Var.l()) {
                    y3(false);
                }
                PbEmotionBar pbEmotionBar = this.a1;
                if (pbEmotionBar != null) {
                    pbEmotionBar.q(true);
                }
                postData.s().getName_show();
                return;
            }
        }
    }

    public void b3(NoNetworkView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048691, this, bVar) == null) {
            this.P = bVar;
            NoNetworkView noNetworkView = this.m;
            if (noNetworkView != null) {
                noNetworkView.a(bVar);
            }
        }
    }

    public void b4() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048692, this) == null) || this.Z1 == null) {
            return;
        }
        while (this.Z1.size() > 0) {
            TbImageView remove = this.Z1.remove(0);
            if (remove != null) {
                remove.O();
            }
        }
    }

    public final void c0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048693, this) == null) || this.J0 == null || !UbsABTestHelper.isResizeInduceSharingABTest() || wx7.k(this.J0.Q())) {
            return;
        }
        this.B0.e();
        wx7.b(this.J0.Q());
    }

    public int c1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048694, this)) == null) ? R.id.obfuscated_res_0x7f091ac8 : invokeV.intValue;
    }

    public boolean c2(int i3) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048695, this, i3)) == null) {
            xw7 xw7Var = this.r;
            if (xw7Var != null) {
                return xw7Var.k(i3);
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public void c3(BdListView.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048696, this, pVar) == null) {
            this.l.setOnSrollToBottomListener(pVar);
        }
    }

    public void c4(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048697, this, z2) == null) {
            this.e0 = z2;
        }
    }

    public void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048698, this) == null) {
            if (!this.c.checkUpIsLogin()) {
                TiebaStatic.log(new StatisticItem("c10517").param("obj_locate", 2).param("fid", this.h0));
            } else if (this.c.e4()) {
                b35 M4 = this.c.M4();
                if (M4 != null && (M4.B() || M4.D())) {
                    this.c.M4().z(false, null);
                    return;
                }
                if (this.k0 != null) {
                    x1();
                }
                EditorTools editorTools = this.k0;
                if (editorTools != null) {
                    this.F0 = false;
                    if (editorTools.n(2) != null) {
                        kj8.c(this.c.getPageContext(), (View) this.k0.n(2).m, false, l2);
                    }
                }
                k1();
            }
        }
    }

    public final int d1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048699, this)) == null) {
            View childAt = this.l.getChildAt(0);
            if (childAt == null) {
                return 0;
            }
            return (-childAt.getTop()) + (this.l.getFirstVisiblePosition() * childAt.getHeight());
        }
        return invokeV.intValue;
    }

    public void d2() {
        PostData postData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048700, this) == null) || this.c == null) {
            return;
        }
        if ((this.C1 || this.D1 == 17) && UbsABTestHelper.leftSlideToFrs()) {
            bs7 bs7Var = this.J0;
            if (bs7Var == null || bs7Var.l() == null || li.isEmpty(this.J0.l().getName())) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.c.getContext()).createNormalCfg(this.J0.l().getName(), null)));
            TiebaStatic.log(new StatisticItem("c13853").param("post_id", this.J0.Q()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("fid", this.J0.l().getId()));
        } else if (!this.k1 || this.j1 || (postData = this.K0) == null || postData.s() == null) {
        } else {
            TiebaStatic.log(new StatisticItem("c12601").param("obj_locate", this.c.isSimpleForum() ? 2 : 1).param("obj_type", this.j1 ? 2 : 1));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.c.getPageContext().getPageActivity(), this.K0.s().getUserId(), this.K0.s().getUserName(), this.c.v().o1(), AddFriendActivityConfig.TYPE_PB_HEAD)));
        }
    }

    public void d3(AbsListView.OnScrollListener onScrollListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048701, this, onScrollListener) == null) {
            this.l.setOnScrollListener(onScrollListener);
        }
    }

    public void d4(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048702, this, z2) == null) {
            this.h.H(z2);
            if (z2 && this.N0) {
                this.I.C(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f03e4));
                this.l.setNextPage(this.I);
                this.f = 2;
            }
            U1();
        }
    }

    public void e0(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048703, this, z2) == null) {
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

    public int e1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048704, this)) == null) ? this.M0 : invokeV.intValue;
    }

    public void e2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048705, this, z2) == null) {
            if (z2) {
                E3();
            } else {
                n1();
            }
            this.Z0.c = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.Z0));
            t2(this.Z0.c, false);
        }
    }

    public void e3(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048706, this, onClickListener) == null) {
            this.C.w0(onClickListener);
        }
    }

    public void e4(zr7 zr7Var) {
        String string;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048707, this, zr7Var) == null) || zr7Var == null) {
            return;
        }
        this.h.I();
        if (!StringUtils.isNull(zr7Var.b)) {
            this.h.F(zr7Var.b);
        }
        String string2 = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f13bf);
        int e3 = kg.e(zr7Var.a, 0);
        if (e3 == 100) {
            string = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f10f7);
        } else if (e3 != 300) {
            string = e3 != 400 ? "" : TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f1339);
        } else {
            string = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f02eb);
        }
        this.c.showNetRefreshView(this.d, String.format(string2, string), null, TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0295), true, new e0(this, zr7Var.c));
    }

    public final void f0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048708, this) == null) {
            bu7 bu7Var = new bu7(this.c, this, (ViewStub) this.d.findViewById(R.id.obfuscated_res_0x7f091456));
            this.s1 = bu7Var;
            bu7Var.o(this.N);
            this.s1.p(this.R);
            this.s1.q(this.O);
            this.s1.o(this.N);
            this.s1.s(this.i0);
        }
    }

    public View f1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048709, this)) == null) ? this.e : (View) invokeV.objValue;
    }

    public void f2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048710, this) == null) {
            b4();
            this.C.a0(1);
            xw7 xw7Var = this.r;
            if (xw7Var != null) {
                xw7Var.l();
            }
            fv7 fv7Var = this.p;
            if (fv7Var != null) {
                fv7Var.k();
            }
            RightFloatLayerView rightFloatLayerView = this.J1;
            if (rightFloatLayerView != null && (rightFloatLayerView instanceof RightFloatLayerLottieView)) {
                ((RightFloatLayerLottieView) rightFloatLayerView).H(600);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
        }
    }

    public void f3(int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048711, this, i3) == null) {
            this.D1 = i3;
        }
    }

    public void f4(bs7 bs7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048712, this, bs7Var) == null) {
            if (bs7Var != null && AntiHelper.o(bs7Var.O())) {
                k08 k08Var = this.B0;
                if (k08Var != null) {
                    k08Var.k(false);
                    this.B0.j();
                }
                ViewGroup.LayoutParams layoutParams = this.z0.getLayoutParams();
                layoutParams.height = -2;
                layoutParams.width = -2;
                this.z0.setLayoutParams(layoutParams);
                WebPManager.setPureDrawable(this.z0, R.drawable.obfuscated_res_0x7f080944, R.color.CAM_X0110, WebPManager.ResourceStateType.NORMAL_PRESS);
                return;
            }
            k08 k08Var2 = this.B0;
            if (k08Var2 == null || !k08Var2.g()) {
                ViewGroup.LayoutParams layoutParams2 = this.z0.getLayoutParams();
                layoutParams2.height = -2;
                layoutParams2.width = -2;
                this.z0.setLayoutParams(layoutParams2);
                WebPManager.setPureDrawable(this.z0, R.drawable.obfuscated_res_0x7f080944, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            }
        }
    }

    public final CustomBlueCheckRadioButton g0(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048713, this, str, str2)) == null) {
            Activity pageActivity = this.c.getPageContext().getPageActivity();
            CustomBlueCheckRadioButton customBlueCheckRadioButton = new CustomBlueCheckRadioButton(pageActivity);
            RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, mi.f(pageActivity, R.dimen.obfuscated_res_0x7f07019a));
            customBlueCheckRadioButton.setOnCheckedChangeListener(this.X);
            customBlueCheckRadioButton.setTag(str);
            customBlueCheckRadioButton.setText(str2);
            customBlueCheckRadioButton.setLayoutParams(layoutParams);
            return customBlueCheckRadioButton;
        }
        return (CustomBlueCheckRadioButton) invokeLL.objValue;
    }

    public PbThreadPostView g1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048714, this)) == null) ? this.o : (PbThreadPostView) invokeV.objValue;
    }

    public void g2(uo uoVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048715, this, uoVar) == null) {
            PbLandscapeListView pbLandscapeListView = this.l;
            pbLandscapeListView.h0 = uoVar;
            pbLandscapeListView.W = true;
        }
    }

    public void g3(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048716, this, onLongClickListener) == null) {
            this.u.y(onLongClickListener);
            this.C.t0(onLongClickListener);
            bu7 bu7Var = this.s1;
            if (bu7Var != null) {
                bu7Var.r(onLongClickListener);
            }
        }
    }

    public boolean g4(bs7 bs7Var, boolean z2) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048717, this, bs7Var, z2)) == null) {
            if (bs7Var == null) {
                return false;
            }
            if (this.t != null) {
                if (bs7Var.O() != null && bs7Var.O().getIsNoTitle() == 0 && !bs7Var.O().isVideoThreadType() && !this.L1) {
                    if (bs7Var.O() != null) {
                        ThreadData O = bs7Var.O();
                        O.parserSpecTitleForFrsAndPb(true, B3(bs7Var));
                        O.setResource(3);
                        O.setPbTitle("2");
                    }
                    if (bs7Var.O().isBJHArticleThreadType()) {
                        this.u.x(this.l);
                        this.t.d(this.l);
                        this.t.a(this.l);
                        this.u.j(this.l);
                        this.u.B(this.J0);
                        if (E1(bs7Var)) {
                            this.t.d(this.l);
                        } else {
                            this.t.e(bs7Var);
                        }
                    } else {
                        this.u.B(this.J0);
                        if (E1(bs7Var)) {
                            this.t.d(this.l);
                        } else {
                            this.t.g(bs7Var);
                        }
                    }
                } else if (bs7Var.O().getIsNoTitle() == 1) {
                    if (bs7Var.O() != null) {
                        this.t.d(this.l);
                        this.u.B(this.J0);
                    }
                } else {
                    this.t.d(this.l);
                    this.u.B(this.J0);
                }
            }
            W3(bs7Var);
            this.I0 = z2;
            return false;
        }
        return invokeLZ.booleanValue;
    }

    public void h0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048718, this) == null) || this.b2) {
            return;
        }
        TiebaStatic.log("c10490");
        this.b2 = true;
        nr4 nr4Var = new nr4(this.c.getPageContext().getPageActivity());
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(f2, Integer.valueOf(h2));
        nr4Var.setTitle(R.string.obfuscated_res_0x7f0f07d8);
        View inflate = LayoutInflater.from(this.c.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0850, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090c24)).setText(R.string.obfuscated_res_0x7f0f0781);
        ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0920a2)).setText(R.string.obfuscated_res_0x7f0f07d8);
        nr4Var.setContentView(inflate);
        nr4Var.setYesButtonTag(sparseArray);
        nr4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f07d7, this.c);
        nr4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0a62, new k0(this));
        nr4Var.create(this.c.getPageContext()).show();
    }

    public RelativeLayout h1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048719, this)) == null) ? this.B : (RelativeLayout) invokeV.objValue;
    }

    public void h2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048720, this) == null) {
            this.C.a0(2);
            xw7 xw7Var = this.r;
            if (xw7Var != null) {
                xw7Var.m();
                if (TbSingleton.getInstance().isNotchScreen(this.c.getFragmentActivity()) || TbSingleton.getInstance().isCutoutScreen(this.c.getFragmentActivity())) {
                    return;
                }
                i1().setSystemUiVisibility(4);
            }
        }
    }

    public final void h3(PostData postData, bs7 bs7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048721, this, postData, bs7Var) == null) {
            this.u.z(postData, bs7Var);
        }
    }

    public final void h4() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048722, this) == null) && this.c.E4()) {
            if (this.c.J4() == -1) {
                SkinManager.setViewTextColor(this.z, R.color.CAM_X0110, 1);
            }
            if (this.c.I4() == -1) {
                SkinManager.setViewTextColor(this.A, R.color.CAM_X0110, 1);
            }
        }
    }

    public void i0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048723, this, str) == null) {
            if (str.contains("_")) {
                str = str.replace("_", "\n");
            }
            nr4 nr4Var = new nr4(this.c.getPageContext().getPageActivity());
            View inflate = LayoutInflater.from(this.c.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0850, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0920a2);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(0, 0, 0, 0);
            textView.setLayoutParams(layoutParams);
            textView.setGravity(3);
            textView.setText(str);
            ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090c24)).setVisibility(8);
            nr4Var.setContentView(inflate);
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(f2, Integer.valueOf(i2));
            nr4Var.setYesButtonTag(sparseArray);
            nr4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f152f, this.c);
            nr4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0374, new l0(this));
            nr4Var.create(this.c.getPageContext()).show();
        }
    }

    public View i1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048724, this)) == null) ? this.d : (View) invokeV.objValue;
    }

    public void i2(AbsListView absListView, int i3, int i4, int i5) {
        PbReplyTitleViewHolder pbReplyTitleViewHolder;
        ww7 ww7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048725, this, absListView, i3, i4, i5) == null) {
            ev7 ev7Var = this.q;
            if (ev7Var != null) {
                ev7Var.c(i3, i4);
            }
            xw7 xw7Var = this.r;
            if (xw7Var != null) {
                xw7Var.n(absListView, i3, i4, i5);
            }
            ay7 ay7Var = this.h;
            if (ay7Var != null && (ww7Var = this.u) != null) {
                ay7Var.w(ww7Var.p());
            }
            t0 t0Var = this.Z0;
            t0Var.a = i3;
            t0Var.b = this.l.getHeaderViewsCount();
            this.Z0.c = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.Z0));
            x3(Y(absListView, i3));
            int i6 = 0;
            t2(this.Z0.c, false);
            j0();
            if (!this.I.n() || this.I.C) {
                return;
            }
            t0 t0Var2 = this.Z0;
            if (t0Var2 != null && (pbReplyTitleViewHolder = t0Var2.c) != null && pbReplyTitleViewHolder.b() != null) {
                i6 = this.Z0.c.b().getTop() < 0 ? this.Z0.c.b().getHeight() : this.Z0.c.b().getBottom();
            }
            this.I.e(i6);
            this.I.C = true;
        }
    }

    public void i3(boolean z2, PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048726, this, z2, postWriteCallBackData) == null) {
            this.c.hideProgressBar();
            if (z2) {
                k0();
            } else if (postWriteCallBackData != null && (postWriteCallBackData.isSensitiveError() || postWriteCallBackData.isErrorLinkCountExceedLimit() || postWriteCallBackData.isErrorShowApplyMemberDialog())) {
                l0();
            } else {
                k0();
            }
        }
    }

    public void i4(bs7 bs7Var) {
        sw7 sw7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048727, this, bs7Var) == null) || (sw7Var = this.s) == null) {
            return;
        }
        sw7Var.h(bs7Var, this.I0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x004d, code lost:
        if (r5.E1 == 1) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void j0() {
        j08 j08Var;
        boolean z2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048728, this) == null) || (j08Var = this.G1) == null) {
            return;
        }
        if (((j08Var.a() == null || this.G1.a().getParent() == null) ? -1 : this.l.getPositionForView(this.G1.a())) != -1) {
            if (this.G1.a().getTop() + k2 <= this.S0.getBottom()) {
                this.E1 = 1;
                z2 = true;
            } else {
                this.E1 = 0;
                z2 = false;
            }
        }
        this.V0.u(this.E1 == 1);
        this.G1.e(z2);
    }

    public void j1() {
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048729, this) == null) {
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView != null) {
                pbLandscapeListView.setVisibility(8);
            }
            if (this.l != null) {
                this.Q0.setVisibility(8);
            }
            ay7 ay7Var = this.h;
            if (ay7Var == null || (view2 = ay7Var.d) == null) {
                return;
            }
            view2.setVisibility(8);
        }
    }

    public void j2(AbsListView absListView, int i3) {
        RightFloatLayerView rightFloatLayerView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048730, this, absListView, i3) == null) {
            xw7 xw7Var = this.r;
            if (xw7Var != null) {
                xw7Var.o(absListView, i3);
            }
            if (!this.c2 && i3 == 0) {
                this.a2 = d1();
                this.Z0.c = null;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.Z0));
                t2(this.Z0.c, true);
                j0();
                this.C.f0(true);
            }
            this.C.e0();
            if (i3 == 0) {
                RightFloatLayerView rightFloatLayerView2 = this.J1;
                if (rightFloatLayerView2 != null) {
                    rightFloatLayerView2.q();
                }
            } else if (i3 == 1) {
                RightFloatLayerView rightFloatLayerView3 = this.J1;
                if (rightFloatLayerView3 != null) {
                    rightFloatLayerView3.p();
                }
            } else if (i3 != 2 || (rightFloatLayerView = this.J1) == null) {
            } else {
                rightFloatLayerView.r();
            }
        }
    }

    public void j3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048731, this) == null) {
            this.c.hideProgressBar();
            bs7 bs7Var = this.J0;
            if (bs7Var != null && this.I != null && bs7Var.y() != null && this.J0.y().b() == 0) {
                this.I.u(this.J0.t());
                if (this.J0.t()) {
                    StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_PB_FOLD_ICON_SHOW);
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem.param("fid", this.J0.m());
                    statisticItem.param("fname", this.J0.n());
                    statisticItem.param("tid", this.J0.Q());
                    TiebaStatic.log(statisticItem);
                }
            }
            q0();
            this.l.A(0L);
            n0();
        }
    }

    public void k0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048732, this) == null) {
            this.h.k();
            ww7 ww7Var = this.u;
            if (ww7Var != null) {
                ww7Var.m();
            }
            PbFragment pbFragment = this.c;
            if (pbFragment != null) {
                mi.w(pbFragment.getContext(), this.G);
            }
            m1();
            wr4 wr4Var = this.b0;
            if (wr4Var != null) {
                wr4Var.dismiss();
            }
            o0();
            nr4 nr4Var = this.D;
            if (nr4Var != null) {
                nr4Var.dismiss();
            }
            pr4 pr4Var = this.E;
            if (pr4Var != null) {
                pr4Var.e();
            }
        }
    }

    public void k1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048733, this) == null) || this.r0 == null) {
            return;
        }
        this.q0.setVisibility(8);
        this.r0.setVisibility(8);
        this.F0 = false;
        PbEmotionBar pbEmotionBar = this.a1;
        if (pbEmotionBar != null) {
            pbEmotionBar.setVisibility(8);
            F2(false);
        }
    }

    public void k2(ArrayList<mp4> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048734, this, arrayList) == null) {
            if (this.V == null) {
                this.V = LayoutInflater.from(this.c.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d01eb, (ViewGroup) null);
            }
            this.c.getBaseFragmentActivity().getLayoutMode().j(this.V);
            if (this.U == null) {
                Dialog dialog = new Dialog(this.c.getPageContext().getPageActivity(), R.style.obfuscated_res_0x7f10039f);
                this.U = dialog;
                dialog.setCanceledOnTouchOutside(true);
                this.U.setCancelable(true);
                this.j0 = (ScrollView) this.V.findViewById(R.id.obfuscated_res_0x7f090ccc);
                this.U.setContentView(this.V);
                WindowManager.LayoutParams attributes = this.U.getWindow().getAttributes();
                attributes.width = mi.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0702de);
                this.U.getWindow().setAttributes(attributes);
                this.X = new x(this);
                this.W = (LinearLayout) this.V.findViewById(R.id.obfuscated_res_0x7f090ccb);
                TextView textView = (TextView) this.V.findViewById(R.id.obfuscated_res_0x7f09079e);
                this.Z = textView;
                textView.setOnClickListener(new y(this));
                TextView textView2 = (TextView) this.V.findViewById(R.id.obfuscated_res_0x7f09079f);
                this.Y = textView2;
                textView2.setOnClickListener(this.N);
            }
            this.W.removeAllViews();
            this.n = new ArrayList();
            CustomBlueCheckRadioButton g02 = g0("0", this.c.getPageContext().getString(R.string.obfuscated_res_0x7f0f13c4));
            this.n.add(g02);
            g02.setChecked(true);
            this.W.addView(g02);
            if (arrayList != null) {
                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                    mp4 mp4Var = arrayList.get(i3);
                    if (mp4Var != null && !TextUtils.isEmpty(mp4Var.b()) && mp4Var.a() > 0) {
                        CustomBlueCheckRadioButton g03 = g0(String.valueOf(mp4Var.a()), mp4Var.b());
                        this.n.add(g03);
                        View view2 = new View(this.c.getPageContext().getPageActivity());
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, mi.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f070198));
                        SkinManager.setBackgroundColor(view2, R.color.CAM_X0204);
                        view2.setLayoutParams(layoutParams);
                        this.W.addView(view2);
                        this.W.addView(g03);
                    }
                }
                ViewGroup.LayoutParams layoutParams2 = this.j0.getLayoutParams();
                int size = arrayList.size();
                if (size == 0 || size == 1) {
                    layoutParams2.height = mi.d(this.c.getPageContext().getPageActivity(), 120.0f);
                } else if (size != 2) {
                    layoutParams2.height = mi.d(this.c.getPageContext().getPageActivity(), 220.0f);
                } else {
                    layoutParams2.height = mi.d(this.c.getPageContext().getPageActivity(), 186.0f);
                }
                this.j0.setLayoutParams(layoutParams2);
                this.j0.removeAllViews();
                LinearLayout linearLayout = this.W;
                if (linearLayout != null && linearLayout.getParent() == null) {
                    this.j0.addView(this.W);
                }
            }
            pg.j(this.U, this.c.getPageContext());
        }
    }

    public void k3() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048735, this) == null) || (pbFragment = this.c) == null || pbFragment.getBaseFragmentActivity() == null) {
            return;
        }
        mi.w(this.c.getPageContext().getPageActivity(), this.c.getBaseFragmentActivity().getCurrentFocus());
    }

    public void l0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048736, this) == null) {
            this.h.k();
            ww7 ww7Var = this.u;
            if (ww7Var != null) {
                ww7Var.m();
            }
            wr4 wr4Var = this.b0;
            if (wr4Var != null) {
                wr4Var.dismiss();
            }
            o0();
            nr4 nr4Var = this.D;
            if (nr4Var != null) {
                nr4Var.dismiss();
            }
            pr4 pr4Var = this.E;
            if (pr4Var != null) {
                pr4Var.e();
            }
        }
    }

    public void l1(boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048737, this, z2) == null) || this.r0 == null || this.u0 == null) {
            return;
        }
        TbSingleton tbSingleton = TbSingleton.getInstance();
        bs7 bs7Var = this.J0;
        boolean z3 = bs7Var != null && bs7Var.k0();
        bs7 bs7Var2 = this.J0;
        this.u0.setText(tbSingleton.getAdVertiComment(z3, bs7Var2 != null && bs7Var2.l0(), a1()));
        if (z2) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(400L);
            this.r0.startAnimation(alphaAnimation);
        }
        this.q0.setVisibility(0);
        this.r0.setVisibility(0);
        this.F0 = true;
        if (this.a1 == null || this.s1.l()) {
            return;
        }
        this.a1.setVisibility(0);
        F2(true);
    }

    public void l2(int i3, String str, int i4, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048738, this, new Object[]{Integer.valueOf(i3), str, Integer.valueOf(i4), Boolean.valueOf(z2)}) == null) {
            m2(i3, str, i4, z2, null);
        }
    }

    public void l3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048739, this) == null) {
            this.I.z();
            this.I.Q();
        }
    }

    public void m0() {
        k08 k08Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048740, this) == null) || (k08Var = this.B0) == null) {
            return;
        }
        k08Var.k(false);
    }

    public void m1() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048741, this) == null) || (editorTools = this.k0) == null) {
            return;
        }
        editorTools.o();
        cx7 cx7Var = this.r1;
        if (cx7Var != null) {
            cx7Var.m();
        }
    }

    public void m2(int i3, String str, int i4, boolean z2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048742, this, new Object[]{Integer.valueOf(i3), str, Integer.valueOf(i4), Boolean.valueOf(z2), str2}) == null) {
            n2(i3, str, i4, z2, str2, false);
        }
    }

    public void m3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048743, this, z2) == null) {
            this.u.A(z2);
        }
    }

    public final boolean n0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048744, this)) == null) ? this.s.b(this.I0) : invokeV.booleanValue;
    }

    public void n1() {
        ay7 ay7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048745, this) == null) || (ay7Var = this.h) == null) {
            return;
        }
        ay7Var.q();
    }

    public void n2(int i3, String str, int i4, boolean z2, String str2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048746, this, new Object[]{Integer.valueOf(i3), str, Integer.valueOf(i4), Boolean.valueOf(z2), str2, Boolean.valueOf(z3)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(R.id.obfuscated_res_0x7f091eb0, str);
            sparseArray.put(R.id.obfuscated_res_0x7f091eb2, Integer.valueOf(i3));
            sparseArray.put(R.id.obfuscated_res_0x7f091ecd, Integer.valueOf(i4));
            sparseArray.put(R.id.obfuscated_res_0x7f091eb1, Boolean.valueOf(z2));
            sparseArray.put(f2, Integer.valueOf(g2));
            int i5 = (i4 != 1002 || z2) ? R.string.obfuscated_res_0x7f0f0492 : R.string.obfuscated_res_0x7f0f0fbd;
            int i6 = R.string.obfuscated_res_0x7f0f0430;
            if (i3 == 0) {
                if (i4 != 1002 || z2) {
                    i6 = R.string.obfuscated_res_0x7f0f0496;
                    i5 = R.string.obfuscated_res_0x7f0f0497;
                } else {
                    i5 = R.string.obfuscated_res_0x7f0f0fc1;
                }
            }
            this.S = new nr4(this.c.getActivity());
            if (StringUtils.isNull(str2)) {
                this.S.setMessageId(i5);
            } else {
                this.S.setOnlyMessageShowCenter(false);
                this.S.setMessage(str2);
            }
            this.S.setYesButtonTag(sparseArray);
            this.S.setPositiveButton(R.string.obfuscated_res_0x7f0f04e3, this.c);
            this.S.setNegativeButton(R.string.obfuscated_res_0x7f0f04de, new p(this));
            this.S.setCancelable(true);
            this.S.create(this.c.getPageContext());
            if (z3) {
                A3(sparseArray, i6, i5);
            } else if (z2) {
                A3(sparseArray, i6, i5);
            } else if (q3()) {
                ti5 ti5Var = new ti5(this.c.v().P1().l().getDeletedReasonInfo().is_grays_cale_forum.intValue(), this.c.v().P1().l().getDeletedReasonInfo().is_boomgrow.intValue(), this.c.v().P1().o().has_forum_rule.intValue());
                ti5Var.i(this.c.v().P1().l().getId(), this.c.v().P1().l().getName());
                ti5Var.h(this.c.v().P1().l().getImage_url());
                ti5Var.j(this.c.v().P1().l().getUser_level());
                H3(sparseArray, i3, ti5Var, this.c.v().P1().U(), false);
            } else {
                P3(this.S, i3);
            }
        }
    }

    public void n3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048747, this, str) == null) {
            this.u0.performClick();
            if (StringUtils.isNull(str) || this.c.M4() == null || this.c.M4().v() == null || this.c.M4().v().h() == null) {
                return;
            }
            EditText h3 = this.c.M4().v().h();
            h3.setText(str);
            h3.setSelection(str.length());
        }
    }

    public void o0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048748, this) == null) {
            nr4 nr4Var = this.S;
            if (nr4Var != null) {
                nr4Var.dismiss();
            }
            Dialog dialog = this.T;
            if (dialog != null) {
                pg.b(dialog, this.c.getPageContext());
            }
            Dialog dialog2 = this.U;
            if (dialog2 != null) {
                pg.b(dialog2, this.c.getPageContext());
            }
            wr4 wr4Var = this.Q;
            if (wr4Var != null) {
                wr4Var.dismiss();
            }
        }
    }

    public void o1() {
        ku4 ku4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048749, this) == null) || (ku4Var = this.H0) == null) {
            return;
        }
        ku4Var.h(false);
    }

    public void o2(int i3, String str, int i4, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048750, this, new Object[]{Integer.valueOf(i3), str, Integer.valueOf(i4), Boolean.valueOf(z2)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(R.id.obfuscated_res_0x7f091eb0, str);
            sparseArray.put(R.id.obfuscated_res_0x7f091eb2, Integer.valueOf(i3));
            sparseArray.put(R.id.obfuscated_res_0x7f091ecd, Integer.valueOf(i4));
            sparseArray.put(R.id.obfuscated_res_0x7f091eb1, Boolean.valueOf(z2));
            sparseArray.put(f2, Integer.valueOf(g2));
            if (z2) {
                v3(sparseArray);
            } else {
                w3(i3, sparseArray);
            }
        }
    }

    public void o3(int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048751, this, i3) == null) {
            this.l.setSelection(i3);
        }
    }

    public void p0() {
        xw7 xw7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048752, this) == null) || (xw7Var = this.r) == null) {
            return;
        }
        xw7Var.b();
    }

    public void p1() {
        Runnable runnable;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048753, this) == null) {
            if (this.y == null) {
                w1();
            }
            this.k.setVisibility(8);
            Handler handler = this.P1;
            if (handler == null || (runnable = this.Q1) == null) {
                return;
            }
            handler.removeCallbacks(runnable);
        }
    }

    public void p2(SparseArray<Object> sparseArray, boolean z2) {
        ur4 ur4Var;
        ur4 ur4Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048754, this, sparseArray, z2) == null) {
            yr4 yr4Var = new yr4(this.c.getContext());
            yr4Var.q(this.c.getString(R.string.obfuscated_res_0x7f0f02d9));
            yr4Var.n(new o(this, z2));
            ArrayList arrayList = new ArrayList();
            int intValue = sparseArray.get(R.id.obfuscated_res_0x7f091eaa) instanceof Integer ? ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091eaa)).intValue() : -1;
            if (!"".equals(sparseArray.get(R.id.obfuscated_res_0x7f091eb0)) && intValue != 2) {
                if ((sparseArray.get(R.id.obfuscated_res_0x7f091eb2) instanceof Integer ? ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091eb2)).intValue() : -1) == 0) {
                    ur4Var2 = new ur4(10, this.c.getString(R.string.obfuscated_res_0x7f0f04a8), yr4Var);
                } else {
                    ur4Var2 = new ur4(10, this.c.getString(R.string.obfuscated_res_0x7f0f049d), yr4Var);
                }
                SparseArray sparseArray2 = new SparseArray();
                sparseArray2.put(R.id.obfuscated_res_0x7f091eb0, sparseArray.get(R.id.obfuscated_res_0x7f091eb0));
                sparseArray2.put(R.id.obfuscated_res_0x7f091eb2, sparseArray.get(R.id.obfuscated_res_0x7f091eb2));
                sparseArray2.put(R.id.obfuscated_res_0x7f091eb1, sparseArray.get(R.id.obfuscated_res_0x7f091eb1));
                sparseArray2.put(R.id.obfuscated_res_0x7f091ecd, sparseArray.get(R.id.obfuscated_res_0x7f091ecd));
                ur4Var2.d.setTag(sparseArray2);
                arrayList.add(ur4Var2);
            }
            if ((!"".equals(sparseArray.get(R.id.obfuscated_res_0x7f091ebb)) || !"".equals(sparseArray.get(R.id.obfuscated_res_0x7f091ebc))) && !O1()) {
                SparseArray sparseArray3 = new SparseArray();
                sparseArray3.put(R.id.obfuscated_res_0x7f091ebb, sparseArray.get(R.id.obfuscated_res_0x7f091ebb));
                sparseArray3.put(R.id.obfuscated_res_0x7f091ebc, sparseArray.get(R.id.obfuscated_res_0x7f091ebc));
                sparseArray3.put(R.id.obfuscated_res_0x7f091ebd, sparseArray.get(R.id.obfuscated_res_0x7f091ebd));
                sparseArray3.put(R.id.obfuscated_res_0x7f091ecd, sparseArray.get(R.id.obfuscated_res_0x7f091ecd));
                sparseArray3.put(R.id.obfuscated_res_0x7f091ebe, sparseArray.get(R.id.obfuscated_res_0x7f091ebe));
                ur4 ur4Var3 = new ur4(11, this.c.getString(R.string.obfuscated_res_0x7f0f0645), yr4Var);
                ur4Var3.d.setTag(sparseArray3);
                arrayList.add(ur4Var3);
            }
            if ((sparseArray.get(R.id.obfuscated_res_0x7f091f03) instanceof Boolean) && ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091f03)).booleanValue()) {
                SparseArray sparseArray4 = new SparseArray();
                sparseArray4.put(R.id.obfuscated_res_0x7f091ec5, sparseArray.get(R.id.obfuscated_res_0x7f091ec5));
                sparseArray4.put(R.id.obfuscated_res_0x7f091eff, sparseArray.get(R.id.obfuscated_res_0x7f091eff));
                sparseArray4.put(R.id.obfuscated_res_0x7f091f00, sparseArray.get(R.id.obfuscated_res_0x7f091f00));
                sparseArray4.put(R.id.obfuscated_res_0x7f091efe, sparseArray.get(R.id.obfuscated_res_0x7f091efe));
                sparseArray4.put(R.id.obfuscated_res_0x7f091f01, sparseArray.get(R.id.obfuscated_res_0x7f091f01));
                sparseArray4.put(R.id.obfuscated_res_0x7f091f02, sparseArray.get(R.id.obfuscated_res_0x7f091f02));
                sparseArray4.put(R.id.obfuscated_res_0x7f091efd, sparseArray.get(R.id.obfuscated_res_0x7f091efd));
                if (z2) {
                    ur4Var = new ur4(12, this.c.getString(R.string.obfuscated_res_0x7f0f148f), yr4Var);
                } else {
                    ur4Var = new ur4(12, this.c.getString(R.string.obfuscated_res_0x7f0f0b25), yr4Var);
                }
                ur4Var.d.setTag(sparseArray4);
                arrayList.add(ur4Var);
            }
            vx7.e(arrayList);
            if (UbsABTestHelper.isPBPlanA()) {
                yr4Var.k(arrayList, false);
            } else {
                yr4Var.k(arrayList, true);
            }
            wr4 wr4Var = new wr4(this.c.getPageContext(), yr4Var);
            this.Q = wr4Var;
            wr4Var.m();
        }
    }

    public void p3(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048755, this, list) == null) {
            this.q1 = list;
            cx7 cx7Var = this.r1;
            if (cx7Var != null) {
                cx7Var.q(list);
            }
        }
    }

    public void q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048756, this) == null) {
            PbListView pbListView = this.I;
            if (pbListView != null) {
                pbListView.x();
                this.I.f();
            }
            o1();
        }
    }

    public void q1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048757, this) == null) {
            this.M.setVisibility(8);
        }
    }

    public void q2(View view2) {
        SparseArray<Object> sparseArray;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048758, this, view2) == null) || (sparseArray = (SparseArray) view2.getTag()) == null) {
            return;
        }
        p2(sparseArray, false);
    }

    public final boolean q3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048759, this)) == null) {
            PbFragment pbFragment = this.c;
            return (pbFragment == null || pbFragment.v().P1().l().getDeletedReasonInfo() == null || 1 != this.c.v().P1().l().getDeletedReasonInfo().is_grays_cale_forum.intValue()) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public void r0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048760, this) == null) {
            this.l.A(0L);
            n0();
        }
    }

    public void r1() {
        RightFloatLayerView rightFloatLayerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048761, this) == null) || (rightFloatLayerView = this.J1) == null) {
            return;
        }
        rightFloatLayerView.c();
    }

    public void r2(@NonNull View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048762, this, view2) == null) || this.x0.getData() == null || !this.x0.getData().hasAgree || this.c.getActivity() == null) {
            return;
        }
        fr7 fr7Var = new fr7(this.c.getContext());
        int f3 = mi.f(TbadkCoreApplication.getInst(), R.dimen.tbds774);
        int f4 = mi.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f070724);
        int[] iArr = new int[2];
        view2.getLocationInWindow(iArr);
        int i3 = iArr[0];
        int i4 = iArr[1];
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(f4, f3);
        layoutParams.leftMargin = ((view2.getWidth() / 2) + i3) - ((int) ((f4 * 1) / 1.45d));
        layoutParams.topMargin = mi.f(TbadkCoreApplication.getInst(), R.dimen.M_H_X006);
        fr7Var.j(f3);
        fr7Var.i(layoutParams);
        fr7Var.h(false);
        fr7Var.l(true, this.c.getActivity().findViewById(16908290), 0, i4, this.J0.Q(), this.J0.m());
    }

    public final void r3() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048763, this) == null) || (pbFragment = this.c) == null || pbFragment.getActivity() == null) {
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
            int f3 = mi.f(this.c.getActivity(), R.dimen.tbds166);
            int i3 = ((rect2.right + rect2.left) / 2) - f3;
            int i4 = (rect.bottom - ((rect2.bottom + rect2.top) / 2)) - f3;
            int i5 = f3 * 2;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i5, i5);
            layoutParams.addRule(12, -1);
            layoutParams.setMargins(i3, 0, 0, i4);
            this.d.addView(this.v0, layoutParams);
            TextView textView = this.C0;
            if (textView != null) {
                textView.setVisibility(4);
                return;
            }
            return;
        }
        BdLog.e("AgreeView not measured");
    }

    public void s0(int i3, boolean z2, String str, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048764, this, new Object[]{Integer.valueOf(i3), Boolean.valueOf(z2), str, Boolean.valueOf(z3)}) == null) {
            this.c.hideProgressBar();
            if (z2 && z3) {
                PbFragment pbFragment = this.c;
                pbFragment.showToast(pbFragment.getPageContext().getString(R.string.obfuscated_res_0x7f0f1217));
            } else if (z3) {
                if (li.isEmpty(str)) {
                    str = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0c2d);
                }
                this.c.showToast(str);
            }
        }
    }

    public void s1() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048765, this) == null) || (editorTools = this.k0) == null) {
            return;
        }
        editorTools.q();
    }

    public void s2(vz4 vz4Var, int i3) {
        FallingView fallingView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048766, this, vz4Var, i3) == null) || (fallingView = this.I1) == null) {
            return;
        }
        fallingView.D(vz4Var, this.c.getPageContext(), i3, false);
    }

    public void s3(View view2) {
        AbsPbActivity w2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048767, this, view2) == null) || (w2 = this.c.w()) == null || w2.isFinishing()) {
            return;
        }
        oz5 oz5Var = new oz5(this.c.getPageContext(), view2);
        oz5Var.g0(R.drawable.obfuscated_res_0x7f0802eb);
        oz5Var.O(48);
        oz5Var.U(true);
        oz5Var.L(2);
        oz5Var.h0(true);
        oz5Var.k0(mi.f(w2, R.dimen.tbds21));
        oz5Var.j0(mi.f(w2, R.dimen.tbds128));
        oz5Var.d0(w2.getResources().getDimensionPixelSize(R.dimen.tbds20));
        oz5Var.a0(w2.getResources().getDimensionPixelSize(R.dimen.tbds38));
        oz5Var.N(3000);
        oz5Var.n0(w2.getString(R.string.obfuscated_res_0x7f0f0dc5), "pb_bottom_agree_tip_guide_key", true);
    }

    public void t0() {
        PbLandscapeListView pbLandscapeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048768, this) == null) || (pbLandscapeListView = this.l) == null) {
            return;
        }
        pbLandscapeListView.setForbidDragListener(true);
    }

    public final void t1() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048769, this) == null) && this.x == null && (pbFragment = this.c) != null) {
            this.x = new rw7(pbFragment.getContext());
        }
    }

    public final void t2(PbReplyTitleViewHolder pbReplyTitleViewHolder, boolean z2) {
        int measuredHeight;
        int i3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048770, this, pbReplyTitleViewHolder, z2) == null) || this.j1 || this.S0 == null || this.h.p() == null) {
            return;
        }
        View r2 = w0().r();
        if (r2 != null) {
            int[] iArr = new int[2];
            r2.getLocationInWindow(iArr);
            int i4 = iArr[1];
            if (i4 != 0) {
                if (this.S0.getVisibility() == 0 && i4 - this.h.p().getBottom() <= this.S0.getHeight()) {
                    this.T0.setVisibility(0);
                    if (i4 > this.h.p().getBottom()) {
                        i3 = -(((this.S0.getHeight() + this.T0.getHeight()) + this.h.p().getBottom()) - r2.getBottom());
                    } else {
                        i3 = -this.S0.getHeight();
                    }
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.S0.getLayoutParams();
                    if (layoutParams.topMargin != i3) {
                        layoutParams.topMargin = i3;
                        this.S0.setLayoutParams(layoutParams);
                    }
                } else {
                    this.T0.setVisibility(4);
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.S0.getLayoutParams();
                    if (layoutParams2.topMargin != 0) {
                        layoutParams2.topMargin = 0;
                        this.S0.setLayoutParams(layoutParams2);
                    }
                }
            }
        }
        int H = this.C.H();
        if (H > 0 && (pbReplyTitleViewHolder == null || pbReplyTitleViewHolder.b().getParent() == null)) {
            if (H > this.l.getFirstVisiblePosition() - this.l.getHeaderViewsCount()) {
                this.S0.setVisibility(4);
                return;
            }
            this.S0.setVisibility(0);
            x3(false);
            this.h.a.hideBottomLine();
            if (this.S0.getParent() == null || ((ViewGroup) this.S0.getParent()).getHeight() > this.S0.getTop()) {
                return;
            }
            this.S0.getParent().requestLayout();
        } else if (pbReplyTitleViewHolder != null && pbReplyTitleViewHolder.b() != null && pbReplyTitleViewHolder.g != null) {
            int top = pbReplyTitleViewHolder.b().getTop();
            if (pbReplyTitleViewHolder.b().getParent() != null) {
                if (this.Y0) {
                    this.X0 = top;
                    this.Y0 = false;
                }
                int i5 = this.X0;
                if (top < i5) {
                    i5 = top;
                }
                this.X0 = i5;
            }
            if (top != 0 || pbReplyTitleViewHolder.b().isShown()) {
                if (this.B.getY() < 0.0f) {
                    measuredHeight = d2 - pbReplyTitleViewHolder.g.getMeasuredHeight();
                } else {
                    measuredHeight = this.h.p().getMeasuredHeight() - pbReplyTitleViewHolder.g.getMeasuredHeight();
                    this.h.a.hideBottomLine();
                }
                if (pbReplyTitleViewHolder.b().getParent() == null && top <= this.X0) {
                    this.S0.setVisibility(0);
                    x3(false);
                } else if (top < measuredHeight) {
                    this.S0.setVisibility(0);
                    x3(false);
                } else {
                    this.S0.setVisibility(4);
                    this.h.a.hideBottomLine();
                }
                if (z2) {
                    this.Y0 = true;
                }
            }
        } else if (this.l.getFirstVisiblePosition() == 0) {
            this.S0.setVisibility(4);
            this.h.a.hideBottomLine();
        }
    }

    public void t3() {
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048771, this) == null) {
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView != null) {
                pbLandscapeListView.setVisibility(0);
            }
            FrameLayout frameLayout = this.Q0;
            if (frameLayout != null) {
                frameLayout.setVisibility(0);
            }
            ay7 ay7Var = this.h;
            if (ay7Var == null || (view2 = ay7Var.d) == null) {
                return;
            }
            view2.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
        }
    }

    public final String u0(long j3) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048772, this, j3)) == null) {
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

    public final void u1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048773, this) == null) && this.t == null) {
            this.t = new uw7(this.c, this.i0);
        }
    }

    public final void u2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048774, this) == null) {
            this.u.w(this.J0, this.K0, this.k1, this.j1);
        }
    }

    public void u3() {
        xw7 xw7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048775, this) == null) || (xw7Var = this.r) == null) {
            return;
        }
        xw7Var.u(this.l);
    }

    public final String v0(int i3) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048776, this, i3)) == null) {
            if (i3 == 0) {
                return this.c.getString(R.string.obfuscated_res_0x7f0f0db1);
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

    public final void v1(bs7 bs7Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048777, this, bs7Var) == null) && bs7Var != null && bs7Var.O() != null && bs7Var.O().isInterviewLive() && this.P0 == null) {
            PbInterviewStatusView pbInterviewStatusView = (PbInterviewStatusView) this.O0.inflate();
            this.P0 = pbInterviewStatusView;
            pbInterviewStatusView.setOnClickListener(this.N);
            this.P0.setCallback(this.c.C4());
            this.P0.setData(this.c, bs7Var);
        }
    }

    public void v2() {
        PbLandscapeListView pbLandscapeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048778, this) == null) || (pbLandscapeListView = this.l) == null) {
            return;
        }
        int headerViewsCount = pbLandscapeListView.getHeaderViewsCount() - this.i1;
        int firstVisiblePosition = (this.l.getFirstVisiblePosition() == 0 || this.l.getFirstVisiblePosition() + headerViewsCount < 0) ? 0 : this.l.getFirstVisiblePosition() + headerViewsCount;
        View childAt = this.l.getChildAt(0);
        int top = childAt != null ? childAt.getTop() : -1;
        this.Z0.c = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.Z0));
        PbReplyTitleViewHolder pbReplyTitleViewHolder = this.Z0.c;
        int b1 = b1(pbReplyTitleViewHolder);
        int measuredHeight = this.B.getMeasuredHeight() + ((int) this.B.getY());
        boolean z2 = this.S0.getVisibility() == 0;
        boolean z3 = this.B.getY() < 0.0f;
        if ((z2 && pbReplyTitleViewHolder != null) || firstVisiblePosition >= this.C.H() + this.l.getHeaderViewsCount()) {
            int measuredHeight2 = pbReplyTitleViewHolder != null ? pbReplyTitleViewHolder.g.getMeasuredHeight() : 0;
            if (z3) {
                this.l.setSelectionFromTop(this.C.H() + this.l.getHeaderViewsCount(), d2 - measuredHeight2);
            } else {
                this.l.setSelectionFromTop(this.C.H() + this.l.getHeaderViewsCount(), this.h.p().getMeasuredHeight() - measuredHeight2);
            }
        } else {
            this.l.setSelectionFromTop(firstVisiblePosition, top);
        }
        if (this.j1 && this.r != null) {
            this.l.setSelectionFromTop(this.C.H() + this.l.getHeaderViewsCount(), this.r.d());
        } else if (this.L0 != 6) {
        } else {
            this.l.setOnLayoutListener(new a(this, b1, pbReplyTitleViewHolder, z2, measuredHeight, firstVisiblePosition, top));
        }
    }

    public final void v3(SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048779, this, sparseArray) == null) || this.c == null) {
            return;
        }
        if (sparseArray != null) {
            sparseArray.put(R.id.obfuscated_res_0x7f091ec4, Boolean.TRUE);
        }
        TBAlertConfig.a aVar = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f1175, TBAlertConfig.OperateBtnStyle.MAIN);
        TBAlertConfig.a aVar2 = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f0374, TBAlertConfig.OperateBtnStyle.SECONDARY);
        bs4 bs4Var = new bs4(this.c.w());
        bs4Var.v(R.string.obfuscated_res_0x7f0f0b21);
        bs4Var.l(R.string.obfuscated_res_0x7f0f0b22);
        bs4Var.n(true);
        bs4Var.r(aVar2, aVar);
        bs4Var.i(false);
        AlertDialog y2 = bs4Var.y();
        aVar.a(new s(this, y2, sparseArray));
        aVar2.a(new t(this, y2));
    }

    public pu7 w0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048780, this)) == null) ? this.C : (pu7) invokeV.objValue;
    }

    public final void w1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048781, this) == null) && this.c.E4()) {
            ViewStub viewStub = (ViewStub) this.d.findViewById(R.id.obfuscated_res_0x7f091398);
            this.k = viewStub;
            viewStub.setVisibility(0);
            if (this.y == null) {
                this.y = (LinearLayout) this.d.findViewById(R.id.obfuscated_res_0x7f091397);
                w95.a(this.c.getPageContext(), this.y);
            }
            if (this.z == null) {
                this.z = (TextView) this.y.findViewById(R.id.obfuscated_res_0x7f09139c);
            }
            if (this.A == null) {
                this.A = (TextView) this.y.findViewById(R.id.obfuscated_res_0x7f09139b);
            }
            this.z.setOnClickListener(this.N);
            this.A.setOnClickListener(this.N);
        }
    }

    public final void w2(AgreeData agreeData, long j3) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLJ(1048782, this, agreeData, j3) == null) || agreeData == null) {
            return;
        }
        if ((UbsABTestHelper.isLikeModifyTestA() || UbsABTestHelper.isShowLikeAnimation()) && (textView = this.C0) != null) {
            if (j3 > 0) {
                if (agreeData.agreeType == 2 && agreeData.hasAgree) {
                    textView.setTextColor(SkinManager.getColor(R.color.CAM_X0301));
                } else {
                    this.C0.setTextColor(SkinManager.getColor(R.color.CAM_X0107));
                }
                this.C0.setText(u0(j3));
                this.C0.setVisibility(0);
                return;
            }
            textView.setVisibility(8);
        }
    }

    public final void w3(int i3, SparseArray<Object> sparseArray) {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048783, this, i3, sparseArray) == null) || (pbFragment = this.c) == null || pbFragment.v() == null || this.c.v().P1() == null || this.c.v().P1().o() == null || this.c.v().P1().l() == null || this.c.v().P1().l().getDeletedReasonInfo() == null) {
            return;
        }
        if (sparseArray != null) {
            sparseArray.put(R.id.obfuscated_res_0x7f091ec4, Boolean.TRUE);
        }
        ti5 ti5Var = new ti5(this.c.v().P1().l().getDeletedReasonInfo().is_grays_cale_forum.intValue(), this.c.v().P1().l().getDeletedReasonInfo().is_boomgrow.intValue(), this.c.v().P1().o().has_forum_rule.intValue());
        ti5Var.i(this.c.v().P1().l().getId(), this.c.v().P1().l().getName());
        ti5Var.h(this.c.v().P1().l().getImage_url());
        ti5Var.j(this.c.v().P1().l().getUser_level());
        H3(sparseArray, i3, ti5Var, this.c.v().P1().U(), true);
    }

    public LinearLayout x0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048784, this)) == null) ? this.s0 : (LinearLayout) invokeV.objValue;
    }

    public void x1() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048785, this) == null) || this.c == null || (editorTools = this.k0) == null) {
            return;
        }
        editorTools.j();
        if (this.c.M4() != null) {
            this.c.M4().P();
        }
        k1();
    }

    public final void x2(bs7 bs7Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048786, this, bs7Var) == null) || bs7Var == null || bs7Var.O() == null) {
            return;
        }
        f4(bs7Var);
        if (bs7Var.r()) {
            WebPManager.setPureDrawable(this.y0, R.drawable.obfuscated_res_0x7f080940, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
        } else {
            WebPManager.setPureDrawable(this.y0, R.drawable.obfuscated_res_0x7f08093f, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        }
        String v0 = v0(bs7Var.O().getReply_num());
        TextView textView = this.D0;
        if (textView != null) {
            textView.setText(v0);
        }
        TextView textView2 = this.E0;
        if (textView2 != null) {
            textView2.setText(v0);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921416, bs7Var.O()));
        w2(bs7Var.O().getAgreeData(), bs7Var.O().getAgreeNum());
        if (this.x0 == null || bs7Var.O() == null) {
            return;
        }
        this.x0.setThreadData(bs7Var.O());
        int i3 = 1;
        if (bs7Var.O().getAgreeData() != null) {
            bs7Var.O().getAgreeData().isInThread = true;
        }
        this.x0.setData(bs7Var.O().getAgreeData());
        fo4 fo4Var = new fo4();
        fo4Var.b = 26;
        if (bs7Var.O().isVideoThreadType() && bs7Var.O().getThreadVideoInfo() != null) {
            i3 = 2;
        }
        fo4Var.c = i3;
        PbFragment pbFragment = this.c;
        if (pbFragment != null && pbFragment.v() != null) {
            fo4Var.j = this.c.v().getFromForumId();
            fo4Var.f = this.c.v().O1();
        }
        this.x0.setStatisticData(fo4Var);
    }

    public void x3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048787, this, z2) == null) {
            this.m0.setVisibility(z2 ? 0 : 8);
        }
    }

    public View y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048788, this)) == null) {
            View view2 = this.V;
            if (view2 != null) {
                return view2.findViewById(R.id.obfuscated_res_0x7f09079f);
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    public final void y1(bs7 bs7Var, xw4 xw4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048789, this, bs7Var, xw4Var) == null) || this.K1 == null || bs7Var == null || xw4Var == null || this.c.getContext() == null) {
            return;
        }
        if (!RightFloatLayerView.k()) {
            r1();
            return;
        }
        if (this.J1 == null) {
            this.J1 = RightFloatLayerLottieView.F(xw4Var, this.c.getContext());
            this.K1.removeAllViews();
            this.K1.addView(this.J1);
        }
        if ((this.I1.getTag() instanceof Boolean) && !((Boolean) this.I1.getTag()).booleanValue()) {
            this.J1.setAutoCompleteShown(false);
            this.J1.setTag(this.I1);
            this.J1.c();
        }
        if (xw4Var.a()) {
            return;
        }
        this.J1.setData(xw4Var);
        this.J1.setLogoListener(new g0(this, xw4Var));
        this.J1.setFeedBackListener(new n0(this, xw4Var));
    }

    public void y2(int i3, bs7 bs7Var, boolean z2, int i4) {
        PostData E0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048790, this, new Object[]{Integer.valueOf(i3), bs7Var, Boolean.valueOf(z2), Integer.valueOf(i4)}) == null) || i3 <= 0 || (E0 = E0(bs7Var, z2)) == null || E0.s() == null) {
            return;
        }
        MetaData s2 = E0.s();
        s2.setGiftNum(s2.getGiftNum() + i3);
    }

    public void y3(boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048791, this, z2) == null) || this.r0 == null) {
            return;
        }
        O2(this.c.M4().C());
        if (this.l0) {
            C3(z2);
        } else {
            l1(z2);
        }
    }

    public String z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048792, this)) == null) ? this.a0 : (String) invokeV.objValue;
    }

    public void z1(bs7 bs7Var) {
        xw4 pbAdFloatViewItemData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048793, this, bs7Var) == null) || bs7Var == null) {
            return;
        }
        if (bs7Var.k0()) {
            pbAdFloatViewItemData = bs7Var.Z();
        } else {
            pbAdFloatViewItemData = TbSingleton.getInstance().getPbAdFloatViewItemData();
        }
        if (pbAdFloatViewItemData != null && !pbAdFloatViewItemData.a()) {
            y1(bs7Var, pbAdFloatViewItemData);
        } else {
            r1();
        }
    }

    public void z2(bs7 bs7Var, boolean z2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048794, this, new Object[]{bs7Var, Boolean.valueOf(z2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            K3(bs7Var, z2, i3, i4);
            this.u.u(i4);
        }
    }

    public void z3(bs7 bs7Var) {
        PostData postData;
        ay7 ay7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048795, this, bs7Var) == null) || bs7Var == null || (postData = this.K0) == null || postData.s() == null || (ay7Var = this.h) == null) {
            return;
        }
        boolean z2 = !this.j1;
        this.k1 = z2;
        ay7Var.G(z2);
        if (this.c.N4() != null) {
            this.c.N4().s(this.k1);
        }
        u2();
        PbFragment pbFragment = this.c;
        if (pbFragment != null && !pbFragment.isSimpleForum() && !ListUtils.isEmpty(bs7Var.p())) {
            yq4 yq4Var = bs7Var.p().get(0);
            if (yq4Var != null) {
                this.h.K(bs7Var, yq4Var.a(), yq4Var.b(), yq4Var.d(), yq4Var.getIsLike());
            }
        } else if (bs7Var.l() != null) {
            this.h.K(bs7Var, bs7Var.l().getName(), bs7Var.l().getId(), bs7Var.l().getImage_url(), bs7Var.l().isLike() == 1);
        }
        if (this.k1) {
            this.u.G(bs7Var, this.K0, this.f0);
            View view2 = this.U0;
            if (view2 != null) {
                view2.setVisibility(8);
            }
            if (this.t1 == null) {
                this.t1 = new h0(this);
            }
            this.l.setListViewDragListener(this.t1);
            return;
        }
        View view3 = this.U0;
        if (view3 != null) {
            view3.setVisibility(0);
        }
        this.u.G(bs7Var, this.K0, this.f0);
        this.t1 = null;
        this.l.setListViewDragListener(null);
    }
}

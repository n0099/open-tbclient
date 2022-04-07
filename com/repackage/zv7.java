package com.repackage;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Configuration;
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
import androidx.annotation.StringRes;
import androidx.appcompat.app.AlertDialog;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
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
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.bi5;
import com.repackage.dr4;
import com.repackage.du4;
import com.repackage.fr4;
import com.repackage.gk8;
import com.repackage.lw7;
import com.repackage.or4;
import com.repackage.us7;
import com.repackage.yh5;
import com.repackage.yu7;
import java.math.RoundingMode;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes7.dex */
public class zv7 {
    public static /* synthetic */ Interceptable $ic;
    public static final int a2;
    public static int b2;
    public static int c2;
    public static int d2;
    public static int e2;
    public static int f2;
    public static int g2;
    public static final int h2;
    public static gk8.f i2;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView A;
    public TextView A0;
    public int A1;
    public ObservedChangeRelativeLayout B;
    public TextView B0;
    public int B1;
    public ju7 C;
    public boolean C0;
    public boolean C1;
    public dr4 D;
    public int D0;
    public f08 D1;
    public fr4 E;
    public yt4 E0;
    public MaskView E1;
    public View F;
    public boolean F0;
    public final FallingView F1;
    public EditText G;
    public yr7 G0;
    public RightFloatLayerView G1;
    public h08 H;
    public PostData H0;
    public final FrameLayout H1;
    public PbListView I;
    public int I0;
    public boolean I1;
    public d08 J;
    public int J0;
    public String J1;
    public View K;
    public boolean K0;
    public CustomMessageListener K1;
    public View L;
    public ViewStub L0;
    public CustomMessageListener L1;
    public View M;
    public PbInterviewStatusView M0;
    public Handler M1;
    public View.OnClickListener N;
    public FrameLayout N0;
    public Runnable N1;
    public TbRichTextView.y O;
    public TextView O0;
    public CustomMessageListener O1;
    public NoNetworkView.b P;
    public View P0;
    public PbFragment.d3 P1;
    public mr4 Q;
    public View Q0;
    public boolean Q1;
    public View.OnClickListener R;
    public View R0;
    public View.OnClickListener R1;
    public dr4 S;
    public PbReplyTitleViewHolder S0;
    public boolean S1;
    public Dialog T;
    public View T0;
    public String T1;
    public Dialog U;
    public int U0;
    public du4.g U1;
    public View V;
    public boolean V0;
    public View.OnClickListener V1;
    public LinearLayout W;
    public q0 W0;
    public final List<TbImageView> W1;
    public CompoundButton.OnCheckedChangeListener X;
    public PbEmotionBar X0;
    public int X1;
    public TextView Y;
    public int Y0;
    public boolean Y1;
    public TextView Z;
    public int Z0;
    public boolean Z1;
    public final ViewTreeObserver.OnGlobalLayoutListener a;
    public String a0;
    public Runnable a1;
    public int b;
    public mr4 b0;
    public PbFakeFloorModel b1;
    public PbFragment c;
    public mr4 c0;
    public vu7 c1;
    public RelativeLayout d;
    public hr4 d0;
    public uv7 d1;
    public View e;
    public boolean e0;
    public boolean e1;
    public int f;
    public boolean f0;
    public int f1;
    public final Handler g;
    public String g0;
    public boolean g1;
    public final wx7 h;
    public String h0;
    public boolean h1;
    public vx7 i;
    public ws7 i0;
    public boolean i1;
    public ViewStub j;
    public ScrollView j0;
    public int j1;
    public ViewStub k;
    public EditorTools k0;
    public PbTopTipView k1;
    public PbLandscapeListView l;
    public boolean l0;
    public PopupWindow l1;
    public NoNetworkView m;
    public View m0;
    public TextView m1;
    public List<CustomBlueCheckRadioButton> n;
    public View n0;
    public List<String> n1;
    public PbThreadPostView o;
    public Button o0;
    public xw7 o1;
    public zu7 p;
    public View p0;
    public ut7 p1;
    public yu7 q;
    public View q0;
    public PbLandscapeListView.c q1;
    public rw7 r;
    public LinearLayout r0;
    public boolean r1;
    public mw7 s;
    public HeadImageView s0;
    public mv7 s1;
    public ow7 t;
    public TextView t0;
    public NavigationBarCoverTip t1;
    public qw7 u;
    public ImageView u0;
    public yh5 u1;
    public nw7 v;
    public AgreeView v0;
    public bi5 v1;
    public pw7 w;
    public ImageView w0;
    public String w1;
    public lw7 x;
    public ImageView x0;
    public PermissionJudgePolicy x1;
    public LinearLayout y;
    public g08 y0;
    public long y1;
    public TextView z;
    public TextView z0;
    public boolean z1;

    /* loaded from: classes7.dex */
    public class a implements PbLandscapeListView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ PbReplyTitleViewHolder b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ int d;
        public final /* synthetic */ int e;
        public final /* synthetic */ int f;
        public final /* synthetic */ zv7 g;

        /* renamed from: com.repackage.zv7$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class RunnableC0574a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public RunnableC0574a(a aVar) {
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
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.g.T0 == null || this.a.g.T0.getLayoutParams() == null) {
                    return;
                }
                ViewGroup.LayoutParams layoutParams = this.a.g.T0.getLayoutParams();
                layoutParams.height = this.a.g.Z0;
                this.a.g.T0.setLayoutParams(layoutParams);
            }
        }

        public a(zv7 zv7Var, int i, PbReplyTitleViewHolder pbReplyTitleViewHolder, boolean z, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zv7Var, Integer.valueOf(i), pbReplyTitleViewHolder, Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = zv7Var;
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
                    int W0 = this.g.W0(this.b);
                    int i3 = this.a;
                    int i4 = W0 - i3;
                    if (this.c && i4 != 0 && i3 <= (i = this.d)) {
                        i4 = W0 - i;
                    }
                    if (this.g.T0 == null || (layoutParams = this.g.T0.getLayoutParams()) == null) {
                        return;
                    }
                    if (i4 == 0 || i4 > this.g.d.getMeasuredHeight() || W0 >= this.g.d.getMeasuredHeight()) {
                        layoutParams.height = this.g.Z0;
                    } else {
                        if (layoutParams != null) {
                            int i5 = layoutParams.height;
                            if (i5 + i4 > 0 && i5 + i4 <= this.g.d.getMeasuredHeight()) {
                                layoutParams.height += i4;
                                this.g.l.setSelectionFromTop(this.e, this.f);
                            }
                        }
                        layoutParams.height = this.g.Z0;
                    }
                    this.g.T0.setLayoutParams(layoutParams);
                    pg.a().post(new RunnableC0574a(this));
                }
                this.g.l.setOnLayoutListener(null);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class a0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zv7 a;

        public a0(zv7 zv7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zv7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zv7Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            zv7 zv7Var;
            wx7 wx7Var;
            LinearLayout linearLayout;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.C == null || (wx7Var = (zv7Var = this.a).h) == null || wx7Var.i == null || zv7Var.G0 == null || this.a.G0.O() == null || this.a.G0.O().isVideoThreadType() || this.a.H1() || this.a.G0.l() == null || ni.isEmpty(this.a.G0.l().getName())) {
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

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zv7 a;

        public b(zv7 zv7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zv7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zv7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            SparseArray<Object> sparseArray;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || (sparseArray = (SparseArray) view2.getTag()) == null) {
                return;
            }
            boolean booleanValue = sparseArray.get(R.id.obfuscated_res_0x7f091e97) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091e97)).booleanValue() : false;
            boolean booleanValue2 = sparseArray.get(R.id.obfuscated_res_0x7f091eaa) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091eaa)).booleanValue() : false;
            boolean booleanValue3 = sparseArray.get(R.id.obfuscated_res_0x7f091e95) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091e95)).booleanValue() : false;
            if (booleanValue) {
                if (booleanValue2) {
                    sparseArray.put(R.id.obfuscated_res_0x7f091e68, 1);
                    this.a.c.c4(sparseArray);
                    return;
                }
                this.a.k2(view2);
            } else if (booleanValue2) {
                sparseArray.put(R.id.obfuscated_res_0x7f091e68, 0);
                sparseArray.put(R.id.obfuscated_res_0x7f091e51, 1);
                this.a.c.c4(sparseArray);
            } else if (booleanValue3) {
                this.a.f2(((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091e59)).intValue(), (String) sparseArray.get(R.id.obfuscated_res_0x7f091e57), ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091e74)).intValue(), ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091e58)).booleanValue());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ zv7 b;

        public b0(zv7 zv7Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zv7Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = zv7Var;
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
                this.b.c.showToast(R.string.obfuscated_res_0x7f0f0c18);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zv7 a;

        public c(zv7 zv7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zv7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zv7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.y2();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Parcelable a;
        public final /* synthetic */ ArrayList b;
        public final /* synthetic */ yr7 c;
        public final /* synthetic */ zv7 d;

        public c0(zv7 zv7Var, Parcelable parcelable, ArrayList arrayList, yr7 yr7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zv7Var, parcelable, arrayList, yr7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = zv7Var;
            this.a = parcelable;
            this.b = arrayList;
            this.c = yr7Var;
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
                this.d.I.C(this.d.c.getString(R.string.obfuscated_res_0x7f0f0dab));
                this.d.I.x();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements PbFakeFloorModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zv7 a;

        public d(zv7 zv7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zv7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zv7Var;
        }

        @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.b
        public void a(PostData postData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, postData) == null) {
                this.a.b1.P(postData);
                this.a.C.Z();
                this.a.c1.c();
                this.a.k0.q();
                this.a.o3(false);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d0 implements PbLandscapeListView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zv7 a;

        public d0(zv7 zv7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zv7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zv7Var;
        }

        @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.c
        public void a(int i, int i2, float f, float f2, float f3, float f4) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)}) == null) && this.a.c != null && this.a.c.isAdded()) {
                if (i < 0 && f > this.a.j1) {
                    this.a.f0();
                    this.a.Y1();
                }
                this.a.m0();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements FallingView.m {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zv7 a;

        public e(zv7 zv7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zv7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zv7Var;
        }

        @Override // com.baidu.tieba.pb.view.FallingView.m
        public void onAnimationEnd() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.I3();
            }
        }

        @Override // com.baidu.tieba.pb.view.FallingView.m
        public void onAnimationStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.F1.setTag(Boolean.FALSE);
                if (this.a.G1 == null) {
                    return;
                }
                this.a.G1.setAutoCompleteShown(false);
                if (this.a.G1.getVisibility() == 0) {
                    this.a.G1.setTag(this.a.F1);
                    this.a.G1.c();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lw4 a;
        public final /* synthetic */ zv7 b;

        public e0(zv7 zv7Var, lw4 lw4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zv7Var, lw4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = zv7Var;
            this.a = lw4Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a == null || this.b.G0 == null || this.b.G1 == null) {
                return;
            }
            this.b.G1.g(this.a);
            this.b.G1.setAutoCompleteShown(false);
        }
    }

    /* loaded from: classes7.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zv7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(zv7 zv7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zv7Var, Integer.valueOf(i)};
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
            this.a = zv7Var;
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

    /* loaded from: classes7.dex */
    public class f0 implements dr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zv7 a;

        public f0(zv7 zv7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zv7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zv7Var;
        }

        @Override // com.repackage.dr4.e
        public void onClick(dr4 dr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dr4Var) == null) {
                this.a.f0();
                dr4Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zv7 a;

        public g(zv7 zv7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zv7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zv7Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.y == null) {
                    this.a.r1();
                }
                this.a.k.setVisibility(0);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g0 implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zv7 a;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ g0 a;

            public a(g0 g0Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {g0Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = g0Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.a.c.HidenSoftKeyPad((InputMethodManager) this.a.a.c.getBaseFragmentActivity().getSystemService("input_method"), this.a.a.d);
                }
            }
        }

        public g0(zv7 zv7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zv7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zv7Var;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                if (this.a.a1 == null) {
                    this.a.a1 = new a(this);
                }
                pg.a().postDelayed(this.a.a1, 150L);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zv7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(zv7 zv7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zv7Var, Integer.valueOf(i)};
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
            this.a = zv7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            this.a.C0 = false;
        }
    }

    /* loaded from: classes7.dex */
    public class h0 implements dr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public h0(zv7 zv7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zv7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.dr4.e
        public void onClick(dr4 dr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dr4Var) == null) {
                dr4Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zv7 a;

        public i(zv7 zv7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zv7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zv7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.y2();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i0 implements dr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public i0(zv7 zv7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zv7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.dr4.e
        public void onClick(dr4 dr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dr4Var) == null) {
                dr4Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j implements j05 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zv7 a;

        public j(zv7 zv7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zv7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zv7Var;
        }

        @Override // com.repackage.j05
        public void onAction(i05 i05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, i05Var) == null) {
                Object obj = i05Var.c;
                if (obj instanceof ax4) {
                    if (((ax4) obj).getType() == EmotionGroupType.BIG_EMOTION || ((ax4) i05Var.c).getType() == EmotionGroupType.USER_COLLECT) {
                        if (this.a.x1 == null) {
                            this.a.x1 = new PermissionJudgePolicy();
                        }
                        this.a.x1.clearRequestPermissionList();
                        this.a.x1.appendRequestPermission(this.a.c.getBaseFragmentActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (this.a.x1.startRequestPermission(this.a.c.getBaseFragmentActivity())) {
                            return;
                        }
                        this.a.c.L4().h((ax4) i05Var.c);
                        this.a.c.L4().z(false, null);
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;
        public final /* synthetic */ View d;
        public final /* synthetic */ zv7 e;

        public j0(zv7 zv7Var, int i, int i2, int i3, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zv7Var, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = zv7Var;
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
                    this.e.l1.showAsDropDown(this.e.q0, this.d.getLeft(), -this.e.q0.getHeight());
                } else {
                    this.e.l1.showAsDropDown(this.d);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class k implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zv7 a;

        public k(zv7 zv7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zv7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zv7Var;
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
            if (this.a.o1 == null) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(11);
                layoutParams.addRule(2, this.a.k0.getId());
                zv7 zv7Var = this.a;
                zv7Var.o1 = new xw7(zv7Var.c.getPageContext(), this.a.d, layoutParams);
                if (!ListUtils.isEmpty(this.a.n1)) {
                    this.a.o1.q(this.a.n1);
                }
                this.a.o1.r(this.a.k0);
            }
            this.a.o1.p(substring);
        }
    }

    /* loaded from: classes7.dex */
    public class k0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lw4 a;
        public final /* synthetic */ zv7 b;

        public k0(zv7 zv7Var, lw4 lw4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zv7Var, lw4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = zv7Var;
            this.a = lw4Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921664));
                this.b.G1.setHomePbFloatLastCloseTime();
                this.b.m1();
                this.b.G1.u(this.a);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class l implements or4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ zv7 b;

        public l(zv7 zv7Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zv7Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = zv7Var;
            this.a = z;
        }

        @Override // com.repackage.or4.e
        public void onItemClick(or4 or4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, or4Var, i, view2) == null) {
                this.b.Q.dismiss();
                SparseArray<Object> sparseArray = (SparseArray) view2.getTag();
                if (sparseArray == null) {
                    return;
                }
                switch (i) {
                    case 10:
                        this.b.f2(((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091e59)).intValue(), (String) sparseArray.get(R.id.obfuscated_res_0x7f091e57), ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091e74)).intValue(), ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091e58)).booleanValue());
                        return;
                    case 11:
                        if (this.b.P1 != null) {
                            this.b.P1.a(new Object[]{sparseArray.get(R.id.obfuscated_res_0x7f091e74), sparseArray.get(R.id.obfuscated_res_0x7f091e62), sparseArray.get(R.id.obfuscated_res_0x7f091e65), sparseArray.get(R.id.obfuscated_res_0x7f091e63), sparseArray.get(R.id.obfuscated_res_0x7f091e64)});
                            return;
                        }
                        return;
                    case 12:
                        this.b.c.X4(this.a, (String) sparseArray.get(R.id.obfuscated_res_0x7f091ea6), sparseArray);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class l0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zv7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l0(zv7 zv7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zv7Var, Integer.valueOf(i)};
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
            this.a = zv7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2921306) {
                this.a.J1 = null;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class m implements dr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public m(zv7 zv7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zv7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.dr4.e
        public void onClick(dr4 dr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dr4Var) == null) {
                dr4Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class m0 implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;
        public final /* synthetic */ zv7 b;

        public m0(zv7 zv7Var, PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zv7Var, pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = zv7Var;
            this.a = pbFragment;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.b.C1 || this.a == null || this.b.c.w() == null || !this.b.c.w().C1()) {
                return;
            }
            this.b.C1 = true;
            this.a.Z3(false);
        }
    }

    /* loaded from: classes7.dex */
    public class n implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlertDialog a;
        public final /* synthetic */ SparseArray b;
        public final /* synthetic */ zv7 c;

        public n(zv7 zv7Var, AlertDialog alertDialog, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zv7Var, alertDialog, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = zv7Var;
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
                    oi.M(this.c.c.x(), R.string.obfuscated_res_0x7f0f0c18);
                } else {
                    this.c.c.k4(this.b, null);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class n0 implements us7.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zv7 a;

        public n0(zv7 zv7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zv7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zv7Var;
        }

        @Override // com.repackage.us7.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.c.a5();
            }
        }

        @Override // com.repackage.us7.b
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

    /* loaded from: classes7.dex */
    public class o implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlertDialog a;

        public o(zv7 zv7Var, AlertDialog alertDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zv7Var, alertDialog};
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

    /* loaded from: classes7.dex */
    public class o0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zv7 a;

        public o0(zv7 zv7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zv7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zv7Var;
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

    /* loaded from: classes7.dex */
    public class p implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlertDialog a;
        public final /* synthetic */ SparseArray b;
        public final /* synthetic */ zv7 c;

        public p(zv7 zv7Var, AlertDialog alertDialog, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zv7Var, alertDialog, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = zv7Var;
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
                    oi.M(this.c.c.x(), R.string.obfuscated_res_0x7f0f0c18);
                } else {
                    this.c.c.k4(this.b, null);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class p0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zv7 a;

        public p0(zv7 zv7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zv7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zv7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.v0 == null || this.a.v0.getData() == null) {
                return;
            }
            zv7 zv7Var = this.a;
            zv7Var.p2(zv7Var.v0.getData(), this.a.v0.getData().agreeNum);
        }
    }

    /* loaded from: classes7.dex */
    public class q implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlertDialog a;

        public q(zv7 zv7Var, AlertDialog alertDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zv7Var, alertDialog};
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

    /* loaded from: classes7.dex */
    public static class q0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public int b;
        public PbReplyTitleViewHolder c;

        public q0() {
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

    /* loaded from: classes7.dex */
    public class r implements yh5.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dr4 a;
        public final /* synthetic */ zv7 b;

        public r(zv7 zv7Var, dr4 dr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zv7Var, dr4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = zv7Var;
            this.a = dr4Var;
        }

        @Override // com.repackage.yh5.g
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                this.b.c.l4(this.a, jSONArray);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class s implements bi5.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SparseArray a;
        public final /* synthetic */ zv7 b;

        public s(zv7 zv7Var, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zv7Var, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = zv7Var;
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

    /* loaded from: classes7.dex */
    public static class t implements gk8.f {
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

        @Override // com.repackage.gk8.f
        public void onRefresh() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public class u implements CompoundButton.OnCheckedChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zv7 a;

        public u(zv7 zv7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zv7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zv7Var;
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

    /* loaded from: classes7.dex */
    public class v implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zv7 a;

        public v(zv7 zv7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zv7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zv7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (this.a.U instanceof Dialog)) {
                rg.b(this.a.U, this.a.c.getPageContext());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class w implements or4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fr4.c a;
        public final /* synthetic */ zv7 b;

        public w(zv7 zv7Var, fr4.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zv7Var, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = zv7Var;
            this.a = cVar;
        }

        @Override // com.repackage.or4.e
        public void onItemClick(or4 or4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, or4Var, i, view2) == null) {
                this.b.c0.dismiss();
                this.a.a(null, i, view2);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class x implements or4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fr4.c a;
        public final /* synthetic */ zv7 b;

        public x(zv7 zv7Var, fr4.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zv7Var, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = zv7Var;
            this.a = cVar;
        }

        @Override // com.repackage.or4.e
        public void onItemClick(or4 or4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, or4Var, i, view2) == null) {
                this.b.c0.dismiss();
                this.a.a(null, i, view2);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class y implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zv7 a;

        public y(zv7 zv7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zv7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zv7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (!(view2 instanceof HeadImageView) || this.a.G0 == null || this.a.G0.O() == null || this.a.G0.O().getAuthor() == null || this.a.G0.O().getAuthor().getAlaInfo() == null || this.a.G0.O().getAuthor().getAlaInfo().live_status != 1) {
                    if (this.a.g1) {
                        TiebaStatic.log(new StatisticItem("c11923").param("obj_id", 2));
                    }
                    if (!this.a.g1 && this.a.G0 != null && this.a.G0.O() != null && this.a.G0.O().getAuthor() != null && this.a.G0.O().getAuthor().isBigV()) {
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
                statisticItem2.param("fid", this.a.G0.m());
                statisticItem2.param("fname", this.a.G0.n());
                statisticItem2.param("obj_param1", this.a.G0.O().getAuthor().getAlaInfo().user_info != null ? this.a.G0.O().getAuthor().getAlaInfo().user_info.user_id : 0L);
                statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem2.param("tid", this.a.G0.Q());
                statisticItem2.param(TiebaStatic.Params.OBJ_PARAM2, 1);
                statisticItem2.param(TiebaStatic.Params.OBJ_PARAM4, YYLiveUtil.calculateLiveType(this.a.G0.O().getAuthor().getAlaInfo()));
                if (this.a.G0.O().getAuthor().getAlaInfo().mYyExtData != null) {
                    statisticItem2.param(TiebaStatic.Params.OBJ_PARAM3, TiebaStatic.YYValues.YY_LIVE);
                    TiebaStaticHelper.addYYParam(statisticItem2, this.a.G0.O().getAuthor().getAlaInfo().mYyExtData);
                }
                TiebaStatic.log(statisticItem2);
                if (this.a.G0.O().getAuthor().getAlaInfo().isLegalYYLiveData()) {
                    YYLiveUtil.jumpYYLiveRoom(this.a.c.getPageContext(), this.a.G0.O().getAuthor().getAlaInfo(), YYLiveUtil.SOURCE_PB_LIVE_HEAD);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class z implements lw7.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zv7 a;

        public z(zv7 zv7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zv7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zv7Var;
        }

        @Override // com.repackage.lw7.a
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

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755098474, "Lcom/repackage/zv7;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755098474, "Lcom/repackage/zv7;");
                return;
            }
        }
        a2 = UtilHelper.getLightStatusBarHeight();
        b2 = 3;
        c2 = 0;
        d2 = 3;
        e2 = 4;
        f2 = 5;
        g2 = 6;
        h2 = oi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds80);
        i2 = new t();
    }

    public zv7(PbFragment pbFragment, View.OnClickListener onClickListener, ws7 ws7Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pbFragment, onClickListener, ws7Var};
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
        this.o0 = null;
        this.q0 = null;
        this.t0 = null;
        this.C0 = true;
        this.E0 = null;
        this.F0 = false;
        this.J0 = 3;
        this.K0 = false;
        this.L0 = null;
        this.U0 = 0;
        this.V0 = true;
        this.W0 = new q0();
        this.Y0 = 0;
        this.e1 = false;
        this.f1 = 0;
        this.g1 = false;
        this.h1 = false;
        this.i1 = false;
        this.j1 = 0;
        this.r1 = false;
        this.y1 = 0L;
        this.B1 = 0;
        this.K1 = new l0(this, 2921306);
        this.L1 = new f(this, 2005016);
        this.M1 = new Handler();
        this.O1 = new h(this, 2004009);
        this.Q1 = true;
        this.R1 = new y(this);
        this.S1 = false;
        this.T1 = null;
        this.W1 = new ArrayList();
        this.Y1 = false;
        this.y1 = System.currentTimeMillis();
        this.c = pbFragment;
        this.N = onClickListener;
        this.i0 = ws7Var;
        this.j1 = oi.k(pbFragment.getContext()) / 8;
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.c.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d05fb, (ViewGroup) null);
        this.d = relativeLayout;
        relativeLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.m0 = this.d.findViewById(R.id.obfuscated_res_0x7f0903e4);
        this.t1 = (NavigationBarCoverTip) this.d.findViewById(R.id.obfuscated_res_0x7f0916fd);
        this.e = this.d.findViewById(R.id.obfuscated_res_0x7f091d92);
        this.H1 = (FrameLayout) this.d.findViewById(R.id.obfuscated_res_0x7f091aa2);
        this.B = (ObservedChangeRelativeLayout) this.d.findViewById(R.id.obfuscated_res_0x7f092046);
        this.m = (NoNetworkView) this.d.findViewById(R.id.obfuscated_res_0x7f0923ad);
        this.l = (PbLandscapeListView) this.d.findViewById(R.id.obfuscated_res_0x7f09154c);
        this.N0 = (FrameLayout) this.d.findViewById(R.id.obfuscated_res_0x7f091ad1);
        this.O0 = new TextView(this.c.getActivity());
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + oi.f(this.c.getActivity(), R.dimen.obfuscated_res_0x7f070309));
        this.l.x(this.O0, 0);
        this.l.setTextViewAdded(true);
        this.Z0 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds134);
        this.T0 = new View(this.c.getPageContext().getPageActivity());
        if (qg5.d()) {
            this.T0.setLayoutParams(new AbsListView.LayoutParams(-1, 0));
        } else {
            this.T0.setLayoutParams(new AbsListView.LayoutParams(-1, this.Z0));
        }
        this.T0.setVisibility(4);
        this.l.addFooterView(this.T0);
        this.l.setOnTouchListener(this.c.D2);
        this.a = new m0(this, pbFragment);
        this.l.getViewTreeObserver().addOnGlobalLayoutListener(this.a);
        this.h = new wx7(pbFragment, this.d);
        if (this.c.D4()) {
            ViewStub viewStub = (ViewStub) this.d.findViewById(R.id.obfuscated_res_0x7f091389);
            this.j = viewStub;
            viewStub.setVisibility(0);
            vx7 vx7Var = new vx7(pbFragment);
            this.i = vx7Var;
            vx7Var.c();
            this.h.a.setVisibility(8);
            layoutParams.height = oi.f(this.c.getActivity(), R.dimen.obfuscated_res_0x7f07023f);
        }
        this.O0.setLayoutParams(layoutParams);
        this.h.p().setOnTouchListener(new us7(new n0(this)));
        this.p0 = this.d.findViewById(R.id.obfuscated_res_0x7f092393);
        this.q0 = this.d.findViewById(R.id.obfuscated_res_0x7f0916a0);
        oi.f(TbadkCoreApplication.getInst(), R.dimen.tbds120);
        this.D0 = oi.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f070287);
        HeadImageView headImageView = (HeadImageView) this.d.findViewById(R.id.obfuscated_res_0x7f0916a4);
        this.s0 = headImageView;
        headImageView.setVisibility(0);
        this.s0.setIsRound(true);
        this.s0.setBorderWidth(oi.f(this.c.getContext(), R.dimen.L_X01));
        this.s0.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
        this.s0.setPlaceHolder(0);
        P1();
        this.t0 = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f0916a3);
        LinearLayout linearLayout = (LinearLayout) this.d.findViewById(R.id.obfuscated_res_0x7f09169b);
        this.r0 = linearLayout;
        linearLayout.setOnClickListener(new o0(this));
        this.u0 = (ImageView) this.d.findViewById(R.id.obfuscated_res_0x7f0916a1);
        this.E1 = (MaskView) this.d.findViewById(R.id.obfuscated_res_0x7f0913aa);
        this.u0.setOnClickListener(this.N);
        AgreeView agreeView = (AgreeView) this.d.findViewById(R.id.obfuscated_res_0x7f09169d);
        this.v0 = agreeView;
        agreeView.setAgreeAlone(true);
        this.v0.m();
        this.v0.setAfterClickListener(new p0(this));
        if (UbsABTestHelper.isLikeModifyTestA()) {
            this.v0.setUseDynamicLikeRes("/pb");
        }
        if (this.v0.getAgreeNumView() != null) {
            this.v0.getAgreeNumView().setVisibility(8);
        }
        if (this.v0.getMsgData() != null) {
            this.v0.getMsgData().a = BdUniqueId.gen();
        }
        boolean booleanExtra = this.c.getBaseFragmentActivity().getIntent().getBooleanExtra("key_is_from_dynamic", false);
        ImageView imageView = (ImageView) this.d.findViewById(R.id.obfuscated_res_0x7f09169f);
        this.w0 = imageView;
        imageView.setOnClickListener(this.N);
        if (booleanExtra) {
            this.w0.setVisibility(8);
        } else {
            this.w0.setVisibility(0);
        }
        ImageView imageView2 = (ImageView) this.d.findViewById(R.id.obfuscated_res_0x7f0916a5);
        this.x0 = imageView2;
        imageView2.setOnClickListener(this.N);
        this.y0 = new g08(this.x0);
        if (!UbsABTestHelper.isResizeInduceSharingABTest() && !UbsABTestHelper.isResizeInduceSharingABTestA()) {
            this.y0.e();
        }
        TextView textView = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f0916a2);
        this.A0 = textView;
        textView.setVisibility(0);
        this.z0 = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f09169e);
        this.L0 = (ViewStub) this.d.findViewById(R.id.obfuscated_res_0x7f090f40);
        if (UbsABTestHelper.isLikeModifyTestA()) {
            this.v0.setVisibility(0);
            this.z0.setVisibility(0);
        }
        this.s = new mw7(this.c, ws7Var);
        this.u = new qw7(this.c, ws7Var, this.N);
        ju7 ju7Var = new ju7(this.c, this.l);
        this.C = ju7Var;
        ju7Var.v0(this.N);
        this.C.x0(this.i0);
        this.C.s0(this.O);
        this.C.u0(this.c.b2);
        this.C.p0(this.V1);
        b bVar = new b(this);
        this.R = bVar;
        this.C.r0(bVar);
        v1();
        p1();
        pw7 pw7Var = new pw7(this.c);
        this.w = pw7Var;
        pw7Var.f = 2;
        o1();
        this.x.a(this.l);
        this.t.a(this.l);
        this.u.j(this.l);
        this.s.a(this.l);
        PbListView pbListView = new PbListView(this.c.getPageContext().getPageActivity());
        this.I = pbListView;
        this.K = pbListView.b().findViewById(R.id.obfuscated_res_0x7f0916ed);
        this.L = this.I.b().findViewById(R.id.obfuscated_res_0x7f09168c);
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
        this.M = this.d.findViewById(R.id.obfuscated_res_0x7f0923c9);
        this.c.registerListener(this.O1);
        this.b1 = new PbFakeFloorModel(this.c.getPageContext());
        PbModel w2 = this.c.w();
        this.b1.R(w2.H(), w2.D(), w2.E(), w2.C(), w2.I());
        vu7 vu7Var = new vu7(this.c.getPageContext(), this.b1, this.d);
        this.c1 = vu7Var;
        vu7Var.k(new c(this));
        this.c1.n(this.c.f2);
        this.b1.T(new d(this));
        if (this.c.w() != null && !StringUtils.isNull(this.c.w().W0())) {
            PbFragment pbFragment2 = this.c;
            pbFragment2.showToast(pbFragment2.w().W0());
        }
        this.P0 = this.d.findViewById(R.id.obfuscated_res_0x7f0916a7);
        this.Q0 = this.d.findViewById(R.id.obfuscated_res_0x7f0903df);
        View findViewById = this.d.findViewById(R.id.obfuscated_res_0x7f091d9e);
        this.R0 = findViewById;
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
        if (this.c.w() != null && this.c.w().F0()) {
            this.P0.setVisibility(0);
            if (layoutParams2 != null) {
                layoutParams2.height = 0;
                this.R0.setLayoutParams(layoutParams2);
            }
        } else if (layoutParams2 != null) {
            layoutParams2.height = a2;
            this.R0.setLayoutParams(layoutParams2);
        }
        PbReplyTitleViewHolder pbReplyTitleViewHolder = new PbReplyTitleViewHolder(this.c.getPageContext(), this.d.findViewById(R.id.obfuscated_res_0x7f09171b));
        this.S0 = pbReplyTitleViewHolder;
        pbReplyTitleViewHolder.s(pbFragment.k0);
        this.S0.g.setVisibility(8);
        this.S0.r(this.N);
        this.S0.p(this.c.b2);
        this.c.registerListener(this.L1);
        this.c.registerListener(this.K1);
        PbFragment pbFragment3 = this.c;
        this.D1 = new f08(pbFragment3, pbFragment3.getUniqueId());
        this.F1 = (FallingView) this.d.findViewById(R.id.obfuscated_res_0x7f090974);
        E2();
        this.F1.setAnimationListener(new e(this));
        a0();
        x2(false);
        this.n0 = this.d.findViewById(R.id.obfuscated_res_0x7f091692);
        Z(qg5.d());
        if (UbsABTestHelper.isPbForumGuideTestA() && w2.G1() && dr7.b().e()) {
            if (this.p == null) {
                this.p = new zu7(this.c.getActivity(), (ViewGroup) d1().findViewById(R.id.obfuscated_res_0x7f0916c6));
            }
            yu7 yu7Var = new yu7(this.l);
            this.q = yu7Var;
            yu7Var.d(new yu7.a() { // from class: com.repackage.au7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.repackage.yu7.a
                public final void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        zv7.this.M1();
                    }
                }
            });
        }
    }

    public final int A0(int i3) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i3)) == null) {
            lo adapter2 = this.l.getAdapter2();
            if (adapter2 == null) {
                return i3;
            }
            if (i3 < adapter2.getCount() && i3 >= 0 && (adapter2.getItem(i3) instanceof vr7)) {
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

    public boolean A1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView == null) {
                return false;
            }
            return pbLandscapeListView.J();
        }
        return invokeV.booleanValue;
    }

    public void A2() {
        Handler handler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (handler = this.M1) == null) {
            return;
        }
        Runnable runnable = this.N1;
        if (runnable != null) {
            handler.removeCallbacks(runnable);
        }
        g gVar = new g(this);
        this.N1 = gVar;
        this.M1.postDelayed(gVar, 2000L);
    }

    @SuppressLint({"ResourceAsColor"})
    public final void A3(yr7 yr7Var, boolean z2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{yr7Var, Boolean.valueOf(z2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) || yr7Var == null || yr7Var.O() == null) {
            return;
        }
        if (this.c.isSimpleForum()) {
            if (yr7Var.h() != null) {
                this.g0 = yr7Var.h().a();
                this.h0 = yr7Var.h().b();
            }
            if (this.g0 == null && this.c.w() != null && this.c.w().s0() != null) {
                this.g0 = this.c.w().s0();
            }
        }
        PostData z0 = z0(yr7Var, z2);
        Z2(z0, yr7Var);
        this.u.B(8);
        if (yr7Var.r0()) {
            this.g1 = true;
            this.h.A(true);
            this.h.a.hideBottomLine();
            if (this.r == null) {
                this.r = new rw7(this.c);
            }
            this.r.v(yr7Var, z0, this.l, this.u, this.N0, this.h, this.g0, this.y1);
            this.r.s(this.R1);
            z2();
        } else {
            this.g1 = false;
            this.h.A(false);
            rw7 rw7Var = this.r;
            if (rw7Var != null) {
                rw7Var.p(this.l);
            }
        }
        if (this.c.M4() != null) {
            this.c.M4().w(this.g1);
        }
        if (z0 == null) {
            return;
        }
        this.H0 = z0;
        this.u.B(0);
        SparseArray<Object> q2 = this.u.q();
        q2.put(R.id.obfuscated_res_0x7f091e55, z0);
        q2.put(R.id.obfuscated_res_0x7f091e6e, Boolean.FALSE);
        this.v.e(yr7Var, this.l);
        this.x.e(yr7Var, this.A1, new z(this));
        this.t.f(yr7Var);
        this.s.h(yr7Var, this.F0);
        this.s.g(yr7Var);
        this.u.C(this.J0, this.G0, z0, this.R1);
        if (this.S0 != null) {
            if (yr7Var.g0()) {
                this.S0.b().setVisibility(8);
            } else {
                this.S0.b().setVisibility(0);
                ls7 ls7Var = new ls7(ls7.h);
                if (yr7Var.O() != null) {
                    yr7Var.O().getReply_num();
                }
                ls7Var.c = yr7Var.g;
                yr7Var.c();
                ls7Var.d = this.c.k5();
                ls7Var.g = yr7Var.f;
                this.S0.i(ls7Var);
            }
        }
        M3(yr7Var);
        pg.a().post(new a0(this));
        this.w.e(this.l);
        if (z0.Q) {
            this.w.f(z0.I());
            this.w.b(this.l, this.l.getHeaderViewsCount() <= 1 ? 0 : 1);
        }
        ju7 ju7Var = this.C;
        if (ju7Var != null && ju7Var.z() != null) {
            this.C.z().m0(z0.Q);
        }
        ju7 ju7Var2 = this.C;
        if (ju7Var2 != null) {
            ju7Var2.q0(z0.Q);
        }
        this.E1.setVisibility(z0.Q ? 0 : 8);
    }

    public Button B0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.o0 : (Button) invokeV.objValue;
    }

    public boolean B1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            EditorTools editorTools = this.k0;
            return editorTools != null && editorTools.getVisibility() == 0;
        }
        return invokeV.booleanValue;
    }

    public void B2(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, editorTools) == null) {
            this.k0 = editorTools;
            editorTools.setOnCancelClickListener(new i(this));
            this.k0.setId(R.id.obfuscated_res_0x7f09169c);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            if (this.k0.getParent() == null) {
                this.d.addView(this.k0, layoutParams);
            }
            this.k0.w(TbadkCoreApplication.getInst().getSkinType());
            this.k0.setActionListener(24, new j(this));
            h1();
            this.c.L4().i(new k(this));
        }
    }

    public void B3(fr4.c cVar, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048583, this, cVar, z2) == null) {
            mr4 mr4Var = this.c0;
            if (mr4Var != null) {
                mr4Var.dismiss();
                this.c0 = null;
            }
            or4 or4Var = new or4(this.c.getContext());
            ArrayList arrayList = new ArrayList();
            yr7 yr7Var = this.G0;
            if (yr7Var != null && yr7Var.O() != null && !this.G0.O().isBjh()) {
                arrayList.add(new kr4(0, this.c.getPageContext().getString(R.string.obfuscated_res_0x7f0f106f), or4Var));
            }
            if (!z2) {
                arrayList.add(new kr4(1, this.c.getPageContext().getString(R.string.obfuscated_res_0x7f0f1070), or4Var));
            }
            or4Var.j(arrayList);
            or4Var.n(new x(this, cVar));
            mr4 mr4Var2 = new mr4(this.c.getPageContext(), or4Var);
            this.c0 = mr4Var2;
            mr4Var2.m();
        }
    }

    public int C0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.l.getHeaderViewsCount() : invokeV.intValue;
    }

    public final boolean C1(PostData postData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, postData)) == null) {
            if (postData == null || postData.s() == null) {
                return false;
            }
            MetaData s2 = postData.s();
            return (TextUtils.isEmpty(s2.getUserId()) && TextUtils.isEmpty(s2.getAvater())) ? false : true;
        }
        return invokeL.booleanValue;
    }

    public void C2(String str) {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, str) == null) || (pbListView = this.I) == null) {
            return;
        }
        pbListView.C(str);
    }

    public void C3(fr4.c cVar, boolean z2, boolean z3, boolean z4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{cVar, Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4)}) == null) {
            mr4 mr4Var = this.b0;
            if (mr4Var != null) {
                mr4Var.dismiss();
                this.b0 = null;
            }
            or4 or4Var = new or4(this.c.getContext());
            ArrayList arrayList = new ArrayList();
            if (!z4) {
                arrayList.add(new kr4(0, this.c.getPageContext().getString(R.string.obfuscated_res_0x7f0f043c), or4Var));
            }
            if (z3) {
                arrayList.add(new kr4(1, this.c.getPageContext().getString(R.string.obfuscated_res_0x7f0f0fa9), or4Var));
            } else if (!z2) {
                arrayList.add(new kr4(1, this.c.getPageContext().getString(R.string.obfuscated_res_0x7f0f0a81), or4Var));
            } else {
                arrayList.add(new kr4(1, this.c.getPageContext().getString(R.string.obfuscated_res_0x7f0f0f85), or4Var));
            }
            or4Var.j(arrayList);
            or4Var.n(new w(this, cVar));
            mr4 mr4Var2 = new mr4(this.c.getPageContext(), or4Var);
            this.c0 = mr4Var2;
            mr4Var2.m();
        }
    }

    public TextView D0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.u.n() : (TextView) invokeV.objValue;
    }

    public boolean D1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void D2(String str) {
        PbReplyTitleViewHolder pbReplyTitleViewHolder;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, str) == null) || this.I == null) {
            return;
        }
        int i3 = 0;
        q0 q0Var = this.W0;
        if (q0Var != null && (pbReplyTitleViewHolder = q0Var.c) != null && pbReplyTitleViewHolder.b() != null) {
            i3 = this.W0.c.b().getTop() < 0 ? this.W0.c.b().getHeight() : this.W0.c.b().getBottom();
        }
        this.I.F(str, i3);
    }

    public void D3(AdapterView.OnItemClickListener onItemClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, onItemClickListener) == null) {
            hr4 hr4Var = this.d0;
            if (hr4Var != null) {
                hr4Var.d();
                this.d0 = null;
            }
            if (this.G0 == null) {
                return;
            }
            ArrayList<qr4> arrayList = new ArrayList<>();
            arrayList.add(new qr4(this.c.getContext().getString(R.string.obfuscated_res_0x7f0f0267), "", this.G0.L() == 1, Integer.toString(1)));
            arrayList.add(new qr4(this.c.getContext().getString(R.string.obfuscated_res_0x7f0f0b26), "", this.G0.L() == 2, Integer.toString(5)));
            arrayList.add(new qr4(this.c.getContext().getString(R.string.obfuscated_res_0x7f0f0b22), "", this.G0.L() == 3, Integer.toString(6)));
            arrayList.add(new qr4(this.c.getContext().getString(R.string.obfuscated_res_0x7f0f0b3d), "", this.G0.L() == 4, Integer.toString(7)));
            hr4 hr4Var2 = new hr4(this.c.getPageContext());
            hr4Var2.l(R.string.obfuscated_res_0x7f0f0dba);
            this.d0 = hr4Var2;
            hr4Var2.k(arrayList, onItemClickListener);
            hr4Var2.c();
            this.d0.n();
        }
    }

    public int E0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            g08 g08Var = this.y0;
            if (g08Var != null) {
                return g08Var.f();
            }
            return 3;
        }
        return invokeV.intValue;
    }

    public final boolean E1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.T1) : invokeV.booleanValue;
    }

    public final void E2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.F1.setFallingFeedbackListener(new FallingView.k() { // from class: com.repackage.zt7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.pb.view.FallingView.k
                public final void onClick() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        zv7.this.O1();
                    }
                }
            });
        }
    }

    public void E3() {
        PostData postData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || !TbadkCoreApplication.isLogin() || this.G0 == null || !this.h1 || this.g1 || this.f0 || (postData = this.H0) == null || postData.s() == null || this.H0.s().getIsLike() || this.H0.s().hadConcerned() || this.d1 != null) {
            return;
        }
        this.d1 = new uv7(this.c);
    }

    public PbInterviewStatusView F0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.M0 : (PbInterviewStatusView) invokeV.objValue;
    }

    public final boolean F1(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, threadData)) == null) {
            if (threadData == null || threadData.getAuthor() == null) {
                return false;
            }
            PostData z0 = z0(this.G0, false);
            return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), (z0 == null || z0.s() == null) ? "" : z0.s().getUserId());
        }
        return invokeL.booleanValue;
    }

    public void F2(PbFragment.d3 d3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, d3Var) == null) {
            this.P1 = d3Var;
        }
    }

    public final void F3(dr4 dr4Var, int i3) {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048599, this, dr4Var, i3) == null) || (pbFragment = this.c) == null || dr4Var == null) {
            return;
        }
        if (this.u1 == null && this.s != null) {
            this.u1 = new yh5(pbFragment.getPageContext(), this.s.c());
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
        mp4 mp4Var = new mp4();
        mp4Var.j(sparseArray);
        this.u1.y(new String[]{this.c.getString(R.string.obfuscated_res_0x7f0f04a9), this.c.getString(R.string.obfuscated_res_0x7f0f04aa), this.c.getString(R.string.obfuscated_res_0x7f0f04ab), this.c.getString(R.string.obfuscated_res_0x7f0f04ac), this.c.getString(R.string.obfuscated_res_0x7f0f04ad)});
        this.u1.x(mp4Var);
        this.u1.A((i3 == 1 || i3 == 2) ? "4" : "3");
        this.u1.z(new r(this, dr4Var));
    }

    public boolean G0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.r1 : invokeV.booleanValue;
    }

    public boolean G1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            View view2 = this.T0;
            if (view2 == null || view2.getParent() == null || this.I.m()) {
                return false;
            }
            int bottom = this.T0.getBottom();
            Rect rect = new Rect();
            this.T0.getWindowVisibleDisplayFrame(rect);
            return bottom > 0 && bottom <= rect.bottom;
        }
        return invokeV.booleanValue;
    }

    public void G2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z2) == null) {
            this.l0 = z2;
        }
    }

    public void G3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            this.M.setVisibility(0);
        }
    }

    public int H0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            int lastVisiblePosition = this.l.getLastVisiblePosition();
            if (this.r != null) {
                if (lastVisiblePosition == this.l.getCount() - 1) {
                    lastVisiblePosition--;
                }
                if (lastVisiblePosition < 0) {
                    lastVisiblePosition = 0;
                }
            }
            return A0(lastVisiblePosition);
        }
        return invokeV.intValue;
    }

    public boolean H1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            yr7 yr7Var = this.G0;
            return yr7Var == null || yr7Var.l() == null || "0".equals(this.G0.l().getId()) || "me0407".equals(this.G0.l().getName());
        }
        return invokeV.booleanValue;
    }

    public void H2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048606, this, z2) == null) {
            this.C.h0(z2);
        }
    }

    public void H3() {
        ju7 ju7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048607, this) == null) || (ju7Var = this.C) == null) {
            return;
        }
        ju7Var.y0();
    }

    public BdTypeListView I0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.l : (BdTypeListView) invokeV.objValue;
    }

    public boolean I1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            rw7 rw7Var = this.r;
            return rw7Var != null && rw7Var.f();
        }
        return invokeV.booleanValue;
    }

    public void I2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048610, this, z2) == null) {
            this.z1 = z2;
        }
    }

    public final void I3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            FallingView fallingView = this.F1;
            if (fallingView != null) {
                fallingView.setTag(Boolean.TRUE);
            }
            RightFloatLayerView rightFloatLayerView = this.G1;
            if (rightFloatLayerView != null && rightFloatLayerView.getTag() == this.F1) {
                this.G1.setTag(null);
                this.G1.setAutoCompleteShown(true);
                this.G1.d();
            }
        }
    }

    public SparseArray<Object> J0(yr7 yr7Var, boolean z2, int i3) {
        InterceptResult invokeCommon;
        PostData z0;
        vo4 vo4Var;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048612, this, new Object[]{yr7Var, Boolean.valueOf(z2), Integer.valueOf(i3)})) == null) {
            StringBuilder sb = null;
            if (yr7Var == null || (z0 = z0(yr7Var, z2)) == null) {
                return null;
            }
            String userId = z0.s().getUserId();
            boolean z3 = userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount());
            SparseArray<Object> sparseArray = new SparseArray<>();
            if (i3 == 0) {
                sparseArray.put(R.id.obfuscated_res_0x7f091e57, z0.I());
                sparseArray.put(R.id.obfuscated_res_0x7f091e59, 0);
                sparseArray.put(R.id.obfuscated_res_0x7f091e58, Boolean.valueOf(z3));
                sparseArray.put(R.id.obfuscated_res_0x7f091e74, Integer.valueOf(yr7Var.V()));
                sparseArray.put(R.id.obfuscated_res_0x7f091e97, Boolean.FALSE);
            } else if (i3 == 1) {
                if (z0.s() != null) {
                    sparseArray.put(R.id.obfuscated_res_0x7f091e62, z0.s().getUserName());
                    sparseArray.put(R.id.obfuscated_res_0x7f091e63, z0.s().getName_show());
                    sparseArray.put(R.id.obfuscated_res_0x7f091e64, z0.s().getPortrait());
                    sparseArray.put(R.id.obfuscated_res_0x7f091e65, z0.I());
                }
                sparseArray.put(R.id.obfuscated_res_0x7f091e57, z0.I());
                sparseArray.put(R.id.obfuscated_res_0x7f091e59, 0);
                sparseArray.put(R.id.obfuscated_res_0x7f091e58, Boolean.valueOf(z3));
                sparseArray.put(R.id.obfuscated_res_0x7f091e74, Integer.valueOf(yr7Var.V()));
                sparseArray.put(R.id.obfuscated_res_0x7f091e97, Boolean.TRUE);
            }
            if (!z3) {
                List<oq4> p2 = yr7Var.p();
                if (ListUtils.getCount(p2) > 0) {
                    sb = new StringBuilder();
                    for (oq4 oq4Var : p2) {
                        if (oq4Var != null && !StringUtils.isNull(oq4Var.a()) && (vo4Var = oq4Var.g) != null && vo4Var.a && !vo4Var.c && ((i4 = vo4Var.b) == 1 || i4 == 2)) {
                            sb.append(ni.cutString(oq4Var.a(), 12));
                            sb.append(this.c.getString(R.string.obfuscated_res_0x7f0f0643));
                            sb.append("、");
                        }
                    }
                }
                if (sb != null && !StringUtils.isNull(sb.toString())) {
                    sparseArray.put(R.id.obfuscated_res_0x7f091e56, String.format(this.c.getString(R.string.obfuscated_res_0x7f0f048d), sb.toString().substring(0, sb.length() - 1)));
                }
            }
            return sparseArray;
        }
        return (SparseArray) invokeCommon.objValue;
    }

    public boolean J1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? this.I1 : invokeV.booleanValue;
    }

    public void J2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048614, this, z2) == null) {
            this.r1 = z2;
        }
    }

    public void J3() {
        g08 g08Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048615, this) == null) || (g08Var = this.y0) == null) {
            return;
        }
        g08Var.m(2);
    }

    public ut7 K0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.p1 : (ut7) invokeV.objValue;
    }

    public boolean K1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            g08 g08Var = this.y0;
            if (g08Var == null) {
                return false;
            }
            return g08Var.h();
        }
        return invokeV.booleanValue;
    }

    public void K2(boolean z2) {
        rw7 rw7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048618, this, z2) == null) || (rw7Var = this.r) == null) {
            return;
        }
        rw7Var.r(z2);
    }

    public void K3(qp4 qp4Var, dr4.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048619, this, qp4Var, eVar) == null) || qp4Var == null) {
            return;
        }
        int a3 = qp4Var.a();
        int h3 = qp4Var.h();
        dr4 dr4Var = this.D;
        if (dr4Var != null) {
            dr4Var.show();
        } else {
            this.D = new dr4(this.c.getPageContext().getPageActivity());
            View inflate = LayoutInflater.from(this.c.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0235, (ViewGroup) null);
            this.F = inflate;
            this.D.setContentView(inflate);
            this.D.setPositiveButton(R.string.obfuscated_res_0x7f0f04dd, eVar);
            this.D.setNegativeButton(R.string.obfuscated_res_0x7f0f04d8, new f0(this));
            this.D.setOnCalcelListener(new g0(this));
            this.D.create(this.c.getPageContext()).show();
        }
        EditText editText = (EditText) this.F.findViewById(R.id.obfuscated_res_0x7f090efa);
        this.G = editText;
        editText.setText("");
        TextView textView = (TextView) this.F.findViewById(R.id.obfuscated_res_0x7f09073c);
        if (a3 <= 0) {
            a3 = 1;
        }
        if (h3 <= 0) {
            h3 = 1;
        }
        textView.setText(MessageFormat.format(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0467), Integer.valueOf(a3), Integer.valueOf(h3)));
        this.c.getBaseFragmentActivity().ShowSoftKeyPadDelay(this.G, 150);
    }

    public View L0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) ? this.L : (View) invokeV.objValue;
    }

    public boolean L1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            EditorTools editorTools = this.k0;
            return editorTools != null && editorTools.u();
        }
        return invokeV.booleanValue;
    }

    public void L2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048622, this, z2) == null) {
            this.C.j0(z2);
        }
    }

    public void L3(boolean z2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048623, this, z2) == null) || this.l == null || (textView = this.O0) == null || this.e == null) {
            return;
        }
        if (z2) {
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.e.setVisibility(0);
            } else {
                this.e.setVisibility(8);
                this.l.removeHeaderView(this.O0);
                this.l.setTextViewAdded(false);
            }
            AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) this.O0.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = a2;
                this.O0.setLayoutParams(layoutParams);
            }
            z2();
            return;
        }
        AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) textView.getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT) + M0(true);
            this.O0.setLayoutParams(layoutParams2);
        }
        z2();
        t2();
    }

    public final int M0(boolean z2) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048624, this, z2)) == null) {
            PbInterviewStatusView pbInterviewStatusView = this.M0;
            if (pbInterviewStatusView != null && pbInterviewStatusView.getVisibility() == 0 && z2) {
                return 0 + oi.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f07026a);
            }
            return 0;
        }
        return invokeZ.intValue;
    }

    public /* synthetic */ void M1() {
        this.l.post(new Runnable() { // from class: com.repackage.bu7
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // java.lang.Runnable
            public final void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    zv7.this.N1();
                }
            }
        });
    }

    public void M2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048626, this, z2) == null) {
            this.C.o0(z2);
        }
    }

    public final void M3(yr7 yr7Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048627, this, yr7Var) == null) || yr7Var == null || yr7Var.O() == null || yr7Var.O().isVideoThreadType()) {
            return;
        }
        boolean z2 = yr7Var.O().getIs_good() == 1;
        boolean z3 = yr7Var.O().getIs_top() == 1;
        qw7 qw7Var = this.u;
        if (qw7Var != null) {
            qw7Var.l(yr7Var, z2, z3);
        }
        ju7 ju7Var = this.C;
        if (ju7Var == null || ju7Var.t() == null) {
            return;
        }
        this.C.t().e(yr7Var, z2, z3);
    }

    public View N0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) ? this.K : (View) invokeV.objValue;
    }

    public /* synthetic */ void N1() {
        zu7 zu7Var = this.p;
        if (zu7Var != null) {
            zu7Var.p();
        }
    }

    public void N2(du4.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048630, this, gVar) == null) {
            this.U1 = gVar;
            h08 h08Var = this.H;
            if (h08Var != null) {
                h08Var.f(gVar);
            }
        }
    }

    @SuppressLint({"CutPasteId"})
    public void N3(yr7 yr7Var, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048631, this, yr7Var, z2) == null) || yr7Var == null) {
            return;
        }
        W3(yr7Var, z2);
        i0();
    }

    public PbListView O0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) ? this.I : (PbListView) invokeV.objValue;
    }

    public /* synthetic */ void O1() {
        String V0;
        PbFragment pbFragment = this.c;
        if (pbFragment != null && pbFragment.w() != null && this.c.w().z1()) {
            V0 = this.c.getString(R.string.obfuscated_res_0x7f0f0dc1);
        } else {
            V0 = V0();
        }
        if (!StringUtils.isNull(V0) && this.G0 != null) {
            V0 = TbSingleton.getInstance().getAdVertiComment(this.G0.k0(), this.G0.l0(), V0);
        }
        PbFragment pbFragment2 = this.c;
        if (pbFragment2 != null && pbFragment2.L4() != null) {
            this.c.L4().k0(V0);
        }
        TextView textView = this.t0;
        if (textView != null) {
            textView.setText(V0);
        }
        o3(false);
        I3();
    }

    public void O2(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048634, this, onClickListener) == null) {
            this.V1 = onClickListener;
            ju7 ju7Var = this.C;
            if (ju7Var != null) {
                ju7Var.p0(onClickListener);
            }
        }
    }

    public void O3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048635, this, str) == null) {
            this.c.showToast(str);
        }
    }

    public int P0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) {
            try {
                return Integer.parseInt(this.G.getText().toString(), 10);
            } catch (Exception unused) {
                return -1;
            }
        }
        return invokeV.intValue;
    }

    public final void P1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048637, this) == null) {
            if (this.s0 != null && TbadkCoreApplication.getCurrentAccountInfo() != null) {
                this.s0.setImageResource(0);
                this.s0.K(TbadkCoreApplication.getCurrentAccountInfo().getAvatar(), 12, false);
                return;
            }
            this.s0.setImageResource(R.drawable.obfuscated_res_0x7f081207);
        }
    }

    public void P2(String str) {
        vx7 vx7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048638, this, str) == null) || (vx7Var = this.i) == null) {
            return;
        }
        vx7Var.b(str);
    }

    public void P3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048639, this) == null) {
            this.c.showProgressBar();
        }
    }

    public View Q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) ? this.P0 : (View) invokeV.objValue;
    }

    public void Q1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048641, this) == null) {
            q2(this.G0);
        }
    }

    public void Q2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048642, this, z2) == null) {
            this.e1 = z2;
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView != null) {
                this.f1 = pbLandscapeListView.getHeaderViewsCount();
            }
        }
    }

    public void Q3() {
        FallingView fallingView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048643, this) == null) || (fallingView = this.F1) == null) {
            return;
        }
        fallingView.C();
    }

    public PbFakeFloorModel R0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) ? this.b1 : (PbFakeFloorModel) invokeV.objValue;
    }

    public void R1() {
        yu7 yu7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048645, this) == null) || (yu7Var = this.q) == null) {
            return;
        }
        yu7Var.b();
    }

    public void R2(PbFragment.e3 e3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048646, this, e3Var) == null) {
        }
    }

    public void R3() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048647, this) == null) || this.W1 == null) {
            return;
        }
        while (this.W1.size() > 0) {
            TbImageView remove = this.W1.remove(0);
            if (remove != null) {
                remove.O();
            }
        }
    }

    public vu7 S0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048648, this)) == null) ? this.c1 : (vu7) invokeV.objValue;
    }

    public void S1(lk8 lk8Var) {
        yr7 yr7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048649, this, lk8Var) == null) || lk8Var == null || lk8Var.a == null || lk8Var.b == null || (yr7Var = this.G0) == null || yr7Var.O() == null || this.G0.O().getAgreeData() == null) {
            return;
        }
        AgreeData agreeData = this.G0.O().getAgreeData();
        String str = lk8Var.b.nid;
        if (!TextUtils.isEmpty(str) && !"0".equals(str)) {
            BaijiahaoData baijiahaoData = agreeData.baijiahaoData;
            if (baijiahaoData == null || !TextUtils.equals(str, baijiahaoData.oriUgcNid)) {
                return;
            }
        } else {
            String str2 = lk8Var.b.threadId;
            String str3 = agreeData.threadId;
            if ("0".equals(str2) || TextUtils.isEmpty(str2) || !TextUtils.equals(str2, str3)) {
                return;
            }
        }
        AgreeData agreeData2 = lk8Var.b;
        p2(agreeData2, agreeData2.agreeNum);
    }

    public void S2(TbRichTextView.y yVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048650, this, yVar) == null) {
            this.O = yVar;
            this.C.s0(yVar);
            this.p1.q(this.O);
        }
    }

    public void S3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048651, this, z2) == null) {
            this.e0 = z2;
        }
    }

    public final boolean T(AbsListView absListView, int i3) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048652, this, absListView, i3)) == null) {
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

    public rw7 T0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048653, this)) == null) ? this.r : (rw7) invokeV.objValue;
    }

    public void T1(int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048654, this, i3) == null) || this.J0 == i3) {
            return;
        }
        this.J0 = i3;
        N3(this.G0, this.F0);
        s2(this.G0, this.F0, this.I0, i3);
        this.c.getBaseFragmentActivity().getLayoutMode().k(i3 == 1);
        this.c.getBaseFragmentActivity().getLayoutMode().j(this.d);
        SkinManager.setBackgroundColor(this.d, R.color.CAM_X0201);
        SkinManager.setBackgroundColor(this.m0, R.color.CAM_X0203);
        rw7 rw7Var = this.r;
        if (rw7Var != null) {
            rw7Var.h(i3);
        }
        nw7 nw7Var = this.v;
        if (nw7Var != null) {
            nw7Var.c(i3);
        }
        mw7 mw7Var = this.s;
        if (mw7Var != null) {
            mw7Var.e(i3);
        }
        ow7 ow7Var = this.t;
        if (ow7Var != null) {
            ow7Var.c(i3);
        }
        qw7 qw7Var = this.u;
        if (qw7Var != null) {
            qw7Var.t(i3);
        }
        pw7 pw7Var = this.w;
        if (pw7Var != null) {
            pw7Var.d();
        }
        lw7 lw7Var = this.x;
        if (lw7Var != null) {
            lw7Var.c();
        }
        MaskView maskView = this.E1;
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
        dr4 dr4Var = this.D;
        if (dr4Var != null) {
            dr4Var.autoChangeSkinType(this.c.getPageContext());
        }
        S3(this.e0);
        this.C.Z();
        h08 h08Var = this.H;
        if (h08Var != null) {
            h08Var.H(i3);
        }
        EditorTools editorTools = this.k0;
        if (editorTools != null) {
            editorTools.w(i3);
        }
        d08 d08Var = this.J;
        if (d08Var != null) {
            d08Var.f(i3);
        }
        if (!ListUtils.isEmpty(this.n)) {
            for (CustomBlueCheckRadioButton customBlueCheckRadioButton : this.n) {
                customBlueCheckRadioButton.c();
            }
        }
        X3();
        UtilHelper.setStatusBarBackground(this.e, i3);
        UtilHelper.setStatusBarBackground(this.R0, i3);
        if (this.y != null) {
            f95.a(this.c.getPageContext(), this.y);
        }
        vu7 vu7Var = this.c1;
        if (vu7Var != null) {
            vu7Var.h(i3);
        }
        wx7 wx7Var = this.h;
        if (wx7Var != null) {
            rw7 rw7Var2 = this.r;
            if (rw7Var2 != null) {
                rw7Var2.i(i3);
            } else {
                wx7Var.u(i3);
            }
        }
        HeadImageView headImageView = this.s0;
        if (headImageView != null) {
            headImageView.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
        }
        LinearLayout linearLayout = this.r0;
        if (linearLayout != null) {
            linearLayout.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(oi.f(this.c.getContext(), R.dimen.tbds47), SkinManager.getColor(R.color.CAM_X0209)));
        }
        yr7 yr7Var = this.G0;
        if (yr7Var != null && yr7Var.r()) {
            WebPManager.setPureDrawable(this.w0, R.drawable.obfuscated_res_0x7f080928, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
        } else {
            WebPManager.setPureDrawable(this.w0, R.drawable.obfuscated_res_0x7f080927, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        }
        WebPManager.setPureDrawable(this.u0, R.drawable.obfuscated_res_0x7f08092a, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        V3(this.G0);
        SkinManager.setBackgroundColor(this.q0, R.color.CAM_X0207);
        SkinManager.setBackgroundColor(this.p0, R.color.CAM_X0203);
        SkinManager.setViewTextColor(this.m1, (int) R.color.cp_cont_n);
        SkinManager.setViewTextColor(this.t0, (int) R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.B0, (int) R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.A0, (int) R.color.CAM_X0107);
        SkinManager.setBackgroundShapeDrawable(this.A0, oi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18), R.color.CAM_X0207, R.color.CAM_X0207);
        SkinManager.setViewTextColor(this.z0, (int) R.color.CAM_X0107);
        SkinManager.setBackgroundShapeDrawable(this.z0, oi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18), R.color.CAM_X0207, R.color.CAM_X0207);
        AgreeView agreeView = this.v0;
        if (agreeView != null) {
            agreeView.m();
            this.v0.B(i3);
            AgreeData data = this.v0.getData();
            if (data != null) {
                p2(data, data.agreeNum);
            }
        }
        ut7 ut7Var = this.p1;
        if (ut7Var != null) {
            ut7Var.m(i3);
        }
        PbEmotionBar pbEmotionBar = this.X0;
        if (pbEmotionBar != null) {
            pbEmotionBar.w();
        }
        PbThreadPostView pbThreadPostView = this.o;
        if (pbThreadPostView != null) {
            pbThreadPostView.c(i3);
        }
        g08 g08Var = this.y0;
        if (g08Var != null) {
            g08Var.i();
        }
        f08 f08Var = this.D1;
        if (f08Var != null) {
            f08Var.c();
        }
        RightFloatLayerView rightFloatLayerView = this.G1;
        if (rightFloatLayerView != null) {
            rightFloatLayerView.o();
        }
        SkinManager.setBackgroundColor(this.Q0, R.color.CAM_X0207);
        SkinManager.setViewTextColor(this.Q0.findViewById(R.id.obfuscated_res_0x7f092201), (int) R.color.CAM_X0105);
    }

    public void T2(NoNetworkView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048655, this, bVar) == null) {
            this.P = bVar;
            NoNetworkView noNetworkView = this.m;
            if (noNetworkView != null) {
                noNetworkView.a(bVar);
            }
        }
    }

    public void T3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048656, this, z2) == null) {
            this.h.H(z2);
            if (z2 && this.K0) {
                this.I.C(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f03df));
                this.l.setNextPage(this.I);
                this.f = 2;
            }
            P1();
        }
    }

    public void U() {
        g08 g08Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048657, this) == null) || (g08Var = this.y0) == null) {
            return;
        }
        g08Var.l(false);
    }

    public final PostData U0(yr7 yr7Var) {
        InterceptResult invokeL;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048658, this, yr7Var)) == null) {
            if (yr7Var == null || yr7Var.O() == null || yr7Var.O().getAuthor() == null) {
                return null;
            }
            PostData postData = new PostData();
            MetaData author = yr7Var.O().getAuthor();
            String userId = author.getUserId();
            HashMap<String, MetaData> userMap = yr7Var.O().getUserMap();
            if (userMap != null && (metaData = userMap.get(userId)) != null && metaData.getUserId() != null) {
                author = metaData;
            }
            postData.p0(1);
            postData.u0(yr7Var.O().getFirstPostId());
            postData.G0(yr7Var.O().getTitle());
            postData.F0(yr7Var.O().getCreateTime());
            postData.n0(author);
            return postData;
        }
        return (PostData) invokeL.objValue;
    }

    public void U1(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048659, this, configuration) == null) || configuration == null) {
            return;
        }
        f0();
        if (configuration.orientation == 2) {
            f1();
            h1();
        } else {
            y2();
        }
        vu7 vu7Var = this.c1;
        if (vu7Var != null) {
            vu7Var.c();
        }
        this.c.a5();
        this.B.setVisibility(8);
        this.h.B(false);
        this.c.W5(false);
        if (this.r != null) {
            if (configuration.orientation == 1) {
                c1().setVisibility(0);
            }
            if (configuration.orientation == 2) {
                this.Z1 = true;
                this.l.setIsLandscape(true);
                this.l.smoothScrollToPosition(0);
            } else {
                this.Z1 = false;
                this.l.setIsLandscape(false);
                int i3 = this.X1;
                if (i3 > 0) {
                    this.l.smoothScrollBy(i3, 0);
                }
            }
            this.r.j(configuration);
            this.N0.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        }
    }

    public void U2(BdListView.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048660, this, pVar) == null) {
            this.l.setOnSrollToBottomListener(pVar);
        }
    }

    public void U3(wr7 wr7Var) {
        String string;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048661, this, wr7Var) == null) || wr7Var == null) {
            return;
        }
        this.h.I();
        if (!StringUtils.isNull(wr7Var.b)) {
            this.h.F(wr7Var.b);
        }
        String string2 = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f139b);
        int e3 = mg.e(wr7Var.a, 0);
        if (e3 == 100) {
            string = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f10de);
        } else if (e3 != 300) {
            string = e3 != 400 ? "" : TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f1318);
        } else {
            string = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f02e6);
        }
        this.c.showNetRefreshView(this.d, String.format(string2, string), null, TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0293), true, new b0(this, wr7Var.c));
    }

    public boolean V(boolean z2) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048662, this, z2)) == null) {
            EditorTools editorTools = this.k0;
            if (editorTools == null || !editorTools.u()) {
                return false;
            }
            this.k0.q();
            return true;
        }
        return invokeZ.booleanValue;
    }

    public String V0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048663, this)) == null) {
            if (!ni.isEmpty(this.w1)) {
                return this.w1;
            }
            if (this.c != null) {
                this.w1 = TbadkCoreApplication.getInst().getResources().getString(xv7.b());
            }
            return this.w1;
        }
        return (String) invokeV.objValue;
    }

    public void V1() {
        NoNetworkView.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048664, this) == null) {
            zu7 zu7Var = this.p;
            if (zu7Var != null) {
                zu7Var.l();
            }
            RelativeLayout relativeLayout = this.d;
            if (relativeLayout != null && relativeLayout.getHandler() != null) {
                this.d.getHandler().removeCallbacksAndMessages(null);
            }
            g08 g08Var = this.y0;
            if (g08Var != null) {
                g08Var.j();
            }
            uv7 uv7Var = this.d1;
            if (uv7Var != null) {
                uv7Var.a();
            }
            mv7 mv7Var = this.s1;
            if (mv7Var != null) {
                mv7Var.c();
            }
            PbTopTipView pbTopTipView = this.k1;
            if (pbTopTipView != null) {
                pbTopTipView.g();
            }
            this.c.hideProgressBar();
            NoNetworkView noNetworkView = this.m;
            if (noNetworkView != null && (bVar = this.P) != null) {
                noNetworkView.d(bVar);
            }
            f0();
            l0();
            if (this.a1 != null) {
                pg.a().removeCallbacks(this.a1);
            }
            PbInterviewStatusView pbInterviewStatusView = this.M0;
            if (pbInterviewStatusView != null) {
                pbInterviewStatusView.m();
            }
            this.M1 = null;
            this.g.removeCallbacksAndMessages(null);
            this.C.a0(3);
            View view2 = this.e;
            if (view2 != null) {
                view2.setBackgroundDrawable(null);
            }
            rw7 rw7Var = this.r;
            if (rw7Var != null) {
                rw7Var.a();
            }
            ju7 ju7Var = this.C;
            if (ju7Var != null) {
                ju7Var.b0();
            }
            this.l.setOnLayoutListener(null);
            xw7 xw7Var = this.o1;
            if (xw7Var != null) {
                xw7Var.l();
            }
            PbEmotionBar pbEmotionBar = this.X0;
            if (pbEmotionBar != null) {
                pbEmotionBar.x();
            }
            qw7 qw7Var = this.u;
            if (qw7Var != null) {
                qw7Var.u();
            }
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView != null) {
                pbLandscapeListView.getViewTreeObserver().removeGlobalOnLayoutListener(this.a);
            }
        }
    }

    public void V2(AbsListView.OnScrollListener onScrollListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048665, this, onScrollListener) == null) {
            this.l.setOnScrollListener(onScrollListener);
        }
    }

    public void V3(yr7 yr7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048666, this, yr7Var) == null) {
            if (yr7Var != null && AntiHelper.o(yr7Var.O())) {
                g08 g08Var = this.y0;
                if (g08Var != null) {
                    g08Var.k(false);
                    this.y0.j();
                }
                ViewGroup.LayoutParams layoutParams = this.x0.getLayoutParams();
                layoutParams.height = -2;
                layoutParams.width = -2;
                this.x0.setLayoutParams(layoutParams);
                WebPManager.setPureDrawable(this.x0, R.drawable.obfuscated_res_0x7f08092c, R.color.CAM_X0110, WebPManager.ResourceStateType.NORMAL_PRESS);
                return;
            }
            g08 g08Var2 = this.y0;
            if (g08Var2 == null || !g08Var2.g()) {
                ViewGroup.LayoutParams layoutParams2 = this.x0.getLayoutParams();
                layoutParams2.height = -2;
                layoutParams2.width = -2;
                this.x0.setLayoutParams(layoutParams2);
                WebPManager.setPureDrawable(this.x0, R.drawable.obfuscated_res_0x7f08092c, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            }
        }
    }

    public boolean W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048667, this)) == null) {
            PbListView pbListView = this.I;
            if (pbListView == null || TextUtils.isEmpty(pbListView.h())) {
                return false;
            }
            return this.I.h().equals(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f09e6));
        }
        return invokeV.booleanValue;
    }

    public final int W0(PbReplyTitleViewHolder pbReplyTitleViewHolder) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048668, this, pbReplyTitleViewHolder)) == null) {
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

    public void W1(TbRichText tbRichText) {
        yr7 yr7Var;
        PostData postData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048669, this, tbRichText) == null) || (yr7Var = this.G0) == null || yr7Var.F() == null || this.G0.F().isEmpty() || tbRichText == null || StringUtils.isNull(tbRichText.getAuthorId())) {
            return;
        }
        for (int i3 = 0; i3 < this.G0.F().size() && (postData = this.G0.F().get(i3)) != null && postData.s() != null && !StringUtils.isNull(postData.s().getUserId()); i3++) {
            if (this.G0.F().get(i3).s().getUserId().equals(tbRichText.getAuthorId())) {
                ut7 ut7Var = this.p1;
                if (ut7Var != null && ut7Var.l()) {
                    o3(false);
                }
                PbEmotionBar pbEmotionBar = this.X0;
                if (pbEmotionBar != null) {
                    pbEmotionBar.q(true);
                }
                postData.s().getName_show();
                return;
            }
        }
    }

    public void W2(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048670, this, onClickListener) == null) {
            this.C.w0(onClickListener);
        }
    }

    public boolean W3(yr7 yr7Var, boolean z2) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048671, this, yr7Var, z2)) == null) {
            if (yr7Var == null) {
                return false;
            }
            if (this.t != null) {
                if (yr7Var.O() != null && yr7Var.O().getIsNoTitle() == 0 && !yr7Var.O().isVideoThreadType() && !this.I1) {
                    if (yr7Var.O() != null) {
                        ThreadData O = yr7Var.O();
                        O.parserSpecTitleForFrsAndPb(true, r3(yr7Var));
                        O.setResource(3);
                        O.setPbTitle("2");
                    }
                    if (yr7Var.O().isBJHArticleThreadType()) {
                        this.u.w(this.l);
                        this.t.d(this.l);
                        this.t.a(this.l);
                        this.u.j(this.l);
                        this.u.A(this.G0);
                        if (z1(yr7Var)) {
                            this.t.d(this.l);
                        } else {
                            this.t.e(yr7Var);
                        }
                    } else {
                        this.u.A(this.G0);
                        if (z1(yr7Var)) {
                            this.t.d(this.l);
                        } else {
                            this.t.g(yr7Var);
                        }
                    }
                } else if (yr7Var.O().getIsNoTitle() == 1) {
                    if (yr7Var.O() != null) {
                        this.t.d(this.l);
                        this.u.A(this.G0);
                    }
                } else {
                    this.t.d(this.l);
                    this.u.A(this.G0);
                }
            }
            M3(yr7Var);
            this.F0 = z2;
            return false;
        }
        return invokeLZ.booleanValue;
    }

    public final void X() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048672, this) == null) || this.G0 == null || !UbsABTestHelper.isResizeInduceSharingABTest() || sx7.k(this.G0.Q())) {
            return;
        }
        this.y0.e();
        sx7.b(this.G0.Q());
    }

    public int X0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048673, this)) == null) ? R.id.obfuscated_res_0x7f091a79 : invokeV.intValue;
    }

    public boolean X1(int i3) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048674, this, i3)) == null) {
            rw7 rw7Var = this.r;
            if (rw7Var != null) {
                return rw7Var.k(i3);
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public void X2(int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048675, this, i3) == null) {
            this.A1 = i3;
        }
    }

    public final void X3() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048676, this) == null) && this.c.D4()) {
            if (this.c.I4() == -1) {
                SkinManager.setViewTextColor(this.z, R.color.CAM_X0110, 1);
            }
            if (this.c.H4() == -1) {
                SkinManager.setViewTextColor(this.A, R.color.CAM_X0110, 1);
            }
        }
    }

    public void Y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048677, this) == null) {
            if (!this.c.checkUpIsLogin()) {
                TiebaStatic.log(new StatisticItem("c10517").param("obj_locate", 2).param("fid", this.h0));
            } else if (this.c.d4()) {
                m25 L4 = this.c.L4();
                if (L4 != null && (L4.B() || L4.D())) {
                    this.c.L4().z(false, null);
                    return;
                }
                if (this.k0 != null) {
                    s1();
                }
                EditorTools editorTools = this.k0;
                if (editorTools != null) {
                    this.C0 = false;
                    if (editorTools.n(2) != null) {
                        gk8.c(this.c.getPageContext(), (View) this.k0.n(2).k, false, i2);
                    }
                }
                f1();
            }
        }
    }

    public final int Y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048678, this)) == null) {
            View childAt = this.l.getChildAt(0);
            if (childAt == null) {
                return 0;
            }
            return (-childAt.getTop()) + (this.l.getFirstVisiblePosition() * childAt.getHeight());
        }
        return invokeV.intValue;
    }

    public void Y1() {
        PostData postData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048679, this) == null) || this.c == null) {
            return;
        }
        if ((this.z1 || this.A1 == 17) && UbsABTestHelper.leftSlideToFrs()) {
            yr7 yr7Var = this.G0;
            if (yr7Var == null || yr7Var.l() == null || ni.isEmpty(this.G0.l().getName())) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.c.getContext()).createNormalCfg(this.G0.l().getName(), null)));
            TiebaStatic.log(new StatisticItem("c13853").param("post_id", this.G0.Q()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("fid", this.G0.l().getId()));
        } else if (!this.h1 || this.g1 || (postData = this.H0) == null || postData.s() == null) {
        } else {
            TiebaStatic.log(new StatisticItem("c12601").param("obj_locate", this.c.isSimpleForum() ? 2 : 1).param("obj_type", this.g1 ? 2 : 1));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.c.getPageContext().getPageActivity(), this.H0.s().getUserId(), this.H0.s().getUserName(), this.c.w().s0(), AddFriendActivityConfig.TYPE_PB_HEAD)));
        }
    }

    public void Y2(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048680, this, onLongClickListener) == null) {
            this.u.x(onLongClickListener);
            this.C.t0(onLongClickListener);
            ut7 ut7Var = this.p1;
            if (ut7Var != null) {
                ut7Var.r(onLongClickListener);
            }
        }
    }

    public void Y3(yr7 yr7Var) {
        mw7 mw7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048681, this, yr7Var) == null) || (mw7Var = this.s) == null) {
            return;
        }
        mw7Var.h(yr7Var, this.F0);
    }

    public void Z(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048682, this, z2) == null) {
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

    public int Z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048683, this)) == null) ? this.J0 : invokeV.intValue;
    }

    public void Z1(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048684, this, z2) == null) {
            if (z2) {
                u3();
            } else {
                i1();
            }
            this.W0.c = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.W0));
            m2(this.W0.c, false);
        }
    }

    public final void Z2(PostData postData, yr7 yr7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048685, this, postData, yr7Var) == null) {
            this.u.y(postData, yr7Var);
        }
    }

    public NoNetworkView a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048686, this)) == null) ? this.m : (NoNetworkView) invokeV.objValue;
    }

    public final void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048687, this) == null) {
            ut7 ut7Var = new ut7(this.c, this, (ViewStub) this.d.findViewById(R.id.obfuscated_res_0x7f09143e));
            this.p1 = ut7Var;
            ut7Var.o(this.N);
            this.p1.p(this.R);
            this.p1.q(this.O);
            this.p1.o(this.N);
            this.p1.s(this.i0);
        }
    }

    public View a1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048688, this)) == null) ? this.e : (View) invokeV.objValue;
    }

    public void a2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048689, this) == null) {
            R3();
            this.C.a0(1);
            rw7 rw7Var = this.r;
            if (rw7Var != null) {
                rw7Var.l();
            }
            zu7 zu7Var = this.p;
            if (zu7Var != null) {
                zu7Var.k();
            }
            RightFloatLayerView rightFloatLayerView = this.G1;
            if (rightFloatLayerView != null && (rightFloatLayerView instanceof RightFloatLayerLottieView)) {
                ((RightFloatLayerLottieView) rightFloatLayerView).H(600);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
        }
    }

    public void a3(boolean z2, PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048690, this, z2, postWriteCallBackData) == null) {
            this.c.hideProgressBar();
            if (z2) {
                f0();
            } else if (postWriteCallBackData != null && (postWriteCallBackData.isSensitiveError() || postWriteCallBackData.isErrorLinkCountExceedLimit() || postWriteCallBackData.isErrorShowApplyMemberDialog())) {
                g0();
            } else {
                f0();
            }
        }
    }

    public final CustomBlueCheckRadioButton b0(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048691, this, str, str2)) == null) {
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

    public PbThreadPostView b1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048692, this)) == null) ? this.o : (PbThreadPostView) invokeV.objValue;
    }

    public void b2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048693, this) == null) {
            this.C.a0(2);
            rw7 rw7Var = this.r;
            if (rw7Var != null) {
                rw7Var.m();
                if (TbSingleton.getInstance().isNotchScreen(this.c.getFragmentActivity()) || TbSingleton.getInstance().isCutoutScreen(this.c.getFragmentActivity())) {
                    return;
                }
                d1().setSystemUiVisibility(4);
            }
        }
    }

    public void b3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048694, this) == null) {
            this.c.hideProgressBar();
            yr7 yr7Var = this.G0;
            if (yr7Var != null && this.I != null && yr7Var.y() != null && this.G0.y().b() == 0) {
                this.I.u(this.G0.t());
                if (this.G0.t()) {
                    StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_PB_FOLD_ICON_SHOW);
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem.param("fid", this.G0.m());
                    statisticItem.param("fname", this.G0.n());
                    statisticItem.param("tid", this.G0.Q());
                    TiebaStatic.log(statisticItem);
                }
            }
            l0();
            this.l.A(0L);
            i0();
        }
    }

    public void c0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048695, this) == null) || this.Y1) {
            return;
        }
        TiebaStatic.log("c10490");
        this.Y1 = true;
        dr4 dr4Var = new dr4(this.c.getPageContext().getPageActivity());
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(c2, Integer.valueOf(e2));
        dr4Var.setTitle(R.string.obfuscated_res_0x7f0f07cf);
        View inflate = LayoutInflater.from(this.c.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0859, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090c35)).setText(R.string.obfuscated_res_0x7f0f0778);
        ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f092044)).setText(R.string.obfuscated_res_0x7f0f07cf);
        dr4Var.setContentView(inflate);
        dr4Var.setYesButtonTag(sparseArray);
        dr4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f07ce, this.c);
        dr4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0a5c, new h0(this));
        dr4Var.create(this.c.getPageContext()).show();
    }

    public RelativeLayout c1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048696, this)) == null) ? this.B : (RelativeLayout) invokeV.objValue;
    }

    public void c2(AbsListView absListView, int i3, int i4, int i5) {
        PbReplyTitleViewHolder pbReplyTitleViewHolder;
        qw7 qw7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048697, this, absListView, i3, i4, i5) == null) {
            yu7 yu7Var = this.q;
            if (yu7Var != null) {
                yu7Var.c(i3, i4);
            }
            rw7 rw7Var = this.r;
            if (rw7Var != null) {
                rw7Var.n(absListView, i3, i4, i5);
            }
            wx7 wx7Var = this.h;
            if (wx7Var != null && (qw7Var = this.u) != null) {
                wx7Var.w(qw7Var.o());
            }
            q0 q0Var = this.W0;
            q0Var.a = i3;
            q0Var.b = this.l.getHeaderViewsCount();
            this.W0.c = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.W0));
            n3(T(absListView, i3));
            int i6 = 0;
            m2(this.W0.c, false);
            e0();
            if (!this.I.n() || this.I.C) {
                return;
            }
            q0 q0Var2 = this.W0;
            if (q0Var2 != null && (pbReplyTitleViewHolder = q0Var2.c) != null && pbReplyTitleViewHolder.b() != null) {
                i6 = this.W0.c.b().getTop() < 0 ? this.W0.c.b().getHeight() : this.W0.c.b().getBottom();
            }
            this.I.e(i6);
            this.I.C = true;
        }
    }

    public void c3() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048698, this) == null) || (pbFragment = this.c) == null || pbFragment.getBaseFragmentActivity() == null) {
            return;
        }
        oi.w(this.c.getPageContext().getPageActivity(), this.c.getBaseFragmentActivity().getCurrentFocus());
    }

    public void d0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048699, this, str) == null) {
            if (str.contains("_")) {
                str = str.replace("_", "\n");
            }
            dr4 dr4Var = new dr4(this.c.getPageContext().getPageActivity());
            View inflate = LayoutInflater.from(this.c.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0859, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f092044);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(0, 0, 0, 0);
            textView.setLayoutParams(layoutParams);
            textView.setGravity(3);
            textView.setText(str);
            ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090c35)).setVisibility(8);
            dr4Var.setContentView(inflate);
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(c2, Integer.valueOf(f2));
            dr4Var.setYesButtonTag(sparseArray);
            dr4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f1504, this.c);
            dr4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f036e, new i0(this));
            dr4Var.create(this.c.getPageContext()).show();
        }
    }

    public View d1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048700, this)) == null) ? this.d : (View) invokeV.objValue;
    }

    public void d2(AbsListView absListView, int i3) {
        RightFloatLayerView rightFloatLayerView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048701, this, absListView, i3) == null) {
            rw7 rw7Var = this.r;
            if (rw7Var != null) {
                rw7Var.o(absListView, i3);
            }
            if (!this.Z1 && i3 == 0) {
                this.X1 = Y0();
                this.W0.c = null;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.W0));
                m2(this.W0.c, true);
                e0();
                this.C.f0(true);
            }
            this.C.e0();
            if (i3 == 0) {
                RightFloatLayerView rightFloatLayerView2 = this.G1;
                if (rightFloatLayerView2 != null) {
                    rightFloatLayerView2.q();
                }
            } else if (i3 == 1) {
                RightFloatLayerView rightFloatLayerView3 = this.G1;
                if (rightFloatLayerView3 != null) {
                    rightFloatLayerView3.p();
                }
            } else if (i3 != 2 || (rightFloatLayerView = this.G1) == null) {
            } else {
                rightFloatLayerView.r();
            }
        }
    }

    public void d3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048702, this) == null) {
            this.I.z();
            this.I.Q();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x004d, code lost:
        if (r5.B1 == 1) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void e0() {
        f08 f08Var;
        boolean z2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048703, this) == null) || (f08Var = this.D1) == null) {
            return;
        }
        if (((f08Var.a() == null || this.D1.a().getParent() == null) ? -1 : this.l.getPositionForView(this.D1.a())) != -1) {
            if (this.D1.a().getTop() + h2 <= this.P0.getBottom()) {
                this.B1 = 1;
                z2 = true;
            } else {
                this.B1 = 0;
                z2 = false;
            }
        }
        this.S0.u(this.B1 == 1);
        this.D1.e(z2);
    }

    public void e1() {
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048704, this) == null) {
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView != null) {
                pbLandscapeListView.setVisibility(8);
            }
            if (this.l != null) {
                this.N0.setVisibility(8);
            }
            wx7 wx7Var = this.h;
            if (wx7Var == null || (view2 = wx7Var.d) == null) {
                return;
            }
            view2.setVisibility(8);
        }
    }

    public void e2(ArrayList<dp4> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048705, this, arrayList) == null) {
            if (this.V == null) {
                this.V = LayoutInflater.from(this.c.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d01f2, (ViewGroup) null);
            }
            this.c.getBaseFragmentActivity().getLayoutMode().j(this.V);
            if (this.U == null) {
                Dialog dialog = new Dialog(this.c.getPageContext().getPageActivity(), R.style.obfuscated_res_0x7f10039f);
                this.U = dialog;
                dialog.setCanceledOnTouchOutside(true);
                this.U.setCancelable(true);
                this.j0 = (ScrollView) this.V.findViewById(R.id.obfuscated_res_0x7f090cdf);
                this.U.setContentView(this.V);
                WindowManager.LayoutParams attributes = this.U.getWindow().getAttributes();
                attributes.width = oi.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0702de);
                this.U.getWindow().setAttributes(attributes);
                this.X = new u(this);
                this.W = (LinearLayout) this.V.findViewById(R.id.obfuscated_res_0x7f090cde);
                TextView textView = (TextView) this.V.findViewById(R.id.obfuscated_res_0x7f0907a1);
                this.Z = textView;
                textView.setOnClickListener(new v(this));
                TextView textView2 = (TextView) this.V.findViewById(R.id.obfuscated_res_0x7f0907a2);
                this.Y = textView2;
                textView2.setOnClickListener(this.N);
            }
            this.W.removeAllViews();
            this.n = new ArrayList();
            CustomBlueCheckRadioButton b02 = b0("0", this.c.getPageContext().getString(R.string.obfuscated_res_0x7f0f13a0));
            this.n.add(b02);
            b02.setChecked(true);
            this.W.addView(b02);
            if (arrayList != null) {
                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                    dp4 dp4Var = arrayList.get(i3);
                    if (dp4Var != null && !TextUtils.isEmpty(dp4Var.b()) && dp4Var.a() > 0) {
                        CustomBlueCheckRadioButton b03 = b0(String.valueOf(dp4Var.a()), dp4Var.b());
                        this.n.add(b03);
                        View view2 = new View(this.c.getPageContext().getPageActivity());
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, oi.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f070198));
                        SkinManager.setBackgroundColor(view2, R.color.CAM_X0204);
                        view2.setLayoutParams(layoutParams);
                        this.W.addView(view2);
                        this.W.addView(b03);
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

    public void e3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048706, this, z2) == null) {
            this.u.z(z2);
        }
    }

    public void f0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048707, this) == null) {
            this.h.k();
            qw7 qw7Var = this.u;
            if (qw7Var != null) {
                qw7Var.m();
            }
            PbFragment pbFragment = this.c;
            if (pbFragment != null) {
                oi.w(pbFragment.getContext(), this.G);
            }
            h1();
            mr4 mr4Var = this.b0;
            if (mr4Var != null) {
                mr4Var.dismiss();
            }
            j0();
            dr4 dr4Var = this.D;
            if (dr4Var != null) {
                dr4Var.dismiss();
            }
            fr4 fr4Var = this.E;
            if (fr4Var != null) {
                fr4Var.e();
            }
        }
    }

    public void f1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048708, this) == null) || this.q0 == null) {
            return;
        }
        this.p0.setVisibility(8);
        this.q0.setVisibility(8);
        this.C0 = false;
        PbEmotionBar pbEmotionBar = this.X0;
        if (pbEmotionBar != null) {
            pbEmotionBar.setVisibility(8);
            x2(false);
        }
    }

    public void f2(int i3, String str, int i4, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048709, this, new Object[]{Integer.valueOf(i3), str, Integer.valueOf(i4), Boolean.valueOf(z2)}) == null) {
            g2(i3, str, i4, z2, null);
        }
    }

    public void f3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048710, this, str) == null) {
            this.t0.performClick();
            if (StringUtils.isNull(str) || this.c.L4() == null || this.c.L4().v() == null || this.c.L4().v().h() == null) {
                return;
            }
            EditText h3 = this.c.L4().v().h();
            h3.setText(str);
            h3.setSelection(str.length());
        }
    }

    public void g0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048711, this) == null) {
            this.h.k();
            qw7 qw7Var = this.u;
            if (qw7Var != null) {
                qw7Var.m();
            }
            mr4 mr4Var = this.b0;
            if (mr4Var != null) {
                mr4Var.dismiss();
            }
            j0();
            dr4 dr4Var = this.D;
            if (dr4Var != null) {
                dr4Var.dismiss();
            }
            fr4 fr4Var = this.E;
            if (fr4Var != null) {
                fr4Var.e();
            }
        }
    }

    public void g1(boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048712, this, z2) == null) || this.q0 == null || this.t0 == null) {
            return;
        }
        TbSingleton tbSingleton = TbSingleton.getInstance();
        yr7 yr7Var = this.G0;
        boolean z3 = yr7Var != null && yr7Var.k0();
        yr7 yr7Var2 = this.G0;
        this.t0.setText(tbSingleton.getAdVertiComment(z3, yr7Var2 != null && yr7Var2.l0(), V0()));
        if (z2) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(400L);
            this.q0.startAnimation(alphaAnimation);
        }
        this.p0.setVisibility(0);
        this.q0.setVisibility(0);
        this.C0 = true;
        if (this.X0 == null || this.p1.l()) {
            return;
        }
        this.X0.setVisibility(0);
        x2(true);
    }

    public void g2(int i3, String str, int i4, boolean z2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048713, this, new Object[]{Integer.valueOf(i3), str, Integer.valueOf(i4), Boolean.valueOf(z2), str2}) == null) {
            h2(i3, str, i4, z2, str2, false);
        }
    }

    public void g3(int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048714, this, i3) == null) {
            this.l.setSelection(i3);
        }
    }

    public void h0() {
        g08 g08Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048715, this) == null) || (g08Var = this.y0) == null) {
            return;
        }
        g08Var.k(false);
    }

    public void h1() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048716, this) == null) || (editorTools = this.k0) == null) {
            return;
        }
        editorTools.o();
        xw7 xw7Var = this.o1;
        if (xw7Var != null) {
            xw7Var.m();
        }
    }

    public void h2(int i3, String str, int i4, boolean z2, String str2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048717, this, new Object[]{Integer.valueOf(i3), str, Integer.valueOf(i4), Boolean.valueOf(z2), str2, Boolean.valueOf(z3)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(R.id.obfuscated_res_0x7f091e57, str);
            sparseArray.put(R.id.obfuscated_res_0x7f091e59, Integer.valueOf(i3));
            sparseArray.put(R.id.obfuscated_res_0x7f091e74, Integer.valueOf(i4));
            sparseArray.put(R.id.obfuscated_res_0x7f091e58, Boolean.valueOf(z2));
            sparseArray.put(c2, Integer.valueOf(d2));
            int i5 = (i4 != 1002 || z2) ? R.string.obfuscated_res_0x7f0f048a : R.string.obfuscated_res_0x7f0f0fa6;
            int i6 = R.string.obfuscated_res_0x7f0f0429;
            if (i3 == 0) {
                if (i4 != 1002 || z2) {
                    i6 = R.string.obfuscated_res_0x7f0f048e;
                    i5 = R.string.obfuscated_res_0x7f0f048f;
                } else {
                    i5 = R.string.obfuscated_res_0x7f0f0faa;
                }
            }
            this.S = new dr4(this.c.getActivity());
            if (StringUtils.isNull(str2)) {
                this.S.setMessageId(i5);
            } else {
                this.S.setOnlyMessageShowCenter(false);
                this.S.setMessage(str2);
            }
            this.S.setYesButtonTag(sparseArray);
            this.S.setPositiveButton(R.string.obfuscated_res_0x7f0f04dd, this.c);
            this.S.setNegativeButton(R.string.obfuscated_res_0x7f0f04d8, new m(this));
            this.S.setCancelable(true);
            this.S.create(this.c.getPageContext());
            if (z3) {
                q3(sparseArray, i6, i5);
            } else if (z2) {
                q3(sparseArray, i6, i5);
            } else if (i3()) {
                ai5 ai5Var = new ai5(this.c.w().T0().l().getDeletedReasonInfo().is_grays_cale_forum.intValue(), this.c.w().T0().l().getDeletedReasonInfo().is_boomgrow.intValue(), this.c.w().T0().o().has_forum_rule.intValue());
                ai5Var.i(this.c.w().T0().l().getId(), this.c.w().T0().l().getName());
                ai5Var.h(this.c.w().T0().l().getImage_url());
                ai5Var.j(this.c.w().T0().l().getUser_level());
                x3(sparseArray, i3, ai5Var, this.c.w().T0().U(), false);
            } else {
                F3(this.S, i3);
            }
        }
    }

    public void h3(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048718, this, list) == null) {
            this.n1 = list;
            xw7 xw7Var = this.o1;
            if (xw7Var != null) {
                xw7Var.q(list);
            }
        }
    }

    public final boolean i0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048719, this)) == null) ? this.s.b(this.F0) : invokeV.booleanValue;
    }

    public void i1() {
        wx7 wx7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048720, this) == null) || (wx7Var = this.h) == null) {
            return;
        }
        wx7Var.q();
    }

    public void i2(int i3, String str, int i4, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048721, this, new Object[]{Integer.valueOf(i3), str, Integer.valueOf(i4), Boolean.valueOf(z2)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(R.id.obfuscated_res_0x7f091e57, str);
            sparseArray.put(R.id.obfuscated_res_0x7f091e59, Integer.valueOf(i3));
            sparseArray.put(R.id.obfuscated_res_0x7f091e74, Integer.valueOf(i4));
            sparseArray.put(R.id.obfuscated_res_0x7f091e58, Boolean.valueOf(z2));
            sparseArray.put(c2, Integer.valueOf(d2));
            if (z2) {
                l3(sparseArray);
            } else {
                m3(i3, sparseArray);
            }
        }
    }

    public final boolean i3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048722, this)) == null) {
            PbFragment pbFragment = this.c;
            return (pbFragment == null || pbFragment.w().T0().l().getDeletedReasonInfo() == null || 1 != this.c.w().T0().l().getDeletedReasonInfo().is_grays_cale_forum.intValue()) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public void j0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048723, this) == null) {
            dr4 dr4Var = this.S;
            if (dr4Var != null) {
                dr4Var.dismiss();
            }
            Dialog dialog = this.T;
            if (dialog != null) {
                rg.b(dialog, this.c.getPageContext());
            }
            Dialog dialog2 = this.U;
            if (dialog2 != null) {
                rg.b(dialog2, this.c.getPageContext());
            }
            mr4 mr4Var = this.Q;
            if (mr4Var != null) {
                mr4Var.dismiss();
            }
        }
    }

    public void j1() {
        yt4 yt4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048724, this) == null) || (yt4Var = this.E0) == null) {
            return;
        }
        yt4Var.h(false);
    }

    public void j2(SparseArray<Object> sparseArray, boolean z2) {
        kr4 kr4Var;
        kr4 kr4Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048725, this, sparseArray, z2) == null) {
            or4 or4Var = new or4(this.c.getContext());
            or4Var.q(this.c.getString(R.string.obfuscated_res_0x7f0f02d4));
            or4Var.n(new l(this, z2));
            ArrayList arrayList = new ArrayList();
            int intValue = sparseArray.get(R.id.obfuscated_res_0x7f091e51) instanceof Integer ? ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091e51)).intValue() : -1;
            if (!"".equals(sparseArray.get(R.id.obfuscated_res_0x7f091e57)) && intValue != 2) {
                if ((sparseArray.get(R.id.obfuscated_res_0x7f091e59) instanceof Integer ? ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091e59)).intValue() : -1) == 0) {
                    kr4Var2 = new kr4(10, this.c.getString(R.string.obfuscated_res_0x7f0f04a0), or4Var);
                } else {
                    kr4Var2 = new kr4(10, this.c.getString(R.string.obfuscated_res_0x7f0f0495), or4Var);
                }
                SparseArray sparseArray2 = new SparseArray();
                sparseArray2.put(R.id.obfuscated_res_0x7f091e57, sparseArray.get(R.id.obfuscated_res_0x7f091e57));
                sparseArray2.put(R.id.obfuscated_res_0x7f091e59, sparseArray.get(R.id.obfuscated_res_0x7f091e59));
                sparseArray2.put(R.id.obfuscated_res_0x7f091e58, sparseArray.get(R.id.obfuscated_res_0x7f091e58));
                sparseArray2.put(R.id.obfuscated_res_0x7f091e74, sparseArray.get(R.id.obfuscated_res_0x7f091e74));
                kr4Var2.d.setTag(sparseArray2);
                arrayList.add(kr4Var2);
            }
            if ((!"".equals(sparseArray.get(R.id.obfuscated_res_0x7f091e62)) || !"".equals(sparseArray.get(R.id.obfuscated_res_0x7f091e63))) && !J1()) {
                SparseArray sparseArray3 = new SparseArray();
                sparseArray3.put(R.id.obfuscated_res_0x7f091e62, sparseArray.get(R.id.obfuscated_res_0x7f091e62));
                sparseArray3.put(R.id.obfuscated_res_0x7f091e63, sparseArray.get(R.id.obfuscated_res_0x7f091e63));
                sparseArray3.put(R.id.obfuscated_res_0x7f091e64, sparseArray.get(R.id.obfuscated_res_0x7f091e64));
                sparseArray3.put(R.id.obfuscated_res_0x7f091e74, sparseArray.get(R.id.obfuscated_res_0x7f091e74));
                sparseArray3.put(R.id.obfuscated_res_0x7f091e65, sparseArray.get(R.id.obfuscated_res_0x7f091e65));
                kr4 kr4Var3 = new kr4(11, this.c.getString(R.string.obfuscated_res_0x7f0f063d), or4Var);
                kr4Var3.d.setTag(sparseArray3);
                arrayList.add(kr4Var3);
            }
            if ((sparseArray.get(R.id.obfuscated_res_0x7f091eaa) instanceof Boolean) && ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091eaa)).booleanValue()) {
                SparseArray sparseArray4 = new SparseArray();
                sparseArray4.put(R.id.obfuscated_res_0x7f091e6c, sparseArray.get(R.id.obfuscated_res_0x7f091e6c));
                sparseArray4.put(R.id.obfuscated_res_0x7f091ea6, sparseArray.get(R.id.obfuscated_res_0x7f091ea6));
                sparseArray4.put(R.id.obfuscated_res_0x7f091ea7, sparseArray.get(R.id.obfuscated_res_0x7f091ea7));
                sparseArray4.put(R.id.obfuscated_res_0x7f091ea5, sparseArray.get(R.id.obfuscated_res_0x7f091ea5));
                sparseArray4.put(R.id.obfuscated_res_0x7f091ea8, sparseArray.get(R.id.obfuscated_res_0x7f091ea8));
                sparseArray4.put(R.id.obfuscated_res_0x7f091ea9, sparseArray.get(R.id.obfuscated_res_0x7f091ea9));
                sparseArray4.put(R.id.obfuscated_res_0x7f091ea4, sparseArray.get(R.id.obfuscated_res_0x7f091ea4));
                if (z2) {
                    kr4Var = new kr4(12, this.c.getString(R.string.obfuscated_res_0x7f0f1468), or4Var);
                } else {
                    kr4Var = new kr4(12, this.c.getString(R.string.obfuscated_res_0x7f0f0b15), or4Var);
                }
                kr4Var.d.setTag(sparseArray4);
                arrayList.add(kr4Var);
            }
            rx7.e(arrayList);
            if (UbsABTestHelper.isPBPlanA()) {
                or4Var.k(arrayList, false);
            } else {
                or4Var.k(arrayList, true);
            }
            mr4 mr4Var = new mr4(this.c.getPageContext(), or4Var);
            this.Q = mr4Var;
            mr4Var.m();
        }
    }

    public void j3() {
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048726, this) == null) {
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView != null) {
                pbLandscapeListView.setVisibility(0);
            }
            FrameLayout frameLayout = this.N0;
            if (frameLayout != null) {
                frameLayout.setVisibility(0);
            }
            wx7 wx7Var = this.h;
            if (wx7Var == null || (view2 = wx7Var.d) == null) {
                return;
            }
            view2.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
        }
    }

    public void k0() {
        rw7 rw7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048727, this) == null) || (rw7Var = this.r) == null) {
            return;
        }
        rw7Var.b();
    }

    public void k1() {
        Runnable runnable;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048728, this) == null) {
            if (this.y == null) {
                r1();
            }
            this.k.setVisibility(8);
            Handler handler = this.M1;
            if (handler == null || (runnable = this.N1) == null) {
                return;
            }
            handler.removeCallbacks(runnable);
        }
    }

    public void k2(View view2) {
        SparseArray<Object> sparseArray;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048729, this, view2) == null) || (sparseArray = (SparseArray) view2.getTag()) == null) {
            return;
        }
        j2(sparseArray, false);
    }

    public void k3() {
        rw7 rw7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048730, this) == null) || (rw7Var = this.r) == null) {
            return;
        }
        rw7Var.u(this.l);
    }

    public void l0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048731, this) == null) {
            PbListView pbListView = this.I;
            if (pbListView != null) {
                pbListView.x();
                this.I.f();
            }
            j1();
        }
    }

    public void l1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048732, this) == null) {
            this.M.setVisibility(8);
        }
    }

    public void l2(iz4 iz4Var, int i3) {
        FallingView fallingView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048733, this, iz4Var, i3) == null) || (fallingView = this.F1) == null) {
            return;
        }
        fallingView.A(iz4Var, this.c.getPageContext(), i3, false);
    }

    public final void l3(SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048734, this, sparseArray) == null) || this.c == null) {
            return;
        }
        if (sparseArray != null) {
            sparseArray.put(R.id.obfuscated_res_0x7f091e6b, Boolean.TRUE);
        }
        TBAlertConfig.a aVar = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f115a, TBAlertConfig.OperateBtnStyle.MAIN);
        TBAlertConfig.a aVar2 = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f036e, TBAlertConfig.OperateBtnStyle.SECONDARY);
        rr4 rr4Var = new rr4(this.c.x());
        rr4Var.v(R.string.obfuscated_res_0x7f0f0b11);
        rr4Var.l(R.string.obfuscated_res_0x7f0f0b12);
        rr4Var.n(true);
        rr4Var.r(aVar2, aVar);
        rr4Var.i(false);
        AlertDialog y2 = rr4Var.y();
        aVar.a(new p(this, y2, sparseArray));
        aVar2.a(new q(this, y2));
    }

    public void m0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048735, this) == null) {
            this.l.A(0L);
            i0();
        }
    }

    public void m1() {
        RightFloatLayerView rightFloatLayerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048736, this) == null) || (rightFloatLayerView = this.G1) == null) {
            return;
        }
        rightFloatLayerView.c();
    }

    public final void m2(PbReplyTitleViewHolder pbReplyTitleViewHolder, boolean z2) {
        int measuredHeight;
        int i3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048737, this, pbReplyTitleViewHolder, z2) == null) || this.g1 || this.P0 == null || this.h.p() == null) {
            return;
        }
        View r2 = r0().r();
        if (r2 != null) {
            int[] iArr = new int[2];
            r2.getLocationInWindow(iArr);
            int i4 = iArr[1];
            if (i4 != 0) {
                if (this.P0.getVisibility() == 0 && i4 - this.h.p().getBottom() <= this.P0.getHeight()) {
                    this.Q0.setVisibility(0);
                    if (i4 > this.h.p().getBottom()) {
                        i3 = -(((this.P0.getHeight() + this.Q0.getHeight()) + this.h.p().getBottom()) - r2.getBottom());
                    } else {
                        i3 = -this.P0.getHeight();
                    }
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.P0.getLayoutParams();
                    if (layoutParams.topMargin != i3) {
                        layoutParams.topMargin = i3;
                        this.P0.setLayoutParams(layoutParams);
                    }
                } else {
                    this.Q0.setVisibility(4);
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.P0.getLayoutParams();
                    if (layoutParams2.topMargin != 0) {
                        layoutParams2.topMargin = 0;
                        this.P0.setLayoutParams(layoutParams2);
                    }
                }
            }
        }
        int H = this.C.H();
        if (H > 0 && (pbReplyTitleViewHolder == null || pbReplyTitleViewHolder.b().getParent() == null)) {
            if (H > this.l.getFirstVisiblePosition() - this.l.getHeaderViewsCount()) {
                this.P0.setVisibility(4);
                return;
            }
            this.P0.setVisibility(0);
            n3(false);
            this.h.a.hideBottomLine();
            if (this.P0.getParent() == null || ((ViewGroup) this.P0.getParent()).getHeight() > this.P0.getTop()) {
                return;
            }
            this.P0.getParent().requestLayout();
        } else if (pbReplyTitleViewHolder != null && pbReplyTitleViewHolder.b() != null && pbReplyTitleViewHolder.g != null) {
            int top = pbReplyTitleViewHolder.b().getTop();
            if (pbReplyTitleViewHolder.b().getParent() != null) {
                if (this.V0) {
                    this.U0 = top;
                    this.V0 = false;
                }
                int i5 = this.U0;
                if (top < i5) {
                    i5 = top;
                }
                this.U0 = i5;
            }
            if (top != 0 || pbReplyTitleViewHolder.b().isShown()) {
                if (this.B.getY() < 0.0f) {
                    measuredHeight = a2 - pbReplyTitleViewHolder.g.getMeasuredHeight();
                } else {
                    measuredHeight = this.h.p().getMeasuredHeight() - pbReplyTitleViewHolder.g.getMeasuredHeight();
                    this.h.a.hideBottomLine();
                }
                if (pbReplyTitleViewHolder.b().getParent() == null && top <= this.U0) {
                    this.P0.setVisibility(0);
                    n3(false);
                } else if (top < measuredHeight) {
                    this.P0.setVisibility(0);
                    n3(false);
                } else {
                    this.P0.setVisibility(4);
                    this.h.a.hideBottomLine();
                }
                if (z2) {
                    this.V0 = true;
                }
            }
        } else if (this.l.getFirstVisiblePosition() == 0) {
            this.P0.setVisibility(4);
            this.h.a.hideBottomLine();
        }
    }

    public final void m3(int i3, SparseArray<Object> sparseArray) {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048738, this, i3, sparseArray) == null) || (pbFragment = this.c) == null || pbFragment.w() == null || this.c.w().T0() == null || this.c.w().T0().o() == null || this.c.w().T0().l() == null || this.c.w().T0().l().getDeletedReasonInfo() == null) {
            return;
        }
        if (sparseArray != null) {
            sparseArray.put(R.id.obfuscated_res_0x7f091e6b, Boolean.TRUE);
        }
        ai5 ai5Var = new ai5(this.c.w().T0().l().getDeletedReasonInfo().is_grays_cale_forum.intValue(), this.c.w().T0().l().getDeletedReasonInfo().is_boomgrow.intValue(), this.c.w().T0().o().has_forum_rule.intValue());
        ai5Var.i(this.c.w().T0().l().getId(), this.c.w().T0().l().getName());
        ai5Var.h(this.c.w().T0().l().getImage_url());
        ai5Var.j(this.c.w().T0().l().getUser_level());
        x3(sparseArray, i3, ai5Var, this.c.w().T0().U(), true);
    }

    public void n0(int i3, boolean z2, String str, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048739, this, new Object[]{Integer.valueOf(i3), Boolean.valueOf(z2), str, Boolean.valueOf(z3)}) == null) {
            this.c.hideProgressBar();
            if (z2 && z3) {
                PbFragment pbFragment = this.c;
                pbFragment.showToast(pbFragment.getPageContext().getString(R.string.obfuscated_res_0x7f0f11f9));
            } else if (z3) {
                if (ni.isEmpty(str)) {
                    str = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0c18);
                }
                this.c.showToast(str);
            }
        }
    }

    public void n1() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048740, this) == null) || (editorTools = this.k0) == null) {
            return;
        }
        editorTools.q();
    }

    public final void n2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048741, this) == null) {
            this.u.v(this.G0, this.H0, this.h1, this.g1);
        }
    }

    public void n3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048742, this, z2) == null) {
            this.m0.setVisibility(z2 ? 0 : 8);
        }
    }

    public void o0() {
        PbLandscapeListView pbLandscapeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048743, this) == null) || (pbLandscapeListView = this.l) == null) {
            return;
        }
        pbLandscapeListView.setForbidDragListener(true);
    }

    public final void o1() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048744, this) == null) && this.x == null && (pbFragment = this.c) != null) {
            this.x = new lw7(pbFragment.getContext());
        }
    }

    public void o2() {
        PbLandscapeListView pbLandscapeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048745, this) == null) || (pbLandscapeListView = this.l) == null) {
            return;
        }
        int headerViewsCount = pbLandscapeListView.getHeaderViewsCount() - this.f1;
        int firstVisiblePosition = (this.l.getFirstVisiblePosition() == 0 || this.l.getFirstVisiblePosition() + headerViewsCount < 0) ? 0 : this.l.getFirstVisiblePosition() + headerViewsCount;
        View childAt = this.l.getChildAt(0);
        int top = childAt != null ? childAt.getTop() : -1;
        this.W0.c = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.W0));
        PbReplyTitleViewHolder pbReplyTitleViewHolder = this.W0.c;
        int W0 = W0(pbReplyTitleViewHolder);
        int measuredHeight = this.B.getMeasuredHeight() + ((int) this.B.getY());
        boolean z2 = this.P0.getVisibility() == 0;
        boolean z3 = this.B.getY() < 0.0f;
        if ((z2 && pbReplyTitleViewHolder != null) || firstVisiblePosition >= this.C.H() + this.l.getHeaderViewsCount()) {
            int measuredHeight2 = pbReplyTitleViewHolder != null ? pbReplyTitleViewHolder.g.getMeasuredHeight() : 0;
            if (z3) {
                this.l.setSelectionFromTop(this.C.H() + this.l.getHeaderViewsCount(), a2 - measuredHeight2);
            } else {
                this.l.setSelectionFromTop(this.C.H() + this.l.getHeaderViewsCount(), this.h.p().getMeasuredHeight() - measuredHeight2);
            }
        } else {
            this.l.setSelectionFromTop(firstVisiblePosition, top);
        }
        if (this.g1 && this.r != null) {
            this.l.setSelectionFromTop(this.C.H() + this.l.getHeaderViewsCount(), this.r.d());
        } else if (this.I0 != 6) {
        } else {
            this.l.setOnLayoutListener(new a(this, W0, pbReplyTitleViewHolder, z2, measuredHeight, firstVisiblePosition, top));
        }
    }

    public void o3(boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048746, this, z2) == null) || this.q0 == null) {
            return;
        }
        G2(this.c.L4().C());
        if (this.l0) {
            s3(z2);
        } else {
            g1(z2);
        }
    }

    public final String p0(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048747, this, j2)) == null) {
            if (j2 == 0) {
                return "";
            }
            NumberFormat numberFormat = NumberFormat.getInstance();
            numberFormat.setRoundingMode(RoundingMode.HALF_UP);
            if (j2 > 9990000) {
                return "· · ·";
            }
            if (j2 >= 1000000) {
                numberFormat.setMaximumFractionDigits(0);
                return numberFormat.format(((float) j2) / 10000.0f) + "W";
            } else if (j2 >= 10000) {
                numberFormat.setMaximumFractionDigits(1);
                return numberFormat.format(((float) j2) / 10000.0f) + "W";
            } else {
                return "" + j2;
            }
        }
        return (String) invokeJ.objValue;
    }

    public final void p1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048748, this) == null) && this.t == null) {
            this.t = new ow7(this.c, this.i0);
        }
    }

    public final void p2(AgreeData agreeData, long j2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLJ(1048749, this, agreeData, j2) == null) || agreeData == null || !UbsABTestHelper.isLikeModifyTestA() || (textView = this.z0) == null) {
            return;
        }
        if (j2 > 0) {
            if (agreeData.agreeType == 2 && agreeData.hasAgree) {
                textView.setTextColor(SkinManager.getColor(R.color.CAM_X0301));
            } else {
                this.z0.setTextColor(SkinManager.getColor(R.color.CAM_X0107));
            }
            this.z0.setText(p0(j2));
            this.z0.setVisibility(0);
            return;
        }
        textView.setVisibility(8);
    }

    public void p3(yr7 yr7Var) {
        PostData postData;
        wx7 wx7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048750, this, yr7Var) == null) || yr7Var == null || (postData = this.H0) == null || postData.s() == null || (wx7Var = this.h) == null) {
            return;
        }
        boolean z2 = !this.g1;
        this.h1 = z2;
        wx7Var.G(z2);
        if (this.c.M4() != null) {
            this.c.M4().s(this.h1);
        }
        n2();
        PbFragment pbFragment = this.c;
        if (pbFragment != null && !pbFragment.isSimpleForum() && !ListUtils.isEmpty(yr7Var.p())) {
            oq4 oq4Var = yr7Var.p().get(0);
            if (oq4Var != null) {
                this.h.K(yr7Var, oq4Var.a(), oq4Var.b(), oq4Var.d(), oq4Var.getIsLike());
            }
        } else if (yr7Var.l() != null) {
            this.h.K(yr7Var, yr7Var.l().getName(), yr7Var.l().getId(), yr7Var.l().getImage_url(), yr7Var.l().isLike() == 1);
        }
        if (this.h1) {
            this.u.F(yr7Var, this.H0, this.f0);
            View view2 = this.R0;
            if (view2 != null) {
                view2.setVisibility(8);
            }
            if (this.q1 == null) {
                this.q1 = new d0(this);
            }
            this.l.setListViewDragListener(this.q1);
            return;
        }
        View view3 = this.R0;
        if (view3 != null) {
            view3.setVisibility(0);
        }
        this.u.F(yr7Var, this.H0, this.f0);
        this.q1 = null;
        this.l.setListViewDragListener(null);
    }

    public final String q0(int i3) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048751, this, i3)) == null) {
            if (i3 == 0) {
                return this.c.getString(R.string.obfuscated_res_0x7f0f0d98);
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

    public final void q1(yr7 yr7Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048752, this, yr7Var) == null) && yr7Var != null && yr7Var.O() != null && yr7Var.O().isInterviewLive() && this.M0 == null) {
            PbInterviewStatusView pbInterviewStatusView = (PbInterviewStatusView) this.L0.inflate();
            this.M0 = pbInterviewStatusView;
            pbInterviewStatusView.setOnClickListener(this.N);
            this.M0.setCallback(this.c.B4());
            this.M0.setData(this.c, yr7Var);
        }
    }

    public final void q2(yr7 yr7Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048753, this, yr7Var) == null) || yr7Var == null || yr7Var.O() == null) {
            return;
        }
        V3(yr7Var);
        if (yr7Var.r()) {
            WebPManager.setPureDrawable(this.w0, R.drawable.obfuscated_res_0x7f080928, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
        } else {
            WebPManager.setPureDrawable(this.w0, R.drawable.obfuscated_res_0x7f080927, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        }
        String q02 = q0(yr7Var.O().getReply_num());
        TextView textView = this.A0;
        if (textView != null) {
            textView.setText(q02);
        }
        TextView textView2 = this.B0;
        if (textView2 != null) {
            textView2.setText(q02);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921416, yr7Var.O()));
        p2(yr7Var.O().getAgreeData(), yr7Var.O().getAgreeNum());
        if (this.v0 == null || yr7Var.O() == null) {
            return;
        }
        this.v0.setThreadData(yr7Var.O());
        int i3 = 1;
        if (yr7Var.O().getAgreeData() != null) {
            yr7Var.O().getAgreeData().isInThread = true;
        }
        this.v0.setData(yr7Var.O().getAgreeData());
        wn4 wn4Var = new wn4();
        wn4Var.b = 4;
        wn4Var.h = 7;
        if (yr7Var.O().isVideoThreadType() && yr7Var.O().getThreadVideoInfo() != null) {
            i3 = 2;
        }
        wn4Var.c = i3;
        PbFragment pbFragment = this.c;
        if (pbFragment != null && pbFragment.w() != null) {
            wn4Var.j = this.c.w().getFromForumId();
            wn4Var.f = this.c.w().S0();
        }
        this.v0.setStatisticData(wn4Var);
    }

    public final void q3(SparseArray<Object> sparseArray, @StringRes int i3, @StringRes int i4) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(1048754, this, sparseArray, i3, i4) == null) || this.c == null) {
            return;
        }
        TBAlertConfig.a aVar = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f0495, TBAlertConfig.OperateBtnStyle.MAIN);
        TBAlertConfig.a aVar2 = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f036e, TBAlertConfig.OperateBtnStyle.SECONDARY);
        rr4 rr4Var = new rr4(this.c.x());
        rr4Var.v(i3);
        rr4Var.l(i4);
        rr4Var.n(true);
        rr4Var.r(aVar2, aVar);
        rr4Var.i(false);
        AlertDialog y2 = rr4Var.y();
        aVar.a(new n(this, y2, sparseArray));
        aVar2.a(new o(this, y2));
    }

    public ju7 r0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048755, this)) == null) ? this.C : (ju7) invokeV.objValue;
    }

    public final void r1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048756, this) == null) && this.c.D4()) {
            ViewStub viewStub = (ViewStub) this.d.findViewById(R.id.obfuscated_res_0x7f091384);
            this.k = viewStub;
            viewStub.setVisibility(0);
            if (this.y == null) {
                this.y = (LinearLayout) this.d.findViewById(R.id.obfuscated_res_0x7f091383);
                f95.a(this.c.getPageContext(), this.y);
            }
            if (this.z == null) {
                this.z = (TextView) this.y.findViewById(R.id.obfuscated_res_0x7f091388);
            }
            if (this.A == null) {
                this.A = (TextView) this.y.findViewById(R.id.obfuscated_res_0x7f091387);
            }
            this.z.setOnClickListener(this.N);
            this.A.setOnClickListener(this.N);
        }
    }

    public void r2(int i3, yr7 yr7Var, boolean z2, int i4) {
        PostData z0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048757, this, new Object[]{Integer.valueOf(i3), yr7Var, Boolean.valueOf(z2), Integer.valueOf(i4)}) == null) || i3 <= 0 || (z0 = z0(yr7Var, z2)) == null || z0.s() == null) {
            return;
        }
        MetaData s2 = z0.s();
        s2.setGiftNum(s2.getGiftNum() + i3);
    }

    public final boolean r3(yr7 yr7Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048758, this, yr7Var)) == null) {
            if (yr7Var == null || yr7Var.O() == null) {
                return false;
            }
            return yr7Var.O().getIsLive() == 1 || yr7Var.O().getThreadType() == 33 || !(yr7Var.O().getTopicData() == null || yr7Var.O().getTopicData().a() == 0) || yr7Var.O().getIs_top() == 1 || yr7Var.O().getIs_good() == 1 || yr7Var.O().isActInfo() || yr7Var.O().isInterviewLive() || yr7Var.O().isVoteThreadType() || yr7Var.O().getYulePostActivityData() != null || !ni.isEmpty(yr7Var.O().getCategory()) || yr7Var.O().isGodThread() || yr7Var.O().isRealGod();
        }
        return invokeL.booleanValue;
    }

    public LinearLayout s0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048759, this)) == null) ? this.r0 : (LinearLayout) invokeV.objValue;
    }

    public void s1() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048760, this) == null) || this.c == null || (editorTools = this.k0) == null) {
            return;
        }
        editorTools.j();
        if (this.c.L4() != null) {
            this.c.L4().P();
        }
        f1();
    }

    public void s2(yr7 yr7Var, boolean z2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048761, this, new Object[]{yr7Var, Boolean.valueOf(z2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            A3(yr7Var, z2, i3, i4);
            this.u.t(i4);
        }
    }

    public void s3(boolean z2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048762, this, z2) == null) || this.q0 == null || (textView = this.t0) == null) {
            return;
        }
        textView.setText(R.string.obfuscated_res_0x7f0f0507);
        if (z2) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(400L);
            this.q0.startAnimation(alphaAnimation);
        }
        this.p0.setVisibility(0);
        this.q0.setVisibility(0);
        this.C0 = true;
        if (this.X0 == null || this.p1.l()) {
            return;
        }
        this.X0.setVisibility(0);
        x2(true);
    }

    public View t0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048763, this)) == null) {
            View view2 = this.V;
            if (view2 != null) {
                return view2.findViewById(R.id.obfuscated_res_0x7f0907a2);
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    public final void t1(yr7 yr7Var, lw4 lw4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048764, this, yr7Var, lw4Var) == null) || this.H1 == null || yr7Var == null || lw4Var == null || this.c.getContext() == null) {
            return;
        }
        if (!RightFloatLayerView.k()) {
            m1();
            return;
        }
        if (this.G1 == null) {
            this.G1 = RightFloatLayerLottieView.F(lw4Var, this.c.getContext());
            this.H1.removeAllViews();
            this.H1.addView(this.G1);
        }
        if ((this.F1.getTag() instanceof Boolean) && !((Boolean) this.F1.getTag()).booleanValue()) {
            this.G1.setAutoCompleteShown(false);
            this.G1.setTag(this.F1);
            this.G1.c();
        }
        if (lw4Var.a()) {
            return;
        }
        this.G1.setData(lw4Var);
        this.G1.setLogoListener(new e0(this, lw4Var));
        this.G1.setFeedBackListener(new k0(this, lw4Var));
    }

    public final void t2() {
        PbInterviewStatusView pbInterviewStatusView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048765, this) == null) && (pbInterviewStatusView = this.M0) != null && pbInterviewStatusView.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.M0.getLayoutParams();
            layoutParams.setMargins(0, 0, 0, 0);
            this.M0.setLayoutParams(layoutParams);
        }
    }

    public void t3(View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048766, this, view2) == null) || wt4.k().h("show_long_press_collection_tips", false)) {
            return;
        }
        Rect rect = new Rect();
        this.q0.getGlobalVisibleRect(rect);
        int i3 = rect.bottom;
        int i4 = rect.top;
        view2.getGlobalVisibleRect(rect);
        int i5 = rect.bottom;
        FrameLayout frameLayout = new FrameLayout(this.c.getContext());
        frameLayout.setBackgroundResource(R.drawable.pic_sign_tip);
        TextView textView = new TextView(this.c.getContext());
        this.m1 = textView;
        textView.setText(R.string.obfuscated_res_0x7f0f042d);
        this.m1.setGravity(17);
        this.m1.setPadding(oi.f(this.c.getContext(), R.dimen.obfuscated_res_0x7f0701e8), 0, oi.f(this.c.getContext(), R.dimen.obfuscated_res_0x7f0701e8), 0);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        layoutParams.height = oi.f(this.c.getContext(), R.dimen.obfuscated_res_0x7f070253);
        if (this.m1.getParent() == null) {
            frameLayout.addView(this.m1, layoutParams);
        }
        PopupWindow popupWindow = new PopupWindow(this.c.getContext());
        this.l1 = popupWindow;
        popupWindow.setContentView(frameLayout);
        this.l1.setHeight(-2);
        this.l1.setWidth(-2);
        this.l1.setFocusable(true);
        this.l1.setOutsideTouchable(false);
        this.l1.setBackgroundDrawable(new ColorDrawable(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent)));
        this.l.postDelayed(new j0(this, i5, i3, i4, view2), 100L);
        wt4.k().u("show_long_press_collection_tips", true);
    }

    public String u0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048767, this)) == null) ? this.a0 : (String) invokeV.objValue;
    }

    public void u1(yr7 yr7Var) {
        lw4 pbAdFloatViewItemData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048768, this, yr7Var) == null) || yr7Var == null) {
            return;
        }
        if (yr7Var.k0()) {
            pbAdFloatViewItemData = yr7Var.Z();
        } else {
            pbAdFloatViewItemData = TbSingleton.getInstance().getPbAdFloatViewItemData();
        }
        if (pbAdFloatViewItemData != null && !pbAdFloatViewItemData.a()) {
            t1(yr7Var, pbAdFloatViewItemData);
        } else {
            m1();
        }
    }

    public void u2() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048769, this) == null) || this.f == 2) {
            return;
        }
        this.l.setNextPage(this.I);
        this.f = 2;
    }

    public void u3() {
        wx7 wx7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048770, this) == null) || (wx7Var = this.h) == null || this.i1) {
            return;
        }
        wx7Var.C();
        this.i1 = true;
    }

    public int v0() {
        InterceptResult invokeV;
        View childAt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048771, this)) == null) {
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

    public final void v1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048772, this) == null) && this.v == null) {
            this.v = new nw7(this.c, this.N);
        }
    }

    public void v2() {
        PbLandscapeListView pbLandscapeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048773, this) == null) || (pbLandscapeListView = this.l) == null) {
            return;
        }
        this.x.d(pbLandscapeListView);
        this.t.d(this.l);
        this.u.w(this.l);
        this.v.d(this.l);
        this.s.f(this.l);
    }

    public void v3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048774, this) == null) {
            this.l.setVisibility(0);
        }
    }

    public PostData w0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048775, this)) == null) {
            if (this.l == null) {
                return null;
            }
            int v0 = v0() - this.l.getHeaderViewsCount();
            int i3 = 0;
            if (v0 < 0) {
                v0 = 0;
            }
            if (this.C.y(v0) != null && this.C.y(v0) != PostData.w0) {
                i3 = v0 + 1;
            }
            if (this.C.x(i3) instanceof PostData) {
                return (PostData) this.C.x(i3);
            }
            return null;
        }
        return (PostData) invokeV.objValue;
    }

    public void w1(yr7 yr7Var) {
        PbReplyTitleViewHolder pbReplyTitleViewHolder;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048776, this, yr7Var) == null) {
            int i3 = 0;
            this.C.g0(yr7Var, false);
            this.C.Z();
            i0();
            ut7 ut7Var = this.p1;
            if (ut7Var != null) {
                ut7Var.n();
            }
            ArrayList<PostData> F = yr7Var.F();
            if (yr7Var.y().b() == 0 || F == null || F.size() < yr7Var.y().e()) {
                if (ListUtils.getCount(F) != 0 && (ListUtils.getCount(F) != 1 || F.get(0) == null || F.get(0).A() != 1)) {
                    if (yr7Var.y().b() == 0) {
                        this.I.C(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f09e6));
                    } else {
                        this.I.C(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0a2b));
                    }
                    this.I.k();
                } else {
                    q0 q0Var = this.W0;
                    if (q0Var != null && (pbReplyTitleViewHolder = q0Var.c) != null && pbReplyTitleViewHolder.b() != null) {
                        i3 = this.W0.c.b().getTop() < 0 ? this.W0.c.b().getHeight() : this.W0.c.b().getBottom();
                    }
                    if (this.c.k5()) {
                        this.I.F(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0db2), i3);
                    } else {
                        this.I.F(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0db3), i3);
                    }
                }
            }
            q2(yr7Var);
        }
    }

    public final void w2() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048777, this) == null) || (pbFragment = this.c) == null || pbFragment.L4() == null || this.k0 == null) {
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

    public void w3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048778, this) == null) {
            if (this.E0 == null) {
                this.E0 = new yt4(this.c.getPageContext());
            }
            this.E0.h(true);
        }
    }

    public FallingView x0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048779, this)) == null) ? this.F1 : (FallingView) invokeV.objValue;
    }

    public boolean x1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048780, this)) == null) ? this.S1 : invokeV.booleanValue;
    }

    public final void x2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048781, this, z2) == null) {
        }
    }

    public final void x3(SparseArray<Object> sparseArray, int i3, ai5 ai5Var, UserData userData, boolean z2) {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048782, this, new Object[]{sparseArray, Integer.valueOf(i3), ai5Var, userData, Boolean.valueOf(z2)}) == null) || (pbFragment = this.c) == null) {
            return;
        }
        if (this.v1 == null && this.s != null) {
            this.v1 = new bi5(pbFragment.getPageContext(), this.s.c(), ai5Var, userData);
        }
        this.v1.C(z2);
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
        mp4 mp4Var = new mp4();
        mp4Var.j(sparseArray2);
        this.v1.E(new String[]{this.c.getString(R.string.obfuscated_res_0x7f0f04a9), this.c.getString(R.string.obfuscated_res_0x7f0f04aa), this.c.getString(R.string.obfuscated_res_0x7f0f04ab), this.c.getString(R.string.obfuscated_res_0x7f0f04ac), this.c.getString(R.string.obfuscated_res_0x7f0f04ad)});
        this.v1.D(mp4Var);
        this.v1.G((i3 == 1 || i3 == 2) ? "4" : "3");
        this.v1.F(new s(this, sparseArray));
    }

    public int y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048783, this)) == null) ? A0(this.l.getFirstVisiblePosition()) : invokeV.intValue;
    }

    public boolean y1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048784, this)) == null) ? this.C0 : invokeV.booleanValue;
    }

    public void y2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048785, this) == null) {
            w2();
            h1();
            this.c1.c();
            o3(false);
        }
    }

    public void y3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048786, this) == null) {
            this.C.g0(this.G0, false);
            this.C.Z();
        }
    }

    public PostData z0(yr7 yr7Var, boolean z2) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048787, this, yr7Var, z2)) == null) {
            PostData postData = null;
            if (yr7Var == null) {
                return null;
            }
            if (yr7Var.W() != null) {
                return yr7Var.W();
            }
            if (!ListUtils.isEmpty(yr7Var.F())) {
                Iterator<PostData> it = yr7Var.F().iterator();
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
                postData = yr7Var.j();
            }
            if (!C1(postData)) {
                postData = U0(yr7Var);
            }
            if (postData != null && postData.s() != null && postData.s().getUserTbVipInfoData() != null && postData.s().getUserTbVipInfoData().getvipIntro() != null) {
                postData.s().getGodUserData().setIntro(postData.s().getUserTbVipInfoData().getvipIntro());
            }
            return postData;
        }
        return (PostData) invokeLZ.objValue;
    }

    public final boolean z1(yr7 yr7Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048788, this, yr7Var)) == null) {
            if (yr7Var == null || yr7Var.O() == null) {
                return false;
            }
            SpannableStringBuilder span_str = yr7Var.O().getSpan_str();
            if (span_str != null) {
                return TbadkApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0d99).equals(span_str.toString());
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void z2() {
        rw7 rw7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048789, this) == null) || (rw7Var = this.r) == null) {
            return;
        }
        rw7Var.q(this.l, this.O0, this.I0);
    }

    public void z3(yr7 yr7Var, int i3, int i4, boolean z2, int i5, boolean z3) {
        PbLandscapeListView pbLandscapeListView;
        int i6;
        PbReplyTitleViewHolder pbReplyTitleViewHolder;
        yr7 yr7Var2;
        Parcelable e3;
        Parcelable e4;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048790, this, new Object[]{yr7Var, Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z2), Integer.valueOf(i5), Boolean.valueOf(z3)}) == null) || yr7Var == null || this.l == null) {
            return;
        }
        this.G0 = yr7Var;
        this.I0 = i3;
        if (yr7Var.O() != null) {
            this.Y0 = yr7Var.O().getCopyThreadRemindType();
            if (yr7Var.O().getAnchorLevel() != 0) {
                this.S1 = true;
            }
            this.f0 = F1(yr7Var.O());
        }
        if (yr7Var.U() != null) {
            this.T1 = yr7Var.U().getUserId();
        }
        q1(yr7Var);
        X();
        this.K0 = false;
        this.F0 = z2;
        b3();
        hs7 hs7Var = yr7Var.h;
        if (hs7Var != null && hs7Var.b()) {
            if (this.o == null) {
                PbThreadPostView pbThreadPostView = new PbThreadPostView(this.c.getContext());
                this.o = pbThreadPostView;
                this.l.x(pbThreadPostView, 1);
                this.o.setData(yr7Var);
                this.o.setChildOnClickLinstener(this.N);
            }
        } else {
            PbThreadPostView pbThreadPostView2 = this.o;
            if (pbThreadPostView2 != null && (pbLandscapeListView = this.l) != null) {
                pbLandscapeListView.removeHeaderView(pbThreadPostView2);
            }
        }
        A3(yr7Var, z2, i3, TbadkCoreApplication.getInst().getSkinType());
        p3(yr7Var);
        this.u.G(yr7Var, this.H0);
        if (this.s1 == null) {
            this.s1 = new mv7(this.c.getPageContext(), this.t1);
        }
        this.s1.a(yr7Var.w());
        if (this.c.D4()) {
            if (this.H == null) {
                h08 h08Var = new h08(this.c.getPageContext());
                this.H = h08Var;
                h08Var.n();
                this.H.f(this.U1);
            }
            this.l.setPullRefresh(this.H);
            z2();
            h08 h08Var2 = this.H;
            if (h08Var2 != null) {
                h08Var2.H(TbadkCoreApplication.getInst().getSkinType());
            }
        } else if (yr7Var.y().c() == 0 && z2) {
            this.l.setPullRefresh(null);
        } else {
            if (this.H == null) {
                h08 h08Var3 = new h08(this.c.getPageContext());
                this.H = h08Var3;
                h08Var3.n();
                this.H.f(this.U1);
            }
            this.l.setPullRefresh(this.H);
            z2();
            h08 h08Var4 = this.H;
            if (h08Var4 != null) {
                h08Var4.H(TbadkCoreApplication.getInst().getSkinType());
            }
            j1();
        }
        i0();
        this.C.n0(this.F0);
        this.C.k0(false);
        this.C.l0(i3 == 5);
        this.C.m0(i3 == 6);
        this.C.i0(z3 && this.Q1 && i3 != 2);
        this.C.g0(yr7Var, false);
        this.C.Z();
        this.u.E(z0(yr7Var, z2), yr7Var.g0());
        if (yr7Var.O() != null && yr7Var.O().getPraise() != null && this.b != -1) {
            yr7Var.O().getPraise().setIsLike(this.b);
        }
        this.l.removeFooterView(this.T0);
        this.l.addFooterView(this.T0);
        if (TbadkCoreApplication.isLogin()) {
            this.l.setNextPage(this.I);
            this.f = 2;
            j1();
        } else {
            this.K0 = true;
            if (yr7Var.y().b() == 1) {
                if (this.J == null) {
                    PbFragment pbFragment = this.c;
                    this.J = new d08(pbFragment, pbFragment);
                }
                this.l.setNextPage(this.J);
            } else {
                this.l.setNextPage(this.I);
            }
            this.f = 3;
        }
        ArrayList<PostData> F = yr7Var.F();
        if (yr7Var.y().b() != 0 && F != null && F.size() >= yr7Var.y().e()) {
            if (z3) {
                if (this.Q1) {
                    l0();
                    if (yr7Var.y().b() != 0) {
                        this.I.C(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0daa));
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
                if (yr7Var.y().b() == 0) {
                    this.I.C(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f09e6));
                } else {
                    this.I.C(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0a2b));
                }
                this.I.k();
            } else {
                q0 q0Var = this.W0;
                if (q0Var == null || (pbReplyTitleViewHolder = q0Var.c) == null || pbReplyTitleViewHolder.b() == null) {
                    i6 = 0;
                } else {
                    i6 = this.W0.c.b().getTop() < 0 ? this.W0.c.b().getHeight() : this.W0.c.b().getBottom();
                }
                if (this.c.k5()) {
                    this.I.u(false);
                    if (ListUtils.isEmpty(yr7Var.R())) {
                        this.I.F(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0db2), i6);
                    }
                } else if (ListUtils.isEmpty(yr7Var.R())) {
                    this.I.F(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0db3), i6);
                }
                if (this.c.M4() != null && !this.c.M4().p()) {
                    this.c.M4().x();
                }
            }
            if (yr7Var.y().b() == 0 || F == null) {
                u2();
            }
        }
        if (i3 == 2) {
            this.l.setSelection(i4 > 1 ? (i4 + ((this.l.getData() == null && yr7Var.F() == null) ? 0 : (this.l.getData().size() - yr7Var.F().size()) + this.l.getHeaderViewsCount())) - 2 : 0);
        } else if (i3 != 3) {
            if (i3 == 4) {
                this.Q1 = false;
            } else if (i3 == 5) {
                this.l.setSelection(0);
            } else if (i3 != 6) {
                if (i3 == 8) {
                    if (i4 == 0) {
                        rw7 rw7Var = this.r;
                        if (rw7Var != null && rw7Var.c() != null) {
                            if (this.c.getBaseFragmentActivity().isUseStyleImmersiveSticky()) {
                                this.l.setSelectionFromTop((this.C.B() + this.l.getHeaderViewsCount()) - 1, this.r.d() - oi.r(this.c.getPageContext().getPageActivity()));
                            } else {
                                this.l.setSelectionFromTop((this.C.B() + this.l.getHeaderViewsCount()) - 1, this.r.d());
                            }
                        } else {
                            this.l.setSelection(this.C.B() + this.l.getHeaderViewsCount());
                        }
                    } else if (ListUtils.isEmpty(yr7Var.R())) {
                        this.l.setSelection(i4 > 0 ? i4 + ((this.l.getData() == null && yr7Var.F() == null) ? 0 : (this.l.getData().size() - yr7Var.F().size()) + this.l.getHeaderViewsCount()) : 0);
                    } else {
                        this.l.setSelection(yr7Var.F().size() + this.l.getHeaderViewsCount());
                    }
                    this.I.f();
                    this.I.C(this.c.getString(R.string.obfuscated_res_0x7f0f0dab));
                    this.I.x();
                }
            } else if (i5 == 1 && (e4 = rv7.b().e()) != null && !(e4 instanceof RecyclerView.SavedState)) {
                this.l.onRestoreInstanceState(e4);
            } else {
                this.l.setSelection(0);
            }
        } else if (i5 == 1 && (e3 = rv7.b().e()) != null && !(e3 instanceof RecyclerView.SavedState)) {
            this.l.post(new c0(this, e3, F, yr7Var));
        }
        if (this.Y0 == b2 && E1()) {
            c0();
        }
        if (this.e1) {
            o2();
            this.e1 = false;
            if (i5 == 0) {
                Q2(true);
            }
        }
        if (yr7Var.d == 1 || yr7Var.e == 1) {
            if (this.k1 == null) {
                this.k1 = new PbTopTipView(this.c.getContext());
            }
            if (yr7Var.e == 1 && "game_guide".equals(this.c.R4())) {
                this.k1.setText(this.c.getString(R.string.obfuscated_res_0x7f0f0dbe));
                this.k1.l(this.d, this.J0);
            } else if (yr7Var.d == 1 && "game_news".equals(this.c.R4())) {
                this.k1.setText(this.c.getString(R.string.obfuscated_res_0x7f0f0dbd));
                this.k1.l(this.d, this.J0);
            }
        }
        this.l.removeFooterView(this.D1.a());
        if (!ListUtils.isEmpty(yr7Var.I()) && yr7Var.y().b() == 0) {
            this.l.removeFooterView(this.T0);
            this.D1.d(Math.max(this.q0.getMeasuredHeight(), this.D0 / 2));
            this.l.addFooterView(this.D1.a());
            this.D1.f(yr7Var);
        }
        q2(yr7Var);
        if (yr7Var.e0() && this.c.w().G1() && this.c.O4() != null) {
            this.c.O4().d();
        }
        if (yr7Var.g() != 3) {
            u1(yr7Var);
        }
        this.t0.setText(TbSingleton.getInstance().getAdVertiComment(yr7Var.k0(), yr7Var.l0(), V0()));
        if (this.p == null || (yr7Var2 = this.G0) == null || yr7Var2.l() == null) {
            return;
        }
        this.p.m(this.G0.l().getImage_url());
        this.p.n(this.G0.l().getName());
        PbFragment pbFragment2 = this.c;
        if (pbFragment2 == null || pbFragment2.w() == null) {
            return;
        }
        this.p.o(this.c.w().b);
    }
}

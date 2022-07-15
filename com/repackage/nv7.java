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
import com.baidu.tbadk.core.dialog.TBAlertBuilder;
import com.baidu.tbadk.core.dialog.TBAlertConfig;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.DialogLoginHelper;
import com.baidu.tbadk.core.util.FirstPraiseToast;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.ReplyPrivacyCheckController;
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
import com.baidu.tbadk.core.view.NavigationBar;
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
import com.repackage.aw7;
import com.repackage.cr4;
import com.repackage.er4;
import com.repackage.fu4;
import com.repackage.js7;
import com.repackage.lj5;
import com.repackage.mu7;
import com.repackage.nq7;
import com.repackage.nr4;
import com.repackage.oj5;
import com.repackage.zh8;
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
public class nv7 {
    public static /* synthetic */ Interceptable $ic;
    public static final int g2;
    public static int h2;
    public static int i2;
    public static int j2;
    public static int k2;
    public static int l2;
    public static int m2;
    public static final int n2;
    public static int o2;
    public static zh8.f p2;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView A;
    public ImageView A0;
    public oj5 A1;
    public ObservedChangeRelativeLayout B;
    public HeadImageView B0;
    public String B1;
    public xt7 C;
    public View C0;
    public PermissionJudgePolicy C1;
    public cr4 D;
    public uz7 D0;
    public long D1;
    public er4 E;
    public TextView E0;
    public boolean E1;
    public View F;
    public TextView F0;
    public int F1;
    public EditText G;
    public TextView G0;
    public int G1;
    public vz7 H;
    public boolean H0;
    public boolean H1;
    public PbListView I;
    public int I0;
    public tz7 I1;
    public rz7 J;
    public au4 J0;
    public MaskView J1;
    public View K;
    public boolean K0;
    public final FallingView K1;
    public View L;
    public jr7 L0;
    public RightFloatLayerView L1;
    public View M;
    public PostData M0;
    public final FrameLayout M1;
    public View.OnClickListener N;
    public int N0;
    public boolean N1;
    public TbRichTextView.y O;
    public int O0;
    public String O1;
    public NoNetworkView.b P;
    public boolean P0;
    public CustomMessageListener P1;
    public lr4 Q;
    public ViewStub Q0;
    public View.OnClickListener Q1;
    public View.OnClickListener R;
    public PbInterviewStatusView R0;
    public CustomMessageListener R1;
    public cr4 S;
    public FrameLayout S0;
    public Handler S1;
    public Dialog T;
    public TextView T0;
    public Runnable T1;
    public Dialog U;
    public View U0;
    public CustomMessageListener U1;
    public View V;
    public View V0;
    public PbFragment.f3 V1;
    public LinearLayout W;
    public View W0;
    public boolean W1;
    public CompoundButton.OnCheckedChangeListener X;
    public PbReplyTitleViewHolder X0;
    public View.OnClickListener X1;
    public TextView Y;
    public View Y0;
    public boolean Y1;
    public TextView Z;
    public int Z0;
    public String Z1;
    public final ViewTreeObserver.OnGlobalLayoutListener a;
    public String a0;
    public boolean a1;
    public fu4.g a2;
    public int b;
    public lr4 b0;
    public w0 b1;
    public View.OnClickListener b2;
    public PbFragment c;
    public lr4 c0;
    public PbEmotionBar c1;
    public final List<TbImageView> c2;
    public RelativeLayout d;
    public gr4 d0;
    public int d1;
    public int d2;
    public View e;
    public boolean e0;
    public int e1;
    public boolean e2;
    public int f;
    public boolean f0;
    public Runnable f1;
    public boolean f2;
    public final Handler g;
    public String g0;
    public PbFakeFloorModel g1;
    public final kx7 h;
    public String h0;
    public ju7 h1;
    public jx7 i;
    public ls7 i0;
    public iv7 i1;
    public ViewStub j;
    public ScrollView j0;
    public boolean j1;
    public ViewStub k;
    public EditorTools k0;
    public int k1;
    public PbLandscapeListView l;
    public boolean l0;
    public boolean l1;
    public NoNetworkView m;
    public View m0;
    public boolean m1;
    public List<CustomBlueCheckRadioButton> n;
    public View n0;
    public boolean n1;
    public PbThreadPostView o;
    public EjectionAnimationView o0;
    public int o1;
    public nu7 p;
    public Button p0;
    public PbTopTipView p1;
    public mu7 q;
    public View q0;
    public PopupWindow q1;
    public gw7 r;
    public View r0;
    public TextView r1;
    public bw7 s;
    public LinearLayout s0;
    public List<String> s1;
    public dw7 t;
    public HeadImageView t0;
    public lw7 t1;
    public fw7 u;
    public ImageView u0;
    public jt7 u1;
    public cw7 v;
    public TextView v0;
    public PbLandscapeListView.c v1;
    public ew7 w;
    public WaterRippleView w0;
    public boolean w1;
    public aw7 x;
    public ImageView x0;
    public av7 x1;
    public LinearLayout y;
    public AgreeView y0;
    public NavigationBarCoverTip y1;
    public TextView z;
    public ImageView z0;
    public lj5 z1;

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
        public final /* synthetic */ nv7 g;

        /* renamed from: com.repackage.nv7$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class RunnableC0694a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public RunnableC0694a(a aVar) {
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
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.g.Y0 == null || this.a.g.Y0.getLayoutParams() == null) {
                    return;
                }
                ViewGroup.LayoutParams layoutParams = this.a.g.Y0.getLayoutParams();
                layoutParams.height = this.a.g.e1;
                this.a.g.Y0.setLayoutParams(layoutParams);
            }
        }

        public a(nv7 nv7Var, int i, PbReplyTitleViewHolder pbReplyTitleViewHolder, boolean z, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nv7Var, Integer.valueOf(i), pbReplyTitleViewHolder, Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = nv7Var;
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
                    int f1 = this.g.f1(this.b);
                    int i3 = this.a;
                    int i4 = f1 - i3;
                    if (this.c && i4 != 0 && i3 <= (i = this.d)) {
                        i4 = f1 - i;
                    }
                    if (this.g.Y0 == null || (layoutParams = this.g.Y0.getLayoutParams()) == null) {
                        return;
                    }
                    if (i4 == 0 || i4 > this.g.d.getMeasuredHeight() || f1 >= this.g.d.getMeasuredHeight()) {
                        layoutParams.height = this.g.e1;
                    } else {
                        if (layoutParams != null) {
                            int i5 = layoutParams.height;
                            if (i5 + i4 > 0 && i5 + i4 <= this.g.d.getMeasuredHeight()) {
                                layoutParams.height += i4;
                                this.g.l.setSelectionFromTop(this.e, this.f);
                            }
                        }
                        layoutParams.height = this.g.e1;
                    }
                    this.g.Y0.setLayoutParams(layoutParams);
                    qg.a().post(new RunnableC0694a(this));
                }
                this.g.l.setOnLayoutListener(null);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a0 implements CompoundButton.OnCheckedChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nv7 a;

        public a0(nv7 nv7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nv7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nv7Var;
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
    public class b implements is7 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nv7 a;

        public b(nv7 nv7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nv7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nv7Var;
        }

        @Override // com.repackage.is7
        public /* synthetic */ void onStart() {
            hs7.a(this);
        }

        @Override // com.repackage.is7
        public void onStop() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.o0.setVisibility(8);
                FirstPraiseToast.getInstance().show();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nv7 a;

        public b0(nv7 nv7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nv7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nv7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (this.a.U instanceof Dialog)) {
                sg.b(this.a.U, this.a.c.getPageContext());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements AgreeView.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nv7 a;

        /* loaded from: classes6.dex */
        public class a implements g15 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

            public a(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = cVar;
            }

            @Override // com.repackage.g15
            public void a(List<Bitmap> list) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
                    this.a.a.o0.setVisibility(0);
                    this.a.a.o0.setBitmaps(list);
                    Rect rect = new Rect();
                    this.a.a.y0.getImgAgree().getGlobalVisibleRect(rect);
                    this.a.a.o0.setAnchorPosition((rect.right + rect.left) / 2, (rect.bottom + rect.top) / 2);
                    this.a.a.o0.k();
                }
            }
        }

        public c(nv7 nv7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nv7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nv7Var;
        }

        @Override // com.baidu.tbadk.core.view.AgreeView.i
        public void onLongPress() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.x3();
                i15.g().c(new a(this));
            }
        }

        @Override // com.baidu.tbadk.core.view.AgreeView.i
        public void onRelease() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.I2();
                this.a.o0.l();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c0 implements nr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ er4.c a;
        public final /* synthetic */ nv7 b;

        public c0(nv7 nv7Var, er4.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nv7Var, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = nv7Var;
            this.a = cVar;
        }

        @Override // com.repackage.nr4.e
        public void N(nr4 nr4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, nr4Var, i, view2) == null) {
                this.b.c0.dismiss();
                this.a.a(null, i, view2);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nv7 a;

        public d(nv7 nv7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nv7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nv7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.y0 == null || this.a.y0.getData() == null) {
                return;
            }
            nv7 nv7Var = this.a;
            nv7Var.C2(nv7Var.y0.getData(), this.a.y0.getData().agreeNum);
            if (this.a.y0.E()) {
                return;
            }
            nv7 nv7Var2 = this.a;
            nv7Var2.x2(nv7Var2.y0);
        }
    }

    /* loaded from: classes6.dex */
    public class d0 implements nr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ er4.c a;
        public final /* synthetic */ nv7 b;

        public d0(nv7 nv7Var, er4.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nv7Var, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = nv7Var;
            this.a = cVar;
        }

        @Override // com.repackage.nr4.e
        public void N(nr4 nr4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, nr4Var, i, view2) == null) {
                this.b.c0.dismiss();
                this.a.a(null, i, view2);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nv7 a;

        public e(nv7 nv7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nv7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nv7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.C0.getVisibility() == 0) {
                    xt4.k().u("pb_share_red_dot_shown", true);
                    this.a.C0.setVisibility(8);
                }
                this.a.N.onClick(view2);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nv7 a;

        public e0(nv7 nv7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nv7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nv7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (!(view2 instanceof HeadImageView) || this.a.L0 == null || this.a.L0.O() == null || this.a.L0.O().getAuthor() == null || this.a.L0.O().getAuthor().getAlaInfo() == null || this.a.L0.O().getAuthor().getAlaInfo().live_status != 1) {
                    if (this.a.l1) {
                        TiebaStatic.log(new StatisticItem("c11923").param("obj_id", 2));
                    }
                    if (!this.a.l1 && this.a.L0 != null && this.a.L0.O() != null && this.a.L0.O().getAuthor() != null && this.a.L0.O().getAuthor().isBigV()) {
                        TiebaStatic.log(new StatisticItem("c12151").param("obj_locate", 1));
                    }
                    if (this.a.c.N() != null) {
                        this.a.c.N().d.b.onClick(view2);
                        return;
                    }
                    return;
                }
                StatisticItem statisticItem = new StatisticItem("c11851");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                TiebaStatic.log(statisticItem);
                StatisticItem statisticItem2 = new StatisticItem("c13715");
                statisticItem2.param("fid", this.a.L0.m());
                statisticItem2.param("fname", this.a.L0.n());
                statisticItem2.param("obj_param1", this.a.L0.O().getAuthor().getAlaInfo().user_info != null ? this.a.L0.O().getAuthor().getAlaInfo().user_info.user_id : 0L);
                statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem2.param("tid", this.a.L0.Q());
                statisticItem2.param(TiebaStatic.Params.OBJ_PARAM2, 1);
                statisticItem2.param(TiebaStatic.Params.OBJ_PARAM4, YYLiveUtil.calculateLiveType(this.a.L0.O().getAuthor().getAlaInfo()));
                if (this.a.L0.O().getAuthor().getAlaInfo().mYyExtData != null) {
                    statisticItem2.param(TiebaStatic.Params.OBJ_PARAM3, TiebaStatic.YYValues.YY_LIVE);
                    TiebaStaticHelper.addYYParam(statisticItem2, this.a.L0.O().getAuthor().getAlaInfo().mYyExtData);
                }
                TiebaStatic.log(statisticItem2);
                if (this.a.L0.O().getAuthor().getAlaInfo().isLegalYYLiveData()) {
                    YYLiveUtil.jumpYYLiveRoom(this.a.c.getPageContext(), this.a.L0.O().getAuthor().getAlaInfo(), YYLiveUtil.SOURCE_PB_LIVE_HEAD);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nv7 a;

        public f(nv7 nv7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nv7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nv7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            SparseArray<Object> sparseArray;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || (sparseArray = (SparseArray) view2.getTag()) == null) {
                return;
            }
            boolean booleanValue = sparseArray.get(R.id.obfuscated_res_0x7f091f30) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091f30)).booleanValue() : false;
            boolean booleanValue2 = sparseArray.get(R.id.obfuscated_res_0x7f091f44) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091f44)).booleanValue() : false;
            boolean booleanValue3 = sparseArray.get(R.id.obfuscated_res_0x7f091f2e) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091f2e)).booleanValue() : false;
            if (booleanValue) {
                if (booleanValue2) {
                    sparseArray.put(R.id.obfuscated_res_0x7f091f00, 1);
                    this.a.c.b5(sparseArray);
                    return;
                }
                this.a.w2(view2);
            } else if (booleanValue2) {
                sparseArray.put(R.id.obfuscated_res_0x7f091f00, 0);
                sparseArray.put(R.id.obfuscated_res_0x7f091ee9, 1);
                this.a.c.b5(sparseArray);
            } else if (booleanValue3) {
                this.a.r2(((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091ef1)).intValue(), (String) sparseArray.get(R.id.obfuscated_res_0x7f091eef), ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091f0c)).intValue(), ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091ef0)).booleanValue());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f0 implements aw7.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nv7 a;

        public f0(nv7 nv7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nv7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nv7Var;
        }

        @Override // com.repackage.aw7.a
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
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nv7 a;

        public g(nv7 nv7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nv7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nv7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.M2();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vw4 a;
        public final /* synthetic */ nv7 b;

        public g0(nv7 nv7Var, vw4 vw4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nv7Var, vw4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = nv7Var;
            this.a = vw4Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a == null || this.b.L0 == null || this.b.L1 == null) {
                return;
            }
            this.b.L1.g(this.a);
            this.b.L1.setAutoCompleteShown(false);
        }
    }

    /* loaded from: classes6.dex */
    public class h implements PbFakeFloorModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nv7 a;

        public h(nv7 nv7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nv7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nv7Var;
        }

        @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.b
        public void a(PostData postData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, postData) == null) {
                this.a.g1.R(postData);
                this.a.C.Y();
                this.a.h1.c();
                this.a.k0.q();
                this.a.D3(false);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nv7 a;

        public h0(nv7 nv7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nv7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nv7Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            nv7 nv7Var;
            kx7 kx7Var;
            LinearLayout linearLayout;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.C == null || (kx7Var = (nv7Var = this.a).h) == null || kx7Var.i == null || nv7Var.L0 == null || this.a.L0.O() == null || this.a.L0.O().isVideoThreadType() || this.a.Q1() || this.a.L0.l() == null || oi.isEmpty(this.a.L0.l().getName())) {
                return;
            }
            if ((this.a.C.I() == null || !this.a.C.I().isShown()) && (linearLayout = this.a.h.i) != null) {
                linearLayout.setVisibility(0);
                if (this.a.c == null || this.a.c.F() == null) {
                    return;
                }
                StatisticItem statisticItem = new StatisticItem("c13400");
                statisticItem.param("tid", this.a.c.F().j2());
                statisticItem.param("fid", this.a.c.F().getForumId());
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i implements FallingView.n {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nv7 a;

        public i(nv7 nv7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nv7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nv7Var;
        }

        @Override // com.baidu.tieba.pb.view.FallingView.n
        public void onAnimationEnd() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.X3();
            }
        }

        @Override // com.baidu.tieba.pb.view.FallingView.n
        public void onAnimationStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.K1.setTag(Boolean.FALSE);
                if (this.a.L1 == null) {
                    return;
                }
                this.a.L1.setAutoCompleteShown(false);
                if (this.a.L1.getVisibility() == 0) {
                    this.a.L1.setTag(this.a.K1);
                    this.a.L1.c();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ nv7 b;

        public i0(nv7 nv7Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nv7Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = nv7Var;
            this.a = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (pi.D()) {
                    UrlManager.getInstance().dealOneLink(this.b.c.getPageContext(), new String[]{this.a});
                    this.b.c.finish();
                    return;
                }
                this.b.c.showToast(R.string.obfuscated_res_0x7f0f0c2b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nv7 a;

        public j(nv7 nv7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nv7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nv7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.C0.getVisibility() == 0) {
                    xt4.k().u("pb_share_red_dot_shown", true);
                    this.a.C0.setVisibility(8);
                }
                this.a.N.onClick(this.a.A0);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Parcelable a;
        public final /* synthetic */ ArrayList b;
        public final /* synthetic */ jr7 c;
        public final /* synthetic */ nv7 d;

        public j0(nv7 nv7Var, Parcelable parcelable, ArrayList arrayList, jr7 jr7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nv7Var, parcelable, arrayList, jr7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = nv7Var;
            this.a = parcelable;
            this.b = arrayList;
            this.c = jr7Var;
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
                this.d.I.C(this.d.c.getString(R.string.obfuscated_res_0x7f0f0dc2));
                this.d.I.x();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class k implements nq7.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nv7 a;

        public k(nv7 nv7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nv7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nv7Var;
        }

        @Override // com.repackage.nq7.d
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.y0.P();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class k0 implements PbLandscapeListView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nv7 a;

        public k0(nv7 nv7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nv7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nv7Var;
        }

        @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.c
        public void a(int i, int i2, float f, float f2, float f3, float f4) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)}) == null) && this.a.c != null && this.a.c.isAdded()) {
                if (i < 0 && f > this.a.o1) {
                    this.a.m0();
                    this.a.i2();
                }
                this.a.v0();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class l extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nv7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(nv7 nv7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nv7Var, Integer.valueOf(i)};
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
            this.a = nv7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2005016 || this.a.C == null) {
                return;
            }
            this.a.C.Y();
        }
    }

    /* loaded from: classes6.dex */
    public class l0 implements cr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nv7 a;

        public l0(nv7 nv7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nv7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nv7Var;
        }

        @Override // com.repackage.cr4.e
        public void onClick(cr4 cr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cr4Var) == null) {
                this.a.m0();
                cr4Var.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class m implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nv7 a;

        public m(nv7 nv7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nv7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nv7Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.y == null) {
                    this.a.A1();
                }
                this.a.k.setVisibility(0);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class m0 implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nv7 a;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ m0 a;

            public a(m0 m0Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {m0Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = m0Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.a.c.HidenSoftKeyPad((InputMethodManager) this.a.a.c.getBaseFragmentActivity().getSystemService("input_method"), this.a.a.d);
                }
            }
        }

        public m0(nv7 nv7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nv7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nv7Var;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                if (this.a.f1 == null) {
                    this.a.f1 = new a(this);
                }
                qg.a().postDelayed(this.a.f1, 150L);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class n extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nv7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n(nv7 nv7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nv7Var, Integer.valueOf(i)};
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
            this.a = nv7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            this.a.H0 = false;
        }
    }

    /* loaded from: classes6.dex */
    public class n0 implements cr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public n0(nv7 nv7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nv7Var};
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
    public class o implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nv7 a;

        public o(nv7 nv7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nv7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nv7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.M2();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class o0 implements cr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public o0(nv7 nv7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nv7Var};
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
    public class p implements k15 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nv7 a;

        public p(nv7 nv7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nv7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nv7Var;
        }

        @Override // com.repackage.k15
        public void C(j15 j15Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, j15Var) == null) {
                Object obj = j15Var.c;
                if ((obj instanceof lx4) && EmotionGroupType.isSendAsPic(((lx4) obj).getType())) {
                    if (this.a.C1 == null) {
                        this.a.C1 = new PermissionJudgePolicy();
                    }
                    this.a.C1.clearRequestPermissionList();
                    this.a.C1.appendRequestPermission(this.a.c.getBaseFragmentActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (this.a.C1.startRequestPermission(this.a.c.getBaseFragmentActivity())) {
                        return;
                    }
                    lx4 lx4Var = (lx4) j15Var.c;
                    this.a.c.K5().h(lx4Var);
                    if (lx4Var.i()) {
                        this.a.c.K5().M(null, null);
                    } else {
                        this.a.c.K5().z(false, null);
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class p0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;
        public final /* synthetic */ View d;
        public final /* synthetic */ nv7 e;

        public p0(nv7 nv7Var, int i, int i2, int i3, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nv7Var, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = nv7Var;
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
                    this.e.q1.showAsDropDown(this.e.r0, this.d.getLeft(), -this.e.r0.getHeight());
                } else {
                    this.e.q1.showAsDropDown(this.d);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class q implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nv7 a;

        public q(nv7 nv7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nv7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nv7Var;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || this.a.c.J0 == null || this.a.c.J0.e() == null) {
                return;
            }
            if (!this.a.c.J0.e().e()) {
                this.a.c.J0.a(false);
            }
            this.a.c.J0.e().l(false);
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
            if (this.a.t1 == null) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(11);
                layoutParams.addRule(2, this.a.k0.getId());
                nv7 nv7Var = this.a;
                nv7Var.t1 = new lw7(nv7Var.c.getPageContext(), this.a.d, layoutParams);
                if (!ListUtils.isEmpty(this.a.s1)) {
                    this.a.t1.q(this.a.s1);
                }
                this.a.t1.r(this.a.k0);
            }
            this.a.t1.p(substring);
        }
    }

    /* loaded from: classes6.dex */
    public class q0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vw4 a;
        public final /* synthetic */ nv7 b;

        public q0(nv7 nv7Var, vw4 vw4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nv7Var, vw4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = nv7Var;
            this.a = vw4Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921664));
                this.b.L1.setHomePbFloatLastCloseTime();
                this.b.v1();
                this.b.L1.u(this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class r implements nr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ nv7 b;

        public r(nv7 nv7Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nv7Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = nv7Var;
            this.a = z;
        }

        @Override // com.repackage.nr4.e
        public void N(nr4 nr4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, nr4Var, i, view2) == null) {
                this.b.Q.dismiss();
                SparseArray<Object> sparseArray = (SparseArray) view2.getTag();
                if (sparseArray == null) {
                    return;
                }
                switch (i) {
                    case 10:
                        this.b.r2(((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091ef1)).intValue(), (String) sparseArray.get(R.id.obfuscated_res_0x7f091eef), ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091f0c)).intValue(), ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091ef0)).booleanValue());
                        return;
                    case 11:
                        if (this.b.V1 != null) {
                            this.b.V1.a(new Object[]{sparseArray.get(R.id.obfuscated_res_0x7f091f0c), sparseArray.get(R.id.obfuscated_res_0x7f091efa), sparseArray.get(R.id.obfuscated_res_0x7f091efd), sparseArray.get(R.id.obfuscated_res_0x7f091efb), sparseArray.get(R.id.obfuscated_res_0x7f091efc)});
                            return;
                        }
                        return;
                    case 12:
                        this.b.c.W5(this.a, (String) sparseArray.get(R.id.obfuscated_res_0x7f091f40), sparseArray);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class r0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nv7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public r0(nv7 nv7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nv7Var, Integer.valueOf(i)};
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
            this.a = nv7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2921306) {
                this.a.O1 = null;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class s implements cr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public s(nv7 nv7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nv7Var};
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
    public class s0 implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;
        public final /* synthetic */ nv7 b;

        public s0(nv7 nv7Var, PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nv7Var, pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = nv7Var;
            this.a = pbFragment;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.b.H1 || this.a == null || this.b.c.F() == null || !this.b.c.F().A2()) {
                return;
            }
            this.b.H1 = true;
            this.a.Y4(false);
        }
    }

    /* loaded from: classes6.dex */
    public class t implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlertDialog a;
        public final /* synthetic */ SparseArray b;
        public final /* synthetic */ nv7 c;

        public t(nv7 nv7Var, AlertDialog alertDialog, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nv7Var, alertDialog, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = nv7Var;
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
                if (!ni.A()) {
                    pi.N(this.c.c.N(), R.string.obfuscated_res_0x7f0f0c2b);
                } else {
                    this.c.c.j5(this.b, null);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class t0 implements js7.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nv7 a;

        public t0(nv7 nv7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nv7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nv7Var;
        }

        @Override // com.repackage.js7.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.c.Z5();
            }
        }

        @Override // com.repackage.js7.b
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
    public class u implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlertDialog a;

        public u(nv7 nv7Var, AlertDialog alertDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nv7Var, alertDialog};
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
    public class u0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ReplyPrivacyCheckController a;
        public final /* synthetic */ n35 b;
        public final /* synthetic */ nv7 c;

        public u0(nv7 nv7Var, ReplyPrivacyCheckController replyPrivacyCheckController, n35 n35Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nv7Var, replyPrivacyCheckController, n35Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = nv7Var;
            this.a = replyPrivacyCheckController;
            this.b = n35Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a == null || this.c.c == null || this.c.c.s5() == null || this.a.checkPrivacyBeforeInvokeEditor(this.c.c.s5().replyPrivateFlag)) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 1).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                    if (DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.c.c.getActivity(), LoginDialogData.PB_BOTTOM_REPLY_RESULT_PAGE))) {
                        this.c.k4();
                        this.b.x0();
                        this.c.s0();
                        return;
                    }
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 2).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class v implements zh8.f {
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

        @Override // com.repackage.zh8.f
        public void onRefresh() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public class v0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nv7 a;

        public v0(nv7 nv7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nv7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nv7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 1).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                if (DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.c.getActivity(), LoginDialogData.PB_BOTTOM_REPLY_RESULT_PAGE))) {
                    this.a.k4();
                    this.a.c.I6();
                    if (this.a.c == null || this.a.c.F() == null || this.a.c.F().R1() == null || this.a.c.F().R1().O() == null || this.a.c.F().R1().O().getAuthor() == null) {
                        return;
                    }
                    TiebaStatic.log(new StatisticItem("c13701").param("tid", this.a.c.F().k2()).param("fid", this.a.c.F().R1().m()).param("uid", TbadkCoreApplication.getCurrentAccountId()));
                    TiebaStatic.log(new StatisticItem("c13402").param("tid", this.a.c.F().b).param("fid", this.a.c.F().R1().m()).param("obj_locate", 1).param("uid", this.a.c.F().R1().O().getAuthor().getUserId()));
                    return;
                }
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 2).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class w implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlertDialog a;
        public final /* synthetic */ SparseArray b;
        public final /* synthetic */ nv7 c;

        public w(nv7 nv7Var, AlertDialog alertDialog, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nv7Var, alertDialog, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = nv7Var;
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
                if (!ni.A()) {
                    pi.N(this.c.c.N(), R.string.obfuscated_res_0x7f0f0c2b);
                } else {
                    this.c.c.j5(this.b, null);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class w0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public int b;
        public PbReplyTitleViewHolder c;

        public w0() {
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
    public class x implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlertDialog a;

        public x(nv7 nv7Var, AlertDialog alertDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nv7Var, alertDialog};
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
    public class y implements lj5.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cr4 a;
        public final /* synthetic */ nv7 b;

        public y(nv7 nv7Var, cr4 cr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nv7Var, cr4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = nv7Var;
            this.a = cr4Var;
        }

        @Override // com.repackage.lj5.g
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                this.b.c.k5(this.a, jSONArray);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class z implements oj5.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SparseArray a;
        public final /* synthetic */ nv7 b;

        public z(nv7 nv7Var, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nv7Var, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = nv7Var;
            this.a = sparseArray;
        }

        @Override // com.repackage.oj5.h
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                this.b.c.j5(this.a, jSONArray);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755455966, "Lcom/repackage/nv7;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755455966, "Lcom/repackage/nv7;");
                return;
            }
        }
        g2 = UtilHelper.getLightStatusBarHeight();
        h2 = 3;
        i2 = 0;
        j2 = 3;
        k2 = 4;
        l2 = 5;
        m2 = 6;
        n2 = pi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds80);
        o2 = 1;
        p2 = new v();
    }

    public nv7(PbFragment pbFragment, View.OnClickListener onClickListener, ls7 ls7Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pbFragment, onClickListener, ls7Var};
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
        this.v0 = null;
        this.H0 = true;
        this.J0 = null;
        this.K0 = false;
        this.O0 = 3;
        this.P0 = false;
        this.Q0 = null;
        this.Z0 = 0;
        this.a1 = true;
        this.b1 = new w0();
        this.d1 = 0;
        this.j1 = false;
        this.k1 = 0;
        this.l1 = false;
        this.m1 = false;
        this.n1 = false;
        this.o1 = 0;
        this.w1 = false;
        this.D1 = 0L;
        this.G1 = 0;
        this.P1 = new r0(this, 2921306);
        this.Q1 = new j(this);
        this.R1 = new l(this, 2005016);
        this.S1 = new Handler();
        this.U1 = new n(this, 2004009);
        this.W1 = true;
        this.X1 = new e0(this);
        this.Y1 = false;
        this.Z1 = null;
        this.c2 = new ArrayList();
        this.e2 = false;
        this.D1 = System.currentTimeMillis();
        this.c = pbFragment;
        this.N = onClickListener;
        this.i0 = ls7Var;
        this.o1 = pi.k(pbFragment.getContext()) / 8;
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.c.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d05fe, (ViewGroup) null);
        this.d = relativeLayout;
        relativeLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.m0 = this.d.findViewById(R.id.obfuscated_res_0x7f0903d5);
        this.y1 = (NavigationBarCoverTip) this.d.findViewById(R.id.obfuscated_res_0x7f091778);
        this.e = this.d.findViewById(R.id.obfuscated_res_0x7f091e32);
        this.M1 = (FrameLayout) this.d.findViewById(R.id.obfuscated_res_0x7f091b37);
        this.B = (ObservedChangeRelativeLayout) this.d.findViewById(R.id.obfuscated_res_0x7f0920f0);
        this.m = (NoNetworkView) this.d.findViewById(R.id.obfuscated_res_0x7f092439);
        this.l = (PbLandscapeListView) this.d.findViewById(R.id.obfuscated_res_0x7f0915c3);
        this.S0 = (FrameLayout) this.d.findViewById(R.id.obfuscated_res_0x7f091b66);
        this.T0 = new TextView(this.c.getActivity());
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + pi.f(this.c.getActivity(), R.dimen.obfuscated_res_0x7f070308));
        this.l.x(this.T0, 0);
        this.l.setTextViewAdded(true);
        this.e1 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds134);
        this.Y0 = new View(this.c.getPageContext().getPageActivity());
        if (ci5.a()) {
            this.Y0.setLayoutParams(new AbsListView.LayoutParams(-1, 0));
        } else {
            this.Y0.setLayoutParams(new AbsListView.LayoutParams(-1, this.e1));
        }
        this.Y0.setVisibility(4);
        this.l.addFooterView(this.Y0);
        this.l.setOnTouchListener(this.c.I2);
        this.a = new s0(this, pbFragment);
        this.l.getViewTreeObserver().addOnGlobalLayoutListener(this.a);
        this.h = new kx7(pbFragment, this.d);
        if (this.c.C5()) {
            ViewStub viewStub = (ViewStub) this.d.findViewById(R.id.obfuscated_res_0x7f0913fc);
            this.j = viewStub;
            viewStub.setVisibility(0);
            jx7 jx7Var = new jx7(pbFragment);
            this.i = jx7Var;
            jx7Var.c();
            this.h.a.setVisibility(8);
            layoutParams.height = pi.f(this.c.getActivity(), R.dimen.obfuscated_res_0x7f07023e);
        }
        this.T0.setLayoutParams(layoutParams);
        this.h.p().setOnTouchListener(new js7(new t0(this)));
        this.q0 = this.d.findViewById(R.id.obfuscated_res_0x7f09241f);
        this.r0 = this.d.findViewById(R.id.obfuscated_res_0x7f091719);
        pi.f(TbadkCoreApplication.getInst(), R.dimen.tbds120);
        this.I0 = pi.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f070286);
        this.u0 = (ImageView) this.d.findViewById(R.id.obfuscated_res_0x7f09083e);
        this.u0.setOnClickListener(new u0(this, new ReplyPrivacyCheckController(this.c.getPageContext()), this.c.K5()));
        Y1();
        t0();
        this.v0 = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f09171c);
        LinearLayout linearLayout = (LinearLayout) this.d.findViewById(R.id.obfuscated_res_0x7f091714);
        this.s0 = linearLayout;
        linearLayout.setOnClickListener(new v0(this));
        EjectionAnimationView ejectionAnimationView = (EjectionAnimationView) this.d.findViewById(R.id.obfuscated_res_0x7f090842);
        this.o0 = ejectionAnimationView;
        ejectionAnimationView.setEjectionAnimationViewCallback(new b(this));
        this.x0 = (ImageView) this.d.findViewById(R.id.obfuscated_res_0x7f09171a);
        this.J1 = (MaskView) this.d.findViewById(R.id.obfuscated_res_0x7f09141d);
        this.x0.setOnClickListener(this.N);
        AgreeView agreeView = (AgreeView) this.d.findViewById(R.id.obfuscated_res_0x7f091716);
        this.y0 = agreeView;
        agreeView.setAgreeAlone(true);
        this.y0.s();
        this.y0.setAgreeLongClickListener(new c(this));
        this.y0.setAfterClickListener(new d(this));
        this.y0.setUseDynamicLikeRes("/pb");
        if (this.y0.getAgreeNumView() != null) {
            this.y0.getAgreeNumView().setVisibility(8);
        }
        if (this.y0.getMsgData() != null) {
            this.y0.getMsgData().a = BdUniqueId.gen();
        }
        boolean booleanExtra = this.c.getBaseFragmentActivity().getIntent().getBooleanExtra("key_is_from_dynamic", false);
        ImageView imageView = (ImageView) this.d.findViewById(R.id.obfuscated_res_0x7f091718);
        this.z0 = imageView;
        imageView.setOnClickListener(this.N);
        if (booleanExtra) {
            this.z0.setVisibility(8);
        } else {
            this.z0.setVisibility(0);
        }
        View findViewById = this.d.findViewById(R.id.obfuscated_res_0x7f09171f);
        this.C0 = findViewById;
        findViewById.setVisibility((xt4.k().h("pb_share_red_dot_shown", false) || !TbadkCoreApplication.isLogin()) ? 8 : 0);
        this.A0 = (ImageView) this.d.findViewById(R.id.obfuscated_res_0x7f09171d);
        HeadImageView headImageView = (HeadImageView) this.d.findViewById(R.id.obfuscated_res_0x7f09171e);
        this.B0 = headImageView;
        headImageView.setIsRound(true);
        this.B0.setOnClickListener(this.Q1);
        this.A0.setOnClickListener(new e(this));
        a2();
        uz7 uz7Var = new uz7(this.A0);
        this.D0 = uz7Var;
        uz7Var.n(this.B0);
        if (!UbsABTestHelper.isResizeInduceSharingABTest() && !UbsABTestHelper.isResizeInduceSharingABTestA()) {
            this.D0.f();
        }
        TextView textView = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f09171b);
        this.F0 = textView;
        textView.setVisibility(0);
        this.E0 = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f091717);
        this.Q0 = (ViewStub) this.d.findViewById(R.id.obfuscated_res_0x7f090f13);
        this.y0.setVisibility(0);
        this.E0.setVisibility(0);
        this.s = new bw7(this.c, ls7Var);
        this.u = new fw7(this.c, ls7Var, this.N);
        xt7 xt7Var = new xt7(this.c, this.l);
        this.C = xt7Var;
        xt7Var.u0(this.N);
        this.C.w0(this.i0);
        this.C.r0(this.O);
        this.C.t0(this.c.g2);
        this.C.o0(this.b2);
        f fVar = new f(this);
        this.R = fVar;
        this.C.q0(fVar);
        E1();
        y1();
        ew7 ew7Var = new ew7(this.c);
        this.w = ew7Var;
        ew7Var.f = 2;
        x1();
        this.x.a(this.l);
        this.u.m(this.l);
        this.t.a(this.l);
        this.s.a(this.l);
        PbListView pbListView = new PbListView(this.c.getPageContext().getPageActivity());
        this.I = pbListView;
        this.K = pbListView.b().findViewById(R.id.obfuscated_res_0x7f091768);
        this.L = this.I.b().findViewById(R.id.obfuscated_res_0x7f091705);
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
        this.M = this.d.findViewById(R.id.obfuscated_res_0x7f092455);
        this.c.registerListener(this.U1);
        this.g1 = new PbFakeFloorModel(this.c.getPageContext());
        PbModel F = this.c.F();
        this.g1.T(F.J(), F.F(), F.G(), F.E(), F.K());
        ju7 ju7Var = new ju7(this.c.getPageContext(), this.g1, this.d);
        this.h1 = ju7Var;
        ju7Var.k(new g(this));
        this.h1.n(this.c.k2);
        this.g1.V(new h(this));
        if (this.c.F() != null && !StringUtils.isNull(this.c.F().U1())) {
            PbFragment pbFragment2 = this.c;
            pbFragment2.showToast(pbFragment2.F().U1());
        }
        this.U0 = this.d.findViewById(R.id.obfuscated_res_0x7f091721);
        this.V0 = this.d.findViewById(R.id.obfuscated_res_0x7f0903d3);
        View findViewById2 = this.d.findViewById(R.id.obfuscated_res_0x7f091e3d);
        this.W0 = findViewById2;
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) findViewById2.getLayoutParams();
        if (this.c.F() != null && this.c.F().D1()) {
            this.U0.setVisibility(0);
            if (layoutParams2 != null) {
                layoutParams2.height = 0;
                this.W0.setLayoutParams(layoutParams2);
            }
        } else if (layoutParams2 != null) {
            layoutParams2.height = g2;
            this.W0.setLayoutParams(layoutParams2);
        }
        PbReplyTitleViewHolder pbReplyTitleViewHolder = new PbReplyTitleViewHolder(this.c.getPageContext(), this.d.findViewById(R.id.obfuscated_res_0x7f091796));
        this.X0 = pbReplyTitleViewHolder;
        pbReplyTitleViewHolder.r(pbFragment.k0);
        this.X0.g.setVisibility(8);
        this.X0.q(this.N);
        this.X0.p(this.c.g2);
        this.c.registerListener(this.R1);
        this.c.registerListener(this.P1);
        PbFragment pbFragment3 = this.c;
        this.I1 = new tz7(pbFragment3, pbFragment3.getUniqueId());
        this.K1 = (FallingView) this.d.findViewById(R.id.obfuscated_res_0x7f09094d);
        S2();
        this.K1.setAnimationListener(new i(this));
        h0();
        L2(false);
        this.n0 = this.d.findViewById(R.id.obfuscated_res_0x7f09170b);
        g0(ci5.a());
        if (UbsABTestHelper.isPbForumGuideTestA() && F.E2() && oq7.b().e()) {
            if (this.p == null) {
                this.p = new nu7(this.c.getActivity(), (ViewGroup) m1().findViewById(R.id.obfuscated_res_0x7f091740));
            }
            mu7 mu7Var = new mu7(this.l);
            this.q = mu7Var;
            mu7Var.d(new mu7.a() { // from class: com.repackage.ot7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.repackage.mu7.a
                public final void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        nv7.this.V1();
                    }
                }
            });
        }
    }

    public xt7 A0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.C : (xt7) invokeV.objValue;
    }

    public final void A1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.c.C5()) {
            ViewStub viewStub = (ViewStub) this.d.findViewById(R.id.obfuscated_res_0x7f0913f7);
            this.k = viewStub;
            viewStub.setVisibility(0);
            if (this.y == null) {
                this.y = (LinearLayout) this.d.findViewById(R.id.obfuscated_res_0x7f0913f6);
                ga5.a(this.c.getPageContext(), this.y);
            }
            if (this.z == null) {
                this.z = (TextView) this.y.findViewById(R.id.obfuscated_res_0x7f0913fb);
            }
            if (this.A == null) {
                this.A = (TextView) this.y.findViewById(R.id.obfuscated_res_0x7f0913fa);
            }
            this.z.setOnClickListener(this.N);
            this.A.setOnClickListener(this.N);
        }
    }

    public final void A2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.u.A(this.L0, this.M0, this.m1, this.l1);
        }
    }

    public final void A3(SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, sparseArray) == null) || this.c == null) {
            return;
        }
        if (sparseArray != null) {
            sparseArray.put(R.id.obfuscated_res_0x7f091f03, Boolean.TRUE);
        }
        TBAlertConfig.a aVar = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f1189, TBAlertConfig.OperateBtnStyle.MAIN);
        TBAlertConfig.a aVar2 = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f036a, TBAlertConfig.OperateBtnStyle.SECONDARY);
        TBAlertBuilder tBAlertBuilder = new TBAlertBuilder(this.c.N());
        tBAlertBuilder.t(R.string.obfuscated_res_0x7f0f0b1b);
        tBAlertBuilder.l(R.string.obfuscated_res_0x7f0f0b1c);
        tBAlertBuilder.n(true);
        tBAlertBuilder.r(aVar2, aVar);
        tBAlertBuilder.i(false);
        AlertDialog w2 = tBAlertBuilder.w();
        aVar.a(new w(this, w2, sparseArray));
        aVar2.a(new x(this, w2));
    }

    public LinearLayout B0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.s0 : (LinearLayout) invokeV.objValue;
    }

    public void B1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.c != null && this.k0 != null) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 9).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                this.k0.j();
                if (this.c.K5() != null) {
                    this.c.K5().Q();
                }
                o1();
                return;
            }
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 20).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
        }
    }

    public void B2() {
        PbLandscapeListView pbLandscapeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (pbLandscapeListView = this.l) == null) {
            return;
        }
        int headerViewsCount = pbLandscapeListView.getHeaderViewsCount() - this.k1;
        int firstVisiblePosition = (this.l.getFirstVisiblePosition() == 0 || this.l.getFirstVisiblePosition() + headerViewsCount < 0) ? 0 : this.l.getFirstVisiblePosition() + headerViewsCount;
        View childAt = this.l.getChildAt(0);
        int top = childAt != null ? childAt.getTop() : -1;
        this.b1.c = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.b1));
        PbReplyTitleViewHolder pbReplyTitleViewHolder = this.b1.c;
        int f1 = f1(pbReplyTitleViewHolder);
        int measuredHeight = this.B.getMeasuredHeight() + ((int) this.B.getY());
        boolean z2 = this.U0.getVisibility() == 0;
        boolean z3 = this.B.getY() < 0.0f;
        if ((z2 && pbReplyTitleViewHolder != null) || firstVisiblePosition >= this.C.G() + this.l.getHeaderViewsCount()) {
            int measuredHeight2 = pbReplyTitleViewHolder != null ? pbReplyTitleViewHolder.g.getMeasuredHeight() : 0;
            if (z3) {
                this.l.setSelectionFromTop(this.C.G() + this.l.getHeaderViewsCount(), g2 - measuredHeight2);
            } else {
                this.l.setSelectionFromTop(this.C.G() + this.l.getHeaderViewsCount(), this.h.p().getMeasuredHeight() - measuredHeight2);
            }
        } else {
            this.l.setSelectionFromTop(firstVisiblePosition, top);
        }
        if (this.l1 && this.r != null) {
            this.l.setSelectionFromTop(this.C.G() + this.l.getHeaderViewsCount(), this.r.d());
        } else if (this.N0 != 6) {
        } else {
            this.l.setOnLayoutListener(new a(this, f1, pbReplyTitleViewHolder, z2, measuredHeight, firstVisiblePosition, top));
        }
    }

    public final void B3(int i3, SparseArray<Object> sparseArray) {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048583, this, i3, sparseArray) == null) || (pbFragment = this.c) == null || pbFragment.F() == null || this.c.F().R1() == null || this.c.F().R1().o() == null || this.c.F().R1().l() == null || this.c.F().R1().l().getDeletedReasonInfo() == null) {
            return;
        }
        if (sparseArray != null) {
            sparseArray.put(R.id.obfuscated_res_0x7f091f03, Boolean.TRUE);
        }
        nj5 nj5Var = new nj5(this.c.F().R1().l().getDeletedReasonInfo().is_grays_cale_forum.intValue(), this.c.F().R1().l().getDeletedReasonInfo().is_boomgrow.intValue(), this.c.F().R1().o().has_forum_rule.intValue());
        nj5Var.i(this.c.F().R1().l().getId(), this.c.F().R1().l().getName());
        nj5Var.h(this.c.F().R1().l().getImage_url());
        nj5Var.j(this.c.F().R1().l().getUser_level());
        M3(sparseArray, i3, nj5Var, this.c.F().R1().U(), true);
    }

    public View C0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            View view2 = this.V;
            if (view2 != null) {
                return view2.findViewById(R.id.obfuscated_res_0x7f090776);
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    public final void C1(jr7 jr7Var, vw4 vw4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048585, this, jr7Var, vw4Var) == null) || this.M1 == null || jr7Var == null || vw4Var == null || this.c.getContext() == null) {
            return;
        }
        if (!RightFloatLayerView.k()) {
            v1();
            return;
        }
        if (this.L1 == null) {
            this.L1 = RightFloatLayerLottieView.F(vw4Var, this.c.getContext());
            this.M1.removeAllViews();
            this.M1.addView(this.L1);
        }
        if ((this.K1.getTag() instanceof Boolean) && !((Boolean) this.K1.getTag()).booleanValue()) {
            this.L1.setAutoCompleteShown(false);
            this.L1.setTag(this.K1);
            this.L1.c();
        }
        if (vw4Var.a()) {
            return;
        }
        this.L1.setData(vw4Var);
        this.L1.setLogoListener(new g0(this, vw4Var));
        this.L1.setFeedBackListener(new q0(this, vw4Var));
    }

    public final void C2(AgreeData agreeData, long j3) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLJ(1048586, this, agreeData, j3) == null) || agreeData == null || (textView = this.E0) == null) {
            return;
        }
        if (j3 > 0) {
            if (agreeData.agreeType == 2 && agreeData.hasAgree) {
                textView.setTextColor(SkinManager.getColor(R.color.CAM_X0301));
            } else {
                this.E0.setTextColor(SkinManager.getColor(R.color.CAM_X0107));
            }
            this.E0.setText(y0(j3));
            this.E0.setVisibility(0);
            return;
        }
        textView.setVisibility(8);
    }

    public void C3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z2) == null) {
            this.m0.setVisibility(z2 ? 0 : 8);
        }
    }

    public String D0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.a0 : (String) invokeV.objValue;
    }

    public void D1(jr7 jr7Var) {
        vw4 pbAdFloatViewItemData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, jr7Var) == null) || jr7Var == null) {
            return;
        }
        if (jr7Var.k0()) {
            pbAdFloatViewItemData = jr7Var.Z();
        } else {
            pbAdFloatViewItemData = TbSingleton.getInstance().getPbAdFloatViewItemData();
        }
        if (pbAdFloatViewItemData != null && !pbAdFloatViewItemData.a()) {
            C1(jr7Var, pbAdFloatViewItemData);
        } else {
            v1();
        }
    }

    public final void D2(jr7 jr7Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, jr7Var) == null) || jr7Var == null || jr7Var.O() == null) {
            return;
        }
        l4(jr7Var);
        ImageView imageView = this.z0;
        if (imageView != null && imageView.getContext() != null) {
            if (jr7Var.r()) {
                WebPManager.setPureDrawable(this.z0, R.drawable.obfuscated_res_0x7f080940, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
            } else {
                WebPManager.setPureDrawable(this.z0, R.drawable.obfuscated_res_0x7f08093f, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            }
        }
        String z0 = z0(jr7Var.O().getReply_num());
        TextView textView = this.F0;
        if (textView != null) {
            textView.setText(z0);
        }
        TextView textView2 = this.G0;
        if (textView2 != null) {
            textView2.setText(z0);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921416, jr7Var.O()));
        C2(jr7Var.O().getAgreeData(), jr7Var.O().getAgreeNum());
        if (this.y0 == null || jr7Var.O() == null) {
            return;
        }
        this.y0.setThreadData(jr7Var.O());
        int i3 = 1;
        if (jr7Var.O().getAgreeData() != null) {
            jr7Var.O().getAgreeData().isInThread = true;
        }
        this.y0.setData(jr7Var.O().getAgreeData());
        tn4 tn4Var = new tn4();
        tn4Var.b = 26;
        if (jr7Var.O().isVideoThreadType() && jr7Var.O().getThreadVideoInfo() != null) {
            i3 = 2;
        }
        tn4Var.c = i3;
        PbFragment pbFragment = this.c;
        if (pbFragment != null && pbFragment.F() != null) {
            tn4Var.j = this.c.F().getFromForumId();
            tn4Var.f = this.c.F().Q1();
        }
        this.y0.setStatisticData(tn4Var);
    }

    public void D3(boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048591, this, z2) == null) || this.r0 == null) {
            return;
        }
        U2(this.c.K5().C());
        if (this.l0) {
            H3(z2);
        } else {
            p1(z2);
        }
    }

    public int E0() {
        InterceptResult invokeV;
        View childAt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
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

    public final void E1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && this.v == null) {
            this.v = new cw7(this.c, this.N);
        }
    }

    public void E2(int i3, jr7 jr7Var, boolean z2, int i4) {
        PostData I0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{Integer.valueOf(i3), jr7Var, Boolean.valueOf(z2), Integer.valueOf(i4)}) == null) || i3 <= 0 || (I0 = I0(jr7Var, z2)) == null || I0.s() == null) {
            return;
        }
        MetaData s2 = I0.s();
        s2.setGiftNum(s2.getGiftNum() + i3);
    }

    public void E3(jr7 jr7Var) {
        PostData postData;
        kx7 kx7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, jr7Var) == null) || jr7Var == null || (postData = this.M0) == null || postData.s() == null || (kx7Var = this.h) == null) {
            return;
        }
        boolean z2 = !this.l1;
        this.m1 = z2;
        kx7Var.G(z2);
        if (this.c.L5() != null) {
            this.c.L5().s(this.m1);
        }
        A2();
        PbFragment pbFragment = this.c;
        if (pbFragment != null && !pbFragment.v0() && !ListUtils.isEmpty(jr7Var.p())) {
            mq4 mq4Var = jr7Var.p().get(0);
            if (mq4Var != null) {
                this.h.K(jr7Var, mq4Var.c(), mq4Var.d(), mq4Var.a(), mq4Var.getIsLike());
            }
        } else if (jr7Var.l() != null) {
            this.h.K(jr7Var, jr7Var.l().getName(), jr7Var.l().getId(), jr7Var.l().getImage_url(), jr7Var.l().isLike() == 1);
        }
        if (this.m1) {
            this.u.L(jr7Var, this.M0, this.f0);
            View view2 = this.W0;
            if (view2 != null) {
                view2.setVisibility(8);
            }
            if (this.v1 == null) {
                this.v1 = new k0(this);
            }
            this.l.setListViewDragListener(this.v1);
            return;
        }
        View view3 = this.W0;
        if (view3 != null) {
            view3.setVisibility(0);
        }
        this.u.L(jr7Var, this.M0, this.f0);
        this.v1 = null;
        this.l.setListViewDragListener(null);
    }

    public PostData F0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            if (this.l == null) {
                return null;
            }
            int E0 = E0() - this.l.getHeaderViewsCount();
            int i3 = 0;
            if (E0 < 0) {
                E0 = 0;
            }
            if (this.C.x(E0) != null && this.C.x(E0) != PostData.z0) {
                i3 = E0 + 1;
            }
            if (this.C.w(i3) instanceof PostData) {
                return (PostData) this.C.w(i3);
            }
            return null;
        }
        return (PostData) invokeV.objValue;
    }

    public void F1(jr7 jr7Var) {
        PbReplyTitleViewHolder pbReplyTitleViewHolder;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, jr7Var) == null) {
            int i3 = 0;
            this.C.f0(jr7Var, false);
            this.C.Y();
            p0();
            jt7 jt7Var = this.u1;
            if (jt7Var != null) {
                jt7Var.n();
            }
            ArrayList<PostData> F = jr7Var.F();
            if (jr7Var.y().b() == 0 || F == null || F.size() < jr7Var.y().e()) {
                if (ListUtils.getCount(F) != 0 && (ListUtils.getCount(F) != 1 || F.get(0) == null || F.get(0).B() != 1)) {
                    if (jr7Var.y().b() == 0) {
                        this.I.C(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f09e5));
                    } else {
                        this.I.C(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0a29));
                    }
                    this.I.k();
                } else {
                    w0 w0Var = this.b1;
                    if (w0Var != null && (pbReplyTitleViewHolder = w0Var.c) != null && pbReplyTitleViewHolder.b() != null) {
                        i3 = this.b1.c.b().getTop() < 0 ? this.b1.c.b().getHeight() : this.b1.c.b().getBottom();
                    }
                    if (this.c.j6()) {
                        this.I.F(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0dc8), i3);
                    } else {
                        this.I.F(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0dc9), i3);
                    }
                }
            }
            D2(jr7Var);
        }
    }

    public void F2(jr7 jr7Var, boolean z2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{jr7Var, Boolean.valueOf(z2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            P3(jr7Var, z2, i3, i4);
            this.u.y(i4);
        }
    }

    public final void F3(SparseArray<Object> sparseArray, @StringRes int i3, @StringRes int i4) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(1048599, this, sparseArray, i3, i4) == null) || this.c == null) {
            return;
        }
        TBAlertConfig.a aVar = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f049f, TBAlertConfig.OperateBtnStyle.MAIN);
        TBAlertConfig.a aVar2 = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f036a, TBAlertConfig.OperateBtnStyle.SECONDARY);
        TBAlertBuilder tBAlertBuilder = new TBAlertBuilder(this.c.N());
        tBAlertBuilder.t(i3);
        tBAlertBuilder.l(i4);
        tBAlertBuilder.n(true);
        tBAlertBuilder.r(aVar2, aVar);
        tBAlertBuilder.i(false);
        AlertDialog w2 = tBAlertBuilder.w();
        aVar.a(new t(this, w2, sparseArray));
        aVar2.a(new u(this, w2));
    }

    public FallingView G0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.K1 : (FallingView) invokeV.objValue;
    }

    public boolean G1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.Y1 : invokeV.booleanValue;
    }

    public final void G2() {
        PbInterviewStatusView pbInterviewStatusView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048602, this) == null) && (pbInterviewStatusView = this.R0) != null && pbInterviewStatusView.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.R0.getLayoutParams();
            layoutParams.setMargins(0, 0, 0, 0);
            this.R0.setLayoutParams(layoutParams);
        }
    }

    public final boolean G3(jr7 jr7Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, jr7Var)) == null) {
            if (jr7Var == null || jr7Var.O() == null) {
                return false;
            }
            return jr7Var.O().getIsLive() == 1 || jr7Var.O().getThreadType() == 33 || !(jr7Var.O().getTopicData() == null || jr7Var.O().getTopicData().a() == 0) || jr7Var.O().getIs_top() == 1 || jr7Var.O().getIs_good() == 1 || jr7Var.O().isActInfo() || jr7Var.O().isInterviewLive() || jr7Var.O().isVoteThreadType() || jr7Var.O().getYulePostActivityData() != null || !oi.isEmpty(jr7Var.O().getCategory()) || jr7Var.O().isGodThread() || jr7Var.O().isRealGod();
        }
        return invokeL.booleanValue;
    }

    public int H0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? J0(this.l.getFirstVisiblePosition()) : invokeV.intValue;
    }

    public boolean H1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.H0 : invokeV.booleanValue;
    }

    public void H2() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048606, this) == null) || this.f == 2) {
            return;
        }
        this.l.setNextPage(this.I);
        this.f = 2;
    }

    public void H3(boolean z2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048607, this, z2) == null) || this.r0 == null || (textView = this.v0) == null) {
            return;
        }
        textView.setText(R.string.obfuscated_res_0x7f0f0510);
        if (z2) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(400L);
            this.r0.startAnimation(alphaAnimation);
        }
        this.q0.setVisibility(0);
        this.r0.setVisibility(0);
        this.H0 = true;
        if (this.c1 == null || this.u1.l()) {
            return;
        }
        this.c1.setVisibility(0);
        L2(true);
    }

    public PostData I0(jr7 jr7Var, boolean z2) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048608, this, jr7Var, z2)) == null) {
            PostData postData = null;
            if (jr7Var == null) {
                return null;
            }
            if (jr7Var.W() != null) {
                return jr7Var.W();
            }
            if (!ListUtils.isEmpty(jr7Var.F())) {
                Iterator<PostData> it = jr7Var.F().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    PostData next = it.next();
                    if (next != null && next.B() == 1) {
                        postData = next;
                        break;
                    }
                }
            }
            if (postData == null) {
                postData = jr7Var.j();
            }
            if (!L1(postData)) {
                postData = d1(jr7Var);
            }
            if (postData != null && postData.s() != null && postData.s().getUserTbVipInfoData() != null && postData.s().getUserTbVipInfoData().getvipIntro() != null) {
                postData.s().getGodUserData().setIntro(postData.s().getUserTbVipInfoData().getvipIntro());
            }
            return postData;
        }
        return (PostData) invokeLZ.objValue;
    }

    public final boolean I1(jr7 jr7Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, jr7Var)) == null) {
            if (jr7Var == null || jr7Var.O() == null) {
                return false;
            }
            SpannableStringBuilder span_str = jr7Var.O().getSpan_str();
            if (span_str != null) {
                return TbadkApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0db0).equals(span_str.toString());
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void I2() {
        PbFragment pbFragment;
        WaterRippleView waterRippleView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048610, this) == null) || (pbFragment = this.c) == null || pbFragment.getActivity() == null || (waterRippleView = this.w0) == null) {
            return;
        }
        ViewParent parent = waterRippleView.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.w0);
        }
        TextView textView = this.E0;
        if (textView != null) {
            textView.setVisibility(0);
        }
    }

    public void I3(View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048611, this, view2) == null) || xt4.k().h("show_long_press_collection_tips", false)) {
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
        this.r1 = textView;
        textView.setText(R.string.obfuscated_res_0x7f0f0433);
        this.r1.setGravity(17);
        this.r1.setPadding(pi.f(this.c.getContext(), R.dimen.obfuscated_res_0x7f0701e8), 0, pi.f(this.c.getContext(), R.dimen.obfuscated_res_0x7f0701e8), 0);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        layoutParams.height = pi.f(this.c.getContext(), R.dimen.obfuscated_res_0x7f070253);
        if (this.r1.getParent() == null) {
            frameLayout.addView(this.r1, layoutParams);
        }
        PopupWindow popupWindow = new PopupWindow(this.c.getContext());
        this.q1 = popupWindow;
        popupWindow.setContentView(frameLayout);
        this.q1.setHeight(-2);
        this.q1.setWidth(-2);
        this.q1.setFocusable(true);
        this.q1.setOutsideTouchable(false);
        this.q1.setBackgroundDrawable(new ColorDrawable(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent)));
        this.l.postDelayed(new p0(this, i5, i3, i4, view2), 100L);
        xt4.k().u("show_long_press_collection_tips", true);
    }

    public final int J0(int i3) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048612, this, i3)) == null) {
            en adapter2 = this.l.getAdapter2();
            if (adapter2 == null) {
                return i3;
            }
            if (i3 < adapter2.getCount() && i3 >= 0 && (adapter2.getItem(i3) instanceof gr7)) {
                i3++;
            }
            int o3 = (adapter2.o() + adapter2.m()) - 1;
            if (i3 > o3) {
                i3 = o3;
            }
            int n3 = (this.l.getAdapter2() == null || !(this.l.getAdapter2() instanceof en)) ? 0 : this.l.getAdapter2().n();
            if (i3 > n3) {
                return i3 - n3;
            }
            return 0;
        }
        return invokeI.intValue;
    }

    public boolean J1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView == null) {
                return false;
            }
            return pbLandscapeListView.J();
        }
        return invokeV.booleanValue;
    }

    public void J2() {
        PbLandscapeListView pbLandscapeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048614, this) == null) || (pbLandscapeListView = this.l) == null) {
            return;
        }
        this.x.d(pbLandscapeListView);
        this.t.e(this.l);
        this.u.B(this.l);
        this.v.d(this.l);
        this.s.f(this.l);
    }

    public void J3() {
        kx7 kx7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048615, this) == null) || (kx7Var = this.h) == null || this.n1) {
            return;
        }
        kx7Var.C();
        this.n1 = true;
    }

    public Button K0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.p0 : (Button) invokeV.objValue;
    }

    public boolean K1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            EditorTools editorTools = this.k0;
            return editorTools != null && editorTools.getVisibility() == 0;
        }
        return invokeV.booleanValue;
    }

    public final void K2() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048618, this) == null) || (pbFragment = this.c) == null || pbFragment.K5() == null || this.k0 == null) {
            return;
        }
        j35.a().c(0);
        n35 K5 = this.c.K5();
        K5.U();
        K5.S();
        if (K5.y() != null) {
            K5.y().setMaxImagesAllowed(K5.v ? 1 : 9);
        }
        K5.n0(SendView.h);
        K5.j(SendView.h);
        q15 m3 = this.k0.m(23);
        q15 m4 = this.k0.m(2);
        q15 m5 = this.k0.m(5);
        if (m4 != null) {
            m4.r();
        }
        if (m5 != null) {
            m5.r();
        }
        if (m3 != null) {
            m3.hide();
        }
        this.k0.invalidate();
    }

    public void K3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            this.l.setVisibility(0);
        }
    }

    public int L0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) ? this.l.getHeaderViewsCount() : invokeV.intValue;
    }

    public final boolean L1(PostData postData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048621, this, postData)) == null) {
            if (postData == null || postData.s() == null) {
                return false;
            }
            MetaData s2 = postData.s();
            return (TextUtils.isEmpty(s2.getUserId()) && TextUtils.isEmpty(s2.getAvater())) ? false : true;
        }
        return invokeL.booleanValue;
    }

    public final void L2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048622, this, z2) == null) {
        }
    }

    public void L3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            if (this.J0 == null) {
                this.J0 = new au4(this.c.getPageContext());
            }
            this.J0.h(true);
        }
    }

    public TextView M0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) ? this.u.q() : (TextView) invokeV.objValue;
    }

    public boolean M1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void M2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
            K2();
            q1();
            this.h1.c();
            D3(false);
        }
    }

    public final void M3(SparseArray<Object> sparseArray, int i3, nj5 nj5Var, UserData userData, boolean z2) {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048627, this, new Object[]{sparseArray, Integer.valueOf(i3), nj5Var, userData, Boolean.valueOf(z2)}) == null) || (pbFragment = this.c) == null) {
            return;
        }
        if (this.A1 == null && this.s != null) {
            this.A1 = new oj5(pbFragment.getPageContext(), this.s.c(), nj5Var, userData);
        }
        this.A1.C(z2);
        AntiData s5 = this.c.s5();
        SparseArray<String> sparseArray2 = new SparseArray<>();
        if (s5 != null && s5.getDelThreadInfoList() != null) {
            List<DeleteThreadInfo> delThreadInfoList = s5.getDelThreadInfoList();
            for (int i4 = 0; i4 < delThreadInfoList.size(); i4++) {
                if (!TextUtils.isEmpty(delThreadInfoList.get(i4).text_info)) {
                    sparseArray2.put(delThreadInfoList.get(i4).text_id, delThreadInfoList.get(i4).text_info);
                }
            }
        }
        kp4 kp4Var = new kp4();
        kp4Var.j(sparseArray2);
        this.A1.E(new String[]{this.c.getString(R.string.obfuscated_res_0x7f0f04b3), this.c.getString(R.string.obfuscated_res_0x7f0f04b4), this.c.getString(R.string.obfuscated_res_0x7f0f04b5), this.c.getString(R.string.obfuscated_res_0x7f0f04b6), this.c.getString(R.string.obfuscated_res_0x7f0f04b7)});
        this.A1.D(kp4Var);
        this.A1.G((i3 == 1 || i3 == 2) ? "4" : "3");
        this.A1.F(new z(this, sparseArray));
    }

    public int N0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) {
            uz7 uz7Var = this.D0;
            if (uz7Var != null) {
                return uz7Var.g();
            }
            return 3;
        }
        return invokeV.intValue;
    }

    public final boolean N1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) ? TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.Z1) : invokeV.booleanValue;
    }

    public final void N2() {
        gw7 gw7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048630, this) == null) || (gw7Var = this.r) == null) {
            return;
        }
        gw7Var.q(this.l, this.T0, this.N0);
    }

    public void N3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048631, this) == null) {
            this.C.f0(this.L0, false);
            this.C.Y();
        }
    }

    public PbInterviewStatusView O0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) ? this.R0 : (PbInterviewStatusView) invokeV.objValue;
    }

    public final boolean O1(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048633, this, threadData)) == null) {
            if (threadData == null || threadData.getAuthor() == null) {
                return false;
            }
            PostData I0 = I0(this.L0, false);
            return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), (I0 == null || I0.s() == null) ? "" : I0.s().getUserId());
        }
        return invokeL.booleanValue;
    }

    public void O2() {
        Handler handler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048634, this) == null) || (handler = this.S1) == null) {
            return;
        }
        Runnable runnable = this.T1;
        if (runnable != null) {
            handler.removeCallbacks(runnable);
        }
        m mVar = new m(this);
        this.T1 = mVar;
        this.S1.postDelayed(mVar, 2000L);
    }

    public void O3(jr7 jr7Var, int i3, int i4, boolean z2, int i5, boolean z3) {
        PbLandscapeListView pbLandscapeListView;
        int i6;
        PbReplyTitleViewHolder pbReplyTitleViewHolder;
        jr7 jr7Var2;
        Parcelable e2;
        Parcelable e3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048635, this, new Object[]{jr7Var, Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z2), Integer.valueOf(i5), Boolean.valueOf(z3)}) == null) || jr7Var == null || this.l == null) {
            return;
        }
        this.L0 = jr7Var;
        this.N0 = i3;
        if (jr7Var.O() != null) {
            this.d1 = jr7Var.O().getCopyThreadRemindType();
            if (jr7Var.O().getAnchorLevel() != 0) {
                this.Y1 = true;
            }
            this.f0 = O1(jr7Var.O());
        }
        if (jr7Var.U() != null) {
            this.Z1 = jr7Var.U().getUserId();
        }
        z1(jr7Var);
        e0();
        this.P0 = false;
        this.K0 = z2;
        p3();
        sr7 sr7Var = jr7Var.h;
        if (sr7Var != null && sr7Var.b()) {
            if (this.o == null) {
                PbThreadPostView pbThreadPostView = new PbThreadPostView(this.c.getContext());
                this.o = pbThreadPostView;
                this.l.x(pbThreadPostView, 1);
                this.o.setData(jr7Var);
                this.o.setChildOnClickLinstener(this.N);
            }
        } else {
            PbThreadPostView pbThreadPostView2 = this.o;
            if (pbThreadPostView2 != null && (pbLandscapeListView = this.l) != null) {
                pbLandscapeListView.removeHeaderView(pbThreadPostView2);
            }
        }
        P3(jr7Var, z2, i3, TbadkCoreApplication.getInst().getSkinType());
        E3(jr7Var);
        this.u.M(jr7Var, this.M0);
        if (this.x1 == null) {
            this.x1 = new av7(this.c.getPageContext(), this.y1);
        }
        this.x1.a(jr7Var.w());
        if (this.c.C5()) {
            if (this.H == null) {
                vz7 vz7Var = new vz7(this.c.getPageContext());
                this.H = vz7Var;
                vz7Var.n();
                this.H.f(this.a2);
            }
            this.l.setPullRefresh(this.H);
            N2();
            vz7 vz7Var2 = this.H;
            if (vz7Var2 != null) {
                vz7Var2.H(TbadkCoreApplication.getInst().getSkinType());
            }
        } else if (jr7Var.y().c() == 0 && z2) {
            this.l.setPullRefresh(null);
        } else {
            if (this.H == null) {
                vz7 vz7Var3 = new vz7(this.c.getPageContext());
                this.H = vz7Var3;
                vz7Var3.n();
                this.H.f(this.a2);
            }
            this.l.setPullRefresh(this.H);
            N2();
            vz7 vz7Var4 = this.H;
            if (vz7Var4 != null) {
                vz7Var4.H(TbadkCoreApplication.getInst().getSkinType());
            }
            s1();
        }
        p0();
        this.C.m0(this.K0);
        this.C.j0(false);
        this.C.k0(i3 == 5);
        this.C.l0(i3 == 6);
        this.C.h0(z3 && this.W1 && i3 != 2);
        this.C.f0(jr7Var, false);
        this.C.Y();
        this.u.K(I0(jr7Var, z2), jr7Var.g0());
        if (jr7Var.O() != null && jr7Var.O().getPraise() != null && this.b != -1) {
            jr7Var.O().getPraise().setIsLike(this.b);
        }
        this.l.removeFooterView(this.Y0);
        this.l.addFooterView(this.Y0);
        if (TbadkCoreApplication.isLogin()) {
            this.l.setNextPage(this.I);
            this.f = 2;
            s1();
        } else {
            this.P0 = true;
            if (jr7Var.y().b() == 1) {
                if (this.J == null) {
                    PbFragment pbFragment = this.c;
                    this.J = new rz7(pbFragment, pbFragment);
                }
                this.l.setNextPage(this.J);
            } else {
                this.l.setNextPage(this.I);
            }
            this.f = 3;
        }
        ArrayList<PostData> F = jr7Var.F();
        if (jr7Var.y().b() != 0 && F != null && F.size() >= jr7Var.y().e()) {
            if (z3) {
                if (this.W1) {
                    u0();
                    if (jr7Var.y().b() != 0) {
                        this.I.C(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0dc1));
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
            if (ListUtils.getCount(F) != 0 && (ListUtils.getCount(F) != 1 || F.get(0) == null || F.get(0).B() != 1)) {
                if (jr7Var.y().b() == 0) {
                    this.I.C(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f09e5));
                } else {
                    this.I.C(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0a29));
                }
                this.I.k();
            } else {
                w0 w0Var = this.b1;
                if (w0Var == null || (pbReplyTitleViewHolder = w0Var.c) == null || pbReplyTitleViewHolder.b() == null) {
                    i6 = 0;
                } else {
                    i6 = this.b1.c.b().getTop() < 0 ? this.b1.c.b().getHeight() : this.b1.c.b().getBottom();
                }
                if (this.c.j6()) {
                    this.I.u(false);
                    if (ListUtils.isEmpty(jr7Var.R())) {
                        this.I.F(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0dc8), i6);
                    }
                } else if (ListUtils.isEmpty(jr7Var.R())) {
                    this.I.F(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0dc9), i6);
                }
                if (this.c.L5() != null && !this.c.L5().p()) {
                    this.c.L5().x();
                }
            }
            if (jr7Var.y().b() == 0 || F == null) {
                H2();
            }
        }
        if (i3 == 2) {
            this.l.setSelection(i4 > 1 ? (i4 + ((this.l.getData() == null && jr7Var.F() == null) ? 0 : (this.l.getData().size() - jr7Var.F().size()) + this.l.getHeaderViewsCount())) - 2 : 0);
        } else if (i3 != 3) {
            if (i3 == 4) {
                this.W1 = false;
            } else if (i3 == 5) {
                this.l.setSelection(0);
            } else if (i3 != 6) {
                if (i3 == 8) {
                    if (i4 == 0) {
                        gw7 gw7Var = this.r;
                        if (gw7Var != null && gw7Var.c() != null) {
                            if (this.c.getBaseFragmentActivity().isUseStyleImmersiveSticky()) {
                                this.l.setSelectionFromTop((this.C.A() + this.l.getHeaderViewsCount()) - 1, this.r.d() - pi.s(this.c.getPageContext().getPageActivity()));
                            } else {
                                this.l.setSelectionFromTop((this.C.A() + this.l.getHeaderViewsCount()) - 1, this.r.d());
                            }
                        } else {
                            this.l.setSelection(this.C.A() + this.l.getHeaderViewsCount());
                        }
                    } else if (ListUtils.isEmpty(jr7Var.R())) {
                        this.l.setSelection(i4 > 0 ? i4 + ((this.l.getData() == null && jr7Var.F() == null) ? 0 : (this.l.getData().size() - jr7Var.F().size()) + this.l.getHeaderViewsCount()) : 0);
                    } else {
                        this.l.setSelection(jr7Var.F().size() + this.l.getHeaderViewsCount());
                    }
                    this.I.f();
                    this.I.C(this.c.getString(R.string.obfuscated_res_0x7f0f0dc2));
                    this.I.x();
                }
            } else if (i5 == 1 && (e3 = fv7.b().e()) != null && !(e3 instanceof RecyclerView.SavedState)) {
                this.l.onRestoreInstanceState(e3);
            } else {
                this.l.setSelection(0);
            }
        } else if (i5 == 1 && (e2 = fv7.b().e()) != null && !(e2 instanceof RecyclerView.SavedState)) {
            this.l.post(new j0(this, e2, F, jr7Var));
        }
        if (this.d1 == h2 && N1()) {
            j0();
        }
        if (this.j1) {
            B2();
            this.j1 = false;
            if (i5 == 0) {
                e3(true);
            }
        }
        if (jr7Var.d == 1 || jr7Var.e == 1) {
            if (this.p1 == null) {
                this.p1 = new PbTopTipView(this.c.getContext());
            }
            if (jr7Var.e == 1 && "game_guide".equals(this.c.Q5())) {
                this.p1.setText(this.c.getString(R.string.obfuscated_res_0x7f0f0dd4));
                this.p1.l(this.d, this.O0);
            } else if (jr7Var.d == 1 && "game_news".equals(this.c.Q5())) {
                this.p1.setText(this.c.getString(R.string.obfuscated_res_0x7f0f0dd3));
                this.p1.l(this.d, this.O0);
            }
        }
        this.l.removeFooterView(this.I1.a());
        if (!ListUtils.isEmpty(jr7Var.I()) && jr7Var.y().b() == 0) {
            this.l.removeFooterView(this.Y0);
            this.I1.d(Math.max(this.r0.getMeasuredHeight(), this.I0 / 2));
            this.l.addFooterView(this.I1.a());
            this.I1.f(jr7Var);
        }
        D2(jr7Var);
        if (jr7Var.e0() && this.c.F().E2() && this.c.N5() != null) {
            this.c.N5().d();
        }
        if (jr7Var.g() != 3) {
            D1(jr7Var);
        }
        this.v0.setText(TbSingleton.getInstance().getAdVertiComment(jr7Var.k0(), jr7Var.l0(), e1()));
        if (this.p == null || (jr7Var2 = this.L0) == null || jr7Var2.l() == null) {
            return;
        }
        this.p.m(this.L0.l().getImage_url());
        this.p.n(this.L0.l().getName());
        PbFragment pbFragment2 = this.c;
        if (pbFragment2 == null || pbFragment2.F() == null) {
            return;
        }
        this.p.o(this.c.F().b);
    }

    public boolean P0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) ? this.w1 : invokeV.booleanValue;
    }

    public boolean P1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) {
            View view2 = this.Y0;
            if (view2 == null || view2.getParent() == null || this.I.m()) {
                return false;
            }
            int bottom = this.Y0.getBottom();
            Rect rect = new Rect();
            this.Y0.getWindowVisibleDisplayFrame(rect);
            return bottom > 0 && bottom <= rect.bottom;
        }
        return invokeV.booleanValue;
    }

    public void P2(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048638, this, editorTools) == null) {
            this.k0 = editorTools;
            editorTools.setOnCancelClickListener(new o(this));
            this.k0.setId(R.id.obfuscated_res_0x7f091715);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            if (this.k0.getParent() == null) {
                this.d.addView(this.k0, layoutParams);
            }
            this.k0.w(TbadkCoreApplication.getInst().getSkinType());
            this.k0.setActionListener(24, new p(this));
            q1();
            this.c.K5().i(new q(this));
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public final void P3(jr7 jr7Var, boolean z2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048639, this, new Object[]{jr7Var, Boolean.valueOf(z2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) || jr7Var == null || jr7Var.O() == null) {
            return;
        }
        if (this.c.v0()) {
            if (jr7Var.h() != null) {
                this.g0 = jr7Var.h().c();
                this.h0 = jr7Var.h().d();
            }
            if (this.g0 == null && this.c.F() != null && this.c.F().q1() != null) {
                this.g0 = this.c.F().q1();
            }
        }
        PostData I0 = I0(jr7Var, z2);
        n3(I0, jr7Var);
        this.u.H(8);
        if (jr7Var.r0()) {
            this.l1 = true;
            this.h.A(true);
            this.h.a.hideBottomLine();
            if (this.r == null) {
                this.r = new gw7(this.c);
            }
            this.r.v(jr7Var, I0, this.l, this.u, this.S0, this.h, this.g0, this.D1);
            this.r.s(this.X1);
            N2();
        } else {
            this.l1 = false;
            this.h.A(false);
            gw7 gw7Var = this.r;
            if (gw7Var != null) {
                gw7Var.p(this.l);
            }
        }
        if (this.c.L5() != null) {
            this.c.L5().w(this.l1);
        }
        if (I0 == null) {
            return;
        }
        this.M0 = I0;
        this.u.H(0);
        SparseArray<Object> u2 = this.u.u();
        u2.put(R.id.obfuscated_res_0x7f091eed, I0);
        u2.put(R.id.obfuscated_res_0x7f091f06, Boolean.FALSE);
        this.v.e(jr7Var, this.l);
        this.x.e(jr7Var, this.F1, new f0(this));
        this.t.g(jr7Var);
        this.s.h(jr7Var, this.K0);
        this.s.g(jr7Var);
        this.u.I(this.O0, this.L0, I0, this.X1);
        if (this.X0 != null) {
            if (jr7Var.g0()) {
                this.X0.b().setVisibility(8);
            } else {
                this.X0.b().setVisibility(0);
                wr7 wr7Var = new wr7(wr7.h);
                if (jr7Var.O() != null) {
                    jr7Var.O().getReply_num();
                }
                wr7Var.c = jr7Var.g;
                jr7Var.c();
                wr7Var.d = this.c.j6();
                wr7Var.g = jr7Var.f;
                this.X0.i(wr7Var);
            }
        }
        b4(jr7Var);
        qg.a().post(new h0(this));
        this.w.e(this.l);
        if (I0.Q) {
            this.w.f(I0.J());
            this.w.b(this.l, this.l.getHeaderViewsCount() <= 1 ? 0 : 1);
        }
        xt7 xt7Var = this.C;
        if (xt7Var != null && xt7Var.y() != null) {
            this.C.y().m0(I0.Q);
        }
        xt7 xt7Var2 = this.C;
        if (xt7Var2 != null) {
            xt7Var2.p0(I0.Q);
        }
        this.J1.setVisibility(I0.Q ? 0 : 8);
    }

    public int Q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) {
            int lastVisiblePosition = this.l.getLastVisiblePosition();
            if (this.r != null) {
                if (lastVisiblePosition == this.l.getCount() - 1) {
                    lastVisiblePosition--;
                }
                if (lastVisiblePosition < 0) {
                    lastVisiblePosition = 0;
                }
            }
            return J0(lastVisiblePosition);
        }
        return invokeV.intValue;
    }

    public boolean Q1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) {
            jr7 jr7Var = this.L0;
            return jr7Var == null || jr7Var.l() == null || "0".equals(this.L0.l().getId()) || "me0407".equals(this.L0.l().getName());
        }
        return invokeV.booleanValue;
    }

    public void Q2(String str) {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048642, this, str) == null) || (pbListView = this.I) == null) {
            return;
        }
        pbListView.C(str);
    }

    public void Q3(er4.c cVar, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048643, this, cVar, z2) == null) {
            lr4 lr4Var = this.c0;
            if (lr4Var != null) {
                lr4Var.dismiss();
                this.c0 = null;
            }
            nr4 nr4Var = new nr4(this.c.getContext());
            ArrayList arrayList = new ArrayList();
            jr7 jr7Var = this.L0;
            if (jr7Var != null && jr7Var.O() != null && !this.L0.O().isBjh()) {
                arrayList.add(new jr4(0, this.c.getPageContext().getString(R.string.obfuscated_res_0x7f0f1098), nr4Var));
            }
            if (!z2) {
                arrayList.add(new jr4(1, this.c.getPageContext().getString(R.string.obfuscated_res_0x7f0f1099), nr4Var));
            }
            nr4Var.j(arrayList);
            nr4Var.n(new d0(this, cVar));
            lr4 lr4Var2 = new lr4(this.c.getPageContext(), nr4Var);
            this.c0 = lr4Var2;
            lr4Var2.m();
        }
    }

    public BdTypeListView R0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) ? this.l : (BdTypeListView) invokeV.objValue;
    }

    public boolean R1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048645, this)) == null) {
            gw7 gw7Var = this.r;
            return gw7Var != null && gw7Var.f();
        }
        return invokeV.booleanValue;
    }

    public void R2(String str) {
        PbReplyTitleViewHolder pbReplyTitleViewHolder;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048646, this, str) == null) || this.I == null) {
            return;
        }
        int i3 = 0;
        w0 w0Var = this.b1;
        if (w0Var != null && (pbReplyTitleViewHolder = w0Var.c) != null && pbReplyTitleViewHolder.b() != null) {
            i3 = this.b1.c.b().getTop() < 0 ? this.b1.c.b().getHeight() : this.b1.c.b().getBottom();
        }
        this.I.F(str, i3);
    }

    public void R3(er4.c cVar, boolean z2, boolean z3, boolean z4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048647, this, new Object[]{cVar, Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4)}) == null) {
            lr4 lr4Var = this.b0;
            if (lr4Var != null) {
                lr4Var.dismiss();
                this.b0 = null;
            }
            nr4 nr4Var = new nr4(this.c.getContext());
            ArrayList arrayList = new ArrayList();
            if (!z4) {
                arrayList.add(new jr4(0, this.c.getPageContext().getString(R.string.obfuscated_res_0x7f0f0443), nr4Var));
            }
            if (z3) {
                arrayList.add(new jr4(1, this.c.getPageContext().getString(R.string.obfuscated_res_0x7f0f0fd6), nr4Var));
            } else if (!z2) {
                arrayList.add(new jr4(1, this.c.getPageContext().getString(R.string.obfuscated_res_0x7f0f0a80), nr4Var));
            } else {
                arrayList.add(new jr4(1, this.c.getPageContext().getString(R.string.obfuscated_res_0x7f0f0fb3), nr4Var));
            }
            nr4Var.j(arrayList);
            nr4Var.n(new c0(this, cVar));
            lr4 lr4Var2 = new lr4(this.c.getPageContext(), nr4Var);
            this.c0 = lr4Var2;
            lr4Var2.m();
        }
    }

    public SparseArray<Object> S0(jr7 jr7Var, boolean z2, int i3) {
        InterceptResult invokeCommon;
        PostData I0;
        so4 so4Var;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048648, this, new Object[]{jr7Var, Boolean.valueOf(z2), Integer.valueOf(i3)})) == null) {
            StringBuilder sb = null;
            if (jr7Var == null || (I0 = I0(jr7Var, z2)) == null) {
                return null;
            }
            String userId = I0.s().getUserId();
            boolean z3 = userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount());
            SparseArray<Object> sparseArray = new SparseArray<>();
            if (i3 == 0) {
                sparseArray.put(R.id.obfuscated_res_0x7f091eef, I0.J());
                sparseArray.put(R.id.obfuscated_res_0x7f091ef1, 0);
                sparseArray.put(R.id.obfuscated_res_0x7f091ef0, Boolean.valueOf(z3));
                sparseArray.put(R.id.obfuscated_res_0x7f091f0c, Integer.valueOf(jr7Var.V()));
                sparseArray.put(R.id.obfuscated_res_0x7f091f30, Boolean.FALSE);
            } else if (i3 == 1) {
                if (I0.s() != null) {
                    sparseArray.put(R.id.obfuscated_res_0x7f091efa, I0.s().getUserName());
                    sparseArray.put(R.id.obfuscated_res_0x7f091efb, I0.s().getName_show());
                    sparseArray.put(R.id.obfuscated_res_0x7f091efc, I0.s().getPortrait());
                    sparseArray.put(R.id.obfuscated_res_0x7f091efd, I0.J());
                }
                sparseArray.put(R.id.obfuscated_res_0x7f091eef, I0.J());
                sparseArray.put(R.id.obfuscated_res_0x7f091ef1, 0);
                sparseArray.put(R.id.obfuscated_res_0x7f091ef0, Boolean.valueOf(z3));
                sparseArray.put(R.id.obfuscated_res_0x7f091f0c, Integer.valueOf(jr7Var.V()));
                sparseArray.put(R.id.obfuscated_res_0x7f091f30, Boolean.TRUE);
            }
            if (!z3) {
                List<mq4> p3 = jr7Var.p();
                if (ListUtils.getCount(p3) > 0) {
                    sb = new StringBuilder();
                    for (mq4 mq4Var : p3) {
                        if (mq4Var != null && !StringUtils.isNull(mq4Var.c()) && (so4Var = mq4Var.g) != null && so4Var.a && !so4Var.c && ((i4 = so4Var.b) == 1 || i4 == 2)) {
                            sb.append(oi.cutString(mq4Var.c(), 12));
                            sb.append(this.c.getString(R.string.obfuscated_res_0x7f0f0650));
                            sb.append("、");
                        }
                    }
                }
                if (sb != null && !StringUtils.isNull(sb.toString())) {
                    sparseArray.put(R.id.obfuscated_res_0x7f091eee, String.format(this.c.getString(R.string.obfuscated_res_0x7f0f0497), sb.toString().substring(0, sb.length() - 1)));
                }
            }
            return sparseArray;
        }
        return (SparseArray) invokeCommon.objValue;
    }

    public boolean S1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) ? this.N1 : invokeV.booleanValue;
    }

    public final void S2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048650, this) == null) {
            this.K1.setFallingFeedbackListener(new FallingView.l() { // from class: com.repackage.nt7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.pb.view.FallingView.l
                public final void onClick() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        nv7.this.X1();
                    }
                }
            });
        }
    }

    public void S3(AdapterView.OnItemClickListener onItemClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048651, this, onItemClickListener) == null) {
            gr4 gr4Var = this.d0;
            if (gr4Var != null) {
                gr4Var.d();
                this.d0 = null;
            }
            if (this.L0 == null) {
                return;
            }
            ArrayList<pr4> arrayList = new ArrayList<>();
            arrayList.add(new pr4(this.c.getContext().getString(R.string.obfuscated_res_0x7f0f026c), "", this.L0.L() == 1, Integer.toString(1)));
            arrayList.add(new pr4(this.c.getContext().getString(R.string.obfuscated_res_0x7f0f0b2f), "", this.L0.L() == 2, Integer.toString(5)));
            arrayList.add(new pr4(this.c.getContext().getString(R.string.obfuscated_res_0x7f0f0b2c), "", this.L0.L() == 3, Integer.toString(6)));
            arrayList.add(new pr4(this.c.getContext().getString(R.string.obfuscated_res_0x7f0f0b4a), "", this.L0.L() == 4, Integer.toString(7)));
            gr4 gr4Var2 = new gr4(this.c.getPageContext());
            gr4Var2.l(R.string.obfuscated_res_0x7f0f0dd0);
            this.d0 = gr4Var2;
            gr4Var2.k(arrayList, onItemClickListener);
            gr4Var2.c();
            this.d0.n();
        }
    }

    public jt7 T0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048652, this)) == null) ? this.u1 : (jt7) invokeV.objValue;
    }

    public boolean T1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048653, this)) == null) {
            uz7 uz7Var = this.D0;
            if (uz7Var == null) {
                return false;
            }
            return uz7Var.i();
        }
        return invokeV.booleanValue;
    }

    public void T2(PbFragment.f3 f3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048654, this, f3Var) == null) {
            this.V1 = f3Var;
        }
    }

    public void T3() {
        PostData postData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048655, this) == null) || !TbadkCoreApplication.isLogin() || this.L0 == null || !this.m1 || this.l1 || this.f0 || (postData = this.M0) == null || postData.s() == null || this.M0.s().getIsLike() || this.M0.s().hadConcerned() || this.i1 != null) {
            return;
        }
        this.i1 = new iv7(this.c);
    }

    public View U0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048656, this)) == null) ? this.L : (View) invokeV.objValue;
    }

    public boolean U1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048657, this)) == null) {
            EditorTools editorTools = this.k0;
            return editorTools != null && editorTools.u();
        }
        return invokeV.booleanValue;
    }

    public void U2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048658, this, z2) == null) {
            this.l0 = z2;
        }
    }

    public final void U3(cr4 cr4Var, int i3) {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048659, this, cr4Var, i3) == null) || (pbFragment = this.c) == null || cr4Var == null) {
            return;
        }
        if (this.z1 == null && this.s != null) {
            this.z1 = new lj5(pbFragment.getPageContext(), this.s.c());
        }
        AntiData s5 = this.c.s5();
        SparseArray<String> sparseArray = new SparseArray<>();
        if (s5 != null && s5.getDelThreadInfoList() != null) {
            List<DeleteThreadInfo> delThreadInfoList = s5.getDelThreadInfoList();
            for (int i4 = 0; i4 < delThreadInfoList.size(); i4++) {
                if (!TextUtils.isEmpty(delThreadInfoList.get(i4).text_info)) {
                    sparseArray.put(delThreadInfoList.get(i4).text_id, delThreadInfoList.get(i4).text_info);
                }
            }
        }
        kp4 kp4Var = new kp4();
        kp4Var.j(sparseArray);
        this.z1.y(new String[]{this.c.getString(R.string.obfuscated_res_0x7f0f04b3), this.c.getString(R.string.obfuscated_res_0x7f0f04b4), this.c.getString(R.string.obfuscated_res_0x7f0f04b5), this.c.getString(R.string.obfuscated_res_0x7f0f04b6), this.c.getString(R.string.obfuscated_res_0x7f0f04b7)});
        this.z1.x(kp4Var);
        this.z1.A((i3 == 1 || i3 == 2) ? "4" : "3");
        this.z1.z(new y(this, cr4Var));
    }

    public final int V0(boolean z2) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048660, this, z2)) == null) {
            PbInterviewStatusView pbInterviewStatusView = this.R0;
            if (pbInterviewStatusView != null && pbInterviewStatusView.getVisibility() == 0 && z2) {
                return 0 + pi.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f07026a);
            }
            return 0;
        }
        return invokeZ.intValue;
    }

    public /* synthetic */ void V1() {
        this.l.post(new Runnable() { // from class: com.repackage.pt7
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // java.lang.Runnable
            public final void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    nv7.this.W1();
                }
            }
        });
    }

    public void V2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048662, this, z2) == null) {
            this.C.g0(z2);
        }
    }

    public void V3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048663, this) == null) {
            this.M.setVisibility(0);
        }
    }

    public View W0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048664, this)) == null) ? this.K : (View) invokeV.objValue;
    }

    public /* synthetic */ void W1() {
        nu7 nu7Var = this.p;
        if (nu7Var != null) {
            nu7Var.p();
        }
    }

    public void W2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048666, this, z2) == null) {
            this.E1 = z2;
        }
    }

    public void W3() {
        xt7 xt7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048667, this) == null) || (xt7Var = this.C) == null) {
            return;
        }
        xt7Var.x0();
    }

    public PbListView X0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048668, this)) == null) ? this.I : (PbListView) invokeV.objValue;
    }

    public /* synthetic */ void X1() {
        String e1;
        PbFragment pbFragment = this.c;
        if (pbFragment != null && pbFragment.F() != null && this.c.F().x2()) {
            e1 = this.c.getString(R.string.obfuscated_res_0x7f0f0dd7);
        } else {
            e1 = e1();
        }
        if (!StringUtils.isNull(e1) && this.L0 != null) {
            e1 = TbSingleton.getInstance().getAdVertiComment(this.L0.k0(), this.L0.l0(), e1);
        }
        PbFragment pbFragment2 = this.c;
        if (pbFragment2 != null && pbFragment2.K5() != null) {
            this.c.K5().m0(e1);
        }
        TextView textView = this.v0;
        if (textView != null) {
            textView.setText(e1);
        }
        D3(false);
        X3();
    }

    public void X2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048670, this, z2) == null) {
            this.w1 = z2;
        }
    }

    public final void X3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048671, this) == null) {
            FallingView fallingView = this.K1;
            if (fallingView != null) {
                fallingView.setTag(Boolean.TRUE);
            }
            RightFloatLayerView rightFloatLayerView = this.L1;
            if (rightFloatLayerView != null && rightFloatLayerView.getTag() == this.K1) {
                this.L1.setTag(null);
                this.L1.setAutoCompleteShown(true);
                this.L1.d();
            }
        }
    }

    public int Y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048672, this)) == null) {
            try {
                return Integer.parseInt(this.G.getText().toString(), 10);
            } catch (Exception unused) {
                return -1;
            }
        }
        return invokeV.intValue;
    }

    public final void Y1() {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048673, this) == null) || (imageView = this.u0) == null) {
            return;
        }
        imageView.setImageResource(R.drawable.obfuscated_res_0x7f08097a);
    }

    public void Y2(boolean z2) {
        gw7 gw7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048674, this, z2) == null) || (gw7Var = this.r) == null) {
            return;
        }
        gw7Var.r(z2);
    }

    public void Y3() {
        uz7 uz7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048675, this) == null) || (uz7Var = this.D0) == null) {
            return;
        }
        uz7Var.o(2);
    }

    public View Z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048676, this)) == null) ? this.U0 : (View) invokeV.objValue;
    }

    public void Z1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048677, this) == null) {
            D2(this.L0);
        }
    }

    public void Z2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048678, this, z2) == null) {
            this.C.i0(z2);
        }
    }

    public void Z3(op4 op4Var, cr4.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048679, this, op4Var, eVar) == null) || op4Var == null) {
            return;
        }
        int a2 = op4Var.a();
        int h3 = op4Var.h();
        cr4 cr4Var = this.D;
        if (cr4Var != null) {
            cr4Var.show();
        } else {
            this.D = new cr4(this.c.getPageContext().getPageActivity());
            View inflate = LayoutInflater.from(this.c.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0225, (ViewGroup) null);
            this.F = inflate;
            this.D.setContentView(inflate);
            this.D.setPositiveButton(R.string.obfuscated_res_0x7f0f04e5, eVar);
            this.D.setNegativeButton(R.string.obfuscated_res_0x7f0f04e0, new l0(this));
            this.D.setOnCalcelListener(new m0(this));
            this.D.create(this.c.getPageContext()).show();
        }
        EditText editText = (EditText) this.F.findViewById(R.id.obfuscated_res_0x7f090ecf);
        this.G = editText;
        editText.setText("");
        TextView textView = (TextView) this.F.findViewById(R.id.obfuscated_res_0x7f09070c);
        if (a2 <= 0) {
            a2 = 1;
        }
        if (h3 <= 0) {
            h3 = 1;
        }
        textView.setText(MessageFormat.format(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f046f), Integer.valueOf(a2), Integer.valueOf(h3)));
        this.c.getBaseFragmentActivity().ShowSoftKeyPadDelay(this.G, 150);
    }

    public NoNetworkView a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048680, this)) == null) ? this.m : (NoNetworkView) invokeV.objValue;
    }

    public final boolean a0(AbsListView absListView, int i3) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048681, this, absListView, i3)) == null) {
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

    public PbFakeFloorModel a1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048682, this)) == null) ? this.g1 : (PbFakeFloorModel) invokeV.objValue;
    }

    public final void a2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048683, this) == null) && UbsABTestHelper.isShareTopRight()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.z0.getLayoutParams();
            layoutParams.addRule(11);
            this.z0.setLayoutParams(layoutParams);
            if (this.A0.getParent() != null) {
                ((ViewGroup) this.A0.getParent()).removeView(this.A0);
                ((ViewGroup) this.B0.getParent()).removeView(this.B0);
            }
            if (this.C0.getParent() != null) {
                ((ViewGroup) this.C0.getParent()).removeView(this.C0);
            }
            RelativeLayout relativeLayout = new RelativeLayout(TbadkCoreApplication.getInst().getContext());
            relativeLayout.addView(this.A0);
            relativeLayout.addView(this.B0);
            relativeLayout.addView(this.C0);
            this.h.a.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, relativeLayout, (View.OnClickListener) null);
            this.h.a.getViewGroup(NavigationBar.ControlAlign.HORIZONTAL_RIGHT).setClipChildren(false);
        }
    }

    public void a3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048684, this, z2) == null) {
            this.C.n0(z2);
        }
    }

    public void a4(boolean z2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048685, this, z2) == null) || this.l == null || (textView = this.T0) == null || this.e == null) {
            return;
        }
        if (z2) {
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.e.setVisibility(0);
            } else {
                this.e.setVisibility(8);
                this.l.removeHeaderView(this.T0);
                this.l.setTextViewAdded(false);
            }
            AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) this.T0.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = g2;
                this.T0.setLayoutParams(layoutParams);
            }
            N2();
            return;
        }
        AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) textView.getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT) + V0(true);
            this.T0.setLayoutParams(layoutParams2);
        }
        N2();
        G2();
    }

    public void b0() {
        uz7 uz7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048686, this) == null) || (uz7Var = this.D0) == null) {
            return;
        }
        uz7Var.m(false);
    }

    public ju7 b1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048687, this)) == null) ? this.h1 : (ju7) invokeV.objValue;
    }

    public void b2() {
        mu7 mu7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048688, this) == null) || (mu7Var = this.q) == null) {
            return;
        }
        mu7Var.b();
    }

    public void b3(fu4.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048689, this, gVar) == null) {
            this.a2 = gVar;
            vz7 vz7Var = this.H;
            if (vz7Var != null) {
                vz7Var.f(gVar);
            }
        }
    }

    public final void b4(jr7 jr7Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048690, this, jr7Var) == null) || jr7Var == null || jr7Var.O() == null || jr7Var.O().isVideoThreadType()) {
            return;
        }
        boolean z2 = jr7Var.O().getIs_good() == 1;
        boolean z3 = jr7Var.O().getIs_top() == 1;
        fw7 fw7Var = this.u;
        if (fw7Var != null) {
            fw7Var.o(jr7Var, z2, z3);
        }
        dw7 dw7Var = this.t;
        if (dw7Var != null) {
            dw7Var.b(jr7Var, z2, z3);
        }
    }

    public boolean c0(boolean z2) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048691, this, z2)) == null) {
            EditorTools editorTools = this.k0;
            if (editorTools == null || !editorTools.u()) {
                return false;
            }
            this.k0.q();
            return true;
        }
        return invokeZ.booleanValue;
    }

    public gw7 c1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048692, this)) == null) ? this.r : (gw7) invokeV.objValue;
    }

    public void c2(ei8 ei8Var) {
        jr7 jr7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048693, this, ei8Var) == null) || ei8Var == null || ei8Var.a == null || ei8Var.b == null || (jr7Var = this.L0) == null || jr7Var.O() == null || this.L0.O().getAgreeData() == null) {
            return;
        }
        AgreeData agreeData = this.L0.O().getAgreeData();
        String str = ei8Var.b.nid;
        if (!TextUtils.isEmpty(str) && !"0".equals(str)) {
            BaijiahaoData baijiahaoData = agreeData.baijiahaoData;
            if (baijiahaoData == null || !TextUtils.equals(str, baijiahaoData.oriUgcNid)) {
                return;
            }
        } else {
            String str2 = ei8Var.b.threadId;
            String str3 = agreeData.threadId;
            if ("0".equals(str2) || TextUtils.isEmpty(str2) || !TextUtils.equals(str2, str3)) {
                return;
            }
        }
        AgreeData agreeData2 = ei8Var.b;
        C2(agreeData2, agreeData2.agreeNum);
    }

    public void c3(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048694, this, onClickListener) == null) {
            this.b2 = onClickListener;
            xt7 xt7Var = this.C;
            if (xt7Var != null) {
                xt7Var.o0(onClickListener);
            }
        }
    }

    @SuppressLint({"CutPasteId"})
    public void c4(jr7 jr7Var, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048695, this, jr7Var, z2) == null) || jr7Var == null) {
            return;
        }
        m4(jr7Var, z2);
        p0();
    }

    public boolean d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048696, this)) == null) {
            PbListView pbListView = this.I;
            if (pbListView == null || TextUtils.isEmpty(pbListView.h())) {
                return false;
            }
            return this.I.h().equals(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f09e5));
        }
        return invokeV.booleanValue;
    }

    public final PostData d1(jr7 jr7Var) {
        InterceptResult invokeL;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048697, this, jr7Var)) == null) {
            if (jr7Var == null || jr7Var.O() == null || jr7Var.O().getAuthor() == null) {
                return null;
            }
            PostData postData = new PostData();
            MetaData author = jr7Var.O().getAuthor();
            String userId = author.getUserId();
            HashMap<String, MetaData> userMap = jr7Var.O().getUserMap();
            if (userMap != null && (metaData = userMap.get(userId)) != null && metaData.getUserId() != null) {
                author = metaData;
            }
            postData.s0(1);
            postData.x0(jr7Var.O().getFirstPostId());
            postData.J0(jr7Var.O().getTitle());
            postData.I0(jr7Var.O().getCreateTime());
            postData.q0(author);
            return postData;
        }
        return (PostData) invokeL.objValue;
    }

    public void d2(int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048698, this, i3) == null) || this.O0 == i3) {
            return;
        }
        this.O0 = i3;
        c4(this.L0, this.K0);
        F2(this.L0, this.K0, this.N0, i3);
        this.c.getBaseFragmentActivity().getLayoutMode().k(i3 == 1);
        this.c.getBaseFragmentActivity().getLayoutMode().j(this.d);
        SkinManager.setBackgroundColor(this.d, R.color.CAM_X0201);
        SkinManager.setBackgroundColor(this.m0, R.color.CAM_X0203);
        gw7 gw7Var = this.r;
        if (gw7Var != null) {
            gw7Var.h(i3);
        }
        cw7 cw7Var = this.v;
        if (cw7Var != null) {
            cw7Var.c(i3);
        }
        bw7 bw7Var = this.s;
        if (bw7Var != null) {
            bw7Var.e(i3);
        }
        dw7 dw7Var = this.t;
        if (dw7Var != null) {
            dw7Var.d(i3);
        }
        fw7 fw7Var = this.u;
        if (fw7Var != null) {
            fw7Var.y(i3);
        }
        ew7 ew7Var = this.w;
        if (ew7Var != null) {
            ew7Var.d();
        }
        aw7 aw7Var = this.x;
        if (aw7Var != null) {
            aw7Var.c();
        }
        MaskView maskView = this.J1;
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
        h4(this.e0);
        this.C.Y();
        vz7 vz7Var = this.H;
        if (vz7Var != null) {
            vz7Var.H(i3);
        }
        EditorTools editorTools = this.k0;
        if (editorTools != null) {
            editorTools.w(i3);
        }
        rz7 rz7Var = this.J;
        if (rz7Var != null) {
            rz7Var.f(i3);
        }
        if (!ListUtils.isEmpty(this.n)) {
            for (CustomBlueCheckRadioButton customBlueCheckRadioButton : this.n) {
                customBlueCheckRadioButton.c();
            }
        }
        n4();
        UtilHelper.setStatusBarBackground(this.e, i3);
        UtilHelper.setStatusBarBackground(this.W0, i3);
        if (this.y != null) {
            ga5.a(this.c.getPageContext(), this.y);
        }
        ju7 ju7Var = this.h1;
        if (ju7Var != null) {
            ju7Var.h(i3);
        }
        kx7 kx7Var = this.h;
        if (kx7Var != null) {
            gw7 gw7Var2 = this.r;
            if (gw7Var2 != null) {
                gw7Var2.i(i3);
            } else {
                kx7Var.u(i3);
            }
        }
        HeadImageView headImageView = this.t0;
        if (headImageView != null) {
            headImageView.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
        }
        LinearLayout linearLayout = this.s0;
        if (linearLayout != null) {
            linearLayout.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(pi.f(this.c.getContext(), R.dimen.tbds47), SkinManager.getColor(R.color.CAM_X0209)));
        }
        jr7 jr7Var = this.L0;
        if (jr7Var != null && jr7Var.r()) {
            WebPManager.setPureDrawable(this.z0, R.drawable.obfuscated_res_0x7f080940, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
        } else {
            WebPManager.setPureDrawable(this.z0, R.drawable.obfuscated_res_0x7f08093f, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        }
        WebPManager.setPureDrawable(this.x0, R.drawable.obfuscated_res_0x7f080942, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        WebPManager.setPureDrawable(this.u0, R.drawable.obfuscated_res_0x7f08097a, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL);
        l4(this.L0);
        if (this.C0.getVisibility() == 0) {
            this.C0.setBackgroundDrawable(SkinManager.createShapeDrawable(pi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds15), R.color.CAM_X0301, 0, 0, i3));
        }
        SkinManager.setBackgroundColor(this.r0, R.color.CAM_X0207);
        SkinManager.setBackgroundColor(this.q0, R.color.CAM_X0203);
        SkinManager.setViewTextColor(this.r1, (int) R.color.cp_cont_n);
        SkinManager.setViewTextColor(this.v0, (int) R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.G0, (int) R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.F0, (int) R.color.CAM_X0107);
        SkinManager.setBackgroundShapeDrawable(this.F0, pi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18), R.color.CAM_X0207, R.color.CAM_X0207);
        SkinManager.setViewTextColor(this.E0, (int) R.color.CAM_X0107);
        SkinManager.setBackgroundShapeDrawable(this.E0, pi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18), R.color.CAM_X0207, R.color.CAM_X0207);
        AgreeView agreeView = this.y0;
        if (agreeView != null) {
            agreeView.s();
            this.y0.K(i3);
            AgreeData data = this.y0.getData();
            if (data != null) {
                C2(data, data.agreeNum);
            }
        }
        jt7 jt7Var = this.u1;
        if (jt7Var != null) {
            jt7Var.m(i3);
        }
        PbEmotionBar pbEmotionBar = this.c1;
        if (pbEmotionBar != null) {
            pbEmotionBar.w();
        }
        PbThreadPostView pbThreadPostView = this.o;
        if (pbThreadPostView != null) {
            pbThreadPostView.c(i3);
        }
        uz7 uz7Var = this.D0;
        if (uz7Var != null) {
            uz7Var.j();
        }
        tz7 tz7Var = this.I1;
        if (tz7Var != null) {
            tz7Var.c();
        }
        RightFloatLayerView rightFloatLayerView = this.L1;
        if (rightFloatLayerView != null) {
            rightFloatLayerView.o();
        }
        SkinManager.setBackgroundColor(this.V0, R.color.CAM_X0207);
        SkinManager.setViewTextColor(this.V0.findViewById(R.id.obfuscated_res_0x7f0922a1), (int) R.color.CAM_X0105);
    }

    public void d3(String str) {
        jx7 jx7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048699, this, str) == null) || (jx7Var = this.i) == null) {
            return;
        }
        jx7Var.b(str);
    }

    public void d4(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048700, this, str) == null) {
            this.c.showToast(str);
        }
    }

    public final void e0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048701, this) == null) || this.L0 == null || !UbsABTestHelper.isResizeInduceSharingABTest() || gx7.k(this.L0.Q())) {
            return;
        }
        this.D0.f();
        gx7.b(this.L0.Q());
    }

    public String e1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048702, this)) == null) {
            if (!oi.isEmpty(this.B1)) {
                return this.B1;
            }
            if (this.c != null) {
                this.B1 = TbadkCoreApplication.getInst().getResources().getString(lv7.b());
            }
            return this.B1;
        }
        return (String) invokeV.objValue;
    }

    public void e2(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048703, this, configuration) == null) || configuration == null) {
            return;
        }
        m0();
        if (configuration.orientation == 2) {
            o1();
            q1();
        } else {
            M2();
        }
        ju7 ju7Var = this.h1;
        if (ju7Var != null) {
            ju7Var.c();
        }
        this.c.Z5();
        this.B.setVisibility(8);
        this.h.B(false);
        this.c.X6(false);
        if (this.r != null) {
            if (configuration.orientation == 1) {
                l1().setVisibility(0);
            }
            if (configuration.orientation == 2) {
                this.f2 = true;
                this.l.setIsLandscape(true);
                this.l.smoothScrollToPosition(0);
            } else {
                this.f2 = false;
                this.l.setIsLandscape(false);
                int i3 = this.d2;
                if (i3 > 0) {
                    this.l.smoothScrollBy(i3, 0);
                }
            }
            this.r.j(configuration);
            this.S0.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        }
    }

    public void e3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048704, this, z2) == null) {
            this.j1 = z2;
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView != null) {
                this.k1 = pbLandscapeListView.getHeaderViewsCount();
            }
        }
    }

    public void e4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048705, this) == null) {
            this.c.showProgressBar();
        }
    }

    public void f0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048706, this) == null) {
            if (!this.c.checkUpIsLogin()) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 2).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                TiebaStatic.log(new StatisticItem("c10517").param("obj_locate", 2).param("fid", this.h0));
            } else if (!this.c.c5()) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 8).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
            } else {
                n35 K5 = this.c.K5();
                if (K5 != null && (K5.B() || K5.D())) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 10).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                    this.c.K5().z(false, null);
                    return;
                }
                if (this.k0 != null) {
                    B1();
                }
                EditorTools editorTools = this.k0;
                if (editorTools != null) {
                    this.H0 = false;
                    if (editorTools.n(2) != null) {
                        zh8.c(this.c.getPageContext(), (View) this.k0.n(2).m, false, p2);
                    }
                }
                o1();
            }
        }
    }

    public final int f1(PbReplyTitleViewHolder pbReplyTitleViewHolder) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048707, this, pbReplyTitleViewHolder)) == null) {
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

    public void f2() {
        NoNetworkView.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048708, this) == null) {
            nu7 nu7Var = this.p;
            if (nu7Var != null) {
                nu7Var.l();
            }
            RelativeLayout relativeLayout = this.d;
            if (relativeLayout != null && relativeLayout.getHandler() != null) {
                this.d.getHandler().removeCallbacksAndMessages(null);
            }
            uz7 uz7Var = this.D0;
            if (uz7Var != null) {
                uz7Var.k();
            }
            iv7 iv7Var = this.i1;
            if (iv7Var != null) {
                iv7Var.a();
            }
            av7 av7Var = this.x1;
            if (av7Var != null) {
                av7Var.c();
            }
            PbTopTipView pbTopTipView = this.p1;
            if (pbTopTipView != null) {
                pbTopTipView.g();
            }
            this.c.hideProgressBar();
            NoNetworkView noNetworkView = this.m;
            if (noNetworkView != null && (bVar = this.P) != null) {
                noNetworkView.e(bVar);
            }
            m0();
            u0();
            if (this.f1 != null) {
                qg.a().removeCallbacks(this.f1);
            }
            PbInterviewStatusView pbInterviewStatusView = this.R0;
            if (pbInterviewStatusView != null) {
                pbInterviewStatusView.m();
            }
            this.S1 = null;
            this.g.removeCallbacksAndMessages(null);
            this.C.Z(3);
            View view2 = this.e;
            if (view2 != null) {
                view2.setBackgroundDrawable(null);
            }
            gw7 gw7Var = this.r;
            if (gw7Var != null) {
                gw7Var.a();
            }
            xt7 xt7Var = this.C;
            if (xt7Var != null) {
                xt7Var.a0();
            }
            this.l.setOnLayoutListener(null);
            lw7 lw7Var = this.t1;
            if (lw7Var != null) {
                lw7Var.l();
            }
            PbEmotionBar pbEmotionBar = this.c1;
            if (pbEmotionBar != null) {
                pbEmotionBar.x();
            }
            fw7 fw7Var = this.u;
            if (fw7Var != null) {
                fw7Var.z();
            }
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView != null) {
                pbLandscapeListView.getViewTreeObserver().removeGlobalOnLayoutListener(this.a);
            }
        }
    }

    public void f3(PbFragment.g3 g3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048709, this, g3Var) == null) {
        }
    }

    public void f4() {
        FallingView fallingView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048710, this) == null) || (fallingView = this.K1) == null) {
            return;
        }
        fallingView.F();
    }

    public void g0(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048711, this, z2) == null) {
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

    public int g1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048712, this)) == null) ? R.id.obfuscated_res_0x7f091b17 : invokeV.intValue;
    }

    public void g2(TbRichText tbRichText) {
        jr7 jr7Var;
        PostData postData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048713, this, tbRichText) == null) || (jr7Var = this.L0) == null || jr7Var.F() == null || this.L0.F().isEmpty() || tbRichText == null || StringUtils.isNull(tbRichText.getAuthorId())) {
            return;
        }
        for (int i3 = 0; i3 < this.L0.F().size() && (postData = this.L0.F().get(i3)) != null && postData.s() != null && !StringUtils.isNull(postData.s().getUserId()); i3++) {
            if (this.L0.F().get(i3).s().getUserId().equals(tbRichText.getAuthorId())) {
                jt7 jt7Var = this.u1;
                if (jt7Var != null && jt7Var.l()) {
                    D3(false);
                }
                PbEmotionBar pbEmotionBar = this.c1;
                if (pbEmotionBar != null) {
                    pbEmotionBar.q(true);
                }
                postData.s().getName_show();
                return;
            }
        }
    }

    public void g3(TbRichTextView.y yVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048714, this, yVar) == null) {
            this.O = yVar;
            this.C.r0(yVar);
            this.u1.q(this.O);
        }
    }

    public void g4() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048715, this) == null) || this.c2 == null) {
            return;
        }
        while (this.c2.size() > 0) {
            TbImageView remove = this.c2.remove(0);
            if (remove != null) {
                remove.O();
            }
        }
    }

    public final void h0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048716, this) == null) {
            jt7 jt7Var = new jt7(this.c, this, (ViewStub) this.d.findViewById(R.id.obfuscated_res_0x7f0914b0));
            this.u1 = jt7Var;
            jt7Var.o(this.N);
            this.u1.p(this.R);
            this.u1.q(this.O);
            this.u1.o(this.N);
            this.u1.s(this.i0);
        }
    }

    public final int h1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048717, this)) == null) {
            View childAt = this.l.getChildAt(0);
            if (childAt == null) {
                return 0;
            }
            return (-childAt.getTop()) + (this.l.getFirstVisiblePosition() * childAt.getHeight());
        }
        return invokeV.intValue;
    }

    public boolean h2(int i3) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048718, this, i3)) == null) {
            gw7 gw7Var = this.r;
            if (gw7Var != null) {
                return gw7Var.k(i3);
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public void h3(NoNetworkView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048719, this, bVar) == null) {
            this.P = bVar;
            NoNetworkView noNetworkView = this.m;
            if (noNetworkView != null) {
                noNetworkView.a(bVar);
            }
        }
    }

    public void h4(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048720, this, z2) == null) {
            this.e0 = z2;
        }
    }

    public final CustomBlueCheckRadioButton i0(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048721, this, str, str2)) == null) {
            Activity pageActivity = this.c.getPageContext().getPageActivity();
            CustomBlueCheckRadioButton customBlueCheckRadioButton = new CustomBlueCheckRadioButton(pageActivity);
            RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, pi.f(pageActivity, R.dimen.obfuscated_res_0x7f07019a));
            customBlueCheckRadioButton.setOnCheckedChangeListener(this.X);
            customBlueCheckRadioButton.setTag(str);
            customBlueCheckRadioButton.setText(str2);
            customBlueCheckRadioButton.setLayoutParams(layoutParams);
            return customBlueCheckRadioButton;
        }
        return (CustomBlueCheckRadioButton) invokeLL.objValue;
    }

    public int i1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048722, this)) == null) ? this.O0 : invokeV.intValue;
    }

    public void i2() {
        PostData postData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048723, this) == null) || this.c == null) {
            return;
        }
        if ((this.E1 || this.F1 == 17) && UbsABTestHelper.leftSlideToFrs()) {
            jr7 jr7Var = this.L0;
            if (jr7Var == null || jr7Var.l() == null || oi.isEmpty(this.L0.l().getName())) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.c.getContext()).createNormalCfg(this.L0.l().getName(), null)));
            TiebaStatic.log(new StatisticItem("c13853").param("post_id", this.L0.Q()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("fid", this.L0.l().getId()));
        } else if (!this.m1 || this.l1 || (postData = this.M0) == null || postData.s() == null) {
        } else {
            TiebaStatic.log(new StatisticItem("c12601").param("obj_locate", this.c.v0() ? 2 : 1).param("obj_type", this.l1 ? 2 : 1));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.c.getPageContext().getPageActivity(), this.M0.s().getUserId(), this.M0.s().getUserName(), this.c.F().q1(), AddFriendActivityConfig.TYPE_PB_HEAD)));
        }
    }

    public void i3(BdListView.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048724, this, pVar) == null) {
            this.l.setOnSrollToBottomListener(pVar);
        }
    }

    public void i4(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048725, this, z2) == null) {
            this.h.H(z2);
            if (z2 && this.P0) {
                this.I.C(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f03df));
                this.l.setNextPage(this.I);
                this.f = 2;
            }
            Y1();
        }
    }

    public void j0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048726, this) == null) || this.e2) {
            return;
        }
        TiebaStatic.log("c10490");
        this.e2 = true;
        cr4 cr4Var = new cr4(this.c.getPageContext().getPageActivity());
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(i2, Integer.valueOf(k2));
        cr4Var.setTitle(R.string.obfuscated_res_0x7f0f07e6);
        View inflate = LayoutInflater.from(this.c.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0862, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090c00)).setText(R.string.obfuscated_res_0x7f0f0786);
        ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0920ee)).setText(R.string.obfuscated_res_0x7f0f07e6);
        cr4Var.setContentView(inflate);
        cr4Var.setYesButtonTag(sparseArray);
        cr4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f07e5, this.c);
        cr4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0a5b, new n0(this));
        cr4Var.create(this.c.getPageContext()).show();
    }

    public View j1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048727, this)) == null) ? this.e : (View) invokeV.objValue;
    }

    public void j2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048728, this, z2) == null) {
            if (z2) {
                J3();
            } else {
                r1();
            }
            this.b1.c = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.b1));
            z2(this.b1.c, false);
        }
    }

    public void j3(AbsListView.OnScrollListener onScrollListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048729, this, onScrollListener) == null) {
            this.l.setOnScrollListener(onScrollListener);
        }
    }

    public void j4(hr7 hr7Var) {
        String string;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048730, this, hr7Var) == null) || hr7Var == null) {
            return;
        }
        this.h.I();
        if (!StringUtils.isNull(hr7Var.b)) {
            this.h.F(hr7Var.b);
        }
        String string2 = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f13d7);
        int e2 = ng.e(hr7Var.a, 0);
        if (e2 == 100) {
            string = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f1109);
        } else if (e2 != 300) {
            string = e2 != 400 ? "" : TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f1351);
        } else {
            string = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f02f1);
        }
        this.c.showNetRefreshView(this.d, String.format(string2, string), null, TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f029a), true, new i0(this, hr7Var.c));
    }

    public void k0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048731, this, str) == null) {
            if (str.contains("_")) {
                str = str.replace("_", "\n");
            }
            cr4 cr4Var = new cr4(this.c.getPageContext().getPageActivity());
            View inflate = LayoutInflater.from(this.c.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0862, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0920ee);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(0, 0, 0, 0);
            textView.setLayoutParams(layoutParams);
            textView.setGravity(3);
            textView.setText(str);
            ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090c00)).setVisibility(8);
            cr4Var.setContentView(inflate);
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(i2, Integer.valueOf(l2));
            cr4Var.setYesButtonTag(sparseArray);
            cr4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f1547, this.c);
            cr4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f036a, new o0(this));
            cr4Var.create(this.c.getPageContext()).show();
        }
    }

    public PbThreadPostView k1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048732, this)) == null) ? this.o : (PbThreadPostView) invokeV.objValue;
    }

    public void k2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048733, this) == null) {
            g4();
            this.C.Z(1);
            gw7 gw7Var = this.r;
            if (gw7Var != null) {
                gw7Var.l();
            }
            nu7 nu7Var = this.p;
            if (nu7Var != null) {
                nu7Var.k();
            }
            RightFloatLayerView rightFloatLayerView = this.L1;
            if (rightFloatLayerView != null && (rightFloatLayerView instanceof RightFloatLayerLottieView)) {
                ((RightFloatLayerLottieView) rightFloatLayerView).H(600);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
        }
    }

    public void k3(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048734, this, onClickListener) == null) {
            this.C.v0(onClickListener);
        }
    }

    public final void k4() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048735, this) == null) || (pbFragment = this.c) == null || pbFragment.K5() == null) {
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921706, Boolean.valueOf(!this.c.K5().C())));
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x004d, code lost:
        if (r5.G1 == 1) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void l0() {
        tz7 tz7Var;
        boolean z2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048736, this) == null) || (tz7Var = this.I1) == null) {
            return;
        }
        if (((tz7Var.a() == null || this.I1.a().getParent() == null) ? -1 : this.l.getPositionForView(this.I1.a())) != -1) {
            if (this.I1.a().getTop() + n2 <= this.U0.getBottom()) {
                this.G1 = 1;
                z2 = true;
            } else {
                this.G1 = 0;
                z2 = false;
            }
        }
        this.X0.t(this.G1 == 1);
        this.I1.e(z2);
    }

    public RelativeLayout l1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048737, this)) == null) ? this.B : (RelativeLayout) invokeV.objValue;
    }

    public void l2(qn qnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048738, this, qnVar) == null) {
            PbLandscapeListView pbLandscapeListView = this.l;
            pbLandscapeListView.h0 = qnVar;
            pbLandscapeListView.W = true;
        }
    }

    public void l3(int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048739, this, i3) == null) {
            this.F1 = i3;
        }
    }

    public void l4(jr7 jr7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048740, this, jr7Var) == null) {
            if (jr7Var != null && AntiHelper.o(jr7Var.O())) {
                uz7 uz7Var = this.D0;
                if (uz7Var != null) {
                    uz7Var.l(false);
                    this.D0.k();
                }
                ViewGroup.LayoutParams layoutParams = this.A0.getLayoutParams();
                layoutParams.height = -2;
                layoutParams.width = -2;
                this.A0.setLayoutParams(layoutParams);
                WebPManager.setPureDrawable(this.A0, R.drawable.obfuscated_res_0x7f080944, R.color.CAM_X0110, WebPManager.ResourceStateType.NORMAL_PRESS);
                return;
            }
            uz7 uz7Var2 = this.D0;
            if (uz7Var2 == null || !uz7Var2.h()) {
                ViewGroup.LayoutParams layoutParams2 = this.A0.getLayoutParams();
                layoutParams2.height = -2;
                layoutParams2.width = -2;
                this.A0.setLayoutParams(layoutParams2);
                WebPManager.setPureDrawable(this.A0, R.drawable.obfuscated_res_0x7f080944, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            }
        }
    }

    public void m0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048741, this) == null) {
            this.h.k();
            fw7 fw7Var = this.u;
            if (fw7Var != null) {
                fw7Var.p();
            }
            PbFragment pbFragment = this.c;
            if (pbFragment != null) {
                pi.x(pbFragment.getContext(), this.G);
            }
            q1();
            lr4 lr4Var = this.b0;
            if (lr4Var != null) {
                lr4Var.dismiss();
            }
            q0();
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

    public View m1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048742, this)) == null) ? this.d : (View) invokeV.objValue;
    }

    public void m2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048743, this) == null) {
            this.C.Z(2);
            gw7 gw7Var = this.r;
            if (gw7Var != null) {
                gw7Var.m();
                if (!TbSingleton.getInstance().isNotchScreen(this.c.getFragmentActivity()) && !TbSingleton.getInstance().isCutoutScreen(this.c.getFragmentActivity())) {
                    m1().setSystemUiVisibility(4);
                }
            }
            n2();
        }
    }

    public void m3(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048744, this, onLongClickListener) == null) {
            this.u.D(onLongClickListener);
            this.C.s0(onLongClickListener);
            jt7 jt7Var = this.u1;
            if (jt7Var != null) {
                jt7Var.r(onLongClickListener);
            }
        }
    }

    public boolean m4(jr7 jr7Var, boolean z2) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048745, this, jr7Var, z2)) == null) {
            if (jr7Var == null) {
                return false;
            }
            if (this.t != null) {
                if (jr7Var.O() != null && jr7Var.O().getIsNoTitle() == 0 && !jr7Var.O().isVideoThreadType() && !this.N1) {
                    if (jr7Var.O() != null) {
                        ThreadData O = jr7Var.O();
                        O.parserSpecTitleForFrsAndPb(true, G3(jr7Var));
                        O.setResource(3);
                        O.setPbTitle("2");
                    }
                    if (jr7Var.O().isBJHArticleThreadType()) {
                        this.u.B(this.l);
                        this.t.e(this.l);
                        this.t.a(this.l);
                        this.u.m(this.l);
                        this.u.G(this.L0);
                        if (I1(jr7Var)) {
                            this.t.e(this.l);
                        } else {
                            this.t.f(jr7Var);
                        }
                    } else {
                        this.u.G(this.L0);
                        if (I1(jr7Var)) {
                            this.t.e(this.l);
                        } else {
                            this.t.h(jr7Var);
                        }
                    }
                } else if (jr7Var.O().getIsNoTitle() == 1) {
                    if (jr7Var.O() != null) {
                        this.t.e(this.l);
                        this.u.G(this.L0);
                    }
                } else {
                    this.t.e(this.l);
                    this.u.G(this.L0);
                }
            }
            b4(jr7Var);
            this.K0 = z2;
            return false;
        }
        return invokeLZ.booleanValue;
    }

    public void n0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048746, this) == null) {
            this.h.k();
            fw7 fw7Var = this.u;
            if (fw7Var != null) {
                fw7Var.p();
            }
            lr4 lr4Var = this.b0;
            if (lr4Var != null) {
                lr4Var.dismiss();
            }
            q0();
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

    public void n1() {
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048747, this) == null) {
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView != null) {
                pbLandscapeListView.setVisibility(8);
            }
            if (this.l != null) {
                this.S0.setVisibility(8);
            }
            kx7 kx7Var = this.h;
            if (kx7Var == null || (view2 = kx7Var.d) == null) {
                return;
            }
            view2.setVisibility(8);
        }
    }

    public final void n2() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048748, this) == null) || (pbFragment = this.c) == null || pbFragment.K5() == null) {
            return;
        }
        this.c.K5().K();
    }

    public final void n3(PostData postData, jr7 jr7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048749, this, postData, jr7Var) == null) {
            this.u.E(postData, jr7Var);
        }
    }

    public final void n4() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048750, this) == null) && this.c.C5()) {
            if (this.c.H5() == -1) {
                SkinManager.setViewTextColor(this.z, R.color.CAM_X0110, 1);
            }
            if (this.c.G5() == -1) {
                SkinManager.setViewTextColor(this.A, R.color.CAM_X0110, 1);
            }
        }
    }

    public void o0() {
        uz7 uz7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048751, this) == null) || (uz7Var = this.D0) == null) {
            return;
        }
        uz7Var.l(false);
    }

    public void o1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048752, this) == null) || this.r0 == null) {
            return;
        }
        this.q0.setVisibility(8);
        this.r0.setVisibility(8);
        this.H0 = false;
        PbEmotionBar pbEmotionBar = this.c1;
        if (pbEmotionBar != null) {
            pbEmotionBar.setVisibility(8);
            L2(false);
        }
    }

    public void o2(AbsListView absListView, int i3, int i4, int i5) {
        PbReplyTitleViewHolder pbReplyTitleViewHolder;
        fw7 fw7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048753, this, absListView, i3, i4, i5) == null) {
            mu7 mu7Var = this.q;
            if (mu7Var != null) {
                mu7Var.c(i3, i4);
            }
            gw7 gw7Var = this.r;
            if (gw7Var != null) {
                gw7Var.n(absListView, i3, i4, i5);
            }
            kx7 kx7Var = this.h;
            if (kx7Var != null && (fw7Var = this.u) != null) {
                kx7Var.w(fw7Var.s());
            }
            w0 w0Var = this.b1;
            w0Var.a = i3;
            w0Var.b = this.l.getHeaderViewsCount();
            this.b1.c = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.b1));
            C3(a0(absListView, i3));
            int i6 = 0;
            z2(this.b1.c, false);
            l0();
            if (!this.I.n() || this.I.C) {
                return;
            }
            w0 w0Var2 = this.b1;
            if (w0Var2 != null && (pbReplyTitleViewHolder = w0Var2.c) != null && pbReplyTitleViewHolder.b() != null) {
                i6 = this.b1.c.b().getTop() < 0 ? this.b1.c.b().getHeight() : this.b1.c.b().getBottom();
            }
            this.I.e(i6);
            this.I.C = true;
        }
    }

    public void o3(boolean z2, PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048754, this, z2, postWriteCallBackData) == null) {
            this.c.hideProgressBar();
            if (z2) {
                m0();
            } else if (postWriteCallBackData != null && (postWriteCallBackData.isSensitiveError() || postWriteCallBackData.isErrorLinkCountExceedLimit() || postWriteCallBackData.isErrorShowApplyMemberDialog())) {
                n0();
            } else {
                m0();
            }
        }
    }

    public void o4(jr7 jr7Var) {
        bw7 bw7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048755, this, jr7Var) == null) || (bw7Var = this.s) == null) {
            return;
        }
        bw7Var.h(jr7Var, this.K0);
    }

    public final boolean p0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048756, this)) == null) ? this.s.b(this.K0) : invokeV.booleanValue;
    }

    public void p1(boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048757, this, z2) == null) || this.r0 == null || this.v0 == null) {
            return;
        }
        TbSingleton tbSingleton = TbSingleton.getInstance();
        jr7 jr7Var = this.L0;
        boolean z3 = jr7Var != null && jr7Var.k0();
        jr7 jr7Var2 = this.L0;
        this.v0.setText(tbSingleton.getAdVertiComment(z3, jr7Var2 != null && jr7Var2.l0(), e1()));
        if (z2) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(400L);
            this.r0.startAnimation(alphaAnimation);
        }
        this.q0.setVisibility(0);
        this.r0.setVisibility(0);
        this.H0 = true;
        if (this.c1 == null || this.u1.l()) {
            return;
        }
        this.c1.setVisibility(0);
        L2(true);
    }

    public void p2(AbsListView absListView, int i3) {
        RightFloatLayerView rightFloatLayerView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048758, this, absListView, i3) == null) {
            gw7 gw7Var = this.r;
            if (gw7Var != null) {
                gw7Var.o(absListView, i3);
            }
            if (!this.f2 && i3 == 0) {
                this.d2 = h1();
                this.b1.c = null;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.b1));
                z2(this.b1.c, true);
                l0();
                this.C.e0(true);
            }
            this.C.d0();
            if (i3 == 0) {
                RightFloatLayerView rightFloatLayerView2 = this.L1;
                if (rightFloatLayerView2 != null) {
                    rightFloatLayerView2.q();
                }
            } else if (i3 == 1) {
                RightFloatLayerView rightFloatLayerView3 = this.L1;
                if (rightFloatLayerView3 != null) {
                    rightFloatLayerView3.p();
                }
            } else if (i3 != 2 || (rightFloatLayerView = this.L1) == null) {
            } else {
                rightFloatLayerView.r();
            }
        }
    }

    public void p3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048759, this) == null) {
            this.c.hideProgressBar();
            jr7 jr7Var = this.L0;
            if (jr7Var != null && this.I != null && jr7Var.y() != null && this.L0.y().b() == 0) {
                this.I.u(this.L0.t());
                if (this.L0.t()) {
                    StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_PB_FOLD_ICON_SHOW);
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem.param("fid", this.L0.m());
                    statisticItem.param("fname", this.L0.n());
                    statisticItem.param("tid", this.L0.Q());
                    TiebaStatic.log(statisticItem);
                }
            }
            u0();
            this.l.A(0L);
            p0();
        }
    }

    public void q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048760, this) == null) {
            cr4 cr4Var = this.S;
            if (cr4Var != null) {
                cr4Var.dismiss();
            }
            Dialog dialog = this.T;
            if (dialog != null) {
                sg.b(dialog, this.c.getPageContext());
            }
            Dialog dialog2 = this.U;
            if (dialog2 != null) {
                sg.b(dialog2, this.c.getPageContext());
            }
            lr4 lr4Var = this.Q;
            if (lr4Var != null) {
                lr4Var.dismiss();
            }
        }
    }

    public void q1() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048761, this) == null) || (editorTools = this.k0) == null) {
            return;
        }
        editorTools.o();
        lw7 lw7Var = this.t1;
        if (lw7Var != null) {
            lw7Var.m();
        }
    }

    public void q2(ArrayList<ap4> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048762, this, arrayList) == null) {
            if (this.V == null) {
                this.V = LayoutInflater.from(this.c.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d01e1, (ViewGroup) null);
            }
            this.c.getBaseFragmentActivity().getLayoutMode().j(this.V);
            if (this.U == null) {
                Dialog dialog = new Dialog(this.c.getPageContext().getPageActivity(), R.style.obfuscated_res_0x7f1003a0);
                this.U = dialog;
                dialog.setCanceledOnTouchOutside(true);
                this.U.setCancelable(true);
                this.j0 = (ScrollView) this.V.findViewById(R.id.obfuscated_res_0x7f090c89);
                this.U.setContentView(this.V);
                WindowManager.LayoutParams attributes = this.U.getWindow().getAttributes();
                attributes.width = pi.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0702dd);
                this.U.getWindow().setAttributes(attributes);
                this.X = new a0(this);
                this.W = (LinearLayout) this.V.findViewById(R.id.obfuscated_res_0x7f090c88);
                TextView textView = (TextView) this.V.findViewById(R.id.obfuscated_res_0x7f090775);
                this.Z = textView;
                textView.setOnClickListener(new b0(this));
                TextView textView2 = (TextView) this.V.findViewById(R.id.obfuscated_res_0x7f090776);
                this.Y = textView2;
                textView2.setOnClickListener(this.N);
            }
            this.W.removeAllViews();
            this.n = new ArrayList();
            CustomBlueCheckRadioButton i02 = i0("0", this.c.getPageContext().getString(R.string.obfuscated_res_0x7f0f13dc));
            this.n.add(i02);
            i02.setChecked(true);
            this.W.addView(i02);
            if (arrayList != null) {
                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                    ap4 ap4Var = arrayList.get(i3);
                    if (ap4Var != null && !TextUtils.isEmpty(ap4Var.b()) && ap4Var.a() > 0) {
                        CustomBlueCheckRadioButton i03 = i0(String.valueOf(ap4Var.a()), ap4Var.b());
                        this.n.add(i03);
                        View view2 = new View(this.c.getPageContext().getPageActivity());
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, pi.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f070198));
                        SkinManager.setBackgroundColor(view2, R.color.CAM_X0204);
                        view2.setLayoutParams(layoutParams);
                        this.W.addView(view2);
                        this.W.addView(i03);
                    }
                }
                ViewGroup.LayoutParams layoutParams2 = this.j0.getLayoutParams();
                int size = arrayList.size();
                if (size == 0 || size == 1) {
                    layoutParams2.height = pi.d(this.c.getPageContext().getPageActivity(), 120.0f);
                } else if (size != 2) {
                    layoutParams2.height = pi.d(this.c.getPageContext().getPageActivity(), 220.0f);
                } else {
                    layoutParams2.height = pi.d(this.c.getPageContext().getPageActivity(), 186.0f);
                }
                this.j0.setLayoutParams(layoutParams2);
                this.j0.removeAllViews();
                LinearLayout linearLayout = this.W;
                if (linearLayout != null && linearLayout.getParent() == null) {
                    this.j0.addView(this.W);
                }
            }
            sg.j(this.U, this.c.getPageContext());
        }
    }

    public void q3() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048763, this) == null) || (pbFragment = this.c) == null || pbFragment.getBaseFragmentActivity() == null) {
            return;
        }
        pi.x(this.c.getPageContext().getPageActivity(), this.c.getBaseFragmentActivity().getCurrentFocus());
    }

    public void r0() {
        gw7 gw7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048764, this) == null) || (gw7Var = this.r) == null) {
            return;
        }
        gw7Var.b();
    }

    public void r1() {
        kx7 kx7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048765, this) == null) || (kx7Var = this.h) == null) {
            return;
        }
        kx7Var.q();
    }

    public void r2(int i3, String str, int i4, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048766, this, new Object[]{Integer.valueOf(i3), str, Integer.valueOf(i4), Boolean.valueOf(z2)}) == null) {
            s2(i3, str, i4, z2, null);
        }
    }

    public void r3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048767, this) == null) {
            this.I.z();
            this.I.Q();
        }
    }

    public void s0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048768, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c14693");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_locate", o2);
            TiebaStatic.log(statisticItem);
        }
    }

    public void s1() {
        au4 au4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048769, this) == null) || (au4Var = this.J0) == null) {
            return;
        }
        au4Var.h(false);
    }

    public void s2(int i3, String str, int i4, boolean z2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048770, this, new Object[]{Integer.valueOf(i3), str, Integer.valueOf(i4), Boolean.valueOf(z2), str2}) == null) {
            t2(i3, str, i4, z2, str2, false);
        }
    }

    public void s3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048771, this, z2) == null) {
            this.u.F(z2);
        }
    }

    public void t0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048772, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c14692");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_locate", o2);
            TiebaStatic.log(statisticItem);
        }
    }

    public void t1() {
        Runnable runnable;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048773, this) == null) {
            if (this.y == null) {
                A1();
            }
            this.k.setVisibility(8);
            Handler handler = this.S1;
            if (handler == null || (runnable = this.T1) == null) {
                return;
            }
            handler.removeCallbacks(runnable);
        }
    }

    public void t2(int i3, String str, int i4, boolean z2, String str2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048774, this, new Object[]{Integer.valueOf(i3), str, Integer.valueOf(i4), Boolean.valueOf(z2), str2, Boolean.valueOf(z3)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(R.id.obfuscated_res_0x7f091eef, str);
            sparseArray.put(R.id.obfuscated_res_0x7f091ef1, Integer.valueOf(i3));
            sparseArray.put(R.id.obfuscated_res_0x7f091f0c, Integer.valueOf(i4));
            sparseArray.put(R.id.obfuscated_res_0x7f091ef0, Boolean.valueOf(z2));
            sparseArray.put(i2, Integer.valueOf(j2));
            int i5 = (i4 != 1002 || z2) ? R.string.obfuscated_res_0x7f0f0494 : R.string.obfuscated_res_0x7f0f0fd3;
            int i6 = R.string.obfuscated_res_0x7f0f042f;
            if (i3 == 0) {
                if (i4 != 1002 || z2) {
                    i6 = R.string.obfuscated_res_0x7f0f0498;
                    i5 = R.string.obfuscated_res_0x7f0f0499;
                } else {
                    i5 = R.string.obfuscated_res_0x7f0f0fd7;
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
            this.S.setPositiveButton(R.string.obfuscated_res_0x7f0f04e5, this.c);
            this.S.setNegativeButton(R.string.obfuscated_res_0x7f0f04e0, new s(this));
            this.S.setCancelable(true);
            this.S.create(this.c.getPageContext());
            if (z3) {
                F3(sparseArray, i6, i5);
            } else if (z2) {
                F3(sparseArray, i6, i5);
            } else if (w3()) {
                nj5 nj5Var = new nj5(this.c.F().R1().l().getDeletedReasonInfo().is_grays_cale_forum.intValue(), this.c.F().R1().l().getDeletedReasonInfo().is_boomgrow.intValue(), this.c.F().R1().o().has_forum_rule.intValue());
                nj5Var.i(this.c.F().R1().l().getId(), this.c.F().R1().l().getName());
                nj5Var.h(this.c.F().R1().l().getImage_url());
                nj5Var.j(this.c.F().R1().l().getUser_level());
                M3(sparseArray, i3, nj5Var, this.c.F().R1().U(), false);
            } else {
                U3(this.S, i3);
            }
        }
    }

    public void t3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048775, this, str) == null) {
            this.v0.performClick();
            if (StringUtils.isNull(str) || this.c.K5() == null || this.c.K5().v() == null || this.c.K5().v().i() == null) {
                return;
            }
            EditText i3 = this.c.K5().v().i();
            i3.setText(str);
            i3.setSelection(str.length());
        }
    }

    public void u0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048776, this) == null) {
            PbListView pbListView = this.I;
            if (pbListView != null) {
                pbListView.x();
                this.I.f();
            }
            s1();
        }
    }

    public void u1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048777, this) == null) {
            this.M.setVisibility(8);
        }
    }

    public void u2(int i3, String str, int i4, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048778, this, new Object[]{Integer.valueOf(i3), str, Integer.valueOf(i4), Boolean.valueOf(z2)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(R.id.obfuscated_res_0x7f091eef, str);
            sparseArray.put(R.id.obfuscated_res_0x7f091ef1, Integer.valueOf(i3));
            sparseArray.put(R.id.obfuscated_res_0x7f091f0c, Integer.valueOf(i4));
            sparseArray.put(R.id.obfuscated_res_0x7f091ef0, Boolean.valueOf(z2));
            sparseArray.put(i2, Integer.valueOf(j2));
            if (z2) {
                A3(sparseArray);
            } else {
                B3(i3, sparseArray);
            }
        }
    }

    public void u3(int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048779, this, i3) == null) {
            this.l.setSelection(i3);
        }
    }

    public void v0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048780, this) == null) {
            this.l.A(0L);
            p0();
        }
    }

    public void v1() {
        RightFloatLayerView rightFloatLayerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048781, this) == null) || (rightFloatLayerView = this.L1) == null) {
            return;
        }
        rightFloatLayerView.c();
    }

    public void v2(SparseArray<Object> sparseArray, boolean z2) {
        jr4 jr4Var;
        jr4 jr4Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048782, this, sparseArray, z2) == null) {
            nr4 nr4Var = new nr4(this.c.getContext());
            nr4Var.q(this.c.getString(R.string.obfuscated_res_0x7f0f02df));
            nr4Var.n(new r(this, z2));
            ArrayList arrayList = new ArrayList();
            int intValue = sparseArray.get(R.id.obfuscated_res_0x7f091ee9) instanceof Integer ? ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091ee9)).intValue() : -1;
            if (!"".equals(sparseArray.get(R.id.obfuscated_res_0x7f091eef)) && intValue != 2) {
                if ((sparseArray.get(R.id.obfuscated_res_0x7f091ef1) instanceof Integer ? ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091ef1)).intValue() : -1) == 0) {
                    jr4Var2 = new jr4(10, this.c.getString(R.string.obfuscated_res_0x7f0f04aa), nr4Var);
                } else {
                    jr4Var2 = new jr4(10, this.c.getString(R.string.obfuscated_res_0x7f0f049f), nr4Var);
                }
                SparseArray sparseArray2 = new SparseArray();
                sparseArray2.put(R.id.obfuscated_res_0x7f091eef, sparseArray.get(R.id.obfuscated_res_0x7f091eef));
                sparseArray2.put(R.id.obfuscated_res_0x7f091ef1, sparseArray.get(R.id.obfuscated_res_0x7f091ef1));
                sparseArray2.put(R.id.obfuscated_res_0x7f091ef0, sparseArray.get(R.id.obfuscated_res_0x7f091ef0));
                sparseArray2.put(R.id.obfuscated_res_0x7f091f0c, sparseArray.get(R.id.obfuscated_res_0x7f091f0c));
                jr4Var2.d.setTag(sparseArray2);
                arrayList.add(jr4Var2);
            }
            if ((!"".equals(sparseArray.get(R.id.obfuscated_res_0x7f091efa)) || !"".equals(sparseArray.get(R.id.obfuscated_res_0x7f091efb))) && !S1()) {
                SparseArray sparseArray3 = new SparseArray();
                sparseArray3.put(R.id.obfuscated_res_0x7f091efa, sparseArray.get(R.id.obfuscated_res_0x7f091efa));
                sparseArray3.put(R.id.obfuscated_res_0x7f091efb, sparseArray.get(R.id.obfuscated_res_0x7f091efb));
                sparseArray3.put(R.id.obfuscated_res_0x7f091efc, sparseArray.get(R.id.obfuscated_res_0x7f091efc));
                sparseArray3.put(R.id.obfuscated_res_0x7f091f0c, sparseArray.get(R.id.obfuscated_res_0x7f091f0c));
                sparseArray3.put(R.id.obfuscated_res_0x7f091efd, sparseArray.get(R.id.obfuscated_res_0x7f091efd));
                jr4 jr4Var3 = new jr4(11, this.c.getString(R.string.obfuscated_res_0x7f0f064a), nr4Var);
                jr4Var3.d.setTag(sparseArray3);
                arrayList.add(jr4Var3);
            }
            if ((sparseArray.get(R.id.obfuscated_res_0x7f091f44) instanceof Boolean) && ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091f44)).booleanValue()) {
                SparseArray sparseArray4 = new SparseArray();
                sparseArray4.put(R.id.obfuscated_res_0x7f091f04, sparseArray.get(R.id.obfuscated_res_0x7f091f04));
                sparseArray4.put(R.id.obfuscated_res_0x7f091f40, sparseArray.get(R.id.obfuscated_res_0x7f091f40));
                sparseArray4.put(R.id.obfuscated_res_0x7f091f41, sparseArray.get(R.id.obfuscated_res_0x7f091f41));
                sparseArray4.put(R.id.obfuscated_res_0x7f091f3f, sparseArray.get(R.id.obfuscated_res_0x7f091f3f));
                sparseArray4.put(R.id.obfuscated_res_0x7f091f42, sparseArray.get(R.id.obfuscated_res_0x7f091f42));
                sparseArray4.put(R.id.obfuscated_res_0x7f091f43, sparseArray.get(R.id.obfuscated_res_0x7f091f43));
                sparseArray4.put(R.id.obfuscated_res_0x7f091f3e, sparseArray.get(R.id.obfuscated_res_0x7f091f3e));
                if (z2) {
                    jr4Var = new jr4(12, this.c.getString(R.string.obfuscated_res_0x7f0f14aa), nr4Var);
                } else {
                    jr4Var = new jr4(12, this.c.getString(R.string.obfuscated_res_0x7f0f0b1f), nr4Var);
                }
                jr4Var.d.setTag(sparseArray4);
                arrayList.add(jr4Var);
            }
            fx7.e(arrayList);
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

    public void v3(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048783, this, list) == null) {
            this.s1 = list;
            lw7 lw7Var = this.t1;
            if (lw7Var != null) {
                lw7Var.q(list);
            }
        }
    }

    public void w0(int i3, boolean z2, String str, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048784, this, new Object[]{Integer.valueOf(i3), Boolean.valueOf(z2), str, Boolean.valueOf(z3)}) == null) {
            this.c.hideProgressBar();
            if (z2 && z3) {
                PbFragment pbFragment = this.c;
                pbFragment.showToast(pbFragment.getPageContext().getString(R.string.obfuscated_res_0x7f0f122f));
            } else if (z3) {
                if (oi.isEmpty(str)) {
                    str = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0c2b);
                }
                this.c.showToast(str);
            }
        }
    }

    public void w1() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048785, this) == null) || (editorTools = this.k0) == null) {
            return;
        }
        editorTools.q();
    }

    public void w2(View view2) {
        SparseArray<Object> sparseArray;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048786, this, view2) == null) || (sparseArray = (SparseArray) view2.getTag()) == null) {
            return;
        }
        v2(sparseArray, false);
    }

    public final boolean w3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048787, this)) == null) {
            PbFragment pbFragment = this.c;
            return (pbFragment == null || pbFragment.F().R1().l().getDeletedReasonInfo() == null || 1 != this.c.F().R1().l().getDeletedReasonInfo().is_grays_cale_forum.intValue()) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public void x0() {
        PbLandscapeListView pbLandscapeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048788, this) == null) || (pbLandscapeListView = this.l) == null) {
            return;
        }
        pbLandscapeListView.setForbidDragListener(true);
    }

    public final void x1() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048789, this) == null) && this.x == null && (pbFragment = this.c) != null) {
            this.x = new aw7(pbFragment.getContext());
        }
    }

    public void x2(@NonNull View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048790, this, view2) == null) || this.y0.getData() == null || !this.y0.getData().hasAgree || this.c.getActivity() == null) {
            return;
        }
        nq7 nq7Var = new nq7(this.c.getContext());
        int f2 = pi.f(TbadkCoreApplication.getInst(), R.dimen.tbds774);
        int f3 = pi.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f07077c);
        int[] iArr = new int[2];
        view2.getLocationInWindow(iArr);
        int i3 = iArr[0];
        int i4 = iArr[1];
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(f3, f2);
        layoutParams.leftMargin = ((view2.getWidth() / 2) + i3) - ((int) ((f3 * 1) / 1.45d));
        layoutParams.topMargin = pi.f(TbadkCoreApplication.getInst(), R.dimen.M_H_X006);
        nq7Var.k(f2);
        nq7Var.j(layoutParams);
        nq7Var.i(false);
        nq7Var.n(true, this.c.getActivity().findViewById(16908290), 0, i4, this.L0.Q(), this.L0.m());
        nq7Var.l(new k(this));
    }

    public final void x3() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048791, this) == null) || (pbFragment = this.c) == null || pbFragment.getActivity() == null) {
            return;
        }
        if (this.y0.getWidth() != 0 && this.y0.getHeight() != 0) {
            WaterRippleView waterRippleView = this.w0;
            if (waterRippleView == null) {
                this.w0 = new WaterRippleView(this.c.getActivity());
            } else {
                ViewParent parent = waterRippleView.getParent();
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(this.w0);
                }
            }
            Rect rect = new Rect();
            this.d.getGlobalVisibleRect(rect);
            Rect rect2 = new Rect();
            this.y0.getImgAgree().getGlobalVisibleRect(rect2);
            int f2 = pi.f(this.c.getActivity(), R.dimen.tbds166);
            int i3 = ((rect2.right + rect2.left) / 2) - f2;
            int i4 = (rect.bottom - ((rect2.bottom + rect2.top) / 2)) - f2;
            int i5 = f2 * 2;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i5, i5);
            layoutParams.addRule(12, -1);
            layoutParams.setMargins(i3, 0, 0, i4);
            this.d.addView(this.w0, layoutParams);
            TextView textView = this.E0;
            if (textView != null) {
                textView.setVisibility(4);
                return;
            }
            return;
        }
        BdLog.e("AgreeView not measured");
    }

    public final String y0(long j3) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048792, this, j3)) == null) {
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

    public final void y1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048793, this) == null) && this.t == null) {
            this.t = new dw7(this.c, this.i0);
        }
    }

    public void y2(d05 d05Var, int i3) {
        FallingView fallingView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048794, this, d05Var, i3) == null) || (fallingView = this.K1) == null) {
            return;
        }
        fallingView.D(d05Var, this.c.getPageContext(), i3, false);
    }

    public void y3() {
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048795, this) == null) {
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView != null) {
                pbLandscapeListView.setVisibility(0);
            }
            FrameLayout frameLayout = this.S0;
            if (frameLayout != null) {
                frameLayout.setVisibility(0);
            }
            kx7 kx7Var = this.h;
            if (kx7Var == null || (view2 = kx7Var.d) == null) {
                return;
            }
            view2.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
        }
    }

    public final String z0(int i3) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048796, this, i3)) == null) {
            if (i3 == 0) {
                return this.c.getString(R.string.obfuscated_res_0x7f0f0daf);
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

    public final void z1(jr7 jr7Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048797, this, jr7Var) == null) && jr7Var != null && jr7Var.O() != null && jr7Var.O().isInterviewLive() && this.R0 == null) {
            PbInterviewStatusView pbInterviewStatusView = (PbInterviewStatusView) this.Q0.inflate();
            this.R0 = pbInterviewStatusView;
            pbInterviewStatusView.setOnClickListener(this.N);
            this.R0.setCallback(this.c.A5());
            this.R0.setData(this.c, jr7Var);
        }
    }

    public final void z2(PbReplyTitleViewHolder pbReplyTitleViewHolder, boolean z2) {
        int measuredHeight;
        int i3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048798, this, pbReplyTitleViewHolder, z2) == null) || this.l1 || this.U0 == null || this.h.p() == null) {
            return;
        }
        View r2 = A0().r();
        if (r2 != null) {
            int[] iArr = new int[2];
            r2.getLocationInWindow(iArr);
            int i4 = iArr[1];
            if (i4 != 0) {
                if (this.U0.getVisibility() == 0 && i4 - this.h.p().getBottom() <= this.U0.getHeight()) {
                    this.V0.setVisibility(0);
                    if (i4 > this.h.p().getBottom()) {
                        i3 = -(((this.U0.getHeight() + this.V0.getHeight()) + this.h.p().getBottom()) - r2.getBottom());
                    } else {
                        i3 = -this.U0.getHeight();
                    }
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.U0.getLayoutParams();
                    if (layoutParams.topMargin != i3) {
                        layoutParams.topMargin = i3;
                        this.U0.setLayoutParams(layoutParams);
                    }
                } else {
                    this.V0.setVisibility(4);
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.U0.getLayoutParams();
                    if (layoutParams2.topMargin != 0) {
                        layoutParams2.topMargin = 0;
                        this.U0.setLayoutParams(layoutParams2);
                    }
                }
            }
        }
        int G = this.C.G();
        if (G > 0 && (pbReplyTitleViewHolder == null || pbReplyTitleViewHolder.b().getParent() == null)) {
            if (G > this.l.getFirstVisiblePosition() - this.l.getHeaderViewsCount()) {
                this.U0.setVisibility(4);
                return;
            }
            this.U0.setVisibility(0);
            C3(false);
            this.h.a.hideBottomLine();
            if (this.U0.getParent() == null || ((ViewGroup) this.U0.getParent()).getHeight() > this.U0.getTop()) {
                return;
            }
            this.U0.getParent().requestLayout();
        } else if (pbReplyTitleViewHolder != null && pbReplyTitleViewHolder.b() != null && pbReplyTitleViewHolder.g != null) {
            int top = pbReplyTitleViewHolder.b().getTop();
            if (pbReplyTitleViewHolder.b().getParent() != null) {
                if (this.a1) {
                    this.Z0 = top;
                    this.a1 = false;
                }
                int i5 = this.Z0;
                if (top < i5) {
                    i5 = top;
                }
                this.Z0 = i5;
            }
            if (top != 0 || pbReplyTitleViewHolder.b().isShown()) {
                if (this.B.getY() < 0.0f) {
                    measuredHeight = g2 - pbReplyTitleViewHolder.g.getMeasuredHeight();
                } else {
                    measuredHeight = this.h.p().getMeasuredHeight() - pbReplyTitleViewHolder.g.getMeasuredHeight();
                    this.h.a.hideBottomLine();
                }
                if (pbReplyTitleViewHolder.b().getParent() == null && top <= this.Z0) {
                    this.U0.setVisibility(0);
                    C3(false);
                } else if (top < measuredHeight) {
                    this.U0.setVisibility(0);
                    C3(false);
                } else {
                    this.U0.setVisibility(4);
                    this.h.a.hideBottomLine();
                }
                if (z2) {
                    this.a1 = true;
                }
            }
        } else if (this.l.getFirstVisiblePosition() == 0) {
            this.U0.setVisibility(4);
            this.h.a.hideBottomLine();
        }
    }

    public void z3() {
        gw7 gw7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048799, this) == null) || (gw7Var = this.r) == null) {
            return;
        }
        gw7Var.u(this.l);
    }
}

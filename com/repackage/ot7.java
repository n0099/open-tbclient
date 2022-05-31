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
import com.repackage.au7;
import com.repackage.dq4;
import com.repackage.fq4;
import com.repackage.ft4;
import com.repackage.kq7;
import com.repackage.lg8;
import com.repackage.lh5;
import com.repackage.ns7;
import com.repackage.oh5;
import com.repackage.oq4;
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
public class ot7 {
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
    public static lg8.f p2;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView A;
    public ImageView A0;
    public oh5 A1;
    public ObservedChangeRelativeLayout B;
    public HeadImageView B0;
    public String B1;
    public yr7 C;
    public View C0;
    public PermissionJudgePolicy C1;
    public dq4 D;
    public tx7 D0;
    public long D1;
    public fq4 E;
    public TextView E0;
    public boolean E1;
    public View F;
    public TextView F0;
    public int F1;
    public EditText G;
    public TextView G0;
    public int G1;
    public ux7 H;
    public boolean H0;
    public boolean H1;
    public PbListView I;
    public int I0;
    public sx7 I1;
    public qx7 J;
    public at4 J0;
    public MaskView J1;
    public View K;
    public boolean K0;
    public final FallingView K1;
    public View L;
    public kp7 L0;
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
    public mq4 Q;
    public ViewStub Q0;
    public View.OnClickListener Q1;
    public View.OnClickListener R;
    public PbInterviewStatusView R0;
    public CustomMessageListener R1;
    public dq4 S;
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
    public PbFragment.e3 V1;
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
    public ft4.g a2;
    public int b;
    public mq4 b0;
    public v0 b1;
    public View.OnClickListener b2;
    public PbFragment c;
    public mq4 c0;
    public PbEmotionBar c1;
    public final List<TbImageView> c2;
    public RelativeLayout d;
    public hq4 d0;
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
    public final jv7 h;
    public String h0;
    public ks7 h1;
    public iv7 i;
    public mq7 i0;
    public jt7 i1;
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
    public os7 p;
    public Button p0;
    public PbTopTipView p1;
    public ns7 q;
    public View q0;
    public PopupWindow q1;
    public gu7 r;
    public View r0;
    public TextView r1;
    public bu7 s;
    public LinearLayout s0;
    public List<String> s1;
    public du7 t;
    public HeadImageView t0;
    public lu7 t1;
    public fu7 u;
    public ImageView u0;
    public kr7 u1;
    public cu7 v;
    public TextView v0;
    public PbLandscapeListView.c v1;
    public eu7 w;
    public WaterRippleView w0;
    public boolean w1;
    public au7 x;
    public ImageView x0;
    public bt7 x1;
    public LinearLayout y;
    public AgreeView y0;
    public NavigationBarCoverTip y1;
    public TextView z;
    public ImageView z0;
    public lh5 z1;

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
        public final /* synthetic */ ot7 g;

        /* renamed from: com.repackage.ot7$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class RunnableC0487a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public RunnableC0487a(a aVar) {
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

        public a(ot7 ot7Var, int i, PbReplyTitleViewHolder pbReplyTitleViewHolder, boolean z, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ot7Var, Integer.valueOf(i), pbReplyTitleViewHolder, Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = ot7Var;
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
                    mg.a().post(new RunnableC0487a(this));
                }
                this.g.l.setOnLayoutListener(null);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ot7 a;

        public a0(ot7 ot7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ot7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ot7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (this.a.U instanceof Dialog)) {
                og.b(this.a.U, this.a.c.getPageContext());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements jq7 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ot7 a;

        public b(ot7 ot7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ot7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ot7Var;
        }

        @Override // com.repackage.jq7
        public /* synthetic */ void onStart() {
            iq7.a(this);
        }

        @Override // com.repackage.jq7
        public void onStop() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.o0.setVisibility(8);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b0 implements oq4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fq4.c a;
        public final /* synthetic */ ot7 b;

        public b0(ot7 ot7Var, fq4.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ot7Var, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ot7Var;
            this.a = cVar;
        }

        @Override // com.repackage.oq4.e
        public void onItemClick(oq4 oq4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, oq4Var, i, view2) == null) {
                this.b.c0.dismiss();
                this.a.a(null, i, view2);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements AgreeView.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ot7 a;

        /* loaded from: classes6.dex */
        public class a implements pz4 {
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

            @Override // com.repackage.pz4
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

        public c(ot7 ot7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ot7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ot7Var;
        }

        @Override // com.baidu.tbadk.core.view.AgreeView.h
        public void onLongPress() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && UbsABTestHelper.isShowLikeAnimation()) {
                this.a.w3();
                rz4.g().c(new a(this));
            }
        }

        @Override // com.baidu.tbadk.core.view.AgreeView.h
        public void onRelease() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.H2();
                this.a.o0.l();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c0 implements oq4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fq4.c a;
        public final /* synthetic */ ot7 b;

        public c0(ot7 ot7Var, fq4.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ot7Var, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ot7Var;
            this.a = cVar;
        }

        @Override // com.repackage.oq4.e
        public void onItemClick(oq4 oq4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, oq4Var, i, view2) == null) {
                this.b.c0.dismiss();
                this.a.a(null, i, view2);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ot7 a;

        public d(ot7 ot7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ot7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ot7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.y0 == null || this.a.y0.getData() == null) {
                return;
            }
            ot7 ot7Var = this.a;
            ot7Var.B2(ot7Var.y0.getData(), this.a.y0.getData().agreeNum);
            if (!UbsABTestHelper.isShowLikeAnimation() || this.a.y0.D()) {
                return;
            }
            ot7 ot7Var2 = this.a;
            ot7Var2.w2(ot7Var2.y0);
        }
    }

    /* loaded from: classes6.dex */
    public class d0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ot7 a;

        public d0(ot7 ot7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ot7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ot7Var;
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
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ot7 a;

        public e(ot7 ot7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ot7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ot7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.C0.getVisibility() == 0) {
                    ys4.k().u("pb_share_red_dot_shown", true);
                    this.a.C0.setVisibility(8);
                }
                this.a.N.onClick(view2);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e0 implements au7.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ot7 a;

        public e0(ot7 ot7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ot7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ot7Var;
        }

        @Override // com.repackage.au7.a
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
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ot7 a;

        public f(ot7 ot7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ot7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ot7Var;
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
                    sparseArray.put(R.id.obfuscated_res_0x7f091e67, 1);
                    this.a.c.m4(sparseArray);
                    return;
                }
                this.a.v2(view2);
            } else if (booleanValue2) {
                sparseArray.put(R.id.obfuscated_res_0x7f091e67, 0);
                sparseArray.put(R.id.obfuscated_res_0x7f091e50, 1);
                this.a.c.m4(sparseArray);
            } else if (booleanValue3) {
                this.a.q2(((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091e58)).intValue(), (String) sparseArray.get(R.id.obfuscated_res_0x7f091e56), ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091e73)).intValue(), ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091e57)).booleanValue());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ot7 a;

        public f0(ot7 ot7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ot7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ot7Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            ot7 ot7Var;
            jv7 jv7Var;
            LinearLayout linearLayout;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.C == null || (jv7Var = (ot7Var = this.a).h) == null || jv7Var.i == null || ot7Var.L0 == null || this.a.L0.O() == null || this.a.L0.O().isVideoThreadType() || this.a.Q1() || this.a.L0.l() == null || ki.isEmpty(this.a.L0.l().getName())) {
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
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ot7 a;

        public g(ot7 ot7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ot7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ot7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.L2();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nv4 a;
        public final /* synthetic */ ot7 b;

        public g0(ot7 ot7Var, nv4 nv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ot7Var, nv4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ot7Var;
            this.a = nv4Var;
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
        public final /* synthetic */ ot7 a;

        public h(ot7 ot7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ot7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ot7Var;
        }

        @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.b
        public void a(PostData postData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, postData) == null) {
                this.a.g1.P(postData);
                this.a.C.Z();
                this.a.h1.c();
                this.a.k0.q();
                this.a.D3(false);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ ot7 b;

        public h0(ot7 ot7Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ot7Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ot7Var;
            this.a = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (li.D()) {
                    UrlManager.getInstance().dealOneLink(this.b.c.getPageContext(), new String[]{this.a});
                    this.b.c.finish();
                    return;
                }
                this.b.c.showToast(R.string.obfuscated_res_0x7f0f0c33);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i implements FallingView.n {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ot7 a;

        public i(ot7 ot7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ot7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ot7Var;
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
    public class i0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Parcelable a;
        public final /* synthetic */ ArrayList b;
        public final /* synthetic */ kp7 c;
        public final /* synthetic */ ot7 d;

        public i0(ot7 ot7Var, Parcelable parcelable, ArrayList arrayList, kp7 kp7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ot7Var, parcelable, arrayList, kp7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = ot7Var;
            this.a = parcelable;
            this.b = arrayList;
            this.c = kp7Var;
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
                this.d.I.C(this.d.c.getString(R.string.obfuscated_res_0x7f0f0dc8));
                this.d.I.x();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ot7 a;

        public j(ot7 ot7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ot7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ot7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.C0.getVisibility() == 0) {
                    ys4.k().u("pb_share_red_dot_shown", true);
                    this.a.C0.setVisibility(8);
                }
                this.a.N.onClick(this.a.A0);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j0 implements PbLandscapeListView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ot7 a;

        public j0(ot7 ot7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ot7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ot7Var;
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
    public class k extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ot7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(ot7 ot7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ot7Var, Integer.valueOf(i)};
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
            this.a = ot7Var;
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
    public class k0 implements dq4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ot7 a;

        public k0(ot7 ot7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ot7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ot7Var;
        }

        @Override // com.repackage.dq4.e
        public void onClick(dq4 dq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dq4Var) == null) {
                this.a.m0();
                dq4Var.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class l implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ot7 a;

        public l(ot7 ot7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ot7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ot7Var;
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
    public class l0 implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ot7 a;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ l0 a;

            public a(l0 l0Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {l0Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = l0Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.a.c.HidenSoftKeyPad((InputMethodManager) this.a.a.c.getBaseFragmentActivity().getSystemService("input_method"), this.a.a.d);
                }
            }
        }

        public l0(ot7 ot7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ot7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ot7Var;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                if (this.a.f1 == null) {
                    this.a.f1 = new a(this);
                }
                mg.a().postDelayed(this.a.f1, 150L);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class m extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ot7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(ot7 ot7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ot7Var, Integer.valueOf(i)};
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
            this.a = ot7Var;
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
    public class m0 implements dq4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public m0(ot7 ot7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ot7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.dq4.e
        public void onClick(dq4 dq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dq4Var) == null) {
                dq4Var.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class n implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ot7 a;

        public n(ot7 ot7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ot7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ot7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.L2();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class n0 implements dq4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public n0(ot7 ot7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ot7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.dq4.e
        public void onClick(dq4 dq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dq4Var) == null) {
                dq4Var.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class o implements tz4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ot7 a;

        public o(ot7 ot7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ot7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ot7Var;
        }

        @Override // com.repackage.tz4
        public void onAction(sz4 sz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, sz4Var) == null) {
                Object obj = sz4Var.c;
                if ((obj instanceof cw4) && EmotionGroupType.isSendAsPic(((cw4) obj).getType())) {
                    if (this.a.C1 == null) {
                        this.a.C1 = new PermissionJudgePolicy();
                    }
                    this.a.C1.clearRequestPermissionList();
                    this.a.C1.appendRequestPermission(this.a.c.getBaseFragmentActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (this.a.C1.startRequestPermission(this.a.c.getBaseFragmentActivity())) {
                        return;
                    }
                    cw4 cw4Var = (cw4) sz4Var.c;
                    this.a.c.V4().h(cw4Var);
                    if (cw4Var.i()) {
                        this.a.c.V4().L(null, null);
                    } else {
                        this.a.c.V4().z(false, null);
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class o0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;
        public final /* synthetic */ View d;
        public final /* synthetic */ ot7 e;

        public o0(ot7 ot7Var, int i, int i2, int i3, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ot7Var, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = ot7Var;
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
    public class p implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ot7 a;

        public p(ot7 ot7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ot7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ot7Var;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || this.a.c.I0 == null || this.a.c.I0.e() == null) {
                return;
            }
            if (!this.a.c.I0.e().e()) {
                this.a.c.I0.a(false);
            }
            this.a.c.I0.e().l(false);
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
                ot7 ot7Var = this.a;
                ot7Var.t1 = new lu7(ot7Var.c.getPageContext(), this.a.d, layoutParams);
                if (!ListUtils.isEmpty(this.a.s1)) {
                    this.a.t1.q(this.a.s1);
                }
                this.a.t1.r(this.a.k0);
            }
            this.a.t1.p(substring);
        }
    }

    /* loaded from: classes6.dex */
    public class p0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nv4 a;
        public final /* synthetic */ ot7 b;

        public p0(ot7 ot7Var, nv4 nv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ot7Var, nv4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ot7Var;
            this.a = nv4Var;
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
    public class q implements oq4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ ot7 b;

        public q(ot7 ot7Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ot7Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ot7Var;
            this.a = z;
        }

        @Override // com.repackage.oq4.e
        public void onItemClick(oq4 oq4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, oq4Var, i, view2) == null) {
                this.b.Q.dismiss();
                SparseArray<Object> sparseArray = (SparseArray) view2.getTag();
                if (sparseArray == null) {
                    return;
                }
                switch (i) {
                    case 10:
                        this.b.q2(((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091e58)).intValue(), (String) sparseArray.get(R.id.obfuscated_res_0x7f091e56), ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091e73)).intValue(), ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091e57)).booleanValue());
                        return;
                    case 11:
                        if (this.b.V1 != null) {
                            this.b.V1.a(new Object[]{sparseArray.get(R.id.obfuscated_res_0x7f091e73), sparseArray.get(R.id.obfuscated_res_0x7f091e61), sparseArray.get(R.id.obfuscated_res_0x7f091e64), sparseArray.get(R.id.obfuscated_res_0x7f091e62), sparseArray.get(R.id.obfuscated_res_0x7f091e63)});
                            return;
                        }
                        return;
                    case 12:
                        this.b.c.h5(this.a, (String) sparseArray.get(R.id.obfuscated_res_0x7f091ea6), sparseArray);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class q0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ot7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q0(ot7 ot7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ot7Var, Integer.valueOf(i)};
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
            this.a = ot7Var;
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
    public class r implements dq4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public r(ot7 ot7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ot7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.dq4.e
        public void onClick(dq4 dq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dq4Var) == null) {
                dq4Var.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class r0 implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;
        public final /* synthetic */ ot7 b;

        public r0(ot7 ot7Var, PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ot7Var, pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ot7Var;
            this.a = pbFragment;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.b.H1 || this.a == null || this.b.c.v() == null || !this.b.c.v().y2()) {
                return;
            }
            this.b.H1 = true;
            this.a.j4(false);
        }
    }

    /* loaded from: classes6.dex */
    public class s implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlertDialog a;
        public final /* synthetic */ SparseArray b;
        public final /* synthetic */ ot7 c;

        public s(ot7 ot7Var, AlertDialog alertDialog, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ot7Var, alertDialog, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ot7Var;
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
                if (!ji.A()) {
                    li.N(this.c.c.w(), R.string.obfuscated_res_0x7f0f0c33);
                } else {
                    this.c.c.u4(this.b, null);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class s0 implements kq7.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ot7 a;

        public s0(ot7 ot7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ot7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ot7Var;
        }

        @Override // com.repackage.kq7.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.c.k5();
            }
        }

        @Override // com.repackage.kq7.b
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
    public class t implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlertDialog a;

        public t(ot7 ot7Var, AlertDialog alertDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ot7Var, alertDialog};
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
    public class t0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x15 a;
        public final /* synthetic */ ot7 b;

        public t0(ot7 ot7Var, x15 x15Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ot7Var, x15Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ot7Var;
            this.a = x15Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.b.c.getActivity(), LoginDialogData.PB_BOTTOM_REPLY_RESULT_PAGE))) {
                this.b.k4();
                this.a.u0();
                this.b.s0();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class u implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlertDialog a;
        public final /* synthetic */ SparseArray b;
        public final /* synthetic */ ot7 c;

        public u(ot7 ot7Var, AlertDialog alertDialog, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ot7Var, alertDialog, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ot7Var;
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
                if (!ji.A()) {
                    li.N(this.c.c.w(), R.string.obfuscated_res_0x7f0f0c33);
                } else {
                    this.c.c.u4(this.b, null);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class u0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ot7 a;

        public u0(ot7 ot7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ot7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ot7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.c.getActivity(), LoginDialogData.PB_BOTTOM_REPLY_RESULT_PAGE))) {
                this.a.k4();
                this.a.c.T5();
                if (this.a.c == null || this.a.c.v() == null || this.a.c.v().P1() == null || this.a.c.v().P1().O() == null || this.a.c.v().P1().O().getAuthor() == null) {
                    return;
                }
                TiebaStatic.log(new StatisticItem("c13701").param("tid", this.a.c.v().i2()).param("fid", this.a.c.v().P1().m()).param("uid", TbadkCoreApplication.getCurrentAccountId()));
                TiebaStatic.log(new StatisticItem("c13402").param("tid", this.a.c.v().b).param("fid", this.a.c.v().P1().m()).param("obj_locate", 1).param("uid", this.a.c.v().P1().O().getAuthor().getUserId()));
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class v implements lg8.f {
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

        @Override // com.repackage.lg8.f
        public void onRefresh() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class v0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public int b;
        public PbReplyTitleViewHolder c;

        public v0() {
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
    public class w implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlertDialog a;

        public w(ot7 ot7Var, AlertDialog alertDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ot7Var, alertDialog};
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
    public class x implements lh5.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dq4 a;
        public final /* synthetic */ ot7 b;

        public x(ot7 ot7Var, dq4 dq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ot7Var, dq4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ot7Var;
            this.a = dq4Var;
        }

        @Override // com.repackage.lh5.g
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                this.b.c.v4(this.a, jSONArray);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class y implements oh5.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SparseArray a;
        public final /* synthetic */ ot7 b;

        public y(ot7 ot7Var, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ot7Var, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ot7Var;
            this.a = sparseArray;
        }

        @Override // com.repackage.oh5.h
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                this.b.c.u4(this.a, jSONArray);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class z implements CompoundButton.OnCheckedChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ot7 a;

        public z(ot7 ot7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ot7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ot7Var;
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

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755428097, "Lcom/repackage/ot7;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755428097, "Lcom/repackage/ot7;");
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
        n2 = li.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds80);
        o2 = 1;
        p2 = new v();
    }

    public ot7(PbFragment pbFragment, View.OnClickListener onClickListener, mq7 mq7Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pbFragment, onClickListener, mq7Var};
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
        this.b1 = new v0();
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
        this.P1 = new q0(this, 2921306);
        this.Q1 = new j(this);
        this.R1 = new k(this, 2005016);
        this.S1 = new Handler();
        this.U1 = new m(this, 2004009);
        this.W1 = true;
        this.X1 = new d0(this);
        this.Y1 = false;
        this.Z1 = null;
        this.c2 = new ArrayList();
        this.e2 = false;
        this.D1 = System.currentTimeMillis();
        this.c = pbFragment;
        this.N = onClickListener;
        this.i0 = mq7Var;
        this.o1 = li.k(pbFragment.getContext()) / 8;
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.c.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d05e5, (ViewGroup) null);
        this.d = relativeLayout;
        relativeLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.m0 = this.d.findViewById(R.id.obfuscated_res_0x7f0903da);
        this.y1 = (NavigationBarCoverTip) this.d.findViewById(R.id.obfuscated_res_0x7f0916db);
        this.e = this.d.findViewById(R.id.obfuscated_res_0x7f091d97);
        this.M1 = (FrameLayout) this.d.findViewById(R.id.obfuscated_res_0x7f091aa1);
        this.B = (ObservedChangeRelativeLayout) this.d.findViewById(R.id.obfuscated_res_0x7f09204a);
        this.m = (NoNetworkView) this.d.findViewById(R.id.obfuscated_res_0x7f0923a4);
        this.l = (PbLandscapeListView) this.d.findViewById(R.id.obfuscated_res_0x7f091528);
        this.S0 = (FrameLayout) this.d.findViewById(R.id.obfuscated_res_0x7f091acf);
        this.T0 = new TextView(this.c.getActivity());
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + li.f(this.c.getActivity(), R.dimen.obfuscated_res_0x7f070309));
        this.l.x(this.T0, 0);
        this.l.setTextViewAdded(true);
        this.e1 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds134);
        this.Y0 = new View(this.c.getPageContext().getPageActivity());
        if (cg5.a()) {
            this.Y0.setLayoutParams(new AbsListView.LayoutParams(-1, 0));
        } else {
            this.Y0.setLayoutParams(new AbsListView.LayoutParams(-1, this.e1));
        }
        this.Y0.setVisibility(4);
        this.l.addFooterView(this.Y0);
        this.l.setOnTouchListener(this.c.H2);
        this.a = new r0(this, pbFragment);
        this.l.getViewTreeObserver().addOnGlobalLayoutListener(this.a);
        this.h = new jv7(pbFragment, this.d);
        if (this.c.N4()) {
            ViewStub viewStub = (ViewStub) this.d.findViewById(R.id.obfuscated_res_0x7f09135f);
            this.j = viewStub;
            viewStub.setVisibility(0);
            iv7 iv7Var = new iv7(pbFragment);
            this.i = iv7Var;
            iv7Var.c();
            this.h.a.setVisibility(8);
            layoutParams.height = li.f(this.c.getActivity(), R.dimen.obfuscated_res_0x7f07023f);
        }
        this.T0.setLayoutParams(layoutParams);
        this.h.p().setOnTouchListener(new kq7(new s0(this)));
        this.q0 = this.d.findViewById(R.id.obfuscated_res_0x7f09238a);
        this.r0 = this.d.findViewById(R.id.obfuscated_res_0x7f09167d);
        li.f(TbadkCoreApplication.getInst(), R.dimen.tbds120);
        this.I0 = li.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f070287);
        this.u0 = (ImageView) this.d.findViewById(R.id.obfuscated_res_0x7f09084c);
        this.u0.setOnClickListener(new t0(this, this.c.V4()));
        Y1();
        t0();
        this.v0 = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f091680);
        LinearLayout linearLayout = (LinearLayout) this.d.findViewById(R.id.obfuscated_res_0x7f091678);
        this.s0 = linearLayout;
        linearLayout.setOnClickListener(new u0(this));
        EjectionAnimationView ejectionAnimationView = (EjectionAnimationView) this.d.findViewById(R.id.obfuscated_res_0x7f090850);
        this.o0 = ejectionAnimationView;
        ejectionAnimationView.setEjectionAnimationViewCallback(new b(this));
        this.x0 = (ImageView) this.d.findViewById(R.id.obfuscated_res_0x7f09167e);
        this.J1 = (MaskView) this.d.findViewById(R.id.obfuscated_res_0x7f091380);
        this.x0.setOnClickListener(this.N);
        AgreeView agreeView = (AgreeView) this.d.findViewById(R.id.obfuscated_res_0x7f09167a);
        this.y0 = agreeView;
        agreeView.setAgreeAlone(true);
        this.y0.r();
        this.y0.setAgreeLongClickListener(new c(this));
        this.y0.setAfterClickListener(new d(this));
        if (UbsABTestHelper.isShowLikeAnimation()) {
            this.y0.setUseDynamicLikeRes("/pb");
        }
        if (this.y0.getAgreeNumView() != null) {
            this.y0.getAgreeNumView().setVisibility(8);
        }
        if (this.y0.getMsgData() != null) {
            this.y0.getMsgData().a = BdUniqueId.gen();
        }
        boolean booleanExtra = this.c.getBaseFragmentActivity().getIntent().getBooleanExtra("key_is_from_dynamic", false);
        ImageView imageView = (ImageView) this.d.findViewById(R.id.obfuscated_res_0x7f09167c);
        this.z0 = imageView;
        imageView.setOnClickListener(this.N);
        if (booleanExtra) {
            this.z0.setVisibility(8);
        } else {
            this.z0.setVisibility(0);
        }
        View findViewById = this.d.findViewById(R.id.obfuscated_res_0x7f091683);
        this.C0 = findViewById;
        findViewById.setVisibility((ys4.k().h("pb_share_red_dot_shown", false) || !TbadkCoreApplication.isLogin()) ? 8 : 0);
        this.A0 = (ImageView) this.d.findViewById(R.id.obfuscated_res_0x7f091681);
        HeadImageView headImageView = (HeadImageView) this.d.findViewById(R.id.obfuscated_res_0x7f091682);
        this.B0 = headImageView;
        headImageView.setIsRound(true);
        this.B0.setOnClickListener(this.Q1);
        this.A0.setOnClickListener(new e(this));
        a2();
        tx7 tx7Var = new tx7(this.A0);
        this.D0 = tx7Var;
        tx7Var.n(this.B0);
        if (!UbsABTestHelper.isResizeInduceSharingABTest() && !UbsABTestHelper.isResizeInduceSharingABTestA()) {
            this.D0.f();
        }
        TextView textView = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f09167f);
        this.F0 = textView;
        textView.setVisibility(0);
        this.E0 = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f09167b);
        this.Q0 = (ViewStub) this.d.findViewById(R.id.obfuscated_res_0x7f090f13);
        if (UbsABTestHelper.isLikeModifyTestA()) {
            this.y0.setVisibility(0);
            this.E0.setVisibility(0);
        }
        this.s = new bu7(this.c, mq7Var);
        this.u = new fu7(this.c, mq7Var, this.N);
        yr7 yr7Var = new yr7(this.c, this.l);
        this.C = yr7Var;
        yr7Var.v0(this.N);
        this.C.x0(this.i0);
        this.C.s0(this.O);
        this.C.u0(this.c.f2);
        this.C.p0(this.b2);
        f fVar = new f(this);
        this.R = fVar;
        this.C.r0(fVar);
        E1();
        y1();
        eu7 eu7Var = new eu7(this.c);
        this.w = eu7Var;
        eu7Var.f = 2;
        x1();
        this.x.a(this.l);
        this.t.a(this.l);
        this.u.j(this.l);
        this.s.a(this.l);
        PbListView pbListView = new PbListView(this.c.getPageContext().getPageActivity());
        this.I = pbListView;
        this.K = pbListView.b().findViewById(R.id.obfuscated_res_0x7f0916cb);
        this.L = this.I.b().findViewById(R.id.obfuscated_res_0x7f091669);
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
        this.M = this.d.findViewById(R.id.obfuscated_res_0x7f0923c0);
        this.c.registerListener(this.U1);
        this.g1 = new PbFakeFloorModel(this.c.getPageContext());
        PbModel v2 = this.c.v();
        this.g1.R(v2.H(), v2.D(), v2.E(), v2.C(), v2.I());
        ks7 ks7Var = new ks7(this.c.getPageContext(), this.g1, this.d);
        this.h1 = ks7Var;
        ks7Var.k(new g(this));
        this.h1.n(this.c.j2);
        this.g1.T(new h(this));
        if (this.c.v() != null && !StringUtils.isNull(this.c.v().S1())) {
            PbFragment pbFragment2 = this.c;
            pbFragment2.showToast(pbFragment2.v().S1());
        }
        this.U0 = this.d.findViewById(R.id.obfuscated_res_0x7f091685);
        this.V0 = this.d.findViewById(R.id.obfuscated_res_0x7f0903d5);
        View findViewById2 = this.d.findViewById(R.id.obfuscated_res_0x7f091da2);
        this.W0 = findViewById2;
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) findViewById2.getLayoutParams();
        if (this.c.v() != null && this.c.v().B1()) {
            this.U0.setVisibility(0);
            if (layoutParams2 != null) {
                layoutParams2.height = 0;
                this.W0.setLayoutParams(layoutParams2);
            }
        } else if (layoutParams2 != null) {
            layoutParams2.height = g2;
            this.W0.setLayoutParams(layoutParams2);
        }
        PbReplyTitleViewHolder pbReplyTitleViewHolder = new PbReplyTitleViewHolder(this.c.getPageContext(), this.d.findViewById(R.id.obfuscated_res_0x7f0916f9));
        this.X0 = pbReplyTitleViewHolder;
        pbReplyTitleViewHolder.s(pbFragment.k0);
        this.X0.g.setVisibility(8);
        this.X0.r(this.N);
        this.X0.q(this.c.f2);
        this.c.registerListener(this.R1);
        this.c.registerListener(this.P1);
        PbFragment pbFragment3 = this.c;
        this.I1 = new sx7(pbFragment3, pbFragment3.getUniqueId());
        this.K1 = (FallingView) this.d.findViewById(R.id.obfuscated_res_0x7f090958);
        R2();
        this.K1.setAnimationListener(new i(this));
        h0();
        K2(false);
        this.n0 = this.d.findViewById(R.id.obfuscated_res_0x7f09166f);
        g0(cg5.a());
        if (UbsABTestHelper.isPbForumGuideTestA() && v2.C2() && po7.b().e()) {
            if (this.p == null) {
                this.p = new os7(this.c.getActivity(), (ViewGroup) m1().findViewById(R.id.obfuscated_res_0x7f0916a4));
            }
            ns7 ns7Var = new ns7(this.l);
            this.q = ns7Var;
            ns7Var.d(new ns7.a() { // from class: com.repackage.qr7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.repackage.ns7.a
                public final void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        ot7.this.V1();
                    }
                }
            });
        }
    }

    public yr7 A0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.C : (yr7) invokeV.objValue;
    }

    public final void A1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.c.N4()) {
            ViewStub viewStub = (ViewStub) this.d.findViewById(R.id.obfuscated_res_0x7f09135a);
            this.k = viewStub;
            viewStub.setVisibility(0);
            if (this.y == null) {
                this.y = (LinearLayout) this.d.findViewById(R.id.obfuscated_res_0x7f091359);
                q85.a(this.c.getPageContext(), this.y);
            }
            if (this.z == null) {
                this.z = (TextView) this.y.findViewById(R.id.obfuscated_res_0x7f09135e);
            }
            if (this.A == null) {
                this.A = (TextView) this.y.findViewById(R.id.obfuscated_res_0x7f09135d);
            }
            this.z.setOnClickListener(this.N);
            this.A.setOnClickListener(this.N);
        }
    }

    public void A2() {
        PbLandscapeListView pbLandscapeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (pbLandscapeListView = this.l) == null) {
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
        if ((z2 && pbReplyTitleViewHolder != null) || firstVisiblePosition >= this.C.H() + this.l.getHeaderViewsCount()) {
            int measuredHeight2 = pbReplyTitleViewHolder != null ? pbReplyTitleViewHolder.g.getMeasuredHeight() : 0;
            if (z3) {
                this.l.setSelectionFromTop(this.C.H() + this.l.getHeaderViewsCount(), g2 - measuredHeight2);
            } else {
                this.l.setSelectionFromTop(this.C.H() + this.l.getHeaderViewsCount(), this.h.p().getMeasuredHeight() - measuredHeight2);
            }
        } else {
            this.l.setSelectionFromTop(firstVisiblePosition, top);
        }
        if (this.l1 && this.r != null) {
            this.l.setSelectionFromTop(this.C.H() + this.l.getHeaderViewsCount(), this.r.d());
        } else if (this.N0 != 6) {
        } else {
            this.l.setOnLayoutListener(new a(this, f1, pbReplyTitleViewHolder, z2, measuredHeight, firstVisiblePosition, top));
        }
    }

    public final void A3(SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, sparseArray) == null) || this.c == null) {
            return;
        }
        if (sparseArray != null) {
            sparseArray.put(R.id.obfuscated_res_0x7f091e6a, Boolean.TRUE);
        }
        TBAlertConfig.a aVar = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f1187, TBAlertConfig.OperateBtnStyle.MAIN);
        TBAlertConfig.a aVar2 = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f0376, TBAlertConfig.OperateBtnStyle.SECONDARY);
        rq4 rq4Var = new rq4(this.c.w());
        rq4Var.u(R.string.obfuscated_res_0x7f0f0b27);
        rq4Var.l(R.string.obfuscated_res_0x7f0f0b28);
        rq4Var.n(true);
        rq4Var.r(aVar2, aVar);
        rq4Var.i(false);
        AlertDialog x2 = rq4Var.x();
        aVar.a(new u(this, x2, sparseArray));
        aVar2.a(new w(this, x2));
    }

    public LinearLayout B0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.s0 : (LinearLayout) invokeV.objValue;
    }

    public void B1() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.c == null || (editorTools = this.k0) == null) {
            return;
        }
        editorTools.j();
        if (this.c.V4() != null) {
            this.c.V4().P();
        }
        o1();
    }

    public final void B2(AgreeData agreeData, long j3) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLJ(1048582, this, agreeData, j3) == null) || agreeData == null) {
            return;
        }
        if ((UbsABTestHelper.isLikeModifyTestA() || UbsABTestHelper.isShowLikeAnimation()) && (textView = this.E0) != null) {
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
    }

    public final void B3(int i3, SparseArray<Object> sparseArray) {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048583, this, i3, sparseArray) == null) || (pbFragment = this.c) == null || pbFragment.v() == null || this.c.v().P1() == null || this.c.v().P1().o() == null || this.c.v().P1().l() == null || this.c.v().P1().l().getDeletedReasonInfo() == null) {
            return;
        }
        if (sparseArray != null) {
            sparseArray.put(R.id.obfuscated_res_0x7f091e6a, Boolean.TRUE);
        }
        nh5 nh5Var = new nh5(this.c.v().P1().l().getDeletedReasonInfo().is_grays_cale_forum.intValue(), this.c.v().P1().l().getDeletedReasonInfo().is_boomgrow.intValue(), this.c.v().P1().o().has_forum_rule.intValue());
        nh5Var.i(this.c.v().P1().l().getId(), this.c.v().P1().l().getName());
        nh5Var.h(this.c.v().P1().l().getImage_url());
        nh5Var.j(this.c.v().P1().l().getUser_level());
        M3(sparseArray, i3, nh5Var, this.c.v().P1().U(), true);
    }

    public View C0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            View view2 = this.V;
            if (view2 != null) {
                return view2.findViewById(R.id.obfuscated_res_0x7f090784);
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    public final void C1(kp7 kp7Var, nv4 nv4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048585, this, kp7Var, nv4Var) == null) || this.M1 == null || kp7Var == null || nv4Var == null || this.c.getContext() == null) {
            return;
        }
        if (!RightFloatLayerView.k()) {
            v1();
            return;
        }
        if (this.L1 == null) {
            this.L1 = RightFloatLayerLottieView.F(nv4Var, this.c.getContext());
            this.M1.removeAllViews();
            this.M1.addView(this.L1);
        }
        if ((this.K1.getTag() instanceof Boolean) && !((Boolean) this.K1.getTag()).booleanValue()) {
            this.L1.setAutoCompleteShown(false);
            this.L1.setTag(this.K1);
            this.L1.c();
        }
        if (nv4Var.a()) {
            return;
        }
        this.L1.setData(nv4Var);
        this.L1.setLogoListener(new g0(this, nv4Var));
        this.L1.setFeedBackListener(new p0(this, nv4Var));
    }

    public final void C2(kp7 kp7Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, kp7Var) == null) || kp7Var == null || kp7Var.O() == null) {
            return;
        }
        l4(kp7Var);
        if (kp7Var.r()) {
            WebPManager.setPureDrawable(this.z0, R.drawable.obfuscated_res_0x7f08094c, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
        } else {
            WebPManager.setPureDrawable(this.z0, R.drawable.obfuscated_res_0x7f08094b, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        }
        String z0 = z0(kp7Var.O().getReply_num());
        TextView textView = this.F0;
        if (textView != null) {
            textView.setText(z0);
        }
        TextView textView2 = this.G0;
        if (textView2 != null) {
            textView2.setText(z0);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921416, kp7Var.O()));
        B2(kp7Var.O().getAgreeData(), kp7Var.O().getAgreeNum());
        if (this.y0 == null || kp7Var.O() == null) {
            return;
        }
        this.y0.setThreadData(kp7Var.O());
        int i3 = 1;
        if (kp7Var.O().getAgreeData() != null) {
            kp7Var.O().getAgreeData().isInThread = true;
        }
        this.y0.setData(kp7Var.O().getAgreeData());
        um4 um4Var = new um4();
        um4Var.b = 26;
        if (kp7Var.O().isVideoThreadType() && kp7Var.O().getThreadVideoInfo() != null) {
            i3 = 2;
        }
        um4Var.c = i3;
        PbFragment pbFragment = this.c;
        if (pbFragment != null && pbFragment.v() != null) {
            um4Var.j = this.c.v().getFromForumId();
            um4Var.f = this.c.v().O1();
        }
        this.y0.setStatisticData(um4Var);
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

    public void D1(kp7 kp7Var) {
        nv4 pbAdFloatViewItemData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, kp7Var) == null) || kp7Var == null) {
            return;
        }
        if (kp7Var.k0()) {
            pbAdFloatViewItemData = kp7Var.Z();
        } else {
            pbAdFloatViewItemData = TbSingleton.getInstance().getPbAdFloatViewItemData();
        }
        if (pbAdFloatViewItemData != null && !pbAdFloatViewItemData.a()) {
            C1(kp7Var, pbAdFloatViewItemData);
        } else {
            v1();
        }
    }

    public void D2(int i3, kp7 kp7Var, boolean z2, int i4) {
        PostData I0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Integer.valueOf(i3), kp7Var, Boolean.valueOf(z2), Integer.valueOf(i4)}) == null) || i3 <= 0 || (I0 = I0(kp7Var, z2)) == null || I0.s() == null) {
            return;
        }
        MetaData s2 = I0.s();
        s2.setGiftNum(s2.getGiftNum() + i3);
    }

    public void D3(boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048591, this, z2) == null) || this.r0 == null) {
            return;
        }
        T2(this.c.V4().C());
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
            this.v = new cu7(this.c, this.N);
        }
    }

    public void E2(kp7 kp7Var, boolean z2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{kp7Var, Boolean.valueOf(z2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            P3(kp7Var, z2, i3, i4);
            this.u.u(i4);
        }
    }

    public void E3(kp7 kp7Var) {
        PostData postData;
        jv7 jv7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, kp7Var) == null) || kp7Var == null || (postData = this.M0) == null || postData.s() == null || (jv7Var = this.h) == null) {
            return;
        }
        boolean z2 = !this.l1;
        this.m1 = z2;
        jv7Var.G(z2);
        if (this.c.W4() != null) {
            this.c.W4().s(this.m1);
        }
        z2();
        PbFragment pbFragment = this.c;
        if (pbFragment != null && !pbFragment.isSimpleForum() && !ListUtils.isEmpty(kp7Var.p())) {
            np4 np4Var = kp7Var.p().get(0);
            if (np4Var != null) {
                this.h.K(kp7Var, np4Var.a(), np4Var.b(), np4Var.d(), np4Var.getIsLike());
            }
        } else if (kp7Var.l() != null) {
            this.h.K(kp7Var, kp7Var.l().getName(), kp7Var.l().getId(), kp7Var.l().getImage_url(), kp7Var.l().isLike() == 1);
        }
        if (this.m1) {
            this.u.G(kp7Var, this.M0, this.f0);
            View view2 = this.W0;
            if (view2 != null) {
                view2.setVisibility(8);
            }
            if (this.v1 == null) {
                this.v1 = new j0(this);
            }
            this.l.setListViewDragListener(this.v1);
            return;
        }
        View view3 = this.W0;
        if (view3 != null) {
            view3.setVisibility(0);
        }
        this.u.G(kp7Var, this.M0, this.f0);
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
            if (this.C.y(E0) != null && this.C.y(E0) != PostData.w0) {
                i3 = E0 + 1;
            }
            if (this.C.x(i3) instanceof PostData) {
                return (PostData) this.C.x(i3);
            }
            return null;
        }
        return (PostData) invokeV.objValue;
    }

    public void F1(kp7 kp7Var) {
        PbReplyTitleViewHolder pbReplyTitleViewHolder;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, kp7Var) == null) {
            int i3 = 0;
            this.C.g0(kp7Var, false);
            this.C.Z();
            p0();
            kr7 kr7Var = this.u1;
            if (kr7Var != null) {
                kr7Var.n();
            }
            ArrayList<PostData> F = kp7Var.F();
            if (kp7Var.y().b() == 0 || F == null || F.size() < kp7Var.y().e()) {
                if (ListUtils.getCount(F) != 0 && (ListUtils.getCount(F) != 1 || F.get(0) == null || F.get(0).A() != 1)) {
                    if (kp7Var.y().b() == 0) {
                        this.I.C(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f09f3));
                    } else {
                        this.I.C(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0a38));
                    }
                    this.I.k();
                } else {
                    v0 v0Var = this.b1;
                    if (v0Var != null && (pbReplyTitleViewHolder = v0Var.c) != null && pbReplyTitleViewHolder.b() != null) {
                        i3 = this.b1.c.b().getTop() < 0 ? this.b1.c.b().getHeight() : this.b1.c.b().getBottom();
                    }
                    if (this.c.u5()) {
                        this.I.F(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0dcf), i3);
                    } else {
                        this.I.F(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0dd0), i3);
                    }
                }
            }
            C2(kp7Var);
        }
    }

    public final void F2() {
        PbInterviewStatusView pbInterviewStatusView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048598, this) == null) && (pbInterviewStatusView = this.R0) != null && pbInterviewStatusView.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.R0.getLayoutParams();
            layoutParams.setMargins(0, 0, 0, 0);
            this.R0.setLayoutParams(layoutParams);
        }
    }

    public final void F3(SparseArray<Object> sparseArray, @StringRes int i3, @StringRes int i4) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(1048599, this, sparseArray, i3, i4) == null) || this.c == null) {
            return;
        }
        TBAlertConfig.a aVar = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f04a4, TBAlertConfig.OperateBtnStyle.MAIN);
        TBAlertConfig.a aVar2 = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f0376, TBAlertConfig.OperateBtnStyle.SECONDARY);
        rq4 rq4Var = new rq4(this.c.w());
        rq4Var.u(i3);
        rq4Var.l(i4);
        rq4Var.n(true);
        rq4Var.r(aVar2, aVar);
        rq4Var.i(false);
        AlertDialog x2 = rq4Var.x();
        aVar.a(new s(this, x2, sparseArray));
        aVar2.a(new t(this, x2));
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

    public void G2() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048602, this) == null) || this.f == 2) {
            return;
        }
        this.l.setNextPage(this.I);
        this.f = 2;
    }

    public final boolean G3(kp7 kp7Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, kp7Var)) == null) {
            if (kp7Var == null || kp7Var.O() == null) {
                return false;
            }
            return kp7Var.O().getIsLive() == 1 || kp7Var.O().getThreadType() == 33 || !(kp7Var.O().getTopicData() == null || kp7Var.O().getTopicData().a() == 0) || kp7Var.O().getIs_top() == 1 || kp7Var.O().getIs_good() == 1 || kp7Var.O().isActInfo() || kp7Var.O().isInterviewLive() || kp7Var.O().isVoteThreadType() || kp7Var.O().getYulePostActivityData() != null || !ki.isEmpty(kp7Var.O().getCategory()) || kp7Var.O().isGodThread() || kp7Var.O().isRealGod();
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

    public final void H2() {
        PbFragment pbFragment;
        WaterRippleView waterRippleView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048606, this) == null) || (pbFragment = this.c) == null || pbFragment.getActivity() == null || (waterRippleView = this.w0) == null) {
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

    public void H3(boolean z2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048607, this, z2) == null) || this.r0 == null || (textView = this.v0) == null) {
            return;
        }
        textView.setText(R.string.obfuscated_res_0x7f0f0514);
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
        K2(true);
    }

    public PostData I0(kp7 kp7Var, boolean z2) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048608, this, kp7Var, z2)) == null) {
            PostData postData = null;
            if (kp7Var == null) {
                return null;
            }
            if (kp7Var.W() != null) {
                return kp7Var.W();
            }
            if (!ListUtils.isEmpty(kp7Var.F())) {
                Iterator<PostData> it = kp7Var.F().iterator();
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
                postData = kp7Var.j();
            }
            if (!L1(postData)) {
                postData = d1(kp7Var);
            }
            if (postData != null && postData.s() != null && postData.s().getUserTbVipInfoData() != null && postData.s().getUserTbVipInfoData().getvipIntro() != null) {
                postData.s().getGodUserData().setIntro(postData.s().getUserTbVipInfoData().getvipIntro());
            }
            return postData;
        }
        return (PostData) invokeLZ.objValue;
    }

    public final boolean I1(kp7 kp7Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, kp7Var)) == null) {
            if (kp7Var == null || kp7Var.O() == null) {
                return false;
            }
            SpannableStringBuilder span_str = kp7Var.O().getSpan_str();
            if (span_str != null) {
                return TbadkApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0db6).equals(span_str.toString());
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void I2() {
        PbLandscapeListView pbLandscapeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048610, this) == null) || (pbLandscapeListView = this.l) == null) {
            return;
        }
        this.x.d(pbLandscapeListView);
        this.t.d(this.l);
        this.u.x(this.l);
        this.v.d(this.l);
        this.s.f(this.l);
    }

    public void I3(View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048611, this, view2) == null) || ys4.k().h("show_long_press_collection_tips", false)) {
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
        textView.setText(R.string.obfuscated_res_0x7f0f043a);
        this.r1.setGravity(17);
        this.r1.setPadding(li.f(this.c.getContext(), R.dimen.obfuscated_res_0x7f0701e8), 0, li.f(this.c.getContext(), R.dimen.obfuscated_res_0x7f0701e8), 0);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        layoutParams.height = li.f(this.c.getContext(), R.dimen.obfuscated_res_0x7f070253);
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
        this.l.postDelayed(new o0(this, i5, i3, i4, view2), 100L);
        ys4.k().u("show_long_press_collection_tips", true);
    }

    public final int J0(int i3) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048612, this, i3)) == null) {
            an adapter2 = this.l.getAdapter2();
            if (adapter2 == null) {
                return i3;
            }
            if (i3 < adapter2.getCount() && i3 >= 0 && (adapter2.getItem(i3) instanceof hp7)) {
                i3++;
            }
            int o3 = (adapter2.o() + adapter2.m()) - 1;
            if (i3 > o3) {
                i3 = o3;
            }
            int n3 = (this.l.getAdapter2() == null || !(this.l.getAdapter2() instanceof an)) ? 0 : this.l.getAdapter2().n();
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

    public final void J2() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048614, this) == null) || (pbFragment = this.c) == null || pbFragment.V4() == null || this.k0 == null) {
            return;
        }
        t15.a().c(0);
        x15 V4 = this.c.V4();
        V4.T();
        V4.R();
        if (V4.y() != null) {
            V4.y().setMaxImagesAllowed(V4.v ? 1 : 9);
        }
        V4.l0(SendView.g);
        V4.j(SendView.g);
        zz4 m3 = this.k0.m(23);
        zz4 m4 = this.k0.m(2);
        zz4 m5 = this.k0.m(5);
        if (m4 != null) {
            m4.e();
        }
        if (m5 != null) {
            m5.e();
        }
        if (m3 != null) {
            m3.hide();
        }
        this.k0.invalidate();
    }

    public void J3() {
        jv7 jv7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048615, this) == null) || (jv7Var = this.h) == null || this.n1) {
            return;
        }
        jv7Var.C();
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

    public final void K2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048618, this, z2) == null) {
        }
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

    public void L2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            J2();
            q1();
            this.h1.c();
            D3(false);
        }
    }

    public void L3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            if (this.J0 == null) {
                this.J0 = new at4(this.c.getPageContext());
            }
            this.J0.h(true);
        }
    }

    public TextView M0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) ? this.u.n() : (TextView) invokeV.objValue;
    }

    public boolean M1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void M2() {
        gu7 gu7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048626, this) == null) || (gu7Var = this.r) == null) {
            return;
        }
        gu7Var.q(this.l, this.T0, this.N0);
    }

    public final void M3(SparseArray<Object> sparseArray, int i3, nh5 nh5Var, UserData userData, boolean z2) {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048627, this, new Object[]{sparseArray, Integer.valueOf(i3), nh5Var, userData, Boolean.valueOf(z2)}) == null) || (pbFragment = this.c) == null) {
            return;
        }
        if (this.A1 == null && this.s != null) {
            this.A1 = new oh5(pbFragment.getPageContext(), this.s.c(), nh5Var, userData);
        }
        this.A1.C(z2);
        AntiData D4 = this.c.D4();
        SparseArray<String> sparseArray2 = new SparseArray<>();
        if (D4 != null && D4.getDelThreadInfoList() != null) {
            List<DeleteThreadInfo> delThreadInfoList = D4.getDelThreadInfoList();
            for (int i4 = 0; i4 < delThreadInfoList.size(); i4++) {
                if (!TextUtils.isEmpty(delThreadInfoList.get(i4).text_info)) {
                    sparseArray2.put(delThreadInfoList.get(i4).text_id, delThreadInfoList.get(i4).text_info);
                }
            }
        }
        lo4 lo4Var = new lo4();
        lo4Var.j(sparseArray2);
        this.A1.E(new String[]{this.c.getString(R.string.obfuscated_res_0x7f0f04b8), this.c.getString(R.string.obfuscated_res_0x7f0f04b9), this.c.getString(R.string.obfuscated_res_0x7f0f04ba), this.c.getString(R.string.obfuscated_res_0x7f0f04bb), this.c.getString(R.string.obfuscated_res_0x7f0f04bc)});
        this.A1.D(lo4Var);
        this.A1.G((i3 == 1 || i3 == 2) ? "4" : "3");
        this.A1.F(new y(this, sparseArray));
    }

    public int N0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) {
            tx7 tx7Var = this.D0;
            if (tx7Var != null) {
                return tx7Var.g();
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

    public void N2() {
        Handler handler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048630, this) == null) || (handler = this.S1) == null) {
            return;
        }
        Runnable runnable = this.T1;
        if (runnable != null) {
            handler.removeCallbacks(runnable);
        }
        l lVar = new l(this);
        this.T1 = lVar;
        this.S1.postDelayed(lVar, 2000L);
    }

    public void N3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048631, this) == null) {
            this.C.g0(this.L0, false);
            this.C.Z();
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

    public void O2(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048634, this, editorTools) == null) {
            this.k0 = editorTools;
            editorTools.setOnCancelClickListener(new n(this));
            this.k0.setId(R.id.obfuscated_res_0x7f091679);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            if (this.k0.getParent() == null) {
                this.d.addView(this.k0, layoutParams);
            }
            this.k0.w(TbadkCoreApplication.getInst().getSkinType());
            this.k0.setActionListener(24, new o(this));
            q1();
            this.c.V4().i(new p(this));
        }
    }

    public void O3(kp7 kp7Var, int i3, int i4, boolean z2, int i5, boolean z3) {
        PbLandscapeListView pbLandscapeListView;
        int i6;
        PbReplyTitleViewHolder pbReplyTitleViewHolder;
        kp7 kp7Var2;
        Parcelable e2;
        Parcelable e3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048635, this, new Object[]{kp7Var, Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z2), Integer.valueOf(i5), Boolean.valueOf(z3)}) == null) || kp7Var == null || this.l == null) {
            return;
        }
        this.L0 = kp7Var;
        this.N0 = i3;
        if (kp7Var.O() != null) {
            this.d1 = kp7Var.O().getCopyThreadRemindType();
            if (kp7Var.O().getAnchorLevel() != 0) {
                this.Y1 = true;
            }
            this.f0 = O1(kp7Var.O());
        }
        if (kp7Var.U() != null) {
            this.Z1 = kp7Var.U().getUserId();
        }
        z1(kp7Var);
        e0();
        this.P0 = false;
        this.K0 = z2;
        o3();
        tp7 tp7Var = kp7Var.h;
        if (tp7Var != null && tp7Var.b()) {
            if (this.o == null) {
                PbThreadPostView pbThreadPostView = new PbThreadPostView(this.c.getContext());
                this.o = pbThreadPostView;
                this.l.x(pbThreadPostView, 1);
                this.o.setData(kp7Var);
                this.o.setChildOnClickLinstener(this.N);
            }
        } else {
            PbThreadPostView pbThreadPostView2 = this.o;
            if (pbThreadPostView2 != null && (pbLandscapeListView = this.l) != null) {
                pbLandscapeListView.removeHeaderView(pbThreadPostView2);
            }
        }
        P3(kp7Var, z2, i3, TbadkCoreApplication.getInst().getSkinType());
        E3(kp7Var);
        this.u.H(kp7Var, this.M0);
        if (this.x1 == null) {
            this.x1 = new bt7(this.c.getPageContext(), this.y1);
        }
        this.x1.a(kp7Var.w());
        if (this.c.N4()) {
            if (this.H == null) {
                ux7 ux7Var = new ux7(this.c.getPageContext());
                this.H = ux7Var;
                ux7Var.n();
                this.H.e(this.a2);
            }
            this.l.setPullRefresh(this.H);
            M2();
            ux7 ux7Var2 = this.H;
            if (ux7Var2 != null) {
                ux7Var2.H(TbadkCoreApplication.getInst().getSkinType());
            }
        } else if (kp7Var.y().c() == 0 && z2) {
            this.l.setPullRefresh(null);
        } else {
            if (this.H == null) {
                ux7 ux7Var3 = new ux7(this.c.getPageContext());
                this.H = ux7Var3;
                ux7Var3.n();
                this.H.e(this.a2);
            }
            this.l.setPullRefresh(this.H);
            M2();
            ux7 ux7Var4 = this.H;
            if (ux7Var4 != null) {
                ux7Var4.H(TbadkCoreApplication.getInst().getSkinType());
            }
            s1();
        }
        p0();
        this.C.n0(this.K0);
        this.C.k0(false);
        this.C.l0(i3 == 5);
        this.C.m0(i3 == 6);
        this.C.i0(z3 && this.W1 && i3 != 2);
        this.C.g0(kp7Var, false);
        this.C.Z();
        this.u.F(I0(kp7Var, z2), kp7Var.g0());
        if (kp7Var.O() != null && kp7Var.O().getPraise() != null && this.b != -1) {
            kp7Var.O().getPraise().setIsLike(this.b);
        }
        this.l.removeFooterView(this.Y0);
        this.l.addFooterView(this.Y0);
        if (TbadkCoreApplication.isLogin()) {
            this.l.setNextPage(this.I);
            this.f = 2;
            s1();
        } else {
            this.P0 = true;
            if (kp7Var.y().b() == 1) {
                if (this.J == null) {
                    PbFragment pbFragment = this.c;
                    this.J = new qx7(pbFragment, pbFragment);
                }
                this.l.setNextPage(this.J);
            } else {
                this.l.setNextPage(this.I);
            }
            this.f = 3;
        }
        ArrayList<PostData> F = kp7Var.F();
        if (kp7Var.y().b() != 0 && F != null && F.size() >= kp7Var.y().e()) {
            if (z3) {
                if (this.W1) {
                    u0();
                    if (kp7Var.y().b() != 0) {
                        this.I.C(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0dc7));
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
                if (kp7Var.y().b() == 0) {
                    this.I.C(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f09f3));
                } else {
                    this.I.C(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0a38));
                }
                this.I.k();
            } else {
                v0 v0Var = this.b1;
                if (v0Var == null || (pbReplyTitleViewHolder = v0Var.c) == null || pbReplyTitleViewHolder.b() == null) {
                    i6 = 0;
                } else {
                    i6 = this.b1.c.b().getTop() < 0 ? this.b1.c.b().getHeight() : this.b1.c.b().getBottom();
                }
                if (this.c.u5()) {
                    this.I.u(false);
                    if (ListUtils.isEmpty(kp7Var.R())) {
                        this.I.F(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0dcf), i6);
                    }
                } else if (ListUtils.isEmpty(kp7Var.R())) {
                    this.I.F(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0dd0), i6);
                }
                if (this.c.W4() != null && !this.c.W4().p()) {
                    this.c.W4().x();
                }
            }
            if (kp7Var.y().b() == 0 || F == null) {
                G2();
            }
        }
        if (i3 == 2) {
            this.l.setSelection(i4 > 1 ? (i4 + ((this.l.getData() == null && kp7Var.F() == null) ? 0 : (this.l.getData().size() - kp7Var.F().size()) + this.l.getHeaderViewsCount())) - 2 : 0);
        } else if (i3 != 3) {
            if (i3 == 4) {
                this.W1 = false;
            } else if (i3 == 5) {
                this.l.setSelection(0);
            } else if (i3 != 6) {
                if (i3 == 8) {
                    if (i4 == 0) {
                        gu7 gu7Var = this.r;
                        if (gu7Var != null && gu7Var.c() != null) {
                            if (this.c.getBaseFragmentActivity().isUseStyleImmersiveSticky()) {
                                this.l.setSelectionFromTop((this.C.B() + this.l.getHeaderViewsCount()) - 1, this.r.d() - li.s(this.c.getPageContext().getPageActivity()));
                            } else {
                                this.l.setSelectionFromTop((this.C.B() + this.l.getHeaderViewsCount()) - 1, this.r.d());
                            }
                        } else {
                            this.l.setSelection(this.C.B() + this.l.getHeaderViewsCount());
                        }
                    } else if (ListUtils.isEmpty(kp7Var.R())) {
                        this.l.setSelection(i4 > 0 ? i4 + ((this.l.getData() == null && kp7Var.F() == null) ? 0 : (this.l.getData().size() - kp7Var.F().size()) + this.l.getHeaderViewsCount()) : 0);
                    } else {
                        this.l.setSelection(kp7Var.F().size() + this.l.getHeaderViewsCount());
                    }
                    this.I.f();
                    this.I.C(this.c.getString(R.string.obfuscated_res_0x7f0f0dc8));
                    this.I.x();
                }
            } else if (i5 == 1 && (e3 = gt7.b().e()) != null && !(e3 instanceof RecyclerView.SavedState)) {
                this.l.onRestoreInstanceState(e3);
            } else {
                this.l.setSelection(0);
            }
        } else if (i5 == 1 && (e2 = gt7.b().e()) != null && !(e2 instanceof RecyclerView.SavedState)) {
            this.l.post(new i0(this, e2, F, kp7Var));
        }
        if (this.d1 == h2 && N1()) {
            j0();
        }
        if (this.j1) {
            A2();
            this.j1 = false;
            if (i5 == 0) {
                d3(true);
            }
        }
        if (kp7Var.d == 1 || kp7Var.e == 1) {
            if (this.p1 == null) {
                this.p1 = new PbTopTipView(this.c.getContext());
            }
            if (kp7Var.e == 1 && "game_guide".equals(this.c.b5())) {
                this.p1.setText(this.c.getString(R.string.obfuscated_res_0x7f0f0ddb));
                this.p1.l(this.d, this.O0);
            } else if (kp7Var.d == 1 && "game_news".equals(this.c.b5())) {
                this.p1.setText(this.c.getString(R.string.obfuscated_res_0x7f0f0dda));
                this.p1.l(this.d, this.O0);
            }
        }
        this.l.removeFooterView(this.I1.a());
        if (!ListUtils.isEmpty(kp7Var.I()) && kp7Var.y().b() == 0) {
            this.l.removeFooterView(this.Y0);
            this.I1.d(Math.max(this.r0.getMeasuredHeight(), this.I0 / 2));
            this.l.addFooterView(this.I1.a());
            this.I1.f(kp7Var);
        }
        C2(kp7Var);
        if (kp7Var.e0() && this.c.v().C2() && this.c.Y4() != null) {
            this.c.Y4().d();
        }
        if (kp7Var.g() != 3) {
            D1(kp7Var);
        }
        this.v0.setText(TbSingleton.getInstance().getAdVertiComment(kp7Var.k0(), kp7Var.l0(), e1()));
        if (this.p == null || (kp7Var2 = this.L0) == null || kp7Var2.l() == null) {
            return;
        }
        this.p.m(this.L0.l().getImage_url());
        this.p.n(this.L0.l().getName());
        PbFragment pbFragment2 = this.c;
        if (pbFragment2 == null || pbFragment2.v() == null) {
            return;
        }
        this.p.o(this.c.v().b);
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

    public void P2(String str) {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048638, this, str) == null) || (pbListView = this.I) == null) {
            return;
        }
        pbListView.C(str);
    }

    @SuppressLint({"ResourceAsColor"})
    public final void P3(kp7 kp7Var, boolean z2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048639, this, new Object[]{kp7Var, Boolean.valueOf(z2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) || kp7Var == null || kp7Var.O() == null) {
            return;
        }
        if (this.c.isSimpleForum()) {
            if (kp7Var.h() != null) {
                this.g0 = kp7Var.h().a();
                this.h0 = kp7Var.h().b();
            }
            if (this.g0 == null && this.c.v() != null && this.c.v().o1() != null) {
                this.g0 = this.c.v().o1();
            }
        }
        PostData I0 = I0(kp7Var, z2);
        m3(I0, kp7Var);
        this.u.C(8);
        if (kp7Var.r0()) {
            this.l1 = true;
            this.h.A(true);
            this.h.a.hideBottomLine();
            if (this.r == null) {
                this.r = new gu7(this.c);
            }
            this.r.v(kp7Var, I0, this.l, this.u, this.S0, this.h, this.g0, this.D1);
            this.r.s(this.X1);
            M2();
        } else {
            this.l1 = false;
            this.h.A(false);
            gu7 gu7Var = this.r;
            if (gu7Var != null) {
                gu7Var.p(this.l);
            }
        }
        if (this.c.W4() != null) {
            this.c.W4().w(this.l1);
        }
        if (I0 == null) {
            return;
        }
        this.M0 = I0;
        this.u.C(0);
        SparseArray<Object> r2 = this.u.r();
        r2.put(R.id.obfuscated_res_0x7f091e54, I0);
        r2.put(R.id.obfuscated_res_0x7f091e6d, Boolean.FALSE);
        this.v.e(kp7Var, this.l);
        this.x.e(kp7Var, this.F1, new e0(this));
        this.t.f(kp7Var);
        this.s.h(kp7Var, this.K0);
        this.s.g(kp7Var);
        this.u.D(this.O0, this.L0, I0, this.X1);
        if (this.X0 != null) {
            if (kp7Var.g0()) {
                this.X0.b().setVisibility(8);
            } else {
                this.X0.b().setVisibility(0);
                xp7 xp7Var = new xp7(xp7.h);
                if (kp7Var.O() != null) {
                    kp7Var.O().getReply_num();
                }
                xp7Var.c = kp7Var.g;
                kp7Var.c();
                xp7Var.d = this.c.u5();
                xp7Var.g = kp7Var.f;
                this.X0.i(xp7Var);
            }
        }
        b4(kp7Var);
        mg.a().post(new f0(this));
        this.w.e(this.l);
        if (I0.Q) {
            this.w.f(I0.I());
            this.w.b(this.l, this.l.getHeaderViewsCount() <= 1 ? 0 : 1);
        }
        yr7 yr7Var = this.C;
        if (yr7Var != null && yr7Var.z() != null) {
            this.C.z().m0(I0.Q);
        }
        yr7 yr7Var2 = this.C;
        if (yr7Var2 != null) {
            yr7Var2.q0(I0.Q);
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
            kp7 kp7Var = this.L0;
            return kp7Var == null || kp7Var.l() == null || "0".equals(this.L0.l().getId()) || "me0407".equals(this.L0.l().getName());
        }
        return invokeV.booleanValue;
    }

    public void Q2(String str) {
        PbReplyTitleViewHolder pbReplyTitleViewHolder;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048642, this, str) == null) || this.I == null) {
            return;
        }
        int i3 = 0;
        v0 v0Var = this.b1;
        if (v0Var != null && (pbReplyTitleViewHolder = v0Var.c) != null && pbReplyTitleViewHolder.b() != null) {
            i3 = this.b1.c.b().getTop() < 0 ? this.b1.c.b().getHeight() : this.b1.c.b().getBottom();
        }
        this.I.F(str, i3);
    }

    public void Q3(fq4.c cVar, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048643, this, cVar, z2) == null) {
            mq4 mq4Var = this.c0;
            if (mq4Var != null) {
                mq4Var.dismiss();
                this.c0 = null;
            }
            oq4 oq4Var = new oq4(this.c.getContext());
            ArrayList arrayList = new ArrayList();
            kp7 kp7Var = this.L0;
            if (kp7Var != null && kp7Var.O() != null && !this.L0.O().isBjh()) {
                arrayList.add(new kq4(0, this.c.getPageContext().getString(R.string.obfuscated_res_0x7f0f1096), oq4Var));
            }
            if (!z2) {
                arrayList.add(new kq4(1, this.c.getPageContext().getString(R.string.obfuscated_res_0x7f0f1097), oq4Var));
            }
            oq4Var.j(arrayList);
            oq4Var.n(new c0(this, cVar));
            mq4 mq4Var2 = new mq4(this.c.getPageContext(), oq4Var);
            this.c0 = mq4Var2;
            mq4Var2.m();
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
            gu7 gu7Var = this.r;
            return gu7Var != null && gu7Var.f();
        }
        return invokeV.booleanValue;
    }

    public final void R2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048646, this) == null) {
            this.K1.setFallingFeedbackListener(new FallingView.l() { // from class: com.repackage.or7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.pb.view.FallingView.l
                public final void onClick() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        ot7.this.X1();
                    }
                }
            });
        }
    }

    public void R3(fq4.c cVar, boolean z2, boolean z3, boolean z4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048647, this, new Object[]{cVar, Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4)}) == null) {
            mq4 mq4Var = this.b0;
            if (mq4Var != null) {
                mq4Var.dismiss();
                this.b0 = null;
            }
            oq4 oq4Var = new oq4(this.c.getContext());
            ArrayList arrayList = new ArrayList();
            if (!z4) {
                arrayList.add(new kq4(0, this.c.getPageContext().getString(R.string.obfuscated_res_0x7f0f044a), oq4Var));
            }
            if (z3) {
                arrayList.add(new kq4(1, this.c.getPageContext().getString(R.string.obfuscated_res_0x7f0f0fd0), oq4Var));
            } else if (!z2) {
                arrayList.add(new kq4(1, this.c.getPageContext().getString(R.string.obfuscated_res_0x7f0f0a8e), oq4Var));
            } else {
                arrayList.add(new kq4(1, this.c.getPageContext().getString(R.string.obfuscated_res_0x7f0f0fad), oq4Var));
            }
            oq4Var.j(arrayList);
            oq4Var.n(new b0(this, cVar));
            mq4 mq4Var2 = new mq4(this.c.getPageContext(), oq4Var);
            this.c0 = mq4Var2;
            mq4Var2.m();
        }
    }

    public SparseArray<Object> S0(kp7 kp7Var, boolean z2, int i3) {
        InterceptResult invokeCommon;
        PostData I0;
        tn4 tn4Var;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048648, this, new Object[]{kp7Var, Boolean.valueOf(z2), Integer.valueOf(i3)})) == null) {
            StringBuilder sb = null;
            if (kp7Var == null || (I0 = I0(kp7Var, z2)) == null) {
                return null;
            }
            String userId = I0.s().getUserId();
            boolean z3 = userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount());
            SparseArray<Object> sparseArray = new SparseArray<>();
            if (i3 == 0) {
                sparseArray.put(R.id.obfuscated_res_0x7f091e56, I0.I());
                sparseArray.put(R.id.obfuscated_res_0x7f091e58, 0);
                sparseArray.put(R.id.obfuscated_res_0x7f091e57, Boolean.valueOf(z3));
                sparseArray.put(R.id.obfuscated_res_0x7f091e73, Integer.valueOf(kp7Var.V()));
                sparseArray.put(R.id.obfuscated_res_0x7f091e97, Boolean.FALSE);
            } else if (i3 == 1) {
                if (I0.s() != null) {
                    sparseArray.put(R.id.obfuscated_res_0x7f091e61, I0.s().getUserName());
                    sparseArray.put(R.id.obfuscated_res_0x7f091e62, I0.s().getName_show());
                    sparseArray.put(R.id.obfuscated_res_0x7f091e63, I0.s().getPortrait());
                    sparseArray.put(R.id.obfuscated_res_0x7f091e64, I0.I());
                }
                sparseArray.put(R.id.obfuscated_res_0x7f091e56, I0.I());
                sparseArray.put(R.id.obfuscated_res_0x7f091e58, 0);
                sparseArray.put(R.id.obfuscated_res_0x7f091e57, Boolean.valueOf(z3));
                sparseArray.put(R.id.obfuscated_res_0x7f091e73, Integer.valueOf(kp7Var.V()));
                sparseArray.put(R.id.obfuscated_res_0x7f091e97, Boolean.TRUE);
            }
            if (!z3) {
                List<np4> p3 = kp7Var.p();
                if (ListUtils.getCount(p3) > 0) {
                    sb = new StringBuilder();
                    for (np4 np4Var : p3) {
                        if (np4Var != null && !StringUtils.isNull(np4Var.a()) && (tn4Var = np4Var.g) != null && tn4Var.a && !tn4Var.c && ((i4 = tn4Var.b) == 1 || i4 == 2)) {
                            sb.append(ki.cutString(np4Var.a(), 12));
                            sb.append(this.c.getString(R.string.obfuscated_res_0x7f0f0652));
                            sb.append("、");
                        }
                    }
                }
                if (sb != null && !StringUtils.isNull(sb.toString())) {
                    sparseArray.put(R.id.obfuscated_res_0x7f091e55, String.format(this.c.getString(R.string.obfuscated_res_0x7f0f049c), sb.toString().substring(0, sb.length() - 1)));
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

    public void S2(PbFragment.e3 e3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048650, this, e3Var) == null) {
            this.V1 = e3Var;
        }
    }

    public void S3(AdapterView.OnItemClickListener onItemClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048651, this, onItemClickListener) == null) {
            hq4 hq4Var = this.d0;
            if (hq4Var != null) {
                hq4Var.d();
                this.d0 = null;
            }
            if (this.L0 == null) {
                return;
            }
            ArrayList<qq4> arrayList = new ArrayList<>();
            arrayList.add(new qq4(this.c.getContext().getString(R.string.obfuscated_res_0x7f0f026a), "", this.L0.L() == 1, Integer.toString(1)));
            arrayList.add(new qq4(this.c.getContext().getString(R.string.obfuscated_res_0x7f0f0b3c), "", this.L0.L() == 2, Integer.toString(5)));
            arrayList.add(new qq4(this.c.getContext().getString(R.string.obfuscated_res_0x7f0f0b38), "", this.L0.L() == 3, Integer.toString(6)));
            arrayList.add(new qq4(this.c.getContext().getString(R.string.obfuscated_res_0x7f0f0b56), "", this.L0.L() == 4, Integer.toString(7)));
            hq4 hq4Var2 = new hq4(this.c.getPageContext());
            hq4Var2.l(R.string.obfuscated_res_0x7f0f0dd7);
            this.d0 = hq4Var2;
            hq4Var2.k(arrayList, onItemClickListener);
            hq4Var2.c();
            this.d0.n();
        }
    }

    public kr7 T0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048652, this)) == null) ? this.u1 : (kr7) invokeV.objValue;
    }

    public boolean T1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048653, this)) == null) {
            tx7 tx7Var = this.D0;
            if (tx7Var == null) {
                return false;
            }
            return tx7Var.i();
        }
        return invokeV.booleanValue;
    }

    public void T2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048654, this, z2) == null) {
            this.l0 = z2;
        }
    }

    public void T3() {
        PostData postData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048655, this) == null) || !TbadkCoreApplication.isLogin() || this.L0 == null || !this.m1 || this.l1 || this.f0 || (postData = this.M0) == null || postData.s() == null || this.M0.s().getIsLike() || this.M0.s().hadConcerned() || this.i1 != null) {
            return;
        }
        this.i1 = new jt7(this.c);
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
            this.C.h0(z2);
        }
    }

    public final void U3(dq4 dq4Var, int i3) {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048659, this, dq4Var, i3) == null) || (pbFragment = this.c) == null || dq4Var == null) {
            return;
        }
        if (this.z1 == null && this.s != null) {
            this.z1 = new lh5(pbFragment.getPageContext(), this.s.c());
        }
        AntiData D4 = this.c.D4();
        SparseArray<String> sparseArray = new SparseArray<>();
        if (D4 != null && D4.getDelThreadInfoList() != null) {
            List<DeleteThreadInfo> delThreadInfoList = D4.getDelThreadInfoList();
            for (int i4 = 0; i4 < delThreadInfoList.size(); i4++) {
                if (!TextUtils.isEmpty(delThreadInfoList.get(i4).text_info)) {
                    sparseArray.put(delThreadInfoList.get(i4).text_id, delThreadInfoList.get(i4).text_info);
                }
            }
        }
        lo4 lo4Var = new lo4();
        lo4Var.j(sparseArray);
        this.z1.y(new String[]{this.c.getString(R.string.obfuscated_res_0x7f0f04b8), this.c.getString(R.string.obfuscated_res_0x7f0f04b9), this.c.getString(R.string.obfuscated_res_0x7f0f04ba), this.c.getString(R.string.obfuscated_res_0x7f0f04bb), this.c.getString(R.string.obfuscated_res_0x7f0f04bc)});
        this.z1.x(lo4Var);
        this.z1.A((i3 == 1 || i3 == 2) ? "4" : "3");
        this.z1.z(new x(this, dq4Var));
    }

    public final int V0(boolean z2) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048660, this, z2)) == null) {
            PbInterviewStatusView pbInterviewStatusView = this.R0;
            if (pbInterviewStatusView != null && pbInterviewStatusView.getVisibility() == 0 && z2) {
                return 0 + li.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f07026a);
            }
            return 0;
        }
        return invokeZ.intValue;
    }

    public /* synthetic */ void V1() {
        this.l.post(new Runnable() { // from class: com.repackage.pr7
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // java.lang.Runnable
            public final void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    ot7.this.W1();
                }
            }
        });
    }

    public void V2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048662, this, z2) == null) {
            this.E1 = z2;
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
        os7 os7Var = this.p;
        if (os7Var != null) {
            os7Var.p();
        }
    }

    public void W2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048666, this, z2) == null) {
            this.w1 = z2;
        }
    }

    public void W3() {
        yr7 yr7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048667, this) == null) || (yr7Var = this.C) == null) {
            return;
        }
        yr7Var.y0();
    }

    public PbListView X0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048668, this)) == null) ? this.I : (PbListView) invokeV.objValue;
    }

    public /* synthetic */ void X1() {
        String e1;
        PbFragment pbFragment = this.c;
        if (pbFragment != null && pbFragment.v() != null && this.c.v().v2()) {
            e1 = this.c.getString(R.string.obfuscated_res_0x7f0f0dde);
        } else {
            e1 = e1();
        }
        if (!StringUtils.isNull(e1) && this.L0 != null) {
            e1 = TbSingleton.getInstance().getAdVertiComment(this.L0.k0(), this.L0.l0(), e1);
        }
        PbFragment pbFragment2 = this.c;
        if (pbFragment2 != null && pbFragment2.V4() != null) {
            this.c.V4().k0(e1);
        }
        TextView textView = this.v0;
        if (textView != null) {
            textView.setText(e1);
        }
        D3(false);
        X3();
    }

    public void X2(boolean z2) {
        gu7 gu7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048670, this, z2) == null) || (gu7Var = this.r) == null) {
            return;
        }
        gu7Var.r(z2);
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
        imageView.setImageResource(R.drawable.obfuscated_res_0x7f080986);
    }

    public void Y2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048674, this, z2) == null) {
            this.C.j0(z2);
        }
    }

    public void Y3() {
        tx7 tx7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048675, this) == null) || (tx7Var = this.D0) == null) {
            return;
        }
        tx7Var.o(2);
    }

    public View Z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048676, this)) == null) ? this.U0 : (View) invokeV.objValue;
    }

    public void Z1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048677, this) == null) {
            C2(this.L0);
        }
    }

    public void Z2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048678, this, z2) == null) {
            this.C.o0(z2);
        }
    }

    public void Z3(po4 po4Var, dq4.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048679, this, po4Var, eVar) == null) || po4Var == null) {
            return;
        }
        int a2 = po4Var.a();
        int h3 = po4Var.h();
        dq4 dq4Var = this.D;
        if (dq4Var != null) {
            dq4Var.show();
        } else {
            this.D = new dq4(this.c.getPageContext().getPageActivity());
            View inflate = LayoutInflater.from(this.c.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0228, (ViewGroup) null);
            this.F = inflate;
            this.D.setContentView(inflate);
            this.D.setPositiveButton(R.string.obfuscated_res_0x7f0f04ea, eVar);
            this.D.setNegativeButton(R.string.obfuscated_res_0x7f0f04e5, new k0(this));
            this.D.setOnCalcelListener(new l0(this));
            this.D.create(this.c.getPageContext()).show();
        }
        EditText editText = (EditText) this.F.findViewById(R.id.obfuscated_res_0x7f090ecd);
        this.G = editText;
        editText.setText("");
        TextView textView = (TextView) this.F.findViewById(R.id.obfuscated_res_0x7f09071c);
        if (a2 <= 0) {
            a2 = 1;
        }
        if (h3 <= 0) {
            h3 = 1;
        }
        textView.setText(MessageFormat.format(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0476), Integer.valueOf(a2), Integer.valueOf(h3)));
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

    public void a3(ft4.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048684, this, gVar) == null) {
            this.a2 = gVar;
            ux7 ux7Var = this.H;
            if (ux7Var != null) {
                ux7Var.e(gVar);
            }
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
            M2();
            return;
        }
        AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) textView.getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT) + V0(true);
            this.T0.setLayoutParams(layoutParams2);
        }
        M2();
        F2();
    }

    public void b0() {
        tx7 tx7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048686, this) == null) || (tx7Var = this.D0) == null) {
            return;
        }
        tx7Var.m(false);
    }

    public ks7 b1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048687, this)) == null) ? this.h1 : (ks7) invokeV.objValue;
    }

    public void b2() {
        ns7 ns7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048688, this) == null) || (ns7Var = this.q) == null) {
            return;
        }
        ns7Var.b();
    }

    public void b3(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048689, this, onClickListener) == null) {
            this.b2 = onClickListener;
            yr7 yr7Var = this.C;
            if (yr7Var != null) {
                yr7Var.p0(onClickListener);
            }
        }
    }

    public final void b4(kp7 kp7Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048690, this, kp7Var) == null) || kp7Var == null || kp7Var.O() == null || kp7Var.O().isVideoThreadType()) {
            return;
        }
        boolean z2 = kp7Var.O().getIs_good() == 1;
        boolean z3 = kp7Var.O().getIs_top() == 1;
        fu7 fu7Var = this.u;
        if (fu7Var != null) {
            fu7Var.l(kp7Var, z2, z3);
        }
        yr7 yr7Var = this.C;
        if (yr7Var == null || yr7Var.t() == null) {
            return;
        }
        this.C.t().e(kp7Var, z2, z3);
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

    public gu7 c1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048692, this)) == null) ? this.r : (gu7) invokeV.objValue;
    }

    public void c2(qg8 qg8Var) {
        kp7 kp7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048693, this, qg8Var) == null) || qg8Var == null || qg8Var.a == null || qg8Var.b == null || (kp7Var = this.L0) == null || kp7Var.O() == null || this.L0.O().getAgreeData() == null) {
            return;
        }
        AgreeData agreeData = this.L0.O().getAgreeData();
        String str = qg8Var.b.nid;
        if (!TextUtils.isEmpty(str) && !"0".equals(str)) {
            BaijiahaoData baijiahaoData = agreeData.baijiahaoData;
            if (baijiahaoData == null || !TextUtils.equals(str, baijiahaoData.oriUgcNid)) {
                return;
            }
        } else {
            String str2 = qg8Var.b.threadId;
            String str3 = agreeData.threadId;
            if ("0".equals(str2) || TextUtils.isEmpty(str2) || !TextUtils.equals(str2, str3)) {
                return;
            }
        }
        AgreeData agreeData2 = qg8Var.b;
        if (agreeData2.agreeType == 2 && agreeData2.hasAgree) {
            x3(this.y0);
        }
        AgreeData agreeData3 = qg8Var.b;
        B2(agreeData3, agreeData3.agreeNum);
    }

    public void c3(String str) {
        iv7 iv7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048694, this, str) == null) || (iv7Var = this.i) == null) {
            return;
        }
        iv7Var.b(str);
    }

    @SuppressLint({"CutPasteId"})
    public void c4(kp7 kp7Var, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048695, this, kp7Var, z2) == null) || kp7Var == null) {
            return;
        }
        m4(kp7Var, z2);
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
            return this.I.h().equals(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f09f3));
        }
        return invokeV.booleanValue;
    }

    public final PostData d1(kp7 kp7Var) {
        InterceptResult invokeL;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048697, this, kp7Var)) == null) {
            if (kp7Var == null || kp7Var.O() == null || kp7Var.O().getAuthor() == null) {
                return null;
            }
            PostData postData = new PostData();
            MetaData author = kp7Var.O().getAuthor();
            String userId = author.getUserId();
            HashMap<String, MetaData> userMap = kp7Var.O().getUserMap();
            if (userMap != null && (metaData = userMap.get(userId)) != null && metaData.getUserId() != null) {
                author = metaData;
            }
            postData.p0(1);
            postData.u0(kp7Var.O().getFirstPostId());
            postData.G0(kp7Var.O().getTitle());
            postData.F0(kp7Var.O().getCreateTime());
            postData.n0(author);
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
        E2(this.L0, this.K0, this.N0, i3);
        this.c.getBaseFragmentActivity().getLayoutMode().k(i3 == 1);
        this.c.getBaseFragmentActivity().getLayoutMode().j(this.d);
        SkinManager.setBackgroundColor(this.d, R.color.CAM_X0201);
        SkinManager.setBackgroundColor(this.m0, R.color.CAM_X0203);
        gu7 gu7Var = this.r;
        if (gu7Var != null) {
            gu7Var.h(i3);
        }
        cu7 cu7Var = this.v;
        if (cu7Var != null) {
            cu7Var.c(i3);
        }
        bu7 bu7Var = this.s;
        if (bu7Var != null) {
            bu7Var.e(i3);
        }
        du7 du7Var = this.t;
        if (du7Var != null) {
            du7Var.c(i3);
        }
        fu7 fu7Var = this.u;
        if (fu7Var != null) {
            fu7Var.u(i3);
        }
        eu7 eu7Var = this.w;
        if (eu7Var != null) {
            eu7Var.d();
        }
        au7 au7Var = this.x;
        if (au7Var != null) {
            au7Var.c();
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
        dq4 dq4Var = this.D;
        if (dq4Var != null) {
            dq4Var.autoChangeSkinType(this.c.getPageContext());
        }
        h4(this.e0);
        this.C.Z();
        ux7 ux7Var = this.H;
        if (ux7Var != null) {
            ux7Var.H(i3);
        }
        EditorTools editorTools = this.k0;
        if (editorTools != null) {
            editorTools.w(i3);
        }
        qx7 qx7Var = this.J;
        if (qx7Var != null) {
            qx7Var.f(i3);
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
            q85.a(this.c.getPageContext(), this.y);
        }
        ks7 ks7Var = this.h1;
        if (ks7Var != null) {
            ks7Var.h(i3);
        }
        jv7 jv7Var = this.h;
        if (jv7Var != null) {
            gu7 gu7Var2 = this.r;
            if (gu7Var2 != null) {
                gu7Var2.i(i3);
            } else {
                jv7Var.u(i3);
            }
        }
        HeadImageView headImageView = this.t0;
        if (headImageView != null) {
            headImageView.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
        }
        LinearLayout linearLayout = this.s0;
        if (linearLayout != null) {
            linearLayout.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(li.f(this.c.getContext(), R.dimen.tbds47), SkinManager.getColor(R.color.CAM_X0209)));
        }
        kp7 kp7Var = this.L0;
        if (kp7Var != null && kp7Var.r()) {
            WebPManager.setPureDrawable(this.z0, R.drawable.obfuscated_res_0x7f08094c, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
        } else {
            WebPManager.setPureDrawable(this.z0, R.drawable.obfuscated_res_0x7f08094b, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        }
        WebPManager.setPureDrawable(this.x0, R.drawable.obfuscated_res_0x7f08094e, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        WebPManager.setPureDrawable(this.u0, R.drawable.obfuscated_res_0x7f080986, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL);
        l4(this.L0);
        if (this.C0.getVisibility() == 0) {
            this.C0.setBackgroundDrawable(SkinManager.createShapeDrawable(li.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds15), R.color.CAM_X0301, 0, 0, i3));
        }
        SkinManager.setBackgroundColor(this.r0, R.color.CAM_X0207);
        SkinManager.setBackgroundColor(this.q0, R.color.CAM_X0203);
        SkinManager.setViewTextColor(this.r1, (int) R.color.cp_cont_n);
        SkinManager.setViewTextColor(this.v0, (int) R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.G0, (int) R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.F0, (int) R.color.CAM_X0107);
        SkinManager.setBackgroundShapeDrawable(this.F0, li.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18), R.color.CAM_X0207, R.color.CAM_X0207);
        SkinManager.setViewTextColor(this.E0, (int) R.color.CAM_X0107);
        SkinManager.setBackgroundShapeDrawable(this.E0, li.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18), R.color.CAM_X0207, R.color.CAM_X0207);
        AgreeView agreeView = this.y0;
        if (agreeView != null) {
            agreeView.r();
            this.y0.J(i3);
            AgreeData data = this.y0.getData();
            if (data != null) {
                B2(data, data.agreeNum);
            }
        }
        kr7 kr7Var = this.u1;
        if (kr7Var != null) {
            kr7Var.m(i3);
        }
        PbEmotionBar pbEmotionBar = this.c1;
        if (pbEmotionBar != null) {
            pbEmotionBar.w();
        }
        PbThreadPostView pbThreadPostView = this.o;
        if (pbThreadPostView != null) {
            pbThreadPostView.c(i3);
        }
        tx7 tx7Var = this.D0;
        if (tx7Var != null) {
            tx7Var.j();
        }
        sx7 sx7Var = this.I1;
        if (sx7Var != null) {
            sx7Var.c();
        }
        RightFloatLayerView rightFloatLayerView = this.L1;
        if (rightFloatLayerView != null) {
            rightFloatLayerView.o();
        }
        SkinManager.setBackgroundColor(this.V0, R.color.CAM_X0207);
        SkinManager.setViewTextColor(this.V0.findViewById(R.id.obfuscated_res_0x7f0921ff), (int) R.color.CAM_X0105);
    }

    public void d3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048699, this, z2) == null) {
            this.j1 = z2;
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView != null) {
                this.k1 = pbLandscapeListView.getHeaderViewsCount();
            }
        }
    }

    public void d4(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048700, this, str) == null) {
            this.c.showToast(str);
        }
    }

    public final void e0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048701, this) == null) || this.L0 == null || !UbsABTestHelper.isResizeInduceSharingABTest() || fv7.k(this.L0.Q())) {
            return;
        }
        this.D0.f();
        fv7.b(this.L0.Q());
    }

    public String e1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048702, this)) == null) {
            if (!ki.isEmpty(this.B1)) {
                return this.B1;
            }
            if (this.c != null) {
                this.B1 = TbadkCoreApplication.getInst().getResources().getString(mt7.b());
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
            L2();
        }
        ks7 ks7Var = this.h1;
        if (ks7Var != null) {
            ks7Var.c();
        }
        this.c.k5();
        this.B.setVisibility(8);
        this.h.B(false);
        this.c.i6(false);
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

    public void e3(PbFragment.f3 f3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048704, this, f3Var) == null) {
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
                TiebaStatic.log(new StatisticItem("c10517").param("obj_locate", 2).param("fid", this.h0));
            } else if (this.c.n4()) {
                x15 V4 = this.c.V4();
                if (V4 != null && (V4.B() || V4.D())) {
                    this.c.V4().z(false, null);
                    return;
                }
                if (this.k0 != null) {
                    B1();
                }
                EditorTools editorTools = this.k0;
                if (editorTools != null) {
                    this.H0 = false;
                    if (editorTools.n(2) != null) {
                        lg8.c(this.c.getPageContext(), (View) this.k0.n(2).m, false, p2);
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
            os7 os7Var = this.p;
            if (os7Var != null) {
                os7Var.l();
            }
            RelativeLayout relativeLayout = this.d;
            if (relativeLayout != null && relativeLayout.getHandler() != null) {
                this.d.getHandler().removeCallbacksAndMessages(null);
            }
            tx7 tx7Var = this.D0;
            if (tx7Var != null) {
                tx7Var.k();
            }
            jt7 jt7Var = this.i1;
            if (jt7Var != null) {
                jt7Var.a();
            }
            bt7 bt7Var = this.x1;
            if (bt7Var != null) {
                bt7Var.c();
            }
            PbTopTipView pbTopTipView = this.p1;
            if (pbTopTipView != null) {
                pbTopTipView.g();
            }
            this.c.hideProgressBar();
            NoNetworkView noNetworkView = this.m;
            if (noNetworkView != null && (bVar = this.P) != null) {
                noNetworkView.d(bVar);
            }
            m0();
            u0();
            if (this.f1 != null) {
                mg.a().removeCallbacks(this.f1);
            }
            PbInterviewStatusView pbInterviewStatusView = this.R0;
            if (pbInterviewStatusView != null) {
                pbInterviewStatusView.m();
            }
            this.S1 = null;
            this.g.removeCallbacksAndMessages(null);
            this.C.a0(3);
            View view2 = this.e;
            if (view2 != null) {
                view2.setBackgroundDrawable(null);
            }
            gu7 gu7Var = this.r;
            if (gu7Var != null) {
                gu7Var.a();
            }
            yr7 yr7Var = this.C;
            if (yr7Var != null) {
                yr7Var.b0();
            }
            this.l.setOnLayoutListener(null);
            lu7 lu7Var = this.t1;
            if (lu7Var != null) {
                lu7Var.l();
            }
            PbEmotionBar pbEmotionBar = this.c1;
            if (pbEmotionBar != null) {
                pbEmotionBar.x();
            }
            fu7 fu7Var = this.u;
            if (fu7Var != null) {
                fu7Var.v();
            }
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView != null) {
                pbLandscapeListView.getViewTreeObserver().removeGlobalOnLayoutListener(this.a);
            }
        }
    }

    public void f3(TbRichTextView.y yVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048709, this, yVar) == null) {
            this.O = yVar;
            this.C.s0(yVar);
            this.u1.q(this.O);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048712, this)) == null) ? R.id.obfuscated_res_0x7f091a78 : invokeV.intValue;
    }

    public void g2(TbRichText tbRichText) {
        kp7 kp7Var;
        PostData postData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048713, this, tbRichText) == null) || (kp7Var = this.L0) == null || kp7Var.F() == null || this.L0.F().isEmpty() || tbRichText == null || StringUtils.isNull(tbRichText.getAuthorId())) {
            return;
        }
        for (int i3 = 0; i3 < this.L0.F().size() && (postData = this.L0.F().get(i3)) != null && postData.s() != null && !StringUtils.isNull(postData.s().getUserId()); i3++) {
            if (this.L0.F().get(i3).s().getUserId().equals(tbRichText.getAuthorId())) {
                kr7 kr7Var = this.u1;
                if (kr7Var != null && kr7Var.l()) {
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

    public void g3(NoNetworkView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048714, this, bVar) == null) {
            this.P = bVar;
            NoNetworkView noNetworkView = this.m;
            if (noNetworkView != null) {
                noNetworkView.a(bVar);
            }
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
            kr7 kr7Var = new kr7(this.c, this, (ViewStub) this.d.findViewById(R.id.obfuscated_res_0x7f091416));
            this.u1 = kr7Var;
            kr7Var.o(this.N);
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
            gu7 gu7Var = this.r;
            if (gu7Var != null) {
                return gu7Var.k(i3);
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public void h3(BdListView.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048719, this, pVar) == null) {
            this.l.setOnSrollToBottomListener(pVar);
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
            RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, li.f(pageActivity, R.dimen.obfuscated_res_0x7f07019a));
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
            kp7 kp7Var = this.L0;
            if (kp7Var == null || kp7Var.l() == null || ki.isEmpty(this.L0.l().getName())) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.c.getContext()).createNormalCfg(this.L0.l().getName(), null)));
            TiebaStatic.log(new StatisticItem("c13853").param("post_id", this.L0.Q()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("fid", this.L0.l().getId()));
        } else if (!this.m1 || this.l1 || (postData = this.M0) == null || postData.s() == null) {
        } else {
            TiebaStatic.log(new StatisticItem("c12601").param("obj_locate", this.c.isSimpleForum() ? 2 : 1).param("obj_type", this.l1 ? 2 : 1));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.c.getPageContext().getPageActivity(), this.M0.s().getUserId(), this.M0.s().getUserName(), this.c.v().o1(), AddFriendActivityConfig.TYPE_PB_HEAD)));
        }
    }

    public void i3(AbsListView.OnScrollListener onScrollListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048724, this, onScrollListener) == null) {
            this.l.setOnScrollListener(onScrollListener);
        }
    }

    public void i4(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048725, this, z2) == null) {
            this.h.H(z2);
            if (z2 && this.P0) {
                this.I.C(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f03e7));
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
        dq4 dq4Var = new dq4(this.c.getPageContext().getPageActivity());
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(i2, Integer.valueOf(k2));
        dq4Var.setTitle(R.string.obfuscated_res_0x7f0f07de);
        View inflate = LayoutInflater.from(this.c.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0843, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090c08)).setText(R.string.obfuscated_res_0x7f0f0787);
        ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f092048)).setText(R.string.obfuscated_res_0x7f0f07de);
        dq4Var.setContentView(inflate);
        dq4Var.setYesButtonTag(sparseArray);
        dq4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f07dd, this.c);
        dq4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0a69, new m0(this));
        dq4Var.create(this.c.getPageContext()).show();
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
            y2(this.b1.c, false);
        }
    }

    public void j3(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048729, this, onClickListener) == null) {
            this.C.w0(onClickListener);
        }
    }

    public void j4(ip7 ip7Var) {
        String string;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048730, this, ip7Var) == null) || ip7Var == null) {
            return;
        }
        this.h.I();
        if (!StringUtils.isNull(ip7Var.b)) {
            this.h.F(ip7Var.b);
        }
        String string2 = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f13d1);
        int e2 = jg.e(ip7Var.a, 0);
        if (e2 == 100) {
            string = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f1107);
        } else if (e2 != 300) {
            string = e2 != 400 ? "" : TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f134b);
        } else {
            string = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f02ed);
        }
        this.c.showNetRefreshView(this.d, String.format(string2, string), null, TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0297), true, new h0(this, ip7Var.c));
    }

    public void k0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048731, this, str) == null) {
            if (str.contains("_")) {
                str = str.replace("_", "\n");
            }
            dq4 dq4Var = new dq4(this.c.getPageContext().getPageActivity());
            View inflate = LayoutInflater.from(this.c.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0843, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f092048);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(0, 0, 0, 0);
            textView.setLayoutParams(layoutParams);
            textView.setGravity(3);
            textView.setText(str);
            ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090c08)).setVisibility(8);
            dq4Var.setContentView(inflate);
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(i2, Integer.valueOf(l2));
            dq4Var.setYesButtonTag(sparseArray);
            dq4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f1545, this.c);
            dq4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0376, new n0(this));
            dq4Var.create(this.c.getPageContext()).show();
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
            this.C.a0(1);
            gu7 gu7Var = this.r;
            if (gu7Var != null) {
                gu7Var.l();
            }
            os7 os7Var = this.p;
            if (os7Var != null) {
                os7Var.k();
            }
            RightFloatLayerView rightFloatLayerView = this.L1;
            if (rightFloatLayerView != null && (rightFloatLayerView instanceof RightFloatLayerLottieView)) {
                ((RightFloatLayerLottieView) rightFloatLayerView).H(600);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
        }
    }

    public void k3(int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048734, this, i3) == null) {
            this.F1 = i3;
        }
    }

    public final void k4() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048735, this) == null) || (pbFragment = this.c) == null || pbFragment.V4() == null) {
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921706, Boolean.valueOf(!this.c.V4().C())));
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x004d, code lost:
        if (r5.G1 == 1) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void l0() {
        sx7 sx7Var;
        boolean z2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048736, this) == null) || (sx7Var = this.I1) == null) {
            return;
        }
        if (((sx7Var.a() == null || this.I1.a().getParent() == null) ? -1 : this.l.getPositionForView(this.I1.a())) != -1) {
            if (this.I1.a().getTop() + n2 <= this.U0.getBottom()) {
                this.G1 = 1;
                z2 = true;
            } else {
                this.G1 = 0;
                z2 = false;
            }
        }
        this.X0.u(this.G1 == 1);
        this.I1.e(z2);
    }

    public RelativeLayout l1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048737, this)) == null) ? this.B : (RelativeLayout) invokeV.objValue;
    }

    public void l2(mn mnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048738, this, mnVar) == null) {
            PbLandscapeListView pbLandscapeListView = this.l;
            pbLandscapeListView.h0 = mnVar;
            pbLandscapeListView.W = true;
        }
    }

    public void l3(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048739, this, onLongClickListener) == null) {
            this.u.y(onLongClickListener);
            this.C.t0(onLongClickListener);
            kr7 kr7Var = this.u1;
            if (kr7Var != null) {
                kr7Var.r(onLongClickListener);
            }
        }
    }

    public void l4(kp7 kp7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048740, this, kp7Var) == null) {
            if (kp7Var != null && AntiHelper.o(kp7Var.O())) {
                tx7 tx7Var = this.D0;
                if (tx7Var != null) {
                    tx7Var.l(false);
                    this.D0.k();
                }
                ViewGroup.LayoutParams layoutParams = this.A0.getLayoutParams();
                layoutParams.height = -2;
                layoutParams.width = -2;
                this.A0.setLayoutParams(layoutParams);
                WebPManager.setPureDrawable(this.A0, R.drawable.obfuscated_res_0x7f080950, R.color.CAM_X0110, WebPManager.ResourceStateType.NORMAL_PRESS);
                return;
            }
            tx7 tx7Var2 = this.D0;
            if (tx7Var2 == null || !tx7Var2.h()) {
                ViewGroup.LayoutParams layoutParams2 = this.A0.getLayoutParams();
                layoutParams2.height = -2;
                layoutParams2.width = -2;
                this.A0.setLayoutParams(layoutParams2);
                WebPManager.setPureDrawable(this.A0, R.drawable.obfuscated_res_0x7f080950, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            }
        }
    }

    public void m0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048741, this) == null) {
            this.h.k();
            fu7 fu7Var = this.u;
            if (fu7Var != null) {
                fu7Var.m();
            }
            PbFragment pbFragment = this.c;
            if (pbFragment != null) {
                li.x(pbFragment.getContext(), this.G);
            }
            q1();
            mq4 mq4Var = this.b0;
            if (mq4Var != null) {
                mq4Var.dismiss();
            }
            q0();
            dq4 dq4Var = this.D;
            if (dq4Var != null) {
                dq4Var.dismiss();
            }
            fq4 fq4Var = this.E;
            if (fq4Var != null) {
                fq4Var.e();
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
            this.C.a0(2);
            gu7 gu7Var = this.r;
            if (gu7Var != null) {
                gu7Var.m();
                if (TbSingleton.getInstance().isNotchScreen(this.c.getFragmentActivity()) || TbSingleton.getInstance().isCutoutScreen(this.c.getFragmentActivity())) {
                    return;
                }
                m1().setSystemUiVisibility(4);
            }
        }
    }

    public final void m3(PostData postData, kp7 kp7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048744, this, postData, kp7Var) == null) {
            this.u.z(postData, kp7Var);
        }
    }

    public boolean m4(kp7 kp7Var, boolean z2) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048745, this, kp7Var, z2)) == null) {
            if (kp7Var == null) {
                return false;
            }
            if (this.t != null) {
                if (kp7Var.O() != null && kp7Var.O().getIsNoTitle() == 0 && !kp7Var.O().isVideoThreadType() && !this.N1) {
                    if (kp7Var.O() != null) {
                        ThreadData O = kp7Var.O();
                        O.parserSpecTitleForFrsAndPb(true, G3(kp7Var));
                        O.setResource(3);
                        O.setPbTitle("2");
                    }
                    if (kp7Var.O().isBJHArticleThreadType()) {
                        this.u.x(this.l);
                        this.t.d(this.l);
                        this.t.a(this.l);
                        this.u.j(this.l);
                        this.u.B(this.L0);
                        if (I1(kp7Var)) {
                            this.t.d(this.l);
                        } else {
                            this.t.e(kp7Var);
                        }
                    } else {
                        this.u.B(this.L0);
                        if (I1(kp7Var)) {
                            this.t.d(this.l);
                        } else {
                            this.t.g(kp7Var);
                        }
                    }
                } else if (kp7Var.O().getIsNoTitle() == 1) {
                    if (kp7Var.O() != null) {
                        this.t.d(this.l);
                        this.u.B(this.L0);
                    }
                } else {
                    this.t.d(this.l);
                    this.u.B(this.L0);
                }
            }
            b4(kp7Var);
            this.K0 = z2;
            return false;
        }
        return invokeLZ.booleanValue;
    }

    public void n0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048746, this) == null) {
            this.h.k();
            fu7 fu7Var = this.u;
            if (fu7Var != null) {
                fu7Var.m();
            }
            mq4 mq4Var = this.b0;
            if (mq4Var != null) {
                mq4Var.dismiss();
            }
            q0();
            dq4 dq4Var = this.D;
            if (dq4Var != null) {
                dq4Var.dismiss();
            }
            fq4 fq4Var = this.E;
            if (fq4Var != null) {
                fq4Var.e();
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
            jv7 jv7Var = this.h;
            if (jv7Var == null || (view2 = jv7Var.d) == null) {
                return;
            }
            view2.setVisibility(8);
        }
    }

    public void n2(AbsListView absListView, int i3, int i4, int i5) {
        PbReplyTitleViewHolder pbReplyTitleViewHolder;
        fu7 fu7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048748, this, absListView, i3, i4, i5) == null) {
            ns7 ns7Var = this.q;
            if (ns7Var != null) {
                ns7Var.c(i3, i4);
            }
            gu7 gu7Var = this.r;
            if (gu7Var != null) {
                gu7Var.n(absListView, i3, i4, i5);
            }
            jv7 jv7Var = this.h;
            if (jv7Var != null && (fu7Var = this.u) != null) {
                jv7Var.w(fu7Var.p());
            }
            v0 v0Var = this.b1;
            v0Var.a = i3;
            v0Var.b = this.l.getHeaderViewsCount();
            this.b1.c = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.b1));
            C3(a0(absListView, i3));
            int i6 = 0;
            y2(this.b1.c, false);
            l0();
            if (!this.I.n() || this.I.C) {
                return;
            }
            v0 v0Var2 = this.b1;
            if (v0Var2 != null && (pbReplyTitleViewHolder = v0Var2.c) != null && pbReplyTitleViewHolder.b() != null) {
                i6 = this.b1.c.b().getTop() < 0 ? this.b1.c.b().getHeight() : this.b1.c.b().getBottom();
            }
            this.I.e(i6);
            this.I.C = true;
        }
    }

    public void n3(boolean z2, PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048749, this, z2, postWriteCallBackData) == null) {
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

    public final void n4() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048750, this) == null) && this.c.N4()) {
            if (this.c.S4() == -1) {
                SkinManager.setViewTextColor(this.z, R.color.CAM_X0110, 1);
            }
            if (this.c.R4() == -1) {
                SkinManager.setViewTextColor(this.A, R.color.CAM_X0110, 1);
            }
        }
    }

    public void o0() {
        tx7 tx7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048751, this) == null) || (tx7Var = this.D0) == null) {
            return;
        }
        tx7Var.l(false);
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
            K2(false);
        }
    }

    public void o2(AbsListView absListView, int i3) {
        RightFloatLayerView rightFloatLayerView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048753, this, absListView, i3) == null) {
            gu7 gu7Var = this.r;
            if (gu7Var != null) {
                gu7Var.o(absListView, i3);
            }
            if (!this.f2 && i3 == 0) {
                this.d2 = h1();
                this.b1.c = null;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.b1));
                y2(this.b1.c, true);
                l0();
                this.C.f0(true);
            }
            this.C.e0();
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

    public void o3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048754, this) == null) {
            this.c.hideProgressBar();
            kp7 kp7Var = this.L0;
            if (kp7Var != null && this.I != null && kp7Var.y() != null && this.L0.y().b() == 0) {
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

    public void o4(kp7 kp7Var) {
        bu7 bu7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048755, this, kp7Var) == null) || (bu7Var = this.s) == null) {
            return;
        }
        bu7Var.h(kp7Var, this.K0);
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
        kp7 kp7Var = this.L0;
        boolean z3 = kp7Var != null && kp7Var.k0();
        kp7 kp7Var2 = this.L0;
        this.v0.setText(tbSingleton.getAdVertiComment(z3, kp7Var2 != null && kp7Var2.l0(), e1()));
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
        K2(true);
    }

    public void p2(ArrayList<bo4> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048758, this, arrayList) == null) {
            if (this.V == null) {
                this.V = LayoutInflater.from(this.c.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d01e4, (ViewGroup) null);
            }
            this.c.getBaseFragmentActivity().getLayoutMode().j(this.V);
            if (this.U == null) {
                Dialog dialog = new Dialog(this.c.getPageContext().getPageActivity(), R.style.obfuscated_res_0x7f10039f);
                this.U = dialog;
                dialog.setCanceledOnTouchOutside(true);
                this.U.setCancelable(true);
                this.j0 = (ScrollView) this.V.findViewById(R.id.obfuscated_res_0x7f090c90);
                this.U.setContentView(this.V);
                WindowManager.LayoutParams attributes = this.U.getWindow().getAttributes();
                attributes.width = li.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0702de);
                this.U.getWindow().setAttributes(attributes);
                this.X = new z(this);
                this.W = (LinearLayout) this.V.findViewById(R.id.obfuscated_res_0x7f090c8f);
                TextView textView = (TextView) this.V.findViewById(R.id.obfuscated_res_0x7f090783);
                this.Z = textView;
                textView.setOnClickListener(new a0(this));
                TextView textView2 = (TextView) this.V.findViewById(R.id.obfuscated_res_0x7f090784);
                this.Y = textView2;
                textView2.setOnClickListener(this.N);
            }
            this.W.removeAllViews();
            this.n = new ArrayList();
            CustomBlueCheckRadioButton i02 = i0("0", this.c.getPageContext().getString(R.string.obfuscated_res_0x7f0f13d6));
            this.n.add(i02);
            i02.setChecked(true);
            this.W.addView(i02);
            if (arrayList != null) {
                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                    bo4 bo4Var = arrayList.get(i3);
                    if (bo4Var != null && !TextUtils.isEmpty(bo4Var.b()) && bo4Var.a() > 0) {
                        CustomBlueCheckRadioButton i03 = i0(String.valueOf(bo4Var.a()), bo4Var.b());
                        this.n.add(i03);
                        View view2 = new View(this.c.getPageContext().getPageActivity());
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, li.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f070198));
                        SkinManager.setBackgroundColor(view2, R.color.CAM_X0204);
                        view2.setLayoutParams(layoutParams);
                        this.W.addView(view2);
                        this.W.addView(i03);
                    }
                }
                ViewGroup.LayoutParams layoutParams2 = this.j0.getLayoutParams();
                int size = arrayList.size();
                if (size == 0 || size == 1) {
                    layoutParams2.height = li.d(this.c.getPageContext().getPageActivity(), 120.0f);
                } else if (size != 2) {
                    layoutParams2.height = li.d(this.c.getPageContext().getPageActivity(), 220.0f);
                } else {
                    layoutParams2.height = li.d(this.c.getPageContext().getPageActivity(), 186.0f);
                }
                this.j0.setLayoutParams(layoutParams2);
                this.j0.removeAllViews();
                LinearLayout linearLayout = this.W;
                if (linearLayout != null && linearLayout.getParent() == null) {
                    this.j0.addView(this.W);
                }
            }
            og.j(this.U, this.c.getPageContext());
        }
    }

    public void p3() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048759, this) == null) || (pbFragment = this.c) == null || pbFragment.getBaseFragmentActivity() == null) {
            return;
        }
        li.x(this.c.getPageContext().getPageActivity(), this.c.getBaseFragmentActivity().getCurrentFocus());
    }

    public void q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048760, this) == null) {
            dq4 dq4Var = this.S;
            if (dq4Var != null) {
                dq4Var.dismiss();
            }
            Dialog dialog = this.T;
            if (dialog != null) {
                og.b(dialog, this.c.getPageContext());
            }
            Dialog dialog2 = this.U;
            if (dialog2 != null) {
                og.b(dialog2, this.c.getPageContext());
            }
            mq4 mq4Var = this.Q;
            if (mq4Var != null) {
                mq4Var.dismiss();
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
        lu7 lu7Var = this.t1;
        if (lu7Var != null) {
            lu7Var.m();
        }
    }

    public void q2(int i3, String str, int i4, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048762, this, new Object[]{Integer.valueOf(i3), str, Integer.valueOf(i4), Boolean.valueOf(z2)}) == null) {
            r2(i3, str, i4, z2, null);
        }
    }

    public void q3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048763, this) == null) {
            this.I.z();
            this.I.Q();
        }
    }

    public void r0() {
        gu7 gu7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048764, this) == null) || (gu7Var = this.r) == null) {
            return;
        }
        gu7Var.b();
    }

    public void r1() {
        jv7 jv7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048765, this) == null) || (jv7Var = this.h) == null) {
            return;
        }
        jv7Var.q();
    }

    public void r2(int i3, String str, int i4, boolean z2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048766, this, new Object[]{Integer.valueOf(i3), str, Integer.valueOf(i4), Boolean.valueOf(z2), str2}) == null) {
            s2(i3, str, i4, z2, str2, false);
        }
    }

    public void r3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048767, this, z2) == null) {
            this.u.A(z2);
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
        at4 at4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048769, this) == null) || (at4Var = this.J0) == null) {
            return;
        }
        at4Var.h(false);
    }

    public void s2(int i3, String str, int i4, boolean z2, String str2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048770, this, new Object[]{Integer.valueOf(i3), str, Integer.valueOf(i4), Boolean.valueOf(z2), str2, Boolean.valueOf(z3)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(R.id.obfuscated_res_0x7f091e56, str);
            sparseArray.put(R.id.obfuscated_res_0x7f091e58, Integer.valueOf(i3));
            sparseArray.put(R.id.obfuscated_res_0x7f091e73, Integer.valueOf(i4));
            sparseArray.put(R.id.obfuscated_res_0x7f091e57, Boolean.valueOf(z2));
            sparseArray.put(i2, Integer.valueOf(j2));
            int i5 = (i4 != 1002 || z2) ? R.string.obfuscated_res_0x7f0f0499 : R.string.obfuscated_res_0x7f0f0fcd;
            int i6 = R.string.obfuscated_res_0x7f0f0436;
            if (i3 == 0) {
                if (i4 != 1002 || z2) {
                    i6 = R.string.obfuscated_res_0x7f0f049d;
                    i5 = R.string.obfuscated_res_0x7f0f049e;
                } else {
                    i5 = R.string.obfuscated_res_0x7f0f0fd1;
                }
            }
            this.S = new dq4(this.c.getActivity());
            if (StringUtils.isNull(str2)) {
                this.S.setMessageId(i5);
            } else {
                this.S.setOnlyMessageShowCenter(false);
                this.S.setMessage(str2);
            }
            this.S.setYesButtonTag(sparseArray);
            this.S.setPositiveButton(R.string.obfuscated_res_0x7f0f04ea, this.c);
            this.S.setNegativeButton(R.string.obfuscated_res_0x7f0f04e5, new r(this));
            this.S.setCancelable(true);
            this.S.create(this.c.getPageContext());
            if (z3) {
                F3(sparseArray, i6, i5);
            } else if (z2) {
                F3(sparseArray, i6, i5);
            } else if (v3()) {
                nh5 nh5Var = new nh5(this.c.v().P1().l().getDeletedReasonInfo().is_grays_cale_forum.intValue(), this.c.v().P1().l().getDeletedReasonInfo().is_boomgrow.intValue(), this.c.v().P1().o().has_forum_rule.intValue());
                nh5Var.i(this.c.v().P1().l().getId(), this.c.v().P1().l().getName());
                nh5Var.h(this.c.v().P1().l().getImage_url());
                nh5Var.j(this.c.v().P1().l().getUser_level());
                M3(sparseArray, i3, nh5Var, this.c.v().P1().U(), false);
            } else {
                U3(this.S, i3);
            }
        }
    }

    public void s3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048771, this, str) == null) {
            this.v0.performClick();
            if (StringUtils.isNull(str) || this.c.V4() == null || this.c.V4().v() == null || this.c.V4().v().i() == null) {
                return;
            }
            EditText i3 = this.c.V4().v().i();
            i3.setText(str);
            i3.setSelection(str.length());
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

    public void t2(int i3, String str, int i4, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048774, this, new Object[]{Integer.valueOf(i3), str, Integer.valueOf(i4), Boolean.valueOf(z2)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(R.id.obfuscated_res_0x7f091e56, str);
            sparseArray.put(R.id.obfuscated_res_0x7f091e58, Integer.valueOf(i3));
            sparseArray.put(R.id.obfuscated_res_0x7f091e73, Integer.valueOf(i4));
            sparseArray.put(R.id.obfuscated_res_0x7f091e57, Boolean.valueOf(z2));
            sparseArray.put(i2, Integer.valueOf(j2));
            if (z2) {
                A3(sparseArray);
            } else {
                B3(i3, sparseArray);
            }
        }
    }

    public void t3(int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048775, this, i3) == null) {
            this.l.setSelection(i3);
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

    public void u2(SparseArray<Object> sparseArray, boolean z2) {
        kq4 kq4Var;
        kq4 kq4Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048778, this, sparseArray, z2) == null) {
            oq4 oq4Var = new oq4(this.c.getContext());
            oq4Var.q(this.c.getString(R.string.obfuscated_res_0x7f0f02db));
            oq4Var.n(new q(this, z2));
            ArrayList arrayList = new ArrayList();
            int intValue = sparseArray.get(R.id.obfuscated_res_0x7f091e50) instanceof Integer ? ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091e50)).intValue() : -1;
            if (!"".equals(sparseArray.get(R.id.obfuscated_res_0x7f091e56)) && intValue != 2) {
                if ((sparseArray.get(R.id.obfuscated_res_0x7f091e58) instanceof Integer ? ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091e58)).intValue() : -1) == 0) {
                    kq4Var2 = new kq4(10, this.c.getString(R.string.obfuscated_res_0x7f0f04af), oq4Var);
                } else {
                    kq4Var2 = new kq4(10, this.c.getString(R.string.obfuscated_res_0x7f0f04a4), oq4Var);
                }
                SparseArray sparseArray2 = new SparseArray();
                sparseArray2.put(R.id.obfuscated_res_0x7f091e56, sparseArray.get(R.id.obfuscated_res_0x7f091e56));
                sparseArray2.put(R.id.obfuscated_res_0x7f091e58, sparseArray.get(R.id.obfuscated_res_0x7f091e58));
                sparseArray2.put(R.id.obfuscated_res_0x7f091e57, sparseArray.get(R.id.obfuscated_res_0x7f091e57));
                sparseArray2.put(R.id.obfuscated_res_0x7f091e73, sparseArray.get(R.id.obfuscated_res_0x7f091e73));
                kq4Var2.d.setTag(sparseArray2);
                arrayList.add(kq4Var2);
            }
            if ((!"".equals(sparseArray.get(R.id.obfuscated_res_0x7f091e61)) || !"".equals(sparseArray.get(R.id.obfuscated_res_0x7f091e62))) && !S1()) {
                SparseArray sparseArray3 = new SparseArray();
                sparseArray3.put(R.id.obfuscated_res_0x7f091e61, sparseArray.get(R.id.obfuscated_res_0x7f091e61));
                sparseArray3.put(R.id.obfuscated_res_0x7f091e62, sparseArray.get(R.id.obfuscated_res_0x7f091e62));
                sparseArray3.put(R.id.obfuscated_res_0x7f091e63, sparseArray.get(R.id.obfuscated_res_0x7f091e63));
                sparseArray3.put(R.id.obfuscated_res_0x7f091e73, sparseArray.get(R.id.obfuscated_res_0x7f091e73));
                sparseArray3.put(R.id.obfuscated_res_0x7f091e64, sparseArray.get(R.id.obfuscated_res_0x7f091e64));
                kq4 kq4Var3 = new kq4(11, this.c.getString(R.string.obfuscated_res_0x7f0f064c), oq4Var);
                kq4Var3.d.setTag(sparseArray3);
                arrayList.add(kq4Var3);
            }
            if ((sparseArray.get(R.id.obfuscated_res_0x7f091eaa) instanceof Boolean) && ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091eaa)).booleanValue()) {
                SparseArray sparseArray4 = new SparseArray();
                sparseArray4.put(R.id.obfuscated_res_0x7f091e6b, sparseArray.get(R.id.obfuscated_res_0x7f091e6b));
                sparseArray4.put(R.id.obfuscated_res_0x7f091ea6, sparseArray.get(R.id.obfuscated_res_0x7f091ea6));
                sparseArray4.put(R.id.obfuscated_res_0x7f091ea7, sparseArray.get(R.id.obfuscated_res_0x7f091ea7));
                sparseArray4.put(R.id.obfuscated_res_0x7f091ea5, sparseArray.get(R.id.obfuscated_res_0x7f091ea5));
                sparseArray4.put(R.id.obfuscated_res_0x7f091ea8, sparseArray.get(R.id.obfuscated_res_0x7f091ea8));
                sparseArray4.put(R.id.obfuscated_res_0x7f091ea9, sparseArray.get(R.id.obfuscated_res_0x7f091ea9));
                sparseArray4.put(R.id.obfuscated_res_0x7f091ea4, sparseArray.get(R.id.obfuscated_res_0x7f091ea4));
                if (z2) {
                    kq4Var = new kq4(12, this.c.getString(R.string.obfuscated_res_0x7f0f14a3), oq4Var);
                } else {
                    kq4Var = new kq4(12, this.c.getString(R.string.obfuscated_res_0x7f0f0b2b), oq4Var);
                }
                kq4Var.d.setTag(sparseArray4);
                arrayList.add(kq4Var);
            }
            ev7.e(arrayList);
            if (UbsABTestHelper.isPBPlanA()) {
                oq4Var.k(arrayList, false);
            } else {
                oq4Var.k(arrayList, true);
            }
            mq4 mq4Var = new mq4(this.c.getPageContext(), oq4Var);
            this.Q = mq4Var;
            mq4Var.m();
        }
    }

    public void u3(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048779, this, list) == null) {
            this.s1 = list;
            lu7 lu7Var = this.t1;
            if (lu7Var != null) {
                lu7Var.q(list);
            }
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

    public void v2(View view2) {
        SparseArray<Object> sparseArray;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048782, this, view2) == null) || (sparseArray = (SparseArray) view2.getTag()) == null) {
            return;
        }
        u2(sparseArray, false);
    }

    public final boolean v3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048783, this)) == null) {
            PbFragment pbFragment = this.c;
            return (pbFragment == null || pbFragment.v().P1().l().getDeletedReasonInfo() == null || 1 != this.c.v().P1().l().getDeletedReasonInfo().is_grays_cale_forum.intValue()) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public void w0(int i3, boolean z2, String str, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048784, this, new Object[]{Integer.valueOf(i3), Boolean.valueOf(z2), str, Boolean.valueOf(z3)}) == null) {
            this.c.hideProgressBar();
            if (z2 && z3) {
                PbFragment pbFragment = this.c;
                pbFragment.showToast(pbFragment.getPageContext().getString(R.string.obfuscated_res_0x7f0f1229));
            } else if (z3) {
                if (ki.isEmpty(str)) {
                    str = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0c33);
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

    public void w2(@NonNull View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048786, this, view2) == null) || this.y0.getData() == null || !this.y0.getData().hasAgree || this.c.getActivity() == null) {
            return;
        }
        oo7 oo7Var = new oo7(this.c.getContext());
        int f2 = li.f(TbadkCoreApplication.getInst(), R.dimen.tbds774);
        int f3 = li.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f070724);
        int[] iArr = new int[2];
        view2.getLocationInWindow(iArr);
        int i3 = iArr[0];
        int i4 = iArr[1];
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(f3, f2);
        layoutParams.leftMargin = ((view2.getWidth() / 2) + i3) - ((int) ((f3 * 1) / 1.45d));
        layoutParams.topMargin = li.f(TbadkCoreApplication.getInst(), R.dimen.M_H_X006);
        oo7Var.j(f2);
        oo7Var.i(layoutParams);
        oo7Var.h(false);
        oo7Var.l(true, this.c.getActivity().findViewById(16908290), 0, i4, this.L0.Q(), this.L0.m());
    }

    public final void w3() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048787, this) == null) || (pbFragment = this.c) == null || pbFragment.getActivity() == null) {
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
            int f2 = li.f(this.c.getActivity(), R.dimen.tbds166);
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
            this.x = new au7(pbFragment.getContext());
        }
    }

    public void x2(ry4 ry4Var, int i3) {
        FallingView fallingView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048790, this, ry4Var, i3) == null) || (fallingView = this.K1) == null) {
            return;
        }
        fallingView.D(ry4Var, this.c.getPageContext(), i3, false);
    }

    public void x3(View view2) {
        AbsPbActivity w2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048791, this, view2) == null) || (w2 = this.c.w()) == null || w2.isFinishing()) {
            return;
        }
        zx5 zx5Var = new zx5(this.c.getPageContext(), view2);
        zx5Var.g0(R.drawable.obfuscated_res_0x7f0802ea);
        zx5Var.O(48);
        zx5Var.U(true);
        zx5Var.L(2);
        zx5Var.h0(true);
        zx5Var.k0(li.f(w2, R.dimen.tbds21));
        zx5Var.j0(li.f(w2, R.dimen.tbds128));
        zx5Var.d0(w2.getResources().getDimensionPixelSize(R.dimen.tbds20));
        zx5Var.a0(w2.getResources().getDimensionPixelSize(R.dimen.tbds38));
        zx5Var.N(3000);
        zx5Var.n0(w2.getString(R.string.obfuscated_res_0x7f0f0dc9), "pb_bottom_agree_tip_guide_key", true);
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
            this.t = new du7(this.c, this.i0);
        }
    }

    public final void y2(PbReplyTitleViewHolder pbReplyTitleViewHolder, boolean z2) {
        int measuredHeight;
        int i3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048794, this, pbReplyTitleViewHolder, z2) == null) || this.l1 || this.U0 == null || this.h.p() == null) {
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
        int H = this.C.H();
        if (H > 0 && (pbReplyTitleViewHolder == null || pbReplyTitleViewHolder.b().getParent() == null)) {
            if (H > this.l.getFirstVisiblePosition() - this.l.getHeaderViewsCount()) {
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
            jv7 jv7Var = this.h;
            if (jv7Var == null || (view2 = jv7Var.d) == null) {
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
                return this.c.getString(R.string.obfuscated_res_0x7f0f0db5);
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

    public final void z1(kp7 kp7Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048797, this, kp7Var) == null) && kp7Var != null && kp7Var.O() != null && kp7Var.O().isInterviewLive() && this.R0 == null) {
            PbInterviewStatusView pbInterviewStatusView = (PbInterviewStatusView) this.Q0.inflate();
            this.R0 = pbInterviewStatusView;
            pbInterviewStatusView.setOnClickListener(this.N);
            this.R0.setCallback(this.c.L4());
            this.R0.setData(this.c, kp7Var);
        }
    }

    public final void z2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048798, this) == null) {
            this.u.w(this.L0, this.M0, this.m1, this.l1);
        }
    }

    public void z3() {
        gu7 gu7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048799, this) == null) || (gu7Var = this.r) == null) {
            return;
        }
        gu7Var.u(this.l);
    }
}

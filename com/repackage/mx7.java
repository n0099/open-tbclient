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
import com.repackage.av4;
import com.repackage.bl5;
import com.repackage.eu7;
import com.repackage.fs4;
import com.repackage.hs7;
import com.repackage.hx7;
import com.repackage.jw7;
import com.repackage.mk8;
import com.repackage.ur4;
import com.repackage.wr4;
import com.repackage.yk5;
import com.repackage.zx7;
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
public class mx7 {
    public static /* synthetic */ Interceptable $ic;
    public static final int i2;
    public static int j2;
    public static int k2;
    public static int l2;
    public static int m2;
    public static int n2;
    public static int o2;
    public static final int p2;
    public static int q2;
    public static mk8.f r2;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout A;
    public AgreeView A0;
    public NavigationBarCoverTip A1;
    public TextView B;
    public ImageView B0;
    public yk5 B1;
    public TextView C;
    public ImageView C0;
    public bl5 C1;
    public ObservedChangeRelativeLayout D;
    public HeadImageView D0;
    public String D1;
    public uv7 E;
    public View E0;
    public PermissionJudgePolicy E1;
    public ur4 F;
    public w18 F0;
    public long F1;
    public wr4 G;
    public TextView G0;
    public boolean G1;
    public View H;
    public TextView H0;
    public int H1;
    public EditText I;
    public TextView I0;
    public int I1;
    public x18 J;
    public boolean J0;
    public boolean J1;
    public PbListView K;
    public int K0;
    public v18 K1;
    public t18 L;
    public uu4 L0;
    public MaskView L1;
    public View M;
    public boolean M0;
    public final FallingView M1;
    public View N;
    public et7 N0;
    public RightFloatLayerView N1;
    public View O;
    public PostData O0;
    public final FrameLayout O1;
    public View.OnClickListener P;
    public int P0;
    public boolean P1;
    public TbRichTextView.y Q;
    public int Q0;
    public String Q1;
    public NoNetworkView.b R;
    public boolean R0;
    public CustomMessageListener R1;
    public ds4 S;
    public ViewStub S0;
    public View.OnClickListener S1;
    public View.OnClickListener T;
    public PbInterviewStatusView T0;
    public CustomMessageListener T1;
    public ur4 U;
    public FrameLayout U0;
    public Handler U1;
    public Dialog V;
    public TextView V0;
    public Runnable V1;
    public Dialog W;
    public View W0;
    public CustomMessageListener W1;
    public View X;
    public View X0;
    public PbFragment.h3 X1;
    public LinearLayout Y;
    public View Y0;
    public boolean Y1;
    public CompoundButton.OnCheckedChangeListener Z;
    public PbReplyTitleViewHolder Z0;
    public View.OnClickListener Z1;
    public final ViewTreeObserver.OnGlobalLayoutListener a;
    public TextView a0;
    public View a1;
    public boolean a2;
    public int b;
    public TextView b0;
    public int b1;
    public String b2;
    public PbFragment c;
    public String c0;
    public boolean c1;
    public av4.g c2;
    public RelativeLayout d;
    public ds4 d0;
    public w0 d1;
    public View.OnClickListener d2;
    public View e;
    public ds4 e0;
    public PbEmotionBar e1;
    public final List<TbImageView> e2;
    public int f;
    public yr4 f0;
    public int f1;
    public int f2;
    public final Handler g;
    public boolean g0;
    public int g1;
    public boolean g2;
    public final mz7 h;
    public boolean h0;
    public Runnable h1;
    public boolean h2;
    public lz7 i;
    public String i0;
    public PbFakeFloorModel i1;
    public ViewStub j;
    public String j0;
    public gw7 j1;
    public ViewStub k;
    public gu7 k0;
    public ex7 k1;
    public PbLandscapeListView l;
    public ScrollView l0;
    public boolean l1;
    public NoNetworkView m;
    public EditorTools m0;
    public int m1;
    public List<CustomBlueCheckRadioButton> n;
    public boolean n0;
    public boolean n1;
    public PbThreadPostView o;
    public View o0;
    public boolean o1;
    public kw7 p;
    public View p0;
    public boolean p1;
    public jw7 q;
    public EjectionAnimationView q0;
    public int q1;
    public ix7 r;
    public Button r0;
    public PbTopTipView r1;
    public hx7 s;
    public View s0;
    public PopupWindow s1;
    public fy7 t;
    public View t0;
    public TextView t1;
    public ay7 u;
    public LinearLayout u0;
    public List<String> u1;
    public cy7 v;
    public HeadImageView v0;
    public ky7 v1;
    public ey7 w;
    public ImageView w0;
    public ev7 w1;
    public by7 x;
    public TextView x0;
    public PbLandscapeListView.c x1;
    public dy7 y;
    public WaterRippleView y0;
    public boolean y1;
    public zx7 z;
    public ImageView z0;
    public ww7 z1;

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
        public final /* synthetic */ mx7 g;

        /* renamed from: com.repackage.mx7$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class RunnableC0531a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public RunnableC0531a(a aVar) {
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
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.g.a1 == null || this.a.g.a1.getLayoutParams() == null) {
                    return;
                }
                ViewGroup.LayoutParams layoutParams = this.a.g.a1.getLayoutParams();
                layoutParams.height = this.a.g.g1;
                this.a.g.a1.setLayoutParams(layoutParams);
            }
        }

        public a(mx7 mx7Var, int i, PbReplyTitleViewHolder pbReplyTitleViewHolder, boolean z, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mx7Var, Integer.valueOf(i), pbReplyTitleViewHolder, Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = mx7Var;
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
                    if (this.g.a1 == null || (layoutParams = this.g.a1.getLayoutParams()) == null) {
                        return;
                    }
                    if (i4 == 0 || i4 > this.g.d.getMeasuredHeight() || f1 >= this.g.d.getMeasuredHeight()) {
                        layoutParams.height = this.g.g1;
                    } else {
                        if (layoutParams != null) {
                            int i5 = layoutParams.height;
                            if (i5 + i4 > 0 && i5 + i4 <= this.g.d.getMeasuredHeight()) {
                                layoutParams.height += i4;
                                this.g.l.setSelectionFromTop(this.e, this.f);
                            }
                        }
                        layoutParams.height = this.g.g1;
                    }
                    this.g.a1.setLayoutParams(layoutParams);
                    rg.a().post(new RunnableC0531a(this));
                }
                this.g.l.setOnLayoutListener(null);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a0 implements CompoundButton.OnCheckedChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mx7 a;

        public a0(mx7 mx7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mx7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mx7Var;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, compoundButton, z) == null) && z) {
                this.a.c0 = (String) compoundButton.getTag();
                if (this.a.n != null) {
                    for (CustomBlueCheckRadioButton customBlueCheckRadioButton : this.a.n) {
                        String str = (String) customBlueCheckRadioButton.getTag();
                        if (str != null && this.a.c0 != null && !str.equals(this.a.c0)) {
                            customBlueCheckRadioButton.setChecked(false);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements du7 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mx7 a;

        public b(mx7 mx7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mx7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mx7Var;
        }

        @Override // com.repackage.du7
        public /* synthetic */ void onStart() {
            cu7.a(this);
        }

        @Override // com.repackage.du7
        public void onStop() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.q0.setVisibility(8);
                FirstPraiseToast.getInstance().show();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mx7 a;

        public b0(mx7 mx7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mx7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mx7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (this.a.W instanceof Dialog)) {
                tg.b(this.a.W, this.a.c.getPageContext());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements AgreeView.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mx7 a;

        /* loaded from: classes6.dex */
        public class a implements e25 {
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

            @Override // com.repackage.e25
            public void a(List<Bitmap> list) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
                    this.a.a.q0.setVisibility(0);
                    this.a.a.q0.setBitmaps(list);
                    Rect rect = new Rect();
                    this.a.a.A0.getImgAgree().getGlobalVisibleRect(rect);
                    this.a.a.q0.setAnchorPosition((rect.right + rect.left) / 2, (rect.bottom + rect.top) / 2);
                    this.a.a.q0.k();
                }
            }
        }

        public c(mx7 mx7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mx7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mx7Var;
        }

        @Override // com.baidu.tbadk.core.view.AgreeView.i
        public void onLongPress() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.D3();
                g25.g().c(new a(this));
            }
        }

        @Override // com.baidu.tbadk.core.view.AgreeView.i
        public void onRelease() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.O2();
                this.a.q0.l();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c0 implements fs4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wr4.c a;
        public final /* synthetic */ mx7 b;

        public c0(mx7 mx7Var, wr4.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mx7Var, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = mx7Var;
            this.a = cVar;
        }

        @Override // com.repackage.fs4.e
        public void i0(fs4 fs4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, fs4Var, i, view2) == null) {
                this.b.e0.dismiss();
                this.a.a(null, i, view2);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mx7 a;

        public d(mx7 mx7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mx7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mx7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.A0 == null || this.a.A0.getData() == null) {
                return;
            }
            mx7 mx7Var = this.a;
            mx7Var.I2(mx7Var.A0.getData(), this.a.A0.getData().agreeNum);
            if (this.a.A0.F()) {
                return;
            }
            mx7 mx7Var2 = this.a;
            mx7Var2.B2(mx7Var2.A0);
        }
    }

    /* loaded from: classes6.dex */
    public class d0 implements fs4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wr4.c a;
        public final /* synthetic */ mx7 b;

        public d0(mx7 mx7Var, wr4.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mx7Var, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = mx7Var;
            this.a = cVar;
        }

        @Override // com.repackage.fs4.e
        public void i0(fs4 fs4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, fs4Var, i, view2) == null) {
                this.b.e0.dismiss();
                this.a.a(null, i, view2);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mx7 a;

        public e(mx7 mx7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mx7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mx7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.E0.getVisibility() == 0) {
                    if (this.a.c != null && this.a.c.r1()) {
                        return;
                    }
                    ru4.k().u("pb_share_red_dot_shown", true);
                    this.a.E0.setVisibility(8);
                }
                this.a.P.onClick(view2);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mx7 a;

        public e0(mx7 mx7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mx7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mx7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (!(view2 instanceof HeadImageView) || this.a.N0 == null || this.a.N0.O() == null || this.a.N0.O().getAuthor() == null || this.a.N0.O().getAuthor().getAlaInfo() == null || this.a.N0.O().getAuthor().getAlaInfo().live_status != 1) {
                    if (this.a.n1) {
                        TiebaStatic.log(new StatisticItem("c11923").param("obj_id", 2));
                    }
                    if (!this.a.n1 && this.a.N0 != null && this.a.N0.O() != null && this.a.N0.O().getAuthor() != null && this.a.N0.O().getAuthor().isBigV()) {
                        TiebaStatic.log(new StatisticItem("c12151").param("obj_locate", 1));
                    }
                    if (this.a.c.P() != null) {
                        this.a.c.P().d.b.onClick(view2);
                        return;
                    }
                    return;
                }
                StatisticItem statisticItem = new StatisticItem("c11851");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                TiebaStatic.log(statisticItem);
                StatisticItem statisticItem2 = new StatisticItem("c13715");
                statisticItem2.param("fid", this.a.N0.m());
                statisticItem2.param("fname", this.a.N0.n());
                statisticItem2.param("obj_param1", this.a.N0.O().getAuthor().getAlaInfo().user_info != null ? this.a.N0.O().getAuthor().getAlaInfo().user_info.user_id : 0L);
                statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem2.param("tid", this.a.N0.Q());
                statisticItem2.param(TiebaStatic.Params.OBJ_PARAM2, 1);
                statisticItem2.param(TiebaStatic.Params.OBJ_PARAM4, YYLiveUtil.calculateLiveType(this.a.N0.O().getAuthor().getAlaInfo()));
                if (this.a.N0.O().getAuthor().getAlaInfo().mYyExtData != null) {
                    statisticItem2.param(TiebaStatic.Params.OBJ_PARAM3, TiebaStatic.YYValues.YY_LIVE);
                    TiebaStaticHelper.addYYParam(statisticItem2, this.a.N0.O().getAuthor().getAlaInfo().mYyExtData);
                }
                TiebaStatic.log(statisticItem2);
                if (this.a.N0.O().getAuthor().getAlaInfo().isLegalYYLiveData()) {
                    YYLiveUtil.jumpYYLiveRoom(this.a.c.getPageContext(), this.a.N0.O().getAuthor().getAlaInfo(), YYLiveUtil.SOURCE_PB_LIVE_HEAD);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mx7 a;

        public f(mx7 mx7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mx7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mx7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            SparseArray<Object> sparseArray;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || (sparseArray = (SparseArray) view2.getTag()) == null) {
                return;
            }
            boolean booleanValue = sparseArray.get(R.id.obfuscated_res_0x7f092030) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092030)).booleanValue() : false;
            boolean booleanValue2 = sparseArray.get(R.id.obfuscated_res_0x7f092044) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092044)).booleanValue() : false;
            boolean booleanValue3 = sparseArray.get(R.id.obfuscated_res_0x7f09202e) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f09202e)).booleanValue() : false;
            if (booleanValue) {
                if (booleanValue2) {
                    sparseArray.put(R.id.obfuscated_res_0x7f091ffb, 1);
                    this.a.c.e5(sparseArray);
                    return;
                }
                this.a.A2(view2);
            } else if (booleanValue2) {
                sparseArray.put(R.id.obfuscated_res_0x7f091ffb, 0);
                sparseArray.put(R.id.obfuscated_res_0x7f091fe4, 1);
                this.a.c.e5(sparseArray);
            } else if (booleanValue3) {
                this.a.v2(((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091fec)).intValue(), (String) sparseArray.get(R.id.obfuscated_res_0x7f091fea), ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f092008)).intValue(), ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091feb)).booleanValue());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f0 implements zx7.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mx7 a;

        public f0(mx7 mx7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mx7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mx7Var;
        }

        @Override // com.repackage.zx7.a
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    this.a.z.a(this.a.l);
                } else {
                    this.a.z.d(this.a.l);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mx7 a;

        public g(mx7 mx7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mx7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mx7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.S2();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qx4 a;
        public final /* synthetic */ mx7 b;

        public g0(mx7 mx7Var, qx4 qx4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mx7Var, qx4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = mx7Var;
            this.a = qx4Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a == null || this.b.N0 == null || this.b.N1 == null) {
                return;
            }
            this.b.N1.g(this.a);
            this.b.N1.setAutoCompleteShown(false);
        }
    }

    /* loaded from: classes6.dex */
    public class h implements PbFakeFloorModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mx7 a;

        public h(mx7 mx7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mx7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mx7Var;
        }

        @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.b
        public void a(PostData postData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, postData) == null) {
                this.a.i1.Q(postData);
                this.a.E.a0();
                this.a.j1.c();
                this.a.m0.q();
                this.a.J3(false);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mx7 a;

        public h0(mx7 mx7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mx7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mx7Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            mx7 mx7Var;
            mz7 mz7Var;
            LinearLayout linearLayout;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.E == null || (mz7Var = (mx7Var = this.a).h) == null || mz7Var.i == null || mx7Var.N0 == null || this.a.N0.O() == null || this.a.N0.O().isVideoThreadType() || this.a.Q1() || this.a.N0.l() == null || pi.isEmpty(this.a.N0.l().getName())) {
                return;
            }
            if ((this.a.E.J() == null || !this.a.E.J().isShown()) && (linearLayout = this.a.h.i) != null) {
                linearLayout.setVisibility(0);
                if (this.a.c == null || this.a.c.K() == null) {
                    return;
                }
                StatisticItem statisticItem = new StatisticItem("c13400");
                statisticItem.param("tid", this.a.c.K().m2());
                statisticItem.param("fid", this.a.c.K().getForumId());
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i implements FallingView.n {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mx7 a;

        public i(mx7 mx7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mx7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mx7Var;
        }

        @Override // com.baidu.tieba.pb.view.FallingView.n
        public void onAnimationEnd() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.d4();
            }
        }

        @Override // com.baidu.tieba.pb.view.FallingView.n
        public void onAnimationStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.M1.setTag(Boolean.FALSE);
                if (this.a.N1 == null) {
                    return;
                }
                this.a.N1.setAutoCompleteShown(false);
                if (this.a.N1.getVisibility() == 0) {
                    this.a.N1.setTag(this.a.M1);
                    this.a.N1.c();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ mx7 b;

        public i0(mx7 mx7Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mx7Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = mx7Var;
            this.a = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (qi.D()) {
                    UrlManager.getInstance().dealOneLink(this.b.c.getPageContext(), new String[]{this.a});
                    this.b.c.finish();
                    return;
                }
                this.b.c.showToast(R.string.obfuscated_res_0x7f0f0c3d);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mx7 a;

        public j(mx7 mx7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mx7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mx7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.E0.getVisibility() == 0) {
                    ru4.k().u("pb_share_red_dot_shown", true);
                    this.a.E0.setVisibility(8);
                }
                this.a.P.onClick(this.a.C0);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Parcelable a;
        public final /* synthetic */ ArrayList b;
        public final /* synthetic */ et7 c;
        public final /* synthetic */ mx7 d;

        public j0(mx7 mx7Var, Parcelable parcelable, ArrayList arrayList, et7 et7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mx7Var, parcelable, arrayList, et7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = mx7Var;
            this.a = parcelable;
            this.b = arrayList;
            this.c = et7Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.d.l.onRestoreInstanceState(this.a);
                if (ListUtils.getCount(this.b) <= 1 || this.c.y().b() <= 0) {
                    return;
                }
                this.d.K.f();
                this.d.K.C(this.d.c.getString(R.string.obfuscated_res_0x7f0f0dd8));
                this.d.K.x();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class k implements hs7.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mx7 a;

        public k(mx7 mx7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mx7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mx7Var;
        }

        @Override // com.repackage.hs7.d
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.A0.Q();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class k0 implements PbLandscapeListView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mx7 a;

        public k0(mx7 mx7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mx7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mx7Var;
        }

        @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.c
        public void a(int i, int i2, float f, float f2, float f3, float f4) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)}) == null) && this.a.c != null && this.a.c.isAdded()) {
                if (i < 0 && f > this.a.q1) {
                    this.a.m0();
                    this.a.l2();
                }
                this.a.v0();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class l extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mx7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(mx7 mx7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mx7Var, Integer.valueOf(i)};
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
            this.a = mx7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2005016 || this.a.E == null) {
                return;
            }
            this.a.E.a0();
        }
    }

    /* loaded from: classes6.dex */
    public class l0 implements ur4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mx7 a;

        public l0(mx7 mx7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mx7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mx7Var;
        }

        @Override // com.repackage.ur4.e
        public void onClick(ur4 ur4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ur4Var) == null) {
                this.a.m0();
                ur4Var.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class m implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mx7 a;

        public m(mx7 mx7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mx7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mx7Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.A == null) {
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
        public final /* synthetic */ mx7 a;

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

        public m0(mx7 mx7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mx7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mx7Var;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                if (this.a.h1 == null) {
                    this.a.h1 = new a(this);
                }
                rg.a().postDelayed(this.a.h1, 150L);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class n extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mx7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n(mx7 mx7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mx7Var, Integer.valueOf(i)};
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
            this.a = mx7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            this.a.J0 = false;
        }
    }

    /* loaded from: classes6.dex */
    public class n0 implements ur4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public n0(mx7 mx7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mx7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.ur4.e
        public void onClick(ur4 ur4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ur4Var) == null) {
                ur4Var.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class o implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mx7 a;

        public o(mx7 mx7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mx7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mx7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.S2();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class o0 implements ur4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public o0(mx7 mx7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mx7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.ur4.e
        public void onClick(ur4 ur4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ur4Var) == null) {
                ur4Var.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class p implements i25 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mx7 a;

        public p(mx7 mx7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mx7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mx7Var;
        }

        @Override // com.repackage.i25
        public void A(h25 h25Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, h25Var) == null) {
                Object obj = h25Var.c;
                if ((obj instanceof gy4) && EmotionGroupType.isSendAsPic(((gy4) obj).getType())) {
                    if (this.a.E1 == null) {
                        this.a.E1 = new PermissionJudgePolicy();
                    }
                    this.a.E1.clearRequestPermissionList();
                    this.a.E1.appendRequestPermission(this.a.c.getBaseFragmentActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (this.a.E1.startRequestPermission(this.a.c.getBaseFragmentActivity())) {
                        return;
                    }
                    gy4 gy4Var = (gy4) h25Var.c;
                    this.a.c.O5().h(gy4Var);
                    if (gy4Var.i()) {
                        this.a.c.O5().M(null, null);
                    } else {
                        this.a.c.O5().z(false, null);
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
        public final /* synthetic */ mx7 e;

        public p0(mx7 mx7Var, int i, int i2, int i3, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mx7Var, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = mx7Var;
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
                    this.e.s1.showAsDropDown(this.e.t0, this.d.getLeft(), -this.e.t0.getHeight());
                } else {
                    this.e.s1.showAsDropDown(this.d);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class q implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mx7 a;

        public q(mx7 mx7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mx7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mx7Var;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || this.a.c.K0 == null || this.a.c.K0.e() == null) {
                return;
            }
            if (!this.a.c.K0.e().e()) {
                this.a.c.K0.a(false);
            }
            this.a.c.K0.e().l(false);
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
            if (!(interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) == null) || this.a.m0 == null || this.a.m0.getVisibility() != 0 || charSequence == null || charSequence.length() < (i4 = i3 + i)) {
                return;
            }
            String substring = charSequence.toString().substring(i, i4);
            if (TextUtils.isEmpty(substring)) {
                return;
            }
            if (this.a.v1 == null) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(11);
                layoutParams.addRule(2, this.a.m0.getId());
                mx7 mx7Var = this.a;
                mx7Var.v1 = new ky7(mx7Var.c.getPageContext(), this.a.d, layoutParams);
                if (!ListUtils.isEmpty(this.a.u1)) {
                    this.a.v1.q(this.a.u1);
                }
                this.a.v1.r(this.a.m0);
            }
            this.a.v1.p(substring);
        }
    }

    /* loaded from: classes6.dex */
    public class q0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qx4 a;
        public final /* synthetic */ mx7 b;

        public q0(mx7 mx7Var, qx4 qx4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mx7Var, qx4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = mx7Var;
            this.a = qx4Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921664));
                this.b.N1.setHomePbFloatLastCloseTime();
                this.b.v1();
                this.b.N1.u(this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class r implements fs4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ mx7 b;

        public r(mx7 mx7Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mx7Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = mx7Var;
            this.a = z;
        }

        @Override // com.repackage.fs4.e
        public void i0(fs4 fs4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, fs4Var, i, view2) == null) {
                this.b.S.dismiss();
                SparseArray<Object> sparseArray = (SparseArray) view2.getTag();
                if (sparseArray == null) {
                    return;
                }
                switch (i) {
                    case 10:
                        this.b.v2(((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091fec)).intValue(), (String) sparseArray.get(R.id.obfuscated_res_0x7f091fea), ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f092008)).intValue(), ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091feb)).booleanValue());
                        return;
                    case 11:
                        if (this.b.X1 != null) {
                            this.b.X1.a(new Object[]{sparseArray.get(R.id.obfuscated_res_0x7f092008), sparseArray.get(R.id.obfuscated_res_0x7f091ff5), sparseArray.get(R.id.obfuscated_res_0x7f091ff8), sparseArray.get(R.id.obfuscated_res_0x7f091ff6), sparseArray.get(R.id.obfuscated_res_0x7f091ff7)});
                            return;
                        }
                        return;
                    case 12:
                        this.b.c.b6(this.a, (String) sparseArray.get(R.id.obfuscated_res_0x7f092040), sparseArray);
                        return;
                    case 13:
                        this.b.u4(true);
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
        public final /* synthetic */ mx7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public r0(mx7 mx7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mx7Var, Integer.valueOf(i)};
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
            this.a = mx7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2921306) {
                this.a.Q1 = null;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class s implements ur4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public s(mx7 mx7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mx7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.ur4.e
        public void onClick(ur4 ur4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ur4Var) == null) {
                ur4Var.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class s0 implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;
        public final /* synthetic */ mx7 b;

        public s0(mx7 mx7Var, PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mx7Var, pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = mx7Var;
            this.a = pbFragment;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.b.J1 || this.a == null || this.b.c.K() == null || !this.b.c.K().D2()) {
                return;
            }
            this.b.J1 = true;
            this.a.b5(false);
        }
    }

    /* loaded from: classes6.dex */
    public class t implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlertDialog a;
        public final /* synthetic */ SparseArray b;
        public final /* synthetic */ mx7 c;

        public t(mx7 mx7Var, AlertDialog alertDialog, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mx7Var, alertDialog, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = mx7Var;
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
                if (!oi.A()) {
                    qi.M(this.c.c.P(), R.string.obfuscated_res_0x7f0f0c3d);
                } else {
                    this.c.c.m5(this.b, null);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class t0 implements eu7.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mx7 a;

        public t0(mx7 mx7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mx7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mx7Var;
        }

        @Override // com.repackage.eu7.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.c.e6();
            }
        }

        @Override // com.repackage.eu7.b
        public void b() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.a.l == null) {
                return;
            }
            if (this.a.t != null) {
                this.a.t.t();
            }
            this.a.l.setSelection(0);
        }
    }

    /* loaded from: classes6.dex */
    public class u implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlertDialog a;

        public u(mx7 mx7Var, AlertDialog alertDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mx7Var, alertDialog};
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
        public final /* synthetic */ k45 b;
        public final /* synthetic */ mx7 c;

        public u0(mx7 mx7Var, ReplyPrivacyCheckController replyPrivacyCheckController, k45 k45Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mx7Var, replyPrivacyCheckController, k45Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = mx7Var;
            this.a = replyPrivacyCheckController;
            this.b = k45Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a == null || this.c.c == null || this.c.c.v5() == null || this.a.checkPrivacyBeforeInvokeEditor(this.c.c.v5().replyPrivateFlag)) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 1).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                    if (DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.c.c.getActivity(), LoginDialogData.PB_BOTTOM_REPLY_RESULT_PAGE))) {
                        this.c.q4();
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
    public static class v implements mk8.f {
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

        @Override // com.repackage.mk8.f
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
        public final /* synthetic */ mx7 a;

        public v0(mx7 mx7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mx7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mx7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.p2();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class w implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlertDialog a;
        public final /* synthetic */ SparseArray b;
        public final /* synthetic */ mx7 c;

        public w(mx7 mx7Var, AlertDialog alertDialog, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mx7Var, alertDialog, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = mx7Var;
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
                if (!oi.A()) {
                    qi.M(this.c.c.P(), R.string.obfuscated_res_0x7f0f0c3d);
                } else {
                    this.c.c.m5(this.b, null);
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

        public x(mx7 mx7Var, AlertDialog alertDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mx7Var, alertDialog};
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
    public class y implements yk5.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ur4 a;
        public final /* synthetic */ mx7 b;

        public y(mx7 mx7Var, ur4 ur4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mx7Var, ur4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = mx7Var;
            this.a = ur4Var;
        }

        @Override // com.repackage.yk5.g
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                this.b.c.n5(this.a, jSONArray);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class z implements bl5.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SparseArray a;
        public final /* synthetic */ mx7 b;

        public z(mx7 mx7Var, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mx7Var, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = mx7Var;
            this.a = sparseArray;
        }

        @Override // com.repackage.bl5.h
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                this.b.c.m5(this.a, jSONArray);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755483835, "Lcom/repackage/mx7;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755483835, "Lcom/repackage/mx7;");
                return;
            }
        }
        i2 = UtilHelper.getLightStatusBarHeight();
        j2 = 3;
        k2 = 0;
        l2 = 3;
        m2 = 4;
        n2 = 5;
        o2 = 6;
        p2 = qi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds80);
        q2 = 1;
        r2 = new v();
    }

    public mx7(PbFragment pbFragment, View.OnClickListener onClickListener, gu7 gu7Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pbFragment, onClickListener, gu7Var};
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
        this.E = null;
        this.F = null;
        this.G = null;
        this.H = null;
        this.I = null;
        this.J = null;
        this.K = null;
        this.L = null;
        this.M = null;
        this.N = null;
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
        this.e0 = null;
        this.f0 = null;
        this.g0 = false;
        this.h0 = false;
        this.i0 = null;
        this.j0 = null;
        this.l0 = null;
        this.n0 = false;
        this.r0 = null;
        this.t0 = null;
        this.x0 = null;
        this.J0 = true;
        this.L0 = null;
        this.M0 = false;
        this.Q0 = 3;
        this.R0 = false;
        this.S0 = null;
        this.b1 = 0;
        this.c1 = true;
        this.d1 = new w0();
        this.f1 = 0;
        this.l1 = false;
        this.m1 = 0;
        this.n1 = false;
        this.o1 = false;
        this.p1 = false;
        this.q1 = 0;
        this.y1 = false;
        this.F1 = 0L;
        this.I1 = 0;
        this.R1 = new r0(this, 2921306);
        this.S1 = new j(this);
        this.T1 = new l(this, 2005016);
        this.U1 = new Handler();
        this.W1 = new n(this, 2004009);
        this.Y1 = true;
        this.Z1 = new e0(this);
        this.a2 = false;
        this.b2 = null;
        this.e2 = new ArrayList();
        this.g2 = false;
        this.F1 = System.currentTimeMillis();
        this.c = pbFragment;
        this.P = onClickListener;
        this.k0 = gu7Var;
        this.q1 = qi.k(pbFragment.getContext()) / 8;
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.c.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0628, (ViewGroup) null);
        this.d = relativeLayout;
        relativeLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.o0 = this.d.findViewById(R.id.obfuscated_res_0x7f0903ed);
        this.A1 = (NavigationBarCoverTip) this.d.findViewById(R.id.obfuscated_res_0x7f091820);
        this.e = this.d.findViewById(R.id.obfuscated_res_0x7f091f2b);
        this.O1 = (FrameLayout) this.d.findViewById(R.id.obfuscated_res_0x7f091bf2);
        this.D = (ObservedChangeRelativeLayout) this.d.findViewById(R.id.obfuscated_res_0x7f0921ee);
        this.m = (NoNetworkView) this.d.findViewById(R.id.obfuscated_res_0x7f09255e);
        this.l = (PbLandscapeListView) this.d.findViewById(R.id.obfuscated_res_0x7f09165c);
        this.U0 = (FrameLayout) this.d.findViewById(R.id.obfuscated_res_0x7f091c24);
        this.V0 = new TextView(this.c.getActivity());
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + qi.f(this.c.getActivity(), R.dimen.obfuscated_res_0x7f070306));
        this.l.x(this.V0, 0);
        this.l.setTextViewAdded(true);
        this.g1 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds134);
        this.a1 = new View(this.c.getPageContext().getPageActivity());
        if (qj5.a()) {
            this.a1.setLayoutParams(new AbsListView.LayoutParams(-1, 0));
        } else {
            this.a1.setLayoutParams(new AbsListView.LayoutParams(-1, this.g1));
        }
        this.a1.setVisibility(4);
        this.l.addFooterView(this.a1);
        this.l.setOnTouchListener(this.c.M2);
        this.a = new s0(this, pbFragment);
        this.l.getViewTreeObserver().addOnGlobalLayoutListener(this.a);
        this.h = new mz7(pbFragment, this.d);
        if (this.c.F5()) {
            ViewStub viewStub = (ViewStub) this.d.findViewById(R.id.obfuscated_res_0x7f09147f);
            this.j = viewStub;
            viewStub.setVisibility(0);
            lz7 lz7Var = new lz7(pbFragment);
            this.i = lz7Var;
            lz7Var.c();
            this.h.a.setVisibility(8);
            layoutParams.height = qi.f(this.c.getActivity(), R.dimen.obfuscated_res_0x7f07023c);
        }
        this.V0.setLayoutParams(layoutParams);
        this.h.p().setOnTouchListener(new eu7(new t0(this)));
        this.s0 = this.d.findViewById(R.id.obfuscated_res_0x7f092544);
        this.t0 = this.d.findViewById(R.id.obfuscated_res_0x7f0917bf);
        qi.f(TbadkCoreApplication.getInst(), R.dimen.tbds120);
        this.K0 = qi.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f070284);
        this.w0 = (ImageView) this.d.findViewById(R.id.obfuscated_res_0x7f090873);
        this.w0.setOnClickListener(new u0(this, new ReplyPrivacyCheckController(this.c.getPageContext()), this.c.O5()));
        a2();
        t0();
        this.x0 = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f0917c2);
        LinearLayout linearLayout = (LinearLayout) this.d.findViewById(R.id.obfuscated_res_0x7f0917ba);
        this.u0 = linearLayout;
        linearLayout.setOnClickListener(new v0(this));
        EjectionAnimationView ejectionAnimationView = (EjectionAnimationView) this.d.findViewById(R.id.obfuscated_res_0x7f090877);
        this.q0 = ejectionAnimationView;
        ejectionAnimationView.setEjectionAnimationViewCallback(new b(this));
        this.z0 = (ImageView) this.d.findViewById(R.id.obfuscated_res_0x7f0917c0);
        this.L1 = (MaskView) this.d.findViewById(R.id.obfuscated_res_0x7f0914a0);
        this.z0.setOnClickListener(this.P);
        AgreeView agreeView = (AgreeView) this.d.findViewById(R.id.obfuscated_res_0x7f0917bc);
        this.A0 = agreeView;
        agreeView.setAgreeAlone(true);
        this.A0.s();
        this.A0.setAgreeLongClickListener(new c(this));
        this.A0.setAfterClickListener(new d(this));
        this.A0.setUseDynamicLikeRes("/pb");
        if (this.A0.getAgreeNumView() != null) {
            this.A0.getAgreeNumView().setVisibility(8);
        }
        if (this.A0.getMsgData() != null) {
            this.A0.getMsgData().a = BdUniqueId.gen();
        }
        boolean booleanExtra = this.c.getBaseFragmentActivity().getIntent().getBooleanExtra("key_is_from_dynamic", false);
        ImageView imageView = (ImageView) this.d.findViewById(R.id.obfuscated_res_0x7f0917be);
        this.B0 = imageView;
        imageView.setOnClickListener(this.P);
        if (booleanExtra) {
            this.B0.setVisibility(8);
        } else {
            this.B0.setVisibility(0);
        }
        View findViewById = this.d.findViewById(R.id.obfuscated_res_0x7f0917c5);
        this.E0 = findViewById;
        findViewById.setVisibility((ru4.k().h("pb_share_red_dot_shown", false) || !TbadkCoreApplication.isLogin()) ? 8 : 0);
        this.C0 = (ImageView) this.d.findViewById(R.id.obfuscated_res_0x7f0917c3);
        HeadImageView headImageView = (HeadImageView) this.d.findViewById(R.id.obfuscated_res_0x7f0917c4);
        this.D0 = headImageView;
        headImageView.setIsRound(true);
        this.D0.setOnClickListener(this.S1);
        this.C0.setOnClickListener(new e(this));
        d2();
        w18 w18Var = new w18(this.C0);
        this.F0 = w18Var;
        w18Var.n(this.D0);
        if (!UbsABTestHelper.isResizeInduceSharingABTest() && !UbsABTestHelper.isResizeInduceSharingABTestA()) {
            this.F0.f();
        }
        TextView textView = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f0917c1);
        this.H0 = textView;
        textView.setVisibility(0);
        this.G0 = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f0917bd);
        this.S0 = (ViewStub) this.d.findViewById(R.id.obfuscated_res_0x7f090f57);
        this.A0.setVisibility(0);
        this.G0.setVisibility(0);
        this.u = new ay7(this.c, gu7Var);
        this.w = new ey7(this.c, gu7Var, this.P);
        uv7 uv7Var = new uv7(this.c, this.l);
        this.E = uv7Var;
        uv7Var.y0(this.P);
        this.E.A0(this.k0);
        this.E.v0(this.Q);
        this.E.x0(this.c.j2);
        this.E.r0(this.d2);
        f fVar = new f(this);
        this.T = fVar;
        this.E.t0(fVar);
        E1();
        y1();
        dy7 dy7Var = new dy7(this.c);
        this.y = dy7Var;
        dy7Var.f = 2;
        x1();
        this.z.a(this.l);
        this.w.m(this.l);
        this.v.a(this.l);
        this.u.a(this.l);
        PbListView pbListView = new PbListView(this.c.getPageContext().getPageActivity());
        this.K = pbListView;
        this.M = pbListView.b().findViewById(R.id.obfuscated_res_0x7f091810);
        this.N = this.K.b().findViewById(R.id.obfuscated_res_0x7f0917aa);
        if (!this.K.i().booleanValue()) {
            this.N.setVisibility(8);
        }
        View view2 = this.M;
        if (view2 != null) {
            view2.setOnClickListener(this.P);
            SkinManager.setBackgroundResource(this.M, R.drawable.pb_foot_more_trans_selector);
        }
        View view3 = this.N;
        if (view3 != null) {
            view3.setOnClickListener(this.P);
        }
        this.K.z();
        this.K.o(R.drawable.pb_foot_more_trans_selector);
        this.K.p(R.drawable.pb_foot_more_trans_selector);
        this.O = this.d.findViewById(R.id.obfuscated_res_0x7f09257a);
        this.c.registerListener(this.W1);
        this.i1 = new PbFakeFloorModel(this.c.getPageContext());
        PbModel K = this.c.K();
        this.i1.S(K.I(), K.E(), K.F(), K.D(), K.J());
        gw7 gw7Var = new gw7(this.c.getPageContext(), this.i1, this.d);
        this.j1 = gw7Var;
        gw7Var.k(new g(this));
        this.j1.n(this.c.o2);
        this.i1.U(new h(this));
        if (this.c.K() != null && !StringUtils.isNull(this.c.K().V1())) {
            PbFragment pbFragment2 = this.c;
            pbFragment2.showToast(pbFragment2.K().V1());
        }
        this.W0 = this.d.findViewById(R.id.obfuscated_res_0x7f0917c7);
        this.X0 = this.d.findViewById(R.id.obfuscated_res_0x7f0903eb);
        View findViewById2 = this.d.findViewById(R.id.obfuscated_res_0x7f091f38);
        this.Y0 = findViewById2;
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) findViewById2.getLayoutParams();
        if (this.c.K() != null && this.c.K().E1()) {
            this.W0.setVisibility(0);
            if (layoutParams2 != null) {
                layoutParams2.height = 0;
                this.Y0.setLayoutParams(layoutParams2);
            }
        } else if (layoutParams2 != null) {
            layoutParams2.height = i2;
            this.Y0.setLayoutParams(layoutParams2);
        }
        PbReplyTitleViewHolder pbReplyTitleViewHolder = new PbReplyTitleViewHolder(this.c.getPageContext(), this.d.findViewById(R.id.obfuscated_res_0x7f09183e));
        this.Z0 = pbReplyTitleViewHolder;
        pbReplyTitleViewHolder.r(pbFragment.e0);
        this.Z0.g.setVisibility(8);
        this.Z0.q(this.P);
        this.Z0.p(this.c.j2);
        this.c.registerListener(this.T1);
        this.c.registerListener(this.R1);
        PbFragment pbFragment3 = this.c;
        this.K1 = new v18(pbFragment3, pbFragment3.getUniqueId());
        this.M1 = (FallingView) this.d.findViewById(R.id.obfuscated_res_0x7f09097e);
        Y2();
        this.M1.setAnimationListener(new i(this));
        h0();
        R2(false);
        this.p0 = this.d.findViewById(R.id.obfuscated_res_0x7f0917b0);
        g0(qj5.a());
        if (UbsABTestHelper.isPbForumGuideTestA() && K.H2() && is7.b().e()) {
            if (this.p == null) {
                this.p = new kw7(this.c.getActivity(), (ViewGroup) m1().findViewById(R.id.obfuscated_res_0x7f0917e8));
            }
            jw7 jw7Var = new jw7(this.l);
            this.q = jw7Var;
            jw7Var.d(new jw7.a() { // from class: com.repackage.iv7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.repackage.jw7.a
                public final void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        mx7.this.V1();
                    }
                }
            });
        }
        this.r = new ix7(this.c.P(), (ViewGroup) m1().findViewById(R.id.obfuscated_res_0x7f091851));
        hx7 hx7Var = new hx7(this.l);
        this.s = hx7Var;
        hx7Var.d(new hx7.a() { // from class: com.repackage.jv7
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.repackage.hx7.a
            public final void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    mx7.this.W1();
                }
            }
        });
    }

    public uv7 A0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.E : (uv7) invokeV.objValue;
    }

    public final void A1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.c.F5()) {
            ViewStub viewStub = (ViewStub) this.d.findViewById(R.id.obfuscated_res_0x7f09147a);
            this.k = viewStub;
            viewStub.setVisibility(0);
            if (this.A == null) {
                this.A = (LinearLayout) this.d.findViewById(R.id.obfuscated_res_0x7f091479);
                fb5.a(this.c.getPageContext(), this.A);
            }
            if (this.B == null) {
                this.B = (TextView) this.A.findViewById(R.id.obfuscated_res_0x7f09147e);
            }
            if (this.C == null) {
                this.C = (TextView) this.A.findViewById(R.id.obfuscated_res_0x7f09147d);
            }
            this.B.setOnClickListener(this.P);
            this.C.setOnClickListener(this.P);
        }
    }

    public void A2(View view2) {
        SparseArray<Object> sparseArray;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) || (sparseArray = (SparseArray) view2.getTag()) == null) {
            return;
        }
        z2(sparseArray, false);
    }

    public void A3(int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i3) == null) {
            this.l.setSelection(i3);
        }
    }

    public LinearLayout B0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.u0 : (LinearLayout) invokeV.objValue;
    }

    public void B1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.c != null && this.m0 != null) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 9).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                this.m0.j();
                if (this.c.O5() != null) {
                    this.c.O5().Q();
                }
                o1();
                return;
            }
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 20).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
        }
    }

    public void B2(@NonNull View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, view2) == null) || this.A0.getData() == null || !this.A0.getData().hasAgree || this.c.getActivity() == null) {
            return;
        }
        hs7 hs7Var = new hs7(this.c.getContext());
        int f2 = qi.f(TbadkCoreApplication.getInst(), R.dimen.tbds774);
        int f3 = qi.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f07076f);
        int[] iArr = new int[2];
        view2.getLocationInWindow(iArr);
        int i3 = iArr[0];
        int i4 = iArr[1];
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(f3, f2);
        layoutParams.leftMargin = ((view2.getWidth() / 2) + i3) - ((int) ((f3 * 1) / 1.45d));
        layoutParams.topMargin = qi.f(TbadkCoreApplication.getInst(), R.dimen.M_H_X006);
        hs7Var.k(f2);
        hs7Var.j(layoutParams);
        hs7Var.i(false);
        hs7Var.n(true, this.c.getActivity().findViewById(16908290), 0, i4, this.N0.Q(), this.N0.m());
        hs7Var.l(new k(this));
    }

    public void B3(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            this.u1 = list;
            ky7 ky7Var = this.v1;
            if (ky7Var != null) {
                ky7Var.q(list);
            }
        }
    }

    public View C0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            View view2 = this.X;
            if (view2 != null) {
                return view2.findViewById(R.id.obfuscated_res_0x7f0907a1);
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    public final void C1(et7 et7Var, qx4 qx4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048585, this, et7Var, qx4Var) == null) || this.O1 == null || et7Var == null || qx4Var == null || this.c.getContext() == null) {
            return;
        }
        if (!RightFloatLayerView.k()) {
            v1();
            return;
        }
        if (this.N1 == null) {
            this.N1 = RightFloatLayerLottieView.F(qx4Var, this.c.getContext());
            this.O1.removeAllViews();
            this.O1.addView(this.N1);
        }
        if ((this.M1.getTag() instanceof Boolean) && !((Boolean) this.M1.getTag()).booleanValue()) {
            this.N1.setAutoCompleteShown(false);
            this.N1.setTag(this.M1);
            this.N1.c();
        }
        if (qx4Var.a()) {
            return;
        }
        this.N1.setData(qx4Var);
        this.N1.setLogoListener(new g0(this, qx4Var));
        this.N1.setFeedBackListener(new q0(this, qx4Var));
    }

    public boolean C2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            ix7 ix7Var = this.r;
            return ix7Var != null && ix7Var.l();
        }
        return invokeV.booleanValue;
    }

    public final boolean C3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            PbFragment pbFragment = this.c;
            return (pbFragment == null || pbFragment.K().S1().l().getDeletedReasonInfo() == null || 1 != this.c.K().S1().l().getDeletedReasonInfo().is_grays_cale_forum.intValue()) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public String D0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.c0 : (String) invokeV.objValue;
    }

    public void D1(et7 et7Var) {
        qx4 pbAdFloatViewItemData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, et7Var) == null) || et7Var == null) {
            return;
        }
        if (et7Var.n0()) {
            pbAdFloatViewItemData = et7Var.a0();
        } else {
            pbAdFloatViewItemData = TbSingleton.getInstance().getPbAdFloatViewItemData();
        }
        if (pbAdFloatViewItemData != null && !pbAdFloatViewItemData.a()) {
            C1(et7Var, pbAdFloatViewItemData);
        } else {
            v1();
        }
    }

    public void D2(z05 z05Var, int i3) {
        FallingView fallingView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048590, this, z05Var, i3) == null) || (fallingView = this.M1) == null) {
            return;
        }
        fallingView.D(z05Var, this.c.getPageContext(), i3, false);
    }

    public final void D3() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (pbFragment = this.c) == null || pbFragment.getActivity() == null) {
            return;
        }
        if (this.A0.getWidth() != 0 && this.A0.getHeight() != 0) {
            WaterRippleView waterRippleView = this.y0;
            if (waterRippleView == null) {
                this.y0 = new WaterRippleView(this.c.getActivity());
            } else {
                ViewParent parent = waterRippleView.getParent();
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(this.y0);
                }
            }
            Rect rect = new Rect();
            this.d.getGlobalVisibleRect(rect);
            Rect rect2 = new Rect();
            this.A0.getImgAgree().getGlobalVisibleRect(rect2);
            int f2 = qi.f(this.c.getActivity(), R.dimen.tbds166);
            int i3 = ((rect2.right + rect2.left) / 2) - f2;
            int i4 = (rect.bottom - ((rect2.bottom + rect2.top) / 2)) - f2;
            int i5 = f2 * 2;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i5, i5);
            layoutParams.addRule(12, -1);
            layoutParams.setMargins(i3, 0, 0, i4);
            this.d.addView(this.y0, layoutParams);
            TextView textView = this.G0;
            if (textView != null) {
                textView.setVisibility(4);
                return;
            }
            return;
        }
        BdLog.e("AgreeView not measured");
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
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && this.x == null) {
            this.x = new by7(this.c, this.P);
        }
    }

    public final void E2() {
        mz7 mz7Var;
        et7 et7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || this.v == null || (mz7Var = this.h) == null || mz7Var.p() == null || (et7Var = this.N0) == null || et7Var.O() == null || !this.N0.O().isQuestionThread() || this.v.c() == null || this.v.c().getVisibility() != 0) {
            return;
        }
        int[] iArr = new int[2];
        this.v.c().getLocationInWindow(iArr);
        boolean z2 = true;
        int height = iArr[1] + this.v.c().getHeight();
        boolean z3 = this.v.c().getParent() != null;
        mz7 mz7Var2 = this.h;
        if (height > mz7Var2.p().getBottom() && z3) {
            z2 = false;
        }
        mz7Var2.H(z2, this.N0.O().getSpan_str());
    }

    public void E3() {
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView != null) {
                pbLandscapeListView.setVisibility(0);
            }
            FrameLayout frameLayout = this.U0;
            if (frameLayout != null) {
                frameLayout.setVisibility(0);
            }
            mz7 mz7Var = this.h;
            if (mz7Var == null || (view2 = mz7Var.d) == null) {
                return;
            }
            view2.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
        }
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
            if (this.E.y(E0) != null && this.E.y(E0) != PostData.J0) {
                i3 = E0 + 1;
            }
            if (this.E.x(i3) instanceof PostData) {
                return (PostData) this.E.x(i3);
            }
            return null;
        }
        return (PostData) invokeV.objValue;
    }

    public void F1(et7 et7Var) {
        PbReplyTitleViewHolder pbReplyTitleViewHolder;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, et7Var) == null) {
            int i3 = 0;
            this.E.i0(et7Var, false);
            this.E.a0();
            p0();
            ev7 ev7Var = this.w1;
            if (ev7Var != null) {
                ev7Var.n();
            }
            ArrayList<PostData> F = et7Var.F();
            if (et7Var.y().b() == 0 || F == null || F.size() < et7Var.y().e()) {
                if (ListUtils.getCount(F) != 0 && (ListUtils.getCount(F) != 1 || F.get(0) == null || F.get(0).B() != 1)) {
                    if (et7Var.y().b() == 0) {
                        this.K.C(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f09e9));
                    } else {
                        this.K.C(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0a3a));
                    }
                    this.K.k();
                } else {
                    w0 w0Var = this.d1;
                    if (w0Var != null && (pbReplyTitleViewHolder = w0Var.c) != null && pbReplyTitleViewHolder.getView() != null) {
                        i3 = this.d1.c.getView().getTop() < 0 ? this.d1.c.getView().getHeight() : this.d1.c.getView().getBottom();
                    }
                    if (this.c.o6()) {
                        this.K.F(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0dde), i3);
                    } else {
                        this.K.F(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0ddf), i3);
                    }
                }
            }
            J2(et7Var);
        }
    }

    public final void F2(PbReplyTitleViewHolder pbReplyTitleViewHolder, boolean z2) {
        int measuredHeight;
        int i3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048598, this, pbReplyTitleViewHolder, z2) == null) || this.n1 || this.W0 == null || this.h.p() == null) {
            return;
        }
        View s2 = A0().s();
        if (s2 != null) {
            int[] iArr = new int[2];
            s2.getLocationInWindow(iArr);
            int i4 = iArr[1];
            if (i4 != 0) {
                if (this.W0.getVisibility() == 0 && i4 - this.h.p().getBottom() <= this.W0.getHeight()) {
                    this.X0.setVisibility(0);
                    if (i4 > this.h.p().getBottom()) {
                        i3 = -(((this.W0.getHeight() + this.X0.getHeight()) + this.h.p().getBottom()) - s2.getBottom());
                    } else {
                        i3 = -this.W0.getHeight();
                    }
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.W0.getLayoutParams();
                    if (layoutParams.topMargin != i3) {
                        layoutParams.topMargin = i3;
                        this.W0.setLayoutParams(layoutParams);
                    }
                } else {
                    this.X0.setVisibility(4);
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.W0.getLayoutParams();
                    if (layoutParams2.topMargin != 0) {
                        layoutParams2.topMargin = 0;
                        this.W0.setLayoutParams(layoutParams2);
                    }
                }
            }
        }
        int H = this.E.H();
        if (H > 0 && (pbReplyTitleViewHolder == null || pbReplyTitleViewHolder.getView().getParent() == null)) {
            if (H > this.l.getFirstVisiblePosition() - this.l.getHeaderViewsCount()) {
                this.W0.setVisibility(4);
                return;
            }
            this.W0.setVisibility(0);
            I3(false);
            this.h.a.hideBottomLine();
            if (this.W0.getParent() == null || ((ViewGroup) this.W0.getParent()).getHeight() > this.W0.getTop()) {
                return;
            }
            this.W0.getParent().requestLayout();
        } else if (pbReplyTitleViewHolder != null && pbReplyTitleViewHolder.getView() != null && pbReplyTitleViewHolder.g != null) {
            int top = pbReplyTitleViewHolder.getView().getTop();
            if (pbReplyTitleViewHolder.getView().getParent() != null) {
                if (this.c1) {
                    this.b1 = top;
                    this.c1 = false;
                }
                int i5 = this.b1;
                if (top < i5) {
                    i5 = top;
                }
                this.b1 = i5;
            }
            if (top != 0 || pbReplyTitleViewHolder.getView().isShown()) {
                if (this.D.getY() < 0.0f) {
                    measuredHeight = i2 - pbReplyTitleViewHolder.g.getMeasuredHeight();
                } else {
                    measuredHeight = this.h.p().getMeasuredHeight() - pbReplyTitleViewHolder.g.getMeasuredHeight();
                    this.h.a.hideBottomLine();
                }
                if (pbReplyTitleViewHolder.getView().getParent() == null && top <= this.b1) {
                    this.W0.setVisibility(0);
                    I3(false);
                } else if (top < measuredHeight) {
                    this.W0.setVisibility(0);
                    I3(false);
                } else {
                    this.W0.setVisibility(4);
                    this.h.a.hideBottomLine();
                }
                if (z2) {
                    this.c1 = true;
                }
            }
        } else if (this.l.getFirstVisiblePosition() == 0) {
            this.W0.setVisibility(4);
            this.h.a.hideBottomLine();
        }
    }

    public void F3() {
        fy7 fy7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048599, this) == null) || (fy7Var = this.t) == null) {
            return;
        }
        fy7Var.u(this.l);
    }

    public FallingView G0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.M1 : (FallingView) invokeV.objValue;
    }

    public boolean G1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.a2 : invokeV.booleanValue;
    }

    public final void G2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            this.w.A(this.N0, this.O0, this.o1, this.n1);
        }
    }

    public final void G3(SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048603, this, sparseArray) == null) || this.c == null) {
            return;
        }
        if (sparseArray != null) {
            sparseArray.put(R.id.obfuscated_res_0x7f091ffe, Boolean.TRUE);
        }
        TBAlertConfig.a aVar = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f1174, TBAlertConfig.OperateBtnStyle.MAIN);
        TBAlertConfig.a aVar2 = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f0370, TBAlertConfig.OperateBtnStyle.SECONDARY);
        TBAlertBuilder tBAlertBuilder = new TBAlertBuilder(this.c.P());
        tBAlertBuilder.t(R.string.obfuscated_res_0x7f0f0b2c);
        tBAlertBuilder.k(R.string.obfuscated_res_0x7f0f0b2d);
        tBAlertBuilder.m(true);
        tBAlertBuilder.r(aVar2, aVar);
        tBAlertBuilder.h(false);
        AlertDialog w2 = tBAlertBuilder.w();
        aVar.a(new w(this, w2, sparseArray));
        aVar2.a(new x(this, w2));
    }

    public int H0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? J0(this.l.getFirstVisiblePosition()) : invokeV.intValue;
    }

    public boolean H1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.J0 : invokeV.booleanValue;
    }

    public void H2() {
        PbLandscapeListView pbLandscapeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048606, this) == null) || (pbLandscapeListView = this.l) == null) {
            return;
        }
        int headerViewsCount = pbLandscapeListView.getHeaderViewsCount() - this.m1;
        int firstVisiblePosition = (this.l.getFirstVisiblePosition() == 0 || this.l.getFirstVisiblePosition() + headerViewsCount < 0) ? 0 : this.l.getFirstVisiblePosition() + headerViewsCount;
        View childAt = this.l.getChildAt(0);
        int top = childAt != null ? childAt.getTop() : -1;
        this.d1.c = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.d1));
        PbReplyTitleViewHolder pbReplyTitleViewHolder = this.d1.c;
        int f1 = f1(pbReplyTitleViewHolder);
        int measuredHeight = this.D.getMeasuredHeight() + ((int) this.D.getY());
        boolean z2 = this.W0.getVisibility() == 0;
        boolean z3 = this.D.getY() < 0.0f;
        if ((z2 && pbReplyTitleViewHolder != null) || firstVisiblePosition >= this.E.H() + this.l.getHeaderViewsCount()) {
            int measuredHeight2 = pbReplyTitleViewHolder != null ? pbReplyTitleViewHolder.g.getMeasuredHeight() : 0;
            if (z3) {
                this.l.setSelectionFromTop(this.E.H() + this.l.getHeaderViewsCount(), i2 - measuredHeight2);
            } else {
                this.l.setSelectionFromTop(this.E.H() + this.l.getHeaderViewsCount(), this.h.p().getMeasuredHeight() - measuredHeight2);
            }
        } else {
            this.l.setSelectionFromTop(firstVisiblePosition, top);
        }
        if (this.n1 && this.t != null) {
            this.l.setSelectionFromTop(this.E.H() + this.l.getHeaderViewsCount(), this.t.d());
        } else if (this.P0 != 6) {
        } else {
            this.l.setOnLayoutListener(new a(this, f1, pbReplyTitleViewHolder, z2, measuredHeight, firstVisiblePosition, top));
        }
    }

    public final void H3(int i3, SparseArray<Object> sparseArray) {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048607, this, i3, sparseArray) == null) || (pbFragment = this.c) == null || pbFragment.K() == null || this.c.K().S1() == null || this.c.K().S1().o() == null || this.c.K().S1().l() == null || this.c.K().S1().l().getDeletedReasonInfo() == null) {
            return;
        }
        if (sparseArray != null) {
            sparseArray.put(R.id.obfuscated_res_0x7f091ffe, Boolean.TRUE);
        }
        al5 al5Var = new al5(this.c.K().S1().l().getDeletedReasonInfo().is_grays_cale_forum.intValue(), this.c.K().S1().l().getDeletedReasonInfo().is_boomgrow.intValue(), this.c.K().S1().o().has_forum_rule.intValue());
        al5Var.i(this.c.K().S1().l().getId(), this.c.K().S1().l().getName());
        al5Var.h(this.c.K().S1().l().getImage_url());
        al5Var.j(this.c.K().S1().l().getUser_level());
        S3(sparseArray, i3, al5Var, this.c.K().S1().V(), true);
    }

    public PostData I0(et7 et7Var, boolean z2) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048608, this, et7Var, z2)) == null) {
            PostData postData = null;
            if (et7Var == null) {
                return null;
            }
            if (et7Var.X() != null) {
                return et7Var.X();
            }
            if (!ListUtils.isEmpty(et7Var.F())) {
                Iterator<PostData> it = et7Var.F().iterator();
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
                postData = et7Var.j();
            }
            if (!L1(postData)) {
                postData = d1(et7Var);
            }
            if (postData != null && postData.s() != null && postData.s().getUserTbVipInfoData() != null && postData.s().getUserTbVipInfoData().getvipIntro() != null) {
                postData.s().getGodUserData().setIntro(postData.s().getUserTbVipInfoData().getvipIntro());
            }
            return postData;
        }
        return (PostData) invokeLZ.objValue;
    }

    public final boolean I1(et7 et7Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, et7Var)) == null) {
            if (et7Var == null || et7Var.O() == null) {
                return false;
            }
            SpannableStringBuilder span_str = et7Var.O().getSpan_str();
            if (span_str != null) {
                return TbadkApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0dc6).equals(span_str.toString());
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void I2(AgreeData agreeData, long j3) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLJ(1048610, this, agreeData, j3) == null) || agreeData == null || (textView = this.G0) == null) {
            return;
        }
        if (j3 > 0) {
            if (agreeData.agreeType == 2 && agreeData.hasAgree) {
                textView.setTextColor(SkinManager.getColor(R.color.CAM_X0301));
            } else {
                this.G0.setTextColor(SkinManager.getColor(R.color.CAM_X0107));
            }
            this.G0.setText(y0(j3));
            this.G0.setVisibility(0);
            return;
        }
        textView.setVisibility(8);
    }

    public void I3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048611, this, z2) == null) {
            this.o0.setVisibility(z2 ? 0 : 8);
        }
    }

    public final int J0(int i3) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048612, this, i3)) == null) {
            fn adapter2 = this.l.getAdapter2();
            if (adapter2 == null) {
                return i3;
            }
            if (i3 < adapter2.getCount() && i3 >= 0 && (adapter2.getItem(i3) instanceof bt7)) {
                i3++;
            }
            int o3 = (adapter2.o() + adapter2.m()) - 1;
            if (i3 > o3) {
                i3 = o3;
            }
            int n3 = (this.l.getAdapter2() == null || !(this.l.getAdapter2() instanceof fn)) ? 0 : this.l.getAdapter2().n();
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

    public final void J2(et7 et7Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048614, this, et7Var) == null) || et7Var == null || et7Var.O() == null) {
            return;
        }
        r4(et7Var);
        ImageView imageView = this.B0;
        if (imageView != null && imageView.getContext() != null) {
            if (et7Var.r()) {
                WebPManager.setPureDrawable(this.B0, R.drawable.obfuscated_res_0x7f08095f, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
            } else {
                WebPManager.setPureDrawable(this.B0, R.drawable.obfuscated_res_0x7f08095e, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            }
        }
        String z0 = z0(et7Var.O().getReply_num());
        TextView textView = this.H0;
        if (textView != null) {
            textView.setText(z0);
        }
        TextView textView2 = this.I0;
        if (textView2 != null) {
            textView2.setText(z0);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921416, et7Var.O()));
        I2(et7Var.O().getAgreeData(), et7Var.O().getAgreeNum());
        if (this.A0 == null || et7Var.O() == null) {
            return;
        }
        this.A0.setThreadData(et7Var.O());
        int i3 = 1;
        if (et7Var.O().getAgreeData() != null) {
            et7Var.O().getAgreeData().isInThread = true;
        }
        this.A0.setData(et7Var.O().getAgreeData());
        lo4 lo4Var = new lo4();
        lo4Var.b = 26;
        if (et7Var.O().isVideoThreadType() && et7Var.O().getThreadVideoInfo() != null) {
            i3 = 2;
        }
        lo4Var.c = i3;
        PbFragment pbFragment = this.c;
        if (pbFragment != null && pbFragment.K() != null) {
            lo4Var.j = this.c.K().getFromForumId();
            lo4Var.f = this.c.K().R1();
        }
        this.A0.setStatisticData(lo4Var);
    }

    public void J3(boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048615, this, z2) == null) || this.t0 == null) {
            return;
        }
        a3(this.c.O5().C());
        if (this.n0) {
            N3(z2);
        } else {
            p1(z2);
        }
    }

    public Button K0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.r0 : (Button) invokeV.objValue;
    }

    public boolean K1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            EditorTools editorTools = this.m0;
            return editorTools != null && editorTools.getVisibility() == 0;
        }
        return invokeV.booleanValue;
    }

    public void K2(int i3, et7 et7Var, boolean z2, int i4) {
        PostData I0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048618, this, new Object[]{Integer.valueOf(i3), et7Var, Boolean.valueOf(z2), Integer.valueOf(i4)}) == null) || i3 <= 0 || (I0 = I0(et7Var, z2)) == null || I0.s() == null) {
            return;
        }
        MetaData s2 = I0.s();
        s2.setGiftNum(s2.getGiftNum() + i3);
    }

    public void K3(et7 et7Var) {
        PostData postData;
        mz7 mz7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048619, this, et7Var) == null) || et7Var == null || (postData = this.O0) == null || postData.s() == null || (mz7Var = this.h) == null) {
            return;
        }
        boolean z2 = !this.n1;
        this.o1 = z2;
        mz7Var.I(z2);
        if (this.c.P5() != null) {
            this.c.P5().s(this.o1);
        }
        G2();
        PbFragment pbFragment = this.c;
        if (pbFragment != null && !pbFragment.u0() && !ListUtils.isEmpty(et7Var.p())) {
            er4 er4Var = et7Var.p().get(0);
            if (er4Var != null) {
                this.h.M(et7Var, er4Var.c(), er4Var.d(), er4Var.a(), er4Var.getIsLike());
            }
        } else if (et7Var.l() != null) {
            this.h.M(et7Var, et7Var.l().getName(), et7Var.l().getId(), et7Var.l().getImage_url(), et7Var.l().isLike() == 1);
        }
        if (this.o1) {
            this.w.L(et7Var, this.O0, this.h0);
            View view2 = this.Y0;
            if (view2 != null) {
                view2.setVisibility(8);
            }
            if (this.x1 == null) {
                this.x1 = new k0(this);
            }
            this.l.setListViewDragListener(this.x1);
            return;
        }
        View view3 = this.Y0;
        if (view3 != null) {
            view3.setVisibility(0);
        }
        this.w.L(et7Var, this.O0, this.h0);
        this.x1 = null;
        this.l.setListViewDragListener(null);
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

    public void L2(et7 et7Var, boolean z2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048622, this, new Object[]{et7Var, Boolean.valueOf(z2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            V3(et7Var, z2, i3, i4);
            this.w.y(i4);
        }
    }

    public final void L3(SparseArray<Object> sparseArray, @StringRes int i3, @StringRes int i4) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(1048623, this, sparseArray, i3, i4) == null) || this.c == null) {
            return;
        }
        TBAlertConfig.a aVar = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f04ab, TBAlertConfig.OperateBtnStyle.MAIN);
        TBAlertConfig.a aVar2 = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f0370, TBAlertConfig.OperateBtnStyle.SECONDARY);
        TBAlertBuilder tBAlertBuilder = new TBAlertBuilder(this.c.P());
        tBAlertBuilder.t(i3);
        tBAlertBuilder.k(i4);
        tBAlertBuilder.m(true);
        tBAlertBuilder.r(aVar2, aVar);
        tBAlertBuilder.h(false);
        AlertDialog w2 = tBAlertBuilder.w();
        aVar.a(new t(this, w2, sparseArray));
        aVar2.a(new u(this, w2));
    }

    public TextView M0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) ? this.w.q() : (TextView) invokeV.objValue;
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
        PbInterviewStatusView pbInterviewStatusView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048626, this) == null) && (pbInterviewStatusView = this.T0) != null && pbInterviewStatusView.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.T0.getLayoutParams();
            layoutParams.setMargins(0, 0, 0, 0);
            this.T0.setLayoutParams(layoutParams);
        }
    }

    public final boolean M3(et7 et7Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048627, this, et7Var)) == null) {
            if (et7Var == null || et7Var.O() == null) {
                return false;
            }
            return et7Var.O().getIsLive() == 1 || et7Var.O().getThreadType() == 33 || !(et7Var.O().getTopicData() == null || et7Var.O().getTopicData().a() == 0) || et7Var.O().getIs_top() == 1 || et7Var.O().getIs_good() == 1 || et7Var.O().isActInfo() || et7Var.O().isInterviewLive() || et7Var.O().isVoteThreadType() || et7Var.O().getYulePostActivityData() != null || !pi.isEmpty(et7Var.O().getCategory()) || et7Var.O().isGodThread() || et7Var.O().isRealGod();
        }
        return invokeL.booleanValue;
    }

    public int N0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) {
            w18 w18Var = this.F0;
            if (w18Var != null) {
                return w18Var.g();
            }
            return 3;
        }
        return invokeV.intValue;
    }

    public final boolean N1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) ? TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.b2) : invokeV.booleanValue;
    }

    public void N2() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048630, this) == null) || this.f == 2) {
            return;
        }
        this.l.setNextPage(this.K);
        this.f = 2;
    }

    public void N3(boolean z2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048631, this, z2) == null) || this.t0 == null || (textView = this.x0) == null) {
            return;
        }
        textView.setText(R.string.obfuscated_res_0x7f0f0519);
        if (z2) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(400L);
            this.t0.startAnimation(alphaAnimation);
        }
        this.s0.setVisibility(0);
        this.t0.setVisibility(0);
        this.J0 = true;
        if (this.e1 == null || this.w1.l()) {
            return;
        }
        this.e1.setVisibility(0);
        R2(true);
    }

    public PbInterviewStatusView O0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) ? this.T0 : (PbInterviewStatusView) invokeV.objValue;
    }

    public final boolean O1(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048633, this, threadData)) == null) {
            if (threadData == null || threadData.getAuthor() == null) {
                return false;
            }
            PostData I0 = I0(this.N0, false);
            return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), (I0 == null || I0.s() == null) ? "" : I0.s().getUserId());
        }
        return invokeL.booleanValue;
    }

    public final void O2() {
        PbFragment pbFragment;
        WaterRippleView waterRippleView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048634, this) == null) || (pbFragment = this.c) == null || pbFragment.getActivity() == null || (waterRippleView = this.y0) == null) {
            return;
        }
        ViewParent parent = waterRippleView.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.y0);
        }
        TextView textView = this.G0;
        if (textView != null) {
            textView.setVisibility(0);
        }
    }

    public void O3(View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048635, this, view2) == null) || ru4.k().h("show_long_press_collection_tips", false)) {
            return;
        }
        Rect rect = new Rect();
        this.t0.getGlobalVisibleRect(rect);
        int i3 = rect.bottom;
        int i4 = rect.top;
        view2.getGlobalVisibleRect(rect);
        int i5 = rect.bottom;
        FrameLayout frameLayout = new FrameLayout(this.c.getContext());
        frameLayout.setBackgroundResource(R.drawable.pic_sign_tip);
        TextView textView = new TextView(this.c.getContext());
        this.t1 = textView;
        textView.setText(R.string.obfuscated_res_0x7f0f043d);
        this.t1.setGravity(17);
        this.t1.setPadding(qi.f(this.c.getContext(), R.dimen.obfuscated_res_0x7f0701e8), 0, qi.f(this.c.getContext(), R.dimen.obfuscated_res_0x7f0701e8), 0);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        layoutParams.height = qi.f(this.c.getContext(), R.dimen.obfuscated_res_0x7f070253);
        if (this.t1.getParent() == null) {
            frameLayout.addView(this.t1, layoutParams);
        }
        PopupWindow popupWindow = new PopupWindow(this.c.getContext());
        this.s1 = popupWindow;
        popupWindow.setContentView(frameLayout);
        this.s1.setHeight(-2);
        this.s1.setWidth(-2);
        this.s1.setFocusable(true);
        this.s1.setOutsideTouchable(false);
        this.s1.setBackgroundDrawable(new ColorDrawable(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent)));
        this.l.postDelayed(new p0(this, i5, i3, i4, view2), 100L);
        ru4.k().u("show_long_press_collection_tips", true);
    }

    public boolean P0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) ? this.y1 : invokeV.booleanValue;
    }

    public boolean P1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) {
            View view2 = this.a1;
            if (view2 == null || view2.getParent() == null || this.K.m()) {
                return false;
            }
            int bottom = this.a1.getBottom();
            Rect rect = new Rect();
            this.a1.getWindowVisibleDisplayFrame(rect);
            return bottom > 0 && bottom <= rect.bottom;
        }
        return invokeV.booleanValue;
    }

    public void P2() {
        PbLandscapeListView pbLandscapeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048638, this) == null) || (pbLandscapeListView = this.l) == null) {
            return;
        }
        this.z.d(pbLandscapeListView);
        this.v.g(this.l);
        this.w.B(this.l);
        this.x.d(this.l);
        this.u.f(this.l);
    }

    public void P3() {
        mz7 mz7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048639, this) == null) || (mz7Var = this.h) == null || this.p1) {
            return;
        }
        mz7Var.D();
        this.p1 = true;
    }

    public int Q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) {
            int lastVisiblePosition = this.l.getLastVisiblePosition();
            if (this.t != null) {
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
            et7 et7Var = this.N0;
            return et7Var == null || et7Var.l() == null || "0".equals(this.N0.l().getId()) || "me0407".equals(this.N0.l().getName());
        }
        return invokeV.booleanValue;
    }

    public final void Q2() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048642, this) == null) || (pbFragment = this.c) == null || pbFragment.O5() == null || this.m0 == null) {
            return;
        }
        g45.a().c(0);
        k45 O5 = this.c.O5();
        O5.U();
        O5.S();
        if (O5.y() != null) {
            O5.y().setMaxImagesAllowed(O5.v ? 1 : 9);
        }
        O5.n0(SendView.h);
        O5.j(SendView.h);
        o25 m3 = this.m0.m(23);
        o25 m4 = this.m0.m(2);
        o25 m5 = this.m0.m(5);
        if (m4 != null) {
            m4.display();
        }
        if (m5 != null) {
            m5.display();
        }
        if (m3 != null) {
            m3.hide();
        }
        this.m0.invalidate();
    }

    public void Q3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048643, this) == null) {
            this.l.setVisibility(0);
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
            fy7 fy7Var = this.t;
            return fy7Var != null && fy7Var.f();
        }
        return invokeV.booleanValue;
    }

    public final void R2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048646, this, z2) == null) {
        }
    }

    public void R3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048647, this) == null) {
            if (this.L0 == null) {
                this.L0 = new uu4(this.c.getPageContext());
            }
            this.L0.h(true);
        }
    }

    public SparseArray<Object> S0(et7 et7Var, boolean z2, int i3) {
        InterceptResult invokeCommon;
        PostData I0;
        kp4 kp4Var;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048648, this, new Object[]{et7Var, Boolean.valueOf(z2), Integer.valueOf(i3)})) == null) {
            StringBuilder sb = null;
            if (et7Var == null || (I0 = I0(et7Var, z2)) == null) {
                return null;
            }
            String userId = I0.s().getUserId();
            boolean z3 = userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount());
            SparseArray<Object> sparseArray = new SparseArray<>();
            if (i3 == 0) {
                sparseArray.put(R.id.obfuscated_res_0x7f091fea, I0.K());
                sparseArray.put(R.id.obfuscated_res_0x7f091fec, 0);
                sparseArray.put(R.id.obfuscated_res_0x7f091feb, Boolean.valueOf(z3));
                sparseArray.put(R.id.obfuscated_res_0x7f092008, Integer.valueOf(et7Var.W()));
                sparseArray.put(R.id.obfuscated_res_0x7f092030, Boolean.FALSE);
            } else if (i3 == 1) {
                if (I0.s() != null) {
                    sparseArray.put(R.id.obfuscated_res_0x7f091ff5, I0.s().getUserName());
                    sparseArray.put(R.id.obfuscated_res_0x7f091ff6, I0.s().getName_show());
                    sparseArray.put(R.id.obfuscated_res_0x7f091ff7, I0.s().getPortrait());
                    sparseArray.put(R.id.obfuscated_res_0x7f091ff8, I0.K());
                }
                sparseArray.put(R.id.obfuscated_res_0x7f091fea, I0.K());
                sparseArray.put(R.id.obfuscated_res_0x7f091fec, 0);
                sparseArray.put(R.id.obfuscated_res_0x7f091feb, Boolean.valueOf(z3));
                sparseArray.put(R.id.obfuscated_res_0x7f092008, Integer.valueOf(et7Var.W()));
                sparseArray.put(R.id.obfuscated_res_0x7f092030, Boolean.TRUE);
            }
            if (!z3) {
                List<er4> p3 = et7Var.p();
                if (ListUtils.getCount(p3) > 0) {
                    sb = new StringBuilder();
                    for (er4 er4Var : p3) {
                        if (er4Var != null && !StringUtils.isNull(er4Var.c()) && (kp4Var = er4Var.g) != null && kp4Var.a && !kp4Var.c && ((i4 = kp4Var.b) == 1 || i4 == 2)) {
                            sb.append(pi.cutString(er4Var.c(), 12));
                            sb.append(this.c.getString(R.string.obfuscated_res_0x7f0f065a));
                            sb.append("、");
                        }
                    }
                }
                if (sb != null && !StringUtils.isNull(sb.toString())) {
                    sparseArray.put(R.id.obfuscated_res_0x7f091fe9, String.format(this.c.getString(R.string.obfuscated_res_0x7f0f04a3), sb.toString().substring(0, sb.length() - 1)));
                }
            }
            return sparseArray;
        }
        return (SparseArray) invokeCommon.objValue;
    }

    public boolean S1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) ? this.P1 : invokeV.booleanValue;
    }

    public void S2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048650, this) == null) {
            Q2();
            q1();
            this.j1.c();
            J3(false);
        }
    }

    public final void S3(SparseArray<Object> sparseArray, int i3, al5 al5Var, UserData userData, boolean z2) {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048651, this, new Object[]{sparseArray, Integer.valueOf(i3), al5Var, userData, Boolean.valueOf(z2)}) == null) || (pbFragment = this.c) == null) {
            return;
        }
        if (this.C1 == null && this.u != null) {
            this.C1 = new bl5(pbFragment.getPageContext(), this.u.c(), al5Var, userData);
        }
        this.C1.C(z2);
        AntiData v5 = this.c.v5();
        SparseArray<String> sparseArray2 = new SparseArray<>();
        if (v5 != null && v5.getDelThreadInfoList() != null) {
            List<DeleteThreadInfo> delThreadInfoList = v5.getDelThreadInfoList();
            for (int i4 = 0; i4 < delThreadInfoList.size(); i4++) {
                if (!TextUtils.isEmpty(delThreadInfoList.get(i4).text_info)) {
                    sparseArray2.put(delThreadInfoList.get(i4).text_id, delThreadInfoList.get(i4).text_info);
                }
            }
        }
        cq4 cq4Var = new cq4();
        cq4Var.j(sparseArray2);
        this.C1.E(new String[]{this.c.getString(R.string.obfuscated_res_0x7f0f04bf), this.c.getString(R.string.obfuscated_res_0x7f0f04c0), this.c.getString(R.string.obfuscated_res_0x7f0f04c1), this.c.getString(R.string.obfuscated_res_0x7f0f04c2), this.c.getString(R.string.obfuscated_res_0x7f0f04c3)});
        this.C1.D(cq4Var);
        this.C1.G((i3 == 1 || i3 == 2) ? "4" : "3");
        this.C1.F(new z(this, sparseArray));
    }

    public ev7 T0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048652, this)) == null) ? this.w1 : (ev7) invokeV.objValue;
    }

    public boolean T1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048653, this)) == null) {
            w18 w18Var = this.F0;
            if (w18Var == null) {
                return false;
            }
            return w18Var.i();
        }
        return invokeV.booleanValue;
    }

    public final void T2() {
        fy7 fy7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048654, this) == null) || (fy7Var = this.t) == null) {
            return;
        }
        fy7Var.q(this.l, this.V0, this.P0);
    }

    public void T3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048655, this) == null) {
            this.E.i0(this.N0, false);
            this.E.a0();
        }
    }

    public View U0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048656, this)) == null) ? this.N : (View) invokeV.objValue;
    }

    public boolean U1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048657, this)) == null) {
            EditorTools editorTools = this.m0;
            return editorTools != null && editorTools.u();
        }
        return invokeV.booleanValue;
    }

    public void U2() {
        Handler handler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048658, this) == null) || (handler = this.U1) == null) {
            return;
        }
        Runnable runnable = this.V1;
        if (runnable != null) {
            handler.removeCallbacks(runnable);
        }
        m mVar = new m(this);
        this.V1 = mVar;
        this.U1.postDelayed(mVar, 2000L);
    }

    public void U3(et7 et7Var, int i3, int i4, boolean z2, int i5, boolean z3) {
        PbLandscapeListView pbLandscapeListView;
        int i6;
        PbReplyTitleViewHolder pbReplyTitleViewHolder;
        PbFragment pbFragment;
        et7 et7Var2;
        Parcelable e2;
        Parcelable e3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048659, this, new Object[]{et7Var, Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z2), Integer.valueOf(i5), Boolean.valueOf(z3)}) == null) || et7Var == null || this.l == null) {
            return;
        }
        this.N0 = et7Var;
        this.P0 = i3;
        if (et7Var.O() != null) {
            this.f1 = et7Var.O().getCopyThreadRemindType();
            if (et7Var.O().getAnchorLevel() != 0) {
                this.a2 = true;
            }
            this.h0 = O1(et7Var.O());
        }
        if (et7Var.V() != null) {
            this.b2 = et7Var.V().getUserId();
        }
        z1(et7Var);
        e0();
        this.R0 = false;
        this.M0 = z2;
        v3();
        nt7 nt7Var = et7Var.h;
        if (nt7Var != null && nt7Var.b()) {
            if (this.o == null) {
                PbThreadPostView pbThreadPostView = new PbThreadPostView(this.c.getContext());
                this.o = pbThreadPostView;
                this.l.x(pbThreadPostView, 1);
                this.o.setData(et7Var);
                this.o.setChildOnClickLinstener(this.P);
            }
        } else {
            PbThreadPostView pbThreadPostView2 = this.o;
            if (pbThreadPostView2 != null && (pbLandscapeListView = this.l) != null) {
                pbLandscapeListView.removeHeaderView(pbThreadPostView2);
            }
        }
        V3(et7Var, z2, i3, TbadkCoreApplication.getInst().getSkinType());
        K3(et7Var);
        this.w.M(et7Var, this.O0);
        if (this.z1 == null) {
            this.z1 = new ww7(this.c.getPageContext(), this.A1);
        }
        this.z1.a(et7Var.w());
        if (this.c.F5()) {
            if (this.J == null) {
                x18 x18Var = new x18(this.c.getPageContext());
                this.J = x18Var;
                x18Var.n();
                this.J.f(this.c2);
            }
            this.l.setPullRefresh(this.J);
            T2();
            x18 x18Var2 = this.J;
            if (x18Var2 != null) {
                x18Var2.H(TbadkCoreApplication.getInst().getSkinType());
            }
        } else if (et7Var.y().c() == 0 && z2) {
            this.l.setPullRefresh(null);
        } else {
            if (this.J == null) {
                x18 x18Var3 = new x18(this.c.getPageContext());
                this.J = x18Var3;
                x18Var3.n();
                this.J.f(this.c2);
            }
            this.l.setPullRefresh(this.J);
            T2();
            x18 x18Var4 = this.J;
            if (x18Var4 != null) {
                x18Var4.H(TbadkCoreApplication.getInst().getSkinType());
            }
            s1();
        }
        p0();
        this.E.p0(this.M0);
        this.E.m0(false);
        this.E.n0(i3 == 5);
        this.E.o0(i3 == 6);
        this.E.k0(z3 && this.Y1 && i3 != 2);
        this.E.i0(et7Var, false);
        this.E.a0();
        this.E.c0(et7Var.y().b() != 0, et7Var.g());
        this.w.K(I0(et7Var, z2), et7Var.i0());
        if (et7Var.O() != null && et7Var.O().getPraise() != null && this.b != -1) {
            et7Var.O().getPraise().setIsLike(this.b);
        }
        this.l.removeFooterView(this.a1);
        this.l.addFooterView(this.a1);
        if (TbadkCoreApplication.isLogin()) {
            this.l.setNextPage(this.K);
            this.f = 2;
            s1();
        } else {
            this.R0 = true;
            if (et7Var.y().b() == 1) {
                if (this.L == null) {
                    PbFragment pbFragment2 = this.c;
                    this.L = new t18(pbFragment2, pbFragment2);
                }
                this.l.setNextPage(this.L);
            } else {
                this.l.setNextPage(this.K);
            }
            this.f = 3;
        }
        ArrayList<PostData> F = et7Var.F();
        if (et7Var.y().b() != 0 && F != null && F.size() >= et7Var.y().e()) {
            if (z3) {
                if (this.Y1) {
                    u0();
                    if (et7Var.y().b() != 0) {
                        this.K.C(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0dd7));
                    }
                } else {
                    this.K.z();
                    this.K.N();
                }
            } else {
                this.K.z();
                this.K.N();
            }
            this.K.k();
        } else {
            if (ListUtils.getCount(F) != 0 && (ListUtils.getCount(F) != 1 || F.get(0) == null || F.get(0).B() != 1)) {
                if (et7Var.y().b() == 0) {
                    this.K.C(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f09e9));
                } else {
                    this.K.C(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0a3a));
                }
                this.K.k();
            } else {
                w0 w0Var = this.d1;
                if (w0Var == null || (pbReplyTitleViewHolder = w0Var.c) == null || pbReplyTitleViewHolder.getView() == null) {
                    i6 = 0;
                } else {
                    i6 = this.d1.c.getView().getTop() < 0 ? this.d1.c.getView().getHeight() : this.d1.c.getView().getBottom();
                }
                if (this.c.o6()) {
                    this.K.u(false);
                    if (ListUtils.isEmpty(et7Var.R())) {
                        this.K.F(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0dde), i6);
                    }
                } else if (ListUtils.isEmpty(et7Var.R())) {
                    this.K.F(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0ddf), i6);
                }
                if (this.c.P5() != null && !this.c.P5().p()) {
                    this.c.P5().x();
                }
            }
            if (et7Var.y().b() == 0 || F == null) {
                N2();
            }
        }
        if (i3 == 2) {
            this.l.setSelection(i4 > 1 ? (i4 + ((this.l.getData() == null && et7Var.F() == null) ? 0 : (this.l.getData().size() - et7Var.F().size()) + this.l.getHeaderViewsCount())) - 2 : 0);
        } else if (i3 != 3) {
            if (i3 == 4) {
                this.Y1 = false;
            } else if (i3 == 5) {
                this.l.setSelection(0);
            } else if (i3 != 6) {
                if (i3 == 8) {
                    if (i4 == 0) {
                        fy7 fy7Var = this.t;
                        if (fy7Var != null && fy7Var.c() != null) {
                            if (this.c.getBaseFragmentActivity().isUseStyleImmersiveSticky()) {
                                this.l.setSelectionFromTop((this.E.B() + this.l.getHeaderViewsCount()) - 1, this.t.d() - qi.s(this.c.getPageContext().getPageActivity()));
                            } else {
                                this.l.setSelectionFromTop((this.E.B() + this.l.getHeaderViewsCount()) - 1, this.t.d());
                            }
                        } else {
                            this.l.setSelection(this.E.B() + this.l.getHeaderViewsCount());
                        }
                    } else if (ListUtils.isEmpty(et7Var.R())) {
                        this.l.setSelection(i4 > 0 ? i4 + ((this.l.getData() == null && et7Var.F() == null) ? 0 : (this.l.getData().size() - et7Var.F().size()) + this.l.getHeaderViewsCount()) : 0);
                    } else {
                        this.l.setSelection(et7Var.F().size() + this.l.getHeaderViewsCount());
                    }
                    this.K.f();
                    this.K.C(this.c.getString(R.string.obfuscated_res_0x7f0f0dd8));
                    this.K.x();
                }
            } else if (i5 == 1 && (e3 = bx7.b().e()) != null && !(e3 instanceof RecyclerView.SavedState)) {
                this.l.onRestoreInstanceState(e3);
            } else {
                this.l.setSelection(0);
            }
        } else if (i5 == 1 && (e2 = bx7.b().e()) != null && !(e2 instanceof RecyclerView.SavedState)) {
            this.l.post(new j0(this, e2, F, et7Var));
        }
        if (this.f1 == j2 && N1()) {
            j0();
        }
        if (this.l1) {
            H2();
            this.l1 = false;
            if (i5 == 0) {
                k3(true);
            }
        }
        if (et7Var.d == 1 || et7Var.e == 1) {
            if (this.r1 == null) {
                this.r1 = new PbTopTipView(this.c.getContext());
            }
            if (et7Var.e == 1 && "game_guide".equals(this.c.V5())) {
                this.r1.setText(this.c.getString(R.string.obfuscated_res_0x7f0f0dea));
                this.r1.l(this.d, this.Q0);
            } else if (et7Var.d == 1 && "game_news".equals(this.c.V5())) {
                this.r1.setText(this.c.getString(R.string.obfuscated_res_0x7f0f0de9));
                this.r1.l(this.d, this.Q0);
            }
        }
        this.l.removeFooterView(this.K1.a());
        if (!ListUtils.isEmpty(et7Var.I()) && et7Var.y().b() == 0) {
            this.l.removeFooterView(this.a1);
            this.K1.d(Math.max(this.t0.getMeasuredHeight(), this.K0 / 2));
            this.l.addFooterView(this.K1.a());
            this.K1.f(et7Var);
        }
        J2(et7Var);
        if (et7Var.g0() && this.c.K().H2() && this.c.R5() != null) {
            this.c.R5().d();
        }
        if (et7Var.g() != 3) {
            D1(et7Var);
        }
        this.x0.setText(TbSingleton.getInstance().getAdVertiComment(et7Var.n0(), et7Var.o0(), e1()));
        if (this.p != null && (et7Var2 = this.N0) != null && et7Var2.l() != null) {
            this.p.m(this.N0.l().getImage_url());
            this.p.n(this.N0.l().getName());
            PbFragment pbFragment3 = this.c;
            if (pbFragment3 != null && pbFragment3.K() != null) {
                this.p.o(this.c.K().b);
            }
        }
        if (this.r != null) {
            et7 et7Var3 = this.N0;
            if (et7Var3 != null && et7Var3.l() != null && (pbFragment = this.c) != null && pbFragment.K() != null) {
                this.r.q(this.c.K().b);
            }
            et7 et7Var4 = this.N0;
            if (et7Var4 == null || et7Var4.O() == null || ListUtils.isEmpty(this.N0.O().getThreadRecommendInfoDataList())) {
                return;
            }
            this.r.p(this.N0.O().getThreadRecommendInfoDataList().get(0));
        }
    }

    public final int V0(boolean z2) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048660, this, z2)) == null) {
            PbInterviewStatusView pbInterviewStatusView = this.T0;
            if (pbInterviewStatusView != null && pbInterviewStatusView.getVisibility() == 0 && z2) {
                return 0 + qi.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f07026a);
            }
            return 0;
        }
        return invokeZ.intValue;
    }

    public /* synthetic */ void V1() {
        this.l.post(new Runnable() { // from class: com.repackage.kv7
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // java.lang.Runnable
            public final void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    mx7.this.X1();
                }
            }
        });
    }

    public void V2(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048662, this, editorTools) == null) {
            this.m0 = editorTools;
            editorTools.setOnCancelClickListener(new o(this));
            this.m0.setId(R.id.obfuscated_res_0x7f0917bb);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            if (this.m0.getParent() == null) {
                this.d.addView(this.m0, layoutParams);
            }
            this.m0.w(TbadkCoreApplication.getInst().getSkinType());
            this.m0.setActionListener(24, new p(this));
            q1();
            this.c.O5().i(new q(this));
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public final void V3(et7 et7Var, boolean z2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048663, this, new Object[]{et7Var, Boolean.valueOf(z2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) || et7Var == null || et7Var.O() == null) {
            return;
        }
        if (this.c.u0()) {
            if (et7Var.h() != null) {
                this.i0 = et7Var.h().c();
                this.j0 = et7Var.h().d();
            }
            if (this.i0 == null && this.c.K() != null && this.c.K().r1() != null) {
                this.i0 = this.c.K().r1();
            }
        }
        PostData I0 = I0(et7Var, z2);
        t3(I0, et7Var);
        this.w.H(8);
        if (et7Var.u0()) {
            this.n1 = true;
            this.h.B(true);
            this.h.a.hideBottomLine();
            if (this.t == null) {
                this.t = new fy7(this.c);
            }
            this.t.v(et7Var, I0, this.l, this.w, this.U0, this.h, this.i0, this.F1);
            this.t.s(this.Z1);
            T2();
        } else {
            this.n1 = false;
            this.h.B(false);
            fy7 fy7Var = this.t;
            if (fy7Var != null) {
                fy7Var.p(this.l);
            }
        }
        if (this.c.P5() != null) {
            this.c.P5().w(this.n1);
        }
        if (I0 == null) {
            return;
        }
        this.O0 = I0;
        this.w.H(0);
        SparseArray<Object> u2 = this.w.u();
        u2.put(R.id.obfuscated_res_0x7f091fe8, I0);
        u2.put(R.id.obfuscated_res_0x7f092001, Boolean.FALSE);
        this.x.e(et7Var, this.l);
        this.z.e(et7Var, this.H1, new f0(this));
        this.v.i(et7Var);
        this.u.h(et7Var, this.M0);
        this.u.g(et7Var);
        this.w.I(this.Q0, this.N0, I0, this.Z1);
        if (this.Z0 != null) {
            if (et7Var.i0()) {
                this.Z0.getView().setVisibility(8);
            } else {
                this.Z0.getView().setVisibility(0);
                rt7 rt7Var = new rt7(rt7.i);
                if (et7Var.O() != null) {
                    et7Var.O().getReply_num();
                }
                rt7Var.c = et7Var.g;
                et7Var.c();
                rt7Var.d = this.c.o6();
                rt7Var.g = et7Var.f;
                rt7Var.h = et7Var.O().isQuestionThread();
                this.Z0.h(rt7Var);
            }
        }
        h4(et7Var);
        rg.a().post(new h0(this));
        this.y.e(this.l);
        if (I0.Q) {
            this.y.f(I0.K());
            this.y.b(this.l, this.l.getHeaderViewsCount() <= 1 ? 0 : 1);
        }
        uv7 uv7Var = this.E;
        if (uv7Var != null && uv7Var.z() != null) {
            this.E.z().F(I0.Q);
        }
        uv7 uv7Var2 = this.E;
        if (uv7Var2 != null) {
            uv7Var2.s0(I0.Q);
        }
        this.L1.setVisibility(I0.Q ? 0 : 8);
    }

    public View W0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048664, this)) == null) ? this.M : (View) invokeV.objValue;
    }

    public /* synthetic */ void W1() {
        if (this.c.Q6()) {
            return;
        }
        this.l.post(new Runnable() { // from class: com.repackage.mv7
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // java.lang.Runnable
            public final void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    mx7.this.Y1();
                }
            }
        });
    }

    public void W2(String str) {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048666, this, str) == null) || (pbListView = this.K) == null) {
            return;
        }
        pbListView.C(str);
    }

    public void W3(wr4.c cVar, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048667, this, cVar, z2) == null) {
            ds4 ds4Var = this.e0;
            if (ds4Var != null) {
                ds4Var.dismiss();
                this.e0 = null;
            }
            fs4 fs4Var = new fs4(this.c.getContext());
            ArrayList arrayList = new ArrayList();
            et7 et7Var = this.N0;
            if (et7Var != null && et7Var.O() != null && !this.N0.O().isBjh()) {
                arrayList.add(new bs4(0, this.c.getPageContext().getString(R.string.obfuscated_res_0x7f0f108e), fs4Var));
            }
            if (!z2) {
                arrayList.add(new bs4(1, this.c.getPageContext().getString(R.string.obfuscated_res_0x7f0f108f), fs4Var));
            }
            fs4Var.j(arrayList);
            fs4Var.n(new d0(this, cVar));
            ds4 ds4Var2 = new ds4(this.c.getPageContext(), fs4Var);
            this.e0 = ds4Var2;
            ds4Var2.k();
        }
    }

    public PbListView X0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048668, this)) == null) ? this.K : (PbListView) invokeV.objValue;
    }

    public /* synthetic */ void X1() {
        kw7 kw7Var = this.p;
        if (kw7Var != null) {
            kw7Var.p();
        }
    }

    public void X2(String str) {
        PbReplyTitleViewHolder pbReplyTitleViewHolder;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048670, this, str) == null) || this.K == null) {
            return;
        }
        int i3 = 0;
        w0 w0Var = this.d1;
        if (w0Var != null && (pbReplyTitleViewHolder = w0Var.c) != null && pbReplyTitleViewHolder.getView() != null) {
            i3 = this.d1.c.getView().getTop() < 0 ? this.d1.c.getView().getHeight() : this.d1.c.getView().getBottom();
        }
        this.K.F(str, i3);
    }

    public void X3(wr4.c cVar, boolean z2, boolean z3, boolean z4, boolean z5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048671, this, new Object[]{cVar, Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), Boolean.valueOf(z5)}) == null) {
            ds4 ds4Var = this.d0;
            if (ds4Var != null) {
                ds4Var.dismiss();
                this.d0 = null;
            }
            fs4 fs4Var = new fs4(this.c.getContext());
            ArrayList arrayList = new ArrayList();
            if (!z4 && !z5) {
                arrayList.add(new bs4(0, this.c.getPageContext().getString(R.string.obfuscated_res_0x7f0f044d), fs4Var));
            }
            if (z3) {
                arrayList.add(new bs4(1, this.c.getPageContext().getString(R.string.obfuscated_res_0x7f0f0ff7), fs4Var));
            } else if (!z2) {
                arrayList.add(new bs4(1, this.c.getPageContext().getString(R.string.obfuscated_res_0x7f0f0a91), fs4Var));
            } else {
                arrayList.add(new bs4(1, this.c.getPageContext().getString(R.string.obfuscated_res_0x7f0f0fd2), fs4Var));
            }
            fs4Var.j(arrayList);
            fs4Var.n(new c0(this, cVar));
            ds4 ds4Var2 = new ds4(this.c.getPageContext(), fs4Var);
            this.e0 = ds4Var2;
            ds4Var2.k();
        }
    }

    public int Y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048672, this)) == null) {
            try {
                return Integer.parseInt(this.I.getText().toString(), 10);
            } catch (Exception unused) {
                return -1;
            }
        }
        return invokeV.intValue;
    }

    public /* synthetic */ void Y1() {
        ix7 ix7Var = this.r;
        if (ix7Var != null) {
            ix7Var.r();
        }
    }

    public final void Y2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048674, this) == null) {
            this.M1.setFallingFeedbackListener(new FallingView.l() { // from class: com.repackage.lv7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.pb.view.FallingView.l
                public final void onClick() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        mx7.this.Z1();
                    }
                }
            });
        }
    }

    public void Y3(AdapterView.OnItemClickListener onItemClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048675, this, onItemClickListener) == null) {
            yr4 yr4Var = this.f0;
            if (yr4Var != null) {
                yr4Var.d();
                this.f0 = null;
            }
            if (this.N0 == null) {
                return;
            }
            ArrayList<hs4> arrayList = new ArrayList<>();
            arrayList.add(new hs4(this.c.getContext().getString(R.string.obfuscated_res_0x7f0f0270), "", this.N0.L() == 1, Integer.toString(1)));
            arrayList.add(new hs4(this.c.getContext().getString(R.string.obfuscated_res_0x7f0f0b40), "", this.N0.L() == 2, Integer.toString(5)));
            arrayList.add(new hs4(this.c.getContext().getString(R.string.obfuscated_res_0x7f0f0b3d), "", this.N0.L() == 3, Integer.toString(6)));
            arrayList.add(new hs4(this.c.getContext().getString(R.string.obfuscated_res_0x7f0f0b5b), "", this.N0.L() == 4, Integer.toString(7)));
            yr4 yr4Var2 = new yr4(this.c.getPageContext());
            yr4Var2.l(R.string.obfuscated_res_0x7f0f0de6);
            this.f0 = yr4Var2;
            yr4Var2.k(arrayList, onItemClickListener);
            yr4Var2.c();
            this.f0.n();
        }
    }

    public View Z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048676, this)) == null) ? this.W0 : (View) invokeV.objValue;
    }

    public /* synthetic */ void Z1() {
        String e1;
        PbFragment pbFragment = this.c;
        if (pbFragment != null && pbFragment.K() != null && this.c.K().A2()) {
            e1 = this.c.getString(R.string.obfuscated_res_0x7f0f0ded);
        } else {
            e1 = e1();
        }
        if (!StringUtils.isNull(e1) && this.N0 != null) {
            e1 = TbSingleton.getInstance().getAdVertiComment(this.N0.n0(), this.N0.o0(), e1);
        }
        PbFragment pbFragment2 = this.c;
        if (pbFragment2 != null && pbFragment2.O5() != null) {
            this.c.O5().m0(e1);
        }
        TextView textView = this.x0;
        if (textView != null) {
            textView.setText(e1);
        }
        J3(false);
        d4();
    }

    public void Z2(PbFragment.h3 h3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048678, this, h3Var) == null) {
            this.X1 = h3Var;
        }
    }

    public void Z3() {
        PostData postData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048679, this) == null) || !TbadkCoreApplication.isLogin() || this.N0 == null || !this.o1 || this.n1 || this.h0 || (postData = this.O0) == null || postData.s() == null || this.O0.s().getIsLike() || this.O0.s().hadConcerned() || this.k1 != null) {
            return;
        }
        this.k1 = new ex7(this.c);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048682, this)) == null) ? this.i1 : (PbFakeFloorModel) invokeV.objValue;
    }

    public final void a2() {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048683, this) == null) || (imageView = this.w0) == null) {
            return;
        }
        imageView.setImageResource(R.drawable.obfuscated_res_0x7f08099c);
    }

    public void a3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048684, this, z2) == null) {
            this.n0 = z2;
        }
    }

    public final void a4(ur4 ur4Var, int i3) {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048685, this, ur4Var, i3) == null) || (pbFragment = this.c) == null || ur4Var == null) {
            return;
        }
        if (this.B1 == null && this.u != null) {
            this.B1 = new yk5(pbFragment.getPageContext(), this.u.c());
        }
        AntiData v5 = this.c.v5();
        SparseArray<String> sparseArray = new SparseArray<>();
        if (v5 != null && v5.getDelThreadInfoList() != null) {
            List<DeleteThreadInfo> delThreadInfoList = v5.getDelThreadInfoList();
            for (int i4 = 0; i4 < delThreadInfoList.size(); i4++) {
                if (!TextUtils.isEmpty(delThreadInfoList.get(i4).text_info)) {
                    sparseArray.put(delThreadInfoList.get(i4).text_id, delThreadInfoList.get(i4).text_info);
                }
            }
        }
        cq4 cq4Var = new cq4();
        cq4Var.j(sparseArray);
        this.B1.y(new String[]{this.c.getString(R.string.obfuscated_res_0x7f0f04bf), this.c.getString(R.string.obfuscated_res_0x7f0f04c0), this.c.getString(R.string.obfuscated_res_0x7f0f04c1), this.c.getString(R.string.obfuscated_res_0x7f0f04c2), this.c.getString(R.string.obfuscated_res_0x7f0f04c3)});
        this.B1.x(cq4Var);
        this.B1.A((i3 == 1 || i3 == 2) ? "4" : "3");
        this.B1.z(new y(this, ur4Var));
    }

    public void b0() {
        w18 w18Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048686, this) == null) || (w18Var = this.F0) == null) {
            return;
        }
        w18Var.m(false);
    }

    public gw7 b1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048687, this)) == null) ? this.j1 : (gw7) invokeV.objValue;
    }

    public final void b2() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048688, this) == null) || (pbFragment = this.c) == null || pbFragment.K() == null || this.c.K().G == null || this.c.K().G.O() == null || !this.c.K().G.O().isQuestionThread()) {
            return;
        }
        ThreadData O = this.c.K().G.O();
        String e2 = this.c.K().e2();
        String f2 = this.c.K().f2();
        int i3 = 5;
        if ("question_answer_invite".equals(e2)) {
            i3 = 1;
        } else if ("3".equals(f2)) {
            i3 = 2;
        } else if ("answer_top".equals(e2)) {
            i3 = 3;
        } else if (this.c.K().x1()) {
            i3 = 4;
        }
        TiebaStatic.log(new StatisticItem("c14924").param("uid", TbadkCoreApplication.getCurrentAccountId()).param("tid", O.getId()).param("fid", O.getFid()).param("obj_source", i3));
    }

    public void b3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048689, this, z2) == null) {
            this.E.j0(z2);
        }
    }

    public void b4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048690, this) == null) {
            this.O.setVisibility(0);
        }
    }

    public boolean c0(boolean z2) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048691, this, z2)) == null) {
            EditorTools editorTools = this.m0;
            if (editorTools == null || !editorTools.u()) {
                return false;
            }
            this.m0.q();
            return true;
        }
        return invokeZ.booleanValue;
    }

    public fy7 c1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048692, this)) == null) ? this.t : (fy7) invokeV.objValue;
    }

    public void c2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048693, this) == null) {
            J2(this.N0);
        }
    }

    public void c3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048694, this, z2) == null) {
            this.G1 = z2;
        }
    }

    public void c4() {
        uv7 uv7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048695, this) == null) || (uv7Var = this.E) == null) {
            return;
        }
        uv7Var.B0();
    }

    public boolean d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048696, this)) == null) {
            PbListView pbListView = this.K;
            if (pbListView == null || TextUtils.isEmpty(pbListView.h())) {
                return false;
            }
            return this.K.h().equals(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f09e9));
        }
        return invokeV.booleanValue;
    }

    public final PostData d1(et7 et7Var) {
        InterceptResult invokeL;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048697, this, et7Var)) == null) {
            if (et7Var == null || et7Var.O() == null || et7Var.O().getAuthor() == null) {
                return null;
            }
            PostData postData = new PostData();
            MetaData author = et7Var.O().getAuthor();
            String userId = author.getUserId();
            HashMap<String, MetaData> userMap = et7Var.O().getUserMap();
            if (userMap != null && (metaData = userMap.get(userId)) != null && metaData.getUserId() != null) {
                author = metaData;
            }
            postData.C0(1);
            postData.I0(et7Var.O().getFirstPostId());
            postData.Z0(et7Var.O().getTitle());
            postData.Y0(et7Var.O().getCreateTime());
            postData.A0(author);
            return postData;
        }
        return (PostData) invokeL.objValue;
    }

    public final void d2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048698, this) == null) && UbsABTestHelper.isShareTopRight()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.B0.getLayoutParams();
            layoutParams.addRule(11);
            this.B0.setLayoutParams(layoutParams);
            if (this.C0.getParent() != null) {
                ((ViewGroup) this.C0.getParent()).removeView(this.C0);
                ((ViewGroup) this.D0.getParent()).removeView(this.D0);
            }
            if (this.E0.getParent() != null) {
                ((ViewGroup) this.E0.getParent()).removeView(this.E0);
            }
            RelativeLayout relativeLayout = new RelativeLayout(TbadkCoreApplication.getInst().getContext());
            relativeLayout.addView(this.C0);
            relativeLayout.addView(this.D0);
            relativeLayout.addView(this.E0);
            this.h.a.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, relativeLayout, (View.OnClickListener) null);
            this.h.a.getViewGroup(NavigationBar.ControlAlign.HORIZONTAL_RIGHT).setClipChildren(false);
        }
    }

    public void d3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048699, this, z2) == null) {
            this.y1 = z2;
        }
    }

    public final void d4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048700, this) == null) {
            FallingView fallingView = this.M1;
            if (fallingView != null) {
                fallingView.setTag(Boolean.TRUE);
            }
            RightFloatLayerView rightFloatLayerView = this.N1;
            if (rightFloatLayerView != null && rightFloatLayerView.getTag() == this.M1) {
                this.N1.setTag(null);
                this.N1.setAutoCompleteShown(true);
                this.N1.d();
            }
        }
    }

    public final void e0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048701, this) == null) || this.N0 == null || !UbsABTestHelper.isResizeInduceSharingABTest() || gz7.k(this.N0.Q())) {
            return;
        }
        this.F0.f();
        gz7.b(this.N0.Q());
    }

    public String e1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048702, this)) == null) {
            if (!pi.isEmpty(this.D1)) {
                return this.D1;
            }
            if (this.c != null) {
                this.D1 = TbadkCoreApplication.getInst().getResources().getString(kx7.b());
            }
            return this.D1;
        }
        return (String) invokeV.objValue;
    }

    public void e2(boolean z2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048703, this, new Object[]{Boolean.valueOf(z2), Integer.valueOf(i3)}) == null) {
            jw7 jw7Var = this.q;
            if (jw7Var != null) {
                jw7Var.b();
            }
            hx7 hx7Var = this.s;
            if (hx7Var != null) {
                hx7Var.b(z2, i3);
            }
        }
    }

    public void e3(boolean z2) {
        fy7 fy7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048704, this, z2) == null) || (fy7Var = this.t) == null) {
            return;
        }
        fy7Var.r(z2);
    }

    public void e4() {
        w18 w18Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048705, this) == null) || (w18Var = this.F0) == null) {
            return;
        }
        w18Var.o(2);
    }

    public void f0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048706, this) == null) {
            if (!this.c.checkUpIsLogin()) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 2).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                TiebaStatic.log(new StatisticItem("c10517").param("obj_locate", 2).param("fid", this.j0));
            } else if (!this.c.f5()) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 8).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
            } else {
                k45 O5 = this.c.O5();
                if (O5 != null && (O5.B() || O5.D())) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 10).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                    this.c.O5().z(false, null);
                    return;
                }
                if (this.m0 != null) {
                    B1();
                }
                EditorTools editorTools = this.m0;
                if (editorTools != null) {
                    this.J0 = false;
                    if (editorTools.n(2) != null) {
                        mk8.c(this.c.getPageContext(), (View) this.m0.n(2).m, false, r2);
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
            if (pbReplyTitleViewHolder == null || pbReplyTitleViewHolder.getView() == null) {
                return 0;
            }
            if (pbReplyTitleViewHolder.getView().getTop() != 0 || pbReplyTitleViewHolder.getView().isShown()) {
                return pbReplyTitleViewHolder.getView().getBottom();
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public void f2(rk8 rk8Var) {
        et7 et7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048708, this, rk8Var) == null) || rk8Var == null || rk8Var.a == null || rk8Var.b == null || (et7Var = this.N0) == null || et7Var.O() == null || this.N0.O().getAgreeData() == null) {
            return;
        }
        AgreeData agreeData = this.N0.O().getAgreeData();
        String str = rk8Var.b.nid;
        if (!TextUtils.isEmpty(str) && !"0".equals(str)) {
            BaijiahaoData baijiahaoData = agreeData.baijiahaoData;
            if (baijiahaoData == null || !TextUtils.equals(str, baijiahaoData.oriUgcNid)) {
                return;
            }
        } else {
            String str2 = rk8Var.b.threadId;
            String str3 = agreeData.threadId;
            if ("0".equals(str2) || TextUtils.isEmpty(str2) || !TextUtils.equals(str2, str3)) {
                return;
            }
        }
        AgreeData agreeData2 = rk8Var.b;
        I2(agreeData2, agreeData2.agreeNum);
    }

    public void f3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048709, this, z2) == null) {
            this.E.l0(z2);
        }
    }

    public void f4(gq4 gq4Var, ur4.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048710, this, gq4Var, eVar) == null) || gq4Var == null) {
            return;
        }
        int a2 = gq4Var.a();
        int h2 = gq4Var.h();
        ur4 ur4Var = this.F;
        if (ur4Var != null) {
            ur4Var.show();
        } else {
            this.F = new ur4(this.c.getPageContext().getPageActivity());
            View inflate = LayoutInflater.from(this.c.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0226, (ViewGroup) null);
            this.H = inflate;
            this.F.setContentView(inflate);
            this.F.setPositiveButton(R.string.obfuscated_res_0x7f0f04ee, eVar);
            this.F.setNegativeButton(R.string.obfuscated_res_0x7f0f04e9, new l0(this));
            this.F.setOnCalcelListener(new m0(this));
            this.F.create(this.c.getPageContext()).show();
        }
        EditText editText = (EditText) this.H.findViewById(R.id.obfuscated_res_0x7f090f14);
        this.I = editText;
        editText.setText("");
        TextView textView = (TextView) this.H.findViewById(R.id.obfuscated_res_0x7f09072e);
        if (a2 <= 0) {
            a2 = 1;
        }
        if (h2 <= 0) {
            h2 = 1;
        }
        textView.setText(MessageFormat.format(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f047c), Integer.valueOf(a2), Integer.valueOf(h2)));
        this.c.getBaseFragmentActivity().ShowSoftKeyPadDelay(this.I, 150);
    }

    public void g0(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048711, this, z2) == null) {
            if (z2) {
                SkinManager.setBackgroundColor(this.l, R.color.CAM_X0202);
            } else {
                this.l.setBackgroundResource(0);
            }
            View view2 = this.p0;
            if (view2 != null) {
                view2.setVisibility(z2 ? 8 : 0);
            }
            PbListView pbListView = this.K;
            if (pbListView != null) {
                pbListView.K(z2 ? 8 : 0);
            }
            View view3 = this.M;
            if (view3 != null) {
                view3.setVisibility(z2 ? 8 : 0);
            }
        }
    }

    public int g1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048712, this)) == null) ? R.id.obfuscated_res_0x7f091bd2 : invokeV.intValue;
    }

    public void g2(int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048713, this, i3) == null) || this.Q0 == i3) {
            return;
        }
        this.Q0 = i3;
        i4(this.N0, this.M0);
        L2(this.N0, this.M0, this.P0, i3);
        this.c.getBaseFragmentActivity().getLayoutMode().l(i3 == 1);
        this.c.getBaseFragmentActivity().getLayoutMode().k(this.d);
        SkinManager.setBackgroundColor(this.d, R.color.CAM_X0201);
        SkinManager.setBackgroundColor(this.o0, R.color.CAM_X0203);
        fy7 fy7Var = this.t;
        if (fy7Var != null) {
            fy7Var.h(i3);
        }
        by7 by7Var = this.x;
        if (by7Var != null) {
            by7Var.c(i3);
        }
        ay7 ay7Var = this.u;
        if (ay7Var != null) {
            ay7Var.e(i3);
        }
        cy7 cy7Var = this.v;
        if (cy7Var != null) {
            cy7Var.f(i3);
        }
        ey7 ey7Var = this.w;
        if (ey7Var != null) {
            ey7Var.y(i3);
        }
        dy7 dy7Var = this.y;
        if (dy7Var != null) {
            dy7Var.d();
        }
        zx7 zx7Var = this.z;
        if (zx7Var != null) {
            zx7Var.c();
        }
        MaskView maskView = this.L1;
        if (maskView != null) {
            maskView.f();
        }
        ix7 ix7Var = this.r;
        if (ix7Var != null) {
            ix7Var.n();
        }
        PbListView pbListView = this.K;
        if (pbListView != null) {
            pbListView.d(i3);
        }
        if (this.M != null) {
            this.c.getBaseFragmentActivity().getLayoutMode().k(this.M);
            SkinManager.setBackgroundResource(this.M, R.drawable.pb_foot_more_trans_selector);
        }
        if (this.N != null) {
            this.c.getBaseFragmentActivity().getLayoutMode().k(this.N);
            SkinManager.setBackgroundResource(this.N, R.drawable.pb_foot_more_trans_selector);
        }
        ur4 ur4Var = this.F;
        if (ur4Var != null) {
            ur4Var.autoChangeSkinType(this.c.getPageContext());
        }
        n4(this.g0);
        this.E.a0();
        x18 x18Var = this.J;
        if (x18Var != null) {
            x18Var.H(i3);
        }
        EditorTools editorTools = this.m0;
        if (editorTools != null) {
            editorTools.w(i3);
        }
        t18 t18Var = this.L;
        if (t18Var != null) {
            t18Var.f(i3);
        }
        if (!ListUtils.isEmpty(this.n)) {
            for (CustomBlueCheckRadioButton customBlueCheckRadioButton : this.n) {
                customBlueCheckRadioButton.c();
            }
        }
        t4();
        UtilHelper.setStatusBarBackground(this.e, i3);
        UtilHelper.setStatusBarBackground(this.Y0, i3);
        if (this.A != null) {
            fb5.a(this.c.getPageContext(), this.A);
        }
        gw7 gw7Var = this.j1;
        if (gw7Var != null) {
            gw7Var.h(i3);
        }
        mz7 mz7Var = this.h;
        if (mz7Var != null) {
            fy7 fy7Var2 = this.t;
            if (fy7Var2 != null) {
                fy7Var2.i(i3);
            } else {
                mz7Var.v(i3);
            }
        }
        HeadImageView headImageView = this.v0;
        if (headImageView != null) {
            headImageView.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
        }
        LinearLayout linearLayout = this.u0;
        if (linearLayout != null) {
            linearLayout.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(qi.f(this.c.getContext(), R.dimen.tbds47), SkinManager.getColor(R.color.CAM_X0209)));
        }
        et7 et7Var = this.N0;
        if (et7Var != null && et7Var.r()) {
            WebPManager.setPureDrawable(this.B0, R.drawable.obfuscated_res_0x7f08095f, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
        } else {
            WebPManager.setPureDrawable(this.B0, R.drawable.obfuscated_res_0x7f08095e, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        }
        WebPManager.setPureDrawable(this.z0, R.drawable.obfuscated_res_0x7f080961, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        WebPManager.setPureDrawable(this.w0, R.drawable.obfuscated_res_0x7f08099c, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL);
        r4(this.N0);
        if (this.E0.getVisibility() == 0) {
            this.E0.setBackgroundDrawable(SkinManager.createShapeDrawable(qi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds15), R.color.CAM_X0301, 0, 0, i3));
        }
        SkinManager.setBackgroundColor(this.t0, R.color.CAM_X0207);
        SkinManager.setBackgroundColor(this.s0, R.color.CAM_X0203);
        SkinManager.setViewTextColor(this.t1, (int) R.color.cp_cont_n);
        SkinManager.setViewTextColor(this.x0, (int) R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.I0, (int) R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.H0, (int) R.color.CAM_X0107);
        SkinManager.setBackgroundShapeDrawable(this.H0, qi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18), R.color.CAM_X0207, R.color.CAM_X0207);
        SkinManager.setViewTextColor(this.G0, (int) R.color.CAM_X0107);
        SkinManager.setBackgroundShapeDrawable(this.G0, qi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18), R.color.CAM_X0207, R.color.CAM_X0207);
        AgreeView agreeView = this.A0;
        if (agreeView != null) {
            agreeView.s();
            this.A0.L(i3);
            AgreeData data = this.A0.getData();
            if (data != null) {
                I2(data, data.agreeNum);
            }
        }
        ev7 ev7Var = this.w1;
        if (ev7Var != null) {
            ev7Var.m(i3);
        }
        PbEmotionBar pbEmotionBar = this.e1;
        if (pbEmotionBar != null) {
            pbEmotionBar.w();
        }
        PbThreadPostView pbThreadPostView = this.o;
        if (pbThreadPostView != null) {
            pbThreadPostView.c(i3);
        }
        w18 w18Var = this.F0;
        if (w18Var != null) {
            w18Var.j();
        }
        v18 v18Var = this.K1;
        if (v18Var != null) {
            v18Var.c();
        }
        RightFloatLayerView rightFloatLayerView = this.N1;
        if (rightFloatLayerView != null) {
            rightFloatLayerView.o();
        }
        SkinManager.setBackgroundColor(this.X0, R.color.CAM_X0207);
        SkinManager.setViewTextColor(this.X0.findViewById(R.id.obfuscated_res_0x7f0923b4), (int) R.color.CAM_X0105);
    }

    public void g3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048714, this, z2) == null) {
            this.E.q0(z2);
        }
    }

    public void g4(boolean z2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048715, this, z2) == null) || this.l == null || (textView = this.V0) == null || this.e == null) {
            return;
        }
        if (z2) {
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.e.setVisibility(0);
            } else {
                this.e.setVisibility(8);
                this.l.removeHeaderView(this.V0);
                this.l.setTextViewAdded(false);
            }
            if (this.V0.getLayoutParams() instanceof AbsListView.LayoutParams) {
                AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) this.V0.getLayoutParams();
                layoutParams.height = i2;
                this.V0.setLayoutParams(layoutParams);
            }
            T2();
            return;
        }
        if (textView.getLayoutParams() instanceof AbsListView.LayoutParams) {
            AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.V0.getLayoutParams();
            layoutParams2.height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT) + V0(true);
            this.V0.setLayoutParams(layoutParams2);
        }
        T2();
        M2();
    }

    public final void h0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048716, this) == null) {
            ev7 ev7Var = new ev7(this.c, this, (ViewStub) this.d.findViewById(R.id.obfuscated_res_0x7f091535));
            this.w1 = ev7Var;
            ev7Var.o(this.P);
            this.w1.p(this.T);
            this.w1.q(this.Q);
            this.w1.o(this.P);
            this.w1.s(this.k0);
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

    public void h2(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048718, this, configuration) == null) || configuration == null) {
            return;
        }
        m0();
        if (configuration.orientation == 2) {
            o1();
            q1();
        } else {
            S2();
        }
        gw7 gw7Var = this.j1;
        if (gw7Var != null) {
            gw7Var.c();
        }
        this.c.e6();
        this.D.setVisibility(8);
        this.h.C(false);
        this.c.g7(false);
        if (this.t != null) {
            if (configuration.orientation == 1) {
                l1().setVisibility(0);
            }
            if (configuration.orientation == 2) {
                this.h2 = true;
                this.l.setIsLandscape(true);
                this.l.smoothScrollToPosition(0);
            } else {
                this.h2 = false;
                this.l.setIsLandscape(false);
                int i3 = this.f2;
                if (i3 > 0) {
                    this.l.smoothScrollBy(i3, 0);
                }
            }
            this.t.j(configuration);
            this.U0.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        }
    }

    public void h3(av4.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048719, this, gVar) == null) {
            this.c2 = gVar;
            x18 x18Var = this.J;
            if (x18Var != null) {
                x18Var.f(gVar);
            }
        }
    }

    public final void h4(et7 et7Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048720, this, et7Var) == null) || et7Var == null || et7Var.O() == null || et7Var.O().isVideoThreadType()) {
            return;
        }
        boolean z2 = et7Var.O().getIs_good() == 1;
        boolean z3 = et7Var.O().getIs_top() == 1;
        ey7 ey7Var = this.w;
        if (ey7Var != null) {
            ey7Var.o(et7Var, z2, z3);
        }
        cy7 cy7Var = this.v;
        if (cy7Var != null) {
            cy7Var.b(et7Var, z2, z3);
        }
    }

    public final CustomBlueCheckRadioButton i0(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048721, this, str, str2)) == null) {
            Activity pageActivity = this.c.getPageContext().getPageActivity();
            CustomBlueCheckRadioButton customBlueCheckRadioButton = new CustomBlueCheckRadioButton(pageActivity);
            RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, qi.f(pageActivity, R.dimen.obfuscated_res_0x7f07019a));
            customBlueCheckRadioButton.setOnCheckedChangeListener(this.Z);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048722, this)) == null) ? this.Q0 : invokeV.intValue;
    }

    public void i2() {
        NoNetworkView.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048723, this) == null) {
            kw7 kw7Var = this.p;
            if (kw7Var != null) {
                kw7Var.l();
            }
            ix7 ix7Var = this.r;
            if (ix7Var != null) {
                ix7Var.o();
            }
            RelativeLayout relativeLayout = this.d;
            if (relativeLayout != null && relativeLayout.getHandler() != null) {
                this.d.getHandler().removeCallbacksAndMessages(null);
            }
            w18 w18Var = this.F0;
            if (w18Var != null) {
                w18Var.k();
            }
            ex7 ex7Var = this.k1;
            if (ex7Var != null) {
                ex7Var.a();
            }
            ww7 ww7Var = this.z1;
            if (ww7Var != null) {
                ww7Var.c();
            }
            PbTopTipView pbTopTipView = this.r1;
            if (pbTopTipView != null) {
                pbTopTipView.g();
            }
            this.c.hideProgressBar();
            NoNetworkView noNetworkView = this.m;
            if (noNetworkView != null && (bVar = this.R) != null) {
                noNetworkView.e(bVar);
            }
            mk8.d();
            m0();
            u0();
            if (this.h1 != null) {
                rg.a().removeCallbacks(this.h1);
            }
            PbInterviewStatusView pbInterviewStatusView = this.T0;
            if (pbInterviewStatusView != null) {
                pbInterviewStatusView.m();
            }
            this.U1 = null;
            this.g.removeCallbacksAndMessages(null);
            this.E.b0(3);
            View view2 = this.e;
            if (view2 != null) {
                view2.setBackgroundDrawable(null);
            }
            fy7 fy7Var = this.t;
            if (fy7Var != null) {
                fy7Var.a();
            }
            uv7 uv7Var = this.E;
            if (uv7Var != null) {
                uv7Var.d0();
            }
            this.l.setOnLayoutListener(null);
            ky7 ky7Var = this.v1;
            if (ky7Var != null) {
                ky7Var.l();
            }
            PbEmotionBar pbEmotionBar = this.e1;
            if (pbEmotionBar != null) {
                pbEmotionBar.x();
            }
            ey7 ey7Var = this.w;
            if (ey7Var != null) {
                ey7Var.z();
            }
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView != null) {
                pbLandscapeListView.getViewTreeObserver().removeGlobalOnLayoutListener(this.a);
            }
        }
    }

    public void i3(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048724, this, onClickListener) == null) {
            this.d2 = onClickListener;
            uv7 uv7Var = this.E;
            if (uv7Var != null) {
                uv7Var.r0(onClickListener);
            }
        }
    }

    @SuppressLint({"CutPasteId"})
    public void i4(et7 et7Var, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048725, this, et7Var, z2) == null) || et7Var == null) {
            return;
        }
        s4(et7Var, z2);
        p0();
    }

    public void j0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048726, this) == null) || this.g2) {
            return;
        }
        TiebaStatic.log("c10490");
        this.g2 = true;
        ur4 ur4Var = new ur4(this.c.getPageContext().getPageActivity());
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(k2, Integer.valueOf(m2));
        ur4Var.setTitle(R.string.obfuscated_res_0x7f0f07f4);
        View inflate = LayoutInflater.from(this.c.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0896, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090c3a)).setText(R.string.obfuscated_res_0x7f0f0791);
        ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0921ec)).setText(R.string.obfuscated_res_0x7f0f07f4);
        ur4Var.setContentView(inflate);
        ur4Var.setYesButtonTag(sparseArray);
        ur4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f07f3, this.c);
        ur4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0a6c, new n0(this));
        ur4Var.create(this.c.getPageContext()).show();
    }

    public View j1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048727, this)) == null) ? this.e : (View) invokeV.objValue;
    }

    public void j2(TbRichText tbRichText) {
        et7 et7Var;
        PostData postData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048728, this, tbRichText) == null) || (et7Var = this.N0) == null || et7Var.F() == null || this.N0.F().isEmpty() || tbRichText == null || StringUtils.isNull(tbRichText.getAuthorId())) {
            return;
        }
        for (int i3 = 0; i3 < this.N0.F().size() && (postData = this.N0.F().get(i3)) != null && postData.s() != null && !StringUtils.isNull(postData.s().getUserId()); i3++) {
            if (this.N0.F().get(i3).s().getUserId().equals(tbRichText.getAuthorId())) {
                ev7 ev7Var = this.w1;
                if (ev7Var != null && ev7Var.l()) {
                    J3(false);
                }
                PbEmotionBar pbEmotionBar = this.e1;
                if (pbEmotionBar != null) {
                    pbEmotionBar.q(true);
                }
                postData.s().getName_show();
                return;
            }
        }
    }

    public void j3(String str) {
        lz7 lz7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048729, this, str) == null) || (lz7Var = this.i) == null) {
            return;
        }
        lz7Var.b(str);
    }

    public void j4(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048730, this, str) == null) {
            this.c.showToast(str);
        }
    }

    public void k0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048731, this, str) == null) {
            if (str.contains("_")) {
                str = str.replace("_", "\n");
            }
            ur4 ur4Var = new ur4(this.c.getPageContext().getPageActivity());
            View inflate = LayoutInflater.from(this.c.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0896, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0921ec);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(0, 0, 0, 0);
            textView.setLayoutParams(layoutParams);
            textView.setGravity(3);
            textView.setText(str);
            ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090c3a)).setVisibility(8);
            ur4Var.setContentView(inflate);
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(k2, Integer.valueOf(n2));
            ur4Var.setYesButtonTag(sparseArray);
            ur4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f1540, this.c);
            ur4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0370, new o0(this));
            ur4Var.create(this.c.getPageContext()).show();
        }
    }

    public PbThreadPostView k1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048732, this)) == null) ? this.o : (PbThreadPostView) invokeV.objValue;
    }

    public boolean k2(int i3) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048733, this, i3)) == null) {
            fy7 fy7Var = this.t;
            if (fy7Var != null) {
                return fy7Var.k(i3);
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public void k3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048734, this, z2) == null) {
            this.l1 = z2;
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView != null) {
                this.m1 = pbLandscapeListView.getHeaderViewsCount();
            }
        }
    }

    public void k4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048735, this) == null) {
            this.c.showProgressBar();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x004d, code lost:
        if (r5.I1 == 1) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void l0() {
        v18 v18Var;
        boolean z2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048736, this) == null) || (v18Var = this.K1) == null) {
            return;
        }
        if (((v18Var.a() == null || this.K1.a().getParent() == null) ? -1 : this.l.getPositionForView(this.K1.a())) != -1) {
            if (this.K1.a().getTop() + p2 <= this.W0.getBottom()) {
                this.I1 = 1;
                z2 = true;
            } else {
                this.I1 = 0;
                z2 = false;
            }
        }
        this.Z0.t(this.I1 == 1);
        this.K1.e(z2);
    }

    public RelativeLayout l1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048737, this)) == null) ? this.D : (RelativeLayout) invokeV.objValue;
    }

    public void l2() {
        PostData postData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048738, this) == null) || this.c == null) {
            return;
        }
        if ((this.G1 || this.H1 == 17) && UbsABTestHelper.leftSlideToFrs()) {
            et7 et7Var = this.N0;
            if (et7Var == null || et7Var.l() == null || pi.isEmpty(this.N0.l().getName())) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.c.getContext()).createNormalCfg(this.N0.l().getName(), null)));
            TiebaStatic.log(new StatisticItem("c13853").param("post_id", this.N0.Q()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("fid", this.N0.l().getId()));
        } else if (!this.o1 || this.n1 || (postData = this.O0) == null || postData.s() == null) {
        } else {
            TiebaStatic.log(new StatisticItem("c12601").param("obj_locate", this.c.u0() ? 2 : 1).param("obj_type", this.n1 ? 2 : 1));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.c.getPageContext().getPageActivity(), this.O0.s().getUserId(), this.O0.s().getUserName(), this.c.K().r1(), AddFriendActivityConfig.TYPE_PB_HEAD)));
        }
    }

    public void l3(PbFragment.i3 i3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048739, this, i3Var) == null) {
        }
    }

    public void l4() {
        FallingView fallingView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048740, this) == null) || (fallingView = this.M1) == null) {
            return;
        }
        fallingView.F();
    }

    public void m0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048741, this) == null) {
            this.h.k();
            ey7 ey7Var = this.w;
            if (ey7Var != null) {
                ey7Var.p();
            }
            PbFragment pbFragment = this.c;
            if (pbFragment != null) {
                qi.x(pbFragment.getContext(), this.I);
            }
            q1();
            ds4 ds4Var = this.d0;
            if (ds4Var != null) {
                ds4Var.dismiss();
            }
            q0();
            ur4 ur4Var = this.F;
            if (ur4Var != null) {
                ur4Var.dismiss();
            }
            wr4 wr4Var = this.G;
            if (wr4Var != null) {
                wr4Var.e();
            }
        }
    }

    public View m1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048742, this)) == null) ? this.d : (View) invokeV.objValue;
    }

    public void m2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048743, this, z2) == null) {
            if (z2) {
                P3();
            } else {
                r1();
            }
            this.d1.c = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.d1));
            F2(this.d1.c, false);
        }
    }

    public void m3(TbRichTextView.y yVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048744, this, yVar) == null) {
            this.Q = yVar;
            this.E.v0(yVar);
            this.w1.q(this.Q);
        }
    }

    public void m4() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048745, this) == null) || this.e2 == null) {
            return;
        }
        while (this.e2.size() > 0) {
            TbImageView remove = this.e2.remove(0);
            if (remove != null) {
                remove.O();
            }
        }
    }

    public void n0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048746, this) == null) {
            this.h.k();
            ey7 ey7Var = this.w;
            if (ey7Var != null) {
                ey7Var.p();
            }
            ds4 ds4Var = this.d0;
            if (ds4Var != null) {
                ds4Var.dismiss();
            }
            q0();
            ur4 ur4Var = this.F;
            if (ur4Var != null) {
                ur4Var.dismiss();
            }
            wr4 wr4Var = this.G;
            if (wr4Var != null) {
                wr4Var.e();
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
                this.U0.setVisibility(8);
            }
            mz7 mz7Var = this.h;
            if (mz7Var == null || (view2 = mz7Var.d) == null) {
                return;
            }
            view2.setVisibility(8);
        }
    }

    public void n2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048748, this) == null) {
            m4();
            this.E.b0(1);
            fy7 fy7Var = this.t;
            if (fy7Var != null) {
                fy7Var.l();
            }
            kw7 kw7Var = this.p;
            if (kw7Var != null) {
                kw7Var.k();
            }
            ix7 ix7Var = this.r;
            if (ix7Var != null) {
                ix7Var.j();
            }
            RightFloatLayerView rightFloatLayerView = this.N1;
            if (rightFloatLayerView != null && (rightFloatLayerView instanceof RightFloatLayerLottieView)) {
                ((RightFloatLayerLottieView) rightFloatLayerView).H(600);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
        }
    }

    public void n3(NoNetworkView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048749, this, bVar) == null) {
            this.R = bVar;
            NoNetworkView noNetworkView = this.m;
            if (noNetworkView != null) {
                noNetworkView.a(bVar);
            }
        }
    }

    public void n4(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048750, this, z2) == null) {
            this.g0 = z2;
        }
    }

    public void o0() {
        w18 w18Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048751, this) == null) || (w18Var = this.F0) == null) {
            return;
        }
        w18Var.l(false);
    }

    public void o1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048752, this) == null) || this.t0 == null) {
            return;
        }
        this.s0.setVisibility(8);
        this.t0.setVisibility(8);
        this.J0 = false;
        PbEmotionBar pbEmotionBar = this.e1;
        if (pbEmotionBar != null) {
            pbEmotionBar.setVisibility(8);
            R2(false);
        }
    }

    public void o2(rn rnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048753, this, rnVar) == null) {
            PbLandscapeListView pbLandscapeListView = this.l;
            pbLandscapeListView.b0 = rnVar;
            pbLandscapeListView.W = true;
        }
    }

    public void o3(BdListView.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048754, this, pVar) == null) {
            this.l.setOnSrollToBottomListener(pVar);
        }
    }

    public void o4(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048755, this, z2) == null) {
            this.h.J(z2);
            if (z2 && this.R0) {
                this.K.C(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f03ea));
                this.l.setNextPage(this.K);
                this.f = 2;
            }
            a2();
        }
    }

    public final boolean p0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048756, this)) == null) ? this.u.b(this.M0) : invokeV.booleanValue;
    }

    public void p1(boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048757, this, z2) == null) || this.t0 == null || this.x0 == null) {
            return;
        }
        TbSingleton tbSingleton = TbSingleton.getInstance();
        et7 et7Var = this.N0;
        boolean z3 = et7Var != null && et7Var.n0();
        et7 et7Var2 = this.N0;
        this.x0.setText(tbSingleton.getAdVertiComment(z3, et7Var2 != null && et7Var2.o0(), e1()));
        if (z2) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(400L);
            this.t0.startAnimation(alphaAnimation);
        }
        this.s0.setVisibility(0);
        this.t0.setVisibility(0);
        this.J0 = true;
        if (this.e1 == null || this.w1.l()) {
            return;
        }
        this.e1.setVisibility(0);
        R2(true);
    }

    public void p2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048758, this) == null) {
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 1).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
            if (!DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.c.getActivity(), LoginDialogData.PB_BOTTOM_REPLY_RESULT_PAGE))) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 2).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                return;
            }
            q4();
            this.c.O6();
            PbFragment pbFragment = this.c;
            if (pbFragment == null || pbFragment.K() == null || this.c.K().S1() == null || this.c.K().S1().O() == null || this.c.K().S1().O().getAuthor() == null) {
                return;
            }
            TiebaStatic.log(new StatisticItem("c13701").param("tid", this.c.K().n2()).param("fid", this.c.K().S1().m()).param("uid", TbadkCoreApplication.getCurrentAccountId()));
            TiebaStatic.log(new StatisticItem("c13402").param("tid", this.c.K().b).param("fid", this.c.K().S1().m()).param("obj_locate", 1).param("uid", this.c.K().S1().O().getAuthor().getUserId()));
        }
    }

    public void p3(AbsListView.OnScrollListener onScrollListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048759, this, onScrollListener) == null) {
            this.l.setOnScrollListener(onScrollListener);
        }
    }

    public void p4(ct7 ct7Var) {
        String string;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048760, this, ct7Var) == null) || ct7Var == null) {
            return;
        }
        this.h.K();
        if (!StringUtils.isNull(ct7Var.b)) {
            this.h.G(ct7Var.b);
        }
        String string2 = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f13c5);
        int e2 = og.e(ct7Var.a, 0);
        if (e2 == 100) {
            string = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f10ff);
        } else if (e2 != 300) {
            string = e2 != 400 ? "" : TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f133e);
        } else {
            string = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f02f5);
        }
        this.c.showNetRefreshView(this.d, String.format(string2, string), null, TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f029f), true, new i0(this, ct7Var.c));
    }

    public void q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048761, this) == null) {
            ur4 ur4Var = this.U;
            if (ur4Var != null) {
                ur4Var.dismiss();
            }
            Dialog dialog = this.V;
            if (dialog != null) {
                tg.b(dialog, this.c.getPageContext());
            }
            Dialog dialog2 = this.W;
            if (dialog2 != null) {
                tg.b(dialog2, this.c.getPageContext());
            }
            ds4 ds4Var = this.S;
            if (ds4Var != null) {
                ds4Var.dismiss();
            }
        }
    }

    public void q1() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048762, this) == null) || (editorTools = this.m0) == null) {
            return;
        }
        editorTools.o();
        ky7 ky7Var = this.v1;
        if (ky7Var != null) {
            ky7Var.m();
        }
    }

    public void q2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048763, this) == null) {
            this.E.b0(2);
            fy7 fy7Var = this.t;
            if (fy7Var != null) {
                fy7Var.m();
                if (!TbSingleton.getInstance().isNotchScreen(this.c.getFragmentActivity()) && !TbSingleton.getInstance().isCutoutScreen(this.c.getFragmentActivity())) {
                    m1().setSystemUiVisibility(4);
                }
            }
            r2();
            b2();
        }
    }

    public void q3(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048764, this, onClickListener) == null) {
            this.E.z0(onClickListener);
        }
    }

    public final void q4() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048765, this) == null) || (pbFragment = this.c) == null || pbFragment.O5() == null) {
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921706, Boolean.valueOf(!this.c.O5().C())));
    }

    public void r0() {
        fy7 fy7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048766, this) == null) || (fy7Var = this.t) == null) {
            return;
        }
        fy7Var.b();
    }

    public void r1() {
        mz7 mz7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048767, this) == null) || (mz7Var = this.h) == null) {
            return;
        }
        mz7Var.q();
    }

    public final void r2() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048768, this) == null) || (pbFragment = this.c) == null || pbFragment.O5() == null) {
            return;
        }
        this.c.O5().K();
    }

    public void r3(int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048769, this, i3) == null) {
            this.H1 = i3;
        }
    }

    public void r4(et7 et7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048770, this, et7Var) == null) {
            if (et7Var != null && AntiHelper.o(et7Var.O())) {
                w18 w18Var = this.F0;
                if (w18Var != null) {
                    w18Var.l(false);
                    this.F0.k();
                }
                ViewGroup.LayoutParams layoutParams = this.C0.getLayoutParams();
                layoutParams.height = -2;
                layoutParams.width = -2;
                this.C0.setLayoutParams(layoutParams);
                WebPManager.setPureDrawable(this.C0, R.drawable.obfuscated_res_0x7f080963, R.color.CAM_X0110, WebPManager.ResourceStateType.NORMAL_PRESS);
                return;
            }
            w18 w18Var2 = this.F0;
            if (w18Var2 == null || !w18Var2.h()) {
                ViewGroup.LayoutParams layoutParams2 = this.C0.getLayoutParams();
                layoutParams2.height = -2;
                layoutParams2.width = -2;
                this.C0.setLayoutParams(layoutParams2);
                WebPManager.setPureDrawable(this.C0, R.drawable.obfuscated_res_0x7f080963, UbsABTestHelper.isShareTopRight() ? R.color.CAM_X0105 : R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            }
        }
    }

    public void s0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048771, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c14693");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_locate", q2);
            TiebaStatic.log(statisticItem);
        }
    }

    public void s1() {
        uu4 uu4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048772, this) == null) || (uu4Var = this.L0) == null) {
            return;
        }
        uu4Var.h(false);
    }

    public void s2(AbsListView absListView, int i3, int i4, int i5) {
        PbReplyTitleViewHolder pbReplyTitleViewHolder;
        ey7 ey7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048773, this, absListView, i3, i4, i5) == null) {
            jw7 jw7Var = this.q;
            if (jw7Var != null) {
                jw7Var.c(i3, i4);
            }
            hx7 hx7Var = this.s;
            if (hx7Var != null) {
                hx7Var.c(i3, i4);
            }
            fy7 fy7Var = this.t;
            if (fy7Var != null) {
                fy7Var.n(absListView, i3, i4, i5);
            }
            mz7 mz7Var = this.h;
            if (mz7Var != null && (ey7Var = this.w) != null) {
                mz7Var.x(ey7Var.s());
            }
            E2();
            w0 w0Var = this.d1;
            w0Var.a = i3;
            w0Var.b = this.l.getHeaderViewsCount();
            this.d1.c = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.d1));
            I3(a0(absListView, i3));
            int i6 = 0;
            F2(this.d1.c, false);
            l0();
            if (!this.K.n() || this.K.C) {
                return;
            }
            w0 w0Var2 = this.d1;
            if (w0Var2 != null && (pbReplyTitleViewHolder = w0Var2.c) != null && pbReplyTitleViewHolder.getView() != null) {
                i6 = this.d1.c.getView().getTop() < 0 ? this.d1.c.getView().getHeight() : this.d1.c.getView().getBottom();
            }
            this.K.e(i6);
            this.K.C = true;
        }
    }

    public void s3(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048774, this, onLongClickListener) == null) {
            this.w.D(onLongClickListener);
            this.E.w0(onLongClickListener);
            ev7 ev7Var = this.w1;
            if (ev7Var != null) {
                ev7Var.r(onLongClickListener);
            }
        }
    }

    public boolean s4(et7 et7Var, boolean z2) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048775, this, et7Var, z2)) == null) {
            if (et7Var == null) {
                return false;
            }
            if (this.v != null) {
                if (et7Var.O() != null && et7Var.O().getIsNoTitle() == 0 && !et7Var.O().isVideoThreadType() && !this.P1) {
                    if (et7Var.O() != null) {
                        ThreadData O = et7Var.O();
                        O.parserSpecTitleForFrsAndPb(true, M3(et7Var));
                        O.setResource(3);
                        O.setPbTitle("2");
                    }
                    if (et7Var.O().isBJHArticleThreadType()) {
                        this.w.B(this.l);
                        this.v.g(this.l);
                        this.v.a(this.l);
                        this.w.m(this.l);
                        this.w.G(this.N0);
                        if (I1(et7Var)) {
                            this.v.g(this.l);
                        } else {
                            this.v.h(et7Var);
                        }
                    } else {
                        this.w.G(this.N0);
                        if (I1(et7Var)) {
                            this.v.g(this.l);
                        } else {
                            this.v.j(et7Var);
                        }
                    }
                } else if (et7Var.O().getIsNoTitle() == 1) {
                    if (et7Var.O() != null) {
                        this.v.g(this.l);
                        this.w.G(this.N0);
                    }
                } else {
                    this.v.g(this.l);
                    this.w.G(this.N0);
                }
            }
            h4(et7Var);
            this.M0 = z2;
            return false;
        }
        return invokeLZ.booleanValue;
    }

    public void t0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048776, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c14692");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_locate", q2);
            TiebaStatic.log(statisticItem);
        }
    }

    public void t1() {
        Runnable runnable;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048777, this) == null) {
            if (this.A == null) {
                A1();
            }
            this.k.setVisibility(8);
            Handler handler = this.U1;
            if (handler == null || (runnable = this.V1) == null) {
                return;
            }
            handler.removeCallbacks(runnable);
        }
    }

    public void t2(AbsListView absListView, int i3) {
        RightFloatLayerView rightFloatLayerView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048778, this, absListView, i3) == null) {
            fy7 fy7Var = this.t;
            if (fy7Var != null) {
                fy7Var.o(absListView, i3);
            }
            if (!this.h2 && i3 == 0) {
                this.f2 = h1();
                this.d1.c = null;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.d1));
                F2(this.d1.c, true);
                l0();
                this.E.h0(true);
            }
            this.E.g0();
            if (i3 == 0) {
                RightFloatLayerView rightFloatLayerView2 = this.N1;
                if (rightFloatLayerView2 != null) {
                    rightFloatLayerView2.q();
                }
            } else if (i3 == 1) {
                RightFloatLayerView rightFloatLayerView3 = this.N1;
                if (rightFloatLayerView3 != null) {
                    rightFloatLayerView3.p();
                }
            } else if (i3 != 2 || (rightFloatLayerView = this.N1) == null) {
            } else {
                rightFloatLayerView.r();
            }
        }
    }

    public final void t3(PostData postData, et7 et7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048779, this, postData, et7Var) == null) {
            this.w.E(postData, et7Var);
        }
    }

    public final void t4() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048780, this) == null) && this.c.F5()) {
            if (this.c.L5() == -1) {
                SkinManager.setViewTextColor(this.B, R.color.CAM_X0110, 1);
            }
            if (this.c.K5() == -1) {
                SkinManager.setViewTextColor(this.C, R.color.CAM_X0110, 1);
            }
        }
    }

    public void u0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048781, this) == null) {
            PbListView pbListView = this.K;
            if (pbListView != null) {
                pbListView.x();
                this.K.f();
            }
            s1();
        }
    }

    public void u1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048782, this) == null) {
            this.O.setVisibility(8);
        }
    }

    public void u2(ArrayList<sp4> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048783, this, arrayList) == null) {
            if (this.X == null) {
                this.X = LayoutInflater.from(this.c.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d01e2, (ViewGroup) null);
            }
            this.c.getBaseFragmentActivity().getLayoutMode().k(this.X);
            if (this.W == null) {
                Dialog dialog = new Dialog(this.c.getPageContext().getPageActivity(), R.style.obfuscated_res_0x7f1003a7);
                this.W = dialog;
                dialog.setCanceledOnTouchOutside(true);
                this.W.setCancelable(true);
                this.l0 = (ScrollView) this.X.findViewById(R.id.obfuscated_res_0x7f090cc3);
                this.W.setContentView(this.X);
                WindowManager.LayoutParams attributes = this.W.getWindow().getAttributes();
                attributes.width = qi.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0702db);
                this.W.getWindow().setAttributes(attributes);
                this.Z = new a0(this);
                this.Y = (LinearLayout) this.X.findViewById(R.id.obfuscated_res_0x7f090cc2);
                TextView textView = (TextView) this.X.findViewById(R.id.obfuscated_res_0x7f0907a0);
                this.b0 = textView;
                textView.setOnClickListener(new b0(this));
                TextView textView2 = (TextView) this.X.findViewById(R.id.obfuscated_res_0x7f0907a1);
                this.a0 = textView2;
                textView2.setOnClickListener(this.P);
            }
            this.Y.removeAllViews();
            this.n = new ArrayList();
            CustomBlueCheckRadioButton i02 = i0("0", this.c.getPageContext().getString(R.string.obfuscated_res_0x7f0f13ca));
            this.n.add(i02);
            i02.setChecked(true);
            this.Y.addView(i02);
            if (arrayList != null) {
                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                    sp4 sp4Var = arrayList.get(i3);
                    if (sp4Var != null && !TextUtils.isEmpty(sp4Var.b()) && sp4Var.a() > 0) {
                        CustomBlueCheckRadioButton i03 = i0(String.valueOf(sp4Var.a()), sp4Var.b());
                        this.n.add(i03);
                        View view2 = new View(this.c.getPageContext().getPageActivity());
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, qi.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f070198));
                        SkinManager.setBackgroundColor(view2, R.color.CAM_X0204);
                        view2.setLayoutParams(layoutParams);
                        this.Y.addView(view2);
                        this.Y.addView(i03);
                    }
                }
                ViewGroup.LayoutParams layoutParams2 = this.l0.getLayoutParams();
                int size = arrayList.size();
                if (size == 0 || size == 1) {
                    layoutParams2.height = qi.d(this.c.getPageContext().getPageActivity(), 120.0f);
                } else if (size != 2) {
                    layoutParams2.height = qi.d(this.c.getPageContext().getPageActivity(), 220.0f);
                } else {
                    layoutParams2.height = qi.d(this.c.getPageContext().getPageActivity(), 186.0f);
                }
                this.l0.setLayoutParams(layoutParams2);
                this.l0.removeAllViews();
                LinearLayout linearLayout = this.Y;
                if (linearLayout != null && linearLayout.getParent() == null) {
                    this.l0.addView(this.Y);
                }
            }
            tg.j(this.W, this.c.getPageContext());
        }
    }

    public void u3(boolean z2, PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048784, this, z2, postWriteCallBackData) == null) {
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

    public void u4(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048785, this, z2) == null) {
            uv7 uv7Var = this.E;
            if (uv7Var != null) {
                uv7Var.u0(z2);
                this.E.a0();
            }
            PbReplyTitleViewHolder pbReplyTitleViewHolder = this.Z0;
            if (pbReplyTitleViewHolder != null) {
                pbReplyTitleViewHolder.o(z2);
            }
            PbReplyTitleViewHolder pbReplyTitleViewHolder2 = this.d1.c;
            if (pbReplyTitleViewHolder2 != null) {
                pbReplyTitleViewHolder2.o(z2);
            }
            PbFragment pbFragment = this.c;
            if (pbFragment != null) {
                pbFragment.f7(z2);
            }
            if (z2) {
                fz7.d(this.c.getPageContext(), this.c.K(), this.c.S5());
            }
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_BATCH_MULTI_DEL_CLICK);
            et7 et7Var = this.N0;
            TiebaStatic.log(statisticItem.param("fid", et7Var != null ? et7Var.m() : "0").param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", "1"));
        }
    }

    public void v0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048786, this) == null) {
            this.l.A(0L);
            p0();
        }
    }

    public void v1() {
        RightFloatLayerView rightFloatLayerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048787, this) == null) || (rightFloatLayerView = this.N1) == null) {
            return;
        }
        rightFloatLayerView.c();
    }

    public void v2(int i3, String str, int i4, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048788, this, new Object[]{Integer.valueOf(i3), str, Integer.valueOf(i4), Boolean.valueOf(z2)}) == null) {
            w2(i3, str, i4, z2, null);
        }
    }

    public void v3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048789, this) == null) {
            this.c.hideProgressBar();
            et7 et7Var = this.N0;
            if (et7Var != null && this.K != null && et7Var.y() != null && this.N0.y().b() == 0) {
                this.K.u(this.N0.t());
                if (this.N0.t()) {
                    StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_PB_FOLD_ICON_SHOW);
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem.param("fid", this.N0.m());
                    statisticItem.param("fname", this.N0.n());
                    statisticItem.param("tid", this.N0.Q());
                    TiebaStatic.log(statisticItem);
                }
            }
            u0();
            this.l.A(0L);
            p0();
        }
    }

    public void v4(et7 et7Var) {
        ay7 ay7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048790, this, et7Var) == null) || (ay7Var = this.u) == null) {
            return;
        }
        ay7Var.h(et7Var, this.M0);
    }

    public void w0(int i3, boolean z2, String str, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048791, this, new Object[]{Integer.valueOf(i3), Boolean.valueOf(z2), str, Boolean.valueOf(z3)}) == null) {
            this.c.hideProgressBar();
            if (z2 && z3) {
                PbFragment pbFragment = this.c;
                pbFragment.showToast(pbFragment.getPageContext().getString(R.string.obfuscated_res_0x7f0f121c));
            } else if (z3) {
                if (pi.isEmpty(str)) {
                    str = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0c3d);
                }
                this.c.showToast(str);
            }
        }
    }

    public void w1() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048792, this) == null) || (editorTools = this.m0) == null) {
            return;
        }
        editorTools.q();
    }

    public void w2(int i3, String str, int i4, boolean z2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048793, this, new Object[]{Integer.valueOf(i3), str, Integer.valueOf(i4), Boolean.valueOf(z2), str2}) == null) {
            x2(i3, str, i4, z2, str2, false);
        }
    }

    public void w3() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048794, this) == null) || (pbFragment = this.c) == null || pbFragment.getBaseFragmentActivity() == null) {
            return;
        }
        qi.x(this.c.getPageContext().getPageActivity(), this.c.getBaseFragmentActivity().getCurrentFocus());
    }

    public void x0() {
        PbLandscapeListView pbLandscapeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048795, this) == null) || (pbLandscapeListView = this.l) == null) {
            return;
        }
        pbLandscapeListView.setForbidDragListener(true);
    }

    public final void x1() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048796, this) == null) && this.z == null && (pbFragment = this.c) != null) {
            this.z = new zx7(pbFragment.getContext());
        }
    }

    public void x2(int i3, String str, int i4, boolean z2, String str2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048797, this, new Object[]{Integer.valueOf(i3), str, Integer.valueOf(i4), Boolean.valueOf(z2), str2, Boolean.valueOf(z3)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(R.id.obfuscated_res_0x7f091fea, str);
            sparseArray.put(R.id.obfuscated_res_0x7f091fec, Integer.valueOf(i3));
            sparseArray.put(R.id.obfuscated_res_0x7f092008, Integer.valueOf(i4));
            sparseArray.put(R.id.obfuscated_res_0x7f091feb, Boolean.valueOf(z2));
            sparseArray.put(k2, Integer.valueOf(l2));
            int i5 = (i4 != 1002 || z2) ? R.string.obfuscated_res_0x7f0f04a0 : R.string.obfuscated_res_0x7f0f0ff4;
            int i6 = R.string.obfuscated_res_0x7f0f0439;
            if (i3 == 0) {
                if (i4 != 1002 || z2) {
                    i6 = R.string.obfuscated_res_0x7f0f04a4;
                    i5 = R.string.obfuscated_res_0x7f0f04a5;
                } else {
                    i5 = R.string.obfuscated_res_0x7f0f0ff8;
                }
            }
            this.U = new ur4(this.c.getActivity());
            if (StringUtils.isNull(str2)) {
                this.U.setMessageId(i5);
            } else {
                this.U.setOnlyMessageShowCenter(false);
                this.U.setMessage(str2);
            }
            this.U.setYesButtonTag(sparseArray);
            this.U.setPositiveButton(R.string.obfuscated_res_0x7f0f04ee, this.c);
            this.U.setNegativeButton(R.string.obfuscated_res_0x7f0f04e9, new s(this));
            this.U.setCancelable(true);
            this.U.create(this.c.getPageContext());
            if (z3) {
                L3(sparseArray, i6, i5);
            } else if (z2) {
                L3(sparseArray, i6, i5);
            } else if (C3()) {
                al5 al5Var = new al5(this.c.K().S1().l().getDeletedReasonInfo().is_grays_cale_forum.intValue(), this.c.K().S1().l().getDeletedReasonInfo().is_boomgrow.intValue(), this.c.K().S1().o().has_forum_rule.intValue());
                al5Var.i(this.c.K().S1().l().getId(), this.c.K().S1().l().getName());
                al5Var.h(this.c.K().S1().l().getImage_url());
                al5Var.j(this.c.K().S1().l().getUser_level());
                S3(sparseArray, i3, al5Var, this.c.K().S1().V(), false);
            } else {
                a4(this.U, i3);
            }
        }
    }

    public void x3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048798, this) == null) {
            this.K.z();
            this.K.Q();
        }
    }

    public final String y0(long j3) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048799, this, j3)) == null) {
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
        if ((interceptable == null || interceptable.invokeV(1048800, this) == null) && this.v == null) {
            this.v = new cy7(this.c, this.k0);
        }
    }

    public void y2(int i3, String str, int i4, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048801, this, new Object[]{Integer.valueOf(i3), str, Integer.valueOf(i4), Boolean.valueOf(z2)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(R.id.obfuscated_res_0x7f091fea, str);
            sparseArray.put(R.id.obfuscated_res_0x7f091fec, Integer.valueOf(i3));
            sparseArray.put(R.id.obfuscated_res_0x7f092008, Integer.valueOf(i4));
            sparseArray.put(R.id.obfuscated_res_0x7f091feb, Boolean.valueOf(z2));
            sparseArray.put(k2, Integer.valueOf(l2));
            if (z2) {
                G3(sparseArray);
            } else {
                H3(i3, sparseArray);
            }
        }
    }

    public void y3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048802, this, z2) == null) {
            this.w.F(z2);
        }
    }

    public final String z0(int i3) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048803, this, i3)) == null) {
            if (i3 == 0) {
                return this.c.getString(R.string.obfuscated_res_0x7f0f0dc5);
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

    public final void z1(et7 et7Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048804, this, et7Var) == null) && et7Var != null && et7Var.O() != null && et7Var.O().isInterviewLive() && this.T0 == null) {
            PbInterviewStatusView pbInterviewStatusView = (PbInterviewStatusView) this.S0.inflate();
            this.T0 = pbInterviewStatusView;
            pbInterviewStatusView.setOnClickListener(this.P);
            this.T0.setCallback(this.c.D5());
            this.T0.setData(this.c, et7Var);
        }
    }

    public void z2(SparseArray<Object> sparseArray, boolean z2) {
        bs4 bs4Var;
        bs4 bs4Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048805, this, sparseArray, z2) == null) {
            fs4 fs4Var = new fs4(this.c.getContext());
            fs4Var.q(this.c.getString(R.string.obfuscated_res_0x7f0f02e3));
            fs4Var.n(new r(this, z2));
            ArrayList arrayList = new ArrayList();
            int intValue = sparseArray.get(R.id.obfuscated_res_0x7f091fe4) instanceof Integer ? ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091fe4)).intValue() : -1;
            if (!"".equals(sparseArray.get(R.id.obfuscated_res_0x7f091fea)) && intValue != 2) {
                if ((sparseArray.get(R.id.obfuscated_res_0x7f091fec) instanceof Integer ? ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091fec)).intValue() : -1) == 0) {
                    bs4Var2 = new bs4(10, this.c.getString(R.string.obfuscated_res_0x7f0f04b6), fs4Var);
                } else {
                    bs4Var2 = new bs4(10, this.c.getString(R.string.obfuscated_res_0x7f0f04ab), fs4Var);
                }
                SparseArray sparseArray2 = new SparseArray();
                sparseArray2.put(R.id.obfuscated_res_0x7f091fea, sparseArray.get(R.id.obfuscated_res_0x7f091fea));
                sparseArray2.put(R.id.obfuscated_res_0x7f091fec, sparseArray.get(R.id.obfuscated_res_0x7f091fec));
                sparseArray2.put(R.id.obfuscated_res_0x7f091feb, sparseArray.get(R.id.obfuscated_res_0x7f091feb));
                sparseArray2.put(R.id.obfuscated_res_0x7f092008, sparseArray.get(R.id.obfuscated_res_0x7f092008));
                bs4Var2.d.setTag(sparseArray2);
                arrayList.add(bs4Var2);
            }
            if ((sparseArray.get(R.id.obfuscated_res_0x7f092009) instanceof Boolean) && ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092009)).booleanValue()) {
                bs4 bs4Var3 = new bs4(13, this.c.getString(R.string.obfuscated_res_0x7f0f0b24), fs4Var);
                SparseArray sparseArray3 = new SparseArray();
                sparseArray3.put(R.id.obfuscated_res_0x7f091fea, sparseArray.get(R.id.obfuscated_res_0x7f091fea));
                sparseArray3.put(R.id.obfuscated_res_0x7f091fec, sparseArray.get(R.id.obfuscated_res_0x7f091fec));
                sparseArray3.put(R.id.obfuscated_res_0x7f091feb, sparseArray.get(R.id.obfuscated_res_0x7f091feb));
                sparseArray3.put(R.id.obfuscated_res_0x7f092008, sparseArray.get(R.id.obfuscated_res_0x7f092008));
                bs4Var3.d.setTag(sparseArray3);
                arrayList.add(bs4Var3);
            }
            if ((!"".equals(sparseArray.get(R.id.obfuscated_res_0x7f091ff5)) || !"".equals(sparseArray.get(R.id.obfuscated_res_0x7f091ff6))) && !S1()) {
                SparseArray sparseArray4 = new SparseArray();
                sparseArray4.put(R.id.obfuscated_res_0x7f091ff5, sparseArray.get(R.id.obfuscated_res_0x7f091ff5));
                sparseArray4.put(R.id.obfuscated_res_0x7f091ff6, sparseArray.get(R.id.obfuscated_res_0x7f091ff6));
                sparseArray4.put(R.id.obfuscated_res_0x7f091ff7, sparseArray.get(R.id.obfuscated_res_0x7f091ff7));
                sparseArray4.put(R.id.obfuscated_res_0x7f092008, sparseArray.get(R.id.obfuscated_res_0x7f092008));
                sparseArray4.put(R.id.obfuscated_res_0x7f091ff8, sparseArray.get(R.id.obfuscated_res_0x7f091ff8));
                bs4 bs4Var4 = new bs4(11, this.c.getString(R.string.obfuscated_res_0x7f0f0654), fs4Var);
                bs4Var4.d.setTag(sparseArray4);
                arrayList.add(bs4Var4);
            }
            if ((sparseArray.get(R.id.obfuscated_res_0x7f092044) instanceof Boolean) && ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092044)).booleanValue()) {
                SparseArray sparseArray5 = new SparseArray();
                sparseArray5.put(R.id.obfuscated_res_0x7f091fff, sparseArray.get(R.id.obfuscated_res_0x7f091fff));
                sparseArray5.put(R.id.obfuscated_res_0x7f092040, sparseArray.get(R.id.obfuscated_res_0x7f092040));
                sparseArray5.put(R.id.obfuscated_res_0x7f092041, sparseArray.get(R.id.obfuscated_res_0x7f092041));
                sparseArray5.put(R.id.obfuscated_res_0x7f09203f, sparseArray.get(R.id.obfuscated_res_0x7f09203f));
                sparseArray5.put(R.id.obfuscated_res_0x7f092042, sparseArray.get(R.id.obfuscated_res_0x7f092042));
                sparseArray5.put(R.id.obfuscated_res_0x7f092043, sparseArray.get(R.id.obfuscated_res_0x7f092043));
                sparseArray5.put(R.id.obfuscated_res_0x7f09203e, sparseArray.get(R.id.obfuscated_res_0x7f09203e));
                if (z2) {
                    bs4Var = new bs4(12, this.c.getString(R.string.obfuscated_res_0x7f0f1499), fs4Var);
                } else {
                    bs4Var = new bs4(12, this.c.getString(R.string.obfuscated_res_0x7f0f0b30), fs4Var);
                }
                bs4Var.d.setTag(sparseArray5);
                arrayList.add(bs4Var);
            }
            ez7.f(arrayList);
            if (UbsABTestHelper.isPBPlanA()) {
                fs4Var.k(arrayList, false);
            } else {
                fs4Var.k(arrayList, true);
            }
            ds4 ds4Var = new ds4(this.c.getPageContext(), fs4Var);
            this.S = ds4Var;
            ds4Var.k();
        }
    }

    public void z3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048806, this, str) == null) {
            this.x0.performClick();
            if (StringUtils.isNull(str) || this.c.O5() == null || this.c.O5().v() == null || this.c.O5().v().i() == null) {
                return;
            }
            EditText i3 = this.c.O5().v().i();
            i3.setText(str);
            i3.setSelection(str.length());
        }
    }
}

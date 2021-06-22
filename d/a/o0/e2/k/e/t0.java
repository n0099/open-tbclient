package d.a.o0.e2.k.e;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
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
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.UserData;
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
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.sendtool.SendView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.util.MaskView;
import com.baidu.tbadk.widget.RightFloatLayerView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ObservedChangeRelativeLayout;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbLandscapeListView;
import com.baidu.tieba.pb.pb.main.PbReplyTitleViewHolder;
import com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar;
import com.baidu.tieba.pb.pb.main.view.CustomBlueCheckRadioButton;
import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
import com.baidu.tieba.pb.pb.main.view.PbThreadPostView;
import com.baidu.tieba.pb.pb.main.view.PbTopTipView;
import com.baidu.tieba.pb.view.FallingView;
import com.baidu.tieba.pb.view.PbInterviewStatusView;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.view.NavigationBarCoverTip;
import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import d.a.n0.r.f0.f;
import d.a.n0.r.q.a2;
import d.a.n0.r.q.w1;
import d.a.n0.r.q.z0;
import d.a.n0.r.s.a;
import d.a.n0.r.s.b;
import d.a.n0.r.s.l;
import d.a.o0.e2.i.a;
import d.a.o0.e2.p.c;
import d.a.o0.e3.g0.a;
import d.a.o0.h.f;
import d.a.o0.h.i;
import java.math.RoundingMode;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import org.json.JSONArray;
import tbclient.DeleteThreadInfo;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes5.dex */
public class t0 {
    public static final int V1 = UtilHelper.getLightStatusBarHeight();
    public static int W1 = 3;
    public static int X1 = 0;
    public static int Y1 = 3;
    public static int Z1 = 4;
    public static int a2 = 5;
    public static int b2 = 6;
    public static final int c2 = d.a.c.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds80);
    public static a.f d2 = new t();
    public d.a.o0.e2.h.e A0;
    public boolean A1;
    public PostData B0;
    public d.a.n0.s.c.f B1;
    public int C0;
    public RightFloatLayerView C1;
    public String E1;
    public PbListView F;
    public ViewStub F0;
    public PbInterviewStatusView G0;
    public View H;
    public FrameLayout H0;
    public View I;
    public TextView I0;
    public View.OnClickListener J;
    public View J0;
    public Runnable J1;
    public View K0;
    public PbReplyTitleViewHolder L0;
    public PbFragment.q2 L1;
    public View M0;
    public View.OnClickListener N;
    public PbEmotionBar Q0;
    public f.g Q1;
    public int S0;
    public int S1;
    public Runnable T0;
    public PbFakeFloorModel U0;
    public boolean U1;
    public d.a.o0.e2.k.e.u V0;
    public o0 W0;

    /* renamed from: a  reason: collision with root package name */
    public final ViewTreeObserver.OnGlobalLayoutListener f57254a;

    /* renamed from: b  reason: collision with root package name */
    public int f57255b;

    /* renamed from: c  reason: collision with root package name */
    public PbFragment f57256c;
    public int c1;

    /* renamed from: d  reason: collision with root package name */
    public RelativeLayout f57257d;
    public PbTopTipView d1;

    /* renamed from: e  reason: collision with root package name */
    public View f57258e;
    public d.a.o0.e2.i.c e0;
    public PopupWindow e1;
    public TextView f1;
    public EditorTools g0;
    public List<String> g1;

    /* renamed from: h  reason: collision with root package name */
    public final d.a.o0.e2.k.e.f1.c f57261h;
    public d.a.o0.e2.k.e.b1.c h1;

    /* renamed from: i  reason: collision with root package name */
    public d.a.o0.e2.k.e.f1.b f57262i;
    public View i0;
    public d.a.o0.e2.k.d.a i1;
    public ViewStub j;
    public View j0;
    public PbLandscapeListView.c j1;
    public ViewStub k;
    public PbLandscapeListView l;
    public View l0;
    public d.a.o0.e2.k.e.h0 l1;
    public NoNetworkView m;
    public View m0;
    public NavigationBarCoverTip m1;
    public List<CustomBlueCheckRadioButton> n;
    public LinearLayout n0;
    public d.a.o0.h.f n1;
    public PbThreadPostView o;
    public HeadImageView o0;
    public d.a.o0.h.i o1;
    public d.a.o0.e2.k.e.a1.f p;
    public TextView p0;
    public String p1;
    public d.a.o0.e2.k.e.a1.a q;
    public ImageView q0;
    public PermissionJudgePolicy q1;
    public d.a.o0.e2.k.e.a1.c r;
    public ImageView r0;
    public long r1;
    public d.a.o0.e2.k.e.a1.e s;
    public ImageView s0;
    public boolean s1;
    public d.a.o0.e2.k.e.a1.b t;
    public d.a.o0.e2.p.h t0;
    public int t1;
    public d.a.o0.e2.k.e.a1.d u;
    public TextView u0;
    public LinearLayout v;
    public TextView v0;
    public boolean v1;
    public TextView w;
    public d.a.o0.e2.p.g w1;
    public TextView x;
    public int x0;
    public MaskView x1;
    public ObservedChangeRelativeLayout y;
    public final FallingView y1;
    public d.a.o0.e2.k.e.i z;
    public final TbImageView z1;

    /* renamed from: f  reason: collision with root package name */
    public int f57259f = 0;

    /* renamed from: g  reason: collision with root package name */
    public final Handler f57260g = new Handler();
    public d.a.n0.r.s.a A = null;
    public d.a.n0.r.s.b B = null;
    public View C = null;
    public EditText D = null;
    public d.a.o0.e2.p.i E = null;
    public d.a.o0.e2.p.e G = null;
    public TbRichTextView.x K = null;
    public NoNetworkView.b L = null;
    public d.a.n0.r.s.j M = null;
    public d.a.n0.r.s.a O = null;
    public Dialog P = null;
    public Dialog Q = null;
    public View R = null;
    public LinearLayout S = null;
    public CompoundButton.OnCheckedChangeListener T = null;
    public TextView U = null;
    public TextView V = null;
    public String W = null;
    public d.a.n0.r.s.j X = null;
    public d.a.n0.r.s.j Y = null;
    public d.a.n0.r.s.e Z = null;
    public boolean a0 = false;
    public boolean b0 = false;
    public String c0 = null;
    public String d0 = null;
    public ScrollView f0 = null;
    public boolean h0 = false;
    public Button k0 = null;
    public boolean w0 = true;
    public d.a.n0.r.f0.a y0 = null;
    public boolean z0 = false;
    public int D0 = 3;
    public boolean E0 = false;
    public int N0 = 0;
    public boolean O0 = true;
    public l0 P0 = new l0();
    public int R0 = 0;
    public boolean X0 = false;
    public int Y0 = 0;
    public boolean Z0 = false;
    public boolean a1 = false;
    public boolean b1 = false;
    public boolean k1 = false;
    public int u1 = 0;
    public CustomMessageListener D1 = new d0(2921552);
    public CustomMessageListener F1 = new h0(2921306);
    public Runnable G1 = new f();
    public CustomMessageListener H1 = new g(2005016);
    public Handler I1 = new Handler();
    public CustomMessageListener K1 = new i(2004009);
    public boolean M1 = true;
    public View.OnClickListener N1 = new v();
    public boolean O1 = false;
    public String P1 = null;
    public final List<TbImageView> R1 = new ArrayList();
    public boolean T1 = false;

    /* loaded from: classes5.dex */
    public class a implements PbLandscapeListView.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f57263a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PbReplyTitleViewHolder f57264b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f57265c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f57266d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f57267e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f57268f;

        /* renamed from: d.a.o0.e2.k.e.t0$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class RunnableC1330a implements Runnable {
            public RunnableC1330a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (t0.this.M0 == null || t0.this.M0.getLayoutParams() == null) {
                    return;
                }
                ViewGroup.LayoutParams layoutParams = t0.this.M0.getLayoutParams();
                layoutParams.height = t0.this.S0;
                t0.this.M0.setLayoutParams(layoutParams);
            }
        }

        public a(int i2, PbReplyTitleViewHolder pbReplyTitleViewHolder, boolean z, int i3, int i4, int i5) {
            this.f57263a = i2;
            this.f57264b = pbReplyTitleViewHolder;
            this.f57265c = z;
            this.f57266d = i3;
            this.f57267e = i4;
            this.f57268f = i5;
        }

        @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.b
        public void onLayout() {
            ViewGroup.LayoutParams layoutParams;
            int i2;
            int i3 = this.f57263a;
            if (i3 >= 0 && i3 <= t0.this.f57257d.getMeasuredHeight()) {
                int N0 = t0.this.N0(this.f57264b);
                int i4 = this.f57263a;
                int i5 = N0 - i4;
                if (this.f57265c && i5 != 0 && i4 <= (i2 = this.f57266d)) {
                    i5 = N0 - i2;
                }
                if (t0.this.M0 == null || (layoutParams = t0.this.M0.getLayoutParams()) == null) {
                    return;
                }
                if (i5 == 0 || i5 > t0.this.f57257d.getMeasuredHeight() || N0 >= t0.this.f57257d.getMeasuredHeight()) {
                    layoutParams.height = t0.this.S0;
                } else {
                    if (layoutParams != null) {
                        int i6 = layoutParams.height;
                        if (i6 + i5 > 0 && i6 + i5 <= t0.this.f57257d.getMeasuredHeight()) {
                            layoutParams.height += i5;
                            t0.this.l.setSelectionFromTop(this.f57267e, this.f57268f);
                        }
                    }
                    layoutParams.height = t0.this.S0;
                }
                t0.this.M0.setLayoutParams(layoutParams);
                d.a.c.e.m.e.a().post(new RunnableC1330a());
            }
            t0.this.l.setOnLayoutListener(null);
        }
    }

    /* loaded from: classes5.dex */
    public class a0 implements DialogInterface.OnCancelListener {

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                t0.this.f57256c.HidenSoftKeyPad((InputMethodManager) t0.this.f57256c.getBaseFragmentActivity().getSystemService("input_method"), t0.this.f57257d);
            }
        }

        public a0() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            if (t0.this.T0 == null) {
                t0.this.T0 = new a();
            }
            d.a.c.e.m.e.a().postDelayed(t0.this.T0, 150L);
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SparseArray<Object> sparseArray = (SparseArray) view.getTag();
            if (sparseArray == null) {
                return;
            }
            boolean booleanValue = sparseArray.get(R.id.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_manage_visible)).booleanValue() : false;
            boolean booleanValue2 = sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue() : false;
            boolean booleanValue3 = sparseArray.get(R.id.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_delete_visible)).booleanValue() : false;
            if (booleanValue) {
                if (booleanValue2) {
                    sparseArray.put(R.id.tag_from, 1);
                    t0.this.f57256c.Z3(sparseArray);
                    return;
                }
                t0.this.U1(view);
            } else if (booleanValue2) {
                sparseArray.put(R.id.tag_from, 0);
                sparseArray.put(R.id.tag_check_mute_from, 1);
                t0.this.f57256c.Z3(sparseArray);
            } else if (booleanValue3) {
                t0.this.Q1(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b0 implements a.e {
        public b0(t0 t0Var) {
        }

        @Override // d.a.n0.r.s.a.e
        public void onClick(d.a.n0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            t0.this.h2();
        }
    }

    /* loaded from: classes5.dex */
    public class c0 implements a.e {
        public c0(t0 t0Var) {
        }

        @Override // d.a.n0.r.s.a.e
        public void onClick(d.a.n0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    /* loaded from: classes5.dex */
    public class d implements PbFakeFloorModel.b {
        public d() {
        }

        @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.b
        public void a(PostData postData) {
            t0.this.U0.E(postData);
            t0.this.z.U();
            t0.this.V0.c();
            t0.this.g0.q();
            t0.this.V2(false);
        }
    }

    /* loaded from: classes5.dex */
    public class d0 extends CustomMessageListener {
        public d0(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2921552) {
                return;
            }
            t0.this.d1();
        }
    }

    /* loaded from: classes5.dex */
    public class e extends BaseBitmapDataSubscriber {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.t.a f57277a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f57278b;

        public e(d.a.n0.t.a aVar, int i2) {
            this.f57277a = aVar;
            this.f57278b = i2;
        }

        @Override // com.facebook.datasource.BaseDataSubscriber
        public void onFailureImpl(DataSource<CloseableReference<CloseableImage>> dataSource) {
        }

        @Override // com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber
        public void onNewResultImpl(Bitmap bitmap) {
            t0.this.s3(this.f57277a, bitmap, this.f57278b);
        }
    }

    /* loaded from: classes5.dex */
    public class e0 implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f57280e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f57281f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f57282g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ View f57283h;

        public e0(int i2, int i3, int i4, View view) {
            this.f57280e = i2;
            this.f57281f = i3;
            this.f57282g = i4;
            this.f57283h = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i2 = this.f57280e;
            if (i2 == this.f57281f || i2 - this.f57282g >= 0) {
                t0.this.e1.showAsDropDown(t0.this.m0, this.f57283h.getLeft(), -t0.this.m0.getHeight());
            } else {
                t0.this.e1.showAsDropDown(this.f57283h);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (t0.this.z1 != null) {
                d.a.o0.e2.p.d.b(t0.this.z1);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f0 implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f57286e;

        public f0(String str) {
            this.f57286e = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            t0.this.C1.k();
            t0.this.A1(this.f57286e);
            t0.this.d1();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921552));
            TiebaStatic.log(new StatisticItem("c14129").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_locate", 2).param("obj_param1", 0));
        }
    }

    /* loaded from: classes5.dex */
    public class g extends CustomMessageListener {
        public g(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2005016 || t0.this.z == null) {
                return;
            }
            t0.this.z.U();
        }
    }

    /* loaded from: classes5.dex */
    public class g0 implements View.OnClickListener {
        public g0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            t0.this.C1.k();
            t0.this.d1();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921552));
            TiebaStatic.log(new StatisticItem("c14129").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_param1", 2).param("obj_locate", 2));
        }
    }

    /* loaded from: classes5.dex */
    public class h implements Runnable {
        public h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (t0.this.v == null) {
                t0.this.h1();
            }
            t0.this.k.setVisibility(0);
        }
    }

    /* loaded from: classes5.dex */
    public class h0 extends CustomMessageListener {
        public h0(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2921306) {
                return;
            }
            t0.this.E1 = null;
        }
    }

    /* loaded from: classes5.dex */
    public class i extends CustomMessageListener {
        public i(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null) {
                return;
            }
            t0.this.w0 = false;
        }
    }

    /* loaded from: classes5.dex */
    public class i0 implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f57293e;

        public i0(PbFragment pbFragment) {
            this.f57293e = pbFragment;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (t0.this.v1 || this.f57293e == null || t0.this.f57256c.A() == null || !t0.this.f57256c.A().b1()) {
                return;
            }
            t0.this.v1 = true;
            this.f57293e.W3(false);
        }
    }

    /* loaded from: classes5.dex */
    public class j implements View.OnClickListener {
        public j() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            t0.this.h2();
        }
    }

    /* loaded from: classes5.dex */
    public class j0 implements a.b {
        public j0() {
        }

        @Override // d.a.o0.e2.i.a.b
        public void a() {
            t0.this.f57256c.X4();
        }

        @Override // d.a.o0.e2.i.a.b
        public void b() {
            if (t0.this.l != null) {
                if (t0.this.p != null) {
                    t0.this.p.u();
                }
                t0.this.l.setSelection(0);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class k implements d.a.n0.w.b {
        public k() {
        }

        @Override // d.a.n0.w.b
        public void onAction(d.a.n0.w.a aVar) {
            Object obj = aVar.f54627c;
            if (obj instanceof d.a.n0.s.c.v) {
                if (((d.a.n0.s.c.v) obj).f() == EmotionGroupType.BIG_EMOTION || ((d.a.n0.s.c.v) aVar.f54627c).f() == EmotionGroupType.USER_COLLECT) {
                    if (t0.this.q1 == null) {
                        t0.this.q1 = new PermissionJudgePolicy();
                    }
                    t0.this.q1.clearRequestPermissionList();
                    t0.this.q1.appendRequestPermission(t0.this.f57256c.getBaseFragmentActivity(), StorageUtils.EXTERNAL_STORAGE_PERMISSION);
                    if (t0.this.q1.startRequestPermission(t0.this.f57256c.getBaseFragmentActivity())) {
                        return;
                    }
                    t0.this.f57256c.K4().h((d.a.n0.s.c.v) aVar.f54627c);
                    t0.this.f57256c.K4().z(false, null);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class k0 implements View.OnClickListener {
        public k0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (DialogLoginHelper.checkUpIsLogin(new d.a.n0.r.q.r0(t0.this.f57256c.getActivity(), "pb_huitie"))) {
                t0.this.f57256c.z5();
                if (t0.this.f57256c == null || t0.this.f57256c.A() == null || t0.this.f57256c.A().C0() == null || t0.this.f57256c.A().C0().L() == null || t0.this.f57256c.A().C0().L().T() == null) {
                    return;
                }
                TiebaStatic.log(new StatisticItem("c13701").param("tid", t0.this.f57256c.A().T0()).param("fid", t0.this.f57256c.A().C0().m()).param("uid", TbadkCoreApplication.getCurrentAccountId()));
                TiebaStatic.log(new StatisticItem("c13402").param("tid", t0.this.f57256c.A().f19254e).param("fid", t0.this.f57256c.A().C0().m()).param("obj_locate", 1).param("uid", t0.this.f57256c.A().C0().L().T().getUserId()));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class l implements TextWatcher {
        public l() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (t0.this.f57256c.D0 == null || t0.this.f57256c.D0.e() == null) {
                return;
            }
            if (!t0.this.f57256c.D0.e().e()) {
                t0.this.f57256c.D0.a(false);
            }
            t0.this.f57256c.D0.e().l(false);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            int i5;
            if (t0.this.g0 != null && t0.this.g0.getVisibility() == 0 && charSequence != null && charSequence.length() >= (i5 = i4 + i2)) {
                String substring = charSequence.toString().substring(i2, i5);
                if (TextUtils.isEmpty(substring)) {
                    return;
                }
                if (t0.this.h1 == null) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.addRule(11);
                    layoutParams.addRule(2, t0.this.g0.getId());
                    t0 t0Var = t0.this;
                    t0Var.h1 = new d.a.o0.e2.k.e.b1.c(t0Var.f57256c.getPageContext(), t0.this.f57257d, layoutParams);
                    if (!ListUtils.isEmpty(t0.this.g1)) {
                        t0.this.h1.q(t0.this.g1);
                    }
                    t0.this.h1.r(t0.this.g0);
                }
                t0.this.h1.p(substring);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class l0 {

        /* renamed from: a  reason: collision with root package name */
        public int f57300a;

        /* renamed from: b  reason: collision with root package name */
        public int f57301b;

        /* renamed from: c  reason: collision with root package name */
        public PbReplyTitleViewHolder f57302c;
    }

    /* loaded from: classes5.dex */
    public class m implements l.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f57303e;

        public m(boolean z) {
            this.f57303e = z;
        }

        @Override // d.a.n0.r.s.l.e
        public void onItemClick(d.a.n0.r.s.l lVar, int i2, View view) {
            t0.this.M.dismiss();
            SparseArray<Object> sparseArray = (SparseArray) view.getTag();
            if (sparseArray == null) {
                return;
            }
            switch (i2) {
                case 10:
                    t0.this.Q1(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                    return;
                case 11:
                    if (t0.this.L1 != null) {
                        t0.this.L1.a(new Object[]{sparseArray.get(R.id.tag_manage_user_identity), sparseArray.get(R.id.tag_forbid_user_name), sparseArray.get(R.id.tag_forbid_user_post_id), sparseArray.get(R.id.tag_forbid_user_name_show), sparseArray.get(R.id.tag_forbid_user_portrait)});
                        return;
                    }
                    return;
                case 12:
                    t0.this.f57256c.U4(this.f57303e, (String) sparseArray.get(R.id.tag_user_mute_mute_userid), sparseArray);
                    return;
                default:
                    return;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class n implements a.e {
        public n(t0 t0Var) {
        }

        @Override // d.a.n0.r.s.a.e
        public void onClick(d.a.n0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    /* loaded from: classes5.dex */
    public class o implements f.g {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.r.s.a f57305a;

        public o(d.a.n0.r.s.a aVar) {
            this.f57305a = aVar;
        }

        @Override // d.a.o0.h.f.g
        public void a(JSONArray jSONArray) {
            t0.this.f57256c.i4(this.f57305a, jSONArray);
        }
    }

    /* loaded from: classes5.dex */
    public class p implements i.h {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.r.s.a f57307a;

        public p(d.a.n0.r.s.a aVar) {
            this.f57307a = aVar;
        }

        @Override // d.a.o0.h.i.h
        public void a(JSONArray jSONArray) {
            t0.this.f57256c.i4(this.f57307a, jSONArray);
        }
    }

    /* loaded from: classes5.dex */
    public class q implements CompoundButton.OnCheckedChangeListener {
        public q() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (z) {
                t0.this.W = (String) compoundButton.getTag();
                if (t0.this.n != null) {
                    for (CustomBlueCheckRadioButton customBlueCheckRadioButton : t0.this.n) {
                        String str = (String) customBlueCheckRadioButton.getTag();
                        if (str != null && t0.this.W != null && !str.equals(t0.this.W)) {
                            customBlueCheckRadioButton.setChecked(false);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class r implements View.OnClickListener {
        public r() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (t0.this.Q instanceof Dialog) {
                d.a.c.e.m.g.b(t0.this.Q, t0.this.f57256c.getPageContext());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class s implements l.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.c f57311e;

        public s(b.c cVar) {
            this.f57311e = cVar;
        }

        @Override // d.a.n0.r.s.l.e
        public void onItemClick(d.a.n0.r.s.l lVar, int i2, View view) {
            t0.this.Y.dismiss();
            this.f57311e.a(null, i2, view);
        }
    }

    /* loaded from: classes5.dex */
    public static class t implements a.f {
        @Override // d.a.o0.e3.g0.a.f
        public void onRefresh() {
        }
    }

    /* loaded from: classes5.dex */
    public class u implements l.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.c f57313e;

        public u(b.c cVar) {
            this.f57313e = cVar;
        }

        @Override // d.a.n0.r.s.l.e
        public void onItemClick(d.a.n0.r.s.l lVar, int i2, View view) {
            t0.this.Y.dismiss();
            this.f57313e.a(null, i2, view);
        }
    }

    /* loaded from: classes5.dex */
    public class v implements View.OnClickListener {
        public v() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!(view instanceof HeadImageView) || t0.this.A0 == null || t0.this.A0.L() == null || t0.this.A0.L().T() == null || t0.this.A0.L().T().getAlaInfo() == null || t0.this.A0.L().T().getAlaInfo().live_status != 1) {
                if (t0.this.Z0) {
                    TiebaStatic.log(new StatisticItem("c11923").param("obj_id", 2));
                }
                if (!t0.this.Z0 && t0.this.A0 != null && t0.this.A0.L() != null && t0.this.A0.L().T() != null && t0.this.A0.L().T().isBigV()) {
                    TiebaStatic.log(new StatisticItem("c12151").param("obj_locate", 1));
                }
                if (t0.this.f57256c.B() != null) {
                    t0.this.f57256c.B().mEvent.f57009b.onClick(view);
                    return;
                }
                return;
            }
            StatisticItem statisticItem = new StatisticItem("c11851");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(statisticItem);
            StatisticItem statisticItem2 = new StatisticItem("c13715");
            statisticItem2.param("fid", t0.this.A0.m());
            statisticItem2.param("fname", t0.this.A0.n());
            statisticItem2.param("obj_param1", t0.this.A0.L().T().getAlaInfo().user_info != null ? t0.this.A0.L().T().getAlaInfo().user_info.user_id : 0L);
            statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem2.param("tid", t0.this.A0.N());
            statisticItem2.param(TiebaStatic.Params.OBJ_PARAM2, 1);
            statisticItem2.param(TiebaStatic.Params.OBJ_PARAM4, YYLiveUtil.calculateLiveType(t0.this.A0.L().T().getAlaInfo()));
            if (t0.this.A0.L().T().getAlaInfo().mYyExtData != null) {
                statisticItem2.param(TiebaStatic.Params.OBJ_PARAM3, TiebaStatic.YYValues.YY_LIVE);
                TiebaStaticHelper.addYYParam(statisticItem2, t0.this.A0.L().T().getAlaInfo().mYyExtData);
            }
            TiebaStatic.log(statisticItem2);
            if (t0.this.A0.L().T().getAlaInfo().isLegalYYLiveData()) {
                YYLiveUtil.jumpYYLiveRoom(t0.this.f57256c.getPageContext(), t0.this.A0.L().T().getAlaInfo());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class w implements Runnable {
        public w() {
        }

        @Override // java.lang.Runnable
        public void run() {
            t0 t0Var;
            d.a.o0.e2.k.e.f1.c cVar;
            LinearLayout linearLayout;
            if (t0.this.z == null || (cVar = (t0Var = t0.this).f57261h) == null || cVar.f57145i == null || t0Var.A0 == null || t0.this.A0.L() == null || t0.this.A0.L().D2() || t0.this.w1() || t0.this.A0.l() == null || d.a.c.e.p.k.isEmpty(t0.this.A0.l().getName())) {
                return;
            }
            if ((t0.this.z.G() == null || !t0.this.z.G().isShown()) && (linearLayout = t0.this.f57261h.f57145i) != null) {
                linearLayout.setVisibility(0);
                if (t0.this.f57256c == null || t0.this.f57256c.A() == null) {
                    return;
                }
                StatisticItem statisticItem = new StatisticItem("c13400");
                statisticItem.param("tid", t0.this.f57256c.A().S0());
                statisticItem.param("fid", t0.this.f57256c.A().getForumId());
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class x implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f57317e;

        public x(String str) {
            this.f57317e = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d.a.c.e.p.l.D()) {
                UrlManager.getInstance().dealOneLink(t0.this.f57256c.getPageContext(), new String[]{this.f57317e});
                t0.this.f57256c.finish();
                return;
            }
            t0.this.f57256c.showToast(R.string.neterror);
        }
    }

    /* loaded from: classes5.dex */
    public class y implements PbLandscapeListView.c {
        public y() {
        }

        @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.c
        public void a(int i2, int i3, float f2, float f3, float f4, float f5) {
            if (t0.this.f57256c == null || !t0.this.f57256c.isAdded()) {
                return;
            }
            if (i2 < 0 && f2 > t0.this.c1) {
                t0.this.a0();
                t0.this.J1();
            }
            t0.this.h0();
        }
    }

    /* loaded from: classes5.dex */
    public class z implements a.e {
        public z() {
        }

        @Override // d.a.n0.r.s.a.e
        public void onClick(d.a.n0.r.s.a aVar) {
            t0.this.a0();
            aVar.dismiss();
        }
    }

    public t0(PbFragment pbFragment, View.OnClickListener onClickListener, d.a.o0.e2.i.c cVar) {
        this.f57256c = null;
        this.f57257d = null;
        this.f57258e = null;
        this.l = null;
        this.z = null;
        this.F = null;
        this.H = null;
        this.J = null;
        this.N = null;
        this.m0 = null;
        this.p0 = null;
        this.F0 = null;
        this.c1 = 0;
        this.r1 = 0L;
        this.r1 = System.currentTimeMillis();
        this.f57256c = pbFragment;
        this.J = onClickListener;
        this.e0 = cVar;
        this.c1 = d.a.c.e.p.l.k(pbFragment.getContext()) / 8;
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.f57256c.getPageContext().getPageActivity()).inflate(R.layout.new_pb_activity, (ViewGroup) null);
        this.f57257d = relativeLayout;
        relativeLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.i0 = this.f57257d.findViewById(R.id.bottom_shadow);
        this.m1 = (NavigationBarCoverTip) this.f57257d.findViewById(R.id.pb_multi_forum_del_tip_view);
        this.f57258e = this.f57257d.findViewById(R.id.statebar_view);
        this.C1 = (RightFloatLayerView) this.f57257d.findViewById(R.id.right_layer_view);
        this.f57256c.registerListener(this.D1);
        j1();
        this.y = (ObservedChangeRelativeLayout) this.f57257d.findViewById(R.id.title_wrapper);
        this.m = (NoNetworkView) this.f57257d.findViewById(R.id.view_no_network);
        this.l = (PbLandscapeListView) this.f57257d.findViewById(R.id.new_pb_list);
        this.H0 = (FrameLayout) this.f57257d.findViewById(R.id.root_float_header);
        this.I0 = new TextView(this.f57256c.getActivity());
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + d.a.c.e.p.l.g(this.f57256c.getActivity(), R.dimen.ds88));
        this.l.x(this.I0, 0);
        this.l.setTextViewAdded(true);
        this.S0 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds134);
        this.M0 = new View(this.f57256c.getPageContext().getPageActivity());
        if (d.a.n0.c1.b.e.d()) {
            this.M0.setLayoutParams(new AbsListView.LayoutParams(-1, 0));
        } else {
            this.M0.setLayoutParams(new AbsListView.LayoutParams(-1, this.S0));
        }
        this.M0.setVisibility(4);
        this.l.addFooterView(this.M0);
        this.l.setOnTouchListener(this.f57256c.t2);
        this.f57254a = new i0(pbFragment);
        this.l.getViewTreeObserver().addOnGlobalLayoutListener(this.f57254a);
        this.f57261h = new d.a.o0.e2.k.e.f1.c(pbFragment, this.f57257d);
        if (this.f57256c.C4()) {
            ViewStub viewStub = (ViewStub) this.f57257d.findViewById(R.id.manga_view_stub);
            this.j = viewStub;
            viewStub.setVisibility(0);
            d.a.o0.e2.k.e.f1.b bVar = new d.a.o0.e2.k.e.f1.b(pbFragment);
            this.f57262i = bVar;
            bVar.c();
            this.f57261h.f57137a.setVisibility(8);
            layoutParams.height = d.a.c.e.p.l.g(this.f57256c.getActivity(), R.dimen.ds120);
        }
        this.I0.setLayoutParams(layoutParams);
        this.f57261h.i().setOnTouchListener(new d.a.o0.e2.i.a(new j0()));
        this.l0 = this.f57257d.findViewById(R.id.view_comment_top_line);
        this.m0 = this.f57257d.findViewById(R.id.pb_editor_tool_comment);
        d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds120);
        this.x0 = d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.ds242);
        HeadImageView headImageView = (HeadImageView) this.f57257d.findViewById(R.id.pb_editor_tool_comment_user_image);
        this.o0 = headImageView;
        headImageView.setVisibility(0);
        this.o0.setIsRound(true);
        this.o0.setBorderWidth(d.a.c.e.p.l.g(this.f57256c.getContext(), R.dimen.L_X01));
        this.o0.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
        this.o0.setPlaceHolder(0);
        D1();
        this.p0 = (TextView) this.f57257d.findViewById(R.id.pb_editor_tool_comment_reply_text);
        LinearLayout linearLayout = (LinearLayout) this.f57257d.findViewById(R.id.pb_editer_tool_comment_layout);
        this.n0 = linearLayout;
        linearLayout.setOnClickListener(new k0());
        this.q0 = (ImageView) this.f57257d.findViewById(R.id.pb_editor_tool_comment_icon);
        this.x1 = (MaskView) this.f57257d.findViewById(R.id.mask_view);
        this.q0.setOnClickListener(this.J);
        boolean booleanExtra = this.f57256c.getBaseFragmentActivity().getIntent().getBooleanExtra("key_is_from_dynamic", false);
        ImageView imageView = (ImageView) this.f57257d.findViewById(R.id.pb_editor_tool_collection);
        this.r0 = imageView;
        imageView.setOnClickListener(this.J);
        if (booleanExtra) {
            this.r0.setVisibility(8);
        } else {
            this.r0.setVisibility(0);
        }
        ImageView imageView2 = (ImageView) this.f57257d.findViewById(R.id.pb_editor_tool_share);
        this.s0 = imageView2;
        imageView2.setOnClickListener(this.J);
        d.a.o0.e2.p.h hVar = new d.a.o0.e2.p.h(this.s0);
        this.t0 = hVar;
        hVar.d();
        TextView textView = (TextView) this.f57257d.findViewById(R.id.pb_editor_tool_comment_red_dot);
        this.u0 = textView;
        textView.setVisibility(0);
        this.F0 = (ViewStub) this.f57257d.findViewById(R.id.interview_status_stub);
        this.q = new d.a.o0.e2.k.e.a1.a(this.f57256c, cVar);
        this.s = new d.a.o0.e2.k.e.a1.e(this.f57256c, cVar, this.J);
        d.a.o0.e2.k.e.i iVar = new d.a.o0.e2.k.e.i(this.f57256c, this.l);
        this.z = iVar;
        iVar.n0(this.J);
        this.z.o0(this.e0);
        this.z.k0(this.K);
        this.z.m0(this.f57256c.U1);
        b bVar2 = new b();
        this.N = bVar2;
        this.z.j0(bVar2);
        k1();
        f1();
        d.a.o0.e2.k.e.a1.d dVar = new d.a.o0.e2.k.e.a1.d(this.f57256c);
        this.u = dVar;
        dVar.f56921f = 2;
        this.r.a(this.l);
        this.s.g(this.l);
        this.q.a(this.l);
        PbListView pbListView = new PbListView(this.f57256c.getPageContext().getPageActivity());
        this.F = pbListView;
        View findViewById = pbListView.b().findViewById(R.id.pb_more_view);
        this.H = findViewById;
        if (findViewById != null) {
            findViewById.setOnClickListener(this.J);
            SkinManager.setBackgroundResource(this.H, R.drawable.pb_foot_more_trans_selector);
        }
        this.F.x();
        this.F.n(R.drawable.pb_foot_more_trans_selector);
        this.F.o(R.drawable.pb_foot_more_trans_selector);
        this.I = this.f57257d.findViewById(R.id.viewstub_progress);
        this.f57256c.registerListener(this.K1);
        this.U0 = new PbFakeFloorModel(this.f57256c.getPageContext());
        d.a.o0.e2.k.e.u uVar = new d.a.o0.e2.k.e.u(this.f57256c.getPageContext(), this.U0, this.f57257d);
        this.V0 = uVar;
        uVar.k(new c());
        this.V0.m(this.f57256c.Y1);
        this.U0.H(new d());
        if (this.f57256c.A() != null && !StringUtils.isNull(this.f57256c.A().F0())) {
            PbFragment pbFragment2 = this.f57256c;
            pbFragment2.showToast(pbFragment2.A().F0());
        }
        this.J0 = this.f57257d.findViewById(R.id.pb_expand_blank_view);
        View findViewById2 = this.f57257d.findViewById(R.id.sticky_view);
        this.K0 = findViewById2;
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) findViewById2.getLayoutParams();
        if (this.f57256c.A() != null && this.f57256c.A().p0()) {
            this.J0.setVisibility(0);
            if (layoutParams2 != null) {
                layoutParams2.height = 0;
                this.K0.setLayoutParams(layoutParams2);
            }
        } else if (layoutParams2 != null) {
            layoutParams2.height = V1;
            this.K0.setLayoutParams(layoutParams2);
        }
        PbReplyTitleViewHolder pbReplyTitleViewHolder = new PbReplyTitleViewHolder(this.f57256c.getPageContext(), this.f57257d.findViewById(R.id.pb_reply_expand_view));
        this.L0 = pbReplyTitleViewHolder;
        pbReplyTitleViewHolder.q(pbFragment.l0);
        this.L0.f19295g.setVisibility(8);
        this.L0.p(this.J);
        this.L0.o(this.f57256c.U1);
        this.f57256c.registerListener(this.H1);
        this.f57256c.registerListener(this.F1);
        PbFragment pbFragment3 = this.f57256c;
        this.w1 = new d.a.o0.e2.p.g(pbFragment3, pbFragment3.getUniqueId());
        this.y1 = (FallingView) this.f57257d.findViewById(R.id.falling_view);
        TbImageView tbImageView = (TbImageView) this.f57257d.findViewById(R.id.falling_ad_view);
        this.z1 = tbImageView;
        tbImageView.setPlaceHolder(2);
        V();
        g2(false);
        this.j0 = this.f57257d.findViewById(R.id.pb_comment_container);
        U(d.a.n0.c1.b.e.d());
    }

    public static /* synthetic */ float B1(Random random) {
        return (random.nextInt(2) * 0.1f) + 0.8f;
    }

    public int A0() {
        int lastVisiblePosition = this.l.getLastVisiblePosition();
        if (this.p != null) {
            if (lastVisiblePosition == this.l.getCount() - 1) {
                lastVisiblePosition--;
            }
            if (lastVisiblePosition < 0) {
                lastVisiblePosition = 0;
            }
        }
        return u0(lastVisiblePosition);
    }

    public final void A1(String str) {
        TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(this.f57256c.getPageContext().getPageActivity(), "", str, true);
        tbWebViewActivityConfig.setFixTitle(true);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig));
    }

    public void A2(TbRichTextView.x xVar) {
        this.K = xVar;
        this.z.k0(xVar);
        this.i1.q(this.K);
    }

    public boolean A3(d.a.o0.e2.h.e eVar, boolean z2) {
        if (eVar == null) {
            return false;
        }
        if (this.r != null) {
            if (eVar.L() != null && eVar.L().v0() == 0 && !eVar.L().D2() && !this.A1) {
                if (eVar.L() != null) {
                    a2 L = eVar.L();
                    L.W2(true, X2(eVar));
                    L.e4(3);
                    L.a4("2");
                }
                if (eVar.L().R1()) {
                    this.s.s(this.l);
                    this.r.d(this.l);
                    this.r.a(this.l);
                    this.s.g(this.l);
                    this.s.w(this.A0);
                    if (o1(eVar)) {
                        this.r.d(this.l);
                    } else {
                        this.r.e(eVar);
                    }
                } else {
                    this.s.w(this.A0);
                    if (o1(eVar)) {
                        this.r.d(this.l);
                    } else {
                        this.r.g(eVar);
                    }
                }
            } else if (eVar.L().v0() == 1) {
                if (eVar.L() != null) {
                    this.r.d(this.l);
                    this.s.w(this.A0);
                }
            } else {
                this.r.d(this.l);
                this.s.w(this.A0);
            }
        }
        p3(eVar);
        this.z0 = z2;
        return false;
    }

    public BdTypeListView B0() {
        return this.l;
    }

    public void B2(NoNetworkView.b bVar) {
        this.L = bVar;
        NoNetworkView noNetworkView = this.m;
        if (noNetworkView != null) {
            noNetworkView.a(bVar);
        }
    }

    public final void B3() {
        if (this.f57256c.C4()) {
            if (this.f57256c.H4() == -1) {
                SkinManager.setViewTextColor(this.w, R.color.CAM_X0110, 1);
            }
            if (this.f57256c.G4() == -1) {
                SkinManager.setViewTextColor(this.x, R.color.CAM_X0110, 1);
            }
        }
    }

    public SparseArray<Object> C0(d.a.o0.e2.h.e eVar, boolean z2, int i2) {
        PostData t0;
        d.a.n0.r.q.d0 d0Var;
        int i3;
        StringBuilder sb = null;
        if (eVar == null || (t0 = t0(eVar, z2)) == null) {
            return null;
        }
        String userId = t0.t().getUserId();
        boolean z3 = userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount());
        SparseArray<Object> sparseArray = new SparseArray<>();
        if (i2 == 0) {
            sparseArray.put(R.id.tag_del_post_id, t0.E());
            sparseArray.put(R.id.tag_del_post_type, 0);
            sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z3));
            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(eVar.S()));
            sparseArray.put(R.id.tag_should_manage_visible, Boolean.FALSE);
        } else if (i2 == 1) {
            if (t0.t() != null) {
                sparseArray.put(R.id.tag_forbid_user_name, t0.t().getUserName());
                sparseArray.put(R.id.tag_forbid_user_name_show, t0.t().getName_show());
                sparseArray.put(R.id.tag_forbid_user_portrait, t0.t().getPortrait());
                sparseArray.put(R.id.tag_forbid_user_post_id, t0.E());
            }
            sparseArray.put(R.id.tag_del_post_id, t0.E());
            sparseArray.put(R.id.tag_del_post_type, 0);
            sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z3));
            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(eVar.S()));
            sparseArray.put(R.id.tag_should_manage_visible, Boolean.TRUE);
        }
        if (!z3) {
            List<w1> p2 = eVar.p();
            if (ListUtils.getCount(p2) > 0) {
                sb = new StringBuilder();
                for (w1 w1Var : p2) {
                    if (w1Var != null && !StringUtils.isNull(w1Var.h()) && (d0Var = w1Var.f53946g) != null && d0Var.f53771a && !d0Var.f53773c && ((i3 = d0Var.f53772b) == 1 || i3 == 2)) {
                        sb.append(d.a.c.e.p.k.cutString(w1Var.h(), 12));
                        sb.append(this.f57256c.getString(R.string.forum));
                        sb.append("、");
                    }
                }
            }
            if (sb != null && !StringUtils.isNull(sb.toString())) {
                sparseArray.put(R.id.tag_del_multi_forum, String.format(this.f57256c.getString(R.string.del_multi_forum_default_txt), sb.toString().substring(0, sb.length() - 1)));
            }
        }
        return sparseArray;
    }

    public /* synthetic */ void C1(d.a.n0.t.a aVar, int i2, View view) {
        UrlManager urlManager = UrlManager.getInstance();
        TbPageContext<BaseFragmentActivity> pageContext = this.f57256c.getPageContext();
        urlManager.dealOneLink(pageContext, new String[]{"http://tieba.baidu.com/mo/q/checkurl?url=" + d.a.c.e.p.k.getUrlEncode(aVar.d())});
        TiebaStatic.log(new StatisticItem("c14126").param("obj_type", i2).param("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    public void C2(BdListView.p pVar) {
        this.l.setOnSrollToBottomListener(pVar);
    }

    public void C3(d.a.o0.e2.h.e eVar) {
        d.a.o0.e2.k.e.a1.a aVar = this.q;
        if (aVar != null) {
            aVar.h(eVar, this.z0);
        }
    }

    public d.a.o0.e2.k.d.a D0() {
        return this.i1;
    }

    public final void D1() {
        if (this.o0 != null && TbadkCoreApplication.getCurrentAccountInfo() != null) {
            this.o0.setImageResource(0);
            this.o0.U(TbadkCoreApplication.getCurrentAccountInfo().getAvatar(), 12, false);
            return;
        }
        this.o0.setImageResource(R.drawable.transparent_bg);
    }

    public void D2(AbsListView.OnScrollListener onScrollListener) {
        this.l.setOnScrollListener(onScrollListener);
    }

    public final int E0(boolean z2) {
        PbInterviewStatusView pbInterviewStatusView = this.G0;
        if (pbInterviewStatusView != null && pbInterviewStatusView.getVisibility() == 0 && z2) {
            return 0 + d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.ds72);
        }
        return 0;
    }

    public void E1(int i2) {
        if (this.D0 == i2) {
            return;
        }
        this.D0 = i2;
        q3(this.A0, this.z0);
        b2(this.A0, this.z0, this.C0, i2);
        this.f57256c.getBaseFragmentActivity().getLayoutMode().k(i2 == 1);
        this.f57256c.getBaseFragmentActivity().getLayoutMode().j(this.f57257d);
        SkinManager.setBackgroundColor(this.f57257d, R.color.CAM_X0201);
        SkinManager.setBackgroundColor(this.i0, R.color.CAM_X0203);
        d.a.o0.e2.k.e.a1.f fVar = this.p;
        if (fVar != null) {
            fVar.h(i2);
        }
        d.a.o0.e2.k.e.a1.b bVar = this.t;
        if (bVar != null) {
            bVar.c(i2);
        }
        d.a.o0.e2.k.e.a1.a aVar = this.q;
        if (aVar != null) {
            aVar.e(i2);
        }
        d.a.o0.e2.k.e.a1.c cVar = this.r;
        if (cVar != null) {
            cVar.c(i2);
        }
        d.a.o0.e2.k.e.a1.e eVar = this.s;
        if (eVar != null) {
            eVar.p(i2);
        }
        d.a.o0.e2.k.e.a1.d dVar = this.u;
        if (dVar != null) {
            dVar.d();
        }
        MaskView maskView = this.x1;
        if (maskView != null) {
            maskView.c();
        }
        PbListView pbListView = this.F;
        if (pbListView != null) {
            pbListView.d(i2);
        }
        if (this.H != null) {
            this.f57256c.getBaseFragmentActivity().getLayoutMode().j(this.H);
            SkinManager.setBackgroundResource(this.H, R.drawable.pb_foot_more_trans_selector);
        }
        d.a.n0.r.s.a aVar2 = this.A;
        if (aVar2 != null) {
            aVar2.autoChangeSkinType(this.f57256c.getPageContext());
        }
        w3(this.a0);
        this.z.U();
        d.a.o0.e2.p.i iVar = this.E;
        if (iVar != null) {
            iVar.I(i2);
        }
        EditorTools editorTools = this.g0;
        if (editorTools != null) {
            editorTools.w(i2);
        }
        d.a.o0.e2.p.e eVar2 = this.G;
        if (eVar2 != null) {
            eVar2.f(i2);
        }
        if (!ListUtils.isEmpty(this.n)) {
            for (CustomBlueCheckRadioButton customBlueCheckRadioButton : this.n) {
                customBlueCheckRadioButton.c();
            }
        }
        B3();
        UtilHelper.setStatusBarBackground(this.f57258e, i2);
        UtilHelper.setStatusBarBackground(this.K0, i2);
        if (this.v != null) {
            d.a.n0.s0.a.a(this.f57256c.getPageContext(), this.v);
        }
        d.a.o0.e2.k.e.u uVar = this.V0;
        if (uVar != null) {
            uVar.h(i2);
        }
        d.a.o0.e2.k.e.f1.c cVar2 = this.f57261h;
        if (cVar2 != null) {
            d.a.o0.e2.k.e.a1.f fVar2 = this.p;
            if (fVar2 != null) {
                fVar2.i(i2);
            } else {
                cVar2.m(i2);
            }
        }
        HeadImageView headImageView = this.o0;
        if (headImageView != null) {
            headImageView.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
        }
        LinearLayout linearLayout = this.n0;
        if (linearLayout != null) {
            linearLayout.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(d.a.c.e.p.l.g(this.f57256c.getContext(), R.dimen.tbds47), SkinManager.getColor(R.color.CAM_X0209)));
        }
        d.a.o0.e2.h.e eVar3 = this.A0;
        if (eVar3 != null && eVar3.r()) {
            WebPManager.setPureDrawable(this.r0, R.drawable.icon_pure_pb_bottom_collected26_selection, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
        } else {
            WebPManager.setPureDrawable(this.r0, R.drawable.icon_pure_pb_bottom_collect26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        }
        WebPManager.setPureDrawable(this.q0, R.drawable.icon_pure_pb_bottom_comment26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        z3(this.A0);
        SkinManager.setBackgroundColor(this.m0, R.color.CAM_X0207);
        SkinManager.setBackgroundColor(this.l0, R.color.CAM_X0203);
        SkinManager.setViewTextColor(this.f1, R.color.cp_cont_n);
        SkinManager.setViewTextColor(this.p0, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.v0, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.u0, R.color.CAM_X0107);
        TextView textView = this.u0;
        int g2 = d.a.c.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18);
        int i3 = R.color.CAM_X0207;
        SkinManager.setBackgroundShapeDrawable(textView, g2, i3, i3);
        d.a.o0.e2.k.d.a aVar3 = this.i1;
        if (aVar3 != null) {
            aVar3.m(i2);
        }
        PbEmotionBar pbEmotionBar = this.Q0;
        if (pbEmotionBar != null) {
            pbEmotionBar.w();
        }
        PbThreadPostView pbThreadPostView = this.o;
        if (pbThreadPostView != null) {
            pbThreadPostView.c(i2);
        }
        d.a.o0.e2.p.h hVar = this.t0;
        if (hVar != null) {
            hVar.f();
        }
        d.a.o0.e2.p.g gVar = this.w1;
        if (gVar != null) {
            gVar.c();
        }
        RightFloatLayerView rightFloatLayerView = this.C1;
        if (rightFloatLayerView != null) {
            rightFloatLayerView.o();
        }
    }

    public void E2(int i2) {
        this.t1 = i2;
    }

    public View F0() {
        return this.H;
    }

    public void F1(Configuration configuration) {
        if (configuration == null) {
            return;
        }
        a0();
        if (configuration.orientation == 2) {
            W0();
            Y0();
        } else {
            h2();
        }
        d.a.o0.e2.k.e.u uVar = this.V0;
        if (uVar != null) {
            uVar.c();
        }
        this.f57256c.X4();
        this.y.setVisibility(8);
        this.f57261h.t(false);
        this.f57256c.N5(false);
        if (this.p != null) {
            if (configuration.orientation == 1) {
                T0().setVisibility(0);
            }
            if (configuration.orientation == 2) {
                this.U1 = true;
                this.l.setIsLandscape(true);
                this.l.smoothScrollToPosition(0);
            } else {
                this.U1 = false;
                this.l.setIsLandscape(false);
                int i2 = this.S1;
                if (i2 > 0) {
                    this.l.smoothScrollBy(i2, 0);
                }
            }
            this.p.j(configuration);
            this.H0.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        }
    }

    public void F2(View.OnLongClickListener onLongClickListener) {
        this.s.t(onLongClickListener);
        this.z.l0(onLongClickListener);
        d.a.o0.e2.k.d.a aVar = this.i1;
        if (aVar != null) {
            aVar.r(onLongClickListener);
        }
    }

    public int G0() {
        try {
            return Integer.parseInt(this.D.getText().toString(), 10);
        } catch (Exception unused) {
            return -1;
        }
    }

    public void G1() {
        NoNetworkView.b bVar;
        RelativeLayout relativeLayout = this.f57257d;
        if (relativeLayout != null && relativeLayout.getHandler() != null) {
            this.f57257d.getHandler().removeCallbacksAndMessages(null);
        }
        d.a.o0.e2.p.h hVar = this.t0;
        if (hVar != null) {
            hVar.g();
        }
        o0 o0Var = this.W0;
        if (o0Var != null) {
            o0Var.a();
        }
        d.a.o0.e2.k.e.h0 h0Var = this.l1;
        if (h0Var != null) {
            h0Var.c();
        }
        PbTopTipView pbTopTipView = this.d1;
        if (pbTopTipView != null) {
            pbTopTipView.g();
        }
        this.f57256c.hideProgressBar();
        NoNetworkView noNetworkView = this.m;
        if (noNetworkView != null && (bVar = this.L) != null) {
            noNetworkView.d(bVar);
        }
        a0();
        g0();
        if (this.T0 != null) {
            d.a.c.e.m.e.a().removeCallbacks(this.T0);
        }
        PbInterviewStatusView pbInterviewStatusView = this.G0;
        if (pbInterviewStatusView != null) {
            pbInterviewStatusView.m();
        }
        this.I1 = null;
        this.f57260g.removeCallbacksAndMessages(null);
        this.z.V(3);
        View view = this.f57258e;
        if (view != null) {
            view.setBackgroundDrawable(null);
        }
        d.a.o0.e2.k.e.a1.f fVar = this.p;
        if (fVar != null) {
            fVar.a();
        }
        d.a.o0.e2.k.e.i iVar = this.z;
        if (iVar != null) {
            iVar.W();
        }
        this.l.setOnLayoutListener(null);
        d.a.o0.e2.k.e.b1.c cVar = this.h1;
        if (cVar != null) {
            cVar.l();
        }
        PbEmotionBar pbEmotionBar = this.Q0;
        if (pbEmotionBar != null) {
            pbEmotionBar.x();
        }
        d.a.o0.e2.k.e.a1.e eVar = this.s;
        if (eVar != null) {
            eVar.q();
        }
        PbLandscapeListView pbLandscapeListView = this.l;
        if (pbLandscapeListView != null) {
            pbLandscapeListView.getViewTreeObserver().removeGlobalOnLayoutListener(this.f57254a);
        }
    }

    public final void G2(PostData postData, d.a.o0.e2.h.e eVar) {
        this.s.u(postData, eVar);
    }

    public View H0() {
        return this.J0;
    }

    public void H1(TbRichText tbRichText) {
        PostData postData;
        d.a.o0.e2.h.e eVar = this.A0;
        if (eVar == null || eVar.D() == null || this.A0.D().isEmpty() || tbRichText == null || StringUtils.isNull(tbRichText.getAuthorId())) {
            return;
        }
        for (int i2 = 0; i2 < this.A0.D().size() && (postData = this.A0.D().get(i2)) != null && postData.t() != null && !StringUtils.isNull(postData.t().getUserId()); i2++) {
            if (this.A0.D().get(i2).t().getUserId().equals(tbRichText.getAuthorId())) {
                d.a.o0.e2.k.d.a aVar = this.i1;
                if (aVar != null && aVar.l()) {
                    V2(false);
                }
                PbEmotionBar pbEmotionBar = this.Q0;
                if (pbEmotionBar != null) {
                    pbEmotionBar.q(true);
                }
                postData.t().getName_show();
                return;
            }
        }
    }

    public void H2(boolean z2, PostWriteCallBackData postWriteCallBackData) {
        this.f57256c.hideProgressBar();
        if (z2) {
            a0();
        } else if (postWriteCallBackData != null && (postWriteCallBackData.isSensitiveError() || postWriteCallBackData.isErrorLinkCountExceedLimit() || postWriteCallBackData.isErrorShowApplyMemberDialog())) {
            b0();
        } else {
            a0();
        }
    }

    public PbFakeFloorModel I0() {
        return this.U0;
    }

    public boolean I1(int i2) {
        d.a.o0.e2.k.e.a1.f fVar = this.p;
        if (fVar != null) {
            return fVar.k(i2);
        }
        return false;
    }

    public void I2() {
        this.f57256c.hideProgressBar();
        g0();
        this.l.A(0L);
        d0();
    }

    public d.a.o0.e2.k.e.u J0() {
        return this.V0;
    }

    public void J1() {
        PostData postData;
        if (this.f57256c == null) {
            return;
        }
        if ((this.s1 || this.t1 == 17) && d.a.n0.b.d.S()) {
            d.a.o0.e2.h.e eVar = this.A0;
            if (eVar == null || eVar.l() == null || d.a.c.e.p.k.isEmpty(this.A0.l().getName())) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f57256c.getContext()).createNormalCfg(this.A0.l().getName(), null)));
            TiebaStatic.log(new StatisticItem("c13853").param("post_id", this.A0.N()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("fid", this.A0.l().getId()));
        } else if (!this.a1 || this.Z0 || (postData = this.B0) == null || postData.t() == null) {
        } else {
            TiebaStatic.log(new StatisticItem("c12601").param("obj_locate", this.f57256c.isSimpleForum() ? 2 : 1).param("obj_type", this.Z0 ? 2 : 1));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.f57256c.getPageContext().getPageActivity(), this.B0.t().getUserId(), this.B0.t().getUserName(), this.f57256c.A().e0(), AddFriendActivityConfig.TYPE_PB_HEAD)));
        }
    }

    public void J2() {
        PbFragment pbFragment = this.f57256c;
        if (pbFragment == null || pbFragment.getBaseFragmentActivity() == null) {
            return;
        }
        d.a.c.e.p.l.x(this.f57256c.getPageContext().getPageActivity(), this.f57256c.getBaseFragmentActivity().getCurrentFocus());
    }

    public d.a.o0.e2.k.e.a1.f K0() {
        return this.p;
    }

    public void K1(boolean z2) {
        if (z2) {
            a3();
        } else {
            Z0();
        }
        this.P0.f57302c = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.P0));
        W1(this.P0.f57302c, false);
    }

    public void K2() {
        this.F.x();
        this.F.O();
    }

    public final PostData L0(d.a.o0.e2.h.e eVar) {
        MetaData metaData;
        if (eVar == null || eVar.L() == null || eVar.L().T() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData T = eVar.L().T();
        String userId = T.getUserId();
        HashMap<String, MetaData> H1 = eVar.L().H1();
        if (H1 != null && (metaData = H1.get(userId)) != null && metaData.getUserId() != null) {
            T = metaData;
        }
        postData.i0(1);
        postData.l0(eVar.L().f0());
        postData.x0(eVar.L().A1());
        postData.w0(eVar.L().Z());
        postData.g0(T);
        return postData;
    }

    public void L1() {
        v3();
        this.z.V(1);
        d.a.o0.e2.k.e.a1.f fVar = this.p;
        if (fVar != null) {
            fVar.l();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
    }

    public void L2(boolean z2) {
        this.s.v(z2);
    }

    public String M0() {
        if (!d.a.c.e.p.k.isEmpty(this.p1)) {
            return this.p1;
        }
        if (this.f57256c != null) {
            this.p1 = TbadkCoreApplication.getInst().getResources().getString(r0.b());
        }
        return this.p1;
    }

    public void M1() {
        this.z.V(2);
        d.a.o0.e2.k.e.a1.f fVar = this.p;
        if (fVar != null) {
            fVar.m();
            if (TbSingleton.getInstance().isNotchScreen(this.f57256c.getFragmentActivity()) || TbSingleton.getInstance().isCutoutScreen(this.f57256c.getFragmentActivity())) {
                return;
            }
            U0().setSystemUiVisibility(4);
        }
    }

    public void M2(String str) {
        this.p0.performClick();
        if (StringUtils.isNull(str) || this.f57256c.K4() == null || this.f57256c.K4().v() == null || this.f57256c.K4().v().i() == null) {
            return;
        }
        EditText i2 = this.f57256c.K4().v().i();
        i2.setText(str);
        i2.setSelection(str.length());
    }

    public final int N0(PbReplyTitleViewHolder pbReplyTitleViewHolder) {
        if (pbReplyTitleViewHolder == null || pbReplyTitleViewHolder.a() == null) {
            return 0;
        }
        if (pbReplyTitleViewHolder.a().getTop() != 0 || pbReplyTitleViewHolder.a().isShown()) {
            return pbReplyTitleViewHolder.a().getBottom();
        }
        return 0;
    }

    public void N1(AbsListView absListView, int i2, int i3, int i4) {
        PbReplyTitleViewHolder pbReplyTitleViewHolder;
        d.a.o0.e2.k.e.a1.e eVar;
        d.a.o0.e2.k.e.a1.f fVar = this.p;
        if (fVar != null) {
            fVar.n(absListView, i2, i3, i4);
        }
        d.a.o0.e2.k.e.f1.c cVar = this.f57261h;
        if (cVar != null && (eVar = this.s) != null) {
            cVar.o(eVar.l());
        }
        l0 l0Var = this.P0;
        l0Var.f57300a = i2;
        l0Var.f57301b = this.l.getHeaderViewsCount();
        this.P0.f57302c = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.P0));
        U2(Q(absListView, i2));
        int i5 = 0;
        W1(this.P0.f57302c, false);
        Z();
        if (!this.F.m() || this.F.D) {
            return;
        }
        l0 l0Var2 = this.P0;
        if (l0Var2 != null && (pbReplyTitleViewHolder = l0Var2.f57302c) != null && pbReplyTitleViewHolder.a() != null) {
            i5 = this.P0.f57302c.a().getTop() < 0 ? this.P0.f57302c.a().getHeight() : this.P0.f57302c.a().getBottom();
        }
        this.F.e(i5);
        this.F.D = true;
    }

    public void N2(int i2) {
        this.l.setSelection(i2);
    }

    public int O0() {
        return R.id.richText;
    }

    public void O1(AbsListView absListView, int i2) {
        RightFloatLayerView rightFloatLayerView;
        d.a.o0.e2.k.e.a1.f fVar = this.p;
        if (fVar != null) {
            fVar.o(absListView, i2);
        }
        if (!this.U1 && i2 == 0) {
            this.S1 = P0();
            this.P0.f57302c = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.P0));
            W1(this.P0.f57302c, true);
            Z();
            this.z.Y(true);
        }
        if (i2 == 0) {
            RightFloatLayerView rightFloatLayerView2 = this.C1;
            if (rightFloatLayerView2 != null) {
                rightFloatLayerView2.q();
            }
        } else if (i2 == 1) {
            RightFloatLayerView rightFloatLayerView3 = this.C1;
            if (rightFloatLayerView3 != null) {
                rightFloatLayerView3.p();
            }
        } else if (i2 != 2 || (rightFloatLayerView = this.C1) == null) {
        } else {
            rightFloatLayerView.r();
        }
    }

    public void O2(int i2, int i3) {
        this.l.setSelectionFromTop(i2, i3);
    }

    public final int P0() {
        View childAt = this.l.getChildAt(0);
        if (childAt == null) {
            return 0;
        }
        return (-childAt.getTop()) + (this.l.getFirstVisiblePosition() * childAt.getHeight());
    }

    public void P1(ArrayList<d.a.n0.r.q.l0> arrayList) {
        if (this.R == null) {
            this.R = LayoutInflater.from(this.f57256c.getPageContext().getPageActivity()).inflate(R.layout.commit_good, (ViewGroup) null);
        }
        this.f57256c.getBaseFragmentActivity().getLayoutMode().j(this.R);
        if (this.Q == null) {
            Dialog dialog = new Dialog(this.f57256c.getPageContext().getPageActivity(), R.style.common_alert_dialog);
            this.Q = dialog;
            dialog.setCanceledOnTouchOutside(true);
            this.Q.setCancelable(true);
            this.f0 = (ScrollView) this.R.findViewById(R.id.good_scroll);
            this.Q.setContentView(this.R);
            WindowManager.LayoutParams attributes = this.Q.getWindow().getAttributes();
            attributes.width = d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.ds540);
            this.Q.getWindow().setAttributes(attributes);
            this.T = new q();
            this.S = (LinearLayout) this.R.findViewById(R.id.good_class_group);
            TextView textView = (TextView) this.R.findViewById(R.id.dialog_button_cancel);
            this.V = textView;
            textView.setOnClickListener(new r());
            TextView textView2 = (TextView) this.R.findViewById(R.id.dialog_button_ok);
            this.U = textView2;
            textView2.setOnClickListener(this.J);
        }
        this.S.removeAllViews();
        this.n = new ArrayList();
        CustomBlueCheckRadioButton W = W("0", this.f57256c.getPageContext().getString(R.string.thread_good_class));
        this.n.add(W);
        W.setChecked(true);
        this.S.addView(W);
        if (arrayList != null) {
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                d.a.n0.r.q.l0 l0Var = arrayList.get(i2);
                if (l0Var != null && !TextUtils.isEmpty(l0Var.b()) && l0Var.a() > 0) {
                    CustomBlueCheckRadioButton W2 = W(String.valueOf(l0Var.a()), l0Var.b());
                    this.n.add(W2);
                    View view = new View(this.f57256c.getPageContext().getPageActivity());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.ds1));
                    SkinManager.setBackgroundColor(view, R.color.CAM_X0204);
                    view.setLayoutParams(layoutParams);
                    this.S.addView(view);
                    this.S.addView(W2);
                }
            }
            ViewGroup.LayoutParams layoutParams2 = this.f0.getLayoutParams();
            int size = arrayList.size();
            if (size == 0 || size == 1) {
                layoutParams2.height = d.a.c.e.p.l.e(this.f57256c.getPageContext().getPageActivity(), 120.0f);
            } else if (size != 2) {
                layoutParams2.height = d.a.c.e.p.l.e(this.f57256c.getPageContext().getPageActivity(), 220.0f);
            } else {
                layoutParams2.height = d.a.c.e.p.l.e(this.f57256c.getPageContext().getPageActivity(), 186.0f);
            }
            this.f0.setLayoutParams(layoutParams2);
            this.f0.removeAllViews();
            LinearLayout linearLayout = this.S;
            if (linearLayout != null && linearLayout.getParent() == null) {
                this.f0.addView(this.S);
            }
        }
        d.a.c.e.m.g.j(this.Q, this.f57256c.getPageContext());
    }

    public void P2(int i2) {
        NavigationBar navigationBar;
        LinearLayout.LayoutParams layoutParams;
        if (this.l != null) {
            d.a.o0.e2.k.e.f1.c cVar = this.f57261h;
            int i3 = 0;
            if (cVar != null && (navigationBar = cVar.f57137a) != null) {
                int fixedNavHeight = navigationBar.getFixedNavHeight();
                if (!(this.f57256c.v4() != -1)) {
                    View view = this.K0;
                    if (view != null && (layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams()) != null) {
                        layoutParams.height = 0;
                        this.K0.setLayoutParams(layoutParams);
                    }
                    i2--;
                }
                i3 = fixedNavHeight;
            }
            this.l.setSelectionFromTop(i2, i3);
        }
    }

    public final boolean Q(AbsListView absListView, int i2) {
        if (absListView == null) {
            return false;
        }
        boolean z2 = i2 > 0;
        if (z2 || absListView.getChildCount() <= 0) {
            return z2;
        }
        return absListView.getChildAt(0).getTop() < absListView.getListPaddingTop();
    }

    public int Q0() {
        return this.D0;
    }

    public void Q1(int i2, String str, int i3, boolean z2) {
        R1(i2, str, i3, z2, null);
    }

    public void Q2(List<String> list) {
        this.g1 = list;
        d.a.o0.e2.k.e.b1.c cVar = this.h1;
        if (cVar != null) {
            cVar.q(list);
        }
    }

    public boolean R(boolean z2) {
        EditorTools editorTools = this.g0;
        if (editorTools == null || !editorTools.u()) {
            return false;
        }
        this.g0.q();
        return true;
    }

    public View R0() {
        return this.f57258e;
    }

    public void R1(int i2, String str, int i3, boolean z2, String str2) {
        S1(i2, str, i3, z2, str2, false);
    }

    public final boolean R2() {
        PbFragment pbFragment = this.f57256c;
        return (pbFragment == null || pbFragment.A().C0().l().getDeletedReasonInfo() == null || 1 != this.f57256c.A().C0().l().getDeletedReasonInfo().is_grays_cale_forum.intValue()) ? false : true;
    }

    public boolean S() {
        PbListView pbListView = this.F;
        if (pbListView == null || TextUtils.isEmpty(pbListView.h())) {
            return false;
        }
        return this.F.h().equals(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
    }

    public PbThreadPostView S0() {
        return this.o;
    }

    public void S1(int i2, String str, int i3, boolean z2, String str2, boolean z3) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(R.id.tag_del_post_id, str);
        sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i2));
        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i3));
        sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
        sparseArray.put(X1, Integer.valueOf(Y1));
        int i4 = R.string.del_all_post_confirm;
        if (i3 == 1002 && !z2) {
            i4 = R.string.report_post_confirm;
        }
        if (i2 == 0) {
            if (i3 == 1002 && !z2) {
                i4 = R.string.report_thread_confirm;
            } else {
                i4 = R.string.del_thread_confirm;
            }
        }
        this.O = new d.a.n0.r.s.a(this.f57256c.getActivity());
        if (StringUtils.isNull(str2)) {
            this.O.setMessageId(i4);
        } else {
            this.O.setOnlyMessageShowCenter(false);
            this.O.setMessage(str2);
        }
        this.O.setYesButtonTag(sparseArray);
        this.O.setPositiveButton(R.string.dialog_ok, this.f57256c);
        this.O.setNegativeButton(R.string.dialog_cancel, new n(this));
        this.O.setCancelable(true);
        this.O.create(this.f57256c.getPageContext());
        if (z3) {
            this.O.show();
        } else if (z2) {
            this.O.show();
        } else if (R2()) {
            d.a.o0.h.h hVar = new d.a.o0.h.h(this.f57256c.A().C0().l().getDeletedReasonInfo().is_grays_cale_forum.intValue(), this.f57256c.A().C0().l().getDeletedReasonInfo().is_boomgrow.intValue(), this.f57256c.A().C0().o().has_forum_rule.intValue());
            hVar.i(this.f57256c.A().C0().l().getId(), this.f57256c.A().C0().l().getName());
            hVar.h(this.f57256c.A().C0().l().getImage_url());
            hVar.j(this.f57256c.A().C0().l().getUser_level());
            d3(this.O, i2, hVar, this.f57256c.A().C0().R());
        } else {
            k3(this.O, i2);
        }
    }

    public void S2() {
        View view;
        PbLandscapeListView pbLandscapeListView = this.l;
        if (pbLandscapeListView != null) {
            pbLandscapeListView.setVisibility(0);
        }
        FrameLayout frameLayout = this.H0;
        if (frameLayout != null) {
            frameLayout.setVisibility(0);
        }
        d.a.o0.e2.k.e.f1.c cVar = this.f57261h;
        if (cVar == null || (view = cVar.f57140d) == null) {
            return;
        }
        view.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
    }

    public void T() {
        if (!this.f57256c.checkUpIsLogin()) {
            TiebaStatic.log(new StatisticItem("c10517").param("obj_locate", 2).param("fid", this.d0));
        } else if (this.f57256c.a4()) {
            d.a.n0.w.w.e K4 = this.f57256c.K4();
            if (K4 != null && (K4.B() || K4.D())) {
                this.f57256c.K4().z(false, null);
                return;
            }
            if (this.g0 != null) {
                i1();
            }
            EditorTools editorTools = this.g0;
            if (editorTools != null) {
                this.w0 = false;
                if (editorTools.n(2) != null) {
                    d.a.o0.e3.g0.a.c(this.f57256c.getPageContext(), (View) this.g0.n(2).k, false, d2);
                }
            }
            W0();
        }
    }

    public RelativeLayout T0() {
        return this.y;
    }

    public void T1(SparseArray<Object> sparseArray, boolean z2) {
        d.a.n0.r.s.h hVar;
        d.a.n0.r.s.h hVar2;
        d.a.n0.r.s.l lVar = new d.a.n0.r.s.l(this.f57256c.getContext());
        lVar.q(this.f57256c.getString(R.string.bar_manager));
        lVar.n(new m(z2));
        ArrayList arrayList = new ArrayList();
        int intValue = sparseArray.get(R.id.tag_check_mute_from) instanceof Integer ? ((Integer) sparseArray.get(R.id.tag_check_mute_from)).intValue() : -1;
        if (!"".equals(sparseArray.get(R.id.tag_del_post_id)) && intValue != 2) {
            if ((sparseArray.get(R.id.tag_del_post_type) instanceof Integer ? ((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue() : -1) == 0) {
                hVar2 = new d.a.n0.r.s.h(10, this.f57256c.getString(R.string.delete_post), lVar);
            } else {
                hVar2 = new d.a.n0.r.s.h(10, this.f57256c.getString(R.string.delete), lVar);
            }
            SparseArray sparseArray2 = new SparseArray();
            int i2 = R.id.tag_del_post_id;
            sparseArray2.put(i2, sparseArray.get(i2));
            int i3 = R.id.tag_del_post_type;
            sparseArray2.put(i3, sparseArray.get(i3));
            int i4 = R.id.tag_del_post_is_self;
            sparseArray2.put(i4, sparseArray.get(i4));
            int i5 = R.id.tag_manage_user_identity;
            sparseArray2.put(i5, sparseArray.get(i5));
            hVar2.f54037d.setTag(sparseArray2);
            arrayList.add(hVar2);
        }
        if ((!"".equals(sparseArray.get(R.id.tag_forbid_user_name)) || !"".equals(sparseArray.get(R.id.tag_forbid_user_name_show))) && !y1()) {
            SparseArray sparseArray3 = new SparseArray();
            int i6 = R.id.tag_forbid_user_name;
            sparseArray3.put(i6, sparseArray.get(i6));
            int i7 = R.id.tag_forbid_user_name_show;
            sparseArray3.put(i7, sparseArray.get(i7));
            int i8 = R.id.tag_forbid_user_portrait;
            sparseArray3.put(i8, sparseArray.get(i8));
            int i9 = R.id.tag_manage_user_identity;
            sparseArray3.put(i9, sparseArray.get(i9));
            int i10 = R.id.tag_forbid_user_post_id;
            sparseArray3.put(i10, sparseArray.get(i10));
            d.a.n0.r.s.h hVar3 = new d.a.n0.r.s.h(11, this.f57256c.getString(R.string.forbidden_person), lVar);
            hVar3.f54037d.setTag(sparseArray3);
            arrayList.add(hVar3);
        }
        if ((sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue()) {
            SparseArray sparseArray4 = new SparseArray();
            int i11 = R.id.tag_is_mem;
            sparseArray4.put(i11, sparseArray.get(i11));
            int i12 = R.id.tag_user_mute_mute_userid;
            sparseArray4.put(i12, sparseArray.get(i12));
            int i13 = R.id.tag_user_mute_mute_username;
            sparseArray4.put(i13, sparseArray.get(i13));
            int i14 = R.id.tag_user_mute_mute_nameshow;
            sparseArray4.put(i14, sparseArray.get(i14));
            int i15 = R.id.tag_user_mute_post_id;
            sparseArray4.put(i15, sparseArray.get(i15));
            int i16 = R.id.tag_user_mute_thread_id;
            sparseArray4.put(i16, sparseArray.get(i16));
            int i17 = R.id.tag_user_mute_msg;
            sparseArray4.put(i17, sparseArray.get(i17));
            if (z2) {
                hVar = new d.a.n0.r.s.h(12, this.f57256c.getString(R.string.un_mute), lVar);
            } else {
                hVar = new d.a.n0.r.s.h(12, this.f57256c.getString(R.string.mute), lVar);
            }
            hVar.f54037d.setTag(sparseArray4);
            arrayList.add(hVar);
        }
        d.a.o0.e2.k.e.e1.a.e(arrayList);
        if (d.a.n0.b.d.z()) {
            lVar.l(arrayList, false);
        } else {
            lVar.l(arrayList, true);
        }
        d.a.n0.r.s.j jVar = new d.a.n0.r.s.j(this.f57256c.getPageContext(), lVar);
        this.M = jVar;
        jVar.l();
    }

    public void T2() {
        d.a.o0.e2.k.e.a1.f fVar = this.p;
        if (fVar != null) {
            fVar.v(this.l);
        }
    }

    public void U(boolean z2) {
        if (z2) {
            SkinManager.setBackgroundColor(this.l, R.color.CAM_X0202);
        } else {
            this.l.setBackgroundResource(0);
        }
        View view = this.j0;
        if (view != null) {
            view.setVisibility(z2 ? 8 : 0);
        }
        PbListView pbListView = this.F;
        if (pbListView != null) {
            pbListView.I(z2 ? 8 : 0);
        }
        View view2 = this.H;
        if (view2 != null) {
            view2.setVisibility(z2 ? 8 : 0);
        }
    }

    public View U0() {
        return this.f57257d;
    }

    public void U1(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray == null) {
            return;
        }
        T1(sparseArray, false);
    }

    public void U2(boolean z2) {
        this.i0.setVisibility(z2 ? 0 : 8);
    }

    public final void V() {
        d.a.o0.e2.k.d.a aVar = new d.a.o0.e2.k.d.a(this.f57256c, this, (ViewStub) this.f57257d.findViewById(R.id.more_god_reply_popup));
        this.i1 = aVar;
        aVar.o(this.J);
        this.i1.p(this.N);
        this.i1.q(this.K);
        this.i1.o(this.J);
        this.i1.s(this.e0);
    }

    public void V0() {
        View view;
        PbLandscapeListView pbLandscapeListView = this.l;
        if (pbLandscapeListView != null) {
            pbLandscapeListView.setVisibility(8);
        }
        if (this.l != null) {
            this.H0.setVisibility(8);
        }
        d.a.o0.e2.k.e.f1.c cVar = this.f57261h;
        if (cVar == null || (view = cVar.f57140d) == null) {
            return;
        }
        view.setVisibility(8);
    }

    public void V1(d.a.n0.t.a aVar, int i2) {
        if (r0.a(aVar, i2)) {
            this.z1.U(aVar.f(), 10, false);
            Fresco.getImagePipeline().fetchDecodedImage(ImageRequestBuilder.newBuilderWithSource(Uri.parse(aVar.e())).setProgressiveRenderingEnabled(true).build(), this.f57256c.getContext()).subscribe(new e(aVar, i2), CallerThreadExecutor.getInstance());
        }
    }

    public void V2(boolean z2) {
        if (this.m0 == null) {
            return;
        }
        o2(this.f57256c.K4().C());
        if (this.h0) {
            Y2(z2);
        } else {
            X0(z2);
        }
    }

    public final CustomBlueCheckRadioButton W(String str, String str2) {
        Activity pageActivity = this.f57256c.getPageContext().getPageActivity();
        CustomBlueCheckRadioButton customBlueCheckRadioButton = new CustomBlueCheckRadioButton(pageActivity);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, d.a.c.e.p.l.g(pageActivity, R.dimen.ds100));
        customBlueCheckRadioButton.setOnCheckedChangeListener(this.T);
        customBlueCheckRadioButton.setTag(str);
        customBlueCheckRadioButton.setText(str2);
        customBlueCheckRadioButton.setLayoutParams(layoutParams);
        return customBlueCheckRadioButton;
    }

    public void W0() {
        if (this.m0 == null) {
            return;
        }
        this.l0.setVisibility(8);
        this.m0.setVisibility(8);
        this.w0 = false;
        PbEmotionBar pbEmotionBar = this.Q0;
        if (pbEmotionBar != null) {
            pbEmotionBar.setVisibility(8);
            g2(false);
        }
    }

    public final void W1(PbReplyTitleViewHolder pbReplyTitleViewHolder, boolean z2) {
        int measuredHeight;
        if (this.Z0 || this.J0 == null || this.f57261h.i() == null) {
            return;
        }
        int F = this.z.F();
        if (F > 0 && (pbReplyTitleViewHolder == null || pbReplyTitleViewHolder.a().getParent() == null)) {
            if (F > this.l.getFirstVisiblePosition() - this.l.getHeaderViewsCount()) {
                this.J0.setVisibility(4);
                return;
            }
            this.J0.setVisibility(0);
            U2(false);
            this.f57261h.f57137a.hideBottomLine();
            if (this.J0.getParent() == null || ((ViewGroup) this.J0.getParent()).getHeight() > this.J0.getTop()) {
                return;
            }
            this.J0.getParent().requestLayout();
        } else if (pbReplyTitleViewHolder != null && pbReplyTitleViewHolder.a() != null && pbReplyTitleViewHolder.f19295g != null) {
            int top = pbReplyTitleViewHolder.a().getTop();
            if (pbReplyTitleViewHolder.a().getParent() != null) {
                if (this.O0) {
                    this.N0 = top;
                    this.O0 = false;
                }
                int i2 = this.N0;
                if (top < i2) {
                    i2 = top;
                }
                this.N0 = i2;
            }
            if (top != 0 || pbReplyTitleViewHolder.a().isShown()) {
                if (this.y.getY() < 0.0f) {
                    measuredHeight = V1 - pbReplyTitleViewHolder.f19295g.getMeasuredHeight();
                } else {
                    measuredHeight = this.f57261h.i().getMeasuredHeight() - pbReplyTitleViewHolder.f19295g.getMeasuredHeight();
                    this.f57261h.f57137a.hideBottomLine();
                }
                if (pbReplyTitleViewHolder.a().getParent() == null && top <= this.N0) {
                    this.J0.setVisibility(0);
                    U2(false);
                } else if (top < measuredHeight) {
                    this.J0.setVisibility(0);
                    U2(false);
                } else {
                    this.J0.setVisibility(4);
                    this.f57261h.f57137a.hideBottomLine();
                }
                if (z2) {
                    this.O0 = true;
                }
            }
        } else if (this.l.getFirstVisiblePosition() == 0) {
            this.J0.setVisibility(4);
            this.f57261h.f57137a.hideBottomLine();
        }
    }

    public void W2(d.a.o0.e2.h.e eVar) {
        PostData postData;
        d.a.o0.e2.k.e.f1.c cVar;
        if (eVar == null || (postData = this.B0) == null || postData.t() == null || (cVar = this.f57261h) == null) {
            return;
        }
        boolean z2 = !this.Z0;
        this.a1 = z2;
        cVar.y(z2);
        if (this.f57256c.L4() != null) {
            this.f57256c.L4().s(this.a1);
        }
        X1();
        PbFragment pbFragment = this.f57256c;
        if (pbFragment != null && !pbFragment.isSimpleForum() && !ListUtils.isEmpty(eVar.p())) {
            w1 w1Var = eVar.p().get(0);
            if (w1Var != null) {
                this.f57261h.B(w1Var.h(), w1Var.a());
            }
        } else if (eVar.l() != null) {
            this.f57261h.B(eVar.l().getName(), eVar.l().getImage_url());
        }
        if (this.a1) {
            this.s.B(eVar, this.B0, this.b0);
            View view = this.K0;
            if (view != null) {
                view.setVisibility(8);
            }
            if (this.j1 == null) {
                this.j1 = new y();
            }
            this.l.setListViewDragListener(this.j1);
            return;
        }
        View view2 = this.K0;
        if (view2 != null) {
            view2.setVisibility(0);
        }
        this.s.B(eVar, this.B0, this.b0);
        this.j1 = null;
        this.l.setListViewDragListener(null);
    }

    public void X() {
        if (this.T1) {
            return;
        }
        TiebaStatic.log("c10490");
        this.T1 = true;
        d.a.n0.r.s.a aVar = new d.a.n0.r.s.a(this.f57256c.getPageContext().getPageActivity());
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(X1, Integer.valueOf(Z1));
        aVar.setTitle(R.string.grade_thread_tips);
        View inflate = LayoutInflater.from(this.f57256c.getPageContext().getPageActivity()).inflate(R.layout.upgrade_success_dialog_content, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.function_description_view)).setText(R.string.function_upgrade_to_photo_live_tips);
        ((TextView) inflate.findViewById(R.id.title_view)).setText(R.string.grade_thread_tips);
        aVar.setContentView(inflate);
        aVar.setYesButtonTag(sparseArray);
        aVar.setPositiveButton(R.string.grade_button_tips, this.f57256c);
        aVar.setNegativeButton(R.string.look_again, new b0(this));
        aVar.create(this.f57256c.getPageContext()).show();
    }

    public void X0(boolean z2) {
        if (this.m0 == null || this.p0 == null) {
            return;
        }
        if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
            this.p0.setText(TbSingleton.getInstance().getAdVertiComment());
        } else {
            this.p0.setText(M0());
        }
        if (z2) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(400L);
            this.m0.startAnimation(alphaAnimation);
        }
        this.l0.setVisibility(0);
        this.m0.setVisibility(0);
        this.w0 = true;
        if (this.Q0 == null || this.i1.l()) {
            return;
        }
        this.Q0.setVisibility(0);
        g2(true);
    }

    public final void X1() {
        this.s.r(this.A0, this.B0, this.a1, this.Z0);
    }

    public final boolean X2(d.a.o0.e2.h.e eVar) {
        if (eVar == null || eVar.L() == null) {
            return false;
        }
        return eVar.L().s0() == 1 || eVar.L().v1() == 33 || !(eVar.L().D1() == null || eVar.L().D1().a() == 0) || eVar.L().y0() == 1 || eVar.L().x0() == 1 || eVar.L().O1() || eVar.L().g2() || eVar.L().G2() || eVar.L().L1() != null || !d.a.c.e.p.k.isEmpty(eVar.L().X()) || eVar.L().d2() || eVar.L().r2();
    }

    public void Y(String str) {
        if (str.contains("_")) {
            str = str.replace("_", "\n");
        }
        d.a.n0.r.s.a aVar = new d.a.n0.r.s.a(this.f57256c.getPageContext().getPageActivity());
        View inflate = LayoutInflater.from(this.f57256c.getPageContext().getPageActivity()).inflate(R.layout.upgrade_success_dialog_content, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.title_view);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        textView.setLayoutParams(layoutParams);
        textView.setGravity(3);
        textView.setText(str);
        ((TextView) inflate.findViewById(R.id.function_description_view)).setVisibility(8);
        aVar.setContentView(inflate);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(X1, Integer.valueOf(a2));
        aVar.setYesButtonTag(sparseArray);
        aVar.setPositiveButton(R.string.view, this.f57256c);
        aVar.setNegativeButton(R.string.cancel, new c0(this));
        aVar.create(this.f57256c.getPageContext()).show();
    }

    public void Y0() {
        EditorTools editorTools = this.g0;
        if (editorTools != null) {
            editorTools.o();
            d.a.o0.e2.k.e.b1.c cVar = this.h1;
            if (cVar != null) {
                cVar.m();
            }
        }
    }

    public void Y1() {
        PbLandscapeListView pbLandscapeListView = this.l;
        if (pbLandscapeListView == null) {
            return;
        }
        int headerViewsCount = pbLandscapeListView.getHeaderViewsCount() - this.Y0;
        int firstVisiblePosition = (this.l.getFirstVisiblePosition() == 0 || this.l.getFirstVisiblePosition() + headerViewsCount < 0) ? 0 : this.l.getFirstVisiblePosition() + headerViewsCount;
        View childAt = this.l.getChildAt(0);
        int top = childAt != null ? childAt.getTop() : -1;
        this.P0.f57302c = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.P0));
        PbReplyTitleViewHolder pbReplyTitleViewHolder = this.P0.f57302c;
        int N0 = N0(pbReplyTitleViewHolder);
        int measuredHeight = this.y.getMeasuredHeight() + ((int) this.y.getY());
        boolean z2 = this.J0.getVisibility() == 0;
        boolean z3 = this.y.getY() < 0.0f;
        if ((z2 && pbReplyTitleViewHolder != null) || firstVisiblePosition >= this.z.F() + this.l.getHeaderViewsCount()) {
            int measuredHeight2 = pbReplyTitleViewHolder != null ? pbReplyTitleViewHolder.f19295g.getMeasuredHeight() : 0;
            if (z3) {
                this.l.setSelectionFromTop(this.z.F() + this.l.getHeaderViewsCount(), V1 - measuredHeight2);
            } else {
                this.l.setSelectionFromTop(this.z.F() + this.l.getHeaderViewsCount(), this.f57261h.i().getMeasuredHeight() - measuredHeight2);
            }
        } else {
            this.l.setSelectionFromTop(firstVisiblePosition, top);
        }
        if (this.Z0 && this.p != null) {
            this.l.setSelectionFromTop(this.z.F() + this.l.getHeaderViewsCount(), this.p.d());
        } else if (this.C0 != 6) {
        } else {
            this.l.setOnLayoutListener(new a(N0, pbReplyTitleViewHolder, z2, measuredHeight, firstVisiblePosition, top));
        }
    }

    public void Y2(boolean z2) {
        TextView textView;
        if (this.m0 == null || (textView = this.p0) == null) {
            return;
        }
        textView.setText(R.string.draft_to_send);
        if (z2) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(400L);
            this.m0.startAnimation(alphaAnimation);
        }
        this.l0.setVisibility(0);
        this.m0.setVisibility(0);
        this.w0 = true;
        if (this.Q0 == null || this.i1.l()) {
            return;
        }
        this.Q0.setVisibility(0);
        g2(true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0049, code lost:
        if (r5.u1 == 1) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void Z() {
        boolean z2;
        d.a.o0.e2.p.g gVar = this.w1;
        if (gVar == null) {
            return;
        }
        if (((gVar.a() == null || this.w1.a().getParent() == null) ? -1 : this.l.getPositionForView(this.w1.a())) != -1) {
            if (this.w1.a().getTop() + c2 <= this.J0.getBottom()) {
                this.u1 = 1;
                z2 = true;
            } else {
                this.u1 = 0;
                z2 = false;
            }
        }
        this.L0.s(this.u1 == 1);
        this.w1.e(z2);
    }

    public void Z0() {
        d.a.o0.e2.k.e.f1.c cVar = this.f57261h;
        if (cVar != null) {
            cVar.j();
        }
    }

    public final void Z1(d.a.o0.e2.h.e eVar) {
        if (eVar == null || eVar.L() == null) {
            return;
        }
        z3(eVar);
        if (eVar.r()) {
            WebPManager.setPureDrawable(this.r0, R.drawable.icon_pure_pb_bottom_collected26_selection, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
        } else {
            WebPManager.setPureDrawable(this.r0, R.drawable.icon_pure_pb_bottom_collect26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        }
        String k02 = k0(eVar.L().b1());
        TextView textView = this.u0;
        if (textView != null) {
            textView.setText(k02);
        }
        TextView textView2 = this.v0;
        if (textView2 != null) {
            textView2.setText(k02);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921416, eVar.L()));
    }

    public void Z2(View view) {
        if (d.a.n0.r.d0.b.j().g("show_long_press_collection_tips", false)) {
            return;
        }
        Rect rect = new Rect();
        this.m0.getGlobalVisibleRect(rect);
        int i2 = rect.bottom;
        int i3 = rect.top;
        view.getGlobalVisibleRect(rect);
        int i4 = rect.bottom;
        FrameLayout frameLayout = new FrameLayout(this.f57256c.getContext());
        frameLayout.setBackgroundResource(R.drawable.pic_sign_tip);
        TextView textView = new TextView(this.f57256c.getContext());
        this.f1 = textView;
        textView.setText(R.string.connection_tips);
        this.f1.setGravity(17);
        this.f1.setPadding(d.a.c.e.p.l.g(this.f57256c.getContext(), R.dimen.ds24), 0, d.a.c.e.p.l.g(this.f57256c.getContext(), R.dimen.ds24), 0);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        layoutParams.height = d.a.c.e.p.l.g(this.f57256c.getContext(), R.dimen.ds60);
        if (this.f1.getParent() == null) {
            frameLayout.addView(this.f1, layoutParams);
        }
        PopupWindow popupWindow = new PopupWindow(this.f57256c.getContext());
        this.e1 = popupWindow;
        popupWindow.setContentView(frameLayout);
        this.e1.setHeight(-2);
        this.e1.setWidth(-2);
        this.e1.setFocusable(true);
        this.e1.setOutsideTouchable(false);
        this.e1.setBackgroundDrawable(new ColorDrawable(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent)));
        this.l.postDelayed(new e0(i4, i2, i3, view), 100L);
        d.a.n0.r.d0.b.j().t("show_long_press_collection_tips", true);
    }

    public NoNetworkView a() {
        return this.m;
    }

    public void a0() {
        this.f57261h.e();
        d.a.o0.e2.k.e.a1.e eVar = this.s;
        if (eVar != null) {
            eVar.j();
        }
        PbFragment pbFragment = this.f57256c;
        if (pbFragment != null) {
            d.a.c.e.p.l.x(pbFragment.getContext(), this.D);
        }
        Y0();
        d.a.n0.r.s.j jVar = this.X;
        if (jVar != null) {
            jVar.dismiss();
        }
        e0();
        d.a.n0.r.s.a aVar = this.A;
        if (aVar != null) {
            aVar.dismiss();
        }
        d.a.n0.r.s.b bVar = this.B;
        if (bVar != null) {
            bVar.e();
        }
    }

    public void a1() {
        d.a.n0.r.f0.a aVar = this.y0;
        if (aVar != null) {
            aVar.h(false);
        }
    }

    public void a2(int i2, d.a.o0.e2.h.e eVar, boolean z2, int i3) {
        PostData t0;
        if (i2 <= 0 || (t0 = t0(eVar, z2)) == null || t0.t() == null) {
            return;
        }
        MetaData t2 = t0.t();
        t2.setGiftNum(t2.getGiftNum() + i2);
    }

    public void a3() {
        d.a.o0.e2.k.e.f1.c cVar = this.f57261h;
        if (cVar == null || this.b1) {
            return;
        }
        cVar.u();
        this.b1 = true;
    }

    public void b() {
        RightFloatLayerView rightFloatLayerView = this.C1;
        if (rightFloatLayerView == null) {
            return;
        }
        if (!rightFloatLayerView.n()) {
            d1();
            return;
        }
        d.a.n0.s.c.f adFloatViewData = TbSingleton.getInstance().getAdFloatViewData();
        this.B1 = adFloatViewData;
        if (adFloatViewData == null) {
            return;
        }
        this.C1.setData(adFloatViewData.c());
        m3();
        TiebaStatic.log(new StatisticItem("c14128").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_locate", 2));
        this.C1.setLogoListener(new f0(this.B1.d()));
        this.C1.setFeedBackListener(new g0());
    }

    public void b0() {
        this.f57261h.e();
        d.a.o0.e2.k.e.a1.e eVar = this.s;
        if (eVar != null) {
            eVar.j();
        }
        d.a.n0.r.s.j jVar = this.X;
        if (jVar != null) {
            jVar.dismiss();
        }
        e0();
        d.a.n0.r.s.a aVar = this.A;
        if (aVar != null) {
            aVar.dismiss();
        }
        d.a.n0.r.s.b bVar = this.B;
        if (bVar != null) {
            bVar.e();
        }
    }

    public void b1() {
        Runnable runnable;
        if (this.v == null) {
            h1();
        }
        this.k.setVisibility(8);
        Handler handler = this.I1;
        if (handler == null || (runnable = this.J1) == null) {
            return;
        }
        handler.removeCallbacks(runnable);
    }

    public void b2(d.a.o0.e2.h.e eVar, boolean z2, int i2, int i3) {
        f3(eVar, z2, i2, i3);
        this.s.p(i3);
    }

    public void b3() {
        this.l.setVisibility(0);
    }

    public void c0() {
        d.a.o0.e2.p.h hVar = this.t0;
        if (hVar != null) {
            hVar.h(false);
        }
    }

    public void c1() {
        this.I.setVisibility(8);
    }

    public final void c2() {
        PbInterviewStatusView pbInterviewStatusView = this.G0;
        if (pbInterviewStatusView == null || pbInterviewStatusView.getVisibility() != 0) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.G0.getLayoutParams();
        layoutParams.setMargins(0, 0, 0, 0);
        this.G0.setLayoutParams(layoutParams);
    }

    public void c3() {
        if (this.y0 == null) {
            this.y0 = new d.a.n0.r.f0.a(this.f57256c.getPageContext());
        }
        this.y0.h(true);
    }

    public final boolean d0() {
        return this.q.b(this.z0);
    }

    public void d1() {
        RightFloatLayerView rightFloatLayerView = this.C1;
        if (rightFloatLayerView != null) {
            rightFloatLayerView.f();
        }
    }

    public void d2() {
        if (this.f57259f != 2) {
            this.l.setNextPage(this.F);
            this.f57259f = 2;
        }
    }

    public final void d3(d.a.n0.r.s.a aVar, int i2, d.a.o0.h.h hVar, UserData userData) {
        PbFragment pbFragment = this.f57256c;
        if (pbFragment == null || aVar == null) {
            return;
        }
        if (this.o1 == null && this.q != null) {
            this.o1 = new d.a.o0.h.i(pbFragment.getPageContext(), this.q.c(), hVar, userData);
        }
        AntiData q4 = this.f57256c.q4();
        SparseArray<String> sparseArray = new SparseArray<>();
        if (q4 != null && q4.getDelThreadInfoList() != null) {
            List<DeleteThreadInfo> delThreadInfoList = q4.getDelThreadInfoList();
            for (int i3 = 0; i3 < delThreadInfoList.size(); i3++) {
                if (!TextUtils.isEmpty(delThreadInfoList.get(i3).text_info)) {
                    sparseArray.put(delThreadInfoList.get(i3).text_id, delThreadInfoList.get(i3).text_info);
                }
            }
        }
        d.a.n0.r.q.v0 v0Var = new d.a.n0.r.q.v0();
        v0Var.j(sparseArray);
        this.o1.B(new String[]{this.f57256c.getString(R.string.delete_thread_reason_1), this.f57256c.getString(R.string.delete_thread_reason_2), this.f57256c.getString(R.string.delete_thread_reason_3), this.f57256c.getString(R.string.delete_thread_reason_4), this.f57256c.getString(R.string.delete_thread_reason_5)});
        this.o1.A(v0Var);
        this.o1.D((i2 == 1 || i2 == 2) ? "4" : "3");
        this.o1.C(new p(aVar));
    }

    public void e0() {
        d.a.n0.r.s.a aVar = this.O;
        if (aVar != null) {
            aVar.dismiss();
        }
        Dialog dialog = this.P;
        if (dialog != null) {
            d.a.c.e.m.g.b(dialog, this.f57256c.getPageContext());
        }
        Dialog dialog2 = this.Q;
        if (dialog2 != null) {
            d.a.c.e.m.g.b(dialog2, this.f57256c.getPageContext());
        }
        d.a.n0.r.s.j jVar = this.M;
        if (jVar != null) {
            jVar.dismiss();
        }
    }

    public void e1() {
        EditorTools editorTools = this.g0;
        if (editorTools != null) {
            editorTools.q();
        }
    }

    public void e2() {
        PbLandscapeListView pbLandscapeListView = this.l;
        if (pbLandscapeListView != null) {
            this.r.d(pbLandscapeListView);
            this.s.s(this.l);
            this.t.d(this.l);
            this.q.f(this.l);
        }
    }

    public void e3(d.a.o0.e2.h.e eVar, int i2, int i3, boolean z2, int i4, boolean z3) {
        PbLandscapeListView pbLandscapeListView;
        int i5;
        PbReplyTitleViewHolder pbReplyTitleViewHolder;
        Parcelable e2;
        Parcelable e3;
        if (eVar == null || this.l == null) {
            return;
        }
        this.A0 = eVar;
        this.C0 = i2;
        if (eVar.L() != null) {
            this.R0 = eVar.L().Y();
            if (eVar.L().P() != 0) {
                this.O1 = true;
            }
            this.b0 = u1(eVar.L());
        }
        if (eVar.R() != null) {
            this.P1 = eVar.R().getUserId();
        }
        g1(eVar);
        this.E0 = false;
        this.z0 = z2;
        I2();
        d.a.o0.e2.h.k kVar = eVar.f56740h;
        if (kVar != null && kVar.b()) {
            if (this.o == null) {
                PbThreadPostView pbThreadPostView = new PbThreadPostView(this.f57256c.getContext());
                this.o = pbThreadPostView;
                this.l.x(pbThreadPostView, 1);
                this.o.setData(eVar);
                this.o.setChildOnClickLinstener(this.J);
            }
        } else {
            PbThreadPostView pbThreadPostView2 = this.o;
            if (pbThreadPostView2 != null && (pbLandscapeListView = this.l) != null) {
                pbLandscapeListView.removeHeaderView(pbThreadPostView2);
            }
        }
        f3(eVar, z2, i2, TbadkCoreApplication.getInst().getSkinType());
        W2(eVar);
        if (this.l1 == null) {
            this.l1 = new d.a.o0.e2.k.e.h0(this.f57256c.getPageContext(), this.m1);
        }
        this.l1.a(eVar.v());
        if (this.f57256c.C4()) {
            if (this.E == null) {
                d.a.o0.e2.p.i iVar = new d.a.o0.e2.p.i(this.f57256c.getPageContext());
                this.E = iVar;
                iVar.n();
                this.E.a(this.Q1);
            }
            this.l.setPullRefresh(this.E);
            i2();
            d.a.o0.e2.p.i iVar2 = this.E;
            if (iVar2 != null) {
                iVar2.I(TbadkCoreApplication.getInst().getSkinType());
            }
        } else if (eVar.w().c() == 0 && z2) {
            this.l.setPullRefresh(null);
        } else {
            if (this.E == null) {
                d.a.o0.e2.p.i iVar3 = new d.a.o0.e2.p.i(this.f57256c.getPageContext());
                this.E = iVar3;
                iVar3.n();
                this.E.a(this.Q1);
            }
            this.l.setPullRefresh(this.E);
            i2();
            d.a.o0.e2.p.i iVar4 = this.E;
            if (iVar4 != null) {
                iVar4.I(TbadkCoreApplication.getInst().getSkinType());
            }
            a1();
        }
        d0();
        this.z.g0(this.z0);
        this.z.d0(false);
        this.z.e0(i2 == 5);
        this.z.f0(i2 == 6);
        this.z.b0(z3 && this.M1 && i2 != 2);
        this.z.Z(eVar, false);
        this.z.U();
        this.s.A(t0(eVar, z2), eVar.a0());
        if (eVar.L() != null && eVar.L().R0() != null && this.f57255b != -1) {
            eVar.L().R0().setIsLike(this.f57255b);
        }
        this.l.removeFooterView(this.M0);
        this.l.addFooterView(this.M0);
        if (TbadkCoreApplication.isLogin()) {
            this.l.setNextPage(this.F);
            this.f57259f = 2;
            a1();
        } else {
            this.E0 = true;
            if (eVar.w().b() == 1) {
                if (this.G == null) {
                    PbFragment pbFragment = this.f57256c;
                    this.G = new d.a.o0.e2.p.e(pbFragment, pbFragment);
                }
                this.l.setNextPage(this.G);
            } else {
                this.l.setNextPage(this.F);
            }
            this.f57259f = 3;
        }
        ArrayList<PostData> D = eVar.D();
        if (eVar.w().b() != 0 && D != null && D.size() >= eVar.w().e()) {
            if (z3) {
                if (this.M1) {
                    g0();
                    if (eVar.w().b() != 0) {
                        this.F.A(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_load_more));
                    }
                } else {
                    this.F.x();
                    this.F.L();
                }
            } else {
                this.F.x();
                this.F.L();
            }
            this.F.j();
        } else {
            if (ListUtils.getCount(D) != 0 && (ListUtils.getCount(D) != 1 || D.get(0) == null || D.get(0).A() != 1)) {
                if (eVar.w().b() == 0) {
                    this.F.A(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                } else {
                    this.F.A(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                }
                this.F.j();
            } else {
                l0 l0Var = this.P0;
                if (l0Var == null || (pbReplyTitleViewHolder = l0Var.f57302c) == null || pbReplyTitleViewHolder.a() == null) {
                    i5 = 0;
                } else {
                    i5 = this.P0.f57302c.a().getTop() < 0 ? this.P0.f57302c.a().getHeight() : this.P0.f57302c.a().getBottom();
                }
                if (this.f57256c.f5()) {
                    this.F.D(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_host_reply), i5);
                } else {
                    this.F.D(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_replay), i5);
                }
                if (this.f57256c.L4() != null && !this.f57256c.L4().p()) {
                    this.f57256c.L4().x();
                }
            }
            if (eVar.w().b() == 0 || D == null) {
                d2();
            }
        }
        if (i2 == 2) {
            this.l.setSelection(i3 > 1 ? (i3 + ((this.l.getData() == null && eVar.D() == null) ? 0 : (this.l.getData().size() - eVar.D().size()) + this.l.getHeaderViewsCount())) - 2 : 0);
        } else if (i2 != 3) {
            if (i2 == 4) {
                this.M1 = false;
            } else if (i2 == 5) {
                this.l.setSelection(0);
            } else if (i2 != 6) {
                if (i2 == 8) {
                    if (i3 == 0) {
                        d.a.o0.e2.k.e.a1.f fVar = this.p;
                        if (fVar != null && fVar.c() != null) {
                            if (this.f57256c.getBaseFragmentActivity().isUseStyleImmersiveSticky()) {
                                this.l.setSelectionFromTop((this.z.A() + this.l.getHeaderViewsCount()) - 1, this.p.d() - d.a.c.e.p.l.r(this.f57256c.getPageContext().getPageActivity()));
                            } else {
                                this.l.setSelectionFromTop((this.z.A() + this.l.getHeaderViewsCount()) - 1, this.p.d());
                            }
                        } else {
                            this.l.setSelection(this.z.A() + this.l.getHeaderViewsCount());
                        }
                    } else {
                        this.l.setSelection(i3 > 0 ? i3 + ((this.l.getData() == null && eVar.D() == null) ? 0 : (this.l.getData().size() - eVar.D().size()) + this.l.getHeaderViewsCount()) : 0);
                    }
                    this.F.f();
                    this.F.A(this.f57256c.getString(R.string.pb_load_more_without_point));
                    this.F.v();
                }
            } else if (i4 == 1 && (e3 = m0.b().e()) != null && !(e3 instanceof RecyclerView.SavedState)) {
                this.l.onRestoreInstanceState(e3);
            } else {
                this.l.setSelection(0);
            }
        } else if (i4 == 1 && (e2 = m0.b().e()) != null && !(e2 instanceof RecyclerView.SavedState)) {
            this.l.onRestoreInstanceState(e2);
            if (ListUtils.getCount(D) > 1 && eVar.w().b() > 0) {
                this.F.f();
                this.F.A(this.f57256c.getString(R.string.pb_load_more_without_point));
                this.F.v();
            }
        }
        if (this.R0 == W1 && t1()) {
            X();
        }
        if (this.X0) {
            Y1();
            this.X0 = false;
            if (i4 == 0) {
                y2(true);
            }
        }
        if (eVar.f56736d == 1 || eVar.f56737e == 1) {
            if (this.d1 == null) {
                this.d1 = new PbTopTipView(this.f57256c.getContext());
            }
            if (eVar.f56737e == 1 && PbActivityConfig.KEY_FROM_GUIDE.equals(this.f57256c.P4())) {
                this.d1.setText(this.f57256c.getString(R.string.pb_read_strategy_add_experience));
                this.d1.l(this.f57257d, this.D0);
            } else if (eVar.f56736d == 1 && PbActivityConfig.KEY_FROM_NEWS.equals(this.f57256c.P4())) {
                this.d1.setText(this.f57256c.getString(R.string.pb_read_news_add_experience));
                this.d1.l(this.f57257d, this.D0);
            }
        }
        this.l.removeFooterView(this.w1.a());
        if (!ListUtils.isEmpty(eVar.F()) && eVar.w().b() == 0) {
            this.l.removeFooterView(this.M0);
            this.w1.d(Math.max(this.m0.getMeasuredHeight(), this.x0 / 2));
            this.l.addFooterView(this.w1.a());
            this.w1.f(eVar);
        }
        Z1(eVar);
    }

    public void f0() {
        d.a.o0.e2.k.e.a1.f fVar = this.p;
        if (fVar != null) {
            fVar.b();
        }
    }

    public final void f1() {
        if (this.r == null) {
            this.r = new d.a.o0.e2.k.e.a1.c(this.f57256c, this.e0);
        }
    }

    public final void f2() {
        PbFragment pbFragment = this.f57256c;
        if (pbFragment == null || pbFragment.K4() == null || this.g0 == null) {
            return;
        }
        d.a.n0.w.w.a.a().c(0);
        d.a.n0.w.w.e K4 = this.f57256c.K4();
        K4.T();
        K4.R();
        if (K4.y() != null) {
            K4.y().setMaxImagesAllowed(K4.z ? 1 : 9);
        }
        K4.l0(SendView.k);
        K4.j(SendView.k);
        d.a.n0.w.h m2 = this.g0.m(23);
        d.a.n0.w.h m3 = this.g0.m(2);
        d.a.n0.w.h m4 = this.g0.m(5);
        if (m3 != null) {
            m3.b();
        }
        if (m4 != null) {
            m4.b();
        }
        if (m2 != null) {
            m2.hide();
        }
        this.g0.invalidate();
    }

    @SuppressLint({"ResourceAsColor"})
    public final void f3(d.a.o0.e2.h.e eVar, boolean z2, int i2, int i3) {
        if (eVar == null || eVar.L() == null) {
            return;
        }
        if (this.f57256c.isSimpleForum()) {
            if (eVar.h() != null) {
                this.c0 = eVar.h().h();
                this.d0 = eVar.h().i();
            }
            if (this.c0 == null && this.f57256c.A() != null && this.f57256c.A().e0() != null) {
                this.c0 = this.f57256c.A().e0();
            }
        }
        PostData t0 = t0(eVar, z2);
        G2(t0, eVar);
        this.s.x(8);
        if (eVar.f0()) {
            this.Z0 = true;
            this.f57261h.s(true);
            this.f57261h.f57137a.hideBottomLine();
            if (this.p == null) {
                this.p = new d.a.o0.e2.k.e.a1.f(this.f57256c);
            }
            this.p.w(eVar, t0, this.l, this.s, this.H0, this.f57261h, this.c0, this.r1);
            this.p.t(this.N1);
            i2();
        } else {
            this.Z0 = false;
            this.f57261h.s(false);
            d.a.o0.e2.k.e.a1.f fVar = this.p;
            if (fVar != null) {
                fVar.p(this.l);
            }
        }
        if (this.f57256c.L4() != null) {
            this.f57256c.L4().w(this.Z0);
        }
        if (t0 == null) {
            return;
        }
        this.B0 = t0;
        this.s.x(0);
        SparseArray<Object> n2 = this.s.n();
        n2.put(R.id.tag_clip_board, t0);
        n2.put(R.id.tag_is_subpb, Boolean.FALSE);
        this.t.e(eVar, this.l);
        this.r.f(eVar);
        this.q.h(eVar, this.z0);
        this.q.g(eVar);
        this.s.y(this.D0, this.A0, t0, this.N1);
        if (this.L0 != null) {
            if (eVar.a0()) {
                this.L0.a().setVisibility(8);
            } else {
                this.L0.a().setVisibility(0);
                d.a.o0.e2.h.o oVar = new d.a.o0.e2.h.o(d.a.o0.e2.h.o.l);
                if (eVar.L() != null) {
                    eVar.L().b1();
                }
                oVar.f56771g = eVar.f56739g;
                eVar.c();
                oVar.f56772h = this.f57256c.f5();
                oVar.k = eVar.f56738f;
                this.L0.h(oVar);
            }
        }
        p3(eVar);
        d.a.c.e.m.e.a().post(new w());
        this.u.e(this.l);
        if (t0.S) {
            this.u.f(t0.E());
            this.u.b(this.l, this.l.getHeaderViewsCount() <= 1 ? 0 : 1);
        }
        d.a.o0.e2.k.e.i iVar = this.z;
        if (iVar != null && iVar.y() != null) {
            this.z.y().s0(t0.S);
        }
        d.a.o0.e2.k.e.i iVar2 = this.z;
        if (iVar2 != null) {
            iVar2.i0(t0.S);
        }
        this.x1.setVisibility(t0.S ? 0 : 8);
    }

    public void g0() {
        PbListView pbListView = this.F;
        if (pbListView != null) {
            pbListView.v();
            this.F.f();
        }
        a1();
    }

    public final void g1(d.a.o0.e2.h.e eVar) {
        if (eVar == null || eVar.L() == null || !eVar.L().g2() || this.G0 != null) {
            return;
        }
        PbInterviewStatusView pbInterviewStatusView = (PbInterviewStatusView) this.F0.inflate();
        this.G0 = pbInterviewStatusView;
        pbInterviewStatusView.setOnClickListener(this.J);
        this.G0.setCallback(this.f57256c.A4());
        this.G0.setData(this.f57256c, eVar);
    }

    public final void g2(boolean z2) {
    }

    public void g3(b.c cVar, boolean z2) {
        d.a.n0.r.s.j jVar = this.Y;
        if (jVar != null) {
            jVar.dismiss();
            this.Y = null;
        }
        d.a.n0.r.s.l lVar = new d.a.n0.r.s.l(this.f57256c.getContext());
        ArrayList arrayList = new ArrayList();
        d.a.o0.e2.h.e eVar = this.A0;
        if (eVar != null && eVar.L() != null && !this.A0.L().V1()) {
            arrayList.add(new d.a.n0.r.s.h(0, this.f57256c.getPageContext().getString(R.string.save_to_emotion), lVar));
        }
        if (!z2) {
            arrayList.add(new d.a.n0.r.s.h(1, this.f57256c.getPageContext().getString(R.string.save_to_local), lVar));
        }
        lVar.k(arrayList);
        lVar.n(new u(cVar));
        d.a.n0.r.s.j jVar2 = new d.a.n0.r.s.j(this.f57256c.getPageContext(), lVar);
        this.Y = jVar2;
        jVar2.l();
    }

    public void h0() {
        this.l.A(0L);
        d0();
    }

    public final void h1() {
        if (this.f57256c.C4()) {
            ViewStub viewStub = (ViewStub) this.f57257d.findViewById(R.id.manga_mention_controller_view_stub);
            this.k = viewStub;
            viewStub.setVisibility(0);
            if (this.v == null) {
                this.v = (LinearLayout) this.f57257d.findViewById(R.id.manga_controller_layout);
                d.a.n0.s0.a.a(this.f57256c.getPageContext(), this.v);
            }
            if (this.w == null) {
                this.w = (TextView) this.v.findViewById(R.id.manga_prev_btn);
            }
            if (this.x == null) {
                this.x = (TextView) this.v.findViewById(R.id.manga_next_btn);
            }
            this.w.setOnClickListener(this.J);
            this.x.setOnClickListener(this.J);
        }
    }

    public void h2() {
        f2();
        Y0();
        this.V0.c();
        V2(false);
    }

    public void h3(b.c cVar, boolean z2, boolean z3) {
        d.a.n0.r.s.j jVar = this.X;
        if (jVar != null) {
            jVar.dismiss();
            this.X = null;
        }
        d.a.n0.r.s.l lVar = new d.a.n0.r.s.l(this.f57256c.getContext());
        ArrayList arrayList = new ArrayList();
        arrayList.add(new d.a.n0.r.s.h(0, this.f57256c.getPageContext().getString(R.string.copy), lVar));
        if (z3) {
            arrayList.add(new d.a.n0.r.s.h(1, this.f57256c.getPageContext().getString(R.string.report_text), lVar));
        } else if (!z2) {
            arrayList.add(new d.a.n0.r.s.h(1, this.f57256c.getPageContext().getString(R.string.mark), lVar));
        } else {
            arrayList.add(new d.a.n0.r.s.h(1, this.f57256c.getPageContext().getString(R.string.remove_mark), lVar));
        }
        lVar.k(arrayList);
        lVar.n(new s(cVar));
        d.a.n0.r.s.j jVar2 = new d.a.n0.r.s.j(this.f57256c.getPageContext(), lVar);
        this.Y = jVar2;
        jVar2.l();
    }

    public void i0(int i2, boolean z2, String str, boolean z3) {
        this.f57256c.hideProgressBar();
        if (z2 && z3) {
            PbFragment pbFragment = this.f57256c;
            pbFragment.showToast(pbFragment.getPageContext().getString(R.string.success));
        } else if (z3) {
            if (d.a.c.e.p.k.isEmpty(str)) {
                str = TbadkCoreApplication.getInst().getResources().getString(R.string.neterror);
            }
            this.f57256c.showToast(str);
        }
    }

    public void i1() {
        EditorTools editorTools;
        if (this.f57256c == null || (editorTools = this.g0) == null) {
            return;
        }
        editorTools.j();
        if (this.f57256c.K4() != null) {
            this.f57256c.K4().P();
        }
        W0();
    }

    public final void i2() {
        d.a.o0.e2.k.e.a1.f fVar = this.p;
        if (fVar != null) {
            fVar.q(this.l, this.I0, this.C0);
        }
    }

    public void i3(AdapterView.OnItemClickListener onItemClickListener) {
        d.a.n0.r.s.e eVar = this.Z;
        if (eVar != null) {
            eVar.d();
            this.Z = null;
        }
        if (this.A0 == null) {
            return;
        }
        ArrayList<d.a.n0.r.s.n> arrayList = new ArrayList<>();
        arrayList.add(new d.a.n0.r.s.n(this.f57256c.getContext().getString(R.string.all_person), "", this.A0.I() == 1, Integer.toString(1)));
        arrayList.add(new d.a.n0.r.s.n(this.f57256c.getContext().getString(R.string.my_fans), "", this.A0.I() == 2, Integer.toString(5)));
        arrayList.add(new d.a.n0.r.s.n(this.f57256c.getContext().getString(R.string.my_attentions), "", this.A0.I() == 3, Integer.toString(6)));
        arrayList.add(new d.a.n0.r.s.n(this.f57256c.getContext().getString(R.string.myself_only), "", this.A0.I() == 4, Integer.toString(7)));
        d.a.n0.r.s.e eVar2 = new d.a.n0.r.s.e(this.f57256c.getPageContext());
        eVar2.l(R.string.pb_privacy_setting_thread_reply_decs);
        this.Z = eVar2;
        eVar2.k(arrayList, onItemClickListener);
        eVar2.c();
        this.Z.n();
    }

    public void j0() {
        PbLandscapeListView pbLandscapeListView = this.l;
        if (pbLandscapeListView != null) {
            pbLandscapeListView.setForbidDragListener(true);
        }
    }

    public void j1() {
        if (TbSingleton.getInstance().isShowRightFloatView(1)) {
            b();
        }
    }

    public void j2() {
        Handler handler = this.I1;
        if (handler == null) {
            return;
        }
        Runnable runnable = this.J1;
        if (runnable != null) {
            handler.removeCallbacks(runnable);
        }
        h hVar = new h();
        this.J1 = hVar;
        this.I1.postDelayed(hVar, 2000L);
    }

    public void j3() {
        PostData postData;
        if (!TbadkCoreApplication.isLogin() || this.A0 == null || !this.a1 || this.Z0 || this.b0 || (postData = this.B0) == null || postData.t() == null || this.B0.t().getIsLike() || this.B0.t().hadConcerned() || this.W0 != null) {
            return;
        }
        this.W0 = new o0(this.f57256c);
    }

    public final String k0(int i2) {
        if (i2 == 0) {
            return this.f57256c.getString(R.string.pb_comment_red_dot_no_reply);
        }
        NumberFormat numberFormat = NumberFormat.getInstance();
        numberFormat.setRoundingMode(RoundingMode.HALF_UP);
        if (i2 > 9990000) {
            return "· · ·";
        }
        if (i2 >= 1000000) {
            numberFormat.setMaximumFractionDigits(0);
            return numberFormat.format(i2 / 10000.0f) + "W";
        } else if (i2 >= 10000) {
            numberFormat.setMaximumFractionDigits(1);
            return numberFormat.format(i2 / 10000.0f) + "W";
        } else {
            return "" + i2;
        }
    }

    public final void k1() {
        if (this.t == null) {
            this.t = new d.a.o0.e2.k.e.a1.b(this.f57256c, this.J);
        }
    }

    public void k2(EditorTools editorTools) {
        this.g0 = editorTools;
        editorTools.setOnCancelClickListener(new j());
        this.g0.setId(R.id.pb_editor);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        if (this.g0.getParent() == null) {
            this.f57257d.addView(this.g0, layoutParams);
        }
        this.g0.w(TbadkCoreApplication.getInst().getSkinType());
        this.g0.setActionListener(24, new k());
        Y0();
        this.f57256c.K4().i(new l());
    }

    public final void k3(d.a.n0.r.s.a aVar, int i2) {
        PbFragment pbFragment = this.f57256c;
        if (pbFragment == null || aVar == null) {
            return;
        }
        if (this.n1 == null && this.q != null) {
            this.n1 = new d.a.o0.h.f(pbFragment.getPageContext(), this.q.c());
        }
        AntiData q4 = this.f57256c.q4();
        SparseArray<String> sparseArray = new SparseArray<>();
        if (q4 != null && q4.getDelThreadInfoList() != null) {
            List<DeleteThreadInfo> delThreadInfoList = q4.getDelThreadInfoList();
            for (int i3 = 0; i3 < delThreadInfoList.size(); i3++) {
                if (!TextUtils.isEmpty(delThreadInfoList.get(i3).text_info)) {
                    sparseArray.put(delThreadInfoList.get(i3).text_id, delThreadInfoList.get(i3).text_info);
                }
            }
        }
        d.a.n0.r.q.v0 v0Var = new d.a.n0.r.q.v0();
        v0Var.j(sparseArray);
        this.n1.x(new String[]{this.f57256c.getString(R.string.delete_thread_reason_1), this.f57256c.getString(R.string.delete_thread_reason_2), this.f57256c.getString(R.string.delete_thread_reason_3), this.f57256c.getString(R.string.delete_thread_reason_4), this.f57256c.getString(R.string.delete_thread_reason_5)});
        this.n1.w(v0Var);
        this.n1.z((i2 == 1 || i2 == 2) ? "4" : "3");
        this.n1.y(new o(aVar));
    }

    public d.a.o0.e2.k.e.i l0() {
        return this.z;
    }

    public void l1(d.a.o0.e2.h.e eVar) {
        PbReplyTitleViewHolder pbReplyTitleViewHolder;
        int i2 = 0;
        this.z.Z(eVar, false);
        this.z.U();
        d0();
        d.a.o0.e2.k.d.a aVar = this.i1;
        if (aVar != null) {
            aVar.n();
        }
        ArrayList<PostData> D = eVar.D();
        if (eVar.w().b() == 0 || D == null || D.size() < eVar.w().e()) {
            if (ListUtils.getCount(D) != 0 && (ListUtils.getCount(D) != 1 || D.get(0) == null || D.get(0).A() != 1)) {
                if (eVar.w().b() == 0) {
                    this.F.A(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                } else {
                    this.F.A(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                }
                this.F.j();
            } else {
                l0 l0Var = this.P0;
                if (l0Var != null && (pbReplyTitleViewHolder = l0Var.f57302c) != null && pbReplyTitleViewHolder.a() != null) {
                    i2 = this.P0.f57302c.a().getTop() < 0 ? this.P0.f57302c.a().getHeight() : this.P0.f57302c.a().getBottom();
                }
                if (this.f57256c.f5()) {
                    this.F.D(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_host_reply), i2);
                } else {
                    this.F.D(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_replay), i2);
                }
            }
        }
        Z1(eVar);
    }

    public void l2(String str) {
        PbListView pbListView = this.F;
        if (pbListView != null) {
            pbListView.A(str);
        }
    }

    public void l3() {
        this.I.setVisibility(0);
    }

    public LinearLayout m0() {
        return this.n0;
    }

    public boolean m1() {
        return this.O1;
    }

    public void m2(String str) {
        PbReplyTitleViewHolder pbReplyTitleViewHolder;
        if (this.F != null) {
            int i2 = 0;
            l0 l0Var = this.P0;
            if (l0Var != null && (pbReplyTitleViewHolder = l0Var.f57302c) != null && pbReplyTitleViewHolder.a() != null) {
                i2 = this.P0.f57302c.a().getTop() < 0 ? this.P0.f57302c.a().getHeight() : this.P0.f57302c.a().getBottom();
            }
            this.F.D(str, i2);
        }
    }

    public void m3() {
        RightFloatLayerView rightFloatLayerView = this.C1;
        if (rightFloatLayerView != null) {
            rightFloatLayerView.g();
        }
    }

    public View n0() {
        View view = this.R;
        if (view != null) {
            return view.findViewById(R.id.dialog_button_ok);
        }
        return null;
    }

    public boolean n1() {
        return this.w0;
    }

    public void n2(PbFragment.q2 q2Var) {
        this.L1 = q2Var;
    }

    public void n3(z0 z0Var, a.e eVar) {
        if (z0Var == null) {
            return;
        }
        int a3 = z0Var.a();
        int h2 = z0Var.h();
        d.a.n0.r.s.a aVar = this.A;
        if (aVar != null) {
            aVar.show();
        } else {
            this.A = new d.a.n0.r.s.a(this.f57256c.getPageContext().getPageActivity());
            View inflate = LayoutInflater.from(this.f57256c.getPageContext().getPageActivity()).inflate(R.layout.dialog_direct_pager, (ViewGroup) null);
            this.C = inflate;
            this.A.setContentView(inflate);
            this.A.setPositiveButton(R.string.dialog_ok, eVar);
            this.A.setNegativeButton(R.string.dialog_cancel, new z());
            this.A.setOnCalcelListener(new a0());
            this.A.create(this.f57256c.getPageContext()).show();
        }
        EditText editText = (EditText) this.C.findViewById(R.id.input_page_number);
        this.D = editText;
        editText.setText("");
        TextView textView = (TextView) this.C.findViewById(R.id.current_page_number);
        if (a3 <= 0) {
            a3 = 1;
        }
        if (h2 <= 0) {
            h2 = 1;
        }
        textView.setText(MessageFormat.format(TbadkCoreApplication.getInst().getResources().getString(R.string.current_page), Integer.valueOf(a3), Integer.valueOf(h2)));
        this.f57256c.getBaseFragmentActivity().ShowSoftKeyPadDelay(this.D, 150);
    }

    public String o0() {
        return this.W;
    }

    public final boolean o1(d.a.o0.e2.h.e eVar) {
        if (eVar == null || eVar.L() == null) {
            return false;
        }
        SpannableStringBuilder n1 = eVar.L().n1();
        if (n1 != null) {
            return TbadkApplication.getInst().getResources().getString(R.string.pb_default_share_tie_title).equals(n1.toString());
        }
        return true;
    }

    public void o2(boolean z2) {
        this.h0 = z2;
    }

    public void o3(boolean z2) {
        TextView textView;
        if (this.l == null || (textView = this.I0) == null || this.f57258e == null) {
            return;
        }
        if (z2) {
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.f57258e.setVisibility(0);
            } else {
                this.f57258e.setVisibility(8);
                this.l.removeHeaderView(this.I0);
                this.l.setTextViewAdded(false);
            }
            AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) this.I0.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = V1;
                this.I0.setLayoutParams(layoutParams);
            }
            i2();
            return;
        }
        AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) textView.getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT) + E0(true);
            this.I0.setLayoutParams(layoutParams2);
        }
        i2();
        c2();
    }

    public int p0() {
        View childAt;
        PbLandscapeListView pbLandscapeListView = this.l;
        if (pbLandscapeListView == null) {
            return 0;
        }
        int firstVisiblePosition = pbLandscapeListView.getFirstVisiblePosition();
        int lastVisiblePosition = this.l.getLastVisiblePosition();
        if (lastVisiblePosition > firstVisiblePosition) {
            int i2 = (lastVisiblePosition - firstVisiblePosition) + 1;
            int[] iArr = new int[i2];
            Rect rect = new Rect();
            int childCount = this.l.getChildCount();
            int i3 = 0;
            for (int i4 = firstVisiblePosition; i4 <= lastVisiblePosition; i4++) {
                int i5 = i4 - firstVisiblePosition;
                if (i5 < childCount && (childAt = this.l.getChildAt(i5)) != null) {
                    childAt.getGlobalVisibleRect(rect);
                    iArr[i5] = rect.height();
                }
                i3 += iArr[i5];
            }
            int i6 = i3 / 2;
            int i7 = 0;
            int i8 = 0;
            while (true) {
                if (i7 >= i2) {
                    break;
                }
                i8 += iArr[i7];
                if (i8 > i6) {
                    firstVisiblePosition += i7;
                    break;
                }
                i7++;
            }
        }
        if (firstVisiblePosition < 0) {
            return 0;
        }
        return firstVisiblePosition;
    }

    public boolean p1() {
        PbLandscapeListView pbLandscapeListView = this.l;
        if (pbLandscapeListView == null) {
            return false;
        }
        return pbLandscapeListView.J();
    }

    public void p2(boolean z2) {
        this.z.a0(z2);
    }

    public final void p3(d.a.o0.e2.h.e eVar) {
        if (eVar == null || eVar.L() == null || eVar.L().D2()) {
            return;
        }
        boolean z2 = eVar.L().x0() == 1;
        boolean z3 = eVar.L().y0() == 1;
        d.a.o0.e2.k.e.a1.e eVar2 = this.s;
        if (eVar2 != null) {
            eVar2.i(eVar, z2, z3);
        }
        d.a.o0.e2.k.e.i iVar = this.z;
        if (iVar == null || iVar.s() == null) {
            return;
        }
        this.z.s().d(eVar, z2, z3);
    }

    public PostData q0() {
        if (this.l == null) {
            return null;
        }
        int p0 = p0() - this.l.getHeaderViewsCount();
        int i2 = 0;
        if (p0 < 0) {
            p0 = 0;
        }
        if (this.z.x(p0) != null && this.z.x(p0) != PostData.t0) {
            i2 = p0 + 1;
        }
        if (this.z.w(i2) instanceof PostData) {
            return (PostData) this.z.w(i2);
        }
        return null;
    }

    public boolean q1() {
        EditorTools editorTools = this.g0;
        return editorTools != null && editorTools.getVisibility() == 0;
    }

    public void q2(boolean z2) {
        d.a.o0.e2.k.e.a1.f fVar = this.p;
        if (fVar != null) {
            fVar.r(z2);
        }
    }

    @SuppressLint({"CutPasteId"})
    public void q3(d.a.o0.e2.h.e eVar, boolean z2) {
        if (eVar == null) {
            return;
        }
        A3(eVar, z2);
        d0();
    }

    public FallingView r0() {
        return this.y1;
    }

    public final boolean r1(PostData postData) {
        if (postData == null || postData.t() == null) {
            return false;
        }
        MetaData t2 = postData.t();
        return (TextUtils.isEmpty(t2.getUserId()) && TextUtils.isEmpty(t2.getAvater())) ? false : true;
    }

    public void r2(boolean z2) {
        this.s1 = z2;
    }

    public void r3(String str) {
        this.f57256c.showToast(str);
    }

    public int s0() {
        return u0(this.l.getFirstVisiblePosition());
    }

    public boolean s1() {
        return false;
    }

    public void s2(boolean z2) {
        this.k1 = z2;
    }

    public void s3(final d.a.n0.t.a aVar, Bitmap bitmap, final int i2) {
        final Random random = new Random();
        c.b bVar = new c.b(bitmap);
        bVar.p(d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds8), true);
        bVar.o(d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds200), d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds200), true);
        bVar.m(d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds100), d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds100));
        bVar.n(new c.InterfaceC1353c() { // from class: d.a.o0.e2.k.e.b
            @Override // d.a.o0.e2.p.c.InterfaceC1353c
            public final float a() {
                return t0.B1(random);
            }
        });
        bVar.q(d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds40), true, true);
        d.a.o0.e2.p.c l2 = bVar.l();
        this.y1.f();
        this.y1.a(l2, 19);
        d.a.c.e.m.e.a().postDelayed(this.G1, 2000L);
        TiebaStatic.log(new StatisticItem("c14125").param("obj_type", i2).param("uid", TbadkCoreApplication.getCurrentAccount()));
        TbImageView tbImageView = this.z1;
        if (tbImageView != null) {
            tbImageView.setOnClickListener(new View.OnClickListener() { // from class: d.a.o0.e2.k.e.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    t0.this.C1(aVar, i2, view);
                }
            });
        }
    }

    public PostData t0(d.a.o0.e2.h.e eVar, boolean z2) {
        PostData postData = null;
        if (eVar == null) {
            return null;
        }
        if (eVar.T() != null) {
            return eVar.T();
        }
        if (!ListUtils.isEmpty(eVar.D())) {
            Iterator<PostData> it = eVar.D().iterator();
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
            postData = eVar.j();
        }
        if (!r1(postData)) {
            postData = L0(eVar);
        }
        if (postData != null && postData.t() != null && postData.t().getUserTbVipInfoData() != null && postData.t().getUserTbVipInfoData().getvipIntro() != null) {
            postData.t().getGodUserData().setIntro(postData.t().getUserTbVipInfoData().getvipIntro());
        }
        return postData;
    }

    public final boolean t1() {
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.P1);
    }

    public void t2(boolean z2) {
        d.a.o0.e2.k.e.a1.f fVar = this.p;
        if (fVar != null) {
            fVar.s(z2);
        }
    }

    public void t3() {
        this.f57256c.showProgressBar();
    }

    public final int u0(int i2) {
        d.a.c.k.e.e adapter2 = this.l.getAdapter2();
        if (adapter2 == null) {
            return i2;
        }
        if (i2 < adapter2.getCount() && i2 >= 0) {
            adapter2.getItem(i2);
        }
        int o2 = (adapter2.o() + adapter2.m()) - 1;
        if (i2 > o2) {
            i2 = o2;
        }
        int n2 = (this.l.getAdapter2() == null || !(this.l.getAdapter2() instanceof d.a.c.k.e.e)) ? 0 : this.l.getAdapter2().n();
        if (i2 > n2) {
            return i2 - n2;
        }
        return 0;
    }

    public final boolean u1(a2 a2Var) {
        if (a2Var == null || a2Var.T() == null) {
            return false;
        }
        PostData t0 = t0(this.A0, false);
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), (t0 == null || t0.t() == null) ? "" : t0.t().getUserId());
    }

    public void u2(boolean z2) {
        this.z.c0(z2);
    }

    public void u3() {
        FallingView fallingView = this.y1;
        if (fallingView != null) {
            fallingView.g();
        }
        if (this.z1 != null) {
            d.a.c.e.m.e.a().removeCallbacks(this.G1);
            this.z1.setVisibility(8);
        }
    }

    public Button v0() {
        return this.k0;
    }

    public boolean v1() {
        View view = this.M0;
        if (view == null || view.getParent() == null || this.F.l()) {
            return false;
        }
        int bottom = this.M0.getBottom();
        Rect rect = new Rect();
        this.M0.getWindowVisibleDisplayFrame(rect);
        return bottom > 0 && bottom <= rect.bottom;
    }

    public void v2(boolean z2) {
        this.z.h0(z2);
    }

    public void v3() {
        if (this.R1 != null) {
            while (this.R1.size() > 0) {
                TbImageView remove = this.R1.remove(0);
                if (remove != null) {
                    remove.Z();
                }
            }
        }
    }

    public int w0() {
        return this.l.getHeaderViewsCount();
    }

    public boolean w1() {
        d.a.o0.e2.h.e eVar = this.A0;
        return eVar == null || eVar.l() == null || "0".equals(this.A0.l().getId()) || "me0407".equals(this.A0.l().getName());
    }

    public void w2(f.g gVar) {
        this.Q1 = gVar;
        d.a.o0.e2.p.i iVar = this.E;
        if (iVar != null) {
            iVar.a(gVar);
        }
    }

    public void w3(boolean z2) {
        this.a0 = z2;
    }

    public TextView x0() {
        return this.s.k();
    }

    public boolean x1() {
        d.a.o0.e2.k.e.a1.f fVar = this.p;
        return fVar != null && fVar.f();
    }

    public void x2(String str) {
        d.a.o0.e2.k.e.f1.b bVar = this.f57262i;
        if (bVar != null) {
            bVar.b(str);
        }
    }

    public void x3(boolean z2) {
        this.f57261h.z(z2);
        if (z2 && this.E0) {
            this.F.A(TbadkCoreApplication.getInst().getResources().getString(R.string.click_load_more));
            this.l.setNextPage(this.F);
            this.f57259f = 2;
        }
        D1();
    }

    public PbInterviewStatusView y0() {
        return this.G0;
    }

    public boolean y1() {
        return this.A1;
    }

    public void y2(boolean z2) {
        this.X0 = z2;
        PbLandscapeListView pbLandscapeListView = this.l;
        if (pbLandscapeListView != null) {
            this.Y0 = pbLandscapeListView.getHeaderViewsCount();
        }
    }

    public void y3(d.a.o0.e2.h.c cVar) {
        String string;
        if (cVar == null) {
            return;
        }
        this.f57261h.A();
        if (!StringUtils.isNull(cVar.f56728b)) {
            this.f57261h.x(cVar.f56728b);
        }
        String string2 = TbadkCoreApplication.getInst().getResources().getString(R.string.thread_delete_by);
        int d3 = d.a.c.e.m.b.d(cVar.f56727a, 0);
        if (d3 == 100) {
            string = TbadkCoreApplication.getInst().getResources().getString(R.string.self);
        } else if (d3 != 300) {
            string = d3 != 400 ? "" : TbadkCoreApplication.getInst().getResources().getString(R.string.system);
        } else {
            string = TbadkCoreApplication.getInst().getResources().getString(R.string.bawu);
        }
        this.f57256c.showNetRefreshView(this.f57257d, String.format(string2, string), null, TbadkCoreApplication.getInst().getResources().getString(R.string.appeal_restore), true, new x(cVar.f56729c));
    }

    public boolean z0() {
        return this.k1;
    }

    public boolean z1() {
        EditorTools editorTools = this.g0;
        return editorTools != null && editorTools.u();
    }

    public void z2(PbFragment.r2 r2Var) {
    }

    public void z3(d.a.o0.e2.h.e eVar) {
        if (eVar != null && AntiHelper.o(eVar.L())) {
            d.a.o0.e2.p.h hVar = this.t0;
            if (hVar != null) {
                hVar.h(false);
                this.t0.g();
            }
            ViewGroup.LayoutParams layoutParams = this.s0.getLayoutParams();
            layoutParams.height = -2;
            layoutParams.width = -2;
            this.s0.setLayoutParams(layoutParams);
            WebPManager.setPureDrawable(this.s0, R.drawable.icon_pure_pb_bottom_share26, R.color.CAM_X0110, WebPManager.ResourceStateType.NORMAL_PRESS);
            return;
        }
        d.a.o0.e2.p.h hVar2 = this.t0;
        if (hVar2 == null || !hVar2.e()) {
            ViewGroup.LayoutParams layoutParams2 = this.s0.getLayoutParams();
            layoutParams2.height = -2;
            layoutParams2.width = -2;
            this.s0.setLayoutParams(layoutParams2);
            WebPManager.setPureDrawable(this.s0, R.drawable.icon_pure_pb_bottom_share26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        }
    }
}

package d.b.i0.c2.k.e;

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
import androidx.exifinterface.media.ExifInterface;
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
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.DialogLoginHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
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
import com.baidu.tieba.pb.view.PbInterviewStatusView;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.view.NavigationBarCoverTip;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import d.b.h0.r.f0.f;
import d.b.h0.r.q.a2;
import d.b.h0.r.q.w1;
import d.b.h0.r.q.z0;
import d.b.h0.r.s.a;
import d.b.h0.r.s.b;
import d.b.h0.r.s.l;
import d.b.i0.c2.i.a;
import d.b.i0.c3.g0.a;
import java.math.RoundingMode;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes4.dex */
public class q0 {
    public static final int K1 = UtilHelper.getLightStatusBarHeight();
    public static int L1 = 3;
    public static int M1 = 0;
    public static int N1 = 3;
    public static int O1 = 4;
    public static int P1 = 5;
    public static int Q1 = 6;
    public static final int R1 = d.b.b.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds80);
    public static a.f S1 = new u();
    public int A0;
    public PbFragment.m2 A1;
    public ViewStub D0;
    public PbListView E;
    public PbInterviewStatusView E0;
    public FrameLayout F0;
    public f.g F1;
    public View G;
    public TextView G0;
    public View H;
    public View H0;
    public int H1;
    public View.OnClickListener I;
    public View I0;
    public PbReplyTitleViewHolder J0;
    public boolean J1;
    public View K0;
    public View.OnClickListener M;
    public PbEmotionBar O0;
    public int Q0;
    public Runnable R0;
    public PbFakeFloorModel S0;
    public d.b.i0.c2.k.e.s T0;
    public m0 U0;

    /* renamed from: a  reason: collision with root package name */
    public int f52761a;
    public int a1;

    /* renamed from: b  reason: collision with root package name */
    public PbFragment f52762b;
    public PbTopTipView b1;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f52763c;
    public PopupWindow c1;

    /* renamed from: d  reason: collision with root package name */
    public View f52764d;
    public d.b.i0.c2.i.c d0;
    public TextView d1;
    public List<String> e1;
    public EditorTools f0;
    public d.b.i0.c2.k.e.y0.c f1;

    /* renamed from: g  reason: collision with root package name */
    public final d.b.i0.c2.k.e.c1.c f52767g;
    public d.b.i0.c2.k.d.a g1;

    /* renamed from: h  reason: collision with root package name */
    public d.b.i0.c2.k.e.c1.b f52768h;
    public View h0;
    public PbLandscapeListView.c h1;
    public ViewStub i;
    public ViewStub j;
    public View j0;
    public f0 j1;
    public PbLandscapeListView k;
    public View k0;
    public NavigationBarCoverTip k1;
    public NoNetworkView l;
    public LinearLayout l0;
    public String l1;
    public List<CustomBlueCheckRadioButton> m;
    public HeadImageView m0;
    public PermissionJudgePolicy m1;
    public PbThreadPostView n;
    public TextView n0;
    public long n1;
    public d.b.i0.c2.k.e.x0.f o;
    public ImageView o0;
    public boolean o1;
    public d.b.i0.c2.k.e.x0.a p;
    public ImageView p0;
    public int p1;
    public d.b.i0.c2.k.e.x0.c q;
    public ImageView q0;
    public d.b.i0.c2.k.e.x0.e r;
    public d.b.i0.c2.p.d r0;
    public d.b.i0.c2.p.c r1;
    public d.b.i0.c2.k.e.x0.b s;
    public TextView s0;
    public MaskView s1;
    public d.b.i0.c2.k.e.x0.d t;
    public TextView t0;
    public boolean t1;
    public LinearLayout u;
    public String u1;
    public TextView v;
    public int v0;
    public TextView w;
    public ObservedChangeRelativeLayout x;
    public d.b.i0.c2.k.e.g y;
    public d.b.i0.c2.h.e y0;
    public Runnable y1;
    public PostData z0;

    /* renamed from: e  reason: collision with root package name */
    public int f52765e = 0;

    /* renamed from: f  reason: collision with root package name */
    public final Handler f52766f = new Handler();
    public d.b.h0.r.s.a z = null;
    public d.b.h0.r.s.b A = null;
    public View B = null;
    public EditText C = null;
    public d.b.i0.c2.p.e D = null;
    public d.b.i0.c2.p.a F = null;
    public TbRichTextView.w J = null;
    public NoNetworkView.b K = null;
    public d.b.h0.r.s.j L = null;
    public d.b.h0.r.s.a N = null;
    public Dialog O = null;
    public Dialog P = null;
    public View Q = null;
    public LinearLayout R = null;
    public CompoundButton.OnCheckedChangeListener S = null;
    public TextView T = null;
    public TextView U = null;
    public String V = null;
    public d.b.h0.r.s.j W = null;
    public d.b.h0.r.s.j X = null;
    public d.b.h0.r.s.e Y = null;
    public boolean Z = false;
    public boolean a0 = false;
    public String b0 = null;
    public String c0 = null;
    public ScrollView e0 = null;
    public boolean g0 = false;
    public Button i0 = null;
    public boolean u0 = true;
    public d.b.h0.r.f0.a w0 = null;
    public boolean x0 = false;
    public int B0 = 3;
    public boolean C0 = false;
    public int L0 = 0;
    public boolean M0 = true;
    public d0 N0 = new d0();
    public int P0 = 0;
    public boolean V0 = false;
    public int W0 = 0;
    public boolean X0 = false;
    public boolean Y0 = false;
    public boolean Z0 = false;
    public boolean i1 = false;
    public int q1 = 0;
    public CustomMessageListener v1 = new x(2921306);
    public CustomMessageListener w1 = new b(2005016);
    public Handler x1 = new Handler();
    public CustomMessageListener z1 = new d(2004009);
    public boolean B1 = true;
    public View.OnClickListener C1 = new n();
    public boolean D1 = false;
    public String E1 = null;
    public final List<TbImageView> G1 = new ArrayList();
    public boolean I1 = false;

    /* loaded from: classes4.dex */
    public class a implements PbLandscapeListView.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f52769a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PbReplyTitleViewHolder f52770b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f52771c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f52772d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f52773e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f52774f;

        /* renamed from: d.b.i0.c2.k.e.q0$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC1154a implements Runnable {
            public RunnableC1154a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (q0.this.K0 == null || q0.this.K0.getLayoutParams() == null) {
                    return;
                }
                ViewGroup.LayoutParams layoutParams = q0.this.K0.getLayoutParams();
                layoutParams.height = q0.this.Q0;
                q0.this.K0.setLayoutParams(layoutParams);
            }
        }

        public a(int i, PbReplyTitleViewHolder pbReplyTitleViewHolder, boolean z, int i2, int i3, int i4) {
            this.f52769a = i;
            this.f52770b = pbReplyTitleViewHolder;
            this.f52771c = z;
            this.f52772d = i2;
            this.f52773e = i3;
            this.f52774f = i4;
        }

        @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.b
        public void onLayout() {
            ViewGroup.LayoutParams layoutParams;
            int i;
            int i2 = this.f52769a;
            if (i2 >= 0 && i2 <= q0.this.f52763c.getMeasuredHeight()) {
                int F0 = q0.this.F0(this.f52770b);
                int i3 = this.f52769a;
                int i4 = F0 - i3;
                if (this.f52771c && i4 != 0 && i3 <= (i = this.f52772d)) {
                    i4 = F0 - i;
                }
                if (q0.this.K0 == null || (layoutParams = q0.this.K0.getLayoutParams()) == null) {
                    return;
                }
                if (i4 == 0 || i4 > q0.this.f52763c.getMeasuredHeight() || F0 >= q0.this.f52763c.getMeasuredHeight()) {
                    layoutParams.height = q0.this.Q0;
                } else {
                    if (layoutParams != null) {
                        int i5 = layoutParams.height;
                        if (i5 + i4 > 0 && i5 + i4 <= q0.this.f52763c.getMeasuredHeight()) {
                            layoutParams.height += i4;
                            q0.this.k.setSelectionFromTop(this.f52773e, this.f52774f);
                        }
                    }
                    layoutParams.height = q0.this.Q0;
                }
                q0.this.K0.setLayoutParams(layoutParams);
                d.b.b.e.m.e.a().post(new RunnableC1154a());
            }
            q0.this.k.setOnLayoutListener(null);
        }
    }

    /* loaded from: classes4.dex */
    public class a0 implements View.OnClickListener {
        public a0() {
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
                    q0.this.f52762b.T3(sparseArray);
                    return;
                }
                q0.this.G1(view);
            } else if (booleanValue2) {
                sparseArray.put(R.id.tag_from, 0);
                sparseArray.put(R.id.tag_check_mute_from, 1);
                q0.this.f52762b.T3(sparseArray);
            } else if (booleanValue3) {
                q0.this.D1(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public b(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2005016 || q0.this.y == null) {
                return;
            }
            q0.this.y.U();
        }
    }

    /* loaded from: classes4.dex */
    public class b0 implements View.OnClickListener {
        public b0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            q0.this.S1();
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (q0.this.u == null) {
                q0.this.Y0();
            }
            q0.this.j.setVisibility(0);
        }
    }

    /* loaded from: classes4.dex */
    public class c0 implements PbFakeFloorModel.b {
        public c0() {
        }

        @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.b
        public void a(PostData postData) {
            q0.this.S0.A(postData);
            q0.this.y.U();
            q0.this.T0.c();
            q0.this.f0.q();
            q0.this.F2(false);
        }
    }

    /* loaded from: classes4.dex */
    public class d extends CustomMessageListener {
        public d(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null) {
                return;
            }
            q0.this.u0 = false;
        }
    }

    /* loaded from: classes4.dex */
    public static class d0 {

        /* renamed from: a  reason: collision with root package name */
        public int f52783a;

        /* renamed from: b  reason: collision with root package name */
        public int f52784b;

        /* renamed from: c  reason: collision with root package name */
        public PbReplyTitleViewHolder f52785c;
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            q0.this.S1();
        }
    }

    /* loaded from: classes4.dex */
    public class f implements d.b.h0.w.b {
        public f() {
        }

        @Override // d.b.h0.w.b
        public void onAction(d.b.h0.w.a aVar) {
            Object obj = aVar.f51526c;
            if (obj instanceof d.b.h0.s.c.t) {
                if (((d.b.h0.s.c.t) obj).e() == EmotionGroupType.BIG_EMOTION || ((d.b.h0.s.c.t) aVar.f51526c).e() == EmotionGroupType.USER_COLLECT) {
                    if (q0.this.m1 == null) {
                        q0.this.m1 = new PermissionJudgePolicy();
                    }
                    q0.this.m1.clearRequestPermissionList();
                    q0.this.m1.appendRequestPermission(q0.this.f52762b.getBaseFragmentActivity(), StorageUtils.EXTERNAL_STORAGE_PERMISSION);
                    if (q0.this.m1.startRequestPermission(q0.this.f52762b.getBaseFragmentActivity())) {
                        return;
                    }
                    q0.this.f52762b.D4().h((d.b.h0.s.c.t) aVar.f51526c);
                    q0.this.f52762b.D4().z(false, null);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements TextWatcher {
        public g() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (q0.this.f52762b.x0 == null || q0.this.f52762b.x0.e() == null) {
                return;
            }
            if (!q0.this.f52762b.x0.e().e()) {
                q0.this.f52762b.x0.a(false);
            }
            q0.this.f52762b.x0.e().l(false);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            int i4;
            if (q0.this.f0 != null && q0.this.f0.getVisibility() == 0 && charSequence != null && charSequence.length() >= (i4 = i3 + i)) {
                String substring = charSequence.toString().substring(i, i4);
                if (TextUtils.isEmpty(substring)) {
                    return;
                }
                if (q0.this.f1 == null) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.addRule(11);
                    layoutParams.addRule(2, q0.this.f0.getId());
                    q0 q0Var = q0.this;
                    q0Var.f1 = new d.b.i0.c2.k.e.y0.c(q0Var.f52762b.getPageContext(), q0.this.f52763c, layoutParams);
                    if (!ListUtils.isEmpty(q0.this.e1)) {
                        q0.this.f1.q(q0.this.e1);
                    }
                    q0.this.f1.r(q0.this.f0);
                }
                q0.this.f1.p(substring);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements l.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f52789e;

        public h(boolean z) {
            this.f52789e = z;
        }

        @Override // d.b.h0.r.s.l.e
        public void onItemClick(d.b.h0.r.s.l lVar, int i, View view) {
            q0.this.L.dismiss();
            SparseArray<Object> sparseArray = (SparseArray) view.getTag();
            if (sparseArray == null) {
                return;
            }
            switch (i) {
                case 10:
                    q0.this.D1(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                    return;
                case 11:
                    if (q0.this.A1 != null) {
                        q0.this.A1.a(new Object[]{sparseArray.get(R.id.tag_manage_user_identity), sparseArray.get(R.id.tag_forbid_user_name), sparseArray.get(R.id.tag_forbid_user_post_id), sparseArray.get(R.id.tag_forbid_user_name_show), sparseArray.get(R.id.tag_forbid_user_portrait)});
                        return;
                    }
                    return;
                case 12:
                    q0.this.f52762b.N4(this.f52789e, (String) sparseArray.get(R.id.tag_user_mute_mute_userid), sparseArray);
                    return;
                default:
                    return;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i implements a.e {
        public i(q0 q0Var) {
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public class j implements CompoundButton.OnCheckedChangeListener {
        public j() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (z) {
                q0.this.V = (String) compoundButton.getTag();
                if (q0.this.m != null) {
                    for (CustomBlueCheckRadioButton customBlueCheckRadioButton : q0.this.m) {
                        String str = (String) customBlueCheckRadioButton.getTag();
                        if (str != null && q0.this.V != null && !str.equals(q0.this.V)) {
                            customBlueCheckRadioButton.setChecked(false);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class k implements View.OnClickListener {
        public k() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (q0.this.P instanceof Dialog) {
                d.b.b.e.m.g.b(q0.this.P, q0.this.f52762b.getPageContext());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class l implements l.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.c f52793e;

        public l(b.c cVar) {
            this.f52793e = cVar;
        }

        @Override // d.b.h0.r.s.l.e
        public void onItemClick(d.b.h0.r.s.l lVar, int i, View view) {
            q0.this.X.dismiss();
            this.f52793e.a(null, i, view);
        }
    }

    /* loaded from: classes4.dex */
    public class m implements l.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.c f52795e;

        public m(b.c cVar) {
            this.f52795e = cVar;
        }

        @Override // d.b.h0.r.s.l.e
        public void onItemClick(d.b.h0.r.s.l lVar, int i, View view) {
            q0.this.X.dismiss();
            this.f52795e.a(null, i, view);
        }
    }

    /* loaded from: classes4.dex */
    public class n implements View.OnClickListener {
        public n() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!(view instanceof HeadImageView) || q0.this.y0 == null || q0.this.y0.L() == null || q0.this.y0.L().T() == null || q0.this.y0.L().T().getAlaInfo() == null || q0.this.y0.L().T().getAlaInfo().live_status != 1) {
                if (q0.this.X0) {
                    TiebaStatic.log(new StatisticItem("c11923").param("obj_id", 2));
                }
                if (!q0.this.X0 && q0.this.y0 != null && q0.this.y0.L() != null && q0.this.y0.L().T() != null && q0.this.y0.L().T().isBigV()) {
                    TiebaStatic.log(new StatisticItem("c12151").param("obj_locate", 1));
                }
                if (q0.this.f52762b.P() != null) {
                    q0.this.f52762b.P().mEvent.f52995b.onClick(view);
                    return;
                }
                return;
            }
            StatisticItem statisticItem = new StatisticItem("c11851");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(statisticItem);
            if (q0.this.y0.L().T().getAlaInfo() == null || !q0.this.y0.L().T().getAlaInfo().isChushou) {
                if (q0.this.y0.L().T().getAlaInfo().live_id > 0) {
                    AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                    alaLiveInfoCoreData.liveID = q0.this.y0.L().T().getAlaInfo().live_id;
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(q0.this.f52762b.P(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_PB_USER_ICON_LIVE, null, false, "")));
                    return;
                }
                return;
            }
            UrlManager urlManager = UrlManager.getInstance();
            TbPageContext<BaseFragmentActivity> pageContext = q0.this.f52762b.getPageContext();
            urlManager.dealOneLink(pageContext, new String[]{"tiebachushou://liveroom?roomid=" + q0.this.y0.L().T().getAlaInfo().thirdRoomId + "&livetype=" + q0.this.y0.L().T().getAlaInfo().thirdLiveType});
        }
    }

    /* loaded from: classes4.dex */
    public class o implements Runnable {
        public o() {
        }

        @Override // java.lang.Runnable
        public void run() {
            q0 q0Var;
            d.b.i0.c2.k.e.c1.c cVar;
            LinearLayout linearLayout;
            if (q0.this.y == null || (cVar = (q0Var = q0.this).f52767g) == null || cVar.i == null || q0Var.y0 == null || q0.this.y0.L() == null || q0.this.y0.L().y2() || q0.this.m1() || q0.this.y0.l() == null || d.b.b.e.p.k.isEmpty(q0.this.y0.l().getName())) {
                return;
            }
            if ((q0.this.y.G() == null || !q0.this.y.G().isShown()) && (linearLayout = q0.this.f52767g.i) != null) {
                linearLayout.setVisibility(0);
                if (q0.this.f52762b == null || q0.this.f52762b.L() == null) {
                    return;
                }
                StatisticItem statisticItem = new StatisticItem("c13400");
                statisticItem.param("tid", q0.this.f52762b.L().O0());
                statisticItem.param("fid", q0.this.f52762b.L().getForumId());
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class p implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f52799e;

        public p(String str) {
            this.f52799e = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d.b.b.e.p.l.C()) {
                UrlManager.getInstance().dealOneLink(q0.this.f52762b.getPageContext(), new String[]{this.f52799e});
                q0.this.f52762b.finish();
                return;
            }
            q0.this.f52762b.showToast(R.string.neterror);
        }
    }

    /* loaded from: classes4.dex */
    public class q implements PbLandscapeListView.c {
        public q() {
        }

        @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.c
        public void a(int i, int i2, float f2, float f3, float f4, float f5) {
            if (q0.this.f52762b == null || !q0.this.f52762b.isAdded()) {
                return;
            }
            if (i < 0 && f2 > q0.this.a1) {
                q0.this.T();
                q0.this.w1();
            }
            q0.this.a0();
        }
    }

    /* loaded from: classes4.dex */
    public class r implements a.e {
        public r() {
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            q0.this.T();
            aVar.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public class s implements DialogInterface.OnCancelListener {

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                q0.this.f52762b.HidenSoftKeyPad((InputMethodManager) q0.this.f52762b.getBaseFragmentActivity().getSystemService("input_method"), q0.this.f52763c);
            }
        }

        public s() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            if (q0.this.R0 == null) {
                q0.this.R0 = new a();
            }
            d.b.b.e.m.e.a().postDelayed(q0.this.R0, 150L);
        }
    }

    /* loaded from: classes4.dex */
    public class t implements a.e {
        public t(q0 q0Var) {
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public static class u implements a.f {
        @Override // d.b.i0.c3.g0.a.f
        public void onRefresh() {
        }
    }

    /* loaded from: classes4.dex */
    public class v implements a.e {
        public v(q0 q0Var) {
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public class w implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f52805e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f52806f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f52807g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ View f52808h;

        public w(int i, int i2, int i3, View view) {
            this.f52805e = i;
            this.f52806f = i2;
            this.f52807g = i3;
            this.f52808h = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i = this.f52805e;
            if (i == this.f52806f || i - this.f52807g >= 0) {
                q0.this.c1.showAsDropDown(q0.this.k0, this.f52808h.getLeft(), -q0.this.k0.getHeight());
            } else {
                q0.this.c1.showAsDropDown(this.f52808h);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class x extends CustomMessageListener {
        public x(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2921306) {
                return;
            }
            q0.this.u1 = null;
        }
    }

    /* loaded from: classes4.dex */
    public class y implements a.b {
        public y() {
        }

        @Override // d.b.i0.c2.i.a.b
        public void a() {
            q0.this.f52762b.Q4();
        }

        @Override // d.b.i0.c2.i.a.b
        public void b() {
            if (q0.this.k != null) {
                if (q0.this.o != null) {
                    q0.this.o.u();
                }
                q0.this.k.setSelection(0);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class z implements View.OnClickListener {
        public z() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (DialogLoginHelper.checkUpIsLogin(new d.b.h0.r.q.r0(q0.this.f52762b.getActivity(), "pb_huitie"))) {
                q0.this.f52762b.s5();
                if (q0.this.f52762b == null || q0.this.f52762b.L() == null || q0.this.f52762b.L().y0() == null || q0.this.f52762b.L().y0().L() == null || q0.this.f52762b.L().y0().L().T() == null) {
                    return;
                }
                TiebaStatic.log(new StatisticItem("c13701").param("tid", q0.this.f52762b.L().P0()).param("fid", q0.this.f52762b.L().y0().m()).param("uid", TbadkCoreApplication.getCurrentAccountId()));
                TiebaStatic.log(new StatisticItem("c13402").param("tid", q0.this.f52762b.L().f19731e).param("fid", q0.this.f52762b.L().y0().m()).param("obj_locate", 1).param("uid", q0.this.f52762b.L().y0().L().T().getUserId()));
            }
        }
    }

    public q0(PbFragment pbFragment, View.OnClickListener onClickListener, d.b.i0.c2.i.c cVar) {
        this.f52762b = null;
        this.f52763c = null;
        this.f52764d = null;
        this.k = null;
        this.y = null;
        this.E = null;
        this.G = null;
        this.I = null;
        this.M = null;
        this.k0 = null;
        this.n0 = null;
        this.D0 = null;
        this.a1 = 0;
        this.n1 = 0L;
        this.n1 = System.currentTimeMillis();
        this.f52762b = pbFragment;
        this.I = onClickListener;
        this.d0 = cVar;
        this.a1 = d.b.b.e.p.l.k(pbFragment.getContext()) / 8;
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.f52762b.getPageContext().getPageActivity()).inflate(R.layout.new_pb_activity, (ViewGroup) null);
        this.f52763c = relativeLayout;
        relativeLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.h0 = this.f52763c.findViewById(R.id.bottom_shadow);
        this.k1 = (NavigationBarCoverTip) this.f52763c.findViewById(R.id.pb_multi_forum_del_tip_view);
        this.f52764d = this.f52763c.findViewById(R.id.statebar_view);
        this.x = (ObservedChangeRelativeLayout) this.f52763c.findViewById(R.id.title_wrapper);
        this.l = (NoNetworkView) this.f52763c.findViewById(R.id.view_no_network);
        this.k = (PbLandscapeListView) this.f52763c.findViewById(R.id.new_pb_list);
        this.F0 = (FrameLayout) this.f52763c.findViewById(R.id.root_float_header);
        this.G0 = new TextView(this.f52762b.getActivity());
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + d.b.b.e.p.l.g(this.f52762b.getActivity(), R.dimen.ds88));
        this.k.x(this.G0, 0);
        this.k.setTextViewAdded(true);
        this.Q0 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds134);
        View view = new View(this.f52762b.getPageContext().getPageActivity());
        this.K0 = view;
        view.setLayoutParams(new AbsListView.LayoutParams(-1, this.Q0));
        this.K0.setVisibility(4);
        this.k.addFooterView(this.K0);
        this.k.setOnTouchListener(this.f52762b.r2);
        this.f52767g = new d.b.i0.c2.k.e.c1.c(pbFragment, this.f52763c);
        if (this.f52762b.v4()) {
            ViewStub viewStub = (ViewStub) this.f52763c.findViewById(R.id.manga_view_stub);
            this.i = viewStub;
            viewStub.setVisibility(0);
            d.b.i0.c2.k.e.c1.b bVar = new d.b.i0.c2.k.e.c1.b(pbFragment);
            this.f52768h = bVar;
            bVar.c();
            this.f52767g.f52649a.setVisibility(8);
            layoutParams.height = d.b.b.e.p.l.g(this.f52762b.getActivity(), R.dimen.ds120);
        }
        this.G0.setLayoutParams(layoutParams);
        this.f52767g.i().setOnTouchListener(new d.b.i0.c2.i.a(new y()));
        this.j0 = this.f52763c.findViewById(R.id.view_comment_top_line);
        this.k0 = this.f52763c.findViewById(R.id.pb_editor_tool_comment);
        d.b.b.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds120);
        this.v0 = d.b.b.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.ds242);
        HeadImageView headImageView = (HeadImageView) this.f52763c.findViewById(R.id.pb_editor_tool_comment_user_image);
        this.m0 = headImageView;
        headImageView.setVisibility(0);
        this.m0.setIsRound(true);
        this.m0.setBorderWidth(d.b.b.e.p.l.g(this.f52762b.getContext(), R.dimen.L_X01));
        this.m0.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
        this.m0.setPlaceHolder(0);
        q1();
        this.n0 = (TextView) this.f52763c.findViewById(R.id.pb_editor_tool_comment_reply_text);
        LinearLayout linearLayout = (LinearLayout) this.f52763c.findViewById(R.id.pb_editer_tool_comment_layout);
        this.l0 = linearLayout;
        linearLayout.setOnClickListener(new z());
        this.o0 = (ImageView) this.f52763c.findViewById(R.id.pb_editor_tool_comment_icon);
        this.s1 = (MaskView) this.f52763c.findViewById(R.id.mask_view);
        this.o0.setOnClickListener(this.I);
        boolean booleanExtra = this.f52762b.getBaseFragmentActivity().getIntent().getBooleanExtra("key_is_from_dynamic", false);
        ImageView imageView = (ImageView) this.f52763c.findViewById(R.id.pb_editor_tool_collection);
        this.p0 = imageView;
        imageView.setOnClickListener(this.I);
        if (booleanExtra) {
            this.p0.setVisibility(8);
        } else {
            this.p0.setVisibility(0);
        }
        ImageView imageView2 = (ImageView) this.f52763c.findViewById(R.id.pb_editor_tool_share);
        this.q0 = imageView2;
        imageView2.setOnClickListener(this.I);
        d.b.i0.c2.p.d dVar = new d.b.i0.c2.p.d(this.q0);
        this.r0 = dVar;
        dVar.d();
        TextView textView = (TextView) this.f52763c.findViewById(R.id.pb_editor_tool_comment_red_dot);
        this.s0 = textView;
        textView.setVisibility(0);
        this.D0 = (ViewStub) this.f52763c.findViewById(R.id.interview_status_stub);
        this.p = new d.b.i0.c2.k.e.x0.a(this.f52762b, cVar);
        this.r = new d.b.i0.c2.k.e.x0.e(this.f52762b, cVar, this.I);
        d.b.i0.c2.k.e.g gVar = new d.b.i0.c2.k.e.g(this.f52762b, this.k);
        this.y = gVar;
        gVar.n0(this.I);
        this.y.o0(this.d0);
        this.y.k0(this.J);
        this.y.m0(this.f52762b.S1);
        a0 a0Var = new a0();
        this.M = a0Var;
        this.y.j0(a0Var);
        a1();
        W0();
        d.b.i0.c2.k.e.x0.d dVar2 = new d.b.i0.c2.k.e.x0.d(this.f52762b);
        this.t = dVar2;
        dVar2.f52911f = 2;
        this.q.a(this.k);
        this.r.g(this.k);
        this.p.a(this.k);
        PbListView pbListView = new PbListView(this.f52762b.getPageContext().getPageActivity());
        this.E = pbListView;
        View findViewById = pbListView.b().findViewById(R.id.pb_more_view);
        this.G = findViewById;
        if (findViewById != null) {
            findViewById.setOnClickListener(this.I);
            SkinManager.setBackgroundResource(this.G, R.drawable.pb_foot_more_trans_selector);
        }
        this.E.x();
        this.E.n(R.drawable.pb_foot_more_trans_selector);
        this.E.o(R.drawable.pb_foot_more_trans_selector);
        this.H = this.f52763c.findViewById(R.id.viewstub_progress);
        this.f52762b.registerListener(this.z1);
        this.S0 = new PbFakeFloorModel(this.f52762b.getPageContext());
        d.b.i0.c2.k.e.s sVar = new d.b.i0.c2.k.e.s(this.f52762b.getPageContext(), this.S0, this.f52763c);
        this.T0 = sVar;
        sVar.k(new b0());
        this.T0.m(this.f52762b.W1);
        this.S0.D(new c0());
        if (this.f52762b.L() != null && !StringUtils.isNull(this.f52762b.L().B0())) {
            PbFragment pbFragment2 = this.f52762b;
            pbFragment2.showToast(pbFragment2.L().B0());
        }
        this.H0 = this.f52763c.findViewById(R.id.pb_expand_blank_view);
        View findViewById2 = this.f52763c.findViewById(R.id.sticky_view);
        this.I0 = findViewById2;
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) findViewById2.getLayoutParams();
        if (this.f52762b.L() != null && this.f52762b.L().l0()) {
            this.H0.setVisibility(0);
            if (layoutParams2 != null) {
                layoutParams2.height = 0;
                this.I0.setLayoutParams(layoutParams2);
            }
        } else if (layoutParams2 != null) {
            layoutParams2.height = K1;
            this.I0.setLayoutParams(layoutParams2);
        }
        PbReplyTitleViewHolder pbReplyTitleViewHolder = new PbReplyTitleViewHolder(this.f52762b.getPageContext(), this.f52763c.findViewById(R.id.pb_reply_expand_view));
        this.J0 = pbReplyTitleViewHolder;
        pbReplyTitleViewHolder.q(pbFragment.f0);
        this.J0.f19769g.setVisibility(8);
        this.J0.p(this.I);
        this.J0.o(this.f52762b.S1);
        this.f52762b.registerListener(this.w1);
        this.f52762b.registerListener(this.v1);
        O();
        R1(false);
        this.r1 = new d.b.i0.c2.p.c(this.f52762b.getPageContext());
    }

    public PbFakeFloorModel A0() {
        return this.S0;
    }

    public void A1(AbsListView absListView, int i2, int i3, int i4) {
        PbReplyTitleViewHolder pbReplyTitleViewHolder;
        d.b.i0.c2.k.e.x0.e eVar;
        d.b.i0.c2.k.e.x0.f fVar = this.o;
        if (fVar != null) {
            fVar.n(absListView, i2, i3, i4);
        }
        d.b.i0.c2.k.e.c1.c cVar = this.f52767g;
        if (cVar != null && (eVar = this.r) != null) {
            cVar.o(eVar.l());
        }
        d0 d0Var = this.N0;
        d0Var.f52783a = i2;
        d0Var.f52784b = this.k.getHeaderViewsCount();
        this.N0.f52785c = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.N0));
        E2(K(absListView, i2));
        int i5 = 0;
        H1(this.N0.f52785c, false);
        S();
        if (!this.E.m() || this.E.D) {
            return;
        }
        d0 d0Var2 = this.N0;
        if (d0Var2 != null && (pbReplyTitleViewHolder = d0Var2.f52785c) != null && pbReplyTitleViewHolder.a() != null) {
            i5 = this.N0.f52785c.a().getTop() < 0 ? this.N0.f52785c.a().getHeight() : this.N0.f52785c.a().getBottom();
        }
        this.E.e(i5);
        this.E.D = true;
    }

    public void A2(int i2) {
        NavigationBar navigationBar;
        LinearLayout.LayoutParams layoutParams;
        if (this.k != null) {
            d.b.i0.c2.k.e.c1.c cVar = this.f52767g;
            int i3 = 0;
            if (cVar != null && (navigationBar = cVar.f52649a) != null) {
                int fixedNavHeight = navigationBar.getFixedNavHeight();
                if (!(this.f52762b.o4() != -1)) {
                    View view = this.I0;
                    if (view != null && (layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams()) != null) {
                        layoutParams.height = 0;
                        this.I0.setLayoutParams(layoutParams);
                    }
                    i2--;
                }
                i3 = fixedNavHeight;
            }
            this.k.setSelectionFromTop(i2, i3);
        }
    }

    public d.b.i0.c2.k.e.s B0() {
        return this.T0;
    }

    public void B1(AbsListView absListView, int i2) {
        d.b.i0.c2.k.e.x0.f fVar = this.o;
        if (fVar != null) {
            fVar.o(absListView, i2);
        }
        if (this.J1 || i2 != 0) {
            return;
        }
        this.H1 = H0();
        this.N0.f52785c = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.N0));
        H1(this.N0.f52785c, true);
        S();
        this.y.Y(true);
    }

    public void B2(List<String> list) {
        this.e1 = list;
        d.b.i0.c2.k.e.y0.c cVar = this.f1;
        if (cVar != null) {
            cVar.q(list);
        }
    }

    public d.b.i0.c2.k.e.x0.f C0() {
        return this.o;
    }

    public void C1(ArrayList<d.b.h0.r.q.l0> arrayList) {
        if (this.Q == null) {
            this.Q = LayoutInflater.from(this.f52762b.getPageContext().getPageActivity()).inflate(R.layout.commit_good, (ViewGroup) null);
        }
        this.f52762b.getBaseFragmentActivity().getLayoutMode().j(this.Q);
        if (this.P == null) {
            Dialog dialog = new Dialog(this.f52762b.getPageContext().getPageActivity(), R.style.common_alert_dialog);
            this.P = dialog;
            dialog.setCanceledOnTouchOutside(true);
            this.P.setCancelable(true);
            this.e0 = (ScrollView) this.Q.findViewById(R.id.good_scroll);
            this.P.setContentView(this.Q);
            WindowManager.LayoutParams attributes = this.P.getWindow().getAttributes();
            attributes.width = d.b.b.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.ds540);
            this.P.getWindow().setAttributes(attributes);
            this.S = new j();
            this.R = (LinearLayout) this.Q.findViewById(R.id.good_class_group);
            TextView textView = (TextView) this.Q.findViewById(R.id.dialog_button_cancel);
            this.U = textView;
            textView.setOnClickListener(new k());
            TextView textView2 = (TextView) this.Q.findViewById(R.id.dialog_button_ok);
            this.T = textView2;
            textView2.setOnClickListener(this.I);
        }
        this.R.removeAllViews();
        this.m = new ArrayList();
        CustomBlueCheckRadioButton P = P("0", this.f52762b.getPageContext().getString(R.string.thread_good_class));
        this.m.add(P);
        P.setChecked(true);
        this.R.addView(P);
        if (arrayList != null) {
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                d.b.h0.r.q.l0 l0Var = arrayList.get(i2);
                if (l0Var != null && !TextUtils.isEmpty(l0Var.b()) && l0Var.a() > 0) {
                    CustomBlueCheckRadioButton P2 = P(String.valueOf(l0Var.a()), l0Var.b());
                    this.m.add(P2);
                    View view = new View(this.f52762b.getPageContext().getPageActivity());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, d.b.b.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.ds1));
                    SkinManager.setBackgroundColor(view, R.color.CAM_X0204);
                    view.setLayoutParams(layoutParams);
                    this.R.addView(view);
                    this.R.addView(P2);
                }
            }
            ViewGroup.LayoutParams layoutParams2 = this.e0.getLayoutParams();
            int size = arrayList.size();
            if (size == 0 || size == 1) {
                layoutParams2.height = d.b.b.e.p.l.e(this.f52762b.getPageContext().getPageActivity(), 120.0f);
            } else if (size != 2) {
                layoutParams2.height = d.b.b.e.p.l.e(this.f52762b.getPageContext().getPageActivity(), 220.0f);
            } else {
                layoutParams2.height = d.b.b.e.p.l.e(this.f52762b.getPageContext().getPageActivity(), 186.0f);
            }
            this.e0.setLayoutParams(layoutParams2);
            this.e0.removeAllViews();
            LinearLayout linearLayout = this.R;
            if (linearLayout != null && linearLayout.getParent() == null) {
                this.e0.addView(this.R);
            }
        }
        d.b.b.e.m.g.j(this.P, this.f52762b.getPageContext());
    }

    public void C2() {
        View view;
        PbLandscapeListView pbLandscapeListView = this.k;
        if (pbLandscapeListView != null) {
            pbLandscapeListView.setVisibility(0);
        }
        FrameLayout frameLayout = this.F0;
        if (frameLayout != null) {
            frameLayout.setVisibility(0);
        }
        d.b.i0.c2.k.e.c1.c cVar = this.f52767g;
        if (cVar == null || (view = cVar.f52652d) == null) {
            return;
        }
        view.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
    }

    public final PostData D0(d.b.i0.c2.h.e eVar) {
        MetaData metaData;
        if (eVar == null || eVar.L() == null || eVar.L().T() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData T = eVar.L().T();
        String userId = T.getUserId();
        HashMap<String, MetaData> E1 = eVar.L().E1();
        if (E1 != null && (metaData = E1.get(userId)) != null && metaData.getUserId() != null) {
            T = metaData;
        }
        postData.g0(1);
        postData.j0(eVar.L().f0());
        postData.v0(eVar.L().x1());
        postData.u0(eVar.L().Z());
        postData.e0(T);
        return postData;
    }

    public void D1(int i2, String str, int i3, boolean z2) {
        E1(i2, str, i3, z2, null);
    }

    public void D2() {
        d.b.i0.c2.k.e.x0.f fVar = this.o;
        if (fVar != null) {
            fVar.v(this.k);
        }
    }

    public String E0() {
        if (!d.b.b.e.p.k.isEmpty(this.l1)) {
            return this.l1;
        }
        if (this.f52762b != null) {
            this.l1 = TbadkCoreApplication.getInst().getResources().getString(p0.a());
        }
        return this.l1;
    }

    public void E1(int i2, String str, int i3, boolean z2, String str2) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(R.id.tag_del_post_id, str);
        sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i2));
        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i3));
        sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
        sparseArray.put(M1, Integer.valueOf(N1));
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
        this.N = new d.b.h0.r.s.a(this.f52762b.getActivity());
        if (StringUtils.isNull(str2)) {
            this.N.setMessageId(i4);
        } else {
            this.N.setOnlyMessageShowCenter(false);
            this.N.setMessage(str2);
        }
        this.N.setYesButtonTag(sparseArray);
        this.N.setPositiveButton(R.string.dialog_ok, this.f52762b);
        this.N.setNegativeButton(R.string.dialog_cancel, new i(this));
        this.N.setCancelable(true);
        this.N.create(this.f52762b.getPageContext());
        this.N.show();
    }

    public void E2(boolean z2) {
        this.h0.setVisibility(z2 ? 0 : 8);
    }

    public final int F0(PbReplyTitleViewHolder pbReplyTitleViewHolder) {
        if (pbReplyTitleViewHolder == null || pbReplyTitleViewHolder.a() == null) {
            return 0;
        }
        if (pbReplyTitleViewHolder.a().getTop() != 0 || pbReplyTitleViewHolder.a().isShown()) {
            return pbReplyTitleViewHolder.a().getBottom();
        }
        return 0;
    }

    public void F1(SparseArray<Object> sparseArray, boolean z2) {
        d.b.h0.r.s.h hVar;
        d.b.h0.r.s.h hVar2;
        d.b.h0.r.s.l lVar = new d.b.h0.r.s.l(this.f52762b.getContext());
        lVar.q(this.f52762b.getString(R.string.bar_manager));
        lVar.n(new h(z2));
        ArrayList arrayList = new ArrayList();
        int intValue = sparseArray.get(R.id.tag_check_mute_from) instanceof Integer ? ((Integer) sparseArray.get(R.id.tag_check_mute_from)).intValue() : -1;
        if (!"".equals(sparseArray.get(R.id.tag_del_post_id)) && intValue != 2) {
            if ((sparseArray.get(R.id.tag_del_post_type) instanceof Integer ? ((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue() : -1) == 0) {
                hVar2 = new d.b.h0.r.s.h(10, this.f52762b.getString(R.string.delete_post), lVar);
            } else {
                hVar2 = new d.b.h0.r.s.h(10, this.f52762b.getString(R.string.delete), lVar);
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
            hVar2.f51005d.setTag(sparseArray2);
            arrayList.add(hVar2);
        }
        if ((!"".equals(sparseArray.get(R.id.tag_forbid_user_name)) || !"".equals(sparseArray.get(R.id.tag_forbid_user_name_show))) && !o1()) {
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
            d.b.h0.r.s.h hVar3 = new d.b.h0.r.s.h(11, this.f52762b.getString(R.string.forbidden_person), lVar);
            hVar3.f51005d.setTag(sparseArray3);
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
                hVar = new d.b.h0.r.s.h(12, this.f52762b.getString(R.string.un_mute), lVar);
            } else {
                hVar = new d.b.h0.r.s.h(12, this.f52762b.getString(R.string.mute), lVar);
            }
            hVar.f51005d.setTag(sparseArray4);
            arrayList.add(hVar);
        }
        d.b.i0.c2.k.e.b1.a.e(arrayList);
        if (d.b.h0.b.d.y()) {
            lVar.l(arrayList, false);
        } else {
            lVar.l(arrayList, true);
        }
        d.b.h0.r.s.j jVar = new d.b.h0.r.s.j(this.f52762b.getPageContext(), lVar);
        this.L = jVar;
        jVar.l();
    }

    public void F2(boolean z2) {
        if (this.k0 == null) {
            return;
        }
        Z1(this.f52762b.D4().C());
        if (this.g0) {
            I2(z2);
        } else {
            P0(z2);
        }
    }

    public int G0() {
        return R.id.richText;
    }

    public void G1(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray == null) {
            return;
        }
        F1(sparseArray, false);
    }

    public void G2(d.b.i0.c2.h.e eVar) {
        PostData postData;
        d.b.i0.c2.k.e.c1.c cVar;
        if (eVar == null || (postData = this.z0) == null || postData.s() == null || (cVar = this.f52767g) == null) {
            return;
        }
        boolean z2 = !this.X0;
        this.Y0 = z2;
        cVar.y(z2);
        if (this.f52762b.E4() != null) {
            this.f52762b.E4().s(this.Y0);
        }
        I1();
        PbFragment pbFragment = this.f52762b;
        if (pbFragment != null && !pbFragment.isSimpleForum() && !ListUtils.isEmpty(eVar.p())) {
            w1 w1Var = eVar.p().get(0);
            if (w1Var != null) {
                this.f52767g.B(w1Var.i(), w1Var.a());
            }
        } else if (eVar.l() != null) {
            this.f52767g.B(eVar.l().getName(), eVar.l().getImage_url());
        }
        if (this.Y0) {
            this.r.B(eVar, this.z0, this.a0);
            View view = this.I0;
            if (view != null) {
                view.setVisibility(8);
            }
            if (this.h1 == null) {
                this.h1 = new q();
            }
            this.k.setListViewDragListener(this.h1);
            return;
        }
        View view2 = this.I0;
        if (view2 != null) {
            view2.setVisibility(0);
        }
        this.r.B(eVar, this.z0, this.a0);
        this.h1 = null;
        this.k.setListViewDragListener(null);
    }

    public final int H0() {
        View childAt = this.k.getChildAt(0);
        if (childAt == null) {
            return 0;
        }
        return (-childAt.getTop()) + (this.k.getFirstVisiblePosition() * childAt.getHeight());
    }

    public final void H1(PbReplyTitleViewHolder pbReplyTitleViewHolder, boolean z2) {
        int measuredHeight;
        if (this.X0 || this.H0 == null || this.f52767g.i() == null) {
            return;
        }
        int F = this.y.F();
        if (F > 0 && (pbReplyTitleViewHolder == null || pbReplyTitleViewHolder.a().getParent() == null)) {
            if (F > this.k.getFirstVisiblePosition() - this.k.getHeaderViewsCount()) {
                this.H0.setVisibility(4);
                return;
            }
            this.H0.setVisibility(0);
            E2(false);
            this.f52767g.f52649a.hideBottomLine();
            if (this.H0.getParent() == null || ((ViewGroup) this.H0.getParent()).getHeight() > this.H0.getTop()) {
                return;
            }
            this.H0.getParent().requestLayout();
        } else if (pbReplyTitleViewHolder != null && pbReplyTitleViewHolder.a() != null && pbReplyTitleViewHolder.f19769g != null) {
            int top = pbReplyTitleViewHolder.a().getTop();
            if (pbReplyTitleViewHolder.a().getParent() != null) {
                if (this.M0) {
                    this.L0 = top;
                    this.M0 = false;
                }
                int i2 = this.L0;
                if (top < i2) {
                    i2 = top;
                }
                this.L0 = i2;
            }
            if (top != 0 || pbReplyTitleViewHolder.a().isShown()) {
                if (this.x.getY() < 0.0f) {
                    measuredHeight = K1 - pbReplyTitleViewHolder.f19769g.getMeasuredHeight();
                } else {
                    measuredHeight = this.f52767g.i().getMeasuredHeight() - pbReplyTitleViewHolder.f19769g.getMeasuredHeight();
                    this.f52767g.f52649a.hideBottomLine();
                }
                if (pbReplyTitleViewHolder.a().getParent() == null && top <= this.L0) {
                    this.H0.setVisibility(0);
                    E2(false);
                } else if (top < measuredHeight) {
                    this.H0.setVisibility(0);
                    E2(false);
                } else {
                    this.H0.setVisibility(4);
                    this.f52767g.f52649a.hideBottomLine();
                }
                if (z2) {
                    this.M0 = true;
                }
            }
        } else if (this.k.getFirstVisiblePosition() == 0) {
            this.H0.setVisibility(4);
            this.f52767g.f52649a.hideBottomLine();
        }
    }

    public final boolean H2(d.b.i0.c2.h.e eVar) {
        if (eVar == null || eVar.L() == null) {
            return false;
        }
        return eVar.L().s0() == 1 || eVar.L().s1() == 33 || !(eVar.L().A1() == null || eVar.L().A1().a() == 0) || eVar.L().x0() == 1 || eVar.L().w0() == 1 || eVar.L().L1() || eVar.L().c2() || eVar.L().B2() || eVar.L().I1() != null || !d.b.b.e.p.k.isEmpty(eVar.L().X()) || eVar.L().Z1() || eVar.L().n2();
    }

    public int I0() {
        return this.B0;
    }

    public final void I1() {
        this.r.r(this.y0, this.z0, this.Y0, this.X0);
    }

    public void I2(boolean z2) {
        TextView textView;
        if (this.k0 == null || (textView = this.n0) == null) {
            return;
        }
        textView.setText(R.string.draft_to_send);
        if (z2) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(400L);
            this.k0.startAnimation(alphaAnimation);
        }
        this.j0.setVisibility(0);
        this.k0.setVisibility(0);
        this.u0 = true;
        if (this.O0 == null || this.g1.l()) {
            return;
        }
        this.O0.setVisibility(0);
        R1(true);
    }

    public View J0() {
        return this.f52764d;
    }

    public void J1() {
        PbLandscapeListView pbLandscapeListView = this.k;
        if (pbLandscapeListView == null) {
            return;
        }
        int headerViewsCount = pbLandscapeListView.getHeaderViewsCount() - this.W0;
        int firstVisiblePosition = (this.k.getFirstVisiblePosition() == 0 || this.k.getFirstVisiblePosition() + headerViewsCount < 0) ? 0 : this.k.getFirstVisiblePosition() + headerViewsCount;
        View childAt = this.k.getChildAt(0);
        int top = childAt != null ? childAt.getTop() : -1;
        this.N0.f52785c = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.N0));
        PbReplyTitleViewHolder pbReplyTitleViewHolder = this.N0.f52785c;
        int F0 = F0(pbReplyTitleViewHolder);
        int measuredHeight = this.x.getMeasuredHeight() + ((int) this.x.getY());
        boolean z2 = this.H0.getVisibility() == 0;
        boolean z3 = this.x.getY() < 0.0f;
        if ((z2 && pbReplyTitleViewHolder != null) || firstVisiblePosition >= this.y.F() + this.k.getHeaderViewsCount()) {
            int measuredHeight2 = pbReplyTitleViewHolder != null ? pbReplyTitleViewHolder.f19769g.getMeasuredHeight() : 0;
            if (z3) {
                this.k.setSelectionFromTop(this.y.F() + this.k.getHeaderViewsCount(), K1 - measuredHeight2);
            } else {
                this.k.setSelectionFromTop(this.y.F() + this.k.getHeaderViewsCount(), this.f52767g.i().getMeasuredHeight() - measuredHeight2);
            }
        } else {
            this.k.setSelectionFromTop(firstVisiblePosition, top);
        }
        if (this.X0 && this.o != null) {
            this.k.setSelectionFromTop(this.y.F() + this.k.getHeaderViewsCount(), this.o.d());
        } else if (this.A0 != 6) {
        } else {
            this.k.setOnLayoutListener(new a(F0, pbReplyTitleViewHolder, z2, measuredHeight, firstVisiblePosition, top));
        }
    }

    public void J2(View view) {
        if (d.b.h0.r.d0.b.i().g("show_long_press_collection_tips", false)) {
            return;
        }
        Rect rect = new Rect();
        this.k0.getGlobalVisibleRect(rect);
        int i2 = rect.bottom;
        int i3 = rect.top;
        view.getGlobalVisibleRect(rect);
        int i4 = rect.bottom;
        FrameLayout frameLayout = new FrameLayout(this.f52762b.getContext());
        frameLayout.setBackgroundResource(R.drawable.pic_sign_tip);
        TextView textView = new TextView(this.f52762b.getContext());
        this.d1 = textView;
        textView.setText(R.string.connection_tips);
        this.d1.setGravity(17);
        this.d1.setPadding(d.b.b.e.p.l.g(this.f52762b.getContext(), R.dimen.ds24), 0, d.b.b.e.p.l.g(this.f52762b.getContext(), R.dimen.ds24), 0);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        layoutParams.height = d.b.b.e.p.l.g(this.f52762b.getContext(), R.dimen.ds60);
        if (this.d1.getParent() == null) {
            frameLayout.addView(this.d1, layoutParams);
        }
        PopupWindow popupWindow = new PopupWindow(this.f52762b.getContext());
        this.c1 = popupWindow;
        popupWindow.setContentView(frameLayout);
        this.c1.setHeight(-2);
        this.c1.setWidth(-2);
        this.c1.setFocusable(true);
        this.c1.setOutsideTouchable(false);
        this.c1.setBackgroundDrawable(new ColorDrawable(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent)));
        this.k.postDelayed(new w(i4, i2, i3, view), 100L);
        d.b.h0.r.d0.b.i().s("show_long_press_collection_tips", true);
    }

    public final boolean K(AbsListView absListView, int i2) {
        if (absListView == null) {
            return false;
        }
        boolean z2 = i2 > 0;
        if (z2 || absListView.getChildCount() <= 0) {
            return z2;
        }
        return absListView.getChildAt(0).getTop() < absListView.getListPaddingTop();
    }

    public PbThreadPostView K0() {
        return this.n;
    }

    public final void K1(d.b.i0.c2.h.e eVar) {
        if (eVar == null || eVar.L() == null) {
            return;
        }
        e3(eVar);
        if (eVar.r()) {
            WebPManager.setPureDrawable(this.p0, R.drawable.icon_pure_pb_bottom_collected26_selection, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
        } else {
            WebPManager.setPureDrawable(this.p0, R.drawable.icon_pure_pb_bottom_collect26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        }
        String d02 = d0(eVar.L().Z0());
        TextView textView = this.s0;
        if (textView != null) {
            textView.setText(d02);
        }
        TextView textView2 = this.t0;
        if (textView2 != null) {
            textView2.setText(d02);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921416, eVar.L()));
    }

    public void K2() {
        d.b.i0.c2.k.e.c1.c cVar = this.f52767g;
        if (cVar == null || this.Z0) {
            return;
        }
        cVar.u();
        this.Z0 = true;
    }

    public boolean L(boolean z2) {
        EditorTools editorTools = this.f0;
        if (editorTools == null || !editorTools.u()) {
            return false;
        }
        this.f0.q();
        return true;
    }

    public RelativeLayout L0() {
        return this.x;
    }

    public void L1(int i2, d.b.i0.c2.h.e eVar, boolean z2, int i3) {
        PostData l0;
        if (i2 <= 0 || (l0 = l0(eVar, z2)) == null || l0.s() == null) {
            return;
        }
        MetaData s2 = l0.s();
        s2.setGiftNum(s2.getGiftNum() + i2);
    }

    public void L2() {
        this.k.setVisibility(0);
    }

    public boolean M() {
        PbListView pbListView = this.E;
        if (pbListView == null || TextUtils.isEmpty(pbListView.h())) {
            return false;
        }
        return this.E.h().equals(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
    }

    public View M0() {
        return this.f52763c;
    }

    public void M1(d.b.i0.c2.h.e eVar, boolean z2, int i2, int i3) {
        O2(eVar, z2, i2, i3);
        this.r.p(i3);
    }

    public void M2() {
        if (this.w0 == null) {
            this.w0 = new d.b.h0.r.f0.a(this.f52762b.getPageContext());
        }
        this.w0.h(true);
    }

    public void N() {
        if (!this.f52762b.checkUpIsLogin()) {
            TiebaStatic.log(new StatisticItem("c10517").param("obj_locate", 2).param("fid", this.c0));
        } else if (this.f52762b.U3()) {
            d.b.h0.w.w.e D4 = this.f52762b.D4();
            if (D4 != null && (D4.B() || D4.D())) {
                this.f52762b.D4().z(false, null);
                return;
            }
            if (this.f0 != null) {
                Z0();
            }
            EditorTools editorTools = this.f0;
            if (editorTools != null) {
                this.u0 = false;
                if (editorTools.n(2) != null) {
                    d.b.i0.c3.g0.a.c(this.f52762b.getPageContext(), (View) this.f0.n(2).k, false, S1);
                }
            }
            O0();
        }
    }

    public void N0() {
        View view;
        PbLandscapeListView pbLandscapeListView = this.k;
        if (pbLandscapeListView != null) {
            pbLandscapeListView.setVisibility(8);
        }
        if (this.k != null) {
            this.F0.setVisibility(8);
        }
        d.b.i0.c2.k.e.c1.c cVar = this.f52767g;
        if (cVar == null || (view = cVar.f52652d) == null) {
            return;
        }
        view.setVisibility(8);
    }

    public final void N1() {
        PbInterviewStatusView pbInterviewStatusView = this.E0;
        if (pbInterviewStatusView == null || pbInterviewStatusView.getVisibility() != 0) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.E0.getLayoutParams();
        layoutParams.setMargins(0, 0, 0, 0);
        this.E0.setLayoutParams(layoutParams);
    }

    public void N2(d.b.i0.c2.h.e eVar, int i2, int i3, boolean z2, int i4, boolean z3) {
        PbLandscapeListView pbLandscapeListView;
        int i5;
        PbReplyTitleViewHolder pbReplyTitleViewHolder;
        Parcelable e2;
        Parcelable e3;
        if (eVar == null || this.k == null) {
            return;
        }
        this.y0 = eVar;
        this.A0 = i2;
        if (eVar.L() != null) {
            this.P0 = eVar.L().Y();
            if (eVar.L().P() != 0) {
                this.D1 = true;
            }
            this.a0 = k1(eVar.L());
        }
        if (eVar.Q() != null) {
            this.E1 = eVar.Q().getUserId();
        }
        X0(eVar);
        this.C0 = false;
        this.x0 = z2;
        t2();
        d.b.i0.c2.h.k kVar = eVar.f52427h;
        if (kVar != null && kVar.b()) {
            if (this.n == null) {
                PbThreadPostView pbThreadPostView = new PbThreadPostView(this.f52762b.getContext());
                this.n = pbThreadPostView;
                this.k.x(pbThreadPostView, 1);
                this.n.setData(eVar);
                this.n.setChildOnClickLinstener(this.I);
            }
        } else {
            PbThreadPostView pbThreadPostView2 = this.n;
            if (pbThreadPostView2 != null && (pbLandscapeListView = this.k) != null) {
                pbLandscapeListView.removeHeaderView(pbThreadPostView2);
            }
        }
        O2(eVar, z2, i2, TbadkCoreApplication.getInst().getSkinType());
        G2(eVar);
        if (this.j1 == null) {
            this.j1 = new f0(this.f52762b.getPageContext(), this.k1);
        }
        this.j1.a(eVar.v());
        if (this.f52762b.v4()) {
            if (this.D == null) {
                d.b.i0.c2.p.e eVar2 = new d.b.i0.c2.p.e(this.f52762b.getPageContext());
                this.D = eVar2;
                eVar2.n();
                this.D.b(this.F1);
            }
            this.k.setPullRefresh(this.D);
            T1();
            d.b.i0.c2.p.e eVar3 = this.D;
            if (eVar3 != null) {
                eVar3.I(TbadkCoreApplication.getInst().getSkinType());
            }
        } else if (eVar.w().c() == 0 && z2) {
            this.k.setPullRefresh(null);
        } else {
            if (this.D == null) {
                d.b.i0.c2.p.e eVar4 = new d.b.i0.c2.p.e(this.f52762b.getPageContext());
                this.D = eVar4;
                eVar4.n();
                this.D.b(this.F1);
            }
            this.k.setPullRefresh(this.D);
            T1();
            d.b.i0.c2.p.e eVar5 = this.D;
            if (eVar5 != null) {
                eVar5.I(TbadkCoreApplication.getInst().getSkinType());
            }
            S0();
        }
        W();
        this.y.g0(this.x0);
        this.y.d0(false);
        this.y.e0(i2 == 5);
        this.y.f0(i2 == 6);
        this.y.b0(z3 && this.B1 && i2 != 2);
        this.y.Z(eVar, false);
        this.y.U();
        this.r.A(l0(eVar, z2), eVar.Z());
        if (eVar.L() != null && eVar.L().P0() != null && this.f52761a != -1) {
            eVar.L().P0().setIsLike(this.f52761a);
        }
        this.k.removeFooterView(this.K0);
        this.k.addFooterView(this.K0);
        if (TbadkCoreApplication.isLogin()) {
            this.k.setNextPage(this.E);
            this.f52765e = 2;
            S0();
        } else {
            this.C0 = true;
            if (eVar.w().b() == 1) {
                if (this.F == null) {
                    PbFragment pbFragment = this.f52762b;
                    this.F = new d.b.i0.c2.p.a(pbFragment, pbFragment);
                }
                this.k.setNextPage(this.F);
            } else {
                this.k.setNextPage(this.E);
            }
            this.f52765e = 3;
        }
        ArrayList<PostData> D = eVar.D();
        if (eVar.w().b() != 0 && D != null && D.size() >= eVar.w().e()) {
            if (z3) {
                if (this.B1) {
                    Z();
                    if (eVar.w().b() != 0) {
                        this.E.A(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_load_more));
                    }
                } else {
                    this.E.x();
                    this.E.L();
                }
            } else {
                this.E.x();
                this.E.L();
            }
            this.E.j();
        } else {
            if (ListUtils.getCount(D) != 0 && (ListUtils.getCount(D) != 1 || D.get(0) == null || D.get(0).z() != 1)) {
                if (eVar.w().b() == 0) {
                    this.E.A(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                } else {
                    this.E.A(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                }
                this.E.j();
            } else {
                d0 d0Var = this.N0;
                if (d0Var == null || (pbReplyTitleViewHolder = d0Var.f52785c) == null || pbReplyTitleViewHolder.a() == null) {
                    i5 = 0;
                } else {
                    i5 = this.N0.f52785c.a().getTop() < 0 ? this.N0.f52785c.a().getHeight() : this.N0.f52785c.a().getBottom();
                }
                if (this.f52762b.Y4()) {
                    this.E.D(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_host_reply), i5);
                } else {
                    this.E.D(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_replay), i5);
                }
                if (this.f52762b.E4() != null && !this.f52762b.E4().p()) {
                    this.f52762b.E4().x();
                }
            }
            if (eVar.w().b() == 0 || D == null) {
                O1();
            }
        }
        if (i2 == 2) {
            this.k.setSelection(i3 > 1 ? (i3 + ((this.k.getData() == null && eVar.D() == null) ? 0 : (this.k.getData().size() - eVar.D().size()) + this.k.getHeaderViewsCount())) - 2 : 0);
        } else if (i2 != 3) {
            if (i2 == 4) {
                this.B1 = false;
            } else if (i2 == 5) {
                this.k.setSelection(0);
            } else if (i2 != 6) {
                if (i2 == 8) {
                    if (i3 == 0) {
                        d.b.i0.c2.k.e.x0.f fVar = this.o;
                        if (fVar != null && fVar.c() != null) {
                            if (this.f52762b.getBaseFragmentActivity().isUseStyleImmersiveSticky()) {
                                this.k.setSelectionFromTop((this.y.A() + this.k.getHeaderViewsCount()) - 1, this.o.d() - d.b.b.e.p.l.r(this.f52762b.getPageContext().getPageActivity()));
                            } else {
                                this.k.setSelectionFromTop((this.y.A() + this.k.getHeaderViewsCount()) - 1, this.o.d());
                            }
                        } else {
                            this.k.setSelection(this.y.A() + this.k.getHeaderViewsCount());
                        }
                    } else {
                        this.k.setSelection(i3 > 0 ? i3 + ((this.k.getData() == null && eVar.D() == null) ? 0 : (this.k.getData().size() - eVar.D().size()) + this.k.getHeaderViewsCount()) : 0);
                    }
                    this.E.f();
                    this.E.A(this.f52762b.getString(R.string.pb_load_more_without_point));
                    this.E.v();
                }
            } else if (i4 == 1 && (e3 = k0.b().e()) != null && !(e3 instanceof RecyclerView.SavedState)) {
                this.k.onRestoreInstanceState(e3);
            } else {
                this.k.setSelection(0);
            }
        } else if (i4 == 1 && (e2 = k0.b().e()) != null && !(e2 instanceof RecyclerView.SavedState)) {
            this.k.onRestoreInstanceState(e2);
            if (ListUtils.getCount(D) > 1 && eVar.w().b() > 0) {
                this.E.f();
                this.E.A(this.f52762b.getString(R.string.pb_load_more_without_point));
                this.E.v();
            }
        }
        if (this.P0 == L1 && j1()) {
            Q();
        }
        if (this.V0) {
            J1();
            this.V0 = false;
            if (i4 == 0) {
                j2(true);
            }
        }
        if (eVar.f52423d == 1 || eVar.f52424e == 1) {
            if (this.b1 == null) {
                this.b1 = new PbTopTipView(this.f52762b.getContext());
            }
            if (eVar.f52424e == 1 && PbActivityConfig.KEY_FROM_GUIDE.equals(this.f52762b.I4())) {
                this.b1.setText(this.f52762b.getString(R.string.pb_read_strategy_add_experience));
                this.b1.l(this.f52763c, this.B0);
            } else if (eVar.f52423d == 1 && PbActivityConfig.KEY_FROM_NEWS.equals(this.f52762b.I4())) {
                this.b1.setText(this.f52762b.getString(R.string.pb_read_news_add_experience));
                this.b1.l(this.f52763c, this.B0);
            }
        }
        this.k.removeFooterView(this.r1.a());
        if (!ListUtils.isEmpty(eVar.F()) && eVar.w().b() == 0) {
            this.k.removeFooterView(this.K0);
            this.r1.d(Math.max(this.k0.getMeasuredHeight(), this.v0 / 2));
            this.k.addFooterView(this.r1.a());
            this.r1.f(eVar);
        }
        K1(eVar);
    }

    public final void O() {
        d.b.i0.c2.k.d.a aVar = new d.b.i0.c2.k.d.a(this.f52762b, this, (ViewStub) this.f52763c.findViewById(R.id.more_god_reply_popup));
        this.g1 = aVar;
        aVar.o(this.I);
        this.g1.p(this.M);
        this.g1.q(this.J);
        this.g1.o(this.I);
        this.g1.s(this.d0);
    }

    public void O0() {
        if (this.k0 == null) {
            return;
        }
        this.j0.setVisibility(8);
        this.k0.setVisibility(8);
        this.u0 = false;
        PbEmotionBar pbEmotionBar = this.O0;
        if (pbEmotionBar != null) {
            pbEmotionBar.setVisibility(8);
            R1(false);
        }
    }

    public void O1() {
        if (this.f52765e != 2) {
            this.k.setNextPage(this.E);
            this.f52765e = 2;
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public final void O2(d.b.i0.c2.h.e eVar, boolean z2, int i2, int i3) {
        if (eVar == null || eVar.L() == null) {
            return;
        }
        if (this.f52762b.isSimpleForum()) {
            if (eVar.h() != null) {
                this.b0 = eVar.h().i();
                this.c0 = eVar.h().h();
            }
            if (this.b0 == null && this.f52762b.L() != null && this.f52762b.L().a0() != null) {
                this.b0 = this.f52762b.L().a0();
            }
        }
        PostData l0 = l0(eVar, z2);
        r2(l0, eVar);
        this.r.x(8);
        if (eVar.e0()) {
            this.X0 = true;
            this.f52767g.s(true);
            this.f52767g.f52649a.hideBottomLine();
            if (this.o == null) {
                this.o = new d.b.i0.c2.k.e.x0.f(this.f52762b);
            }
            this.o.w(eVar, l0, this.k, this.r, this.F0, this.f52767g, this.b0, this.n1);
            this.o.t(this.C1);
            T1();
        } else {
            this.X0 = false;
            this.f52767g.s(false);
            d.b.i0.c2.k.e.x0.f fVar = this.o;
            if (fVar != null) {
                fVar.p(this.k);
            }
        }
        if (this.f52762b.E4() != null) {
            this.f52762b.E4().w(this.X0);
        }
        if (l0 == null) {
            return;
        }
        this.z0 = l0;
        this.r.x(0);
        SparseArray<Object> n2 = this.r.n();
        n2.put(R.id.tag_clip_board, l0);
        n2.put(R.id.tag_is_subpb, Boolean.FALSE);
        this.s.e(eVar, this.k);
        this.q.f(eVar);
        this.p.g(eVar, this.x0);
        this.p.f(eVar);
        this.r.y(this.B0, this.y0, l0, this.C1);
        if (this.J0 != null) {
            if (eVar.Z()) {
                this.J0.a().setVisibility(8);
            } else {
                this.J0.a().setVisibility(0);
                d.b.i0.c2.h.o oVar = new d.b.i0.c2.h.o(d.b.i0.c2.h.o.l);
                if (eVar.L() != null) {
                    eVar.L().Z0();
                }
                oVar.f52456g = eVar.f52426g;
                eVar.c();
                oVar.f52457h = this.f52762b.Y4();
                oVar.k = eVar.f52425f;
                this.J0.h(oVar);
            }
        }
        W2(eVar);
        d.b.b.e.m.e.a().post(new o());
        this.t.e(this.k);
        if (l0.S) {
            this.t.f(l0.D());
            this.t.b(this.k, this.k.getHeaderViewsCount() <= 1 ? 0 : 1);
        }
        d.b.i0.c2.k.e.g gVar = this.y;
        if (gVar != null && gVar.y() != null) {
            this.y.y().s0(l0.S);
        }
        d.b.i0.c2.k.e.g gVar2 = this.y;
        if (gVar2 != null) {
            gVar2.i0(l0.S);
        }
        this.s1.setVisibility(l0.S ? 0 : 8);
    }

    public final CustomBlueCheckRadioButton P(String str, String str2) {
        Activity pageActivity = this.f52762b.getPageContext().getPageActivity();
        CustomBlueCheckRadioButton customBlueCheckRadioButton = new CustomBlueCheckRadioButton(pageActivity);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, d.b.b.e.p.l.g(pageActivity, R.dimen.ds100));
        customBlueCheckRadioButton.setOnCheckedChangeListener(this.S);
        customBlueCheckRadioButton.setTag(str);
        customBlueCheckRadioButton.setText(str2);
        customBlueCheckRadioButton.setLayoutParams(layoutParams);
        return customBlueCheckRadioButton;
    }

    public void P0(boolean z2) {
        TextView textView;
        if (this.k0 == null || (textView = this.n0) == null) {
            return;
        }
        textView.setText(E0());
        if (z2) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(400L);
            this.k0.startAnimation(alphaAnimation);
        }
        this.j0.setVisibility(0);
        this.k0.setVisibility(0);
        this.u0 = true;
        if (this.O0 == null || this.g1.l()) {
            return;
        }
        this.O0.setVisibility(0);
        R1(true);
    }

    public void P1() {
        PbLandscapeListView pbLandscapeListView = this.k;
        if (pbLandscapeListView != null) {
            this.q.d(pbLandscapeListView);
            this.r.s(this.k);
            this.s.d(this.k);
            this.p.e(this.k);
        }
    }

    public void P2(b.c cVar, boolean z2) {
        d.b.h0.r.s.j jVar = this.X;
        if (jVar != null) {
            jVar.dismiss();
            this.X = null;
        }
        d.b.h0.r.s.l lVar = new d.b.h0.r.s.l(this.f52762b.getContext());
        ArrayList arrayList = new ArrayList();
        d.b.i0.c2.h.e eVar = this.y0;
        if (eVar != null && eVar.L() != null && !this.y0.L().S1()) {
            arrayList.add(new d.b.h0.r.s.h(0, this.f52762b.getPageContext().getString(R.string.save_to_emotion), lVar));
        }
        if (!z2) {
            arrayList.add(new d.b.h0.r.s.h(1, this.f52762b.getPageContext().getString(R.string.save_to_local), lVar));
        }
        lVar.k(arrayList);
        lVar.n(new m(cVar));
        d.b.h0.r.s.j jVar2 = new d.b.h0.r.s.j(this.f52762b.getPageContext(), lVar);
        this.X = jVar2;
        jVar2.l();
    }

    public void Q() {
        if (this.I1) {
            return;
        }
        TiebaStatic.log("c10490");
        this.I1 = true;
        d.b.h0.r.s.a aVar = new d.b.h0.r.s.a(this.f52762b.getPageContext().getPageActivity());
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(M1, Integer.valueOf(O1));
        aVar.setTitle(R.string.grade_thread_tips);
        View inflate = LayoutInflater.from(this.f52762b.getPageContext().getPageActivity()).inflate(R.layout.upgrade_success_dialog_content, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.function_description_view)).setText(R.string.function_upgrade_to_photo_live_tips);
        ((TextView) inflate.findViewById(R.id.title_view)).setText(R.string.grade_thread_tips);
        aVar.setContentView(inflate);
        aVar.setYesButtonTag(sparseArray);
        aVar.setPositiveButton(R.string.grade_button_tips, this.f52762b);
        aVar.setNegativeButton(R.string.look_again, new t(this));
        aVar.create(this.f52762b.getPageContext()).show();
    }

    public void Q0() {
        EditorTools editorTools = this.f0;
        if (editorTools != null) {
            editorTools.o();
            d.b.i0.c2.k.e.y0.c cVar = this.f1;
            if (cVar != null) {
                cVar.m();
            }
        }
    }

    public final void Q1() {
        PbFragment pbFragment = this.f52762b;
        if (pbFragment == null || pbFragment.D4() == null || this.f0 == null) {
            return;
        }
        d.b.h0.w.w.a.a().c(0);
        d.b.h0.w.w.e D4 = this.f52762b.D4();
        D4.T();
        D4.R();
        if (D4.y() != null) {
            D4.y().setMaxImagesAllowed(D4.z ? 1 : 9);
        }
        D4.l0(SendView.k);
        D4.j(SendView.k);
        d.b.h0.w.h m2 = this.f0.m(23);
        d.b.h0.w.h m3 = this.f0.m(2);
        d.b.h0.w.h m4 = this.f0.m(5);
        if (m3 != null) {
            m3.b();
        }
        if (m4 != null) {
            m4.b();
        }
        if (m2 != null) {
            m2.hide();
        }
        this.f0.invalidate();
    }

    public void Q2(b.c cVar, boolean z2, boolean z3) {
        d.b.h0.r.s.j jVar = this.W;
        if (jVar != null) {
            jVar.dismiss();
            this.W = null;
        }
        d.b.h0.r.s.l lVar = new d.b.h0.r.s.l(this.f52762b.getContext());
        ArrayList arrayList = new ArrayList();
        arrayList.add(new d.b.h0.r.s.h(0, this.f52762b.getPageContext().getString(R.string.copy), lVar));
        if (z3) {
            arrayList.add(new d.b.h0.r.s.h(1, this.f52762b.getPageContext().getString(R.string.report_text), lVar));
        } else if (!z2) {
            arrayList.add(new d.b.h0.r.s.h(1, this.f52762b.getPageContext().getString(R.string.mark), lVar));
        } else {
            arrayList.add(new d.b.h0.r.s.h(1, this.f52762b.getPageContext().getString(R.string.remove_mark), lVar));
        }
        lVar.k(arrayList);
        lVar.n(new l(cVar));
        d.b.h0.r.s.j jVar2 = new d.b.h0.r.s.j(this.f52762b.getPageContext(), lVar);
        this.X = jVar2;
        jVar2.l();
    }

    public void R(String str) {
        if (str.contains("_")) {
            str = str.replace("_", "\n");
        }
        d.b.h0.r.s.a aVar = new d.b.h0.r.s.a(this.f52762b.getPageContext().getPageActivity());
        View inflate = LayoutInflater.from(this.f52762b.getPageContext().getPageActivity()).inflate(R.layout.upgrade_success_dialog_content, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.title_view);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        textView.setLayoutParams(layoutParams);
        textView.setGravity(3);
        textView.setText(str);
        ((TextView) inflate.findViewById(R.id.function_description_view)).setVisibility(8);
        aVar.setContentView(inflate);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(M1, Integer.valueOf(P1));
        aVar.setYesButtonTag(sparseArray);
        aVar.setPositiveButton(R.string.view, this.f52762b);
        aVar.setNegativeButton(R.string.cancel, new v(this));
        aVar.create(this.f52762b.getPageContext()).show();
    }

    public void R0() {
        d.b.i0.c2.k.e.c1.c cVar = this.f52767g;
        if (cVar != null) {
            cVar.j();
        }
    }

    public final void R1(boolean z2) {
    }

    public void R2(AdapterView.OnItemClickListener onItemClickListener) {
        d.b.h0.r.s.e eVar = this.Y;
        if (eVar != null) {
            eVar.d();
            this.Y = null;
        }
        if (this.y0 == null) {
            return;
        }
        ArrayList<d.b.h0.r.s.n> arrayList = new ArrayList<>();
        arrayList.add(new d.b.h0.r.s.n(this.f52762b.getContext().getString(R.string.all_person), "", this.y0.I() == 1, Integer.toString(1)));
        arrayList.add(new d.b.h0.r.s.n(this.f52762b.getContext().getString(R.string.my_fans), "", this.y0.I() == 2, Integer.toString(5)));
        arrayList.add(new d.b.h0.r.s.n(this.f52762b.getContext().getString(R.string.my_attentions), "", this.y0.I() == 3, Integer.toString(6)));
        arrayList.add(new d.b.h0.r.s.n(this.f52762b.getContext().getString(R.string.myself_only), "", this.y0.I() == 4, Integer.toString(7)));
        d.b.h0.r.s.e eVar2 = new d.b.h0.r.s.e(this.f52762b.getPageContext());
        eVar2.l(R.string.pb_privacy_setting_thread_reply_decs);
        this.Y = eVar2;
        eVar2.k(arrayList, onItemClickListener);
        eVar2.c();
        this.Y.n();
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0049, code lost:
        if (r5.q1 == 1) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void S() {
        boolean z2;
        d.b.i0.c2.p.c cVar = this.r1;
        if (cVar == null) {
            return;
        }
        if (((cVar.a() == null || this.r1.a().getParent() == null) ? -1 : this.k.getPositionForView(this.r1.a())) != -1) {
            if (this.r1.a().getTop() + R1 <= this.H0.getBottom()) {
                this.q1 = 1;
                z2 = true;
            } else {
                this.q1 = 0;
                z2 = false;
            }
        }
        this.J0.s(this.q1 == 1);
        this.r1.e(z2);
    }

    public void S0() {
        d.b.h0.r.f0.a aVar = this.w0;
        if (aVar != null) {
            aVar.h(false);
        }
    }

    public void S1() {
        Q1();
        Q0();
        this.T0.c();
        F2(false);
    }

    public void S2() {
        PostData postData;
        if (!TbadkCoreApplication.isLogin() || this.y0 == null || !this.Y0 || this.X0 || this.a0 || (postData = this.z0) == null || postData.s() == null || this.z0.s().getIsLike() || this.z0.s().hadConcerned() || this.U0 != null) {
            return;
        }
        this.U0 = new m0(this.f52762b);
    }

    public void T() {
        this.f52767g.e();
        d.b.i0.c2.k.e.x0.e eVar = this.r;
        if (eVar != null) {
            eVar.j();
        }
        PbFragment pbFragment = this.f52762b;
        if (pbFragment != null) {
            d.b.b.e.p.l.w(pbFragment.getContext(), this.C);
        }
        Q0();
        d.b.h0.r.s.j jVar = this.W;
        if (jVar != null) {
            jVar.dismiss();
        }
        X();
        d.b.h0.r.s.a aVar = this.z;
        if (aVar != null) {
            aVar.dismiss();
        }
        d.b.h0.r.s.b bVar = this.A;
        if (bVar != null) {
            bVar.e();
        }
    }

    public void T0() {
        Runnable runnable;
        if (this.u == null) {
            Y0();
        }
        this.j.setVisibility(8);
        Handler handler = this.x1;
        if (handler == null || (runnable = this.y1) == null) {
            return;
        }
        handler.removeCallbacks(runnable);
    }

    public final void T1() {
        d.b.i0.c2.k.e.x0.f fVar = this.o;
        if (fVar != null) {
            fVar.q(this.k, this.G0, this.A0);
        }
    }

    public void T2() {
        this.H.setVisibility(0);
    }

    public void U() {
        this.f52767g.e();
        d.b.i0.c2.k.e.x0.e eVar = this.r;
        if (eVar != null) {
            eVar.j();
        }
        d.b.h0.r.s.j jVar = this.W;
        if (jVar != null) {
            jVar.dismiss();
        }
        X();
        d.b.h0.r.s.a aVar = this.z;
        if (aVar != null) {
            aVar.dismiss();
        }
        d.b.h0.r.s.b bVar = this.A;
        if (bVar != null) {
            bVar.e();
        }
    }

    public void U0() {
        this.H.setVisibility(8);
    }

    public void U1() {
        Handler handler = this.x1;
        if (handler == null) {
            return;
        }
        Runnable runnable = this.y1;
        if (runnable != null) {
            handler.removeCallbacks(runnable);
        }
        c cVar = new c();
        this.y1 = cVar;
        this.x1.postDelayed(cVar, 2000L);
    }

    public void U2(z0 z0Var, a.e eVar) {
        if (z0Var == null) {
            return;
        }
        int a2 = z0Var.a();
        int h2 = z0Var.h();
        d.b.h0.r.s.a aVar = this.z;
        if (aVar != null) {
            aVar.show();
        } else {
            this.z = new d.b.h0.r.s.a(this.f52762b.getPageContext().getPageActivity());
            View inflate = LayoutInflater.from(this.f52762b.getPageContext().getPageActivity()).inflate(R.layout.dialog_direct_pager, (ViewGroup) null);
            this.B = inflate;
            this.z.setContentView(inflate);
            this.z.setPositiveButton(R.string.dialog_ok, eVar);
            this.z.setNegativeButton(R.string.dialog_cancel, new r());
            this.z.setOnCalcelListener(new s());
            this.z.create(this.f52762b.getPageContext()).show();
        }
        EditText editText = (EditText) this.B.findViewById(R.id.input_page_number);
        this.C = editText;
        editText.setText("");
        TextView textView = (TextView) this.B.findViewById(R.id.current_page_number);
        if (a2 <= 0) {
            a2 = 1;
        }
        if (h2 <= 0) {
            h2 = 1;
        }
        textView.setText(MessageFormat.format(TbadkCoreApplication.getInst().getResources().getString(R.string.current_page), Integer.valueOf(a2), Integer.valueOf(h2)));
        this.f52762b.getBaseFragmentActivity().ShowSoftKeyPadDelay(this.C, 150);
    }

    public void V() {
        d.b.i0.c2.p.d dVar = this.r0;
        if (dVar != null) {
            dVar.h(false);
        }
    }

    public void V0() {
        EditorTools editorTools = this.f0;
        if (editorTools != null) {
            editorTools.q();
        }
    }

    public void V1(EditorTools editorTools) {
        this.f0 = editorTools;
        editorTools.setOnCancelClickListener(new e());
        this.f0.setId(R.id.pb_editor);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        if (this.f0.getParent() == null) {
            this.f52763c.addView(this.f0, layoutParams);
        }
        this.f0.w(TbadkCoreApplication.getInst().getSkinType());
        this.f0.setActionListener(24, new f());
        Q0();
        this.f52762b.D4().i(new g());
    }

    public void V2(boolean z2) {
        TextView textView;
        if (this.k == null || (textView = this.G0) == null || this.f52764d == null) {
            return;
        }
        if (z2) {
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.f52764d.setVisibility(0);
            } else {
                this.f52764d.setVisibility(8);
                this.k.removeHeaderView(this.G0);
                this.k.setTextViewAdded(false);
            }
            AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) this.G0.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = K1;
                this.G0.setLayoutParams(layoutParams);
            }
            T1();
            return;
        }
        AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) textView.getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT) + w0(true);
            this.G0.setLayoutParams(layoutParams2);
        }
        T1();
        N1();
    }

    public final boolean W() {
        return this.p.b(this.x0);
    }

    public final void W0() {
        if (this.q == null) {
            this.q = new d.b.i0.c2.k.e.x0.c(this.f52762b, this.d0);
        }
    }

    public void W1(String str) {
        PbListView pbListView = this.E;
        if (pbListView != null) {
            pbListView.A(str);
        }
    }

    public final void W2(d.b.i0.c2.h.e eVar) {
        if (eVar == null || eVar.L() == null || eVar.L().y2()) {
            return;
        }
        boolean z2 = eVar.L().w0() == 1;
        boolean z3 = eVar.L().x0() == 1;
        d.b.i0.c2.k.e.x0.e eVar2 = this.r;
        if (eVar2 != null) {
            eVar2.i(eVar, z2, z3);
        }
        d.b.i0.c2.k.e.g gVar = this.y;
        if (gVar == null || gVar.s() == null) {
            return;
        }
        this.y.s().d(eVar, z2, z3);
    }

    public void X() {
        d.b.h0.r.s.a aVar = this.N;
        if (aVar != null) {
            aVar.dismiss();
        }
        Dialog dialog = this.O;
        if (dialog != null) {
            d.b.b.e.m.g.b(dialog, this.f52762b.getPageContext());
        }
        Dialog dialog2 = this.P;
        if (dialog2 != null) {
            d.b.b.e.m.g.b(dialog2, this.f52762b.getPageContext());
        }
        d.b.h0.r.s.j jVar = this.L;
        if (jVar != null) {
            jVar.dismiss();
        }
    }

    public final void X0(d.b.i0.c2.h.e eVar) {
        if (eVar == null || eVar.L() == null || !eVar.L().c2() || this.E0 != null) {
            return;
        }
        PbInterviewStatusView pbInterviewStatusView = (PbInterviewStatusView) this.D0.inflate();
        this.E0 = pbInterviewStatusView;
        pbInterviewStatusView.setOnClickListener(this.I);
        this.E0.setCallback(this.f52762b.t4());
        this.E0.setData(this.f52762b, eVar);
    }

    public void X1(String str) {
        PbReplyTitleViewHolder pbReplyTitleViewHolder;
        if (this.E != null) {
            int i2 = 0;
            d0 d0Var = this.N0;
            if (d0Var != null && (pbReplyTitleViewHolder = d0Var.f52785c) != null && pbReplyTitleViewHolder.a() != null) {
                i2 = this.N0.f52785c.a().getTop() < 0 ? this.N0.f52785c.a().getHeight() : this.N0.f52785c.a().getBottom();
            }
            this.E.D(str, i2);
        }
    }

    @SuppressLint({"CutPasteId"})
    public void X2(d.b.i0.c2.h.e eVar, boolean z2) {
        if (eVar == null) {
            return;
        }
        f3(eVar, z2);
        W();
    }

    public void Y() {
        d.b.i0.c2.k.e.x0.f fVar = this.o;
        if (fVar != null) {
            fVar.b();
        }
    }

    public final void Y0() {
        if (this.f52762b.v4()) {
            ViewStub viewStub = (ViewStub) this.f52763c.findViewById(R.id.manga_mention_controller_view_stub);
            this.j = viewStub;
            viewStub.setVisibility(0);
            if (this.u == null) {
                this.u = (LinearLayout) this.f52763c.findViewById(R.id.manga_controller_layout);
                d.b.h0.s0.a.a(this.f52762b.getPageContext(), this.u);
            }
            if (this.v == null) {
                this.v = (TextView) this.u.findViewById(R.id.manga_prev_btn);
            }
            if (this.w == null) {
                this.w = (TextView) this.u.findViewById(R.id.manga_next_btn);
            }
            this.v.setOnClickListener(this.I);
            this.w.setOnClickListener(this.I);
        }
    }

    public void Y1(PbFragment.m2 m2Var) {
        this.A1 = m2Var;
    }

    public void Y2(String str) {
        this.f52762b.showToast(str);
    }

    public void Z() {
        PbListView pbListView = this.E;
        if (pbListView != null) {
            pbListView.v();
            this.E.f();
        }
        S0();
    }

    public void Z0() {
        EditorTools editorTools;
        if (this.f52762b == null || (editorTools = this.f0) == null) {
            return;
        }
        editorTools.j();
        if (this.f52762b.D4() != null) {
            this.f52762b.D4().P();
        }
        O0();
    }

    public void Z1(boolean z2) {
        this.g0 = z2;
    }

    public void Z2() {
        this.f52762b.showProgressBar();
    }

    public NoNetworkView a() {
        return this.l;
    }

    public void a0() {
        this.k.A(0L);
        W();
    }

    public final void a1() {
        if (this.s == null) {
            this.s = new d.b.i0.c2.k.e.x0.b(this.f52762b, this.I);
        }
    }

    public void a2(boolean z2) {
        this.y.a0(z2);
    }

    public void a3() {
        if (this.G1 != null) {
            while (this.G1.size() > 0) {
                TbImageView remove = this.G1.remove(0);
                if (remove != null) {
                    remove.c0();
                }
            }
        }
    }

    public void b0(int i2, boolean z2, String str, boolean z3) {
        this.f52762b.hideProgressBar();
        if (z2 && z3) {
            PbFragment pbFragment = this.f52762b;
            pbFragment.showToast(pbFragment.getPageContext().getString(R.string.success));
        } else if (z3) {
            if (d.b.b.e.p.k.isEmpty(str)) {
                str = TbadkCoreApplication.getInst().getResources().getString(R.string.neterror);
            }
            this.f52762b.showToast(str);
        }
    }

    public void b1(d.b.i0.c2.h.e eVar) {
        PbReplyTitleViewHolder pbReplyTitleViewHolder;
        int i2 = 0;
        this.y.Z(eVar, false);
        this.y.U();
        W();
        d.b.i0.c2.k.d.a aVar = this.g1;
        if (aVar != null) {
            aVar.n();
        }
        ArrayList<PostData> D = eVar.D();
        if (eVar.w().b() == 0 || D == null || D.size() < eVar.w().e()) {
            if (ListUtils.getCount(D) != 0 && (ListUtils.getCount(D) != 1 || D.get(0) == null || D.get(0).z() != 1)) {
                if (eVar.w().b() == 0) {
                    this.E.A(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                } else {
                    this.E.A(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                }
                this.E.j();
            } else {
                d0 d0Var = this.N0;
                if (d0Var != null && (pbReplyTitleViewHolder = d0Var.f52785c) != null && pbReplyTitleViewHolder.a() != null) {
                    i2 = this.N0.f52785c.a().getTop() < 0 ? this.N0.f52785c.a().getHeight() : this.N0.f52785c.a().getBottom();
                }
                if (this.f52762b.Y4()) {
                    this.E.D(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_host_reply), i2);
                } else {
                    this.E.D(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_replay), i2);
                }
            }
        }
        K1(eVar);
    }

    public void b2(boolean z2) {
        d.b.i0.c2.k.e.x0.f fVar = this.o;
        if (fVar != null) {
            fVar.r(z2);
        }
    }

    public void b3(boolean z2) {
        this.Z = z2;
    }

    public void c0() {
        PbLandscapeListView pbLandscapeListView = this.k;
        if (pbLandscapeListView != null) {
            pbLandscapeListView.setForbidDragListener(true);
        }
    }

    public boolean c1() {
        return this.D1;
    }

    public void c2(boolean z2) {
        this.o1 = z2;
    }

    public void c3(boolean z2) {
        this.f52767g.z(z2);
        if (z2 && this.C0) {
            this.E.A(TbadkCoreApplication.getInst().getResources().getString(R.string.click_load_more));
            this.k.setNextPage(this.E);
            this.f52765e = 2;
        }
        q1();
    }

    public final String d0(int i2) {
        if (i2 == 0) {
            return this.f52762b.getString(R.string.pb_comment_red_dot_no_reply);
        }
        NumberFormat numberFormat = NumberFormat.getInstance();
        numberFormat.setRoundingMode(RoundingMode.HALF_UP);
        if (i2 > 9990000) {
            return "· · ·";
        }
        if (i2 >= 1000000) {
            numberFormat.setMaximumFractionDigits(0);
            return numberFormat.format(i2 / 10000.0f) + ExifInterface.LONGITUDE_WEST;
        } else if (i2 >= 10000) {
            numberFormat.setMaximumFractionDigits(1);
            return numberFormat.format(i2 / 10000.0f) + ExifInterface.LONGITUDE_WEST;
        } else {
            return "" + i2;
        }
    }

    public boolean d1() {
        return this.u0;
    }

    public void d2(boolean z2) {
        this.i1 = z2;
    }

    public void d3(d.b.i0.c2.h.c cVar) {
        String string;
        if (cVar == null) {
            return;
        }
        this.f52767g.A();
        if (!StringUtils.isNull(cVar.f52415b)) {
            this.f52767g.x(cVar.f52415b);
        }
        String string2 = TbadkCoreApplication.getInst().getResources().getString(R.string.thread_delete_by);
        int d2 = d.b.b.e.m.b.d(cVar.f52414a, 0);
        if (d2 == 100) {
            string = TbadkCoreApplication.getInst().getResources().getString(R.string.self);
        } else if (d2 != 300) {
            string = d2 != 400 ? "" : TbadkCoreApplication.getInst().getResources().getString(R.string.system);
        } else {
            string = TbadkCoreApplication.getInst().getResources().getString(R.string.bawu);
        }
        this.f52762b.showNetRefreshView(this.f52763c, String.format(string2, string), null, TbadkCoreApplication.getInst().getResources().getString(R.string.appeal_restore), true, new p(cVar.f52416c));
    }

    public d.b.i0.c2.k.e.g e0() {
        return this.y;
    }

    public final boolean e1(d.b.i0.c2.h.e eVar) {
        if (eVar == null || eVar.L() == null) {
            return false;
        }
        SpannableStringBuilder l1 = eVar.L().l1();
        if (l1 != null) {
            return TbadkApplication.getInst().getResources().getString(R.string.pb_default_share_tie_title).equals(l1.toString());
        }
        return true;
    }

    public void e2(boolean z2) {
        d.b.i0.c2.k.e.x0.f fVar = this.o;
        if (fVar != null) {
            fVar.s(z2);
        }
    }

    public void e3(d.b.i0.c2.h.e eVar) {
        if (eVar != null && AntiHelper.o(eVar.L())) {
            d.b.i0.c2.p.d dVar = this.r0;
            if (dVar != null) {
                dVar.h(false);
                this.r0.g();
            }
            ViewGroup.LayoutParams layoutParams = this.q0.getLayoutParams();
            layoutParams.height = -2;
            layoutParams.width = -2;
            this.q0.setLayoutParams(layoutParams);
            WebPManager.setPureDrawable(this.q0, R.drawable.icon_pure_pb_bottom_share26, R.color.CAM_X0110, WebPManager.ResourceStateType.NORMAL_PRESS);
            return;
        }
        d.b.i0.c2.p.d dVar2 = this.r0;
        if (dVar2 == null || !dVar2.e()) {
            ViewGroup.LayoutParams layoutParams2 = this.q0.getLayoutParams();
            layoutParams2.height = -2;
            layoutParams2.width = -2;
            this.q0.setLayoutParams(layoutParams2);
            WebPManager.setPureDrawable(this.q0, R.drawable.icon_pure_pb_bottom_share26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        }
    }

    public LinearLayout f0() {
        return this.l0;
    }

    public boolean f1() {
        PbLandscapeListView pbLandscapeListView = this.k;
        if (pbLandscapeListView == null) {
            return false;
        }
        return pbLandscapeListView.J();
    }

    public void f2(boolean z2) {
        this.y.c0(z2);
    }

    public boolean f3(d.b.i0.c2.h.e eVar, boolean z2) {
        if (eVar == null) {
            return false;
        }
        if (this.q != null) {
            if (eVar.L() != null && eVar.L().v0() == 0 && !eVar.L().y2() && !this.t1) {
                if (eVar.L() != null) {
                    a2 L = eVar.L();
                    L.R2(true, H2(eVar));
                    L.Z3(3);
                    L.V3("2");
                }
                if (eVar.L().O1()) {
                    this.r.s(this.k);
                    this.q.d(this.k);
                    this.q.a(this.k);
                    this.r.g(this.k);
                    this.r.w(this.y0);
                    if (e1(eVar)) {
                        this.q.d(this.k);
                    } else {
                        this.q.e(eVar);
                    }
                } else {
                    this.r.w(this.y0);
                    if (e1(eVar)) {
                        this.q.d(this.k);
                    } else {
                        this.q.g(eVar);
                    }
                }
            } else if (eVar.L().v0() == 1) {
                if (eVar.L() != null) {
                    this.q.d(this.k);
                    this.r.w(this.y0);
                }
            } else {
                this.q.d(this.k);
                this.r.w(this.y0);
            }
        }
        W2(eVar);
        this.x0 = z2;
        return false;
    }

    public View g0() {
        View view = this.Q;
        if (view != null) {
            return view.findViewById(R.id.dialog_button_ok);
        }
        return null;
    }

    public boolean g1() {
        EditorTools editorTools = this.f0;
        return editorTools != null && editorTools.getVisibility() == 0;
    }

    public void g2(boolean z2) {
        this.y.h0(z2);
    }

    public final void g3() {
        if (this.f52762b.v4()) {
            if (this.f52762b.A4() == -1) {
                SkinManager.setViewTextColor(this.v, R.color.CAM_X0110, 1);
            }
            if (this.f52762b.z4() == -1) {
                SkinManager.setViewTextColor(this.w, R.color.CAM_X0110, 1);
            }
        }
    }

    public String h0() {
        return this.V;
    }

    public final boolean h1(PostData postData) {
        if (postData == null || postData.s() == null) {
            return false;
        }
        MetaData s2 = postData.s();
        return (TextUtils.isEmpty(s2.getUserId()) && TextUtils.isEmpty(s2.getAvater())) ? false : true;
    }

    public void h2(f.g gVar) {
        this.F1 = gVar;
        d.b.i0.c2.p.e eVar = this.D;
        if (eVar != null) {
            eVar.b(gVar);
        }
    }

    public void h3(d.b.i0.c2.h.e eVar) {
        d.b.i0.c2.k.e.x0.a aVar = this.p;
        if (aVar != null) {
            aVar.g(eVar, this.x0);
        }
    }

    public int i0() {
        View childAt;
        PbLandscapeListView pbLandscapeListView = this.k;
        if (pbLandscapeListView == null) {
            return 0;
        }
        int firstVisiblePosition = pbLandscapeListView.getFirstVisiblePosition();
        int lastVisiblePosition = this.k.getLastVisiblePosition();
        if (lastVisiblePosition > firstVisiblePosition) {
            int i2 = (lastVisiblePosition - firstVisiblePosition) + 1;
            int[] iArr = new int[i2];
            Rect rect = new Rect();
            int childCount = this.k.getChildCount();
            int i3 = 0;
            for (int i4 = firstVisiblePosition; i4 <= lastVisiblePosition; i4++) {
                int i5 = i4 - firstVisiblePosition;
                if (i5 < childCount && (childAt = this.k.getChildAt(i5)) != null) {
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

    public boolean i1() {
        return false;
    }

    public void i2(String str) {
        d.b.i0.c2.k.e.c1.b bVar = this.f52768h;
        if (bVar != null) {
            bVar.b(str);
        }
    }

    public PostData j0() {
        if (this.k == null) {
            return null;
        }
        int i0 = i0() - this.k.getHeaderViewsCount();
        int i2 = 0;
        if (i0 < 0) {
            i0 = 0;
        }
        if (this.y.x(i0) != null && this.y.x(i0) != PostData.n0) {
            i2 = i0 + 1;
        }
        if (this.y.w(i2) instanceof PostData) {
            return (PostData) this.y.w(i2);
        }
        return null;
    }

    public final boolean j1() {
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.E1);
    }

    public void j2(boolean z2) {
        this.V0 = z2;
        PbLandscapeListView pbLandscapeListView = this.k;
        if (pbLandscapeListView != null) {
            this.W0 = pbLandscapeListView.getHeaderViewsCount();
        }
    }

    public int k0() {
        return m0(this.k.getFirstVisiblePosition());
    }

    public final boolean k1(a2 a2Var) {
        if (a2Var == null || a2Var.T() == null) {
            return false;
        }
        PostData l0 = l0(this.y0, false);
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), (l0 == null || l0.s() == null) ? "" : l0.s().getUserId());
    }

    public void k2(PbFragment.n2 n2Var) {
    }

    public PostData l0(d.b.i0.c2.h.e eVar, boolean z2) {
        PostData postData = null;
        if (eVar == null) {
            return null;
        }
        if (eVar.S() != null) {
            return eVar.S();
        }
        if (!ListUtils.isEmpty(eVar.D())) {
            Iterator<PostData> it = eVar.D().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                PostData next = it.next();
                if (next != null && next.z() == 1) {
                    postData = next;
                    break;
                }
            }
        }
        if (postData == null) {
            postData = eVar.j();
        }
        if (!h1(postData)) {
            postData = D0(eVar);
        }
        if (postData != null && postData.s() != null && postData.s().getUserTbVipInfoData() != null && postData.s().getUserTbVipInfoData().getvipIntro() != null) {
            postData.s().getGodUserData().setIntro(postData.s().getUserTbVipInfoData().getvipIntro());
        }
        return postData;
    }

    public boolean l1() {
        View view = this.K0;
        if (view == null || view.getParent() == null || this.E.l()) {
            return false;
        }
        int bottom = this.K0.getBottom();
        Rect rect = new Rect();
        this.K0.getWindowVisibleDisplayFrame(rect);
        return bottom > 0 && bottom <= rect.bottom;
    }

    public void l2(TbRichTextView.w wVar) {
        this.J = wVar;
        this.y.k0(wVar);
        this.g1.q(this.J);
    }

    public final int m0(int i2) {
        d.b.b.j.e.e adapter2 = this.k.getAdapter2();
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
        int n2 = (this.k.getAdapter2() == null || !(this.k.getAdapter2() instanceof d.b.b.j.e.e)) ? 0 : this.k.getAdapter2().n();
        if (i2 > n2) {
            return i2 - n2;
        }
        return 0;
    }

    public boolean m1() {
        d.b.i0.c2.h.e eVar = this.y0;
        return eVar == null || eVar.l() == null || "0".equals(this.y0.l().getId()) || "me0407".equals(this.y0.l().getName());
    }

    public void m2(NoNetworkView.b bVar) {
        this.K = bVar;
        NoNetworkView noNetworkView = this.l;
        if (noNetworkView != null) {
            noNetworkView.a(bVar);
        }
    }

    public Button n0() {
        return this.i0;
    }

    public boolean n1() {
        d.b.i0.c2.k.e.x0.f fVar = this.o;
        return fVar != null && fVar.f();
    }

    public void n2(BdListView.p pVar) {
        this.k.setOnSrollToBottomListener(pVar);
    }

    public int o0() {
        return this.k.getHeaderViewsCount();
    }

    public boolean o1() {
        return this.t1;
    }

    public void o2(AbsListView.OnScrollListener onScrollListener) {
        this.k.setOnScrollListener(onScrollListener);
    }

    public TextView p0() {
        return this.r.k();
    }

    public boolean p1() {
        EditorTools editorTools = this.f0;
        return editorTools != null && editorTools.u();
    }

    public void p2(int i2) {
        this.p1 = i2;
    }

    public PbInterviewStatusView q0() {
        return this.E0;
    }

    public final void q1() {
        if (this.m0 != null && TbadkCoreApplication.getCurrentAccountInfo() != null) {
            this.m0.setImageResource(0);
            this.m0.W(TbadkCoreApplication.getCurrentAccountInfo().getAvatar(), 12, false);
            return;
        }
        this.m0.setImageResource(R.drawable.transparent_bg);
    }

    public void q2(View.OnLongClickListener onLongClickListener) {
        this.r.t(onLongClickListener);
        this.y.l0(onLongClickListener);
        d.b.i0.c2.k.d.a aVar = this.g1;
        if (aVar != null) {
            aVar.r(onLongClickListener);
        }
    }

    public boolean r0() {
        return this.i1;
    }

    public void r1(int i2) {
        if (this.B0 == i2) {
            return;
        }
        this.B0 = i2;
        X2(this.y0, this.x0);
        M1(this.y0, this.x0, this.A0, i2);
        this.f52762b.getBaseFragmentActivity().getLayoutMode().k(i2 == 1);
        this.f52762b.getBaseFragmentActivity().getLayoutMode().j(this.f52763c);
        SkinManager.setBackgroundColor(this.f52763c, R.color.CAM_X0201);
        SkinManager.setBackgroundColor(this.h0, R.color.CAM_X0203);
        d.b.i0.c2.k.e.x0.f fVar = this.o;
        if (fVar != null) {
            fVar.h(i2);
        }
        d.b.i0.c2.k.e.x0.b bVar = this.s;
        if (bVar != null) {
            bVar.c(i2);
        }
        d.b.i0.c2.k.e.x0.a aVar = this.p;
        if (aVar != null) {
            aVar.d(i2);
        }
        d.b.i0.c2.k.e.x0.c cVar = this.q;
        if (cVar != null) {
            cVar.c(i2);
        }
        d.b.i0.c2.k.e.x0.e eVar = this.r;
        if (eVar != null) {
            eVar.p(i2);
        }
        d.b.i0.c2.k.e.x0.d dVar = this.t;
        if (dVar != null) {
            dVar.d();
        }
        MaskView maskView = this.s1;
        if (maskView != null) {
            maskView.c();
        }
        PbListView pbListView = this.E;
        if (pbListView != null) {
            pbListView.d(i2);
        }
        if (this.G != null) {
            this.f52762b.getBaseFragmentActivity().getLayoutMode().j(this.G);
            SkinManager.setBackgroundResource(this.G, R.drawable.pb_foot_more_trans_selector);
        }
        d.b.h0.r.s.a aVar2 = this.z;
        if (aVar2 != null) {
            aVar2.autoChangeSkinType(this.f52762b.getPageContext());
        }
        b3(this.Z);
        this.y.U();
        d.b.i0.c2.p.e eVar2 = this.D;
        if (eVar2 != null) {
            eVar2.I(i2);
        }
        EditorTools editorTools = this.f0;
        if (editorTools != null) {
            editorTools.w(i2);
        }
        d.b.i0.c2.p.a aVar3 = this.F;
        if (aVar3 != null) {
            aVar3.f(i2);
        }
        if (!ListUtils.isEmpty(this.m)) {
            for (CustomBlueCheckRadioButton customBlueCheckRadioButton : this.m) {
                customBlueCheckRadioButton.c();
            }
        }
        g3();
        UtilHelper.setStatusBarBackground(this.f52764d, i2);
        UtilHelper.setStatusBarBackground(this.I0, i2);
        if (this.u != null) {
            d.b.h0.s0.a.a(this.f52762b.getPageContext(), this.u);
        }
        d.b.i0.c2.k.e.s sVar = this.T0;
        if (sVar != null) {
            sVar.h(i2);
        }
        d.b.i0.c2.k.e.c1.c cVar2 = this.f52767g;
        if (cVar2 != null) {
            d.b.i0.c2.k.e.x0.f fVar2 = this.o;
            if (fVar2 != null) {
                fVar2.i(i2);
            } else {
                cVar2.m(i2);
            }
        }
        HeadImageView headImageView = this.m0;
        if (headImageView != null) {
            headImageView.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
        }
        LinearLayout linearLayout = this.l0;
        if (linearLayout != null) {
            linearLayout.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(d.b.b.e.p.l.g(this.f52762b.getContext(), R.dimen.tbds47), SkinManager.getColor(R.color.CAM_X0209)));
        }
        d.b.i0.c2.h.e eVar3 = this.y0;
        if (eVar3 != null && eVar3.r()) {
            WebPManager.setPureDrawable(this.p0, R.drawable.icon_pure_pb_bottom_collected26_selection, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
        } else {
            WebPManager.setPureDrawable(this.p0, R.drawable.icon_pure_pb_bottom_collect26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        }
        WebPManager.setPureDrawable(this.o0, R.drawable.icon_pure_pb_bottom_comment26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        e3(this.y0);
        SkinManager.setBackgroundColor(this.k0, R.color.CAM_X0207);
        SkinManager.setBackgroundColor(this.j0, R.color.CAM_X0203);
        SkinManager.setViewTextColor(this.d1, R.color.cp_cont_n);
        SkinManager.setViewTextColor(this.n0, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.t0, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.s0, R.color.CAM_X0107);
        TextView textView = this.s0;
        int g2 = d.b.b.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18);
        int i3 = R.color.CAM_X0207;
        SkinManager.setBackgroundShapeDrawable(textView, g2, i3, i3);
        d.b.i0.c2.k.d.a aVar4 = this.g1;
        if (aVar4 != null) {
            aVar4.m(i2);
        }
        PbEmotionBar pbEmotionBar = this.O0;
        if (pbEmotionBar != null) {
            pbEmotionBar.w();
        }
        PbThreadPostView pbThreadPostView = this.n;
        if (pbThreadPostView != null) {
            pbThreadPostView.c(i2);
        }
        d.b.i0.c2.p.d dVar2 = this.r0;
        if (dVar2 != null) {
            dVar2.f();
        }
        d.b.i0.c2.p.c cVar3 = this.r1;
        if (cVar3 != null) {
            cVar3.c();
        }
    }

    public final void r2(PostData postData, d.b.i0.c2.h.e eVar) {
        this.r.u(postData, eVar);
    }

    public int s0() {
        int lastVisiblePosition = this.k.getLastVisiblePosition();
        if (this.o != null) {
            if (lastVisiblePosition == this.k.getCount() - 1) {
                lastVisiblePosition--;
            }
            if (lastVisiblePosition < 0) {
                lastVisiblePosition = 0;
            }
        }
        return m0(lastVisiblePosition);
    }

    public void s1(Configuration configuration) {
        if (configuration == null) {
            return;
        }
        T();
        if (configuration.orientation == 2) {
            O0();
            Q0();
        } else {
            S1();
        }
        d.b.i0.c2.k.e.s sVar = this.T0;
        if (sVar != null) {
            sVar.c();
        }
        this.f52762b.Q4();
        this.x.setVisibility(8);
        this.f52767g.t(false);
        this.f52762b.G5(false);
        if (this.o != null) {
            if (configuration.orientation == 1) {
                L0().setVisibility(0);
            }
            if (configuration.orientation == 2) {
                this.J1 = true;
                this.k.setIsLandscape(true);
                this.k.smoothScrollToPosition(0);
            } else {
                this.J1 = false;
                this.k.setIsLandscape(false);
                int i2 = this.H1;
                if (i2 > 0) {
                    this.k.smoothScrollBy(i2, 0);
                }
            }
            this.o.j(configuration);
            this.F0.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        }
    }

    public void s2(boolean z2, PostWriteCallBackData postWriteCallBackData) {
        this.f52762b.hideProgressBar();
        if (z2) {
            T();
        } else if (postWriteCallBackData != null && (postWriteCallBackData.isSensitiveError() || postWriteCallBackData.isErrorLinkCountExceedLimit() || postWriteCallBackData.isErrorShowApplyMemberDialog())) {
            U();
        } else {
            T();
        }
    }

    public BdTypeListView t0() {
        return this.k;
    }

    public void t1() {
        NoNetworkView.b bVar;
        d.b.i0.c2.p.d dVar = this.r0;
        if (dVar != null) {
            dVar.g();
        }
        m0 m0Var = this.U0;
        if (m0Var != null) {
            m0Var.a();
        }
        f0 f0Var = this.j1;
        if (f0Var != null) {
            f0Var.c();
        }
        PbTopTipView pbTopTipView = this.b1;
        if (pbTopTipView != null) {
            pbTopTipView.g();
        }
        this.f52762b.hideProgressBar();
        NoNetworkView noNetworkView = this.l;
        if (noNetworkView != null && (bVar = this.K) != null) {
            noNetworkView.d(bVar);
        }
        T();
        Z();
        if (this.R0 != null) {
            d.b.b.e.m.e.a().removeCallbacks(this.R0);
        }
        PbInterviewStatusView pbInterviewStatusView = this.E0;
        if (pbInterviewStatusView != null) {
            pbInterviewStatusView.m();
        }
        this.x1 = null;
        this.f52766f.removeCallbacksAndMessages(null);
        this.y.V(3);
        View view = this.f52764d;
        if (view != null) {
            view.setBackgroundDrawable(null);
        }
        d.b.i0.c2.k.e.x0.f fVar = this.o;
        if (fVar != null) {
            fVar.a();
        }
        d.b.i0.c2.k.e.g gVar = this.y;
        if (gVar != null) {
            gVar.W();
        }
        this.k.setOnLayoutListener(null);
        d.b.i0.c2.k.e.y0.c cVar = this.f1;
        if (cVar != null) {
            cVar.l();
        }
        PbEmotionBar pbEmotionBar = this.O0;
        if (pbEmotionBar != null) {
            pbEmotionBar.x();
        }
        d.b.i0.c2.k.e.x0.e eVar = this.r;
        if (eVar != null) {
            eVar.q();
        }
    }

    public void t2() {
        this.f52762b.hideProgressBar();
        Z();
        this.k.A(0L);
        W();
    }

    public SparseArray<Object> u0(d.b.i0.c2.h.e eVar, boolean z2, int i2) {
        PostData l0;
        d.b.h0.r.q.d0 d0Var;
        int i3;
        StringBuilder sb = null;
        if (eVar == null || (l0 = l0(eVar, z2)) == null) {
            return null;
        }
        String userId = l0.s().getUserId();
        boolean z3 = userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount());
        SparseArray<Object> sparseArray = new SparseArray<>();
        if (i2 == 0) {
            sparseArray.put(R.id.tag_del_post_id, l0.D());
            sparseArray.put(R.id.tag_del_post_type, 0);
            sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z3));
            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(eVar.R()));
            sparseArray.put(R.id.tag_should_manage_visible, Boolean.FALSE);
        } else if (i2 == 1) {
            if (l0.s() != null) {
                sparseArray.put(R.id.tag_forbid_user_name, l0.s().getUserName());
                sparseArray.put(R.id.tag_forbid_user_name_show, l0.s().getName_show());
                sparseArray.put(R.id.tag_forbid_user_portrait, l0.s().getPortrait());
                sparseArray.put(R.id.tag_forbid_user_post_id, l0.D());
            }
            sparseArray.put(R.id.tag_del_post_id, l0.D());
            sparseArray.put(R.id.tag_del_post_type, 0);
            sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z3));
            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(eVar.R()));
            sparseArray.put(R.id.tag_should_manage_visible, Boolean.TRUE);
        }
        if (!z3) {
            List<w1> p2 = eVar.p();
            if (ListUtils.getCount(p2) > 0) {
                sb = new StringBuilder();
                for (w1 w1Var : p2) {
                    if (w1Var != null && !StringUtils.isNull(w1Var.i()) && (d0Var = w1Var.f50922g) != null && d0Var.f50757a && !d0Var.f50759c && ((i3 = d0Var.f50758b) == 1 || i3 == 2)) {
                        sb.append(d.b.b.e.p.k.cutString(w1Var.i(), 12));
                        sb.append(this.f52762b.getString(R.string.forum));
                        sb.append("、");
                    }
                }
            }
            if (sb != null && !StringUtils.isNull(sb.toString())) {
                sparseArray.put(R.id.tag_del_multi_forum, String.format(this.f52762b.getString(R.string.del_multi_forum_default_txt), sb.toString().substring(0, sb.length() - 1)));
            }
        }
        return sparseArray;
    }

    public void u1(TbRichText tbRichText) {
        PostData postData;
        d.b.i0.c2.h.e eVar = this.y0;
        if (eVar == null || eVar.D() == null || this.y0.D().isEmpty() || tbRichText == null || StringUtils.isNull(tbRichText.getAuthorId())) {
            return;
        }
        for (int i2 = 0; i2 < this.y0.D().size() && (postData = this.y0.D().get(i2)) != null && postData.s() != null && !StringUtils.isNull(postData.s().getUserId()); i2++) {
            if (this.y0.D().get(i2).s().getUserId().equals(tbRichText.getAuthorId())) {
                d.b.i0.c2.k.d.a aVar = this.g1;
                if (aVar != null && aVar.l()) {
                    F2(false);
                }
                PbEmotionBar pbEmotionBar = this.O0;
                if (pbEmotionBar != null) {
                    pbEmotionBar.q(true);
                }
                postData.s().getName_show();
                return;
            }
        }
    }

    public void u2() {
        PbFragment pbFragment = this.f52762b;
        if (pbFragment == null || pbFragment.getBaseFragmentActivity() == null) {
            return;
        }
        d.b.b.e.p.l.w(this.f52762b.getPageContext().getPageActivity(), this.f52762b.getBaseFragmentActivity().getCurrentFocus());
    }

    public d.b.i0.c2.k.d.a v0() {
        return this.g1;
    }

    public boolean v1(int i2) {
        d.b.i0.c2.k.e.x0.f fVar = this.o;
        if (fVar != null) {
            return fVar.k(i2);
        }
        return false;
    }

    public void v2() {
        this.E.x();
        this.E.O();
    }

    public final int w0(boolean z2) {
        PbInterviewStatusView pbInterviewStatusView = this.E0;
        if (pbInterviewStatusView != null && pbInterviewStatusView.getVisibility() == 0 && z2) {
            return 0 + d.b.b.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.ds72);
        }
        return 0;
    }

    public void w1() {
        PostData postData;
        if (this.f52762b == null) {
            return;
        }
        if ((this.o1 || this.p1 == 17) && d.b.h0.b.d.O()) {
            d.b.i0.c2.h.e eVar = this.y0;
            if (eVar == null || eVar.l() == null || d.b.b.e.p.k.isEmpty(this.y0.l().getName())) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f52762b.getContext()).createNormalCfg(this.y0.l().getName(), null)));
            TiebaStatic.log(new StatisticItem("c13853").param("post_id", this.y0.N()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("fid", this.y0.l().getId()));
        } else if (!this.Y0 || this.X0 || (postData = this.z0) == null || postData.s() == null) {
        } else {
            TiebaStatic.log(new StatisticItem("c12601").param("obj_locate", this.f52762b.isSimpleForum() ? 2 : 1).param("obj_type", this.X0 ? 2 : 1));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.f52762b.getPageContext().getPageActivity(), this.z0.s().getUserId(), this.z0.s().getUserName(), this.f52762b.L().a0(), AddFriendActivityConfig.TYPE_PB_HEAD)));
        }
    }

    public void w2(boolean z2) {
        this.r.v(z2);
    }

    public View x0() {
        return this.G;
    }

    public void x1(boolean z2) {
        if (z2) {
            K2();
        } else {
            R0();
        }
        this.N0.f52785c = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.N0));
        H1(this.N0.f52785c, false);
    }

    public void x2(String str) {
        this.n0.performClick();
        if (StringUtils.isNull(str) || this.f52762b.D4() == null || this.f52762b.D4().v() == null || this.f52762b.D4().v().i() == null) {
            return;
        }
        EditText i2 = this.f52762b.D4().v().i();
        i2.setText(str);
        i2.setSelection(str.length());
    }

    public int y0() {
        try {
            return Integer.parseInt(this.C.getText().toString(), 10);
        } catch (Exception unused) {
            return -1;
        }
    }

    public void y1() {
        a3();
        this.y.V(1);
        d.b.i0.c2.k.e.x0.f fVar = this.o;
        if (fVar != null) {
            fVar.l();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
    }

    public void y2(int i2) {
        this.k.setSelection(i2);
    }

    public View z0() {
        return this.H0;
    }

    public void z1() {
        this.y.V(2);
        d.b.i0.c2.k.e.x0.f fVar = this.o;
        if (fVar != null) {
            fVar.m();
            if (TbSingleton.getInstance().isNotchScreen(this.f52762b.getFragmentActivity()) || TbSingleton.getInstance().isCutoutScreen(this.f52762b.getFragmentActivity())) {
                return;
            }
            M0().setSystemUiVisibility(4);
        }
    }

    public void z2(int i2, int i3) {
        this.k.setSelectionFromTop(i2, i3);
    }
}

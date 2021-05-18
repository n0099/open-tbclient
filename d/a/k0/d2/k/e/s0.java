package d.a.k0.d2.k.e;

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
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
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
import d.a.j0.r.f0.f;
import d.a.j0.r.q.a2;
import d.a.j0.r.q.w1;
import d.a.j0.r.q.z0;
import d.a.j0.r.s.a;
import d.a.j0.r.s.b;
import d.a.j0.r.s.l;
import d.a.k0.d2.i.a;
import d.a.k0.d2.p.c;
import d.a.k0.d3.g0.a;
import d.a.k0.h.f;
import d.a.k0.h.i;
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
public class s0 {
    public static final int U1 = UtilHelper.getLightStatusBarHeight();
    public static int V1 = 3;
    public static int W1 = 0;
    public static int X1 = 3;
    public static int Y1 = 4;
    public static int Z1 = 5;
    public static int a2 = 6;
    public static final int b2 = d.a.c.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds80);
    public static a.f c2 = new t();
    public PostData A0;
    public d.a.j0.s.c.f A1;
    public int B0;
    public RightFloatLayerView B1;
    public String D1;
    public ViewStub E0;
    public PbListView F;
    public PbInterviewStatusView F0;
    public FrameLayout G0;
    public View H;
    public TextView H0;
    public View I;
    public View I0;
    public Runnable I1;
    public View.OnClickListener J;
    public View J0;
    public PbReplyTitleViewHolder K0;
    public PbFragment.n2 K1;
    public View L0;
    public View.OnClickListener N;
    public PbEmotionBar P0;
    public f.g P1;
    public int R0;
    public int R1;
    public Runnable S0;
    public PbFakeFloorModel T0;
    public boolean T1;
    public d.a.k0.d2.k.e.u U0;
    public o0 V0;

    /* renamed from: a  reason: collision with root package name */
    public final ViewTreeObserver.OnGlobalLayoutListener f53176a;

    /* renamed from: b  reason: collision with root package name */
    public int f53177b;
    public int b1;

    /* renamed from: c  reason: collision with root package name */
    public PbFragment f53178c;
    public PbTopTipView c1;

    /* renamed from: d  reason: collision with root package name */
    public RelativeLayout f53179d;
    public PopupWindow d1;

    /* renamed from: e  reason: collision with root package name */
    public View f53180e;
    public d.a.k0.d2.i.c e0;
    public TextView e1;
    public List<String> f1;
    public EditorTools g0;
    public d.a.k0.d2.k.e.a1.c g1;

    /* renamed from: h  reason: collision with root package name */
    public final d.a.k0.d2.k.e.e1.c f53183h;
    public d.a.k0.d2.k.d.a h1;

    /* renamed from: i  reason: collision with root package name */
    public d.a.k0.d2.k.e.e1.b f53184i;
    public View i0;
    public PbLandscapeListView.c i1;
    public ViewStub j;
    public ViewStub k;
    public View k0;
    public d.a.k0.d2.k.e.h0 k1;
    public PbLandscapeListView l;
    public View l0;
    public NavigationBarCoverTip l1;
    public NoNetworkView m;
    public LinearLayout m0;
    public d.a.k0.h.f m1;
    public List<CustomBlueCheckRadioButton> n;
    public HeadImageView n0;
    public d.a.k0.h.i n1;
    public PbThreadPostView o;
    public TextView o0;
    public String o1;
    public d.a.k0.d2.k.e.z0.f p;
    public ImageView p0;
    public PermissionJudgePolicy p1;
    public d.a.k0.d2.k.e.z0.a q;
    public ImageView q0;
    public long q1;
    public d.a.k0.d2.k.e.z0.c r;
    public ImageView r0;
    public boolean r1;
    public d.a.k0.d2.k.e.z0.e s;
    public d.a.k0.d2.p.h s0;
    public int s1;
    public d.a.k0.d2.k.e.z0.b t;
    public TextView t0;
    public d.a.k0.d2.k.e.z0.d u;
    public TextView u0;
    public boolean u1;
    public LinearLayout v;
    public d.a.k0.d2.p.g v1;
    public TextView w;
    public int w0;
    public MaskView w1;
    public TextView x;
    public final FallingView x1;
    public ObservedChangeRelativeLayout y;
    public final TbImageView y1;
    public d.a.k0.d2.k.e.i z;
    public d.a.k0.d2.h.e z0;
    public boolean z1;

    /* renamed from: f  reason: collision with root package name */
    public int f53181f = 0;

    /* renamed from: g  reason: collision with root package name */
    public final Handler f53182g = new Handler();
    public d.a.j0.r.s.a A = null;
    public d.a.j0.r.s.b B = null;
    public View C = null;
    public EditText D = null;
    public d.a.k0.d2.p.i E = null;
    public d.a.k0.d2.p.e G = null;
    public TbRichTextView.x K = null;
    public NoNetworkView.b L = null;
    public d.a.j0.r.s.j M = null;
    public d.a.j0.r.s.a O = null;
    public Dialog P = null;
    public Dialog Q = null;
    public View R = null;
    public LinearLayout S = null;
    public CompoundButton.OnCheckedChangeListener T = null;
    public TextView U = null;
    public TextView V = null;
    public String W = null;
    public d.a.j0.r.s.j X = null;
    public d.a.j0.r.s.j Y = null;
    public d.a.j0.r.s.e Z = null;
    public boolean a0 = false;
    public boolean b0 = false;
    public String c0 = null;
    public String d0 = null;
    public ScrollView f0 = null;
    public boolean h0 = false;
    public Button j0 = null;
    public boolean v0 = true;
    public d.a.j0.r.f0.a x0 = null;
    public boolean y0 = false;
    public int C0 = 3;
    public boolean D0 = false;
    public int M0 = 0;
    public boolean N0 = true;
    public l0 O0 = new l0();
    public int Q0 = 0;
    public boolean W0 = false;
    public int X0 = 0;
    public boolean Y0 = false;
    public boolean Z0 = false;
    public boolean a1 = false;
    public boolean j1 = false;
    public int t1 = 0;
    public CustomMessageListener C1 = new d0(2921552);
    public CustomMessageListener E1 = new h0(2921306);
    public Runnable F1 = new f();
    public CustomMessageListener G1 = new g(2005016);
    public Handler H1 = new Handler();
    public CustomMessageListener J1 = new i(2004009);
    public boolean L1 = true;
    public View.OnClickListener M1 = new v();
    public boolean N1 = false;
    public String O1 = null;
    public final List<TbImageView> Q1 = new ArrayList();
    public boolean S1 = false;

    /* loaded from: classes5.dex */
    public class a implements PbLandscapeListView.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f53185a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PbReplyTitleViewHolder f53186b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f53187c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f53188d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f53189e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f53190f;

        /* renamed from: d.a.k0.d2.k.e.s0$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class RunnableC1251a implements Runnable {
            public RunnableC1251a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (s0.this.L0 == null || s0.this.L0.getLayoutParams() == null) {
                    return;
                }
                ViewGroup.LayoutParams layoutParams = s0.this.L0.getLayoutParams();
                layoutParams.height = s0.this.R0;
                s0.this.L0.setLayoutParams(layoutParams);
            }
        }

        public a(int i2, PbReplyTitleViewHolder pbReplyTitleViewHolder, boolean z, int i3, int i4, int i5) {
            this.f53185a = i2;
            this.f53186b = pbReplyTitleViewHolder;
            this.f53187c = z;
            this.f53188d = i3;
            this.f53189e = i4;
            this.f53190f = i5;
        }

        @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.b
        public void onLayout() {
            ViewGroup.LayoutParams layoutParams;
            int i2;
            int i3 = this.f53185a;
            if (i3 >= 0 && i3 <= s0.this.f53179d.getMeasuredHeight()) {
                int M0 = s0.this.M0(this.f53186b);
                int i4 = this.f53185a;
                int i5 = M0 - i4;
                if (this.f53187c && i5 != 0 && i4 <= (i2 = this.f53188d)) {
                    i5 = M0 - i2;
                }
                if (s0.this.L0 == null || (layoutParams = s0.this.L0.getLayoutParams()) == null) {
                    return;
                }
                if (i5 == 0 || i5 > s0.this.f53179d.getMeasuredHeight() || M0 >= s0.this.f53179d.getMeasuredHeight()) {
                    layoutParams.height = s0.this.R0;
                } else {
                    if (layoutParams != null) {
                        int i6 = layoutParams.height;
                        if (i6 + i5 > 0 && i6 + i5 <= s0.this.f53179d.getMeasuredHeight()) {
                            layoutParams.height += i5;
                            s0.this.l.setSelectionFromTop(this.f53189e, this.f53190f);
                        }
                    }
                    layoutParams.height = s0.this.R0;
                }
                s0.this.L0.setLayoutParams(layoutParams);
                d.a.c.e.m.e.a().post(new RunnableC1251a());
            }
            s0.this.l.setOnLayoutListener(null);
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
                s0.this.f53178c.HidenSoftKeyPad((InputMethodManager) s0.this.f53178c.getBaseFragmentActivity().getSystemService("input_method"), s0.this.f53179d);
            }
        }

        public a0() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            if (s0.this.S0 == null) {
                s0.this.S0 = new a();
            }
            d.a.c.e.m.e.a().postDelayed(s0.this.S0, 150L);
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
                    s0.this.f53178c.V3(sparseArray);
                    return;
                }
                s0.this.S1(view);
            } else if (booleanValue2) {
                sparseArray.put(R.id.tag_from, 0);
                sparseArray.put(R.id.tag_check_mute_from, 1);
                s0.this.f53178c.V3(sparseArray);
            } else if (booleanValue3) {
                s0.this.P1(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b0 implements a.e {
        public b0(s0 s0Var) {
        }

        @Override // d.a.j0.r.s.a.e
        public void onClick(d.a.j0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            s0.this.f2();
        }
    }

    /* loaded from: classes5.dex */
    public class c0 implements a.e {
        public c0(s0 s0Var) {
        }

        @Override // d.a.j0.r.s.a.e
        public void onClick(d.a.j0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    /* loaded from: classes5.dex */
    public class d implements PbFakeFloorModel.b {
        public d() {
        }

        @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.b
        public void a(PostData postData) {
            s0.this.T0.A(postData);
            s0.this.z.U();
            s0.this.U0.c();
            s0.this.g0.q();
            s0.this.T2(false);
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
            s0.this.c1();
        }
    }

    /* loaded from: classes5.dex */
    public class e extends BaseBitmapDataSubscriber {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.j0.t.a f53199a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f53200b;

        public e(d.a.j0.t.a aVar, int i2) {
            this.f53199a = aVar;
            this.f53200b = i2;
        }

        @Override // com.facebook.datasource.BaseDataSubscriber
        public void onFailureImpl(DataSource<CloseableReference<CloseableImage>> dataSource) {
        }

        @Override // com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber
        public void onNewResultImpl(Bitmap bitmap) {
            s0.this.q3(this.f53199a, bitmap, this.f53200b);
        }
    }

    /* loaded from: classes5.dex */
    public class e0 implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f53202e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f53203f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f53204g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ View f53205h;

        public e0(int i2, int i3, int i4, View view) {
            this.f53202e = i2;
            this.f53203f = i3;
            this.f53204g = i4;
            this.f53205h = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i2 = this.f53202e;
            if (i2 == this.f53203f || i2 - this.f53204g >= 0) {
                s0.this.d1.showAsDropDown(s0.this.l0, this.f53205h.getLeft(), -s0.this.l0.getHeight());
            } else {
                s0.this.d1.showAsDropDown(this.f53205h);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (s0.this.y1 != null) {
                d.a.k0.d2.p.d.b(s0.this.y1);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f0 implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f53208e;

        public f0(String str) {
            this.f53208e = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            s0.this.B1.k();
            s0.this.z1(this.f53208e);
            s0.this.c1();
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
            if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2005016 || s0.this.z == null) {
                return;
            }
            s0.this.z.U();
        }
    }

    /* loaded from: classes5.dex */
    public class g0 implements View.OnClickListener {
        public g0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            s0.this.B1.k();
            s0.this.c1();
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
            if (s0.this.v == null) {
                s0.this.g1();
            }
            s0.this.k.setVisibility(0);
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
            s0.this.D1 = null;
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
            s0.this.v0 = false;
        }
    }

    /* loaded from: classes5.dex */
    public class i0 implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f53215e;

        public i0(PbFragment pbFragment) {
            this.f53215e = pbFragment;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (s0.this.u1 || this.f53215e == null || s0.this.f53178c.z() == null || !s0.this.f53178c.z().Y0()) {
                return;
            }
            s0.this.u1 = true;
            this.f53215e.S3(false);
        }
    }

    /* loaded from: classes5.dex */
    public class j implements View.OnClickListener {
        public j() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            s0.this.f2();
        }
    }

    /* loaded from: classes5.dex */
    public class j0 implements a.b {
        public j0() {
        }

        @Override // d.a.k0.d2.i.a.b
        public void a() {
            s0.this.f53178c.T4();
        }

        @Override // d.a.k0.d2.i.a.b
        public void b() {
            if (s0.this.l != null) {
                if (s0.this.p != null) {
                    s0.this.p.u();
                }
                s0.this.l.setSelection(0);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class k implements d.a.j0.w.b {
        public k() {
        }

        @Override // d.a.j0.w.b
        public void onAction(d.a.j0.w.a aVar) {
            Object obj = aVar.f50770c;
            if (obj instanceof d.a.j0.s.c.v) {
                if (((d.a.j0.s.c.v) obj).e() == EmotionGroupType.BIG_EMOTION || ((d.a.j0.s.c.v) aVar.f50770c).e() == EmotionGroupType.USER_COLLECT) {
                    if (s0.this.p1 == null) {
                        s0.this.p1 = new PermissionJudgePolicy();
                    }
                    s0.this.p1.clearRequestPermissionList();
                    s0.this.p1.appendRequestPermission(s0.this.f53178c.getBaseFragmentActivity(), StorageUtils.EXTERNAL_STORAGE_PERMISSION);
                    if (s0.this.p1.startRequestPermission(s0.this.f53178c.getBaseFragmentActivity())) {
                        return;
                    }
                    s0.this.f53178c.G4().h((d.a.j0.s.c.v) aVar.f50770c);
                    s0.this.f53178c.G4().z(false, null);
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
            if (DialogLoginHelper.checkUpIsLogin(new d.a.j0.r.q.r0(s0.this.f53178c.getActivity(), "pb_huitie"))) {
                s0.this.f53178c.v5();
                if (s0.this.f53178c == null || s0.this.f53178c.z() == null || s0.this.f53178c.z().y0() == null || s0.this.f53178c.z().y0().L() == null || s0.this.f53178c.z().y0().L().T() == null) {
                    return;
                }
                TiebaStatic.log(new StatisticItem("c13701").param("tid", s0.this.f53178c.z().P0()).param("fid", s0.this.f53178c.z().y0().m()).param("uid", TbadkCoreApplication.getCurrentAccountId()));
                TiebaStatic.log(new StatisticItem("c13402").param("tid", s0.this.f53178c.z().f19179e).param("fid", s0.this.f53178c.z().y0().m()).param("obj_locate", 1).param("uid", s0.this.f53178c.z().y0().L().T().getUserId()));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class l implements TextWatcher {
        public l() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (s0.this.f53178c.y0 == null || s0.this.f53178c.y0.e() == null) {
                return;
            }
            if (!s0.this.f53178c.y0.e().e()) {
                s0.this.f53178c.y0.a(false);
            }
            s0.this.f53178c.y0.e().l(false);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            int i5;
            if (s0.this.g0 != null && s0.this.g0.getVisibility() == 0 && charSequence != null && charSequence.length() >= (i5 = i4 + i2)) {
                String substring = charSequence.toString().substring(i2, i5);
                if (TextUtils.isEmpty(substring)) {
                    return;
                }
                if (s0.this.g1 == null) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.addRule(11);
                    layoutParams.addRule(2, s0.this.g0.getId());
                    s0 s0Var = s0.this;
                    s0Var.g1 = new d.a.k0.d2.k.e.a1.c(s0Var.f53178c.getPageContext(), s0.this.f53179d, layoutParams);
                    if (!ListUtils.isEmpty(s0.this.f1)) {
                        s0.this.g1.q(s0.this.f1);
                    }
                    s0.this.g1.r(s0.this.g0);
                }
                s0.this.g1.p(substring);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class l0 {

        /* renamed from: a  reason: collision with root package name */
        public int f53222a;

        /* renamed from: b  reason: collision with root package name */
        public int f53223b;

        /* renamed from: c  reason: collision with root package name */
        public PbReplyTitleViewHolder f53224c;
    }

    /* loaded from: classes5.dex */
    public class m implements l.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f53225e;

        public m(boolean z) {
            this.f53225e = z;
        }

        @Override // d.a.j0.r.s.l.e
        public void onItemClick(d.a.j0.r.s.l lVar, int i2, View view) {
            s0.this.M.dismiss();
            SparseArray<Object> sparseArray = (SparseArray) view.getTag();
            if (sparseArray == null) {
                return;
            }
            switch (i2) {
                case 10:
                    s0.this.P1(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                    return;
                case 11:
                    if (s0.this.K1 != null) {
                        s0.this.K1.a(new Object[]{sparseArray.get(R.id.tag_manage_user_identity), sparseArray.get(R.id.tag_forbid_user_name), sparseArray.get(R.id.tag_forbid_user_post_id), sparseArray.get(R.id.tag_forbid_user_name_show), sparseArray.get(R.id.tag_forbid_user_portrait)});
                        return;
                    }
                    return;
                case 12:
                    s0.this.f53178c.Q4(this.f53225e, (String) sparseArray.get(R.id.tag_user_mute_mute_userid), sparseArray);
                    return;
                default:
                    return;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class n implements a.e {
        public n(s0 s0Var) {
        }

        @Override // d.a.j0.r.s.a.e
        public void onClick(d.a.j0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    /* loaded from: classes5.dex */
    public class o implements f.g {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.j0.r.s.a f53227a;

        public o(d.a.j0.r.s.a aVar) {
            this.f53227a = aVar;
        }

        @Override // d.a.k0.h.f.g
        public void a(JSONArray jSONArray) {
            s0.this.f53178c.e4(this.f53227a, jSONArray);
        }
    }

    /* loaded from: classes5.dex */
    public class p implements i.h {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.j0.r.s.a f53229a;

        public p(d.a.j0.r.s.a aVar) {
            this.f53229a = aVar;
        }

        @Override // d.a.k0.h.i.h
        public void a(JSONArray jSONArray) {
            s0.this.f53178c.e4(this.f53229a, jSONArray);
        }
    }

    /* loaded from: classes5.dex */
    public class q implements CompoundButton.OnCheckedChangeListener {
        public q() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (z) {
                s0.this.W = (String) compoundButton.getTag();
                if (s0.this.n != null) {
                    for (CustomBlueCheckRadioButton customBlueCheckRadioButton : s0.this.n) {
                        String str = (String) customBlueCheckRadioButton.getTag();
                        if (str != null && s0.this.W != null && !str.equals(s0.this.W)) {
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
            if (s0.this.Q instanceof Dialog) {
                d.a.c.e.m.g.b(s0.this.Q, s0.this.f53178c.getPageContext());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class s implements l.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.c f53233e;

        public s(b.c cVar) {
            this.f53233e = cVar;
        }

        @Override // d.a.j0.r.s.l.e
        public void onItemClick(d.a.j0.r.s.l lVar, int i2, View view) {
            s0.this.Y.dismiss();
            this.f53233e.a(null, i2, view);
        }
    }

    /* loaded from: classes5.dex */
    public static class t implements a.f {
        @Override // d.a.k0.d3.g0.a.f
        public void onRefresh() {
        }
    }

    /* loaded from: classes5.dex */
    public class u implements l.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.c f53235e;

        public u(b.c cVar) {
            this.f53235e = cVar;
        }

        @Override // d.a.j0.r.s.l.e
        public void onItemClick(d.a.j0.r.s.l lVar, int i2, View view) {
            s0.this.Y.dismiss();
            this.f53235e.a(null, i2, view);
        }
    }

    /* loaded from: classes5.dex */
    public class v implements View.OnClickListener {
        public v() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!(view instanceof HeadImageView) || s0.this.z0 == null || s0.this.z0.L() == null || s0.this.z0.L().T() == null || s0.this.z0.L().T().getAlaInfo() == null || s0.this.z0.L().T().getAlaInfo().live_status != 1) {
                if (s0.this.Y0) {
                    TiebaStatic.log(new StatisticItem("c11923").param("obj_id", 2));
                }
                if (!s0.this.Y0 && s0.this.z0 != null && s0.this.z0.L() != null && s0.this.z0.L().T() != null && s0.this.z0.L().T().isBigV()) {
                    TiebaStatic.log(new StatisticItem("c12151").param("obj_locate", 1));
                }
                if (s0.this.f53178c.A() != null) {
                    s0.this.f53178c.A().mEvent.f52937b.onClick(view);
                    return;
                }
                return;
            }
            StatisticItem statisticItem = new StatisticItem("c11851");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(statisticItem);
            StatisticItem statisticItem2 = new StatisticItem("c13715");
            statisticItem2.param("fid", s0.this.z0.m());
            statisticItem2.param("fname", s0.this.z0.n());
            statisticItem2.param("obj_param1", s0.this.z0.L().T().getAlaInfo().user_info != null ? s0.this.z0.L().T().getAlaInfo().user_info.user_id : 0L);
            statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem2.param("tid", s0.this.z0.N());
            statisticItem2.param(TiebaStatic.Params.OBJ_PARAM2, 1);
            statisticItem2.param(TiebaStatic.Params.OBJ_PARAM4, YYLiveUtil.calculateLiveType(s0.this.z0.L().T().getAlaInfo()));
            if (s0.this.z0.L().T().getAlaInfo().mYyExtData != null) {
                statisticItem2.param(TiebaStatic.Params.OBJ_PARAM3, TiebaStatic.YYValues.YY_LIVE);
                TiebaStaticHelper.addYYParam(statisticItem2, s0.this.z0.L().T().getAlaInfo().mYyExtData);
            }
            TiebaStatic.log(statisticItem2);
            if (s0.this.z0.L().T().getAlaInfo().isLegalYYLiveData()) {
                YYLiveUtil.jumpYYLiveRoom(s0.this.f53178c.getPageContext(), s0.this.z0.L().T().getAlaInfo());
            } else if (s0.this.z0.L().T().getAlaInfo() == null || !s0.this.z0.L().T().getAlaInfo().isChushou) {
                if (s0.this.z0.L().T().getAlaInfo().live_id > 0) {
                    AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                    alaLiveInfoCoreData.liveID = s0.this.z0.L().T().getAlaInfo().live_id;
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(s0.this.f53178c.A(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_PB_USER_ICON_LIVE, null, false, "")));
                }
            } else {
                UrlManager urlManager = UrlManager.getInstance();
                TbPageContext<BaseFragmentActivity> pageContext = s0.this.f53178c.getPageContext();
                urlManager.dealOneLink(pageContext, new String[]{"tiebachushou://liveroom?roomid=" + s0.this.z0.L().T().getAlaInfo().thirdRoomId + "&livetype=" + s0.this.z0.L().T().getAlaInfo().thirdLiveType});
            }
        }
    }

    /* loaded from: classes5.dex */
    public class w implements Runnable {
        public w() {
        }

        @Override // java.lang.Runnable
        public void run() {
            s0 s0Var;
            d.a.k0.d2.k.e.e1.c cVar;
            LinearLayout linearLayout;
            if (s0.this.z == null || (cVar = (s0Var = s0.this).f53183h) == null || cVar.f53066i == null || s0Var.z0 == null || s0.this.z0.L() == null || s0.this.z0.L().B2() || s0.this.v1() || s0.this.z0.l() == null || d.a.c.e.p.k.isEmpty(s0.this.z0.l().getName())) {
                return;
            }
            if ((s0.this.z.G() == null || !s0.this.z.G().isShown()) && (linearLayout = s0.this.f53183h.f53066i) != null) {
                linearLayout.setVisibility(0);
                if (s0.this.f53178c == null || s0.this.f53178c.z() == null) {
                    return;
                }
                StatisticItem statisticItem = new StatisticItem("c13400");
                statisticItem.param("tid", s0.this.f53178c.z().O0());
                statisticItem.param("fid", s0.this.f53178c.z().getForumId());
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class x implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f53239e;

        public x(String str) {
            this.f53239e = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d.a.c.e.p.l.D()) {
                UrlManager.getInstance().dealOneLink(s0.this.f53178c.getPageContext(), new String[]{this.f53239e});
                s0.this.f53178c.finish();
                return;
            }
            s0.this.f53178c.showToast(R.string.neterror);
        }
    }

    /* loaded from: classes5.dex */
    public class y implements PbLandscapeListView.c {
        public y() {
        }

        @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.c
        public void a(int i2, int i3, float f2, float f3, float f4, float f5) {
            if (s0.this.f53178c == null || !s0.this.f53178c.isAdded()) {
                return;
            }
            if (i2 < 0 && f2 > s0.this.b1) {
                s0.this.Z();
                s0.this.I1();
            }
            s0.this.g0();
        }
    }

    /* loaded from: classes5.dex */
    public class z implements a.e {
        public z() {
        }

        @Override // d.a.j0.r.s.a.e
        public void onClick(d.a.j0.r.s.a aVar) {
            s0.this.Z();
            aVar.dismiss();
        }
    }

    public s0(PbFragment pbFragment, View.OnClickListener onClickListener, d.a.k0.d2.i.c cVar) {
        this.f53178c = null;
        this.f53179d = null;
        this.f53180e = null;
        this.l = null;
        this.z = null;
        this.F = null;
        this.H = null;
        this.J = null;
        this.N = null;
        this.l0 = null;
        this.o0 = null;
        this.E0 = null;
        this.b1 = 0;
        this.q1 = 0L;
        this.q1 = System.currentTimeMillis();
        this.f53178c = pbFragment;
        this.J = onClickListener;
        this.e0 = cVar;
        this.b1 = d.a.c.e.p.l.k(pbFragment.getContext()) / 8;
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.f53178c.getPageContext().getPageActivity()).inflate(R.layout.new_pb_activity, (ViewGroup) null);
        this.f53179d = relativeLayout;
        relativeLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.i0 = this.f53179d.findViewById(R.id.bottom_shadow);
        this.l1 = (NavigationBarCoverTip) this.f53179d.findViewById(R.id.pb_multi_forum_del_tip_view);
        this.f53180e = this.f53179d.findViewById(R.id.statebar_view);
        this.B1 = (RightFloatLayerView) this.f53179d.findViewById(R.id.right_layer_view);
        this.f53178c.registerListener(this.C1);
        i1();
        this.y = (ObservedChangeRelativeLayout) this.f53179d.findViewById(R.id.title_wrapper);
        this.m = (NoNetworkView) this.f53179d.findViewById(R.id.view_no_network);
        this.l = (PbLandscapeListView) this.f53179d.findViewById(R.id.new_pb_list);
        this.G0 = (FrameLayout) this.f53179d.findViewById(R.id.root_float_header);
        this.H0 = new TextView(this.f53178c.getActivity());
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + d.a.c.e.p.l.g(this.f53178c.getActivity(), R.dimen.ds88));
        this.l.x(this.H0, 0);
        this.l.setTextViewAdded(true);
        this.R0 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds134);
        View view = new View(this.f53178c.getPageContext().getPageActivity());
        this.L0 = view;
        view.setLayoutParams(new AbsListView.LayoutParams(-1, this.R0));
        this.L0.setVisibility(4);
        this.l.addFooterView(this.L0);
        this.l.setOnTouchListener(this.f53178c.s2);
        this.f53176a = new i0(pbFragment);
        this.l.getViewTreeObserver().addOnGlobalLayoutListener(this.f53176a);
        this.f53183h = new d.a.k0.d2.k.e.e1.c(pbFragment, this.f53179d);
        if (this.f53178c.y4()) {
            ViewStub viewStub = (ViewStub) this.f53179d.findViewById(R.id.manga_view_stub);
            this.j = viewStub;
            viewStub.setVisibility(0);
            d.a.k0.d2.k.e.e1.b bVar = new d.a.k0.d2.k.e.e1.b(pbFragment);
            this.f53184i = bVar;
            bVar.c();
            this.f53183h.f53058a.setVisibility(8);
            layoutParams.height = d.a.c.e.p.l.g(this.f53178c.getActivity(), R.dimen.ds120);
        }
        this.H0.setLayoutParams(layoutParams);
        this.f53183h.i().setOnTouchListener(new d.a.k0.d2.i.a(new j0()));
        this.k0 = this.f53179d.findViewById(R.id.view_comment_top_line);
        this.l0 = this.f53179d.findViewById(R.id.pb_editor_tool_comment);
        d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds120);
        this.w0 = d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.ds242);
        HeadImageView headImageView = (HeadImageView) this.f53179d.findViewById(R.id.pb_editor_tool_comment_user_image);
        this.n0 = headImageView;
        headImageView.setVisibility(0);
        this.n0.setIsRound(true);
        this.n0.setBorderWidth(d.a.c.e.p.l.g(this.f53178c.getContext(), R.dimen.L_X01));
        this.n0.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
        this.n0.setPlaceHolder(0);
        C1();
        this.o0 = (TextView) this.f53179d.findViewById(R.id.pb_editor_tool_comment_reply_text);
        LinearLayout linearLayout = (LinearLayout) this.f53179d.findViewById(R.id.pb_editer_tool_comment_layout);
        this.m0 = linearLayout;
        linearLayout.setOnClickListener(new k0());
        this.p0 = (ImageView) this.f53179d.findViewById(R.id.pb_editor_tool_comment_icon);
        this.w1 = (MaskView) this.f53179d.findViewById(R.id.mask_view);
        this.p0.setOnClickListener(this.J);
        boolean booleanExtra = this.f53178c.getBaseFragmentActivity().getIntent().getBooleanExtra("key_is_from_dynamic", false);
        ImageView imageView = (ImageView) this.f53179d.findViewById(R.id.pb_editor_tool_collection);
        this.q0 = imageView;
        imageView.setOnClickListener(this.J);
        if (booleanExtra) {
            this.q0.setVisibility(8);
        } else {
            this.q0.setVisibility(0);
        }
        ImageView imageView2 = (ImageView) this.f53179d.findViewById(R.id.pb_editor_tool_share);
        this.r0 = imageView2;
        imageView2.setOnClickListener(this.J);
        d.a.k0.d2.p.h hVar = new d.a.k0.d2.p.h(this.r0);
        this.s0 = hVar;
        hVar.d();
        TextView textView = (TextView) this.f53179d.findViewById(R.id.pb_editor_tool_comment_red_dot);
        this.t0 = textView;
        textView.setVisibility(0);
        this.E0 = (ViewStub) this.f53179d.findViewById(R.id.interview_status_stub);
        this.q = new d.a.k0.d2.k.e.z0.a(this.f53178c, cVar);
        this.s = new d.a.k0.d2.k.e.z0.e(this.f53178c, cVar, this.J);
        d.a.k0.d2.k.e.i iVar = new d.a.k0.d2.k.e.i(this.f53178c, this.l);
        this.z = iVar;
        iVar.n0(this.J);
        this.z.o0(this.e0);
        this.z.k0(this.K);
        this.z.m0(this.f53178c.T1);
        b bVar2 = new b();
        this.N = bVar2;
        this.z.j0(bVar2);
        j1();
        e1();
        d.a.k0.d2.k.e.z0.d dVar = new d.a.k0.d2.k.e.z0.d(this.f53178c);
        this.u = dVar;
        dVar.f53346f = 2;
        this.r.a(this.l);
        this.s.g(this.l);
        this.q.a(this.l);
        PbListView pbListView = new PbListView(this.f53178c.getPageContext().getPageActivity());
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
        this.I = this.f53179d.findViewById(R.id.viewstub_progress);
        this.f53178c.registerListener(this.J1);
        this.T0 = new PbFakeFloorModel(this.f53178c.getPageContext());
        d.a.k0.d2.k.e.u uVar = new d.a.k0.d2.k.e.u(this.f53178c.getPageContext(), this.T0, this.f53179d);
        this.U0 = uVar;
        uVar.k(new c());
        this.U0.m(this.f53178c.X1);
        this.T0.D(new d());
        if (this.f53178c.z() != null && !StringUtils.isNull(this.f53178c.z().B0())) {
            PbFragment pbFragment2 = this.f53178c;
            pbFragment2.showToast(pbFragment2.z().B0());
        }
        this.I0 = this.f53179d.findViewById(R.id.pb_expand_blank_view);
        View findViewById2 = this.f53179d.findViewById(R.id.sticky_view);
        this.J0 = findViewById2;
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) findViewById2.getLayoutParams();
        if (this.f53178c.z() != null && this.f53178c.z().l0()) {
            this.I0.setVisibility(0);
            if (layoutParams2 != null) {
                layoutParams2.height = 0;
                this.J0.setLayoutParams(layoutParams2);
            }
        } else if (layoutParams2 != null) {
            layoutParams2.height = U1;
            this.J0.setLayoutParams(layoutParams2);
        }
        PbReplyTitleViewHolder pbReplyTitleViewHolder = new PbReplyTitleViewHolder(this.f53178c.getPageContext(), this.f53179d.findViewById(R.id.pb_reply_expand_view));
        this.K0 = pbReplyTitleViewHolder;
        pbReplyTitleViewHolder.q(pbFragment.g0);
        this.K0.f19220g.setVisibility(8);
        this.K0.p(this.J);
        this.K0.o(this.f53178c.T1);
        this.f53178c.registerListener(this.G1);
        this.f53178c.registerListener(this.E1);
        PbFragment pbFragment3 = this.f53178c;
        this.v1 = new d.a.k0.d2.p.g(pbFragment3, pbFragment3.getUniqueId());
        this.x1 = (FallingView) this.f53179d.findViewById(R.id.falling_view);
        TbImageView tbImageView = (TbImageView) this.f53179d.findViewById(R.id.falling_ad_view);
        this.y1 = tbImageView;
        tbImageView.setPlaceHolder(2);
        U();
        e2(false);
    }

    public static /* synthetic */ float A1(Random random) {
        return (random.nextInt(2) * 0.1f) + 0.8f;
    }

    public BdTypeListView A0() {
        return this.l;
    }

    public void A2(BdListView.p pVar) {
        this.l.setOnSrollToBottomListener(pVar);
    }

    public void A3(d.a.k0.d2.h.e eVar) {
        d.a.k0.d2.k.e.z0.a aVar = this.q;
        if (aVar != null) {
            aVar.h(eVar, this.y0);
        }
    }

    public SparseArray<Object> B0(d.a.k0.d2.h.e eVar, boolean z2, int i2) {
        PostData s0;
        d.a.j0.r.q.d0 d0Var;
        int i3;
        StringBuilder sb = null;
        if (eVar == null || (s0 = s0(eVar, z2)) == null) {
            return null;
        }
        String userId = s0.t().getUserId();
        boolean z3 = userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount());
        SparseArray<Object> sparseArray = new SparseArray<>();
        if (i2 == 0) {
            sparseArray.put(R.id.tag_del_post_id, s0.E());
            sparseArray.put(R.id.tag_del_post_type, 0);
            sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z3));
            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(eVar.S()));
            sparseArray.put(R.id.tag_should_manage_visible, Boolean.FALSE);
        } else if (i2 == 1) {
            if (s0.t() != null) {
                sparseArray.put(R.id.tag_forbid_user_name, s0.t().getUserName());
                sparseArray.put(R.id.tag_forbid_user_name_show, s0.t().getName_show());
                sparseArray.put(R.id.tag_forbid_user_portrait, s0.t().getPortrait());
                sparseArray.put(R.id.tag_forbid_user_post_id, s0.E());
            }
            sparseArray.put(R.id.tag_del_post_id, s0.E());
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
                    if (w1Var != null && !StringUtils.isNull(w1Var.g()) && (d0Var = w1Var.f50119g) != null && d0Var.f49944a && !d0Var.f49946c && ((i3 = d0Var.f49945b) == 1 || i3 == 2)) {
                        sb.append(d.a.c.e.p.k.cutString(w1Var.g(), 12));
                        sb.append(this.f53178c.getString(R.string.forum));
                        sb.append("、");
                    }
                }
            }
            if (sb != null && !StringUtils.isNull(sb.toString())) {
                sparseArray.put(R.id.tag_del_multi_forum, String.format(this.f53178c.getString(R.string.del_multi_forum_default_txt), sb.toString().substring(0, sb.length() - 1)));
            }
        }
        return sparseArray;
    }

    public /* synthetic */ void B1(d.a.j0.t.a aVar, int i2, View view) {
        UrlManager urlManager = UrlManager.getInstance();
        TbPageContext<BaseFragmentActivity> pageContext = this.f53178c.getPageContext();
        urlManager.dealOneLink(pageContext, new String[]{"http://tieba.baidu.com/mo/q/checkurl?url=" + d.a.c.e.p.k.getUrlEncode(aVar.d())});
        TiebaStatic.log(new StatisticItem("c14126").param("obj_type", i2).param("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    public void B2(AbsListView.OnScrollListener onScrollListener) {
        this.l.setOnScrollListener(onScrollListener);
    }

    public d.a.k0.d2.k.d.a C0() {
        return this.h1;
    }

    public final void C1() {
        if (this.n0 != null && TbadkCoreApplication.getCurrentAccountInfo() != null) {
            this.n0.setImageResource(0);
            this.n0.V(TbadkCoreApplication.getCurrentAccountInfo().getAvatar(), 12, false);
            return;
        }
        this.n0.setImageResource(R.drawable.transparent_bg);
    }

    public void C2(int i2) {
        this.s1 = i2;
    }

    public final int D0(boolean z2) {
        PbInterviewStatusView pbInterviewStatusView = this.F0;
        if (pbInterviewStatusView != null && pbInterviewStatusView.getVisibility() == 0 && z2) {
            return 0 + d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.ds72);
        }
        return 0;
    }

    public void D1(int i2) {
        if (this.C0 == i2) {
            return;
        }
        this.C0 = i2;
        o3(this.z0, this.y0);
        Z1(this.z0, this.y0, this.B0, i2);
        this.f53178c.getBaseFragmentActivity().getLayoutMode().k(i2 == 1);
        this.f53178c.getBaseFragmentActivity().getLayoutMode().j(this.f53179d);
        SkinManager.setBackgroundColor(this.f53179d, R.color.CAM_X0201);
        SkinManager.setBackgroundColor(this.i0, R.color.CAM_X0203);
        d.a.k0.d2.k.e.z0.f fVar = this.p;
        if (fVar != null) {
            fVar.h(i2);
        }
        d.a.k0.d2.k.e.z0.b bVar = this.t;
        if (bVar != null) {
            bVar.c(i2);
        }
        d.a.k0.d2.k.e.z0.a aVar = this.q;
        if (aVar != null) {
            aVar.e(i2);
        }
        d.a.k0.d2.k.e.z0.c cVar = this.r;
        if (cVar != null) {
            cVar.c(i2);
        }
        d.a.k0.d2.k.e.z0.e eVar = this.s;
        if (eVar != null) {
            eVar.p(i2);
        }
        d.a.k0.d2.k.e.z0.d dVar = this.u;
        if (dVar != null) {
            dVar.d();
        }
        MaskView maskView = this.w1;
        if (maskView != null) {
            maskView.c();
        }
        PbListView pbListView = this.F;
        if (pbListView != null) {
            pbListView.d(i2);
        }
        if (this.H != null) {
            this.f53178c.getBaseFragmentActivity().getLayoutMode().j(this.H);
            SkinManager.setBackgroundResource(this.H, R.drawable.pb_foot_more_trans_selector);
        }
        d.a.j0.r.s.a aVar2 = this.A;
        if (aVar2 != null) {
            aVar2.autoChangeSkinType(this.f53178c.getPageContext());
        }
        u3(this.a0);
        this.z.U();
        d.a.k0.d2.p.i iVar = this.E;
        if (iVar != null) {
            iVar.I(i2);
        }
        EditorTools editorTools = this.g0;
        if (editorTools != null) {
            editorTools.w(i2);
        }
        d.a.k0.d2.p.e eVar2 = this.G;
        if (eVar2 != null) {
            eVar2.f(i2);
        }
        if (!ListUtils.isEmpty(this.n)) {
            for (CustomBlueCheckRadioButton customBlueCheckRadioButton : this.n) {
                customBlueCheckRadioButton.c();
            }
        }
        z3();
        UtilHelper.setStatusBarBackground(this.f53180e, i2);
        UtilHelper.setStatusBarBackground(this.J0, i2);
        if (this.v != null) {
            d.a.j0.s0.a.a(this.f53178c.getPageContext(), this.v);
        }
        d.a.k0.d2.k.e.u uVar = this.U0;
        if (uVar != null) {
            uVar.h(i2);
        }
        d.a.k0.d2.k.e.e1.c cVar2 = this.f53183h;
        if (cVar2 != null) {
            d.a.k0.d2.k.e.z0.f fVar2 = this.p;
            if (fVar2 != null) {
                fVar2.i(i2);
            } else {
                cVar2.m(i2);
            }
        }
        HeadImageView headImageView = this.n0;
        if (headImageView != null) {
            headImageView.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
        }
        LinearLayout linearLayout = this.m0;
        if (linearLayout != null) {
            linearLayout.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(d.a.c.e.p.l.g(this.f53178c.getContext(), R.dimen.tbds47), SkinManager.getColor(R.color.CAM_X0209)));
        }
        d.a.k0.d2.h.e eVar3 = this.z0;
        if (eVar3 != null && eVar3.r()) {
            WebPManager.setPureDrawable(this.q0, R.drawable.icon_pure_pb_bottom_collected26_selection, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
        } else {
            WebPManager.setPureDrawable(this.q0, R.drawable.icon_pure_pb_bottom_collect26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        }
        WebPManager.setPureDrawable(this.p0, R.drawable.icon_pure_pb_bottom_comment26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        x3(this.z0);
        SkinManager.setBackgroundColor(this.l0, R.color.CAM_X0207);
        SkinManager.setBackgroundColor(this.k0, R.color.CAM_X0203);
        SkinManager.setViewTextColor(this.e1, R.color.cp_cont_n);
        SkinManager.setViewTextColor(this.o0, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.u0, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.t0, R.color.CAM_X0107);
        TextView textView = this.t0;
        int g2 = d.a.c.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18);
        int i3 = R.color.CAM_X0207;
        SkinManager.setBackgroundShapeDrawable(textView, g2, i3, i3);
        d.a.k0.d2.k.d.a aVar3 = this.h1;
        if (aVar3 != null) {
            aVar3.m(i2);
        }
        PbEmotionBar pbEmotionBar = this.P0;
        if (pbEmotionBar != null) {
            pbEmotionBar.w();
        }
        PbThreadPostView pbThreadPostView = this.o;
        if (pbThreadPostView != null) {
            pbThreadPostView.c(i2);
        }
        d.a.k0.d2.p.h hVar = this.s0;
        if (hVar != null) {
            hVar.f();
        }
        d.a.k0.d2.p.g gVar = this.v1;
        if (gVar != null) {
            gVar.c();
        }
        RightFloatLayerView rightFloatLayerView = this.B1;
        if (rightFloatLayerView != null) {
            rightFloatLayerView.o();
        }
    }

    public void D2(View.OnLongClickListener onLongClickListener) {
        this.s.t(onLongClickListener);
        this.z.l0(onLongClickListener);
        d.a.k0.d2.k.d.a aVar = this.h1;
        if (aVar != null) {
            aVar.r(onLongClickListener);
        }
    }

    public View E0() {
        return this.H;
    }

    public void E1(Configuration configuration) {
        if (configuration == null) {
            return;
        }
        Z();
        if (configuration.orientation == 2) {
            V0();
            X0();
        } else {
            f2();
        }
        d.a.k0.d2.k.e.u uVar = this.U0;
        if (uVar != null) {
            uVar.c();
        }
        this.f53178c.T4();
        this.y.setVisibility(8);
        this.f53183h.t(false);
        this.f53178c.J5(false);
        if (this.p != null) {
            if (configuration.orientation == 1) {
                S0().setVisibility(0);
            }
            if (configuration.orientation == 2) {
                this.T1 = true;
                this.l.setIsLandscape(true);
                this.l.smoothScrollToPosition(0);
            } else {
                this.T1 = false;
                this.l.setIsLandscape(false);
                int i2 = this.R1;
                if (i2 > 0) {
                    this.l.smoothScrollBy(i2, 0);
                }
            }
            this.p.j(configuration);
            this.G0.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        }
    }

    public final void E2(PostData postData, d.a.k0.d2.h.e eVar) {
        this.s.u(postData, eVar);
    }

    public int F0() {
        try {
            return Integer.parseInt(this.D.getText().toString(), 10);
        } catch (Exception unused) {
            return -1;
        }
    }

    public void F1() {
        NoNetworkView.b bVar;
        RelativeLayout relativeLayout = this.f53179d;
        if (relativeLayout != null && relativeLayout.getHandler() != null) {
            this.f53179d.getHandler().removeCallbacksAndMessages(null);
        }
        d.a.k0.d2.p.h hVar = this.s0;
        if (hVar != null) {
            hVar.g();
        }
        o0 o0Var = this.V0;
        if (o0Var != null) {
            o0Var.a();
        }
        d.a.k0.d2.k.e.h0 h0Var = this.k1;
        if (h0Var != null) {
            h0Var.c();
        }
        PbTopTipView pbTopTipView = this.c1;
        if (pbTopTipView != null) {
            pbTopTipView.g();
        }
        this.f53178c.hideProgressBar();
        NoNetworkView noNetworkView = this.m;
        if (noNetworkView != null && (bVar = this.L) != null) {
            noNetworkView.d(bVar);
        }
        Z();
        f0();
        if (this.S0 != null) {
            d.a.c.e.m.e.a().removeCallbacks(this.S0);
        }
        PbInterviewStatusView pbInterviewStatusView = this.F0;
        if (pbInterviewStatusView != null) {
            pbInterviewStatusView.m();
        }
        this.H1 = null;
        this.f53182g.removeCallbacksAndMessages(null);
        this.z.V(3);
        View view = this.f53180e;
        if (view != null) {
            view.setBackgroundDrawable(null);
        }
        d.a.k0.d2.k.e.z0.f fVar = this.p;
        if (fVar != null) {
            fVar.a();
        }
        d.a.k0.d2.k.e.i iVar = this.z;
        if (iVar != null) {
            iVar.W();
        }
        this.l.setOnLayoutListener(null);
        d.a.k0.d2.k.e.a1.c cVar = this.g1;
        if (cVar != null) {
            cVar.l();
        }
        PbEmotionBar pbEmotionBar = this.P0;
        if (pbEmotionBar != null) {
            pbEmotionBar.x();
        }
        d.a.k0.d2.k.e.z0.e eVar = this.s;
        if (eVar != null) {
            eVar.q();
        }
        PbLandscapeListView pbLandscapeListView = this.l;
        if (pbLandscapeListView != null) {
            pbLandscapeListView.getViewTreeObserver().removeGlobalOnLayoutListener(this.f53176a);
        }
    }

    public void F2(boolean z2, PostWriteCallBackData postWriteCallBackData) {
        this.f53178c.hideProgressBar();
        if (z2) {
            Z();
        } else if (postWriteCallBackData != null && (postWriteCallBackData.isSensitiveError() || postWriteCallBackData.isErrorLinkCountExceedLimit() || postWriteCallBackData.isErrorShowApplyMemberDialog())) {
            a0();
        } else {
            Z();
        }
    }

    public View G0() {
        return this.I0;
    }

    public void G1(TbRichText tbRichText) {
        PostData postData;
        d.a.k0.d2.h.e eVar = this.z0;
        if (eVar == null || eVar.D() == null || this.z0.D().isEmpty() || tbRichText == null || StringUtils.isNull(tbRichText.getAuthorId())) {
            return;
        }
        for (int i2 = 0; i2 < this.z0.D().size() && (postData = this.z0.D().get(i2)) != null && postData.t() != null && !StringUtils.isNull(postData.t().getUserId()); i2++) {
            if (this.z0.D().get(i2).t().getUserId().equals(tbRichText.getAuthorId())) {
                d.a.k0.d2.k.d.a aVar = this.h1;
                if (aVar != null && aVar.l()) {
                    T2(false);
                }
                PbEmotionBar pbEmotionBar = this.P0;
                if (pbEmotionBar != null) {
                    pbEmotionBar.q(true);
                }
                postData.t().getName_show();
                return;
            }
        }
    }

    public void G2() {
        this.f53178c.hideProgressBar();
        f0();
        this.l.A(0L);
        c0();
    }

    public PbFakeFloorModel H0() {
        return this.T0;
    }

    public boolean H1(int i2) {
        d.a.k0.d2.k.e.z0.f fVar = this.p;
        if (fVar != null) {
            return fVar.k(i2);
        }
        return false;
    }

    public void H2() {
        PbFragment pbFragment = this.f53178c;
        if (pbFragment == null || pbFragment.getBaseFragmentActivity() == null) {
            return;
        }
        d.a.c.e.p.l.x(this.f53178c.getPageContext().getPageActivity(), this.f53178c.getBaseFragmentActivity().getCurrentFocus());
    }

    public d.a.k0.d2.k.e.u I0() {
        return this.U0;
    }

    public void I1() {
        PostData postData;
        if (this.f53178c == null) {
            return;
        }
        if ((this.r1 || this.s1 == 17) && d.a.j0.b.d.R()) {
            d.a.k0.d2.h.e eVar = this.z0;
            if (eVar == null || eVar.l() == null || d.a.c.e.p.k.isEmpty(this.z0.l().getName())) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f53178c.getContext()).createNormalCfg(this.z0.l().getName(), null)));
            TiebaStatic.log(new StatisticItem("c13853").param("post_id", this.z0.N()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("fid", this.z0.l().getId()));
        } else if (!this.Z0 || this.Y0 || (postData = this.A0) == null || postData.t() == null) {
        } else {
            TiebaStatic.log(new StatisticItem("c12601").param("obj_locate", this.f53178c.isSimpleForum() ? 2 : 1).param("obj_type", this.Y0 ? 2 : 1));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.f53178c.getPageContext().getPageActivity(), this.A0.t().getUserId(), this.A0.t().getUserName(), this.f53178c.z().a0(), AddFriendActivityConfig.TYPE_PB_HEAD)));
        }
    }

    public void I2() {
        this.F.x();
        this.F.O();
    }

    public d.a.k0.d2.k.e.z0.f J0() {
        return this.p;
    }

    public void J1(boolean z2) {
        if (z2) {
            Y2();
        } else {
            Y0();
        }
        this.O0.f53224c = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.O0));
        U1(this.O0.f53224c, false);
    }

    public void J2(boolean z2) {
        this.s.v(z2);
    }

    public final PostData K0(d.a.k0.d2.h.e eVar) {
        MetaData metaData;
        if (eVar == null || eVar.L() == null || eVar.L().T() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData T = eVar.L().T();
        String userId = T.getUserId();
        HashMap<String, MetaData> F1 = eVar.L().F1();
        if (F1 != null && (metaData = F1.get(userId)) != null && metaData.getUserId() != null) {
            T = metaData;
        }
        postData.i0(1);
        postData.l0(eVar.L().f0());
        postData.x0(eVar.L().y1());
        postData.w0(eVar.L().Z());
        postData.g0(T);
        return postData;
    }

    public void K1() {
        t3();
        this.z.V(1);
        d.a.k0.d2.k.e.z0.f fVar = this.p;
        if (fVar != null) {
            fVar.l();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
    }

    public void K2(String str) {
        this.o0.performClick();
        if (StringUtils.isNull(str) || this.f53178c.G4() == null || this.f53178c.G4().v() == null || this.f53178c.G4().v().i() == null) {
            return;
        }
        EditText i2 = this.f53178c.G4().v().i();
        i2.setText(str);
        i2.setSelection(str.length());
    }

    public String L0() {
        if (!d.a.c.e.p.k.isEmpty(this.o1)) {
            return this.o1;
        }
        if (this.f53178c != null) {
            this.o1 = TbadkCoreApplication.getInst().getResources().getString(r0.b());
        }
        return this.o1;
    }

    public void L1() {
        this.z.V(2);
        d.a.k0.d2.k.e.z0.f fVar = this.p;
        if (fVar != null) {
            fVar.m();
            if (TbSingleton.getInstance().isNotchScreen(this.f53178c.getFragmentActivity()) || TbSingleton.getInstance().isCutoutScreen(this.f53178c.getFragmentActivity())) {
                return;
            }
            T0().setSystemUiVisibility(4);
        }
    }

    public void L2(int i2) {
        this.l.setSelection(i2);
    }

    public final int M0(PbReplyTitleViewHolder pbReplyTitleViewHolder) {
        if (pbReplyTitleViewHolder == null || pbReplyTitleViewHolder.a() == null) {
            return 0;
        }
        if (pbReplyTitleViewHolder.a().getTop() != 0 || pbReplyTitleViewHolder.a().isShown()) {
            return pbReplyTitleViewHolder.a().getBottom();
        }
        return 0;
    }

    public void M1(AbsListView absListView, int i2, int i3, int i4) {
        PbReplyTitleViewHolder pbReplyTitleViewHolder;
        d.a.k0.d2.k.e.z0.e eVar;
        d.a.k0.d2.k.e.z0.f fVar = this.p;
        if (fVar != null) {
            fVar.n(absListView, i2, i3, i4);
        }
        d.a.k0.d2.k.e.e1.c cVar = this.f53183h;
        if (cVar != null && (eVar = this.s) != null) {
            cVar.o(eVar.l());
        }
        l0 l0Var = this.O0;
        l0Var.f53222a = i2;
        l0Var.f53223b = this.l.getHeaderViewsCount();
        this.O0.f53224c = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.O0));
        S2(Q(absListView, i2));
        int i5 = 0;
        U1(this.O0.f53224c, false);
        Y();
        if (!this.F.m() || this.F.D) {
            return;
        }
        l0 l0Var2 = this.O0;
        if (l0Var2 != null && (pbReplyTitleViewHolder = l0Var2.f53224c) != null && pbReplyTitleViewHolder.a() != null) {
            i5 = this.O0.f53224c.a().getTop() < 0 ? this.O0.f53224c.a().getHeight() : this.O0.f53224c.a().getBottom();
        }
        this.F.e(i5);
        this.F.D = true;
    }

    public void M2(int i2, int i3) {
        this.l.setSelectionFromTop(i2, i3);
    }

    public int N0() {
        return R.id.richText;
    }

    public void N1(AbsListView absListView, int i2) {
        RightFloatLayerView rightFloatLayerView;
        d.a.k0.d2.k.e.z0.f fVar = this.p;
        if (fVar != null) {
            fVar.o(absListView, i2);
        }
        if (!this.T1 && i2 == 0) {
            this.R1 = O0();
            this.O0.f53224c = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.O0));
            U1(this.O0.f53224c, true);
            Y();
            this.z.Y(true);
        }
        if (i2 == 0) {
            RightFloatLayerView rightFloatLayerView2 = this.B1;
            if (rightFloatLayerView2 != null) {
                rightFloatLayerView2.q();
            }
        } else if (i2 == 1) {
            RightFloatLayerView rightFloatLayerView3 = this.B1;
            if (rightFloatLayerView3 != null) {
                rightFloatLayerView3.p();
            }
        } else if (i2 != 2 || (rightFloatLayerView = this.B1) == null) {
        } else {
            rightFloatLayerView.r();
        }
    }

    public void N2(int i2) {
        NavigationBar navigationBar;
        LinearLayout.LayoutParams layoutParams;
        if (this.l != null) {
            d.a.k0.d2.k.e.e1.c cVar = this.f53183h;
            int i3 = 0;
            if (cVar != null && (navigationBar = cVar.f53058a) != null) {
                int fixedNavHeight = navigationBar.getFixedNavHeight();
                if (!(this.f53178c.r4() != -1)) {
                    View view = this.J0;
                    if (view != null && (layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams()) != null) {
                        layoutParams.height = 0;
                        this.J0.setLayoutParams(layoutParams);
                    }
                    i2--;
                }
                i3 = fixedNavHeight;
            }
            this.l.setSelectionFromTop(i2, i3);
        }
    }

    public final int O0() {
        View childAt = this.l.getChildAt(0);
        if (childAt == null) {
            return 0;
        }
        return (-childAt.getTop()) + (this.l.getFirstVisiblePosition() * childAt.getHeight());
    }

    public void O1(ArrayList<d.a.j0.r.q.l0> arrayList) {
        if (this.R == null) {
            this.R = LayoutInflater.from(this.f53178c.getPageContext().getPageActivity()).inflate(R.layout.commit_good, (ViewGroup) null);
        }
        this.f53178c.getBaseFragmentActivity().getLayoutMode().j(this.R);
        if (this.Q == null) {
            Dialog dialog = new Dialog(this.f53178c.getPageContext().getPageActivity(), R.style.common_alert_dialog);
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
        CustomBlueCheckRadioButton V = V("0", this.f53178c.getPageContext().getString(R.string.thread_good_class));
        this.n.add(V);
        V.setChecked(true);
        this.S.addView(V);
        if (arrayList != null) {
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                d.a.j0.r.q.l0 l0Var = arrayList.get(i2);
                if (l0Var != null && !TextUtils.isEmpty(l0Var.b()) && l0Var.a() > 0) {
                    CustomBlueCheckRadioButton V2 = V(String.valueOf(l0Var.a()), l0Var.b());
                    this.n.add(V2);
                    View view = new View(this.f53178c.getPageContext().getPageActivity());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.ds1));
                    SkinManager.setBackgroundColor(view, R.color.CAM_X0204);
                    view.setLayoutParams(layoutParams);
                    this.S.addView(view);
                    this.S.addView(V2);
                }
            }
            ViewGroup.LayoutParams layoutParams2 = this.f0.getLayoutParams();
            int size = arrayList.size();
            if (size == 0 || size == 1) {
                layoutParams2.height = d.a.c.e.p.l.e(this.f53178c.getPageContext().getPageActivity(), 120.0f);
            } else if (size != 2) {
                layoutParams2.height = d.a.c.e.p.l.e(this.f53178c.getPageContext().getPageActivity(), 220.0f);
            } else {
                layoutParams2.height = d.a.c.e.p.l.e(this.f53178c.getPageContext().getPageActivity(), 186.0f);
            }
            this.f0.setLayoutParams(layoutParams2);
            this.f0.removeAllViews();
            LinearLayout linearLayout = this.S;
            if (linearLayout != null && linearLayout.getParent() == null) {
                this.f0.addView(this.S);
            }
        }
        d.a.c.e.m.g.j(this.Q, this.f53178c.getPageContext());
    }

    public void O2(List<String> list) {
        this.f1 = list;
        d.a.k0.d2.k.e.a1.c cVar = this.g1;
        if (cVar != null) {
            cVar.q(list);
        }
    }

    public int P0() {
        return this.C0;
    }

    public void P1(int i2, String str, int i3, boolean z2) {
        Q1(i2, str, i3, z2, null);
    }

    public final boolean P2() {
        PbFragment pbFragment = this.f53178c;
        return (pbFragment == null || pbFragment.z().y0().l().getDeletedReasonInfo() == null || 1 != this.f53178c.z().y0().l().getDeletedReasonInfo().is_grays_cale_forum.intValue()) ? false : true;
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

    public View Q0() {
        return this.f53180e;
    }

    public void Q1(int i2, String str, int i3, boolean z2, String str2) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(R.id.tag_del_post_id, str);
        sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i2));
        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i3));
        sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
        sparseArray.put(W1, Integer.valueOf(X1));
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
        this.O = new d.a.j0.r.s.a(this.f53178c.getActivity());
        if (StringUtils.isNull(str2)) {
            this.O.setMessageId(i4);
        } else {
            this.O.setOnlyMessageShowCenter(false);
            this.O.setMessage(str2);
        }
        this.O.setYesButtonTag(sparseArray);
        this.O.setPositiveButton(R.string.dialog_ok, this.f53178c);
        this.O.setNegativeButton(R.string.dialog_cancel, new n(this));
        this.O.setCancelable(true);
        this.O.create(this.f53178c.getPageContext());
        if (z2) {
            this.O.show();
        } else if (P2()) {
            d.a.k0.h.h hVar = new d.a.k0.h.h(this.f53178c.z().y0().l().getDeletedReasonInfo().is_grays_cale_forum.intValue(), this.f53178c.z().y0().l().getDeletedReasonInfo().is_boomgrow.intValue(), this.f53178c.z().y0().o().has_forum_rule.intValue());
            hVar.i(this.f53178c.z().y0().l().getId(), this.f53178c.z().y0().l().getName());
            hVar.h(this.f53178c.z().y0().l().getImage_url());
            hVar.j(this.f53178c.z().y0().l().getUser_level());
            b3(this.O, i2, hVar, this.f53178c.z().y0().R());
        } else {
            i3(this.O, i2);
        }
    }

    public void Q2() {
        View view;
        PbLandscapeListView pbLandscapeListView = this.l;
        if (pbLandscapeListView != null) {
            pbLandscapeListView.setVisibility(0);
        }
        FrameLayout frameLayout = this.G0;
        if (frameLayout != null) {
            frameLayout.setVisibility(0);
        }
        d.a.k0.d2.k.e.e1.c cVar = this.f53183h;
        if (cVar == null || (view = cVar.f53061d) == null) {
            return;
        }
        view.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
    }

    public boolean R(boolean z2) {
        EditorTools editorTools = this.g0;
        if (editorTools == null || !editorTools.u()) {
            return false;
        }
        this.g0.q();
        return true;
    }

    public PbThreadPostView R0() {
        return this.o;
    }

    public void R1(SparseArray<Object> sparseArray, boolean z2) {
        d.a.j0.r.s.h hVar;
        d.a.j0.r.s.h hVar2;
        d.a.j0.r.s.l lVar = new d.a.j0.r.s.l(this.f53178c.getContext());
        lVar.q(this.f53178c.getString(R.string.bar_manager));
        lVar.n(new m(z2));
        ArrayList arrayList = new ArrayList();
        int intValue = sparseArray.get(R.id.tag_check_mute_from) instanceof Integer ? ((Integer) sparseArray.get(R.id.tag_check_mute_from)).intValue() : -1;
        if (!"".equals(sparseArray.get(R.id.tag_del_post_id)) && intValue != 2) {
            if ((sparseArray.get(R.id.tag_del_post_type) instanceof Integer ? ((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue() : -1) == 0) {
                hVar2 = new d.a.j0.r.s.h(10, this.f53178c.getString(R.string.delete_post), lVar);
            } else {
                hVar2 = new d.a.j0.r.s.h(10, this.f53178c.getString(R.string.delete), lVar);
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
            hVar2.f50210d.setTag(sparseArray2);
            arrayList.add(hVar2);
        }
        if ((!"".equals(sparseArray.get(R.id.tag_forbid_user_name)) || !"".equals(sparseArray.get(R.id.tag_forbid_user_name_show))) && !x1()) {
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
            d.a.j0.r.s.h hVar3 = new d.a.j0.r.s.h(11, this.f53178c.getString(R.string.forbidden_person), lVar);
            hVar3.f50210d.setTag(sparseArray3);
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
                hVar = new d.a.j0.r.s.h(12, this.f53178c.getString(R.string.un_mute), lVar);
            } else {
                hVar = new d.a.j0.r.s.h(12, this.f53178c.getString(R.string.mute), lVar);
            }
            hVar.f50210d.setTag(sparseArray4);
            arrayList.add(hVar);
        }
        d.a.k0.d2.k.e.d1.a.e(arrayList);
        if (d.a.j0.b.d.z()) {
            lVar.l(arrayList, false);
        } else {
            lVar.l(arrayList, true);
        }
        d.a.j0.r.s.j jVar = new d.a.j0.r.s.j(this.f53178c.getPageContext(), lVar);
        this.M = jVar;
        jVar.l();
    }

    public void R2() {
        d.a.k0.d2.k.e.z0.f fVar = this.p;
        if (fVar != null) {
            fVar.v(this.l);
        }
    }

    public boolean S() {
        PbListView pbListView = this.F;
        if (pbListView == null || TextUtils.isEmpty(pbListView.h())) {
            return false;
        }
        return this.F.h().equals(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
    }

    public RelativeLayout S0() {
        return this.y;
    }

    public void S1(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray == null) {
            return;
        }
        R1(sparseArray, false);
    }

    public void S2(boolean z2) {
        this.i0.setVisibility(z2 ? 0 : 8);
    }

    public void T() {
        if (!this.f53178c.checkUpIsLogin()) {
            TiebaStatic.log(new StatisticItem("c10517").param("obj_locate", 2).param("fid", this.d0));
        } else if (this.f53178c.W3()) {
            d.a.j0.w.w.e G4 = this.f53178c.G4();
            if (G4 != null && (G4.B() || G4.D())) {
                this.f53178c.G4().z(false, null);
                return;
            }
            if (this.g0 != null) {
                h1();
            }
            EditorTools editorTools = this.g0;
            if (editorTools != null) {
                this.v0 = false;
                if (editorTools.n(2) != null) {
                    d.a.k0.d3.g0.a.c(this.f53178c.getPageContext(), (View) this.g0.n(2).k, false, c2);
                }
            }
            V0();
        }
    }

    public View T0() {
        return this.f53179d;
    }

    public void T1(d.a.j0.t.a aVar, int i2) {
        if (r0.a(aVar, i2)) {
            this.y1.V(aVar.f(), 10, false);
            Fresco.getImagePipeline().fetchDecodedImage(ImageRequestBuilder.newBuilderWithSource(Uri.parse(aVar.e())).setProgressiveRenderingEnabled(true).build(), this.f53178c.getContext()).subscribe(new e(aVar, i2), CallerThreadExecutor.getInstance());
        }
    }

    public void T2(boolean z2) {
        if (this.l0 == null) {
            return;
        }
        m2(this.f53178c.G4().C());
        if (this.h0) {
            W2(z2);
        } else {
            W0(z2);
        }
    }

    public final void U() {
        d.a.k0.d2.k.d.a aVar = new d.a.k0.d2.k.d.a(this.f53178c, this, (ViewStub) this.f53179d.findViewById(R.id.more_god_reply_popup));
        this.h1 = aVar;
        aVar.o(this.J);
        this.h1.p(this.N);
        this.h1.q(this.K);
        this.h1.o(this.J);
        this.h1.s(this.e0);
    }

    public void U0() {
        View view;
        PbLandscapeListView pbLandscapeListView = this.l;
        if (pbLandscapeListView != null) {
            pbLandscapeListView.setVisibility(8);
        }
        if (this.l != null) {
            this.G0.setVisibility(8);
        }
        d.a.k0.d2.k.e.e1.c cVar = this.f53183h;
        if (cVar == null || (view = cVar.f53061d) == null) {
            return;
        }
        view.setVisibility(8);
    }

    public final void U1(PbReplyTitleViewHolder pbReplyTitleViewHolder, boolean z2) {
        int measuredHeight;
        if (this.Y0 || this.I0 == null || this.f53183h.i() == null) {
            return;
        }
        int F = this.z.F();
        if (F > 0 && (pbReplyTitleViewHolder == null || pbReplyTitleViewHolder.a().getParent() == null)) {
            if (F > this.l.getFirstVisiblePosition() - this.l.getHeaderViewsCount()) {
                this.I0.setVisibility(4);
                return;
            }
            this.I0.setVisibility(0);
            S2(false);
            this.f53183h.f53058a.hideBottomLine();
            if (this.I0.getParent() == null || ((ViewGroup) this.I0.getParent()).getHeight() > this.I0.getTop()) {
                return;
            }
            this.I0.getParent().requestLayout();
        } else if (pbReplyTitleViewHolder != null && pbReplyTitleViewHolder.a() != null && pbReplyTitleViewHolder.f19220g != null) {
            int top = pbReplyTitleViewHolder.a().getTop();
            if (pbReplyTitleViewHolder.a().getParent() != null) {
                if (this.N0) {
                    this.M0 = top;
                    this.N0 = false;
                }
                int i2 = this.M0;
                if (top < i2) {
                    i2 = top;
                }
                this.M0 = i2;
            }
            if (top != 0 || pbReplyTitleViewHolder.a().isShown()) {
                if (this.y.getY() < 0.0f) {
                    measuredHeight = U1 - pbReplyTitleViewHolder.f19220g.getMeasuredHeight();
                } else {
                    measuredHeight = this.f53183h.i().getMeasuredHeight() - pbReplyTitleViewHolder.f19220g.getMeasuredHeight();
                    this.f53183h.f53058a.hideBottomLine();
                }
                if (pbReplyTitleViewHolder.a().getParent() == null && top <= this.M0) {
                    this.I0.setVisibility(0);
                    S2(false);
                } else if (top < measuredHeight) {
                    this.I0.setVisibility(0);
                    S2(false);
                } else {
                    this.I0.setVisibility(4);
                    this.f53183h.f53058a.hideBottomLine();
                }
                if (z2) {
                    this.N0 = true;
                }
            }
        } else if (this.l.getFirstVisiblePosition() == 0) {
            this.I0.setVisibility(4);
            this.f53183h.f53058a.hideBottomLine();
        }
    }

    public void U2(d.a.k0.d2.h.e eVar) {
        PostData postData;
        d.a.k0.d2.k.e.e1.c cVar;
        if (eVar == null || (postData = this.A0) == null || postData.t() == null || (cVar = this.f53183h) == null) {
            return;
        }
        boolean z2 = !this.Y0;
        this.Z0 = z2;
        cVar.y(z2);
        if (this.f53178c.H4() != null) {
            this.f53178c.H4().s(this.Z0);
        }
        V1();
        PbFragment pbFragment = this.f53178c;
        if (pbFragment != null && !pbFragment.isSimpleForum() && !ListUtils.isEmpty(eVar.p())) {
            w1 w1Var = eVar.p().get(0);
            if (w1Var != null) {
                this.f53183h.B(w1Var.g(), w1Var.a());
            }
        } else if (eVar.l() != null) {
            this.f53183h.B(eVar.l().getName(), eVar.l().getImage_url());
        }
        if (this.Z0) {
            this.s.B(eVar, this.A0, this.b0);
            View view = this.J0;
            if (view != null) {
                view.setVisibility(8);
            }
            if (this.i1 == null) {
                this.i1 = new y();
            }
            this.l.setListViewDragListener(this.i1);
            return;
        }
        View view2 = this.J0;
        if (view2 != null) {
            view2.setVisibility(0);
        }
        this.s.B(eVar, this.A0, this.b0);
        this.i1 = null;
        this.l.setListViewDragListener(null);
    }

    public final CustomBlueCheckRadioButton V(String str, String str2) {
        Activity pageActivity = this.f53178c.getPageContext().getPageActivity();
        CustomBlueCheckRadioButton customBlueCheckRadioButton = new CustomBlueCheckRadioButton(pageActivity);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, d.a.c.e.p.l.g(pageActivity, R.dimen.ds100));
        customBlueCheckRadioButton.setOnCheckedChangeListener(this.T);
        customBlueCheckRadioButton.setTag(str);
        customBlueCheckRadioButton.setText(str2);
        customBlueCheckRadioButton.setLayoutParams(layoutParams);
        return customBlueCheckRadioButton;
    }

    public void V0() {
        if (this.l0 == null) {
            return;
        }
        this.k0.setVisibility(8);
        this.l0.setVisibility(8);
        this.v0 = false;
        PbEmotionBar pbEmotionBar = this.P0;
        if (pbEmotionBar != null) {
            pbEmotionBar.setVisibility(8);
            e2(false);
        }
    }

    public final void V1() {
        this.s.r(this.z0, this.A0, this.Z0, this.Y0);
    }

    public final boolean V2(d.a.k0.d2.h.e eVar) {
        if (eVar == null || eVar.L() == null) {
            return false;
        }
        return eVar.L().s0() == 1 || eVar.L().t1() == 33 || !(eVar.L().B1() == null || eVar.L().B1().a() == 0) || eVar.L().x0() == 1 || eVar.L().w0() == 1 || eVar.L().M1() || eVar.L().e2() || eVar.L().E2() || eVar.L().J1() != null || !d.a.c.e.p.k.isEmpty(eVar.L().X()) || eVar.L().b2() || eVar.L().p2();
    }

    public void W() {
        if (this.S1) {
            return;
        }
        TiebaStatic.log("c10490");
        this.S1 = true;
        d.a.j0.r.s.a aVar = new d.a.j0.r.s.a(this.f53178c.getPageContext().getPageActivity());
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(W1, Integer.valueOf(Y1));
        aVar.setTitle(R.string.grade_thread_tips);
        View inflate = LayoutInflater.from(this.f53178c.getPageContext().getPageActivity()).inflate(R.layout.upgrade_success_dialog_content, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.function_description_view)).setText(R.string.function_upgrade_to_photo_live_tips);
        ((TextView) inflate.findViewById(R.id.title_view)).setText(R.string.grade_thread_tips);
        aVar.setContentView(inflate);
        aVar.setYesButtonTag(sparseArray);
        aVar.setPositiveButton(R.string.grade_button_tips, this.f53178c);
        aVar.setNegativeButton(R.string.look_again, new b0(this));
        aVar.create(this.f53178c.getPageContext()).show();
    }

    public void W0(boolean z2) {
        if (this.l0 == null || this.o0 == null) {
            return;
        }
        if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
            this.o0.setText(TbSingleton.getInstance().getAdVertiComment());
        } else {
            this.o0.setText(L0());
        }
        if (z2) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(400L);
            this.l0.startAnimation(alphaAnimation);
        }
        this.k0.setVisibility(0);
        this.l0.setVisibility(0);
        this.v0 = true;
        if (this.P0 == null || this.h1.l()) {
            return;
        }
        this.P0.setVisibility(0);
        e2(true);
    }

    public void W1() {
        PbLandscapeListView pbLandscapeListView = this.l;
        if (pbLandscapeListView == null) {
            return;
        }
        int headerViewsCount = pbLandscapeListView.getHeaderViewsCount() - this.X0;
        int firstVisiblePosition = (this.l.getFirstVisiblePosition() == 0 || this.l.getFirstVisiblePosition() + headerViewsCount < 0) ? 0 : this.l.getFirstVisiblePosition() + headerViewsCount;
        View childAt = this.l.getChildAt(0);
        int top = childAt != null ? childAt.getTop() : -1;
        this.O0.f53224c = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.O0));
        PbReplyTitleViewHolder pbReplyTitleViewHolder = this.O0.f53224c;
        int M0 = M0(pbReplyTitleViewHolder);
        int measuredHeight = this.y.getMeasuredHeight() + ((int) this.y.getY());
        boolean z2 = this.I0.getVisibility() == 0;
        boolean z3 = this.y.getY() < 0.0f;
        if ((z2 && pbReplyTitleViewHolder != null) || firstVisiblePosition >= this.z.F() + this.l.getHeaderViewsCount()) {
            int measuredHeight2 = pbReplyTitleViewHolder != null ? pbReplyTitleViewHolder.f19220g.getMeasuredHeight() : 0;
            if (z3) {
                this.l.setSelectionFromTop(this.z.F() + this.l.getHeaderViewsCount(), U1 - measuredHeight2);
            } else {
                this.l.setSelectionFromTop(this.z.F() + this.l.getHeaderViewsCount(), this.f53183h.i().getMeasuredHeight() - measuredHeight2);
            }
        } else {
            this.l.setSelectionFromTop(firstVisiblePosition, top);
        }
        if (this.Y0 && this.p != null) {
            this.l.setSelectionFromTop(this.z.F() + this.l.getHeaderViewsCount(), this.p.d());
        } else if (this.B0 != 6) {
        } else {
            this.l.setOnLayoutListener(new a(M0, pbReplyTitleViewHolder, z2, measuredHeight, firstVisiblePosition, top));
        }
    }

    public void W2(boolean z2) {
        TextView textView;
        if (this.l0 == null || (textView = this.o0) == null) {
            return;
        }
        textView.setText(R.string.draft_to_send);
        if (z2) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(400L);
            this.l0.startAnimation(alphaAnimation);
        }
        this.k0.setVisibility(0);
        this.l0.setVisibility(0);
        this.v0 = true;
        if (this.P0 == null || this.h1.l()) {
            return;
        }
        this.P0.setVisibility(0);
        e2(true);
    }

    public void X(String str) {
        if (str.contains("_")) {
            str = str.replace("_", "\n");
        }
        d.a.j0.r.s.a aVar = new d.a.j0.r.s.a(this.f53178c.getPageContext().getPageActivity());
        View inflate = LayoutInflater.from(this.f53178c.getPageContext().getPageActivity()).inflate(R.layout.upgrade_success_dialog_content, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.title_view);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        textView.setLayoutParams(layoutParams);
        textView.setGravity(3);
        textView.setText(str);
        ((TextView) inflate.findViewById(R.id.function_description_view)).setVisibility(8);
        aVar.setContentView(inflate);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(W1, Integer.valueOf(Z1));
        aVar.setYesButtonTag(sparseArray);
        aVar.setPositiveButton(R.string.view, this.f53178c);
        aVar.setNegativeButton(R.string.cancel, new c0(this));
        aVar.create(this.f53178c.getPageContext()).show();
    }

    public void X0() {
        EditorTools editorTools = this.g0;
        if (editorTools != null) {
            editorTools.o();
            d.a.k0.d2.k.e.a1.c cVar = this.g1;
            if (cVar != null) {
                cVar.m();
            }
        }
    }

    public final void X1(d.a.k0.d2.h.e eVar) {
        if (eVar == null || eVar.L() == null) {
            return;
        }
        x3(eVar);
        if (eVar.r()) {
            WebPManager.setPureDrawable(this.q0, R.drawable.icon_pure_pb_bottom_collected26_selection, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
        } else {
            WebPManager.setPureDrawable(this.q0, R.drawable.icon_pure_pb_bottom_collect26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        }
        String j02 = j0(eVar.L().Z0());
        TextView textView = this.t0;
        if (textView != null) {
            textView.setText(j02);
        }
        TextView textView2 = this.u0;
        if (textView2 != null) {
            textView2.setText(j02);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921416, eVar.L()));
    }

    public void X2(View view) {
        if (d.a.j0.r.d0.b.j().g("show_long_press_collection_tips", false)) {
            return;
        }
        Rect rect = new Rect();
        this.l0.getGlobalVisibleRect(rect);
        int i2 = rect.bottom;
        int i3 = rect.top;
        view.getGlobalVisibleRect(rect);
        int i4 = rect.bottom;
        FrameLayout frameLayout = new FrameLayout(this.f53178c.getContext());
        frameLayout.setBackgroundResource(R.drawable.pic_sign_tip);
        TextView textView = new TextView(this.f53178c.getContext());
        this.e1 = textView;
        textView.setText(R.string.connection_tips);
        this.e1.setGravity(17);
        this.e1.setPadding(d.a.c.e.p.l.g(this.f53178c.getContext(), R.dimen.ds24), 0, d.a.c.e.p.l.g(this.f53178c.getContext(), R.dimen.ds24), 0);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        layoutParams.height = d.a.c.e.p.l.g(this.f53178c.getContext(), R.dimen.ds60);
        if (this.e1.getParent() == null) {
            frameLayout.addView(this.e1, layoutParams);
        }
        PopupWindow popupWindow = new PopupWindow(this.f53178c.getContext());
        this.d1 = popupWindow;
        popupWindow.setContentView(frameLayout);
        this.d1.setHeight(-2);
        this.d1.setWidth(-2);
        this.d1.setFocusable(true);
        this.d1.setOutsideTouchable(false);
        this.d1.setBackgroundDrawable(new ColorDrawable(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent)));
        this.l.postDelayed(new e0(i4, i2, i3, view), 100L);
        d.a.j0.r.d0.b.j().t("show_long_press_collection_tips", true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0049, code lost:
        if (r5.t1 == 1) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void Y() {
        boolean z2;
        d.a.k0.d2.p.g gVar = this.v1;
        if (gVar == null) {
            return;
        }
        if (((gVar.a() == null || this.v1.a().getParent() == null) ? -1 : this.l.getPositionForView(this.v1.a())) != -1) {
            if (this.v1.a().getTop() + b2 <= this.I0.getBottom()) {
                this.t1 = 1;
                z2 = true;
            } else {
                this.t1 = 0;
                z2 = false;
            }
        }
        this.K0.s(this.t1 == 1);
        this.v1.e(z2);
    }

    public void Y0() {
        d.a.k0.d2.k.e.e1.c cVar = this.f53183h;
        if (cVar != null) {
            cVar.j();
        }
    }

    public void Y1(int i2, d.a.k0.d2.h.e eVar, boolean z2, int i3) {
        PostData s0;
        if (i2 <= 0 || (s0 = s0(eVar, z2)) == null || s0.t() == null) {
            return;
        }
        MetaData t2 = s0.t();
        t2.setGiftNum(t2.getGiftNum() + i2);
    }

    public void Y2() {
        d.a.k0.d2.k.e.e1.c cVar = this.f53183h;
        if (cVar == null || this.a1) {
            return;
        }
        cVar.u();
        this.a1 = true;
    }

    public void Z() {
        this.f53183h.e();
        d.a.k0.d2.k.e.z0.e eVar = this.s;
        if (eVar != null) {
            eVar.j();
        }
        PbFragment pbFragment = this.f53178c;
        if (pbFragment != null) {
            d.a.c.e.p.l.x(pbFragment.getContext(), this.D);
        }
        X0();
        d.a.j0.r.s.j jVar = this.X;
        if (jVar != null) {
            jVar.dismiss();
        }
        d0();
        d.a.j0.r.s.a aVar = this.A;
        if (aVar != null) {
            aVar.dismiss();
        }
        d.a.j0.r.s.b bVar = this.B;
        if (bVar != null) {
            bVar.e();
        }
    }

    public void Z0() {
        d.a.j0.r.f0.a aVar = this.x0;
        if (aVar != null) {
            aVar.h(false);
        }
    }

    public void Z1(d.a.k0.d2.h.e eVar, boolean z2, int i2, int i3) {
        d3(eVar, z2, i2, i3);
        this.s.p(i3);
    }

    public void Z2() {
        this.l.setVisibility(0);
    }

    public NoNetworkView a() {
        return this.m;
    }

    public void a0() {
        this.f53183h.e();
        d.a.k0.d2.k.e.z0.e eVar = this.s;
        if (eVar != null) {
            eVar.j();
        }
        d.a.j0.r.s.j jVar = this.X;
        if (jVar != null) {
            jVar.dismiss();
        }
        d0();
        d.a.j0.r.s.a aVar = this.A;
        if (aVar != null) {
            aVar.dismiss();
        }
        d.a.j0.r.s.b bVar = this.B;
        if (bVar != null) {
            bVar.e();
        }
    }

    public void a1() {
        Runnable runnable;
        if (this.v == null) {
            g1();
        }
        this.k.setVisibility(8);
        Handler handler = this.H1;
        if (handler == null || (runnable = this.I1) == null) {
            return;
        }
        handler.removeCallbacks(runnable);
    }

    public final void a2() {
        PbInterviewStatusView pbInterviewStatusView = this.F0;
        if (pbInterviewStatusView == null || pbInterviewStatusView.getVisibility() != 0) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.F0.getLayoutParams();
        layoutParams.setMargins(0, 0, 0, 0);
        this.F0.setLayoutParams(layoutParams);
    }

    public void a3() {
        if (this.x0 == null) {
            this.x0 = new d.a.j0.r.f0.a(this.f53178c.getPageContext());
        }
        this.x0.h(true);
    }

    public void b() {
        RightFloatLayerView rightFloatLayerView = this.B1;
        if (rightFloatLayerView == null) {
            return;
        }
        if (!rightFloatLayerView.n()) {
            c1();
            return;
        }
        d.a.j0.s.c.f adFloatViewData = TbSingleton.getInstance().getAdFloatViewData();
        this.A1 = adFloatViewData;
        if (adFloatViewData == null) {
            return;
        }
        this.B1.setData(adFloatViewData.c());
        k3();
        TiebaStatic.log(new StatisticItem("c14128").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_locate", 2));
        this.B1.setLogoListener(new f0(this.A1.d()));
        this.B1.setFeedBackListener(new g0());
    }

    public void b0() {
        d.a.k0.d2.p.h hVar = this.s0;
        if (hVar != null) {
            hVar.h(false);
        }
    }

    public void b1() {
        this.I.setVisibility(8);
    }

    public void b2() {
        if (this.f53181f != 2) {
            this.l.setNextPage(this.F);
            this.f53181f = 2;
        }
    }

    public final void b3(d.a.j0.r.s.a aVar, int i2, d.a.k0.h.h hVar, UserData userData) {
        PbFragment pbFragment = this.f53178c;
        if (pbFragment == null || aVar == null) {
            return;
        }
        if (this.n1 == null && this.q != null) {
            this.n1 = new d.a.k0.h.i(pbFragment.getPageContext(), this.q.c(), hVar, userData);
        }
        AntiData m4 = this.f53178c.m4();
        SparseArray<String> sparseArray = new SparseArray<>();
        if (m4 != null && m4.getDelThreadInfoList() != null) {
            List<DeleteThreadInfo> delThreadInfoList = m4.getDelThreadInfoList();
            for (int i3 = 0; i3 < delThreadInfoList.size(); i3++) {
                if (!TextUtils.isEmpty(delThreadInfoList.get(i3).text_info)) {
                    sparseArray.put(delThreadInfoList.get(i3).text_id, delThreadInfoList.get(i3).text_info);
                }
            }
        }
        d.a.j0.r.q.v0 v0Var = new d.a.j0.r.q.v0();
        v0Var.j(sparseArray);
        this.n1.B(new String[]{this.f53178c.getString(R.string.delete_thread_reason_1), this.f53178c.getString(R.string.delete_thread_reason_2), this.f53178c.getString(R.string.delete_thread_reason_3), this.f53178c.getString(R.string.delete_thread_reason_4), this.f53178c.getString(R.string.delete_thread_reason_5)});
        this.n1.A(v0Var);
        this.n1.D((i2 == 1 || i2 == 2) ? "4" : "3");
        this.n1.C(new p(aVar));
    }

    public final boolean c0() {
        return this.q.b(this.y0);
    }

    public void c1() {
        RightFloatLayerView rightFloatLayerView = this.B1;
        if (rightFloatLayerView != null) {
            rightFloatLayerView.f();
        }
    }

    public void c2() {
        PbLandscapeListView pbLandscapeListView = this.l;
        if (pbLandscapeListView != null) {
            this.r.d(pbLandscapeListView);
            this.s.s(this.l);
            this.t.d(this.l);
            this.q.f(this.l);
        }
    }

    public void c3(d.a.k0.d2.h.e eVar, int i2, int i3, boolean z2, int i4, boolean z3) {
        PbLandscapeListView pbLandscapeListView;
        int i5;
        PbReplyTitleViewHolder pbReplyTitleViewHolder;
        Parcelable e2;
        Parcelable e3;
        if (eVar == null || this.l == null) {
            return;
        }
        this.z0 = eVar;
        this.B0 = i2;
        if (eVar.L() != null) {
            this.Q0 = eVar.L().Y();
            if (eVar.L().P() != 0) {
                this.N1 = true;
            }
            this.b0 = t1(eVar.L());
        }
        if (eVar.R() != null) {
            this.O1 = eVar.R().getUserId();
        }
        f1(eVar);
        this.D0 = false;
        this.y0 = z2;
        G2();
        d.a.k0.d2.h.k kVar = eVar.f52721h;
        if (kVar != null && kVar.b()) {
            if (this.o == null) {
                PbThreadPostView pbThreadPostView = new PbThreadPostView(this.f53178c.getContext());
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
        d3(eVar, z2, i2, TbadkCoreApplication.getInst().getSkinType());
        U2(eVar);
        if (this.k1 == null) {
            this.k1 = new d.a.k0.d2.k.e.h0(this.f53178c.getPageContext(), this.l1);
        }
        this.k1.a(eVar.v());
        if (this.f53178c.y4()) {
            if (this.E == null) {
                d.a.k0.d2.p.i iVar = new d.a.k0.d2.p.i(this.f53178c.getPageContext());
                this.E = iVar;
                iVar.n();
                this.E.a(this.P1);
            }
            this.l.setPullRefresh(this.E);
            g2();
            d.a.k0.d2.p.i iVar2 = this.E;
            if (iVar2 != null) {
                iVar2.I(TbadkCoreApplication.getInst().getSkinType());
            }
        } else if (eVar.w().c() == 0 && z2) {
            this.l.setPullRefresh(null);
        } else {
            if (this.E == null) {
                d.a.k0.d2.p.i iVar3 = new d.a.k0.d2.p.i(this.f53178c.getPageContext());
                this.E = iVar3;
                iVar3.n();
                this.E.a(this.P1);
            }
            this.l.setPullRefresh(this.E);
            g2();
            d.a.k0.d2.p.i iVar4 = this.E;
            if (iVar4 != null) {
                iVar4.I(TbadkCoreApplication.getInst().getSkinType());
            }
            Z0();
        }
        c0();
        this.z.g0(this.y0);
        this.z.d0(false);
        this.z.e0(i2 == 5);
        this.z.f0(i2 == 6);
        this.z.b0(z3 && this.L1 && i2 != 2);
        this.z.Z(eVar, false);
        this.z.U();
        this.s.A(s0(eVar, z2), eVar.a0());
        if (eVar.L() != null && eVar.L().P0() != null && this.f53177b != -1) {
            eVar.L().P0().setIsLike(this.f53177b);
        }
        this.l.removeFooterView(this.L0);
        this.l.addFooterView(this.L0);
        if (TbadkCoreApplication.isLogin()) {
            this.l.setNextPage(this.F);
            this.f53181f = 2;
            Z0();
        } else {
            this.D0 = true;
            if (eVar.w().b() == 1) {
                if (this.G == null) {
                    PbFragment pbFragment = this.f53178c;
                    this.G = new d.a.k0.d2.p.e(pbFragment, pbFragment);
                }
                this.l.setNextPage(this.G);
            } else {
                this.l.setNextPage(this.F);
            }
            this.f53181f = 3;
        }
        ArrayList<PostData> D = eVar.D();
        if (eVar.w().b() != 0 && D != null && D.size() >= eVar.w().e()) {
            if (z3) {
                if (this.L1) {
                    f0();
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
                l0 l0Var = this.O0;
                if (l0Var == null || (pbReplyTitleViewHolder = l0Var.f53224c) == null || pbReplyTitleViewHolder.a() == null) {
                    i5 = 0;
                } else {
                    i5 = this.O0.f53224c.a().getTop() < 0 ? this.O0.f53224c.a().getHeight() : this.O0.f53224c.a().getBottom();
                }
                if (this.f53178c.b5()) {
                    this.F.D(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_host_reply), i5);
                } else {
                    this.F.D(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_replay), i5);
                }
                if (this.f53178c.H4() != null && !this.f53178c.H4().p()) {
                    this.f53178c.H4().x();
                }
            }
            if (eVar.w().b() == 0 || D == null) {
                b2();
            }
        }
        if (i2 == 2) {
            this.l.setSelection(i3 > 1 ? (i3 + ((this.l.getData() == null && eVar.D() == null) ? 0 : (this.l.getData().size() - eVar.D().size()) + this.l.getHeaderViewsCount())) - 2 : 0);
        } else if (i2 != 3) {
            if (i2 == 4) {
                this.L1 = false;
            } else if (i2 == 5) {
                this.l.setSelection(0);
            } else if (i2 != 6) {
                if (i2 == 8) {
                    if (i3 == 0) {
                        d.a.k0.d2.k.e.z0.f fVar = this.p;
                        if (fVar != null && fVar.c() != null) {
                            if (this.f53178c.getBaseFragmentActivity().isUseStyleImmersiveSticky()) {
                                this.l.setSelectionFromTop((this.z.A() + this.l.getHeaderViewsCount()) - 1, this.p.d() - d.a.c.e.p.l.r(this.f53178c.getPageContext().getPageActivity()));
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
                    this.F.A(this.f53178c.getString(R.string.pb_load_more_without_point));
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
                this.F.A(this.f53178c.getString(R.string.pb_load_more_without_point));
                this.F.v();
            }
        }
        if (this.Q0 == V1 && s1()) {
            W();
        }
        if (this.W0) {
            W1();
            this.W0 = false;
            if (i4 == 0) {
                w2(true);
            }
        }
        if (eVar.f52717d == 1 || eVar.f52718e == 1) {
            if (this.c1 == null) {
                this.c1 = new PbTopTipView(this.f53178c.getContext());
            }
            if (eVar.f52718e == 1 && PbActivityConfig.KEY_FROM_GUIDE.equals(this.f53178c.L4())) {
                this.c1.setText(this.f53178c.getString(R.string.pb_read_strategy_add_experience));
                this.c1.l(this.f53179d, this.C0);
            } else if (eVar.f52717d == 1 && PbActivityConfig.KEY_FROM_NEWS.equals(this.f53178c.L4())) {
                this.c1.setText(this.f53178c.getString(R.string.pb_read_news_add_experience));
                this.c1.l(this.f53179d, this.C0);
            }
        }
        this.l.removeFooterView(this.v1.a());
        if (!ListUtils.isEmpty(eVar.F()) && eVar.w().b() == 0) {
            this.l.removeFooterView(this.L0);
            this.v1.d(Math.max(this.l0.getMeasuredHeight(), this.w0 / 2));
            this.l.addFooterView(this.v1.a());
            this.v1.f(eVar);
        }
        X1(eVar);
    }

    public void d0() {
        d.a.j0.r.s.a aVar = this.O;
        if (aVar != null) {
            aVar.dismiss();
        }
        Dialog dialog = this.P;
        if (dialog != null) {
            d.a.c.e.m.g.b(dialog, this.f53178c.getPageContext());
        }
        Dialog dialog2 = this.Q;
        if (dialog2 != null) {
            d.a.c.e.m.g.b(dialog2, this.f53178c.getPageContext());
        }
        d.a.j0.r.s.j jVar = this.M;
        if (jVar != null) {
            jVar.dismiss();
        }
    }

    public void d1() {
        EditorTools editorTools = this.g0;
        if (editorTools != null) {
            editorTools.q();
        }
    }

    public final void d2() {
        PbFragment pbFragment = this.f53178c;
        if (pbFragment == null || pbFragment.G4() == null || this.g0 == null) {
            return;
        }
        d.a.j0.w.w.a.a().c(0);
        d.a.j0.w.w.e G4 = this.f53178c.G4();
        G4.T();
        G4.R();
        if (G4.y() != null) {
            G4.y().setMaxImagesAllowed(G4.z ? 1 : 9);
        }
        G4.l0(SendView.k);
        G4.j(SendView.k);
        d.a.j0.w.h m2 = this.g0.m(23);
        d.a.j0.w.h m3 = this.g0.m(2);
        d.a.j0.w.h m4 = this.g0.m(5);
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
    public final void d3(d.a.k0.d2.h.e eVar, boolean z2, int i2, int i3) {
        if (eVar == null || eVar.L() == null) {
            return;
        }
        if (this.f53178c.isSimpleForum()) {
            if (eVar.h() != null) {
                this.c0 = eVar.h().g();
                this.d0 = eVar.h().h();
            }
            if (this.c0 == null && this.f53178c.z() != null && this.f53178c.z().a0() != null) {
                this.c0 = this.f53178c.z().a0();
            }
        }
        PostData s0 = s0(eVar, z2);
        E2(s0, eVar);
        this.s.x(8);
        if (eVar.f0()) {
            this.Y0 = true;
            this.f53183h.s(true);
            this.f53183h.f53058a.hideBottomLine();
            if (this.p == null) {
                this.p = new d.a.k0.d2.k.e.z0.f(this.f53178c);
            }
            this.p.w(eVar, s0, this.l, this.s, this.G0, this.f53183h, this.c0, this.q1);
            this.p.t(this.M1);
            g2();
        } else {
            this.Y0 = false;
            this.f53183h.s(false);
            d.a.k0.d2.k.e.z0.f fVar = this.p;
            if (fVar != null) {
                fVar.p(this.l);
            }
        }
        if (this.f53178c.H4() != null) {
            this.f53178c.H4().w(this.Y0);
        }
        if (s0 == null) {
            return;
        }
        this.A0 = s0;
        this.s.x(0);
        SparseArray<Object> n2 = this.s.n();
        n2.put(R.id.tag_clip_board, s0);
        n2.put(R.id.tag_is_subpb, Boolean.FALSE);
        this.t.e(eVar, this.l);
        this.r.f(eVar);
        this.q.h(eVar, this.y0);
        this.q.g(eVar);
        this.s.y(this.C0, this.z0, s0, this.M1);
        if (this.K0 != null) {
            if (eVar.a0()) {
                this.K0.a().setVisibility(8);
            } else {
                this.K0.a().setVisibility(0);
                d.a.k0.d2.h.o oVar = new d.a.k0.d2.h.o(d.a.k0.d2.h.o.l);
                if (eVar.L() != null) {
                    eVar.L().Z0();
                }
                oVar.f52752g = eVar.f52720g;
                eVar.c();
                oVar.f52753h = this.f53178c.b5();
                oVar.k = eVar.f52719f;
                this.K0.h(oVar);
            }
        }
        n3(eVar);
        d.a.c.e.m.e.a().post(new w());
        this.u.e(this.l);
        if (s0.S) {
            this.u.f(s0.E());
            this.u.b(this.l, this.l.getHeaderViewsCount() <= 1 ? 0 : 1);
        }
        d.a.k0.d2.k.e.i iVar = this.z;
        if (iVar != null && iVar.y() != null) {
            this.z.y().s0(s0.S);
        }
        d.a.k0.d2.k.e.i iVar2 = this.z;
        if (iVar2 != null) {
            iVar2.i0(s0.S);
        }
        this.w1.setVisibility(s0.S ? 0 : 8);
    }

    public void e0() {
        d.a.k0.d2.k.e.z0.f fVar = this.p;
        if (fVar != null) {
            fVar.b();
        }
    }

    public final void e1() {
        if (this.r == null) {
            this.r = new d.a.k0.d2.k.e.z0.c(this.f53178c, this.e0);
        }
    }

    public final void e2(boolean z2) {
    }

    public void e3(b.c cVar, boolean z2) {
        d.a.j0.r.s.j jVar = this.Y;
        if (jVar != null) {
            jVar.dismiss();
            this.Y = null;
        }
        d.a.j0.r.s.l lVar = new d.a.j0.r.s.l(this.f53178c.getContext());
        ArrayList arrayList = new ArrayList();
        d.a.k0.d2.h.e eVar = this.z0;
        if (eVar != null && eVar.L() != null && !this.z0.L().T1()) {
            arrayList.add(new d.a.j0.r.s.h(0, this.f53178c.getPageContext().getString(R.string.save_to_emotion), lVar));
        }
        if (!z2) {
            arrayList.add(new d.a.j0.r.s.h(1, this.f53178c.getPageContext().getString(R.string.save_to_local), lVar));
        }
        lVar.k(arrayList);
        lVar.n(new u(cVar));
        d.a.j0.r.s.j jVar2 = new d.a.j0.r.s.j(this.f53178c.getPageContext(), lVar);
        this.Y = jVar2;
        jVar2.l();
    }

    public void f0() {
        PbListView pbListView = this.F;
        if (pbListView != null) {
            pbListView.v();
            this.F.f();
        }
        Z0();
    }

    public final void f1(d.a.k0.d2.h.e eVar) {
        if (eVar == null || eVar.L() == null || !eVar.L().e2() || this.F0 != null) {
            return;
        }
        PbInterviewStatusView pbInterviewStatusView = (PbInterviewStatusView) this.E0.inflate();
        this.F0 = pbInterviewStatusView;
        pbInterviewStatusView.setOnClickListener(this.J);
        this.F0.setCallback(this.f53178c.w4());
        this.F0.setData(this.f53178c, eVar);
    }

    public void f2() {
        d2();
        X0();
        this.U0.c();
        T2(false);
    }

    public void f3(b.c cVar, boolean z2, boolean z3) {
        d.a.j0.r.s.j jVar = this.X;
        if (jVar != null) {
            jVar.dismiss();
            this.X = null;
        }
        d.a.j0.r.s.l lVar = new d.a.j0.r.s.l(this.f53178c.getContext());
        ArrayList arrayList = new ArrayList();
        arrayList.add(new d.a.j0.r.s.h(0, this.f53178c.getPageContext().getString(R.string.copy), lVar));
        if (z3) {
            arrayList.add(new d.a.j0.r.s.h(1, this.f53178c.getPageContext().getString(R.string.report_text), lVar));
        } else if (!z2) {
            arrayList.add(new d.a.j0.r.s.h(1, this.f53178c.getPageContext().getString(R.string.mark), lVar));
        } else {
            arrayList.add(new d.a.j0.r.s.h(1, this.f53178c.getPageContext().getString(R.string.remove_mark), lVar));
        }
        lVar.k(arrayList);
        lVar.n(new s(cVar));
        d.a.j0.r.s.j jVar2 = new d.a.j0.r.s.j(this.f53178c.getPageContext(), lVar);
        this.Y = jVar2;
        jVar2.l();
    }

    public void g0() {
        this.l.A(0L);
        c0();
    }

    public final void g1() {
        if (this.f53178c.y4()) {
            ViewStub viewStub = (ViewStub) this.f53179d.findViewById(R.id.manga_mention_controller_view_stub);
            this.k = viewStub;
            viewStub.setVisibility(0);
            if (this.v == null) {
                this.v = (LinearLayout) this.f53179d.findViewById(R.id.manga_controller_layout);
                d.a.j0.s0.a.a(this.f53178c.getPageContext(), this.v);
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

    public final void g2() {
        d.a.k0.d2.k.e.z0.f fVar = this.p;
        if (fVar != null) {
            fVar.q(this.l, this.H0, this.B0);
        }
    }

    public void g3(AdapterView.OnItemClickListener onItemClickListener) {
        d.a.j0.r.s.e eVar = this.Z;
        if (eVar != null) {
            eVar.d();
            this.Z = null;
        }
        if (this.z0 == null) {
            return;
        }
        ArrayList<d.a.j0.r.s.n> arrayList = new ArrayList<>();
        arrayList.add(new d.a.j0.r.s.n(this.f53178c.getContext().getString(R.string.all_person), "", this.z0.I() == 1, Integer.toString(1)));
        arrayList.add(new d.a.j0.r.s.n(this.f53178c.getContext().getString(R.string.my_fans), "", this.z0.I() == 2, Integer.toString(5)));
        arrayList.add(new d.a.j0.r.s.n(this.f53178c.getContext().getString(R.string.my_attentions), "", this.z0.I() == 3, Integer.toString(6)));
        arrayList.add(new d.a.j0.r.s.n(this.f53178c.getContext().getString(R.string.myself_only), "", this.z0.I() == 4, Integer.toString(7)));
        d.a.j0.r.s.e eVar2 = new d.a.j0.r.s.e(this.f53178c.getPageContext());
        eVar2.l(R.string.pb_privacy_setting_thread_reply_decs);
        this.Z = eVar2;
        eVar2.k(arrayList, onItemClickListener);
        eVar2.c();
        this.Z.n();
    }

    public void h0(int i2, boolean z2, String str, boolean z3) {
        this.f53178c.hideProgressBar();
        if (z2 && z3) {
            PbFragment pbFragment = this.f53178c;
            pbFragment.showToast(pbFragment.getPageContext().getString(R.string.success));
        } else if (z3) {
            if (d.a.c.e.p.k.isEmpty(str)) {
                str = TbadkCoreApplication.getInst().getResources().getString(R.string.neterror);
            }
            this.f53178c.showToast(str);
        }
    }

    public void h1() {
        EditorTools editorTools;
        if (this.f53178c == null || (editorTools = this.g0) == null) {
            return;
        }
        editorTools.j();
        if (this.f53178c.G4() != null) {
            this.f53178c.G4().P();
        }
        V0();
    }

    public void h2() {
        Handler handler = this.H1;
        if (handler == null) {
            return;
        }
        Runnable runnable = this.I1;
        if (runnable != null) {
            handler.removeCallbacks(runnable);
        }
        h hVar = new h();
        this.I1 = hVar;
        this.H1.postDelayed(hVar, 2000L);
    }

    public void h3() {
        PostData postData;
        if (!TbadkCoreApplication.isLogin() || this.z0 == null || !this.Z0 || this.Y0 || this.b0 || (postData = this.A0) == null || postData.t() == null || this.A0.t().getIsLike() || this.A0.t().hadConcerned() || this.V0 != null) {
            return;
        }
        this.V0 = new o0(this.f53178c);
    }

    public void i0() {
        PbLandscapeListView pbLandscapeListView = this.l;
        if (pbLandscapeListView != null) {
            pbLandscapeListView.setForbidDragListener(true);
        }
    }

    public void i1() {
        if (TbSingleton.getInstance().isShowRightFloatView(1)) {
            b();
        }
    }

    public void i2(EditorTools editorTools) {
        this.g0 = editorTools;
        editorTools.setOnCancelClickListener(new j());
        this.g0.setId(R.id.pb_editor);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        if (this.g0.getParent() == null) {
            this.f53179d.addView(this.g0, layoutParams);
        }
        this.g0.w(TbadkCoreApplication.getInst().getSkinType());
        this.g0.setActionListener(24, new k());
        X0();
        this.f53178c.G4().i(new l());
    }

    public final void i3(d.a.j0.r.s.a aVar, int i2) {
        PbFragment pbFragment = this.f53178c;
        if (pbFragment == null || aVar == null) {
            return;
        }
        if (this.m1 == null && this.q != null) {
            this.m1 = new d.a.k0.h.f(pbFragment.getPageContext(), this.q.c());
        }
        AntiData m4 = this.f53178c.m4();
        SparseArray<String> sparseArray = new SparseArray<>();
        if (m4 != null && m4.getDelThreadInfoList() != null) {
            List<DeleteThreadInfo> delThreadInfoList = m4.getDelThreadInfoList();
            for (int i3 = 0; i3 < delThreadInfoList.size(); i3++) {
                if (!TextUtils.isEmpty(delThreadInfoList.get(i3).text_info)) {
                    sparseArray.put(delThreadInfoList.get(i3).text_id, delThreadInfoList.get(i3).text_info);
                }
            }
        }
        d.a.j0.r.q.v0 v0Var = new d.a.j0.r.q.v0();
        v0Var.j(sparseArray);
        this.m1.x(new String[]{this.f53178c.getString(R.string.delete_thread_reason_1), this.f53178c.getString(R.string.delete_thread_reason_2), this.f53178c.getString(R.string.delete_thread_reason_3), this.f53178c.getString(R.string.delete_thread_reason_4), this.f53178c.getString(R.string.delete_thread_reason_5)});
        this.m1.w(v0Var);
        this.m1.z((i2 == 1 || i2 == 2) ? "4" : "3");
        this.m1.y(new o(aVar));
    }

    public final String j0(int i2) {
        if (i2 == 0) {
            return this.f53178c.getString(R.string.pb_comment_red_dot_no_reply);
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

    public final void j1() {
        if (this.t == null) {
            this.t = new d.a.k0.d2.k.e.z0.b(this.f53178c, this.J);
        }
    }

    public void j2(String str) {
        PbListView pbListView = this.F;
        if (pbListView != null) {
            pbListView.A(str);
        }
    }

    public void j3() {
        this.I.setVisibility(0);
    }

    public d.a.k0.d2.k.e.i k0() {
        return this.z;
    }

    public void k1(d.a.k0.d2.h.e eVar) {
        PbReplyTitleViewHolder pbReplyTitleViewHolder;
        int i2 = 0;
        this.z.Z(eVar, false);
        this.z.U();
        c0();
        d.a.k0.d2.k.d.a aVar = this.h1;
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
                l0 l0Var = this.O0;
                if (l0Var != null && (pbReplyTitleViewHolder = l0Var.f53224c) != null && pbReplyTitleViewHolder.a() != null) {
                    i2 = this.O0.f53224c.a().getTop() < 0 ? this.O0.f53224c.a().getHeight() : this.O0.f53224c.a().getBottom();
                }
                if (this.f53178c.b5()) {
                    this.F.D(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_host_reply), i2);
                } else {
                    this.F.D(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_replay), i2);
                }
            }
        }
        X1(eVar);
    }

    public void k2(String str) {
        PbReplyTitleViewHolder pbReplyTitleViewHolder;
        if (this.F != null) {
            int i2 = 0;
            l0 l0Var = this.O0;
            if (l0Var != null && (pbReplyTitleViewHolder = l0Var.f53224c) != null && pbReplyTitleViewHolder.a() != null) {
                i2 = this.O0.f53224c.a().getTop() < 0 ? this.O0.f53224c.a().getHeight() : this.O0.f53224c.a().getBottom();
            }
            this.F.D(str, i2);
        }
    }

    public void k3() {
        RightFloatLayerView rightFloatLayerView = this.B1;
        if (rightFloatLayerView != null) {
            rightFloatLayerView.g();
        }
    }

    public LinearLayout l0() {
        return this.m0;
    }

    public boolean l1() {
        return this.N1;
    }

    public void l2(PbFragment.n2 n2Var) {
        this.K1 = n2Var;
    }

    public void l3(z0 z0Var, a.e eVar) {
        if (z0Var == null) {
            return;
        }
        int a3 = z0Var.a();
        int h2 = z0Var.h();
        d.a.j0.r.s.a aVar = this.A;
        if (aVar != null) {
            aVar.show();
        } else {
            this.A = new d.a.j0.r.s.a(this.f53178c.getPageContext().getPageActivity());
            View inflate = LayoutInflater.from(this.f53178c.getPageContext().getPageActivity()).inflate(R.layout.dialog_direct_pager, (ViewGroup) null);
            this.C = inflate;
            this.A.setContentView(inflate);
            this.A.setPositiveButton(R.string.dialog_ok, eVar);
            this.A.setNegativeButton(R.string.dialog_cancel, new z());
            this.A.setOnCalcelListener(new a0());
            this.A.create(this.f53178c.getPageContext()).show();
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
        this.f53178c.getBaseFragmentActivity().ShowSoftKeyPadDelay(this.D, 150);
    }

    public View m0() {
        View view = this.R;
        if (view != null) {
            return view.findViewById(R.id.dialog_button_ok);
        }
        return null;
    }

    public boolean m1() {
        return this.v0;
    }

    public void m2(boolean z2) {
        this.h0 = z2;
    }

    public void m3(boolean z2) {
        TextView textView;
        if (this.l == null || (textView = this.H0) == null || this.f53180e == null) {
            return;
        }
        if (z2) {
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.f53180e.setVisibility(0);
            } else {
                this.f53180e.setVisibility(8);
                this.l.removeHeaderView(this.H0);
                this.l.setTextViewAdded(false);
            }
            AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) this.H0.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = U1;
                this.H0.setLayoutParams(layoutParams);
            }
            g2();
            return;
        }
        AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) textView.getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT) + D0(true);
            this.H0.setLayoutParams(layoutParams2);
        }
        g2();
        a2();
    }

    public String n0() {
        return this.W;
    }

    public final boolean n1(d.a.k0.d2.h.e eVar) {
        if (eVar == null || eVar.L() == null) {
            return false;
        }
        SpannableStringBuilder l1 = eVar.L().l1();
        if (l1 != null) {
            return TbadkApplication.getInst().getResources().getString(R.string.pb_default_share_tie_title).equals(l1.toString());
        }
        return true;
    }

    public void n2(boolean z2) {
        this.z.a0(z2);
    }

    public final void n3(d.a.k0.d2.h.e eVar) {
        if (eVar == null || eVar.L() == null || eVar.L().B2()) {
            return;
        }
        boolean z2 = eVar.L().w0() == 1;
        boolean z3 = eVar.L().x0() == 1;
        d.a.k0.d2.k.e.z0.e eVar2 = this.s;
        if (eVar2 != null) {
            eVar2.i(eVar, z2, z3);
        }
        d.a.k0.d2.k.e.i iVar = this.z;
        if (iVar == null || iVar.s() == null) {
            return;
        }
        this.z.s().d(eVar, z2, z3);
    }

    public int o0() {
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

    public boolean o1() {
        PbLandscapeListView pbLandscapeListView = this.l;
        if (pbLandscapeListView == null) {
            return false;
        }
        return pbLandscapeListView.J();
    }

    public void o2(boolean z2) {
        d.a.k0.d2.k.e.z0.f fVar = this.p;
        if (fVar != null) {
            fVar.r(z2);
        }
    }

    @SuppressLint({"CutPasteId"})
    public void o3(d.a.k0.d2.h.e eVar, boolean z2) {
        if (eVar == null) {
            return;
        }
        y3(eVar, z2);
        c0();
    }

    public PostData p0() {
        if (this.l == null) {
            return null;
        }
        int o0 = o0() - this.l.getHeaderViewsCount();
        int i2 = 0;
        if (o0 < 0) {
            o0 = 0;
        }
        if (this.z.x(o0) != null && this.z.x(o0) != PostData.o0) {
            i2 = o0 + 1;
        }
        if (this.z.w(i2) instanceof PostData) {
            return (PostData) this.z.w(i2);
        }
        return null;
    }

    public boolean p1() {
        EditorTools editorTools = this.g0;
        return editorTools != null && editorTools.getVisibility() == 0;
    }

    public void p2(boolean z2) {
        this.r1 = z2;
    }

    public void p3(String str) {
        this.f53178c.showToast(str);
    }

    public FallingView q0() {
        return this.x1;
    }

    public final boolean q1(PostData postData) {
        if (postData == null || postData.t() == null) {
            return false;
        }
        MetaData t2 = postData.t();
        return (TextUtils.isEmpty(t2.getUserId()) && TextUtils.isEmpty(t2.getAvater())) ? false : true;
    }

    public void q2(boolean z2) {
        this.j1 = z2;
    }

    public void q3(final d.a.j0.t.a aVar, Bitmap bitmap, final int i2) {
        final Random random = new Random();
        c.b bVar = new c.b(bitmap);
        bVar.p(d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds8), true);
        bVar.o(d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds200), d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds200), true);
        bVar.m(d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds100), d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds100));
        bVar.n(new c.InterfaceC1274c() { // from class: d.a.k0.d2.k.e.b
            @Override // d.a.k0.d2.p.c.InterfaceC1274c
            public final float a() {
                return s0.A1(random);
            }
        });
        bVar.q(d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds40), true, true);
        d.a.k0.d2.p.c l2 = bVar.l();
        this.x1.f();
        this.x1.a(l2, 19);
        d.a.c.e.m.e.a().postDelayed(this.F1, 2000L);
        TiebaStatic.log(new StatisticItem("c14125").param("obj_type", i2).param("uid", TbadkCoreApplication.getCurrentAccount()));
        TbImageView tbImageView = this.y1;
        if (tbImageView != null) {
            tbImageView.setOnClickListener(new View.OnClickListener() { // from class: d.a.k0.d2.k.e.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    s0.this.B1(aVar, i2, view);
                }
            });
        }
    }

    public int r0() {
        return t0(this.l.getFirstVisiblePosition());
    }

    public boolean r1() {
        return false;
    }

    public void r2(boolean z2) {
        d.a.k0.d2.k.e.z0.f fVar = this.p;
        if (fVar != null) {
            fVar.s(z2);
        }
    }

    public void r3() {
        this.f53178c.showProgressBar();
    }

    public PostData s0(d.a.k0.d2.h.e eVar, boolean z2) {
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
        if (!q1(postData)) {
            postData = K0(eVar);
        }
        if (postData != null && postData.t() != null && postData.t().getUserTbVipInfoData() != null && postData.t().getUserTbVipInfoData().getvipIntro() != null) {
            postData.t().getGodUserData().setIntro(postData.t().getUserTbVipInfoData().getvipIntro());
        }
        return postData;
    }

    public final boolean s1() {
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.O1);
    }

    public void s2(boolean z2) {
        this.z.c0(z2);
    }

    public void s3() {
        FallingView fallingView = this.x1;
        if (fallingView != null) {
            fallingView.g();
        }
        if (this.y1 != null) {
            d.a.c.e.m.e.a().removeCallbacks(this.F1);
            this.y1.setVisibility(8);
        }
    }

    public final int t0(int i2) {
        d.a.c.j.e.e adapter2 = this.l.getAdapter2();
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
        int n2 = (this.l.getAdapter2() == null || !(this.l.getAdapter2() instanceof d.a.c.j.e.e)) ? 0 : this.l.getAdapter2().n();
        if (i2 > n2) {
            return i2 - n2;
        }
        return 0;
    }

    public final boolean t1(a2 a2Var) {
        if (a2Var == null || a2Var.T() == null) {
            return false;
        }
        PostData s0 = s0(this.z0, false);
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), (s0 == null || s0.t() == null) ? "" : s0.t().getUserId());
    }

    public void t2(boolean z2) {
        this.z.h0(z2);
    }

    public void t3() {
        if (this.Q1 != null) {
            while (this.Q1.size() > 0) {
                TbImageView remove = this.Q1.remove(0);
                if (remove != null) {
                    remove.Z();
                }
            }
        }
    }

    public Button u0() {
        return this.j0;
    }

    public boolean u1() {
        View view = this.L0;
        if (view == null || view.getParent() == null || this.F.l()) {
            return false;
        }
        int bottom = this.L0.getBottom();
        Rect rect = new Rect();
        this.L0.getWindowVisibleDisplayFrame(rect);
        return bottom > 0 && bottom <= rect.bottom;
    }

    public void u2(f.g gVar) {
        this.P1 = gVar;
        d.a.k0.d2.p.i iVar = this.E;
        if (iVar != null) {
            iVar.a(gVar);
        }
    }

    public void u3(boolean z2) {
        this.a0 = z2;
    }

    public int v0() {
        return this.l.getHeaderViewsCount();
    }

    public boolean v1() {
        d.a.k0.d2.h.e eVar = this.z0;
        return eVar == null || eVar.l() == null || "0".equals(this.z0.l().getId()) || "me0407".equals(this.z0.l().getName());
    }

    public void v2(String str) {
        d.a.k0.d2.k.e.e1.b bVar = this.f53184i;
        if (bVar != null) {
            bVar.b(str);
        }
    }

    public void v3(boolean z2) {
        this.f53183h.z(z2);
        if (z2 && this.D0) {
            this.F.A(TbadkCoreApplication.getInst().getResources().getString(R.string.click_load_more));
            this.l.setNextPage(this.F);
            this.f53181f = 2;
        }
        C1();
    }

    public TextView w0() {
        return this.s.k();
    }

    public boolean w1() {
        d.a.k0.d2.k.e.z0.f fVar = this.p;
        return fVar != null && fVar.f();
    }

    public void w2(boolean z2) {
        this.W0 = z2;
        PbLandscapeListView pbLandscapeListView = this.l;
        if (pbLandscapeListView != null) {
            this.X0 = pbLandscapeListView.getHeaderViewsCount();
        }
    }

    public void w3(d.a.k0.d2.h.c cVar) {
        String string;
        if (cVar == null) {
            return;
        }
        this.f53183h.A();
        if (!StringUtils.isNull(cVar.f52709b)) {
            this.f53183h.x(cVar.f52709b);
        }
        String string2 = TbadkCoreApplication.getInst().getResources().getString(R.string.thread_delete_by);
        int d2 = d.a.c.e.m.b.d(cVar.f52708a, 0);
        if (d2 == 100) {
            string = TbadkCoreApplication.getInst().getResources().getString(R.string.self);
        } else if (d2 != 300) {
            string = d2 != 400 ? "" : TbadkCoreApplication.getInst().getResources().getString(R.string.system);
        } else {
            string = TbadkCoreApplication.getInst().getResources().getString(R.string.bawu);
        }
        this.f53178c.showNetRefreshView(this.f53179d, String.format(string2, string), null, TbadkCoreApplication.getInst().getResources().getString(R.string.appeal_restore), true, new x(cVar.f52710c));
    }

    public PbInterviewStatusView x0() {
        return this.F0;
    }

    public boolean x1() {
        return this.z1;
    }

    public void x2(PbFragment.o2 o2Var) {
    }

    public void x3(d.a.k0.d2.h.e eVar) {
        if (eVar != null && AntiHelper.o(eVar.L())) {
            d.a.k0.d2.p.h hVar = this.s0;
            if (hVar != null) {
                hVar.h(false);
                this.s0.g();
            }
            ViewGroup.LayoutParams layoutParams = this.r0.getLayoutParams();
            layoutParams.height = -2;
            layoutParams.width = -2;
            this.r0.setLayoutParams(layoutParams);
            WebPManager.setPureDrawable(this.r0, R.drawable.icon_pure_pb_bottom_share26, R.color.CAM_X0110, WebPManager.ResourceStateType.NORMAL_PRESS);
            return;
        }
        d.a.k0.d2.p.h hVar2 = this.s0;
        if (hVar2 == null || !hVar2.e()) {
            ViewGroup.LayoutParams layoutParams2 = this.r0.getLayoutParams();
            layoutParams2.height = -2;
            layoutParams2.width = -2;
            this.r0.setLayoutParams(layoutParams2);
            WebPManager.setPureDrawable(this.r0, R.drawable.icon_pure_pb_bottom_share26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        }
    }

    public boolean y0() {
        return this.j1;
    }

    public boolean y1() {
        EditorTools editorTools = this.g0;
        return editorTools != null && editorTools.u();
    }

    public void y2(TbRichTextView.x xVar) {
        this.K = xVar;
        this.z.k0(xVar);
        this.h1.q(this.K);
    }

    public boolean y3(d.a.k0.d2.h.e eVar, boolean z2) {
        if (eVar == null) {
            return false;
        }
        if (this.r != null) {
            if (eVar.L() != null && eVar.L().v0() == 0 && !eVar.L().B2() && !this.z1) {
                if (eVar.L() != null) {
                    a2 L = eVar.L();
                    L.U2(true, V2(eVar));
                    L.c4(3);
                    L.Y3("2");
                }
                if (eVar.L().P1()) {
                    this.s.s(this.l);
                    this.r.d(this.l);
                    this.r.a(this.l);
                    this.s.g(this.l);
                    this.s.w(this.z0);
                    if (n1(eVar)) {
                        this.r.d(this.l);
                    } else {
                        this.r.e(eVar);
                    }
                } else {
                    this.s.w(this.z0);
                    if (n1(eVar)) {
                        this.r.d(this.l);
                    } else {
                        this.r.g(eVar);
                    }
                }
            } else if (eVar.L().v0() == 1) {
                if (eVar.L() != null) {
                    this.r.d(this.l);
                    this.s.w(this.z0);
                }
            } else {
                this.r.d(this.l);
                this.s.w(this.z0);
            }
        }
        n3(eVar);
        this.y0 = z2;
        return false;
    }

    public int z0() {
        int lastVisiblePosition = this.l.getLastVisiblePosition();
        if (this.p != null) {
            if (lastVisiblePosition == this.l.getCount() - 1) {
                lastVisiblePosition--;
            }
            if (lastVisiblePosition < 0) {
                lastVisiblePosition = 0;
            }
        }
        return t0(lastVisiblePosition);
    }

    public final void z1(String str) {
        TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(this.f53178c.getPageContext().getPageActivity(), "", str, true);
        tbWebViewActivityConfig.setFixTitle(true);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig));
    }

    public void z2(NoNetworkView.b bVar) {
        this.L = bVar;
        NoNetworkView noNetworkView = this.m;
        if (noNetworkView != null) {
            noNetworkView.a(bVar);
        }
    }

    public final void z3() {
        if (this.f53178c.y4()) {
            if (this.f53178c.D4() == -1) {
                SkinManager.setViewTextColor(this.w, R.color.CAM_X0110, 1);
            }
            if (this.f53178c.C4() == -1) {
                SkinManager.setViewTextColor(this.x, R.color.CAM_X0110, 1);
            }
        }
    }
}

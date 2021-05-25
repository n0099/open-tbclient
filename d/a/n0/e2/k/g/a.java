package d.a.n0.e2.k.g;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.util.MaskView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.pb.pb.sub.BlankView;
import com.baidu.tieba.pb.pb.sub.EllipsizeRichTextView;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
import com.baidu.tieba.pb.pb.sub.SubPbModel;
import com.baidu.tieba.pb.pb.sub.SubPbView;
import com.baidu.tieba.pb.view.KeyboardEventLayout;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import d.a.m0.r.f0.f;
import d.a.m0.r.q.v0;
import d.a.m0.r.s.a;
import d.a.m0.r.s.b;
import d.a.m0.z0.i0;
import d.a.n0.e2.h.r;
import d.a.n0.e2.i.c;
import d.a.n0.e2.k.e.d0;
import d.a.n0.e2.k.g.b;
import d.a.n0.e3.y;
import d.a.n0.h.f;
import d.a.n0.h.i;
import d.a.n0.z.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import tbclient.DeleteThreadInfo;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes5.dex */
public class a implements KeyboardEventLayout.a {
    public static final int r0 = TbadkCoreApplication.getInst().getListItemRule().c();
    public ThreadSkinView A;
    public d.a.m0.r.f0.a B;
    public d.a.n0.e2.k.g.d C;
    public View D;
    public View F;
    public View H;
    public BlankView I;
    public View J;
    public View.OnClickListener M;
    public d.a.m0.r.s.b N;
    public ProgressBar P;
    public ArrayList<PostData> U;
    public r V;
    public TextView W;
    public RelativeLayout X;
    public ImageView Y;
    public ImageView Z;

    /* renamed from: a  reason: collision with root package name */
    public SubPbView f53585a;
    public LinearLayout a0;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f53586b;
    public HeadImageView b0;

    /* renamed from: c  reason: collision with root package name */
    public View f53587c;
    public View c0;

    /* renamed from: d  reason: collision with root package name */
    public BdTypeListView f53588d;
    public d0 d0;

    /* renamed from: e  reason: collision with root package name */
    public d.a.n0.e2.p.i f53589e;

    /* renamed from: f  reason: collision with root package name */
    public NewSubPbActivity f53590f;

    /* renamed from: g  reason: collision with root package name */
    public NoNetworkView f53591g;
    public SubPbModel g0;
    public d.a.n0.h.f i0;
    public RelativeLayout j;
    public d.a.n0.h.i j0;
    public d.a.n0.e2.k.g.c k0;
    public ImageView l;
    public f.g m0;
    public MaskView n0;
    public View r;

    /* renamed from: h  reason: collision with root package name */
    public NoDataView f53592h = null;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f53593i = null;
    public NavigationBar k = null;
    public View m = null;
    public TextView n = null;
    public LinearLayout o = null;
    public HeadImageView p = null;
    public TextView q = null;
    public ImageView s = null;
    public TextView t = null;
    public TextView u = null;
    public TextView v = null;
    public EllipsizeRichTextView w = null;
    public TbImageView x = null;
    public PlayVoiceBntNew y = null;
    public TextView z = null;
    public MorePopupWindow E = null;
    public d.a.m0.r.s.b G = null;
    public Dialog K = null;
    public d.a.m0.r.s.a L = null;
    public boolean O = true;
    public NewSubPbActivity.q0 Q = null;
    public NewSubPbActivity.q0 R = null;
    public d.a.m0.w.w.h S = null;
    public int T = 0;
    public int e0 = 2;
    public int f0 = 0;
    public boolean h0 = true;
    public boolean l0 = d.a.m0.b.d.W();
    public d.a.n0.e2.i.c o0 = new d.a.n0.e2.i.c(new h());
    public AdapterView.OnItemLongClickListener p0 = new c();
    public AdapterView.OnItemClickListener q0 = new d();

    /* renamed from: d.a.n0.e2.k.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class RunnableC1275a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f53594e;

        public RunnableC1275a(boolean z) {
            this.f53594e = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.f53588d.setEnabled(this.f53594e);
        }
    }

    /* loaded from: classes5.dex */
    public class b implements y.d {
        public b() {
        }

        @Override // d.a.n0.e3.y.d
        public void onDraftLoaded(WriteData writeData) {
            a.this.T();
        }
    }

    /* loaded from: classes5.dex */
    public class c implements AdapterView.OnItemLongClickListener {
        public c() {
        }

        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j) {
            SparseArray<Object> sparseArray;
            PostData postData = (PostData) ListUtils.getItem(a.this.U, i2);
            if (view != null && view.getTag() != null) {
                if (a.this.d0 == null) {
                    a.this.d0 = new d0(a.this.f53590f.getPageContext(), a.this.M);
                }
                a.this.d0.l();
                try {
                    sparseArray = (SparseArray) view.getTag();
                } catch (ClassCastException e2) {
                    e2.printStackTrace();
                    sparseArray = null;
                }
                if (sparseArray == null) {
                    return true;
                }
                PostData postData2 = sparseArray.get(R.id.tag_clip_board) instanceof PostData ? (PostData) sparseArray.get(R.id.tag_clip_board) : null;
                boolean z = a.this.Z(sparseArray.get(R.id.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue() : false) && TbadkCoreApplication.isLogin();
                a.this.d0.p(sparseArray, a.this.g0.k0(), z, a.this.l0 && postData2 != null && postData2.h0, a.this.g0.T());
                if (z) {
                    a.this.d0.C().setVisibility(0);
                    a.this.d0.C().setTag(postData.E());
                } else {
                    a.this.d0.C().setVisibility(8);
                }
                a.this.d0.z().setVisibility(8);
            }
            return false;
        }
    }

    /* loaded from: classes5.dex */
    public class d implements AdapterView.OnItemClickListener {
        public d() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            if (a.this.f53590f != null && ViewHelper.checkUpIsLogin(a.this.f53590f.getPageContext().getPageActivity())) {
                if ((a.this.f53590f.mReplyPrivacyController != null && a.this.g0 != null && a.this.g0.R() != null && !a.this.f53590f.mReplyPrivacyController.checkPrivacyBeforeInvokeEditor(a.this.g0.R().replyPrivateFlag)) || a.this.g0 == null || a.this.S == null) {
                    return;
                }
                a.this.K0();
                if (view != null && (view.getTag() instanceof b.a)) {
                    a.this.s();
                    a.this.g0.J0();
                    return;
                }
                SparseArray sparseArray = (SparseArray) view.getTag();
                if (sparseArray != null) {
                    String str = (String) sparseArray.get(R.id.tag_photo_username);
                    String str2 = (String) sparseArray.get(R.id.tag_photo_userid);
                    if (str != null) {
                        a.this.S.S(str2);
                        a.this.S.R(str);
                    }
                }
                a.this.u();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.f53590f.finish();
        }
    }

    /* loaded from: classes5.dex */
    public class f implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f53600e;

        public f(int i2) {
            this.f53600e = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            int headerViewsCount = this.f53600e + a.this.f53588d.getHeaderViewsCount();
            if (headerViewsCount >= 1) {
                headerViewsCount--;
            }
            a.this.f53588d.setSelection(headerViewsCount);
        }
    }

    /* loaded from: classes5.dex */
    public class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.I != null) {
                a.this.f53585a.g();
            } else {
                a.this.f53590f.finish();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements c.a {
        public h() {
        }

        @Override // d.a.n0.e2.i.c.a
        public boolean a(View view, MotionEvent motionEvent) {
            return false;
        }

        @Override // d.a.n0.e2.i.c.a
        public boolean b(View view, MotionEvent motionEvent) {
            return true;
        }

        @Override // d.a.n0.e2.i.c.a
        public boolean c(View view, MotionEvent motionEvent) {
            a.this.x(false);
            a.this.x(true);
            return true;
        }
    }

    /* loaded from: classes5.dex */
    public class i implements View.OnClickListener {
        public i() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.K != null && (a.this.K instanceof Dialog)) {
                d.a.c.e.m.g.b(a.this.K, a.this.f53590f.getPageContext());
            }
            SparseArray sparseArray = (SparseArray) view.getTag();
            if (sparseArray == null) {
                return;
            }
            a.this.g0(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue(), false);
        }
    }

    /* loaded from: classes5.dex */
    public class j implements View.OnClickListener {
        public j() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.K != null && (a.this.K instanceof Dialog)) {
                d.a.c.e.m.g.b(a.this.K, a.this.f53590f.getPageContext());
            }
            SparseArray sparseArray = (SparseArray) view.getTag();
            if (sparseArray == null || a.this.Q == null) {
                return;
            }
            a.this.Q.a(new Object[]{sparseArray.get(R.id.tag_manage_user_identity), sparseArray.get(R.id.tag_forbid_user_name), sparseArray.get(R.id.tag_forbid_user_post_id), sparseArray.get(R.id.tag_forbid_user_name_show), sparseArray.get(R.id.tag_forbid_user_portrait)});
        }
    }

    /* loaded from: classes5.dex */
    public class k implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f53606e;

        public k(boolean z) {
            this.f53606e = z;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.K != null && (a.this.K instanceof Dialog)) {
                d.a.c.e.m.g.b(a.this.K, a.this.f53590f.getPageContext());
            }
            SparseArray<Object> sparseArray = (SparseArray) view.getTag();
            if (sparseArray == null) {
                return;
            }
            a.this.f53590f.handleMuteClick(this.f53606e, (String) sparseArray.get(R.id.tag_user_mute_mute_userid), sparseArray);
        }
    }

    /* loaded from: classes5.dex */
    public class l implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SparseArray f53608e;

        public l(SparseArray sparseArray) {
            this.f53608e = sparseArray;
        }

        @Override // d.a.m0.r.s.a.e
        public void onClick(d.a.m0.r.s.a aVar) {
            if (a.this.R != null) {
                a.this.R.a(new Object[]{this.f53608e.get(R.id.tag_del_post_id), this.f53608e.get(R.id.tag_manage_user_identity), this.f53608e.get(R.id.tag_del_post_is_self), this.f53608e.get(R.id.tag_del_post_type)});
            }
            aVar.dismiss();
        }
    }

    /* loaded from: classes5.dex */
    public class m implements a.e {
        public m(a aVar) {
        }

        @Override // d.a.m0.r.s.a.e
        public void onClick(d.a.m0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    /* loaded from: classes5.dex */
    public class n implements f.g {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SparseArray f53610a;

        public n(SparseArray sparseArray) {
            this.f53610a = sparseArray;
        }

        @Override // d.a.n0.h.f.g
        public void a(JSONArray jSONArray) {
            String JsonArrayToString = StringHelper.JsonArrayToString(jSONArray);
            if (a.this.R != null) {
                a.this.R.a(new Object[]{this.f53610a.get(R.id.tag_del_post_id), this.f53610a.get(R.id.tag_manage_user_identity), this.f53610a.get(R.id.tag_del_post_is_self), this.f53610a.get(R.id.tag_del_post_type), JsonArrayToString});
            }
        }
    }

    /* loaded from: classes5.dex */
    public class o implements i.h {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SparseArray f53612a;

        public o(SparseArray sparseArray) {
            this.f53612a = sparseArray;
        }

        @Override // d.a.n0.h.i.h
        public void a(JSONArray jSONArray) {
            String JsonArrayToString = StringHelper.JsonArrayToString(jSONArray);
            if (a.this.R != null) {
                a.this.R.a(new Object[]{this.f53612a.get(R.id.tag_del_post_id), this.f53612a.get(R.id.tag_manage_user_identity), this.f53612a.get(R.id.tag_del_post_is_self), this.f53612a.get(R.id.tag_del_post_type), JsonArrayToString});
            }
        }
    }

    public a(NewSubPbActivity newSubPbActivity, View.OnClickListener onClickListener) {
        this.f53585a = null;
        this.f53587c = null;
        this.f53588d = null;
        this.f53589e = null;
        this.f53590f = null;
        this.f53591g = null;
        this.j = null;
        this.r = null;
        this.C = null;
        this.H = null;
        this.M = null;
        this.P = null;
        this.W = null;
        this.X = null;
        this.Y = null;
        this.Z = null;
        this.f53590f = newSubPbActivity;
        this.M = onClickListener;
        this.f53585a = (SubPbView) LayoutInflater.from(newSubPbActivity.getPageContext().getPageActivity()).inflate(R.layout.new_sub_pb_layout, (ViewGroup) null);
        this.f53587c = LayoutInflater.from(this.f53590f.getPageContext().getPageActivity()).inflate(R.layout.new_sub_pb_head, (ViewGroup) null);
        this.f53586b = (LinearLayout) this.f53585a.findViewById(R.id.navigation_bar_group);
        this.X = (RelativeLayout) this.f53585a.findViewById(R.id.subpb_editor_tool_comment);
        TextView textView = (TextView) this.f53585a.findViewById(R.id.subpb_editor_tool_comment_reply_text);
        this.W = textView;
        textView.setOnClickListener(this.M);
        this.Y = (ImageView) this.f53585a.findViewById(R.id.subpb_editor_tool_more_img);
        ImageView imageView = (ImageView) this.f53585a.findViewById(R.id.subpb_editor_tool_emotion_img);
        this.Z = imageView;
        imageView.setOnClickListener(this.M);
        this.Y.setOnClickListener(this.M);
        this.f53591g = (NoNetworkView) this.f53585a.findViewById(R.id.view_no_network);
        V();
        U();
        this.j = (RelativeLayout) this.f53585a.findViewById(R.id.sub_pb_body_layout);
        this.f53588d = (BdTypeListView) this.f53585a.findViewById(R.id.new_sub_pb_list);
        ThreadSkinView threadSkinView = (ThreadSkinView) LayoutInflater.from(this.f53590f.getPageContext().getPageActivity()).inflate(R.layout.thread_skin_layout, (ViewGroup) null);
        this.A = threadSkinView;
        this.f53588d.addHeaderView(threadSkinView);
        this.f53588d.addHeaderView(this.f53587c);
        this.J = new TextView(newSubPbActivity.getActivity());
        this.J.setLayoutParams(new AbsListView.LayoutParams(-1, 20));
        this.f53588d.x(this.J, 0);
        this.f53585a.setTopView(this.J);
        this.f53585a.setNavigationView(this.f53586b);
        this.f53585a.setListView(this.f53588d);
        this.f53585a.setContentView(this.j);
        d.a.n0.e2.k.g.d dVar = new d.a.n0.e2.k.g.d(this.f53590f.getPageContext());
        this.C = dVar;
        dVar.v();
        this.H = this.C.b();
        this.f53588d.setNextPage(this.C);
        this.C.z(this.M);
        this.f53588d.setOnItemClickListener(this.q0);
        this.f53588d.setOnItemLongClickListener(this.p0);
        this.f53588d.setOnTouchListener(this.o0);
        d.a.n0.e2.p.i iVar = new d.a.n0.e2.p.i(newSubPbActivity.getPageContext());
        this.f53589e = iVar;
        iVar.n();
        this.f53589e.a(this.m0);
        this.f53589e.I(TbadkCoreApplication.getInst().getSkinType());
        this.P = (ProgressBar) this.f53585a.findViewById(R.id.progress);
        this.n0 = (MaskView) this.f53585a.findViewById(R.id.mask_view);
        this.c0 = this.f53585a.findViewById(R.id.view_comment_top_line);
        this.a0 = (LinearLayout) this.f53585a.findViewById(R.id.pb_editer_tool_comment_layout);
        HeadImageView headImageView = (HeadImageView) this.f53585a.findViewById(R.id.pb_editor_tool_comment_user_image);
        this.b0 = headImageView;
        headImageView.setVisibility(0);
        this.b0.setIsRound(true);
        this.b0.setBorderWidth(d.a.c.e.p.l.g(this.f53590f, R.dimen.L_X01));
        this.b0.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
        this.b0.setDefaultBgResource(0);
        this.b0.setDefaultResource(R.color.CAM_X0205);
        if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
            this.b0.V(TbadkCoreApplication.getCurrentAccountInfo().getAvatar(), 12, false);
        }
        e0(TbadkCoreApplication.getInst().getSkinType());
        View view = this.f53587c;
        if (view != null) {
            view.setVisibility(4);
        }
        View a2 = d.a.m0.d.c.b().a(this.f53590f.getActivity(), 4);
        this.r = a2;
        if (a2 != null) {
            a2.setVisibility(8);
            this.o.addView(this.r, 3);
        }
        d.a.n0.e2.k.g.c cVar = new d.a.n0.e2.k.g.c(this.f53590f, this.f53588d);
        this.k0 = cVar;
        cVar.f(this.O);
        this.k0.d(this.M);
        this.k0.b();
    }

    public int A() {
        BlankView blankView = this.I;
        if (blankView == null) {
            return 0;
        }
        return blankView.getHeight();
    }

    public void A0() {
        if (this.B == null) {
            this.B = new d.a.m0.r.f0.a(this.f53590f.getPageContext());
        }
        this.B.h(true);
    }

    public int B() {
        d.a.m0.w.w.h hVar = this.S;
        if (hVar == null || hVar.a() == null) {
            return 0;
        }
        return this.S.a().getHeight();
    }

    public final void B0(SparseArray<Object> sparseArray, d.a.n0.h.h hVar, UserData userData) {
        AntiData R;
        NewSubPbActivity newSubPbActivity = this.f53590f;
        if (newSubPbActivity == null || sparseArray == null || this.f53587c == null) {
            return;
        }
        if (this.j0 == null) {
            this.j0 = new d.a.n0.h.i(newSubPbActivity.getPageContext(), this.f53587c, hVar, userData);
        }
        SparseArray<String> sparseArray2 = new SparseArray<>();
        SubPbModel subPbModel = this.g0;
        if (subPbModel != null && (R = subPbModel.R()) != null && R.getDelThreadInfoList() != null) {
            List<DeleteThreadInfo> delThreadInfoList = R.getDelThreadInfoList();
            for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                    sparseArray2.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                }
            }
        }
        v0 v0Var = new v0();
        v0Var.j(sparseArray2);
        this.j0.B(new String[]{this.f53590f.getString(R.string.delete_thread_reason_1), this.f53590f.getString(R.string.delete_thread_reason_2), this.f53590f.getString(R.string.delete_thread_reason_3), this.f53590f.getString(R.string.delete_thread_reason_4), this.f53590f.getString(R.string.delete_thread_reason_5)});
        this.j0.A(v0Var);
        this.j0.D("4");
        this.j0.C(new o(sparseArray));
    }

    public View C() {
        return this.x;
    }

    public void C0(int i2) {
        W(NoDataViewFactory.e.d(null, this.f53590f.getResources().getString(R.string.refresh_view_title_text)));
        this.X.setVisibility(8);
    }

    public View D() {
        return this.n;
    }

    public void D0(String str, boolean z) {
        if (z) {
            W(NoDataViewFactory.e.d("", str));
        } else {
            W(NoDataViewFactory.e.d(str, this.f53590f.getPageContext().getString(R.string.refresh_view_title_text)));
        }
        this.X.setVisibility(8);
    }

    public View E() {
        return this.f53587c;
    }

    public void E0(b.c cVar, boolean z) {
        d.a.m0.r.s.b bVar = this.N;
        if (bVar != null) {
            bVar.e();
            this.N = null;
        }
        d.a.m0.r.s.b bVar2 = new d.a.m0.r.s.b(this.f53590f.getPageContext().getPageActivity());
        this.N = bVar2;
        if (z) {
            bVar2.j(new String[]{this.f53590f.getPageContext().getString(R.string.save_to_emotion)}, cVar);
        } else {
            bVar2.j(new String[]{this.f53590f.getPageContext().getString(R.string.save_to_emotion), this.f53590f.getPageContext().getString(R.string.save_to_local)}, cVar);
        }
        this.N.c(this.f53590f.getPageContext());
        this.N.m();
    }

    public View F() {
        return this.o;
    }

    public final void F0(SparseArray<Object> sparseArray) {
        AntiData R;
        NewSubPbActivity newSubPbActivity = this.f53590f;
        if (newSubPbActivity == null || sparseArray == null || this.f53587c == null) {
            return;
        }
        if (this.i0 == null) {
            this.i0 = new d.a.n0.h.f(newSubPbActivity.getPageContext(), this.f53587c);
        }
        SparseArray<String> sparseArray2 = new SparseArray<>();
        SubPbModel subPbModel = this.g0;
        if (subPbModel != null && (R = subPbModel.R()) != null && R.getDelThreadInfoList() != null) {
            List<DeleteThreadInfo> delThreadInfoList = R.getDelThreadInfoList();
            for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                    sparseArray2.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                }
            }
        }
        v0 v0Var = new v0();
        v0Var.j(sparseArray2);
        this.i0.x(new String[]{this.f53590f.getString(R.string.delete_thread_reason_1), this.f53590f.getString(R.string.delete_thread_reason_2), this.f53590f.getString(R.string.delete_thread_reason_3), this.f53590f.getString(R.string.delete_thread_reason_4), this.f53590f.getString(R.string.delete_thread_reason_5)});
        this.i0.w(v0Var);
        this.i0.z("4");
        this.i0.y(new n(sparseArray));
    }

    public ListView G() {
        return this.f53588d;
    }

    public void G0() {
        this.f53588d.setNextPage(this.C);
        this.C.O();
    }

    public View H() {
        return this.H;
    }

    public void H0(r rVar, int i2, boolean z, boolean z2) {
        int i3;
        int i4;
        int i5;
        View view;
        if (rVar == null) {
            return;
        }
        if (this.h0 && (view = this.f53587c) != null) {
            view.setVisibility(8);
            this.f53588d.removeHeaderView(this.f53587c);
            this.e0 = 1;
        }
        this.V = rVar;
        if (rVar.i() != null) {
            this.V.i().h0 = true;
        }
        View view2 = this.f53587c;
        if (view2 != null) {
            view2.setVisibility(0);
        }
        if (rVar.l() != null && rVar.l().B2()) {
            this.n.setText(R.string.view_original);
        } else {
            this.n.setText(R.string.view_subject);
        }
        if (rVar.i() != null) {
            int A = rVar.i().A();
            this.T = A;
            if (A > 0) {
                this.k.setCenterTextTitle(String.format(this.f53590f.getResources().getString(R.string.subpb_floor_reply), Integer.valueOf(this.T)));
                NewSubPbActivity newSubPbActivity = this.f53590f;
                if (newSubPbActivity != null) {
                    this.W.setText(newSubPbActivity.getReplyHint());
                }
            } else {
                this.k.setCenterTextTitle(this.f53590f.getResources().getString(R.string.local_floor_reply));
            }
            String str = this.f53590f.isFromPb() ? "PB" : null;
            if (rVar.i().L() != null) {
                this.A.setData(this.f53590f.getPageContext(), rVar.i().L(), d.a.n0.e3.j0.a.a("PB", "c0132", rVar.d().getId(), rVar.d().getName(), rVar.l().o0(), str));
            } else {
                this.A.setData(null, null, null);
            }
        }
        if (rVar.o()) {
            this.C.O();
            this.k0.g(true);
        } else {
            this.C.f();
            this.k0.g(false);
        }
        ArrayList<PostData> k2 = rVar.k();
        this.U = k2;
        if (k2 == null || k2.size() <= r0) {
            i3 = 0;
            i4 = 0;
            i5 = 0;
        } else {
            int size = this.U.size() - r0;
            j0(size);
            int firstVisiblePosition = this.f53588d.getFirstVisiblePosition() - size;
            View childAt = this.f53588d.getChildAt(0);
            i3 = size;
            i4 = firstVisiblePosition;
            i5 = childAt == null ? 0 : childAt.getTop();
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.U);
        if (ListUtils.isEmpty(this.U)) {
            this.f53588d.setNextPage(null);
            if (this.h0) {
                arrayList.add(0, new d.a.n0.e2.k.g.f.a());
            }
        } else {
            this.f53588d.setNextPage(this.C);
        }
        d.a.n0.e2.k.g.f.b bVar = new d.a.n0.e2.k.g.f.b();
        bVar.e(rVar.m());
        arrayList.add(0, bVar);
        if (this.h0) {
            arrayList.add(0, rVar.i());
        }
        NewSubPbActivity newSubPbActivity2 = this.f53590f;
        if (newSubPbActivity2 != null && newSubPbActivity2.getSubPbModel() != null) {
            this.n0.setVisibility(this.f53590f.getSubPbModel().q0() ? 0 : 8);
        }
        this.k0.e(this.V.l(), arrayList);
        y(rVar, rVar.i(), rVar.e(), rVar.f(), i2, z);
        if (i3 > 0) {
            this.f53588d.setSelectionFromTop(i4, i5);
        } else if (z2 && !d.a.c.e.p.k.isEmpty(this.f53590f.getSubPbModel().Y())) {
            String Y = this.f53590f.getSubPbModel().Y();
            int i6 = 0;
            while (true) {
                if (i6 < arrayList.size()) {
                    if ((arrayList.get(i6) instanceof PostData) && Y.equals(((PostData) arrayList.get(i6)).E())) {
                        this.f53588d.post(new f(i6));
                        break;
                    }
                    i6++;
                } else {
                    break;
                }
            }
        }
        if (this.V.j() > 1) {
            this.f53588d.setPullRefresh(this.f53589e);
            this.f53585a.setEnableDragExit(false);
            return;
        }
        this.f53588d.setPullRefresh(null);
        this.f53585a.setEnableDragExit(true);
    }

    public int I() {
        NavigationBar navigationBar = this.k;
        if (navigationBar == null) {
            return 0;
        }
        return navigationBar.getHeight();
    }

    public boolean I0() {
        return this.k0.a();
    }

    public d0 J() {
        return this.d0;
    }

    public final void J0(MetaData metaData) {
        if (metaData == null) {
            return;
        }
        String name_show = metaData.getName_show();
        if (i0.b(name_show) + (!StringUtils.isNull(metaData.getSealPrefix()) ? d.a.c.e.p.k.byteLength(metaData.getSealPrefix()) + 2 : 0) > 14) {
            String k2 = i0.k(name_show, 0, 14);
            if (k2.length() == name_show.length()) {
                name_show = k2;
            } else {
                name_show = k2 + StringHelper.STRING_MORE;
            }
        }
        if (!StringUtils.isNull(metaData.getSealPrefix())) {
            this.q.setText(Q(metaData.getSealPrefix(), name_show));
        } else {
            this.q.setText(name_show);
        }
        if (metaData.getAlaUserData() != null && this.r != null) {
            if (metaData.getAlaUserData().anchor_live == 0) {
                this.r.setVisibility(8);
            } else {
                this.r.setVisibility(0);
                d.a.m0.d.b bVar = new d.a.m0.d.b();
                bVar.f49262a = metaData.getAlaUserData();
                bVar.f49263b = 4;
                this.r.setTag(bVar);
            }
        }
        if (metaData.isBigV()) {
            SkinManager.setViewTextColor(this.q, R.color.cp_cont_r);
        } else if (d.a.m0.b.d.x()) {
            d.a.m0.r.u.c.d(this.q).s(R.color.CAM_X0108);
        } else {
            d.a.m0.r.u.c.d(this.q).s(R.color.CAM_X0106);
        }
        this.p.setVisibility(0);
        this.p.setUserId(metaData.getUserId());
        this.p.setUserName(metaData.getUserName());
        this.p.setDefaultResource(R.drawable.transparent_bg);
        UtilHelper.showHeadImageViewBigV(this.p, metaData);
        this.p.V(metaData.getAvater(), 28, false);
        this.o.setTag(R.id.tag_user_id, metaData.getUserId());
        this.o.setTag(R.id.tag_user_name, metaData.getUserName());
        this.o.setTag(R.id.tag_virtual_user_url, metaData.getVirtualUserUrl());
    }

    public ImageView K() {
        return this.Z;
    }

    public void K0() {
        BdTypeListView bdTypeListView = this.f53588d;
        if (bdTypeListView != null) {
            this.f0 = bdTypeListView.getLastVisiblePosition();
        }
    }

    public ImageView L() {
        return this.Y;
    }

    public void L0(boolean z) {
        d0 d0Var = this.d0;
        if (d0Var == null || d0Var.z() == null) {
            return;
        }
        if (z) {
            this.d0.z().setText(R.string.remove_mark);
        } else {
            this.d0.z().setText(R.string.mark);
        }
    }

    public MorePopupWindow M() {
        return this.E;
    }

    public TextView N() {
        return this.W;
    }

    public TextView O() {
        return this.w;
    }

    public View P() {
        return this.f53585a;
    }

    public final SpannableStringBuilder Q(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 == null || str == null) {
            return spannableStringBuilder;
        }
        arrayList.add(new m.a(str, R.drawable.pic_smalldot_title));
        return d.a.n0.z.m.h(this.f53590f.getActivity(), str2, arrayList, true);
    }

    public void R() {
        d.a.m0.r.f0.a aVar = this.B;
        if (aVar != null) {
            aVar.h(false);
        }
    }

    public void S() {
        NoDataView noDataView = this.f53592h;
        if (noDataView != null) {
            noDataView.setVisibility(8);
            this.f53588d.setVisibility(0);
            this.X.setVisibility(0);
            this.f53585a.setOnTouchListener(null);
        }
    }

    public void T() {
        d.a.m0.w.w.h hVar;
        if (this.W == null || (hVar = this.S) == null) {
            return;
        }
        if (hVar.u()) {
            this.W.setText(R.string.draft_to_send);
        } else {
            this.W.setText(this.f53590f.getReplyHint());
        }
    }

    public void U() {
        LinearLayout linearLayout = (LinearLayout) this.f53587c.findViewById(R.id.subpb_head_user_info_root);
        this.o = linearLayout;
        linearLayout.setOnClickListener(this.M);
        HeadImageView headImageView = (HeadImageView) this.f53587c.findViewById(R.id.photo);
        this.p = headImageView;
        headImageView.setRadius(d.a.c.e.p.l.g(this.f53590f.getActivity(), R.dimen.tbds45));
        this.p.setClickable(false);
        this.q = (TextView) this.f53587c.findViewById(R.id.user_name);
        ImageView imageView = (ImageView) this.f53587c.findViewById(R.id.user_rank);
        this.s = imageView;
        imageView.setVisibility(8);
        this.t = (TextView) this.f53587c.findViewById(R.id.floor_owner);
        TextView textView = (TextView) this.f53587c.findViewById(R.id.see_subject);
        this.n = textView;
        textView.setOnClickListener(this.M);
        this.u = (TextView) this.f53587c.findViewById(R.id.floor);
        this.v = (TextView) this.f53587c.findViewById(R.id.time);
        EllipsizeRichTextView ellipsizeRichTextView = (EllipsizeRichTextView) this.f53587c.findViewById(R.id.content_text);
        this.w = ellipsizeRichTextView;
        ellipsizeRichTextView.setOnClickListener(this.M);
        SkinManager.setViewTextColor(this.w, R.color.CAM_X0105);
        this.w.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
        this.w.setLineSpacing(0.0f, 1.25f);
        TbImageView tbImageView = (TbImageView) this.f53587c.findViewById(R.id.sub_pb_image);
        this.x = tbImageView;
        tbImageView.setOnClickListener(this.M);
        this.z = (TextView) this.f53587c.findViewById(R.id.advert);
        this.y = (PlayVoiceBntNew) this.f53587c.findViewById(R.id.voice_btn);
        this.f53587c.setOnTouchListener(this.o0);
        this.f53587c.setOnClickListener(this.M);
    }

    public void V() {
        int g2 = d.a.c.e.p.l.g(this.f53590f.getPageContext().getPageActivity(), R.dimen.ds88);
        int g3 = d.a.c.e.p.l.g(this.f53590f.getPageContext().getPageActivity(), R.dimen.ds2);
        NavigationBar navigationBar = (NavigationBar) this.f53585a.findViewById(R.id.view_navigation_bar);
        this.k = navigationBar;
        this.m = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new g());
        ImageView backImageView = this.k.getBackImageView();
        this.l = backImageView;
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.m.getLayoutParams();
            layoutParams.height = g2;
            layoutParams.width = g2;
            layoutParams.leftMargin = g3;
            backImageView.setLayoutParams(layoutParams);
        }
        View view = this.m;
        if (view != null && (view.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.m.getLayoutParams();
            layoutParams2.width = g2;
            layoutParams2.height = g2;
            this.m.setLayoutParams(layoutParams2);
        }
        this.k.hideBottomLine();
    }

    public final void W(NoDataViewFactory.e eVar) {
        NoDataViewFactory.c a2 = NoDataViewFactory.c.a(new NoDataViewFactory.b(this.f53590f.getPageContext().getString(R.string.refresh_view_button_text), this.f53593i));
        if (this.f53592h == null) {
            Activity pageActivity = this.f53590f.getPageContext().getPageActivity();
            this.f53592h = NoDataViewFactory.a(pageActivity, this.j, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NETERROR, d.a.c.e.p.l.g(pageActivity, R.dimen.ds250)), eVar, a2);
        }
        this.f53588d.setVisibility(8);
        this.P.setVisibility(8);
        this.S.w();
        SkinManager.setBackgroundColor(this.f53592h, R.color.CAM_X0201);
        this.f53592h.setClickable(true);
        this.f53592h.setTextOption(eVar);
        this.f53592h.f(this.f53590f.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.f53592h.setVisibility(0);
    }

    public void X(d.a.m0.w.w.h hVar) {
        if (hVar == null || hVar.a() == null) {
            return;
        }
        this.S = hVar;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        this.j.addView(hVar.a(), layoutParams);
        this.S.O(new b());
    }

    public boolean Y() {
        return this.f53585a.e();
    }

    public final boolean Z(boolean z) {
        SubPbModel subPbModel = this.g0;
        if (subPbModel == null || subPbModel.T() == null) {
            return false;
        }
        if (this.g0.k0() != 0) {
            return false;
        }
        r rVar = this.V;
        return (rVar == null || rVar.l() == null || this.V.l().T() == null || !TextUtils.equals(this.V.l().T().getUserId(), TbadkCoreApplication.getCurrentAccount())) && !z;
    }

    @Override // com.baidu.tieba.pb.view.KeyboardEventLayout.a
    public void a(int i2) {
    }

    public void a0() {
        d.a.n0.e2.k.g.c cVar = this.k0;
        if (cVar != null) {
            cVar.c();
        }
    }

    public void b0() {
        SubPbView subPbView = this.f53585a;
        if (subPbView != null) {
            subPbView.f();
        }
        d.a.m0.w.w.h hVar = this.S;
        if (hVar != null) {
            hVar.B();
        }
    }

    public void c0() {
    }

    public void d0() {
    }

    public void e0(int i2) {
        this.f53590f.getLayoutMode().k(i2 == 1);
        this.f53590f.getLayoutMode().j(this.f53585a);
        this.f53590f.getLayoutMode().j(this.f53587c);
        SkinManager.setBackgroundColor(this.f53585a, R.color.CAM_X0201);
        SkinManager.setBackgroundColor(this.j, R.color.CAM_X0201);
        this.k.onChangeSkinType(this.f53590f.getPageContext(), i2);
        WebPManager.setPureDrawable(this.l, R.drawable.icon_pure_topbar_close44, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
        TextView textView = this.n;
        if (textView != null) {
            SkinManager.setViewTextColor(textView, R.color.goto_see_subject_color);
        }
        this.f53591g.c(this.f53590f.getPageContext(), i2);
        this.f53590f.getLayoutMode().j(this.H);
        SkinManager.setViewTextColor(this.w, R.color.CAM_X0105);
        this.w.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
        d.a.m0.w.w.h hVar = this.S;
        if (hVar != null && hVar.a() != null) {
            this.S.a().w(i2);
        }
        this.C.d(i2);
        this.y.b();
        SkinManager.setViewTextColor(this.W, R.color.CAM_X0110);
        SkinManager.setViewTextColor(this.t, R.color.CAM_X0302);
        if (d.a.m0.b.d.x()) {
            d.a.m0.r.u.c.d(this.q).x(R.string.F_X02);
            d.a.m0.r.u.c.d(this.q).s(R.color.CAM_X0108);
        } else {
            d.a.m0.r.u.c.d(this.q).x(R.string.F_X01);
            SkinManager.setViewTextColor(this.q, R.color.CAM_X0106);
        }
        this.W.setAlpha(0.95f);
        if (this.D != null) {
            d.a.m0.s0.a.a(this.f53590f.getPageContext(), this.D);
        }
        d.a.n0.e2.k.g.c cVar = this.k0;
        if (cVar != null) {
            cVar.c();
        }
        this.f53590f.getLayoutMode().j(this.F);
        SkinManager.setBackgroundColor(this.c0, R.color.CAM_X0203);
        this.b0.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
        this.a0.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(d.a.c.e.p.l.g(this.f53590f, R.dimen.tbds47), SkinManager.getColor(R.color.CAM_X0209)));
    }

    public void f0() {
        if (this.f53590f.isPaused()) {
        }
    }

    public void g0(int i2, String str, int i3, boolean z, boolean z2) {
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(R.id.tag_del_post_id, str);
        sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i2));
        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i3));
        sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z));
        int i4 = R.string.del_all_post_confirm;
        if (i3 == 1002 && !z) {
            i4 = R.string.report_post_confirm;
        }
        if (i2 == 0) {
            if (i3 == 1002 && !z) {
                i4 = R.string.report_thread_confirm;
            } else {
                i4 = R.string.del_thread_confirm;
            }
        }
        d.a.m0.r.s.a aVar = new d.a.m0.r.s.a(this.f53590f.getPageContext().getPageActivity());
        this.L = aVar;
        aVar.setMessageId(i4);
        this.L.setYesButtonTag(sparseArray);
        this.L.setPositiveButton(R.string.dialog_ok, new l(sparseArray));
        this.L.setNegativeButton(R.string.dialog_cancel, new m(this));
        this.L.setCancelable(true);
        this.L.create(this.f53590f.getPageContext());
        if (z2) {
            this.L.show();
        } else if (z) {
            this.L.show();
        } else if (1 == this.g0.V()) {
            d.a.n0.h.h hVar = new d.a.n0.h.h(this.g0.V(), this.g0.U(), this.g0.X());
            hVar.i(this.V.d().getId(), this.V.d().getName());
            hVar.h(this.g0.W());
            hVar.j(this.g0.l0());
            UserData userData = new UserData();
            userData.setIsManager(this.g0.Z());
            B0(sparseArray, hVar, userData);
        } else {
            F0(sparseArray);
        }
    }

    public void h0(SparseArray<Object> sparseArray, boolean z) {
        boolean z2 = true;
        if (this.K == null) {
            Dialog dialog = new Dialog(this.f53590f.getPageContext().getPageActivity(), R.style.common_alert_dialog);
            this.K = dialog;
            dialog.setCanceledOnTouchOutside(true);
            this.K.setCancelable(true);
            this.F = LayoutInflater.from(this.f53590f.getPageContext().getPageActivity()).inflate(R.layout.forum_manage_dialog, (ViewGroup) null);
            this.f53590f.getLayoutMode().j(this.F);
            this.K.setContentView(this.F);
            WindowManager.LayoutParams attributes = this.K.getWindow().getAttributes();
            attributes.width = (int) (d.a.c.e.p.l.k(this.f53590f.getPageContext().getPageActivity()) * 0.9d);
            this.K.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.K.findViewById(R.id.del_post_btn);
        TextView textView2 = (TextView) this.K.findViewById(R.id.forbid_user_btn);
        TextView textView3 = (TextView) this.K.findViewById(R.id.disable_reply_btn);
        int intValue = sparseArray.get(R.id.tag_check_mute_from) instanceof Integer ? ((Integer) sparseArray.get(R.id.tag_check_mute_from)).intValue() : -1;
        if (!"".equals(sparseArray.get(R.id.tag_del_post_id)) && intValue != 2) {
            SparseArray sparseArray2 = (SparseArray) textView.getTag();
            if (sparseArray2 == null) {
                sparseArray2 = new SparseArray();
                textView.setTag(sparseArray2);
            }
            textView.setVisibility(0);
            int i2 = R.id.tag_del_post_id;
            sparseArray2.put(i2, sparseArray.get(i2));
            int i3 = R.id.tag_del_post_type;
            sparseArray2.put(i3, sparseArray.get(i3));
            int i4 = R.id.tag_del_post_is_self;
            sparseArray2.put(i4, sparseArray.get(i4));
            int i5 = R.id.tag_manage_user_identity;
            sparseArray2.put(i5, sparseArray.get(i5));
            textView.setOnClickListener(new i());
        } else {
            textView.setVisibility(8);
        }
        if ("".equals(sparseArray.get(R.id.tag_forbid_user_name)) && "".equals(sparseArray.get(R.id.tag_forbid_user_name_show))) {
            textView2.setVisibility(8);
        } else {
            SparseArray sparseArray3 = (SparseArray) textView2.getTag();
            if (sparseArray3 == null) {
                sparseArray3 = new SparseArray();
                textView2.setTag(sparseArray3);
            }
            textView2.setVisibility(0);
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
            textView2.setOnClickListener(new j());
        }
        if (!(((sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue()) ? false : false)) {
            textView3.setVisibility(8);
        } else {
            SparseArray sparseArray4 = (SparseArray) textView3.getTag();
            if (sparseArray4 == null) {
                sparseArray4 = new SparseArray();
                textView3.setTag(sparseArray4);
            }
            textView3.setVisibility(0);
            if (z) {
                textView3.setText(R.string.un_mute);
            } else {
                textView3.setText(R.string.mute);
            }
            int i11 = R.id.tag_is_mem;
            sparseArray4.put(i11, sparseArray.get(i11));
            int i12 = R.id.tag_user_mute_mute_userid;
            sparseArray4.put(i12, sparseArray.get(i12));
            int i13 = R.id.tag_user_mute_mute_username;
            sparseArray4.put(i13, sparseArray.get(i13));
            int i14 = R.id.tag_user_mute_post_id;
            sparseArray4.put(i14, sparseArray.get(i14));
            int i15 = R.id.tag_user_mute_thread_id;
            sparseArray4.put(i15, sparseArray.get(i15));
            int i16 = R.id.tag_user_mute_mute_nameshow;
            sparseArray4.put(i16, sparseArray.get(i16));
            textView3.setOnClickListener(new k(z));
        }
        d.a.c.e.m.g.j(this.K, this.f53590f.getPageContext());
    }

    public void i0(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray == null) {
            return;
        }
        h0(sparseArray, false);
    }

    public final void j0(int i2) {
        ArrayList<PostData> arrayList = this.U;
        if (arrayList == null) {
            return;
        }
        if (arrayList.size() <= i2) {
            this.U.clear();
        }
        int i3 = 0;
        Iterator<PostData> it = this.U.iterator();
        while (it.hasNext()) {
            it.next();
            i3++;
            it.remove();
            if (i3 >= i2) {
                return;
            }
        }
    }

    public void k0(NewSubPbActivity.q0 q0Var) {
        this.R = q0Var;
    }

    public void l0() {
        this.f53588d.setVisibility(0);
        this.P.setVisibility(8);
        this.C.f();
    }

    public void m0(NewSubPbActivity.q0 q0Var) {
        this.Q = q0Var;
    }

    public void n0(boolean z) {
        this.h0 = z;
    }

    public void o0(f.g gVar) {
        this.m0 = gVar;
        d.a.n0.e2.p.i iVar = this.f53589e;
        if (iVar != null) {
            iVar.a(gVar);
        }
    }

    public void p0() {
        this.f53588d.setVisibility(0);
        this.P.setVisibility(8);
        this.C.P();
    }

    public void q0(SubPbModel subPbModel) {
        this.g0 = subPbModel;
    }

    public void r(boolean z) {
        SubPbModel subPbModel = this.g0;
        if (subPbModel == null || !subPbModel.p0() || z) {
            return;
        }
        this.k.setIsClose(true);
        this.k.setIsCorner(true);
        this.k.isShowBottomLine(true);
        this.k.setBottomLineHeight(3);
        this.k.setStatusBarVisibility(8);
        this.I = new BlankView(this.f53590f.getPageContext().getPageActivity());
        this.f53586b.addView(this.I, 0, new LinearLayout.LayoutParams(-1, d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.ds160)));
        this.I.setVisibility(0);
        this.I.setOnClickListener(new e());
        this.f53585a.setBlankView(this.I);
    }

    public void r0(TbRichTextView.x xVar) {
        this.k0.i(xVar);
    }

    public void s() {
        v0(this.f53590f);
        this.f53588d.setNextPage(this.C);
    }

    public void s0(View.OnLongClickListener onLongClickListener) {
        this.k0.h(onLongClickListener);
    }

    public void t(boolean z) {
        HeadImageView headImageView = this.b0;
        if (headImageView != null) {
            headImageView.V(TbadkCoreApplication.getCurrentAccountInfo() != null ? TbadkCoreApplication.getCurrentAccountInfo().getAvatar() : null, 12, false);
        }
    }

    public void t0(View.OnClickListener onClickListener) {
        this.f53593i = onClickListener;
    }

    public void u() {
        View view;
        if (this.g0 == null) {
            return;
        }
        if ((!I0() && (view = this.H) != null && view.isShown()) || ListUtils.isEmpty(this.U)) {
            this.g0.F0(false);
        } else {
            this.g0.F0(true);
        }
    }

    public void u0(AbsListView.OnScrollListener onScrollListener) {
        this.f53588d.setOnScrollListener(onScrollListener);
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x020f  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0248  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void v(PostData postData, int i2, SparseArray<Object> sparseArray) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        String userId;
        boolean z5;
        if (postData == null) {
            return;
        }
        if (sparseArray == null) {
            sparseArray = new SparseArray<>();
        }
        boolean z6 = true;
        if (i2 != 0) {
            if (i2 != 3) {
                z = true;
                z2 = true;
            } else {
                z = false;
                z2 = false;
            }
            String userId2 = postData.t().getUserId();
            if (userId2 != null && userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                z = false;
            }
            if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                z = false;
            }
        } else {
            z = false;
            z2 = false;
        }
        r rVar = this.V;
        if (rVar != null && rVar.l() != null && this.V.l().T() != null && postData.t() != null) {
            String userId3 = this.V.l().T().getUserId();
            String userId4 = postData.t().getUserId();
            if (!StringUtils.isNull(userId3) && userId3.equals(TbadkCoreApplication.getCurrentAccount())) {
                if (StringUtils.isNull(userId4) || !userId4.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z2 = true;
                    z3 = true;
                    z4 = false;
                    userId = postData.t().getUserId();
                    if (userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z2 = true;
                        z4 = true;
                    }
                    int i3 = postData.A() == 1 ? 0 : 1;
                    if (z) {
                        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i2));
                        sparseArray.put(R.id.tag_forbid_user_post_id, postData.E());
                        if (postData.t() != null) {
                            sparseArray.put(R.id.tag_forbid_user_name, postData.t().getUserName());
                            sparseArray.put(R.id.tag_forbid_user_name_show, postData.t().getName_show());
                            sparseArray.put(R.id.tag_forbid_user_portrait, postData.t().getPortrait());
                        }
                        z5 = true;
                    } else {
                        sparseArray.put(R.id.tag_forbid_user_name, "");
                        sparseArray.put(R.id.tag_forbid_user_name_show, "");
                        sparseArray.put(R.id.tag_forbid_user_portrait, "");
                        z5 = false;
                    }
                    if (z2) {
                        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i2));
                        sparseArray.put(R.id.tag_del_post_is_self, Boolean.TRUE);
                        sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i3));
                        sparseArray.put(R.id.tag_del_post_id, postData.E());
                    } else {
                        sparseArray.put(R.id.tag_del_post_is_self, Boolean.FALSE);
                        sparseArray.put(R.id.tag_del_post_type, 0);
                        sparseArray.put(R.id.tag_del_post_id, "");
                        z6 = z5;
                    }
                    sparseArray.put(R.id.tag_should_manage_visible, Boolean.valueOf(z6));
                    sparseArray.put(R.id.tag_forbid_user_post_id, postData.E());
                    if (z) {
                        sparseArray.put(R.id.tag_should_manage_visible, Boolean.TRUE);
                        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i2));
                        if (postData.t() != null) {
                            sparseArray.put(R.id.tag_forbid_user_name, postData.t().getUserName());
                            sparseArray.put(R.id.tag_forbid_user_name_show, postData.t().getName_show());
                            sparseArray.put(R.id.tag_forbid_user_portrait, postData.t().getPortrait());
                        }
                    } else {
                        sparseArray.put(R.id.tag_should_manage_visible, Boolean.FALSE);
                    }
                    if (z3) {
                        sparseArray.put(R.id.tag_user_mute_visible, Boolean.TRUE);
                        sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.t() != null) {
                            sparseArray.put(R.id.tag_user_mute_mute_userid, postData.t().getUserId());
                            sparseArray.put(R.id.tag_user_mute_mute_username, postData.t().getUserName());
                            sparseArray.put(R.id.tag_user_mute_mute_nameshow, postData.t().getName_show());
                        }
                        if (this.V.l() != null) {
                            sparseArray.put(R.id.tag_user_mute_thread_id, this.V.l().o0());
                        }
                        sparseArray.put(R.id.tag_user_mute_post_id, postData.E());
                    } else {
                        sparseArray.put(R.id.tag_user_mute_visible, Boolean.FALSE);
                    }
                    if (z2) {
                        sparseArray.put(R.id.tag_should_delete_visible, Boolean.TRUE);
                        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i2));
                        sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z4));
                        sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i3));
                        sparseArray.put(R.id.tag_del_post_id, postData.E());
                        sparseArray.put(R.id.tag_has_sub_post, Boolean.valueOf(postData.W()));
                        return;
                    }
                    sparseArray.put(R.id.tag_should_delete_visible, Boolean.FALSE);
                    return;
                }
                z2 = true;
                z3 = false;
                z4 = true;
                userId = postData.t().getUserId();
                if (userId != null) {
                    z2 = true;
                    z4 = true;
                }
                if (postData.A() == 1) {
                }
                if (z) {
                }
                if (z2) {
                }
                sparseArray.put(R.id.tag_should_manage_visible, Boolean.valueOf(z6));
                sparseArray.put(R.id.tag_forbid_user_post_id, postData.E());
                if (z) {
                }
                if (z3) {
                }
                if (z2) {
                }
            }
        }
        z3 = false;
        z4 = false;
        userId = postData.t().getUserId();
        if (userId != null) {
        }
        if (postData.A() == 1) {
        }
        if (z) {
        }
        if (z2) {
        }
        sparseArray.put(R.id.tag_should_manage_visible, Boolean.valueOf(z6));
        sparseArray.put(R.id.tag_forbid_user_post_id, postData.E());
        if (z) {
        }
        if (z3) {
        }
        if (z2) {
        }
    }

    public void v0(BdListView.p pVar) {
        this.f53588d.setOnSrollToBottomListener(pVar);
    }

    public void w() {
        MorePopupWindow morePopupWindow = this.E;
        if (morePopupWindow != null) {
            d.a.c.e.m.g.d(morePopupWindow, this.f53590f.getPageContext().getPageActivity());
        }
        d.a.m0.r.s.b bVar = this.G;
        if (bVar != null) {
            bVar.e();
        }
        d.a.m0.r.s.a aVar = this.L;
        if (aVar != null) {
            aVar.dismiss();
        }
        Dialog dialog = this.K;
        if (dialog != null) {
            d.a.c.e.m.g.b(dialog, this.f53590f.getPageContext());
        }
        ProgressBar progressBar = this.P;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
        d0 d0Var = this.d0;
        if (d0Var != null) {
            d0Var.dismiss();
        }
    }

    public void w0(View view) {
        this.D = view;
    }

    public final void x(boolean z) {
        BdTypeListView bdTypeListView = this.f53588d;
        if (bdTypeListView != null) {
            if (!z) {
                bdTypeListView.setEnabled(z);
            } else {
                bdTypeListView.postDelayed(new RunnableC1275a(z), 10L);
            }
        }
    }

    public void x0() {
        this.P.setVisibility(0);
    }

    public void y(r rVar, PostData postData, boolean z, boolean z2, int i2, boolean z3) {
        if (postData == null || this.h0) {
            return;
        }
        if (!StringUtils.isNull(postData.z())) {
            this.x.setVisibility(0);
            this.x.V(postData.z(), 10, true);
        } else {
            this.x.setVisibility(8);
        }
        d.a.n0.e3.h0.i v = postData.v();
        if (v != null && v.f54005a) {
            this.z.setVisibility(0);
        } else {
            this.z.setVisibility(8);
        }
        SparseArray<Object> sparseArray = (SparseArray) this.f53587c.getTag();
        if (sparseArray == null) {
            sparseArray = new SparseArray<>();
            this.f53587c.setTag(sparseArray);
        }
        sparseArray.clear();
        sparseArray.put(R.id.tag_clip_board, postData);
        sparseArray.put(R.id.tag_is_subpb, Boolean.FALSE);
        v(postData, i2, sparseArray);
        this.u.setText((CharSequence) null);
        this.q.setText((CharSequence) null);
        this.t.setVisibility(8);
        if (!this.h0) {
            J0(postData.t());
            if (z) {
                this.t.setVisibility(0);
                SkinManager.setViewTextColor(this.t, R.color.CAM_X0302);
            }
        }
        this.v.setText(StringHelper.getFormatTime(postData.R()));
        String format = String.format(this.f53590f.getPageContext().getString(R.string.is_floor), Integer.valueOf(postData.A()));
        if (rVar.l() != null && rVar.l().B2()) {
            this.u.setText((CharSequence) null);
        } else {
            this.u.setText(format);
        }
        postData.t().getUserTbVipInfoData();
        boolean y0 = y0(this.w, postData.K());
        if (StringUtils.isNull(postData.z()) && !y0 && postData.V() != null) {
            this.y.setVisibility(0);
            this.y.setTag(postData.V());
            return;
        }
        this.y.setVisibility(8);
    }

    public final boolean y0(TextView textView, TbRichText tbRichText) {
        if (textView != null && tbRichText != null && tbRichText.u() != null) {
            TbRichTextData tbRichTextData = new TbRichTextData(1);
            Iterator<TbRichTextData> it = tbRichText.u().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null) {
                    int type = next.getType();
                    if (type != 1) {
                        if (type != 2) {
                            if (type == 17) {
                                String str = next.u().mGifInfo.mSharpText;
                                if (str != null && str.startsWith(SmallTailInfo.EMOTION_PREFIX) && str.endsWith(SmallTailInfo.EMOTION_SUFFIX)) {
                                    String substring = str.substring(2, str.length() - 1);
                                    tbRichTextData.s("[" + substring + "]");
                                }
                            } else if (type != 18) {
                            }
                        }
                        tbRichTextData.J(true);
                        textView.setMovementMethod(d.a.n0.v3.c.a());
                    } else {
                        tbRichTextData.s(next.A());
                    }
                }
            }
            if (!tbRichTextData.F()) {
                textView.setMovementMethod(LinkMovementMethod.getInstance());
            }
            try {
                if (tbRichTextData.A() == null || tbRichTextData.A().length() <= 0) {
                    return false;
                }
                textView.setText(tbRichTextData.A());
                return true;
            } catch (Exception unused) {
                textView.setText("");
            }
        }
        return false;
    }

    public void z(int i2, boolean z, String str, boolean z2) {
        ProgressBar progressBar = this.P;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
        if (z && z2) {
            NewSubPbActivity newSubPbActivity = this.f53590f;
            newSubPbActivity.showToast(newSubPbActivity.getResources().getString(R.string.delete_success));
        } else if (str == null || !z2) {
        } else {
            this.f53590f.showToast(str);
        }
    }

    public void z0(PostData postData) {
        int i2;
        View view;
        if (postData == null) {
            return;
        }
        postData.n0(true);
        PostData postData2 = new PostData();
        postData2.r0(52);
        if (!I0() && (view = this.H) != null && view.isShown()) {
            i2 = (this.f0 - this.e0) - 1;
        } else {
            i2 = this.f0 - this.e0;
        }
        int count = ListUtils.getCount(this.U);
        if (i2 > count) {
            i2 = count;
        }
        ArrayList arrayList = new ArrayList(ListUtils.subList(this.U, 0, i2));
        ListUtils.add(arrayList, postData2);
        ListUtils.add(arrayList, postData);
        this.f53588d.smoothScrollToPosition(this.f0 + 2);
        this.f53588d.setNextPage(null);
    }
}

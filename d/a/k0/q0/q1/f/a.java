package d.a.k0.q0.q1.f;

import android.os.Build;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.android.internal.http.multipart.Part;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.upload.action.pb.IMPushPb;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumRulesShowActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.ForumRuleBaseData;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupEditText;
import com.baidu.tbadk.core.view.spanGroup.TbLinkSpanGroup;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.forumRule.ForumRulesEditActivity;
import com.baidu.tieba.frs.forumRule.view.ForumRuleDelItemDialogView;
import com.baidu.tieba.pb.pb.main.view.EditorScrollView;
import com.baidu.tieba.view.BdTopToast;
import d.a.j0.r.s.l;
import d.a.k0.q0.q1.f.b;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/* loaded from: classes4.dex */
public class a implements View.OnClickListener {
    public LinearLayout A;
    public LinearLayout B;
    public NavigationBar C;
    public TextView D;
    public TextView E;
    public TextView F;
    public d.a.k0.b0.e G;
    public EditorScrollView H;
    public BdTopToast K;
    public int M;
    public d.a.j0.r.s.j N;
    public d.a.j0.r.s.l O;

    /* renamed from: e  reason: collision with root package name */
    public final TbPageContext<?> f59293e;

    /* renamed from: f  reason: collision with root package name */
    public final String f59294f;

    /* renamed from: g  reason: collision with root package name */
    public final String f59295g;

    /* renamed from: h  reason: collision with root package name */
    public final String f59296h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.k0.q0.q1.b.b f59297i;
    public ForumRulesEditActivity j;
    public View k;
    public View l;
    public View m;
    public RelativeLayout n;
    public RelativeLayout o;
    public ImageView p;
    public ImageView q;
    public ImageView r;
    public EMTextView s;
    public EMTextView t;
    public EMTextView u;
    public EMTextView v;
    public EMTextView w;
    public EMTextView x;
    public EditText y;
    public EditText z;
    public List<d.a.k0.q0.q1.f.b> I = new ArrayList();
    public ForumRuleBaseData J = new ForumRuleBaseData();
    public boolean L = true;
    public boolean P = false;
    public Runnable Q = new d();
    public l.d R = new l();
    public l.d S = new C1525a();

    /* renamed from: d.a.k0.q0.q1.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1525a implements l.d {
        public C1525a() {
        }

        @Override // d.a.j0.r.s.l.d
        public void onClick() {
            a.this.B();
            if (a.this.j != null) {
                a.this.j.finish();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.j0.r.s.a f59299e;

        public b(a aVar, d.a.j0.r.s.a aVar2) {
            this.f59299e = aVar2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.a.j0.r.s.a aVar = this.f59299e;
            if (aVar != null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View.OnClickListener f59300e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.j0.r.s.a f59301f;

        public c(a aVar, View.OnClickListener onClickListener, d.a.j0.r.s.a aVar2) {
            this.f59300e = onClickListener;
            this.f59301f = aVar2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f59300e.onClick(view);
            d.a.j0.r.s.a aVar = this.f59301f;
            if (aVar != null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.s(true, null, false);
        }
    }

    /* loaded from: classes4.dex */
    public class e implements ViewTreeObserver.OnScrollChangedListener {
        public e() {
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            a.this.F();
            d.a.c.e.p.l.x(a.this.f59293e.getPageActivity(), a.this.y);
            d.a.c.e.p.l.x(a.this.f59293e.getPageActivity(), a.this.z);
        }
    }

    /* loaded from: classes4.dex */
    public class f implements TextWatcher {
        public f() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            int length = editable.toString().length();
            a.this.Y(length);
            a.R(a.this.u, length, 50);
            a.this.M();
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }
    }

    /* loaded from: classes4.dex */
    public class g implements TextWatcher {

        /* renamed from: d.a.k0.q0.q1.f.a$g$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class View$OnTouchListenerC1526a implements View.OnTouchListener {
            public View$OnTouchListenerC1526a(g gVar) {
            }

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    view.getParent().requestDisallowInterceptTouchEvent(true);
                } else if (motionEvent.getAction() == 1) {
                    view.getParent().requestDisallowInterceptTouchEvent(false);
                } else if (motionEvent.getAction() == 3) {
                    view.getParent().requestDisallowInterceptTouchEvent(false);
                }
                return false;
            }
        }

        public g() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            int length = editable.toString().length();
            a.this.t(length);
            a.R(a.this.w, length, 500);
            a.this.M();
            if (a.this.z.getLineCount() > 6) {
                a.this.z.setOnTouchListener(new View$OnTouchListenerC1526a(this));
            } else {
                a.this.z.setOnTouchListener(null);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }
    }

    /* loaded from: classes4.dex */
    public class h implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.k0.q0.q1.f.b f59306e;

        /* renamed from: d.a.k0.q0.q1.f.a$h$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class View$OnClickListenerC1527a implements View.OnClickListener {
            public View$OnClickListenerC1527a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                h hVar = h.this;
                a.this.O(hVar.f59306e);
            }
        }

        public h(d.a.k0.q0.q1.f.b bVar) {
            this.f59306e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.f59306e.k().getText().toString().length() != 0 || this.f59306e.l().getText().toString().length() != 0) {
                a.this.W(new View$OnClickListenerC1527a());
            } else {
                a.this.O(this.f59306e);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i implements b.e {
        public i() {
        }

        @Override // d.a.k0.q0.q1.f.b.e
        public void a() {
            a.this.M();
        }
    }

    /* loaded from: classes4.dex */
    public class j implements Runnable {
        public j() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.H.fullScroll(IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER);
        }
    }

    /* loaded from: classes4.dex */
    public class k implements l.c {
        public k() {
        }

        @Override // d.a.j0.r.s.l.c
        public void onClick() {
            a.this.B();
        }
    }

    /* loaded from: classes4.dex */
    public class l implements l.d {
        public l() {
        }

        @Override // d.a.j0.r.s.l.d
        public void onClick() {
            a.this.x();
        }
    }

    public a(TbPageContext<?> tbPageContext, d.a.k0.q0.q1.b.b bVar, View view, String str, String str2, String str3, String str4, int i2, ForumRulesEditActivity forumRulesEditActivity) {
        this.f59293e = tbPageContext;
        this.f59294f = str;
        this.f59295g = str2;
        this.f59296h = str4;
        this.M = i2;
        this.j = forumRulesEditActivity;
        this.f59297i = bVar;
        G(view, str3);
    }

    public static void R(TextView textView, int i2, int i3) {
        textView.setText(i2 + "/" + i3);
        if (i2 > i3) {
            d.a.j0.r.u.c.d(textView).q(R.color.CAM_X0301);
        } else {
            d.a.j0.r.u.c.d(textView).q(R.color.CAM_X0111);
        }
    }

    public final void A() {
        if (this.I.size() <= 0 || this.B == null) {
            return;
        }
        d.a.k0.q0.q1.f.b bVar = this.I.get(0);
        this.B.removeView(bVar.m());
        this.I.remove(bVar);
        L();
        N();
    }

    public void B() {
        d.a.j0.r.s.j jVar = this.N;
        if (jVar == null || !jVar.isShowing()) {
            return;
        }
        this.N.dismiss();
    }

    public final void F() {
        d.a.k0.b0.e eVar = this.G;
        if (eVar != null) {
            eVar.I();
        }
    }

    public final void G(View view, String str) {
        this.k = view;
        this.C = (NavigationBar) view.findViewById(R.id.navi_forumrule_title);
        this.A = (LinearLayout) view.findViewById(R.id.rule_main_content);
        this.H = (EditorScrollView) view.findViewById(R.id.scrool_main);
        this.p = (ImageView) view.findViewById(R.id.forum_copy_icon);
        this.n = (RelativeLayout) view.findViewById(R.id.forum_to_copy_rl);
        this.q = (ImageView) view.findViewById(R.id.forum_copy_arrow);
        this.s = (EMTextView) view.findViewById(R.id.forum_copy_title);
        this.l = view.findViewById(R.id.forum_to_copy_divider);
        this.y = (EditText) view.findViewById(R.id.et_big_title);
        this.t = (EMTextView) view.findViewById(R.id.tv_used_example);
        this.u = (EMTextView) view.findViewById(R.id.title_number);
        this.m = view.findViewById(R.id.forum_title_divider);
        this.v = (EMTextView) view.findViewById(R.id.preface_title);
        this.z = (EditText) view.findViewById(R.id.preface_content);
        this.w = (EMTextView) view.findViewById(R.id.preface_number);
        this.B = (LinearLayout) view.findViewById(R.id.ll_add_rule);
        this.o = (RelativeLayout) view.findViewById(R.id.create_rule_btn);
        this.x = (EMTextView) view.findViewById(R.id.create_rule);
        this.r = (ImageView) view.findViewById(R.id.create_rule_icon);
        TextView addTextButton = this.C.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.f59293e.getString(R.string.dialog_cancel), null);
        this.F = addTextButton;
        addTextButton.setId(R.id.negative_feedback_view);
        this.F.setOnClickListener(this);
        this.C.setCenterTextTitle(this.f59293e.getString(R.string.forum_rule_defalt_title_setting));
        EMTextView eMTextView = new EMTextView(this.f59293e.getPageActivity());
        this.D = eMTextView;
        eMTextView.setText(this.f59293e.getString(R.string.video_preview));
        this.D.setGravity(16);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        layoutParams.gravity = 17;
        this.D.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X004), 0, UtilHelper.getDimenPixelSize(R.dimen.M_W_X004), 0);
        this.D.setLayoutParams(layoutParams);
        this.C.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.D, this);
        EMTextView eMTextView2 = new EMTextView(this.f59293e.getPageActivity());
        this.E = eMTextView2;
        eMTextView2.setText(this.f59293e.getString(R.string.push_commit));
        this.E.setEnabled(false);
        this.E.setGravity(16);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -1);
        layoutParams2.rightMargin = UtilHelper.getDimenPixelSize(R.dimen.M_W_X007);
        this.E.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X004), 0, 0, 0);
        this.E.setLayoutParams(layoutParams2);
        this.C.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.E, this);
        H();
        V();
        s(false, null, false);
    }

    public final void H() {
        this.n.setOnClickListener(this);
        this.t.setOnClickListener(this);
        this.o.setOnClickListener(this);
        this.A.setOnClickListener(this);
        this.C.setOnClickListener(this);
        R(this.u, 0, 50);
        R(this.w, 0, 500);
        this.H.setListener(new e());
        this.y.addTextChangedListener(new f());
        this.z.addTextChangedListener(new g());
    }

    public void I() {
        this.K = null;
        this.J = null;
        this.f59297i = null;
        this.j = null;
        B();
        this.N = null;
        this.O = null;
    }

    public void J() {
        if (this.N == null) {
            d.a.j0.r.s.l lVar = new d.a.j0.r.s.l(this.f59293e.getPageActivity());
            this.O = lVar;
            lVar.q(this.f59293e.getString(R.string.forum_rule_draft_title));
            this.N = new d.a.j0.r.s.j(this.f59293e, this.O);
            ArrayList arrayList = new ArrayList();
            d.a.j0.r.s.h hVar = new d.a.j0.r.s.h(this.f59293e.getString(R.string.save), this.O);
            hVar.o(R.color.CAM_X0302);
            hVar.m(this.R);
            arrayList.add(hVar);
            d.a.j0.r.s.h hVar2 = new d.a.j0.r.s.h(this.f59293e.getString(R.string.not_save), this.O);
            hVar2.m(this.S);
            arrayList.add(hVar2);
            this.O.m(new k());
            this.O.k(arrayList);
        }
        T();
    }

    public final void K() {
        if (this.J == null) {
            this.J = new ForumRuleBaseData();
        }
        ArrayList arrayList = new ArrayList();
        List<d.a.k0.q0.q1.f.b> list = this.I;
        if (list != null && list.size() > 0) {
            for (int i2 = 0; i2 < this.I.size(); i2++) {
                ForumRuleBaseData.ForumRuleItemData forumRuleItemData = new ForumRuleBaseData.ForumRuleItemData();
                d.a.k0.q0.q1.f.b bVar = this.I.get(i2);
                EditText l2 = bVar.l();
                SpanGroupEditText k2 = bVar.k();
                if (l2 != null) {
                    forumRuleItemData.setTitle(l2.getText().toString());
                }
                if (k2 != null) {
                    forumRuleItemData.setContent(k2.getSpanGroupManager().t());
                }
                forumRuleItemData.setStatus(i2 + "");
                arrayList.add(forumRuleItemData);
            }
        }
        this.J.setTitle(this.y.getText().toString());
        this.J.setPreface(this.z.getText().toString());
        this.J.setList(arrayList);
    }

    public final void L() {
        List<d.a.k0.q0.q1.f.b> list = this.I;
        if (list != null) {
            if (list.size() >= 20) {
                this.x.setText(this.f59293e.getString(R.string.forum_rule_item_number_max));
                this.o.setEnabled(false);
                this.x.setEnabled(false);
                this.L = false;
                this.r.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_edit_add12, d.a.k0.d3.c.a(SkinManager.getColor(R.color.CAM_X0105), SkinManager.RESOURCE_ALPHA_DISABLE), WebPManager.ResourceStateType.NORMAL_PRESS));
                d.a.j0.r.u.c d2 = d.a.j0.r.u.c.d(this.o);
                d2.h(R.color.CAM_X0902);
                d2.i(R.dimen.L_X02);
                d2.k(R.string.J_X07);
                d2.e(R.string.A_X09);
                d2.f(R.color.CAM_X0201);
                return;
            }
            this.x.setText(String.format(this.f59293e.getString(R.string.forum_rule_item_add_number), Integer.valueOf(20 - this.I.size())));
            this.o.setEnabled(true);
            this.x.setEnabled(true);
            this.L = true;
            this.r.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_edit_add12, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
            d.a.j0.r.u.c d3 = d.a.j0.r.u.c.d(this.o);
            d3.h(R.color.CAM_X0902);
            d3.i(R.dimen.L_X02);
            d3.k(R.string.J_X07);
            d3.e(R.string.A_X01);
            d3.f(R.color.CAM_X0201);
        }
    }

    public final void M() {
        if (this.E == null) {
            return;
        }
        if (y()) {
            this.E.setEnabled(true);
        } else {
            this.E.setEnabled(false);
        }
    }

    public final void N() {
        List<d.a.k0.q0.q1.f.b> list = this.I;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (int i2 = 0; i2 < this.I.size(); i2++) {
            d.a.k0.q0.q1.f.b bVar = this.I.get(i2);
            bVar.t(i2);
            bVar.s(i2);
        }
    }

    public final void O(d.a.k0.q0.q1.f.b bVar) {
        if (bVar != null) {
            this.B.removeView(bVar.m());
            this.I.remove(bVar);
            S();
            L();
            N();
            M();
        }
    }

    public final void P(d.a.k0.q0.q1.f.b bVar) {
        if (bVar != null) {
            bVar.o(new h(bVar));
            bVar.p(new i());
        }
    }

    public void Q(ForumRuleBaseData forumRuleBaseData, boolean z) {
        if (this.k == null || forumRuleBaseData == null) {
            return;
        }
        this.y.setText(forumRuleBaseData.getTitle());
        this.y.setSelection(forumRuleBaseData.getTitle() != null ? forumRuleBaseData.getTitle().length() : 0);
        this.z.setText(forumRuleBaseData.getPreface());
        this.z.setSelection(forumRuleBaseData.getPreface() != null ? forumRuleBaseData.getPreface().length() : 0);
        if (forumRuleBaseData.getPbDataList() != null && forumRuleBaseData.getPbDataList().size() > 0) {
            d.a.k0.q0.q1.f.b bVar = this.I.get(0);
            this.B.removeView(bVar.m());
            this.I.remove(bVar);
            for (int i2 = 0; i2 < forumRuleBaseData.getPbDataList().size(); i2++) {
                s(false, forumRuleBaseData.getPbDataList().get(i2), !z);
            }
            return;
        }
        A();
    }

    public final void S() {
        if (this.I.get(0) != null) {
            if (this.I.size() == 1) {
                this.I.get(0).q(false);
            } else {
                this.I.get(0).q(true);
            }
        }
    }

    public void T() {
        ForumRulesEditActivity forumRulesEditActivity;
        if (this.N == null || (forumRulesEditActivity = this.j) == null || forumRulesEditActivity.isFinishing()) {
            return;
        }
        this.N.l();
    }

    public final void V() {
        RelativeLayout relativeLayout;
        if (this.G != null || (relativeLayout = this.n) == null) {
            return;
        }
        d.a.k0.b0.e eVar = new d.a.k0.b0.e(this.f59293e, relativeLayout);
        this.G = eVar;
        eVar.g0(R.drawable.bg_tip_blue_up_left);
        this.G.O(16);
        this.G.U(true);
        this.G.h0(true);
        this.G.N(3000);
        this.G.j0(UtilHelper.getDimenPixelSize(R.dimen.tbds20));
        this.G.m0(this.f59293e.getString(R.string.forum_rule_defalt_tocopy_tip), "key_forum_rule_first_edit");
    }

    public final void W(View.OnClickListener onClickListener) {
        d.a.j0.r.s.a aVar = new d.a.j0.r.s.a(this.f59293e.getPageActivity());
        aVar.setContentViewSize(2);
        aVar.setCanceledOnTouchOutside(false);
        ForumRuleDelItemDialogView forumRuleDelItemDialogView = new ForumRuleDelItemDialogView(this.f59293e.getPageActivity());
        forumRuleDelItemDialogView.setConfirmButtonListener(new b(this, aVar));
        forumRuleDelItemDialogView.setpostButtonListener(new c(this, onClickListener, aVar));
        aVar.setContentView(forumRuleDelItemDialogView);
        aVar.create(this.f59293e).show();
    }

    public final void X(String str) {
        BdTopToast bdTopToast = this.K;
        if (bdTopToast == null || !bdTopToast.isShown()) {
            BdTopToast bdTopToast2 = new BdTopToast(this.f59293e.getPageActivity(), 2000);
            bdTopToast2.i(false);
            bdTopToast2.h(str);
            this.K = bdTopToast2;
            bdTopToast2.j((ViewGroup) this.k.findViewById(R.id.ll_forum_rule_all));
        }
    }

    public final void Y(int i2) {
        if (i2 > 0) {
            this.t.setVisibility(8);
            ViewGroup.LayoutParams layoutParams = this.y.getLayoutParams();
            layoutParams.width = -1;
            this.y.setLayoutParams(layoutParams);
            return;
        }
        this.t.setVisibility(0);
        ViewGroup.LayoutParams layoutParams2 = this.y.getLayoutParams();
        layoutParams2.width = -2;
        this.y.setLayoutParams(layoutParams2);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.F) {
            J();
        } else if (view == this.E) {
            v();
        } else if (view == this.D) {
            K();
            this.f59293e.sendMessage(new CustomMessage(2002001, new ForumRulesShowActivityConfig(this.f59293e.getPageActivity(), this.f59294f, this.f59295g, this.J, ForumRulesShowActivityConfig.FORUM_RULE_EDIT_FROM_SHOW, this.f59296h, this.M)));
        } else if (view == this.n) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FrsActivityConfig(this.f59293e.getPageActivity()).createNormalCfg(this.f59295g, FrsActivityConfig.FRS_FROM_FORUM_RULE_EDIT)));
        } else if (view == this.t) {
            z();
        } else if (view != this.A && view != this.C) {
            if (view == this.o) {
                d.a.c.e.m.e.a().removeCallbacks(this.Q);
                d.a.c.e.m.e.a().postDelayed(this.Q, 300L);
            }
        } else {
            d.a.c.e.p.l.x(this.f59293e.getPageActivity(), this.y);
            d.a.c.e.p.l.x(this.f59293e.getPageActivity(), this.z);
        }
    }

    public void p() {
        A();
        q(R.string.forum_rule_defalt_one_title, R.string.forum_rule_defalt_one_content);
        q(R.string.forum_rule_defalt_two_title, R.string.forum_rule_defalt_two_content);
        q(R.string.forum_rule_defalt_three_title, R.string.forum_rule_defalt_three_content);
        q(R.string.forum_rule_defalt_four_title, R.string.forum_rule_defalt_four_content);
        s(false, null, false);
    }

    public final void q(int i2, int i3) {
        if (this.B != null) {
            d.a.k0.q0.q1.f.b bVar = new d.a.k0.q0.q1.f.b(this.f59293e.getPageActivity());
            P(bVar);
            r(bVar);
            String string = TbadkApplication.getInst().getResources().getString(i2);
            String string2 = TbadkApplication.getInst().getResources().getString(i3);
            bVar.l().setText(string);
            bVar.l().setSelection(string.length());
            bVar.k().d(string2);
            bVar.k().setSelection(bVar.k().getText().toString().length());
        }
    }

    public final void r(d.a.k0.q0.q1.f.b bVar) {
        if (bVar != null) {
            this.B.addView(bVar.m());
            this.I.add(bVar);
            S();
            if (this.I.indexOf(bVar) != -1) {
                bVar.t(this.I.indexOf(bVar));
                bVar.s(this.I.indexOf(bVar));
            }
            M();
            L();
        }
    }

    public final void s(boolean z, ForumRuleBaseData.ForumRuleItemPbData forumRuleItemPbData, boolean z2) {
        if (this.B != null) {
            d.a.k0.q0.q1.f.b bVar = new d.a.k0.q0.q1.f.b(this.f59293e.getPageActivity());
            P(bVar);
            r(bVar);
            if (forumRuleItemPbData != null) {
                bVar.l().setText(forumRuleItemPbData.title);
                EditText l2 = bVar.l();
                String str = forumRuleItemPbData.title;
                l2.setSelection(str != null ? str.length() : 0);
                if (forumRuleItemPbData.mContent != null) {
                    for (int i2 = 0; i2 < forumRuleItemPbData.mContent.size(); i2++) {
                        ForumRuleBaseData.ForumRuleItemPbContentData forumRuleItemPbContentData = forumRuleItemPbData.mContent.get(i2);
                        if (forumRuleItemPbContentData != null) {
                            if ("a".equals(forumRuleItemPbContentData.tag)) {
                                TbLinkSpanGroup tbLinkSpanGroup = new TbLinkSpanGroup(TbLinkSpanGroup.LINK_TYPE.PARSED_EXTERNAL_LINK);
                                SpanGroupEditText k2 = bVar.k();
                                tbLinkSpanGroup.a(k2.getText(), k2.getSelectionEnd(), k2.getSelectionEnd(), (int) k2.getTextSize());
                                tbLinkSpanGroup.C(forumRuleItemPbContentData.href);
                                tbLinkSpanGroup.z(forumRuleItemPbContentData.value);
                                tbLinkSpanGroup.r();
                                k2.getSpanGroupManager().v(tbLinkSpanGroup);
                            } else if ("plainText".equals(forumRuleItemPbContentData.tag)) {
                                bVar.k().d(forumRuleItemPbContentData.value);
                            } else if ("br".equals(forumRuleItemPbContentData.tag)) {
                                bVar.k().d(Part.CRLF);
                            }
                        }
                    }
                }
                bVar.k().setSelection(bVar.k().getText().toString().length());
                if (z2 && "1".equals(forumRuleItemPbData.status)) {
                    bVar.l().setTextColor(SkinManager.getColor(R.color.CAM_X0301));
                    bVar.k().setTextColor(SkinManager.getColor(R.color.CAM_X0301));
                    bVar.r(true);
                }
            }
            if (z) {
                d.a.c.e.m.e.a().post(new j());
            }
        }
    }

    public final void t(int i2) {
        if (i2 == 0 && !this.P) {
            if ("Meizu".equalsIgnoreCase(Build.BRAND)) {
                d.a.k0.q0.q1.e.a.c(UtilHelper.getDimenPixelSize(R.dimen.tbds6), UtilHelper.getDimenPixelSize(R.dimen.tbds20), this.z);
                this.P = true;
            } else if ("Xiaomi".equalsIgnoreCase(Build.BRAND)) {
                d.a.k0.q0.q1.e.a.c(0, UtilHelper.getDimenPixelSize(R.dimen.tbds_20), this.z);
                this.P = true;
            }
        } else if (this.P) {
            this.P = false;
            d.a.k0.q0.q1.e.a.c(0, 0, this.z);
        }
    }

    public void u(int i2) {
        if (this.k != null) {
            d.a.j0.r.u.c.d(this.A).f(R.color.CAM_X0201);
            d.a.j0.r.u.c.d(this.s).q(R.color.CAM_X0105);
            d.a.j0.r.u.c.d(this.l).f(R.color.CAM_X0210);
            d.a.j0.r.u.c.d(this.m).f(R.color.CAM_X0210);
            d.a.j0.r.u.c.d(this.u).q(R.color.CAM_X0111);
            d.a.j0.r.u.c.d(this.w).q(R.color.CAM_X0111);
            d.a.j0.r.u.c d2 = d.a.j0.r.u.c.d(this.t);
            d2.q(R.color.CAM_X0304);
            d2.v(R.string.F_X02);
            d.a.j0.r.u.c d3 = d.a.j0.r.u.c.d(this.v);
            d3.q(R.color.CAM_X0107);
            d3.v(R.string.F_X02);
            d.a.j0.r.u.c.d(this.F).s(R.color.CAM_X0105);
            d.a.j0.r.u.c d4 = d.a.j0.r.u.c.d(this.D);
            d4.s(R.color.CAM_X0302);
            d4.u(R.dimen.T_X05);
            d.a.j0.r.u.c.d(this.E).u(R.dimen.T_X05);
            this.E.setTextColor(SkinManager.getColorStateListWithClickAndDisableState(R.color.CAM_X0302, TbadkCoreApplication.getInst().getSkinType()));
            this.x.setTextColor(SkinManager.getColorStateListWithClickAndDisableState(R.color.CAM_X0105, TbadkCoreApplication.getInst().getSkinType()));
            this.y.setHintTextColor(SkinManager.getColor(R.color.CAM_X0111));
            this.y.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            this.z.setHintTextColor(SkinManager.getColor(R.color.CAM_X0111));
            this.z.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            this.p.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_frs_recommend_copy18, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
            this.q.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_list_arrow16_right, SkinManager.getColor(R.color.CAM_X0107), WebPManager.ResourceStateType.NORMAL_PRESS));
            if (this.L) {
                this.r.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_edit_add12, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
            } else {
                this.r.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_edit_add12, d.a.k0.d3.c.a(SkinManager.getColor(R.color.CAM_X0304), SkinManager.RESOURCE_ALPHA_PRESS), WebPManager.ResourceStateType.NORMAL_PRESS));
            }
            NavigationBar navigationBar = this.C;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(this.f59293e, i2);
            }
            d.a.j0.r.s.l lVar = this.O;
            if (lVar != null) {
                lVar.j();
            }
            if (i2 == 0) {
                d.a.k0.v3.i.e(this.y, R.drawable.edittext_cursor);
                d.a.k0.v3.i.e(this.z, R.drawable.edittext_cursor);
            } else {
                d.a.k0.v3.i.e(this.y, R.drawable.edittext_cursor_1);
                d.a.k0.v3.i.e(this.z, R.drawable.edittext_cursor_1);
            }
            d.a.j0.r.u.c d5 = d.a.j0.r.u.c.d(this.o);
            d5.h(R.color.CAM_X0902);
            d5.i(R.dimen.L_X02);
            d5.k(R.string.J_X07);
            d5.e(this.L ? R.string.A_X01 : R.string.A_X09);
            d5.f(R.color.CAM_X0201);
        }
    }

    public final void v() {
        EditText editText = this.y;
        if (editText != null && editText.getText().toString().length() > 50) {
            X(String.format(this.f59293e.getString(R.string.forum_rule_commit_error_toast), this.f59293e.getString(R.string.forum_rule_defalt_main_title)));
            return;
        }
        List<d.a.k0.q0.q1.f.b> list = this.I;
        if (list != null && list.size() > 0) {
            for (int i2 = 0; i2 < this.I.size(); i2++) {
                new ForumRuleBaseData.ForumRuleItemData();
                d.a.k0.q0.q1.f.b bVar = this.I.get(i2);
                EditText l2 = bVar.l();
                SpanGroupEditText k2 = bVar.k();
                if (l2 != null && l2.getText().toString().trim().length() > 30) {
                    X(String.format(this.f59293e.getString(R.string.forum_rule_commit_error_toast), String.format(this.f59293e.getString(R.string.forum_rule_defalt_has_forum_rule), d.a.k0.q0.q1.e.a.d(i2 + 1), this.f59293e.getString(R.string.forum_rule_title))));
                    return;
                } else if (k2 != null && k2.getText().toString().length() > 1000) {
                    X(String.format(this.f59293e.getString(R.string.forum_rule_commit_error_toast), String.format(this.f59293e.getString(R.string.forum_rule_defalt_has_forum_rule), d.a.k0.q0.q1.e.a.d(i2 + 1), this.f59293e.getString(R.string.forum_rule_content))));
                    return;
                }
            }
        }
        EditText editText2 = this.z;
        if (editText2 != null && editText2.getText().toString().length() > 500) {
            X(String.format(this.f59293e.getString(R.string.forum_rule_commit_error_toast), this.f59293e.getString(R.string.forum_rule_defalt_preface_title)));
            return;
        }
        K();
        this.f59297i.commitData(this.J, false);
    }

    public final boolean w() {
        int i2;
        int i3;
        int i4;
        int i5;
        ForumRuleBaseData forumRuleBaseData = this.J;
        if (forumRuleBaseData != null) {
            i2 = forumRuleBaseData.getTitle() != null ? this.J.getTitle().length() : 0;
            if (this.J.getList() == null || this.J.getList().size() <= 0) {
                i4 = 0;
                i5 = 0;
            } else {
                i4 = 0;
                i5 = 0;
                for (int i6 = 0; i6 < this.J.getList().size(); i6++) {
                    ForumRuleBaseData.ForumRuleItemData forumRuleItemData = this.J.getList().get(i6);
                    if (forumRuleItemData != null) {
                        if (forumRuleItemData.getTitle() != null) {
                            i4 += forumRuleItemData.getTitle().length();
                        }
                        if (forumRuleItemData.getContent() != null) {
                            i5 += forumRuleItemData.getContent().length();
                        }
                    }
                }
            }
            i3 = this.J.getPreface() != null ? this.J.getPreface().length() : 0;
        } else {
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
        }
        if (i2 + i4 + i5 + i3 > 5000) {
            B();
            X(String.format(this.f59293e.getString(R.string.forum_rule_draft_total_num_error_toast), 5000));
            return true;
        }
        return false;
    }

    public final void x() {
        K();
        if (w()) {
            return;
        }
        ForumRuleBaseData forumRuleBaseData = this.J;
        if (forumRuleBaseData != null) {
            if (forumRuleBaseData.getTitle().length() > 50) {
                B();
                X(String.format(this.f59293e.getString(R.string.forum_rule_draft_error_toast), this.f59293e.getString(R.string.forum_rule_defalt_main_title), 50));
                return;
            }
            if (this.J.getList() != null) {
                for (int i2 = 0; i2 < this.J.getList().size(); i2++) {
                    ForumRuleBaseData.ForumRuleItemData forumRuleItemData = this.J.getList().get(i2);
                    if (forumRuleItemData != null) {
                        if (forumRuleItemData.getTitle().length() > 50) {
                            B();
                            X(String.format(this.f59293e.getString(R.string.forum_rule_draft_error_toast), this.f59293e.getString(R.string.forum_rule_defalt_item_title), 50));
                            return;
                        } else if (forumRuleItemData.getContent().length() > 1000) {
                            B();
                            X(String.format(this.f59293e.getString(R.string.forum_rule_draft_error_toast), this.f59293e.getString(R.string.forum_rule_defalt_item_content), 1000));
                            return;
                        }
                    }
                }
            }
            if (this.J.getPreface().length() > 600) {
                B();
                X(String.format(this.f59293e.getString(R.string.forum_rule_draft_error_toast), this.f59293e.getString(R.string.forum_rule_defalt_preface_title), 600));
                return;
            }
        }
        this.f59297i.commitData(this.J, true);
    }

    public final boolean y() {
        EditText editText;
        if (this.E == null || (editText = this.y) == null || editText.getText().toString().trim().length() <= 0) {
            return false;
        }
        EditText editText2 = this.z;
        if (editText2 == null || editText2.getText().toString().trim().length() > 0) {
            List<d.a.k0.q0.q1.f.b> list = this.I;
            if (list == null || list.size() <= 0) {
                return true;
            }
            for (int i2 = 0; i2 < this.I.size(); i2++) {
                d.a.k0.q0.q1.f.b bVar = this.I.get(i2);
                EditText l2 = bVar.l();
                SpanGroupEditText k2 = bVar.k();
                if (l2 == null || l2.getText().toString().trim().length() <= 0 || k2 == null || k2.getText().toString().trim().length() <= 0) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public final void z() {
        String format = String.format(this.f59293e.getString(R.string.forum_rule_defalt_title_demo), this.f59295g, d.a.c.e.p.k.getDateStringMouth(new Date()));
        this.y.setText(format);
        this.y.setSelection(format.length());
        ViewGroup.LayoutParams layoutParams = this.y.getLayoutParams();
        layoutParams.width = -1;
        this.y.setLayoutParams(layoutParams);
    }
}

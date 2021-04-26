package d.a.j0.q0.w1.e;

import android.graphics.Rect;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AbsListView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity;
import com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity;
import com.compatible.menukey.MenuKeyUtils;
import d.a.c.e.p.l;
import d.a.c.j.e.n;
import d.a.i0.r.s.a;
import d.a.i0.z0.i0;
import d.a.j0.d2.i.c;
import d.a.j0.q0.w1.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public FrsGameSubPbActivity f58895a;

    /* renamed from: b  reason: collision with root package name */
    public RelativeLayout f58896b;

    /* renamed from: c  reason: collision with root package name */
    public View f58897c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.j0.q0.w1.d.e f58898d;

    /* renamed from: e  reason: collision with root package name */
    public BdTypeListView f58899e;

    /* renamed from: f  reason: collision with root package name */
    public NavigationBar f58900f;

    /* renamed from: g  reason: collision with root package name */
    public FrameLayout f58901g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f58902h;

    /* renamed from: i  reason: collision with root package name */
    public EditText f58903i;
    public TextView j;
    public TextView k;
    public TextView l;
    public ProgressBar m;
    public View n;
    public d.a.j0.q0.w1.c o;
    public d.a.j0.q0.w1.b p;
    public View.OnClickListener q;
    public ViewTreeObserver.OnGlobalLayoutListener r;
    public d.a.j0.q0.w1.d.b s;
    public List<n> t;
    public String u;
    public String v;
    public long w;
    public boolean x;
    public boolean y;
    public d.a.j0.d2.i.c z = new d.a.j0.d2.i.c(new c());

    /* renamed from: d.a.j0.q0.w1.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class RunnableC1472a implements Runnable {
        public RunnableC1472a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.f58903i.requestFocus();
            l.x(a.this.f58895a.getPageContext().getPageActivity(), a.this.f58903i);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.f58903i.requestFocus();
            l.K(a.this.f58895a.getPageContext().getPageActivity(), a.this.f58903i);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements c.a {
        public c() {
        }

        @Override // d.a.j0.d2.i.c.a
        public boolean a(View view, MotionEvent motionEvent) {
            return false;
        }

        @Override // d.a.j0.d2.i.c.a
        public boolean b(View view, MotionEvent motionEvent) {
            return true;
        }

        @Override // d.a.j0.d2.i.c.a
        public boolean c(View view, MotionEvent motionEvent) {
            a.this.s(false);
            a.this.N(view);
            a.this.s(true);
            return true;
        }
    }

    /* loaded from: classes4.dex */
    public class d implements AbsListView.OnScrollListener {
        public d() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i2) {
            if (i2 != 0) {
                l.x(a.this.f58895a.getPageContext().getPageActivity(), a.this.f58903i);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a aVar = a.this;
            aVar.p(aVar.f58903i.getText().toString());
        }
    }

    /* loaded from: classes4.dex */
    public class f implements a.InterfaceC1469a {
        public f() {
        }

        @Override // d.a.j0.q0.w1.a.InterfaceC1469a
        public void a(d.a.j0.q0.w1.d.d dVar) {
            if (dVar == null) {
                return;
            }
            a.this.M(dVar);
        }

        @Override // d.a.j0.q0.w1.a.InterfaceC1469a
        public void b(d.a.j0.q0.w1.d.d dVar) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(a.this.f58895a.getPageContext().getPageActivity()).createNormalConfig(Long.valueOf(dVar.f58892g).longValue(), String.valueOf(a.this.w).equals(dVar.f58892g), false)));
        }

        @Override // d.a.j0.q0.w1.a.InterfaceC1469a
        public void c(d.a.j0.q0.w1.d.d dVar) {
            if (a.this.o != null) {
                a.this.o.i();
            }
            if (dVar == null) {
                a.this.t(null);
                a.this.J();
                return;
            }
            a.this.t(dVar.f58893h);
            a.this.v = dVar.f58892g;
        }
    }

    /* loaded from: classes4.dex */
    public class g implements ViewTreeObserver.OnGlobalLayoutListener {
        public g() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Rect rect = new Rect();
            a.this.f58895a.getPageContext().getPageActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
            int r = l.r(a.this.f58895a.getPageContext().getPageActivity());
            int[] p = l.p(a.this.f58895a.getPageContext().getPageActivity());
            if (p[1] - rect.bottom > p[1] / 4 && !a.this.x) {
                a.this.x = true;
                a.this.F(true);
            } else if (p[1] - rect.height() == r && a.this.x) {
                a.this.x = false;
                a.this.F(false);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.r.s.a f58911e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.j0.q0.w1.d.d f58912f;

        public h(d.a.i0.r.s.a aVar, d.a.j0.q0.w1.d.d dVar) {
            this.f58911e = aVar;
            this.f58912f = dVar;
        }

        @Override // d.a.i0.r.s.a.e
        public void onClick(d.a.i0.r.s.a aVar) {
            this.f58911e.dismiss();
            a.this.r(this.f58912f);
        }
    }

    /* loaded from: classes4.dex */
    public class i implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.r.s.a f58914e;

        public i(a aVar, d.a.i0.r.s.a aVar2) {
            this.f58914e = aVar2;
        }

        @Override // d.a.i0.r.s.a.e
        public void onClick(d.a.i0.r.s.a aVar) {
            this.f58914e.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public class j implements TextWatcher {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f58915e;

        public j(int i2) {
            this.f58915e = i2;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            if (!TextUtils.isEmpty(charSequence)) {
                a.this.j.setEnabled(true);
                String charSequence2 = charSequence.toString();
                if (StringUtils.isNull(charSequence2)) {
                    return;
                }
                int b2 = i0.b(charSequence2);
                int i5 = this.f58915e;
                if (b2 > i5) {
                    String k = i0.k(charSequence2, 0, i5 - 1);
                    a.this.f58903i.setText(k);
                    a.this.f58903i.setSelection(a.this.f58903i.getText().length());
                    UtilHelper.showToast(a.this.f58895a.getPageContext().getPageActivity().getApplication(), a.this.f58895a.getPageContext().getPageActivity().getResources().getString(R.string.edit_text_over_limit_tip, Integer.valueOf(k.length())));
                    return;
                }
                return;
            }
            a.this.J();
            a.this.j.setEnabled(false);
        }
    }

    /* loaded from: classes4.dex */
    public class k implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f58917e;

        public k(boolean z) {
            this.f58917e = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.f58899e.setEnabled(this.f58917e);
        }
    }

    public a(FrsGameSubPbActivity frsGameSubPbActivity, View.OnClickListener onClickListener, String str) {
        this.f58895a = frsGameSubPbActivity;
        this.q = onClickListener;
        this.u = str;
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(frsGameSubPbActivity.getPageContext().getPageActivity()).inflate(R.layout.frs_game_sub_pb_activity, (ViewGroup) null);
        this.f58896b = relativeLayout;
        BdTypeListView bdTypeListView = (BdTypeListView) relativeLayout.findViewById(R.id.new_sub_pb_list);
        this.f58899e = bdTypeListView;
        bdTypeListView.setOnTouchListener(this.z);
        this.f58899e.setOnScrollListener(new d());
        this.f58898d = new d.a.j0.q0.w1.d.e(this.f58895a.getPageContext());
        this.f58897c = BdListViewHelper.d(this.f58895a.getActivity(), this.f58899e, BdListViewHelper.HeadType.DEFAULT);
        TextView textView = (TextView) this.f58896b.findViewById(R.id.subpb_editor_tool_comment_reply_text);
        this.k = textView;
        textView.setOnClickListener(this.q);
        this.l = (TextView) this.f58896b.findViewById(R.id.no_reply_list_view);
        this.f58901g = (FrameLayout) this.f58896b.findViewById(R.id.bottom_view);
        this.f58902h = (LinearLayout) this.f58896b.findViewById(R.id.subpb_editor_tool_comment_input_container);
        this.f58903i = (EditText) this.f58896b.findViewById(R.id.subpb_editor_tool_comment_input_edit);
        TextView textView2 = (TextView) this.f58896b.findViewById(R.id.subpb_editor_tool_comment_send_tv);
        this.j = textView2;
        textView2.setOnClickListener(new e());
        this.m = (ProgressBar) this.f58896b.findViewById(R.id.progressBar);
        C();
        d.a.j0.q0.w1.b bVar = new d.a.j0.q0.w1.b(this.f58895a.getPageContext(), this.f58899e);
        this.p = bVar;
        bVar.b(new f());
        K(PbFullScreenEditorActivity.REPLY_MAX_SIZE);
        B();
        D(TbadkCoreApplication.getInst().getSkinType());
        this.t = new ArrayList();
        this.w = d.a.c.e.m.b.f(TbadkCoreApplication.getCurrentAccount(), 0L);
    }

    public void A(boolean z, String str, d.a.j0.q0.w1.d.d dVar) {
        if (z) {
            BdToast.d(this.f58895a.getPageContext().getPageActivity(), this.f58895a.getPageContext().getString(R.string.subpb_delete_comment_succ_tip), 1).q();
            this.t.remove(dVar);
            this.p.c(this.t);
            G(this.y);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = this.f58895a.getPageContext().getString(R.string.subpb_delete_comment_fail_tip);
        }
        BdToast.d(this.f58895a.getPageContext().getPageActivity(), str, 1).q();
    }

    public final void B() {
        this.r = new g();
        this.f58895a.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.r);
    }

    public final void C() {
        NavigationBar navigationBar = (NavigationBar) this.f58896b.findViewById(R.id.view_navigation_bar);
        this.f58900f = navigationBar;
        this.n = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.f58900f.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.n.getLayoutParams();
            int g2 = l.g(this.f58895a.getPageContext().getPageActivity(), R.dimen.ds30);
            layoutParams.height = g2;
            layoutParams.width = g2;
            backImageView.setLayoutParams(layoutParams);
        }
        View view = this.n;
        if (view != null && (view.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.n.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = -1;
            this.n.setPadding(l.g(this.f58895a.getPageContext().getPageActivity(), R.dimen.ds32), this.n.getPaddingTop(), this.n.getPaddingRight(), this.n.getPaddingBottom());
            this.n.setLayoutParams(layoutParams2);
        }
        if (this.f58900f.getBackImageView() != null) {
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f58900f.getBackImageView(), R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public void D(int i2) {
        this.f58895a.getLayoutMode().k(i2 == 1);
        this.f58895a.getLayoutMode().j(this.f58896b);
        SkinManager.setBackgroundColor(this.f58896b, R.color.CAM_X0201);
        this.f58900f.onChangeSkinType(this.f58895a.getPageContext(), i2);
        this.f58898d.d(i2);
        SkinManager.setViewTextColor(this.k, R.color.CAM_X0110);
        this.k.setAlpha(0.95f);
        SkinManager.setBackgroundResource(this.k, R.drawable.pb_ecomm_comment_bg);
        SkinManager.setViewTextColor(this.l, R.color.CAM_X0109);
        SkinManager.setBackgroundResource(this.f58902h, R.drawable.pb_ecomm_comment_bg);
        SkinManager.setViewTextColor(this.f58903i, R.color.CAM_X0106);
        this.f58903i.setHintTextColor(SkinManager.getColor(R.color.CAM_X0110));
        SkinManager.setViewTextColor(this.j, R.color.game_sub_pb_send_txt_color);
    }

    public void E() {
        if (this.r != null) {
            this.f58895a.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.r);
        }
    }

    public final void F(boolean z) {
        if (z) {
            Rect rect = new Rect();
            this.f58902h.getWindowVisibleDisplayFrame(rect);
            int e2 = (l.p(this.f58895a.getPageContext().getPageActivity())[1] - rect.bottom) - (MenuKeyUtils.hasSmartBar() ? l.e(this.f58895a.getPageContext().getPageActivity(), 48.0f) : 0);
            FrameLayout frameLayout = this.f58901g;
            frameLayout.scrollTo(frameLayout.getScrollX(), e2);
            return;
        }
        this.f58901g.setScrollY(0);
    }

    public final void G(boolean z) {
        if (ListUtils.isEmpty(this.t)) {
            this.f58899e.setNextPage(null);
            this.l.setVisibility(0);
        } else {
            this.f58899e.setNextPage(this.f58898d);
            this.l.setVisibility(8);
            if (z) {
                this.f58898d.O();
            } else {
                this.f58898d.f();
            }
        }
        L();
    }

    public void H(d.a.j0.q0.w1.c cVar) {
        this.o = cVar;
    }

    public void I(BdListView.p pVar) {
        this.f58899e.setOnSrollToBottomListener(pVar);
    }

    public final void J() {
        d.a.j0.q0.w1.d.b bVar = this.s;
        this.v = bVar != null ? bVar.f58885e : null;
    }

    public final void K(int i2) {
        this.f58903i.addTextChangedListener(new j(i2));
    }

    public final void L() {
        if (!ListUtils.isEmpty(this.t)) {
            this.f58900f.setCenterTextTitle(String.format(this.f58895a.getResources().getString(R.string.subpb_floor_reply_count), StringHelper.numFormatOver10000(this.t.size())));
        } else {
            this.f58900f.setCenterTextTitle(this.f58895a.getResources().getString(R.string.reply));
        }
    }

    public final void M(d.a.j0.q0.w1.d.d dVar) {
        d.a.i0.r.s.a aVar = new d.a.i0.r.s.a(this.f58895a.getPageContext().getPageActivity());
        aVar.setTitle((String) null);
        aVar.setMessageId(R.string.del_all_post_confirm);
        aVar.setCanceledOnTouchOutside(true);
        aVar.setPositiveButton(R.string.dialog_ok, new h(aVar, dVar));
        aVar.setNegativeButton(R.string.dialog_cancel, new i(this, aVar));
        aVar.create(this.f58895a.getPageContext()).show();
    }

    public void N(View view) {
        NavigationBar navigationBar;
        if (this.f58897c == null || (navigationBar = this.f58900f) == null) {
            return;
        }
        if (navigationBar.isNavigationBarExcludeStatusbarVisible()) {
            this.f58900f.showNavigationBarExcludeStatusbar(false);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.f58897c.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight()));
            } else {
                BdTypeListView bdTypeListView = this.f58899e;
                if (bdTypeListView != null) {
                    bdTypeListView.removeHeaderView(this.f58897c);
                }
            }
            this.f58900f.setVisibility(8);
            return;
        }
        this.f58900f.showNavigationBarExcludeStatusbar(true);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.f58897c.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.g(this.f58895a.getActivity(), R.dimen.ds98)));
        } else {
            BdTypeListView bdTypeListView2 = this.f58899e;
            if (bdTypeListView2 != null) {
                bdTypeListView2.x(this.f58897c, 0);
            }
        }
        this.f58900f.setVisibility(0);
    }

    public void O(boolean z, d.a.j0.q0.w1.d.b bVar, List<n> list) {
        this.y = z;
        this.s = bVar;
        J();
        if (ListUtils.isEmpty(list)) {
            G(z);
            return;
        }
        this.t.clear();
        this.t.addAll(list);
        this.l.setVisibility(8);
        this.f58899e.setNextPage(this.f58898d);
        this.p.c(list);
        q();
        this.k.setVisibility(0);
        this.k.setText(R.string.say_your_point);
        G(z);
    }

    public void P(boolean z) {
        View view = this.f58897c;
        if (view == null || view.getLayoutParams() == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.f58897c.getLayoutParams();
        if (z) {
            q();
            layoutParams.height = l.g(this.f58895a.getPageContext().getPageActivity(), R.dimen.ds98);
        } else {
            layoutParams.height = l.g(this.f58895a.getPageContext().getPageActivity(), R.dimen.ds98) + UtilHelper.getLightStatusBarHeight();
        }
        this.f58897c.setLayoutParams(layoutParams);
    }

    public void Q(int i2) {
        this.m.setVisibility(i2);
    }

    public final void p(String str) {
        Q(0);
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_ADD_SUB_COMMENT);
        httpMessage.addParam("user_id", this.w);
        httpMessage.addParam("reply_user_id", this.v);
        httpMessage.addParam("content", str);
        httpMessage.addParam("main_tower_id", this.u);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public final void q() {
        if (this.f58900f.getBackImageView() != null) {
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f58900f.getBackImageView(), R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public final void r(d.a.j0.q0.w1.d.d dVar) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_DELETE_SUB_COMMENT);
        httpMessage.addParam("user_id", this.w);
        httpMessage.addParam("main_tower_id", dVar.f58891f);
        httpMessage.addParam("id", dVar.f58890e);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public final void s(boolean z) {
        BdTypeListView bdTypeListView = this.f58899e;
        if (bdTypeListView != null) {
            if (!z) {
                bdTypeListView.setEnabled(z);
            } else {
                bdTypeListView.postDelayed(new k(z), 10L);
            }
        }
    }

    public void t(String str) {
        this.k.setVisibility(8);
        this.f58902h.setVisibility(0);
        this.f58903i.post(new b());
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String format = String.format(this.f58895a.getPageContext().getPageActivity().getResources().getString(R.string.reply_sub_floor), str);
        this.f58903i.setText(format);
        this.f58903i.setSelection(format.length());
    }

    public ListView u() {
        return this.f58899e;
    }

    public NavigationBar v() {
        return this.f58900f;
    }

    public TextView w() {
        return this.k;
    }

    public View x() {
        return this.f58896b;
    }

    public View y() {
        return this.f58897c;
    }

    public void z(boolean z, String str, d.a.j0.q0.w1.d.d dVar) {
        Q(8);
        if (z && dVar != null) {
            BdToast.d(this.f58895a.getPageContext().getPageActivity(), this.f58895a.getPageContext().getString(R.string.subpb_add_comment_succ_tip), 1).q();
            this.f58903i.setText((CharSequence) null);
            this.t.add(dVar);
            this.p.c(this.t);
            G(this.y);
            this.f58903i.post(new RunnableC1472a());
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = this.f58895a.getPageContext().getString(R.string.subpb_add_comment_fail_tip);
        }
        BdToast.d(this.f58895a.getPageContext().getPageActivity(), str, 1).q();
    }
}

package d.b.i0.p0.w1.e;

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
import d.b.b.e.p.l;
import d.b.b.j.e.n;
import d.b.h0.r.s.a;
import d.b.h0.z0.i0;
import d.b.i0.c2.i.c;
import d.b.i0.p0.w1.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public FrsGameSubPbActivity f58692a;

    /* renamed from: b  reason: collision with root package name */
    public RelativeLayout f58693b;

    /* renamed from: c  reason: collision with root package name */
    public View f58694c;

    /* renamed from: d  reason: collision with root package name */
    public d.b.i0.p0.w1.d.e f58695d;

    /* renamed from: e  reason: collision with root package name */
    public BdTypeListView f58696e;

    /* renamed from: f  reason: collision with root package name */
    public NavigationBar f58697f;

    /* renamed from: g  reason: collision with root package name */
    public FrameLayout f58698g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f58699h;
    public EditText i;
    public TextView j;
    public TextView k;
    public TextView l;
    public ProgressBar m;
    public View n;
    public d.b.i0.p0.w1.c o;
    public d.b.i0.p0.w1.b p;
    public View.OnClickListener q;
    public ViewTreeObserver.OnGlobalLayoutListener r;
    public d.b.i0.p0.w1.d.b s;
    public List<n> t;
    public String u;
    public String v;
    public long w;
    public boolean x;
    public boolean y;
    public d.b.i0.c2.i.c z = new d.b.i0.c2.i.c(new c());

    /* renamed from: d.b.i0.p0.w1.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class RunnableC1446a implements Runnable {
        public RunnableC1446a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.i.requestFocus();
            l.w(a.this.f58692a.getPageContext().getPageActivity(), a.this.i);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.i.requestFocus();
            l.J(a.this.f58692a.getPageContext().getPageActivity(), a.this.i);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements c.a {
        public c() {
        }

        @Override // d.b.i0.c2.i.c.a
        public boolean a(View view, MotionEvent motionEvent) {
            return true;
        }

        @Override // d.b.i0.c2.i.c.a
        public boolean b(View view, MotionEvent motionEvent) {
            a.this.s(false);
            a.this.N(view);
            a.this.s(true);
            return true;
        }

        @Override // d.b.i0.c2.i.c.a
        public boolean c(View view, MotionEvent motionEvent) {
            return false;
        }
    }

    /* loaded from: classes4.dex */
    public class d implements AbsListView.OnScrollListener {
        public d() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i != 0) {
                l.w(a.this.f58692a.getPageContext().getPageActivity(), a.this.i);
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
            aVar.p(aVar.i.getText().toString());
        }
    }

    /* loaded from: classes4.dex */
    public class f implements a.InterfaceC1443a {
        public f() {
        }

        @Override // d.b.i0.p0.w1.a.InterfaceC1443a
        public void a(d.b.i0.p0.w1.d.d dVar) {
            if (a.this.o != null) {
                a.this.o.i();
            }
            if (dVar == null) {
                a.this.t(null);
                a.this.J();
                return;
            }
            a.this.t(dVar.f58691h);
            a.this.v = dVar.f58690g;
        }

        @Override // d.b.i0.p0.w1.a.InterfaceC1443a
        public void b(d.b.i0.p0.w1.d.d dVar) {
            if (dVar == null) {
                return;
            }
            a.this.M(dVar);
        }

        @Override // d.b.i0.p0.w1.a.InterfaceC1443a
        public void c(d.b.i0.p0.w1.d.d dVar) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(a.this.f58692a.getPageContext().getPageActivity()).createNormalConfig(Long.valueOf(dVar.f58690g).longValue(), String.valueOf(a.this.w).equals(dVar.f58690g), false)));
        }
    }

    /* loaded from: classes4.dex */
    public class g implements ViewTreeObserver.OnGlobalLayoutListener {
        public g() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Rect rect = new Rect();
            a.this.f58692a.getPageContext().getPageActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
            int r = l.r(a.this.f58692a.getPageContext().getPageActivity());
            int[] p = l.p(a.this.f58692a.getPageContext().getPageActivity());
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
        public final /* synthetic */ d.b.h0.r.s.a f58707e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.b.i0.p0.w1.d.d f58708f;

        public h(d.b.h0.r.s.a aVar, d.b.i0.p0.w1.d.d dVar) {
            this.f58707e = aVar;
            this.f58708f = dVar;
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            this.f58707e.dismiss();
            a.this.r(this.f58708f);
        }
    }

    /* loaded from: classes4.dex */
    public class i implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.r.s.a f58710e;

        public i(a aVar, d.b.h0.r.s.a aVar2) {
            this.f58710e = aVar2;
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            this.f58710e.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public class j implements TextWatcher {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f58711e;

        public j(int i) {
            this.f58711e = i;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (!TextUtils.isEmpty(charSequence)) {
                a.this.j.setEnabled(true);
                String charSequence2 = charSequence.toString();
                if (StringUtils.isNull(charSequence2)) {
                    return;
                }
                int b2 = i0.b(charSequence2);
                int i4 = this.f58711e;
                if (b2 > i4) {
                    String k = i0.k(charSequence2, 0, i4 - 1);
                    a.this.i.setText(k);
                    a.this.i.setSelection(a.this.i.getText().length());
                    UtilHelper.showToast(a.this.f58692a.getPageContext().getPageActivity().getApplication(), a.this.f58692a.getPageContext().getPageActivity().getResources().getString(R.string.edit_text_over_limit_tip, Integer.valueOf(k.length())));
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
        public final /* synthetic */ boolean f58713e;

        public k(boolean z) {
            this.f58713e = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.f58696e.setEnabled(this.f58713e);
        }
    }

    public a(FrsGameSubPbActivity frsGameSubPbActivity, View.OnClickListener onClickListener, String str) {
        this.f58692a = frsGameSubPbActivity;
        this.q = onClickListener;
        this.u = str;
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(frsGameSubPbActivity.getPageContext().getPageActivity()).inflate(R.layout.frs_game_sub_pb_activity, (ViewGroup) null);
        this.f58693b = relativeLayout;
        BdTypeListView bdTypeListView = (BdTypeListView) relativeLayout.findViewById(R.id.new_sub_pb_list);
        this.f58696e = bdTypeListView;
        bdTypeListView.setOnTouchListener(this.z);
        this.f58696e.setOnScrollListener(new d());
        this.f58695d = new d.b.i0.p0.w1.d.e(this.f58692a.getPageContext());
        this.f58694c = BdListViewHelper.d(this.f58692a.getActivity(), this.f58696e, BdListViewHelper.HeadType.DEFAULT);
        TextView textView = (TextView) this.f58693b.findViewById(R.id.subpb_editor_tool_comment_reply_text);
        this.k = textView;
        textView.setOnClickListener(this.q);
        this.l = (TextView) this.f58693b.findViewById(R.id.no_reply_list_view);
        this.f58698g = (FrameLayout) this.f58693b.findViewById(R.id.bottom_view);
        this.f58699h = (LinearLayout) this.f58693b.findViewById(R.id.subpb_editor_tool_comment_input_container);
        this.i = (EditText) this.f58693b.findViewById(R.id.subpb_editor_tool_comment_input_edit);
        TextView textView2 = (TextView) this.f58693b.findViewById(R.id.subpb_editor_tool_comment_send_tv);
        this.j = textView2;
        textView2.setOnClickListener(new e());
        this.m = (ProgressBar) this.f58693b.findViewById(R.id.progressBar);
        C();
        d.b.i0.p0.w1.b bVar = new d.b.i0.p0.w1.b(this.f58692a.getPageContext(), this.f58696e);
        this.p = bVar;
        bVar.b(new f());
        K(PbFullScreenEditorActivity.REPLY_MAX_SIZE);
        B();
        D(TbadkCoreApplication.getInst().getSkinType());
        this.t = new ArrayList();
        this.w = d.b.b.e.m.b.f(TbadkCoreApplication.getCurrentAccount(), 0L);
    }

    public void A(boolean z, String str, d.b.i0.p0.w1.d.d dVar) {
        if (z) {
            BdToast.d(this.f58692a.getPageContext().getPageActivity(), this.f58692a.getPageContext().getString(R.string.subpb_delete_comment_succ_tip), 1).q();
            this.t.remove(dVar);
            this.p.c(this.t);
            G(this.y);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = this.f58692a.getPageContext().getString(R.string.subpb_delete_comment_fail_tip);
        }
        BdToast.d(this.f58692a.getPageContext().getPageActivity(), str, 1).q();
    }

    public final void B() {
        this.r = new g();
        this.f58692a.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.r);
    }

    public final void C() {
        NavigationBar navigationBar = (NavigationBar) this.f58693b.findViewById(R.id.view_navigation_bar);
        this.f58697f = navigationBar;
        this.n = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.f58697f.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.n.getLayoutParams();
            int g2 = l.g(this.f58692a.getPageContext().getPageActivity(), R.dimen.ds30);
            layoutParams.height = g2;
            layoutParams.width = g2;
            backImageView.setLayoutParams(layoutParams);
        }
        View view = this.n;
        if (view != null && (view.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.n.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = -1;
            this.n.setPadding(l.g(this.f58692a.getPageContext().getPageActivity(), R.dimen.ds32), this.n.getPaddingTop(), this.n.getPaddingRight(), this.n.getPaddingBottom());
            this.n.setLayoutParams(layoutParams2);
        }
        if (this.f58697f.getBackImageView() != null) {
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f58697f.getBackImageView(), R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public void D(int i2) {
        this.f58692a.getLayoutMode().k(i2 == 1);
        this.f58692a.getLayoutMode().j(this.f58693b);
        SkinManager.setBackgroundColor(this.f58693b, R.color.CAM_X0201);
        this.f58697f.onChangeSkinType(this.f58692a.getPageContext(), i2);
        this.f58695d.d(i2);
        SkinManager.setViewTextColor(this.k, R.color.CAM_X0110);
        this.k.setAlpha(0.95f);
        SkinManager.setBackgroundResource(this.k, R.drawable.pb_ecomm_comment_bg);
        SkinManager.setViewTextColor(this.l, R.color.CAM_X0109);
        SkinManager.setBackgroundResource(this.f58699h, R.drawable.pb_ecomm_comment_bg);
        SkinManager.setViewTextColor(this.i, R.color.CAM_X0106);
        this.i.setHintTextColor(SkinManager.getColor(R.color.CAM_X0110));
        SkinManager.setViewTextColor(this.j, R.color.game_sub_pb_send_txt_color);
    }

    public void E() {
        if (this.r != null) {
            this.f58692a.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.r);
        }
    }

    public final void F(boolean z) {
        if (z) {
            Rect rect = new Rect();
            this.f58699h.getWindowVisibleDisplayFrame(rect);
            int e2 = (l.p(this.f58692a.getPageContext().getPageActivity())[1] - rect.bottom) - (MenuKeyUtils.hasSmartBar() ? l.e(this.f58692a.getPageContext().getPageActivity(), 48.0f) : 0);
            FrameLayout frameLayout = this.f58698g;
            frameLayout.scrollTo(frameLayout.getScrollX(), e2);
            return;
        }
        this.f58698g.setScrollY(0);
    }

    public final void G(boolean z) {
        if (ListUtils.isEmpty(this.t)) {
            this.f58696e.setNextPage(null);
            this.l.setVisibility(0);
        } else {
            this.f58696e.setNextPage(this.f58695d);
            this.l.setVisibility(8);
            if (z) {
                this.f58695d.O();
            } else {
                this.f58695d.f();
            }
        }
        L();
    }

    public void H(d.b.i0.p0.w1.c cVar) {
        this.o = cVar;
    }

    public void I(BdListView.p pVar) {
        this.f58696e.setOnSrollToBottomListener(pVar);
    }

    public final void J() {
        d.b.i0.p0.w1.d.b bVar = this.s;
        this.v = bVar != null ? bVar.f58683e : null;
    }

    public final void K(int i2) {
        this.i.addTextChangedListener(new j(i2));
    }

    public final void L() {
        if (!ListUtils.isEmpty(this.t)) {
            this.f58697f.setCenterTextTitle(String.format(this.f58692a.getResources().getString(R.string.subpb_floor_reply_count), StringHelper.numFormatOver10000(this.t.size())));
        } else {
            this.f58697f.setCenterTextTitle(this.f58692a.getResources().getString(R.string.reply));
        }
    }

    public final void M(d.b.i0.p0.w1.d.d dVar) {
        d.b.h0.r.s.a aVar = new d.b.h0.r.s.a(this.f58692a.getPageContext().getPageActivity());
        aVar.setTitle((String) null);
        aVar.setMessageId(R.string.del_all_post_confirm);
        aVar.setCanceledOnTouchOutside(true);
        aVar.setPositiveButton(R.string.dialog_ok, new h(aVar, dVar));
        aVar.setNegativeButton(R.string.dialog_cancel, new i(this, aVar));
        aVar.create(this.f58692a.getPageContext()).show();
    }

    public void N(View view) {
        NavigationBar navigationBar;
        if (this.f58694c == null || (navigationBar = this.f58697f) == null) {
            return;
        }
        if (navigationBar.isNavigationBarExcludeStatusbarVisible()) {
            this.f58697f.showNavigationBarExcludeStatusbar(false);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.f58694c.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight()));
            } else {
                BdTypeListView bdTypeListView = this.f58696e;
                if (bdTypeListView != null) {
                    bdTypeListView.removeHeaderView(this.f58694c);
                }
            }
            this.f58697f.setVisibility(8);
            return;
        }
        this.f58697f.showNavigationBarExcludeStatusbar(true);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.f58694c.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.g(this.f58692a.getActivity(), R.dimen.ds98)));
        } else {
            BdTypeListView bdTypeListView2 = this.f58696e;
            if (bdTypeListView2 != null) {
                bdTypeListView2.x(this.f58694c, 0);
            }
        }
        this.f58697f.setVisibility(0);
    }

    public void O(boolean z, d.b.i0.p0.w1.d.b bVar, List<n> list) {
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
        this.f58696e.setNextPage(this.f58695d);
        this.p.c(list);
        q();
        this.k.setVisibility(0);
        this.k.setText(R.string.say_your_point);
        G(z);
    }

    public void P(boolean z) {
        View view = this.f58694c;
        if (view == null || view.getLayoutParams() == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.f58694c.getLayoutParams();
        if (z) {
            q();
            layoutParams.height = l.g(this.f58692a.getPageContext().getPageActivity(), R.dimen.ds98);
        } else {
            layoutParams.height = l.g(this.f58692a.getPageContext().getPageActivity(), R.dimen.ds98) + UtilHelper.getLightStatusBarHeight();
        }
        this.f58694c.setLayoutParams(layoutParams);
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
        if (this.f58697f.getBackImageView() != null) {
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f58697f.getBackImageView(), R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public final void r(d.b.i0.p0.w1.d.d dVar) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_DELETE_SUB_COMMENT);
        httpMessage.addParam("user_id", this.w);
        httpMessage.addParam("main_tower_id", dVar.f58689f);
        httpMessage.addParam("id", dVar.f58688e);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public final void s(boolean z) {
        BdTypeListView bdTypeListView = this.f58696e;
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
        this.f58699h.setVisibility(0);
        this.i.post(new b());
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String format = String.format(this.f58692a.getPageContext().getPageActivity().getResources().getString(R.string.reply_sub_floor), str);
        this.i.setText(format);
        this.i.setSelection(format.length());
    }

    public ListView u() {
        return this.f58696e;
    }

    public NavigationBar v() {
        return this.f58697f;
    }

    public TextView w() {
        return this.k;
    }

    public View x() {
        return this.f58693b;
    }

    public View y() {
        return this.f58694c;
    }

    public void z(boolean z, String str, d.b.i0.p0.w1.d.d dVar) {
        Q(8);
        if (z && dVar != null) {
            BdToast.d(this.f58692a.getPageContext().getPageActivity(), this.f58692a.getPageContext().getString(R.string.subpb_add_comment_succ_tip), 1).q();
            this.i.setText((CharSequence) null);
            this.t.add(dVar);
            this.p.c(this.t);
            G(this.y);
            this.i.post(new RunnableC1446a());
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = this.f58692a.getPageContext().getString(R.string.subpb_add_comment_fail_tip);
        }
        BdToast.d(this.f58692a.getPageContext().getPageActivity(), str, 1).q();
    }
}

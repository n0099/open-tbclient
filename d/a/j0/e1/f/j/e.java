package d.a.j0.e1.f.j;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.chat.officialBar.OfficialBarTipActivity;
import com.baidu.tieba.im.chat.officialBar.OfficialBarTipListAdapter;
import d.a.c.e.p.l;
import java.util.List;
/* loaded from: classes4.dex */
public class e extends d.a.c.a.d<OfficialBarTipActivity> {

    /* renamed from: a  reason: collision with root package name */
    public BdListView f53514a;

    /* renamed from: b  reason: collision with root package name */
    public OfficialBarTipListAdapter f53515b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f53516c;

    /* renamed from: d  reason: collision with root package name */
    public NoDataView f53517d;

    /* renamed from: e  reason: collision with root package name */
    public NoNetworkView f53518e;

    /* renamed from: f  reason: collision with root package name */
    public OfficialBarTipActivity f53519f;

    /* renamed from: g  reason: collision with root package name */
    public ViewGroup f53520g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f53521h;

    /* renamed from: i  reason: collision with root package name */
    public RelativeLayout f53522i;
    public TextView j;
    public boolean k;
    public TextView l;
    public View m;
    public TextView n;
    public TextView o;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ OfficialBarTipActivity f53523e;

        public a(e eVar, OfficialBarTipActivity officialBarTipActivity) {
            this.f53523e = officialBarTipActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f53523e.finish();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ OfficialBarTipActivity f53524e;

        public b(OfficialBarTipActivity officialBarTipActivity) {
            this.f53524e = officialBarTipActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!e.this.f53521h) {
                if (e.this.f53519f.hasNoRead()) {
                    e.this.n.setVisibility(0);
                }
                e.this.p(this.f53524e, true);
                return;
            }
            e.this.p(this.f53524e, false);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ OfficialBarTipActivity f53526e;

        public c(OfficialBarTipActivity officialBarTipActivity) {
            this.f53526e = officialBarTipActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f53526e.deleteSelectedDatas();
            e.this.p(this.f53526e, false);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!e.this.k) {
                e.this.r(true);
            } else {
                e.this.r(false);
            }
        }
    }

    /* renamed from: d.a.j0.e1.f.j.e$e  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1219e implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ OfficialBarTipActivity f53529e;

        public View$OnClickListenerC1219e(OfficialBarTipActivity officialBarTipActivity) {
            this.f53529e = officialBarTipActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e.this.f53519f.setAllRead();
            e.this.p(this.f53529e, false);
        }
    }

    public e(OfficialBarTipActivity officialBarTipActivity) {
        super(officialBarTipActivity.getPageContext());
        this.f53521h = false;
        this.f53522i = null;
        this.k = false;
        officialBarTipActivity.setContentView(R.layout.officialbar_msg_activity);
        this.f53519f = officialBarTipActivity;
        m(officialBarTipActivity);
        n(officialBarTipActivity);
        l(officialBarTipActivity);
    }

    public OfficialBarTipListAdapter j() {
        return this.f53515b;
    }

    public BdListView k() {
        return this.f53514a;
    }

    public final void l(OfficialBarTipActivity officialBarTipActivity) {
        RelativeLayout relativeLayout = (RelativeLayout) officialBarTipActivity.findViewById(R.id.tip_footer);
        this.f53522i = relativeLayout;
        TextView textView = (TextView) relativeLayout.findViewById(R.id.delete_txt);
        this.l = textView;
        textView.setOnClickListener(new c(officialBarTipActivity));
        this.j = (TextView) this.f53522i.findViewById(R.id.select_all_txt);
        int g2 = l.g(this.f53519f.getPageContext().getPageActivity(), R.dimen.ds40);
        Drawable drawable = SkinManager.getDrawable(R.drawable.btn_bgb_choice_n);
        drawable.setBounds(0, 0, g2, g2);
        this.j.setText(this.f53519f.getPageContext().getString(R.string.select_all));
        this.j.setCompoundDrawables(drawable, null, null, null);
        this.j.setOnClickListener(new d());
    }

    public final void m(OfficialBarTipActivity officialBarTipActivity) {
        NavigationBar navigationBar = (NavigationBar) officialBarTipActivity.findViewById(R.id.view_navigation_bar);
        this.f53516c = navigationBar;
        navigationBar.setCenterTextTitle(officialBarTipActivity.getPageContext().getString(R.string.subscribe_forum_list));
        this.f53516c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a(this, officialBarTipActivity));
        this.f53516c.showBottomLine();
        ViewGroup viewGroup = (ViewGroup) officialBarTipActivity.findViewById(R.id.root_view);
        this.f53520g = viewGroup;
        this.f53518e = (NoNetworkView) viewGroup.findViewById(R.id.no_network_view);
        View inflate = LayoutInflater.from(this.f53519f.getBaseContext()).inflate(R.layout.im_ba_btn, (ViewGroup) null);
        this.m = inflate;
        inflate.setVisibility(8);
        TextView textView = (TextView) this.m.findViewById(R.id.all_read);
        this.n = textView;
        textView.setVisibility(8);
        TextView textView2 = (TextView) this.m.findViewById(R.id.edit);
        this.o = textView2;
        textView2.setVisibility(0);
        this.m = this.f53516c.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.m, (View.OnClickListener) null);
        this.o.setOnClickListener(new b(officialBarTipActivity));
    }

    public final void n(OfficialBarTipActivity officialBarTipActivity) {
        this.f53514a = (BdListView) officialBarTipActivity.findViewById(R.id.msg_list);
        OfficialBarTipListAdapter officialBarTipListAdapter = new OfficialBarTipListAdapter(officialBarTipActivity);
        this.f53515b = officialBarTipListAdapter;
        this.f53514a.setAdapter((ListAdapter) officialBarTipListAdapter);
        this.f53517d = NoDataViewFactory.a(officialBarTipActivity.getPageContext().getPageActivity(), this.f53520g, NoDataViewFactory.d.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.e.a(R.string.official_message_activity_no_data), null);
    }

    public void o(List<ImMessageCenterShowItemData> list) {
        this.f53515b.n(list);
        if (list == null || list.size() > 0) {
            return;
        }
        this.o.setVisibility(8);
    }

    public void onChangeSkinType(int i2) {
        this.f53519f.getLayoutMode().k(i2 == 1);
        this.f53519f.getLayoutMode().j(this.f53520g);
        this.f53516c.onChangeSkinType(this.f53519f.getPageContext(), i2);
        SkinManager.setNavbarTitleColor(this.o, R.color.navi_op_text, R.color.navi_op_text_skin);
        SkinManager.setNavbarTitleColor(this.n, R.color.navi_op_text, R.color.navi_op_text_skin);
        NoDataView noDataView = this.f53517d;
        if (noDataView != null) {
            noDataView.f(this.f53519f.getPageContext(), i2);
        }
        NoNetworkView noNetworkView = this.f53518e;
        if (noNetworkView != null) {
            noNetworkView.c(this.f53519f.getPageContext(), i2);
        }
        this.f53515b.notifyDataSetChanged();
    }

    public final void p(OfficialBarTipActivity officialBarTipActivity, boolean z) {
        if (z) {
            this.f53522i.setVisibility(0);
            this.f53515b.o(true);
            this.f53515b.notifyDataSetChanged();
            if (officialBarTipActivity.hasSelectedData()) {
                q(true);
            } else {
                q(false);
            }
            this.o.setText(officialBarTipActivity.getPageContext().getString(R.string.cancel));
            this.n.setOnClickListener(new View$OnClickListenerC1219e(officialBarTipActivity));
            this.f53521h = true;
            return;
        }
        this.f53522i.setVisibility(8);
        this.n.setVisibility(8);
        this.f53515b.o(false);
        this.f53515b.notifyDataSetChanged();
        this.o.setText(officialBarTipActivity.getPageContext().getString(R.string.edit));
        this.f53521h = false;
    }

    public void q(boolean z) {
        if (z) {
            this.l.setAlpha(1.0f);
            this.l.setEnabled(true);
            return;
        }
        this.l.setAlpha(0.3f);
        this.l.setEnabled(false);
    }

    public void r(boolean z) {
        int g2 = l.g(this.f53519f.getPageContext().getPageActivity(), R.dimen.ds40);
        if (z) {
            Drawable drawable = SkinManager.getDrawable(R.drawable.btn_bgb_choice_s);
            drawable.setBounds(0, 0, g2, g2);
            this.j.setText(this.f53519f.getPageContext().getString(R.string.cancel_select_all));
            this.j.setCompoundDrawables(drawable, null, null, null);
            q(true);
            this.k = true;
            this.f53519f.updateEditStatus(true);
            return;
        }
        Drawable drawable2 = SkinManager.getDrawable(R.drawable.btn_bgb_choice_n);
        drawable2.setBounds(0, 0, g2, g2);
        this.j.setText(this.f53519f.getPageContext().getString(R.string.select_all));
        this.j.setCompoundDrawables(drawable2, null, null, null);
        q(false);
        this.k = false;
        this.f53519f.updateEditStatus(false);
    }
}

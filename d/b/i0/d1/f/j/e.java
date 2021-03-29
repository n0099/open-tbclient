package d.b.i0.d1.f.j;

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
import d.b.b.e.p.l;
import java.util.List;
/* loaded from: classes3.dex */
public class e extends d.b.b.a.d<OfficialBarTipActivity> {

    /* renamed from: a  reason: collision with root package name */
    public BdListView f53719a;

    /* renamed from: b  reason: collision with root package name */
    public OfficialBarTipListAdapter f53720b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f53721c;

    /* renamed from: d  reason: collision with root package name */
    public NoDataView f53722d;

    /* renamed from: e  reason: collision with root package name */
    public NoNetworkView f53723e;

    /* renamed from: f  reason: collision with root package name */
    public OfficialBarTipActivity f53724f;

    /* renamed from: g  reason: collision with root package name */
    public ViewGroup f53725g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f53726h;
    public RelativeLayout i;
    public TextView j;
    public boolean k;
    public TextView l;
    public View m;
    public TextView n;
    public TextView o;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ OfficialBarTipActivity f53727e;

        public a(e eVar, OfficialBarTipActivity officialBarTipActivity) {
            this.f53727e = officialBarTipActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f53727e.finish();
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ OfficialBarTipActivity f53728e;

        public b(OfficialBarTipActivity officialBarTipActivity) {
            this.f53728e = officialBarTipActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!e.this.f53726h) {
                if (e.this.f53724f.hasNoRead()) {
                    e.this.n.setVisibility(0);
                }
                e.this.q(this.f53728e, true);
                return;
            }
            e.this.q(this.f53728e, false);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ OfficialBarTipActivity f53730e;

        public c(OfficialBarTipActivity officialBarTipActivity) {
            this.f53730e = officialBarTipActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f53730e.deleteSelectedDatas();
            e.this.q(this.f53730e, false);
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!e.this.k) {
                e.this.s(true);
            } else {
                e.this.s(false);
            }
        }
    }

    /* renamed from: d.b.i0.d1.f.j.e$e  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC1194e implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ OfficialBarTipActivity f53733e;

        public View$OnClickListenerC1194e(OfficialBarTipActivity officialBarTipActivity) {
            this.f53733e = officialBarTipActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e.this.f53724f.setAllRead();
            e.this.q(this.f53733e, false);
        }
    }

    public e(OfficialBarTipActivity officialBarTipActivity) {
        super(officialBarTipActivity.getPageContext());
        this.f53726h = false;
        this.i = null;
        this.k = false;
        officialBarTipActivity.setContentView(R.layout.officialbar_msg_activity);
        this.f53724f = officialBarTipActivity;
        m(officialBarTipActivity);
        n(officialBarTipActivity);
        l(officialBarTipActivity);
    }

    public OfficialBarTipListAdapter i() {
        return this.f53720b;
    }

    public BdListView k() {
        return this.f53719a;
    }

    public final void l(OfficialBarTipActivity officialBarTipActivity) {
        RelativeLayout relativeLayout = (RelativeLayout) officialBarTipActivity.findViewById(R.id.tip_footer);
        this.i = relativeLayout;
        TextView textView = (TextView) relativeLayout.findViewById(R.id.delete_txt);
        this.l = textView;
        textView.setOnClickListener(new c(officialBarTipActivity));
        this.j = (TextView) this.i.findViewById(R.id.select_all_txt);
        int g2 = l.g(this.f53724f.getPageContext().getPageActivity(), R.dimen.ds40);
        Drawable drawable = SkinManager.getDrawable(R.drawable.btn_bgb_choice_n);
        drawable.setBounds(0, 0, g2, g2);
        this.j.setText(this.f53724f.getPageContext().getString(R.string.select_all));
        this.j.setCompoundDrawables(drawable, null, null, null);
        this.j.setOnClickListener(new d());
    }

    public final void m(OfficialBarTipActivity officialBarTipActivity) {
        NavigationBar navigationBar = (NavigationBar) officialBarTipActivity.findViewById(R.id.view_navigation_bar);
        this.f53721c = navigationBar;
        navigationBar.setCenterTextTitle(officialBarTipActivity.getPageContext().getString(R.string.subscribe_forum_list));
        this.f53721c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a(this, officialBarTipActivity));
        this.f53721c.showBottomLine();
        ViewGroup viewGroup = (ViewGroup) officialBarTipActivity.findViewById(R.id.root_view);
        this.f53725g = viewGroup;
        this.f53723e = (NoNetworkView) viewGroup.findViewById(R.id.no_network_view);
        View inflate = LayoutInflater.from(this.f53724f.getBaseContext()).inflate(R.layout.im_ba_btn, (ViewGroup) null);
        this.m = inflate;
        inflate.setVisibility(8);
        TextView textView = (TextView) this.m.findViewById(R.id.all_read);
        this.n = textView;
        textView.setVisibility(8);
        TextView textView2 = (TextView) this.m.findViewById(R.id.edit);
        this.o = textView2;
        textView2.setVisibility(0);
        this.m = this.f53721c.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.m, (View.OnClickListener) null);
        this.o.setOnClickListener(new b(officialBarTipActivity));
    }

    public final void n(OfficialBarTipActivity officialBarTipActivity) {
        this.f53719a = (BdListView) officialBarTipActivity.findViewById(R.id.msg_list);
        OfficialBarTipListAdapter officialBarTipListAdapter = new OfficialBarTipListAdapter(officialBarTipActivity);
        this.f53720b = officialBarTipListAdapter;
        this.f53719a.setAdapter((ListAdapter) officialBarTipListAdapter);
        this.f53722d = NoDataViewFactory.a(officialBarTipActivity.getPageContext().getPageActivity(), this.f53725g, NoDataViewFactory.d.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.e.a(R.string.official_message_activity_no_data), null);
    }

    public void o(List<ImMessageCenterShowItemData> list) {
        this.f53720b.n(list);
        if (list == null || list.size() > 0) {
            return;
        }
        this.o.setVisibility(8);
    }

    public void onChangeSkinType(int i) {
        this.f53724f.getLayoutMode().k(i == 1);
        this.f53724f.getLayoutMode().j(this.f53725g);
        this.f53721c.onChangeSkinType(this.f53724f.getPageContext(), i);
        SkinManager.setNavbarTitleColor(this.o, R.color.navi_op_text, R.color.navi_op_text_skin);
        SkinManager.setNavbarTitleColor(this.n, R.color.navi_op_text, R.color.navi_op_text_skin);
        NoDataView noDataView = this.f53722d;
        if (noDataView != null) {
            noDataView.f(this.f53724f.getPageContext(), i);
        }
        NoNetworkView noNetworkView = this.f53723e;
        if (noNetworkView != null) {
            noNetworkView.c(this.f53724f.getPageContext(), i);
        }
        this.f53720b.notifyDataSetChanged();
    }

    public final void q(OfficialBarTipActivity officialBarTipActivity, boolean z) {
        if (z) {
            this.i.setVisibility(0);
            this.f53720b.o(true);
            this.f53720b.notifyDataSetChanged();
            if (officialBarTipActivity.hasSelectedData()) {
                r(true);
            } else {
                r(false);
            }
            this.o.setText(officialBarTipActivity.getPageContext().getString(R.string.cancel));
            this.n.setOnClickListener(new View$OnClickListenerC1194e(officialBarTipActivity));
            this.f53726h = true;
            return;
        }
        this.i.setVisibility(8);
        this.n.setVisibility(8);
        this.f53720b.o(false);
        this.f53720b.notifyDataSetChanged();
        this.o.setText(officialBarTipActivity.getPageContext().getString(R.string.edit));
        this.f53726h = false;
    }

    public void r(boolean z) {
        if (z) {
            this.l.setAlpha(1.0f);
            this.l.setEnabled(true);
            return;
        }
        this.l.setAlpha(0.3f);
        this.l.setEnabled(false);
    }

    public void s(boolean z) {
        int g2 = l.g(this.f53724f.getPageContext().getPageActivity(), R.dimen.ds40);
        if (z) {
            Drawable drawable = SkinManager.getDrawable(R.drawable.btn_bgb_choice_s);
            drawable.setBounds(0, 0, g2, g2);
            this.j.setText(this.f53724f.getPageContext().getString(R.string.cancel_select_all));
            this.j.setCompoundDrawables(drawable, null, null, null);
            r(true);
            this.k = true;
            this.f53724f.updateEditStatus(true);
            return;
        }
        Drawable drawable2 = SkinManager.getDrawable(R.drawable.btn_bgb_choice_n);
        drawable2.setBounds(0, 0, g2, g2);
        this.j.setText(this.f53724f.getPageContext().getString(R.string.select_all));
        this.j.setCompoundDrawables(drawable2, null, null, null);
        r(false);
        this.k = false;
        this.f53724f.updateEditStatus(false);
    }
}

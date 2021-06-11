package d.a.n0.f1.f.j;

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
    public BdListView f58100a;

    /* renamed from: b  reason: collision with root package name */
    public OfficialBarTipListAdapter f58101b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f58102c;

    /* renamed from: d  reason: collision with root package name */
    public NoDataView f58103d;

    /* renamed from: e  reason: collision with root package name */
    public NoNetworkView f58104e;

    /* renamed from: f  reason: collision with root package name */
    public OfficialBarTipActivity f58105f;

    /* renamed from: g  reason: collision with root package name */
    public ViewGroup f58106g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f58107h;

    /* renamed from: i  reason: collision with root package name */
    public RelativeLayout f58108i;
    public TextView j;
    public boolean k;
    public TextView l;
    public View m;
    public TextView n;
    public TextView o;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ OfficialBarTipActivity f58109e;

        public a(e eVar, OfficialBarTipActivity officialBarTipActivity) {
            this.f58109e = officialBarTipActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f58109e.finish();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ OfficialBarTipActivity f58110e;

        public b(OfficialBarTipActivity officialBarTipActivity) {
            this.f58110e = officialBarTipActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!e.this.f58107h) {
                if (e.this.f58105f.hasNoRead()) {
                    e.this.n.setVisibility(0);
                }
                e.this.p(this.f58110e, true);
                return;
            }
            e.this.p(this.f58110e, false);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ OfficialBarTipActivity f58112e;

        public c(OfficialBarTipActivity officialBarTipActivity) {
            this.f58112e = officialBarTipActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f58112e.deleteSelectedDatas();
            e.this.p(this.f58112e, false);
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

    /* renamed from: d.a.n0.f1.f.j.e$e  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1365e implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ OfficialBarTipActivity f58115e;

        public View$OnClickListenerC1365e(OfficialBarTipActivity officialBarTipActivity) {
            this.f58115e = officialBarTipActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e.this.f58105f.setAllRead();
            e.this.p(this.f58115e, false);
        }
    }

    public e(OfficialBarTipActivity officialBarTipActivity) {
        super(officialBarTipActivity.getPageContext());
        this.f58107h = false;
        this.f58108i = null;
        this.k = false;
        officialBarTipActivity.setContentView(R.layout.officialbar_msg_activity);
        this.f58105f = officialBarTipActivity;
        m(officialBarTipActivity);
        n(officialBarTipActivity);
        l(officialBarTipActivity);
    }

    public OfficialBarTipListAdapter i() {
        return this.f58101b;
    }

    public BdListView k() {
        return this.f58100a;
    }

    public final void l(OfficialBarTipActivity officialBarTipActivity) {
        RelativeLayout relativeLayout = (RelativeLayout) officialBarTipActivity.findViewById(R.id.tip_footer);
        this.f58108i = relativeLayout;
        TextView textView = (TextView) relativeLayout.findViewById(R.id.delete_txt);
        this.l = textView;
        textView.setOnClickListener(new c(officialBarTipActivity));
        this.j = (TextView) this.f58108i.findViewById(R.id.select_all_txt);
        int g2 = l.g(this.f58105f.getPageContext().getPageActivity(), R.dimen.ds40);
        Drawable drawable = SkinManager.getDrawable(R.drawable.btn_bgb_choice_n);
        drawable.setBounds(0, 0, g2, g2);
        this.j.setText(this.f58105f.getPageContext().getString(R.string.select_all));
        this.j.setCompoundDrawables(drawable, null, null, null);
        this.j.setOnClickListener(new d());
    }

    public final void m(OfficialBarTipActivity officialBarTipActivity) {
        NavigationBar navigationBar = (NavigationBar) officialBarTipActivity.findViewById(R.id.view_navigation_bar);
        this.f58102c = navigationBar;
        navigationBar.setCenterTextTitle(officialBarTipActivity.getPageContext().getString(R.string.subscribe_forum_list));
        this.f58102c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a(this, officialBarTipActivity));
        this.f58102c.showBottomLine();
        ViewGroup viewGroup = (ViewGroup) officialBarTipActivity.findViewById(R.id.root_view);
        this.f58106g = viewGroup;
        this.f58104e = (NoNetworkView) viewGroup.findViewById(R.id.no_network_view);
        View inflate = LayoutInflater.from(this.f58105f.getBaseContext()).inflate(R.layout.im_ba_btn, (ViewGroup) null);
        this.m = inflate;
        inflate.setVisibility(8);
        TextView textView = (TextView) this.m.findViewById(R.id.all_read);
        this.n = textView;
        textView.setVisibility(8);
        TextView textView2 = (TextView) this.m.findViewById(R.id.edit);
        this.o = textView2;
        textView2.setVisibility(0);
        this.m = this.f58102c.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.m, (View.OnClickListener) null);
        this.o.setOnClickListener(new b(officialBarTipActivity));
    }

    public final void n(OfficialBarTipActivity officialBarTipActivity) {
        this.f58100a = (BdListView) officialBarTipActivity.findViewById(R.id.msg_list);
        OfficialBarTipListAdapter officialBarTipListAdapter = new OfficialBarTipListAdapter(officialBarTipActivity);
        this.f58101b = officialBarTipListAdapter;
        this.f58100a.setAdapter((ListAdapter) officialBarTipListAdapter);
        this.f58103d = NoDataViewFactory.a(officialBarTipActivity.getPageContext().getPageActivity(), this.f58106g, NoDataViewFactory.d.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.e.a(R.string.official_message_activity_no_data), null);
    }

    public void o(List<ImMessageCenterShowItemData> list) {
        this.f58101b.n(list);
        if (list == null || list.size() > 0) {
            return;
        }
        this.o.setVisibility(8);
    }

    public void onChangeSkinType(int i2) {
        this.f58105f.getLayoutMode().k(i2 == 1);
        this.f58105f.getLayoutMode().j(this.f58106g);
        this.f58102c.onChangeSkinType(this.f58105f.getPageContext(), i2);
        SkinManager.setNavbarTitleColor(this.o, R.color.navi_op_text, R.color.navi_op_text_skin);
        SkinManager.setNavbarTitleColor(this.n, R.color.navi_op_text, R.color.navi_op_text_skin);
        NoDataView noDataView = this.f58103d;
        if (noDataView != null) {
            noDataView.f(this.f58105f.getPageContext(), i2);
        }
        NoNetworkView noNetworkView = this.f58104e;
        if (noNetworkView != null) {
            noNetworkView.c(this.f58105f.getPageContext(), i2);
        }
        this.f58101b.notifyDataSetChanged();
    }

    public final void p(OfficialBarTipActivity officialBarTipActivity, boolean z) {
        if (z) {
            this.f58108i.setVisibility(0);
            this.f58101b.o(true);
            this.f58101b.notifyDataSetChanged();
            if (officialBarTipActivity.hasSelectedData()) {
                q(true);
            } else {
                q(false);
            }
            this.o.setText(officialBarTipActivity.getPageContext().getString(R.string.cancel));
            this.n.setOnClickListener(new View$OnClickListenerC1365e(officialBarTipActivity));
            this.f58107h = true;
            return;
        }
        this.f58108i.setVisibility(8);
        this.n.setVisibility(8);
        this.f58101b.o(false);
        this.f58101b.notifyDataSetChanged();
        this.o.setText(officialBarTipActivity.getPageContext().getString(R.string.edit));
        this.f58107h = false;
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
        int g2 = l.g(this.f58105f.getPageContext().getPageActivity(), R.dimen.ds40);
        if (z) {
            Drawable drawable = SkinManager.getDrawable(R.drawable.btn_bgb_choice_s);
            drawable.setBounds(0, 0, g2, g2);
            this.j.setText(this.f58105f.getPageContext().getString(R.string.cancel_select_all));
            this.j.setCompoundDrawables(drawable, null, null, null);
            q(true);
            this.k = true;
            this.f58105f.updateEditStatus(true);
            return;
        }
        Drawable drawable2 = SkinManager.getDrawable(R.drawable.btn_bgb_choice_n);
        drawable2.setBounds(0, 0, g2, g2);
        this.j.setText(this.f58105f.getPageContext().getString(R.string.select_all));
        this.j.setCompoundDrawables(drawable2, null, null, null);
        q(false);
        this.k = false;
        this.f58105f.updateEditStatus(false);
    }
}

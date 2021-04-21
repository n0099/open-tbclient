package d.b.j0.e1.j;

import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.UpdatesItemData;
import com.baidu.tieba.im.groupUpdates.UpdatesActivity;
import d.b.c.a.d;
import java.util.List;
/* loaded from: classes4.dex */
public class c extends d<UpdatesActivity> {

    /* renamed from: a  reason: collision with root package name */
    public View f55817a;

    /* renamed from: b  reason: collision with root package name */
    public View f55818b;

    /* renamed from: c  reason: collision with root package name */
    public UpdatesActivity f55819c;

    /* renamed from: d  reason: collision with root package name */
    public BdListView f55820d;

    /* renamed from: e  reason: collision with root package name */
    public a f55821e;

    /* renamed from: f  reason: collision with root package name */
    public ProgressBar f55822f;

    /* renamed from: g  reason: collision with root package name */
    public Button f55823g;

    /* renamed from: h  reason: collision with root package name */
    public Button f55824h;
    public Button i;
    public NavigationBar j;
    public View k;
    public View l;

    public c(UpdatesActivity updatesActivity) {
        super(updatesActivity.getPageContext());
        this.f55819c = updatesActivity;
        n();
        a aVar = new a(this.f55819c);
        this.f55821e = aVar;
        this.f55820d.setAdapter((ListAdapter) aVar);
        this.f55820d.setOnScrollListener(this.f55819c);
    }

    public void d() {
        this.f55823g.setVisibility(0);
        this.f55818b.setVisibility(0);
        this.f55824h.setVisibility(8);
        this.k.setVisibility(8);
        r(0);
        o();
    }

    @Override // d.b.c.a.d
    public void destroy() {
        super.destroy();
        a aVar = this.f55821e;
        if (aVar != null) {
            aVar.a();
            this.f55821e = null;
        }
        this.f55819c = null;
    }

    public void e() {
        this.f55823g.setVisibility(8);
        this.f55818b.setVisibility(8);
        this.f55824h.setVisibility(0);
        this.k.setVisibility(0);
        o();
    }

    public View f() {
        return this.f55818b;
    }

    public Button h() {
        return this.f55824h;
    }

    public Button i() {
        return this.i;
    }

    public Button k() {
        return this.f55823g;
    }

    public a l() {
        return this.f55821e;
    }

    public BdListView m() {
        return this.f55820d;
    }

    public void n() {
        View inflate = View.inflate(this.f55819c.getPageContext().getPageActivity(), R.layout.updates_activity, null);
        this.f55817a = inflate;
        this.f55819c.setContentView(inflate);
        NavigationBar navigationBar = (NavigationBar) this.f55819c.findViewById(R.id.view_navigation_bar);
        this.j = navigationBar;
        this.f55818b = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.j.setTitleText(this.f55819c.getPageContext().getString(R.string.updates_activity_title));
        this.k = this.j.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.updates_activity_nav_left, (View.OnClickListener) null);
        this.l = this.j.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.updates_activity_nav_right, (View.OnClickListener) null);
        Button button = (Button) this.k.findViewById(R.id.btn_delete);
        this.i = button;
        button.setOnClickListener(this.f55819c);
        this.f55818b.setOnClickListener(this.f55819c);
        this.f55820d = (BdListView) this.f55817a.findViewById(R.id.updates_list);
        this.f55822f = (ProgressBar) this.f55817a.findViewById(R.id.pro_load);
        Button button2 = (Button) this.l.findViewById(R.id.btn_edit);
        this.f55823g = button2;
        button2.setOnClickListener(this.f55819c);
        Button button3 = (Button) this.l.findViewById(R.id.btn_cancel);
        this.f55824h = button3;
        button3.setOnClickListener(this.f55819c);
        r(0);
        s(false);
    }

    public void o() {
        a aVar = this.f55821e;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    public void onChangeSkinType(int i) {
        this.f55819c.getLayoutMode().k(i == 1);
        this.f55819c.getLayoutMode().j(this.f55817a);
        this.j.onChangeSkinType(this.f55819c.getPageContext(), i);
        SkinManager.setBackgroundResource(this.i, R.drawable.btn_delete_groupupdates);
    }

    public void q(List<UpdatesItemData> list) {
        a aVar = this.f55821e;
        if (aVar != null) {
            aVar.c(list);
        }
    }

    public void r(int i) {
        UpdatesActivity updatesActivity;
        Button button = this.i;
        if (button == null || (updatesActivity = this.f55819c) == null) {
            return;
        }
        button.setText(String.format(updatesActivity.getPageContext().getString(R.string.del_count), Integer.valueOf(i)));
        if (i == 0) {
            this.i.setEnabled(false);
        } else {
            this.i.setEnabled(true);
        }
    }

    public void s(boolean z) {
        this.f55822f.setVisibility(z ? 0 : 8);
    }
}

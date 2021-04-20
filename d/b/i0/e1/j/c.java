package d.b.i0.e1.j;

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
    public View f55396a;

    /* renamed from: b  reason: collision with root package name */
    public View f55397b;

    /* renamed from: c  reason: collision with root package name */
    public UpdatesActivity f55398c;

    /* renamed from: d  reason: collision with root package name */
    public BdListView f55399d;

    /* renamed from: e  reason: collision with root package name */
    public a f55400e;

    /* renamed from: f  reason: collision with root package name */
    public ProgressBar f55401f;

    /* renamed from: g  reason: collision with root package name */
    public Button f55402g;

    /* renamed from: h  reason: collision with root package name */
    public Button f55403h;
    public Button i;
    public NavigationBar j;
    public View k;
    public View l;

    public c(UpdatesActivity updatesActivity) {
        super(updatesActivity.getPageContext());
        this.f55398c = updatesActivity;
        n();
        a aVar = new a(this.f55398c);
        this.f55400e = aVar;
        this.f55399d.setAdapter((ListAdapter) aVar);
        this.f55399d.setOnScrollListener(this.f55398c);
    }

    public void d() {
        this.f55402g.setVisibility(0);
        this.f55397b.setVisibility(0);
        this.f55403h.setVisibility(8);
        this.k.setVisibility(8);
        r(0);
        o();
    }

    @Override // d.b.c.a.d
    public void destroy() {
        super.destroy();
        a aVar = this.f55400e;
        if (aVar != null) {
            aVar.a();
            this.f55400e = null;
        }
        this.f55398c = null;
    }

    public void e() {
        this.f55402g.setVisibility(8);
        this.f55397b.setVisibility(8);
        this.f55403h.setVisibility(0);
        this.k.setVisibility(0);
        o();
    }

    public View f() {
        return this.f55397b;
    }

    public Button h() {
        return this.f55403h;
    }

    public Button i() {
        return this.i;
    }

    public Button k() {
        return this.f55402g;
    }

    public a l() {
        return this.f55400e;
    }

    public BdListView m() {
        return this.f55399d;
    }

    public void n() {
        View inflate = View.inflate(this.f55398c.getPageContext().getPageActivity(), R.layout.updates_activity, null);
        this.f55396a = inflate;
        this.f55398c.setContentView(inflate);
        NavigationBar navigationBar = (NavigationBar) this.f55398c.findViewById(R.id.view_navigation_bar);
        this.j = navigationBar;
        this.f55397b = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.j.setTitleText(this.f55398c.getPageContext().getString(R.string.updates_activity_title));
        this.k = this.j.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.updates_activity_nav_left, (View.OnClickListener) null);
        this.l = this.j.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.updates_activity_nav_right, (View.OnClickListener) null);
        Button button = (Button) this.k.findViewById(R.id.btn_delete);
        this.i = button;
        button.setOnClickListener(this.f55398c);
        this.f55397b.setOnClickListener(this.f55398c);
        this.f55399d = (BdListView) this.f55396a.findViewById(R.id.updates_list);
        this.f55401f = (ProgressBar) this.f55396a.findViewById(R.id.pro_load);
        Button button2 = (Button) this.l.findViewById(R.id.btn_edit);
        this.f55402g = button2;
        button2.setOnClickListener(this.f55398c);
        Button button3 = (Button) this.l.findViewById(R.id.btn_cancel);
        this.f55403h = button3;
        button3.setOnClickListener(this.f55398c);
        r(0);
        s(false);
    }

    public void o() {
        a aVar = this.f55400e;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    public void onChangeSkinType(int i) {
        this.f55398c.getLayoutMode().k(i == 1);
        this.f55398c.getLayoutMode().j(this.f55396a);
        this.j.onChangeSkinType(this.f55398c.getPageContext(), i);
        SkinManager.setBackgroundResource(this.i, R.drawable.btn_delete_groupupdates);
    }

    public void q(List<UpdatesItemData> list) {
        a aVar = this.f55400e;
        if (aVar != null) {
            aVar.c(list);
        }
    }

    public void r(int i) {
        UpdatesActivity updatesActivity;
        Button button = this.i;
        if (button == null || (updatesActivity = this.f55398c) == null) {
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
        this.f55401f.setVisibility(z ? 0 : 8);
    }
}

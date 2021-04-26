package d.a.j0.e1.j;

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
import d.a.c.a.d;
import java.util.List;
/* loaded from: classes4.dex */
public class c extends d<UpdatesActivity> {

    /* renamed from: a  reason: collision with root package name */
    public View f53676a;

    /* renamed from: b  reason: collision with root package name */
    public View f53677b;

    /* renamed from: c  reason: collision with root package name */
    public UpdatesActivity f53678c;

    /* renamed from: d  reason: collision with root package name */
    public BdListView f53679d;

    /* renamed from: e  reason: collision with root package name */
    public a f53680e;

    /* renamed from: f  reason: collision with root package name */
    public ProgressBar f53681f;

    /* renamed from: g  reason: collision with root package name */
    public Button f53682g;

    /* renamed from: h  reason: collision with root package name */
    public Button f53683h;

    /* renamed from: i  reason: collision with root package name */
    public Button f53684i;
    public NavigationBar j;
    public View k;
    public View l;

    public c(UpdatesActivity updatesActivity) {
        super(updatesActivity.getPageContext());
        this.f53678c = updatesActivity;
        m();
        a aVar = new a(this.f53678c);
        this.f53680e = aVar;
        this.f53679d.setAdapter((ListAdapter) aVar);
        this.f53679d.setOnScrollListener(this.f53678c);
    }

    public void d() {
        this.f53682g.setVisibility(0);
        this.f53677b.setVisibility(0);
        this.f53683h.setVisibility(8);
        this.k.setVisibility(8);
        p(0);
        n();
    }

    @Override // d.a.c.a.d
    public void destroy() {
        super.destroy();
        a aVar = this.f53680e;
        if (aVar != null) {
            aVar.a();
            this.f53680e = null;
        }
        this.f53678c = null;
    }

    public void e() {
        this.f53682g.setVisibility(8);
        this.f53677b.setVisibility(8);
        this.f53683h.setVisibility(0);
        this.k.setVisibility(0);
        n();
    }

    public View f() {
        return this.f53677b;
    }

    public Button g() {
        return this.f53683h;
    }

    public Button h() {
        return this.f53684i;
    }

    public Button j() {
        return this.f53682g;
    }

    public a k() {
        return this.f53680e;
    }

    public BdListView l() {
        return this.f53679d;
    }

    public void m() {
        View inflate = View.inflate(this.f53678c.getPageContext().getPageActivity(), R.layout.updates_activity, null);
        this.f53676a = inflate;
        this.f53678c.setContentView(inflate);
        NavigationBar navigationBar = (NavigationBar) this.f53678c.findViewById(R.id.view_navigation_bar);
        this.j = navigationBar;
        this.f53677b = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.j.setTitleText(this.f53678c.getPageContext().getString(R.string.updates_activity_title));
        this.k = this.j.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.updates_activity_nav_left, (View.OnClickListener) null);
        this.l = this.j.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.updates_activity_nav_right, (View.OnClickListener) null);
        Button button = (Button) this.k.findViewById(R.id.btn_delete);
        this.f53684i = button;
        button.setOnClickListener(this.f53678c);
        this.f53677b.setOnClickListener(this.f53678c);
        this.f53679d = (BdListView) this.f53676a.findViewById(R.id.updates_list);
        this.f53681f = (ProgressBar) this.f53676a.findViewById(R.id.pro_load);
        Button button2 = (Button) this.l.findViewById(R.id.btn_edit);
        this.f53682g = button2;
        button2.setOnClickListener(this.f53678c);
        Button button3 = (Button) this.l.findViewById(R.id.btn_cancel);
        this.f53683h = button3;
        button3.setOnClickListener(this.f53678c);
        p(0);
        q(false);
    }

    public void n() {
        a aVar = this.f53680e;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    public void o(List<UpdatesItemData> list) {
        a aVar = this.f53680e;
        if (aVar != null) {
            aVar.c(list);
        }
    }

    public void onChangeSkinType(int i2) {
        this.f53678c.getLayoutMode().k(i2 == 1);
        this.f53678c.getLayoutMode().j(this.f53676a);
        this.j.onChangeSkinType(this.f53678c.getPageContext(), i2);
        SkinManager.setBackgroundResource(this.f53684i, R.drawable.btn_delete_groupupdates);
    }

    public void p(int i2) {
        UpdatesActivity updatesActivity;
        Button button = this.f53684i;
        if (button == null || (updatesActivity = this.f53678c) == null) {
            return;
        }
        button.setText(String.format(updatesActivity.getPageContext().getString(R.string.del_count), Integer.valueOf(i2)));
        if (i2 == 0) {
            this.f53684i.setEnabled(false);
        } else {
            this.f53684i.setEnabled(true);
        }
    }

    public void q(boolean z) {
        this.f53681f.setVisibility(z ? 0 : 8);
    }
}

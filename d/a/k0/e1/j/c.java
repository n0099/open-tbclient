package d.a.k0.e1.j;

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
    public View f54383a;

    /* renamed from: b  reason: collision with root package name */
    public View f54384b;

    /* renamed from: c  reason: collision with root package name */
    public UpdatesActivity f54385c;

    /* renamed from: d  reason: collision with root package name */
    public BdListView f54386d;

    /* renamed from: e  reason: collision with root package name */
    public a f54387e;

    /* renamed from: f  reason: collision with root package name */
    public ProgressBar f54388f;

    /* renamed from: g  reason: collision with root package name */
    public Button f54389g;

    /* renamed from: h  reason: collision with root package name */
    public Button f54390h;

    /* renamed from: i  reason: collision with root package name */
    public Button f54391i;
    public NavigationBar j;
    public View k;
    public View l;

    public c(UpdatesActivity updatesActivity) {
        super(updatesActivity.getPageContext());
        this.f54385c = updatesActivity;
        m();
        a aVar = new a(this.f54385c);
        this.f54387e = aVar;
        this.f54386d.setAdapter((ListAdapter) aVar);
        this.f54386d.setOnScrollListener(this.f54385c);
    }

    public void d() {
        this.f54389g.setVisibility(0);
        this.f54384b.setVisibility(0);
        this.f54390h.setVisibility(8);
        this.k.setVisibility(8);
        p(0);
        n();
    }

    @Override // d.a.c.a.d
    public void destroy() {
        super.destroy();
        a aVar = this.f54387e;
        if (aVar != null) {
            aVar.a();
            this.f54387e = null;
        }
        this.f54385c = null;
    }

    public void e() {
        this.f54389g.setVisibility(8);
        this.f54384b.setVisibility(8);
        this.f54390h.setVisibility(0);
        this.k.setVisibility(0);
        n();
    }

    public View f() {
        return this.f54384b;
    }

    public Button g() {
        return this.f54390h;
    }

    public Button h() {
        return this.f54391i;
    }

    public Button j() {
        return this.f54389g;
    }

    public a k() {
        return this.f54387e;
    }

    public BdListView l() {
        return this.f54386d;
    }

    public void m() {
        View inflate = View.inflate(this.f54385c.getPageContext().getPageActivity(), R.layout.updates_activity, null);
        this.f54383a = inflate;
        this.f54385c.setContentView(inflate);
        NavigationBar navigationBar = (NavigationBar) this.f54385c.findViewById(R.id.view_navigation_bar);
        this.j = navigationBar;
        this.f54384b = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.j.setTitleText(this.f54385c.getPageContext().getString(R.string.updates_activity_title));
        this.k = this.j.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.updates_activity_nav_left, (View.OnClickListener) null);
        this.l = this.j.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.updates_activity_nav_right, (View.OnClickListener) null);
        Button button = (Button) this.k.findViewById(R.id.btn_delete);
        this.f54391i = button;
        button.setOnClickListener(this.f54385c);
        this.f54384b.setOnClickListener(this.f54385c);
        this.f54386d = (BdListView) this.f54383a.findViewById(R.id.updates_list);
        this.f54388f = (ProgressBar) this.f54383a.findViewById(R.id.pro_load);
        Button button2 = (Button) this.l.findViewById(R.id.btn_edit);
        this.f54389g = button2;
        button2.setOnClickListener(this.f54385c);
        Button button3 = (Button) this.l.findViewById(R.id.btn_cancel);
        this.f54390h = button3;
        button3.setOnClickListener(this.f54385c);
        p(0);
        q(false);
    }

    public void n() {
        a aVar = this.f54387e;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    public void o(List<UpdatesItemData> list) {
        a aVar = this.f54387e;
        if (aVar != null) {
            aVar.c(list);
        }
    }

    public void onChangeSkinType(int i2) {
        this.f54385c.getLayoutMode().k(i2 == 1);
        this.f54385c.getLayoutMode().j(this.f54383a);
        this.j.onChangeSkinType(this.f54385c.getPageContext(), i2);
        SkinManager.setBackgroundResource(this.f54391i, R.drawable.btn_delete_groupupdates);
    }

    public void p(int i2) {
        UpdatesActivity updatesActivity;
        Button button = this.f54391i;
        if (button == null || (updatesActivity = this.f54385c) == null) {
            return;
        }
        button.setText(String.format(updatesActivity.getPageContext().getString(R.string.del_count), Integer.valueOf(i2)));
        if (i2 == 0) {
            this.f54391i.setEnabled(false);
        } else {
            this.f54391i.setEnabled(true);
        }
    }

    public void q(boolean z) {
        this.f54388f.setVisibility(z ? 0 : 8);
    }
}

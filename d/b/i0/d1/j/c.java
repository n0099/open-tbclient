package d.b.i0.d1.j;

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
import d.b.b.a.d;
import java.util.List;
/* loaded from: classes3.dex */
public class c extends d<UpdatesActivity> {

    /* renamed from: a  reason: collision with root package name */
    public View f53874a;

    /* renamed from: b  reason: collision with root package name */
    public View f53875b;

    /* renamed from: c  reason: collision with root package name */
    public UpdatesActivity f53876c;

    /* renamed from: d  reason: collision with root package name */
    public BdListView f53877d;

    /* renamed from: e  reason: collision with root package name */
    public a f53878e;

    /* renamed from: f  reason: collision with root package name */
    public ProgressBar f53879f;

    /* renamed from: g  reason: collision with root package name */
    public Button f53880g;

    /* renamed from: h  reason: collision with root package name */
    public Button f53881h;
    public Button i;
    public NavigationBar j;
    public View k;
    public View l;

    public c(UpdatesActivity updatesActivity) {
        super(updatesActivity.getPageContext());
        this.f53876c = updatesActivity;
        n();
        a aVar = new a(this.f53876c);
        this.f53878e = aVar;
        this.f53877d.setAdapter((ListAdapter) aVar);
        this.f53877d.setOnScrollListener(this.f53876c);
    }

    public void d() {
        this.f53880g.setVisibility(0);
        this.f53875b.setVisibility(0);
        this.f53881h.setVisibility(8);
        this.k.setVisibility(8);
        r(0);
        o();
    }

    @Override // d.b.b.a.d
    public void destroy() {
        super.destroy();
        a aVar = this.f53878e;
        if (aVar != null) {
            aVar.a();
            this.f53878e = null;
        }
        this.f53876c = null;
    }

    public void e() {
        this.f53880g.setVisibility(8);
        this.f53875b.setVisibility(8);
        this.f53881h.setVisibility(0);
        this.k.setVisibility(0);
        o();
    }

    public View f() {
        return this.f53875b;
    }

    public Button h() {
        return this.f53881h;
    }

    public Button i() {
        return this.i;
    }

    public Button k() {
        return this.f53880g;
    }

    public a l() {
        return this.f53878e;
    }

    public BdListView m() {
        return this.f53877d;
    }

    public void n() {
        View inflate = View.inflate(this.f53876c.getPageContext().getPageActivity(), R.layout.updates_activity, null);
        this.f53874a = inflate;
        this.f53876c.setContentView(inflate);
        NavigationBar navigationBar = (NavigationBar) this.f53876c.findViewById(R.id.view_navigation_bar);
        this.j = navigationBar;
        this.f53875b = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.j.setTitleText(this.f53876c.getPageContext().getString(R.string.updates_activity_title));
        this.k = this.j.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.updates_activity_nav_left, (View.OnClickListener) null);
        this.l = this.j.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.updates_activity_nav_right, (View.OnClickListener) null);
        Button button = (Button) this.k.findViewById(R.id.btn_delete);
        this.i = button;
        button.setOnClickListener(this.f53876c);
        this.f53875b.setOnClickListener(this.f53876c);
        this.f53877d = (BdListView) this.f53874a.findViewById(R.id.updates_list);
        this.f53879f = (ProgressBar) this.f53874a.findViewById(R.id.pro_load);
        Button button2 = (Button) this.l.findViewById(R.id.btn_edit);
        this.f53880g = button2;
        button2.setOnClickListener(this.f53876c);
        Button button3 = (Button) this.l.findViewById(R.id.btn_cancel);
        this.f53881h = button3;
        button3.setOnClickListener(this.f53876c);
        r(0);
        s(false);
    }

    public void o() {
        a aVar = this.f53878e;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    public void onChangeSkinType(int i) {
        this.f53876c.getLayoutMode().k(i == 1);
        this.f53876c.getLayoutMode().j(this.f53874a);
        this.j.onChangeSkinType(this.f53876c.getPageContext(), i);
        SkinManager.setBackgroundResource(this.i, R.drawable.btn_delete_groupupdates);
    }

    public void q(List<UpdatesItemData> list) {
        a aVar = this.f53878e;
        if (aVar != null) {
            aVar.c(list);
        }
    }

    public void r(int i) {
        UpdatesActivity updatesActivity;
        Button button = this.i;
        if (button == null || (updatesActivity = this.f53876c) == null) {
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
        this.f53879f.setVisibility(z ? 0 : 8);
    }
}

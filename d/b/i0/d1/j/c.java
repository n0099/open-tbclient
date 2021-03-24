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
/* loaded from: classes4.dex */
public class c extends d<UpdatesActivity> {

    /* renamed from: a  reason: collision with root package name */
    public View f53873a;

    /* renamed from: b  reason: collision with root package name */
    public View f53874b;

    /* renamed from: c  reason: collision with root package name */
    public UpdatesActivity f53875c;

    /* renamed from: d  reason: collision with root package name */
    public BdListView f53876d;

    /* renamed from: e  reason: collision with root package name */
    public a f53877e;

    /* renamed from: f  reason: collision with root package name */
    public ProgressBar f53878f;

    /* renamed from: g  reason: collision with root package name */
    public Button f53879g;

    /* renamed from: h  reason: collision with root package name */
    public Button f53880h;
    public Button i;
    public NavigationBar j;
    public View k;
    public View l;

    public c(UpdatesActivity updatesActivity) {
        super(updatesActivity.getPageContext());
        this.f53875c = updatesActivity;
        n();
        a aVar = new a(this.f53875c);
        this.f53877e = aVar;
        this.f53876d.setAdapter((ListAdapter) aVar);
        this.f53876d.setOnScrollListener(this.f53875c);
    }

    public void d() {
        this.f53879g.setVisibility(0);
        this.f53874b.setVisibility(0);
        this.f53880h.setVisibility(8);
        this.k.setVisibility(8);
        r(0);
        o();
    }

    @Override // d.b.b.a.d
    public void destroy() {
        super.destroy();
        a aVar = this.f53877e;
        if (aVar != null) {
            aVar.a();
            this.f53877e = null;
        }
        this.f53875c = null;
    }

    public void e() {
        this.f53879g.setVisibility(8);
        this.f53874b.setVisibility(8);
        this.f53880h.setVisibility(0);
        this.k.setVisibility(0);
        o();
    }

    public View f() {
        return this.f53874b;
    }

    public Button h() {
        return this.f53880h;
    }

    public Button i() {
        return this.i;
    }

    public Button k() {
        return this.f53879g;
    }

    public a l() {
        return this.f53877e;
    }

    public BdListView m() {
        return this.f53876d;
    }

    public void n() {
        View inflate = View.inflate(this.f53875c.getPageContext().getPageActivity(), R.layout.updates_activity, null);
        this.f53873a = inflate;
        this.f53875c.setContentView(inflate);
        NavigationBar navigationBar = (NavigationBar) this.f53875c.findViewById(R.id.view_navigation_bar);
        this.j = navigationBar;
        this.f53874b = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.j.setTitleText(this.f53875c.getPageContext().getString(R.string.updates_activity_title));
        this.k = this.j.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.updates_activity_nav_left, (View.OnClickListener) null);
        this.l = this.j.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.updates_activity_nav_right, (View.OnClickListener) null);
        Button button = (Button) this.k.findViewById(R.id.btn_delete);
        this.i = button;
        button.setOnClickListener(this.f53875c);
        this.f53874b.setOnClickListener(this.f53875c);
        this.f53876d = (BdListView) this.f53873a.findViewById(R.id.updates_list);
        this.f53878f = (ProgressBar) this.f53873a.findViewById(R.id.pro_load);
        Button button2 = (Button) this.l.findViewById(R.id.btn_edit);
        this.f53879g = button2;
        button2.setOnClickListener(this.f53875c);
        Button button3 = (Button) this.l.findViewById(R.id.btn_cancel);
        this.f53880h = button3;
        button3.setOnClickListener(this.f53875c);
        r(0);
        s(false);
    }

    public void o() {
        a aVar = this.f53877e;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    public void onChangeSkinType(int i) {
        this.f53875c.getLayoutMode().k(i == 1);
        this.f53875c.getLayoutMode().j(this.f53873a);
        this.j.onChangeSkinType(this.f53875c.getPageContext(), i);
        SkinManager.setBackgroundResource(this.i, R.drawable.btn_delete_groupupdates);
    }

    public void q(List<UpdatesItemData> list) {
        a aVar = this.f53877e;
        if (aVar != null) {
            aVar.c(list);
        }
    }

    public void r(int i) {
        UpdatesActivity updatesActivity;
        Button button = this.i;
        if (button == null || (updatesActivity = this.f53875c) == null) {
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
        this.f53878f.setVisibility(z ? 0 : 8);
    }
}

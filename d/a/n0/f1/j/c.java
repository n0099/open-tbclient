package d.a.n0.f1.j;

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
    public View f58262a;

    /* renamed from: b  reason: collision with root package name */
    public View f58263b;

    /* renamed from: c  reason: collision with root package name */
    public UpdatesActivity f58264c;

    /* renamed from: d  reason: collision with root package name */
    public BdListView f58265d;

    /* renamed from: e  reason: collision with root package name */
    public a f58266e;

    /* renamed from: f  reason: collision with root package name */
    public ProgressBar f58267f;

    /* renamed from: g  reason: collision with root package name */
    public Button f58268g;

    /* renamed from: h  reason: collision with root package name */
    public Button f58269h;

    /* renamed from: i  reason: collision with root package name */
    public Button f58270i;
    public NavigationBar j;
    public View k;
    public View l;

    public c(UpdatesActivity updatesActivity) {
        super(updatesActivity.getPageContext());
        this.f58264c = updatesActivity;
        n();
        a aVar = new a(this.f58264c);
        this.f58266e = aVar;
        this.f58265d.setAdapter((ListAdapter) aVar);
        this.f58265d.setOnScrollListener(this.f58264c);
    }

    public void d() {
        this.f58268g.setVisibility(0);
        this.f58263b.setVisibility(0);
        this.f58269h.setVisibility(8);
        this.k.setVisibility(8);
        q(0);
        o();
    }

    @Override // d.a.c.a.d
    public void destroy() {
        super.destroy();
        a aVar = this.f58266e;
        if (aVar != null) {
            aVar.a();
            this.f58266e = null;
        }
        this.f58264c = null;
    }

    public void e() {
        this.f58268g.setVisibility(8);
        this.f58263b.setVisibility(8);
        this.f58269h.setVisibility(0);
        this.k.setVisibility(0);
        o();
    }

    public View f() {
        return this.f58263b;
    }

    public Button h() {
        return this.f58269h;
    }

    public Button i() {
        return this.f58270i;
    }

    public Button k() {
        return this.f58268g;
    }

    public a l() {
        return this.f58266e;
    }

    public BdListView m() {
        return this.f58265d;
    }

    public void n() {
        View inflate = View.inflate(this.f58264c.getPageContext().getPageActivity(), R.layout.updates_activity, null);
        this.f58262a = inflate;
        this.f58264c.setContentView(inflate);
        NavigationBar navigationBar = (NavigationBar) this.f58264c.findViewById(R.id.view_navigation_bar);
        this.j = navigationBar;
        this.f58263b = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.j.setTitleText(this.f58264c.getPageContext().getString(R.string.updates_activity_title));
        this.k = this.j.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.updates_activity_nav_left, (View.OnClickListener) null);
        this.l = this.j.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.updates_activity_nav_right, (View.OnClickListener) null);
        Button button = (Button) this.k.findViewById(R.id.btn_delete);
        this.f58270i = button;
        button.setOnClickListener(this.f58264c);
        this.f58263b.setOnClickListener(this.f58264c);
        this.f58265d = (BdListView) this.f58262a.findViewById(R.id.updates_list);
        this.f58267f = (ProgressBar) this.f58262a.findViewById(R.id.pro_load);
        Button button2 = (Button) this.l.findViewById(R.id.btn_edit);
        this.f58268g = button2;
        button2.setOnClickListener(this.f58264c);
        Button button3 = (Button) this.l.findViewById(R.id.btn_cancel);
        this.f58269h = button3;
        button3.setOnClickListener(this.f58264c);
        q(0);
        r(false);
    }

    public void o() {
        a aVar = this.f58266e;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    public void onChangeSkinType(int i2) {
        this.f58264c.getLayoutMode().k(i2 == 1);
        this.f58264c.getLayoutMode().j(this.f58262a);
        this.j.onChangeSkinType(this.f58264c.getPageContext(), i2);
        SkinManager.setBackgroundResource(this.f58270i, R.drawable.btn_delete_groupupdates);
    }

    public void p(List<UpdatesItemData> list) {
        a aVar = this.f58266e;
        if (aVar != null) {
            aVar.c(list);
        }
    }

    public void q(int i2) {
        UpdatesActivity updatesActivity;
        Button button = this.f58270i;
        if (button == null || (updatesActivity = this.f58264c) == null) {
            return;
        }
        button.setText(String.format(updatesActivity.getPageContext().getString(R.string.del_count), Integer.valueOf(i2)));
        if (i2 == 0) {
            this.f58270i.setEnabled(false);
        } else {
            this.f58270i.setEnabled(true);
        }
    }

    public void r(boolean z) {
        this.f58267f.setVisibility(z ? 0 : 8);
    }
}

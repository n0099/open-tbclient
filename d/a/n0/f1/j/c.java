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
    public View f54573a;

    /* renamed from: b  reason: collision with root package name */
    public View f54574b;

    /* renamed from: c  reason: collision with root package name */
    public UpdatesActivity f54575c;

    /* renamed from: d  reason: collision with root package name */
    public BdListView f54576d;

    /* renamed from: e  reason: collision with root package name */
    public a f54577e;

    /* renamed from: f  reason: collision with root package name */
    public ProgressBar f54578f;

    /* renamed from: g  reason: collision with root package name */
    public Button f54579g;

    /* renamed from: h  reason: collision with root package name */
    public Button f54580h;

    /* renamed from: i  reason: collision with root package name */
    public Button f54581i;
    public NavigationBar j;
    public View k;
    public View l;

    public c(UpdatesActivity updatesActivity) {
        super(updatesActivity.getPageContext());
        this.f54575c = updatesActivity;
        m();
        a aVar = new a(this.f54575c);
        this.f54577e = aVar;
        this.f54576d.setAdapter((ListAdapter) aVar);
        this.f54576d.setOnScrollListener(this.f54575c);
    }

    public void d() {
        this.f54579g.setVisibility(0);
        this.f54574b.setVisibility(0);
        this.f54580h.setVisibility(8);
        this.k.setVisibility(8);
        p(0);
        n();
    }

    @Override // d.a.c.a.d
    public void destroy() {
        super.destroy();
        a aVar = this.f54577e;
        if (aVar != null) {
            aVar.a();
            this.f54577e = null;
        }
        this.f54575c = null;
    }

    public void e() {
        this.f54579g.setVisibility(8);
        this.f54574b.setVisibility(8);
        this.f54580h.setVisibility(0);
        this.k.setVisibility(0);
        n();
    }

    public View f() {
        return this.f54574b;
    }

    public Button g() {
        return this.f54580h;
    }

    public Button h() {
        return this.f54581i;
    }

    public Button j() {
        return this.f54579g;
    }

    public a k() {
        return this.f54577e;
    }

    public BdListView l() {
        return this.f54576d;
    }

    public void m() {
        View inflate = View.inflate(this.f54575c.getPageContext().getPageActivity(), R.layout.updates_activity, null);
        this.f54573a = inflate;
        this.f54575c.setContentView(inflate);
        NavigationBar navigationBar = (NavigationBar) this.f54575c.findViewById(R.id.view_navigation_bar);
        this.j = navigationBar;
        this.f54574b = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.j.setTitleText(this.f54575c.getPageContext().getString(R.string.updates_activity_title));
        this.k = this.j.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.updates_activity_nav_left, (View.OnClickListener) null);
        this.l = this.j.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.updates_activity_nav_right, (View.OnClickListener) null);
        Button button = (Button) this.k.findViewById(R.id.btn_delete);
        this.f54581i = button;
        button.setOnClickListener(this.f54575c);
        this.f54574b.setOnClickListener(this.f54575c);
        this.f54576d = (BdListView) this.f54573a.findViewById(R.id.updates_list);
        this.f54578f = (ProgressBar) this.f54573a.findViewById(R.id.pro_load);
        Button button2 = (Button) this.l.findViewById(R.id.btn_edit);
        this.f54579g = button2;
        button2.setOnClickListener(this.f54575c);
        Button button3 = (Button) this.l.findViewById(R.id.btn_cancel);
        this.f54580h = button3;
        button3.setOnClickListener(this.f54575c);
        p(0);
        q(false);
    }

    public void n() {
        a aVar = this.f54577e;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    public void o(List<UpdatesItemData> list) {
        a aVar = this.f54577e;
        if (aVar != null) {
            aVar.c(list);
        }
    }

    public void onChangeSkinType(int i2) {
        this.f54575c.getLayoutMode().k(i2 == 1);
        this.f54575c.getLayoutMode().j(this.f54573a);
        this.j.onChangeSkinType(this.f54575c.getPageContext(), i2);
        SkinManager.setBackgroundResource(this.f54581i, R.drawable.btn_delete_groupupdates);
    }

    public void p(int i2) {
        UpdatesActivity updatesActivity;
        Button button = this.f54581i;
        if (button == null || (updatesActivity = this.f54575c) == null) {
            return;
        }
        button.setText(String.format(updatesActivity.getPageContext().getString(R.string.del_count), Integer.valueOf(i2)));
        if (i2 == 0) {
            this.f54581i.setEnabled(false);
        } else {
            this.f54581i.setEnabled(true);
        }
    }

    public void q(boolean z) {
        this.f54578f.setVisibility(z ? 0 : 8);
    }
}

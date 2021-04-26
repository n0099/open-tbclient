package d.a.j0.e1.x;

import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.ValidateItemData;
import com.baidu.tieba.im.validate.ValidateActivity;
import d.a.c.a.d;
import java.util.List;
/* loaded from: classes4.dex */
public class c extends d<ValidateActivity> {

    /* renamed from: a  reason: collision with root package name */
    public View f53898a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f53899b;

    /* renamed from: c  reason: collision with root package name */
    public ValidateActivity f53900c;

    /* renamed from: d  reason: collision with root package name */
    public BdListView f53901d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.j0.e1.x.a f53902e;

    /* renamed from: f  reason: collision with root package name */
    public ProgressBar f53903f;

    /* renamed from: g  reason: collision with root package name */
    public NavigationBar f53904g;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.f53900c.finish();
        }
    }

    public c(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext());
        this.f53900c = validateActivity;
        g();
        d.a.j0.e1.x.a aVar = new d.a.j0.e1.x.a(this.f53900c);
        this.f53902e = aVar;
        this.f53901d.setAdapter((ListAdapter) aVar);
        this.f53901d.setOnSrollToBottomListener(this.f53900c);
    }

    @Override // d.a.c.a.d
    public void destroy() {
        super.destroy();
        d.a.j0.e1.x.a aVar = this.f53902e;
        if (aVar != null) {
            aVar.a();
            this.f53902e = null;
        }
        this.f53900c = null;
    }

    public ImageView e() {
        return this.f53899b;
    }

    public d.a.j0.e1.x.a f() {
        return this.f53902e;
    }

    public void g() {
        View inflate = View.inflate(this.f53900c.getPageContext().getPageActivity(), R.layout.validate_activity, null);
        this.f53898a = inflate;
        this.f53900c.setContentView(inflate);
        NavigationBar navigationBar = (NavigationBar) this.f53900c.findViewById(R.id.view_navigation_bar);
        this.f53904g = navigationBar;
        navigationBar.setTitleText(this.f53900c.getPageContext().getString(R.string.validate));
        this.f53904g.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a());
        this.f53901d = (BdListView) this.f53898a.findViewById(R.id.validate_list);
        this.f53903f = (ProgressBar) this.f53898a.findViewById(R.id.pro_load);
        j(false);
    }

    public void h(List<ValidateItemData> list) {
        d.a.j0.e1.x.a aVar = this.f53902e;
        if (aVar != null) {
            aVar.c(list);
        }
    }

    public void j(boolean z) {
        this.f53903f.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i2) {
        this.f53900c.getLayoutMode().k(i2 == 1);
        this.f53900c.getLayoutMode().j(this.f53898a);
        this.f53904g.onChangeSkinType(this.f53900c.getPageContext(), i2);
        if (i2 != 1 && i2 != 4) {
            this.f53901d.setDivider(new ColorDrawable(this.f53900c.getResources().getColor(R.color.common_color_10241)));
            this.f53901d.setDividerHeight(this.f53900c.getResources().getDimensionPixelSize(R.dimen.ds2));
            return;
        }
        this.f53901d.setDivider(new ColorDrawable(this.f53900c.getResources().getColor(R.color.common_color_10179)));
        this.f53901d.setDividerHeight(this.f53900c.getResources().getDimensionPixelSize(R.dimen.ds2));
    }
}

package d.a.k0.e1.x;

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
    public View f54605a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f54606b;

    /* renamed from: c  reason: collision with root package name */
    public ValidateActivity f54607c;

    /* renamed from: d  reason: collision with root package name */
    public BdListView f54608d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.k0.e1.x.a f54609e;

    /* renamed from: f  reason: collision with root package name */
    public ProgressBar f54610f;

    /* renamed from: g  reason: collision with root package name */
    public NavigationBar f54611g;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.f54607c.finish();
        }
    }

    public c(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext());
        this.f54607c = validateActivity;
        g();
        d.a.k0.e1.x.a aVar = new d.a.k0.e1.x.a(this.f54607c);
        this.f54609e = aVar;
        this.f54608d.setAdapter((ListAdapter) aVar);
        this.f54608d.setOnSrollToBottomListener(this.f54607c);
    }

    @Override // d.a.c.a.d
    public void destroy() {
        super.destroy();
        d.a.k0.e1.x.a aVar = this.f54609e;
        if (aVar != null) {
            aVar.a();
            this.f54609e = null;
        }
        this.f54607c = null;
    }

    public ImageView e() {
        return this.f54606b;
    }

    public d.a.k0.e1.x.a f() {
        return this.f54609e;
    }

    public void g() {
        View inflate = View.inflate(this.f54607c.getPageContext().getPageActivity(), R.layout.validate_activity, null);
        this.f54605a = inflate;
        this.f54607c.setContentView(inflate);
        NavigationBar navigationBar = (NavigationBar) this.f54607c.findViewById(R.id.view_navigation_bar);
        this.f54611g = navigationBar;
        navigationBar.setTitleText(this.f54607c.getPageContext().getString(R.string.validate));
        this.f54611g.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a());
        this.f54608d = (BdListView) this.f54605a.findViewById(R.id.validate_list);
        this.f54610f = (ProgressBar) this.f54605a.findViewById(R.id.pro_load);
        j(false);
    }

    public void h(List<ValidateItemData> list) {
        d.a.k0.e1.x.a aVar = this.f54609e;
        if (aVar != null) {
            aVar.c(list);
        }
    }

    public void j(boolean z) {
        this.f54610f.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i2) {
        this.f54607c.getLayoutMode().k(i2 == 1);
        this.f54607c.getLayoutMode().j(this.f54605a);
        this.f54611g.onChangeSkinType(this.f54607c.getPageContext(), i2);
        if (i2 != 1 && i2 != 4) {
            this.f54608d.setDivider(new ColorDrawable(this.f54607c.getResources().getColor(R.color.common_color_10241)));
            this.f54608d.setDividerHeight(this.f54607c.getResources().getDimensionPixelSize(R.dimen.ds2));
            return;
        }
        this.f54608d.setDivider(new ColorDrawable(this.f54607c.getResources().getColor(R.color.common_color_10179)));
        this.f54608d.setDividerHeight(this.f54607c.getResources().getDimensionPixelSize(R.dimen.ds2));
    }
}

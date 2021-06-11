package d.a.n0.f1.x;

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
    public View f58484a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f58485b;

    /* renamed from: c  reason: collision with root package name */
    public ValidateActivity f58486c;

    /* renamed from: d  reason: collision with root package name */
    public BdListView f58487d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.n0.f1.x.a f58488e;

    /* renamed from: f  reason: collision with root package name */
    public ProgressBar f58489f;

    /* renamed from: g  reason: collision with root package name */
    public NavigationBar f58490g;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.f58486c.finish();
        }
    }

    public c(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext());
        this.f58486c = validateActivity;
        h();
        d.a.n0.f1.x.a aVar = new d.a.n0.f1.x.a(this.f58486c);
        this.f58488e = aVar;
        this.f58487d.setAdapter((ListAdapter) aVar);
        this.f58487d.setOnSrollToBottomListener(this.f58486c);
    }

    @Override // d.a.c.a.d
    public void destroy() {
        super.destroy();
        d.a.n0.f1.x.a aVar = this.f58488e;
        if (aVar != null) {
            aVar.a();
            this.f58488e = null;
        }
        this.f58486c = null;
    }

    public ImageView e() {
        return this.f58485b;
    }

    public d.a.n0.f1.x.a f() {
        return this.f58488e;
    }

    public void h() {
        View inflate = View.inflate(this.f58486c.getPageContext().getPageActivity(), R.layout.validate_activity, null);
        this.f58484a = inflate;
        this.f58486c.setContentView(inflate);
        NavigationBar navigationBar = (NavigationBar) this.f58486c.findViewById(R.id.view_navigation_bar);
        this.f58490g = navigationBar;
        navigationBar.setTitleText(this.f58486c.getPageContext().getString(R.string.validate));
        this.f58490g.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a());
        this.f58487d = (BdListView) this.f58484a.findViewById(R.id.validate_list);
        this.f58489f = (ProgressBar) this.f58484a.findViewById(R.id.pro_load);
        k(false);
    }

    public void i(List<ValidateItemData> list) {
        d.a.n0.f1.x.a aVar = this.f58488e;
        if (aVar != null) {
            aVar.c(list);
        }
    }

    public void k(boolean z) {
        this.f58489f.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i2) {
        this.f58486c.getLayoutMode().k(i2 == 1);
        this.f58486c.getLayoutMode().j(this.f58484a);
        this.f58490g.onChangeSkinType(this.f58486c.getPageContext(), i2);
        if (i2 != 1 && i2 != 4) {
            this.f58487d.setDivider(new ColorDrawable(this.f58486c.getResources().getColor(R.color.common_color_10241)));
            this.f58487d.setDividerHeight(this.f58486c.getResources().getDimensionPixelSize(R.dimen.ds2));
            return;
        }
        this.f58487d.setDivider(new ColorDrawable(this.f58486c.getResources().getColor(R.color.common_color_10179)));
        this.f58487d.setDividerHeight(this.f58486c.getResources().getDimensionPixelSize(R.dimen.ds2));
    }
}

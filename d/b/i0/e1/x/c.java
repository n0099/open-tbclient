package d.b.i0.e1.x;

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
import d.b.c.a.d;
import java.util.List;
/* loaded from: classes4.dex */
public class c extends d<ValidateActivity> {

    /* renamed from: a  reason: collision with root package name */
    public View f55608a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f55609b;

    /* renamed from: c  reason: collision with root package name */
    public ValidateActivity f55610c;

    /* renamed from: d  reason: collision with root package name */
    public BdListView f55611d;

    /* renamed from: e  reason: collision with root package name */
    public d.b.i0.e1.x.a f55612e;

    /* renamed from: f  reason: collision with root package name */
    public ProgressBar f55613f;

    /* renamed from: g  reason: collision with root package name */
    public NavigationBar f55614g;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.f55610c.finish();
        }
    }

    public c(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext());
        this.f55610c = validateActivity;
        h();
        d.b.i0.e1.x.a aVar = new d.b.i0.e1.x.a(this.f55610c);
        this.f55612e = aVar;
        this.f55611d.setAdapter((ListAdapter) aVar);
        this.f55611d.setOnSrollToBottomListener(this.f55610c);
    }

    @Override // d.b.c.a.d
    public void destroy() {
        super.destroy();
        d.b.i0.e1.x.a aVar = this.f55612e;
        if (aVar != null) {
            aVar.a();
            this.f55612e = null;
        }
        this.f55610c = null;
    }

    public ImageView e() {
        return this.f55609b;
    }

    public d.b.i0.e1.x.a f() {
        return this.f55612e;
    }

    public void h() {
        View inflate = View.inflate(this.f55610c.getPageContext().getPageActivity(), R.layout.validate_activity, null);
        this.f55608a = inflate;
        this.f55610c.setContentView(inflate);
        NavigationBar navigationBar = (NavigationBar) this.f55610c.findViewById(R.id.view_navigation_bar);
        this.f55614g = navigationBar;
        navigationBar.setTitleText(this.f55610c.getPageContext().getString(R.string.validate));
        this.f55614g.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a());
        this.f55611d = (BdListView) this.f55608a.findViewById(R.id.validate_list);
        this.f55613f = (ProgressBar) this.f55608a.findViewById(R.id.pro_load);
        k(false);
    }

    public void i(List<ValidateItemData> list) {
        d.b.i0.e1.x.a aVar = this.f55612e;
        if (aVar != null) {
            aVar.c(list);
        }
    }

    public void k(boolean z) {
        this.f55613f.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        this.f55610c.getLayoutMode().k(i == 1);
        this.f55610c.getLayoutMode().j(this.f55608a);
        this.f55614g.onChangeSkinType(this.f55610c.getPageContext(), i);
        if (i != 1 && i != 4) {
            this.f55611d.setDivider(new ColorDrawable(this.f55610c.getResources().getColor(R.color.common_color_10241)));
            this.f55611d.setDividerHeight(this.f55610c.getResources().getDimensionPixelSize(R.dimen.ds2));
            return;
        }
        this.f55611d.setDivider(new ColorDrawable(this.f55610c.getResources().getColor(R.color.common_color_10179)));
        this.f55611d.setDividerHeight(this.f55610c.getResources().getDimensionPixelSize(R.dimen.ds2));
    }
}

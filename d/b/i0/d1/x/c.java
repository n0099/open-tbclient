package d.b.i0.d1.x;

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
import d.b.b.a.d;
import java.util.List;
/* loaded from: classes4.dex */
public class c extends d<ValidateActivity> {

    /* renamed from: a  reason: collision with root package name */
    public View f54085a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f54086b;

    /* renamed from: c  reason: collision with root package name */
    public ValidateActivity f54087c;

    /* renamed from: d  reason: collision with root package name */
    public BdListView f54088d;

    /* renamed from: e  reason: collision with root package name */
    public d.b.i0.d1.x.a f54089e;

    /* renamed from: f  reason: collision with root package name */
    public ProgressBar f54090f;

    /* renamed from: g  reason: collision with root package name */
    public NavigationBar f54091g;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.f54087c.finish();
        }
    }

    public c(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext());
        this.f54087c = validateActivity;
        h();
        d.b.i0.d1.x.a aVar = new d.b.i0.d1.x.a(this.f54087c);
        this.f54089e = aVar;
        this.f54088d.setAdapter((ListAdapter) aVar);
        this.f54088d.setOnSrollToBottomListener(this.f54087c);
    }

    @Override // d.b.b.a.d
    public void destroy() {
        super.destroy();
        d.b.i0.d1.x.a aVar = this.f54089e;
        if (aVar != null) {
            aVar.a();
            this.f54089e = null;
        }
        this.f54087c = null;
    }

    public ImageView e() {
        return this.f54086b;
    }

    public d.b.i0.d1.x.a f() {
        return this.f54089e;
    }

    public void h() {
        View inflate = View.inflate(this.f54087c.getPageContext().getPageActivity(), R.layout.validate_activity, null);
        this.f54085a = inflate;
        this.f54087c.setContentView(inflate);
        NavigationBar navigationBar = (NavigationBar) this.f54087c.findViewById(R.id.view_navigation_bar);
        this.f54091g = navigationBar;
        navigationBar.setTitleText(this.f54087c.getPageContext().getString(R.string.validate));
        this.f54091g.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a());
        this.f54088d = (BdListView) this.f54085a.findViewById(R.id.validate_list);
        this.f54090f = (ProgressBar) this.f54085a.findViewById(R.id.pro_load);
        k(false);
    }

    public void i(List<ValidateItemData> list) {
        d.b.i0.d1.x.a aVar = this.f54089e;
        if (aVar != null) {
            aVar.c(list);
        }
    }

    public void k(boolean z) {
        this.f54090f.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        this.f54087c.getLayoutMode().k(i == 1);
        this.f54087c.getLayoutMode().j(this.f54085a);
        this.f54091g.onChangeSkinType(this.f54087c.getPageContext(), i);
        if (i != 1 && i != 4) {
            this.f54088d.setDivider(new ColorDrawable(this.f54087c.getResources().getColor(R.color.common_color_10241)));
            this.f54088d.setDividerHeight(this.f54087c.getResources().getDimensionPixelSize(R.dimen.ds2));
            return;
        }
        this.f54088d.setDivider(new ColorDrawable(this.f54087c.getResources().getColor(R.color.common_color_10179)));
        this.f54088d.setDividerHeight(this.f54087c.getResources().getDimensionPixelSize(R.dimen.ds2));
    }
}

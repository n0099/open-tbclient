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
/* loaded from: classes3.dex */
public class c extends d<ValidateActivity> {

    /* renamed from: a  reason: collision with root package name */
    public View f54086a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f54087b;

    /* renamed from: c  reason: collision with root package name */
    public ValidateActivity f54088c;

    /* renamed from: d  reason: collision with root package name */
    public BdListView f54089d;

    /* renamed from: e  reason: collision with root package name */
    public d.b.i0.d1.x.a f54090e;

    /* renamed from: f  reason: collision with root package name */
    public ProgressBar f54091f;

    /* renamed from: g  reason: collision with root package name */
    public NavigationBar f54092g;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.f54088c.finish();
        }
    }

    public c(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext());
        this.f54088c = validateActivity;
        h();
        d.b.i0.d1.x.a aVar = new d.b.i0.d1.x.a(this.f54088c);
        this.f54090e = aVar;
        this.f54089d.setAdapter((ListAdapter) aVar);
        this.f54089d.setOnSrollToBottomListener(this.f54088c);
    }

    @Override // d.b.b.a.d
    public void destroy() {
        super.destroy();
        d.b.i0.d1.x.a aVar = this.f54090e;
        if (aVar != null) {
            aVar.a();
            this.f54090e = null;
        }
        this.f54088c = null;
    }

    public ImageView e() {
        return this.f54087b;
    }

    public d.b.i0.d1.x.a f() {
        return this.f54090e;
    }

    public void h() {
        View inflate = View.inflate(this.f54088c.getPageContext().getPageActivity(), R.layout.validate_activity, null);
        this.f54086a = inflate;
        this.f54088c.setContentView(inflate);
        NavigationBar navigationBar = (NavigationBar) this.f54088c.findViewById(R.id.view_navigation_bar);
        this.f54092g = navigationBar;
        navigationBar.setTitleText(this.f54088c.getPageContext().getString(R.string.validate));
        this.f54092g.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a());
        this.f54089d = (BdListView) this.f54086a.findViewById(R.id.validate_list);
        this.f54091f = (ProgressBar) this.f54086a.findViewById(R.id.pro_load);
        k(false);
    }

    public void i(List<ValidateItemData> list) {
        d.b.i0.d1.x.a aVar = this.f54090e;
        if (aVar != null) {
            aVar.c(list);
        }
    }

    public void k(boolean z) {
        this.f54091f.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        this.f54088c.getLayoutMode().k(i == 1);
        this.f54088c.getLayoutMode().j(this.f54086a);
        this.f54092g.onChangeSkinType(this.f54088c.getPageContext(), i);
        if (i != 1 && i != 4) {
            this.f54089d.setDivider(new ColorDrawable(this.f54088c.getResources().getColor(R.color.common_color_10241)));
            this.f54089d.setDividerHeight(this.f54088c.getResources().getDimensionPixelSize(R.dimen.ds2));
            return;
        }
        this.f54089d.setDivider(new ColorDrawable(this.f54088c.getResources().getColor(R.color.common_color_10179)));
        this.f54089d.setDividerHeight(this.f54088c.getResources().getDimensionPixelSize(R.dimen.ds2));
    }
}

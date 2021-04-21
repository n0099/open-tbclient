package d.b.j0.e1.x;

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
    public View f56029a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f56030b;

    /* renamed from: c  reason: collision with root package name */
    public ValidateActivity f56031c;

    /* renamed from: d  reason: collision with root package name */
    public BdListView f56032d;

    /* renamed from: e  reason: collision with root package name */
    public d.b.j0.e1.x.a f56033e;

    /* renamed from: f  reason: collision with root package name */
    public ProgressBar f56034f;

    /* renamed from: g  reason: collision with root package name */
    public NavigationBar f56035g;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.f56031c.finish();
        }
    }

    public c(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext());
        this.f56031c = validateActivity;
        h();
        d.b.j0.e1.x.a aVar = new d.b.j0.e1.x.a(this.f56031c);
        this.f56033e = aVar;
        this.f56032d.setAdapter((ListAdapter) aVar);
        this.f56032d.setOnSrollToBottomListener(this.f56031c);
    }

    @Override // d.b.c.a.d
    public void destroy() {
        super.destroy();
        d.b.j0.e1.x.a aVar = this.f56033e;
        if (aVar != null) {
            aVar.a();
            this.f56033e = null;
        }
        this.f56031c = null;
    }

    public ImageView e() {
        return this.f56030b;
    }

    public d.b.j0.e1.x.a f() {
        return this.f56033e;
    }

    public void h() {
        View inflate = View.inflate(this.f56031c.getPageContext().getPageActivity(), R.layout.validate_activity, null);
        this.f56029a = inflate;
        this.f56031c.setContentView(inflate);
        NavigationBar navigationBar = (NavigationBar) this.f56031c.findViewById(R.id.view_navigation_bar);
        this.f56035g = navigationBar;
        navigationBar.setTitleText(this.f56031c.getPageContext().getString(R.string.validate));
        this.f56035g.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a());
        this.f56032d = (BdListView) this.f56029a.findViewById(R.id.validate_list);
        this.f56034f = (ProgressBar) this.f56029a.findViewById(R.id.pro_load);
        k(false);
    }

    public void i(List<ValidateItemData> list) {
        d.b.j0.e1.x.a aVar = this.f56033e;
        if (aVar != null) {
            aVar.c(list);
        }
    }

    public void k(boolean z) {
        this.f56034f.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        this.f56031c.getLayoutMode().k(i == 1);
        this.f56031c.getLayoutMode().j(this.f56029a);
        this.f56035g.onChangeSkinType(this.f56031c.getPageContext(), i);
        if (i != 1 && i != 4) {
            this.f56032d.setDivider(new ColorDrawable(this.f56031c.getResources().getColor(R.color.common_color_10241)));
            this.f56032d.setDividerHeight(this.f56031c.getResources().getDimensionPixelSize(R.dimen.ds2));
            return;
        }
        this.f56032d.setDivider(new ColorDrawable(this.f56031c.getResources().getColor(R.color.common_color_10179)));
        this.f56032d.setDividerHeight(this.f56031c.getResources().getDimensionPixelSize(R.dimen.ds2));
    }
}

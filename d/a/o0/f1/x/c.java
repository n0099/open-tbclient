package d.a.o0.f1.x;

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
    public View f58609a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f58610b;

    /* renamed from: c  reason: collision with root package name */
    public ValidateActivity f58611c;

    /* renamed from: d  reason: collision with root package name */
    public BdListView f58612d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.o0.f1.x.a f58613e;

    /* renamed from: f  reason: collision with root package name */
    public ProgressBar f58614f;

    /* renamed from: g  reason: collision with root package name */
    public NavigationBar f58615g;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.f58611c.finish();
        }
    }

    public c(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext());
        this.f58611c = validateActivity;
        h();
        d.a.o0.f1.x.a aVar = new d.a.o0.f1.x.a(this.f58611c);
        this.f58613e = aVar;
        this.f58612d.setAdapter((ListAdapter) aVar);
        this.f58612d.setOnSrollToBottomListener(this.f58611c);
    }

    @Override // d.a.c.a.d
    public void destroy() {
        super.destroy();
        d.a.o0.f1.x.a aVar = this.f58613e;
        if (aVar != null) {
            aVar.a();
            this.f58613e = null;
        }
        this.f58611c = null;
    }

    public ImageView e() {
        return this.f58610b;
    }

    public d.a.o0.f1.x.a f() {
        return this.f58613e;
    }

    public void h() {
        View inflate = View.inflate(this.f58611c.getPageContext().getPageActivity(), R.layout.validate_activity, null);
        this.f58609a = inflate;
        this.f58611c.setContentView(inflate);
        NavigationBar navigationBar = (NavigationBar) this.f58611c.findViewById(R.id.view_navigation_bar);
        this.f58615g = navigationBar;
        navigationBar.setTitleText(this.f58611c.getPageContext().getString(R.string.validate));
        this.f58615g.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a());
        this.f58612d = (BdListView) this.f58609a.findViewById(R.id.validate_list);
        this.f58614f = (ProgressBar) this.f58609a.findViewById(R.id.pro_load);
        k(false);
    }

    public void i(List<ValidateItemData> list) {
        d.a.o0.f1.x.a aVar = this.f58613e;
        if (aVar != null) {
            aVar.c(list);
        }
    }

    public void k(boolean z) {
        this.f58614f.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i2) {
        this.f58611c.getLayoutMode().k(i2 == 1);
        this.f58611c.getLayoutMode().j(this.f58609a);
        this.f58615g.onChangeSkinType(this.f58611c.getPageContext(), i2);
        if (i2 != 1 && i2 != 4) {
            this.f58612d.setDivider(new ColorDrawable(this.f58611c.getResources().getColor(R.color.common_color_10241)));
            this.f58612d.setDividerHeight(this.f58611c.getResources().getDimensionPixelSize(R.dimen.ds2));
            return;
        }
        this.f58612d.setDivider(new ColorDrawable(this.f58611c.getResources().getColor(R.color.common_color_10179)));
        this.f58612d.setDividerHeight(this.f58611c.getResources().getDimensionPixelSize(R.dimen.ds2));
    }
}

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
    public View f54795a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f54796b;

    /* renamed from: c  reason: collision with root package name */
    public ValidateActivity f54797c;

    /* renamed from: d  reason: collision with root package name */
    public BdListView f54798d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.n0.f1.x.a f54799e;

    /* renamed from: f  reason: collision with root package name */
    public ProgressBar f54800f;

    /* renamed from: g  reason: collision with root package name */
    public NavigationBar f54801g;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.f54797c.finish();
        }
    }

    public c(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext());
        this.f54797c = validateActivity;
        g();
        d.a.n0.f1.x.a aVar = new d.a.n0.f1.x.a(this.f54797c);
        this.f54799e = aVar;
        this.f54798d.setAdapter((ListAdapter) aVar);
        this.f54798d.setOnSrollToBottomListener(this.f54797c);
    }

    @Override // d.a.c.a.d
    public void destroy() {
        super.destroy();
        d.a.n0.f1.x.a aVar = this.f54799e;
        if (aVar != null) {
            aVar.a();
            this.f54799e = null;
        }
        this.f54797c = null;
    }

    public ImageView e() {
        return this.f54796b;
    }

    public d.a.n0.f1.x.a f() {
        return this.f54799e;
    }

    public void g() {
        View inflate = View.inflate(this.f54797c.getPageContext().getPageActivity(), R.layout.validate_activity, null);
        this.f54795a = inflate;
        this.f54797c.setContentView(inflate);
        NavigationBar navigationBar = (NavigationBar) this.f54797c.findViewById(R.id.view_navigation_bar);
        this.f54801g = navigationBar;
        navigationBar.setTitleText(this.f54797c.getPageContext().getString(R.string.validate));
        this.f54801g.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a());
        this.f54798d = (BdListView) this.f54795a.findViewById(R.id.validate_list);
        this.f54800f = (ProgressBar) this.f54795a.findViewById(R.id.pro_load);
        j(false);
    }

    public void h(List<ValidateItemData> list) {
        d.a.n0.f1.x.a aVar = this.f54799e;
        if (aVar != null) {
            aVar.c(list);
        }
    }

    public void j(boolean z) {
        this.f54800f.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i2) {
        this.f54797c.getLayoutMode().k(i2 == 1);
        this.f54797c.getLayoutMode().j(this.f54795a);
        this.f54801g.onChangeSkinType(this.f54797c.getPageContext(), i2);
        if (i2 != 1 && i2 != 4) {
            this.f54798d.setDivider(new ColorDrawable(this.f54797c.getResources().getColor(R.color.common_color_10241)));
            this.f54798d.setDividerHeight(this.f54797c.getResources().getDimensionPixelSize(R.dimen.ds2));
            return;
        }
        this.f54798d.setDivider(new ColorDrawable(this.f54797c.getResources().getColor(R.color.common_color_10179)));
        this.f54798d.setDividerHeight(this.f54797c.getResources().getDimensionPixelSize(R.dimen.ds2));
    }
}

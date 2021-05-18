package d.a.k0.j3.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.themeCenter.background.DressItemData;
/* loaded from: classes5.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f56846a;

    /* renamed from: b  reason: collision with root package name */
    public View f56847b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f56848c;

    /* renamed from: d  reason: collision with root package name */
    public TbImageView f56849d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f56850e;

    public h(TbPageContext<?> tbPageContext) {
        this.f56846a = tbPageContext;
        b();
    }

    public View a() {
        return this.f56847b;
    }

    public final void b() {
        View inflate = LayoutInflater.from(this.f56846a.getPageActivity()).inflate(R.layout.background_preview_bottom, (ViewGroup) null);
        this.f56847b = inflate;
        this.f56848c = (TextView) inflate.findViewById(R.id.text_bg_name);
        this.f56849d = (TbImageView) this.f56847b.findViewById(R.id.bg_permission_icon);
        this.f56850e = (TextView) this.f56847b.findViewById(R.id.text_bg_description);
        c();
    }

    public void c() {
        d.a.j0.s0.a.a(this.f56846a, this.f56847b);
    }

    public void d(DressItemData dressItemData) {
        if (dressItemData == null) {
            return;
        }
        this.f56848c.setText(dressItemData.getTitle());
        this.f56849d.V(dressItemData.getPermissionImgUrl(), 10, false);
        this.f56850e.setText(dressItemData.getDescription());
    }
}

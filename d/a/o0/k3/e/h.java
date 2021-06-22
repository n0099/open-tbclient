package d.a.o0.k3.e;

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
    public TbPageContext<?> f60840a;

    /* renamed from: b  reason: collision with root package name */
    public View f60841b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f60842c;

    /* renamed from: d  reason: collision with root package name */
    public TbImageView f60843d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f60844e;

    public h(TbPageContext<?> tbPageContext) {
        this.f60840a = tbPageContext;
        b();
    }

    public View a() {
        return this.f60841b;
    }

    public final void b() {
        View inflate = LayoutInflater.from(this.f60840a.getPageActivity()).inflate(R.layout.background_preview_bottom, (ViewGroup) null);
        this.f60841b = inflate;
        this.f60842c = (TextView) inflate.findViewById(R.id.text_bg_name);
        this.f60843d = (TbImageView) this.f60841b.findViewById(R.id.bg_permission_icon);
        this.f60844e = (TextView) this.f60841b.findViewById(R.id.text_bg_description);
        c();
    }

    public void c() {
        d.a.n0.s0.a.a(this.f60840a, this.f60841b);
    }

    public void d(DressItemData dressItemData) {
        if (dressItemData == null) {
            return;
        }
        this.f60842c.setText(dressItemData.getTitle());
        this.f60843d.U(dressItemData.getPermissionImgUrl(), 10, false);
        this.f60844e.setText(dressItemData.getDescription());
    }
}

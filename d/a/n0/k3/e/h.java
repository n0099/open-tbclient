package d.a.n0.k3.e;

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
    public TbPageContext<?> f57026a;

    /* renamed from: b  reason: collision with root package name */
    public View f57027b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f57028c;

    /* renamed from: d  reason: collision with root package name */
    public TbImageView f57029d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f57030e;

    public h(TbPageContext<?> tbPageContext) {
        this.f57026a = tbPageContext;
        b();
    }

    public View a() {
        return this.f57027b;
    }

    public final void b() {
        View inflate = LayoutInflater.from(this.f57026a.getPageActivity()).inflate(R.layout.background_preview_bottom, (ViewGroup) null);
        this.f57027b = inflate;
        this.f57028c = (TextView) inflate.findViewById(R.id.text_bg_name);
        this.f57029d = (TbImageView) this.f57027b.findViewById(R.id.bg_permission_icon);
        this.f57030e = (TextView) this.f57027b.findViewById(R.id.text_bg_description);
        c();
    }

    public void c() {
        d.a.m0.s0.a.a(this.f57026a, this.f57027b);
    }

    public void d(DressItemData dressItemData) {
        if (dressItemData == null) {
            return;
        }
        this.f57028c.setText(dressItemData.getTitle());
        this.f57029d.V(dressItemData.getPermissionImgUrl(), 10, false);
        this.f57030e.setText(dressItemData.getDescription());
    }
}

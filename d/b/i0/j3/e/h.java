package d.b.i0.j3.e;

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
    public TbPageContext<?> f57731a;

    /* renamed from: b  reason: collision with root package name */
    public View f57732b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f57733c;

    /* renamed from: d  reason: collision with root package name */
    public TbImageView f57734d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f57735e;

    public h(TbPageContext<?> tbPageContext) {
        this.f57731a = tbPageContext;
        b();
    }

    public View a() {
        return this.f57732b;
    }

    public final void b() {
        View inflate = LayoutInflater.from(this.f57731a.getPageActivity()).inflate(R.layout.background_preview_bottom, (ViewGroup) null);
        this.f57732b = inflate;
        this.f57733c = (TextView) inflate.findViewById(R.id.text_bg_name);
        this.f57734d = (TbImageView) this.f57732b.findViewById(R.id.bg_permission_icon);
        this.f57735e = (TextView) this.f57732b.findViewById(R.id.text_bg_description);
        c();
    }

    public void c() {
        d.b.h0.s0.a.a(this.f57731a, this.f57732b);
    }

    public void d(DressItemData dressItemData) {
        if (dressItemData == null) {
            return;
        }
        this.f57733c.setText(dressItemData.getTitle());
        this.f57734d.W(dressItemData.getPermissionImgUrl(), 10, false);
        this.f57735e.setText(dressItemData.getDescription());
    }
}

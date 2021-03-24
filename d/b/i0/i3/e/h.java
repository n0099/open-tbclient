package d.b.i0.i3.e;

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
    public TbPageContext<?> f56283a;

    /* renamed from: b  reason: collision with root package name */
    public View f56284b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f56285c;

    /* renamed from: d  reason: collision with root package name */
    public TbImageView f56286d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f56287e;

    public h(TbPageContext<?> tbPageContext) {
        this.f56283a = tbPageContext;
        b();
    }

    public View a() {
        return this.f56284b;
    }

    public final void b() {
        View inflate = LayoutInflater.from(this.f56283a.getPageActivity()).inflate(R.layout.background_preview_bottom, (ViewGroup) null);
        this.f56284b = inflate;
        this.f56285c = (TextView) inflate.findViewById(R.id.text_bg_name);
        this.f56286d = (TbImageView) this.f56284b.findViewById(R.id.bg_permission_icon);
        this.f56287e = (TextView) this.f56284b.findViewById(R.id.text_bg_description);
        c();
    }

    public void c() {
        d.b.h0.s0.a.a(this.f56283a, this.f56284b);
    }

    public void d(DressItemData dressItemData) {
        if (dressItemData == null) {
            return;
        }
        this.f56285c.setText(dressItemData.getTitle());
        this.f56286d.W(dressItemData.getPermissionImgUrl(), 10, false);
        this.f56287e.setText(dressItemData.getDescription());
    }
}

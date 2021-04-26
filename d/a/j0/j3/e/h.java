package d.a.j0.j3.e;

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
    public TbPageContext<?> f56139a;

    /* renamed from: b  reason: collision with root package name */
    public View f56140b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f56141c;

    /* renamed from: d  reason: collision with root package name */
    public TbImageView f56142d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f56143e;

    public h(TbPageContext<?> tbPageContext) {
        this.f56139a = tbPageContext;
        b();
    }

    public View a() {
        return this.f56140b;
    }

    public final void b() {
        View inflate = LayoutInflater.from(this.f56139a.getPageActivity()).inflate(R.layout.background_preview_bottom, (ViewGroup) null);
        this.f56140b = inflate;
        this.f56141c = (TextView) inflate.findViewById(R.id.text_bg_name);
        this.f56142d = (TbImageView) this.f56140b.findViewById(R.id.bg_permission_icon);
        this.f56143e = (TextView) this.f56140b.findViewById(R.id.text_bg_description);
        c();
    }

    public void c() {
        d.a.i0.s0.a.a(this.f56139a, this.f56140b);
    }

    public void d(DressItemData dressItemData) {
        if (dressItemData == null) {
            return;
        }
        this.f56141c.setText(dressItemData.getTitle());
        this.f56142d.V(dressItemData.getPermissionImgUrl(), 10, false);
        this.f56143e.setText(dressItemData.getDescription());
    }
}

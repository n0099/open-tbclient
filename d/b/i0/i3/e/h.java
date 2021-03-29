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
    public TbPageContext<?> f56284a;

    /* renamed from: b  reason: collision with root package name */
    public View f56285b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f56286c;

    /* renamed from: d  reason: collision with root package name */
    public TbImageView f56287d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f56288e;

    public h(TbPageContext<?> tbPageContext) {
        this.f56284a = tbPageContext;
        b();
    }

    public View a() {
        return this.f56285b;
    }

    public final void b() {
        View inflate = LayoutInflater.from(this.f56284a.getPageActivity()).inflate(R.layout.background_preview_bottom, (ViewGroup) null);
        this.f56285b = inflate;
        this.f56286c = (TextView) inflate.findViewById(R.id.text_bg_name);
        this.f56287d = (TbImageView) this.f56285b.findViewById(R.id.bg_permission_icon);
        this.f56288e = (TextView) this.f56285b.findViewById(R.id.text_bg_description);
        c();
    }

    public void c() {
        d.b.h0.s0.a.a(this.f56284a, this.f56285b);
    }

    public void d(DressItemData dressItemData) {
        if (dressItemData == null) {
            return;
        }
        this.f56286c.setText(dressItemData.getTitle());
        this.f56287d.W(dressItemData.getPermissionImgUrl(), 10, false);
        this.f56288e.setText(dressItemData.getDescription());
    }
}

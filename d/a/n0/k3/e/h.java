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
    public TbPageContext<?> f60715a;

    /* renamed from: b  reason: collision with root package name */
    public View f60716b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f60717c;

    /* renamed from: d  reason: collision with root package name */
    public TbImageView f60718d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f60719e;

    public h(TbPageContext<?> tbPageContext) {
        this.f60715a = tbPageContext;
        b();
    }

    public View a() {
        return this.f60716b;
    }

    public final void b() {
        View inflate = LayoutInflater.from(this.f60715a.getPageActivity()).inflate(R.layout.background_preview_bottom, (ViewGroup) null);
        this.f60716b = inflate;
        this.f60717c = (TextView) inflate.findViewById(R.id.text_bg_name);
        this.f60718d = (TbImageView) this.f60716b.findViewById(R.id.bg_permission_icon);
        this.f60719e = (TextView) this.f60716b.findViewById(R.id.text_bg_description);
        c();
    }

    public void c() {
        d.a.m0.s0.a.a(this.f60715a, this.f60716b);
    }

    public void d(DressItemData dressItemData) {
        if (dressItemData == null) {
            return;
        }
        this.f60717c.setText(dressItemData.getTitle());
        this.f60718d.U(dressItemData.getPermissionImgUrl(), 10, false);
        this.f60719e.setText(dressItemData.getDescription());
    }
}

package d.b.j0.j3.e;

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
    public TbPageContext<?> f58152a;

    /* renamed from: b  reason: collision with root package name */
    public View f58153b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f58154c;

    /* renamed from: d  reason: collision with root package name */
    public TbImageView f58155d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f58156e;

    public h(TbPageContext<?> tbPageContext) {
        this.f58152a = tbPageContext;
        b();
    }

    public View a() {
        return this.f58153b;
    }

    public final void b() {
        View inflate = LayoutInflater.from(this.f58152a.getPageActivity()).inflate(R.layout.background_preview_bottom, (ViewGroup) null);
        this.f58153b = inflate;
        this.f58154c = (TextView) inflate.findViewById(R.id.text_bg_name);
        this.f58155d = (TbImageView) this.f58153b.findViewById(R.id.bg_permission_icon);
        this.f58156e = (TextView) this.f58153b.findViewById(R.id.text_bg_description);
        c();
    }

    public void c() {
        d.b.i0.s0.a.a(this.f58152a, this.f58153b);
    }

    public void d(DressItemData dressItemData) {
        if (dressItemData == null) {
            return;
        }
        this.f58154c.setText(dressItemData.getTitle());
        this.f58155d.W(dressItemData.getPermissionImgUrl(), 10, false);
        this.f58156e.setText(dressItemData.getDescription());
    }
}

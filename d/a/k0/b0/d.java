package d.a.k0.b0;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.MessageRedDotView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public Context f52110a;

    /* renamed from: b  reason: collision with root package name */
    public View f52111b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f52112c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f52113d;

    /* renamed from: e  reason: collision with root package name */
    public MessageRedDotView f52114e;

    public d(Context context) {
        this.f52110a = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.widget_message_entrance, (ViewGroup) null);
        this.f52111b = inflate;
        this.f52112c = (RelativeLayout) inflate.findViewById(R.id.message_view_layout);
        this.f52113d = (ImageView) this.f52111b.findViewById(R.id.img_message);
        MessageRedDotView messageRedDotView = (MessageRedDotView) this.f52111b.findViewById(R.id.img_red_tip);
        this.f52114e = messageRedDotView;
        messageRedDotView.setShadowEnabled(false);
    }

    public MessageRedDotView a() {
        return this.f52114e;
    }

    public ImageView b() {
        return this.f52113d;
    }

    public View c() {
        return this.f52111b;
    }

    public void d(int i2) {
        this.f52114e.e();
        this.f52113d.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_topbar_information40, SkinManager.getColor(R.color.CAM_X0106), WebPManager.ResourceStateType.NORMAL_PRESS));
    }

    public void e(boolean z, int i2) {
        if (z) {
            this.f52114e.f(i2);
            this.f52114e.setVisibility(0);
            return;
        }
        this.f52114e.setVisibility(8);
    }

    public void f(NavigationBar.ControlAlign controlAlign, boolean z) {
        if (z || controlAlign != NavigationBar.ControlAlign.HORIZONTAL_RIGHT) {
            return;
        }
        ((RelativeLayout.LayoutParams) this.f52113d.getLayoutParams()).rightMargin = -l.g(this.f52110a, R.dimen.tbds10);
        ((RelativeLayout.LayoutParams) this.f52114e.getLayoutParams()).rightMargin = -l.g(this.f52110a, R.dimen.tbds10);
        this.f52112c.getLayoutParams().width = l.g(this.f52110a, R.dimen.ds88);
    }

    public void g(int i2) {
        View view = this.f52111b;
        if (view != null) {
            view.setVisibility(i2);
        }
    }
}

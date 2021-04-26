package d.a.j0.b0;

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
    public Context f51411a;

    /* renamed from: b  reason: collision with root package name */
    public View f51412b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f51413c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f51414d;

    /* renamed from: e  reason: collision with root package name */
    public MessageRedDotView f51415e;

    public d(Context context) {
        this.f51411a = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.widget_message_entrance, (ViewGroup) null);
        this.f51412b = inflate;
        this.f51413c = (RelativeLayout) inflate.findViewById(R.id.message_view_layout);
        this.f51414d = (ImageView) this.f51412b.findViewById(R.id.img_message);
        MessageRedDotView messageRedDotView = (MessageRedDotView) this.f51412b.findViewById(R.id.img_red_tip);
        this.f51415e = messageRedDotView;
        messageRedDotView.setShadowEnabled(false);
    }

    public MessageRedDotView a() {
        return this.f51415e;
    }

    public ImageView b() {
        return this.f51414d;
    }

    public View c() {
        return this.f51412b;
    }

    public void d(int i2) {
        this.f51415e.e();
        this.f51414d.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_topbar_information40, SkinManager.getColor(R.color.CAM_X0106), WebPManager.ResourceStateType.NORMAL_PRESS));
    }

    public void e(boolean z, int i2) {
        if (z) {
            this.f51415e.f(i2);
            this.f51415e.setVisibility(0);
            return;
        }
        this.f51415e.setVisibility(8);
    }

    public void f(NavigationBar.ControlAlign controlAlign, boolean z) {
        if (z || controlAlign != NavigationBar.ControlAlign.HORIZONTAL_RIGHT) {
            return;
        }
        ((RelativeLayout.LayoutParams) this.f51414d.getLayoutParams()).rightMargin = -l.g(this.f51411a, R.dimen.tbds10);
        ((RelativeLayout.LayoutParams) this.f51415e.getLayoutParams()).rightMargin = -l.g(this.f51411a, R.dimen.tbds10);
        this.f51413c.getLayoutParams().width = l.g(this.f51411a, R.dimen.ds88);
    }

    public void g(int i2) {
        View view = this.f51412b;
        if (view != null) {
            view.setVisibility(i2);
        }
    }
}

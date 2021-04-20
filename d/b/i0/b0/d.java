package d.b.i0.b0;

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
import d.b.c.e.p.l;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public Context f53248a;

    /* renamed from: b  reason: collision with root package name */
    public View f53249b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f53250c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f53251d;

    /* renamed from: e  reason: collision with root package name */
    public MessageRedDotView f53252e;

    public d(Context context) {
        this.f53248a = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.widget_message_entrance, (ViewGroup) null);
        this.f53249b = inflate;
        this.f53250c = (RelativeLayout) inflate.findViewById(R.id.message_view_layout);
        this.f53251d = (ImageView) this.f53249b.findViewById(R.id.img_message);
        MessageRedDotView messageRedDotView = (MessageRedDotView) this.f53249b.findViewById(R.id.img_red_tip);
        this.f53252e = messageRedDotView;
        messageRedDotView.setShadowEnabled(false);
    }

    public MessageRedDotView a() {
        return this.f53252e;
    }

    public ImageView b() {
        return this.f53251d;
    }

    public View c() {
        return this.f53249b;
    }

    public void d(int i) {
        this.f53252e.e();
        this.f53251d.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_topbar_information40, SkinManager.getColor(R.color.CAM_X0106), WebPManager.ResourceStateType.NORMAL_PRESS));
    }

    public void e(boolean z, int i) {
        if (z) {
            this.f53252e.f(i);
            this.f53252e.setVisibility(0);
            return;
        }
        this.f53252e.setVisibility(8);
    }

    public void f(NavigationBar.ControlAlign controlAlign, boolean z) {
        if (z || controlAlign != NavigationBar.ControlAlign.HORIZONTAL_RIGHT) {
            return;
        }
        ((RelativeLayout.LayoutParams) this.f53251d.getLayoutParams()).rightMargin = -l.g(this.f53248a, R.dimen.tbds10);
        ((RelativeLayout.LayoutParams) this.f53252e.getLayoutParams()).rightMargin = -l.g(this.f53248a, R.dimen.tbds10);
        this.f53250c.getLayoutParams().width = l.g(this.f53248a, R.dimen.ds88);
    }

    public void g(int i) {
        View view = this.f53249b;
        if (view != null) {
            view.setVisibility(i);
        }
    }
}

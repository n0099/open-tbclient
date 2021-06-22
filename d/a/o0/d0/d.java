package d.a.o0.d0;

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
    public Context f56227a;

    /* renamed from: b  reason: collision with root package name */
    public View f56228b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f56229c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f56230d;

    /* renamed from: e  reason: collision with root package name */
    public MessageRedDotView f56231e;

    public d(Context context) {
        this.f56227a = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.widget_message_entrance, (ViewGroup) null);
        this.f56228b = inflate;
        this.f56229c = (RelativeLayout) inflate.findViewById(R.id.message_view_layout);
        this.f56230d = (ImageView) this.f56228b.findViewById(R.id.img_message);
        MessageRedDotView messageRedDotView = (MessageRedDotView) this.f56228b.findViewById(R.id.img_red_tip);
        this.f56231e = messageRedDotView;
        messageRedDotView.setShadowEnabled(false);
    }

    public MessageRedDotView a() {
        return this.f56231e;
    }

    public ImageView b() {
        return this.f56230d;
    }

    public View c() {
        return this.f56228b;
    }

    public void d(int i2) {
        this.f56231e.e();
        this.f56230d.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_topbar_information40, SkinManager.getColor(R.color.CAM_X0106), WebPManager.ResourceStateType.NORMAL_PRESS));
    }

    public void e(boolean z, int i2) {
        if (z) {
            this.f56231e.f(i2);
            this.f56231e.setVisibility(0);
            return;
        }
        this.f56231e.setVisibility(8);
    }

    public void f(NavigationBar.ControlAlign controlAlign, boolean z) {
        if (z || controlAlign != NavigationBar.ControlAlign.HORIZONTAL_RIGHT) {
            return;
        }
        ((RelativeLayout.LayoutParams) this.f56230d.getLayoutParams()).rightMargin = -l.g(this.f56227a, R.dimen.tbds10);
        ((RelativeLayout.LayoutParams) this.f56231e.getLayoutParams()).rightMargin = -l.g(this.f56227a, R.dimen.tbds10);
        this.f56229c.getLayoutParams().width = l.g(this.f56227a, R.dimen.ds88);
    }

    public void g(int i2) {
        View view = this.f56228b;
        if (view != null) {
            view.setVisibility(i2);
        }
    }
}

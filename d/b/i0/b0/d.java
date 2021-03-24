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
import d.b.b.e.p.l;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public Context f51961a;

    /* renamed from: b  reason: collision with root package name */
    public View f51962b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f51963c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f51964d;

    /* renamed from: e  reason: collision with root package name */
    public MessageRedDotView f51965e;

    public d(Context context) {
        this.f51961a = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.widget_message_entrance, (ViewGroup) null);
        this.f51962b = inflate;
        this.f51963c = (RelativeLayout) inflate.findViewById(R.id.message_view_layout);
        this.f51964d = (ImageView) this.f51962b.findViewById(R.id.img_message);
        MessageRedDotView messageRedDotView = (MessageRedDotView) this.f51962b.findViewById(R.id.img_red_tip);
        this.f51965e = messageRedDotView;
        messageRedDotView.setShadowEnabled(false);
    }

    public MessageRedDotView a() {
        return this.f51965e;
    }

    public ImageView b() {
        return this.f51964d;
    }

    public View c() {
        return this.f51962b;
    }

    public void d(int i) {
        this.f51965e.e();
        this.f51964d.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_topbar_information40, SkinManager.getColor(R.color.CAM_X0106), WebPManager.ResourceStateType.NORMAL_PRESS));
    }

    public void e(boolean z, int i) {
        if (z) {
            this.f51965e.f(i);
            this.f51965e.setVisibility(0);
            return;
        }
        this.f51965e.setVisibility(8);
    }

    public void f(NavigationBar.ControlAlign controlAlign, boolean z) {
        if (z || controlAlign != NavigationBar.ControlAlign.HORIZONTAL_RIGHT) {
            return;
        }
        ((RelativeLayout.LayoutParams) this.f51964d.getLayoutParams()).rightMargin = -l.g(this.f51961a, R.dimen.tbds10);
        ((RelativeLayout.LayoutParams) this.f51965e.getLayoutParams()).rightMargin = -l.g(this.f51961a, R.dimen.tbds10);
        this.f51963c.getLayoutParams().width = l.g(this.f51961a, R.dimen.ds88);
    }

    public void g(int i) {
        View view = this.f51962b;
        if (view != null) {
            view.setVisibility(i);
        }
    }
}

package d.b.i0.n.c;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.R;
import tbclient.SimpleUser;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public final View.OnClickListener f56972a;

    /* renamed from: b  reason: collision with root package name */
    public BaseActivity f56973b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f56974c;

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f56975d;

    /* renamed from: e  reason: collision with root package name */
    public TbSettingTextTipView f56976e;

    /* renamed from: f  reason: collision with root package name */
    public TbSettingTextTipView f56977f;

    public b(BaseActivity baseActivity, View.OnClickListener onClickListener) {
        this.f56973b = baseActivity;
        this.f56972a = onClickListener;
        b();
    }

    public View a() {
        return this.f56974c;
    }

    public final void b() {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.f56973b).inflate(R.layout.account_safe_activity, (ViewGroup) null);
        this.f56974c = linearLayout;
        this.f56975d = (LinearLayout) linearLayout.findViewById(R.id.content_container);
        this.f56976e = (TbSettingTextTipView) this.f56974c.findViewById(R.id.bar_record);
        this.f56977f = (TbSettingTextTipView) this.f56974c.findViewById(R.id.account_status);
        this.f56976e.a();
        this.f56977f.a();
        this.f56976e.setOnClickListener(this.f56972a);
        this.f56977f.setOnClickListener(this.f56972a);
    }

    public void c() {
        this.f56974c.removeAllViews();
        this.f56973b = null;
    }

    public void d(SimpleUser simpleUser) {
        if (simpleUser == null) {
            return;
        }
        this.f56977f.setTip(simpleUser.block_msg);
    }

    public void e(int i) {
        this.f56973b.getLayoutMode().k(i == 1);
        this.f56973b.getLayoutMode().j(this.f56974c);
    }
}

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
    public final View.OnClickListener f58438a;

    /* renamed from: b  reason: collision with root package name */
    public BaseActivity f58439b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f58440c;

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f58441d;

    /* renamed from: e  reason: collision with root package name */
    public TbSettingTextTipView f58442e;

    /* renamed from: f  reason: collision with root package name */
    public TbSettingTextTipView f58443f;

    public b(BaseActivity baseActivity, View.OnClickListener onClickListener) {
        this.f58439b = baseActivity;
        this.f58438a = onClickListener;
        b();
    }

    public View a() {
        return this.f58440c;
    }

    public final void b() {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.f58439b).inflate(R.layout.account_safe_activity, (ViewGroup) null);
        this.f58440c = linearLayout;
        this.f58441d = (LinearLayout) linearLayout.findViewById(R.id.content_container);
        this.f58442e = (TbSettingTextTipView) this.f58440c.findViewById(R.id.bar_record);
        this.f58443f = (TbSettingTextTipView) this.f58440c.findViewById(R.id.account_status);
        this.f58442e.a();
        this.f58443f.a();
        this.f58442e.setOnClickListener(this.f58438a);
        this.f58443f.setOnClickListener(this.f58438a);
    }

    public void c() {
        this.f58440c.removeAllViews();
        this.f58439b = null;
    }

    public void d(SimpleUser simpleUser) {
        if (simpleUser == null) {
            return;
        }
        this.f58443f.setTip(simpleUser.block_msg);
    }

    public void e(int i) {
        this.f58439b.getLayoutMode().k(i == 1);
        this.f58439b.getLayoutMode().j(this.f58440c);
    }
}

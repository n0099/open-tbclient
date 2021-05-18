package d.a.k0.n.c;

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
    public final View.OnClickListener f57581a;

    /* renamed from: b  reason: collision with root package name */
    public BaseActivity f57582b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f57583c;

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f57584d;

    /* renamed from: e  reason: collision with root package name */
    public TbSettingTextTipView f57585e;

    /* renamed from: f  reason: collision with root package name */
    public TbSettingTextTipView f57586f;

    public b(BaseActivity baseActivity, View.OnClickListener onClickListener) {
        this.f57582b = baseActivity;
        this.f57581a = onClickListener;
        b();
    }

    public View a() {
        return this.f57583c;
    }

    public final void b() {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.f57582b).inflate(R.layout.account_safe_activity, (ViewGroup) null);
        this.f57583c = linearLayout;
        this.f57584d = (LinearLayout) linearLayout.findViewById(R.id.content_container);
        this.f57585e = (TbSettingTextTipView) this.f57583c.findViewById(R.id.bar_record);
        this.f57586f = (TbSettingTextTipView) this.f57583c.findViewById(R.id.account_status);
        this.f57585e.a();
        this.f57586f.a();
        this.f57585e.setOnClickListener(this.f57581a);
        this.f57586f.setOnClickListener(this.f57581a);
    }

    public void c() {
        this.f57583c.removeAllViews();
        this.f57582b = null;
    }

    public void d(SimpleUser simpleUser) {
        if (simpleUser == null) {
            return;
        }
        this.f57586f.setTip(simpleUser.block_msg);
    }

    public void e(int i2) {
        this.f57582b.getLayoutMode().k(i2 == 1);
        this.f57582b.getLayoutMode().j(this.f57583c);
    }
}

package d.a.n0.p.c;

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
    public final View.OnClickListener f57931a;

    /* renamed from: b  reason: collision with root package name */
    public BaseActivity f57932b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f57933c;

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f57934d;

    /* renamed from: e  reason: collision with root package name */
    public TbSettingTextTipView f57935e;

    /* renamed from: f  reason: collision with root package name */
    public TbSettingTextTipView f57936f;

    public b(BaseActivity baseActivity, View.OnClickListener onClickListener) {
        this.f57932b = baseActivity;
        this.f57931a = onClickListener;
        b();
    }

    public View a() {
        return this.f57933c;
    }

    public final void b() {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.f57932b).inflate(R.layout.account_safe_activity, (ViewGroup) null);
        this.f57933c = linearLayout;
        this.f57934d = (LinearLayout) linearLayout.findViewById(R.id.content_container);
        this.f57935e = (TbSettingTextTipView) this.f57933c.findViewById(R.id.bar_record);
        this.f57936f = (TbSettingTextTipView) this.f57933c.findViewById(R.id.account_status);
        this.f57935e.a();
        this.f57936f.a();
        this.f57935e.setOnClickListener(this.f57931a);
        this.f57936f.setOnClickListener(this.f57931a);
    }

    public void c() {
        this.f57933c.removeAllViews();
        this.f57932b = null;
    }

    public void d(SimpleUser simpleUser) {
        if (simpleUser == null) {
            return;
        }
        this.f57936f.setTip(simpleUser.block_msg);
    }

    public void e(int i2) {
        this.f57932b.getLayoutMode().k(i2 == 1);
        this.f57932b.getLayoutMode().j(this.f57933c);
    }
}

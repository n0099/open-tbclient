package d.b.j0.n.c;

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
    public final View.OnClickListener f58859a;

    /* renamed from: b  reason: collision with root package name */
    public BaseActivity f58860b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f58861c;

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f58862d;

    /* renamed from: e  reason: collision with root package name */
    public TbSettingTextTipView f58863e;

    /* renamed from: f  reason: collision with root package name */
    public TbSettingTextTipView f58864f;

    public b(BaseActivity baseActivity, View.OnClickListener onClickListener) {
        this.f58860b = baseActivity;
        this.f58859a = onClickListener;
        b();
    }

    public View a() {
        return this.f58861c;
    }

    public final void b() {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.f58860b).inflate(R.layout.account_safe_activity, (ViewGroup) null);
        this.f58861c = linearLayout;
        this.f58862d = (LinearLayout) linearLayout.findViewById(R.id.content_container);
        this.f58863e = (TbSettingTextTipView) this.f58861c.findViewById(R.id.bar_record);
        this.f58864f = (TbSettingTextTipView) this.f58861c.findViewById(R.id.account_status);
        this.f58863e.a();
        this.f58864f.a();
        this.f58863e.setOnClickListener(this.f58859a);
        this.f58864f.setOnClickListener(this.f58859a);
    }

    public void c() {
        this.f58861c.removeAllViews();
        this.f58860b = null;
    }

    public void d(SimpleUser simpleUser) {
        if (simpleUser == null) {
            return;
        }
        this.f58864f.setTip(simpleUser.block_msg);
    }

    public void e(int i) {
        this.f58860b.getLayoutMode().k(i == 1);
        this.f58860b.getLayoutMode().j(this.f58861c);
    }
}

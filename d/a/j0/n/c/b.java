package d.a.j0.n.c;

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
    public final View.OnClickListener f56874a;

    /* renamed from: b  reason: collision with root package name */
    public BaseActivity f56875b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f56876c;

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f56877d;

    /* renamed from: e  reason: collision with root package name */
    public TbSettingTextTipView f56878e;

    /* renamed from: f  reason: collision with root package name */
    public TbSettingTextTipView f56879f;

    public b(BaseActivity baseActivity, View.OnClickListener onClickListener) {
        this.f56875b = baseActivity;
        this.f56874a = onClickListener;
        b();
    }

    public View a() {
        return this.f56876c;
    }

    public final void b() {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.f56875b).inflate(R.layout.account_safe_activity, (ViewGroup) null);
        this.f56876c = linearLayout;
        this.f56877d = (LinearLayout) linearLayout.findViewById(R.id.content_container);
        this.f56878e = (TbSettingTextTipView) this.f56876c.findViewById(R.id.bar_record);
        this.f56879f = (TbSettingTextTipView) this.f56876c.findViewById(R.id.account_status);
        this.f56878e.a();
        this.f56879f.a();
        this.f56878e.setOnClickListener(this.f56874a);
        this.f56879f.setOnClickListener(this.f56874a);
    }

    public void c() {
        this.f56876c.removeAllViews();
        this.f56875b = null;
    }

    public void d(SimpleUser simpleUser) {
        if (simpleUser == null) {
            return;
        }
        this.f56879f.setTip(simpleUser.block_msg);
    }

    public void e(int i2) {
        this.f56875b.getLayoutMode().k(i2 == 1);
        this.f56875b.getLayoutMode().j(this.f56876c);
    }
}

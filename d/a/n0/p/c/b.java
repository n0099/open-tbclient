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
    public final View.OnClickListener f61622a;

    /* renamed from: b  reason: collision with root package name */
    public BaseActivity f61623b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f61624c;

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f61625d;

    /* renamed from: e  reason: collision with root package name */
    public TbSettingTextTipView f61626e;

    /* renamed from: f  reason: collision with root package name */
    public TbSettingTextTipView f61627f;

    public b(BaseActivity baseActivity, View.OnClickListener onClickListener) {
        this.f61623b = baseActivity;
        this.f61622a = onClickListener;
        b();
    }

    public View a() {
        return this.f61624c;
    }

    public final void b() {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.f61623b).inflate(R.layout.account_safe_activity, (ViewGroup) null);
        this.f61624c = linearLayout;
        this.f61625d = (LinearLayout) linearLayout.findViewById(R.id.content_container);
        this.f61626e = (TbSettingTextTipView) this.f61624c.findViewById(R.id.bar_record);
        this.f61627f = (TbSettingTextTipView) this.f61624c.findViewById(R.id.account_status);
        this.f61626e.a();
        this.f61627f.a();
        this.f61626e.setOnClickListener(this.f61622a);
        this.f61627f.setOnClickListener(this.f61622a);
    }

    public void c() {
        this.f61624c.removeAllViews();
        this.f61623b = null;
    }

    public void d(SimpleUser simpleUser) {
        if (simpleUser == null) {
            return;
        }
        this.f61627f.setTip(simpleUser.block_msg);
    }

    public void e(int i2) {
        this.f61623b.getLayoutMode().k(i2 == 1);
        this.f61623b.getLayoutMode().j(this.f61624c);
    }
}

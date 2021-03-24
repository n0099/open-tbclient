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
    public final View.OnClickListener f56971a;

    /* renamed from: b  reason: collision with root package name */
    public BaseActivity f56972b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f56973c;

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f56974d;

    /* renamed from: e  reason: collision with root package name */
    public TbSettingTextTipView f56975e;

    /* renamed from: f  reason: collision with root package name */
    public TbSettingTextTipView f56976f;

    public b(BaseActivity baseActivity, View.OnClickListener onClickListener) {
        this.f56972b = baseActivity;
        this.f56971a = onClickListener;
        b();
    }

    public View a() {
        return this.f56973c;
    }

    public final void b() {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.f56972b).inflate(R.layout.account_safe_activity, (ViewGroup) null);
        this.f56973c = linearLayout;
        this.f56974d = (LinearLayout) linearLayout.findViewById(R.id.content_container);
        this.f56975e = (TbSettingTextTipView) this.f56973c.findViewById(R.id.bar_record);
        this.f56976f = (TbSettingTextTipView) this.f56973c.findViewById(R.id.account_status);
        this.f56975e.a();
        this.f56976f.a();
        this.f56975e.setOnClickListener(this.f56971a);
        this.f56976f.setOnClickListener(this.f56971a);
    }

    public void c() {
        this.f56973c.removeAllViews();
        this.f56972b = null;
    }

    public void d(SimpleUser simpleUser) {
        if (simpleUser == null) {
            return;
        }
        this.f56976f.setTip(simpleUser.block_msg);
    }

    public void e(int i) {
        this.f56972b.getLayoutMode().k(i == 1);
        this.f56972b.getLayoutMode().j(this.f56973c);
    }
}

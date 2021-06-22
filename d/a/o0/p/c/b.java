package d.a.o0.p.c;

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
    public final View.OnClickListener f61747a;

    /* renamed from: b  reason: collision with root package name */
    public BaseActivity f61748b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f61749c;

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f61750d;

    /* renamed from: e  reason: collision with root package name */
    public TbSettingTextTipView f61751e;

    /* renamed from: f  reason: collision with root package name */
    public TbSettingTextTipView f61752f;

    public b(BaseActivity baseActivity, View.OnClickListener onClickListener) {
        this.f61748b = baseActivity;
        this.f61747a = onClickListener;
        b();
    }

    public View a() {
        return this.f61749c;
    }

    public final void b() {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.f61748b).inflate(R.layout.account_safe_activity, (ViewGroup) null);
        this.f61749c = linearLayout;
        this.f61750d = (LinearLayout) linearLayout.findViewById(R.id.content_container);
        this.f61751e = (TbSettingTextTipView) this.f61749c.findViewById(R.id.bar_record);
        this.f61752f = (TbSettingTextTipView) this.f61749c.findViewById(R.id.account_status);
        this.f61751e.a();
        this.f61752f.a();
        this.f61751e.setOnClickListener(this.f61747a);
        this.f61752f.setOnClickListener(this.f61747a);
    }

    public void c() {
        this.f61749c.removeAllViews();
        this.f61748b = null;
    }

    public void d(SimpleUser simpleUser) {
        if (simpleUser == null) {
            return;
        }
        this.f61752f.setTip(simpleUser.block_msg);
    }

    public void e(int i2) {
        this.f61748b.getLayoutMode().k(i2 == 1);
        this.f61748b.getLayoutMode().j(this.f61749c);
    }
}

package d.a.i0.z0;

import android.content.Context;
import android.text.style.ClickableSpan;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
/* loaded from: classes3.dex */
public class r extends ClickableSpan {

    /* renamed from: e  reason: collision with root package name */
    public Context f50184e;

    public r(Context context) {
        this.f50184e = null;
        this.f50184e = context;
    }

    public Context a() {
        return this.f50184e;
    }

    public void b(String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.f50184e).createNormalCfg(str, null, null)));
    }

    public void c(String str) {
        d.a.i0.l.a.l(this.f50184e, str);
    }
}

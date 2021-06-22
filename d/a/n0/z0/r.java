package d.a.n0.z0;

import android.content.Context;
import android.text.style.ClickableSpan;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
/* loaded from: classes3.dex */
public class r extends ClickableSpan {

    /* renamed from: e  reason: collision with root package name */
    public Context f54861e;

    public r(Context context) {
        this.f54861e = null;
        this.f54861e = context;
    }

    public Context a() {
        return this.f54861e;
    }

    public void b(String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.f54861e).createNormalCfg(str, null, null)));
    }

    public void c(String str) {
        d.a.n0.l.a.l(this.f54861e, str);
    }
}

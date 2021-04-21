package d.b.j0.s.b.l;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes4.dex */
public class a extends d.b.h0.a.n1.a.a.a {
    @Override // d.b.h0.a.n1.a.a.a
    public void b(@NonNull Bundle bundle) {
        String string = bundle.getString("key_param_url");
        if (StringUtils.isNull(string)) {
            c();
        } else {
            MessageManager.getInstance().sendMessage(new CustomMessage(2001447, string));
        }
    }
}

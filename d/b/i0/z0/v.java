package d.b.i0.z0;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes3.dex */
public class v {
    public static final <T extends IntentConfig> void a(int i, T t) {
        MessageManager.getInstance().sendMessage(new CustomMessage(i, t));
    }

    public static final <T extends IntentConfig> void b(T t) {
        a(2002001, t);
    }
}

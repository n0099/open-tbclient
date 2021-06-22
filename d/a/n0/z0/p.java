package d.a.n0.z0;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.InitUserNameDialogActivityConfig;
/* loaded from: classes3.dex */
public class p {

    /* loaded from: classes3.dex */
    public static class a implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            p.b();
        }
    }

    public static void a() {
        if (!d.a.c.e.p.l.C()) {
            d.a.c.e.m.e.a().post(new a());
        } else {
            b();
        }
    }

    public static void b() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new InitUserNameDialogActivityConfig(TbadkCoreApplication.getInst().getContext())));
    }
}

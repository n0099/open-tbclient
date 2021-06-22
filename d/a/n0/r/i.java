package d.a.n0.r;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes3.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public static final CustomMessageListener f53637a = new a(0);

    /* loaded from: classes3.dex */
    public static class a extends CustomMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null) {
                return;
            }
            switch (customResponsedMessage.getCmd()) {
                case 2005009:
                    TbadkCoreApplication.getInst().startSyncService();
                    return;
                case 2005010:
                    TbadkCoreApplication.getInst().stopSyncService();
                    return;
                case 2005011:
                    TbadkCoreApplication.getInst().startActiveService();
                    return;
                case 2005012:
                    TbadkCoreApplication.getInst().stopActiveServide();
                    return;
                case 2005013:
                    TbadkCoreApplication.getInst().startClearTempService();
                    return;
                case 2005014:
                default:
                    return;
                case 2005015:
                    TbadkCoreApplication.getInst().startSyncLoginService();
                    return;
            }
        }
    }

    public static void a() {
        MessageManager.getInstance().registerListener(2005009, f53637a);
        MessageManager.getInstance().registerListener(2005010, f53637a);
        MessageManager.getInstance().registerListener(2005011, f53637a);
        MessageManager.getInstance().registerListener(2005012, f53637a);
        MessageManager.getInstance().registerListener(2005013, f53637a);
        MessageManager.getInstance().registerListener(2005015, f53637a);
    }
}

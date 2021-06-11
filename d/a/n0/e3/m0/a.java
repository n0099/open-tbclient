package d.a.n0.e3.m0;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ExceptionData;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: d.a.n0.e3.m0.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C1354a extends CustomMessageListener {
        public C1354a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof ExceptionData) || !((ExceptionData) customResponsedMessage.getData()).info.contains("com.baidu.location")) {
                return;
            }
            TbadkCoreApplication.getInst().addBDLocCrashCount();
        }
    }

    public static void a() {
        MessageManager.getInstance().registerListener(new C1354a(2016301));
    }
}

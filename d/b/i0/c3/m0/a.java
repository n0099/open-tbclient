package d.b.i0.c3.m0;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ExceptionData;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: d.b.i0.c3.m0.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C1188a extends CustomMessageListener {
        public C1188a(int i) {
            super(i);
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
        MessageManager.getInstance().registerListener(new C1188a(2016301));
    }
}

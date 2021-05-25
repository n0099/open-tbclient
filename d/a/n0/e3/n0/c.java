package d.a.n0.e3.n0;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class c extends d {

    /* renamed from: d  reason: collision with root package name */
    public volatile HashMap<String, Long> f54141d;

    /* loaded from: classes5.dex */
    public static class a extends CustomMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (TbadkCoreApplication.getInst().getPhotoLiveReadThreadHistory() != null) {
                TbadkCoreApplication.getInst().getPhotoLiveReadThreadHistory().e();
            }
        }
    }

    static {
        MessageManager.getInstance().registerListener(new a(2005016));
    }

    public c(int i2) {
        super(i2);
        this.f54141d = new HashMap<>();
    }

    public void e() {
        synchronized (this) {
            this.f54144c.clear();
            this.f54141d.clear();
        }
    }

    public long f(String str) {
        try {
            synchronized (this) {
                if (this.f54141d.get(str) != null) {
                    return this.f54141d.get(str).longValue();
                }
                return 0L;
            }
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
            return 0L;
        }
    }
}

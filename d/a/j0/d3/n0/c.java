package d.a.j0.d3.n0;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class c extends d {

    /* renamed from: d  reason: collision with root package name */
    public volatile HashMap<String, Long> f53221d;

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
        this.f53221d = new HashMap<>();
    }

    public void e() {
        synchronized (this) {
            this.f53224c.clear();
            this.f53221d.clear();
        }
    }

    public long f(String str) {
        try {
            synchronized (this) {
                if (this.f53221d.get(str) != null) {
                    return this.f53221d.get(str).longValue();
                }
                return 0L;
            }
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
            return 0L;
        }
    }
}

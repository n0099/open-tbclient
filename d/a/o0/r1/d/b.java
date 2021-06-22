package d.a.o0.r1.d;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.searchbox.live.interfaces.realauth.LiveRealAuthCallback;
import com.baidu.searchbox.live.interfaces.service.LiveRealAuthService;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.wallet.ICertification;
import java.util.Map;
/* loaded from: classes3.dex */
public class b implements LiveRealAuthService {

    /* loaded from: classes3.dex */
    public class a implements ICertification.CertificationCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LiveRealAuthCallback f63699a;

        public a(b bVar, LiveRealAuthCallback liveRealAuthCallback) {
            this.f63699a = liveRealAuthCallback;
        }

        @Override // com.baidu.tieba.wallet.ICertification.CertificationCallback
        public void onResult(int i2, Map<String, Object> map) {
            LiveRealAuthCallback liveRealAuthCallback = this.f63699a;
            if (liveRealAuthCallback != null) {
                liveRealAuthCallback.onRealAuthResult(i2, map);
            }
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.service.LiveRealAuthService
    public void doAuth(Map<String, ?> map, LiveRealAuthCallback liveRealAuthCallback) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921433, ICertification.class);
        if (runTask == null || runTask.getData() == null) {
            return;
        }
        ((ICertification) runTask.getData()).certification(TbadkCoreApplication.getInst(), map, new a(this, liveRealAuthCallback));
    }
}

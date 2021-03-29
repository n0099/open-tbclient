package d.b.i0.s.b.i;

import android.app.Activity;
import android.os.Bundle;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.sapi2.service.AbstractThirdPartyService;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation;
import com.baidu.tbadk.core.TbadkCoreApplication;
import d.b.h0.l0.d;
import java.util.Map;
/* loaded from: classes4.dex */
public class a extends ActivityDelegation implements d.b.g0.a.m.a {

    /* renamed from: f  reason: collision with root package name */
    public d.b.i0.s.b.i.d.a f60085f;

    /* renamed from: g  reason: collision with root package name */
    public Activity f60086g;

    /* renamed from: h  reason: collision with root package name */
    public Map<String, String> f60087h;

    /* renamed from: e  reason: collision with root package name */
    public BdUniqueId f60084e = BdUniqueId.gen();
    public CustomMessageListener i = new C1526a(2921393);

    /* renamed from: d.b.i0.s.b.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1526a extends CustomMessageListener {
        public C1526a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getData() == null) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (data instanceof d) {
                d dVar = (d) data;
                if (getTag() == dVar.f50297a || dVar.f50303g) {
                    a.this.mResult.putInt("result_code", dVar.f50298b);
                    a.this.mResult.putString(AbstractThirdPartyService.EXTRA_RESULT_MSG, dVar.f50299c);
                    if (a.this.f60085f != null) {
                        a.this.f60085f.a(a.this.mResult);
                    }
                    a.this.finish();
                }
            }
        }
    }

    public void b(Activity activity) {
        this.f60086g = activity;
    }

    public void c(d.b.i0.s.b.i.d.a aVar) {
        this.f60085f = aVar;
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    public void finish() {
        this.f60085f = null;
        MessageManager.getInstance().unRegisterListener(this.i);
        super.finish();
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    public boolean onExec() {
        this.i.setTag(this.f60084e);
        MessageManager.getInstance().registerListener(this.i);
        int i = this.mParams.getInt("type");
        String string = this.mParams.getString("orderInfo");
        d dVar = new d();
        dVar.f50297a = this.f60084e;
        dVar.f50298b = i;
        dVar.f50299c = string;
        dVar.f50301e = (Map) this.mParams.getSerializable("params");
        dVar.f50302f = this.f60087h;
        if (getAgent() != null) {
            dVar.f50300d = getAgent();
        } else {
            Activity activity = this.f60086g;
            if (activity != null) {
                dVar.f50300d = activity;
            } else {
                dVar.f50300d = TbadkCoreApplication.getInst().getCurrentActivity();
            }
        }
        CustomMessage customMessage = new CustomMessage(2921393, dVar);
        customMessage.setTag(this.f60084e);
        boolean sendMessage = MessageManager.getInstance().sendMessage(customMessage);
        this.mResult.putInt("result_code", sendMessage ? 0 : 1);
        Bundle bundle = this.mResult;
        bundle.putString(AbstractThirdPartyService.EXTRA_RESULT_MSG, "" + sendMessage);
        return false;
    }

    @Override // d.b.g0.a.m.a
    public void onResult(int i) {
        this.mResult.putInt("result_code", i);
        this.mResult.putString(AbstractThirdPartyService.EXTRA_RESULT_MSG, "");
        finish();
    }
}

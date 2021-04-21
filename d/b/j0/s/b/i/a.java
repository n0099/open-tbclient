package d.b.j0.s.b.i;

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
import d.b.i0.l0.d;
import java.util.Map;
/* loaded from: classes4.dex */
public class a extends ActivityDelegation implements d.b.h0.a.m.a {

    /* renamed from: f  reason: collision with root package name */
    public d.b.j0.s.b.i.d.a f61807f;

    /* renamed from: g  reason: collision with root package name */
    public Activity f61808g;

    /* renamed from: h  reason: collision with root package name */
    public Map<String, String> f61809h;

    /* renamed from: e  reason: collision with root package name */
    public BdUniqueId f61806e = BdUniqueId.gen();
    public CustomMessageListener i = new C1588a(2921393);

    /* renamed from: d.b.j0.s.b.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1588a extends CustomMessageListener {
        public C1588a(int i) {
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
                if (getTag() == dVar.f51040a || dVar.f51046g) {
                    a.this.mResult.putInt("result_code", dVar.f51041b);
                    a.this.mResult.putString(AbstractThirdPartyService.EXTRA_RESULT_MSG, dVar.f51042c);
                    if (a.this.f61807f != null) {
                        a.this.f61807f.a(a.this.mResult);
                    }
                    a.this.finish();
                }
            }
        }
    }

    public void b(Activity activity) {
        this.f61808g = activity;
    }

    public void c(d.b.j0.s.b.i.d.a aVar) {
        this.f61807f = aVar;
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    public void finish() {
        this.f61807f = null;
        MessageManager.getInstance().unRegisterListener(this.i);
        super.finish();
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    public boolean onExec() {
        this.i.setTag(this.f61806e);
        MessageManager.getInstance().registerListener(this.i);
        int i = this.mParams.getInt("type");
        String string = this.mParams.getString("orderInfo");
        d dVar = new d();
        dVar.f51040a = this.f61806e;
        dVar.f51041b = i;
        dVar.f51042c = string;
        dVar.f51044e = (Map) this.mParams.getSerializable("params");
        dVar.f51045f = this.f61809h;
        if (getAgent() != null) {
            dVar.f51043d = getAgent();
        } else {
            Activity activity = this.f61808g;
            if (activity != null) {
                dVar.f51043d = activity;
            } else {
                dVar.f51043d = TbadkCoreApplication.getInst().getCurrentActivity();
            }
        }
        CustomMessage customMessage = new CustomMessage(2921393, dVar);
        customMessage.setTag(this.f61806e);
        boolean sendMessage = MessageManager.getInstance().sendMessage(customMessage);
        this.mResult.putInt("result_code", sendMessage ? 0 : 1);
        Bundle bundle = this.mResult;
        bundle.putString(AbstractThirdPartyService.EXTRA_RESULT_MSG, "" + sendMessage);
        return false;
    }

    @Override // d.b.h0.a.m.a
    public void onResult(int i) {
        this.mResult.putInt("result_code", i);
        this.mResult.putString(AbstractThirdPartyService.EXTRA_RESULT_MSG, "");
        finish();
    }
}

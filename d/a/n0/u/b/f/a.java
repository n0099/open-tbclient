package d.a.n0.u.b.f;

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
import d.a.m0.l0.e;
import java.util.Map;
/* loaded from: classes4.dex */
public class a extends ActivityDelegation implements d.a.l0.a.m.a {

    /* renamed from: f  reason: collision with root package name */
    public d.a.n0.u.b.f.d.a f61265f;

    /* renamed from: g  reason: collision with root package name */
    public Activity f61266g;

    /* renamed from: h  reason: collision with root package name */
    public Map<String, String> f61267h;

    /* renamed from: e  reason: collision with root package name */
    public BdUniqueId f61264e = BdUniqueId.gen();

    /* renamed from: i  reason: collision with root package name */
    public CustomMessageListener f61268i = new C1629a(2921393);

    /* renamed from: d.a.n0.u.b.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1629a extends CustomMessageListener {
        public C1629a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getData() == null) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (data instanceof e) {
                e eVar = (e) data;
                if (getTag() == eVar.f49500a || eVar.f49506g) {
                    a.this.mResult.putInt("result_code", eVar.f49501b);
                    a.this.mResult.putString(AbstractThirdPartyService.EXTRA_RESULT_MSG, eVar.f49502c);
                    if (a.this.f61265f != null) {
                        a.this.f61265f.a(a.this.mResult);
                    }
                    a.this.finish();
                }
            }
        }
    }

    public void b(Activity activity) {
        this.f61266g = activity;
    }

    public void c(d.a.n0.u.b.f.d.a aVar) {
        this.f61265f = aVar;
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    public void finish() {
        this.f61265f = null;
        MessageManager.getInstance().unRegisterListener(this.f61268i);
        super.finish();
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    public boolean onExec() {
        this.f61268i.setTag(this.f61264e);
        MessageManager.getInstance().registerListener(this.f61268i);
        int i2 = this.mParams.getInt("type");
        String string = this.mParams.getString("orderInfo");
        e eVar = new e();
        eVar.f49500a = this.f61264e;
        eVar.f49501b = i2;
        eVar.f49502c = string;
        eVar.f49504e = (Map) this.mParams.getSerializable("params");
        eVar.f49505f = this.f61267h;
        if (getAgent() != null) {
            eVar.f49503d = getAgent();
        } else {
            Activity activity = this.f61266g;
            if (activity != null) {
                eVar.f49503d = activity;
            } else {
                eVar.f49503d = TbadkCoreApplication.getInst().getCurrentActivity();
            }
        }
        CustomMessage customMessage = new CustomMessage(2921393, eVar);
        customMessage.setTag(this.f61264e);
        boolean sendMessage = MessageManager.getInstance().sendMessage(customMessage);
        this.mResult.putInt("result_code", sendMessage ? 0 : 1);
        Bundle bundle = this.mResult;
        bundle.putString(AbstractThirdPartyService.EXTRA_RESULT_MSG, "" + sendMessage);
        return false;
    }

    @Override // d.a.l0.a.m.a
    public void onResult(int i2) {
        this.mResult.putInt("result_code", i2);
        this.mResult.putString(AbstractThirdPartyService.EXTRA_RESULT_MSG, "");
        finish();
    }
}

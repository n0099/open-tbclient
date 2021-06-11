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
    public d.a.n0.u.b.f.d.a f64974f;

    /* renamed from: g  reason: collision with root package name */
    public Activity f64975g;

    /* renamed from: h  reason: collision with root package name */
    public Map<String, String> f64976h;

    /* renamed from: e  reason: collision with root package name */
    public BdUniqueId f64973e = BdUniqueId.gen();

    /* renamed from: i  reason: collision with root package name */
    public CustomMessageListener f64977i = new C1686a(2921393);

    /* renamed from: d.a.n0.u.b.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1686a extends CustomMessageListener {
        public C1686a(int i2) {
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
                if (getTag() == eVar.f53174a || eVar.f53180g) {
                    a.this.mResult.putInt("result_code", eVar.f53175b);
                    a.this.mResult.putString(AbstractThirdPartyService.EXTRA_RESULT_MSG, eVar.f53176c);
                    if (a.this.f64974f != null) {
                        a.this.f64974f.a(a.this.mResult);
                    }
                    a.this.finish();
                }
            }
        }
    }

    public void b(Activity activity) {
        this.f64975g = activity;
    }

    public void c(d.a.n0.u.b.f.d.a aVar) {
        this.f64974f = aVar;
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    public void finish() {
        this.f64974f = null;
        MessageManager.getInstance().unRegisterListener(this.f64977i);
        super.finish();
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    public boolean onExec() {
        this.f64977i.setTag(this.f64973e);
        MessageManager.getInstance().registerListener(this.f64977i);
        int i2 = this.mParams.getInt("type");
        String string = this.mParams.getString("orderInfo");
        e eVar = new e();
        eVar.f53174a = this.f64973e;
        eVar.f53175b = i2;
        eVar.f53176c = string;
        eVar.f53178e = (Map) this.mParams.getSerializable("params");
        eVar.f53179f = this.f64976h;
        if (getAgent() != null) {
            eVar.f53177d = getAgent();
        } else {
            Activity activity = this.f64975g;
            if (activity != null) {
                eVar.f53177d = activity;
            } else {
                eVar.f53177d = TbadkCoreApplication.getInst().getCurrentActivity();
            }
        }
        CustomMessage customMessage = new CustomMessage(2921393, eVar);
        customMessage.setTag(this.f64973e);
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

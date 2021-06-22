package d.a.o0.u.b.f;

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
import d.a.n0.l0.e;
import java.util.Map;
/* loaded from: classes4.dex */
public class a extends ActivityDelegation implements d.a.m0.a.m.a {

    /* renamed from: f  reason: collision with root package name */
    public d.a.o0.u.b.f.d.a f65099f;

    /* renamed from: g  reason: collision with root package name */
    public Activity f65100g;

    /* renamed from: h  reason: collision with root package name */
    public Map<String, String> f65101h;

    /* renamed from: e  reason: collision with root package name */
    public BdUniqueId f65098e = BdUniqueId.gen();

    /* renamed from: i  reason: collision with root package name */
    public CustomMessageListener f65102i = new C1690a(2921393);

    /* renamed from: d.a.o0.u.b.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1690a extends CustomMessageListener {
        public C1690a(int i2) {
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
                if (getTag() == eVar.f53281a || eVar.f53287g) {
                    a.this.mResult.putInt("result_code", eVar.f53282b);
                    a.this.mResult.putString(AbstractThirdPartyService.EXTRA_RESULT_MSG, eVar.f53283c);
                    if (a.this.f65099f != null) {
                        a.this.f65099f.a(a.this.mResult);
                    }
                    a.this.finish();
                }
            }
        }
    }

    public void b(Activity activity) {
        this.f65100g = activity;
    }

    public void c(d.a.o0.u.b.f.d.a aVar) {
        this.f65099f = aVar;
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    public void finish() {
        this.f65099f = null;
        MessageManager.getInstance().unRegisterListener(this.f65102i);
        super.finish();
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    public boolean onExec() {
        this.f65102i.setTag(this.f65098e);
        MessageManager.getInstance().registerListener(this.f65102i);
        int i2 = this.mParams.getInt("type");
        String string = this.mParams.getString("orderInfo");
        e eVar = new e();
        eVar.f53281a = this.f65098e;
        eVar.f53282b = i2;
        eVar.f53283c = string;
        eVar.f53285e = (Map) this.mParams.getSerializable("params");
        eVar.f53286f = this.f65101h;
        if (getAgent() != null) {
            eVar.f53284d = getAgent();
        } else {
            Activity activity = this.f65100g;
            if (activity != null) {
                eVar.f53284d = activity;
            } else {
                eVar.f53284d = TbadkCoreApplication.getInst().getCurrentActivity();
            }
        }
        CustomMessage customMessage = new CustomMessage(2921393, eVar);
        customMessage.setTag(this.f65098e);
        boolean sendMessage = MessageManager.getInstance().sendMessage(customMessage);
        this.mResult.putInt("result_code", sendMessage ? 0 : 1);
        Bundle bundle = this.mResult;
        bundle.putString(AbstractThirdPartyService.EXTRA_RESULT_MSG, "" + sendMessage);
        return false;
    }

    @Override // d.a.m0.a.m.a
    public void onResult(int i2) {
        this.mResult.putInt("result_code", i2);
        this.mResult.putString(AbstractThirdPartyService.EXTRA_RESULT_MSG, "");
        finish();
    }
}

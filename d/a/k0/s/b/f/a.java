package d.a.k0.s.b.f;

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
import d.a.j0.l0.e;
import java.util.Map;
/* loaded from: classes4.dex */
public class a extends ActivityDelegation implements d.a.i0.a.m.a {

    /* renamed from: f  reason: collision with root package name */
    public d.a.k0.s.b.f.d.a f60692f;

    /* renamed from: g  reason: collision with root package name */
    public Activity f60693g;

    /* renamed from: h  reason: collision with root package name */
    public Map<String, String> f60694h;

    /* renamed from: e  reason: collision with root package name */
    public BdUniqueId f60691e = BdUniqueId.gen();

    /* renamed from: i  reason: collision with root package name */
    public CustomMessageListener f60695i = new C1598a(2921393);

    /* renamed from: d.a.k0.s.b.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1598a extends CustomMessageListener {
        public C1598a(int i2) {
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
                if (getTag() == eVar.f49456a || eVar.f49462g) {
                    a.this.mResult.putInt("result_code", eVar.f49457b);
                    a.this.mResult.putString(AbstractThirdPartyService.EXTRA_RESULT_MSG, eVar.f49458c);
                    if (a.this.f60692f != null) {
                        a.this.f60692f.a(a.this.mResult);
                    }
                    a.this.finish();
                }
            }
        }
    }

    public void b(Activity activity) {
        this.f60693g = activity;
    }

    public void c(d.a.k0.s.b.f.d.a aVar) {
        this.f60692f = aVar;
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    public void finish() {
        this.f60692f = null;
        MessageManager.getInstance().unRegisterListener(this.f60695i);
        super.finish();
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    public boolean onExec() {
        this.f60695i.setTag(this.f60691e);
        MessageManager.getInstance().registerListener(this.f60695i);
        int i2 = this.mParams.getInt("type");
        String string = this.mParams.getString("orderInfo");
        e eVar = new e();
        eVar.f49456a = this.f60691e;
        eVar.f49457b = i2;
        eVar.f49458c = string;
        eVar.f49460e = (Map) this.mParams.getSerializable("params");
        eVar.f49461f = this.f60694h;
        if (getAgent() != null) {
            eVar.f49459d = getAgent();
        } else {
            Activity activity = this.f60693g;
            if (activity != null) {
                eVar.f49459d = activity;
            } else {
                eVar.f49459d = TbadkCoreApplication.getInst().getCurrentActivity();
            }
        }
        CustomMessage customMessage = new CustomMessage(2921393, eVar);
        customMessage.setTag(this.f60691e);
        boolean sendMessage = MessageManager.getInstance().sendMessage(customMessage);
        this.mResult.putInt("result_code", sendMessage ? 0 : 1);
        Bundle bundle = this.mResult;
        bundle.putString(AbstractThirdPartyService.EXTRA_RESULT_MSG, "" + sendMessage);
        return false;
    }

    @Override // d.a.i0.a.m.a
    public void onResult(int i2) {
        this.mResult.putInt("result_code", i2);
        this.mResult.putString(AbstractThirdPartyService.EXTRA_RESULT_MSG, "");
        finish();
    }
}

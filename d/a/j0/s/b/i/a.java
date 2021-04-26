package d.a.j0.s.b.i;

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
import d.a.i0.l0.e;
import java.util.Map;
/* loaded from: classes4.dex */
public class a extends ActivityDelegation implements d.a.h0.a.m.a {

    /* renamed from: f  reason: collision with root package name */
    public d.a.j0.s.b.i.d.a f59965f;

    /* renamed from: g  reason: collision with root package name */
    public Activity f59966g;

    /* renamed from: h  reason: collision with root package name */
    public Map<String, String> f59967h;

    /* renamed from: e  reason: collision with root package name */
    public BdUniqueId f59964e = BdUniqueId.gen();

    /* renamed from: i  reason: collision with root package name */
    public CustomMessageListener f59968i = new C1527a(2921393);

    /* renamed from: d.a.j0.s.b.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1527a extends CustomMessageListener {
        public C1527a(int i2) {
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
                if (getTag() == eVar.f48627a || eVar.f48633g) {
                    a.this.mResult.putInt("result_code", eVar.f48628b);
                    a.this.mResult.putString(AbstractThirdPartyService.EXTRA_RESULT_MSG, eVar.f48629c);
                    if (a.this.f59965f != null) {
                        a.this.f59965f.a(a.this.mResult);
                    }
                    a.this.finish();
                }
            }
        }
    }

    public void b(Activity activity) {
        this.f59966g = activity;
    }

    public void c(d.a.j0.s.b.i.d.a aVar) {
        this.f59965f = aVar;
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    public void finish() {
        this.f59965f = null;
        MessageManager.getInstance().unRegisterListener(this.f59968i);
        super.finish();
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    public boolean onExec() {
        this.f59968i.setTag(this.f59964e);
        MessageManager.getInstance().registerListener(this.f59968i);
        int i2 = this.mParams.getInt("type");
        String string = this.mParams.getString("orderInfo");
        e eVar = new e();
        eVar.f48627a = this.f59964e;
        eVar.f48628b = i2;
        eVar.f48629c = string;
        eVar.f48631e = (Map) this.mParams.getSerializable("params");
        eVar.f48632f = this.f59967h;
        if (getAgent() != null) {
            eVar.f48630d = getAgent();
        } else {
            Activity activity = this.f59966g;
            if (activity != null) {
                eVar.f48630d = activity;
            } else {
                eVar.f48630d = TbadkCoreApplication.getInst().getCurrentActivity();
            }
        }
        CustomMessage customMessage = new CustomMessage(2921393, eVar);
        customMessage.setTag(this.f59964e);
        boolean sendMessage = MessageManager.getInstance().sendMessage(customMessage);
        this.mResult.putInt("result_code", sendMessage ? 0 : 1);
        Bundle bundle = this.mResult;
        bundle.putString(AbstractThirdPartyService.EXTRA_RESULT_MSG, "" + sendMessage);
        return false;
    }

    @Override // d.a.h0.a.m.a
    public void onResult(int i2) {
        this.mResult.putInt("result_code", i2);
        this.mResult.putString(AbstractThirdPartyService.EXTRA_RESULT_MSG, "");
        finish();
    }
}

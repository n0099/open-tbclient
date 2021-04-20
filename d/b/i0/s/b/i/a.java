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
    public d.b.i0.s.b.i.d.a f61386f;

    /* renamed from: g  reason: collision with root package name */
    public Activity f61387g;

    /* renamed from: h  reason: collision with root package name */
    public Map<String, String> f61388h;

    /* renamed from: e  reason: collision with root package name */
    public BdUniqueId f61385e = BdUniqueId.gen();
    public CustomMessageListener i = new C1565a(2921393);

    /* renamed from: d.b.i0.s.b.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1565a extends CustomMessageListener {
        public C1565a(int i) {
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
                if (getTag() == dVar.f50704a || dVar.f50710g) {
                    a.this.mResult.putInt("result_code", dVar.f50705b);
                    a.this.mResult.putString(AbstractThirdPartyService.EXTRA_RESULT_MSG, dVar.f50706c);
                    if (a.this.f61386f != null) {
                        a.this.f61386f.a(a.this.mResult);
                    }
                    a.this.finish();
                }
            }
        }
    }

    public void b(Activity activity) {
        this.f61387g = activity;
    }

    public void c(d.b.i0.s.b.i.d.a aVar) {
        this.f61386f = aVar;
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    public void finish() {
        this.f61386f = null;
        MessageManager.getInstance().unRegisterListener(this.i);
        super.finish();
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    public boolean onExec() {
        this.i.setTag(this.f61385e);
        MessageManager.getInstance().registerListener(this.i);
        int i = this.mParams.getInt("type");
        String string = this.mParams.getString("orderInfo");
        d dVar = new d();
        dVar.f50704a = this.f61385e;
        dVar.f50705b = i;
        dVar.f50706c = string;
        dVar.f50708e = (Map) this.mParams.getSerializable("params");
        dVar.f50709f = this.f61388h;
        if (getAgent() != null) {
            dVar.f50707d = getAgent();
        } else {
            Activity activity = this.f61387g;
            if (activity != null) {
                dVar.f50707d = activity;
            } else {
                dVar.f50707d = TbadkCoreApplication.getInst().getCurrentActivity();
            }
        }
        CustomMessage customMessage = new CustomMessage(2921393, dVar);
        customMessage.setTag(this.f61385e);
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

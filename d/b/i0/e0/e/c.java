package d.b.i0.e0.e;

import android.app.Activity;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.wallet.BaiduWalletServiceProviderMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c implements b {

    /* renamed from: a  reason: collision with root package name */
    public long f50903a;

    /* renamed from: b  reason: collision with root package name */
    public long f50904b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, d.b.i0.e0.e.a> f50905c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    public boolean f50906d;

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final c f50907a = new c();
    }

    public static final c d() {
        return a.f50907a;
    }

    @Override // d.b.i0.e0.e.b
    public void a() {
        boolean z;
        Iterator<Map.Entry<String, d.b.i0.e0.e.a>> it = this.f50905c.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                z = true;
                break;
            }
            Map.Entry<String, d.b.i0.e0.e.a> next = it.next();
            if (next.getValue() != null && !next.getValue().m()) {
                z = false;
                break;
            }
        }
        this.f50906d = z;
        if (z) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921541, Boolean.TRUE));
        }
    }

    public boolean b() {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        return this.f50906d && currentTimeMillis > f() && currentTimeMillis < e();
    }

    public d.b.i0.e0.e.a c(String str) {
        return this.f50905c.get(str);
    }

    public long e() {
        return this.f50904b;
    }

    public long f() {
        return this.f50903a;
    }

    public void g() {
        BdUniqueId uniqueId;
        Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
        if (currentActivity instanceof BaseActivity) {
            uniqueId = ((BaseActivity) currentActivity).getUniqueId();
        } else {
            uniqueId = currentActivity instanceof BaseFragmentActivity ? ((BaseFragmentActivity) currentActivity).getUniqueId() : null;
        }
        for (Map.Entry<String, d.b.i0.e0.e.a> entry : this.f50905c.entrySet()) {
            if (entry.getValue() != null) {
                entry.getValue().q(uniqueId);
                entry.getValue().p(this);
                entry.getValue().n();
            }
        }
    }

    public void h(JSONObject jSONObject) {
        this.f50903a = jSONObject.optLong("start_time");
        this.f50904b = jSONObject.optLong("end_time");
        JSONObject optJSONObject = jSONObject.optJSONObject("feed");
        if (optJSONObject != null) {
            d.b.i0.e0.e.a aVar = new d.b.i0.e0.e.a();
            aVar.o(optJSONObject);
            this.f50905c.put("homePage", aVar);
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("forum");
        if (optJSONObject2 != null) {
            d.b.i0.e0.e.a aVar2 = new d.b.i0.e0.e.a();
            aVar2.o(optJSONObject2);
            this.f50905c.put("enterForum", aVar2);
        }
        JSONObject optJSONObject3 = jSONObject.optJSONObject("channel");
        if (optJSONObject3 != null) {
            d.b.i0.e0.e.a aVar3 = new d.b.i0.e0.e.a();
            aVar3.o(optJSONObject3);
            this.f50905c.put("channel", aVar3);
        }
        JSONObject optJSONObject4 = jSONObject.optJSONObject("news");
        if (optJSONObject4 != null) {
            d.b.i0.e0.e.a aVar4 = new d.b.i0.e0.e.a();
            aVar4.o(optJSONObject4);
            this.f50905c.put("message", aVar4);
        }
        JSONObject optJSONObject5 = jSONObject.optJSONObject(BaiduWalletServiceProviderMap.PLUGIN_PERSONAL);
        if (optJSONObject5 != null) {
            d.b.i0.e0.e.a aVar5 = new d.b.i0.e0.e.a();
            aVar5.o(optJSONObject5);
            this.f50905c.put("person", aVar5);
        }
    }
}

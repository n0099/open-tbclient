package d.a.n0.e0.e;

import android.app.Activity;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.wallet.BaiduWalletServiceProviderMap;
import com.yy.gslbsdk.db.ResultTB;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c implements b {

    /* renamed from: a  reason: collision with root package name */
    public long f53135a;

    /* renamed from: b  reason: collision with root package name */
    public long f53136b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, d.a.n0.e0.e.a> f53137c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    public boolean f53138d;

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final c f53139a = new c();
    }

    public static final c d() {
        return a.f53139a;
    }

    @Override // d.a.n0.e0.e.b
    public void a() {
        boolean z;
        Iterator<Map.Entry<String, d.a.n0.e0.e.a>> it = this.f53137c.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                z = true;
                break;
            }
            Map.Entry<String, d.a.n0.e0.e.a> next = it.next();
            if (next.getValue() != null && !next.getValue().m()) {
                z = false;
                break;
            }
        }
        this.f53138d = z;
        if (z) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921551, Boolean.TRUE));
        }
    }

    public boolean b() {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        return this.f53138d && currentTimeMillis > f() && currentTimeMillis < e();
    }

    public d.a.n0.e0.e.a c(String str) {
        return this.f53137c.get(str);
    }

    public long e() {
        return this.f53136b;
    }

    public long f() {
        return this.f53135a;
    }

    public void g() {
        BdUniqueId uniqueId;
        Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
        if (currentActivity instanceof BaseActivity) {
            uniqueId = ((BaseActivity) currentActivity).getUniqueId();
        } else {
            uniqueId = currentActivity instanceof BaseFragmentActivity ? ((BaseFragmentActivity) currentActivity).getUniqueId() : null;
        }
        for (Map.Entry<String, d.a.n0.e0.e.a> entry : this.f53137c.entrySet()) {
            if (entry.getValue() != null) {
                entry.getValue().q(uniqueId);
                entry.getValue().p(this);
                entry.getValue().n();
            }
        }
    }

    public void h(JSONObject jSONObject) {
        this.f53135a = jSONObject.optLong("start_time");
        this.f53136b = jSONObject.optLong(ResultTB.ENDTIME);
        JSONObject optJSONObject = jSONObject.optJSONObject("feed");
        if (optJSONObject != null) {
            d.a.n0.e0.e.a aVar = new d.a.n0.e0.e.a();
            aVar.o(optJSONObject);
            this.f53137c.put("homePage", aVar);
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("forum");
        if (optJSONObject2 != null) {
            d.a.n0.e0.e.a aVar2 = new d.a.n0.e0.e.a();
            aVar2.o(optJSONObject2);
            this.f53137c.put("enterForum", aVar2);
        }
        JSONObject optJSONObject3 = jSONObject.optJSONObject("channel");
        if (optJSONObject3 != null) {
            d.a.n0.e0.e.a aVar3 = new d.a.n0.e0.e.a();
            aVar3.o(optJSONObject3);
            this.f53137c.put("channel", aVar3);
        }
        JSONObject optJSONObject4 = jSONObject.optJSONObject("news");
        if (optJSONObject4 != null) {
            d.a.n0.e0.e.a aVar4 = new d.a.n0.e0.e.a();
            aVar4.o(optJSONObject4);
            this.f53137c.put("message", aVar4);
        }
        JSONObject optJSONObject5 = jSONObject.optJSONObject(BaiduWalletServiceProviderMap.PLUGIN_PERSONAL);
        if (optJSONObject5 != null) {
            d.a.n0.e0.e.a aVar5 = new d.a.n0.e0.e.a();
            aVar5.o(optJSONObject5);
            this.f53137c.put("person", aVar5);
        }
    }
}

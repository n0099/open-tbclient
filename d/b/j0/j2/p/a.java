package d.b.j0.j2.p;

import android.content.Intent;
import android.net.Uri;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.play.cyberPlayer.CyberRemotePlayerService;
import com.baidu.tieba.setting.model.imageWatermarkType.SetImageWatermarkTypeReqMsg;
import d.b.c.e.m.e;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public boolean f58040a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f58041b;

    /* renamed from: c  reason: collision with root package name */
    public HashMap<String, Integer> f58042c;

    /* renamed from: d.b.j0.j2.p.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC1390a implements Runnable {
        public RunnableC1390a(a aVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
            TbadkCoreApplication.getInst().getContext().stopService(new Intent(TbadkCoreApplication.getInst().getContext(), CyberRemotePlayerService.class));
        }
    }

    public boolean a(Uri uri) {
        HashMap<String, Integer> hashMap = this.f58042c;
        if (hashMap == null || uri == null) {
            return false;
        }
        return hashMap.containsKey(uri.getHost());
    }

    public boolean b() {
        return this.f58041b;
    }

    public boolean c() {
        if (this.f58040a) {
            c.f();
        }
        return this.f58040a;
    }

    public void d(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        boolean z = this.f58040a;
        this.f58040a = jSONObject.optInt(SetImageWatermarkTypeReqMsg.SWITCH, 0) == 1;
        this.f58041b = jSONObject.optInt("p2p_config", 0) == 1;
        JSONArray optJSONArray = jSONObject.optJSONArray("domain_list");
        if (optJSONArray != null) {
            this.f58042c = new HashMap<>();
            for (int i = 0; i < optJSONArray.length(); i++) {
                String optString = optJSONArray.optString(i);
                if (!StringUtils.isNull(optString)) {
                    this.f58042c.put(optString, 0);
                }
            }
        }
        if (this.f58040a) {
            c.f();
            if (z) {
                return;
            }
            Intent intent = new Intent(TbadkCoreApplication.getInst().getContext(), CyberRemotePlayerService.class);
            intent.putExtra("pcdn", true);
            TbadkCoreApplication.getInst().getContext().startService(intent);
            e.a().postDelayed(new RunnableC1390a(this), 3000L);
        }
    }
}

package d.a.j0.j2.p;

import android.content.Intent;
import android.net.Uri;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.play.cyberPlayer.CyberRemotePlayerService;
import com.baidu.tieba.setting.model.imageWatermarkType.SetImageWatermarkTypeReqMsg;
import d.a.c.e.m.e;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public boolean f56020a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f56021b;

    /* renamed from: c  reason: collision with root package name */
    public HashMap<String, Integer> f56022c;

    /* renamed from: d.a.j0.j2.p.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class RunnableC1329a implements Runnable {
        public RunnableC1329a(a aVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
            TbadkCoreApplication.getInst().getContext().stopService(new Intent(TbadkCoreApplication.getInst().getContext(), CyberRemotePlayerService.class));
        }
    }

    public boolean a(Uri uri) {
        HashMap<String, Integer> hashMap = this.f56022c;
        if (hashMap == null || uri == null) {
            return false;
        }
        return hashMap.containsKey(uri.getHost());
    }

    public boolean b() {
        return this.f56021b;
    }

    public boolean c() {
        if (this.f56020a) {
            c.f();
        }
        return this.f56020a;
    }

    public void d(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        boolean z = this.f56020a;
        this.f56020a = jSONObject.optInt(SetImageWatermarkTypeReqMsg.SWITCH, 0) == 1;
        this.f56021b = jSONObject.optInt("p2p_config", 0) == 1;
        JSONArray optJSONArray = jSONObject.optJSONArray("domain_list");
        if (optJSONArray != null) {
            this.f56022c = new HashMap<>();
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                String optString = optJSONArray.optString(i2);
                if (!StringUtils.isNull(optString)) {
                    this.f56022c.put(optString, 0);
                }
            }
        }
        if (this.f56020a) {
            c.f();
            if (z) {
                return;
            }
            Intent intent = new Intent(TbadkCoreApplication.getInst().getContext(), CyberRemotePlayerService.class);
            intent.putExtra("pcdn", true);
            TbadkCoreApplication.getInst().getContext().startService(intent);
            e.a().postDelayed(new RunnableC1329a(this), 3000L);
        }
    }
}

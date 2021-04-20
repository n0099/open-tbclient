package d.b.i0.j2.p;

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
    public boolean f57619a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f57620b;

    /* renamed from: c  reason: collision with root package name */
    public HashMap<String, Integer> f57621c;

    /* renamed from: d.b.i0.j2.p.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC1367a implements Runnable {
        public RunnableC1367a(a aVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
            TbadkCoreApplication.getInst().getContext().stopService(new Intent(TbadkCoreApplication.getInst().getContext(), CyberRemotePlayerService.class));
        }
    }

    public boolean a(Uri uri) {
        HashMap<String, Integer> hashMap = this.f57621c;
        if (hashMap == null || uri == null) {
            return false;
        }
        return hashMap.containsKey(uri.getHost());
    }

    public boolean b() {
        return this.f57620b;
    }

    public boolean c() {
        if (this.f57619a) {
            c.f();
        }
        return this.f57619a;
    }

    public void d(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        boolean z = this.f57619a;
        this.f57619a = jSONObject.optInt(SetImageWatermarkTypeReqMsg.SWITCH, 0) == 1;
        this.f57620b = jSONObject.optInt("p2p_config", 0) == 1;
        JSONArray optJSONArray = jSONObject.optJSONArray("domain_list");
        if (optJSONArray != null) {
            this.f57621c = new HashMap<>();
            for (int i = 0; i < optJSONArray.length(); i++) {
                String optString = optJSONArray.optString(i);
                if (!StringUtils.isNull(optString)) {
                    this.f57621c.put(optString, 0);
                }
            }
        }
        if (this.f57619a) {
            c.f();
            if (z) {
                return;
            }
            Intent intent = new Intent(TbadkCoreApplication.getInst().getContext(), CyberRemotePlayerService.class);
            intent.putExtra("pcdn", true);
            TbadkCoreApplication.getInst().getContext().startService(intent);
            e.a().postDelayed(new RunnableC1367a(this), 3000L);
        }
    }
}

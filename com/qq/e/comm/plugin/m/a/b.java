package com.qq.e.comm.plugin.m.a;

import com.baidu.live.tbadk.core.util.TbEnum;
import com.qq.e.comm.plugin.ab.f.e;
import com.qq.e.comm.plugin.y.d;
import com.qq.e.comm.plugin.y.u;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b extends com.qq.e.comm.plugin.ab.f.a.b {
    @Override // com.qq.e.comm.plugin.ab.f.a.b
    public String a() {
        return "recordEvent";
    }

    @Override // com.qq.e.comm.plugin.ab.f.a.b
    public void a(e eVar, String str, String str2, String str3) {
        try {
            JSONObject jSONObject = new JSONObject(str2);
            int optInt = jSONObject.optInt(TbEnum.SystemMessage.KEY_EVENT_ID);
            int optInt2 = jSONObject.optInt("value");
            JSONObject optJSONObject = jSONObject.optJSONObject("ext");
            com.qq.e.comm.plugin.y.e b2 = new com.qq.e.comm.plugin.y.e(optInt).b(optInt2);
            b2.a(new d(optJSONObject));
            u.a(b2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}

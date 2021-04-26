package d.a.j0.q0.y1;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import com.alibaba.fastjson.asm.Label;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.mobads.container.bridge.BaiduAppJsBridgeHandler;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import d.a.c.e.p.j;
import d.a.i0.r.y.l;
import d.a.i0.r.y.n;
import d.a.i0.r.y.o;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a extends n {

    /* renamed from: c  reason: collision with root package name */
    public l f58956c;

    /* renamed from: d  reason: collision with root package name */
    public String f58957d;

    public a(l lVar, String str) {
        super(lVar);
        this.f58956c = lVar;
        this.f58957d = str;
    }

    @o(isAsync = false, value = "downloadGame")
    private void downloadGame(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("packageName");
        String optString2 = jSONObject.optString(BaiduAppJsBridgeHandler.INPUT_PARAM_DOWNLOAD_URL);
        String optString3 = jSONObject.optString("imageUrl");
        if (StringUtils.isNull(optString)) {
            return;
        }
        if (!j.z()) {
            UtilHelper.showToast(b(), R.string.neterror);
            return;
        }
        if (StringUtils.isNull(optString2)) {
            h(optString);
        } else {
            d.a.j0.s2.b0.e.n().E(optString, optString2, optString, 0, d.a.j0.s2.b0.e.o(optString).intValue(), null, true, false, true, optString3, null, null);
        }
        TiebaStatic.log(new StatisticItem("c12775").param("fid", StringUtils.isNull(this.f58957d) ? "" : this.f58957d));
    }

    @Override // d.a.i0.r.y.n
    public String g() {
        return "TBHY_COMMON_DOWNLOAD_GAME";
    }

    public final void h(String str) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + str));
        try {
            if (!(this.f58956c.f() instanceof Activity)) {
                intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
            }
            this.f58956c.f().startActivity(intent);
        } catch (ActivityNotFoundException e2) {
            BdLog.e(e2.getMessage());
        }
    }
}

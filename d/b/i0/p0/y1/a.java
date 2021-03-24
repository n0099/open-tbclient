package d.b.i0.p0.y1;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.swan.gamecenter.appmanager.install.InstallAntiBlockingActivity;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import d.b.b.e.p.j;
import d.b.h0.r.y.l;
import d.b.h0.r.y.n;
import d.b.h0.r.y.o;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a extends n {

    /* renamed from: c  reason: collision with root package name */
    public l f58750c;

    /* renamed from: d  reason: collision with root package name */
    public String f58751d;

    public a(l lVar, String str) {
        super(lVar);
        this.f58750c = lVar;
        this.f58751d = str;
    }

    @o(isAsync = false, value = "downloadGame")
    private void downloadGame(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString(InstallAntiBlockingActivity.PARAM_PACKAGE_NAME);
        String optString2 = jSONObject.optString("downloadUrl");
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
            d.b.i0.r2.x.e.n().E(optString, optString2, optString, 0, d.b.i0.r2.x.e.o(optString).intValue(), null, true, false, true, optString3, null, null);
        }
        TiebaStatic.log(new StatisticItem("c12775").param("fid", StringUtils.isNull(this.f58751d) ? "" : this.f58751d));
    }

    @Override // d.b.h0.r.y.n
    public String g() {
        return "TBHY_COMMON_DOWNLOAD_GAME";
    }

    public final void h(String str) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + str));
        try {
            if (!(this.f58750c.f() instanceof Activity)) {
                intent.addFlags(268435456);
            }
            this.f58750c.f().startActivity(intent);
        } catch (ActivityNotFoundException e2) {
            BdLog.e(e2.getMessage());
        }
    }
}

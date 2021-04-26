package d.a.h0.f.f.h;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.minivideo.plugin.capture.db.AuthoritySharedPreferences;
import com.baidu.swan.apps.favordata.SwanFavorItemData;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.wallet.paysdk.banksign.datamodel.QueryResponse;
import d.a.h0.a.z1.k.e;
import d.a.h0.a.z1.k.f;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b extends f {
    public String w;

    public static String l(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1903789791:
                if (str.equals("continueClick")) {
                    c2 = '\n';
                    break;
                }
                break;
            case -1263222921:
                if (str.equals("openApp")) {
                    c2 = 5;
                    break;
                }
                break;
            case -625158317:
                if (str.equals("deleteDownload")) {
                    c2 = 3;
                    break;
                }
                break;
            case -606050596:
                if (str.equals("resumeAllDownload")) {
                    c2 = 6;
                    break;
                }
                break;
            case -567202649:
                if (str.equals("continue")) {
                    c2 = '\b';
                    break;
                }
                break;
            case -451216226:
                if (str.equals("pauseDownload")) {
                    c2 = 1;
                    break;
                }
                break;
            case 66344735:
                if (str.equals("authorizeClick")) {
                    c2 = '\t';
                    break;
                }
                break;
            case 184711125:
                if (str.equals("resumeDownload")) {
                    c2 = 2;
                    break;
                }
                break;
            case 900412038:
                if (str.equals("installApp")) {
                    c2 = 4;
                    break;
                }
                break;
            case 1475610601:
                if (str.equals("authorize")) {
                    c2 = 7;
                    break;
                }
                break;
            case 1554935562:
                if (str.equals("startDownload")) {
                    c2 = 0;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                return IntentConfig.START;
            case 1:
                return "pause";
            case 2:
                return "resume";
            case 3:
                return QueryResponse.Options.CANCEL;
            case 4:
                return "install";
            case 5:
                return "open";
            case 6:
                return "continue";
            case 7:
                return "authorize";
            case '\b':
                return AuthoritySharedPreferences.KEY_CONFIG_FIRSTSHOT_GUIDE;
            case '\t':
                return "authorizeclick";
            case '\n':
                return "guideclick";
            default:
                return null;
        }
    }

    @Override // d.a.h0.a.z1.k.f, d.a.h0.a.z1.k.e
    public JSONObject f() {
        this.j = d.a.h0.a.b2.b.d(TextUtils.equals(this.f45411a, SwanFavorItemData.SCHEME_AUTHORITY_SWAN_GAME) ? 1 : 0);
        this.m = SwanAppNetworkUtils.f().type;
        if (this.f45417g == null) {
            this.f45417g = new JSONObject();
        }
        try {
            this.f45417g.put("host", d.a.h0.a.w0.a.k().f());
            this.f45417g.put("package", this.w);
        } catch (JSONException e2) {
            if (e.f45410i) {
                e2.printStackTrace();
            }
        }
        return super.f();
    }

    public void m(a aVar) {
        if (aVar == null) {
            return;
        }
        if (e.f45410i) {
            Log.d("SwanAppUBCEvent", "setCommonData: " + aVar.a());
        }
        this.f45411a = aVar.f46011a;
        this.f45415e = aVar.f46013c;
        this.f45413c = aVar.f46012b;
        this.n = aVar.f46016f;
        this.p = aVar.f46017g;
        this.q = aVar.f46018h;
        this.t = aVar.f46019i;
        this.v = aVar.j;
        this.k = aVar.f46014d;
        this.l = aVar.f46015e;
    }
}

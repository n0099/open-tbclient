package d.b.g0.s.i.a.b;

import androidx.annotation.NonNull;
import com.baidu.searchbox.player.ubc.VideoPlayerUbcConstants;
import com.baidu.swan.apps.favordata.SwanFavorItemData;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.webkit.sdk.plugin.ZeusPluginFactory;
import d.b.g0.a.y0.e.b;
import d.b.g0.n.e;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c extends a {
    public c(ZeusPluginFactory.Invoker invoker, String str) {
        super(invoker, str);
    }

    @Override // d.b.g0.a.s0.k.g.a
    public void O(String str) {
    }

    @Override // d.b.g0.s.i.a.b.a
    public void r0(int i, int i2, String str) {
        try {
            JSONObject x0 = x0();
            JSONObject y0 = y0();
            y0.put("errorNo", i);
            y0.put("sub_errorNo", i2);
            y0.put("errorInfo", str);
            x0.put("ext", y0.toString());
            e.l(VideoPlayerUbcConstants.UBC_VIDEO_PLAY_ERROR, x0);
        } catch (Exception e2) {
            if (a.v) {
                e2.printStackTrace();
            }
        }
    }

    @Override // d.b.g0.s.i.a.b.a
    public void s0() {
        try {
            JSONObject x0 = x0();
            x0.put("type", "first_frame");
            x0.put("ext", y0().toString());
            e.l(VideoPlayerUbcConstants.UBC_VIDEO_PLAY_SUCCESS, x0);
        } catch (Exception e2) {
            if (a.v) {
                e2.printStackTrace();
            }
        }
    }

    @NonNull
    public final JSONObject x0() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("from", "video");
            jSONObject.put("network", SwanAppNetworkUtils.e());
        } catch (Exception e2) {
            if (a.v) {
                e2.printStackTrace();
            }
        }
        return jSONObject;
    }

    @NonNull
    public final JSONObject y0() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ext_from", "aiapp");
            jSONObject.put("appid", d.b.g0.a.r1.e.T());
            jSONObject.put("url", this.f49360b);
            jSONObject.put(TiebaStatic.Params.VID, this.f49360b);
            jSONObject.put("isInline", true);
            String str = "";
            d.b.g0.a.r1.e y = d.b.g0.a.r1.e.y();
            if (y != null) {
                str = y.i0() ? SwanFavorItemData.SCHEME_AUTHORITY_SWAN_GAME : "swan";
                b.a L = y.L();
                if (L != null && L.l1() > 0) {
                    jSONObject.put("ext_start", L.l1());
                }
            }
            jSONObject.put("ext_page", str);
        } catch (Exception e2) {
            if (a.v) {
                e2.printStackTrace();
            }
        }
        return jSONObject;
    }
}

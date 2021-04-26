package d.a.h0.s.i.a.b;

import androidx.annotation.NonNull;
import com.baidu.searchbox.player.ubc.VideoPlayerUbcConstants;
import com.baidu.swan.apps.favordata.SwanFavorItemData;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.webkit.sdk.plugin.ZeusPluginFactory;
import d.a.h0.a.y0.e.b;
import d.a.h0.n.e;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c extends a {
    public c(ZeusPluginFactory.Invoker invoker, String str) {
        super(invoker, str);
    }

    @Override // d.a.h0.a.s0.k.g.a
    public void X(String str) {
    }

    @Override // d.a.h0.s.i.a.b.a
    public void s0(int i2, int i3, String str) {
        try {
            JSONObject y0 = y0();
            JSONObject z0 = z0();
            z0.put("errorNo", i2);
            z0.put("sub_errorNo", i3);
            z0.put("errorInfo", str);
            y0.put("ext", z0.toString());
            e.l(VideoPlayerUbcConstants.UBC_VIDEO_PLAY_ERROR, y0);
        } catch (Exception e2) {
            if (a.v) {
                e2.printStackTrace();
            }
        }
    }

    @Override // d.a.h0.s.i.a.b.a
    public void t0() {
        try {
            JSONObject y0 = y0();
            y0.put("type", "first_frame");
            y0.put("ext", z0().toString());
            e.l(VideoPlayerUbcConstants.UBC_VIDEO_PLAY_SUCCESS, y0);
        } catch (Exception e2) {
            if (a.v) {
                e2.printStackTrace();
            }
        }
    }

    @NonNull
    public final JSONObject y0() {
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
    public final JSONObject z0() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ext_from", "aiapp");
            jSONObject.put("appid", d.a.h0.a.r1.e.T());
            jSONObject.put("url", this.f47613b);
            jSONObject.put(TiebaStatic.Params.VID, this.f47613b);
            jSONObject.put("isInline", true);
            String str = "";
            d.a.h0.a.r1.e h2 = d.a.h0.a.r1.e.h();
            if (h2 != null) {
                str = h2.i0() ? SwanFavorItemData.SCHEME_AUTHORITY_SWAN_GAME : "swan";
                b.a L = h2.L();
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

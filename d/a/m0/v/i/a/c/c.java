package d.a.m0.v.i.a.c;

import androidx.annotation.NonNull;
import com.baidu.searchbox.player.ubc.VideoPlayerUbcConstants;
import com.baidu.swan.apps.favordata.SwanFavorItemData;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.webkit.sdk.plugin.ZeusPluginFactory;
import d.a.m0.a.f1.e.b;
import d.a.m0.r.e;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c extends a {
    public c(ZeusPluginFactory.Invoker invoker, String str) {
        super(invoker, str);
    }

    @Override // d.a.m0.v.i.a.c.a, d.a.m0.a.y0.k.g.a
    public void C() {
    }

    @Override // d.a.m0.v.i.a.c.a
    public void C0(int i2, int i3, String str) {
        try {
            JSONObject J0 = J0();
            JSONObject K0 = K0();
            K0.put("errorNo", i2);
            K0.put("sub_errorNo", i3);
            K0.put("errorInfo", str);
            J0.put("ext", K0.toString());
            e.m("36", J0);
        } catch (Exception e2) {
            if (a.x) {
                e2.printStackTrace();
            }
        }
    }

    @Override // d.a.m0.v.i.a.c.a
    public void D0() {
        try {
            JSONObject J0 = J0();
            J0.put("type", "first_frame");
            J0.put("ext", K0().toString());
            e.m(VideoPlayerUbcConstants.UBC_VIDEO_PLAY_SUCCESS, J0);
        } catch (Exception e2) {
            if (a.x) {
                e2.printStackTrace();
            }
        }
    }

    @Override // d.a.m0.v.i.a.c.a, d.a.m0.a.y0.k.g.a
    public void H() {
    }

    @NonNull
    public final JSONObject J0() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("from", "video");
            jSONObject.put("network", SwanAppNetworkUtils.e());
        } catch (Exception e2) {
            if (a.x) {
                e2.printStackTrace();
            }
        }
        return jSONObject;
    }

    @NonNull
    public final JSONObject K0() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ext_from", "aiapp");
            jSONObject.put("appid", d.a.m0.a.a2.e.V());
            jSONObject.put("url", this.f52300b);
            jSONObject.put(TiebaStatic.Params.VID, this.f52300b);
            jSONObject.put("isInline", true);
            String str = "";
            d.a.m0.a.a2.e i2 = d.a.m0.a.a2.e.i();
            if (i2 != null) {
                str = i2.m0() ? SwanFavorItemData.SCHEME_AUTHORITY_SWAN_GAME : "swan";
                b.a N = i2.N();
                if (N != null && N.s1() > 0) {
                    jSONObject.put("ext_start", N.s1());
                }
            }
            jSONObject.put("ext_page", str);
        } catch (Exception e2) {
            if (a.x) {
                e2.printStackTrace();
            }
        }
        return jSONObject;
    }

    @Override // d.a.m0.a.y0.k.g.a
    public void N(ZeusPluginFactory.Invoker invoker) {
    }

    @Override // d.a.m0.a.y0.k.g.a
    public void V() {
    }

    @Override // d.a.m0.a.y0.k.g.a
    public ZeusPluginFactory.Invoker g0() {
        return null;
    }

    @Override // d.a.m0.v.i.a.c.a, d.a.m0.a.y0.k.g.a
    public void n0() {
    }
}

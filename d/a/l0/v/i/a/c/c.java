package d.a.l0.v.i.a.c;

import androidx.annotation.NonNull;
import com.baidu.searchbox.player.ubc.VideoPlayerUbcConstants;
import com.baidu.swan.apps.favordata.SwanFavorItemData;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.webkit.sdk.plugin.ZeusPluginFactory;
import d.a.l0.a.f1.e.b;
import d.a.l0.r.e;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c extends a {
    public c(ZeusPluginFactory.Invoker invoker, String str) {
        super(invoker, str);
    }

    @Override // d.a.l0.v.i.a.c.a, d.a.l0.a.y0.k.g.a
    public void D() {
    }

    @Override // d.a.l0.v.i.a.c.a
    public void F0(int i2, int i3, String str) {
        try {
            JSONObject M0 = M0();
            JSONObject N0 = N0();
            N0.put("errorNo", i2);
            N0.put("sub_errorNo", i3);
            N0.put("errorInfo", str);
            M0.put("ext", N0.toString());
            e.m(VideoPlayerUbcConstants.UBC_VIDEO_PLAY_ERROR, M0);
        } catch (Exception e2) {
            if (a.x) {
                e2.printStackTrace();
            }
        }
    }

    @Override // d.a.l0.v.i.a.c.a
    public void G0() {
        try {
            JSONObject M0 = M0();
            M0.put("type", "first_frame");
            M0.put("ext", N0().toString());
            e.m(VideoPlayerUbcConstants.UBC_VIDEO_PLAY_SUCCESS, M0);
        } catch (Exception e2) {
            if (a.x) {
                e2.printStackTrace();
            }
        }
    }

    @Override // d.a.l0.v.i.a.c.a, d.a.l0.a.y0.k.g.a
    public void K() {
    }

    @NonNull
    public final JSONObject M0() {
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
    public final JSONObject N0() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ext_from", "aiapp");
            jSONObject.put("appid", d.a.l0.a.a2.e.V());
            jSONObject.put("url", this.f48518b);
            jSONObject.put(TiebaStatic.Params.VID, this.f48518b);
            jSONObject.put("isInline", true);
            String str = "";
            d.a.l0.a.a2.e i2 = d.a.l0.a.a2.e.i();
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

    @Override // d.a.l0.a.y0.k.g.a
    public void Q(ZeusPluginFactory.Invoker invoker) {
    }

    @Override // d.a.l0.a.y0.k.g.a
    public void Y() {
    }

    @Override // d.a.l0.a.y0.k.g.a
    public ZeusPluginFactory.Invoker j0() {
        return null;
    }

    @Override // d.a.l0.v.i.a.c.a, d.a.l0.a.y0.k.g.a
    public void q0() {
    }
}

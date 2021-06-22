package d.a.o0.t2;

import androidx.annotation.NonNull;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.App;
import tbclient.GoodsInfo;
/* loaded from: classes5.dex */
public class c {
    @NonNull
    public static String a(@NonNull App app) {
        List<GoodsInfo> list = app.goods_info;
        String str = "";
        if (list == null) {
            return "";
        }
        for (GoodsInfo goodsInfo : list) {
            if (goodsInfo != null) {
                try {
                    JSONObject optJSONObject = new JSONObject(goodsInfo.lego_card).optJSONObject("ad_common");
                    if (optJSONObject != null) {
                        str = optJSONObject.optString("id");
                    }
                    return str;
                } catch (JSONException unused) {
                }
            }
        }
        return str;
    }

    public static int b(@NonNull App app) {
        List<GoodsInfo> list = app.goods_info;
        if (list == null) {
            return -1;
        }
        Iterator<GoodsInfo> it = list.iterator();
        while (it.hasNext()) {
            GoodsInfo next = it.next();
            if (next != null) {
                try {
                    JSONObject optJSONObject = new JSONObject(next.lego_card).optJSONObject("ad_common");
                    if (optJSONObject != null) {
                        return d.a.c.e.m.b.d(optJSONObject.optString(IAdRequestParam.POS), -1);
                    }
                    return -1;
                } catch (JSONException unused) {
                }
            }
        }
        return -1;
    }

    public static void c(@NonNull App.Builder builder, int i2) {
        if (builder.goods_info == null) {
            return;
        }
        for (int i3 = 0; i3 < builder.goods_info.size(); i3++) {
            GoodsInfo goodsInfo = (GoodsInfo) d.a.o0.k1.o.k.a.d(builder.goods_info, i3);
            if (goodsInfo != null) {
                try {
                    JSONObject jSONObject = new JSONObject(goodsInfo.lego_card);
                    JSONObject optJSONObject = jSONObject.optJSONObject("ad_common");
                    if (optJSONObject != null) {
                        optJSONObject.put(IAdRequestParam.POS, String.valueOf(d.a.c.e.m.b.d(optJSONObject.optString(IAdRequestParam.POS), 0) + i2));
                        GoodsInfo.Builder builder2 = new GoodsInfo.Builder(goodsInfo);
                        builder2.lego_card = jSONObject.toString();
                        builder.goods_info.set(i3, builder2.build(false));
                    }
                } catch (JSONException unused) {
                }
            }
        }
    }
}

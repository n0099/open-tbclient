package d.b.i0.v3.m;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.MetaData;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<MetaData> f63386a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, String> f63387b = null;

    public ArrayList<MetaData> a() {
        return this.f63386a;
    }

    public void b(String str) {
        try {
            c(new JSONObject(str), true);
        } catch (Exception e2) {
            BdLog.detailException(e2);
        }
    }

    public void c(JSONObject jSONObject, boolean z) {
        if (jSONObject == null) {
            return;
        }
        if (z) {
            try {
                if (this.f63387b == null) {
                    this.f63387b = new HashMap<>();
                }
            } catch (Exception e2) {
                BdLog.detailException(e2);
                return;
            }
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("user_list");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                MetaData metaData = new MetaData();
                metaData.parserJson(optJSONArray.getJSONObject(i));
                if (!TextUtils.isEmpty(metaData.getName_show())) {
                    this.f63386a.add(metaData);
                    if (z) {
                        this.f63387b.put(metaData.getName_show(), metaData.getPortrait());
                    }
                }
            }
        }
    }
}

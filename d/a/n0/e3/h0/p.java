package d.a.n0.e3.h0;

import androidx.core.app.NotificationCompat;
import com.baidu.tbadk.core.data.AbstractData;
import com.baidu.tbadk.data.MetaData;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class p {

    /* renamed from: a  reason: collision with root package name */
    public String f57722a;

    /* renamed from: b  reason: collision with root package name */
    public MetaData f57723b;

    /* renamed from: c  reason: collision with root package name */
    public List<AbstractData> f57724c = new ArrayList();

    public void a(JSONObject jSONObject) {
        try {
            this.f57722a = jSONObject.optString("id");
            MetaData metaData = new MetaData();
            this.f57723b = metaData;
            metaData.parserJson(jSONObject.optJSONObject(NotificationCompat.CarExtender.KEY_AUTHOR));
            JSONArray optJSONArray = jSONObject.optJSONArray("abstract");
            this.f57724c = new ArrayList();
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    AbstractData abstractData = new AbstractData();
                    abstractData.parserJson(optJSONArray.getJSONObject(i2));
                    this.f57724c.add(abstractData);
                }
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }
}

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
    public String f54033a;

    /* renamed from: b  reason: collision with root package name */
    public MetaData f54034b;

    /* renamed from: c  reason: collision with root package name */
    public List<AbstractData> f54035c = new ArrayList();

    public void a(JSONObject jSONObject) {
        try {
            this.f54033a = jSONObject.optString("id");
            MetaData metaData = new MetaData();
            this.f54034b = metaData;
            metaData.parserJson(jSONObject.optJSONObject(NotificationCompat.CarExtender.KEY_AUTHOR));
            JSONArray optJSONArray = jSONObject.optJSONArray("abstract");
            this.f54035c = new ArrayList();
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    AbstractData abstractData = new AbstractData();
                    abstractData.parserJson(optJSONArray.getJSONObject(i2));
                    this.f54035c.add(abstractData);
                }
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }
}

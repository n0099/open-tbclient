package d.b.i0.c3.h0;

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
    public String f53410a;

    /* renamed from: b  reason: collision with root package name */
    public MetaData f53411b;

    /* renamed from: c  reason: collision with root package name */
    public List<AbstractData> f53412c = new ArrayList();

    public void a(JSONObject jSONObject) {
        try {
            this.f53410a = jSONObject.optString("id");
            MetaData metaData = new MetaData();
            this.f53411b = metaData;
            metaData.parserJson(jSONObject.optJSONObject(NotificationCompat.CarExtender.KEY_AUTHOR));
            JSONArray optJSONArray = jSONObject.optJSONArray("abstract");
            this.f53412c = new ArrayList();
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                for (int i = 0; i < length; i++) {
                    AbstractData abstractData = new AbstractData();
                    abstractData.parserJson(optJSONArray.getJSONObject(i));
                    this.f53412c.add(abstractData);
                }
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }
}

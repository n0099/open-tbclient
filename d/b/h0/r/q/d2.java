package d.b.h0.r.q;

import androidx.core.app.NotificationCompat;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.FrsPage.TopNotice;
/* loaded from: classes3.dex */
public class d2 {

    /* renamed from: a  reason: collision with root package name */
    public String f51167a = null;

    /* renamed from: b  reason: collision with root package name */
    public String f51168b = null;

    public String a() {
        return this.f51167a;
    }

    public String b() {
        return this.f51168b;
    }

    public void c(JSONObject jSONObject) {
        try {
            this.f51167a = jSONObject.getString("title");
            this.f51168b = jSONObject.getString("title_link");
            jSONObject.getString(NotificationCompat.CarExtender.KEY_AUTHOR);
            jSONObject.getInt("id");
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public void d(TopNotice topNotice) {
        if (topNotice == null) {
            return;
        }
        this.f51167a = topNotice.title;
        this.f51168b = topNotice.title_link;
        String str = topNotice.author;
        topNotice.id.intValue();
    }
}

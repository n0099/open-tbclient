package d.a.j0.r.q;

import androidx.core.app.NotificationCompat;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.FrsPage.TopNotice;
/* loaded from: classes3.dex */
public class d2 {

    /* renamed from: a  reason: collision with root package name */
    public String f49947a = null;

    /* renamed from: b  reason: collision with root package name */
    public String f49948b = null;

    public String a() {
        return this.f49947a;
    }

    public String b() {
        return this.f49948b;
    }

    public void c(JSONObject jSONObject) {
        try {
            this.f49947a = jSONObject.getString("title");
            this.f49948b = jSONObject.getString("title_link");
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
        this.f49947a = topNotice.title;
        this.f49948b = topNotice.title_link;
        String str = topNotice.author;
        topNotice.id.intValue();
    }
}

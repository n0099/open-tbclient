package d.a.n0.e3.o0.d;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<Integer> f54160a;

    /* renamed from: b  reason: collision with root package name */
    public String f54161b;

    /* renamed from: c  reason: collision with root package name */
    public String f54162c;

    /* renamed from: d  reason: collision with root package name */
    public String f54163d;

    /* renamed from: e  reason: collision with root package name */
    public int f54164e;

    public void a(String str) {
        if (StringUtils.isNull(str)) {
            return;
        }
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("data");
            if (optJSONObject != null) {
                JSONArray optJSONArray = optJSONObject.optJSONArray("chunk_nolist");
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    this.f54160a = new ArrayList<>();
                    for (int i2 = 0; i2 < length; i2++) {
                        this.f54160a.add(Integer.valueOf(optJSONArray.getInt(i2)));
                    }
                }
                this.f54161b = optJSONObject.optString("upload_id");
                this.f54162c = optJSONObject.optString("video_url");
            }
        } catch (JSONException unused) {
        }
    }
}

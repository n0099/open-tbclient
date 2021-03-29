package d.b.i0.c3.o0.d;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<Integer> f53534a;

    /* renamed from: b  reason: collision with root package name */
    public String f53535b;

    /* renamed from: c  reason: collision with root package name */
    public String f53536c;

    /* renamed from: d  reason: collision with root package name */
    public String f53537d;

    /* renamed from: e  reason: collision with root package name */
    public int f53538e;

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
                    this.f53534a = new ArrayList<>();
                    for (int i = 0; i < length; i++) {
                        this.f53534a.add(Integer.valueOf(optJSONArray.getInt(i)));
                    }
                }
                this.f53535b = optJSONObject.optString("upload_id");
                this.f53536c = optJSONObject.optString("video_url");
            }
        } catch (JSONException unused) {
        }
    }
}

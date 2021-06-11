package d.a.n0.e3.o0.d;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<Integer> f57849a;

    /* renamed from: b  reason: collision with root package name */
    public String f57850b;

    /* renamed from: c  reason: collision with root package name */
    public String f57851c;

    /* renamed from: d  reason: collision with root package name */
    public String f57852d;

    /* renamed from: e  reason: collision with root package name */
    public int f57853e;

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
                    this.f57849a = new ArrayList<>();
                    for (int i2 = 0; i2 < length; i2++) {
                        this.f57849a.add(Integer.valueOf(optJSONArray.getInt(i2)));
                    }
                }
                this.f57850b = optJSONObject.optString("upload_id");
                this.f57851c = optJSONObject.optString("video_url");
            }
        } catch (JSONException unused) {
        }
    }
}

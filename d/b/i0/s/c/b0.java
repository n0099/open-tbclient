package d.b.i0.s.c;

import com.baidu.tbadk.TbConfig;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b0 {

    /* renamed from: a  reason: collision with root package name */
    public boolean f51883a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f51884b;

    /* renamed from: c  reason: collision with root package name */
    public int f51885c;

    /* renamed from: d  reason: collision with root package name */
    public int f51886d;

    /* renamed from: e  reason: collision with root package name */
    public String f51887e;

    /* renamed from: f  reason: collision with root package name */
    public String f51888f;

    /* renamed from: g  reason: collision with root package name */
    public String f51889g;

    /* renamed from: h  reason: collision with root package name */
    public int f51890h;
    public String i;

    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f51883a = jSONObject.optInt("isShowDownloadNaniPanel", 2) == 1;
        this.f51884b = jSONObject.optInt("isActivateNaniApp", 1) == 1;
        this.f51885c = jSONObject.optInt("downloadNaniShowPosition", 3);
        this.f51886d = jSONObject.optInt("downloadNaniShowRate", 2);
        this.f51887e = jSONObject.optString("downloadNaniLinkUrl", null);
        this.f51888f = jSONObject.optString("downloadNaniTxt", null);
        this.f51889g = jSONObject.optString("showNaniTailTxt", null);
        this.f51890h = jSONObject.optInt("showNaniTailVideoType", 0);
        this.i = jSONObject.optString("preNaniShareUrl", TbConfig.NANI_DEFAULT_H5_PREFIX);
    }
}

package d.a.i0.s.c;

import com.baidu.tbadk.TbConfig;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b0 {

    /* renamed from: a  reason: collision with root package name */
    public boolean f49534a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f49535b;

    /* renamed from: c  reason: collision with root package name */
    public int f49536c;

    /* renamed from: d  reason: collision with root package name */
    public int f49537d;

    /* renamed from: e  reason: collision with root package name */
    public String f49538e;

    /* renamed from: f  reason: collision with root package name */
    public String f49539f;

    /* renamed from: g  reason: collision with root package name */
    public String f49540g;

    /* renamed from: h  reason: collision with root package name */
    public int f49541h;

    /* renamed from: i  reason: collision with root package name */
    public String f49542i;

    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f49534a = jSONObject.optInt("isShowDownloadNaniPanel", 2) == 1;
        this.f49535b = jSONObject.optInt("isActivateNaniApp", 1) == 1;
        this.f49536c = jSONObject.optInt("downloadNaniShowPosition", 3);
        this.f49537d = jSONObject.optInt("downloadNaniShowRate", 2);
        this.f49538e = jSONObject.optString("downloadNaniLinkUrl", null);
        this.f49539f = jSONObject.optString("downloadNaniTxt", null);
        this.f49540g = jSONObject.optString("showNaniTailTxt", null);
        this.f49541h = jSONObject.optInt("showNaniTailVideoType", 0);
        this.f49542i = jSONObject.optString("preNaniShareUrl", TbConfig.NANI_DEFAULT_H5_PREFIX);
    }
}

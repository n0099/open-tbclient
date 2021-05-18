package d.a.j0.s.c;

import com.baidu.tbadk.TbConfig;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b0 {

    /* renamed from: a  reason: collision with root package name */
    public boolean f50353a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f50354b;

    /* renamed from: c  reason: collision with root package name */
    public int f50355c;

    /* renamed from: d  reason: collision with root package name */
    public int f50356d;

    /* renamed from: e  reason: collision with root package name */
    public String f50357e;

    /* renamed from: f  reason: collision with root package name */
    public String f50358f;

    /* renamed from: g  reason: collision with root package name */
    public String f50359g;

    /* renamed from: h  reason: collision with root package name */
    public int f50360h;

    /* renamed from: i  reason: collision with root package name */
    public String f50361i;

    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f50353a = jSONObject.optInt("isShowDownloadNaniPanel", 2) == 1;
        this.f50354b = jSONObject.optInt("isActivateNaniApp", 1) == 1;
        this.f50355c = jSONObject.optInt("downloadNaniShowPosition", 3);
        this.f50356d = jSONObject.optInt("downloadNaniShowRate", 2);
        this.f50357e = jSONObject.optString("downloadNaniLinkUrl", null);
        this.f50358f = jSONObject.optString("downloadNaniTxt", null);
        this.f50359g = jSONObject.optString("showNaniTailTxt", null);
        this.f50360h = jSONObject.optInt("showNaniTailVideoType", 0);
        this.f50361i = jSONObject.optString("preNaniShareUrl", TbConfig.NANI_DEFAULT_H5_PREFIX);
    }
}

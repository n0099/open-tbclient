package d.a.m0.s.c;

import com.baidu.tbadk.TbConfig;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c0 {

    /* renamed from: a  reason: collision with root package name */
    public boolean f54097a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f54098b;

    /* renamed from: c  reason: collision with root package name */
    public int f54099c;

    /* renamed from: d  reason: collision with root package name */
    public int f54100d;

    /* renamed from: e  reason: collision with root package name */
    public String f54101e;

    /* renamed from: f  reason: collision with root package name */
    public String f54102f;

    /* renamed from: g  reason: collision with root package name */
    public String f54103g;

    /* renamed from: h  reason: collision with root package name */
    public int f54104h;

    /* renamed from: i  reason: collision with root package name */
    public String f54105i;

    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f54097a = jSONObject.optInt("isShowDownloadNaniPanel", 2) == 1;
        this.f54098b = jSONObject.optInt("isActivateNaniApp", 1) == 1;
        this.f54099c = jSONObject.optInt("downloadNaniShowPosition", 3);
        this.f54100d = jSONObject.optInt("downloadNaniShowRate", 2);
        this.f54101e = jSONObject.optString("downloadNaniLinkUrl", null);
        this.f54102f = jSONObject.optString("downloadNaniTxt", null);
        this.f54103g = jSONObject.optString("showNaniTailTxt", null);
        this.f54104h = jSONObject.optInt("showNaniTailVideoType", 0);
        this.f54105i = jSONObject.optString("preNaniShareUrl", TbConfig.NANI_DEFAULT_H5_PREFIX);
    }
}

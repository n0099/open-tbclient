package d.b.h0.s.c;

import com.baidu.tbadk.TbConfig;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class z {

    /* renamed from: a  reason: collision with root package name */
    public boolean f51243a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f51244b;

    /* renamed from: c  reason: collision with root package name */
    public int f51245c;

    /* renamed from: d  reason: collision with root package name */
    public int f51246d;

    /* renamed from: e  reason: collision with root package name */
    public String f51247e;

    /* renamed from: f  reason: collision with root package name */
    public String f51248f;

    /* renamed from: g  reason: collision with root package name */
    public String f51249g;

    /* renamed from: h  reason: collision with root package name */
    public int f51250h;
    public String i;

    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f51243a = jSONObject.optInt("isShowDownloadNaniPanel", 2) == 1;
        this.f51244b = jSONObject.optInt("isActivateNaniApp", 1) == 1;
        this.f51245c = jSONObject.optInt("downloadNaniShowPosition", 3);
        this.f51246d = jSONObject.optInt("downloadNaniShowRate", 2);
        this.f51247e = jSONObject.optString("downloadNaniLinkUrl", null);
        this.f51248f = jSONObject.optString("downloadNaniTxt", null);
        this.f51249g = jSONObject.optString("showNaniTailTxt", null);
        this.f51250h = jSONObject.optInt("showNaniTailVideoType", 0);
        this.i = jSONObject.optString("preNaniShareUrl", TbConfig.NANI_DEFAULT_H5_PREFIX);
    }
}

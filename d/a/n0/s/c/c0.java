package d.a.n0.s.c;

import com.baidu.tbadk.TbConfig;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c0 {

    /* renamed from: a  reason: collision with root package name */
    public boolean f54204a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f54205b;

    /* renamed from: c  reason: collision with root package name */
    public int f54206c;

    /* renamed from: d  reason: collision with root package name */
    public int f54207d;

    /* renamed from: e  reason: collision with root package name */
    public String f54208e;

    /* renamed from: f  reason: collision with root package name */
    public String f54209f;

    /* renamed from: g  reason: collision with root package name */
    public String f54210g;

    /* renamed from: h  reason: collision with root package name */
    public int f54211h;

    /* renamed from: i  reason: collision with root package name */
    public String f54212i;

    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f54204a = jSONObject.optInt("isShowDownloadNaniPanel", 2) == 1;
        this.f54205b = jSONObject.optInt("isActivateNaniApp", 1) == 1;
        this.f54206c = jSONObject.optInt("downloadNaniShowPosition", 3);
        this.f54207d = jSONObject.optInt("downloadNaniShowRate", 2);
        this.f54208e = jSONObject.optString("downloadNaniLinkUrl", null);
        this.f54209f = jSONObject.optString("downloadNaniTxt", null);
        this.f54210g = jSONObject.optString("showNaniTailTxt", null);
        this.f54211h = jSONObject.optInt("showNaniTailVideoType", 0);
        this.f54212i = jSONObject.optString("preNaniShareUrl", TbConfig.NANI_DEFAULT_H5_PREFIX);
    }
}

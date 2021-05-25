package d.a.m0.s.c;

import com.baidu.tbadk.TbConfig;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c0 {

    /* renamed from: a  reason: collision with root package name */
    public boolean f50421a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f50422b;

    /* renamed from: c  reason: collision with root package name */
    public int f50423c;

    /* renamed from: d  reason: collision with root package name */
    public int f50424d;

    /* renamed from: e  reason: collision with root package name */
    public String f50425e;

    /* renamed from: f  reason: collision with root package name */
    public String f50426f;

    /* renamed from: g  reason: collision with root package name */
    public String f50427g;

    /* renamed from: h  reason: collision with root package name */
    public int f50428h;

    /* renamed from: i  reason: collision with root package name */
    public String f50429i;

    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f50421a = jSONObject.optInt("isShowDownloadNaniPanel", 2) == 1;
        this.f50422b = jSONObject.optInt("isActivateNaniApp", 1) == 1;
        this.f50423c = jSONObject.optInt("downloadNaniShowPosition", 3);
        this.f50424d = jSONObject.optInt("downloadNaniShowRate", 2);
        this.f50425e = jSONObject.optString("downloadNaniLinkUrl", null);
        this.f50426f = jSONObject.optString("downloadNaniTxt", null);
        this.f50427g = jSONObject.optString("showNaniTailTxt", null);
        this.f50428h = jSONObject.optInt("showNaniTailVideoType", 0);
        this.f50429i = jSONObject.optString("preNaniShareUrl", TbConfig.NANI_DEFAULT_H5_PREFIX);
    }
}

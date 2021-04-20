package d.b.h0.s.c;

import com.baidu.tbadk.TbConfig;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b0 {

    /* renamed from: a  reason: collision with root package name */
    public boolean f51547a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f51548b;

    /* renamed from: c  reason: collision with root package name */
    public int f51549c;

    /* renamed from: d  reason: collision with root package name */
    public int f51550d;

    /* renamed from: e  reason: collision with root package name */
    public String f51551e;

    /* renamed from: f  reason: collision with root package name */
    public String f51552f;

    /* renamed from: g  reason: collision with root package name */
    public String f51553g;

    /* renamed from: h  reason: collision with root package name */
    public int f51554h;
    public String i;

    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f51547a = jSONObject.optInt("isShowDownloadNaniPanel", 2) == 1;
        this.f51548b = jSONObject.optInt("isActivateNaniApp", 1) == 1;
        this.f51549c = jSONObject.optInt("downloadNaniShowPosition", 3);
        this.f51550d = jSONObject.optInt("downloadNaniShowRate", 2);
        this.f51551e = jSONObject.optString("downloadNaniLinkUrl", null);
        this.f51552f = jSONObject.optString("downloadNaniTxt", null);
        this.f51553g = jSONObject.optString("showNaniTailTxt", null);
        this.f51554h = jSONObject.optInt("showNaniTailVideoType", 0);
        this.i = jSONObject.optString("preNaniShareUrl", TbConfig.NANI_DEFAULT_H5_PREFIX);
    }
}

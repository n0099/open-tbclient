package d.b.i0.s.c;

import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class e0 {

    /* renamed from: f  reason: collision with root package name */
    public static final Map<ShareDialogConfig.From, Integer> f51907f;

    /* renamed from: a  reason: collision with root package name */
    public int f51908a;

    /* renamed from: b  reason: collision with root package name */
    public int f51909b;

    /* renamed from: c  reason: collision with root package name */
    public String f51910c;

    /* renamed from: d  reason: collision with root package name */
    public int f51911d;

    /* renamed from: e  reason: collision with root package name */
    public List<Integer> f51912e;

    static {
        HashMap hashMap = new HashMap();
        f51907f = hashMap;
        hashMap.put(ShareDialogConfig.From.Recommend, 1);
        f51907f.put(ShareDialogConfig.From.Concern, 2);
        f51907f.put(ShareDialogConfig.From.PB, 3);
        f51907f.put(ShareDialogConfig.From.FRS, 4);
        f51907f.put(ShareDialogConfig.From.PersonPolymeric, 5);
        f51907f.put(ShareDialogConfig.From.VideoMiddlePageHorizontal, 6);
        f51907f.put(ShareDialogConfig.From.VideoMiddlePageVertical, 7);
        f51907f.put(ShareDialogConfig.From.HomeVideoTab, 8);
        f51907f.put(ShareDialogConfig.From.HomeGameTab, 9);
    }

    public int a() {
        return this.f51911d;
    }

    public String b() {
        return this.f51910c;
    }

    public boolean c() {
        return System.currentTimeMillis() / 1000 >= ((long) this.f51908a) && System.currentTimeMillis() / 1000 <= ((long) this.f51909b);
    }

    public boolean d(ShareDialogConfig.From from) {
        Integer num;
        return (this.f51912e == null || (num = f51907f.get(from)) == null || !this.f51912e.contains(num)) ? false : true;
    }

    public void e(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f51908a = jSONObject.optInt("begin_time");
        this.f51909b = jSONObject.optInt("end_time");
        this.f51910c = jSONObject.optString("text");
        this.f51911d = jSONObject.optInt("icon_exp");
        f(jSONObject.optString("page_list"));
    }

    public final void f(String str) {
        String[] split;
        if (d.b.c.e.p.k.isEmpty(str) || (split = str.split(",")) == null) {
            return;
        }
        for (String str2 : split) {
            int d2 = d.b.c.e.m.b.d(str2, -1);
            if (d2 != -1) {
                if (this.f51912e == null) {
                    this.f51912e = new ArrayList();
                }
                this.f51912e.add(Integer.valueOf(d2));
            }
        }
    }
}

package d.a.m0.s.c;

import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class f0 {

    /* renamed from: f  reason: collision with root package name */
    public static final Map<ShareDialogConfig.From, Integer> f50450f;

    /* renamed from: a  reason: collision with root package name */
    public int f50451a;

    /* renamed from: b  reason: collision with root package name */
    public int f50452b;

    /* renamed from: c  reason: collision with root package name */
    public String f50453c;

    /* renamed from: d  reason: collision with root package name */
    public int f50454d;

    /* renamed from: e  reason: collision with root package name */
    public List<Integer> f50455e;

    static {
        HashMap hashMap = new HashMap();
        f50450f = hashMap;
        hashMap.put(ShareDialogConfig.From.Recommend, 1);
        f50450f.put(ShareDialogConfig.From.Concern, 2);
        f50450f.put(ShareDialogConfig.From.PB, 3);
        f50450f.put(ShareDialogConfig.From.FRS, 4);
        f50450f.put(ShareDialogConfig.From.PersonPolymeric, 5);
        f50450f.put(ShareDialogConfig.From.VideoMiddlePageHorizontal, 6);
        f50450f.put(ShareDialogConfig.From.VideoMiddlePageVertical, 7);
        f50450f.put(ShareDialogConfig.From.HomeVideoTab, 8);
        f50450f.put(ShareDialogConfig.From.HomeGameTab, 9);
    }

    public int a() {
        return this.f50454d;
    }

    public String b() {
        return this.f50453c;
    }

    public boolean c() {
        return System.currentTimeMillis() / 1000 >= ((long) this.f50451a) && System.currentTimeMillis() / 1000 <= ((long) this.f50452b);
    }

    public boolean d(ShareDialogConfig.From from) {
        Integer num;
        return (this.f50455e == null || (num = f50450f.get(from)) == null || !this.f50455e.contains(num)) ? false : true;
    }

    public void e(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f50451a = jSONObject.optInt("begin_time");
        this.f50452b = jSONObject.optInt("end_time");
        this.f50453c = jSONObject.optString("text");
        this.f50454d = jSONObject.optInt("icon_exp");
        f(jSONObject.optString("page_list"));
    }

    public final void f(String str) {
        String[] split;
        if (d.a.c.e.p.k.isEmpty(str) || (split = str.split(",")) == null) {
            return;
        }
        for (String str2 : split) {
            int d2 = d.a.c.e.m.b.d(str2, -1);
            if (d2 != -1) {
                if (this.f50455e == null) {
                    this.f50455e = new ArrayList();
                }
                this.f50455e.add(Integer.valueOf(d2));
            }
        }
    }
}

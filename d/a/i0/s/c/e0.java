package d.a.i0.s.c;

import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class e0 {

    /* renamed from: f  reason: collision with root package name */
    public static final Map<ShareDialogConfig.From, Integer> f49560f;

    /* renamed from: a  reason: collision with root package name */
    public int f49561a;

    /* renamed from: b  reason: collision with root package name */
    public int f49562b;

    /* renamed from: c  reason: collision with root package name */
    public String f49563c;

    /* renamed from: d  reason: collision with root package name */
    public int f49564d;

    /* renamed from: e  reason: collision with root package name */
    public List<Integer> f49565e;

    static {
        HashMap hashMap = new HashMap();
        f49560f = hashMap;
        hashMap.put(ShareDialogConfig.From.Recommend, 1);
        f49560f.put(ShareDialogConfig.From.Concern, 2);
        f49560f.put(ShareDialogConfig.From.PB, 3);
        f49560f.put(ShareDialogConfig.From.FRS, 4);
        f49560f.put(ShareDialogConfig.From.PersonPolymeric, 5);
        f49560f.put(ShareDialogConfig.From.VideoMiddlePageHorizontal, 6);
        f49560f.put(ShareDialogConfig.From.VideoMiddlePageVertical, 7);
        f49560f.put(ShareDialogConfig.From.HomeVideoTab, 8);
        f49560f.put(ShareDialogConfig.From.HomeGameTab, 9);
    }

    public int a() {
        return this.f49564d;
    }

    public String b() {
        return this.f49563c;
    }

    public boolean c() {
        return System.currentTimeMillis() / 1000 >= ((long) this.f49561a) && System.currentTimeMillis() / 1000 <= ((long) this.f49562b);
    }

    public boolean d(ShareDialogConfig.From from) {
        Integer num;
        return (this.f49565e == null || (num = f49560f.get(from)) == null || !this.f49565e.contains(num)) ? false : true;
    }

    public void e(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f49561a = jSONObject.optInt("begin_time");
        this.f49562b = jSONObject.optInt("end_time");
        this.f49563c = jSONObject.optString("text");
        this.f49564d = jSONObject.optInt("icon_exp");
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
                if (this.f49565e == null) {
                    this.f49565e = new ArrayList();
                }
                this.f49565e.add(Integer.valueOf(d2));
            }
        }
    }
}

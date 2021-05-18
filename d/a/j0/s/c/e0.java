package d.a.j0.s.c;

import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class e0 {

    /* renamed from: f  reason: collision with root package name */
    public static final Map<ShareDialogConfig.From, Integer> f50379f;

    /* renamed from: a  reason: collision with root package name */
    public int f50380a;

    /* renamed from: b  reason: collision with root package name */
    public int f50381b;

    /* renamed from: c  reason: collision with root package name */
    public String f50382c;

    /* renamed from: d  reason: collision with root package name */
    public int f50383d;

    /* renamed from: e  reason: collision with root package name */
    public List<Integer> f50384e;

    static {
        HashMap hashMap = new HashMap();
        f50379f = hashMap;
        hashMap.put(ShareDialogConfig.From.Recommend, 1);
        f50379f.put(ShareDialogConfig.From.Concern, 2);
        f50379f.put(ShareDialogConfig.From.PB, 3);
        f50379f.put(ShareDialogConfig.From.FRS, 4);
        f50379f.put(ShareDialogConfig.From.PersonPolymeric, 5);
        f50379f.put(ShareDialogConfig.From.VideoMiddlePageHorizontal, 6);
        f50379f.put(ShareDialogConfig.From.VideoMiddlePageVertical, 7);
        f50379f.put(ShareDialogConfig.From.HomeVideoTab, 8);
        f50379f.put(ShareDialogConfig.From.HomeGameTab, 9);
    }

    public int a() {
        return this.f50383d;
    }

    public String b() {
        return this.f50382c;
    }

    public boolean c() {
        return System.currentTimeMillis() / 1000 >= ((long) this.f50380a) && System.currentTimeMillis() / 1000 <= ((long) this.f50381b);
    }

    public boolean d(ShareDialogConfig.From from) {
        Integer num;
        return (this.f50384e == null || (num = f50379f.get(from)) == null || !this.f50384e.contains(num)) ? false : true;
    }

    public void e(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f50380a = jSONObject.optInt("begin_time");
        this.f50381b = jSONObject.optInt("end_time");
        this.f50382c = jSONObject.optString("text");
        this.f50383d = jSONObject.optInt("icon_exp");
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
                if (this.f50384e == null) {
                    this.f50384e = new ArrayList();
                }
                this.f50384e.add(Integer.valueOf(d2));
            }
        }
    }
}

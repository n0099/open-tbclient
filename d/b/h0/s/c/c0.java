package d.b.h0.s.c;

import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c0 {

    /* renamed from: f  reason: collision with root package name */
    public static final Map<ShareDialogConfig.From, Integer> f51143f;

    /* renamed from: a  reason: collision with root package name */
    public int f51144a;

    /* renamed from: b  reason: collision with root package name */
    public int f51145b;

    /* renamed from: c  reason: collision with root package name */
    public String f51146c;

    /* renamed from: d  reason: collision with root package name */
    public int f51147d;

    /* renamed from: e  reason: collision with root package name */
    public List<Integer> f51148e;

    static {
        HashMap hashMap = new HashMap();
        f51143f = hashMap;
        hashMap.put(ShareDialogConfig.From.Recommend, 1);
        f51143f.put(ShareDialogConfig.From.Concern, 2);
        f51143f.put(ShareDialogConfig.From.PB, 3);
        f51143f.put(ShareDialogConfig.From.FRS, 4);
        f51143f.put(ShareDialogConfig.From.PersonPolymeric, 5);
        f51143f.put(ShareDialogConfig.From.VideoMiddlePageHorizontal, 6);
        f51143f.put(ShareDialogConfig.From.VideoMiddlePageVertical, 7);
        f51143f.put(ShareDialogConfig.From.HomeVideoTab, 8);
        f51143f.put(ShareDialogConfig.From.HomeGameTab, 9);
    }

    public int a() {
        return this.f51147d;
    }

    public String b() {
        return this.f51146c;
    }

    public boolean c() {
        return System.currentTimeMillis() / 1000 >= ((long) this.f51144a) && System.currentTimeMillis() / 1000 <= ((long) this.f51145b);
    }

    public boolean d(ShareDialogConfig.From from) {
        Integer num;
        return (this.f51148e == null || (num = f51143f.get(from)) == null || !this.f51148e.contains(num)) ? false : true;
    }

    public void e(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f51144a = jSONObject.optInt("begin_time");
        this.f51145b = jSONObject.optInt("end_time");
        this.f51146c = jSONObject.optString("text");
        this.f51147d = jSONObject.optInt("icon_exp");
        f(jSONObject.optString("page_list"));
    }

    public final void f(String str) {
        String[] split;
        if (d.b.b.e.p.k.isEmpty(str) || (split = str.split(",")) == null) {
            return;
        }
        for (String str2 : split) {
            int d2 = d.b.b.e.m.b.d(str2, -1);
            if (d2 != -1) {
                if (this.f51148e == null) {
                    this.f51148e = new ArrayList();
                }
                this.f51148e.add(Integer.valueOf(d2));
            }
        }
    }
}

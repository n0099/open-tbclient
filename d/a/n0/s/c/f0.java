package d.a.n0.s.c;

import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.yy.gslbsdk.db.ResultTB;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class f0 {

    /* renamed from: f  reason: collision with root package name */
    public static final Map<ShareDialogConfig.From, Integer> f54233f;

    /* renamed from: a  reason: collision with root package name */
    public int f54234a;

    /* renamed from: b  reason: collision with root package name */
    public int f54235b;

    /* renamed from: c  reason: collision with root package name */
    public String f54236c;

    /* renamed from: d  reason: collision with root package name */
    public int f54237d;

    /* renamed from: e  reason: collision with root package name */
    public List<Integer> f54238e;

    static {
        HashMap hashMap = new HashMap();
        f54233f = hashMap;
        hashMap.put(ShareDialogConfig.From.Recommend, 1);
        f54233f.put(ShareDialogConfig.From.Concern, 2);
        f54233f.put(ShareDialogConfig.From.PB, 3);
        f54233f.put(ShareDialogConfig.From.FRS, 4);
        f54233f.put(ShareDialogConfig.From.PersonPolymeric, 5);
        f54233f.put(ShareDialogConfig.From.VideoMiddlePageHorizontal, 6);
        f54233f.put(ShareDialogConfig.From.VideoMiddlePageVertical, 7);
        f54233f.put(ShareDialogConfig.From.HomeVideoTab, 8);
        f54233f.put(ShareDialogConfig.From.HomeGameTab, 9);
    }

    public int a() {
        return this.f54237d;
    }

    public String b() {
        return this.f54236c;
    }

    public boolean c() {
        return System.currentTimeMillis() / 1000 >= ((long) this.f54234a) && System.currentTimeMillis() / 1000 <= ((long) this.f54235b);
    }

    public boolean d(ShareDialogConfig.From from) {
        Integer num;
        return (this.f54238e == null || (num = f54233f.get(from)) == null || !this.f54238e.contains(num)) ? false : true;
    }

    public void e(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f54234a = jSONObject.optInt("begin_time");
        this.f54235b = jSONObject.optInt(ResultTB.ENDTIME);
        this.f54236c = jSONObject.optString("text");
        this.f54237d = jSONObject.optInt("icon_exp");
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
                if (this.f54238e == null) {
                    this.f54238e = new ArrayList();
                }
                this.f54238e.add(Integer.valueOf(d2));
            }
        }
    }
}

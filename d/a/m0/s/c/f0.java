package d.a.m0.s.c;

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
    public static final Map<ShareDialogConfig.From, Integer> f54126f;

    /* renamed from: a  reason: collision with root package name */
    public int f54127a;

    /* renamed from: b  reason: collision with root package name */
    public int f54128b;

    /* renamed from: c  reason: collision with root package name */
    public String f54129c;

    /* renamed from: d  reason: collision with root package name */
    public int f54130d;

    /* renamed from: e  reason: collision with root package name */
    public List<Integer> f54131e;

    static {
        HashMap hashMap = new HashMap();
        f54126f = hashMap;
        hashMap.put(ShareDialogConfig.From.Recommend, 1);
        f54126f.put(ShareDialogConfig.From.Concern, 2);
        f54126f.put(ShareDialogConfig.From.PB, 3);
        f54126f.put(ShareDialogConfig.From.FRS, 4);
        f54126f.put(ShareDialogConfig.From.PersonPolymeric, 5);
        f54126f.put(ShareDialogConfig.From.VideoMiddlePageHorizontal, 6);
        f54126f.put(ShareDialogConfig.From.VideoMiddlePageVertical, 7);
        f54126f.put(ShareDialogConfig.From.HomeVideoTab, 8);
        f54126f.put(ShareDialogConfig.From.HomeGameTab, 9);
    }

    public int a() {
        return this.f54130d;
    }

    public String b() {
        return this.f54129c;
    }

    public boolean c() {
        return System.currentTimeMillis() / 1000 >= ((long) this.f54127a) && System.currentTimeMillis() / 1000 <= ((long) this.f54128b);
    }

    public boolean d(ShareDialogConfig.From from) {
        Integer num;
        return (this.f54131e == null || (num = f54126f.get(from)) == null || !this.f54131e.contains(num)) ? false : true;
    }

    public void e(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f54127a = jSONObject.optInt("begin_time");
        this.f54128b = jSONObject.optInt(ResultTB.ENDTIME);
        this.f54129c = jSONObject.optString("text");
        this.f54130d = jSONObject.optInt("icon_exp");
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
                if (this.f54131e == null) {
                    this.f54131e = new ArrayList();
                }
                this.f54131e.add(Integer.valueOf(d2));
            }
        }
    }
}

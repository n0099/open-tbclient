package d.b.i0.a;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.FloatStrategy;
/* loaded from: classes3.dex */
public class n {

    /* renamed from: a  reason: collision with root package name */
    public boolean f50328a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f50329b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f50330c;

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public Integer f50331a;

        /* renamed from: b  reason: collision with root package name */
        public String f50332b;

        /* renamed from: c  reason: collision with root package name */
        public Integer f50333c;

        /* renamed from: d  reason: collision with root package name */
        public Long f50334d;

        /* renamed from: e  reason: collision with root package name */
        public Long f50335e;

        /* renamed from: f  reason: collision with root package name */
        public Integer f50336f;

        /* renamed from: g  reason: collision with root package name */
        public String f50337g;
    }

    /* loaded from: classes3.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public static final n f50338a = new n();
    }

    public static n b() {
        return c.f50338a;
    }

    public final void a(b bVar, boolean z) {
        if (bVar == null) {
            return;
        }
        try {
            if (this.f50328a) {
                boolean g2 = d.b.i0.r.d0.b.j().g("pref_key_task_first_open", true);
                int k = d.b.i0.r.d0.b.j().k("pref_key_float_tip_num", 0);
                long l = d.b.i0.r.d0.b.j().l("pref_key_new_task_complete_time", 0L);
                long currentTimeMillis = System.currentTimeMillis();
                if (g2) {
                    if (e(bVar)) {
                        this.f50330c = true;
                        d.b.i0.r.d0.b.j().t("pref_key_task_first_open", false);
                    }
                } else if (d(bVar, currentTimeMillis / 1000, l / 1000)) {
                    if (z) {
                        if (e(bVar)) {
                            this.f50330c = true;
                            d.b.i0.r.d0.b.j().v("pref_key_float_tip_num", 0);
                        }
                    } else if (k >= bVar.f50336f.intValue() || !e(bVar)) {
                    } else {
                        this.f50330c = true;
                        d.b.i0.r.d0.b.j().v("pref_key_float_tip_num", k + 1);
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    public final boolean c(d.b.i0.a.b bVar) {
        if (bVar == null) {
            return false;
        }
        int x = bVar.x();
        return x == 5 || x == 6 || x == 7 || x == 8;
    }

    public final boolean d(b bVar, long j, long j2) {
        boolean z;
        if (bVar != null && j2 > 0 && !TextUtils.isEmpty(bVar.f50332b) && bVar.f50334d.longValue() < bVar.f50335e.longValue() && j >= bVar.f50334d.longValue() && j <= bVar.f50335e.longValue() && bVar.f50336f.intValue() > 0 && bVar.f50331a.intValue() >= 0 && j > j2) {
            String[] split = bVar.f50332b.split(",");
            if (split != null && split.length > 0) {
                for (String str : split) {
                    if ("3".equals(str)) {
                        z = true;
                        break;
                    }
                }
            }
            z = false;
            if (!z) {
                return false;
            }
            long intValue = bVar.f50331a.intValue() * 86400;
            long j3 = j - j2;
            if (j3 > intValue && j3 < intValue + 86400) {
                return true;
            }
        }
        return false;
    }

    public final boolean e(b bVar) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2921409, bVar), Boolean.class);
        if (runTask == null || runTask.getData() == null || !(runTask.getData() instanceof Boolean)) {
            return false;
        }
        return ((Boolean) runTask.getData()).booleanValue();
    }

    public final void f(String str) {
        d.b.i0.r.d0.b.j().x("pref_key_strategy_json", str);
        d.b.i0.r.d0.b.j().v("pref_key_float_tip_num", 0);
    }

    public void g() {
        d.b.i0.r.d0.b.j().w("pref_key_new_task_complete_time", System.currentTimeMillis());
    }

    public void h(d.b.i0.a.b bVar) {
        if (bVar != null && c(bVar)) {
            d.b.i0.r.d0.b.j().w("pref_key_new_task_complete_time", System.currentTimeMillis());
        }
    }

    public void i(d.b.i0.a.z.b bVar) {
        b bVar2;
        if (bVar == null || bVar.a() == null || bVar.a().size() <= 0) {
            return;
        }
        ArrayList<FloatStrategy> a2 = bVar.a();
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        Iterator<FloatStrategy> it = a2.iterator();
        while (true) {
            if (!it.hasNext()) {
                bVar2 = null;
                break;
            }
            FloatStrategy next = it.next();
            if (currentTimeMillis > next.show_time_begin.longValue() && currentTimeMillis < next.show_time_end.longValue()) {
                bVar2 = new b();
                bVar2.f50332b = next.browsetimepage;
                bVar2.f50333c = next.duration;
                bVar2.f50336f = next.show_num;
                bVar2.f50334d = next.show_time_begin;
                bVar2.f50335e = next.show_time_end;
                bVar2.f50337g = next.toast;
                bVar2.f50331a = next.un_do_mission;
                break;
            }
        }
        if (bVar2 == null) {
            f("");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("un_do_mission", bVar2.f50331a.intValue());
            jSONObject.put("browsetimepage", bVar2.f50332b);
            jSONObject.put("duration", bVar2.f50333c.intValue());
            jSONObject.put("show_time_begin", bVar2.f50334d.longValue());
            jSONObject.put("show_time_end", bVar2.f50335e.longValue());
            jSONObject.put("show_num", bVar2.f50336f.intValue());
            jSONObject.put("toast", bVar2.f50337g);
            String jSONObject2 = jSONObject.toString();
            if (TextUtils.isEmpty(jSONObject2)) {
                f("");
                return;
            }
            if (!jSONObject2.equals(d.b.i0.r.d0.b.j().p("pref_key_strategy_json", null))) {
                f(jSONObject2);
            }
            a(bVar2, true);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public void j(boolean z) {
        this.f50328a = z;
        if (z && this.f50329b) {
            this.f50329b = false;
            if (!this.f50330c && d.b.i0.a.c.y().t()) {
                String p = d.b.i0.r.d0.b.j().p("pref_key_strategy_json", null);
                if (TextUtils.isEmpty(p)) {
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(p);
                    b bVar = new b();
                    bVar.f50331a = Integer.valueOf(jSONObject.optInt("un_do_mission", 0));
                    bVar.f50332b = jSONObject.optString("browsetimepage", "");
                    bVar.f50333c = Integer.valueOf(jSONObject.optInt("duration", 0));
                    bVar.f50334d = Long.valueOf(jSONObject.optLong("show_time_begin", 0L));
                    bVar.f50335e = Long.valueOf(jSONObject.optLong("show_time_end", 0L));
                    bVar.f50336f = Integer.valueOf(jSONObject.optInt("show_num", 0));
                    bVar.f50337g = jSONObject.optString("toast", null);
                    a(bVar, false);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public n() {
        this.f50328a = false;
        this.f50329b = true;
        this.f50330c = false;
    }
}

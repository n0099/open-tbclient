package d.a.n0.a;

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
public class p {

    /* renamed from: a  reason: collision with root package name */
    public boolean f52524a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f52525b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f52526c;

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public Integer f52527a;

        /* renamed from: b  reason: collision with root package name */
        public String f52528b;

        /* renamed from: c  reason: collision with root package name */
        public Integer f52529c;

        /* renamed from: d  reason: collision with root package name */
        public Long f52530d;

        /* renamed from: e  reason: collision with root package name */
        public Long f52531e;

        /* renamed from: f  reason: collision with root package name */
        public Integer f52532f;

        /* renamed from: g  reason: collision with root package name */
        public String f52533g;
    }

    /* loaded from: classes3.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public static final p f52534a = new p();
    }

    public static p b() {
        return c.f52534a;
    }

    public final void a(b bVar, boolean z) {
        if (bVar == null) {
            return;
        }
        try {
            if (this.f52524a) {
                boolean g2 = d.a.n0.r.d0.b.j().g("pref_key_task_first_open", true);
                int k = d.a.n0.r.d0.b.j().k("pref_key_float_tip_num", 0);
                long l = d.a.n0.r.d0.b.j().l("pref_key_new_task_complete_time", 0L);
                long currentTimeMillis = System.currentTimeMillis();
                if (g2) {
                    if (e(bVar)) {
                        this.f52526c = true;
                        d.a.n0.r.d0.b.j().t("pref_key_task_first_open", false);
                    }
                } else if (d(bVar, currentTimeMillis / 1000, l / 1000)) {
                    if (z) {
                        if (e(bVar)) {
                            this.f52526c = true;
                            d.a.n0.r.d0.b.j().v("pref_key_float_tip_num", 0);
                        }
                    } else if (k >= bVar.f52532f.intValue() || !e(bVar)) {
                    } else {
                        this.f52526c = true;
                        d.a.n0.r.d0.b.j().v("pref_key_float_tip_num", k + 1);
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    public final boolean c(d.a.n0.a.c cVar) {
        if (cVar == null) {
            return false;
        }
        int x = cVar.x();
        return x == 5 || x == 6 || x == 7 || x == 8;
    }

    public final boolean d(b bVar, long j, long j2) {
        boolean z;
        if (bVar != null && j2 > 0 && !TextUtils.isEmpty(bVar.f52528b) && bVar.f52530d.longValue() < bVar.f52531e.longValue() && j >= bVar.f52530d.longValue() && j <= bVar.f52531e.longValue() && bVar.f52532f.intValue() > 0 && bVar.f52527a.intValue() >= 0 && j > j2) {
            String[] split = bVar.f52528b.split(",");
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
            long intValue = bVar.f52527a.intValue() * 86400;
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
        d.a.n0.r.d0.b.j().x("pref_key_strategy_json", str);
        d.a.n0.r.d0.b.j().v("pref_key_float_tip_num", 0);
    }

    public void g() {
        d.a.n0.r.d0.b.j().w("pref_key_new_task_complete_time", System.currentTimeMillis());
    }

    public void h(d.a.n0.a.c cVar) {
        if (cVar != null && c(cVar)) {
            d.a.n0.r.d0.b.j().w("pref_key_new_task_complete_time", System.currentTimeMillis());
        }
    }

    public void i(d.a.n0.a.c0.b bVar) {
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
                bVar2.f52528b = next.browsetimepage;
                bVar2.f52529c = next.duration;
                bVar2.f52532f = next.show_num;
                bVar2.f52530d = next.show_time_begin;
                bVar2.f52531e = next.show_time_end;
                bVar2.f52533g = next.toast;
                bVar2.f52527a = next.un_do_mission;
                break;
            }
        }
        if (bVar2 == null) {
            f("");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("un_do_mission", bVar2.f52527a.intValue());
            jSONObject.put("browsetimepage", bVar2.f52528b);
            jSONObject.put("duration", bVar2.f52529c.intValue());
            jSONObject.put("show_time_begin", bVar2.f52530d.longValue());
            jSONObject.put("show_time_end", bVar2.f52531e.longValue());
            jSONObject.put("show_num", bVar2.f52532f.intValue());
            jSONObject.put("toast", bVar2.f52533g);
            String jSONObject2 = jSONObject.toString();
            if (TextUtils.isEmpty(jSONObject2)) {
                f("");
                return;
            }
            if (!jSONObject2.equals(d.a.n0.r.d0.b.j().p("pref_key_strategy_json", null))) {
                f(jSONObject2);
            }
            a(bVar2, true);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public void j(boolean z) {
        this.f52524a = z;
        if (z && this.f52525b) {
            this.f52525b = false;
            if (!this.f52526c && d.y().t()) {
                String p = d.a.n0.r.d0.b.j().p("pref_key_strategy_json", null);
                if (TextUtils.isEmpty(p)) {
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(p);
                    b bVar = new b();
                    bVar.f52527a = Integer.valueOf(jSONObject.optInt("un_do_mission", 0));
                    bVar.f52528b = jSONObject.optString("browsetimepage", "");
                    bVar.f52529c = Integer.valueOf(jSONObject.optInt("duration", 0));
                    bVar.f52530d = Long.valueOf(jSONObject.optLong("show_time_begin", 0L));
                    bVar.f52531e = Long.valueOf(jSONObject.optLong("show_time_end", 0L));
                    bVar.f52532f = Integer.valueOf(jSONObject.optInt("show_num", 0));
                    bVar.f52533g = jSONObject.optString("toast", null);
                    a(bVar, false);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public p() {
        this.f52524a = false;
        this.f52525b = true;
        this.f52526c = false;
    }
}

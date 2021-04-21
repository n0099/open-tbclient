package d.b.i0.r.q;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.TaskInfo;
/* loaded from: classes3.dex */
public class y1 {

    /* renamed from: a  reason: collision with root package name */
    public String f51679a;

    /* renamed from: b  reason: collision with root package name */
    public long f51680b;

    /* renamed from: c  reason: collision with root package name */
    public long f51681c;

    /* renamed from: d  reason: collision with root package name */
    public long f51682d;

    /* renamed from: e  reason: collision with root package name */
    public long f51683e;

    /* renamed from: f  reason: collision with root package name */
    public long f51684f;

    /* renamed from: g  reason: collision with root package name */
    public String f51685g;

    /* renamed from: h  reason: collision with root package name */
    public int f51686h;
    public int i;
    public String j;

    public long a() {
        return this.f51684f;
    }

    public String b() {
        return this.f51680b + "";
    }

    public String c() {
        return this.f51679a;
    }

    public String d() {
        return this.j;
    }

    public long e() {
        return this.f51683e;
    }

    public String f() {
        return this.f51681c + "";
    }

    public String g() {
        return this.f51682d + "";
    }

    public int h() {
        return this.i;
    }

    public String i() {
        return this.f51685g;
    }

    public int j() {
        return this.f51686h;
    }

    public void k(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            this.f51679a = jSONObject.optString("forum_name");
            this.f51680b = jSONObject.optLong("forum_id");
            this.f51681c = jSONObject.optLong("task_id");
            this.f51682d = jSONObject.optLong("thread_id");
            jSONObject.optString("bgimg");
            this.f51683e = jSONObject.optLong("start_time");
            this.f51684f = jSONObject.optLong("end_time");
            this.f51685g = jSONObject.optString("thread_img");
            String optString = jSONObject.optString("thread_img_size");
            if (optString != null && optString.length() > 0) {
                String[] split = optString.split(",");
                if (split.length > 1) {
                    this.f51686h = Integer.valueOf(split[0]).intValue();
                    this.i = Integer.valueOf(split[1]).intValue();
                }
            }
            if (this.f51686h <= 0) {
                this.f51686h = 1;
            }
            if (this.i <= 0) {
                this.i = 1;
            }
        } catch (Exception e2) {
            BdLog.e(e2.toString());
        }
    }

    public void l(TaskInfo taskInfo) {
        if (taskInfo == null) {
            return;
        }
        this.f51679a = taskInfo.forum_name;
        this.f51680b = taskInfo.forum_id.longValue();
        Long l = taskInfo.task_id;
        this.f51681c = l != null ? l.longValue() : -1L;
        Long l2 = taskInfo.thread_id;
        this.f51682d = l2 != null ? l2.longValue() : -1L;
        String str = taskInfo.bgimg;
        this.f51685g = taskInfo.thread_img;
        Long l3 = taskInfo.start_time;
        this.f51683e = l3 != null ? l3.longValue() : -1L;
        Long l4 = taskInfo.end_time;
        this.f51684f = l4 != null ? l4.longValue() : -1L;
        String str2 = taskInfo.thread_img_size;
        if (str2 != null) {
            try {
                String[] split = str2.split(",");
                this.f51686h = d.b.c.e.m.b.d(split[0], 1);
                this.i = d.b.c.e.m.b.d(split[1], 1);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
        if (this.f51686h <= 0) {
            this.f51686h = 1;
        }
        if (this.i <= 0) {
            this.i = 1;
        }
        this.j = taskInfo.obj_id;
    }
}

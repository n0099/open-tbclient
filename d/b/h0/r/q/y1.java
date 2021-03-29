package d.b.h0.r.q;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.TaskInfo;
/* loaded from: classes3.dex */
public class y1 {

    /* renamed from: a  reason: collision with root package name */
    public String f50936a;

    /* renamed from: b  reason: collision with root package name */
    public long f50937b;

    /* renamed from: c  reason: collision with root package name */
    public long f50938c;

    /* renamed from: d  reason: collision with root package name */
    public long f50939d;

    /* renamed from: e  reason: collision with root package name */
    public long f50940e;

    /* renamed from: f  reason: collision with root package name */
    public long f50941f;

    /* renamed from: g  reason: collision with root package name */
    public String f50942g;

    /* renamed from: h  reason: collision with root package name */
    public int f50943h;
    public int i;
    public String j;

    public long a() {
        return this.f50941f;
    }

    public String b() {
        return this.f50937b + "";
    }

    public String c() {
        return this.f50936a;
    }

    public String d() {
        return this.j;
    }

    public long e() {
        return this.f50940e;
    }

    public String f() {
        return this.f50938c + "";
    }

    public String g() {
        return this.f50939d + "";
    }

    public int h() {
        return this.i;
    }

    public String i() {
        return this.f50942g;
    }

    public int j() {
        return this.f50943h;
    }

    public void k(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            this.f50936a = jSONObject.optString("forum_name");
            this.f50937b = jSONObject.optLong("forum_id");
            this.f50938c = jSONObject.optLong("task_id");
            this.f50939d = jSONObject.optLong("thread_id");
            jSONObject.optString("bgimg");
            this.f50940e = jSONObject.optLong("start_time");
            this.f50941f = jSONObject.optLong("end_time");
            this.f50942g = jSONObject.optString("thread_img");
            String optString = jSONObject.optString("thread_img_size");
            if (optString != null && optString.length() > 0) {
                String[] split = optString.split(",");
                if (split.length > 1) {
                    this.f50943h = Integer.valueOf(split[0]).intValue();
                    this.i = Integer.valueOf(split[1]).intValue();
                }
            }
            if (this.f50943h <= 0) {
                this.f50943h = 1;
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
        this.f50936a = taskInfo.forum_name;
        this.f50937b = taskInfo.forum_id.longValue();
        Long l = taskInfo.task_id;
        this.f50938c = l != null ? l.longValue() : -1L;
        Long l2 = taskInfo.thread_id;
        this.f50939d = l2 != null ? l2.longValue() : -1L;
        String str = taskInfo.bgimg;
        this.f50942g = taskInfo.thread_img;
        Long l3 = taskInfo.start_time;
        this.f50940e = l3 != null ? l3.longValue() : -1L;
        Long l4 = taskInfo.end_time;
        this.f50941f = l4 != null ? l4.longValue() : -1L;
        String str2 = taskInfo.thread_img_size;
        if (str2 != null) {
            try {
                String[] split = str2.split(",");
                this.f50943h = d.b.b.e.m.b.d(split[0], 1);
                this.i = d.b.b.e.m.b.d(split[1], 1);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
        if (this.f50943h <= 0) {
            this.f50943h = 1;
        }
        if (this.i <= 0) {
            this.i = 1;
        }
        this.j = taskInfo.obj_id;
    }
}

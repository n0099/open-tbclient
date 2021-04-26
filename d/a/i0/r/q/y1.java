package d.a.i0.r.q;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.TaskInfo;
/* loaded from: classes3.dex */
public class y1 {

    /* renamed from: a  reason: collision with root package name */
    public String f49315a;

    /* renamed from: b  reason: collision with root package name */
    public long f49316b;

    /* renamed from: c  reason: collision with root package name */
    public long f49317c;

    /* renamed from: d  reason: collision with root package name */
    public long f49318d;

    /* renamed from: e  reason: collision with root package name */
    public long f49319e;

    /* renamed from: f  reason: collision with root package name */
    public long f49320f;

    /* renamed from: g  reason: collision with root package name */
    public String f49321g;

    /* renamed from: h  reason: collision with root package name */
    public int f49322h;

    /* renamed from: i  reason: collision with root package name */
    public int f49323i;
    public String j;

    public long a() {
        return this.f49320f;
    }

    public String b() {
        return this.f49316b + "";
    }

    public String c() {
        return this.f49315a;
    }

    public String d() {
        return this.j;
    }

    public long e() {
        return this.f49319e;
    }

    public String f() {
        return this.f49317c + "";
    }

    public String g() {
        return this.f49318d + "";
    }

    public int h() {
        return this.f49323i;
    }

    public String i() {
        return this.f49321g;
    }

    public int j() {
        return this.f49322h;
    }

    public void k(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            this.f49315a = jSONObject.optString("forum_name");
            this.f49316b = jSONObject.optLong("forum_id");
            this.f49317c = jSONObject.optLong("task_id");
            this.f49318d = jSONObject.optLong("thread_id");
            jSONObject.optString("bgimg");
            this.f49319e = jSONObject.optLong("start_time");
            this.f49320f = jSONObject.optLong("end_time");
            this.f49321g = jSONObject.optString("thread_img");
            String optString = jSONObject.optString("thread_img_size");
            if (optString != null && optString.length() > 0) {
                String[] split = optString.split(",");
                if (split.length > 1) {
                    this.f49322h = Integer.valueOf(split[0]).intValue();
                    this.f49323i = Integer.valueOf(split[1]).intValue();
                }
            }
            if (this.f49322h <= 0) {
                this.f49322h = 1;
            }
            if (this.f49323i <= 0) {
                this.f49323i = 1;
            }
        } catch (Exception e2) {
            BdLog.e(e2.toString());
        }
    }

    public void l(TaskInfo taskInfo) {
        if (taskInfo == null) {
            return;
        }
        this.f49315a = taskInfo.forum_name;
        this.f49316b = taskInfo.forum_id.longValue();
        Long l = taskInfo.task_id;
        this.f49317c = l != null ? l.longValue() : -1L;
        Long l2 = taskInfo.thread_id;
        this.f49318d = l2 != null ? l2.longValue() : -1L;
        String str = taskInfo.bgimg;
        this.f49321g = taskInfo.thread_img;
        Long l3 = taskInfo.start_time;
        this.f49319e = l3 != null ? l3.longValue() : -1L;
        Long l4 = taskInfo.end_time;
        this.f49320f = l4 != null ? l4.longValue() : -1L;
        String str2 = taskInfo.thread_img_size;
        if (str2 != null) {
            try {
                String[] split = str2.split(",");
                this.f49322h = d.a.c.e.m.b.d(split[0], 1);
                this.f49323i = d.a.c.e.m.b.d(split[1], 1);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
        if (this.f49322h <= 0) {
            this.f49322h = 1;
        }
        if (this.f49323i <= 0) {
            this.f49323i = 1;
        }
        this.j = taskInfo.obj_id;
    }
}

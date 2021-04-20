package d.b.h0.r.q;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.TaskInfo;
/* loaded from: classes3.dex */
public class y1 {

    /* renamed from: a  reason: collision with root package name */
    public String f51343a;

    /* renamed from: b  reason: collision with root package name */
    public long f51344b;

    /* renamed from: c  reason: collision with root package name */
    public long f51345c;

    /* renamed from: d  reason: collision with root package name */
    public long f51346d;

    /* renamed from: e  reason: collision with root package name */
    public long f51347e;

    /* renamed from: f  reason: collision with root package name */
    public long f51348f;

    /* renamed from: g  reason: collision with root package name */
    public String f51349g;

    /* renamed from: h  reason: collision with root package name */
    public int f51350h;
    public int i;
    public String j;

    public long a() {
        return this.f51348f;
    }

    public String b() {
        return this.f51344b + "";
    }

    public String c() {
        return this.f51343a;
    }

    public String d() {
        return this.j;
    }

    public long e() {
        return this.f51347e;
    }

    public String f() {
        return this.f51345c + "";
    }

    public String g() {
        return this.f51346d + "";
    }

    public int h() {
        return this.i;
    }

    public String i() {
        return this.f51349g;
    }

    public int j() {
        return this.f51350h;
    }

    public void k(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            this.f51343a = jSONObject.optString("forum_name");
            this.f51344b = jSONObject.optLong("forum_id");
            this.f51345c = jSONObject.optLong("task_id");
            this.f51346d = jSONObject.optLong("thread_id");
            jSONObject.optString("bgimg");
            this.f51347e = jSONObject.optLong("start_time");
            this.f51348f = jSONObject.optLong("end_time");
            this.f51349g = jSONObject.optString("thread_img");
            String optString = jSONObject.optString("thread_img_size");
            if (optString != null && optString.length() > 0) {
                String[] split = optString.split(",");
                if (split.length > 1) {
                    this.f51350h = Integer.valueOf(split[0]).intValue();
                    this.i = Integer.valueOf(split[1]).intValue();
                }
            }
            if (this.f51350h <= 0) {
                this.f51350h = 1;
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
        this.f51343a = taskInfo.forum_name;
        this.f51344b = taskInfo.forum_id.longValue();
        Long l = taskInfo.task_id;
        this.f51345c = l != null ? l.longValue() : -1L;
        Long l2 = taskInfo.thread_id;
        this.f51346d = l2 != null ? l2.longValue() : -1L;
        String str = taskInfo.bgimg;
        this.f51349g = taskInfo.thread_img;
        Long l3 = taskInfo.start_time;
        this.f51347e = l3 != null ? l3.longValue() : -1L;
        Long l4 = taskInfo.end_time;
        this.f51348f = l4 != null ? l4.longValue() : -1L;
        String str2 = taskInfo.thread_img_size;
        if (str2 != null) {
            try {
                String[] split = str2.split(",");
                this.f51350h = d.b.c.e.m.b.d(split[0], 1);
                this.i = d.b.c.e.m.b.d(split[1], 1);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
        if (this.f51350h <= 0) {
            this.f51350h = 1;
        }
        if (this.i <= 0) {
            this.i = 1;
        }
        this.j = taskInfo.obj_id;
    }
}

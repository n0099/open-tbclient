package d.a.j0.r.q;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.TaskInfo;
/* loaded from: classes3.dex */
public class y1 {

    /* renamed from: a  reason: collision with root package name */
    public String f50134a;

    /* renamed from: b  reason: collision with root package name */
    public long f50135b;

    /* renamed from: c  reason: collision with root package name */
    public long f50136c;

    /* renamed from: d  reason: collision with root package name */
    public long f50137d;

    /* renamed from: e  reason: collision with root package name */
    public long f50138e;

    /* renamed from: f  reason: collision with root package name */
    public long f50139f;

    /* renamed from: g  reason: collision with root package name */
    public String f50140g;

    /* renamed from: h  reason: collision with root package name */
    public int f50141h;

    /* renamed from: i  reason: collision with root package name */
    public int f50142i;
    public String j;

    public long a() {
        return this.f50139f;
    }

    public String b() {
        return this.f50135b + "";
    }

    public String c() {
        return this.f50134a;
    }

    public String d() {
        return this.j;
    }

    public long e() {
        return this.f50138e;
    }

    public String f() {
        return this.f50136c + "";
    }

    public String g() {
        return this.f50137d + "";
    }

    public int h() {
        return this.f50142i;
    }

    public String i() {
        return this.f50140g;
    }

    public int j() {
        return this.f50141h;
    }

    public void k(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            this.f50134a = jSONObject.optString("forum_name");
            this.f50135b = jSONObject.optLong("forum_id");
            this.f50136c = jSONObject.optLong("task_id");
            this.f50137d = jSONObject.optLong("thread_id");
            jSONObject.optString("bgimg");
            this.f50138e = jSONObject.optLong("start_time");
            this.f50139f = jSONObject.optLong("end_time");
            this.f50140g = jSONObject.optString("thread_img");
            String optString = jSONObject.optString("thread_img_size");
            if (optString != null && optString.length() > 0) {
                String[] split = optString.split(",");
                if (split.length > 1) {
                    this.f50141h = Integer.valueOf(split[0]).intValue();
                    this.f50142i = Integer.valueOf(split[1]).intValue();
                }
            }
            if (this.f50141h <= 0) {
                this.f50141h = 1;
            }
            if (this.f50142i <= 0) {
                this.f50142i = 1;
            }
        } catch (Exception e2) {
            BdLog.e(e2.toString());
        }
    }

    public void l(TaskInfo taskInfo) {
        if (taskInfo == null) {
            return;
        }
        this.f50134a = taskInfo.forum_name;
        this.f50135b = taskInfo.forum_id.longValue();
        Long l = taskInfo.task_id;
        this.f50136c = l != null ? l.longValue() : -1L;
        Long l2 = taskInfo.thread_id;
        this.f50137d = l2 != null ? l2.longValue() : -1L;
        String str = taskInfo.bgimg;
        this.f50140g = taskInfo.thread_img;
        Long l3 = taskInfo.start_time;
        this.f50138e = l3 != null ? l3.longValue() : -1L;
        Long l4 = taskInfo.end_time;
        this.f50139f = l4 != null ? l4.longValue() : -1L;
        String str2 = taskInfo.thread_img_size;
        if (str2 != null) {
            try {
                String[] split = str2.split(",");
                this.f50141h = d.a.c.e.m.b.d(split[0], 1);
                this.f50142i = d.a.c.e.m.b.d(split[1], 1);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
        if (this.f50141h <= 0) {
            this.f50141h = 1;
        }
        if (this.f50142i <= 0) {
            this.f50142i = 1;
        }
        this.j = taskInfo.obj_id;
    }
}

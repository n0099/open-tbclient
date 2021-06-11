package d.a.m0.r.q;

import com.baidu.adp.lib.util.BdLog;
import com.yy.gslbsdk.db.ResultTB;
import org.json.JSONObject;
import tbclient.TaskInfo;
/* loaded from: classes3.dex */
public class y1 {

    /* renamed from: a  reason: collision with root package name */
    public String f53854a;

    /* renamed from: b  reason: collision with root package name */
    public long f53855b;

    /* renamed from: c  reason: collision with root package name */
    public long f53856c;

    /* renamed from: d  reason: collision with root package name */
    public long f53857d;

    /* renamed from: e  reason: collision with root package name */
    public long f53858e;

    /* renamed from: f  reason: collision with root package name */
    public long f53859f;

    /* renamed from: g  reason: collision with root package name */
    public String f53860g;

    /* renamed from: h  reason: collision with root package name */
    public int f53861h;

    /* renamed from: i  reason: collision with root package name */
    public int f53862i;
    public String j;

    public long a() {
        return this.f53859f;
    }

    public String b() {
        return this.f53855b + "";
    }

    public String c() {
        return this.f53854a;
    }

    public String d() {
        return this.j;
    }

    public long e() {
        return this.f53858e;
    }

    public String f() {
        return this.f53856c + "";
    }

    public String g() {
        return this.f53857d + "";
    }

    public int h() {
        return this.f53862i;
    }

    public String i() {
        return this.f53860g;
    }

    public int j() {
        return this.f53861h;
    }

    public void k(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            this.f53854a = jSONObject.optString("forum_name");
            this.f53855b = jSONObject.optLong("forum_id");
            this.f53856c = jSONObject.optLong("task_id");
            this.f53857d = jSONObject.optLong("thread_id");
            jSONObject.optString("bgimg");
            this.f53858e = jSONObject.optLong("start_time");
            this.f53859f = jSONObject.optLong(ResultTB.ENDTIME);
            this.f53860g = jSONObject.optString("thread_img");
            String optString = jSONObject.optString("thread_img_size");
            if (optString != null && optString.length() > 0) {
                String[] split = optString.split(",");
                if (split.length > 1) {
                    this.f53861h = Integer.valueOf(split[0]).intValue();
                    this.f53862i = Integer.valueOf(split[1]).intValue();
                }
            }
            if (this.f53861h <= 0) {
                this.f53861h = 1;
            }
            if (this.f53862i <= 0) {
                this.f53862i = 1;
            }
        } catch (Exception e2) {
            BdLog.e(e2.toString());
        }
    }

    public void l(TaskInfo taskInfo) {
        if (taskInfo == null) {
            return;
        }
        this.f53854a = taskInfo.forum_name;
        this.f53855b = taskInfo.forum_id.longValue();
        Long l = taskInfo.task_id;
        this.f53856c = l != null ? l.longValue() : -1L;
        Long l2 = taskInfo.thread_id;
        this.f53857d = l2 != null ? l2.longValue() : -1L;
        String str = taskInfo.bgimg;
        this.f53860g = taskInfo.thread_img;
        Long l3 = taskInfo.start_time;
        this.f53858e = l3 != null ? l3.longValue() : -1L;
        Long l4 = taskInfo.end_time;
        this.f53859f = l4 != null ? l4.longValue() : -1L;
        String str2 = taskInfo.thread_img_size;
        if (str2 != null) {
            try {
                String[] split = str2.split(",");
                this.f53861h = d.a.c.e.m.b.d(split[0], 1);
                this.f53862i = d.a.c.e.m.b.d(split[1], 1);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
        if (this.f53861h <= 0) {
            this.f53861h = 1;
        }
        if (this.f53862i <= 0) {
            this.f53862i = 1;
        }
        this.j = taskInfo.obj_id;
    }
}

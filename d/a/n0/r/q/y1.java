package d.a.n0.r.q;

import com.baidu.adp.lib.util.BdLog;
import com.yy.gslbsdk.db.ResultTB;
import org.json.JSONObject;
import tbclient.TaskInfo;
/* loaded from: classes3.dex */
public class y1 {

    /* renamed from: a  reason: collision with root package name */
    public String f53961a;

    /* renamed from: b  reason: collision with root package name */
    public long f53962b;

    /* renamed from: c  reason: collision with root package name */
    public long f53963c;

    /* renamed from: d  reason: collision with root package name */
    public long f53964d;

    /* renamed from: e  reason: collision with root package name */
    public long f53965e;

    /* renamed from: f  reason: collision with root package name */
    public long f53966f;

    /* renamed from: g  reason: collision with root package name */
    public String f53967g;

    /* renamed from: h  reason: collision with root package name */
    public int f53968h;

    /* renamed from: i  reason: collision with root package name */
    public int f53969i;
    public String j;

    public long a() {
        return this.f53966f;
    }

    public String b() {
        return this.f53962b + "";
    }

    public String c() {
        return this.f53961a;
    }

    public String d() {
        return this.j;
    }

    public long e() {
        return this.f53965e;
    }

    public String f() {
        return this.f53963c + "";
    }

    public String g() {
        return this.f53964d + "";
    }

    public int h() {
        return this.f53969i;
    }

    public String i() {
        return this.f53967g;
    }

    public int j() {
        return this.f53968h;
    }

    public void k(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            this.f53961a = jSONObject.optString("forum_name");
            this.f53962b = jSONObject.optLong("forum_id");
            this.f53963c = jSONObject.optLong("task_id");
            this.f53964d = jSONObject.optLong("thread_id");
            jSONObject.optString("bgimg");
            this.f53965e = jSONObject.optLong("start_time");
            this.f53966f = jSONObject.optLong(ResultTB.ENDTIME);
            this.f53967g = jSONObject.optString("thread_img");
            String optString = jSONObject.optString("thread_img_size");
            if (optString != null && optString.length() > 0) {
                String[] split = optString.split(",");
                if (split.length > 1) {
                    this.f53968h = Integer.valueOf(split[0]).intValue();
                    this.f53969i = Integer.valueOf(split[1]).intValue();
                }
            }
            if (this.f53968h <= 0) {
                this.f53968h = 1;
            }
            if (this.f53969i <= 0) {
                this.f53969i = 1;
            }
        } catch (Exception e2) {
            BdLog.e(e2.toString());
        }
    }

    public void l(TaskInfo taskInfo) {
        if (taskInfo == null) {
            return;
        }
        this.f53961a = taskInfo.forum_name;
        this.f53962b = taskInfo.forum_id.longValue();
        Long l = taskInfo.task_id;
        this.f53963c = l != null ? l.longValue() : -1L;
        Long l2 = taskInfo.thread_id;
        this.f53964d = l2 != null ? l2.longValue() : -1L;
        String str = taskInfo.bgimg;
        this.f53967g = taskInfo.thread_img;
        Long l3 = taskInfo.start_time;
        this.f53965e = l3 != null ? l3.longValue() : -1L;
        Long l4 = taskInfo.end_time;
        this.f53966f = l4 != null ? l4.longValue() : -1L;
        String str2 = taskInfo.thread_img_size;
        if (str2 != null) {
            try {
                String[] split = str2.split(",");
                this.f53968h = d.a.c.e.m.b.d(split[0], 1);
                this.f53969i = d.a.c.e.m.b.d(split[1], 1);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
        if (this.f53968h <= 0) {
            this.f53968h = 1;
        }
        if (this.f53969i <= 0) {
            this.f53969i = 1;
        }
        this.j = taskInfo.obj_id;
    }
}

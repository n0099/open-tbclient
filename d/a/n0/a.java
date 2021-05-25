package d.a.n0;

import android.content.SharedPreferences;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    public static final a q = new a();

    /* renamed from: a  reason: collision with root package name */
    public AtomicBoolean f51100a = new AtomicBoolean(false);

    /* renamed from: b  reason: collision with root package name */
    public int f51101b;

    /* renamed from: c  reason: collision with root package name */
    public int f51102c;

    /* renamed from: d  reason: collision with root package name */
    public int f51103d;

    /* renamed from: e  reason: collision with root package name */
    public String f51104e;

    /* renamed from: f  reason: collision with root package name */
    public int f51105f;

    /* renamed from: g  reason: collision with root package name */
    public int f51106g;

    /* renamed from: h  reason: collision with root package name */
    public int f51107h;

    /* renamed from: i  reason: collision with root package name */
    public int f51108i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public long o;
    public int p;

    public static a h() {
        return q;
    }

    public long a() {
        return this.o;
    }

    public int b() {
        return this.m;
    }

    public int c() {
        return this.n;
    }

    public int d() {
        return this.f51105f;
    }

    public int e() {
        return this.f51107h;
    }

    public int f() {
        return this.f51106g;
    }

    public String g() {
        return this.f51104e;
    }

    public int i() {
        return this.l;
    }

    public int j() {
        return TbadkCoreApplication.getInst().getSharedPreferences("ad_sp_workplace", 0).getInt("pic_page_cache_time", 20);
    }

    public int k() {
        return TbadkCoreApplication.getInst().getSharedPreferences("ad_sp_workplace", 0).getInt("pic_page_first_floor", 5);
    }

    public int l() {
        return TbadkCoreApplication.getInst().getSharedPreferences("ad_sp_workplace", 0).getInt("pic_page_floor_interval", 7);
    }

    public int m() {
        return TbadkCoreApplication.getInst().getSharedPreferences("ad_sp_workplace", 0).getInt("pic_page_insert_mode", 1);
    }

    public int n() {
        return TbadkCoreApplication.getInst().getSharedPreferences("ad_sp_workplace", 0).getInt("pic_page_max_ad_num", 5);
    }

    public int o() {
        return TbadkCoreApplication.getInst().getSharedPreferences("ad_sp_workplace", 0).getInt("pic_page_pre_load_num", 5);
    }

    public int p() {
        return TbadkCoreApplication.getInst().getSharedPreferences("ad_sp_workplace", 0).getInt("pic_page_request_num", 5);
    }

    public int q() {
        return TbadkCoreApplication.getInst().getSharedPreferences("ad_sp_workplace", 0).getInt("pic_page_req_gap_time", 30);
    }

    public boolean r() {
        return this.f51108i == 1;
    }

    public boolean s() {
        return this.k == 1;
    }

    public boolean t() {
        return this.j == 1;
    }

    public boolean u() {
        return this.p == 1;
    }

    public boolean v() {
        return this.f51101b == 1;
    }

    public void w(JSONObject jSONObject) {
        boolean z = this.f51100a.get();
        if (jSONObject == null || z) {
            return;
        }
        this.f51100a.set(true);
        jSONObject.optInt("tieba_landing_page_type_switch", -1);
        this.f51101b = jSONObject.optInt("tieba_fix_apk_install_status_switch", 1);
        this.f51102c = jSONObject.optInt("tieba_12.2_download_ad_discard", -1);
        this.f51103d = jSONObject.optInt("tieba_12.3_ad_discard_optimize", -1);
        this.f51104e = jSONObject.optString("tieba_follow_up_cmatch_switchs", "");
        this.f51105f = jSONObject.optInt("tieba_follow_up_expire_time", 7);
        this.f51106g = jSONObject.optInt("tieba_follow_up_max_remind_times", 3);
        this.f51107h = jSONObject.optInt("tieba_follow_up_gap_time", 5);
        this.f51108i = jSONObject.optInt("tieba_12.4_download_path", 0);
        this.j = jSONObject.optInt("tieba_video_ad_jump_switch", 0);
        this.k = jSONObject.optInt("tieba_lazy_launch_switch", 0);
        this.l = jSONObject.optInt("tieba_lazy_launch_internal", 0);
        SharedPreferences.Editor edit = TbadkCoreApplication.getInst().getSharedPreferences("ad_sp_workplace", 0).edit();
        edit.putInt("pic_page_insert_mode", jSONObject.optInt("pic_page_insert_mode", 1));
        edit.putInt("pic_page_request_num", jSONObject.optInt("pic_page_request_num", 5));
        edit.putInt("pic_page_cache_time", jSONObject.optInt("pic_page_cache_time", 20));
        edit.putInt("pic_page_first_floor", jSONObject.optInt("pic_page_first_floor", 5));
        edit.putInt("pic_page_floor_interval", jSONObject.optInt("pic_page_floor_interval", 7));
        edit.putInt("pic_page_pre_load_num", jSONObject.optInt("pic_page_pre_load_num", 5));
        edit.putInt("pic_page_max_ad_num", jSONObject.optInt("pic_page_max_ad_num", 5));
        edit.putInt("pic_page_req_gap_time", jSONObject.optInt("pic_page_req_gap_time", 30));
        edit.commit();
        this.m = jSONObject.optInt("tieba_max_fake_progress", 0);
        this.n = jSONObject.optInt("tieba_max_fake_time", 60);
        this.o = jSONObject.optLong("tieba_max_fake_speed", 0L);
        this.p = jSONObject.optInt("tieba_video_load_optimize_switch", 0);
    }

    public boolean x() {
        return this.f51103d == 1;
    }

    public boolean y() {
        return this.f51102c == 1;
    }
}

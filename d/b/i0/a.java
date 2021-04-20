package d.b.i0;

import android.content.SharedPreferences;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    public static final a m = new a();

    /* renamed from: a  reason: collision with root package name */
    public AtomicBoolean f52258a = new AtomicBoolean(false);

    /* renamed from: b  reason: collision with root package name */
    public int f52259b;

    /* renamed from: c  reason: collision with root package name */
    public int f52260c;

    /* renamed from: d  reason: collision with root package name */
    public int f52261d;

    /* renamed from: e  reason: collision with root package name */
    public String f52262e;

    /* renamed from: f  reason: collision with root package name */
    public int f52263f;

    /* renamed from: g  reason: collision with root package name */
    public int f52264g;

    /* renamed from: h  reason: collision with root package name */
    public int f52265h;
    public int i;
    public int j;
    public int k;
    public int l;

    public static a e() {
        return m;
    }

    public int a() {
        return this.f52263f;
    }

    public int b() {
        return this.f52265h;
    }

    public int c() {
        return this.f52264g;
    }

    public String d() {
        return this.f52262e;
    }

    public int f() {
        return this.l;
    }

    public int g() {
        return TbadkCoreApplication.getInst().getSharedPreferences("ad_sp_workplace", 0).getInt("pic_page_cache_time", 20);
    }

    public int h() {
        return TbadkCoreApplication.getInst().getSharedPreferences("ad_sp_workplace", 0).getInt("pic_page_first_floor", 5);
    }

    public int i() {
        return TbadkCoreApplication.getInst().getSharedPreferences("ad_sp_workplace", 0).getInt("pic_page_floor_interval", 7);
    }

    public int j() {
        return TbadkCoreApplication.getInst().getSharedPreferences("ad_sp_workplace", 0).getInt("pic_page_insert_mode", 1);
    }

    public int k() {
        return TbadkCoreApplication.getInst().getSharedPreferences("ad_sp_workplace", 0).getInt("pic_page_max_ad_num", 5);
    }

    public int l() {
        return TbadkCoreApplication.getInst().getSharedPreferences("ad_sp_workplace", 0).getInt("pic_page_pre_load_num", 5);
    }

    public int m() {
        return TbadkCoreApplication.getInst().getSharedPreferences("ad_sp_workplace", 0).getInt("pic_page_request_num", 5);
    }

    public int n() {
        return TbadkCoreApplication.getInst().getSharedPreferences("ad_sp_workplace", 0).getInt("pic_page_req_gap_time", 30);
    }

    public boolean o() {
        return this.i == 1;
    }

    public boolean p() {
        return this.k == 1;
    }

    public boolean q() {
        return this.j == 1;
    }

    public boolean r() {
        return this.f52259b == 1;
    }

    public void s(JSONObject jSONObject) {
        boolean z = this.f52258a.get();
        if (jSONObject == null || z) {
            return;
        }
        this.f52258a.set(true);
        jSONObject.optInt("tieba_landing_page_type_switch", -1);
        this.f52259b = jSONObject.optInt("tieba_fix_apk_install_status_switch", 1);
        this.f52260c = jSONObject.optInt("tieba_12.2_download_ad_discard", -1);
        this.f52261d = jSONObject.optInt("tieba_12.3_ad_discard_optimize", -1);
        this.f52262e = jSONObject.optString("tieba_follow_up_cmatch_switchs", "");
        this.f52263f = jSONObject.optInt("tieba_follow_up_expire_time", 7);
        this.f52264g = jSONObject.optInt("tieba_follow_up_max_remind_times", 3);
        this.f52265h = jSONObject.optInt("tieba_follow_up_gap_time", 5);
        this.i = jSONObject.optInt("tieba_12.4_download_path", 0);
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
    }

    public boolean t() {
        return this.f52261d == 1;
    }

    public boolean u() {
        return this.f52260c == 1;
    }
}

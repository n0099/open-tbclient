package d.o.a.e.b.i;

import androidx.annotation.NonNull;
import com.baidu.adp.plugin.PluginCenter;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class m {

    /* renamed from: a  reason: collision with root package name */
    public final JSONObject f71090a;

    /* renamed from: b  reason: collision with root package name */
    public int f71091b;

    public m(JSONObject jSONObject) {
        this.f71090a = jSONObject;
    }

    @NonNull
    public static m b(@NonNull JSONObject jSONObject) {
        return new m(jSONObject);
    }

    public int a() {
        return this.f71091b;
    }

    public void c(int i2) {
        this.f71091b = d(i2);
    }

    public final int d(int i2) {
        int optInt = this.f71090a.optInt("thread_count", 4);
        if (optInt > 16) {
            optInt = 16;
        }
        if (optInt > 0) {
            return r() == 1 ? Math.min(optInt, i2) : optInt;
        } else if (r() > 0) {
            return i2;
        } else {
            return 1;
        }
    }

    public boolean e() {
        return r() > 0;
    }

    public boolean f() {
        return r() == 1;
    }

    public int g() {
        return this.f71090a.optInt("buffer_count", 512);
    }

    public int h() {
        return this.f71090a.optInt("buffer_size", 8192);
    }

    public boolean i() {
        return this.f71090a.optInt("segment_mode", 1) == 0;
    }

    public long j() {
        long optInt = this.f71090a.optInt("segment_min_kb", 512) * 1024;
        if (optInt < 65536) {
            return 65536L;
        }
        return optInt;
    }

    public long k() {
        long optInt = this.f71090a.optInt("segment_max_kb", 0) * 1048576;
        if (optInt < j()) {
            return -1L;
        }
        return optInt;
    }

    public long l() {
        long optInt = this.f71090a.optInt("connect_timeout", -1);
        if (optInt >= 2000) {
            return optInt;
        }
        return -1L;
    }

    public long m() {
        long optInt = this.f71090a.optInt("read_timeout", -1);
        if (optInt >= PluginCenter.PLUGIN_RETRY_MIN_TIME_INTERVAL) {
            return optInt;
        }
        return -1L;
    }

    public int n() {
        return this.f71090a.optInt("ip_strategy", 0);
    }

    public float o() {
        return (float) this.f71090a.optDouble("main_ratio", 0.0d);
    }

    public boolean p() {
        return this.f71090a.optInt("ratio_segment", 0) == 1;
    }

    public float q() {
        return Math.min(Math.max(0.0f, (float) this.f71090a.optDouble("poor_speed_ratio", 0.0d)), 1.0f);
    }

    public final int r() {
        return this.f71090a.optInt("url_balance", 2);
    }
}

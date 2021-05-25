package d.a.l0.a.e0.g;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import com.baidu.tbadk.TbConfig;
import d.a.l0.a.a2.e;
import d.a.l0.a.k;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final String f41478a = "performance_" + System.currentTimeMillis();

    /* renamed from: b  reason: collision with root package name */
    public int f41479b = 3000;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, Object> f41480c;

    /* renamed from: d  reason: collision with root package name */
    public b f41481d;

    /* renamed from: e  reason: collision with root package name */
    public BufferedWriter f41482e;

    @SuppressLint({"HandlerLeak"})
    /* loaded from: classes2.dex */
    public class b extends Handler {
        public b() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (a.this.f41480c != null) {
                a.this.f41480c.put("timestamp", Long.valueOf(System.currentTimeMillis()));
                JSONObject jSONObject = new JSONObject();
                for (Map.Entry entry : a.this.f41480c.entrySet()) {
                    try {
                        jSONObject.putOpt((String) entry.getKey(), entry.getValue());
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
                a.this.e(jSONObject.toString());
                d.a.l0.a.e0.d.g("PropertyLogcat", jSONObject.toString());
                if (a.this.f41481d != null) {
                    a.this.f41481d.sendEmptyMessageDelayed(100, a.this.f41479b);
                }
            }
        }
    }

    static {
        boolean z = k.f43199a;
    }

    public final void e(String str) {
        BufferedWriter bufferedWriter = this.f41482e;
        if (bufferedWriter != null) {
            try {
                bufferedWriter.write(str);
                this.f41482e.write(10);
                d.a.l0.a.e0.d.g("PropertyLogcat", "Export logcat success");
            } catch (IOException e2) {
                d.a.l0.a.e0.d.c("PropertyLogcat", "Logcat write fail", e2);
            }
        }
    }

    public final String f() {
        return d.a.l0.a.k2.b.n(e.V(), this.f41478a, TbConfig.TMP_LOG_DIR_NAME);
    }

    public void g(int i2) {
        if (i2 >= 1000) {
            this.f41479b = i2;
        }
    }

    public void h() {
        if (this.f41480c == null) {
            this.f41480c = d.a.l0.a.e0.g.b.h().i();
            d.a.l0.a.e0.d.g("PropertyLogcat", "Start monitor logcat");
        }
        if (this.f41481d == null) {
            this.f41481d = new b();
        }
        if (this.f41482e == null) {
            File file = new File(f());
            try {
                if (!file.exists()) {
                    file.createNewFile();
                }
                this.f41482e = new BufferedWriter(new FileWriter(file, true));
            } catch (IOException e2) {
                d.a.l0.a.e0.d.c("PropertyLogcat", "Create log file fail", e2);
            }
        }
        this.f41481d.removeMessages(100);
        this.f41481d.sendEmptyMessage(100);
    }

    public String i() {
        if (this.f41480c != null) {
            d.a.l0.a.e0.g.b.h().j();
            this.f41480c = null;
            d.a.l0.a.e0.d.g("PropertyLogcat", "Stop monitor logcat");
        }
        d.a.l0.t.d.d(this.f41482e);
        this.f41482e = null;
        return d.a.l0.a.k2.b.I(f(), e.V());
    }
}

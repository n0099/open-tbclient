package d.a.i0.a.e0.g;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import com.baidu.tbadk.TbConfig;
import d.a.i0.a.a2.e;
import d.a.i0.a.k;
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
    public final String f41304a = "performance_" + System.currentTimeMillis();

    /* renamed from: b  reason: collision with root package name */
    public int f41305b = 3000;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, Object> f41306c;

    /* renamed from: d  reason: collision with root package name */
    public b f41307d;

    /* renamed from: e  reason: collision with root package name */
    public BufferedWriter f41308e;

    @SuppressLint({"HandlerLeak"})
    /* loaded from: classes2.dex */
    public class b extends Handler {
        public b() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (a.this.f41306c != null) {
                a.this.f41306c.put("timestamp", Long.valueOf(System.currentTimeMillis()));
                JSONObject jSONObject = new JSONObject();
                for (Map.Entry entry : a.this.f41306c.entrySet()) {
                    try {
                        jSONObject.putOpt((String) entry.getKey(), entry.getValue());
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
                a.this.e(jSONObject.toString());
                d.a.i0.a.e0.d.g("PropertyLogcat", jSONObject.toString());
                if (a.this.f41307d != null) {
                    a.this.f41307d.sendEmptyMessageDelayed(100, a.this.f41305b);
                }
            }
        }
    }

    static {
        boolean z = k.f43025a;
    }

    public final void e(String str) {
        BufferedWriter bufferedWriter = this.f41308e;
        if (bufferedWriter != null) {
            try {
                bufferedWriter.write(str);
                this.f41308e.write(10);
                d.a.i0.a.e0.d.g("PropertyLogcat", "Export logcat success");
            } catch (IOException e2) {
                d.a.i0.a.e0.d.c("PropertyLogcat", "Logcat write fail", e2);
            }
        }
    }

    public final String f() {
        return d.a.i0.a.k2.b.n(e.V(), this.f41304a, TbConfig.TMP_LOG_DIR_NAME);
    }

    public void g(int i2) {
        if (i2 >= 1000) {
            this.f41305b = i2;
        }
    }

    public void h() {
        if (this.f41306c == null) {
            this.f41306c = d.a.i0.a.e0.g.b.h().i();
            d.a.i0.a.e0.d.g("PropertyLogcat", "Start monitor logcat");
        }
        if (this.f41307d == null) {
            this.f41307d = new b();
        }
        if (this.f41308e == null) {
            File file = new File(f());
            try {
                if (!file.exists()) {
                    file.createNewFile();
                }
                this.f41308e = new BufferedWriter(new FileWriter(file, true));
            } catch (IOException e2) {
                d.a.i0.a.e0.d.c("PropertyLogcat", "Create log file fail", e2);
            }
        }
        this.f41307d.removeMessages(100);
        this.f41307d.sendEmptyMessage(100);
    }

    public String i() {
        if (this.f41306c != null) {
            d.a.i0.a.e0.g.b.h().j();
            this.f41306c = null;
            d.a.i0.a.e0.d.g("PropertyLogcat", "Stop monitor logcat");
        }
        d.a.i0.t.d.d(this.f41308e);
        this.f41308e = null;
        return d.a.i0.a.k2.b.I(f(), e.V());
    }
}

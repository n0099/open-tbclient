package d.b.g0.a.c0.e;

import android.os.Handler;
import android.os.Message;
import com.baidu.tbadk.TbConfig;
import d.b.g0.a.k;
import d.b.g0.a.r1.e;
import d.b.g0.p.d;
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
    public final String f44042a = "performance_" + System.currentTimeMillis();

    /* renamed from: b  reason: collision with root package name */
    public int f44043b = 3000;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, Object> f44044c;

    /* renamed from: d  reason: collision with root package name */
    public b f44045d;

    /* renamed from: e  reason: collision with root package name */
    public BufferedWriter f44046e;

    /* loaded from: classes2.dex */
    public class b extends Handler {
        public b() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (a.this.f44044c != null) {
                a.this.f44044c.put("timestamp", Long.valueOf(System.currentTimeMillis()));
                JSONObject jSONObject = new JSONObject();
                for (Map.Entry entry : a.this.f44044c.entrySet()) {
                    try {
                        jSONObject.putOpt((String) entry.getKey(), entry.getValue());
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
                a.this.e(jSONObject.toString());
                d.b.g0.a.c0.c.g("PropertyLogcat", jSONObject.toString());
                if (a.this.f44045d != null) {
                    a.this.f44045d.sendEmptyMessageDelayed(100, a.this.f44043b);
                }
            }
        }
    }

    static {
        boolean z = k.f45443a;
    }

    public final void e(String str) {
        BufferedWriter bufferedWriter = this.f44046e;
        if (bufferedWriter != null) {
            try {
                bufferedWriter.write(str);
                this.f44046e.write(10);
                d.b.g0.a.c0.c.g("PropertyLogcat", "Export logcat success");
            } catch (IOException e2) {
                d.b.g0.a.c0.c.c("PropertyLogcat", "Logcat write fail", e2);
            }
        }
    }

    public final String f() {
        return d.b.g0.a.a2.b.b(e.T(), this.f44042a, TbConfig.TMP_LOG_DIR_NAME);
    }

    public void g(int i) {
        if (i >= 1000) {
            this.f44043b = i;
        }
    }

    public void h() {
        if (this.f44044c == null) {
            this.f44044c = d.b.g0.a.c0.e.b.h().i();
            d.b.g0.a.c0.c.g("PropertyLogcat", "Start monitor logcat");
        }
        if (this.f44045d == null) {
            this.f44045d = new b();
        }
        if (this.f44046e == null) {
            File file = new File(f());
            try {
                if (!file.exists()) {
                    file.createNewFile();
                }
                this.f44046e = new BufferedWriter(new FileWriter(file, true));
            } catch (IOException e2) {
                d.b.g0.a.c0.c.c("PropertyLogcat", "Create log file fail", e2);
            }
        }
        this.f44045d.removeMessages(100);
        this.f44045d.sendEmptyMessage(100);
    }

    public String i() {
        if (this.f44044c != null) {
            d.b.g0.a.c0.e.b.h().j();
            this.f44044c = null;
            d.b.g0.a.c0.c.g("PropertyLogcat", "Stop monitor logcat");
        }
        d.a(this.f44046e);
        this.f44046e = null;
        return d.b.g0.a.a2.b.q(f(), e.T());
    }
}

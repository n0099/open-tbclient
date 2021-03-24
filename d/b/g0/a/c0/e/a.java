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
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final String f43649a = "performance_" + System.currentTimeMillis();

    /* renamed from: b  reason: collision with root package name */
    public int f43650b = 3000;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, Object> f43651c;

    /* renamed from: d  reason: collision with root package name */
    public b f43652d;

    /* renamed from: e  reason: collision with root package name */
    public BufferedWriter f43653e;

    /* loaded from: classes3.dex */
    public class b extends Handler {
        public b() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (a.this.f43651c != null) {
                a.this.f43651c.put("timestamp", Long.valueOf(System.currentTimeMillis()));
                JSONObject jSONObject = new JSONObject();
                for (Map.Entry entry : a.this.f43651c.entrySet()) {
                    try {
                        jSONObject.putOpt((String) entry.getKey(), entry.getValue());
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
                a.this.e(jSONObject.toString());
                d.b.g0.a.c0.c.g("PropertyLogcat", jSONObject.toString());
                if (a.this.f43652d != null) {
                    a.this.f43652d.sendEmptyMessageDelayed(100, a.this.f43650b);
                }
            }
        }
    }

    static {
        boolean z = k.f45050a;
    }

    public final void e(String str) {
        BufferedWriter bufferedWriter = this.f43653e;
        if (bufferedWriter != null) {
            try {
                bufferedWriter.write(str);
                this.f43653e.write(10);
                d.b.g0.a.c0.c.g("PropertyLogcat", "Export logcat success");
            } catch (IOException e2) {
                d.b.g0.a.c0.c.c("PropertyLogcat", "Logcat write fail", e2);
            }
        }
    }

    public final String f() {
        return d.b.g0.a.a2.b.b(e.T(), this.f43649a, TbConfig.TMP_LOG_DIR_NAME);
    }

    public void g(int i) {
        if (i >= 1000) {
            this.f43650b = i;
        }
    }

    public void h() {
        if (this.f43651c == null) {
            this.f43651c = d.b.g0.a.c0.e.b.h().i();
            d.b.g0.a.c0.c.g("PropertyLogcat", "Start monitor logcat");
        }
        if (this.f43652d == null) {
            this.f43652d = new b();
        }
        if (this.f43653e == null) {
            File file = new File(f());
            try {
                if (!file.exists()) {
                    file.createNewFile();
                }
                this.f43653e = new BufferedWriter(new FileWriter(file, true));
            } catch (IOException e2) {
                d.b.g0.a.c0.c.c("PropertyLogcat", "Create log file fail", e2);
            }
        }
        this.f43652d.removeMessages(100);
        this.f43652d.sendEmptyMessage(100);
    }

    public String i() {
        if (this.f43651c != null) {
            d.b.g0.a.c0.e.b.h().j();
            this.f43651c = null;
            d.b.g0.a.c0.c.g("PropertyLogcat", "Stop monitor logcat");
        }
        d.a(this.f43653e);
        this.f43653e = null;
        return d.b.g0.a.a2.b.q(f(), e.T());
    }
}

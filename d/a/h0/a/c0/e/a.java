package d.a.h0.a.c0.e;

import android.os.Handler;
import android.os.Message;
import com.baidu.tbadk.TbConfig;
import d.a.h0.a.k;
import d.a.h0.a.r1.e;
import d.a.h0.p.d;
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
    public final String f41658a = "performance_" + System.currentTimeMillis();

    /* renamed from: b  reason: collision with root package name */
    public int f41659b = 3000;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, Object> f41660c;

    /* renamed from: d  reason: collision with root package name */
    public b f41661d;

    /* renamed from: e  reason: collision with root package name */
    public BufferedWriter f41662e;

    /* loaded from: classes2.dex */
    public class b extends Handler {
        public b() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (a.this.f41660c != null) {
                a.this.f41660c.put("timestamp", Long.valueOf(System.currentTimeMillis()));
                JSONObject jSONObject = new JSONObject();
                for (Map.Entry entry : a.this.f41660c.entrySet()) {
                    try {
                        jSONObject.putOpt((String) entry.getKey(), entry.getValue());
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
                a.this.e(jSONObject.toString());
                d.a.h0.a.c0.c.g("PropertyLogcat", jSONObject.toString());
                if (a.this.f41661d != null) {
                    a.this.f41661d.sendEmptyMessageDelayed(100, a.this.f41659b);
                }
            }
        }
    }

    static {
        boolean z = k.f43101a;
    }

    public final void e(String str) {
        BufferedWriter bufferedWriter = this.f41662e;
        if (bufferedWriter != null) {
            try {
                bufferedWriter.write(str);
                this.f41662e.write(10);
                d.a.h0.a.c0.c.g("PropertyLogcat", "Export logcat success");
            } catch (IOException e2) {
                d.a.h0.a.c0.c.c("PropertyLogcat", "Logcat write fail", e2);
            }
        }
    }

    public final String f() {
        return d.a.h0.a.a2.b.b(e.T(), this.f41658a, TbConfig.TMP_LOG_DIR_NAME);
    }

    public void g(int i2) {
        if (i2 >= 1000) {
            this.f41659b = i2;
        }
    }

    public void h() {
        if (this.f41660c == null) {
            this.f41660c = d.a.h0.a.c0.e.b.h().i();
            d.a.h0.a.c0.c.g("PropertyLogcat", "Start monitor logcat");
        }
        if (this.f41661d == null) {
            this.f41661d = new b();
        }
        if (this.f41662e == null) {
            File file = new File(f());
            try {
                if (!file.exists()) {
                    file.createNewFile();
                }
                this.f41662e = new BufferedWriter(new FileWriter(file, true));
            } catch (IOException e2) {
                d.a.h0.a.c0.c.c("PropertyLogcat", "Create log file fail", e2);
            }
        }
        this.f41661d.removeMessages(100);
        this.f41661d.sendEmptyMessage(100);
    }

    public String i() {
        if (this.f41660c != null) {
            d.a.h0.a.c0.e.b.h().j();
            this.f41660c = null;
            d.a.h0.a.c0.c.g("PropertyLogcat", "Stop monitor logcat");
        }
        d.a(this.f41662e);
        this.f41662e = null;
        return d.a.h0.a.a2.b.q(f(), e.T());
    }
}

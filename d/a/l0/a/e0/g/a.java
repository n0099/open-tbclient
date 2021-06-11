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
    public final String f45154a = "performance_" + System.currentTimeMillis();

    /* renamed from: b  reason: collision with root package name */
    public int f45155b = 3000;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, Object> f45156c;

    /* renamed from: d  reason: collision with root package name */
    public b f45157d;

    /* renamed from: e  reason: collision with root package name */
    public BufferedWriter f45158e;

    @SuppressLint({"HandlerLeak"})
    /* loaded from: classes2.dex */
    public class b extends Handler {
        public b() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (a.this.f45156c != null) {
                a.this.f45156c.put("timestamp", Long.valueOf(System.currentTimeMillis()));
                JSONObject jSONObject = new JSONObject();
                for (Map.Entry entry : a.this.f45156c.entrySet()) {
                    try {
                        jSONObject.putOpt((String) entry.getKey(), entry.getValue());
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
                a.this.e(jSONObject.toString());
                d.a.l0.a.e0.d.g("PropertyLogcat", jSONObject.toString());
                if (a.this.f45157d != null) {
                    a.this.f45157d.sendEmptyMessageDelayed(100, a.this.f45155b);
                }
            }
        }
    }

    static {
        boolean z = k.f46875a;
    }

    public final void e(String str) {
        BufferedWriter bufferedWriter = this.f45158e;
        if (bufferedWriter != null) {
            try {
                bufferedWriter.write(str);
                this.f45158e.write(10);
                d.a.l0.a.e0.d.g("PropertyLogcat", "Export logcat success");
            } catch (IOException e2) {
                d.a.l0.a.e0.d.c("PropertyLogcat", "Logcat write fail", e2);
            }
        }
    }

    public final String f() {
        return d.a.l0.a.k2.b.n(e.V(), this.f45154a, TbConfig.TMP_LOG_DIR_NAME);
    }

    public void g(int i2) {
        if (i2 >= 1000) {
            this.f45155b = i2;
        }
    }

    public void h() {
        if (this.f45156c == null) {
            this.f45156c = d.a.l0.a.e0.g.b.h().i();
            d.a.l0.a.e0.d.g("PropertyLogcat", "Start monitor logcat");
        }
        if (this.f45157d == null) {
            this.f45157d = new b();
        }
        if (this.f45158e == null) {
            File file = new File(f());
            try {
                if (!file.exists()) {
                    file.createNewFile();
                }
                this.f45158e = new BufferedWriter(new FileWriter(file, true));
            } catch (IOException e2) {
                d.a.l0.a.e0.d.c("PropertyLogcat", "Create log file fail", e2);
            }
        }
        this.f45157d.removeMessages(100);
        this.f45157d.sendEmptyMessage(100);
    }

    public String i() {
        if (this.f45156c != null) {
            d.a.l0.a.e0.g.b.h().j();
            this.f45156c = null;
            d.a.l0.a.e0.d.g("PropertyLogcat", "Stop monitor logcat");
        }
        d.a.l0.t.d.d(this.f45158e);
        this.f45158e = null;
        return d.a.l0.a.k2.b.I(f(), e.V());
    }
}

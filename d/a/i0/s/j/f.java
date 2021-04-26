package d.a.i0.s.j;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import d.a.c.e.p.j;
import java.net.InetSocketAddress;
import java.net.Socket;
/* loaded from: classes3.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public boolean f49851a = false;

    /* renamed from: b  reason: collision with root package name */
    public int f49852b = 0;

    public void a(String str) {
        int lastIndexOf;
        String str2;
        this.f49851a = false;
        this.f49852b = 0;
        if (!TextUtils.isEmpty(str) && (lastIndexOf = str.lastIndexOf(":")) >= 5) {
            String str3 = null;
            try {
                str2 = str.substring(5, lastIndexOf);
            } catch (Exception e2) {
                e = e2;
                str2 = null;
            }
            try {
                str3 = str.substring(lastIndexOf + 1);
            } catch (Exception e3) {
                e = e3;
                BdLog.e(e.getMessage());
                if (TextUtils.isEmpty(str2)) {
                    return;
                }
                return;
            }
            if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
                return;
            }
            int i2 = 0;
            int i3 = 0;
            for (int i4 = 0; i4 < 3; i4++) {
                Socket socket = new Socket();
                long currentTimeMillis = System.currentTimeMillis();
                try {
                    try {
                        socket.connect(new InetSocketAddress(str2, d.a.c.e.m.b.d(String.valueOf(str3), 8000)), c());
                        if (socket.isConnected()) {
                            i2++;
                            i3 = (int) (i3 + (System.currentTimeMillis() - currentTimeMillis));
                            this.f49851a = true;
                        }
                        socket.close();
                    } catch (Exception e4) {
                        BdLog.e(e4.getMessage());
                        try {
                            socket.close();
                        } catch (Exception e5) {
                            BdLog.e(e5.getMessage());
                        }
                    }
                } catch (Throwable th) {
                    try {
                        socket.close();
                    } catch (Exception e6) {
                        BdLog.e(e6.getMessage());
                    }
                    throw th;
                }
            }
            if (!this.f49851a || i2 <= 0) {
                return;
            }
            this.f49852b = i3 / i2;
        }
    }

    public int b() {
        return this.f49852b;
    }

    public final int c() {
        int I = j.I();
        if (I != 1) {
            return I != 2 ? 5000 : 10000;
        }
        return 3000;
    }

    public boolean d() {
        return this.f49851a;
    }
}

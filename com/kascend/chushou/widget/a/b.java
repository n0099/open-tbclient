package com.kascend.chushou.widget.a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.kascend.chushou.c.e;
import com.kascend.chushou.constants.ParserRet;
import com.tencent.connect.common.Constants;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b {
    private String a;
    private String b;
    private long g;
    private a nFZ;
    private volatile boolean c = false;
    private d<ParserRet> nFY = new com.kascend.chushou.widget.a.a();
    private boolean f = false;
    private final tv.chushou.zues.c nGa = new tv.chushou.zues.c(Looper.getMainLooper(), new Handler.Callback() { // from class: com.kascend.chushou.widget.a.b.2
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    if (!b.this.c) {
                        b.this.d();
                        return false;
                    }
                    return false;
                default:
                    return false;
            }
        }
    });

    /* loaded from: classes6.dex */
    public interface a {
        void b(ParserRet parserRet);
    }

    public void a(String str) {
        this.a = str;
        if (this.nFY != null) {
            this.nFY.b();
        }
    }

    public void a(a aVar) {
        this.nFZ = aVar;
    }

    public void a(boolean z) {
        if (z) {
            this.nFY = new c();
        } else {
            this.nFY = new com.kascend.chushou.widget.a.a();
        }
    }

    public void b(boolean z) {
        this.nGa.removeMessages(1);
        this.c = true;
        if (z) {
            this.b = null;
        }
    }

    public void a() {
        b(true);
    }

    public void b() {
        if (this.nFY != null) {
            this.nFY.c();
        }
        d();
    }

    public void c() {
        a();
    }

    public void d() {
        this.c = false;
        this.nGa.removeMessages(1);
        if (!this.f || System.currentTimeMillis() - this.g >= 20000) {
            if (this.f) {
                com.kascend.chushou.toolkit.a.a.l("type", Constants.VIA_REPORT_TYPE_WPA_STATE, "value", this.a);
            }
            this.g = System.currentTimeMillis();
            this.f = true;
            com.kascend.chushou.c.c.dMk().d(new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.widget.a.b.1
                @Override // com.kascend.chushou.c.b
                public void a() {
                }

                @Override // com.kascend.chushou.c.b
                public void a(String str, JSONObject jSONObject) {
                    long j;
                    b.this.f = false;
                    ParserRet D = e.D(jSONObject, b.this.b);
                    if (D.mRc == 0 && D.mData != null) {
                        b.this.b = D.mBreakpoint;
                        if (b.this.nFZ != null) {
                            b.this.nFZ.b(D);
                        }
                        long longValue = ((Long) D.mData1).longValue();
                        if (longValue == -1) {
                            if (b.this.nFY != null) {
                                j = b.this.nFY.E(D);
                            } else {
                                j = 1000;
                            }
                            b.this.nGa.B(1, j);
                            return;
                        }
                        if (b.this.nFY != null) {
                            b.this.nFY.b();
                        }
                        b.this.nGa.B(1, longValue);
                        return;
                    }
                    a(-1, "");
                }

                @Override // com.kascend.chushou.c.b
                public void a(int i, String str) {
                    long j;
                    b.this.f = false;
                    if (b.this.nFY != null) {
                        j = b.this.nFY.a();
                    } else {
                        j = 1000;
                    }
                    b.this.nGa.B(1, j);
                }
            }, this.a, this.b);
        }
    }
}

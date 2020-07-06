package com.kascend.chushou.widget.a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.kascend.chushou.c.e;
import com.kascend.chushou.constants.ParserRet;
import com.tencent.connect.common.Constants;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class b {
    private String a;
    private String b;
    private long g;
    private a nxq;
    private volatile boolean c = false;
    private d<ParserRet> nxp = new com.kascend.chushou.widget.a.a();
    private boolean f = false;
    private final tv.chushou.zues.c nxr = new tv.chushou.zues.c(Looper.getMainLooper(), new Handler.Callback() { // from class: com.kascend.chushou.widget.a.b.2
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

    /* loaded from: classes5.dex */
    public interface a {
        void b(ParserRet parserRet);
    }

    public void a(String str) {
        this.a = str;
        if (this.nxp != null) {
            this.nxp.b();
        }
    }

    public void a(a aVar) {
        this.nxq = aVar;
    }

    public void a(boolean z) {
        if (z) {
            this.nxp = new c();
        } else {
            this.nxp = new com.kascend.chushou.widget.a.a();
        }
    }

    public void b(boolean z) {
        this.nxr.removeMessages(1);
        this.c = true;
        if (z) {
            this.b = null;
        }
    }

    public void a() {
        b(true);
    }

    public void b() {
        if (this.nxp != null) {
            this.nxp.c();
        }
        d();
    }

    public void c() {
        a();
    }

    public void d() {
        this.c = false;
        this.nxr.removeMessages(1);
        if (!this.f || System.currentTimeMillis() - this.g >= 20000) {
            if (this.f) {
                com.kascend.chushou.toolkit.a.a.l("type", Constants.VIA_REPORT_TYPE_WPA_STATE, "value", this.a);
            }
            this.g = System.currentTimeMillis();
            this.f = true;
            com.kascend.chushou.c.c.dIP().d(new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.widget.a.b.1
                @Override // com.kascend.chushou.c.b
                public void a() {
                }

                @Override // com.kascend.chushou.c.b
                public void a(String str, JSONObject jSONObject) {
                    long j;
                    b.this.f = false;
                    ParserRet B = e.B(jSONObject, b.this.b);
                    if (B.mRc == 0 && B.mData != null) {
                        b.this.b = B.mBreakpoint;
                        if (b.this.nxq != null) {
                            b.this.nxq.b(B);
                        }
                        long longValue = ((Long) B.mData1).longValue();
                        if (longValue == -1) {
                            if (b.this.nxp != null) {
                                j = b.this.nxp.E(B);
                            } else {
                                j = 1000;
                            }
                            b.this.nxr.B(1, j);
                            return;
                        }
                        if (b.this.nxp != null) {
                            b.this.nxp.b();
                        }
                        b.this.nxr.B(1, longValue);
                        return;
                    }
                    a(-1, "");
                }

                @Override // com.kascend.chushou.c.b
                public void a(int i, String str) {
                    long j;
                    b.this.f = false;
                    if (b.this.nxp != null) {
                        j = b.this.nxp.a();
                    } else {
                        j = 1000;
                    }
                    b.this.nxr.B(1, j);
                }
            }, this.a, this.b);
        }
    }
}

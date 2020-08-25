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
    private a nZS;
    private volatile boolean c = false;
    private d<ParserRet> nZR = new com.kascend.chushou.widget.a.a();
    private boolean f = false;
    private final tv.chushou.zues.c nZT = new tv.chushou.zues.c(Looper.getMainLooper(), new Handler.Callback() { // from class: com.kascend.chushou.widget.a.b.2
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
        if (this.nZR != null) {
            this.nZR.b();
        }
    }

    public void a(a aVar) {
        this.nZS = aVar;
    }

    public void a(boolean z) {
        if (z) {
            this.nZR = new c();
        } else {
            this.nZR = new com.kascend.chushou.widget.a.a();
        }
    }

    public void b(boolean z) {
        this.nZT.removeMessages(1);
        this.c = true;
        if (z) {
            this.b = null;
        }
    }

    public void a() {
        b(true);
    }

    public void b() {
        if (this.nZR != null) {
            this.nZR.c();
        }
        d();
    }

    public void c() {
        a();
    }

    public void d() {
        this.c = false;
        this.nZT.removeMessages(1);
        if (!this.f || System.currentTimeMillis() - this.g >= 20000) {
            if (this.f) {
                com.kascend.chushou.toolkit.a.a.a("type", Constants.VIA_REPORT_TYPE_WPA_STATE, "value", this.a);
            }
            this.g = System.currentTimeMillis();
            this.f = true;
            com.kascend.chushou.c.c.dYm().d(new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.widget.a.b.1
                @Override // com.kascend.chushou.c.b
                public void a() {
                }

                @Override // com.kascend.chushou.c.b
                public void a(String str, JSONObject jSONObject) {
                    long j;
                    b.this.f = false;
                    ParserRet F = e.F(jSONObject, b.this.b);
                    if (F.mRc == 0 && F.mData != null) {
                        b.this.b = F.mBreakpoint;
                        if (b.this.nZS != null) {
                            b.this.nZS.b(F);
                        }
                        long longValue = ((Long) F.mData1).longValue();
                        if (longValue == -1) {
                            if (b.this.nZR != null) {
                                j = b.this.nZR.E(F);
                            } else {
                                j = 1000;
                            }
                            b.this.nZT.B(1, j);
                            return;
                        }
                        if (b.this.nZR != null) {
                            b.this.nZR.b();
                        }
                        b.this.nZT.B(1, longValue);
                        return;
                    }
                    a(-1, "");
                }

                @Override // com.kascend.chushou.c.b
                public void a(int i, String str) {
                    long j;
                    b.this.f = false;
                    if (b.this.nZR != null) {
                        j = b.this.nZR.a();
                    } else {
                        j = 1000;
                    }
                    b.this.nZT.B(1, j);
                }
            }, this.a, this.b);
        }
    }
}

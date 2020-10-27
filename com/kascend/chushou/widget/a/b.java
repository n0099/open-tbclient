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

    /* renamed from: a  reason: collision with root package name */
    private String f4259a;
    private String b;
    private long g;
    private a pqM;
    private volatile boolean c = false;
    private d<ParserRet> pqL = new com.kascend.chushou.widget.a.a();
    private boolean f = false;
    private final tv.chushou.zues.c pqN = new tv.chushou.zues.c(Looper.getMainLooper(), new Handler.Callback() { // from class: com.kascend.chushou.widget.a.b.2
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
        this.f4259a = str;
        if (this.pqL != null) {
            this.pqL.b();
        }
    }

    public void a(a aVar) {
        this.pqM = aVar;
    }

    public void a(boolean z) {
        if (z) {
            this.pqL = new c();
        } else {
            this.pqL = new com.kascend.chushou.widget.a.a();
        }
    }

    public void b(boolean z) {
        this.pqN.removeMessages(1);
        this.c = true;
        if (z) {
            this.b = null;
        }
    }

    public void a() {
        b(true);
    }

    public void b() {
        if (this.pqL != null) {
            this.pqL.c();
        }
        d();
    }

    public void c() {
        a();
    }

    public void d() {
        this.c = false;
        this.pqN.removeMessages(1);
        if (!this.f || System.currentTimeMillis() - this.g >= 20000) {
            if (this.f) {
                com.kascend.chushou.toolkit.a.a.a("type", Constants.VIA_REPORT_TYPE_WPA_STATE, "value", this.f4259a);
            }
            this.g = System.currentTimeMillis();
            this.f = true;
            com.kascend.chushou.c.c.eqe().d(new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.widget.a.b.1
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
                        if (b.this.pqM != null) {
                            b.this.pqM.b(F);
                        }
                        long longValue = ((Long) F.mData1).longValue();
                        if (longValue == -1) {
                            if (b.this.pqL != null) {
                                j = b.this.pqL.G(F);
                            } else {
                                j = 1000;
                            }
                            b.this.pqN.E(1, j);
                            return;
                        }
                        if (b.this.pqL != null) {
                            b.this.pqL.b();
                        }
                        b.this.pqN.E(1, longValue);
                        return;
                    }
                    a(-1, "");
                }

                @Override // com.kascend.chushou.c.b
                public void a(int i, String str) {
                    long j;
                    b.this.f = false;
                    if (b.this.pqL != null) {
                        j = b.this.pqL.a();
                    } else {
                        j = 1000;
                    }
                    b.this.pqN.E(1, j);
                }
            }, this.f4259a, this.b);
        }
    }
}

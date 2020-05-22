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
    private a nam;
    private volatile boolean c = false;
    private d<ParserRet> nal = new com.kascend.chushou.widget.a.a();
    private boolean f = false;
    private final tv.chushou.zues.c nan = new tv.chushou.zues.c(Looper.getMainLooper(), new Handler.Callback() { // from class: com.kascend.chushou.widget.a.b.2
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
        if (this.nal != null) {
            this.nal.b();
        }
    }

    public void a(a aVar) {
        this.nam = aVar;
    }

    public void a(boolean z) {
        if (z) {
            this.nal = new c();
        } else {
            this.nal = new com.kascend.chushou.widget.a.a();
        }
    }

    public void b(boolean z) {
        this.nan.removeMessages(1);
        this.c = true;
        if (z) {
            this.b = null;
        }
    }

    public void a() {
        b(true);
    }

    public void b() {
        if (this.nal != null) {
            this.nal.c();
        }
        d();
    }

    public void c() {
        a();
    }

    public void d() {
        this.c = false;
        this.nan.removeMessages(1);
        if (!this.f || System.currentTimeMillis() - this.g >= 20000) {
            if (this.f) {
                com.kascend.chushou.toolkit.a.a.l("type", Constants.VIA_REPORT_TYPE_WPA_STATE, "value", this.a);
            }
            this.g = System.currentTimeMillis();
            this.f = true;
            com.kascend.chushou.c.c.dDV().d(new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.widget.a.b.1
                @Override // com.kascend.chushou.c.b
                public void a() {
                }

                @Override // com.kascend.chushou.c.b
                public void a(String str, JSONObject jSONObject) {
                    long j;
                    b.this.f = false;
                    ParserRet A = e.A(jSONObject, b.this.b);
                    if (A.mRc == 0 && A.mData != null) {
                        b.this.b = A.mBreakpoint;
                        if (b.this.nam != null) {
                            b.this.nam.b(A);
                        }
                        long longValue = ((Long) A.mData1).longValue();
                        if (longValue == -1) {
                            if (b.this.nal != null) {
                                j = b.this.nal.E(A);
                            } else {
                                j = 1000;
                            }
                            b.this.nan.A(1, j);
                            return;
                        }
                        if (b.this.nal != null) {
                            b.this.nal.b();
                        }
                        b.this.nan.A(1, longValue);
                        return;
                    }
                    a(-1, "");
                }

                @Override // com.kascend.chushou.c.b
                public void a(int i, String str) {
                    long j;
                    b.this.f = false;
                    if (b.this.nal != null) {
                        j = b.this.nal.a();
                    } else {
                        j = 1000;
                    }
                    b.this.nan.A(1, j);
                }
            }, this.a, this.b);
        }
    }
}

package com.kascend.chushou.widget.gifts;

import com.kascend.chushou.constants.ParserRet;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class d extends com.kascend.chushou.view.base.c<f> {
    private String c = "";
    private int d = 1;
    private String e;

    public void a(String str, int i, int i2) {
        this.e = str;
        this.c = String.valueOf(i);
        this.d = i2;
    }

    public void c() {
        com.kascend.chushou.c.c.dEj().a(new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.widget.gifts.d.1
            @Override // com.kascend.chushou.c.b
            public void a() {
            }

            @Override // com.kascend.chushou.c.b
            public void a(String str, JSONObject jSONObject) {
                if (d.this.b()) {
                    ParserRet dJ = com.kascend.chushou.c.f.dJ(jSONObject);
                    ((f) d.this.b).h((List) dJ.mData, true, false);
                    d.this.c = dJ.mBreakpoint;
                }
            }

            @Override // com.kascend.chushou.c.b
            public void a(int i, String str) {
                if (d.this.b()) {
                    ((f) d.this.b).setHasMoreItems(false);
                }
            }
        }, this.e, this.d, this.c);
    }
}

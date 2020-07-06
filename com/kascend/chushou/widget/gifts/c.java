package com.kascend.chushou.widget.gifts;

import android.text.TextUtils;
import com.kascend.chushou.constants.GeneralGift;
import com.kascend.chushou.constants.ParserRet;
import java.util.List;
import org.json.JSONObject;
import tv.chushou.zues.utils.h;
/* loaded from: classes5.dex */
public class c extends com.kascend.chushou.view.base.c<f> {
    private String d;
    private String c = "";
    private String e = "";

    public c(String str) {
        this.d = str;
    }

    public void a(String str) {
        if (!TextUtils.isEmpty(str) && !TextUtils.equals(this.e, str)) {
            this.e = str;
            a(true);
        }
    }

    public void a(final boolean z) {
        if (z) {
            this.c = "";
        }
        com.kascend.chushou.c.c.dIP().b(new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.widget.gifts.c.1
            @Override // com.kascend.chushou.c.b
            public void a() {
                if (c.this.b() && z) {
                    tv.chushou.zues.a.a.post(new com.kascend.chushou.widget.gifts.a.a(c.this.d, 1));
                }
            }

            @Override // com.kascend.chushou.c.b
            public void a(String str, JSONObject jSONObject) {
                if (c.this.b()) {
                    if (z) {
                        tv.chushou.zues.a.a.post(new com.kascend.chushou.widget.gifts.a.a(c.this.d, 2));
                    }
                    ParserRet dT = com.kascend.chushou.c.f.dT(jSONObject);
                    List<GeneralGift> list = (List) dT.mData;
                    if (z && h.isEmpty(list)) {
                        tv.chushou.zues.a.a.post(new com.kascend.chushou.widget.gifts.a.a(c.this.d, 6));
                    }
                    ((f) c.this.b).h(list, true, z);
                    c.this.c = dT.mBreakpoint;
                }
            }

            @Override // com.kascend.chushou.c.b
            public void a(int i, String str) {
                if (c.this.b()) {
                    if (z) {
                        tv.chushou.zues.a.a.post(new com.kascend.chushou.widget.gifts.a.a(c.this.d, 4));
                    }
                    ((f) c.this.b).setHasMoreItems(false);
                }
            }
        }, this.e, this.c);
    }

    public void c() {
        this.c = "";
        this.e = "";
    }
}

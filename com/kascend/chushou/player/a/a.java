package com.kascend.chushou.player.a;

import android.content.Context;
import android.widget.TextView;
import com.kascend.chushou.a;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
import tv.chushou.zues.utils.g;
import tv.chushou.zues.utils.h;
/* loaded from: classes6.dex */
public abstract class a {
    protected TextView b;
    protected Context c;

    /* renamed from: a  reason: collision with root package name */
    protected List<c> f4109a = new ArrayList();
    protected com.kascend.chushou.c.b ogW = new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.a.a.1
        @Override // com.kascend.chushou.c.b
        public void a() {
        }

        @Override // com.kascend.chushou.c.b
        public void a(String str, JSONObject jSONObject) {
            int optInt = jSONObject.optInt("code", -1);
            String optString = jSONObject.optString("message", "");
            if (optInt == 0) {
                g.PQ(a.i.report_success);
            } else {
                a(optInt, optString);
            }
        }

        @Override // com.kascend.chushou.c.b
        public void a(int i, String str) {
            if (i == 401) {
                com.kascend.chushou.d.e.b(a.this.c, (String) null);
                return;
            }
            if (h.isEmpty(str)) {
                str = a.this.c.getString(a.i.report_failed);
            }
            g.c(a.this.c, str);
        }
    };

    public void a(String str) {
        this.b.setText(str);
    }

    public a(TextView textView, Context context) {
        this.b = textView;
        this.c = context;
    }

    public int a(int i) {
        if (i == a.i.dialog_drag) {
            return 1;
        }
        if (i == a.i.dialog_sex) {
            return 2;
        }
        if (i == a.i.dialog_ad) {
            return 3;
        }
        if (i == a.i.dialog_plugin) {
            return 7;
        }
        if (i != a.i.dialog_other) {
            if (i == a.i.dialog_thief) {
                return 4;
            }
            if (i == a.i.dialog_tagerror) {
                return 6;
            }
            if (i == a.i.dialog_long_time) {
                return 8;
            }
            return i == a.i.dynamics_report_02 ? 9 : 5;
        }
        return 5;
    }
}

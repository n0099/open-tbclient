package com.kascend.chushou.player.ui.h5.a;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.searchbox.http.HttpConfig;
import com.kascend.chushou.a;
import com.kascend.chushou.constants.ListItem;
import com.kascend.chushou.d.e;
import com.kascend.chushou.d.f;
import org.json.JSONObject;
import tv.chushou.zues.widget.fresco.FrescoThumbnailView;
import tv.chushou.zues.widget.fresco.b;
/* loaded from: classes6.dex */
public class b extends LinearLayout implements View.OnClickListener {
    private TextView c;
    private TextView d;
    private boolean f;
    private FrescoThumbnailView pkk;
    private FrescoThumbnailView pkz;
    private com.kascend.chushou.player.ui.h5.c.b pll;

    public b(Context context) {
        super(context);
        this.f = false;
        a(context);
    }

    private void a(Context context) {
        LayoutInflater.from(context).inflate(a.h.view_lucky_draw_notifier, (ViewGroup) this, true);
        this.pkk = (FrescoThumbnailView) findViewById(a.f.iv_lucky_draw_icon);
        this.pkk.setAnim(true);
        this.pkz = (FrescoThumbnailView) findViewById(a.f.iv_lucky_draw_text_bg);
        this.c = (TextView) findViewById(a.f.tv_lucky_draw_text);
        this.d = (TextView) findViewById(a.f.tv_count);
        this.pkk.setOnClickListener(this);
        this.d.setVisibility(8);
        this.pkz.setVisibility(8);
        this.c.setVisibility(8);
    }

    public void a(com.kascend.chushou.player.ui.h5.c.b bVar) {
        if (bVar == null) {
            setVisibility(8);
        } else if (!this.f) {
            this.pll = bVar;
            this.pkk.j(bVar.f4172a, com.kascend.chushou.view.a.a(""), b.C1104b.qfb, b.C1104b.qfb);
            this.f = true;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str = this.pll.q;
        char c = 65535;
        switch (str.hashCode()) {
            case 1819:
                if (str.equals(HttpConfig.UBC_HTTP_ID)) {
                    c = 0;
                    break;
                }
                break;
            case 1821:
                if (str.equals("96")) {
                    c = 3;
                    break;
                }
                break;
            case 1823:
                if (str.equals("98")) {
                    c = 1;
                    break;
                }
                break;
            case 1824:
                if (str.equals("99")) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                tv.chushou.zues.a.a.post(new com.kascend.chushou.player.ui.button.b(9, this.pll));
                return;
            case 1:
                ListItem listItem = new ListItem();
                listItem.mType = "98";
                listItem.mUrl = this.pll.o;
                tv.chushou.zues.a.a.post(new com.kascend.chushou.player.ui.button.b(2, listItem));
                return;
            case 2:
                ListItem listItem2 = new ListItem();
                listItem2.mType = "99";
                listItem2.mUrl = this.pll.o;
                e.a(getContext(), listItem2, (JSONObject) null);
                return;
            case 3:
                Activity hj = f.hj(getContext());
                if (hj == null) {
                    hj = com.kascend.chushou.d.b.eqf();
                }
                e.a(hj, this.pll.o);
                return;
            default:
                return;
        }
    }
}

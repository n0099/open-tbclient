package com.kascend.chushou.player.ui.h5.b;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.kascend.chushou.a;
import tv.chushou.zues.utils.h;
import tv.chushou.zues.widget.fresco.FrescoThumbnailView;
import tv.chushou.zues.widget.fresco.b;
/* loaded from: classes6.dex */
public class c extends LinearLayout implements View.OnClickListener {
    private Context a;
    private TextView d;
    private TextView e;
    private boolean f;
    private int g;
    private FrescoThumbnailView nzH;
    private FrescoThumbnailView nzM;

    public c(Context context) {
        super(context);
        this.f = false;
        this.g = 1;
        a(context);
    }

    private void a(Context context) {
        this.a = context;
        LayoutInflater.from(context).inflate(a.h.view_lucky_draw_notifier, (ViewGroup) this, true);
        this.nzM = (FrescoThumbnailView) findViewById(a.f.iv_lucky_draw_icon);
        this.nzM.setAnim(true);
        this.nzH = (FrescoThumbnailView) findViewById(a.f.iv_lucky_draw_text_bg);
        this.d = (TextView) findViewById(a.f.tv_lucky_draw_text);
        this.e = (TextView) findViewById(a.f.tv_count);
        this.nzM.setOnClickListener(this);
        this.d.setOnClickListener(this);
    }

    public int getType() {
        return this.g;
    }

    public void a(com.kascend.chushou.player.ui.h5.d.a aVar) {
        this.g = 2;
        com.kascend.chushou.player.ui.h5.c.c dOj = aVar.dOj();
        if (dOj == null) {
            setVisibility(8);
        } else if (!this.f) {
            this.nzM.i(dOj.a, a.e.open_vote, b.C0959b.ouG, b.C0959b.ouG);
            this.nzH.i(dOj.b, a.e.open_vote_text_bg, b.C0959b.small, b.C0959b.small);
            int color = ContextCompat.getColor(this.a, a.c.kas_white);
            if (!h.isEmpty(dOj.c)) {
                try {
                    color = Color.parseColor(dOj.c);
                } catch (Exception e) {
                    color = ContextCompat.getColor(this.a, a.c.kas_white);
                }
            }
            this.d.setTextColor(color);
            this.d.setText(b.e(this.a, dOj.e));
            this.f = true;
        }
    }

    public void a(b bVar) {
        this.g = 1;
        com.kascend.chushou.player.ui.h5.c.c dOj = bVar.dOj();
        if (dOj == null) {
            setVisibility(8);
        } else if (!this.f) {
            this.nzM.i(dOj.a, a.e.open_luckydraw, b.C0959b.ouG, b.C0959b.ouG);
            this.nzH.i(dOj.b, a.e.open_luckydraw_text_bg, b.C0959b.small, b.C0959b.small);
            int color = ContextCompat.getColor(this.a, a.c.kas_white);
            if (!h.isEmpty(dOj.c)) {
                try {
                    color = Color.parseColor(dOj.c);
                } catch (Exception e) {
                    color = ContextCompat.getColor(this.a, a.c.kas_white);
                }
            }
            this.d.setTextColor(color);
            this.d.setText(b.e(this.a, dOj.e));
            if (bVar.e() > 1) {
                this.e.setVisibility(0);
                this.e.setText(String.valueOf(bVar.e()));
            } else {
                this.e.setVisibility(8);
            }
            this.f = true;
        }
    }

    public void a(long j) {
        if (j > 0) {
            setVisibility(0);
            this.d.setText(b.e(this.a, j));
            return;
        }
        setVisibility(8);
    }

    public void a(int i) {
        if (i > 1) {
            this.e.setVisibility(0);
            this.e.setText(String.valueOf(i));
            return;
        }
        this.e.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.g == 1) {
            tv.chushou.zues.a.a.post(new com.kascend.chushou.player.ui.button.b(4, null));
        } else if (this.g == 2) {
            tv.chushou.zues.a.a.post(new com.kascend.chushou.player.ui.button.b(3, null));
        }
    }
}

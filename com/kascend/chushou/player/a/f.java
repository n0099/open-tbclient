package com.kascend.chushou.player.a;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.content.res.ResourcesCompat;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.kascend.chushou.a;
import com.kascend.chushou.constants.ChatInfo;
import com.kascend.chushou.constants.RoomInfo;
import java.util.List;
/* loaded from: classes6.dex */
public class f extends b {
    private TextView d;
    private TextView e;
    private LinearLayout f;
    private LinearLayout g;
    private LinearLayout h;
    private Context i;
    private List<c> j;
    private boolean k;
    private TextView l;
    private ScrollView nSQ;

    public f(Context context) {
        super(context);
        this.k = false;
        Window window = getWindow();
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.gravity = 80;
            attributes.width = -1;
            window.setAttributes(attributes);
            window.setWindowAnimations(a.j.share_dialog_animation);
        }
        this.i = context;
        setContentView(a.h.dialog_operate_report);
        setCanceledOnTouchOutside(true);
        b();
    }

    @Override // android.app.Dialog
    protected void onStart() {
        super.onStart();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindow().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        getWindow().setLayout(displayMetrics.widthPixels, getWindow().getAttributes().height);
    }

    private void b() {
        this.h = (LinearLayout) findViewById(a.f.ll_dialog_operate);
        this.nSQ = (ScrollView) findViewById(a.f.scroll_content);
        this.d = (TextView) findViewById(a.f.tvDlgUserTitle);
        this.e = (TextView) findViewById(a.f.tv_header);
        this.f = (LinearLayout) findViewById(a.f.ll_operate_content);
        this.g = (LinearLayout) findViewById(a.f.ll_report_content);
        this.l = (TextView) findViewById(a.f.tv_cancel);
        this.l.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.a.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.dismiss();
            }
        });
    }

    @Override // android.app.Dialog
    public void show() {
        d();
        c();
        super.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        int i = 0;
        int dip2px = tv.chushou.zues.utils.a.dip2px(this.i, 58.0f);
        while (true) {
            int i2 = i;
            if (i2 >= this.j.size()) {
                break;
            }
            c cVar = this.j.get(i2);
            if ((cVar.a != 1 || cVar.h) && (cVar.a != 2 || cVar.h || this.k)) {
                if (this.j.get(i2).a == 1) {
                    dip2px += tv.chushou.zues.utils.a.dip2px(this.i, 58.0f);
                } else if (this.j.get(i2).a == 2) {
                    dip2px += tv.chushou.zues.utils.a.dip2px(this.i, 58.0f);
                }
            }
            i = i2 + 1;
        }
        if (this.d.isShown()) {
            dip2px += tv.chushou.zues.utils.a.dip2px(this.i, 58.0f);
        }
        if (this.e.isShown()) {
            dip2px += tv.chushou.zues.utils.a.dip2px(this.i, 58.0f);
        }
        if (dip2px > (tv.chushou.zues.utils.a.hc(this.i).y - tv.chushou.zues.utils.a.dip2px(this.i, 80.0f)) - tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.i)) {
            ViewGroup.LayoutParams layoutParams = this.nSQ.getLayoutParams();
            layoutParams.height = ((tv.chushou.zues.utils.a.hc(this.i).y - tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.i)) - tv.chushou.zues.utils.a.dip2px(this.i, 80.0f)) - tv.chushou.zues.utils.a.dip2px(this.i, 58.0f);
            if (this.e.isShown()) {
                layoutParams.height -= tv.chushou.zues.utils.a.dip2px(this.i, 58.0f);
            }
            if (this.d.isShown()) {
                layoutParams.height -= tv.chushou.zues.utils.a.dip2px(this.i, 58.0f);
            }
            this.nSQ.setLayoutParams(layoutParams);
            return;
        }
        ViewGroup.LayoutParams layoutParams2 = this.nSQ.getLayoutParams();
        layoutParams2.height = -2;
        this.nSQ.setLayoutParams(layoutParams2);
    }

    private void d() {
        this.f.removeAllViews();
        this.g.removeAllViews();
        int i = 0;
        while (i < this.j.size()) {
            c cVar = this.j.get(i);
            boolean z = i == this.j.size() + (-1);
            if (cVar.a == 1) {
                a(cVar);
            } else {
                a(cVar, z);
            }
            i++;
        }
    }

    private void a(final c cVar) {
        View inflate = LayoutInflater.from(this.i).inflate(a.h.view_dlg_operate_item, (ViewGroup) this.f, false);
        ((ImageView) inflate.findViewById(a.f.iv_icon)).setImageResource(cVar.b);
        ((TextView) inflate.findViewById(a.f.tv_content)).setText(this.i.getString(cVar.c));
        if (cVar.e) {
            inflate.findViewById(a.f.ivDialogMore).setVisibility(0);
            inflate.findViewById(a.f.diliver).setVisibility(8);
        } else {
            inflate.findViewById(a.f.ivDialogMore).setVisibility(8);
            inflate.findViewById(a.f.diliver).setVisibility(0);
        }
        this.f.addView(inflate);
        inflate.setOnClickListener(new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.a.f.2
            @Override // tv.chushou.zues.a
            public void dL(View view) {
                cVar.nSH.a(cVar.c);
                if (cVar.c == a.i.dialog_report) {
                    f.this.k = !f.this.k;
                    f.this.c();
                    if (f.this.k) {
                        ((ImageView) view.findViewById(a.f.ivDialogMore)).setImageDrawable(ResourcesCompat.getDrawable(f.this.i.getResources(), a.e.dialog_icon_up_n, null));
                        return;
                    } else {
                        ((ImageView) view.findViewById(a.f.ivDialogMore)).setImageDrawable(ResourcesCompat.getDrawable(f.this.i.getResources(), a.e.dialog_icon_down_n, null));
                        return;
                    }
                }
                f.this.dismiss();
            }
        });
    }

    private void a(final c cVar, boolean z) {
        View inflate = LayoutInflater.from(this.i).inflate(a.h.view_dlg_report_child_item, (ViewGroup) this.g, false);
        TextView textView = (TextView) inflate.findViewById(a.f.tv_content);
        textView.setText(this.i.getString(cVar.c));
        if (cVar.g) {
            textView.setPadding(tv.chushou.zues.utils.a.dip2px(this.i, 42.0f), 0, 0, 0);
            textView.setTextColor(Color.parseColor("#888888"));
        } else {
            textView.setPadding(0, 0, 0, 0);
            textView.setTextColor(Color.parseColor("#484848"));
        }
        if (z) {
            inflate.findViewById(a.f.diliver).setVisibility(8);
        } else {
            inflate.findViewById(a.f.diliver).setVisibility(0);
        }
        this.g.addView(inflate);
        inflate.setOnClickListener(new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.a.f.3
            @Override // tv.chushou.zues.a
            public void dL(View view) {
                f.this.dismiss();
                cVar.nSH.a(cVar.c);
            }
        });
    }

    public void a(ChatInfo chatInfo, String str, boolean z) {
        e eVar = new e(z, str, this.i, this.g, this.d);
        eVar.a(chatInfo);
        this.j = eVar.a();
        if (this.d != null) {
            this.d.setText(chatInfo.mUserNickname);
        }
    }

    public void a(String str, String str2) {
        e eVar = new e(false, "", this.i, this.g, this.d);
        eVar.a(str, str2);
        this.j = eVar.a();
        if (this.d != null) {
            this.d.setText(str2);
        }
    }

    public void a(RoomInfo roomInfo) {
        a(roomInfo, (String) null);
    }

    public void a(RoomInfo roomInfo, String str) {
        d dVar = new d(this.d, this.i);
        dVar.a(roomInfo, str);
        this.j = dVar.a();
    }

    public void a() {
        if (this.h != null) {
            ViewGroup.LayoutParams layoutParams = this.h.getLayoutParams();
            layoutParams.width = tv.chushou.zues.utils.a.dip2px(this.i, 300.0f);
            this.h.setLayoutParams(layoutParams);
        }
    }
}

package com.kascend.chushou.player.a;

import android.content.Context;
import android.widget.TextView;
import com.kascend.chushou.a;
import com.kascend.chushou.constants.RoomInfo;
import com.kascend.chushou.player.a.c;
import java.util.List;
import tv.chushou.zues.widget.sweetalert.b;
/* loaded from: classes5.dex */
public class d extends a {
    private String f;
    private RoomInfo moH;

    public void a(RoomInfo roomInfo, String str) {
        this.moH = roomInfo;
        this.f = str;
    }

    public d(TextView textView, Context context) {
        super(textView, context);
    }

    public List<c> a() {
        a(this.c.getString(a.i.report_room));
        b();
        return this.a;
    }

    public void b() {
        this.a.clear();
        c.a aVar = new c.a() { // from class: com.kascend.chushou.player.a.d.1
            @Override // com.kascend.chushou.player.a.c.a
            public void a(int i) {
                d.this.b(i);
            }
        };
        this.a.add(new c(2, a.e.dialog_report, a.i.dialog_drag, false, aVar));
        this.a.add(new c(2, a.e.dialog_report, a.i.dialog_sex, false, aVar));
        if (!"4".equals(this.f)) {
            this.a.add(new c(2, a.e.dialog_report, a.i.dialog_thief, false, aVar));
        }
        this.a.add(new c(2, a.e.dialog_report, a.i.dialog_tagerror, false, aVar));
        if (!"4".equals(this.f)) {
            this.a.add(new c(2, a.e.dialog_report, a.i.dialog_plugin, false, aVar));
        }
        this.a.add(new c(2, a.e.dialog_report, a.i.dialog_long_time, false, aVar));
        this.a.add(new c(2, a.e.dialog_report, a.i.dialog_other, false, aVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final int i) {
        tv.chushou.zues.widget.sweetalert.b w = new tv.chushou.zues.widget.sweetalert.b(this.c).a(new b.a() { // from class: com.kascend.chushou.player.a.d.3
            @Override // tv.chushou.zues.widget.sweetalert.b.a
            public void onClick(tv.chushou.zues.widget.sweetalert.b bVar) {
                bVar.dismiss();
            }
        }).b(new b.a() { // from class: com.kascend.chushou.player.a.d.2
            @Override // tv.chushou.zues.widget.sweetalert.b.a
            public void onClick(tv.chushou.zues.widget.sweetalert.b bVar) {
                bVar.dKx();
                com.kascend.chushou.c.c.dwG().c(d.this.mny, null, d.this.moH.mRoomID, d.this.a(i) + "");
            }
        }).Qt(this.c.getString(a.i.alert_dialog_cancel)).Qv(this.c.getString(a.i.alert_dialog_ok)).w(this.c.getString(a.i.alert_dialog_report_room, this.moH.mName));
        w.getWindow().setLayout(tv.chushou.zues.utils.a.gh(this.c).x - (this.c.getResources().getDimensionPixelSize(a.d.alert_margin_h) * 2), -2);
        w.show();
    }
}

package com.kascend.chushou.player.a;

import android.content.Context;
import android.widget.TextView;
import com.kascend.chushou.a;
import com.kascend.chushou.constants.RoomInfo;
import com.kascend.chushou.player.a.c;
import java.util.List;
import tv.chushou.zues.widget.sweetalert.b;
/* loaded from: classes6.dex */
public class d extends a {
    private String f;
    private RoomInfo pkr;

    public void a(RoomInfo roomInfo, String str) {
        this.pkr = roomInfo;
        this.f = str;
    }

    public d(TextView textView, Context context) {
        super(textView, context);
    }

    public List<c> a() {
        a(this.c.getString(a.i.report_room));
        b();
        return this.f4109a;
    }

    public void b() {
        this.f4109a.clear();
        c.a aVar = new c.a() { // from class: com.kascend.chushou.player.a.d.1
            @Override // com.kascend.chushou.player.a.c.a
            public void a(int i) {
                d.this.b(i);
            }
        };
        this.f4109a.add(new c(2, a.e.dialog_report, a.i.dialog_drag, false, aVar));
        this.f4109a.add(new c(2, a.e.dialog_report, a.i.dialog_sex, false, aVar));
        if (!"4".equals(this.f)) {
            this.f4109a.add(new c(2, a.e.dialog_report, a.i.dialog_thief, false, aVar));
        }
        this.f4109a.add(new c(2, a.e.dialog_report, a.i.dialog_tagerror, false, aVar));
        if (!"4".equals(this.f)) {
            this.f4109a.add(new c(2, a.e.dialog_report, a.i.dialog_plugin, false, aVar));
        }
        this.f4109a.add(new c(2, a.e.dialog_report, a.i.dialog_long_time, false, aVar));
        this.f4109a.add(new c(2, a.e.dialog_report, a.i.dialog_other, false, aVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final int i) {
        tv.chushou.zues.widget.sweetalert.b E = new tv.chushou.zues.widget.sweetalert.b(this.c).a(new b.a() { // from class: com.kascend.chushou.player.a.d.3
            @Override // tv.chushou.zues.widget.sweetalert.b.a
            public void onClick(tv.chushou.zues.widget.sweetalert.b bVar) {
                bVar.dismiss();
            }
        }).b(new b.a() { // from class: com.kascend.chushou.player.a.d.2
            @Override // tv.chushou.zues.widget.sweetalert.b.a
            public void onClick(tv.chushou.zues.widget.sweetalert.b bVar) {
                bVar.eIq();
                com.kascend.chushou.c.c.etT().c(d.this.pjm, null, d.this.pkr.mRoomID, d.this.a(i) + "");
            }
        }).aaw(this.c.getString(a.i.alert_dialog_cancel)).aay(this.c.getString(a.i.alert_dialog_ok)).E(this.c.getString(a.i.alert_dialog_report_room, this.pkr.mName));
        E.getWindow().setLayout(tv.chushou.zues.utils.a.hB(this.c).x - (this.c.getResources().getDimensionPixelSize(a.d.alert_margin_h) * 2), -2);
        E.show();
    }
}

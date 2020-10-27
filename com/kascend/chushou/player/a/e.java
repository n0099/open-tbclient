package com.kascend.chushou.player.a;

import android.content.Context;
import android.graphics.Typeface;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.kascend.chushou.a;
import com.kascend.chushou.constants.ChatInfo;
import com.kascend.chushou.constants.ParserRet;
import com.kascend.chushou.player.a.c;
import java.util.List;
import org.json.JSONObject;
import tv.chushou.zues.utils.g;
import tv.chushou.zues.utils.h;
import tv.chushou.zues.widget.sweetalert.b;
/* loaded from: classes6.dex */
public class e extends a {
    private final int e;
    private final int f;
    private boolean g;
    private String h;
    private String j;
    private String k;
    private LinearLayout l;
    private ChatInfo oZs;

    public e(boolean z, String str, Context context, LinearLayout linearLayout, TextView textView) {
        super(textView, context);
        this.e = 1;
        this.f = 2;
        this.g = z;
        this.h = str;
        this.l = linearLayout;
    }

    public void a(ChatInfo chatInfo) {
        this.oZs = chatInfo;
        this.j = this.oZs.mUserID;
        this.k = this.oZs.mUserNickname;
    }

    public void a(String str, String str2) {
        this.j = str;
        this.k = str2;
    }

    public List<c> a() {
        this.f4107a.clear();
        if (this.g) {
            b(this.h);
            if (this.h.equals("1") || this.h.equals("3") || this.h.equals("2")) {
                if (this.oZs != null) {
                    a(this.oZs.mUserNickname);
                    this.b.setTypeface(Typeface.defaultFromStyle(0));
                }
            } else {
                a(this.c.getString(a.i.str_report_user));
                e();
            }
        } else {
            a(this.c.getString(a.i.str_report_user));
            b();
            e();
        }
        return this.f4107a;
    }

    private void b(String str) {
        if (!h.isEmpty(str)) {
            if (str.equals("2")) {
                if (this.oZs.mPrivilegeInfo.mRole.equals("1")) {
                    a(true);
                } else {
                    c();
                }
            } else if (str.equals("3")) {
                d();
            } else if (str.equals("1")) {
                if (this.oZs.mPrivilegeInfo.mRole.equals("2") || this.oZs.mPrivilegeInfo.mRole.equals("1")) {
                    b();
                    this.l.setVisibility(0);
                    return;
                }
                d();
            } else {
                b();
                this.l.setVisibility(0);
            }
        }
    }

    private void c() {
        this.f4107a.add(new c(1, a.e.dialog_add_admin, a.i.dialog_add_admin, false, new c.a() { // from class: com.kascend.chushou.player.a.e.1
            @Override // com.kascend.chushou.player.a.c.a
            public void a(int i) {
                e.this.i();
            }
        }));
        a(true);
    }

    private void d() {
        a(false);
    }

    private void a(boolean z) {
        this.l.setVisibility(8);
        this.f4107a.add(new c(1, a.e.dialog_forbid_oneday, a.i.dialog_forbid_one_day, false, new c.a() { // from class: com.kascend.chushou.player.a.e.3
            @Override // com.kascend.chushou.player.a.c.a
            public void a(int i) {
                e.this.g();
            }
        }));
        this.f4107a.add(new c(1, a.e.dialog_forbid_forever, a.i.dialog_forbid_forever, false, new c.a() { // from class: com.kascend.chushou.player.a.e.4
            @Override // com.kascend.chushou.player.a.c.a
            public void a(int i) {
                e.this.h();
            }
        }));
        if (z) {
            this.f4107a.add(new c(1, a.e.dialog_forbid_forever, a.i.dialog_add_blacklist, false, new c.a() { // from class: com.kascend.chushou.player.a.e.5
                @Override // com.kascend.chushou.player.a.c.a
                public void a(int i) {
                    e.this.j();
                }
            }));
        }
        this.f4107a.add(new c(1, a.e.dialog_report, a.i.dialog_report, true, new c.a() { // from class: com.kascend.chushou.player.a.e.6
            @Override // com.kascend.chushou.player.a.c.a
            public void a(int i) {
                if (e.this.l.isShown()) {
                    e.this.f();
                } else {
                    e.this.e();
                }
            }
        }));
        b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        int i = 0;
        this.l.setVisibility(0);
        while (true) {
            int i2 = i;
            if (i2 < this.f4107a.size()) {
                if (this.f4107a.get(i2).d == a.i.dialog_report) {
                    this.f4107a.get(i2).h = true;
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        this.l.setVisibility(8);
        for (int i = 0; i < this.f4107a.size(); i++) {
            if (this.f4107a.get(i).d == a.i.dialog_report) {
                this.f4107a.get(i).h = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        tv.chushou.zues.widget.sweetalert.b D = new tv.chushou.zues.widget.sweetalert.b(this.c).a(new b.a() { // from class: com.kascend.chushou.player.a.e.8
            @Override // tv.chushou.zues.widget.sweetalert.b.a
            public void onClick(tv.chushou.zues.widget.sweetalert.b bVar) {
                bVar.dismiss();
            }
        }).b(new b.a() { // from class: com.kascend.chushou.player.a.e.7
            @Override // tv.chushou.zues.widget.sweetalert.b.a
            public void onClick(tv.chushou.zues.widget.sweetalert.b bVar) {
                bVar.eEA();
                e.this.b(1);
            }
        }).aah(this.c.getString(a.i.alert_dialog_cancel)).aaj(this.c.getString(a.i.alert_dialog_ok)).D(this.c.getString(a.i.alert_dialog_forbid_check, this.oZs.mUserNickname));
        D.getWindow().setLayout(tv.chushou.zues.utils.a.hD(this.c).x - (this.c.getResources().getDimensionPixelSize(a.d.alert_margin_h) * 2), -2);
        D.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        tv.chushou.zues.widget.sweetalert.b D = new tv.chushou.zues.widget.sweetalert.b(this.c).a(new b.a() { // from class: com.kascend.chushou.player.a.e.10
            @Override // tv.chushou.zues.widget.sweetalert.b.a
            public void onClick(tv.chushou.zues.widget.sweetalert.b bVar) {
                bVar.dismiss();
            }
        }).b(new b.a() { // from class: com.kascend.chushou.player.a.e.9
            @Override // tv.chushou.zues.widget.sweetalert.b.a
            public void onClick(tv.chushou.zues.widget.sweetalert.b bVar) {
                bVar.eEA();
                e.this.b(2);
            }
        }).aah(this.c.getString(a.i.alert_dialog_cancel)).aaj(this.c.getString(a.i.alert_dialog_ok)).D(this.c.getString(a.i.alert_dialog_forbid_forever_check, this.oZs.mUserNickname));
        D.getWindow().setLayout(tv.chushou.zues.utils.a.hD(this.c).x - (this.c.getResources().getDimensionPixelSize(a.d.alert_margin_h) * 2), -2);
        D.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i) {
        com.kascend.chushou.c.c.eqe().a(this.oZs.mRoomID, this.oZs.mUserID, i, new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.a.e.11
            private ChatInfo oZu;

            @Override // com.kascend.chushou.c.b
            public void a() {
                this.oZu = e.this.oZs;
            }

            @Override // com.kascend.chushou.c.b
            public void a(String str, JSONObject jSONObject) {
                int optInt = jSONObject.optInt("code", -1);
                if (optInt == 0) {
                    g.d(e.this.c, e.this.c.getResources().getString(a.i.forbid_success, this.oZu.mUserNickname));
                } else if (optInt == 401) {
                    com.kascend.chushou.d.e.b(e.this.c, (String) null);
                } else {
                    String optString = jSONObject.optString("message", "");
                    if (h.isEmpty(optString)) {
                        optString = e.this.c.getResources().getString(a.i.forbid_failed, this.oZu.mUserNickname);
                    }
                    g.d(e.this.c, optString);
                }
            }

            @Override // com.kascend.chushou.c.b
            public void a(int i2, String str) {
                if (h.isEmpty(str)) {
                    str = e.this.c.getResources().getString(a.i.forbid_failed, this.oZu.mUserNickname);
                }
                g.d(e.this.c, str);
            }
        });
    }

    public void b() {
        c.a aVar = new c.a() { // from class: com.kascend.chushou.player.a.e.12
            @Override // com.kascend.chushou.player.a.c.a
            public void a(int i) {
                e.this.c(i);
            }
        };
        if (this.f4107a.size() > 0) {
            this.f4107a.add(new c(2, a.e.dialog_report, a.i.dialog_drag, a.i.dialog_report, false, false, true, aVar));
            this.f4107a.add(new c(2, a.e.dialog_report, a.i.dialog_sex, a.i.dialog_report, false, false, true, aVar));
            this.f4107a.add(new c(2, a.e.dialog_report, a.i.dialog_ad, a.i.dialog_report, false, false, true, aVar));
            this.f4107a.add(new c(2, a.e.dialog_report, a.i.dialog_plugin, a.i.dialog_report, false, false, true, aVar));
            this.f4107a.add(new c(2, a.e.dialog_report, a.i.dialog_other, a.i.dialog_report, false, false, true, aVar));
            return;
        }
        this.f4107a.add(new c(2, a.e.dialog_report, a.i.dialog_drag, a.i.dialog_report, false, false, false, aVar));
        this.f4107a.add(new c(2, a.e.dialog_report, a.i.dialog_sex, a.i.dialog_report, false, false, false, aVar));
        this.f4107a.add(new c(2, a.e.dialog_report, a.i.dialog_ad, a.i.dialog_report, false, false, false, aVar));
        this.f4107a.add(new c(2, a.e.dialog_report, a.i.dialog_plugin, a.i.dialog_report, false, false, false, aVar));
        this.f4107a.add(new c(2, a.e.dialog_report, a.i.dialog_other, a.i.dialog_report, false, false, false, aVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final int i) {
        tv.chushou.zues.widget.sweetalert.b D = new tv.chushou.zues.widget.sweetalert.b(this.c).a(new b.a() { // from class: com.kascend.chushou.player.a.e.14
            @Override // tv.chushou.zues.widget.sweetalert.b.a
            public void onClick(tv.chushou.zues.widget.sweetalert.b bVar) {
                bVar.dismiss();
            }
        }).b(new b.a() { // from class: com.kascend.chushou.player.a.e.13
            @Override // tv.chushou.zues.widget.sweetalert.b.a
            public void onClick(tv.chushou.zues.widget.sweetalert.b bVar) {
                bVar.eEA();
                com.kascend.chushou.c.c.eqe().c(e.this.oYl, e.this.j, null, e.this.a(i) + "");
            }
        }).aah(this.c.getString(a.i.alert_dialog_cancel)).aaj(this.c.getString(a.i.alert_dialog_ok)).D(this.c.getString(a.i.alert_dialog_report_user, this.k));
        D.getWindow().setLayout(tv.chushou.zues.utils.a.hD(this.c).x - (this.c.getResources().getDimensionPixelSize(a.d.alert_margin_h) * 2), -2);
        D.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        tv.chushou.zues.widget.sweetalert.b D = new tv.chushou.zues.widget.sweetalert.b(this.c).a(new b.a() { // from class: com.kascend.chushou.player.a.e.16
            @Override // tv.chushou.zues.widget.sweetalert.b.a
            public void onClick(tv.chushou.zues.widget.sweetalert.b bVar) {
                bVar.dismiss();
            }
        }).b(new b.a() { // from class: com.kascend.chushou.player.a.e.15
            @Override // tv.chushou.zues.widget.sweetalert.b.a
            public void onClick(tv.chushou.zues.widget.sweetalert.b bVar) {
                bVar.eEA();
                com.kascend.chushou.c.c.eqe().a(e.this.oZs.mRoomID, e.this.oZs.mUserID, new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.a.e.15.1
                    private ChatInfo oZu;

                    @Override // com.kascend.chushou.c.b
                    public void a() {
                        this.oZu = e.this.oZs;
                    }

                    @Override // com.kascend.chushou.c.b
                    public void a(String str, JSONObject jSONObject) {
                        int optInt = jSONObject.optInt("code", -1);
                        if (optInt == 0) {
                            g.d(e.this.c, e.this.c.getResources().getString(a.i.add_admin_success, this.oZu.mUserNickname));
                        } else if (optInt == -1) {
                            g.d(e.this.c, e.this.c.getResources().getString(a.i.add_admin_failed, this.oZu.mUserNickname));
                        } else {
                            g.d(e.this.c, jSONObject.optString("message"));
                        }
                    }

                    @Override // com.kascend.chushou.c.b
                    public void a(int i, String str) {
                        g.d(e.this.c, e.this.c.getResources().getString(a.i.add_admin_failed, this.oZu.mUserNickname));
                    }
                });
            }
        }).aah(this.c.getString(a.i.alert_dialog_cancel)).aaj(this.c.getString(a.i.alert_dialog_ok)).D(this.c.getString(a.i.alert_dialog_add_admin_check, this.oZs.mUserNickname));
        D.getWindow().setLayout(tv.chushou.zues.utils.a.hD(this.c).x - (this.c.getResources().getDimensionPixelSize(a.d.alert_margin_h) * 2), -2);
        D.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        tv.chushou.zues.widget.sweetalert.b D = new tv.chushou.zues.widget.sweetalert.b(this.c).a(new b.a() { // from class: com.kascend.chushou.player.a.e.18
            @Override // tv.chushou.zues.widget.sweetalert.b.a
            public void onClick(tv.chushou.zues.widget.sweetalert.b bVar) {
                bVar.dismiss();
            }
        }).b(new b.a() { // from class: com.kascend.chushou.player.a.e.17
            @Override // tv.chushou.zues.widget.sweetalert.b.a
            public void onClick(tv.chushou.zues.widget.sweetalert.b bVar) {
                bVar.eEA();
                e.this.k();
            }
        }).aah(this.c.getString(a.i.alert_dialog_cancel)).aaj(this.c.getString(a.i.alert_dialog_add_to_blacklist_confirm)).D(this.c.getString(a.i.alert_dialog_add_to_blacklist));
        D.getWindow().setLayout(tv.chushou.zues.utils.a.hD(this.c).x - (this.c.getResources().getDimensionPixelSize(a.d.alert_margin_h) * 2), -2);
        D.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        com.kascend.chushou.c.c.eqe().b(this.oZs.mRoomID, this.oZs.mUserID, new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.a.e.2
            @Override // com.kascend.chushou.c.b
            public void a() {
            }

            @Override // com.kascend.chushou.c.b
            public void a(String str, JSONObject jSONObject) {
                ParserRet eB = com.kascend.chushou.c.a.eB(jSONObject);
                if (eB.mRc == 0) {
                    g.d(e.this.c, e.this.c.getString(a.i.add_blacklist_success, e.this.oZs.mUserNickname));
                } else {
                    a(eB.mRc, eB.mMessage);
                }
            }

            @Override // com.kascend.chushou.c.b
            public void a(int i, String str) {
                if (h.isEmpty(str)) {
                    str = e.this.c.getString(a.i.add_blacklist_failed, e.this.oZs.mUserNickname);
                }
                g.d(e.this.c, str);
            }
        });
    }
}

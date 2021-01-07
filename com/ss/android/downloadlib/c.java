package com.ss.android.downloadlib;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.live.tbadk.pay.PayHelper;
import com.ss.android.a.a.d.c;
import com.ss.android.b.a.a.a;
import com.ss.android.b.a.a.b;
import com.ss.android.downloadlib.a.b.d;
import com.ss.android.downloadlib.a.j;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c implements com.ss.android.b.a.b {

    /* renamed from: a  reason: collision with root package name */
    private static String f13273a = c.class.getSimpleName();
    private static volatile c pWF;
    private i pWG = i.iz(j.a());

    private c() {
    }

    public static c eGv() {
        if (pWF == null) {
            synchronized (c.class) {
                if (pWF == null) {
                    pWF = new c();
                }
            }
        }
        return pWF;
    }

    @Override // com.ss.android.b.a.b
    public Dialog a(Context context, String str, boolean z, @NonNull final com.ss.android.a.a.b.c cVar, com.ss.android.a.a.b.b bVar, com.ss.android.a.a.b.a aVar, com.ss.android.a.a.b.d dVar, int i) {
        if (b(cVar.d())) {
            a(cVar.d());
            return null;
        } else if (context == null || TextUtils.isEmpty(cVar.a())) {
            return null;
        } else {
            this.pWG.a(context, i, dVar, cVar);
            final com.ss.android.a.a.b.b bVar2 = (com.ss.android.a.a.b.b) com.ss.android.downloadlib.f.i.M(bVar, eGx());
            final com.ss.android.a.a.b.a aVar2 = (com.ss.android.a.a.b.a) com.ss.android.downloadlib.f.i.M(aVar, eGw());
            if ((j.i().optInt("disable_lp_dialog", 0) == 1) | z) {
                this.pWG.a(cVar.a(), cVar.d(), 2, bVar2, aVar2);
                return null;
            }
            com.ss.android.downloadlib.f.h.i(f13273a, "tryStartDownload show dialog appName:" + cVar.a(), null);
            Dialog b2 = j.eGf().b(new c.a(context).aal(cVar.h()).aam("确认要下载此应用吗？").aan("确认").aao(PayHelper.STATUS_CANCEL_DESC).a(new c.b() { // from class: com.ss.android.downloadlib.c.1
                @Override // com.ss.android.a.a.d.c.b
                public void a(DialogInterface dialogInterface) {
                    c.this.pWG.a(cVar.a(), cVar.d(), 2, bVar2, aVar2);
                    com.ss.android.downloadlib.e.a.eGB().a("landing_download_dialog_confirm", cVar, bVar2);
                    dialogInterface.dismiss();
                }

                @Override // com.ss.android.a.a.d.c.b
                public void b(DialogInterface dialogInterface) {
                    com.ss.android.downloadlib.e.a.eGB().a("landing_download_dialog_cancel", cVar, bVar2);
                    dialogInterface.dismiss();
                }

                @Override // com.ss.android.a.a.d.c.b
                public void c(DialogInterface dialogInterface) {
                    com.ss.android.downloadlib.e.a.eGB().a("landing_download_dialog_cancel", cVar, bVar2);
                }
            }).RX(0).eFC());
            com.ss.android.downloadlib.e.a.eGB().a("landing_download_dialog_show", cVar, bVar2);
            return b2;
        }
    }

    @Override // com.ss.android.b.a.b
    public boolean a(Context context, long j, String str, com.ss.android.a.a.b.d dVar, int i) {
        com.ss.android.b.a.b.a jb = com.ss.android.downloadlib.a.b.d.eFT().jb(j);
        if (jb != null) {
            this.pWG.a(context, i, dVar, jb.eFL());
            return true;
        }
        com.ss.android.a.a.b.c iY = com.ss.android.downloadlib.a.b.d.eFT().iY(j);
        if (iY != null) {
            this.pWG.a(context, i, dVar, iY);
            return true;
        }
        return false;
    }

    public void a(long j) {
        com.ss.android.a.a.b.c iY = com.ss.android.downloadlib.a.b.d.eFT().iY(j);
        com.ss.android.b.a.b.a jb = com.ss.android.downloadlib.a.b.d.eFT().jb(j);
        com.ss.android.b.a.a.c eFL = (iY != null || jb == null) ? iY : jb.eFL();
        if (eFL != null) {
            if (jb == null) {
                this.pWG.a(eFL.a(), j, 2, eGx(), eGw());
            } else {
                this.pWG.a(eFL.a(), j, 2, new b.a().aat(jb.x()).aaB(jb.y()).BC(jb.u()).BA(false).aav("click_start_detail").aaw("click_pause_detail").aax("click_continue_detail").aay("click_install_detail").aaA("storage_deny_detail").eFF(), jb.eFN());
            }
        }
    }

    public boolean b(long j) {
        return (com.ss.android.downloadlib.a.b.d.eFT().iY(j) == null && com.ss.android.downloadlib.a.b.d.eFT().jb(j) == null) ? false : true;
    }

    public boolean a(Context context, Uri uri, com.ss.android.a.a.b.c cVar, com.ss.android.a.a.b.b bVar, com.ss.android.a.a.b.a aVar) {
        com.ss.android.a.a.b.a eGw;
        if (j.i().optInt("disable_market") == 1 || uri == null) {
            return false;
        }
        if (context == null) {
            context = j.a();
        }
        if (cVar == null) {
            return com.ss.android.downloadlib.f.f.h(context, uri).a() == 5;
        }
        com.ss.android.a.a.b.b bVar2 = (com.ss.android.a.a.b.b) com.ss.android.downloadlib.f.i.M(bVar, eGx());
        if ((cVar instanceof com.ss.android.b.a.a.c) && TextUtils.isEmpty(cVar.a())) {
            ((com.ss.android.b.a.a.c) cVar).aaD(uri.toString());
            eGw = BH(true);
        } else if (cVar.a().startsWith("market")) {
            eGw = BH(true);
        } else {
            eGw = eGw();
        }
        d.a aVar2 = new d.a(cVar.d(), cVar, bVar2, eGw);
        String queryParameter = uri.getQueryParameter("id");
        if (!TextUtils.isEmpty(queryParameter) && (cVar instanceof com.ss.android.b.a.a.c)) {
            ((com.ss.android.b.a.a.c) cVar).aaC(queryParameter);
        }
        if (com.ss.android.downloadlib.f.i.b(cVar) && com.ss.android.socialbase.downloader.k.a.eJW().b("app_link_opt") == 1 && com.ss.android.downloadlib.b.a.b(aVar2)) {
            return true;
        }
        com.ss.android.downloadlib.e.a.eGB().a("market_click_open", cVar, aVar2.pVx);
        com.ss.android.downloadlib.a.b.e bA = com.ss.android.downloadlib.f.f.bA(context, queryParameter);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("market_url", uri.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (bA.a() == 5) {
            com.ss.android.downloadlib.e.a.eGB().a("market_open_success", jSONObject, aVar2);
            j.eGe().a(context, aVar2.pVw, aVar2.pVy, aVar2.pVx, aVar2.pVw.v());
            com.ss.android.b.a.b.a aVar3 = new com.ss.android.b.a.b.a(aVar2.pVw, aVar2.pVx, aVar2.pVy);
            if (!TextUtils.isEmpty(queryParameter)) {
                aVar3.b(queryParameter);
            }
            aVar3.e(2);
            aVar3.f(System.currentTimeMillis());
            aVar3.h(4);
            com.ss.android.downloadlib.a.b.d.eFT().d(aVar3);
            return true;
        }
        try {
            jSONObject.put("error_code", bA.b());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        com.ss.android.downloadlib.e.a.eGB().a("market_open_failed", jSONObject, aVar2);
        return false;
    }

    @Override // com.ss.android.b.a.b
    public boolean a(Context context, Uri uri, com.ss.android.a.a.b.c cVar) {
        return a(context, uri, cVar, (com.ss.android.a.a.b.b) null, (com.ss.android.a.a.b.a) null);
    }

    public static com.ss.android.a.a.b.a eGw() {
        return BH(false);
    }

    public static com.ss.android.a.a.b.a BH(boolean z) {
        a.C1231a Bz = new a.C1231a().RZ(0).Bw(true).By(false).Bz(false);
        if (z) {
            Bz.Sa(2);
        } else {
            Bz.Sa(0);
        }
        return Bz.eFE();
    }

    public static com.ss.android.a.a.b.b eGx() {
        return new b.a().aat("landing_h5_download_ad_button").aau("landing_h5_download_ad_button").aav("click_start_detail").aaw("click_pause_detail").aax("click_continue_detail").aay("click_install_detail").aaz("click_open_detail").aaA("storage_deny_detail").Sb(1).BA(false).BB(true).BC(false).eFF();
    }
}

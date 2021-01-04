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
    private static String f13272a = c.class.getSimpleName();
    private static volatile c pUX;
    private i pUY = i.iz(j.a());

    private c() {
    }

    public static c eFR() {
        if (pUX == null) {
            synchronized (c.class) {
                if (pUX == null) {
                    pUX = new c();
                }
            }
        }
        return pUX;
    }

    @Override // com.ss.android.b.a.b
    public Dialog a(Context context, String str, boolean z, @NonNull final com.ss.android.a.a.b.c cVar, com.ss.android.a.a.b.b bVar, com.ss.android.a.a.b.a aVar, com.ss.android.a.a.b.d dVar, int i) {
        if (b(cVar.d())) {
            a(cVar.d());
            return null;
        } else if (context == null || TextUtils.isEmpty(cVar.a())) {
            return null;
        } else {
            this.pUY.a(context, i, dVar, cVar);
            final com.ss.android.a.a.b.b bVar2 = (com.ss.android.a.a.b.b) com.ss.android.downloadlib.f.i.M(bVar, eFT());
            final com.ss.android.a.a.b.a aVar2 = (com.ss.android.a.a.b.a) com.ss.android.downloadlib.f.i.M(aVar, eFS());
            if ((j.i().optInt("disable_lp_dialog", 0) == 1) | z) {
                this.pUY.a(cVar.a(), cVar.d(), 2, bVar2, aVar2);
                return null;
            }
            com.ss.android.downloadlib.f.h.i(f13272a, "tryStartDownload show dialog appName:" + cVar.a(), null);
            Dialog b2 = j.eFB().b(new c.a(context).aak(cVar.h()).aal("确认要下载此应用吗？").aam("确认").aan(PayHelper.STATUS_CANCEL_DESC).a(new c.b() { // from class: com.ss.android.downloadlib.c.1
                @Override // com.ss.android.a.a.d.c.b
                public void a(DialogInterface dialogInterface) {
                    c.this.pUY.a(cVar.a(), cVar.d(), 2, bVar2, aVar2);
                    com.ss.android.downloadlib.e.a.eFX().a("landing_download_dialog_confirm", cVar, bVar2);
                    dialogInterface.dismiss();
                }

                @Override // com.ss.android.a.a.d.c.b
                public void b(DialogInterface dialogInterface) {
                    com.ss.android.downloadlib.e.a.eFX().a("landing_download_dialog_cancel", cVar, bVar2);
                    dialogInterface.dismiss();
                }

                @Override // com.ss.android.a.a.d.c.b
                public void c(DialogInterface dialogInterface) {
                    com.ss.android.downloadlib.e.a.eFX().a("landing_download_dialog_cancel", cVar, bVar2);
                }
            }).RH(0).eEY());
            com.ss.android.downloadlib.e.a.eFX().a("landing_download_dialog_show", cVar, bVar2);
            return b2;
        }
    }

    @Override // com.ss.android.b.a.b
    public boolean a(Context context, long j, String str, com.ss.android.a.a.b.d dVar, int i) {
        com.ss.android.b.a.b.a iY = com.ss.android.downloadlib.a.b.d.eFp().iY(j);
        if (iY != null) {
            this.pUY.a(context, i, dVar, iY.eFh());
            return true;
        }
        com.ss.android.a.a.b.c iV = com.ss.android.downloadlib.a.b.d.eFp().iV(j);
        if (iV != null) {
            this.pUY.a(context, i, dVar, iV);
            return true;
        }
        return false;
    }

    public void a(long j) {
        com.ss.android.a.a.b.c iV = com.ss.android.downloadlib.a.b.d.eFp().iV(j);
        com.ss.android.b.a.b.a iY = com.ss.android.downloadlib.a.b.d.eFp().iY(j);
        com.ss.android.b.a.a.c eFh = (iV != null || iY == null) ? iV : iY.eFh();
        if (eFh != null) {
            if (iY == null) {
                this.pUY.a(eFh.a(), j, 2, eFT(), eFS());
            } else {
                this.pUY.a(eFh.a(), j, 2, new b.a().aas(iY.x()).aaA(iY.y()).BC(iY.u()).BA(false).aau("click_start_detail").aav("click_pause_detail").aaw("click_continue_detail").aax("click_install_detail").aaz("storage_deny_detail").eFb(), iY.eFj());
            }
        }
    }

    public boolean b(long j) {
        return (com.ss.android.downloadlib.a.b.d.eFp().iV(j) == null && com.ss.android.downloadlib.a.b.d.eFp().iY(j) == null) ? false : true;
    }

    public boolean a(Context context, Uri uri, com.ss.android.a.a.b.c cVar, com.ss.android.a.a.b.b bVar, com.ss.android.a.a.b.a aVar) {
        com.ss.android.a.a.b.a eFS;
        if (j.i().optInt("disable_market") == 1 || uri == null) {
            return false;
        }
        if (context == null) {
            context = j.a();
        }
        if (cVar == null) {
            return com.ss.android.downloadlib.f.f.h(context, uri).a() == 5;
        }
        com.ss.android.a.a.b.b bVar2 = (com.ss.android.a.a.b.b) com.ss.android.downloadlib.f.i.M(bVar, eFT());
        if ((cVar instanceof com.ss.android.b.a.a.c) && TextUtils.isEmpty(cVar.a())) {
            ((com.ss.android.b.a.a.c) cVar).aaC(uri.toString());
            eFS = BH(true);
        } else if (cVar.a().startsWith("market")) {
            eFS = BH(true);
        } else {
            eFS = eFS();
        }
        d.a aVar2 = new d.a(cVar.d(), cVar, bVar2, eFS);
        String queryParameter = uri.getQueryParameter("id");
        if (!TextUtils.isEmpty(queryParameter) && (cVar instanceof com.ss.android.b.a.a.c)) {
            ((com.ss.android.b.a.a.c) cVar).aaB(queryParameter);
        }
        if (com.ss.android.downloadlib.f.i.b(cVar) && com.ss.android.socialbase.downloader.k.a.eJs().b("app_link_opt") == 1 && com.ss.android.downloadlib.b.a.b(aVar2)) {
            return true;
        }
        com.ss.android.downloadlib.e.a.eFX().a("market_click_open", cVar, aVar2.pTP);
        com.ss.android.downloadlib.a.b.e bA = com.ss.android.downloadlib.f.f.bA(context, queryParameter);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("market_url", uri.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (bA.a() == 5) {
            com.ss.android.downloadlib.e.a.eFX().a("market_open_success", jSONObject, aVar2);
            j.eFA().a(context, aVar2.pTO, aVar2.pTQ, aVar2.pTP, aVar2.pTO.v());
            com.ss.android.b.a.b.a aVar3 = new com.ss.android.b.a.b.a(aVar2.pTO, aVar2.pTP, aVar2.pTQ);
            if (!TextUtils.isEmpty(queryParameter)) {
                aVar3.b(queryParameter);
            }
            aVar3.e(2);
            aVar3.f(System.currentTimeMillis());
            aVar3.h(4);
            com.ss.android.downloadlib.a.b.d.eFp().d(aVar3);
            return true;
        }
        try {
            jSONObject.put("error_code", bA.b());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        com.ss.android.downloadlib.e.a.eFX().a("market_open_failed", jSONObject, aVar2);
        return false;
    }

    @Override // com.ss.android.b.a.b
    public boolean a(Context context, Uri uri, com.ss.android.a.a.b.c cVar) {
        return a(context, uri, cVar, (com.ss.android.a.a.b.b) null, (com.ss.android.a.a.b.a) null);
    }

    public static com.ss.android.a.a.b.a eFS() {
        return BH(false);
    }

    public static com.ss.android.a.a.b.a BH(boolean z) {
        a.C1190a Bz = new a.C1190a().RJ(0).Bw(true).By(false).Bz(false);
        if (z) {
            Bz.RK(2);
        } else {
            Bz.RK(0);
        }
        return Bz.eFa();
    }

    public static com.ss.android.a.a.b.b eFT() {
        return new b.a().aas("landing_h5_download_ad_button").aat("landing_h5_download_ad_button").aau("click_start_detail").aav("click_pause_detail").aaw("click_continue_detail").aax("click_install_detail").aay("click_open_detail").aaz("storage_deny_detail").RL(1).BA(false).BB(true).BC(false).eFb();
    }
}

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
/* loaded from: classes6.dex */
public class c implements com.ss.android.b.a.b {

    /* renamed from: a  reason: collision with root package name */
    private static String f7721a = c.class.getSimpleName();
    private static volatile c qdw;
    private i qdx = i.iB(j.a());

    private c() {
    }

    public static c eFh() {
        if (qdw == null) {
            synchronized (c.class) {
                if (qdw == null) {
                    qdw = new c();
                }
            }
        }
        return qdw;
    }

    @Override // com.ss.android.b.a.b
    public Dialog a(Context context, String str, boolean z, @NonNull final com.ss.android.a.a.b.c cVar, com.ss.android.a.a.b.b bVar, com.ss.android.a.a.b.a aVar, com.ss.android.a.a.b.d dVar, int i) {
        if (b(cVar.d())) {
            a(cVar.d());
            return null;
        } else if (context == null || TextUtils.isEmpty(cVar.a())) {
            return null;
        } else {
            this.qdx.a(context, i, dVar, cVar);
            final com.ss.android.a.a.b.b bVar2 = (com.ss.android.a.a.b.b) com.ss.android.downloadlib.f.i.L(bVar, eFj());
            final com.ss.android.a.a.b.a aVar2 = (com.ss.android.a.a.b.a) com.ss.android.downloadlib.f.i.L(aVar, eFi());
            if ((j.i().optInt("disable_lp_dialog", 0) == 1) | z) {
                this.qdx.a(cVar.a(), cVar.d(), 2, bVar2, aVar2);
                return null;
            }
            com.ss.android.downloadlib.f.h.i(f7721a, "tryStartDownload show dialog appName:" + cVar.a(), null);
            Dialog b = j.eER().b(new c.a(context).aaw(cVar.h()).aax("确认要下载此应用吗？").aay("确认").aaz(PayHelper.STATUS_CANCEL_DESC).a(new c.b() { // from class: com.ss.android.downloadlib.c.1
                @Override // com.ss.android.a.a.d.c.b
                public void a(DialogInterface dialogInterface) {
                    c.this.qdx.a(cVar.a(), cVar.d(), 2, bVar2, aVar2);
                    com.ss.android.downloadlib.e.a.eFo().a("landing_download_dialog_confirm", cVar, bVar2);
                    dialogInterface.dismiss();
                }

                @Override // com.ss.android.a.a.d.c.b
                public void b(DialogInterface dialogInterface) {
                    com.ss.android.downloadlib.e.a.eFo().a("landing_download_dialog_cancel", cVar, bVar2);
                    dialogInterface.dismiss();
                }

                @Override // com.ss.android.a.a.d.c.b
                public void c(DialogInterface dialogInterface) {
                    com.ss.android.downloadlib.e.a.eFo().a("landing_download_dialog_cancel", cVar, bVar2);
                }
            }).QQ(0).eEo());
            com.ss.android.downloadlib.e.a.eFo().a("landing_download_dialog_show", cVar, bVar2);
            return b;
        }
    }

    @Override // com.ss.android.b.a.b
    public boolean a(Context context, long j, String str, com.ss.android.a.a.b.d dVar, int i) {
        com.ss.android.b.a.b.a je = com.ss.android.downloadlib.a.b.d.eEF().je(j);
        if (je != null) {
            this.qdx.a(context, i, dVar, je.eEx());
            return true;
        }
        com.ss.android.a.a.b.c jb = com.ss.android.downloadlib.a.b.d.eEF().jb(j);
        if (jb != null) {
            this.qdx.a(context, i, dVar, jb);
            return true;
        }
        return false;
    }

    public void a(long j) {
        com.ss.android.a.a.b.c jb = com.ss.android.downloadlib.a.b.d.eEF().jb(j);
        com.ss.android.b.a.b.a je = com.ss.android.downloadlib.a.b.d.eEF().je(j);
        com.ss.android.b.a.a.c eEx = (jb != null || je == null) ? jb : je.eEx();
        if (eEx != null) {
            if (je == null) {
                this.qdx.a(eEx.a(), j, 2, eFj(), eFi());
            } else {
                this.qdx.a(eEx.a(), j, 2, new b.a().aaE(je.x()).aaM(je.y()).BQ(je.u()).BO(false).aaG("click_start_detail").aaH("click_pause_detail").aaI("click_continue_detail").aaJ("click_install_detail").aaL("storage_deny_detail").eEr(), je.eEz());
            }
        }
    }

    public boolean b(long j) {
        return (com.ss.android.downloadlib.a.b.d.eEF().jb(j) == null && com.ss.android.downloadlib.a.b.d.eEF().je(j) == null) ? false : true;
    }

    @Override // com.ss.android.b.a.b
    public boolean a(Context context, Uri uri, com.ss.android.a.a.b.c cVar, com.ss.android.a.a.b.b bVar, com.ss.android.a.a.b.a aVar) {
        com.ss.android.a.a.b.a eFi;
        if (!com.ss.android.downloadlib.b.b.a(uri) || j.i().optInt("disable_market") == 1) {
            return false;
        }
        if (context == null) {
            context = j.a();
        }
        String ai = com.ss.android.downloadlib.b.b.ai(uri);
        if (cVar == null) {
            return com.ss.android.downloadlib.f.f.bx(context, ai).a() == 5;
        }
        if (aVar != null) {
            aVar.a(2);
            eFi = aVar;
        } else if ((cVar instanceof com.ss.android.b.a.a.c) && TextUtils.isEmpty(cVar.a())) {
            ((com.ss.android.b.a.a.c) cVar).aaO(uri.toString());
            eFi = BV(true);
        } else if (cVar.a().startsWith("market")) {
            eFi = BV(true);
        } else {
            eFi = eFi();
        }
        d.a aVar2 = new d.a(cVar.d(), cVar, (com.ss.android.a.a.b.b) com.ss.android.downloadlib.f.i.L(bVar, eFj()), eFi);
        if (!TextUtils.isEmpty(ai) && (cVar instanceof com.ss.android.b.a.a.c)) {
            ((com.ss.android.b.a.a.c) cVar).aaN(ai);
        }
        if (com.ss.android.downloadlib.f.i.b(cVar) && com.ss.android.socialbase.downloader.k.a.eIH().b("app_link_opt") == 1 && com.ss.android.downloadlib.b.a.b(aVar2)) {
            return true;
        }
        com.ss.android.downloadlib.e.a.eFo().a("market_click_open", cVar, aVar2.qcp);
        com.ss.android.downloadlib.a.b.e bx = com.ss.android.downloadlib.f.f.bx(context, ai);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("market_url", uri.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (bx.a() == 5) {
            com.ss.android.downloadlib.e.a.eFo().a("market_open_success", jSONObject, aVar2);
            j.eEQ().a(context, aVar2.qco, aVar2.qcq, aVar2.qcp, aVar2.qco.v());
            com.ss.android.b.a.b.a aVar3 = new com.ss.android.b.a.b.a(aVar2.qco, aVar2.qcp, aVar2.qcq);
            if (!TextUtils.isEmpty(ai)) {
                aVar3.b(ai);
            }
            aVar3.e(2);
            aVar3.f(System.currentTimeMillis());
            aVar3.h(4);
            com.ss.android.downloadlib.a.b.d.eEF().d(aVar3);
            return true;
        }
        try {
            jSONObject.put("error_code", bx.b());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        com.ss.android.downloadlib.e.a.eFo().a("market_open_failed", jSONObject, aVar2);
        return false;
    }

    public static com.ss.android.a.a.b.a eFi() {
        return BV(false);
    }

    public static com.ss.android.a.a.b.a BV(boolean z) {
        a.C1210a BN = new a.C1210a().QS(0).BK(true).BM(false).BN(false);
        if (z) {
            BN.QT(2);
        } else {
            BN.QT(0);
        }
        return BN.eEq();
    }

    public static com.ss.android.a.a.b.b eFj() {
        return new b.a().aaE("landing_h5_download_ad_button").aaF("landing_h5_download_ad_button").aaG("click_start_detail").aaH("click_pause_detail").aaI("click_continue_detail").aaJ("click_install_detail").aaK("click_open_detail").aaL("storage_deny_detail").QU(1).BO(false).BP(true).BQ(false).eEr();
    }
}

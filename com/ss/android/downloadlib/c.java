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
    private static String f12975a = c.class.getSimpleName();
    private static volatile c qcj;
    private i qck = i.iA(j.a());

    private c() {
    }

    public static c eEV() {
        if (qcj == null) {
            synchronized (c.class) {
                if (qcj == null) {
                    qcj = new c();
                }
            }
        }
        return qcj;
    }

    @Override // com.ss.android.b.a.b
    public Dialog a(Context context, String str, boolean z, @NonNull final com.ss.android.a.a.b.c cVar, com.ss.android.a.a.b.b bVar, com.ss.android.a.a.b.a aVar, com.ss.android.a.a.b.d dVar, int i) {
        if (b(cVar.d())) {
            a(cVar.d());
            return null;
        } else if (context == null || TextUtils.isEmpty(cVar.a())) {
            return null;
        } else {
            this.qck.a(context, i, dVar, cVar);
            final com.ss.android.a.a.b.b bVar2 = (com.ss.android.a.a.b.b) com.ss.android.downloadlib.f.i.M(bVar, eEX());
            final com.ss.android.a.a.b.a aVar2 = (com.ss.android.a.a.b.a) com.ss.android.downloadlib.f.i.M(aVar, eEW());
            if ((j.i().optInt("disable_lp_dialog", 0) == 1) | z) {
                this.qck.a(cVar.a(), cVar.d(), 2, bVar2, aVar2);
                return null;
            }
            com.ss.android.downloadlib.f.h.i(f12975a, "tryStartDownload show dialog appName:" + cVar.a(), null);
            Dialog b2 = j.eEF().b(new c.a(context).aaf(cVar.h()).aag("确认要下载此应用吗？").aah("确认").aai(PayHelper.STATUS_CANCEL_DESC).a(new c.b() { // from class: com.ss.android.downloadlib.c.1
                @Override // com.ss.android.a.a.d.c.b
                public void a(DialogInterface dialogInterface) {
                    c.this.qck.a(cVar.a(), cVar.d(), 2, bVar2, aVar2);
                    com.ss.android.downloadlib.e.a.eFc().a("landing_download_dialog_confirm", cVar, bVar2);
                    dialogInterface.dismiss();
                }

                @Override // com.ss.android.a.a.d.c.b
                public void b(DialogInterface dialogInterface) {
                    com.ss.android.downloadlib.e.a.eFc().a("landing_download_dialog_cancel", cVar, bVar2);
                    dialogInterface.dismiss();
                }

                @Override // com.ss.android.a.a.d.c.b
                public void c(DialogInterface dialogInterface) {
                    com.ss.android.downloadlib.e.a.eFc().a("landing_download_dialog_cancel", cVar, bVar2);
                }
            }).QL(0).eEc());
            com.ss.android.downloadlib.e.a.eFc().a("landing_download_dialog_show", cVar, bVar2);
            return b2;
        }
    }

    @Override // com.ss.android.b.a.b
    public boolean a(Context context, long j, String str, com.ss.android.a.a.b.d dVar, int i) {
        com.ss.android.b.a.b.a je = com.ss.android.downloadlib.a.b.d.eEt().je(j);
        if (je != null) {
            this.qck.a(context, i, dVar, je.eEl());
            return true;
        }
        com.ss.android.a.a.b.c jb = com.ss.android.downloadlib.a.b.d.eEt().jb(j);
        if (jb != null) {
            this.qck.a(context, i, dVar, jb);
            return true;
        }
        return false;
    }

    public void a(long j) {
        com.ss.android.a.a.b.c jb = com.ss.android.downloadlib.a.b.d.eEt().jb(j);
        com.ss.android.b.a.b.a je = com.ss.android.downloadlib.a.b.d.eEt().je(j);
        com.ss.android.b.a.a.c eEl = (jb != null || je == null) ? jb : je.eEl();
        if (eEl != null) {
            if (je == null) {
                this.qck.a(eEl.a(), j, 2, eEX(), eEW());
            } else {
                this.qck.a(eEl.a(), j, 2, new b.a().aan(je.x()).aav(je.y()).BS(je.u()).BQ(false).aap("click_start_detail").aaq("click_pause_detail").aar("click_continue_detail").aas("click_install_detail").aau("storage_deny_detail").eEf(), je.eEn());
            }
        }
    }

    public boolean b(long j) {
        return (com.ss.android.downloadlib.a.b.d.eEt().jb(j) == null && com.ss.android.downloadlib.a.b.d.eEt().je(j) == null) ? false : true;
    }

    public boolean a(Context context, Uri uri, com.ss.android.a.a.b.c cVar, com.ss.android.a.a.b.b bVar, com.ss.android.a.a.b.a aVar) {
        com.ss.android.a.a.b.a eEW;
        if (j.i().optInt("disable_market") == 1 || uri == null) {
            return false;
        }
        if (context == null) {
            context = j.a();
        }
        if (cVar == null) {
            return com.ss.android.downloadlib.f.f.h(context, uri).a() == 5;
        }
        com.ss.android.a.a.b.b bVar2 = (com.ss.android.a.a.b.b) com.ss.android.downloadlib.f.i.M(bVar, eEX());
        if ((cVar instanceof com.ss.android.b.a.a.c) && TextUtils.isEmpty(cVar.a())) {
            ((com.ss.android.b.a.a.c) cVar).aax(uri.toString());
            eEW = BX(true);
        } else if (cVar.a().startsWith("market")) {
            eEW = BX(true);
        } else {
            eEW = eEW();
        }
        d.a aVar2 = new d.a(cVar.d(), cVar, bVar2, eEW);
        String queryParameter = uri.getQueryParameter("id");
        if (!TextUtils.isEmpty(queryParameter) && (cVar instanceof com.ss.android.b.a.a.c)) {
            ((com.ss.android.b.a.a.c) cVar).aaw(queryParameter);
        }
        if (com.ss.android.downloadlib.f.i.b(cVar) && com.ss.android.socialbase.downloader.k.a.eIx().b("app_link_opt") == 1 && com.ss.android.downloadlib.b.a.b(aVar2)) {
            return true;
        }
        com.ss.android.downloadlib.e.a.eFc().a("market_click_open", cVar, aVar2.qbb);
        com.ss.android.downloadlib.a.b.e bz = com.ss.android.downloadlib.f.f.bz(context, queryParameter);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("market_url", uri.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (bz.a() == 5) {
            com.ss.android.downloadlib.e.a.eFc().a("market_open_success", jSONObject, aVar2);
            j.eEE().a(context, aVar2.qba, aVar2.qbc, aVar2.qbb, aVar2.qba.v());
            com.ss.android.b.a.b.a aVar3 = new com.ss.android.b.a.b.a(aVar2.qba, aVar2.qbb, aVar2.qbc);
            if (!TextUtils.isEmpty(queryParameter)) {
                aVar3.b(queryParameter);
            }
            aVar3.e(2);
            aVar3.f(System.currentTimeMillis());
            aVar3.h(4);
            com.ss.android.downloadlib.a.b.d.eEt().d(aVar3);
            return true;
        }
        try {
            jSONObject.put("error_code", bz.b());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        com.ss.android.downloadlib.e.a.eFc().a("market_open_failed", jSONObject, aVar2);
        return false;
    }

    @Override // com.ss.android.b.a.b
    public boolean a(Context context, Uri uri, com.ss.android.a.a.b.c cVar) {
        return a(context, uri, cVar, (com.ss.android.a.a.b.b) null, (com.ss.android.a.a.b.a) null);
    }

    public static com.ss.android.a.a.b.a eEW() {
        return BX(false);
    }

    public static com.ss.android.a.a.b.a BX(boolean z) {
        a.C1218a BP = new a.C1218a().QN(0).BM(true).BO(false).BP(false);
        if (z) {
            BP.QO(2);
        } else {
            BP.QO(0);
        }
        return BP.eEe();
    }

    public static com.ss.android.a.a.b.b eEX() {
        return new b.a().aan("landing_h5_download_ad_button").aao("landing_h5_download_ad_button").aap("click_start_detail").aaq("click_pause_detail").aar("click_continue_detail").aas("click_install_detail").aat("click_open_detail").aau("storage_deny_detail").QP(1).BQ(false).BR(true).BS(false).eEf();
    }
}

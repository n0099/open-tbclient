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
    private static volatile c qcJ;
    private i qcK = i.iA(j.a());

    private c() {
    }

    public static c eFd() {
        if (qcJ == null) {
            synchronized (c.class) {
                if (qcJ == null) {
                    qcJ = new c();
                }
            }
        }
        return qcJ;
    }

    @Override // com.ss.android.b.a.b
    public Dialog a(Context context, String str, boolean z, @NonNull final com.ss.android.a.a.b.c cVar, com.ss.android.a.a.b.b bVar, com.ss.android.a.a.b.a aVar, com.ss.android.a.a.b.d dVar, int i) {
        if (b(cVar.d())) {
            a(cVar.d());
            return null;
        } else if (context == null || TextUtils.isEmpty(cVar.a())) {
            return null;
        } else {
            this.qcK.a(context, i, dVar, cVar);
            final com.ss.android.a.a.b.b bVar2 = (com.ss.android.a.a.b.b) com.ss.android.downloadlib.f.i.M(bVar, eFf());
            final com.ss.android.a.a.b.a aVar2 = (com.ss.android.a.a.b.a) com.ss.android.downloadlib.f.i.M(aVar, eFe());
            if ((j.i().optInt("disable_lp_dialog", 0) == 1) | z) {
                this.qcK.a(cVar.a(), cVar.d(), 2, bVar2, aVar2);
                return null;
            }
            com.ss.android.downloadlib.f.h.i(f12975a, "tryStartDownload show dialog appName:" + cVar.a(), null);
            Dialog b2 = j.eEN().b(new c.a(context).aar(cVar.h()).aas("确认要下载此应用吗？").aat("确认").aau(PayHelper.STATUS_CANCEL_DESC).a(new c.b() { // from class: com.ss.android.downloadlib.c.1
                @Override // com.ss.android.a.a.d.c.b
                public void a(DialogInterface dialogInterface) {
                    c.this.qcK.a(cVar.a(), cVar.d(), 2, bVar2, aVar2);
                    com.ss.android.downloadlib.e.a.eFk().a("landing_download_dialog_confirm", cVar, bVar2);
                    dialogInterface.dismiss();
                }

                @Override // com.ss.android.a.a.d.c.b
                public void b(DialogInterface dialogInterface) {
                    com.ss.android.downloadlib.e.a.eFk().a("landing_download_dialog_cancel", cVar, bVar2);
                    dialogInterface.dismiss();
                }

                @Override // com.ss.android.a.a.d.c.b
                public void c(DialogInterface dialogInterface) {
                    com.ss.android.downloadlib.e.a.eFk().a("landing_download_dialog_cancel", cVar, bVar2);
                }
            }).QM(0).eEk());
            com.ss.android.downloadlib.e.a.eFk().a("landing_download_dialog_show", cVar, bVar2);
            return b2;
        }
    }

    @Override // com.ss.android.b.a.b
    public boolean a(Context context, long j, String str, com.ss.android.a.a.b.d dVar, int i) {
        com.ss.android.b.a.b.a je = com.ss.android.downloadlib.a.b.d.eEB().je(j);
        if (je != null) {
            this.qcK.a(context, i, dVar, je.eEt());
            return true;
        }
        com.ss.android.a.a.b.c jb = com.ss.android.downloadlib.a.b.d.eEB().jb(j);
        if (jb != null) {
            this.qcK.a(context, i, dVar, jb);
            return true;
        }
        return false;
    }

    public void a(long j) {
        com.ss.android.a.a.b.c jb = com.ss.android.downloadlib.a.b.d.eEB().jb(j);
        com.ss.android.b.a.b.a je = com.ss.android.downloadlib.a.b.d.eEB().je(j);
        com.ss.android.b.a.a.c eEt = (jb != null || je == null) ? jb : je.eEt();
        if (eEt != null) {
            if (je == null) {
                this.qcK.a(eEt.a(), j, 2, eFf(), eFe());
            } else {
                this.qcK.a(eEt.a(), j, 2, new b.a().aaz(je.x()).aaH(je.y()).BS(je.u()).BQ(false).aaB("click_start_detail").aaC("click_pause_detail").aaD("click_continue_detail").aaE("click_install_detail").aaG("storage_deny_detail").eEn(), je.eEv());
            }
        }
    }

    public boolean b(long j) {
        return (com.ss.android.downloadlib.a.b.d.eEB().jb(j) == null && com.ss.android.downloadlib.a.b.d.eEB().je(j) == null) ? false : true;
    }

    public boolean a(Context context, Uri uri, com.ss.android.a.a.b.c cVar, com.ss.android.a.a.b.b bVar, com.ss.android.a.a.b.a aVar) {
        com.ss.android.a.a.b.a eFe;
        if (j.i().optInt("disable_market") == 1 || uri == null) {
            return false;
        }
        if (context == null) {
            context = j.a();
        }
        if (cVar == null) {
            return com.ss.android.downloadlib.f.f.h(context, uri).a() == 5;
        }
        com.ss.android.a.a.b.b bVar2 = (com.ss.android.a.a.b.b) com.ss.android.downloadlib.f.i.M(bVar, eFf());
        if ((cVar instanceof com.ss.android.b.a.a.c) && TextUtils.isEmpty(cVar.a())) {
            ((com.ss.android.b.a.a.c) cVar).aaJ(uri.toString());
            eFe = BX(true);
        } else if (cVar.a().startsWith("market")) {
            eFe = BX(true);
        } else {
            eFe = eFe();
        }
        d.a aVar2 = new d.a(cVar.d(), cVar, bVar2, eFe);
        String queryParameter = uri.getQueryParameter("id");
        if (!TextUtils.isEmpty(queryParameter) && (cVar instanceof com.ss.android.b.a.a.c)) {
            ((com.ss.android.b.a.a.c) cVar).aaI(queryParameter);
        }
        if (com.ss.android.downloadlib.f.i.b(cVar) && com.ss.android.socialbase.downloader.k.a.eIF().b("app_link_opt") == 1 && com.ss.android.downloadlib.b.a.b(aVar2)) {
            return true;
        }
        com.ss.android.downloadlib.e.a.eFk().a("market_click_open", cVar, aVar2.qbB);
        com.ss.android.downloadlib.a.b.e by = com.ss.android.downloadlib.f.f.by(context, queryParameter);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("market_url", uri.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (by.a() == 5) {
            com.ss.android.downloadlib.e.a.eFk().a("market_open_success", jSONObject, aVar2);
            j.eEM().a(context, aVar2.qbA, aVar2.qbC, aVar2.qbB, aVar2.qbA.v());
            com.ss.android.b.a.b.a aVar3 = new com.ss.android.b.a.b.a(aVar2.qbA, aVar2.qbB, aVar2.qbC);
            if (!TextUtils.isEmpty(queryParameter)) {
                aVar3.b(queryParameter);
            }
            aVar3.e(2);
            aVar3.f(System.currentTimeMillis());
            aVar3.h(4);
            com.ss.android.downloadlib.a.b.d.eEB().d(aVar3);
            return true;
        }
        try {
            jSONObject.put("error_code", by.b());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        com.ss.android.downloadlib.e.a.eFk().a("market_open_failed", jSONObject, aVar2);
        return false;
    }

    @Override // com.ss.android.b.a.b
    public boolean a(Context context, Uri uri, com.ss.android.a.a.b.c cVar) {
        return a(context, uri, cVar, (com.ss.android.a.a.b.b) null, (com.ss.android.a.a.b.a) null);
    }

    public static com.ss.android.a.a.b.a eFe() {
        return BX(false);
    }

    public static com.ss.android.a.a.b.a BX(boolean z) {
        a.C1220a BP = new a.C1220a().QO(0).BM(true).BO(false).BP(false);
        if (z) {
            BP.QP(2);
        } else {
            BP.QP(0);
        }
        return BP.eEm();
    }

    public static com.ss.android.a.a.b.b eFf() {
        return new b.a().aaz("landing_h5_download_ad_button").aaA("landing_h5_download_ad_button").aaB("click_start_detail").aaC("click_pause_detail").aaD("click_continue_detail").aaE("click_install_detail").aaF("click_open_detail").aaG("storage_deny_detail").QQ(1).BQ(false).BR(true).BS(false).eEn();
    }
}

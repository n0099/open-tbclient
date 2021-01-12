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
    private static String f12973a = c.class.getSimpleName();
    private static volatile c pSe;
    private i pSf = i.ix(j.a());

    private c() {
    }

    public static c eCE() {
        if (pSe == null) {
            synchronized (c.class) {
                if (pSe == null) {
                    pSe = new c();
                }
            }
        }
        return pSe;
    }

    @Override // com.ss.android.b.a.b
    public Dialog a(Context context, String str, boolean z, @NonNull final com.ss.android.a.a.b.c cVar, com.ss.android.a.a.b.b bVar, com.ss.android.a.a.b.a aVar, com.ss.android.a.a.b.d dVar, int i) {
        if (b(cVar.d())) {
            a(cVar.d());
            return null;
        } else if (context == null || TextUtils.isEmpty(cVar.a())) {
            return null;
        } else {
            this.pSf.a(context, i, dVar, cVar);
            final com.ss.android.a.a.b.b bVar2 = (com.ss.android.a.a.b.b) com.ss.android.downloadlib.f.i.M(bVar, eCG());
            final com.ss.android.a.a.b.a aVar2 = (com.ss.android.a.a.b.a) com.ss.android.downloadlib.f.i.M(aVar, eCF());
            if ((j.i().optInt("disable_lp_dialog", 0) == 1) | z) {
                this.pSf.a(cVar.a(), cVar.d(), 2, bVar2, aVar2);
                return null;
            }
            com.ss.android.downloadlib.f.h.i(f12973a, "tryStartDownload show dialog appName:" + cVar.a(), null);
            Dialog b2 = j.eCo().b(new c.a(context).Zd(cVar.h()).Ze("确认要下载此应用吗？").Zf("确认").Zg(PayHelper.STATUS_CANCEL_DESC).a(new c.b() { // from class: com.ss.android.downloadlib.c.1
                @Override // com.ss.android.a.a.d.c.b
                public void a(DialogInterface dialogInterface) {
                    c.this.pSf.a(cVar.a(), cVar.d(), 2, bVar2, aVar2);
                    com.ss.android.downloadlib.e.a.eCL().a("landing_download_dialog_confirm", cVar, bVar2);
                    dialogInterface.dismiss();
                }

                @Override // com.ss.android.a.a.d.c.b
                public void b(DialogInterface dialogInterface) {
                    com.ss.android.downloadlib.e.a.eCL().a("landing_download_dialog_cancel", cVar, bVar2);
                    dialogInterface.dismiss();
                }

                @Override // com.ss.android.a.a.d.c.b
                public void c(DialogInterface dialogInterface) {
                    com.ss.android.downloadlib.e.a.eCL().a("landing_download_dialog_cancel", cVar, bVar2);
                }
            }).Qq(0).eBL());
            com.ss.android.downloadlib.e.a.eCL().a("landing_download_dialog_show", cVar, bVar2);
            return b2;
        }
    }

    @Override // com.ss.android.b.a.b
    public boolean a(Context context, long j, String str, com.ss.android.a.a.b.d dVar, int i) {
        com.ss.android.b.a.b.a jb = com.ss.android.downloadlib.a.b.d.eCc().jb(j);
        if (jb != null) {
            this.pSf.a(context, i, dVar, jb.eBU());
            return true;
        }
        com.ss.android.a.a.b.c iY = com.ss.android.downloadlib.a.b.d.eCc().iY(j);
        if (iY != null) {
            this.pSf.a(context, i, dVar, iY);
            return true;
        }
        return false;
    }

    public void a(long j) {
        com.ss.android.a.a.b.c iY = com.ss.android.downloadlib.a.b.d.eCc().iY(j);
        com.ss.android.b.a.b.a jb = com.ss.android.downloadlib.a.b.d.eCc().jb(j);
        com.ss.android.b.a.a.c eBU = (iY != null || jb == null) ? iY : jb.eBU();
        if (eBU != null) {
            if (jb == null) {
                this.pSf.a(eBU.a(), j, 2, eCG(), eCF());
            } else {
                this.pSf.a(eBU.a(), j, 2, new b.a().Zl(jb.x()).Zt(jb.y()).By(jb.u()).Bw(false).Zn("click_start_detail").Zo("click_pause_detail").Zp("click_continue_detail").Zq("click_install_detail").Zs("storage_deny_detail").eBO(), jb.eBW());
            }
        }
    }

    public boolean b(long j) {
        return (com.ss.android.downloadlib.a.b.d.eCc().iY(j) == null && com.ss.android.downloadlib.a.b.d.eCc().jb(j) == null) ? false : true;
    }

    public boolean a(Context context, Uri uri, com.ss.android.a.a.b.c cVar, com.ss.android.a.a.b.b bVar, com.ss.android.a.a.b.a aVar) {
        com.ss.android.a.a.b.a eCF;
        if (j.i().optInt("disable_market") == 1 || uri == null) {
            return false;
        }
        if (context == null) {
            context = j.a();
        }
        if (cVar == null) {
            return com.ss.android.downloadlib.f.f.h(context, uri).a() == 5;
        }
        com.ss.android.a.a.b.b bVar2 = (com.ss.android.a.a.b.b) com.ss.android.downloadlib.f.i.M(bVar, eCG());
        if ((cVar instanceof com.ss.android.b.a.a.c) && TextUtils.isEmpty(cVar.a())) {
            ((com.ss.android.b.a.a.c) cVar).Zv(uri.toString());
            eCF = BD(true);
        } else if (cVar.a().startsWith("market")) {
            eCF = BD(true);
        } else {
            eCF = eCF();
        }
        d.a aVar2 = new d.a(cVar.d(), cVar, bVar2, eCF);
        String queryParameter = uri.getQueryParameter("id");
        if (!TextUtils.isEmpty(queryParameter) && (cVar instanceof com.ss.android.b.a.a.c)) {
            ((com.ss.android.b.a.a.c) cVar).Zu(queryParameter);
        }
        if (com.ss.android.downloadlib.f.i.b(cVar) && com.ss.android.socialbase.downloader.k.a.eGg().b("app_link_opt") == 1 && com.ss.android.downloadlib.b.a.b(aVar2)) {
            return true;
        }
        com.ss.android.downloadlib.e.a.eCL().a("market_click_open", cVar, aVar2.pQW);
        com.ss.android.downloadlib.a.b.e bA = com.ss.android.downloadlib.f.f.bA(context, queryParameter);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("market_url", uri.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (bA.a() == 5) {
            com.ss.android.downloadlib.e.a.eCL().a("market_open_success", jSONObject, aVar2);
            j.eCn().a(context, aVar2.pQV, aVar2.pQX, aVar2.pQW, aVar2.pQV.v());
            com.ss.android.b.a.b.a aVar3 = new com.ss.android.b.a.b.a(aVar2.pQV, aVar2.pQW, aVar2.pQX);
            if (!TextUtils.isEmpty(queryParameter)) {
                aVar3.b(queryParameter);
            }
            aVar3.e(2);
            aVar3.f(System.currentTimeMillis());
            aVar3.h(4);
            com.ss.android.downloadlib.a.b.d.eCc().d(aVar3);
            return true;
        }
        try {
            jSONObject.put("error_code", bA.b());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        com.ss.android.downloadlib.e.a.eCL().a("market_open_failed", jSONObject, aVar2);
        return false;
    }

    @Override // com.ss.android.b.a.b
    public boolean a(Context context, Uri uri, com.ss.android.a.a.b.c cVar) {
        return a(context, uri, cVar, (com.ss.android.a.a.b.b) null, (com.ss.android.a.a.b.a) null);
    }

    public static com.ss.android.a.a.b.a eCF() {
        return BD(false);
    }

    public static com.ss.android.a.a.b.a BD(boolean z) {
        a.C1214a Bv = new a.C1214a().Qs(0).Bs(true).Bu(false).Bv(false);
        if (z) {
            Bv.Qt(2);
        } else {
            Bv.Qt(0);
        }
        return Bv.eBN();
    }

    public static com.ss.android.a.a.b.b eCG() {
        return new b.a().Zl("landing_h5_download_ad_button").Zm("landing_h5_download_ad_button").Zn("click_start_detail").Zo("click_pause_detail").Zp("click_continue_detail").Zq("click_install_detail").Zr("click_open_detail").Zs("storage_deny_detail").Qu(1).Bw(false).Bx(true).By(false).eBO();
    }
}

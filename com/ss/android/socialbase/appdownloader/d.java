package com.ss.android.socialbase.appdownloader;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Environment;
import android.text.TextUtils;
import com.baidu.mapapi.UIMsg;
import com.ss.android.socialbase.appdownloader.c.l;
import com.ss.android.socialbase.appdownloader.c.n;
import com.ss.android.socialbase.downloader.d.ab;
import com.ss.android.socialbase.downloader.d.ad;
import com.ss.android.socialbase.downloader.d.o;
import com.ss.android.socialbase.downloader.downloader.r;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class d {
    private String i;
    private String j;
    private boolean n = false;
    private String p;
    private com.ss.android.socialbase.appdownloader.c.c qdJ;
    private com.ss.android.socialbase.appdownloader.c.d qdK;
    private com.ss.android.socialbase.appdownloader.c.h qdL;
    private com.ss.android.socialbase.appdownloader.c.g qdM;
    private l qdN;
    private com.ss.android.socialbase.appdownloader.c.i qdO;
    private DownloadReceiver qdP;
    private com.ss.android.socialbase.appdownloader.c.f qdQ;
    private n qdR;
    private o qdS;

    /* renamed from: a  reason: collision with root package name */
    private static final String f13021a = d.class.getSimpleName();
    private static volatile d qdI = null;
    private static boolean l = false;
    private static boolean m = false;

    public com.ss.android.socialbase.appdownloader.c.c eFq() {
        return this.qdJ;
    }

    public com.ss.android.socialbase.appdownloader.c.d eFr() {
        return this.qdK;
    }

    public com.ss.android.socialbase.appdownloader.c.h eFs() {
        return this.qdL;
    }

    public void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.j = str;
        }
    }

    public String d() {
        return this.j;
    }

    public com.ss.android.socialbase.appdownloader.c.f eFt() {
        return this.qdQ;
    }

    public boolean f() {
        return com.ss.android.socialbase.downloader.k.a.b().optInt("package_flag_config", 1) == 1;
    }

    public n eFu() {
        return this.qdR;
    }

    public void a(n nVar) {
        this.qdR = nVar;
    }

    public File h() {
        if (TextUtils.isEmpty(this.p)) {
            return null;
        }
        try {
            File file = new File(this.p);
            try {
                if (!file.exists()) {
                    file.mkdirs();
                } else if (!file.isDirectory()) {
                    file.delete();
                    file.mkdirs();
                }
                return file;
            } catch (Exception e) {
                return file;
            }
        } catch (Exception e2) {
            return null;
        }
    }

    public String i() {
        return this.i;
    }

    private d() {
    }

    public static d eFv() {
        if (qdI == null) {
            synchronized (d.class) {
                if (qdI == null) {
                    qdI = new d();
                }
            }
        }
        return qdI;
    }

    @Deprecated
    public void a(Context context, String str, com.ss.android.socialbase.appdownloader.c.c cVar, com.ss.android.socialbase.appdownloader.c.d dVar, com.ss.android.socialbase.appdownloader.c.h hVar) {
        if (cVar != null) {
            this.qdJ = cVar;
        }
        if (dVar != null) {
            this.qdK = dVar;
        }
        if (hVar != null) {
            this.qdL = hVar;
        }
        c(context);
    }

    private void c(Context context) {
        if (context != null && !l) {
            com.ss.android.socialbase.downloader.b.e.a("application/vnd.android.package-archive");
            com.ss.android.socialbase.downloader.downloader.b.a(context);
            com.ss.android.socialbase.downloader.downloader.b.a(new com.ss.android.socialbase.appdownloader.d.b());
            p();
            l = true;
        }
    }

    public void b(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.p = str;
        }
    }

    private void p() {
        if (!m) {
            if (this.qdP == null) {
                this.qdP = new DownloadReceiver();
            }
            try {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                intentFilter.addAction("android.intent.action.BOOT_COMPLETED");
                intentFilter.addAction("android.ss.intent.action.DOWNLOAD_COMPLETE");
                IntentFilter intentFilter2 = new IntentFilter();
                intentFilter2.addAction("android.intent.action.PACKAGE_ADDED");
                intentFilter2.addAction("android.intent.action.PACKAGE_REPLACED");
                intentFilter2.addDataScheme("package");
                IntentFilter intentFilter3 = new IntentFilter();
                intentFilter3.addAction("android.intent.action.MEDIA_MOUNTED");
                intentFilter3.addDataScheme("file");
                com.ss.android.socialbase.downloader.downloader.b.eGC().registerReceiver(this.qdP, intentFilter);
                com.ss.android.socialbase.downloader.downloader.b.eGC().registerReceiver(this.qdP, intentFilter2);
                com.ss.android.socialbase.downloader.downloader.b.eGC().registerReceiver(this.qdP, intentFilter3);
                m = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean a(Context context, int i) {
        return c.f(context, i, true) == 1;
    }

    public void e(Context context, int i, int i2) {
        try {
            switch (i2) {
                case -4:
                case -1:
                    com.ss.android.socialbase.downloader.downloader.f.iB(context).e(i);
                    break;
                case -3:
                    c.f(context, i, true);
                    break;
                case -2:
                    com.ss.android.socialbase.downloader.downloader.f.iB(context).c(i);
                    break;
                case 0:
                case 6:
                default:
                    return;
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 7:
                case 8:
                    com.ss.android.socialbase.downloader.downloader.f.iB(context).a(i);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int a(f fVar) {
        com.ss.android.socialbase.appdownloader.e.b bVar;
        String str;
        String str2;
        JSONObject jSONObject;
        com.ss.android.socialbase.downloader.g.c h;
        if (fVar == null || fVar.b() == null) {
            return 0;
        }
        try {
            List<com.ss.android.socialbase.downloader.g.e> a2 = a(fVar.f());
            String c = fVar.c();
            if (TextUtils.isEmpty(c)) {
                return 0;
            }
            final int a3 = a(fVar, c);
            final boolean z = a3 == 0;
            String M = fVar.M();
            String d = fVar.d();
            if (TextUtils.isEmpty(M)) {
                M = c.a(c, d, fVar.n(), z);
            }
            if (M.length() > 255) {
                M = M.substring(M.length() + UIMsg.m_AppUI.V_WM_ADDLISTUPDATE);
            }
            if (TextUtils.isEmpty(d)) {
                d = M;
            }
            String n = (!M.endsWith(".apk") || c.d(fVar.n())) ? fVar.n() : "application/vnd.android.package-archive";
            String e = fVar.e();
            if (TextUtils.isEmpty(fVar.e())) {
                e = c.b();
            }
            if (TextUtils.isEmpty(e) || TextUtils.isEmpty(M)) {
                return 0;
            }
            int a4 = com.ss.android.socialbase.downloader.downloader.b.a(c, e);
            if (com.ss.android.socialbase.downloader.k.a.fm(fVar.eFV()).a("resume_task_override_settings") && (h = com.ss.android.socialbase.downloader.downloader.f.iB(com.ss.android.socialbase.downloader.downloader.b.eGC()).h(a4)) != null) {
                try {
                    fVar.fj(new JSONObject(h.R()));
                } catch (Throwable th) {
                }
            }
            com.ss.android.socialbase.downloader.k.a.a(a4, fVar.eFV());
            boolean L = fVar.L();
            boolean z2 = (!L && com.ss.android.socialbase.downloader.m.d.d(e, M) && com.ss.android.socialbase.downloader.downloader.f.iB(fVar.b()).h(a4) == null) ? true : L;
            com.ss.android.socialbase.downloader.d.b eFF = fVar.eFF();
            if (eFF != null || (!fVar.g() && !fVar.h())) {
                bVar = eFF;
            } else if (fVar.eFG() != null) {
                bVar = new com.ss.android.socialbase.appdownloader.e.b(fVar.eFG());
            } else {
                bVar = new com.ss.android.socialbase.appdownloader.e.b(fVar.b(), a4, d, e, M, fVar.m());
            }
            ad eFM = fVar.eFM();
            ad adVar = eFM == null ? new ad() { // from class: com.ss.android.socialbase.appdownloader.d.1
                @Override // com.ss.android.socialbase.downloader.d.ad
                public void a(com.ss.android.socialbase.downloader.g.c cVar, com.ss.android.socialbase.downloader.e.a aVar, int i) {
                    if (d.this.qdL != null) {
                        d.this.qdL.a(cVar, aVar, i);
                    }
                }
            } : eFM;
            ab eGv = com.ss.android.socialbase.downloader.downloader.b.eGv();
            if (eGv != null && fVar.eFQ() == null) {
                fVar.a(eGv);
            }
            String m2 = fVar.m();
            try {
                if (!TextUtils.isEmpty(m2)) {
                    jSONObject = new JSONObject(m2);
                } else {
                    jSONObject = new JSONObject();
                }
                jSONObject.put("auto_install_with_notification", fVar.i());
                jSONObject.put("auto_install_without_notification", fVar.h());
                str2 = jSONObject.toString();
            } catch (Throwable th2) {
                str2 = str;
            }
            boolean z3 = fVar.g() || fVar.h();
            if (z3 && com.ss.android.socialbase.downloader.k.a.RW(a4).b("enable_notification_ui") == 1) {
                com.ss.android.socialbase.appdownloader.e.c.eFD().a(a4, fVar.W());
            }
            final com.ss.android.socialbase.downloader.g.d js = com.ss.android.socialbase.downloader.downloader.f.iC(fVar.b()).aby(c).ha(fVar.eFT()).abw(M).abx(d).abz(e).CB(fVar.j()).gZ(a2).a(adVar).RJ(fVar.x()).RK(fVar.y()).CD(z3).abA(str2).abB(n).RM(fVar.E()).RL(fVar.F()).b(fVar.eFE()).c(bVar).a(a(fVar.eFN())).CC(z2).CF(fVar.s()).CG(fVar.t()).c(fVar.eFH()).d(fVar.eFI()).CE(fVar.o()).abC(fVar.u()).abD(fVar.v()).jr(fVar.w()).CH(fVar.z()).abE(fVar.A()).CI(fVar.B()).CJ(fVar.C()).CL(fVar.G()).CM(fVar.H()).c(fVar.eFK()).a(fVar.eFL()).a(fVar.eFJ()).CN(fVar.I()).b(fVar.eFO()).b(fVar.eFU()).CK(fVar.J()).c(fVar.eFP()).fl(fVar.eFV()).abF(fVar.W()).d(fVar.eFQ()).RN(fVar.eFR()).js(fVar.eFS());
            if (js != null) {
                if (z3 && fVar.T() && fVar.eDJ() != null && !fVar.eDJ().isFinishing() && !com.ss.android.socialbase.appdownloader.e.d.a()) {
                    final String str3 = d;
                    com.ss.android.socialbase.appdownloader.e.d.a(fVar.eDJ(), new com.ss.android.socialbase.appdownloader.c.o() { // from class: com.ss.android.socialbase.appdownloader.d.2
                        @Override // com.ss.android.socialbase.appdownloader.c.o
                        public void a() {
                            com.ss.android.socialbase.downloader.f.a.b(d.f13021a, "notification permission granted, start download :" + str3);
                            d.this.a(js, a3, z);
                        }

                        @Override // com.ss.android.socialbase.appdownloader.c.o
                        public void b() {
                            com.ss.android.socialbase.downloader.f.a.b(d.f13021a, "notification permission denied, start download :" + str3);
                            d.this.a(js, a3, z);
                        }
                    });
                    return a4;
                }
                com.ss.android.socialbase.downloader.f.a.b(f13021a, "notification permission need not request, start download :" + d);
                a(js, a3, z);
                js.a();
                return a4;
            }
            return a4;
        } catch (Throwable th3) {
            com.ss.android.socialbase.downloader.h.a.a(fVar.eFL(), (com.ss.android.socialbase.downloader.g.c) null, new com.ss.android.socialbase.downloader.e.a(1003, com.ss.android.socialbase.downloader.m.d.c(th3, "addDownloadTask")), 0);
            com.ss.android.socialbase.downloader.f.a.e(f13021a, String.format("add download task error:%s", th3));
            return 0;
        }
    }

    private int a(f fVar, String str) {
        com.ss.android.socialbase.downloader.k.a fm = com.ss.android.socialbase.downloader.k.a.fm(fVar.eFV());
        JSONObject abH = fm.abH("anti_hijack_dir");
        if (abH == null || TextUtils.isEmpty(abH.optString("dir_name"))) {
            return -1;
        }
        String d = fVar.d();
        String M = fVar.M();
        if (TextUtils.isEmpty(M)) {
            M = c.a(str, d, fVar.n(), true);
        }
        if (M.length() > 255) {
            M = M.substring(M.length() + UIMsg.m_AppUI.V_WM_ADDLISTUPDATE);
        }
        if (TextUtils.isEmpty(d)) {
            d = M;
        }
        String e = fVar.e();
        if (TextUtils.isEmpty(e)) {
            e = c.b();
        }
        String str2 = e + File.separator + c.a(d, fm);
        com.ss.android.socialbase.downloader.g.c bF = bF(fVar.b(), str);
        if (bF != null && bF.eIc()) {
            fVar.abf(bF.k());
            try {
                fVar.fj(new JSONObject(bF.R()));
                return 0;
            } catch (Throwable th) {
                return 0;
            }
        } else if (bF == null && "application/vnd.android.package-archive".equalsIgnoreCase(a(M, fVar.n()))) {
            int d2 = b.d(fm);
            if (d2 == 0) {
                fVar.abf(str2);
                return d2;
            }
            return d2;
        } else if (bF != null) {
            return 8;
        } else {
            return 9;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.ss.android.socialbase.downloader.g.d dVar, int i, boolean z) {
        if (dVar != null) {
            dVar.n();
            com.ss.android.socialbase.downloader.g.c a2 = dVar.a();
            if (a2 != null) {
                a2.m(i);
            }
            if (a2 != null && z) {
                a2.n(z);
            }
        }
    }

    private List<com.ss.android.socialbase.downloader.g.e> a(List<com.ss.android.socialbase.downloader.g.e> list) {
        boolean z;
        ArrayList arrayList = new ArrayList();
        boolean z2 = false;
        if (list != null && list.size() > 0) {
            Iterator<com.ss.android.socialbase.downloader.g.e> it = list.iterator();
            while (true) {
                z = z2;
                if (!it.hasNext()) {
                    break;
                }
                com.ss.android.socialbase.downloader.g.e next = it.next();
                if (next != null && !TextUtils.isEmpty(next.a()) && !TextUtils.isEmpty(next.b())) {
                    if (next.a().equals("User-Agent")) {
                        z = true;
                    }
                    arrayList.add(new com.ss.android.socialbase.downloader.g.e(next.a(), next.b()));
                }
                z2 = z;
            }
            z2 = z;
        }
        if (!z2) {
            arrayList.add(new com.ss.android.socialbase.downloader.g.e("User-Agent", com.ss.android.socialbase.appdownloader.b.a.f13015a));
        }
        return arrayList;
    }

    private String a(String str, String str2) {
        if (!TextUtils.isEmpty(str) && str.endsWith(".apk") && !c.d(str2)) {
            return "application/vnd.android.package-archive";
        }
        return str2;
    }

    private com.ss.android.socialbase.downloader.d.d a(final com.ss.android.socialbase.appdownloader.c.e eVar) {
        if (eVar == null) {
            return null;
        }
        return new com.ss.android.socialbase.downloader.d.d() { // from class: com.ss.android.socialbase.appdownloader.d.3
            @Override // com.ss.android.socialbase.downloader.d.d
            public void a(int i, com.ss.android.socialbase.downloader.g.c cVar, String str, String str2) {
                switch (i) {
                    case 1:
                    case 3:
                    case 5:
                    case 6:
                    case 7:
                        eVar.a(i, str, cVar.q(), cVar.eHB());
                        return;
                    case 2:
                    case 4:
                    default:
                        return;
                    case 8:
                        eVar.g(i, cVar.D(), str, str2);
                        return;
                    case 9:
                        eVar.a(com.ss.android.socialbase.downloader.downloader.b.eGC(), str);
                        return;
                    case 10:
                        eVar.a(cVar);
                        return;
                }
            }

            @Override // com.ss.android.socialbase.downloader.d.d
            public boolean a(boolean z) {
                return eVar.a(z);
            }

            @Override // com.ss.android.socialbase.downloader.d.d
            public String a() {
                return eVar.a();
            }
        };
    }

    public com.ss.android.socialbase.downloader.g.c bF(Context context, String str) {
        if (TextUtils.isEmpty(str) || context == null) {
            return null;
        }
        try {
            com.ss.android.socialbase.downloader.g.c g = g(context, str, h());
            if (g == null) {
                g = g(context, str, context.getFilesDir());
            }
            if (g == null) {
                g = g(context, str, Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS));
            }
            if (g == null) {
                g = g(context, str, context.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS));
            }
            boolean a2 = com.ss.android.socialbase.downloader.k.a.eIF().a("get_download_info_by_list");
            if (g == null && a2) {
                return bG(context, str);
            }
            return g;
        } catch (Throwable th) {
            com.ss.android.socialbase.downloader.f.a.b(f13021a, String.format("getAppDownloadInfo error:%s", th.getMessage()));
            return null;
        }
    }

    private com.ss.android.socialbase.downloader.g.c g(Context context, String str, File file) {
        if (context == null || TextUtils.isEmpty(str) || file == null) {
            return null;
        }
        return com.ss.android.socialbase.downloader.downloader.f.iB(context).hB(str, file.getAbsolutePath());
    }

    private com.ss.android.socialbase.downloader.g.c bG(Context context, String str) {
        List<com.ss.android.socialbase.downloader.g.c> a2 = com.ss.android.socialbase.downloader.downloader.f.iB(context).a(str);
        if (a2 != null) {
            for (com.ss.android.socialbase.downloader.g.c cVar : a2) {
                if (cVar != null && cVar.eIc()) {
                    return cVar;
                }
            }
        }
        return null;
    }

    public List<com.ss.android.socialbase.downloader.g.c> a(Context context) {
        return com.ss.android.socialbase.downloader.downloader.f.iB(context).c("application/vnd.android.package-archive");
    }

    public List<com.ss.android.socialbase.downloader.g.c> b(Context context) {
        return com.ss.android.socialbase.downloader.downloader.f.iB(context).d("application/vnd.android.package-archive");
    }

    public l eFw() {
        return this.qdN;
    }

    public com.ss.android.socialbase.appdownloader.c.g eFx() {
        return this.qdM;
    }

    public void a(com.ss.android.socialbase.appdownloader.c.g gVar) {
        this.qdM = gVar;
    }

    public void a(com.ss.android.socialbase.appdownloader.c.i iVar) {
        this.qdO = iVar;
    }

    public r eFy() {
        return com.ss.android.socialbase.downloader.downloader.f.iB(com.ss.android.socialbase.downloader.downloader.b.eGC()).eGH();
    }

    public void a(r rVar) {
        com.ss.android.socialbase.downloader.downloader.f.iB(com.ss.android.socialbase.downloader.downloader.b.eGC()).a(rVar);
    }

    public void a(o oVar) {
        this.qdS = oVar;
    }

    public o eFz() {
        return this.qdS;
    }
}

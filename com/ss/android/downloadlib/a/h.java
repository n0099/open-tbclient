package com.ss.android.downloadlib.a;

import android.content.Context;
import android.os.Environment;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.down.request.db.DownloadDataConstants;
import com.ss.android.a.a.a.q;
import com.ss.android.downloadlib.a.b.d;
import com.ss.android.downloadlib.f.g;
import com.ss.android.downloadlib.f.j;
import java.io.File;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class h implements j.a {

    /* renamed from: a  reason: collision with root package name */
    private long f12959a;
    private boolean c = false;
    private final com.ss.android.downloadlib.f.j pRF = new com.ss.android.downloadlib.f.j(Looper.getMainLooper(), this);
    private b pRG;
    private d.a pRj;

    /* loaded from: classes4.dex */
    public interface b {
        void a(com.ss.android.socialbase.downloader.g.c cVar);
    }

    public void a(long j) {
        this.f12959a = j;
        this.pRj = com.ss.android.downloadlib.a.b.d.eCc().jc(j);
        if (this.pRj.a()) {
            com.ss.android.downloadlib.f.i.b();
        }
    }

    public void a(com.ss.android.socialbase.downloader.g.c cVar) {
        this.c = false;
        if (this.pRG != null) {
            this.pRG.a(cVar);
            this.pRG = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean e(Context context, int i, boolean z) {
        if (com.ss.android.downloadlib.f.i.b(this.pRj.pQW)) {
            com.ss.android.b.a.b.a jb = com.ss.android.downloadlib.a.b.d.eCc().jb(this.pRj.f12938a);
            if (jb != null) {
                com.ss.android.socialbase.downloader.notification.b.eGk().f(jb.t());
            }
            return com.ss.android.downloadlib.b.a.b(this.pRj);
        } else if (a(i) && !TextUtils.isEmpty(this.pRj.pQW.v()) && j.i().optInt("disable_market") != 1) {
            return com.ss.android.downloadlib.b.a.a(this.pRj, i);
        } else {
            return false;
        }
    }

    private boolean a(int i) {
        return (this.pRj.pQY.b() == 2 && i == 2) || this.pRj.pQY.b() == 3;
    }

    boolean a() {
        return com.ss.android.downloadlib.f.i.b(this.pRj.pQW) && !i.a(this.pRj.pQY.a());
    }

    public int a(boolean z) {
        if (!a() || !z) {
            return 0;
        }
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(boolean z) {
        return !z && this.pRj.pQY.b() == 1;
    }

    private boolean c() {
        return d() && e();
    }

    private boolean d() {
        return (this.pRj.pQW == null || TextUtils.isEmpty(this.pRj.pQW.v()) || TextUtils.isEmpty(this.pRj.pQW.a())) ? false : true;
    }

    private boolean e() {
        return this.pRj.pQY.d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(@NonNull final q qVar) {
        if (!TextUtils.isEmpty(this.pRj.pQW.n()) && this.pRj.pQW.n().startsWith(Environment.getDataDirectory().getAbsolutePath())) {
            qVar.a();
        } else {
            b(new q() { // from class: com.ss.android.downloadlib.a.h.1
                @Override // com.ss.android.a.a.a.q
                public void a() {
                    qVar.a();
                }

                @Override // com.ss.android.a.a.a.q
                public void a(String str) {
                    j.eCo().a(1, j.a(), h.this.pRj.pQW, "您已禁止使用存储权限，请授权后再下载", null, 1);
                    com.ss.android.downloadlib.e.a.eCL().b(h.this.f12959a, 1);
                    qVar.a(str);
                }
            });
        }
    }

    private void b(final q qVar) {
        if (com.ss.android.downloadlib.f.g.b("android.permission.WRITE_EXTERNAL_STORAGE")) {
            if (qVar != null) {
                qVar.a();
                return;
            }
            return;
        }
        com.ss.android.downloadlib.f.g.a(new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, new g.a() { // from class: com.ss.android.downloadlib.a.h.2
            @Override // com.ss.android.downloadlib.f.g.a
            public void a() {
                if (qVar != null) {
                    qVar.a();
                }
            }

            @Override // com.ss.android.downloadlib.f.g.a
            public void a(String str) {
                if (qVar != null) {
                    qVar.a(str);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Message message, com.ss.android.a.a.d.e eVar, Map<Integer, Object> map) {
        int i = 0;
        if (message != null && message.what == 3) {
            com.ss.android.socialbase.downloader.g.c cVar = (com.ss.android.socialbase.downloader.g.c) message.obj;
            if (message.arg1 != 1 && message.arg1 != 6 && message.arg1 == 2) {
                if (cVar.eFe()) {
                    com.ss.android.downloadlib.h.eCM().a(this.pRj.pQW, this.pRj.pQY, this.pRj.pQX);
                    cVar.g(false);
                }
                com.ss.android.downloadlib.e.a.eCL().a(cVar);
            }
            eVar.a(cVar);
            int a2 = com.ss.android.socialbase.appdownloader.c.a(cVar.q());
            long efR = cVar.efR();
            if (efR > 0) {
                i = (int) ((cVar.eEJ() * 100) / efR);
                if (this.pRG != null) {
                    this.pRG.a(cVar);
                    this.pRG = null;
                }
            }
            int i2 = i;
            for (com.ss.android.a.a.b.d dVar : a(map)) {
                switch (a2) {
                    case 1:
                        if (cVar.q() != 11) {
                            dVar.a(eVar, i2);
                            break;
                        } else {
                            for (com.ss.android.a.a.b.e eVar2 : I(map)) {
                                eVar2.a(cVar);
                            }
                            break;
                        }
                    case 2:
                        dVar.b(eVar, i2);
                        break;
                    case 3:
                        if (cVar.q() == -4) {
                            dVar.a();
                            break;
                        } else if (cVar.q() == -1) {
                            dVar.a(eVar);
                            break;
                        } else if (cVar.q() != -3) {
                            break;
                        } else if (com.ss.android.downloadlib.f.i.b(this.pRj.pQW)) {
                            dVar.b(eVar);
                            break;
                        } else {
                            dVar.c(eVar);
                            break;
                        }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(com.ss.android.socialbase.downloader.g.c cVar) {
        if (i.b(this.pRj.pQW) && !this.c) {
            com.ss.android.downloadlib.e.a.eCL().a("file_status", (cVar == null || !com.ss.android.downloadlib.f.i.b(cVar.n())) ? 2 : 1, this.pRj);
            this.c = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        if (this.pRG == null) {
            this.pRG = new b() { // from class: com.ss.android.downloadlib.a.h.3
                @Override // com.ss.android.downloadlib.a.h.b
                public void a(com.ss.android.socialbase.downloader.g.c cVar) {
                    com.ss.android.downloadlib.e.a.eCL().a(h.this.f12959a, 2, cVar);
                }
            };
        }
    }

    private void f() {
        Message obtain = Message.obtain();
        obtain.what = 1;
        this.pRF.sendMessageDelayed(obtain, 1200L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c(com.ss.android.socialbase.downloader.g.c cVar) {
        return k(cVar) || g();
    }

    private boolean k(com.ss.android.socialbase.downloader.g.c cVar) {
        return l(cVar) && !com.ss.android.downloadlib.f.i.b(this.pRj.pQW);
    }

    private boolean g() {
        return com.ss.android.downloadlib.f.i.b(this.pRj.pQW) && i.a(this.pRj.pQY.a());
    }

    private boolean l(com.ss.android.socialbase.downloader.g.c cVar) {
        return cVar != null && cVar.q() == -3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a(Context context, com.ss.android.socialbase.downloader.d.b bVar) {
        int i = 0;
        if (context != null) {
            Map<String, String> j = this.pRj.pQW.j();
            ArrayList arrayList = new ArrayList();
            if (j != null) {
                for (Map.Entry<String, String> entry : j.entrySet()) {
                    if (entry != null) {
                        arrayList.add(new com.ss.android.socialbase.downloader.g.e(entry.getKey(), entry.getValue()));
                    }
                }
            }
            String c = com.ss.android.downloadlib.f.c.c(String.valueOf(this.pRj.pQW.d()), this.pRj.pQW.c(), this.pRj.pQW.k(), String.valueOf(this.pRj.pQW.A()));
            com.ss.android.socialbase.downloader.k.a g = com.ss.android.downloadlib.f.d.g(this.pRj.pQW);
            this.pRj.pQW.F();
            int i2 = (this.pRj.pQW.t() || i.e(this.pRj.pQW)) ? 4 : 4;
            String c2 = c(g);
            com.ss.android.socialbase.downloader.g.c h = com.ss.android.socialbase.downloader.downloader.f.iy(j.a()).h(com.ss.android.socialbase.downloader.downloader.b.a(this.pRj.pQW.a(), c2));
            if (h != null && 3 == this.pRj.pQW.A()) {
                h.g(true);
                com.ss.android.socialbase.downloader.m.d.a(h);
            }
            com.ss.android.socialbase.appdownloader.f QP = new com.ss.android.socialbase.appdownloader.f(context, this.pRj.pQW.a()).gY(this.pRj.pQW.b()).ZQ(this.pRj.pQW.h()).ZT(c).gX(arrayList).BF(this.pRj.pQW.l()).BH(this.pRj.pQW.m()).ZR(this.pRj.pQW.o()).ZS(c2).ZY(this.pRj.pQW.w()).ZW(this.pRj.pQW.e()).je(this.pRj.pQW.f()).a(bVar).BQ(this.pRj.pQW.q() || g.a("need_independent_process", 0) == 1).a(this.pRj.pQW.eBI()).BG(this.pRj.pQW.C()).ZV(this.pRj.pQW.v()).QN(1000).QO(100).fi(com.ss.android.downloadlib.f.d.h(this.pRj.pQW)).BN(true).BO(true).QL(g.a(DownloadDataConstants.Columns.COLUMN_RETRY_COUNT, 5)).QM(g.a("backup_url_retry_count", 0)).BO(true).BR(g.a("need_head_connection", 1) == 1).BI(g.a("need_https_to_http_retry", 0) == 1).BM(g.a("need_chunk_downgrade_retry", 1) == 1).BL(g.a("need_retry_delay", 0) == 1).ZX(g.d("retry_delay_time_array")).BP(g.a("need_reuse_runnable", 0) == 1).a(d.B(this.pRj.pQW.a(), this.pRj.pQW.p())).a(d.fd(this.pRj.pQW.p())).QP(i2);
            if (!TextUtils.isEmpty(this.pRj.pQW.i())) {
                QP.ZU(this.pRj.pQW.i());
            } else {
                QP.ZU("application/vnd.android.package-archive");
            }
            com.ss.android.downloadlib.a.c.a aVar = null;
            if (g.a("clear_space_use_disk_handler", 0) == 1) {
                aVar = new com.ss.android.downloadlib.a.c.a();
                QP.a(aVar);
            }
            i = i.a(this.pRj.pQW, c(), QP);
            if (aVar != null) {
                aVar.a(i);
            }
        }
        return i;
    }

    private String c(com.ss.android.socialbase.downloader.k.a aVar) {
        File externalFilesDir;
        if (!TextUtils.isEmpty(this.pRj.pQW.n())) {
            return this.pRj.pQW.n();
        }
        com.ss.android.socialbase.downloader.g.c bH = com.ss.android.socialbase.appdownloader.d.eCW().bH(j.a(), this.pRj.pQW.a());
        boolean b2 = com.ss.android.downloadlib.f.g.b("android.permission.WRITE_EXTERNAL_STORAGE");
        if (bH != null && !TextUtils.isEmpty(bH.k())) {
            String k = bH.k();
            if (!b2 && !k.startsWith(Environment.getDataDirectory().getAbsolutePath())) {
                try {
                    File externalFilesDir2 = j.a().getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);
                    if (externalFilesDir2 != null) {
                        if (k.startsWith(externalFilesDir2.getAbsolutePath())) {
                            return k;
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                com.ss.android.socialbase.downloader.downloader.f.iy(com.ss.android.socialbase.downloader.downloader.b.eEd()).b(bH.g());
            } else {
                return k;
            }
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("ttdownloader_code", Integer.valueOf(b2 ? 1 : 2));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        com.ss.android.downloadlib.e.a.eCL().a("label_external_permission", jSONObject, this.pRj);
        String str = null;
        try {
            str = com.ss.android.socialbase.appdownloader.c.b();
        } catch (Exception e3) {
        }
        int d = com.ss.android.downloadlib.f.d.d(aVar);
        if (d != 0) {
            if (d == 4 || (!b2 && d == 2)) {
                File filesDir = j.a().getFilesDir();
                if (!filesDir.exists()) {
                    filesDir.mkdirs();
                }
                if (filesDir.exists()) {
                    return filesDir.getAbsolutePath();
                }
                return str;
            } else if ((d == 3 || (!b2 && d == 1)) && (externalFilesDir = j.a().getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS)) != null) {
                if (!externalFilesDir.exists()) {
                    externalFilesDir.mkdirs();
                }
                if (externalFilesDir.exists()) {
                    return externalFilesDir.getAbsolutePath();
                }
                return str;
            } else {
                return str;
            }
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(com.ss.android.socialbase.downloader.g.c cVar) {
        if (this.pRj.pQW != null && cVar != null && cVar.g() != 0) {
            int q = cVar.q();
            if (q == -1 || q == -4) {
                com.ss.android.downloadlib.e.a.eCL().a(this.f12959a, 2);
            } else if (i.b(this.pRj.pQW)) {
                com.ss.android.downloadlib.e.a.eCL().a(this.f12959a, 2);
            }
            switch (q) {
                case -4:
                case -1:
                    b();
                    com.ss.android.downloadlib.a.b.d.eCc().d(new com.ss.android.b.a.b.a(this.pRj.pQW, this.pRj.pQX, this.pRj.pQY, cVar.g()));
                    return;
                case -3:
                    if (com.ss.android.downloadlib.f.i.b(this.pRj.pQW)) {
                        com.ss.android.downloadlib.f.i.b();
                        return;
                    }
                    com.ss.android.downloadlib.e.a.eCL().a(this.f12959a, 5, cVar);
                    f();
                    return;
                case -2:
                    com.ss.android.downloadlib.e.a.eCL().a(this.f12959a, 4, cVar);
                    return;
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
                    com.ss.android.downloadlib.e.a.eCL().a(this.f12959a, 3, cVar);
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x009b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(com.ss.android.socialbase.downloader.g.c cVar, com.ss.android.a.a.d.e eVar, List<com.ss.android.a.a.b.d> list) {
        int i;
        if (!list.isEmpty()) {
            if (cVar == null || eVar == null) {
                for (com.ss.android.a.a.b.d dVar : list) {
                    dVar.a();
                }
                return;
            }
            try {
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (cVar.efR() > 0) {
                i = (int) ((cVar.eEJ() * 100) / cVar.efR());
                int i2 = i >= 0 ? i : 0;
                eVar.a(cVar);
                for (com.ss.android.a.a.b.d dVar2 : list) {
                    switch (cVar.q()) {
                        case -4:
                        case 0:
                            if (com.ss.android.downloadlib.f.i.b(this.pRj.pQW)) {
                                eVar.f12906b = -3;
                                dVar2.b(eVar);
                                break;
                            } else {
                                dVar2.a();
                                break;
                            }
                        case -3:
                            if (com.ss.android.downloadlib.f.i.b(this.pRj.pQW)) {
                                dVar2.b(eVar);
                                break;
                            } else {
                                dVar2.c(eVar);
                                break;
                            }
                        case -2:
                            dVar2.b(eVar, i2);
                            break;
                        case -1:
                            dVar2.a(eVar);
                            break;
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 7:
                        case 8:
                            dVar2.a(eVar, i2);
                            break;
                        case 11:
                            if (dVar2 instanceof com.ss.android.a.a.b.e) {
                                ((com.ss.android.a.a.b.e) dVar2).a(cVar);
                                break;
                            } else {
                                dVar2.a(eVar, i2);
                                break;
                            }
                    }
                }
            }
            i = 0;
            if (i >= 0) {
            }
            eVar.a(cVar);
            while (r2.hasNext()) {
            }
        }
    }

    @Override // com.ss.android.downloadlib.f.j.a
    public void a(Message message) {
        switch (message.what) {
            case 1:
                com.ss.android.a.a.a.b eCv = j.eCv();
                if (eCv != null && eCv.a()) {
                    com.ss.android.downloadlib.e.a.eCL().a("install_window_show", this.pRj);
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* loaded from: classes4.dex */
    static class a extends com.ss.android.socialbase.downloader.d.a {
        private com.ss.android.downloadlib.f.j pRJ;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(com.ss.android.downloadlib.f.j jVar) {
            this.pRJ = jVar;
        }

        @Override // com.ss.android.socialbase.downloader.d.x, com.ss.android.socialbase.downloader.d.b
        public void a(com.ss.android.socialbase.downloader.g.c cVar) {
            a(cVar, 1);
        }

        @Override // com.ss.android.socialbase.downloader.d.x, com.ss.android.socialbase.downloader.d.b
        public void b(com.ss.android.socialbase.downloader.g.c cVar) {
            a(cVar, 2);
        }

        @Override // com.ss.android.socialbase.downloader.d.x, com.ss.android.socialbase.downloader.d.b
        public void c(com.ss.android.socialbase.downloader.g.c cVar) {
            a(cVar, 4);
        }

        @Override // com.ss.android.socialbase.downloader.d.x, com.ss.android.socialbase.downloader.d.b
        public void d(com.ss.android.socialbase.downloader.g.c cVar) {
            a(cVar, -2);
        }

        @Override // com.ss.android.socialbase.downloader.d.x, com.ss.android.socialbase.downloader.d.b
        public void e(com.ss.android.socialbase.downloader.g.c cVar) {
            a(cVar, -3);
        }

        @Override // com.ss.android.socialbase.downloader.d.x, com.ss.android.socialbase.downloader.d.b
        public void a(com.ss.android.socialbase.downloader.g.c cVar, com.ss.android.socialbase.downloader.e.a aVar) {
            a(cVar, -1);
        }

        @Override // com.ss.android.socialbase.downloader.d.x, com.ss.android.socialbase.downloader.d.b
        public void f(com.ss.android.socialbase.downloader.g.c cVar) {
            a(cVar, -4);
        }

        @Override // com.ss.android.socialbase.downloader.d.a, com.ss.android.socialbase.downloader.d.ag
        public void g(com.ss.android.socialbase.downloader.g.c cVar) {
            a(cVar, 11);
        }

        private void a(com.ss.android.socialbase.downloader.g.c cVar, int i) {
            Message obtain = Message.obtain();
            obtain.what = 3;
            obtain.obj = cVar;
            obtain.arg1 = i;
            this.pRJ.sendMessage(obtain);
        }
    }

    @NonNull
    public static List<com.ss.android.a.a.b.d> a(Map<Integer, Object> map) {
        ArrayList arrayList = new ArrayList();
        if (map == null || map.isEmpty()) {
            return arrayList;
        }
        for (Object obj : map.values()) {
            if (obj instanceof com.ss.android.a.a.b.d) {
                arrayList.add((com.ss.android.a.a.b.d) obj);
            } else if ((obj instanceof SoftReference) && (((SoftReference) obj).get() instanceof com.ss.android.a.a.b.d)) {
                arrayList.add((com.ss.android.a.a.b.d) ((SoftReference) obj).get());
            }
        }
        return arrayList;
    }

    @NonNull
    public static List<com.ss.android.a.a.b.e> I(Map<Integer, Object> map) {
        ArrayList arrayList = new ArrayList();
        if (map == null || map.isEmpty()) {
            return arrayList;
        }
        for (Object obj : map.values()) {
            if (obj instanceof com.ss.android.a.a.b.e) {
                arrayList.add((com.ss.android.a.a.b.e) obj);
            } else if ((obj instanceof SoftReference) && (((SoftReference) obj).get() instanceof com.ss.android.a.a.b.e)) {
                arrayList.add((com.ss.android.a.a.b.e) ((SoftReference) obj).get());
            }
        }
        return arrayList;
    }
}

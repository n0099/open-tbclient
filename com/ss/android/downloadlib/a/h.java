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
/* loaded from: classes6.dex */
public class h implements j.a {

    /* renamed from: a  reason: collision with root package name */
    private long f7710a;
    private d.a qcB;
    private b qcX;
    private boolean c = false;
    private final com.ss.android.downloadlib.f.j qcW = new com.ss.android.downloadlib.f.j(Looper.getMainLooper(), this);

    /* loaded from: classes6.dex */
    public interface b {
        void a(com.ss.android.socialbase.downloader.g.c cVar);
    }

    public void a(long j) {
        this.f7710a = j;
        this.qcB = com.ss.android.downloadlib.a.b.d.eEF().jf(j);
        if (this.qcB.a()) {
            com.ss.android.downloadlib.f.i.b();
        }
    }

    public void a(com.ss.android.socialbase.downloader.g.c cVar) {
        this.c = false;
        if (this.qcX != null) {
            this.qcX.a(cVar);
            this.qcX = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean e(Context context, int i, boolean z) {
        if (com.ss.android.downloadlib.f.i.b(this.qcB.qco)) {
            com.ss.android.b.a.b.a je = com.ss.android.downloadlib.a.b.d.eEF().je(this.qcB.f7695a);
            if (je != null) {
                com.ss.android.socialbase.downloader.notification.b.eIK().f(je.t());
            }
            return com.ss.android.downloadlib.b.a.b(this.qcB);
        } else if (a(i) && !TextUtils.isEmpty(this.qcB.qco.v()) && j.i().optInt("disable_market") != 1) {
            return com.ss.android.downloadlib.b.a.a(this.qcB, i);
        } else {
            return false;
        }
    }

    private boolean a(int i) {
        return (this.qcB.qcq.b() == 2 && i == 2) || this.qcB.qcq.b() == 3;
    }

    boolean a() {
        return com.ss.android.downloadlib.f.i.b(this.qcB.qco) && !i.a(this.qcB.qcq.a());
    }

    public int a(boolean z) {
        if (!a() || !z) {
            return 0;
        }
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(boolean z) {
        return !z && this.qcB.qcq.b() == 1;
    }

    private boolean c() {
        return d() && e();
    }

    private boolean d() {
        return (this.qcB.qco == null || TextUtils.isEmpty(this.qcB.qco.v()) || TextUtils.isEmpty(this.qcB.qco.a())) ? false : true;
    }

    private boolean e() {
        return this.qcB.qcq.d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(@NonNull final q qVar) {
        if (!TextUtils.isEmpty(this.qcB.qco.n())) {
            String n = this.qcB.qco.n();
            if (n.startsWith(Environment.getDataDirectory().getAbsolutePath())) {
                qVar.a();
                return;
            }
            try {
                if (n.startsWith(j.a().getExternalCacheDir().getParent())) {
                    qVar.a();
                    return;
                }
            } catch (Exception e) {
            }
        }
        b(new q() { // from class: com.ss.android.downloadlib.a.h.1
            @Override // com.ss.android.a.a.a.q
            public void a() {
                qVar.a();
            }

            @Override // com.ss.android.a.a.a.q
            public void a(String str) {
                j.eER().a(1, j.a(), h.this.qcB.qco, "您已禁止使用存储权限，请授权后再下载", null, 1);
                com.ss.android.downloadlib.e.a.eFo().b(h.this.f7710a, 1);
                qVar.a(str);
            }
        });
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
                if (cVar.eHF()) {
                    com.ss.android.downloadlib.h.eFp().a(this.qcB.qco, this.qcB.qcq, this.qcB.qcp);
                    cVar.g(false);
                }
                com.ss.android.downloadlib.e.a.eFo().a(cVar);
            }
            eVar.a(cVar);
            int a2 = com.ss.android.socialbase.appdownloader.c.a(cVar.q());
            long am = cVar.am();
            if (am > 0) {
                i = (int) ((cVar.eHm() * 100) / am);
                if (this.qcX != null) {
                    this.qcX.a(cVar);
                    this.qcX = null;
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
                            for (com.ss.android.a.a.b.e eVar2 : K(map)) {
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
                        } else if (com.ss.android.downloadlib.f.i.b(this.qcB.qco)) {
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
        if (i.b(this.qcB.qco) && !this.c) {
            com.ss.android.downloadlib.e.a.eFo().a("file_status", (cVar == null || !com.ss.android.downloadlib.f.i.b(cVar.n())) ? 2 : 1, this.qcB);
            this.c = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        if (this.qcX == null) {
            this.qcX = new b() { // from class: com.ss.android.downloadlib.a.h.3
                @Override // com.ss.android.downloadlib.a.h.b
                public void a(com.ss.android.socialbase.downloader.g.c cVar) {
                    com.ss.android.downloadlib.e.a.eFo().a(h.this.f7710a, 2, cVar);
                }
            };
        }
    }

    private void f() {
        Message obtain = Message.obtain();
        obtain.what = 1;
        this.qcW.sendMessageDelayed(obtain, 1200L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c(com.ss.android.socialbase.downloader.g.c cVar) {
        return k(cVar) || g();
    }

    private boolean k(com.ss.android.socialbase.downloader.g.c cVar) {
        return l(cVar) && !com.ss.android.downloadlib.f.i.b(this.qcB.qco);
    }

    private boolean g() {
        return com.ss.android.downloadlib.f.i.b(this.qcB.qco) && i.a(this.qcB.qcq.a());
    }

    private boolean l(com.ss.android.socialbase.downloader.g.c cVar) {
        return cVar != null && cVar.q() == -3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a(Context context, com.ss.android.socialbase.downloader.d.b bVar) {
        int i = 0;
        if (context != null) {
            Map<String, String> j = this.qcB.qco.j();
            ArrayList arrayList = new ArrayList();
            if (j != null) {
                for (Map.Entry<String, String> entry : j.entrySet()) {
                    if (entry != null) {
                        arrayList.add(new com.ss.android.socialbase.downloader.g.e(entry.getKey(), entry.getValue()));
                    }
                }
            }
            String c = com.ss.android.downloadlib.f.c.c(String.valueOf(this.qcB.qco.d()), this.qcB.qco.c(), this.qcB.qco.k(), String.valueOf(this.qcB.qco.A()));
            com.ss.android.socialbase.downloader.k.a g = com.ss.android.downloadlib.f.d.g(this.qcB.qco);
            this.qcB.qco.F();
            int i2 = (this.qcB.qco.t() || i.e(this.qcB.qco)) ? 4 : 4;
            String c2 = c(g);
            com.ss.android.socialbase.downloader.g.c h = com.ss.android.socialbase.downloader.downloader.f.iC(j.a()).h(com.ss.android.socialbase.downloader.downloader.b.a(this.qcB.qco.a(), c2));
            if (h != null && 3 == this.qcB.qco.A()) {
                h.g(true);
                com.ss.android.socialbase.downloader.m.d.a(h);
            }
            com.ss.android.socialbase.appdownloader.f Rp = new com.ss.android.socialbase.appdownloader.f(context, this.qcB.qco.a()).gW(this.qcB.qco.b()).abi(this.qcB.qco.h()).abl(c).gV(arrayList).BX(this.qcB.qco.l()).BZ(this.qcB.qco.m()).abj(this.qcB.qco.o()).abk(c2).abq(this.qcB.qco.w()).abo(this.qcB.qco.e()).jh(this.qcB.qco.f()).a(bVar).Ci(this.qcB.qco.q() || g.a("need_independent_process", 0) == 1).a(this.qcB.qco.eEl()).BY(this.qcB.qco.C()).abn(this.qcB.qco.v()).Rn(1000).Ro(100).fm(com.ss.android.downloadlib.f.d.h(this.qcB.qco)).Cf(true).Cg(true).Rl(g.a(DownloadDataConstants.Columns.COLUMN_RETRY_COUNT, 5)).Rm(g.a("backup_url_retry_count", 0)).Cg(true).Cj(g.a("need_head_connection", 1) == 1).Ca(g.a("need_https_to_http_retry", 0) == 1).Ce(g.a("need_chunk_downgrade_retry", 1) == 1).Cd(g.a("need_retry_delay", 0) == 1).abp(g.d("retry_delay_time_array")).Ch(g.a("need_reuse_runnable", 0) == 1).a(d.B(this.qcB.qco.a(), this.qcB.qco.p())).a(d.fh(this.qcB.qco.p())).Rp(i2);
            if (!TextUtils.isEmpty(this.qcB.qco.i())) {
                Rp.abm(this.qcB.qco.i());
            } else {
                Rp.abm("application/vnd.android.package-archive");
            }
            com.ss.android.downloadlib.a.c.a aVar = null;
            if (g.a("clear_space_use_disk_handler", 0) == 1) {
                aVar = new com.ss.android.downloadlib.a.c.a();
                Rp.a(aVar);
            }
            i = i.a(this.qcB.qco, c(), Rp);
            if (aVar != null) {
                aVar.a(i);
            }
        }
        return i;
    }

    private String c(com.ss.android.socialbase.downloader.k.a aVar) {
        File externalFilesDir;
        if (!TextUtils.isEmpty(this.qcB.qco.n())) {
            return this.qcB.qco.n();
        }
        com.ss.android.socialbase.downloader.g.c bE = com.ss.android.socialbase.appdownloader.d.eFz().bE(j.a(), this.qcB.qco.a());
        boolean b2 = com.ss.android.downloadlib.f.g.b("android.permission.WRITE_EXTERNAL_STORAGE");
        if (bE != null && !TextUtils.isEmpty(bE.k())) {
            String k = bE.k();
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
                com.ss.android.socialbase.downloader.downloader.f.iC(com.ss.android.socialbase.downloader.downloader.b.eGG()).b(bE.g());
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
        com.ss.android.downloadlib.e.a.eFo().a("label_external_permission", jSONObject, this.qcB);
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
        if (this.qcB.qco != null && cVar != null && cVar.g() != 0) {
            int q = cVar.q();
            if (q == -1 || q == -4) {
                com.ss.android.downloadlib.e.a.eFo().a(this.f7710a, 2);
            } else if (i.b(this.qcB.qco)) {
                com.ss.android.downloadlib.e.a.eFo().a(this.f7710a, 2);
            }
            switch (q) {
                case -4:
                case -1:
                    b();
                    com.ss.android.downloadlib.a.b.d.eEF().d(new com.ss.android.b.a.b.a(this.qcB.qco, this.qcB.qcp, this.qcB.qcq, cVar.g()));
                    return;
                case -3:
                    if (com.ss.android.downloadlib.f.i.b(this.qcB.qco)) {
                        com.ss.android.downloadlib.f.i.b();
                        return;
                    }
                    com.ss.android.downloadlib.e.a.eFo().a(this.f7710a, 5, cVar);
                    f();
                    return;
                case -2:
                    com.ss.android.downloadlib.e.a.eFo().a(this.f7710a, 4, cVar);
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
                    com.ss.android.downloadlib.e.a.eFo().a(this.f7710a, 3, cVar);
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
            if (cVar.am() > 0) {
                i = (int) ((cVar.eHm() * 100) / cVar.am());
                int i2 = i >= 0 ? i : 0;
                eVar.a(cVar);
                for (com.ss.android.a.a.b.d dVar2 : list) {
                    switch (cVar.q()) {
                        case -4:
                        case 0:
                            if (com.ss.android.downloadlib.f.i.b(this.qcB.qco)) {
                                eVar.b = -3;
                                dVar2.b(eVar);
                                break;
                            } else {
                                dVar2.a();
                                break;
                            }
                        case -3:
                            if (com.ss.android.downloadlib.f.i.b(this.qcB.qco)) {
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
                com.ss.android.a.a.a.b eEY = j.eEY();
                if (eEY != null && eEY.a()) {
                    com.ss.android.downloadlib.e.a.eFo().a("install_window_show", this.qcB);
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* loaded from: classes6.dex */
    static class a extends com.ss.android.socialbase.downloader.d.a {
        private com.ss.android.downloadlib.f.j qda;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(com.ss.android.downloadlib.f.j jVar) {
            this.qda = jVar;
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
            this.qda.sendMessage(obtain);
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
    public static List<com.ss.android.a.a.b.e> K(Map<Integer, Object> map) {
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

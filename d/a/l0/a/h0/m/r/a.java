package d.a.l0.a.h0.m.r;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.pms.model.PMSAppInfo;
import d.a.l0.a.a1.e;
import d.a.l0.a.a1.h.a;
import d.a.l0.a.j2.i;
import d.a.l0.a.k;
import d.a.l0.a.q2.e;
import d.a.l0.a.v2.j0;
import d.a.l0.a.v2.q;
import d.a.l0.a.v2.q0;
import d.a.l0.a.v2.w;
import d.a.l0.n.f.h;
import d.a.l0.n.h.f;
import d.a.l0.n.h.g;
import d.a.l0.t.d;
import java.io.File;
import java.io.IOException;
import java.nio.channels.ReadableByteChannel;
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f42412a = k.f43199a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f42413b = false;

    /* renamed from: d.a.l0.a.h0.m.r.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class RunnableC0685a implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            File[] listFiles;
            d.K(new File(AppRuntime.getAppContext().getFilesDir(), "aiapps_zip"));
            File file = new File(AppRuntime.getAppContext().getFilesDir(), "swan_zip");
            if (!file.isDirectory() || (listFiles = file.listFiles()) == null) {
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            for (File file2 : listFiles) {
                long lastModified = file2.lastModified();
                if (file2.isFile() && lastModified > 0 && currentTimeMillis - lastModified > 86400000) {
                    d.K(file2);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f42414a = 0;

        /* renamed from: b  reason: collision with root package name */
        public boolean f42415b = false;

        /* renamed from: c  reason: collision with root package name */
        public String f42416c = "";
    }

    public static d.a.l0.a.q2.a a(ReadableByteChannel readableByteChannel, String str, d.a.l0.n.f.d dVar) throws IOException {
        if (readableByteChannel == null) {
            d.a.l0.a.q2.a aVar = new d.a.l0.a.q2.a();
            aVar.j(11L);
            aVar.h(2300L);
            aVar.e("empty source");
            e.a().f(aVar);
            if (f42412a) {
                Log.i("PkgDownloadUtil", "checkPkgZipSign err: " + aVar);
            }
            return aVar;
        }
        dVar.n("670", "aiapp_aps_check_sign_start_timestamp");
        dVar.n("770", "na_pms_start_check_sign");
        if (j0.d(readableByteChannel, str, new d.a.l0.a.v2.a1.c())) {
            dVar.n("670", "aiapp_aps_check_sign_end_timestamp");
            dVar.n("770", "na_pms_end_check_sign");
            return null;
        }
        d.a.l0.a.q2.a aVar2 = new d.a.l0.a.q2.a();
        aVar2.j(11L);
        aVar2.h(2300L);
        aVar2.e("check zip file sign fail.");
        e.a().f(aVar2);
        if (f42412a) {
            Log.i("PkgDownloadUtil", "checkPkgZipSign err: " + aVar2);
        }
        return aVar2;
    }

    public static boolean b(@Nullable d.a.l0.n.h.e eVar) {
        if (eVar == null || TextUtils.isEmpty(eVar.f48006a)) {
            return false;
        }
        File file = new File(eVar.f48006a);
        return file.exists() && file.isFile() && file.delete();
    }

    @AnyThread
    public static void c() {
        if (f42413b) {
            return;
        }
        synchronized (a.class) {
            if (f42413b) {
                return;
            }
            f42413b = true;
            q.j(new RunnableC0685a(), "deleteHistoryZipFile");
        }
    }

    public static String d() {
        return e.C0561e.h().getPath();
    }

    public static String e() {
        return d.a.l0.a.c1.b.g().c();
    }

    public static String f() {
        return d.a.l0.a.c1.b.g().c();
    }

    public static String g() {
        return e.C0561e.h().getPath();
    }

    public static String h() {
        return e.C0561e.h().getPath();
    }

    public static String i() {
        return d.a.l0.a.c1.b.g().c();
    }

    public static void j(PMSAppInfo pMSAppInfo, f fVar) {
        if (pMSAppInfo == null || fVar == null) {
            return;
        }
        pMSAppInfo.c(fVar);
        if (fVar.f48013h == 1) {
            pMSAppInfo.n(d.a.l0.a.c1.b.i().v(fVar.f48012g, fVar.f48014i));
        } else {
            pMSAppInfo.n(0);
        }
    }

    public static void k(PMSAppInfo pMSAppInfo, g gVar) {
        if (pMSAppInfo == null || gVar == null) {
            return;
        }
        pMSAppInfo.d(gVar);
        if (gVar.f48013h == 0) {
            pMSAppInfo.n(0);
        }
    }

    public static d.a.l0.a.q2.a l(d.a.l0.n.h.e eVar, d.a.l0.n.f.d dVar) {
        File i2;
        if (eVar == null) {
            d.a.l0.a.q2.a aVar = new d.a.l0.a.q2.a();
            aVar.j(11L);
            aVar.h(2320L);
            aVar.e("pkg info is empty");
            d.a.l0.a.q2.e.a().f(aVar);
            return aVar;
        }
        File file = new File(eVar.f48006a);
        int i3 = eVar.f48013h;
        if (i3 == 1) {
            i2 = d.a.l0.a.c1.b.g().a(eVar.f48012g, String.valueOf(eVar.f48014i));
            if (i2 == null) {
                d.a.l0.a.q2.a aVar2 = new d.a.l0.a.q2.a();
                aVar2.j(11L);
                aVar2.h(2320L);
                aVar2.e("获取解压目录失败");
                d.a.l0.a.q2.e.a().f(aVar2);
                return aVar2;
            } else if (f42412a) {
                Log.e("PkgDownloadUtil", "bundleZipFile:" + file);
            }
        } else if (i3 == 0) {
            i2 = e.C0561e.i(eVar.f48012g, String.valueOf(eVar.f48014i));
        } else {
            d.a.l0.a.q2.a aVar3 = new d.a.l0.a.q2.a();
            aVar3.j(11L);
            aVar3.h(2320L);
            aVar3.e("pkh category illegal");
            d.a.l0.a.q2.e.a().f(aVar3);
            return aVar3;
        }
        if (!file.exists()) {
            d.a.l0.a.q2.a aVar4 = new d.a.l0.a.q2.a();
            aVar4.j(11L);
            aVar4.h(2320L);
            aVar4.e("解压失败：包不存在");
            d.a.l0.a.q2.e.a().f(aVar4);
            return aVar4;
        } else if (i2.isFile() && !i2.delete()) {
            d.a.l0.a.e0.d.h("PkgDownloadUtil", "解压失败：解压目录被文件占用，且无法删除 path=" + i2.getAbsolutePath());
            d.a.l0.a.q2.a aVar5 = new d.a.l0.a.q2.a();
            aVar5.j(11L);
            aVar5.h(2320L);
            aVar5.e("解压失败：解压目录被文件占用，且无法删除");
            d.a.l0.a.q2.e.a().f(aVar5);
            return aVar5;
        } else if (!i2.exists() && !i2.mkdirs()) {
            if (f42412a) {
                Log.e("PkgDownloadUtil", "解压失败：解压文件夹创建失败 " + i2.getAbsolutePath());
            }
            d.a.l0.a.q2.a aVar6 = new d.a.l0.a.q2.a();
            aVar6.j(11L);
            aVar6.h(2320L);
            aVar6.e("解压失败：解压文件夹创建失败");
            d.a.l0.a.q2.e.a().f(aVar6);
            return aVar6;
        } else {
            if (f42412a) {
                Log.i("PkgDownloadUtil", "开始执行解压操作, bundle:" + file.getPath() + " , folder:" + i2.getPath());
            }
            if (m(file, i2, dVar).f42415b) {
                return null;
            }
            b m = m(file, i2, dVar);
            if (m.f42415b) {
                i.a(dVar, eVar.f48013h, true);
                return null;
            }
            i.a(dVar, eVar.f48013h, false);
            d.a.l0.a.e0.d.h("PkgDownloadUtil", "解压失败后删除解压目录: " + i2.getAbsolutePath());
            d.K(i2);
            d.a.l0.a.q2.a aVar7 = new d.a.l0.a.q2.a();
            int i4 = m.f42414a;
            if (i4 == 0) {
                aVar7.j(11L);
                aVar7.h(2320L);
                aVar7.e("unzip failed");
            } else if (i4 != 1 && i4 != 2) {
                aVar7.j(4L);
                aVar7.h(7L);
                aVar7.e("Unkown bundle type");
            } else {
                aVar7.j(11L);
                aVar7.h(2330L);
                aVar7.e("decryt failed:" + m.f42416c + ", PkgType=" + m.f42414a);
            }
            d.a.l0.a.q2.e.a().f(aVar7);
            return aVar7;
        }
    }

    @NonNull
    public static b m(@NonNull File file, @NonNull File file2, @NonNull d.a.l0.n.f.d dVar) {
        b bVar = new b();
        long currentTimeMillis = System.currentTimeMillis();
        a.b i2 = d.a.l0.a.a1.h.a.i(file);
        int i3 = 0;
        if (i2.f40715b != -1) {
            dVar.n("670", "package_start_decrypt");
            dVar.n("770", "na_package_start_decrypt");
            a.C0562a c2 = d.a.l0.a.a1.h.a.c(i2.f40714a, file2, i2.f40715b);
            dVar.n("670", "package_end_decrypt");
            dVar.n("770", "na_package_end_decrypt");
            bVar.f42415b = c2.f40712a;
            bVar.f42416c = c2.f40713b;
            i3 = i2.f40715b;
            bVar.f42414a = i3;
        } else {
            bVar.f42414a = 0;
            dVar.n("670", "package_start_unzip");
            dVar.n("770", "na_package_start_unzip");
            boolean T = d.T(file.getPath(), file2.getPath());
            bVar.f42415b = T;
            if (T) {
                boolean A = d.A(file.getAbsolutePath(), file2.getAbsolutePath());
                bVar.f42415b = A;
                if (!A) {
                    d.a.l0.a.j2.p.d dVar2 = new d.a.l0.a.j2.p.d();
                    d.a.l0.a.q2.a aVar = new d.a.l0.a.q2.a();
                    aVar.j(4L);
                    aVar.h(52L);
                    dVar2.p(aVar);
                    dVar2.l("path", file2.getAbsolutePath());
                    dVar2.l("eMsg", "unzip files not match zip content");
                    dVar2.l("decryptType", String.valueOf(i2.f40715b));
                    dVar2.l("stack", q0.z(30));
                    d.a.l0.a.j2.k.L(dVar2);
                }
            }
            dVar.n("670", "package_end_unzip");
            dVar.n("770", "na_package_end_unzip");
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        if (f42412a) {
            d.a.l0.a.a1.h.a.g((int) (currentTimeMillis2 - currentTimeMillis));
        }
        Bundle bundle = new Bundle();
        bundle.putInt("download_package_type_id", i3);
        h.a(dVar, bundle, "event_download_package_type");
        return bVar;
    }

    public static void n(@Nullable PMSAppInfo pMSAppInfo) {
        if (pMSAppInfo == null) {
            return;
        }
        if (!TextUtils.isEmpty(pMSAppInfo.webViewDomains)) {
            d.a.l0.a.b2.a.c.u(pMSAppInfo.appId, "", w.e(pMSAppInfo.webViewDomains));
        }
        if (!TextUtils.isEmpty(pMSAppInfo.webAction)) {
            d.a.l0.a.b2.a.c.t("", w.e(pMSAppInfo.webAction));
        }
        if (!TextUtils.isEmpty(pMSAppInfo.domains)) {
            d.a.l0.a.b2.a.c.s(pMSAppInfo.appId, w.d(pMSAppInfo.domains));
        }
        if (TextUtils.isEmpty(pMSAppInfo.domainConfig)) {
            return;
        }
        d.a.l0.a.b2.a.c.r(pMSAppInfo.appId, pMSAppInfo.domainConfig);
    }
}

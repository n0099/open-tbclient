package d.b.h0.a.e0.p.r;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.pms.model.PMSAppInfo;
import d.b.h0.a.f2.e;
import d.b.h0.a.i2.e0;
import d.b.h0.a.i2.p;
import d.b.h0.a.i2.v;
import d.b.h0.a.k;
import d.b.h0.a.u0.d;
import d.b.h0.a.u0.g.a;
import d.b.h0.g.q.a;
import d.b.h0.l.h.h;
import d.b.h0.l.k.f;
import d.b.h0.l.k.g;
import d.b.h0.p.d;
import java.io.File;
import java.io.IOException;
import java.nio.channels.ReadableByteChannel;
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f44949a = k.f45772a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f44950b = false;

    /* renamed from: d.b.h0.a.e0.p.r.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class RunnableC0709a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ File f44951e;

        public RunnableC0709a(File file) {
            this.f44951e = file;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.w(this.f44951e);
        }
    }

    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f44952a = 0;

        /* renamed from: b  reason: collision with root package name */
        public boolean f44953b = false;

        /* renamed from: c  reason: collision with root package name */
        public String f44954c = "";
    }

    public static d.b.h0.a.f2.a a(ReadableByteChannel readableByteChannel, String str, d.b.h0.l.h.d dVar) throws IOException {
        if (readableByteChannel == null) {
            d.b.h0.a.f2.a aVar = new d.b.h0.a.f2.a();
            aVar.j(11L);
            aVar.h(2300L);
            aVar.e("empty source");
            e.a().f(aVar);
            if (f44949a) {
                Log.i("PkgDownloadUtil", "checkPkgZipSign err: " + aVar);
            }
            return aVar;
        }
        dVar.k("670", "aiapp_aps_check_sign_start_timestamp");
        dVar.k("770", "na_pms_start_check_sign");
        if (e0.d(readableByteChannel, str, new d.b.h0.a.i2.r0.c())) {
            dVar.k("670", "aiapp_aps_check_sign_end_timestamp");
            dVar.k("770", "na_pms_end_check_sign");
            return null;
        }
        d.b.h0.a.f2.a aVar2 = new d.b.h0.a.f2.a();
        aVar2.j(11L);
        aVar2.h(2300L);
        aVar2.e("check zip file sign fail.");
        e.a().f(aVar2);
        if (f44949a) {
            Log.i("PkgDownloadUtil", "checkPkgZipSign err: " + aVar2);
        }
        return aVar2;
    }

    public static boolean b(@Nullable d.b.h0.l.k.e eVar) {
        if (eVar == null || TextUtils.isEmpty(eVar.f49638a)) {
            return false;
        }
        File file = new File(eVar.f49638a);
        return file.exists() && file.isFile() && file.delete();
    }

    @AnyThread
    public static void c() {
        if (f44950b) {
            return;
        }
        synchronized (a.class) {
            if (f44950b) {
                return;
            }
            f44950b = true;
            File file = new File(AppRuntime.getAppContext().getFilesDir(), "aiapps_zip");
            if (file.exists()) {
                p.k(new RunnableC0709a(file), "deleteHistoryZipFile");
            }
        }
    }

    public static String d() {
        return d.e.g().getPath();
    }

    public static String e() {
        return a.d.g().getPath();
    }

    public static String f() {
        return a.d.g().getPath();
    }

    public static String g() {
        return d.e.g().getPath();
    }

    public static String h() {
        return d.e.g().getPath();
    }

    public static d.b.h0.g.z.a.a i(String str, long j) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return d.b.h0.g.z.a.a.a(d.b.h0.p.d.r(new File(a.d.h(str, String.valueOf(j)), "game.json")));
    }

    public static String j() {
        return a.d.g().getPath();
    }

    public static void k(PMSAppInfo pMSAppInfo, f fVar) {
        d.b.h0.g.z.a.a i;
        if (pMSAppInfo == null || fVar == null) {
            return;
        }
        pMSAppInfo.c(fVar);
        if (fVar.f49645h == 1 && (i = i(fVar.f49644g, fVar.i)) != null) {
            pMSAppInfo.m(i.f49415a);
        } else {
            pMSAppInfo.m(0);
        }
    }

    public static void l(PMSAppInfo pMSAppInfo, g gVar) {
        if (pMSAppInfo == null || gVar == null) {
            return;
        }
        pMSAppInfo.d(gVar);
        if (gVar.f49645h == 0) {
            pMSAppInfo.m(0);
        }
    }

    public static d.b.h0.a.f2.a m(d.b.h0.l.k.e eVar, d.b.h0.l.h.d dVar) {
        File h2;
        if (eVar == null) {
            d.b.h0.a.f2.a aVar = new d.b.h0.a.f2.a();
            aVar.j(11L);
            aVar.h(2320L);
            aVar.e("pkg info is empty");
            e.a().f(aVar);
            return aVar;
        }
        File file = new File(eVar.f49638a);
        int i = eVar.f49645h;
        if (i == 1) {
            h2 = a.d.h(eVar.f49644g, String.valueOf(eVar.i));
        } else if (i == 0) {
            h2 = d.e.h(eVar.f49644g, String.valueOf(eVar.i));
        } else {
            d.b.h0.a.f2.a aVar2 = new d.b.h0.a.f2.a();
            aVar2.j(11L);
            aVar2.h(2320L);
            aVar2.e("pkh category illegal");
            e.a().f(aVar2);
            return aVar2;
        }
        if (!file.exists()) {
            d.b.h0.a.f2.a aVar3 = new d.b.h0.a.f2.a();
            aVar3.j(11L);
            aVar3.h(2320L);
            aVar3.e("解压失败：包不存在");
            e.a().f(aVar3);
            return aVar3;
        } else if (h2.isFile() && !h2.delete()) {
            if (f44949a) {
                Log.e("PkgDownloadUtil", "解压失败：解压目录被文件占用，且无法删除");
            }
            d.b.h0.a.f2.a aVar4 = new d.b.h0.a.f2.a();
            aVar4.j(11L);
            aVar4.h(2320L);
            aVar4.e("解压失败：解压目录被文件占用，且无法删除");
            e.a().f(aVar4);
            return aVar4;
        } else if (!h2.exists() && !h2.mkdirs()) {
            if (f44949a) {
                Log.e("PkgDownloadUtil", "解压失败：解压文件夹创建失败 " + h2.getAbsolutePath());
            }
            d.b.h0.a.f2.a aVar5 = new d.b.h0.a.f2.a();
            aVar5.j(11L);
            aVar5.h(2320L);
            aVar5.e("解压失败：解压文件夹创建失败");
            e.a().f(aVar5);
            return aVar5;
        } else {
            if (f44949a) {
                Log.i("PkgDownloadUtil", "开始执行解压操作, bundle:" + file.getPath() + " , folder:" + h2.getPath());
            }
            if (n(file, h2, dVar).f44953b) {
                return null;
            }
            b n = n(file, h2, dVar);
            if (n.f44953b) {
                d.b.h0.a.z1.f.a(dVar, eVar.f49645h, true);
                return null;
            }
            d.b.h0.a.z1.f.a(dVar, eVar.f49645h, false);
            d.b.h0.p.d.w(h2);
            d.b.h0.a.f2.a aVar6 = new d.b.h0.a.f2.a();
            int i2 = n.f44952a;
            if (i2 == 0) {
                aVar6.j(11L);
                aVar6.h(2320L);
                aVar6.e("unzip failed");
            } else if (i2 != 1 && i2 != 2) {
                aVar6.j(4L);
                aVar6.h(7L);
                aVar6.e("Unkown bundle type");
            } else {
                aVar6.j(11L);
                aVar6.h(2330L);
                aVar6.e("decryt failed:" + n.f44954c + ", PkgType=" + n.f44952a);
            }
            e.a().f(aVar6);
            return aVar6;
        }
    }

    @NonNull
    public static b n(@NonNull File file, @NonNull File file2, @NonNull d.b.h0.l.h.d dVar) {
        b bVar = new b();
        long currentTimeMillis = System.currentTimeMillis();
        a.b f2 = d.b.h0.a.u0.g.a.f(file);
        int i = 0;
        if (f2.f47340b != -1) {
            dVar.k("670", "package_start_decrypt");
            dVar.k("770", "na_package_start_decrypt");
            a.C0883a a2 = d.b.h0.a.u0.g.a.a(f2.f47339a, file2, f2.f47340b);
            dVar.k("670", "package_end_decrypt");
            dVar.k("770", "na_package_end_decrypt");
            bVar.f44953b = a2.f47337a;
            bVar.f44954c = a2.f47338b;
            i = f2.f47340b;
            bVar.f44952a = i;
        } else {
            bVar.f44952a = 0;
            dVar.k("670", "package_start_unzip");
            dVar.k("770", "na_package_start_unzip");
            bVar.f44953b = d.b.h0.p.d.F(file.getPath(), file2.getPath());
            dVar.k("670", "package_end_unzip");
            dVar.k("770", "na_package_end_unzip");
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        if (f44949a) {
            d.b.h0.a.u0.g.a.d((int) (currentTimeMillis2 - currentTimeMillis));
        }
        Bundle bundle = new Bundle();
        bundle.putInt("download_package_type_id", i);
        h.a(dVar, bundle, "event_download_package_type");
        return bVar;
    }

    public static void o(@Nullable PMSAppInfo pMSAppInfo) {
        if (pMSAppInfo == null) {
            return;
        }
        if (!TextUtils.isEmpty(pMSAppInfo.webViewDomains)) {
            d.b.h0.a.s1.a.c.o(pMSAppInfo.appId, "", v.c(pMSAppInfo.webViewDomains));
        }
        if (!TextUtils.isEmpty(pMSAppInfo.webAction)) {
            d.b.h0.a.s1.a.c.n("", v.c(pMSAppInfo.webAction));
        }
        if (TextUtils.isEmpty(pMSAppInfo.domains)) {
            return;
        }
        d.b.h0.a.s1.a.c.m(pMSAppInfo.appId, v.b(pMSAppInfo.domains));
    }
}

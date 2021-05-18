package d.a.i0.a.a1;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import d.a.i0.a.a1.e;
import d.a.i0.a.a1.g;
import d.a.i0.a.a1.h.a;
import d.a.i0.a.f1.g.b;
import d.a.i0.a.k;
import d.a.i0.a.v2.q;
import d.a.i0.n.f.h;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.Channels;
import java.nio.channels.Pipe;
/* loaded from: classes3.dex */
public class f extends g.f {
    public static final boolean k = k.f43025a;

    /* renamed from: h  reason: collision with root package name */
    public final d.a.i0.n.h.e f40519h;

    /* renamed from: i  reason: collision with root package name */
    public final d.a.i0.n.f.d f40520i;
    public d.a.i0.a.n2.g.b j;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            f.this.j();
        }
    }

    public f(d.a.i0.n.h.e eVar, d.a.i0.n.f.d dVar) {
        super("extract");
        this.f40519h = eVar;
        this.f40520i = dVar;
    }

    @Override // d.a.i0.a.a1.g.f
    public void e() {
        super.e();
        if (b().getBoolean("result_output_dir_allow_rollback", false)) {
            String string = b().getString("result_output_dir");
            d.a.i0.a.e0.d.h("SwanExtractor", "#onInstallFaild del: " + string);
            d.a.i0.t.d.L(string);
        }
    }

    @Override // d.a.i0.a.a1.g.f
    public boolean f(Pipe.SourceChannel sourceChannel, Bundle bundle) {
        d.a.i0.a.f1.g.a aVar;
        String string = bundle.getString("launch_id");
        if (k) {
            aVar = d.a.i0.a.f1.g.a.d(string);
            b.C0624b e2 = aVar.e();
            e2.b("SwanExtractor");
            e2.d(1);
        } else {
            aVar = null;
        }
        boolean k2 = k(Channels.newInputStream(sourceChannel), string);
        if (aVar != null && k) {
            aVar.g("SwanExtractor", "done: " + k2);
        }
        return k2;
    }

    public final void j() {
        d.a.i0.n.h.e eVar = this.f40519h;
        if (eVar == null || eVar.f47837h != 0 || e.w()) {
            return;
        }
        e.e(this.f40519h.f47836g + File.separator + this.f40519h.f47838i);
    }

    public final boolean k(InputStream inputStream, String str) {
        if (inputStream == null) {
            return false;
        }
        d.a.i0.a.q2.a q = q(new BufferedInputStream(inputStream), str);
        if (q == null) {
            return true;
        }
        d.a.i0.a.e0.d.h("SwanExtractor", "#extract error=" + q);
        if (k) {
            d.a.i0.a.f1.g.a d2 = d.a.i0.a.f1.g.a.d(str);
            d2.g("SwanExtractor", "onProcess installe error=" + q);
        }
        b().putLong("result_error_code", q.a());
        return false;
    }

    public final void l(boolean z) {
        if (z) {
            p("670", "package_end_decrypt");
            p("770", "na_package_end_decrypt");
            return;
        }
        p("670", "package_end_unzip");
        p("770", "na_package_end_unzip");
    }

    public final void m(boolean z) {
        if (z) {
            p("670", "package_start_decrypt");
            p("770", "na_package_start_decrypt");
            return;
        }
        p("670", "package_start_unzip");
        p("770", "na_package_start_unzip");
    }

    public void n(String str) {
        if (d.a.i0.a.n2.g.a.c() <= 0) {
            return;
        }
        if (k) {
            Log.i("SwanExtractor", "startUnzipFileObserver: ");
        }
        if (this.j == null) {
            d.a.i0.a.n2.g.b bVar = new d.a.i0.a.n2.g.b(str);
            this.j = bVar;
            bVar.startWatching();
        }
    }

    public void o() {
        if (d.a.i0.a.n2.g.a.c() <= 0) {
            return;
        }
        if (k) {
            Log.i("SwanExtractor", "stopUnzipFileObserver: ");
        }
        d.a.i0.a.n2.g.b bVar = this.j;
        if (bVar == null) {
            return;
        }
        bVar.stopWatching();
        this.j = null;
    }

    public final void p(String str, String str2) {
        d.a.i0.n.f.d dVar = this.f40520i;
        if (dVar != null) {
            dVar.n(str, str2);
        }
    }

    public final d.a.i0.a.q2.a q(@NonNull BufferedInputStream bufferedInputStream, String str) {
        File i2;
        a.C0551a c0551a;
        d.a.i0.a.f1.g.a d2 = d.a.i0.a.f1.g.a.d(str);
        d.a.i0.n.h.e eVar = this.f40519h;
        if (eVar == null) {
            d.a.i0.a.q2.a aVar = new d.a.i0.a.q2.a();
            aVar.j(11L);
            aVar.h(2320L);
            aVar.e("pkg info is empty");
            d.a.i0.a.q2.e.a().f(aVar);
            return aVar;
        }
        int i3 = eVar.f47837h;
        boolean z = true;
        if (i3 == 1) {
            d.a.i0.a.p.b.a.e g2 = d.a.i0.a.c1.b.g();
            d.a.i0.n.h.e eVar2 = this.f40519h;
            i2 = g2.a(eVar2.f47836g, String.valueOf(eVar2.f47838i));
        } else if (i3 == 0) {
            i2 = e.C0550e.i(eVar.f47836g, String.valueOf(eVar.f47838i));
        } else {
            d.a.i0.a.q2.a aVar2 = new d.a.i0.a.q2.a();
            aVar2.j(11L);
            aVar2.h(2320L);
            aVar2.e("pkh category illegal");
            d.a.i0.a.q2.e.a().f(aVar2);
            return aVar2;
        }
        if (i2 == null) {
            d.a.i0.a.q2.a aVar3 = new d.a.i0.a.q2.a();
            aVar3.j(11L);
            aVar3.h(2320L);
            aVar3.e("获取解压目录失败");
            d.a.i0.a.q2.e.a().f(aVar3);
            return aVar3;
        } else if (i2.isFile() && !i2.delete()) {
            if (k) {
                d2.g("SwanExtractor", "解压失败：解压目录被文件占用，且无法删除");
            }
            d.a.i0.a.q2.a aVar4 = new d.a.i0.a.q2.a();
            aVar4.j(11L);
            aVar4.h(2320L);
            aVar4.e("解压失败：解压目录被文件占用，且无法删除");
            d.a.i0.a.q2.e.a().f(aVar4);
            return aVar4;
        } else {
            if (!i2.exists()) {
                b().putBoolean("result_output_dir_allow_rollback", true);
                if (!i2.mkdirs()) {
                    if (k) {
                        d2.g("SwanExtractor", "解压失败：解压文件夹创建失败");
                    }
                    q.j(new a(), "doFallbackIfNeeded");
                    d.a.i0.a.q2.a aVar5 = new d.a.i0.a.q2.a();
                    aVar5.j(11L);
                    aVar5.h(2320L);
                    aVar5.e("解压失败：解压文件夹创建失败");
                    d.a.i0.a.q2.e.a().f(aVar5);
                    return aVar5;
                }
            }
            n(i2.getPath());
            if (k) {
                d2.g("SwanExtractor", "开始执行解压操作, folder:" + i2.getPath());
            }
            b().putString("result_output_dir", i2.toString());
            long currentTimeMillis = System.currentTimeMillis();
            try {
                a.b h2 = d.a.i0.a.a1.h.a.h(bufferedInputStream);
                int i4 = h2 == null ? -1 : h2.f40541b;
                boolean z2 = i4 != -1;
                m(z2);
                if (z2) {
                    c0551a = d.a.i0.a.a1.h.a.c(bufferedInputStream, i2, i4);
                    if (c0551a == null || !c0551a.f40538a) {
                        z = false;
                    }
                } else {
                    z = d.a.i0.t.g.d(bufferedInputStream, i2.getPath());
                    c0551a = null;
                    i4 = 0;
                }
                l(z2);
                long currentTimeMillis2 = System.currentTimeMillis();
                if (k) {
                    d.a.i0.a.a1.h.a.g((int) (currentTimeMillis2 - currentTimeMillis));
                }
                if (this.f40520i != null) {
                    Bundle bundle = new Bundle();
                    bundle.putInt("download_package_type_id", i4);
                    h.a(this.f40520i, bundle, "event_download_package_type");
                }
                o();
                if (z) {
                    return null;
                }
                d.a.i0.a.q2.a aVar6 = new d.a.i0.a.q2.a();
                aVar6.j(11L);
                if (z2) {
                    aVar6.h(2330L);
                    aVar6.e("decrypt failed:" + c0551a.f40539b);
                } else {
                    aVar6.h(2320L);
                    aVar6.e("unzip failed");
                }
                d.a.i0.a.q2.e.a().f(aVar6);
                return aVar6;
            } catch (IOException e2) {
                if (k) {
                    d2.g("SwanExtractor", "obtainEncryptedBundle Exception: " + e2.toString());
                    e2.printStackTrace();
                }
                d.a.i0.a.q2.a aVar7 = new d.a.i0.a.q2.a();
                aVar7.j(11L);
                aVar7.h(2320L);
                aVar7.e("obtainEncryptedBundle Exception: " + e2.toString());
                d.a.i0.a.q2.e.a().f(aVar7);
                return aVar7;
            }
        }
    }
}

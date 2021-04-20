package d.b.g0.a.u0;

import android.os.Bundle;
import androidx.annotation.NonNull;
import d.b.g0.a.k;
import d.b.g0.a.u0.d;
import d.b.g0.a.u0.f;
import d.b.g0.a.u0.g.a;
import d.b.g0.a.y0.g.b;
import d.b.g0.g.q.a;
import d.b.g0.l.h.h;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.Channels;
import java.nio.channels.Pipe;
/* loaded from: classes2.dex */
public class e extends f.AbstractC0862f {
    public static final boolean j = k.f45443a;

    /* renamed from: h  reason: collision with root package name */
    public final d.b.g0.l.k.e f46994h;
    public final d.b.g0.l.h.d i;

    public e(d.b.g0.l.k.e eVar, d.b.g0.l.h.d dVar) {
        super("extract");
        this.f46994h = eVar;
        this.i = dVar;
    }

    @Override // d.b.g0.a.u0.f.AbstractC0862f
    public void e() {
        super.e();
        if (b().getBoolean("result_output_dir_allow_rollback", false)) {
            d.b.g0.p.d.x(b().getString("result_output_dir"));
        }
    }

    @Override // d.b.g0.a.u0.f.AbstractC0862f
    public boolean f(Pipe.SourceChannel sourceChannel, Bundle bundle) {
        d.b.g0.a.y0.g.a aVar;
        String string = bundle.getString("launch_id");
        if (j) {
            aVar = d.b.g0.a.y0.g.a.d(string);
            b.C0898b e2 = aVar.e();
            e2.b("SwanExtractor");
            e2.d(1);
        } else {
            aVar = null;
        }
        boolean i = i(Channels.newInputStream(sourceChannel), string);
        if (aVar != null && j) {
            aVar.g("SwanExtractor", "done: " + i);
        }
        return i;
    }

    public final boolean i(InputStream inputStream, String str) {
        if (inputStream == null) {
            return false;
        }
        d.b.g0.a.f2.a m = m(new BufferedInputStream(inputStream), str);
        if (m == null) {
            return true;
        }
        if (j) {
            d.b.g0.a.y0.g.a d2 = d.b.g0.a.y0.g.a.d(str);
            d2.g("SwanExtractor", "onProcess installe error=" + m);
        }
        b().putLong("result_error_code", m.a());
        return false;
    }

    public final void j(boolean z) {
        if (z) {
            l("670", "package_end_decrypt");
            l("770", "na_package_end_decrypt");
            return;
        }
        l("670", "package_end_unzip");
        l("770", "na_package_end_unzip");
    }

    public final void k(boolean z) {
        if (z) {
            l("670", "package_start_decrypt");
            l("770", "na_package_start_decrypt");
            return;
        }
        l("670", "package_start_unzip");
        l("770", "na_package_start_unzip");
    }

    public final void l(String str, String str2) {
        d.b.g0.l.h.d dVar = this.i;
        if (dVar != null) {
            dVar.k(str, str2);
        }
    }

    public final d.b.g0.a.f2.a m(@NonNull BufferedInputStream bufferedInputStream, String str) {
        File h2;
        a.C0863a c0863a;
        d.b.g0.a.y0.g.a d2 = d.b.g0.a.y0.g.a.d(str);
        d.b.g0.l.k.e eVar = this.f46994h;
        if (eVar == null) {
            d.b.g0.a.f2.a aVar = new d.b.g0.a.f2.a();
            aVar.j(11L);
            aVar.h(2320L);
            aVar.e("pkg info is empty");
            d.b.g0.a.f2.e.a().f(aVar);
            return aVar;
        }
        int i = eVar.f49316h;
        boolean z = true;
        if (i == 1) {
            h2 = a.d.h(eVar.f49315g, String.valueOf(eVar.i));
        } else if (i == 0) {
            h2 = d.e.h(eVar.f49315g, String.valueOf(eVar.i));
        } else {
            d.b.g0.a.f2.a aVar2 = new d.b.g0.a.f2.a();
            aVar2.j(11L);
            aVar2.h(2320L);
            aVar2.e("pkh category illegal");
            d.b.g0.a.f2.e.a().f(aVar2);
            return aVar2;
        }
        if (h2.isFile() && !h2.delete()) {
            if (j) {
                d2.g("SwanExtractor", "解压失败：解压目录被文件占用，且无法删除");
            }
            d.b.g0.a.f2.a aVar3 = new d.b.g0.a.f2.a();
            aVar3.j(11L);
            aVar3.h(2320L);
            aVar3.e("解压失败：解压目录被文件占用，且无法删除");
            d.b.g0.a.f2.e.a().f(aVar3);
            return aVar3;
        }
        if (!h2.exists()) {
            b().putBoolean("result_output_dir_allow_rollback", true);
            if (!h2.mkdirs()) {
                if (j) {
                    d2.g("SwanExtractor", "解压失败：解压文件夹创建失败");
                }
                d.b.g0.a.f2.a aVar4 = new d.b.g0.a.f2.a();
                aVar4.j(11L);
                aVar4.h(2320L);
                aVar4.e("解压失败：解压文件夹创建失败");
                d.b.g0.a.f2.e.a().f(aVar4);
                return aVar4;
            }
        }
        if (j) {
            d2.g("SwanExtractor", "开始执行解压操作, folder:" + h2.getPath());
        }
        b().putString("result_output_dir", h2.toString());
        long currentTimeMillis = System.currentTimeMillis();
        try {
            a.b e2 = d.b.g0.a.u0.g.a.e(bufferedInputStream);
            int i2 = e2 == null ? -1 : e2.f47011b;
            boolean z2 = i2 != -1;
            k(z2);
            if (z2) {
                c0863a = d.b.g0.a.u0.g.a.a(bufferedInputStream, h2, i2);
                if (c0863a == null || !c0863a.f47008a) {
                    z = false;
                }
            } else {
                z = d.b.g0.p.f.d(bufferedInputStream, h2.getPath());
                c0863a = null;
                i2 = 0;
            }
            j(z2);
            long currentTimeMillis2 = System.currentTimeMillis();
            if (j) {
                d.b.g0.a.u0.g.a.d((int) (currentTimeMillis2 - currentTimeMillis));
            }
            if (this.i != null) {
                Bundle bundle = new Bundle();
                bundle.putInt("download_package_type_id", i2);
                h.a(this.i, bundle, "event_download_package_type");
            }
            if (z) {
                return null;
            }
            d.b.g0.a.f2.a aVar5 = new d.b.g0.a.f2.a();
            aVar5.j(11L);
            if (z2) {
                aVar5.h(2330L);
                aVar5.e("decrypt failed:" + c0863a.f47009b);
            } else {
                aVar5.h(2320L);
                aVar5.e("unzip failed");
            }
            d.b.g0.a.f2.e.a().f(aVar5);
            return aVar5;
        } catch (IOException e3) {
            if (j) {
                d2.g("SwanExtractor", "obtainEncryptedBundle Exception: " + e3.toString());
                e3.printStackTrace();
            }
            d.b.g0.a.f2.a aVar6 = new d.b.g0.a.f2.a();
            aVar6.j(11L);
            aVar6.h(2320L);
            aVar6.e("obtainEncryptedBundle Exception: " + e3.toString());
            d.b.g0.a.f2.e.a().f(aVar6);
            return aVar6;
        }
    }
}

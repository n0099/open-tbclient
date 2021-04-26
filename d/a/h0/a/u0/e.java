package d.a.h0.a.u0;

import android.os.Bundle;
import androidx.annotation.NonNull;
import d.a.h0.a.k;
import d.a.h0.a.u0.d;
import d.a.h0.a.u0.f;
import d.a.h0.a.u0.g.a;
import d.a.h0.a.y0.g.b;
import d.a.h0.g.q.a;
import d.a.h0.l.h.h;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.Channels;
import java.nio.channels.Pipe;
/* loaded from: classes2.dex */
public class e extends f.AbstractC0821f {
    public static final boolean j = k.f43101a;

    /* renamed from: h  reason: collision with root package name */
    public final d.a.h0.l.k.e f44734h;

    /* renamed from: i  reason: collision with root package name */
    public final d.a.h0.l.h.d f44735i;

    public e(d.a.h0.l.k.e eVar, d.a.h0.l.h.d dVar) {
        super("extract");
        this.f44734h = eVar;
        this.f44735i = dVar;
    }

    @Override // d.a.h0.a.u0.f.AbstractC0821f
    public void e() {
        super.e();
        if (b().getBoolean("result_output_dir_allow_rollback", false)) {
            d.a.h0.p.d.x(b().getString("result_output_dir"));
        }
    }

    @Override // d.a.h0.a.u0.f.AbstractC0821f
    public boolean f(Pipe.SourceChannel sourceChannel, Bundle bundle) {
        d.a.h0.a.y0.g.a aVar;
        String string = bundle.getString("launch_id");
        if (j) {
            aVar = d.a.h0.a.y0.g.a.d(string);
            b.C0857b e2 = aVar.e();
            e2.b("SwanExtractor");
            e2.d(1);
        } else {
            aVar = null;
        }
        boolean i2 = i(Channels.newInputStream(sourceChannel), string);
        if (aVar != null && j) {
            aVar.g("SwanExtractor", "done: " + i2);
        }
        return i2;
    }

    public final boolean i(InputStream inputStream, String str) {
        if (inputStream == null) {
            return false;
        }
        d.a.h0.a.f2.a m = m(new BufferedInputStream(inputStream), str);
        if (m == null) {
            return true;
        }
        if (j) {
            d.a.h0.a.y0.g.a d2 = d.a.h0.a.y0.g.a.d(str);
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
        d.a.h0.l.h.d dVar = this.f44735i;
        if (dVar != null) {
            dVar.n(str, str2);
        }
    }

    public final d.a.h0.a.f2.a m(@NonNull BufferedInputStream bufferedInputStream, String str) {
        File h2;
        a.C0822a c0822a;
        d.a.h0.a.y0.g.a d2 = d.a.h0.a.y0.g.a.d(str);
        d.a.h0.l.k.e eVar = this.f44734h;
        if (eVar == null) {
            d.a.h0.a.f2.a aVar = new d.a.h0.a.f2.a();
            aVar.j(11L);
            aVar.h(2320L);
            aVar.e("pkg info is empty");
            d.a.h0.a.f2.e.a().f(aVar);
            return aVar;
        }
        int i2 = eVar.f47154h;
        boolean z = true;
        if (i2 == 1) {
            h2 = a.d.h(eVar.f47153g, String.valueOf(eVar.f47155i));
        } else if (i2 == 0) {
            h2 = d.e.h(eVar.f47153g, String.valueOf(eVar.f47155i));
        } else {
            d.a.h0.a.f2.a aVar2 = new d.a.h0.a.f2.a();
            aVar2.j(11L);
            aVar2.h(2320L);
            aVar2.e("pkh category illegal");
            d.a.h0.a.f2.e.a().f(aVar2);
            return aVar2;
        }
        if (h2.isFile() && !h2.delete()) {
            if (j) {
                d2.g("SwanExtractor", "解压失败：解压目录被文件占用，且无法删除");
            }
            d.a.h0.a.f2.a aVar3 = new d.a.h0.a.f2.a();
            aVar3.j(11L);
            aVar3.h(2320L);
            aVar3.e("解压失败：解压目录被文件占用，且无法删除");
            d.a.h0.a.f2.e.a().f(aVar3);
            return aVar3;
        }
        if (!h2.exists()) {
            b().putBoolean("result_output_dir_allow_rollback", true);
            if (!h2.mkdirs()) {
                if (j) {
                    d2.g("SwanExtractor", "解压失败：解压文件夹创建失败");
                }
                d.a.h0.a.f2.a aVar4 = new d.a.h0.a.f2.a();
                aVar4.j(11L);
                aVar4.h(2320L);
                aVar4.e("解压失败：解压文件夹创建失败");
                d.a.h0.a.f2.e.a().f(aVar4);
                return aVar4;
            }
        }
        if (j) {
            d2.g("SwanExtractor", "开始执行解压操作, folder:" + h2.getPath());
        }
        b().putString("result_output_dir", h2.toString());
        long currentTimeMillis = System.currentTimeMillis();
        try {
            a.b e2 = d.a.h0.a.u0.g.a.e(bufferedInputStream);
            int i3 = e2 == null ? -1 : e2.f44753b;
            boolean z2 = i3 != -1;
            k(z2);
            if (z2) {
                c0822a = d.a.h0.a.u0.g.a.a(bufferedInputStream, h2, i3);
                if (c0822a == null || !c0822a.f44750a) {
                    z = false;
                }
            } else {
                z = d.a.h0.p.f.d(bufferedInputStream, h2.getPath());
                c0822a = null;
                i3 = 0;
            }
            j(z2);
            long currentTimeMillis2 = System.currentTimeMillis();
            if (j) {
                d.a.h0.a.u0.g.a.d((int) (currentTimeMillis2 - currentTimeMillis));
            }
            if (this.f44735i != null) {
                Bundle bundle = new Bundle();
                bundle.putInt("download_package_type_id", i3);
                h.a(this.f44735i, bundle, "event_download_package_type");
            }
            if (z) {
                return null;
            }
            d.a.h0.a.f2.a aVar5 = new d.a.h0.a.f2.a();
            aVar5.j(11L);
            if (z2) {
                aVar5.h(2330L);
                aVar5.e("decrypt failed:" + c0822a.f44751b);
            } else {
                aVar5.h(2320L);
                aVar5.e("unzip failed");
            }
            d.a.h0.a.f2.e.a().f(aVar5);
            return aVar5;
        } catch (IOException e3) {
            if (j) {
                d2.g("SwanExtractor", "obtainEncryptedBundle Exception: " + e3.toString());
                e3.printStackTrace();
            }
            d.a.h0.a.f2.a aVar6 = new d.a.h0.a.f2.a();
            aVar6.j(11L);
            aVar6.h(2320L);
            aVar6.e("obtainEncryptedBundle Exception: " + e3.toString());
            d.a.h0.a.f2.e.a().f(aVar6);
            return aVar6;
        }
    }
}

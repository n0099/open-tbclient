package d.b.j0.q3.j.f;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.TbMd5;
import com.baidu.tbadk.download.DownloadData;
import d.b.i0.v.c;
import d.b.i0.v.d;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: c  reason: collision with root package name */
    public static volatile b f61101c;

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, String> f61102a;

    /* renamed from: b  reason: collision with root package name */
    public DownloadData f61103b;

    /* loaded from: classes5.dex */
    public class a implements c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ InterfaceC1547b f61104a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f61105b;

        public a(InterfaceC1547b interfaceC1547b, String str) {
            this.f61104a = interfaceC1547b;
            this.f61105b = str;
        }

        @Override // d.b.i0.v.c
        public void onFileDownloadFailed(DownloadData downloadData, int i, String str) {
            File file = new File(downloadData.getPath());
            if (file.exists()) {
                file.delete();
            }
            if (b.this.f61103b != null && downloadData.getUrl().equals(b.this.f61103b.getUrl())) {
                b.this.f61103b = null;
            }
            InterfaceC1547b interfaceC1547b = this.f61104a;
            if (interfaceC1547b != null) {
                interfaceC1547b.a(str);
            }
        }

        @Override // d.b.i0.v.c
        public void onFileDownloadSucceed(DownloadData downloadData) {
            if (downloadData == null || StringUtils.isNull(downloadData.getPath())) {
                return;
            }
            if (b.this.f61103b != null && downloadData.getUrl().equals(b.this.f61103b.getUrl())) {
                b.this.f61103b = null;
            }
            if (this.f61104a != null) {
                b.this.f61102a.put(downloadData.getPath().substring(d.b.j0.q3.c.f60981e.length(), downloadData.getPath().lastIndexOf(".")), downloadData.getPath());
                this.f61104a.c(this.f61105b, downloadData.getPath());
            }
        }

        @Override // d.b.i0.v.c
        public boolean onFileDownloaded(DownloadData downloadData) {
            return true;
        }

        @Override // d.b.i0.v.c
        public void onFileUpdateProgress(DownloadData downloadData) {
            if (downloadData.getStatus() == 4) {
                File file = new File(downloadData.getPath());
                if (file.exists()) {
                    file.delete();
                }
                if (b.this.f61103b != null && downloadData.getUrl().equals(b.this.f61103b.getUrl())) {
                    b.this.f61103b = null;
                }
                InterfaceC1547b interfaceC1547b = this.f61104a;
                if (interfaceC1547b != null) {
                    interfaceC1547b.b();
                }
            }
        }

        @Override // d.b.i0.v.c
        public boolean onPreDownload(DownloadData downloadData) {
            return true;
        }
    }

    /* renamed from: d.b.j0.q3.j.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC1547b {
        void a(String str);

        void b();

        void c(String str, String str2);
    }

    public static b g() {
        if (f61101c == null) {
            synchronized (b.class) {
                if (f61101c == null) {
                    f61101c = new b();
                }
            }
        }
        return f61101c;
    }

    public void d() {
        File[] listFiles;
        HashMap<String, String> hashMap = this.f61102a;
        if (hashMap == null) {
            this.f61102a = new HashMap<>();
        } else {
            hashMap.clear();
        }
        File file = new File(d.b.j0.q3.c.f60981e);
        if (file.exists()) {
            for (File file2 : file.listFiles()) {
                if (file2.isFile()) {
                    this.f61102a.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                }
            }
        }
    }

    public void e(String str, String str2, InterfaceC1547b interfaceC1547b) {
        String nameMd5FromUrl;
        if (TextUtils.isEmpty(str2) || (nameMd5FromUrl = TbMd5.getNameMd5FromUrl(str2)) == null) {
            return;
        }
        if (this.f61103b != null) {
            d.j().g(this.f61103b.getUrl(), true);
        }
        File file = new File(d.b.j0.q3.c.f60981e);
        if (!file.exists()) {
            file.mkdirs();
        }
        DownloadData downloadData = new DownloadData();
        downloadData.setType(18);
        downloadData.setId(str);
        downloadData.setUrl(str2);
        downloadData.setPath(d.b.j0.q3.c.f60981e + nameMd5FromUrl + ("." + str2.substring(str2.lastIndexOf(".") + 1)));
        downloadData.setCallback(new a(interfaceC1547b, str2));
        this.f61103b = downloadData;
        d.j().k(downloadData);
    }

    public String f(String str) {
        String nameMd5FromUrl = TbMd5.getNameMd5FromUrl(str);
        if (nameMd5FromUrl == null) {
            return null;
        }
        HashMap<String, String> hashMap = this.f61102a;
        if (hashMap == null) {
            this.f61102a = new HashMap<>();
            d();
            if (this.f61102a.size() > 0) {
                return this.f61102a.get(nameMd5FromUrl);
            }
            return null;
        }
        return hashMap.get(nameMd5FromUrl);
    }
}

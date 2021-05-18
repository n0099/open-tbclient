package d.a.k0.q3.j.f;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.TbMd5;
import com.baidu.tbadk.download.DownloadData;
import d.a.j0.v.c;
import d.a.j0.v.d;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: c  reason: collision with root package name */
    public static volatile b f59981c;

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, String> f59982a;

    /* renamed from: b  reason: collision with root package name */
    public DownloadData f59983b;

    /* loaded from: classes5.dex */
    public class a implements c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ InterfaceC1560b f59984a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f59985b;

        public a(InterfaceC1560b interfaceC1560b, String str) {
            this.f59984a = interfaceC1560b;
            this.f59985b = str;
        }

        @Override // d.a.j0.v.c
        public void onFileDownloadFailed(DownloadData downloadData, int i2, String str) {
            File file = new File(downloadData.getPath());
            if (file.exists()) {
                file.delete();
            }
            if (b.this.f59983b != null && downloadData.getUrl().equals(b.this.f59983b.getUrl())) {
                b.this.f59983b = null;
            }
            InterfaceC1560b interfaceC1560b = this.f59984a;
            if (interfaceC1560b != null) {
                interfaceC1560b.a(str);
            }
        }

        @Override // d.a.j0.v.c
        public void onFileDownloadSucceed(DownloadData downloadData) {
            if (downloadData == null || StringUtils.isNull(downloadData.getPath())) {
                return;
            }
            if (b.this.f59983b != null && downloadData.getUrl().equals(b.this.f59983b.getUrl())) {
                b.this.f59983b = null;
            }
            if (this.f59984a != null) {
                b.this.f59982a.put(downloadData.getPath().substring(d.a.k0.q3.c.f59856e.length(), downloadData.getPath().lastIndexOf(".")), downloadData.getPath());
                this.f59984a.c(this.f59985b, downloadData.getPath());
            }
        }

        @Override // d.a.j0.v.c
        public boolean onFileDownloaded(DownloadData downloadData) {
            return true;
        }

        @Override // d.a.j0.v.c
        public void onFileUpdateProgress(DownloadData downloadData) {
            if (downloadData.getStatus() == 4) {
                File file = new File(downloadData.getPath());
                if (file.exists()) {
                    file.delete();
                }
                if (b.this.f59983b != null && downloadData.getUrl().equals(b.this.f59983b.getUrl())) {
                    b.this.f59983b = null;
                }
                InterfaceC1560b interfaceC1560b = this.f59984a;
                if (interfaceC1560b != null) {
                    interfaceC1560b.b();
                }
            }
        }

        @Override // d.a.j0.v.c
        public boolean onPreDownload(DownloadData downloadData) {
            return true;
        }
    }

    /* renamed from: d.a.k0.q3.j.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC1560b {
        void a(String str);

        void b();

        void c(String str, String str2);
    }

    public static b g() {
        if (f59981c == null) {
            synchronized (b.class) {
                if (f59981c == null) {
                    f59981c = new b();
                }
            }
        }
        return f59981c;
    }

    public void d() {
        File[] listFiles;
        HashMap<String, String> hashMap = this.f59982a;
        if (hashMap == null) {
            this.f59982a = new HashMap<>();
        } else {
            hashMap.clear();
        }
        File file = new File(d.a.k0.q3.c.f59856e);
        if (file.exists()) {
            for (File file2 : file.listFiles()) {
                if (file2.isFile()) {
                    this.f59982a.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                }
            }
        }
    }

    public void e(String str, String str2, InterfaceC1560b interfaceC1560b) {
        String nameMd5FromUrl;
        if (TextUtils.isEmpty(str2) || (nameMd5FromUrl = TbMd5.getNameMd5FromUrl(str2)) == null) {
            return;
        }
        if (this.f59983b != null) {
            d.j().g(this.f59983b.getUrl(), true);
        }
        File file = new File(d.a.k0.q3.c.f59856e);
        if (!file.exists()) {
            file.mkdirs();
        }
        DownloadData downloadData = new DownloadData();
        downloadData.setType(18);
        downloadData.setId(str);
        downloadData.setUrl(str2);
        downloadData.setPath(d.a.k0.q3.c.f59856e + nameMd5FromUrl + ("." + str2.substring(str2.lastIndexOf(".") + 1)));
        downloadData.setCallback(new a(interfaceC1560b, str2));
        this.f59983b = downloadData;
        d.j().k(downloadData);
    }

    public String f(String str) {
        String nameMd5FromUrl = TbMd5.getNameMd5FromUrl(str);
        if (nameMd5FromUrl == null) {
            return null;
        }
        HashMap<String, String> hashMap = this.f59982a;
        if (hashMap == null) {
            this.f59982a = new HashMap<>();
            d();
            if (this.f59982a.size() > 0) {
                return this.f59982a.get(nameMd5FromUrl);
            }
            return null;
        }
        return hashMap.get(nameMd5FromUrl);
    }
}

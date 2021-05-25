package d.a.n0.r3.j.f;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.TbMd5;
import com.baidu.tbadk.download.DownloadData;
import d.a.m0.v.c;
import d.a.m0.v.d;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: c  reason: collision with root package name */
    public static volatile b f60122c;

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, String> f60123a;

    /* renamed from: b  reason: collision with root package name */
    public DownloadData f60124b;

    /* loaded from: classes5.dex */
    public class a implements c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ InterfaceC1573b f60125a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f60126b;

        public a(InterfaceC1573b interfaceC1573b, String str) {
            this.f60125a = interfaceC1573b;
            this.f60126b = str;
        }

        @Override // d.a.m0.v.c
        public void onFileDownloadFailed(DownloadData downloadData, int i2, String str) {
            File file = new File(downloadData.getPath());
            if (file.exists()) {
                file.delete();
            }
            if (b.this.f60124b != null && downloadData.getUrl().equals(b.this.f60124b.getUrl())) {
                b.this.f60124b = null;
            }
            InterfaceC1573b interfaceC1573b = this.f60125a;
            if (interfaceC1573b != null) {
                interfaceC1573b.a(str);
            }
        }

        @Override // d.a.m0.v.c
        public void onFileDownloadSucceed(DownloadData downloadData) {
            if (downloadData == null || StringUtils.isNull(downloadData.getPath())) {
                return;
            }
            if (b.this.f60124b != null && downloadData.getUrl().equals(b.this.f60124b.getUrl())) {
                b.this.f60124b = null;
            }
            if (this.f60125a != null) {
                b.this.f60123a.put(downloadData.getPath().substring(d.a.n0.r3.c.f59997e.length(), downloadData.getPath().lastIndexOf(".")), downloadData.getPath());
                this.f60125a.c(this.f60126b, downloadData.getPath());
            }
        }

        @Override // d.a.m0.v.c
        public boolean onFileDownloaded(DownloadData downloadData) {
            return true;
        }

        @Override // d.a.m0.v.c
        public void onFileUpdateProgress(DownloadData downloadData) {
            if (downloadData.getStatus() == 4) {
                File file = new File(downloadData.getPath());
                if (file.exists()) {
                    file.delete();
                }
                if (b.this.f60124b != null && downloadData.getUrl().equals(b.this.f60124b.getUrl())) {
                    b.this.f60124b = null;
                }
                InterfaceC1573b interfaceC1573b = this.f60125a;
                if (interfaceC1573b != null) {
                    interfaceC1573b.b();
                }
            }
        }

        @Override // d.a.m0.v.c
        public boolean onPreDownload(DownloadData downloadData) {
            return true;
        }
    }

    /* renamed from: d.a.n0.r3.j.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC1573b {
        void a(String str);

        void b();

        void c(String str, String str2);
    }

    public static b g() {
        if (f60122c == null) {
            synchronized (b.class) {
                if (f60122c == null) {
                    f60122c = new b();
                }
            }
        }
        return f60122c;
    }

    public void d() {
        File[] listFiles;
        HashMap<String, String> hashMap = this.f60123a;
        if (hashMap == null) {
            this.f60123a = new HashMap<>();
        } else {
            hashMap.clear();
        }
        File file = new File(d.a.n0.r3.c.f59997e);
        if (file.exists()) {
            for (File file2 : file.listFiles()) {
                if (file2.isFile()) {
                    this.f60123a.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                }
            }
        }
    }

    public void e(String str, String str2, InterfaceC1573b interfaceC1573b) {
        String nameMd5FromUrl;
        if (TextUtils.isEmpty(str2) || (nameMd5FromUrl = TbMd5.getNameMd5FromUrl(str2)) == null) {
            return;
        }
        if (this.f60124b != null) {
            d.j().g(this.f60124b.getUrl(), true);
        }
        File file = new File(d.a.n0.r3.c.f59997e);
        if (!file.exists()) {
            file.mkdirs();
        }
        DownloadData downloadData = new DownloadData();
        downloadData.setType(18);
        downloadData.setId(str);
        downloadData.setUrl(str2);
        downloadData.setPath(d.a.n0.r3.c.f59997e + nameMd5FromUrl + ("." + str2.substring(str2.lastIndexOf(".") + 1)));
        downloadData.setCallback(new a(interfaceC1573b, str2));
        this.f60124b = downloadData;
        d.j().k(downloadData);
    }

    public String f(String str) {
        String nameMd5FromUrl = TbMd5.getNameMd5FromUrl(str);
        if (nameMd5FromUrl == null) {
            return null;
        }
        HashMap<String, String> hashMap = this.f60123a;
        if (hashMap == null) {
            this.f60123a = new HashMap<>();
            d();
            if (this.f60123a.size() > 0) {
                return this.f60123a.get(nameMd5FromUrl);
            }
            return null;
        }
        return hashMap.get(nameMd5FromUrl);
    }
}

package d.a.n0.r3.i.f;

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
    public static volatile b f63811c;

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, String> f63812a;

    /* renamed from: b  reason: collision with root package name */
    public DownloadData f63813b;

    /* loaded from: classes5.dex */
    public class a implements c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ InterfaceC1629b f63814a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f63815b;

        public a(InterfaceC1629b interfaceC1629b, String str) {
            this.f63814a = interfaceC1629b;
            this.f63815b = str;
        }

        @Override // d.a.m0.v.c
        public void onFileDownloadFailed(DownloadData downloadData, int i2, String str) {
            File file = new File(downloadData.getPath());
            if (file.exists()) {
                file.delete();
            }
            if (b.this.f63813b != null && downloadData.getUrl().equals(b.this.f63813b.getUrl())) {
                b.this.f63813b = null;
            }
            InterfaceC1629b interfaceC1629b = this.f63814a;
            if (interfaceC1629b != null) {
                interfaceC1629b.a(str);
            }
        }

        @Override // d.a.m0.v.c
        public void onFileDownloadSucceed(DownloadData downloadData) {
            if (downloadData == null || StringUtils.isNull(downloadData.getPath())) {
                return;
            }
            if (b.this.f63813b != null && downloadData.getUrl().equals(b.this.f63813b.getUrl())) {
                b.this.f63813b = null;
            }
            if (this.f63814a != null) {
                b.this.f63812a.put(downloadData.getPath().substring(d.a.n0.r3.c.f63688e.length(), downloadData.getPath().lastIndexOf(".")), downloadData.getPath());
                this.f63814a.c(this.f63815b, downloadData.getPath());
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
                if (b.this.f63813b != null && downloadData.getUrl().equals(b.this.f63813b.getUrl())) {
                    b.this.f63813b = null;
                }
                InterfaceC1629b interfaceC1629b = this.f63814a;
                if (interfaceC1629b != null) {
                    interfaceC1629b.b();
                }
            }
        }

        @Override // d.a.m0.v.c
        public boolean onPreDownload(DownloadData downloadData) {
            return true;
        }
    }

    /* renamed from: d.a.n0.r3.i.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC1629b {
        void a(String str);

        void b();

        void c(String str, String str2);
    }

    public static b g() {
        if (f63811c == null) {
            synchronized (b.class) {
                if (f63811c == null) {
                    f63811c = new b();
                }
            }
        }
        return f63811c;
    }

    public void d() {
        File[] listFiles;
        HashMap<String, String> hashMap = this.f63812a;
        if (hashMap == null) {
            this.f63812a = new HashMap<>();
        } else {
            hashMap.clear();
        }
        File file = new File(d.a.n0.r3.c.f63688e);
        if (file.exists()) {
            for (File file2 : file.listFiles()) {
                if (file2.isFile()) {
                    this.f63812a.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                }
            }
        }
    }

    public void e(String str, String str2, InterfaceC1629b interfaceC1629b) {
        String nameMd5FromUrl;
        if (TextUtils.isEmpty(str2) || (nameMd5FromUrl = TbMd5.getNameMd5FromUrl(str2)) == null) {
            return;
        }
        if (this.f63813b != null) {
            d.j().g(this.f63813b.getUrl(), true);
        }
        File file = new File(d.a.n0.r3.c.f63688e);
        if (!file.exists()) {
            file.mkdirs();
        }
        DownloadData downloadData = new DownloadData();
        downloadData.setType(18);
        downloadData.setId(str);
        downloadData.setUrl(str2);
        downloadData.setPath(d.a.n0.r3.c.f63688e + nameMd5FromUrl + ("." + str2.substring(str2.lastIndexOf(".") + 1)));
        downloadData.setCallback(new a(interfaceC1629b, str2));
        this.f63813b = downloadData;
        d.j().k(downloadData);
    }

    public String f(String str) {
        String nameMd5FromUrl = TbMd5.getNameMd5FromUrl(str);
        if (nameMd5FromUrl == null) {
            return null;
        }
        HashMap<String, String> hashMap = this.f63812a;
        if (hashMap == null) {
            this.f63812a = new HashMap<>();
            d();
            if (this.f63812a.size() > 0) {
                return this.f63812a.get(nameMd5FromUrl);
            }
            return null;
        }
        return hashMap.get(nameMd5FromUrl);
    }
}

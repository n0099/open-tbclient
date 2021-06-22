package d.a.o0.r3.i.f;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.TbMd5;
import com.baidu.tbadk.download.DownloadData;
import d.a.n0.v.c;
import d.a.n0.v.d;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: c  reason: collision with root package name */
    public static volatile a f63930c;

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, String> f63931a;

    /* renamed from: b  reason: collision with root package name */
    public DownloadData f63932b;

    /* renamed from: d.a.o0.r3.i.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1632a implements c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f63933a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f63934b;

        public C1632a(b bVar, String str) {
            this.f63933a = bVar;
            this.f63934b = str;
        }

        @Override // d.a.n0.v.c
        public void onFileDownloadFailed(DownloadData downloadData, int i2, String str) {
            File file = new File(downloadData.getPath());
            if (file.exists()) {
                file.delete();
            }
            if (a.this.f63932b != null && downloadData.getUrl().equals(a.this.f63932b.getUrl())) {
                a.this.f63932b = null;
            }
            b bVar = this.f63933a;
            if (bVar != null) {
                bVar.a(str);
            }
        }

        @Override // d.a.n0.v.c
        public void onFileDownloadSucceed(DownloadData downloadData) {
            if (downloadData == null || StringUtils.isNull(downloadData.getPath())) {
                return;
            }
            if (a.this.f63932b != null && downloadData.getUrl().equals(a.this.f63932b.getUrl())) {
                a.this.f63932b = null;
            }
            if (this.f63933a != null) {
                a.this.f63931a.put(downloadData.getPath().substring(d.a.o0.r3.c.f63809a.length(), downloadData.getPath().lastIndexOf(".")), downloadData.getPath());
                this.f63933a.c(this.f63934b, downloadData.getPath());
            }
        }

        @Override // d.a.n0.v.c
        public boolean onFileDownloaded(DownloadData downloadData) {
            return true;
        }

        @Override // d.a.n0.v.c
        public void onFileUpdateProgress(DownloadData downloadData) {
            if (downloadData.getStatus() == 4) {
                File file = new File(downloadData.getPath());
                if (file.exists()) {
                    file.delete();
                }
                if (a.this.f63932b != null && downloadData.getUrl().equals(a.this.f63932b.getUrl())) {
                    a.this.f63932b = null;
                }
                b bVar = this.f63933a;
                if (bVar != null) {
                    bVar.b();
                }
            }
        }

        @Override // d.a.n0.v.c
        public boolean onPreDownload(DownloadData downloadData) {
            return true;
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a(String str);

        void b();

        void c(String str, String str2);
    }

    public static a h() {
        if (f63930c == null) {
            synchronized (a.class) {
                if (f63930c == null) {
                    f63930c = new a();
                }
            }
        }
        return f63930c;
    }

    public void d() {
        if (this.f63932b != null) {
            d.j().g(this.f63932b.getUrl(), true);
        }
    }

    public void e() {
        File[] listFiles;
        HashMap<String, String> hashMap = this.f63931a;
        if (hashMap == null) {
            this.f63931a = new HashMap<>();
        } else {
            hashMap.clear();
        }
        File file = new File(d.a.o0.r3.c.f63809a);
        if (file.exists()) {
            for (File file2 : file.listFiles()) {
                if (file2.isFile()) {
                    this.f63931a.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                }
            }
        }
    }

    public void f(String str, String str2, b bVar) {
        String nameMd5FromUrl;
        if (TextUtils.isEmpty(str2) || (nameMd5FromUrl = TbMd5.getNameMd5FromUrl(str2)) == null) {
            return;
        }
        DownloadData downloadData = this.f63932b;
        if (downloadData != null) {
            if (str2.equals(downloadData.getUrl())) {
                return;
            }
            d.j().g(this.f63932b.getUrl(), true);
        }
        File file = new File(d.a.o0.r3.c.f63809a);
        if (!file.exists()) {
            file.mkdirs();
        }
        DownloadData downloadData2 = new DownloadData();
        downloadData2.setType(17);
        downloadData2.setId(str);
        downloadData2.setUrl(str2);
        downloadData2.setPath(d.a.o0.r3.c.f63809a + nameMd5FromUrl + ("." + str2.substring(str2.lastIndexOf(".") + 1)));
        downloadData2.setCallback(new C1632a(bVar, str2));
        this.f63932b = downloadData2;
        d.j().k(downloadData2);
    }

    public String g(String str) {
        String nameMd5FromUrl = TbMd5.getNameMd5FromUrl(str);
        if (nameMd5FromUrl == null) {
            return null;
        }
        HashMap<String, String> hashMap = this.f63931a;
        if (hashMap == null) {
            this.f63931a = new HashMap<>();
            e();
            if (this.f63931a.size() > 0) {
                return this.f63931a.get(nameMd5FromUrl);
            }
            return null;
        }
        return hashMap.get(nameMd5FromUrl);
    }
}

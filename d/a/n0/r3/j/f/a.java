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
public class a {

    /* renamed from: c  reason: collision with root package name */
    public static volatile a f60116c;

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, String> f60117a;

    /* renamed from: b  reason: collision with root package name */
    public DownloadData f60118b;

    /* renamed from: d.a.n0.r3.j.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1572a implements c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f60119a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f60120b;

        public C1572a(b bVar, String str) {
            this.f60119a = bVar;
            this.f60120b = str;
        }

        @Override // d.a.m0.v.c
        public void onFileDownloadFailed(DownloadData downloadData, int i2, String str) {
            File file = new File(downloadData.getPath());
            if (file.exists()) {
                file.delete();
            }
            if (a.this.f60118b != null && downloadData.getUrl().equals(a.this.f60118b.getUrl())) {
                a.this.f60118b = null;
            }
            b bVar = this.f60119a;
            if (bVar != null) {
                bVar.a(str);
            }
        }

        @Override // d.a.m0.v.c
        public void onFileDownloadSucceed(DownloadData downloadData) {
            if (downloadData == null || StringUtils.isNull(downloadData.getPath())) {
                return;
            }
            if (a.this.f60118b != null && downloadData.getUrl().equals(a.this.f60118b.getUrl())) {
                a.this.f60118b = null;
            }
            if (this.f60119a != null) {
                a.this.f60117a.put(downloadData.getPath().substring(d.a.n0.r3.c.f59993a.length(), downloadData.getPath().lastIndexOf(".")), downloadData.getPath());
                this.f60119a.c(this.f60120b, downloadData.getPath());
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
                if (a.this.f60118b != null && downloadData.getUrl().equals(a.this.f60118b.getUrl())) {
                    a.this.f60118b = null;
                }
                b bVar = this.f60119a;
                if (bVar != null) {
                    bVar.b();
                }
            }
        }

        @Override // d.a.m0.v.c
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
        if (f60116c == null) {
            synchronized (a.class) {
                if (f60116c == null) {
                    f60116c = new a();
                }
            }
        }
        return f60116c;
    }

    public void d() {
        if (this.f60118b != null) {
            d.j().g(this.f60118b.getUrl(), true);
        }
    }

    public void e() {
        File[] listFiles;
        HashMap<String, String> hashMap = this.f60117a;
        if (hashMap == null) {
            this.f60117a = new HashMap<>();
        } else {
            hashMap.clear();
        }
        File file = new File(d.a.n0.r3.c.f59993a);
        if (file.exists()) {
            for (File file2 : file.listFiles()) {
                if (file2.isFile()) {
                    this.f60117a.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                }
            }
        }
    }

    public void f(String str, String str2, b bVar) {
        String nameMd5FromUrl;
        if (TextUtils.isEmpty(str2) || (nameMd5FromUrl = TbMd5.getNameMd5FromUrl(str2)) == null) {
            return;
        }
        DownloadData downloadData = this.f60118b;
        if (downloadData != null) {
            if (str2.equals(downloadData.getUrl())) {
                return;
            }
            d.j().g(this.f60118b.getUrl(), true);
        }
        File file = new File(d.a.n0.r3.c.f59993a);
        if (!file.exists()) {
            file.mkdirs();
        }
        DownloadData downloadData2 = new DownloadData();
        downloadData2.setType(17);
        downloadData2.setId(str);
        downloadData2.setUrl(str2);
        downloadData2.setPath(d.a.n0.r3.c.f59993a + nameMd5FromUrl + ("." + str2.substring(str2.lastIndexOf(".") + 1)));
        downloadData2.setCallback(new C1572a(bVar, str2));
        this.f60118b = downloadData2;
        d.j().k(downloadData2);
    }

    public String g(String str) {
        String nameMd5FromUrl = TbMd5.getNameMd5FromUrl(str);
        if (nameMd5FromUrl == null) {
            return null;
        }
        HashMap<String, String> hashMap = this.f60117a;
        if (hashMap == null) {
            this.f60117a = new HashMap<>();
            e();
            if (this.f60117a.size() > 0) {
                return this.f60117a.get(nameMd5FromUrl);
            }
            return null;
        }
        return hashMap.get(nameMd5FromUrl);
    }
}

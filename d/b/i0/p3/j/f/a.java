package d.b.i0.p3.j.f;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.TbMd5;
import com.baidu.tbadk.download.DownloadData;
import d.b.h0.v.c;
import d.b.h0.v.d;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: c  reason: collision with root package name */
    public static volatile a f59005c;

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, String> f59006a;

    /* renamed from: b  reason: collision with root package name */
    public DownloadData f59007b;

    /* renamed from: d.b.i0.p3.j.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1459a implements c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f59008a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f59009b;

        public C1459a(b bVar, String str) {
            this.f59008a = bVar;
            this.f59009b = str;
        }

        @Override // d.b.h0.v.c
        public void onFileDownloadFailed(DownloadData downloadData, int i, String str) {
            File file = new File(downloadData.getPath());
            if (file.exists()) {
                file.delete();
            }
            if (a.this.f59007b != null && downloadData.getUrl().equals(a.this.f59007b.getUrl())) {
                a.this.f59007b = null;
            }
            b bVar = this.f59008a;
            if (bVar != null) {
                bVar.a(str);
            }
        }

        @Override // d.b.h0.v.c
        public void onFileDownloadSucceed(DownloadData downloadData) {
            if (downloadData == null || StringUtils.isNull(downloadData.getPath())) {
                return;
            }
            if (a.this.f59007b != null && downloadData.getUrl().equals(a.this.f59007b.getUrl())) {
                a.this.f59007b = null;
            }
            if (this.f59008a != null) {
                a.this.f59006a.put(downloadData.getPath().substring(d.b.i0.p3.c.f58887a.length(), downloadData.getPath().lastIndexOf(".")), downloadData.getPath());
                this.f59008a.c(this.f59009b, downloadData.getPath());
            }
        }

        @Override // d.b.h0.v.c
        public boolean onFileDownloaded(DownloadData downloadData) {
            return true;
        }

        @Override // d.b.h0.v.c
        public void onFileUpdateProgress(DownloadData downloadData) {
            if (downloadData.getStatus() == 4) {
                File file = new File(downloadData.getPath());
                if (file.exists()) {
                    file.delete();
                }
                if (a.this.f59007b != null && downloadData.getUrl().equals(a.this.f59007b.getUrl())) {
                    a.this.f59007b = null;
                }
                b bVar = this.f59008a;
                if (bVar != null) {
                    bVar.b();
                }
            }
        }

        @Override // d.b.h0.v.c
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
        if (f59005c == null) {
            synchronized (a.class) {
                if (f59005c == null) {
                    f59005c = new a();
                }
            }
        }
        return f59005c;
    }

    public void d() {
        if (this.f59007b != null) {
            d.j().g(this.f59007b.getUrl(), true);
        }
    }

    public void e() {
        File[] listFiles;
        HashMap<String, String> hashMap = this.f59006a;
        if (hashMap == null) {
            this.f59006a = new HashMap<>();
        } else {
            hashMap.clear();
        }
        File file = new File(d.b.i0.p3.c.f58887a);
        if (file.exists()) {
            for (File file2 : file.listFiles()) {
                if (file2.isFile()) {
                    this.f59006a.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                }
            }
        }
    }

    public void f(String str, String str2, b bVar) {
        String nameMd5FromUrl;
        if (TextUtils.isEmpty(str2) || (nameMd5FromUrl = TbMd5.getNameMd5FromUrl(str2)) == null) {
            return;
        }
        DownloadData downloadData = this.f59007b;
        if (downloadData != null) {
            if (str2.equals(downloadData.getUrl())) {
                return;
            }
            d.j().g(this.f59007b.getUrl(), true);
        }
        File file = new File(d.b.i0.p3.c.f58887a);
        if (!file.exists()) {
            file.mkdirs();
        }
        DownloadData downloadData2 = new DownloadData();
        downloadData2.setType(17);
        downloadData2.setId(str);
        downloadData2.setUrl(str2);
        downloadData2.setPath(d.b.i0.p3.c.f58887a + nameMd5FromUrl + ("." + str2.substring(str2.lastIndexOf(".") + 1)));
        downloadData2.setCallback(new C1459a(bVar, str2));
        this.f59007b = downloadData2;
        d.j().k(downloadData2);
    }

    public String g(String str) {
        String nameMd5FromUrl = TbMd5.getNameMd5FromUrl(str);
        if (nameMd5FromUrl == null) {
            return null;
        }
        HashMap<String, String> hashMap = this.f59006a;
        if (hashMap == null) {
            this.f59006a = new HashMap<>();
            e();
            if (this.f59006a.size() > 0) {
                return this.f59006a.get(nameMd5FromUrl);
            }
            return null;
        }
        return hashMap.get(nameMd5FromUrl);
    }
}

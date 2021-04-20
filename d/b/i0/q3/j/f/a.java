package d.b.i0.q3.j.f;

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
    public static volatile a f60674c;

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, String> f60675a;

    /* renamed from: b  reason: collision with root package name */
    public DownloadData f60676b;

    /* renamed from: d.b.i0.q3.j.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1523a implements c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f60677a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f60678b;

        public C1523a(b bVar, String str) {
            this.f60677a = bVar;
            this.f60678b = str;
        }

        @Override // d.b.h0.v.c
        public void onFileDownloadFailed(DownloadData downloadData, int i, String str) {
            File file = new File(downloadData.getPath());
            if (file.exists()) {
                file.delete();
            }
            if (a.this.f60676b != null && downloadData.getUrl().equals(a.this.f60676b.getUrl())) {
                a.this.f60676b = null;
            }
            b bVar = this.f60677a;
            if (bVar != null) {
                bVar.a(str);
            }
        }

        @Override // d.b.h0.v.c
        public void onFileDownloadSucceed(DownloadData downloadData) {
            if (downloadData == null || StringUtils.isNull(downloadData.getPath())) {
                return;
            }
            if (a.this.f60676b != null && downloadData.getUrl().equals(a.this.f60676b.getUrl())) {
                a.this.f60676b = null;
            }
            if (this.f60677a != null) {
                a.this.f60675a.put(downloadData.getPath().substring(d.b.i0.q3.c.f60556a.length(), downloadData.getPath().lastIndexOf(".")), downloadData.getPath());
                this.f60677a.c(this.f60678b, downloadData.getPath());
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
                if (a.this.f60676b != null && downloadData.getUrl().equals(a.this.f60676b.getUrl())) {
                    a.this.f60676b = null;
                }
                b bVar = this.f60677a;
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
        if (f60674c == null) {
            synchronized (a.class) {
                if (f60674c == null) {
                    f60674c = new a();
                }
            }
        }
        return f60674c;
    }

    public void d() {
        if (this.f60676b != null) {
            d.j().g(this.f60676b.getUrl(), true);
        }
    }

    public void e() {
        File[] listFiles;
        HashMap<String, String> hashMap = this.f60675a;
        if (hashMap == null) {
            this.f60675a = new HashMap<>();
        } else {
            hashMap.clear();
        }
        File file = new File(d.b.i0.q3.c.f60556a);
        if (file.exists()) {
            for (File file2 : file.listFiles()) {
                if (file2.isFile()) {
                    this.f60675a.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                }
            }
        }
    }

    public void f(String str, String str2, b bVar) {
        String nameMd5FromUrl;
        if (TextUtils.isEmpty(str2) || (nameMd5FromUrl = TbMd5.getNameMd5FromUrl(str2)) == null) {
            return;
        }
        DownloadData downloadData = this.f60676b;
        if (downloadData != null) {
            if (str2.equals(downloadData.getUrl())) {
                return;
            }
            d.j().g(this.f60676b.getUrl(), true);
        }
        File file = new File(d.b.i0.q3.c.f60556a);
        if (!file.exists()) {
            file.mkdirs();
        }
        DownloadData downloadData2 = new DownloadData();
        downloadData2.setType(17);
        downloadData2.setId(str);
        downloadData2.setUrl(str2);
        downloadData2.setPath(d.b.i0.q3.c.f60556a + nameMd5FromUrl + ("." + str2.substring(str2.lastIndexOf(".") + 1)));
        downloadData2.setCallback(new C1523a(bVar, str2));
        this.f60676b = downloadData2;
        d.j().k(downloadData2);
    }

    public String g(String str) {
        String nameMd5FromUrl = TbMd5.getNameMd5FromUrl(str);
        if (nameMd5FromUrl == null) {
            return null;
        }
        HashMap<String, String> hashMap = this.f60675a;
        if (hashMap == null) {
            this.f60675a = new HashMap<>();
            e();
            if (this.f60675a.size() > 0) {
                return this.f60675a.get(nameMd5FromUrl);
            }
            return null;
        }
        return hashMap.get(nameMd5FromUrl);
    }
}

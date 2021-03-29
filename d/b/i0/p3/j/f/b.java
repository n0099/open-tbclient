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
public class b {

    /* renamed from: c  reason: collision with root package name */
    public static volatile b f59012c;

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, String> f59013a;

    /* renamed from: b  reason: collision with root package name */
    public DownloadData f59014b;

    /* loaded from: classes5.dex */
    public class a implements c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ InterfaceC1461b f59015a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f59016b;

        public a(InterfaceC1461b interfaceC1461b, String str) {
            this.f59015a = interfaceC1461b;
            this.f59016b = str;
        }

        @Override // d.b.h0.v.c
        public void onFileDownloadFailed(DownloadData downloadData, int i, String str) {
            File file = new File(downloadData.getPath());
            if (file.exists()) {
                file.delete();
            }
            if (b.this.f59014b != null && downloadData.getUrl().equals(b.this.f59014b.getUrl())) {
                b.this.f59014b = null;
            }
            InterfaceC1461b interfaceC1461b = this.f59015a;
            if (interfaceC1461b != null) {
                interfaceC1461b.a(str);
            }
        }

        @Override // d.b.h0.v.c
        public void onFileDownloadSucceed(DownloadData downloadData) {
            if (downloadData == null || StringUtils.isNull(downloadData.getPath())) {
                return;
            }
            if (b.this.f59014b != null && downloadData.getUrl().equals(b.this.f59014b.getUrl())) {
                b.this.f59014b = null;
            }
            if (this.f59015a != null) {
                b.this.f59013a.put(downloadData.getPath().substring(d.b.i0.p3.c.f58892e.length(), downloadData.getPath().lastIndexOf(".")), downloadData.getPath());
                this.f59015a.c(this.f59016b, downloadData.getPath());
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
                if (b.this.f59014b != null && downloadData.getUrl().equals(b.this.f59014b.getUrl())) {
                    b.this.f59014b = null;
                }
                InterfaceC1461b interfaceC1461b = this.f59015a;
                if (interfaceC1461b != null) {
                    interfaceC1461b.b();
                }
            }
        }

        @Override // d.b.h0.v.c
        public boolean onPreDownload(DownloadData downloadData) {
            return true;
        }
    }

    /* renamed from: d.b.i0.p3.j.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC1461b {
        void a(String str);

        void b();

        void c(String str, String str2);
    }

    public static b g() {
        if (f59012c == null) {
            synchronized (b.class) {
                if (f59012c == null) {
                    f59012c = new b();
                }
            }
        }
        return f59012c;
    }

    public void d() {
        File[] listFiles;
        HashMap<String, String> hashMap = this.f59013a;
        if (hashMap == null) {
            this.f59013a = new HashMap<>();
        } else {
            hashMap.clear();
        }
        File file = new File(d.b.i0.p3.c.f58892e);
        if (file.exists()) {
            for (File file2 : file.listFiles()) {
                if (file2.isFile()) {
                    this.f59013a.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                }
            }
        }
    }

    public void e(String str, String str2, InterfaceC1461b interfaceC1461b) {
        String nameMd5FromUrl;
        if (TextUtils.isEmpty(str2) || (nameMd5FromUrl = TbMd5.getNameMd5FromUrl(str2)) == null) {
            return;
        }
        if (this.f59014b != null) {
            d.j().g(this.f59014b.getUrl(), true);
        }
        File file = new File(d.b.i0.p3.c.f58892e);
        if (!file.exists()) {
            file.mkdirs();
        }
        DownloadData downloadData = new DownloadData();
        downloadData.setType(18);
        downloadData.setId(str);
        downloadData.setUrl(str2);
        downloadData.setPath(d.b.i0.p3.c.f58892e + nameMd5FromUrl + ("." + str2.substring(str2.lastIndexOf(".") + 1)));
        downloadData.setCallback(new a(interfaceC1461b, str2));
        this.f59014b = downloadData;
        d.j().k(downloadData);
    }

    public String f(String str) {
        String nameMd5FromUrl = TbMd5.getNameMd5FromUrl(str);
        if (nameMd5FromUrl == null) {
            return null;
        }
        HashMap<String, String> hashMap = this.f59013a;
        if (hashMap == null) {
            this.f59013a = new HashMap<>();
            d();
            if (this.f59013a.size() > 0) {
                return this.f59013a.get(nameMd5FromUrl);
            }
            return null;
        }
        return hashMap.get(nameMd5FromUrl);
    }
}

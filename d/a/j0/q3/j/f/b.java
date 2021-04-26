package d.a.j0.q3.j.f;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.TbMd5;
import com.baidu.tbadk.download.DownloadData;
import d.a.i0.v.c;
import d.a.i0.v.d;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: c  reason: collision with root package name */
    public static volatile b f59236c;

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, String> f59237a;

    /* renamed from: b  reason: collision with root package name */
    public DownloadData f59238b;

    /* loaded from: classes5.dex */
    public class a implements c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ InterfaceC1486b f59239a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f59240b;

        public a(InterfaceC1486b interfaceC1486b, String str) {
            this.f59239a = interfaceC1486b;
            this.f59240b = str;
        }

        @Override // d.a.i0.v.c
        public void onFileDownloadFailed(DownloadData downloadData, int i2, String str) {
            File file = new File(downloadData.getPath());
            if (file.exists()) {
                file.delete();
            }
            if (b.this.f59238b != null && downloadData.getUrl().equals(b.this.f59238b.getUrl())) {
                b.this.f59238b = null;
            }
            InterfaceC1486b interfaceC1486b = this.f59239a;
            if (interfaceC1486b != null) {
                interfaceC1486b.a(str);
            }
        }

        @Override // d.a.i0.v.c
        public void onFileDownloadSucceed(DownloadData downloadData) {
            if (downloadData == null || StringUtils.isNull(downloadData.getPath())) {
                return;
            }
            if (b.this.f59238b != null && downloadData.getUrl().equals(b.this.f59238b.getUrl())) {
                b.this.f59238b = null;
            }
            if (this.f59239a != null) {
                b.this.f59237a.put(downloadData.getPath().substring(d.a.j0.q3.c.f59111e.length(), downloadData.getPath().lastIndexOf(".")), downloadData.getPath());
                this.f59239a.c(this.f59240b, downloadData.getPath());
            }
        }

        @Override // d.a.i0.v.c
        public boolean onFileDownloaded(DownloadData downloadData) {
            return true;
        }

        @Override // d.a.i0.v.c
        public void onFileUpdateProgress(DownloadData downloadData) {
            if (downloadData.getStatus() == 4) {
                File file = new File(downloadData.getPath());
                if (file.exists()) {
                    file.delete();
                }
                if (b.this.f59238b != null && downloadData.getUrl().equals(b.this.f59238b.getUrl())) {
                    b.this.f59238b = null;
                }
                InterfaceC1486b interfaceC1486b = this.f59239a;
                if (interfaceC1486b != null) {
                    interfaceC1486b.b();
                }
            }
        }

        @Override // d.a.i0.v.c
        public boolean onPreDownload(DownloadData downloadData) {
            return true;
        }
    }

    /* renamed from: d.a.j0.q3.j.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC1486b {
        void a(String str);

        void b();

        void c(String str, String str2);
    }

    public static b g() {
        if (f59236c == null) {
            synchronized (b.class) {
                if (f59236c == null) {
                    f59236c = new b();
                }
            }
        }
        return f59236c;
    }

    public void d() {
        File[] listFiles;
        HashMap<String, String> hashMap = this.f59237a;
        if (hashMap == null) {
            this.f59237a = new HashMap<>();
        } else {
            hashMap.clear();
        }
        File file = new File(d.a.j0.q3.c.f59111e);
        if (file.exists()) {
            for (File file2 : file.listFiles()) {
                if (file2.isFile()) {
                    this.f59237a.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                }
            }
        }
    }

    public void e(String str, String str2, InterfaceC1486b interfaceC1486b) {
        String nameMd5FromUrl;
        if (TextUtils.isEmpty(str2) || (nameMd5FromUrl = TbMd5.getNameMd5FromUrl(str2)) == null) {
            return;
        }
        if (this.f59238b != null) {
            d.j().g(this.f59238b.getUrl(), true);
        }
        File file = new File(d.a.j0.q3.c.f59111e);
        if (!file.exists()) {
            file.mkdirs();
        }
        DownloadData downloadData = new DownloadData();
        downloadData.setType(18);
        downloadData.setId(str);
        downloadData.setUrl(str2);
        downloadData.setPath(d.a.j0.q3.c.f59111e + nameMd5FromUrl + ("." + str2.substring(str2.lastIndexOf(".") + 1)));
        downloadData.setCallback(new a(interfaceC1486b, str2));
        this.f59238b = downloadData;
        d.j().k(downloadData);
    }

    public String f(String str) {
        String nameMd5FromUrl = TbMd5.getNameMd5FromUrl(str);
        if (nameMd5FromUrl == null) {
            return null;
        }
        HashMap<String, String> hashMap = this.f59237a;
        if (hashMap == null) {
            this.f59237a = new HashMap<>();
            d();
            if (this.f59237a.size() > 0) {
                return this.f59237a.get(nameMd5FromUrl);
            }
            return null;
        }
        return hashMap.get(nameMd5FromUrl);
    }
}

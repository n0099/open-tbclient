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
public class b {

    /* renamed from: c  reason: collision with root package name */
    public static volatile b f63936c;

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, String> f63937a;

    /* renamed from: b  reason: collision with root package name */
    public DownloadData f63938b;

    /* loaded from: classes5.dex */
    public class a implements c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ InterfaceC1633b f63939a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f63940b;

        public a(InterfaceC1633b interfaceC1633b, String str) {
            this.f63939a = interfaceC1633b;
            this.f63940b = str;
        }

        @Override // d.a.n0.v.c
        public void onFileDownloadFailed(DownloadData downloadData, int i2, String str) {
            File file = new File(downloadData.getPath());
            if (file.exists()) {
                file.delete();
            }
            if (b.this.f63938b != null && downloadData.getUrl().equals(b.this.f63938b.getUrl())) {
                b.this.f63938b = null;
            }
            InterfaceC1633b interfaceC1633b = this.f63939a;
            if (interfaceC1633b != null) {
                interfaceC1633b.a(str);
            }
        }

        @Override // d.a.n0.v.c
        public void onFileDownloadSucceed(DownloadData downloadData) {
            if (downloadData == null || StringUtils.isNull(downloadData.getPath())) {
                return;
            }
            if (b.this.f63938b != null && downloadData.getUrl().equals(b.this.f63938b.getUrl())) {
                b.this.f63938b = null;
            }
            if (this.f63939a != null) {
                b.this.f63937a.put(downloadData.getPath().substring(d.a.o0.r3.c.f63813e.length(), downloadData.getPath().lastIndexOf(".")), downloadData.getPath());
                this.f63939a.c(this.f63940b, downloadData.getPath());
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
                if (b.this.f63938b != null && downloadData.getUrl().equals(b.this.f63938b.getUrl())) {
                    b.this.f63938b = null;
                }
                InterfaceC1633b interfaceC1633b = this.f63939a;
                if (interfaceC1633b != null) {
                    interfaceC1633b.b();
                }
            }
        }

        @Override // d.a.n0.v.c
        public boolean onPreDownload(DownloadData downloadData) {
            return true;
        }
    }

    /* renamed from: d.a.o0.r3.i.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC1633b {
        void a(String str);

        void b();

        void c(String str, String str2);
    }

    public static b g() {
        if (f63936c == null) {
            synchronized (b.class) {
                if (f63936c == null) {
                    f63936c = new b();
                }
            }
        }
        return f63936c;
    }

    public void d() {
        File[] listFiles;
        HashMap<String, String> hashMap = this.f63937a;
        if (hashMap == null) {
            this.f63937a = new HashMap<>();
        } else {
            hashMap.clear();
        }
        File file = new File(d.a.o0.r3.c.f63813e);
        if (file.exists()) {
            for (File file2 : file.listFiles()) {
                if (file2.isFile()) {
                    this.f63937a.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                }
            }
        }
    }

    public void e(String str, String str2, InterfaceC1633b interfaceC1633b) {
        String nameMd5FromUrl;
        if (TextUtils.isEmpty(str2) || (nameMd5FromUrl = TbMd5.getNameMd5FromUrl(str2)) == null) {
            return;
        }
        if (this.f63938b != null) {
            d.j().g(this.f63938b.getUrl(), true);
        }
        File file = new File(d.a.o0.r3.c.f63813e);
        if (!file.exists()) {
            file.mkdirs();
        }
        DownloadData downloadData = new DownloadData();
        downloadData.setType(18);
        downloadData.setId(str);
        downloadData.setUrl(str2);
        downloadData.setPath(d.a.o0.r3.c.f63813e + nameMd5FromUrl + ("." + str2.substring(str2.lastIndexOf(".") + 1)));
        downloadData.setCallback(new a(interfaceC1633b, str2));
        this.f63938b = downloadData;
        d.j().k(downloadData);
    }

    public String f(String str) {
        String nameMd5FromUrl = TbMd5.getNameMd5FromUrl(str);
        if (nameMd5FromUrl == null) {
            return null;
        }
        HashMap<String, String> hashMap = this.f63937a;
        if (hashMap == null) {
            this.f63937a = new HashMap<>();
            d();
            if (this.f63937a.size() > 0) {
                return this.f63937a.get(nameMd5FromUrl);
            }
            return null;
        }
        return hashMap.get(nameMd5FromUrl);
    }
}

package d.b.i0.q3.m;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.TbMd5;
import com.baidu.tbadk.download.DownloadData;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes5.dex */
public class l {

    /* renamed from: f  reason: collision with root package name */
    public static final String f60866f;

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, String> f60867a;

    /* renamed from: b  reason: collision with root package name */
    public List<DownloadData> f60868b;

    /* renamed from: c  reason: collision with root package name */
    public b f60869c;

    /* renamed from: d  reason: collision with root package name */
    public String f60870d;

    /* renamed from: e  reason: collision with root package name */
    public d.b.h0.v.c f60871e = new a();

    /* loaded from: classes5.dex */
    public class a implements d.b.h0.v.c {
        public a() {
        }

        @Override // d.b.h0.v.c
        public void onFileDownloadFailed(DownloadData downloadData, int i, String str) {
            File file = new File(downloadData.getPath());
            if (file.exists()) {
                file.delete();
            }
            l.this.i(downloadData);
            if (l.this.f60869c == null || !l.this.f60870d.equals(downloadData.getUrl())) {
                return;
            }
            l.this.f60869c.a(str);
        }

        @Override // d.b.h0.v.c
        public void onFileDownloadSucceed(DownloadData downloadData) {
            if (downloadData == null || StringUtils.isNull(downloadData.getPath()) || StringUtils.isNull(l.f60866f)) {
                return;
            }
            l.this.i(downloadData);
            if (l.this.f60869c == null || !l.this.f60870d.equals(downloadData.getUrl())) {
                return;
            }
            l.this.f60867a.put(downloadData.getPath().substring(l.f60866f.length() + 1, downloadData.getPath().lastIndexOf(".")), downloadData.getPath());
            l.this.f60869c.c(l.this.f60870d, downloadData.getPath());
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
                l.this.i(downloadData);
                if (l.this.f60869c == null || !l.this.f60870d.equals(downloadData.getUrl())) {
                    return;
                }
                l.this.f60869c.b();
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

    static {
        f60866f = TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers") != null ? TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers").getPath() : "";
    }

    public void e() {
        File[] listFiles;
        if (StringUtils.isNull(f60866f)) {
            return;
        }
        HashMap<String, String> hashMap = this.f60867a;
        if (hashMap == null) {
            this.f60867a = new HashMap<>();
        } else {
            hashMap.clear();
        }
        File file = new File(f60866f);
        if (file.exists()) {
            for (File file2 : file.listFiles()) {
                if (file2.isFile()) {
                    this.f60867a.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                }
            }
        }
    }

    public void f(String str) {
        if (!TextUtils.isEmpty(str) && !StringUtils.isNull(f60866f)) {
            String nameMd5FromUrl = TbMd5.getNameMd5FromUrl(str);
            if (nameMd5FromUrl == null) {
                return;
            }
            File file = new File(f60866f);
            if (!file.exists()) {
                file.mkdirs();
            }
            String str2 = "." + str.substring(str.lastIndexOf(".") + 1);
            if (this.f60868b == null) {
                this.f60868b = new ArrayList();
            }
            if (h(str)) {
                return;
            }
            DownloadData downloadData = new DownloadData();
            downloadData.setType(10);
            downloadData.setUrl(str);
            downloadData.setPath(f60866f + "/" + nameMd5FromUrl + str2);
            downloadData.setCallback(this.f60871e);
            this.f60868b.add(downloadData);
            d.b.h0.v.d.j().k(downloadData);
            return;
        }
        b bVar = this.f60869c;
        if (bVar != null) {
            bVar.a("");
        }
    }

    public String g(String str) {
        String nameMd5FromUrl = TbMd5.getNameMd5FromUrl(str);
        if (nameMd5FromUrl == null) {
            return null;
        }
        if (this.f60867a == null) {
            this.f60867a = new HashMap<>();
            e();
        }
        return this.f60867a.get(nameMd5FromUrl);
    }

    public final boolean h(String str) {
        if (!ListUtils.isEmpty(this.f60868b) && str != null) {
            for (DownloadData downloadData : this.f60868b) {
                if (downloadData != null && str.equals(downloadData.getUrl())) {
                    return true;
                }
            }
        }
        return false;
    }

    public final void i(DownloadData downloadData) {
        if (ListUtils.isEmpty(this.f60868b) || downloadData == null) {
            return;
        }
        int i = -1;
        int i2 = 0;
        while (true) {
            if (i2 < this.f60868b.size()) {
                if (this.f60868b.get(i2) != null && this.f60868b.get(i2).getUrl() != null && this.f60868b.get(i2).getUrl().equals(downloadData.getUrl())) {
                    i = i2;
                    break;
                }
                i2++;
            } else {
                break;
            }
        }
        this.f60868b.remove(i);
    }

    public void j(String str) {
        if (str == null) {
            this.f60870d = "";
        } else {
            this.f60870d = str;
        }
    }

    public void k(b bVar) {
        this.f60869c = bVar;
    }
}

package d.a.o0.r3.l;

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
    public static final String f64128f;

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, String> f64129a;

    /* renamed from: b  reason: collision with root package name */
    public List<DownloadData> f64130b;

    /* renamed from: c  reason: collision with root package name */
    public b f64131c;

    /* renamed from: d  reason: collision with root package name */
    public String f64132d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.n0.v.c f64133e = new a();

    /* loaded from: classes5.dex */
    public class a implements d.a.n0.v.c {
        public a() {
        }

        @Override // d.a.n0.v.c
        public void onFileDownloadFailed(DownloadData downloadData, int i2, String str) {
            File file = new File(downloadData.getPath());
            if (file.exists()) {
                file.delete();
            }
            l.this.i(downloadData);
            if (l.this.f64131c == null || !l.this.f64132d.equals(downloadData.getUrl())) {
                return;
            }
            l.this.f64131c.a(str);
        }

        @Override // d.a.n0.v.c
        public void onFileDownloadSucceed(DownloadData downloadData) {
            if (downloadData == null || StringUtils.isNull(downloadData.getPath()) || StringUtils.isNull(l.f64128f)) {
                return;
            }
            l.this.i(downloadData);
            if (l.this.f64131c == null || !l.this.f64132d.equals(downloadData.getUrl())) {
                return;
            }
            l.this.f64129a.put(downloadData.getPath().substring(l.f64128f.length() + 1, downloadData.getPath().lastIndexOf(".")), downloadData.getPath());
            l.this.f64131c.c(l.this.f64132d, downloadData.getPath());
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
                l.this.i(downloadData);
                if (l.this.f64131c == null || !l.this.f64132d.equals(downloadData.getUrl())) {
                    return;
                }
                l.this.f64131c.b();
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

    static {
        f64128f = TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers") != null ? TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers").getPath() : "";
    }

    public void e() {
        File[] listFiles;
        if (StringUtils.isNull(f64128f)) {
            return;
        }
        HashMap<String, String> hashMap = this.f64129a;
        if (hashMap == null) {
            this.f64129a = new HashMap<>();
        } else {
            hashMap.clear();
        }
        File file = new File(f64128f);
        if (file.exists()) {
            for (File file2 : file.listFiles()) {
                if (file2.isFile()) {
                    this.f64129a.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                }
            }
        }
    }

    public void f(String str) {
        if (!TextUtils.isEmpty(str) && !StringUtils.isNull(f64128f)) {
            String nameMd5FromUrl = TbMd5.getNameMd5FromUrl(str);
            if (nameMd5FromUrl == null) {
                return;
            }
            File file = new File(f64128f);
            if (!file.exists()) {
                file.mkdirs();
            }
            String str2 = "." + str.substring(str.lastIndexOf(".") + 1);
            if (this.f64130b == null) {
                this.f64130b = new ArrayList();
            }
            if (h(str)) {
                return;
            }
            DownloadData downloadData = new DownloadData();
            downloadData.setType(10);
            downloadData.setUrl(str);
            downloadData.setPath(f64128f + "/" + nameMd5FromUrl + str2);
            downloadData.setCallback(this.f64133e);
            this.f64130b.add(downloadData);
            d.a.n0.v.d.j().k(downloadData);
            return;
        }
        b bVar = this.f64131c;
        if (bVar != null) {
            bVar.a("");
        }
    }

    public String g(String str) {
        String nameMd5FromUrl = TbMd5.getNameMd5FromUrl(str);
        if (nameMd5FromUrl == null) {
            return null;
        }
        if (this.f64129a == null) {
            this.f64129a = new HashMap<>();
            e();
        }
        return this.f64129a.get(nameMd5FromUrl);
    }

    public final boolean h(String str) {
        if (!ListUtils.isEmpty(this.f64130b) && str != null) {
            for (DownloadData downloadData : this.f64130b) {
                if (downloadData != null && str.equals(downloadData.getUrl())) {
                    return true;
                }
            }
        }
        return false;
    }

    public final void i(DownloadData downloadData) {
        if (ListUtils.isEmpty(this.f64130b) || downloadData == null) {
            return;
        }
        int i2 = -1;
        int i3 = 0;
        while (true) {
            if (i3 < this.f64130b.size()) {
                if (this.f64130b.get(i3) != null && this.f64130b.get(i3).getUrl() != null && this.f64130b.get(i3).getUrl().equals(downloadData.getUrl())) {
                    i2 = i3;
                    break;
                }
                i3++;
            } else {
                break;
            }
        }
        this.f64130b.remove(i2);
    }

    public void j(String str) {
        if (str == null) {
            this.f64132d = "";
        } else {
            this.f64132d = str;
        }
    }

    public void k(b bVar) {
        this.f64131c = bVar;
    }
}

package d.b.j0.q3.m;

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
    public static final String f61287f;

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, String> f61288a;

    /* renamed from: b  reason: collision with root package name */
    public List<DownloadData> f61289b;

    /* renamed from: c  reason: collision with root package name */
    public b f61290c;

    /* renamed from: d  reason: collision with root package name */
    public String f61291d;

    /* renamed from: e  reason: collision with root package name */
    public d.b.i0.v.c f61292e = new a();

    /* loaded from: classes5.dex */
    public class a implements d.b.i0.v.c {
        public a() {
        }

        @Override // d.b.i0.v.c
        public void onFileDownloadFailed(DownloadData downloadData, int i, String str) {
            File file = new File(downloadData.getPath());
            if (file.exists()) {
                file.delete();
            }
            l.this.i(downloadData);
            if (l.this.f61290c == null || !l.this.f61291d.equals(downloadData.getUrl())) {
                return;
            }
            l.this.f61290c.a(str);
        }

        @Override // d.b.i0.v.c
        public void onFileDownloadSucceed(DownloadData downloadData) {
            if (downloadData == null || StringUtils.isNull(downloadData.getPath()) || StringUtils.isNull(l.f61287f)) {
                return;
            }
            l.this.i(downloadData);
            if (l.this.f61290c == null || !l.this.f61291d.equals(downloadData.getUrl())) {
                return;
            }
            l.this.f61288a.put(downloadData.getPath().substring(l.f61287f.length() + 1, downloadData.getPath().lastIndexOf(".")), downloadData.getPath());
            l.this.f61290c.c(l.this.f61291d, downloadData.getPath());
        }

        @Override // d.b.i0.v.c
        public boolean onFileDownloaded(DownloadData downloadData) {
            return true;
        }

        @Override // d.b.i0.v.c
        public void onFileUpdateProgress(DownloadData downloadData) {
            if (downloadData.getStatus() == 4) {
                File file = new File(downloadData.getPath());
                if (file.exists()) {
                    file.delete();
                }
                l.this.i(downloadData);
                if (l.this.f61290c == null || !l.this.f61291d.equals(downloadData.getUrl())) {
                    return;
                }
                l.this.f61290c.b();
            }
        }

        @Override // d.b.i0.v.c
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
        f61287f = TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers") != null ? TbadkCoreApplication.getInst().getApp().getExternalFilesDir("stickers").getPath() : "";
    }

    public void e() {
        File[] listFiles;
        if (StringUtils.isNull(f61287f)) {
            return;
        }
        HashMap<String, String> hashMap = this.f61288a;
        if (hashMap == null) {
            this.f61288a = new HashMap<>();
        } else {
            hashMap.clear();
        }
        File file = new File(f61287f);
        if (file.exists()) {
            for (File file2 : file.listFiles()) {
                if (file2.isFile()) {
                    this.f61288a.put(file2.getName().substring(0, file2.getName().lastIndexOf(".")), file2.getAbsolutePath());
                }
            }
        }
    }

    public void f(String str) {
        if (!TextUtils.isEmpty(str) && !StringUtils.isNull(f61287f)) {
            String nameMd5FromUrl = TbMd5.getNameMd5FromUrl(str);
            if (nameMd5FromUrl == null) {
                return;
            }
            File file = new File(f61287f);
            if (!file.exists()) {
                file.mkdirs();
            }
            String str2 = "." + str.substring(str.lastIndexOf(".") + 1);
            if (this.f61289b == null) {
                this.f61289b = new ArrayList();
            }
            if (h(str)) {
                return;
            }
            DownloadData downloadData = new DownloadData();
            downloadData.setType(10);
            downloadData.setUrl(str);
            downloadData.setPath(f61287f + "/" + nameMd5FromUrl + str2);
            downloadData.setCallback(this.f61292e);
            this.f61289b.add(downloadData);
            d.b.i0.v.d.j().k(downloadData);
            return;
        }
        b bVar = this.f61290c;
        if (bVar != null) {
            bVar.a("");
        }
    }

    public String g(String str) {
        String nameMd5FromUrl = TbMd5.getNameMd5FromUrl(str);
        if (nameMd5FromUrl == null) {
            return null;
        }
        if (this.f61288a == null) {
            this.f61288a = new HashMap<>();
            e();
        }
        return this.f61288a.get(nameMd5FromUrl);
    }

    public final boolean h(String str) {
        if (!ListUtils.isEmpty(this.f61289b) && str != null) {
            for (DownloadData downloadData : this.f61289b) {
                if (downloadData != null && str.equals(downloadData.getUrl())) {
                    return true;
                }
            }
        }
        return false;
    }

    public final void i(DownloadData downloadData) {
        if (ListUtils.isEmpty(this.f61289b) || downloadData == null) {
            return;
        }
        int i = -1;
        int i2 = 0;
        while (true) {
            if (i2 < this.f61289b.size()) {
                if (this.f61289b.get(i2) != null && this.f61289b.get(i2).getUrl() != null && this.f61289b.get(i2).getUrl().equals(downloadData.getUrl())) {
                    i = i2;
                    break;
                }
                i2++;
            } else {
                break;
            }
        }
        this.f61289b.remove(i);
    }

    public void j(String str) {
        if (str == null) {
            this.f61291d = "";
        } else {
            this.f61291d = str;
        }
    }

    public void k(b bVar) {
        this.f61290c = bVar;
    }
}

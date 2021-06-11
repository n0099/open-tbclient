package d.a.n0.z1;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.download.DownloadData;
import d.a.c.e.p.m;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
/* loaded from: classes4.dex */
public class b {

    /* loaded from: classes4.dex */
    public static class a implements d.a.m0.v.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.z1.e.b f67320a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f67321b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.z1.f.a f67322c;

        /* renamed from: d.a.n0.z1.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C1814a extends BdAsyncTask<Void, Void, Boolean> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ DownloadData f67323a;

            public C1814a(DownloadData downloadData) {
                this.f67323a = downloadData;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Boolean doInBackground(Void... voidArr) {
                FileHelper.deleteFileOrDir(new File(a.this.f67321b));
                if (b.g(this.f67323a.getPath(), a.this.f67322c)) {
                    a aVar = a.this;
                    return Boolean.valueOf(b.f(aVar.f67322c, aVar.f67321b));
                }
                return Boolean.FALSE;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public void onPostExecute(Boolean bool) {
                if (bool.booleanValue()) {
                    a aVar = a.this;
                    aVar.f67320a.onSuccess(aVar.f67321b);
                    return;
                }
                a.this.f67320a.onFail("fail to download");
            }
        }

        public a(d.a.n0.z1.e.b bVar, String str, d.a.n0.z1.f.a aVar) {
            this.f67320a = bVar;
            this.f67321b = str;
            this.f67322c = aVar;
        }

        @Override // d.a.m0.v.c
        public void onFileDownloadFailed(DownloadData downloadData, int i2, String str) {
            if (this.f67320a != null) {
                String str2 = "faile to download:";
                if (downloadData != null && !TextUtils.isEmpty(downloadData.getUrl())) {
                    str2 = "faile to download:" + downloadData.getUrl();
                }
                this.f67320a.onFail(str2);
            }
        }

        @Override // d.a.m0.v.c
        public void onFileDownloadSucceed(DownloadData downloadData) {
            new C1814a(downloadData).execute(new Void[0]);
        }

        @Override // d.a.m0.v.c
        public boolean onFileDownloaded(DownloadData downloadData) {
            return true;
        }

        @Override // d.a.m0.v.c
        public void onFileUpdateProgress(DownloadData downloadData) {
            d.a.n0.z1.e.b bVar = this.f67320a;
            if (bVar != null) {
                bVar.onProgress(downloadData.getProcess());
            }
        }

        @Override // d.a.m0.v.c
        public boolean onPreDownload(DownloadData downloadData) {
            return true;
        }
    }

    public static void c(d.a.n0.z1.f.a aVar, d.a.n0.z1.e.b bVar) {
        List<d.a.n0.z1.f.b> list;
        if (aVar == null || (list = aVar.f67359e) == null || list.size() == 0 || TextUtils.isEmpty(aVar.f67358d)) {
            if (bVar != null) {
                bVar.onFail("group data null");
                return;
            }
            return;
        }
        a aVar2 = new a(bVar, c.f67326c + aVar.f67355a + "/", aVar);
        new File(c.f67326c).mkdirs();
        d(aVar, c.f67326c, aVar2);
    }

    public static void d(d.a.n0.z1.f.a aVar, String str, d.a.m0.v.c cVar) {
        if (aVar == null || TextUtils.isEmpty(aVar.f67358d)) {
            if (cVar != null) {
                cVar.onFileDownloadFailed(null, 0, "data is null");
                return;
            }
            return;
        }
        String str2 = aVar.f67355a + ".zip";
        DownloadData downloadData = new DownloadData(aVar.f67355a, str2, Uri.encode(aVar.f67358d, "-![.:/,%?&=]"), cVar);
        downloadData.setPath(str + str2);
        d.a.m0.v.d.j().k(downloadData);
    }

    public static String e(String str, String str2, Bitmap bitmap, int i2) {
        if (bitmap != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            File file = new File(str + str2);
            try {
                if ((!file.exists() || file.delete()) && file.createNewFile()) {
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    bitmap.compress(Bitmap.CompressFormat.PNG, i2, fileOutputStream);
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    return file.getPath();
                }
                return null;
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static boolean f(d.a.n0.z1.f.a aVar, String str) {
        File file = new File(str + "panel.png");
        File file2 = new File(str + "panel_momo.png");
        if (file.exists() && file2.exists()) {
            return true;
        }
        if (new File(str + aVar.f67357c).exists()) {
            Bitmap bitmap = null;
            try {
                bitmap = BitmapFactory.decodeFile(str + aVar.f67357c);
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
            }
            if (bitmap == null) {
                return false;
            }
            if (file.exists() || !TextUtils.isEmpty(e(str, "panel.png", bitmap, 60))) {
                return file2.exists() || !TextUtils.isEmpty(e(str, "panel_momo.png", bitmap, 60));
            }
            return false;
        }
        return false;
    }

    public static boolean g(String str, d.a.n0.z1.f.a aVar) {
        ZipInputStream zipInputStream = null;
        try {
            try {
                ZipInputStream zipInputStream2 = new ZipInputStream(new BufferedInputStream(new FileInputStream(str)));
                while (true) {
                    try {
                        ZipEntry nextEntry = zipInputStream2.getNextEntry();
                        if (nextEntry != null) {
                            if (!nextEntry.isDirectory()) {
                                String str2 = ".emotions/" + aVar.f67355a;
                                FileHelper.saveFile(TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/" + str2 + "/" + nextEntry.getName(), zipInputStream2);
                            }
                        } else {
                            zipInputStream2.close();
                            FileHelper.deleteFile(new File(str));
                            m.e(zipInputStream2);
                            return true;
                        }
                    } catch (FileNotFoundException e2) {
                        e = e2;
                        zipInputStream = zipInputStream2;
                        e.printStackTrace();
                        m.e(zipInputStream);
                        return false;
                    } catch (IOException e3) {
                        e = e3;
                        zipInputStream = zipInputStream2;
                        e.printStackTrace();
                        m.e(zipInputStream);
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        zipInputStream = zipInputStream2;
                        m.e(zipInputStream);
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (FileNotFoundException e4) {
            e = e4;
        } catch (IOException e5) {
            e = e5;
        }
    }
}

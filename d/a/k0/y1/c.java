package d.a.k0.y1;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.MediaScannerClient;
import com.baidu.tbadk.core.util.TbMd5;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tieba.faceshop.MyEmotionGroupData;
import com.baidu.tieba.newfaceshop.NewFaceGroupDownloadModel;
import d.a.k0.l0.g;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    public static volatile c f63443b;

    /* renamed from: c  reason: collision with root package name */
    public static final String f63444c = TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/.emotions/";

    /* renamed from: a  reason: collision with root package name */
    public Handler f63445a = new Handler(Looper.getMainLooper());

    /* loaded from: classes4.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.k0.y1.e.b f63446e;

        public a(c cVar, d.a.k0.y1.e.b bVar) {
            this.f63446e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f63446e.a("url null");
        }
    }

    /* loaded from: classes4.dex */
    public class b implements d.a.j0.v.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f63447a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.k0.y1.e.b f63448b;

        /* loaded from: classes4.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f63450e;

            public a(String str) {
                this.f63450e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.f63448b.onSuccess(this.f63450e);
            }
        }

        /* renamed from: d.a.k0.y1.c$b$b  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC1742b implements Runnable {
            public RunnableC1742b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.f63448b.a("rename failed");
            }
        }

        /* renamed from: d.a.k0.y1.c$b$c  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC1743c implements Runnable {
            public RunnableC1743c() {
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.f63448b.a("download failed");
            }
        }

        public b(String str, d.a.k0.y1.e.b bVar) {
            this.f63447a = str;
            this.f63448b = bVar;
        }

        @Override // d.a.j0.v.c
        public void onFileDownloadFailed(DownloadData downloadData, int i2, String str) {
            if (this.f63448b != null) {
                c.this.f63445a.post(new RunnableC1743c());
            }
        }

        @Override // d.a.j0.v.c
        public void onFileDownloadSucceed(DownloadData downloadData) {
            String str = downloadData.getPath() + (FileHelper.isGif(null, this.f63447a) ? ".gif" : ".jpg");
            if (FileHelper.renameTo(downloadData.getPath(), str)) {
                new MediaScannerClient(TbadkApplication.getInst().getContext()).saveImage(str);
                if (this.f63448b != null) {
                    c.this.f63445a.post(new a(str));
                }
            } else if (this.f63448b != null) {
                c.this.f63445a.post(new RunnableC1742b());
            }
        }

        @Override // d.a.j0.v.c
        public boolean onFileDownloaded(DownloadData downloadData) {
            return true;
        }

        @Override // d.a.j0.v.c
        public void onFileUpdateProgress(DownloadData downloadData) {
        }

        @Override // d.a.j0.v.c
        public boolean onPreDownload(DownloadData downloadData) {
            return true;
        }
    }

    /* renamed from: d.a.k0.y1.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1744c extends BdAsyncTask<Void, Void, List<String>> {
        public C1744c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public List<String> doInBackground(Void... voidArr) {
            return c.this.h();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(List<String> list) {
            if (list == null || list.isEmpty()) {
                return;
            }
            NewFaceGroupDownloadModel newFaceGroupDownloadModel = new NewFaceGroupDownloadModel();
            for (String str : list) {
                newFaceGroupDownloadModel.s(str, Boolean.FALSE, null);
            }
        }
    }

    public static c i() {
        if (f63443b == null) {
            synchronized (c.class) {
                if (f63443b == null) {
                    f63443b = new c();
                }
            }
        }
        return f63443b;
    }

    public boolean b(boolean z) {
        List<String> h2 = h();
        if (h2.size() > 0) {
            if (z) {
                c(h2, false);
            }
            return false;
        }
        return true;
    }

    public boolean c(List<String> list, boolean z) {
        if (list != null && !list.isEmpty()) {
            int i2 = 0;
            for (String str : list) {
                MyEmotionGroupData myEmotionGroupData = new MyEmotionGroupData();
                myEmotionGroupData.setGroupId(str);
                myEmotionGroupData.setUid(TbadkCoreApplication.getCurrentAccount());
                if (d.a.k0.l0.a.c().b(myEmotionGroupData)) {
                    FileHelper.deleteFileOrDir(new File(f63444c + str));
                    g.k().h(str);
                    i2++;
                }
            }
            if (i2 > 0) {
                MessageManager.getInstance().runTask(2004603, (Class) null);
                if (z) {
                    d.m().w();
                    return true;
                }
                return true;
            }
        }
        return false;
    }

    public void d(String str, d.a.k0.y1.e.b bVar) {
        if (TextUtils.isEmpty(str)) {
            if (bVar != null) {
                this.f63445a.post(new a(this, bVar));
                return;
            }
            return;
        }
        String nameMd5FromUrl = TbMd5.getNameMd5FromUrl(str);
        DownloadData downloadData = new DownloadData(nameMd5FromUrl, nameMd5FromUrl, str, new b(nameMd5FromUrl, bVar));
        downloadData.setPath((FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/") + nameMd5FromUrl);
        d.a.j0.v.d.j().k(downloadData);
    }

    public void e() {
        new C1744c().execute(new Void[0]);
    }

    public List<MyEmotionGroupData> f() {
        try {
            List<MyEmotionGroupData> h2 = d.a.k0.l0.a.c().h(TbadkCoreApplication.getCurrentAccount());
            Iterator<MyEmotionGroupData> it = h2.iterator();
            while (it.hasNext()) {
                MyEmotionGroupData next = it.next();
                if (next.getGroupId() != null && next.getGroupId().contains("collect_")) {
                    it.remove();
                }
            }
            return h2;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public MyEmotionGroupData g(String str) {
        return d.a.k0.l0.a.c().d(TbadkCoreApplication.getCurrentAccount(), str);
    }

    public List<String> h() {
        ArrayList arrayList = new ArrayList();
        for (MyEmotionGroupData myEmotionGroupData : f()) {
            File file = new File(f63444c + myEmotionGroupData.getGroupId());
            BdLog.e("getFileUnExistList Called:" + file.getName() + "   Exsists:" + file.exists());
            if (!file.exists()) {
                arrayList.add(myEmotionGroupData.getGroupId());
            }
        }
        return arrayList;
    }

    public boolean j(List<String> list, boolean z) {
        if (list != null && !list.isEmpty()) {
            try {
                g.k().o(list, TbadkCoreApplication.getCurrentAccount());
                MessageManager.getInstance().runTask(2004603, (Class) null);
                if (z) {
                    d.m().w();
                    return true;
                }
                return true;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return false;
    }
}

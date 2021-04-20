package d.b.i0.y1;

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
import d.b.i0.l0.g;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    public static volatile c f64023b;

    /* renamed from: c  reason: collision with root package name */
    public static final String f64024c = TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/.emotions/";

    /* renamed from: a  reason: collision with root package name */
    public Handler f64025a = new Handler(Looper.getMainLooper());

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.i0.y1.e.b f64026e;

        public a(c cVar, d.b.i0.y1.e.b bVar) {
            this.f64026e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f64026e.onFail("url null");
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.b.h0.v.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f64027a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.b.i0.y1.e.b f64028b;

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f64030e;

            public a(String str) {
                this.f64030e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.f64028b.onSuccess(this.f64030e);
            }
        }

        /* renamed from: d.b.i0.y1.c$b$b  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC1717b implements Runnable {
            public RunnableC1717b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.f64028b.onFail("rename failed");
            }
        }

        /* renamed from: d.b.i0.y1.c$b$c  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC1718c implements Runnable {
            public RunnableC1718c() {
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.f64028b.onFail("download failed");
            }
        }

        public b(String str, d.b.i0.y1.e.b bVar) {
            this.f64027a = str;
            this.f64028b = bVar;
        }

        @Override // d.b.h0.v.c
        public void onFileDownloadFailed(DownloadData downloadData, int i, String str) {
            if (this.f64028b != null) {
                c.this.f64025a.post(new RunnableC1718c());
            }
        }

        @Override // d.b.h0.v.c
        public void onFileDownloadSucceed(DownloadData downloadData) {
            String str = downloadData.getPath() + (FileHelper.isGif(null, this.f64027a) ? ".gif" : ".jpg");
            if (FileHelper.renameTo(downloadData.getPath(), str)) {
                new MediaScannerClient(TbadkApplication.getInst().getContext()).saveImage(str);
                if (this.f64028b != null) {
                    c.this.f64025a.post(new a(str));
                }
            } else if (this.f64028b != null) {
                c.this.f64025a.post(new RunnableC1717b());
            }
        }

        @Override // d.b.h0.v.c
        public boolean onFileDownloaded(DownloadData downloadData) {
            return true;
        }

        @Override // d.b.h0.v.c
        public void onFileUpdateProgress(DownloadData downloadData) {
        }

        @Override // d.b.h0.v.c
        public boolean onPreDownload(DownloadData downloadData) {
            return true;
        }
    }

    /* renamed from: d.b.i0.y1.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1719c extends BdAsyncTask<Void, Void, List<String>> {
        public C1719c() {
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
        if (f64023b == null) {
            synchronized (c.class) {
                if (f64023b == null) {
                    f64023b = new c();
                }
            }
        }
        return f64023b;
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
            int i = 0;
            for (String str : list) {
                MyEmotionGroupData myEmotionGroupData = new MyEmotionGroupData();
                myEmotionGroupData.setGroupId(str);
                myEmotionGroupData.setUid(TbadkCoreApplication.getCurrentAccount());
                if (d.b.i0.l0.a.c().b(myEmotionGroupData)) {
                    FileHelper.deleteFileOrDir(new File(f64024c + str));
                    g.k().h(str);
                    i++;
                }
            }
            if (i > 0) {
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

    public void d(String str, d.b.i0.y1.e.b bVar) {
        if (TextUtils.isEmpty(str)) {
            if (bVar != null) {
                this.f64025a.post(new a(this, bVar));
                return;
            }
            return;
        }
        String nameMd5FromUrl = TbMd5.getNameMd5FromUrl(str);
        DownloadData downloadData = new DownloadData(nameMd5FromUrl, nameMd5FromUrl, str, new b(nameMd5FromUrl, bVar));
        downloadData.setPath((FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/") + nameMd5FromUrl);
        d.b.h0.v.d.j().k(downloadData);
    }

    public void e() {
        new C1719c().execute(new Void[0]);
    }

    public List<MyEmotionGroupData> f() {
        try {
            List<MyEmotionGroupData> h2 = d.b.i0.l0.a.c().h(TbadkCoreApplication.getCurrentAccount());
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
        return d.b.i0.l0.a.c().d(TbadkCoreApplication.getCurrentAccount(), str);
    }

    public List<String> h() {
        ArrayList arrayList = new ArrayList();
        for (MyEmotionGroupData myEmotionGroupData : f()) {
            File file = new File(f64024c + myEmotionGroupData.getGroupId());
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

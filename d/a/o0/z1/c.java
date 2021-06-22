package d.a.o0.z1;

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
import d.a.o0.m0.g;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes5.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    public static volatile c f67450b;

    /* renamed from: c  reason: collision with root package name */
    public static final String f67451c = TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/.emotions/";

    /* renamed from: a  reason: collision with root package name */
    public Handler f67452a = new Handler(Looper.getMainLooper());

    /* loaded from: classes5.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.z1.e.b f67453e;

        public a(c cVar, d.a.o0.z1.e.b bVar) {
            this.f67453e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f67453e.onFail("url null");
        }
    }

    /* loaded from: classes5.dex */
    public class b implements d.a.n0.v.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f67454a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.z1.e.b f67455b;

        /* loaded from: classes5.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f67457e;

            public a(String str) {
                this.f67457e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.f67455b.onSuccess(this.f67457e);
            }
        }

        /* renamed from: d.a.o0.z1.c$b$b  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class RunnableC1819b implements Runnable {
            public RunnableC1819b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.f67455b.onFail("rename failed");
            }
        }

        /* renamed from: d.a.o0.z1.c$b$c  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class RunnableC1820c implements Runnable {
            public RunnableC1820c() {
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.f67455b.onFail("download failed");
            }
        }

        public b(String str, d.a.o0.z1.e.b bVar) {
            this.f67454a = str;
            this.f67455b = bVar;
        }

        @Override // d.a.n0.v.c
        public void onFileDownloadFailed(DownloadData downloadData, int i2, String str) {
            if (this.f67455b != null) {
                c.this.f67452a.post(new RunnableC1820c());
            }
        }

        @Override // d.a.n0.v.c
        public void onFileDownloadSucceed(DownloadData downloadData) {
            String str = downloadData.getPath() + (FileHelper.isGif(null, this.f67454a) ? ".gif" : ".jpg");
            if (FileHelper.renameTo(downloadData.getPath(), str)) {
                new MediaScannerClient(TbadkApplication.getInst().getContext()).saveImage(str);
                if (this.f67455b != null) {
                    c.this.f67452a.post(new a(str));
                }
            } else if (this.f67455b != null) {
                c.this.f67452a.post(new RunnableC1819b());
            }
        }

        @Override // d.a.n0.v.c
        public boolean onFileDownloaded(DownloadData downloadData) {
            return true;
        }

        @Override // d.a.n0.v.c
        public void onFileUpdateProgress(DownloadData downloadData) {
        }

        @Override // d.a.n0.v.c
        public boolean onPreDownload(DownloadData downloadData) {
            return true;
        }
    }

    /* renamed from: d.a.o0.z1.c$c  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1821c extends BdAsyncTask<Void, Void, List<String>> {
        public C1821c() {
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
                newFaceGroupDownloadModel.w(str, Boolean.FALSE, null);
            }
        }
    }

    public static c i() {
        if (f67450b == null) {
            synchronized (c.class) {
                if (f67450b == null) {
                    f67450b = new c();
                }
            }
        }
        return f67450b;
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
                if (d.a.o0.m0.a.c().b(myEmotionGroupData)) {
                    FileHelper.deleteFileOrDir(new File(f67451c + str));
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

    public void d(String str, d.a.o0.z1.e.b bVar) {
        if (TextUtils.isEmpty(str)) {
            if (bVar != null) {
                this.f67452a.post(new a(this, bVar));
                return;
            }
            return;
        }
        String nameMd5FromUrl = TbMd5.getNameMd5FromUrl(str);
        DownloadData downloadData = new DownloadData(nameMd5FromUrl, nameMd5FromUrl, str, new b(nameMd5FromUrl, bVar));
        downloadData.setPath((FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/") + nameMd5FromUrl);
        d.a.n0.v.d.j().k(downloadData);
    }

    public void e() {
        new C1821c().execute(new Void[0]);
    }

    public List<MyEmotionGroupData> f() {
        try {
            List<MyEmotionGroupData> h2 = d.a.o0.m0.a.c().h(TbadkCoreApplication.getCurrentAccount());
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
        return d.a.o0.m0.a.c().d(TbadkCoreApplication.getCurrentAccount(), str);
    }

    public List<String> h() {
        ArrayList arrayList = new ArrayList();
        for (MyEmotionGroupData myEmotionGroupData : f()) {
            File file = new File(f67451c + myEmotionGroupData.getGroupId());
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

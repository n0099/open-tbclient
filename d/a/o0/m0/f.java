package d.a.o0.m0;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.spswitch.emotion.resource.EmotionResourceProvider;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tieba.R;
import com.baidu.tieba.faceshop.MyEmotionGroupData;
import com.baidu.tieba.faceshop.QueryDownloadMessage;
import com.baidu.tieba.tbadkCore.message.CancelDownloadMessage;
import java.io.File;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class f {

    /* renamed from: f  reason: collision with root package name */
    public static f f61051f = new f();

    /* renamed from: a  reason: collision with root package name */
    public c f61052a;

    /* renamed from: b  reason: collision with root package name */
    public List<String> f61053b;

    /* renamed from: c  reason: collision with root package name */
    public int f61054c = 5;

    /* renamed from: d  reason: collision with root package name */
    public CustomMessageListener f61055d = new a(2001140);

    /* renamed from: e  reason: collision with root package name */
    public CustomMessageListener f61056e = new b(2001119);

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2001140 && (customResponsedMessage instanceof CancelDownloadMessage)) {
                f.this.d();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public b(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2001119 && (customResponsedMessage instanceof QueryDownloadMessage)) {
                f.this.f61053b = ((QueryDownloadMessage) customResponsedMessage).getData();
                f fVar = f.this;
                fVar.g(fVar.f61053b);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends BdAsyncTask<List<String>, List<DownloadData>, List<DownloadData>> {
        public c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public List<DownloadData> doInBackground(List<String>... listArr) {
            LinkedList linkedList = new LinkedList();
            if (listArr[0] == null) {
                return linkedList;
            }
            for (int i2 = 0; i2 < listArr[0].size(); i2++) {
                MyEmotionGroupData d2 = d.a.o0.m0.a.c().d(TbadkCoreApplication.getCurrentAccount(), listArr[0].get(i2));
                if (d2 != null && d.a.o0.m0.b.d(d2.getGroupId())) {
                    DownloadData downloadData = new DownloadData(d2.getGroupId());
                    downloadData.setStatus(3);
                    linkedList.add(downloadData);
                }
            }
            return linkedList;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(List<DownloadData> list) {
            super.onPostExecute(list);
            if (list == null) {
                list = new LinkedList<>();
            }
            for (DownloadData downloadData : d.a.n0.v.d.j().i()) {
                for (String str : f.this.f61053b) {
                    if (downloadData.getType() == 11 && downloadData.getId().equals(str)) {
                        list.add(downloadData);
                    }
                }
            }
            f.this.h(list);
        }
    }

    public f() {
        MessageManager.getInstance().registerListener(this.f61056e);
        MessageManager.getInstance().registerListener(this.f61055d);
    }

    public static f f() {
        return f61051f;
    }

    public void d() {
        d.a.n0.v.d.j().h(11);
    }

    public void e(String str) {
        d.a.n0.v.d.j().f(str, 11);
    }

    public final void g(List<String> list) {
        c cVar = new c();
        this.f61052a = cVar;
        cVar.execute(list);
    }

    public void h(List<DownloadData> list) {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new DownloadMessage(list));
    }

    public void i(DownloadData downloadData) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(downloadData);
        MessageManager.getInstance().dispatchResponsedMessageToUI(new DownloadMessage(linkedList));
    }

    public void j(String str, String str2, String str3) {
        if (d.a.c.e.p.k.isEmpty(str) || d.a.c.e.p.k.isEmpty(str3)) {
            return;
        }
        DownloadData downloadData = new DownloadData(str, str2, str3, new e());
        downloadData.setStatusMsg(TbadkCoreApplication.getCurrentAccount());
        downloadData.setType(11);
        String[] split = str3.split("/");
        if (split.length > 1) {
            String[] split2 = split[split.length - 1].split("_");
            if (split2 != null) {
                if (split2.length == 5) {
                    downloadData.setDescription(split2[1]);
                    downloadData.setCheck(split2[2]);
                    downloadData.setWidth(d.a.c.e.m.b.d(split2[3], 200));
                    downloadData.setHeight(d.a.c.e.m.b.d(split2[4].split(EmotionResourceProvider.EMOTION_RES_NAME_SUFFIX)[0], 200));
                } else if (split2.length == 3) {
                    downloadData.setDescription(split2[1]);
                    downloadData.setCheck(split2[2].split(EmotionResourceProvider.EMOTION_RES_NAME_SUFFIX)[0]);
                    downloadData.setWidth(200);
                    downloadData.setHeight(200);
                } else {
                    downloadData.setStatusMsg(TbadkApplication.getInst().getApp().getString(R.string.download_fail));
                    downloadData.setStatus(2);
                }
            } else {
                downloadData.setStatusMsg(TbadkApplication.getInst().getApp().getString(R.string.download_fail));
                downloadData.setStatus(2);
            }
        } else {
            downloadData.setStatusMsg(TbadkApplication.getInst().getApp().getString(R.string.download_fail));
            downloadData.setStatus(2);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath());
        sb.append(FileHelper.getPrefixByType(2));
        File file = new File(sb.toString());
        if (!file.exists()) {
            file.mkdirs();
        }
        sb.append("/");
        sb.append(str);
        downloadData.setPath(sb.toString());
        BdLog.d("download:path:" + downloadData.getPath());
        d.a.n0.v.d.j().l(downloadData, this.f61054c);
    }
}

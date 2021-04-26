package d.a.j0.l0;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.util.httpNet.WebClient;
import com.baidu.tbadk.img.GetEmotionInfosModel;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.faceshop.CollectEmotionData;
import com.baidu.tieba.faceshop.UserCollectModel;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes4.dex */
public class u {

    /* renamed from: b  reason: collision with root package name */
    public static u f56445b;

    /* renamed from: a  reason: collision with root package name */
    public GetEmotionInfosModel f56446a;

    /* loaded from: classes4.dex */
    public class a extends BdAsyncTask<Void, Void, Integer> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ l f56447a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ List f56448b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f56449c;

        public a(l lVar, List list, boolean z) {
            this.f56447a = lVar;
            this.f56448b = list;
            this.f56449c = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Integer doInBackground(Void... voidArr) {
            return Integer.valueOf(d.a.j0.l0.g.k().i(TbadkCoreApplication.getCurrentAccount()) - 1);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Integer num) {
            if (num.intValue() >= 300) {
                l lVar = this.f56447a;
                if (lVar != null) {
                    lVar.onResult(4, 0, 0);
                    return;
                } else {
                    d.a.c.e.p.l.L(TbadkCoreApplication.getInst(), R.string.save_emotion_limit);
                    return;
                }
            }
            while (this.f56448b.size() + num.intValue() > 300) {
                List list = this.f56448b;
                list.remove(list.size() - 1);
            }
            u.this.i(this.f56448b, this.f56449c, this.f56447a);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements GetEmotionInfosModel.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ l f56451a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Map f56452b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ List f56453c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ boolean f56454d;

        public b(l lVar, Map map, List list, boolean z) {
            this.f56451a = lVar;
            this.f56452b = map;
            this.f56453c = list;
            this.f56454d = z;
        }

        @Override // com.baidu.tbadk.img.GetEmotionInfosModel.b
        public void onFail(int i2, String str) {
            l lVar = this.f56451a;
            if (lVar == null) {
                d.a.c.e.p.l.L(TbadkCoreApplication.getInst(), R.string.save_emotion_failed);
            } else {
                lVar.onResult(4, 0, 0);
            }
        }

        @Override // com.baidu.tbadk.img.GetEmotionInfosModel.b
        public void onSuccess(List<d.a.i0.b0.c> list) {
            if (list == null || list.isEmpty()) {
                l lVar = this.f56451a;
                if (lVar == null) {
                    d.a.c.e.p.l.L(TbadkCoreApplication.getInst(), R.string.save_emotion_failed);
                } else {
                    lVar.onResult(4, 0, 0);
                }
            }
            for (d.a.i0.b0.c cVar : list) {
                if (!v.e().f(cVar.f48057a)) {
                    cVar.f48062f = (String) this.f56452b.get(cVar.f48063g);
                    this.f56453c.add(cVar);
                }
            }
            u.this.m(this.f56453c, this.f56451a, this.f56454d);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements j {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ List f56456a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.b0.c f56457b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ AtomicInteger f56458c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ l f56459d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f56460e;

        public c(List list, d.a.i0.b0.c cVar, AtomicInteger atomicInteger, l lVar, boolean z) {
            this.f56456a = list;
            this.f56457b = cVar;
            this.f56458c = atomicInteger;
            this.f56459d = lVar;
            this.f56460e = z;
        }

        @Override // d.a.j0.l0.u.j
        public void onFail() {
            if (this.f56458c.decrementAndGet() == 0) {
                u.this.f(this.f56456a, this.f56459d, this.f56460e);
            }
        }

        @Override // d.a.j0.l0.u.j
        public void onSuccess() {
            this.f56456a.add(u.this.w(this.f56457b));
            if (this.f56458c.decrementAndGet() == 0) {
                u.this.f(this.f56456a, this.f56459d, this.f56460e);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d extends BdAsyncTask<Void, Void, Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ List f56462a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ l f56463b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f56464c;

        public d(u uVar, List list, l lVar, boolean z) {
            this.f56462a = list;
            this.f56463b = lVar;
            this.f56464c = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(Void... voidArr) {
            return Boolean.valueOf(d.a.j0.l0.g.k().b(this.f56462a));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            if (bool != null && bool.booleanValue()) {
                l lVar = this.f56463b;
                if (lVar == null) {
                    d.a.c.e.p.l.L(TbadkCoreApplication.getInst(), R.string.add_success);
                } else {
                    lVar.onResult(4, 1, 0);
                }
                v.e().g();
                if (this.f56464c) {
                    new UserCollectModel().s();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921028));
                TiebaStatic.log("c12222");
                return;
            }
            l lVar2 = this.f56463b;
            if (lVar2 == null) {
                d.a.c.e.p.l.L(TbadkCoreApplication.getInst(), R.string.save_emotion_failed);
            } else {
                lVar2.onResult(4, 0, 0);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e extends BdAsyncTask<Void, Void, List<Integer>> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ List f56465a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ l f56466b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f56467c;

        public e(u uVar, List list, l lVar, boolean z) {
            this.f56465a = list;
            this.f56466b = lVar;
            this.f56467c = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public List<Integer> doInBackground(Void[] voidArr) {
            List<CollectEmotionData> n = d.a.j0.l0.g.k().n(TbadkCoreApplication.getCurrentAccountForEmotion());
            HashMap hashMap = new HashMap();
            for (CollectEmotionData collectEmotionData : n) {
                hashMap.put(collectEmotionData.getSharpText(), collectEmotionData);
            }
            int size = n.size() - 2;
            for (int i2 = 0; i2 < this.f56465a.size(); i2++) {
                CollectEmotionData collectEmotionData2 = (CollectEmotionData) this.f56465a.get(i2);
                collectEmotionData2.orderId = size;
                String sharpText = collectEmotionData2.getSharpText();
                if (hashMap.containsKey(sharpText)) {
                    n.remove(hashMap.get(sharpText));
                    hashMap.remove(sharpText);
                }
                d.a.j0.l0.g.k().r(collectEmotionData2);
                size--;
            }
            for (int i3 = 0; i3 < n.size(); i3++) {
                CollectEmotionData collectEmotionData3 = n.get(i3);
                if (!d.a.i0.a0.d.f47966d.equals(collectEmotionData3.sharpText)) {
                    collectEmotionData3.orderId = size;
                    d.a.j0.l0.g.k().r(collectEmotionData3);
                    size--;
                }
            }
            if (this.f56465a.size() > 0) {
                v.e().g();
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(Integer.valueOf(this.f56465a.size()));
            arrayList.add(0);
            return arrayList;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(List<Integer> list) {
            if (this.f56466b == null || list == null || list.size() != 2) {
                return;
            }
            this.f56466b.onResult(2, list.get(0).intValue(), list.get(1).intValue());
            if (list.get(0).intValue() > 0) {
                if (this.f56467c) {
                    new UserCollectModel().s();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921028));
                StatisticItem statisticItem = new StatisticItem("c12227");
                statisticItem.param("obj_param1", list.get(0).intValue());
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f extends BdAsyncTask<Void, Void, List<Integer>> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ List f56468a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ l f56469b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f56470c;

        public f(u uVar, List list, l lVar, boolean z) {
            this.f56468a = list;
            this.f56469b = lVar;
            this.f56470c = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public List<Integer> doInBackground(Void[] voidArr) {
            int i2 = 0;
            for (CollectEmotionData collectEmotionData : this.f56468a) {
                if (collectEmotionData != null && !"setting_icon".equals(collectEmotionData.pid) && !d.a.i0.a0.d.f47966d.equals(collectEmotionData.sharpText)) {
                    d.a.j0.l0.g.k().g(collectEmotionData);
                    ImageFileInfo imageFileInfo = collectEmotionData.imageFileInfo;
                    if (imageFileInfo != null && !TextUtils.isEmpty(imageFileInfo.getFilePath())) {
                        File file = new File(collectEmotionData.imageFileInfo.getFilePath());
                        if (file.exists()) {
                            file.delete();
                        }
                        String filePath = collectEmotionData.imageFileInfo.getFilePath();
                        File file2 = new File(filePath.replace("_s.jpg", "_b.jpg"));
                        if (file2.exists()) {
                            file2.delete();
                        }
                        File file3 = new File(filePath.replace("_s.jpg", "_b.gif"));
                        if (file3.exists()) {
                            file3.delete();
                        }
                    }
                    i2++;
                }
            }
            List<CollectEmotionData> n = d.a.j0.l0.g.k().n(TbadkCoreApplication.getCurrentAccount());
            for (int i3 = 0; i3 < n.size(); i3++) {
                CollectEmotionData collectEmotionData2 = n.get(i3);
                if (!d.a.i0.a0.d.f47966d.equals(collectEmotionData2.getSharpText())) {
                    collectEmotionData2.orderId = (n.size() - i3) - 1;
                    d.a.j0.l0.g.k().r(collectEmotionData2);
                }
            }
            if (i2 > 0) {
                v.e().g();
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(Integer.valueOf(i2));
            arrayList.add(Integer.valueOf(this.f56468a.size() - i2));
            return arrayList;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(List<Integer> list) {
            if (this.f56469b == null || list == null || list.size() != 2) {
                return;
            }
            this.f56469b.onResult(1, list.get(0).intValue(), list.get(1).intValue());
            if (list.get(0).intValue() > 0) {
                if (this.f56470c) {
                    new UserCollectModel().s();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921028));
                StatisticItem statisticItem = new StatisticItem("c12226");
                statisticItem.param("obj_param1", list.get(0).intValue());
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g extends BdAsyncTask<Void, Void, List<Integer>> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ List f56471a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ l f56472b;

        public g(List list, l lVar) {
            this.f56471a = list;
            this.f56472b = lVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public List<Integer> doInBackground(Void[] voidArr) {
            int i2 = 0;
            for (CollectEmotionData collectEmotionData : this.f56471a) {
                String filePath = collectEmotionData.imageFileInfo.getFilePath();
                File file = new File(filePath.replace("_s.jpg", "_b.jpg"));
                byte[] r = file.exists() ? u.this.r(file) : null;
                if (r == null) {
                    r = u.this.r(new File(filePath.replace("_s.jpg", "_b.gif")));
                }
                if (r != null && FileHelper.saveImageFileByUser(collectEmotionData.picUrl, r, TbadkCoreApplication.getInst().getContext()) == 0) {
                    i2++;
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(Integer.valueOf(i2));
            arrayList.add(Integer.valueOf(this.f56471a.size() - i2));
            return arrayList;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(List<Integer> list) {
            if (this.f56472b == null || list == null || list.size() != 2) {
                return;
            }
            this.f56472b.onResult(3, list.get(0).intValue(), list.get(1).intValue());
            if (list.get(0).intValue() > 0) {
                StatisticItem statisticItem = new StatisticItem("c12228");
                statisticItem.param("obj_param1", list.get(0).intValue());
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h extends BdAsyncTask<Void, Void, List<CollectEmotionData>> {
        public h() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public List<CollectEmotionData> doInBackground(Void... voidArr) {
            return u.this.p();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(List<CollectEmotionData> list) {
            if (list == null) {
                return;
            }
            for (CollectEmotionData collectEmotionData : list) {
                if (collectEmotionData != null) {
                    d.a.i0.b0.c cVar = new d.a.i0.b0.c();
                    cVar.f48057a = collectEmotionData.pid;
                    cVar.f48062f = collectEmotionData.pkgId;
                    cVar.f48060d = collectEmotionData.picUrl;
                    cVar.f48061e = collectEmotionData.thumbnail;
                    cVar.f48058b = collectEmotionData.width;
                    cVar.f48059c = collectEmotionData.height;
                    new k(null).execute(cVar);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i implements l {
        public i(u uVar) {
        }

        @Override // d.a.j0.l0.u.l
        public void onResult(int i2, int i3, int i4) {
        }
    }

    /* loaded from: classes4.dex */
    public interface j {
        void onFail();

        void onSuccess();
    }

    /* loaded from: classes4.dex */
    public class k extends BdAsyncTask<d.a.i0.b0.c, Void, Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public d.a.i0.b0.c f56475a;

        /* renamed from: b  reason: collision with root package name */
        public j f56476b;

        public k(j jVar) {
            this.f56476b = jVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Boolean doInBackground(d.a.i0.b0.c[] cVarArr) {
            if (cVarArr != null && cVarArr.length > 0) {
                this.f56475a = cVarArr[0];
                WebClient webClient = new WebClient();
                byte[] downloadImageBytes = webClient.downloadImageBytes(this.f56475a.f48060d, false);
                if (downloadImageBytes != null && webClient.IsRequestSuccess()) {
                    String q = u.this.q(this.f56475a, true);
                    if (TextUtils.isEmpty(q)) {
                        return Boolean.FALSE;
                    }
                    if (d.a.c.e.p.l.B(downloadImageBytes)) {
                        q = q.replace("_b.jpg", "_b.gif");
                    }
                    File file = new File(q);
                    if (!file.getParentFile().exists()) {
                        file.getParentFile().mkdirs();
                    }
                    if (!u.this.u(file, downloadImageBytes)) {
                        return Boolean.FALSE;
                    }
                    byte[] downloadImageBytes2 = webClient.downloadImageBytes(this.f56475a.f48061e, false);
                    if (downloadImageBytes2 != null && webClient.IsRequestSuccess()) {
                        String q2 = u.this.q(this.f56475a, false);
                        if (TextUtils.isEmpty(q2)) {
                            return Boolean.FALSE;
                        }
                        if (!u.this.u(new File(q2), downloadImageBytes2)) {
                            return Boolean.FALSE;
                        }
                        return Boolean.TRUE;
                    }
                    return Boolean.FALSE;
                }
                return Boolean.FALSE;
            }
            return Boolean.FALSE;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            if (bool != null && bool.booleanValue()) {
                j jVar = this.f56476b;
                if (jVar != null) {
                    jVar.onSuccess();
                    return;
                }
                return;
            }
            j jVar2 = this.f56476b;
            if (jVar2 != null) {
                jVar2.onFail();
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface l {
        void onResult(int i2, int i3, int i4);
    }

    public static String o(String str, boolean z) {
        String str2 = TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/.collect/" + d.a.i0.a0.d.b() + "/" + str + "_s.jpg";
        if (z) {
            String replace = str2.replace("_s.jpg", "_b.jpg");
            if (new File(replace).exists()) {
                return replace;
            }
            String replace2 = str2.replace("_s.jpg", "_b.gif");
            return new File(replace2).exists() ? replace2 : "";
        }
        return str2;
    }

    public static u s() {
        if (f56445b == null) {
            f56445b = new u();
        }
        return f56445b;
    }

    public final void f(List<CollectEmotionData> list, l lVar, boolean z) {
        new d(this, list, lVar, z).execute(new Void[0]);
    }

    public void g(String str, String str2) {
        if (d.a.j0.y1.d.m().n()) {
            d.a.c.e.p.l.L(BdBaseApplication.getInst().getApp(), R.string.face_collect_is_syncing);
            return;
        }
        d.a.i0.b0.c cVar = new d.a.i0.b0.c();
        cVar.f48060d = str;
        cVar.f48062f = str2;
        ArrayList arrayList = new ArrayList();
        arrayList.add(cVar);
        h(arrayList, true, null);
    }

    public void h(List<d.a.i0.b0.c> list, boolean z, l lVar) {
        new a(lVar, list, z).execute(new Void[0]);
    }

    public void i(List<d.a.i0.b0.c> list, boolean z, l lVar) {
        if (list == null || list.isEmpty()) {
            if (lVar == null) {
                d.a.c.e.p.l.L(TbadkCoreApplication.getInst(), R.string.save_emotion_failed);
            } else {
                lVar.onResult(4, 0, 0);
            }
        } else if (TbadkCoreApplication.isLogin()) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            HashMap hashMap = new HashMap();
            for (d.a.i0.b0.c cVar : list) {
                String str = cVar.f48057a;
                if (str != null && !TextUtils.isEmpty(str)) {
                    if (!v.e().f(cVar.f48057a)) {
                        arrayList.add(cVar);
                    }
                } else {
                    arrayList2.add(cVar.f48060d);
                    String str2 = cVar.f48062f;
                    if (str2 != null) {
                        hashMap.put(cVar.f48060d, str2);
                    }
                }
            }
            if (arrayList2.size() > 0) {
                if (this.f56446a == null) {
                    this.f56446a = new GetEmotionInfosModel();
                }
                this.f56446a.u(arrayList2, new b(lVar, hashMap, arrayList, z));
                return;
            }
            m(arrayList, lVar, z);
        } else if (lVar == null) {
            ViewHelper.skipToLoginActivity(TbadkCoreApplication.getInst());
        } else {
            lVar.onResult(4, 0, 0);
        }
    }

    public void j(List<String> list, l lVar) {
        if (ListUtils.isEmpty(list) && lVar != null) {
            lVar.onResult(4, 0, 0);
        }
        if (d.a.j0.y1.d.m().n()) {
            d.a.c.e.p.l.L(BdBaseApplication.getInst().getApp(), R.string.face_collect_is_syncing);
            lVar.onResult(4, 0, 0);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            d.a.i0.b0.c cVar = new d.a.i0.b0.c();
            cVar.f48060d = str;
            arrayList.add(cVar);
        }
        h(arrayList, true, lVar);
    }

    public boolean k(boolean z) {
        List<CollectEmotionData> p = p();
        if (p == null || p.isEmpty()) {
            return true;
        }
        if (z) {
            l(p, false, new i(this));
        }
        return false;
    }

    public void l(List<CollectEmotionData> list, boolean z, l lVar) {
        if (list != null && list.size() > 0) {
            new f(this, list, lVar, z).execute(new Void[0]);
        } else if (lVar != null) {
            lVar.onResult(1, 1, 0);
        }
    }

    public final void m(List<d.a.i0.b0.c> list, l lVar, boolean z) {
        if (list.size() == 0) {
            if (lVar == null) {
                d.a.c.e.p.l.L(TbadkCoreApplication.getInst(), R.string.add_success);
                return;
            } else {
                lVar.onResult(4, 1, 0);
                return;
            }
        }
        AtomicInteger atomicInteger = new AtomicInteger(list.size());
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        for (d.a.i0.b0.c cVar : list) {
            new k(new c(copyOnWriteArrayList, cVar, atomicInteger, lVar, z)).execute(cVar);
        }
    }

    public void n() {
        new h().execute(new Void[0]);
    }

    public List<CollectEmotionData> p() {
        ArrayList arrayList = new ArrayList();
        List<CollectEmotionData> n = d.a.j0.l0.g.k().n(TbadkCoreApplication.getCurrentAccountForEmotion());
        if (n != null) {
            for (CollectEmotionData collectEmotionData : n) {
                if (collectEmotionData != null && !"setting_icon".equals(collectEmotionData.pid) && !new File(o(collectEmotionData.pid, false)).exists()) {
                    arrayList.add(collectEmotionData);
                }
            }
        }
        return arrayList;
    }

    public final String q(d.a.i0.b0.c cVar, boolean z) {
        String str;
        if (cVar == null || TextUtils.isEmpty(cVar.f48060d) || TextUtils.isEmpty(cVar.f48057a)) {
            return "";
        }
        if (z) {
            str = "_b.jpg";
        } else {
            str = "_s.jpg";
        }
        return TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/.collect/" + d.a.i0.a0.d.b() + "/" + cVar.f48057a + str;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [boolean] */
    public byte[] r(File file) {
        FileInputStream fileInputStream;
        InputStream inputStream = null;
        if (file != null) {
            ?? exists = file.exists();
            try {
                if (exists != 0) {
                    try {
                        fileInputStream = new FileInputStream(file);
                        try {
                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
                            byte[] bArr = new byte[1024];
                            while (true) {
                                int read = fileInputStream.read(bArr, 0, 1024);
                                if (read != -1) {
                                    byteArrayOutputStream.write(bArr, 0, read);
                                } else {
                                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                                    d.a.c.e.p.m.e(fileInputStream);
                                    return byteArray;
                                }
                            }
                        } catch (IOException e2) {
                            e = e2;
                            BdLog.e(e.getMessage());
                            d.a.c.e.p.m.e(fileInputStream);
                            return null;
                        }
                    } catch (IOException e3) {
                        e = e3;
                        fileInputStream = null;
                    } catch (Throwable th) {
                        th = th;
                        d.a.c.e.p.m.e(inputStream);
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                inputStream = exists;
            }
        }
        return null;
    }

    public void t(List<CollectEmotionData> list, boolean z, l lVar) {
        if (list != null && list.size() > 0) {
            new e(this, list, lVar, z).execute(new Void[0]);
        } else if (lVar != null) {
            lVar.onResult(2, 0, 0);
        }
    }

    public final boolean u(File file, byte[] bArr) {
        FileOutputStream fileOutputStream = null;
        try {
            try {
                try {
                    if ((!file.exists() || file.delete()) && file.createNewFile()) {
                        FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                        try {
                            fileOutputStream2.write(bArr, 0, bArr.length);
                            fileOutputStream2.flush();
                            fileOutputStream2.close();
                            return true;
                        } catch (IOException e2) {
                            e = e2;
                            fileOutputStream = fileOutputStream2;
                            BdLog.e(e.getMessage());
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                            return false;
                        } catch (Throwable th) {
                            th = th;
                            fileOutputStream = fileOutputStream2;
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                            throw th;
                        }
                    }
                    return false;
                } catch (IOException e3) {
                    e = e3;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            BdLog.e(th3.getMessage());
        }
    }

    public void v(List<CollectEmotionData> list, l lVar) {
        if (list == null || list.size() <= 0) {
            return;
        }
        new g(list, lVar).execute(new Void[0]);
    }

    public final CollectEmotionData w(d.a.i0.b0.c cVar) {
        CollectEmotionData collectEmotionData = new CollectEmotionData();
        StringBuilder sb = new StringBuilder(d.a.i0.a0.d.f47968f);
        if (TextUtils.isEmpty(cVar.f48062f)) {
            sb.append(cVar.f48057a);
            sb.append(",");
        } else {
            sb.append(cVar.f48062f);
            sb.append("_");
            sb.append(cVar.f48057a);
            sb.append(",");
        }
        sb.append(cVar.f48058b);
        sb.append(",");
        sb.append(cVar.f48059c);
        sb.append(",");
        String lowerCase = d.a.c.e.p.q.c(sb.toString().replace("collect_", "") + "7S6wbXjEKL9N").toLowerCase();
        collectEmotionData.pid = cVar.f48057a;
        collectEmotionData.uid = TbadkCoreApplication.getCurrentAccount();
        collectEmotionData.sharpText = SmallTailInfo.EMOTION_PREFIX + sb.toString() + lowerCase + SmallTailInfo.EMOTION_SUFFIX;
        collectEmotionData.orderId = d.a.j0.l0.g.k().i(collectEmotionData.uid) + 1;
        collectEmotionData.width = cVar.f48058b;
        collectEmotionData.height = cVar.f48059c;
        collectEmotionData.picUrl = cVar.f48060d;
        collectEmotionData.thumbnail = cVar.f48061e;
        collectEmotionData.backup = "";
        return collectEmotionData;
    }
}

package d.b.h0.r.n;

import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.bigday.GetBigdayInfoHttpResMessage;
import com.baidu.tbadk.core.bigday.GetBigdayInfoReqMessage;
import com.baidu.tbadk.core.bigday.GetBigdayInfoSocketResMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.TbMd5;
import com.baidu.tbadk.core.util.resourceLoaderProc.BigdayImageLoaderProc;
import com.baidu.tbadk.switchs.BigdaySwitch;
import com.squareup.wire.Wire;
import d.b.b.e.d.l;
import d.b.b.e.l.d;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.GetBigday.BigdayInfo;
import tbclient.GetBigday.GetBigdayResIdl;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: h  reason: collision with root package name */
    public static b f50655h;

    /* renamed from: a  reason: collision with root package name */
    public d.b.h0.r.n.a f50656a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.h0.r.n.a f50657b;

    /* renamed from: c  reason: collision with root package name */
    public SparseArray<Long> f50658c;

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<d.b.h0.r.n.a> f50659d;

    /* renamed from: e  reason: collision with root package name */
    public BdUniqueId f50660e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f50661f = false;

    /* renamed from: g  reason: collision with root package name */
    public d.b.b.c.g.a f50662g = new a(CmdConfigHttp.CMD_GET_BIGDAY_INFO, 309609);

    /* loaded from: classes3.dex */
    public class a extends d.b.b.c.g.a {
        public a(int i, int i2) {
            super(i, i2);
        }

        @Override // d.b.b.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage == null || responsedMessage.hasError()) {
                return;
            }
            b.this.f50661f = true;
            ArrayList<d.b.h0.r.n.a> arrayList = null;
            if (responsedMessage instanceof GetBigdayInfoSocketResMessage) {
                arrayList = ((GetBigdayInfoSocketResMessage) responsedMessage).bigdayInfos;
            } else if (responsedMessage instanceof GetBigdayInfoHttpResMessage) {
                arrayList = ((GetBigdayInfoHttpResMessage) responsedMessage).bigdayInfos;
            }
            b.this.m(arrayList);
        }
    }

    /* renamed from: d.b.h0.r.n.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1083b extends BdAsyncTask<Void, Void, ArrayList<d.b.h0.r.n.a>> {
        public C1083b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public ArrayList<d.b.h0.r.n.a> doInBackground(Void... voidArr) {
            byte[] bArr;
            ArrayList<d.b.h0.r.n.a> arrayList = new ArrayList<>();
            l<byte[]> d2 = d.b.h0.r.r.a.f().d("tb.bigday_datas");
            if (d2 == null || (bArr = d2.get("tb.bigday_datas")) == null) {
                return arrayList;
            }
            try {
                GetBigdayResIdl getBigdayResIdl = (GetBigdayResIdl) new Wire(new Class[0]).parseFrom(bArr, GetBigdayResIdl.class);
                if (getBigdayResIdl.data != null) {
                    for (BigdayInfo bigdayInfo : getBigdayResIdl.data.bigday_list) {
                        if (bigdayInfo != null) {
                            d.b.h0.r.n.a aVar = new d.b.h0.r.n.a();
                            aVar.b(bigdayInfo);
                            if (aVar.a()) {
                                arrayList.add(aVar);
                            }
                        }
                    }
                    return arrayList;
                }
                return arrayList;
            } catch (Exception unused) {
                return null;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(ArrayList<d.b.h0.r.n.a> arrayList) {
            super.onPostExecute(arrayList);
            if (arrayList != null) {
                b.this.l(arrayList);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class c extends DiskFileOperate implements d.b.b.e.a.a {

        /* renamed from: a  reason: collision with root package name */
        public ArrayList<String> f50665a;

        public c(String str, String str2, DiskFileOperate.Action action, ArrayList<d.b.h0.r.n.a> arrayList) {
            super(str, str2, action);
            this.f50665a = new ArrayList<>();
            Iterator<d.b.h0.r.n.a> it = arrayList.iterator();
            while (it.hasNext()) {
                d.b.h0.r.n.a next = it.next();
                if (next != null) {
                    String g2 = d.h().g(next.f50648a, 41);
                    if (!StringUtils.isNULL(g2)) {
                        String nameMd5FromUrl = TbMd5.getNameMd5FromUrl(g2);
                        if (!StringUtils.isNULL(nameMd5FromUrl)) {
                            this.f50665a.add(nameMd5FromUrl);
                        }
                    }
                }
            }
        }

        @Override // d.b.b.e.a.a
        public boolean compare(File file) {
            return (file == null || StringUtils.isNULL(file.getName()) || this.f50665a.contains(file.getName())) ? false : true;
        }
    }

    public b() {
        d.b.i0.c3.d0.a.h(309609, GetBigdayInfoSocketResMessage.class, false, false);
        d.b.i0.c3.d0.a.c(309609, CmdConfigHttp.CMD_GET_BIGDAY_INFO, "c/s/getBigday", GetBigdayInfoHttpResMessage.class, false, false, true, false);
        MessageManager.getInstance().registerListener(this.f50662g);
        this.f50658c = new SparseArray<>();
    }

    public static b i() {
        if (f50655h == null) {
            f50655h = new b();
        }
        return f50655h;
    }

    public final void d(ArrayList<d.b.h0.r.n.a> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        ListUtils.addAll(arrayList2, 0, arrayList);
        ListUtils.add(arrayList2, this.f50656a);
        ListUtils.add(arrayList2, this.f50657b);
        c cVar = new c(TbConfig.BIGDAY_IMAGE_CACHE_DIR_NAME, null, DiskFileOperate.Action.DELETE_FILES, arrayList2);
        cVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
        cVar.setSdCard(false);
        cVar.setSavedCache(true);
        d.b.b.e.a.d.g().a(cVar);
    }

    public void e() {
        MessageManager.getInstance().unRegisterListener(this.f50662g);
    }

    public final void f() {
        if (ListUtils.isEmpty(this.f50659d)) {
            return;
        }
        Iterator<d.b.h0.r.n.a> it = this.f50659d.iterator();
        while (it.hasNext()) {
            d.b.h0.r.n.a next = it.next();
            if (!BigdayImageLoaderProc.isImageFileExist(next.f50648a)) {
                d.h().m(next.f50648a, 41, null, this.f50660e);
            }
        }
    }

    public final d.b.h0.r.n.a g(List<d.b.h0.r.n.a> list, int i) {
        if (ListUtils.isEmpty(list)) {
            return null;
        }
        for (d.b.h0.r.n.a aVar : list) {
            if (aVar.a() && aVar.f50652e == i) {
                long currentTimeMillis = System.currentTimeMillis() / 1000;
                long j = aVar.f50653f;
                if (j > currentTimeMillis) {
                    this.f50658c.put(i, Long.valueOf(j));
                    return null;
                } else if (aVar.f50654g >= currentTimeMillis) {
                    return aVar;
                }
            }
        }
        return null;
    }

    public d.b.h0.r.n.a h(int i) {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (i == 1) {
            if (this.f50656a == null && this.f50658c.get(i, 0L).longValue() != 0 && this.f50658c.get(i, 0L).longValue() < currentTimeMillis) {
                this.f50656a = g(this.f50659d, 1);
            }
            d.b.h0.r.n.a aVar = this.f50656a;
            if (aVar != null && (currentTimeMillis < aVar.f50653f || currentTimeMillis > aVar.f50654g)) {
                this.f50656a = g(this.f50659d, 1);
            }
            d.b.h0.r.n.a aVar2 = this.f50656a;
            if (aVar2 != null && BigdayImageLoaderProc.isImageFileExist(aVar2.f50648a)) {
                return this.f50656a;
            }
        } else if (i == 3) {
            if (this.f50657b == null && this.f50658c.get(i, 0L).longValue() != 0 && this.f50658c.get(i, 0L).longValue() < currentTimeMillis) {
                this.f50656a = g(this.f50659d, 3);
            }
            d.b.h0.r.n.a aVar3 = this.f50657b;
            if (aVar3 != null && (currentTimeMillis < aVar3.f50653f || currentTimeMillis > aVar3.f50654g)) {
                this.f50657b = g(this.f50659d, 3);
            }
            d.b.h0.r.n.a aVar4 = this.f50657b;
            if (aVar4 != null && BigdayImageLoaderProc.isImageFileExist(aVar4.f50648a)) {
                return this.f50657b;
            }
        }
        return null;
    }

    public void j() {
        new C1083b().execute(new Void[0]);
    }

    public void k() {
        this.f50661f = false;
        GetBigdayInfoReqMessage getBigdayInfoReqMessage = new GetBigdayInfoReqMessage();
        getBigdayInfoReqMessage.setTag(this.f50660e);
        MessageManager.getInstance().sendMessage(getBigdayInfoReqMessage);
    }

    public final void l(ArrayList<d.b.h0.r.n.a> arrayList) {
        if (ListUtils.isEmpty(arrayList) || this.f50661f) {
            return;
        }
        this.f50656a = g(arrayList, 1);
        this.f50657b = g(arrayList, 3);
        this.f50659d = arrayList;
        f();
        d.b.h0.r.n.a aVar = this.f50656a;
        if (aVar == null || !BigdayImageLoaderProc.isImageFileExist(aVar.f50648a) || SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) != 1 || System.currentTimeMillis() <= d.b.h0.r.d0.b.i().k("key_bigday_next_showtime_home", 0L)) {
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, this.f50656a));
    }

    public final void m(ArrayList<d.b.h0.r.n.a> arrayList) {
        d.b.h0.r.n.a g2 = g(arrayList, 1);
        d.b.h0.r.n.a g3 = g(arrayList, 3);
        d(arrayList);
        this.f50659d = arrayList;
        if (g2 != null && g2.a()) {
            this.f50656a = g2;
        }
        if (g3 != null && g3.a()) {
            this.f50657b = g3;
        }
        f();
        d.b.h0.r.n.a aVar = this.f50656a;
        if (aVar == null || !BigdayImageLoaderProc.isImageFileExist(aVar.f50648a) || SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) != 1 || System.currentTimeMillis() <= d.b.h0.r.d0.b.i().k("key_bigday_next_showtime_home", 0L)) {
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, this.f50656a));
    }

    public void n(boolean z) {
    }

    public void o(BdUniqueId bdUniqueId) {
        this.f50660e = bdUniqueId;
    }
}

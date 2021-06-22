package d.a.n0.r.n;

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
import d.a.c.e.d.l;
import d.a.c.e.l.d;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.GetBigday.BigdayInfo;
import tbclient.GetBigday.GetBigdayResIdl;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: h  reason: collision with root package name */
    public static b f53674h;

    /* renamed from: a  reason: collision with root package name */
    public d.a.n0.r.n.a f53675a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.n0.r.n.a f53676b;

    /* renamed from: c  reason: collision with root package name */
    public SparseArray<Long> f53677c;

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<d.a.n0.r.n.a> f53678d;

    /* renamed from: e  reason: collision with root package name */
    public BdUniqueId f53679e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f53680f = false;

    /* renamed from: g  reason: collision with root package name */
    public d.a.c.c.g.a f53681g = new a(CmdConfigHttp.CMD_GET_BIGDAY_INFO, 309609);

    /* loaded from: classes3.dex */
    public class a extends d.a.c.c.g.a {
        public a(int i2, int i3) {
            super(i2, i3);
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage == null || responsedMessage.hasError()) {
                return;
            }
            b.this.f53680f = true;
            ArrayList<d.a.n0.r.n.a> arrayList = null;
            if (responsedMessage instanceof GetBigdayInfoSocketResMessage) {
                arrayList = ((GetBigdayInfoSocketResMessage) responsedMessage).bigdayInfos;
            } else if (responsedMessage instanceof GetBigdayInfoHttpResMessage) {
                arrayList = ((GetBigdayInfoHttpResMessage) responsedMessage).bigdayInfos;
            }
            b.this.m(arrayList);
        }
    }

    /* renamed from: d.a.n0.r.n.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1202b extends BdAsyncTask<Void, Void, ArrayList<d.a.n0.r.n.a>> {
        public C1202b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public ArrayList<d.a.n0.r.n.a> doInBackground(Void... voidArr) {
            byte[] bArr;
            ArrayList<d.a.n0.r.n.a> arrayList = new ArrayList<>();
            l<byte[]> d2 = d.a.n0.r.r.a.f().d("tb.bigday_datas");
            if (d2 == null || (bArr = d2.get("tb.bigday_datas")) == null) {
                return arrayList;
            }
            try {
                GetBigdayResIdl getBigdayResIdl = (GetBigdayResIdl) new Wire(new Class[0]).parseFrom(bArr, GetBigdayResIdl.class);
                if (getBigdayResIdl.data != null) {
                    for (BigdayInfo bigdayInfo : getBigdayResIdl.data.bigday_list) {
                        if (bigdayInfo != null) {
                            d.a.n0.r.n.a aVar = new d.a.n0.r.n.a();
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
        public void onPostExecute(ArrayList<d.a.n0.r.n.a> arrayList) {
            super.onPostExecute(arrayList);
            if (arrayList != null) {
                b.this.l(arrayList);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class c extends DiskFileOperate implements d.a.c.e.a.a {

        /* renamed from: a  reason: collision with root package name */
        public ArrayList<String> f53684a;

        public c(String str, String str2, DiskFileOperate.Action action, ArrayList<d.a.n0.r.n.a> arrayList) {
            super(str, str2, action);
            this.f53684a = new ArrayList<>();
            Iterator<d.a.n0.r.n.a> it = arrayList.iterator();
            while (it.hasNext()) {
                d.a.n0.r.n.a next = it.next();
                if (next != null) {
                    String g2 = d.h().g(next.f53667a, 41);
                    if (!StringUtils.isNULL(g2)) {
                        String nameMd5FromUrl = TbMd5.getNameMd5FromUrl(g2);
                        if (!StringUtils.isNULL(nameMd5FromUrl)) {
                            this.f53684a.add(nameMd5FromUrl);
                        }
                    }
                }
            }
        }

        @Override // d.a.c.e.a.a
        public boolean compare(File file) {
            return (file == null || StringUtils.isNULL(file.getName()) || this.f53684a.contains(file.getName())) ? false : true;
        }
    }

    public b() {
        d.a.o0.e3.d0.a.h(309609, GetBigdayInfoSocketResMessage.class, false, false);
        d.a.o0.e3.d0.a.c(309609, CmdConfigHttp.CMD_GET_BIGDAY_INFO, "c/s/getBigday", GetBigdayInfoHttpResMessage.class, false, false, true, false);
        MessageManager.getInstance().registerListener(this.f53681g);
        this.f53677c = new SparseArray<>();
    }

    public static b i() {
        if (f53674h == null) {
            f53674h = new b();
        }
        return f53674h;
    }

    public final void d(ArrayList<d.a.n0.r.n.a> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        ListUtils.addAll(arrayList2, 0, arrayList);
        ListUtils.add(arrayList2, this.f53675a);
        ListUtils.add(arrayList2, this.f53676b);
        c cVar = new c(TbConfig.BIGDAY_IMAGE_CACHE_DIR_NAME, null, DiskFileOperate.Action.DELETE_FILES, arrayList2);
        cVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
        cVar.setSdCard(false);
        cVar.setSavedCache(true);
        d.a.c.e.a.d.g().a(cVar);
    }

    public void e() {
        MessageManager.getInstance().unRegisterListener(this.f53681g);
    }

    public final void f() {
        if (ListUtils.isEmpty(this.f53678d)) {
            return;
        }
        Iterator<d.a.n0.r.n.a> it = this.f53678d.iterator();
        while (it.hasNext()) {
            d.a.n0.r.n.a next = it.next();
            if (!BigdayImageLoaderProc.isImageFileExist(next.f53667a)) {
                d.h().m(next.f53667a, 41, null, this.f53679e);
            }
        }
    }

    public final d.a.n0.r.n.a g(List<d.a.n0.r.n.a> list, int i2) {
        if (ListUtils.isEmpty(list)) {
            return null;
        }
        for (d.a.n0.r.n.a aVar : list) {
            if (aVar.a() && aVar.f53671e == i2) {
                long currentTimeMillis = System.currentTimeMillis() / 1000;
                long j = aVar.f53672f;
                if (j > currentTimeMillis) {
                    this.f53677c.put(i2, Long.valueOf(j));
                    return null;
                } else if (aVar.f53673g >= currentTimeMillis) {
                    return aVar;
                }
            }
        }
        return null;
    }

    public d.a.n0.r.n.a h(int i2) {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (i2 == 1) {
            if (this.f53675a == null && this.f53677c.get(i2, 0L).longValue() != 0 && this.f53677c.get(i2, 0L).longValue() < currentTimeMillis) {
                this.f53675a = g(this.f53678d, 1);
            }
            d.a.n0.r.n.a aVar = this.f53675a;
            if (aVar != null && (currentTimeMillis < aVar.f53672f || currentTimeMillis > aVar.f53673g)) {
                this.f53675a = g(this.f53678d, 1);
            }
            d.a.n0.r.n.a aVar2 = this.f53675a;
            if (aVar2 != null && BigdayImageLoaderProc.isImageFileExist(aVar2.f53667a)) {
                return this.f53675a;
            }
        } else if (i2 == 3) {
            if (this.f53676b == null && this.f53677c.get(i2, 0L).longValue() != 0 && this.f53677c.get(i2, 0L).longValue() < currentTimeMillis) {
                this.f53675a = g(this.f53678d, 3);
            }
            d.a.n0.r.n.a aVar3 = this.f53676b;
            if (aVar3 != null && (currentTimeMillis < aVar3.f53672f || currentTimeMillis > aVar3.f53673g)) {
                this.f53676b = g(this.f53678d, 3);
            }
            d.a.n0.r.n.a aVar4 = this.f53676b;
            if (aVar4 != null && BigdayImageLoaderProc.isImageFileExist(aVar4.f53667a)) {
                return this.f53676b;
            }
        }
        return null;
    }

    public void j() {
        new C1202b().execute(new Void[0]);
    }

    public void k() {
        this.f53680f = false;
        GetBigdayInfoReqMessage getBigdayInfoReqMessage = new GetBigdayInfoReqMessage();
        getBigdayInfoReqMessage.setTag(this.f53679e);
        MessageManager.getInstance().sendMessage(getBigdayInfoReqMessage);
    }

    public final void l(ArrayList<d.a.n0.r.n.a> arrayList) {
        if (ListUtils.isEmpty(arrayList) || this.f53680f) {
            return;
        }
        this.f53675a = g(arrayList, 1);
        this.f53676b = g(arrayList, 3);
        this.f53678d = arrayList;
        f();
        d.a.n0.r.n.a aVar = this.f53675a;
        if (aVar == null || !BigdayImageLoaderProc.isImageFileExist(aVar.f53667a) || SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) != 1 || System.currentTimeMillis() <= d.a.n0.r.d0.b.j().l("key_bigday_next_showtime_home", 0L)) {
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, this.f53675a));
    }

    public final void m(ArrayList<d.a.n0.r.n.a> arrayList) {
        d.a.n0.r.n.a g2 = g(arrayList, 1);
        d.a.n0.r.n.a g3 = g(arrayList, 3);
        d(arrayList);
        this.f53678d = arrayList;
        if (g2 != null && g2.a()) {
            this.f53675a = g2;
        }
        if (g3 != null && g3.a()) {
            this.f53676b = g3;
        }
        f();
        d.a.n0.r.n.a aVar = this.f53675a;
        if (aVar == null || !BigdayImageLoaderProc.isImageFileExist(aVar.f53667a) || SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) != 1 || System.currentTimeMillis() <= d.a.n0.r.d0.b.j().l("key_bigday_next_showtime_home", 0L)) {
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, this.f53675a));
    }

    public void n(boolean z) {
    }

    public void o(BdUniqueId bdUniqueId) {
        this.f53679e = bdUniqueId;
    }
}

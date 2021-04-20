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
import d.b.c.e.d.l;
import d.b.c.e.l.d;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.GetBigday.BigdayInfo;
import tbclient.GetBigday.GetBigdayResIdl;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: h  reason: collision with root package name */
    public static b f51063h;

    /* renamed from: a  reason: collision with root package name */
    public d.b.h0.r.n.a f51064a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.h0.r.n.a f51065b;

    /* renamed from: c  reason: collision with root package name */
    public SparseArray<Long> f51066c;

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<d.b.h0.r.n.a> f51067d;

    /* renamed from: e  reason: collision with root package name */
    public BdUniqueId f51068e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f51069f = false;

    /* renamed from: g  reason: collision with root package name */
    public d.b.c.c.g.a f51070g = new a(CmdConfigHttp.CMD_GET_BIGDAY_INFO, 309609);

    /* loaded from: classes3.dex */
    public class a extends d.b.c.c.g.a {
        public a(int i, int i2) {
            super(i, i2);
        }

        @Override // d.b.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage == null || responsedMessage.hasError()) {
                return;
            }
            b.this.f51069f = true;
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
    public class C1097b extends BdAsyncTask<Void, Void, ArrayList<d.b.h0.r.n.a>> {
        public C1097b() {
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
    public static class c extends DiskFileOperate implements d.b.c.e.a.a {

        /* renamed from: a  reason: collision with root package name */
        public ArrayList<String> f51073a;

        public c(String str, String str2, DiskFileOperate.Action action, ArrayList<d.b.h0.r.n.a> arrayList) {
            super(str, str2, action);
            this.f51073a = new ArrayList<>();
            Iterator<d.b.h0.r.n.a> it = arrayList.iterator();
            while (it.hasNext()) {
                d.b.h0.r.n.a next = it.next();
                if (next != null) {
                    String g2 = d.h().g(next.f51056a, 41);
                    if (!StringUtils.isNULL(g2)) {
                        String nameMd5FromUrl = TbMd5.getNameMd5FromUrl(g2);
                        if (!StringUtils.isNULL(nameMd5FromUrl)) {
                            this.f51073a.add(nameMd5FromUrl);
                        }
                    }
                }
            }
        }

        @Override // d.b.c.e.a.a
        public boolean compare(File file) {
            return (file == null || StringUtils.isNULL(file.getName()) || this.f51073a.contains(file.getName())) ? false : true;
        }
    }

    public b() {
        d.b.i0.d3.d0.a.h(309609, GetBigdayInfoSocketResMessage.class, false, false);
        d.b.i0.d3.d0.a.c(309609, CmdConfigHttp.CMD_GET_BIGDAY_INFO, "c/s/getBigday", GetBigdayInfoHttpResMessage.class, false, false, true, false);
        MessageManager.getInstance().registerListener(this.f51070g);
        this.f51066c = new SparseArray<>();
    }

    public static b i() {
        if (f51063h == null) {
            f51063h = new b();
        }
        return f51063h;
    }

    public final void d(ArrayList<d.b.h0.r.n.a> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        ListUtils.addAll(arrayList2, 0, arrayList);
        ListUtils.add(arrayList2, this.f51064a);
        ListUtils.add(arrayList2, this.f51065b);
        c cVar = new c(TbConfig.BIGDAY_IMAGE_CACHE_DIR_NAME, null, DiskFileOperate.Action.DELETE_FILES, arrayList2);
        cVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
        cVar.setSdCard(false);
        cVar.setSavedCache(true);
        d.b.c.e.a.d.g().a(cVar);
    }

    public void e() {
        MessageManager.getInstance().unRegisterListener(this.f51070g);
    }

    public final void f() {
        if (ListUtils.isEmpty(this.f51067d)) {
            return;
        }
        Iterator<d.b.h0.r.n.a> it = this.f51067d.iterator();
        while (it.hasNext()) {
            d.b.h0.r.n.a next = it.next();
            if (!BigdayImageLoaderProc.isImageFileExist(next.f51056a)) {
                d.h().m(next.f51056a, 41, null, this.f51068e);
            }
        }
    }

    public final d.b.h0.r.n.a g(List<d.b.h0.r.n.a> list, int i) {
        if (ListUtils.isEmpty(list)) {
            return null;
        }
        for (d.b.h0.r.n.a aVar : list) {
            if (aVar.a() && aVar.f51060e == i) {
                long currentTimeMillis = System.currentTimeMillis() / 1000;
                long j = aVar.f51061f;
                if (j > currentTimeMillis) {
                    this.f51066c.put(i, Long.valueOf(j));
                    return null;
                } else if (aVar.f51062g >= currentTimeMillis) {
                    return aVar;
                }
            }
        }
        return null;
    }

    public d.b.h0.r.n.a h(int i) {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (i == 1) {
            if (this.f51064a == null && this.f51066c.get(i, 0L).longValue() != 0 && this.f51066c.get(i, 0L).longValue() < currentTimeMillis) {
                this.f51064a = g(this.f51067d, 1);
            }
            d.b.h0.r.n.a aVar = this.f51064a;
            if (aVar != null && (currentTimeMillis < aVar.f51061f || currentTimeMillis > aVar.f51062g)) {
                this.f51064a = g(this.f51067d, 1);
            }
            d.b.h0.r.n.a aVar2 = this.f51064a;
            if (aVar2 != null && BigdayImageLoaderProc.isImageFileExist(aVar2.f51056a)) {
                return this.f51064a;
            }
        } else if (i == 3) {
            if (this.f51065b == null && this.f51066c.get(i, 0L).longValue() != 0 && this.f51066c.get(i, 0L).longValue() < currentTimeMillis) {
                this.f51064a = g(this.f51067d, 3);
            }
            d.b.h0.r.n.a aVar3 = this.f51065b;
            if (aVar3 != null && (currentTimeMillis < aVar3.f51061f || currentTimeMillis > aVar3.f51062g)) {
                this.f51065b = g(this.f51067d, 3);
            }
            d.b.h0.r.n.a aVar4 = this.f51065b;
            if (aVar4 != null && BigdayImageLoaderProc.isImageFileExist(aVar4.f51056a)) {
                return this.f51065b;
            }
        }
        return null;
    }

    public void j() {
        new C1097b().execute(new Void[0]);
    }

    public void k() {
        this.f51069f = false;
        GetBigdayInfoReqMessage getBigdayInfoReqMessage = new GetBigdayInfoReqMessage();
        getBigdayInfoReqMessage.setTag(this.f51068e);
        MessageManager.getInstance().sendMessage(getBigdayInfoReqMessage);
    }

    public final void l(ArrayList<d.b.h0.r.n.a> arrayList) {
        if (ListUtils.isEmpty(arrayList) || this.f51069f) {
            return;
        }
        this.f51064a = g(arrayList, 1);
        this.f51065b = g(arrayList, 3);
        this.f51067d = arrayList;
        f();
        d.b.h0.r.n.a aVar = this.f51064a;
        if (aVar == null || !BigdayImageLoaderProc.isImageFileExist(aVar.f51056a) || SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) != 1 || System.currentTimeMillis() <= d.b.h0.r.d0.b.j().l("key_bigday_next_showtime_home", 0L)) {
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, this.f51064a));
    }

    public final void m(ArrayList<d.b.h0.r.n.a> arrayList) {
        d.b.h0.r.n.a g2 = g(arrayList, 1);
        d.b.h0.r.n.a g3 = g(arrayList, 3);
        d(arrayList);
        this.f51067d = arrayList;
        if (g2 != null && g2.a()) {
            this.f51064a = g2;
        }
        if (g3 != null && g3.a()) {
            this.f51065b = g3;
        }
        f();
        d.b.h0.r.n.a aVar = this.f51064a;
        if (aVar == null || !BigdayImageLoaderProc.isImageFileExist(aVar.f51056a) || SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) != 1 || System.currentTimeMillis() <= d.b.h0.r.d0.b.j().l("key_bigday_next_showtime_home", 0L)) {
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, this.f51064a));
    }

    public void n(boolean z) {
    }

    public void o(BdUniqueId bdUniqueId) {
        this.f51068e = bdUniqueId;
    }
}

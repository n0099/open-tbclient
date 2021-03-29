package d.b.i0.u0.c;

import androidx.collection.LongSparseArray;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.godSquare.model.req.GodSquareCacheRequestMsg;
import com.baidu.tieba.godSquare.model.req.GodSquareRequestMsg;
import com.baidu.tieba.godSquare.model.res.GodSquareCacheResponsedMsg;
import com.baidu.tieba.godSquare.model.res.GodSquareHttpResponsedMsg;
import com.baidu.tieba.godSquare.model.res.GodSquareSocketResponsedMsg;
import d.b.b.e.p.j;
import d.b.b.j.e.n;
import d.b.i0.x.e0.h;
import d.b.i0.x.f0.e;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetHotGod.DataRes;
import tbclient.User;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public c f61250a;

    /* renamed from: b  reason: collision with root package name */
    public BaseActivity f61251b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f61252c;

    /* renamed from: g  reason: collision with root package name */
    public LongSparseArray<MetaData> f61256g;

    /* renamed from: d  reason: collision with root package name */
    public int f61253d = 0;

    /* renamed from: e  reason: collision with root package name */
    public List<n> f61254e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public int f61255f = 1;

    /* renamed from: h  reason: collision with root package name */
    public d.b.b.c.g.a f61257h = new a(CmdConfigHttp.CMD_GET_HOT_GOD, 309315);
    public CustomMessageListener i = new C1596b(2016446);

    /* loaded from: classes4.dex */
    public class a extends d.b.b.c.g.a {
        public a(int i, int i2) {
            super(i, i2);
        }

        @Override // d.b.b.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (b.this.f61250a == null) {
                return;
            }
            if (responsedMessage instanceof GodSquareHttpResponsedMsg) {
                GodSquareHttpResponsedMsg godSquareHttpResponsedMsg = (GodSquareHttpResponsedMsg) responsedMessage;
                b.this.f61250a.a(b.this.f(godSquareHttpResponsedMsg.getResult()), b.this.f61252c, godSquareHttpResponsedMsg.getHasMore(), godSquareHttpResponsedMsg.getErrorString());
            } else if (responsedMessage instanceof GodSquareSocketResponsedMsg) {
                GodSquareSocketResponsedMsg godSquareSocketResponsedMsg = (GodSquareSocketResponsedMsg) responsedMessage;
                b.this.f61250a.a(b.this.f(godSquareSocketResponsedMsg.getResult()), b.this.f61252c, godSquareSocketResponsedMsg.getHasMore(), godSquareSocketResponsedMsg.getErrorString());
            }
        }
    }

    /* renamed from: d.b.i0.u0.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1596b extends CustomMessageListener {
        public C1596b(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (b.this.f61250a == null) {
                return;
            }
            if (!(customResponsedMessage instanceof GodSquareCacheResponsedMsg)) {
                b.this.i(1);
                return;
            }
            GodSquareCacheResponsedMsg godSquareCacheResponsedMsg = (GodSquareCacheResponsedMsg) customResponsedMessage;
            if (godSquareCacheResponsedMsg.getResult() == null || ListUtils.isEmpty(godSquareCacheResponsedMsg.getResult().user_list)) {
                b.this.i(1);
            } else {
                b.this.f61250a.a(b.this.f(godSquareCacheResponsedMsg.getResult()), b.this.f61252c, true, godSquareCacheResponsedMsg.getErrorString());
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface c {
        void a(List<n> list, boolean z, boolean z2, String str);
    }

    public b(c cVar, BaseActivity baseActivity) {
        this.f61250a = cVar;
        this.f61251b = baseActivity;
        k();
    }

    public final void e(List<User> list) {
        if (this.f61256g == null) {
            this.f61256g = new LongSparseArray<>();
        }
        for (User user : list) {
            h hVar = new h();
            MetaData metaData = new MetaData();
            hVar.f62211e = metaData;
            metaData.parserProtobuf(user);
            this.f61256g.put(user.id.longValue(), hVar.f62211e);
        }
    }

    public final List<n> f(DataRes dataRes) {
        MetaData metaData;
        MetaData metaData2;
        if (dataRes == null || ListUtils.isEmpty(dataRes.user_list)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        e(dataRes.user_list);
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        if (!ListUtils.isEmpty(dataRes.recommend_uid_list) && this.f61252c) {
            for (Long l : dataRes.recommend_uid_list) {
                if (l != null && (metaData2 = this.f61256g.get(l.longValue())) != null) {
                    h hVar = new h();
                    hVar.f62211e = metaData2;
                    hVar.f62212f = 1;
                    arrayList2.add(hVar);
                }
            }
            if (this.f61251b != null && !ListUtils.isEmpty(arrayList2)) {
                e eVar = new e();
                eVar.f62233e = this.f61251b.getResources().getString(R.string.special_recommend);
                eVar.needTopMargin = false;
                arrayList2.add(0, eVar);
            }
            arrayList.addAll(arrayList2);
        }
        if (!ListUtils.isEmpty(dataRes.hot_uid_list)) {
            for (Long l2 : dataRes.hot_uid_list) {
                if (l2 != null && (metaData = this.f61256g.get(l2.longValue())) != null) {
                    h hVar2 = new h();
                    hVar2.f62211e = metaData;
                    hVar2.f62212f = 0;
                    hVar2.f62213g = this.f61255f;
                    arrayList3.add(hVar2);
                    this.f61255f++;
                }
            }
            if (this.f61251b != null && !ListUtils.isEmpty(arrayList3) && this.f61252c) {
                e eVar2 = new e();
                eVar2.f62233e = this.f61251b.getResources().getString(R.string.hot_god);
                if (ListUtils.isEmpty(arrayList2)) {
                    eVar2.needTopMargin = false;
                } else {
                    eVar2.needTopMargin = true;
                }
                arrayList3.add(0, eVar2);
            }
            arrayList.addAll(arrayList3);
        }
        return arrayList;
    }

    public boolean g(long j) {
        LongSparseArray<MetaData> longSparseArray = this.f61256g;
        return (longSparseArray == null || longSparseArray.get(j) == null) ? false : true;
    }

    public final void h(int i) {
        if (this.f61251b == null) {
            return;
        }
        GodSquareCacheRequestMsg godSquareCacheRequestMsg = new GodSquareCacheRequestMsg();
        godSquareCacheRequestMsg.cacheKey = i + "";
        this.f61251b.sendMessage(godSquareCacheRequestMsg);
    }

    public final void i(int i) {
        if (this.f61251b == null) {
            return;
        }
        this.f61253d = i;
        GodSquareRequestMsg godSquareRequestMsg = new GodSquareRequestMsg();
        godSquareRequestMsg.pn = i;
        this.f61251b.sendMessage(godSquareRequestMsg);
    }

    public void j() {
        this.f61252c = false;
        i(this.f61253d + 1);
    }

    public final void k() {
        BaseActivity baseActivity = this.f61251b;
        if (baseActivity == null) {
            return;
        }
        baseActivity.registerListener(this.i);
        this.f61251b.registerListener(this.f61257h);
    }

    public void l() {
        this.f61255f = 1;
        this.f61252c = true;
        if (j.A()) {
            i(1);
        } else {
            h(1);
        }
    }
}

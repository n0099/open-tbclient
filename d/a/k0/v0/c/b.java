package d.a.k0.v0.c;

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
import d.a.c.e.p.j;
import d.a.c.j.e.n;
import d.a.k0.x.e0.h;
import d.a.k0.x.f0.e;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetHotGod.DataRes;
import tbclient.User;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public c f62363a;

    /* renamed from: b  reason: collision with root package name */
    public BaseActivity f62364b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f62365c;

    /* renamed from: g  reason: collision with root package name */
    public LongSparseArray<MetaData> f62369g;

    /* renamed from: d  reason: collision with root package name */
    public int f62366d = 0;

    /* renamed from: e  reason: collision with root package name */
    public List<n> f62367e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public int f62368f = 1;

    /* renamed from: h  reason: collision with root package name */
    public d.a.c.c.g.a f62370h = new a(CmdConfigHttp.CMD_GET_HOT_GOD, 309315);

    /* renamed from: i  reason: collision with root package name */
    public CustomMessageListener f62371i = new C1684b(2016446);

    /* loaded from: classes4.dex */
    public class a extends d.a.c.c.g.a {
        public a(int i2, int i3) {
            super(i2, i3);
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (b.this.f62363a == null) {
                return;
            }
            if (responsedMessage instanceof GodSquareHttpResponsedMsg) {
                GodSquareHttpResponsedMsg godSquareHttpResponsedMsg = (GodSquareHttpResponsedMsg) responsedMessage;
                b.this.f62363a.a(b.this.f(godSquareHttpResponsedMsg.getResult()), b.this.f62365c, godSquareHttpResponsedMsg.getHasMore(), godSquareHttpResponsedMsg.getErrorString());
            } else if (responsedMessage instanceof GodSquareSocketResponsedMsg) {
                GodSquareSocketResponsedMsg godSquareSocketResponsedMsg = (GodSquareSocketResponsedMsg) responsedMessage;
                b.this.f62363a.a(b.this.f(godSquareSocketResponsedMsg.getResult()), b.this.f62365c, godSquareSocketResponsedMsg.getHasMore(), godSquareSocketResponsedMsg.getErrorString());
            }
        }
    }

    /* renamed from: d.a.k0.v0.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1684b extends CustomMessageListener {
        public C1684b(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (b.this.f62363a == null) {
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
                b.this.f62363a.a(b.this.f(godSquareCacheResponsedMsg.getResult()), b.this.f62365c, true, godSquareCacheResponsedMsg.getErrorString());
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface c {
        void a(List<n> list, boolean z, boolean z2, String str);
    }

    public b(c cVar, BaseActivity baseActivity) {
        this.f62363a = cVar;
        this.f62364b = baseActivity;
        k();
    }

    public final void e(List<User> list) {
        if (this.f62369g == null) {
            this.f62369g = new LongSparseArray<>();
        }
        for (User user : list) {
            h hVar = new h();
            MetaData metaData = new MetaData();
            hVar.f63195e = metaData;
            metaData.parserProtobuf(user);
            this.f62369g.put(user.id.longValue(), hVar.f63195e);
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
        if (!ListUtils.isEmpty(dataRes.recommend_uid_list) && this.f62365c) {
            for (Long l : dataRes.recommend_uid_list) {
                if (l != null && (metaData2 = this.f62369g.get(l.longValue())) != null) {
                    h hVar = new h();
                    hVar.f63195e = metaData2;
                    hVar.f63196f = 1;
                    arrayList2.add(hVar);
                }
            }
            if (this.f62364b != null && !ListUtils.isEmpty(arrayList2)) {
                e eVar = new e();
                eVar.f63219e = this.f62364b.getResources().getString(R.string.special_recommend);
                eVar.needTopMargin = false;
                arrayList2.add(0, eVar);
            }
            arrayList.addAll(arrayList2);
        }
        if (!ListUtils.isEmpty(dataRes.hot_uid_list)) {
            for (Long l2 : dataRes.hot_uid_list) {
                if (l2 != null && (metaData = this.f62369g.get(l2.longValue())) != null) {
                    h hVar2 = new h();
                    hVar2.f63195e = metaData;
                    hVar2.f63196f = 0;
                    hVar2.f63197g = this.f62368f;
                    arrayList3.add(hVar2);
                    this.f62368f++;
                }
            }
            if (this.f62364b != null && !ListUtils.isEmpty(arrayList3) && this.f62365c) {
                e eVar2 = new e();
                eVar2.f63219e = this.f62364b.getResources().getString(R.string.hot_god);
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
        LongSparseArray<MetaData> longSparseArray = this.f62369g;
        return (longSparseArray == null || longSparseArray.get(j) == null) ? false : true;
    }

    public final void h(int i2) {
        if (this.f62364b == null) {
            return;
        }
        GodSquareCacheRequestMsg godSquareCacheRequestMsg = new GodSquareCacheRequestMsg();
        godSquareCacheRequestMsg.cacheKey = i2 + "";
        this.f62364b.sendMessage(godSquareCacheRequestMsg);
    }

    public final void i(int i2) {
        if (this.f62364b == null) {
            return;
        }
        this.f62366d = i2;
        GodSquareRequestMsg godSquareRequestMsg = new GodSquareRequestMsg();
        godSquareRequestMsg.pn = i2;
        this.f62364b.sendMessage(godSquareRequestMsg);
    }

    public void j() {
        this.f62365c = false;
        i(this.f62366d + 1);
    }

    public final void k() {
        BaseActivity baseActivity = this.f62364b;
        if (baseActivity == null) {
            return;
        }
        baseActivity.registerListener(this.f62371i);
        this.f62364b.registerListener(this.f62370h);
    }

    public void l() {
        this.f62368f = 1;
        this.f62365c = true;
        if (j.A()) {
            i(1);
        } else {
            h(1);
        }
    }
}

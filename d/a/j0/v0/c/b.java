package d.a.j0.v0.c;

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
import d.a.j0.x.e0.h;
import d.a.j0.x.f0.e;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetHotGod.DataRes;
import tbclient.User;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public c f61639a;

    /* renamed from: b  reason: collision with root package name */
    public BaseActivity f61640b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f61641c;

    /* renamed from: g  reason: collision with root package name */
    public LongSparseArray<MetaData> f61645g;

    /* renamed from: d  reason: collision with root package name */
    public int f61642d = 0;

    /* renamed from: e  reason: collision with root package name */
    public List<n> f61643e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public int f61644f = 1;

    /* renamed from: h  reason: collision with root package name */
    public d.a.c.c.g.a f61646h = new a(CmdConfigHttp.CMD_GET_HOT_GOD, 309315);

    /* renamed from: i  reason: collision with root package name */
    public CustomMessageListener f61647i = new C1619b(2016446);

    /* loaded from: classes4.dex */
    public class a extends d.a.c.c.g.a {
        public a(int i2, int i3) {
            super(i2, i3);
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (b.this.f61639a == null) {
                return;
            }
            if (responsedMessage instanceof GodSquareHttpResponsedMsg) {
                GodSquareHttpResponsedMsg godSquareHttpResponsedMsg = (GodSquareHttpResponsedMsg) responsedMessage;
                b.this.f61639a.a(b.this.f(godSquareHttpResponsedMsg.getResult()), b.this.f61641c, godSquareHttpResponsedMsg.getHasMore(), godSquareHttpResponsedMsg.getErrorString());
            } else if (responsedMessage instanceof GodSquareSocketResponsedMsg) {
                GodSquareSocketResponsedMsg godSquareSocketResponsedMsg = (GodSquareSocketResponsedMsg) responsedMessage;
                b.this.f61639a.a(b.this.f(godSquareSocketResponsedMsg.getResult()), b.this.f61641c, godSquareSocketResponsedMsg.getHasMore(), godSquareSocketResponsedMsg.getErrorString());
            }
        }
    }

    /* renamed from: d.a.j0.v0.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1619b extends CustomMessageListener {
        public C1619b(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (b.this.f61639a == null) {
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
                b.this.f61639a.a(b.this.f(godSquareCacheResponsedMsg.getResult()), b.this.f61641c, true, godSquareCacheResponsedMsg.getErrorString());
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface c {
        void a(List<n> list, boolean z, boolean z2, String str);
    }

    public b(c cVar, BaseActivity baseActivity) {
        this.f61639a = cVar;
        this.f61640b = baseActivity;
        k();
    }

    public final void e(List<User> list) {
        if (this.f61645g == null) {
            this.f61645g = new LongSparseArray<>();
        }
        for (User user : list) {
            h hVar = new h();
            MetaData metaData = new MetaData();
            hVar.f62471e = metaData;
            metaData.parserProtobuf(user);
            this.f61645g.put(user.id.longValue(), hVar.f62471e);
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
        if (!ListUtils.isEmpty(dataRes.recommend_uid_list) && this.f61641c) {
            for (Long l : dataRes.recommend_uid_list) {
                if (l != null && (metaData2 = this.f61645g.get(l.longValue())) != null) {
                    h hVar = new h();
                    hVar.f62471e = metaData2;
                    hVar.f62472f = 1;
                    arrayList2.add(hVar);
                }
            }
            if (this.f61640b != null && !ListUtils.isEmpty(arrayList2)) {
                e eVar = new e();
                eVar.f62495e = this.f61640b.getResources().getString(R.string.special_recommend);
                eVar.needTopMargin = false;
                arrayList2.add(0, eVar);
            }
            arrayList.addAll(arrayList2);
        }
        if (!ListUtils.isEmpty(dataRes.hot_uid_list)) {
            for (Long l2 : dataRes.hot_uid_list) {
                if (l2 != null && (metaData = this.f61645g.get(l2.longValue())) != null) {
                    h hVar2 = new h();
                    hVar2.f62471e = metaData;
                    hVar2.f62472f = 0;
                    hVar2.f62473g = this.f61644f;
                    arrayList3.add(hVar2);
                    this.f61644f++;
                }
            }
            if (this.f61640b != null && !ListUtils.isEmpty(arrayList3) && this.f61641c) {
                e eVar2 = new e();
                eVar2.f62495e = this.f61640b.getResources().getString(R.string.hot_god);
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
        LongSparseArray<MetaData> longSparseArray = this.f61645g;
        return (longSparseArray == null || longSparseArray.get(j) == null) ? false : true;
    }

    public final void h(int i2) {
        if (this.f61640b == null) {
            return;
        }
        GodSquareCacheRequestMsg godSquareCacheRequestMsg = new GodSquareCacheRequestMsg();
        godSquareCacheRequestMsg.cacheKey = i2 + "";
        this.f61640b.sendMessage(godSquareCacheRequestMsg);
    }

    public final void i(int i2) {
        if (this.f61640b == null) {
            return;
        }
        this.f61642d = i2;
        GodSquareRequestMsg godSquareRequestMsg = new GodSquareRequestMsg();
        godSquareRequestMsg.pn = i2;
        this.f61640b.sendMessage(godSquareRequestMsg);
    }

    public void j() {
        this.f61641c = false;
        i(this.f61642d + 1);
    }

    public final void k() {
        BaseActivity baseActivity = this.f61640b;
        if (baseActivity == null) {
            return;
        }
        baseActivity.registerListener(this.f61647i);
        this.f61640b.registerListener(this.f61646h);
    }

    public void l() {
        this.f61644f = 1;
        this.f61641c = true;
        if (j.A()) {
            i(1);
        } else {
            h(1);
        }
    }
}

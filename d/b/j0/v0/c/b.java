package d.b.j0.v0.c;

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
import d.b.c.e.p.j;
import d.b.c.j.e.n;
import d.b.j0.x.e0.h;
import d.b.j0.x.f0.e;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetHotGod.DataRes;
import tbclient.User;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public c f63409a;

    /* renamed from: b  reason: collision with root package name */
    public BaseActivity f63410b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f63411c;

    /* renamed from: g  reason: collision with root package name */
    public LongSparseArray<MetaData> f63415g;

    /* renamed from: d  reason: collision with root package name */
    public int f63412d = 0;

    /* renamed from: e  reason: collision with root package name */
    public List<n> f63413e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public int f63414f = 1;

    /* renamed from: h  reason: collision with root package name */
    public d.b.c.c.g.a f63416h = new a(CmdConfigHttp.CMD_GET_HOT_GOD, 309315);
    public CustomMessageListener i = new C1679b(2016446);

    /* loaded from: classes4.dex */
    public class a extends d.b.c.c.g.a {
        public a(int i, int i2) {
            super(i, i2);
        }

        @Override // d.b.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (b.this.f63409a == null) {
                return;
            }
            if (responsedMessage instanceof GodSquareHttpResponsedMsg) {
                GodSquareHttpResponsedMsg godSquareHttpResponsedMsg = (GodSquareHttpResponsedMsg) responsedMessage;
                b.this.f63409a.a(b.this.f(godSquareHttpResponsedMsg.getResult()), b.this.f63411c, godSquareHttpResponsedMsg.getHasMore(), godSquareHttpResponsedMsg.getErrorString());
            } else if (responsedMessage instanceof GodSquareSocketResponsedMsg) {
                GodSquareSocketResponsedMsg godSquareSocketResponsedMsg = (GodSquareSocketResponsedMsg) responsedMessage;
                b.this.f63409a.a(b.this.f(godSquareSocketResponsedMsg.getResult()), b.this.f63411c, godSquareSocketResponsedMsg.getHasMore(), godSquareSocketResponsedMsg.getErrorString());
            }
        }
    }

    /* renamed from: d.b.j0.v0.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1679b extends CustomMessageListener {
        public C1679b(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (b.this.f63409a == null) {
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
                b.this.f63409a.a(b.this.f(godSquareCacheResponsedMsg.getResult()), b.this.f63411c, true, godSquareCacheResponsedMsg.getErrorString());
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface c {
        void a(List<n> list, boolean z, boolean z2, String str);
    }

    public b(c cVar, BaseActivity baseActivity) {
        this.f63409a = cVar;
        this.f63410b = baseActivity;
        k();
    }

    public final void e(List<User> list) {
        if (this.f63415g == null) {
            this.f63415g = new LongSparseArray<>();
        }
        for (User user : list) {
            h hVar = new h();
            MetaData metaData = new MetaData();
            hVar.f64207e = metaData;
            metaData.parserProtobuf(user);
            this.f63415g.put(user.id.longValue(), hVar.f64207e);
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
        if (!ListUtils.isEmpty(dataRes.recommend_uid_list) && this.f63411c) {
            for (Long l : dataRes.recommend_uid_list) {
                if (l != null && (metaData2 = this.f63415g.get(l.longValue())) != null) {
                    h hVar = new h();
                    hVar.f64207e = metaData2;
                    hVar.f64208f = 1;
                    arrayList2.add(hVar);
                }
            }
            if (this.f63410b != null && !ListUtils.isEmpty(arrayList2)) {
                e eVar = new e();
                eVar.f64229e = this.f63410b.getResources().getString(R.string.special_recommend);
                eVar.needTopMargin = false;
                arrayList2.add(0, eVar);
            }
            arrayList.addAll(arrayList2);
        }
        if (!ListUtils.isEmpty(dataRes.hot_uid_list)) {
            for (Long l2 : dataRes.hot_uid_list) {
                if (l2 != null && (metaData = this.f63415g.get(l2.longValue())) != null) {
                    h hVar2 = new h();
                    hVar2.f64207e = metaData;
                    hVar2.f64208f = 0;
                    hVar2.f64209g = this.f63414f;
                    arrayList3.add(hVar2);
                    this.f63414f++;
                }
            }
            if (this.f63410b != null && !ListUtils.isEmpty(arrayList3) && this.f63411c) {
                e eVar2 = new e();
                eVar2.f64229e = this.f63410b.getResources().getString(R.string.hot_god);
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
        LongSparseArray<MetaData> longSparseArray = this.f63415g;
        return (longSparseArray == null || longSparseArray.get(j) == null) ? false : true;
    }

    public final void h(int i) {
        if (this.f63410b == null) {
            return;
        }
        GodSquareCacheRequestMsg godSquareCacheRequestMsg = new GodSquareCacheRequestMsg();
        godSquareCacheRequestMsg.cacheKey = i + "";
        this.f63410b.sendMessage(godSquareCacheRequestMsg);
    }

    public final void i(int i) {
        if (this.f63410b == null) {
            return;
        }
        this.f63412d = i;
        GodSquareRequestMsg godSquareRequestMsg = new GodSquareRequestMsg();
        godSquareRequestMsg.pn = i;
        this.f63410b.sendMessage(godSquareRequestMsg);
    }

    public void j() {
        this.f63411c = false;
        i(this.f63412d + 1);
    }

    public final void k() {
        BaseActivity baseActivity = this.f63410b;
        if (baseActivity == null) {
            return;
        }
        baseActivity.registerListener(this.i);
        this.f63410b.registerListener(this.f63416h);
    }

    public void l() {
        this.f63414f = 1;
        this.f63411c = true;
        if (j.A()) {
            i(1);
        } else {
            h(1);
        }
    }
}

package d.b.i0.v0.c;

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
import d.b.i0.x.e0.h;
import d.b.i0.x.f0.e;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetHotGod.DataRes;
import tbclient.User;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public c f62988a;

    /* renamed from: b  reason: collision with root package name */
    public BaseActivity f62989b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f62990c;

    /* renamed from: g  reason: collision with root package name */
    public LongSparseArray<MetaData> f62994g;

    /* renamed from: d  reason: collision with root package name */
    public int f62991d = 0;

    /* renamed from: e  reason: collision with root package name */
    public List<n> f62992e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public int f62993f = 1;

    /* renamed from: h  reason: collision with root package name */
    public d.b.c.c.g.a f62995h = new a(CmdConfigHttp.CMD_GET_HOT_GOD, 309315);
    public CustomMessageListener i = new C1656b(2016446);

    /* loaded from: classes4.dex */
    public class a extends d.b.c.c.g.a {
        public a(int i, int i2) {
            super(i, i2);
        }

        @Override // d.b.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (b.this.f62988a == null) {
                return;
            }
            if (responsedMessage instanceof GodSquareHttpResponsedMsg) {
                GodSquareHttpResponsedMsg godSquareHttpResponsedMsg = (GodSquareHttpResponsedMsg) responsedMessage;
                b.this.f62988a.a(b.this.f(godSquareHttpResponsedMsg.getResult()), b.this.f62990c, godSquareHttpResponsedMsg.getHasMore(), godSquareHttpResponsedMsg.getErrorString());
            } else if (responsedMessage instanceof GodSquareSocketResponsedMsg) {
                GodSquareSocketResponsedMsg godSquareSocketResponsedMsg = (GodSquareSocketResponsedMsg) responsedMessage;
                b.this.f62988a.a(b.this.f(godSquareSocketResponsedMsg.getResult()), b.this.f62990c, godSquareSocketResponsedMsg.getHasMore(), godSquareSocketResponsedMsg.getErrorString());
            }
        }
    }

    /* renamed from: d.b.i0.v0.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1656b extends CustomMessageListener {
        public C1656b(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (b.this.f62988a == null) {
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
                b.this.f62988a.a(b.this.f(godSquareCacheResponsedMsg.getResult()), b.this.f62990c, true, godSquareCacheResponsedMsg.getErrorString());
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface c {
        void a(List<n> list, boolean z, boolean z2, String str);
    }

    public b(c cVar, BaseActivity baseActivity) {
        this.f62988a = cVar;
        this.f62989b = baseActivity;
        k();
    }

    public final void e(List<User> list) {
        if (this.f62994g == null) {
            this.f62994g = new LongSparseArray<>();
        }
        for (User user : list) {
            h hVar = new h();
            MetaData metaData = new MetaData();
            hVar.f63786e = metaData;
            metaData.parserProtobuf(user);
            this.f62994g.put(user.id.longValue(), hVar.f63786e);
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
        if (!ListUtils.isEmpty(dataRes.recommend_uid_list) && this.f62990c) {
            for (Long l : dataRes.recommend_uid_list) {
                if (l != null && (metaData2 = this.f62994g.get(l.longValue())) != null) {
                    h hVar = new h();
                    hVar.f63786e = metaData2;
                    hVar.f63787f = 1;
                    arrayList2.add(hVar);
                }
            }
            if (this.f62989b != null && !ListUtils.isEmpty(arrayList2)) {
                e eVar = new e();
                eVar.f63808e = this.f62989b.getResources().getString(R.string.special_recommend);
                eVar.needTopMargin = false;
                arrayList2.add(0, eVar);
            }
            arrayList.addAll(arrayList2);
        }
        if (!ListUtils.isEmpty(dataRes.hot_uid_list)) {
            for (Long l2 : dataRes.hot_uid_list) {
                if (l2 != null && (metaData = this.f62994g.get(l2.longValue())) != null) {
                    h hVar2 = new h();
                    hVar2.f63786e = metaData;
                    hVar2.f63787f = 0;
                    hVar2.f63788g = this.f62993f;
                    arrayList3.add(hVar2);
                    this.f62993f++;
                }
            }
            if (this.f62989b != null && !ListUtils.isEmpty(arrayList3) && this.f62990c) {
                e eVar2 = new e();
                eVar2.f63808e = this.f62989b.getResources().getString(R.string.hot_god);
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
        LongSparseArray<MetaData> longSparseArray = this.f62994g;
        return (longSparseArray == null || longSparseArray.get(j) == null) ? false : true;
    }

    public final void h(int i) {
        if (this.f62989b == null) {
            return;
        }
        GodSquareCacheRequestMsg godSquareCacheRequestMsg = new GodSquareCacheRequestMsg();
        godSquareCacheRequestMsg.cacheKey = i + "";
        this.f62989b.sendMessage(godSquareCacheRequestMsg);
    }

    public final void i(int i) {
        if (this.f62989b == null) {
            return;
        }
        this.f62991d = i;
        GodSquareRequestMsg godSquareRequestMsg = new GodSquareRequestMsg();
        godSquareRequestMsg.pn = i;
        this.f62989b.sendMessage(godSquareRequestMsg);
    }

    public void j() {
        this.f62990c = false;
        i(this.f62991d + 1);
    }

    public final void k() {
        BaseActivity baseActivity = this.f62989b;
        if (baseActivity == null) {
            return;
        }
        baseActivity.registerListener(this.i);
        this.f62989b.registerListener(this.f62995h);
    }

    public void l() {
        this.f62993f = 1;
        this.f62990c = true;
        if (j.A()) {
            i(1);
        } else {
            h(1);
        }
    }
}

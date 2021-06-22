package d.a.o0.w0.c;

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
import d.a.c.k.e.n;
import d.a.o0.z.e0.h;
import d.a.o0.z.f0.e;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetHotGod.DataRes;
import tbclient.User;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public c f66309a;

    /* renamed from: b  reason: collision with root package name */
    public BaseActivity f66310b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f66311c;

    /* renamed from: g  reason: collision with root package name */
    public LongSparseArray<MetaData> f66315g;

    /* renamed from: d  reason: collision with root package name */
    public int f66312d = 0;

    /* renamed from: e  reason: collision with root package name */
    public List<n> f66313e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public int f66314f = 1;

    /* renamed from: h  reason: collision with root package name */
    public d.a.c.c.g.a f66316h = new a(CmdConfigHttp.CMD_GET_HOT_GOD, 309315);

    /* renamed from: i  reason: collision with root package name */
    public CustomMessageListener f66317i = new C1758b(2016446);

    /* loaded from: classes4.dex */
    public class a extends d.a.c.c.g.a {
        public a(int i2, int i3) {
            super(i2, i3);
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (b.this.f66309a == null) {
                return;
            }
            if (responsedMessage instanceof GodSquareHttpResponsedMsg) {
                GodSquareHttpResponsedMsg godSquareHttpResponsedMsg = (GodSquareHttpResponsedMsg) responsedMessage;
                b.this.f66309a.a(b.this.f(godSquareHttpResponsedMsg.getResult()), b.this.f66311c, godSquareHttpResponsedMsg.getHasMore(), godSquareHttpResponsedMsg.getErrorString());
            } else if (responsedMessage instanceof GodSquareSocketResponsedMsg) {
                GodSquareSocketResponsedMsg godSquareSocketResponsedMsg = (GodSquareSocketResponsedMsg) responsedMessage;
                b.this.f66309a.a(b.this.f(godSquareSocketResponsedMsg.getResult()), b.this.f66311c, godSquareSocketResponsedMsg.getHasMore(), godSquareSocketResponsedMsg.getErrorString());
            }
        }
    }

    /* renamed from: d.a.o0.w0.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1758b extends CustomMessageListener {
        public C1758b(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (b.this.f66309a == null) {
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
                b.this.f66309a.a(b.this.f(godSquareCacheResponsedMsg.getResult()), b.this.f66311c, true, godSquareCacheResponsedMsg.getErrorString());
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface c {
        void a(List<n> list, boolean z, boolean z2, String str);
    }

    public b(c cVar, BaseActivity baseActivity) {
        this.f66309a = cVar;
        this.f66310b = baseActivity;
        k();
    }

    public final void e(List<User> list) {
        if (this.f66315g == null) {
            this.f66315g = new LongSparseArray<>();
        }
        for (User user : list) {
            h hVar = new h();
            MetaData metaData = new MetaData();
            hVar.f67318e = metaData;
            metaData.parserProtobuf(user);
            this.f66315g.put(user.id.longValue(), hVar.f67318e);
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
        if (!ListUtils.isEmpty(dataRes.recommend_uid_list) && this.f66311c) {
            for (Long l : dataRes.recommend_uid_list) {
                if (l != null && (metaData2 = this.f66315g.get(l.longValue())) != null) {
                    h hVar = new h();
                    hVar.f67318e = metaData2;
                    hVar.f67319f = 1;
                    arrayList2.add(hVar);
                }
            }
            if (this.f66310b != null && !ListUtils.isEmpty(arrayList2)) {
                e eVar = new e();
                eVar.f67342e = this.f66310b.getResources().getString(R.string.special_recommend);
                eVar.needTopMargin = false;
                arrayList2.add(0, eVar);
            }
            arrayList.addAll(arrayList2);
        }
        if (!ListUtils.isEmpty(dataRes.hot_uid_list)) {
            for (Long l2 : dataRes.hot_uid_list) {
                if (l2 != null && (metaData = this.f66315g.get(l2.longValue())) != null) {
                    h hVar2 = new h();
                    hVar2.f67318e = metaData;
                    hVar2.f67319f = 0;
                    hVar2.f67320g = this.f66314f;
                    arrayList3.add(hVar2);
                    this.f66314f++;
                }
            }
            if (this.f66310b != null && !ListUtils.isEmpty(arrayList3) && this.f66311c) {
                e eVar2 = new e();
                eVar2.f67342e = this.f66310b.getResources().getString(R.string.hot_god);
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
        LongSparseArray<MetaData> longSparseArray = this.f66315g;
        return (longSparseArray == null || longSparseArray.get(j) == null) ? false : true;
    }

    public final void h(int i2) {
        if (this.f66310b == null) {
            return;
        }
        GodSquareCacheRequestMsg godSquareCacheRequestMsg = new GodSquareCacheRequestMsg();
        godSquareCacheRequestMsg.cacheKey = i2 + "";
        this.f66310b.sendMessage(godSquareCacheRequestMsg);
    }

    public final void i(int i2) {
        if (this.f66310b == null) {
            return;
        }
        this.f66312d = i2;
        GodSquareRequestMsg godSquareRequestMsg = new GodSquareRequestMsg();
        godSquareRequestMsg.pn = i2;
        this.f66310b.sendMessage(godSquareRequestMsg);
    }

    public void j() {
        this.f66311c = false;
        i(this.f66312d + 1);
    }

    public final void k() {
        BaseActivity baseActivity = this.f66310b;
        if (baseActivity == null) {
            return;
        }
        baseActivity.registerListener(this.f66317i);
        this.f66310b.registerListener(this.f66316h);
    }

    public void l() {
        this.f66314f = 1;
        this.f66311c = true;
        if (j.A()) {
            i(1);
        } else {
            h(1);
        }
    }
}

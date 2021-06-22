package d.a.o0.j0.h;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.enterForum.home.forumRecommendHttpResponseMessage;
import com.baidu.tieba.enterForum.home.forumRecommendSocketResponseMessage;
import com.baidu.tieba.enterForum.model.EnterForumModel;
import d.a.o0.d0.c;
import d.a.o0.j0.d.f;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class d implements d.a.o0.d0.c {

    /* renamed from: a  reason: collision with root package name */
    public EnterForumModel f59737a;

    /* renamed from: b  reason: collision with root package name */
    public c.a f59738b;

    /* renamed from: c  reason: collision with root package name */
    public final EnterForumModel.f f59739c = new a();

    /* renamed from: d  reason: collision with root package name */
    public d.a.c.c.g.a f59740d = new b(CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, 303011);

    /* loaded from: classes4.dex */
    public class a implements EnterForumModel.f {
        public a() {
        }

        @Override // com.baidu.tieba.enterForum.model.EnterForumModel.f
        public void a(EnterForumModel.e eVar) {
            d.a.o0.j0.d.d dVar;
            if (d.this.f59738b == null) {
                return;
            }
            if (eVar == null || !eVar.f14638b || (dVar = eVar.f14640d) == null || dVar.e() == null) {
                d.this.f59738b.a(null, false, 1, 0);
                return;
            }
            ArrayList<TransmitForumData> arrayList = new ArrayList<>();
            ArrayList<f> b2 = eVar.f14640d.e().b();
            if (ListUtils.getCount(b2) > 0) {
                Iterator<f> it = b2.iterator();
                while (it.hasNext()) {
                    f next = it.next();
                    if (next != null && !StringUtils.isNull(next.D()) && !StringUtils.isNull(next.G())) {
                        TransmitForumData transmitForumData = new TransmitForumData(Long.valueOf(next.D()).longValue(), next.G(), false, 1, next.B());
                        transmitForumData.tabItemDatas = next.I();
                        arrayList.add(transmitForumData);
                    }
                }
            }
            d.this.f59738b.a(arrayList, true, 1, 0);
        }
    }

    /* loaded from: classes4.dex */
    public class b extends d.a.c.c.g.a {
        public b(int i2, int i3) {
            super(i2, i3);
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            boolean z = responsedMessage instanceof forumRecommendSocketResponseMessage;
            if ((z || (responsedMessage instanceof forumRecommendHttpResponseMessage)) && d.this.f59737a.getUniqueId() == responsedMessage.getOrginalMessage().getTag() && !responsedMessage.hasError()) {
                if (z) {
                    d.this.f59737a.N((forumRecommendSocketResponseMessage) responsedMessage);
                }
                if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    d.this.f59737a.M((forumRecommendHttpResponseMessage) responsedMessage);
                }
            }
        }
    }

    public d() {
        this.f59737a = null;
        EnterForumModel enterForumModel = new EnterForumModel(null);
        this.f59737a = enterForumModel;
        enterForumModel.T(this.f59739c);
        MessageManager.getInstance().registerListener(this.f59740d);
    }

    @Override // d.a.o0.d0.c
    public void a(c.a aVar) {
        this.f59738b = aVar;
    }

    @Override // d.a.o0.d0.c
    public void b() {
        EnterForumModel enterForumModel;
        if (this.f59738b == null || (enterForumModel = this.f59737a) == null) {
            return;
        }
        enterForumModel.H(true);
    }
}

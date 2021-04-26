package d.a.j0.i0.h;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.enterForum.home.forumRecommendHttpResponseMessage;
import com.baidu.tieba.enterForum.home.forumRecommendSocketResponseMessage;
import com.baidu.tieba.enterForum.model.EnterForumModel;
import d.a.j0.b0.c;
import d.a.j0.i0.d.f;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class d implements d.a.j0.b0.c {

    /* renamed from: a  reason: collision with root package name */
    public EnterForumModel f55032a;

    /* renamed from: b  reason: collision with root package name */
    public c.a f55033b;

    /* renamed from: c  reason: collision with root package name */
    public final EnterForumModel.f f55034c = new a();

    /* renamed from: d  reason: collision with root package name */
    public d.a.c.c.g.a f55035d = new b(CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, 303011);

    /* loaded from: classes4.dex */
    public class a implements EnterForumModel.f {
        public a() {
        }

        @Override // com.baidu.tieba.enterForum.model.EnterForumModel.f
        public void a(EnterForumModel.e eVar) {
            d.a.j0.i0.d.d dVar;
            if (d.this.f55033b == null) {
                return;
            }
            if (eVar == null || !eVar.f15281b || (dVar = eVar.f15283d) == null || dVar.e() == null) {
                d.this.f55033b.a(null, false, 1, 0);
                return;
            }
            ArrayList<TransmitForumData> arrayList = new ArrayList<>();
            ArrayList<f> b2 = eVar.f15283d.e().b();
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
            d.this.f55033b.a(arrayList, true, 1, 0);
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
            if ((z || (responsedMessage instanceof forumRecommendHttpResponseMessage)) && d.this.f55032a.getUniqueId() == responsedMessage.getOrginalMessage().getTag() && !responsedMessage.hasError()) {
                if (z) {
                    d.this.f55032a.J((forumRecommendSocketResponseMessage) responsedMessage);
                }
                if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    d.this.f55032a.I((forumRecommendHttpResponseMessage) responsedMessage);
                }
            }
        }
    }

    public d() {
        this.f55032a = null;
        EnterForumModel enterForumModel = new EnterForumModel(null);
        this.f55032a = enterForumModel;
        enterForumModel.P(this.f55034c);
        MessageManager.getInstance().registerListener(this.f55035d);
    }

    @Override // d.a.j0.b0.c
    public void a(c.a aVar) {
        this.f55033b = aVar;
    }

    @Override // d.a.j0.b0.c
    public void b() {
        EnterForumModel enterForumModel;
        if (this.f55033b == null || (enterForumModel = this.f55032a) == null) {
            return;
        }
        enterForumModel.D(true);
    }
}

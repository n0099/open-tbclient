package d.b.i0.n0.d.a;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.forumMember.tbtitle.model.cache.GetLevelInfoReadCacheResponsedMessage;
import com.baidu.tieba.forumMember.tbtitle.model.req.GetLevelInfoReadCacheRequestMessage;
import com.baidu.tieba.forumMember.tbtitle.model.req.GetLevelInfoRequestMessage;
import com.baidu.tieba.forumMember.tbtitle.model.res.GetLevelInfoHttpResponsedMessage;
import com.baidu.tieba.forumMember.tbtitle.model.res.GetLevelInfoSocketResponsedMessage;
import tbclient.GetLevelInfo.DataRes;
/* loaded from: classes4.dex */
public class a<T> {

    /* renamed from: a  reason: collision with root package name */
    public c f57066a;

    /* renamed from: b  reason: collision with root package name */
    public BaseActivity<T> f57067b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.b.c.g.a f57068c = new C1353a(CmdConfigHttp.CMD_GET_LEVLE_INFO, 301005);

    /* renamed from: d  reason: collision with root package name */
    public CustomMessageListener f57069d = new b(2003007);

    /* renamed from: d.b.i0.n0.d.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1353a extends d.b.b.c.g.a {
        public C1353a(int i, int i2) {
            super(i, i2);
        }

        @Override // d.b.b.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage instanceof GetLevelInfoHttpResponsedMessage) {
                GetLevelInfoHttpResponsedMessage getLevelInfoHttpResponsedMessage = (GetLevelInfoHttpResponsedMessage) responsedMessage;
                a.this.f57066a.a(getLevelInfoHttpResponsedMessage.getResult(), true, getLevelInfoHttpResponsedMessage.getError(), getLevelInfoHttpResponsedMessage.getErrorString());
            } else if (responsedMessage instanceof GetLevelInfoSocketResponsedMessage) {
                GetLevelInfoSocketResponsedMessage getLevelInfoSocketResponsedMessage = (GetLevelInfoSocketResponsedMessage) responsedMessage;
                a.this.f57066a.a(getLevelInfoSocketResponsedMessage.getmResult(), true, getLevelInfoSocketResponsedMessage.getError(), getLevelInfoSocketResponsedMessage.getErrorString());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public b(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage instanceof GetLevelInfoReadCacheResponsedMessage)) {
                return;
            }
            GetLevelInfoReadCacheResponsedMessage getLevelInfoReadCacheResponsedMessage = (GetLevelInfoReadCacheResponsedMessage) customResponsedMessage;
            a.this.f57066a.a(getLevelInfoReadCacheResponsedMessage.getResult(), false, getLevelInfoReadCacheResponsedMessage.getError(), getLevelInfoReadCacheResponsedMessage.getErrorString());
        }
    }

    /* loaded from: classes4.dex */
    public interface c {
        void a(DataRes dataRes, boolean z, int i, String str);
    }

    public a(c cVar, BaseActivity<T> baseActivity) {
        this.f57066a = cVar;
        this.f57067b = baseActivity;
        b();
    }

    public final void b() {
        this.f57067b.registerListener(this.f57069d);
        this.f57067b.registerListener(this.f57068c);
    }

    public void c(int i) {
        GetLevelInfoReadCacheRequestMessage getLevelInfoReadCacheRequestMessage = new GetLevelInfoReadCacheRequestMessage();
        getLevelInfoReadCacheRequestMessage.setCacheKey("" + i);
        this.f57067b.sendMessage(getLevelInfoReadCacheRequestMessage);
    }

    public void d(int i) {
        GetLevelInfoRequestMessage getLevelInfoRequestMessage = new GetLevelInfoRequestMessage();
        getLevelInfoRequestMessage.setForumId(i);
        this.f57067b.sendMessage(getLevelInfoRequestMessage);
    }
}

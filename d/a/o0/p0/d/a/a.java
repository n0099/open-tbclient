package d.a.o0.p0.d.a;

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
    public c f61847a;

    /* renamed from: b  reason: collision with root package name */
    public BaseActivity<T> f61848b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.c.c.g.a f61849c = new C1522a(CmdConfigHttp.CMD_GET_LEVLE_INFO, 301005);

    /* renamed from: d  reason: collision with root package name */
    public CustomMessageListener f61850d = new b(2003007);

    /* renamed from: d.a.o0.p0.d.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1522a extends d.a.c.c.g.a {
        public C1522a(int i2, int i3) {
            super(i2, i3);
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage instanceof GetLevelInfoHttpResponsedMessage) {
                GetLevelInfoHttpResponsedMessage getLevelInfoHttpResponsedMessage = (GetLevelInfoHttpResponsedMessage) responsedMessage;
                a.this.f61847a.a(getLevelInfoHttpResponsedMessage.getResult(), true, getLevelInfoHttpResponsedMessage.getError(), getLevelInfoHttpResponsedMessage.getErrorString());
            } else if (responsedMessage instanceof GetLevelInfoSocketResponsedMessage) {
                GetLevelInfoSocketResponsedMessage getLevelInfoSocketResponsedMessage = (GetLevelInfoSocketResponsedMessage) responsedMessage;
                a.this.f61847a.a(getLevelInfoSocketResponsedMessage.getmResult(), true, getLevelInfoSocketResponsedMessage.getError(), getLevelInfoSocketResponsedMessage.getErrorString());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public b(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage instanceof GetLevelInfoReadCacheResponsedMessage)) {
                return;
            }
            GetLevelInfoReadCacheResponsedMessage getLevelInfoReadCacheResponsedMessage = (GetLevelInfoReadCacheResponsedMessage) customResponsedMessage;
            a.this.f61847a.a(getLevelInfoReadCacheResponsedMessage.getResult(), false, getLevelInfoReadCacheResponsedMessage.getError(), getLevelInfoReadCacheResponsedMessage.getErrorString());
        }
    }

    /* loaded from: classes4.dex */
    public interface c {
        void a(DataRes dataRes, boolean z, int i2, String str);
    }

    public a(c cVar, BaseActivity<T> baseActivity) {
        this.f61847a = cVar;
        this.f61848b = baseActivity;
        b();
    }

    public final void b() {
        this.f61848b.registerListener(this.f61850d);
        this.f61848b.registerListener(this.f61849c);
    }

    public void c(int i2) {
        GetLevelInfoReadCacheRequestMessage getLevelInfoReadCacheRequestMessage = new GetLevelInfoReadCacheRequestMessage();
        getLevelInfoReadCacheRequestMessage.setCacheKey("" + i2);
        this.f61848b.sendMessage(getLevelInfoReadCacheRequestMessage);
    }

    public void d(int i2) {
        GetLevelInfoRequestMessage getLevelInfoRequestMessage = new GetLevelInfoRequestMessage();
        getLevelInfoRequestMessage.setForumId(i2);
        this.f61848b.sendMessage(getLevelInfoRequestMessage);
    }
}

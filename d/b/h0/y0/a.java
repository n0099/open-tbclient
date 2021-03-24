package d.b.h0.y0;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.trackConfig.TrackConfigResponseMessage;
import d.b.b.e.n.f;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public b f51645a;

    /* renamed from: b  reason: collision with root package name */
    public HttpMessageListener f51646b = new C1114a(CmdConfigHttp.CMD_TRACK_CONFIG);

    /* renamed from: d.b.h0.y0.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1114a extends HttpMessageListener {
        public C1114a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof TrackConfigResponseMessage) {
                TrackConfigResponseMessage trackConfigResponseMessage = (TrackConfigResponseMessage) httpResponsedMessage;
                if (a.this.f51645a != null) {
                    a.this.f51645a.a(trackConfigResponseMessage.isSuccess(), trackConfigResponseMessage.getData());
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(boolean z, boolean z2);
    }

    public a() {
        MessageManager.getInstance().registerListener(this.f51646b);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_TRACK_CONFIG, TbConfig.SERVER_ADDRESS + TbConfig.GET_TRACK_CONFIG);
        tbHttpMessageTask.setResponsedClass(TrackConfigResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        f.h(TbSingleton.getInstance().isIsOpenTrack());
    }

    public void b(b bVar) {
        this.f51645a = bVar;
    }

    public void c() {
        MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.CMD_TRACK_CONFIG));
    }
}

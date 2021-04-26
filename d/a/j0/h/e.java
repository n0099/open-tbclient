package d.a.j0.h;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.tieba.deletethread.DeleteThreadHttpResponseMessage;
import d.a.c.e.p.j;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public HttpMessageListener f54716a;

    /* renamed from: b  reason: collision with root package name */
    public c f54717b = null;

    /* renamed from: c  reason: collision with root package name */
    public CustomMessageListener f54718c = new a(2016489);

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof JSONObject)) {
                return;
            }
            e.this.c((JSONObject) customResponsedMessage.getData());
        }
    }

    /* loaded from: classes4.dex */
    public class b extends HttpMessageListener {
        public b(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003185 && (httpResponsedMessage instanceof DeleteThreadHttpResponseMessage) && httpResponsedMessage.isSuccess() && e.this.f54717b != null) {
                e.this.f54717b.a((DeleteThreadHttpResponseMessage) httpResponsedMessage);
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface c {
        void a(DeleteThreadHttpResponseMessage deleteThreadHttpResponseMessage);
    }

    public e(String str) {
        if (this.f54716a == null) {
            this.f54716a = new b(CmdConfigHttp.CMD_NEG_DELETE_THREAD);
        }
        MessageManager.getInstance().registerListener(this.f54716a);
        MessageManager.getInstance().registerListener(this.f54718c);
    }

    public final void c(JSONObject jSONObject) {
        if (jSONObject != null && j.A()) {
            try {
                int i2 = jSONObject.getInt("type");
                String JsonArrayToString = StringHelper.JsonArrayToString(jSONObject.getJSONArray("thread_ids"));
                String JsonArrayToString2 = StringHelper.JsonArrayToString(jSONObject.getJSONArray("reason"));
                String string = jSONObject.getString("forum_id");
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_NEG_DELETE_THREAD);
                httpMessage.addParam("type", i2);
                httpMessage.addParam("thread_ids", JsonArrayToString);
                httpMessage.addParam("reason", JsonArrayToString2);
                httpMessage.addParam("forum_id", string);
                httpMessage.addParam(HttpRequest.TBS, TbadkCoreApplication.getInst().getTbs());
                MessageManager.getInstance().sendMessage(httpMessage);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void d() {
        MessageManager.getInstance().unRegisterListener(this.f54718c);
        MessageManager.getInstance().unRegisterListener(this.f54716a);
    }

    public void e() {
        MessageManager.getInstance().registerListener(this.f54716a);
        MessageManager.getInstance().registerListener(this.f54718c);
    }

    public void f(c cVar) {
        this.f54717b = cVar;
    }
}

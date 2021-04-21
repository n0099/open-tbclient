package d.b.j0.o.b;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.ad.asyncpv.AdAsyncRequestData;
import com.baidu.tieba.ad.asyncpv.AdAsyncResponseData;
import com.baidu.tieba.recapp.constants.PlaceId;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public PlaceId f59030a;

    /* renamed from: b  reason: collision with root package name */
    public InterfaceC1432b f59031b;

    /* renamed from: c  reason: collision with root package name */
    public HttpMessageListener f59032c = new a(CmdConfigHttp.CMD_AD_ASYNC_BATCH_REQUEST);

    /* loaded from: classes4.dex */
    public class a extends HttpMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if ((httpResponsedMessage instanceof AdAsyncResponseData) && httpResponsedMessage.getCmd() == 1003491) {
                AdAsyncResponseData adAsyncResponseData = (AdAsyncResponseData) httpResponsedMessage;
                if (b.this.f59031b != null) {
                    b.this.f59031b.a(adAsyncResponseData.isSuccess(), adAsyncResponseData.getAds());
                }
            }
        }
    }

    /* renamed from: d.b.j0.o.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC1432b {
        void a(boolean z, List<AdvertAppInfo> list);
    }

    public b(InterfaceC1432b interfaceC1432b, PlaceId placeId) {
        this.f59030a = placeId;
        this.f59031b = interfaceC1432b;
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_AD_ASYNC_BATCH_REQUEST, TbConfig.SERVER_ADDRESS + "tiebaads/commonbatch");
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsNeedAddStatisticsParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setmIsNBaiduServer(false);
        tbHttpMessageTask.setResponsedClass(AdAsyncResponseData.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().registerListener(this.f59032c);
    }

    public void b() {
        MessageManager.getInstance().unRegisterListener(this.f59032c);
    }

    public void c(Map<String, String> map, int i) {
        MessageManager.getInstance().sendMessage(new AdAsyncRequestData(this.f59030a, map, i));
    }
}

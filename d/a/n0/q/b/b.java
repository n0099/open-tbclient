package d.a.n0.q.b;

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
    public PlaceId f58176a;

    /* renamed from: b  reason: collision with root package name */
    public InterfaceC1472b f58177b;

    /* renamed from: c  reason: collision with root package name */
    public HttpMessageListener f58178c = new a(CmdConfigHttp.CMD_AD_ASYNC_BATCH_REQUEST);

    /* loaded from: classes4.dex */
    public class a extends HttpMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if ((httpResponsedMessage instanceof AdAsyncResponseData) && httpResponsedMessage.getCmd() == 1003491) {
                AdAsyncResponseData adAsyncResponseData = (AdAsyncResponseData) httpResponsedMessage;
                if (b.this.f58177b != null) {
                    b.this.f58177b.a(adAsyncResponseData.isSuccess(), adAsyncResponseData.getAds());
                }
            }
        }
    }

    /* renamed from: d.a.n0.q.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC1472b {
        void a(boolean z, List<AdvertAppInfo> list);
    }

    public b(InterfaceC1472b interfaceC1472b, PlaceId placeId) {
        this.f58176a = placeId;
        this.f58177b = interfaceC1472b;
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_AD_ASYNC_BATCH_REQUEST, TbConfig.SERVER_ADDRESS + "tiebaads/commonbatch");
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsNeedAddStatisticsParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setmIsNBaiduServer(false);
        tbHttpMessageTask.setResponsedClass(AdAsyncResponseData.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().registerListener(this.f58178c);
    }

    public void b() {
        MessageManager.getInstance().unRegisterListener(this.f58178c);
    }

    public void c(Map<String, String> map, int i2) {
        MessageManager.getInstance().sendMessage(new AdAsyncRequestData(this.f58176a, map, i2));
    }
}

package d.b.i0.t.j.g.d;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.ala.downloader.ResourceDownloader;
import com.baidu.ala.gift.AlaDynamicGift;
import com.baidu.ala.gift.AlaDynamicGiftLocalInfoConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.ala.personcenter.privilege.entereffect.AlaGetEnterEffectResponsedMessage;
import com.baidu.tieba.ala.personcenter.privilege.entereffect.data.AlaEnterEffectData;
import d.b.b.j.e.n;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f60945a;

    /* renamed from: b  reason: collision with root package name */
    public b f60946b;

    /* renamed from: c  reason: collision with root package name */
    public BdAsyncTask f60947c;

    /* renamed from: d  reason: collision with root package name */
    public HttpMessageListener f60948d;

    /* renamed from: d.b.i0.t.j.g.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1574a extends HttpMessageListener {

        /* renamed from: d.b.i0.t.j.g.d.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C1575a extends BdAsyncTask {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ List f60950a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ HttpResponsedMessage f60951b;

            public C1575a(List list, HttpResponsedMessage httpResponsedMessage) {
                this.f60950a = list;
                this.f60951b = httpResponsedMessage;
            }

            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Object doInBackground(Object[] objArr) {
                AlaDynamicGift alaDynamicGift;
                for (n nVar : this.f60950a) {
                    if (nVar instanceof AlaEnterEffectData) {
                        AlaEnterEffectData alaEnterEffectData = (AlaEnterEffectData) nVar;
                        if (alaEnterEffectData.type == 1 && (alaDynamicGift = alaEnterEffectData.gift) != null && alaDynamicGift.giftZip != null) {
                            if (ResourceDownloader.checkDirNeedToDownload(AlaDynamicGiftLocalInfoConfig.DIR_PATH + alaEnterEffectData.gift.giftZip.zipName, AlaDynamicGiftLocalInfoConfig.PIC_MD5_PREFIX + alaEnterEffectData.gift.giftName)) {
                                alaEnterEffectData.downLoadStatus = 100;
                            } else {
                                alaEnterEffectData.downLoadStatus = 101;
                            }
                        }
                    }
                }
                return null;
            }

            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public void onCancelled() {
                super.onCancelled();
                a.this.f60946b.a((AlaGetEnterEffectResponsedMessage) this.f60951b);
            }

            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public void onPostExecute(Object obj) {
                super.onPostExecute(obj);
                a.this.f60946b.a((AlaGetEnterEffectResponsedMessage) this.f60951b);
            }
        }

        public C1574a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof AlaGetEnterEffectResponsedMessage) {
                AlaGetEnterEffectResponsedMessage alaGetEnterEffectResponsedMessage = (AlaGetEnterEffectResponsedMessage) httpResponsedMessage;
                List<n> effectList = alaGetEnterEffectResponsedMessage.getEffectList();
                if (ListUtils.isEmpty(effectList)) {
                    a.this.f60946b.a(alaGetEnterEffectResponsedMessage);
                    return;
                }
                a.this.f60947c = new C1575a(effectList, httpResponsedMessage).execute(new Object[0]);
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(AlaGetEnterEffectResponsedMessage alaGetEnterEffectResponsedMessage);
    }

    public a(TbPageContext tbPageContext, b bVar) {
        C1574a c1574a = new C1574a(AlaCmdConfigHttp.CMD_ALA_GET_ENTER_EFFECT);
        this.f60948d = c1574a;
        this.f60945a = tbPageContext;
        this.f60946b = bVar;
        tbPageContext.registerListener(c1574a);
    }

    public void c() {
        BdAsyncTask bdAsyncTask = this.f60947c;
        if (bdAsyncTask != null) {
            bdAsyncTask.cancel();
        }
    }

    public void d() {
        HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_GET_ENTER_EFFECT);
        httpMessage.addParam("user_id", TbadkCoreApplication.getCurrentAccount());
        this.f60945a.sendMessage(httpMessage);
    }
}

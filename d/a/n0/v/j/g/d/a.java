package d.a.n0.v.j.g.d;

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
import d.a.c.j.e.n;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f62145a;

    /* renamed from: b  reason: collision with root package name */
    public b f62146b;

    /* renamed from: c  reason: collision with root package name */
    public BdAsyncTask f62147c;

    /* renamed from: d  reason: collision with root package name */
    public HttpMessageListener f62148d;

    /* renamed from: d.a.n0.v.j.g.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1675a extends HttpMessageListener {

        /* renamed from: d.a.n0.v.j.g.d.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C1676a extends BdAsyncTask {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ List f62150a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ HttpResponsedMessage f62151b;

            public C1676a(List list, HttpResponsedMessage httpResponsedMessage) {
                this.f62150a = list;
                this.f62151b = httpResponsedMessage;
            }

            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Object doInBackground(Object[] objArr) {
                AlaDynamicGift alaDynamicGift;
                for (n nVar : this.f62150a) {
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
                a.this.f62146b.a((AlaGetEnterEffectResponsedMessage) this.f62151b);
            }

            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public void onPostExecute(Object obj) {
                super.onPostExecute(obj);
                a.this.f62146b.a((AlaGetEnterEffectResponsedMessage) this.f62151b);
            }
        }

        public C1675a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof AlaGetEnterEffectResponsedMessage) {
                AlaGetEnterEffectResponsedMessage alaGetEnterEffectResponsedMessage = (AlaGetEnterEffectResponsedMessage) httpResponsedMessage;
                List<n> effectList = alaGetEnterEffectResponsedMessage.getEffectList();
                if (ListUtils.isEmpty(effectList)) {
                    a.this.f62146b.a(alaGetEnterEffectResponsedMessage);
                    return;
                }
                a.this.f62147c = new C1676a(effectList, httpResponsedMessage).execute(new Object[0]);
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(AlaGetEnterEffectResponsedMessage alaGetEnterEffectResponsedMessage);
    }

    public a(TbPageContext tbPageContext, b bVar) {
        C1675a c1675a = new C1675a(AlaCmdConfigHttp.CMD_ALA_GET_ENTER_EFFECT);
        this.f62148d = c1675a;
        this.f62145a = tbPageContext;
        this.f62146b = bVar;
        tbPageContext.registerListener(c1675a);
    }

    public void c() {
        BdAsyncTask bdAsyncTask = this.f62147c;
        if (bdAsyncTask != null) {
            bdAsyncTask.cancel();
        }
    }

    public void d() {
        HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_GET_ENTER_EFFECT);
        httpMessage.addParam("user_id", TbadkCoreApplication.getCurrentAccount());
        this.f62145a.sendMessage(httpMessage);
    }
}

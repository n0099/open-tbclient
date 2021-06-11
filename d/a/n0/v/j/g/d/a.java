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
import d.a.c.k.e.n;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f65860a;

    /* renamed from: b  reason: collision with root package name */
    public b f65861b;

    /* renamed from: c  reason: collision with root package name */
    public BdAsyncTask f65862c;

    /* renamed from: d  reason: collision with root package name */
    public HttpMessageListener f65863d;

    /* renamed from: d.a.n0.v.j.g.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1732a extends HttpMessageListener {

        /* renamed from: d.a.n0.v.j.g.d.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C1733a extends BdAsyncTask {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ List f65865a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ HttpResponsedMessage f65866b;

            public C1733a(List list, HttpResponsedMessage httpResponsedMessage) {
                this.f65865a = list;
                this.f65866b = httpResponsedMessage;
            }

            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Object doInBackground(Object[] objArr) {
                AlaDynamicGift alaDynamicGift;
                for (n nVar : this.f65865a) {
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
                a.this.f65861b.a((AlaGetEnterEffectResponsedMessage) this.f65866b);
            }

            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public void onPostExecute(Object obj) {
                super.onPostExecute(obj);
                a.this.f65861b.a((AlaGetEnterEffectResponsedMessage) this.f65866b);
            }
        }

        public C1732a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof AlaGetEnterEffectResponsedMessage) {
                AlaGetEnterEffectResponsedMessage alaGetEnterEffectResponsedMessage = (AlaGetEnterEffectResponsedMessage) httpResponsedMessage;
                List<n> effectList = alaGetEnterEffectResponsedMessage.getEffectList();
                if (ListUtils.isEmpty(effectList)) {
                    a.this.f65861b.a(alaGetEnterEffectResponsedMessage);
                    return;
                }
                a.this.f65862c = new C1733a(effectList, httpResponsedMessage).execute(new Object[0]);
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(AlaGetEnterEffectResponsedMessage alaGetEnterEffectResponsedMessage);
    }

    public a(TbPageContext tbPageContext, b bVar) {
        C1732a c1732a = new C1732a(AlaCmdConfigHttp.CMD_ALA_GET_ENTER_EFFECT);
        this.f65863d = c1732a;
        this.f65860a = tbPageContext;
        this.f65861b = bVar;
        tbPageContext.registerListener(c1732a);
    }

    public void c() {
        BdAsyncTask bdAsyncTask = this.f65862c;
        if (bdAsyncTask != null) {
            bdAsyncTask.cancel();
        }
    }

    public void d() {
        HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_GET_ENTER_EFFECT);
        httpMessage.addParam("user_id", TbadkCoreApplication.getCurrentAccount());
        this.f65860a.sendMessage(httpMessage);
    }
}

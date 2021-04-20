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
import d.b.c.j.e.n;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f62509a;

    /* renamed from: b  reason: collision with root package name */
    public b f62510b;

    /* renamed from: c  reason: collision with root package name */
    public BdAsyncTask f62511c;

    /* renamed from: d  reason: collision with root package name */
    public HttpMessageListener f62512d;

    /* renamed from: d.b.i0.t.j.g.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1627a extends HttpMessageListener {

        /* renamed from: d.b.i0.t.j.g.d.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C1628a extends BdAsyncTask {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ List f62514a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ HttpResponsedMessage f62515b;

            public C1628a(List list, HttpResponsedMessage httpResponsedMessage) {
                this.f62514a = list;
                this.f62515b = httpResponsedMessage;
            }

            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Object doInBackground(Object[] objArr) {
                AlaDynamicGift alaDynamicGift;
                for (n nVar : this.f62514a) {
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
                a.this.f62510b.a((AlaGetEnterEffectResponsedMessage) this.f62515b);
            }

            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public void onPostExecute(Object obj) {
                super.onPostExecute(obj);
                a.this.f62510b.a((AlaGetEnterEffectResponsedMessage) this.f62515b);
            }
        }

        public C1627a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof AlaGetEnterEffectResponsedMessage) {
                AlaGetEnterEffectResponsedMessage alaGetEnterEffectResponsedMessage = (AlaGetEnterEffectResponsedMessage) httpResponsedMessage;
                List<n> effectList = alaGetEnterEffectResponsedMessage.getEffectList();
                if (ListUtils.isEmpty(effectList)) {
                    a.this.f62510b.a(alaGetEnterEffectResponsedMessage);
                    return;
                }
                a.this.f62511c = new C1628a(effectList, httpResponsedMessage).execute(new Object[0]);
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(AlaGetEnterEffectResponsedMessage alaGetEnterEffectResponsedMessage);
    }

    public a(TbPageContext tbPageContext, b bVar) {
        C1627a c1627a = new C1627a(AlaCmdConfigHttp.CMD_ALA_GET_ENTER_EFFECT);
        this.f62512d = c1627a;
        this.f62509a = tbPageContext;
        this.f62510b = bVar;
        tbPageContext.registerListener(c1627a);
    }

    public void c() {
        BdAsyncTask bdAsyncTask = this.f62511c;
        if (bdAsyncTask != null) {
            bdAsyncTask.cancel();
        }
    }

    public void d() {
        HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_GET_ENTER_EFFECT);
        httpMessage.addParam("user_id", TbadkCoreApplication.getCurrentAccount());
        this.f62509a.sendMessage(httpMessage);
    }
}

package d.a.n0.i2;

import android.app.Activity;
import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import d.a.m0.r.s.j;
import d.a.m0.r.s.l;
import java.util.ArrayList;
import java.util.List;
import tbclient.SmartApp;
/* loaded from: classes5.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f59442a;

    /* renamed from: b  reason: collision with root package name */
    public Context f59443b;

    /* renamed from: c  reason: collision with root package name */
    public j f59444c;

    /* renamed from: d  reason: collision with root package name */
    public l f59445d;

    /* renamed from: e  reason: collision with root package name */
    public List<d.a.m0.r.s.h> f59446e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.m0.r.s.h f59447f;

    /* renamed from: g  reason: collision with root package name */
    public b f59448g;

    /* renamed from: h  reason: collision with root package name */
    public SmartApp f59449h;

    /* renamed from: i  reason: collision with root package name */
    public l.d f59450i = new a();

    /* loaded from: classes5.dex */
    public class a implements l.d {
        public a() {
        }

        @Override // d.a.m0.r.s.l.d
        public void onClick() {
            if (i.this.f59449h == null) {
                return;
            }
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SMART_APP_DEL_BROWSE_HISTORY);
            httpMessage.addParam("swan_app_key", i.this.f59449h.id);
            MessageManager.getInstance().sendMessage(httpMessage);
            if (i.this.f59448g != null) {
                i.this.f59448g.a(i.this.f59449h.id);
            }
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SMART_APP_HISTORY_DELETE_CLICK);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_id", i.this.f59449h.swan_app_id.longValue());
            statisticItem.param("obj_name", i.this.f59449h.name);
            TiebaStatic.log(statisticItem);
            if (i.this.f59444c != null) {
                i.this.f59444c.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a(String str);
    }

    static {
        MessageManager.getInstance().registerTask(new TbHttpMessageTask(CmdConfigHttp.CMD_SMART_APP_DEL_BROWSE_HISTORY, TbConfig.SERVER_ADDRESS + TbConfig.URL_SMART_APP_DEL_BROWSE_HISTORY));
    }

    public i(TbPageContext tbPageContext) {
        this.f59442a = tbPageContext;
        Activity pageActivity = tbPageContext.getPageActivity();
        this.f59443b = pageActivity;
        this.f59445d = new l(pageActivity);
        this.f59446e = new ArrayList();
    }

    public void d(SmartApp smartApp) {
        this.f59449h = smartApp;
    }

    public void e() {
        if (this.f59444c != null) {
            return;
        }
        d.a.m0.r.s.h hVar = new d.a.m0.r.s.h(this.f59443b.getString(R.string.delete), this.f59445d);
        this.f59447f = hVar;
        hVar.m(this.f59450i);
        this.f59446e.add(this.f59447f);
        this.f59445d.k(this.f59446e);
        this.f59444c = new j(this.f59442a, this.f59445d);
    }

    public void f(b bVar) {
        this.f59448g = bVar;
    }

    public void g() {
        j jVar = this.f59444c;
        if (jVar == null) {
            return;
        }
        jVar.l();
    }
}

package d.b.i0.g2;

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
import d.b.h0.r.s.j;
import d.b.h0.r.s.l;
import java.util.ArrayList;
import java.util.List;
import tbclient.SmartApp;
/* loaded from: classes5.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f54984a;

    /* renamed from: b  reason: collision with root package name */
    public Context f54985b;

    /* renamed from: c  reason: collision with root package name */
    public j f54986c;

    /* renamed from: d  reason: collision with root package name */
    public l f54987d;

    /* renamed from: e  reason: collision with root package name */
    public List<d.b.h0.r.s.h> f54988e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.h0.r.s.h f54989f;

    /* renamed from: g  reason: collision with root package name */
    public b f54990g;

    /* renamed from: h  reason: collision with root package name */
    public SmartApp f54991h;
    public l.d i = new a();

    /* loaded from: classes5.dex */
    public class a implements l.d {
        public a() {
        }

        @Override // d.b.h0.r.s.l.d
        public void onClick() {
            if (i.this.f54991h == null) {
                return;
            }
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SMART_APP_DEL_BROWSE_HISTORY);
            httpMessage.addParam("swan_app_key", i.this.f54991h.id);
            MessageManager.getInstance().sendMessage(httpMessage);
            if (i.this.f54990g != null) {
                i.this.f54990g.a(i.this.f54991h.id);
            }
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SMART_APP_HISTORY_DELETE_CLICK);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_id", i.this.f54991h.swan_app_id.longValue());
            statisticItem.param("obj_name", i.this.f54991h.name);
            TiebaStatic.log(statisticItem);
            if (i.this.f54986c != null) {
                i.this.f54986c.dismiss();
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
        this.f54984a = tbPageContext;
        Activity pageActivity = tbPageContext.getPageActivity();
        this.f54985b = pageActivity;
        this.f54987d = new l(pageActivity);
        this.f54988e = new ArrayList();
    }

    public void d(SmartApp smartApp) {
        this.f54991h = smartApp;
    }

    public void e() {
        if (this.f54986c != null) {
            return;
        }
        d.b.h0.r.s.h hVar = new d.b.h0.r.s.h(this.f54985b.getString(R.string.delete), this.f54987d);
        this.f54989f = hVar;
        hVar.m(this.i);
        this.f54988e.add(this.f54989f);
        this.f54987d.k(this.f54988e);
        this.f54986c = new j(this.f54984a, this.f54987d);
    }

    public void f(b bVar) {
        this.f54990g = bVar;
    }

    public void g() {
        j jVar = this.f54986c;
        if (jVar == null) {
            return;
        }
        jVar.l();
    }
}

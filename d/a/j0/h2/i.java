package d.a.j0.h2;

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
import d.a.i0.r.s.j;
import d.a.i0.r.s.l;
import java.util.ArrayList;
import java.util.List;
import tbclient.SmartApp;
/* loaded from: classes4.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f54858a;

    /* renamed from: b  reason: collision with root package name */
    public Context f54859b;

    /* renamed from: c  reason: collision with root package name */
    public j f54860c;

    /* renamed from: d  reason: collision with root package name */
    public l f54861d;

    /* renamed from: e  reason: collision with root package name */
    public List<d.a.i0.r.s.h> f54862e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.i0.r.s.h f54863f;

    /* renamed from: g  reason: collision with root package name */
    public b f54864g;

    /* renamed from: h  reason: collision with root package name */
    public SmartApp f54865h;

    /* renamed from: i  reason: collision with root package name */
    public l.d f54866i = new a();

    /* loaded from: classes4.dex */
    public class a implements l.d {
        public a() {
        }

        @Override // d.a.i0.r.s.l.d
        public void onClick() {
            if (i.this.f54865h == null) {
                return;
            }
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SMART_APP_DEL_BROWSE_HISTORY);
            httpMessage.addParam("swan_app_key", i.this.f54865h.id);
            MessageManager.getInstance().sendMessage(httpMessage);
            if (i.this.f54864g != null) {
                i.this.f54864g.a(i.this.f54865h.id);
            }
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SMART_APP_HISTORY_DELETE_CLICK);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_id", i.this.f54865h.swan_app_id.longValue());
            statisticItem.param("obj_name", i.this.f54865h.name);
            TiebaStatic.log(statisticItem);
            if (i.this.f54860c != null) {
                i.this.f54860c.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(String str);
    }

    static {
        MessageManager.getInstance().registerTask(new TbHttpMessageTask(CmdConfigHttp.CMD_SMART_APP_DEL_BROWSE_HISTORY, TbConfig.SERVER_ADDRESS + TbConfig.URL_SMART_APP_DEL_BROWSE_HISTORY));
    }

    public i(TbPageContext tbPageContext) {
        this.f54858a = tbPageContext;
        Activity pageActivity = tbPageContext.getPageActivity();
        this.f54859b = pageActivity;
        this.f54861d = new l(pageActivity);
        this.f54862e = new ArrayList();
    }

    public void d(SmartApp smartApp) {
        this.f54865h = smartApp;
    }

    public void e() {
        if (this.f54860c != null) {
            return;
        }
        d.a.i0.r.s.h hVar = new d.a.i0.r.s.h(this.f54859b.getString(R.string.delete), this.f54861d);
        this.f54863f = hVar;
        hVar.m(this.f54866i);
        this.f54862e.add(this.f54863f);
        this.f54861d.k(this.f54862e);
        this.f54860c = new j(this.f54858a, this.f54861d);
    }

    public void f(b bVar) {
        this.f54864g = bVar;
    }

    public void g() {
        j jVar = this.f54860c;
        if (jVar == null) {
            return;
        }
        jVar.l();
    }
}

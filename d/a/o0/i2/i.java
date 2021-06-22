package d.a.o0.i2;

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
import d.a.n0.r.s.j;
import d.a.n0.r.s.l;
import java.util.ArrayList;
import java.util.List;
import tbclient.SmartApp;
/* loaded from: classes5.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f59567a;

    /* renamed from: b  reason: collision with root package name */
    public Context f59568b;

    /* renamed from: c  reason: collision with root package name */
    public j f59569c;

    /* renamed from: d  reason: collision with root package name */
    public l f59570d;

    /* renamed from: e  reason: collision with root package name */
    public List<d.a.n0.r.s.h> f59571e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.n0.r.s.h f59572f;

    /* renamed from: g  reason: collision with root package name */
    public b f59573g;

    /* renamed from: h  reason: collision with root package name */
    public SmartApp f59574h;

    /* renamed from: i  reason: collision with root package name */
    public l.d f59575i = new a();

    /* loaded from: classes5.dex */
    public class a implements l.d {
        public a() {
        }

        @Override // d.a.n0.r.s.l.d
        public void onClick() {
            if (i.this.f59574h == null) {
                return;
            }
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SMART_APP_DEL_BROWSE_HISTORY);
            httpMessage.addParam("swan_app_key", i.this.f59574h.id);
            MessageManager.getInstance().sendMessage(httpMessage);
            if (i.this.f59573g != null) {
                i.this.f59573g.a(i.this.f59574h.id);
            }
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SMART_APP_HISTORY_DELETE_CLICK);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_id", i.this.f59574h.swan_app_id.longValue());
            statisticItem.param("obj_name", i.this.f59574h.name);
            TiebaStatic.log(statisticItem);
            if (i.this.f59569c != null) {
                i.this.f59569c.dismiss();
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
        this.f59567a = tbPageContext;
        Activity pageActivity = tbPageContext.getPageActivity();
        this.f59568b = pageActivity;
        this.f59570d = new l(pageActivity);
        this.f59571e = new ArrayList();
    }

    public void d(SmartApp smartApp) {
        this.f59574h = smartApp;
    }

    public void e() {
        if (this.f59569c != null) {
            return;
        }
        d.a.n0.r.s.h hVar = new d.a.n0.r.s.h(this.f59568b.getString(R.string.delete), this.f59570d);
        this.f59572f = hVar;
        hVar.m(this.f59575i);
        this.f59571e.add(this.f59572f);
        this.f59570d.k(this.f59571e);
        this.f59569c = new j(this.f59567a, this.f59570d);
    }

    public void f(b bVar) {
        this.f59573g = bVar;
    }

    public void g() {
        j jVar = this.f59569c;
        if (jVar == null) {
            return;
        }
        jVar.l();
    }
}

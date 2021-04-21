package d.b.j0.e2.c;

import android.os.Bundle;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.pass.ecommerce.bean.SuggestAddrField;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.pbextra.praise.PraiseListResponsedMessage;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public String f56077a;

    /* renamed from: b  reason: collision with root package name */
    public String f56078b;

    /* renamed from: c  reason: collision with root package name */
    public String f56079c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f56080d;

    /* renamed from: e  reason: collision with root package name */
    public int f56081e;

    /* renamed from: f  reason: collision with root package name */
    public int f56082f;

    /* renamed from: g  reason: collision with root package name */
    public int f56083g;

    /* renamed from: h  reason: collision with root package name */
    public final List<d.b.j0.e2.c.a> f56084h;
    public b i;
    public final HttpMessageListener j;

    /* loaded from: classes3.dex */
    public class a extends HttpMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001400) {
                if (d.this.i != null) {
                    d.this.i.onLoadFailed(null);
                }
            } else if (httpResponsedMessage.getError() != 0 || !(httpResponsedMessage instanceof PraiseListResponsedMessage)) {
                if (d.this.i != null) {
                    d.this.i.onLoadFailed(null);
                }
            } else {
                PraiseListResponsedMessage praiseListResponsedMessage = (PraiseListResponsedMessage) httpResponsedMessage;
                if (praiseListResponsedMessage.getError() != 0) {
                    if (d.this.i != null) {
                        d.this.i.onLoadFailed(praiseListResponsedMessage.getErrMsg());
                        return;
                    }
                    return;
                }
                List<d.b.j0.e2.c.a> list = praiseListResponsedMessage.getmZanItemDataList();
                if (list != null) {
                    for (d.b.j0.e2.c.a aVar : list) {
                        d.this.f56084h.add(aVar);
                    }
                }
                d dVar = d.this;
                dVar.f56083g = dVar.f56084h.size();
                d.this.f56082f = praiseListResponsedMessage.getTotalNum();
                d.h(d.this);
                int i = d.this.f56081e > 5 ? 1003 : 1001;
                if (d.this.f56083g >= d.this.f56082f) {
                    i = 1002;
                }
                if (d.this.i != null) {
                    d.this.i.onLoadSuccessed(d.this.f56082f, d.this.f56084h, i, d.this.f56082f - d.this.f56083g);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void onLoadFailed(String str);

        void onLoadSuccessed(int i, List<d.b.j0.e2.c.a> list, int i2, int i3);
    }

    public d() {
        this.f56077a = "";
        this.f56078b = "";
        this.f56079c = "";
        this.f56080d = true;
        this.f56081e = 1;
        this.f56082f = 0;
        this.f56083g = 0;
        this.f56084h = new ArrayList(100);
        this.i = null;
        this.j = new a(CmdConfigHttp.PRAISE_LIST_HTTP_CMD);
        this.f56077a = "";
        this.f56078b = "";
    }

    public static /* synthetic */ int h(d dVar) {
        int i = dVar.f56081e;
        dVar.f56081e = i + 1;
        return i;
    }

    public String i() {
        return this.f56079c;
    }

    public d.b.j0.e2.c.a j(int i) {
        if (i <= -1 || i >= this.f56084h.size()) {
            return null;
        }
        return this.f56084h.get(i);
    }

    public String k() {
        return this.f56077a;
    }

    public boolean l() {
        return this.f56080d;
    }

    public void m(int i) {
        n();
    }

    public final void n() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.PRAISE_LIST_HTTP_CMD);
        httpMessage.addParam("post_id", this.f56078b + "");
        httpMessage.addParam(SuggestAddrField.KEY_PAGE_NUM, this.f56081e + "");
        httpMessage.addParam("res_num", "20");
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void o(Bundle bundle, String str) {
        bundle.putBoolean(str, this.f56080d);
    }

    public void p(Bundle bundle, String str) {
        bundle.putString(str, this.f56079c);
    }

    public void q(Bundle bundle, String str) {
        bundle.putString(str, this.f56078b);
    }

    public void r(Bundle bundle, String str) {
        bundle.putInt(str, this.f56082f);
    }

    public void s(Bundle bundle, String str) {
        bundle.putString(str, this.f56077a);
    }

    public void t(boolean z) {
    }

    public void u(int i) {
        this.f56082f = i;
    }

    public void v() {
        MessageManager messageManager = MessageManager.getInstance();
        messageManager.unRegisterListener(this.j);
        messageManager.unRegisterTask(CmdConfigHttp.CMD_GRAFFITI_LIST);
        messageManager.unRegisterTask(309326);
    }

    public d(String str, String str2, String str3, boolean z, b bVar) {
        this.f56077a = "";
        this.f56078b = "";
        this.f56079c = "";
        this.f56080d = true;
        this.f56081e = 1;
        this.f56082f = 0;
        this.f56083g = 0;
        this.f56084h = new ArrayList(100);
        this.i = null;
        this.j = new a(CmdConfigHttp.PRAISE_LIST_HTTP_CMD);
        this.f56077a = str;
        this.f56078b = str2;
        this.f56079c = str3;
        this.i = bVar;
        this.f56080d = z;
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.PRAISE_LIST_HTTP_CMD, TbConfig.SERVER_ADDRESS + "c/u/zan/getuserlist");
        tbHttpMessageTask.setResponsedClass(PraiseListResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().registerListener(this.j);
    }
}

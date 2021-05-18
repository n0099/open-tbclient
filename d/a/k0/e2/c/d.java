package d.a.k0.e2.c;

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
/* loaded from: classes5.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public String f54656a;

    /* renamed from: b  reason: collision with root package name */
    public String f54657b;

    /* renamed from: c  reason: collision with root package name */
    public String f54658c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f54659d;

    /* renamed from: e  reason: collision with root package name */
    public int f54660e;

    /* renamed from: f  reason: collision with root package name */
    public int f54661f;

    /* renamed from: g  reason: collision with root package name */
    public int f54662g;

    /* renamed from: h  reason: collision with root package name */
    public final List<d.a.k0.e2.c.a> f54663h;

    /* renamed from: i  reason: collision with root package name */
    public b f54664i;
    public final HttpMessageListener j;

    /* loaded from: classes5.dex */
    public class a extends HttpMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001400) {
                if (d.this.f54664i != null) {
                    d.this.f54664i.onLoadFailed(null);
                }
            } else if (httpResponsedMessage.getError() != 0 || !(httpResponsedMessage instanceof PraiseListResponsedMessage)) {
                if (d.this.f54664i != null) {
                    d.this.f54664i.onLoadFailed(null);
                }
            } else {
                PraiseListResponsedMessage praiseListResponsedMessage = (PraiseListResponsedMessage) httpResponsedMessage;
                if (praiseListResponsedMessage.getError() != 0) {
                    if (d.this.f54664i != null) {
                        d.this.f54664i.onLoadFailed(praiseListResponsedMessage.getErrMsg());
                        return;
                    }
                    return;
                }
                List<d.a.k0.e2.c.a> list = praiseListResponsedMessage.getmZanItemDataList();
                if (list != null) {
                    for (d.a.k0.e2.c.a aVar : list) {
                        d.this.f54663h.add(aVar);
                    }
                }
                d dVar = d.this;
                dVar.f54662g = dVar.f54663h.size();
                d.this.f54661f = praiseListResponsedMessage.getTotalNum();
                d.h(d.this);
                int i2 = d.this.f54660e > 5 ? 1003 : 1001;
                if (d.this.f54662g >= d.this.f54661f) {
                    i2 = 1002;
                }
                if (d.this.f54664i != null) {
                    d.this.f54664i.onLoadSuccessed(d.this.f54661f, d.this.f54663h, i2, d.this.f54661f - d.this.f54662g);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void onLoadFailed(String str);

        void onLoadSuccessed(int i2, List<d.a.k0.e2.c.a> list, int i3, int i4);
    }

    public d() {
        this.f54656a = "";
        this.f54657b = "";
        this.f54658c = "";
        this.f54659d = true;
        this.f54660e = 1;
        this.f54661f = 0;
        this.f54662g = 0;
        this.f54663h = new ArrayList(100);
        this.f54664i = null;
        this.j = new a(CmdConfigHttp.PRAISE_LIST_HTTP_CMD);
        this.f54656a = "";
        this.f54657b = "";
    }

    public static /* synthetic */ int h(d dVar) {
        int i2 = dVar.f54660e;
        dVar.f54660e = i2 + 1;
        return i2;
    }

    public String i() {
        return this.f54658c;
    }

    public d.a.k0.e2.c.a j(int i2) {
        if (i2 <= -1 || i2 >= this.f54663h.size()) {
            return null;
        }
        return this.f54663h.get(i2);
    }

    public String k() {
        return this.f54656a;
    }

    public boolean l() {
        return this.f54659d;
    }

    public void m(int i2) {
        n();
    }

    public final void n() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.PRAISE_LIST_HTTP_CMD);
        httpMessage.addParam("post_id", this.f54657b + "");
        httpMessage.addParam(SuggestAddrField.KEY_PAGE_NUM, this.f54660e + "");
        httpMessage.addParam("res_num", "20");
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void o(Bundle bundle, String str) {
        bundle.putBoolean(str, this.f54659d);
    }

    public void p(Bundle bundle, String str) {
        bundle.putString(str, this.f54658c);
    }

    public void q(Bundle bundle, String str) {
        bundle.putString(str, this.f54657b);
    }

    public void r(Bundle bundle, String str) {
        bundle.putInt(str, this.f54661f);
    }

    public void s(Bundle bundle, String str) {
        bundle.putString(str, this.f54656a);
    }

    public void t(boolean z) {
    }

    public void u(int i2) {
        this.f54661f = i2;
    }

    public void v() {
        MessageManager messageManager = MessageManager.getInstance();
        messageManager.unRegisterListener(this.j);
        messageManager.unRegisterTask(CmdConfigHttp.CMD_GRAFFITI_LIST);
        messageManager.unRegisterTask(309326);
    }

    public d(String str, String str2, String str3, boolean z, b bVar) {
        this.f54656a = "";
        this.f54657b = "";
        this.f54658c = "";
        this.f54659d = true;
        this.f54660e = 1;
        this.f54661f = 0;
        this.f54662g = 0;
        this.f54663h = new ArrayList(100);
        this.f54664i = null;
        this.j = new a(CmdConfigHttp.PRAISE_LIST_HTTP_CMD);
        this.f54656a = str;
        this.f54657b = str2;
        this.f54658c = str3;
        this.f54664i = bVar;
        this.f54659d = z;
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.PRAISE_LIST_HTTP_CMD, TbConfig.SERVER_ADDRESS + "c/u/zan/getuserlist");
        tbHttpMessageTask.setResponsedClass(PraiseListResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().registerListener(this.j);
    }
}

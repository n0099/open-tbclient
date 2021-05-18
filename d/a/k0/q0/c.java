package d.a.k0.q0;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import tbclient.BawuThrones;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public w f58261a;

    /* renamed from: b  reason: collision with root package name */
    public BawuThrones f58262b;

    /* loaded from: classes4.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static c f58263a = new c();
    }

    public static c c() {
        return b.f58263a;
    }

    public void a() {
        this.f58262b = null;
        w wVar = this.f58261a;
        if (wVar != null) {
            wVar.g();
        }
        this.f58261a = null;
    }

    public BawuThrones b() {
        return this.f58262b;
    }

    public void d(String str, String str2) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FRS_RECOMMEND);
        httpMessage.addParam("forum_id", str);
        httpMessage.addParam("thread_id", str2);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void e(BawuThrones bawuThrones) {
        this.f58262b = bawuThrones;
    }

    public void f(TbPageContext tbPageContext, String str, String str2) {
        if (this.f58261a == null) {
            this.f58261a = new w();
        }
        this.f58261a.i(tbPageContext, str, str2);
    }

    public c() {
    }
}

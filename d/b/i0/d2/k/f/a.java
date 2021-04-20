package d.b.i0.d2.k.f;

import android.content.Context;
import android.content.DialogInterface;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.report.UEGReportResponsedMessage;
import d.b.c.a.f;
import d.b.c.a.j;
import d.b.h0.r.f0.c;
/* loaded from: classes3.dex */
public class a implements d.b.i0.l3.a {

    /* renamed from: a  reason: collision with root package name */
    public Context f54429a;

    /* renamed from: b  reason: collision with root package name */
    public BdUniqueId f54430b;

    /* renamed from: d  reason: collision with root package name */
    public d.b.h0.r.f0.a f54432d;

    /* renamed from: e  reason: collision with root package name */
    public c f54433e;

    /* renamed from: f  reason: collision with root package name */
    public HttpMessageListener f54434f = new b(CmdConfigHttp.CMD_UEG_REPORT);

    /* renamed from: c  reason: collision with root package name */
    public d.b.i0.d2.k.f.b f54431c = new d.b.i0.d2.k.f.b();

    /* renamed from: d.b.i0.d2.k.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class DialogInterface$OnCancelListenerC1222a implements DialogInterface.OnCancelListener {
        public DialogInterface$OnCancelListenerC1222a() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            MessageManager.getInstance().removeMessage(a.this.f54430b);
        }
    }

    /* loaded from: classes3.dex */
    public class b extends HttpMessageListener {
        public b(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof UEGReportResponsedMessage) {
                if (a.this.f54432d != null) {
                    a.this.f54432d.h(false);
                }
                UEGReportResponsedMessage uEGReportResponsedMessage = (UEGReportResponsedMessage) httpResponsedMessage;
                String url = uEGReportResponsedMessage.getUrl();
                if (!StringUtils.isNull(url)) {
                    a.this.h(url);
                    return;
                }
                String errorString = uEGReportResponsedMessage.getErrorString();
                if (StringUtils.isNull(errorString)) {
                    errorString = a.this.f54429a.getString(R.string.neterror);
                }
                a.this.f54433e.b(errorString);
            }
        }
    }

    public a(Context context) {
        this.f54429a = context;
        c cVar = new c();
        this.f54433e = cVar;
        cVar.f50891a = 1000L;
    }

    @Override // d.b.i0.l3.a
    public void a(BdUniqueId bdUniqueId) {
        this.f54430b = bdUniqueId;
        this.f54431c.c(bdUniqueId);
        this.f54434f.setTag(bdUniqueId);
        this.f54434f.setSelfListener(true);
        MessageManager.getInstance().registerListener(this.f54434f);
    }

    @Override // d.b.i0.l3.a
    public void b(String str) {
        j();
        this.f54431c.b(str);
    }

    public final void h(String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(this.f54429a, this.f54429a.getString(R.string.pb_web_view_report_title), str, true)));
    }

    public void i(String str) {
        j();
        this.f54431c.a(str);
    }

    public final void j() {
        if (this.f54432d == null) {
            f<?> a2 = j.a(this.f54429a);
            TbPageContext tbPageContext = a2 instanceof TbPageContext ? (TbPageContext) a2 : null;
            if (tbPageContext == null) {
                return;
            }
            d.b.h0.r.f0.a aVar = new d.b.h0.r.f0.a(tbPageContext);
            this.f54432d = aVar;
            aVar.e(new DialogInterface$OnCancelListenerC1222a());
        }
        this.f54432d.h(true);
    }
}

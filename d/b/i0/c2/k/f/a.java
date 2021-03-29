package d.b.i0.c2.k.f;

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
import d.b.b.a.f;
import d.b.b.a.j;
import d.b.h0.r.f0.c;
/* loaded from: classes5.dex */
public class a implements d.b.i0.k3.a {

    /* renamed from: a  reason: collision with root package name */
    public Context f53020a;

    /* renamed from: b  reason: collision with root package name */
    public BdUniqueId f53021b;

    /* renamed from: d  reason: collision with root package name */
    public d.b.h0.r.f0.a f53023d;

    /* renamed from: e  reason: collision with root package name */
    public c f53024e;

    /* renamed from: f  reason: collision with root package name */
    public HttpMessageListener f53025f = new b(CmdConfigHttp.CMD_UEG_REPORT);

    /* renamed from: c  reason: collision with root package name */
    public d.b.i0.c2.k.f.b f53022c = new d.b.i0.c2.k.f.b();

    /* renamed from: d.b.i0.c2.k.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class DialogInterface$OnCancelListenerC1165a implements DialogInterface.OnCancelListener {
        public DialogInterface$OnCancelListenerC1165a() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            MessageManager.getInstance().removeMessage(a.this.f53021b);
        }
    }

    /* loaded from: classes5.dex */
    public class b extends HttpMessageListener {
        public b(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof UEGReportResponsedMessage) {
                if (a.this.f53023d != null) {
                    a.this.f53023d.h(false);
                }
                UEGReportResponsedMessage uEGReportResponsedMessage = (UEGReportResponsedMessage) httpResponsedMessage;
                String url = uEGReportResponsedMessage.getUrl();
                if (!StringUtils.isNull(url)) {
                    a.this.h(url);
                    return;
                }
                String errorString = uEGReportResponsedMessage.getErrorString();
                if (StringUtils.isNull(errorString)) {
                    errorString = a.this.f53020a.getString(R.string.neterror);
                }
                a.this.f53024e.b(errorString);
            }
        }
    }

    public a(Context context) {
        this.f53020a = context;
        c cVar = new c();
        this.f53024e = cVar;
        cVar.f50484a = 1000L;
    }

    @Override // d.b.i0.k3.a
    public void a(BdUniqueId bdUniqueId) {
        this.f53021b = bdUniqueId;
        this.f53022c.c(bdUniqueId);
        this.f53025f.setTag(bdUniqueId);
        this.f53025f.setSelfListener(true);
        MessageManager.getInstance().registerListener(this.f53025f);
    }

    @Override // d.b.i0.k3.a
    public void b(String str) {
        j();
        this.f53022c.b(str);
    }

    public final void h(String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(this.f53020a, this.f53020a.getString(R.string.pb_web_view_report_title), str, true)));
    }

    public void i(String str) {
        j();
        this.f53022c.a(str);
    }

    public final void j() {
        if (this.f53023d == null) {
            f<?> a2 = j.a(this.f53020a);
            TbPageContext tbPageContext = a2 instanceof TbPageContext ? (TbPageContext) a2 : null;
            if (tbPageContext == null) {
                return;
            }
            d.b.h0.r.f0.a aVar = new d.b.h0.r.f0.a(tbPageContext);
            this.f53023d = aVar;
            aVar.e(new DialogInterface$OnCancelListenerC1165a());
        }
        this.f53023d.h(true);
    }
}

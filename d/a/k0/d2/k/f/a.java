package d.a.k0.d2.k.f;

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
import d.a.c.a.f;
import d.a.c.a.j;
import d.a.j0.r.f0.c;
/* loaded from: classes5.dex */
public class a implements d.a.k0.l3.a {

    /* renamed from: a  reason: collision with root package name */
    public Context f53370a;

    /* renamed from: b  reason: collision with root package name */
    public BdUniqueId f53371b;

    /* renamed from: d  reason: collision with root package name */
    public d.a.j0.r.f0.a f53373d;

    /* renamed from: e  reason: collision with root package name */
    public c f53374e;

    /* renamed from: f  reason: collision with root package name */
    public HttpMessageListener f53375f = new b(CmdConfigHttp.CMD_UEG_REPORT);

    /* renamed from: c  reason: collision with root package name */
    public d.a.k0.d2.k.f.b f53372c = new d.a.k0.d2.k.f.b();

    /* renamed from: d.a.k0.d2.k.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class DialogInterface$OnCancelListenerC1256a implements DialogInterface.OnCancelListener {
        public DialogInterface$OnCancelListenerC1256a() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            MessageManager.getInstance().removeMessage(a.this.f53371b);
        }
    }

    /* loaded from: classes5.dex */
    public class b extends HttpMessageListener {
        public b(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof UEGReportResponsedMessage) {
                if (a.this.f53373d != null) {
                    a.this.f53373d.h(false);
                }
                UEGReportResponsedMessage uEGReportResponsedMessage = (UEGReportResponsedMessage) httpResponsedMessage;
                String url = uEGReportResponsedMessage.getUrl();
                if (!StringUtils.isNull(url)) {
                    a.this.h(url);
                    return;
                }
                String errorString = uEGReportResponsedMessage.getErrorString();
                if (StringUtils.isNull(errorString)) {
                    errorString = a.this.f53370a.getString(R.string.neterror);
                }
                a.this.f53374e.b(errorString);
            }
        }
    }

    public a(Context context) {
        this.f53370a = context;
        c cVar = new c();
        this.f53374e = cVar;
        cVar.f49665a = 1000L;
    }

    @Override // d.a.k0.l3.a
    public void a(BdUniqueId bdUniqueId) {
        this.f53371b = bdUniqueId;
        this.f53372c.c(bdUniqueId);
        this.f53375f.setTag(bdUniqueId);
        this.f53375f.setSelfListener(true);
        MessageManager.getInstance().registerListener(this.f53375f);
    }

    @Override // d.a.k0.l3.a
    public void b(String str) {
        j();
        this.f53372c.b(str);
    }

    public final void h(String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(this.f53370a, this.f53370a.getString(R.string.pb_web_view_report_title), str, true)));
    }

    public void i(String str) {
        j();
        this.f53372c.a(str);
    }

    public final void j() {
        if (this.f53373d == null) {
            f<?> a2 = j.a(this.f53370a);
            TbPageContext tbPageContext = a2 instanceof TbPageContext ? (TbPageContext) a2 : null;
            if (tbPageContext == null) {
                return;
            }
            d.a.j0.r.f0.a aVar = new d.a.j0.r.f0.a(tbPageContext);
            this.f53373d = aVar;
            aVar.e(new DialogInterface$OnCancelListenerC1256a());
        }
        this.f53373d.h(true);
    }
}

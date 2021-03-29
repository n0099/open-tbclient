package d.b.i0.w;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.callfans.CallFansResMsg;
import d.b.h0.r.s.a;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f62089a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f62090b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f62091c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f62092d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f62093e;

    /* renamed from: f  reason: collision with root package name */
    public String f62094f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f62095g = false;

    /* renamed from: d.b.i0.w.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1645a implements View.OnClickListener {
        public View$OnClickListenerC1645a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a aVar = a.this;
            aVar.f62095g = !aVar.f62095g;
            aVar.h();
            d.b.h0.r.d0.b.i().s("key_call_fans_no_tip_again", a.this.f62095g);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.r.s.a f62097e;

        public b(d.b.h0.r.s.a aVar) {
            this.f62097e = aVar;
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            a.this.d();
            this.f62097e.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public class c implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.r.s.a f62099e;

        public c(a aVar, d.b.h0.r.s.a aVar2) {
            this.f62099e = aVar2;
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            d.b.h0.r.d0.b.i().s("key_call_fans_no_tip_again", false);
            this.f62099e.dismiss();
        }
    }

    public a(TbPageContext tbPageContext) {
        this.f62089a = tbPageContext;
        g();
    }

    public void c() {
        if (!TbSingleton.getInstance().mCanCallFans) {
            this.f62089a.showToast(R.string.have_used_call_fans_this_week);
        } else if (d.b.h0.r.d0.b.i().g("key_call_fans_no_tip_again", false)) {
            d();
        } else {
            d.b.h0.r.s.a aVar = new d.b.h0.r.s.a(this.f62089a.getPageActivity());
            aVar.setContentViewSize(1);
            View inflate = LayoutInflater.from(this.f62089a.getPageActivity()).inflate(R.layout.call_fans_dialog_content, (ViewGroup) null);
            this.f62090b = (TextView) inflate.findViewById(R.id.title);
            this.f62091c = (TextView) inflate.findViewById(R.id.call_fans_intro);
            this.f62093e = (TextView) inflate.findViewById(R.id.no_tip_again_text);
            this.f62092d = (ImageView) inflate.findViewById(R.id.checkbox);
            h();
            this.f62092d.setOnClickListener(new View$OnClickListenerC1645a());
            f();
            aVar.setContentView(inflate);
            aVar.setPositiveButton(this.f62089a.getString(R.string.call_fans), new b(aVar));
            aVar.setNegativeButton(this.f62089a.getString(R.string.next_time), new c(this, aVar));
            aVar.create(this.f62089a).show();
        }
    }

    public final void d() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_CALL_FANS);
        httpMessage.addParam("thread_id", this.f62094f);
        MessageManager.getInstance().sendMessage(httpMessage);
        this.f62089a.showToast(R.string.your_thread_is_recommended_to_fans);
        TbSingleton.getInstance().mCallFansTid = this.f62094f;
        TbSingleton.getInstance().mCanCallFans = false;
    }

    public void e(int i, int i2, String str) {
        TiebaStatic.log(new StatisticItem("c13847").param("obj_source", i).param("obj_type", i2).param("tid", str).param("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    public void f() {
        SkinManager.setViewTextColor(this.f62090b, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f62091c, R.color.CAM_X0107);
        h();
        SkinManager.setViewTextColor(this.f62093e, R.color.CAM_X0107);
    }

    public final void g() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_CALL_FANS, TbConfig.SERVER_ADDRESS + TbConfig.URL_CALL_FANS);
        tbHttpMessageTask.setResponsedClass(CallFansResMsg.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        messageManager.registerTask(tbHttpMessageTask);
    }

    public final void h() {
        Drawable maskDrawable;
        ImageView imageView = this.f62092d;
        if (imageView == null) {
            return;
        }
        if (this.f62095g) {
            maskDrawable = SvgManager.getInstance().getMaskDrawable(R.drawable.ic_icon_mask_use_complete16_svg, null);
        } else {
            maskDrawable = SvgManager.getInstance().getMaskDrawable(R.drawable.ic_icon_mask_use_check16_svg, null);
        }
        imageView.setImageDrawable(maskDrawable);
    }

    public void i(String str) {
        this.f62094f = str;
    }
}

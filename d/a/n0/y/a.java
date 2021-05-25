package d.a.n0.y;

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
import d.a.m0.r.s.a;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f63345a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f63346b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f63347c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f63348d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f63349e;

    /* renamed from: f  reason: collision with root package name */
    public String f63350f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f63351g = false;

    /* renamed from: d.a.n0.y.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1744a implements View.OnClickListener {
        public View$OnClickListenerC1744a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a aVar = a.this;
            aVar.f63351g = !aVar.f63351g;
            aVar.h();
            d.a.m0.r.d0.b.j().t("key_call_fans_no_tip_again", a.this.f63351g);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.r.s.a f63353e;

        public b(d.a.m0.r.s.a aVar) {
            this.f63353e = aVar;
        }

        @Override // d.a.m0.r.s.a.e
        public void onClick(d.a.m0.r.s.a aVar) {
            a.this.d();
            this.f63353e.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public class c implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.r.s.a f63355e;

        public c(a aVar, d.a.m0.r.s.a aVar2) {
            this.f63355e = aVar2;
        }

        @Override // d.a.m0.r.s.a.e
        public void onClick(d.a.m0.r.s.a aVar) {
            d.a.m0.r.d0.b.j().t("key_call_fans_no_tip_again", false);
            this.f63355e.dismiss();
        }
    }

    public a(TbPageContext tbPageContext) {
        this.f63345a = tbPageContext;
        g();
    }

    public void c() {
        if (!TbSingleton.getInstance().mCanCallFans) {
            this.f63345a.showToast(R.string.have_used_call_fans_this_week);
        } else if (d.a.m0.r.d0.b.j().g("key_call_fans_no_tip_again", false)) {
            d();
        } else {
            d.a.m0.r.s.a aVar = new d.a.m0.r.s.a(this.f63345a.getPageActivity());
            aVar.setContentViewSize(1);
            View inflate = LayoutInflater.from(this.f63345a.getPageActivity()).inflate(R.layout.call_fans_dialog_content, (ViewGroup) null);
            this.f63346b = (TextView) inflate.findViewById(R.id.title);
            this.f63347c = (TextView) inflate.findViewById(R.id.call_fans_intro);
            this.f63349e = (TextView) inflate.findViewById(R.id.no_tip_again_text);
            this.f63348d = (ImageView) inflate.findViewById(R.id.checkbox);
            h();
            this.f63348d.setOnClickListener(new View$OnClickListenerC1744a());
            f();
            aVar.setContentView(inflate);
            aVar.setPositiveButton(this.f63345a.getString(R.string.call_fans), new b(aVar));
            aVar.setNegativeButton(this.f63345a.getString(R.string.next_time), new c(this, aVar));
            aVar.create(this.f63345a).show();
        }
    }

    public final void d() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_CALL_FANS);
        httpMessage.addParam("thread_id", this.f63350f);
        MessageManager.getInstance().sendMessage(httpMessage);
        this.f63345a.showToast(R.string.your_thread_is_recommended_to_fans);
        TbSingleton.getInstance().mCallFansTid = this.f63350f;
        TbSingleton.getInstance().mCanCallFans = false;
    }

    public void e(int i2, int i3, String str) {
        TiebaStatic.log(new StatisticItem("c13847").param("obj_source", i2).param("obj_type", i3).param("tid", str).param("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    public void f() {
        SkinManager.setViewTextColor(this.f63346b, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f63347c, R.color.CAM_X0107);
        h();
        SkinManager.setViewTextColor(this.f63349e, R.color.CAM_X0107);
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
        ImageView imageView = this.f63348d;
        if (imageView == null) {
            return;
        }
        if (this.f63351g) {
            maskDrawable = SvgManager.getInstance().getMaskDrawable(R.drawable.ic_icon_mask_use_complete16_svg, null);
        } else {
            maskDrawable = SvgManager.getInstance().getMaskDrawable(R.drawable.ic_icon_mask_use_check16_svg, null);
        }
        imageView.setImageDrawable(maskDrawable);
    }

    public void i(String str) {
        this.f63350f = str;
    }
}

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
    public TbPageContext f67060a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f67061b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f67062c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f67063d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f67064e;

    /* renamed from: f  reason: collision with root package name */
    public String f67065f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f67066g = false;

    /* renamed from: d.a.n0.y.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1801a implements View.OnClickListener {
        public View$OnClickListenerC1801a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a aVar = a.this;
            aVar.f67066g = !aVar.f67066g;
            aVar.h();
            d.a.m0.r.d0.b.j().t("key_call_fans_no_tip_again", a.this.f67066g);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.r.s.a f67068e;

        public b(d.a.m0.r.s.a aVar) {
            this.f67068e = aVar;
        }

        @Override // d.a.m0.r.s.a.e
        public void onClick(d.a.m0.r.s.a aVar) {
            a.this.d();
            this.f67068e.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public class c implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.r.s.a f67070e;

        public c(a aVar, d.a.m0.r.s.a aVar2) {
            this.f67070e = aVar2;
        }

        @Override // d.a.m0.r.s.a.e
        public void onClick(d.a.m0.r.s.a aVar) {
            d.a.m0.r.d0.b.j().t("key_call_fans_no_tip_again", false);
            this.f67070e.dismiss();
        }
    }

    public a(TbPageContext tbPageContext) {
        this.f67060a = tbPageContext;
        g();
    }

    public void c() {
        if (!TbSingleton.getInstance().mCanCallFans) {
            this.f67060a.showToast(R.string.have_used_call_fans_this_week);
        } else if (d.a.m0.r.d0.b.j().g("key_call_fans_no_tip_again", false)) {
            d();
        } else {
            d.a.m0.r.s.a aVar = new d.a.m0.r.s.a(this.f67060a.getPageActivity());
            aVar.setContentViewSize(1);
            View inflate = LayoutInflater.from(this.f67060a.getPageActivity()).inflate(R.layout.call_fans_dialog_content, (ViewGroup) null);
            this.f67061b = (TextView) inflate.findViewById(R.id.title);
            this.f67062c = (TextView) inflate.findViewById(R.id.call_fans_intro);
            this.f67064e = (TextView) inflate.findViewById(R.id.no_tip_again_text);
            this.f67063d = (ImageView) inflate.findViewById(R.id.checkbox);
            h();
            this.f67063d.setOnClickListener(new View$OnClickListenerC1801a());
            f();
            aVar.setContentView(inflate);
            aVar.setPositiveButton(this.f67060a.getString(R.string.call_fans), new b(aVar));
            aVar.setNegativeButton(this.f67060a.getString(R.string.next_time), new c(this, aVar));
            aVar.create(this.f67060a).show();
        }
    }

    public final void d() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_CALL_FANS);
        httpMessage.addParam("thread_id", this.f67065f);
        MessageManager.getInstance().sendMessage(httpMessage);
        this.f67060a.showToast(R.string.your_thread_is_recommended_to_fans);
        TbSingleton.getInstance().mCallFansTid = this.f67065f;
        TbSingleton.getInstance().mCanCallFans = false;
    }

    public void e(int i2, int i3, String str) {
        TiebaStatic.log(new StatisticItem("c13847").param("obj_source", i2).param("obj_type", i3).param("tid", str).param("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    public void f() {
        SkinManager.setViewTextColor(this.f67061b, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f67062c, R.color.CAM_X0107);
        h();
        SkinManager.setViewTextColor(this.f67064e, R.color.CAM_X0107);
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
        ImageView imageView = this.f67063d;
        if (imageView == null) {
            return;
        }
        if (this.f67066g) {
            maskDrawable = SvgManager.getInstance().getMaskDrawable(R.drawable.ic_icon_mask_use_complete16_svg, null);
        } else {
            maskDrawable = SvgManager.getInstance().getMaskDrawable(R.drawable.ic_icon_mask_use_check16_svg, null);
        }
        imageView.setImageDrawable(maskDrawable);
    }

    public void i(String str) {
        this.f67065f = str;
    }
}

package d.b.j0.w;

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
import d.b.i0.r.s.a;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f64041a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f64042b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f64043c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f64044d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f64045e;

    /* renamed from: f  reason: collision with root package name */
    public String f64046f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f64047g = false;

    /* renamed from: d.b.j0.w.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1715a implements View.OnClickListener {
        public View$OnClickListenerC1715a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a aVar = a.this;
            aVar.f64047g = !aVar.f64047g;
            aVar.h();
            d.b.i0.r.d0.b.j().t("key_call_fans_no_tip_again", a.this.f64047g);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.i0.r.s.a f64049e;

        public b(d.b.i0.r.s.a aVar) {
            this.f64049e = aVar;
        }

        @Override // d.b.i0.r.s.a.e
        public void onClick(d.b.i0.r.s.a aVar) {
            a.this.d();
            this.f64049e.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public class c implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.i0.r.s.a f64051e;

        public c(a aVar, d.b.i0.r.s.a aVar2) {
            this.f64051e = aVar2;
        }

        @Override // d.b.i0.r.s.a.e
        public void onClick(d.b.i0.r.s.a aVar) {
            d.b.i0.r.d0.b.j().t("key_call_fans_no_tip_again", false);
            this.f64051e.dismiss();
        }
    }

    public a(TbPageContext tbPageContext) {
        this.f64041a = tbPageContext;
        g();
    }

    public void c() {
        if (!TbSingleton.getInstance().mCanCallFans) {
            this.f64041a.showToast(R.string.have_used_call_fans_this_week);
        } else if (d.b.i0.r.d0.b.j().g("key_call_fans_no_tip_again", false)) {
            d();
        } else {
            d.b.i0.r.s.a aVar = new d.b.i0.r.s.a(this.f64041a.getPageActivity());
            aVar.setContentViewSize(1);
            View inflate = LayoutInflater.from(this.f64041a.getPageActivity()).inflate(R.layout.call_fans_dialog_content, (ViewGroup) null);
            this.f64042b = (TextView) inflate.findViewById(R.id.title);
            this.f64043c = (TextView) inflate.findViewById(R.id.call_fans_intro);
            this.f64045e = (TextView) inflate.findViewById(R.id.no_tip_again_text);
            this.f64044d = (ImageView) inflate.findViewById(R.id.checkbox);
            h();
            this.f64044d.setOnClickListener(new View$OnClickListenerC1715a());
            f();
            aVar.setContentView(inflate);
            aVar.setPositiveButton(this.f64041a.getString(R.string.call_fans), new b(aVar));
            aVar.setNegativeButton(this.f64041a.getString(R.string.next_time), new c(this, aVar));
            aVar.create(this.f64041a).show();
        }
    }

    public final void d() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_CALL_FANS);
        httpMessage.addParam("thread_id", this.f64046f);
        MessageManager.getInstance().sendMessage(httpMessage);
        this.f64041a.showToast(R.string.your_thread_is_recommended_to_fans);
        TbSingleton.getInstance().mCallFansTid = this.f64046f;
        TbSingleton.getInstance().mCanCallFans = false;
    }

    public void e(int i, int i2, String str) {
        TiebaStatic.log(new StatisticItem("c13847").param("obj_source", i).param("obj_type", i2).param("tid", str).param("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    public void f() {
        SkinManager.setViewTextColor(this.f64042b, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f64043c, R.color.CAM_X0107);
        h();
        SkinManager.setViewTextColor(this.f64045e, R.color.CAM_X0107);
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
        ImageView imageView = this.f64044d;
        if (imageView == null) {
            return;
        }
        if (this.f64047g) {
            maskDrawable = SvgManager.getInstance().getMaskDrawable(R.drawable.ic_icon_mask_use_complete16_svg, null);
        } else {
            maskDrawable = SvgManager.getInstance().getMaskDrawable(R.drawable.ic_icon_mask_use_check16_svg, null);
        }
        imageView.setImageDrawable(maskDrawable);
    }

    public void i(String str) {
        this.f64046f = str;
    }
}

package d.b.i0.s2.h0;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.widget.CountDownTextView;
import d.b.i0.s2.w;
/* loaded from: classes4.dex */
public class c extends e {

    /* renamed from: g  reason: collision with root package name */
    public HeadImageView f61723g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f61724h;
    public TextView i;
    public CountDownTextView j;
    public boolean k;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.i0.s2.c0.b.e f61725e;

        public a(d.b.i0.s2.c0.b.e eVar) {
            this.f61725e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Context context = c.this.f61731b.getContext();
            String str = this.f61725e.f61599d;
            AdvertAppInfo advertAppInfo = c.this.f61733d;
            w.d(context, str, null, advertAppInfo != null ? advertAppInfo.T3 : "");
            d.b.i0.s2.f0.c cVar = c.this.f61732c;
            if (cVar != null) {
                cVar.j(302);
                d.b.i0.s2.f0.e.b().d(c.this.f61732c);
            }
            d.b.i0.j1.o.h.b bVar = c.this.f61734e;
            if (bVar != null) {
                d.b.i0.j1.o.h.c.h(bVar);
            }
            c.this.a(false);
        }
    }

    public c(View view, String str) {
        super(view, str);
        m();
    }

    @Override // d.b.i0.s2.h0.e
    public void a(boolean z) {
        this.k = z;
        CountDownTextView countDownTextView = this.j;
        if (countDownTextView != null) {
            countDownTextView.setEnableTimeoutListener(z);
        }
    }

    @Override // d.b.i0.s2.h0.e
    public void c() {
        SkinManager.setViewTextColor(this.f61724h, R.color.CAM_X0101, 1);
        SkinManager.setViewTextColor(this.i, R.color.CAM_X0101, 1);
        SkinManager.setBackgroundResource(this.i, R.drawable.tail_frame_action_btn_bg, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // d.b.i0.s2.h0.e
    public void d(d.b.i0.s2.c0.b.e eVar) {
        super.d(eVar);
        this.f61723g.W(eVar.f61598c, 10, false);
        this.f61724h.setText(eVar.f61597b);
        this.i.setText(eVar.f61600e);
        this.f61731b.setOnClickListener(new a(eVar));
        this.j.f(eVar.f61603h);
        c();
    }

    @Override // d.b.i0.s2.h0.e
    public void e() {
        super.e();
        this.j.e();
    }

    @Override // d.b.i0.s2.h0.e
    public void l(CountDownTextView.c cVar) {
        super.l(cVar);
        this.j.setTimeoutListener(cVar);
    }

    public final void m() {
        HeadImageView headImageView = (HeadImageView) b(R.id.user_portrait);
        this.f61723g = headImageView;
        headImageView.setDefaultResource(R.drawable.icon_default_avatar100);
        this.f61723g.setDefaultBgResource(R.color.CAM_X0205);
        this.f61723g.setIsRound(true);
        this.f61724h = (TextView) b(R.id.user_name);
        this.j = (CountDownTextView) b(R.id.count_down_text);
        this.i = (TextView) b(R.id.action);
    }
}

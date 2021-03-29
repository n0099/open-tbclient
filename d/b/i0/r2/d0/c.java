package d.b.i0.r2.d0;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.widget.CountDownTextView;
import d.b.i0.r2.t;
/* loaded from: classes5.dex */
public class c extends e {

    /* renamed from: g  reason: collision with root package name */
    public HeadImageView f59822g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f59823h;
    public TextView i;
    public CountDownTextView j;
    public boolean k;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AdCard.g f59824e;

        public a(AdCard.g gVar) {
            this.f59824e = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Context context = c.this.f59830b.getContext();
            String str = this.f59824e.f20721d;
            AdvertAppInfo advertAppInfo = c.this.f59832d;
            t.d(context, str, null, advertAppInfo != null ? advertAppInfo.T3 : "");
            d.b.i0.r2.b0.c cVar = c.this.f59831c;
            if (cVar != null) {
                cVar.j(302);
                d.b.i0.r2.b0.e.b().d(c.this.f59831c);
            }
            d.b.i0.i1.o.h.b bVar = c.this.f59833e;
            if (bVar != null) {
                d.b.i0.i1.o.h.c.h(bVar);
            }
            c.this.a(false);
        }
    }

    public c(View view, String str) {
        super(view, str);
        m();
    }

    @Override // d.b.i0.r2.d0.e
    public void a(boolean z) {
        this.k = z;
        CountDownTextView countDownTextView = this.j;
        if (countDownTextView != null) {
            countDownTextView.setEnableTimeoutListener(z);
        }
    }

    @Override // d.b.i0.r2.d0.e
    public void c() {
        SkinManager.setViewTextColor(this.f59823h, R.color.CAM_X0101, 1);
        SkinManager.setViewTextColor(this.i, R.color.CAM_X0101, 1);
        SkinManager.setBackgroundResource(this.i, R.drawable.tail_frame_action_btn_bg, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // d.b.i0.r2.d0.e
    public void d(AdCard.g gVar) {
        super.d(gVar);
        this.f59822g.W(gVar.f20720c, 10, false);
        this.f59823h.setText(gVar.f20719b);
        this.i.setText(gVar.f20722e);
        this.f59830b.setOnClickListener(new a(gVar));
        this.j.f(gVar.f20725h);
        c();
    }

    @Override // d.b.i0.r2.d0.e
    public void e() {
        super.e();
        this.j.e();
    }

    @Override // d.b.i0.r2.d0.e
    public void l(CountDownTextView.c cVar) {
        super.l(cVar);
        this.j.setTimeoutListener(cVar);
    }

    public final void m() {
        HeadImageView headImageView = (HeadImageView) b(R.id.user_portrait);
        this.f59822g = headImageView;
        headImageView.setDefaultResource(R.drawable.icon_default_avatar100);
        this.f59822g.setDefaultBgResource(R.color.CAM_X0205);
        this.f59822g.setIsRound(true);
        this.f59823h = (TextView) b(R.id.user_name);
        this.j = (CountDownTextView) b(R.id.count_down_text);
        this.i = (TextView) b(R.id.action);
    }
}

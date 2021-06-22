package d.a.o0.t2.j0;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.widget.CountDownTextView;
import d.a.o0.t2.f0.b.f;
import d.a.o0.t2.y;
/* loaded from: classes5.dex */
public class c extends e {

    /* renamed from: g  reason: collision with root package name */
    public HeadImageView f64998g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f64999h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f65000i;
    public CountDownTextView j;
    public boolean k;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f65001e;

        public a(f fVar) {
            this.f65001e = fVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Context context = c.this.f65007b.getContext();
            String str = this.f65001e.f64897d;
            AdvertAppInfo advertAppInfo = c.this.f65009d;
            y.d(context, str, null, advertAppInfo != null ? advertAppInfo.Q3 : "");
            d.a.o0.t2.i0.c cVar = c.this.f65008c;
            if (cVar != null) {
                cVar.i(302);
                d.a.o0.t2.i0.e.b().d(c.this.f65008c);
            }
            d.a.o0.k1.o.h.b bVar = c.this.f65010e;
            if (bVar != null) {
                d.a.o0.k1.o.h.c.h(bVar);
            }
            c.this.a(false);
        }
    }

    public c(View view, String str) {
        super(view, str);
        m();
    }

    @Override // d.a.o0.t2.j0.e
    public void a(boolean z) {
        this.k = z;
        CountDownTextView countDownTextView = this.j;
        if (countDownTextView != null) {
            countDownTextView.setEnableTimeoutListener(z);
        }
    }

    @Override // d.a.o0.t2.j0.e
    public void c() {
        SkinManager.setViewTextColor(this.f64999h, R.color.CAM_X0101, 1);
        SkinManager.setViewTextColor(this.f65000i, R.color.CAM_X0101, 1);
        SkinManager.setBackgroundResource(this.f65000i, R.drawable.tail_frame_action_btn_bg, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // d.a.o0.t2.j0.e
    public void d(f fVar) {
        super.d(fVar);
        this.f64998g.U(fVar.f64896c, 10, false);
        this.f64999h.setText(fVar.f64895b);
        this.f65000i.setText(fVar.f64898e);
        this.f65007b.setOnClickListener(new a(fVar));
        this.j.f(fVar.f64901h);
        c();
    }

    @Override // d.a.o0.t2.j0.e
    public void e() {
        super.e();
        this.j.e();
    }

    @Override // d.a.o0.t2.j0.e
    public void l(CountDownTextView.c cVar) {
        super.l(cVar);
        this.j.setTimeoutListener(cVar);
    }

    public final void m() {
        HeadImageView headImageView = (HeadImageView) b(R.id.user_portrait);
        this.f64998g = headImageView;
        headImageView.setDefaultResource(R.drawable.icon_default_avatar100);
        this.f64998g.setDefaultBgResource(R.color.CAM_X0205);
        this.f64998g.setIsRound(true);
        this.f64999h = (TextView) b(R.id.user_name);
        this.j = (CountDownTextView) b(R.id.count_down_text);
        this.f65000i = (TextView) b(R.id.action);
    }
}

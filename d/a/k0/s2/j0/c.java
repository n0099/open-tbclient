package d.a.k0.s2.j0;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.widget.CountDownTextView;
import d.a.k0.s2.f0.b.f;
import d.a.k0.s2.y;
/* loaded from: classes5.dex */
public class c extends e {

    /* renamed from: g  reason: collision with root package name */
    public HeadImageView f61079g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f61080h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f61081i;
    public CountDownTextView j;
    public boolean k;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f61082e;

        public a(f fVar) {
            this.f61082e = fVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Context context = c.this.f61088b.getContext();
            String str = this.f61082e.f60978d;
            AdvertAppInfo advertAppInfo = c.this.f61090d;
            y.d(context, str, null, advertAppInfo != null ? advertAppInfo.M3 : "");
            d.a.k0.s2.i0.c cVar = c.this.f61089c;
            if (cVar != null) {
                cVar.i(302);
                d.a.k0.s2.i0.e.b().d(c.this.f61089c);
            }
            d.a.k0.j1.o.h.b bVar = c.this.f61091e;
            if (bVar != null) {
                d.a.k0.j1.o.h.c.h(bVar);
            }
            c.this.a(false);
        }
    }

    public c(View view, String str) {
        super(view, str);
        m();
    }

    @Override // d.a.k0.s2.j0.e
    public void a(boolean z) {
        this.k = z;
        CountDownTextView countDownTextView = this.j;
        if (countDownTextView != null) {
            countDownTextView.setEnableTimeoutListener(z);
        }
    }

    @Override // d.a.k0.s2.j0.e
    public void c() {
        SkinManager.setViewTextColor(this.f61080h, R.color.CAM_X0101, 1);
        SkinManager.setViewTextColor(this.f61081i, R.color.CAM_X0101, 1);
        SkinManager.setBackgroundResource(this.f61081i, R.drawable.tail_frame_action_btn_bg, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // d.a.k0.s2.j0.e
    public void d(f fVar) {
        super.d(fVar);
        this.f61079g.V(fVar.f60977c, 10, false);
        this.f61080h.setText(fVar.f60976b);
        this.f61081i.setText(fVar.f60979e);
        this.f61088b.setOnClickListener(new a(fVar));
        this.j.f(fVar.f60982h);
        c();
    }

    @Override // d.a.k0.s2.j0.e
    public void e() {
        super.e();
        this.j.e();
    }

    @Override // d.a.k0.s2.j0.e
    public void l(CountDownTextView.c cVar) {
        super.l(cVar);
        this.j.setTimeoutListener(cVar);
    }

    public final void m() {
        HeadImageView headImageView = (HeadImageView) b(R.id.user_portrait);
        this.f61079g = headImageView;
        headImageView.setDefaultResource(R.drawable.icon_default_avatar100);
        this.f61079g.setDefaultBgResource(R.color.CAM_X0205);
        this.f61079g.setIsRound(true);
        this.f61080h = (TextView) b(R.id.user_name);
        this.j = (CountDownTextView) b(R.id.count_down_text);
        this.f61081i = (TextView) b(R.id.action);
    }
}

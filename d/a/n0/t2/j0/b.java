package d.a.n0.t2.j0;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import d.a.n0.t2.f0.b.f;
import d.a.n0.t2.y;
/* loaded from: classes5.dex */
public class b extends e {

    /* renamed from: g  reason: collision with root package name */
    public HeadImageView f64868g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f64869h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f64870i;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f64871e;

        public a(f fVar) {
            this.f64871e = fVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Context context = b.this.f64882b.getContext();
            f fVar = this.f64871e;
            String str = fVar.f64772d;
            String str2 = fVar.f64774f;
            AdvertAppInfo advertAppInfo = b.this.f64884d;
            y.d(context, str, str2, advertAppInfo != null ? advertAppInfo.Q3 : "");
            d.a.n0.t2.i0.c cVar = b.this.f64883c;
            if (cVar != null) {
                cVar.i(302);
                d.a.n0.t2.i0.e.b().d(b.this.f64883c);
            }
            d.a.n0.k1.o.h.b bVar = b.this.f64885e;
            if (bVar != null) {
                d.a.n0.k1.o.h.c.h(bVar);
            }
        }
    }

    public b(View view, String str) {
        super(view, str);
        m();
    }

    @Override // d.a.n0.t2.j0.e
    public void c() {
        super.c();
        SkinManager.setViewTextColor(this.f64869h, R.color.CAM_X0620, 1);
        SkinManager.setViewTextColor(this.f64870i, R.color.CAM_X0101, 1);
        SkinManager.setBackgroundResource(this.f64870i, R.drawable.tail_frame_action_btn_bg, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // d.a.n0.t2.j0.e
    public void d(f fVar) {
        super.d(fVar);
        this.f64868g.U(fVar.f64771c, 10, false);
        this.f64869h.setText(fVar.f64770b);
        this.f64870i.setText(fVar.f64773e);
        this.f64882b.setOnClickListener(new a(fVar));
        c();
    }

    public final void m() {
        HeadImageView headImageView = (HeadImageView) b(R.id.user_portrait);
        this.f64868g = headImageView;
        headImageView.setDefaultResource(R.drawable.icon_default_avatar100);
        this.f64868g.setDefaultBgResource(R.color.CAM_X0205);
        this.f64868g.setIsRound(true);
        this.f64869h = (TextView) b(R.id.user_name);
        this.f64870i = (TextView) b(R.id.action);
    }
}

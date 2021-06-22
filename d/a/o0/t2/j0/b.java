package d.a.o0.t2.j0;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import d.a.o0.t2.f0.b.f;
import d.a.o0.t2.y;
/* loaded from: classes5.dex */
public class b extends e {

    /* renamed from: g  reason: collision with root package name */
    public HeadImageView f64993g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f64994h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f64995i;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f64996e;

        public a(f fVar) {
            this.f64996e = fVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Context context = b.this.f65007b.getContext();
            f fVar = this.f64996e;
            String str = fVar.f64897d;
            String str2 = fVar.f64899f;
            AdvertAppInfo advertAppInfo = b.this.f65009d;
            y.d(context, str, str2, advertAppInfo != null ? advertAppInfo.Q3 : "");
            d.a.o0.t2.i0.c cVar = b.this.f65008c;
            if (cVar != null) {
                cVar.i(302);
                d.a.o0.t2.i0.e.b().d(b.this.f65008c);
            }
            d.a.o0.k1.o.h.b bVar = b.this.f65010e;
            if (bVar != null) {
                d.a.o0.k1.o.h.c.h(bVar);
            }
        }
    }

    public b(View view, String str) {
        super(view, str);
        m();
    }

    @Override // d.a.o0.t2.j0.e
    public void c() {
        super.c();
        SkinManager.setViewTextColor(this.f64994h, R.color.CAM_X0620, 1);
        SkinManager.setViewTextColor(this.f64995i, R.color.CAM_X0101, 1);
        SkinManager.setBackgroundResource(this.f64995i, R.drawable.tail_frame_action_btn_bg, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // d.a.o0.t2.j0.e
    public void d(f fVar) {
        super.d(fVar);
        this.f64993g.U(fVar.f64896c, 10, false);
        this.f64994h.setText(fVar.f64895b);
        this.f64995i.setText(fVar.f64898e);
        this.f65007b.setOnClickListener(new a(fVar));
        c();
    }

    public final void m() {
        HeadImageView headImageView = (HeadImageView) b(R.id.user_portrait);
        this.f64993g = headImageView;
        headImageView.setDefaultResource(R.drawable.icon_default_avatar100);
        this.f64993g.setDefaultBgResource(R.color.CAM_X0205);
        this.f64993g.setIsRound(true);
        this.f64994h = (TextView) b(R.id.user_name);
        this.f64995i = (TextView) b(R.id.action);
    }
}

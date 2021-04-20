package d.b.i0.s2.h0;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import d.b.i0.s2.w;
/* loaded from: classes4.dex */
public class b extends e {

    /* renamed from: g  reason: collision with root package name */
    public HeadImageView f61719g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f61720h;
    public TextView i;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.i0.s2.c0.b.e f61721e;

        public a(d.b.i0.s2.c0.b.e eVar) {
            this.f61721e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Context context = b.this.f61731b.getContext();
            d.b.i0.s2.c0.b.e eVar = this.f61721e;
            String str = eVar.f61599d;
            String str2 = eVar.f61601f;
            AdvertAppInfo advertAppInfo = b.this.f61733d;
            w.d(context, str, str2, advertAppInfo != null ? advertAppInfo.T3 : "");
            d.b.i0.s2.f0.c cVar = b.this.f61732c;
            if (cVar != null) {
                cVar.j(302);
                d.b.i0.s2.f0.e.b().d(b.this.f61732c);
            }
            d.b.i0.j1.o.h.b bVar = b.this.f61734e;
            if (bVar != null) {
                d.b.i0.j1.o.h.c.h(bVar);
            }
        }
    }

    public b(View view, String str) {
        super(view, str);
        m();
    }

    @Override // d.b.i0.s2.h0.e
    public void c() {
        super.c();
        SkinManager.setViewTextColor(this.f61720h, R.color.CAM_X0620, 1);
        SkinManager.setViewTextColor(this.i, R.color.CAM_X0101, 1);
        SkinManager.setBackgroundResource(this.i, R.drawable.tail_frame_action_btn_bg, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // d.b.i0.s2.h0.e
    public void d(d.b.i0.s2.c0.b.e eVar) {
        super.d(eVar);
        this.f61719g.W(eVar.f61598c, 10, false);
        this.f61720h.setText(eVar.f61597b);
        this.i.setText(eVar.f61600e);
        this.f61731b.setOnClickListener(new a(eVar));
        c();
    }

    public final void m() {
        HeadImageView headImageView = (HeadImageView) b(R.id.user_portrait);
        this.f61719g = headImageView;
        headImageView.setDefaultResource(R.drawable.icon_default_avatar100);
        this.f61719g.setDefaultBgResource(R.color.CAM_X0205);
        this.f61719g.setIsRound(true);
        this.f61720h = (TextView) b(R.id.user_name);
        this.i = (TextView) b(R.id.action);
    }
}

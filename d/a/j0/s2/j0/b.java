package d.a.j0.s2.j0;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import d.a.j0.s2.x;
/* loaded from: classes5.dex */
public class b extends e {

    /* renamed from: g  reason: collision with root package name */
    public HeadImageView f60339g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f60340h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f60341i;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.j0.s2.e0.b.e f60342e;

        public a(d.a.j0.s2.e0.b.e eVar) {
            this.f60342e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Context context = b.this.f60353b.getContext();
            d.a.j0.s2.e0.b.e eVar = this.f60342e;
            String str = eVar.f60233d;
            String str2 = eVar.f60235f;
            AdvertAppInfo advertAppInfo = b.this.f60355d;
            x.d(context, str, str2, advertAppInfo != null ? advertAppInfo.T3 : "");
            d.a.j0.s2.h0.c cVar = b.this.f60354c;
            if (cVar != null) {
                cVar.j(302);
                d.a.j0.s2.h0.e.b().d(b.this.f60354c);
            }
            d.a.j0.j1.o.h.b bVar = b.this.f60356e;
            if (bVar != null) {
                d.a.j0.j1.o.h.c.h(bVar);
            }
        }
    }

    public b(View view, String str) {
        super(view, str);
        m();
    }

    @Override // d.a.j0.s2.j0.e
    public void c() {
        super.c();
        SkinManager.setViewTextColor(this.f60340h, R.color.CAM_X0620, 1);
        SkinManager.setViewTextColor(this.f60341i, R.color.CAM_X0101, 1);
        SkinManager.setBackgroundResource(this.f60341i, R.drawable.tail_frame_action_btn_bg, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // d.a.j0.s2.j0.e
    public void d(d.a.j0.s2.e0.b.e eVar) {
        super.d(eVar);
        this.f60339g.V(eVar.f60232c, 10, false);
        this.f60340h.setText(eVar.f60231b);
        this.f60341i.setText(eVar.f60234e);
        this.f60353b.setOnClickListener(new a(eVar));
        c();
    }

    public final void m() {
        HeadImageView headImageView = (HeadImageView) b(R.id.user_portrait);
        this.f60339g = headImageView;
        headImageView.setDefaultResource(R.drawable.icon_default_avatar100);
        this.f60339g.setDefaultBgResource(R.color.CAM_X0205);
        this.f60339g.setIsRound(true);
        this.f60340h = (TextView) b(R.id.user_name);
        this.f60341i = (TextView) b(R.id.action);
    }
}

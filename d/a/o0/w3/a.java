package d.a.o0.w3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.widget.OvalActionButton;
import com.baidu.tbadk.widget.layout.GridLayout;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
/* loaded from: classes5.dex */
public abstract class a {

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f66517b;

    /* renamed from: c  reason: collision with root package name */
    public f f66518c;

    /* renamed from: d  reason: collision with root package name */
    public View.OnClickListener f66519d = new View$OnClickListenerC1766a();

    /* renamed from: a  reason: collision with root package name */
    public View f66516a = b();

    /* renamed from: d.a.o0.w3.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC1766a implements View.OnClickListener {
        public View$OnClickListenerC1766a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            f fVar = a.this.f66518c;
            if (fVar != null) {
                if (fVar.g() != 0) {
                    UtilHelper.setNavigationBarBackground(a.this.f66517b.getPageActivity(), a.this.f66518c.g());
                }
                a.this.f66518c.k(true);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b extends a {
        public View A;
        public View B;
        public View C;
        public int D;

        /* renamed from: e  reason: collision with root package name */
        public View f66521e;

        /* renamed from: f  reason: collision with root package name */
        public LinearLayout f66522f;

        /* renamed from: g  reason: collision with root package name */
        public LinearLayout f66523g;

        /* renamed from: h  reason: collision with root package name */
        public LinearLayout f66524h;

        /* renamed from: i  reason: collision with root package name */
        public LinearLayout f66525i;
        public LinearLayout j;
        public LinearLayout k;
        public LinearLayout l;
        public ImageView m;
        public ImageView n;
        public ImageView o;
        public ImageView p;
        public ImageView q;
        public ImageView r;
        public TextView s;
        public TextView t;
        public TextView u;
        public TextView v;
        public TextView w;
        public TextView x;
        public View y;
        public View z;

        /* renamed from: d.a.o0.w3.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class View$OnClickListenerC1767a implements View.OnClickListener {
            public View$OnClickListenerC1767a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.a.o0.w3.f fVar = b.this.f66518c;
                if (fVar != null) {
                    fVar.o(fVar.i());
                }
            }
        }

        /* renamed from: d.a.o0.w3.a$b$b  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class View$OnClickListenerC1768b implements View.OnClickListener {
            public View$OnClickListenerC1768b() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.a.o0.w3.f fVar = b.this.f66518c;
                if (fVar != null) {
                    fVar.n();
                }
            }
        }

        /* loaded from: classes5.dex */
        public class c implements View.OnClickListener {
            public c() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.a.o0.w3.f fVar = b.this.f66518c;
                if (fVar != null) {
                    fVar.s();
                }
            }
        }

        /* loaded from: classes5.dex */
        public class d implements View.OnClickListener {
            public d() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.a.o0.w3.f fVar = b.this.f66518c;
                if (fVar != null) {
                    fVar.m();
                }
            }
        }

        /* loaded from: classes5.dex */
        public class e implements View.OnClickListener {
            public e() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.a.o0.w3.f fVar = b.this.f66518c;
                if (fVar != null) {
                    fVar.t(fVar.i());
                }
            }
        }

        /* loaded from: classes5.dex */
        public class f implements View.OnClickListener {
            public f() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.a.o0.w3.f fVar = b.this.f66518c;
                if (fVar != null) {
                    fVar.u();
                }
            }
        }

        public b(TbPageContext tbPageContext, d.a.o0.w3.f fVar) {
            super(tbPageContext, fVar);
            this.f66521e = this.f66516a.findViewById(R.id.view_background);
            this.f66522f = (LinearLayout) this.f66516a.findViewById(R.id.type_container);
            this.f66523g = (LinearLayout) this.f66516a.findViewById(R.id.thread_text);
            this.m = (ImageView) this.f66516a.findViewById(R.id.thread_text_iv);
            this.s = (TextView) this.f66516a.findViewById(R.id.thread_text_tv);
            this.f66524h = (LinearLayout) this.f66516a.findViewById(R.id.thread_pic);
            this.n = (ImageView) this.f66516a.findViewById(R.id.thread_pic_iv);
            this.t = (TextView) this.f66516a.findViewById(R.id.thread_pic_tv);
            this.f66525i = (LinearLayout) this.f66516a.findViewById(R.id.thread_video);
            this.o = (ImageView) this.f66516a.findViewById(R.id.thread_video_iv);
            this.u = (TextView) this.f66516a.findViewById(R.id.thread_video_tv);
            this.j = (LinearLayout) this.f66516a.findViewById(R.id.thread_ala);
            this.p = (ImageView) this.f66516a.findViewById(R.id.thread_ala_iv);
            this.v = (TextView) this.f66516a.findViewById(R.id.thread_ala_tv);
            this.j.setVisibility(TbSingleton.getInstance().isShowStartLiveEntry() ? 0 : 8);
            this.j.setVisibility(TbSingleton.getInstance().isAuditPackageSwitchOn() ? 0 : 8);
            this.k = (LinearLayout) this.f66516a.findViewById(R.id.thread_vote);
            this.q = (ImageView) this.f66516a.findViewById(R.id.thread_vote_iv);
            this.w = (TextView) this.f66516a.findViewById(R.id.thread_vote_tv);
            this.l = (LinearLayout) this.f66516a.findViewById(R.id.thread_write_score);
            this.r = (ImageView) this.f66516a.findViewById(R.id.thread_write_score_iv);
            this.x = (TextView) this.f66516a.findViewById(R.id.thread_write_score_tv);
            this.y = this.f66516a.findViewById(R.id.line_1);
            this.z = this.f66516a.findViewById(R.id.line_2);
            this.A = this.f66516a.findViewById(R.id.line_3);
            this.B = this.f66516a.findViewById(R.id.line_4);
            this.C = this.f66516a.findViewById(R.id.line_5);
            this.B.setVisibility(TbSingleton.getInstance().isShowStartLiveEntry() ? 0 : 8);
            this.s.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.frs_write_article_title));
            this.t.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.home_write_article_pic));
            this.u.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.home_write_photo_title));
            this.v.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.ala_live));
            this.w.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.frs_write_vote_title));
            this.x.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.evaluate));
            this.f66521e.setOnClickListener(this.f66519d);
            this.f66523g.setOnClickListener(new View$OnClickListenerC1767a());
            this.f66524h.setOnClickListener(new View$OnClickListenerC1768b());
            this.f66525i.setOnClickListener(new c());
            this.j.setOnClickListener(new d());
            this.k.setOnClickListener(new e());
            this.l.setOnClickListener(new f());
            this.D = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds21);
            c(TbadkCoreApplication.getInst().getSkinType());
        }

        @Override // d.a.o0.w3.a
        public View b() {
            return LayoutInflater.from(this.f66517b.getPageActivity()).inflate(R.layout.home_page_test_write_thread_view, (ViewGroup) null);
        }

        @Override // d.a.o0.w3.a
        public void c(int i2) {
            super.c(i2);
            SkinManager.setBackgroundColor(this.f66521e, R.color.CAM_X0603);
            TBSelector.makeDrawableSelector().setShape(0).setType(1).radius(this.D).defaultColor(R.color.CAM_X0701).into(this.f66522f);
            this.m.setImageDrawable(WebPManager.getMaskDrawable(R.drawable.icon_mask_post_text24, WebPManager.ResourceStateType.NORMAL));
            this.n.setImageDrawable(WebPManager.getMaskDrawable(R.drawable.icon_mask_post_image24, WebPManager.ResourceStateType.NORMAL));
            this.o.setImageDrawable(WebPManager.getMaskDrawable(R.drawable.icon_mask_post_photograph24, WebPManager.ResourceStateType.NORMAL));
            this.p.setImageDrawable(WebPManager.getMaskDrawable(R.drawable.icon_mask_post_live24, WebPManager.ResourceStateType.NORMAL));
            this.q.setImageDrawable(WebPManager.getMaskDrawable(R.drawable.icon_mask_post_vote24, WebPManager.ResourceStateType.NORMAL));
            this.r.setImageDrawable(WebPManager.getMaskDrawable(R.drawable.icon_home_publish_grade24, WebPManager.ResourceStateType.NORMAL));
            SkinManager.setViewTextColor(this.s, R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.t, R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.u, R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.v, R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.w, R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.x, R.color.CAM_X0101);
            TBSelector.makeDrawableSelector().setShape(0).setType(1).tlRadius(this.D).trRadius(this.D).into(this.f66523g);
            TBSelector.makeDrawableSelector().setShape(0).setType(1).into(this.f66524h);
            TBSelector.makeDrawableSelector().setShape(0).setType(1).into(this.f66525i);
            TBSelector.makeDrawableSelector().setShape(0).setType(1).into(this.j);
            TBSelector.makeDrawableSelector().setShape(0).setType(1).blRadius(this.D).brRadius(this.D).into(this.k);
            TBSelector.makeDrawableSelector().setShape(0).setType(1).blRadius(this.D).brRadius(this.D).into(this.l);
            SkinManager.setBackgroundColor(this.y, R.color.CAM_X0613);
            SkinManager.setBackgroundColor(this.z, R.color.CAM_X0613);
            SkinManager.setBackgroundColor(this.A, R.color.CAM_X0613);
            SkinManager.setBackgroundColor(this.B, R.color.CAM_X0613);
            SkinManager.setBackgroundColor(this.C, R.color.CAM_X0613);
        }
    }

    /* loaded from: classes5.dex */
    public static class c extends a {
        public TextView A;
        public OvalActionButton B;
        public GridLayout C;
        public TBLottieAnimationView D;

        /* renamed from: e  reason: collision with root package name */
        public View f66532e;

        /* renamed from: f  reason: collision with root package name */
        public View f66533f;

        /* renamed from: g  reason: collision with root package name */
        public LinearLayout f66534g;

        /* renamed from: h  reason: collision with root package name */
        public ImageView f66535h;

        /* renamed from: i  reason: collision with root package name */
        public TextView f66536i;
        public LinearLayout j;
        public ImageView k;
        public TextView l;
        public LinearLayout m;
        public ImageView n;
        public TextView o;
        public LinearLayout p;
        public ImageView q;
        public TextView r;
        public LinearLayout s;
        public ImageView t;
        public TextView u;
        public LinearLayout v;
        public ImageView w;
        public TextView x;
        public LinearLayout y;
        public ImageView z;

        /* renamed from: d.a.o0.w3.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class View$OnClickListenerC1769a implements View.OnClickListener {
            public View$OnClickListenerC1769a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.a.o0.w3.f fVar = c.this.f66518c;
                if (fVar != null) {
                    fVar.o(fVar.i());
                }
            }
        }

        /* loaded from: classes5.dex */
        public class b implements View.OnClickListener {
            public b() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.a.o0.w3.f fVar = c.this.f66518c;
                if (fVar != null) {
                    fVar.s();
                }
            }
        }

        /* renamed from: d.a.o0.w3.a$c$c  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class View$OnClickListenerC1770c implements View.OnClickListener {
            public View$OnClickListenerC1770c() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.a.o0.w3.f fVar = c.this.f66518c;
                if (fVar != null) {
                    fVar.n();
                }
            }
        }

        /* loaded from: classes5.dex */
        public class d implements View.OnClickListener {
            public d() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.a.o0.w3.f fVar = c.this.f66518c;
                if (fVar != null) {
                    fVar.m();
                }
            }
        }

        /* loaded from: classes5.dex */
        public class e implements View.OnClickListener {
            public e() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.a.o0.w3.f fVar = c.this.f66518c;
                if (fVar != null) {
                    fVar.t(fVar.i());
                }
            }
        }

        /* loaded from: classes5.dex */
        public class f implements View.OnClickListener {
            public f() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.a.o0.w3.f fVar = c.this.f66518c;
                if (fVar != null) {
                    fVar.u();
                }
            }
        }

        /* loaded from: classes5.dex */
        public class g implements View.OnClickListener {
            public g() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.a.o0.w3.f fVar = c.this.f66518c;
                if (fVar != null) {
                    fVar.q();
                }
            }
        }

        public c(TbPageContext tbPageContext, d.a.o0.w3.f fVar) {
            super(tbPageContext, fVar);
            if (tbPageContext == null) {
                return;
            }
            this.j = (LinearLayout) this.f66516a.findViewById(R.id.home_write_article);
            this.k = (ImageView) this.f66516a.findViewById(R.id.home_write_article_icon);
            this.l = (TextView) this.f66516a.findViewById(R.id.home_write_article_title);
            this.f66534g = (LinearLayout) this.f66516a.findViewById(R.id.home_write_photo);
            this.f66535h = (ImageView) this.f66516a.findViewById(R.id.home_write_photo_icon);
            this.f66536i = (TextView) this.f66516a.findViewById(R.id.home_write_photo_title);
            this.m = (LinearLayout) this.f66516a.findViewById(R.id.home_write_album);
            this.n = (ImageView) this.f66516a.findViewById(R.id.home_write_album_icon);
            this.o = (TextView) this.f66516a.findViewById(R.id.home_write_album_title);
            this.p = (LinearLayout) this.f66516a.findViewById(R.id.home_write_live);
            this.q = (ImageView) this.f66516a.findViewById(R.id.home_write_live_icon);
            this.r = (TextView) this.f66516a.findViewById(R.id.home_write_live_title);
            this.p.setVisibility(TbSingleton.getInstance().isShowStartLiveEntry() ? 0 : 8);
            this.s = (LinearLayout) this.f66516a.findViewById(R.id.home_write_vote);
            this.t = (ImageView) this.f66516a.findViewById(R.id.home_write_vote_icon);
            this.u = (TextView) this.f66516a.findViewById(R.id.home_write_vote_title);
            ((LinearLayout.LayoutParams) this.t.getLayoutParams()).topMargin = TbSingleton.getInstance().isShowStartLiveEntry() ? ((LinearLayout.LayoutParams) this.t.getLayoutParams()).topMargin : 0;
            this.v = (LinearLayout) this.f66516a.findViewById(R.id.home_write_score);
            this.w = (ImageView) this.f66516a.findViewById(R.id.home_write_score_icon);
            this.x = (TextView) this.f66516a.findViewById(R.id.home_write_score_title);
            this.y = (LinearLayout) this.f66516a.findViewById(R.id.home_write_commodity);
            this.z = (ImageView) this.f66516a.findViewById(R.id.home_write_commodity_icon);
            this.A = (TextView) this.f66516a.findViewById(R.id.home_write_commodity_title);
            this.B = (OvalActionButton) this.f66516a.findViewById(R.id.write_close_view);
            d.a.o0.w3.f fVar2 = this.f66518c;
            if (fVar2 != null && "frs".equals(fVar2.h())) {
                this.B.setIsCircle(true);
                this.B.setHasShadow(false);
            }
            this.f66533f = this.f66516a.findViewById(R.id.view_background_white);
            this.f66532e = this.f66516a.findViewById(R.id.view_background_translate);
            GridLayout gridLayout = (GridLayout) this.f66516a.findViewById(R.id.type_container);
            this.C = gridLayout;
            gridLayout.setMeasureAllChild(true);
            this.C.setVerNum(2);
            TBLottieAnimationView tBLottieAnimationView = (TBLottieAnimationView) this.f66516a.findViewById(R.id.bottom_bar_background);
            this.D = tBLottieAnimationView;
            tBLottieAnimationView.setSpeed(1.2f);
            a();
            this.f66532e.setOnClickListener(this.f66519d);
            this.f66532e.setClickable(true);
            this.k.setOnClickListener(new View$OnClickListenerC1769a());
            this.f66535h.setOnClickListener(new b());
            this.n.setOnClickListener(new View$OnClickListenerC1770c());
            this.q.setOnClickListener(new d());
            this.s.setOnClickListener(new e());
            this.v.setOnClickListener(new f());
            this.y.setOnClickListener(new g());
        }

        @Override // d.a.o0.w3.a
        public void a() {
            float k = l.k(this.f66517b.getPageActivity());
            int i2 = (int) (0.13518518f * k);
            d(this.k, i2);
            d(this.f66535h, i2);
            d(this.n, i2);
            d(this.q, i2);
            d(this.t, i2);
            d(this.w, i2);
            d(this.z, i2);
            float g2 = (k * 1.0f) / l.g(TbadkCoreApplication.getInst(), R.dimen.tbds1080);
            ViewGroup.LayoutParams layoutParams = this.C.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = (int) (l.g(TbadkCoreApplication.getInst(), R.dimen.tbds423) * g2);
                this.C.setLayoutParams(layoutParams);
            }
            ViewGroup.LayoutParams layoutParams2 = this.f66533f.getLayoutParams();
            if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
                int g3 = (int) (l.g(TbadkCoreApplication.getInst(), R.dimen.tbds1023) * g2);
                if (g3 <= 0) {
                    g3 = 1023;
                }
                ((RelativeLayout.LayoutParams) layoutParams2).height = g3;
                this.f66533f.setLayoutParams(layoutParams2);
            }
            ViewGroup.LayoutParams layoutParams3 = this.D.getLayoutParams();
            if (layoutParams3 instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) layoutParams3).height = (int) ((l.g(TbadkCoreApplication.getInst(), R.dimen.tbds800) * g2) - ((l.g(TbadkCoreApplication.getInst(), R.dimen.tbds135) * g2) - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()));
                this.D.setLayoutParams(layoutParams3);
            }
        }

        @Override // d.a.o0.w3.a
        public View b() {
            return LayoutInflater.from(this.f66517b.getPageActivity()).inflate(R.layout.bottom_write_thread, (ViewGroup) null);
        }

        @Override // d.a.o0.w3.a
        public void c(int i2) {
            this.B.e(i2);
            SkinManager.setLottieAnimation(this.D, R.raw.bottom_bar_bg);
            SkinManager.setBackgroundResource(this.f66533f, R.drawable.write_tab_background);
            SkinManager.setImageResource(this.f66535h, R.drawable.icon_mask_post_photograph56);
            SkinManager.setImageResource(this.k, R.drawable.icon_mask_post_text56);
            SkinManager.setImageResource(this.n, R.drawable.icon_mask_post_image56);
            SkinManager.setImageResource(this.q, R.drawable.icon_mask_post_live56);
            SkinManager.setImageResource(this.t, R.drawable.icon_mask_post_vote56);
            SkinManager.setImageResource(this.w, R.drawable.icon_mask_post_evaluation56);
            SkinManager.setImageResource(this.z, R.drawable.icon_mask_post_goods56);
            SkinManager.setViewTextColor(this.f66536i, R.color.CAM_X0107);
            SkinManager.setViewTextColor(this.l, R.color.CAM_X0107);
            SkinManager.setViewTextColor(this.o, R.color.CAM_X0107);
            SkinManager.setViewTextColor(this.r, R.color.CAM_X0107);
            SkinManager.setViewTextColor(this.u, R.color.CAM_X0107);
            SkinManager.setViewTextColor(this.x, R.color.CAM_X0107);
            SkinManager.setViewTextColor(this.A, R.color.CAM_X0107);
        }

        public final void d(ImageView imageView, int i2) {
            if (imageView == null || i2 <= 0) {
                return;
            }
            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
            layoutParams.width = i2;
            layoutParams.height = i2;
            imageView.setLayoutParams(layoutParams);
        }

        public void e(boolean z) {
        }
    }

    public a(TbPageContext tbPageContext, f fVar) {
        this.f66517b = tbPageContext;
        this.f66518c = fVar;
    }

    public void a() {
    }

    public abstract View b();

    public void c(int i2) {
    }
}

package d.b.i0.u3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.widget.OvalActionButton;
import com.baidu.tbadk.widget.layout.GridLayout;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import d.b.b.e.p.l;
/* loaded from: classes5.dex */
public abstract class a {

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f61439b;

    /* renamed from: c  reason: collision with root package name */
    public g f61440c;

    /* renamed from: d  reason: collision with root package name */
    public View.OnClickListener f61441d = new View$OnClickListenerC1603a();

    /* renamed from: a  reason: collision with root package name */
    public View f61438a = b();

    /* renamed from: d.b.i0.u3.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC1603a implements View.OnClickListener {
        public View$OnClickListenerC1603a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            g gVar = a.this.f61440c;
            if (gVar != null) {
                if (gVar.j() != 0) {
                    UtilHelper.setNavigationBarBackground(a.this.f61439b.getPageActivity(), a.this.f61440c.j());
                }
                a.this.f61440c.n(true);
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
        public View f61443e;

        /* renamed from: f  reason: collision with root package name */
        public LinearLayout f61444f;

        /* renamed from: g  reason: collision with root package name */
        public LinearLayout f61445g;

        /* renamed from: h  reason: collision with root package name */
        public LinearLayout f61446h;
        public LinearLayout i;
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

        /* renamed from: d.b.i0.u3.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class View$OnClickListenerC1604a implements View.OnClickListener {
            public View$OnClickListenerC1604a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g gVar = b.this.f61440c;
                if (gVar != null) {
                    gVar.r(gVar.l());
                }
            }
        }

        /* renamed from: d.b.i0.u3.a$b$b  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class View$OnClickListenerC1605b implements View.OnClickListener {
            public View$OnClickListenerC1605b() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g gVar = b.this.f61440c;
                if (gVar != null) {
                    gVar.q();
                }
            }
        }

        /* loaded from: classes5.dex */
        public class c implements View.OnClickListener {
            public c() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g gVar = b.this.f61440c;
                if (gVar != null) {
                    gVar.v();
                }
            }
        }

        /* loaded from: classes5.dex */
        public class d implements View.OnClickListener {
            public d() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g gVar = b.this.f61440c;
                if (gVar != null) {
                    gVar.p();
                }
            }
        }

        /* loaded from: classes5.dex */
        public class e implements View.OnClickListener {
            public e() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g gVar = b.this.f61440c;
                if (gVar != null) {
                    gVar.w(gVar.l());
                }
            }
        }

        /* loaded from: classes5.dex */
        public class f implements View.OnClickListener {
            public f() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g gVar = b.this.f61440c;
                if (gVar != null) {
                    gVar.x();
                }
            }
        }

        public b(TbPageContext tbPageContext, g gVar) {
            super(tbPageContext, gVar);
            this.f61443e = this.f61438a.findViewById(R.id.view_background);
            this.f61444f = (LinearLayout) this.f61438a.findViewById(R.id.type_container);
            this.f61445g = (LinearLayout) this.f61438a.findViewById(R.id.thread_text);
            this.m = (ImageView) this.f61438a.findViewById(R.id.thread_text_iv);
            this.s = (TextView) this.f61438a.findViewById(R.id.thread_text_tv);
            this.f61446h = (LinearLayout) this.f61438a.findViewById(R.id.thread_pic);
            this.n = (ImageView) this.f61438a.findViewById(R.id.thread_pic_iv);
            this.t = (TextView) this.f61438a.findViewById(R.id.thread_pic_tv);
            this.i = (LinearLayout) this.f61438a.findViewById(R.id.thread_video);
            this.o = (ImageView) this.f61438a.findViewById(R.id.thread_video_iv);
            this.u = (TextView) this.f61438a.findViewById(R.id.thread_video_tv);
            this.j = (LinearLayout) this.f61438a.findViewById(R.id.thread_ala);
            this.p = (ImageView) this.f61438a.findViewById(R.id.thread_ala_iv);
            this.v = (TextView) this.f61438a.findViewById(R.id.thread_ala_tv);
            this.k = (LinearLayout) this.f61438a.findViewById(R.id.thread_vote);
            this.q = (ImageView) this.f61438a.findViewById(R.id.thread_vote_iv);
            this.w = (TextView) this.f61438a.findViewById(R.id.thread_vote_tv);
            this.l = (LinearLayout) this.f61438a.findViewById(R.id.thread_write_score);
            this.r = (ImageView) this.f61438a.findViewById(R.id.thread_write_score_iv);
            this.x = (TextView) this.f61438a.findViewById(R.id.thread_write_score_tv);
            this.y = this.f61438a.findViewById(R.id.line_1);
            this.z = this.f61438a.findViewById(R.id.line_2);
            this.A = this.f61438a.findViewById(R.id.line_3);
            this.B = this.f61438a.findViewById(R.id.line_4);
            this.C = this.f61438a.findViewById(R.id.line_5);
            this.s.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.frs_write_article_title));
            this.t.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.home_write_article_pic));
            this.u.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.home_write_photo_title));
            this.v.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.ala_live));
            this.w.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.frs_write_vote_title));
            this.x.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.evaluate));
            this.f61443e.setOnClickListener(this.f61441d);
            this.f61445g.setOnClickListener(new View$OnClickListenerC1604a());
            this.f61446h.setOnClickListener(new View$OnClickListenerC1605b());
            this.i.setOnClickListener(new c());
            this.j.setOnClickListener(new d());
            this.k.setOnClickListener(new e());
            this.l.setOnClickListener(new f());
            this.D = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds21);
            c(TbadkCoreApplication.getInst().getSkinType());
        }

        @Override // d.b.i0.u3.a
        public View b() {
            return LayoutInflater.from(this.f61439b.getPageActivity()).inflate(R.layout.home_page_test_write_thread_view, (ViewGroup) null);
        }

        @Override // d.b.i0.u3.a
        public void c(int i) {
            super.c(i);
            SkinManager.setBackgroundColor(this.f61443e, R.color.CAM_X0603);
            TBSelector.makeDrawableSelector().setShape(0).setType(1).radius(this.D).defaultColor(R.color.CAM_X0701).into(this.f61444f);
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
            TBSelector.makeDrawableSelector().setShape(0).setType(1).tlRadius(this.D).trRadius(this.D).into(this.f61445g);
            TBSelector.makeDrawableSelector().setShape(0).setType(1).into(this.f61446h);
            TBSelector.makeDrawableSelector().setShape(0).setType(1).into(this.i);
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

        /* renamed from: e  reason: collision with root package name */
        public View f61453e;

        /* renamed from: f  reason: collision with root package name */
        public View f61454f;

        /* renamed from: g  reason: collision with root package name */
        public TBLottieAnimationView f61455g;

        /* renamed from: h  reason: collision with root package name */
        public RelativeLayout f61456h;
        public View i;
        public View j;
        public View k;
        public View l;
        public View m;
        public View n;

        /* renamed from: d.b.i0.u3.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class View$OnClickListenerC1606a implements View.OnClickListener {
            public View$OnClickListenerC1606a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g gVar = c.this.f61440c;
                if (gVar != null) {
                    gVar.r(gVar.l());
                }
            }
        }

        /* loaded from: classes5.dex */
        public class b implements View.OnClickListener {
            public b() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g gVar = c.this.f61440c;
                if (gVar != null) {
                    gVar.q();
                }
            }
        }

        /* renamed from: d.b.i0.u3.a$c$c  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class View$OnClickListenerC1607c implements View.OnClickListener {
            public View$OnClickListenerC1607c() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g gVar = c.this.f61440c;
                if (gVar != null) {
                    gVar.v();
                }
            }
        }

        /* loaded from: classes5.dex */
        public class d implements View.OnClickListener {
            public d() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g gVar = c.this.f61440c;
                if (gVar != null) {
                    gVar.p();
                }
            }
        }

        public c(TbPageContext tbPageContext, g gVar) {
            super(tbPageContext, gVar);
            this.f61453e = this.f61438a.findViewById(R.id.transparent_back_view);
            this.f61454f = this.f61438a.findViewById(R.id.view_background);
            this.f61455g = (TBLottieAnimationView) this.f61438a.findViewById(R.id.bottom_bar_background);
            this.f61456h = (RelativeLayout) this.f61438a.findViewById(R.id.type_container);
            this.i = this.f61438a.findViewById(R.id.closeView);
            this.j = this.f61438a.findViewById(R.id.publish_text_view);
            this.k = this.f61438a.findViewById(R.id.publish_image_view);
            this.l = this.f61438a.findViewById(R.id.publish_video_view);
            this.m = this.f61438a.findViewById(R.id.publish_ala_view);
            this.n = this.f61438a.findViewById(R.id.publish_ala_view_tip);
            this.f61454f.setOnClickListener(this.f61441d);
            this.f61456h.setOnClickListener(this.f61441d);
            this.i.setOnClickListener(this.f61441d);
            this.j.setOnClickListener(new View$OnClickListenerC1606a());
            this.k.setOnClickListener(new b());
            this.l.setOnClickListener(new View$OnClickListenerC1607c());
            this.m.setOnClickListener(new d());
            d(false);
            this.f61455g.setSpeed(1.4f);
        }

        @Override // d.b.i0.u3.a
        public View b() {
            return LayoutInflater.from(this.f61439b.getPageActivity()).inflate(R.layout.home_page_bottom_write_thread, (ViewGroup) null);
        }

        @Override // d.b.i0.u3.a
        public void c(int i) {
            SkinManager.setLottieAnimation(this.f61455g, R.raw.lottie_use_publish_n);
            SkinManager.setBackgroundResource(this.f61454f, R.color.CAM_X0502);
            SkinManager.setBackgroundResource(this.n, R.drawable.home_publish_ala_red_tip);
        }

        public void d(boolean z) {
            this.f61454f.setClickable(z);
            this.f61456h.setClickable(z);
            this.i.setClickable(z);
            this.j.setClickable(z);
            this.k.setClickable(z);
            this.l.setClickable(z);
            this.m.setClickable(z);
        }

        public void e(boolean z) {
            View view = this.n;
            if (view == null) {
                return;
            }
            if (z) {
                view.setVisibility(0);
            } else {
                view.setVisibility(8);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class d extends a {
        public TextView A;
        public OvalActionButton B;
        public GridLayout C;
        public TBLottieAnimationView D;

        /* renamed from: e  reason: collision with root package name */
        public View f61461e;

        /* renamed from: f  reason: collision with root package name */
        public View f61462f;

        /* renamed from: g  reason: collision with root package name */
        public LinearLayout f61463g;

        /* renamed from: h  reason: collision with root package name */
        public ImageView f61464h;
        public TextView i;
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

        /* renamed from: d.b.i0.u3.a$d$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class View$OnClickListenerC1608a implements View.OnClickListener {
            public View$OnClickListenerC1608a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.b.i0.u3.g gVar = d.this.f61440c;
                if (gVar != null) {
                    gVar.r(gVar.l());
                }
            }
        }

        /* loaded from: classes5.dex */
        public class b implements View.OnClickListener {
            public b() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.b.i0.u3.g gVar = d.this.f61440c;
                if (gVar != null) {
                    gVar.v();
                }
            }
        }

        /* loaded from: classes5.dex */
        public class c implements View.OnClickListener {
            public c() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.b.i0.u3.g gVar = d.this.f61440c;
                if (gVar != null) {
                    gVar.q();
                }
            }
        }

        /* renamed from: d.b.i0.u3.a$d$d  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class View$OnClickListenerC1609d implements View.OnClickListener {
            public View$OnClickListenerC1609d() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.b.i0.u3.g gVar = d.this.f61440c;
                if (gVar != null) {
                    gVar.p();
                }
            }
        }

        /* loaded from: classes5.dex */
        public class e implements View.OnClickListener {
            public e() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.b.i0.u3.g gVar = d.this.f61440c;
                if (gVar != null) {
                    gVar.w(gVar.l());
                }
            }
        }

        /* loaded from: classes5.dex */
        public class f implements View.OnClickListener {
            public f() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.b.i0.u3.g gVar = d.this.f61440c;
                if (gVar != null) {
                    gVar.x();
                }
            }
        }

        /* loaded from: classes5.dex */
        public class g implements View.OnClickListener {
            public g() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.b.i0.u3.g gVar = d.this.f61440c;
                if (gVar != null) {
                    gVar.t();
                }
            }
        }

        public d(TbPageContext tbPageContext, d.b.i0.u3.g gVar) {
            super(tbPageContext, gVar);
            if (tbPageContext == null) {
                return;
            }
            this.j = (LinearLayout) this.f61438a.findViewById(R.id.home_write_article);
            this.k = (ImageView) this.f61438a.findViewById(R.id.home_write_article_icon);
            this.l = (TextView) this.f61438a.findViewById(R.id.home_write_article_title);
            this.f61463g = (LinearLayout) this.f61438a.findViewById(R.id.home_write_photo);
            this.f61464h = (ImageView) this.f61438a.findViewById(R.id.home_write_photo_icon);
            this.i = (TextView) this.f61438a.findViewById(R.id.home_write_photo_title);
            this.m = (LinearLayout) this.f61438a.findViewById(R.id.home_write_album);
            this.n = (ImageView) this.f61438a.findViewById(R.id.home_write_album_icon);
            this.o = (TextView) this.f61438a.findViewById(R.id.home_write_album_title);
            this.p = (LinearLayout) this.f61438a.findViewById(R.id.home_write_live);
            this.q = (ImageView) this.f61438a.findViewById(R.id.home_write_live_icon);
            this.r = (TextView) this.f61438a.findViewById(R.id.home_write_live_title);
            this.s = (LinearLayout) this.f61438a.findViewById(R.id.home_write_vote);
            this.t = (ImageView) this.f61438a.findViewById(R.id.home_write_vote_icon);
            this.u = (TextView) this.f61438a.findViewById(R.id.home_write_vote_title);
            this.v = (LinearLayout) this.f61438a.findViewById(R.id.home_write_score);
            this.w = (ImageView) this.f61438a.findViewById(R.id.home_write_score_icon);
            this.x = (TextView) this.f61438a.findViewById(R.id.home_write_score_title);
            this.y = (LinearLayout) this.f61438a.findViewById(R.id.home_write_commodity);
            this.z = (ImageView) this.f61438a.findViewById(R.id.home_write_commodity_icon);
            this.A = (TextView) this.f61438a.findViewById(R.id.home_write_commodity_title);
            this.B = (OvalActionButton) this.f61438a.findViewById(R.id.write_close_view);
            d.b.i0.u3.g gVar2 = this.f61440c;
            if (gVar2 != null && "frs".equals(gVar2.k())) {
                this.B.setIsCircle(true);
                this.B.setHasShadow(false);
            }
            this.f61462f = this.f61438a.findViewById(R.id.view_background_white);
            this.f61461e = this.f61438a.findViewById(R.id.view_background_translate);
            GridLayout gridLayout = (GridLayout) this.f61438a.findViewById(R.id.type_container);
            this.C = gridLayout;
            gridLayout.setMeasureAllChild(true);
            this.C.setVerNum(2);
            TBLottieAnimationView tBLottieAnimationView = (TBLottieAnimationView) this.f61438a.findViewById(R.id.bottom_bar_background);
            this.D = tBLottieAnimationView;
            tBLottieAnimationView.setSpeed(1.2f);
            a();
            this.f61461e.setOnClickListener(this.f61441d);
            this.f61461e.setClickable(true);
            this.k.setOnClickListener(new View$OnClickListenerC1608a());
            this.f61464h.setOnClickListener(new b());
            this.n.setOnClickListener(new c());
            this.q.setOnClickListener(new View$OnClickListenerC1609d());
            this.s.setOnClickListener(new e());
            this.v.setOnClickListener(new f());
            this.y.setOnClickListener(new g());
        }

        @Override // d.b.i0.u3.a
        public void a() {
            float k = l.k(this.f61439b.getPageActivity());
            int i = (int) (0.13518518f * k);
            d(this.k, i);
            d(this.f61464h, i);
            d(this.n, i);
            d(this.q, i);
            d(this.t, i);
            d(this.w, i);
            d(this.z, i);
            float g2 = (k * 1.0f) / l.g(TbadkCoreApplication.getInst(), R.dimen.tbds1080);
            ViewGroup.LayoutParams layoutParams = this.C.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = (int) (l.g(TbadkCoreApplication.getInst(), R.dimen.tbds423) * g2);
                this.C.setLayoutParams(layoutParams);
            }
            ViewGroup.LayoutParams layoutParams2 = this.f61462f.getLayoutParams();
            if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
                int g3 = (int) (l.g(TbadkCoreApplication.getInst(), R.dimen.tbds1023) * g2);
                if (g3 <= 0) {
                    g3 = 1023;
                }
                ((RelativeLayout.LayoutParams) layoutParams2).height = g3;
                this.f61462f.setLayoutParams(layoutParams2);
            }
            ViewGroup.LayoutParams layoutParams3 = this.D.getLayoutParams();
            if (layoutParams3 instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) layoutParams3).height = (int) ((l.g(TbadkCoreApplication.getInst(), R.dimen.tbds800) * g2) - ((l.g(TbadkCoreApplication.getInst(), R.dimen.tbds135) * g2) - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()));
                this.D.setLayoutParams(layoutParams3);
            }
        }

        @Override // d.b.i0.u3.a
        public View b() {
            return LayoutInflater.from(this.f61439b.getPageActivity()).inflate(R.layout.bottom_write_thread, (ViewGroup) null);
        }

        @Override // d.b.i0.u3.a
        public void c(int i) {
            this.B.e(i);
            SkinManager.setLottieAnimation(this.D, R.raw.bottom_bar_bg);
            SkinManager.setBackgroundResource(this.f61462f, R.drawable.write_tab_background);
            SkinManager.setImageResource(this.f61464h, R.drawable.icon_mask_post_photograph56);
            SkinManager.setImageResource(this.k, R.drawable.icon_mask_post_text56);
            SkinManager.setImageResource(this.n, R.drawable.icon_mask_post_image56);
            SkinManager.setImageResource(this.q, R.drawable.icon_mask_post_live56);
            SkinManager.setImageResource(this.t, R.drawable.icon_mask_post_vote56);
            SkinManager.setImageResource(this.w, R.drawable.icon_mask_post_evaluation56);
            SkinManager.setImageResource(this.z, R.drawable.icon_mask_post_goods56);
            SkinManager.setViewTextColor(this.i, R.color.CAM_X0107);
            SkinManager.setViewTextColor(this.l, R.color.CAM_X0107);
            SkinManager.setViewTextColor(this.o, R.color.CAM_X0107);
            SkinManager.setViewTextColor(this.r, R.color.CAM_X0107);
            SkinManager.setViewTextColor(this.u, R.color.CAM_X0107);
            SkinManager.setViewTextColor(this.x, R.color.CAM_X0107);
            SkinManager.setViewTextColor(this.A, R.color.CAM_X0107);
        }

        public final void d(ImageView imageView, int i) {
            if (imageView == null || i <= 0) {
                return;
            }
            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i;
            imageView.setLayoutParams(layoutParams);
        }

        public void e(boolean z) {
        }
    }

    public a(TbPageContext tbPageContext, g gVar) {
        this.f61439b = tbPageContext;
        this.f61440c = gVar;
    }

    public void a() {
    }

    public abstract View b();

    public void c(int i) {
    }
}

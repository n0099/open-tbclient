package d.b.i0.i0.m;

import android.graphics.Rect;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.R;
import d.b.b.e.p.l;
import d.b.h0.r.q.n1;
import d.b.h0.r.q.w;
/* loaded from: classes4.dex */
public class c extends d.b.h0.g0.f.a<w, d.b.i0.i0.d.c> {
    public View k;
    public TextView l;
    public TextView m;
    public TextView n;
    public TextView o;
    public TextView p;
    public ImageView q;
    public ImageView r;
    public TextView s;
    public BarImageView t;
    public TextView u;
    public ViewEventCenter v;
    public View w;
    public TextView x;
    public View y;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.i0.i0.d.f f55788e;

        public a(d.b.i0.i0.d.f fVar) {
            this.f55788e = fVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log("c13386");
            c.this.v.dispatchMvcEvent(new d.b.h0.g0.c.b(15, this.f55788e, null, null));
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ w f55790e;

        public b(w wVar) {
            this.f55790e = wVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Bundle bundle = new Bundle();
            bundle.putParcelable("info_forum_image_rect", c.this.r());
            bundle.putParcelable("info_forum_name_rect", c.this.s());
            d.b.h0.g0.c.b bVar = new d.b.h0.g0.c.b(1, this.f55790e, null, null);
            bVar.g(bundle);
            c.this.v.dispatchMvcEvent(bVar);
        }
    }

    /* renamed from: d.b.i0.i0.m.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnLongClickListenerC1297c implements View.OnLongClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ w f55792e;

        public View$OnLongClickListenerC1297c(w wVar) {
            this.f55792e = wVar;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            c.this.v.dispatchMvcEvent(new d.b.h0.g0.c.b(12, this.f55792e, null, null));
            return true;
        }
    }

    /* loaded from: classes4.dex */
    public class d implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TextView f55794e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f55795f;

        public d(TextView textView, int i) {
            this.f55794e = textView;
            this.f55795f = i;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            int k;
            if (!(this.f55794e.getParent() instanceof ViewGroup) || (k = l.k(c.this.b())) == 0) {
                return;
            }
            this.f55794e.setMaxWidth(k - (this.f55795f + l.g(TbadkCoreApplication.getInst(), R.dimen.tbds452)));
            this.f55794e.postInvalidate();
            this.f55794e.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        }
    }

    public c(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.v = viewEventCenter;
        View findViewById = view.findViewById(R.id.rootview);
        this.k = findViewById;
        this.l = (TextView) findViewById.findViewById(R.id.name);
        this.m = (TextView) this.k.findViewById(R.id.live_label);
        this.n = (TextView) this.k.findViewById(R.id.pinpai_label);
        this.o = (TextView) this.k.findViewById(R.id.trial_label);
        this.p = (TextView) this.k.findViewById(R.id.edit_btn_label);
        this.q = (ImageView) this.k.findViewById(R.id.sign);
        this.r = (ImageView) this.k.findViewById(R.id.grade);
        this.s = (TextView) this.k.findViewById(R.id.owner_flag);
        this.w = this.k.findViewById(R.id.enterforum_item_divider);
        this.x = (TextView) this.k.findViewById(R.id.tv_add_love);
        this.t = (BarImageView) this.k.findViewById(R.id.forum_avatar);
        this.y = this.k.findViewById(R.id.forum_top_divider);
        this.u = (TextView) this.k.findViewById(R.id.forum_intro);
        this.t.setPlaceHolder(1);
        this.t.setStrokeColorResId(R.color.CAM_X0201);
    }

    @Override // d.b.i0.c3.t
    public boolean onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        d.b.h0.s0.a.a(tbPageContext, g());
        return true;
    }

    public final Rect r() {
        Rect rect = new Rect();
        this.t.getGlobalVisibleRect(rect);
        return rect;
    }

    public final Rect s() {
        Rect rect = new Rect();
        this.l.getGlobalVisibleRect(rect);
        return rect;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.h0.g0.f.e
    /* renamed from: t */
    public void k(w wVar) {
        super.k(wVar);
        if (wVar == null) {
            return;
        }
        w(wVar);
        SkinManager.setBackgroundColor(this.w, R.color.CAM_X0205);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.q, R.drawable.icon_pure_ba_checkedin16_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
        SkinManager.setViewTextColor(this.l, R.color.CAM_X0105);
    }

    public final void u(TextView textView, int i) {
        if (textView == null) {
            return;
        }
        textView.getViewTreeObserver().addOnGlobalLayoutListener(new d(textView, i));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.h0.g0.f.e
    /* renamed from: v */
    public void m(d.b.i0.i0.d.c cVar) {
        super.m(cVar);
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842910, 16842919}, SkinManager.getDrawable(R.color.CAM_X0204));
        stateListDrawable.addState(new int[0], SkinManager.getDrawable(R.color.CAM_X0205).mutate());
        this.k.setBackgroundDrawable(stateListDrawable);
        this.t.setPlaceHolder(1);
    }

    public final void w(w wVar) {
        int i;
        if (wVar == null) {
            return;
        }
        d.b.i0.i0.d.c cVar = (d.b.i0.i0.d.c) h();
        this.k.setBackgroundDrawable(SkinManager.getColorDrawableWithClickState(R.color.CAM_X0205));
        int i2 = 0;
        this.k.setVisibility(0);
        this.l.setVisibility(0);
        if (wVar instanceof d.b.i0.i0.d.f) {
            d.b.i0.i0.d.f fVar = (d.b.i0.i0.d.f) wVar;
            this.l.setText(fVar.G());
            this.q.setVisibility(fVar.Q() == 0 ? 8 : 0);
            if (fVar.F() == 0) {
                this.r.setVisibility(8);
            } else {
                this.r.setVisibility(0);
                SkinManager.setImageResource(this.r, BitmapHelper.getGradeResourceIdInEnterForum(fVar.F()));
            }
            this.t.setShowOval(true);
            this.t.W(fVar.B(), 10, false);
            this.t.setShowOuterBorder(false);
            this.t.setShowInnerBorder(true);
            this.t.setStrokeWith(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.t.setStrokeColorResId(R.color.CAM_X0401);
            if (fVar.E() > 0) {
                SkinManager.setBackgroundColor(this.y, R.color.CAM_X0302);
            } else {
                SkinManager.setBackgroundColor(this.y, R.color.transparent);
            }
            if (!fVar.K().isEmpty()) {
                this.u.setText(fVar.K());
            }
            SkinManager.setViewTextColor(this.u, R.color.CAM_X0109);
            if (f().getString(R.string.ala_follow_live_enter_live_square_txt).equals(fVar.G())) {
                TiebaStatic.log(new StatisticItem("c12887"));
            }
            this.s.setVisibility((fVar.O() == 1 && fVar.P() == 1) ? 0 : 8);
            if (fVar.M() == 1) {
                this.n.setVisibility(0);
                this.n.setText(R.string.brand_label_ba_text);
                SkinManager.setBackgroundResource(this.n, R.drawable.enter_forum_brand_label_bg_shape);
                SkinManager.setViewTextColor(this.n, R.color.CAM_X0101);
                this.m.setVisibility(8);
            } else {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2911007, Boolean.class, Long.valueOf(d.b.b.e.m.b.f(fVar.D(), 0L)));
                if (runTask != null && ((Boolean) runTask.getData()).booleanValue()) {
                    this.m.setVisibility(0);
                    this.m.setText("");
                    SkinManager.setBackgroundResource(this.m, R.drawable.icon_ba_list_live);
                    SkinManager.setViewTextColor(this.m, R.color.CAM_X0111);
                } else {
                    this.m.setVisibility(8);
                }
                this.n.setVisibility(8);
            }
            if (fVar.R()) {
                this.o.setVisibility(0);
                i = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds122) + 0;
            } else {
                this.o.setVisibility(8);
                i = 0;
            }
            if (fVar.N()) {
                this.p.setVisibility(0);
                i += l.g(TbadkCoreApplication.getInst(), R.dimen.tbds200);
            } else {
                this.p.setVisibility(8);
            }
            i2 = i;
            this.p.setOnClickListener(new a(fVar));
        } else if (wVar instanceof n1) {
            n1 n1Var = (n1) wVar;
            this.l.setText(n1Var.D());
            this.q.setVisibility(8);
            this.r.setVisibility(8);
            if (f().getString(R.string.ala_follow_live_enter_live_square_txt).equals(n1Var.D())) {
                TiebaStatic.log(new StatisticItem("c12887"));
            }
        }
        SkinManager.setBackgroundResource(this.s, R.drawable.icon_owner_bg);
        SkinManager.setViewTextColor(this.s, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.l, R.color.CAM_X0105);
        this.x.setVisibility(8);
        this.k.setOnClickListener(new b(wVar));
        this.k.setOnLongClickListener(new View$OnLongClickListenerC1297c(wVar));
        u(this.l, i2);
    }
}

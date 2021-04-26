package d.a.j0.a1.b;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.framework.indicator.StickyAppBarLayout;
import d.a.i0.z0.l;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public Context f50406a;

    /* renamed from: b  reason: collision with root package name */
    public View f50407b;

    /* renamed from: c  reason: collision with root package name */
    public View f50408c;

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f50409d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f50410e;

    /* renamed from: f  reason: collision with root package name */
    public FrameLayout f50411f;

    /* renamed from: g  reason: collision with root package name */
    public FrameLayout f50412g;

    /* renamed from: h  reason: collision with root package name */
    public TBSpecificationBtn f50413h;

    /* renamed from: i  reason: collision with root package name */
    public TBSpecificationBtn f50414i;
    public d.a.i0.r.f0.m.c j;
    public d.a.i0.r.f0.m.c k;
    public PopupWindow m;
    public boolean l = true;
    public float n = 1.0f;
    public View.OnClickListener o = new View$OnClickListenerC1095b();
    public View.OnClickListener p = new c();
    public View.OnClickListener q = new d();

    /* loaded from: classes4.dex */
    public class a implements Animator.AnimatorListener {
        public a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            if (b.this.m == null || !b.this.m.isShowing()) {
                return;
            }
            b.this.m.dismiss();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (b.this.m == null || !b.this.m.isShowing()) {
                return;
            }
            b.this.m.dismiss();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921501, 0));
        }
    }

    /* renamed from: d.a.j0.a1.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1095b implements View.OnClickListener {
        public View$OnClickListenerC1095b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.i();
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.i();
            if (!b.this.l) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921502, 0));
                b.this.l = true;
                b.this.q();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001384, 0));
            b.this.p(1);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.i();
            if (b.this.l) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921502, 1));
                b.this.l = false;
                b.this.q();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001384, 0));
            b.this.p(2);
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnTouchListener {
        public e() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent == null || motionEvent.getAction() != 0) {
                return false;
            }
            b.this.i();
            return false;
        }
    }

    /* loaded from: classes4.dex */
    public class f implements PopupWindow.OnDismissListener {
        public f(b bVar) {
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921501, 0));
        }
    }

    /* loaded from: classes4.dex */
    public class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.i();
        }
    }

    /* loaded from: classes4.dex */
    public class h implements View.OnClickListener {
        public h(b bVar) {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    /* loaded from: classes4.dex */
    public class i implements ValueAnimator.AnimatorUpdateListener {
        public i() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            b.this.f50412g.setAlpha(floatValue);
            if (b.this.f50412g.getMeasuredHeight() > 0) {
                b.this.f50412g.setTranslationY(b.this.f50412g.getMeasuredHeight() * (floatValue - 1.0f));
            }
            b.this.f50408c.setAlpha(floatValue);
        }
    }

    /* loaded from: classes4.dex */
    public class j implements ValueAnimator.AnimatorUpdateListener {
        public j() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            b.this.f50412g.setAlpha(floatValue);
            if (b.this.f50412g.getMeasuredHeight() > 0) {
                b.this.f50412g.setTranslationY(b.this.f50412g.getMeasuredHeight() * (floatValue - 1.0f));
            }
            b.this.f50408c.setAlpha(floatValue);
        }
    }

    public b(Context context) {
        this.f50406a = context;
        j();
    }

    public final void i() {
        if (l.a()) {
            return;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
        ofFloat.setDuration(200L);
        ofFloat.setInterpolator(new DecelerateInterpolator());
        ofFloat.addUpdateListener(new j());
        ofFloat.addListener(new a());
        ofFloat.start();
    }

    public final void j() {
        View inflate = LayoutInflater.from(this.f50406a).inflate(R.layout.home_page_concern_dialog_thread, (ViewGroup) null);
        this.f50407b = inflate;
        this.f50409d = (LinearLayout) inflate.findViewById(R.id.root_main);
        this.f50411f = (FrameLayout) this.f50407b.findViewById(R.id.type_container);
        this.f50410e = (LinearLayout) this.f50407b.findViewById(R.id.ll_btn);
        this.f50408c = this.f50407b.findViewById(R.id.mask_view);
        this.f50412g = (FrameLayout) this.f50407b.findViewById(R.id.bottom_background_view);
        this.f50413h = (TBSpecificationBtn) this.f50407b.findViewById(R.id.btn_all_concern);
        this.f50414i = (TBSpecificationBtn) this.f50407b.findViewById(R.id.btn_person_concern);
        this.f50413h.setTextSize(R.dimen.tbds34);
        this.f50413h.setText(TbadkCoreApplication.getInst().getString(R.string.attention_all));
        this.f50414i.setTextSize(R.dimen.tbds34);
        this.f50414i.setText(TbadkCoreApplication.getInst().getString(R.string.attention_person));
        this.f50414i.setOnClickListener(this.q);
        this.f50413h.setOnClickListener(this.p);
        this.f50411f.setOnClickListener(this.o);
        d.a.i0.r.f0.m.c cVar = new d.a.i0.r.f0.m.c();
        this.j = cVar;
        cVar.o(R.color.CAM_X0304);
        d.a.i0.r.f0.m.c cVar2 = new d.a.i0.r.f0.m.c();
        this.k = cVar2;
        cVar2.q(R.color.CAM_X0108);
        this.l = d.a.i0.r.d0.b.j().k("key_home_concern_all_status", 0) != 1;
        q();
        k(TbadkCoreApplication.getInst().getSkinType());
    }

    public void k(int i2) {
        if (this.f50407b == null) {
            return;
        }
        this.f50413h.l(i2);
        this.f50414i.l(i2);
        SkinManager.setBackgroundColorWithAlpha(this.f50410e, R.color.CAM_X0208, this.n, i2);
        SkinManager.setBackgroundColor(this.f50412g, R.color.CAM_X0202);
        SkinManager.setBackgroundColor(this.f50408c, R.color.CAM_X0605);
    }

    public void l(float f2) {
        this.n = f2;
    }

    public final void m() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setDuration(200L);
        ofFloat.setInterpolator(new DecelerateInterpolator());
        ofFloat.addUpdateListener(new i());
        ofFloat.start();
    }

    public void n(StickyAppBarLayout stickyAppBarLayout) {
        o(stickyAppBarLayout);
    }

    public final void o(StickyAppBarLayout stickyAppBarLayout) {
        if (this.m == null) {
            PopupWindow popupWindow = new PopupWindow(this.f50407b, -1, -1, true);
            this.m = popupWindow;
            popupWindow.setContentView(this.f50407b);
            this.m.setOutsideTouchable(true);
            this.m.setBackgroundDrawable(new ColorDrawable(0));
            this.m.setFocusable(true);
            this.m.setTouchInterceptor(new e());
            this.m.setOnDismissListener(new f(this));
            this.m.setAnimationStyle(0);
        }
        int[] iArr = new int[2];
        stickyAppBarLayout.getLocationInWindow(iArr);
        int height = (iArr[1] + stickyAppBarLayout.getHeight()) - UtilHelper.getDimenPixelSize(R.dimen.tbds3);
        int dimensionPixelOffset = iArr[0] - this.f50406a.getResources().getDimensionPixelOffset(R.dimen.tbds44);
        if (UtilHelper.canUseStyleImmersiveSticky() && (!"Meizu".equalsIgnoreCase(Build.BRAND) || Build.VERSION.SDK_INT > 24)) {
            height -= UtilHelper.getStatusBarHeight();
        }
        this.f50409d.setOnClickListener(new g());
        this.f50410e.setOnClickListener(new h(this));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f50411f.getLayoutParams();
        if (!"Meizu".equalsIgnoreCase(Build.BRAND) || Build.VERSION.SDK_INT > 24) {
            layoutParams.topMargin = height;
        }
        this.f50411f.setLayoutParams(layoutParams);
        if (d.a.c.e.m.g.m(this.m, stickyAppBarLayout, 0, dimensionPixelOffset, height)) {
            m();
        }
    }

    public final void p(int i2) {
        StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_CONCERN_SWITCH);
        statisticItem.param("obj_type", i2);
        TiebaStatic.log(statisticItem);
    }

    public final void q() {
        TBSpecificationBtn tBSpecificationBtn = this.f50413h;
        if (tBSpecificationBtn == null || this.f50414i == null) {
            return;
        }
        if (this.l) {
            tBSpecificationBtn.setConfig(this.j);
            this.f50414i.setConfig(this.k);
            return;
        }
        tBSpecificationBtn.setConfig(this.k);
        this.f50414i.setConfig(this.j);
    }
}

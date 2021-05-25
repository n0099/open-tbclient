package d.a.m0.r.s;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.message.WindowSwitchMessage;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.a.m0.r.s.l;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class j extends Dialog {
    public static int n = 1000;

    /* renamed from: e  reason: collision with root package name */
    public Context f50267e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.c.a.f f50268f;

    /* renamed from: g  reason: collision with root package name */
    public View f50269g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f50270h;

    /* renamed from: i  reason: collision with root package name */
    public float f50271i;
    public boolean j;
    public l k;
    public boolean l;
    public CustomMessageListener m;

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2001304 || !(customResponsedMessage.getData() instanceof Integer) || j.this.k == null) {
                return;
            }
            j.this.k.j();
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            j.this.cancel();
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Animation.AnimationListener {
        public c() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            j.this.setCancelable(true);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            j.this.setCancelable(false);
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Animation.AnimationListener {

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (j.this.f50268f == null || j.this.f50268f.getPageActivity() == null) {
                    return;
                }
                Activity pageActivity = j.this.f50268f.getPageActivity();
                if (pageActivity.isFinishing() || pageActivity.getWindow() == null) {
                    return;
                }
                j.super.dismiss();
            }
        }

        public d() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            j.this.j = false;
            j.this.f50270h.post(new a());
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            j.this.j = true;
        }
    }

    public j(d.a.c.a.f fVar, l lVar) {
        super(fVar.getPageActivity(), 16973835);
        this.f50271i = 0.33f;
        this.j = false;
        this.l = true;
        this.m = new a(2001304);
        this.f50268f = fVar;
        this.f50267e = fVar.getPageActivity();
        this.k = lVar;
        this.f50269g = lVar.c();
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        if (this.f50270h == null || this.j || !isShowing()) {
            return;
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this.f50267e, R.anim.pop_exit_anim);
        loadAnimation.setFillAfter(true);
        loadAnimation.setAnimationListener(new d());
        this.f50270h.startAnimation(loadAnimation);
        MessageManager.getInstance().unRegisterListener(this.m);
        MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.FALSE));
    }

    public View f() {
        return this.f50269g;
    }

    public LinearLayout g() {
        return this.f50270h;
    }

    public void h(l lVar) {
        this.k = lVar;
        this.f50269g = lVar.c();
    }

    public void i(String str, String[] strArr, l.e eVar) {
        this.k = new l(this.f50267e);
        if (!StringUtils.isNull(str)) {
            this.k.q(str);
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < strArr.length; i2++) {
            arrayList.add(new h(i2, strArr[i2], this.k));
        }
        this.k.k(arrayList);
        this.k.n(eVar);
        setCanceledOnTouchOutside(true);
        this.f50269g = this.k.c();
    }

    public void j(SpannableStringBuilder spannableStringBuilder) {
        l lVar = this.k;
        if (lVar != null) {
            lVar.o(spannableStringBuilder);
            this.k.p();
        }
    }

    public void k(float f2) {
        this.f50271i = f2;
    }

    public void l() {
        this.j = false;
        if (isShowing()) {
            super.dismiss();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.valueOf(d.a.c.e.m.g.j(this, this.f50268f))));
        if (this.f50270h != null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.f50267e, R.anim.bomb_pop_enter_anim);
            loadAnimation.setFillAfter(true);
            loadAnimation.setAnimationListener(new c());
            this.f50270h.startAnimation(loadAnimation);
        }
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        if (isShowing()) {
            cancel();
        } else {
            super.onBackPressed();
        }
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(R.layout.popup_dialog);
        Display defaultDisplay = ((WindowManager) this.f50267e.getSystemService("window")).getDefaultDisplay();
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = defaultDisplay.getWidth();
        attributes.height = defaultDisplay.getHeight();
        if (this.l) {
            attributes.y = d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen._bottom_enter_anim_place_holder_height);
            getWindow().addFlags(512);
        }
        getWindow().setAttributes(attributes);
        getWindow().setBackgroundDrawableResource(R.color.transparent);
        getWindow().setDimAmount(this.f50271i);
        getWindow().setGravity(80);
        getWindow().setWindowAnimations(0);
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.root_view);
        this.f50270h = linearLayout;
        linearLayout.setOnClickListener(new b());
        View view = this.f50269g;
        if (view == null) {
            return;
        }
        this.f50270h.removeView(view);
        if (this.l) {
            View view2 = this.f50269g;
            if ((view2 instanceof ViewGroup) && ((ViewGroup) view2).getChildAt(((ViewGroup) view2).getChildCount() - 1).getId() != n) {
                View view3 = new View(getContext());
                view3.setId(n);
                view3.setLayoutParams(new ViewGroup.LayoutParams(-1, d.a.c.e.p.l.g(getContext(), R.dimen.bottom_enter_anim_place_holder_height)));
                SkinManager.setBackgroundResource(view3, R.color.CAM_X0204);
                ((ViewGroup) this.f50269g).addView(view3);
            }
        }
        if (this.f50269g.getParent() != null) {
            if (this.f50269g.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.f50269g.getParent()).removeView(this.f50269g);
                this.f50270h.addView(this.f50269g);
                return;
            }
            return;
        }
        this.f50270h.addView(this.f50269g);
    }

    @Override // android.app.Dialog
    public void setContentView(View view) {
        this.f50269g = view;
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        this.f50268f.registerListener(this.m);
    }

    public j(d.a.c.a.f fVar) {
        super(fVar.getPageActivity(), 16973835);
        this.f50271i = 0.33f;
        this.j = false;
        this.l = true;
        this.m = new a(2001304);
        this.f50267e = fVar.getPageActivity();
        this.f50268f = fVar;
    }
}

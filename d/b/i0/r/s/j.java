package d.b.i0.r.s;

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
import d.b.i0.r.s.l;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class j extends Dialog {
    public static int n = 1000;

    /* renamed from: e  reason: collision with root package name */
    public Context f51759e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.c.a.f f51760f;

    /* renamed from: g  reason: collision with root package name */
    public View f51761g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f51762h;
    public float i;
    public boolean j;
    public l k;
    public boolean l;
    public CustomMessageListener m;

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {
        public a(int i) {
            super(i);
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
                if (j.this.f51760f == null || j.this.f51760f.getPageActivity() == null) {
                    return;
                }
                Activity pageActivity = j.this.f51760f.getPageActivity();
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
            j.this.f51762h.post(new a());
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            j.this.j = true;
        }
    }

    public j(d.b.c.a.f fVar, l lVar) {
        super(fVar.getPageActivity(), 16973835);
        this.i = 0.33f;
        this.j = false;
        this.l = true;
        this.m = new a(2001304);
        this.f51760f = fVar;
        this.f51759e = fVar.getPageActivity();
        this.k = lVar;
        this.f51761g = lVar.c();
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        if (this.f51762h == null || this.j || !isShowing()) {
            return;
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this.f51759e, R.anim.pop_exit_anim);
        loadAnimation.setFillAfter(true);
        loadAnimation.setAnimationListener(new d());
        this.f51762h.startAnimation(loadAnimation);
        MessageManager.getInstance().unRegisterListener(this.m);
        MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.FALSE));
    }

    public View f() {
        return this.f51761g;
    }

    public LinearLayout g() {
        return this.f51762h;
    }

    public void h(l lVar) {
        this.k = lVar;
        this.f51761g = lVar.c();
    }

    public void i(String str, String[] strArr, l.e eVar) {
        this.k = new l(this.f51759e);
        if (!StringUtils.isNull(str)) {
            this.k.q(str);
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < strArr.length; i++) {
            arrayList.add(new h(i, strArr[i], this.k));
        }
        this.k.k(arrayList);
        this.k.n(eVar);
        setCanceledOnTouchOutside(true);
        this.f51761g = this.k.c();
    }

    public void j(SpannableStringBuilder spannableStringBuilder) {
        l lVar = this.k;
        if (lVar != null) {
            lVar.o(spannableStringBuilder);
            this.k.p();
        }
    }

    public void k(float f2) {
        this.i = f2;
    }

    public void l() {
        this.j = false;
        if (isShowing()) {
            super.dismiss();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.valueOf(d.b.c.e.m.g.j(this, this.f51760f))));
        if (this.f51762h != null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.f51759e, R.anim.bomb_pop_enter_anim);
            loadAnimation.setFillAfter(true);
            loadAnimation.setAnimationListener(new c());
            this.f51762h.startAnimation(loadAnimation);
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
        Display defaultDisplay = ((WindowManager) this.f51759e.getSystemService("window")).getDefaultDisplay();
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = defaultDisplay.getWidth();
        attributes.height = defaultDisplay.getHeight();
        if (this.l) {
            attributes.y = d.b.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen._bottom_enter_anim_place_holder_height);
            getWindow().addFlags(512);
        }
        getWindow().setAttributes(attributes);
        getWindow().setBackgroundDrawableResource(R.color.transparent);
        getWindow().setDimAmount(this.i);
        getWindow().setGravity(80);
        getWindow().setWindowAnimations(0);
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.root_view);
        this.f51762h = linearLayout;
        linearLayout.setOnClickListener(new b());
        View view = this.f51761g;
        if (view == null) {
            return;
        }
        this.f51762h.removeView(view);
        if (this.l) {
            View view2 = this.f51761g;
            if ((view2 instanceof ViewGroup) && ((ViewGroup) view2).getChildAt(((ViewGroup) view2).getChildCount() - 1).getId() != n) {
                View view3 = new View(getContext());
                view3.setId(n);
                view3.setLayoutParams(new ViewGroup.LayoutParams(-1, d.b.c.e.p.l.g(getContext(), R.dimen.bottom_enter_anim_place_holder_height)));
                SkinManager.setBackgroundResource(view3, R.color.CAM_X0204);
                ((ViewGroup) this.f51761g).addView(view3);
            }
        }
        if (this.f51761g.getParent() != null) {
            if (this.f51761g.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.f51761g.getParent()).removeView(this.f51761g);
                this.f51762h.addView(this.f51761g);
                return;
            }
            return;
        }
        this.f51762h.addView(this.f51761g);
    }

    @Override // android.app.Dialog
    public void setContentView(View view) {
        this.f51761g = view;
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        this.f51760f.registerListener(this.m);
    }

    public j(d.b.c.a.f fVar) {
        super(fVar.getPageActivity(), 16973835);
        this.i = 0.33f;
        this.j = false;
        this.l = true;
        this.m = new a(2001304);
        this.f51759e = fVar.getPageActivity();
        this.f51760f = fVar;
    }
}

package d.a.i0.r.o;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import d.a.c.e.p.k;
import d.a.c.e.p.l;
/* loaded from: classes3.dex */
public class c extends PopupWindow {

    /* renamed from: a  reason: collision with root package name */
    public TbImageView f49041a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f49042b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f49043c;

    /* renamed from: d  reason: collision with root package name */
    public Button f49044d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.i0.a.b0.a f49045e;

    /* renamed from: f  reason: collision with root package name */
    public int f49046f;

    /* renamed from: g  reason: collision with root package name */
    public int f49047g;

    /* renamed from: h  reason: collision with root package name */
    public RelativeLayout f49048h;

    /* renamed from: i  reason: collision with root package name */
    public CustomMessageListener f49049i;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.f49045e == null) {
                return;
            }
            if (c.this.f49045e.f47788d == d.a.i0.a.b0.a.H) {
                if (!UtilHelper.dealOneScheme(TbadkCoreApplication.getInst().getCurrentActivity(), c.this.f49045e.l) && !k.isEmpty(c.this.f49045e.k)) {
                    c cVar = c.this;
                    cVar.e(cVar.f49045e.k);
                }
            } else if (c.this.f49045e.f47788d == d.a.i0.a.b0.a.I && !k.isEmpty(c.this.f49045e.k)) {
                c cVar2 = c.this;
                cVar2.e(cVar2.f49045e.k);
            }
            c.this.dismiss();
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.dismiss();
        }
    }

    /* renamed from: d.a.i0.r.o.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1060c implements PopupWindow.OnDismissListener {
        public C1060c() {
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            MessageManager.getInstance().unRegisterListener(c.this.f49049i);
        }
    }

    /* loaded from: classes3.dex */
    public class d extends CustomMessageListener {
        public d(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.this.dismiss();
        }
    }

    public c(Context context) {
        super(context);
        this.f49049i = new d(2921420);
        g(context);
        MessageManager.getInstance().registerListener(this.f49049i);
    }

    public void d(Context context, d.a.i0.a.b0.a aVar) {
        if (aVar == null) {
            return;
        }
        this.f49045e = aVar;
        if (k.isEmpty(aVar.f47789e)) {
            this.f49042b.setText(context.getResources().getString(R.string.task_already_finish));
        } else {
            this.f49042b.setText(aVar.f47789e);
        }
        if (k.isEmpty(aVar.p)) {
            this.f49042b.setTextColor(context.getResources().getColor(R.color.CAM_X0107));
        } else {
            this.f49042b.setTextColor(d.a.j0.j1.o.k.b.b(aVar.p));
        }
        if (k.isEmpty(aVar.f47790f)) {
            this.f49043c.setText(context.getResources().getString(R.string.back));
        } else {
            this.f49043c.setText(aVar.f47790f);
        }
        if (k.isEmpty(aVar.q)) {
            this.f49043c.setTextColor(context.getResources().getColor(R.color.CAM_X0101));
        } else {
            this.f49043c.setTextColor(d.a.j0.j1.o.k.b.b(aVar.q));
        }
        if (!k.isEmpty(aVar.o)) {
            this.f49043c.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(l.g(context, R.dimen.tbds120), d.a.j0.j1.o.k.b.b(aVar.o)));
        }
        if (!k.isEmpty(aVar.j)) {
            this.f49041a.V(aVar.j, 10, false);
        } else {
            this.f49041a.V(String.valueOf(R.drawable.banner_size), 24, false);
        }
    }

    public final void e(String str) {
        TbPageContext<?> f2;
        if (k.isEmpty(str) || (f2 = f(TbadkCoreApplication.getInst().getCurrentActivity())) == null) {
            return;
        }
        UrlManager.getInstance().dealOneLink(f2, new String[]{str});
    }

    public final TbPageContext f(Activity activity) {
        if (activity instanceof BaseActivity) {
            return ((BaseActivity) activity).getPageContext();
        }
        if (activity instanceof BaseFragmentActivity) {
            return ((BaseFragmentActivity) activity).getPageContext();
        }
        return null;
    }

    public void g(Context context) {
        View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.popupwindow_business, (ViewGroup) null);
        TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.lower_hair_img);
        this.f49041a = tbImageView;
        tbImageView.setRadius(l.g(context, R.dimen.tbds32));
        this.f49041a.setConrers(3);
        this.f49042b = (TextView) inflate.findViewById(R.id.lower_hair_text_1);
        this.f49043c = (TextView) inflate.findViewById(R.id.lower_hair_text_2);
        this.f49044d = (Button) inflate.findViewById(R.id.btn_close);
        this.f49048h = (RelativeLayout) inflate.findViewById(R.id.lower_hair_content);
        this.f49043c.setOnClickListener(new a());
        this.f49044d.setOnClickListener(new b());
        setContentView(inflate);
        setWidth(-1);
        setHeight(-1);
        setFocusable(true);
        setBackgroundDrawable(new ColorDrawable(context.getResources().getColor(R.color.black_alpha35)));
        setAnimationStyle(R.style.UpdateStyle);
        setClippingEnabled(false);
        setOnDismissListener(new C1060c());
    }

    public final boolean h() {
        Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
        if (currentActivity != null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            currentActivity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            this.f49046f = displayMetrics.widthPixels;
            this.f49047g = displayMetrics.heightPixels;
        }
        return this.f49047g > 2000 && this.f49046f > 2000;
    }

    public void i() {
        RelativeLayout relativeLayout;
        if (h() && (relativeLayout = this.f49048h) != null && relativeLayout.getLayoutParams() != null) {
            this.f49048h.getLayoutParams().width = (this.f49046f * 2) / 3;
        }
        showAtLocation(getContentView(), 17, 0, 0);
    }
}

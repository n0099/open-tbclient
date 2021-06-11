package d.a.m0.r.o;

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
public class b extends PopupWindow {

    /* renamed from: a  reason: collision with root package name */
    public TbImageView f53580a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f53581b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f53582c;

    /* renamed from: d  reason: collision with root package name */
    public Button f53583d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.m0.a.e0.a f53584e;

    /* renamed from: f  reason: collision with root package name */
    public int f53585f;

    /* renamed from: g  reason: collision with root package name */
    public int f53586g;

    /* renamed from: h  reason: collision with root package name */
    public RelativeLayout f53587h;

    /* renamed from: i  reason: collision with root package name */
    public CustomMessageListener f53588i;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.f53584e == null) {
                return;
            }
            if (b.this.f53584e.f52360d == d.a.m0.a.e0.a.D) {
                if (!UtilHelper.dealOneScheme(TbadkCoreApplication.getInst().getCurrentActivity(), b.this.f53584e.l) && !k.isEmpty(b.this.f53584e.k)) {
                    b bVar = b.this;
                    bVar.e(bVar.f53584e.k);
                }
            } else if (b.this.f53584e.f52360d == d.a.m0.a.e0.a.E && !k.isEmpty(b.this.f53584e.k)) {
                b bVar2 = b.this;
                bVar2.e(bVar2.f53584e.k);
            }
            b.this.dismiss();
        }
    }

    /* renamed from: d.a.m0.r.o.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC1200b implements View.OnClickListener {
        public View$OnClickListenerC1200b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.dismiss();
        }
    }

    /* loaded from: classes3.dex */
    public class c implements PopupWindow.OnDismissListener {
        public c() {
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            MessageManager.getInstance().unRegisterListener(b.this.f53588i);
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
            b.this.dismiss();
        }
    }

    public b(Context context) {
        super(context);
        this.f53588i = new d(2921420);
        g(context);
        MessageManager.getInstance().registerListener(this.f53588i);
    }

    public void d(Context context, d.a.m0.a.e0.a aVar) {
        if (aVar == null) {
            return;
        }
        this.f53584e = aVar;
        if (k.isEmpty(aVar.f52361e)) {
            this.f53581b.setText(context.getResources().getString(R.string.task_already_finish));
        } else {
            this.f53581b.setText(aVar.f52361e);
        }
        if (k.isEmpty(aVar.p)) {
            this.f53581b.setTextColor(context.getResources().getColor(R.color.CAM_X0107));
        } else {
            this.f53581b.setTextColor(d.a.n0.k1.o.k.b.b(aVar.p));
        }
        if (k.isEmpty(aVar.f52362f)) {
            this.f53582c.setText(context.getResources().getString(R.string.back));
        } else {
            this.f53582c.setText(aVar.f52362f);
        }
        if (k.isEmpty(aVar.q)) {
            this.f53582c.setTextColor(context.getResources().getColor(R.color.CAM_X0101));
        } else {
            this.f53582c.setTextColor(d.a.n0.k1.o.k.b.b(aVar.q));
        }
        if (!k.isEmpty(aVar.o)) {
            this.f53582c.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(l.g(context, R.dimen.tbds120), d.a.n0.k1.o.k.b.b(aVar.o)));
        }
        if (!k.isEmpty(aVar.j)) {
            this.f53580a.U(aVar.j, 10, false);
        } else {
            this.f53580a.U(String.valueOf(R.drawable.banner_size), 24, false);
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
        this.f53580a = tbImageView;
        tbImageView.setRadius(l.g(context, R.dimen.tbds32));
        this.f53580a.setConrers(3);
        this.f53581b = (TextView) inflate.findViewById(R.id.lower_hair_text_1);
        this.f53582c = (TextView) inflate.findViewById(R.id.lower_hair_text_2);
        this.f53583d = (Button) inflate.findViewById(R.id.btn_close);
        this.f53587h = (RelativeLayout) inflate.findViewById(R.id.lower_hair_content);
        this.f53582c.setOnClickListener(new a());
        this.f53583d.setOnClickListener(new View$OnClickListenerC1200b());
        setContentView(inflate);
        setWidth(-1);
        setHeight(-1);
        setFocusable(true);
        setBackgroundDrawable(new ColorDrawable(context.getResources().getColor(R.color.black_alpha35)));
        setAnimationStyle(R.style.UpdateStyle);
        setClippingEnabled(false);
        setOnDismissListener(new c());
    }

    public final boolean h() {
        Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
        if (currentActivity != null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            currentActivity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            this.f53585f = displayMetrics.widthPixels;
            this.f53586g = displayMetrics.heightPixels;
        }
        return this.f53586g > 2000 && this.f53585f > 2000;
    }

    public void i() {
        RelativeLayout relativeLayout;
        if (h() && (relativeLayout = this.f53587h) != null && relativeLayout.getLayoutParams() != null) {
            this.f53587h.getLayoutParams().width = (this.f53585f * 2) / 3;
        }
        showAtLocation(getContentView(), 17, 0, 0);
    }
}

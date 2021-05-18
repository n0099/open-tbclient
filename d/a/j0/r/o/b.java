package d.a.j0.r.o;

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
    public TbImageView f49860a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f49861b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f49862c;

    /* renamed from: d  reason: collision with root package name */
    public Button f49863d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.j0.a.d0.a f49864e;

    /* renamed from: f  reason: collision with root package name */
    public int f49865f;

    /* renamed from: g  reason: collision with root package name */
    public int f49866g;

    /* renamed from: h  reason: collision with root package name */
    public RelativeLayout f49867h;

    /* renamed from: i  reason: collision with root package name */
    public CustomMessageListener f49868i;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.f49864e == null) {
                return;
            }
            if (b.this.f49864e.f48662d == d.a.j0.a.d0.a.D) {
                if (!UtilHelper.dealOneScheme(TbadkCoreApplication.getInst().getCurrentActivity(), b.this.f49864e.l) && !k.isEmpty(b.this.f49864e.k)) {
                    b bVar = b.this;
                    bVar.e(bVar.f49864e.k);
                }
            } else if (b.this.f49864e.f48662d == d.a.j0.a.d0.a.E && !k.isEmpty(b.this.f49864e.k)) {
                b bVar2 = b.this;
                bVar2.e(bVar2.f49864e.k);
            }
            b.this.dismiss();
        }
    }

    /* renamed from: d.a.j0.r.o.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC1135b implements View.OnClickListener {
        public View$OnClickListenerC1135b() {
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
            MessageManager.getInstance().unRegisterListener(b.this.f49868i);
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
        this.f49868i = new d(2921420);
        g(context);
        MessageManager.getInstance().registerListener(this.f49868i);
    }

    public void d(Context context, d.a.j0.a.d0.a aVar) {
        if (aVar == null) {
            return;
        }
        this.f49864e = aVar;
        if (k.isEmpty(aVar.f48663e)) {
            this.f49861b.setText(context.getResources().getString(R.string.task_already_finish));
        } else {
            this.f49861b.setText(aVar.f48663e);
        }
        if (k.isEmpty(aVar.p)) {
            this.f49861b.setTextColor(context.getResources().getColor(R.color.CAM_X0107));
        } else {
            this.f49861b.setTextColor(d.a.k0.j1.o.k.b.b(aVar.p));
        }
        if (k.isEmpty(aVar.f48664f)) {
            this.f49862c.setText(context.getResources().getString(R.string.back));
        } else {
            this.f49862c.setText(aVar.f48664f);
        }
        if (k.isEmpty(aVar.q)) {
            this.f49862c.setTextColor(context.getResources().getColor(R.color.CAM_X0101));
        } else {
            this.f49862c.setTextColor(d.a.k0.j1.o.k.b.b(aVar.q));
        }
        if (!k.isEmpty(aVar.o)) {
            this.f49862c.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(l.g(context, R.dimen.tbds120), d.a.k0.j1.o.k.b.b(aVar.o)));
        }
        if (!k.isEmpty(aVar.j)) {
            this.f49860a.V(aVar.j, 10, false);
        } else {
            this.f49860a.V(String.valueOf(R.drawable.banner_size), 24, false);
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
        this.f49860a = tbImageView;
        tbImageView.setRadius(l.g(context, R.dimen.tbds32));
        this.f49860a.setConrers(3);
        this.f49861b = (TextView) inflate.findViewById(R.id.lower_hair_text_1);
        this.f49862c = (TextView) inflate.findViewById(R.id.lower_hair_text_2);
        this.f49863d = (Button) inflate.findViewById(R.id.btn_close);
        this.f49867h = (RelativeLayout) inflate.findViewById(R.id.lower_hair_content);
        this.f49862c.setOnClickListener(new a());
        this.f49863d.setOnClickListener(new View$OnClickListenerC1135b());
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
            this.f49865f = displayMetrics.widthPixels;
            this.f49866g = displayMetrics.heightPixels;
        }
        return this.f49866g > 2000 && this.f49865f > 2000;
    }

    public void i() {
        RelativeLayout relativeLayout;
        if (h() && (relativeLayout = this.f49867h) != null && relativeLayout.getLayoutParams() != null) {
            this.f49867h.getLayoutParams().width = (this.f49865f * 2) / 3;
        }
        showAtLocation(getContentView(), 17, 0, 0);
    }
}

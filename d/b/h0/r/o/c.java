package d.b.h0.r.o;

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
import d.b.c.e.p.k;
import d.b.c.e.p.l;
/* loaded from: classes3.dex */
public class c extends PopupWindow {

    /* renamed from: a  reason: collision with root package name */
    public TbImageView f51086a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f51087b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f51088c;

    /* renamed from: d  reason: collision with root package name */
    public Button f51089d;

    /* renamed from: e  reason: collision with root package name */
    public d.b.h0.a.b0.a f51090e;

    /* renamed from: f  reason: collision with root package name */
    public int f51091f;

    /* renamed from: g  reason: collision with root package name */
    public int f51092g;

    /* renamed from: h  reason: collision with root package name */
    public RelativeLayout f51093h;
    public CustomMessageListener i;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.f51090e == null) {
                return;
            }
            if (c.this.f51090e.f49906d == d.b.h0.a.b0.a.H) {
                if (!UtilHelper.dealOneScheme(TbadkCoreApplication.getInst().getCurrentActivity(), c.this.f51090e.l) && !k.isEmpty(c.this.f51090e.k)) {
                    c cVar = c.this;
                    cVar.e(cVar.f51090e.k);
                }
            } else if (c.this.f51090e.f49906d == d.b.h0.a.b0.a.I && !k.isEmpty(c.this.f51090e.k)) {
                c cVar2 = c.this;
                cVar2.e(cVar2.f51090e.k);
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

    /* renamed from: d.b.h0.r.o.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1099c implements PopupWindow.OnDismissListener {
        public C1099c() {
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            MessageManager.getInstance().unRegisterListener(c.this.i);
        }
    }

    /* loaded from: classes3.dex */
    public class d extends CustomMessageListener {
        public d(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.this.dismiss();
        }
    }

    public c(Context context) {
        super(context);
        this.i = new d(2921420);
        g(context);
        MessageManager.getInstance().registerListener(this.i);
    }

    public void d(Context context, d.b.h0.a.b0.a aVar) {
        if (aVar == null) {
            return;
        }
        this.f51090e = aVar;
        if (k.isEmpty(aVar.f49907e)) {
            this.f51087b.setText(context.getResources().getString(R.string.task_already_finish));
        } else {
            this.f51087b.setText(aVar.f49907e);
        }
        if (k.isEmpty(aVar.p)) {
            this.f51087b.setTextColor(context.getResources().getColor(R.color.CAM_X0107));
        } else {
            this.f51087b.setTextColor(d.b.i0.j1.o.k.b.b(aVar.p));
        }
        if (k.isEmpty(aVar.f49908f)) {
            this.f51088c.setText(context.getResources().getString(R.string.back));
        } else {
            this.f51088c.setText(aVar.f49908f);
        }
        if (k.isEmpty(aVar.q)) {
            this.f51088c.setTextColor(context.getResources().getColor(R.color.CAM_X0101));
        } else {
            this.f51088c.setTextColor(d.b.i0.j1.o.k.b.b(aVar.q));
        }
        if (!k.isEmpty(aVar.o)) {
            this.f51088c.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(l.g(context, R.dimen.tbds120), d.b.i0.j1.o.k.b.b(aVar.o)));
        }
        if (!k.isEmpty(aVar.j)) {
            this.f51086a.W(aVar.j, 10, false);
        } else {
            this.f51086a.W(String.valueOf(R.drawable.banner_size), 24, false);
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
        this.f51086a = tbImageView;
        tbImageView.setRadius(l.g(context, R.dimen.tbds32));
        this.f51086a.setConrers(3);
        this.f51087b = (TextView) inflate.findViewById(R.id.lower_hair_text_1);
        this.f51088c = (TextView) inflate.findViewById(R.id.lower_hair_text_2);
        this.f51089d = (Button) inflate.findViewById(R.id.btn_close);
        this.f51093h = (RelativeLayout) inflate.findViewById(R.id.lower_hair_content);
        this.f51088c.setOnClickListener(new a());
        this.f51089d.setOnClickListener(new b());
        setContentView(inflate);
        setWidth(-1);
        setHeight(-1);
        setFocusable(true);
        setBackgroundDrawable(new ColorDrawable(context.getResources().getColor(R.color.black_alpha35)));
        setAnimationStyle(R.style.UpdateStyle);
        setClippingEnabled(false);
        setOnDismissListener(new C1099c());
    }

    public final boolean h() {
        Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
        if (currentActivity != null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            currentActivity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            this.f51091f = displayMetrics.widthPixels;
            this.f51092g = displayMetrics.heightPixels;
        }
        return this.f51092g > 2000 && this.f51091f > 2000;
    }

    public void i() {
        RelativeLayout relativeLayout;
        if (h() && (relativeLayout = this.f51093h) != null && relativeLayout.getLayoutParams() != null) {
            this.f51093h.getLayoutParams().width = (this.f51091f * 2) / 3;
        }
        showAtLocation(getContentView(), 17, 0, 0);
    }
}

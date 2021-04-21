package d.b.i0.r.o;

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
    public TbImageView f51422a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f51423b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f51424c;

    /* renamed from: d  reason: collision with root package name */
    public Button f51425d;

    /* renamed from: e  reason: collision with root package name */
    public d.b.i0.a.b0.a f51426e;

    /* renamed from: f  reason: collision with root package name */
    public int f51427f;

    /* renamed from: g  reason: collision with root package name */
    public int f51428g;

    /* renamed from: h  reason: collision with root package name */
    public RelativeLayout f51429h;
    public CustomMessageListener i;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.f51426e == null) {
                return;
            }
            if (c.this.f51426e.f50242d == d.b.i0.a.b0.a.H) {
                if (!UtilHelper.dealOneScheme(TbadkCoreApplication.getInst().getCurrentActivity(), c.this.f51426e.l) && !k.isEmpty(c.this.f51426e.k)) {
                    c cVar = c.this;
                    cVar.e(cVar.f51426e.k);
                }
            } else if (c.this.f51426e.f50242d == d.b.i0.a.b0.a.I && !k.isEmpty(c.this.f51426e.k)) {
                c cVar2 = c.this;
                cVar2.e(cVar2.f51426e.k);
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

    /* renamed from: d.b.i0.r.o.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1121c implements PopupWindow.OnDismissListener {
        public C1121c() {
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

    public void d(Context context, d.b.i0.a.b0.a aVar) {
        if (aVar == null) {
            return;
        }
        this.f51426e = aVar;
        if (k.isEmpty(aVar.f50243e)) {
            this.f51423b.setText(context.getResources().getString(R.string.task_already_finish));
        } else {
            this.f51423b.setText(aVar.f50243e);
        }
        if (k.isEmpty(aVar.p)) {
            this.f51423b.setTextColor(context.getResources().getColor(R.color.CAM_X0107));
        } else {
            this.f51423b.setTextColor(d.b.j0.j1.o.k.b.b(aVar.p));
        }
        if (k.isEmpty(aVar.f50244f)) {
            this.f51424c.setText(context.getResources().getString(R.string.back));
        } else {
            this.f51424c.setText(aVar.f50244f);
        }
        if (k.isEmpty(aVar.q)) {
            this.f51424c.setTextColor(context.getResources().getColor(R.color.CAM_X0101));
        } else {
            this.f51424c.setTextColor(d.b.j0.j1.o.k.b.b(aVar.q));
        }
        if (!k.isEmpty(aVar.o)) {
            this.f51424c.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(l.g(context, R.dimen.tbds120), d.b.j0.j1.o.k.b.b(aVar.o)));
        }
        if (!k.isEmpty(aVar.j)) {
            this.f51422a.W(aVar.j, 10, false);
        } else {
            this.f51422a.W(String.valueOf(R.drawable.banner_size), 24, false);
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
        this.f51422a = tbImageView;
        tbImageView.setRadius(l.g(context, R.dimen.tbds32));
        this.f51422a.setConrers(3);
        this.f51423b = (TextView) inflate.findViewById(R.id.lower_hair_text_1);
        this.f51424c = (TextView) inflate.findViewById(R.id.lower_hair_text_2);
        this.f51425d = (Button) inflate.findViewById(R.id.btn_close);
        this.f51429h = (RelativeLayout) inflate.findViewById(R.id.lower_hair_content);
        this.f51424c.setOnClickListener(new a());
        this.f51425d.setOnClickListener(new b());
        setContentView(inflate);
        setWidth(-1);
        setHeight(-1);
        setFocusable(true);
        setBackgroundDrawable(new ColorDrawable(context.getResources().getColor(R.color.black_alpha35)));
        setAnimationStyle(R.style.UpdateStyle);
        setClippingEnabled(false);
        setOnDismissListener(new C1121c());
    }

    public final boolean h() {
        Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
        if (currentActivity != null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            currentActivity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            this.f51427f = displayMetrics.widthPixels;
            this.f51428g = displayMetrics.heightPixels;
        }
        return this.f51428g > 2000 && this.f51427f > 2000;
    }

    public void i() {
        RelativeLayout relativeLayout;
        if (h() && (relativeLayout = this.f51429h) != null && relativeLayout.getLayoutParams() != null) {
            this.f51429h.getLayoutParams().width = (this.f51427f * 2) / 3;
        }
        showAtLocation(getContentView(), 17, 0, 0);
    }
}

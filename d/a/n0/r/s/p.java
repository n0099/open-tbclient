package d.a.n0.r.s;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.TBAlertConfig;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class p {

    /* renamed from: a  reason: collision with root package name */
    public static final int f54094a = d.a.c.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds96);

    /* loaded from: classes3.dex */
    public static class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TBAlertConfig.a f54095e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ View.OnClickListener f54096f;

        public a(TBAlertConfig.a aVar, View.OnClickListener onClickListener) {
            this.f54095e = aVar;
            this.f54096f = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            View.OnClickListener onClickListener = this.f54095e.f12217c;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
            View.OnClickListener onClickListener2 = this.f54096f;
            if (onClickListener2 != null) {
                onClickListener2.onClick(view);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f54097a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f54098b;

        static {
            int[] iArr = new int[TBAlertConfig.OperateBtnStyle.values().length];
            f54098b = iArr;
            try {
                iArr[TBAlertConfig.OperateBtnStyle.MAIN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f54098b[TBAlertConfig.OperateBtnStyle.ALERT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f54098b[TBAlertConfig.OperateBtnStyle.FORCE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f54098b[TBAlertConfig.OperateBtnStyle.SECONDARY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[TBAlertConfig.OperateType.values().length];
            f54097a = iArr2;
            try {
                iArr2[TBAlertConfig.OperateType.ONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f54097a[TBAlertConfig.OperateType.TWO.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f54097a[TBAlertConfig.OperateType.THREE.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public static TextView a(@NonNull Context context) {
        TextView textView = new TextView(context);
        d.a.n0.r.u.c d2 = d.a.n0.r.u.c.d(textView);
        d2.w(R.dimen.T_X07);
        d2.u(R.color.CAM_X0301);
        d2.x(R.string.F_X01);
        d2.k(R.dimen.L_X02);
        d2.j(R.color.CAM_X0301);
        d2.m(R.string.J_X07);
        d2.g(17170445);
        textView.setMaxLines(1);
        textView.setSingleLine();
        textView.setGravity(17);
        return textView;
    }

    public static TextView b(Activity activity, boolean z) {
        return z ? c(activity) : d(activity);
    }

    public static TextView c(@NonNull Context context) {
        EMTextView eMTextView = new EMTextView(context);
        d.a.n0.r.u.c d2 = d.a.n0.r.u.c.d(eMTextView);
        d2.w(R.dimen.T_X07);
        d2.t(R.dimen.M_T_X002);
        d2.s(R.color.CAM_X0107);
        d2.x(R.string.F_X01);
        return eMTextView;
    }

    public static TextView d(@NonNull Context context) {
        EMTextView eMTextView = new EMTextView(context);
        d.a.n0.r.u.c d2 = d.a.n0.r.u.c.d(eMTextView);
        d2.w(R.dimen.T_X07);
        d2.t(R.dimen.M_T_X002);
        d2.s(R.color.CAM_X0108);
        d2.x(R.string.F_X01);
        return eMTextView;
    }

    public static TextView e(@NonNull Context context) {
        TextView textView = new TextView(context);
        d.a.n0.r.u.c d2 = d.a.n0.r.u.c.d(textView);
        d2.w(R.dimen.T_X07);
        d2.u(R.color.CAM_X0101);
        d2.x(R.string.F_X01);
        d2.m(R.string.J_X07);
        d2.g(R.color.CAM_X0303);
        textView.setMaxLines(1);
        textView.setSingleLine();
        textView.setGravity(17);
        return textView;
    }

    public static TextView f(@NonNull Context context) {
        TextView textView = new TextView(context);
        d.a.n0.r.u.c d2 = d.a.n0.r.u.c.d(textView);
        d2.w(R.dimen.T_X07);
        d2.u(R.color.CAM_X0304);
        d2.x(R.string.F_X01);
        d2.k(R.dimen.L_X02);
        d2.j(R.color.CAM_X0304);
        d2.i(R.string.A_X07);
        d2.m(R.string.J_X07);
        d2.g(17170445);
        textView.setMaxLines(1);
        textView.setSingleLine();
        textView.setGravity(17);
        return textView;
    }

    public static View g(@NonNull Context context, @NonNull TBAlertConfig.a aVar, @Nullable View.OnClickListener onClickListener) {
        return h(context, aVar, onClickListener, false);
    }

    public static View h(@NonNull Context context, @NonNull TBAlertConfig.a aVar, @Nullable View.OnClickListener onClickListener, boolean z) {
        TextView f2;
        int i2 = b.f54098b[aVar.f12216b.ordinal()];
        if (i2 == 1) {
            f2 = f(context);
        } else if (i2 == 2) {
            f2 = a(context);
        } else if (i2 != 3) {
            f2 = i2 != 4 ? null : j(context);
        } else {
            f2 = e(context);
        }
        f2.setText(aVar.f12215a);
        if (z) {
            d.a.n0.r.u.c.d(f2).w(R.dimen.T_X08);
        }
        f2.setOnClickListener(new a(aVar, onClickListener));
        return f2;
    }

    public static View i(@NonNull Context context, @NonNull TBAlertConfig.b bVar, @Nullable View.OnClickListener onClickListener) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setPadding(0, d.a.c.e.p.l.g(context, R.dimen.M_H_X008), 0, d.a.c.e.p.l.g(context, R.dimen.M_H_X008));
        linearLayout.setGravity(17);
        int i2 = b.f54097a[bVar.f12218a.ordinal()];
        boolean z = true;
        if (i2 == 1) {
            linearLayout.setOrientation(0);
            linearLayout.setWeightSum(837.0f);
            View g2 = g(context, bVar.f12219b, onClickListener);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, f54094a);
            layoutParams.weight = 494.0f;
            linearLayout.addView(g2, layoutParams);
        } else if (i2 == 2) {
            linearLayout.setOrientation(0);
            if (bVar.f12219b.f12215a.length() <= 6 && bVar.f12220c.f12215a.length() <= 6) {
                z = false;
            }
            View h2 = h(context, bVar.f12219b, onClickListener, z);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, f54094a);
            layoutParams2.setMargins(d.a.c.e.p.l.g(context, R.dimen.M_W_X012), 0, d.a.c.e.p.l.g(context, R.dimen.M_W_X006) / 2, 0);
            layoutParams2.weight = 1.0f;
            linearLayout.addView(h2, layoutParams2);
            View h3 = h(context, bVar.f12220c, onClickListener, z);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, f54094a);
            layoutParams3.setMargins(d.a.c.e.p.l.g(context, R.dimen.M_W_X006) / 2, 0, d.a.c.e.p.l.g(context, R.dimen.M_W_X012), 0);
            layoutParams3.weight = 1.0f;
            linearLayout.addView(h3, layoutParams3);
        } else if (i2 == 3) {
            linearLayout.setOrientation(1);
            View g3 = g(context, bVar.f12219b, onClickListener);
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, f54094a);
            layoutParams4.setMargins(d.a.c.e.p.l.g(context, R.dimen.M_W_X012), 0, d.a.c.e.p.l.g(context, R.dimen.M_W_X012), d.a.c.e.p.l.g(context, R.dimen.M_H_X005));
            linearLayout.addView(g3, layoutParams4);
            View g4 = g(context, bVar.f12220c, onClickListener);
            LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, f54094a);
            layoutParams5.setMargins(d.a.c.e.p.l.g(context, R.dimen.M_W_X012), 0, d.a.c.e.p.l.g(context, R.dimen.M_W_X012), d.a.c.e.p.l.g(context, R.dimen.M_H_X005));
            linearLayout.addView(g4, layoutParams5);
            View g5 = g(context, bVar.f12221d, onClickListener);
            LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-1, f54094a);
            layoutParams6.setMargins(d.a.c.e.p.l.g(context, R.dimen.M_W_X012), 0, d.a.c.e.p.l.g(context, R.dimen.M_W_X012), 0);
            linearLayout.addView(g5, layoutParams6);
        }
        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        return linearLayout;
    }

    public static TextView j(@NonNull Context context) {
        TextView textView = new TextView(context);
        d.a.n0.r.u.c d2 = d.a.n0.r.u.c.d(textView);
        d2.w(R.dimen.T_X07);
        d2.u(R.color.CAM_X0105);
        d2.x(R.string.F_X01);
        d2.k(R.dimen.L_X02);
        d2.j(R.color.CAM_X0902);
        d2.m(R.string.J_X07);
        d2.g(17170445);
        textView.setMaxLines(1);
        textView.setSingleLine();
        textView.setGravity(17);
        return textView;
    }

    public static TextView k(@NonNull Context context) {
        EMTextView eMTextView = new EMTextView(context);
        d.a.n0.r.u.c d2 = d.a.n0.r.u.c.d(eMTextView);
        d2.w(R.dimen.T_X05);
        d2.s(R.color.CAM_X0105);
        d2.x(R.string.F_X02);
        eMTextView.setMaxLines(1);
        eMTextView.setSingleLine();
        eMTextView.setGravity(17);
        return eMTextView;
    }
}

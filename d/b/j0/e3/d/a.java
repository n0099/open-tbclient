package d.b.j0.e3.d;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadvert.view.CountDownTextView;
import d.b.c.e.p.l;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public Context f56121a;

    /* renamed from: b  reason: collision with root package name */
    public FrameLayout f56122b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f56123c;

    /* renamed from: d  reason: collision with root package name */
    public d f56124d;

    /* renamed from: d.b.j0.e3.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC1309a implements View.OnClickListener {
        public View$OnClickListenerC1309a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f56124d != null) {
                a.this.f56124d.a();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f56124d != null) {
                a.this.f56124d.b();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements CountDownTextView.c {
        public c() {
        }

        @Override // com.baidu.tieba.tbadvert.view.CountDownTextView.c
        public void a(View view) {
            if (a.this.f56124d != null) {
                a.this.f56124d.b();
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface d {
        void a();

        void b();
    }

    public a(Context context, d dVar) {
        this.f56124d = dVar;
        this.f56121a = context;
        this.f56122b = new FrameLayout(context);
    }

    public View b() {
        return this.f56122b;
    }

    public final void c() {
        TextView textView = new TextView(this.f56121a);
        textView.setText(R.string.tb_ad_label);
        int dimension = (int) this.f56121a.getResources().getDimension(R.dimen.ds28);
        textView.setTextSize(0, (int) this.f56121a.getResources().getDimension(R.dimen.ds22));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) this.f56121a.getResources().getDimension(R.dimen.ds68), (int) this.f56121a.getResources().getDimension(R.dimen.ds40));
        textView.setTextColor(-1);
        textView.setGravity(17);
        textView.setAlpha(0.5f);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-16777216);
        gradientDrawable.setCornerRadius(this.f56121a.getResources().getDimension(R.dimen.ds4));
        gradientDrawable.setStroke(1, -16777216);
        textView.setBackgroundDrawable(gradientDrawable);
        layoutParams.gravity = 83;
        layoutParams.setMargins(dimension, 0, 0, (int) this.f56121a.getResources().getDimension(R.dimen.ds28));
        this.f56122b.addView(textView, layoutParams);
    }

    public final void d(int i) {
        CountDownTextView countDownTextView = new CountDownTextView(this.f56121a);
        int dimension = (int) this.f56121a.getResources().getDimension(R.dimen.ds22);
        int dimension2 = (int) this.f56121a.getResources().getDimension(R.dimen.ds36);
        Context context = this.f56121a;
        if ((context instanceof Activity) && (UtilHelper.isNotchScreen((Activity) context) || UtilHelper.isCutoutScreen((Activity) this.f56121a))) {
            dimension2 += l.r((Activity) this.f56121a);
        }
        String string = this.f56121a.getResources().getString(R.string.skip);
        countDownTextView.setTextSize(0, dimension);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) this.f56121a.getResources().getDimension(R.dimen.ds106), (int) this.f56121a.getResources().getDimension(R.dimen.ds52));
        countDownTextView.setTextColor(-1);
        countDownTextView.setGravity(17);
        countDownTextView.setAlpha(0.5f);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-16777216);
        gradientDrawable.setCornerRadius(this.f56121a.getResources().getDimension(R.dimen.ds4));
        gradientDrawable.setStroke(1, -16777216);
        countDownTextView.setBackgroundDrawable(gradientDrawable);
        countDownTextView.d(string, i);
        layoutParams.gravity = 53;
        layoutParams.setMargins(0, dimension2, (int) this.f56121a.getResources().getDimension(R.dimen.ds32), 0);
        this.f56122b.addView(countDownTextView, layoutParams);
        countDownTextView.setOnClickListener(new b());
        countDownTextView.setTimeoutListener(new c());
    }

    public final void e(d.b.c.j.d.a aVar) {
        ImageView imageView = new ImageView(this.f56121a);
        this.f56123c = imageView;
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        if (aVar != null) {
            this.f56123c.setImageBitmap(aVar.p());
        }
        this.f56123c.setOnClickListener(new View$OnClickListenerC1309a());
        this.f56122b.addView(this.f56123c);
    }

    public void f(Object obj, int i) {
        if (obj instanceof d.b.c.j.d.a) {
            e((d.b.c.j.d.a) obj);
        }
        c();
        d(i);
    }
}

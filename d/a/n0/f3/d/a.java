package d.a.n0.f3.d;

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
import d.a.c.e.p.l;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public Context f54892a;

    /* renamed from: b  reason: collision with root package name */
    public FrameLayout f54893b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f54894c;

    /* renamed from: d  reason: collision with root package name */
    public d f54895d;

    /* renamed from: d.a.n0.f3.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC1338a implements View.OnClickListener {
        public View$OnClickListenerC1338a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f54895d != null) {
                a.this.f54895d.a();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f54895d != null) {
                a.this.f54895d.b();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements CountDownTextView.c {
        public c() {
        }

        @Override // com.baidu.tieba.tbadvert.view.CountDownTextView.c
        public void a(View view) {
            if (a.this.f54895d != null) {
                a.this.f54895d.b();
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface d {
        void a();

        void b();
    }

    public a(Context context, d dVar) {
        this.f54895d = dVar;
        this.f54892a = context;
        this.f54893b = new FrameLayout(context);
    }

    public View b() {
        return this.f54893b;
    }

    public final void c() {
        TextView textView = new TextView(this.f54892a);
        textView.setText(R.string.tb_ad_label);
        int dimension = (int) this.f54892a.getResources().getDimension(R.dimen.ds28);
        textView.setTextSize(0, (int) this.f54892a.getResources().getDimension(R.dimen.ds22));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) this.f54892a.getResources().getDimension(R.dimen.ds68), (int) this.f54892a.getResources().getDimension(R.dimen.ds40));
        textView.setTextColor(-1);
        textView.setGravity(17);
        textView.setAlpha(0.5f);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-16777216);
        gradientDrawable.setCornerRadius(this.f54892a.getResources().getDimension(R.dimen.ds4));
        gradientDrawable.setStroke(1, -16777216);
        textView.setBackgroundDrawable(gradientDrawable);
        layoutParams.gravity = 83;
        layoutParams.setMargins(dimension, 0, 0, (int) this.f54892a.getResources().getDimension(R.dimen.ds28));
        this.f54893b.addView(textView, layoutParams);
    }

    public final void d(int i2) {
        CountDownTextView countDownTextView = new CountDownTextView(this.f54892a);
        int dimension = (int) this.f54892a.getResources().getDimension(R.dimen.ds22);
        int dimension2 = (int) this.f54892a.getResources().getDimension(R.dimen.ds36);
        Context context = this.f54892a;
        if ((context instanceof Activity) && (UtilHelper.isNotchScreen((Activity) context) || UtilHelper.isCutoutScreen((Activity) this.f54892a))) {
            dimension2 += l.r((Activity) this.f54892a);
        }
        String string = this.f54892a.getResources().getString(R.string.skip);
        countDownTextView.setTextSize(0, dimension);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) this.f54892a.getResources().getDimension(R.dimen.ds106), (int) this.f54892a.getResources().getDimension(R.dimen.ds52));
        countDownTextView.setTextColor(-1);
        countDownTextView.setGravity(17);
        countDownTextView.setAlpha(0.5f);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-16777216);
        gradientDrawable.setCornerRadius(this.f54892a.getResources().getDimension(R.dimen.ds4));
        gradientDrawable.setStroke(1, -16777216);
        countDownTextView.setBackgroundDrawable(gradientDrawable);
        countDownTextView.d(string, i2);
        layoutParams.gravity = 53;
        layoutParams.setMargins(0, dimension2, (int) this.f54892a.getResources().getDimension(R.dimen.ds32), 0);
        this.f54893b.addView(countDownTextView, layoutParams);
        countDownTextView.setOnClickListener(new b());
        countDownTextView.setTimeoutListener(new c());
    }

    public final void e(d.a.c.j.d.a aVar) {
        ImageView imageView = new ImageView(this.f54892a);
        this.f54894c = imageView;
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        if (aVar != null) {
            this.f54894c.setImageBitmap(aVar.p());
        }
        this.f54894c.setOnClickListener(new View$OnClickListenerC1338a());
        this.f54893b.addView(this.f54894c);
    }

    public void f(Object obj, int i2) {
        if (obj instanceof d.a.c.j.d.a) {
            e((d.a.c.j.d.a) obj);
        }
        c();
        d(i2);
    }
}

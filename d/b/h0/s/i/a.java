package d.b.h0.s.i;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.coreExtra.view.AbsFloorImageTextView;
import com.baidu.tbadk.coreExtra.view.FloorImageTextViewNew;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.coreExtra.view.ImageViewerBottomLayout;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public Context f51379a;

    /* renamed from: b  reason: collision with root package name */
    public ImageViewerBottomLayout f51380b;

    /* renamed from: c  reason: collision with root package name */
    public AbsFloorImageTextView f51381c;

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f51382d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f51383e = true;

    /* renamed from: f  reason: collision with root package name */
    public final ImageViewerBottomLayout.a f51384f = new C1099a();

    /* renamed from: d.b.h0.s.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1099a implements ImageViewerBottomLayout.a {
        public C1099a() {
        }

        @Override // com.baidu.tbadk.coreExtra.view.ImageViewerBottomLayout.a
        public void a(ImageViewerBottomLayout imageViewerBottomLayout, boolean z) {
            a.this.f51383e = z;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016496, Boolean.valueOf(a.this.f51383e)));
            a.this.p(z);
        }
    }

    public a(@NonNull Context context, @NonNull RelativeLayout relativeLayout) {
        this.f51379a = context;
        LinearLayout linearLayout = new LinearLayout(context);
        this.f51382d = linearLayout;
        linearLayout.setOrientation(1);
        this.f51382d.setVisibility(8);
        SkinManager.setBackgroundColorToTransparent(this.f51382d, R.color.CAM_X0607, GradientDrawable.Orientation.BOTTOM_TOP);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        relativeLayout.addView(this.f51382d, layoutParams);
        d();
        e();
    }

    public int c() {
        ImageViewerBottomLayout imageViewerBottomLayout = this.f51380b;
        if (imageViewerBottomLayout == null || this.f51381c == null) {
            return 0;
        }
        return imageViewerBottomLayout.getHeight() + AbsFloorImageTextView.m;
    }

    public final void d() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        FloorImageTextViewNew floorImageTextViewNew = new FloorImageTextViewNew(this.f51379a);
        this.f51381c = floorImageTextViewNew;
        this.f51382d.addView(floorImageTextViewNew, layoutParams);
    }

    public final void e() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, ImageViewerBottomLayout.u);
        ImageViewerBottomLayout imageViewerBottomLayout = new ImageViewerBottomLayout(this.f51379a);
        this.f51380b = imageViewerBottomLayout;
        this.f51382d.addView(imageViewerBottomLayout, layoutParams);
        this.f51380b.setExpandButtonListener(this.f51384f);
    }

    public boolean f() {
        return this.f51383e;
    }

    public boolean g() {
        return h(this.f51382d);
    }

    public final boolean h(View view) {
        return view != null && view.getVisibility() == 0;
    }

    public void i(ImageUrlData imageUrlData) {
        AbsFloorImageTextView absFloorImageTextView = this.f51381c;
        if (absFloorImageTextView != null) {
            absFloorImageTextView.f(imageUrlData);
        }
        ImageViewerBottomLayout imageViewerBottomLayout = this.f51380b;
        if (imageViewerBottomLayout != null) {
            imageViewerBottomLayout.d(imageUrlData);
        }
    }

    public void j(ImageViewerBottomLayout.b bVar) {
        ImageViewerBottomLayout imageViewerBottomLayout = this.f51380b;
        if (imageViewerBottomLayout != null) {
            imageViewerBottomLayout.setOnDownloadImageListener(bVar);
        }
    }

    public void k(View.OnClickListener onClickListener) {
        ImageViewerBottomLayout imageViewerBottomLayout = this.f51380b;
        if (imageViewerBottomLayout != null) {
            imageViewerBottomLayout.setOnReplyClickListener(onClickListener);
        }
    }

    public void l(ImageViewerBottomLayout.c cVar) {
        ImageViewerBottomLayout imageViewerBottomLayout = this.f51380b;
        if (imageViewerBottomLayout != null) {
            imageViewerBottomLayout.setOnShareImageListener(cVar);
        }
    }

    public void m(String str) {
        AbsFloorImageTextView absFloorImageTextView = this.f51381c;
        if (absFloorImageTextView != null) {
            absFloorImageTextView.setUserId(str);
        }
        ImageViewerBottomLayout imageViewerBottomLayout = this.f51380b;
        if (imageViewerBottomLayout != null) {
            imageViewerBottomLayout.setUserId(str);
        }
    }

    public void n(int i) {
        LinearLayout linearLayout = this.f51382d;
        if (linearLayout != null) {
            linearLayout.clearAnimation();
            this.f51382d.setVisibility(i);
        }
    }

    public void o(int i, int i2) {
        if (i == 0) {
            d.b.i0.o3.a.c(this.f51382d, i2);
        } else {
            d.b.i0.o3.a.a(this.f51382d, i2);
        }
    }

    public void p(boolean z) {
        AbsFloorImageTextView absFloorImageTextView = this.f51381c;
        if (absFloorImageTextView != null) {
            absFloorImageTextView.e(z);
        }
        ImageViewerBottomLayout imageViewerBottomLayout = this.f51380b;
        if (imageViewerBottomLayout != null) {
            imageViewerBottomLayout.e(!z);
        }
    }
}

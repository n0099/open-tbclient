package d.a.j0.s.i;

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
    public Context f50616a;

    /* renamed from: b  reason: collision with root package name */
    public ImageViewerBottomLayout f50617b;

    /* renamed from: c  reason: collision with root package name */
    public AbsFloorImageTextView f50618c;

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f50619d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f50620e = true;

    /* renamed from: f  reason: collision with root package name */
    public final ImageViewerBottomLayout.a f50621f = new C1149a();

    /* renamed from: d.a.j0.s.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1149a implements ImageViewerBottomLayout.a {
        public C1149a() {
        }

        @Override // com.baidu.tbadk.coreExtra.view.ImageViewerBottomLayout.a
        public void a(ImageViewerBottomLayout imageViewerBottomLayout, boolean z) {
            a.this.f50620e = z;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016496, Boolean.valueOf(a.this.f50620e)));
            a.this.p(z);
        }
    }

    public a(@NonNull Context context, @NonNull RelativeLayout relativeLayout) {
        this.f50616a = context;
        LinearLayout linearLayout = new LinearLayout(context);
        this.f50619d = linearLayout;
        linearLayout.setOrientation(1);
        this.f50619d.setVisibility(8);
        SkinManager.setBackgroundColorToTransparent(this.f50619d, R.color.CAM_X0607, GradientDrawable.Orientation.BOTTOM_TOP);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        relativeLayout.addView(this.f50619d, layoutParams);
        d();
        e();
    }

    public int c() {
        ImageViewerBottomLayout imageViewerBottomLayout = this.f50617b;
        if (imageViewerBottomLayout == null || this.f50618c == null) {
            return 0;
        }
        return imageViewerBottomLayout.getHeight() + AbsFloorImageTextView.m;
    }

    public final void d() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        FloorImageTextViewNew floorImageTextViewNew = new FloorImageTextViewNew(this.f50616a);
        this.f50618c = floorImageTextViewNew;
        this.f50619d.addView(floorImageTextViewNew, layoutParams);
    }

    public final void e() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, ImageViewerBottomLayout.u);
        ImageViewerBottomLayout imageViewerBottomLayout = new ImageViewerBottomLayout(this.f50616a);
        this.f50617b = imageViewerBottomLayout;
        this.f50619d.addView(imageViewerBottomLayout, layoutParams);
        this.f50617b.setExpandButtonListener(this.f50621f);
    }

    public boolean f() {
        return this.f50620e;
    }

    public boolean g() {
        return h(this.f50619d);
    }

    public final boolean h(View view) {
        return view != null && view.getVisibility() == 0;
    }

    public void i(ImageUrlData imageUrlData) {
        AbsFloorImageTextView absFloorImageTextView = this.f50618c;
        if (absFloorImageTextView != null) {
            absFloorImageTextView.f(imageUrlData);
        }
        ImageViewerBottomLayout imageViewerBottomLayout = this.f50617b;
        if (imageViewerBottomLayout != null) {
            imageViewerBottomLayout.d(imageUrlData);
        }
    }

    public void j(ImageViewerBottomLayout.b bVar) {
        ImageViewerBottomLayout imageViewerBottomLayout = this.f50617b;
        if (imageViewerBottomLayout != null) {
            imageViewerBottomLayout.setOnDownloadImageListener(bVar);
        }
    }

    public void k(View.OnClickListener onClickListener) {
        ImageViewerBottomLayout imageViewerBottomLayout = this.f50617b;
        if (imageViewerBottomLayout != null) {
            imageViewerBottomLayout.setOnReplyClickListener(onClickListener);
        }
    }

    public void l(ImageViewerBottomLayout.c cVar) {
        ImageViewerBottomLayout imageViewerBottomLayout = this.f50617b;
        if (imageViewerBottomLayout != null) {
            imageViewerBottomLayout.setOnShareImageListener(cVar);
        }
    }

    public void m(String str) {
        AbsFloorImageTextView absFloorImageTextView = this.f50618c;
        if (absFloorImageTextView != null) {
            absFloorImageTextView.setUserId(str);
        }
        ImageViewerBottomLayout imageViewerBottomLayout = this.f50617b;
        if (imageViewerBottomLayout != null) {
            imageViewerBottomLayout.setUserId(str);
        }
    }

    public void n(int i2) {
        LinearLayout linearLayout = this.f50619d;
        if (linearLayout != null) {
            linearLayout.clearAnimation();
            this.f50619d.setVisibility(i2);
        }
    }

    public void o(int i2, int i3) {
        if (i2 == 0) {
            d.a.k0.p3.a.c(this.f50619d, i3);
        } else {
            d.a.k0.p3.a.a(this.f50619d, i3);
        }
    }

    public void p(boolean z) {
        AbsFloorImageTextView absFloorImageTextView = this.f50618c;
        if (absFloorImageTextView != null) {
            absFloorImageTextView.e(z);
        }
        ImageViewerBottomLayout imageViewerBottomLayout = this.f50617b;
        if (imageViewerBottomLayout != null) {
            imageViewerBottomLayout.e(!z);
        }
    }
}

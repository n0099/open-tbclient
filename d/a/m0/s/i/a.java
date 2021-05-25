package d.a.m0.s.i;

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
    public Context f50689a;

    /* renamed from: b  reason: collision with root package name */
    public ImageViewerBottomLayout f50690b;

    /* renamed from: c  reason: collision with root package name */
    public AbsFloorImageTextView f50691c;

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f50692d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f50693e = true;

    /* renamed from: f  reason: collision with root package name */
    public final ImageViewerBottomLayout.a f50694f = new C1158a();

    /* renamed from: d.a.m0.s.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1158a implements ImageViewerBottomLayout.a {
        public C1158a() {
        }

        @Override // com.baidu.tbadk.coreExtra.view.ImageViewerBottomLayout.a
        public void a(ImageViewerBottomLayout imageViewerBottomLayout, boolean z) {
            a.this.f50693e = z;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016496, Boolean.valueOf(a.this.f50693e)));
            a.this.q(z);
        }
    }

    public a(@NonNull Context context, @NonNull RelativeLayout relativeLayout) {
        this.f50689a = context;
        LinearLayout linearLayout = new LinearLayout(context);
        this.f50692d = linearLayout;
        linearLayout.setOrientation(1);
        this.f50692d.setVisibility(8);
        SkinManager.setBackgroundColorToTransparent(this.f50692d, R.color.CAM_X0607, GradientDrawable.Orientation.BOTTOM_TOP);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        relativeLayout.addView(this.f50692d, layoutParams);
        d();
        e();
    }

    public int c() {
        ImageViewerBottomLayout imageViewerBottomLayout = this.f50690b;
        if (imageViewerBottomLayout == null || this.f50691c == null) {
            return 0;
        }
        return imageViewerBottomLayout.getHeight() + AbsFloorImageTextView.m;
    }

    public final void d() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        FloorImageTextViewNew floorImageTextViewNew = new FloorImageTextViewNew(this.f50689a);
        this.f50691c = floorImageTextViewNew;
        this.f50692d.addView(floorImageTextViewNew, layoutParams);
    }

    public final void e() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, ImageViewerBottomLayout.v);
        ImageViewerBottomLayout imageViewerBottomLayout = new ImageViewerBottomLayout(this.f50689a);
        this.f50690b = imageViewerBottomLayout;
        this.f50692d.addView(imageViewerBottomLayout, layoutParams);
        this.f50690b.setExpandButtonListener(this.f50694f);
    }

    public boolean f() {
        return this.f50693e;
    }

    public boolean g() {
        return h(this.f50692d);
    }

    public final boolean h(View view) {
        return view != null && view.getVisibility() == 0;
    }

    public void i(ImageUrlData imageUrlData) {
        AbsFloorImageTextView absFloorImageTextView = this.f50691c;
        if (absFloorImageTextView != null) {
            absFloorImageTextView.f(imageUrlData);
        }
        ImageViewerBottomLayout imageViewerBottomLayout = this.f50690b;
        if (imageViewerBottomLayout != null) {
            imageViewerBottomLayout.d(imageUrlData);
        }
    }

    public void j(ImageViewerBottomLayout.b bVar) {
        ImageViewerBottomLayout imageViewerBottomLayout = this.f50690b;
        if (imageViewerBottomLayout != null) {
            imageViewerBottomLayout.setOnDownloadImageListener(bVar);
        }
    }

    public void k(View.OnClickListener onClickListener) {
        ImageViewerBottomLayout imageViewerBottomLayout = this.f50690b;
        if (imageViewerBottomLayout != null) {
            imageViewerBottomLayout.setOnReplyClickListener(onClickListener);
        }
    }

    public void l(ImageViewerBottomLayout.c cVar) {
        ImageViewerBottomLayout imageViewerBottomLayout = this.f50690b;
        if (imageViewerBottomLayout != null) {
            imageViewerBottomLayout.setOnShareImageListener(cVar);
        }
    }

    public void m(String str) {
        AbsFloorImageTextView absFloorImageTextView = this.f50691c;
        if (absFloorImageTextView != null) {
            absFloorImageTextView.setUserId(str);
        }
        ImageViewerBottomLayout imageViewerBottomLayout = this.f50690b;
        if (imageViewerBottomLayout != null) {
            imageViewerBottomLayout.setUserId(str);
        }
    }

    public void n(int i2) {
        LinearLayout linearLayout = this.f50692d;
        if (linearLayout != null) {
            linearLayout.clearAnimation();
            this.f50692d.setVisibility(i2);
        }
    }

    public void o(int i2, int i3) {
        if (i2 == 0) {
            d.a.n0.q3.a.c(this.f50692d, i3);
        } else {
            d.a.n0.q3.a.a(this.f50692d, i3);
        }
    }

    public void p(boolean z) {
        ImageViewerBottomLayout imageViewerBottomLayout = this.f50690b;
        if (imageViewerBottomLayout != null) {
            imageViewerBottomLayout.setYoungterCoverSomeView(z);
        }
    }

    public void q(boolean z) {
        AbsFloorImageTextView absFloorImageTextView = this.f50691c;
        if (absFloorImageTextView != null) {
            absFloorImageTextView.e(z);
        }
        ImageViewerBottomLayout imageViewerBottomLayout = this.f50690b;
        if (imageViewerBottomLayout != null) {
            imageViewerBottomLayout.e(!z);
        }
    }
}

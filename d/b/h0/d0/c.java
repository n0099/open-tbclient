package d.b.h0.d0;

import android.content.Context;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class c extends d.b.h0.d0.a {

    /* renamed from: a  reason: collision with root package name */
    public NestedScrollView f50091a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f50092b;

    /* renamed from: c  reason: collision with root package name */
    public TbImageView f50093c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f50094d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f50095e;

    /* renamed from: f  reason: collision with root package name */
    public TBSpecificationBtn f50096f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f50097g;

    /* renamed from: h  reason: collision with root package name */
    public int f50098h;
    public Rect i;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.a(-1);
        }
    }

    public c(Context context, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(context).inflate(R.layout.frs_net_refresh_view_layout, (ViewGroup) null));
        this.f50098h = 0;
        this.i = new Rect();
        this.f50091a = (NestedScrollView) this.attachedView.findViewById(R.id.scrollview);
        this.f50092b = (LinearLayout) this.attachedView.findViewById(R.id.container);
        this.f50093c = (TbImageView) this.attachedView.findViewById(R.id.net_refresh_image);
        this.f50094d = (TextView) this.attachedView.findViewById(R.id.net_refresh_desc);
        this.f50095e = (TextView) this.attachedView.findViewById(R.id.net_refresh_title);
        this.f50097g = (LinearLayout) this.attachedView.findViewById(R.id.net_refresh_info_layout);
        this.f50096f = (TBSpecificationBtn) this.attachedView.findViewById(R.id.net_refresh_button);
        d.b.h0.r.f0.m.a aVar = new d.b.h0.r.f0.m.a();
        this.f50096f.setText(context.getResources().getString(R.string.refresh_view_button_text));
        this.f50096f.setTextSize(R.dimen.tbds42);
        this.f50096f.setConfig(aVar);
        this.f50096f.setOnClickListener(onClickListener);
        this.attachedView.setOnClickListener(null);
    }

    public void a(int i) {
        if (this.f50098h <= 0) {
            this.f50098h = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds156);
        }
        NestedScrollView nestedScrollView = this.f50091a;
        if (nestedScrollView == null) {
            return;
        }
        if (i == 0) {
            nestedScrollView.post(new a());
        }
        if (this.f50091a.getLocalVisibleRect(this.i)) {
            int i2 = this.i.bottom;
            int abs = Math.abs(this.f50092b.getTop());
            int abs2 = i2 - Math.abs(this.f50092b.getBottom());
            ViewGroup.LayoutParams layoutParams = this.f50092b.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                int i3 = this.f50098h;
                if (abs < i3) {
                    marginLayoutParams.topMargin = i3;
                    this.f50092b.setLayoutParams(marginLayoutParams);
                } else if (abs == i3) {
                    if (abs2 > i3) {
                        marginLayoutParams.topMargin = i3 + ((abs2 - i3) / 2);
                        this.f50092b.setLayoutParams(marginLayoutParams);
                    }
                } else if (abs > i3) {
                    if (abs2 < i3) {
                        marginLayoutParams.topMargin = i3;
                    } else if (abs2 == i3) {
                        marginLayoutParams.topMargin = i3;
                    } else if (abs2 > i3) {
                        marginLayoutParams.topMargin = (abs + abs2) / 2;
                    }
                    this.f50092b.setLayoutParams(marginLayoutParams);
                }
            }
        }
    }

    public View b() {
        return this.attachedView;
    }

    public void c(String str) {
        if (str == null) {
            return;
        }
        this.f50096f.setText(str);
    }

    public void d(String str) {
        if (str == null) {
            this.f50094d.setVisibility(8);
            return;
        }
        this.f50094d.setVisibility(0);
        this.f50094d.setText(str);
    }

    public void e(String str) {
        if (str == null) {
            return;
        }
        this.f50095e.setText(str);
    }

    public void f() {
        this.f50096f.setVisibility(0);
        this.f50095e.setVisibility(0);
        SkinManager.setViewTextColor(this.f50094d, R.color.CAM_X0109, 1);
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        SkinManager.setImageResource(this.f50093c, R.drawable.new_pic_emotion_08);
        SkinManager.setViewTextColor(this.f50094d, R.color.CAM_X0109, 1, skinType);
        SkinManager.setViewTextColor(this.f50095e, R.color.CAM_X0107, 1, skinType);
        SkinManager.setBackgroundColor(this.attachedView, R.color.CAM_X0201);
        TBSpecificationBtn tBSpecificationBtn = this.f50096f;
        if (tBSpecificationBtn != null) {
            tBSpecificationBtn.k();
        }
    }

    @Override // d.b.h0.d0.a
    public void onViewAttached() {
        super.onViewAttached();
        onChangeSkinType();
    }

    @Override // d.b.h0.d0.a
    public void onViewDettached() {
        super.onViewDettached();
        this.f50093c.setImageResource(0);
    }
}

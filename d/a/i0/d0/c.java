package d.a.i0.d0;

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
public class c extends d.a.i0.d0.a {

    /* renamed from: a  reason: collision with root package name */
    public NestedScrollView f48396a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f48397b;

    /* renamed from: c  reason: collision with root package name */
    public TbImageView f48398c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f48399d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f48400e;

    /* renamed from: f  reason: collision with root package name */
    public TBSpecificationBtn f48401f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f48402g;

    /* renamed from: h  reason: collision with root package name */
    public int f48403h;

    /* renamed from: i  reason: collision with root package name */
    public Rect f48404i;

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
        this.f48403h = 0;
        this.f48404i = new Rect();
        this.f48396a = (NestedScrollView) this.attachedView.findViewById(R.id.scrollview);
        this.f48397b = (LinearLayout) this.attachedView.findViewById(R.id.container);
        this.f48398c = (TbImageView) this.attachedView.findViewById(R.id.net_refresh_image);
        this.f48399d = (TextView) this.attachedView.findViewById(R.id.net_refresh_desc);
        this.f48400e = (TextView) this.attachedView.findViewById(R.id.net_refresh_title);
        this.f48402g = (LinearLayout) this.attachedView.findViewById(R.id.net_refresh_info_layout);
        this.f48401f = (TBSpecificationBtn) this.attachedView.findViewById(R.id.net_refresh_button);
        d.a.i0.r.f0.m.a aVar = new d.a.i0.r.f0.m.a();
        this.f48401f.setText(context.getResources().getString(R.string.refresh_view_button_text));
        this.f48401f.setTextSize(R.dimen.tbds42);
        this.f48401f.setConfig(aVar);
        this.f48401f.setOnClickListener(onClickListener);
        this.attachedView.setOnClickListener(null);
    }

    public void a(int i2) {
        if (this.f48403h <= 0) {
            this.f48403h = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds156);
        }
        NestedScrollView nestedScrollView = this.f48396a;
        if (nestedScrollView == null) {
            return;
        }
        if (i2 == 0) {
            nestedScrollView.post(new a());
        }
        if (this.f48396a.getLocalVisibleRect(this.f48404i)) {
            int i3 = this.f48404i.bottom;
            int abs = Math.abs(this.f48397b.getTop());
            int abs2 = i3 - Math.abs(this.f48397b.getBottom());
            ViewGroup.LayoutParams layoutParams = this.f48397b.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                int i4 = this.f48403h;
                if (abs < i4) {
                    marginLayoutParams.topMargin = i4;
                    this.f48397b.setLayoutParams(marginLayoutParams);
                } else if (abs == i4) {
                    if (abs2 > i4) {
                        marginLayoutParams.topMargin = i4 + ((abs2 - i4) / 2);
                        this.f48397b.setLayoutParams(marginLayoutParams);
                    }
                } else if (abs > i4) {
                    if (abs2 < i4) {
                        marginLayoutParams.topMargin = i4;
                    } else if (abs2 == i4) {
                        marginLayoutParams.topMargin = i4;
                    } else if (abs2 > i4) {
                        marginLayoutParams.topMargin = (abs + abs2) / 2;
                    }
                    this.f48397b.setLayoutParams(marginLayoutParams);
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
        this.f48401f.setText(str);
    }

    public void d(String str) {
        if (str == null) {
            this.f48399d.setVisibility(8);
            return;
        }
        this.f48399d.setVisibility(0);
        this.f48399d.setText(str);
    }

    public void e(String str) {
        if (str == null) {
            return;
        }
        this.f48400e.setText(str);
    }

    public void f() {
        this.f48401f.setVisibility(0);
        this.f48400e.setVisibility(0);
        SkinManager.setViewTextColor(this.f48399d, R.color.CAM_X0109, 1);
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        SkinManager.setImageResource(this.f48398c, R.drawable.new_pic_emotion_08);
        SkinManager.setViewTextColor(this.f48399d, R.color.CAM_X0109, 1, skinType);
        SkinManager.setViewTextColor(this.f48400e, R.color.CAM_X0107, 1, skinType);
        SkinManager.setBackgroundColor(this.attachedView, R.color.CAM_X0201);
        TBSpecificationBtn tBSpecificationBtn = this.f48401f;
        if (tBSpecificationBtn != null) {
            tBSpecificationBtn.k();
        }
    }

    @Override // d.a.i0.d0.a
    public void onViewAttached() {
        super.onViewAttached();
        onChangeSkinType();
    }

    @Override // d.a.i0.d0.a
    public void onViewDettached() {
        super.onViewDettached();
        this.f48398c.setImageResource(0);
    }
}

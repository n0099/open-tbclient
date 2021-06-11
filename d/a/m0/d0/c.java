package d.a.m0.d0;

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
public class c extends d.a.m0.d0.a {

    /* renamed from: a  reason: collision with root package name */
    public NestedScrollView f52942a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f52943b;

    /* renamed from: c  reason: collision with root package name */
    public TbImageView f52944c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f52945d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f52946e;

    /* renamed from: f  reason: collision with root package name */
    public TBSpecificationBtn f52947f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f52948g;

    /* renamed from: h  reason: collision with root package name */
    public int f52949h;

    /* renamed from: i  reason: collision with root package name */
    public Rect f52950i;

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
        this.f52949h = 0;
        this.f52950i = new Rect();
        this.f52942a = (NestedScrollView) this.attachedView.findViewById(R.id.scrollview);
        this.f52943b = (LinearLayout) this.attachedView.findViewById(R.id.container);
        this.f52944c = (TbImageView) this.attachedView.findViewById(R.id.net_refresh_image);
        this.f52945d = (TextView) this.attachedView.findViewById(R.id.net_refresh_desc);
        this.f52946e = (TextView) this.attachedView.findViewById(R.id.net_refresh_title);
        this.f52948g = (LinearLayout) this.attachedView.findViewById(R.id.net_refresh_info_layout);
        this.f52947f = (TBSpecificationBtn) this.attachedView.findViewById(R.id.net_refresh_button);
        d.a.m0.r.f0.m.a aVar = new d.a.m0.r.f0.m.a();
        this.f52947f.setText(context.getResources().getString(R.string.refresh_view_button_text));
        this.f52947f.setTextSize(R.dimen.tbds42);
        this.f52947f.setConfig(aVar);
        this.f52947f.setOnClickListener(onClickListener);
        this.attachedView.setOnClickListener(null);
    }

    public void a(int i2) {
        if (this.f52949h <= 0) {
            this.f52949h = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds156);
        }
        NestedScrollView nestedScrollView = this.f52942a;
        if (nestedScrollView == null) {
            return;
        }
        if (i2 == 0) {
            nestedScrollView.post(new a());
        }
        if (this.f52942a.getLocalVisibleRect(this.f52950i)) {
            int i3 = this.f52950i.bottom;
            int abs = Math.abs(this.f52943b.getTop());
            int abs2 = i3 - Math.abs(this.f52943b.getBottom());
            ViewGroup.LayoutParams layoutParams = this.f52943b.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                int i4 = this.f52949h;
                if (abs < i4) {
                    marginLayoutParams.topMargin = i4;
                    this.f52943b.setLayoutParams(marginLayoutParams);
                } else if (abs == i4) {
                    if (abs2 > i4) {
                        marginLayoutParams.topMargin = i4 + ((abs2 - i4) / 2);
                        this.f52943b.setLayoutParams(marginLayoutParams);
                    }
                } else if (abs > i4) {
                    if (abs2 < i4) {
                        marginLayoutParams.topMargin = i4;
                    } else if (abs2 == i4) {
                        marginLayoutParams.topMargin = i4;
                    } else if (abs2 > i4) {
                        marginLayoutParams.topMargin = (abs + abs2) / 2;
                    }
                    this.f52943b.setLayoutParams(marginLayoutParams);
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
        this.f52947f.setText(str);
    }

    public void d(String str) {
        if (str == null) {
            this.f52945d.setVisibility(8);
            return;
        }
        this.f52945d.setVisibility(0);
        this.f52945d.setText(str);
    }

    public void e(String str) {
        if (str == null) {
            return;
        }
        this.f52946e.setText(str);
    }

    public void f() {
        this.f52947f.setVisibility(0);
        this.f52946e.setVisibility(0);
        SkinManager.setViewTextColor(this.f52945d, R.color.CAM_X0109, 1);
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        SkinManager.setImageResource(this.f52944c, R.drawable.new_pic_emotion_08);
        SkinManager.setViewTextColor(this.f52945d, R.color.CAM_X0109, 1, skinType);
        SkinManager.setViewTextColor(this.f52946e, R.color.CAM_X0107, 1, skinType);
        SkinManager.setBackgroundColor(this.attachedView, R.color.CAM_X0201);
        TBSpecificationBtn tBSpecificationBtn = this.f52947f;
        if (tBSpecificationBtn != null) {
            tBSpecificationBtn.k();
        }
    }

    @Override // d.a.m0.d0.a
    public void onViewAttached() {
        super.onViewAttached();
        onChangeSkinType();
    }

    @Override // d.a.m0.d0.a
    public void onViewDettached() {
        super.onViewDettached();
        this.f52944c.setImageResource(0);
    }
}

package d.a.j0.d0;

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
public class c extends d.a.j0.d0.a {

    /* renamed from: a  reason: collision with root package name */
    public NestedScrollView f49224a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f49225b;

    /* renamed from: c  reason: collision with root package name */
    public TbImageView f49226c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f49227d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f49228e;

    /* renamed from: f  reason: collision with root package name */
    public TBSpecificationBtn f49229f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f49230g;

    /* renamed from: h  reason: collision with root package name */
    public int f49231h;

    /* renamed from: i  reason: collision with root package name */
    public Rect f49232i;

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
        this.f49231h = 0;
        this.f49232i = new Rect();
        this.f49224a = (NestedScrollView) this.attachedView.findViewById(R.id.scrollview);
        this.f49225b = (LinearLayout) this.attachedView.findViewById(R.id.container);
        this.f49226c = (TbImageView) this.attachedView.findViewById(R.id.net_refresh_image);
        this.f49227d = (TextView) this.attachedView.findViewById(R.id.net_refresh_desc);
        this.f49228e = (TextView) this.attachedView.findViewById(R.id.net_refresh_title);
        this.f49230g = (LinearLayout) this.attachedView.findViewById(R.id.net_refresh_info_layout);
        this.f49229f = (TBSpecificationBtn) this.attachedView.findViewById(R.id.net_refresh_button);
        d.a.j0.r.f0.m.a aVar = new d.a.j0.r.f0.m.a();
        this.f49229f.setText(context.getResources().getString(R.string.refresh_view_button_text));
        this.f49229f.setTextSize(R.dimen.tbds42);
        this.f49229f.setConfig(aVar);
        this.f49229f.setOnClickListener(onClickListener);
        this.attachedView.setOnClickListener(null);
    }

    public void a(int i2) {
        if (this.f49231h <= 0) {
            this.f49231h = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds156);
        }
        NestedScrollView nestedScrollView = this.f49224a;
        if (nestedScrollView == null) {
            return;
        }
        if (i2 == 0) {
            nestedScrollView.post(new a());
        }
        if (this.f49224a.getLocalVisibleRect(this.f49232i)) {
            int i3 = this.f49232i.bottom;
            int abs = Math.abs(this.f49225b.getTop());
            int abs2 = i3 - Math.abs(this.f49225b.getBottom());
            ViewGroup.LayoutParams layoutParams = this.f49225b.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                int i4 = this.f49231h;
                if (abs < i4) {
                    marginLayoutParams.topMargin = i4;
                    this.f49225b.setLayoutParams(marginLayoutParams);
                } else if (abs == i4) {
                    if (abs2 > i4) {
                        marginLayoutParams.topMargin = i4 + ((abs2 - i4) / 2);
                        this.f49225b.setLayoutParams(marginLayoutParams);
                    }
                } else if (abs > i4) {
                    if (abs2 < i4) {
                        marginLayoutParams.topMargin = i4;
                    } else if (abs2 == i4) {
                        marginLayoutParams.topMargin = i4;
                    } else if (abs2 > i4) {
                        marginLayoutParams.topMargin = (abs + abs2) / 2;
                    }
                    this.f49225b.setLayoutParams(marginLayoutParams);
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
        this.f49229f.setText(str);
    }

    public void d(String str) {
        if (str == null) {
            this.f49227d.setVisibility(8);
            return;
        }
        this.f49227d.setVisibility(0);
        this.f49227d.setText(str);
    }

    public void e(String str) {
        if (str == null) {
            return;
        }
        this.f49228e.setText(str);
    }

    public void f() {
        this.f49229f.setVisibility(0);
        this.f49228e.setVisibility(0);
        SkinManager.setViewTextColor(this.f49227d, R.color.CAM_X0109, 1);
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        SkinManager.setImageResource(this.f49226c, R.drawable.new_pic_emotion_08);
        SkinManager.setViewTextColor(this.f49227d, R.color.CAM_X0109, 1, skinType);
        SkinManager.setViewTextColor(this.f49228e, R.color.CAM_X0107, 1, skinType);
        SkinManager.setBackgroundColor(this.attachedView, R.color.CAM_X0201);
        TBSpecificationBtn tBSpecificationBtn = this.f49229f;
        if (tBSpecificationBtn != null) {
            tBSpecificationBtn.k();
        }
    }

    @Override // d.a.j0.d0.a
    public void onViewAttached() {
        super.onViewAttached();
        onChangeSkinType();
    }

    @Override // d.a.j0.d0.a
    public void onViewDettached() {
        super.onViewDettached();
        this.f49226c.setImageResource(0);
    }
}

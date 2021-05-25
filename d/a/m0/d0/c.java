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
    public NestedScrollView f49268a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f49269b;

    /* renamed from: c  reason: collision with root package name */
    public TbImageView f49270c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f49271d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f49272e;

    /* renamed from: f  reason: collision with root package name */
    public TBSpecificationBtn f49273f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f49274g;

    /* renamed from: h  reason: collision with root package name */
    public int f49275h;

    /* renamed from: i  reason: collision with root package name */
    public Rect f49276i;

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
        this.f49275h = 0;
        this.f49276i = new Rect();
        this.f49268a = (NestedScrollView) this.attachedView.findViewById(R.id.scrollview);
        this.f49269b = (LinearLayout) this.attachedView.findViewById(R.id.container);
        this.f49270c = (TbImageView) this.attachedView.findViewById(R.id.net_refresh_image);
        this.f49271d = (TextView) this.attachedView.findViewById(R.id.net_refresh_desc);
        this.f49272e = (TextView) this.attachedView.findViewById(R.id.net_refresh_title);
        this.f49274g = (LinearLayout) this.attachedView.findViewById(R.id.net_refresh_info_layout);
        this.f49273f = (TBSpecificationBtn) this.attachedView.findViewById(R.id.net_refresh_button);
        d.a.m0.r.f0.m.a aVar = new d.a.m0.r.f0.m.a();
        this.f49273f.setText(context.getResources().getString(R.string.refresh_view_button_text));
        this.f49273f.setTextSize(R.dimen.tbds42);
        this.f49273f.setConfig(aVar);
        this.f49273f.setOnClickListener(onClickListener);
        this.attachedView.setOnClickListener(null);
    }

    public void a(int i2) {
        if (this.f49275h <= 0) {
            this.f49275h = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds156);
        }
        NestedScrollView nestedScrollView = this.f49268a;
        if (nestedScrollView == null) {
            return;
        }
        if (i2 == 0) {
            nestedScrollView.post(new a());
        }
        if (this.f49268a.getLocalVisibleRect(this.f49276i)) {
            int i3 = this.f49276i.bottom;
            int abs = Math.abs(this.f49269b.getTop());
            int abs2 = i3 - Math.abs(this.f49269b.getBottom());
            ViewGroup.LayoutParams layoutParams = this.f49269b.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                int i4 = this.f49275h;
                if (abs < i4) {
                    marginLayoutParams.topMargin = i4;
                    this.f49269b.setLayoutParams(marginLayoutParams);
                } else if (abs == i4) {
                    if (abs2 > i4) {
                        marginLayoutParams.topMargin = i4 + ((abs2 - i4) / 2);
                        this.f49269b.setLayoutParams(marginLayoutParams);
                    }
                } else if (abs > i4) {
                    if (abs2 < i4) {
                        marginLayoutParams.topMargin = i4;
                    } else if (abs2 == i4) {
                        marginLayoutParams.topMargin = i4;
                    } else if (abs2 > i4) {
                        marginLayoutParams.topMargin = (abs + abs2) / 2;
                    }
                    this.f49269b.setLayoutParams(marginLayoutParams);
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
        this.f49273f.setText(str);
    }

    public void d(String str) {
        if (str == null) {
            this.f49271d.setVisibility(8);
            return;
        }
        this.f49271d.setVisibility(0);
        this.f49271d.setText(str);
    }

    public void e(String str) {
        if (str == null) {
            return;
        }
        this.f49272e.setText(str);
    }

    public void f() {
        this.f49273f.setVisibility(0);
        this.f49272e.setVisibility(0);
        SkinManager.setViewTextColor(this.f49271d, R.color.CAM_X0109, 1);
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        SkinManager.setImageResource(this.f49270c, R.drawable.new_pic_emotion_08);
        SkinManager.setViewTextColor(this.f49271d, R.color.CAM_X0109, 1, skinType);
        SkinManager.setViewTextColor(this.f49272e, R.color.CAM_X0107, 1, skinType);
        SkinManager.setBackgroundColor(this.attachedView, R.color.CAM_X0201);
        TBSpecificationBtn tBSpecificationBtn = this.f49273f;
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
        this.f49270c.setImageResource(0);
    }
}

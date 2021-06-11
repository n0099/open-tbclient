package tv.athena.revenue.payui.view.banner;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.payapi.bean.BannerConfigItem;
import i.a.a.e.c;
import i.a.a.e.d;
import i.a.a.e.e;
import i.a.a.e.h;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import tv.athena.revenue.payui.model.ImageLoaderSupplier;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 G2\u00020\u0001:\u0001GB\u0011\b\u0016\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\bD\u0010EB\u001b\b\u0016\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\bD\u0010FB#\b\u0016\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\bD\u0010\u0017J\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0011\u0010\r\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b\r\u0010\fJ\u0013\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ)\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u0014H\u0014¢\u0006\u0004\b\u001a\u0010\u001bJ\u001d\u0010\u001c\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002¢\u0006\u0004\b\u001c\u0010\u0007J\u0015\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u0014¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010\"\u001a\u00020\u00052\b\u0010!\u001a\u0004\u0018\u00010 ¢\u0006\u0004\b\"\u0010#J\u0017\u0010&\u001a\u00020\u00052\b\u0010%\u001a\u0004\u0018\u00010$¢\u0006\u0004\b&\u0010'J\u0015\u0010)\u001a\u00020\u00052\u0006\u0010%\u001a\u00020(¢\u0006\u0004\b)\u0010*J\u0015\u0010-\u001a\u00020\u00052\u0006\u0010,\u001a\u00020+¢\u0006\u0004\b-\u0010.J\u000f\u0010/\u001a\u00020\u0005H\u0002¢\u0006\u0004\b/\u0010\tR\u0013\u00100\u001a\u00020+8F@\u0006¢\u0006\u0006\u001a\u0004\b0\u00101R\u001c\u00103\u001a\b\u0012\u0004\u0012\u00020\u0003028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00106\u001a\u0002058\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u00109\u001a\u0002088\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010<\u001a\u00020;8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b<\u0010=R\u0018\u0010?\u001a\u0004\u0018\u00010>8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010@R\u0018\u0010B\u001a\u0004\u0018\u00010A8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010C¨\u0006H"}, d2 = {"Ltv/athena/revenue/payui/view/banner/PluginCenterTopBanner;", "Landroid/widget/RelativeLayout;", "", "Lcom/yy/mobile/framework/revenuesdk/payapi/bean/BannerConfigItem$BannerInfo;", "data", "", "addRadios", "(Ljava/util/List;)V", "endAutoScroll", "()V", "Landroid/widget/RadioGroup$LayoutParams;", "generateCheckedParam", "()Landroid/widget/RadioGroup$LayoutParams;", "generateDefaultParam", "getData", "()Ljava/util/List;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyle", "init", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "setData", "time", "setFlipInterval", "(I)V", "Ltv/athena/revenue/payui/model/ImageLoaderSupplier;", "supplier", "setImageLoaderSupplier", "(Ltv/athena/revenue/payui/model/ImageLoaderSupplier;)V", "Landroid/widget/AdapterView$OnItemClickListener;", "listener", "setOnItemClickListener", "(Landroid/widget/AdapterView$OnItemClickListener;)V", "Landroid/view/View$OnClickListener;", "setOnPlaceHolderClickListener", "(Landroid/view/View$OnClickListener;)V", "", "isVisible", "setPlaceHolderVisible", "(Z)V", "startAutoScroll", "isFlipping", "()Z", "", "mData", "Ljava/util/List;", "Ltv/athena/revenue/payui/view/banner/PluginCenterBannerGallery;", "mGallery", "Ltv/athena/revenue/payui/view/banner/PluginCenterBannerGallery;", "", "mLayoutAspectRatio", "F", "Landroid/widget/AdapterView$OnItemSelectedListener;", "mListener", "Landroid/widget/AdapterView$OnItemSelectedListener;", "Landroid/view/View;", "mPlaceholderView", "Landroid/view/View;", "Landroid/widget/RadioGroup;", "mRadios", "Landroid/widget/RadioGroup;", "<init>", "(Landroid/content/Context;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Companion", "payui_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes8.dex */
public final class PluginCenterTopBanner extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public PluginCenterBannerGallery f72971e;

    /* renamed from: f  reason: collision with root package name */
    public RadioGroup f72972f;

    /* renamed from: g  reason: collision with root package name */
    public final List<BannerConfigItem.BannerInfo> f72973g;

    /* renamed from: h  reason: collision with root package name */
    public View f72974h;

    /* renamed from: i  reason: collision with root package name */
    public float f72975i;
    public final AdapterView.OnItemSelectedListener j;

    /* loaded from: classes8.dex */
    public static final class a implements RadioGroup.OnCheckedChangeListener {
        public a() {
        }

        @Override // android.widget.RadioGroup.OnCheckedChangeListener
        public final void onCheckedChanged(RadioGroup radioGroup, int i2) {
            int size = PluginCenterTopBanner.this.f72973g.size();
            for (int i3 = 0; i3 < size; i3++) {
                View childAt = radioGroup.getChildAt(i3);
                if (childAt == null) {
                    throw new TypeCastException("null cannot be cast to non-null type android.widget.RadioButton");
                }
                RadioButton radioButton = (RadioButton) childAt;
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class b implements AdapterView.OnItemSelectedListener {
        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public b() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i2, long j) {
            if (i2 < i.a.a.e.o.c.b.f72190a.a(PluginCenterTopBanner.b(PluginCenterTopBanner.this).getData())) {
                RLog.debug("PluginCenterTopBanner", "banner display position = " + i2 + " id = " + PluginCenterTopBanner.b(PluginCenterTopBanner.this).getData().get(i2).id);
                RadioGroup radioGroup = PluginCenterTopBanner.this.f72972f;
                if (radioGroup == null) {
                    Intrinsics.throwNpe();
                }
                List<BannerConfigItem.BannerInfo> data = PluginCenterTopBanner.b(PluginCenterTopBanner.this).getData();
                if (data == null) {
                    Intrinsics.throwNpe();
                }
                View childAt = radioGroup.getChildAt(i2 % data.size());
                if (childAt != null) {
                    RadioGroup radioGroup2 = PluginCenterTopBanner.this.f72972f;
                    if (radioGroup2 == null) {
                        Intrinsics.throwNpe();
                    }
                    radioGroup2.check(childAt.getId());
                }
            }
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    public PluginCenterTopBanner(Context context) {
        this(context, null);
    }

    public static final /* synthetic */ PluginCenterBannerGallery b(PluginCenterTopBanner pluginCenterTopBanner) {
        PluginCenterBannerGallery pluginCenterBannerGallery = pluginCenterTopBanner.f72971e;
        if (pluginCenterBannerGallery == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGallery");
        }
        return pluginCenterBannerGallery;
    }

    public final void d(List<? extends BannerConfigItem.BannerInfo> list) {
        RadioGroup radioGroup = this.f72972f;
        if (radioGroup == null) {
            Intrinsics.throwNpe();
        }
        radioGroup.removeAllViews();
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            RadioButton radioButton = new RadioButton(getContext());
            radioButton.setId(i2 + 4660);
            Context context = getContext();
            Intrinsics.checkExpressionValueIsNotNull(context, "context");
            radioButton.setButtonDrawable(context.getResources().getDrawable(c.pay_ui_hp_top_banner_selector_newstyle));
            RadioGroup radioGroup2 = this.f72972f;
            if (radioGroup2 == null) {
                Intrinsics.throwNpe();
            }
            radioGroup2.addView(radioButton, e());
        }
        RadioGroup radioGroup3 = this.f72972f;
        if (radioGroup3 == null) {
            Intrinsics.throwNpe();
        }
        radioGroup3.setOnCheckedChangeListener(new a());
    }

    public final RadioGroup.LayoutParams e() {
        int dimension = (int) getResources().getDimension(i.a.a.e.b.pay_ui_home_top_banner_dot_homepage);
        return new RadioGroup.LayoutParams(dimension + 12, dimension);
    }

    public final void f(Context context, AttributeSet attributeSet, int i2) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, h.Pay_Ui_Banner, i2, 0);
        this.f72975i = obtainStyledAttributes.getFloat(h.Pay_Ui_Banner_playUiAspectRatio, 0.0f);
        obtainStyledAttributes.recycle();
        LayoutInflater.from(context).inflate(e.pay_ui_layout_plugincenter_top_banner, (ViewGroup) this, true);
        View findViewById = findViewById(d.lbb_top_banner_gallery);
        if (findViewById != null) {
            this.f72971e = (PluginCenterBannerGallery) findViewById;
            View findViewById2 = findViewById(d.lbb_radio_top_banner);
            if (findViewById2 != null) {
                this.f72972f = (RadioGroup) findViewById2;
                this.f72974h = findViewById(d.banner_placeholder);
                PluginCenterBannerGallery pluginCenterBannerGallery = this.f72971e;
                if (pluginCenterBannerGallery == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mGallery");
                }
                pluginCenterBannerGallery.setOnItemSelectedListener(this.j);
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type android.widget.RadioGroup");
        }
        throw new TypeCastException("null cannot be cast to non-null type tv.athena.revenue.payui.view.banner.PluginCenterBannerGallery");
    }

    public final List<BannerConfigItem.BannerInfo> getData() {
        return this.f72973g;
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        if (this.f72975i > 0) {
            i3 = View.MeasureSpec.makeMeasureSpec((int) (View.MeasureSpec.getSize(i2) / this.f72975i), 1073741824);
        }
        super.onMeasure(i2, i3);
    }

    public final void setData(List<? extends BannerConfigItem.BannerInfo> list) {
        if (Intrinsics.areEqual(this.f72973g, list) || list == null) {
            return;
        }
        this.f72973g.clear();
        this.f72973g.addAll(list);
        if (this.f72972f != null) {
            if (this.f72973g.size() <= 1) {
                RadioGroup radioGroup = this.f72972f;
                if (radioGroup == null) {
                    Intrinsics.throwNpe();
                }
                radioGroup.setVisibility(8);
            } else {
                RadioGroup radioGroup2 = this.f72972f;
                if (radioGroup2 == null) {
                    Intrinsics.throwNpe();
                }
                radioGroup2.setVisibility(0);
            }
        }
        PluginCenterBannerGallery pluginCenterBannerGallery = this.f72971e;
        if (pluginCenterBannerGallery == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGallery");
        }
        pluginCenterBannerGallery.setData(list);
        d(list);
        RadioGroup radioGroup3 = this.f72972f;
        if (radioGroup3 == null) {
            Intrinsics.throwNpe();
        }
        RadioGroup radioGroup4 = this.f72972f;
        if (radioGroup4 == null) {
            Intrinsics.throwNpe();
        }
        View childAt = radioGroup4.getChildAt(0);
        Intrinsics.checkExpressionValueIsNotNull(childAt, "mRadios!!.getChildAt(0)");
        radioGroup3.check(childAt.getId());
    }

    public final void setFlipInterval(int i2) {
        PluginCenterBannerGallery pluginCenterBannerGallery = this.f72971e;
        if (pluginCenterBannerGallery == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGallery");
        }
        pluginCenterBannerGallery.setFlipInterval(i2);
    }

    public final void setImageLoaderSupplier(ImageLoaderSupplier imageLoaderSupplier) {
        PluginCenterBannerGallery pluginCenterBannerGallery = this.f72971e;
        if (pluginCenterBannerGallery == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGallery");
        }
        pluginCenterBannerGallery.setImageLoaderSupplier(imageLoaderSupplier);
    }

    public final void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        PluginCenterBannerGallery pluginCenterBannerGallery = this.f72971e;
        if (pluginCenterBannerGallery == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGallery");
        }
        pluginCenterBannerGallery.setOnItemClickListener(onItemClickListener);
    }

    public final void setOnPlaceHolderClickListener(View.OnClickListener onClickListener) {
        View view = this.f72974h;
        if (view != null) {
            view.setOnClickListener(onClickListener);
        }
    }

    public final void setPlaceHolderVisible(boolean z) {
        if (z) {
            View view = this.f72974h;
            if (view != null) {
                view.setVisibility(0);
                return;
            }
            return;
        }
        View view2 = this.f72974h;
        if (view2 != null) {
            view2.setVisibility(8);
        }
    }

    public PluginCenterTopBanner(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PluginCenterTopBanner(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f72973g = new ArrayList();
        this.j = new b();
        f(context, attributeSet, i2);
    }
}

package com.dxmpay.wallet.base.widget;

import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.apollon.base.widget.NetImageView;
import com.dxmpay.apollon.statusbar.ImmersiveStatusBarManager;
import com.dxmpay.apollon.statusbar.StatusBarUtils;
import com.dxmpay.apollon.utils.DisplayUtils;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.apollon.utils.support.ViewHelper;
import com.dxmpay.wallet.utils.AccessibilityUtils;
/* loaded from: classes2.dex */
public class BdActionBar extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int TEXT_ALIGN_CENTER = 1;
    public static final int TEXT_ALIGN_LEFT = 0;
    public static final int TEXT_ALIGN_RIGHT = 2;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public String f55853e;

    /* renamed from: f  reason: collision with root package name */
    public View f55854f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f55855g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f55856h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f55857i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f55858j;

    /* renamed from: k  reason: collision with root package name */
    public View f55859k;
    public View l;
    public View m;
    public View mLeftImgZone2;
    public TextView mTitleCenterText;
    public NetImageView n;
    public View o;
    public NetImageView p;
    public TextView q;
    public View r;
    public TextView s;
    public ImageView t;
    public ImageView u;
    public ImageView v;
    public View w;
    public TextView x;
    public ImageView y;

    /* loaded from: classes2.dex */
    public class a implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BdActionBar f55860e;

        public a(BdActionBar bdActionBar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdActionBar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55860e = bdActionBar;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                if (motionEvent.getAction() == 0 || motionEvent.getAction() == 2) {
                    ViewHelper.setAlpha(this.f55860e.mLeftImgZone2, 0.5f);
                    return false;
                }
                ViewHelper.setAlpha(this.f55860e.mLeftImgZone2, 1.0f);
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes2.dex */
    public class b implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BdActionBar f55861e;

        public b(BdActionBar bdActionBar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdActionBar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55861e = bdActionBar;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                if (motionEvent.getAction() == 0 || motionEvent.getAction() == 2) {
                    ViewHelper.setAlpha(this.f55861e.l, 0.5f);
                    return false;
                }
                ViewHelper.setAlpha(this.f55861e.l, 1.0f);
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BdActionBar(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f55853e = "";
        c();
    }

    public final BdActionBar b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            if (i2 == 0 || 8 == i2) {
                this.f55856h.setVisibility(8);
            }
            return this;
        }
        return (BdActionBar) invokeI.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), getLayoutId()), this);
            this.f55859k = findViewById(ResUtils.id(getContext(), "actionbar_statusbar_top"));
            setTop((Activity) null);
            this.f55854f = findViewById(ResUtils.id(getContext(), "title"));
            this.mLeftImgZone2 = findViewById(ResUtils.id(getContext(), "title_left_imgzone2"));
            this.f55855g = (ImageView) findViewById(ResUtils.id(getContext(), "title_left_imgzone2_img"));
            this.f55857i = (TextView) findViewById(ResUtils.id(getContext(), "wallet_titlebar_left_imgzone2_close"));
            this.v = (ImageView) findViewById(ResUtils.id(getContext(), "bd_ab_ic_close"));
            this.f55858j = (TextView) findViewById(ResUtils.id(getContext(), "title_left_imgzone2_notify"));
            this.f55856h = (TextView) findViewById(ResUtils.id(getContext(), "title_left_imgzone2_notify"));
            this.mLeftImgZone2.setOnTouchListener(new a(this));
            View findViewById = findViewById(ResUtils.id(getContext(), "title_close"));
            this.l = findViewById;
            findViewById.setOnTouchListener(new b(this));
            this.mTitleCenterText = (TextView) findViewById(ResUtils.id(getContext(), "title_center_text"));
            this.r = findViewById(ResUtils.id(getContext(), "title_center_safe_layout"));
            this.s = (TextView) findViewById(ResUtils.id(getContext(), "title_center_safe_tip"));
            this.t = (ImageView) findViewById(ResUtils.id(getContext(), "safe_icon"));
            this.m = findViewById(ResUtils.id(getContext(), "title_right_imgzone1"));
            this.n = (NetImageView) findViewById(ResUtils.id(getContext(), "title_right_imgzone2_img1"));
            this.o = findViewById(ResUtils.id(getContext(), "title_right_imgzone2"));
            this.p = (NetImageView) findViewById(ResUtils.id(getContext(), "title_right_imgzone2_img"));
            this.q = (TextView) findViewById(ResUtils.id(getContext(), "title_right_imgzone2_notify"));
            this.w = findViewById(ResUtils.id(getContext(), "title_right_imgzone2_notify_zone"));
            this.x = (TextView) findViewById(ResUtils.id(getContext(), "title_right_imgzone2_notify1"));
            this.y = (ImageView) findViewById(ResUtils.id(getContext(), "title_right_imgzone2_notify_triangle"));
            if (!TextUtils.isEmpty(this.f55853e)) {
                setTitle(this.f55853e);
            }
            this.u = (ImageView) findViewById(ResUtils.id(getContext(), "title_bottom_seperator"));
        }
    }

    public final void d(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) {
            view.setVisibility(view.getVisibility() == 0 ? 8 : 0);
        }
    }

    public final BdActionBar f(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            if (i2 == 0 || 8 == i2) {
                if (this.f55857i.getVisibility() != i2) {
                    d(this.v);
                }
                this.f55857i.setVisibility(i2);
            }
            return this;
        }
        return (BdActionBar) invokeI.objValue;
    }

    public int getActionBarHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f55854f.getHeight() - this.f55859k.getHeight() : invokeV.intValue;
    }

    public String getLayoutId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? "dxm_wallet_base_action_bar" : (String) invokeV.objValue;
    }

    public int getMainTitleViewWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            this.mTitleCenterText.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            return this.mTitleCenterText.getMeasuredWidth();
        }
        return invokeV.intValue;
    }

    public View getRightImgZone1ImgView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.n : (View) invokeV.objValue;
    }

    public View getRightImgZone2ImgView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.p : (View) invokeV.objValue;
    }

    public View getRightImgZone2NotifyView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.q : (View) invokeV.objValue;
    }

    public int getRightImgZone2NotifyVisibility() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.q.getVisibility() : invokeV.intValue;
    }

    public View getRightNotifyZone1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.w : (View) invokeV.objValue;
    }

    public View getRightZone1View() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.m : (View) invokeV.objValue;
    }

    public View getRightZoneView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.o : (View) invokeV.objValue;
    }

    public int getStatusBarHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f55859k.getHeight() : invokeV.intValue;
    }

    public String getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f55853e : (String) invokeV.objValue;
    }

    public int[] getTitleSizeRange() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? new int[]{DisplayUtils.dip2px(getContext(), 18.0f), Math.round(this.f55858j.getTextSize())} : (int[]) invokeV.objValue;
    }

    public void hideLeftZone() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.mLeftImgZone2.setVisibility(8);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.l.getLayoutParams();
            layoutParams.width = DisplayUtils.dip2px(getContext(), 50.0f);
            this.l.setLayoutParams(layoutParams);
            this.l.setPadding(DisplayUtils.dip2px(getContext(), 12.0f), 0, 0, 0);
        }
    }

    public boolean isLeftZoneImageSelected() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.mLeftImgZone2.isSelected() : invokeV.booleanValue;
    }

    public void resetFullScreenTextColor() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            TextView textView = this.f55856h;
            if (textView != null) {
                textView.setTextColor(ResUtils.getColor(getContext(), "dxm_wallet_base_click_text1_color_selector"));
            }
            TextView textView2 = this.f55857i;
            if (textView2 != null) {
                textView2.setTextColor(ResUtils.getColor(getContext(), "dxm_wallet_base_click_text1_color_selector"));
            }
            TextView textView3 = this.f55858j;
            if (textView3 != null) {
                textView3.setTextColor(ResUtils.getColor(getContext(), "dxm_wallet_base_click_text1_color_selector"));
            }
            TextView textView4 = this.mTitleCenterText;
            if (textView4 != null) {
                textView4.setTextColor(ResUtils.getColor(getContext(), "dxm_wallet_black3"));
            }
            TextView textView5 = this.q;
            if (textView5 != null) {
                textView5.setTextColor(ResUtils.getColor(getContext(), "dxm_wallet_base_click_text2color_selector"));
            }
            TextView textView6 = this.s;
            if (textView6 != null) {
                textView6.setTextColor(ResUtils.getColor(getContext(), "dxm_wallet_text_999999"));
            }
        }
    }

    public void setBottomSeperatorvisible(boolean z) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048596, this, z) == null) || (imageView = this.u) == null) {
            return;
        }
        imageView.setVisibility(z ? 0 : 8);
    }

    public int setCloseButtonVisibility(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048597, this, i2)) == null) {
            int visibility = this.l.getVisibility();
            if (i2 == 0 || 8 == i2 || 4 == i2) {
                this.l.setVisibility(i2);
                if (i2 == 0) {
                    this.mTitleCenterText.setMaxEms(ResUtils.getInteger(getContext(), "dxm_wallet_base_titlebar_centertext_maxems_1"));
                }
            }
            return visibility;
        }
        return invokeI.intValue;
    }

    public void setCloseOnClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, onClickListener) == null) {
            this.l.setOnClickListener(onClickListener);
        }
    }

    public void setFullScreenTextColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i2) == null) {
            TextView textView = this.f55856h;
            if (textView != null) {
                textView.setTextColor(i2);
            }
            TextView textView2 = this.f55857i;
            if (textView2 != null) {
                textView2.setTextColor(i2);
            }
            TextView textView3 = this.f55858j;
            if (textView3 != null) {
                textView3.setTextColor(i2);
            }
            TextView textView4 = this.mTitleCenterText;
            if (textView4 != null) {
                textView4.setTextColor(i2);
            }
            TextView textView5 = this.q;
            if (textView5 != null) {
                textView5.setTextColor(i2);
            }
            TextView textView6 = this.s;
            if (textView6 != null) {
                textView6.setTextColor(i2);
            }
        }
    }

    public void setIconFlag(boolean z) {
        View view;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            if (z) {
                setLeftZoneImageSrc(ResUtils.drawable(getContext(), "dxm_wallet_base_actionbar_back_selector_white"));
                if (this.p.getVisibility() == 0) {
                    setRightImgZone2Src(ResUtils.drawable(getContext(), "dxm_wallet_base_actionbar_more_selector_white"));
                }
                this.v.setImageDrawable(ResUtils.getDrawable(getContext(), "dxm_wallet_base_actionbar_close_selector_white"));
            } else {
                setLeftZoneImageSrc(ResUtils.drawable(getContext(), "dxm_wallet_base_actionbar_back_selector"));
                if (this.p.getVisibility() == 0) {
                    setRightImgZone2Src(ResUtils.drawable(getContext(), "dxm_wallet_base_actionbar_more_selector"));
                }
                this.v.setImageDrawable(ResUtils.getDrawable(getContext(), "dxm_wallet_base_actionbar_close_selector"));
            }
            if (Build.VERSION.SDK_INT >= 19) {
                Activity activity = getContext() instanceof Activity ? (Activity) getContext() : null;
                if (activity == null || (view = this.f55859k) == null) {
                    return;
                }
                ImmersiveStatusBarManager.setTopBar(activity, view, !z);
            }
        }
    }

    public void setImgZoneBackgroundResource(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i2) == null) {
            this.m.setBackgroundResource(i2);
            this.o.setBackgroundResource(i2);
        }
    }

    public void setLeftImgZone2NotifyText(String str, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(1048602, this, str, f2) == null) {
            this.f55856h.setVisibility(8);
            if (f2 < 0.0f) {
                return;
            }
            this.f55856h.setText(str);
            this.f55856h.setTextSize(1, f2);
        }
    }

    public void setLeftImgZone2NotifyTextColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i2) == null) {
            this.f55856h.setTextColor(i2);
        }
    }

    public void setLeftImgZone2NotifyTextColorStateList(ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, colorStateList) == null) {
            this.f55856h.setTextColor(colorStateList);
        }
    }

    public void setLeftZoneImageSelected(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048605, this, z) == null) {
        }
    }

    public void setLeftZoneImageSrc(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048606, this, i2) == null) {
            Drawable drawable = i2 != 0 ? getResources().getDrawable(i2) : null;
            if (drawable != null) {
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            }
            this.f55855g.setImageDrawable(drawable);
        }
    }

    public void setLeftZoneOnClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, onClickListener) == null) {
            this.mLeftImgZone2.setOnClickListener(onClickListener);
        }
    }

    public BdActionBar setOnlyIcons(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048609, this, z)) == null) {
            int i2 = z ? 8 : 0;
            b(i2);
            f(i2);
            return this;
        }
        return (BdActionBar) invokeZ.objValue;
    }

    public void setRightImgZone1Enable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048610, this, z) == null) {
            this.n.setEnabled(z);
            this.m.setEnabled(z);
        }
    }

    public void setRightImgZone1OnClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, onClickListener) == null) {
            this.m.setOnClickListener(onClickListener);
        }
    }

    public void setRightImgZone1Src(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048612, this, i2) == null) {
            this.m.setVisibility(0);
            this.n.setVisibility(0);
            this.n.setImageResource(i2);
        }
    }

    public void setRightImgZone1Visibility(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048614, this, i2) == null) {
            this.m.setVisibility(i2);
        }
    }

    public void setRightImgZone2Enable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048615, this, z) == null) {
            this.p.setEnabled(z);
            this.o.setEnabled(z);
        }
    }

    public void setRightImgZone2NotifyClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, onClickListener) == null) {
            if (onClickListener != null) {
                this.q.setVisibility(0);
            }
            this.q.setOnClickListener(onClickListener);
        }
    }

    public void setRightImgZone2NotifyText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, str) == null) {
            if (!TextUtils.isEmpty(str)) {
                setRightImgZone2NotifyVisibility(0);
            }
            this.q.setText(str);
        }
    }

    public void setRightImgZone2NotifyTextBg(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048618, this, i2) == null) {
            this.q.setBackgroundResource(i2);
            this.q.setPadding(12, 6, 12, 6);
        }
    }

    public void setRightImgZone2NotifyTextColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048619, this, i2) == null) {
            this.q.setTextColor(i2);
        }
    }

    public void setRightImgZone2NotifyTextSize(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048620, this, f2) == null) {
            this.q.setTextSize(1, f2);
        }
    }

    public void setRightImgZone2NotifyTextViewPadding(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048621, this, i2, i3, i4, i5) == null) {
            this.q.setPadding(i2, i3, i4, i5);
        }
    }

    public void setRightImgZone2NotifyVisibility(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048622, this, i2) == null) {
            this.q.setVisibility(i2);
        }
    }

    public void setRightImgZone2OnClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, onClickListener) == null) {
            if (onClickListener != null) {
                this.o.setVisibility(0);
            }
            this.o.setOnClickListener(onClickListener);
        }
    }

    public void setRightImgZone2Src(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048624, this, i2) == null) {
            this.p.setVisibility(0);
            this.p.setImageResource(i2);
        }
    }

    public void setRightImgZone2Visibility(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048627, this, i2) == null) {
            this.o.setVisibility(i2);
        }
    }

    public void setRightNotifyImg(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, drawable) == null) {
            this.y.setImageDrawable(drawable);
        }
    }

    public void setRightNotifyText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, str) == null) {
            this.x.setText(str);
        }
    }

    public void setRightNotifyTextColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048630, this, i2) == null) {
            this.x.setTextColor(i2);
        }
    }

    public void setRightNotifyTextSize(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048631, this, i2) == null) {
            this.x.setTextSize(1, i2);
        }
    }

    public void setRightNotifyZone1Bg(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048632, this, drawable) == null) {
            this.w.setBackgroundDrawable(drawable);
        }
    }

    public void setRightNotifyZone1ClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048633, this, onClickListener) == null) {
            this.w.setOnClickListener(onClickListener);
        }
    }

    public void setRightNotifyZone1Visibility(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048634, this, i2) == null) {
            this.w.setVisibility(i2);
        }
    }

    public void setSafeIconVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048635, this, z) == null) {
            if (z) {
                this.t.setVisibility(0);
            } else {
                this.t.setVisibility(8);
            }
        }
    }

    public void setTitle(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048637, this, str) == null) {
            this.f55853e = str;
            this.mTitleCenterText.setText(str);
        }
    }

    public void setTitleCenterSafeTipColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048638, this, i2) == null) {
            this.s.setTextColor(i2);
        }
    }

    public void setTitleCenterSafeTipText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048639, this, str) == null) {
            if (TextUtils.isEmpty(str)) {
                this.r.setVisibility(8);
                return;
            }
            this.r.setVisibility(0);
            this.s.setText(str);
        }
    }

    public void setTitleColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048640, this, i2) == null) {
            this.mTitleCenterText.setTextColor(i2);
        }
    }

    public void setTitleEllipsize(TextUtils.TruncateAt truncateAt) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048641, this, truncateAt) == null) || truncateAt == null) {
            return;
        }
        this.mTitleCenterText.setSingleLine();
        this.mTitleCenterText.setEllipsize(truncateAt);
    }

    public void setTitleShadowLayer(float f2, float f3, float f4, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048642, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Integer.valueOf(i2)}) == null) {
            this.mTitleCenterText.setShadowLayer(f2, f3, f4, i2);
        }
    }

    public void setTitleSize(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048643, this, i2) == null) {
            this.mTitleCenterText.setTextSize(0, i2);
        }
    }

    public void setTitleTextColorAlpha(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048644, this, i2) == null) {
            try {
                int currentTextColor = this.mTitleCenterText.getCurrentTextColor();
                this.mTitleCenterText.setTextColor(Color.argb(i2, Color.red(currentTextColor), Color.green(currentTextColor), Color.blue(currentTextColor)));
                int currentTextColor2 = this.s.getCurrentTextColor();
                this.s.setTextColor(Color.argb(i2, Color.red(currentTextColor2), Color.green(currentTextColor2), Color.blue(currentTextColor2)));
            } catch (Throwable unused) {
            }
        }
    }

    public void setTitlebgColor(int i2) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048645, this, i2) == null) || (view = this.f55854f) == null) {
            return;
        }
        view.setBackgroundColor(i2);
    }

    public void setTop(Activity activity) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048646, this, activity) == null) || Build.VERSION.SDK_INT < 19) {
            return;
        }
        if (activity == null) {
            activity = getContext() instanceof Activity ? (Activity) getContext() : null;
        }
        if (activity == null) {
            return;
        }
        this.f55859k.setLayoutParams(new RelativeLayout.LayoutParams(-1, StatusBarUtils.getStatusBarHeight(activity)));
        ImmersiveStatusBarManager.setTopBar(activity, this.f55859k, true);
    }

    public void setbackBg(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048647, this, drawable) == null) {
            this.mLeftImgZone2.setBackgroundDrawable(drawable);
        }
    }

    public void setRightImgZone2Src(int i2, CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048625, this, i2, charSequence) == null) {
            setRightImgZone2Src(i2);
            AccessibilityUtils.setContentDescription(this.p, charSequence);
        }
    }

    public void setTitle(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048636, this, i2) == null) {
            setTitle(getResources().getString(i2));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BdActionBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f55853e = "";
        c();
    }

    public void setLeftZoneImageSrc(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, drawable) == null) {
            if (drawable != null) {
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            }
            this.f55855g.setImageDrawable(drawable);
        }
    }

    public void setRightImgZone1Src(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, str) == null) {
            this.m.setVisibility(0);
            this.n.setVisibility(0);
            this.n.setImageUrl(str);
        }
    }

    public void setRightImgZone2Src(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, str) == null) {
            this.p.setVisibility(0);
            this.p.setImageUrl(str);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BdActionBar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f55853e = "";
        c();
    }
}

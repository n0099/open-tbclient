package com.dxmpay.wallet.base.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.TextView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.apollon.utils.ResUtils;
/* loaded from: classes11.dex */
public class BorderTipTextView extends TextView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f62358e;

    /* renamed from: f  reason: collision with root package name */
    public int f62359f;

    /* renamed from: g  reason: collision with root package name */
    public int f62360g;

    /* renamed from: h  reason: collision with root package name */
    public int f62361h;

    /* renamed from: i  reason: collision with root package name */
    public ColorStateList f62362i;
    public Drawable j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BorderTipTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f62358e = getPaddingLeft();
        this.f62359f = getPaddingRight();
        this.f62360g = getPaddingTop();
        this.f62361h = getPaddingBottom();
        this.f62362i = getTextColors();
        this.j = getBackground();
    }

    public void setText(CharSequence charSequence, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048576, this, charSequence, z) == null) {
            if (z) {
                setBackgroundDrawable(ResUtils.getDrawable(getContext(), "dxm_wallet_base_tip_bg"));
                setTextColor(ResUtils.getColor(getContext(), "dxm_wallet_base_font_text6Color"));
                setText(charSequence);
                setPadding(6, 0, 6, 2);
                return;
            }
            setBackgroundDrawable(this.j);
            setTextColor(this.f62362i);
            setText(charSequence);
            setPadding(this.f62358e, this.f62360g, this.f62359f, this.f62361h);
        }
    }
}

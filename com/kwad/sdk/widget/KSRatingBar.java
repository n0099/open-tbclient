package com.kwad.sdk.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import java.math.BigDecimal;
/* loaded from: classes3.dex */
public class KSRatingBar extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f60300b;

    /* renamed from: c  reason: collision with root package name */
    public int f60301c;

    /* renamed from: d  reason: collision with root package name */
    public int f60302d;

    /* renamed from: e  reason: collision with root package name */
    public a f60303e;

    /* renamed from: f  reason: collision with root package name */
    public float f60304f;

    /* renamed from: g  reason: collision with root package name */
    public float f60305g;

    /* renamed from: h  reason: collision with root package name */
    public float f60306h;

    /* renamed from: i  reason: collision with root package name */
    public Drawable f60307i;

    /* renamed from: j  reason: collision with root package name */
    public Drawable f60308j;

    /* renamed from: k  reason: collision with root package name */
    public Drawable f60309k;
    public int l;
    public boolean m;

    /* loaded from: classes3.dex */
    public interface a {
        void a(float f2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KSRatingBar(Context context, AttributeSet attributeSet) {
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
        this.l = 1;
        this.m = false;
        setOrientation(0);
        setDividerDrawable(getResources().getDrawable(R.drawable.ksad_reward_apk_stars_divider));
        setShowDividers(2);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ksad_KSRatingBar);
        this.f60309k = obtainStyledAttributes.getDrawable(R.styleable.ksad_KSRatingBar_ksad_starHalf);
        this.f60307i = obtainStyledAttributes.getDrawable(R.styleable.ksad_KSRatingBar_ksad_starEmpty);
        this.f60308j = obtainStyledAttributes.getDrawable(R.styleable.ksad_KSRatingBar_ksad_starFill);
        this.f60304f = obtainStyledAttributes.getDimension(R.styleable.ksad_KSRatingBar_ksad_starImageWidth, 60.0f);
        this.f60305g = obtainStyledAttributes.getDimension(R.styleable.ksad_KSRatingBar_ksad_starImageHeight, 120.0f);
        this.f60306h = obtainStyledAttributes.getDimension(R.styleable.ksad_KSRatingBar_ksad_starImagePadding, 15.0f);
        this.f60301c = obtainStyledAttributes.getInteger(R.styleable.ksad_KSRatingBar_ksad_totalStarCount, 5);
        this.f60302d = obtainStyledAttributes.getInteger(R.styleable.ksad_KSRatingBar_ksad_starCount, 5);
        this.a = obtainStyledAttributes.getBoolean(R.styleable.ksad_KSRatingBar_ksad_clickable, true);
        this.f60300b = obtainStyledAttributes.getBoolean(R.styleable.ksad_KSRatingBar_ksad_halfstart, false);
        for (int i4 = 0; i4 < this.f60301c; i4++) {
            ImageView a2 = a(context, this.m);
            a2.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.sdk.widget.KSRatingBar.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ KSRatingBar a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext2 = TitanRuntime.newInitContext();
                        newInitContext2.initArgs = r2;
                        Object[] objArr3 = {this};
                        interceptable2.invokeUnInit(65536, newInitContext2);
                        int i5 = newInitContext2.flag;
                        if ((i5 & 1) != 0) {
                            int i6 = i5 & 2;
                            newInitContext2.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext2);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    KSRatingBar kSRatingBar;
                    float indexOfChild;
                    a aVar;
                    float indexOfChild2;
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) && this.a.a) {
                        if (!this.a.f60300b) {
                            KSRatingBar kSRatingBar2 = this.a;
                            kSRatingBar2.setStar(kSRatingBar2.indexOfChild(view) + 1.0f);
                            if (this.a.f60303e != null) {
                                this.a.f60303e.a(this.a.indexOfChild(view) + 1.0f);
                                return;
                            }
                            return;
                        }
                        if (this.a.l % 2 == 0) {
                            kSRatingBar = this.a;
                            indexOfChild = kSRatingBar.indexOfChild(view) + 1.0f;
                        } else {
                            kSRatingBar = this.a;
                            indexOfChild = kSRatingBar.indexOfChild(view) + 0.5f;
                        }
                        kSRatingBar.setStar(indexOfChild);
                        if (this.a.f60303e != null) {
                            if (this.a.l % 2 == 0) {
                                aVar = this.a.f60303e;
                                indexOfChild2 = this.a.indexOfChild(view) + 1.0f;
                            } else {
                                aVar = this.a.f60303e;
                                indexOfChild2 = this.a.indexOfChild(view) + 0.5f;
                            }
                            aVar.a(indexOfChild2);
                            KSRatingBar.e(this.a);
                        }
                    }
                }
            });
            addView(a2);
        }
        setStar(this.f60302d);
    }

    private ImageView a(Context context, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65537, this, context, z)) == null) {
            ImageView imageView = new ImageView(context);
            imageView.setLayoutParams(new ViewGroup.LayoutParams(Math.round(this.f60304f), Math.round(this.f60305g)));
            imageView.setPadding(0, 0, Math.round(this.f60306h), 0);
            imageView.setImageDrawable(z ? this.f60307i : this.f60308j);
            return imageView;
        }
        return (ImageView) invokeLZ.objValue;
    }

    public static /* synthetic */ int e(KSRatingBar kSRatingBar) {
        int i2 = kSRatingBar.l;
        kSRatingBar.l = i2 + 1;
        return i2;
    }

    public void setImagePadding(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048576, this, f2) == null) {
            this.f60306h = f2;
        }
    }

    public void setOnRatingChangeListener(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            this.f60303e = aVar;
        }
    }

    public void setStar(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeF(Constants.METHOD_SEND_USER_MSG, this, f2) != null) {
            return;
        }
        int i2 = (int) f2;
        float floatValue = new BigDecimal(Float.toString(f2)).subtract(new BigDecimal(Integer.toString(i2))).floatValue();
        int i3 = this.f60301c;
        float f3 = i2 > i3 ? i3 : i2;
        if (f3 < 0.0f) {
            f3 = 0.0f;
        }
        for (int i4 = 0; i4 < f3; i4++) {
            ((ImageView) getChildAt(i4)).setImageDrawable(this.f60308j);
        }
        if (floatValue > 0.0f) {
            ((ImageView) getChildAt(i2)).setImageDrawable(this.f60309k);
            int i5 = this.f60301c;
            while (true) {
                i5--;
                if (i5 < 1.0f + f3) {
                    return;
                }
                ((ImageView) getChildAt(i5)).setImageDrawable(this.f60307i);
            }
        } else {
            int i6 = this.f60301c;
            while (true) {
                i6--;
                if (i6 < f3) {
                    return;
                }
                ((ImageView) getChildAt(i6)).setImageDrawable(this.f60307i);
            }
        }
    }

    public void setStarEmptyDrawable(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, drawable) == null) {
            this.f60307i = drawable;
        }
    }

    public void setStarFillDrawable(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, drawable) == null) {
            this.f60308j = drawable;
        }
    }

    public void setStarHalfDrawable(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, drawable) == null) {
            this.f60309k = drawable;
        }
    }

    public void setStarImageHeight(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048582, this, f2) == null) {
            this.f60305g = f2;
        }
    }

    public void setStarImageWidth(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048583, this, f2) == null) {
            this.f60304f = f2;
        }
    }

    public void setTotalStarCount(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.f60301c = i2;
        }
    }

    public void setmClickable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.a = z;
        }
    }
}

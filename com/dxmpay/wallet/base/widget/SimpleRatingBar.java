package com.dxmpay.wallet.base.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.apollon.utils.DisplayUtils;
import com.dxmpay.apollon.utils.ResUtils;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class SimpleRatingBar extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public OnSimpleRatingBarChangeListener mChangeListener;
    public String mImageBackground;
    public String mImageStar;
    public int mMaxRate;
    public int mRate;
    public float mSeparationDP;
    public ArrayList<ImageView> mStars;
    public float mVerticalPaddingDP;

    /* loaded from: classes2.dex */
    public interface OnSimpleRatingBarChangeListener {
        void onRatingChanged(SimpleRatingBar simpleRatingBar, int i2, boolean z);
    }

    /* loaded from: classes2.dex */
    public class OnStarClickListener implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SimpleRatingBar f56005e;

        public OnStarClickListener(SimpleRatingBar simpleRatingBar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {simpleRatingBar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56005e = simpleRatingBar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                int indexOf = this.f56005e.mStars.indexOf(view) + 1;
                SimpleRatingBar simpleRatingBar = this.f56005e;
                if (indexOf == simpleRatingBar.mRate || indexOf <= 0 || indexOf > simpleRatingBar.mMaxRate) {
                    return;
                }
                simpleRatingBar.setRate(indexOf, true);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SimpleRatingBar(Context context) {
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
        this.mMaxRate = 5;
        this.mSeparationDP = 0.0f;
        this.mVerticalPaddingDP = 4.0f;
        this.mRate = 0;
        this.mImageBackground = "dxm_wallet_cashdesk_rating_gray";
        this.mImageStar = "dxm_wallet_cashdesk_rating_gold";
        init();
    }

    public void addStar() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ImageView imageView = new ImageView(getContext());
            imageView.setPadding(DisplayUtils.dip2px(getContext(), this.mSeparationDP / 2.0f), DisplayUtils.dip2px(getContext(), this.mVerticalPaddingDP), DisplayUtils.dip2px(getContext(), this.mSeparationDP / 2.0f), DisplayUtils.dip2px(getContext(), this.mVerticalPaddingDP));
            imageView.setOnClickListener(new OnStarClickListener(this));
            imageView.setImageResource(ResUtils.drawable(getContext(), this.mImageBackground));
            this.mStars.add(imageView);
            addView(imageView, new LinearLayout.LayoutParams(-2, -2));
        }
    }

    public int getRating() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mRate : invokeV.intValue;
    }

    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            setOrientation(0);
            this.mStars = new ArrayList<>();
            initRatingBar();
        }
    }

    public void initRatingBar() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            removeAllViews();
            this.mStars.clear();
            this.mRate = 0;
            for (int i2 = 0; i2 < this.mMaxRate; i2++) {
                addStar();
            }
        }
    }

    public void setOnChangeListener(OnSimpleRatingBarChangeListener onSimpleRatingBarChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onSimpleRatingBarChangeListener) == null) {
            this.mChangeListener = onSimpleRatingBarChangeListener;
        }
    }

    public void setRate(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            this.mRate = i2;
            int i3 = 0;
            while (i3 < this.mStars.size()) {
                this.mStars.get(i3).setImageResource(ResUtils.drawable(getContext(), i3 < i2 ? this.mImageStar : this.mImageBackground));
                i3++;
            }
            OnSimpleRatingBarChangeListener onSimpleRatingBarChangeListener = this.mChangeListener;
            if (onSimpleRatingBarChangeListener != null) {
                onSimpleRatingBarChangeListener.onRatingChanged(this, this.mRate, z);
            }
        }
    }

    public void setRating(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            setRate(i2, false);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SimpleRatingBar(Context context, AttributeSet attributeSet) {
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
        this.mMaxRate = 5;
        this.mSeparationDP = 0.0f;
        this.mVerticalPaddingDP = 4.0f;
        this.mRate = 0;
        this.mImageBackground = "dxm_wallet_cashdesk_rating_gray";
        this.mImageStar = "dxm_wallet_cashdesk_rating_gold";
        init();
    }
}

package com.kwad.sdk.reward.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
/* loaded from: classes6.dex */
public class AppScoreView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ImageView f36413a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f36414b;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AppScoreView(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AppScoreView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppScoreView(Context context, @Nullable AttributeSet attributeSet, int i2) {
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
        a();
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            LinearLayout.inflate(getContext(), R.layout.ksad_app_score, this);
            this.f36413a = (ImageView) findViewById(R.id.ksad_score_fourth);
            this.f36414b = (ImageView) findViewById(R.id.ksad_score_fifth);
        }
    }

    public void setScore(float f2) {
        ImageView imageView;
        int i2;
        ImageView imageView2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048576, this, f2) == null) {
            double d2 = f2;
            if (d2 > 4.5d) {
                this.f36413a.setImageResource(R.drawable.ksad_app_score_yellow);
                imageView2 = this.f36414b;
                i3 = R.drawable.ksad_app_score_yellow;
            } else if (d2 > 4.0d) {
                this.f36413a.setImageResource(R.drawable.ksad_app_score_yellow);
                imageView2 = this.f36414b;
                i3 = R.drawable.ksad_app_score_half;
            } else {
                if (d2 > 3.5d) {
                    imageView = this.f36413a;
                    i2 = R.drawable.ksad_app_score_yellow;
                } else {
                    int i4 = (d2 > 3.0d ? 1 : (d2 == 3.0d ? 0 : -1));
                    if (i4 > 0) {
                        imageView = this.f36413a;
                        i2 = R.drawable.ksad_app_score_half;
                    } else if (i4 != 0) {
                        return;
                    } else {
                        imageView = this.f36413a;
                        i2 = R.drawable.ksad_app_score_gray;
                    }
                }
                imageView.setImageResource(i2);
                imageView2 = this.f36414b;
                i3 = R.drawable.ksad_app_score_gray;
            }
            imageView2.setImageResource(i3);
        }
    }
}

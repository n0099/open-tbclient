package com.repackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.widget.AdImageView;
import com.baidu.sdk.container.filedownloader.MaterialLoadErrorCode;
import com.baidu.sdk.container.filedownloader.MaterialLoader;
import com.baidu.sdk.container.widget.AdView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class yc1 extends wc1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView i0;
    public Bitmap j0;

    /* loaded from: classes7.dex */
    public class a implements ad1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yc1 a;

        public a(yc1 yc1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yc1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yc1Var;
        }

        @Override // com.repackage.ad1
        public void a(String str, View view2, MaterialLoadErrorCode materialLoadErrorCode) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, str, view2, materialLoadErrorCode) == null) {
                yc1 yc1Var = this.a;
                yc1Var.L("StaticImage Load Failed: " + materialLoadErrorCode.toString());
            }
        }

        @Override // com.repackage.ad1
        public void onLoadingComplete(String str, View view2, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, view2, bitmap) == null) {
                this.a.j0 = bitmap;
                this.a.V();
                this.a.M();
            }
        }

        @Override // com.repackage.ad1
        public void onLoadingStarted(String str, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, view2) == null) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yc1 a;

        public b(yc1 yc1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yc1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yc1Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.K();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements ad1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yc1 a;

        public c(yc1 yc1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yc1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yc1Var;
        }

        @Override // com.repackage.ad1
        public void a(String str, View view2, MaterialLoadErrorCode materialLoadErrorCode) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, str, view2, materialLoadErrorCode) == null) {
                yc1 yc1Var = this.a;
                yc1Var.L("Get Static Image error: " + materialLoadErrorCode.getMessage());
            }
        }

        @Override // com.repackage.ad1
        public void onLoadingComplete(String str, View view2, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, view2, bitmap) == null) {
                this.a.j0 = bitmap;
            }
        }

        @Override // com.repackage.ad1
        public void onLoadingStarted(String str, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, view2) == null) {
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public yc1(Context context, JSONObject jSONObject) {
        super(context, jSONObject);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, jSONObject};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (JSONObject) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.r = "image";
    }

    @Override // com.repackage.wc1
    public void C() {
        RelativeLayout.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.b == 2) {
            return;
        }
        try {
            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            AdImageView adImageView = new AdImageView(this.a);
            this.i0 = adImageView;
            adImageView.setVisibility(0);
            this.i0.setOnClickListener(new b(this));
            this.i0.setLayoutParams(layoutParams);
            Z();
        } catch (Exception e) {
            L(wc1.h0 + " exception=" + Log.getStackTraceString(e));
        }
        if (this.j0 == null) {
            L("bitmap is null!!!");
            return;
        }
        this.i0.setDrawingCacheEnabled(true);
        this.i0.setImageBitmap(this.j0);
        j(this.i0, layoutParams);
        this.i0.requestLayout();
        super.C();
        this.i0.requestFocus();
        O();
    }

    @Override // com.repackage.wc1
    public void D() {
        AdView adView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ImageView imageView = this.i0;
            if (imageView != null && (adView = this.k) != null && adView.indexOfChild(imageView) >= 0) {
                if (this.i0.getDrawingCache() != null) {
                    this.i0.getDrawingCache().recycle();
                }
                this.k.removeAllViews();
            }
            Bitmap bitmap = this.j0;
            if (bitmap == null || bitmap.isRecycled()) {
                return;
            }
            this.j0.recycle();
            this.j0 = null;
        }
    }

    public final void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            ImageView imageView = this.i0;
            if (imageView != null) {
                imageView.setScaleType(this.F == 17 ? ImageView.ScaleType.CENTER_CROP : ImageView.ScaleType.FIT_XY);
            }
            if (this.j0 != null) {
                return;
            }
            this.j0 = this.h.a(this.t, new c(this));
        }
    }

    @Override // com.repackage.wc1, com.repackage.hd1
    public void a(id1 id1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, id1Var) == null) {
            super.a(id1Var);
        }
    }

    @Override // com.baidu.sdk.container.widget.AdView.a
    public void b(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048580, this, i, i2) == null) {
        }
    }

    @Override // com.repackage.wc1, com.repackage.hd1
    public void c(gd1 gd1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, gd1Var) == null) {
            super.c(gd1Var);
        }
    }

    @Override // com.repackage.wc1, com.repackage.hd1
    public View getAdView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? super.getAdView() : (View) invokeV.objValue;
    }

    @Override // com.repackage.wc1, com.repackage.hd1
    public void load() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.load();
            if (this.h.c(this.t, MaterialLoader.MaterialCacheType.PICTURE)) {
                V();
                M();
                return;
            }
            try {
                MaterialLoader.k(this.a).f(this.t, new a(this));
            } catch (Exception e) {
                L("StaticImage,Exception: " + e.toString());
            }
        }
    }

    @Override // com.baidu.sdk.container.widget.AdView.a
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
        }
    }

    @Override // com.baidu.sdk.container.widget.AdView.a
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            W();
        }
    }

    @Override // com.baidu.sdk.container.widget.AdView.a
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048586, this, i, keyEvent)) == null) {
            return false;
        }
        return invokeIL.booleanValue;
    }

    @Override // com.baidu.sdk.container.widget.AdView.a
    public void onWindowFocusChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
        }
    }

    @Override // com.baidu.sdk.container.widget.AdView.a
    public void onWindowVisibilityChanged(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
        }
    }

    @Override // com.repackage.wc1
    public void z() {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (imageView = this.i0) == null) {
            return;
        }
        imageView.setOnClickListener(null);
    }
}

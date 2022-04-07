package com.repackage;

import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.clickinfo.NadTouchInfoModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.cache.disk.DefaultDiskStorage;
import com.repackage.c11;
import java.lang.ref.WeakReference;
/* loaded from: classes6.dex */
public final class nh0 implements kh0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final NadTouchInfoModel a;
    public WeakReference<mh0> b;
    public WeakReference<View> c;
    public final Context d;
    public final int e;
    public final int f;
    public final int g;

    public nh0(@NonNull lh0 lh0Var, @NonNull View view2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {lh0Var, view2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = hi0.b();
        this.c = new WeakReference<>(view2);
        this.b = new WeakReference<>(lh0Var.getTouchInfoCollector());
        DisplayMetrics displayMetrics = this.d.getResources().getDisplayMetrics();
        this.e = displayMetrics.widthPixels;
        this.f = displayMetrics.heightPixels;
        this.g = displayMetrics.densityDpi;
        this.a = new NadTouchInfoModel(-1);
        d();
    }

    @NonNull
    public static kh0 b(@Nullable kh0 kh0Var, @NonNull lh0 lh0Var, @NonNull View view2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, kh0Var, lh0Var, view2)) == null) {
            if (kh0Var == null) {
                return new nh0(lh0Var, view2);
            }
            nh0 nh0Var = (nh0) kh0Var;
            if (nh0Var.c.get() == null) {
                nh0Var.c = new WeakReference<>(view2);
            }
            if (nh0Var.b.get() == null) {
                nh0Var.b = new WeakReference<>(lh0Var.getTouchInfoCollector());
            }
            return nh0Var;
        }
        return (kh0) invokeLLL.objValue;
    }

    @Override // com.repackage.kh0
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            mh0 mh0Var = this.b.get();
            if (mh0Var == null) {
                return "";
            }
            int[] b = mh0Var.b();
            int[] iArr = new int[2];
            View view2 = this.c.get();
            if (view2 != null) {
                view2.getLocationOnScreen(iArr);
            }
            int i = iArr[1];
            int height = view2 != null ? view2.getHeight() + i : 0;
            Point c = c();
            int i2 = this.e;
            int i3 = this.f;
            if (c != null) {
                i2 = c.x;
                i3 = c.y;
            }
            String[] strArr = new String[9];
            strArr[0] = DefaultDiskStorage.DEFAULT_DISK_STORAGE_VERSION_PREFIX;
            strArr[1] = c11.c.j() ? "1" : "0";
            strArr[2] = String.valueOf(b[0]);
            strArr[3] = String.valueOf(b[1]);
            strArr[4] = String.valueOf(i);
            strArr[5] = String.valueOf(height);
            strArr[6] = String.valueOf(i2);
            strArr[7] = String.valueOf(i3);
            strArr[8] = String.valueOf(this.g);
            return TextUtils.join(",", strArr);
        }
        return (String) invokeV.objValue;
    }

    public final Point c() {
        InterceptResult invokeV;
        Display display;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            View view2 = this.c.get();
            if (view2 == null || Build.VERSION.SDK_INT < 17 || (display = view2.getDisplay()) == null) {
                return null;
            }
            Point point = new Point();
            display.getRealSize(point);
            return point;
        }
        return (Point) invokeV.objValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            NadTouchInfoModel nadTouchInfoModel = this.a;
            if (nadTouchInfoModel.b) {
                return;
            }
            nadTouchInfoModel.a = this.g;
            nadTouchInfoModel.b = true;
        }
    }
}

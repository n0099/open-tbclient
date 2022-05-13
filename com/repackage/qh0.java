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
import com.repackage.m11;
import java.lang.ref.WeakReference;
/* loaded from: classes6.dex */
public final class qh0 implements nh0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final NadTouchInfoModel a;
    public WeakReference<ph0> b;
    public WeakReference<View> c;
    public final Context d;
    public final int e;
    public final int f;
    public final int g;

    public qh0(@NonNull oh0 oh0Var, @NonNull View view2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {oh0Var, view2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = ki0.b();
        this.c = new WeakReference<>(view2);
        this.b = new WeakReference<>(oh0Var.getTouchInfoCollector());
        DisplayMetrics displayMetrics = this.d.getResources().getDisplayMetrics();
        this.e = displayMetrics.widthPixels;
        this.f = displayMetrics.heightPixels;
        this.g = displayMetrics.densityDpi;
        this.a = new NadTouchInfoModel(-1);
        e();
    }

    @NonNull
    public static nh0 b(@Nullable nh0 nh0Var, @NonNull oh0 oh0Var, @NonNull View view2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, nh0Var, oh0Var, view2)) == null) {
            if (nh0Var == null) {
                return new qh0(oh0Var, view2);
            }
            qh0 qh0Var = (qh0) nh0Var;
            if (qh0Var.c.get() == null) {
                qh0Var.c = new WeakReference<>(view2);
            }
            if (qh0Var.b.get() == null) {
                qh0Var.b = new WeakReference<>(oh0Var.getTouchInfoCollector());
            }
            return qh0Var;
        }
        return (nh0) invokeLLL.objValue;
    }

    @Override // com.repackage.nh0
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ph0 ph0Var = this.b.get();
            if (ph0Var == null) {
                return "";
            }
            int[] b = ph0Var.b();
            int[] iArr = new int[2];
            View view2 = this.c.get();
            if (view2 != null) {
                view2.getLocationOnScreen(iArr);
            }
            int i = iArr[1];
            int height = view2 != null ? view2.getHeight() + i : 0;
            Point d = d();
            int i2 = this.e;
            int i3 = this.f;
            if (d != null) {
                i2 = d.x;
                i3 = d.y;
            }
            String[] strArr = new String[9];
            strArr[0] = DefaultDiskStorage.DEFAULT_DISK_STORAGE_VERSION_PREFIX;
            strArr[1] = m11.c.j() ? "1" : "0";
            strArr[2] = String.valueOf(b[0]);
            strArr[3] = String.valueOf(b[1]);
            strArr[4] = String.valueOf(i);
            strArr[5] = String.valueOf(height);
            strArr[6] = String.valueOf(i2);
            strArr[7] = String.valueOf(i3);
            strArr[8] = String.valueOf(this.g);
            String join = TextUtils.join(",", strArr);
            c();
            return join;
        }
        return (String) invokeV.objValue;
    }

    public final void c() {
        View view2;
        ph0 ph0Var;
        b11 b11Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || !w01.a || (view2 = this.c.get()) == null || (ph0Var = this.b.get()) == null || (b11Var = (b11) v01.a().a(b11.class)) == null) {
            return;
        }
        int[] iArr = ph0Var.b;
        b11Var.a(view2, iArr[0], iArr[1]);
    }

    public final Point d() {
        InterceptResult invokeV;
        Display display;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
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

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            NadTouchInfoModel nadTouchInfoModel = this.a;
            if (nadTouchInfoModel.b) {
                return;
            }
            nadTouchInfoModel.a = this.g;
            nadTouchInfoModel.b = true;
        }
    }
}

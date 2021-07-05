package com.ksad.lottie;

import android.graphics.Rect;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import androidx.core.view.InputDeviceCompat;
import com.airbnb.lottie.L;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.track.ui.TrackUI;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ksad.lottie.model.layer.Layer;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
/* loaded from: classes7.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final l f33736a;

    /* renamed from: b  reason: collision with root package name */
    public final HashSet<String> f33737b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, List<Layer>> f33738c;

    /* renamed from: d  reason: collision with root package name */
    public Map<String, g> f33739d;

    /* renamed from: e  reason: collision with root package name */
    public Map<String, com.ksad.lottie.model.c> f33740e;

    /* renamed from: f  reason: collision with root package name */
    public SparseArrayCompat<com.ksad.lottie.model.d> f33741f;

    /* renamed from: g  reason: collision with root package name */
    public LongSparseArray<Layer> f33742g;

    /* renamed from: h  reason: collision with root package name */
    public List<Layer> f33743h;

    /* renamed from: i  reason: collision with root package name */
    public Rect f33744i;
    public float j;
    public float k;
    public float l;

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f33736a = new l();
        this.f33737b = new HashSet<>();
    }

    public l a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f33736a : (l) invokeV.objValue;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Layer a(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) ? this.f33742g.get(j) : (Layer) invokeJ.objValue;
    }

    public void a(Rect rect, float f2, float f3, float f4, List<Layer> list, LongSparseArray<Layer> longSparseArray, Map<String, List<Layer>> map, Map<String, g> map2, SparseArrayCompat<com.ksad.lottie.model.d> sparseArrayCompat, Map<String, com.ksad.lottie.model.c> map3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{rect, Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), list, longSparseArray, map, map2, sparseArrayCompat, map3}) == null) {
            this.f33744i = rect;
            this.j = f2;
            this.k = f3;
            this.l = f4;
            this.f33743h = list;
            this.f33742g = longSparseArray;
            this.f33738c = map;
            this.f33739d = map2;
            this.f33741f = sparseArrayCompat;
            this.f33740e = map3;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            Log.w(L.TAG, str);
            this.f33737b.add(str);
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.f33736a.a(z);
        }
    }

    public Rect b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f33744i : (Rect) invokeV.objValue;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public List<Layer> b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) ? this.f33738c.get(str) : (List) invokeL.objValue;
    }

    public float c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? (k() / this.l) * 1000.0f : invokeV.floatValue;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public float d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.j : invokeV.floatValue;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public float e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.k : invokeV.floatValue;
    }

    public float f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.l : invokeV.floatValue;
    }

    public List<Layer> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f33743h : (List) invokeV.objValue;
    }

    public SparseArrayCompat<com.ksad.lottie.model.d> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f33741f : (SparseArrayCompat) invokeV.objValue;
    }

    public Map<String, com.ksad.lottie.model.c> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f33740e : (Map) invokeV.objValue;
    }

    public Map<String, g> j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f33739d : (Map) invokeV.objValue;
    }

    public float k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.k - this.j : invokeV.floatValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            StringBuilder sb = new StringBuilder("LottieComposition:\n");
            for (Layer layer : this.f33743h) {
                sb.append(layer.a(TrackUI.SEPERATOR));
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}

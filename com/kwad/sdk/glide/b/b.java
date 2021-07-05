package com.kwad.sdk.glide.b;

import androidx.annotation.ColorInt;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f37595a;

    /* renamed from: b  reason: collision with root package name */
    public int f37596b;

    /* renamed from: c  reason: collision with root package name */
    public int f37597c;

    /* renamed from: d  reason: collision with root package name */
    public int f37598d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f37599e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f37600f;

    /* renamed from: g  reason: collision with root package name */
    public int f37601g;

    /* renamed from: h  reason: collision with root package name */
    public int f37602h;

    /* renamed from: i  reason: collision with root package name */
    public int f37603i;
    public int j;
    @ColorInt
    public int[] k;

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }
}

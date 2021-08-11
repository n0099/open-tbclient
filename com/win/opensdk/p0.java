package com.win.opensdk;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class p0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f76747a;

    /* renamed from: b  reason: collision with root package name */
    public int f76748b;

    /* renamed from: c  reason: collision with root package name */
    public int f76749c;

    /* renamed from: d  reason: collision with root package name */
    public int f76750d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f76751e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f76752f;

    /* renamed from: g  reason: collision with root package name */
    public int f76753g;

    /* renamed from: h  reason: collision with root package name */
    public int f76754h;

    /* renamed from: i  reason: collision with root package name */
    public int f76755i;

    /* renamed from: j  reason: collision with root package name */
    public int f76756j;
    public int[] k;

    public p0() {
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

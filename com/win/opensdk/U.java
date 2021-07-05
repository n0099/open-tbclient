package com.win.opensdk;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class U {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int[] f42478a;

    /* renamed from: b  reason: collision with root package name */
    public int f42479b;

    /* renamed from: c  reason: collision with root package name */
    public int f42480c;

    /* renamed from: d  reason: collision with root package name */
    public T f42481d;

    /* renamed from: e  reason: collision with root package name */
    public List f42482e;

    /* renamed from: f  reason: collision with root package name */
    public int f42483f;

    /* renamed from: g  reason: collision with root package name */
    public int f42484g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f42485h;

    /* renamed from: i  reason: collision with root package name */
    public int f42486i;
    public int j;
    public int k;
    public int l;
    public int m;

    public U() {
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
        this.f42478a = null;
        this.f42479b = 0;
        this.f42480c = 0;
        this.f42482e = new ArrayList();
        this.m = 0;
    }
}

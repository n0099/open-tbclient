package com.win.opensdk;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class U {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int[] f39492a;

    /* renamed from: b  reason: collision with root package name */
    public int f39493b;

    /* renamed from: c  reason: collision with root package name */
    public int f39494c;

    /* renamed from: d  reason: collision with root package name */
    public T f39495d;

    /* renamed from: e  reason: collision with root package name */
    public List f39496e;

    /* renamed from: f  reason: collision with root package name */
    public int f39497f;

    /* renamed from: g  reason: collision with root package name */
    public int f39498g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f39499h;

    /* renamed from: i  reason: collision with root package name */
    public int f39500i;
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
        this.f39492a = null;
        this.f39493b = 0;
        this.f39494c = 0;
        this.f39496e = new ArrayList();
        this.m = 0;
    }
}

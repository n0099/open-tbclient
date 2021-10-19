package com.win.opensdk;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class q0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int[] f77495a;

    /* renamed from: b  reason: collision with root package name */
    public int f77496b;

    /* renamed from: c  reason: collision with root package name */
    public int f77497c;

    /* renamed from: d  reason: collision with root package name */
    public p0 f77498d;

    /* renamed from: e  reason: collision with root package name */
    public List f77499e;

    /* renamed from: f  reason: collision with root package name */
    public int f77500f;

    /* renamed from: g  reason: collision with root package name */
    public int f77501g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f77502h;

    /* renamed from: i  reason: collision with root package name */
    public int f77503i;

    /* renamed from: j  reason: collision with root package name */
    public int f77504j;
    public int k;
    public int l;
    public int m;

    public q0() {
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
        this.f77495a = null;
        this.f77496b = 0;
        this.f77497c = 0;
        this.f77499e = new ArrayList();
        this.m = 0;
    }
}

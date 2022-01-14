package com.kuaishou.weapon.un;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
/* loaded from: classes3.dex */
public class m implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long o = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f55153b;

    /* renamed from: c  reason: collision with root package name */
    public String f55154c;

    /* renamed from: d  reason: collision with root package name */
    public String f55155d;

    /* renamed from: e  reason: collision with root package name */
    public String f55156e;

    /* renamed from: f  reason: collision with root package name */
    public int f55157f;

    /* renamed from: g  reason: collision with root package name */
    public int f55158g;

    /* renamed from: h  reason: collision with root package name */
    public int f55159h;

    /* renamed from: i  reason: collision with root package name */
    public int f55160i;

    /* renamed from: j  reason: collision with root package name */
    public String f55161j;
    public String k;
    public String l;
    public int m;
    public String n;

    public m() {
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

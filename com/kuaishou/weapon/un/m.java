package com.kuaishou.weapon.un;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
/* loaded from: classes7.dex */
public class m implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long o = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f38901b;

    /* renamed from: c  reason: collision with root package name */
    public String f38902c;

    /* renamed from: d  reason: collision with root package name */
    public String f38903d;

    /* renamed from: e  reason: collision with root package name */
    public String f38904e;

    /* renamed from: f  reason: collision with root package name */
    public int f38905f;

    /* renamed from: g  reason: collision with root package name */
    public int f38906g;

    /* renamed from: h  reason: collision with root package name */
    public int f38907h;
    public int i;
    public String j;
    public String k;
    public String l;
    public int m;
    public String n;

    public m() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }
}

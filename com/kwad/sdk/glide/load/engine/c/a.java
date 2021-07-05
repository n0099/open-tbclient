package com.kwad.sdk.glide.load.engine.c;

import android.os.Handler;
import android.os.Looper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.glide.load.DecodeFormat;
import com.kwad.sdk.glide.load.engine.a.h;
import com.kwad.sdk.glide.load.engine.bitmap_recycle.e;
/* loaded from: classes7.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final h f38064a;

    /* renamed from: b  reason: collision with root package name */
    public final e f38065b;

    /* renamed from: c  reason: collision with root package name */
    public final DecodeFormat f38066c;

    /* renamed from: d  reason: collision with root package name */
    public final Handler f38067d;

    public a(h hVar, e eVar, DecodeFormat decodeFormat) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {hVar, eVar, decodeFormat};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f38067d = new Handler(Looper.getMainLooper());
        this.f38064a = hVar;
        this.f38065b = eVar;
        this.f38066c = decodeFormat;
    }
}

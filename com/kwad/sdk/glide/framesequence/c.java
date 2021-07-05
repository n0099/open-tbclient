package com.kwad.sdk.glide.framesequence;

import android.graphics.Bitmap;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.glide.framesequence.FrameSequenceDrawable;
import com.kwad.sdk.glide.load.engine.s;
/* loaded from: classes7.dex */
public class c<DataType> implements com.kwad.sdk.glide.load.f<DataType, FrameSequenceDrawable> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.f<DataType, FrameSequence> f37721a;

    /* renamed from: b  reason: collision with root package name */
    public final FrameSequenceDrawable.a f37722b;

    public c(com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar, com.kwad.sdk.glide.load.f<DataType, FrameSequence> fVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar, fVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f37721a = fVar;
        this.f37722b = new FrameSequenceDrawable.a(this, eVar) { // from class: com.kwad.sdk.glide.framesequence.c.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ com.kwad.sdk.glide.load.engine.bitmap_recycle.e f37723a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ c f37724b;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this, eVar};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f37724b = this;
                this.f37723a = eVar;
            }

            @Override // com.kwad.sdk.glide.framesequence.FrameSequenceDrawable.a
            public Bitmap a(int i4, int i5) {
                InterceptResult invokeII;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeII = interceptable2.invokeII(1048576, this, i4, i5)) == null) ? this.f37723a.a(i4, i5, Bitmap.Config.ARGB_8888) : (Bitmap) invokeII.objValue;
            }

            @Override // com.kwad.sdk.glide.framesequence.FrameSequenceDrawable.a
            public void a(Bitmap bitmap) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitmap) == null) {
                    this.f37723a.a(bitmap);
                }
            }
        };
    }

    @Override // com.kwad.sdk.glide.load.f
    @Nullable
    public s<FrameSequenceDrawable> a(DataType datatype, int i2, int i3, com.kwad.sdk.glide.load.e eVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{datatype, Integer.valueOf(i2), Integer.valueOf(i3), eVar})) == null) {
            s<FrameSequence> a2 = this.f37721a.a(datatype, i2, i3, eVar);
            if (a2 == null) {
                return null;
            }
            return new d(new FrameSequenceDrawable(a2.e(), this.f37722b));
        }
        return (s) invokeCommon.objValue;
    }

    @Override // com.kwad.sdk.glide.load.f
    public boolean a(DataType datatype, com.kwad.sdk.glide.load.e eVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, datatype, eVar)) == null) ? this.f37721a.a(datatype, eVar) : invokeLL.booleanValue;
    }
}

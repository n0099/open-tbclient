package com.kwad.sdk.glide.framesequence;

import android.graphics.Bitmap;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.glide.framesequence.FrameSequenceDrawable;
import com.kwad.sdk.glide.load.engine.s;
/* loaded from: classes7.dex */
public class e implements com.kwad.sdk.glide.load.resource.e.e<FrameSequence, FrameSequenceDrawable> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final FrameSequenceDrawable.a f37725a;

    public e(com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f37725a = new FrameSequenceDrawable.a(this, eVar) { // from class: com.kwad.sdk.glide.framesequence.e.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ com.kwad.sdk.glide.load.engine.bitmap_recycle.e f37726a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ e f37727b;

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
                this.f37727b = this;
                this.f37726a = eVar;
            }

            @Override // com.kwad.sdk.glide.framesequence.FrameSequenceDrawable.a
            public Bitmap a(int i4, int i5) {
                InterceptResult invokeII;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeII = interceptable2.invokeII(1048576, this, i4, i5)) == null) ? this.f37726a.a(i4, i5, Bitmap.Config.ARGB_8888) : (Bitmap) invokeII.objValue;
            }

            @Override // com.kwad.sdk.glide.framesequence.FrameSequenceDrawable.a
            public void a(Bitmap bitmap) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitmap) == null) {
                    this.f37726a.a(bitmap);
                }
            }
        };
    }

    @Override // com.kwad.sdk.glide.load.resource.e.e
    public s<FrameSequenceDrawable> a(s<FrameSequence> sVar, com.kwad.sdk.glide.load.e eVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, sVar, eVar)) == null) ? new d(new FrameSequenceDrawable(sVar.e(), this.f37725a)) : (s) invokeLL.objValue;
    }
}

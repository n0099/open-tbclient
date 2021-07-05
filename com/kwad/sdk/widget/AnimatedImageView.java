package com.kwad.sdk.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.page.widget.RoundAngleImageView;
import com.kwad.sdk.glide.framesequence.FrameSequence;
import com.kwad.sdk.glide.framesequence.FrameSequenceDrawable;
import com.kwad.sdk.glide.webp.e;
/* loaded from: classes7.dex */
public class AnimatedImageView extends RoundAngleImageView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f39416a;

    /* renamed from: b  reason: collision with root package name */
    public FrameSequenceDrawable f39417b;

    /* renamed from: c  reason: collision with root package name */
    public a f39418c;

    /* renamed from: d  reason: collision with root package name */
    public FrameSequenceDrawable.b f39419d;

    /* loaded from: classes7.dex */
    public interface a {
        void a();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnimatedImageView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f39416a = 1;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnimatedImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f39416a = 1;
        a(context, attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnimatedImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f39416a = 1;
        a(context, attributeSet);
    }

    private void a(Context context, AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65540, this, context, attributeSet) == null) {
            this.f39419d = new FrameSequenceDrawable.b(this) { // from class: com.kwad.sdk.widget.AnimatedImageView.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ AnimatedImageView f39420a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f39420a = this;
                }

                @Override // com.kwad.sdk.glide.framesequence.FrameSequenceDrawable.b
                public void a(FrameSequenceDrawable frameSequenceDrawable) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, frameSequenceDrawable) == null) || this.f39420a.f39418c == null) {
                        return;
                    }
                    this.f39420a.f39418c.a();
                }
            };
            e.a(context);
        }
    }

    public void a() {
        FrameSequenceDrawable frameSequenceDrawable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (frameSequenceDrawable = this.f39417b) == null) {
            return;
        }
        frameSequenceDrawable.start();
    }

    public void b() {
        FrameSequenceDrawable frameSequenceDrawable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (frameSequenceDrawable = this.f39417b) == null) {
            return;
        }
        frameSequenceDrawable.stop();
    }

    public void setOnFinishedListener(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            this.f39418c = aVar;
        }
    }

    public void setWebpStream(FrameSequence frameSequence) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, frameSequence) == null) || frameSequence == null) {
            return;
        }
        try {
            FrameSequenceDrawable frameSequenceDrawable = new FrameSequenceDrawable(frameSequence);
            frameSequenceDrawable.setLoopCount(this.f39416a);
            frameSequenceDrawable.setOnFinishedListener(this.f39419d);
            setImageDrawable(frameSequenceDrawable);
            if (this.f39417b != null) {
                this.f39417b.destroy();
            }
            this.f39417b = frameSequenceDrawable;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}

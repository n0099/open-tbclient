package com.opensource.svgaplayer;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.minivideo.effect.core.vlogedit.MediaAEffect;
import com.baidu.minivideo.effect.core.vlogedit.ShaderParams;
import com.baidu.tieba.video.VideoItemModel;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebChromeClient;
import com.kwad.v8.debug.ExecutionState;
import com.opensource.svgaplayer.SVGAParser;
import com.repackage.mj9;
import com.repackage.xi9;
import com.repackage.yi9;
import com.repackage.zi9;
import java.lang.reflect.Field;
import java.net.URL;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u00002\u00020\u0001:\u0001LB\u0013\b\u0016\u0012\b\u0010D\u001a\u0004\u0018\u00010C¢\u0006\u0004\bE\u0010FB\u001d\b\u0016\u0012\b\u0010D\u001a\u0004\u0018\u00010C\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\bE\u0010GB%\b\u0016\u0012\b\u0010D\u001a\u0004\u0018\u00010C\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010H\u001a\u00020\u0018¢\u0006\u0004\bE\u0010IB-\b\u0016\u0012\b\u0010D\u001a\u0004\u0018\u00010C\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010H\u001a\u00020\u0018\u0012\u0006\u0010J\u001a\u00020\u0018¢\u0006\u0004\bE\u0010KJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\bJ\u000f\u0010\n\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\bJ\u0017\u0010\r\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\r\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\r\u0010\u0011J\r\u0010\u0012\u001a\u00020\u0004¢\u0006\u0004\b\u0012\u0010\bJ!\u0010\u0012\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0012\u0010\u0017J\u001d\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0015¢\u0006\u0004\b\u001b\u0010\u001cJ\u001d\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001a\u001a\u00020\u0015¢\u0006\u0004\b\u001f\u0010 J\r\u0010!\u001a\u00020\u0004¢\u0006\u0004\b!\u0010\bJ\u0015\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u0015¢\u0006\u0004\b!\u0010#R\u0018\u0010%\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R$\u0010(\u001a\u0004\u0018\u00010'8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\"\u0010.\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u0010#R\"\u00104\u001a\u0002038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R*\u0010;\u001a\u00020\u00152\u0006\u0010:\u001a\u00020\u00158\u0006@BX\u0086\u000e¢\u0006\u0012\n\u0004\b;\u0010/\u001a\u0004\b;\u00101\"\u0004\b<\u0010#R\"\u0010=\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010B¨\u0006M"}, d2 = {"Lcom/opensource/svgaplayer/SVGAImageView;", "Landroid/widget/ImageView;", "Landroid/util/AttributeSet;", "attrs", "", "loadAttrs", "(Landroid/util/AttributeSet;)V", "onDetachedFromWindow", "()V", "pauseAnimation", "setSoftwareLayerType", "Lcom/opensource/svgaplayer/SVGAVideoEntity;", "videoItem", "setVideoItem", "(Lcom/opensource/svgaplayer/SVGAVideoEntity;)V", "Lcom/opensource/svgaplayer/SVGADynamicEntity;", "dynamicItem", "(Lcom/opensource/svgaplayer/SVGAVideoEntity;Lcom/opensource/svgaplayer/SVGADynamicEntity;)V", "startAnimation", "Lcom/opensource/svgaplayer/utils/SVGARange;", "range", "", MediaAEffect.AE_ANIM_REVERSE, "(Lcom/opensource/svgaplayer/utils/SVGARange;Z)V", "", ExecutionState.FRAME, "andPlay", "stepToFrame", "(IZ)V", "", "percentage", "stepToPercentage", "(DZ)V", "stopAnimation", "clear", "(Z)V", "Landroid/animation/ValueAnimator;", ShaderParams.VALUE_TYPE_ANIMATOR, "Landroid/animation/ValueAnimator;", "Lcom/opensource/svgaplayer/SVGACallback;", WebChromeClient.KEY_ARG_CALLBACK, "Lcom/opensource/svgaplayer/SVGACallback;", "getCallback", "()Lcom/opensource/svgaplayer/SVGACallback;", "setCallback", "(Lcom/opensource/svgaplayer/SVGACallback;)V", "clearsAfterStop", "Z", "getClearsAfterStop", "()Z", "setClearsAfterStop", "Lcom/opensource/svgaplayer/SVGAImageView$FillMode;", "fillMode", "Lcom/opensource/svgaplayer/SVGAImageView$FillMode;", "getFillMode", "()Lcom/opensource/svgaplayer/SVGAImageView$FillMode;", "setFillMode", "(Lcom/opensource/svgaplayer/SVGAImageView$FillMode;)V", "<set-?>", "isAnimating", "setAnimating", "loops", "I", "getLoops", "()I", "setLoops", "(I)V", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "FillMode", "library_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes5.dex */
public class SVGAImageView extends ImageView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public int b;
    public boolean c;
    public FillMode d;
    public xi9 e;
    public ValueAnimator f;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/opensource/svgaplayer/SVGAImageView$FillMode;", "Ljava/lang/Enum;", "<init>", "(Ljava/lang/String;I)V", "Backward", "Forward", "library_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes5.dex */
    public static final class FillMode {
        public static final /* synthetic */ FillMode[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final FillMode Backward;
        public static final FillMode Forward;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1795233139, "Lcom/opensource/svgaplayer/SVGAImageView$FillMode;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1795233139, "Lcom/opensource/svgaplayer/SVGAImageView$FillMode;");
                    return;
                }
            }
            FillMode fillMode = new FillMode("Backward", 0);
            Backward = fillMode;
            FillMode fillMode2 = new FillMode("Forward", 1);
            Forward = fillMode2;
            $VALUES = new FillMode[]{fillMode, fillMode2};
        }

        public FillMode(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static FillMode valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (FillMode) Enum.valueOf(FillMode.class, str) : (FillMode) invokeL.objValue;
        }

        public static FillMode[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (FillMode[]) $VALUES.clone() : (FillMode[]) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static final class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ SVGAParser b;
        public final /* synthetic */ SVGAImageView c;
        public final /* synthetic */ boolean d;
        public final /* synthetic */ boolean e;

        /* renamed from: com.opensource.svgaplayer.SVGAImageView$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public static final class C0375a implements SVGAParser.b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            /* renamed from: com.opensource.svgaplayer.SVGAImageView$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes5.dex */
            public static final class RunnableC0376a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ C0375a a;
                public final /* synthetic */ SVGAVideoEntity b;

                public RunnableC0376a(C0375a c0375a, SVGAVideoEntity sVGAVideoEntity) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {c0375a, sVGAVideoEntity};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = c0375a;
                    this.b = sVGAVideoEntity;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        this.b.o(this.a.a.d);
                        this.a.a.c.setVideoItem(this.b);
                        Drawable drawable = this.a.a.c.getDrawable();
                        if (!(drawable instanceof yi9)) {
                            drawable = null;
                        }
                        yi9 yi9Var = (yi9) drawable;
                        if (yi9Var != null) {
                            ImageView.ScaleType scaleType = this.a.a.c.getScaleType();
                            Intrinsics.checkExpressionValueIsNotNull(scaleType, "scaleType");
                            yi9Var.e(scaleType);
                        }
                        a aVar = this.a.a;
                        if (aVar.e) {
                            aVar.c.d();
                        }
                    }
                }
            }

            public C0375a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // com.opensource.svgaplayer.SVGAParser.b
            public void a(SVGAVideoEntity sVGAVideoEntity) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, sVGAVideoEntity) == null) {
                    this.a.c.post(new RunnableC0376a(this, sVGAVideoEntity));
                }
            }

            @Override // com.opensource.svgaplayer.SVGAParser.b
            public void onError() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                }
            }
        }

        public a(String str, SVGAParser sVGAParser, SVGAImageView sVGAImageView, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, sVGAParser, sVGAImageView, Boolean.valueOf(z), Boolean.valueOf(z2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.b = sVGAParser;
            this.c = sVGAImageView;
            this.d = z;
            this.e = z2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                C0375a c0375a = new C0375a(this);
                if (!StringsKt__StringsJVMKt.startsWith$default(this.a, "http://", false, 2, null) && !StringsKt__StringsJVMKt.startsWith$default(this.a, "https://", false, 2, null)) {
                    this.b.v(this.a, c0375a);
                } else {
                    this.b.w(new URL(this.a), c0375a);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class b implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ValueAnimator a;
        public final /* synthetic */ SVGAImageView b;
        public final /* synthetic */ yi9 c;

        public b(ValueAnimator valueAnimator, SVGAImageView sVGAImageView, mj9 mj9Var, yi9 yi9Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {valueAnimator, sVGAImageView, mj9Var, yi9Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = valueAnimator;
            this.b = sVGAImageView;
            this.c = yi9Var;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                yi9 yi9Var = this.c;
                ValueAnimator animator = this.a;
                Intrinsics.checkExpressionValueIsNotNull(animator, "animator");
                Object animatedValue = animator.getAnimatedValue();
                if (animatedValue != null) {
                    yi9Var.d(((Integer) animatedValue).intValue());
                    xi9 callback = this.b.getCallback();
                    if (callback != null) {
                        callback.b(this.c.a(), (this.c.a() + 1) / this.c.b().d());
                        return;
                    }
                    return;
                }
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class c implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;
        public final /* synthetic */ SVGAImageView c;
        public final /* synthetic */ yi9 d;

        public c(int i, int i2, SVGAImageView sVGAImageView, mj9 mj9Var, yi9 yi9Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), sVGAImageView, mj9Var, yi9Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i;
            this.b = i2;
            this.c = sVGAImageView;
            this.d = yi9Var;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                this.c.a = false;
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                this.c.a = false;
                this.c.f();
                if (!this.c.getClearsAfterStop()) {
                    if (this.c.getFillMode() == FillMode.Backward) {
                        this.d.d(this.a);
                    } else if (this.c.getFillMode() == FillMode.Forward) {
                        this.d.d(this.b);
                    }
                }
                xi9 callback = this.c.getCallback();
                if (callback != null) {
                    callback.a();
                }
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            xi9 callback;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) || (callback = this.c.getCallback()) == null) {
                return;
            }
            callback.c();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
                this.c.a = true;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SVGAImageView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = true;
        this.d = FillMode.Forward;
        c();
    }

    private final void setAnimating(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TRACKBALL, this, z) == null) {
        }
    }

    public final void b(AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, attributeSet) == null) {
            Context context = getContext();
            Intrinsics.checkExpressionValueIsNotNull(context, "context");
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.SVGAImageView, 0, 0);
            this.b = obtainStyledAttributes.getInt(R.styleable.SVGAImageView_loopCount, 0);
            this.c = obtainStyledAttributes.getBoolean(R.styleable.SVGAImageView_clearsAfterStop, true);
            boolean z = obtainStyledAttributes.getBoolean(R.styleable.SVGAImageView_antiAlias, true);
            boolean z2 = obtainStyledAttributes.getBoolean(R.styleable.SVGAImageView_autoPlay, true);
            String string = obtainStyledAttributes.getString(R.styleable.SVGAImageView_fillMode);
            if (string != null) {
                if (Intrinsics.areEqual(string, "0")) {
                    this.d = FillMode.Backward;
                } else if (Intrinsics.areEqual(string, "1")) {
                    this.d = FillMode.Forward;
                }
            }
            String string2 = obtainStyledAttributes.getString(R.styleable.SVGAImageView_source);
            if (string2 != null) {
                Context context2 = getContext();
                Intrinsics.checkExpressionValueIsNotNull(context2, "context");
                new Thread(new a(string2, new SVGAParser(context2), this, z, z2)).start();
            }
            obtainStyledAttributes.recycle();
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || Build.VERSION.SDK_INT >= 18) {
            return;
        }
        setLayerType(1, null);
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            e(null, false);
        }
    }

    public final void e(mj9 mj9Var, boolean z) {
        Field declaredField;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048579, this, mj9Var, z) == null) {
            g(false);
            Drawable drawable = getDrawable();
            if (!(drawable instanceof yi9)) {
                drawable = null;
            }
            yi9 yi9Var = (yi9) drawable;
            if (yi9Var != null) {
                yi9Var.c(false);
                ImageView.ScaleType scaleType = getScaleType();
                Intrinsics.checkExpressionValueIsNotNull(scaleType, "scaleType");
                yi9Var.e(scaleType);
                SVGAVideoEntity b2 = yi9Var.b();
                if (mj9Var == null) {
                    int max = Math.max(0, 0);
                    int d = b2.d() - 1;
                    if (mj9Var != null) {
                        mj9Var.b();
                        throw null;
                    } else if (mj9Var == null) {
                        int min = Math.min(d, (Integer.MAX_VALUE + 0) - 1);
                        ValueAnimator animator = ValueAnimator.ofInt(max, min);
                        double d2 = 1.0d;
                        try {
                            Class<?> cls = Class.forName("android.animation.ValueAnimator");
                            if (cls != null && (declaredField = cls.getDeclaredField("sDurationScale")) != null) {
                                declaredField.setAccessible(true);
                                double d3 = declaredField.getFloat(cls);
                                if (d3 == 0.0d) {
                                    try {
                                        declaredField.setFloat(cls, 1.0f);
                                        Log.e("SVGAPlayer", "The animation duration scale has been reset to 1.0x, because you closed it on developer options.");
                                    } catch (Exception unused) {
                                    }
                                }
                                d2 = d3;
                            }
                        } catch (Exception unused2) {
                        }
                        Intrinsics.checkExpressionValueIsNotNull(animator, "animator");
                        animator.setInterpolator(new LinearInterpolator());
                        animator.setDuration((long) ((((min - max) + 1) * (1000 / b2.c())) / d2));
                        int i = this.b;
                        animator.setRepeatCount(i <= 0 ? VideoItemModel.TYPE_LOADING : i - 1);
                        animator.addUpdateListener(new b(animator, this, mj9Var, yi9Var, z));
                        animator.addListener(new c(max, min, this, mj9Var, yi9Var, z));
                        if (z) {
                            animator.reverse();
                        } else {
                            animator.start();
                        }
                        this.f = animator;
                        return;
                    } else {
                        mj9Var.a();
                        throw null;
                    }
                }
                mj9Var.b();
                throw null;
            }
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            g(this.c);
        }
    }

    public final void g(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            ValueAnimator valueAnimator = this.f;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            ValueAnimator valueAnimator2 = this.f;
            if (valueAnimator2 != null) {
                valueAnimator2.removeAllListeners();
            }
            ValueAnimator valueAnimator3 = this.f;
            if (valueAnimator3 != null) {
                valueAnimator3.removeAllUpdateListeners();
            }
            Drawable drawable = getDrawable();
            if (!(drawable instanceof yi9)) {
                drawable = null;
            }
            yi9 yi9Var = (yi9) drawable;
            if (yi9Var != null) {
                yi9Var.c(z);
            }
        }
    }

    public final xi9 getCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.e : (xi9) invokeV.objValue;
    }

    public final boolean getClearsAfterStop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.c : invokeV.booleanValue;
    }

    public final FillMode getFillMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.d : (FillMode) invokeV.objValue;
    }

    public final int getLoops() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.b : invokeV.intValue;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onDetachedFromWindow();
            ValueAnimator valueAnimator = this.f;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            ValueAnimator valueAnimator2 = this.f;
            if (valueAnimator2 != null) {
                valueAnimator2.removeAllListeners();
            }
            ValueAnimator valueAnimator3 = this.f;
            if (valueAnimator3 != null) {
                valueAnimator3.removeAllUpdateListeners();
            }
        }
    }

    public final void setCallback(xi9 xi9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, xi9Var) == null) {
            this.e = xi9Var;
        }
    }

    public final void setClearsAfterStop(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.c = z;
        }
    }

    public final void setFillMode(FillMode fillMode) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, fillMode) == null) {
            this.d = fillMode;
        }
    }

    public final void setLoops(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.b = i;
        }
    }

    public final void setVideoItem(SVGAVideoEntity sVGAVideoEntity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, sVGAVideoEntity) == null) {
            setVideoItem(sVGAVideoEntity, new zi9());
        }
    }

    public final void setVideoItem(SVGAVideoEntity sVGAVideoEntity, zi9 zi9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, sVGAVideoEntity, zi9Var) == null) {
            if (sVGAVideoEntity == null) {
                setImageDrawable(null);
                return;
            }
            if (zi9Var == null) {
                zi9Var = new zi9();
            }
            yi9 yi9Var = new yi9(sVGAVideoEntity, zi9Var);
            yi9Var.c(this.c);
            setImageDrawable(yi9Var);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SVGAImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = true;
        this.d = FillMode.Forward;
        c();
        if (attributeSet != null) {
            b(attributeSet);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SVGAImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.c = true;
        this.d = FillMode.Forward;
        c();
        if (attributeSet != null) {
            b(attributeSet);
        }
    }
}

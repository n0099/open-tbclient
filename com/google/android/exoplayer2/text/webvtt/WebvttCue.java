package com.google.android.exoplayer2.text.webvtt;

import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.Cue;
/* loaded from: classes4.dex */
public final class WebvttCue extends Cue {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final long endTime;
    public final long startTime;

    /* renamed from: com.google.android.exoplayer2.text.webvtt.WebvttCue$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$android$text$Layout$Alignment;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1117269798, "Lcom/google/android/exoplayer2/text/webvtt/WebvttCue$1;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1117269798, "Lcom/google/android/exoplayer2/text/webvtt/WebvttCue$1;");
                    return;
                }
            }
            int[] iArr = new int[Layout.Alignment.values().length];
            $SwitchMap$android$text$Layout$Alignment = iArr;
            try {
                iArr[Layout.Alignment.ALIGN_NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$android$text$Layout$Alignment[Layout.Alignment.ALIGN_CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$android$text$Layout$Alignment[Layout.Alignment.ALIGN_OPPOSITE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class Builder {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String TAG = "WebvttCueBuilder";
        public transient /* synthetic */ FieldHolder $fh;
        public long endTime;
        public float line;
        public int lineAnchor;
        public int lineType;
        public float position;
        public int positionAnchor;
        public long startTime;
        public SpannableStringBuilder text;
        public Layout.Alignment textAlignment;
        public float width;

        public Builder() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            reset();
        }

        private Builder derivePositionAnchorFromAlignment() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
                Layout.Alignment alignment = this.textAlignment;
                if (alignment == null) {
                    this.positionAnchor = Integer.MIN_VALUE;
                } else {
                    int i = AnonymousClass1.$SwitchMap$android$text$Layout$Alignment[alignment.ordinal()];
                    if (i == 1) {
                        this.positionAnchor = 0;
                    } else if (i == 2) {
                        this.positionAnchor = 1;
                    } else if (i != 3) {
                        Log.w(TAG, "Unrecognized alignment: " + this.textAlignment);
                        this.positionAnchor = 0;
                    } else {
                        this.positionAnchor = 2;
                    }
                }
                return this;
            }
            return (Builder) invokeV.objValue;
        }

        public WebvttCue build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.position != Float.MIN_VALUE && this.positionAnchor == Integer.MIN_VALUE) {
                    derivePositionAnchorFromAlignment();
                }
                return new WebvttCue(this.startTime, this.endTime, this.text, this.textAlignment, this.line, this.lineType, this.lineAnchor, this.position, this.positionAnchor, this.width);
            }
            return (WebvttCue) invokeV.objValue;
        }

        public void reset() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.startTime = 0L;
                this.endTime = 0L;
                this.text = null;
                this.textAlignment = null;
                this.line = Float.MIN_VALUE;
                this.lineType = Integer.MIN_VALUE;
                this.lineAnchor = Integer.MIN_VALUE;
                this.position = Float.MIN_VALUE;
                this.positionAnchor = Integer.MIN_VALUE;
                this.width = Float.MIN_VALUE;
            }
        }

        public Builder setEndTime(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j)) == null) {
                this.endTime = j;
                return this;
            }
            return (Builder) invokeJ.objValue;
        }

        public Builder setLine(float f) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(1048579, this, f)) == null) {
                this.line = f;
                return this;
            }
            return (Builder) invokeF.objValue;
        }

        public Builder setLineAnchor(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
                this.lineAnchor = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setLineType(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
                this.lineType = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setPosition(float f) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(1048582, this, f)) == null) {
                this.position = f;
                return this;
            }
            return (Builder) invokeF.objValue;
        }

        public Builder setPositionAnchor(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
                this.positionAnchor = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setStartTime(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j)) == null) {
                this.startTime = j;
                return this;
            }
            return (Builder) invokeJ.objValue;
        }

        public Builder setText(SpannableStringBuilder spannableStringBuilder) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, spannableStringBuilder)) == null) {
                this.text = spannableStringBuilder;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setTextAlignment(Layout.Alignment alignment) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, alignment)) == null) {
                this.textAlignment = alignment;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setWidth(float f) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(1048587, this, f)) == null) {
                this.width = f;
                return this;
            }
            return (Builder) invokeF.objValue;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WebvttCue(CharSequence charSequence) {
        this(0L, 0L, charSequence);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r8;
            Object[] objArr = {charSequence};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Long) objArr2[0]).longValue(), ((Long) objArr2[1]).longValue(), (CharSequence) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    public boolean isNormalCue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.line == Float.MIN_VALUE && this.position == Float.MIN_VALUE : invokeV.booleanValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WebvttCue(long j, long j2, CharSequence charSequence) {
        this(j, j2, charSequence, null, Float.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Float.MIN_VALUE, Integer.MIN_VALUE, Float.MIN_VALUE);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {Long.valueOf(j), Long.valueOf(j2), charSequence};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Long) objArr2[0]).longValue(), ((Long) objArr2[1]).longValue(), (CharSequence) objArr2[2], (Layout.Alignment) objArr2[3], ((Float) objArr2[4]).floatValue(), ((Integer) objArr2[5]).intValue(), ((Integer) objArr2[6]).intValue(), ((Float) objArr2[7]).floatValue(), ((Integer) objArr2[8]).intValue(), ((Float) objArr2[9]).floatValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebvttCue(long j, long j2, CharSequence charSequence, Layout.Alignment alignment, float f, int i, int i2, float f2, int i3, float f3) {
        super(charSequence, alignment, f, i, i2, f2, i3, f3);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j), Long.valueOf(j2), charSequence, alignment, Float.valueOf(f), Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3), Float.valueOf(f3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((CharSequence) objArr2[0], (Layout.Alignment) objArr2[1], ((Float) objArr2[2]).floatValue(), ((Integer) objArr2[3]).intValue(), ((Integer) objArr2[4]).intValue(), ((Float) objArr2[5]).floatValue(), ((Integer) objArr2[6]).intValue(), ((Float) objArr2[7]).floatValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.startTime = j;
        this.endTime = j2;
    }
}

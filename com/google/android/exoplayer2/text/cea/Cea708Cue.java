package com.google.android.exoplayer2.text.cea;

import android.text.Layout;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.Cue;
/* loaded from: classes6.dex */
public final class Cea708Cue extends Cue implements Comparable<Cea708Cue> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int PRIORITY_UNSET = -1;
    public transient /* synthetic */ FieldHolder $fh;
    public final int priority;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Cea708Cue(CharSequence charSequence, Layout.Alignment alignment, float f2, int i, int i2, float f3, int i3, float f4, boolean z, int i4, int i5) {
        super(charSequence, alignment, f2, i, i2, f3, i3, f4, z, i4);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r4;
            Object[] objArr = {charSequence, alignment, Float.valueOf(f2), Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f3), Integer.valueOf(i3), Float.valueOf(f4), Boolean.valueOf(z), Integer.valueOf(i4), Integer.valueOf(i5)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i6 = newInitContext.flag;
            if ((i6 & 1) != 0) {
                int i7 = i6 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((CharSequence) objArr2[0], (Layout.Alignment) objArr2[1], ((Float) objArr2[2]).floatValue(), ((Integer) objArr2[3]).intValue(), ((Integer) objArr2[4]).intValue(), ((Float) objArr2[5]).floatValue(), ((Integer) objArr2[6]).intValue(), ((Float) objArr2[7]).floatValue(), ((Boolean) objArr2[8]).booleanValue(), ((Integer) objArr2[9]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.priority = i5;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    public int compareTo(@NonNull Cea708Cue cea708Cue) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cea708Cue)) == null) {
            int i = cea708Cue.priority;
            int i2 = this.priority;
            if (i < i2) {
                return -1;
            }
            return i > i2 ? 1 : 0;
        }
        return invokeL.intValue;
    }
}

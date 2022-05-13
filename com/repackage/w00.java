package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.cea.Cea608Decoder;
import com.kwad.yoga.YogaNodeJNIBase;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
/* loaded from: classes7.dex */
public class w00 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile byte[] a;
    public transient /* synthetic */ FieldHolder $fh;

    public w00() {
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

    public static byte[] a() throws InvalidAlgorithmParameterException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a == null) {
                synchronized (w00.class) {
                    if (a == null) {
                        byte[] bArr = new byte[16];
                        System.arraycopy(d10.a(), 0, bArr, 0, 16);
                        s00 s00Var = new s00();
                        s00Var.a(2, bArr, bArr);
                        a = s00Var.b(new byte[]{-71, -100, -115, 26, Cea608Decoder.CTRL_ROLL_UP_CAPTIONS_4_ROWS, -124, YogaNodeJNIBase.LAYOUT_BORDER_START_INDEX, YogaNodeJNIBase.LAYOUT_BORDER_START_INDEX, -31, -46, -56, 1, 25, -127, -99, -107, -54, 51, Cea608Decoder.CTRL_ERASE_NON_DISPLAYED_MEMORY, YogaNodeJNIBase.LAYOUT_BORDER_START_INDEX, 68, -68, -19, 28, 66, 19, -113, 5, 25, -11, -123, 50});
                    }
                }
            }
            return a;
        }
        return (byte[]) invokeV.objValue;
    }
}

package com.huawei.hms.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class SafeIntent extends Intent {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SafeIntent(Intent intent) {
        super(intent == null ? new Intent() : intent);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {intent};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Intent) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // android.content.Intent
    public String getAction() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                return super.getAction();
            } catch (Exception unused) {
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    @Override // android.content.Intent
    public Bundle getExtras() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            try {
                return super.getExtras();
            } catch (Exception unused) {
                return new Bundle();
            }
        }
        return (Bundle) invokeV.objValue;
    }

    @Override // android.content.Intent
    public boolean[] getBooleanArrayExtra(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            try {
                return super.getBooleanArrayExtra(str);
            } catch (Exception unused) {
                return new boolean[0];
            }
        }
        return (boolean[]) invokeL.objValue;
    }

    @Override // android.content.Intent
    public Bundle getBundleExtra(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            try {
                return super.getBundleExtra(str);
            } catch (Exception unused) {
                return new Bundle();
            }
        }
        return (Bundle) invokeL.objValue;
    }

    @Override // android.content.Intent
    public byte[] getByteArrayExtra(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            try {
                return super.getByteArrayExtra(str);
            } catch (Exception unused) {
                return new byte[0];
            }
        }
        return (byte[]) invokeL.objValue;
    }

    @Override // android.content.Intent
    public char[] getCharArrayExtra(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            try {
                return super.getCharArrayExtra(str);
            } catch (Exception unused) {
                return new char[0];
            }
        }
        return (char[]) invokeL.objValue;
    }

    @Override // android.content.Intent
    public CharSequence[] getCharSequenceArrayExtra(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            try {
                return super.getCharSequenceArrayExtra(str);
            } catch (Exception unused) {
                return new CharSequence[0];
            }
        }
        return (CharSequence[]) invokeL.objValue;
    }

    @Override // android.content.Intent
    public ArrayList<CharSequence> getCharSequenceArrayListExtra(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            try {
                return super.getCharSequenceArrayListExtra(str);
            } catch (Exception unused) {
                return new ArrayList<>();
            }
        }
        return (ArrayList) invokeL.objValue;
    }

    @Override // android.content.Intent
    public CharSequence getCharSequenceExtra(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            try {
                return super.getCharSequenceExtra(str);
            } catch (Exception unused) {
                return "";
            }
        }
        return (CharSequence) invokeL.objValue;
    }

    @Override // android.content.Intent
    public double[] getDoubleArrayExtra(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            try {
                return super.getDoubleArrayExtra(str);
            } catch (Exception unused) {
                return new double[0];
            }
        }
        return (double[]) invokeL.objValue;
    }

    @Override // android.content.Intent
    public float[] getFloatArrayExtra(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
            try {
                return super.getFloatArrayExtra(str);
            } catch (Exception unused) {
                return new float[0];
            }
        }
        return (float[]) invokeL.objValue;
    }

    @Override // android.content.Intent
    public int[] getIntArrayExtra(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) {
            try {
                return super.getIntArrayExtra(str);
            } catch (Exception unused) {
                return new int[0];
            }
        }
        return (int[]) invokeL.objValue;
    }

    @Override // android.content.Intent
    public ArrayList<Integer> getIntegerArrayListExtra(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, str)) == null) {
            try {
                return super.getIntegerArrayListExtra(str);
            } catch (Exception unused) {
                return new ArrayList<>();
            }
        }
        return (ArrayList) invokeL.objValue;
    }

    @Override // android.content.Intent
    public long[] getLongArrayExtra(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, str)) == null) {
            try {
                return super.getLongArrayExtra(str);
            } catch (Exception unused) {
                return new long[0];
            }
        }
        return (long[]) invokeL.objValue;
    }

    @Override // android.content.Intent
    public Parcelable[] getParcelableArrayExtra(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, str)) == null) {
            try {
                return super.getParcelableArrayExtra(str);
            } catch (Exception unused) {
                return new Parcelable[0];
            }
        }
        return (Parcelable[]) invokeL.objValue;
    }

    @Override // android.content.Intent
    public <T extends Parcelable> ArrayList<T> getParcelableArrayListExtra(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, str)) == null) {
            try {
                return super.getParcelableArrayListExtra(str);
            } catch (Exception unused) {
                return null;
            }
        }
        return (ArrayList) invokeL.objValue;
    }

    @Override // android.content.Intent
    public <T extends Parcelable> T getParcelableExtra(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, str)) == null) {
            try {
                return (T) super.getParcelableExtra(str);
            } catch (Exception unused) {
                return null;
            }
        }
        return (T) invokeL.objValue;
    }

    @Override // android.content.Intent
    public Serializable getSerializableExtra(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, str)) == null) {
            try {
                return super.getSerializableExtra(str);
            } catch (Exception unused) {
                return null;
            }
        }
        return (Serializable) invokeL.objValue;
    }

    @Override // android.content.Intent
    public short[] getShortArrayExtra(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, str)) == null) {
            try {
                return super.getShortArrayExtra(str);
            } catch (Exception unused) {
                return new short[0];
            }
        }
        return (short[]) invokeL.objValue;
    }

    @Override // android.content.Intent
    public String[] getStringArrayExtra(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, str)) == null) {
            try {
                return super.getStringArrayExtra(str);
            } catch (Exception unused) {
                return new String[0];
            }
        }
        return (String[]) invokeL.objValue;
    }

    @Override // android.content.Intent
    public ArrayList<String> getStringArrayListExtra(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, str)) == null) {
            try {
                return super.getStringArrayListExtra(str);
            } catch (Exception unused) {
                return new ArrayList<>();
            }
        }
        return (ArrayList) invokeL.objValue;
    }

    @Override // android.content.Intent
    public String getStringExtra(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, str)) == null) {
            try {
                return super.getStringExtra(str);
            } catch (Exception unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    @Override // android.content.Intent
    public boolean hasExtra(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, str)) == null) {
            try {
                return super.hasExtra(str);
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    @Override // android.content.Intent
    public boolean getBooleanExtra(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, str, z)) == null) {
            try {
                return super.getBooleanExtra(str, z);
            } catch (Exception unused) {
                return z;
            }
        }
        return invokeLZ.booleanValue;
    }

    @Override // android.content.Intent
    public byte getByteExtra(String str, byte b) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{str, Byte.valueOf(b)})) == null) {
            try {
                return super.getByteExtra(str, b);
            } catch (Exception unused) {
                return b;
            }
        }
        return invokeCommon.byteValue;
    }

    @Override // android.content.Intent
    public char getCharExtra(String str, char c) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{str, Character.valueOf(c)})) == null) {
            try {
                return super.getCharExtra(str, c);
            } catch (Exception unused) {
                return c;
            }
        }
        return invokeCommon.charValue;
    }

    @Override // android.content.Intent
    public double getDoubleExtra(String str, double d) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{str, Double.valueOf(d)})) == null) {
            try {
                return super.getDoubleExtra(str, d);
            } catch (Exception unused) {
                return d;
            }
        }
        return invokeCommon.doubleValue;
    }

    @Override // android.content.Intent
    public float getFloatExtra(String str, float f) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(1048591, this, str, f)) == null) {
            try {
                return super.getFloatExtra(str, f);
            } catch (Exception unused) {
                return f;
            }
        }
        return invokeLF.floatValue;
    }

    @Override // android.content.Intent
    public int getIntExtra(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048593, this, str, i)) == null) {
            try {
                return super.getIntExtra(str, i);
            } catch (Exception unused) {
                return i;
            }
        }
        return invokeLI.intValue;
    }

    @Override // android.content.Intent
    public long getLongExtra(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048596, this, str, j)) == null) {
            try {
                return super.getLongExtra(str, j);
            } catch (Exception unused) {
                return j;
            }
        }
        return invokeLJ.longValue;
    }

    @Override // android.content.Intent
    public short getShortExtra(String str, short s) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048602, this, new Object[]{str, Short.valueOf(s)})) == null) {
            try {
                return super.getShortExtra(str, s);
            } catch (Exception unused) {
                return s;
            }
        }
        return invokeCommon.shortValue;
    }
}

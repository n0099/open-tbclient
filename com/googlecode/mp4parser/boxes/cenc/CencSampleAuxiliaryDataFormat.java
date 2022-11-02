package com.googlecode.mp4parser.boxes.cenc;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.coremedia.iso.Hex;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes7.dex */
public class CencSampleAuxiliaryDataFormat {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public byte[] iv;
    public List<Pair> pairs;

    /* loaded from: classes7.dex */
    public class Pair {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int clear;
        public long encrypted;
        public final /* synthetic */ CencSampleAuxiliaryDataFormat this$0;

        public Pair(CencSampleAuxiliaryDataFormat cencSampleAuxiliaryDataFormat, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cencSampleAuxiliaryDataFormat, Integer.valueOf(i), Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = cencSampleAuxiliaryDataFormat;
            this.clear = i;
            this.encrypted = j;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || Pair.class != obj.getClass()) {
                    return false;
                }
                Pair pair = (Pair) obj;
                if (this.clear == pair.clear && this.encrypted == pair.encrypted) {
                    return true;
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                long j = this.encrypted;
                return (this.clear * 31) + ((int) (j ^ (j >>> 32)));
            }
            return invokeV.intValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return "clr:" + this.clear + " enc:" + this.encrypted;
            }
            return (String) invokeV.objValue;
        }
    }

    public CencSampleAuxiliaryDataFormat() {
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
        this.pairs = new LinkedList();
    }

    public int getSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            int length = this.iv.length;
            List<Pair> list = this.pairs;
            if (list != null && list.size() > 0) {
                return length + 2 + (this.pairs.size() * 6);
            }
            return length;
        }
        return invokeV.intValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            byte[] bArr = this.iv;
            int i2 = 0;
            if (bArr != null) {
                i = Arrays.hashCode(bArr);
            } else {
                i = 0;
            }
            int i3 = i * 31;
            List<Pair> list = this.pairs;
            if (list != null) {
                i2 = list.hashCode();
            }
            return i3 + i2;
        }
        return invokeV.intValue;
    }

    public Pair createPair(int i, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Long.valueOf(j)})) == null) {
            return new Pair(this, i, j);
        }
        return (Pair) invokeCommon.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj == null || CencSampleAuxiliaryDataFormat.class != obj.getClass()) {
                return false;
            }
            CencSampleAuxiliaryDataFormat cencSampleAuxiliaryDataFormat = (CencSampleAuxiliaryDataFormat) obj;
            if (!new BigInteger(this.iv).equals(new BigInteger(cencSampleAuxiliaryDataFormat.iv))) {
                return false;
            }
            List<Pair> list = this.pairs;
            List<Pair> list2 = cencSampleAuxiliaryDataFormat.pairs;
            if (list == null ? list2 == null : list.equals(list2)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return "Entry{iv=" + Hex.encodeHex(this.iv) + ", pairs=" + this.pairs + '}';
        }
        return (String) invokeV.objValue;
    }
}

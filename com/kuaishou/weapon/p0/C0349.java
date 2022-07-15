package com.kuaishou.weapon.p0;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* renamed from: com.kuaishou.weapon.p0.ʽ  reason: contains not printable characters */
/* loaded from: classes5.dex */
public class C0349 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: ʻ  reason: contains not printable characters */
    public int f159;

    /* renamed from: ʼ  reason: contains not printable characters */
    public String f160;

    /* renamed from: ʽ  reason: contains not printable characters */
    public String f161;

    /* renamed from: ʾ  reason: contains not printable characters */
    public int f162;

    /* renamed from: ʿ  reason: contains not printable characters */
    public int f163;

    /* renamed from: ˆ  reason: contains not printable characters */
    public String f164;

    /* renamed from: ˈ  reason: contains not printable characters */
    public int f165;

    /* renamed from: ˉ  reason: contains not printable characters */
    public int f166;

    /* renamed from: ˊ  reason: contains not printable characters */
    public int f167;

    /* renamed from: ˋ  reason: contains not printable characters */
    public String f168;

    /* renamed from: ˎ  reason: contains not printable characters */
    public C0351 f169;

    /* renamed from: ˏ  reason: contains not printable characters */
    public String f170;

    /* renamed from: ˑ  reason: contains not printable characters */
    public List<C0350> f171;

    /* renamed from: com.kuaishou.weapon.p0.ʽ$ʻ  reason: contains not printable characters */
    /* loaded from: classes5.dex */
    public static class C0350 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: ʻ  reason: contains not printable characters */
        public int f172;

        /* renamed from: ʼ  reason: contains not printable characters */
        public int f173;

        /* renamed from: ʽ  reason: contains not printable characters */
        public String f174;

        public C0350() {
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

        /* renamed from: ʻ  reason: contains not printable characters */
        public String m345() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f174 : (String) invokeV.objValue;
        }

        /* renamed from: ʻ  reason: contains not printable characters */
        public void m346(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                this.f172 = i;
            }
        }

        /* renamed from: ʻ  reason: contains not printable characters */
        public void m347(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                this.f174 = str;
            }
        }

        /* renamed from: ʼ  reason: contains not printable characters */
        public int m348() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f172 : invokeV.intValue;
        }

        /* renamed from: ʼ  reason: contains not printable characters */
        public void m349(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
                this.f173 = i;
            }
        }

        /* renamed from: ʽ  reason: contains not printable characters */
        public int m350() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f173 : invokeV.intValue;
        }
    }

    /* renamed from: com.kuaishou.weapon.p0.ʽ$ʼ  reason: contains not printable characters */
    /* loaded from: classes5.dex */
    public static class C0351 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: ʻ  reason: contains not printable characters */
        public int f175;

        /* renamed from: ʼ  reason: contains not printable characters */
        public int f176;

        public C0351() {
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

        /* renamed from: ʻ  reason: contains not printable characters */
        public int m351() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f175 : invokeV.intValue;
        }

        /* renamed from: ʻ  reason: contains not printable characters */
        public void m352(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                this.f175 = i;
            }
        }

        /* renamed from: ʼ  reason: contains not printable characters */
        public int m353() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f176 : invokeV.intValue;
        }

        /* renamed from: ʼ  reason: contains not printable characters */
        public void m354(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
                this.f176 = i;
            }
        }
    }

    public C0349() {
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

    /* renamed from: ʻ  reason: contains not printable characters */
    public List<C0350> m319() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f171 : (List) invokeV.objValue;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public void m320(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            this.f166 = i;
        }
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public void m321(C0351 c0351) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, c0351) == null) {
            this.f169 = c0351;
        }
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public void m322(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.f160 = str;
        }
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public void m323(List<C0350> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            this.f171 = list;
        }
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public String m324() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f160 : (String) invokeV.objValue;
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public void m325(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.f159 = i;
        }
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public void m326(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.f161 = str;
        }
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    public C0351 m327() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f169 : (C0351) invokeV.objValue;
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    public void m328(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.f162 = i;
        }
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    public void m329(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.f164 = str;
        }
    }

    /* renamed from: ʾ  reason: contains not printable characters */
    public int m330() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f166 : invokeV.intValue;
    }

    /* renamed from: ʾ  reason: contains not printable characters */
    public void m331(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.f163 = i;
        }
    }

    /* renamed from: ʾ  reason: contains not printable characters */
    public void m332(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.f168 = str;
        }
    }

    /* renamed from: ʿ  reason: contains not printable characters */
    public int m333() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f159 : invokeV.intValue;
    }

    /* renamed from: ʿ  reason: contains not printable characters */
    public void m334(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            this.f165 = i;
        }
    }

    /* renamed from: ʿ  reason: contains not printable characters */
    public void m335(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            this.f170 = str;
        }
    }

    /* renamed from: ˆ  reason: contains not printable characters */
    public String m336() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f161 : (String) invokeV.objValue;
    }

    /* renamed from: ˆ  reason: contains not printable characters */
    public void m337(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            this.f167 = i;
        }
    }

    /* renamed from: ˈ  reason: contains not printable characters */
    public int m338() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f162 : invokeV.intValue;
    }

    /* renamed from: ˉ  reason: contains not printable characters */
    public String m339() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f164 : (String) invokeV.objValue;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public int m340() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.f163 : invokeV.intValue;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public int m341() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.f165 : invokeV.intValue;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public int m342() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.f167 : invokeV.intValue;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public String m343() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.f168 : (String) invokeV.objValue;
    }

    /* renamed from: ˑ  reason: contains not printable characters */
    public String m344() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.f170 : (String) invokeV.objValue;
    }
}

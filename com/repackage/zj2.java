package com.repackage;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes7.dex */
public class zj2 extends DataInputStream {
    public static /* synthetic */ Interceptable $ic;
    public static final yj2<String, byte[]> a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements yj2<String, byte[]> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.yj2
        @Nullable
        public String call(@Nullable byte[] bArr) throws Exception {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bArr)) == null) {
                if (bArr == null) {
                    return null;
                }
                return bArr.length == 0 ? "" : new String(bArr);
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class b implements yj2<Boolean, byte[]> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zj2 a;

        public b(zj2 zj2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zj2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zj2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.yj2
        @Nullable
        public Boolean call(@Nullable byte[] bArr) throws Exception {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bArr)) == null) {
                return Boolean.valueOf(bArr != null);
            }
            return (Boolean) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755110161, "Lcom/repackage/zj2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755110161, "Lcom/repackage/zj2;");
                return;
            }
        }
        a = new a();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zj2(InputStream inputStream) throws IOException {
        super(inputStream);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {inputStream};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((InputStream) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public Map<String, Boolean> a() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? f(new b(this)) : (Map) invokeV.objValue;
    }

    public byte[] c() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            int readInt = readInt();
            if (readInt >= 0) {
                byte[] bArr = new byte[readInt];
                if (readInt == read(bArr)) {
                    return bArr;
                }
                return null;
            }
            return null;
        }
        return (byte[]) invokeV.objValue;
    }

    public <T> T d(@NonNull yj2<T, byte[]> yj2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, yj2Var)) == null) {
            try {
                return yj2Var.call(c());
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return (T) invokeL.objValue;
    }

    public <T> List<T> e(yj2<T, byte[]> yj2Var) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, yj2Var)) == null) {
            int readInt = readInt();
            if (readInt < 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList(readInt);
            for (int i = 0; i < readInt; i++) {
                try {
                    arrayList.add(yj2Var.call(c()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public <T> Map<String, T> f(yj2<T, byte[]> yj2Var) throws IOException {
        InterceptResult invokeL;
        List<String> j;
        List<T> e;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, yj2Var)) == null) {
            if (readInt() >= 0 && (j = j()) != null && (e = e(yj2Var)) != null && j.size() == e.size()) {
                HashMap hashMap = new HashMap();
                for (int i = 0; i < j.size(); i++) {
                    hashMap.put(j.get(i), e.get(i));
                }
                return hashMap;
            }
            return null;
        }
        return (Map) invokeL.objValue;
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            try {
                return a.call(c());
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    public List<String> j() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? e(a) : (List) invokeV.objValue;
    }

    public List<String> k(List<String> list) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, list)) == null) {
            List<String> j = j();
            return j == null ? list : j;
        }
        return (List) invokeL.objValue;
    }

    public Map<String, String> l() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? f(a) : (Map) invokeV.objValue;
    }
}

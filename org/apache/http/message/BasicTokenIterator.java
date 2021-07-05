package org.apache.http.message;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.NoSuchElementException;
import org.apache.http.HeaderIterator;
import org.apache.http.ParseException;
import org.apache.http.TokenIterator;
@Deprecated
/* loaded from: classes10.dex */
public class BasicTokenIterator implements TokenIterator {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String HTTP_SEPARATORS = " ,;=()<>@:\\\"/[]?{}\t";
    public transient /* synthetic */ FieldHolder $fh;
    public String currentHeader;
    public String currentToken;
    public final HeaderIterator headerIt;
    public int searchPos;

    public BasicTokenIterator(HeaderIterator headerIterator) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {headerIterator};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        throw new RuntimeException("Stub!");
    }

    public String createToken(String str, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, str, i2, i3)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (String) invokeLII.objValue;
    }

    public int findNext(int i2) throws ParseException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            throw new RuntimeException("Stub!");
        }
        return invokeI.intValue;
    }

    public int findTokenEnd(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            throw new RuntimeException("Stub!");
        }
        return invokeI.intValue;
    }

    public int findTokenSeparator(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            throw new RuntimeException("Stub!");
        }
        return invokeI.intValue;
    }

    public int findTokenStart(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            throw new RuntimeException("Stub!");
        }
        return invokeI.intValue;
    }

    @Override // org.apache.http.TokenIterator, java.util.Iterator
    public boolean hasNext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            throw new RuntimeException("Stub!");
        }
        return invokeV.booleanValue;
    }

    public boolean isHttpSeparator(char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Character.valueOf(c2)})) == null) {
            throw new RuntimeException("Stub!");
        }
        return invokeCommon.booleanValue;
    }

    public boolean isTokenChar(char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Character.valueOf(c2)})) == null) {
            throw new RuntimeException("Stub!");
        }
        return invokeCommon.booleanValue;
    }

    public boolean isTokenSeparator(char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Character.valueOf(c2)})) == null) {
            throw new RuntimeException("Stub!");
        }
        return invokeCommon.booleanValue;
    }

    public boolean isWhitespace(char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{Character.valueOf(c2)})) == null) {
            throw new RuntimeException("Stub!");
        }
        return invokeCommon.booleanValue;
    }

    @Override // java.util.Iterator
    public final Object next() throws NoSuchElementException, ParseException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            throw new RuntimeException("Stub!");
        }
        return invokeV.objValue;
    }

    @Override // org.apache.http.TokenIterator
    public String nextToken() throws NoSuchElementException, ParseException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (String) invokeV.objValue;
    }

    @Override // java.util.Iterator
    public final void remove() throws UnsupportedOperationException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            throw new RuntimeException("Stub!");
        }
    }
}

package io.reactivex.internal.util;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class LinkedArrayList {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int capacityHint;
    public Object[] head;
    public int indexInTail;
    public volatile int size;
    public Object[] tail;

    public LinkedArrayList(int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.capacityHint = i;
    }

    public void add(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
            if (this.size == 0) {
                Object[] objArr = new Object[this.capacityHint + 1];
                this.head = objArr;
                this.tail = objArr;
                objArr[0] = obj;
                this.indexInTail = 1;
                this.size = 1;
                return;
            }
            int i = this.indexInTail;
            int i2 = this.capacityHint;
            if (i == i2) {
                Object[] objArr2 = new Object[i2 + 1];
                objArr2[0] = obj;
                this.tail[i2] = objArr2;
                this.tail = objArr2;
                this.indexInTail = 1;
                this.size++;
                return;
            }
            this.tail[i] = obj;
            this.indexInTail = i + 1;
            this.size++;
        }
    }

    public Object[] head() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.head;
        }
        return (Object[]) invokeV.objValue;
    }

    public int size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.size;
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            int i = this.capacityHint;
            int i2 = this.size;
            ArrayList arrayList = new ArrayList(i2 + 1);
            Object[] head = head();
            int i3 = 0;
            while (true) {
                int i4 = 0;
                while (i3 < i2) {
                    arrayList.add(head[i4]);
                    i3++;
                    i4++;
                    if (i4 == i) {
                        break;
                    }
                }
                return arrayList.toString();
                head = head[i];
            }
        } else {
            return (String) invokeV.objValue;
        }
    }
}

package com.googlecode.mp4parser.h264;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class BTree {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BTree one;
    public Object value;
    public BTree zero;

    public BTree() {
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

    public Object getValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.value;
        }
        return invokeV.objValue;
    }

    public void addString(String str, Object obj) {
        BTree bTree;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, obj) == null) {
            if (str.length() == 0) {
                this.value = obj;
                return;
            }
            if (str.charAt(0) == '0') {
                if (this.zero == null) {
                    this.zero = new BTree();
                }
                bTree = this.zero;
            } else {
                if (this.one == null) {
                    this.one = new BTree();
                }
                bTree = this.one;
            }
            bTree.addString(str.substring(1), obj);
        }
    }

    public BTree down(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            if (i == 0) {
                return this.zero;
            }
            return this.one;
        }
        return (BTree) invokeI.objValue;
    }
}

package com.yy.mobile.framework.revenuesdk.payapi.callbackresult;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.payapi.bean.SplitRecordItem;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class SplitOrderConfigResult {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String bottomGuideMsg;
    public String hintMsg;
    public boolean needSplit;
    public String splitId;
    public List<SplitRecordItem> splitRecordItemList;

    public SplitOrderConfigResult() {
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
        this.splitRecordItemList = new ArrayList();
    }

    public SplitOrderConfigResult(boolean z, String str, String str2, List<SplitRecordItem> list, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z), str, str2, list, str3};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.splitRecordItemList = new ArrayList();
        this.needSplit = z;
        this.splitId = str;
        this.hintMsg = str2;
        this.splitRecordItemList = list;
        this.bottomGuideMsg = str3;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return "SplitOrderConfigResult{needSplit=" + this.needSplit + ", splitId=" + this.splitId + ", hintMsg=" + this.hintMsg + ", bottomGuideMsg=" + this.bottomGuideMsg + ", splitRecordItemList=" + this.splitRecordItemList + '}';
        }
        return (String) invokeV.objValue;
    }
}

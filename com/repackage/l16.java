package com.repackage;

import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.ItemData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.ApkDetail;
import tbclient.ManageInfo;
/* loaded from: classes6.dex */
public class l16 implements jn {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId e;
    public transient /* synthetic */ FieldHolder $fh;
    public ItemData a;
    public int b;
    public int c;
    public boolean d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755581888, "Lcom/repackage/l16;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755581888, "Lcom/repackage/l16;");
                return;
            }
        }
        e = BdUniqueId.gen();
    }

    public l16() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = null;
        this.b = 0;
        this.c = 0;
        this.d = true;
    }

    public static l16 b(vy4 vy4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, vy4Var)) == null) {
            l16 l16Var = new l16();
            l16Var.a = vy4Var.b;
            l16Var.b = vy4Var.d;
            l16Var.c = vy4Var.e;
            return l16Var;
        }
        return (l16) invokeL.objValue;
    }

    public static l16 e(ManageInfo manageInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, manageInfo)) == null) {
            l16 l16Var = new l16();
            ItemData itemData = new ItemData();
            l16Var.a = itemData;
            itemData.parseProto(manageInfo.item);
            l16Var.b = manageInfo.item_source.intValue();
            return l16Var;
        }
        return (l16) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: a */
    public l16 clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            l16 l16Var = new l16();
            l16Var.a = this.a;
            l16Var.b = this.b;
            l16Var.c = this.c;
            l16Var.d = this.d;
            return l16Var;
        }
        return (l16) invokeV.objValue;
    }

    public boolean f(l16 l16Var) {
        InterceptResult invokeL;
        ItemData itemData;
        ApkDetail apkDetail;
        ApkDetail apkDetail2;
        ItemData itemData2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, l16Var)) == null) {
            boolean z = this.b == l16Var.b && this.c == l16Var.c;
            ItemData itemData3 = this.a;
            boolean equals = (itemData3 == null || (itemData2 = l16Var.a) == null) ? false : itemData3.pkgName.equals(itemData2.pkgName);
            ItemData itemData4 = this.a;
            return z && equals && ((itemData4 == null || (itemData = l16Var.a) == null || (apkDetail = itemData4.apkDetail) == null || (apkDetail2 = itemData.apkDetail) == null) ? false : apkDetail.version_code.equals(apkDetail2.version_code));
        }
        return invokeL.booleanValue;
    }

    @Override // com.repackage.jn
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? e : (BdUniqueId) invokeV.objValue;
    }
}

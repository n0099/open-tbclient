package com.repackage;

import android.content.res.Resources;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import tbclient.ApkDetail;
import tbclient.ItemInfo;
/* loaded from: classes6.dex */
public class mn6 extends fo4 {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId b;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<rn6> a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755493476, "Lcom/repackage/mn6;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755493476, "Lcom/repackage/mn6;");
                return;
            }
        }
        b = BdUniqueId.gen();
    }

    public mn6() {
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
        setSupportType(BaseCardInfo.SupportType.FULL);
    }

    public ArrayList<rn6> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (ArrayList) invokeV.objValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? !ListUtils.isEmpty(this.a) : invokeV.booleanValue;
    }

    @Override // com.repackage.fo4
    public cq4 getNegFeedBackData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return null;
        }
        return (cq4) invokeV.objValue;
    }

    @Override // com.repackage.fo4
    public ThreadData getThreadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return null;
        }
        return (ThreadData) invokeV.objValue;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.repackage.on
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? b : (BdUniqueId) invokeV.objValue;
    }

    public void h(ItemInfo itemInfo) {
        ApkDetail apkDetail;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, itemInfo) == null) {
            if (this.a == null) {
                this.a = new ArrayList<>();
            }
            this.a.clear();
            if (itemInfo == null || (apkDetail = itemInfo.apk_detail) == null) {
                return;
            }
            if (!pi.isEmpty(apkDetail.developer)) {
                this.a.add(new rn6(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f04e7), itemInfo.apk_detail.developer, null));
            }
            if (!pi.isEmpty(itemInfo.apk_detail.publisher)) {
                this.a.add(new rn6(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0f3d), itemInfo.apk_detail.publisher, null));
            }
            if (!pi.isEmpty(itemInfo.apk_detail.version)) {
                this.a.add(new rn6(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0480), itemInfo.apk_detail.version, null));
            }
            if (!pi.isEmpty(itemInfo.apk_detail.update_time)) {
                this.a.add(new rn6(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f14c7), itemInfo.apk_detail.update_time, null));
            }
            if (og.g(itemInfo.apk_detail.size, 0L) > 0) {
                this.a.add(new rn6(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0614), StringHelper.getFormatSize(og.g(itemInfo.apk_detail.size, 0L)), null));
            }
            int intValue = itemInfo.apk_detail.need_network.intValue();
            int i = R.string.obfuscated_res_0x7f0f0531;
            if (intValue > 0) {
                this.a.add(new rn6(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f097f), TbadkCoreApplication.getInst().getResources().getString(itemInfo.apk_detail.need_network.intValue() == 1 ? R.string.obfuscated_res_0x7f0f0531 : R.string.obfuscated_res_0x7f0f0530), null));
            }
            if (itemInfo.apk_detail.need_inner_buy.intValue() > 0) {
                ArrayList<rn6> arrayList = this.a;
                String string = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0830);
                Resources resources = TbadkCoreApplication.getInst().getResources();
                if (itemInfo.apk_detail.need_inner_buy.intValue() != 1) {
                    i = R.string.obfuscated_res_0x7f0f0530;
                }
                arrayList.add(new rn6(string, resources.getString(i), null));
            }
            if (!pi.isEmpty(itemInfo.apk_detail.authority_url)) {
                this.a.add(new rn6(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0e0d), TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0982), itemInfo.apk_detail.authority_url));
            }
            if (pi.isEmpty(itemInfo.apk_detail.privacy_url)) {
                return;
            }
            this.a.add(new rn6(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0ef8), TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0982), itemInfo.apk_detail.privacy_url));
        }
    }
}

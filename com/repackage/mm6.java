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
public class mm6 extends pn4 {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId b;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<rm6> a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755494437, "Lcom/repackage/mm6;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755494437, "Lcom/repackage/mm6;");
                return;
            }
        }
        b = BdUniqueId.gen();
    }

    public mm6() {
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

    public ArrayList<rm6> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (ArrayList) invokeV.objValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? !ListUtils.isEmpty(this.a) : invokeV.booleanValue;
    }

    @Override // com.repackage.pn4
    public lp4 getNegFeedBackData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return null;
        }
        return (lp4) invokeV.objValue;
    }

    @Override // com.repackage.pn4
    public ThreadData getThreadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return null;
        }
        return (ThreadData) invokeV.objValue;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.repackage.uo
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? b : (BdUniqueId) invokeV.objValue;
    }

    public void i(ItemInfo itemInfo) {
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
            if (!ni.isEmpty(apkDetail.developer)) {
                this.a.add(new rm6(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f04d5), itemInfo.apk_detail.developer, null));
            }
            if (!ni.isEmpty(itemInfo.apk_detail.publisher)) {
                this.a.add(new rm6(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0efd), itemInfo.apk_detail.publisher, null));
            }
            if (!ni.isEmpty(itemInfo.apk_detail.version)) {
                this.a.add(new rm6(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f046b), itemInfo.apk_detail.version, null));
            }
            if (!ni.isEmpty(itemInfo.apk_detail.update_time)) {
                this.a.add(new rm6(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f1492), itemInfo.apk_detail.update_time, null));
            }
            if (mg.g(itemInfo.apk_detail.size, 0L) > 0) {
                this.a.add(new rm6(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f05ff), StringHelper.getFormatSize(mg.g(itemInfo.apk_detail.size, 0L)), null));
            }
            int intValue = itemInfo.apk_detail.need_network.intValue();
            int i = R.string.obfuscated_res_0x7f0f051d;
            if (intValue > 0) {
                this.a.add(new rm6(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0962), TbadkCoreApplication.getInst().getResources().getString(itemInfo.apk_detail.need_network.intValue() == 1 ? R.string.obfuscated_res_0x7f0f051d : R.string.obfuscated_res_0x7f0f051c), null));
            }
            if (itemInfo.apk_detail.need_inner_buy.intValue() > 0) {
                ArrayList<rm6> arrayList = this.a;
                String string = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f080c);
                Resources resources = TbadkCoreApplication.getInst().getResources();
                if (itemInfo.apk_detail.need_inner_buy.intValue() != 1) {
                    i = R.string.obfuscated_res_0x7f0f051c;
                }
                arrayList.add(new rm6(string, resources.getString(i), null));
            }
            if (!ni.isEmpty(itemInfo.apk_detail.authority_url)) {
                this.a.add(new rm6(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0dda), TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0965), itemInfo.apk_detail.authority_url));
            }
            if (ni.isEmpty(itemInfo.apk_detail.privacy_url)) {
                return;
            }
            this.a.add(new rm6(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0eb9), TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0965), itemInfo.apk_detail.privacy_url));
        }
    }
}

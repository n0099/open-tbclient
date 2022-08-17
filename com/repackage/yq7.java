package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class yq7 {
    public static /* synthetic */ Interceptable $ic;
    public static final a a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static final class a {
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

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void a(int i, int i2, int i3, String objParam1, String fid) {
            int i4;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), objParam1, fid}) == null) {
                Intrinsics.checkNotNullParameter(objParam1, "objParam1");
                Intrinsics.checkNotNullParameter(fid, "fid");
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_INTEREST_GUIDE_CLICK);
                statisticItem.param("obj_name", i);
                if (UbsABTestHelper.isFirstLoginTestA()) {
                    i4 = 1;
                } else {
                    i4 = UbsABTestHelper.isFirstLoginTestB() ? 2 : 3;
                }
                statisticItem.param("obj_type", i4);
                statisticItem.param("obj_locate", i2);
                statisticItem.param("obj_source", i3);
                statisticItem.param("obj_param1", objParam1);
                statisticItem.param("fid", fid);
                TiebaStatic.log(statisticItem);
            }
        }

        @JvmStatic
        public final void b(String objName) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, objName) == null) {
                Intrinsics.checkNotNullParameter(objName, "objName");
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_INTEREST_GUIDE_SEE_MORE_CLICK);
                statisticItem.param("obj_name", objName);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                TiebaStatic.log(statisticItem);
            }
        }

        @JvmStatic
        public final void c(int i, int i2) {
            int i3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_INTEREST_GUIDE_SHOW);
                statisticItem.param("obj_name", i);
                if (UbsABTestHelper.isFirstLoginTestA()) {
                    i3 = 1;
                } else {
                    i3 = UbsABTestHelper.isFirstLoginTestB() ? 2 : 3;
                }
                statisticItem.param("obj_type", i3);
                statisticItem.param("obj_source", i2);
                TiebaStatic.log(statisticItem);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755133070, "Lcom/repackage/yq7;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755133070, "Lcom/repackage/yq7;");
                return;
            }
        }
        a = new a(null);
    }

    @JvmStatic
    public static final void a(int i, int i2, int i3, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str, str2}) == null) {
            a.a(i, i2, i3, str, str2);
        }
    }

    @JvmStatic
    public static final void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, str) == null) {
            a.b(str);
        }
    }

    @JvmStatic
    public static final void c(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65539, null, i, i2) == null) {
            a.c(i, i2);
        }
    }
}

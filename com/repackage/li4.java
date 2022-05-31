package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BdToken.activeConfig.ActiveCenterData;
import com.baidu.tbadk.core.data.NewUserRedPackageData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import tbclient.ActiveConfig.DataRes;
import tbclient.FloatStrategy;
import tbclient.MissionInfo;
/* loaded from: classes6.dex */
public class li4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public DataRes a;
    public boolean b;
    public String c;
    public final ArrayList<lh4> d;
    public final ArrayList<FloatStrategy> e;
    public NewUserRedPackageData f;
    public ActiveCenterData g;

    public li4() {
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
        this.b = false;
        this.c = "";
        this.d = new ArrayList<>();
        this.e = new ArrayList<>();
    }

    public ArrayList<FloatStrategy> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.e : (ArrayList) invokeV.objValue;
    }

    public ArrayList<lh4> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.d : (ArrayList) invokeV.objValue;
    }

    public void c(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dataRes) == null) {
            this.a = dataRes;
            this.d.clear();
            this.e.clear();
            if (dataRes == null) {
                return;
            }
            this.b = dataRes.is_new_user.intValue() == 1;
            this.c = dataRes.active_url;
            this.e.addAll(dataRes.float_list);
            for (MissionInfo missionInfo : this.a.mission_list) {
                if (missionInfo != null) {
                    lh4 lh4Var = new lh4(missionInfo);
                    if (missionInfo.tasktype.intValue() == 5) {
                        ws4.e().g(missionInfo);
                    } else if (missionInfo.tasktype.intValue() == 9) {
                        zh4.c().f(lh4Var);
                    } else if (lh4Var.K()) {
                        this.d.add(lh4Var);
                    }
                }
            }
            NewUserRedPackageData newUserRedPackageData = new NewUserRedPackageData();
            this.f = newUserRedPackageData;
            newUserRedPackageData.parseProto(dataRes);
            if (dataRes.active_center != null) {
                ActiveCenterData activeCenterData = new ActiveCenterData();
                this.g = activeCenterData;
                activeCenterData.parseProto(dataRes);
            }
        }
    }
}

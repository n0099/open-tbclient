package d.a.o0.a.c0;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BdToken.activeConfig.ActiveCenterData;
import com.baidu.tbadk.core.data.NewUserRedPackageData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.r;
import java.util.ArrayList;
import tbclient.ActiveConfig.DataRes;
import tbclient.FloatStrategy;
import tbclient.MissionInfo;
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public DataRes f51245a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f51246b;

    /* renamed from: c  reason: collision with root package name */
    public String f51247c;

    /* renamed from: d  reason: collision with root package name */
    public final ArrayList<d.a.o0.a.c> f51248d;

    /* renamed from: e  reason: collision with root package name */
    public final ArrayList<FloatStrategy> f51249e;

    /* renamed from: f  reason: collision with root package name */
    public NewUserRedPackageData f51250f;

    /* renamed from: g  reason: collision with root package name */
    public ActiveCenterData f51251g;

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f51246b = false;
        this.f51247c = "";
        this.f51248d = new ArrayList<>();
        this.f51249e = new ArrayList<>();
    }

    public ArrayList<FloatStrategy> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f51249e : (ArrayList) invokeV.objValue;
    }

    public ArrayList<d.a.o0.a.c> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f51248d : (ArrayList) invokeV.objValue;
    }

    public void c(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dataRes) == null) {
            this.f51245a = dataRes;
            this.f51248d.clear();
            this.f51249e.clear();
            if (dataRes == null) {
                return;
            }
            this.f51246b = dataRes.is_new_user.intValue() == 1;
            this.f51247c = dataRes.active_url;
            this.f51249e.addAll(dataRes.float_list);
            for (MissionInfo missionInfo : this.f51245a.mission_list) {
                if (missionInfo != null) {
                    d.a.o0.a.c cVar = new d.a.o0.a.c(missionInfo);
                    if (missionInfo.tasktype.intValue() == 5) {
                        d.a.o0.r.c0.a.e().g(missionInfo);
                    } else if (missionInfo.tasktype.intValue() == 9) {
                        r.c().f(cVar);
                    } else if (cVar.K()) {
                        this.f51248d.add(cVar);
                    }
                }
            }
            NewUserRedPackageData newUserRedPackageData = new NewUserRedPackageData();
            this.f51250f = newUserRedPackageData;
            newUserRedPackageData.parseProto(dataRes);
            if (dataRes.active_center != null) {
                ActiveCenterData activeCenterData = new ActiveCenterData();
                this.f51251g = activeCenterData;
                activeCenterData.parseProto(dataRes);
            }
        }
    }
}

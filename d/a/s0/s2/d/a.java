package d.a.s0.s2.d;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.GetLockWindowMsg.DataRes;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f65429a;

    /* renamed from: b  reason: collision with root package name */
    public String f65430b;

    /* renamed from: c  reason: collision with root package name */
    public b f65431c;

    /* renamed from: d  reason: collision with root package name */
    public MetaData f65432d;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f65430b : (String) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f65429a : (String) invokeV.objValue;
    }

    public b c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f65431c : (b) invokeV.objValue;
    }

    public MetaData d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f65432d : (MetaData) invokeV.objValue;
    }

    public void e(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, dataRes) == null) || dataRes == null) {
            return;
        }
        this.f65429a = dataRes.publish_user;
        this.f65430b = dataRes.publish_pic;
        MetaData metaData = new MetaData();
        this.f65432d = metaData;
        metaData.parserProtobuf(dataRes.author);
        this.f65432d.setPendantData(null);
        b bVar = new b();
        this.f65431c = bVar;
        bVar.e(TbadkCoreApplication.getInst(), dataRes.thread_info);
    }
}

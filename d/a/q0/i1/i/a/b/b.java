package d.a.q0.i1.i.a.b;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.BroadcastInfo;
import tbclient.RecommendForumInfo;
import tbclient.ThreadInfo;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f59055a;

    /* renamed from: b  reason: collision with root package name */
    public String f59056b;

    /* renamed from: c  reason: collision with root package name */
    public String f59057c;

    /* renamed from: d  reason: collision with root package name */
    public long f59058d;

    /* renamed from: e  reason: collision with root package name */
    public int f59059e;

    /* renamed from: f  reason: collision with root package name */
    public long f59060f;

    /* renamed from: g  reason: collision with root package name */
    public int f59061g;

    /* renamed from: h  reason: collision with root package name */
    public String f59062h;

    /* renamed from: i  reason: collision with root package name */
    public int f59063i;
    public RecommendForumInfo j;
    public ThreadInfo k;

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
            }
        }
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f59063i : invokeV.intValue;
    }

    public long b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f59060f : invokeV.longValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f59056b : (String) invokeV.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f59062h : (String) invokeV.objValue;
    }

    public RecommendForumInfo e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.j : (RecommendForumInfo) invokeV.objValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f59057c : (String) invokeV.objValue;
    }

    public long g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f59058d : invokeV.longValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f59059e : invokeV.intValue;
    }

    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f59061g : invokeV.intValue;
    }

    public ThreadInfo j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.k : (ThreadInfo) invokeV.objValue;
    }

    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f59055a : (String) invokeV.objValue;
    }

    public void l(BroadcastInfo broadcastInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, broadcastInfo) == null) || broadcastInfo == null) {
            return;
        }
        this.f59060f = broadcastInfo.bcast_id.longValue();
        this.f59055a = broadcastInfo.title;
        this.f59056b = broadcastInfo.content;
        this.f59057c = broadcastInfo.pic_url;
        this.f59058d = broadcastInfo.publish_time.intValue();
        this.f59059e = broadcastInfo.pushuser_cnt.intValue();
        this.j = broadcastInfo.forum_info;
        this.k = broadcastInfo.thread_infos;
        this.f59062h = broadcastInfo.ctr;
        this.f59061g = broadcastInfo.pv.intValue();
        this.f59063i = broadcastInfo.audit_status.intValue();
    }
}

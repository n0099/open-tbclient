package d.a.q0.e1.j.h;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.tabfeed.data.SpecialColumnListData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.p0.s.q.b2;
import d.a.p0.s.q.l0;
import d.a.p0.s.q.n;
import d.a.p0.s.q.p1;
import d.a.p0.s.q.t1;
import java.util.ArrayList;
import java.util.List;
import tbclient.ActivityPage.DataRes;
import tbclient.ActivityPage.HotTopic;
import tbclient.ActivityPage.RecommendForumList;
import tbclient.ActivityPage.RecommendUserList;
import tbclient.ActivityPage.SpecialColumnList;
import tbclient.BannerImage;
import tbclient.Page;
import tbclient.ThreadInfo;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f56259a;

    /* renamed from: b  reason: collision with root package name */
    public int f56260b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<b2> f56261c;

    /* renamed from: d  reason: collision with root package name */
    public n f56262d;

    /* renamed from: e  reason: collision with root package name */
    public l0 f56263e;

    /* renamed from: f  reason: collision with root package name */
    public p1 f56264f;

    /* renamed from: g  reason: collision with root package name */
    public t1 f56265g;

    /* renamed from: h  reason: collision with root package name */
    public b f56266h;

    /* renamed from: i  reason: collision with root package name */
    public SpecialColumnListData f56267i;

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
                return;
            }
        }
        this.f56259a = true;
        this.f56260b = 1;
    }

    public n a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f56262d : (n) invokeV.objValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f56260b : invokeV.intValue;
    }

    public l0 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f56263e : (l0) invokeV.objValue;
    }

    public b d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f56266h : (b) invokeV.objValue;
    }

    public p1 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f56264f : (p1) invokeV.objValue;
    }

    public t1 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f56265g : (t1) invokeV.objValue;
    }

    public SpecialColumnListData g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f56267i : (SpecialColumnListData) invokeV.objValue;
    }

    public ArrayList<b2> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f56261c : (ArrayList) invokeV.objValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f56259a : invokeV.booleanValue;
    }

    public void j(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, dataRes) == null) || dataRes == null) {
            return;
        }
        Page page = dataRes.page_info;
        if (page != null) {
            this.f56260b = page.current_page.intValue();
            this.f56259a = page.has_more.intValue() == 1;
        }
        this.f56261c = new ArrayList<>(ListUtils.getCount(dataRes.thread_list));
        for (ThreadInfo threadInfo : dataRes.thread_list) {
            b2 b2Var = new b2();
            b2Var.K2(threadInfo);
            b2Var.A1();
            this.f56261c.add(b2Var);
        }
        List<BannerImage> list = dataRes.banner_image;
        if (!ListUtils.isEmpty(list)) {
            n nVar = new n();
            this.f56262d = nVar;
            nVar.parserProtobuf(list);
        }
        List<BannerImage> list2 = dataRes.grid;
        if (ListUtils.getCount(list2) >= 4) {
            l0 l0Var = new l0();
            this.f56263e = l0Var;
            l0Var.parserProtobuf(list2);
        }
        RecommendForumList recommendForumList = dataRes.recommend_forum;
        if (recommendForumList != null && ListUtils.getCount(recommendForumList.forum_list) >= 5) {
            p1 p1Var = new p1();
            this.f56264f = p1Var;
            p1Var.h(recommendForumList.forum_list);
            p1 p1Var2 = this.f56264f;
            p1Var2.j = recommendForumList.class_name;
            p1Var2.floorPosition = recommendForumList.floor_position.intValue();
            this.f56264f.f53411h = TbadkCoreApplication.getInst().getString(R.string.recommend_forum_list_title);
            this.f56264f.f53412i = R.color.CAM_X0108;
        }
        RecommendUserList recommendUserList = dataRes.recommend_user;
        if (recommendUserList != null && ListUtils.getCount(recommendUserList.user_list) >= 4) {
            t1 t1Var = new t1();
            this.f56265g = t1Var;
            t1Var.d(recommendUserList.user_list);
            this.f56265g.floorPosition = recommendUserList.floor_position.intValue();
            this.f56265g.f53442e = TbadkCoreApplication.getInst().getString(R.string.recommend_user_list_title);
            this.f56265g.f53443f = R.color.CAM_X0108;
        }
        HotTopic hotTopic = dataRes.hot_topic;
        if (hotTopic != null && ListUtils.getCount(hotTopic.topic_list) >= 4) {
            b bVar = new b();
            this.f56266h = bVar;
            bVar.e(hotTopic);
        }
        SpecialColumnList specialColumnList = dataRes.special_column;
        if (specialColumnList == null || ListUtils.getCount(specialColumnList.item_list) < 3) {
            return;
        }
        SpecialColumnListData specialColumnListData = new SpecialColumnListData();
        this.f56267i = specialColumnListData;
        specialColumnListData.parserProtobuf(specialColumnList);
    }
}

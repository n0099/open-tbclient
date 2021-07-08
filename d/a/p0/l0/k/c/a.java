package d.a.p0.l0.k.c;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.k.e.n;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import tbclient.RecommendForumInfo;
import tbclient.Recommforum.DataRes;
import tbclient.Recommforum.RecommForum;
import tbclient.Recommforum.TestInfo;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public List<f> f59706a;

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, Integer> f59707b;

    /* renamed from: c  reason: collision with root package name */
    public LinkedHashMap<String, List<b>> f59708c;

    /* renamed from: d  reason: collision with root package name */
    public HashMap<Long, Integer> f59709d;

    /* renamed from: e  reason: collision with root package name */
    public HashMap<String, List<b>> f59710e;

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

    public List<n> a(long j, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z)})) == null) {
            ArrayList arrayList = new ArrayList();
            if (j > 0) {
                List<n> c2 = c(j, z);
                if (c2 != null && !ListUtils.isEmpty(c2)) {
                    arrayList.addAll(c2);
                }
                List<n> b2 = b(z);
                if (b2 != null && !ListUtils.isEmpty(b2)) {
                    arrayList.addAll(b2);
                }
            } else {
                List<n> b3 = b(z);
                if (b3 != null && !ListUtils.isEmpty(b3)) {
                    arrayList.addAll(b3);
                }
            }
            e eVar = new e();
            eVar.f59728e = TbadkCoreApplication.getInst().getMainTabBottomBarHeightId();
            arrayList.add(eVar);
            return arrayList;
        }
        return (List) invokeCommon.objValue;
    }

    public List<n> b(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
            ArrayList arrayList = new ArrayList();
            HashMap<String, Integer> hashMap = this.f59707b;
            if (hashMap != null && hashMap.size() > 0) {
                for (String str : this.f59707b.keySet()) {
                    if (!StringUtils.isNull(str)) {
                        int intValue = this.f59707b.get(str).intValue();
                        d dVar = new d();
                        dVar.w(str);
                        dVar.needTopMargin = !z;
                        dVar.q(intValue);
                        dVar.p(e(str));
                        arrayList.add(dVar);
                        arrayList.addAll(dVar.o());
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeZ.objValue;
    }

    public final List<n> c(long j, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z)})) == null) {
            if (j <= 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            HashMap<String, List<b>> hashMap = this.f59710e;
            if (hashMap != null && hashMap.size() > 0) {
                Iterator<String> it = this.f59710e.keySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    String next = it.next();
                    if (!StringUtils.isNull(next)) {
                        String[] split = next.split("[|]");
                        if (String.valueOf(j).equals(split[0]) && split.length == 2 && !StringUtils.isNull(split[1])) {
                            String str = split[1];
                            int intValue = this.f59709d.get(Long.valueOf(j)).intValue();
                            d dVar = new d();
                            dVar.w(str);
                            dVar.needTopMargin = !z;
                            dVar.q(intValue);
                            dVar.p(g(next));
                            arrayList.add(dVar);
                            arrayList.addAll(dVar.o());
                            break;
                        }
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeCommon.objValue;
    }

    public List<f> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f59706a : (List) invokeV.objValue;
    }

    public final List<b> e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            ArrayList arrayList = new ArrayList();
            LinkedHashMap<String, List<b>> linkedHashMap = this.f59708c;
            if (linkedHashMap != null && linkedHashMap.size() > 0) {
                arrayList.addAll(this.f59708c.get(str));
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public List<f> f(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048581, this, j)) == null) {
            if (ListUtils.isEmpty(this.f59706a)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int size = this.f59706a.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    i2 = 0;
                    break;
                } else if (this.f59706a.get(i2).f59729a == j) {
                    break;
                } else {
                    i2++;
                }
            }
            if (i2 == 0) {
                int i3 = size - 1;
                arrayList.add(this.f59706a.get(i3));
                arrayList.addAll(this.f59706a.subList(0, i3));
            } else {
                int i4 = i2 - 1;
                arrayList.addAll(this.f59706a.subList(i4, size));
                arrayList.addAll(this.f59706a.subList(0, i4));
            }
            return arrayList;
        }
        return (List) invokeJ.objValue;
    }

    public final List<b> g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            ArrayList arrayList = new ArrayList();
            HashMap<String, List<b>> hashMap = this.f59710e;
            if (hashMap != null && hashMap.size() > 0) {
                arrayList.addAll(this.f59710e.get(str));
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public void h(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, dataRes) == null) || dataRes == null) {
            return;
        }
        if (!ListUtils.isEmpty(dataRes.test_info)) {
            this.f59706a = new ArrayList();
            this.f59709d = new HashMap<>();
            this.f59710e = new HashMap<>();
            for (TestInfo testInfo : dataRes.test_info) {
                if (testInfo != null) {
                    f fVar = new f();
                    fVar.a(testInfo);
                    this.f59706a.add(fVar);
                    RecommForum recommForum = testInfo.recomm_forum;
                    if (recommForum != null && !ListUtils.isEmpty(recommForum.forums)) {
                        ArrayList arrayList = new ArrayList();
                        for (RecommendForumInfo recommendForumInfo : testInfo.recomm_forum.forums) {
                            if (recommendForumInfo != null) {
                                b bVar = new b();
                                bVar.a(recommendForumInfo);
                                bVar.f59718h = 1;
                                arrayList.add(bVar);
                            }
                        }
                        this.f59709d.put(Long.valueOf(fVar.f59729a), testInfo.recomm_forum.page_size);
                        HashMap<String, List<b>> hashMap = this.f59710e;
                        hashMap.put(String.valueOf(fVar.f59729a) + "|" + testInfo.recomm_forum.title, arrayList);
                    }
                }
            }
        }
        if (ListUtils.isEmpty(dataRes.recomm_forum)) {
            return;
        }
        this.f59707b = new HashMap<>();
        this.f59708c = new LinkedHashMap<>();
        for (RecommForum recommForum2 : dataRes.recomm_forum) {
            if (recommForum2 != null && !ListUtils.isEmpty(recommForum2.forums)) {
                ArrayList arrayList2 = new ArrayList();
                for (RecommendForumInfo recommendForumInfo2 : recommForum2.forums) {
                    if (recommendForumInfo2 != null) {
                        b bVar2 = new b();
                        bVar2.a(recommendForumInfo2);
                        bVar2.f59718h = 2;
                        arrayList2.add(bVar2);
                    }
                }
                this.f59707b.put(recommForum2.title, recommForum2.page_size);
                this.f59708c.put(recommForum2.title, arrayList2);
            }
        }
    }
}

package com.repackage;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import tbclient.RecommendForumInfo;
import tbclient.Recommforum.DataRes;
import tbclient.Recommforum.RecommForum;
import tbclient.Recommforum.TestInfo;
/* loaded from: classes5.dex */
public class e66 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<j66> a;
    public HashMap<String, Integer> b;
    public LinkedHashMap<String, List<f66>> c;
    public HashMap<Long, Integer> d;
    public HashMap<String, List<f66>> e;

    public e66() {
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

    public List<uo> a(long j, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z)})) == null) {
            ArrayList arrayList = new ArrayList();
            if (j > 0) {
                List<uo> c = c(j, z);
                if (c != null && !ListUtils.isEmpty(c)) {
                    arrayList.addAll(c);
                }
                List<uo> b = b(z);
                if (b != null && !ListUtils.isEmpty(b)) {
                    arrayList.addAll(b);
                }
            } else {
                List<uo> b2 = b(z);
                if (b2 != null && !ListUtils.isEmpty(b2)) {
                    arrayList.addAll(b2);
                }
            }
            i66 i66Var = new i66();
            i66Var.a = TbadkCoreApplication.getInst().getMainTabBottomBarHeightId();
            arrayList.add(i66Var);
            return arrayList;
        }
        return (List) invokeCommon.objValue;
    }

    public List<uo> b(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
            ArrayList arrayList = new ArrayList();
            HashMap<String, Integer> hashMap = this.b;
            if (hashMap != null && hashMap.size() > 0) {
                for (String str : this.b.keySet()) {
                    if (!StringUtils.isNull(str)) {
                        int intValue = this.b.get(str).intValue();
                        h66 h66Var = new h66();
                        h66Var.setTitle(str);
                        h66Var.needTopMargin = !z;
                        h66Var.s(intValue);
                        h66Var.r(e(str));
                        arrayList.add(h66Var);
                        arrayList.addAll(h66Var.q());
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeZ.objValue;
    }

    public final List<uo> c(long j, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z)})) == null) {
            if (j <= 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            HashMap<String, List<f66>> hashMap = this.e;
            if (hashMap != null && hashMap.size() > 0) {
                Iterator<String> it = this.e.keySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    String next = it.next();
                    if (!StringUtils.isNull(next)) {
                        String[] split = next.split("[|]");
                        if (String.valueOf(j).equals(split[0]) && split.length == 2 && !StringUtils.isNull(split[1])) {
                            String str = split[1];
                            int intValue = this.d.get(Long.valueOf(j)).intValue();
                            h66 h66Var = new h66();
                            h66Var.setTitle(str);
                            h66Var.needTopMargin = !z;
                            h66Var.s(intValue);
                            h66Var.r(g(next));
                            arrayList.add(h66Var);
                            arrayList.addAll(h66Var.q());
                            break;
                        }
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeCommon.objValue;
    }

    public List<j66> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.a : (List) invokeV.objValue;
    }

    public final List<f66> e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            ArrayList arrayList = new ArrayList();
            LinkedHashMap<String, List<f66>> linkedHashMap = this.c;
            if (linkedHashMap != null && linkedHashMap.size() > 0) {
                arrayList.addAll(this.c.get(str));
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public List<j66> f(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048581, this, j)) == null) {
            if (ListUtils.isEmpty(this.a)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int size = this.a.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    i = 0;
                    break;
                } else if (this.a.get(i).a == j) {
                    break;
                } else {
                    i++;
                }
            }
            if (i == 0) {
                int i2 = size - 1;
                arrayList.add(this.a.get(i2));
                arrayList.addAll(this.a.subList(0, i2));
            } else {
                int i3 = i - 1;
                arrayList.addAll(this.a.subList(i3, size));
                arrayList.addAll(this.a.subList(0, i3));
            }
            return arrayList;
        }
        return (List) invokeJ.objValue;
    }

    public final List<f66> g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            ArrayList arrayList = new ArrayList();
            HashMap<String, List<f66>> hashMap = this.e;
            if (hashMap != null && hashMap.size() > 0) {
                arrayList.addAll(this.e.get(str));
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
            this.a = new ArrayList();
            this.d = new HashMap<>();
            this.e = new HashMap<>();
            for (TestInfo testInfo : dataRes.test_info) {
                if (testInfo != null) {
                    j66 j66Var = new j66();
                    j66Var.a(testInfo);
                    this.a.add(j66Var);
                    RecommForum recommForum = testInfo.recomm_forum;
                    if (recommForum != null && !ListUtils.isEmpty(recommForum.forums)) {
                        ArrayList arrayList = new ArrayList();
                        for (RecommendForumInfo recommendForumInfo : testInfo.recomm_forum.forums) {
                            if (recommendForumInfo != null) {
                                f66 f66Var = new f66();
                                f66Var.a(recommendForumInfo);
                                f66Var.h = 1;
                                arrayList.add(f66Var);
                            }
                        }
                        this.d.put(Long.valueOf(j66Var.a), testInfo.recomm_forum.page_size);
                        HashMap<String, List<f66>> hashMap = this.e;
                        hashMap.put(String.valueOf(j66Var.a) + "|" + testInfo.recomm_forum.title, arrayList);
                    }
                }
            }
        }
        if (ListUtils.isEmpty(dataRes.recomm_forum)) {
            return;
        }
        this.b = new HashMap<>();
        this.c = new LinkedHashMap<>();
        for (RecommForum recommForum2 : dataRes.recomm_forum) {
            if (recommForum2 != null && !ListUtils.isEmpty(recommForum2.forums)) {
                ArrayList arrayList2 = new ArrayList();
                for (RecommendForumInfo recommendForumInfo2 : recommForum2.forums) {
                    if (recommendForumInfo2 != null) {
                        f66 f66Var2 = new f66();
                        f66Var2.a(recommendForumInfo2);
                        f66Var2.h = 2;
                        arrayList2.add(f66Var2);
                    }
                }
                this.b.put(recommForum2.title, recommForum2.page_size);
                this.c.put(recommForum2.title, arrayList2);
            }
        }
    }
}

package com.repackage;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.abtest.group.AbsGroupUbsABTest;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsVideoTabPlayActivityConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.TbImageHelper;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.model.NetModel;
import com.baidu.tbadk.util.AdExtParam;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.frs.commontab.FrsCommonTabFragment;
import com.baidu.tieba.frs.commontab.FrsCommonTabNetModel;
import com.baidu.tieba.frs.commontab.FrsCommonTabRequestData;
import com.baidu.tieba.frs.dynamic.FrsDynamicModel;
import com.baidu.tieba.frs.dynamic.FrsDynamicRequestData;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
import tbclient.App;
/* loaded from: classes7.dex */
public class te6 implements NetModel.k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsCommonTabFragment a;
    public ue6 b;
    public FrsCommonTabRequestData c;
    public FrsCommonTabNetModel d;
    public boolean e;
    public FrsDynamicRequestData f;
    public FrsDynamicModel g;
    public boolean h;
    public HashSet<String> i;
    public int j;
    public long k;
    public int l;
    public String m;
    public String n;
    public rp6 o;

    public te6(FrsCommonTabFragment frsCommonTabFragment, int i, int i2, String str, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsCommonTabFragment, Integer.valueOf(i), Integer.valueOf(i2), str, Integer.valueOf(i3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = new HashSet<>();
        this.j = 1;
        this.k = -1L;
        if (frsCommonTabFragment == null) {
            return;
        }
        this.a = frsCommonTabFragment;
        this.n = "FRS_GENERAL_TAB" + i2;
        if (i2 == 89) {
            this.e = true;
            FrsDynamicRequestData frsDynamicRequestData = new FrsDynamicRequestData();
            this.f = frsDynamicRequestData;
            frsDynamicRequestData.forumId = i;
            frsDynamicRequestData.scrH = li.i(TbadkCoreApplication.getInst());
            this.f.scrW = li.k(TbadkCoreApplication.getInst());
            this.f.scrDip = li.h(TbadkCoreApplication.getInst());
            FrsDynamicModel frsDynamicModel = new FrsDynamicModel(frsCommonTabFragment.getPageContext(), this.f);
            this.g = frsDynamicModel;
            frsDynamicModel.a0(this);
            this.g.setUniqueId(frsCommonTabFragment.getUniqueId());
            return;
        }
        this.e = false;
        FrsCommonTabRequestData frsCommonTabRequestData = new FrsCommonTabRequestData();
        this.c = frsCommonTabRequestData;
        frsCommonTabRequestData.fid = i;
        frsCommonTabRequestData.tabId = i2;
        frsCommonTabRequestData.isDefaultNavTab = i(i2) ? 1 : 0;
        FrsCommonTabRequestData frsCommonTabRequestData2 = this.c;
        frsCommonTabRequestData2.tabName = str;
        frsCommonTabRequestData2.isGeneralTab = i3;
        FrsCommonTabNetModel frsCommonTabNetModel = new FrsCommonTabNetModel(frsCommonTabFragment.getPageContext(), this.c);
        this.d = frsCommonTabNetModel;
        frsCommonTabNetModel.a0(this);
        this.d.setUniqueId(frsCommonTabFragment.getUniqueId());
    }

    public void a(ThreadData threadData) {
        ue6 ue6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, threadData) == null) || threadData == null || (ue6Var = this.b) == null || ue6Var.c == null) {
            return;
        }
        ArrayList<jn> arrayList = new ArrayList<>();
        arrayList.add(threadData);
        ArrayList<jn> t = t(arrayList);
        if (ListUtils.isEmpty(this.b.c)) {
            this.b.c.addAll(t);
        } else {
            if (this.b.c.size() == 1 && (this.b.c.get(0) instanceof nb6)) {
                this.b.c.remove(0);
            }
            this.b.c.addAll(0, t);
        }
        this.a.Y0(this.b);
    }

    public final void b(List<jn> list) {
        JSONObject b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) || db7.e(list)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (jn jnVar : list) {
            if ((jnVar instanceof ThreadData) && (b = b98.b(((ThreadData) jnVar).getRawThreadInfo())) != null) {
                arrayList.add(b);
            }
        }
        b98.f().h(this.n, arrayList);
    }

    public final String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            int b = this.h ? 0 : u68.b(this.b.c);
            String d = this.h ? "" : b98.f().d(this.n);
            ue6 ue6Var = this.b;
            String e = u68.e(ue6Var == null ? null : ue6Var.c, this.h);
            AdExtParam.a b2 = AdExtParam.a.b();
            b2.g(b);
            b2.e(e);
            b2.c(d);
            b2.f(this.a.f);
            return b2.a();
        }
        return (String) invokeV.objValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ue6 ue6Var = this.b;
            if (ue6Var == null) {
                return true;
            }
            return ue6Var.a;
        }
        return invokeV.booleanValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.j : invokeV.intValue;
    }

    public ue6 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.b : (ue6) invokeV.objValue;
    }

    public final void g(List<App> list, List<jn> list2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, list, list2) == null) {
            b(list2);
            u68.i(u68.h(list, "FRS_GENERAL_TAB"), list2, 0);
            u68.a(list2, this.j, "FRS_GENERAL_TAB");
        }
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            ue6 ue6Var = this.b;
            return (ue6Var == null || ListUtils.isEmpty(ue6Var.c)) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final boolean i(int i) {
        InterceptResult invokeI;
        FrsViewData frsViewData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            FrsCommonTabFragment frsCommonTabFragment = this.a;
            return (frsCommonTabFragment == null || (frsViewData = frsCommonTabFragment.d) == null || frsViewData.mHeadLineDefaultNavTabId != i) ? false : true;
        }
        return invokeI.booleanValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.h : invokeV.booleanValue;
    }

    public void k(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            this.h = false;
            if (!this.e) {
                if (this.d.S()) {
                    return;
                }
                int i2 = this.j + 1;
                this.j = i2;
                FrsCommonTabRequestData frsCommonTabRequestData = this.c;
                frsCommonTabRequestData.pn = i2;
                frsCommonTabRequestData.sortType = i;
                frsCommonTabRequestData.lastThreadId = -1L;
                frsCommonTabRequestData.adExtParams = c();
                this.d.loadData();
            } else if (this.g.S()) {
                return;
            } else {
                if (TbImageHelper.getInstance().isShowBigImage()) {
                    this.f.qType = 2;
                } else {
                    this.f.qType = 1;
                }
                this.g.loadData();
            }
            mp6.a();
        }
    }

    public void l(String str) {
        ue6 ue6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, str) == null) || (ue6Var = this.b) == null || db7.e(ue6Var.c)) {
            return;
        }
        u68.d(str, this.b.c);
        this.a.Y0(this.b);
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.m
    public void m(MvcSocketResponsedMessage mvcSocketResponsedMessage, MvcSocketMessage mvcSocketMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048588, this, mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage) == null) || mvcSocketResponsedMessage == null) {
            return;
        }
        ue6 ue6Var = null;
        if (!mvcSocketResponsedMessage.hasError()) {
            if (mvcSocketResponsedMessage.getData() instanceof ue6) {
                ue6Var = (ue6) mvcSocketResponsedMessage.getData();
            } else if (mvcSocketResponsedMessage.getData() instanceof ve6) {
                ve6 ve6Var = (ve6) mvcSocketResponsedMessage.getData();
                ue6 ue6Var2 = new ue6();
                ArrayList<jn> arrayList = ve6Var.a;
                ue6Var2.c = arrayList;
                ue6Var2.a = ve6Var.c;
                ue6Var2.b = ve6Var.b;
                if (!ListUtils.isEmpty(arrayList)) {
                    ArrayList<jn> arrayList2 = ue6Var2.c;
                    jn jnVar = (jn) ListUtils.getItem(arrayList2, arrayList2.size() - 1);
                    if (jnVar instanceof ThreadData) {
                        this.f.lastThreadId = jg.g(((ThreadData) jnVar).getId(), 0L);
                    }
                }
                ue6Var = ue6Var2;
            }
        }
        if (ue6Var == null || !n(ue6Var)) {
            this.l = mvcSocketResponsedMessage.getError();
            this.m = mvcSocketResponsedMessage.getErrorString();
            ErrorData errorData = new ErrorData();
            errorData.setError_code(this.l);
            errorData.setError_msg(this.m);
            if (this.l != 0) {
                this.a.onServerError(errorData);
            }
        }
    }

    public final boolean n(ue6 ue6Var) {
        InterceptResult invokeL;
        rp6 rp6Var;
        rp6 rp6Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, ue6Var)) == null) {
            if (ue6Var == null) {
                return false;
            }
            boolean z = this.a.h == 100;
            ArrayList arrayList = new ArrayList();
            if (this.h) {
                this.i.clear();
                Iterator<jn> it = ue6Var.c.iterator();
                while (it.hasNext()) {
                    jn next = it.next();
                    if (next instanceof ThreadData) {
                        ThreadData threadData = (ThreadData) next;
                        String tid = threadData.getTid();
                        if (!this.i.contains(tid)) {
                            this.i.add(tid);
                        }
                        if (z && threadData.getThreadVideoInfo() != null && !TextUtils.isEmpty(threadData.getThreadVideoInfo().video_url)) {
                            VideoItemData videoItemData = new VideoItemData();
                            videoItemData.buildWithThreadData(threadData);
                            arrayList.add(videoItemData);
                        }
                    }
                }
                if (z && !arrayList.isEmpty()) {
                    FrsVideoTabPlayActivityConfig.putVideoTabListByFid(((VideoItemData) arrayList.get(0)).forum_id, arrayList);
                }
                int i = ue6Var.l;
                if (i != -1) {
                    if (i == 1) {
                        g(ue6Var.k, ue6Var.c);
                    } else if (i == 2) {
                        rp6 rp6Var3 = this.o;
                        if (rp6Var3 != null) {
                            rp6Var3.b(ue6Var.c, this.h, this.a.y());
                        }
                    } else if (i != 3) {
                        if (rp6.d()) {
                            rp6 rp6Var4 = this.o;
                            if (rp6Var4 != null) {
                                rp6Var4.b(ue6Var.c, this.h, this.a.y());
                            }
                        } else {
                            g(ue6Var.k, ue6Var.c);
                        }
                    } else if (!ListUtils.isEmpty(ue6Var.m)) {
                        int intValue = ue6Var.m.get(0).ad_type.intValue();
                        if (intValue == 1) {
                            g(ue6Var.k, ue6Var.c);
                        } else if (intValue == 2 && (rp6Var2 = this.o) != null) {
                            rp6Var2.g(ue6Var.c, ue6Var.m, this.h, this.a.y());
                        }
                    }
                }
                this.b = ue6Var;
                ue6Var.c = t(ue6Var.c);
            } else {
                ue6 ue6Var2 = this.b;
                ue6Var2.a = ue6Var.a;
                ue6Var2.b.putAll(ue6Var.b);
                ArrayList<jn> arrayList2 = new ArrayList<>();
                Iterator<jn> it2 = ue6Var.c.iterator();
                while (it2.hasNext()) {
                    jn next2 = it2.next();
                    if (next2 instanceof ThreadData) {
                        ThreadData threadData2 = (ThreadData) next2;
                        String tid2 = threadData2.getTid();
                        if (!this.i.contains(tid2)) {
                            threadData2.isFromBrandForum = this.a.l;
                            arrayList2.add(threadData2);
                            this.i.add(tid2);
                            if (z && threadData2.getThreadVideoInfo() != null && !TextUtils.isEmpty(threadData2.getThreadVideoInfo().video_url)) {
                                VideoItemData videoItemData2 = new VideoItemData();
                                videoItemData2.buildWithThreadData(threadData2);
                                arrayList.add(videoItemData2);
                            }
                        }
                    }
                }
                if (z && !arrayList.isEmpty()) {
                    FrsVideoTabPlayActivityConfig.getVideoTabListByFid(((VideoItemData) arrayList.get(0)).forum_id).addAll(arrayList);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921628));
                }
                int i2 = ue6Var.l;
                if (i2 == 1) {
                    g(ue6Var.k, ue6Var.c);
                } else if (i2 == 2) {
                    rp6 rp6Var5 = this.o;
                    if (rp6Var5 != null) {
                        rp6Var5.b(ue6Var.c, this.h, this.a.y());
                    }
                } else if (i2 != 3) {
                    if (rp6.d()) {
                        rp6 rp6Var6 = this.o;
                        if (rp6Var6 != null) {
                            rp6Var6.b(ue6Var.c, this.h, this.a.y());
                        }
                    } else {
                        g(ue6Var.k, ue6Var.c);
                    }
                } else if (!ListUtils.isEmpty(ue6Var.m)) {
                    int intValue2 = ue6Var.m.get(0).ad_type.intValue();
                    if (intValue2 == 1) {
                        g(ue6Var.k, ue6Var.c);
                    } else if (intValue2 == 2 && (rp6Var = this.o) != null) {
                        rp6Var.g(ue6Var.c, ue6Var.m, this.h, this.a.y());
                    }
                }
                this.b.c.addAll(t(arrayList2));
            }
            this.a.Y0(this.b);
            return true;
        }
        return invokeL.booleanValue;
    }

    public void o(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.h = true;
            if (!this.e) {
                if (this.d.S()) {
                    return;
                }
                this.j = 1;
                FrsCommonTabRequestData frsCommonTabRequestData = this.c;
                frsCommonTabRequestData.pn = 1;
                frsCommonTabRequestData.sortType = i;
                long j = this.k;
                if (j >= 0) {
                    frsCommonTabRequestData.lastThreadId = j;
                }
                this.c.adExtParams = c();
                this.d.loadData();
            } else if (this.g.S()) {
                return;
            } else {
                if (TbImageHelper.getInstance().isShowBigImage()) {
                    this.f.qType = 2;
                } else {
                    this.f.qType = 1;
                }
                this.f.lastThreadId = 0L;
                this.g.loadData();
            }
            mp6.a();
        }
    }

    public void p(rp6 rp6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, rp6Var) == null) {
            this.o = rp6Var;
        }
    }

    public void q(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048592, this, j) == null) {
            this.k = j;
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.l
    public void r(MvcHttpResponsedMessage mvcHttpResponsedMessage, MvcHttpMessage mvcHttpMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048593, this, mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage) == null) || mvcHttpResponsedMessage == null) {
            return;
        }
        ue6 ue6Var = null;
        if (!mvcHttpResponsedMessage.hasError()) {
            if (mvcHttpResponsedMessage.getData() instanceof ue6) {
                ue6Var = (ue6) mvcHttpResponsedMessage.getData();
            } else if (mvcHttpResponsedMessage.getData() instanceof ve6) {
                ve6 ve6Var = (ve6) mvcHttpResponsedMessage.getData();
                ue6 ue6Var2 = new ue6();
                ArrayList<jn> arrayList = ve6Var.a;
                ue6Var2.c = arrayList;
                ue6Var2.a = ve6Var.c;
                ue6Var2.b = ve6Var.b;
                if (!ListUtils.isEmpty(arrayList)) {
                    ArrayList<jn> arrayList2 = ue6Var2.c;
                    jn jnVar = (jn) ListUtils.getItem(arrayList2, arrayList2.size() - 1);
                    if (jnVar instanceof ThreadData) {
                        this.f.lastThreadId = jg.g(((ThreadData) jnVar).getId(), 0L);
                    }
                }
                ue6Var = ue6Var2;
            }
        }
        if (ue6Var == null || !n(ue6Var)) {
            this.l = mvcHttpResponsedMessage.getError();
            this.m = mvcHttpResponsedMessage.getErrorString();
            ErrorData errorData = new ErrorData();
            errorData.setError_code(this.l);
            errorData.setError_msg(this.m);
            if (this.l != 0) {
                this.a.onServerError(errorData);
            }
        }
    }

    public void s(int i) {
        FrsCommonTabRequestData frsCommonTabRequestData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048594, this, i) == null) || (frsCommonTabRequestData = this.c) == null) {
            return;
        }
        frsCommonTabRequestData.tabType = i;
    }

    public final ArrayList<jn> t(ArrayList<jn> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, arrayList)) == null) {
            boolean z = this.a.h == 16;
            boolean z2 = this.a.h == 100;
            ArrayList<jn> arrayList2 = new ArrayList<>();
            Iterator<jn> it = arrayList.iterator();
            int i = 0;
            while (it.hasNext()) {
                jn next = it.next();
                if (next instanceof co4) {
                    ((co4) next).setPosition(i);
                    arrayList2.add(next);
                } else if (next instanceof eo4) {
                    ((eo4) next).position = i;
                    arrayList2.add(next);
                } else if (next instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) next;
                    AbsGroupUbsABTest.setCardInfoUbsABTest(threadData);
                    int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                    if (threadData.getType() == ThreadData.TYPE_NORMAL && !threadData.isTop()) {
                        rp4 rp4Var = new rp4();
                        rp4Var.s = threadData;
                        rp4Var.position = i;
                        rp4Var.a = true;
                        rp4Var.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList2.add(rp4Var);
                        rp4 rp4Var2 = new rp4();
                        rp4Var2.s = threadData;
                        rp4Var2.position = i;
                        if (threadData.isBJHNormalThreadType()) {
                            rp4Var2.f = true;
                        } else if (threadData.picCount() == 1) {
                            rp4Var2.d = true;
                            rp4Var2.t = imageWidthAndHeight[0];
                            rp4Var2.u = imageWidthAndHeight[1];
                        } else if (threadData.picCount() >= 2) {
                            rp4Var2.e = true;
                        } else {
                            rp4Var2.b = true;
                        }
                        rp4Var2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(rp4Var2);
                        if (threadData.getPollData() != null) {
                            rp4 rp4Var3 = new rp4();
                            rp4Var3.o = true;
                            rp4Var3.s = threadData;
                            rp4Var3.position = i;
                            rp4Var3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(rp4Var3);
                        }
                        if (threadData.getSmartApp() != null) {
                            rp4 rp4Var4 = new rp4();
                            rp4Var4.l = true;
                            rp4Var4.s = threadData;
                            rp4Var4.position = i;
                            rp4Var4.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(rp4Var4);
                        }
                        if (!ListUtils.isEmpty(threadData.getLinkDataList()) || !ListUtils.isEmpty(threadData.getGoodsDataList())) {
                            rp4 rp4Var5 = new rp4();
                            if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) == 1) {
                                rp4Var5.p = true;
                            } else if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) > 1) {
                                rp4Var5.q = true;
                            }
                            rp4Var5.s = threadData;
                            rp4Var5.position = i;
                            rp4Var5.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(rp4Var5);
                        }
                        if (threadData.getTopAgreePost() != null) {
                            rp4 rp4Var6 = new rp4();
                            rp4Var6.h = true;
                            rp4Var6.s = threadData;
                            rp4Var6.position = i;
                            rp4Var6.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(rp4Var6);
                        }
                        if (!z && threadData.getItem() != null && !threadData.isVoteThreadType()) {
                            rp4 rp4Var7 = new rp4();
                            rp4Var7.n = true;
                            rp4Var7.s = threadData;
                            rp4Var7.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(rp4Var7);
                        }
                        rp4 rp4Var8 = new rp4();
                        rp4Var8.g = true;
                        rp4Var8.s = threadData;
                        rp4Var8.position = i;
                        rp4Var8.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(rp4Var8);
                    } else if ((threadData.getType() == ThreadData.TYPE_VIDEO || threadData.getType() == ThreadData.TYPE_FAKE_VIDEO) && !threadData.isTop()) {
                        rp4 rp4Var9 = new rp4();
                        rp4Var9.s = threadData;
                        rp4Var9.position = i;
                        rp4Var9.a = true;
                        threadData.isJumpToFrsVideoTabPlay = z2;
                        rp4Var9.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList2.add(rp4Var9);
                        rp4 rp4Var10 = new rp4();
                        rp4Var10.s = threadData;
                        rp4Var10.position = i;
                        if (threadData instanceof mo4) {
                            rp4Var10.j = true;
                        } else {
                            rp4Var10.i = true;
                        }
                        rp4Var10.s.isJumpToFrsVideoTabPlay = z2;
                        rp4Var10.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(rp4Var10);
                        if (threadData.getPollData() != null) {
                            rp4 rp4Var11 = new rp4();
                            rp4Var11.o = true;
                            rp4Var11.s = threadData;
                            rp4Var11.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            rp4Var11.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(rp4Var11);
                        }
                        if (threadData.getSmartApp() != null) {
                            rp4 rp4Var12 = new rp4();
                            rp4Var12.l = true;
                            rp4Var12.s = threadData;
                            rp4Var12.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            rp4Var12.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(rp4Var12);
                        }
                        if (threadData.getTopAgreePost() != null) {
                            rp4 rp4Var13 = new rp4();
                            rp4Var13.h = true;
                            rp4Var13.s = threadData;
                            rp4Var13.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            rp4Var13.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(rp4Var13);
                        }
                        if (!z && threadData.getItem() != null && !threadData.isVoteThreadType()) {
                            rp4 rp4Var14 = new rp4();
                            rp4Var14.n = true;
                            rp4Var14.s = threadData;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            rp4Var14.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(rp4Var14);
                        }
                        rp4 rp4Var15 = new rp4();
                        rp4Var15.g = true;
                        rp4Var15.s = threadData;
                        rp4Var15.position = i;
                        threadData.isJumpToFrsVideoTabPlay = z2;
                        rp4Var15.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(rp4Var15);
                    } else if (threadData.getThreadVideoInfo() != null && !threadData.isLiveInterviewLiveType() && threadData.isGodThread()) {
                        rp4 rp4Var16 = new rp4();
                        rp4Var16.s = threadData;
                        rp4Var16.position = i;
                        rp4Var16.a = true;
                        threadData.isJumpToFrsVideoTabPlay = z2;
                        rp4Var16.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList2.add(rp4Var16);
                        rp4 rp4Var17 = new rp4();
                        rp4Var17.s = threadData;
                        rp4Var17.position = i;
                        rp4Var17.k = true;
                        threadData.isJumpToFrsVideoTabPlay = z2;
                        rp4Var17.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(rp4Var17);
                        if (threadData.getPollData() != null) {
                            rp4 rp4Var18 = new rp4();
                            rp4Var18.o = true;
                            rp4Var18.s = threadData;
                            rp4Var18.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            rp4Var18.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(rp4Var18);
                        }
                        if (threadData.getSmartApp() != null) {
                            rp4 rp4Var19 = new rp4();
                            rp4Var19.l = true;
                            rp4Var19.s = threadData;
                            rp4Var19.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            rp4Var19.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(rp4Var19);
                        }
                        if (threadData.getTopAgreePost() != null) {
                            rp4 rp4Var20 = new rp4();
                            rp4Var20.h = true;
                            rp4Var20.s = threadData;
                            rp4Var20.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            rp4Var20.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(rp4Var20);
                        }
                        if (!z && threadData.getItem() != null && !threadData.isVoteThreadType()) {
                            rp4 rp4Var21 = new rp4();
                            rp4Var21.n = true;
                            rp4Var21.s = threadData;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            rp4Var21.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(rp4Var21);
                        }
                        rp4 rp4Var22 = new rp4();
                        rp4Var22.g = true;
                        rp4Var22.s = threadData;
                        rp4Var22.position = i;
                        threadData.isJumpToFrsVideoTabPlay = z2;
                        rp4Var22.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(rp4Var22);
                    } else if (threadData.getType() == ThreadData.TYPE_ARTICLE && threadData.isBJHArticleThreadType()) {
                        threadData.position = i;
                        arrayList2.add(threadData);
                    } else {
                        rp4 rp4Var23 = new rp4();
                        rp4Var23.s = threadData;
                        rp4Var23.position = i;
                        arrayList2.add(rp4Var23);
                    }
                    i++;
                    threadData.setSupportType(BaseCardInfo.SupportType.TOP);
                } else {
                    arrayList2.add(next);
                }
                i++;
            }
            AbsGroupUbsABTest.setCardInfoUbsABTest(arrayList2);
            return arrayList2;
        }
        return (ArrayList) invokeL.objValue;
    }
}

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
/* loaded from: classes5.dex */
public class cg6 implements NetModel.k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsCommonTabFragment a;
    public dg6 b;
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
    public lr6 o;

    public cg6(FrsCommonTabFragment frsCommonTabFragment, int i, int i2, String str, int i3) {
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
            frsDynamicRequestData.scrH = mi.i(TbadkCoreApplication.getInst());
            this.f.scrW = mi.k(TbadkCoreApplication.getInst());
            this.f.scrDip = mi.h(TbadkCoreApplication.getInst());
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
        dg6 dg6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, threadData) == null) || threadData == null || (dg6Var = this.b) == null || dg6Var.c == null) {
            return;
        }
        ArrayList<ro> arrayList = new ArrayList<>();
        arrayList.add(threadData);
        ArrayList<ro> t = t(arrayList);
        if (ListUtils.isEmpty(this.b.c)) {
            this.b.c.addAll(t);
        } else {
            if (this.b.c.size() == 1 && (this.b.c.get(0) instanceof xc6)) {
                this.b.c.remove(0);
            }
            this.b.c.addAll(0, t);
        }
        this.a.W0(this.b);
    }

    public final void b(List<ro> list) {
        JSONObject b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) || pd7.e(list)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (ro roVar : list) {
            if ((roVar instanceof ThreadData) && (b = ub8.b(((ThreadData) roVar).getRawThreadInfo())) != null) {
                arrayList.add(b);
            }
        }
        ub8.f().h(this.n, arrayList);
    }

    public final String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            int b = this.h ? 0 : n98.b(this.b.c);
            String d = this.h ? "" : ub8.f().d(this.n);
            dg6 dg6Var = this.b;
            String e = n98.e(dg6Var == null ? null : dg6Var.c, this.h);
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
            dg6 dg6Var = this.b;
            if (dg6Var == null) {
                return true;
            }
            return dg6Var.a;
        }
        return invokeV.booleanValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.j : invokeV.intValue;
    }

    public dg6 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.b : (dg6) invokeV.objValue;
    }

    public final void g(List<App> list, List<ro> list2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, list, list2) == null) {
            b(list2);
            n98.i(n98.h(list, "FRS_GENERAL_TAB"), list2, 0);
            n98.a(list2, this.j, "FRS_GENERAL_TAB");
        }
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            dg6 dg6Var = this.b;
            return (dg6Var == null || ListUtils.isEmpty(dg6Var.c)) ? false : true;
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
            gr6.a();
        }
    }

    public void l(String str) {
        dg6 dg6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, str) == null) || (dg6Var = this.b) == null || pd7.e(dg6Var.c)) {
            return;
        }
        n98.d(str, this.b.c);
        this.a.W0(this.b);
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.m
    public void m(MvcSocketResponsedMessage mvcSocketResponsedMessage, MvcSocketMessage mvcSocketMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048588, this, mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage) == null) || mvcSocketResponsedMessage == null) {
            return;
        }
        dg6 dg6Var = null;
        if (!mvcSocketResponsedMessage.hasError()) {
            if (mvcSocketResponsedMessage.getData() instanceof dg6) {
                dg6Var = (dg6) mvcSocketResponsedMessage.getData();
            } else if (mvcSocketResponsedMessage.getData() instanceof eg6) {
                eg6 eg6Var = (eg6) mvcSocketResponsedMessage.getData();
                dg6 dg6Var2 = new dg6();
                ArrayList<ro> arrayList = eg6Var.a;
                dg6Var2.c = arrayList;
                dg6Var2.a = eg6Var.c;
                dg6Var2.b = eg6Var.b;
                if (!ListUtils.isEmpty(arrayList)) {
                    ArrayList<ro> arrayList2 = dg6Var2.c;
                    ro roVar = (ro) ListUtils.getItem(arrayList2, arrayList2.size() - 1);
                    if (roVar instanceof ThreadData) {
                        this.f.lastThreadId = kg.g(((ThreadData) roVar).getId(), 0L);
                    }
                }
                dg6Var = dg6Var2;
            }
        }
        if (dg6Var == null || !n(dg6Var)) {
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

    public final boolean n(dg6 dg6Var) {
        InterceptResult invokeL;
        lr6 lr6Var;
        lr6 lr6Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, dg6Var)) == null) {
            if (dg6Var == null) {
                return false;
            }
            boolean z = this.a.h == 100;
            ArrayList arrayList = new ArrayList();
            if (this.h) {
                this.i.clear();
                Iterator<ro> it = dg6Var.c.iterator();
                while (it.hasNext()) {
                    ro next = it.next();
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
                int i = dg6Var.l;
                if (i != -1) {
                    if (i == 1) {
                        g(dg6Var.k, dg6Var.c);
                    } else if (i == 2) {
                        lr6 lr6Var3 = this.o;
                        if (lr6Var3 != null) {
                            lr6Var3.b(dg6Var.c, this.h, this.a.y());
                        }
                    } else if (i != 3) {
                        if (lr6.d()) {
                            lr6 lr6Var4 = this.o;
                            if (lr6Var4 != null) {
                                lr6Var4.b(dg6Var.c, this.h, this.a.y());
                            }
                        } else {
                            g(dg6Var.k, dg6Var.c);
                        }
                    } else if (!ListUtils.isEmpty(dg6Var.m)) {
                        int intValue = dg6Var.m.get(0).ad_type.intValue();
                        if (intValue == 1) {
                            g(dg6Var.k, dg6Var.c);
                        } else if (intValue == 2 && (lr6Var2 = this.o) != null) {
                            lr6Var2.g(dg6Var.c, dg6Var.m, this.h, this.a.y());
                        }
                    }
                }
                this.b = dg6Var;
                dg6Var.c = t(dg6Var.c);
            } else {
                dg6 dg6Var2 = this.b;
                dg6Var2.a = dg6Var.a;
                dg6Var2.b.putAll(dg6Var.b);
                ArrayList<ro> arrayList2 = new ArrayList<>();
                Iterator<ro> it2 = dg6Var.c.iterator();
                while (it2.hasNext()) {
                    ro next2 = it2.next();
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
                int i2 = dg6Var.l;
                if (i2 == 1) {
                    g(dg6Var.k, dg6Var.c);
                } else if (i2 == 2) {
                    lr6 lr6Var5 = this.o;
                    if (lr6Var5 != null) {
                        lr6Var5.b(dg6Var.c, this.h, this.a.y());
                    }
                } else if (i2 != 3) {
                    if (lr6.d()) {
                        lr6 lr6Var6 = this.o;
                        if (lr6Var6 != null) {
                            lr6Var6.b(dg6Var.c, this.h, this.a.y());
                        }
                    } else {
                        g(dg6Var.k, dg6Var.c);
                    }
                } else if (!ListUtils.isEmpty(dg6Var.m)) {
                    int intValue2 = dg6Var.m.get(0).ad_type.intValue();
                    if (intValue2 == 1) {
                        g(dg6Var.k, dg6Var.c);
                    } else if (intValue2 == 2 && (lr6Var = this.o) != null) {
                        lr6Var.g(dg6Var.c, dg6Var.m, this.h, this.a.y());
                    }
                }
                this.b.c.addAll(t(arrayList2));
            }
            this.a.W0(this.b);
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
            gr6.a();
        }
    }

    public void p(lr6 lr6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, lr6Var) == null) {
            this.o = lr6Var;
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
        dg6 dg6Var = null;
        if (!mvcHttpResponsedMessage.hasError()) {
            if (mvcHttpResponsedMessage.getData() instanceof dg6) {
                dg6Var = (dg6) mvcHttpResponsedMessage.getData();
            } else if (mvcHttpResponsedMessage.getData() instanceof eg6) {
                eg6 eg6Var = (eg6) mvcHttpResponsedMessage.getData();
                dg6 dg6Var2 = new dg6();
                ArrayList<ro> arrayList = eg6Var.a;
                dg6Var2.c = arrayList;
                dg6Var2.a = eg6Var.c;
                dg6Var2.b = eg6Var.b;
                if (!ListUtils.isEmpty(arrayList)) {
                    ArrayList<ro> arrayList2 = dg6Var2.c;
                    ro roVar = (ro) ListUtils.getItem(arrayList2, arrayList2.size() - 1);
                    if (roVar instanceof ThreadData) {
                        this.f.lastThreadId = kg.g(((ThreadData) roVar).getId(), 0L);
                    }
                }
                dg6Var = dg6Var2;
            }
        }
        if (dg6Var == null || !n(dg6Var)) {
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

    public final ArrayList<ro> t(ArrayList<ro> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, arrayList)) == null) {
            boolean z = this.a.h == 16;
            boolean z2 = this.a.h == 100;
            ArrayList<ro> arrayList2 = new ArrayList<>();
            Iterator<ro> it = arrayList.iterator();
            int i = 0;
            while (it.hasNext()) {
                ro next = it.next();
                if (next instanceof np4) {
                    ((np4) next).setPosition(i);
                    arrayList2.add(next);
                } else if (next instanceof pp4) {
                    ((pp4) next).position = i;
                    arrayList2.add(next);
                } else if (next instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) next;
                    AbsGroupUbsABTest.setCardInfoUbsABTest(threadData);
                    int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                    if (threadData.getType() == ThreadData.TYPE_NORMAL && !threadData.isTop()) {
                        br4 br4Var = new br4();
                        br4Var.s = threadData;
                        br4Var.position = i;
                        br4Var.a = true;
                        br4Var.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList2.add(br4Var);
                        br4 br4Var2 = new br4();
                        br4Var2.s = threadData;
                        br4Var2.position = i;
                        if (threadData.isBJHNormalThreadType()) {
                            br4Var2.f = true;
                        } else if (threadData.picCount() == 1) {
                            br4Var2.d = true;
                            br4Var2.t = imageWidthAndHeight[0];
                            br4Var2.u = imageWidthAndHeight[1];
                        } else if (threadData.picCount() >= 2) {
                            br4Var2.e = true;
                        } else {
                            br4Var2.b = true;
                        }
                        br4Var2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(br4Var2);
                        if (threadData.getPollData() != null) {
                            br4 br4Var3 = new br4();
                            br4Var3.o = true;
                            br4Var3.s = threadData;
                            br4Var3.position = i;
                            br4Var3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(br4Var3);
                        }
                        if (threadData.getSmartApp() != null) {
                            br4 br4Var4 = new br4();
                            br4Var4.l = true;
                            br4Var4.s = threadData;
                            br4Var4.position = i;
                            br4Var4.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(br4Var4);
                        }
                        if (!ListUtils.isEmpty(threadData.getLinkDataList()) || !ListUtils.isEmpty(threadData.getGoodsDataList())) {
                            br4 br4Var5 = new br4();
                            if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) == 1) {
                                br4Var5.p = true;
                            } else if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) > 1) {
                                br4Var5.q = true;
                            }
                            br4Var5.s = threadData;
                            br4Var5.position = i;
                            br4Var5.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(br4Var5);
                        }
                        if (threadData.getTopAgreePost() != null) {
                            br4 br4Var6 = new br4();
                            br4Var6.h = true;
                            br4Var6.s = threadData;
                            br4Var6.position = i;
                            br4Var6.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(br4Var6);
                        }
                        if (!z && threadData.getItem() != null && !threadData.isVoteThreadType()) {
                            br4 br4Var7 = new br4();
                            br4Var7.n = true;
                            br4Var7.s = threadData;
                            br4Var7.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(br4Var7);
                        }
                        br4 br4Var8 = new br4();
                        br4Var8.g = true;
                        br4Var8.s = threadData;
                        br4Var8.position = i;
                        br4Var8.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(br4Var8);
                    } else if ((threadData.getType() == ThreadData.TYPE_VIDEO || threadData.getType() == ThreadData.TYPE_FAKE_VIDEO) && !threadData.isTop()) {
                        br4 br4Var9 = new br4();
                        br4Var9.s = threadData;
                        br4Var9.position = i;
                        br4Var9.a = true;
                        threadData.isJumpToFrsVideoTabPlay = z2;
                        br4Var9.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList2.add(br4Var9);
                        br4 br4Var10 = new br4();
                        br4Var10.s = threadData;
                        br4Var10.position = i;
                        if (threadData instanceof xp4) {
                            br4Var10.j = true;
                        } else {
                            br4Var10.i = true;
                        }
                        br4Var10.s.isJumpToFrsVideoTabPlay = z2;
                        br4Var10.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(br4Var10);
                        if (threadData.getPollData() != null) {
                            br4 br4Var11 = new br4();
                            br4Var11.o = true;
                            br4Var11.s = threadData;
                            br4Var11.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            br4Var11.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(br4Var11);
                        }
                        if (threadData.getSmartApp() != null) {
                            br4 br4Var12 = new br4();
                            br4Var12.l = true;
                            br4Var12.s = threadData;
                            br4Var12.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            br4Var12.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(br4Var12);
                        }
                        if (threadData.getTopAgreePost() != null) {
                            br4 br4Var13 = new br4();
                            br4Var13.h = true;
                            br4Var13.s = threadData;
                            br4Var13.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            br4Var13.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(br4Var13);
                        }
                        if (!z && threadData.getItem() != null && !threadData.isVoteThreadType()) {
                            br4 br4Var14 = new br4();
                            br4Var14.n = true;
                            br4Var14.s = threadData;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            br4Var14.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(br4Var14);
                        }
                        br4 br4Var15 = new br4();
                        br4Var15.g = true;
                        br4Var15.s = threadData;
                        br4Var15.position = i;
                        threadData.isJumpToFrsVideoTabPlay = z2;
                        br4Var15.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(br4Var15);
                    } else if (threadData.getThreadVideoInfo() != null && !threadData.isLiveInterviewLiveType() && threadData.isGodThread()) {
                        br4 br4Var16 = new br4();
                        br4Var16.s = threadData;
                        br4Var16.position = i;
                        br4Var16.a = true;
                        threadData.isJumpToFrsVideoTabPlay = z2;
                        br4Var16.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList2.add(br4Var16);
                        br4 br4Var17 = new br4();
                        br4Var17.s = threadData;
                        br4Var17.position = i;
                        br4Var17.k = true;
                        threadData.isJumpToFrsVideoTabPlay = z2;
                        br4Var17.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(br4Var17);
                        if (threadData.getPollData() != null) {
                            br4 br4Var18 = new br4();
                            br4Var18.o = true;
                            br4Var18.s = threadData;
                            br4Var18.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            br4Var18.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(br4Var18);
                        }
                        if (threadData.getSmartApp() != null) {
                            br4 br4Var19 = new br4();
                            br4Var19.l = true;
                            br4Var19.s = threadData;
                            br4Var19.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            br4Var19.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(br4Var19);
                        }
                        if (threadData.getTopAgreePost() != null) {
                            br4 br4Var20 = new br4();
                            br4Var20.h = true;
                            br4Var20.s = threadData;
                            br4Var20.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            br4Var20.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(br4Var20);
                        }
                        if (!z && threadData.getItem() != null && !threadData.isVoteThreadType()) {
                            br4 br4Var21 = new br4();
                            br4Var21.n = true;
                            br4Var21.s = threadData;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            br4Var21.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(br4Var21);
                        }
                        br4 br4Var22 = new br4();
                        br4Var22.g = true;
                        br4Var22.s = threadData;
                        br4Var22.position = i;
                        threadData.isJumpToFrsVideoTabPlay = z2;
                        br4Var22.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(br4Var22);
                    } else if (threadData.getType() == ThreadData.TYPE_ARTICLE && threadData.isBJHArticleThreadType()) {
                        threadData.position = i;
                        arrayList2.add(threadData);
                    } else {
                        br4 br4Var23 = new br4();
                        br4Var23.s = threadData;
                        br4Var23.position = i;
                        arrayList2.add(br4Var23);
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

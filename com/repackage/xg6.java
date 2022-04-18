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
public class xg6 implements NetModel.k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsCommonTabFragment a;
    public yg6 b;
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
    public ls6 o;

    public xg6(FrsCommonTabFragment frsCommonTabFragment, int i, int i2, String str, int i3) {
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
            frsDynamicRequestData.scrH = oi.i(TbadkCoreApplication.getInst());
            this.f.scrW = oi.k(TbadkCoreApplication.getInst());
            this.f.scrDip = oi.h(TbadkCoreApplication.getInst());
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
        yg6 yg6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, threadData) == null) || threadData == null || (yg6Var = this.b) == null || yg6Var.c == null) {
            return;
        }
        ArrayList<uo> arrayList = new ArrayList<>();
        arrayList.add(threadData);
        ArrayList<uo> t = t(arrayList);
        if (ListUtils.isEmpty(this.b.c)) {
            this.b.c.addAll(t);
        } else {
            if (this.b.c.size() == 1 && (this.b.c.get(0) instanceof sd6)) {
                this.b.c.remove(0);
            }
            this.b.c.addAll(0, t);
        }
        this.a.V0(this.b);
    }

    public final void b(List<uo> list) {
        JSONObject b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) || jd7.e(list)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (uo uoVar : list) {
            if ((uoVar instanceof ThreadData) && (b = yc8.b(((ThreadData) uoVar).getRawThreadInfo())) != null) {
                arrayList.add(b);
            }
        }
        yc8.f().h(this.n, arrayList);
    }

    public final String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            int b = this.h ? 0 : n98.b(this.b.c);
            String d = this.h ? "" : yc8.f().d(this.n);
            yg6 yg6Var = this.b;
            String e = n98.e(yg6Var == null ? null : yg6Var.c, this.h);
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
            yg6 yg6Var = this.b;
            if (yg6Var == null) {
                return true;
            }
            return yg6Var.a;
        }
        return invokeV.booleanValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.j : invokeV.intValue;
    }

    public yg6 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.b : (yg6) invokeV.objValue;
    }

    public final void g(List<App> list, List<uo> list2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, list, list2) == null) {
            b(list2);
            n98.k(n98.h(list, "FRS_GENERAL_TAB"), list2, 0);
            n98.a(list2, this.j, "FRS_GENERAL_TAB");
        }
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            yg6 yg6Var = this.b;
            return (yg6Var == null || ListUtils.isEmpty(yg6Var.c)) ? false : true;
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
            gs6.a();
        }
    }

    public void l(String str) {
        yg6 yg6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, str) == null) || (yg6Var = this.b) == null || jd7.e(yg6Var.c)) {
            return;
        }
        n98.d(str, this.b.c);
        this.a.V0(this.b);
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.m
    public void m(MvcSocketResponsedMessage mvcSocketResponsedMessage, MvcSocketMessage mvcSocketMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048588, this, mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage) == null) || mvcSocketResponsedMessage == null) {
            return;
        }
        yg6 yg6Var = null;
        if (!mvcSocketResponsedMessage.hasError()) {
            if (mvcSocketResponsedMessage.getData() instanceof yg6) {
                yg6Var = (yg6) mvcSocketResponsedMessage.getData();
            } else if (mvcSocketResponsedMessage.getData() instanceof zg6) {
                zg6 zg6Var = (zg6) mvcSocketResponsedMessage.getData();
                yg6 yg6Var2 = new yg6();
                ArrayList<uo> arrayList = zg6Var.a;
                yg6Var2.c = arrayList;
                yg6Var2.a = zg6Var.c;
                yg6Var2.b = zg6Var.b;
                if (!ListUtils.isEmpty(arrayList)) {
                    ArrayList<uo> arrayList2 = yg6Var2.c;
                    uo uoVar = (uo) ListUtils.getItem(arrayList2, arrayList2.size() - 1);
                    if (uoVar instanceof ThreadData) {
                        this.f.lastThreadId = mg.g(((ThreadData) uoVar).getId(), 0L);
                    }
                }
                yg6Var = yg6Var2;
            }
        }
        if (yg6Var == null || !n(yg6Var)) {
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

    public final boolean n(yg6 yg6Var) {
        InterceptResult invokeL;
        ls6 ls6Var;
        ls6 ls6Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, yg6Var)) == null) {
            if (yg6Var == null) {
                return false;
            }
            boolean z = this.a.h == 100;
            ArrayList arrayList = new ArrayList();
            if (this.h) {
                this.i.clear();
                Iterator<uo> it = yg6Var.c.iterator();
                while (it.hasNext()) {
                    uo next = it.next();
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
                int i = yg6Var.l;
                if (i != -1) {
                    if (i == 1) {
                        g(yg6Var.k, yg6Var.c);
                    } else if (i == 2) {
                        ls6 ls6Var3 = this.o;
                        if (ls6Var3 != null) {
                            ls6Var3.b(yg6Var.c, this.h, this.a.z());
                        }
                    } else if (i != 3) {
                        if (ls6.d()) {
                            ls6 ls6Var4 = this.o;
                            if (ls6Var4 != null) {
                                ls6Var4.b(yg6Var.c, this.h, this.a.z());
                            }
                        } else {
                            g(yg6Var.k, yg6Var.c);
                        }
                    } else if (!ListUtils.isEmpty(yg6Var.m)) {
                        int intValue = yg6Var.m.get(0).ad_type.intValue();
                        if (intValue == 1) {
                            g(yg6Var.k, yg6Var.c);
                        } else if (intValue == 2 && (ls6Var2 = this.o) != null) {
                            ls6Var2.g(yg6Var.c, yg6Var.m, this.h, this.a.z());
                        }
                    }
                }
                this.b = yg6Var;
                yg6Var.c = t(yg6Var.c);
            } else {
                yg6 yg6Var2 = this.b;
                yg6Var2.a = yg6Var.a;
                yg6Var2.b.putAll(yg6Var.b);
                ArrayList<uo> arrayList2 = new ArrayList<>();
                Iterator<uo> it2 = yg6Var.c.iterator();
                while (it2.hasNext()) {
                    uo next2 = it2.next();
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
                int i2 = yg6Var.l;
                if (i2 == 1) {
                    g(yg6Var.k, yg6Var.c);
                } else if (i2 == 2) {
                    ls6 ls6Var5 = this.o;
                    if (ls6Var5 != null) {
                        ls6Var5.b(yg6Var.c, this.h, this.a.z());
                    }
                } else if (i2 != 3) {
                    if (ls6.d()) {
                        ls6 ls6Var6 = this.o;
                        if (ls6Var6 != null) {
                            ls6Var6.b(yg6Var.c, this.h, this.a.z());
                        }
                    } else {
                        g(yg6Var.k, yg6Var.c);
                    }
                } else if (!ListUtils.isEmpty(yg6Var.m)) {
                    int intValue2 = yg6Var.m.get(0).ad_type.intValue();
                    if (intValue2 == 1) {
                        g(yg6Var.k, yg6Var.c);
                    } else if (intValue2 == 2 && (ls6Var = this.o) != null) {
                        ls6Var.g(yg6Var.c, yg6Var.m, this.h, this.a.z());
                    }
                }
                this.b.c.addAll(t(arrayList2));
            }
            this.a.V0(this.b);
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
            gs6.a();
        }
    }

    public void p(ls6 ls6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, ls6Var) == null) {
            this.o = ls6Var;
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
        yg6 yg6Var = null;
        if (!mvcHttpResponsedMessage.hasError()) {
            if (mvcHttpResponsedMessage.getData() instanceof yg6) {
                yg6Var = (yg6) mvcHttpResponsedMessage.getData();
            } else if (mvcHttpResponsedMessage.getData() instanceof zg6) {
                zg6 zg6Var = (zg6) mvcHttpResponsedMessage.getData();
                yg6 yg6Var2 = new yg6();
                ArrayList<uo> arrayList = zg6Var.a;
                yg6Var2.c = arrayList;
                yg6Var2.a = zg6Var.c;
                yg6Var2.b = zg6Var.b;
                if (!ListUtils.isEmpty(arrayList)) {
                    ArrayList<uo> arrayList2 = yg6Var2.c;
                    uo uoVar = (uo) ListUtils.getItem(arrayList2, arrayList2.size() - 1);
                    if (uoVar instanceof ThreadData) {
                        this.f.lastThreadId = mg.g(((ThreadData) uoVar).getId(), 0L);
                    }
                }
                yg6Var = yg6Var2;
            }
        }
        if (yg6Var == null || !n(yg6Var)) {
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

    public final ArrayList<uo> t(ArrayList<uo> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, arrayList)) == null) {
            boolean z = this.a.h == 16;
            boolean z2 = this.a.h == 100;
            ArrayList<uo> arrayList2 = new ArrayList<>();
            Iterator<uo> it = arrayList.iterator();
            int i = 0;
            while (it.hasNext()) {
                uo next = it.next();
                if (next instanceof dp4) {
                    ((dp4) next).setPosition(i);
                    arrayList2.add(next);
                } else if (next instanceof ep4) {
                    ((ep4) next).position = i;
                    arrayList2.add(next);
                } else if (next instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) next;
                    AbsGroupUbsABTest.setCardInfoUbsABTest(threadData);
                    int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                    if (threadData.getType() == ThreadData.TYPE_NORMAL && !threadData.isTop()) {
                        qq4 qq4Var = new qq4();
                        qq4Var.s = threadData;
                        qq4Var.position = i;
                        qq4Var.a = true;
                        qq4Var.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList2.add(qq4Var);
                        qq4 qq4Var2 = new qq4();
                        qq4Var2.s = threadData;
                        qq4Var2.position = i;
                        if (threadData.isBJHNormalThreadType()) {
                            qq4Var2.f = true;
                        } else if (threadData.picCount() == 1) {
                            qq4Var2.d = true;
                            qq4Var2.t = imageWidthAndHeight[0];
                            qq4Var2.u = imageWidthAndHeight[1];
                        } else if (threadData.picCount() >= 2) {
                            qq4Var2.e = true;
                        } else {
                            qq4Var2.b = true;
                        }
                        qq4Var2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(qq4Var2);
                        if (threadData.getPollData() != null) {
                            qq4 qq4Var3 = new qq4();
                            qq4Var3.o = true;
                            qq4Var3.s = threadData;
                            qq4Var3.position = i;
                            qq4Var3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(qq4Var3);
                        }
                        if (threadData.getSmartApp() != null) {
                            qq4 qq4Var4 = new qq4();
                            qq4Var4.l = true;
                            qq4Var4.s = threadData;
                            qq4Var4.position = i;
                            qq4Var4.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(qq4Var4);
                        }
                        if (!ListUtils.isEmpty(threadData.getLinkDataList()) || !ListUtils.isEmpty(threadData.getGoodsDataList())) {
                            qq4 qq4Var5 = new qq4();
                            if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) == 1) {
                                qq4Var5.p = true;
                            } else if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) > 1) {
                                qq4Var5.q = true;
                            }
                            qq4Var5.s = threadData;
                            qq4Var5.position = i;
                            qq4Var5.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(qq4Var5);
                        }
                        if (threadData.getTopAgreePost() != null) {
                            qq4 qq4Var6 = new qq4();
                            qq4Var6.h = true;
                            qq4Var6.s = threadData;
                            qq4Var6.position = i;
                            qq4Var6.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(qq4Var6);
                        }
                        if (!z && threadData.getItem() != null && !threadData.isVoteThreadType()) {
                            qq4 qq4Var7 = new qq4();
                            qq4Var7.n = true;
                            qq4Var7.s = threadData;
                            qq4Var7.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(qq4Var7);
                        }
                        qq4 qq4Var8 = new qq4();
                        qq4Var8.g = true;
                        qq4Var8.s = threadData;
                        qq4Var8.position = i;
                        qq4Var8.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(qq4Var8);
                    } else if ((threadData.getType() == ThreadData.TYPE_VIDEO || threadData.getType() == ThreadData.TYPE_FAKE_VIDEO) && !threadData.isTop()) {
                        qq4 qq4Var9 = new qq4();
                        qq4Var9.s = threadData;
                        qq4Var9.position = i;
                        qq4Var9.a = true;
                        threadData.isJumpToFrsVideoTabPlay = z2;
                        qq4Var9.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList2.add(qq4Var9);
                        qq4 qq4Var10 = new qq4();
                        qq4Var10.s = threadData;
                        qq4Var10.position = i;
                        if (threadData instanceof mp4) {
                            qq4Var10.j = true;
                        } else {
                            qq4Var10.i = true;
                        }
                        qq4Var10.s.isJumpToFrsVideoTabPlay = z2;
                        qq4Var10.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(qq4Var10);
                        if (threadData.getPollData() != null) {
                            qq4 qq4Var11 = new qq4();
                            qq4Var11.o = true;
                            qq4Var11.s = threadData;
                            qq4Var11.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            qq4Var11.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(qq4Var11);
                        }
                        if (threadData.getSmartApp() != null) {
                            qq4 qq4Var12 = new qq4();
                            qq4Var12.l = true;
                            qq4Var12.s = threadData;
                            qq4Var12.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            qq4Var12.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(qq4Var12);
                        }
                        if (threadData.getTopAgreePost() != null) {
                            qq4 qq4Var13 = new qq4();
                            qq4Var13.h = true;
                            qq4Var13.s = threadData;
                            qq4Var13.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            qq4Var13.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(qq4Var13);
                        }
                        if (!z && threadData.getItem() != null && !threadData.isVoteThreadType()) {
                            qq4 qq4Var14 = new qq4();
                            qq4Var14.n = true;
                            qq4Var14.s = threadData;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            qq4Var14.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(qq4Var14);
                        }
                        qq4 qq4Var15 = new qq4();
                        qq4Var15.g = true;
                        qq4Var15.s = threadData;
                        qq4Var15.position = i;
                        threadData.isJumpToFrsVideoTabPlay = z2;
                        qq4Var15.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(qq4Var15);
                    } else if (threadData.getThreadVideoInfo() != null && !threadData.isLiveInterviewLiveType() && threadData.isGodThread()) {
                        qq4 qq4Var16 = new qq4();
                        qq4Var16.s = threadData;
                        qq4Var16.position = i;
                        qq4Var16.a = true;
                        threadData.isJumpToFrsVideoTabPlay = z2;
                        qq4Var16.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList2.add(qq4Var16);
                        qq4 qq4Var17 = new qq4();
                        qq4Var17.s = threadData;
                        qq4Var17.position = i;
                        qq4Var17.k = true;
                        threadData.isJumpToFrsVideoTabPlay = z2;
                        qq4Var17.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(qq4Var17);
                        if (threadData.getPollData() != null) {
                            qq4 qq4Var18 = new qq4();
                            qq4Var18.o = true;
                            qq4Var18.s = threadData;
                            qq4Var18.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            qq4Var18.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(qq4Var18);
                        }
                        if (threadData.getSmartApp() != null) {
                            qq4 qq4Var19 = new qq4();
                            qq4Var19.l = true;
                            qq4Var19.s = threadData;
                            qq4Var19.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            qq4Var19.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(qq4Var19);
                        }
                        if (threadData.getTopAgreePost() != null) {
                            qq4 qq4Var20 = new qq4();
                            qq4Var20.h = true;
                            qq4Var20.s = threadData;
                            qq4Var20.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            qq4Var20.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(qq4Var20);
                        }
                        if (!z && threadData.getItem() != null && !threadData.isVoteThreadType()) {
                            qq4 qq4Var21 = new qq4();
                            qq4Var21.n = true;
                            qq4Var21.s = threadData;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            qq4Var21.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(qq4Var21);
                        }
                        qq4 qq4Var22 = new qq4();
                        qq4Var22.g = true;
                        qq4Var22.s = threadData;
                        qq4Var22.position = i;
                        threadData.isJumpToFrsVideoTabPlay = z2;
                        qq4Var22.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(qq4Var22);
                    } else if (threadData.getType() == ThreadData.TYPE_ARTICLE && threadData.isBJHArticleThreadType()) {
                        threadData.position = i;
                        arrayList2.add(threadData);
                    } else {
                        qq4 qq4Var23 = new qq4();
                        qq4Var23.s = threadData;
                        qq4Var23.position = i;
                        arrayList2.add(qq4Var23);
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

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
/* loaded from: classes6.dex */
public class ii6 implements NetModel.k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsCommonTabFragment a;
    public ji6 b;
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
    public zs6 o;

    public ii6(FrsCommonTabFragment frsCommonTabFragment, int i, int i2, String str, int i3) {
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
            frsDynamicRequestData.scrH = qi.i(TbadkCoreApplication.getInst());
            this.f.scrW = qi.k(TbadkCoreApplication.getInst());
            this.f.scrDip = qi.h(TbadkCoreApplication.getInst());
            FrsDynamicModel frsDynamicModel = new FrsDynamicModel(frsCommonTabFragment.getPageContext(), this.f);
            this.g = frsDynamicModel;
            frsDynamicModel.b0(this);
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
        frsCommonTabNetModel.b0(this);
        this.d.setUniqueId(frsCommonTabFragment.getUniqueId());
    }

    public void a(ThreadData threadData) {
        ji6 ji6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, threadData) == null) || threadData == null || (ji6Var = this.b) == null || ji6Var.c == null) {
            return;
        }
        ArrayList<on> arrayList = new ArrayList<>();
        arrayList.add(threadData);
        ArrayList<on> t = t(arrayList);
        if (ListUtils.isEmpty(this.b.c)) {
            this.b.c.addAll(t);
        } else {
            if (this.b.c.size() == 1 && (this.b.c.get(0) instanceof cf6)) {
                this.b.c.remove(0);
            }
            this.b.c.addAll(0, t);
        }
        this.a.M1(this.b);
    }

    public final void b(List<on> list) {
        JSONObject b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) || bf7.e(list)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (on onVar : list) {
            if ((onVar instanceof ThreadData) && (b = ld8.b(((ThreadData) onVar).getRawThreadInfo())) != null) {
                arrayList.add(b);
            }
        }
        ld8.f().h(this.n, arrayList);
    }

    public final String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            int b = this.h ? 0 : db8.b(this.b.c);
            String d = this.h ? "" : ld8.f().d(this.n);
            ji6 ji6Var = this.b;
            String e = db8.e(ji6Var == null ? null : ji6Var.c, this.h);
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
            ji6 ji6Var = this.b;
            if (ji6Var == null) {
                return true;
            }
            return ji6Var.a;
        }
        return invokeV.booleanValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.j : invokeV.intValue;
    }

    public ji6 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.b : (ji6) invokeV.objValue;
    }

    public final void g(List<App> list, List<on> list2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, list, list2) == null) {
            b(list2);
            db8.i(db8.h(list, "FRS_GENERAL_TAB"), list2, 0);
            db8.a(list2, this.j, "FRS_GENERAL_TAB");
        }
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            ji6 ji6Var = this.b;
            return (ji6Var == null || ListUtils.isEmpty(ji6Var.c)) ? false : true;
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
                if (this.d.T()) {
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
            } else if (this.g.T()) {
                return;
            } else {
                if (TbImageHelper.getInstance().isShowBigImage()) {
                    this.f.qType = 2;
                } else {
                    this.f.qType = 1;
                }
                this.g.loadData();
            }
            us6.a();
        }
    }

    public void l(String str) {
        ji6 ji6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, str) == null) || (ji6Var = this.b) == null || bf7.e(ji6Var.c)) {
            return;
        }
        db8.d(str, this.b.c);
        this.a.M1(this.b);
    }

    public final boolean m(ji6 ji6Var) {
        InterceptResult invokeL;
        zs6 zs6Var;
        zs6 zs6Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, ji6Var)) == null) {
            if (ji6Var == null) {
                return false;
            }
            boolean z = this.a.h == 100;
            ArrayList arrayList = new ArrayList();
            if (this.h) {
                this.i.clear();
                Iterator<on> it = ji6Var.c.iterator();
                while (it.hasNext()) {
                    on next = it.next();
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
                int i = ji6Var.l;
                if (i != -1) {
                    if (i == 1) {
                        g(ji6Var.k, ji6Var.c);
                    } else if (i == 2) {
                        zs6 zs6Var3 = this.o;
                        if (zs6Var3 != null) {
                            zs6Var3.b(ji6Var.c, this.h, this.a.U());
                        }
                    } else if (i != 3) {
                        if (zs6.d()) {
                            zs6 zs6Var4 = this.o;
                            if (zs6Var4 != null) {
                                zs6Var4.b(ji6Var.c, this.h, this.a.U());
                            }
                        } else {
                            g(ji6Var.k, ji6Var.c);
                        }
                    } else if (!ListUtils.isEmpty(ji6Var.m)) {
                        int intValue = ji6Var.m.get(0).ad_type.intValue();
                        if (intValue == 1) {
                            g(ji6Var.k, ji6Var.c);
                        } else if (intValue == 2 && (zs6Var2 = this.o) != null) {
                            zs6Var2.g(ji6Var.c, ji6Var.m, this.h, this.a.U());
                        }
                    }
                }
                this.b = ji6Var;
                ji6Var.c = t(ji6Var.c);
            } else {
                ji6 ji6Var2 = this.b;
                ji6Var2.a = ji6Var.a;
                ji6Var2.b.putAll(ji6Var.b);
                ArrayList<on> arrayList2 = new ArrayList<>();
                Iterator<on> it2 = ji6Var.c.iterator();
                while (it2.hasNext()) {
                    on next2 = it2.next();
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
                int i2 = ji6Var.l;
                if (i2 == 1) {
                    g(ji6Var.k, ji6Var.c);
                } else if (i2 == 2) {
                    zs6 zs6Var5 = this.o;
                    if (zs6Var5 != null) {
                        zs6Var5.b(ji6Var.c, this.h, this.a.U());
                    }
                } else if (i2 != 3) {
                    if (zs6.d()) {
                        zs6 zs6Var6 = this.o;
                        if (zs6Var6 != null) {
                            zs6Var6.b(ji6Var.c, this.h, this.a.U());
                        }
                    } else {
                        g(ji6Var.k, ji6Var.c);
                    }
                } else if (!ListUtils.isEmpty(ji6Var.m)) {
                    int intValue2 = ji6Var.m.get(0).ad_type.intValue();
                    if (intValue2 == 1) {
                        g(ji6Var.k, ji6Var.c);
                    } else if (intValue2 == 2 && (zs6Var = this.o) != null) {
                        zs6Var.g(ji6Var.c, ji6Var.m, this.h, this.a.U());
                    }
                }
                this.b.c.addAll(t(arrayList2));
            }
            this.a.M1(this.b);
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.m
    public void n(MvcSocketResponsedMessage mvcSocketResponsedMessage, MvcSocketMessage mvcSocketMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048589, this, mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage) == null) || mvcSocketResponsedMessage == null) {
            return;
        }
        ji6 ji6Var = null;
        if (!mvcSocketResponsedMessage.hasError()) {
            if (mvcSocketResponsedMessage.getData() instanceof ji6) {
                ji6Var = (ji6) mvcSocketResponsedMessage.getData();
            } else if (mvcSocketResponsedMessage.getData() instanceof ki6) {
                ki6 ki6Var = (ki6) mvcSocketResponsedMessage.getData();
                ji6 ji6Var2 = new ji6();
                ArrayList<on> arrayList = ki6Var.a;
                ji6Var2.c = arrayList;
                ji6Var2.a = ki6Var.c;
                ji6Var2.b = ki6Var.b;
                if (!ListUtils.isEmpty(arrayList)) {
                    ArrayList<on> arrayList2 = ji6Var2.c;
                    on onVar = (on) ListUtils.getItem(arrayList2, arrayList2.size() - 1);
                    if (onVar instanceof ThreadData) {
                        this.f.lastThreadId = og.g(((ThreadData) onVar).getId(), 0L);
                    }
                }
                ji6Var = ji6Var2;
            }
        }
        if (ji6Var == null || !m(ji6Var)) {
            this.l = mvcSocketResponsedMessage.getError();
            this.m = mvcSocketResponsedMessage.getErrorString();
            ErrorData errorData = new ErrorData();
            errorData.setError_code(this.l);
            errorData.setError_msg(this.m);
            if (this.l != 0) {
                this.a.f(errorData);
            }
        }
    }

    public void o(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.h = true;
            if (!this.e) {
                if (this.d.T()) {
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
            } else if (this.g.T()) {
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
            us6.a();
        }
    }

    public void p(zs6 zs6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, zs6Var) == null) {
            this.o = zs6Var;
        }
    }

    public void q(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048592, this, j) == null) {
            this.k = j;
        }
    }

    public void r(int i) {
        FrsCommonTabRequestData frsCommonTabRequestData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048593, this, i) == null) || (frsCommonTabRequestData = this.c) == null) {
            return;
        }
        frsCommonTabRequestData.tabType = i;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.l
    public void s(MvcHttpResponsedMessage mvcHttpResponsedMessage, MvcHttpMessage mvcHttpMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048594, this, mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage) == null) || mvcHttpResponsedMessage == null) {
            return;
        }
        ji6 ji6Var = null;
        if (!mvcHttpResponsedMessage.hasError()) {
            if (mvcHttpResponsedMessage.getData() instanceof ji6) {
                ji6Var = (ji6) mvcHttpResponsedMessage.getData();
            } else if (mvcHttpResponsedMessage.getData() instanceof ki6) {
                ki6 ki6Var = (ki6) mvcHttpResponsedMessage.getData();
                ji6 ji6Var2 = new ji6();
                ArrayList<on> arrayList = ki6Var.a;
                ji6Var2.c = arrayList;
                ji6Var2.a = ki6Var.c;
                ji6Var2.b = ki6Var.b;
                if (!ListUtils.isEmpty(arrayList)) {
                    ArrayList<on> arrayList2 = ji6Var2.c;
                    on onVar = (on) ListUtils.getItem(arrayList2, arrayList2.size() - 1);
                    if (onVar instanceof ThreadData) {
                        this.f.lastThreadId = og.g(((ThreadData) onVar).getId(), 0L);
                    }
                }
                ji6Var = ji6Var2;
            }
        }
        if (ji6Var == null || !m(ji6Var)) {
            this.l = mvcHttpResponsedMessage.getError();
            this.m = mvcHttpResponsedMessage.getErrorString();
            ErrorData errorData = new ErrorData();
            errorData.setError_code(this.l);
            errorData.setError_msg(this.m);
            if (this.l != 0) {
                this.a.f(errorData);
            }
        }
    }

    public final ArrayList<on> t(ArrayList<on> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, arrayList)) == null) {
            boolean z = this.a.h == 16;
            boolean z2 = this.a.h == 100;
            ArrayList<on> arrayList2 = new ArrayList<>();
            Iterator<on> it = arrayList.iterator();
            int i = 0;
            while (it.hasNext()) {
                on next = it.next();
                if (next instanceof tp4) {
                    ((tp4) next).setPosition(i);
                    arrayList2.add(next);
                } else if (next instanceof vp4) {
                    ((vp4) next).position = i;
                    arrayList2.add(next);
                } else if (next instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) next;
                    AbsGroupUbsABTest.setCardInfoUbsABTest(threadData);
                    int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                    if (threadData.getType() == ThreadData.TYPE_NORMAL && !threadData.isTop()) {
                        ir4 ir4Var = new ir4();
                        ir4Var.t = threadData;
                        ir4Var.position = i;
                        ir4Var.a = true;
                        ir4Var.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList2.add(ir4Var);
                        ir4 ir4Var2 = new ir4();
                        ir4Var2.t = threadData;
                        ir4Var2.position = i;
                        if (threadData.isBJHNormalThreadType()) {
                            ir4Var2.f = true;
                        } else if (threadData.picCount() == 1) {
                            ir4Var2.d = true;
                            ir4Var2.u = imageWidthAndHeight[0];
                            ir4Var2.v = imageWidthAndHeight[1];
                        } else if (threadData.picCount() >= 2) {
                            ir4Var2.e = true;
                        } else {
                            ir4Var2.b = true;
                        }
                        ir4Var2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(ir4Var2);
                        if (threadData.getPollData() != null) {
                            ir4 ir4Var3 = new ir4();
                            ir4Var3.o = true;
                            ir4Var3.t = threadData;
                            ir4Var3.position = i;
                            ir4Var3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(ir4Var3);
                        }
                        if (threadData.getSmartApp() != null) {
                            ir4 ir4Var4 = new ir4();
                            ir4Var4.l = true;
                            ir4Var4.t = threadData;
                            ir4Var4.position = i;
                            ir4Var4.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(ir4Var4);
                        }
                        if (!ListUtils.isEmpty(threadData.getLinkDataList()) || !ListUtils.isEmpty(threadData.getGoodsDataList())) {
                            ir4 ir4Var5 = new ir4();
                            if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) == 1) {
                                ir4Var5.p = true;
                            } else if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) > 1) {
                                ir4Var5.q = true;
                            }
                            ir4Var5.t = threadData;
                            ir4Var5.position = i;
                            ir4Var5.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(ir4Var5);
                        }
                        if (threadData.getTopAgreePost() != null) {
                            ir4 ir4Var6 = new ir4();
                            ir4Var6.h = true;
                            ir4Var6.t = threadData;
                            ir4Var6.position = i;
                            ir4Var6.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(ir4Var6);
                        }
                        if (!z && threadData.getItem() != null && !threadData.isVoteThreadType()) {
                            ir4 ir4Var7 = new ir4();
                            ir4Var7.n = true;
                            ir4Var7.t = threadData;
                            ir4Var7.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(ir4Var7);
                        }
                        ir4 ir4Var8 = new ir4();
                        ir4Var8.g = true;
                        ir4Var8.t = threadData;
                        ir4Var8.position = i;
                        ir4Var8.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(ir4Var8);
                    } else if ((threadData.getType() == ThreadData.TYPE_VIDEO || threadData.getType() == ThreadData.TYPE_FAKE_VIDEO) && !threadData.isTop()) {
                        ir4 ir4Var9 = new ir4();
                        ir4Var9.t = threadData;
                        ir4Var9.position = i;
                        ir4Var9.a = true;
                        threadData.isJumpToFrsVideoTabPlay = z2;
                        ir4Var9.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList2.add(ir4Var9);
                        ir4 ir4Var10 = new ir4();
                        ir4Var10.t = threadData;
                        ir4Var10.position = i;
                        if (threadData instanceof dq4) {
                            ir4Var10.j = true;
                        } else {
                            ir4Var10.i = true;
                        }
                        ir4Var10.t.isJumpToFrsVideoTabPlay = z2;
                        ir4Var10.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(ir4Var10);
                        if (threadData.getPollData() != null) {
                            ir4 ir4Var11 = new ir4();
                            ir4Var11.o = true;
                            ir4Var11.t = threadData;
                            ir4Var11.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            ir4Var11.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(ir4Var11);
                        }
                        if (threadData.getSmartApp() != null) {
                            ir4 ir4Var12 = new ir4();
                            ir4Var12.l = true;
                            ir4Var12.t = threadData;
                            ir4Var12.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            ir4Var12.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(ir4Var12);
                        }
                        if (threadData.getTopAgreePost() != null) {
                            ir4 ir4Var13 = new ir4();
                            ir4Var13.h = true;
                            ir4Var13.t = threadData;
                            ir4Var13.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            ir4Var13.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(ir4Var13);
                        }
                        if (!z && threadData.getItem() != null && !threadData.isVoteThreadType()) {
                            ir4 ir4Var14 = new ir4();
                            ir4Var14.n = true;
                            ir4Var14.t = threadData;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            ir4Var14.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(ir4Var14);
                        }
                        ir4 ir4Var15 = new ir4();
                        ir4Var15.g = true;
                        ir4Var15.t = threadData;
                        ir4Var15.position = i;
                        threadData.isJumpToFrsVideoTabPlay = z2;
                        ir4Var15.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(ir4Var15);
                    } else if (threadData.getThreadVideoInfo() != null && !threadData.isLiveInterviewLiveType() && threadData.isGodThread()) {
                        ir4 ir4Var16 = new ir4();
                        ir4Var16.t = threadData;
                        ir4Var16.position = i;
                        ir4Var16.a = true;
                        threadData.isJumpToFrsVideoTabPlay = z2;
                        ir4Var16.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList2.add(ir4Var16);
                        ir4 ir4Var17 = new ir4();
                        ir4Var17.t = threadData;
                        ir4Var17.position = i;
                        ir4Var17.k = true;
                        threadData.isJumpToFrsVideoTabPlay = z2;
                        ir4Var17.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(ir4Var17);
                        if (threadData.getPollData() != null) {
                            ir4 ir4Var18 = new ir4();
                            ir4Var18.o = true;
                            ir4Var18.t = threadData;
                            ir4Var18.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            ir4Var18.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(ir4Var18);
                        }
                        if (threadData.getSmartApp() != null) {
                            ir4 ir4Var19 = new ir4();
                            ir4Var19.l = true;
                            ir4Var19.t = threadData;
                            ir4Var19.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            ir4Var19.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(ir4Var19);
                        }
                        if (threadData.getTopAgreePost() != null) {
                            ir4 ir4Var20 = new ir4();
                            ir4Var20.h = true;
                            ir4Var20.t = threadData;
                            ir4Var20.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            ir4Var20.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(ir4Var20);
                        }
                        if (!z && threadData.getItem() != null && !threadData.isVoteThreadType()) {
                            ir4 ir4Var21 = new ir4();
                            ir4Var21.n = true;
                            ir4Var21.t = threadData;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            ir4Var21.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(ir4Var21);
                        }
                        ir4 ir4Var22 = new ir4();
                        ir4Var22.g = true;
                        ir4Var22.t = threadData;
                        ir4Var22.position = i;
                        threadData.isJumpToFrsVideoTabPlay = z2;
                        ir4Var22.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(ir4Var22);
                    } else if (threadData.getType() == ThreadData.TYPE_ARTICLE && threadData.isBJHArticleThreadType()) {
                        threadData.position = i;
                        arrayList2.add(threadData);
                    } else {
                        ir4 ir4Var23 = new ir4();
                        ir4Var23.t = threadData;
                        ir4Var23.position = i;
                        arrayList2.add(ir4Var23);
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

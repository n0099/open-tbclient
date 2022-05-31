package com.repackage;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.YyExtData;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes7.dex */
public class rn5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public sn5 a;
    public tn5 b;
    public xn5 c;
    public wn5 d;
    public un5 e;
    public vn5 f;
    public List<wm> g;

    /* loaded from: classes7.dex */
    public class a implements lo5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbPageContext a;

        public a(rn5 rn5Var, TbPageContext tbPageContext) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rn5Var, tbPageContext};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbPageContext;
        }

        @Override // com.repackage.lo5
        public void a(pm5 pm5Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, pm5Var) == null) || pm5Var == null || pm5Var.getThreadData() == null) {
                return;
            }
            if (pm5Var.getThreadData().getThreadAlaInfo() != null && pm5Var.getThreadData().getThreadAlaInfo().mYyExtData != null) {
                AlaInfoData threadAlaInfo = pm5Var.getThreadData().getThreadAlaInfo();
                TbPageContext tbPageContext = this.a;
                YyExtData yyExtData = threadAlaInfo.mYyExtData;
                String str = yyExtData.mSid;
                String str2 = yyExtData.mSsid;
                String str3 = yyExtData.mTemplateId;
                YYLiveUtil.jumpToYYLiveRoom(tbPageContext, str, str2, str3, "" + threadAlaInfo.roomId, threadAlaInfo.mYyExtData.streamInfo, YYLiveUtil.SOURCE_HOME_LIVE_TAB_FOLLOW_CARD);
                return;
            }
            bn5.i(this.a.getPageActivity(), pm5Var.getThreadData());
        }
    }

    /* loaded from: classes7.dex */
    public class b implements lo5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbPageContext a;

        public b(rn5 rn5Var, TbPageContext tbPageContext) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rn5Var, tbPageContext};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbPageContext;
        }

        @Override // com.repackage.lo5
        public void a(pm5 pm5Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, pm5Var) == null) || pm5Var == null || pm5Var.getThreadData() == null || pm5Var.getThreadData().getThreadAlaInfo() == null || pm5Var.getThreadData().getThreadAlaInfo().mYyExtData == null) {
                return;
            }
            AlaInfoData threadAlaInfo = pm5Var.getThreadData().getThreadAlaInfo();
            TbPageContext tbPageContext = this.a;
            YyExtData yyExtData = threadAlaInfo.mYyExtData;
            String str = yyExtData.mSid;
            String str2 = yyExtData.mSsid;
            String str3 = yyExtData.mTemplateId;
            YYLiveUtil.jumpToYYLiveRoom(tbPageContext, str, str2, str3, "" + threadAlaInfo.roomId, YYLiveUtil.SOURCE_HOME_LIVE_TAB_FOLLOW_HEAD);
        }
    }

    public rn5(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = new LinkedList();
        this.a = new sn5(tbPageContext);
        this.b = new tn5(tbPageContext);
        this.c = new xn5(tbPageContext);
        this.d = new wn5(tbPageContext);
        this.e = new un5(tbPageContext);
        this.f = new vn5(tbPageContext);
        this.b.b0(new a(this, tbPageContext));
        this.d.b0(new b(this, tbPageContext));
        this.g.add(this.a);
        this.g.add(this.b);
        this.g.add(this.c);
        this.g.add(this.d);
        this.g.add(this.e);
        this.g.add(this.f);
    }

    public List<wm> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.g : (List) invokeV.objValue;
    }
}

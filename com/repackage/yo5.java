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
public class yo5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public zo5 a;
    public ap5 b;
    public ep5 c;
    public dp5 d;
    public bp5 e;
    public cp5 f;
    public List<eo> g;

    /* loaded from: classes7.dex */
    public class a implements sp5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbPageContext a;

        public a(yo5 yo5Var, TbPageContext tbPageContext) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yo5Var, tbPageContext};
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

        @Override // com.repackage.sp5
        public void a(wn5 wn5Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, wn5Var) == null) || wn5Var == null || wn5Var.getThreadData() == null) {
                return;
            }
            if (wn5Var.getThreadData().getThreadAlaInfo() != null && wn5Var.getThreadData().getThreadAlaInfo().mYyExtData != null) {
                AlaInfoData threadAlaInfo = wn5Var.getThreadData().getThreadAlaInfo();
                TbPageContext tbPageContext = this.a;
                YyExtData yyExtData = threadAlaInfo.mYyExtData;
                String str = yyExtData.mSid;
                String str2 = yyExtData.mSsid;
                String str3 = yyExtData.mTemplateId;
                YYLiveUtil.jumpToYYLiveRoom(tbPageContext, str, str2, str3, "" + threadAlaInfo.roomId, threadAlaInfo.mYyExtData.streamInfo, YYLiveUtil.SOURCE_HOME_LIVE_TAB_FOLLOW_CARD);
                return;
            }
            io5.i(this.a.getPageActivity(), wn5Var.getThreadData());
        }
    }

    /* loaded from: classes7.dex */
    public class b implements sp5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbPageContext a;

        public b(yo5 yo5Var, TbPageContext tbPageContext) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yo5Var, tbPageContext};
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

        @Override // com.repackage.sp5
        public void a(wn5 wn5Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, wn5Var) == null) || wn5Var == null || wn5Var.getThreadData() == null || wn5Var.getThreadData().getThreadAlaInfo() == null || wn5Var.getThreadData().getThreadAlaInfo().mYyExtData == null) {
                return;
            }
            AlaInfoData threadAlaInfo = wn5Var.getThreadData().getThreadAlaInfo();
            TbPageContext tbPageContext = this.a;
            YyExtData yyExtData = threadAlaInfo.mYyExtData;
            String str = yyExtData.mSid;
            String str2 = yyExtData.mSsid;
            String str3 = yyExtData.mTemplateId;
            YYLiveUtil.jumpToYYLiveRoom(tbPageContext, str, str2, str3, "" + threadAlaInfo.roomId, YYLiveUtil.SOURCE_HOME_LIVE_TAB_FOLLOW_HEAD);
        }
    }

    public yo5(TbPageContext tbPageContext) {
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
        this.a = new zo5(tbPageContext);
        this.b = new ap5(tbPageContext);
        this.c = new ep5(tbPageContext);
        this.d = new dp5(tbPageContext);
        this.e = new bp5(tbPageContext);
        this.f = new cp5(tbPageContext);
        this.b.b0(new a(this, tbPageContext));
        this.d.b0(new b(this, tbPageContext));
        this.g.add(this.a);
        this.g.add(this.b);
        this.g.add(this.c);
        this.g.add(this.d);
        this.g.add(this.e);
        this.g.add(this.f);
    }

    public List<eo> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.g : (List) invokeV.objValue;
    }
}

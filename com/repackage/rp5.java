package com.repackage;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.AlaUserInfoData;
import com.baidu.tbadk.core.data.YyExtData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes7.dex */
public class rp5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public sp5 a;
    public tp5 b;
    public xp5 c;
    public wp5 d;
    public up5 e;
    public vp5 f;
    public List<an> g;

    /* loaded from: classes7.dex */
    public class a implements lq5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbPageContext a;

        public a(rp5 rp5Var, TbPageContext tbPageContext) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rp5Var, tbPageContext};
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

        @Override // com.repackage.lq5
        public void a(qo5 qo5Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, qo5Var) == null) || qo5Var == null || qo5Var.getThreadData() == null) {
                return;
            }
            if (qo5Var.getThreadData().getThreadAlaInfo() != null && qo5Var.getThreadData().getThreadAlaInfo().mYyExtData != null) {
                AlaInfoData threadAlaInfo = qo5Var.getThreadData().getThreadAlaInfo();
                TbPageContext tbPageContext = this.a;
                YyExtData yyExtData = threadAlaInfo.mYyExtData;
                String str = yyExtData.mSid;
                String str2 = yyExtData.mSsid;
                String str3 = yyExtData.mTemplateId;
                YYLiveUtil.jumpToYYLiveRoom(tbPageContext, str, str2, str3, "" + threadAlaInfo.roomId, threadAlaInfo.mYyExtData.streamInfo, YYLiveUtil.SOURCE_HOME_LIVE_TAB_FOLLOW_CARD);
                AlaUserInfoData alaUserInfoData = threadAlaInfo.user_info;
                if (alaUserInfoData != null) {
                    StatisticItem.make("c14719").param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_id", alaUserInfoData.ala_id).param("obj_locate", 1).eventStat();
                    return;
                }
                return;
            }
            dp5.h(this.a.getPageActivity(), qo5Var.getThreadData());
        }
    }

    /* loaded from: classes7.dex */
    public class b implements lq5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbPageContext a;

        public b(rp5 rp5Var, TbPageContext tbPageContext) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rp5Var, tbPageContext};
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

        @Override // com.repackage.lq5
        public void a(qo5 qo5Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, qo5Var) == null) || qo5Var == null || qo5Var.getThreadData() == null || qo5Var.getThreadData().getThreadAlaInfo() == null || qo5Var.getThreadData().getThreadAlaInfo().mYyExtData == null) {
                return;
            }
            AlaInfoData threadAlaInfo = qo5Var.getThreadData().getThreadAlaInfo();
            TbPageContext tbPageContext = this.a;
            YyExtData yyExtData = threadAlaInfo.mYyExtData;
            String str = yyExtData.mSid;
            String str2 = yyExtData.mSsid;
            String str3 = yyExtData.mTemplateId;
            YYLiveUtil.jumpToYYLiveRoom(tbPageContext, str, str2, str3, "" + threadAlaInfo.roomId, YYLiveUtil.SOURCE_HOME_LIVE_TAB_FOLLOW_HEAD);
        }
    }

    public rp5(TbPageContext tbPageContext) {
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
        this.a = new sp5(tbPageContext);
        this.b = new tp5(tbPageContext);
        this.c = new xp5(tbPageContext);
        this.d = new wp5(tbPageContext);
        this.e = new up5(tbPageContext);
        this.f = new vp5(tbPageContext);
        this.b.b0(new a(this, tbPageContext));
        this.d.b0(new b(this, tbPageContext));
        this.g.add(this.a);
        this.g.add(this.b);
        this.g.add(this.c);
        this.g.add(this.d);
        this.g.add(this.e);
        this.g.add(this.f);
    }

    public List<an> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.g : (List) invokeV.objValue;
    }
}

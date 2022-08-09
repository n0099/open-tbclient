package com.repackage;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.NewHottopic.PkItem;
import tbclient.NewHottopic.PkModule;
/* loaded from: classes7.dex */
public class q37 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;
    public long b;
    public long c;
    public a d;
    public a e;
    public int f;

    /* loaded from: classes7.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;
        public String b;
        public String c;
        public String d;
        public boolean e;
        public long f;
        public String g;

        public a(q37 q37Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q37Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    public q37() {
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

    public void a(PkModule pkModule) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, pkModule) == null) || pkModule == null || pkModule.agree == null || pkModule.disagree == null) {
            return;
        }
        this.b = pkModule.pk_id.longValue();
        this.c = pkModule.user_pk_id.longValue();
        a aVar = new a(this);
        this.d = aVar;
        aVar.a = pkModule.agree.pk_num.longValue();
        this.d.b = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1438) : pkModule.agree.pk_desc;
        a aVar2 = this.d;
        PkItem pkItem = pkModule.agree;
        aVar2.c = pkItem.last_username;
        aVar2.d = pkItem.pk_icon;
        aVar2.e = pkItem.has_clicked.longValue() == 1;
        this.d.f = pkModule.agree.pk_index.longValue();
        this.d.g = pkModule.agree.pk_icon_after;
        a aVar3 = new a(this);
        this.e = aVar3;
        aVar3.a = pkModule.disagree.pk_num.longValue();
        this.e.b = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1437) : pkModule.disagree.pk_desc;
        a aVar4 = this.e;
        PkItem pkItem2 = pkModule.disagree;
        aVar4.c = pkItem2.last_username;
        aVar4.d = pkItem2.pk_icon;
        aVar4.e = pkItem2.has_clicked.longValue() == 1;
        this.e.f = pkModule.disagree.pk_index.longValue();
        this.e.g = pkModule.disagree.pk_icon_after;
    }

    public void b(tbclient.NewTopicList.PkModule pkModule) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pkModule) == null) || pkModule == null || pkModule.agree == null || pkModule.disagree == null) {
            return;
        }
        this.b = pkModule.pk_id.longValue();
        this.c = pkModule.user_pk_id.longValue();
        a aVar = new a(this);
        this.d = aVar;
        aVar.a = pkModule.agree.pk_num.longValue();
        this.d.b = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1438) : pkModule.agree.pk_desc;
        a aVar2 = this.d;
        tbclient.NewTopicList.PkItem pkItem = pkModule.agree;
        aVar2.c = pkItem.last_username;
        aVar2.d = pkItem.pk_icon;
        aVar2.e = pkItem.has_clicked.longValue() == 1;
        this.d.f = pkModule.agree.pk_index.longValue();
        this.d.g = pkModule.agree.pk_icon_after;
        a aVar3 = new a(this);
        this.e = aVar3;
        aVar3.a = pkModule.disagree.pk_num.longValue();
        this.e.b = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1437) : pkModule.disagree.pk_desc;
        a aVar4 = this.e;
        tbclient.NewTopicList.PkItem pkItem2 = pkModule.disagree;
        aVar4.c = pkItem2.last_username;
        aVar4.d = pkItem2.pk_icon;
        aVar4.e = pkItem2.has_clicked.longValue() == 1;
        this.e.f = pkModule.disagree.pk_index.longValue();
        this.e.g = pkModule.disagree.pk_icon_after;
    }

    public void c(tbclient.PkModule pkModule) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pkModule) == null) || pkModule == null || pkModule.agree == null || pkModule.disagree == null) {
            return;
        }
        this.b = pkModule.pk_id.longValue();
        this.c = pkModule.user_pk_id.longValue();
        a aVar = new a(this);
        this.d = aVar;
        aVar.a = pkModule.agree.pk_num.longValue();
        this.d.b = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1438) : pkModule.agree.pk_desc;
        a aVar2 = this.d;
        tbclient.PkItem pkItem = pkModule.agree;
        aVar2.c = pkItem.last_username;
        aVar2.d = pkItem.pk_icon;
        aVar2.e = pkItem.has_clicked.longValue() == 1;
        this.d.f = pkModule.agree.pk_index.longValue();
        this.d.g = pkModule.agree.pk_icon_after;
        a aVar3 = new a(this);
        this.e = aVar3;
        aVar3.a = pkModule.disagree.pk_num.longValue();
        this.e.b = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1437) : pkModule.disagree.pk_desc;
        a aVar4 = this.e;
        tbclient.PkItem pkItem2 = pkModule.disagree;
        aVar4.c = pkItem2.last_username;
        aVar4.d = pkItem2.pk_icon;
        aVar4.e = pkItem2.has_clicked.longValue() == 1;
        this.e.f = pkModule.disagree.pk_index.longValue();
        this.e.g = pkModule.disagree.pk_icon_after;
    }
}

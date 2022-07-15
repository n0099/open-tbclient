package com.repackage;

import android.widget.CompoundButton;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class hs8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public ij5 b;
    public NEGFeedBackView.b c;

    /* loaded from: classes6.dex */
    public class a implements NEGFeedBackView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hs8 a;

        public a(hs8 hs8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hs8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hs8Var;
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void a(ArrayList<Integer> arrayList, String str, kp4 kp4Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLL(1048576, this, arrayList, str, kp4Var) == null) || arrayList == null || kp4Var == null) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            int size = arrayList.size();
            int i = 0;
            for (int i2 = 0; i2 < size; i2++) {
                sb.append(arrayList.get(i2));
                sb.append(",");
            }
            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
            int i3 = kp4Var.n;
            int i4 = 3;
            if (i3 == 0) {
                i = 1;
            } else if (i3 == 40) {
                i = 2;
            } else if (i3 == 49 || i3 == 69) {
                i = 3;
            }
            boolean z = kp4Var.r;
            if (!this.a.a) {
                i4 = z ? 5 : 4;
            } else if (!z) {
                i4 = 2;
            }
            StatisticItem.make(TbadkCoreStatisticKey.NEG_FEEDBACK_KEY).param("tid", kp4Var.f()).param("nid", kp4Var.e()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", kp4Var.c()).param("obj_param1", kp4Var.k).param("obj_source", kp4Var.l).param("obj_id", kp4Var.m).param("obj_type", sb.toString()).param("obj_name", str).param(TiebaStatic.Params.OBJ_PARAM2, i).param("obj_locate", i4).eventStat();
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void b(kp4 kp4Var, CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, kp4Var, compoundButton, z) == null) {
            }
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void c(kp4 kp4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, kp4Var) == null) {
            }
        }
    }

    public hs8() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = false;
        this.c = new a(this);
    }

    public void b() {
        ij5 ij5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (ij5Var = this.b) == null) {
            return;
        }
        ij5Var.h();
    }

    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.a = z;
        }
    }

    public void d(TbPageContext tbPageContext, VideoItemData videoItemData, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, videoItemData, z) == null) || tbPageContext == null || videoItemData == null || !ViewHelper.checkUpIsLogin(tbPageContext.getPageActivity())) {
            return;
        }
        if (this.b == null) {
            this.b = new ij5(tbPageContext);
        }
        kp4 negFeedBackData = videoItemData.getNegFeedBackData();
        if (negFeedBackData == null) {
            negFeedBackData = new kp4();
        }
        String str = videoItemData.thread_id;
        String str2 = videoItemData.forum_id;
        negFeedBackData.r = z;
        negFeedBackData.o(str);
        negFeedBackData.l(str2);
        this.b.r(this.a);
        this.b.p(this.c);
        this.b.o(negFeedBackData);
        this.b.q(true);
        this.b.h();
        this.b.s();
        StatisticItem.make(TbadkCoreStatisticKey.NEGATIVE_FEEDBACK_OPEN_CLICK).param("obj_locate", this.a ? z ? 3 : 2 : z ? 5 : 4).param("fid", str2).param("tid", str).param("uid", TbadkCoreApplication.getCurrentAccount()).eventStat();
    }
}

package d.a.q0.x3;

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
import d.a.p0.s.q.w0;
import d.a.q0.h.d;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f66916a;

    /* renamed from: b  reason: collision with root package name */
    public d f66917b;

    /* renamed from: c  reason: collision with root package name */
    public NEGFeedBackView.b f66918c;

    /* renamed from: d.a.q0.x3.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1848a implements NEGFeedBackView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f66919a;

        public C1848a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f66919a = aVar;
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void onCheckedChanged(w0 w0Var, CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLZ(1048576, this, w0Var, compoundButton, z) == null) {
            }
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void onNEGFeedbackConfirm(ArrayList<Integer> arrayList, String str, w0 w0Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, arrayList, str, w0Var) == null) || arrayList == null || w0Var == null) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            int size = arrayList.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                sb.append(arrayList.get(i3));
                sb.append(",");
            }
            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
            int i4 = w0Var.m;
            int i5 = 3;
            if (i4 == 0) {
                i2 = 1;
            } else if (i4 == 40) {
                i2 = 2;
            } else if (i4 == 49 || i4 == 69) {
                i2 = 3;
            }
            boolean z = w0Var.q;
            if (!this.f66919a.f66916a) {
                i5 = z ? 5 : 4;
            } else if (!z) {
                i5 = 2;
            }
            StatisticItem.make(TbadkCoreStatisticKey.NEG_FEEDBACK_KEY).param("tid", w0Var.e()).param("nid", w0Var.d()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", w0Var.c()).param("obj_param1", w0Var.j).param("obj_source", w0Var.k).param("obj_id", w0Var.l).param("obj_type", sb.toString()).param("obj_name", str).param(TiebaStatic.Params.OBJ_PARAM2, i2).param("obj_locate", i5).eventStat();
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void onNEGFeedbackWindowShow(w0 w0Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, w0Var) == null) {
            }
        }
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f66916a = false;
        this.f66918c = new C1848a(this);
    }

    public void b() {
        d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (dVar = this.f66917b) == null) {
            return;
        }
        dVar.h();
    }

    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.f66916a = z;
        }
    }

    public void d(TbPageContext tbPageContext, VideoItemData videoItemData, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, videoItemData, z) == null) || tbPageContext == null || videoItemData == null || !ViewHelper.checkUpIsLogin(tbPageContext.getPageActivity())) {
            return;
        }
        if (this.f66917b == null) {
            this.f66917b = new d(tbPageContext);
        }
        w0 negFeedBackData = videoItemData.getNegFeedBackData();
        if (negFeedBackData == null) {
            negFeedBackData = new w0();
        }
        String str = videoItemData.thread_id;
        String str2 = videoItemData.forum_id;
        negFeedBackData.q = z;
        negFeedBackData.n(str);
        negFeedBackData.l(str2);
        this.f66917b.r(this.f66916a);
        this.f66917b.p(this.f66918c);
        this.f66917b.o(negFeedBackData);
        this.f66917b.q(true);
        this.f66917b.h();
        this.f66917b.s();
        StatisticItem.make(TbadkCoreStatisticKey.NEGATIVE_FEEDBACK_OPEN_CLICK).param("obj_locate", this.f66916a ? z ? 3 : 2 : z ? 5 : 4).param("fid", str2).param("tid", str).param("uid", TbadkCoreApplication.getCurrentAccount()).eventStat();
    }
}

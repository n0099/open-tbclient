package com.repackage;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tieba.newdetail.HotTopicDetailModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.o55;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class oh5 implements rc1<o55> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public static final class b implements o55, HotTopicDetailModel.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public HotTopicDetailModel b;
        @Nullable
        public o55.a c;

        public b() {
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

        @Override // com.repackage.o55
        public o55 a(@NonNull TbPageContext tbPageContext, long j, @NonNull String str) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{tbPageContext, Long.valueOf(j), str})) == null) {
                HotTopicDetailModel hotTopicDetailModel = new HotTopicDetailModel(tbPageContext);
                this.b = hotTopicDetailModel;
                hotTopicDetailModel.N(j, str);
                this.b.M(this);
                return this;
            }
            return (o55) invokeCommon.objValue;
        }

        @Override // com.repackage.o55
        public void b(int i, aq4 aq4Var, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), aq4Var, Long.valueOf(j)}) == null) {
                this.b.A(i, aq4Var, j);
            }
        }

        @Override // com.repackage.o55
        public void c(@Nullable o55.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
                this.c = aVar;
            }
        }

        @Override // com.baidu.tieba.newdetail.HotTopicDetailModel.d
        public void netLoadMoreCallback(int i, @Nullable z27 z27Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(1048579, this, i, z27Var) == null) || this.c == null) {
                return;
            }
            if (z27Var != null) {
                ArrayList arrayList = new ArrayList();
                for (yx5 yx5Var : z27Var.a) {
                    if (yx5Var instanceof yx5) {
                        ThreadData threadData = yx5Var.getThreadData();
                        if (!TextUtils.equals(threadData.getTid(), "0")) {
                            arrayList.add(threadData);
                        }
                    }
                }
                this.c.b(arrayList, z27Var.i());
            }
            this.c.a();
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    public oh5() {
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.rc1
    /* renamed from: a */
    public o55 getService() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new b(null) : (o55) invokeV.objValue;
    }
}

package com.repackage;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.d55;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes5.dex */
public class e38 implements d55, PersonPostModel.d, PersonPostModel.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public PersonPostModel a;
    @Nullable
    public d55.a b;

    public e38(@NonNull TbPageContext tbPageContext) {
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
        this.a = new PersonPostModel(tbPageContext, tbPageContext.getUniqueId(), this, false, PersonPostModel.FROM_PERSON_POLYMERIC);
    }

    @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.c
    public void I(PersonPostModel personPostModel, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048576, this, personPostModel, z) == null) || this.b == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<uo> it = personPostModel.threadList.iterator();
        while (it.hasNext()) {
            uo next = it.next();
            if (next instanceof CardPersonDynamicThreadData) {
                ThreadData threadData = ((CardPersonDynamicThreadData) next).getThreadData();
                if (!TextUtils.equals(threadData.getTid(), "0")) {
                    arrayList.add(threadData);
                }
            }
        }
        this.b.b(arrayList, personPostModel.getDataResMap());
        this.b.a();
    }

    @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.d
    public void O(PersonPostModel personPostModel, boolean z) {
        d55.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, personPostModel, z) == null) || (aVar = this.b) == null) {
            return;
        }
        aVar.a();
    }

    @Override // com.repackage.d55
    public void a(@Nullable d55.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            this.b = aVar;
        }
    }

    @Override // com.repackage.d55
    public void b(@NonNull String str, @Nullable MetaData metaData, @NonNull Integer num, @NonNull Integer num2, @NonNull Integer num3, @NonNull Integer num4, @NonNull Long l, @NonNull Integer num5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{str, metaData, num, num2, num3, num4, l, num5}) == null) {
            this.a.fetchPostByBeginThreadId(str, this, metaData, num, num2, num3, num4, l, num5);
        }
    }
}

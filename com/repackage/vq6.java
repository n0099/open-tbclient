package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.model.NetModel;
import com.baidu.tieba.frs.voiceroom.data.VoiceRoomListNetModel;
import com.baidu.tieba.frs.voiceroom.data.VoiceRoomWrapper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.il4;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class vq6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final VoiceRoomListNetModel a;

    /* loaded from: classes7.dex */
    public static final class a implements NetModel.k<tq6, uq6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hl4<List<VoiceRoomWrapper>> a;

        public a(hl4<List<VoiceRoomWrapper>> hl4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hl4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hl4Var;
        }

        @Override // com.baidu.tbadk.mvc.model.NetModel.m
        public void o(MvcSocketResponsedMessage<uq6, ?> mvcSocketResponsedMessage, MvcSocketMessage<tq6, uq6> mvcSocketMessage, MvcNetMessage<tq6, uq6> mvcNetMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLL(1048576, this, mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage) == null) || mvcSocketResponsedMessage == null || mvcSocketResponsedMessage.hasError()) {
                return;
            }
            if (mvcSocketResponsedMessage.getError() == 0) {
                this.a.a(new il4.c(mvcSocketResponsedMessage.getData().a()));
                return;
            }
            hl4<List<VoiceRoomWrapper>> hl4Var = this.a;
            String errorString = mvcSocketResponsedMessage.getErrorString();
            Intrinsics.checkNotNullExpressionValue(errorString, "responsedMessage.errorString");
            hl4Var.a(new il4.a(errorString, null, 2, null));
        }

        @Override // com.baidu.tbadk.mvc.model.NetModel.l
        public void t(MvcHttpResponsedMessage<uq6> mvcHttpResponsedMessage, MvcHttpMessage<tq6, uq6> mvcHttpMessage, MvcNetMessage<tq6, uq6> mvcNetMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage) == null) || mvcHttpResponsedMessage == null || mvcHttpResponsedMessage.hasError()) {
                return;
            }
            if (mvcHttpResponsedMessage.getError() == 0) {
                this.a.a(new il4.c(mvcHttpResponsedMessage.getData().a()));
                return;
            }
            hl4<List<VoiceRoomWrapper>> hl4Var = this.a;
            String errorString = mvcHttpResponsedMessage.getErrorString();
            Intrinsics.checkNotNullExpressionValue(errorString, "responsedMessage.errorString");
            hl4Var.a(new il4.a(errorString, null, 2, null));
        }
    }

    public vq6() {
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
        this.a = new VoiceRoomListNetModel();
    }

    public final void a(TbPageContext<?> tbPageContext, long j, long j2, hl4<List<VoiceRoomWrapper>> callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{tbPageContext, Long.valueOf(j), Long.valueOf(j2), callback}) == null) {
            Intrinsics.checkNotNullParameter(tbPageContext, "tbPageContext");
            Intrinsics.checkNotNullParameter(callback, "callback");
            tq6 tq6Var = new tq6(j, j2);
            this.a.setUniqueId(tbPageContext.getUniqueId());
            this.a.d0(tq6Var);
            this.a.c0(new a(callback));
            this.a.loadData();
            callback.a(new il4.b(null, 1, null));
        }
    }
}

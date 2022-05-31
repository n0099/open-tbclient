package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.im.data.MsgLocalData;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.PersonalChatMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.dg8;
/* loaded from: classes5.dex */
public class b15 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public z05 a;

    /* loaded from: classes5.dex */
    public class a extends mc5<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z05 a;

        public a(b15 b15Var, z05 z05Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b15Var, z05Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z05Var;
        }

        @Override // com.repackage.mc5
        public Object doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? Long.valueOf(e47.v().j(this.a.a().a)) : invokeV.objValue;
        }
    }

    public b15(z05 z05Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {z05Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = z05Var;
    }

    public final ChatMessage a(String str, long j) {
        InterceptResult invokeLJ;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048576, this, str, j)) == null) {
            ChatMessage b = b();
            if (b == null) {
                return null;
            }
            b.setCustomGroupType(2);
            b.setMsgType(1);
            b.setContent(str);
            long b2 = x67.b(j);
            b.setMsgId(b2);
            b.setRecordId(b2);
            b.setTime(System.currentTimeMillis() / 1000);
            UserData userData = new UserData();
            userData.setUserName(TbadkCoreApplication.getCurrentAccountName());
            userData.setUserId(TbadkCoreApplication.getCurrentAccount());
            userData.setName_show(TbadkCoreApplication.getCurrentAccountNameShow());
            userData.setPortrait(TbadkCoreApplication.getCurrentPortrait());
            b.setUserInfo(userData);
            try {
                j2 = jg.g(TbadkCoreApplication.getCurrentAccount(), 0L);
            } catch (Exception unused) {
                j2 = 0;
            }
            b.setUserId(j2);
            MsgLocalData msgLocalData = new MsgLocalData();
            msgLocalData.setStatus((short) 1);
            msgLocalData.setErrno(0L);
            msgLocalData.setRetry(0L);
            msgLocalData.setUpload_offset(null);
            b.setLocalData(msgLocalData);
            return b;
        }
        return (ChatMessage) invokeLJ.objValue;
    }

    public ChatMessage b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            z05 z05Var = this.a;
            if (z05Var == null || z05Var.a() == null) {
                return null;
            }
            PersonalChatMessage personalChatMessage = new PersonalChatMessage();
            personalChatMessage.setBornTime(System.currentTimeMillis());
            personalChatMessage.setToUserId(Long.parseLong(this.a.a().a));
            UserData userData = new UserData();
            userData.setUserId(this.a.a().a);
            userData.setPortrait(this.a.a().c);
            userData.setName_show(this.a.a().b);
            personalChatMessage.setToUserInfo(userData);
            personalChatMessage.setIsFriend(this.a.a().j ? 1 : 0);
            return personalChatMessage;
        }
        return (ChatMessage) invokeV.objValue;
    }

    public /* synthetic */ void c(String str, Object obj) {
        if (obj instanceof Long) {
            j57.k().u(a(str, ((Long) obj).longValue()));
            e("");
        }
    }

    public void d(dg8.g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, gVar) == null) || gVar == null) {
            return;
        }
        z05 z05Var = this.a;
        if (z05Var != null && z05Var.a() != null) {
            dg8.l(this.a.a().a, gVar);
        } else {
            gVar.a(null);
        }
    }

    public void e(String str) {
        z05 z05Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || (z05Var = this.a) == null || z05Var.a() == null) {
            return;
        }
        dg8.u(this.a.a().a, str);
    }

    public void f(z05 z05Var, final String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, z05Var, str) == null) {
            this.a = z05Var;
            pc5.c(new a(this, z05Var), new tb5() { // from class: com.repackage.a15
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.repackage.tb5
                public final void onReturnDataInUI(Object obj) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                        b15.this.c(str, obj);
                    }
                }
            });
        }
    }
}

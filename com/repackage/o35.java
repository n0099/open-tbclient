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
import com.repackage.ek8;
/* loaded from: classes7.dex */
public class o35 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public m35 a;

    /* loaded from: classes7.dex */
    public class a extends cf5<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m35 a;

        public a(o35 o35Var, m35 m35Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o35Var, m35Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m35Var;
        }

        @Override // com.repackage.cf5
        public Object doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? Long.valueOf(x77.w().j(this.a.a().a)) : invokeV.objValue;
        }
    }

    public o35(m35 m35Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {m35Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = m35Var;
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
            long b2 = sa7.b(j);
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
                j2 = og.g(TbadkCoreApplication.getCurrentAccount(), 0L);
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
            m35 m35Var = this.a;
            if (m35Var == null || m35Var.a() == null) {
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
            e97.k().u(a(str, ((Long) obj).longValue()));
            e("");
        }
    }

    public void d(ek8.h hVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, hVar) == null) || hVar == null) {
            return;
        }
        m35 m35Var = this.a;
        if (m35Var != null && m35Var.a() != null) {
            ek8.m(this.a.a().a, hVar);
        } else {
            hVar.a(null);
        }
    }

    public void e(String str) {
        m35 m35Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || (m35Var = this.a) == null || m35Var.a() == null) {
            return;
        }
        ek8.w(this.a.a().a, str);
    }

    public void f(m35 m35Var, final String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, m35Var, str) == null) {
            this.a = m35Var;
            gf5.c(new a(this, m35Var), new je5() { // from class: com.repackage.n35
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.repackage.je5
                public final void onReturnDataInUI(Object obj) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                        o35.this.c(str, obj);
                    }
                }
            });
        }
    }
}

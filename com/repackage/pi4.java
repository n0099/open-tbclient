package com.repackage;

import android.app.Activity;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.performance.speed.SpeedRuntimeProvider;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.BdToken.BdUniDispatchSchemeController;
import com.baidu.tbadk.BdToken.DecryptCodeHttpRespMsg;
import com.baidu.tbadk.BdToken.DecryptCodeReqMsg;
import com.baidu.tbadk.BdToken.DecryptCodeSocketRespMsg;
import com.baidu.tbadk.BdToken.TiebaUidCheckHttpResMsg;
import com.baidu.tbadk.BdToken.TiebaUidCheckReqMsg;
import com.baidu.tbadk.BdToken.TiebaUidCheckSocketResMsg;
import com.baidu.tbadk.GrowthStatsUtil;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.data.UserData;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.qi4;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes6.dex */
public class pi4 {
    public static /* synthetic */ Interceptable $ic;
    public static final Pattern i;
    public static final Pattern j;
    public static final Pattern k;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public long b;
    public fj4 c;
    public qi4 d;
    public AtomicBoolean e;
    public AtomicBoolean f;
    public wj4 g;
    public qi4.b h;

    /* loaded from: classes6.dex */
    public class a extends BdAsyncTask<String, Integer, l> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pi4 a;

        public a(pi4 pi4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pi4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pi4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public l doInBackground(String... strArr) {
            InterceptResult invokeL;
            Matcher matcher;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, strArr)) == null) {
                if (strArr == null || strArr.length < 1) {
                    return null;
                }
                String str = strArr[0];
                if (!ni.isEmpty(str) && (matcher = pi4.j.matcher(str)) != null && matcher.find() && matcher.groupCount() >= 2) {
                    String group = matcher.group(1);
                    String group2 = matcher.group(2);
                    if (TextUtils.isEmpty(group2)) {
                        return null;
                    }
                    UserData e = c35.d().e();
                    String tiebaUid = e != null ? e.getTiebaUid() : "";
                    if ((TextUtils.isEmpty(group) || !group.equals(TbadkCoreApplication.getCurrentAccountNameShow())) && !group2.equals(tiebaUid)) {
                        l lVar = new l();
                        lVar.c(group);
                        lVar.d(group2);
                        return lVar;
                    }
                    return null;
                }
                return null;
            }
            return (l) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(l lVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lVar) == null) {
                super.onPostExecute(lVar);
                if (lVar == null || this.a.f.get()) {
                    return;
                }
                this.a.f.compareAndSet(false, true);
                TiebaUidCheckReqMsg tiebaUidCheckReqMsg = new TiebaUidCheckReqMsg();
                tiebaUidCheckReqMsg.setTiebaUid(lVar);
                MessageManager.getInstance().sendMessage(tiebaUidCheckReqMsg);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements qi4.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pi4 a;

        public b(pi4 pi4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pi4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pi4Var;
        }

        @Override // com.repackage.qi4.b
        public void a(boolean z, lj4 lj4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZL(1048576, this, z, lj4Var) == null) && z && lj4Var != null) {
                this.a.t();
                this.a.u(lj4Var.a(), lj4Var.c());
                this.a.w(lj4Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pi4 a;

        public c(pi4 pi4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pi4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pi4Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                pi4.C().q(this.a.A());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pi4 a;

        public d(pi4 pi4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pi4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pi4Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                pi4.C().q(this.a.A());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e extends wa {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pi4 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(pi4 pi4Var, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pi4Var, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pi4Var;
        }

        @Override // com.repackage.wa
        public void onMessage(ResponsedMessage responsedMessage) {
            si4 decryptData;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                this.a.e.compareAndSet(true, false);
                if (responsedMessage instanceof DecryptCodeHttpRespMsg) {
                    decryptData = ((DecryptCodeHttpRespMsg) responsedMessage).getDecryptData();
                } else if (!(responsedMessage instanceof DecryptCodeSocketRespMsg)) {
                    return;
                } else {
                    decryptData = ((DecryptCodeSocketRespMsg) responsedMessage).getDecryptData();
                }
                if (decryptData == null) {
                    return;
                }
                yj4.c(responsedMessage.getError(), decryptData.g());
                GrowthStatsUtil.statisticClipBoard(decryptData.f());
                UtilHelper.clearClipBoard();
                int g = decryptData.g();
                if (g == 1 || g == 0) {
                    if (MessageManager.getInstance().findTask(2921361) == null || decryptData.g.equals(TbadkCoreApplication.getInst().getCurAiAppid())) {
                        return;
                    }
                    yj4.e();
                    TbadkCoreApplication.getInst().setCurAiAppid(null);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921377, decryptData));
                } else if (g == 2) {
                    yj4.e();
                    this.a.u(decryptData.e(), decryptData.f());
                } else if (g == 4 || g != 3 || StringUtils.isNull(decryptData.f())) {
                } else {
                    yj4.e();
                    this.a.v(decryptData.f());
                    this.a.H(decryptData.f());
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f extends wa {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pi4 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(pi4 pi4Var, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pi4Var, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pi4Var;
        }

        @Override // com.repackage.wa
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            com.baidu.tbadk.core.data.UserData userData;
            TiebaUidCheckReqMsg tiebaUidCheckReqMsg;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                this.a.f.compareAndSet(true, false);
                if (responsedMessage instanceof TiebaUidCheckSocketResMsg) {
                    userData = ((TiebaUidCheckSocketResMsg) responsedMessage).getUserData();
                } else if (!(responsedMessage instanceof TiebaUidCheckHttpResMsg)) {
                    return;
                } else {
                    userData = ((TiebaUidCheckHttpResMsg) responsedMessage).getUserData();
                }
                l lVar = (responsedMessage.getOrginalMessage() == null || !(responsedMessage.getOrginalMessage().getExtra() instanceof TiebaUidCheckReqMsg) || (tiebaUidCheckReqMsg = (TiebaUidCheckReqMsg) responsedMessage.getOrginalMessage().getExtra()) == null) ? null : tiebaUidCheckReqMsg.mTiebaUidData;
                if (userData == null || lVar == null) {
                    return;
                }
                UtilHelper.clearClipBoard();
                jj4 d = jj4.d();
                d.b();
                d.e(userData, lVar);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pi4 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(pi4 pi4Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pi4Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pi4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage instanceof BackgroundSwitchMessage) || ((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue()) {
                return;
            }
            this.a.q(this.a.A());
        }
    }

    /* loaded from: classes6.dex */
    public class h extends BdAsyncTask<String, Integer, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pi4 a;

        public h(pi4 pi4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pi4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pi4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            InterceptResult invokeL;
            Matcher matcher;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, strArr)) == null) {
                if (strArr != null && strArr.length >= 1) {
                    String str = strArr[0];
                    if (ni.isEmpty(str)) {
                        return null;
                    }
                    String D = this.a.D();
                    if (!ni.isEmpty(D) && (matcher = Pattern.compile(D).matcher(str)) != null && matcher.find()) {
                        return str;
                    }
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                super.onPostExecute((h) str);
                if (str == null) {
                    if (this.a.c == null || !this.a.G()) {
                        return;
                    }
                    this.a.c.b();
                    return;
                }
                this.a.r(str);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i extends BdAsyncTask<String, Integer, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pi4 a;

        public i(pi4 pi4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pi4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pi4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            InterceptResult invokeL;
            Matcher matcher;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, strArr)) == null) {
                if (strArr != null && strArr.length >= 1) {
                    String str = strArr[0];
                    if (!ni.isEmpty(str) && (matcher = pi4.k.matcher(str)) != null && matcher.find()) {
                        return str;
                    }
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                super.onPostExecute((i) str);
                if (str != null) {
                    this.a.v(str.substring(1, str.length() - 1));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j extends BdAsyncTask<String, Integer, vj4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pi4 a;

        public j(pi4 pi4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pi4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pi4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public vj4 doInBackground(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, strArr)) == null) {
                if (strArr == null || strArr.length < 1) {
                    return null;
                }
                String str = strArr[0];
                if (ni.isEmpty(str)) {
                    return null;
                }
                if (this.a.g == null) {
                    this.a.g = new wj4();
                }
                return this.a.g.a(str);
            }
            return (vj4) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(vj4 vj4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, vj4Var) == null) {
                super.onPostExecute(vj4Var);
                if (vj4Var == null) {
                    return;
                }
                if (!vj4Var.d) {
                    if (StringUtils.isNull(vj4Var.a)) {
                        return;
                    }
                    this.a.N(vj4Var.a, vj4Var.c);
                    return;
                }
                UtilHelper.clearClipBoard();
                if (this.a.v(vj4Var.e)) {
                    this.a.H(vj4Var.e);
                    yj4.b(vj4Var.c, vj4Var.e);
                } else if (StringUtils.isNull(vj4Var.a)) {
                } else {
                    this.a.N(vj4Var.a, vj4Var.c);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class k {
        public static /* synthetic */ Interceptable $ic;
        public static final pi4 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-98565873, "Lcom/repackage/pi4$k;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-98565873, "Lcom/repackage/pi4$k;");
                    return;
                }
            }
            a = new pi4();
        }
    }

    /* loaded from: classes6.dex */
    public static class l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;

        public l() {
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

        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (String) invokeV.objValue;
        }

        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.b : (String) invokeV.objValue;
        }

        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                this.a = str;
            }
        }

        public void d(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                this.b = str;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755408970, "Lcom/repackage/pi4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755408970, "Lcom/repackage/pi4;");
                return;
            }
        }
        i = Pattern.compile("\\$[0-9A-Za-z@_]{5,200}[#$]", 2);
        j = Pattern.compile("^@(.*)@给你分享了贴吧号#(\\d+)#\\s?整段复制后打开贴吧即可找到Ta$", 2);
        k = Pattern.compile("\\$(com.baidu.tieba://unidispatch/)[0-9a-zA-Z]{1,10}\\?[0-9a-zA-Z_=&%\\-.]{1,300}[$]", 2);
    }

    public pi4() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.e = new AtomicBoolean(false);
        this.f = new AtomicBoolean(false);
        this.h = new b(this);
    }

    public static final pi4 C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? k.a : (pi4) invokeV.objValue;
    }

    public final String A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (System.currentTimeMillis() - this.b < 2000) {
                return null;
            }
            this.b = System.currentTimeMillis();
            return UtilHelper.getClipBoardContent();
        }
        return (String) invokeV.objValue;
    }

    public final TbPageContext B(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity)) == null) {
            if (activity instanceof BaseActivity) {
                return ((BaseActivity) activity).getPageContext();
            }
            if (activity instanceof BaseFragmentActivity) {
                return ((BaseFragmentActivity) activity).getPageContext();
            }
            return null;
        }
        return (TbPageContext) invokeL.objValue;
    }

    public final String D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? new String(Base64.decode(vt4.k().q("key_baidu_password_re", "LipcXlsjJGEtekEtWjAtOV9dezUsfVxeezAsMX1bXF4kXXsxfS4q"), 0)) : (String) invokeV.objValue;
    }

    public boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            String clipBoardContent = UtilHelper.getClipBoardContent();
            if (ni.isEmpty(clipBoardContent)) {
                return false;
            }
            return I(D(), clipBoardContent) || clipBoardContent.contains("^sZqulxTVsT$") || J(i, clipBoardContent) || J(k, clipBoardContent) || J(j, clipBoardContent);
        }
        return invokeV.booleanValue;
    }

    public void F(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048580, this, z) == null) || this.a) {
            return;
        }
        K();
        M();
        L();
        qi4 qi4Var = new qi4();
        this.d = qi4Var;
        qi4Var.g(this.h);
        this.c = new fj4();
        String A = A();
        if (!ni.isEmpty(A)) {
            C().q(A);
        } else if (z) {
            pg.a().postDelayed(new c(this), PluginCenter.PLUGIN_RETRY_MIN_TIME_INTERVAL);
        } else {
            pg.a().postDelayed(new d(this), 2000L);
        }
        this.a = true;
    }

    public final boolean G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            String topActivityClassName = UtilHelper.getTopActivityClassName();
            return !ni.isEmpty(topActivityClassName) && topActivityClassName.equals(SpeedRuntimeProvider.MAIN_ACTIVITY_NAME) && TbSingleton.getInstance().isRecommendPage();
        }
        return invokeV.booleanValue;
    }

    public final void H(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            Uri parse = Uri.parse(str);
            String queryParameter = parse != null ? parse.getQueryParameter("obj_source") : "";
            String queryParameter2 = parse != null ? parse.getQueryParameter("obj_type") : "";
            String queryParameter3 = parse != null ? parse.getQueryParameter("tid") : "";
            String queryParameter4 = parse != null ? parse.getQueryParameter("fname") : "";
            String queryParameter5 = parse != null ? parse.getQueryParameter(TiebaStatic.Params.EQID) : "";
            if (!TextUtils.isEmpty(queryParameter) && !TextUtils.isEmpty(queryParameter2) && queryParameter2.startsWith("tbcm")) {
                TiebaStatic.log(new StatisticItem("c13390").param("obj_type", queryParameter2).param("obj_source", queryParameter).param("tid", queryParameter3).param("fname", queryParameter4));
            } else {
                TiebaStatic.log(new StatisticItem("c13390").param("obj_type", queryParameter2).param("obj_source", queryParameter).param("tid", queryParameter3).param("fname", queryParameter4).param("query", queryParameter5));
            }
        }
    }

    public boolean I(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, str, str2)) == null) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return false;
            }
            return J(Pattern.compile(str), str2);
        }
        return invokeLL.booleanValue;
    }

    public boolean J(Pattern pattern, String str) {
        InterceptResult invokeLL;
        Matcher matcher;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, pattern, str)) == null) ? (pattern == null || TextUtils.isEmpty(str) || (matcher = pattern.matcher(str)) == null || !matcher.find()) ? false : true : invokeLL.booleanValue;
    }

    public final void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            kk8.h(309626, DecryptCodeSocketRespMsg.class, false, false);
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_HTTP_DECRYPT_CODE, kk8.a(TbConfig.DECRYPT_CODE_URL, 309626));
            tbHttpMessageTask.setResponsedClass(DecryptCodeHttpRespMsg.class);
            tbHttpMessageTask.setIsNeedAddCommenParam(true);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public final void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            MessageManager.getInstance().registerListener(new e(this, CmdConfigHttp.CMD_HTTP_DECRYPT_CODE, 309626));
            MessageManager.getInstance().registerListener(new f(this, CmdConfigHttp.CMD_HTTP_TIEBA_UID_CHECK, 309702));
            MessageManager.getInstance().registerListener(new g(this, 2001011));
        }
    }

    public final void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            kk8.h(309702, TiebaUidCheckSocketResMsg.class, false, false);
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_HTTP_TIEBA_UID_CHECK, kk8.a(TbConfig.URL_GET_USER_BY_TIEBA_UID, 309702));
            tbHttpMessageTask.setResponsedClass(TiebaUidCheckHttpResMsg.class);
            tbHttpMessageTask.setIsNeedAddCommenParam(true);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public final void N(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048588, this, str, str2) == null) || this.e.get()) {
            return;
        }
        yj4.b = str;
        yj4.d(str2);
        this.e.compareAndSet(false, true);
        DecryptCodeReqMsg decryptCodeReqMsg = new DecryptCodeReqMsg();
        decryptCodeReqMsg.setCode(str);
        MessageManager.getInstance().sendMessage(decryptCodeReqMsg);
    }

    public void p(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, str) == null) || ni.isEmpty(str)) {
            return;
        }
        new h(this).execute(str);
    }

    public void q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            p(str);
            s(str);
            x(str);
            y(str);
            z(str);
        }
    }

    public final void r(String str) {
        qi4 qi4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, str) == null) || (qi4Var = this.d) == null) {
            return;
        }
        qi4Var.c(str);
    }

    public void s(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048592, this, str) == null) && !ni.isEmpty(str) && str.contains("^sZqulxTVsT$")) {
            r(str);
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            UtilHelper.clearClipBoard();
        }
    }

    public final void u(String str, String str2) {
        TbPageContext<?> B;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048594, this, str, str2) == null) || ni.isEmpty(str2) || (B = B(TbadkCoreApplication.getInst().getCurrentActivity())) == null) {
            return;
        }
        UrlManager.getInstance().dealOneLink(B, str, new String[]{str2});
    }

    public final boolean v(String str) {
        InterceptResult invokeL;
        Activity currentActivity;
        Uri parse;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, str)) == null) {
            if (ni.isEmpty(str) || (currentActivity = TbadkCoreApplication.getInst().getCurrentActivity()) == null || (parse = Uri.parse(str)) == null) {
                return false;
            }
            if (str.startsWith(BdUniDispatchSchemeController.SCHEME)) {
                Uri.Builder buildUpon = Uri.parse(str).buildUpon();
                buildUpon.appendQueryParameter(BdUniDispatchSchemeController.PARAM_SCHEME_FROM, BdUniDispatchSchemeController.SCHEME_FROM_TB_TOKEN);
                parse = buildUpon.build();
            }
            return UtilHelper.dealOneScheme(currentActivity, parse.toString());
        }
        return invokeL.booleanValue;
    }

    public final void w(lj4 lj4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, lj4Var) == null) || lj4Var == null || lj4Var.b() == null || ni.isEmpty(lj4Var.b().a) || !G()) {
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921380, lj4Var.b().a));
    }

    public void x(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048597, this, str) == null) || ni.isEmpty(str)) {
            return;
        }
        new j(this).execute(str);
    }

    public void y(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048598, this, str) == null) || ni.isEmpty(str)) {
            return;
        }
        new i(this).execute(str);
    }

    public void z(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048599, this, str) == null) || ni.isEmpty(str)) {
            return;
        }
        new a(this).execute(str);
    }
}

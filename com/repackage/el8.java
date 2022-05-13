package com.repackage;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.NetWorkErr;
import com.baidu.tbadk.coreExtra.data.AuthTokenData;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.dx4;
import com.repackage.nr4;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public class el8 {
    public static /* synthetic */ Interceptable $ic;
    public static AtomicBoolean a;
    public static List<Integer> b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements nr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nr4 a;
        public final /* synthetic */ dx4 b;

        public a(nr4 nr4Var, dx4 dx4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nr4Var, dx4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nr4Var;
            this.b = dx4Var;
        }

        @Override // com.repackage.nr4.e
        public void onClick(nr4 nr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nr4Var) == null) {
                this.a.dismiss();
                MessageManager.getInstance().sendMessage(new CustomMessage(2921372, this.b));
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements nr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nr4 a;

        public b(nr4 nr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nr4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nr4Var;
        }

        @Override // com.repackage.nr4.e
        public void onClick(nr4 nr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nr4Var) == null) {
                this.a.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static abstract class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c() {
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

        public abstract void a(String str);

        public void b(dx4.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
                if (cVar != null && cVar.a) {
                    if (cVar instanceof dx4.a) {
                        a(((dx4.a) cVar).b);
                        return;
                    } else if (cVar instanceof dx4.b) {
                        c(((dx4.b) cVar).b);
                        return;
                    } else {
                        e();
                        return;
                    }
                }
                d();
            }
        }

        public abstract void c(String str);

        public abstract void d();

        public abstract void e();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755733664, "Lcom/repackage/el8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755733664, "Lcom/repackage/el8;");
                return;
            }
        }
        a = new AtomicBoolean(false);
        b = Arrays.asList(Integer.valueOf((int) NetWorkErr.ERROR_UEG_IDENTITY_VERIFY), Integer.valueOf((int) NetWorkErr.ERROR_UEG_PHONE_VERIFY), Integer.valueOf((int) NetWorkErr.ERROR_UEG_MODIFY_PWD), Integer.valueOf((int) NetWorkErr.ERROR_UEG_FACE_VERIFY), Integer.valueOf((int) NetWorkErr.ERROR_UEG_DOUBLE_CHECK), Integer.valueOf((int) NetWorkErr.ERROR_UEG_BIND_MOBILE));
    }

    public static boolean a(int i, AuthTokenData authTokenData, c cVar) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(65537, null, i, authTokenData, cVar)) == null) {
            if (b.contains(Integer.valueOf(i))) {
                if ((i == 3250020 || i == 3250021) && (authTokenData == null || TextUtils.isEmpty(authTokenData.getAuthToken()))) {
                    return false;
                }
                return c(i, authTokenData.getAuthToken(), cVar);
            }
            return false;
        }
        return invokeILL.booleanValue;
    }

    public static boolean b(int i, String str, c cVar) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(65538, null, i, str, cVar)) == null) {
            if (b.contains(Integer.valueOf(i))) {
                if ((i == 3250020 || i == 3250021) && TextUtils.isEmpty(str)) {
                    return false;
                }
                return c(i, str, cVar);
            }
            return false;
        }
        return invokeILL.booleanValue;
    }

    public static boolean c(int i, String str, c cVar) {
        InterceptResult invokeILL;
        dx4 a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(65539, null, i, str, cVar)) == null) {
            if (a.compareAndSet(false, true)) {
                String.valueOf(System.currentTimeMillis());
                if (i == 3250022) {
                    dx4 d = dx4.d();
                    d.g(cVar);
                    if (cVar != null) {
                        cVar.d();
                    }
                    if (TbadkCoreApplication.getInst().getCurrentActivity() != null) {
                        nr4 nr4Var = new nr4(TbadkCoreApplication.getInst().getCurrentActivity());
                        nr4Var.setMessageId(R.string.obfuscated_res_0x7f0f027d);
                        nr4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0ad7, new a(nr4Var, d));
                        nr4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0374, new b(nr4Var));
                        if (TbadkCoreApplication.getInst().getCurrentActivity() instanceof c9) {
                            nr4Var.create(((c9) TbadkCoreApplication.getInst().getCurrentActivity()).getPageContext());
                            nr4Var.show();
                        }
                    }
                } else {
                    if (i == 3250017) {
                        a2 = dx4.b();
                    } else if (i == 3250023) {
                        a2 = dx4.c();
                    } else if (i == 3250024) {
                        a2 = new dx4(4, null);
                    } else {
                        a2 = dx4.a(str);
                    }
                    a2.g(cVar);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921372, a2));
                }
                a.set(false);
                return true;
            }
            return false;
        }
        return invokeILL.booleanValue;
    }
}

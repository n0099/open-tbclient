package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.lego.card.exception.CardParseException;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class dd7 extends fd7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<fd7> c;

    /* loaded from: classes5.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes5.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final dd7 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-446644196, "Lcom/repackage/dd7$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-446644196, "Lcom/repackage/dd7$b;");
                    return;
                }
            }
            a = new dd7(null);
        }
    }

    public /* synthetic */ dd7(a aVar) {
        this();
    }

    public static dd7 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? b.a : (dd7) invokeV.objValue;
    }

    public static ICardInfo i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            try {
                ICardInfo j = j(new JSONObject(str));
                if (j != null) {
                    if (j.isValid()) {
                        return j;
                    }
                }
                return null;
            } catch (CardParseException e) {
                BdLog.detailException("CardFactory.getPageCardInfo", e);
                return null;
            } catch (JSONException e2) {
                BdLog.detailException("CardFactory.getPageCardInfo", e2);
                return null;
            }
        }
        return (ICardInfo) invokeL.objValue;
    }

    public static ICardInfo j(JSONObject jSONObject) throws CardParseException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject)) == null) ? h().b(jSONObject, jSONObject.optInt("card_type")) : (ICardInfo) invokeL.objValue;
    }

    @Override // com.repackage.fd7
    public <T> yd7 a(TbPageContext<T> tbPageContext, ICardInfo iCardInfo, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048576, this, tbPageContext, iCardInfo, i)) == null) {
            yd7 e = e(tbPageContext, iCardInfo, i);
            if (e != null) {
                e.setBusinessType(i);
            }
            return e;
        }
        return (yd7) invokeLLI.objValue;
    }

    @Override // com.repackage.fd7
    public ICardInfo b(JSONObject jSONObject, int i) throws CardParseException {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject, i)) == null) ? f(jSONObject, i) : (ICardInfo) invokeLI.objValue;
    }

    @Override // com.repackage.fd7
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    @Override // com.repackage.fd7
    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "lego_main" : (String) invokeV.objValue;
    }

    public final <T> yd7 e(TbPageContext<T> tbPageContext, ICardInfo iCardInfo, int i) {
        InterceptResult invokeLLI;
        yd7 a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048580, this, tbPageContext, iCardInfo, i)) == null) {
            for (fd7 fd7Var : this.c) {
                try {
                    a2 = fd7Var.a(tbPageContext, iCardInfo, i);
                } catch (Throwable th) {
                    BdLog.detailException("factory <" + fd7Var.d() + "> respond exception", th);
                }
                if (a2 != null) {
                    return a2;
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("No card factory for card type ");
            sb.append(iCardInfo == null ? -1 : iCardInfo.getCardType());
            BdLog.e(sb.toString());
            return null;
        }
        return (yd7) invokeLLI.objValue;
    }

    public final ICardInfo f(JSONObject jSONObject, int i) throws CardParseException {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048581, this, jSONObject, i)) == null) {
            for (fd7 fd7Var : this.c) {
                try {
                    ICardInfo b2 = fd7Var.b(jSONObject, i);
                    if (b2 != null) {
                        return b2;
                    }
                } catch (Throwable th) {
                    throw new CardParseException("Card type " + i + ", factory <" + fd7Var.d() + "> respond exception", th);
                }
            }
            BdLog.e("No card factory for card type " + i);
            return null;
        }
        return (ICardInfo) invokeLI.objValue;
    }

    public synchronized void g(fd7 fd7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, fd7Var) == null) {
            synchronized (this) {
                this.c.add(fd7Var);
            }
        }
    }

    public dd7() {
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
        this.c = new ArrayList(4);
    }
}

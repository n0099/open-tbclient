package com.repackage;

import android.app.Activity;
import android.os.Bundle;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.service.AbstractThirdPartyService;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes6.dex */
public class km5 extends ActivityDelegation implements gh1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public nm5 b;
    public Activity c;
    public Map<String, String> d;
    public CustomMessageListener e;

    /* loaded from: classes6.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ km5 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(km5 km5Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {km5Var, Integer.valueOf(i)};
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
            this.a = km5Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (data instanceof w85) {
                w85 w85Var = (w85) data;
                if (getTag() == w85Var.a || w85Var.g) {
                    this.a.mResult.putInt("result_code", w85Var.b);
                    this.a.mResult.putString(AbstractThirdPartyService.EXTRA_RESULT_MSG, w85Var.c);
                    if (this.a.b != null) {
                        this.a.b.a(this.a.mResult);
                    }
                    this.a.finish();
                }
            }
        }
    }

    public km5() {
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
        this.a = BdUniqueId.gen();
        this.e = new a(this, 2921393);
    }

    public void c(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, activity) == null) {
            this.c = activity;
        }
    }

    public void d(nm5 nm5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, nm5Var) == null) {
            this.b = nm5Var;
        }
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    public void finish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.b = null;
            MessageManager.getInstance().unRegisterListener(this.e);
            super.finish();
        }
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    public boolean onExec() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            this.e.setTag(this.a);
            MessageManager.getInstance().registerListener(this.e);
            int i = this.mParams.getInt("type");
            String string = this.mParams.getString("orderInfo");
            w85 w85Var = new w85();
            w85Var.a = this.a;
            w85Var.b = i;
            w85Var.c = string;
            w85Var.e = (Map) this.mParams.getSerializable("params");
            w85Var.f = this.d;
            if (getAgent() != null) {
                w85Var.d = getAgent();
            } else {
                Activity activity = this.c;
                if (activity != null) {
                    w85Var.d = activity;
                } else {
                    w85Var.d = TbadkCoreApplication.getInst().getCurrentActivity();
                }
            }
            CustomMessage customMessage = new CustomMessage(2921393, w85Var);
            customMessage.setTag(this.a);
            boolean sendMessage = MessageManager.getInstance().sendMessage(customMessage);
            this.mResult.putInt("result_code", sendMessage ? 0 : 1);
            Bundle bundle = this.mResult;
            bundle.putString(AbstractThirdPartyService.EXTRA_RESULT_MSG, "" + sendMessage);
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.gh1
    public void onResult(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.mResult.putInt("result_code", i);
            this.mResult.putString(AbstractThirdPartyService.EXTRA_RESULT_MSG, "");
            finish();
        }
    }
}

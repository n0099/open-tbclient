package com.repackage;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.im.message.LoadHistoryMessage;
import com.baidu.tieba.im.message.LoadHistoryResponsedMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
/* loaded from: classes6.dex */
public abstract class i87 implements CustomMessageTask.CustomRunnable<LoadHistoryMessage.a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public d67 a;
    public int b;

    public i87(d67 d67Var, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {d67Var, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = d67Var;
        this.b = i;
    }

    public final LoadHistoryResponsedMessage a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            LoadHistoryResponsedMessage loadHistoryResponsedMessage = new LoadHistoryResponsedMessage(i);
            loadHistoryResponsedMessage.setError(-18);
            return loadHistoryResponsedMessage;
        }
        return (LoadHistoryResponsedMessage) invokeI.objValue;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<LoadHistoryMessage.a> customMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, customMessage)) == null) {
            if (customMessage != null && (customMessage instanceof LoadHistoryMessage) && this.a != null) {
                LoadHistoryMessage.a data = customMessage.getData();
                LoadHistoryResponsedMessage loadHistoryResponsedMessage = new LoadHistoryResponsedMessage(this.b);
                LinkedList<ChatMessage> g = this.a.g(mg.g(data.d, 0L), data.a, data.b, data.c);
                if (g == null) {
                    return a(this.b);
                }
                LoadHistoryResponsedMessage.a aVar = new LoadHistoryResponsedMessage.a();
                if (data.a == null) {
                    aVar.c = true;
                } else {
                    aVar.c = false;
                }
                aVar.a = data.d;
                aVar.b = g;
                try {
                    loadHistoryResponsedMessage.decodeInBackGround(2001105, aVar);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return loadHistoryResponsedMessage;
            }
            return a(this.b);
        }
        return (CustomResponsedMessage) invokeL.objValue;
    }
}

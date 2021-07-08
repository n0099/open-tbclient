package com.yy.hiidostatis.message.monitor;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.message.MessageMonitor;
import com.yy.hiidostatis.message.utils.KVIO;
import com.yy.hiidostatis.provider.MessageConfig;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes6.dex */
public class MessageMonitorImpl implements MessageMonitor {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String PROCESS_ID_KEY = "hiido_process_id";
    public transient /* synthetic */ FieldHolder $fh;
    public MessageConfig config;
    public Object lock;
    public final ConcurrentHashMap<String, MessageParams> msgParams;
    public int processId;

    /* loaded from: classes6.dex */
    public static class MessageParams {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String act;
        public AtomicLong autoId;
        public String autoIdKey;
        public AtomicInteger packId;

        public MessageParams(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.act = str;
            this.autoIdKey = str + "_auid";
            this.autoId = new AtomicLong(KVIO.get().decodeLong(this.autoIdKey));
            this.packId = new AtomicInteger();
        }

        public String getAct() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.act : (String) invokeV.objValue;
        }

        public long getAutoId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.autoId.get() : invokeV.longValue;
        }

        public String getAutoIdKey() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.autoIdKey : (String) invokeV.objValue;
        }

        public long incrementAndGetAutoId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.autoId.incrementAndGet() : invokeV.longValue;
        }

        public int incrementAndGetPackId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.packId.incrementAndGet() : invokeV.intValue;
        }
    }

    public MessageMonitorImpl(MessageConfig messageConfig) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {messageConfig};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.lock = new Object();
        this.config = messageConfig;
        this.msgParams = new ConcurrentHashMap<>();
        this.processId = KVIO.get().decodeInt(PROCESS_ID_KEY, 1);
        KVIO.get().encode(PROCESS_ID_KEY, this.processId + 1);
    }

    private MessageParams getAct(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, str)) == null) {
            MessageParams messageParams = this.msgParams.get(str);
            if (messageParams == null) {
                synchronized (this.lock) {
                    messageParams = this.msgParams.get(str);
                    if (messageParams == null) {
                        messageParams = new MessageParams(str);
                        this.msgParams.put(str, messageParams);
                    }
                }
            }
            return messageParams;
        }
        return (MessageParams) invokeL.objValue;
    }

    private synchronized void writeAutoIdToRecord(MessageParams messageParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, messageParams) == null) {
            synchronized (this) {
                KVIO.get().encode(messageParams.getAutoIdKey(), messageParams.getAutoId());
            }
        }
    }

    @Override // com.yy.hiidostatis.message.MessageMonitor
    public void commit() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            KVIO.get().commit();
        }
    }

    @Override // com.yy.hiidostatis.message.MessageMonitor
    public long getAutoId(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            MessageParams act = getAct(str);
            long incrementAndGetAutoId = act.incrementAndGetAutoId();
            writeAutoIdToRecord(act);
            return incrementAndGetAutoId;
        }
        return invokeL.longValue;
    }

    @Override // com.yy.hiidostatis.message.MessageMonitor
    public int getPackId(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) ? getAct(str).incrementAndGetPackId() : invokeL.intValue;
    }

    @Override // com.yy.hiidostatis.message.MessageMonitor
    public int getProcessId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.processId : invokeV.intValue;
    }

    @Override // com.yy.hiidostatis.message.MessageMonitor
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }
}

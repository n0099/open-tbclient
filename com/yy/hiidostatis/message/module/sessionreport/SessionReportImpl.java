package com.yy.hiidostatis.message.module.sessionreport;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.api.StatisContent;
import com.yy.hiidostatis.message.Packer;
import com.yy.hiidostatis.message.SessionReport;
import com.yy.hiidostatis.message.utils.NoNull;
import com.yy.hiidostatis.provider.MessageConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes6.dex */
public class SessionReportImpl implements SessionReport {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public MessageConfig config;
    public Packer packer;
    public Map<String, Session> sessions;

    /* loaded from: classes6.dex */
    public class Session {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String act;
        public final SessionReport.AfterFlush afterFlush;
        public final SessionReport.Processor processor;
        public final String session;
        public final /* synthetic */ SessionReportImpl this$0;
        public Map<String, SessionReport.StatisContentAble> values;

        public Session(SessionReportImpl sessionReportImpl, String str, String str2, SessionReport.Processor processor, SessionReport.AfterFlush afterFlush) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sessionReportImpl, str, str2, processor, afterFlush};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = sessionReportImpl;
            this.values = new HashMap();
            this.session = str;
            this.act = str2;
            this.processor = processor;
            this.afterFlush = afterFlush;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized void flushSession(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65539, this, str) == null) {
                synchronized (this) {
                    SessionReport.StatisContentAble statisContentAble = this.values.get(str);
                    if (statisContentAble == null) {
                        return;
                    }
                    send(str, statisContentAble);
                    if (this.afterFlush != null) {
                        SessionReport.StatisContentAble reset = this.afterFlush.reset(str, statisContentAble);
                        if (reset == null) {
                            this.values.remove(str);
                        } else {
                            this.values.put(str, reset);
                        }
                    }
                }
            }
        }

        private void send(String str, SessionReport.StatisContentAble statisContentAble) {
            List<StatisContent> statisContent;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, str, statisContentAble) == null) || (statisContent = statisContentAble.toStatisContent(this.act, str)) == null || statisContent.isEmpty()) {
                return;
            }
            for (StatisContent statisContent2 : statisContent) {
                statisContent2.put("session", this.session);
                this.this$0.packer.addMessage(statisContent2);
            }
        }

        public void close() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || NoNull.isEmpty(this.values)) {
                return;
            }
            try {
                for (Map.Entry<String, SessionReport.StatisContentAble> entry : this.values.entrySet()) {
                    send(entry.getKey(), entry.getValue());
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        public synchronized boolean pushToSession(String str, Object obj) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, obj)) == null) {
                synchronized (this) {
                    try {
                        this.values.put(str, this.processor.process(this.values.get(str), str, obj));
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        return false;
                    }
                }
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    public SessionReportImpl(MessageConfig messageConfig, Packer packer) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {messageConfig, packer};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.sessions = new ConcurrentHashMap();
        this.config = messageConfig;
        this.packer = packer;
    }

    @Override // com.yy.hiidostatis.message.SessionReport
    public void beginSession(String str, String str2, SessionReport.Processor processor, SessionReport.AfterFlush afterFlush) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, str, str2, processor, afterFlush) == null) {
            this.sessions.put(str, new Session(this, str, str2, processor, afterFlush));
        }
    }

    @Override // com.yy.hiidostatis.message.SessionReport
    public void closeSession(String str) {
        Session remove;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || (remove = this.sessions.remove(str)) == null) {
            return;
        }
        remove.close();
    }

    @Override // com.yy.hiidostatis.message.SessionReport
    public boolean flushSession(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2)) == null) {
            Session session = this.sessions.get(str);
            if (session == null) {
                return false;
            }
            session.flushSession(str2);
            return true;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.yy.hiidostatis.message.SessionReport
    public boolean flushSessionAll(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) ? flushSessionAll(str, null) : invokeL.booleanValue;
    }

    @Override // com.yy.hiidostatis.message.SessionReport
    public boolean pushToSession(String str, String str2, Object obj) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, str, str2, obj)) == null) {
            Session session = this.sessions.get(str);
            if (session != null) {
                return session.pushToSession(str2, obj);
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    @Override // com.yy.hiidostatis.message.SessionReport
    public boolean flushSessionAll(String str, Set<String> set) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, set)) == null) {
            Session session = this.sessions.get(str);
            if (session == null) {
                return false;
            }
            for (Map.Entry entry : new ArrayList(session.values.entrySet())) {
                if (set == null || !set.contains(entry.getKey())) {
                    session.flushSession((String) entry.getKey());
                }
            }
            return true;
        }
        return invokeLL.booleanValue;
    }
}
